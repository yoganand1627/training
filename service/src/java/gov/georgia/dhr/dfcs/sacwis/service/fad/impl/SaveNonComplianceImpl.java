package gov.georgia.dhr.dfcs.sacwis.service.fad.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceCbx;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceChild;
import gov.georgia.dhr.dfcs.sacwis.db.NonComplianceChildId;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.fad.SaveNonCompliance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcCbx;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcEvent;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;



/**
 *
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 * 8/12/2008    CWells    Delete CheckBox selections before updating with new values 
 *  
 *  
 **/

public class SaveNonComplianceImpl extends BaseServiceImpl implements SaveNonCompliance {
  private CapsCaseDAO capsCaseDAO;

  private CapsResourceDAO capsResourceDAO;

  private EmployeeDAO employeeDAO;
  
  private EventDAO eventDAO;

  private NonComplianceCbxDAO nonComplianceCbxDAO;

  private NonComplianceChildDAO nonComplianceChildDAO;

  private NonComplianceDAO nonComplianceDAO;

  private PersonDAO personDAO;

  private PlacementDAO placementDAO;

  private StageDAO stageDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;
  
  private TodoDAO todoDAO;
  
  private UnitDAO unitDAO;
  
  private UnitEmpLinkDAO unitEmpLinkDAO;

  // offsets into the Object[] returned by the placementDAO lookup
  private static final int OFFSET_idPerson = 0;

