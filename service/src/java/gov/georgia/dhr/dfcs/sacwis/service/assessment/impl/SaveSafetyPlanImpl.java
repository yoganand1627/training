package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpPersonsRespnsblDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SpPersonsRespnsbl;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.SaveSafetyPlan;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonResonsibleSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorSO;

import java.util.Iterator;
import java.util.List;

public class SaveSafetyPlanImpl extends BaseServiceImpl implements SaveSafetyPlan {

  private SpSafetyFactorsDAO spSafetyFactorsDAO = null;

  private SpSafetyPlanDAO spSafetyPlanDAO = null;

  private SpPersonsRespnsblDAO spPersonsRespnsblDAO = null;

  private EventDAO eventDAO = null;

  private PostEvent postEvent = null;

  private CheckStageEventStatus checkStageEventStatus;
  
  private ApprovalDAO approvalDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  
  private TodoDAO todoDAO = null;
  
  private ApprovalRejectionDAO approvalRejectionDAO = null;
  
  private ApproversDAO approversDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private InvalidateApproval invalidateApproval = null;
  

  public void setSpSafetyFactorsDAO(SpSafetyFactorsDAO spSafetyFactorsDAO) {
    this.spSafetyFactorsDAO = spSafetyFactorsDAO;
  }

  public void setSpSafetyPlanDAO(SpSafetyPlanDAO spSafetyPlanDAO) {
    this.spSafetyPlanDAO = spSafetyPlanDAO;
  }

  public void setSpPersonsRespnsblDAO(SpPersonsRespnsblDAO spPersonsRespnsblDAO) {
    this.spPersonsRespnsblDAO = spPersonsRespnsblDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public EventDAO getEventDAO() {
    return eventDAO;
  }

    
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
    }
  
