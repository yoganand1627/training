package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
//import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to display the Person List and call other pages.
 * <p/>
 * <pre>
 * Change History:
 *  Date      User              Description
 *  --------  ----------------  --------------------------------------------------
 *  07/19/05  PINKSTBA          SIR 23727 MPS Phase II. Method (displayPersonList_xa) has a
 *                              different implementation from Impact.  This method gets its
 *                              information from the Person Ejb instead of the service.
 *                              Also, all references to WtxException/WtcHelper are changed
 *                              to ServiceException/ServiceHelper.
 *  07/02/08  mchillman         Added to show exchange child detail tab    
 *  07/10/08  mchillman         Added to show NonIncidentAFCARSInformation Tab
 *  10/02/08  wjcochran         Added a check on an index in callPersonSearch_xa to prevent
 *                              IndexOutOfBounds exceptions 
 *  11/25/09  arege             SMS#37361 Show Non-Incident AFCARS Information tab only if 
 *                              the child is an non-incident child
 *  12/08/09  hjbaptiste        SMS# 41275:  Removed the condition that the youth had to be over the 
 *                              age of 13 in order to show the Youth Detail page so that the page
 *                              will be made available for anyone regardless of age.    
 *  4/20/10   cwells            SMS 37267 Case Name needs to be reset to display the correct Name when coming from ECD                                          
 * </pre>
 */
@SuppressWarnings("serial")
public class PersonListConversation extends BaseHiddenFieldStateConversation {
  
  public static final String SEC_REGIONAL_SS_STF = UserProfile.SEC_REGIONAL_SS_STF;

  private Person person;
  
  private CaseMgmt caseMgmt;

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public static final String TRACE_TAG = "PersonListConversation";
  //public static final String EVENT_SEARCH = EventSearchConversation.EVENT_SEARCH;

  public static final int PAGE_SIZE = 50;
  public static final String PREDISPLAY = "P";
  public static final String STAGE_CD_FAD = "FAD";
  public static final String CASE_LIST = "/workload/CaseListConversation/displayCaseList";
  public static final String ADMIN_REVIEW = "/workload/AdmnReviewConversation/displayAdminReview";
  public static final String PAGE_MODE_SELECT = PageModeConstants.PersonList.SELECT;
  public static final String PAGE_MODE_CLLTRL_ONLY = PageModeConstants.PersonList.CLLTRL_ONLY;
  public static final String PAGE_MODE_PRINC_ONLY = PageModeConstants.PersonList.PRINC_ONLY;
  public static final String PAGE_MODE_ALLEG_PERP_ONLY = PageModeConstants.PersonList.ALLEG_PERP_ONLY;
  public static final String FILTER_BY_PRINC_ONLY_18 = PersonListPullBackInfo.filter.PRINC_ONLY_18; // SIR
  // 13544
  public static final String FILTER_BY_PRINC_ONLY_21 = PersonListPullBackInfo.filter.PRINC_ONLY_21; // SIR
  // 13544
  public static final String PRINCIPAL = "PRN";
  public static final String PERPETRATOR = "AP";
  public static final String COLLATERAL = "COL";
  public static final String FAD_STAGE = "FAD";
  public static final String DISPLAY_PAGE = "/person/PersonList/displayPersonList";
  public static final String EVENT_STATUS_PENDING = "PEND";
  public static final String EVENT_STATUS_COMPLETE = "COMP";
  
