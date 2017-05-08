package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN20DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN22DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SzCdOnCallCounty_ARRAY_CCMN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMNA1SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlPageSizeNbr_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UsPageNbr_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH7SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN16DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN21DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * OnCallConversation <p/>
 * <p/>
 * <pre>
 *    Description:
 *    Contains the business logic methods for handling On-Call shifts and blocks.
 *    &lt;p/&gt;
 *    Change History:
 *    Date      User            Description
 *    --------  --------------  --------------------------------------------------
 *    09/30/03  Merle A Demo    SIR19889 OnCall schedule caused IndexArrayOutOfBounds
 *                              exception, added control veriable arrayEmpOnCallFull
 *                              to disable the 'Add' button when 9 people are in
 *                              the ccmn22di_array in the .jsp. Also changed the
 *                              size of the array from 9 to 18 in the .xds  9 delete
 *                              rows and 9 add rows.  The changes here are to stop
 *                              the user from adding more than 9 rows by adding a
 *                              group that put the array over 9.
 *    03/04/04  RIOSJA          SIR 22742 - Use ID_EMP_ON_CALL_LINK, not just
 *                              ID_PERSON, to distinguish unique rows in the
 *                              Employees list when adding/updating/deleting
 *                              employees.
 *    05/28/04  RIOSJA          SIR 18871 - Retrieve phone extension also when
 *                              getting On-Call Employee Details from Person Search
 *                              pullback.
 *    06/10/04  Dickmaec        SIR 15168 - The On-Call Report can be run with
 *                              multiple counites selected.  Previously a user could
 *                              only run the report with one County selected.
 *                              A String buffer was created to hold the multiple county
 *                              searches.  The SQR is a little picking on how the parameters
 *                              need to be passed to over.   For example the selectedCountiesString
 *                              string buffer format will be in the following format '009 018 027'.
 *                              The last space is trimed off before it is passed to the jsp
 *                              and then to the SQR report.
 *    09/01/04 dickmaec         SIR 23134 - Allows the page to search the region type of 'Statewide'
 *    10/04/04 dickmaec         SIR 23185 - Fixed the Next Hyperlink with the pagination.
 *    05/09/05 NALLAVS          SIR 23547 - Removed System.out.println statements.
 *    08/25/05 mkw              SIR 23935 - Updated to reflect coding standards and fix compile error due to * imports.
 * </pre>
 *
 * @author Jason Rios, December 9, 2002
 */
public class OnCallConversation extends BaseHiddenFieldStateConversation {
  // Declare static constants
  public static final String TRACE_TAG = "OnCallConversation";

  public static final String SEARCH_PAGE = "/workload/OnCall/displayOnCallSearch";

  public static final String DETAIL_PAGE = "/workload/OnCall/displayOnCallDetail";

  public static final int SEARCH_RESULTS_PER_PAGE = 50;

  public static final int INITIAL_PAGE = 1;

  // Sir19889
  public static final int INT_MAX_ON_CALL_EMPLOYEES = 9;

  public static final String ERROR_STRING = "error";

  public static final String ALL_COUNTIES_COUNTY_CODE = "255";

  public static final String ALL_COUNTIES_COUNTY_DECODE = "ALL";

  public static final String MULTIPLE_COUNTIES_CODE = "256";

  public static final String MULTIPLE_COUNTIES_DECODE = "MULT";

  public static final String SCHEDULE_FILLED = "Y";

  public static final String SCHEDULE_NOT_FILLED = "N";

  public static final String ADD = "A";

  public static final String UPDATE = "U";

  public static final String DELETE = "D";

  public static final String ON_CALL_SEARCH_PAGE = "OnCallSearch";

  public static final String ON_CALL_DETAIL_PAGE = "OnCallDetail";

  public static final String ON_CALL_CONVERSATION_URL = "/workload/OnCall/";

  public static final String CCMN06SO_DETAIL = "CCMN06SO_DETAIL";

  public static final String CCMN06SO_LIST = "CCMN06SO_LIST";

  public static final String CCMN09SO_DETAIL = "CCMN09SO_DETAIL";

  public static final String CCMN09SO_LIST = "CCMN09SO_LIST";

  public static final String CCMN10SI = "CCMN10SI";

  public static final String SELETED_COUNTIES_VECTOR = "selectedCountiesVector";

  public static final String PERFORMED_STAFF_SEARCH = "performedStaffSearch";

  public static final String SEL_SZCD_ONCALL_PROG = "selSzCdOnCallProgram";

  public static final String SEL_SZCD_ONCALL_TYP = "selSzCdOnCallType";

  public static final String TXT_DT_ONCALL_START = "txtDtDtOnCallStart";

  public static final String TXT_TM_ONCALL_START = "txtTmOnCallStart";

  public static final String TXT_DT_ONCALL_END = "txtDtDtOnCallEnd";

  public static final String TXT_TM_ONCALL_END = "txtTmOnCallEnd";

  public static final String SEL_SZCD_REGION = "txtRegion";

  public static final String SEL_SZCD_COUNTY = "selSzCdCounty";

  public static final String HDN_ID_PERSON = "hdnUlIdPerson";

  public static final String HDN_ID_EMP_ON_CALL_LINK = "hdnUlIdEmpOnCallLink";

  public static final String TXT_NM_PERSON_FULL = "szNmPersonFull";

  public static final String TXT_TITLE = "txtSzTitle";

  public static final String TXT_EMP_ONCALL_PHONE1 = "txtSzNbrEmpOnCallPhone1";

  public static final String TXT_EMP_ONCALL_PHONE2 = "txtSzNbrEmpOnCallPhone2";

  public static final String TXT_EMP_ONCALL_EXT1 = "txtLNbrEmpOnCallExt1";

  public static final String TXT_EMP_ONCALL_EXT2 = "txtLNbrEmpOnCallExt2";

  public static final String HDN_EMP_HOME_PHONE = "hdnSzNbrEmpHomePhone";

  public static final String SEL_ONCALL_DESIG = "selSzCdEmpOnCallDesig";

  public static final String SZ_CD_ON_CALL_PROGRAM = "szCdOnCallProgram";

  public static final String SZ_CD_TITLE = "szCdTitle";

  public static final String SEL_ONCALL_PROGRAM = "selSzCdEmpOnCallProgram";

  public static final String TXT_EMP_ONCALL_CONTACT_ORD = "txtUsNbrEmpOnCallCntctOrd";

  private static final String SELECTED_EMPLOYEE_STRING = "selectedEmployeeIndex_CLEAN";

  private static final String GENERAL_FAILURE = "General Failure: ";

  private static final String ON_CALL_DETAIL_PAGE_MODE = "onCallDetailPageMode";

  private static final String ON_CALL_EMPLOYEE_DETAIL_PAGE_MODE = "onCallEmployeeDetailPageMode";

  private Admin admin = null;

