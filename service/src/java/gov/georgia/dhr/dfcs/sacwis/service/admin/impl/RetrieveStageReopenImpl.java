package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageReopenDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopen;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveStageReopen;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageReopenRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageReopenRetrieveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *This class implements the retrieveStageReopen service to retrieve
 *database information from STAGE_REOPEN.
 *@author bhavna.gehlot
 */

/** Change History:
  *    Date      User      Description
  *  --------  --------  --------------------------------------------------------------
  *  09/17/2009  bgehlot STGAP00015395: Added code for displaying previous stage closure information
  *  11/09/2010  arege   SMS#77106: User should be able to reopen a stage if  a Legal Status of NAF for the child in the given case does not exist.
*/
public class RetrieveStageReopenImpl extends BaseServiceImpl implements RetrieveStageReopen {
  static final String SAFETY_RSRC_ASMNT_NARR = "SAFETY_RSRC_ASMNT_NARR";

  private StageReopenDAO stageReopenDAO = null;
  private PersonDAO personDAO = null;
  private StageLinkDAO stageLinkDAO = null;  
  private StagePersonLinkDAO stagePersonLinkDAO = null;  
  private LegalStatusDAO legalStatusDAO = null;
  private StageDAO stageDAO = null;
  private EventDAO eventDAO = null;
  private ApproversDAO approversDAO = null;

