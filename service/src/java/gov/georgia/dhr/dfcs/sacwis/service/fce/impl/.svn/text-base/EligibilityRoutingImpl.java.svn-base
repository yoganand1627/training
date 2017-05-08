package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EligibilityRouting;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveEligibilityAlert;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AssignSaveGroup_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *
 *  3/30/09      cwells            STGAP00012033 Made corrections to display the eligibility alerts correctly whenever a 
 *                                 Medicaid application is save and submitted.
 *
 **/
public class EligibilityRoutingImpl  extends BaseServiceImpl implements EligibilityRouting{
  
  public static final String INITIAL_MEDICAID = "IMA";
  public static final String FOSTER_CARE_APPLICATION = "FCA";
  
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private PersonDAO personDAO = null;
  private TodoDAO todoDAO = null;
  private SaveEligibilityAlert saveEligibilityAlert = null;
  
  public static final String SECONDARY = "SE";
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setSaveEligibilityAlert(SaveEligibilityAlert saveEligibilityAlert) {
    this.saveEligibilityAlert = saveEligibilityAlert;
  }

  public void eligibilityRouting(int idStage, int idUser, int idPerson, String eventType) throws ServiceException{
    Integer idPersonObject = stagePersonLinkDAO.findIdPersonByIdStageIdPersonAndCdStagePersRole(idStage, idPerson, SECONDARY);
    if(idPersonObject == null){
      String nmPersonFull= personDAO.findNmFullByIdPerson(idPerson);
      CCMN25SI ccmn25si = new CCMN25SI();
      AssignSaveGroup assignSaveGroup = new AssignSaveGroup();
      AssignSaveGroup_ARRAY assignSaveGroup_ARRAY = new AssignSaveGroup_ARRAY();
      AssignmentGroup_ARRAY assignmentGroup_ARRAY = retrieveStageByIdStageAndOrderByCdStagePersRole(idStage);
      Enumeration assignmentGroup_enum = assignmentGroup_ARRAY.enumerateAssignmentGroup();
      while (assignmentGroup_enum.hasMoreElements()) {
        AssignmentGroup assignmentGroup = (AssignmentGroup) assignmentGroup_enum.nextElement();
        assignSaveGroup.setUlIdStage(assignmentGroup.getUlIdStage());
        assignSaveGroup.setUlIdStagePerson(assignmentGroup.getUlIdStagePerson());
        assignSaveGroup.setSzCdStageProgram(assignmentGroup.getSzCdStageProgram());
        assignSaveGroup.setSzCdStageType(assignmentGroup.getSzCdStageType());  //SIR 23879
        assignSaveGroup.setUlIdCase(assignmentGroup.getUlIdCase());
        assignSaveGroup.setTsLastUpdate(assignmentGroup.getTsLastUpdate());
        break;
      }
      assignSaveGroup.setSzCdScrDataAction("A");
      assignSaveGroup.setSzNmPersonFull(nmPersonFull);
      assignSaveGroup.setUlIdPerson(idPerson);
      assignSaveGroup.setUlSysIdPriorPerson(idPerson);
      assignSaveGroup.setSzCdStagePersRole("SE");
      assignSaveGroup_ARRAY.addAssignSaveGroup(assignSaveGroup);
      ccmn25si.setAssignSaveGroup_ARRAY(assignSaveGroup_ARRAY);
      
      
      String cdStagePersType = CodesTables.CPRSNALL_STF;
      String cdStagePersSearchInd = ArchitectureConstants.N;
      String txtStagePersNotes = "";
      Date dtStagePersLink = new Date();
      String cdStagePersRelInt = "";
      String indStagePersReporter = ArchitectureConstants.N;
      String indStagePersInLaw = ArchitectureConstants.N;
      String cdStagePersRole = assignSaveGroup.getSzCdStagePersRole();
      String indStagePersEmpNew = "1";
      int idCase = assignSaveGroup.getUlIdCase();
      
      int stagePersonLinkRow = stagePersonLinkDAO.insertStagePersonLink(idStage, idPerson, cdStagePersRole,
                                                                        cdStagePersType, cdStagePersSearchInd,
                                                                        txtStagePersNotes, dtStagePersLink,
                                                                        cdStagePersRelInt, indStagePersReporter,
                                                                        indStagePersInLaw, indStagePersEmpNew);
      if (stagePersonLinkRow == 0) {
        throw new ServiceException(Messages.MSG_CMN_DUP_SP_LINK);
      }
      if(FOSTER_CARE_APPLICATION.equals(eventType)){
        callSaveTodo(assignSaveGroup, idUser);
      }
    }else if(FOSTER_CARE_APPLICATION.equals(eventType)){
      // STGAP00012033 Secondary Worker has already been assigned but we still need to create the Todo for the Foster
      // Care Application
      callSaveTodo(idStage, idPerson);
    }
    if(INITIAL_MEDICAID.equals(eventType)){
      // STGAP00012033 
      Stage stageAndCase = stageDAO.findStageAndCapsCase(idStage);  
      int idCase = stageAndCase.getCapsCase().getIdCase() != null ? stageAndCase.getCapsCase().getIdCase() : 0;
      saveEligibilityAlert.saveEligibilityAlert(idPerson, idUser, idStage, idCase, INITIAL_MEDICAID);
    }
  }
  
