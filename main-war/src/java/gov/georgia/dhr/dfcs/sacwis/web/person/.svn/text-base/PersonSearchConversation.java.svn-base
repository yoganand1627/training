package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierPersSrchRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HierSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrsnSearchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSearchOutRec_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PrsnSrchListpInit_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

import org.exolab.castor.types.Date;

/**
 * This is the Conversation class used to search for people from the Person Search page.
 * 
 * @author Jeff Chambers, December 09, 2002 
 * <p/> Change History: 
 * Date     User                Description 
 * -------- ----------------    -------------------------------------------------- 
 * 04/22/03 Grimshan            SIR #16840 added Message and Page Mode
 *                              sets if the user has the Restrict Person Search 
 *                              Secuirty Attribute and is not in a case context 
 * 05/02/03 EILERSBE            SIR #17060 - Changed the call in searchPersonSearch_xa 
 *                              that sets the tuxedo pagination information
 *                              so that it sets the correct ulRowQty into tuxPagination. 
 * 05/08/03 GRIMSHAN            SIR #17351 Changed the way case context is set in searchPersonSearch 
 * 05/18/03 GRIMSHAN            SIR 17553 - set Bindactivestatus to N so that the
 *                              person detail page never falls into employee mode when being accessed 
 *                              from a case 
 * 08/20/03 GRIMSHAN            SIR 19581 - set new variable into person helper so that if the person 
 *                              is an inactive employee the information will still be hidden. 
 * 10/03/03 CORLEYAN            SIR 19953 use get phone when getting the phone
 * 10/28/08 SSUBRAM             STGAP00010705: If a child has been marked as adoption finalized, 
 *                              their pre-adoptive record will not show up for general users.  
 *                              Only users with the SAU Sealed attribute will be able to search, 
 *                              and receive results, for a child pre-adoptive name.
 * 12/08/09 hjbaptiste          SMS# 41275:  Removed the condition that the youth had to be over the 
 *                              age of 13 in order to show the Youth Detail page so that the page
 *                              will be made available for anyone regardless of age.                               
 *         
 */
public class PersonSearchConversation extends BaseHiddenFieldStateConversation {
  private Person person;

  public static final String TRACE_TAG = "PersonSearchConversation";

  public static final String STATE_PERSON_ID = "statePersonId";

  public static final String NO_RESULTS_FOUND = "NO_RESULTS_FOUND";