  private Person person = null;

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  /**
   * Displays the On-Call Search page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void displayOnCallSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayOnCallSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    try {
      // The hidden state field should be cleared at the beginning of all
      // conversations.
      state.removeAllAttributes(request);

      // Determine the PageMode based on the user's security privileges.
      String pageMode = PageModeConstants.VIEW;
      if (user.hasRight(UserProfile.SEC_MNTN_ON_CALL)) {
        pageMode = PageModeConstants.EDIT;
      }
      PageMode.setPageMode(pageMode, request);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Displays the On-Call Detail page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void displayOnCallDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayOnCallDetail_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Set the PageMode to the value specified by the JSP.
      if (!PageMode.getPageMode(request).equals(PageModeConstants.VIEW)) {
        PageMode.setPageMode(ContextHelper.getStringSafe(request, "pageMode"), request);
      }

      String origin = ContextHelper.getStringSafe(request, "pageName");
      if (origin.equals(ON_CALL_SEARCH_PAGE)) {
        int onCallId = ContextHelper.getIntSafe(request, "rbUlIdOnCall");
        state.setAttribute("ulIdOnCall", onCallId, request);

        // Loop through the list of On-Call schedules. Find the schedule that was
        // selected by the user. Then create another CCMN06SO object that will
        // contain only that schedule. Put it into state. This object will be
        // used to keep track of the details of the selected on-call schedule.
        CCMN06SO selectedSchedule = new CCMN06SO();
        CCMN06SO ccmn06so = (CCMN06SO) state.getAttribute(CCMN06SO_LIST, request);
        ROWCCMN16DO schedule;
        Enumeration enumeration = ccmn06so.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();
        while (enumeration.hasMoreElements()) {
          schedule = (ROWCCMN16DO) enumeration.nextElement();
          if (schedule.getUlIdOnCall() == onCallId) {
            ROWCCMN16DO copyOfSchedule = new ROWCCMN16DO();
            copyOfSchedule.setBIndOnCallFilled(schedule.getBIndOnCallFilled());
            copyOfSchedule.setDtDtOnCallEnd(schedule.getDtDtOnCallEnd());
            copyOfSchedule.setDtDtOnCallStart(schedule.getDtDtOnCallStart());
            copyOfSchedule.setSzCdOnCallProgram(schedule.getSzCdOnCallProgram());
            copyOfSchedule.setSzCdOnCallType(schedule.getSzCdOnCallType());
            copyOfSchedule.setSzCdRegion(schedule.getSzCdRegion());
            copyOfSchedule.setTmOnCallEnd(schedule.getTmOnCallEnd());
            copyOfSchedule.setTmOnCallStart(schedule.getTmOnCallStart());
            copyOfSchedule.setTsLastUpdate(schedule.getTsLastUpdate());
            copyOfSchedule.setUlCountOfCounty(schedule.getUlCountOfCounty());
            copyOfSchedule.setUlIdOnCall(schedule.getUlIdOnCall());

            ROWCCMN16DO_ARRAY rowccmn16do_array = new ROWCCMN16DO_ARRAY();
            rowccmn16do_array.addROWCCMN16DO(0, copyOfSchedule);
            selectedSchedule.setROWCCMN16DO_ARRAY(rowccmn16do_array);
            state.setAttribute(CCMN06SO_DETAIL, selectedSchedule, request);
            break;
          }
        }

        // Find the counties to which the selected schedule applies. Create a
        // Vector of the county codes. If 'Statewide' is the selected region, then
        // skip this step since the schedule applies to all counties.
        String onCallRegion = selectedSchedule.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getSzCdRegion();
        if (!onCallRegion.equals(CodesTables.CREGIONS_98)) {
          // Set the pagination objects to the appropriate values for the call to
          // the On-Call Schedule County Retrieve service (CCMNH7S).
          UlPageSizeNbr_ARRAY pageSizeNbr = new UlPageSizeNbr_ARRAY();
          UsPageNbr_ARRAY pageNbr = new UsPageNbr_ARRAY();
          pageSizeNbr.addUlPageSizeNbr(SEARCH_RESULTS_PER_PAGE);
          pageNbr.addUsPageNbr(INITIAL_PAGE);

          // Call the On-Call Schedule County Retrieve service (CCMNH7S) to find
          // the counties to which the selected schedule applies.
          CCMNH7SI ccmnh7si = populateCCMNH7SI_Retrieve(onCallRegion, onCallId);
          ArchInputStruct input = new ArchInputStruct();
          input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());
          ccmnh7si.setArchInputStruct(input);
          ccmnh7si.setUlPageSizeNbr_ARRAY(pageSizeNbr);
          ccmnh7si.setUsPageNbr_ARRAY(pageNbr);

          CCMNH7SO ccmnh7so = admin.retrieveOnCallListCounty(ccmnh7si);

          // Iterate through the list of counties, and create a Vector of the
          // county codes. Put the vector into state.
          List selectedCountiesVector = new ArrayList();
          ROWCCMNH7DO county;
          enumeration = ccmnh7so.getROWCCMNH7DO_ARRAY().enumerateROWCCMNH7DO();
          while (enumeration.hasMoreElements()) {
            county = (ROWCCMNH7DO) enumeration.nextElement();
            selectedCountiesVector.add(county.getSzCdOnCallCounty());
            selectedSchedule.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).setSzCdOnCallCounty(county.getSzCdOnCallCounty());
          }
          state.setAttribute(SELETED_COUNTIES_VECTOR, selectedCountiesVector, request);
        }

        // Get the Employees assigned to this schedule. Put the resultset into
        // state.
        CCMN09SI ccmn09si = populateCCMN09SI_Retrieve(context, onCallId);
        CCMN09SO ccmn09so = person.findEmpOnCallInfo(ccmn09si);
        state.setAttribute(CCMN09SO_LIST, ccmn09so, request);

        // Copy the employee list from the retrieve service output object
        // (CCMN09SO) into the save service input object (CCMN10SI), and put the
        // input object into state. This object will be used to flag any changes
        // (i.e., adds, updates, deletes) to the employee list because only it
        // has the 'szCdScrDataAction' property that indicates whether the
        // employee was added, updated or deleted.
        CCMN10SI ccmn10si = copyCCMN09SOtoCCMN10SI(ccmn09so, context);
        state.setAttribute(CCMN10SI, ccmn10si, request);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Displays the On-Call Employee Detail page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void displayOnCallEmployee_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayOnCallEmployee_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      CCMN09SO ccmn09so_detail = new CCMN09SO();
      ROWCCMN21DO_ARRAY rowccmn21do_array = new ROWCCMN21DO_ARRAY();

      // Clear the indicator from state that indicates that a Staff Search was
      // performed because we don't yet know whether this method was called by
      // the Staff Search page or the On-Call Detail page.
      state.removeAttribute(PERFORMED_STAFF_SEARCH, request);

      // This method was called either by the Staff Search page after the user
      // performed a staff search and selected person(s) from the list (if), or
      // it was called by the On-Call Detail page because the user clicked an
      // employee hyperlink (else).
      if (request.getAttribute(StaffSearchInput.STAFF_PULL_BACK) != null) {
        // Put an indicator into state to let the On-Call Employee Detail page
        // know that a Staff Search was performed.
        state.setAttribute(PERFORMED_STAFF_SEARCH, true, request);

        // Restore the value of the On-Call Employee Detail page PageMode.
        String originalOnCallEmployeeDetailPageMode = (String) state.getAttribute(ON_CALL_EMPLOYEE_DETAIL_PAGE_MODE,
                                                                                  request);
        PageMode.setPageMode(originalOnCallEmployeeDetailPageMode, request);

        // Get the object returned by Staff Search containing the selected
        // staff person(s) info, and put the info into an employee object that
        // will be used by the On-Call Employee Detail page.
        ROWCCMN50DO_ARRAY staffSearch_array = (ROWCCMN50DO_ARRAY) request
                .getAttribute(StaffSearchInput.STAFF_PULL_BACK);

        Enumeration enumeration = staffSearch_array.enumerateROWCCMN50DO();
        while (enumeration.hasMoreElements()) {
          ROWCCMN50DO staffSearchEmployee = (ROWCCMN50DO) enumeration.nextElement();

          ROWCCMN21DO employee = new ROWCCMN21DO();
          employee.setUlIdPerson(staffSearchEmployee.getUlIdPerson());
          employee.setSzNmPersonFull(staffSearchEmployee.getSzNmPersonFull());
          employee.setLNbrPhone(staffSearchEmployee.getLSysNbrPersPhnHome());
          employee.setSzCdTitle(Lookup.simpleDecodeSafe("CTITLEA", staffSearchEmployee.getSzCdEmployeeClass()));
          employee.setSzCdOnCallProgram(staffSearchEmployee.getSzCdEmpProgram());

          // Call the On-Call Phone retrieve service to retrieve the employee's
          // on-call phone, business pager and business phone, if they exist. The
          // numbers will be retrieved in that order.
          try {
            CCMNA1SI ccmna1si = populateCCMNA1SI_Retrieve(context, staffSearchEmployee.getUlIdPerson());
            // CCMNA1SO ccmna1so = CCMNA1SO.unmarshal(new StringReader(WtcHelper.callService("CCMNA1S", ccmna1si)));
            CCMNA1SO ccmna1so = admin.retrieveOnCallPhone(ccmna1si);

            // If any one of the three numbers listed above was found, then use
            // that number as the default on-call phone number for this employee;
            // otherwise, use the business phone and extension retrieved by the
            // Staff Search pullback.
            LNbrPhone_ARRAY lNbrPhoneArray = ccmna1so.getLNbrPhone_ARRAY();
            int size = lNbrPhoneArray.getLNbrPhoneCount();
            if ((size > 0) && ccmna1so.getLNbrPhone_ARRAY().getLNbrPhone(0) != null) {
              employee.setSzNbrEmpOnCallPhone1(ccmna1so.getLNbrPhone_ARRAY().getLNbrPhone(0));
              // RIOSJA, SIR 18871 - Retrieve phone extension also.
              employee.setLNbrEmpOnCallExt1(ccmna1so.getLNbrPhone_ARRAY().getLNbrPhoneExtension(0));
            } else {
              employee.setSzNbrEmpOnCallPhone1(staffSearchEmployee.getLSysNbrPersPhoneWork());
              employee.setLNbrEmpOnCallExt1(staffSearchEmployee.getLNbrPhoneExtension());
            }
          } // end try
          catch (ServiceException we) {
            // If no rows were found, then set the on-call phone to the business
            // phone retrieved by the staff search pullback.
            if (we.getErrorCode() == Messages.MSG_NO_ROWS_RETURNED) {
              employee.setSzNbrEmpOnCallPhone1(staffSearchEmployee.getLSysNbrPersPhoneWork());
              employee.setLNbrEmpOnCallExt1(staffSearchEmployee.getLNbrPhoneExtension());
            } else {
              throw we;
            }
          } // end catch( ServiceException we )
          // rowccmn21do_array.addROWCCMN21DO( 0, employee );
          rowccmn21do_array.addROWCCMN21DO(employee);
        } // end while( enumeration.hasMoreElements() )
        ccmn09so_detail.setROWCCMN21DO_ARRAY(rowccmn21do_array);
        state.setAttribute(CCMN09SO_DETAIL, ccmn09so_detail, request);
      } // end if( request.getAttribute( StaffSearchConversation.STAFF_PULL_BACK ) != null )
      else {
        putOnCallParamsIntoState(context);

        // Find the selected employee in the employees object that is in state,
        // create a second object with just that employee, and put the new
        // object in state.
        ccmn09so_detail.setROWCCMN21DO_ARRAY(rowccmn21do_array);
        int selectedEmployeeIndex = ContextHelper.getIntSafe(request, SELECTED_EMPLOYEE_STRING);
        state.setAttribute(SELECTED_EMPLOYEE_STRING, selectedEmployeeIndex, request);
        CCMN09SO ccmn09so_list = (CCMN09SO) state.getAttribute(CCMN09SO_LIST, request);
        ROWCCMN21DO selectedEmployee = ccmn09so_list.getROWCCMN21DO_ARRAY().getROWCCMN21DO(selectedEmployeeIndex);
        ccmn09so_detail.getROWCCMN21DO_ARRAY().addROWCCMN21DO(0, selectedEmployee);
        ccmn09so_detail.getROWCCMN21DO_ARRAY().setUlRowQty(1);
        state.setAttribute(CCMN09SO_DETAIL, ccmn09so_detail, request);
      } // end if( request.getAttribute( StaffSearchConversation.STAFF_PULL_BACK ) != null )

      // Put the employee's name and person id into GlobalData so that it can
      // be used to populate the "Info Box" on the Phone Detail page if the
      // user navigates there.
      GlobalData.setSzNmPersonFull(ccmn09so_detail.getROWCCMN21DO_ARRAY().getROWCCMN21DO(0).getSzNmPersonFull(),
                                   request);
      GlobalData.setUlIdPerson(ccmn09so_detail.getROWCCMN21DO_ARRAY().getROWCCMN21DO(0).getUlIdPerson(), request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Searches the database for On-Call blocks and shifts that match the specified search criteria.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void searchOnCallSchedules_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".searchOnCallSchedules_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCMN06SI ccmn06si;
    CCMN06SO ccmn06so = null;

    try {
      // Save the search params for later use.
      String buttonPressed = ContextHelper.getStringSafe(request, "buttonPressed");
      if (buttonPressed.equals(OnCallCustomValidation.SEARCH_BUTTON)
          || buttonPressed.equals(OnCallCustomValidation.SAVE_BUTTON)) {
        putOnCallParamsIntoState(context);
      }

      // Set the pagination objects to the appropriate values for the call to
      // the On-Call Schedule Search service (CCMN06S)
      TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, tuxPagination);
      tuxPagination.getResultDetails().setResultsPerPage(SEARCH_RESULTS_PER_PAGE);
      ArchInputStruct input = new ArchInputStruct();
      input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());
      input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
      // input.setUlPageSizeNbr(250);
      // input.setUsPageNbr(1);
      input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());

      // Call the On-Call Schedule Search service to retrieve all schedules that
      // match the search params. Catch a "No rows returned" exception if it
      // occurs, and put an appropriate message into the request.
      try {
        ccmn06si = populateCCMN06SI_Search(context);
        ccmn06si.setArchInputStruct(input);
        ccmn06so = admin.findOnCallList(ccmn06si);
      } catch (ServiceException we) {
        if (we.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED
            && !buttonPressed.equals(OnCallCustomValidation.DELETE_BUTTON_ON_SEARCH_PAGE)) {
          throw we;
        }
      }

      // Put the output object into state. If rows were returned by the service,
      // then also put the pagination information into the request, and continue
      // with normal processing.
      state.setAttribute(CCMN06SO_LIST, ccmn06so, request);

      request.setAttribute("bSearchPerformed", true);

      if (ccmn06so != null) {
        ArchOutputStruct archOutputStruct = new ArchOutputStruct();
        archOutputStruct.setBMoreDataInd(ccmn06so.getArchOutputStruct().getBMoreDataInd());
        ccmn06so.setArchOutputStruct(archOutputStruct);
      }

      if (ccmn06so != null) {
        tuxPagination.setPaginationInformation(ccmn06so.getArchOutputStruct(), ccmn06so.getROWCCMN16DO_ARRAY().getROWCCMN16DOCount());
        storePaginationBeanToRequest(context, tuxPagination);

        // Create a "Schedule-to-Counties" HashMap that maps each On-Call
        // schedule to the county/counties to which it applies.
        Map scheduleToCountiesHashMap = new HashMap();
        scheduleToCountiesHashMap = buildScheduleToCountiesHashmap(context, ccmn06so, scheduleToCountiesHashMap);
        state.setAttribute("scheduleToCountiesHashMap", scheduleToCountiesHashMap, request);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Takes the user to the On-Call Detail page in NEW PageMode.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void addOnCallSchedule_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addOnCallSchedule_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // In case the user performed any searches prior to clicking the 'Add'
      // button, clear the search parameter fields from state so that the fields
      // in the Schedule Information section of the On-Call Detail page will
      // be empty by default. Also remove CCMN06SO_DETAIL, CCMN09SO_LIST and
      // CCMN09SO_DETAIL from state since they contain data for the previously
      // selected shift/block.
      state.removeAttribute(SEL_SZCD_ONCALL_PROG, request);
      state.removeAttribute(SEL_SZCD_ONCALL_TYP, request);
      state.removeAttribute(TXT_DT_ONCALL_START, request);
      state.removeAttribute(TXT_TM_ONCALL_START, request);
      state.removeAttribute(TXT_DT_ONCALL_END, request);
      state.removeAttribute(TXT_TM_ONCALL_END, request);
      state.removeAttribute(SEL_SZCD_REGION, request);
      state.removeAttribute(SELETED_COUNTIES_VECTOR, request);
      state.removeAttribute(CCMN06SO_DETAIL, request);
      state.removeAttribute(CCMN09SO_LIST, request);
      state.removeAttribute(CCMN09SO_DETAIL, request);

      // SIR 19589 - CCMN06SO_LIST is used to store info, so make sure it's not null
      if (state.getAttribute(CCMN06SO_LIST, request) == null) {
        CCMN06SO ccmn06so = new CCMN06SO();
        ccmn06so.setROWCCMN16DO_ARRAY(new ROWCCMN16DO_ARRAY());
        state.setAttribute(CCMN06SO_LIST, ccmn06so, request);
      }
      
      //Creates all of the counties and gets the matching regions to be put in a Hash map.  
      List<String> countyCodes = new ArrayList<String>(Lookup.getCategoryCodesCollection(CodesTables.CCNTYREG));
      Map<String, String> countyRegions = new HashMap<String, String>();
      for (int i = 0; i < countyCodes.size(); i++){
        String code = countyCodes.get(i);
        countyRegions.put(code, Lookup.simpleDecode(CodesTables.CCNTYREG, code));
      }
      state.setAttribute("countyRegionCodes", countyRegions, request);
      // PageMode will always be NEW.
      PageMode.setPageMode(PageModeConstants.NEW, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Saves or updates an On-Call block/shift. This activity method is called only by the On-Call Detail page. Two
   * different services are used by this method to save on-call data to the database. CCMN07S is the On-Call Schedule
   * AUD service. Is is used to insert or update schedule information. It is also used to delete an entire schedule from
   * the system, including the schedule's employee list. It is not used to insert, update or delete individual employees
   * from the employee list. CCMN10S is the On-Call Save service. It is used to insert a complete schedule, including
   * the employee list, if the PageMode is NEW_USING. It is also used to insert, update or delete individual employees
   * from the employee list. It is not used to update or delete schedule information.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void saveOnCallSchedule_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveOnCallSchedule_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCMN10SI ccmn10si;
    CCMN07SO ccmn07so = null;
    CCMN10SO ccmn10so = null;

    try {
        // If the PageMode is MODIFY, then call CCMN07S to save the updated
        // schedule information to the database.
      String pageMode = PageMode.getPageMode(request);
        if (PageModeConstants.MODIFY.equals(pageMode)) {
          // Call the service.
          CCMN07SI ccmn07si = populateCCMN07SI_AUD(context, UPDATE);
          // ccmn07so = CCMN07SO.unmarshal(new StringReader(WtcHelper.callService("CCMN07S", ccmn07si.toString(),
          // wth.getTuxedoConnection())));
          ccmn07so = admin.saveOnCallListInformation(ccmn07si);
        }

        // Call CCMN10S. If the PageMode is NEW or NEW_USING, the service will
        // save both the schedule details and the employee list. If the PageMode
        // is MODIFY, the service will save only the employee list.
        ccmn10si = populateCCMN10SI_Save(context);
        removeUnchangedEmployeesFromList(ccmn10si);
        ccmn10so = admin.saveOnCallDetailInformation(ccmn10si);

      // Whichever service saved the schedule details will have put a copy of
      // those details into the request under the name "savedSchedule". Get the
      // object so that it can be used to update the list of schedules that will
      // be displayed on the On-Call Search page.
      CCMN06SO ccmn06so_list = (CCMN06SO) state.getAttribute(CCMN06SO_LIST, request);
      ROWCCMN16DO scheduleToPutInList = new ROWCCMN16DO();
      //ROWCCMN20DI savedSchedule = (ROWCCMN20DI) request.getAttribute("savedSchedule");
      ROWCCMN20DI savedSchedule = ccmn10si.getROWCCMN20DI();
      scheduleToPutInList.setDtDtOnCallEnd(savedSchedule.getDtDtOnCallEnd());
      scheduleToPutInList.setDtDtOnCallStart(savedSchedule.getDtDtOnCallStart());
      scheduleToPutInList.setSzCdOnCallProgram(savedSchedule.getSzCdOnCallProgram());
      scheduleToPutInList.setSzCdOnCallType(savedSchedule.getSzCdOnCallType());
      scheduleToPutInList.setSzCdRegion(savedSchedule.getSzCdRegion());
      scheduleToPutInList.setTmOnCallEnd(savedSchedule.getTmOnCallEnd());
      scheduleToPutInList.setTmOnCallStart(savedSchedule.getTmOnCallStart());
      scheduleToPutInList.setUlCountOfCounty(savedSchedule.getCdCountyCounter());
      scheduleToPutInList.setSzCdOnCallCounty(savedSchedule.getSzCdOnCallCounty());
      //request.removeAttribute("savedSchedule");

      // If the schedule was newly added to the database, put it at the top of
      // the list to be displayed on the On-Call Search page. If the schedule
      // was updated, leave it in the same place in the list, just update the
      // details.
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)
          || PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
        
        scheduleToPutInList.setUlIdOnCall(ccmn10so.getROWCCMN20DO().getUlIdOnCall());
        scheduleToPutInList.setTsLastUpdate(ccmn10so.getROWCCMN20DO().getTsLastUpdate());
 
        
        ccmn06so_list.getROWCCMN16DO_ARRAY().addROWCCMN16DO(0, scheduleToPutInList);
        int numOfSchedulesInList = ccmn06so_list.getROWCCMN16DO_ARRAY().getUlRowQty();
        numOfSchedulesInList++;
        ccmn06so_list.getROWCCMN16DO_ARRAY().setUlRowQty(numOfSchedulesInList);
      } else {
        scheduleToPutInList.setUlIdOnCall(savedSchedule.getUlIdOnCall());
        scheduleToPutInList.setTsLastUpdate(ccmn07so.getROWCCMN20DO().getTsLastUpdate());
        int indexOfUpdatedScheduleInList = 0;
        Enumeration enumeration = ccmn06so_list.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();
        while (enumeration.hasMoreElements()) {
          ROWCCMN16DO schedule = (ROWCCMN16DO) enumeration.nextElement();
          if (schedule.getUlIdOnCall() == savedSchedule.getUlIdOnCall()) {
            break;
          }
          indexOfUpdatedScheduleInList++;
        }
        ccmn06so_list.getROWCCMN16DO_ARRAY().setROWCCMN16DO(indexOfUpdatedScheduleInList, scheduleToPutInList);
      }

      // Create a "Schedule-to-Counties" HashMap that maps each On-Call
      // schedule to the county/counties to which it applies.
      Map scheduleToCountiesHashMap = new HashMap();
      scheduleToCountiesHashMap = buildScheduleToCountiesHashmap(context, ccmn06so_list, scheduleToCountiesHashMap);
      state.setAttribute("scheduleToCountiesHashMap", scheduleToCountiesHashMap, request);

      // Set the PageMode to MODIFY after the save is successful in case it was
      // NEW or NEW_USING.
      PageMode.setPageMode(PageModeConstants.MODIFY, request);

      // Put an indicator into the request so that the On-Call Search page will
      // anchor down to the On-Call Schedule list.
      request.setAttribute("bSearchPerformed", true);

      // Since the data has been saved to the database, clear CCMN06SO_DETAIL,
      // CCMN09SO_DETAIL, CCMN09SO_LIST and CCMN10SI from state. CCMN06_LIST
      // should remain because it will be used to populate the On-Call Schedule
      // list.
      state.removeAttribute(CCMN06SO_DETAIL, request);
      state.removeAttribute(CCMN09SO_DETAIL, request);
      state.removeAttribute(CCMN09SO_LIST, request);
      state.removeAttribute(CCMN10SI, request);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Copies the employee details into the employee list objects (CCMN09SO_LIST and CCMN10SI) that are kept in state.
   * Employee details for all employees will be saved to the database by the saveScheduleOnDetailPage_xa activity method
   * when the user clicks the 'Save' button on the On-Call Detail page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void saveOnCallEmployee_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveOnCallEmployee_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    int ulIdOnCall;
    int hdnUlIdEmpOnCallLink;
    int hdnUlIdPerson;
    String szNmPersonFull;
    String txtSzNbrEmpOnCallPhone1;
    String txtSzNbrEmpOnCallPhone2;
    String txtLNbrEmpOnCallExt1;
    String txtLNbrEmpOnCallExt2;
    String hdnSzNbrEmpHomePhone;
    String selSzCdEmpOnCallDesig;
    int txtUsNbrEmpOnCallCntctOrd;
    String szCdTitle;
    String szCdOnCallProgram;

    try {
      // Since the employee details are being added to the employee object,
      // clear the indicator from state that indicates that a Staff Search was
      // performed.
      state.removeAttribute(PERFORMED_STAFF_SEARCH, request);

      // CCMN09SO_LIST is used for displaying the employee list on the On-Call
      // Detail page.
      CCMN09SO ccmn09so_list = (CCMN09SO) state.getAttribute(CCMN09SO_LIST, request);
      if (ccmn09so_list == null) {
        ccmn09so_list = new CCMN09SO();
        ROWCCMN21DO_ARRAY rowccmn21do_array = new ROWCCMN21DO_ARRAY();
        rowccmn21do_array.setUlRowQty(0);
        ccmn09so_list.setROWCCMN21DO_ARRAY(rowccmn21do_array);
      }

      // CCMN10SI is used for saving all updates to the employee list.
      CCMN10SI ccmn10si = (CCMN10SI) state.getAttribute(CCMN10SI, request);
      if (ccmn10si == null) {
        ccmn10si = new CCMN10SI();
        ROWCCMN22DI_ARRAY rowccmn22di_array = new ROWCCMN22DI_ARRAY();
        rowccmn22di_array.setUlRowQty(0);
        ccmn10si.setROWCCMN22DI_ARRAY(rowccmn22di_array);
      }

      // If the user selected an employee from the On-Call Detail page,
      // 'numOfEmployees' will be 1; otherwise 'numOfEmployees' will be the
      // number of employees selected from Staff Search.
      Integer SelectedEmployeeIndex = (Integer) state.getAttribute(SELECTED_EMPLOYEE_STRING, request);
      int numOfEmployees = ContextHelper.getIntSafe(request, "numOfEmployees");

      // SIR 19889 - 'if' added to make sure user does not try to add more than
      // 9 rows to the on call employee list.
      int numLeft;
      numLeft = INT_MAX_ON_CALL_EMPLOYEES - (ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty() + numOfEmployees);
      if (numLeft < 0 && !(INT_MAX_ON_CALL_EMPLOYEES == (ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty()))) {
        String linkMessage = MessageLookup.getMessageByNumber(Messages.MSG_OVER_ROW_LIMIT);
        linkMessage = MessageLookup
                .addMessageParameter(
                        linkMessage,
                        String
                                .valueOf((INT_MAX_ON_CALL_EMPLOYEES - ccmn09so_list
                                .getROWCCMN21DO_ARRAY()
                                .getUlRowQty())));
        setInformationalMessage(linkMessage, request);
      } else {
        for (int i = 0; i < numOfEmployees; i++) {
          hdnUlIdEmpOnCallLink = ContextHelper.getIntSafe(request, HDN_ID_EMP_ON_CALL_LINK + i); // RIOSJA, SIR 22742
          hdnUlIdPerson = ContextHelper.getIntSafe(request, HDN_ID_PERSON + i);
          szNmPersonFull = ContextHelper.getStringSafe(request, TXT_NM_PERSON_FULL + i);
          txtSzNbrEmpOnCallPhone1 = ContextHelper.getPhoneSafe(request, TXT_EMP_ONCALL_PHONE1 + i);
          txtSzNbrEmpOnCallPhone2 = ContextHelper.getPhoneSafe(request, TXT_EMP_ONCALL_PHONE2 + i);
          txtLNbrEmpOnCallExt1 = ContextHelper.getStringSafe(request, TXT_EMP_ONCALL_EXT1 + i);
          txtLNbrEmpOnCallExt2 = ContextHelper.getStringSafe(request, TXT_EMP_ONCALL_EXT2 + i);
          hdnSzNbrEmpHomePhone = ContextHelper.getPhoneSafe(request, HDN_EMP_HOME_PHONE + i);
          selSzCdEmpOnCallDesig = ContextHelper.getStringSafe(request, SEL_ONCALL_DESIG + i);
          txtUsNbrEmpOnCallCntctOrd = ContextHelper.getIntSafe(request, TXT_EMP_ONCALL_CONTACT_ORD + i);
          szCdTitle = ContextHelper.getStringSafe(request, TXT_TITLE + i);
          szCdOnCallProgram = ContextHelper.getStringSafe(request, SEL_ONCALL_PROGRAM + i);

          ulIdOnCall = 0;
          if (state.getAttribute("ulIdOnCall", request) != null) {
            ulIdOnCall = (Integer) state.getAttribute("ulIdOnCall", request);
          }

          // CCMN09SO_LIST is used for displaying the employee list on the On-Call
          // Detail page. If the PageMode is NEW, the employee is not yet in the
          // list. Add them to it. Else, the employee is in the list. Use the
          // "selectedEmployeeIndex" to find them. Then update their data.
          // --------------
          // CCMN10SI is used for saving all updates to the employee list. If an
          // employee is added to CCMN09SO_LIST, he should be added to CCMN10SI and
          // marked as added. If an employee is deleted from CCMN09SO_LIST, he should
          // remain in CCMN10SI but marked for deletion. If an employee is updated
          // in CCMN09SO_LIST, then consider the following: The user might have
          // selected an employee from the employee list, then performed a staff
          // search, then replaced the employee with a different person. If this
          // happened, we must mark the original employee for deletion in CCMN10SI
          // and add the new employee; otherwise, we can just update their data in
          // CCMN10SI. Compare the originally selected employee's person id to the
          // person id from the form to see if it's the same employee.
          if (PageMode.getPageMode(request).equals(PageModeConstants.NEW) && SelectedEmployeeIndex == null) {
            // ***********************
            // *** EMPLOYEE IS NEW ***
            // ***********************
            // Add the new employee to CCMN09SO_LIST.
            ROWCCMN21DO newEmployee = new ROWCCMN21DO();
            newEmployee.setLNbrEmpOnCallExt1(txtLNbrEmpOnCallExt1);
            newEmployee.setLNbrEmpOnCallExt2(txtLNbrEmpOnCallExt2);
            newEmployee.setSzCdEmpOnCallDesig(selSzCdEmpOnCallDesig);
            newEmployee.setSzNbrEmpOnCallPhone1(txtSzNbrEmpOnCallPhone1);
            newEmployee.setSzNbrEmpOnCallPhone2(txtSzNbrEmpOnCallPhone2);
            newEmployee.setSzNmPersonFull(szNmPersonFull);
            newEmployee.setUlIdPerson(hdnUlIdPerson);
            newEmployee.setUsNbrEmpOnCallCntctOrd(txtUsNbrEmpOnCallCntctOrd);
            newEmployee.setLNbrPhone(hdnSzNbrEmpHomePhone);
            newEmployee.setSzCdTitle(szCdTitle);
            newEmployee.setSzCdOnCallProgram(szCdOnCallProgram);
            ccmn09so_list.getROWCCMN21DO_ARRAY().addROWCCMN21DO(newEmployee);
            int numOfEmployeesInCCMN09SO = ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty();
            numOfEmployeesInCCMN09SO++;
            ccmn09so_list.getROWCCMN21DO_ARRAY().setUlRowQty(numOfEmployeesInCCMN09SO);

            // Add the new employee to CCMN10SI.
            ROWCCMN22DI copyOfNewEmployee = new ROWCCMN22DI();
            copyOfNewEmployee.setLNbrEmpOnCallExt1(txtLNbrEmpOnCallExt1);
            copyOfNewEmployee.setLNbrEmpOnCallExt2(txtLNbrEmpOnCallExt2);
            copyOfNewEmployee.setSzCdEmpOnCallDesig(selSzCdEmpOnCallDesig);
            copyOfNewEmployee.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
            copyOfNewEmployee.setSzNbrEmpOnCallPhone1(txtSzNbrEmpOnCallPhone1);
            copyOfNewEmployee.setSzNbrEmpOnCallPhone2(txtSzNbrEmpOnCallPhone2);
            copyOfNewEmployee.setSzCdTitle(szCdTitle);
            copyOfNewEmployee.setSzCdOnCallProgram(szCdOnCallProgram);

            if (ulIdOnCall > 0) {
              copyOfNewEmployee.setUlIdOnCall(ulIdOnCall);
            }
            copyOfNewEmployee.setUlIdPerson(hdnUlIdPerson);
            copyOfNewEmployee.setUsNbrEmpOnCallCntctOrd(txtUsNbrEmpOnCallCntctOrd);
            ccmn10si.getROWCCMN22DI_ARRAY().addROWCCMN22DI(copyOfNewEmployee);
            int numOfEmployeesInCCMN10SI = ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty();
            numOfEmployeesInCCMN10SI++;
            ccmn10si.getROWCCMN22DI_ARRAY().setUlRowQty(numOfEmployeesInCCMN10SI);
          } // end if( PageMode.getPageMode( request ).equals( PageMode.NEW ) &&...
          else {
            // Get the originally selected employee.
            int selectedEmployeeIndex = SelectedEmployeeIndex;
            ROWCCMN21DO originallySelectedEmployee = ccmn09so_list.getROWCCMN21DO_ARRAY()
                    .getROWCCMN21DO(selectedEmployeeIndex);

            // The employee is either the same employee that was originally selected
            // by the user (if), or it is a different employee selected from staff
            // search (else). Handle each case appropriately.
            if (originallySelectedEmployee.getUlIdEmpOnCallLink() == hdnUlIdEmpOnCallLink) {
              // ***************************************************
              // *** EMPLOYEE IS SAME EMPLOYEE, DATA WAS UPDATED ***
              // ***************************************************
              // Update the employee's data in CCMN10SI. (Employee's data will be
              // updated in CCMN09SO_LIST further down.)
              Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
              while (enumeration.hasMoreElements()) {
                ROWCCMN22DI copyOfOriginallySelectedEmployee = (ROWCCMN22DI) enumeration.nextElement();

                // RIOSJA, SIR 22742 - Use ID_EMP_ON_CALL_LINK, not just
                // ID_PERSON, to distinguish unique rows.
                if (copyOfOriginallySelectedEmployee.getUlIdPerson() == originallySelectedEmployee.getUlIdPerson()
                    && copyOfOriginallySelectedEmployee.getUlIdEmpOnCallLink() == originallySelectedEmployee
                        .getUlIdEmpOnCallLink()
                    && (copyOfOriginallySelectedEmployee.getSzCdScrDataAction() == null || !copyOfOriginallySelectedEmployee
                        .getSzCdScrDataAction()
                        .equals(
                                ServiceConstants.REQ_FUNC_CD_DELETE))) {
                  copyOfOriginallySelectedEmployee.setUlIdEmpOnCallLink(hdnUlIdEmpOnCallLink);
                  copyOfOriginallySelectedEmployee.setLNbrEmpOnCallExt1(txtLNbrEmpOnCallExt1);
                  copyOfOriginallySelectedEmployee.setLNbrEmpOnCallExt2(txtLNbrEmpOnCallExt2);
                  copyOfOriginallySelectedEmployee.setSzCdEmpOnCallDesig(selSzCdEmpOnCallDesig);
                  copyOfOriginallySelectedEmployee.setSzNbrEmpOnCallPhone1(txtSzNbrEmpOnCallPhone1);
                  copyOfOriginallySelectedEmployee.setSzNbrEmpOnCallPhone2(txtSzNbrEmpOnCallPhone2);
                  copyOfOriginallySelectedEmployee.setUsNbrEmpOnCallCntctOrd(txtUsNbrEmpOnCallCntctOrd);
                  copyOfOriginallySelectedEmployee.setSzCdTitle(szCdTitle);
                  copyOfOriginallySelectedEmployee.setSzCdOnCallProgram(szCdOnCallProgram);
                  if (copyOfOriginallySelectedEmployee.getSzCdScrDataAction() == null) {
                    copyOfOriginallySelectedEmployee.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
                  }
                }
              } // end while ( enumeration.hasMoreElements() )
            } // end if( originallySelectedEmployee.getUlIdPerson() == hdnUlIdPerson )
            else {
              // ****************************************************************************
              // *** ORIGINAL EMPLOYEE WILL BE REPLACED BY NEW EMPLOYEE FROM STAFF SEARCH ***
              // ****************************************************************************
              // Mark the original employee for deletion in CCMN10SI if the PageMode
              // is not NEW_USING. If the PageMode is NEW_USING, then actually delete
              // the employee from CCMN10SI because the save service used for
              // inserting new schedules will save all employees regardless of the
              // value in 'SzCdScrDataAction'. (Employee's data will be updated in
              // CCMN09SO_LIST further down.)
              ROWCCMN22DI employeeInCCMN10SI = null;
              Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
              while (enumeration.hasMoreElements()) {
                ROWCCMN22DI copyOfOriginallySelectedEmployee = (ROWCCMN22DI) enumeration.nextElement();

                // RIOSJA, SIR 22742 - Use ID_EMP_ON_CALL_LINK, not just
                // ID_PERSON, to distinguish unique rows.
                if (copyOfOriginallySelectedEmployee.getUlIdPerson() == originallySelectedEmployee.getUlIdPerson()
                    && copyOfOriginallySelectedEmployee.getUlIdEmpOnCallLink() == originallySelectedEmployee
                        .getUlIdEmpOnCallLink()
                    && (copyOfOriginallySelectedEmployee.getSzCdScrDataAction() == null || !copyOfOriginallySelectedEmployee
                        .getSzCdScrDataAction()
                        .equals(
                                ServiceConstants.REQ_FUNC_CD_DELETE))) {
                  if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
                    copyOfOriginallySelectedEmployee.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
                  } else {
                    employeeInCCMN10SI = copyOfOriginallySelectedEmployee;
                  }
                }
              }

              // Since PageMode is NEW_USING, actually delete the originally
              // selected employee from CCMN10SI using the index found above.
              if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING) && employeeInCCMN10SI != null) {
                int numOfEmployeesInList = ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty();
                ccmn10si.getROWCCMN22DI_ARRAY().removeROWCCMN22DI(employeeInCCMN10SI);
                numOfEmployeesInList--;
                ccmn10si.getROWCCMN22DI_ARRAY().setUlRowQty(numOfEmployeesInList);
              }

              // Add the new employee to CCMN10SI.
              ROWCCMN22DI newEmployee = new ROWCCMN22DI();
              newEmployee.setLNbrEmpOnCallExt1(txtLNbrEmpOnCallExt1);
              newEmployee.setLNbrEmpOnCallExt2(txtLNbrEmpOnCallExt2);
              newEmployee.setSzCdEmpOnCallDesig(selSzCdEmpOnCallDesig);
              newEmployee.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
              newEmployee.setSzNbrEmpOnCallPhone1(txtSzNbrEmpOnCallPhone1);
              newEmployee.setSzNbrEmpOnCallPhone2(txtSzNbrEmpOnCallPhone2);
              newEmployee.setSzCdTitle(szCdTitle);
              newEmployee.setSzCdOnCallProgram(szCdOnCallProgram);
              if (ulIdOnCall > 0) {
                newEmployee.setUlIdOnCall(ulIdOnCall);
              }
              newEmployee.setUlIdPerson(hdnUlIdPerson);
              newEmployee.setUsNbrEmpOnCallCntctOrd(txtUsNbrEmpOnCallCntctOrd);
              ccmn10si.getROWCCMN22DI_ARRAY().addROWCCMN22DI(newEmployee);
              int numOfEmployeesInCCMN10SI = ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty();
              numOfEmployeesInCCMN10SI++;
              ccmn10si.getROWCCMN22DI_ARRAY().setUlRowQty(numOfEmployeesInCCMN10SI);
            } // end if ( updatedEmployee.getUlIdPerson() == hdnUlIdPerson )

            // Update the employee's data in CCMN09SO_LIST.
            originallySelectedEmployee.setLNbrEmpOnCallExt1(txtLNbrEmpOnCallExt1);
            originallySelectedEmployee.setLNbrEmpOnCallExt2(txtLNbrEmpOnCallExt2);
            originallySelectedEmployee.setSzCdEmpOnCallDesig(selSzCdEmpOnCallDesig);
            originallySelectedEmployee.setSzNbrEmpOnCallPhone1(txtSzNbrEmpOnCallPhone1);
            originallySelectedEmployee.setSzNbrEmpOnCallPhone2(txtSzNbrEmpOnCallPhone2);
            originallySelectedEmployee.setSzNmPersonFull(szNmPersonFull);
            originallySelectedEmployee.setUlIdPerson(hdnUlIdPerson);
            originallySelectedEmployee.setUsNbrEmpOnCallCntctOrd(txtUsNbrEmpOnCallCntctOrd);
            originallySelectedEmployee.setLNbrPhone(hdnSzNbrEmpHomePhone);
            originallySelectedEmployee.setSzCdTitle(szCdTitle);
            originallySelectedEmployee.setSzCdOnCallProgram(szCdOnCallProgram);
          } // end if( PageMode.getPageMode( request ).equals( PageMode.NEW ) &&...
        } // end for
      } // End else Block for Sir19889

      // If the user was adding a new employee(s), the PageMode was set to NEW
      // temporarily. Now that the new employee(s) has been added, set the
      // On-Call Detail page's PageMode back to what it was before.
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW) && SelectedEmployeeIndex == null) {
        String originalOnCallDetailPageMode = (String) state.getAttribute(ON_CALL_DETAIL_PAGE_MODE, request);
        PageMode.setPageMode(originalOnCallDetailPageMode, request);
      }

      // Put an indicator into the request telling the On-Call Detail page to
      // anchor to the Employees section.
      // Sir19889 do not goto EmployeesSection, goto the top so user can view message about
      // adding too many rows
      if (numLeft >= 0) {
        request.setAttribute("goToEmployeesSection", true);
      }
      state.setAttribute(CCMN09SO_LIST, ccmn09so_list, request);
      state.setAttribute(CCMN10SI, ccmn10si, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Deletes an On-Call block or shift from the database.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void deleteOnCallSchedule_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteOnCallSchedule_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    CCMN07SI ccmn07si;

    try {
      // Call the On-Call Schedule AUD service to delete the schedule from the
      // database.
      ccmn07si = populateCCMN07SI_AUD(context, DELETE);
      // WtcHelper.callService("CCMN07S", ccmn07si);
      admin.saveOnCallListInformation(ccmn07si);
      removeDeletedScheduleFromList(context);

      // Put an indicator into the request so that the On-Call Search page will
      // anchor down to the On-Call Schedule list.
      request.setAttribute("bSearchPerformed", true);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Calls the Staff Search page.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void performStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".performStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // Preserve the value of the On-Call Employee Detail page PageMode so that
      // it can be restored upon returning from the Staff Search page.
      state.setAttribute(ON_CALL_EMPLOYEE_DETAIL_PAGE_MODE, PageMode.getPageMode(request), request);
      StaffSearchInput io = new StaffSearchInput();
      io.setSourcePage(StaffSearchInput.ON_CALL);
      io.setDestinationUrl("/workload/OnCall/displayOnCallEmployee");
      request.setAttribute("StaffSearchInput", io);
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Loads the On-Call Employee Detail page in NEW mode.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void addOnCallEmployee_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addOnCallEmployee_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      putOnCallParamsIntoState(context);

      // Put the On-Call Detail page PageMode into state so that it can be set
      // back to that value upon returning from the On-Call Employee Detail page.
      // Then set the On-Call Employee Detail page PageMode to NEW.
      state.setAttribute(ON_CALL_DETAIL_PAGE_MODE, PageMode.getPageMode(request), request);
      PageMode.setPageMode(PageModeConstants.NEW, request);

      // Put an empty employee object into state to be used by the On-Call
      // Employee Detail page.
      CCMN09SO ccmn09so_detail = new CCMN09SO();
      ROWCCMN21DO_ARRAY rowccmn21do_array = new ROWCCMN21DO_ARRAY();
      rowccmn21do_array.addROWCCMN21DO(new ROWCCMN21DO());
      ccmn09so_detail.setROWCCMN21DO_ARRAY(rowccmn21do_array);
      state.setAttribute(CCMN09SO_DETAIL, ccmn09so_detail, request);

      // Since the user is adding a new employee(s), clear the "selected employee
      // index" from state. (The index is used to track which employee in the
      // employee list the user was updating last.)
      state.removeAttribute(SELECTED_EMPLOYEE_STRING, request);

      // ------------------------------------
      // --- GO TO THE STAFF SEARCH PAGE. ---
      // ------------------------------------
      // Preserve the value of the On-Call Employee Detail page PageMode so that
      // it can be restored upon returning from the Staff Search page.
      state.setAttribute(ON_CALL_EMPLOYEE_DETAIL_PAGE_MODE, PageMode.getPageMode(request), request);
      StaffSearchInput io = new StaffSearchInput();
      io.setSourcePage(StaffSearchInput.ON_CALL);
      io.setDestinationUrl("/workload/OnCall/displayOnCallEmployee");
      request.setAttribute("StaffSearchInput", io);
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Removes an employee from CCMN09SO_LIST in state so that it will no longer appear in the employee list, and marks
   * the employee for deletion in CCMN10SI in state so that the employee will be deleted when the save service is
   * called.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void deleteOnCallEmployee_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addOnCallEmployee_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      putOnCallParamsIntoState(context);

      // Delete the employee from CCMN09SO_LIST.
      int selectedEmployeeIndex = ContextHelper.getIntSafe(request, SELECTED_EMPLOYEE_STRING);
      CCMN09SO ccmn09so_list = (CCMN09SO) state.getAttribute(CCMN09SO_LIST, request);
      int numOfEmployeesInList = ccmn09so_list.getROWCCMN21DO_ARRAY().getUlRowQty();
      ROWCCMN21DO deletedEmployee = ccmn09so_list.getROWCCMN21DO_ARRAY().getROWCCMN21DO(selectedEmployeeIndex);
      ccmn09so_list.getROWCCMN21DO_ARRAY().removeROWCCMN21DO(deletedEmployee);
      numOfEmployeesInList--;
      ccmn09so_list.getROWCCMN21DO_ARRAY().setUlRowQty(numOfEmployeesInList);

      // Mark the employee as 'deleted' in CCMN10SI
      CCMN10SI ccmn10si = (CCMN10SI) state.getAttribute(CCMN10SI, request);
      ROWCCMN22DI employeeInCCMN10SI = null;
      ROWCCMN22DI employee;
      Enumeration enumeration = ccmn10si.getROWCCMN22DI_ARRAY().enumerateROWCCMN22DI();
      while (enumeration.hasMoreElements()) {
        employee = (ROWCCMN22DI) enumeration.nextElement();

        // Compare a few of the fields to determine if this is the employee that
        // was deleted from CCMN09SO_LIST. If it's the same employee, and the
        // PageMode is not NEW_USING, and the employee is not already marked for
        // deletion, then mark them for deletion. If it's the same employee, and
        // the PageMode is NEW_USING, then actually remove them from the list
        // because the save service saves all employees in the list regardless
        // of the 'SzCdScrDataAction' value. (NOTE: If the user has made a lot
        // of changes to the employee list without saving, this process could
        // begin to fail because CCMN09SO_LIST and CCMN10SI will get more and
        // more out of sync.
        if (employee.getUlIdPerson() == deletedEmployee.getUlIdPerson()
            && employee.getUsNbrEmpOnCallCntctOrd() == deletedEmployee.getUsNbrEmpOnCallCntctOrd()
//            && employee.getSzCdEmpOnCallDesig().equals(deletedEmployee.getSzCdEmpOnCallDesig())
&& (employee.getSzCdScrDataAction() == null || !employee.getSzCdScrDataAction()
                .equals(ServiceConstants.REQ_FUNC_CD_DELETE))) {
          if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
            employee.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
          } else {
            employeeInCCMN10SI = employee;
          }
          break;
        }
      } // end while ( enumeration.hasMoreElements() )

      // Since PageMode is NEW_USING, actually delete the employee from CCMN10SI.
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING) && employeeInCCMN10SI != null) {
        numOfEmployeesInList = ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty();
        ccmn10si.getROWCCMN22DI_ARRAY().removeROWCCMN22DI(employeeInCCMN10SI);
        numOfEmployeesInList--;
        ccmn10si.getROWCCMN22DI_ARRAY().setUlRowQty(numOfEmployeesInList);
      }

      // Put an indicator into the request telling the On-Call Detail page to
      // anchor to the Employees section.
      request.setAttribute("goToEmployeesSection", true);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Removes an employee from CCMN09SO_DETAIL in state so that it will no longer appear in the list of employees
   * retrieved from Staff Search.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void removeEmployeeFromStaffSearchList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".removeEmployeeFromStaffSearchList_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String txtSzNbrEmpOnCallPhone1;
    String txtSzNbrEmpOnCallPhone2;
    String txtLNbrEmpOnCallExt1;
    String txtLNbrEmpOnCallExt2;
    String selSzCdEmpOnCallDesig;
    int txtUsNbrEmpOnCallCntctOrd;

    try {
      int indexOfEmployeeToRemove = ContextHelper.getInt(request, "indexOfEmployeeToRemove");
      ROWCCMN21DO employeeToRemove = null;

      CCMN09SO ccmn09so_detail = (CCMN09SO) state.getAttribute(CCMN09SO_DETAIL, request);
      ROWCCMN21DO_ARRAY rowccmn21do_array = ccmn09so_detail.getROWCCMN21DO_ARRAY();

      int loopCounter = 0;
      Enumeration enumeration = rowccmn21do_array.enumerateROWCCMN21DO();
      while (enumeration.hasMoreElements()) {
        ROWCCMN21DO employee = (ROWCCMN21DO) enumeration.nextElement();

        txtSzNbrEmpOnCallPhone1 = ContextHelper.getPhoneSafe(request, TXT_EMP_ONCALL_PHONE1 + loopCounter);
        txtSzNbrEmpOnCallPhone2 = ContextHelper.getPhoneSafe(request, TXT_EMP_ONCALL_PHONE2 + loopCounter);
        txtLNbrEmpOnCallExt1 = ContextHelper.getStringSafe(request, TXT_EMP_ONCALL_EXT1 + loopCounter);
        txtLNbrEmpOnCallExt2 = ContextHelper.getStringSafe(request, TXT_EMP_ONCALL_EXT2 + loopCounter);
        selSzCdEmpOnCallDesig = ContextHelper.getStringSafe(request, SEL_ONCALL_DESIG + loopCounter);
        txtUsNbrEmpOnCallCntctOrd = ContextHelper.getIntSafe(request, TXT_EMP_ONCALL_CONTACT_ORD + loopCounter);

        employee.setSzNbrEmpOnCallPhone1(txtSzNbrEmpOnCallPhone1);
        employee.setSzNbrEmpOnCallPhone2(txtSzNbrEmpOnCallPhone2);
        employee.setLNbrEmpOnCallExt1(txtLNbrEmpOnCallExt1);
        employee.setLNbrEmpOnCallExt2(txtLNbrEmpOnCallExt2);
        employee.setSzCdEmpOnCallDesig(selSzCdEmpOnCallDesig);
        employee.setUsNbrEmpOnCallCntctOrd(txtUsNbrEmpOnCallCntctOrd);

        if (indexOfEmployeeToRemove == loopCounter) {
          employeeToRemove = employee;
        }
        loopCounter++;
      }

      rowccmn21do_array.removeROWCCMN21DO(employeeToRemove);

      // If the user removed the last employee from the list, put an empty
      // employee object into the list so the On-Call Employee Detail page can
      // display properly. Also, remove the Staff Search indicator since none
      // of the employees returned by Staff Search remain.
      int numOfEmployees = ContextHelper.getInt(request, "numOfEmployees");
      if (numOfEmployees == 1) {
        rowccmn21do_array.addROWCCMN21DO(new ROWCCMN21DO());
        state.removeAttribute(PERFORMED_STAFF_SEARCH, request);
      }

      ccmn09so_detail.setROWCCMN21DO_ARRAY(rowccmn21do_array);
      state.setAttribute(CCMN09SO_DETAIL, ccmn09so_detail, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /*
   * Creates a url to a page in this converation given the page name and a hashtable of parameters. public static String
   * getUrl( String pageName, Map parameters ) { String baseUrl = ON_CALL_CONVERSATION_URL + pageName; return
   * BasePrsConversation.getUrl( baseUrl, parameters ); }
   */

