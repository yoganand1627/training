package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReview;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewCateg;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewCbxResponse;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewItem;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReviewQuesResponse;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveCaseReview;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewQuestionsSO;

/**
 * This class provides the service that saves the case review.
 * 
 * @author  Bhavna Gehlot March 16 , 2009
 * 
 * Change History:
 **  Date        User              Description
 **  --------    ----------------  ----------------------------------------------------------------
 *   06/11/2009 bgehlot        STGAP00014241 : To accommodate the changes being made as a result of STGAP00014235 
 *                             the case review page implementation should be revisited and revised if needed. 
 *   07/10/2009 bgehlot        STGAP00014653 : Update logic for setting Review Period/Review Type 
 *   08/07/2009 bgehlot        STGAP00015039: Set the review period in the 07/2009 format
 *   10/08/2009 bgehlot        SMS#38872: Add a new display field to the Case Review Detail page which displays the date the case 
 *                             review was marked Review Complete.
 */

public class SaveCaseReviewImpl extends BaseServiceImpl implements SaveCaseReview {

  private CaseReviewDAO caseReviewDAO = null;
  
  private TodoDAO todoDAO = null;
  
  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;

  private String EVENT_STATUS_COMP = "COMP";

  public void setCaseReviewDAO(CaseReviewDAO caseReviewDAO) {
    this.caseReviewDAO = caseReviewDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public int saveCaseReview(CaseReviewSaveSI caseReviewSaveSI) throws ServiceException {
    String eventReqFuncCd = "";
    int idEvent = caseReviewSaveSI.getIdCsrEvent();
    String cdPreviousCategory = null;
    String cdPreviousItem = null;
    int idCsrEvent = 0;
    int idCaseReviewCateg = 0;
    int idCaseReviewItem = 0;
    ROWCCMN01UIG00 caseReviewEvent = caseReviewSaveSI.getROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY caseReviewEvent_array = caseReviewSaveSI.getROWCCMN01UIG01_ARRAY();
    CCMN01UO ccmn01uo = new CCMN01UO();
    //SMS#38872: DO not update the event once in COMP status
    String previousEventStatus = "";

    //Get the Case REview record for that event.
    CaseReview caseReview = caseReviewDAO.findCaseReviewByIdEvent(idEvent);
    
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    //SMS#38872: DO not update the event once in COMP status
    if(event != null && idEvent != 0){
      previousEventStatus = event.getCdEventStatus();
      if(CodesTables.CEVTSTAT_COMP.equals(previousEventStatus) || CodesTables.CEVTSTAT_PROC.equals(previousEventStatus)
         || CodesTables.CEVTSTAT_NEW.equals(previousEventStatus)){
        //Get the date from the event table if it already exists.
        caseReviewEvent.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      }
    }
    // set add or update mode
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }

   
    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(caseReviewSaveSI.getCdReqFuncCd())) {
      //SMS#38872: DO not update the event once in COMP status
      if(!CodesTables.CEVTSTAT_COMP.equals(previousEventStatus)){
        ccmn01uo = callPostEvent(eventReqFuncCd, caseReviewEvent, caseReviewEvent_array);
        // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
        idEvent = ccmn01uo.getUlIdEvent();
      }
    }

    event = (Event) getPersistentObject(Event.class, idEvent);
    
    Stage stage = (Stage) getPersistentObject(Stage.class, caseReviewSaveSI.getIdStage());
   
    CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, caseReviewSaveSI.getIdCase());
    
    Person reviewerPerson = (Person) getPersistentObject(Person.class, caseReviewSaveSI.getIdReviewer());
    
    Date dtReview = caseReviewSaveSI.getDtDtReview();
    
    caseReview = new CaseReview();
    
    // if add or update or keep
    //STGAP00014241: Using a different CdReqFuncCd other than ADD or UPDATE as with NEW status we still want to do
    // ADD for other tables and UPDATE for CASE_REVIEW table.
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(caseReviewSaveSI.getCdReqFuncCd())
        || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(caseReviewSaveSI.getCdReqFuncCd())
        || ServiceConstants.REQ_FUNC_CD_KEEP.equals(caseReviewSaveSI.getCdReqFuncCd())) {
      
      if (idEvent != 0 && ServiceConstants.REQ_FUNC_CD_UPDATE.equals(caseReviewSaveSI.getCdReqFuncCd())) {
        caseReview = (CaseReview) getPersistentObject(CaseReview.class, idEvent);
        //STGAP00014653: Save this only when its user initiated case review as batch already has these values in the table and
        // they should not be updated when working on batch generated case review
        if(!CodesTables.CCSRTYPE_RT4.equals(caseReviewSaveSI.getCdReviewType())){
          caseReview.setCdReviewType(caseReviewSaveSI.getCdReviewType());
        }
      }
      
      //STGAP00014241: Using a different CdReqFuncCd other than ADD or UPDATE as with NEW status we still want to do
      // ADD for other tables and UPDATE for CASE_REVIEW table.
      if (idEvent != 0 && ServiceConstants.REQ_FUNC_CD_KEEP.equals(caseReviewSaveSI.getCdReqFuncCd())) {
        caseReview = (CaseReview) getPersistentObject(CaseReview.class, idEvent);
        //SMS#38872 The Date of Review represents the date the case review documentation was started
        caseReview.setDtReview(caseReviewSaveSI.getDtDtReview());
      }
      
      //STGAP00014653: Save these only when its user initiated case review as batch already has these values in the table and
      // they should not be updated when working on batch generated case review
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(caseReviewSaveSI.getCdReqFuncCd())) {
        //STGAP00015039: Set the review period in the 07/2009 format
        String zeroPrefix = "";
        if((DateHelper.getMonth(dtReview) + 1) < 10){
          zeroPrefix = "0";
        }
        caseReview.setReviewPeriod(zeroPrefix + FormattingHelper.formatInt(DateHelper.getMonth(dtReview) + 1) + "/" + 
                                   FormattingHelper.formatInt(DateHelper.getYear(dtReview)));
        caseReview.setCdReviewType(caseReviewSaveSI.getCdReviewType());
        //SMS#38872 The Date of Review represents the date the case review documentation was started
        caseReview.setDtReview(caseReviewSaveSI.getDtDtReview());
      }

      //Set the data into caseReview Object
      caseReview.setEvent(event);
      caseReview.setIdCsrEvent(caseReviewSaveSI.getIdCsrEvent());
      caseReview.setDtLastUpdate(caseReviewSaveSI.getDtLastUpdate());
      caseReview.setIndComplete(caseReviewSaveSI.getIndComplete());
      caseReview.setReviewerPerson(reviewerPerson);
      caseReview.setDtStaffedWithWorker(caseReviewSaveSI.getDtDtStaffedWithWorker());
      caseReview.setDtCorrectionDue(caseReviewSaveSI.getDtDtCorrectionDue());
      caseReview.setDtCorrectionComplete(caseReviewSaveSI.getDtDtCorrectionComplete());
      caseReview.setTxtSummaryComment(caseReviewSaveSI.getSzTxtSummaryComment());
      caseReview.setStage(stage);    
      caseReview.setCapsCase(capsCase);
      caseReview.setDtReviewComplete(caseReviewSaveSI.getDtDtReviewComplete());
      caseReviewDAO.saveCaseReview(caseReview);
      
      //Iterate through each questions
      Iterator<CaseReviewQuestionsSO> iter = caseReviewSaveSI.getCaseReviewQuestionsList().iterator();
      while (iter.hasNext()) {
        CaseReviewQuestionsSO question = (CaseReviewQuestionsSO) iter.next();

        // Each time the Category code changes, we must save the new Category information
        // to the database.
        if (cdPreviousCategory == null || !cdPreviousCategory.equals(question.getSzCdCategory())) {
          CaseReviewCateg caseReviewCateg = new CaseReviewCateg();
          caseReviewCateg.setEvent(event);
          caseReviewCateg.setCdCategory(question.getSzCdCategory());
          caseReviewCateg.setStage(stage); 
          //STGAP00014241: Using a different CdReqFuncCd other than ADD or UPDATE as with NEW status we still want to do
          // ADD for other tables and UPDATE for CASE_REVIEW table. 
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(caseReviewSaveSI.getCdReqFuncCd()) ||
                          ServiceConstants.REQ_FUNC_CD_KEEP.equals(caseReviewSaveSI.getCdReqFuncCd())){
            idCaseReviewCateg = caseReviewDAO.saveCaseReviewCateg(caseReviewCateg);
          } else{
            idCaseReviewCateg = caseReviewDAO.updateCaseReviewCateg(question.getSzCdCategory(), question.getIdCaseReviewCateg());
          }
          cdPreviousCategory = question.getSzCdCategory();
        }
        CaseReviewCateg caseReviewCateg = (CaseReviewCateg) getPersistentObject(CaseReviewCateg.class, idCaseReviewCateg);
        // Each time the Item code changes, we must save the new Item
        // information to the database.
        if (cdPreviousItem == null || !cdPreviousItem.equals(question.getSzCdItem())) {
          CaseReviewItem caseReviewItem = new CaseReviewItem();
          caseReviewItem.setEvent(event);
          caseReviewItem.setCdItem(question.getSzCdItem());
          caseReviewItem.setTxtComments(question.getTxtComments());
          caseReviewItem.setStage(stage);    
          caseReviewItem.setCaseReviewCateg(caseReviewCateg);
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(caseReviewSaveSI.getCdReqFuncCd())||
                          ServiceConstants.REQ_FUNC_CD_KEEP.equals(caseReviewSaveSI.getCdReqFuncCd())){
            idCaseReviewItem = caseReviewDAO.saveCaseReviewItem(caseReviewItem);
          }else{
            idCaseReviewItem = caseReviewDAO.updateCaseReviewItem(question.getTxtComments(), question.getIdCaseReviewItem());
          }
          cdPreviousCategory = question.getSzCdCategory();
          cdPreviousItem = question.getSzCdItem();
        }
        CaseReviewItem caseReviewItem = (CaseReviewItem) getPersistentObject(CaseReviewItem.class, idCaseReviewItem);
        
        // Each iteration through the Questions, we must save the new
        // question information to the database.
        CaseReviewQuesResponse caseReviewQuesResponse = new CaseReviewQuesResponse();
        caseReviewQuesResponse.setEvent(event);
        caseReviewQuesResponse.setCdQuestion(question.getSzCdQuestion());
        caseReviewQuesResponse.setCdQuesResponse(question.getSzCdQuestionResponse());
        caseReviewQuesResponse.setStage(stage);    
        caseReviewQuesResponse.setCaseReviewCateg(caseReviewCateg);
        caseReviewQuesResponse.setCaseReviewItem(caseReviewItem);
        caseReviewQuesResponse.setCdVersion(question.getCdVersion());
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(caseReviewSaveSI.getCdReqFuncCd())||
                        ServiceConstants.REQ_FUNC_CD_KEEP.equals(caseReviewSaveSI.getCdReqFuncCd())){
          caseReviewDAO.saveCaseReviewQuestions(caseReviewQuesResponse);
        }else{
          caseReviewDAO.updateCaseReviewQuestion(question.getSzCdQuestionResponse(), question.getIdCaseReviewQuestion());
        }
        
        // CheckBox Question:
        if(ArchitectureConstants.Y.equals(question.getIndCbx())){
          // delete current check boxes for that question
          caseReviewDAO.deleteCaseReviewChkBxByCdQuestion(question.getSzCdQuestion(), question.getCdVersion(), idEvent);

          List<String> checkedCheckboxesList = new ArrayList<String>();
          checkedCheckboxesList = Arrays.asList(caseReviewSaveSI.getCheckedCheckboxes());      
          Iterator<String> itCheckedCheckboxes = checkedCheckboxesList.iterator();

          // add newly selected check boxes for the question
          while (itCheckedCheckboxes.hasNext()) {
            CaseReviewCbxResponse caseReviewCbxResponse = new CaseReviewCbxResponse();
            caseReviewCbxResponse.setEvent(event);
            caseReviewCbxResponse.setCdCbxQuestion(itCheckedCheckboxes.next().toString());
            caseReviewCbxResponse.setCdQuestion(question.getSzCdQuestion());
            caseReviewCbxResponse.setCdVersion(question.getCdVersion());
            caseReviewDAO.saveCaseReviewCbxResponse(caseReviewCbxResponse);
          }
        } 
      }
      idCsrEvent = caseReview.getIdCsrEvent();
      
      // If the status is complete then the Event created through Batch has corresponding To do which needs to be deleted
      if(Boolean.TRUE.equals(caseReviewSaveSI.getIndTodoDelete())){
        Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
        // Get the idTodo for the reviewer and the event
        Integer idTodo = todoDAO.findIdToDoFromToDoByIdPersonIdEvent(caseReviewSaveSI.getIdReviewer(), idEvent);
        if(idTodo != null){
          Todo todo = todoDAO.findTodoByIdTodo(idTodo);
          todo.setDtTodoCompleted(dtToday);
          todoDAO.deleteTodo(todo);
        }
      }
    }
    
    // if delete
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(caseReviewSaveSI.getCdReqFuncCd())) {
      //Look for a Todo for that event, if it's there delete that To do. This comes into picture when a user with
      //DELETE_CASE_REVIEW security attributes wants to delete the Case Reviews createed by other users. 
      Integer idTodo = todoDAO.findIdToDoFromToDoByIdEvent(idEvent);
      if(idTodo != null){
        todoDAO.deleteTodoByIdEvent(idEvent);
      }
      caseReviewDAO.deleteCaseReviewByIdEvent(idEvent);
      caseReviewDAO.deleteCaseReviewCategByIdEvent(idEvent);
      caseReviewDAO.deleteCaseReviewItemByIdEvent(idEvent);
      caseReviewDAO.deleteCaseReviewQuesResponseByIdEvent(idEvent);
      caseReviewDAO.deleteCaseReviewCbxResponseByIdEvent(idEvent);
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_DELETE;
      ccmn01uo = callPostEvent(eventReqFuncCd, caseReviewEvent, caseReviewEvent_array);
    }
    
    //Create an alert
    callAlert(caseReviewSaveSI.getIndCaseReviewComplete(), stage.getIndStageClose(), caseReviewSaveSI.getDtDtCorrectionDue(),
              caseReviewEvent.getSzCdEventStatus(), caseReviewSaveSI.getIdCaseWorker(), capsCase, stage);
    
    return idCsrEvent;
  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00,
                                 ROWCCMN01UIG01_ARRAY rowccmn01uig01_array) throws ServiceException {

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }
  
  private void callAlert(boolean indCaseReviewComplte, String stageClosed, Date dtCorrectionsDue, String cdEventStatus, 
                         int idPrimaryCaseWorker, CapsCase capsCase, Stage stage){

    //Create an alert for the primary case manager on that case for open stages when the Case Review is complete
    if(indCaseReviewComplte && ArchitectureConstants.N.equals(stageClosed) && dtCorrectionsDue != null 
                    && EVENT_STATUS_COMP.equals(cdEventStatus)){
      Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      String todoDesc = "Complete Case Review Corrections by "+ dtCorrectionsDue +".";
      String todoLongDesc = "Complete Case Review Corrections by "+ dtCorrectionsDue +".";
      todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, dtToday, capsCase, stage);

    }
    
  }

  //This method saves the To Do or Alert 
  private void todoSaveHelper(String todoDesc, String todoLongDesc, Integer idPerson, Date dueDate,
                              CapsCase capsCase, Stage stage){
    Todo todo = new Todo();
    String cdTask = "";
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    todo.setPersonByIdTodoPersAssigned(personDAO.findPersonByIdPerson(idPerson));
    todo.setTxtTodoDesc(todoDesc);
    todo.setTxtTodoLongDesc(todoLongDesc);
    todo.setCdTodoTask(cdTask);
    todo.setDtTodoDue(dueDate);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setCapsCase(capsCase);
    todo.setDtTodoCreated(dtToday);
    todo.setStage(stage);
    todoDAO.saveTodo(todo);
  }
}