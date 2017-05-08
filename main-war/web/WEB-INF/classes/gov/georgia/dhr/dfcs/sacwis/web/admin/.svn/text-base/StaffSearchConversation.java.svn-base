package gov.georgia.dhr.dfcs.sacwis.web.admin;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.PageSizeNbr;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageIdInStruct_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StfSrchCrtInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to search for staff from the Staff Search page.
 * 
 * @author Jeff Chambers, October 04, 2002
 *         <p>
 * 
 * <pre>
 *                   Change History:
 *                   Date      User         Description
 *                   --------  -----------  ----------------------------------------------
 *                   ??/??/??  ???          SIR 17964 -- staffSearchInput object will remain in
 *                                          state, this will allow the user to have original
 *                                          search criteria on the Staff Search page after returning
 *                                          from the Staff Sec Mnt page .
 *                   07/16/03  CASDORJM     SIR 18839 - The unit program that the user entered
 *                                          on the window was not getting updated on the employee
 *                                          table because the following variable was not getting
 *                                          set.  ALSO - added change log.
 *                   07/16/03  DOUGLACS     SIR 18919 - Supervisor not getting changed when program,
 *                                          reg/div, or unit changed
 *                   07/21/03  DOUGLACS     SIR 19015 - when changing program, reg/div, or unit,
 *                                          data should really be saved and re-retrieved before
 *                                          going to job history.
 *                   07/30/03  Merle Demo   Sir19133 updated setUlPageSizeNbr for CARC14S.SRC to
 *                                          match what is in ccmn05so.h
 *                                          CCMN05SOG01_SZCDPERSONRACE_SIZE =10.  Added new class
 *                                          PageSizeNbr contains only static variables for all the
 *                                          rows to be returned
 *                   08/07/03  dickmaec     //SIR 19374 -- Changed formatting helper from
 *                                          initCapsName to changeCase, this will allow hyphenated
 *                                          name searches to return the correct results.
 *                   09/10/03  douglacs     SIR 19748 - also set person name into global data for
 *                                          use in infobox on records check
 *                   10/16/03  douglacs     SIR 19915 -If the UlIdUnit is different (the Program,
 *                                          Unit or Region has changed) or Emp Term Date is filled -
 *                                          set the UlIdUnitEmpLink to 0
 *                   11/06/03  Todd Reser   SIR 19794 - Added Sets.H for PPTParticipant so when
 *                                          going to Staff Search from PPTParticipant Radio Buttons
 *                                          are used instead of Checkboxes.
 *                   11/12/03  Todd Reser   Updated Javadocs and comments.
 *                   04/01/04  douglacs     SIR 22500 - Supervisor should be updated on every save.
 *                   04/13/04  gerryc       SIR 16271 - added mail code to the search parameters,
 *                                          and convert it to all uppercase.
 *                   07/09/04  douglacs     SIR 14339 - delete employee was not handling return of
 *                                          error message MSG_CMN_STAGES_OUTSTANDING
 *                   11/03/04  gerryc       SIR 23196 - added catch for error message that doesn't
 *                                          allow more than 50 people to be in a unit.
 *                   03/01/05  douglacs     SIR 23024 - removed the ability to delete an employee
 *                   07/24/05  werlem       SIR 23728 - MPS Phase II Enhancement to add Contact List
 *                                          and Detail to MPS.
 *                   08/01/05  werlem       SIR 23841 - Fixed problem created by removing an unused
 *                                          return value for a method (commented out the line
 *                                          instead of removing just the local variable by mistake);
 *                                          also, reformatted according to project code style; for
 *                                          comparisons, make sure to ignore whitespace, and the
 *                                          and the only changes will be line wrapping.
 *                   08/27/06 aodutayo      Job Description should return only one row when displaying
 *                                          that section in SHINES as opposed to multiple lines used in
 *                                          IMPACT. It should also update the same line in the database
 *                                          instead of creating a new entry for the same person whenever
 *                                          job change or title occurs .
 *                   10/06/06 aodutayo      Change populateCCMN05SI_Add and populateROWCCMN04SO0 to use the value 
 *                                          of the office selected on the staff detail page when adding or 
 *                                          updating a new staff. Used to be populated by the 
 *                                          retrieveOfficeName service in 
 *                                          StaffDetailCustomValidation.java file.
 *                                          It should be noted that szCdEmpProgram is not used in Shines. Commenting
 *                                          out lines that use it.****(Yet to do it aodutayo).
 *                                          Removed/commented all references to JobHistory. Cleaned up xconf file also.
 *                                          Also refactored the code
 *                  7/15/2008 cwells        Catching the MSG_CMN_ONCALL_OUTSTANDING thrown in the Save Employee Detail
 *                                          Service when Trying to terminate an employee who is on call                      
 *                                                                                                     
 * </pre>
 * 
 * </p>
 */
@SuppressWarnings("serial")
public class StaffSearchConversation extends BaseHiddenFieldStateConversation {

  /**
   * The setStaffSearchPageSet method sets the PageSet based upon the conditions below.
   * 
   * @param callingPage
   *          integer value from StaffSearchInput constants
   * @param user
   *          User Profile object so security rights can be checked
   * @param context
   *          The GrndsExchangeContext object.
   */
  protected void setStaffSearchPageSet(int callingPage, UserProfile user, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    if ((callingPage == StaffSearchInput.STAFF_MAINT) && (user.hasRight(UserProfile.SEC_MNTN_STAFF_GEN))) {
      GrndsTrace.msg(TRACE_TAG, 7, "D"); // Page State 4
      Sets.setPageSet(Sets.D, request);
    } else if ((callingPage == StaffSearchInput.STAFF_MAINT)
               && (user.hasRight(UserProfile.SEC_MNTN_STAFF_GEN) == false)) {
      GrndsTrace.msg(TRACE_TAG, 7, "A"); // Page State 1
      Sets.setPageSet(Sets.A, request);
    } else if ((callingPage == StaffSearchInput.UNIT_MAINT) || (callingPage == StaffSearchInput.ASSIGN)
               || (callingPage == StaffSearchInput.ON_CALL)) {
      GrndsTrace.msg(TRACE_TAG, 7, "C"); // Page State 3
      Sets.setPageSet(Sets.C, request);
    } else if (callingPage == StaffSearchInput.EVENT_SEARCH) {
      GrndsTrace.msg(TRACE_TAG, 7, "B"); // Page State 2 for Event Search
      Sets.setPageSet(Sets.B, request);
      populateEventSearch(context);
    } else if ((callingPage == StaffSearchInput.OTHER)) {
      GrndsTrace.msg(TRACE_TAG, 7, "E"); // Page State 2 Not Event Search
      Sets.setPageSet(Sets.E, request);
    }
    // SIR 18869 Added OTHER_MAINTAIN_SEARCH to handle the Staff Security Mnt
    // page and Mnt Designee. Will return the Search Results Object.
    // like E except maintain Staff Search si object
    else if (callingPage == StaffSearchInput.OTHER_MAINTAIN_SEARCH) {
      GrndsTrace.msg(TRACE_TAG, 7, "F");
      Sets.setPageSet(Sets.F, request);
    }
    // SPB SIR 19992
    else if (callingPage == StaffSearchInput.TODO) {
      GrndsTrace.msg(TRACE_TAG, 7, "G");
      // Coming from ToDo Detail - Page State 2 Not Event Search
      Sets.setPageSet(Sets.G, request);
    }
    // SIR 19794 - Added Set H for PPT Participant
    else if (callingPage == StaffSearchInput.PPTParticipant) {
      GrndsTrace.msg(TRACE_TAG, 7, "H");
      // Coming from PPT Participant - Page State 2 Not Event Search
      Sets.setPageSet(Sets.H, request);
    }
  }

  /**
   * The displayStaffSearch clears state if the StaffSearch object is not found, Looks for the StaffSearchInput object,
   * which is used by calling pages that have pull backs. If the object is not found it will create an instance of that
   * object to avoid a NPE.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // reset deletePressed on display of search page if it exists
    if (state.getAttribute("deletePressed", request) != null) {
      state.removeAttribute("deletePressed", request);
    }
    // Only clear state and set app mode if user is NOT in pull back mode
    if (state.getAttribute("StaffSearch", request) == null && "".equalsIgnoreCase(StaffSearchInput.PULL_BACK_KEY)) {
      state.removeAllAttributes(request);

      // SIR 17205 GRIMSHAN -- only set app mode if the page is not in pull
      // back mode.
      // Set the AppMode in Global Data
      if (user.hasRight(UserProfile.SEC_MNTN_STAFF_GEN)) {
        // Set AppMode to EDIT
        GlobalData.setAppMode(PageModeConstants.EDIT, request);
      } else {
        // Set AppMode to VIEW
        GlobalData.setAppMode(PageModeConstants.VIEW, request);
      }
    }

    // SPB SIR 19661: Needed such that the 3rd level tabs do not show
    GlobalData.setUlIdPerson(0, request);

    // SIR 17964 -- staffSearchInput object will remain in state, this will allow
    // the user to have original search criteria on the Staff Search page after
    // returning from the Staff Sec Mnt page

    StaffSearchInput staffSearchInput = (StaffSearchInput) request.getAttribute("StaffSearchInput");
    // Check to see if StaffSearchInput is in the request, if not we assume it
    // was called from the Metaphore
    CCMN03SI ccmn03si = (CCMN03SI) state.getAttribute("CCMN03SI", request);

    /*
     * Map officeMap = officeDAO.findOffice(); if (officeMap == null) { throw new
     * ServiceException(Messages.MSG_CMN_INVALID_OFFICE); }
     */

