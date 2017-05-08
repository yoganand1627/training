package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StffAsgnmtHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAssign;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight; //mxpatel added this for defect #9451
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN25SO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/*Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  10/28/08  mxpatel           STGAP00009451 added an if statement to check if the employee is
                              MES Program assistant, if so display an alert in case todo list.
*/

public class SaveAssignImpl extends BaseServiceImpl implements SaveAssign {

  public static final String REASON_CODE_01 = "01";

  public static final String REASON_CODE_02 = "02";

  public static final String INTAKE_APS = "B";

  public static final String INTAKE = "C";

  public static final String INTAKE_NON_INT = "D";

  public static final String INTAKE_FULL_SVC = "E";

  public static final String NON_INT_FUL_SVC = "F";

  public static final String NON_INT_FAD = "G";

  public static final String CAPS_REGION_SWI = CodesTables.CREGDIV_515;

  public static final int CAPS_REGION_MAX = 99;

  public static final String CAPS_UNIT_SWI = CodesTables.CREGIONS_00;

  public static final String CAPS_UNIT_STATE_OFFICE = CodesTables.CREGIONS_99;
  
  public static final String NEW_PRIMARY_ASSIGN_ALERT = "NewAlert";
  
  public static final String INTAKE_REPORT_ALERT = "IntakeAlert";
  
  public static final String SUPERVISOR = "Supervisor";
  
  public static final String STRING_SPECIALIST_NUM = "83";//mxpatel added this for defect #9451
  
  

  private CapsCaseDAO capsCaseDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  // ccmn81d
  private EmployeeDAO employeeDAO = null;

  private PostEvent postEvent = null;

  // ccmngod
  private StageDAO stageDAO = null;

  // ccmn80d
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  // ccmn99d, ccmn43d
  private TodoDAO todoDAO = null;

  // ccmna1d,ccmngod,ccmng1d
  private UnitDAO unitDAO = null;

