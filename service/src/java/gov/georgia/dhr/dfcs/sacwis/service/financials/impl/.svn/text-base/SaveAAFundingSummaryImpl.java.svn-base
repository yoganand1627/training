package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AaFundingReasonEligDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AaFunding;
import gov.georgia.dhr.dfcs.sacwis.db.AaFundingReasonElig;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Eligibility;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveAAFundingSummary;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Herve Jean-Baptiste September 11, 2011
 * 
 * <pre>
 *   Change History:
 *   Date         User                      Description
 *   --------     -----------------------   -----------------------------------------------------------------
 *   10/18/11     hnguyen                   STGAP00017276: Update event desc based on funding type that was validated.                                                          
 *   10/20/11     hnguyen                   STGAP00017241: If Non-Recurring Request and no AA Funding type reason exists then create one
 *                                          and reorder logic to create AA Funding record prior to creating child record AA funding reason elig.
 *   10/24/11     hnguyen                   STGAP00017241: Update logic to delete all previously saved AA Funding Reason and create a new funding reason.                                                                                                    
 * </pre>
 * 
 */
public class SaveAAFundingSummaryImpl extends BaseServiceImpl implements SaveAAFundingSummary {
  
  private static final String UPDATE = ServiceConstants.REQ_FUNC_CD_UPDATE;
  public static final String TITLE_IVB = CodesTables.CAAFDTYP_PST;
  public static final String NON_RECURRING_ONLY_CHECK = CodesTables.CAAFRSNE_NONRC;
  public static final String AA_FUNDING_CODE_TABLE = CodesTables.CAAFDTYP;
  private static final String TODO_ALERT = "A";

  private AaFundingDAO aaFundingDAO = null;
  private EventDAO eventDAO = null;
  private PostEvent postEvent = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private TodoDAO todoDAO = null;
  private AaFundingReasonEligDAO aaFundingReasonEligDAO = null;
  private CheckStageEventStatus checkStageEventStatus = null;
  
  public void setAaFundingDAO(AaFundingDAO aaFundingDAO) {
    this.aaFundingDAO = aaFundingDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
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

  public void setAaFundingReasonEligDAO(AaFundingReasonEligDAO aaFundingReasonEligDAO) {
    this.aaFundingReasonEligDAO = aaFundingReasonEligDAO;
  }
  
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  
  public int saveAAFundingSummary(AAFundingSummarySO aAFundingSummarySO) throws ServiceException {
    AaFunding aaFundingSummary = new AaFunding();
    int idAaFundingEvent = aAFundingSummarySO.getIdAaFundingEvent();
    int idUser = aAFundingSummarySO.getIduser();
    int idChild = aAFundingSummarySO.getIdChild();
    int idStage = aAFundingSummarySO.getIdStage();
    int idCase = aAFundingSummarySO.getIdCase();
    String cdEventStatus = aAFundingSummarySO.getCdEventStatus();
    String cdTask = aAFundingSummarySO.getCdTask();
    
    callCheckStageEventStatus(idAaFundingEvent, idStage, cdTask);
    
    // Call Post Event and update the event status
    List<EventPersonLink> eventPersonLinkList = null;
    CCMN01UO ccmn01uo = new CCMN01UO();
    ccmn01uo = callPostEvent(aAFundingSummarySO, eventPersonLinkList);
    if (ccmn01uo != null) {
      idAaFundingEvent = ccmn01uo.getUlIdEvent();
      Event aAFundingEvent = (Event) getPersistentObject(Event.class, idAaFundingEvent);
      aAFundingSummarySO.setDtEventLastUpdate(ccmn01uo.getTsLastUpdate());
      aAFundingSummarySO.setCdEventStatus(aAFundingEvent.getCdEventStatus());
      aAFundingSummarySO.setDtEventOccurred(aAFundingEvent.getDtEventOccurred());
      if (!CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) {
        aaFundingSummary = (AaFunding) getPersistentObject(AaFunding.class, idAaFundingEvent);
      }
      aaFundingSummary.setEvent(aAFundingEvent);
    }
    // Populate all foreign key objects
    if (aAFundingSummarySO.getIdEligibilityEvent() > 0) {
      Eligibility eligibility = (Eligibility) getPersistentObject(Eligibility.class, aAFundingSummarySO.getIdEligibilityEvent());
      aaFundingSummary.setEligibility(eligibility);
    }
    Person child = (Person) getPersistentObject(Person.class, idChild);
    aaFundingSummary.setChild(child);
    Employee employee = (Employee) getPersistentObject(Employee.class, idUser);
    aaFundingSummary.setEmployee(employee);
    if (aAFundingSummarySO.getIdApplicableSibling() > 0) {
      Person sibling = (Person) getPersistentObject(Person.class, aAFundingSummarySO.getIdApplicableSibling());
      aaFundingSummary.setSibling(sibling);
    }
    // If the Validate button was clicked, set it so it can be saved
    if (aAFundingSummarySO.isValidateButtonPressed()) {
      aAFundingSummarySO.setDtAaFundingValidated(new Date());
    }
    // If the user indicated that this AA Funding Summary is a Non-Recurring Request, 
    // set the appropriate funding type
    if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndNonRecurringReq())) {
      aAFundingSummarySO.setCdAaFundingType(CodesTables.CAAFDTYP_NRC);
    }
    // Populate the rest of the fields so they can be saved
    populateAAFunding(aAFundingSummarySO, aaFundingSummary);
    aaFundingDAO.saveAaFunding(aaFundingSummary);
    
