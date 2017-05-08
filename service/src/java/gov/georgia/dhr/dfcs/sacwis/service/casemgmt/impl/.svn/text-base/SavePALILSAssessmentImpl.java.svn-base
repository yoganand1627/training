package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Pal;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePALILSAssessment;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC02SO;

public class SavePALILSAssessmentImpl extends BaseServiceImpl implements SavePALILSAssessment {

  private ComplexStageDAO complexStageDAO = null;
  private PalDAO palDAO = null;
  private TodoDAO todoDAO = null;
  private PostEvent postEvent = null;

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setPalDAO(PalDAO palDAO) {
    this.palDAO = palDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public CCFC02SO savePalIlsAssessment(CCFC02SI ccfc02si) throws ServiceException {
    CCFC02SO ccfc02so = new CCFC02SO();
    ROWCCMN01UIG00 ccfc02si_rowccmn01uig00 = ccfc02si.getROWCCMN01UIG00();
    int idStage = ccfc02si_rowccmn01uig00.getUlIdStage();
    String cdStagePersRole = CodesTables.CROLEALL_PC;
    // Retrieve the ID PERSON for a given role, for a given stage.
    //   It's used to find the primary worker for a given stage.
    // cinv51d
    Integer idWkldPerson = complexStageDAO.findPrimaryWorker(idStage, cdStagePersRole);
    if (idWkldPerson == null) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }
    Date tsLastUpdate = ccfc02si.getTsSysTsLastUpdate2();
    int idEvent = ccfc02si_rowccmn01uig00.getUlIdEvent();
    // CCMN01U -- POST EVENT
    postEvent(idEvent, idStage, ccfc02si_rowccmn01uig00.getUlIdPerson(), idWkldPerson,
              ccfc02si_rowccmn01uig00.getSzCdTask(), ccfc02si.getSzSysCdWinMode(), tsLastUpdate);

    // (BEGIN): CAUD49D
    String cdPalCloseLivArr = ccfc02si.getSzCdPalCloseLivArr();
    String txtPalIlNoIlsRsn = ccfc02si.getSzTxtPalIlNoIlsRsn();
    Date dtPalPostasmtDate = DateHelper.toJavaDate(ccfc02si.getDtDtPalPostasmtDate());
    Date dtPalPreasmtDate = DateHelper.toJavaDate(ccfc02si.getDtDtPalPreasmtDate());
    String indPalIlNoIlsAssmt = ccfc02si.getCIndPalIlNoIlsAssmt();
    String indPalIlNoPoasmt_Scre = ccfc02si.getCIndPalIlNoPoasmt_Scre();
    String indPalIlNoPrasmtScre = ccfc02si.getCIndPalIlNoPrasmtScre();
    int nbrPalPostasmtScore = ccfc02si.getLNbrPalPostasmtScore();
    int nbrPalPreasmtScore = ccfc02si.getLNbrPalPreasmtScore();

    String cReqFuncCd = ccfc02si.getArchInputStruct().getCReqFuncCd();
    int nbrRowsAffected;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // caud49d
      nbrRowsAffected = palDAO.insertPal(idStage, tsLastUpdate, cdPalCloseLivArr, dtPalPostasmtDate, dtPalPreasmtDate,
                                         indPalIlNoIlsAssmt, indPalIlNoPoasmt_Scre, indPalIlNoPrasmtScre,
                                         nbrPalPostasmtScore, nbrPalPreasmtScore, txtPalIlNoIlsRsn);
      if (nbrRowsAffected == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // caud49d
      nbrRowsAffected = palDAO.updatePal(idStage, tsLastUpdate, cdPalCloseLivArr, dtPalPostasmtDate, dtPalPreasmtDate,
                                         indPalIlNoIlsAssmt, indPalIlNoPoasmt_Scre, indPalIlNoPrasmtScre,
                                         nbrPalPostasmtScore, nbrPalPreasmtScore, txtPalIlNoIlsRsn);
      if (nbrRowsAffected == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      Pal pal = new Pal();
      pal.setIdPalStage(idStage);
      pal.setDtLastUpdate(tsLastUpdate);
      // caud49d
      palDAO.deletePal(pal);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    // Whenever the data for PAL ILS Assessment is saved, the associated TODO, if any, will be taken off the Staff TODO
    //   List.  This is necessary because in the PAL Dialog when a TODO is completed for the ILS or RUT windows the
    //   event status remains PROC until the stage is completed through the PAL Summary window.  Thus, simply completing
    //   a TODO would not have removed it from the TODO List.  The CINV43D dam updates the date  TODO completed and
    //   removes the TODO from the TODO list whenever the window data is saved.
    // (BEGIN): cinv43d
    // This check for idEvent being zero was added during translation.  The orginal service ignores SQL_NOT_FOUND,
    //   which is exactly what will ALWAYS happen if idEvent is zero, as zero is not a valid value for ID_TOOD_EVENT.
    if (idEvent != 0) {
      // cinv43d -- Ignores SQL_NOT_FOUND
      todoDAO.updateTodoByIdEvent(ccfc02si_rowccmn01uig00.getUlIdEvent());
    }
    return ccfc02so;
  }

  private void postEvent(int idEvent, int idStage, int idPerson, Integer idWkldPerson, String cdTask, String cdWinMode,
                         Date tsLastUpdate
  ) throws ServiceException {
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn01ui.setArchInputStruct(archInputStruct);
    // Set the CCMN01UI ReqFuncCd to REQ_FUNC_CD_ADD if a NULL value ulIdEvent is passed in
    if (idEvent == 0) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }

    // Populate Common Function CCMN01U -- POST EVENT object
    ROWCCMN01UIG00 ccmn01ui_rowccmn01uig00 = new ROWCCMN01UIG00();
    ccmn01ui.setROWCCMN01UIG00(ccmn01ui_rowccmn01uig00);
    ccmn01ui_rowccmn01uig00.setUlIdPerson(idPerson);
    // Task is in Process
    ccmn01ui_rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    // Event type is ILS. Defined in the interface because it does not exist in codes_tables.
    ccmn01ui_rowccmn01uig00.setSzCdEventType(INDEPENDENT_LIVING_SKILLS);
    // Set CCMN01UI DtEventOccurred to current system date
    ccmn01ui_rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    ccmn01ui_rowccmn01uig00.setUlIdEvent(idEvent);
    ccmn01ui_rowccmn01uig00.setUlIdStage(idStage);
    ccmn01ui_rowccmn01uig00.setSzCdTask(cdTask);
    ccmn01ui_rowccmn01uig00.setSzTxtEventDescr(ILS_ASSESSMENT_RESULTS);
    // Set ccmn01u Time Stamp if the service input message IdEvent is not equal to NULL
    if (idEvent != 0) {
      ccmn01ui_rowccmn01uig00.setTsLastUpdate(tsLastUpdate);
    }
    // If the CCMN01 ReqFuncCd is ADD, meaning that no IdEvent exists for the record being saved, populate the CCMN01
    //   Input Msg with the Primary Child's IdPerson for the Event-Person Link
    if (PageModeConstants.NEW.equals(cdWinMode)) {
      // Place id_person of the Primary Child on the Event Person Link Table
      ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idWkldPerson != null ? idWkldPerson : 0);
      // Tell the function it is an add
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      ccmn01ui_rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    }
    ccmn01ui.setROWCCMN01UIG00(ccmn01ui_rowccmn01uig00);
    // Call Post Event function. It will throw exceptions when necessary, all of which cause failure.
    postEvent.postEvent(ccmn01ui);
  }

}