  private StffAsgnmtHistoryDAO stffAsgnmtHistoryDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  private CheckIfUserHasRight checkIfUserHasRight;//mxpatel added this for defect #9451

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }
  
  //mxpatel added this for defect #9451
  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }
  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setStffAsgnmtHistoryDAO(StffAsgnmtHistoryDAO stffAsgnmtHistoryDAO) {
    this.stffAsgnmtHistoryDAO = stffAsgnmtHistoryDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CCMN25SO saveAssign(CCMN25SI ccmn25si) throws ServiceException {

    CCMN25SO ccmn25so = new CCMN25SO();

    String reqFuncCd = ccmn25si.getArchInputStruct().getCReqFuncCd();
    int ulIdPersonCreator = ccmn25si.getUlIdPerson();
    boolean isMesProgramAssistant = ccmn25si.getIndMesProgramAssistant();
    Enumeration assignSaveGroup_enum = ccmn25si.getAssignSaveGroup_ARRAY().enumerateAssignSaveGroup();

    while (assignSaveGroup_enum.hasMoreElements()) {
      AssignSaveGroup assignSaveGroup = (AssignSaveGroup) assignSaveGroup_enum.nextElement();
      // Call CheckStageEventStatus
      int idStage = assignSaveGroup.getUlIdStage();
      int idPerson = assignSaveGroup.getUlIdPerson();
      int idPriorPerson = assignSaveGroup.getUlSysIdPriorPerson();
      String nmPersonFull = assignSaveGroup.getSzNmPersonFull();
      callCheckStageEventStatus(idStage);

      // Based upon the value of pInputMsg->ArchInputStruct.cReqFuncCd,
      // the following should happen:
      // UNDETERMINED no telling - this should never be passed in
      // INTAKE_APS call full service + stage prog -- This was removed since there will no longer be APS
      // INTAKE only post event
      // INTAKE_NON_INT only post event
      // NON_INT_FAD only post event
      // INTAKE_FULL_SVC call full service
      // NON_INT_FUL_SV call full service
      // NON_INT_FAD only post event
      if (INTAKE.equals(reqFuncCd) || INTAKE_NON_INT.equals(reqFuncCd) || NON_INT_FAD.equals(reqFuncCd)) {

        // Only post the "Primary Assignment Issued" event        
        callPostEvent(idStage, idPerson, ulIdPersonCreator, nmPersonFull);
        
        break;

      } else if (NON_INT_FUL_SVC.equals(reqFuncCd) || INTAKE_FULL_SVC.equals(reqFuncCd)) {

        // Perform "full service functionality" (i.e, update
        // the stage_person_link table, send ToDos, etc.)

        String dataAction = assignSaveGroup.getSzCdScrDataAction();

        String cdStagePersType = CodesTables.CPRSNALL_STF;
        String cdStagePersSearchInd = ArchitectureConstants.N;
        String txtStagePersNotes = "";
        Date dtStagePersLink = new Date();
        String cdStagePersRelInt = "";
        String indStagePersReporter = ArchitectureConstants.N;
        String indStagePersInLaw = ArchitectureConstants.N;
        String cdStagePersRole = assignSaveGroup.getSzCdStagePersRole();
        Date tsLastUpdate = assignSaveGroup.getTsLastUpdate();
        int idStagePerson = assignSaveGroup.getUlIdStagePerson();

        String indStagePersEmpNew = "1";

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
          // CallCCMN80D
          int stagePersonLinkRow = stagePersonLinkDAO.insertStagePersonLink(idStage, idPerson, cdStagePersRole,
                                                                            cdStagePersType, cdStagePersSearchInd,
                                                                            txtStagePersNotes, dtStagePersLink,
                                                                            cdStagePersRelInt, indStagePersReporter,
                                                                            indStagePersInLaw, indStagePersEmpNew);
          if (stagePersonLinkRow == 0) {
            throw new ServiceException(Messages.MSG_CMN_DUP_SP_LINK);
          }
          // Ccmn19s.CallCCMN43D
          callSaveTodo(assignSaveGroup, reqFuncCd, ulIdPersonCreator, isMesProgramAssistant, null);

        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(dataAction)) {

          // CallCCMN80D
          int stagePersonLinkrow = stagePersonLinkDAO.updateStagePersonLink(idStage, idPerson, cdStagePersRole,
                                                                            cdStagePersType, cdStagePersSearchInd,
                                                                            txtStagePersNotes, dtStagePersLink,
                                                                            cdStagePersRelInt, indStagePersReporter,
                                                                            indStagePersInLaw, indStagePersEmpNew,
                                                                            idStagePerson, tsLastUpdate);
          if (stagePersonLinkrow == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }

          // Both primary and secondary assignments can
          // have a data action of UPDATE, but we only
          // want to perform the "primary worker changed"
          // actions if it was the primary worker changed:
          // 1) post "Primary Assignment" event
          // 2) create "Primary Assignment" ToDo
          // 3) reassign all of the prior primary worker's
          // ToDo's to the new worker
          // 4) send the new worker's supervisor a ToDo
          // 5) update the worker's DT_LAST_ASSIGNED
          // 6) set the stage's region and unit to the
          // new primary worker's region and unit
          // 7) set the case's region to the new primary
          // worker's region
          //
          if (CodesTables.CSTFROLS_PR.equals(cdStagePersRole)) {

            // Post the "Primary Assignment" event           
            callPostEvent(idStage, idPerson, ulIdPersonCreator, nmPersonFull);

            // create "Primary Assignment" ToDo
            // CallCCMN43D
            callSaveTodo(assignSaveGroup, reqFuncCd, ulIdPersonCreator, isMesProgramAssistant, NEW_PRIMARY_ASSIGN_ALERT);
                        
            //create "An Intake report with a response time of <response time> has been assigned to your workload." when the INTAKE case
            // is assigned to Case Manager
            Stage stage = stageDAO.findStageByIdStage(idStage);
            if(CodesTables.CTXTOGA_INT.equals(stage.getCdStage())){
              callSaveTodo(assignSaveGroup, reqFuncCd, ulIdPersonCreator, isMesProgramAssistant, INTAKE_REPORT_ALERT);
            }
            
            callSaveTodoForCountyDirector(assignSaveGroup, ulIdPersonCreator);

            // Create todo for an Intake report with a response time of <response time> has been assigned to your
            // workload.
            // callSaveTodoForResponseTime(assignSaveGroup, reqFuncCd, ulIdPersonCreator);

            // reassign all of the prior primary worker's
            // ToDo's to the new worker
            // rc = CallCCMN99D(ccmn25si, ccmn25so, row, pServiceStatus);
            todoDAO.updateTodo(idPerson, idPriorPerson, idStage);

            // update the staff assignment history with the assignment changes
            updateStffAsgnmtHistory(assignSaveGroup, ulIdPersonCreator);

            int idUnit = assignSaveGroup.getUlIdUnit();
            // determine the Unit Supervisor/Approver
            // CallCCMNA1D(ccmn25si, ccmn25so, row, pServiceStatus);
            Unit unit = unitDAO.findUnitByIdUnit(idUnit);
            if (unit == null) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            // If the Unit Supervisor/Approver IS NOT the
            // worker who received the new assignment
            // then:
            // Create a ToDo for the Unit
            // Supervisor/Approver indicating the new
            // assignment
            int unitSupervisor = unit.getPerson().getIdPerson();
            if (unitSupervisor != idPerson) {
              Person unitSupervisorPerson = retrieveUnitSupervisorByCaseManagerId(idPerson);
              if(unitSupervisorPerson != null){
                if(unitSupervisorPerson.getIdPerson() != idPerson){
                  // Pass in a temporary reqfunccd of "S" for supervisor todo
                  // Ccmn19s.CallCCMN43D
                  callSaveTodo(assignSaveGroup, "S", ulIdPersonCreator, isMesProgramAssistant, NEW_PRIMARY_ASSIGN_ALERT);
                  
                  //create "An Intake report with a response time of <response time> has been assigned to your workload." when the INTAKE case
                  // is assigned to Case Manager
                  if(CodesTables.CTXTOGA_INT.equals(stage.getCdStage())){
                    callSaveTodo(assignSaveGroup, "S" , ulIdPersonCreator, isMesProgramAssistant, INTAKE_REPORT_ALERT);
                  }
                }
              }
            }

            // update Dt_Last_Assigned on the Employee Table
            // rc = CallCCMN81D(ccmn25si, ccmn25so, row, pServiceStatus);
            if (0 == employeeDAO.updateDtEmpLastAssigned(idPerson, ccmn25si.getUlIdEmployee())) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            //STGAP00009893 - get the unit id of the case manager who the case is being transferred to and if their unit is different from the current unit
            //(that is if they are "OUT" assigned to the unit) use the idUnit of the new case manager to update the stage table
            UnitEmpLink unitEmpLink = unitEmpLinkDAO.findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(idPerson, CodesTables.CUMINOUT_IN);
            if (unitEmpLink == null){
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }
            Unit unit1 = unitEmpLink.getUnit();
            int newIdUnit = unit1.getIdUnit() != null ? unit1.getIdUnit().intValue() : 0;
            if (newIdUnit == idUnit) {
              // STGAP00009653 - update stage's unit only. Modified DAO signature since this method is only called from
              // here.
              if (0 == stageDAO.updateStageIdUnitByIdStage(idUnit, idStage)) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
            }else{
              if (0 == stageDAO.updateStageIdUnitByIdStage(newIdUnit, idStage)) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
            }
           /* //STGAP00007728 - called unitEmpLinkDAO to hit the UNIT_EMP_LINK table to trigger a count on the workload
            int updateUnitEmpLinkCount = unitEmpLinkDAO.updateUnitEmpLink(idPerson, CodesTables.CUMINOUT_IN);
            unitEmpLinkDAO.updateUnitEmpLink(idPerson, CodesTables.CUMINOUT_OUT);
            if (0 == updateUnitEmpLinkCount) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }*/
/* STGAP00009653 - Staff assignment is no longer updating Stage region. It is still updating stage's unit as before.
 * Did not add a new DAO method but changed the existing instead to update only stage's idUnit since that method is only called from here.
            // Added below logic to convert three digit Unit Region to two digit Unit region.
            String cdUnitRegion = unit.getCdUnitRegion();
            if (cdUnitRegion.length() == 3) {
              cdUnitRegion = cdUnitRegion.substring(1, 3);
            }

            // removed the call to ccmng0d, the region is available from the unit structure

            // Need to have unit call
            // update IdUnit and CdStageRegion on the
            // Stage table

            // rc = CallCCMNB7D(ccmn25si, ccmn25so, row, pServiceStatus);
            if (0 == stageDAO.updateStageIdUnitCdStageRegionByIdStage(idUnit, idStage, cdUnitRegion)) {
              throw new ServiceException(Messages.SQL_NOT_FOUND);
            }

            // Only update the case region if the stage has an ID case,
            // certain intake stages will not have an idcase
            int idCase = assignSaveGroup.getUlIdCase();
            if (0 != idCase) {
              // update CdCaseRegion on the Caps_case table
              // rc = CallCCMNG1D(ccmn25si, ccmn25so, row, pServiceStatus);
              if (0 == capsCaseDAO.updateCapsCaseCdCaseRegion(idCase, cdUnitRegion)) {
                throw new ServiceException(Messages.SQL_NOT_FOUND);
              }
            }// end if idcase !=0
End STGAP00009653 */            
          } // end if the role is primary
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction)) {
          StagePersonLink stagePersonLink = new StagePersonLink();
          stagePersonLink.setIdStagePersonLink(idStagePerson);
          stagePersonLink.setDtLastUpdate(tsLastUpdate);
          // Added the following four lines to make the object "stagePersonLink" persistent
          Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
          stagePersonLink.setStage(stage);
          Person person = (Person) getPersistentObject(Person.class, idPerson);
          stagePersonLink.setPerson(person);
          // CallCCMN80D
          stagePersonLinkDAO.deleteStagePersonLink(stagePersonLink);

          // Transfer all Outstanding ToDos to the Primary
          // worker(this will only happen for secondary workers
          // rc = CallCCMN99D(ccmn25si, ccmn25so, row, pServiceStatus)
          todoDAO.updateTodo(idPriorPerson, idPerson, idStage);
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
    return ccmn25so;
  }

  private void callPostEvent(int idStage, int idPerson, int ulIdPersonCreator, String personFull) throws ServiceException {

    // AssignSaveGroup assignSaveGroup = ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(row);
    CCMN01UI ccmn01ui = new CCMN01UI();

    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
    ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
    // setting rowccmn01uig01 with appropriate values - idPerson and dataAction
    ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
    //This field will be the IdPerson of the user logged into the system
    rowccmn01uig01.setUlIdPerson(idPerson);
    rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    // creating and setting the list/array object
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);

    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());//STGAP00000956
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_ASG);
    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setUlIdPerson(ulIdPersonCreator);
    rowccmn01uig00.setSzTxtEventDescr("Primary Assignment Issued For: " + personFull);

    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    postEvent.postEvent(ccmn01ui);

  }

  private void callCheckStageEventStatus(int idStage) throws ServiceException {

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(null);

    // Ccmn06u.CheckStageEventStatus
    checkStageEventStatus.status(ccmn06ui);

  }

  private void callSaveTodo(AssignSaveGroup assignSaveGroup, String reqFuncCd, int idPersCreator, boolean isMesProgramAssistant, String alert) {

    // AssignSaveGroup assignSaveGroup = ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(row);
    int idStage = assignSaveGroup.getUlIdStage();
    int idPerson = assignSaveGroup.getUlIdPerson();
    int idCase = assignSaveGroup.getUlIdCase();
    int sysIdPriorPerson = assignSaveGroup.getUlSysIdPriorPerson();
    String dataAction = assignSaveGroup.getSzCdScrDataAction();
    String personFull = assignSaveGroup.getSzNmPersonFull();
    
    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setTxtTodoLongDesc(null);

    Person persCreator = (Person) getPersistentObject(Person.class, idPersCreator);
    todo.setPersonByIdTodoPersCreator(persCreator);

    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
    todo.setCapsCase(capsCase);

    todo.setIdTodo(0);

    Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
    todo.setStage(stage);
    
    //mxpatel wrote this IF statement for defect #9451
    if(idPerson != idPersCreator){
      if(!checkIfUserHasRight.determineIfUserHasRight(idPerson, STRING_SPECIALIST_NUM)){
        isMesProgramAssistant = false;
      }
      else{
        isMesProgramAssistant = true;
      }
    }

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
      todo.setTxtTodoDesc("New Secondary Assignment");
      Person persWorker = (Person) getPersistentObject(Person.class, sysIdPriorPerson);
      todo.setPersonByIdTodoPersWorker(persWorker);

      Person persAssigned = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersAssigned(persAssigned);
      if(isMesProgramAssistant){
        Person personSupervisor = retrieveUnitSupervisorByCaseManagerId(idPerson);
        if(personSupervisor != null){
          Todo todoSuper = new Todo();
          todoSuper.setCdTodoTask("");
          todoSuper.setCdTodoType(CodesTables.CTODOTYP_A);
          todoSuper.setDtTodoTaskDue(null);
          todoSuper.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
          todoSuper.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
          todoSuper.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
          todoSuper.setTxtTodoLongDesc(null);
          
          persCreator = (Person) getPersistentObject(Person.class, idPersCreator);
          todoSuper.setPersonByIdTodoPersCreator(persCreator);
          
          capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
          todoSuper.setCapsCase(capsCase);
          
          todoSuper.setIdTodo(0);
          
          stage = (Stage) getPersistentObject(Stage.class, idStage);
          todoSuper.setStage(stage);
          
          todoSuper.setTxtTodoDesc("MES Worker has been added to the Foster Care Stage as Secondary Assignment");
          persWorker = (Person) getPersistentObject(Person.class, sysIdPriorPerson);
          todoSuper.setPersonByIdTodoPersWorker(persWorker);
          
          todoSuper.setPersonByIdTodoPersAssigned(personSupervisor);
          todoDAO.saveTodo(todoSuper);
        }
      }

    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(dataAction)) {

      Person persWorker = (Person) getPersistentObject(Person.class, sysIdPriorPerson);
      todo.setPersonByIdTodoPersWorker(persWorker);
      
      if("S".equals(reqFuncCd)){
        Person unitSupervisor =  retrieveUnitSupervisorByCaseManagerId(idPerson);
          // Generate these alert when case is assigned to other case worker
          if(NEW_PRIMARY_ASSIGN_ALERT.equals(alert)){ 
            todo.setTxtTodoDesc("New Primary Assignment for: " + personFull);
          }else if(INTAKE_REPORT_ALERT.equals(alert)){
            todo.setTxtTodoDesc("An Intake report with a response time of " + stage.getCdStageCurrPriority()
                                + " has been assigned to your workload");
          }
          todo.setPersonByIdTodoPersAssigned(unitSupervisor);
      }else{
        // Generate these alert when case is assigned to other case worker
        if(NEW_PRIMARY_ASSIGN_ALERT.equals(alert)){ 
          todo.setTxtTodoDesc("New Primary Assignment for: " + personFull);
        }else if(INTAKE_REPORT_ALERT.equals(alert)){
          todo.setTxtTodoDesc("An Intake report with a response time of " + stage.getCdStageCurrPriority()
                              + " has been assigned to your workload");
        }
        Person persAssigned = (Person) getPersistentObject(Person.class, idPerson);
        todo.setPersonByIdTodoPersAssigned(persAssigned);
      }
    }

    // Ccmn19s.CallCCMN43D
    todoDAO.saveTodo(todo);
  }

  /*
   * updates the StffAsgnmtHistory table
   * 
   */
  private int updateStffAsgnmtHistory(AssignSaveGroup assignSaveGroup, int idPersCreator) {

    int idStage = assignSaveGroup.getUlIdStage();
    int idPerson = assignSaveGroup.getUlIdPerson();
    int idCase = assignSaveGroup.getUlIdCase();
    int sysIdPriorPerson = assignSaveGroup.getUlSysIdPriorPerson();

    return stffAsgnmtHistoryDAO.insertStffAsgnmtHistory(sysIdPriorPerson, idPerson, idPersCreator, idStage, idCase);
  }
  
  //
  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {
    // CallCCMN60D
    // this retrieve finds the unit supervisor's id.
    Integer idSupervisor = unitEmpLinkDAO.findUnitSupervisorByIdPerson(idPerson);
    if (idSupervisor == null ) {
        return null;
    }
    return getPersistentObject(Person.class, idSupervisor);
  }
  
  private void callSaveTodoForCountyDirector(AssignSaveGroup assignSaveGroup, int idPersCreator){
    int idStage = assignSaveGroup.getUlIdStage();
    int idPerson = assignSaveGroup.getUlIdPerson();
    int idCase = assignSaveGroup.getUlIdCase();
    String personFull = assignSaveGroup.getSzNmPersonFull();
    int idCountyDirector = 0;
    
    Unit unit = unitDAO.findUnitByIdUnit(assignSaveGroup.getUlIdUnit());
    String cdCounty = unit.getCdCounty();
    List<String> securityClass = new ArrayList<String>();
    securityClass.add("COUNTY_DIRECTOR");
     
    List<Integer> countyDirector = employeeDAO.findIdPersonByJobSecurityRole(cdCounty, securityClass);
    for (Iterator<Integer> it = countyDirector.iterator(); it.hasNext();) {
      Integer idCD  = it.next();
      idCountyDirector = Integer.parseInt(idCD.toString());
      break;
    }
    
    if(idCountyDirector != 0){
      Todo todo = new Todo();
      todo.setCdTodoTask("");
      todo.setCdTodoType(CodesTables.CTODOTYP_A);
      todo.setDtTodoTaskDue(null);
      todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
      todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
      todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
      todo.setTxtTodoLongDesc(null);
      
      Person persCreator = (Person) getPersistentObject(Person.class, idPersCreator);
      todo.setPersonByIdTodoPersCreator(persCreator);
      
      CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
      todo.setCapsCase(capsCase);
      
      todo.setIdTodo(0);
      
      Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
      todo.setStage(stage);
      todo.setTxtTodoDesc(personFull + " has made an assignment over the policy limit");
      Person persWorker = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersWorker(persWorker);
      
      Person persAssigned = (Person) getPersistentObject(Person.class, idCountyDirector);
      todo.setPersonByIdTodoPersAssigned(persAssigned);
      todoDAO.saveTodo(todo);
    }
  }
}