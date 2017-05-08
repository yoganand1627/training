package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PalService;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePALTrainingService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC11SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

public class SavePALTrainingServiceImpl extends BaseServiceImpl implements SavePALTrainingService {

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexStageDAO complexStageDAO = null;

  private PalServiceDAO palServiceDAO = null;

  private PostEvent postEvent = null;

  private TodoDAO todoDAO = null;

  public static final String RECORD_UNPAID_TRAINING = "RUT";

  public static final String RECORD_UNPAID_TRAINING_DESC = "Record Services/Training";

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setPalServiceDAO(PalServiceDAO palServiceDAO) {
    this.palServiceDAO = palServiceDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCFC11SO savePALTrainningService(CCFC11SI ccfc11si) throws ServiceException {
    CCFC11SO ccfc11so = new CCFC11SO();
    String pageMode = ccfc11si.getSzSysCdWinMode();
    CCMN01UI ccmn01ui = new CCMN01UI();
    CCMN06UI ccmn06ui = new CCMN06UI();
    int idStage = ccfc11si.getROWCCMN01UIG00().getUlIdStage();
    String cdTask = ccfc11si.getROWCCMN01UIG00().getSzCdTask();
    Integer idPersonPrimaryWorker = 0;
    int idEvent = ccfc11si.getROWCCMN01UIG00().getUlIdEvent();
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(ccfc11si.getArchInputStruct().getCReqFuncCd());
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    // This will throw exceptions with appropriate messages if we cannot continue.
    checkStageEventStatus.status(ccmn06ui);

    if (PageModeConstants.NEW.equals(pageMode)) {
      // Pull the stage out of the first row in ROWCCFC11SIG00_ARRAY
      idStage = ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(0).getUlIdStage();
      // cinv51dQUERYdam
      idPersonPrimaryWorker = complexStageDAO.findPrimaryWorker(idStage, CodesTables.CROLES_PC);
      if (idPersonPrimaryWorker == null) {
        throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
      }
    }

    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();

    if (idEvent == 0) {
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);

    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    rowccmn01uig01.setUlIdPerson(idPersonPrimaryWorker != null ? idPersonPrimaryWorker : 0);
    rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    ROWCCMN01UIG00 ccmn01ui_rowccmn01uig00 = new ROWCCMN01UIG00();
    ccmn01ui_rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    ccmn01ui_rowccmn01uig00.setUlIdPerson(ccfc11si.getROWCCMN01UIG00().getUlIdPerson());
    ccmn01ui_rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    ccmn01ui_rowccmn01uig00.setSzCdEventType(RECORD_UNPAID_TRAINING);
    ccmn01ui_rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    ccmn01ui_rowccmn01uig00.setUlIdEvent(idEvent);
    ccmn01ui_rowccmn01uig00.setUlIdStage(idStage);
    ccmn01ui_rowccmn01uig00.setSzCdTask(cdTask);
    ccmn01ui_rowccmn01uig00.setSzTxtEventDescr(RECORD_UNPAID_TRAINING_DESC);

    if (idEvent != 0) {
      ccmn01ui_rowccmn01uig00.setTsLastUpdate(ccfc11si.getROWCCMN01UIG00().getTsLastUpdate());
    }

    // The following block is commented out since it appears to be done uncondtionally above (bug in service?).
//    if (PageMode.NEW.equals(pageMode)) {
//      rowccmn01uig01.setUlIdPerson(idPersonPrimaryWorker);
//      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
//    }

    //  PostEvent (ccmn01u)
    ccmn01ui.setROWCCMN01UIG00(ccmn01ui_rowccmn01uig00);
    // PostEvent
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

    if (ccmn01uo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    idEvent = ccmn01uo.getUlIdEvent();
    ccfc11so.setUlIdEvent(idEvent);
    ROWCCFC11SIG00_ARRAY rowCcfc11SiG00Array = ccfc11si.getROWCCFC11SIG00_ARRAY();

    for (Enumeration rowCcfc11SiG00Enum = rowCcfc11SiG00Array.enumerateROWCCFC11SIG00(); rowCcfc11SiG00Enum
            .hasMoreElements();) {
      ROWCCFC11SIG00 rowCcfc11SiG00 = (ROWCCFC11SIG00) rowCcfc11SiG00Enum.nextElement();
      PalService palService = new PalService();
      String szCdScrDataAction = rowCcfc11SiG00.getSzCdScrDataAction();
      int idPalService = rowCcfc11SiG00.getUlIdPalService();
      idStage = rowCcfc11SiG00.getUlIdStage();
      String cdPalServiceCategory = rowCcfc11SiG00.getSzCdPalServiceCategory();
      Date dtLastUpdate = rowCcfc11SiG00.getTsLastUpdate();
      String cdPalServiceType = rowCcfc11SiG00.getSzCdPalServiceType();
      int nbrPalServiceUnits = rowCcfc11SiG00.getLNbrPalServiceUnits();
      String sdsPalServiceOther = rowCcfc11SiG00.getSzSdsPalServiceOther();
      Date dtPalServiceDate = DateHelper.toJavaDate(rowCcfc11SiG00.getDtDtPalServiceDate());

      palService.setIdPalService(idPalService);
      palService.getStage().setIdStage(idStage);
      palService.setCdPalServiceCatgory(cdPalServiceCategory);
      palService.setDtLastUpdate(dtLastUpdate);
      palService.setCdPalServiceType(cdPalServiceType);
      palService.setNbrPalServiceUnits(nbrPalServiceUnits);
      palService.setSdsPalServiceOther(sdsPalServiceOther);
      palService.setDtPalServiceDate(dtPalServiceDate);

      // caud62dAUDdam
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction) ||
          ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)) {
        palServiceDAO.savePalService(palService);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
        palServiceDAO.deletePalService(palService);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }

    }

    if (idEvent != 0) {
      // Added the TODO AUD, CINV43D, to the
      // save service so that whenever the data for PAL ILS
      // Assessment is saved, the associated TODO, if any, will
      // be taken off the Staff TODO List. This is necessary
      // because in the PAL Dialog when a TODO is completed for
      // the ILS or RUT windows the event status remains PROC
      // until the stage is completed through the PAL Summary
      // window. Thus, simply completing a TODO would not have
      // removed it from the TODO List. The CINV43D updates
      // the date TODO completed and removes the TODO from the
      // TODO list whenever the window data is saved.

      // cinv43dAUDdam    
      todoDAO.updateTodoByIdEvent(idEvent);

    }

    return ccfc11so;
  }

}
