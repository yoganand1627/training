package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * Defines the 2nd and 3rd Level tabs used in SACWIS.
 *
 * @author Dann W. Webster
 * @version 1.0
 */
public final class MetaphorTabs {

  // Case Types
  public static final String ADO = "ADO";
  public static final String AOC = "AOC";
  public static final String ARF = "ARF";
  public static final String ARI_AFC = "ARI_AFC";
  public static final String ARI_APS = "ARI_APS";
  public static final String ARI_RCL = "ARI_RCL";
  public static final String ARI_CCL = "ARI_CCL";
  public static final String ARI_CPS = "ARI_CPS";
  public static final String DIV = "DIV";
  public static final String FAD = "FAD";
  public static final String FPR = "FPR";
  public static final String FRE = "FRE";
  public static final String FSU = "FSU";
  public static final String I_R = "I&R";
  public static final String INT = "INT";
  public static final String INV_AFC = "INV_AFC";
  public static final String INV_APS = "INV_APS";
  public static final String INV_CCL = "INV_CCL";
  public static final String INV_CPS = "INV_CPS";
  public static final String INV_RCL = "INV_RCL";
  public static final String PAD = "PAD";
  public static final String PAL = "PAL";
  public static final String PFC = "PFC";
  public static final String SPC = "SPC";
  public static final String SUB = "SUB";
  public static final String SVC = "SVC";

  // Tab attribute names
  public static final String LEVEL_1_TAB_ATTRIBUTE_NAME = "level1Tab";
  public static final String LEVEL_2_TAB_ATTRIBUTE_NAME = "level2Tab";
  public static final String LEVEL_3_TAB_ATTRIBUTE_NAME = "level3Tab";
  public static final String USER_ID_ATTRIBUTE_NAME = "userId";
  public static final String PASSWORD_ATTRIBUTE_NAME = "password";
  public static final String ID_NUMBER_ATTRIBUTE_NAME = "idNumber";
  public static final String STAGE_TYPE_ATTRIBUTE_NAME = "stageType";
  public static final String RESOURCE_TYPE_ATTRIBUTE_NAME = "resourceType";
  public static final String TRACE_TAG = "MetaphorTabs.";

  private MetaphorTabs() {
    // Such that MetaphorTabs cannot be instantiated (or subclassed) but can still be accessed from NavInit
  }

  private static BaseSessionStateManager state = null;

