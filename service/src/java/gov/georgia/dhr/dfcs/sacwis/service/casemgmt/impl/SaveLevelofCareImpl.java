package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonLocDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonLoc;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveLevelofCare;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdEventStatus_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TsLastUpdate_ARRAY;

public class SaveLevelofCareImpl extends BaseServiceImpl implements SaveLevelofCare {

  private CheckStageEventStatus checkStageEventStatus = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PostEvent postEvent = null;
  private PersonLocDAO personLocDAO = null;
  private ComplexPersonLocDAO complexPersonLocDAO = null;
  private TodoDAO todoDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setComplexPersonLocDAO(ComplexPersonLocDAO complexPersonLocDAO) {
    this.complexPersonLocDAO = complexPersonLocDAO;
  }

  public void setPersonLocDAO(PersonLocDAO personLocDAO) {
    this.personLocDAO = personLocDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CSUB17SO saveEventAndLevelofCare(CSUB17SI csub17si) throws ServiceException {
    CSUB17SO csub17so = new CSUB17SO();
    String cReqFuncCd = csub17si.getArchInputStruct().getCReqFuncCd();
    checkEventStatus(cReqFuncCd, csub17si.getSzCdTask(), csub17si.getUlIdStage());
    if (0 == csub17si.getUlIdPerson()) {
      // If the IdPerson of the service input Message is 0, get the Id Person of the stage's
      //   primary child.(CdStagePersRole is set to "primary child")
      // cinv51d
      Integer idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(csub17si.getUlIdPerson(),
                                                                                    CodesTables.CROLEALL_PC);
      if (idPerson == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // Set both service input and output message person ID's to To-Do person assigned.
      // The service will use this person ID when calling other DAOs.
      csub17si.setUlIdPerson(idPerson != null ? idPerson : 0);
      csub17so.setUlIdPerson(idPerson != null ? idPerson : 0);
    }
    //csub88d -- checks for duplicate dates for ALOC.
    long countNumberofRows =
            personLocDAO.countPersonLocByDtPlocStart(csub17si.getUlIdPerson(),
                                                     csub17si.getSzCdPlocType(),
                                                     DateHelper.toJavaDate(csub17si.getDtDtPlocStart()));
    if ((CodesTables.CPLOCELG_ALOC.equals(csub17si.getSzCdPlocType()) && countNumberofRows != 0 &&
         ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) || (countNumberofRows > 0 && StringHelper.isTrue(
            csub17si.getIndDateModified()) && ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd))) {
      throw new ServiceException(Messages.MSG_ALOC_START_DT_EXISTS);
    }
    // Call postEvent to add or update the event as necessary.
    CCMN01UO ccmn01uo = postEvent(csub17si.getTsLastUpdate_ARRAY().getTsLastUpdate(), csub17si.getSzCdTask(),
                                  csub17si.getUlIdStage(), csub17si.getUlIdEventPerson(), csub17si.getUlIdPlocEvent(),
                                  csub17si.getSzCdEventStatus_ARRAY(), csub17si.getSzTxtEventDescr(),
                                  csub17si.getUlIdPerson());
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      csub17so.setUlIdEvent(ccmn01uo.getUlIdEvent());
    }
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      csub17so.setUlIdEvent(csub17si.getUlIdPlocEvent());
    }
    TsLastUpdate_ARRAY csub17so_tsLastUpdate_array = new TsLastUpdate_ARRAY();
    csub17so_tsLastUpdate_array.setTsLastUpdate(new Date[] {ccmn01uo.getTsLastUpdate()});
    csub17so.setTsLastUpdate_ARRAY(csub17so_tsLastUpdate_array);
    // Update the person loc table.
    auPersonLoc(csub17si, csub17so.getUlIdEvent());
    int idPlocEvent;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      idPlocEvent = csub17so.getUlIdEvent();
    } else {
      idPlocEvent = csub17si.getUlIdPlocEvent();
    }
    // cses15d
    Object[] personLocInfo = personLocDAO.findPersonLoc(idPlocEvent);
    if (personLocInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    PersonLoc personLoc = (PersonLoc) personLocInfo[0];
    csub17so_tsLastUpdate_array.addTsLastUpdate(personLoc.getDtLastUpdate());
    if (0 != csub17si.getUlIdPlocEvent()) {
      // cinv43d -- ignores SQL_NOT_FOUND
      todoDAO.updateTodoByIdEvent(csub17si.getUlIdPlocEvent());
    }
    return csub17so;
  }

  private void auPersonLoc(CSUB17SI csub17si, int outputIdEvent) throws ServiceException {
    int idPlocEvent;
    // Iff the service is in "add" mode, move the IdEvent from the service output message to the DAM input message.
    // Else, the DAM input IdEvent is set to the IdEvent in the service input message.
    // Set IdEvent to common function IdEvent if in "add" mode
    if (0 == csub17si.getUlIdPlocEvent()) {
      idPlocEvent = outputIdEvent;
    } else {
      idPlocEvent = csub17si.getUlIdPlocEvent();
    }
    // If LOC type is "billing", the window is in modify mode, and current event status is "complete",
    //   set the Write history indicator flag.
    // The indicator is set regardless of the event, closed or in process.
    // The indicator should have no effects on payment.
    String cReqFuncCd = csub17si.getArchInputStruct().getCReqFuncCd();
    String indPlocWriteHistory;
    if (CodesTables.CPLOCELG_BLOC.equals(csub17si.getSzCdPlocType()) &&
        ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      indPlocWriteHistory = ArchitectureConstants.Y;
    } else {
      indPlocWriteHistory = ArchitectureConstants.N;
    }
    int idPerson = csub17si.getUlIdPerson();
    String cdPlocChild = csub17si.getSzCdPlocChild();
    String cdPlocType = csub17si.getSzCdPlocType();
    String sysIndPrfrmValidation = csub17si.getBSysIndPrfrmValidation();
    String indPlocCsupSend = csub17si.getCIndPlocCsupSend();
    Date dtPlocEnd = DateHelper.toJavaDate(csub17si.getDtDtPlocEnd());
    Date dtPlocStart = DateHelper.toJavaDate(csub17si.getDtDtPlocStart());
    int idPersUpdt = csub17si.getUlIdPersUpdt();
    String cdRevType = csub17si.getSzCdRevType();
    int idStage = csub17si.getUlIdStage(); // only used for caude9d, not caud11d
    // The second element in the tsLastUpdate_array is used for the LOC tsLastUpdate.
    Date dtLastUpdate = csub17si.getTsLastUpdate_ARRAY().getTsLastUpdate(1);
    int rowsAffected;
    if (CodesTables.CPLOCELG_ALOC.equals(csub17si.getSzCdPlocType())) {
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // caude9d
        rowsAffected = complexPersonLocDAO.insertPersonLoc(idPerson, idStage, sysIndPrfrmValidation, cdPlocChild,
                                                           cdPlocType, dtPlocEnd, dtPlocStart, indPlocCsupSend,
                                                           indPlocWriteHistory, idPersUpdt, cdRevType);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // caude9d
        rowsAffected = complexPersonLocDAO.updatePersonLoc(idPerson, cdPlocType, dtPlocStart, dtPlocEnd,
                                                           idPlocEvent, idStage, cdPlocChild, indPlocCsupSend,
                                                           indPlocWriteHistory, idPersUpdt, cdRevType, dtLastUpdate);
      } else {
        // DELETE is not allowed
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    } else {
      // Not found will have to be accepted given the fact
      // that the call could be coming from the temporary
      // workload, and would not have a stage record.
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // caud11d
        rowsAffected = complexPersonLocDAO.insertPersonLocRloc(sysIndPrfrmValidation, idPlocEvent, idPerson,
                                                               cdPlocChild, cdPlocType, dtPlocEnd, dtPlocStart,
                                                               indPlocCsupSend, indPlocWriteHistory, idPersUpdt,
                                                               cdRevType);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // caud11d
        rowsAffected = complexPersonLocDAO.updatePersonLocRloc(sysIndPrfrmValidation, idPlocEvent, idPerson,
                                                               cdPlocChild, cdPlocType, dtPlocEnd, dtPlocStart,
                                                               indPlocCsupSend, indPlocWriteHistory, idPersUpdt,
                                                               cdRevType, dtLastUpdate);
      } else {
        // DELETE is not allowed
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    if (rowsAffected == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  private CCMN01UO postEvent(Date[] csub17so_tsLastUpdates, String cdTask, int idStage, int idEventPerson,
                             int idPlocEvent, SzCdEventStatus_ARRAY szCdEventStatus_array, String txtEventDescr,
                             int idPerson) throws ServiceException {
    //post event processing
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    CCMN01UI ccmn01ui = new CCMN01UI();
    rowccmn01uig00.setSzCdTask(cdTask);
    // Pull the second element in the event status array out to use here.
    rowccmn01uig00.setSzCdEventStatus(szCdEventStatus_array.getSzCdEventStatus(1));
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_LOC);
    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rowccmn01uig00.setUlIdPerson(idEventPerson);
    rowccmn01uig00.setUlIdEvent(idPlocEvent);
    // Use the first timestamp entry here
    rowccmn01uig00.setTsLastUpdate(csub17so_tsLastUpdates[0]);
    rowccmn01uig00.setSzTxtEventDescr(txtEventDescr);
    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
    if (0 == idPlocEvent) {
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
    ROWCCMN01UIG01_ARRAY rowccmn01uig00_array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    // Name: if person is being added, create default entry in Name table
    // Use the first element of the event status array here
    if (CodesTables.CEVTSTAT_NEW.equals(szCdEventStatus_array.getSzCdEventStatus(0)) ||
        0 == idPlocEvent) {
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01.setUlIdPerson(idPerson);
      rowccmn01uig00_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig00_array);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    // Calling PostEvent
    return postEvent.postEvent(ccmn01ui);
  }

  private void checkEventStatus(String cReqFuncCd, String cdTask, int idStage) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    ccmn06ui.setSzCdTask(cdTask);
    ccmn06ui.setUlIdStage(idStage);
    // Calling CheckStageEventStatus (indirectly CCMN06U)
    // The Exception with appropriate error messages are thrown by the called method.
    // Hence no need to catch them here.
    checkStageEventStatus.status(ccmn06ui);
  }
}

