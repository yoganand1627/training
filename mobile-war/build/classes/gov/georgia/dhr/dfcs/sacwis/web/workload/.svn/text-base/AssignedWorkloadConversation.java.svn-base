package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicWorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntakeProgressionStatusSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN52DI_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UnitStaffIdentifier;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileException;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to display the Assigned Workload <p/>
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  10/27/03    JMC       SIR 19905 - Set AppMode to edit in displayOtherAssigned()
 *  11/25/03    dickmaec  Sir19809 -- Added Static constaints.
 *  02/06/04    corleyan  SIR 19749 -- Put User ID and name into state for report
 *  05/19/04    corleyan  SIR 22876 -- Put sortOrder into state for report
 *  09/23/04    hadjimh   SIR 22557 -- Users are requesting that after sorting
 *                        their workload by a certain criteria, that the sort
 *                        option remain when they navigate back to the Assigned
 *                        workload page.
 *  06/29/05  casdorjm    SIR 23689 - added new informational message to let
 *                        user know when they are looking at a filtered wkld.
 *  07/14/05  Nallavs     SIR 23265 - Added SORT_BY_RECIDIVISM,which is used to
 *                        sort Rcvm field on workload page.
 *  &lt;p/&gt;
 *  &lt;p/&gt;
 * </pre>
 * 
 * @author Jenn Casdorph, November 20, 2002
 */