  public static Iterator<TabInfo> getLevel1Tabs(UserProfile profile) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    tabs.add(Nav.getTabInfo(TabConstants.MY_TASKS_ASSIGNEDWORKLOAD));
    tabs.add(Nav.getTabInfo(TabConstants.CASE_CASESEARCH));
    tabs.add(Nav.getTabInfo(TabConstants.SEARCH_PERSONSEARCH));
    if (profile.hasRight(UserProfile.SEC_REC_CALL)) {
      tabs.add(Nav.getTabInfo(TabConstants.INTAKE_INTAKE));
    }
    if (!profile.hasRight(UserProfile.SEC_RESTRICT_FINANCIAL)){
      tabs.add(Nav.getTabInfo(TabConstants.FINANCIAL_CONTRACTSEARCH));
    }
    tabs.add(Nav.getTabInfo(TabConstants.REPORTS_REPORTLIST));
    if (!profile.hasRight(UserProfile.SEC_RESTRICT_RESOURCE)){
      tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_RESOURCESEARCH));
    }
    return tabs.iterator();
  }

  public static Iterator<TabInfo> getLevel2Tabs(UserProfile profile, int level1Tab, int level2Tab, String property,
                                                HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + "getLevel2Tabs()");
    state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    List<TabInfo> tabs;

    switch (level1Tab) {
      case TabConstants.MY_TASKS_ASSIGNEDWORKLOAD:
        tabs = getMyTasksTabs(profile);
        break;
      case TabConstants.CASE_CASESEARCH:
        //GrndsTrace.msg(TRACE_TAG, 8, "L1 is CASE : profile, level2Tab, idNumber, property : " +
        //                             profile.getUserLogonID() + "," + level2Tab + "," + property);
        tabs = CaseTabs.getLevel2CaseTabs(profile, level2Tab, property, request);
        break;
      case TabConstants.SEARCH_PERSONSEARCH:
        tabs = getSearchTabs(profile);
        break;
      case TabConstants.INTAKE_INTAKE:
        tabs = getIntakeTabs();
        break;
      case TabConstants.FINANCIAL_CONTRACTSEARCH:
        tabs = getFinancialTabs(profile);
        break;
      case TabConstants.REPORTS_REPORTLIST:
        tabs = getReportsTabs();
        break;
      case TabConstants.RESOURCE_RESOURCESEARCH:
        tabs = getResourcesTabs(level2Tab, request);
        break;
      default:
        tabs = new LinkedList<TabInfo>();
        break;
    }
    GrndsTrace.exitScope();
    return tabs.iterator();
  }

  protected static List<TabInfo> getMyTasksTabs(UserProfile profile) {
    GrndsTrace.enterScope(TRACE_TAG + "getMyTasksTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    // If GD.ulIdPersonId == GD.ulIdWrkldPersonId
    // for designee workload, only show workload, staff to-do list, and unit summary
    // 2nd level tab, else show all other 2nd level tabs
    tabs.add(Nav.getTabInfo(TabConstants.WORKLOAD_ASSIGNEDWORKLOAD));
    tabs.add(Nav.getTabInfo(TabConstants.STAFF_TO_DO_LIST_TODCMNTTN));
    if (profile.hasRight(UserProfile.SEC_UNIT_SUMMARY_ACCESS)) {
      tabs.add(Nav.getTabInfo(TabConstants.UNIT_SUMMARY_UNITSUMMARY));
    }
    if (profile.hasRight(UserProfile.SEC_UNIT_SUMMARY_ACCESS) || profile.hasRight(UserProfile.SEC_MNTN_UNIT)) {
      tabs.add(Nav.getTabInfo(TabConstants.UNIT_MAINTENANCE_UNITMNT));
    }
    // || || SEC_BROWSE_SEC
    if (profile.hasRight(UserProfile.SEC_MNTN_LOGIN) || profile.hasRight(UserProfile.SEC_CHG_USER_CLASS)
        || profile.hasRight(UserProfile.SEC_BROWSE_SEC)) {
      tabs.add(Nav.getTabInfo(TabConstants.STAFF_SECURITY_MAINTENANCE_STAFFSECURITYMN));
    }
    if (profile.hasRight(UserProfile.SEC_MNTN_SEC_PROFILE) || profile.hasRight(UserProfile.SEC_BROWSE_SEC)) {
      tabs.add(Nav.getTabInfo(TabConstants.SECURITY_PROFILE_MAINTENANCE_SECURITYPROFILEMNT));
    }
    if (profile.hasRight(UserProfile.SEC_MNTN_SEC)) {
      tabs.add(Nav.getTabInfo(TabConstants.MAINTAIN_DESIGNEE_MNTAINDESIGNEE));
    }
    if (profile.hasRight(UserProfile.SEC_MNTN_SEC_PROFILE) || profile.hasRight(UserProfile.SEC_BROWSE_SEC)) {
      tabs.add(Nav.getTabInfo(TabConstants.CODES_TABLES_MAINTENANCE_CODESTABLESMNT));
    }

    GrndsTrace.exitScope();
    return tabs;
  }

  protected static List<TabInfo> getSearchTabs(UserProfile profile) {
    GrndsTrace.enterScope(TRACE_TAG + "getSearchTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONSEARCH));
    // SPB SIR 18357
    if (!profile.hasRight(UserProfile.SEC_RESTRICT_RESOURCE)){
      tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_SEARCH_SEARCH));
    }
    if (profile.hasRight(UserProfile.SEC_MTN_HOME) || profile.hasRight(UserProfile.SEC_EMERG_PLCMT)) {
      tabs.add(Nav.getTabInfo(TabConstants.F_A_HOME_FAHOMESEARCH));
    }
    if (profile.hasRight(UserProfile.SEC_SAU_EXCHANGE) || profile.hasRight(UserProfile.SEC_ADO_VIEW)) {
      tabs.add(Nav.getTabInfo(TabConstants.EXCHANGE_HOME_SEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.EXCHANGE_CHILD_SEARCH));
    }
    tabs.add(Nav.getTabInfo(TabConstants.STAFF_SEARCH_STAFFSEARCH));
    if (!profile.hasRight(UserProfile.SEC_RESTRICT_FINANCIAL)){
      tabs.add(Nav.getTabInfo(TabConstants.CONTRACT_CONTRACTSEARCH_CONTRACTSEARCH));
    }
    tabs.add(Nav.getTabInfo(TabConstants.ON_CALL_ONCALL));
    if (!profile.hasRight(UserProfile.SEC_RESTRICT_CASE_SEARCH)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SEARCHSEARCH_CASESEARCH));
    }
       
    GrndsTrace.exitScope();
    return tabs;
  }

  protected static List<TabInfo> getIntakeTabs() {
    GrndsTrace.enterScope(TRACE_TAG + "getIntakeTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    tabs.add(Nav.getTabInfo(TabConstants.CALL_INFORMATION_CALLINFRMTN));
    tabs.add(Nav.getTabInfo(TabConstants.INTAKE_ACTIONS_INTAKEACTIONS));
    tabs.add(Nav.getTabInfo(TabConstants.CALL_LOG_CALLLOG));
    GrndsTrace.exitScope();
    return tabs;
  }

  protected static List<TabInfo> getFinancialTabs(UserProfile profile) {
    GrndsTrace.enterScope(TRACE_TAG + "getFinancialTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    tabs.add(Nav.getTabInfo(TabConstants.CONTRACT_CONTRACTSEARCH_CONTRACTSEARCH));
    if (profile.hasRight(UserProfile.SEC_FIN_BROWSE_INVOICE) || profile.hasRight(UserProfile.SEC_FIN_MODIFY_INVOICE)) {
      tabs.add(Nav.getTabInfo(TabConstants.INVOICE_SEARCH_INVOICESEARCH));
    }
    if (profile.hasRight(UserProfile.SEC_FIN_MODIFY_CPS_PAY_APPVL)) {
      tabs.add(Nav.getTabInfo(TabConstants.PAYMENT_APPROVAL_PYMNTAPPROVAL));
    }
    if (profile.hasRight(UserProfile.SEC_FIN_BROWSE_PAY_HIST)) {
      tabs.add(Nav.getTabInfo(TabConstants.PAYMENT_HISTORY_PYMNTHISTORY));
    }
    if (profile.hasRight(UserProfile.SEC_BROWSE_COUNTY_BUDGET_LIMIT) || profile.hasRight(UserProfile.SEC_MODIFY_COUNTY_BUDGET_LIMIT)){
      tabs.add(Nav.getTabInfo(TabConstants.COUNTY_BUDGET_LIMIT_SEARCH_COUNTYBUDGETLIMITSEARCH));
    }
    tabs.add(Nav.getTabInfo(TabConstants.TCM_CLAIMS_TCMCLAIMS));
    GrndsTrace.exitScope();
    return tabs;
  }

  protected static List<TabInfo> getReportsTabs() {
    GrndsTrace.enterScope(TRACE_TAG + "getReportsTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    tabs.add(Nav.getTabInfo(TabConstants.REPORT_LAUNCH_REPORTLIST));
    tabs.add(Nav.getTabInfo(TabConstants.REPORT_LIST_REPORTLIST));
    GrndsTrace.exitScope();
    return tabs;
  }

  protected static List<TabInfo> getResourcesTabs(int level2Tab, HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + "getResourcesTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();

    // Needed to determine whether to show the facility detail tab or not
    String resourceType = "";

    if (state.getAttribute(RESOURCE_TYPE_ATTRIBUTE_NAME, request) != null) {
      resourceType = (String) state.getAttribute(RESOURCE_TYPE_ATTRIBUTE_NAME, request);
    }
    tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_SEARCH_RESOURCESEARCH));
    tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_ORS_SEARCH_SEARCH));
    // If L2 tab is NOT Resource Search, show all L2 tabs
    if (level2Tab != TabConstants.RESOURCE_SEARCH_RESOURCESEARCH && 
                    level2Tab != TabConstants.RESOURCE_ORS_SEARCH_SEARCH &&
                    level2Tab != TabConstants.RESOURCE_ORS_DETAIL_RESOURCEDETAIL &&
                    level2Tab != TabConstants.PENDING_PORTAL_ADMIN_LIST) {
      tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_DETAIL_RESOURCEDETAIL));
      // If resource type is Other or MHMR, add facility tab
      if ("06".equals(resourceType) || "05".equals(resourceType)) {
        tabs.add(Nav.getTabInfo(TabConstants.FACILITY_DETAIL_FACILITY));
      }
      tabs.add(Nav.getTabInfo(TabConstants.SERVICES_BY_AREA_SERVICESBYAREA));
    } else if(level2Tab == TabConstants.RESOURCE_ORS_DETAIL_RESOURCEDETAIL) {
      tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_ORS_DETAIL_RESOURCEDETAIL));
    } else {
      tabs.add(Nav.getTabInfo(TabConstants.PENDING_PORTAL_ADMIN_LIST));
    }
    GrndsTrace.exitScope();
    return tabs;
  }

  public static Iterator<TabInfo> getLevel3Tabs(UserProfile profile, int level1Tab, int level2Tab, String stageType,
                                                HttpServletRequest request) {
    return Level3Tabs.getLevel3Tabs(profile, level1Tab, level2Tab, stageType, request).iterator();
  }
}