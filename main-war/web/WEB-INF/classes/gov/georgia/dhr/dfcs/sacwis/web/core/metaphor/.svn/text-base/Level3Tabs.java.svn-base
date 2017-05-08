package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UnitStaffIdentifier;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

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
      case TabConstants.MY_TASKS_CHILD_LIST:
        l3Tabs = Level3Tabs.getMyTasksTabs(level2Tab, request);
        break;
      case TabConstants.CASE:
        l3Tabs = Level3Tabs.getCaseTabs(level2Tab, request);
        break;
      case TabConstants.ADMIN:
        l3Tabs = Level3Tabs.getAdminTabs(level2Tab, request);
        break;
      default:
        l3Tabs = new LinkedList<TabInfo>();
        break;
    }
    return l3Tabs;
  }

  protected static List<TabInfo> getMyTasksTabs(int level2Tab, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    if ((level2Tab == TabConstants.FAC_AGENCY_LIST) && !(("".equals(GlobalData.getUlIdParentRsrcAsString(request))||"0".equals(GlobalData.getUlIdParentRsrcAsString(request))))) {
      
      tabs.add(Nav.getTabInfo(TabConstants.CHILD_LIST_SPECIFIC));
      tabs.add(Nav.getTabInfo(TabConstants.HOMES_LIST));
      }
    
    return tabs;
  }

  protected static List<TabInfo> getAdminTabs(int level2Tab, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    if ((level2Tab == TabConstants.STAFF_LIST)&& !(("".equals(GlobalData.getUlIdStaffAsString(request))||"0".equals(GlobalData.getUlIdStaffAsString(request))))) {  
      tabs.add(Nav.getTabInfo(TabConstants.VENDOR_STAFF_DETAIL));
    }else if ((level2Tab == TabConstants.PENDING_STAFF_LIST)&& !(("".equals(GlobalData.getUlIdStaffAsString(request))||"0".equals(GlobalData.getUlIdStaffAsString(request))))) {
      tabs.add(Nav.getTabInfo(TabConstants.PENDING_STAFF_DETAIL));
    }
  return tabs;
  } 
  
  protected static List<TabInfo> getCaseTabs(int level2Tab, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    
  return tabs;
  }

}

  
  
  