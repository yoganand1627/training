package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * Determines which 2nd level tabs as well as which 3rd-level Tabs get displayed for 2nd-level tabs under the 1st-level
 * Tab 'CASE'
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  10/26/09  pcoogan   Created for SHINES Portal 
 * </pre>
 *
 * @author Patrick Coogan
 * @version 1.0
 */
public abstract class CaseTabs {
  public static final String TRACE_TAG = "CaseTabs.";

  protected static List<TabInfo> getLevel3CaseTabs(int level2Tab, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    
    return tabs;
  }

  /**
   * Gets the L2 tabs for a given stage type and program code. Defaults to Case Search if the caseNumber is null or
   * blank, if the L2 tab id is 0, or if the user doesn't have SEC_RESTRICT_CASE_SEARCH permissions.
   */
  protected static List<TabInfo> getLevel2CaseTabs(UserProfile profile, int level2Tab,
                                                   HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + " Calling *** getLevel2CaseTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    
   
    GrndsTrace.msg(TRACE_TAG, 8, "level2Tab is == " + level2Tab);
    
    if (!"".equals(GlobalData.getUlIdPersonAsString(request))){ 
      tabs.add(Nav.getTabInfo(TabConstants.PORTAL_CHILD_DETAIL));
    } else {
      tabs.add(Nav.getTabInfo(TabConstants.CHILD_LIST_ALL));  
    }
    
    GrndsTrace.exitScope();
    return tabs;
  }
}