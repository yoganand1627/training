package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePAL;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC04SO;

public class SavePALImpl extends BaseServiceImpl implements SavePAL {

  public static final String PRIMARY_CHILD_ROLE = "PC";
  public static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;
  public static final String EVENT_TYPE_PCL = "PCL";
  public static final String PAL_STAGE_TYPE = CodesTables.CSTAGES_PAL;
  public static final String PAL_STAGE_TODO = "CFC001";
  public static final String TODO_DESCRIP = "The PAL Stage has been closed for ";
  public static final String EVENT_TYPE_ILS = "ILS";
  public static final String EVENT_TYPE_RUT = "RUT";

  private CloseStageCase closeStageCase = null;
  private ComplexStageDAO complexStageDAO = null;
  private EventDAO eventDAO = null;
  private PalDAO palDAO = null;
  private PersonDAO personDAO = null;
  private PostEvent postEvent = null;
  private TodoCommonFunction todoCommonFunction = null;

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPalDAO(PalDAO palDAO) {
    this.palDAO = palDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public CCFC04SO savePAL(CCFC04SI ccfc04si) throws ServiceException {
    CCFC04SO ccfc04so = new CCFC04SO();
    int ccfc04siIdStage = ccfc04si.getUlIdStage();

    // cinv51dQUERYdam
    int cinv51dIdPrimaryWorker = complexStageDAO.findPrimaryWorker(ccfc04siIdStage, PRIMARY_CHILD_ROLE);

    if (cinv51dIdPrimaryWorker == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct ccfc04siArchInputStruct = ccfc04si.getArchInputStruct();
    ROWCCMN01UIG00 rowCcmn01Uig00 = new ROWCCMN01UIG00();
    int ccfc04siIdEvent = ccfc04si.getUlIdEvent();

    if (0 != ccfc04siIdEvent) {
      ccfc04siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowCcmn01Uig00.setTsLastUpdate(ccfc04si.getROWCCMN01UIG00().getTsLastUpdate());
    } else {
      ccfc04siArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }

    ccmn01ui.setArchInputStruct(ccfc04siArchInputStruct);
    ROWCCMN01UIG01 rowCcmn01Uig01 = new ROWCCMN01UIG01();
    rowCcmn01Uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    rowCcmn01Uig01.setUlIdPerson(cinv51dIdPrimaryWorker);
    ROWCCMN01UIG01_ARRAY rowCcmn01Uig01Array = new ROWCCMN01UIG01_ARRAY();
    rowCcmn01Uig01Array.setROWCCMN01UIG01(0, rowCcmn01Uig01);
    rowCcmn01Uig00.setROWCCMN01UIG01_ARRAY(rowCcmn01Uig01Array);
    ROWCCMN01UIG00 ccfc04siRowCcmn01Uig00 = ccfc04si.getROWCCMN01UIG00();
    rowCcmn01Uig00.setSzCdTask(ccfc04siRowCcmn01Uig00.getSzCdTask());
    rowCcmn01Uig00.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
    rowCcmn01Uig00.setSzCdEventType(EVENT_TYPE_PCL);
    rowCcmn01Uig00.setSzTxtEventDescr(ccfc04siRowCcmn01Uig00.getSzTxtEventDescr());
    rowCcmn01Uig00.setUlIdPerson(ccfc04siRowCcmn01Uig00.getUlIdPerson());
    rowCcmn01Uig00.setUlIdStage(ccfc04siIdStage);
    rowCcmn01Uig00.setUlIdEvent(ccfc04siIdEvent);
    rowCcmn01Uig00.setDtDtEventOccurred(ccfc04si.getDtDtStageClose());
    ccmn01ui.setROWCCMN01UIG00(rowCcmn01Uig00);
    postEvent.postEvent(ccmn01ui);

    // cmsc15dAUDdam
    int cmsc15dRowsUpdated = palDAO.updatePal(ccfc04siIdStage, ccfc04si.getSzCdPalCloseLivArr());

    if (cmsc15dRowsUpdated == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }

    // Call the EVENT STATUS DAO - CAUD64D
    // Description - This DAO will update the CD EVENT STATUS for a row in the
    // EVENT table given CD EVENT TYPE and the ID STAGE. This
    // DAO will change all events for the stage with the CD EVENT
    // TYPE specified. It will change the CD EVENT STATUS to the
    // status specified in the input.
    // (re-open PAL Training/Serivces event)

    // caud64dAUDdam
    int caud64dRowsUpdated = eventDAO.updateEvent(EVENT_STATUS_COMPLETE, ccfc04siIdStage, EVENT_TYPE_RUT);

    if (caud64dRowsUpdated == 0) {
      // caud64dAUDdam
      eventDAO.updateEvent(EVENT_STATUS_COMPLETE, ccfc04siIdStage, EVENT_TYPE_ILS);
    }

    // csec66dQUERYdam
    int csec66dIdPerson = personDAO.findIdPersonByIdStageCdUnitSpecialization(ccfc04siIdStage);

    if (csec66dIdPerson == 0) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }

    // Call the Stage Person Link DAO - CCMN44D
    // Description - This DAO will return a single row from the
    // person table based upon the ID_PERSON passed
    // in.

    // ccmn44dQUERYdam
    Person ccmn44dPerson = personDAO.findPersonByIdPerson(csec66dIdPerson);

    if (ccmn44dPerson == null) {
      throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
    }

    String ccmn44dNmPersonFull = ccmn44dPerson.getNmPersonFull();

    // Call the ToDo Common Function - CSUB40U
    // Description - This service performs the business logic neccessary
    // to execute the TODO COMMON FUNCTION. This service
    // will help standardize/formalize how Todo's are created.
    // It will prevent hard-coding, of Todo descriptions, due
    // dates, and other data within the functional program.

    CSUB40UI csub40ui = new CSUB40UI();
    ArchInputStruct csub40uiArchInputStruct = ccfc04si.getArchInputStruct();
    csub40uiArchInputStruct.setCReqFuncCd(ccfc04si.getArchInputStruct().getCReqFuncCd());
    csub40ui.setArchInputStruct(csub40uiArchInputStruct);
    CSUB40UIG00 csub40Uig00 = new CSUB40UIG00();
    csub40Uig00.setSzSysCdTodoCf(PAL_STAGE_TODO);
    csub40Uig00.setSzSysTxtTodoCfDesc(TODO_DESCRIP);
    csub40Uig00.setSzSysTxtTodoCfDesc(csub40Uig00.getSzSysTxtTodoCfDesc() + ccmn44dNmPersonFull);
    csub40Uig00.setDtSysDtTodoCfDueFrom(ccfc04si.getDtDtStageClose());
    csub40Uig00.setUlSysIdTodoCfPersAssgn(csec66dIdPerson);
    csub40Uig00.setUlSysIdTodoCfPersCrea(ccfc04siRowCcmn01Uig00.getUlIdPerson());
    csub40Uig00.setUlSysIdTodoCfEvent(ccfc04siRowCcmn01Uig00.getUlIdEvent());
    csub40Uig00.setUlSysIdTodoCfStage(ccfc04siIdStage);
    csub40ui.setCSUB40UIG00(csub40Uig00);
    todoCommonFunction.audTodo(csub40ui);

    // Call the Close Stage Case Common Function - CCMN02U
    // Description - This shared library function provides the necessary
    // updates required to close a stage. If a case and a
    // situation are associated with the stage, and there are
    // no other open stages associated with the case, the
    // situation and the case are also closed.

    CCMN02UI ccmn02ui = new CCMN02UI();
    ArchInputStruct ccmn02uiArchInputStruct = ccfc04si.getArchInputStruct();
    ccmn02uiArchInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn02ui.setArchInputStruct(ccmn02uiArchInputStruct);
    CCMN02UIG00 ccmn02Uig00 = new CCMN02UIG00();
    ccmn02Uig00.setSzCdStageReasonClosed(ccfc04si.getSzCdStageReasonClosed());
    ccmn02Uig00.setSzCdStage(PAL_STAGE_TYPE);
    ccmn02Uig00.setSzCdStageProgram(ccfc04si.getSzCdStageProgram());
    ccmn02Uig00.setUlIdStage(ccfc04siIdStage);
    ccmn02ui.setCCMN02UIG00(ccmn02Uig00);
    closeStageCase.closeStageCase(ccmn02ui);

    return ccfc04so;
  }
}
