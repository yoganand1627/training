package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckIfPersonViewSearchSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RecordsCheckSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckIfPersonViewSearchSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenMapping;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * Records Check Summary Conversation
 * Author: Corey Harden
 * Date: 06/03/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 * 07/07/11  hnguyen           SMS#113889: Fixed issue with selected History checkbox not persisting after validation error.
 *
 *
 *
*/


@SuppressWarnings("serial")
public class RecordsCheckSummaryConversation extends BaseHiddenFieldStateConversation {

  private Person person;
  public static String ADD_BY_PERSON = "addByPerson";
  public static String ADD_BY_REQ_TYPE = "addBySearchType";
  public static String SELECTED_PERSON = "selPersonByIdRecCheckPerson";
  public static String DT_REC_CHECK_REQ = "dtRecCheckRequest";
  public static String DT_REC_CHECK_COMP = "dtRecCheckCompleted";
  public static String HISTORY = "indReccheckHistory";
  public static String COMMENTS = "txtRecCheckComments";
  public static String META_DATA = "hdnMetaData";
  public static final String NOT_VIEW_SEARCHED = "Not View Searched";
  public static final String TRACE_TAG = "RecordsCheckSummaryConversation";
  public static final int PAGE_SIZE = 1000;
  public static final String PERSON_PERSONSEARCH = "PERSON_PERSONSEARCH";

  public void setPerson(Person person) {
    this.person = person;
  }