  private static final int OFFSET_idStage = 1;
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO){
    this.employeeDAO = employeeDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setNonComplianceCbxDAO(NonComplianceCbxDAO nonComplianceCbxDAO) {
    this.nonComplianceCbxDAO = nonComplianceCbxDAO;
  }

  public void setNonComplianceChildDAO(NonComplianceChildDAO nonComplianceChildDAO) {
    this.nonComplianceChildDAO = nonComplianceChildDAO;
  }

  public void setNonComplianceDAO(NonComplianceDAO nonComplianceDAO) {
    this.nonComplianceDAO = nonComplianceDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO){
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public NonComplianceSO saveNonCompliance(NonComplianceSI input) {
    NonComplianceSO nonComplianceSO = new NonComplianceSO();
    NonCompliance nonCompliance = new NonCompliance();

    nonCompliance.setCapsCase(capsCaseDAO.findCapsCaseByIdCase(input.getIdCase()));
    nonCompliance.setCdCounty(input.getCdCounty());
    nonCompliance.setCdNonCompliance(input.getCdNonCompliance());
    nonCompliance.setDtEffectFrom(input.getDtEffectFrom());
    nonCompliance.setDtEffectTo(input.getDtEffectTo());
    nonCompliance.setDtOfViolation(input.getDtOfViolation());
    nonCompliance.setDtTracking(input.getDtTracking());
    nonCompliance.setIdNonCompliance(input.getIdNonCompliance());
    nonCompliance.setDtLastUpdate(input.getDtLastUpdate());
    nonCompliance.setIndDocCompleted(input.getIndDocCompleted());
    nonCompliance.setCdCounty(input.getCdCounty());
    nonCompliance.setTxtComments(input.getTxtComments());
    nonCompliance.setIndStOffConcurrence(input.getIndStOffCon());
    nonCompliance.setDtStOffConcurrence(input.getDtStOffCon());
    nonCompliance.setIndCpaConcurrence(input.getIndCpaCon());
    nonCompliance.setDtCpaConcurrence(input.getDtCpaCon());
    NcEvent ncEvent = input.getEventBean();
    Event event = new Event();
    event.setIdEvent(ncEvent.getEventId());
    event.setDtLastUpdate(ncEvent.getDateLastUpdate());
    event.setStage(stageDAO.findStageByIdStage(ncEvent.getStageId()));
    event.setCdEventStatus(ncEvent.getEventStatusCode());
    event.setCdEventType(ncEvent.getEventTypeCode());
    event.setCapsCase(capsCaseDAO.findCapsCaseByIdCase(ncEvent.getCaseId()));
    event.setPerson(personDAO.findPersonByIdPerson(ncEvent.getPersonId()));
    event.setCdTask(ncEvent.getEventTaskCode());
    event.setDtEventOccurred(ncEvent.getDateEventOccurred());
    event.setTxtEventDescr(ncEvent.getEventDescription());
    int savedEventId = eventDAO.saveEventReturnsEventId(event);
    event = eventDAO.findEventByIdEvent(savedEventId);
    nonCompliance.setEvent(event);
    // Saving NonCompliance
    int idNonCompliance = nonComplianceDAO.saveNonComplianceReturnId(nonCompliance);
    // After saving load the NonComplianceDAO by querying the DB
    nonCompliance = nonComplianceDAO.findNonComplianceById(idNonCompliance);

    
    // STGAP00009834 Removing all old Cbx selections to replace with new entires
    nonComplianceCbxDAO.deleteNonComplianceCbxByIdNonCompliance(idNonCompliance);
    
    
    // Saving NonComplianceCbx
    Iterator<NcCbx> itrNcCbx = input.getNcCbx().iterator();
    while (itrNcCbx.hasNext()) {
      NcCbx ncCbx = itrNcCbx.next();
      NonComplianceCbx nonComplianceCbx = new NonComplianceCbx();
      nonComplianceCbx.setIdNonComplianceCbx(ncCbx.getIdNonComplianceCbx());
      nonComplianceCbx.setDtLastUpdate(ncCbx.getDtLastUpdate()); 
      nonComplianceCbx.setNonCompliance(nonCompliance);
      nonComplianceCbx.setCdNonComplianceCbx(ncCbx.getCdNonComplianceCbx());
      nonComplianceCbx.setCdNonComplianceCbxType(ncCbx.getCdNonComplianceCbxType());
      nonComplianceCbxDAO.saveNonComplianceCbx(nonComplianceCbx);
    }
    // Saving NonComplianceChild
    Iterator<NcPerson> itrChildren = input.getChildrenInHome().iterator();
    List<NonComplianceChild> nonComplianceChildList = null;
    if (input.isUpdateFlag()) {
      nonComplianceChildList = nonComplianceChildDAO.findNonComplianceChildbyIdNonCompliance(idNonCompliance); 
    }
    NonComplianceChild nonComplianceChild = null;
    // Basically Non Compliance Child will be updated in case of update flag is true
    while (itrChildren.hasNext()) {
      NcPerson ncPerson = itrChildren.next();
      
      NonComplianceChildId nonComplianceChildId = new NonComplianceChildId();
      nonComplianceChildId.setIdNonCompliance(idNonCompliance);
      nonComplianceChildId.setIdPerson(ncPerson.getIdPerson());
      if (input.isUpdateFlag()) {
        for(int i = 0; i < nonComplianceChildList.size(); i++) {
          if (nonComplianceChildList.get(i).getId().getIdPerson() == ncPerson.getIdPerson()){
            nonComplianceChild = nonComplianceChildList.get(i);
          }
        }
     }else{
        nonComplianceChild = new NonComplianceChild();
        nonComplianceChild.setId(nonComplianceChildId);
        nonComplianceChild.setDtLastUpdate(ncPerson.getDtLastUpdate());
      }
      nonComplianceChild.setIndAdoptiveProcess(ncPerson.getIndAdoptiveProcess());
      nonComplianceChild.setIndHomeViolation(ncPerson.getIndHomeViolation());
      nonComplianceChildDAO.saveNonComplianceChild(nonComplianceChild);
    }

    // Alerts should be saved only at the time of adding(inserts) a new Non Compliance (either
    // Policy Violation or Corrective Action Plan
    if (!input.isUpdateFlag() && ncEvent != null) {
      saveAlerts(input);
    }
    return nonComplianceSO;
  }

  /**
   * Saves an alert to the To do table
   * @param idLoggedinPerson
   * @param idPerson
   * @param idStage
   * @param rsrcName
   * @param times
   * @param nonComplianceType
   */
  private void createTodo(int idLoggedinPerson, int idPerson, int idStage, 
                          String rsrcName, String times,
                          String nonComplianceType){
    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setTxtTodoDesc(rsrcName + " has a" + times + nonComplianceType + ".");
    todo.setTxtTodoLongDesc("");

    Person persCrea = personDAO.findPersonByIdPerson(idLoggedinPerson);
    todo.setPersonByIdTodoPersCreator(persCrea);

    Person persAssigned = personDAO.findPersonByIdPerson(idPerson);
    todo.setPersonByIdTodoPersAssigned(persAssigned);

    CapsCase capsCase = null;
    todo.setCapsCase(capsCase);
    todo.setIdTodo(0);

    Stage stage = stageDAO.findStageByIdStage(idStage);
    todo.setStage(stage);
    // Send Alert to Case Manager
    todoDAO.saveTodo(todo);
  }
  /**
   * Returns true/false if the idPerson already exist in the list. 
   * @param idPerson
   * @param alertSentList
   * @return boolean
   */
  private boolean isAlertSentAlready(int idPerson, ArrayList<Integer> alertSentList){
    boolean alertSentFlag = false; 
    for (int i = 0; i < alertSentList.size(); i++){
      if (alertSentList.get(i) == idPerson){
        alertSentFlag = true;
        break;
      }
    }
    return alertSentFlag;
  }
  /**
   * Saves alerts to the To do table
   * @param input
   */
  private void saveAlerts(NonComplianceSI input){
    NcEvent ncEvent = input.getEventBean();
    // Find the Primary Case manager for the FAD stage
    StagePersonLink stagePersonLink = stagePersonLinkDAO
                                                        .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                               ncEvent
                                                                                                                      .getStageId(),
                                                                                                               CodesTables.CSTFROLS_PR,
                                                                                                               CodesTables.CPRSNALL_STF);
    // Primary Case Manager idPerson
    int idPerson = stagePersonLink.getPerson().getIdPerson();

    // Count the number of non_compliance (either Corrective Action Plan or Policy Violation)
    // recorded for this resource.
    // If the count is 1, then send the alerts to Primary Case Manager and their Supervisor only
    // If the count is 2 or above then send the alerts all the way up to the Director whose
    // Employee class code is 'G1021'
    long countTotalNonCompRecs = nonComplianceDAO
                                                .countTotalNonComplianceByIdCaseCdNonCompliance(
                                                                                                ncEvent.getCaseId(),
                                                                                                input
                                                                                                .getCdNonCompliance());

    //Get the FAD Home (Resource Information) by passing the case id.
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdCase(ncEvent.getCaseId());
    String times = "";
    String nonComplianceType = "";
    if (CodesTables.CEVNTTYP_VLT.equals(input.getCdNonCompliance())) {
      nonComplianceType = " Policy Violation";
    } else if (CodesTables.CEVNTTYP_CRA.equals(input.getCdNonCompliance())) {
      nonComplianceType = " Corrective Action Plan";
    }
    times = (countTotalNonCompRecs > 1)? " multiple":"";
    //Construct an Alert Sent Array List that holds all the idPerson for whom the alerts are 
    //already sent. Use this List to avoid duplicate alerts sent to these idPerson.
    ArrayList<Integer> alertSentList = new ArrayList<Integer>();
    int idSupervisor = 0;
    // Sending alerts to the Case Managers/Supervisor of the FCC stage for each child currently
    // placed in the home
    List caseMgrList = placementDAO.findDistinctCaseManagerofFosterCareChildByResourceId(capsResource.getIdResource());

    for (Iterator it = caseMgrList.iterator(); it.hasNext();) {
      Object placement[] = (Object[])it.next();
      int idCaseManager = (Integer) placement[OFFSET_idPerson];
      int idStage = (Integer) placement[OFFSET_idStage];
      // Send an Alert to Case Manager and avoid duplicates by using flags.
      if(!isAlertSentAlready(idCaseManager, alertSentList)){
        createTodo(input.getIdLoggedInPerson(), idCaseManager, idStage, capsResource.getNmResource(), times,
                    nonComplianceType);
        alertSentList.add(idCaseManager);
      }
      // Sending alerts to Supervisor and avoid duplicates by using flags.
      idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idCaseManager);
      if(!isAlertSentAlready(idSupervisor, alertSentList)){
        createTodo(input.getIdLoggedInPerson(), idSupervisor, idStage, capsResource.getNmResource(), times,
                    nonComplianceType);
        alertSentList.add(idSupervisor);
      }
    }
    //Sending alerts to the Primary Case Manager of the FAD Home stage
    if(!isAlertSentAlready(idPerson, alertSentList)){
      createTodo(input.getIdLoggedInPerson(), idPerson, ncEvent.getStageId(), capsResource.getNmResource(), times,
               nonComplianceType);
      alertSentList.add(idPerson);
    }
   
    //Find the Case Manager's Supervisor
    idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idPerson);
    //Send alert to the Case Manager's Supervisor of the FAD Home stage
    if(!isAlertSentAlready(idSupervisor, alertSentList)){
      createTodo(input.getIdLoggedInPerson(), idSupervisor, ncEvent.getStageId(), capsResource.getNmResource(), times,
               nonComplianceType);
      alertSentList.add(idSupervisor);
    }
    if (countTotalNonCompRecs > 1) {
      //Sending alerts to Unit Director/County Director/Region Director/Deputy Director Program Policy &
      //Development/Director Program Policy & Development if it occurs more than once
      
      //Looping through to find the Hierarchy of Unit Director for Home, County Director and Regional Director 
      //Level as mentioned above for FAD Home stage starting from the Supervisor level (Not from the case manager)
      int idParentPerson = 0;
      List<Map> parentUnits = unitDAO.findParentUnitByIdPerson(idSupervisor);
      if (parentUnits != null && !parentUnits.isEmpty()){
        for (Iterator<Map> it = parentUnits.iterator(); it.hasNext();) {
          Map parentUnit = it.next();
          idPerson = (Integer)parentUnit.get("idPerson");
          // Send an Alert to the Hierarchy with the stage ID of home
          // Check and Send only to the persons that are not in the alertSentList to avoid duplication
          if(!isAlertSentAlready(idPerson, alertSentList)){
            createTodo(input.getIdLoggedInPerson(), idPerson, ncEvent.getStageId(), capsResource.getNmResource(), times,
                     nonComplianceType);
            alertSentList.add(idPerson);
          }
          idParentPerson = (Integer)parentUnit.get("idParentPerson");
          // Send an Alert to the Hierarchy with the stage ID of home
          // Check and Send only to the persons that are not in the alertSentList to avoid duplication
          if(!isAlertSentAlready(idParentPerson, alertSentList)){
            createTodo(input.getIdLoggedInPerson(), idParentPerson, ncEvent.getStageId(), capsResource.getNmResource(), times,
                     nonComplianceType);
            alertSentList.add(idParentPerson);
          }
        }
      }
      //Get the Director Program Policy and Development Employee record for cdEmpClass = 'G1021'. This should
      //always returns 1 record and send an alert.
      List<Integer> empList = employeeDAO.findIdPersonByAndCdEmpClass(CodesTables.CEMPJBCL_G1021);
      int directoryEmpId = 0;
      for (Iterator<Integer> empListIt = empList.iterator(); empListIt.hasNext();){
        directoryEmpId = empListIt.next();
        // Send an Alert to the Hierarchy with the stage ID of home
        // Check and Send only to the persons that are not in the alertSentList to avoid duplication
        if(!isAlertSentAlready(directoryEmpId, alertSentList)){
          createTodo(input.getIdLoggedInPerson(), directoryEmpId, ncEvent.getStageId(), capsResource.getNmResource(), times,
                   nonComplianceType);
          alertSentList.add(directoryEmpId);
        }
      }         
      //Get the Deputy Director Program Policy and Development Employee record for cdEmpClass = 'G1022'. This should
      //always returns 1 record and send an alert.
      empList = employeeDAO.findIdPersonByAndCdEmpClass(CodesTables.CEMPJBCL_G1022);
      for (Iterator<Integer> empListIt = empList.iterator(); empListIt.hasNext();){
        directoryEmpId = empListIt.next();
        // Send an Alert to the Hierarchy with the stage ID of home
        // Check and Send only to the persons that are not in the alertSentList to avoid duplication
        if(!isAlertSentAlready(directoryEmpId, alertSentList)){
          createTodo(input.getIdLoggedInPerson(), directoryEmpId, ncEvent.getStageId(), capsResource.getNmResource(), times,
                   nonComplianceType);
          alertSentList.add(directoryEmpId);
        }
      }
    }
  }
}