    if (staffSearchInput != null) {
      // Put the StaffSearchInput object into state
      state.setAttribute("StaffSearchInput", staffSearchInput, request);
      setStaffSearchPageSet(staffSearchInput.getSourcePageCode(), user, context);

      if ((Sets.isInSet(Sets.F, request)) && (ccmn03si != null)) {
        request.setAttribute("LOAD_INPUT_FROM_STATE", Boolean.TRUE);
        staffSearch(context, ccmn03si);
      }
    } else {
      setStaffSearchPageSet(StaffSearchInput.STAFF_MAINT, user, context);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * The populateEventSearch passes a vector of StageIds to perform a search.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private void populateEventSearch(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateEventSearch()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Pagination
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(SEARCH_RESULTS_PER_PAGE);

    BaseSessionStateManager state = getSessionStateManager(context);

    // Get the StageIds from the StaffSearchInput object
    StaffSearchInput staffSearchInput = (StaffSearchInput) request.getAttribute("StaffSearchInput");

    int vectorSize = staffSearchInput.getNumStageIds();

    try {
      StageIdInStruct_ARRAY stageidinstruct_array = new StageIdInStruct_ARRAY();
      for (int i = 0; i < vectorSize; i++) {
        // Get the UlIdStage from the StaffSearchInput object
        int stageId = staffSearchInput.getStageId(i);

        StageIdInStruct stageidinstruct = new StageIdInStruct();
        stageidinstruct.setUlIdStage(stageId);

        stageidinstruct_array.addStageIdInStruct(stageidinstruct);
      }

      // Set the values for the ArchInputStruct
      ArchInputStruct input = new ArchInputStruct();
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
      input.setBPerfInd("Y");
      input.setBDataAcsInd("Y");
      input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
      input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
      input.setSzUserId(user.getUserLogonID());

      CCMN03SI ccmn03si = new CCMN03SI();
      ccmn03si.setArchInputStruct(input);
      ccmn03si.setStfSrchCrtInStruct(new StfSrchCrtInStruct());
      ccmn03si.setStageIdInStruct_ARRAY(stageidinstruct_array);

      CCMN03SO ccmn03so = admin.retrieveStaffList(ccmn03si);

      // Set the objects into state
      state.setAttribute("StaffSearch", ccmn03so, request);
      state.setAttribute("ROWCCMN50DO_ARRAY", ccmn03so.getROWCCMN50DO_ARRAY(), request);

      // Set this to display the results
      request.setAttribute("SearchPerformed", "Y");

      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(ccmn03so.getBMoreDataInd());
      ccmn03so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccmn03so.getArchOutputStruct(), ccmn03so.getROWCCMN50DO_ARRAY()
                                                                                     .getUlRowQty());
      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, tuxPagination);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_SEARCH_NOT_FOUND:
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
   * The staffSearch_xa takes input from the StaffSearch.jsp and performs a search based on the criteria. It returns the
   * result in one of two objects, StaffSearch or StaffSecurity. For the logic on StaffSecurityMnt.jsp, the StaffSearch
   * object is needed to persist for redisplay after a designee has been added and saved. This object is cleared from
   * state.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void staffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".staffSearch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Pagination
    //TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    //ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    //tuxPagination.getResultDetails().setResultsPerPage(SEARCH_RESULTS_PER_PAGE);

    // Allocate the structures
    StageIdInStruct stageidinstruct = new StageIdInStruct();
    CCMN03SI ccmn03si = new CCMN03SI();
    ArchInputStruct input = new ArchInputStruct();
    StfSrchCrtInStruct stfsrchcrtinstruct = new StfSrchCrtInStruct();
    StageIdInStruct_ARRAY stageidinstruct_array = new StageIdInStruct_ARRAY();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    //input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    //input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
    input.setSzUserId(user.getUserLogonID());

    ccmn03si.setArchInputStruct(input);

    // sir # 19768 begin ochumd
    StaffSearchInput staffSearchInput = (StaffSearchInput) state.getAttribute("StaffSearchInput", request);
    if ((staffSearchInput != null) && (staffSearchInput.getSourcePageCode() == StaffSearchInput.ASSIGN)) {
      stfsrchcrtinstruct.setBIndCaseAssignable(ArchitectureConstants.Y);
    } else {
      stfsrchcrtinstruct.setBIndCaseAssignable(ArchitectureConstants.N);
    }
    // sir # 19768 end ochumd

    // If Person Id is entered it is the ONLY criteria seached on
    if (ContextHelper.getIntSafe(context, personID) != 0) {
      stfsrchcrtinstruct.setUlIdPerson(ContextHelper.getIntSafe(context, personID));
      // SPB SIR 19992
      if (Sets.isInSet(Sets.G, request)) {
        stfsrchcrtinstruct.setCScrIndActive("Y");
      }
      ccmn03si.setStfSrchCrtInStruct(stfsrchcrtinstruct);
      stageidinstruct_array.addStageIdInStruct(stageidinstruct);
      ccmn03si.setStageIdInStruct_ARRAY(stageidinstruct_array);
    } else {
      // If SSN is entered it is the ONLY criteria seached on
      if (!"".equals(ContextHelper.getSSNSafe(context, personSSN))) {
        stfsrchcrtinstruct.setSzNbrPersonIdNumber(ContextHelper.getSSNSafe(context, personSSN));
        // SPB SIR 19992
        if (Sets.isInSet(Sets.G, request)) {
          stfsrchcrtinstruct.setCScrIndActive("Y");
        }
        ccmn03si.setStfSrchCrtInStruct(stfsrchcrtinstruct);
        stageidinstruct_array.addStageIdInStruct(stageidinstruct);
        ccmn03si.setStageIdInStruct_ARRAY(stageidinstruct_array);
      } else {
        // Use all the other search criteria for the search
        stfsrchcrtinstruct.setSzNmNameFirst(FormattingHelper.initCapsName(request.getParameter("txtSzNmNameFirst")));
        stfsrchcrtinstruct.setSzNmNameMiddle(FormattingHelper.initCapsName(request.getParameter("txtSzNmNameMiddle")));
        // SIR 19374 -- Changed formatting helper from initCapsName to changeCase.
        stfsrchcrtinstruct.setSzNmNameLast(FormattingHelper.changeCase(request.getParameter("txtSzNmNameLast")));
        stfsrchcrtinstruct.setSzCdUnitProgram(request.getParameter("cboSzCdUnitProgram")); // Required
        stfsrchcrtinstruct.setSzCdUnitRegion(request.getParameter("cboSzCdUnitRegion"));
        String nbrUnit = request.getParameter("txtSzNbrUnit");
        stfsrchcrtinstruct.setSzNbrUnit(nbrUnit != null ? nbrUnit.toUpperCase() : nbrUnit);

        // This sets the Staff radio button value the service is expecting Y or null
        if ("actv".equalsIgnoreCase(request.getParameter("rbCScrIndActive"))) {
          stfsrchcrtinstruct.setCScrIndActive("Y");
        } else {
          stfsrchcrtinstruct.setCScrIndActive(null);
        }

        stfsrchcrtinstruct.setSzCdUnitSpecialization(ContextHelper.getStringSafe(context, "cboSzCdUnitSpecialization"));
        stfsrchcrtinstruct.setSzAddrMailCodeCity(ContextHelper.getStringSafe(context, "txtSzNmOfficeName"));
        // .toUpperCase());
        stfsrchcrtinstruct.setSzCdOfficeCounty(ContextHelper.getStringSafe(context, "txtSzCdOfficeCounty"));
        stfsrchcrtinstruct.setSzAddrMailCode(ContextHelper.getStringSafe(context, "txtSzAddrMailCode"));
        // stfsrchcrtinstruct.setSzAddrMailCode((ContextHelper.getStringSafe(context,
        // "txtSzAddrMailCode")).toUpperCase());// 16271
        // added
        // mail
        // code
        stfsrchcrtinstruct.setSzNbrPersonIdNumber("");
        stfsrchcrtinstruct.setSzCdEmpSkill("");

        ccmn03si.setStfSrchCrtInStruct(stfsrchcrtinstruct);
        stageidinstruct_array.addStageIdInStruct(stageidinstruct);
        ccmn03si.setStageIdInStruct_ARRAY(stageidinstruct_array);
      }
    }

    staffSearch(context, ccmn03si);

    performanceTrace.exitScope();
  }

  /**
   * The continueStaffSearch_xa performs the pull back functionality for StaffSearch.jsp. It checks the PageSets to
   * determin if the row has one or more objects (radio button or checkboxes). It puts the selected row or rows into the
   * request as the StaffPullBack object. The StaffSearchInput, StaffSecurity, and ROWCCMN50DO_ARRAY are all removed
   * from state.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void continueStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".continueStaffSearch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    int personId = 0;
    String fullName = "";

    ROWCCMN50DO_ARRAY inRowArray = (ROWCCMN50DO_ARRAY) state.getAttribute("ROWCCMN50DO_ARRAY", request);
    ROWCCMN50DO_ARRAY outRowArray = new ROWCCMN50DO_ARRAY();

    // Put the index into the ROWCCMN50DO and add that row into the outRowArray
    // object and set into the request for retriveal. The first if is for
    // checkboxes and the else if is for radio buttons.
    if (Sets.isInSet(Sets.C, request)) {
      String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbx");

      for (int i = 0; i < checkedValues.length; i++) {
        int index = Integer.parseInt(checkedValues[i]);
        ROWCCMN50DO inRow = inRowArray.getROWCCMN50DO(index);
        outRowArray.addROWCCMN50DO(inRow);
      }
    } else if (Sets.isInSet(Sets.B | Sets.E | Sets.F | Sets.G | Sets.H, request)) {
      int index = ContextHelper.getIntSafe(request, "rbRowsIndex");
      ROWCCMN50DO inRow = inRowArray.getROWCCMN50DO(index);
      personId = inRow.getUlIdPerson();
      outRowArray.addROWCCMN50DO(inRow);

      // Get this for the first pull back for StaffSecurityMnt
      fullName = inRow.getSzNmPersonFull();
    }

    request.setAttribute(StaffSearchInput.STAFF_PULL_BACK, outRowArray);
    StaffSearchInput staffSearchInput = (StaffSearchInput) state.getAttribute("StaffSearchInput", request);
    String destinationUrl = staffSearchInput.getDestinationUrl();

    // Set the UlIdPerson into GlobalData
    GlobalData.setUlIdPerson(personId, request);

    // Set into GlobalData if the secMntFlag is true, this will put that name at
    // the top of the page for StaffSecMnt.
    if (staffSearchInput.getSecMntFlag() == true) {
      GlobalData.setSzNmStaff(fullName, request);
    }

    // Remove unused objects from state
    state.removeAttribute("StaffSearchInput", request);
    // state.removeAttribute( "StaffSecurity", request );
    state.removeAttribute("ROWCCMN50DO_ARRAY", request);

    // forward the user.
    try {
      forward(destinationUrl, request, context.getResponse());
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * The continueStaffSearch_xa performs the pull back functionality for StaffSearch.jsp. It checks the PageSets to
   * determin if the row has one or more objects (radio button or checkboxes). It puts the selected row or rows into the
   * request as the StaffPullBack object. The StaffSearchInput, StaffSecurity, and ROWCCMN50DO_ARRAY are all removed
   * from state.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayStaffDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    int personID;
    String first;
    String middle;
    String last;
    String fullName;

    // Field hdnUlIdPerson and hdnDisplayType are set by JavaScript on the
    // StaffSearch.jsp when a user clicks on a hyperlink
    if ("Modify".equalsIgnoreCase(ContextHelper.getStringSafe(context, "hdnDisplayType"))) {
      personID = ContextHelper.getIntSafe(context, "hdnUlIdPerson");
    } else if ("Add".equalsIgnoreCase(ContextHelper.getStringSafe(context, "hdnDisplayType"))) {
      personID = 0;
    } else {
      personID = GlobalData.getUlIdPerson(request);
    }

    // Set the PageMode to MODIFY if user has SEC_MNTN_STAFF_GEN
    if (user.hasRight(UserProfile.SEC_MNTN_STAFF_GEN)) {
      PageMode.setPageMode(PageModeConstants.MODIFY, request);
    } else {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
    }

    try {
      // If a person ID is passed to this method, then we are displaying
      // for an already existing staff member, set the reqfunccd to "update"
      if (personID != 0) {
        // Set the personId into GlobalData
        GlobalData.setUlIdPerson(personID, request);

        // Allocate the structures
        ArchInputStruct input = new ArchInputStruct();
        CCMN04SI ccmn04si = new CCMN04SI();

        // Set the values for the ArchInputStruct
        input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
        input.setUsPageNbr(1);
        input.setUlPageSizeNbr(50);
        input.setSzUserId(user.getUserLogonID());
        ccmn04si.setArchInputStruct(input);

        UlIdPerson_ARRAY_CCMN04SI a = new UlIdPerson_ARRAY_CCMN04SI();

        a.addUlIdPerson(personID);
        ccmn04si.setUlIdPerson_ARRAY_CCMN04SI(a);

        CCMN04SO ccmn04so = admin.retrieveEmployeeDetail(ccmn04si);

        /**
         * If the Staff is terminated (has a termination date) set int's to 0 and Strings to Empty Strings:
         * 
         * FTE: 0 Office: "" Unit: "" Region/Div: "" Program: "" Role: "" Mail Code: ""
         */