  public void setApprovalRejectionDAO(ApprovalRejectionDAO approvalRejectionDAO) {
    this.approvalRejectionDAO = approvalRejectionDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  @SuppressWarnings("unchecked")
  public int deleteSafetyPlan(SafetyPlanSaveSI safetyPlanSaveSI) {
    int idCase = safetyPlanSaveSI.getUlIdCase();
    int idEvent = safetyPlanSaveSI.getUlIdEvent();
    int idStage = safetyPlanSaveSI.getUlIdStage();
    List deletedFactorList = safetyPlanSaveSI.getDeletedFactorList();
    SpSafetyFactors spSafetyFactors = null;
    List<SafetyFactorSO> safetyFactorList = safetyPlanSaveSI.getSafetyFactorList();
    Iterator safetyFactorIt = safetyFactorList.iterator();
    
    //  make sure stage is not closed
    checkStageEventStatus(ServiceConstants.REQ_FUNC_CD_DELETE, idStage, CodesTables.CSTAGES_INV);
    
    while (safetyFactorIt.hasNext()) {
      SafetyFactorSO safetyFactorSO = (SafetyFactorSO) safetyFactorIt.next();
      int idSftyFctr = safetyFactorSO.getIdSftyFctr();
      deletedFactorList.add(idSftyFctr);
    }
    Event event = null;
    SpSafetyPlan spSafetyPlan = getPersistentObject(SpSafetyPlan.class, idEvent);
    event = getPersistentObject(Event.class, idEvent);
    spSafetyPlan.setEvent(event);
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    spSafetyPlan.setCapsCase(capsCase);

    
    // delete factors and persons responsible
    if (deletedFactorList != null) {
      Iterator deletedFactorListIt = deletedFactorList.iterator();
      Integer idFactor = null;
      while (deletedFactorListIt.hasNext()) {
        idFactor = (Integer) deletedFactorListIt.next();
        // Safety Factor
        // Delete Safety Factors
        if (idEvent != 0) {
          spPersonsRespnsblDAO.deleteSpPersonsRespnsbl(idFactor);
          spSafetyFactorsDAO.deleteSafetyFactor(idFactor);
        }
      }
    }
    
    
   // STGAP00009550 Deleting an event should delete Task from approvers ToDo list
    
    List<Integer> idApprovalList = approvalEventLinkDAO.findIdApprovalEventLinksByIdEvent(idEvent);
    if (idApprovalList != null && !idApprovalList.isEmpty()) {
      // Delete the todo associating approver
      List<Approvers> approversList = approversDAO.findApproversByIdApproval(idApprovalList);
      if (approversList != null && !approversList.isEmpty()) {
        for (Iterator<Approvers> it = approversList.iterator(); it.hasNext();) {
          Approvers approvers = it.next();
          int idTodo = approvers.getTodo().getIdTodo();
          if (idTodo != 0) {
            Todo todo = getPersistentObject(Todo.class, idTodo);
            todoDAO.deleteTodo(todo);
          }
        }
      }
      approversDAO.deleteApproversByIdApproval(idApprovalList);
      approvalRejectionDAO.deleteApprovalRejectionByIdApproval(idApprovalList);
      approvalEventLinkDAO.deleteApprovalEventLinkByIdEvent(idEvent);
      approvalDAO.deleteApprovalByIdApproval(idApprovalList);
      eventDAO.deleteAppEventByIdApproval(idApprovalList);
    }

    // to delete to-do that has event id populated (some alerts, etc.)
    todoDAO.deleteTodoByIdTodoEvent(idEvent);

    // delete plan
    // spSafetyPlanDAO.deleteSpSafetyPlan(spSafetyPlan);
    spSafetyPlanDAO.deleteSpSafetyPlan(spSafetyPlan.getIdEvent(), spSafetyPlan.getDtLastUpdate());
    // delete event
    CCMN01UO ccmn01uo = callPostEvent(ServiceConstants.REQ_FUNC_CD_DELETE, safetyPlanSaveSI.getROWCCMN01UIG00());
    return 0;
  }
  
  @SuppressWarnings("unchecked")
  public int saveSafetyPlan(SafetyPlanSaveSI safetyPlanSaveSI) {

    int idCase = safetyPlanSaveSI.getUlIdCase();
    int idEvent = safetyPlanSaveSI.getUlIdEvent();
    int idStage = safetyPlanSaveSI.getUlIdStage();

    CCMN01UO ccmn01uo = new CCMN01UO();
    ROWCCMN01UIG00 safetyPlanEvent = safetyPlanSaveSI.getROWCCMN01UIG00();

    List deletedFactorList = safetyPlanSaveSI.getDeletedFactorList();

    String eventReqFuncCd = "";

    SpSafetyPlan spSafetyPlan = null;

    // set add or update mode
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      spSafetyPlan = getPersistentObject(SpSafetyPlan.class, idEvent);

    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;

      spSafetyPlan = new SpSafetyPlan();
    }

    // make sure stage is not closed
    checkStageEventStatus(eventReqFuncCd, idStage, CodesTables.CSTAGES_INV);

    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(safetyPlanSaveSI.getCdReqFuncCd())) {
      ccmn01uo = callPostEvent(eventReqFuncCd, safetyPlanEvent);
      // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
      idEvent = ccmn01uo.getUlIdEvent();
    }

    // Safety Plan

    if (idCase != 0) {
      CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
      spSafetyPlan.setCapsCase(capsCase);
    }

    Event event = null;
    if (idEvent != 0) {
      event = getPersistentObject(Event.class, idEvent);
      spSafetyPlan.setEvent(event);
    }

    spSafetyPlan.setDtDiscWithCrtkr(safetyPlanSaveSI.getDtDiscWithCrtkr());
    spSafetyPlan.setDtLastUpdate(safetyPlanSaveSI.getDtLastUpdate());
    spSafetyPlan.setIndCrtkrAgreesSp(safetyPlanSaveSI.getIndCrtkrAgreesSp());
    spSafetyPlanDAO.saveSpSafetyPlan(spSafetyPlan);

    SpSafetyFactors spSafetyFactors = null;
    List<SafetyFactorSO> safetyFactorList = safetyPlanSaveSI.getSafetyFactorList();
    Iterator safetyFactorIt = safetyFactorList.iterator();

