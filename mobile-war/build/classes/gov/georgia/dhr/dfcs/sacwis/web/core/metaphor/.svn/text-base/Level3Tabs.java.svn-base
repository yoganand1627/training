package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UnitStaffIdentifier;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Populates Data into Level3Tabs
 * <p/>
 * <pre>
 *  Change History
 *  Date      Fixer        Description
 *  6/30/2004 gerryc       SIR 19651 - use new PLACEMENT_LOG_RESOURCE instead of fad placement log so that the screen
 *                         definitions from resource are used, and Resource Name is displayed instead of case name.
 *  11/9/2009 pcoogan      ECEM: Adding in vendor staff list views for SHINES Vendor Portal.                       
 * </pre>
 *
 * @author Dann Webster
 * @version 1.0
 */
public abstract class Level3Tabs {
  public static List<TabInfo> getLevel3Tabs(UserProfile profile, int level1Tab, int level2Tab, String stageType,
                                            HttpServletRequest request) {
    List<TabInfo> l3Tabs;
    switch (level1Tab) {
      case TabConstants.MY_TASKS_ASSIGNEDWORKLOAD:
        l3Tabs = Level3Tabs.getMyTasksTabs(level2Tab, request);
        break;
      case TabConstants.CASE_CASESEARCH:
        l3Tabs = CaseTabs.getLevel3CaseTabs(level2Tab, stageType, request);
        break;
      case TabConstants.INTAKE_INTAKE:
        l3Tabs = Level3Tabs.getIntakeTabs(profile, level2Tab);
        break;
      case TabConstants.FINANCIAL_CONTRACTSEARCH:
        l3Tabs = Level3Tabs.getFinancialTabs(level2Tab);
        break;
      case TabConstants.SEARCH_PERSONSEARCH:
        l3Tabs = Level3Tabs.getSearchTabs(profile, level2Tab, request);
        break;
      case TabConstants.REPORTS_REPORTLIST:
        l3Tabs = Level3Tabs.getReportsTabs(level2Tab);
        break;
      case TabConstants.RESOURCE_RESOURCESEARCH:
        l3Tabs = Level3Tabs.getResourceTabs(level2Tab);
        break;
      default:
        l3Tabs = new LinkedList<TabInfo>();
        break;
    }
    return l3Tabs;
  }

  protected static List<TabInfo> getMyTasksTabs(int level2Tab, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    if (level2Tab == TabConstants.UNIT_SUMMARY_UNITSUMMARY) {
      UnitStaffIdentifier unitStaffIdentifier = UserProfileHelper.getUnitStaffIdentifier(request);
      tabs.add(Nav.getTabInfo(TabConstants.UNIT_SUMMARY_3_UNITSUMMARY));
      if (unitStaffIdentifier != null) {
        tabs.add(Nav.getTabInfo(TabConstants.WORKLOAD_OTHER_ASSIGNEDWORKLOAD_OTHER));
        tabs.add(Nav.getTabInfo(TabConstants.STAFF_TO_DO_LIST_TODCMNTTN_OTHER));
      }
    }
    if(level2Tab == TabConstants.CODES_TABLES_MAINTENANCE_CODESTABLESMNT){
      tabs.add(Nav.getTabInfo(TabConstants.CODES_TABLES_MAINTENANCE_3_CODESTABLESMNT));
    }
    return tabs;
  }