  /**
   * <p>This method displays the Person List page.</p> <p>The following services are used: <blockquote><ul> <li>CINV01S
   * - Retrieves Person List info</li> </ul></blockquote></p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void displayPersonList_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(PAGE_SIZE);

    //  Do not clear state since this must function as a pullback

    //  Get the destination URL if it was passed in by the calling page and set it into state.
    PersonListPullBackInfo personListPullBackInfo;
    if (request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) != null) {
      personListPullBackInfo = (PersonListPullBackInfo) request.getAttribute(
              PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);
    } else {
      // Reset PageMode that is in state, so that if a user is in the middle of a pullback,
      // and then clicks the Person List Tab, it will not show up as lister mode
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      personListPullBackInfo = new PersonListPullBackInfo();
    }
    state.setAttribute("destinationURL", personListPullBackInfo.getDestinationUrl(), request);
    // Added SPB for metaphor as the 3rd level tabs should only show after user selects a person from list
    GlobalData.setUlIdPerson(0, request);
    // End SPB
    try {
      //Call the method to populate the cinv01si object and pass in the UsPageNbr for pagination
      CINV01SI cinv01si = populateCINV01S_Retrieve(context, tuxPagination, PREDISPLAY);
      CINV01SO cinv01so = person.retrievePersonList(cinv01si);
      
      // SMS 37267 Case Name needs to be reset to display the correct Name when coming from ECD
      String nmCase = CaseUtility.getNmCase(GlobalData.getUlIdCase(request));
      
      GlobalData.setSzNmCase(nmCase, request);

      // Get page mode out of the request here so we can pass it to the filter submethod and also use it
      // to check for error messages
      String mode = PageModeConstants.VIEW;
      if (PageMode.getPageMode(request) != null) {
        mode = PageMode.getPageMode(request);
      }

      //  Call the filter submethod to check if the object needs to be filtered
      cinv01so = filterCINV01SO(cinv01so, mode, personListPullBackInfo.getFilterBy());

      state.setAttribute("CINV01SO", cinv01so, request);

      int eventID = 0;
      String eventStatus = "";

      if (cinv01so != null) {
        eventID = cinv01so.getUlIdEvent();
        eventStatus = cinv01so.getSzCdEventStatus();
      }

      // If there is an event ID associated with this action, and the status is pending, and
      // we are not in approval mode display a message
      // warning the user that performing this action will invalidate the pending approval
      if (mode.equals(PageModeConstants.EDIT) && (eventID != 0) && (eventStatus.equals(EVENT_STATUS_PENDING))
          && !GlobalData.isApprovalMode(request)) {
        setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL),
                                DISPLAY_PAGE,
                                request);
        setPopUpMessage(MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVLD_APRVL_POPUP),
                        DISPLAY_PAGE,
                        request);
      }

      //set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(cinv01so.getArchOutputStruct(),
                                             cinv01so.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00Count());
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method is called when the user clicks on the Person Name Hyperlink. It calls Person Detail and passes it the
   * information it needs to populate. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callPersonDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callPersonDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      // Retrieve the object from state so that information from the person
      // selected can be
      // placed in global data
      CINV01SO cinv01so = (CINV01SO) state.getAttribute("CINV01SO", request);
      int index = ContextHelper.getIntSafe(request, "hdnPersonLoopCount");
      ROWCINV01SOG00_ARRAY rowcinv01sogooARRAY;
      if (cinv01so != null) {
        rowcinv01sogooARRAY = cinv01so.getROWCINV01SOG00_ARRAY();
      } else {
        rowcinv01sogooARRAY = new ROWCINV01SOG00_ARRAY();
      }
      ROWCINV01SOG00 rowcinv01so;
      if (rowcinv01sogooARRAY.getROWCINV01SOG00Count() > index || rowcinv01sogooARRAY.getROWCINV01SOG00Count() == index) {
        rowcinv01so = rowcinv01sogooARRAY.getROWCINV01SOG00(index);
      } else {
        rowcinv01so = new ROWCINV01SOG00();
      }
      int idPerson = rowcinv01so.getUlIdPerson();
      GlobalData.setUlIdPerson(idPerson, request);
      if(0 < rowcinv01so.getLNbrPersonAge() && rowcinv01so.getLNbrPersonAge() <= 21){
        state.setContextParameter("_restrictedFunds"+idPerson, ArchitectureConstants.Y, request);
      }
      state.setContextParameter("_youthDetailAvailable"+idPerson, ArchitectureConstants.Y, request);

      
      //show exchange child detail tab only if primary child and stage is ADO or PAD
      checkExchangeChildTabDisplay(context, rowcinv01so);
      //show Non-Incident AFCARS Information tab only if primary child and stage is PAD
      checkNonIncidentAFCARSInformationTabDisplay(context, rowcinv01so);
      
      GlobalData.setUlIdEvent(cinv01so.getUlIdEvent(), request);
      //Set the page mode for the person detail page equal to the current App
      // Mode
      PersonHelper.setPersonDetailPageMode(request, GlobalData.getAppMode(request));

      // SIR 17553 GRIMSHAN Set active status to N, b/c if person detail is
      // accessed through
      // person list, the page should be in the regular app mode regardless of
      // whether or
      //not the person is an employee
      // SIR 16774 GRIMSHAN set statically to N
      PersonHelper.setBIndActiveStatus(request, "N");

    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method is called when the user clicks the Search or Add button. It calls the Person Search page and passes it
   * any information it needs to populate or pass on to Person Detail. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callPersonSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callPersonSearch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    try {
      // Retrieve the cinv01so object from state, so that if they have selected
      // a person to
      // search on, that person's information will be available for person
      // search.
      CINV01SO cinv01so = (CINV01SO) state.getAttribute("CINV01SO", request);
      int index = ContextHelper.getIntSafe(request, "rbPersonList_CLEAN");
      ROWCINV01SOG00_ARRAY rowcinv01sogooARRAY;
      if (cinv01so != null) {
        rowcinv01sogooARRAY = cinv01so.getROWCINV01SOG00_ARRAY();
      } else {
        rowcinv01sogooARRAY = new ROWCINV01SOG00_ARRAY();
      }
      ROWCINV01SOG00 rowcinv01so;
      if (rowcinv01sogooARRAY.getROWCINV01SOG00Count() > index || (rowcinv01sogooARRAY.getROWCINV01SOG00Count() == index && index > 0)) {
        rowcinv01so = rowcinv01sogooARRAY.getROWCINV01SOG00(index);
      } else {
        rowcinv01so = new ROWCINV01SOG00();
      }

      // If they have selected the search pushbutton, place the information for
      // the person they
      // have searched on in the request.
      if (StringHelper.isValid(ContextHelper.getString(request, "btnSearch.x"))) {
        String tempName = rowcinv01so.getSzNmPersonFull();
        int indexComma = tempName.indexOf(',');
        int length = tempName.length();
        String firstName = "";
        String lastName = "";
        // parse the full name available from the service into first and last
        // name
        if ((indexComma != (length - 1)) && (indexComma != -1)) {
          firstName = tempName.substring(indexComma + 1, length);
          lastName = tempName.substring(0, indexComma);
        }

        request.setAttribute("txtSzNmNameFirst", firstName);
        request.setAttribute("txtSzNmNameLast", lastName);
        request.setAttribute("indPersonList", "Y");
        GlobalData.setUlIdPerson(rowcinv01so.getUlIdPerson(), request);
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This method is called when the page is being used as a Lister page. It will put the selected row in the
   * personListPullBackInfo object and call the Destination URL passed in from the calling page. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callContinue_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callContinue_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    // Person List is acting as a pullback, retrieve the destination URL, and
    // forward
    // to that conversation
    try {
      PersonListPullBackInfo personListPullBackInfo = populateCallContinue(context);

      request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPullBackInfo);
      // Get the destinationURL we set into state in the display method
      String destinationURL;
      if (state.getAttribute("destinationURL", request) == null) {
        throw new IllegalArgumentException("The destination Url is null");
      } else {
        destinationURL = (String) state.getAttribute("destinationURL", request);
        state.removeAttribute("destinationURL", request);
      }

      // Forward the conversation to the destinationURL passed in from the
      // calling page!
      forward(destinationURL, request, context.getResponse());
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p/>
   * This submethod populates the CINV01SI object for the retrieve service </p>
   *
   * @param context       The <code>GrndeExchangeContext<code> object, The TuxedoPaginationValueBean Pagination bean.
   * @param tuxPagination The Tuxedo Pagination Value Bean
   * @param cReqFuncCd    The reqFuncCd
   * @return cinv01si
   */
  public CINV01SI populateCINV01S_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination,
                                           String cReqFuncCd) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCINV01S_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    ArchInputStruct input = new ArchInputStruct();
    CINV01SI cinv01si = new CINV01SI();

    //Set the values for the ArchInputStruct
    input.setCReqFuncCd(cReqFuncCd);
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(PAGE_SIZE);
    input.setSzUserId(user.getUserLogonID());

    // check to see if calling window is Event list, Case list or Admin Review.
    // If
    // they pass an ID_STAGE, then find all the people in the stage.
    // If not pass in ID_CASE to the DAM and Set the IndCase to TRUE
    // To signal to the service which DAM to use
    String bSysIndCase = "";
    if ((ContextHelper.getPreviousUrl(context).equals(CASE_LIST))
        /*|| (ContextHelper.getPreviousUrl(context).equals(EVENT_SEARCH)) */
        || (ContextHelper.getPreviousUrl(context).equals(ADMIN_REVIEW))) {
      if (GlobalData.getUlIdStage(request) != 0) {
        bSysIndCase = ArchitectureConstants.N;
        cinv01si.setUlIdStage(GlobalData.getUlIdStage(request));
      } else {
        bSysIndCase = ArchitectureConstants.Y;
        cinv01si.setUlIdCase(GlobalData.getUlIdCase(request));
      }
    } else {
      cinv01si.setUlIdStage(GlobalData.getUlIdStage(request));
      bSysIndCase = ArchitectureConstants.N;
    }

    //SIR 19689, moved exception down here (and made it more explicit) from
    // before populate
    //because exception was preventing us ever to do a person list by case id
    // SIR 22985 - Added unexpected navigation error to the Illegal State
    // Exception
    // so that the user can better inform us as to how they got this message.

