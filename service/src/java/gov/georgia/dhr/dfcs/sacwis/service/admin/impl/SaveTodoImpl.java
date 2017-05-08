package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpOnCallLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FamilyAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FamilyAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveTodo;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveCaseBudgetLimitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.EventIdStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ToDoAUDStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 *  *
 * <pre>
 *  Change History:
 *    Date        User         Description
 *    ----------  --------     ----------------------------------------------------------------------
 *    04/24/08    CWells       STGAP00008181 - Moving Case Budget Limit Calculations 
 *                             from the Save and Submit button to the Save of the ToDo
 *    05/21/09    mchillman    STGAP00012139 - MR-050 made sure that the approver for the adoption
 *                             assistance application is SAU and ADO_ASSIST_SPC
 *    07/26/09    hjbaptiste   STGAP00014781 - The check to see if user has the right to approve an 
 *                             adoption subsidy application or an adoption assistance agreement will no 
 *                             longer check if the user has the SAU_Staff attribute. Instead, it will check to see if 
 *                             user also has the SEC_ADO_VIEW attribute
 *    08/03/09    hjbaptiste   STGAP00014922 - Changed the condition to an 'OR' when checking to see if person selected to
 *                             assign the approval of a special need application has the correct attributes      
 *    03/21/11    htvo         SMS#97845 MR-074-2 AFCARS: changed saving alerts from single todo to list of todos 
 *                             so that this service can be better reused in saving simple alerts                   
 *    03/05/12    vcollooru    STGAP00017922: Modified to set the users with CDNFSI_ALERT profile to receive 
 *                             the Child Death, Near Fatality, or Serious Injury alerts.
 * 
 */
public class SaveTodoImpl extends BaseServiceImpl implements SaveTodo {

  private final String FAMILY_ASSESSMENT_TASK = "7060";

  private final String WINDOW_MODE_NEW_APPRV = "X";

  private final String WINDOW_MODE_NEXT_APPRV = "Y";

  private final String WINDOW_MODE_ASSIGN = "Z";

  private final String APPROVAL_FLAG = "Z";

  private final String APPROVE_CALL_CD_TASK = "1040";

  private final String APPROVE_CALL_CD_TASK_CHILD_DEATH = "1041";

  private final String APPROVE_CALL_CD_TASK_SERIOUS_INJURY = "1042";
  
  private final String APPROVE_CALL_CD_TASK_NEAR_FATALITY = "1045";

  private final String APPROVE_CALL_CD_TASK_NI = "1044";

  private final String APPROVE_SERVICE_AUTHORIZATION = "4190";

  private final String IMMEDIATE_RESPONSE_DESC = "Intake report requiring immediate response received";

  private final String ALLEGED_VICTIM_PREVIOUSLY_REPORTED = "Intake report has been received on an Alleged Victim that has previous reports.";

  private final String SUPERVISOR = "SUPERVISOR";

  private final String COUNTY_DIRECTOR = "COUNTY_DIRECTOR";

  private final String RISK_CONSULTANT = "RISK_CONSULTANT";

  private ApprovalDAO approvalDAO = null;

  private SvcAuthEventLinkDAO svcAuthEventLinkDAO = null;

  private ApprovalEventLinkDAO approvalEventLinkDAO = null;

  private ApproversDAO approversDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexApprovalDAO complexApprovalDAO = null;

  private ComplexTodoDAO complexTodoDAO = null;

  private ComplexEventDAO complexEventDAO = null;

  private EmployeeDAO employeeDAO = null;

  private EmpOnCallLinkDAO empOnCallLinkDAO = null;

  private EventDAO eventDAO = null;

  private FamilyAssmtDAO familyAssmtDAO = null;

  private SaveCaseBudgetLimitList saveCaseBudgetLimitList = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TaskDAO taskDAO = null;

  private TodoDAO todoDAO = null;

  private CheckIfUserHasRight checkIfUserHasRight = null;

  public static final String CPS_INV_CONCL_TASK_CODE = "2330";

  public static final String SAFETY_ASSESSMENT_CODE = "2285";

  public static final String RISK_ASSESSMENT_CODE = "2295";

  public static final String SAFETY_PLAN_CODE = "2275";

  public static final String SEC_AUTH_TO_APPROVE = "85";
  
  public static final String SEC_SAU_EXCHANGE = "91";
    
  public static final String SEC_ADO_VIEW = "63";
  
  public static final String SEC_ADOPT_ASSIST_SPEC = "59";
  
  private static final Set<String> ADOPTION_ASSIT_APPL_TASK_CODES = new HashSet<String>() {
    {
      add("8610"); // ADO
      add("9100"); // PAD
    }
  };
  
