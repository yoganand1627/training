package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PalFollowUpDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalPublicAssistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PalPublicAssist;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePALFollowup;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC08SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC08SO;

import java.util.Date;
import java.util.Enumeration;

public class SavePALFollowupImpl extends BaseServiceImpl implements SavePALFollowup {

  public static final String PRIMARY_CHILD = CodesTables.CROLEALL_PC;

  public static final String STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  /** This is not in CodesTables; it may be a bug. */
  public static final String FOLLOW_UP = "FUP";

  /**
   * This should probably come from a decode, but we do not want to link this to the framework that loads codes and
   * decodes, so it is hard-coded here.
   */
  public static final String PAL_FOLLOWUP_COMPLETED = "PAL Follow-up Completed";

  private CheckStageEventStatus checkStageEventStatus = null;
  private PalFollowUpDAO palFollowUpDAO = null;
  private PalPublicAssistDAO palPublicAssistDAO = null;
  private PostEvent postEvent = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoDAO todoDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPalFollowUpDAO(PalFollowUpDAO palFollowUpDAO) {
    this.palFollowUpDAO = palFollowUpDAO;
  }

  public void setPalPublicAssistDAO(PalPublicAssistDAO palPublicAssistDAO) {
    this.palPublicAssistDAO = palPublicAssistDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCFC08SO savePALFollowup(CCFC08SI ccfc08si) throws ServiceException {
    int rowsUpdated;
    ROWCCMN01UIG00 ccfc08si_rowccmn01uig00 = ccfc08si.getROWCCMN01UIG00();
    int idStage = ccfc08si_rowccmn01uig00.getUlIdStage();
    String cReqFuncCd = ccfc08si.getArchInputStruct().getCReqFuncCd();
    String cdTask = ccfc08si_rowccmn01uig00.getSzCdTask();
    int idEvent = ccfc08si_rowccmn01uig00.getUlIdEvent();
    String pageMode = ccfc08si.getSzSysCdWinMode();
    CCMN01UI ccmn01ui = new CCMN01UI();
    CCMN06UI ccmn06ui = new CCMN06UI();

    ccmn06ui.setArchInputStruct(ccfc08si.getArchInputStruct());
    ccmn06ui.getArchInputStruct().setCReqFuncCd(cReqFuncCd);
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    // CheckStageEventStatus; this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);

    Integer idPersonFromWorkload = 0;
    if (PageModeConstants.NEW.equals(pageMode)) {
      // cinv51dQUERYdam
      //idPersonFromWorkload = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage, PRIMARY_CHILD);
      idPersonFromWorkload = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PRIMARY_CHILD);
      if (idPersonFromWorkload == null || idPersonFromWorkload == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
    if (idEvent == 0) {
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {

      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
    int idPerson = ccfc08si_rowccmn01uig00.getUlIdPerson();

    ROWCCMN01UIG00 ccmn01ui_rowccmn01uig00 = new ROWCCMN01UIG00();
    ccmn01ui_rowccmn01uig00.setUlIdPerson(idPerson);
    ccmn01ui_rowccmn01uig00.setSzCdEventStatus(STATUS_COMPLETE);
    ccmn01ui_rowccmn01uig00.setSzCdEventType(FOLLOW_UP);
    ccmn01ui_rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    ccmn01ui_rowccmn01uig00.setUlIdEvent(idEvent);
    ccmn01ui_rowccmn01uig00.setUlIdStage(idStage);
    ccmn01ui_rowccmn01uig00.setSzCdTask(cdTask);
    ccmn01ui_rowccmn01uig00.setSzTxtEventDescr(PAL_FOLLOWUP_COMPLETED);

    if (idEvent != 0) {
      Date tsLastUpdate2 = ccfc08si.getTsSysTsLastUpdate2();
      ccmn01ui_rowccmn01uig00.setTsLastUpdate(tsLastUpdate2);
    }

    if (PageModeConstants.NEW.equals(pageMode)) {
      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idPersonFromWorkload);
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      ccmn01ui_rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    }

    // PostEvent (ccmn01u)
    ccmn01ui.setROWCCMN01UIG00(ccmn01ui_rowccmn01uig00);
    // Post event throws exceptions with appropriate messages that will halt processing if it fails.
    postEvent.postEvent(ccmn01ui);

    String cdPalFollupEducStat = ccfc08si.getSzCdPalFollupEducStat();
    String cdPalFollupEmployed = ccfc08si.getSzCdPalFollupEmployed();
    String cdPalFollupLivArr = ccfc08si.getSzCdPalFollupLivArr();
    String cdPalFollupMarital = ccfc08si.getSzCdPalFollupMarital();
    String cdPalFollupHighestEdu = ccfc08si.getSzCdPalFollupHighestEdu();
    String cdPalFollupReunified = ccfc08si.getUCdPalFollupReunified();
    Date dtPalFollupDate = DateHelper.toJavaDate(ccfc08si.getDtDtPalFollupDate());
    String indPalFollupNoPubAst = ccfc08si.getCIndPalFollupNoPubAst();
    String indPalFollupNotLocate = ccfc08si.getCIndPalFollupNotLocate();
    int nbrPalFollupNumChldrn = ccfc08si.getLNbrPalFollupNumChldrn();
    Date lastUpdate = ccmn01ui_rowccmn01uig00.getTsLastUpdate();

    // caud56dAUDdam
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      rowsUpdated = palFollowUpDAO.insertPalFollowUp(idStage, lastUpdate, dtPalFollupDate, cdPalFollupEducStat,
                                                     cdPalFollupEmployed, cdPalFollupHighestEdu, cdPalFollupLivArr,
                                                     cdPalFollupMarital, cdPalFollupReunified, indPalFollupNoPubAst,
                                                     indPalFollupNotLocate, nbrPalFollupNumChldrn);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      rowsUpdated = palFollowUpDAO.updatePalFollowUp(dtPalFollupDate, cdPalFollupEducStat, cdPalFollupEmployed,
                                                     cdPalFollupHighestEdu, cdPalFollupLivArr, cdPalFollupMarital,
                                                     cdPalFollupReunified, indPalFollupNoPubAst, indPalFollupNotLocate,
                                                     nbrPalFollupNumChldrn, lastUpdate, idStage);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      rowsUpdated = palFollowUpDAO.deletePalFollowUp(lastUpdate, idStage);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    if (rowsUpdated == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    if (ArchitectureConstants.N.equals(indPalFollupNoPubAst)) {
      ROWCCFC08SIG00_ARRAY rowCcfc08SiG00Array = ccfc08si.getROWCCFC08SIG00_ARRAY();

      for (Enumeration rowCcfc08SiG00Enum = rowCcfc08SiG00Array.enumerateROWCCFC08SIG00();
           rowCcfc08SiG00Enum.hasMoreElements();) {

        ROWCCFC08SIG00 rowCcfc08SiG00 = (ROWCCFC08SIG00) rowCcfc08SiG00Enum.nextElement();
        String cdPalPublicAssist = rowCcfc08SiG00.getSzCdPalPublicAssist();

        PalPublicAssist palPublicAssist = new PalPublicAssist();
        palPublicAssist.getId().setCdPalPublicAssist(cdPalPublicAssist);

        // caud57dAUDdam
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          palPublicAssistDAO.savePalPublicAssist(palPublicAssist);
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
          rowsUpdated = palPublicAssistDAO.deletePalPublicAssist(idStage, cdPalPublicAssist, lastUpdate);
          if (rowsUpdated == 0) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }

    }

    // Added the TODO AUD, CAUDB7D, to the save service so that whenever the data for PAL Followup is saved,
    // the associated TODOs, if any, will be taken off the Staff TODO List. This is necessary because in the
    // PAL Dialog when a TODO is completed for the ILS or RUT windows the event status remains PROC
    // until the stage is completed through the PAL Summary window. Thus, simply completing a TODO would not have
    // removed it from the TODO List. The CAUDB7D dam updates the date TODO completed and removes the TODO from
    // the TODO list whenever the window data is saved. Allocate memory for DAM Input and Output Structures
    // caudb7dAUDdam
    todoDAO.updateToDoDtTodoCompletedByIdStageAndCdTodoTask(idStage, cdTask);
    // Return an empty CCFC08SO object, for consistency.
    return new CCFC08SO();
  }

}