  /**
   * This method displays the Records Check summary page
   * @param context - the context of the application
   */
  @SuppressWarnings("unchecked")
  public void displayRecordsCheckSummary_xa(GrndsExchangeContext context) { 
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRecordsCheckSummary_xa()");
    performanceTrace.enterScope();
    
    // get the request object and state object
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // create the service in and out transport objects
    RecordsCheckSummarySI recordsCheckSummarySI = new RecordsCheckSummarySI();
    RecordsCheckSummarySO recordsCheckSummarySO = new RecordsCheckSummarySO();

    // get parameters for in object
    Integer idStage = GlobalData.getUlIdStage(request);
    Integer idCase = GlobalData.getUlIdCase(request);

    // populate in object
    recordsCheckSummarySI.setIdStage(idStage);
    recordsCheckSummarySI.setIdCase(idCase);

    // call service to retrieve records check summary info
    recordsCheckSummarySO = person.retrieveRecordsCheckSummary(recordsCheckSummarySI);

    // add SO object to request for page retrieval
    request.setAttribute("recordsCheckSummarySO", recordsCheckSummarySO);
    
    // check to see if all records checks have been completed
    if(recordsCheckSummarySO.getMissingTypesMap().containsKey(recordsCheckSummarySO.getMissingTypesList())){
      List<String> missingTypesList = (List<String>) recordsCheckSummarySO.getMissingTypesMap().get(recordsCheckSummarySO.getMissingTypesList());
      recordsCheckSummarySO.setIsComplete(missingTypesList.isEmpty());
    }
    
    // add SO object to state for retrieval during display of "Add By" view
    state.setAttribute("recordsCheckSummarySO", recordsCheckSummarySO, request); 
    
    // log time and exit method scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  
  /**
   * This method displays the respective "Add By" view chosen by the user
   * on the summary view of the page
   * @param context - the context of the application
   */
  public void addRequiredRecordsCheck_xa(GrndsExchangeContext context) {
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addRequiredRecordsCheck_xa()");
    performanceTrace.enterScope();

    // get the request and state objects
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // create the service in and out transport objects
    RecordsCheckSummarySI recordsCheckSummarySI = new RecordsCheckSummarySI();
    RecordsCheckSummarySO recordsCheckSummarySO = (RecordsCheckSummarySO) state.getAttribute("recordsCheckSummarySO", request);
    
    // get parameters for in object
    String addType = StringHelper.getSafeString(request.getParameter("add_type"));
    Integer idStage = StringHelper.toInteger(request.getParameter("hdnIdStage")); 
    Integer idCase = StringHelper.toInteger(request.getParameter("hdnIdCase")); 
    Integer idPerson = 0;
    
    // populate in object
    recordsCheckSummarySI.setAddByType(addType);
    recordsCheckSummarySI.setIdStage(idStage);
    recordsCheckSummarySI.setIdCase(idCase);
    
    // get the person from the request if add by person was selected
    if (RecordsCheckSummaryConversation.ADD_BY_PERSON.equals(addType)) {
      // get selected person
      idPerson = StringHelper.toInteger(request.getParameter(RecordsCheckSummaryConversation.SELECTED_PERSON));
      
      try {
        // get the screen definition and add informational section to the screen
        Screen screen = ScreenMapping.getScreenData(context);
        setRcSummaryScreenData(screen, idPerson, getPersonFullName(recordsCheckSummarySO, idPerson));
      } catch (ServletException e) {
        processSevereException(context, e);
      }
      
      //add person's info to global data for display in page info section
      GlobalData.setUlIdPerson(idPerson, request);
      GlobalData.setSzNmPersonFull(getPersonFullName(recordsCheckSummarySO, idPerson), request);
    }
    
    // create and populate Service In object to check if search has been performed on person
    CheckIfPersonViewSearchSI checkIfPersonViewSearchSI = new CheckIfPersonViewSearchSI();
    checkIfPersonViewSearchSI.setIdPerson(idPerson);
    checkIfPersonViewSearchSI.setIdStage(idStage);
    
    //Call the service which checks to see if the Person is view searched.
    CheckIfPersonViewSearchSO checkIfPersonViewSearchSO = person.checkViewSearchForRecordsCheckSummary(checkIfPersonViewSearchSI);
    String isPersonViewSearched = checkIfPersonViewSearchSO.getIsPersonViewSearched();
    String nmPerson = checkIfPersonViewSearchSO.getNmPerson();
    
    // set error message if this is an intake stage and no View Search has been performed
    if(RecordsCheckSummaryConversation.NOT_VIEW_SEARCHED.equals(isPersonViewSearched)){
      // return to Records Check Summary view
      this.setPresentationBranch("error", context);
      
      // add name of person to error message
      String errorMessage = MessageLookup.addMessageParameter(MessageLookup.getMessageByNumber(Messages.MSG_PREVENT_ADD_RECORDS_CHECK),FormattingHelper.formatString(nmPerson));
      
      // set the error message
      setErrorMessage(errorMessage, "/person/RecordsCheckSummary/displayRecordsCheckSummary", request);
      return;
    }
    
    // add SO object and add type to request for page retrieval
    request.setAttribute("recordsCheckSummarySO", recordsCheckSummarySO);
    request.setAttribute("addType", addType);
    
    // set attributes in state
    state.setAttribute("idCase", String.valueOf(idCase), request);
    state.setAttribute("idStage", String.valueOf(idStage), request);
    state.setAttribute("idPerson", String.valueOf(idPerson), request);
    state.setAttribute("recordsCheckSummarySO", recordsCheckSummarySO, request); 
    
    // log time and exit method scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  
  
  /**
   * This method saves the Records Check Summary information
   * @param context - the context of the application
   */
  public void saveRecordsCheckSummary_xa(GrndsExchangeContext context){
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveRecordsCheckSummary_xa()");
    performanceTrace.enterScope();
    
    // get the request and state objects
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    // create the service in and out transport objects
    RecordsCheckSummarySI recordsCheckSummarySI = new RecordsCheckSummarySI();
    RecordsCheckSummarySO recordsCheckSummarySO = (RecordsCheckSummarySO) state.getAttribute("recordsCheckSummarySO", request);

    // get parameters for in object
    String addType = request.getParameter("hdnType") ;
    Integer idStage = StringHelper.toInteger((String)state.getAttribute("idStage", request));
    Integer idCase = "null".equals(state.getAttribute("idCase", request)) ? 0 : StringHelper.toInteger((String) state.getAttribute("idCase", request));
    Integer idPerson = StringHelper.toInteger((String)state.getAttribute("idPerson", request));
    
    // if idPerson is 0 then we are coming from the intake stage
    if(idPerson == null || idPerson == 0){
      // get person id from global data
      idPerson = GlobalData.getUlIdPerson(request);
    }
    
    try{
     // populate the transport object 
     populateRecordsCheckSummarySI(request, recordsCheckSummarySI, recordsCheckSummarySO);
      
     // populate in object
     recordsCheckSummarySI.setAddByType(addType);
     recordsCheckSummarySI.setIdStage(idStage);
     recordsCheckSummarySI.setIdCase(idCase);
     recordsCheckSummarySI.setIdPerson(idPerson);
        
     // call service to save Records Checks
     person.saveRecordsCheckSummary(recordsCheckSummarySI);
     
     // get Records Check records
     recordsCheckSummarySO = person.retrieveRecordsCheckSummary(recordsCheckSummarySI);
     
     // if performing save from add by person view, recreate informational section
     if(RecordsCheckSummaryConversation.ADD_BY_PERSON.equals(addType)){
       // get the screen definition and add informational section to the page
       Screen screen = ScreenMapping.getScreenData(context);
       setRcSummaryScreenData(screen, idPerson, getPersonFullName(recordsCheckSummarySO, idPerson));
     }
     
    }catch(ParseException p){
      // process parse exception
      processSevereException(context, p);
      return;
    }catch (ServletException s){
      // process parse exception
      processSevereException(context, s);
      return;
    }
    
    
    // add SO object to request and stage for page retrieval
    request.setAttribute("addType", addType);
    request.setAttribute("recordsCheckSummarySO", recordsCheckSummarySO);
    state.setAttribute("recordsCheckSummarySO", recordsCheckSummarySO, request);
    
    // log time and exit method scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  
  /**
   * This method sets up data to be used to display the Records Check List page
   * @param context - The GRNDS context object
   */
  public void displayRecordsCheckList_xa(GrndsExchangeContext context){
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRecordsCheckList_xa()");
    performanceTrace.enterScope();
    
    // store url of Records Check List page in a variable
    String forwardUrl = "/person/RecordsCheck/displayRecordsCheckList";
    
    // get the request
    HttpServletRequest request = context.getRequest();
    
    // get the person name and id and set them into global data 
    String idPerson = StringHelper.getSafeString(request.getParameter("hdnIdPerson"));
    String name = StringHelper.getSafeString(request.getParameter("hdnNmPerson"));
    GlobalData.setUlIdPerson((idPerson == null ? 0 : Integer.valueOf(idPerson)), request);
    GlobalData.setSzNmPersonFull(name, request);

    try{
      // forward control to RecordsCheckCoversation to display the Records Check List page
      forward(forwardUrl, request, context.getResponse());
    }catch(Exception e){
      // process any exception
      processSevereException(context, e);
      return;
    }finally{
      // log time and exit method scope
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }
  
  
  /**
   * This method displays the Records Check Detail page
   * @param context - The GRNDS context object
   */
  public void displayRecordsCheckDetail_xa(GrndsExchangeContext context){
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayRecordsCheckDetail_xa()");
    performanceTrace.enterScope();
    
    // get the state object
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    // setup url to forward Records Check conversation display method
    String forwardUrl = "/person/RecordsCheck/displayRecordsCheckDetail";
    
    // set Records Check person data into Golobal Data
    String idPerson = StringHelper.getSafeString(request.getParameter("hdnIdPerson"));
    String name = StringHelper.getSafeString(request.getParameter("hdnNmPerson"));
    GlobalData.setUlIdPerson((idPerson == null ? 0 : Integer.valueOf(idPerson)), request);
    GlobalData.setSzNmPersonFull(name, request);
    
    // get user and clear state
    @SuppressWarnings("unused")
    UserProfile user = UserProfileHelper.getUserProfile(context);
    state.removeAllAttributes(request);
    
    // paginate RecordsCheckList
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);
    
    // get the pageMode from the calling page;
    String pageMode = GlobalData.getAppMode(request);

    // Determine if this is an employee
    if ("N".equals(PersonHelper.getBIndActiveStatus(request))) {
      String indEmployee = "N";
      request.setAttribute("indEmployee", indEmployee);
    }
    
    // setup the page mode
    if (String.valueOf(request.getParameter("level2Tab")).equalsIgnoreCase(PERSON_PERSONSEARCH)){
      pageMode = PageModeConstants.VIEW; 
    }
    
    // set pageMode in state
    state.setAttribute("pageMode", pageMode, request);

    try {
      // populate the Service In object and retrieve the Records Check
      CCFC26SI ccfc26si = populateCCFC26SI_RETRIEVE(context, tuxPagination);
      CCFC26SO ccfc26so = person.retrieveRecordsCheck(ccfc26si);

      // set Service Out object into state for later retrieval
      state.setAttribute("CCFC26SO", ccfc26so, request);

      // set the information into the pagination bean and then store it to the request
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccfc26so.getBMoreDataInd());
      ccfc26so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccfc26so.getArchOutputStruct(), ccfc26so.getROWCCFC26SOG00_ARRAY().getROWCCFC26SOG00Count());
      storePaginationBeanToRequest(context, tuxPagination);
      
      // forward request to RecordsCheckConversation method to display the detail page
      forward(forwardUrl, request, context.getResponse());
    } catch (ServiceException we) {
      handleRCError(we, context);
    } catch (Exception ve) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Exception:" + ve.getMessage());
      processSevereException(context, ve);
    } finally{
      // log trace time and exit scope
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }
  
  
  /**
   * This method populates the Service In transport object with data from the page
   * @param request - the request object representing the current user request
   * @param recordsCheckSummarySI - the Records Check Service In object for data transport
   * @throws ParseException - thrown when the string cannot be formatted into a date
   */
  private void populateRecordsCheckSummarySI(HttpServletRequest request, RecordsCheckSummarySI recordsCheckSummarySI, RecordsCheckSummarySO recordsCheckSummarySO) throws ParseException{
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateRecordsCheckSummarySI()");
    performanceTrace.enterScope();
    
    // create list to hold Records Checks
    List<RecordsCheckBean> recordsCheckList = new ArrayList<RecordsCheckBean>();
    
    // create map and list to hold person data
    Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
    List<Integer> tempPersonList = new ArrayList<Integer>();
    
    // get the number of rows from the request
    int rowCount = StringHelper.toInteger(request.getParameter("hdnRowCount"));
    
    //get map containing list of missing types and a map of persons missing those types
    @SuppressWarnings("unchecked")
    Map missingMap = recordsCheckSummarySO.getMissingTypesMap();
    
    //get map of missing types to persons
    @SuppressWarnings("unchecked")
    Map<String, Map<Integer, RecordsCheckBean>> missingTypesMap = (Map<String, Map<Integer, RecordsCheckBean>>) missingMap.get(recordsCheckSummarySO.getMissingTypesToPerson());
    
    // create object to format dates
    SimpleDateFormat dateFormatter = new SimpleDateFormat(DateHelper.SLASH_FORMAT_STRING);
    
    // loop thru rows to add them to Records Check list
    for(int i = 1; i <= rowCount; i++){
      // get metadata
      String metaData = StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.META_DATA + i));
      
      // break out of loop if there are no more rows
      if(metaData == null){
        continue;
      }
      
      // create variables to hold meta data information
      String type = "";
      int idPerson = 0;
      int idRequestor = 0;
      @SuppressWarnings("unused")
      int idRecCheck = 0;
      @SuppressWarnings("unused")
      String name = "";
      
      // delimit the meta data
      String[] nvp = metaData.split("&");
      
      // loop thru name-value pairs (nvp) to delimit nvp's and retrieve data
      for(String str : nvp){
        // delimit the nvp
        String[] delimtedPair = str.split("=");
        
        // add data to variables
        if("person".equals(delimtedPair[0])){
          // get the person id
          idPerson = StringHelper.toInteger(delimtedPair[1]);
          // add each person to list
          if(!temp.containsKey(idPerson)){
            temp.put(idPerson, idPerson);
            tempPersonList.add(idPerson);
          }
        }else if("requestor".equals(delimtedPair[0])){
          // get the person id of the requestor
          idRequestor = StringHelper.toInteger(delimtedPair[1]);
          // add each requestor to list of persons
          if(!temp.containsKey(idRequestor)){
            temp.put(idPerson, idRequestor);
            tempPersonList.add(idRequestor);
          }
        }else if("idRecCheck".equals(delimtedPair[0])){
          // get the primary key of the Records Check
          idRecCheck = StringHelper.toInteger(delimtedPair[1]);
        }else if("personName".equals(delimtedPair[0])){
          name = StringHelper.getSafeString(delimtedPair[1]);
        }else{
          // get the type of the Records Check
          type = StringHelper.getSafeString(delimtedPair[0]);
        }
      }
      
      // get map of persons to Records Checks
      RecordsCheckBean rcBean = missingTypesMap.get(type).get(idPerson);
      
      // check to make sure request date is populated before save
      if(StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_REQ + i)) != null){
        // check status of Records Check bean to determine if this is an add or update
        if(ServiceConstants.REQ_FUNC_CD_ADD.equals(rcBean.getStatus())){
          rcBean.setDtRecCheckCompleted(StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_COMP + i)) == null ? null : dateFormatter.parse(StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_COMP + i))));
          rcBean.setDtRecCheckRequest(dateFormatter.parse(StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_REQ + i))));
          rcBean.setIndReccheckHistory(StringHelper.toYorN(ServiceConstants.FND_YES.equals(request.getParameter(RecordsCheckSummaryConversation.HISTORY + i))));
          rcBean.setTxtRecCheckComments(StringHelper.getNonNullString(request.getParameter((RecordsCheckSummaryConversation.COMMENTS + i))).trim());
          rcBean.setPersonByIdRecCheckRequestor(idRequestor);
        }else if(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rcBean.getStatus())){
          rcBean.setDtRecCheckCompleted(StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_COMP + i)) == null ? null : dateFormatter.parse(StringHelper.getSafeString(request.getParameter(RecordsCheckSummaryConversation.DT_REC_CHECK_COMP + i))));
          rcBean.setIndReccheckHistory(StringHelper.toYorN(ServiceConstants.FND_YES.equals(request.getParameter(RecordsCheckSummaryConversation.HISTORY + i))));
          rcBean.setTxtRecCheckComments(StringHelper.getNonNullString(request.getParameter((RecordsCheckSummaryConversation.COMMENTS + i))).trim());
        }
        
        // add Records Check to list
        recordsCheckList.add(rcBean);
      }
    }
    
    // set list into transport object
    recordsCheckSummarySI.setRecordsCheckList(recordsCheckList);
    
    // set list of person into SI object
    recordsCheckSummarySI.setPersonList(tempPersonList);
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  
  /**
   * This method creates a full name, using the first and the last name of the
   * person, of the form: LastName, FirstName
   * @param recordsCheckSummarySO - the Service Out transport object
   * @param idPerson - the primary key of the person
   * @return - returns the full name of the person represented by the idPerson primary key
   */
  @SuppressWarnings("unchecked")
  private String getPersonFullName(RecordsCheckSummarySO recordsCheckSummarySO, Integer idPerson){
 
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getPersonFullName()");
    performanceTrace.enterScope();
    
    //create string to hold selected person's name
    String name = "";
    
    //make sure person list is not null
    if(recordsCheckSummarySO.getPersonList() != null){
      
      //create iterator for loop over list
      Iterator<RecordsCheckPersonBean> it = recordsCheckSummarySO.getPersonList().iterator();
      
      //create person object
      RecordsCheckPersonBean rcBean;
      
      //loop through list of person to find selected person
      while(it.hasNext()){
        //get the person object
        rcBean = it.next();
        //check to see if this is the chosen person
        if(idPerson.equals(rcBean.getPersonId())){
          //set full name and break outta loop
          name = rcBean.getDisplayNameFull();
          break;
        }
      }
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    
    return name;
  }
  
  
  /**
   * This helper method handles all the WTC Exceptions thrown by this conversation for Records Check.
   * @param we - WtcException
   * @param context - The GrndsExchangeContext object
   */
  private void handleRCError(ServiceException we, GrndsExchangeContext context) {
    
    // get the request object
    HttpServletRequest request = context.getRequest();
    
    // handle error
    switch (we.getErrorCode()) {
    case Messages.MSG_DUPLICATE_RECORD:
      this.setPresentationBranch("error", context);
      String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
      setErrorMessage(errorMessage1, "/person/RecordsCheckSummary/displayRecordsCheckDetail", request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      this.setPresentationBranch("error", context);
      String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage2, "/person/RecordsCheckSummary/displayRecordsCheckDetail", request);
      break;
    default:
      if (we.getErrorCode() != 0) {
        setErrorMessage(we.getErrorCode(), request);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
      break;
    }
  }
  
  
  /**
   * This helper method populates rows for a display of rows from the records_check 
   * table for the subject of external records checks
   * @param context - The GrndsExchangeContext object
   * @param tuxPagination - TuxedoPaginationValueBean
   * @return ccfc26si
   * @throws MarshalException
   * @throws ValidationException
   */
  private CCFC26SI populateCCFC26SI_RETRIEVE(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination) throws MarshalException, ValidationException {
    
    // set logging information
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC26SI_RETRIEVE()");
    performanceTrace.enterScope();

    // get user and request object
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // define and populate a new service object
    CCFC26SI ccfc26si = new CCFC26SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);
    ccfc26si.setArchInputStruct(input);
    ccfc26si.setUlIdRecCheckPerson(GlobalData.getUlIdPerson(request));

    // get trace time and exit scope
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return ccfc26si;

  }
  
  
  /**
   * Set Info1 and Info2 to display person Id and Person full name
   *
   * @param screen - the screen object representing the personScreenDef.xml file
   * @param idPerson - the id of the person
   * @param nmPerson - the full name of the person
   */
  protected static void setRcSummaryScreenData(Screen screen, int idPerson, String nmPerson) {
    // if the person name is valid, add informational section to the screen
    if (StringHelper.isValid(nmPerson)) {
      screen.setParameter("Info1", "Full Person Name", false);
      if (idPerson != 0) {
        screen.setParameter("Info2", "Person ID", false);
      }
    } 
  }
}