  private static final Set<String> ADOPTION_ASSIT_AGREE_TASK_CODES = new HashSet<String>() {
    {
      add("9116"); // ADO
      add("9106"); // PAD
      add("9115"); // ADO
      add("9105"); // PAD
    }
  };
  

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setComplexApprovalDAO(ComplexApprovalDAO complexApprovalDAO) {
    this.complexApprovalDAO = complexApprovalDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setComplexEventDAO(ComplexEventDAO complexEventDAO) {
    this.complexEventDAO = complexEventDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEmpOnCallLinkDAO(EmpOnCallLinkDAO empOnCallLinkDAO) {
    this.empOnCallLinkDAO = empOnCallLinkDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setFamilyAssmtDAO(FamilyAssmtDAO familyAssmtDAO) {
    this.familyAssmtDAO = familyAssmtDAO;
  }

  public void setSaveCaseBudgetLimitList(SaveCaseBudgetLimitList saveCaseBudgetLimitList) {
    this.saveCaseBudgetLimitList = saveCaseBudgetLimitList;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSvcAuthEventLinkDAO(SvcAuthEventLinkDAO svcAuthEventLinkDAO) {
    this.svcAuthEventLinkDAO = svcAuthEventLinkDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }

  public CINV05SO saveTodoAlert(TodoAlertSaveSI todoalertsavesi) {
    CINV05SO cinv05so = new CINV05SO();
    // SMS#97845 MR-074-2 AFCARS: changed saving alerts from single todo to list of todos 
    // so that this service can be reused in saving simple alerts created by the system
    List<Integer> idTodoPersAssignedList = todoalertsavesi.getIdTodoPersAssignedList();
    if (idTodoPersAssignedList != null && !idTodoPersAssignedList.isEmpty()) {
      List<Todo> todoAlertList = new ArrayList<Todo>();
      for (Integer idTodoPersAssigned : idTodoPersAssignedList) {
        String txtTodoLongDesc = todoalertsavesi.getTxtTodoLongDesc();
        int idStage = todoalertsavesi.getIdStage();
        int idPersonCreator = todoalertsavesi.getIdPersonCreator();
        String txtShortDesc = todoalertsavesi.getTxtTodoShortDesc();

        Date System_date = new Date();
        String cdTodoTask = null;
        String cdTodoType = CodesTables.CTODOTYP_A;
        Date dtTodoCompleted = System_date;
        Date dtTodoCreated = System_date;
        Date dtTodoDue = todoalertsavesi.getDueDate();
        Date dtTaskDue = null;

        Todo todo = new Todo();
        todo.setCdTodoTask(cdTodoTask);
        todo.setCdTodoType(cdTodoType);
        todo.setDtTodoCompleted(dtTodoCompleted);
        todo.setDtTodoCreated(dtTodoCreated);
        todo.setDtTodoDue(dtTodoDue);
        todo.setDtTodoTaskDue(dtTaskDue);
        todo.setTxtTodoDesc(txtShortDesc);

        Stage stage = this.getPersistentObject(Stage.class, idStage);
        todo.setStage(stage);
        todo.setCapsCase(stage.getCapsCase());
        Person person = this.getPersistentObject(Person.class, idTodoPersAssigned);
        // Allow system created alert which does not need creator set
        if (idPersonCreator > 0) {
          Person creator = this.getPersistentObject(Person.class, idPersonCreator);
          todo.setPersonByIdTodoPersCreator(creator);
        }
        todo.setPersonByIdTodoPersAssigned(person);
        todo.setPersonByIdTodoPersWorker(person);
        todo.setTxtTodoLongDesc(txtTodoLongDesc);

        todoAlertList.add(todo);       
      }
      complexTodoDAO.saveTodo(todoAlertList);
    }
    // -- add something into the output object to return
    cinv05so.setUlIdPerson(3);
    return cinv05so;
  }

  public CCMN19SO saveTodoInformation(CCMN19SI ccmn19si) throws ServiceException {
    CCMN19SO ccmn19so = new CCMN19SO();
    // Note: CopmplexTodoDAO is called many times, for insert/update/delete operations with
    // a Todo object as the parameter. The same populated object is re-used in the later calls
    // after re-setting the required fields of the object whenever required.
    Todo todo = populateTodo(ccmn19si);
    String cReqFuncCd = ccmn19si.getArchInputStruct().getCReqFuncCd();
    boolean bAprv = true;
    int idPersonAssigned = ccmn19si.getToDoAUDStruct().getUlIdTodoPersAssigned();

    // Check to see if user has the authorization to approve the task. There's no need to
    // continue if they don't. STGAP00004839 ei
    if (!checkIfUserHasRight.determineIfUserHasRight(idPersonAssigned, SEC_AUTH_TO_APPROVE)) {
      throw new ServiceException(Messages.MSG_NOT_AUTH_TO_APPROVE);
    }
    if (CodesTables.CTODOTYP_T.equals(ccmn19si.getToDoAUDStruct().getSzCdTodoType())
        && ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Check Stage/Event common function . Need to check the ToDo type, so that the CheckStageEventStatus
      // function won't be called for Alerts and Reminders, which do not pass a stage.
      CCMN06UI ccmn06ui = new CCMN06UI();
      ccmn06ui.setUlIdStage(todo.getStage() != null ? todo.getStage().getIdStage() : 0);
      ccmn06ui.setSzCdTask(todo.getCdTodoTask());
      // Calling CheckStageEventStatus
      checkStageEventStatus.status(ccmn06ui);
    }

    if (WINDOW_MODE_NEW_APPRV.equals(cReqFuncCd)) {
      // STGAP00005880 - do not delete any invalid or rejected historical record relating to event being
      // submitted for approval. Notes that even though this is baseline code but the schema for GA has been
      // changed that makes it immpossible to delete approval event of rejection and still showing history of
      // rejection, so cancel the deletion entirely (per build lead's approval)
      /*
       * // Logic to look for and delete any approvals that were previously rejected or invalidated and // are still
       * linked to an event being submitted. NOTE: It was decided to loop through the calld DAO // function for each
       * Id_Event passed because it is the quickest way to implement this fix. It can be // tuned at a later date to
       * improve performance if it becomes an issue. One way to eliminate the looping // is to have all the windows that
       * call this function to link an array of event to an approval event // submit the events, ordering the 'APP'
       * (approval events) at the end. They will all be deleted through // this processing and the loops can be
       * terminated when a id_event = 0 once again. // For each id_event passed to the service, loop through to see if
       * the event is linked to a previous // approval. If so, continue processing to delete approval. If not, keep
       * looping through events to // find others linked to approvals. Need to loop through all events because nth event //
       * may have beem deleted because it was an approval event. for (Enumeration eventIdStructEnum =
       * ccmn19si.getEventIdStruct_ARRAY().enumerateEventIdStruct(); eventIdStructEnum .hasMoreElements();) {
       * EventIdStruct eventIdStruct = (EventIdStruct) eventIdStructEnum.nextElement(); // Calling CCMN55D // This DAO
       * will look for an id_approval that maches the id_event passes. // It will look in the APPROVAL_EVENT_LINK table.
       * Integer wrappedIdApproval = approvalEventLinkDAO.findApprovalEventLinkByIdEvent(eventIdStruct.getUlIdEvent());
       * int idApproval = wrappedIdApproval != null ? wrappedIdApproval : 0; // If the idApproval is not zero, loop
       * through events to see if any of them match. If so delete them so // there are no errors in later processing.
       * Also set bMatch to break out of loop as soon as a match is made // to cut down on unnecessary looping if (0 !=
       * idApproval) { for (Enumeration eventIdStructEnum2 = ccmn19si.getEventIdStruct_ARRAY().enumerateEventIdStruct();
       * eventIdStructEnum2 .hasMoreElements();) { EventIdStruct eventIdStruct2 = (EventIdStruct)
       * eventIdStructEnum2.nextElement(); if (idApproval == eventIdStruct2.getUlIdEvent()) {
       * eventIdStruct2.setUlIdEvent(0); break; } } } // If the Id_Approval is not zero, call DAO to see if the approval
       * was ever rejected or invalidated if (0 != idApproval) { // Calling DAO CCMN56D // This DAO will look for the
       * status of the approval found in the previous DAO. // It will look in the APPROVERS table.If none any of the
       * status' found are REJT or INVD, the // Id_Approval passed in will be set to 0 to indicate that the Approval
       * should not be deleted. // Else it will retain the same Approval Id and the processing will continue with
       * deleting the event.
       * 
       * List<Map> listApprvr = approversDAO.findAllApproversForGivenApproval(idApproval); if (listApprvr == null ||
       * listApprvr.isEmpty()) { // If no row is found, the approval was deleted already because it was also related to
       * a revious event // passed. Set the id_approval to zero to stop the deleting of approvals idApproval = 0; } else { //
       * Loop through DAO output rec to see if any of the approver rejected an approval or if any of them were //
       * invalidated for (Iterator<Map> it = listApprvr.iterator(); it.hasNext();) { Map map = it.next(); // set
       * Approval indicator to 0 if an approver has a status of INVD or REJT if
       * ((CodesTables.CAPPDESG_REJT.equals(map.get("cdApproversStatus"))) ||
       * (CodesTables.CAPPDESG_INVD.equals(map.get("cdApproversStatus")))) { bAprv = false; break; } } // If the
       * approval status' were all APRVD (note none found should be pending because invalidate // approval should have
       * taken care of all events and edits check that no PEND events can be // submitted for approval) set the
       * id_approval to 0 to stop approval delete processing if (bAprv == true) { idApproval = 0; } } } // If the
       * id_approval was not set to zero, the approval needs to be deleted so caud51d needs to be called if (0 !=
       * idApproval) { // Calling DAO CAUD51D // This DAO will delete the approval and all record associated with it.
       * Records will be deleted // from: APPROVAL_EVENT_LINK, APPOVERS, APPROVAL, and EVENT. int rowsDeleted =
       * complexApprovalDAO.approvalCascadeDelete(idApproval,eventIdStruct.getUlIdEvent()); if (rowsDeleted <= 0) {
       * throw new ServiceException(Messages.SQL_NOT_FOUND); } } } // End of Enumeration... Call CCMN55D
       */
      // End STGAP00005880
      // NEW APPROVAL CREATION SCENERIO (EVENT LIST / FUNCTIONAL WIN)
      // Call DAO CCMN46D to add a record to the EVENT table for the Approval Event to be created.
      // Add a record to EVENT table and return the new ID EVENT, which is set to input object (ccmn19si)
      // Calling DAO CCMN46D
      Integer idEventNew = callCCMN46D(CodesTables.CEVTSTAT_PROC, todo.getDtTodoCreated(),
                                       todo.getPersonByIdTodoPersCreator().getIdPerson(), todo.getStage().getIdStage(),
                                       todo.getTxtTodoDesc(), todo.getCdTodoTask(), CodesTables.CEVNTTYP_APP);

      // Update the event status for the Event Ids passed to the service
      // This DAO will ADD/UPDATE a record from the Event table or update the status of a group of events to Pending.
      // loop through all the Event Id's
      String currentTaskCode = "";
      String taskCode = "";

      Event currentEvent = eventDAO.findEventByIdEvent(ccmn19si.getEventStruct().getUlIdEvent());
      if (currentEvent != null) {
        currentTaskCode = currentEvent.getCdTask();
      }
      for (Enumeration eventIdStructEnum3 = ccmn19si.getEventIdStruct_ARRAY().enumerateEventIdStruct(); eventIdStructEnum3
                                                                                                                          .hasMoreElements();) {
        EventIdStruct eventIdStruct4 = (EventIdStruct) eventIdStructEnum3.nextElement();
        int idEvent = eventIdStruct4.getUlIdEvent();
        Event event = eventDAO.findEventByIdEvent(idEvent);
        taskCode = event.getCdTask();
        // The loop will go through the entire array because the number of actual Event Ids in the array is
        // not being passed in. Check the value of ulIdEvent. If it is not blank call the DAO,
        // otherwise exit the loop.
        if (idEvent != 0) {
          
          if (ADOPTION_ASSIT_APPL_TASK_CODES.contains(currentTaskCode)) {
            if (checkIfUserHasRight.determineIfUserHasRight(idPersonAssigned, SEC_ADO_VIEW) == false
                            || checkIfUserHasRight.determineIfUserHasRight(idPersonAssigned, SEC_ADOPT_ASSIST_SPEC) == false) {
                            throw new ServiceException (Messages.MSG_AA_APP_APPRV_PRIV);
            }
          }
          
          if (ADOPTION_ASSIT_AGREE_TASK_CODES.contains(currentTaskCode) || (ADOPTION_ASSIT_AGREE_TASK_CODES.contains(taskCode))) {
            if (checkIfUserHasRight.determineIfUserHasRight(idPersonAssigned, SEC_ADO_VIEW) == false 
                           || checkIfUserHasRight.determineIfUserHasRight(idPersonAssigned, SEC_ADOPT_ASSIST_SPEC) == false){
              throw new ServiceException (Messages.MSG_AA_AGR_APPRV_PRIV);
            }
          }
            
          if (CPS_INV_CONCL_TASK_CODE.equals(currentTaskCode)) {
            if (!SAFETY_ASSESSMENT_CODE.equals(taskCode) && !RISK_ASSESSMENT_CODE.equals(taskCode)
                && !SAFETY_PLAN_CODE.equals(taskCode)) {
              int rowsUpdated = eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_PEND);
              if (rowsUpdated < 1) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
            }
          } else {
            int rowsUpdated = eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_PEND);
            if (rowsUpdated < 1) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

          }
        }
      }
      // Set function to delete all records on APPROVAL_EVENT_LINK table for events that may be linked to a
      // previously rejected approval. Loop through all the Event Id's
      /*
       * for (Enumeration eventIdStructEnum4 = ccmn19si.getEventIdStruct_ARRAY().enumerateEventIdStruct();
       * eventIdStructEnum4 .hasMoreElements();) { EventIdStruct eventIdStruct5 = (EventIdStruct)
       * eventIdStructEnum4.nextElement(); int idEvent = eventIdStruct5.getUlIdEvent(); if (idEvent != 0) { // Calling
       * DAO CCMN91D ...(for DELETE) // This DAO will Add several records to the APPROVAL_EVENT_LINK table
       * approvalEventLinkDAO.deleteApprovalEventLinkByIdEvent(idEvent); } }
       */
      // Calling DAO CCMN91D (ADD): Add records in Approval_Event_link table * now that any previous links to a
      // rejected approval have been * removed.
      if (currentEvent != null) {
        if (CodesTables.CEVNTTYP_AUT.equals(currentEvent.getCdEventType())
            && APPROVE_SERVICE_AUTHORIZATION.equals(taskCode))
          ;
        {
          // STGAP00008181
          // Budget Limit validation code
          // Begin
          // When the save and submit button on the service auth header page is clicked then the requested amount
          // for each service which has predefined budget limit needs to be validated against the budget limits.
          // If it exceeds the limit an error message is displayed.
          // If the the amount is within the limits and there is no entry for the service code that is being
          // validated in the case budget limit table then a new row is inserted, else the existing row is updated.

          if (currentEvent != null) {
            int idSvcAuthEvent = currentEvent.getIdEvent();
            SvcAuthEventLink svcAuthEventLink = svcAuthEventLinkDAO.findSvcAuthEventLinkByEventId(idSvcAuthEvent);
            String eventStatus = "";
            eventStatus = currentEvent.getCdEventStatus();
            int idSvcAuth = 0;

            if (CodesTables.CEVTSTAT_COMP.equals(eventStatus)
                && (CodesTables.CEVNTTYP_AUT.equals(currentEvent.getCdEventType()))) {
              idSvcAuth = svcAuthEventLink.getServiceAuthorization().getIdSvcAuth();
              CaseBudgetLimitSaveSI csBdgtSaveSI = new CaseBudgetLimitSaveSI();
              csBdgtSaveSI.setUlIdCase(currentEvent.getCapsCase().getIdCase());
              csBdgtSaveSI.setModeIndicator(CodesTables.CEVTSTAT_PEND);
              csBdgtSaveSI.setUlIdSvcAuth(idSvcAuth);
              csBdgtSaveSI.setUlIdEvent(currentEvent.getIdEvent());

              saveCaseBudgetLimitList.saveCaseBudgetLimitList(csBdgtSaveSI);
            }
          }
          // Budget Limit validation code
          // End
        }
      }
      for (Enumeration eventIdStructEnum5 = ccmn19si.getEventIdStruct_ARRAY().enumerateEventIdStruct(); eventIdStructEnum5
                                                                                                                          .hasMoreElements();) {
        EventIdStruct eventIdStruct5 = (EventIdStruct) eventIdStructEnum5.nextElement();
        int idEvent = eventIdStruct5.getUlIdEvent();
        if (idEvent != 0) {
          // Calling DAO CCMN91D ... (for INSERT)
          approvalEventLinkDAO.insertApprovalEventLink(idEvent, idEventNew);
        }
      }
      // Calling DAO CCMN92D to add a record to Approval Table.
      int rowsInserted = approvalDAO.insertApproval(idEventNew, ccmn19si.getApprvStruct().getUlIdPerson(),
                                                    ccmn19si.getApprvStruct().getSzTxtApprovalTopic());
      if (rowsInserted <= 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // Add a record to Todo table.
      todo.setPersonByIdTodoPersCreator(null);
      // Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation
      int idTodo = (callCCMN43D(todo, cReqFuncCd));

      Person toDoPersWorker = todo.getPersonByIdTodoPersWorker();
      String personByIdTodoPersWorkerCdCounty = null;

      if (toDoPersWorker != null) {

        personByIdTodoPersWorkerCdCounty = todo.getPersonByIdTodoPersWorker().getEmployee().getUnit().getCdCounty();
        // When an Inake is submitted with a special investigation type of Child Death or series injury an
        // alert is created for County director
        //STGAP00017922:Did not include NEAR_FATALITY as this Alert is not part of the existing requirements. Also note that
        //this Alert will never be sent as 'COUNTY_DIRECTOR'is not a security class name (cd_security_class_name in security_class table)
        //If the security_class_name is corrected in future, INCLUDE Near Fatality task code also 
        if (APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(todo.getCdTodoTask())
            || APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(todo.getCdTodoTask())) {
          ArrayList<String> jobList = new ArrayList<String>();
          jobList.add(COUNTY_DIRECTOR);
          List countyDirectorsList = employeeDAO.findIdPersonByJobSecurityRole(personByIdTodoPersWorkerCdCounty,
                                                                               jobList);
          for (Iterator it = countyDirectorsList.iterator(); it.hasNext();) {
            Integer idCountyDirectors = (Integer) it.next();

            Todo todoCountyDirectors = populateTodo(ccmn19si);
            todoCountyDirectors.setCdTodoType(CodesTables.CTODOTYP_A);
            todoCountyDirectors.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idCountyDirectors));
            // Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation
            callCCMN43D(todoCountyDirectors, cReqFuncCd);
          }
        }

      }

      // An immediate-24hrs response time is assigned
      if (CodesTables.CPRIORTY_IM.equals(todo.getStage().getCdStageCurrPriority()))

      {

        if (APPROVE_CALL_CD_TASK.equals(todo.getCdTodoTask()) || APPROVE_CALL_CD_TASK_NI.equals(todo.getCdTodoTask())
            || APPROVE_CALL_CD_TASK_CHILD_DEATH.equals(todo.getCdTodoTask())
            || APPROVE_CALL_CD_TASK_SERIOUS_INJURY.equals(todo.getCdTodoTask())
            || APPROVE_CALL_CD_TASK_NEAR_FATALITY.equals(todo.getCdTodoTask())) {

          // if OnCall Supervisor is found, create an alert for immediate-24hrs response

          // Check for weekends and OffTime (5:00 PM and 8:00 AM)
          // if (DateHelper.getHelper.gtodo.getStage().getIncomingDetail().getDtIncomingCall())
          if (DateUtility.isNonBusinessHour(todo.getStage().getIncomingDetail().getDtIncomingCall())) {

            Calendar cal = Calendar.getInstance();

            List onCallSupervisorList = empOnCallLinkDAO
                                                        .findOnCallIdEmpBySecurityClassNm(
                                                                                          personByIdTodoPersWorkerCdCounty,
                                                                                          SUPERVISOR, cal.getTime());
            for (Iterator it = onCallSupervisorList.iterator(); it.hasNext();) {

              Integer idOnCallSupervisor = (Integer) it.next();

              Todo todoOnCallSupervisor = populateTodo(ccmn19si);
              // todoOnCallSupervisor.setCdTodoTask(task.getCdTask());
              todoOnCallSupervisor.setCdTodoTask("");
              todoOnCallSupervisor.setTxtTodoDesc(IMMEDIATE_RESPONSE_DESC + "-"
                                                  + todoOnCallSupervisor.getStage().getNmStage());

              todoOnCallSupervisor.setCdTodoType(CodesTables.CTODOTYP_A);
              todoOnCallSupervisor.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idOnCallSupervisor));
              // Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation
              callCCMN43D(todoOnCallSupervisor, cReqFuncCd);

            }// end of for

          }// end of isNonBusinessHour

          // Send an alert to supervisor
          Todo todoSupervisor = populateTodo(ccmn19si);
          todoSupervisor.setCdTodoTask("");
          todoSupervisor.setCdTodoType(CodesTables.CTODOTYP_A);
          todoSupervisor.setTxtTodoDesc(IMMEDIATE_RESPONSE_DESC + "-" + todoSupervisor.getStage().getNmStage());
          callCCMN43D(todoSupervisor, cReqFuncCd);
          // STGAP00007159: Commented out the alert as per defect manager's clarification
          /*
           * // if County director is found, create an alert for immediate-24hrs response ArrayList<String> jobList =
           * new ArrayList<String>(); jobList.add(COUNTY_DIRECTOR); List countyDirectorsList =
           * employeeDAO.findIdPersonByJobSecurityRole(personByIdTodoPersWorkerCdCounty, jobList); for (Iterator it =
           * countyDirectorsList.iterator(); it.hasNext();) { Integer idCountyDirectors = (Integer) it.next(); Todo
           * todoCountyDirectors = populateTodo(ccmn19si); todoCountyDirectors.setCdTodoTask("");
           * todoCountyDirectors.setCdTodoType(CodesTables.CTODOTYP_A);
           * todoCountyDirectors.setTxtTodoDesc(IMMEDIATE_RESPONSE_DESC + "-" +
           * todoCountyDirectors.getStage().getNmStage());
           * todoCountyDirectors.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idCountyDirectors)); //
           * Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation callCCMN43D(todoCountyDirectors, cReqFuncCd); }
           */

        }
      }
      // STGAP00007159: Commented out the alert as per defect manager's clarification
      // Check for Alleged Victim previously reported.
      /*
       * if (checkForAllegedVictimPreviousReported(todo.getStage().getIdStage(), todo.getCapsCase().getIdCase())) { //
       * Find a risk director, if found send an alert ArrayList<String> JobTitleList = new ArrayList<String>();
       * JobTitleList.add(RISK_CONSULTANT); List employeeList = employeeDAO .findIdPersonByJobSecurityRolesAndRegion(
       * todo.getPersonByIdTodoPersWorker() .getEmployee().getCdEmpUnitRegion(), JobTitleList); for (Iterator it =
       * employeeList.iterator(); it.hasNext();) { Integer idRiskDirectors = (Integer) it.next(); Todo todoRiskDirectors =
       * populateTodo(ccmn19si); todoRiskDirectors.setCdTodoTask("");
       * todoRiskDirectors.setCdTodoType(CodesTables.CTODOTYP_A);
       * todoRiskDirectors.setTxtTodoDesc(ALLEGED_VICTIM_PREVIOUSLY_REPORTED);
       * todoRiskDirectors.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idRiskDirectors)); // Calling
       * DAO (ComplexTodoDAO) CCMN43D ..... insert operation callCCMN43D(todoRiskDirectors, cReqFuncCd); } }
       */

      ccmn19so.setLdIdTodo(idTodo);
      // Calling DAO CCMN93D to Add a record to APPROVERS table
      ApproversStruct approversStruct = ccmn19si.getApproversStruct();
      if (approversStruct == null) {
        throw new RuntimeWrappedException(new PopulationException("ApproversStruct not populated in CCMN19SI object."));
      }
      approversStruct.setUlIdApproval(idEventNew);
      approversStruct.setLdIdTodo(idTodo);
      callCCMN93D(approversStruct);
    }
    // Add approver Creation Scenario (EVENT LIST / APPROVAL STATUS)
    else if (WINDOW_MODE_NEXT_APPRV.equals(cReqFuncCd)) {
      // Add a record to Todo table
      // Re-setting two fields of Todo object, populated earlier.
      // Set ulIdEvent to ulIdApproval if the window Mode is WINDOW_MODE_NEXT_APPRV. If it is not this
      // window Mode, then Id Event is set like it originally was.
      Event todoEvent = getPersistentObject(Event.class, ccmn19si.getApproversStruct().getUlIdApproval());
      todo.setEvent(todoEvent);
      todo.setPersonByIdTodoPersCreator(null);
      // Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation
      int idTodo = (callCCMN43D(todo, cReqFuncCd));
      ccmn19so.setLdIdTodo(idTodo);
      // Calling DAO CCMN93D to Add a record to APPROVERS table
      ccmn19si.getApproversStruct().setLdIdTodo(idTodo);
      callCCMN93D(ccmn19si.getApproversStruct());
      // Updating timestamp on Event table if the TaskNew in the InputMsg != APPROVAL_FLAG
      // (i.e. if approver is being added from some window OTHER than Approval Status (CCMN65W)
      // Update the timestamp on the Event table
      if (!APPROVAL_FLAG.equals(ccmn19si.getCSysIndTaskNew())) {
        // Calling DAO CCMNG3D
        int rowsUpdated = eventDAO.updateEvent(ccmn19si.getApproversStruct().getUlIdApproval());
        if (rowsUpdated < 1) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Calling DAO (ComplexTodoDAO) CCMN43D ... Update a record from Todo table
      ccmn19so.setLdIdTodo(callCCMN43D(todo, cReqFuncCd));
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Calling DAO (ComplexTodoDAO) CCMN43D ... Delete a record from Todo table
      ccmn19so.setLdIdTodo(callCCMN43D(todo, cReqFuncCd));
    } else if (WINDOW_MODE_ASSIGN.equals(cReqFuncCd)) {
      // If the todo is task related and a new event is needed then get a description and a new event otherwise an
      // Id Event was passed in from Task List window or the todo is a REMINDER_TODO that isn't tied to an event.
      String cdTodoTask = todo.getCdTodoTask();
      if (ArchitectureConstants.Y.equals(ccmn19si.getCSysIndTaskNew()) && cdTodoTask != null) {
        // Read Task Table for Event Type and Default Description

        // Calling DAO CCMN82D
        Task task = taskDAO.findTaskByCdTask(cdTodoTask);
        if (task == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        String eventType = task.getCdTaskEventType();
        String eventDesc = task.getTxtTaskDecode();
        Date todayDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

        // Calling DAO CCMN46D.... Make event to tie ToDo To
        // Add a record to EVENT table and return the new ID EVENT, which is set to the input object, ccmn19si
        callCCMN46D(CodesTables.CEVTSTAT_NEW, todayDate, todo.getPersonByIdTodoPersCreator().getIdPerson(),
                    todo.getStage().getIdStage(), eventDesc, todo.getCdTodoTask(), eventType);
        // A Family Assessment Shell, not just the event needs to be created when creating a ToDo for a New Event
        if (FAMILY_ASSESSMENT_TASK.equals(cdTodoTask)) {
          FamilyAssmt familyAssmt = new FamilyAssmt();
          familyAssmt.setIdEvent(todo.getEvent().getIdEvent());
          Stage stage = new Stage();
          stage.setIdStage(todo.getStage() != null ? todo.getStage().getIdStage() : 0);
          familyAssmt.setStage(stage);
          familyAssmt.setDtFamAssmtComplt(null);
          // Calling DAO CSVC03D ... saves the family assessment id.
          familyAssmtDAO.saveFamilyAssmt(familyAssmt);
        }
      }
      // Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation
      ccmn19so.setLdIdTodo(callCCMN43D(todo, ServiceConstants.REQ_FUNC_CD_ADD));
    } else {
      // NEW & NEW USING Scenario (Todo DIALOG)
      // Calling DAO (ComplexTodoDAO) CCMN43D ..... insert operation
      ccmn19so.setLdIdTodo(callCCMN43D(todo, ServiceConstants.REQ_FUNC_CD_ADD));
    }
    return ccmn19so;
  }

  private int callCCMN43D(Todo todo, String cReqFuncCd) throws ServiceException {
    // ADDs/UPDATEs/DELETEs a record of the Todo table.
    int idTodo;
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      idTodo = complexTodoDAO.updateTodo(todo);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      idTodo = complexTodoDAO.deleteTodo(todo);
    } else {
      // Insert operation
      idTodo = complexTodoDAO.insertTodo(todo);
    }
    // if a todo was not found, inform the user that the todo has been
    // deleted
    if (idTodo == 0) {
      throw new ServiceException(Messages.MSG_CMN_TODO_DELETED);
    }
    return idTodo;
  }

