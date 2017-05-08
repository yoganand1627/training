package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Parameter;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenDefinitionsXmlDao;

/**
 * Accesses TabInfo and NavTask objects. Also accesses Hashmaps mapping tabIDs to tab constant names and vice versa.
 *
 * @author Stephan Brauchli
 * @version 1.0
 */

public class Nav {
  private static final String TRACE_TAG = "Nav";

  protected static final String JNDI_FILTERCLASS_NAME = "filterClassJndiName";

  private static Map<String, TabInfo> tabIdToTabInfoMap = null;
  private static Map<String, String> filterClassMap = null;
  private static Map<String, NavTask> taskCdToNavTaskMap = null;
  private static Map<String, Integer> tabConstantToTabIdMap = null;
  private static Map<String, String> tabIdToTabConstantMap = null;
  private static Map<IdTriple, String> tripleToTaskCodeMap = null;

  protected static String getJspUrl(HttpServletRequest request) {
    Screen screen = (Screen) request.getAttribute(ScreenDefinitionsXmlDao.SCREEN);
    Parameter parameter = screen.getParameter("HtmlBody");
    return parameter.getValue();
  }

  /**
   * Gets the TabInfo bean from the tabID2TabInfo map for a given Tab ID
   *
   * @return TabInfo SPB 1/27/03
   */
  public static TabInfo getTabInfo(String tabCode) {
    return tabIdToTabInfoMap.get(tabCode);
  }

  public static Map getTabInfoMap() {
    return tabIdToTabInfoMap;
  }

  public static void setIdToTabInfoMap(Map<String, TabInfo> tabIdToTabInfoMap) {
    Nav.tabIdToTabInfoMap = tabIdToTabInfoMap;
  }

  /**
   * Gets a hashmap of TabInfo beans from the tabID2TabInfo map
   *
   * @return HashMap SPB 1/27/03
   */
  public static Map getTabInfos() {
    return tabIdToTabInfoMap;
  }

  /**
   * Gets the TabInfo bean for a given Tab ID
   *
   * @return TabInfo SPB 1/27/03
   */
  public static TabInfo getTabInfo(int tabCode) {
    return getTabInfo(String.valueOf(tabCode));
  }

  /**
   * Gets the TabInfo bean from the map for a given Tab ID
   *
   * @return TabInfo SPB 1/27/03
   */
  public static TabInfo getTabInfoForId(String tabId) {
    return tabIdToTabInfoMap.get(tabId);
  }

  /**
   * Gets the NavTask bean for a given Tab ID (String)
   *
   * @return NavTask SPB 1/27/03
   */
  public static NavTask getNavTask(String tabCode) {
    return taskCdToNavTaskMap.get(tabCode);
  }

  static void setTaskCdToNavTaskMap(Map<String, NavTask> taskCdToNavTaskMap) {
    Nav.taskCdToNavTaskMap = taskCdToNavTaskMap;
  }

  /**
   * Gets the NavTask bean for a given Tab ID (int)
   *
   * @return NavTask SPB 1/27/03
   */
  public static NavTask getNavTask(int tabCode) {
    return getNavTask(String.valueOf(tabCode));
  }

  /**
   * Gets the Tab ID for a given Tab Constant name
   *
   * @return String SPB 1/27/03
   */
  public static String getTabIdUsingConstant(String tabConstant) {
    return String.valueOf(tabConstantToTabIdMap.get(tabConstant));
  }

  static void setTabConstantToTabIdMap(Map<String, Integer> tabConstantToTabIdMap) {
    Nav.tabConstantToTabIdMap = tabConstantToTabIdMap;
  }

  /**
   * Gets the Tab Constant name for a given Tab ID
   *
   * @return String SPB 1/27/03
   */
  public static String getTabConstantUsingTabId(String tabId) {
    return String.valueOf(tabIdToTabConstantMap.get(tabId));
  }

  static void setTabIdToTabConstantMap(Map<String, String> tabIdToTabConstantMap) {
    Nav.tabIdToTabConstantMap = tabIdToTabConstantMap;
  }

  static void setTripleToTaskCodeMap(Map<IdTriple, String> tripleToTaskCodeMap) {
    Nav.tripleToTaskCodeMap = tripleToTaskCodeMap;
  }

  static void setFilterClassMap(Map<String, String> filterClassMap) {
    Nav.filterClassMap = filterClassMap;
  }

  /**
   * Gets the Task Code for a given Triple
   *
   * @return String SPB 1/27/03
   */
  public static String getTaskCodeForTriple(IdTriple iTrip) {
    return tripleToTaskCodeMap.get(iTrip);
  }

  /**
   * Determines whether to show a tab depending on the filter class (if any) that the tab requires.
   *
   * @return boolean SPB 2/18/03
   */
  public static boolean showTab(String tabId, HttpServletRequest request) {
    try {
      String filterClassName = filterClassMap.get(tabId);
      if (filterClassName != null) {
        Class aClass = Class.forName(filterClassName);
        ShowTab showTab = (ShowTab) aClass.newInstance();
        return showTab.showTab(tabId, request);
      } else {
        return true;
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 8, "Exception showing tab: " + tabId + "\n" + e.getMessage());
      //e.printStackTrace();
      return true;
    }
  }
}
