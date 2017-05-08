package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveRecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCFC27SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC27SO;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * * <pre>
 *  Change History:
 *  Date        User        Description
 *  --------   --------     --------------------------------------------------
 *  01/19/2010 wcochran     SMS #37458 - Added code to create and save an
 *                          alert when fingerprint information is saved
 *  03/16/2010 wcochran     SMS #37458 - Added code to ensure todo alert is
 *                          sent to the case manager and not the requester.
 * </pre>
 */
public class SaveRecordsCheckImpl extends BaseServiceImpl implements SaveRecordsCheck {

  private RecordsCheckDAO recordsCheckDAO = null;
  private PersonDAO personDAO = null;
  private TodoDAO todoDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private final String REC_CHECK_FINGERPRINT_CARD = "F";
  
  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public CCFC27SO audRecordsCheck(CCFC27SI ccfc27si) throws ServiceException {
    CCFC27SO ccfc27so = new CCFC27SO();
    // List AUD CAUD87D - This will add/update/delete a full row to
    // Records Check Table.  It will take as input a RecordsCheck object
    ROWCCFC27SIG00_ARRAY rowccfc27sig00_array = ccfc27si.getROWCCFC27SIG00_ARRAY();
    Enumeration rowccfc27sig00_enum = rowccfc27sig00_array.enumerateROWCCFC27SIG00();
    // While more rows are left to process continue loop.
    while (rowccfc27sig00_enum.hasMoreElements()) {
      ROWCCFC27SIG00 rowccfc27sig00 = (ROWCCFC27SIG00) rowccfc27sig00_enum.nextElement();
      Date dtLastUpdate = rowccfc27sig00.getTsLastUpdate();
      int idRecCheck = rowccfc27sig00.getUlIdRecCheck();
      String indFingerprintInfoAdded = rowccfc27sig00.getCIndFingerPrintInfoAdded();
      String cdStage = rowccfc27sig00.getSzCdStage();
      String cdScrDataAction = rowccfc27sig00.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction) ||
          ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        RecordsCheck recordsCheck = new RecordsCheck();
        recordsCheck.setDtLastUpdate(dtLastUpdate);
        recordsCheck.setIdRecCheck(idRecCheck);
        recordsCheck.setCdRecCheckCheckType(rowccfc27sig00.getSzCdRecCheckCheckType());
        recordsCheck.setCdRecCheckStatus(rowccfc27sig00.getSzCdRecCheckStatus());
        recordsCheck.setTxtRecCheckComments(rowccfc27sig00.getSzTxtRecCheckComments());
        recordsCheck.setDtRecCheckCompleted(DateHelper.toJavaDate(rowccfc27sig00.getDtDtRecCheckCompleted()));
        recordsCheck.setDtRecCheckRequest(DateHelper.toJavaDate(rowccfc27sig00.getDtDtRecCheckRequest()));
        recordsCheck.setIndReccheckHistory(rowccfc27sig00.getCIndRecCheckHistory());
        
        // below is FingerPrintCheckData.
        Date dtFingerprintCardReturn = DateHelper.toJavaDate(rowccfc27sig00.getSelDtFingerprintCardReturn());
        Date dtLiveScanResultReceived = DateHelper.toJavaDate(rowccfc27sig00.getSelDtLiveScanResultReceived());
        
        recordsCheck.setDtRecCheckCrimRelRec(DateHelper.toJavaDate(rowccfc27sig00.getSelDtCriminalReleaseReceived()));
        recordsCheck.setDtRecchkFpCardGiven(DateHelper.toJavaDate(rowccfc27sig00.getSelDtFingerprintCardGiven()));
        recordsCheck.setDtRecchkFpCardReturn(dtFingerprintCardReturn);
        recordsCheck.setDtRecchkLsPerformed(DateHelper.toJavaDate(rowccfc27sig00.getSelDtLiveScanPerformed()));
        recordsCheck.setDtRecchkLsresultRec(dtLiveScanResultReceived);
        recordsCheck.setIndRecchkFpcard(rowccfc27sig00.getCbFingerprintCard());
        recordsCheck.setIndRecchkLiveScan(rowccfc27sig00.getCbLiveScan());
        recordsCheck.setIndRecchkRefuseInvClrnce(rowccfc27sig00.getRbRefuseSignInvestigationClearance());
        recordsCheck.setIndRecchkFpchkResult(rowccfc27sig00.getRbFingerPrintCkResult());
        recordsCheck.setIndRecchkRecmndatn(rowccfc27sig00.getRbRecommendation());
        
        Person recCheckPerson = personDAO.findPersonByIdPerson(ccfc27si.getUlIdRecCheckPerson());
        if (recCheckPerson == null){
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        recordsCheck.setPersonByIdRecCheckPerson(recCheckPerson);

        Person requestorPerson = (Person) getPersistentObject(Person.class, rowccfc27sig00.getUlIdRecCheckRequestor());
        recordsCheck.setPersonByIdRecCheckRequestor(requestorPerson);

        if (rowccfc27sig00.getUlIdStage() != 0) {
          Stage stage = (Stage) getPersistentObject(Stage.class, rowccfc27sig00.getUlIdStage());
          recordsCheck.setStage(stage);
        }
        // caud87d
        recordsCheckDAO.saveRecordsCheck(recordsCheck);
        int savedIdRecCheck = recordsCheck.getIdRecCheck();
        ccfc27so.setUlIdRecCheck(savedIdRecCheck);
        
        /*
         * Only add a Todo if we're updating the record check with
         * fingerprint information. (SMS #37458)
         */
        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)
            && ArchitectureConstants.Y.equals(indFingerprintInfoAdded)) {
          processFingerprintData(ccfc27si, rowccfc27sig00);
        }
        
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
        // caud87d
        if (0 == recordsCheckDAO.deleteRecordsCheck(idRecCheck, dtLastUpdate)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    return ccfc27so;
  }
  
