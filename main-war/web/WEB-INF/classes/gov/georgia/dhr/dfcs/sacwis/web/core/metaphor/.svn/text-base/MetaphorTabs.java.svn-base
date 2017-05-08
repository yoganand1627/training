package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
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
    if (profile.hasRight(UserProfile.NYTD_USER)) {
    	tabs.add(Nav.getTabInfo(TabConstants.USER_PROFILE_DETAIL));
    	tabs.add(Nav.getTabInfo(TabConstants.PORTAL_SURVEY_DETAIL));
    	return tabs.iterator();
    }
    tabs.add(Nav.getTabInfo(TabConstants.MY_TASKS_CHILD_LIST));
    tabs.add(Nav.getTabInfo(TabConstants.CASE));
    tabs.add(Nav.getTabInfo(TabConstants.ADMIN));
    
    return tabs.iterator();
  }

  public static Iterator<TabInfo> getLevel2Tabs(UserProfile profile, int level1Tab, int level2Tab, String property,
                                                HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + "getLevel2Tabs()");
    state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    List<TabInfo> tabs;

    switch (level1Tab) {
    case TabConstants.MY_TASKS_CHILD_LIST:
      tabs = getMyTasksTabs(profile);
      break;
    case TabConstants.CASE:
      tabs = getCaseTabs(profile);
      break;
    case TabConstants.ADMIN:
      tabs = getAdminTabs(profile);
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
        tabs.add(Nav.getTabInfo(TabConstants.CHILD_LIST_ALL));
        tabs.add(Nav.getTabInfo(TabConstants.FAC_AGENCY_LIST));
        
    GrndsTrace.exitScope();
    return tabs;
  }

  protected static List<TabInfo> getAdminTabs(UserProfile profile) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
      tabs.add(Nav.getTabInfo(TabConstants.STAFF_LIST));
      
      if (profile.hasRight(UserProfile.PLCMNT_PRV_ADMIN)) {
        tabs.add(Nav.getTabInfo(TabConstants.PENDING_STAFF_LIST));
      }
    
  return tabs;
  } 
  
  protected static List<TabInfo> getCaseTabs(UserProfile profile) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    tabs.add(Nav.getTabInfo(TabConstants.PORTAL_CHILD_DETAIL));
  return tabs;
  } 

  
  
  public static Iterator<TabInfo> getLevel3Tabs(UserProfile profile, int level1Tab, int level2Tab, String stageType,
                                                HttpServletRequest request) {
    return Level3Tabs.getLevel3Tabs(profile, level1Tab, level2Tab, stageType, request).iterator();
  }
}