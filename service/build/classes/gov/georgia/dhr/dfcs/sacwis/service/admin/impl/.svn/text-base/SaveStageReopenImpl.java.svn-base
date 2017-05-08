package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageReopenDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopen;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopenCbx;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStageReopen;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageReopenSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenSaveSO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------    --------  --------------------------------------------------   
 *  11/18/2009  arege     SMS#38675: Used new method to delete Approval rejections for the SUB stage and task to resolve constraint violation exception.
 *
 * </pre>
 */
public class SaveStageReopenImpl extends BaseServiceImpl implements SaveStageReopen {

  private PostEvent postEvent = null;
  private StageReopenDAO stageReopenDAO = null;
  private EventDAO eventDAO = null;
  private ApproversDAO approversDAO = null;
  private TodoDAO todoDAO = null;
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private ApprovalRejectionDAO approvalRejectionDAO = null;
  private ApprovalDAO approvalDAO = null;
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private CapsCaseDAO capsCaseDAO = null;

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageReopenDAO(StageReopenDAO stageReopenDAO) {
    this.stageReopenDAO = stageReopenDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApprovalRejectionDAO(ApprovalRejectionDAO approvalRejectionDAO) {
    this.approvalRejectionDAO = approvalRejectionDAO;
  }

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }


  public StageReopenSaveSO saveStageReopen(StageReopenSaveSI stageReopenSaveSI) throws ServiceException {
    int ulIdEvent = stageReopenSaveSI.getUlIdEvent();
    String actionCode = "";
    StageReopen stageReopen;
    StageReopenSaveSO stageReopenSaveSO = new StageReopenSaveSO();

    //this is a new Stage Reopen and we need to add EVENT 
    actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    CCMN01UO ccmn01uo = callPostEvent(stageReopenSaveSI, actionCode);

    ulIdEvent = ccmn01uo.getUlIdEvent();

    Event event = getPersistentObject(Event.class, ulIdEvent);

    stageReopen = new StageReopen();

    stageReopen.setIdEvent(ulIdEvent);

    stageReopen.setEvent(event);

    //Set the data from Stage Reopen Page into stageReopen
    stageReopen.setDtStageReopen(stageReopenSaveSI.getDtStageReopened());

    Person personPerformedBy = getPersistentObject(Person.class, stageReopenSaveSI.getIdPerformedBy());
    stageReopen.setPerformedByPerson(personPerformedBy);

    Person personRequestedBy = getPersistentObject(Person.class, stageReopenSaveSI.getIdRequestedBy());
    stageReopen.setRequestedByPerson(personRequestedBy);

    stageReopen.setTxtJustificationComment(stageReopenSaveSI.getSzTxtStageReopenCmnts());

    String cdTask = "";
    String cdApprovalTask = "";
    Date dtStageClose = null;
    String cdStageReasonClosed = "";
    String txtStageClosureComments = "";
    Person approverPerson = null;
    Date dtApproval = null;
    String txtApproversComments = "";
    int idClosedEvent = 0;

    //Get the stage closure data and set it into stageReopen
    Stage stage = getPersistentObject(Stage.class, stageReopenSaveSI.getUlIdStage());

    if(stage != null){
      dtStageClose = stage.getDtStageClose();
      cdStageReasonClosed = stage.getCdStageReasonClosed();
      txtStageClosureComments = stage.getTxtStageClosureCmnts();
    }

    stageReopen.setDtStageClose(dtStageClose);
    stageReopen.setCdStageReasonClosed(cdStageReasonClosed);
    if(!CodesTables.CSTAGES_DIV.equals(stage.getCdStage())){
      stageReopen.setTxtStageClosureCmnts(txtStageClosureComments);
    }else{
      stageReopen.setTxtStageClosureCmnts("");
    }

    String cdStage = stage.getCdStage();

    //Set the tasks Approval and closure
    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      cdTask = DIV_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = DIV_APPROVAL_TASK_CODE;
    }else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      cdTask = FPR_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = FPR_APPROVAL_TASK_CODE;
    }else if(CodesTables.CSTAGES_SUB.equals(cdStage)){
      cdTask = SUB_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = SUB_APPROVAL_TASK_CODE;
    }else if(CodesTables.CSTAGES_ADO.equals(cdStage)){
      cdTask = ADO_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = ADO_APPROVAL_TASK_CODE;
    }else if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      cdTask = FSU_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = FSU_APPROVAL_TASK_CODE;
    }else if(CodesTables.CSTAGES_PFC.equals(cdStage)){
      cdTask = PFC_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = PFC_APPROVAL_TASK_CODE;
    }else if(CodesTables.CSTAGES_PAD.equals(cdStage)){
      cdTask = PAD_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = PAD_APPROVAL_TASK_CODE;
    }

    //get the approval data and set it into stageReopen
    Event stageClosureEvent = new Event();
    //For DIV the closure event is DIV and for others its CCL
    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      stageClosureEvent = eventDAO.findEventByIdStageAndEventTypeAndTask(stageReopenSaveSI.getUlIdStage(), CodesTables.CEVNTTYP_DIV, cdTask);
    }else{
      stageClosureEvent = eventDAO.findEventByIdStageAndEventTypeAndTask(stageReopenSaveSI.getUlIdStage(), CodesTables.CEVNTTYP_CCL, cdTask);
    }
    if(stageClosureEvent != null){
      idClosedEvent = stageClosureEvent.getIdEvent();
      //get the approval data and set it into stageReopen
      Event stageClosureApprovalEvent = eventDAO.findEventByIdStageAndEventTypeAndTask(stageReopenSaveSI.getUlIdStage(), CodesTables.CEVNTTYP_APP, cdApprovalTask);
      if(stageClosureApprovalEvent != null){
        Approvers approver = new Approvers();
        //For these stages get the approvers using idEvent
        approver = approversDAO.findApproverByIdEventForFSUSUBFPR(stageClosureApprovalEvent.getIdEvent());
        //Get the approver data
        if(approver != null){
          approverPerson = approver.getPerson() != null ? approver.getPerson(): null;
          dtApproval = approver.getDtApproversDetermination();
          txtApproversComments = approver.getTxtApproversCmnts();
        }
      }
    }
    if(approverPerson != null){
      stageReopen.setApprover(approverPerson);
    }
    stageReopen.setDtApprovalDate(dtApproval);
    stageReopen.setTxtApproversCmnts(txtApproversComments);

    //regardless of event, at this point we can call saveOrUpdate
    stageReopenDAO.saveOrUpdateStageReopen(stageReopen);

    // delete current check boxes for that question
    stageReopenDAO.deleteStageReopenCbxByIdEvent(ulIdEvent);

    List<String> checkedCheckboxesList = new ArrayList<String>();
    checkedCheckboxesList = Arrays.asList(stageReopenSaveSI.getCheckedCheckboxes());      
    Iterator<String> itCheckedCheckboxes = checkedCheckboxesList.iterator();

    // add newly selected check boxes for the question
    while (itCheckedCheckboxes.hasNext()) {
      StageReopenCbx stageReopenCbx = new StageReopenCbx();
      stageReopenCbx.setEvent(event);
      stageReopenCbx.setCdCbx(itCheckedCheckboxes.next().toString());
      stageReopenDAO.saveStageReopenCbx(stageReopenCbx);
    }

    openClosedStage(stageReopenSaveSI, idClosedEvent);


    stageReopenSaveSO.setUlIdEvent(ulIdEvent);

    return stageReopenSaveSO;
  }

  /**
   * This private method calls postEvent to create a new event if this is a new Stage Reopen
   *
   * @param stageReopenSaveSI
   * @param actionCode
   * @return CCMN01UO
   * @throws ServiceException
   */
  private CCMN01UO callPostEvent(StageReopenSaveSI stageReopenSaveSI, String actionCode) 
  throws ServiceException {

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = "";

    Stage stage = getPersistentObject(Stage.class, stageReopenSaveSI.getUlIdStage());
    String cdStage = stage.getCdStage();
    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      desc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_DIV);
    }else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      desc = "Ongoing";
    }else if(CodesTables.CSTAGES_SUB.equals(cdStage)){
      desc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_SUB);
    }else if(CodesTables.CSTAGES_ADO.equals(cdStage)){
      desc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_ADO);
    }else if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      desc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU);
    }else if(CodesTables.CSTAGES_PFC.equals(cdStage)){
      desc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_PFC);
    }else if(CodesTables.CSTAGES_PAD.equals(cdStage)){
      desc = Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_PAD);
    }

    desc = desc  + " Stage has been reopened";    

    int idEvent = stageReopenSaveSI.getUlIdEvent();

    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    rowccmn01uig00.setSzCdTask(stageReopenSaveSI.getCdTask());
    rowccmn01uig00.setSzCdEventStatus(stageReopenSaveSI.getSzEventStatus());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CRP);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(stageReopenSaveSI.getCdTask());
    rowccmn01uig00.setUlIdStage(stageReopenSaveSI.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(stageReopenSaveSI.getUlIdPerson());
    rowccmn01uig00.setUlIdStage(stageReopenSaveSI.getUlIdStage());   
    rowccmn01uig00.setUlIdEvent(stageReopenSaveSI.getUlIdEvent());
    rowccmn01uig00.setTsLastUpdate(stageReopenSaveSI.getDtLastUpdate());

    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();   
    archInputStruct.setCReqFuncCd(actionCode);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);


    return postEvent.postEvent(ccmn01ui);
  }

  private void openClosedStage(StageReopenSaveSI stageReopenSaveSI, int idClosedEvent) throws ServiceException{
    String cdStageClosureTask = "";
    String cdApprovalTask = "";
    Stage stage = getPersistentObject(Stage.class, stageReopenSaveSI.getUlIdStage());
    String cdStage = stage.getCdStage();
    int idStage = stage.getIdStage();
    String txtEventDescrSTG = "";
    String txtEventDescrCAS = "Case Closed";

    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      cdStageClosureTask = DIV_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = DIV_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "Diversion Stage Closed";
    }else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      cdStageClosureTask = FPR_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = FPR_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "CPS Ongoing Stage Closed";
    }else if(CodesTables.CSTAGES_SUB.equals(cdStage)){
      cdStageClosureTask = SUB_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = SUB_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "Foster Care Child Stage Closed";
    }else if(CodesTables.CSTAGES_ADO.equals(cdStage)){
      cdStageClosureTask = ADO_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = ADO_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "Adoption Stage Closed";
    }else if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      cdStageClosureTask = FSU_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = FSU_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "Foster Care Family Stage Closed";
    }else if(CodesTables.CSTAGES_PFC.equals(cdStage)){
      cdStageClosureTask = PFC_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = PFC_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "Post Foster Care Stage Closed";
    }else if(CodesTables.CSTAGES_PAD.equals(cdStage)){
      cdStageClosureTask = PAD_STAGE_CLOSURE_TASK_CODE;
      cdApprovalTask = PAD_APPROVAL_TASK_CODE;
      txtEventDescrSTG = "Post Adoption Stage Closed";
    }

    //Delete the Approvers
    approversDAO.deleteApproversByIdStageCdTask(idStage, cdApprovalTask);
    
    // SMS#38675: For the following stages approvalRejection record should be deleted before approvalEventLink record.
    if (CodesTables.CSTAGES_FSU.equals(cdStage) || CodesTables.CSTAGES_DIV.equals(cdStage)
        || CodesTables.CSTAGES_FPR.equals(cdStage) || CodesTables.CSTAGES_PFC.equals(cdStage)
        || CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_PAD.equals(cdStage)) {
      if (CodesTables.CSTAGES_FSU.equals(cdStage) || CodesTables.CSTAGES_FPR.equals(cdStage)) {
        // SMS#38675: Delete Approval rejections for by stage and task directly using id_event from event table.
        approvalRejectionDAO.deleteApprovalRejections(idStage, cdApprovalTask);
      } else {
       // This method uses approval_event_link to get id_Event
        approvalRejectionDAO.deleteApprovalRejectionsByIdStageCdTask(idStage, cdApprovalTask);
      }
    }
    
    //If DIV delete from APPROVER_EVENT_LINK table for DIV event Type also along with APP
    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      approvalEventLinkDAO.deleteApprovalEventLinkByIdStageCdTask(idStage, CodesTables.CEVNTTYP_APP, cdApprovalTask);
      approvalEventLinkDAO.deleteApprovalEventLinkByIdStageCdTask(idStage, CodesTables.CEVNTTYP_DIV, DIV_STAGE_CLOSURE_TASK_CODE);
    }else{
      approvalEventLinkDAO.deleteApprovalEventLinkByIdStageCdTask(idStage, CodesTables.CEVNTTYP_APP, cdApprovalTask);
    }
    
    approversDAO.deleteApprovers(idStage, cdApprovalTask);
    
    //Delete the Approval Rejections
    if(CodesTables.CSTAGES_SUB.equals(cdStage)){
    	//SMS#38675: Delete Approval rejections for the SUB stage and task
    	approvalRejectionDAO.deleteApprovalRejections(idStage, cdApprovalTask);
    }
    
    //For these stages delete Approvals without using APPROVERS_EVENT_LINK table
    if(CodesTables.CSTAGES_FSU.equals(cdStage) || CodesTables.CSTAGES_SUB.equals(cdStage) ||CodesTables.CSTAGES_FPR.equals(cdStage)){
      approvalDAO.deleteApprovals(idStage, cdApprovalTask);
    }else{
      approvalDAO.deleteApprovalsByIdStageCdTask(idStage, cdApprovalTask);
    }
    
    //Delete the ToDo 
    todoDAO.deleteTodoByIdTodoStageCdTask(idStage, cdApprovalTask);
    //Delete the approval event
    eventDAO.deleteEvent(idStage, cdApprovalTask);
    //Delete the STG event
    eventDAO.deleteEventByStageDesc(idStage, txtEventDescrSTG, CodesTables.CEVNTTYP_STG);
    //Delete the CAS event
    eventDAO.deleteEventByStageDesc(idStage, txtEventDescrCAS, CodesTables.CEVNTTYP_CAS);

    //If DIV update the DIV event type to COMP else update CCL event type to COMP
    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      eventDAO.updateEventByStageTaskType(idStage, cdStageClosureTask, CodesTables.CEVNTTYP_DIV);
    }else{
      eventDAO.updateEventByStageTaskType(idStage, cdStageClosureTask, CodesTables.CEVNTTYP_CCL);
    }
    // Set the these stage data to null
    stage.setDtStageClose(null);
    stage.setCdStageReasonClosed(null);
    stage.setIndStageClose(null);    

    stageDAO.saveOrUpdateStage(stage);  

    //Get the history person to whom stage was assigned.
    int idPerson = 0;
    StagePersonLink stagePersonLink = stagePersonLinkDAO.findIdPersonByIdStageCdStagePersRole(idStage);
    if(stagePersonLink != null){
      idPerson = stagePersonLink.getPerson() != null ? stagePersonLink.getPerson().getIdPerson() : 0;
    }
    //Delete that person
    stagePersonLinkDAO.deleteStagePersonLinkByIdPersonIdStage(idPerson, idStage);

    //Assign the atge to the hnew person who performed the Stage Reopen
    int idPersonNew = stageReopenSaveSI.getUlIdPerson();
    assignStage(stageReopenSaveSI.getUlIdCase(), stageReopenSaveSI.getUlIdStage(), idPersonNew);

    // If case is closed open the case
    Date dtCaseClosed = null;
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(stageReopenSaveSI.getUlIdCase());
    if(capsCase != null){
      dtCaseClosed = capsCase.getDtCaseClosed();
    }
    if(dtCaseClosed != null){
      capsCase.setDtCaseClosed(null);
      capsCaseDAO.saveCapsCase(capsCase);
    }    
  }

  private void assignStage(int idNewCase, int idNewStage, int idPerson) {
    String persRole = CodesTables.CSTFROLS_PR;
    String persType = CodesTables.CPRSNALL_STF;
    stagePersonLinkDAO.insertNewStagePersonLink(idNewStage, idPerson, idNewCase, persRole, persType, new Date());
  }

}