  public void setStageReopenDAO(StageReopenDAO stageReopenDAO) {
    this.stageReopenDAO = stageReopenDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO){
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  /*implements public method declared in interface file */          

  public StageReopenRetrieveSO retrieveStageReopen(StageReopenRetrieveSI stageReopenRetrieveSI)
  throws ServiceException
  {

    StageReopenRetrieveSO stageReopenRetrieveSO = new StageReopenRetrieveSO();
    int ulIdEvent = stageReopenRetrieveSI.getUlIdEvent();

    stageReopenRetrieveSO.setUlIdEvent(ulIdEvent);

    Event event = getPersistentObject(Event.class, ulIdEvent);

    StageReopen stageReopen = getPersistentObject(StageReopen.class, ulIdEvent);
    // If not new, get information from the existing event
    if (ulIdEvent != 0) {

      stageReopenRetrieveSO.setUlIdStage((event.getStage()).getIdStage().intValue());
      if(stageReopen != null){

        stageReopenRetrieveSO.setDtStageReopened(stageReopen.getDtStageReopen());

        Person personPerformedBy = getPersistentObject(Person.class, stageReopen.getPerformedByPerson().getIdPerson());
        stageReopenRetrieveSO.setIdPerformedBy(personPerformedBy != null ? personPerformedBy.getIdPerson() : 0);

        String szNmPerformedBy = "";
        String szNmRequestedBy = "";
        if(personPerformedBy != null){
          szNmPerformedBy = personDAO.findNmFullByIdPerson(personPerformedBy.getIdPerson());
        }
        stageReopenRetrieveSO.setSzNmPerformedBy(szNmPerformedBy);

        Person personRequestedBy = getPersistentObject(Person.class, stageReopen.getRequestedByPerson().getIdPerson());
        stageReopenRetrieveSO.setIdRequestedBy(personRequestedBy != null ? personRequestedBy.getIdPerson() : 0);

        if(personRequestedBy != null){
          szNmRequestedBy = personDAO.findNmFullByIdPerson(personRequestedBy.getIdPerson());
        }
        stageReopenRetrieveSO.setSzNmRequestedBy(szNmRequestedBy);
        
          stageReopenRetrieveSO.setSzTxtStageReopenCmnts(stageReopen.getTxtJustificationComment());
      }
      
      stageReopenRetrieveSO.setCdEventStatus(event.getCdEventStatus());
      stageReopenRetrieveSO.setDtLastUpdate(event.getDtLastUpdate());
      
      //Get the previous stage closure information from Stage Reopen table when user comes from Event Search page
      // to see the Reopen Stage event
      stageReopenRetrieveSO = getPreviousStageClosureInfoFromStageReopenEvent(stageReopenRetrieveSI, stageReopenRetrieveSO);
    } else{
      Person personPerformedBy = getPersistentObject(Person.class, stageReopenRetrieveSI.getUlIdUser());
      stageReopenRetrieveSO.setIdPerformedBy(personPerformedBy != null ? personPerformedBy.getIdPerson() : 0);

      String szNmPerformedBy = "";
      if(personPerformedBy != null){
        szNmPerformedBy = personDAO.findNmFullByIdPerson(personPerformedBy.getIdPerson());
      }
      stageReopenRetrieveSO.setSzNmPerformedBy(szNmPerformedBy);

      stageReopenRetrieveSO.setDtStageReopened(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
      
      //Get the previous stage closure information from stage table when user is reopening the stage by clicking on
      //Reopen Stage button on Case Summary Page
      stageReopenRetrieveSO = getPreviousStageClosureInfo(stageReopenRetrieveSI, stageReopenRetrieveSO);
    }
   
    //Get the check boxes response
    List<String> checkedcheckboxesList = new ArrayList<String>();
    checkedcheckboxesList = stageReopenDAO.findCheckboxbyIdEvent(ulIdEvent);
    Iterator<String> itCheckedcheckboxesList = checkedcheckboxesList.iterator();
    String[] checkedCheckboxes = new String[checkedcheckboxesList.size()];      

    if (checkedcheckboxesList != null && !checkedcheckboxesList.isEmpty()) {
      for (int i = 0; itCheckedcheckboxesList.hasNext(); i++) {
        String cb1 = (String) itCheckedcheckboxesList.next();
        checkedCheckboxes[i] = cb1;          
      }
    }

    stageReopenRetrieveSO.setCheckedCheckboxes(checkedCheckboxes);
    
    checkIfStageCanBeReopened(stageReopenRetrieveSI, stageReopenRetrieveSO);

    return stageReopenRetrieveSO;
  }

  private void checkIfStageCanBeReopened(StageReopenRetrieveSI stageReopenRetrieveSI, StageReopenRetrieveSO stageReopenRetrieveSO){

    Stage stage = getPersistentObject(Stage.class, stageReopenRetrieveSI.getUlIdStage());
    String cdStage = stage.getCdStage();
    int idCase = stage.getCapsCase().getIdCase();
    Map legalStatus = null;
    // STGAP00014341-Check for ADO Stage Closure with reason "Adoption Finalized" with close indicator of Y
    // then set the sealed indicator as Y
    if(CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_SUB.equals(cdStage)){
      Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonForChildByIdStage(stageReopenRetrieveSI.getUlIdStage());
      
      List<String> cdStages = new ArrayList<String>();
      cdStages.add(CodesTables.CSTAGES_ADO);
      cdStages.add(CodesTables.CSTAGES_SUB);
      cdStages.add(CodesTables.CSTAGES_INV);
      cdStages.add(CodesTables.CSTAGES_PAD);

      // Check if there exists a Legal Status of NAF for the child in the given case.
      if(idPrimaryChild != null){
        int idPrimaryChildInt = idPrimaryChild.intValue();
        legalStatus = legalStatusDAO.findLegalStatusByIdCaseByIdPersonByCdStatusByCdStages(idCase, idPrimaryChildInt, CodesTables.CLEGSTAT_NAF, cdStages);
      }
    }

    // STGAP00014341-Check for FCC Stage Closure with reason "Adoption Finalized" with close indicator of Y
    // then set the sealed indicator as Y
    if(CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)){
      if (legalStatus == null && ArchitectureConstants.Y.equals(stage.getIndStageClose()) && stage.getDtStageClose() != null) {
        stageReopenRetrieveSO.setBIndStageReopen(ArchitectureConstants.Y);
      } else {
        stageReopenRetrieveSO.setBIndStageReopen(ArchitectureConstants.N);
      }
    }

    //STGAP00014341: Check for if the DIV has been progressed to INV if it is then it cannot be reopened
    if(CodesTables.CSTAGES_DIV.equals(cdStage) && ArchitectureConstants.Y.equals(stage.getIndStageClose()) && stage.getDtStageClose() != null){
      Stage stageNew = stageLinkDAO.findNewIdStageByIdPriorStage( stageReopenRetrieveSI.getUlIdStage());
      if(stageNew != null && CodesTables.CSTAGES_INV.equals(stageNew.getCdStage())){
        stageReopenRetrieveSO.setBIndStageReopen(ArchitectureConstants.N);
      }else{
        stageReopenRetrieveSO.setBIndStageReopen(ArchitectureConstants.Y);
      }

    }

    // STGAP00014341-Check if the stages are INT, INV, FAD, ARI. These stages cannot be reopened
    if (CodesTables.CSTAGES_INT.equals(cdStage) || CodesTables.CSTAGES_INV.equals(cdStage) || CodesTables.CSTAGES_FAD.equals(cdStage)
                    || CodesTables.CSTAGES_ARI.equals(cdStage)) {
      stageReopenRetrieveSO.setBIndStageReopen(ArchitectureConstants.N);
    } 

    // STGAP00014341- If the dtStageClose is null stages cannot be reopened as they are already open
    if (stage.getDtStageClose() == null) {
      stageReopenRetrieveSO.setBIndStageReopen(ArchitectureConstants.N);
    } 
  }
  
  /**
   * This method gets the previous stage closure information from stage table when user is reopening the stage by clicking on
   * Reopen Stage button on Case Summary Page
   * @param stageReopenRetrieveSI
   * @param stageReopenRetrieveSO
   * @return
   */
  private StageReopenRetrieveSO getPreviousStageClosureInfo(StageReopenRetrieveSI stageReopenRetrieveSI, StageReopenRetrieveSO stageReopenRetrieveSO){
    String cdTask = "";
    String cdApprovalTask = "";
    Person approverPerson = null;
    Date dtApproval = null;
    String txtApproversComments = "";
    String nmApprover = "";
    
    Stage stage = stageDAO.findStageByIdStage(stageReopenRetrieveSI.getUlIdStage());
    
    String cdStage = stage.getCdStage();
    String stageType = stage.getCdStageType();
    
    String reasonCodesTable = getReasonsCodesTable(stageType,cdStage);
    
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
    
    if(stage != null){
      stageReopenRetrieveSO.setDtStageClosure(stage.getDtStageClose());
      stageReopenRetrieveSO.setSzClosureReason(Lookup.simpleDecodeSafe(reasonCodesTable, stage.getCdStageReasonClosed()));
      if(!CodesTables.CSTAGES_DIV.equals(stage.getCdStage())){
        stageReopenRetrieveSO.setTxtClosureComments(stage.getTxtStageClosureCmnts());
      }else{
        stageReopenRetrieveSO.setTxtClosureComments("");
      }
    }

  //get the approval data and set it into stageReopen
    Event stageClosureEvent = new Event();
    //For DIV the closure event is DIV and for others its CCL
    if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      stageClosureEvent = eventDAO.findEventByIdStageAndEventTypeAndTask(stageReopenRetrieveSI.getUlIdStage(), CodesTables.CEVNTTYP_DIV, cdTask);
    }else{
      stageClosureEvent = eventDAO.findEventByIdStageAndEventTypeAndTask(stageReopenRetrieveSI.getUlIdStage(), CodesTables.CEVNTTYP_CCL, cdTask);
    }
    if(stageClosureEvent != null){
      //get the approval data and set it into stageReopen
      Event stageClosureApprovalEvent = eventDAO.findEventByIdStageAndEventTypeAndTask(stageReopenRetrieveSI.getUlIdStage(), CodesTables.CEVNTTYP_APP, cdApprovalTask);
      if(stageClosureApprovalEvent != null){
        Approvers approver = new Approvers();
        //For these stages get the approvers using idEvent
        approver = approversDAO.findApproverByIdEventForFSUSUBFPR(stageClosureApprovalEvent.getIdEvent());
        //Get the approver data
        if(approver != null){
          approverPerson = approver.getPerson() != null ? approver.getPerson(): null;
          nmApprover = approverPerson.getNmPersonFull();
          dtApproval = approver.getDtApproversDetermination();
          txtApproversComments = approver.getTxtApproversCmnts();
        }
      }
    }
    if(approverPerson != null){
      stageReopenRetrieveSO.setNmApprover(nmApprover);
    }
    stageReopenRetrieveSO.setDtApproval(dtApproval);
    stageReopenRetrieveSO.setTxtApproversComments(txtApproversComments);
    
    return stageReopenRetrieveSO;
  }
  
