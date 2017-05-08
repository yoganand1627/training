package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCaseReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlanGoalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseReview;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.PlanGoal;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveCaseReview;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseReviewRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewQuestionsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseReviewRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class provides the service that retrieves the case review.
 * 
 * @author  Bhavna Gehlot March 16 , 2009
 * 
 */

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  ----------------------------------------------------------------
 **  5/31/2009  bgehlot        STGAP00013989 : Changed code so that contact log displays correctly
 **  06/11/2009 bgehlot        STGAP00014241 : To accommodate the changes being made as a result of STGAP00014235 
 *                             the case review page implementation should be revisited and revised if needed. 
 *   07/10/2009 bgehlot        STGAP00014653 : Update logic for setting Review Period/Review Type 
 *   08/07/2009 bgehlot        STGAP00015039: Set the review period in the 07/2009 format
 *   09/14/2009 bgehlot        STGAP00014598: Get PR or HP Case Manager for the stage 
 *   09/21/2009 bgehlot        STGAP00014667: Get the hasSixMonthRecurrence from Materialized view so that page loads faster, if it 
 *                             returns empty string or null then get it by using other query. 
 *   10/09/2009 bgehlot        SMS#38872: Add a new display field to the Case Review Detail page which displays the date the case 
 *                             review was marked 'Review Complete'.
 *   12/15/2009 arege          SMS#37372 Sample Case Review should not show logged in Case Manager as reviewer when the Case Review is in NEW status. 
 *   12/23/2009 bgehlot        SMS#42495: Display Question numbers in front of the Question text
 */

public class RetrieveCaseReviewImpl extends BaseServiceImpl implements RetrieveCaseReview {

  private ComplexCaseReviewDAO complexCaseReviewDAO = null;
  private StageDAO stageDAO = null;
  private CapsCaseDAO capsCaseDAO = null;
  private PersonDAO personDAO = null;
  private EventDAO eventDAO = null;
  private CaseReviewDAO caseReviewDAO = null;
  private ContactDAO contactDAO = null;
  private CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private EmpJobHistoryDAO empJobHistoryDAO = null;
  private TodoDAO todoDAO = null;
  private LegalActionDAO legalActionDAO = null;
  private LegalStatusDAO legalStatusDAO = null;
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  private PlanGoalDAO planGoalDAO = null;
  private AllegationDAO allegationDAO = null;
  private FCCPFamilyDAO fccpFamilyDAO = null;