        if (ccmn04so.getROWCCMN04SOG00().getDtDtEmpTermination() != null) {
          ccmn04so.getROWCCMN04SOG00().setLNbrEmpActivePct(0);
          ccmn04so.setSzNmOfficeName("");
          ROWCCMN04SOG04 rowccmn04sog04 = new ROWCCMN04SOG04();
          rowccmn04sog04.setSzNbrUnit("");
          rowccmn04sog04.setSzCdUnitRegion("");
          rowccmn04sog04.setSzCdUnitProgram("");
          rowccmn04sog04.setSzCdUnitMemberRole("");
          ccmn04so.setROWCCMN04SOG04(rowccmn04sog04);
          // ccmn04so.setSzAddrMailCode("");
          ccmn04so.setSzNmOfficeName("");
        }

        state.setAttribute("CCMN04SO", ccmn04so, request);

        first = ccmn04so.getROWCCMN04SOG01().getSzNmNameFirst();
        middle = ccmn04so.getROWCCMN04SOG01().getSzNmNameMiddle();
        last = ccmn04so.getROWCCMN04SOG01().getSzNmNameLast();

        fullName = FormattingHelper.formatFullName(first, middle, last);

        // Set USPS message for display on the JSP
        // shouldn't this be the pending indicator - changed 7/8 CSD
        // if ( ccmn04so.getROWCCMN04SOG00().getBIndEmpConfirmedHrmis().equalsIgnoreCase("N") &&
        // ccmn04so.getROWCCMN04SOG00().getBIndEmpConfirmedHrmis() != null )
        /*
         * if ("Y".equalsIgnoreCase(ccmn04so.getROWCCMN04SOG00().getBIndEmpPendingHrmis()) &&
         * ccmn04so.getROWCCMN04SOG00().getBIndEmpPendingHrmis() != null)
         *  { String pendingHrmis = MessageLookup.getMessageByNumber(Messages.MSG_CMN_PNDING_USPS);
         * setInformationalMessage(pendingHrmis, "/admin/StaffSearch/displayStaffDetail", request); }
         */

        // Set PersonID and Full Name into Global Data
        GlobalData.setUlIdPerson(personID, request);
        GlobalData.setSzNmStaff(fullName, request);
        // SIR 19748 - also set person name into global data for use in
        // infobox on records check
        GlobalData.setSzNmPersonFull(fullName, request);

        request.setAttribute("cReqFuncCd", ServiceConstants.REQ_FUNC_CD_UPDATE);

        /*
         * Race Ehtnicity Sub-module code for populating in the display.
         */

        // getting race data
        CCMN04SOG07_ARRAY raceList;
        if (ccmn04so.getCCMN04SOG07_ARRAY() != null) {
          raceList = ccmn04so.getCCMN04SOG07_ARRAY();
        } else {
          raceList = new CCMN04SOG07_ARRAY();
        }

        // getting ethnicity data
        CCMN04SOG08_ARRAY ethnicityList;
        if (ccmn04so.getCCMN04SOG08_ARRAY() != null) {
          ethnicityList = ccmn04so.getCCMN04SOG08_ARRAY();
        } else {
          ethnicityList = new CCMN04SOG08_ARRAY();
        }

        // create a RaceEthnicityBean, populating, and add it to the request
        RaceEthnicityBean reBean = new RaceEthnicityBean();
        reBean.setRaces(raceList);
        reBean.setEthnicity(ethnicityList);
        RaceEthnicityHelper.addToRequest(reBean, request);