  /**
   * This method  gets the previous stage closure information from Stage Reopen table when user comes from Event Search page
   * to see the Reopen Stage event
   * @param stageReopenRetrieveSI
   * @param stageReopenRetrieveSO
   * @return
   */
  private StageReopenRetrieveSO getPreviousStageClosureInfoFromStageReopenEvent(StageReopenRetrieveSI stageReopenRetrieveSI, StageReopenRetrieveSO stageReopenRetrieveSO){
    Stage stage = stageDAO.findStageByIdStage(stageReopenRetrieveSI.getUlIdStage());

    String cdStage = stage.getCdStage();
    String stageType = stage.getCdStageType();

    String reasonCodesTable = getReasonsCodesTable(stageType,cdStage);

    StageReopen stageReopen = stageReopenDAO.findStageReopenByIdEvent(stageReopenRetrieveSI.getUlIdEvent());
    if(stageReopen != null){
      stageReopenRetrieveSO.setSzClosureReason(Lookup.simpleDecodeSafe(reasonCodesTable, stageReopen.getCdStageReasonClosed()));
      stageReopenRetrieveSO.setTxtClosureComments(stageReopen.getTxtStageClosureCmnts());
      stageReopenRetrieveSO.setDtStageClosure(stageReopen.getDtStageClose());
      Person approver = stageReopen.getApprover();
      String nmApprover = "";
      if(approver != null){
        nmApprover = approver.getNmPersonFull();
      }
      stageReopenRetrieveSO.setNmApprover(nmApprover);
      stageReopenRetrieveSO.setDtApproval(stageReopen.getDtApprovalDate());
      stageReopenRetrieveSO.setTxtApproversComments(stageReopen.getTxtApproversCmnts());
    }
    return stageReopenRetrieveSO;
  }
  