  public AssignmentGroup_ARRAY retrieveStageByIdStageAndOrderByCdStagePersRole(int idStage){
    AssignmentGroup_ARRAY assignmentGroupArray = new AssignmentGroup_ARRAY();
    List<Map> stageInfo = stageDAO.findStageByIdStageAndOrderByCdStagePersRole(idStage);
    if (stageInfo == null || stageInfo.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    for (Iterator<Map> it = stageInfo.iterator(); it.hasNext();) {
      Map stageMap = it.next();
      AssignmentGroup assignmentGroup = new AssignmentGroup();
      assignmentGroup.setSzNmStage((String) stageMap.get("nmStage"));
      assignmentGroup.setSzNmPersonFull((String) stageMap.get("nmPersonFull"));
      assignmentGroup.setSzCdStagePersRole((String) stageMap.get("cdStagePersRole"));
      assignmentGroup.setUlIdStage((Integer) stageMap.get("idStage") != null ? (Integer) stageMap.get("idStage") : 0);
      assignmentGroup.setUlIdPerson((Integer) stageMap.get("idPerson") != null ?
                                    (Integer) stageMap.get("idPerson") : 0);
      assignmentGroup.setUlIdStagePerson((Integer) stageMap.get("idStagePersonLink") != null ?
                                         (Integer) stageMap.get("idStagePersonLink") : 0);
      assignmentGroup.setUlIdCase((Integer) stageMap.get("idCase") != null ? (Integer) stageMap.get("idCase") : 0);
      assignmentGroup.setSzCdStage((String) stageMap.get("cdStage"));
      assignmentGroup.setSzCdStageProgram((String) stageMap.get("cdStageProgram"));
      assignmentGroup.setSzCdStageType((String) stageMap.get("cdStageType"));
      assignmentGroup.setSzCdStageCnty((String) stageMap.get("cdStageCnty"));
      assignmentGroup.setTsLastUpdate(((Date) stageMap.get("dtLastUpdate")));
      assignmentGroupArray.addAssignmentGroup(assignmentGroup);
    }
    return assignmentGroupArray;
  }
  
  private void callSaveTodo(AssignSaveGroup assignSaveGroup, int idPersCreator) {

    int idStage = assignSaveGroup.getUlIdStage();
    int idPerson = assignSaveGroup.getUlIdPerson();
    int idCase = assignSaveGroup.getUlIdCase();
    int sysIdPriorPerson = assignSaveGroup.getUlSysIdPriorPerson();
    String dataAction = assignSaveGroup.getSzCdScrDataAction();
    
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
    
    String desc = "An FCEA Initial/Amended App or Notification of Change is ready to be assigned.";

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
      todo.setTxtTodoDesc(desc);
      Person persWorker = (Person) getPersistentObject(Person.class, sysIdPriorPerson);
      todo.setPersonByIdTodoPersWorker(persWorker);

      Person persAssigned = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersAssigned(persAssigned);
    } 
    todoDAO.saveTodo(todo);
  }
  private void callSaveTodo(int idStage , int idPerson) {
    Stage stage = getPersistentObject(Stage.class, idStage);
    int idCase = stage.getCapsCase()!= null ? stage.getCapsCase().getIdCase() : 0;
    
    Todo todo = new Todo();
    todo.setCdTodoTask("");
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoTaskDue(null);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoDue(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setTxtTodoLongDesc(null);

    Person persCreator = (Person) getPersistentObject(Person.class, idPerson);
    todo.setPersonByIdTodoPersCreator(persCreator);

    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
    todo.setCapsCase(capsCase);

    todo.setIdTodo(0);
    todo.setStage(stage);
    
    String desc = "An FCEA Initial/Amemded App or Notification of Change is ready to be assigned.";

      todo.setTxtTodoDesc(desc);
      Person persWorker = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersWorker(persWorker);
      Person persAssigned = (Person) getPersistentObject(Person.class, idPerson);
      todo.setPersonByIdTodoPersAssigned(persAssigned);
    
    todoDAO.saveTodo(todo);
  }
}