    List<String> cdAaFundingReasonEligs = new ArrayList<String>();
    // If the user indicated that this AA Funding Summary is a Non-Recurring Request, 
    // set the appropriate funding reason
    if (ServiceConstants.FND_YES.equals(aAFundingSummarySO.getIndNonRecurringReq())) {
      // Delete the existing AA Funding Reason Eligible record
      deleteAllAaFundingRsnElig(idAaFundingEvent);
      // Save this reason
      createAaFundingReasonElig(idAaFundingEvent, NON_RECURRING_ONLY_CHECK);
      cdAaFundingReasonEligs.add(NON_RECURRING_ONLY_CHECK);
    }
    aAFundingSummarySO.setCdAaFundingReasonEligs(cdAaFundingReasonEligs);

    if (aAFundingSummarySO.isValidateButtonPressed()) {
      // If the AA Funding type is Title IV-B, clear out any existing reason eligible.
      // IV-B Funding types do not have a reason eligible 
      if (TITLE_IVB.equals(aAFundingSummarySO.getCdAaFundingType())) {
        // Delete the existing AA Funding Reason Eligible record
        deleteAllAaFundingRsnElig(idAaFundingEvent);
      }
      // If user is has click the "Validate" button send Alert to Case Manager of the Stage
      // to inform that the AA Funding Summary has been validated
      List<Integer> personList = new ArrayList<Integer>();
      // Find the Primary Case Manager and add it to the list of persons that need to get the alert
      int idCaseManager = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, CodesTables.CROLEALL_PR);
      personList.add(idCaseManager);
      String alertShortText = "AA Funding Type has been determined for " + child.getNmPersonFull();
      String alertLongText = child.getNmPersonFull()
                             + "'s Adoption Assistance Funding eligibility has been determined to be "
                             + Lookup.simpleDecodeSafe(AA_FUNDING_CODE_TABLE, aAFundingSummarySO.getCdAaFundingType())
                             + ".  Please submit an Adoption Assistance Application to SAU.";
      for (Integer idEmployee : personList) {
        Todo todo = createTodo(idUser, idStage, idCase, cdTask);
        todo.setTxtTodoDesc(alertShortText);
        todo.setTxtTodoLongDesc(alertLongText);
        todo.setCdTodoTask("");
        todo.setCdTodoType(CodesTables.CTODOTYP_A);
        todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idEmployee));
        todoDAO.saveTodo(todo);
      }
      
      // Delete existing Tasks for this event
      todoDAO.deleteTodoByIdEvent(idAaFundingEvent);
    }
    return idAaFundingEvent;
  }

  /**
   * Transfers the SO object to the  hibernate object's data record to be saved to the database
   * 
   * @param aAFundingSummarySO
   * @param aaFundingSummary
   */
  private void populateAAFunding(AAFundingSummarySO aAFundingSummarySO, AaFunding aaFundingSummary) {
    aaFundingSummary.setDtCreated(aAFundingSummarySO.getDtCreated());
    aaFundingSummary.setDtAaFundingValidated(aAFundingSummarySO.getDtAaFundingValidated());
    aaFundingSummary.setNbrFfy(aAFundingSummarySO.getNbrFfy());
    aaFundingSummary.setDtChildDob(aAFundingSummarySO.getDtChildDob());
    aaFundingSummary.setNbrChildAge(aAFundingSummarySO.getNbrChildAge());
    aaFundingSummary.setIndNonRecurringReq(aAFundingSummarySO.getIndNonRecurringReq());
    aaFundingSummary.setCdAaFundingType(aAFundingSummarySO.getCdAaFundingType());
    aaFundingSummary.setIndAcAgeMet(aAFundingSummarySO.getIndAcAgeMet());
    aaFundingSummary.setIndAcTimeInFosterMet(aAFundingSummarySO.getIndAcTimeInFosterMet());
    aaFundingSummary.setNbrChildMthsInFoster(aAFundingSummarySO.getNbrChildMthsInFoster());
    aaFundingSummary.setIndAcSiblingMet(aAFundingSummarySO.getIndAcSiblingMet());
    aaFundingSummary.setNmAcSiblingFullName(aAFundingSummarySO.getNmAcSiblingFullName());
    aaFundingSummary.setDtAcSiblingDob(aAFundingSummarySO.getDtAcSiblingDob());
    aaFundingSummary.setNbrAcSiblingAge(aAFundingSummarySO.getNbrAcSiblingAge());
    aaFundingSummary.setNbrAcSiblingMthsInFoster(aAFundingSummarySO.getNbrAcSiblingMthsInFoster());
    aaFundingSummary.setIndAcTprCtwVsMet(aAFundingSummarySO.getIndAcTprCtwVsMet());
    aaFundingSummary.setIndAcSsiEligMet(aAFundingSummarySO.getIndAcSsiEligMet());
    aaFundingSummary.setIndAcChildOfMinorMet(aAFundingSummarySO.getIndAcChildOfMinorMet());
    aaFundingSummary.setIndAcIvePriorAdoptMet(aAFundingSummarySO.getIndAcIvePriorAdoptMet());
    aaFundingSummary.setIndNacAfdcMet(aAFundingSummarySO.getIndNacAfdcMet());
    aaFundingSummary.setIndNacSsiEligMet(aAFundingSummarySO.getIndNacSsiEligMet());
    aaFundingSummary.setIndNacChildOfMinorMet(aAFundingSummarySO.getIndNacChildOfMinorMet());
    aaFundingSummary.setIndNacIvePriorAdoptMet(aAFundingSummarySO.getIndNacIvePriorAdoptMet());
    aaFundingSummary.setTxtComments(aAFundingSummarySO.getTxtComments());
  }
  
  private Todo createTodo(int idPerson, int idStage, int idCase, String cdTask) {

    Todo todo = new Todo();
    Person person = getPersistentObject(Person.class, idPerson);
    Stage stage = getPersistentObject(Stage.class, idStage);
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    todo.setCdTodoType(TODO_ALERT);
    todo.setDtTodoCreated(new Date());
    todo.setDtTodoCompleted(new Date());
    todo.setDtTodoDue(new Date());
    todo.setDtTodoTaskDue(null);
    todo.setCapsCase(capsCase);
    todo.setPersonByIdTodoPersWorker(person);
    todo.setStage(stage);
    todo.setCdTodoTask(cdTask);
    return todo;
  }
  
  /**
   * Updates the event for Adoption Assistance Funding Summary
   * 
   * @param 
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(AAFundingSummarySO aAFundingSummarySO , List<EventPersonLink> eventPersonLinkList) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    // Whenever a save or validate is performed, the event is always updated since it is
    // created on stage progression or when the Add button is clicked
    String cdReqAction = UPDATE;
    String eventStatus = aAFundingSummarySO.getCdEventStatus();
    String desc = StringHelper.EMPTY_STRING;
      if (aAFundingSummarySO.isSaveButtonPressed()) {
        eventStatus = CodesTables.CEVTSTAT_PROC;
        desc = "AA Funding Determination has been saved but has not been validated";
      }
      else if (aAFundingSummarySO.isValidateButtonPressed()){
        eventStatus = CodesTables.CEVTSTAT_APRV;
        String fundingType = aAFundingSummarySO.getCdAaFundingType();
        
        // STGAP00017276: Update event desc based on funding type that was validated.
        if(CodesTables.CAAFDTYP_IVE.equals(fundingType)){
          desc = "Title IV-E Validated: " + FormattingHelper.formatDate(new Date());
        }
        else if(CodesTables.CAAFDTYP_PST.equals(fundingType)){
          desc = "Title IV-B Validated: " + FormattingHelper.formatDate(new Date());
        }
        else{
          desc = "Non-Recurring Request Only Validated: " + FormattingHelper.formatDate(new Date());
        }
      }

    int idEvent = aAFundingSummarySO.getIdAaFundingEvent();
    Date dtEventOccurred = null;
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_AFS);
    rowccmn01uig00.setSzCdTask(aAFundingSummarySO.getCdTask());
    rowccmn01uig00.setUlIdPerson(aAFundingSummarySO.getIduser());
    rowccmn01uig00.setUlIdStage(aAFundingSummarySO.getIdStage());
    rowccmn01uig00.setUlIdEvent(idEvent);

    if(idEvent != 0){
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if(event != null){
        // Set the date last update from what is in the DB or else we can get a time stamp mismatch message
        Date dtEventLastUpdated = event.getDtLastUpdate();
        rowccmn01uig00.setTsLastUpdate(dtEventLastUpdated);
        dtEventOccurred = event.getDtEventOccurred();
        if (eventPersonLinkList != null && !eventPersonLinkList.isEmpty()) {
          Iterator<EventPersonLink> eventPersonLinkList_it = eventPersonLinkList.iterator();
          while (eventPersonLinkList_it.hasNext()) {
            EventPersonLink deleteEventPersonLink = eventPersonLinkList_it.next();
            Person person = deleteEventPersonLink.getPerson();
            ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
            rowccmn01uig01.setUlIdPerson(person.getIdPerson()); 
            rowccmn01uig01.setSzCdScrDataAction(cdReqAction);
            rowccmn01uig01.setTsLastUpdate(dtEventLastUpdated);
            rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          }
        }
      }
    }
    if (!DateHelper.isNull(dtEventOccurred) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cdReqAction);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }

  private void callCheckStageEventStatus(int idEvent, int idStage, String cdTask) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();

    ArchInputStruct archInputStruct = new ArchInputStruct();

    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    if (0 != idEvent) {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    ccmn06ui.setArchInputStruct(archInputStruct);

    // rc = Ccmn06u.CheckStageEventStatus(ccmn06ui, pCCMN06UOutputRec, pServiceStatus);
    checkStageEventStatus.status(ccmn06ui);
  }
  
  private int deleteAllAaFundingRsnElig(int idAaFundingEvent) {
    return aaFundingReasonEligDAO.deleteAllAaFundingRsnEligByIdEvent(idAaFundingEvent);
  }
  
  private void createAaFundingReasonElig(int idAaFundingEvent, String cdAaFundingRsn) {
    AaFundingReasonElig aaFundingReasonElig = new AaFundingReasonElig();
    aaFundingReasonElig.setCdAaFundingRsn(cdAaFundingRsn);
    AaFunding aaFunding = aaFundingDAO.findAAfundingByIdEvent(idAaFundingEvent);
    aaFundingReasonElig.setAaFunding(aaFunding);
    aaFundingReasonEligDAO.saveAaFundingReasonElig(aaFundingReasonElig);
  }
  
  private List<AaFundingReasonElig> getAllAaFundingReasonElig(int idAaFundingEvent) {
    return aaFundingReasonEligDAO.findAaFundingReasonElig(idAaFundingEvent);
  }
}