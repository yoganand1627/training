package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.TodoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------

 09/29/2008   mxpatel          STGAP00009127: entered an IF statement, so that we will
                               only to try to retrieve the case id if a case existst. This is to avoid
                               NPE for person merge when one or more persons being merged are in an open intake 
                               stage and no case_id exists for the intake as it is not a case yet.
 04/07/2009   arege            STGAP00012281 : If FCA_ELIGIBILITY_TODO_INFO do not override the idtodo info
                               description to be consistent with the Custody Design Document.                              

                               
*/

public class TodoCommonFunctionImpl extends BaseServiceImpl implements TodoCommonFunction {

  private TodoInfoDAO todoInfoDAO = null;

  private StageDAO stageDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private TodoDAO todoDAO = null;

  public void setTodoInfoDAO(TodoInfoDAO todoInfoDAO) {
    this.todoInfoDAO = todoInfoDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  /**
   * This should really be taken from codes_tables, I think, but nothing there makes any sense for it. Also, the
   * cd_todo_info_pers_assignd is never set to this value in todo_info, so I do not believe that it is ever used.
   */
  public static final String CD_MEMBER = "60";

  /** This should really be taken from codes_tables, I think, but nothing there makes any sense for it. */
  public static final String CD_LEAD = "40";

  /** There are no codes tables for task codes. */
  public static final String THREE_MONTH = "2030";

  public static final int TWENTIETH_DAY = 20;

  /** These codes do not appear in codes tables, though they might be concatenations of two codes. */
  public static final Set<String> CHILD_PLAN_ADOPTION_PLAN_TODO_INFOS = new HashSet<String>(
                                                                                            Arrays
                                                                                                  .asList(new String[] {
                                                                                                                        "SUB015",
                                                                                                                        "SUB016",
                                                                                                                        "ADO015" }));
  public static final String FCA_ELIGIBILITY_TODO_INFO = "SUB001"; //Added per STGAP00012281

  public CSUB40UO audTodo(CSUB40UI csub40ui) throws ServiceException {
    // The object to be passed in to Todo table for add/update
    CSUB40UIG00 csub40UIG00 = csub40ui.getCSUB40UIG00();
    // The current date.
    Date now = new Date();
    // If no dtSysDtTodoCfDueFrom is provided, use the current date.
    if (DateHelper.isNull(csub40UIG00.getDtSysDtTodoCfDueFrom())) {
      csub40UIG00.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(now));
    }
    // cses08d
    TodoInfo todoInfo = todoInfoDAO.findTodoInfoByCdTodoInfo(csub40UIG00.getSzSysCdTodoCf());
    if (todoInfo == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // If the IndTodoInfoEnabled is not set to "Y," then we return immediately.
    if (!ArchitectureConstants.Y.equals("Y")) { // todoInfo.getIndTodoInfoEnabled())) {
      CSUB40UO csub40uo = new CSUB40UO();
      return csub40uo;
    }
    Todo todo = populateTodo(csub40UIG00, todoInfo, now);
    // Only used for case-related todos, so it will have been assigned by populateTodo().
    Person personByIdTodoPersWorker = todo.getPersonByIdTodoPersWorker();
    int idPersAssigned = csub40UIG00.getUlSysIdTodoCfPersAssgn();
    
    if(csub40UIG00.getLNbrRemovalAgeYr() > 14)
    {
      todo.setPersonByIdTodoPersAssigned(personByIdTodoPersWorker);
      todoDAO.saveTodo(todo);
    }
    // Set the Person Assigned and save the to-do.
    if (0 != idPersAssigned) {
      Person persAssigned = (Person) getPersistentObject(Person.class, idPersAssigned);
      todo.setPersonByIdTodoPersAssigned(persAssigned);
      // ccmn43d
      todoDAO.saveTodo(todo);
    } else if (CD_MEMBER.equals(todoInfo.getCdTodoInfoPersAssignd())) {
      todo.setPersonByIdTodoPersAssigned(personByIdTodoPersWorker);
      // ccmn43d
      todoDAO.saveTodo(todo);
    } else if (CD_LEAD.equals(todoInfo.getCdTodoInfoPersAssignd())) {
      // ccmn60d -- Call DAO to retrieve the Supervisor
      Map map = unitEmpLinkDAO
                              .findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(personByIdTodoPersWorker
                                                                                                              .getIdPerson());
      if (map != null) {
        Person persAssigned = (Person) getPersistentObject(Person.class, (Integer) map.get("idPerson"));
        todo.setPersonByIdTodoPersAssigned(persAssigned);
        // ccmn43d
        todoDAO.saveTodo(todo);
        if (THREE_MONTH.equals(todoInfo.getCdTodoInfoTask())) {
          // We want to duplicate the Todo for this because save will only add a new object if the object has not
          // been saved previously; note that we do NOT copy the idTodo or dtLastUpdate values
          Todo workerTodo = new Todo();
          workerTodo.setCapsCase(todo.getCapsCase());
          workerTodo.setCdTodoTask(todo.getCdTodoTask());
          workerTodo.setCdTodoType(todo.getCdTodoType());
          workerTodo.setDtTodoCompleted(todo.getDtTodoCompleted());
          workerTodo.setDtTodoCreated(todo.getDtTodoCreated());
          workerTodo.setDtTodoDue(todo.getDtTodoDue());
          workerTodo.setDtTodoTaskDue(todo.getDtTodoTaskDue());
          workerTodo.setEvent(todo.getEvent());
          workerTodo.setNmTodoCreatorInit(todo.getNmTodoCreatorInit());
          workerTodo.setPersonByIdTodoPersCreator(todo.getPersonByIdTodoPersCreator());
          workerTodo.setPersonByIdTodoPersWorker(todo.getPersonByIdTodoPersWorker());
          workerTodo.setStage(todo.getStage());
          workerTodo.setTxtTodoDesc(todo.getTxtTodoDesc());
          workerTodo.setTxtTodoLongDesc(todo.getTxtTodoLongDesc());
          // Set the person assigned to the person worker
          todo.setPersonByIdTodoPersAssigned(todo.getPersonByIdTodoPersWorker());
          // ccmn43d
          todoDAO.saveTodo(todo);
        }
      } else {

        Person persWorker = (Person) getPersistentObject(Person.class, personByIdTodoPersWorker.getIdPerson());
        todo.setPersonByIdTodoPersAssigned(persWorker);
        // ccmn43d
        todoDAO.saveTodo(todo);
      }
    } else {
      // If Person Assigned is completely unknown continue with this check.
      // Call DAO to retrieve ID PERSON
      // csec04d
      UnitEmpLink unitEmpLink = unitEmpLinkDAO.findContractAndContractPeriod(personByIdTodoPersWorker.getIdPerson(),
                                                                             todoInfo.getCdTodoInfoPersAssignd());
      if (unitEmpLink != null) {
        Person person = unitEmpLink.getPerson();
        person = (Person) getPersistentObject(Person.class, person.getIdPerson());
        todo.setPersonByIdTodoPersAssigned(person);
        // Calling DAO to persist the populated todo object into the database.
        // ccmn43d
        todoDAO.saveTodo(todo);
      } else {
        personByIdTodoPersWorker = (Person) getPersistentObject(Person.class, personByIdTodoPersWorker.getIdPerson());
        todo.setPersonByIdTodoPersAssigned(personByIdTodoPersWorker);
        // ccmn43d
        todoDAO.saveTodo(todo);
      }
    }

    CSUB40UO csub40uo = new CSUB40UO();
    csub40uo.setSzCdTodoTask(todo.getCdTodoTask());
    csub40uo.setSzCdTodoType(todo.getCdTodoType());
    csub40uo.setDtDtTaskDue(DateHelper.toCastorDate(todo.getDtTodoCompleted()));
    csub40uo.setDtDtTodoCompleted(DateHelper.toCastorDate(todo.getDtTodoCreated()));
    csub40uo.setDtDtTodoCreated(DateHelper.toCastorDate(todo.getDtTodoDue()));
    csub40uo.setDtDtTodoDue(DateHelper.toCastorDate(todo.getDtTodoTaskDue()));
    if(todo.getCapsCase() != null){//mxpatel entered this IF for defect #9127
    csub40uo.setUlIdCase(todo.getCapsCase().getIdCase());
    }
    csub40uo.setUlIdEvent(todo.getEvent() != null ? todo.getEvent().getIdEvent() : 0);
    csub40uo.setUlIdStage(todo.getStage().getIdStage());
    csub40uo.setLdIdTodo(todo.getIdTodo());
    csub40uo.setUlIdTodoPersAssigned(todo.getPersonByIdTodoPersAssigned().getIdPerson());

    if (todo.getPersonByIdTodoPersCreator() != null) {
      csub40uo.setUlIdTodoPersCreator(todo.getPersonByIdTodoPersCreator().getIdPerson());
    }
    csub40uo.setUlIdTodoPersWorker(personByIdTodoPersWorker.getIdPerson());
    csub40uo.setSzTxtTodoDesc(todo.getTxtTodoDesc());
    csub40uo.setTxtTodoLongDesc(todo.getTxtTodoLongDesc());

    return csub40uo;
  }

  private Todo populateTodo(CSUB40UIG00 csub40UIG00, TodoInfo todoInfo, Date now) throws ServiceException {
    Todo todo = new Todo();
    int idTodoCfStage = csub40UIG00.getUlSysIdTodoCfStage();

    // Skip assignment of case and worker if this is not a case-related todo.
    if (0 != idTodoCfStage) {
      populateCaseRelatedTodoInformation(idTodoCfStage, todo, csub40UIG00);
    }
    // Continue populating 'todo'. The TODO COMMON FUNCTION ASSUMES THAT ALL REQUIRED INFORMATION HAS BEEN PROVIDED
    // BY THE CALLING SERVICE. Programer must make sure thatthey populate all these fields.
    todo.setCdTodoTask(todoInfo.getCdTodoInfoTask());
    todo.setCdTodoType(todoInfo.getCdTodoInfoType());

    // only set the event object if there is one. not all to dos are tied to events
    if (csub40UIG00.getUlSysIdTodoCfEvent() != 0) {
      Event event = (Event) getPersistentObject(Event.class, csub40UIG00.getUlSysIdTodoCfEvent());
      todo.setEvent(event);
    }

    Stage tempStage = (Stage) getPersistentObject(Stage.class, idTodoCfStage);
    todo.setStage(tempStage);
    // Any Long Description that may have been retrievedvfrom the TODO INFO table will be
    // overriden by the users long description.
    String szSysTxtTodoCfLongDesc = csub40UIG00.getSzSysTxtTodoCfLongDesc();
    if (StringHelper.isValid(szSysTxtTodoCfLongDesc)) {
      todo.setTxtTodoLongDesc(szSysTxtTodoCfLongDesc);
    } else {
      // Copy the long description retrieved from the TODOINFO table
      todo.setTxtTodoLongDesc(todoInfo.getTxtTodoInfoLongDesc());
    }
    // Any Description that may have been retrieved from the TODO INFO table will be
    // overriden by the users description.
    String szSysTxtTodoCfDesc = csub40UIG00.getSzSysTxtTodoCfDesc();
    //STGAP00012281 if FCA_ELIGIBILITY_TODO_INFO do not override the idtodo info
    // description to be consistent with the Custody Design Document.
    if (StringHelper.isValid(szSysTxtTodoCfDesc) && !FCA_ELIGIBILITY_TODO_INFO.equals(todoInfo.getCdTodoInfo())) {
      todo.setTxtTodoDesc(szSysTxtTodoCfDesc);
    } else {
      // Copy the description retrieved from the TODO INFO table
      todo.setTxtTodoDesc(todoInfo.getTxtTodoInfoDesc());
    }
    // When creating the todo, the due date and the display date will be calculated based
    // upon the start date passed into this function.
    todo.setDtTodoDue(calculateDtTodoDue(csub40UIG00, todoInfo));
    // The folowing logic will set the Person Creator and calculate the Task Due date.
    // It will do this only if the Todo Info Type is "T" for Task. Otherwise it will set
    // the Person Creator to the one passed in and the Task Due date to NULL.
    if (CodesTables.CTODOTYP_T.equals(todoInfo.getCdTodoInfoType())) {
      // Person persCreator = (Person) getPersistentObject(Person.class, 0);
      // todo.setPersonByIdTodoPersCreator(persCreator);
      todo.setDtTodoTaskDue(calculateDtTodoTaskDue(csub40UIG00, todoInfo));
    } else {
      Person persCreator = (Person) getPersistentObject(Person.class, csub40UIG00.getUlSysIdTodoCfPersCrea());
      todo.setPersonByIdTodoPersCreator(persCreator);
      todo.setDtTodoTaskDue(null);
    }
    todo.setDtTodoCreated(now);
    todo.setDtTodoCompleted(null);
    return todo;
  }

  private void populateCaseRelatedTodoInformation(int idTodoCfStage, Todo todo, CSUB40UIG00 csub40UIG00)
                                                                                                        throws ServiceException {
    // cint40d
    Stage stage = stageDAO.findStageByIdStage(idTodoCfStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    // The idCase is encapsulated in the CapsCase object
    todo.setCapsCase(stage.getCapsCase());
    // Continue formating 'todo'. The following is a check for the primary employee
    Person person = new Person();
    int sysIdTodoCfPersWkr = csub40UIG00.getUlSysIdTodoCfPersWkr();
    if (0 != sysIdTodoCfPersWkr) {
      person = (Person) getPersistentObject(Person.class, sysIdTodoCfPersWkr);
    } else {
      String cdStagePersRole = null;
      if (ArchitectureConstants.Y.equals(stage.getIndStageClose())) {
        if (!DateHelper.isNull(stage.getDtStageClose())) {
          cdStagePersRole = CodesTables.CROLEALL_HP;
        }
        // Note that this means that cdStagePersRole will not be set if indStageClose is not set
        // and the dtStageClose is null.
      } else {
        cdStagePersRole = CodesTables.CROLEALL_PR;
      }
      // cinv51d
      Integer idTodoPersAssigned = complexStageDAO.findPrimaryWorker(idTodoCfStage, cdStagePersRole);
      if (idTodoPersAssigned == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      person = (Person) getPersistentObject(Person.class, idTodoPersAssigned);
    }
    todo.setPersonByIdTodoPersWorker(person);
  }

  private Date calculateDtTodoTaskDue(CSUB40UIG00 csub40UIG00, TodoInfo todoInfo) {
    Calendar calTodoDue = Calendar.getInstance();
    calTodoDue.setTime(DateHelper.toJavaDate(csub40UIG00.getDtSysDtTodoCfDueFrom()));

    int nbrTodoInfoTaskDueDd = todoInfo.getNbrTodoInfoTaskDueDd() != null ? todoInfo.getNbrTodoInfoTaskDueDd() : 0;
    int nbrTodoInfoTaskDueYy = todoInfo.getNbrTodoInfoTaskDueYy() != null ? todoInfo.getNbrTodoInfoTaskDueYy() : 0;
    int nbrTodoInfoDueMm = todoInfo.getNbrTodoInfoDueMm() != null ? todoInfo.getNbrTodoInfoDueMm() : 0;

    calTodoDue.add(Calendar.DATE, nbrTodoInfoTaskDueDd);
    calTodoDue.add(Calendar.MONTH, nbrTodoInfoDueMm);
    calTodoDue.add(Calendar.YEAR, nbrTodoInfoTaskDueYy);
    if (THREE_MONTH.equals(todoInfo.getCdTodoInfoTask())) {
      calTodoDue.set(Calendar.DAY_OF_MONTH, TWENTIETH_DAY);
    }
    return calTodoDue.getTime();
  }

  private Date calculateDtTodoDue(CSUB40UIG00 csub40UIG00, TodoInfo todoInfo) {
    Calendar calTodoDue = Calendar.getInstance();
    calTodoDue.setTime(DateHelper.toJavaDate(csub40UIG00.getDtSysDtTodoCfDueFrom()));
    // Calculate the date that the todo will be displayed on the worker's Staff To-Do List.
    // Child Plans and Adoption Plans do not function like other modules. Since the worker
    // is now able to enter the 'Next Review Date', we need to create a todo for the next
    // review that is due on the date entered by the worker. The todo should be displayed
    // one month before the actual due date.
    String szSysCdTodoCf = csub40UIG00.getSzSysCdTodoCf();
    int nbrTodoInfoTaskDueDd = todoInfo.getNbrTodoInfoTaskDueDd() != null ? todoInfo.getNbrTodoInfoTaskDueDd() : 0;
    int nbrTodoInfoTaskDueYy = todoInfo.getNbrTodoInfoTaskDueYy() != null ? todoInfo.getNbrTodoInfoTaskDueYy() : 0;
    int nbrTodoInfoDueMm = todoInfo.getNbrTodoInfoDueMm() != null ? todoInfo.getNbrTodoInfoDueMm() : 0;

    if (CHILD_PLAN_ADOPTION_PLAN_TODO_INFOS.contains(szSysCdTodoCf)) {
      // Note that, this appers to be a bug, given the comment above; it should probably be:
      // tmepCall.add(Calendar.MONTH, todoInfo.getNbrTodoInfoDueMm() - 1);
      // This was NOT fixed during conversion because we want the services to behave exaclty the same way.
      calTodoDue.add(Calendar.DATE, nbrTodoInfoTaskDueDd);
      calTodoDue.add(Calendar.MONTH, -1);
      calTodoDue.add(Calendar.YEAR, nbrTodoInfoTaskDueYy);
    } else {
      calTodoDue.add(Calendar.DATE, nbrTodoInfoTaskDueDd);
      calTodoDue.add(Calendar.MONTH, nbrTodoInfoDueMm);
      calTodoDue.add(Calendar.YEAR, nbrTodoInfoTaskDueYy);
    }
    if (THREE_MONTH.equals(todoInfo.getCdTodoInfoTask())) {
      calTodoDue.set(Calendar.DAY_OF_MONTH, TWENTIETH_DAY);
    }
    return calTodoDue.getTime();
  }
}
