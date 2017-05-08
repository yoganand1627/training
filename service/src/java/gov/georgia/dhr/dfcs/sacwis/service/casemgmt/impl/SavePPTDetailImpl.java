package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PptDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Ppt;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SavePPTDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB50SO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SavePPTDetailImpl extends BaseServiceImpl implements SavePPTDetail {

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexStageDAO complexStageDAO = null;
  
  private ContactStandardsDAO contactStandardsDAO = null;

  private PostEvent postEvent = null;

  private TodoDAO todoDAO = null;

  private PptDAO pptDAO = null;

  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }
  
  public void setContactStandardsDAO(ContactStandardsDAO contactStandardsDAO) {
    this.contactStandardsDAO = contactStandardsDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setPptDAO(PptDAO pptDAO) {
    this.pptDAO = pptDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public CSUB50SO savePPTDetail(CSUB50SI csub50si) throws ServiceException {

    CSUB50SO csub50so = new CSUB50SO();
    int userId = csub50si.getROWCCMN01UIG00().getUlIdPerson();
    Calendar cal = Calendar.getInstance();
    Date dtCurrentDate = cal.getTime();

    // (BEGIN): Common Function: ccmn06u Check Stage/Event common function
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(csub50si.getArchInputStruct());

    if (csub50si.getROWCCMN01UIG00().getUlIdEvent() == 0) {
      ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    ccmn06ui.setUlIdStage(csub50si.getUlIdStage());
    ccmn06ui.setSzCdTask(csub50si.getROWCCMN01UIG00().getSzCdTask());

    // this throws an exception that will halt processing with a message if it fails; success is no output.
    checkStageEventStatus.status(ccmn06ui);
    int idPerson = 0;
    String cdStage = csub50si.getCSUB50SIG00().getSzCdStage();
    if (csub50si.getUlIdPerson() == 0 && !(CodesTables.CTXGASTG_FPR.equals(cdStage))
        && !(CodesTables.CTXGASTG_FSU.equals(cdStage)) && !(CodesTables.CTXGASTG_INV.equals(cdStage))) {
      idPerson = complexStageDAO.findPrimaryWorker(csub50si.getUlIdStage(), PRIMARY_CHILD);
      /*
       * if (idPerson == 0) { throw new ServiceException(Messages.SQL_NOT_FOUND); }
       */
    }
    csub50si.setUlIdPerson(idPerson);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(csub50si.getArchInputStruct());
    ROWCCMN01UIG00 rowCCMN01UIG00 = csub50si.getROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowCCMN01UIG00_Array = new ROWCCMN01UIG01_ARRAY();
    ROWCCMN01UIG01 rowCCMN01UIG01 = new ROWCCMN01UIG01();
    
    if (csub50si.getROWCCMN01UIG00().getUlIdEvent() == 0) {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      rowCCMN01UIG01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowCCMN01UIG01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    }
    
      if (csub50si.getUlIdPerson() != 0) {
        rowCCMN01UIG01.setUlIdPerson(csub50si.getUlIdPerson());
        rowCCMN01UIG00_Array.addROWCCMN01UIG01(0, rowCCMN01UIG01);
      }
      rowCCMN01UIG00.setROWCCMN01UIG01_ARRAY(rowCCMN01UIG00_Array);
      ccmn01ui.setROWCCMN01UIG00(rowCCMN01UIG00);
    
    
    int idEvent = 0;
    CCMN01UO ccmn01uo = new CCMN01UO();
    if (ccmn01ui.getROWCCMN01UIG00() != null) {
      ccmn01ui.getROWCCMN01UIG00().setDtDtEventOccurred(DateHelper.toCastorDate(dtCurrentDate));
      ccmn01ui.getROWCCMN01UIG00().setTsLastUpdate(csub50si.getROWCCMN01UIG00().getTsLastUpdate());
      ccmn01ui.getROWCCMN01UIG00().setUlIdEvent(csub50si.getROWCCMN01UIG00().getUlIdEvent());
      ccmn01ui.getROWCCMN01UIG00().setUlIdStage(csub50si.getROWCCMN01UIG00().getUlIdStage());
      ccmn01ui.getROWCCMN01UIG00().setUlIdPerson(csub50si.getROWCCMN01UIG00().getUlIdPerson());
      ccmn01ui.getROWCCMN01UIG00().setSzCdTask(csub50si.getROWCCMN01UIG00().getSzCdTask());
      ccmn01ui.getROWCCMN01UIG00().setSzCdEventStatus(csub50si.getROWCCMN01UIG00().getSzCdEventStatus());
      ccmn01ui.getROWCCMN01UIG00().setSzCdEventType(csub50si.getROWCCMN01UIG00().getSzCdEventType());
      ccmn01ui.getROWCCMN01UIG00().setSzTxtEventDescr(csub50si.getROWCCMN01UIG00().getSzTxtEventDescr());

      // this throws an exception that will halt processing with a message if it fails; success is no output.
      ccmn01uo = postEvent.postEvent(ccmn01ui);

      csub50so.setUlIdEvent(ccmn01uo.getUlIdEvent());
      csub50so.setTsSysTsLastUpdate2(ccmn01uo.getTsLastUpdate());

      // removed block of code that was errored but unused in Ga system

      if (csub50si.getCSUB50SIG00().getUlIdPptEvent() == 0) {
        idEvent = ccmn01uo.getUlIdEvent();
      } else {
        idEvent = csub50si.getCSUB50SIG00().getUlIdPptEvent();
      }
    } else {
      idEvent = csub50si.getCSUB50SIG00().getUlIdPptEvent();
      csub50so.setUlIdEvent(idEvent);
    }

    Ppt ppt = new Ppt();

    if (!(csub50si.getCSUB50SIG00().getUlIdPptEvent() == 0)) {
      ppt = (Ppt) getPersistentObject(Ppt.class, idEvent);
    }

    Event event = (Event) getPersistentObject(Event.class, idEvent);

    ppt.setEvent(event);
    ppt.setAddrPptCity(csub50si.getCSUB50SIG00().getSzAddrPptCity());
    ppt.setAddrPptCnty(csub50si.getCSUB50SIG00().getSzAddrPptCnty());
    ppt.setAddrPptStLn1(csub50si.getCSUB50SIG00().getSzAddrPptStLn1());
    ppt.setAddrPptStLn2(csub50si.getCSUB50SIG00().getSzAddrPptStLn2());
    ppt.setAddrPptState(csub50si.getCSUB50SIG00().getSzAddrPptState());
    ppt.setAddrPptZip(csub50si.getCSUB50SIG00().getSzAddrPptZip());
    ppt.setNbrPptPhone(csub50si.getCSUB50SIG00().getSzNbrPptPhone());
    ppt.setTxtPptAddrCmnt(csub50si.getCSUB50SIG00().getSzTxtPptAddrCmnt());

    if (csub50si.getCSUB50SIG00().getTmScrTmPptTime() != null) {
      ppt.setDtPptDate(DateHelper.toJavaDateSafe(csub50si.getCSUB50SIG00().getDtDtPptDate(),
                                                 csub50si.getCSUB50SIG00().getTmScrTmPptTime()));
    } else {
      ppt.setDtPptDate(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtDtPptDate()));
    }
    ppt.setCdPptType(csub50si.getCSUB50SIG00().getSzMeetingType());
    ppt.setDtAhOutcome(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtOutcomeDiscussed()));
    ppt.setDtAhRequested(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtDateHearingReq()));
    ppt.setIndAhAsstNeeded(csub50si.getCSUB50SIG00().getBIndAssistNeeded());
    ppt.setDtUrBegin(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtUtilBeginDate()));
    ppt.setDtUrEnd(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtUtilEndDate()));
    ppt.setDtDatePrepIntvw(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtDatePrepIntvw()));
    ppt.setDtPermRepComp(DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtPermRepComp()));
    ppt.setIndFtmReqMet(csub50si.getCSUB50SIG00().getBIndPrevReqMet());
    ppt.setIndMdtPerm(csub50si.getCSUB50SIG00().getBIndPermanency());
    ppt.setIndMdtWlbng(csub50si.getCSUB50SIG00().getBIndWellbeing());
    ppt.setIndMdtSfty(csub50si.getCSUB50SIG00().getBIndSafety());
    ppt.setNbrPptPhoneExt(csub50si.getCSUB50SIG00().getLNbrPptPhoneExt());
    ppt.setIndTranPlanComp(csub50si.getCSUB50SIG00().getIndTranPlanComp());
    
    // MR-62: Added contact standards logic
    CSUB50SIG00 csub50sig00 = csub50si.getCSUB50SIG00();
    Integer idContactStdsEvent = csub50sig00.getUlIdContactStdsEvent();
    if (idContactStdsEvent > 0) {
      ContactStandards cs = contactStandardsDAO.findContactStandardsByIdEvent(idContactStdsEvent);
        //(ContactStandards) getPersistentObject(ContactStandards.class, idContactStdsEvent);
      ppt.setContactStandards(cs);
    }

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(csub50si.getArchInputStruct().getCReqFuncCd())
        || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(csub50si.getArchInputStruct().getCReqFuncCd())) {

      pptDAO.savePpt(ppt);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(csub50si.getArchInputStruct().getCReqFuncCd())) {

      pptDAO.deletePpt(ppt);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }

    // Retrieve record from the PPT Table to get most recent timestamp

    Ppt pptInfo = pptDAO.findPpt(idEvent);

    csub50so.setUlIdPptEvent(pptInfo.getIdPptEvent() != null ? pptInfo.getIdPptEvent() : 0);
    csub50so.setTsLastUpdate(pptInfo.getDtLastUpdate());

    if (ArchitectureConstants.YES.equals(csub50si.getCSysIndDtPptCompFlld())) {

      ccmn01ui.setArchInputStruct(csub50si.getArchInputStruct());
      ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ccmn01ui.getROWCCMN01UIG00().setDtDtEventOccurred(DateHelper.toCastorDate(dtCurrentDate));
      ccmn01ui.getROWCCMN01UIG00().setSzCdEventStatus(STATUS_NEW);
      if (csub50si.getROWCCMN01UIG00().getUlIdPerson() != 0) {
        ccmn01ui.getROWCCMN01UIG00().setUlIdPerson(csub50si.getROWCCMN01UIG00().getUlIdPerson());
      }
      ccmn01ui.getROWCCMN01UIG00().setSzTxtEventDescr(PPR);
      ccmn01ui.getROWCCMN01UIG00().setUlIdEvent(csub50si.getROWCCMN01UIG00().getUlIdEvent());
      ccmn01ui.getROWCCMN01UIG00().setUlIdStage(csub50si.getROWCCMN01UIG00().getUlIdStage());
      ccmn01ui.getROWCCMN01UIG00().setSzCdTask(csub50si.getROWCCMN01UIG00().getSzCdTask());
      ccmn01ui.getROWCCMN01UIG00().setSzCdEventType(csub50si.getROWCCMN01UIG00().getSzCdEventType());

      // this throws an exception that will halt processing with a message if it fails; success is no output.
      ccmn01uo = postEvent.postEvent(ccmn01ui);

      CSUB40UI csub40ui = new CSUB40UI();
      csub40ui.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE1);
      csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub50si.getCSUB50SIG00().getDtDtPptDate());
      csub40ui.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub50si.getUlSysIdTodoCfPersCrea());
      csub40ui.getCSUB40UIG00().setUlSysIdTodoCfStage(csub50si.getUlIdStage());
      csub40ui.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccmn01uo.getUlIdEvent());
      CSUB40UO csub40uo = todoCommonFunction.audTodo(csub40ui);

      if (csub40uo != null) {

        csub40ui.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE2);
        csub40ui.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub50si.getCSUB50SIG00().getDtDtPptDate());
        csub40ui.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub50si.getUlSysIdTodoCfPersCrea());
        csub40ui.getCSUB40UIG00().setUlSysIdTodoCfStage(csub50si.getUlIdStage());
        csub40ui.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccmn01uo.getUlIdEvent());
        csub40uo = todoCommonFunction.audTodo(csub40ui);
      }
    }
    Date meetingDate = DateHelper.toJavaDate(csub50si.getCSUB50SIG00().getDtDtPptDate());
    if (CodesTables.CTXGASTG_SUB.equals(cdStage)) {
      List<CnsrvtrshpRemoval> cnsrvtrRemovalList = cnsrvtrshpRemovalDAO.findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(csub50si.getUlIdCase(),idPerson);
      if (cnsrvtrRemovalList != null && !cnsrvtrRemovalList.isEmpty()) {
        if (CodesTables.CMEETTYP_MDT.equals(csub50si.getCSUB50SIG00().getSzMeetingType())
            && meetingDate.after(DateHelper.addToDate(cnsrvtrRemovalList.get(0).getDtRemoval(), 0, 0, 25))) {
          addMDTNotOccurAlertTodo(idEvent, csub50si.getUlIdCase(), csub50si.getUlIdStage(), userId,
                                  cnsrvtrRemovalList.get(0).getDtRemoval());
        }
        if (CodesTables.CMEETTYP_FTM.equals(csub50si.getCSUB50SIG00().getSzMeetingType())
            && meetingDate.after(DateHelper.addToDate(cnsrvtrRemovalList.get(0).getDtRemoval(), 0, 0, 7))) {
          addFTMNotOccurAlertTodo(idEvent, csub50si.getUlIdCase(), csub50si.getUlIdStage(), userId,
                                  cnsrvtrRemovalList.get(0).getDtRemoval());
        }
      }
    }
    return csub50so;
  }

  private int addMDTNotOccurAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date endDate) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    int idPerson = complexStageDAO.findPrimaryWorker(idStage, PRIMARY_CHILD);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = DateHelper.addToDate(endDate, 0, 0, 25);
    String todoDesc = "MDT did not occur within 20 days of child's placement.";
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

  private int addFTMNotOccurAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date endDate) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    int idPerson = complexStageDAO.findPrimaryWorker(idStage, PRIMARY_CHILD);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = DateHelper.addToDate(endDate, 0, 0, 7);
    String todoDesc = "FTM did not occur within 7 days of child's placement.";
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

}