  public void setComplexCaseReviewDAO(ComplexCaseReviewDAO complexCaseReviewDAO) {
    this.complexCaseReviewDAO = complexCaseReviewDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCaseReviewDAO(CaseReviewDAO caseReviewDAO) {
    this.caseReviewDAO = caseReviewDAO;
  }
  
  public void setContactDAO(ContactDAO contactDAO) {
    this.contactDAO = contactDAO;
  }

  public void setCnsrvtrshpRemovalDAO(CnsrvtrshpRemovalDAO cnsrvtrshpRemovalDAO) {
    this.cnsrvtrshpRemovalDAO = cnsrvtrshpRemovalDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO){
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO) {
    this.legalStatusDAO = legalStatusDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPlanGoalDAO(PlanGoalDAO planGoalDAO) {
    this.planGoalDAO = planGoalDAO;
  }

  public void setAllegationDAO(AllegationDAO allegationDAO) {
    this.allegationDAO = allegationDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }
  
  public CaseReviewRetrieveSO retrieveCaseReview(CaseReviewRetrieveSI caseReviewRetrieveSI)
  throws ServiceException {
    CaseReviewRetrieveSO caseReviewRetrieveSO = new CaseReviewRetrieveSO();
    int idEvent = caseReviewRetrieveSI.getIdCaseRevEvent();
    String cdEventStatus = StringHelper.EMPTY_STRING;

    //If the event Already exists
    if (idEvent != 0) {
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if (event == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      //Get the current status of the event
      cdEventStatus = event.getCdEventStatus();
      
      //Get the Case REview record for that event.
      CaseReview caseReview = caseReviewDAO.findCaseReviewByIdEvent(idEvent);

      //CaseReview when Status is NEW
      if(CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)){
        //Set the Sample Review for the Review Type Drop down
        caseReviewRetrieveSO.setCdReviewType(CodesTables.CCSRTYPE_RT4);
        
        //STGAP00014241: Using a different CdReqFuncCd other than ADD or UPDATE as with NEW status we still want to do
        // ADD for other tables and UPDATE for CASE_REVIEW table. Set the CdReqFuncCd variable
        caseReviewRetrieveSO.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_KEEP);
       
        //Set the variable to true if there is no To do for that event.The user 
        // cannot update the Case Review in NEW status if she does not have To do in her To Do List for that event
        //She should see all the fields disabled.
        if( todoDAO.findIdToDoFromToDoByIdPersonIdEvent(caseReviewRetrieveSI.getIdStaff(), idEvent) != null ){
          caseReviewRetrieveSO.setDisableCdReviewType(false);
        }else{
          caseReviewRetrieveSO.setDisableCdReviewType(true);
        }
        //Set the review date to pass in the prepopulateQuestions method
        Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
        caseReviewRetrieveSO.setDtReview(currentDate);

        //Pre populate Question Responses based on the rules.
        caseReviewRetrieveSO = prepopulateQuestions(caseReviewRetrieveSI, caseReviewRetrieveSO);
        
        caseReviewRetrieveSO = displayCaseReviewQuestions(caseReviewRetrieveSI, caseReviewRetrieveSO);
      }else{
       // Displays the questions
        caseReviewRetrieveSO = displayCaseReviewQuestions(caseReviewRetrieveSI, caseReviewRetrieveSO);
      }

      if(caseReview != null && CodesTables.CEVTSTAT_PROC.equals(cdEventStatus)){
        //Set the CdReqFuncCd variable
        caseReviewRetrieveSO.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        
        //Set the ReviewerInitiatedCaseReview variable to true if there is no To Do for that event.
        if( todoDAO.findIdToDoFromToDoByIdPersonIdEvent(caseReviewRetrieveSI.getIdStaff(), idEvent) != null ){
          caseReviewRetrieveSO.setReviewerInitiatedCaseReview(false);
        }else{
          caseReviewRetrieveSO.setReviewerInitiatedCaseReview(true);
        }
      }
      
      //If  the current status is COMP still the CdReqFuncCd is UPDATE as the "Date Corrections Completed" is always
      //enabled with Save button to save.
      if(CodesTables.CEVTSTAT_COMP.equals(cdEventStatus)){
        caseReviewRetrieveSO.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      }

      //Displays the questions with the Responses
      caseReviewRetrieveSO = processCaseReviewDetails(caseReviewRetrieveSI, caseReviewRetrieveSO);
      // Retrieve case review event
      caseReviewRetrieveSO.setROWCCMN45DO(processEventDAO(idEvent));
      caseReviewRetrieveSO.setIdCaseRevEvent(idEvent);
    } else {
      //Set the review date to pass in the prepopulateQuestions method
      Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
      caseReviewRetrieveSO.setDtReview(currentDate);
      
      //STGAP00014653: Review period is the current month for the user initiated case review only
      int month = DateHelper.getMonth(currentDate) + 1;
      int year = DateHelper.getYear(currentDate);
     //STGAP00015039: Set the review period in the 07/2009 format
      String zeroPrefix = "";
      if(month < 10){
        zeroPrefix = "0";
      }
      caseReviewRetrieveSO.setReviewPeriod(zeroPrefix + FormattingHelper.formatInt(month) + "/" + 
                                           FormattingHelper.formatInt(year));
      
      //Pre populate Question Responses based on the rules.
      caseReviewRetrieveSO = prepopulateQuestions(caseReviewRetrieveSI, caseReviewRetrieveSO);

      // Displays the questions
      caseReviewRetrieveSO = displayCaseReviewQuestions(caseReviewRetrieveSI, caseReviewRetrieveSO);

      caseReviewRetrieveSO.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      caseReviewRetrieveSO.setIdCaseRevEvent(idEvent);
    }
    return caseReviewRetrieveSO;
  }


  private ROWCCMN45DO processEventDAO(int idEvent) throws ServiceException {

    // Calling ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

  private CaseReviewRetrieveSO displayCaseReviewQuestions(CaseReviewRetrieveSI caseReviewRetrieveSI, CaseReviewRetrieveSO caseReviewRetrieveSO) {
    List<CaseReviewQuestionsSO> caseReviewQuestionList = new ArrayList<CaseReviewQuestionsSO>();
    int idStage = caseReviewRetrieveSI.getIdStage();
    int idCase = caseReviewRetrieveSI.getIdCase();

    //get case information
    CapsCase stageCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    if (stageCase == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }


    //get stage information
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    String cdRegion = stage.getCdStageRegion();
    String cdCounty = stage.getCdStageCnty();
    String nmCase = stageCase.getNmCase();
    String cdCaseProgram = stage.getCdStage();
    Date dtStageOpened = stage.getDtStageStart();
    Integer idCW = null;
    int idCaseWorker = 0;
    
    //STGAP00014598: Get the Case Worker for open and Closed stage
    idCW = stagePersonLinkDAO.findIdCaseWorkerByIdStageAndCdStagePersRole(idStage);
    
    idCaseWorker = idCW != null ? idCW : 0;
    
    String nmCaseWorker = personDAO.findNmFullByIdPerson(idCaseWorker);
    //SMS#37372 Sample Case Review should not show logged in Case Manager as reviewer when the Case Review is in NEW status. 
    int idReviewer = 0;
    if (!CodesTables.CCSRTYPE_RT4.equals(caseReviewRetrieveSO.getCdReviewType())) {
      idReviewer = caseReviewRetrieveSI.getIdStaff();
      String nmReviewer = personDAO.findNmFullByIdPerson(idReviewer);
      String cdjobTitle = empJobHistoryDAO.findEmpJobTitle(idReviewer);
      caseReviewRetrieveSO.setNmReviewer(nmReviewer + ", " + Lookup.simpleDecodeSafe(CodesTables.CTITLEA, cdjobTitle)); // CEMPJBCL
    }

    String cdStage = stage.getCdStage();
    Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());

    //If the stage is FCC then the stage open date is the removal date
    if(CodesTables.CSTAGES_SUB.equals(cdStage)){
      Integer idPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
      if(idPerson != null){
        Date dtRemoval = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(idCase, idPerson);
        dtStageOpened = dtRemoval;
      }
    }

    caseReviewRetrieveSO.setCdRegion(Lookup.simpleDecodeSafe(CodesTables.CREGIONS, cdRegion));
    caseReviewRetrieveSO.setCdCounty(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, cdCounty));
    caseReviewRetrieveSO.setNmCase(nmCase);
    caseReviewRetrieveSO.setNmCaseWorker(nmCaseWorker);
    caseReviewRetrieveSO.setCdCaseProgram(Lookup.simpleDecodeSafe(CodesTables.CSTAGES, cdCaseProgram));
    caseReviewRetrieveSO.setDtStageOpened(dtStageOpened);
    caseReviewRetrieveSO.setIdCaseWorker(idCaseWorker);
    caseReviewRetrieveSO.setIdCase(idCase);
    caseReviewRetrieveSO.setDtReview(currentDate);
    
    //get the questions to be displayed on the page
    List<Map<String, Object>> questionsList =  complexCaseReviewDAO.findCaseReviewQuestions(cdStage, caseReviewRetrieveSI.getMaxVersion());

    if (questionsList != null && !questionsList.isEmpty()) {
      Iterator<Map<String, Object>> itquestionsList = questionsList.iterator();

      while (itquestionsList.hasNext()) {
        CaseReviewQuestionsSO caseReviewQuestionsSO = new CaseReviewQuestionsSO();
        Map<String, Object> questionMap =  (Map<String, Object>) itquestionsList.next();
        caseReviewQuestionsSO.setSzCdCategory((String) questionMap.get("cdCategory"));
        caseReviewQuestionsSO.setSzTxtCategory((String) questionMap.get("txtCategory"));
        caseReviewQuestionsSO.setNbrCategoryOrder((Integer) questionMap.get("nbrCategoryOrder"));
        caseReviewQuestionsSO.setSzCdItem((String) questionMap.get("cdItem"));
        caseReviewQuestionsSO.setSzTxtItem((String) questionMap.get("txtItem"));
        caseReviewQuestionsSO.setNbrItemOrder((Integer) questionMap.get("nbrItemOrder"));
        caseReviewQuestionsSO.setSzCdQuestion((String) questionMap.get("cdQuestion"));
        caseReviewQuestionsSO.setSzTxtQuestion((String) questionMap.get("txtQuestion"));
        caseReviewQuestionsSO.setNbrQuestionOrder((Integer) questionMap.get("nbrQuestionOrder"));
        caseReviewQuestionsSO.setIndCbx((String) questionMap.get("indCbx"));
        caseReviewQuestionsSO.setIndQuestionType((String) questionMap.get("indQuestionType"));
        caseReviewQuestionsSO.setCdVersion((Integer) questionMap.get("cdVersion"));
        caseReviewQuestionsSO.setTxtQuesHelp((String) questionMap.get("txtQuesHelp"));
        caseReviewQuestionsSO.setTxtQuestionNum((String) questionMap.get("txtQuestionNum") + " ");

        if(ArchitectureConstants.Y.equals(caseReviewQuestionsSO.getIndCbx())){
          //Get the check boxes for the questions
          List<CodeAttributes> cbxQuestionList = getCategoryCollection(caseReviewQuestionsSO.getSzCdQuestion(), caseReviewQuestionsSO.getCdVersion());
          caseReviewQuestionsSO.setCaseReviewCbxQuestionsList(cbxQuestionList);
        }
        caseReviewQuestionList.add(caseReviewQuestionsSO);
      }
      caseReviewRetrieveSO.setCaseReviewQuestionsList(caseReviewQuestionList);
      
      //Display the Contact Log under Item 19 of Well Being
      if (caseReviewQuestionList != null && !caseReviewQuestionList.isEmpty()) {
        Iterator<CaseReviewQuestionsSO> itcaseReviewQuestionList = caseReviewQuestionList.iterator();
        while (itcaseReviewQuestionList.hasNext()) {
          CaseReviewQuestionsSO caseReviewQuestionsSO = itcaseReviewQuestionList.next();
          List<Map<String,Object>>  contactSummaryList = new ArrayList<Map<String,Object>>();
          //Get the item type for which the contact log need to be displayed.
          String contactSummary = caseReviewRetrieveSI.getContactSummary();
          if(!StringHelper.isEmptyOrNull(contactSummary)){
            if(contactSummary.equals(caseReviewQuestionsSO.getSzCdItem())){
              //Get all the contact dates for all the principals for the date  range for the case
              List<Map<String,Object>> contactSummaryListDB = contactDAO.findContactsByIdCaseIdPersonWithinDates(idCase, caseReviewRetrieveSI.getFromDate(), caseReviewRetrieveSI.getToDate());
               if (contactSummaryListDB != null && !contactSummaryListDB.isEmpty()) {
                 Iterator<Map<String,Object>> itcontactSummaryList = contactSummaryListDB.iterator();
                 int prevIdPerson = 0;
                 String nmPersonFull = StringHelper.EMPTY_STRING;
                 String cdStagePersRelInt = StringHelper.EMPTY_STRING;
                 String Month1 = StringHelper.EMPTY_STRING;
                 String Month2 = StringHelper.EMPTY_STRING;
                 String Month3 = StringHelper.EMPTY_STRING;
                 String Month4 = StringHelper.EMPTY_STRING;
                 String Month5 = StringHelper.EMPTY_STRING;
                 String Month6 = StringHelper.EMPTY_STRING;
                 while (itcontactSummaryList.hasNext()) {
                   Map<String,Object> map = itcontactSummaryList.next();
                   Map<String,Object> mapPerson = new HashMap<String,Object>();
                   int idPerson = (Integer) map.get("idPerson");
                   //If the person id is same
                   if(prevIdPerson == 0 || idPerson == prevIdPerson){
                     nmPersonFull = (String)map.get("nmPersonFull");
                     cdStagePersRelInt = (String)map.get("cdStagePersRelInt");
                     Date dtContactOccurred = (Date) map.get("dtContactOccurred");
                     String cdContactLocation = (String) map.get("cdContactLocation");
                     cdContactLocation = Lookup.simpleDecodeSafe( "CCNCTLOC", cdContactLocation);
                     //If Location is not empty then put the dash "-" in front of it.
                     if(!StringHelper.isEmptyOrNull(cdContactLocation)){
                       cdContactLocation = " - " + cdContactLocation;
                     }else{
                       cdContactLocation = StringHelper.EMPTY_STRING;
                     }
                     //Compare the contact month with the months of the past six months and concatenate the dates and location 
                     // which lies in the same months
                     if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(caseReviewRetrieveSI.getToDate())){
                       Month1 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -1, 0))){
                       Month2 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -2, 0))){
                       Month3 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -3, 0))){
                       Month4 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -4, 0))){
                       Month5 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -5, 0))){
                       Month6 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }
                   }else{
                     //Put the name relationship and months in the Map
                     mapPerson.put("nmPersonFull", nmPersonFull);
                     mapPerson.put("cdStagePersRelInt", cdStagePersRelInt);
                     mapPerson.put("Month1", Month1);
                     mapPerson.put("Month2", Month2);
                     mapPerson.put("Month3", Month3);
                     mapPerson.put("Month4", Month4);
                     mapPerson.put("Month5", Month5);
                     mapPerson.put("Month6", Month6);
                     //add the map to the list
                     contactSummaryList.add(mapPerson);
                     Month1 = StringHelper.EMPTY_STRING;
                     Month2 = StringHelper.EMPTY_STRING;
                     Month3 = StringHelper.EMPTY_STRING;
                     Month4 = StringHelper.EMPTY_STRING;
                     Month5 = StringHelper.EMPTY_STRING;
                     Month6 = StringHelper.EMPTY_STRING;
                     mapPerson = new HashMap<String,Object>();
                     //STGAP00013989 : Added this code here
                     nmPersonFull = (String)map.get("nmPersonFull");
                     cdStagePersRelInt = (String)map.get("cdStagePersRelInt");
                     Date dtContactOccurred = (Date) map.get("dtContactOccurred");
                     String cdContactLocation = (String) map.get("cdContactLocation");
                     cdContactLocation = Lookup.simpleDecodeSafe( "CCNCTLOC", cdContactLocation);
                     //If Location is not empty then put the dash "-" in front of it.
                     if(!StringHelper.isEmptyOrNull(cdContactLocation)){
                       cdContactLocation = " - " + cdContactLocation;
                     }else{
                       cdContactLocation = StringHelper.EMPTY_STRING;
                     }
                     //Compare the contact month with the months of the past six months and concatenate the dates and location 
                     // which lies in the same months
                     if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(caseReviewRetrieveSI.getToDate())){
                       Month1 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -1, 0))){
                       Month2 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -2, 0))){
                       Month3 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -3, 0))){
                       Month4 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -4, 0))){
                       Month5 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }else if(DateHelper.getMonth(dtContactOccurred)== DateHelper.getMonth(DateHelper.addToDate(caseReviewRetrieveSI.getToDate(), 0, -5, 0))){
                       Month6 += FormattingHelper.formatDate(dtContactOccurred) + cdContactLocation + "<br>";
                     }
                   }
                   prevIdPerson = idPerson;
                   
                   //If it's the last record Put the values in the map and add to the list
                   if(!itcontactSummaryList.hasNext()){
                     mapPerson.put("nmPersonFull", nmPersonFull);
                     mapPerson.put("cdStagePersRelInt", cdStagePersRelInt);
                     mapPerson.put("Month1", Month1);
                     mapPerson.put("Month2", Month2);
                     mapPerson.put("Month3", Month3);
                     mapPerson.put("Month4", Month4);
                     mapPerson.put("Month5", Month5);
                     mapPerson.put("Month6", Month6);
                     contactSummaryList.add(mapPerson);
                   }
                 }
               }
               //Set the list to the output object
               caseReviewRetrieveSO.setContactSummaryList(contactSummaryList);
               break;
            }
          }
        }
        
      }
    }
    return caseReviewRetrieveSO;
  }

  private CaseReviewRetrieveSO prepopulateQuestions(CaseReviewRetrieveSI caseReviewRetrieveSI, CaseReviewRetrieveSO caseReviewRetrieveSO) {
    String YES = "0";
    String NO = "1";
    Map<String, String> prepopulatedData = new HashMap<String, String>();

    int idCase = caseReviewRetrieveSI.getIdCase();
    int idStage = caseReviewRetrieveSI.getIdStage();

    //get stage information
    Stage stage = stageDAO.findStageByIdStage(idStage);
    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    //get the cdStage    
    String cdStage = stage.getCdStage();

    //Safety Questions Pre population
    if(CodesTables.CSTAGES_FPR.equals(cdStage) || CodesTables.CSTAGES_INV.equals(cdStage)){
 
      Integer idStageINVObj = stageDAO.findIdStageByIdCaseAndCdStage(idCase, CodesTables.CSTAGES_INV);
      int idStageINV = idStageINVObj != null ? idStageINVObj : 0;
      List<Integer> idVictimsList = allegationDAO.findPersonByIdVictimByIdStage(idStageINV);
      
      //STGAP00014667: Check to see if the Materialized View Exists.
      boolean materializedViewExists = true;
      try{
        String hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatmentFromMaterializedView(idStageINV);
      }catch(Exception e){
        materializedViewExists = false;
      }

      //Safety Question Q09 2 Item2 
      if (idVictimsList != null && !idVictimsList.isEmpty()) {
        Iterator<Integer> iter = idVictimsList.iterator();
        while(iter.hasNext()){
          int idAllegedVictim = iter.next();
          //STGAP00014667: Get the hasSixMonthRecurrence from Materialized view so that page loads faster, if it returns empty string or null
          // then get it by using other query. 
          String hasSixMonthRecurrence = "";
          if(materializedViewExists){
            hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatmentFromMaterializedView(idStageINV);
          }
          if(hasSixMonthRecurrence == null || StringHelper.EMPTY_STRING.equals(hasSixMonthRecurrence)){
            hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatment(idAllegedVictim, idCase);
          }
          if(ArchitectureConstants.N.equals(hasSixMonthRecurrence) || NO_RECUR.equals(hasSixMonthRecurrence) ){
            prepopulatedData.put("Q09", YES);            
          }else{
            prepopulatedData.put("Q09", NO);
            break;
          }
        }
      }

      //Safety Question Q10 2.1 Item2
      List<Integer> idAllegedPerpList = new ArrayList<Integer>();
      if (idVictimsList != null && !idVictimsList.isEmpty()) {
        Iterator<Integer> iter = idVictimsList.iterator();
        while(iter.hasNext()){
          int idAllegedVictim = iter.next();
          //STGAP00014667: Get the hasSixMonthRecurrence from Materialized view so that page loads faster, if it returns empty string or null
          // then get it by using other query. 
          String hasSixMonthRecurrence = "";
          if(materializedViewExists){
            hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatmentFromMaterializedView(idStageINV);
          }
          if(hasSixMonthRecurrence == null || StringHelper.EMPTY_STRING.equals(hasSixMonthRecurrence)){
            hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatment(idAllegedVictim, idCase);
          }
          List<Integer> idAllegedPerpListCurrent = allegationDAO.findpersonByIdAllegedPerpetratorByIdStage(idStageINV, idAllegedVictim);
          List<String> idAllegedPerpListCurrentStr = new ArrayList<String>();
          if(idAllegedPerpListCurrent != null){
            for(int i = 0; i < idAllegedPerpListCurrent.size() ; i++){
              idAllegedPerpListCurrentStr.add(idAllegedPerpListCurrent.get(i).toString());
            }
          }
          if(ArchitectureConstants.Y.equals(hasSixMonthRecurrence) || YES_RECUR.equals(hasSixMonthRecurrence) ){
            List<String> idAllegedPerpListStr = new ArrayList<String>();
            idAllegedPerpList = allegationDAO.findpersonByIdAllegedPerpetratorByIdVictim(idAllegedVictim);
            if(idAllegedPerpList != null){
              for(int i = 0; i < idAllegedPerpList.size() ; i++){
                idAllegedPerpListStr.add(idAllegedPerpList.get(i).toString());
              }
            }
            if(idAllegedPerpListStr != null && idAllegedPerpListCurrentStr != null){
              Collection<String> differentAllegedPerp = getNonOverlapping(idAllegedPerpListStr, idAllegedPerpListCurrentStr);
              if(differentAllegedPerp != null && !differentAllegedPerp.isEmpty()){
                prepopulatedData.put("Q10", YES);
                break;
              }else{
                prepopulatedData.put("Q10", NO);
              }
            }
          }
        }
      }

      //Safety Question Q11 2.2 Item2
      List<String> cdAllegTypeList = new ArrayList<String>();
      if (idVictimsList != null && !idVictimsList.isEmpty()) {
        Iterator<Integer> iter = idVictimsList.iterator();
        while(iter.hasNext()){
          int idAllegedVictim = iter.next();
          //STGAP00014667: Get the hasSixMonthRecurrence from Materialized view so that page loads faster, if it returns empty string or null
          // then get it by using other query. 
          String hasSixMonthRecurrence = "";
          if(materializedViewExists){
            hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatmentFromMaterializedView(idStageINV);
          }
          if(hasSixMonthRecurrence == null || StringHelper.EMPTY_STRING.equals(hasSixMonthRecurrence)){
            hasSixMonthRecurrence = allegationDAO.findRecurrenceOfMaltreatment(idAllegedVictim, idCase);
          }
          List<String> cdAllegTypeListCurrent = allegationDAO.findCdAllegTypeByIdStageIdVictim(idStageINV, idAllegedVictim);
          if(ArchitectureConstants.Y.equals(hasSixMonthRecurrence) || YES_RECUR.equals(hasSixMonthRecurrence)){
            cdAllegTypeList = allegationDAO.findCdAllegTypeByIdVictim(idAllegedVictim);
            if(cdAllegTypeList != null && cdAllegTypeListCurrent != null){
              Collection<String> differentAllegedType = getNonOverlapping(cdAllegTypeList, cdAllegTypeListCurrent);
              if(differentAllegedType != null && !differentAllegedType.isEmpty()){
                prepopulatedData.put("Q11", YES);
                break;
              }else{
                prepopulatedData.put("Q11", NO);
              }
            }
          }
        }
      }
    }
    
    //Permanency Questions Prepopulation
    if(CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)){
      Integer idPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
      if(idPerson != null){
        //Permanency question Q41 5 Item 5
        Character hasTwelveMonthRecurrence = legalStatusDAO.findTwelveMonthRecurrence(idStage, idCase, idPerson);
        if(ArchitectureConstants.N.toCharArray()[0] == (hasTwelveMonthRecurrence.charValue())){
          prepopulatedData.put("Q41", YES);            
        }else{
          prepopulatedData.put("Q41", NO);
        }
        
        //Permanency question Q70 9.1 Item5
        Date dtRemoval = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(idCase, idPerson);
        
        if(dtRemoval != null){
          boolean isGreaterthan15months = false;
          List<String> cdLegalStatuses = new ArrayList<String>();
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NAF);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NCD);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NCT);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NCO);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NPR);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NTT);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NCE);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NGP);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NPC);
          cdLegalStatuses.add(CodesTables.CLEGSTAT_NCS);
          
          //Get the month difference between the dtRemoval and the dtLegalStatusStat for the above legal status' type
          Float monthsBetween = legalStatusDAO.findCurrentLegalStatusByIdPersonCdLegalStatuses(idPerson,cdLegalStatuses, dtRemoval);
          
          //If the month difference above is null then get the month difference between the previous month of dtReview and the dtRemoval
          if(monthsBetween == null){
            Date toDate = DateHelper.addToDate(DateHelper.getLastDayOfTheMonth(caseReviewRetrieveSO.getDtReview()), 0, -1, 0);  
            monthsBetween = legalStatusDAO.findMonthDiff(toDate, dtRemoval);
          }
          
          if(monthsBetween < 0 ){
            monthsBetween = -monthsBetween;
          } 
          //If the  month difference is greater than 15
          if(monthsBetween > 15){
            isGreaterthan15months = true;
          }

          
          List<String> cdHrTypCrtOrds = new ArrayList<String>();
          cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR- Legal/Biological Father
          cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR- Legal Father
          cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
          cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Mother
          if(isGreaterthan15months){
            //Check to seee if the LEgal Action of type Petition Files exists with above TPRs
            List<LegalAction> legalActionListBycdHrTypCrtOrd = legalActionDAO.findLegalActionBycdHrTypCrtOrd(idCase, idPerson, cdHrTypCrtOrds, CodesTables.CLEGCPS_PFD);
            if(legalActionListBycdHrTypCrtOrd != null && !legalActionListBycdHrTypCrtOrd.isEmpty()){
              prepopulatedData.put("Q70", YES);
            }else{
              prepopulatedData.put("Q70", NO);
            }
          }
        }

        //Permanency question Q71 9.2 Item5
        List<String> cdHrTypCrtOrds = new ArrayList<String>();
        cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL); // TPR- Legal/Biological Father
        cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF); // TPR- Legal Father
        cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB); // TPR - Biological Father
        cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM); // TPR - Mother
        
        //Outcomes Appeal Approved, denied
        List<String> cdOutcomes = new ArrayList<String>();
        cdOutcomes.add(CodesTables.CLEGLOUT_APA);
        cdOutcomes.add(CodesTables.CLEGLOUT_APD);
        
        //Checl to see if the Legal Action of type Appeal exists.
        List<LegalAction> legalActionListBycdHrTypCrtOrd = legalActionDAO.findLegalActionBycdHrTypCrtOrd(idCase, idPerson, cdHrTypCrtOrds, CodesTables.CLEGCPS_APL);
        if(legalActionListBycdHrTypCrtOrd != null && !legalActionListBycdHrTypCrtOrd.isEmpty()){
          List<LegalAction> legalActionListBycdHrTypCrtOrdAndcdOutcomes = legalActionDAO.findLegalActionBycdHrTypCrtOrdAndcdOutcomes(idCase, idPerson, cdHrTypCrtOrds, cdOutcomes);
          if(legalActionListBycdHrTypCrtOrdAndcdOutcomes != null && !legalActionListBycdHrTypCrtOrdAndcdOutcomes.isEmpty()){
            prepopulatedData.put("Q71", YES);
          }else{
            prepopulatedData.put("Q71", NO);
          }
        }

        //Permanency question Q75 9.6 Item5
        List<String> cdEventStatuses = new ArrayList<String>();
        cdEventStatuses.add(CodesTables.CEVTSTAT_APRV);
        List<Event> eventList = eventDAO.findEventByIdCaseAndCdEventTypeDesc(idCase, CodesTables.CEVNTTYP_PLN, cdEventStatuses);
        if(eventList != null && !eventList.isEmpty()){
          Iterator<Event> iter = eventList.iterator();
          while(iter.hasNext()){
            Event event = iter.next();
            EventPersonLink epL = eventPersonLinkDAO.findEventPersonLinkByIdEventAndIdPerson(event.getIdEvent().intValue(),
                                                                                             idPerson);
            if(epL != null){
              PlanGoal planGoal = planGoalDAO.findFCGSByIdEventByCdGoalTypeCdGoalRsn(event.getIdEvent(), CodesTables.CCTPLNTY_NRE, CodesTables.CNRRSN_ADO);
              if(planGoal != null){
                prepopulatedData.put("Q75", YES);
                break;
              }else{
                prepopulatedData.put("Q75", NO);
              }
            }
          }
        }
      }
    }

    //Well Being Questions Pre population
    if(CodesTables.CSTAGES_SUB.equals(cdStage) || CodesTables.CSTAGES_ADO.equals(cdStage)){
      Integer idPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
      if(idPerson != null){
        Date dtRemoval = cnsrvtrshpRemovalDAO.findLatestCnsrvtrshpRemovalDatetByIdCase(idCase, idPerson);
        Date dtCurrRev = fccpFamilyDAO.findEarliestDtCurrRevByIdCase(idCase, dtRemoval);
        if(dtRemoval != null && dtCurrRev != null){
          long daysBetween = (long) (DateHelper.minutesDifference(dtCurrRev, dtRemoval) / (60.0 * 24.0));      
          if(daysBetween < 0){
            daysBetween = -daysBetween;
          }
          if(daysBetween > 30){
            prepopulatedData.put("Q139", NO);
          }else{
            prepopulatedData.put("Q139", YES);
          }
        }
      }
    }//End Well Being PrePopulation


    caseReviewRetrieveSO.setPrepopulatedData(prepopulatedData);
    return caseReviewRetrieveSO;

  }

  private CaseReviewRetrieveSO processCaseReviewDetails(CaseReviewRetrieveSI caseReviewRetrieveSI, CaseReviewRetrieveSO caseReviewRetrieveSO) {
    List<CaseReviewQuestionsSO> caseReviewQuestionList = new ArrayList<CaseReviewQuestionsSO>();
    String MAIN_QUESTION = "M";    
    String DECISION_QUESTION = "D";    
    String NO_QUES_RESPONSE = "1";
    int idEvent = caseReviewRetrieveSI.getIdCaseRevEvent();
    int idStage = caseReviewRetrieveSI.getIdStage();
    String nmReviewer = StringHelper.EMPTY_STRING;
    String cdEventStatus = StringHelper.EMPTY_STRING;
    
    //Get the Case Review record for  that event
    CaseReview caseReview = caseReviewDAO.findCaseReviewByIdEvent(idEvent);
    String cdPreviousItem = null;
    
    //STGAP00014241: get the event status 
    if (idEvent != 0) {
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if (event == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      //Get the current status of the event
      cdEventStatus = event.getCdEventStatus();
    }
    
    //STGAP00014241: if status is not NEW get the data as all these data will not be saved
    // in CASE_REVIEW table even though a record will exists in that table.
    if (caseReview != null && !CodesTables.CEVTSTAT_NEW.equals(cdEventStatus))
    {
      String cdjobTitle = empJobHistoryDAO.findEmpJobTitle(caseReview.getReviewerPerson().getIdPerson());
      caseReviewRetrieveSO.setIdCaseRevEvent(caseReview.getIdCsrEvent());
      caseReviewRetrieveSO.setIndComplete(caseReview.getIndComplete());
      caseReviewRetrieveSO.setCdReviewType(caseReview.getCdReviewType());
      caseReviewRetrieveSO.setDtReview(caseReview.getDtReview());  
      caseReviewRetrieveSO.setIdReviewer(caseReview.getReviewerPerson().getIdPerson());
      nmReviewer = caseReview.getReviewerPerson() != null ? caseReview.getReviewerPerson().getNmPersonFull() : StringHelper.EMPTY_STRING;
      caseReviewRetrieveSO.setNmReviewer(nmReviewer + ", " + Lookup.simpleDecodeSafe(CodesTables.CTITLEA, cdjobTitle));
      caseReviewRetrieveSO.setReviewPeriod(caseReview.getReviewPeriod());
      caseReviewRetrieveSO.setDtStaffedWithWorker(caseReview.getDtStaffedWithWorker());
      caseReviewRetrieveSO.setDtCorrectionDue(caseReview.getDtCorrectionDue());
      caseReviewRetrieveSO.setDtCorrectionComplete(caseReview.getDtCorrectionComplete());
      caseReviewRetrieveSO.setTxtSummaryComment(caseReview.getTxtSummaryComment());
      //SMS#38872: Add a new display field to the Case Review Detail page which displays the date the case review 
      //          was marked Review Complete.
      
      caseReviewRetrieveSO.setDtReviewComplete(caseReview.getDtReviewComplete());
    }  
      caseReviewRetrieveSO.setDtLastUpdate(caseReview.getDtLastUpdate());
      
      //STGAP00014653: Get the review type and review period from the table when status is NEW
      if(caseReview != null && CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)){
        caseReviewRetrieveSO.setReviewPeriod(caseReview.getReviewPeriod());
        caseReviewRetrieveSO.setCdReviewType(caseReview.getCdReviewType());
      }

    //get the questions and the Responses to be displayed on the page
    List<Map<String, Object>> questionsDetailList =  caseReviewDAO.findCaseReviewDetails(idStage, idEvent);

    if (questionsDetailList != null && !questionsDetailList.isEmpty()) {
      Iterator<Map<String, Object>> itquestionsList = questionsDetailList.iterator();

      while (itquestionsList.hasNext()) {
        CaseReviewQuestionsSO caseReviewQuestionsSO = new CaseReviewQuestionsSO();
        Map<String,Object> questionMap = (Map<String,Object>) itquestionsList.next();
        caseReviewQuestionsSO.setIdCaseReviewCateg((Integer) questionMap.get("idCaseReviewCateg"));
        caseReviewQuestionsSO.setSzCdCategory((String) questionMap.get("cdCategory"));
        caseReviewQuestionsSO.setSzTxtCategory((String) questionMap.get("txtCategory"));
        caseReviewQuestionsSO.setNbrCategoryOrder((Integer) questionMap.get("nbrCategoryOrder"));
        caseReviewQuestionsSO.setIdCaseReviewItem((Integer) questionMap.get("idCaseReviewItem"));
        caseReviewQuestionsSO.setSzCdItem((String) questionMap.get("cdItem"));
        caseReviewQuestionsSO.setSzTxtItem((String) questionMap.get("txtItem"));
        caseReviewQuestionsSO.setNbrItemOrder((Integer) questionMap.get("nbrItemOrder"));
        caseReviewQuestionsSO.setIdCaseReviewQuestion((Integer) questionMap.get("idCaseReviewQuestion"));
        caseReviewQuestionsSO.setSzCdQuestion((String) questionMap.get("cdQuestion"));
        caseReviewQuestionsSO.setSzTxtQuestion((String) questionMap.get("txtQuestion"));
        caseReviewQuestionsSO.setNbrQuestionOrder((Integer) questionMap.get("nbrQuestionOrder"));
        caseReviewQuestionsSO.setIndCbx((String) questionMap.get("indCbx"));
        caseReviewQuestionsSO.setIndQuestionType((String) questionMap.get("indQuestionType"));
        caseReviewQuestionsSO.setSzCdQuestionResponse((String) questionMap.get("cdQuesResponse"));
        caseReviewQuestionsSO.setTxtComments((String) questionMap.get("txtComments"));
        caseReviewQuestionsSO.setTxtQuesHelp((String) questionMap.get("txtQuesHelp"));
        caseReviewQuestionsSO.setCdVersion((Integer) questionMap.get("cdVersion"));
        caseReviewQuestionsSO.setTxtQuestionNum((String) questionMap.get("txtQuestionNum") + " ");
        if(ArchitectureConstants.Y.equals(caseReviewQuestionsSO.getIndCbx())){
          //Get the check boxes for the questions
          List<CodeAttributes> cbxQuestionList = getCategoryCollection(caseReviewQuestionsSO.getSzCdQuestion(), caseReviewQuestionsSO.getCdVersion());
          caseReviewQuestionsSO.setCaseReviewCbxQuestionsList(cbxQuestionList);
          //Get the check boxes response
          List<Map<String,Object>> checkedcheckboxesList = new ArrayList<Map<String,Object>>();
          checkedcheckboxesList = caseReviewDAO.findCheckboxbyCdQuestion((String) questionMap.get("cdQuestion"), (Integer) questionMap.get("cdVersion"), idEvent);
          Iterator<Map<String,Object>> itCheckedcheckboxesList = checkedcheckboxesList.iterator();
          String[] checkedCheckboxes = new String[checkedcheckboxesList.size()];      

          if (checkedcheckboxesList != null && !checkedcheckboxesList.isEmpty()) {
            for (int i = 0; itCheckedcheckboxesList.hasNext(); i++) {
              Map<String,Object> cb1 = (Map<String,Object>) itCheckedcheckboxesList.next();
              checkedCheckboxes[i] = (String) cb1.get("cdCbxQuestion");          
            }
          }

          caseReviewQuestionsSO.setCheckedCheckboxes(checkedCheckboxes);
        }

        //This below code checks to see if the decision question for that item has No radio button selected then
        //disable the Main Questions radio button hence mainQuestionDisabled is set to true.
        String indQuestionType = caseReviewQuestionsSO.getIndQuestionType();
        if (cdPreviousItem == null || !cdPreviousItem.equals(caseReviewQuestionsSO.getSzCdItem())) {
          if(MAIN_QUESTION.equals(indQuestionType)){
            List<Map<String, Object>> questionsDetailInnerList =  caseReviewDAO.findCaseReviewDetails(idStage, idEvent);
            if (questionsDetailInnerList != null && !questionsDetailInnerList.isEmpty()) {
              Iterator<Map<String, Object>> iterInner = questionsDetailList.iterator();
              while (iterInner.hasNext()) {
                Map<String,Object> questionMapInner = (Map<String,Object>) iterInner.next();
                String indQuestionTypeInner = (String) questionMapInner.get("indQuestionType");
                if (caseReviewQuestionsSO.getSzCdItem().equals((String) questionMapInner.get("cdItem"))) {
                  if(DECISION_QUESTION.equals(indQuestionTypeInner) && NO_QUES_RESPONSE.equals((String) questionMapInner.get("cdQuesResponse"))){
                    boolean mainQuestionDisabled = true;
                    caseReviewQuestionsSO.setMainQuestionDisabled(mainQuestionDisabled);
                    break;
                  }
                }
              }
            }
          }
        }

        caseReviewQuestionList.add(caseReviewQuestionsSO);
        cdPreviousItem = caseReviewQuestionsSO.getSzCdItem();
      }
      caseReviewRetrieveSO.setCaseReviewQuestionsList(caseReviewQuestionList);
    }
    return caseReviewRetrieveSO;

  }

  /**
   * Used to get a list of all CodeAttribute objects in a given category
   *
   * @param cdQuestion The Question for which the check boxes are searched for
   * @return The resulting list of CodeAttributes objects
   */
  public List<CodeAttributes> getCategoryCollection(String cdQuestion, int cdVersion){
    //Get all the check boxes for that question.
    List<Map<String, Object>> cbxQuestionList = caseReviewDAO.findCheckboxbyCdQuestionLookup(cdQuestion, cdVersion);
    Collection<CodeAttributes> result = new ArrayList<CodeAttributes>();
    //Set all the check boxes code and decode in the CodeAttribute Object and add them to the Collection result
    if (cbxQuestionList != null && !cbxQuestionList.isEmpty()) {
      Iterator<Map<String, Object>> itcbxQuestionsList = cbxQuestionList.iterator();
      while (itcbxQuestionsList.hasNext()) {
        Map<String, Object> caseReviewQuesCbxLookupMap = (Map<String, Object>) itcbxQuestionsList.next();
        CodeAttributes codeAttributes = new CodeAttributes((String)caseReviewQuesCbxLookupMap.get("cdQuestion"), 
                                                           (String)caseReviewQuesCbxLookupMap.get("cdCbxQuestion"),
                                                           (String)caseReviewQuesCbxLookupMap.get("txtCbxQuestion"));
        result.add(codeAttributes);
      }
    }
    //Create a list and add the collection result to that list
    List<CodeAttributes> list = new ArrayList<CodeAttributes>(result.size());
    list.addAll(result);
    return list;
  }
  
  //

  public static Collection<String> getNonOverlapping(Collection<String> coll1, Collection<String> coll2)
  {
      Collection<String> result = union(coll1, coll2);
      result.removeAll(intersect(coll1, coll2));
      return result;
  }
  
  //This method returns the unique values from the List
  public static Collection<String> union(Collection<String> coll1, Collection<String> coll2)
  {
      Set<String> union = new HashSet<String>(coll1);
      union.addAll(new HashSet<String>(coll2));
      return new ArrayList<String>(union);
  }
  
  //this method finds only those items that overlap between the two collections.
  public static Collection<String> intersect(Collection<String> coll1, Collection<String> coll2)
  {
      Set<String> intersection = new HashSet<String>(coll1);
      intersection.retainAll(new HashSet<String>(coll2));
      return intersection;
  }
}