  protected static List<TabInfo> getSearchTabs(UserProfile profile, int level2Tab, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    switch (level2Tab) {
      case TabConstants.PERSON_PERSONSEARCH:
        tabs.add(Nav.getTabInfo(TabConstants.PERSON_DETAIL_PERSONDETAIL));
        tabs.add(Nav.getTabInfo(TabConstants.RECORDS_CHECK_RECORDSCHECK));
        int idPerson = GlobalData.getUlIdPerson(request);
        // FIXME: This should almost certainly be in a ShowTab instance.
        BaseSessionStateManager state =
                (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
        String thirdLevelPSA = (String) state.getContextParameter("_activePSA" + idPerson, request);
        if (ArchitectureConstants.Y.equals(thirdLevelPSA)) {
          tabs.add(Nav.getTabInfo(TabConstants.PROTECTIVE_SERVICE_ALERT));
        }
        // add Youth Detail tab entry; filter is done through PersonDtlShowTab
        tabs.add(Nav.getTabInfo(TabConstants.YOUTH_DETAIL));
        break;
      case TabConstants.STAFF_SEARCH_STAFFSEARCH:
        tabs.add(Nav.getTabInfo(TabConstants.STAFF_DETAIL_STAFFSEARCH));
        if (profile.hasRight(UserProfile.SEC_EMPL_REC_CHECK)) {
          tabs.add(Nav.getTabInfo(TabConstants.RECORDS_CHECK_RECORDSCHECK));
        }
        break;
    }

    return tabs;
  }

  protected static List<TabInfo> getIntakeTabs(UserProfile profile, int level2Tab) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    // added 3/13/2003 SPB
    if (level2Tab == TabConstants.CALL_INFORMATION_CALLINFRMTN) {
      tabs.add(Nav.getTabInfo(TabConstants.CALL_PERSON_DETAIL_REDISPLAY));
      tabs.add(Nav.getTabInfo(TabConstants.INCOMING_PERSON_DETAIL_INCOMING));
      if (profile.hasRight(UserProfile.SEC_EMPL_REC_CHECK)) {
        tabs.add(Nav.getTabInfo(TabConstants.RECORDS_CHECK_RECORDSCHECK));
      }
    }
    return tabs;
  }

  protected static List<TabInfo> getFinancialTabs(int level2Tab) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    switch (level2Tab) {
      case TabConstants.CONTRACT_CONTRACTSEARCH_CONTRACTSEARCH:
        tabs.add(Nav.getTabInfo(TabConstants.CONTRACT_CONTRACTSEARCH_3_CONTRACTS));
        break;
      case TabConstants.INVOICE_SEARCH_INVOICESEARCH:
        tabs.add(Nav.getTabInfo(TabConstants.INVOICE_INVOICE));
        break;
      case TabConstants.PAYMENT_APPROVAL_PYMNTAPPROVAL:
        // added SPB 3/18/03
        tabs.add(Nav.getTabInfo(TabConstants.INVOICE_INVOICE));
        break;
      case TabConstants.PAYMENT_HISTORY_PYMNTHISTORY:
        tabs.add(Nav.getTabInfo(TabConstants.INVOICE_INVOICE));
        break;
      case TabConstants.FINANCIAL_ACCOUNT_FINANCIALACCT:
        // end SPB
        tabs.add(Nav.getTabInfo(TabConstants.FINANCIAL_ACCOUNT_DETAIL_FINANCIALACCT));
        tabs.add(Nav.getTabInfo(TabConstants.FINANCIAL_ACCOUNT_REGISTER_FINANCIALACCT));
        break;
    }
    return tabs;
  }

  protected static List<TabInfo> getReportsTabs(int level2Tab) {
    // FIXME: This doesn't do anything.
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    if (level2Tab == TabConstants.REPORT_LIST_REPORTLIST) {
      // No L3
    }
    return tabs;
  }

  protected static List<TabInfo> getResourceTabs(int level2Tab) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    if (level2Tab == TabConstants.FACILITY_DETAIL_FACILITY) {
      tabs.add(Nav.getTabInfo(TabConstants.FACILITY_DETAIL_3_FACILITY));
      // SIR 19651 - use new PLACEMENT_LOG_RESOURCE instead of fad placement log
      tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_LOG_RESOURCE_PLACEMENTLOG));
      //added tab for Caretaker Information.
      tabs.add(Nav.getTabInfo(TabConstants.CARETAKER_INFMTN_DTL));      
      tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_REFERRAL_LOG));
    }
    if (level2Tab == TabConstants.RESOURCE_DETAIL_RESOURCEDETAIL) {
      tabs.add(Nav.getTabInfo(TabConstants.RESOURCE_DETAIL_RESOURCEDETAIL_3));
      tabs.add(Nav.getTabInfo(TabConstants.VENDOR_STAFF_LIST));      
      tabs.add(Nav.getTabInfo(TabConstants.PENDING_VENDOR_STAFF_LIST));
    }
    return tabs;
  }
}