  /**
   * Created for SMS #37458
   * Process fingerprint data and create a new todo if the necessary data
   * is found.
   * @param ccfc27si
   * @param rowccfc27sig00
   */
  private void processFingerprintData(CCFC27SI ccfc27si, ROWCCFC27SIG00 rowccfc27sig00) {

    Date dtFingerprintCardReturn = DateHelper.toJavaDate(rowccfc27sig00.getSelDtFingerprintCardReturn());
    Date dtLiveScanResultReceived = DateHelper.toJavaDate(rowccfc27sig00.getSelDtLiveScanResultReceived());

    /* if these dates are null, then there is 
     * no processing to perform.
     */
    if (dtFingerprintCardReturn == null && dtLiveScanResultReceived == null) {
      return;
    }

    Integer idRecCheckPerson = ccfc27si.getUlIdRecCheckPerson();
    Person recCheckPerson = getPersistentObject(Person.class, idRecCheckPerson);
    Date dtPersonBirth = recCheckPerson.getDtPersonBirth();
    int personAge = DateHelper.getAge(dtPersonBirth);
    /* If this person is not at least 18
     * years of age, then no fingerprint alert
     * should be sent
     */
    if (personAge < 18) {
      return;
    }
    
    /* We want the fingerprint alert to go to
     * the case manager associated with the
     * current (related) stage. If this id
     * was not passed, then we take it from the
     * retrieved records check row.
     */
    Integer idStage = ccfc27si.getUlIdStageRelated();
    if (idStage == null || idStage <= 0) {
      idStage = rowccfc27sig00.getUlIdStage();
    }

    Date dtTodoDue = null;
    String indFingerprintDateToUse = rowccfc27sig00.getCIndFingerPrintDateToUse();
    if (REC_CHECK_FINGERPRINT_CARD.equals(indFingerprintDateToUse)) {
      dtTodoDue = dtFingerprintCardReturn;
    } else {
      dtTodoDue = dtLiveScanResultReceived;
    }
    Integer idCaseManager = null;
    String cdStage = rowccfc27sig00.getSzCdStage();
    /* if idStage is null or zero, we need to locate
     * all of the FAD stages and the associated case
     * managers and send the alert to all of those
     * case managers.
     */
    if (idStage == null || idStage <= 0) {
      Set<String> cdStages = new HashSet<String>();
      cdStages.add(CodesTables.CSTAGES_FAD);
      List<Object[]> listStagePersonLink = stagePersonLinkDAO
                                                                    .findIdStageIdCaseManagerByIdPersonCdStage(
                                                                                                               idRecCheckPerson,
                                                                                                               cdStages);
      for (Object[] o : listStagePersonLink) {
        idStage = (Integer) o[0];
        idCaseManager = (Integer) o[1];
        createTodo(dtTodoDue, idRecCheckPerson, idCaseManager, idStage);
      }
    }
    /* We should only send this alert for persons 
     * involved in FAD Stages 
     */
    else if (CodesTables.CSTAGES_FAD.equals(cdStage)) {
        
      idCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStageOrderDesc(idStage);
      createTodo(dtTodoDue, idRecCheckPerson, idCaseManager, idStage);
    }

  }
  
  private void createTodo(Date dtTodoDue, Integer idRecCheckPerson, 
                          Integer idCaseManager, Integer idStage) {

    Person recChkPerson = getPersistentObject(Person.class, idRecCheckPerson);
    String nmRecChkPerson = recChkPerson.getNmPersonFull();
    String txtTodoDesc = "Fingerprint check due in 120 days for " + nmRecChkPerson;

    dtTodoDue = updateDate(dtTodoDue);
    Todo todo = new Todo();
    Stage stage = null;
    CapsCase cCase = null;

    if (idStage != null && idStage > 0) {
      stage = getPersistentObject(Stage.class, idStage);
      if (stage != null) {
        cCase = stage.getCapsCase();
      }
    }
    
    Person persCreator = (Person) getPersistentObject(Person.class, idCaseManager);
    Person persAssigned = (Person) getPersistentObject(Person.class, idCaseManager);

    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setPersonByIdTodoPersCreator(persCreator);
    todo.setPersonByIdTodoPersWorker(persCreator);
    todo.setDtTodoCreated(DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));
    todo.setDtTodoCompleted(null);
    todo.setStage(stage);
    todo.setCapsCase(cCase);
    todo.setDtTodoDue(dtTodoDue);
    todo.setDtTodoTaskDue(null);
    todo.setPersonByIdTodoPersAssigned(persAssigned);
    todo.setTxtTodoLongDesc(txtTodoDesc);
    todo.setTxtTodoDesc(txtTodoDesc);
    todoDAO.saveTodo(todo);
    
  }
  
  /*
   * This method will update the date to be 120
   * days prior to the 5 year due date for the
   * fingerprint check due date
   */
  private Date updateDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.YEAR, 5);
    calendar.add(Calendar.DAY_OF_YEAR, -120);
  
    return calendar.getTime();
  }

}
