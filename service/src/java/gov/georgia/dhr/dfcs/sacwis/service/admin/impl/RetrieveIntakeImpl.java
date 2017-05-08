package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveIntake;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoCaseInfStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignedStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreatedStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TaskStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TodoInfoStruct;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RetrieveIntakeImpl extends BaseServiceImpl implements RetrieveIntake {

  private static final String WINDOW_MODE_NEW_APPRV = "X";
  private static final String WINDOW_MODE_NEXT_APPRV = "Y";
  private static final String WINDOW_MODE_ASSIGN = "Z";
  public static final String SPECIAL_INVESTIGATION_TASK = "2270";
  public static final String SPCL_INV_APPROVAL_TASK = "2265";
  public static final String APPROVE_SAFETY_RESOURCE = "7332";
  public static final String APPROVE_SAFETY_RESOURCE_ONG = "7333";
  public static final String SUPERVISOR = "Supervisor";
  public static final String COUNTY_DIRECTOR = "County Director";
  public static final String POLICY_UNIT = "Policy Unit";
  public static final String DEPUTY_DIRECTOR = "Deputy Director";
  public static final String DEPUTY_DIRECTOR_SEC_CLASS = "DEPUTY_DIRECTOR";
  public static final String PRU_STAFF_SECURITY_CLASS_NAME = "STATE_CONC";
  private static final String NBR_UNIT_COUNTY_DIRECTOR = "18";
  public static final String VACANT_PERSON = "Vacant";

  private static final String SYSTEM_NAME = "System";

  private EmpTempAssignDAO empTempAssignDAO = null;
  private PersonDAO personDAO = null;
  private TaskDAO taskDAO = null;
  private UnitDAO unitDAO = null;
  private TodoDAO todoDAO = null;
  private StageDAO stageDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }
  
  private static final Set<String> ADOPTION_ASSIT_TASK_CODES = new HashSet<String>() {
    {
      add("9116"); // ADO agreement
      add("9106"); // PAD agreement
      
      add("8351"); // ADO application
      add("8352"); // PAD application
    }
  };

  public CCMN13SO findIntakeInformation(CCMN13SI ccmn13si) throws ServiceException {
    CCMN13SO ccmn13so = new CCMN13SO();
    // Create empty structs so we can use them below.
    TaskStruct taskStruct = new TaskStruct();
    AssignedStruct assignedStruct = new AssignedStruct();
    TodoInfoStruct todoInfoStruct = new TodoInfoStruct();
    CreatedStruct createdStruct = new CreatedStruct();
    StageStruct stageStruct; // This is created by a helper method sometimes.

    String cReqFuncCd = ccmn13si.getArchInputStruct().getCReqFuncCd();
    TodoCaseInfStruct todoCaseInfStruct = ccmn13si.getTodoCaseInfStruct();
    int idStage = todoCaseInfStruct.getUlIdStage();
    String cdTask = todoCaseInfStruct.getSzCdTask();

    // get the system date
    Date systemDate = new Date();
    ccmn13so.setDtWCDDtSystemDate(DateHelper.toCastorDate(systemDate));
    ccmn13so.setTmTmWCDDtSystemTime(FormattingHelper.formatTime(systemDate));
    
    taskStruct.setDtDtTaskDue(null);
    if (WINDOW_MODE_NEW_APPRV.equals(cReqFuncCd) || WINDOW_MODE_NEXT_APPRV.equals(cReqFuncCd)) {
      // ccmn89d -- get the user's supervisor by program
      // cjg - SHINES changed to use county
      Map map = null;
      if (isAdopAssistanceTask(cdTask)) {
        map = retrieveSAURegionStaff(todoCaseInfStruct.getUlIdCase());
        
      } else if (SPCL_INV_APPROVAL_TASK.equals(cdTask) && SUPERVISOR.equals(ccmn13si.getSzWhichSpclInvApprover())) {
        map = retrieveCountyDirector(todoCaseInfStruct.getSzCdCounty());
      } else if (SPCL_INV_APPROVAL_TASK.equals(cdTask) && COUNTY_DIRECTOR.equals(ccmn13si.getSzWhichSpclInvApprover())) {
        map = retrievePolicyUnit(todoCaseInfStruct.getUlIdCase());
      } else if (SPCL_INV_APPROVAL_TASK.equals(cdTask) && POLICY_UNIT.equals(ccmn13si.getSzWhichSpclInvApprover())) {
        map = retrieveDeputyDirector(todoCaseInfStruct.getUlIdCase());
      } else if (APPROVE_SAFETY_RESOURCE.equals(cdTask) && SUPERVISOR.equals(ccmn13si.getSzWhichSafetyRsrcApprover()) ||
                      APPROVE_SAFETY_RESOURCE_ONG.equals(cdTask) && SUPERVISOR.equals(ccmn13si.getSzWhichSafetyRsrcApprover())) {
        map = retrieveCountyDirector(todoCaseInfStruct.getSzCdCounty());
      } else {
        map = unitDAO.findUnitByCdCountyCdUnitRegionNbrUnit(todoCaseInfStruct.getSzCdCounty(),
                                                                todoCaseInfStruct.getSzCdUnitRegion(),
                                                                todoCaseInfStruct.getSzNbrUnit());
        if (map == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }
      assignedStruct.setSzNmPersonFull(map.get("nmPersonFull") != null ? (String) map.get("nmPersonFull") : null);
      assignedStruct.setUlIdTodoPersAssigned(map.get("idPerson") != null ? (Integer) map.get("idPerson") : 0);
      // ccmn82
      taskStruct.setSzTxtTaskDecode(getTxtTaskDecode(cdTask));
      // cint21d/cint07d/ccmn19d
      stageStruct = callStageIncomingDetailPersonDaos(idStage);
      createdStruct.setDtDtTodoCreated(ccmn13so.getDtWCDDtSystemDate());
      createdStruct.setTmTmTodoCreated(ccmn13so.getTmTmWCDDtSystemTime());
    } else if (WINDOW_MODE_ASSIGN.equals(cReqFuncCd)) {
      if (cdTask != null) {
        // when the window is call from TASK LIST
        // ccmn82d
        taskStruct.setSzTxtTaskDecode(getTxtTaskDecode(cdTask));
      }
      // to retrieve szCdStage, since I&R and SPC intakes do not have a stage name, which kills ccmn19d.
      // cint21d/cint07d/ccmn19dcreatedStruct
      stageStruct = callStageIncomingDetailPersonDaos(idStage);
      createdStruct.setDtDtTodoCreated(ccmn13so.getDtWCDDtSystemDate());
      createdStruct.setTmTmTodoCreated(ccmn13so.getTmTmWCDDtSystemTime());
    } else {
      int stageStructIdStage = 0;
      // NEW USING / MODIFY SCENERIO WINDOW POPULATION, when the window is called from TO DO LIST
      // ccmn90d -- get the information for TODO
      Todo todo = todoDAO.findTodoByIdTodo(todoCaseInfStruct.getLdIdTodo());
      if (todo != null) {
        todoInfoStruct.setSzCdTodoType(todo.getCdTodoType());
        todoInfoStruct.setDtDtTodoDue(DateHelper.toCastorDate(todo.getDtTodoDue()));
        todoInfoStruct.setUlIdCase(todo.getCapsCase() != null ? todo.getCapsCase().getIdCase() : 0);
        todoInfoStruct.setUlIdEvent(todo.getEvent() != null ? todo.getEvent().getIdEvent() : 0);
        todoInfoStruct.setLdIdTodo(todo.getIdTodo() != null ? todo.getIdTodo() : 0);
        todoInfoStruct.setSzTxtTodoDesc(todo.getTxtTodoDesc());
        todoInfoStruct.setTxtTodoLongDesc(todo.getTxtTodoLongDesc());
        todoInfoStruct.setDtDtTodoCompleted(DateHelper.toCastorDate(todo.getDtTodoCompleted()));
        taskStruct.setSzCdTask(todo.getCdTodoTask());
        taskStruct.setDtDtTaskDue(DateHelper.toCastorDate(todo.getDtTodoTaskDue()));
        stageStructIdStage = (todo.getStage()) != null ? todo.getStage().getIdStage() : 0;
        createdStruct.setUlIdTodoPersCreator(todo.getPersonByIdTodoPersCreator() != null ?
                                             todo.getPersonByIdTodoPersCreator().getIdPerson() : 0);
        createdStruct.setDtDtTodoCreated(DateHelper.toCastorDate(todo.getDtTodoCreated()));
        createdStruct.setTmTmTodoCreated(FormattingHelper.formatTime(todo.getDtTodoCreated()));
        assignedStruct.setUlIdTodoPersAssigned(todo.getPersonByIdTodoPersAssigned() != null ?
                                               todo.getPersonByIdTodoPersAssigned().getIdPerson() : 0);
        ccmn13so.setTsLastUpdate(todo.getDtLastUpdate());
      }
      // If the CD TASK not NULL in the output, call DAO
      cdTask = taskStruct.getSzCdTask();
      if (taskStruct.getSzCdTask() != null) {
        todoCaseInfStruct.setSzCdTask(taskStruct.getSzCdTask());
        // ccmn82d
        taskStruct.setSzTxtTaskDecode(getTxtTaskDecode(cdTask));
      }
      // If the ID STAGE is not zero in the output, call DAO
      if (stageStructIdStage != 0) {
        todoCaseInfStruct.setUlIdStage(stageStructIdStage);

        // cint21d/cint07d/ccmn19d
        stageStruct = callStageIncomingDetailPersonDaos(stageStructIdStage);
      } else {
        // We need an empty stage struct if idStage was 0.
        stageStruct = new StageStruct();
      }
      // Put the stageStructIdStage into the stageStruct now that we are sure it has been created.
      stageStruct.setUlIdStage(stageStructIdStage);
      // Get the NM PERSON for the Created and Assigned.
      int idPersonCreator = createdStruct.getUlIdTodoPersCreator();
      if (idPersonCreator != 0) {
        // ccmn44d -- retrieve the name of the person who created the ToDo
        Person person = personDAO.findPersonByIdPerson(idPersonCreator);
        if (person == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        createdStruct.setSzNmPersonFull(person.getNmPersonFull());

      } else {
        createdStruct.setSzNmPersonFull(SYSTEM_NAME);
      }
      // ccmn44d --Retrieve the name of the person the ToDo is assigned to.
      
      Person person = personDAO.findPersonByIdPerson(assignedStruct.getUlIdTodoPersAssigned());
      if (person == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      assignedStruct.setSzNmPersonFull(person.getNmPersonFull());
    }
    // Add the structs to the output message
    ccmn13so.setTaskStruct(taskStruct);
    ccmn13so.setAssignedStruct(assignedStruct);
    ccmn13so.setTodoInfoStruct(todoInfoStruct);
    ccmn13so.setCreatedStruct(createdStruct);
    ccmn13so.setStageStruct(stageStruct);
    return ccmn13so;
  }

  private StageStruct callStageIncomingDetailPersonDaos(int idStage) throws ServiceException {
    // cint21d -- retrieve this.szCdStage, since I&R intakes do not have a stage name, which kills ccmn19d.
    Stage stage = stageDAO.findStageByIdStage(idStage);
    String szCdStage = null;
    if (stage != null) {
      szCdStage = stage.getCdStage();
    }
    // Call ccmn19d only if the stage is not I&R or SPC.
    StageStruct stageStruct = new StageStruct();
    if (!(CodesTables.CSTAGES_IR.equals(szCdStage) && CodesTables.CSTAGES_SPC.equals(szCdStage))) {
      String cdIncmgStatus = null;
      // Retrieve CD_INCMG_STATUS from the Incoming Detail table. If the STATUS is MFD (Marked for Deletion),
      //   it is OK not to find a primary worker and to ignore this SQL not found error.
      if (CodesTables.CSTAGES_INT.equals(szCdStage)) {
        // Ccint07d
        IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailByIdStage(idStage);
        if (incomingDetail == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        cdIncmgStatus = incomingDetail.getCdIncmgStatus();
      }
      // Retrieve the STAGE NM and PRIMARY NM from STAGE,PERSON and STAGE PERSON LINK.
      // ccmn19d -- get NM STAGE and primary worker
      Map persMap = personDAO.findNmPersonAndNmStageByIdStage(idStage, CodesTables.CROLEALL_PR);
      if (persMap == null) {
        if (CodesTables.CINCMGST_MFD.equals(cdIncmgStatus)) {
          // Explictly set this to null if marked for deletion.
          stageStruct.setSzNmStage(null);
        }
      } else {
        stageStruct.setSzNmStage((String) persMap.get("nmStage"));
        stageStruct.setUlIdTodoPersWorker((Integer) persMap.get("idPerson") != null ? (Integer) persMap.get(
                "idPerson") : 0);
        stageStruct.setSzNmPersonFull((String) persMap.get("nmPersonFull"));
      }
    }
    return stageStruct;
  }

  private String getTxtTaskDecode(String cdTask) throws ServiceException {
    // ccmn82d -- get TASK decode
    Task task = taskDAO.findTaskByCdTask(cdTask);
    if (task == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return task.getTxtTaskDecode();
  }
  
  @SuppressWarnings({"unchecked"})
  private Map retrieveSAURegionStaff(int idCase) {
    Map map = new HashMap();
    Integer idStaff = null;
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    if(capsCase != null) {
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, capsCase.getCdCaseCounty());
      List<Integer> sauList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
      if(sauList != null && sauList.size() > 0) {
        idStaff  = sauList.get(0);
      }
    }
    if(idStaff != null && idStaff.intValue() > 0) {
      map.put("idPerson", idStaff);
      map.put("nmPersonFull", personDAO.findNmFullByIdPerson(idStaff));
    }
    return map; 
  }
  
  @SuppressWarnings({"unchecked"})
  private Map retrieveCountyDirector(String cdCounty) {
    Map map = new HashMap();
    Integer idStaff = null;
    String cdStageRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    // Find the County Director for the stage's county and add the person to the list of
    // those to receive the alert
    Unit cd = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(cdCounty, cdStageRegion, NBR_UNIT_COUNTY_DIRECTOR);
    if (cd != null) {
      idStaff  = cd.getPerson().getIdPerson();
      String nmPerson = personDAO.findNmFullByIdPerson(cd.getPerson().getIdPerson());
      // Some counties do not have a county director; rather they have a vacant person and an actual
      // employee is designated to perform the work for the vacant person. In this situation,
      // find the designee and assign the alert to them.
      if (nmPerson.indexOf(VACANT_PERSON) >= 0) {
        List<EmpTempAssign> temps = empTempAssignDAO.findIdsemp(cd.getPerson().getIdPerson());
        if (temps != null && !temps.isEmpty()) {
          EmpTempAssign temp = temps.get(0);
          idStaff = temp.getPersonByIdPersonDesignee().getIdPerson();
        }
      }
    }
    if(idStaff != null && idStaff.intValue() > 0) {
      map.put("idPerson", idStaff);
      map.put("nmPersonFull", personDAO.findNmFullByIdPerson(idStaff));
    }
    return map; 
  }
  
  @SuppressWarnings({"unchecked"})
  private Map retrievePolicyUnit(int idCase) {
    Map map = new HashMap();
    Integer idStaff = null;
    // Policy Specialist
    List<Integer> policySpecialistList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(PRU_STAFF_SECURITY_CLASS_NAME);
    if (policySpecialistList != null && !policySpecialistList.isEmpty()) {
      idStaff  = policySpecialistList.get(0);
      if(idStaff != null && idStaff.intValue() > 0) {
        map.put("idPerson", idStaff);
        map.put("nmPersonFull", personDAO.findNmFullByIdPerson(idStaff));
      }
    }
    return map; 
  }
  
  @SuppressWarnings({"unchecked"})
  private Map retrieveDeputyDirector(int idCase) {
    Map map = new HashMap();
    Integer idStaff = null;
    // Policy Specialist
    List<Integer> policySpecialistList = unitEmpLinkDAO.findEmployeeByCdSecurityClassName(DEPUTY_DIRECTOR_SEC_CLASS);
    if (policySpecialistList != null && !policySpecialistList.isEmpty()) {
      idStaff  = policySpecialistList.get(0);
      if(idStaff != null && idStaff.intValue() > 0) {
        map.put("idPerson", idStaff);
        map.put("nmPersonFull", personDAO.findNmFullByIdPerson(idStaff));
      }
    }
    return map; 
  }
  
  protected static boolean isAdopAssistanceTask(String taskCode) {
    return ADOPTION_ASSIT_TASK_CODES.contains(taskCode);
  } 
  
}