  public static final String NO_PHONETIC_RESULTS_RETURNED = "NO_PHONETIC_RESULTS_RETURNED";

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * displayPersonSearch <p/> This method is used for the initial display of the Person Search page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayPersonSearch_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonSearch_xa()");
    performanceTrace.enterScope();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get the destination URL if it was passed in by the calling page and set it into state.
    PersonListPullBackInfo personListPullBackInfo;
    if (request.getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME) != null) {
      personListPullBackInfo = (PersonListPullBackInfo) request
                                                               .getAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);
    } else {
      // Reset PageMode that is in state, so that if a user is in the middle of a pullback,
      // and then clicks the Person List Tab, it will not show up as lister mode
      PageMode.setPageMode(PageModeConstants.EDIT, request);
      personListPullBackInfo = new PersonListPullBackInfo();
    }
    state.setAttribute("destinationURL", personListPullBackInfo.getDestinationUrl(), request);

    // SIR 19812, set in state so we can mark search performed
    state.setAttribute(STATE_PERSON_ID, GlobalData.getUlIdPerson(request), request);

    // SPB SIR 19661: Needed such that the 3rd level tabs do not show
    GlobalData.setUlIdPerson(0, request);

    // Do not remove all objects from state as information is needed for relate.

    // SIR 16840 If the we are not in the case context and the user has the restrict person search
    // security attribute, set the page mode to view, and display an informational message
    // informing them that they do not have rights to search

    if (GlobalData.getUlIdStage(request) == 0 && user.hasRight(UserProfile.SEC_RESTRICT_PERSON_SEARCH)) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      setInformationalMessage(MessageLookup.getMessageByNumber(Messages.MSG_NO_SEARCH_RIGHT),
                              "/person/PersonSearch/displayPersonSearch", request);
    } else {
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * searchPersonSearch <p/> This method is used to call the Person Search Service CINT09 for searching on parameters
   * entered in the page. It sets up pagination for the list on the page, and then calls the main service. After the
   * first service is complete, if the calling page is person list, the page calls CINV50 to update the search indicator
   * for the person that was searched on.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void searchPersonSearch_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchPersonSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Pagination
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(65);

    try {
      PersonSearchInRec personSearchInRec = populatePersonSearchInRec(context, tuxPagination);
      PersonSearchOutRec personSearchOutRec = person.retrievePersonSearch(personSearchInRec);

      PrsnSearchOutRec_ARRAY personArray = personSearchOutRec.getPrsnSearchOutRec_ARRAY();

      if (personArray != null) {

        PrsnSearchOutRec_ARRAY tempPersonArray = new PrsnSearchOutRec_ARRAY();
        Enumeration e = personArray.enumeratePrsnSearchOutRec();

        // The following code is used to de-duplicate the rows returned by the service.
        // more than one row with the same person id can be returned, so as we are looping
        // through all of the rows, add the person id into a hash set. If the current row
        // has an id that is not already in the set, add that row into a temp array that
        // will later be set into the output object in the place of the originally returned array
        Set<Integer> hashSet = new HashSet<Integer>();
        // Loop though all of the rows in the Person array
        while (e.hasMoreElements()) {
          PrsnSearchOutRec personSearchList = (PrsnSearchOutRec) e.nextElement();
          if (!hashSet.contains(new Integer(personSearchList.getUlIdPerson()))) {
            boolean add = hashSet.add(personSearchList.getUlIdPerson());
            tempPersonArray.addPrsnSearchOutRec(personSearchList);
          }
        }

        personSearchOutRec.setPrsnSearchOutRec_ARRAY(tempPersonArray);

        /**
         * SIR 17060 Changed the call below that sets the tuxedo pagination information so that it sets the correct
         * ulRowQty into tuxPagination. Previously, it was using the ulRowQty from the PersonOutRecArray, which was
         * always 0. The person search service sets the ulRowQty in the ArchOutputStruct, so that one is used for
         * tuxPagination.
         */

        ArchOutputStruct archOutputStruct = new ArchOutputStruct();
        archOutputStruct.setBMoreDataInd(personArray.getBMoreDataInd());
        personSearchOutRec.setArchOutputStruct(archOutputStruct);

        tuxPagination.setPaginationInformation(personSearchOutRec.getArchOutputStruct(),
                                               personSearchOutRec.getPrsnSearchOutRec_ARRAY()
                                                                 .getPrsnSearchOutRecCount());
        request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

        // set the personSearchInRec into the request so the page can look at it when it is setting
        // the match type
        request.setAttribute("PrsnSearchInRec", personSearchInRec);
      } // end if (personArray != null)
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
      state.setAttribute("CINT09SO", personSearchOutRec, request);
      if (GlobalData.getUlIdStage(request) != 0) {
        request.setAttribute("CaseContext", ArchitectureConstants.Y);
      } else {
        request.setAttribute("CaseContext", ArchitectureConstants.N);
      }

      // Call the update no matter what.
      // If Stage ID is not 0 we are in a case context or if we are called from intake
      // call the service to update the person flag
      if (GlobalData.getUlIdStage(request) != 0 || state.getAttribute("IntakeObject", request) != null) {
        CINV50SI cinv50si = populateCINV50S(context);
        person.updatePersonSearchIndicator(cinv50si);
      }

      request.setAttribute(NO_RESULTS_FOUND, ArchitectureConstants.FALSE);
      request.setAttribute(NO_PHONETIC_RESULTS_RETURNED, ArchitectureConstants.FALSE);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_NAME_TOO_COMMON:
      case Messages.MSG_CMN_TOO_MANY_RECORDS:
      case Messages.MSG_CFC_PERFORM_SEARCH:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_CMN_SEARCH_NOT_FOUND:
        // case Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED:
        setErrorMessage(we.getErrorCode(), "/person/PersonSearch/searchPersonSearch", context.getRequest());
        break;
      case Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED:
        //request.setAttribute(NO_PHONETIC_RESULTS_RETURNED, ArchitectureConstants.TRUE);
        setInformationalMessage(we.getErrorCode(), "/person/PersonSearch/searchPersonSearch", context.getRequest());
        break;
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * calculateMatchType <p/> This method is used to determine what type of "Match" was returned by the search for each
   * person returned.
   * 
   * @param prsnsearchinrec
   *          The GrndsExchangeContext Object
   * @return matchType
   */
  public static String calculateMatchType(PrsnSearchInRec prsnsearchinrec) {

    String matchType = StringHelper.EMPTY_STRING;
    int matchCount = 0;

    if (prsnsearchinrec == null) {
      // FIXME: NPE's should never be manually thrown!
      String msg = "The PrsnSearchInRec passed to PersonSearchConversation.calculateMatchType() is null.";
      throw new NullPointerException(msg);
    }

    // This will set the match type, and incriment match count
    if (ArchitectureConstants.Y.equalsIgnoreCase(prsnsearchinrec.getBScrAdditParametersChk())) {
      matchType = "PARA";
      matchCount++;
    }

    if (ArchitectureConstants.Y.equalsIgnoreCase(prsnsearchinrec.getBScrAddressChk())) {
      matchType = "ADDR";
      matchCount++;
    }

    if (ArchitectureConstants.Y.equalsIgnoreCase(prsnsearchinrec.getBASearchFlag())) {
      matchType = "PHON";
      matchCount++;
    }

    if (ArchitectureConstants.Y.equalsIgnoreCase(prsnsearchinrec.getBScrPhoneticChk())
        && ArchitectureConstants.N.equalsIgnoreCase(prsnsearchinrec.getBScrAdditParametersChk())) {
      matchType = "PHON";
      matchCount++;
    } else if (ArchitectureConstants.N.equalsIgnoreCase(prsnsearchinrec.getBScrPhoneticChk())
               && ArchitectureConstants.N.equalsIgnoreCase(prsnsearchinrec.getBScrAdditParametersChk())) {
      matchType = "EXAC";
      matchCount++;
    }

    // If more than one method was used to get results
    if (matchCount > 1) {
      matchType = "COMB";
    }

    return matchType;
  }

  /**
   * displayPersonDetail <p/> This method is used to display the person detail page via the hyperlink on the Person
   * Search page. It determines if the user has the maintain person security attribute and sets PersonHelper mode and
   * app mode depending on security, and if the page is accessed in a case context or not.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayPersonDetail_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Set the Full Name into GlobalData
    String fullName = ContextHelper.getStringSafe(context, "hdnFullName");
    int personId = ContextHelper.getIntSafe(context, "hdnUlIdPerson");

    GlobalData.setUlIdPerson(personId, request);
    GlobalData.setSzNmPersonFull(fullName, request);

    // SIR 17553 set bindactive status into a place where it will not get cleared
    PersonHelper.setBIndActiveStatus(request, ContextHelper.getStringSafe(request, "bIndActiveStatus"));

    // SIR 19581 If the person searched on is a former employee we do not want to display the information
    // set this variable into a place that will not get cleared.
    PersonHelper.setBSysIndViewPersonInfo(request, ContextHelper.getStringSafe(request, "bSysIndViewPersonInfo"));
    // If Id Stage is 0, we are not in a case context so set app mode,
    // otherwise we are in case context, just set page mode
    if (GlobalData.getUlIdStage(request) == 0) {
      // If the user has the Maintain Person Security Attribute, set the application
      // mode to modify and the page mode for person to maintain person, otherwise
      // set the application mode and page mode to view
      if (user.hasRight(UserProfile.SEC_MNTN_PERSON)) {
        GlobalData.setAppMode(PageModeConstants.MODIFY, request);
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON);
      } else {
        GlobalData.setAppMode(PageModeConstants.VIEW, request);
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.VIEW);
      }
    } else {
      // If the user has the Maintain Person Security Attribute, set the page mode to
      // Maintain person
      if (user.hasRight(UserProfile.SEC_MNTN_PERSON)) {
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON);
      } else {
        PersonHelper.setPersonDetailPageMode(request, PageModeConstants.VIEW);
      }
    }

    String hdnIndPsa = ContextHelper.getStringSafe(request, "hdnIndPsa");
    if (hdnIndPsa != null) {
      // -- set into state so the Protective Service Alert third-level tab shows up
      state.setContextParameter("_activePSA" + personId, hdnIndPsa, request);
    }

    // -- set into state so the Protective Service Alert third-level tab shows up
    state.setContextParameter("_youthDetailAvailable" + personId, ArchitectureConstants.Y, request);

    // Forward user to PersonDetail.jsp
    try {
      forward("/person/PersonDetail/displayPersonDetail", request, context.getResponse());
    } catch (ServletException ex) {
      processSevereException(context, ex);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * relatePerson <p/> This method is used to display Person Detail when the user wants to relate a person into a stage.
   * It is only accessed in the case context, and passes the PersonHelper pageMode as "Relate"
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void relatePerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".relatePerson_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PersonSearchOutRec personsearchoutrec = (PersonSearchOutRec) state.getAttribute("CINT09SO", request);
    PrsnSearchOutRec_ARRAY outRowArray = personsearchoutrec.getPrsnSearchOutRec_ARRAY();

    int index = ContextHelper.getIntSafe(request, "rbRowsIndex");
    PrsnSearchOutRec outRow = outRowArray.getPrsnSearchOutRec(index);

    GlobalData.setUlIdPerson(outRow.getUlIdPerson(), request);
    PersonHelper.setPersonDetailPageMode(request, PageModeConstants.PersonDetail.WINDOW_MODE_RELATE);

    // Forward user to PersonDetail.jsp
    try {
      forward("/person/PersonDetail/displayPersonDetail", request, context.getResponse());
    } catch (ServletException ex) {
      processSevereException(context, ex);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /**
   * relatePersonInake <p/> This method is used when the user is relating a person into an intake.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void relatePersonIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".relatePerson_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PersonSearchOutRec personsearchoutrec = (PersonSearchOutRec) state.getAttribute("CINT09SO", request);
    PrsnSearchOutRec_ARRAY outRowArray = personsearchoutrec.getPrsnSearchOutRec_ARRAY();

    int index = ContextHelper.getIntSafe(request, "rbRowsIndex");
    PrsnSearchOutRec outRow = outRowArray.getPrsnSearchOutRec(index);

    GlobalData.setUlIdPerson(outRow.getUlIdPerson(), request);

    // Put the selected row in the request
    request.setAttribute("relatedPerson", outRow);

    performanceTrace.exitScope();
  }

  /**
   * addPerson <p/> This method is used to call Person Detail for adding a new person into a stage. It passes StageId,
   * Program Code, Person Helper Page Mode, Stage Code and Task Code to Person Detail
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void addPerson_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addPerson_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    String program = ContextHelper.getStringSafe(request, "hdnSzCdStageProgram");
    String stage = ContextHelper.getStringSafe(request, "hdnSzCdStage");
    String task = ContextHelper.getStringSafe(request, "hdnSzCdTask");

    PersonHelper.setPersonDetailPageMode(request, PageModeConstants.NEW);
    GlobalData.setSzCdStageProgram(program, request);
    GlobalData.setSzCdStage(stage, request);
    GlobalData.setSzCdTask(task, request);

    // Forward user to PersonDetail.jsp
    try {
      forward("/person/PersonDetail/addPersonDetail", request, context.getResponse());
    } catch (ServletException ex) {
      processSevereException(context, ex);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

  }

  /** @param context */
  public void callContinue_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callContinue_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    PersonSearchOutRec personsearchoutrec = (PersonSearchOutRec) state.getAttribute("CINT09SO", request);
    PrsnSearchOutRec_ARRAY personArray = personsearchoutrec.getPrsnSearchOutRec_ARRAY();

    int index = ContextHelper.getIntSafe(request, "rbRowsIndex");
    PrsnSearchOutRec personRow = personArray.getPrsnSearchOutRec(index);

    // populate ROWCINV01SOG00 object from PrsnSearchOutRec object. Basically, Copy PrsnSearchOutRec to ROWCINV01SOG00,
    // so that we can use set ROWCINV01SOG00 object into personListPullBackInfo.

    ROWCINV01SOG00 rowcinv01sog00 = populate_ROWCINV01SOG00(context, personRow);

    // Now create PersonListPullBackInfo object set it in request.
    // Also get the destination URL from state and redirect to that page.
    try {
      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
      personListPullBackInfo.setPersonListRow(rowcinv01sog00);

      request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPullBackInfo);
      // Get the destinationURL we set into state in the display method
      String destinationURL;
      if (state.getAttribute("destinationURL", request) == null) {
        // FIXME: This is caught by the catch statement below.
        throw new IllegalArgumentException("The destination Url is null");
      } else {
        destinationURL = (String) state.getAttribute("destinationURL", request);
        state.removeAttribute("destinationURL", request);
      }
      // Forward the conversation to the destinationURL passed in from the
      // calling page!
      forward(destinationURL, request, context.getResponse());
    } catch (Exception e) {
      // FIXME: Handle the exception or log it properly; do not use system.out.
      e.printStackTrace();
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * displayAsyncResults <p/> This method is used by intake to display results that have previously been selected
   * Asynchronously. Intake passes the array via request to Person Search which then retrieves it and re-sets it into a
   * CINT09SO object for displaying on the Person Search page.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   */
  public void displayAsyncResults_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAsyncResults");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Initialize the outer SO object to a new version of it.
    PersonSearchOutRec personSearchOutRec = new PersonSearchOutRec();
    PrsnSearchOutRec_ARRAY prsnsearchoutrec_array = new PrsnSearchOutRec_ARRAY();

    // Retrieve the inner array from the request as passed by intake.
    PrsnSrchListpInit_ARRAY prstsrchlistpinit_array = (PrsnSrchListpInit_ARRAY) request.getAttribute("asyncResults");
    Enumeration enumeration = prstsrchlistpinit_array.enumeratePrsnSrchListpInit();

    // loop through all of the array elements passed to person search and place them in
    // the output structure person search can read and display
    while (enumeration.hasMoreElements()) {
      PrsnSrchListpInit oldPerson = (PrsnSrchListpInit) enumeration.nextElement();

      // Matthew McClain, 08/31/2003, empty person record
      // This should probably be fixed in cint05s.src marshal output struct
      if (oldPerson.getUlIdPerson() == 0) {
        continue;
      }

      PrsnSearchOutRec newPerson = new PrsnSearchOutRec();
      newPerson.setSzScrCdPersonSearchHit(oldPerson.getSzScrCdPersonSearchHit());
      newPerson.setCCdPersonSex(oldPerson.getCCdPersonSex());
      newPerson.setCWcdIndMerge(oldPerson.getCWcdIndMerge());
      newPerson.setDtDtNameEndDate(oldPerson.getDtDtNameEndDate());
      newPerson.setDtDtPersonDeath(oldPerson.getDtDtPersonDeath());
      newPerson.setLNbrPersonAge(oldPerson.getLNbrPersonAge());
      newPerson.setSzAddrCity(oldPerson.getSzAddrCity());
      newPerson.setSzAddrPersAddrStLn1(oldPerson.getSzAddrPersAddrStLn1());
      newPerson.setSzCdCounty(oldPerson.getSzCdCounty());
      newPerson.setSzCdPersonEthnicGroup(oldPerson.getSzCdPersonEthnicGroup());
      newPerson.setSzNbrPersonIdSsn(oldPerson.getSzNbrPersonIdSsn());
      newPerson.setSzNmIncmgPersFull(oldPerson.getSzNmIncmgPersFull());
      newPerson.setSzNmPersonFull(oldPerson.getSzNmPersonFull());
      newPerson.setSzNmNameFirst(oldPerson.getSzNmNameFirst());
      newPerson.setSzNmNameMiddle(oldPerson.getSzNmNameMiddle());
      newPerson.setSzNmNameLast(oldPerson.getSzNmNameLast());
      newPerson.setUlIdPerson(oldPerson.getUlIdPerson());

      // Matthew McClain, 08/31/2003, data was never getting filled in for async searches
      // Matthew McClain, 08/31/2003, no way to tell if person is employee at this time
      newPerson.setBSysIndViewPersonInfo(ArchitectureConstants.Y);
      newPerson.setBIndActiveStatus(oldPerson.getBIndActiveStatus());
      newPerson.setUsScrIndScore(oldPerson.getUsScrIndScore());
      prsnsearchoutrec_array.addPrsnSearchOutRec(newPerson);
    }
    personSearchOutRec.setPrsnSearchOutRec_ARRAY(prsnsearchoutrec_array);

    // Set the prsnsearchinrec into request so that when the list is displaying
    // the call to match will have it available
    PrsnSearchInRec prsnsearchinrec = getSearchCriteria(request);
    // Matthew McClain, 08/31/2003, data was never getting filled in for async searches
    prsnsearchinrec.setBASearchFlag(ArchitectureConstants.Y);
    request.setAttribute("PrsnSearchInRec", prsnsearchinrec);

    state.setAttribute("CINT09SO", personSearchOutRec, request);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private ROWCINV01SOG00 populate_ROWCINV01SOG00(GrndsExchangeContext context, PrsnSearchOutRec personRow) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populate_ROWCINV01SOG00()");
    performanceTrace.enterScope();

    // HttpServletRequest request = context.getRequest();
    // BaseSessionStateManager state = getSessionStateManager(context);
    // UserProfile user = UserProfileHelper.getUserProfile(context);

    ROWCINV01SOG00 rowcinv01sog00 = new ROWCINV01SOG00();
    // Currently we are just populating personId and Person full name to ROWCINV01SOG00,
    // but ROWCINV01SOG00 object can be populated with all values if needed.
    rowcinv01sog00.setUlIdPerson(personRow.getUlIdPerson());
    rowcinv01sog00.setSzNmPersonFull(personRow.getSzNmPersonFull());
    // wjcochran - Added person Gender & Age to search results
    rowcinv01sog00.setCCdPersonSex(personRow.getCCdPersonSex());
    rowcinv01sog00.setLNbrPersonAge(personRow.getLNbrPersonAge());

    return rowcinv01sog00;

  }

  /**
   * populateCINV50S <p/> This method is used to populate the input structure used when calling CINV50S.
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @return cinv50si
   */
  private CINV50SI populateCINV50S(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    BaseSessionStateManager state = getSessionStateManager(context);

    // Call the service and update the search flag.
    CINV50SI cinv50si = new CINV50SI();
    ArchInputStruct input = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);
    input.setSzUserId(user.getUserLogonID());

    // Set the ArchInputStruct
    cinv50si.setArchInputStruct(input);

    cinv50si.setSzCdStagePersSearchInd("V");

    // IMPACT change -- The DAM is now selecting based on UlIdPerson instead
    // of UlIdStagePerson, so pass in UlIdPerson in the place of UlIdStagePerson
    // SIR 19812
    Integer integer = (Integer) state.getAttribute(STATE_PERSON_ID, request);
    if (integer != null) {
      cinv50si.setUlIdStagePerson(integer);
    }

    // If we are coming from intake, set the task code to 1000, since there
    // is no "real" task code, otherwise set it to the one in global data
    if (state.getAttribute("IntakeObject", request) != null) {
      cinv50si.setSzCdTask("1000");
    } else {
      cinv50si.setSzCdTask(GlobalData.getSzCdTask(request));
    }
    cinv50si.setUlIdStage(GlobalData.getUlIdStage(request));

    return cinv50si;
  }

  /**
   * populatePersonSearchInRec <p/> This method is used to populate the input structure used when calling CINT09S
   * 
   * @param context
   *          The GrndsExchangeContext Object
   * @param tuxPagination
   *          The Object used to determine pagination
   * @return cint09si
   */
  private PersonSearchInRec populatePersonSearchInRec(GrndsExchangeContext context,
                                                      TuxedoPaginationValueBean tuxPagination) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    String indSealed = getSealedAttribute(request);
    String searchType = ContextHelper.getStringSafe(context, "cboSearchType");
    String firstName = FormattingHelper.initCaps(ContextHelper.getStringSafe(context, "txtSzNmNameFirst"));
    String middleName = FormattingHelper.initCaps(ContextHelper.getStringSafe(context, "txtSzNmNameMiddle"));
    String lastName = FormattingHelper.initCaps(ContextHelper.getStringSafe(context, "txtSzNmNameLast"));
    String addrStreet1 = ContextHelper.getStringSafe(context, "txtSzAddrPersAddrStLn1").toUpperCase();
    String addrStreet2 = StringHelper.EMPTY_STRING;
    String addrCity = ContextHelper.getStringSafe(context, "txtSzCdAddrCity").toUpperCase();
    String addrState = ContextHelper.getStringSafe(context, "cbxSzCdAddrState");
    String addrZip = ContextHelper.getStringSafe(context, "txtlAddrZip");
    String addrZip2 = ContextHelper.getStringSafe(context, "txtlAddrZip2");
    String addrCounty = ContextHelper.getStringSafe(context, "cboSzCdAddrCounty");
    String ssn = ContextHelper.getSSNSafe(context, "txtSzSysTxtGenericSSN");
    int personId = ContextHelper.getIntSafe(context, "txtUlIdPerson");
    String gender = ContextHelper.getStringSafe(context, "cboCcdPersonSex");
    Date birthDay = DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtDtPersonBirth"));
    int age = ContextHelper.getIntSafe(context, "txtlNbrPersonAge");
    // SIR 19953 use get phone safe when searching for phone.
    String phone = ContextHelper.getPhoneSafe(context, "txtlNbrPhone");
    String indAddlParams = CheckboxHelper.getCheckboxValue(request, "cbxAdditionalParams");
    String indAddr = CheckboxHelper.getCheckboxValue(request, "cbxAddressSearch");
    int intakeReportId = ContextHelper.getIntSafe(context, "txtIntReportID");
    String medicaidNbr = ContextHelper.getStringSafe(context, "txtMedaidNO");

    // Allocate the structures

    // The PersonSearchInRec is the outer piece of the CINT09SI object, which contains the
    // PrsnSearchInRec inner piece
    PersonSearchInRec personSearchInRec = new PersonSearchInRec();
    PrsnSearchInRec prsnSearchInRec = new PrsnSearchInRec();
    ArchInputStruct input = new ArchInputStruct();
    // STGAP00010705: Set the Sealed Indicator
    prsnSearchInRec.setBIndSealed(indSealed);
    // Set the values for the ArchInputStruct
    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());

    // Set the ArchInputStruct
    personSearchInRec.setArchInputStruct(input);

    // Set the search types to N and switch when used
    prsnSearchInRec.setBScrPhoneticChk(ArchitectureConstants.N);
    prsnSearchInRec.setScrPartlNameChk(ArchitectureConstants.N);
    prsnSearchInRec.setBScrAddressChk(ArchitectureConstants.N);
    prsnSearchInRec.setBScrAdditParametersChk(ArchitectureConstants.N);
    prsnSearchInRec.setBUNKNOWNDOBSEARCH(ArchitectureConstants.N);
    prsnSearchInRec.setBASearchFlag(ArchitectureConstants.N);
    prsnSearchInRec.setBIndNamePrimary(ArchitectureConstants.N);
    prsnSearchInRec.setBScrFullNameChk(ArchitectureConstants.N);

    prsnSearchInRec.setUlIdPerson(personId);
    prsnSearchInRec.setSzNbrPersonIdSsn(ssn);
    prsnSearchInRec.setLNbrPhone(phone);
    prsnSearchInRec.setSzNmNameFirst(firstName);
    prsnSearchInRec.setSzNmNameMiddle(middleName);
    prsnSearchInRec.setSzNmNameLast(lastName);
    prsnSearchInRec.setLNbrPersonAge(age);
    prsnSearchInRec.setCCdPersonSex(gender);
    prsnSearchInRec.setDtDtPersonBirth(birthDay);
    prsnSearchInRec.setSzAddrPersAddrStLn1(addrStreet1);
    prsnSearchInRec.setSzAddrPersAddrStLn2(addrStreet2);
    prsnSearchInRec.setSzAddrCity(addrCity);
    prsnSearchInRec.setSzCdAddrState(addrState);
    prsnSearchInRec.setNbrMedicaidNo(medicaidNbr);
    prsnSearchInRec.setUlIdStage(intakeReportId);

    // If last 4 digits of ZIP are given add a "-" and append them
    if (addrZip2.equalsIgnoreCase(StringHelper.EMPTY_STRING)) {
      prsnSearchInRec.setLAddrZip(addrZip);
    } else {
      prsnSearchInRec.setLAddrZip(addrZip + "-" + addrZip2);
    }
    prsnSearchInRec.setSzCdAddrCounty(addrCounty);

    // If Additional paramters is checked only use addly parameters to search on
    if ("Y".equals(indAddlParams)) {
      prsnSearchInRec.setBScrAdditParametersChk(ArchitectureConstants.Y);
    } else {
      // If search type is Phonetic
      if ("PHO".equalsIgnoreCase(searchType)) {
        prsnSearchInRec.setBScrPhoneticChk(ArchitectureConstants.Y);
      }
      // If search type is Partial Name
      if ("PAR".equalsIgnoreCase(searchType)) {
        prsnSearchInRec.setScrPartlNameChk(ArchitectureConstants.Y);
      }
      // If search type is Full Name
      if ("FUL".equalsIgnoreCase(searchType)) {
        prsnSearchInRec.setBScrFullNameChk(ArchitectureConstants.Y);
      }
      // If search type is Date of Birth
      if ("DOB".equalsIgnoreCase(searchType)) {
        prsnSearchInRec.setBUNKNOWNDOBSEARCH(ArchitectureConstants.Y);
      }
      // If searchType is not selected and SSN, personId and phone are not entered use this criteria
      if ("Y".equals(indAddr)) {
        prsnSearchInRec.setBScrAddressChk(ArchitectureConstants.Y);
      }
    }
    // Set the PrsnSearchInRec
    personSearchInRec.setPrsnSearchInRec(prsnSearchInRec);
    return personSearchInRec;
  }

  private PrsnSearchInRec getSearchCriteria(HttpServletRequest request) {
    // turn the input object from this save into the input object for the personSearch
    PrsnSearchInRec prsnsearchinrec = new PrsnSearchInRec();
    HierPersSrchRec searchCriteria = null;
    // STGAP00010705: Get the Sealed Indicator
    String indSealed = getSealedAttribute(request);
    // STGAP00010705: Set the Sealed Indicator
    prsnsearchinrec.setBIndSealed(indSealed);
    HierSrchInRec hiersrchinrec = (HierSrchInRec) request.getAttribute("searchCriteria");
    if (hiersrchinrec != null) {
      searchCriteria = hiersrchinrec.getHierPersSrchRec();
    }
    if (searchCriteria == null) {
      searchCriteria = new HierPersSrchRec();
    }
    prsnsearchinrec.setBASearchFlag(searchCriteria.getBASearchFlag());
    prsnsearchinrec.setCCdPersonSex(searchCriteria.getCCdPersonSex());
    prsnsearchinrec.setDtDtPersonBirth(searchCriteria.getDtDtPersonBirth());
    prsnsearchinrec.setLAddrZip(searchCriteria.getLAddrZip());
    prsnsearchinrec.setLNbrPersonAge(searchCriteria.getLNbrPersonAge());
    prsnsearchinrec.setLNbrPhone(searchCriteria.getLNbrPhone());
    prsnsearchinrec.setSzAddrCity(searchCriteria.getSzAddrCity());
    prsnsearchinrec.setSzAddrPersAddrStLn1(searchCriteria.getSzAddrPersAddrStLn1());
    prsnsearchinrec.setSzAddrPersAddrStLn2(searchCriteria.getSzAddrPersAddrStLn2());
    prsnsearchinrec.setSzCdAddrCounty(searchCriteria.getSzCdAddrCounty());
    prsnsearchinrec.setSzAddrCity(searchCriteria.getSzAddrCity());
    prsnsearchinrec.setSzNbrPersonIdSsn(searchCriteria.getSzNbrPersonIdSsn());
    prsnsearchinrec.setSzNmNameFirst(searchCriteria.getSzNmNameFirst());
    prsnsearchinrec.setSzNmNameMiddle(searchCriteria.getSzNmNameMiddle());
    prsnsearchinrec.setSzNmNameLast(searchCriteria.getSzNmNameLast());

    return prsnsearchinrec;
  }
  /**
   * STGAP00010705: This method is called by the other methods to get whether the user has Rights to access
   * ADO and FCC Stages after the Adoption is Finalized.
   * 
   * @param request
   *                HTTP Servlet Request object.
   * @return String
   *                Return either N or Y.
   */
  private String getSealedAttribute(HttpServletRequest request) {
    String retValue = ArchitectureConstants.N;
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile != null) {
      retValue = userProfile.hasRight(UserProfile.SEC_SAU_SEALED) == true ? 
                                   ArchitectureConstants.Y : ArchitectureConstants.N ;
    }
    return retValue;
  }
}