    while (safetyFactorIt.hasNext()) {
      SafetyFactorSO safetyFactorSO = (SafetyFactorSO) safetyFactorIt.next();
      int idSftyFctr = safetyFactorSO.getIdSftyFctr();
      if (idSftyFctr != 0)

      {
        spSafetyFactors = getPersistentObject(SpSafetyFactors.class, idSftyFctr);
      } else {
        spSafetyFactors = new SpSafetyFactors();
      }

      spSafetyFactors.setIdSftyFctr(safetyFactorSO.getIdSftyFctr());
      spSafetyFactors.setDtCompltdBy(safetyFactorSO.getDtCompltdBy());
      spSafetyFactors.setDtLastUpdate(safetyFactorSO.getDtLastUpdate());
      spSafetyFactors.setEvent(event);
      spSafetyFactors.setNmFirstOthrResp(safetyFactorSO.getNmFirstOthrResp());
      spSafetyFactors.setNmLastOthrResp(safetyFactorSO.getNmLastOthrResp());
      spSafetyFactors.setNmMiddleOthrResp(safetyFactorSO.getNmMiddleOthrResp());
      spSafetyFactors.setTxtDescActions(safetyFactorSO.getSzTxtDescActions());
      spSafetyFactors.setTxtSftyFctrComments(safetyFactorSO.getSzTxtSftyFctrComments());
      spSafetyFactors.setTxtSftyFctrDesc(safetyFactorSO.getSzTxtSftyFctrDesc());
      spSafetyFactors.setTxtSftyFctrMitigate(safetyFactorSO.getSzTxtSftyFctrMitigate());
      spSafetyFactors.setSpSafetyPlan(spSafetyPlan);
      spSafetyFactorsDAO.saveSafetyFactor(spSafetyFactors);

      // Responsible person
      // Delete Persons Respnsbl
      if (safetyFactorSO.getIdSftyFctr() != 0) {
        spSafetyFactors = getPersistentObject(SpSafetyFactors.class, safetyFactorSO.getIdSftyFctr());
        spPersonsRespnsblDAO.deleteSpPersonsRespnsbl(spSafetyFactors.getIdSftyFctr());
      }

      List<PersonResonsibleSO> personsRespnsblList = safetyFactorSO.getPersonResonsibleList();

      if (personsRespnsblList != null) {
        Iterator personsRespnsblIt = personsRespnsblList.iterator();
        int idPerson = 0;

        while (personsRespnsblIt.hasNext()) {

          PersonResonsibleSO personResonsibleSO = (PersonResonsibleSO) personsRespnsblIt.next();

          idPerson = personResonsibleSO.getIdPerson();

          SpPersonsRespnsbl spPersonsRespnsbl = new SpPersonsRespnsbl();
          spPersonsRespnsbl.setIdSpPersRespnsbl(personResonsibleSO.getIdSpPersRespnsbl());

          if (idPerson != 0) {
            Person person = getPersistentObject(Person.class, idPerson);
            spPersonsRespnsbl.setPersonByIdPerson(person);
          }

          spPersonsRespnsbl.setSpSafetyFactorsByIdSftyFctr(spSafetyFactors);

          spPersonsRespnsblDAO.saveSpPersonsRespnsbl(spPersonsRespnsbl);
        }
      }
    }

    // Delete
    if (deletedFactorList != null) {
      Iterator deletedFactorListIt = deletedFactorList.iterator();
      Integer idFactor = null;
      while (deletedFactorListIt.hasNext()) {
        idFactor = (Integer) deletedFactorListIt.next();
        // Safety Factor
        // Delete Safety Factors
        if (idEvent != 0) {
          spPersonsRespnsblDAO.deleteSpPersonsRespnsbl(idFactor);
          spSafetyFactorsDAO.deleteSafetyFactor(idFactor);
        }
      }
    }
// if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(safetyPlanSaveSI.getCdReqFuncCd())) then delete plan and event here
    return idEvent;
  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {

    // rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdStage) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdStage);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

}
