package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import java.util.*;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FaIndivTrainingDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.FaIndivTraining;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SavePreservice;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD33SO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;

public class SavePreserviceImpl extends BaseServiceImpl implements SavePreservice {

  private FaIndivTrainingDAO faIndivTrainingDAO = null;

  private CapsResourceDAO capsResourceDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoDAO todoDAO = null;

  private boolean sendAlert = false;

  private final static String CPR_TRAINING = "CPR";

  private final static String FIRST_AID_TRAINING = "First Aid";

  private final static String CPR_TRANING_1_YEAR = CodesTables.CFATRAIN_CPR1;

  private final static String CPR_TRANING_2_YEAR = CodesTables.CFATRAIN_CPR2;

  private final static String FIRST_AID_CERT_1_YEAR = CodesTables.CFATRAIN_FAC1;

  private final static String FIRST_AID_CERT_2_YEAR = CodesTables.CFATRAIN_FAC2;

  private final static String FIRST_AID_CERT_3_YEAR = CodesTables.CFATRAIN_FAC3;

  public static final String PERS_ROLE_PR = CodesTables.CSTFROLS_PR;

  public static final String TODO_DESC = "Training Expires In 60 Days";

  public static final String TODO_TYPE = CodesTables.CTODOTYP_A;

  public void setFaIndivTrainingDAO(FaIndivTrainingDAO faIndivTrainingDAO) {
    this.faIndivTrainingDAO = faIndivTrainingDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  //This method is used for save as well as delete the record, depending on the 
  //  add or delete function, cdSysDataActionOutcome flag

  public CFAD33SO savePreservice(CFAD33SI cfad33si) throws ServiceException {
    CFAD33SIG00_ARRAY cfad33sig00_array = cfad33si.getCFAD33SIG00_ARRAY();
    int idStage = cfad33si.getUlIdStage();
    int userId = cfad33si.getUlIdPerson();

    Enumeration cfad33sig00_enum = cfad33sig00_array.enumerateCFAD33SIG00();
    while (cfad33sig00_enum.hasMoreElements()) {
      CFAD33SIG00 rowcfad33sig00 = (CFAD33SIG00) cfad33sig00_enum.nextElement();
      String cdSysDataActionOutcome = rowcfad33sig00.getSzCdSysDataActionOutcome();
      String cdIndivTrnType = rowcfad33sig00.getSzCdIndivTrnType();
      Date trngCompletedDate = DateHelper.toJavaDate(rowcfad33sig00.getDtDtIndivTrn());

      int idIndivTraining = rowcfad33sig00.getUlIdIndivTraining();

      if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdSysDataActionOutcome)) {

        faIndivTrainingDAO.deleteFaIndivTraining(idIndivTraining);
        break;
      } 
      else
      {

        if (cdIndivTrnType.equals(CodesTables.CFATRAIN_PRSV)
            && cdSysDataActionOutcome.equals(ServiceConstants.REQ_FUNC_CD_ADD)) {

          checkToDo(cfad33si.getUlIdPerson(), cfad33si.getUlIdStage());
         // break;
        }
      }

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdSysDataActionOutcome)
          || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdSysDataActionOutcome)) {
        audFaIndivTraining(cfad33si.getUlIdPerson(), rowcfad33sig00);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      //if training type is CPR-1 yr, CPR-2 yr or First Aid-1yr, First Aid-2 yr or First Aid-3 yrs
      //then send the alert to the primary case manager 60 days prior to expiration date of the training.

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdSysDataActionOutcome) || cdIndivTrnType.equals(CPR_TRANING_1_YEAR)
          || cdIndivTrnType.equals(CPR_TRANING_2_YEAR) || cdIndivTrnType.equals(FIRST_AID_CERT_1_YEAR)
          || cdIndivTrnType.equals(FIRST_AID_CERT_2_YEAR) || cdIndivTrnType.equals(FIRST_AID_CERT_3_YEAR)) {
        sendAlert = true;
      } else {
        sendAlert = false;
      }
      if (sendAlert) {
        Date trngExpirationDate = calculateTrngExpirationDate(cdIndivTrnType, trngCompletedDate);
        createTodo(idStage, userId, trngExpirationDate, cdIndivTrnType);
      }
    }
    // Reset the enumeration to restart the loop and execute one update for each row.
    /* cfad33sig00_enum = cfad33sig00_array.enumerateCFAD33SIG00();
     while (cfad33sig00_enum.hasMoreElements()) {
     audFaIndivTraining(cfad33si.getUlIdPerson(), (CFAD33SIG00) cfad33sig00_enum.nextElement());
     }*/
    // Returns an empty object.
    return new CFAD33SO();
  }

  private void audFaIndivTraining(int idPerson, CFAD33SIG00 rowcfad33sig00) throws ServiceException {
    FaIndivTraining faIndivTraining = new FaIndivTraining();
    faIndivTraining.setIndIndivTrnEc(rowcfad33sig00.getCIndIndivTrnEc());
    faIndivTraining.setDtLastUpdate(rowcfad33sig00.getTsLastUpdate());
    String cdSysDataActionOutcome = rowcfad33sig00.getSzCdSysDataActionOutcome();

    //if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdSysDataActionOutcome) ||
    //  ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdSysDataActionOutcome)) {
    String trngType = rowcfad33sig00.getSzCdIndivTrnType();
    Date trngCompletedDate = DateHelper.toJavaDate(rowcfad33sig00.getDtDtIndivTrn());

    faIndivTraining.setCdIndivTrnType(rowcfad33sig00.getSzCdIndivTrnType());
    faIndivTraining.setDtIndivTrn(DateHelper.toJavaDate(rowcfad33sig00.getDtDtIndivTrn()));
    faIndivTraining.setIdIndivTraining(rowcfad33sig00.getUlIdIndivTraining());
    faIndivTraining.setNbrIndivTrnHrs(rowcfad33sig00.getLdNbrIndivTrnHrs());
    faIndivTraining.setNbrIndivTrnSession(rowcfad33sig00.getSNbrIndivTrnSession());
    faIndivTraining.setTxtIndivTrnTitle(rowcfad33sig00.getSzTxtIndivTrnTitle());

    faIndivTraining.setCdTrain1Role(rowcfad33sig00.getLdCdTrain1Role());
    faIndivTraining.setCdTrain2Role(rowcfad33sig00.getLdCdTrain2Role());
    faIndivTraining.setCdTrain3Role(rowcfad33sig00.getLdCdTrain3Role());
    faIndivTraining.setCdTrain4Role(rowcfad33sig00.getLdCdTrain4Role());

    faIndivTraining.setNmTrain1(rowcfad33sig00.getLdNmTrain1());
    faIndivTraining.setNmTrain2(rowcfad33sig00.getLdNmTrain2());
    faIndivTraining.setNmTrain3(rowcfad33sig00.getLdNmTrain3());
    faIndivTraining.setNmTrain4(rowcfad33sig00.getLdNmTrain4());

    faIndivTraining.setDtLastUpdate(rowcfad33sig00.getTsLastUpdate());
    faIndivTraining.setIndCoTrain(rowcfad33sig00.getLdIndCoTrain());
    faIndivTraining.setIndIndivTrnEc(rowcfad33sig00.getCIndIndivTrnEc());
    faIndivTraining.setNmAgency(rowcfad33sig00.getNmAgency());

    Person personObject = (Person) getPersistentObject(Person.class, idPerson);
    faIndivTraining.setPerson(personObject);
    //    caud86d
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdSysDataActionOutcome)) {
      long count = faIndivTrainingDAO.countFaIndivTrainingByIdPersonAndCdIndivTrnTypeAndDtIndivTrn(idPerson, trngType,
                                                                                                   trngCompletedDate);
      if (count != 0) {
        throw new ServiceException(Messages.MSG_DUPLICATE_RECORD);

      }
    }
    faIndivTrainingDAO.saveFaIndivTraining(faIndivTraining);
  }

  public void checkToDo(int idPerson, int idStage) throws ServiceException {
    // cmsc34d
    if (faIndivTrainingDAO.countFaIndivTrainingByIdPersonAndCdIndivTrnType(idPerson, CodesTables.CFATRAIN_PRSV) == 0) {
      // cses41d
      CapsResource capsResource = capsResourceDAO.findResourceByIdRsrcFaHomeStage(idStage);
      if (capsResource == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      if (capsResource.getCdRsrcFaHomeStatus().equals(CodesTables.CFAHMSTA_INQ)) {
        CSUB40UI csub40ui = new CSUB40UI();
        CSUB40UIG00 csub40uigoo = new CSUB40UIG00();
        csub40uigoo.setSzSysCdTodoCf("FAD045");
        csub40uigoo.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
        csub40uigoo.setUlSysIdTodoCfPersCrea(0);
        csub40uigoo.setUlSysIdTodoCfEvent(capsResource.getIdResource() != null ? capsResource.getEvent().getIdEvent().intValue(): 0);
        csub40uigoo.setUlSysIdTodoCfStage(idStage);
        csub40ui.setCSUB40UIG00(csub40uigoo);
        todoCommonFunction.audTodo(csub40ui);
      }
    }
  }

  /**
   * This method calculates the expiry date depending on the training type.
   * Expiration date of CPR-1 yr = (Training Completed Date + 1 year) - 60 days.
   * Expiration date of CPR-2 yr = (Training Completed Date + 2 year) - 60 days.
   * Expiration date of First Aid-1 yr = (Training Completed Date + 1 year) - 60 days. and so on.
   * @param cdIndivTrnType
   * @param trngCompletedDate
   * @return
   */

  private Date calculateTrngExpirationDate(String cdIndivTrnType, Date trngCompletedDate) {
    Date trngExpirationDate = null;

    if (cdIndivTrnType.equals(CPR_TRANING_1_YEAR)) {
      trngExpirationDate = DateHelper.addToDate(trngCompletedDate, 1, 0, -60);
    } else if (cdIndivTrnType.equals(CPR_TRANING_2_YEAR)) {
      trngExpirationDate = DateHelper.addToDate(trngCompletedDate, 2, 0, -60);
    } else if (cdIndivTrnType.equals(FIRST_AID_CERT_1_YEAR)) {
      trngExpirationDate = DateHelper.addToDate(trngCompletedDate, 1, 0, -60);
    } else if (cdIndivTrnType.equals(FIRST_AID_CERT_2_YEAR)) {
      trngExpirationDate = DateHelper.addToDate(trngCompletedDate, 2, 0, -60);

    } else if (cdIndivTrnType.equals(FIRST_AID_CERT_3_YEAR)) {
      trngExpirationDate = DateHelper.addToDate(trngCompletedDate, 3, 0, -60);
    }

    return trngExpirationDate;
  }

  //send alert to the primary case manager.
  private void createTodo(int idStage, int userId, Date trngExpirationDate, String cdIndivTrnType) {
    //get primary case manager's id.
    int idPersonPrimaryCaseManager = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, PERS_ROLE_PR);
    Person primaryCaseManager = getPersistentObject(Person.class, idPersonPrimaryCaseManager);
    //get user's id and full name.
    Person user = getPersistentObject(Person.class, userId);

    String personFullName = user.getNmPersonFull();
    //get due date which is training expiry date.
    Date todoDueDate = trngExpirationDate;
    String cdTask = "";
    String trngName = "";
    if (cdIndivTrnType.equals(CPR_TRANING_1_YEAR) || cdIndivTrnType.equals(CPR_TRANING_2_YEAR)) {

      trngName = CPR_TRAINING;
    } else if (cdIndivTrnType.equals(FIRST_AID_CERT_1_YEAR) || cdIndivTrnType.equals(FIRST_AID_CERT_2_YEAR)
               || cdIndivTrnType.equals(FIRST_AID_CERT_3_YEAR)) {
      trngName = FIRST_AID_TRAINING;
    }
    String todoDesc = personFullName + "\'s " + trngName + " " + TODO_DESC;
    Stage stage = getPersistentObject(Stage.class, idStage);
    CapsCase capsCase = stage.getCapsCase();
    Todo todo = new Todo();
    todo.setCdTodoTask(cdTask);
    todo.setCapsCase(capsCase);
    todo.setCdTodoType(TODO_TYPE);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(primaryCaseManager);
    todo.setStage(stage);
    todo.setTxtTodoDesc(todoDesc);
    todo.setTxtTodoLongDesc(todoDesc);
    todoDAO.saveTodo(todo);
  }

}
