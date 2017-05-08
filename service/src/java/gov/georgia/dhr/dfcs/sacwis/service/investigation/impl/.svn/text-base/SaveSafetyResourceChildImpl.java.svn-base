package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveSafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourcePersonBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildErrorBean;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;

/**
 *This class implements the saveSafteyResourceChild service to save records to
 *SAFETY_RESOURCE_CHILD.  Service handles either multiple children on an add or a 
 *single record on updates.  The service will also validate overlapping safety
 *resource placements or removals to open FCC or ADO stages before performing save.
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  PCOOGAN           Creation per Safety Resource enhancement MR-008.
 * 06/23/2009 bgehlot          STGAP00014328: Adding the alert
 * 06/23/2011 htvo             SMS#113076: add shorten short desc and long desc for FTM alerts
 * </pre>
 */

public class SaveSafetyResourceChildImpl extends BaseServiceImpl implements SaveSafetyResourceChild {

  private static final int MSG_SRP_OVERLAP_1 = 60431;
  private static final int MSG_SRP_OVERLAP_2 = 60432;
  private static final int MSG_SRP_CUSTODY_REMOVAL = 60434;
  private static final String EVENT_STATUS_PROC = "PROC";
  private static final String EVENT_STATUS_COMP = "COMP";
  
  
  private SafetyResourceChildDAO safetyResourceChildDAO = null;
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  private EventDAO eventDAO = null;
  private EmployeeDAO employeeDAO = null;
  private TodoDAO todoDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonDAO personDAO = null;
  