//    if ((ArchitectureConstants.N.equals(bSysIndCase) && (cinv01si.getUlIdStage() == 0))) {
//      throw new IllegalStateException(MessageLookup.getMessageByNumber(Messages.MSG_UNEX_NAV)
//                                      + " - Stage ID not set in Global Data");
//    }
//    if ((ArchitectureConstants.Y.equals(bSysIndCase) && (cinv01si.getUlIdCase() == 0))) {
//      throw new IllegalStateException(MessageLookup.getMessageByNumber(Messages.MSG_UNEX_NAV)
//                                      + " - Case ID not set in Global Data");
//    }

    cinv01si.setBSysIndCase(bSysIndCase);
    cinv01si.setArchInputStruct(input);
    cinv01si.setSzCdStageProgram(GlobalData.getSzCdStageProgram(request));
    cinv01si.setSzSysCdWinMode(PageMode.getPageMode(request));

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cinv01si;
  }

  /**
   * <p/>
   * This submethod populates the data the person list passes on to the next page when functioning as a lister/pullback
   * page. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object
   * @return personListPullBackInfo
   */
  private PersonListPullBackInfo populateCallContinue(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCallContinue()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // Populate the personListPullBackInfo object
    PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
    CINV01SO cinv01so;
    ROWCINV01SOG00_ARRAY rowcinv01sogooARRAY;
    ROWCINV01SOG00 rowcinv01sogoo;

    if (state.getAttribute("CINV01SO", request) != null) {
      cinv01so = (CINV01SO) state.getAttribute("CINV01SO", request);
    } else {
      cinv01so = new CINV01SO();
    }
    if (cinv01so.getROWCINV01SOG00_ARRAY() != null) {
      rowcinv01sogooARRAY = cinv01so.getROWCINV01SOG00_ARRAY();
    } else {
      rowcinv01sogooARRAY = new ROWCINV01SOG00_ARRAY();
    }

    int index = ContextHelper.getIntSafe(request, "rbPersonList_CLEAN");
    rowcinv01sogoo = rowcinv01sogooARRAY.getROWCINV01SOG00(index);

    //SIR 18849 -- Part 1 -- Will pass the name field selected on the Person
    // List page and
    //displayed the name top of the Medical/Mental Assessment page.
    String personFull = rowcinv01sogoo.getSzNmPersonFull();
    GlobalData.setSzNmPersonFull(personFull, request);

    personListPullBackInfo.setPersonListRow(rowcinv01sogoo);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return personListPullBackInfo;
  }

  /**
   * <p/>
   * This submethod takes the CINV01SO ouput object from the CINV01S retrieve service and filters the list by Person
   * Type if necessary. </p>
   *
   * @param cinv01so The CINV01SO object
   * @param mode     The Lister Mode
   * @return cinv01so
   */
  public CINV01SO filterCINV01SO(CINV01SO cinv01so, String mode, String filterBy) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".filterCINV01SO()");
    performanceTrace.enterScope();

    //  If the pageMode is PRINC_ONLY or CLLTRL_ONLY we want to filter the array
    // now
    ROWCINV01SOG00_ARRAY entireArray = new ROWCINV01SOG00_ARRAY();
    ROWCINV01SOG00_ARRAY filteredArray = new ROWCINV01SOG00_ARRAY();
    ROWCINV01SOG00 row;

    if (cinv01so.getROWCINV01SOG00_ARRAY() != null) {
      entireArray = cinv01so.getROWCINV01SOG00_ARRAY();
    }

    // If the mode is Principal Only, Collateral Only, or AP only, filter the
    // person list so that only those persons associated with the case will
    // display
    if (mode.equals(PAGE_MODE_PRINC_ONLY) || mode.equals(PAGE_MODE_CLLTRL_ONLY)
        || mode.equals(PAGE_MODE_ALLEG_PERP_ONLY)) {
      Enumeration rowArrayENUM = entireArray.enumerateROWCINV01SOG00();

      // Set the role check based on the mode of the page.
      String role = "";
      if (mode.equals(PAGE_MODE_PRINC_ONLY)) {
        role = PRINCIPAL;
      } else if (mode.equals(PAGE_MODE_CLLTRL_ONLY)) {
        role = COLLATERAL;
      } else {
        role = PERPETRATOR;
      }

      // Loop through all of the persons in the person list, if the filter is
      // equal to the
      // person's information, add that person to the array for the page to
      // display
      // SIR 13544 - Further filter by age based on mode.
      while (rowArrayENUM.hasMoreElements()) {
        row = (ROWCINV01SOG00) rowArrayENUM.nextElement();

        // SIR 17067 GRIMSHAN -- removed
        //  && ( row.getSzCdStagePersRole().equals( filterBy ) ) )
        // from else clause. The service does the filtering if the mode is alleg
        // perp only
        if (filterBy.equals(PERPETRATOR)) {
          filteredArray.addROWCINV01SOG00(row);
        } else if (row.getSzCdStagePersType().equals(role)) {
          // SIR 13544 Determine the age of the person based on the DOB in the
          // database
          // if there is no DOB in the database, leave age at 0. We do
          // want to display the person for selection if there is no age
          // available.
          int age = 0;
          if (row.getDtDtPersonBirth() != null) {
            age = DateHelper.getAge(row.getDtDtPersonBirth());
          }

          // Add the person to the list if the information matches the
          // filterBy. If there is no filterBy information, add the person
          // to the list regardless.
          if (filterBy.equals(FILTER_BY_PRINC_ONLY_18) && age < 18) {
            filteredArray.addROWCINV01SOG00(row);
          } else if (mode.equals(FILTER_BY_PRINC_ONLY_21) && age < 21) {
            filteredArray.addROWCINV01SOG00(row);
          } else if ("".equals(filterBy)) {
            filteredArray.addROWCINV01SOG00(row);
          }
        }
      } // End while

      cinv01so.setROWCINV01SOG00_ARRAY(filteredArray);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return cinv01so;
  }
  
  private void checkExchangeChildTabDisplay(GrndsExchangeContext context, ROWCINV01SOG00 rowcinv01so) {
    //show exchange child detail tab only if primary child and stage is ADO or PAD
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    String stage = GlobalData.getSzCdStage(request);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    if((CodesTables.CROLES_PC.equalsIgnoreCase(rowcinv01so.getSzCdStagePersRole())) && 
                    (CodesTables.CSTAGES_ADO.equalsIgnoreCase(stage) || CodesTables.CSTAGES_PAD.equalsIgnoreCase(stage))
                    && (user.hasRight(UserProfile.SEC_SAU_EXCHANGE) || user.hasRight(UserProfile.SEC_ADO_VIEW))){
      state.setContextParameter("_exchangeChildDetailAvailable"+rowcinv01so.getUlIdPerson(), ArchitectureConstants.Y, request);
    } else {
      state.removeContextParameter("_exchangeChildDetailAvailable"+rowcinv01so.getUlIdPerson(), request);
    }
  }
  
  private void checkNonIncidentAFCARSInformationTabDisplay(GrndsExchangeContext context, ROWCINV01SOG00 rowcinv01so) {
    // show Non-Incident AFCARS Information tab only if:
    // - the person role is the Primary Child
    // - the stage is a PAD stage
    // - the user hasStageAccess OR is an SAU user
    //SMS#37361 - the child is an non-incident child
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    CINV01SO cinv01so = (CINV01SO) state.getAttribute("CINV01SO", request);
    String stage = GlobalData.getSzCdStage(request);
    if ((CodesTables.CROLES_PC.equalsIgnoreCase(rowcinv01so.getSzCdStagePersRole()))
        && CodesTables.CSTAGES_PAD.equalsIgnoreCase(stage)
        && (CaseUtility.hasStageAccess(user.getUserID(), GlobalData.getUlIdStage(request))
            || user.hasRight(UserProfile.SEC_SAU_EXCHANGE) || user.hasRight(UserProfile.SEC_ADO_VIEW))
        && cinv01so.getBIndNonIncident()) {
      state.setContextParameter("_nonIncidentAFCARSInformationAvailable" + rowcinv01so.getUlIdPerson(),
                                ArchitectureConstants.Y, request);
    } else {
      state.removeContextParameter("_nonIncidentAFCARSInformationAvailable" + rowcinv01so.getUlIdPerson(), request);
    }
  }
}