  /**
   * Removes an employee from CCMN09SO_DETAIL in state so that it will no longer appear in the list of employees
   * retrieved from Staff Search.
   *
   * @param context The GrndeExchangeContext object.
   */
  private void removeDeletedScheduleFromList(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".removeDeletedScheduleFromList()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      int deletedScheduleId = ContextHelper.getIntSafe(request, "rbUlIdOnCall");

      // Iterate through the on-call schedules that were displayed in the
      // list, find the schedule that was deleted, and remove it from the list
      // of schedules that will be displayed on the On-Call Search page.
      CCMN06SO ccmn06so_list = (CCMN06SO) state.getAttribute(CCMN06SO_LIST, request);
      Enumeration enumeration = ccmn06so_list.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();
      ROWCCMN16DO deletedSchedule = null;
      while (enumeration.hasMoreElements()) {
        ROWCCMN16DO rowccmn16do = (ROWCCMN16DO) enumeration.nextElement();
        if (rowccmn16do.getUlIdOnCall() == deletedScheduleId) {
          deletedSchedule = rowccmn16do;
          break;
        } // end if( rowccmn16do.getUlIdOnCall() == rowccmn20di.getUlIdOnCall() )
      } // end while( enumeration.hasMoreElements() )
      ccmn06so_list.getROWCCMN16DO_ARRAY().removeROWCCMN16DO(deletedSchedule);
      int numOfSchedulesInList = ccmn06so_list.getROWCCMN16DO_ARRAY().getUlRowQty();
      numOfSchedulesInList++;
      ccmn06so_list.getROWCCMN16DO_ARRAY().setUlRowQty(numOfSchedulesInList);
      state.setAttribute(CCMN06SO_LIST, ccmn06so_list, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Builds a "Schedule-to-Counties" HashMap that maps each On-Call schedule to the county/counties to which it
   * applies.
   *
   * @param ccmn06so
   * @param scheduleToCountiesHashMap
   */
  private Map buildScheduleToCountiesHashmap(GrndsExchangeContext context, CCMN06SO ccmn06so,
                                             Map scheduleToCountiesHashMap) throws ValidationException,
                                                                                   MarshalException, ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".buildScheduleToCountiesHashmap()");
    performanceTrace.enterScope();

    // SIR 15168 - Added for request and state.
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Set the pagination objects to the appropriate values for the call to
    // the On-Call County Retrieve service (CCMNH7S)
    UlPageSizeNbr_ARRAY pageSizeNbr = new UlPageSizeNbr_ARRAY();
    UsPageNbr_ARRAY pageNbr = new UsPageNbr_ARRAY();
    pageSizeNbr.addUlPageSizeNbr(SEARCH_RESULTS_PER_PAGE);
    pageNbr.addUsPageNbr(INITIAL_PAGE);

    Boolean bLaunchReport = Boolean.TRUE;
    List selectedCountiesVector;
    selectedCountiesVector = (List) state.getAttribute(SELETED_COUNTIES_VECTOR, request);

    // Interate through the schedules, and find the counties to which each
    // schedule applies. Create a "Schedule-to-Counties" HashMap that maps
    // each On-Call schedule to the county to which it applies.
    String county;
    CCMNH7SI ccmnh7si;
    CCMNH7SO ccmnh7so;
    ROWCCMN16DO schedule;
    Enumeration searchResultsEnum = ccmn06so.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();

    while (searchResultsEnum.hasMoreElements()) {
      schedule = (ROWCCMN16DO) searchResultsEnum.nextElement();
      ccmnh7si = populateCCMNH7SI_Retrieve(schedule.getSzCdRegion(), schedule.getUlIdOnCall());
      ArchInputStruct input = new ArchInputStruct();
      input.setSzUserId(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());
      ccmnh7si.setArchInputStruct(input);
      ccmnh7si.setUlPageSizeNbr_ARRAY(pageSizeNbr);
      ccmnh7si.setUsPageNbr_ARRAY(pageNbr);
      // ccmnh7so = CCMNH7SO.unmarshal(new StringReader(WtcHelper.callService("CCMNH7S", ccmnh7si)));
      ccmnh7so = admin.retrieveOnCallListCounty(ccmnh7si);

      // SIR 15168 - This code will use an iterator to verify that the
      // counties are within the same county group. It will then pass
      // an indicator to jsp.
      String selectedRegion = ContextHelper.getString(request, SEL_SZCD_REGION);

      // SIR 23124 and 22185-- If the Region is Statewide Intake the checkbox helper returns zero
      // counties. Since all counties are being searched on the code in the if statement
      // does not need to ne run.
      if (!CodesTables.CREGIONS_98.equals(selectedRegion) && selectedCountiesVector != null) {
        Iterator searchCountiesIter = selectedCountiesVector.iterator();
        while (searchCountiesIter.hasNext()) {
          String searchCounty = (String) searchCountiesIter.next();
          Enumeration scheduleCountiesEnum = ccmnh7so.getROWCCMNH7DO_ARRAY().enumerateROWCCMNH7DO();
          boolean searchCountyFound = false;
          while (scheduleCountiesEnum.hasMoreElements() && !searchCountyFound) {
            ROWCCMNH7DO scheduleCounty = (ROWCCMNH7DO) scheduleCountiesEnum.nextElement();
            if (searchCounty.equals(scheduleCounty.getSzCdOnCallCounty())) {
              searchCountyFound = true;
              break;
            }
          }
          if (!searchCountyFound) {
            bLaunchReport = Boolean.FALSE;
            break;
          }
        }
      }

      // pass bLaunchReport to determine if the user can launch the report
      request.setAttribute("bLaunchReport", bLaunchReport);

      // If the schedule applies to only one county, then put that county's
      // name in the map. If the schedule applies to more than one county,
      // then put "MULT" (Multiple) in the map. Otherwise, put "error" in the
      // map to indicate that an error has occurred.
      if (ccmnh7so.getArchOutputStruct().getUlRowQty() == 1) {
        // If the county code is '255', then the schedule applied to 'All'
        // counties. Set the name directly instead of using the counties codes
        // table because county code '255' is not in the codes table.
        if (ccmnh7so.getROWCCMNH7DO_ARRAY().getROWCCMNH7DO(0).getSzCdOnCallCounty().equals(ALL_COUNTIES_COUNTY_CODE)) {
          county = ALL_COUNTIES_COUNTY_CODE;
        } else {
          county = ccmnh7so.getROWCCMNH7DO_ARRAY().getROWCCMNH7DO(0).getSzCdOnCallCounty();
        }
        scheduleToCountiesHashMap.put(schedule.getUlIdOnCall(), county);
      } else if (ccmnh7so.getArchOutputStruct().getUlRowQty() > 1) {
        scheduleToCountiesHashMap.put(schedule.getUlIdOnCall(), MULTIPLE_COUNTIES_CODE);
      } else {
        scheduleToCountiesHashMap.put(schedule.getUlIdOnCall(), ERROR_STRING);
      }
    } // end while( enumeration.hasMoreElements() )
    performanceTrace.exitScope();
    return scheduleToCountiesHashMap;
  }