  private ComplexTodoDAO complexTodoDAO = null;

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }
  
  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }
    
  /*Implements public method defined in interface file */
  
  public SafetyResourceChildSaveSO saveSafetyResourceChild(SafetyResourceChildSaveSI safetyResourceChildSaveSI)
          throws ServiceException {

    int ulIdEvent = safetyResourceChildSaveSI.getUlIdEvent();
    //Check for overlapping safety resource placements or removals for all children being saved
    SafetyResourceChildSaveSO safetyResourceChildSaveSO = validateSafetyResourcePlacement(safetyResourceChildSaveSI);
  
    //Save only if no errors.  If errors, the errors will be returned to conversation without save
    if (safetyResourceChildSaveSO.getSafetyResourceChildList().isEmpty()){
      
      saveSafetyResourceChildRecords(safetyResourceChildSaveSI);
      updateSrEvent(ulIdEvent);
      //STGAP00014328: Create an alert when the safety resource child record is created.  
      if(safetyResourceChildSaveSI.getUlIdSrChild() == 0){
        saveAlert(safetyResourceChildSaveSI, ulIdEvent);
      }  
    }
  
    return safetyResourceChildSaveSO;
  }

  
  /**
   * This private method checks overlapping safety resource placements and checks for
   * open Custody removals for all children being saved.  If any errors are found, they
   * are added to the error list return object for presentation by the conversation.
   * 
   * @param safetyResourceChildSaveSI
   * @return SafetyResourceChildSaveSO
   * @throws ServiceException
   */
  private SafetyResourceChildSaveSO validateSafetyResourcePlacement 
      (SafetyResourceChildSaveSI safetyResourceChildSaveSI) throws ServiceException{
    
    SafetyResourceChildSaveSO safetyResourceChildSaveSO = new SafetyResourceChildSaveSO();
    List<SafetyResourceChildErrorBean> errorList = new ArrayList<SafetyResourceChildErrorBean>();
    List <SafetyResourcePersonBean> safetyResourceChildList = safetyResourceChildSaveSI.getSafetyResourceChildList();
    int ulIdSrChild = safetyResourceChildSaveSI.getUlIdSrChild();
    Date dtStart = safetyResourceChildSaveSI.getDtStart();
    Date dtEnd = safetyResourceChildSaveSI.getDtEnd();
    
    if (dtEnd == null) {
      
      dtEnd = DateHelper.MAX_JAVA_DATE;
      
    }
    
    // For each child being saved, check for overlaps on left, right, and for custody removals
    for (Iterator <SafetyResourcePersonBean> it = safetyResourceChildList.iterator(); it.hasNext();) {      

      SafetyResourcePersonBean safetyResourceChildBean = it.next();
      int ulIdChild = safetyResourceChildBean.getUlIdChild();
      
      List <Integer> rightList = safetyResourceChildDAO.findOverlapRightForChild(ulIdChild, 
                                                                                 dtEnd, ulIdSrChild);
      
      if (!rightList.isEmpty()){
        
        SafetyResourceChildErrorBean safetyResourceChildErrorBean = new SafetyResourceChildErrorBean();
        safetyResourceChildErrorBean.setnmChildFull(safetyResourceChildBean.getNmChildFull());
        safetyResourceChildErrorBean.setUlIdMessage(MSG_SRP_OVERLAP_2);
        errorList.add(safetyResourceChildErrorBean);
        
      } else 
      {
        List <Integer> leftList = safetyResourceChildDAO.findOverlapLeftForChild(ulIdChild, 
                                  dtStart, dtEnd, ulIdSrChild);
        
        if(!leftList.isEmpty()){
          
          SafetyResourceChildErrorBean safetyResourceChildErrorBean = new SafetyResourceChildErrorBean();
          safetyResourceChildErrorBean.setnmChildFull(safetyResourceChildBean.getNmChildFull());
          safetyResourceChildErrorBean.setUlIdMessage(MSG_SRP_OVERLAP_1);
          errorList.add(safetyResourceChildErrorBean);
          
        } else
        {
          List <Integer> custodyList = cnsrvtrshpRemovalDAO.findOpenRemovalsAfterDate(ulIdChild, dtEnd);
          
          if(!custodyList.isEmpty()){
            
            SafetyResourceChildErrorBean safetyResourceChildErrorBean = new SafetyResourceChildErrorBean();
            safetyResourceChildErrorBean.setnmChildFull(safetyResourceChildBean.getNmChildFull());
            safetyResourceChildErrorBean.setUlIdMessage(MSG_SRP_CUSTODY_REMOVAL);
            errorList.add(safetyResourceChildErrorBean);  
          }
        } 
      }
    }
  
    safetyResourceChildSaveSO.setSafetyResourceChildList(errorList);
    
    return safetyResourceChildSaveSO;
  }
    
  /**
   * This private method saves to SAFETY_RESOURCE_CHILD for all children in the SI object.
   * 
   * @param safetyResourceChildSaveSI
   * @return 
   * @throws ServiceException
   */
  private void saveSafetyResourceChildRecords
              (SafetyResourceChildSaveSI safetyResourceChildSaveSI) throws ServiceException{
    
    List <SafetyResourcePersonBean> safetyResourceChildList = safetyResourceChildSaveSI.getSafetyResourceChildList();
    int ulIdSrChild = safetyResourceChildSaveSI.getUlIdSrChild();
    int ulIdEvent = safetyResourceChildSaveSI.getUlIdEvent();
    Date dtStart = safetyResourceChildSaveSI.getDtStart();
    Date dtEnd = safetyResourceChildSaveSI.getDtEnd();
    String cdPrimaryRelationship = safetyResourceChildSaveSI.getCdRelationshipPrimary();
    String cdSecondaryRelationship = safetyResourceChildSaveSI.getCdRelationshipSecondary();
    
    //Iterate through each child being saved; will always be 1 for updates, but may be many for insert
    for (Iterator <SafetyResourcePersonBean> it = safetyResourceChildList.iterator(); it.hasNext();) {      

      SafetyResourcePersonBean safetyResourceChildBean = it.next();
      int ulIdChild = safetyResourceChildBean.getUlIdChild();
      int returned = 0;
      
      //Get safetyResource bean to set into safteyResoruceChild bean for save
      SafetyResource safetyResource = getPersistentObject(SafetyResource.class, ulIdEvent);
      SafetyResourceChild safetyResourceChild;
      
      // If new, create a new row.  Otherwise get existing row and perform update
      if (ulIdSrChild == 0)
      {
         safetyResourceChild = new SafetyResourceChild();
         safetyResourceChild.setIdSrChild(ulIdSrChild);
      } else 
      {  
        safetyResourceChild =  getPersistentObject(SafetyResourceChild.class, ulIdSrChild);     
      }
       
      safetyResourceChild.setCdRelPrimary(cdPrimaryRelationship);
      safetyResourceChild.setCdRelSecondary(cdSecondaryRelationship );
      safetyResourceChild.setDtStart(dtStart);
      safetyResourceChild.setDtEnd(dtEnd);
      safetyResourceChild.setIdChild(ulIdChild);
      safetyResourceChild.setSafetyResource(safetyResource);
      
      returned = safetyResourceChildDAO.saveOrUpdateSafetyResourceChild(safetyResourceChild); 
    }
  }
  
  /**
   * This private method updates the status of the safety resource event attached
   * to the child record if the end date entered means that either the last placement
   * has been closed (update to COMP) or a placement has been un-end dated (update 
   * back to PROC).
   * 
   * @param idEvent
   * @return 
   * @throws ServiceException
   */  
  private void updateSrEvent(int idEvent) throws ServiceException{
    
     List<Integer> openSrChildPlacements = new ArrayList<Integer>();
     openSrChildPlacements =  safetyResourceChildDAO.findOpenSafetyResourcesForEvent(idEvent);
     
     Event event = getPersistentObject(Event.class, idEvent);
     
     String status = event.getCdEventStatus();
     
     if (status.equals(EVENT_STATUS_PROC)&&openSrChildPlacements.isEmpty())
     {
       status = EVENT_STATUS_COMP;
       eventDAO.updateEventByIdEvent(idEvent, status);
     }
     else if (status.equals(EVENT_STATUS_COMP)&&!openSrChildPlacements.isEmpty())
     {  
       status = EVENT_STATUS_PROC;
       eventDAO.updateEventByIdEvent(idEvent, status); 
       
     } 
  } 
  
  //STGAP00014328: Alert assigned to the primary case manager
  private void saveAlert(SafetyResourceChildSaveSI safetyResourceChildSaveSI, int idEvent){   
    
    List <SafetyResourcePersonBean> safetyResourceChildList = safetyResourceChildSaveSI.getSafetyResourceChildList();
    List<Todo> todoList = new ArrayList<Todo>();
    for (Iterator <SafetyResourcePersonBean> it = safetyResourceChildList.iterator(); it.hasNext();) {      

      SafetyResourcePersonBean safetyResourceChildBean = it.next();
      String nmChild = "";
      int ulIdChild = safetyResourceChildBean.getUlIdChild();
      nmChild = personDAO.findNmFullByIdPerson(ulIdChild);
      
      String todoDesc = "Initiate a plan for closure of the safety resource for " + nmChild + ".";
      
      // SMS#113076: set static text for alert short desc and move the dynamic text to long desc
      String ftmTodoDescShort = "Placed child, " + nmChild + " must be safely returned home in 45 days";
      String ftmTodoDescLong = "Within 45 days of placing " + nmChild + " he or she must be safely returned home or a FTM must be facilitated with the family to develop a plan.";
  
      
      String dateOfPlacement = safetyResourceChildSaveSI.getDtStart().toString();
      
      String childPlacedTodo = nmChild + " " + "has been placed with a Safety resource as of " + " " + dateOfPlacement;
      

      
      Todo todo = new Todo();
     
      Event event = null;
      CapsCase capsCase = getPersistentObject(CapsCase.class, safetyResourceChildSaveSI.getUlIdCase());
      Stage stage = getPersistentObject(Stage.class, safetyResourceChildSaveSI.getUlIdStage());
      if (0 != idEvent) {
        event = getPersistentObject(Event.class, idEvent);
      }else{
        event = getPersistentObject(Event.class, idEvent);
      }
      
      
      
      //Get the primary case worker assigned to the stage where the safety resource record is documented.
      Integer idPrimaryCaseWorkerObj = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(safetyResourceChildSaveSI.getUlIdStage(), CodesTables.CROLEALL_PR);
      List<Integer> idSecondaryCaseWorkerObj = stagePersonLinkDAO.findIdCaseWorkersByIdStageAndCdStagePersRole(safetyResourceChildSaveSI.getUlIdStage(), CodesTables.CROLEALL_SE);
      // Get the County Directors
      List<String> cdEmployeeClassList = new ArrayList<String>();
      cdEmployeeClassList.add(CodesTables.CEMPJBCL_14037);// County Director
      
      
      
      int idPrimaryCaseWorker = idPrimaryCaseWorkerObj != null ? idPrimaryCaseWorkerObj : 0;
      Person caseManager = getPersistentObject(Person.class, idPrimaryCaseWorker);
      String cdCounty = "";
      if(caseManager.getEmployee().getUnit() != null){
        cdCounty = caseManager.getEmployee().getUnit().getCdCounty();
      }
      List<Integer> cntyEmpIdList = employeeDAO.findIdPersonBycdCountyAndCdEmpClass(cdCounty, cdEmployeeClassList);
      
      
      
      
      
      String cdTask = "";
      Date dateCreated = new Date();
      todo.setDtTodoDue(DateHelper.addToDate(safetyResourceChildSaveSI.getDtStart(), 0, 0, 45));
      todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPrimaryCaseWorker));
      todo.setTxtTodoDesc(todoDesc);
      todo.setCdTodoTask(cdTask);
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, safetyResourceChildSaveSI.getUlIdPerson()));
      todo.setDtTodoCreated(dateCreated);
      todo.setStage(stage);
      todo.setCapsCase(capsCase);
      todo.setEvent(event);
      todoList.add(todo);
      

      
      
      
      
      //SMS 112186 Capta 4.3 Sending alerts for children when they are placed. 
      if(idPrimaryCaseWorkerObj > 0){
        Todo childPlacedtodo = new Todo();
        childPlacedtodo.setDtTodoDue(safetyResourceChildSaveSI.getDtStart());
        childPlacedtodo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPrimaryCaseWorkerObj));
        childPlacedtodo.setTxtTodoDesc(childPlacedTodo);
        childPlacedtodo.setCdTodoTask(cdTask);
        childPlacedtodo.setCdTodoType(CodesTables.CTODOTYP_A);
        childPlacedtodo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, safetyResourceChildSaveSI.getUlIdPerson()));
        childPlacedtodo.setDtTodoCreated(dateCreated);
        childPlacedtodo.setStage(stage);
        childPlacedtodo.setCapsCase(capsCase);
        childPlacedtodo.setEvent(event);
        todoList.add(childPlacedtodo);
        
        
        Todo ftmTodo = new Todo();    
        ftmTodo.setDtTodoDue(DateHelper.addToDate(safetyResourceChildSaveSI.getDtStart(), 0, 0, 35));
        ftmTodo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPrimaryCaseWorker));
        // SMS#113076: add shorten short desc and long desc
        ftmTodo.setTxtTodoDesc(ftmTodoDescShort); 
        ftmTodo.setTxtTodoLongDesc(ftmTodoDescLong);
        ftmTodo.setCdTodoTask(cdTask);
        ftmTodo.setCdTodoType(CodesTables.CTODOTYP_A);
        ftmTodo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, safetyResourceChildSaveSI.getUlIdPerson()));
        ftmTodo.setDtTodoCreated(dateCreated);
        ftmTodo.setStage(stage);
        ftmTodo.setCapsCase(capsCase);
        ftmTodo.setEvent(event);
        todoList.add(ftmTodo);
      }
      
      
      if(idSecondaryCaseWorkerObj != null && !idSecondaryCaseWorkerObj.isEmpty()){
        for(Integer idSecondaryWorker : idSecondaryCaseWorkerObj){
        Todo childPlacedtodo = new Todo();
        childPlacedtodo.setDtTodoDue(safetyResourceChildSaveSI.getDtStart());
        childPlacedtodo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idSecondaryWorker));
        childPlacedtodo.setTxtTodoDesc(childPlacedTodo);
        childPlacedtodo.setCdTodoTask(cdTask);
        childPlacedtodo.setCdTodoType(CodesTables.CTODOTYP_A);
        childPlacedtodo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, safetyResourceChildSaveSI.getUlIdPerson()));
        childPlacedtodo.setDtTodoCreated(dateCreated);
        childPlacedtodo.setStage(stage);
        childPlacedtodo.setCapsCase(capsCase);
        childPlacedtodo.setEvent(event);
        todoList.add(childPlacedtodo);
        
        
        Todo ftmTodo = new Todo();
        ftmTodo.setDtTodoDue(DateHelper.addToDate(safetyResourceChildSaveSI.getDtStart(), 0, 0, 35));
        ftmTodo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idSecondaryWorker));
       // ftmTodo.setTxtTodoDesc(ftmTodoDesc);
        // SMS#113076: add shorten short desc and long desc
        ftmTodo.setTxtTodoDesc(ftmTodoDescShort); 
        ftmTodo.setTxtTodoLongDesc(ftmTodoDescLong);
        
        ftmTodo.setCdTodoTask(cdTask);
        ftmTodo.setCdTodoType(CodesTables.CTODOTYP_A);
        ftmTodo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, safetyResourceChildSaveSI.getUlIdPerson()));
        ftmTodo.setDtTodoCreated(dateCreated);
        ftmTodo.setStage(stage);
        ftmTodo.setCapsCase(capsCase);
        ftmTodo.setEvent(event);
        todoList.add(ftmTodo);
        }
      }
      
      // Sending FTM Alerts to County Directors 
      if(cntyEmpIdList != null && !cntyEmpIdList.isEmpty()){
        for(Integer cntyEmpId : cntyEmpIdList){
        Todo ftmTodo = new Todo();
        ftmTodo.setDtTodoDue(DateHelper.addToDate(safetyResourceChildSaveSI.getDtStart(), 0, 0, 35));
        ftmTodo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, cntyEmpId));
        //ftmTodo.setTxtTodoDesc(ftmTodoDesc);
        // SMS#113076: add shorten short desc and long desc for FTM alerts
        ftmTodo.setTxtTodoDesc(ftmTodoDescShort); 
        ftmTodo.setTxtTodoLongDesc(ftmTodoDescLong);        
        ftmTodo.setCdTodoTask(cdTask);
        ftmTodo.setCdTodoType(CodesTables.CTODOTYP_A);
        ftmTodo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, safetyResourceChildSaveSI.getUlIdPerson()));
        ftmTodo.setDtTodoCreated(dateCreated);
        ftmTodo.setStage(stage);
        ftmTodo.setCapsCase(capsCase);
        ftmTodo.setEvent(event);
        todoList.add(ftmTodo);
        }
      }
      
      

      
      
      
      
      
    }
    
    
    complexTodoDAO.saveTodo(todoList);
  }
}  