  private Integer callCCMN46D(String eventStat, Date dtTodoCreated, int idTodoPersonCreator, int idStage,
                              String txtTodoDesc, String cdToDoTask, String cdEventType) throws ServiceException {

    Integer idEventNew = complexEventDAO.insertEvent(eventStat, cdEventType, dtTodoCreated, idTodoPersonCreator,
                                                     idStage, txtTodoDesc, cdToDoTask);
    if (idEventNew == null) {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return idEventNew;

  }

  private void callCCMN93D(ApproversStruct approversStruct) throws ServiceException {
    Date dtApproversDetermination = DateHelper.toJavaDate(approversStruct.getDtDtApproversDetermination());
    Date dtApproversRequested = DateHelper.toJavaDate(approversStruct.getDtDtApproversRequested());
    int rowsInserted = approversDAO.insertApprovers(CodesTables.CEVTSTAT_PEND, dtApproversDetermination,
                                                    dtApproversRequested, approversStruct.getUlIdApproval(),
                                                    approversStruct.getUlIdPerson(), approversStruct.getLdIdTodo(),
                                                    approversStruct.getBIndApproversHistorical(),
                                                    approversStruct.getSzTxtApproversComments());
    if (rowsInserted < 1) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private Todo populateTodo(CCMN19SI ccmn19si) {
    Todo todo = new Todo();
    ToDoAUDStruct doAUDStruct = ccmn19si.getToDoAUDStruct();
    int idCase = doAUDStruct.getUlIdCase();
    int idEvent = doAUDStruct.getUlIdEvent();
    int idTodoPersAssigned = doAUDStruct.getUlIdTodoPersAssigned();
    int idTodoPersCreator = doAUDStruct.getUlIdTodoPersCreator();
    int idTodoPersWorker = doAUDStruct.getUlIdTodoPersWorker();
    int idStage = doAUDStruct.getUlIdStage();
    todo.setCdTodoTask(doAUDStruct.getSzCdTodoTask());
    todo.setCdTodoType(doAUDStruct.getSzCdTodoType());
    todo.setDtTodoCompleted(DateHelper.toJavaDate(doAUDStruct.getDtDtTodoCompleted()));
    Date todoCreated = DateHelper.toJavaDateSafe(doAUDStruct.getDtDtTodoCreated(), doAUDStruct.getTmTmTodoCreated());
    todo.setDtTodoCreated(todoCreated);
    todo.setDtTodoDue(DateHelper.toJavaDate(doAUDStruct.getDtDtTodoDue()));
    todo.setDtTodoTaskDue(DateHelper.toJavaDate(doAUDStruct.getDtDtTaskDue()));
    todo.setCapsCase(idCase != 0 ? getPersistentObject(CapsCase.class, idCase) : null);
    todo.setEvent(idEvent != 0 ? getPersistentObject(Event.class, idEvent) : null);
    todo.setPersonByIdTodoPersCreator(idTodoPersCreator != 0 ? getPersistentObject(Person.class, idTodoPersCreator)
                                                            : null);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idTodoPersAssigned));
    todo
        .setPersonByIdTodoPersWorker(idTodoPersWorker != 0 ? getPersistentObject(Person.class, idTodoPersWorker) : null);
    todo.setStage(idStage != 0 ? getPersistentObject(Stage.class, idStage) : null);
    todo.setIdTodo(doAUDStruct.getLdIdTodo());
    todo.setTxtTodoDesc(doAUDStruct.getSzTxtTodoDesc());
    todo.setTxtTodoLongDesc(doAUDStruct.getTxtTodoLongDesc());
    todo.setDtLastUpdate(doAUDStruct.getTsLastUpdate());
    return todo;
  }