  /**
   * Helper method to populate the input object for the On-Call search service (CCMN06S).
   *
   * @param context The GrndeExchangeContext object.
   */
  private CCMN06SI populateCCMN06SI_Search(GrndsExchangeContext context) throws LookupException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN06SI_Search()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCMN06SI ccmn06si = new CCMN06SI();
    ROWCCMN16DI rowccmn16di = new ROWCCMN16DI();

    // If the user clicked the Search button, populate the input object with
    // the search params entered by the user. If the user clicked a pagination
    // hyperlink, populate the input object with the most recently used search
    // params.
    String buttonPressed = ContextHelper.getStringSafe(request, "buttonPressed");
    if (buttonPressed.equals(OnCallCustomValidation.SEARCH_BUTTON)
        || buttonPressed.equals(OnCallCustomValidation.SAVE_BUTTON)) {
      // Get the form field values from the request.
      rowccmn16di.setSzCdOnCallProgram(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_PROG));
      rowccmn16di.setSzCdRegion(ContextHelper.getStringSafe(request, SEL_SZCD_REGION));
      rowccmn16di.setSzCdOnCallType(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_TYP));
      rowccmn16di.setTmOnCallStart(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START));
      rowccmn16di.setTmOnCallEnd(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END));
      if (request.getParameter(TXT_DT_ONCALL_START) != null && !"".equals(request.getParameter(TXT_DT_ONCALL_START))) {
        org.exolab.castor.types.Date date = null;
        try {
          date = DateHelper.toCastorDate((String) state.getAttribute(TXT_DT_ONCALL_START, request));
        } catch (Exception e) {
          // Nothing is needed here, null is a good value.
        }
        rowccmn16di.setDtDtOnCallStart(date);
      }
      if (request.getParameter(TXT_DT_ONCALL_END) != null && !"".equals(request.getParameter(TXT_DT_ONCALL_END))) {
        org.exolab.castor.types.Date date = null;
        try {
          date = DateHelper.toCastorDate((String) state.getAttribute(TXT_DT_ONCALL_END, request));
        } catch (Exception e) {
          // Nothing is needed here, null is a good value.
        }
        rowccmn16di.setDtDtOnCallEnd(date);
      }

      // Get the selected counties from the request.
      SzCdOnCallCounty_ARRAY_CCMN06SI selectedCounties = new SzCdOnCallCounty_ARRAY_CCMN06SI();
      String selectedRegion = ContextHelper.getString(request, SEL_SZCD_REGION);

      // String checkboxGroupName = "cbxSelectedCountiesRegion" + selectedRegion;
      // String[] selectedCountiesFromRequest = CheckboxHelper.getCheckedValues(request, checkboxGroupName);

      String[] selectedCountiesFromRequest = new String[1];
      selectedCountiesFromRequest[0] = ContextHelper.getString(request, SEL_SZCD_COUNTY);

      // SIR 15168 - Create new String buffers.

      StringBuffer selectedCountiesString = new StringBuffer("");
      StringBuffer decodedSelectedCountiesString = new StringBuffer("");

      // SIR 23134 -- If the Region is Statewide Intake the checkbox helper returns zero
      // counties. The SQR report can be populated in two different ways: The first
      // populates county code as '152 147' and decodes as 'Lubbock|Comal'. The | is
      // used on the SQR report and translated into a comma. If the user searches on
      // a region of statewide the Counties string and decode string will passed as
      // 'STATEWIDE'. This will allow the SQR to return the all coounties searches.
      for (int i = 0; i < selectedCountiesFromRequest.length; i++) {
        selectedCounties.addSzCdOnCallCounty(selectedCountiesFromRequest[i]);
        // get counties and create a string buffer
        selectedCountiesString.append(selectedCountiesFromRequest[i]).append(" ");
        decodedSelectedCountiesString.append(Lookup.simpleDecode(CodesTables.CCOUNT, selectedCountiesFromRequest[i]))
                .append("|");
      }

      // SIR 15168 - if the user only searches on one county this if statement trims the
      // blank space off the end. County code have a length of 3.
      selectedCountiesString.delete(selectedCountiesString.length() - 1, selectedCountiesString.length());

      decodedSelectedCountiesString.delete(decodedSelectedCountiesString.length() - 1,
                                           decodedSelectedCountiesString.length());

      // Pass variables from the conversation to the jsp.
      request.setAttribute("selectedCountiesString", selectedCountiesString);
      request.setAttribute("decodedSelectedCountiesString", decodedSelectedCountiesString);

      Integer counterCountiesString = selectedCountiesString.length();
      request.setAttribute("counterCountiesString", counterCountiesString);

      rowccmn16di.setSzCdOnCallCounty_ARRAY_CCMN06SI(selectedCounties);
      rowccmn16di.setCdCountyCounter(selectedCountiesFromRequest.length);
    } else {
      // Get the form field values from state.
      rowccmn16di.setSzCdOnCallProgram((String) state.getAttribute(SEL_SZCD_ONCALL_PROG, request));
      rowccmn16di.setSzCdRegion((String) state.getAttribute(SEL_SZCD_REGION, request));
      rowccmn16di.setSzCdOnCallType((String) state.getAttribute(SEL_SZCD_ONCALL_TYP, request));
      rowccmn16di.setTmOnCallStart((String) state.getAttribute(TXT_TM_ONCALL_START, request));
      rowccmn16di.setTmOnCallEnd((String) state.getAttribute(TXT_TM_ONCALL_END, request));
      if (state.getAttribute(TXT_DT_ONCALL_START, request) != null
          && !"".equals(state.getAttribute(TXT_DT_ONCALL_START, request))) {
        org.exolab.castor.types.Date date = null;
        try {
          date = DateHelper.toCastorDate((String) state.getAttribute(TXT_DT_ONCALL_START, request));
        } catch (Exception e) {
          // Nothing is needed here, null is a good value.
        }
        rowccmn16di.setDtDtOnCallStart(date);
      }
      if (state.getAttribute(TXT_DT_ONCALL_END, request) != null
          && !"".equals(state.getAttribute(TXT_DT_ONCALL_END, request))) {
        org.exolab.castor.types.Date date = null;
        try {
          date = DateHelper.toCastorDate((String) state.getAttribute(TXT_DT_ONCALL_END, request));
        } catch (Exception e) {
          // Nothing is needed here, null is a good value.
        }
        rowccmn16di.setDtDtOnCallEnd(date);
      }

      // Get the selected counties from state.
      SzCdOnCallCounty_ARRAY_CCMN06SI selectedCounties = new SzCdOnCallCounty_ARRAY_CCMN06SI();
      List selectedCountiesVector = (List) state.getAttribute(SELETED_COUNTIES_VECTOR, request);
      Iterator iter = selectedCountiesVector.iterator();
      while (iter.hasNext()) {
        String county = (String) iter.next();
        selectedCounties.addSzCdOnCallCounty(county);
      }
      rowccmn16di.setSzCdOnCallCounty_ARRAY_CCMN06SI(selectedCounties);
      rowccmn16di.setCdCountyCounter(selectedCountiesVector.size());
    }
    ccmn06si.setROWCCMN16DI(rowccmn16di);
    performanceTrace.exitScope();
    return ccmn06si;
  }

  /**
   * Helper method to populate the input object for the On-Call Schedule AUD service (CCMN07S).
   *
   * @param context The GrndeExchangeContext object.
   * @param action  The action to be performed - add, update or delete
   */
  private CCMN07SI populateCCMN07SI_AUD(GrndsExchangeContext context, String action) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN07SI_AUD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    CCMN07SI ccmn07si = new CCMN07SI();
    ROWCCMN20DI rowccmn20di = new ROWCCMN20DI();
    SzCdOnCallCounty_ARRAY selectedCounties = new SzCdOnCallCounty_ARRAY();
    //String[] selectedCountiesFromRequest;

    // Populate the input object based upon the activity for which it will
    // be used. The options are: ADD, UPDATE and DELETE. (NOTE: ADD was used
    // in CAPS, but it will never be used in IMPACT. The ADD functionality
    // will now be handled by the On-Call Schedule Save service--CCMN10S.)
    if (action.equals(UPDATE)) {
      rowccmn20di.setBIndOnCallFilled(SCHEDULE_FILLED);
      rowccmn20di.setUlIdOnCall(ContextHelper.getIntSafe(request, "hdnUlIdOnCall"));
      rowccmn20di.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));
      rowccmn20di.setSzCdOnCallProgram(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_PROG));
      //rowccmn20di.setSzCdRegion(ContextHelper.getStringSafe(request, SEL_SZCD_REGION));
      String region = null;
      try {
        region = Lookup.simpleDecode(CodesTables.CCNTYREG, ContextHelper.getStringSafe(request, SEL_SZCD_COUNTY));
      } catch (Exception e) {
      }
      rowccmn20di.setSzCdRegion(region);
      rowccmn20di.setSzCdOnCallCounty(ContextHelper.getStringSafe(request, SEL_SZCD_COUNTY));
      selectedCounties.addSzCdOnCallCounty(rowccmn20di.getSzCdOnCallCounty());
      rowccmn20di.setSzCdOnCallCounty_ARRAY(selectedCounties);
      rowccmn20di.setSzCdOnCallType(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_TYP));
      rowccmn20di.setTmOnCallStart(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START));
      rowccmn20di.setTmOnCallEnd(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END));
      org.exolab.castor.types.Date date = null;
      try {
        date = ContextHelper.getCastorDate(request, TXT_DT_ONCALL_START);
      } catch (Exception e) {
        // Nothing is needed here, null is a good value.
      }
      rowccmn20di.setDtDtOnCallStart(date);
      date = null;
      try {
        date = ContextHelper.getCastorDate(request, TXT_DT_ONCALL_END);
      } catch (Exception e) {
        // Nothing is needed here, null is a good value.
      }
      rowccmn20di.setDtDtOnCallEnd(date);

      ArchInputStruct input = new ArchInputStruct();
      input.setUlPageSizeNbr(1);
      input.setUsPageNbr(INITIAL_PAGE);
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());
      // if End Date of schedule to be updated is null or not before today, set
      // ArchInputStruct.usPageNbr = 0 to indicate ToDo's are needed. Same as
      // windows code now, but doesn't seem to work. - JEH 06/04/03
      if (rowccmn20di.getDtDtOnCallEnd() == null || !DateHelper.isBeforeToday(rowccmn20di.getDtDtOnCallEnd())) {
        input.setUsPageNbr(0);
      }
      ccmn07si.setArchInputStruct(input);

      // Put a copy of the updated schedule's details into the request so that
      // the calling method can use them to update the list of schedules that
      // will be displayed on the On-Call Search page.
      //request.setAttribute("savedSchedule", rowccmn20di);
    } // end if( action.equals( UPDATE ) )
    else if (action.equals(DELETE)) {
      rowccmn20di.setUlIdOnCall(ContextHelper.getIntSafe(request, "rbUlIdOnCall"));

      // Iterate through the on-call schedules that were displayed in the
      // list, find the selected schedule, and get its timestamp.
      CCMN06SO ccmn06so_list = (CCMN06SO) state.getAttribute(CCMN06SO_LIST, request);
      Enumeration enumeration = ccmn06so_list.getROWCCMN16DO_ARRAY().enumerateROWCCMN16DO();
      ROWCCMN16DO rowccmn16do;
      while (enumeration.hasMoreElements()) {
        rowccmn16do = (ROWCCMN16DO) enumeration.nextElement();
        if (rowccmn16do.getUlIdOnCall() == rowccmn20di.getUlIdOnCall()) {
          rowccmn20di.setTsLastUpdate(rowccmn16do.getTsLastUpdate());
          rowccmn20di.setBIndOnCallFilled(rowccmn16do.getBIndOnCallFilled());
          rowccmn20di.setSzCdOnCallProgram(rowccmn16do.getSzCdOnCallProgram());
          rowccmn20di.setSzCdRegion(rowccmn16do.getSzCdRegion());
          rowccmn20di.setSzCdOnCallCounty(rowccmn16do.getSzCdOnCallCounty());
          rowccmn20di.setSzCdOnCallType(rowccmn16do.getSzCdOnCallType());
          rowccmn20di.setTmOnCallStart(rowccmn16do.getTmOnCallStart());
          rowccmn20di.setTmOnCallEnd(rowccmn16do.getTmOnCallEnd());
          rowccmn20di.setDtDtOnCallEnd(rowccmn16do.getDtDtOnCallEnd());
          rowccmn20di.setDtDtOnCallStart(rowccmn16do.getDtDtOnCallStart());

          if (CodesTables.CREGIONS_98.equals(rowccmn16do.getSzCdRegion())) {
            selectedCounties.addSzCdOnCallCounty(ALL_COUNTIES_COUNTY_CODE);
            rowccmn20di.setSzCdOnCallMultOrAll(ALL_COUNTIES_COUNTY_DECODE);
            rowccmn20di.setCdCountyCounter(1);
            rowccmn20di.setSzCdOnCallCounty_ARRAY(selectedCounties);
          } else {
            if (rowccmn16do.getUlCountOfCounty() > 1) {
              rowccmn20di.setSzCdOnCallMultOrAll(MULTIPLE_COUNTIES_DECODE);
            } else {
              // value doesn't matter. not used in service.
              rowccmn20di.setSzCdOnCallMultOrAll("0");
            }
            rowccmn20di.setCdCountyCounter(rowccmn16do.getUlCountOfCounty());
          } // end if( CodesTables.CREGIONS_98.equals( rowccmn16do.getSzCdRegion() ) )
          break;
        } // end if( rowccmn16do.getUlIdOnCall() == rowccmn20di.getUlIdOnCall() )
      } // end while( enumeration.hasMoreElements() )

      ArchInputStruct input = new ArchInputStruct();
      input.setUlPageSizeNbr(1);
      input.setUsPageNbr(1);
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
      input.setSzUserId(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());
      // if End Date of schedule to be deleted is null or beyond today, set
      // ArchInputStruct.usPageNbr = 99 to indicate ToDo's are needed
      if (rowccmn20di.getDtDtOnCallEnd() == null || DateHelper.isAfterToday(rowccmn20di.getDtDtOnCallEnd())) {
        input.setUsPageNbr(99);
      }
      ccmn07si.setArchInputStruct(input);
    } // end else if( action.equals( DELETE ) )

    ROWCCMN20DI_ARRAY rowccmn20di_array = new ROWCCMN20DI_ARRAY();
    rowccmn20di_array.addROWCCMN20DI(0, rowccmn20di);
    ccmn07si.setROWCCMN20DI_ARRAY(rowccmn20di_array);

    performanceTrace.exitScope();
    return ccmn07si;
  }

  /**
   * Helper method to populate the input object for the On-Call Counties List retrieve service.
   *
   * @param ulIdOnCall The unique identifier of the On-Call schedule
   */
  private CCMN09SI populateCCMN09SI_Retrieve(GrndsExchangeContext context, int ulIdOnCall) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN09SI_Retrieve()");
    performanceTrace.enterScope();

    CCMN09SI ccmn09si = new CCMN09SI();
    ROWCCMN21DI rowccmn21di = new ROWCCMN21DI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());

    rowccmn21di.setUlIdOnCall(ulIdOnCall);
    ccmn09si.setROWCCMN21DI(rowccmn21di);
    ccmn09si.setArchInputStruct(input);

    performanceTrace.exitScope();
    return ccmn09si;
  }

  /**
   * Helper method to populate the input object for the On-Call Schedule Save service (CCMN10S).
   *
   * @param context The GrndeExchangeContext object.
   */
  private CCMN10SI populateCCMN10SI_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN10SI_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CCMN10SI ccmn10si;
    ROWCCMN20DI rowccmn20di = new ROWCCMN20DI();
    SzCdOnCallCounty_ARRAY selectedCountiesArray = new SzCdOnCallCounty_ARRAY();
    //String[] selectedCountiesFromRequest;
    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    input.setSzUserId(UserProfileHelper.getUserProfile(request).getUserLogonID());

    // The On-Call Schedule Save service input object (CCMN10SI) in state
    // will be used to track all changes to the schedule information, including
    // any changes to the employee list. Continue using the one in state if
    // it exists, otherwise create it.
    ccmn10si = (CCMN10SI) state.getAttribute(CCMN10SI, request);
    if (ccmn10si == null) {
      ccmn10si = new CCMN10SI();
      ROWCCMN22DI_ARRAY rowccmn22di_array = new ROWCCMN22DI_ARRAY();
      rowccmn22di_array.setUlRowQty(0);
      ccmn10si.setROWCCMN22DI_ARRAY(rowccmn22di_array);
    }
    input.setUlPageSizeNbr(ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty());
    ccmn10si.setArchInputStruct(input);
    rowccmn20di.setSzCdOnCallProgram(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_PROG));
    String region = null;
    try {
      region = Lookup.simpleDecode(CodesTables.CCNTYREG, ContextHelper.getStringSafe(request, SEL_SZCD_COUNTY));
    } catch (Exception e) {
    }
    rowccmn20di.setSzCdRegion(region);
    rowccmn20di.setSzCdOnCallType(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_TYP));
    rowccmn20di.setTmOnCallStart(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START));
    rowccmn20di.setTmOnCallEnd(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END));
    rowccmn20di.setSzCdOnCallCounty(ContextHelper.getStringSafe(request, SEL_SZCD_COUNTY));

    selectedCountiesArray.addSzCdOnCallCounty(ContextHelper.getStringSafe(request, SEL_SZCD_COUNTY));
    rowccmn20di.setSzCdOnCallCounty_ARRAY(selectedCountiesArray);

    org.exolab.castor.types.Date date = null;
    try {
      date = ContextHelper.getCastorDate(request, TXT_DT_ONCALL_START);
    } catch (Exception e) {
      // Nothing is needed here, null is a good value.
    }
    rowccmn20di.setDtDtOnCallStart(date);
    date = null;
    try {
      date = ContextHelper.getCastorDate(request, TXT_DT_ONCALL_END);
    } catch (Exception e) {
      // Nothing is needed here, null is a good value.
    }
    rowccmn20di.setDtDtOnCallEnd(date);

    // The schedule's employee list must be filled before it will pass
    // validation, so set it to "filled" by default.
    rowccmn20di.setBIndOnCallFilled(SCHEDULE_FILLED);

    int ulIdOnCall = 0;
    if (state.getAttribute("ulIdOnCall", request) != null) {
      ulIdOnCall = (Integer) state.getAttribute("ulIdOnCall", request);
    }

    if (ulIdOnCall > 0) {
      rowccmn20di.setUlIdOnCall(ulIdOnCall);
    }
    ccmn10si.setROWCCMN20DI(rowccmn20di);

    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)
        || PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
      input.setUsPageNbr(INITIAL_PAGE);
      ccmn10si.setSzSysCdWinMode(PageModeConstants.NEW_USING);

      // Put a copy of the newly saved schedule's details into the request so
      // that the calling method can use them to update the list of schedules
      // that will be displayed on the On-Call Search page.
      //request.setAttribute("savedSchedule", rowccmn20di);
    } else {
      ccmn10si.setSzSysCdWinMode(PageModeConstants.MODIFY);
    }
    performanceTrace.exitScope();
    return ccmn10si;
  }

  /** Called by the displayOnCallEmployee_xa to retrieve an employee's on-call phone, business pager and business phone. */
  private CCMNA1SI populateCCMNA1SI_Retrieve(GrndsExchangeContext context, int ulIdPerson) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMNA1SI_Retrieve()");
    performanceTrace.enterScope();

    CCMNA1SI ccmna1si = new CCMNA1SI();
    UlIdPerson_ARRAY_CCMNA1SI ulIdPersonArray = new UlIdPerson_ARRAY_CCMNA1SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(UserProfileHelper.getUserProfile(context.getRequest()).getUserLogonID());

    input.setUsPageNbr(INITIAL_PAGE);
    input.setUlPageSizeNbr(1);
    ccmna1si.setArchInputStruct(input);

    ulIdPersonArray.setUlIdPerson(new int[] {ulIdPerson});
    ccmna1si.setUlIdPerson_ARRAY_CCMNA1SI(ulIdPersonArray);

    performanceTrace.exitScope();
    return ccmna1si;
  }

  /**
   * Helper method to populate the input object for the On-Call Counties List retrieve service (CCMNH7S).
   *
   * @param region   The region to which the On-Call schedule applies
   * @param onCallId The unique identifier of the On-Call schedule
   */
  private CCMNH7SI populateCCMNH7SI_Retrieve(String region, int onCallId) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMNH7SI_Retrieve()");
    performanceTrace.enterScope();

    CCMNH7SI ccmnh7si = new CCMNH7SI();

    ccmnh7si.setSzCdRegion(region);
    ccmnh7si.setCdIdOnCall(onCallId);

    performanceTrace.exitScope();
    return ccmnh7si;
  }

  /**
   * Called by the displayOnCallDetail_xa to copy the employee list from the retrieve service output object (CCMN09SO)
   * to the save service input object (CCMN10SI).
   *
   * @param ccmn09so The object containing the employees for the given schedule.
   */
  private CCMN10SI copyCCMN09SOtoCCMN10SI(CCMN09SO ccmn09so, GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyCCMN09SOtoCCMN10SI()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    CCMN10SI ccmn10si = new CCMN10SI();
    ROWCCMN22DI_ARRAY rowccmn22di_array = new ROWCCMN22DI_ARRAY();
    ROWCCMN22DI copyOfEmployee;

    ROWCCMN21DO employee;
    Enumeration enumeration = ccmn09so.getROWCCMN21DO_ARRAY().enumerateROWCCMN21DO();
    while (enumeration.hasMoreElements()) {
      employee = (ROWCCMN21DO) enumeration.nextElement();
      copyOfEmployee = new ROWCCMN22DI();

      // Copy the employee properties.
      copyOfEmployee.setLNbrEmpOnCallExt1(employee.getLNbrEmpOnCallExt1());
      copyOfEmployee.setLNbrEmpOnCallExt2(employee.getLNbrEmpOnCallExt2());
      copyOfEmployee.setSzCdEmpOnCallDesig(employee.getSzCdEmpOnCallDesig());
      copyOfEmployee.setSzNbrEmpOnCallPhone1(employee.getSzNbrEmpOnCallPhone1());
      copyOfEmployee.setSzNbrEmpOnCallPhone2(employee.getSzNbrEmpOnCallPhone2());
      copyOfEmployee.setTsLastUpdate(employee.getTsLastUpdate());
      copyOfEmployee.setUlIdEmpOnCallLink(employee.getUlIdEmpOnCallLink());
      copyOfEmployee.setUlIdOnCall(employee.getUlIdOnCall());
      copyOfEmployee.setUlIdPerson(employee.getUlIdPerson());
      copyOfEmployee.setUsNbrEmpOnCallCntctOrd(employee.getUsNbrEmpOnCallCntctOrd());
      copyOfEmployee.setSzCdOnCallProgram(employee.getSzCdOnCallProgram());
      copyOfEmployee.setSzCdTitle(employee.getSzCdTitle());

      // If the PageMode is NEW_USING, the default action for all employees will
      // be ADD; otherwise, the action field will be empty. Employees with no
      // action indicated will be removed from input object before the save service
      // is called since no action is necessary.
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW_USING)) {
        copyOfEmployee.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      }
      rowccmn22di_array.addROWCCMN22DI(copyOfEmployee);
    }
    rowccmn22di_array.setUlRowQty(ccmn09so.getROWCCMN21DO_ARRAY().getUlRowQty());
    ccmn10si.setROWCCMN22DI_ARRAY(rowccmn22di_array);

    performanceTrace.exitScope();
    return ccmn10si;
  }

  /**
   * Called by the saveScheduleFromDetailPage method to remove from the On-Call Schedule Save service input object
   * (CCMN10SI) all unchanged employees and employees that were added and deleted in the same session since no action is
   * necessary.
   *
   * @param ccmn10si On-Call Schedule Save service input object containing the employee list.
   */
  private void removeUnchangedEmployeesFromList(CCMN10SI ccmn10si) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "removeUnchangedEmployeesFromList()");
    performanceTrace.enterScope();

    ROWCCMN22DI employee;
    int numOfEmployeesInList = ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty();
    int numOfLoopsNeeded = ccmn10si.getROWCCMN22DI_ARRAY().getUlRowQty() - 1;
    for (int i = numOfLoopsNeeded; i >= 0; i--) {
      employee = ccmn10si.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i);

      // If no changes were made to the employee (first 2 conditions), or if
      // the employee was added and deleted in the same page session (last 3
      // conditions), remove him from the list since no action is necessary.
      if ((employee.getSzCdScrDataAction() == null || "".equals(employee.getSzCdScrDataAction()))
          || (employee.getUlIdEmpOnCallLink() == 0 && employee.getSzCdScrDataAction() != null && employee
              .getSzCdScrDataAction()
              .equals(
                      ServiceConstants.REQ_FUNC_CD_DELETE))) {
        ccmn10si.getROWCCMN22DI_ARRAY().removeROWCCMN22DI(ccmn10si.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i));
        numOfEmployeesInList--;
        ccmn10si.getROWCCMN22DI_ARRAY().setUlRowQty(numOfEmployeesInList);
        ccmn10si.getArchInputStruct().setUlPageSizeNbr(numOfEmployeesInList);
      }
    }
    performanceTrace.exitScope();
  }

  /**
   * Used to re-populate the request with the search/save parameters so the fields on the JSP can be re-populated upon
   * return.
   *
   * @param context The GrndsExchangeContext object.
   */
  private void putOnCallParamsIntoState(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "putOnCallParamsIntoState()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    state.setAttribute(SEL_SZCD_ONCALL_PROG, ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_PROG), request);
    state.setAttribute(SEL_SZCD_ONCALL_TYP, ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_TYP), request);
    state.setAttribute(TXT_DT_ONCALL_START, ContextHelper.getStringSafe(request, TXT_DT_ONCALL_START), request);
    state.setAttribute(TXT_TM_ONCALL_START, ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START), request);
    state.setAttribute(TXT_DT_ONCALL_END, ContextHelper.getStringSafe(request, TXT_DT_ONCALL_END), request);
    state.setAttribute(TXT_TM_ONCALL_END, ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END), request);
    state.setAttribute(SEL_SZCD_REGION, ContextHelper.getStringSafe(request, SEL_SZCD_REGION), request);
    String selectedRegion = ContextHelper.getStringSafe(request, SEL_SZCD_REGION);

    // If 'Statewide' is the selected region, then all the counties will be
    // selected by default. Create the vector of selected counties only if
    // 'Statewide' is not the selected region.
    if (!selectedRegion.equals(CodesTables.CREGIONS_98)) {
      // String checkboxGroupName = "cbxSelectedCountiesRegion" + ContextHelper.getStringSafe(request, SEL_SZCD_REGION);
      // String[] selectedCountiesFromRequest = CheckboxHelper.getCheckedValues(request, checkboxGroupName);
      String[] selectedCountiesFromRequest = new String[1];
      selectedCountiesFromRequest[0] = ContextHelper.getStringSafe(request, SEL_SZCD_COUNTY);
      List selectedCountiesVector = new ArrayList();
      for (int i = 0; i < selectedCountiesFromRequest.length; i++) {
        selectedCountiesVector.add(selectedCountiesFromRequest[i]);
      }
      state.setAttribute(SELETED_COUNTIES_VECTOR, selectedCountiesVector, request);
    }

    // If CCMN06SO_DETAIL is in state, then we need to update its params with
    // the values from the form since it will be used to repopulate the On-Call
    // Detail page if the user is deleting an employee from the list.
    if (state.getAttribute(CCMN06SO_DETAIL, request) != null) {
      CCMN06SO ccmn06so_detail = (CCMN06SO) state.getAttribute(CCMN06SO_DETAIL, request);
      ROWCCMN16DO rowccmn16do = ccmn06so_detail.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0);
      rowccmn16do.setSzCdOnCallProgram(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_PROG));
      rowccmn16do.setSzCdOnCallType(ContextHelper.getStringSafe(request, SEL_SZCD_ONCALL_TYP));
      rowccmn16do.setSzCdRegion(ContextHelper.getStringSafe(request, SEL_SZCD_REGION));
      rowccmn16do.setTmOnCallEnd(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_END));
      rowccmn16do.setTmOnCallStart(ContextHelper.getTimeSafe(request, TXT_TM_ONCALL_START));
      org.exolab.castor.types.Date endDateAsJavaUtilDate = null;
      try {
        endDateAsJavaUtilDate = ContextHelper.getCastorDate(request, TXT_DT_ONCALL_END);
      } catch (Exception e) {
        // Nothing is needed here, null is a good value.
      }
      org.exolab.castor.types.Date startDateAsJavaUtilDate = null;
      try {
        startDateAsJavaUtilDate = ContextHelper.getCastorDate(request, TXT_DT_ONCALL_START);
      } catch (Exception e) {
        // Nothing is needed here, null is a good value.
      }
      rowccmn16do.setDtDtOnCallEnd(endDateAsJavaUtilDate);
      rowccmn16do.setDtDtOnCallStart(startDateAsJavaUtilDate);
    }

    performanceTrace.exitScope();
  }

  /**
   * Helper method that creates a regions HashMap. The HashMap key will be the region code (from the regions
   * codestable). The HashMap value will be a Vector of CodeAttributes objects that contain codes/decodes of the
   * counties that belong to that region.
   */
  private Map buildCountiesToRegionHashMap() throws LookupException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "buildCountiesToRegionHashMap()");
    performanceTrace.enterScope();

    Map countiesToRegionHashMap = new HashMap();

    // Get all regions from the regions codestable.
    Collection regionsCollection = Lookup.getCategoryCollection(CodesTables.CREGIONS);

    // Build the regions HashMap.
    CodeAttributes region;
    Iterator regionsIterator = regionsCollection.iterator();
    while (regionsIterator.hasNext()) {
      region = (CodeAttributes) regionsIterator.next();
      countiesToRegionHashMap.put(region.getCode(), new ArrayList());
    }

    // Get the codestable that indicates to which region each county belongs.
    Collection countiesToRegionsCollection = Lookup.getCategoryCollection(CodesTables.CCNTYREG);

    // Add each county's CodeAttributes object to the appropriate Vector
    // based on the region to which the county belongs.
    List countiesVector;
    CodeAttributes countyToRegion;
    Iterator countiesToRegionsIterator = countiesToRegionsCollection.iterator();
    while (countiesToRegionsIterator.hasNext()) {
      countyToRegion = (CodeAttributes) countiesToRegionsIterator.next();
      countiesVector = (List) countiesToRegionHashMap.get(countyToRegion.getDecode());
      countiesVector.add(Lookup.decode(CodesTables.CCOUNT, countyToRegion.getCode()));
    }

    performanceTrace.exitScope();
    return countiesToRegionHashMap;
  }

  /**
   * Helper method that handles all the WTC Exceptions.
   *
   * @param we      The WtcException object.
   * @param context The GrndeExchangeContext object.
   */
  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    setPresentationBranch("error", context);
    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_CMN_OVERLAP_UPDATE:
      case Messages.MSG_CMN_OVERLAP_ADD:
      case Messages.MSG_CMN_ON_CALL_TOO_MANY:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_DATABASE_SAVE_FAIL:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_MULT_INST:
        setErrorMessage(errorCode, DETAIL_PAGE, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }
}