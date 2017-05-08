package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.NonPrsExceptionWrapper;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Initializable;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Destroyable;

/**
 * <p>Title: </p> <p>Description: Populates the TabMap with TabInfo beans and TabIDs read from a .csv file, then
 * populates the NavMap with NavTask beans and TaskCDs read from the TASK table. Also creates a map mapping tab IDs to
 * tab constants, as well as another map mapping tab constants to tab IDs. </p> <p>Copyright: Copyright (c) 2002</p>
 *
 * @author Stephan Brauchli
 * @version 1.0
 */
/*
 * Change History:
*  Date      User      Description
*  --------  --------  --------------------------------------------------
* 04/18/05   ACodrea   Sir NA - Setting the default fetch size in the
*                      statement. It is needed for Oracle 10g driver.
* 05/12/05   werlem    Sir NA - Fixed exception handling and made an
*                      init() method so we could reinitialize for mobile.
* <pre>
*/

public class NavInit implements Initializable, Destroyable {
  public static final String TRACE_TAG = "NavInit.";

  public static final String CASE_STAGE_MAINT = "4444";

  public static final Field[] fields = TabConstants.class.getFields();

  public void initialize(ServletContext servletContext) throws BasePrsException {
    try {
      // Sets both the tabMap and the filterClassMap
      populateTabInfoAndFilterMaps();

      // Maps task Codes to NavTask objects
      populateTrippleToTaskCodesMapAndNavMap();

      // Maps tab constants to tab IDs
      populateTabIdMap();

      // Maps tab IDs to tab constants
      populateTabConstantMap();
    } catch (Exception e) {
      String msg = "Exception occurred in NavInit!";
      GrndsTrace.msg(TRACE_TAG, 8, msg);
      throw new NonPrsExceptionWrapper(msg, e, BasePrsException.CRITICAL_PRIORITY);
    }
  }