  // todo.getStage().getIdStage()
  private boolean checkForAllegedVictimPreviousReported(int idStage, int idCase) {

    List<Map> stagePersonMap = stagePersonLinkDAO
                                                 .findIdPersonAndNmPersonFullFromStagePersonLinkAndPersonByAllegedVictim(idStage);

    if (stagePersonMap == null || stagePersonMap.isEmpty()) {
      // throw new ServiceException(Messages.SQL_NOT_FOUND);
      return false;
    }
    Iterator itCcmne4dStagePersonMap = stagePersonMap.iterator();

    while (itCcmne4dStagePersonMap.hasNext()) {
      Map ccmne4dStagePersonMap = (Map) itCcmne4dStagePersonMap.next();
      int ccmne4dIdPerson = (Integer) ccmne4dStagePersonMap.get("idPerson");

      // ccmne5dQUERYdam
      List<Map> stagePersonLinkMap = stagePersonLinkDAO
                                                       .findIdStageIdPersonIdCaseFromStageAndStagePersonLink(
                                                                                                             ccmne4dIdPerson,
                                                                                                             idCase);

      Iterator itCcmne5dStagePersonLinkMap = stagePersonLinkMap.iterator();

      while (itCcmne5dStagePersonLinkMap.hasNext()) {
        return true;
      } // end while
    } // end while stagePersonMap hasNex
    return false;
  }
}