  /**
   * This helper method takes in the Stage code to determines the Task Code and returns it. 
   * 
   * @param testCdStage
   *          String
   * @return taskCode
   */
  private String getTaskCode(String testCdStage) {
    String taskCode = StringHelper.EMPTY_STRING;
    //Set the task code depending on the current stage
    if (StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_SUB)){
      taskCode = SUB_TASK_CODE;
    } else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_FSU)){
      taskCode = FSU_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_ADO)){
      taskCode = ADO_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_PAD)){
      taskCode = PAD_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_DIV)){
      taskCode = DIV_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_FPR)){
      taskCode = FPR_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_PFC)){
      taskCode = PFC_TASK_CODE;
    }
    return taskCode;
  }
  
  /**
   * This method returns the Closure Reason codes table for the stage
   * @param stageType
   * @param cdStage
   * @return
   */
  private String getReasonsCodesTable(String stageType, String cdStage){
    // Codes table for Reason.
    String reasonCodesTable = StringHelper.EMPTY_STRING;  

    if ((stageType.startsWith("C-")) && !(CodesTables.CSTAGES_PAD.equals(cdStage)))
    {
      reasonCodesTable =  CodesTables.CCLOSCRS;
    }
    else if(CodesTables.CSTAGES_FSU.equals(cdStage)){
      reasonCodesTable = CodesTables.CCLOSFCF; // FSU (Foster Care Child) reasons
    }
    else if(CodesTables.CSTAGES_SUB.equals(cdStage)){
      reasonCodesTable = CodesTables.CCLOSFCC; // SUB (Foster Care Family) reasons
    }
    else if(CodesTables.CSTAGES_PAD.equals(cdStage)){
      reasonCodesTable = CodesTables.CCLOSPAD; // PAD (Post Adoption) reasons
    }
    else if(CodesTables.CSTAGES_ADO.equals(cdStage)){
      reasonCodesTable = CodesTables.CCLOSADO; // ADO (Adoption) reasons
    }
    else if(CodesTables.CSTAGES_PFC.equals(cdStage)){
      reasonCodesTable = CodesTables.CCLOSPFC; // PFC (Post Foster Care Services) reasons
    }
    else if(CodesTables.CSTAGES_FPR.equals(cdStage)){
      reasonCodesTable = CodesTables.CCLOSONG; // FPR (CPS On Going) reasons 
    }  
    else if(CodesTables.CSTAGES_DIV.equals(cdStage)){
      reasonCodesTable = CodesTables.CDIVDSPN; // DIV (Diversion Closure) reasons
    }
    return reasonCodesTable;
  }
}