  /**
   * Populates the NavMap with NavTask beans and TaskCDs read from the TASK table NavTask beans correspond to a set of 3
   * tabs and contain the Level 1, Level 2, Level 3 IDs which correspond to the TabIDs in TabMap. Each ID uniquely
   * identifies a TabInfoBean.  NavTask also contains the program code, stage type, and taskCd.
   *
   * @return NavMap SPB 1/8/03
   */
  private static void populateTrippleToTaskCodesMapAndNavMap() throws SQLException {
    Connection connection = null;
    ResultSet results = null;
    PreparedStatement statement = null;
    Map<IdTriple, String> tripleToTaskCodeMap = new HashMap<IdTriple, String>();
    Map<String, NavTask> navMap = new HashMap<String, NavTask>();
    try {
      connection = JdbcHelper.getConnection();

      String sql =
              "select CD_TASK, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_CODE_PREFER, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB from TASK";

      statement = connection.prepareStatement(sql);

      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(350);

      results = statement.executeQuery();

      // Currently, there are 329 rows, so always guarantee that we get the whole table at once
      results.setFetchSize(350);

      int counter = 0;

      while (results.next()) {
        String taskCD = "CD_TASK";
        String program = "CD_TASK_STAGE_PROGRAM";
        String stage = "CD_TASK_STAGE";

        NavTask navTask;
        navTask = new NavTask();

        navTask.setTaskCode(results.getString(taskCD));
        navTask.setStageType(results.getString(stage));
        navTask.setProgramCd(results.getString(program));

        String tabInfoL1ConstantName = (results.getString("TXT_1ST_TAB"));
        String tabInfoL2ConstantName = (results.getString("TXT_2ND_TAB"));
        String tabInfoL3ConstantName = (results.getString("TXT_3RD_TAB"));

        int defaultTab = results.getInt("IND_TASK_CODE_PREFER");
        String taskCode = results.getString(taskCD);

/*
        **   Default Tab indicator explained:
        **   If a 2nd level tab links to a page which shows directly under a 3rd level tab, then the 3rd level defaultTab value is 2 (the 2nd level tab shares the taskCD with it).
        **   If a 2nd Level tab links to a page whcih shows underneath it w/o a 3rd level tab, then its defaultTab value is 2.
        **   If a 3rd Level tab only shows once an action on a page under a 3rd level tab has been performed (i.e. person list),
        **   then the 3rd level tabs defaultTab value is 3 and the second levels is 2.
        **   SPB 02/20/03
 */
        if (defaultTab >= 2) {
          String id3 = String.valueOf(verifyTabInfoConstant(tabInfoL3ConstantName));
          String msg = "*defaultTab >= 2* tabInfoL3ConstantName - id3:" + tabInfoL3ConstantName + "///" + id3 + "-**";
          GrndsTrace.msg(TRACE_TAG, 8, msg);
          String strProgram = results.getString(program);
          String strStage = results.getString(stage);
          if (!"0".equals(id3)) // If this is a 3rd Level Tab
          {
            if ("ALL".equals(strProgram)) {
              // Need to perform the tripleToTaskCodeMap puts for each program, and
              // no program option, for this to really work for "ALL" programs.
              tripleToTaskCodeMap.put(new IdTriple("", strStage, id3), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("AFC", strStage, id3), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("APS", strStage, id3), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("CCL", strStage, id3), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("CPS", strStage, id3), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("PRS", strStage, id3), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("RCL", strStage, id3), taskCode);
            } else {
              tripleToTaskCodeMap.put(new IdTriple(strProgram, strStage, id3), taskCode);
            }
          }
          if (defaultTab == 2) // If this is a 2nd Level Tab
          {
            String id2 = String.valueOf(verifyTabInfoConstant(tabInfoL2ConstantName));
            if ("ALL".equals(strProgram)) {
              // Need to perform the tripleToTaskCodeMap puts for each program, and
              // no program option, for this to really work for "ALL" programs.
              tripleToTaskCodeMap.put(new IdTriple("", strStage, id2), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("AFC", strStage, id2), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("APS", strStage, id2), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("CCL", strStage, id2), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("CPS", strStage, id2), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("PRS", strStage, id2), taskCode);
              tripleToTaskCodeMap.put(new IdTriple("RCL", strStage, id2), taskCode);
            } else {
              GrndsTrace.msg(TRACE_TAG, 8,
                             " *2* IdTriple( program, stage, id2 ) , taskCode : (" + strProgram + ", " + strStage +
                             ", " + id2 + ") , " + taskCode + ".");
              tripleToTaskCodeMap.put(new IdTriple(strProgram, strStage, id2), taskCode);
            }
          }
        }

        // defaultTab != 0 Ignore all tasks associates with Approval Status
        // Bind L1 Tabs to their corresponding tab Constant by use of the tabID
        if ("CASE_CASESEARCH".equalsIgnoreCase(tabInfoL1ConstantName)) {
          navTask.setLevel1Id(TabConstants.CASE_CASESEARCH);
        }
        // Task Codes were originally only under Case tab, but now there are
        // some that go under Intake as well.
        else if ("INTAKE_INTAKE".equalsIgnoreCase(tabInfoL1ConstantName)) {
          navTask.setLevel1Id(TabConstants.INTAKE_INTAKE);
        }
        GrndsTrace.msg(TRACE_TAG, 8, "");
        String msg =
                "Setting L2 ID into NavTask #:" + counter + " || " + verifyTabInfoConstant(tabInfoL2ConstantName);
        GrndsTrace.msg(TRACE_TAG, 8, msg);
        navTask.setLevel2Id((verifyTabInfoConstant(tabInfoL2ConstantName)));

        if (tabInfoL3ConstantName != null) {
          if (verifyTabInfoConstant(tabInfoL3ConstantName) != 0) { // Set L3ID to corresponding ID from TabInfo
            GrndsTrace.msg(TRACE_TAG, 8, "Setting L3 ID into NavTask #:" + counter + " || " +
                                         verifyTabInfoConstant(tabInfoL3ConstantName));
            GrndsTrace.msg(TRACE_TAG, 8, "");
            navTask.setLevel3Id((verifyTabInfoConstant(tabInfoL3ConstantName)));
          }
        } else {
          navTask.setLevel3Id(0);
        }
        GrndsTrace.msg(TRACE_TAG, 8,
                       "TASK CD put in NavMap:" + results.getString(taskCD) + ". - taskCode ." + taskCode);
        navMap.put(results.getString(taskCD), navTask);

        counter++;
      } // end while
      Nav.setTripleToTaskCodeMap(tripleToTaskCodeMap);
      Nav.setTaskCdToNavTaskMap(navMap);
    } finally {
      if (results != null) {
        results.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  /**
   * Verifies whether tab Constant exists in TabInfo as static constant. Returns tabID if successful, and 0 if not.
   *
   * @return tabID SPB 1/27/03
   */
  private static int verifyTabInfoConstant(String tabConstant) {
    int tabId;
    try {
      tabId = TabConstants.class.getField(tabConstant).getInt(null);
      GrndsTrace.msg(TRACE_TAG, 8, "In verifyTabInfoConstant(), tabConstant and ID == " + tabConstant + "/ " + tabId);
      return tabId;
    } catch (Exception e) {
      return 0;
    }
  }

  /**
   * Generates the TabMap containing TabInfo beans and TabIDs read from the METAPHOR table. TabInfo Beans correspond to
   * one tab and contain the TabID, URL for the tab, the contsant used for the tab, the tab text, and if applicable, the
   * active and inactive image names for an L1 tab.
   *
   * @return TabMap SPB 2/11/03
   */
  private static void populateTabInfoAndFilterMaps() throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet results = null;

    Map<String, TabInfo> tabInfoMap = new HashMap<String, TabInfo>();
    Map<String, String> filterClassMap = new HashMap<String, String>();
    // SPB SIR 18984 - Movedtab ID to filter mapping to Metaphor table TXT_FILTER_PATH field.
    // Method now returns two Maps wrapped in a Map[].
    try {
      connection = JdbcHelper.getConnection();

      String sql = "select ID_TAB, TXT_TAB_URL, TXT_TAB, TXT_L1_IMG_INACTIVE, TXT_L1_IMG_ACTIVE, TXT_FILTER_PATH " +
                   "  from METAPHOR";

      statement = connection.prepareStatement(sql);
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(200);

      results = statement.executeQuery();

      // Currently, there are 149 rows, so always guarantee that we get the whole table at once
      results.setFetchSize(200);

      while (results.next()) {
        int id = (results.getInt("ID_TAB"));
        String url = (results.getString("TXT_TAB_URL"));
        String tabText = (results.getString("TXT_TAB"));
        String activeTabImg = "";
        String inactiveTabImg = "";
        if ((results.getString("TXT_L1_IMG_INACTIVE")) != null) {
          inactiveTabImg = (results.getString("TXT_L1_IMG_INACTIVE"));
          activeTabImg = (results.getString("TXT_L1_IMG_ACTIVE"));
        }
        String filter = (results.getString("TXT_FILTER_PATH"));
        // if a filter exists, add it to the filterClassMap
        if (filter != null) {
          filterClassMap.put(String.valueOf(id), filter);
        }
        //Create TabInfo
        TabInfo tabInfo = new TabInfo();
        tabInfo.setTabId(id);
        tabInfo.setName(tabText);
        tabInfo.setActiveImg(activeTabImg);
        tabInfo.setInactiveImg(inactiveTabImg);
        tabInfo.setUrl(url);
        // add TabInfo to tabInfoMap
        tabInfoMap.put(String.valueOf(id), tabInfo);
      } // end while
      // Maps tab IDs to TabInfo beans containing all info for a tab
      Nav.setIdToTabInfoMap(tabInfoMap);
      // Maps tab IDs to filter classes
      Nav.setFilterClassMap(filterClassMap);
    } finally {
      if (results != null) {
        results.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    }
  }

  /**
   * Generates the TabIdMap mapping TabConstants to TabIDs by accessing TabConstants.java by reflection
   *
   * @return TabIdMap SPB 1/8/03
   */
  private static void populateTabIdMap() throws IllegalAccessException {
    Map<String, Integer> tabIdMap = new HashMap<String, Integer>();
    Class tabInfo = TabConstants.class;
    Field[] fields = tabInfo.getFields();
    for (int i = 0; i < fields.length; i++) {
      String name = fields[i].getName();
      // GrndsTrace.msg( TRACE_TAG, 8, "Name in populate Map == " + name );
      int value = fields[i].getInt(null);
      GrndsTrace.msg(TRACE_TAG, 8, "Value in populate Map == " + value);
      tabIdMap.put(name, value);
    }
    Nav.setTabConstantToTabIdMap(tabIdMap);
  }

  /**
   * Generates the tabConstantMap mapping TabIDs to TabConstants by accessing TabConstants.java by reflection
   *
   * @return tabConstantMap SPB 1/23/03
   */
  private static void populateTabConstantMap() throws IllegalAccessException {
    Map<String, String> tabConstantMap = new HashMap<String, String>();
    Class tabInfo = TabConstants.class;
    Field[] fields = tabInfo.getFields();
    for (int i = 0; i < fields.length; i++) {
      int tabID = fields[i].getInt(null);
      String strTabId = String.valueOf(tabID);
      String strConstant = fields[i].getName();
      tabConstantMap.put(strTabId, strConstant);
    }
    Nav.setTabIdToTabConstantMap(tabConstantMap);
  }

  public void destroy(ServletContext config) throws BasePrsException {
    Nav.setFilterClassMap(null);
    Nav.setIdToTabInfoMap(null);
    Nav.setTabConstantToTabIdMap(null);
    Nav.setTabIdToTabConstantMap(null);
    Nav.setTaskCdToNavTaskMap(null);
    Nav.setTripleToTaskCodeMap(null);
  }
}