        /*
         * // give the user an informational message that all history rows are // ended, but the termination date is not
         * entered. ROWCCMN04SOG02 jobDescritption = ccmn04so.getROWCCMN04SOG02(); //boolean mostRecentFound = false;
         * 
         * //ROWCCMN04SOG02 displayJobDescriptionArray = ccmn04so.getROWCCMN04SOG02();
         * 
         *  // find the job history row that used to be the current job history if (displayJobDescriptionArray == null) {
         * displayJobDescriptionArray = new ROWCCMN04SOG02(); }
         * 
         * 
         * Enumeration e = displayJobDescriptionArray.enumerateROWCCMN04SOG02(); while (e.hasMoreElements() &&
         * !mostRecentFound) { jobDescritption = (ROWCCMN04SOG02) e.nextElement(); mostRecentFound =
         * (jobDescritption.getDtDtJobEnd() == null); }
         * 
         * 
         * //if (ccmn04so.getROWCCMN04SOG00().getDtDtEmpTermination() == null && !mostRecentFound) { // Verified that
         * the line below is not required/necessary from cjg
         * 
         * if( ( ccmn04so.getROWCCMN04SOG00().getDtDtEmpTermination() ) == null ) { String needTermDate = "Job History
         * is end dated, but Term date is not entered"; setInformationalMessage(needTermDate, DISPLAY_PAGE, request);
         * setPopUpMessage(needTermDate, DISPLAY_PAGE, request); }
         */
      } else // The person is new, set the reqfuncd to "add"
      {
        PageMode.setPageMode(PageModeConstants.NEW, request);

        // Set AppMode to Edit
        GlobalData.setAppMode(PageModeConstants.EDIT, request);

        request.setAttribute("cReqFuncCd", ServiceConstants.REQ_FUNC_CD_ADD);
      }
    }

    catch (ServiceException we) {
      processSevereException(context, we);
    } catch (Exception e) {
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * The addStaffDetail_xa calls the populateCCMN05SI_Add method that populates the service with the fields on
   * StaffDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void addStaffDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addStaffDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    try {
      CCMN05SI ccmn05si = populateCCMN05SI_Add(context);
      CCMN05SO ccmn05so = admin.saveEmployeeDetail(ccmn05si);

      GlobalData.setUlIdPerson(ccmn05so.getUlIdPerson(), request);
      // PageMode.setPageMode(PageModeConstants.EDIT, request);
      // forward the user to Staff Detail
      forward("/admin/StaffSearch/displayStaffDetail", request, context.getResponse());
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_ADD_TO_UNIT:
      case Messages.MSG_CMN_FIRST_UNIT_MBR:
      case Messages.MSG_CMN_INVALID_UNIT:
      case Messages.MSG_CMN_SSN_NOT_UNIQUE:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_STF_APPRVR_MOD:
      case Messages.MSG_CMN_INVALID_OFFICE:
      case Messages.MSG_CMN_MORE_THAN_50_MEMBERS: // SIR 23196
        setErrorMessage(errorCode, "/admin/StaffSearch/displayStaffDetail", request);
        break;
      // This handles any bad uncaught exceptions
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
   * The saveStaffDetail_xa saves the Staff person being viewed on StaffDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveStaffDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveStaffDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    int personID = GlobalData.getUlIdPerson(request);

    CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

    try {
      // Check to see if Program, Region/Division or Unit have been changed. If
      // they have, call service CCMN08SO to update the supervisor, end date the
      // current job and create a new one with the updated supervisor and send
      // them to the JobHistoryDetail.jsp
      //String oldProgram = ccmn04so.getROWCCMN04SOG04().getSzCdUnitProgram();
      String oldRegion = ccmn04so.getROWCCMN04SOG04().getSzCdUnitRegion();
      String oldUnit = ccmn04so.getROWCCMN04SOG04().getSzNbrUnit();

      //String newProgram = ContextHelper.getStringSafe(context, "cboSzCdUnitProgram");
      String newRegion = ContextHelper.getStringSafe(context, "cboSzCdUnitRegion");
      String newUnit = ContextHelper.getStringSafe(context, "txtSzNbrUnit").toUpperCase();

      CCMN05SI ccmn05si = populateCCMN05SI(context, ServiceConstants.REQ_FUNC_CD_UPDATE);

      admin.saveEmployeeDetail(ccmn05si);

      if (!newRegion.equals(oldRegion) || !newUnit.equals(oldUnit)) {
        // Call CCMN08SOS to get new Supervisor
        CCMN08SI ccmn08si = populateCCMN08SI(context);
        CCMN08SO ccmn08so = admin.findUnitSupervisorName(ccmn08si);
        // since ccmn05 was called to save, need new values before updating job history
        ArchInputStruct input = new ArchInputStruct();
        CCMN04SI ccmn04si = new CCMN04SI();

        // Set the values for the ArchInputStruct
        input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_LIST);
        input.setUsPageNbr(1);
        input.setUlPageSizeNbr(50);
        input.setSzUserId(user.getUserLogonID());
        ccmn04si.setArchInputStruct(input);

        UlIdPerson_ARRAY_CCMN04SI a = new UlIdPerson_ARRAY_CCMN04SI();

        a.addUlIdPerson(personID);
        ccmn04si.setUlIdPerson_ARRAY_CCMN04SI(a);

        ccmn04so = admin.retrieveEmployeeDetail(ccmn04si);

        state.setAttribute("CCMN04SO", ccmn04so, request);

        // This method is only called for its side-effects (e.g. sets page mode).
        populateROWCCMN04SOG02_DisplayJobHistory(context, ccmn08so);

        // go to the job history detail page.
        int supervisorId = 0;
        String supervisorName;

        try {
          // SIR 18919 - supervisor isn't being changed when program, reg/div or unit change
          // supervisorName = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02( 0 ).getSzNmPersonFull();
          // supervisorId = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02( 0 ).getUlIdJobPersSupv();
          supervisorName = ccmn08so.getSzNmPersonFull();
          supervisorId = ccmn08so.getUlIdPerson();
        } catch (Exception e) {
          // if there are any problems getting the supervisor name, just set it to blank
          supervisorName = "";
        }
        request.setAttribute("supervisorName", supervisorName);
        request.setAttribute("supervisorId", String.valueOf(supervisorId));
        state.setAttribute("currSupervisor", String.valueOf(supervisorId), request);
        // state.setAttribute( "CCMN05SI", ccmn05si, request );
        // request.setAttribute( "ROWCCMN04SOG02", jobHistory );

        // call Job History
        // String changedLocation = "Program, Reg/Div, or Unit has changed. Please update job history.";
        // setInformationalMessage(changedLocation, "/admin/StaffSearch/displayJobHistory", request);
        forward("/admin/StaffSearch/displayStaffDetail", request, context.getResponse());
      } else {
        // Just save by calling the populateCCMN05SI()
        // CCMN05SI ccmn05si = populateCCMN05SI( context, WtcHelper.REQ_FUNC_CD_UPDATE );
        // WtcHelper.callService( "CCMN05S", ccmn05si );

        // call Staff Detail
        forward("/admin/StaffSearch/displayStaffDetail", request, context.getResponse());
      }
    }catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_STF_APPRVR_DEL:
      case Messages.MSG_CMN_ONCALL_OUTSTANDING:
        setErrorMessage(errorCode, "/admin/StaffSearch/displayStaffDetail", request);
        break;
      // This handles any bad uncaught exceptions
      default:
        handleError(we, context, null);
        break;
      }
    } catch (Exception e) {
      handleError(e, context, null);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * The deleteStaffDetailJob_xa deletes the Staff person being viewed on StaffDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void deleteStaffDetailJob_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteStaffDetailJob_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Set the cReqFuncCd to delete
    request.setAttribute("hdnCReqFuncCd", ServiceConstants.REQ_FUNC_CD_DELETE);

    try {
      CCMN05SI ccmn05si = populateCCMN05SI(context, ServiceConstants.REQ_FUNC_CD_UPDATE);
      // CCMN05SI ccmn05si = (CCMN05SI)state.getAttribute( "CCMN05SI", request );
      ccmn05si = populateCCMN05SI_Delete(context, ccmn05si);
      admin.saveEmployeeDetail(ccmn05si);
      // delete should only be pressed once, Search display will clear attribute
      state.setAttribute("deletePressed", "true", request);

      forward("/admin/StaffSearch/displayStaffDetail", request, context.getResponse());
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_STF_APPRVR_MOD:
      case Messages.MSG_CMN_STF_APPRVR_DEL:
      case Messages.MSG_CMN_UNIT_APPROVER:
        setErrorMessage(errorCode, "/admin/StaffSearch/displayStaffDetail", request);
        break;
      // This handles any bad uncaught exceptions
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
   * The displayJobDescriptionDetail displays the JobDescriptionDetail page.
   * 
   * @param context
   */
  public void displayJobDescriptionDetail_xa(GrndsExchangeContext context) {
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    
    try{
      CCMN05SI ccmn05si = copyCCMN04STOCCMN05S(context);
      CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

    /*
     * ROWCCMN04SOG02 jobDescription = ccmn04so.getROWCCMN04SOG02(); //ROWCCMN04SOG02 jobHistory =
     * jobHistoryArray.getROWCCMN04SOG02(index);
     * 
     * request.setAttribute("ROWCCMN04SOG02", jobDescription); state.setAttribute("CCMN05SI", ccmn05si, request);
     */
    /*
     * try { // 22500 get new supervisor CCMN08SI ccmn08si = populateCCMN08SI(context); CCMN08SO ccmn08so =
     * admin.findUnitSupervisorName(ccmn08si); int currSupervisor = ccmn08so.getUlIdPerson();
     * state.setAttribute("currSupervisor", String.valueOf(currSupervisor), request); } catch (Exception e) {
     * processSevereException(context, e); }
     */
    //ccmn05si = populateCCMN05SI(context, ServiceConstants.REQ_FUNC_CD_LIST);
    //ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

      ROWCCMN04SOG02 jobDescription = ccmn04so.getROWCCMN04SOG02();
    // ROWCCMN04SOG02 jobHistoryArray = jobHistoryArray.getROWCCMN04SOG02(index);
    
    //request.setAttribute("ROWCCMN04SOG02", jobDescription);
      state.setAttribute("ROWCCMN04SOG02", jobDescription, request);
      state.setAttribute("CCMN05SI", ccmn05si, request);
    } catch(Exception e){
      handleError(e, context, "error");
    }
  }

  /**
   * The saveJobDescriptionDetail_xa saves the Job Description.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void saveJobDescriptionDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveJobDescriptionDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // Call the save method for Job History
    try {
      CCMN05SI ccmn05si = (CCMN05SI) state.getAttribute("CCMN05SI", request);
      ccmn05si = populateCCMN05SI_SaveJobDescription(context, ccmn05si);

      ccmn05si.getROWCCMN05SIG00().setBIndEmpPendingHrmis("Y");

      admin.saveEmployeeDetail(ccmn05si);

      // Set PageMode to MODIFY for redisplay of StaffDetail.jsp
      PageMode.setPageMode(PageModeConstants.MODIFY, request);

      // call Staff Detail
      // forward("/admin/StaffSearch/displayStaffDetail", request, context.getResponse());
    } catch (Exception e) {
      handleError(e, context, "error");
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  private void handleError(Exception e, GrndsExchangeContext context, String errorBranch){
    if(e instanceof ServiceException){
      ServiceException se = (ServiceException) e;
      if(errorBranch != null){
        setPresentationBranch(errorBranch, context);
      }
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_ADD_TO_UNIT:
      case Messages.MSG_CMN_FIRST_UNIT_MBR:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_CMN_INVALID_UNIT:
      case Messages.MSG_CMN_STF_APPRVR_MOD:
      case Messages.MSG_CMN_INVALID_OFFICE:
      case Messages.MSG_CMN_TODO_OUTSTANDING:
      case Messages.MSG_CMN_STAGES_OUTSTANDING:
        setErrorMessage(errorCode, "/admin/StaffSearch/displayStaffDetail", context.getRequest());
        break;
      default:
        processSevereException(context, se);
        break;
      }
    } else{
      processSevereException(context, e);
    }
  }

  /**
   * Public setter method
   * 
   * @param admin
   */
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * The populateJobDescription populates the Job Description row with the fields on JobDescriptionDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param reqFunCd
   *          This will set the data action to add "A" or update "U".
   * @param supervisorId
   *          This is the id of the supervisor
   * @return jobHistory
   */
  private ROWCCMN05SIG02 populateJobDescription(GrndsExchangeContext context, String reqFunCd, int supervisorId) {
    ROWCCMN05SIG02 jobDescription = new ROWCCMN05SIG02();

    // This sets all the fields from Job History JSP and returns the row
    jobDescription.setUlIdEmpJobHistory(ContextHelper.getIntSafe(context, "hdnUlIdEmpJobHistory"));
    jobDescription.setBIndJobAssignable(CheckboxHelper.getCheckboxValue(context.getRequest(), "cbxbIndCaseAssignable"));
    jobDescription.setSzCdJobClass(ContextHelper.getStringSafe(context, "cboSzCdJobTitle"));
    jobDescription.setSzBjnJob(ContextHelper.getStringSafe(context, "txtSzTextERS").toUpperCase());
    jobDescription.setTsLastUpdate(ContextHelper.getJavaDateSafe(context, "hdnTsLastUpdate"));
    jobDescription.setSzCdJobFunction(ContextHelper.getStringSafe(context, "hdnSzCdJobFunction"));
    jobDescription.setUlIdJobPersSupv(supervisorId);
    jobDescription.setSzCdScrDataAction(reqFunCd);
    jobDescription.setSzCdJobTitle(ContextHelper.getStringSafe(context, "cboSzCdJobTitle"));

    return jobDescription;
  }

  /**
   * The populateCCMN05SI_SaveJobDescription saves the Job Description.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param ccmn05si
   *          Instance of the CCMN05SI object
   * @return ccmn05si
   */
  private CCMN05SI populateCCMN05SI_SaveJobDescription(GrndsExchangeContext context, CCMN05SI ccmn05si) {
    //BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    // Get the Job History row out of the CCMN05SI object
    ROWCCMN05SIG02 jobDescription = ccmn05si.getROWCCMN05SIG02();

    if (jobDescription == null) {
      jobDescription = new ROWCCMN05SIG02();
    }

    String functionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    // int supervisorId = Integer.parseInt(request.getParameter("hdnUlIdJobPersSupv"));
    // 22500 - use current supervisor on save which is represented by hdnUlIdJobPersSupv
    // and not by currSupervisor
    //-- NullPointer: int supervisorId = Integer.parseInt(state.getAttribute("currSupervisor", request).toString());
    int supervisorId = ContextHelper.getIntSafe(request, "hdnUlIdJobPersSupv");
    //int supervisorId = Integer.parseInt(request.getAttribute("supervisorId").toString());

    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
      // SIR 22500 - clear array since job history will save both old and new
      // job history records and update supervisor
      jobDescription = null;// .clearROWCCMN05SIG02();
      functionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    }

    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    // Sir19133 changed PageSizeNbr from 50 to 10
    // input.setUlPageSizeNbr( 50 );
    input.setUlPageSizeNbr(PageSizeNbr.CCMN05SOG01_SZCDPERSONRACE_SIZE);
    input.setSzUserId(user.getUserLogonID());

    ccmn05si.setArchInputStruct(input);

    ccmn05si.setUlIdEmployee(user.getUserID());

    // Call the populate Job History method to set the fields
    jobDescription = populateJobDescription(context, functionCode, supervisorId);

    // Set the Job History row back onto the CCMN05SI object
    ccmn05si.setROWCCMN05SIG02(jobDescription);

    return ccmn05si;
  }

  /**
   * The populateCCMN05SI calls the CCMN05SI service to save the fields on the StaffDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param functionCode
   *          Sets the cReqFuncCd to add "A" or update "U".
   * @return ccmn05si
   */
  private CCMN05SI populateCCMN05SI(GrndsExchangeContext context, String functionCode) throws ServiceException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CCMN05SI ccmn05si = new CCMN05SI();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(functionCode);
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);
    input.setSzUserId(user.getUserLogonID());

    ccmn05si.setArchInputStruct(input);

    ccmn05si.setUlIdEmployee(user.getUserID());

    ccmn05si.setUlIdPerson(GlobalData.getUlIdPerson(request));

    String nameFirst = FormattingHelper.initCapsName(ContextHelper.getStringSafe(context, "txtSzNmNameFirst"));
    String nameLast = FormattingHelper.initCapsName(ContextHelper.getStringSafe(context, "txtSzNmNameLast"));
    String nameMiddle = FormattingHelper.initCapsName(ContextHelper.getStringSafe(context, "txtSzNmNameMiddle"));
    String nameFull = FormattingHelper.formatFullName(nameFirst, nameMiddle, nameLast);

    CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

    // If an employee is the victim in an APS
    // case and their name changes (say from John P. Smith
    // to John Q. Jones), the case and stage names should
    // change to reflect the new name. The old name must be
    // passed in so the dam can find the person.

    String oldFirst = ccmn04so.getROWCCMN04SOG01().getSzNmNameFirst();
    String oldMiddle = ccmn04so.getROWCCMN04SOG01().getSzNmNameMiddle();
    String oldLast = ccmn04so.getROWCCMN04SOG01().getSzNmNameLast();
    String oldName = FormattingHelper.formatFullName(oldFirst, oldMiddle, oldLast);

    // Call CCMN08SOS to get new Unit ID for Program, Unit and Region combination
    CCMN08SO ccmn08so = populateUlIdUnit(context);
    int UlIdUnit = ccmn08so.getUlIdUnit();
    int currSupervisor = ccmn08so.getUlIdPerson();

    state.setAttribute("currSupervisor", String.valueOf(currSupervisor), request);

    // String oldName = ccmn04so.getROWCCMN04SOG06().getSzNmPersonFull();

    ccmn05si.setSzNmPersonFull(oldName);

    ROWCCMN05SIG00 rowccmn05sig00 = populateROWCCMN04SO0(ccmn04so.getROWCCMN04SOG00(), context,
                                                         ccmn04so.getUlIdOffice());
    ROWCCMN05SIG01 rowccmn05sig01 = populateROWCCMN04SO1(ccmn04so.getROWCCMN04SOG01(), context, oldName, nameFull);
    ROWCCMN05SIG04 rowccmn05sig04 = populateROWCCMN04SO4(ccmn04so.getROWCCMN04SOG04(), context, UlIdUnit);
    ROWCCMN05SIG05 rowccmn05sig05 = populateROWCCMN04SO5(ccmn04so.getROWCCMN04SOG05(), context);
    ROWCCMN05SIG06 rowccmn05sig06 = populateROWCCMN04SO6(ccmn04so.getROWCCMN04SOG06(), context, nameFull);

    /*
     * Populate for Race Ethnicity
     */
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    // SIR 17612 - fix ethnicity group
    rowccmn05sig06.setSzCdPersonEthnicGroup(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request));

    ROWCCMN05SIG08_ARRAY raceArray = new ROWCCMN05SIG08_ARRAY();
    ROWCCMN05SIG09_ARRAY ethArray = new ROWCCMN05SIG09_ARRAY();

    RaceEthnicityBean.Races races = reBean.getRaces();

    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
      ROWCCMN05SIG08 raceRow = new ROWCCMN05SIG08();
      raceRow.setSzCdPersonRace(race.getValue());
      raceRow.setSzCdScrDataAction(race.getActionCode());
      raceArray.addROWCCMN05SIG08(raceRow);
    }

    // If the old ethnicity is equivalant to the new ethnicity no need to
    // resave the information. If they are not equal, Add the new Eth.
    // The DAM automatically deletes the old eth.
    String ethnicity = reBean.getEthnicity();
    if (!ethnicity.equals(reBean.getOldEthnicity())) {
      ROWCCMN05SIG09 ethRow = new ROWCCMN05SIG09();
      ethRow.setSzCdPersonEthnicity(ethnicity);
      ethRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      ethArray.addROWCCMN05SIG09(ethRow);

      // ** DWW: 05/06/2003
      // ** SIRs 16675, 16868
      // ** changed to only add one ethnicity, not add the new one and delete the old.

      // ethRow = new ROWCCMN05SIG09();
      // ethRow.setSzCdPersonEthnicity( reBean.getOldEthnicity() );
      // ethRow.setSzCdScrDataAction( WtcHelper.REQ_FUNC_CD_DELETE );
      // ethArray.addROWCCMN05SIG09( ethRow );
    }

    // SIR 22500 - update supervisor every save unless job history has already
    // been updated from job history unless program, reg, div, unit are
    // changing
    // String oldProgram = ccmn04so.getROWCCMN04SOG04().getSzCdUnitProgram();
    //String oldRegion = ccmn04so.getROWCCMN04SOG04().getSzCdUnitRegion();
    //String oldUnit = ccmn04so.getROWCCMN04SOG04().getSzNbrUnit();
    // String newProgram = ContextHelper.getStringSafe(context, "cboSzCdUnitProgram");
    //String newRegion = ContextHelper.getStringSafe(context, "cboSzCdUnitRegion");
    //String newUnit = ContextHelper.getStringSafe(context, "txtSzNbrUnit");

    ROWCCMN04SOG02 jobDescription = ccmn04so.getROWCCMN04SOG02();
    if (jobDescription == null) {
      processSevereException(context, new Exception("Job Description is null."));
    }

    ROWCCMN05SIG02 updatedJobDescription = new ROWCCMN05SIG02();

    // always update job history
    updatedJobDescription.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    updatedJobDescription.setDtDtJobEnd(ContextHelper.getCastorDateSafe(context, "txtDtJobTerm"));
    if (!DateHelper.isNull(ContextHelper.getCastorDateSafe(context, "txtDtJobTerm"))) {
      updatedJobDescription.setBIndJobAssignable(ArchitectureConstants.N);
    }else {
      updatedJobDescription.setBIndJobAssignable(jobDescription.getBIndJobAssignable());
    }
    updatedJobDescription.setDtDtJobStart(jobDescription.getDtDtJobStart());
    updatedJobDescription.setSzBjnJob(jobDescription.getSzBjnJob());
    updatedJobDescription.setSzCdJobClass(jobDescription.getSzCdJobClass());
    //updatedJobDescription.setSzCdJobClass(jobDescription.getSzCdJobTitle());
    updatedJobDescription.setSzCdJobTitle(jobDescription.getSzCdJobTitle());
    updatedJobDescription.setSzCdJobFunction(jobDescription.getSzCdJobFunction());
    updatedJobDescription.setTsLastUpdate(jobDescription.getTsLastUpdate());
    updatedJobDescription.setUlIdEmpJobHistory(jobDescription.getUlIdEmpJobHistory());
    updatedJobDescription.setUlIdJobPersSupv(jobDescription.getUlIdJobPersSupv());

    if (ccmn08so.getUlIdPerson() != jobDescription.getUlIdJobPersSupv()) {
      updatedJobDescription.setUlIdJobPersSupv(ccmn08so.getUlIdPerson());
    }

    ccmn05si.setROWCCMN05SIG02(updatedJobDescription);

    // Set all the rows back into the ccmn05si object
    ccmn05si.setROWCCMN05SIG00(rowccmn05sig00);
    ccmn05si.setROWCCMN05SIG01(rowccmn05sig01);
    ccmn05si.setROWCCMN05SIG04(rowccmn05sig04);
    ccmn05si.setROWCCMN05SIG05(rowccmn05sig05);
    ccmn05si.setROWCCMN05SIG06(rowccmn05sig06);
    ccmn05si.setROWCCMN05SIG08_ARRAY(raceArray);
    ccmn05si.setROWCCMN05SIG09_ARRAY(ethArray);

    return ccmn05si;
  }

  /**
   * The populateCCMN05SI_Delete calls the CCMN05SI service to save the fields on the StaffDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param ccmn05si
   *          Gets an instance of the CCMN05SI object.
   * @return ccmn05si
   */
  private CCMN05SI populateCCMN05SI_Delete(GrndsExchangeContext context, CCMN05SI ccmn05si) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);
    ROWCCMN04SOG02_ARRAY inRowArray = ccmn04so.getROWCCMN04SOG02_ARRAY();

    ROWCCMN04SOG02 inRow = inRowArray.getROWCCMN04SOG02(0);
    ROWCCMN05SIG02 deleteRow = new ROWCCMN05SIG02();
    ROWCCMN05SIG02_ARRAY deleteRowArray = new ROWCCMN05SIG02_ARRAY();
    // ROWCCMN05SIG02 updateRow = new ROWCCMN05SIG02();

    // Delete the Row in the 0 index position
    deleteRow.setTsLastUpdate(inRow.getTsLastUpdate());
    deleteRow.setUlIdEmpJobHistory(inRow.getUlIdEmpJobHistory());
    deleteRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);

    // If the row deleted was the only row, there is nothing in the 1st position
    // so skip this functionality and just delete the row.
    // if (inRowArray.getROWCCMN04SOG02Count() > 1 )
    // {
    // Get the 2nd row in the array because we need to update id_emp_job_hist
    // on employee table (happens in table004.trg)
    ROWCCMN04SOG02 inRow2 = inRowArray.getROWCCMN04SOG02(1);

    // Set End Date to Max Castor Date and update JobClass and EmpJobHistory
    // for the row in the 1st position
    // updateRow.setTsLastUpdate( inRow2.getTsLastUpdate() );
    // updateRow.setUlIdEmpJobHistory( inRow2.getUlIdEmpJobHistory() );
    // updateRow.setSzCdScrDataAction( WtcHelper.REQ_FUNC_CD_UPDATE );
    // updateRow.setDtDtJobEnd( DateHelper.MAX_CASTOR_DATE );
    // updateRow.setDtDtJobStart( inRow2.getDtDtJobStart() );
    // updateRow.setBIndJobAssignable( inRow2.getBIndJobAssignable() );
    // updateRow.setSzBjnJob( inRow2.getSzBjnJob() );
    // updateRow.setSzCdJobClass( inRow2.getSzCdJobClass() );
    // updateRow.setSzCdJobFunction( inRow2.getSzCdJobFunction() );
    // updateRow.setUlIdJobPersSupv( inRow2.getUlIdJobPersSupv() );

    // deleteRowArray.addROWCCMN05SIG02( updateRow );
    ccmn05si.getROWCCMN05SIG00().setUlIdEmpJobHistory(inRow2.getUlIdEmpJobHistory());
    // }

    deleteRowArray.addROWCCMN05SIG02(deleteRow);
    ccmn05si.setROWCCMN05SIG02_ARRAY(deleteRowArray);

    return ccmn05si;
  }

  private CCMN03SO staffSearch(GrndsExchangeContext context, CCMN03SI ccmn03si) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Pagination
    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(SEARCH_RESULTS_PER_PAGE);

    try {

      // Set this for the JSP to display the results section
      request.setAttribute("SearchPerformed", "Y");

      // If this is NOT the second search for Staff Security Mnt, clear state.
      if (!Sets.isInSet(Sets.E | Sets.F, request)) {
        state.removeAttribute("StaffSearch", request);
      }
      
      ArchInputStruct ais = null;
      if(ccmn03si.getArchInputStruct() != null){
        ais = ccmn03si.getArchInputStruct();
      } else{
        ais = new ArchInputStruct();
      }
      ais.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
      ais.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
      ccmn03si.setArchInputStruct(ais);

      // call the Tuxedo service using the WtcHelper object
      CCMN03SO ccmn03so = admin.retrieveStaffList(ccmn03si);

      /**
       * The search results will be set into two different objects. If coming from Staff Security Maintainance, Sets
       * will be "E". Set the result into object named "StaffSecurity". If the user came from anywhere else, set the
       * results into the StaffSearch object.
       * 
       * ROWCCMN50DO_ARRAY is the row object that the pull back gets set into.
       */
      if (Sets.isInSet(Sets.E | Sets.F, request)) {
        state.setAttribute("CCMN03SI", ccmn03si, request);
        state.setAttribute("StaffSecurity", ccmn03so, request);
        state.setAttribute("ROWCCMN50DO_ARRAY", ccmn03so.getROWCCMN50DO_ARRAY(), request);
      } else {
        state.setAttribute("StaffSearch", ccmn03so, request);
        state.setAttribute("ROWCCMN50DO_ARRAY", ccmn03so.getROWCCMN50DO_ARRAY(), request);
      }

      //ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      //archOutputStruct.setBMoreDataInd(ccmn03so.getROWCCMN50DO_ARRAY().getBMoreDataInd());
      //ccmn03so.setArchOutputStruct(archOutputStruct);
      tuxPagination.setPaginationInformation(ccmn03so.getArchOutputStruct(), ccmn03so.getROWCCMN50DO_ARRAY().getROWCCMN50DOCount());
      storePaginationBeanToRequest(context, tuxPagination);

      return ccmn03so;
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.MSG_CMN_SEARCH_NOT_FOUND:

        break;

      // This handles any bad uncaught exceptions
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }

    return null;
  }

  /**
   * The populateROWCCMN04SOG02_DisplayJobHistory populates fields from JobHistory.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @param ccmn08so
   *          CCMN08SO object.
   * @return newJobHistory
   */
  private ROWCCMN04SOG02 populateROWCCMN04SOG02_DisplayJobHistory(GrndsExchangeContext context, CCMN08SO ccmn08so) {
    HttpServletRequest request = context.getRequest();
    org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());

    // create a new job history row using the supervisor returned by ccmn08s
    // starting today
    ROWCCMN04SOG02 newJobHistory = new ROWCCMN04SOG02();
    newJobHistory.setDtDtJobEnd(null);
    newJobHistory.setDtDtJobStart(today);
    newJobHistory.setUlIdJobPersSupv(ccmn08so.getUlIdPerson());
    PageMode.setPageMode(PageModeConstants.NEW, request);

    return newJobHistory;
  }

  /**
   * The populateCCMN08SI Gets the Supervisor Id basesd on the Region, Unit and Program.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccmn08si CCMN08SI object.
   */
  private CCMN08SI populateCCMN08SI(GrndsExchangeContext context) {
    // Call CCMN08SI to update supervisor and save Program, Unit and Region.
    CCMN08SI ccmn08si = new CCMN08SI();
    ArchInputStruct unitInput = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    unitInput.setCReqFuncCd("S");
    unitInput.setBPerfInd("Y");
    unitInput.setBDataAcsInd("Y");
    unitInput.setUsPageNbr(1);

    ccmn08si.setArchInputStruct(unitInput);

    ccmn08si.setSzCdCounty(ContextHelper.getStringSafe(context, "cboSzCdCounty"));
    ccmn08si.setSzCdUnitRegion(ContextHelper.getStringSafe(context, "cboSzCdUnitRegion"));
    ccmn08si.setSzNbrUnit(ContextHelper.getStringSafe(context, "txtSzNbrUnit").toUpperCase());

    return ccmn08si;
  }

  /**
   * The populateROWCCMN04SO0 populates the ROWCCMN05SIG00 from fileds on StaffDetail.jsp.
   * 
   * @param outputRow
   *          ROWCCMN04SOG00 object.
   * @param context
   *          The GrndsExchangeContext object.
   * @return inputRow
   */
  private ROWCCMN05SIG00 populateROWCCMN04SO0(ROWCCMN04SOG00 outputRow, GrndsExchangeContext context, int ulIdOffice) {
    //HttpServletRequest request = context.getRequest();

    ROWCCMN05SIG00 inputRow = new ROWCCMN05SIG00();

    int fte;

    if (ContextHelper.getIntSafe(context, "txtlNbrEmpActivePct") == 0) {
      fte = ContextHelper.getIntSafe(context, "txtlNbrEmpActivePct");
    } else {
      fte = ContextHelper.getIntSafe(context, "hdnlNbrEmpActivePct");
    }

    // FTE, Hire Date and Term Date from JSP
    inputRow.setLNbrEmpActivePct(fte);
    inputRow.setDtDtEmpHire(ContextHelper.getCastorDateSafe(context, "txtDtJobHire"));

    // If there is NOT a termination date set bIndActive to "Y"
    if (DateHelper.isNull(ContextHelper.getCastorDateSafe(context, "txtDtJobTerm"))) {

      inputRow.setBIndActiveStatus("Y");
      inputRow.setDtDtEmpTermination(null);
    } else {
      inputRow.setBIndActiveStatus("N");
      inputRow.setDtDtEmpTermination(ContextHelper.getCastorDateSafe(context, "txtDtJobTerm"));
      // if term date is entered and there is an open job history row, end the
      // open job history

    }
    
    // Copied from out to in
    inputRow.setBIndEmpConfirmedHrmis(outputRow.getBIndEmpConfirmedHrmis());
    inputRow.setBIndEmpPendingHrmis(outputRow.getBIndEmpPendingHrmis());
    inputRow.setSzCdEmployeeClass(outputRow.getSzCdEmployeeClass());
    inputRow.setSzCdEmpProgram(outputRow.getSzCdEmpProgram());
    inputRow.setSzIdEmployeeLogon(outputRow.getSzIdEmployeeLogon());
    inputRow.setSzNmEmpEmailAddr(outputRow.getSzNmEmpEmailAddr());
    inputRow.setTsLastUpdate(outputRow.getTsLastUpdate());
    inputRow.setDtDtEmpLastAssigned(outputRow.getDtDtEmpLastAssigned());
    inputRow.setUlIdEmpJobHistory(outputRow.getUlIdEmpJobHistory());

    // JMC - SIR 18839 - The unit program that the user entered on the window
    // was not getting updated on the employee table because the following
    // variable was not getting set.
    // inputRow.setSzCdEmpProgram(ContextHelper.getStringSafe(request, "hdnUlIdOffice"));

    // Get ulIdOffice which is set into the request by the custom validation class
    String szCdOfficeLocation = ContextHelper.getStringSafe(context, "cboSzCdOfficeLocation");
    int seledtedIdOffice = Integer.parseInt(szCdOfficeLocation);
    if(seledtedIdOffice == 0){
      inputRow.setUlIdOffice(outputRow.getUlIdOffice());
    }else{
      inputRow.setUlIdOffice(seledtedIdOffice);
    }

    return inputRow;
  }

  /**
   * The populateROWCCMN04SO1 populates the ROWCCMN05SIG01 from fields on StaffDetail.jsp and sets the data action
   * depending on the old and new names being the same.
   * 
   * @param outputRow
   *          ROWCCMN04SOG01 object
   * @param context
   *          The GrndsExchangeContext object.
   * @param oldName
   *          Gets name from CCMN04SO service
   * @param newName
   *          Gets name from StaffDetail.jsp
   * @return inputRow
   */
  private ROWCCMN05SIG01 populateROWCCMN04SO1(ROWCCMN04SOG01 outputRow, GrndsExchangeContext context, String oldName,
                                              String newName) {
    ROWCCMN05SIG01 inputRow = new ROWCCMN05SIG01();

    // First, Middle and Last Name from the JSP
    inputRow.setSzNmNameFirst(FormattingHelper.initCapsName(ContextHelper.getStringSafe(context, "txtSzNmNameFirst")));
    inputRow
            .setSzNmNameMiddle(FormattingHelper.initCapsName(ContextHelper.getStringSafe(context, "txtSzNmNameMiddle")));
    inputRow.setSzNmNameLast(FormattingHelper.initCapsName(ContextHelper.getStringSafe(context, "txtSzNmNameLast")));

    // Set in the out to in
    inputRow.setBIndNameInvalid(outputRow.getBIndNameInvalid());
    inputRow.setBIndNamePrimary(outputRow.getBIndNamePrimary());
    inputRow.setDtDtNameEndDate(outputRow.getDtDtNameEndDate());
    inputRow.setDtDtNameStartDate(outputRow.getDtDtNameStartDate());
    inputRow.setUlIdName(outputRow.getUlIdName());
    if (oldName.equalsIgnoreCase(newName)) {
      inputRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    } else // Name has changed
    {
      inputRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    inputRow.setTsLastUpdate(outputRow.getTsLastUpdate());
    return inputRow;
  }

  /**
   * The populateROWCCMN04SO4 populates the ROWCCMN05SIG04 from fields on StaffDetail.jsp.
   * 
   * @param outputRow
   *          ROWCCMN04SOG04 object
   * @param context
   *          The GrndsExchangeContext object.
   * @param UlIdUnit
   *          Integer value of the Unit Id
   * @return inputRow
   */
  private ROWCCMN05SIG04 populateROWCCMN04SO4(ROWCCMN04SOG04 outputRow, GrndsExchangeContext context, int UlIdUnit) {
    ROWCCMN05SIG04 inputRow = new ROWCCMN05SIG04();

    // CSD-6/18/03 - SIR 17087 - when reinstating an employee, need to pass
    // Member IN/OUT to service
    if (outputRow.getSzCdUnitMemberInOut() == null || "".equals(outputRow.getSzCdUnitMemberInOut())) {
      inputRow.setSzCdUnitMemberInOut("IN");
    } else {
      inputRow.setSzCdUnitMemberInOut(outputRow.getSzCdUnitMemberInOut());
    }
    inputRow.setSzCdUnitMemberRole(ContextHelper.getStringSafe(context, "cboSzCdUnitMemberRole"));
    inputRow.setTsLastUpdate(outputRow.getTsLastUpdate());
    inputRow.setUlIdUnit(UlIdUnit);
    // If the UlIdUnit is different (the Program, Unit or Region has changed)
    // or Emp Term Date is filled - SIR 19915
    // set the UlIdUnitEmpLink to 0
    // if (outputRow.getUlIdUnit() != UlIdUnit
    // || DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtJobTerm")) != null) {
    // inputRow.setUlIdUnitEmpLink(0);
    // } else {
    // inputRow.setUlIdUnitEmpLink(outputRow.getUlIdUnitEmpLink());
    // }
    inputRow.setUlIdUnitEmpLink(outputRow.getUlIdUnitEmpLink());
    return inputRow;
  }

  /**
   * The populateROWCCMN04SO5 populates the ROWCCMN05SIG05 from fields on StaffDetail.jsp.
   * 
   * @param outputRow
   *          ROWCCMN04SOG05 object
   * @param context
   *          The GrndsExchangeContext object.
   * @return inputRow
   */
  private ROWCCMN05SIG05 populateROWCCMN04SO5(ROWCCMN04SOG05 outputRow, GrndsExchangeContext context) {
    ROWCCMN05SIG05 inputRow = new ROWCCMN05SIG05();

    // SSN number from JSP
    inputRow.setSzNbrPersonIdNumber(ContextHelper.getSSNSafe(context, "txtSzSysTxtGenericSSN"));

    // Copy from out to in
    inputRow.setDtPersonIDEnd(outputRow.getDtPersonIDEnd());
    inputRow.setDtPersonIDStart(outputRow.getDtPersonIDStart());
    inputRow.setSzCdPersonIdType(outputRow.getSzCdPersonIdType());
    inputRow.setSzDescPersonID(outputRow.getSzDescPersonID());
    inputRow.setSzNbrPersonIdNumber(outputRow.getSzNbrPersonIdNumber());
    inputRow.setUlIdPersonId(outputRow.getUlIdPersonId());
    inputRow.setTsLastUpdate(outputRow.getTsLastUpdate());

    return inputRow;
  }

  /**
   * The populateROWCCMN04SO6 populates the ROWCCMN05SIG06 from fields on StaffDetail.jsp.
   * 
   * @param outputRow
   *          ROWCCMN04SOG06 object
   * @param context
   *          The GrndsExchangeContext object.
   * @param nameFull
   *          Full Name
   * @return inputRow
   */
  private ROWCCMN05SIG06 populateROWCCMN04SO6(ROWCCMN04SOG06 outputRow, GrndsExchangeContext context, String nameFull) {
    ROWCCMN05SIG06 inputRow = new ROWCCMN05SIG06();
    inputRow.setCCdPersonSex(ContextHelper.getStringSafe(context, "cbocCdPersonSex"));
    //inputRow.setDtDtPersonBirth(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDateBirth")));
    inputRow.setSzCdPersonEthnicGroup(outputRow.getSzCdPersonEthnicGroup());
    inputRow.setSzNmPersonFull(nameFull);
    inputRow.setTsLastUpdate(outputRow.getTsLastUpdate());

    return inputRow;
  }

  /**
   * The populateCCMN05SI_Add populates the CCMN05SI when adding from fields on StaffDetail.jsp.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccmn05si
   */
  private CCMN05SI populateCCMN05SI_Add(GrndsExchangeContext context) throws ServiceException {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Allocate the structures
    ArchInputStruct archInputStruct = new ArchInputStruct();
    CCMN05SI ccmn05si = new CCMN05SI();

    // Set the values for the ArchInputStruct
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    archInputStruct.setBPerfInd("Y");
    archInputStruct.setBDataAcsInd("Y");
    archInputStruct.setUsPageNbr(1);
    archInputStruct.setUlPageSizeNbr(50);
    archInputStruct.setSzUserId(user.getUserLogonID());

    ccmn05si.setArchInputStruct(archInputStruct);

    ccmn05si.setUlIdPerson(0);

    ccmn05si.setUlIdEmployee(user.getUserID());

    // String nameFirst = FormattingHelper.initCapsName( ContextHelper.getStringSafe( context, "txtSzNmNameFirst" ) );
    // String nameLast = FormattingHelper.initCapsName( ContextHelper.getStringSafe( context, "txtSzNmNameLast" ) );
    // String nameMiddle = FormattingHelper.initCapsName( ContextHelper.getStringSafe( context, "txtSzNmNameMiddle" ) );
    String nameFirst = FormattingHelper.changeCase(ContextHelper.getStringSafe(context, "txtSzNmNameFirst"));
    String nameLast = FormattingHelper.changeCase(ContextHelper.getStringSafe(context, "txtSzNmNameLast"));
    String nameMiddle = FormattingHelper.changeCase(ContextHelper.getStringSafe(context, "txtSzNmNameMiddle"));
    String nameFull = FormattingHelper.formatFullName(nameFirst, nameMiddle, nameLast);

    ccmn05si.setSzNmPersonFull("");
    // ccmn05si.setSzNmPersonFull( nameFull );

    // Use the Unit, Program and Region to retrieve the ulIdUnit for the ROWCCMN04SIG04
    // And for the Supervisor ID and Name
    int supervisorId;
    String supervisorName;
    int ulIdUnit;
    CCMN08SO ccmn08so = populateUlIdUnit(context);
    supervisorId = ccmn08so.getUlIdPerson();
    supervisorName = ccmn08so.getSzNmPersonFull();
    ulIdUnit = ccmn08so.getUlIdUnit();

    request.setAttribute("supervisorName", supervisorName);
    request.setAttribute("supervisorId", "" + supervisorId);

    ROWCCMN05SIG00 row0 = new ROWCCMN05SIG00();
    ROWCCMN05SIG02 jobHistory = populateJobDescription(context, ServiceConstants.REQ_FUNC_CD_ADD, supervisorId);
    // ROWCCMN05SIG02_ARRAY jobHistoryArray = new ROWCCMN05SIG02_ARRAY();
    // jobHistoryArray.addROWCCMN05SIG02(jobHistory);
    ROWCCMN05SIG01 row1 = new ROWCCMN05SIG01();
    ROWCCMN05SIG04 row4 = new ROWCCMN05SIG04();
    ROWCCMN05SIG05 row5 = new ROWCCMN05SIG05();
    ROWCCMN05SIG06 row6 = new ROWCCMN05SIG06();

    // Set the ROWCCMN04SIG00
    row0.setSzCdEmpProgram(ContextHelper.getStringSafe(request, "cboSzCdUnitProgram"));
    row0.setSzCdEmployeeClass(jobHistory.getSzCdJobClass());
    row0.setLNbrEmpActivePct(ContextHelper.getIntSafe(context, "txtlNbrEmpActivePct"));
    row0.setDtDtEmpHire(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtJobHire")));
    row0.setUlIdEmpJobHistory(0); // Constant
    row0.setSzIdEmployeeLogon(""); // Constant
    row0.setDtDtEmpLastAssigned(null);
    row0.setBIndEmpPendingHrmis("Y"); // Constant
    row0.setBIndEmpConfirmedHrmis("N"); // Constant
    row0.setBIndActiveStatus("Y"); // Constant
    row0.setSzNmEmpEmailAddr(""); // Constant

    // ulIdOffice is set into the request by the custom validation class
    String szCdOfficeLocation = ContextHelper.getStringSafe(context, "cboSzCdOfficeLocation");
    int ulIdOffice = Integer.parseInt(szCdOfficeLocation);
    row0.setUlIdOffice(ulIdOffice);

    if ("".equals(ContextHelper.getStringSafe(context, "txtDtJobEnd"))) {
      row0.setDtDtEmpTermination(ContextHelper.getCastorDateSafe(context, "txtDtJobTerm"));
    } else {
      row0.setDtDtEmpTermination(null);
    }
    // Set the ROWCCMN04SIG01
    row1.setDtDtNameStartDate(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtJobHire")));
    row1.setUlIdName(0); // Constant
    row1.setBIndNameInvalid("N"); // Constant
    row1.setBIndNamePrimary("Y"); // Constant
    row1.setSzNmNameFirst(nameFirst);
    row1.setSzNmNameMiddle(nameMiddle);
    row1.setSzNmNameLast(nameLast);
    row1.setSzCdScrDataAction("A");

    // Set the ROWCCMN04SIG04
    row4.setUlIdUnitEmpLink(0);
    row4.setSzCdUnitMemberInOut("IN"); // Constant
    row4.setSzCdUnitMemberRole(ContextHelper.getStringSafe(context, "cboSzCdUnitMemberRole"));
    row4.setUlIdUnit(ulIdUnit);

    // Set the ROWCCMN04SIG05
    row5.setSzCdPersonIdType("SSN"); // Constant
    row5.setUlIdPersonId(0); // Constant
    row5.setSzDescPersonID(""); // Constant
    row5.setBIndPersonIDInvalid("N"); // Constant
    row5.setSzNbrPersonIdNumber(ContextHelper.getSSNSafe(context, "txtSzSysTxtGenericSSN"));
    row5.setDtPersonIDStart(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDtJobHire")));

    // Set the ROWCCMN04SIG06
    row6.setCCdPersonSex(ContextHelper.getStringSafe(context, "cbocCdPersonSex"));
    //row6.setDtDtPersonBirth(DateHelper.toCastorDateSafe(ContextHelper.getStringSafe(context, "txtDateBirth")));
    row6.setSzNmPersonFull(nameFull);

    /*
     * Populate for Race Ethnicity
     */
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    // SIR 17612 - fix person ethnicity group
    row6.setSzCdPersonEthnicGroup(RaceEthnicityHelper.getRaceEthnicityGroup(reBean, request));

    ROWCCMN05SIG08_ARRAY raceArray = new ROWCCMN05SIG08_ARRAY();
    ROWCCMN05SIG09_ARRAY ethArray = new ROWCCMN05SIG09_ARRAY();

    RaceEthnicityBean.Races races = reBean.getRaces();

    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
      ROWCCMN05SIG08 raceRow = new ROWCCMN05SIG08();
      raceRow.setSzCdPersonRace(race.getValue());
      raceRow.setSzCdScrDataAction(race.getActionCode());
      raceArray.addROWCCMN05SIG08(raceRow);
    }

    // If the old ethnicity is equivalant to the new ethnicity no need to
    // resave the information. If they are not equal, Add the new Eth.
    // The DAM automatically deletes the old eth.
    String ethnicity = reBean.getEthnicity();
    if (!ethnicity.equals(reBean.getOldEthnicity())) {
      ROWCCMN05SIG09 ethRow = new ROWCCMN05SIG09();
      ethRow.setSzCdPersonEthnicity(ethnicity);
      ethRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      ethArray.addROWCCMN05SIG09(ethRow);

      // ** DWW: 05/06/2003
      // ** SIRs 16675, 16868
      // ** changed to only add one ethnicity, not add new and delete the old.

      // ethRow = new ROWCCMN05SIG09();
      // ethRow.setSzCdPersonEthnicity( reBean.getOldEthnicity() );
      // ethRow.setSzCdScrDataAction( WtcHelper.REQ_FUNC_CD_DELETE );
      // ethArray.addROWCCMN05SIG09( ethRow );
    }

    // Set the rows into the ccmn05si object
    ccmn05si.setROWCCMN05SIG00(row0);
    ccmn05si.setROWCCMN05SIG01(row1);
    ccmn05si.setROWCCMN05SIG02(jobHistory);
    ccmn05si.setROWCCMN05SIG04(row4);
    ccmn05si.setROWCCMN05SIG05(row5);
    ccmn05si.setROWCCMN05SIG06(row6);
    ccmn05si.setROWCCMN05SIG08_ARRAY(raceArray);
    ccmn05si.setROWCCMN05SIG09_ARRAY(ethArray);
    ccmn05si.setArchInputStruct(archInputStruct);

    return ccmn05si;
  }

  /**
   * The populateUlIdUnit populates the UnitId based on Program, Unit and Region.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccmn08so
   */
  private CCMN08SO populateUlIdUnit(GrndsExchangeContext context) throws ServiceException {
    UserProfile user = UserProfileHelper.getUserProfile(context);

    // Call CCMN08SI to get the ulIdUnit for the populateCCMN05SI_Add
    //CCMN08SO ccmn08so = new CCMN08SO();
    CCMN08SI ccmn08si = new CCMN08SI();
    ArchInputStruct unitInput = new ArchInputStruct();

    // Set the values for the ArchInputStruct
    unitInput.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    unitInput.setBPerfInd("Y");
    unitInput.setBDataAcsInd("Y");
    unitInput.setUsPageNbr(1);
    unitInput.setUlPageSizeNbr(50);
    unitInput.setSzUserId(user.getUserLogonID());

    ccmn08si.setArchInputStruct(unitInput);
    ccmn08si.setSzCdCounty(ContextHelper.getStringSafe(context, "cboSzCdCounty"));
    ccmn08si.setSzCdUnitRegion(ContextHelper.getStringSafe(context, "cboSzCdUnitRegion"));
    ccmn08si.setSzNbrUnit(ContextHelper.getStringSafe(context, "txtSzNbrUnit").toUpperCase());

    //try {
      // call the Tuxedo service using the WtcHelper object

    CCMN08SO ccmn08so = admin.findUnitSupervisorName(ccmn08si);
      
    //} catch (ServiceException we) {
    //  throw we;
    //}
      /*
      // switch the response based on the Service Returned Error Code
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_INVALID_UNIT:
        //String invalidUnit = MessageLookup.getMessageByNumber(Messages.MSG_CMN_INVALID_UNIT);
        //setErrorMessage(invalidUnit, "/admin/StaffSearch/displayStaffDetail", context.getRequest());
        setErrorMessage(errorCode, context.getRequest());
        //setPresentationBranch("error", context);
        break;

      // This handles any bad uncaught exceptions
      default:
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
    */

    return ccmn08so;
  }

  /**
   * This method is called when the hyperlink for job history is clicked.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   * @return ccmn05si
   */
  private CCMN05SI copyCCMN04STOCCMN05S(GrndsExchangeContext context) throws ServiceException {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    BaseSessionStateManager state = getSessionStateManager(context);

    CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

    // Allocate the structures
    ArchInputStruct input = new ArchInputStruct();
    CCMN05SI ccmn05si = new CCMN05SI();

    // Set the values for the ArchInputStruct
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");
    input.setUsPageNbr(1);
    input.setUlPageSizeNbr(50);
    input.setSzUserId(user.getUserLogonID());

    ccmn05si.setArchInputStruct(input);

    ccmn05si.setUlIdPerson(GlobalData.getUlIdPerson(request));

    String oldFirst = ccmn04so.getROWCCMN04SOG01().getSzNmNameFirst();
    String oldMiddle = ccmn04so.getROWCCMN04SOG01().getSzNmNameMiddle();
    String oldLast = ccmn04so.getROWCCMN04SOG01().getSzNmNameLast();
    String oldName = FormattingHelper.formatFullName(oldFirst, oldMiddle, oldLast);

    ccmn05si.setSzNmPersonFull(oldName);

    // Use the Unit, Program and Region to retrieve the ulIdUnit for the
    // ROWCCMN04SIG04 And for the Supervisor ID and Name
    int supervisorId;
    String supervisorName;
    CCMN08SO ccmn08so = populateUlIdUnit(context);
    supervisorId = ccmn08so.getUlIdPerson();
    supervisorName = ccmn08so.getSzNmPersonFull();
    // int ulIdUnit = ccmn08so.getUlIdUnit();

    request.setAttribute("supervisorName", supervisorName);
    request.setAttribute("supervisorId", String.valueOf(supervisorId));

    ROWCCMN05SIG00 row0 = new ROWCCMN05SIG00();
    ROWCCMN05SIG01 row1 = new ROWCCMN05SIG01();

    // No need to populate job history row here. It will be populated when the
    // job history detail page is saved.
    // ROWCCMN05SIG02 jobHistory = populateJobHistory( context, WtcHelper.REQ_FUNC_CD_UPDATE, supervisorId );
    // ROWCCMN05SIG02_ARRAY jobHistoryArray = new ROWCCMN05SIG02_ARRAY();
    // jobHistoryArray.addROWCCMN05SIG02( jobHistory );

    ROWCCMN05SIG04 row4 = new ROWCCMN05SIG04();
    ROWCCMN05SIG05 row5 = new ROWCCMN05SIG05();
    ROWCCMN05SIG06 row6 = new ROWCCMN05SIG06();

    // Copy the ROWCCMN04SIG00
    row0.setSzCdEmpProgram(ccmn04so.getROWCCMN04SOG00().getSzCdEmpProgram());
    row0.setSzCdEmployeeClass(ccmn04so.getROWCCMN04SOG00().getSzCdEmployeeClass());
    row0.setLNbrEmpActivePct(ccmn04so.getROWCCMN04SOG00().getLNbrEmpActivePct());
    row0.setDtDtEmpHire(ccmn04so.getROWCCMN04SOG00().getDtDtEmpHire());
    row0.setUlIdEmpJobHistory(ccmn04so.getROWCCMN04SOG00().getUlIdEmpJobHistory());
    row0.setSzIdEmployeeLogon(ccmn04so.getROWCCMN04SOG00().getSzIdEmployeeLogon());
    row0.setDtDtEmpLastAssigned(ccmn04so.getROWCCMN04SOG00().getDtDtEmpLastAssigned());
    row0.setBIndEmpPendingHrmis(ccmn04so.getROWCCMN04SOG00().getBIndEmpPendingHrmis());
    row0.setBIndEmpConfirmedHrmis(ccmn04so.getROWCCMN04SOG00().getBIndEmpConfirmedHrmis());
    row0.setBIndActiveStatus(ccmn04so.getROWCCMN04SOG00().getBIndActiveStatus());
    row0.setSzNmEmpEmailAddr(ccmn04so.getROWCCMN04SOG00().getSzNmEmpEmailAddr());
    row0.setUlIdOffice(ccmn04so.getROWCCMN04SOG00().getUlIdOffice());

    row0.setDtDtEmpTermination(ContextHelper.getCastorDateSafe(context, "txtDtJobTerm"));

    row0.setTsLastUpdate(ccmn04so.getROWCCMN04SOG00().getTsLastUpdate());

    // Copy the ROWCCMN04SIG01
    row1.setDtDtNameStartDate(ccmn04so.getROWCCMN04SOG01().getDtDtNameStartDate());
    row1.setUlIdName(ccmn04so.getROWCCMN04SOG01().getUlIdName());
    row1.setBIndNameInvalid(ccmn04so.getROWCCMN04SOG01().getBIndNameInvalid());
    row1.setBIndNamePrimary(ccmn04so.getROWCCMN04SOG01().getBIndNamePrimary());
    row1.setSzNmNameFirst(ccmn04so.getROWCCMN04SOG01().getSzNmNameFirst());
    row1.setSzNmNameMiddle(ccmn04so.getROWCCMN04SOG01().getSzNmNameMiddle());
    row1.setSzNmNameLast(ccmn04so.getROWCCMN04SOG01().getSzNmNameLast());
    row1.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_NO_ACTION);
    row1.setTsLastUpdate(ccmn04so.getROWCCMN04SOG01().getTsLastUpdate());

    // Copy the ROWCCMN04SIG04
    row4.setUlIdUnitEmpLink(ccmn04so.getROWCCMN04SOG04().getUlIdUnitEmpLink());
    row4.setSzCdUnitMemberInOut(ccmn04so.getROWCCMN04SOG04().getSzCdUnitMemberInOut());
    row4.setSzCdUnitMemberRole(ccmn04so.getROWCCMN04SOG04().getSzCdUnitMemberRole());
    row4.setUlIdUnit(ccmn04so.getROWCCMN04SOG04().getUlIdUnit());
    row4.setTsLastUpdate(ccmn04so.getROWCCMN04SOG04().getTsLastUpdate());

    // Copy the ROWCCMN04SIG05
    row5.setSzCdPersonIdType(ccmn04so.getROWCCMN04SOG05().getSzCdPersonIdType());
    row5.setUlIdPersonId(ccmn04so.getROWCCMN04SOG05().getUlIdPersonId());
    row5.setSzDescPersonID(ccmn04so.getROWCCMN04SOG05().getSzDescPersonID());
    row5.setBIndPersonIDInvalid(ccmn04so.getROWCCMN04SOG05().getBIndPersonIDInvalid());
    row5.setSzNbrPersonIdNumber(ccmn04so.getROWCCMN04SOG05().getSzNbrPersonIdNumber());
    row5.setDtPersonIDStart(ccmn04so.getROWCCMN04SOG05().getDtPersonIDStart());
    row5.setTsLastUpdate(ccmn04so.getROWCCMN04SOG05().getTsLastUpdate());

    // Copy the ROWCCMN04SIG06
    row6.setCCdPersonSex(ccmn04so.getROWCCMN04SOG06().getCCdPersonSex());
    row6.setDtDtPersonBirth(ccmn04so.getROWCCMN04SOG06().getDtDtPersonBirth());
    row6.setSzCdPersonEthnicGroup(ccmn04so.getROWCCMN04SOG06().getSzCdPersonEthnicGroup());
    row6.setSzNmPersonFull(ccmn04so.getROWCCMN04SOG06().getSzNmPersonFull());
    row6.setTsLastUpdate(ccmn04so.getROWCCMN04SOG06().getTsLastUpdate());

    /*
     * Populate for Race Ethnicity
     */
    RaceEthnicityBean reBean = RaceEthnicityHelper.getFromRequest(request);
    ROWCCMN05SIG08_ARRAY raceArray = new ROWCCMN05SIG08_ARRAY();
    ROWCCMN05SIG09_ARRAY ethArray = new ROWCCMN05SIG09_ARRAY();

    RaceEthnicityBean.Races races = reBean.getRaces();

    while (races.hasNext()) {
      RaceEthnicityBean.Race race = races.next();
      ROWCCMN05SIG08 raceRow = new ROWCCMN05SIG08();
      raceRow.setSzCdPersonRace(race.getValue());
      raceRow.setSzCdScrDataAction(race.getActionCode());
      raceArray.addROWCCMN05SIG08(raceRow);
    }

    // If the old ethnicity is equivalant to the new ethnicity no need to
    // resave the information. If they are not equal, Add the new Eth.
    // The DAM automatically deletes the old eth.
    String ethnicity = reBean.getEthnicity();
    if (!ethnicity.equals(reBean.getOldEthnicity())) {
      ROWCCMN05SIG09 ethRow = new ROWCCMN05SIG09();
      ethRow.setSzCdPersonEthnicity(ethnicity);
      ethRow.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      ethArray.addROWCCMN05SIG09(ethRow);

      // ** DWW: 05/06/2003
      // ** SIRs 16675, 16868
      // ** changed to only add one ethnicity, not add new and delete the old.

      // ethRow = new ROWCCMN05SIG09();
      // ethRow.setSzCdPersonEthnicity( reBean.getOldEthnicity() );
      // ethRow.setSzCdScrDataAction( WtcHelper.REQ_FUNC_CD_DELETE );
      // ethArray.addROWCCMN05SIG09( ethRow );
    }

    // Set the rows into the ccmn05si object
    ccmn05si.setROWCCMN05SIG00(row0);
    ccmn05si.setROWCCMN05SIG01(row1);
    // ccmn05si.setROWCCMN05SIG02_ARRAY( jobHistoryArray );
    ccmn05si.setROWCCMN05SIG04(row4);
    ccmn05si.setROWCCMN05SIG05(row5);
    ccmn05si.setROWCCMN05SIG06(row6);
    ccmn05si.setROWCCMN05SIG08_ARRAY(raceArray);
    ccmn05si.setROWCCMN05SIG09_ARRAY(ethArray);

    return ccmn05si;
  }

  // Static variables
  public static final int SEARCH_RESULTS_PER_PAGE = 50;

  public static final String TRACE_TAG = "StaffSearchConversation";

  public static final String personID = "txtUlIdPerson";

  public static final String personSSN = "txtSzSysTxtGenericSSN";

  public static final String DISPLAY_PAGE = "/admin/StaffSearch/displayStaffDetail";

  private Admin admin;

}