@SuppressWarnings("serial")
public class AssignedWorkloadConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "AssignedWorkloadConversation";

  public static final String STAGE_PERSON_NEW = "1";
  
  public static final List<String> NEW_INDICATORS = Arrays.asList(new String[]{STAGE_PERSON_NEW, ArchitectureConstants.Y});

  // -- Random Variables --
  public static final String EVENT_STATUS_COMP = "COMP";

  public static final String NOTIFICATION = "NOT";

  public static final String FORM_LETTER_DESCRIP = "Form Letter Sent to Reporter: ";

  public static final String NULL_STRING = "";

  public static final String REASON_CLOSED_SVC_COMP = "85";

  public static final String UNIT_SUMMARY_PAGE = "/workload/UnitSummary/displayUnitSummary";

  public static final String ACTION_CHANGE = "C";

  public static final String DISPLAY_PAGE = "/workload/AssignedWorkload/displayAssignedWorkload";

  public static final String CPS_PROGRAM = "CPS";

  // public static final String CCL_PROGRAM = "CCL";
  // public static final String RCL_PROGRAM = "RCL";
  public static final String FOSTER_ADOPTIVE = "FAD";

  public static final String INTAKE_STAGE = "INT";

  public static final String SUBCARE = "SUB";

  public static final String FAMILY_SUBCARE = "FSU";

  // public static final String SVC = "SVC";
  public static final String FAMILY_PRES = "FPR";

  // public static final String ADULT_FAMILY_CARE = "AFC";
  public static final String INVESTIGATION = "INV";

  // public static final String ADULT_LIVING = "PAL";
  public static final String POST_ADOPTION = "PAD";

  // public static final String FAMILY_REUN = "FRE";
  public static final String DISPOSITION_CODE_ACA = "ACA";

  public static final String DISPOSITION_CODE_DIV = "DIV";

  public static final String DISPOSITION_CODE_IC = "IC";

  public static final String DISPOSITION_CODE_PA = "PA";

  public static final String DISPOSITION_CODE_PF = "PF";

  public static final String DISPOSITION_CODE_NI = "NI";
  
  public static final String RESAON_CLOSED_ADO_FINAL = CodesTables.CCLOSADO_ADF;

  public static final String SCREEN_OUT_NO_MALTREATMENT_CODE = "SNM";

  public static final String ADOPTION = "ADO";

  public static final String INDICATOR_NO = "N";

  public static final String BRANCH_UNIT_SUMMARY_WORKLOAD = "UnitSummaryWorkload";

  public static final String BRANCH_ASSIGNED_WORKLOAD = "AssignedWorkload";

  /* SIR #22557. added static string */
  public static final String WORKLOAD_SORT_BY = "WorkLoadSortBy";

  public static final String FILTER_BY_INV_30 = "1";

  public static final String FILTER_BY_SVC_60 = "2";
  
  private static final String ERROR_STRING = "error";

  private Admin admin;

  private Person person;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  /** If unitStaffIdentifier is in state/session, then goto UnitSummaryWorkload, else go to assignedWorkload */
  public void displayMyTasks_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayMyTasks_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    UnitStaffIdentifier unitStaffIdentifier = UserProfileHelper.getUnitStaffIdentifier(request);

    if (unitStaffIdentifier != null) {
      setPresentationBranch(BRANCH_UNIT_SUMMARY_WORKLOAD, context);
    } else {
      setPresentationBranch(BRANCH_ASSIGNED_WORKLOAD, context);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method displays the Assigned Workload page.
   * </p>
   * <p>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CCMN14 - Retrieves Workload info</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayAssignedWorkload_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayAssignedWorkload_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    
    // Clear out unit staff identifier information
    try {
      UserProfileHelper.setUnitStaffIdentifier(null, request);
    } catch (UserProfileException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure clearing UnitStaffIdentifier:" + e.getMessage());
      processSevereException(context, e);
    }

    UserProfile user = UserProfileHelper.getUserProfile(context);
    displayWorkload(context, user.getUserID(), user.getUserFullName());

    // this is the conversation that the login page sends us to
    // the login page does NOT set appMode, so we need to set it
    GlobalData.setAppMode(PageModeConstants.EDIT, request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void displayWorkload(GrndsExchangeContext context, int ulIdPerson, String szFullName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayAssignedWorkload_xa");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    TuxedoPaginationValueBean tuxPagination = new TuxedoPaginationValueBean();
    ValueBeanHelper.populateDefaultValues(context, tuxPagination);
    tuxPagination.getResultDetails().setResultsPerPage(100);

    state.removeAllAttributes(request);

    // populateGlobalData(context);

    try {
      // Call the method to populate the ccmn14si object and pass in the UsPageNbr for pagination
      // SIR 19749 The workload report needs to know the name and ID we are using to view workload. Set
      // it into state
      state.setAttribute("workloadPersonID", ulIdPerson, request);
      state.setAttribute("workloadPersonName", szFullName, request);
      CCMN14SI ccmn14si = populateCCMN14S_Retrieve(context, tuxPagination, ulIdPerson);
      CCMN14SO ccmn14so = admin.findWorkloadInformation(ccmn14si);
      state.setAttribute("CCMN14SO", ccmn14so, request);
      // set the information into the pagination bean and then store it to the request
      tuxPagination.setPaginationInformation(ccmn14so.getArchOutputStruct(), ccmn14so.getROWCCMN37DO_ARRAY()
                                                                                     .getROWCCMN37DOCount());
    } catch (ServiceException se) {
      switch (se.getErrorCode()) {
      case Messages.MSG_CMN_EMPTY_WORKLOAD:
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
        processSevereException(context, se);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    // We need to store the pagination bean to the request here to keep the sortable column tag
    // from failing if we got a checked exception above.
    storePaginationBeanToRequest(context, tuxPagination);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method displays the Assigned Workload for a Designee selected from Unit Summary
   * </p>
   * <p>
   * The following services are used: <blockquote>
   * <ul>
   * <li>CCMN14 - Retrieves Workload info</li>
   * </ul>
   * </blockquote>
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void displayOtherAssignedWorkload_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayOtherAssignedWorkload_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    // UserProfile user = UserProfileHelper.getUserProfile(request);

    // the data in this field should be set by
    // UnitSummaryConversation.callAssignedWorkload_xa. If the data is present
    // the Workload page will display the workload of the person selected by
    // UnitSummary; if nothing is found, an IllegalStateException is thrown
    UnitStaffIdentifier unitStaffIdentifier = UserProfileHelper.getUnitStaffIdentifier(request);
    if (unitStaffIdentifier == null) {
      throw new IllegalStateException("No UnitStaffIdentifier found in session or state.");
    } else {
      String filterBy = ContextHelper.getStringSafe(request, "filterBy");
      request.setAttribute("filterBy", filterBy);
      if (FILTER_BY_INV_30.equals(filterBy)) {
        setInformationalMessage(Messages.MSG_FILTERED_INV_30,
                                "/workload/AssignedWorkload/displayOtherAssignedWorkload", request);
      } else if (FILTER_BY_SVC_60.equals(filterBy)) {
        setInformationalMessage(Messages.MSG_FILTERED_SVC_60,
                                "/workload/AssignedWorkload/displayOtherAssignedWorkload", request);
      }
      String strMessage = "You are currently viewing the workload of " + unitStaffIdentifier.getSzStaffNameFull() + ".";
      setInformationalMessage(strMessage, "/workload/AssignedWorkload/displayOtherAssignedWorkload", request);
      displayWorkload(context, unitStaffIdentifier.getUlIdStaff(), unitStaffIdentifier.getSzStaffNameFull());
    }

    // displayWorkload clears state, so PageMode should be set after that call.
    // JMC - SIR 19905 - We also need to set AppMode since Summary Workload should do the same
    // thing as Workload.
    GlobalData.setAppMode(PageModeConstants.EDIT, request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method is called when the user selects the stage name hyperlink.
   * </p>
   * <p>
   * The ccmn14so object is retrieved from state and the information needed to populate the Case Summary page is set
   * into Global Data.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void callCaseSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callCaseSummary_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);
      int index = Integer.parseInt(request.getParameter("index"));
      ROWCCMN37DO_ARRAY row37doArray;
      if (ccmn14so != null) {
        row37doArray = ccmn14so.getROWCCMN37DO_ARRAY();
      } else {
        row37doArray = new ROWCCMN37DO_ARRAY();
      }
      ROWCCMN37DO row37do;
      if (row37doArray.getROWCCMN37DOCount() > index || row37doArray.getROWCCMN37DOCount() == index) {
        row37do = row37doArray.getROWCCMN37DO(index);
      } else {
        row37do = new ROWCCMN37DO();
      }

      if (NEW_INDICATORS.contains(row37do.getBIndStagePersEmpNew())) {
        CCMN26SI ccmn26si = populateCCMN26SI_Update(context, row37do);
        person.updateIndStagePersEmpNew(ccmn26si);
      }

      GlobalData.setSzCdStage(row37do.getSzCdStage(), request);
      GlobalData.setSzCdStageProgram(row37do.getSzCdStageProgram(), request);
      GlobalData.setSzCdStageType(row37do.getSzCdStageType(), request);
      GlobalData.setSzNmStage(row37do.getSzNmStage(), request);
      GlobalData.setUlIdCase(row37do.getUlIdCase(), request);
      GlobalData.setUlIdStage(row37do.getUlIdStage(), request);
      GlobalData.setSzNmCase(row37do.getSzNmCase(), request);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method is called when the user selects the stage name hyperlink and there is no case id associated with the
   * stage.
   * </p>
   * <p>
   * The ccmn14so object is retrieved from state and the information needed to populate the Event List page is set into
   * Global Data.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void callEventList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".callEventList_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);
      int index = ContextHelper.getIntSafe(context, "index");
      ROWCCMN37DO_ARRAY row37doArray;
      if (ccmn14so != null) {
        row37doArray = ccmn14so.getROWCCMN37DO_ARRAY();
      } else {
        row37doArray = new ROWCCMN37DO_ARRAY();
      }
      ROWCCMN37DO row37do;
      if (row37doArray.getROWCCMN37DOCount() > index || row37doArray.getROWCCMN37DOCount() == index) {
        row37do = row37doArray.getROWCCMN37DO(index);
      } else {
        row37do = new ROWCCMN37DO();
      }
      // SPB - 3/6/2003 added for EventList
      GlobalData.setSzCdStageType(row37do.getSzCdStageType(), request);
      // Done
      GlobalData.setSzCdStage(row37do.getSzCdStage(), request);
      GlobalData.setSzNmStage(row37do.getSzNmStage(), request);
      GlobalData.setUlIdStage(row37do.getUlIdStage(), request);
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      GlobalData.setSzCdStageProgram(row37do.getSzCdStageProgram(), request);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method is called when the user clicks the Assign Stage button.
   * </p>
   * <p>
   * The ccmn14so object is retrieved from state and the information needed to populate the Assign page is set into
   * Global Data.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void assignStage_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".assignStage_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    try {
      CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);
      ROWCCMN37DO_ARRAY row37Array;
      if (ccmn14so != null) {
        row37Array = ccmn14so.getROWCCMN37DO_ARRAY();
      } else {
        row37Array = new ROWCCMN37DO_ARRAY();
      }

      String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbx");

      if (checkedValues.length != 0) {
        int[] stageIdArray = new int[checkedValues.length];
        for (int i = 0; i < checkedValues.length; i++) {
          int index = Integer.parseInt(checkedValues[i]);
          ROWCCMN37DO row37 = row37Array.getROWCCMN37DO(index);
          stageIdArray[i] = row37.getUlIdStage();
        }
        request.setAttribute("stageID", stageIdArray);
        GlobalData.setUlIdPerson(user.getUserID(), request);
      }
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This method is called when the user clicks the Stage Progression button.
   * </p>
   * <p>
   * The ccmn14so object is retrieved from state and the information needed to populate the Stage Progression page is
   * set into Global Data.
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object.
   */
  public void stageProgression_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".stageProgression_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    try {
      CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);
      String[] checkedValues = CheckboxHelper.getCheckedValues(request, "cbx");

      int index = ContextHelper.getIntSafe(request, "index");
      if (checkedValues.length != 0) {
        index = Integer.parseInt(checkedValues[0]);
      }
      ROWCCMN37DO_ARRAY row37doArray;
      if (ccmn14so != null) {
        row37doArray = ccmn14so.getROWCCMN37DO_ARRAY();
      } else {
        row37doArray = new ROWCCMN37DO_ARRAY();
      }
      ROWCCMN37DO row37do;

      if (row37doArray.getROWCCMN37DOCount() > index || row37doArray.getROWCCMN37DOCount() == index) {
        row37do = row37doArray.getROWCCMN37DO(index);
      } else {
        row37do = new ROWCCMN37DO();
      }
      
      if (INTAKE_STAGE.equals(row37do.getSzCdStage())){
        IntakeProgressionStatusSI intakeProgressionStatusSI = new IntakeProgressionStatusSI();
        intakeProgressionStatusSI.setIdStage(row37do.getUlIdStage());
        admin.checkIntakeProgressionStatus(intakeProgressionStatusSI);
      }
      
      // Set stage info into global data for next page
      GlobalData.setUlIdCase(row37do.getUlIdCase(), request);
      GlobalData.setUlIdStage(row37do.getUlIdStage(), request);
      GlobalData.setSzNmStage(row37do.getSzNmStage(), request);
      GlobalData.setSzNmCase(row37do.getSzNmCase(), request);
      GlobalData.setSzCdStage(row37do.getSzCdStage(), request);
      GlobalData.setSzCdStageProgram(row37do.getSzCdStageProgram(), request);
      GlobalData.setSzCdStageType(row37do.getSzCdStageType(), request);
      request.setAttribute("szCdStageReasonClosed", row37do.getSzCdStageReasonClosed());
      GlobalData.setUlIdPerson(user.getUserID(), request);
      request.removeAttribute(GRNDS_QNAME_ATTRIBUTE);
    } catch (ServiceException se) {
      setPresentationBranch(ERROR_STRING, context);
      setErrorMessage(se.getErrorCode(), request);
    }catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * <p>
   * This submethod populates the CCMN26SI object for the update service which updates the 'new' stage indicator on the
   * Assigned Workload
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object, the selected row
   * @param row37do
   * @return A popluated {@link CCMN26SI} object.
   */
  private CCMN26SI populateCCMN26SI_Update(GrndsExchangeContext context, ROWCCMN37DO row37do) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN26SI_Update");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CCMN26SI ccmn26si = new CCMN26SI();
    ROWCCMN52DI_ARRAY rowArray = new ROWCCMN52DI_ARRAY();
    ROWCCMN52DI row = new ROWCCMN52DI();

    row.setUlIdStage(row37do.getUlIdStage());
    row.setTsLastUpdate(row37do.getTsLastUpdate());
    rowArray.addROWCCMN52DI(row);

    UserProfile user = UserProfileHelper.getUserProfile(request);

    ArchInputStruct input = new ArchInputStruct();
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    input.setSzUserId(user.getUserLogonID());
    ccmn26si.setArchInputStruct(input);

    GlobalData.setUlIdPerson(user.getUserID(), request);
    ccmn26si.setUlIdPerson(GlobalData.getUlIdPerson(request));
    ccmn26si.setROWCCMN52DI_ARRAY(rowArray);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccmn26si;
  }

  /**
   * <p>
   * This submethod populates the CCMN14SI object for the retrieve service
   * </p>
   * 
   * @param context
   *          The <code>GrndeExchangeContext<code> object, pageNumber  (used for pagination)
   * @param tuxPagination
   * @param ulIdPerson
   * @return A populated {@link CCMN14SI} object.
   */
  private CCMN14SI populateCCMN14S_Retrieve(GrndsExchangeContext context, TuxedoPaginationValueBean tuxPagination,
                                            int ulIdPerson) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCMN14S_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    /* SIR#22557. added the session variable */
    HttpSession session = request.getSession();
    BaseSessionStateManager state = getSessionStateManager(context);

    UserProfile user = UserProfileHelper.getUserProfile(request);

    CCMN14SI ccmn14si = new CCMN14SI();
    ArchInputStruct input = new ArchInputStruct();
    ROWCCMN52DI rowccmn52di = new ROWCCMN52DI();
    ROWCCMN52DI_ARRAY rowccmn52di_array = new ROWCCMN52DI_ARRAY();

    input.setBPerfInd("Y");
    input.setBDataAcsInd("Y");

    input.setUsPageNbr(tuxPagination.getResultDetails().getRequestedPage());
    input.setUlPageSizeNbr(tuxPagination.getResultDetails().getResultsPerPage());

    input.setCReqFuncCd(ContextHelper.getStringSafe(request, "filterBy"));

    ccmn14si.setArchInputStruct(input);
    ccmn14si.setUlIdPerson(ulIdPerson);

    // skip UnitAccess for every workload call
    ccmn14si.setBSysIndSupervisor(ArchitectureConstants.N);
    if (user.getSysSupervisorAccess()) {
      ccmn14si.setBSysIndSupervisor(ArchitectureConstants.Y);
    }

    ccmn14si.setSzNbrUnit(user.getUserUnit());
    ccmn14si.setSzCdUnitProgram(user.getUserProgram());
    ccmn14si.setSzCdUnitRegion(user.getUserRegion());
    
    //-- sorting parameter
    String orderBy = ContextHelper.getStringSafe(context, "orderBy");
    if("".equals(orderBy)) {
      String fromSession = (String) session.getAttribute(WORKLOAD_SORT_BY);
      orderBy = fromSession != null ? fromSession : DynamicWorkloadDAO.SORT_BY_DEFAULT;
    }
    ccmn14si.setBWcdCdSortBy(orderBy);
    tuxPagination.getResultDetails().setOrderBy(orderBy);
    state.setAttribute("workloadSortOrder", orderBy, request);
    session.setAttribute(WORKLOAD_SORT_BY, orderBy);
    
    java.util.Date d1 = new Date();
    rowccmn52di.setTsLastUpdate(d1);

    // Add the struct to the array
    rowccmn52di_array.addROWCCMN52DI(rowccmn52di);
    // Set the array into the parent struct
    ccmn14si.setROWCCMN52DI_ARRAY(rowccmn52di_array);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccmn14si;
  }
}
