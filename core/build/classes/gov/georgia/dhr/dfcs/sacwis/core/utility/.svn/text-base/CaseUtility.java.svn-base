package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.facility.log.GrndsTrace;

/**
 * CaseUtility provides helper methods for accessing data about cases or their events that is not easily available in
 * CAPS.
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  02/17/04  Dejuanr   SIR 18305 - Added getDateLastUpdate.
 *  02/28/05  e. Dickman SIR 22372 - Added isStageMerged.
 *  05/26/04  RIOSJA    SIR 22899 - Added getEventByStageAndEventType() methods
 *                      to search for an event given a stage id and event type.
 *  5/27/2004 gerryc    SIR 22931 - in the getStage(result set) method, the name
 *                      of the case was getting set as the name of the stage.
 *                      That is fixed now, so the case name will correctly
 *                      display on the case summary page, instead of the stage
 *                      name.
 *  06/29/04  RIOSJA    SIR 16114 - Added getPriorStage(), getInvStage() and
 *                      getStageByTypeAndPriorStage() methods to use for the new
 *                      Services and Referrals Checklist functionality that is
 *                      being added to all family stages (FPR, FRE and FSU).
 *  05/09/05  cooganpj  SIR 23572 - Added getCaseCheckoutStatus
 *                      method to determine if a stage is checked out to mobile
 *                      device, per MPS Mobile Online IMPACT Enhancements.
 *  05/12/05  cooganpj  SIR 23572 - Changes SQL to only look at primary assignments
 *  06/10/05  cooganpj  SIR 23675 - Changed getCaseCheckoutStatus to only look at
 *                      INV stage cases for MPS Phase I.
 *  06/29/05  cooganpj  SIR 23726 - Changed getCaseCheckoutStatus to check SVC stages
 *                      as well as INV stages, overloaded getCaseCheckoutStatus to check
 *                      an array of stages to see if any are checked out to MPS, and
 *                      added getCheckedOutStages and getCheckedOutPersonStatus to determine
 *                      what stages out of an array of stages are checked out to MPS and if
 *                      a pair of person ID's is connected to a stage checked out to MPS.
 *  07/13/05  cooganpj  SIR 23726 - Move SQL to constants and close performance trace.
 *  07/15/05  dejuanr   Phase 2 - The sql in getInvStage does not work in ianywhere.
 *                      I made a simple sql that assume a SVC stage, becuase the prior
 *                      stage of a SVC is always INV. This is for the MPS
 *  08/17/05  mkw       Phase II -- Moved getCdMobileStatus method here from
 *                      MobileUtility so we could use it in code shared with
 *                      server IMPACT.
 *  09/23/05  cooganpj  SIR 23966 (MPS Phase III Lockdown Changes) - Added getAFCPendingStatus
 *                      function to determine when AFC stage is pending approval.
 *  03/27/08  amroberts STGAP00007037 Allowed OUT assigned case managers modify access to cases in
 *  					inferior/child units
 *  10/26/08  mchillman STGAP00010580 Added sealed, sensitive and date sealed attributes to stage  
 *  
 *  05/04/2009 bgehlot  STGAP00012868 Added a SQL in the hasStageAccess method for if the user is a designee of 
 *                      parent supervisors in the unit hierarchy of a person who is assigned to the stage
 *  05/26/2010 hnguyen  SMS#37187 Updated hasStageAccess to account for temporary stage person link 
 *                      during intake creation, this will allow user to modify the call record after they
 *                      navigate away from call information and access it again through workload.
 * </pre>
 *
 * @author Bradley Eilers
 * @version 1.0
 */
public class CaseUtility {

  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
          GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                             "exception.globalLogger"));

  private static final String TRACE_TAG = "CaseUtility";

  public static final String STAGE_CLOSURE = "1";
  public static final char OPEN_STAGES = 'O';
  public static final char CLOSED_STAGES = 'C';
  public static final char ALL_STAGES = 'A';
  public static final String MERGE_STAGE = "97";

  protected static final String SELECT_STAGE_CLAUSE = "SELECT STAGE.ID_STAGE, \n" +
                                                      "       STAGE.ID_CASE, \n" +
                                                      "       STAGE.ID_SITUATION, \n" +
                                                      "       STAGE.NM_STAGE, \n" +
                                                      "       STAGE.CD_STAGE, \n" +
                                                      "       STAGE.CD_STAGE_TYPE, \n" +
                                                      "       STAGE.CD_STAGE_PROGRAM, \n" +
                                                      "       STAGE.DT_STAGE_START, \n" +
                                                      "       STAGE.IND_STAGE_CLOSE, \n" +
                                                      "       STAGE.CD_STAGE_REASON_CLOSED, \n" +
                                                      "       CAPS_CASE.NM_CASE, \n" +
                                                      "       STAGE.DT_STAGE_CLOSE, \n" +
                                                      "       STAGE.IND_STAGE_SEALED, \n" +
                                                      "       STAGE.IND_STAGE_SENSITIVE, \n" +
                                                      "       STAGE.DT_STAGE_SEALED \n" +
                                                      "   FROM STAGE LEFT OUTER JOIN CAPS_CASE \n" +
                                                      "     ON STAGE.ID_CASE = CAPS_CASE.ID_CASE \n" +
                                                      "   WHERE \n";

  protected static final String GET_CHECKOUT_STATUS_SQL = "SELECT CD_MOBILE_STATUS " +
                                                          "FROM WORKLOAD " +
                                                          "WHERE " +
                                                          "CD_WKLD_STAGE_PERS_ROLE = 'PR' " +
                                                          "AND (CD_WKLD_STAGE = 'INV' OR " +
                                                          "CD_WKLD_STAGE = 'SVC') " +
                                                          "AND ID_WKLD_STAGE = ? ";

  protected static final String GET_CHECKEDOUT_PERSON_STATUS_SQL = "SELECT DISTINCT COUNT(*) FROM " +
                                                                   "STAGE_PERSON_LINK SPL, WORKLOAD W " +
                                                                   "WHERE (SPL.ID_PERSON = ? OR SPL.ID_PERSON = ?) " +
                                                                   "AND W.ID_WKLD_STAGE = SPL.ID_STAGE " +
                                                                   "AND W.CD_MOBILE_STATUS = 'OT'";

  protected static final String GET_AFC_PENDING_STATUS_SQL = "SELECT COUNT(*) \n" +
                                                             "FROM EVENT \n" +
                                                             "WHERE ID_CASE = ? \n" +
                                                             "AND CD_TASK = 2460 \n" +
                                                             "AND CD_EVENT_STATUS = 'PROC'";

  private static final String MOBILE_STATUS_SQL = "SELECT CD_MOBILE_STATUS \n" +
                                                  "FROM WORKLOAD \n" +
                                                  "WHERE ID_WKLD_CASE = ?";

  /**
   * Returns the last (using the fact that ID columns increment) approvers status record for the event. This will always
   * be one of "APRV," "REJT," "PEND," OR "INVD." If the event has not been submitted for approval, it will be null.
   *
   * @param ulIdEvent The ID_EVENT of the event for which the Approvers status will be returned.
   * @return The approvers status for the particular event.
   */
  public static String getApproversStatus(int ulIdEvent) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".getApproversStatus");
    performanceTrace.enterScope();
    String status = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();

      String sql = "SELECT CD_APPROVERS_STATUS " +
                   "FROM APPROVAL_EVENT_LINK AEL, " +
                   "APPROVERS A " +
                   "WHERE AEL.ID_EVENT = ? " +
                   "AND AEL.ID_APPROVAL = A.ID_APPROVAL " +
                   "AND ROWNUM < 2 " +
                   "ORDER BY AEL.ID_APPROVAL DESC, A.ID_APPROVERS DESC";

      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, ulIdEvent);

      resultSet = preparedStatement.executeQuery();
      /*
       * SELECT CD_APPROVERS_STATUS FROM APPROVAL_EVENT_LINK AEL, APPROVERS A WHERE AEL.ID_EVENT = ? AND AEL.ID_APPROVAL =
       * A.ID_APPROVAL AND ROWNUM < 2 ORDER BY AEL.ID_APPROVAL DESC, A.ID_APPROVERS DESC;
       */

      if (resultSet.next()) {
        status = resultSet.getString(1);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    return status;
  }

  /**
   * Return the UlIdPerson for the PAL Coordinator assigned to a Stage.
   *
   * @param ulIdStage
   * @return ulIdPerson ID for the PAL coordinator for a stage
   */
  public static int getPALCoordinatorID(int ulIdStage) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".getPALCoordinator");
    performanceTrace.enterScope();
    int coordinatorID = 0;
    Connection connection = null;
    StringBuffer sqlBuf = new StringBuffer();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      sqlBuf.append("SELECT U.ID_PERSON AS ID_PERSON");
      sqlBuf.append(" FROM   STAGE    S, ");
      sqlBuf.append(" UNIT     U, ");
      sqlBuf.append(" CCNTYREG C ");
      sqlBuf.append(" WHERE  U.CD_UNIT_SPECIALIZATION = 'PAL' ");
      sqlBuf.append(" AND    S.CD_STAGE_CNTY          = C.CODE ");
      sqlBuf.append(" AND    '0'+C.DECODE             = U.CD_UNIT_REGION ");
      sqlBuf.append(" AND    S.ID_STAGE               = ?");
      preparedStatement = connection.prepareStatement(sqlBuf.toString());

      // Add variables to statement
      preparedStatement.setInt(1, ulIdStage);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT U.ID_PERSON FROM STAGE S, UNIT U, CCNTYREG C WHERE U.CD_UNIT_SPECIALIZATION = 'PAL' AND S.CD_STAGE_CNTY =
       * C.CODE AND '0'+C.DECODE = U.CD_UNIT_REGION AND S.ID_STAGE = :hI_ulIdStage:hI_ulIdStage_i;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();

      // If a result row is returned, Record exists on approval event link table so it has been submitted for approval
      if (resultSet.next()) {
        GrndsTrace.msg(TRACE_TAG, 10, "Record exists for PAL Coordinator for ulIdStage " + ulIdStage + ".");
        coordinatorID = resultSet.getInt("ID_PERSON");
      } else {
        GrndsTrace.msg(TRACE_TAG, 10, "Record does NOT for PAL Coordinator for ulIdStage " + ulIdStage + ".");
      }

    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope(coordinatorID);
    return coordinatorID;
  }

  /**
   * Check to see if the given event id has an entry on the approval event link table. If it does, the event has been
   * submitted for approval at one point.
   *
   * @param ulIdEvent id event to check
   * @return whether or not the event has been submitted for approval
   */
  public static boolean hasBeenSubmittedForApproval(String ulIdEvent) {
    return hasBeenSubmittedForApproval(Integer.parseInt(ulIdEvent));
  }

  /**
   * Check to see if the given event id has an entry on the approval event link table. If it does, the event has been
   * submitted for approval at one point.
   *
   * @param ulIdEvent id event to check
   * @return whether or not the event has been submitted for approval
   */
  public static boolean hasBeenSubmittedForApproval(int ulIdEvent) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".hasBeenSubmittedForApproval");
    performanceTrace.enterScope();
    boolean bSubmittedForApproval = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT A.ID_APPROVAL FROM APPROVAL_EVENT_LINK A WHERE A.ID_EVENT = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulIdEvent);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT A.ID_APPROVAL FROM APPROVAL_EVENT_LINK A WHERE A.ID_EVENT = :hostulIdEvent:hostulIdEvent_ind;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();

      // If a result row is returned, Record exists on approval event link table so it has been submitted for approval
      if (resultSet.next()) {
        GrndsTrace.msg(TRACE_TAG, 10,
                       "Record exists on approval event link table so it has been submitted for approval");
        bSubmittedForApproval = true;
      } else {
        GrndsTrace.msg(TRACE_TAG, 10,
                       "Record does NOT exist on approval event link table so it has NOT been submitted for approval");
        bSubmittedForApproval = false;
      }

    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope(bSubmittedForApproval);
    // return value from service
    return bSubmittedForApproval;
  }

  /**
   * Returns a list of open stages for a given case; they are sorted by stage code, then stage name.
   *
   * @param ulIdCase The case id.
   * @return A <tt>List</tt> of <tt>CaseUtility.Stage</tt> objects.
   */
  public static List<CaseUtility.Stage> getOpenStages(int ulIdCase) {
    return getStages(String.valueOf(ulIdCase), OPEN_STAGES);
  }

  /**
   * Returns a String of open merge stages for a given stage id;
   *
   * @param ulIdStage The stage id.
   * @return A <tt>List</tt> of <tt>Merge Stages</tt> objects.
   */
  public static boolean isStageMerged(int ulIdStage) {
    GrndsTrace.enterScope(TRACE_TAG + ".isStageMerged");

    boolean results = false;
    Connection connection = null;

    StringBuffer buf = new StringBuffer();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      buf.append("SELECT COUNT(1) FROM STAGE WHERE ID_STAGE = ? \n");
      buf.append("AND CD_STAGE_REASON_CLOSED = '97'   \n");

      preparedStatement = connection.prepareStatement(buf.toString());

      // Add variables to statement
      preparedStatement.setInt(1, ulIdStage);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        results = resultSet.getInt(1) > 0 ? true : false;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return results;
  }

  /**
   * Returns a list of open stages for a given case; they are sorted by stage code, then stage name.
   *
   * @param ulIdCaseString The case id.
   * @return A <tt>List</tt> of <tt>CaseUtility.Stage</tt> objects.
   */
  public static List<CaseUtility.Stage> getOpenStages(String ulIdCaseString) {
    return getStages(ulIdCaseString, OPEN_STAGES);
  }

  /**
   * Returns a list of open stages for a given case; they are sorted by stage code, then stage name.
   *
   * @param ulIdCase The case id.
   * @return A <tt>List</tt> of <tt>CaseUtility.Stage</tt> objects.
   */
  public static List<CaseUtility.Stage> getClosedStages(int ulIdCase) {
    return getStages(String.valueOf(ulIdCase), CLOSED_STAGES);
  }

  /**
   * Returns a list of open stages for a given case; they are sorted by stage code, then stage name.
   *
   * @param ulIdCaseString The case id.
   * @return A <tt>List</tt> of <tt>CaseUtility.Stage</tt> objects.
   */
  public static List<CaseUtility.Stage> getClosedStages(String ulIdCaseString) {
    return getStages(ulIdCaseString, CLOSED_STAGES);
  }

  /**
   * Returns a list of open stages for a given case; they are sorted by stage code, then stage name.
   *
   * @param ulIdCase The case id.
   * @return A <tt>List</tt> of <tt>CaseUtility.Stage</tt> objects.
   */
  public static List<CaseUtility.Stage> getAllStages(int ulIdCase) {
    return getStages(String.valueOf(ulIdCase), ALL_STAGES);
  }

  /**
   * Returns a list of open stages for a given case; they are sorted by stage code, then stage name.
   *
   * @param ulIdCaseString The case id.
   * @return A <tt>List</tt> of <tt>CaseUtility.Stage</tt> objects.
   */
  public static List<CaseUtility.Stage> getAllStages(String ulIdCaseString) {
    return getStages(ulIdCaseString, ALL_STAGES);
  }

  /**
   * @param ulIdCase
   * @param stageType
   * @return The list of open or closed stages
   */
  protected static List<CaseUtility.Stage> getStages(String ulIdCase, char stageType) {
    GrndsTrace.enterScope(TRACE_TAG + ".getStages");

    List<CaseUtility.Stage> results = new ArrayList<CaseUtility.Stage>();
    Connection connection = null;

    StringBuffer buf = new StringBuffer();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      buf.append(SELECT_STAGE_CLAUSE).append(" STAGE.ID_CASE = ? \n");

      switch (stageType) {
        case CLOSED_STAGES:
          buf.append(" AND STAGE.IND_STAGE_CLOSE = 'Y' ");
          break;
        case OPEN_STAGES:
          buf.append(" AND STAGE.IND_STAGE_CLOSE = 'N' ");
          break;
        case ALL_STAGES:
          // add no and clause
          break;
        default:
          throw new IllegalArgumentException("Illegal Stage Type.");
      }

      buf.append("ORDER BY CD_STAGE, NM_STAGE");
      preparedStatement = connection.prepareStatement(buf.toString());

      // Add variables to statement
      preparedStatement.setString(1, ulIdCase);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      while (resultSet.next()) {
        CaseUtility.Stage stage = getStage(resultSet);
        results.add(stage);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return results;
  }

  /**
   * Returns the case name from its id
   *
   * @param ulIdCase The ID_CASE value as a <tt>String</tt>
   * @return the case name
   */
  public static String getNmCase(int ulIdCase) {
    return getNmCase(String.valueOf(ulIdCase));
  }

  /**
   * Returns the case name from its id
   *
   * @param ulIdCase The ID_CASE value as a <tt>String</tt>
   * @return the case name
   */
  public static String getNmCase(String ulIdCase) {
    GrndsTrace.enterScope(TRACE_TAG + ".getNmCase");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String nmCase = null;
    try {
      connection = JdbcHelper.getConnection();

      String sql = "SELECT NM_CASE FROM CAPS_CASE WHERE ID_CASE = ?";

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ulIdCase);
      preparedStatement.execute();

      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        nmCase = resultSet.getString(1);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return nmCase;
  }

  public static String getCounty(String ulIdCase) {
    GrndsTrace.enterScope(TRACE_TAG + ".getNmCase");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String county = null;
    try {
      connection = JdbcHelper.getConnection();
      String sql = "SELECT CD_CASE_COUNTY FROM CAPS_CASE WHERE ID_CASE = ?";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ulIdCase);
      preparedStatement.execute();
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        county = resultSet.getString(1);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return county;
  }

  /**
   * Returns information about a stage.
   *
   * @param ulIdStage The ID_STAGE value as an int
   * @return Information about a particular stage
   */
  public static CaseUtility.Stage getStage(int ulIdStage) {
    return getStage(String.valueOf(ulIdStage));
  }

  /**
   * Returns information about a stage.
   *
   * @param ulIdStage The ID_STAGE value as a <tt>String</tt>
   * @return Information about a particular stage.
   */
  public static CaseUtility.Stage getStage(String ulIdStage) {
    GrndsTrace.enterScope(TRACE_TAG + ".getStage");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();

      String sql = SELECT_STAGE_CLAUSE + " ID_STAGE = ? \n";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, ulIdStage);
      preparedStatement.execute();

      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        return getStage(resultSet);
      }
      return null;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
  }

  protected static CaseUtility.Stage getStage(ResultSet resultSet)
          throws SQLException {
    return new Stage(resultSet.getInt("ID_STAGE"), resultSet.getInt("ID_CASE"),
                     resultSet.getInt("ID_SITUATION"), resultSet.getString("NM_STAGE"), resultSet.getString("CD_STAGE"),
                     resultSet.getString("CD_STAGE_TYPE"), resultSet.getString("CD_STAGE_PROGRAM"),
                     resultSet.getString("DT_STAGE_START"), resultSet.getString("DT_STAGE_CLOSE"),
                     resultSet.getString("IND_STAGE_CLOSE"), resultSet.getString("CD_STAGE_REASON_CLOSED"),
                     resultSet.getString("NM_CASE"), resultSet.getString("IND_STAGE_SEALED"),
                     resultSet.getString("IND_STAGE_SENSITIVE"), resultSet.getString("DT_STAGE_SEALED"));
  }

  /**
   * Returns details for the investigation (INV) stage from which the given stage originates.
   *
   * @param ulIdStage id of the stage for which to retrieve the corresponding INV stage
   * @return details of the investigation stage from which the given stage originates... returned in the form of a Stage
   *         class
   */
  public static CaseUtility.Stage getInvStage(int ulIdStage) {
    GrndsTrace.enterScope(TRACE_TAG + ".getInvStage");

    CaseUtility.Stage invStage = new CaseUtility.Stage();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Phase 2
      // Connect By does not work in Ianywhere
      String sql = PlatformConstants.SERVER_IMPACT ?
                   "SELECT LINK.ID_PRIOR_STAGE " +
                   "FROM ( " +
                   "SELECT SL.ID_PRIOR_STAGE " +
                   "FROM STAGE_LINK SL " +
                   "CONNECT BY SL.ID_STAGE = PRIOR SL.ID_PRIOR_STAGE " +
                   "START WITH SL.ID_STAGE = ?) LINK, " +
                   "STAGE S " +
                   "WHERE S.ID_STAGE = LINK.ID_PRIOR_STAGE " +
                   "AND S.CD_STAGE = 'INV' " +
                   "AND ROWNUM < 2"
                   : "SELECT ID_PRIOR_STAGE FROM STAGE_LINK WHERE ID_STAGE = ? ";

      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulIdStage);

      // Set max rows to replace ROWNUM sql statement
      preparedStatement.setMaxRows(1);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();

      int invStageId = 0;
      if (resultSet.next()) {
        invStageId = resultSet.getInt("ID_PRIOR_STAGE");
      }
      GrndsTrace.msg(TRACE_TAG, 10, "inv stage id:" + invStageId);

      // Get the investigation stage details
      if (invStageId > 0) {
        invStage = CaseUtility.getStage(invStageId);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return invStage;
  }

  /**
   * Returns details for the stage of the given type, if one exists, that originated from the given stage id. (USAGE:
   * This method was written for SIR 16114 to find the FSU stage that most closely precedes the FRE stage with the given
   * start date.)
   *
   * @param ulIdPriorStage id of the stage that led to the creation of a stage we are searching for
   * @param szCdStage      type of stage we are searching for
   * @return details of the stage we are searching for... returned in the form of a Stage class
   */
  public static CaseUtility.Stage getStageByTypeAndPriorStage(int ulIdPriorStage, String szCdStage) {
    GrndsTrace.enterScope(TRACE_TAG + ".getStageByTypeAndPriorStage");

    CaseUtility.Stage stage = new CaseUtility.Stage();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      String sql = "SELECT " +
                   "RESULT.ID_STAGE, " +
                   "S.CD_STAGE " +
                   "FROM ( " +
                   "SELECT " +
                   "SL.ID_PRIOR_STAGE, " +
                   "SL.ID_STAGE " +
                   "FROM " +
                   "STAGE_LINK SL " +
                   "START WITH SL.ID_PRIOR_STAGE = ?  " +
                   "CONNECT BY SL.ID_PRIOR_STAGE = PRIOR SL.ID_STAGE) RESULT, " +
                   "STAGE S " +
                   "WHERE " +
                   "S.ID_STAGE = RESULT.ID_STAGE " +
                   "AND S.CD_STAGE = ?";

      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulIdPriorStage);
      preparedStatement.setString(2, szCdStage);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();

      int stageId = 0;
      if (resultSet.next()) {
        stageId = resultSet.getInt("ID_STAGE");
      }

      // Get the stage details
      if (stageId > 0) {
        stage = CaseUtility.getStage(stageId);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return stage;
  }

  /**
   * Returns details for the stage prior to the given stage as indicated by the STAGE_LINK table.
   *
   * @param ulIdStage id of the stage for which to retrieve the corresponding prior stage
   * @return details of the prior stage returned in the form of a Stage class
   */
  public static CaseUtility.Stage getPriorStage(int ulIdStage) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPriorStage");

    CaseUtility.Stage priorStage = new CaseUtility.Stage();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      String sql = SELECT_STAGE_CLAUSE
                   + " " +
                   "ID_STAGE = (" +
                   "SELECT \n" +
                   "SL.ID_PRIOR_STAGE \n" +
                   "FROM  \n" +
                   "STAGE_LINK SL, \n" +
                   "STAGE S \n" +
                   "WHERE \n" +
                   "S.ID_STAGE = SL.ID_PRIOR_STAGE \n" +
                   "AND SL.ID_STAGE = ?)";

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, ulIdStage);
      preparedStatement.execute();

      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        priorStage = getStage(resultSet);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return priorStage;
  }

  /**
   * Returns a the event and todo id's for an approval given an event from the stage.
   *
   * @param ulIdEvent The case id.
   * @return A <tt>CaseUtility.ToDo</tt> objects.
   */
  public static CaseUtility.ToDo getApprovalToDo(int ulIdEvent) {
    return getApprovalToDo(String.valueOf(ulIdEvent));
  }

  /**
   * Returns a the event and todo id's for an approval given an event from the stage.
   *
   * @param ulIdEvent The case id.
   * @return A <tt>CaseUtility.ToDo</tt> objects.
   */
  public static CaseUtility.ToDo getApprovalToDo(String ulIdEvent) {
    GrndsTrace.enterScope(TRACE_TAG + ".getOpenStages");

    CaseUtility.ToDo approvalToDo = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT  A.ID_APPROVAL, C.ID_TODO, E.CD_EVENT_STATUS " +
                   "FROM APPROVAL_EVENT_LINK A, TODO C, EVENT E " +
                   "WHERE A.ID_EVENT = ? " +
                   "  AND A.ID_APPROVAL = C.ID_TODO_EVENT " +
                   "  AND E.ID_EVENT = A.ID_APPROVAL";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdEvent);

      // Execute the sql
      preparedStatement.execute();
      // SELECT A.ID_APPROVAL, C.ID_TODO
      //   FROM APPROVAL_EVENT_LINK A, TODO C
      //  WHERE A.ID_EVENT = 65383725
      //   AND A.ID_APPROVAL = C.ID_TODO_EVENT

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        approvalToDo = new ToDo(resultSet.getInt("ID_TODO"), resultSet.getInt("ID_APPROVAL"),
                                resultSet.getString("CD_EVENT_STATUS"));
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return approvalToDo;
  }

  /**
   * This utility will get the DateLastUpdate for a specific row in a table. This was create for SIR 18305 to get the
   * date off of the Incoming Detail table so that i could update the status.
   *
   * @param table      - Table we want to get the date from
   * @param primaryKey - Key we are using to search
   * @param ulId       - Id number
   * @return date last update
   */
  public static java.util.Date getDateLastUpdate(String table, String primaryKey, int ulId) {
    GrndsTrace.enterScope(TRACE_TAG + ".getDateLastUpdate");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    java.util.Date tsDataLastUpdate = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT DT_LAST_UPDATE FROM " + table + " WHERE " + primaryKey + " = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulId);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        Timestamp timestamp = resultSet.getTimestamp(1);
        tsDataLastUpdate = new java.util.Date(timestamp.getTime());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();

    return tsDataLastUpdate;
  }

  /**
   * Returns a the event and todo id's for an approval given an event from the stage.
   *
   * @param ulIdToDo The case id.
   * @return A <tt>CaseUtility.ToDo</tt> objects.
   */
  public static CaseUtility.ToDo getToDo(int ulIdToDo) {
    return getToDo(String.valueOf(ulIdToDo));
  }

  /**
   * Returns a the event and todo id's for an approval given an event from the stage.
   *
   * @param ulIdToDo The case id.
   * @return A <tt>CaseUtility.ToDo</tt> objects.
   */
  public static CaseUtility.ToDo getToDo(String ulIdToDo) {
    GrndsTrace.enterScope(TRACE_TAG + ".getToDo");

    CaseUtility.ToDo toDo = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT T.ID_TODO, \n" +
                   "T.ID_TODO_PERS_ASSIGNED, \n" +
                   "C.ID_CASE, \n" +
                   "C.NM_CASE, \n" +
                   "S.ID_STAGE, \n" +
                   "S.NM_STAGE, \n" +
                   "S.CD_STAGE, \n" +
                   "S.CD_STAGE_PROGRAM, \n" +
                   "S.CD_STAGE_TYPE, \n" +
                   "E.ID_EVENT, \n" +
                   "E.CD_EVENT_STATUS, \n" +
                   "TSK.CD_TASK, \n" +
                   "TSK.CD_TASK_EVENT_TYPE, \n" +
                   "TSK.IND_STAGE_CLOSURE, \n" +
                   "TSK.TXT_EVENT_DETAIL_URL \n" +
                   "FROM TODO T, STAGE S, EVENT E, CAPS_CASE C, TASK TSK \n" +
                   "WHERE T.ID_TODO = ? \n" +
                   "AND T.ID_TODO_EVENT = E.ID_EVENT (+) \n" +
                   "AND T.ID_TODO_STAGE = S.ID_STAGE \n" +
                   "AND T.ID_TODO_CASE = C.ID_CASE (+) \n" +
                   "AND T.CD_TODO_TASK = TSK.CD_TASK \n" +
                   "AND T.DT_TODO_COMPLETED IS NULL";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdToDo);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT T.ID_TODO, T.ID_TODO_PERS_ASSIGNED, C.ID_CASE, C.NM_CASE, S.ID_STAGE, S.NM_STAGE, S.CD_STAGE,
       * S.CD_STAGE_PROGRAM, S.CD_STAGE_TYPE, E.ID_EVENT, E.CD_EVENT_STATUS, TSK.CD_TASK, TSK.CD_TASK_EVENT_TYPE,
       * TSK.IND_STAGE_CLOSURE, TSK.TXT_EVENT_DETAIL_URL FROM TODO T, STAGE S, EVENT E, CAPS_CASE C, TASK TSK WHERE
       * T.ID_TODO = :ldIdTodo AND T.ID_TODO_EVENT = E.ID_EVENT (+) -- ensures that todo's with no event (yet) will work
       * AND T.ID_TODO_STAGE = S.ID_STAGE AND T.ID_TODO_CASE = C.ID_CASE (+) -- ensures that intake approvals (no case
       * sometimes) will work AND T.CD_TODO_TASK = TSK.CD_TASK AND T.DT_TODO_COMPLETED IS NULL
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        toDo = new ToDo(resultSet.getInt("ID_TODO"), resultSet.getInt("ID_TODO_PERS_ASSIGNED"),
                        resultSet.getInt("ID_CASE"), resultSet.getString("NM_CASE"), resultSet.getInt("ID_STAGE"),
                        resultSet.getString("NM_STAGE"), resultSet.getString("CD_STAGE"),
                        resultSet.getString("CD_STAGE_PROGRAM"), resultSet.getString("CD_STAGE_TYPE"),
                        resultSet.getInt("ID_EVENT"), resultSet.getString("CD_EVENT_STATUS"),
                        resultSet.getString("CD_TASK"), resultSet.getString("CD_TASK_EVENT_TYPE"),
                        STAGE_CLOSURE.equals(resultSet.getString("IND_STAGE_CLOSURE")),
                        resultSet.getString("TXT_EVENT_DETAIL_URL"));
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return toDo;
  }

  /**
   * Returns the most recent event id and event status for the given person and event type.
   *
   * @param ulIdPerson id for the person whose event we wish to retrieve
   * @param eventType  the event type to retrieve
   * @return the most recent event for the given stage and task code in the form of an Event class
   */
  public static CaseUtility.Event getPersonEvent(String ulIdPerson, String eventType) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPersonEvent");

    CaseUtility.Event event = new CaseUtility.Event();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT EVENT.ID_EVENT, CD_EVENT_STATUS " +
                   "FROM EVENT, EVENT_PERSON_LINK " +
                   "WHERE ID_PERSON = ? " +
                   "AND CD_EVENT_TYPE = ? " +
                   "AND EVENT.ID_EVENT = EVENT_PERSON_LINK.ID_EVENT " +
                   "ORDER BY EVENT.DT_LAST_UPDATE DESC";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdPerson);
      preparedStatement.setString(2, eventType);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        GrndsTrace.msg(TRACE_TAG, 10, "event:" + event.toString());
      }
    } catch (Exception e) {
      // Return null event
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return event;
  }

  /**
   * Returns details for the requested event id.
   *
   * @param ulIdEvent id event for the event
   * @return the requested event in the form of an Event class
   */
  public static CaseUtility.Event getEvent(int ulIdEvent) {
    return getEvent(Integer.toString(ulIdEvent));
  }

  /**
   * Returns details for the requested event id.
   *
   * @param ulIdEvent id event for the event
   * @return the requested event in the form of an Event class
   */
  public static CaseUtility.Event getEvent(String ulIdEvent) {
    GrndsTrace.enterScope(TRACE_TAG + ".getEvent");

    CaseUtility.Event event = new CaseUtility.Event();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE, DT_EVENT_OCCURRED, TXT_EVENT_DESCR, ID_EVENT_STAGE " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT=? " +
                   "ORDER BY ID_EVENT DESC";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdEvent);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE FROM EVENT WHERE ID_EVENT_STAGE =
       * :hI_ulIdStage:hI_ulIdStage_i AND CD_TASK = :hI_szCdTask:hI_szCdTask_i ORDER BY ID_EVENT DESC;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        event.setCdTask(resultSet.getString("CD_TASK"));
        event.setDtLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        event.setDtEventOccurred(resultSet.getTimestamp("DT_EVENT_OCCURRED"));
        event.setTxtEventDesc(resultSet.getString("TXT_EVENT_DESCR"));
        event.setIdStage(resultSet.getInt("ID_EVENT_STAGE"));
        GrndsTrace.msg(TRACE_TAG, 10, "event:" + event.toString());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return event;
  }

  /**
   * Returns the most recent event id and event status for the given stage and task code<br> <code>Example usage:<br>
   * CaseUtility.Event event = CaseUtility.getEvent( "28151930","2610" );<br> String eventStatus =
   * event.getCdEventStatus();<br> int ulIdEvent = event.getIdEvent();<br> </code>
   *
   * @param ulIdStage id stage for the event
   * @param szCdTask  task code for the event
   * @return the most recent event for the given stage and task code in the form of an Event class
   */
  public static CaseUtility.Event getEvent(int ulIdStage, String szCdTask) {
    return getEvent(Integer.toString(ulIdStage), szCdTask);
  }

  /**
   * Returns the most recent event id and event status for the given stage and task code<br> Usage Example: see
   * getEvent( int, String )
   *
   * @param ulIdStage id stage for the event
   * @param szCdTask  task code for the event
   * @return the most recent event for the given stage and task code in the form of an Event class
   */
  public static CaseUtility.Event getEvent(String ulIdStage, String szCdTask) {
    GrndsTrace.enterScope(TRACE_TAG + ".getEvent");

    CaseUtility.Event event = new CaseUtility.Event();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT_STAGE=? AND CD_TASK=? " +
                   "ORDER BY ID_EVENT DESC";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdStage);
      preparedStatement.setString(2, szCdTask);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE FROM EVENT WHERE ID_EVENT_STAGE =
       * :hI_ulIdStage:hI_ulIdStage_i AND CD_TASK = :hI_szCdTask:hI_szCdTask_i ORDER BY ID_EVENT DESC;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        event.setCdTask(resultSet.getString("CD_TASK"));
        event.setDtLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        GrndsTrace.msg(TRACE_TAG, 10, "event:" + event.toString());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return event;
  }

  public static CaseUtility.Event getFirstCompEventByStageAndTask(int ulIdStage, String szCdTask) {
    GrndsTrace.enterScope(TRACE_TAG + ".getFirstCompEventByStageAndTask");
    CaseUtility.Event event = new CaseUtility.Event();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();
      String sql = "SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT_STAGE=? AND CD_TASK=? " +
                   "AND CD_EVENT_STATUS = 'COMP' " +
                   "ORDER BY ID_EVENT ASC";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, ulIdStage);
      preparedStatement.setString(2, szCdTask);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        event.setCdTask(resultSet.getString("CD_TASK"));
        event.setDtLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        GrndsTrace.msg(TRACE_TAG, 10, "event:" + event.toString());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return event;
  }

  /**
   * Returns the most recent event id, event status, task code and timestamp for the given stage and event type.<br>
   * <code>Example usage:<br> CaseUtility.Event event = CaseUtility.getEventByStageAndEventType( 28151930, "STG" );<br>
   * int ulIdEvent = event.getIdEvent();<br> String eventStatus = event.getCdEventStatus();<br> </code>
   *
   * @param ulIdStage     Stage id for the event
   * @param szCdEventType Type of event
   * @return The most recent event id, event status, task code and timestamp in the form of an Event class for the given
   *         stage and event type.
   */
  public static CaseUtility.Event getEventByStageAndEventType(int ulIdStage, String szCdEventType) {
    return getEventByStageAndEventType(Integer.toString(ulIdStage), szCdEventType);
  }

  /**
   * Returns the most recent event id, event status, task code and timestamp for the given stage and event type.<br>
   * Usage Example: see getEventByStageAndEventType( int, String )
   *
   * @param ulIdStage     Stage id for the event
   * @param szCdEventType Type of event
   * @return The most recent event id, event status, task code and timestamp in the form of an Event class for the given
   *         stage and event type.
   */
  public static CaseUtility.Event getEventByStageAndEventType(String ulIdStage, String szCdEventType) {
    GrndsTrace.enterScope(TRACE_TAG + ".getEventByStageAndEventType");

    CaseUtility.Event event = new CaseUtility.Event();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT_STAGE=? AND CD_EVENT_TYPE=? " +
                   "ORDER BY ID_EVENT DESC";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdStage);
      preparedStatement.setString(2, szCdEventType);

      // Execute the sql
      preparedStatement.execute();

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        event.setCdTask(resultSet.getString("CD_TASK"));
        event.setDtLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        GrndsTrace.msg(TRACE_TAG, 10, "event:" + event.toString());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    GrndsTrace.exitScope();
    return event;
  }

  /**
   * Returns the most recent event id and event status for the given stage and task code<br> <code>Example usage:<br>
   * CaseUtility.Event event = CaseUtility.getEvent( "28151930","2610" );<br> String eventStatus =
   * event.getCdEventStatus();<br> int ulIdEvent = event.getIdEvent();<br> </code>
   *
   * @param ulIdStage id stage for the event
   * @param szCdTask  task code for the event
   * @return the most recent event for the given stage and task code in the form of an Event class
   */
  public static CaseUtility.Event getIntakeCallEvent(int ulIdStage, String szCdTask, String eventType) {
    return getIntakeCallEvent(Integer.toString(ulIdStage), szCdTask, eventType);
  }

  /**
   * Returns the most recent event id and event status for the given stage and task code<br> Usage Example: see
   * getEvent( int, String )
   *
   * @param ulIdStage id stage for the event
   * @param szCdTask  task code for the event
   * @return the most recent event for the given stage and task code in the form of an Event class
   *         <p/>
   *         NOTE: There are instances where one Intake stage will have two RECORD_CALL events. This method will return
   *         the most current event.'
   *         <p/>
   *         Also note that the PRIORITY_CHANGE event has the same CD_TASK as the RECORD_CALL event. This is why it is
   *         necessary that we pass the event type to this method.
   */
  public static CaseUtility.Event getIntakeCallEvent(String ulIdStage, String szCdTask, String eventType) {
    GrndsTrace.enterScope(TRACE_TAG + ".getIntakeCallEvent");

    CaseUtility.Event event = new CaseUtility.Event();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT_STAGE=? AND CD_TASK=? AND CD_EVENT_TYPE=?" +
                   "ORDER BY ID_EVENT DESC";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdStage);
      preparedStatement.setString(2, szCdTask);
      preparedStatement.setString(3, eventType);
      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE FROM EVENT WHERE ID_EVENT_STAGE =
       * :hI_ulIdStage:hI_ulIdStage_i AND CD_TASK = :hI_szCdTask:hI_szCdTask_i AND CD_EVENT_TYPE =
       * :hI_szCdEventType:hI_szCdEventType_i ORDER BY ID_EVENT DESC;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        event.setCdTask(resultSet.getString("CD_TASK"));
        event.setDtLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        GrndsTrace.msg(TRACE_TAG, 10, "event:" + event.toString());
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return event;
  }

  /**
   * Returns a list of CaseUtility.Event objects for the given EventIdStruct_ARRAY; the events are passed in this object
   * because this method is used in ToDoConversation with data from ToDoDetailDB.<br> Usage Example: see getEvent(
   * int[], String )
   *
   * @param idEvents the event ids
   * @return a list of CaseUtility.Event objects for the given array of events
   */
  public static List<CaseUtility.Event> getEvents(int[] idEvents) {
    GrndsTrace.enterScope(TRACE_TAG + ".getEvent");

    int eventCount = idEvents.length;
    if (eventCount == 0) {
      throw new IllegalArgumentException("At least 1 event is required.");
    }

    List<CaseUtility.Event> events = new LinkedList<CaseUtility.Event>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();

      String sql = "  SELECT ID_EVENT, CD_EVENT_STATUS, CD_TASK, DT_LAST_UPDATE " +
                   "    FROM EVENT " +
                   "   WHERE ID_EVENT IN ( " + SqlHelper.toSetString(eventCount) + ") " +
                   "ORDER BY ID_EVENT";
      preparedStatement = connection.prepareStatement(sql);
      for (int i = 0; i < eventCount; i++) {
        preparedStatement.setInt((i + 1), idEvents[i]);
      }

      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        CaseUtility.Event event = new CaseUtility.Event();
        event.setIdEvent(resultSet.getInt("ID_EVENT"));
        event.setCdEventStatus(resultSet.getString("CD_EVENT_STATUS"));
        event.setCdTask(resultSet.getString("CD_TASK"));
        event.setDtLastUpdate(resultSet.getTimestamp("DT_LAST_UPDATE"));
        events.add(event);
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return events;
  }

  /**
   * Returns the status of the given event.
   *
   * @param ulIdEvent The ID_EVENT for the event of interest
   * @return The status of the event (a code from type CEVTSTAT)
   */
  public static String getSzCdEventStatus(int ulIdEvent) {
    return getSzCdEventStatus(String.valueOf(ulIdEvent));
  }

  /**
   * Returns the status of the given event.
   *
   * @param ulIdEvent The ID_EVENT for the event of interest
   * @return The status of the event (a code from type CEVTSTAT)
   */
  public static String getSzCdEventStatus(String ulIdEvent) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSzCdEventStatus");

    String szCdEventStatus = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT CD_EVENT_STATUS FROM EVENT WHERE ID_EVENT=?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdEvent);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT CD_EVENT_STATUS WHERE ID_EVENT = :hI_ulIdEvent:hI_ulIdEvent_i;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        szCdEventStatus = resultSet.getString("CD_EVENT_STATUS");
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return szCdEventStatus;
  }

  /**
   * Returns the type of the given event.
   *
   * @param ulIdEvent The ID_EVENT for the event of interest
   * @return The type of the event (a code from type CEVNTTYP)
   */
  public static String getSzCdEventType(int ulIdEvent) {
    return getSzCdEventType(String.valueOf(ulIdEvent));
  }
  
  /**
   * Returns the type of the given event.
   *
   * @param ulIdEvent The ID_EVENT for the event of interest
   * @return The type of the event (a code from type CEVNTTYP)
   */
  public static String getSzCdEventType(String ulIdEvent) {
    GrndsTrace.enterScope(TRACE_TAG + ".getSzCdEventType");

    String szCdEventType = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT CD_EVENT_TYPE FROM EVENT WHERE ID_EVENT=?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdEvent);

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        szCdEventType = resultSet.getString("CD_EVENT_TYPE");
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return szCdEventType;
  }
  
  /**
   * Returns a set of tasks associated with events not in COMP or APRV status for a particular stage.
   *
   * @param ulIdStage id stage for the events
   * @return A set of task codes for all events not in COMP or APRV in that stage
   */
  public static Set getPendingEventTasks(int ulIdStage) {
    return getPendingEventTasks(String.valueOf(ulIdStage));
  }

  /**
   * Returns a set of tasks associated with events not in COMP or APRV status for a particular stage.
   *
   * @param ulIdStage id stage for the events
   * @return A set of task codes for all events not in COMP or APRV in that stage
   */
  public static Set<String> getPendingEventTasks(String ulIdStage) {
    GrndsTrace.enterScope(TRACE_TAG + ".getPendingEventTasks");

    Set<String> taskSet = new HashSet<String>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT DISTINCT CD_TASK " +
                   "FROM EVENT " +
                   "WHERE ID_EVENT_STAGE=? " +
                   "AND NOT ( CD_EVENT_STATUS = 'COMP' OR CD_EVENT_STATUS = 'APRV' OR CD_EVENT_STATUS = 'PEND' )";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setString(1, ulIdStage);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT DISTINCT CD_TASK, FROM EVENT WHERE ID_EVENT_STAGE = :hI_ulIdStage:hI_ulIdStage_i AND NOT (
       * CD_EVENT_STATUS = 'COMP' OR CD_EVENT_STATUS = 'APRV' )
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        taskSet.add(resultSet.getString("CD_TASK"));
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return taskSet;
  }

  /**
   * Finds the number of events associated with a ulIdApproval (found in the ID_EVENT_TODO column of the TODO table).
   *
   * @param ulIdApproval
   * @return The number of events associated with an approval.
   */
  public static int getApprovalEventCount(int ulIdApproval) {
    GrndsTrace.enterScope(TRACE_TAG + ".getEvent");

    int eventCount = -1;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT COUNT(*) FROM APPROVAL_EVENT_LINK WHERE ID_APPROVAL = ?";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulIdApproval);

      // Execute the sql
      preparedStatement.execute();
      /*
       * SELECT COUNT(*) FROM APPROVAL_EVENT_LINK WHERE ID_APPROVAL = :hI_ulIdApproval:hI_ulIdApproval_i
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();
      if (resultSet.next()) {
        eventCount = resultSet.getInt(1); // Only 1 column is returned
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    GrndsTrace.exitScope();
    return eventCount;
  }

  /**
   * Looks at the case to determine if the given user has access to a given stage.<br> Use this version of the method if
   * you want to test access for the current user.<br> The following items are checked: <br> <li>primary worker assigned
   * to stage</li> <li>one of the four secondary workers assigned to the stage</li> <li>the supervisor of any of the
   * above</li> <li>the designee of any of the above supervisors</li> <code> Usage Example:<br> int ulIdStage =
   * GlobalData.getUlIdStage( request );<br> boolean bStageAccess = CaseUtility.hasStageAccess( ulIdStage,
   * UserProfileHelper.getUserProfile( request ) );<br> </code>
   *
   * @param userId
   * @param ulIdStage stage id to check
   * @return whether or not the user has access
   */
  public static boolean hasStageAccess(int userId, int ulIdStage) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".hasStageAccess");
    performanceTrace.enterScope();
    boolean bStageAccess = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      // The first part checks to see if the user is directly assigned to the stage
      String sql = "SELECT 'x' FROM DUAL WHERE EXISTS\n" +
                   "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                   "   FROM STAGE_PERSON_LINK, \n" +
                   "        UNIT_EMP_LINK \n" +
                   "  WHERE UNIT_EMP_LINK.ID_PERSON = ? \n" + // ulIdPerson 1
                   "    AND STAGE_PERSON_LINK.ID_STAGE = ? \n" + // ulIdStage 2
                   "    AND STAGE_PERSON_LINK.ID_PERSON = ? \n" + // ulIdPerson 3
                   "    AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ))\n" +
                   // This part checks to see if the user is a designee of the person assigned to the stage
                   "OR EXISTS\n" +
                   "(SELECT EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE \n" +
                   "   FROM EMP_TEMP_ASSIGN, STAGE_PERSON_LINK \n" +
                   "  WHERE EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = ? \n" + // ulIdPerson 4
                   "    AND NOT EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= ? \n" + // now 5
                   "    AND STAGE_PERSON_LINK.ID_STAGE = ? \n" + // ulIdStage 6
                   "    AND STAGE_PERSON_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP \n" +
                   "    AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ))\n" +
                   // This part checks to see if the user is a supervisor of a person who is assigned to the stage
                   "OR EXISTS\n" +
                   "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                   "   FROM UNIT_EMP_LINK, \n" +
                   "        ( SELECT UNIT_EMP_LINK.ID_UNIT \n" +
                   "            FROM UNIT_EMP_LINK, \n" +
                   "                 ( SELECT STAGE_PERSON_LINK.ID_PERSON \n" +
                   "                     FROM STAGE_PERSON_LINK \n" +
                   "                    WHERE STAGE_PERSON_LINK.ID_STAGE = ? \n" + // ulIdStage 7
                   "                      AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS \n" +
                   "           WHERE UNIT_EMP_LINK.ID_PERSON = STAGE_WORKERS.ID_PERSON \n" +
                   "           UNION SELECT ID_UNIT \n" +
                   "            FROM STAGE \n" +
                   "           WHERE ID_STAGE = ? ) STAGE_UNITS \n" + // ulIdStage 8
                   "  WHERE UNIT_EMP_LINK.ID_PERSON = ? \n" + // ulIdPerson 9
                   "    AND UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT \n" +
                   "    AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' ))\n" +
                   // This part checks to see if the user is a designee of a supervisor of a person
                   //   who is assigned to the stage
                   "OR EXISTS\n" +
                   "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                   "   FROM UNIT_EMP_LINK, EMP_TEMP_ASSIGN, \n" +
                   "        ( SELECT UNIT_EMP_LINK.ID_UNIT \n" +
                   "            FROM UNIT_EMP_LINK, \n" +
                   "                 ( SELECT STAGE_PERSON_LINK.ID_PERSON \n" +
                   "                     FROM STAGE_PERSON_LINK \n" +
                   "                    WHERE STAGE_PERSON_LINK.ID_STAGE = ? \n" + // ulIdStage 10
                   "                      AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS \n" +
                   "           WHERE UNIT_EMP_LINK.ID_PERSON = STAGE_WORKERS.ID_PERSON \n" +
                   "           UNION SELECT ID_UNIT \n" +
                   "            FROM STAGE \n" +
                   "           WHERE ID_STAGE = ? ) STAGE_UNITS \n" + // ulIdStage 11
                   "  WHERE UNIT_EMP_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP \n" +
                   "    AND UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT \n" +
                   "    AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' ) \n" +
                   "    AND EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = ? \n" + // ulIdPerson 12
                   "    AND NOT EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= ?)\n" +// now 13
                   //STGAP00012868: This part checks to see if the user is a designee of parent supervisors in the unit hierarchy of a person
                   //   who is assigned to the stage
                    " OR EXISTS (SELECT U.ID_PERSON \n" +
                    "            FROM UNIT U\n" +
                    "            START WITH U.ID_UNIT IN (\n" +
                    "                      SELECT ID_UNIT_PARENT \n" +
                    "                      FROM UNIT \n" +
                    "                      WHERE ID_UNIT IN (\n" +
                    "                              SELECT UEL.ID_UNIT \n" +
                    "                              FROM UNIT_EMP_LINK UEL\n" +
                    "                              WHERE UEL.ID_PERSON IN (\n" +
                    "                                   SELECT SPL.ID_PERSON\n" +
                    "                                   FROM STAGE_PERSON_LINK SPL\n" +
                    "                                   WHERE SPL.ID_STAGE = ? \n" + //ulIdStage 14
                    "                                   AND SPL.CD_STAGE_PERS_ROLE IN ('PR', 'SE')\n" +
                    "                                   )\n" +
                    "                                   AND UEL.CD_UNIT_MEMBER_IN_OUT IN('IN','OUT')\n" +
                    "                              )\n" +
                    "                       )\n" +
                    "            CONNECT BY (\n" +
                    "                    PRIOR U.ID_UNIT = U.ID_UNIT_PARENT\n" +
                    "                    AND U.ID_UNIT <> U.ID_UNIT_PARENT\n" +
                    "                    AND U.CD_COUNTY <> 'XXX'\n" +
                    "                    AND PRIOR U.CD_COUNTY = U.CD_COUNTY\n" +
                    "            )\n" +
                    "            INTERSECT\n" +
                    "                  SELECT U.ID_PERSON\n" +
                    "                  FROM UNIT U, UNIT_EMP_LINK UEL\n" +
                    "                  WHERE (UEL.ID_PERSON = ? \n" + //ulIdPerson 15
                    "                  OR UEL.ID_PERSON IN (SELECT ETA.ID_PERSON_EMP\n" +
                    "                                   FROM EMP_TEMP_ASSIGN ETA\n" +
                    "                                                  WHERE ETA.ID_PERSON_DESIGNEE = ? \n" + //ulIdPerson 16
                    "                                                  AND NOT ETA.DT_ASSIGN_EXPIRATION <= ?))\n" + //now 17
                    "                  AND UEL.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' )\n" +
                    "                  AND UEL.CD_UNIT_MEMBER_IN_OUT IN ('IN', 'OUT')\n" +
                    "                  AND U.ID_UNIT =  UEL.ID_UNIT)\n" +
                    // this part checks if stage is temporarily assigned on user's workload
                    "OR EXISTS\n" +
                    "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                    "   FROM TEMP_STAGE_PERS_LINK, \n" +
                    "        UNIT_EMP_LINK \n" +
                    "  WHERE UNIT_EMP_LINK.ID_PERSON = ? \n" + // ulIdPerson 18
                    "    AND TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE = ? \n" + // ulIdStage 19
                    "    AND TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE_PERSON = ? \n" + // ulIdPerson 20
                    "    AND TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ))\n" +
                    // This part checks to see if the user is a designee of the person temporarily assigned to the stage
                    "OR EXISTS\n" +
                    "(SELECT EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE \n" +
                    "   FROM EMP_TEMP_ASSIGN, TEMP_STAGE_PERS_LINK \n" +
                    "  WHERE EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = ? \n" + // ulIdPerson 21
                    "    AND NOT EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= ? \n" + // now 22
                    "    AND TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE = ? \n" + // ulIdStage 23
                    "    AND TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP \n" +
                    "    AND TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ))\n" +
                    // This part checks to see if the user is a supervisor of a person who is temporarily assigned to the stage
                    "OR EXISTS\n" +
                    "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                    "   FROM UNIT_EMP_LINK, \n" +
                    "        ( SELECT UNIT_EMP_LINK.ID_UNIT \n" +
                    "            FROM UNIT_EMP_LINK, \n" +
                    "                 ( SELECT TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE_PERSON ID_PERSON \n" +
                    "                     FROM TEMP_STAGE_PERS_LINK \n" +
                    "                    WHERE TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE = ? \n" + // ulIdStage 24
                    "                      AND TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS \n" +
                    "           WHERE UNIT_EMP_LINK.ID_PERSON = STAGE_WORKERS.ID_PERSON ) STAGE_UNITS \n" + 
                    "  WHERE UNIT_EMP_LINK.ID_PERSON = ? \n" + // ulIdPerson 25
                    "    AND UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT \n" +
                    "    AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' ))\n" +
                    // This part checks to see if the user is a designee of a supervisor of a person
                    //   who is temporarily assigned to the stage
                    "OR EXISTS\n" +
                    "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                    "   FROM UNIT_EMP_LINK, EMP_TEMP_ASSIGN, \n" +
                    "        ( SELECT UNIT_EMP_LINK.ID_UNIT \n" +
                    "            FROM UNIT_EMP_LINK, \n" +
                    "                 ( SELECT TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE_PERSON ID_PERSON \n" +
                    "                     FROM TEMP_STAGE_PERS_LINK \n" +
                    "                    WHERE TEMP_STAGE_PERS_LINK.ID_TEMP_STAGE = ? \n" + // ulIdStage 26
                    "                      AND TEMP_STAGE_PERS_LINK.CD_TEMP_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS \n" +
                    "           WHERE UNIT_EMP_LINK.ID_PERSON = STAGE_WORKERS.ID_PERSON ) STAGE_UNITS \n" + 
                    "  WHERE UNIT_EMP_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP \n" +
                    "    AND UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT \n" +
                    "    AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' ) \n" +
                    "    AND EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = ? \n" + // ulIdPerson 27
                    "    AND NOT EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= ?)\n" +// now 28
                  // This part checks to see if the user is a designee of parent supervisors in the unit hierarchy of a person
                  //   who is temporarily assigned to the stage
                   " OR EXISTS (SELECT U.ID_PERSON \n" +
                   "            FROM UNIT U\n" +
                   "            START WITH U.ID_UNIT IN (\n" +
                   "                      SELECT ID_UNIT_PARENT \n" +
                   "                      FROM UNIT \n" +
                   "                      WHERE ID_UNIT IN (\n" +
                   "                              SELECT UEL.ID_UNIT \n" +
                   "                              FROM UNIT_EMP_LINK UEL\n" +
                   "                              WHERE UEL.ID_PERSON IN (\n" +
                   "                                   SELECT SPL.ID_TEMP_STAGE_PERSON\n" +
                   "                                   FROM TEMP_STAGE_PERS_LINK SPL\n" +
                   "                                   WHERE SPL.ID_TEMP_STAGE = ? \n" + //ulIdStage 29
                   "                                   AND SPL.CD_TEMP_STAGE_PERS_ROLE IN ('PR', 'SE')\n" +
                   "                                   )\n" +
                   "                                   AND UEL.CD_UNIT_MEMBER_IN_OUT IN('IN','OUT')\n" +
                   "                              )\n" +
                   "                       )\n" +
                   "            CONNECT BY (\n" +
                   "                    PRIOR U.ID_UNIT = U.ID_UNIT_PARENT\n" +
                   "                    AND U.ID_UNIT <> U.ID_UNIT_PARENT\n" +
                   "                    AND U.CD_COUNTY <> 'XXX'\n" +
                   "                    AND PRIOR U.CD_COUNTY = U.CD_COUNTY\n" +
                   "            )\n" +
                   "            INTERSECT\n" +
                   "                  SELECT U.ID_PERSON\n" +
                   "                  FROM UNIT U, UNIT_EMP_LINK UEL\n" +
                   "                  WHERE (UEL.ID_PERSON = ? \n" + //ulIdPerson 30
                   "                  OR UEL.ID_PERSON IN (SELECT ETA.ID_PERSON_EMP\n" +
                   "                                   FROM EMP_TEMP_ASSIGN ETA\n" +
                   "                                                  WHERE ETA.ID_PERSON_DESIGNEE = ? \n" + //ulIdPerson 31
                   "                                                  AND NOT ETA.DT_ASSIGN_EXPIRATION <= ?))\n" + //now 32
                   "                  AND UEL.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' )\n" +
                   "                  AND UEL.CD_UNIT_MEMBER_IN_OUT IN ('IN', 'OUT')\n" +
                   "                  AND U.ID_UNIT =  UEL.ID_UNIT)\n" ;
      preparedStatement = connection.prepareStatement(sql);

      // Current time
      Timestamp now = new Timestamp(System.currentTimeMillis());

      // Add variables to statement
      preparedStatement.setInt(1, userId);
      preparedStatement.setInt(2, ulIdStage);
      preparedStatement.setInt(3, userId);
      preparedStatement.setInt(4, userId);
      preparedStatement.setTimestamp(5, now);
      preparedStatement.setInt(6, ulIdStage);
      preparedStatement.setInt(7, ulIdStage);
      preparedStatement.setInt(8, ulIdStage);
      preparedStatement.setInt(9, userId);
      preparedStatement.setInt(10, ulIdStage);
      preparedStatement.setInt(11, ulIdStage);
      preparedStatement.setInt(12, userId);
      preparedStatement.setTimestamp(13, now);
      preparedStatement.setInt(14, ulIdStage);
      preparedStatement.setInt(15, userId);
      preparedStatement.setInt(16, userId);
      preparedStatement.setTimestamp(17, now);
      preparedStatement.setInt(18, userId);
      preparedStatement.setInt(19, ulIdStage);
      preparedStatement.setInt(20, userId);
      preparedStatement.setInt(21, userId);
      preparedStatement.setTimestamp(22, now);
      preparedStatement.setInt(23, ulIdStage);
      preparedStatement.setInt(24, ulIdStage);
      preparedStatement.setInt(25, userId);
      preparedStatement.setInt(26, ulIdStage);
      preparedStatement.setInt(27, userId);
      preparedStatement.setTimestamp(28, now);
      preparedStatement.setInt(29, ulIdStage);
      preparedStatement.setInt(30, userId);
      preparedStatement.setInt(31, userId);
      preparedStatement.setTimestamp(32, now);

      // Set the fetch size to 1 because we will just be testing to see if there is at least 1 result
      preparedStatement.setFetchSize(1);

      // Execute the sql and set bStageAccess based on if any rows are returned
      rs = preparedStatement.executeQuery();
      bStageAccess = rs.next() || isSuperiorUnit(userId, ulIdStage);
    } catch (SQLException e) {
      // Return return false;
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, rs);
    }

    performanceTrace.exitScope(bStageAccess);
    // return value from service
    return bStageAccess;
  }

  /**
   * This query does the following : 
   * <li> 1. From the STAGE_PERSON_LINK, it gets the persons with role 'PR', 'SE' of the passed in <BR>
   *         Stage and get their Units (Temporary Unit assignments excluded)</li>
   * <li> 2. Recursively find the parent Units of the primary and secondary assignment's Units<BR>
   *         It will stop once it reaches the top county Unit as the parent Unit(county code = 'XXX')</li>
   * <li> 3.Finds the permanent Unit number for the logged in User(Temporary Unit assignments excluded)</li>
   * <li> 4. Then get the common rows between the two results using an 'INTERSECT'</li>
   *
   * @param userId
   * @param ulIdStage
   * @return bIsSuperior, a boolean indicating wether the person logged in is in a superior<BR>
   *         (above in Unit hierarchy) Unit than that of the Units of the primary and secondary <BR> 
   *         assignments of the passed in Stage
   */
  private static boolean isSuperiorUnit(int userId, int ulIdStage) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".hasSuperiorUnit");
    performanceTrace.enterScope();
    boolean bIsSuperior = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      String sql = " SELECT U.ID_UNIT\n" +
       "FROM UNIT U\n" +
       "START WITH U.ID_UNIT IN (SELECT ID_UNIT_PARENT FROM UNIT WHERE ID_UNIT IN (SELECT UEL.ID_UNIT FROM UNIT_EMP_LINK UEL\n" + 
       "                                                    WHERE UEL.ID_PERSON IN (SELECT SPL.ID_PERSON\n" + 
       "                                                                            FROM STAGE_PERSON_LINK SPL\n" + 
       "                                                                           WHERE SPL.ID_STAGE = ?\n" + 
       "                                                                           AND SPL.CD_STAGE_PERS_ROLE IN ('PR', 'SE'))\n" + 
       "                                                    AND UEL.CD_UNIT_MEMBER_IN_OUT IN('IN','OUT')))\n" + 
       "CONNECT BY (PRIOR U.ID_UNIT_PARENT  = U.ID_UNIT\n" + 
       "             AND U.ID_UNIT <> U.ID_UNIT_PARENT\n" +
       "             AND U.CD_COUNTY <> 'XXX'\n" + 
       "             AND PRIOR U.CD_COUNTY = U.CD_COUNTY)\n" + 
       "INTERSECT\n" + 
       "SELECT U.ID_UNIT\n" + 
       "FROM UNIT U, UNIT_EMP_LINK UEL\n" + 
       "WHERE UEL.ID_PERSON = ?\n" +
       "AND UEL.CD_UNIT_MEMBER_IN_OUT IN ('IN','OUT')\n" + //WAS ='IN'
       "AND U.ID_UNIT =  UEL.ID_UNIT\n";

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, ulIdStage);
      preparedStatement.setInt(2, userId);
      rs = preparedStatement.executeQuery();
      bIsSuperior = rs.next();
    } catch (SQLException e) {
      // Return return false;
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, rs);
    }
    performanceTrace.exitScope(bIsSuperior);
    // return value from service
    return bIsSuperior;
  }

  /**
   * Looks at the case to determine if the given user has access to any open stage.<br> Use this version of the method
   * if you want to test access for the current user.<br> The following items are checked: <br> <li>primary worker
   * assigned to stage</li> <li>one of the four secondary workers assigned to the stage</li> <li>the supervisor of any
   * of the above</li> <li>the designee of any of the above supervisors</li>
   *
   * @param userId
   * @param ulIdCase case id to check
   * @return whether or not the user has access
   */
  public static boolean hasStageAccessToAnyOpenStage(int userId, int ulIdCase) {
    return hasStageAccessToAnyStage(userId, ArchitectureConstants.N, ulIdCase);
  }

  /**
   * Looks at the case to determine if the given user has access to any closed stage.<br> Use this version of the method
   * if you want to test access for the current user.<br> The following items are checked: <br> <li>primary worker
   * assigned to stage</li> <li>one of the four secondary workers assigned to the stage</li> <li>the supervisor of any
   * of the above</li> <li>the designee of any of the above supervisors</li>
   *
   * @param userId
   * @param ulIdCase case id to check
   * @return whether or not the user has access
   */
  public static boolean hasStageAccessToAnyClosedStage(int userId, int ulIdCase) {
    return hasStageAccessToAnyStage(userId, ArchitectureConstants.Y, ulIdCase);
  }

  /**
   * Looks at the case to determine if the given user has access to any open or closed stage, depending on whether
   * indStageClose is set.<br> Use this version of the method if you want to test access for the current user.<br> The
   * following items are checked: <br> <li>primary worker assigned to stage</li> <li>one of the four secondary workers
   * assigned to the stage</li> <li>the supervisor of any of the above</li> <li>the designee of any of the above
   * supervisors</li>
   *
   * @param userId        the id of of the user to check
   * @param indStageClose whether or not the stage is closed
   * @param ulIdCase      case id to check
   * @return whether or not the user has access
   */
  public static boolean hasStageAccessToAnyStage(int userId, String indStageClose, int ulIdCase) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".hasStageAccessToAnyStage");
    performanceTrace.enterScope();
    boolean bStageAccess = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // The first part checks to see if the user is directly assigned to any stage in the case.
      String sql = "SELECT 'x' FROM DUAL WHERE EXISTS\n" +
                   "(SELECT STAGE_PERSON_LINK.ID_PERSON \n" +
                   "   FROM STAGE, \n" +
                   "        STAGE_PERSON_LINK \n" +
                   "  WHERE STAGE_PERSON_LINK.ID_CASE = ? \n" + // ulIdCase 1
                   "    AND STAGE_PERSON_LINK.ID_PERSON = ? \n" + // ulIdPerson 2
                   "    AND STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE \n" +
                   "    AND STAGE.IND_STAGE_CLOSE = ? \n" + // indStageClose 3
                   "    AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ))\n" +
                   // This part checks to see if the user is a designee of the person
                   // assigned to any stage in the case.
                   "OR EXISTS\n" +
                   "(SELECT EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE \n" +
                   "   FROM STAGE, \n" +
                   "        STAGE_PERSON_LINK, \n" +
                   "        EMP_TEMP_ASSIGN \n" +
                   "  WHERE EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = ? \n" + // ulIdPerson 4
                   "    AND EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= ? \n" + // now 5
                   "    AND STAGE_PERSON_LINK.ID_CASE = ? \n" + // ulIdCase 6
                   "    AND STAGE_PERSON_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP \n" +
                   "    AND STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE \n" +
                   "    AND STAGE.IND_STAGE_CLOSE = ? \n" + // indStageClose 7
                   "    AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ))\n" +
                   // This part checks to see if the user is a supervisor of a person
                   // who is assigned to any stage in the case. It joins UNIT_EMP_LINK
                   // table because CD_UNIT_MEMBER_ROLE column allows you to determine
                   // if the person is supervisor.
                   "OR EXISTS\n" +
                   "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                   "   FROM UNIT_EMP_LINK, \n" +
                   "        ( SELECT UNIT_EMP_LINK.ID_UNIT \n" +
                   "            FROM UNIT_EMP_LINK, \n" +
                   "                 ( SELECT STAGE_PERSON_LINK.ID_PERSON \n" +
                   "                     FROM STAGE, \n" +
                   "                          STAGE_PERSON_LINK \n" +
                   "                    WHERE STAGE_PERSON_LINK.ID_CASE = ? \n" + // ulIdCase 8
                   "                      AND STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE \n" +
                   "                      AND STAGE.IND_STAGE_CLOSE = ? \n" + // indStageClose 9
                   "                      AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS \n" +
                   "           WHERE UNIT_EMP_LINK.ID_PERSON = STAGE_WORKERS.ID_PERSON \n" +
                   "           UNION SELECT ID_UNIT \n" +
                   "            FROM STAGE \n" +
                   "           WHERE ID_CASE = ? \n" + // ulIdCase 10
                   "             AND IND_STAGE_CLOSE = ? ) STAGE_UNITS \n" + // indStageClose 11
                   "  WHERE UNIT_EMP_LINK.ID_PERSON = ? \n" + // ulIdPerson 12
                   "    AND UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT \n" +
                   "    AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( ?, ?, ? ))\n" + // role 13, role 14, role 15
                   // This part checks to see if the user is a designee of a supervisor
                   // of a person who is assigned to any stage in the case. It joins
                   // UNIT_EMP_LINK table because CD_UNIT_MEMBER_ROLE column allows
                   // you to determine if the person is supervisor.
                   "OR EXISTS\n" +
                   "(SELECT UNIT_EMP_LINK.ID_PERSON \n" +
                   "  FROM UNIT_EMP_LINK, EMP_TEMP_ASSIGN, \n" +
                   "       ( SELECT UNIT_EMP_LINK.ID_UNIT \n" +
                   "           FROM UNIT_EMP_LINK, \n" +
                   "                ( SELECT STAGE_PERSON_LINK.ID_PERSON \n" +
                   "                    FROM STAGE, \n" +
                   "                         STAGE_PERSON_LINK \n" +
                   "                   WHERE STAGE_PERSON_LINK.ID_CASE = ? \n" + // ulIdCase 16
                   "                     AND STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE \n" +
                   "                     AND STAGE.IND_STAGE_CLOSE = ? \n" + // indStageClose 17
                   "                     AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS \n" +
                   "          WHERE UNIT_EMP_LINK.ID_PERSON = STAGE_WORKERS.ID_PERSON \n" +
                   "          UNION SELECT ID_UNIT \n" +
                   "           FROM STAGE \n" +
                   "          WHERE ID_CASE = ? \n" + // ulIdCase 18
                   "            AND IND_STAGE_CLOSE = ? ) STAGE_UNITS \n" + // indStageClose 19
                   " WHERE UNIT_EMP_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP \n" +
                   "   AND UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT \n" +
                   "   AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( ?, ?, ? ) \n" + // role 20, role 21, role 22
                   "   AND EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = ? \n" + // ulIdPerson 23
                   "   AND EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= ?)"; // now 24
      preparedStatement = connection.prepareStatement(sql);

      // Current time
      Timestamp now = new Timestamp(System.currentTimeMillis());

      // Add variables to statement
      preparedStatement.setInt(1, ulIdCase);
      preparedStatement.setInt(2, userId);
      preparedStatement.setString(3, indStageClose);
      preparedStatement.setInt(4, userId);
      preparedStatement.setTimestamp(5, now);
      preparedStatement.setInt(6, ulIdCase);
      preparedStatement.setString(7, indStageClose);
      preparedStatement.setInt(8, ulIdCase);
      preparedStatement.setString(9, indStageClose);
      preparedStatement.setInt(10, ulIdCase);
      preparedStatement.setString(11, indStageClose);
      preparedStatement.setInt(12, userId);
      preparedStatement.setString(13, CodesTables.CUNMBRRL_20);
      preparedStatement.setString(14, CodesTables.CUNMBRRL_30);
      preparedStatement.setString(15, CodesTables.CUNMBRRL_40);
      preparedStatement.setInt(16, ulIdCase);
      preparedStatement.setString(17, indStageClose);
      preparedStatement.setInt(18, ulIdCase);
      preparedStatement.setString(19, indStageClose);
      preparedStatement.setString(20, CodesTables.CUNMBRRL_20);
      preparedStatement.setString(21, CodesTables.CUNMBRRL_30);
      preparedStatement.setString(22, CodesTables.CUNMBRRL_40);
      preparedStatement.setInt(23, userId);
      preparedStatement.setTimestamp(24, now);

      // Set the fetch size to 1 because we will just be testing to see if there is at least 1 result
      preparedStatement.setFetchSize(1);

      // Execute the sql and set bStageAccess based on if any rows are returned
      rs = preparedStatement.executeQuery();
      bStageAccess = rs.next();
      /*
       * SELECT UNIT_EMP_LINK.ID_PERSON FROM STAGE, STAGE_PERSON_LINK, UNIT_EMP_LINK WHERE UNIT_EMP_LINK.ID_PERSON =
       * :ulIdPerson AND STAGE_PERSON_LINK.ID_CASE = :ulIdCase AND STAGE_PERSON_LINK.ID_PERSON = :ulIdPerson AND
       * STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE AND STAGE.IND_STAGE_CLOSE = :indStageClose AND
       * STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) UNION SELECT EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE
       * FROM STAGE, STAGE_PERSON_LINK, UNIT_EMP_LINK, EMP_TEMP_ASSIGN WHERE EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE =
       * :ulIdPerson AND NOT EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= :now AND STAGE_PERSON_LINK.ID_CASE = :ulIdCase AND
       * STAGE_PERSON_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP AND STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE AND
       * STAGE.IND_STAGE_CLOSE = :indStageClose AND STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) UNION
       * SELECT UNIT_EMP_LINK.ID_PERSON FROM UNIT_EMP_LINK, ( SELECT UNIT_EMP_LINK.ID_UNIT FROM UNIT_EMP_LINK, ( SELECT
       * STAGE_PERSON_LINK.ID_PERSON FROM STAGE, STAGE_PERSON_LINK WHERE STAGE_PERSON_LINK.ID_CASE = :ulIdCase AND
       * STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE AND STAGE.IND_STAGE_CLOSE = :indStageClose AND
       * STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS WHERE UNIT_EMP_LINK.ID_PERSON =
       * STAGE_WORKERS.ID_PERSON UNION SELECT ID_UNIT FROM STAGE WHERE ID_CASE = :ulIdCase AND IND_STAGE_CLOSE =
       * :indStageClose ) STAGE_UNITS WHERE UNIT_EMP_LINK.ID_PERSON = :ulIdPerson AND UNIT_EMP_LINK.ID_UNIT =
       * STAGE_UNITS.ID_UNIT AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' ) UNION SELECT
       * UNIT_EMP_LINK.ID_PERSON FROM UNIT_EMP_LINK, EMP_TEMP_ASSIGN, ( SELECT UNIT_EMP_LINK.ID_UNIT FROM UNIT_EMP_LINK, (
       * SELECT STAGE_PERSON_LINK.ID_PERSON FROM STAGE, STAGE_PERSON_LINK WHERE STAGE_PERSON_LINK.ID_CASE = :ulIdCase
       * AND STAGE_PERSON_LINK.ID_STAGE = STAGE.ID_STAGE AND STAGE.IND_STAGE_CLOSE = :indStageClose AND
       * STAGE_PERSON_LINK.CD_STAGE_PERS_ROLE IN ( 'PR', 'SE', 'HP' ) ) STAGE_WORKERS WHERE UNIT_EMP_LINK.ID_PERSON =
       * STAGE_WORKERS.ID_PERSON UNION SELECT ID_UNIT FROM STAGE WHERE ID_CASE = :ulIdCase AND IND_STAGE_CLOSE =
       * :indStageClose ) STAGE_UNITS WHERE UNIT_EMP_LINK.ID_PERSON = EMP_TEMP_ASSIGN.ID_PERSON_EMP AND
       * UNIT_EMP_LINK.ID_UNIT = STAGE_UNITS.ID_UNIT AND UNIT_EMP_LINK.CD_UNIT_MEMBER_ROLE IN ( '20', '30', '40' ) AND
       * EMP_TEMP_ASSIGN.ID_PERSON_DESIGNEE = :ulIdPerson AND NOT EMP_TEMP_ASSIGN.DT_ASSIGN_EXPIRATION <= :now;
       */
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, rs);
    }

    performanceTrace.exitScope(bStageAccess);
    // return value from service
    return bStageAccess;
  }

  /**
   * Check to see if the given stage has a stage closure event that is in PEND status.
   *
   * @param ulIdStage id stage to check
   * @return whether or not the event has been submitted for approval
   */
  public static int getPendingStageClosureEvent(int ulIdStage) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".isStageClosurePendingApproval");
    performanceTrace.enterScope();
    int idPendingStageClosureEvent = 0;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Get a connection to the database
      connection = JdbcHelper.getConnection();

      // Create the sql statement
      String sql = "SELECT E.ID_EVENT " +
                   "FROM EVENT E, STAGE S, TASK T " +
                   "WHERE E.ID_EVENT_STAGE = ? " +
                   "AND S.ID_STAGE = ? " +
                   "AND E.ID_EVENT_STAGE = S.ID_STAGE " +
                   "AND E.CD_TASK = T.CD_TASK " +
                   "AND T.IND_STAGE_CLOSURE = '1' " +
                   "AND E.CD_EVENT_STATUS = 'PEND' " +
                   "ORDER BY E.DT_LAST_UPDATE DESC";
      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulIdStage);
      preparedStatement.setInt(2, ulIdStage);

      // Execute the sql
      resultSet = preparedStatement.executeQuery();
      /*
       * SELECT E.ID_EVENT FROM EVENT E, STAGE S, TASK T WHERE E.ID_EVENT_STAGE = :hostulIdStage:hostulIdStage_ind AND
       * S.ID_STAGE = :hostulIdStage:hostulIdStage_ind AND E.ID_EVENT_STAGE = S.ID_STAGE AND E.CD_TASK = T.CD_TASK AND
       * T.IND_STAGE_CLOSURE = '1' AND E.CD_EVENT_STATUS = 'PEND' ORDER BY E.DT_LAST_UPDATE DESC
       */
      if (resultSet.next()) {
        idPendingStageClosureEvent = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope();
    // return value from service
    return idPendingStageClosureEvent;
  }

  public static String getCdMobileStatus(int idCase) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getCdMobileStatus");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String cdMobileStatus = null;
    try {
      connection = JdbcHelper.getConnection();
      preparedStatement = connection.prepareStatement(MOBILE_STATUS_SQL, ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);
      preparedStatement.setInt(1, idCase);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        cdMobileStatus = resultSet.getString(1);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    performanceTrace.exitScope(cdMobileStatus);
    return cdMobileStatus;
  }

  /** Inner class for holding infromation about an Approval Todo */
  public static class ToDo implements Serializable {
    private int idTodo = 0;
    private int idPersonAssigned = 0;
    private int idCase = 0;
    private String nmCase = null;
    private int idStage = 0;
    private String nmStage = null;
    private String cdStage = null;
    private String cdStageProgram = null;
    private String cdStageType = null;
    private int idEvent = 0;
    private String cdEventStatus = null;
    private String cdTask = null;
    private String cdTaskEventType = null;
    private boolean indStageClosure = false;
    private String txtEventDetailUrl = null;

    public ToDo(int idTodo, int idEvent, String cdEventStatus) {
      this.idTodo = idTodo;
      this.idEvent = idEvent;
      this.cdEventStatus = cdEventStatus;
    }

    public ToDo(int idTodo, int idPersonAssigned, int idCase, String nmCase, int idStage, String nmStage,
                String cdStage, String cdStageProgram, String cdStageType, int idEvent, String cdEventStatus,
                String cdTask,
                String cdTaskEventType, boolean indStageClosure, String txtEventDetailUrl) {
      this.idTodo = idTodo;
      this.idPersonAssigned = idPersonAssigned;
      this.idCase = idCase;
      this.nmCase = nmCase;
      this.idStage = idStage;
      this.nmStage = nmStage;
      this.cdStage = cdStage;
      this.cdStageProgram = cdStageProgram;
      this.cdStageType = cdStageType;
      this.idEvent = idEvent;
      this.cdEventStatus = cdEventStatus;
      this.cdTask = cdTask;
      this.cdTaskEventType = cdTaskEventType;
      this.indStageClosure = indStageClosure;
      this.txtEventDetailUrl = txtEventDetailUrl;
    }

    public int getIdTodo() {
      return idTodo;
    }

    public void setIdTodo(int idTodo) {
      this.idTodo = idTodo;
    }

    public int getIdPersonAssigned() {
      return idPersonAssigned;
    }

    public void setIdPersonAssigned(int idPersonAssigned) {
      this.idPersonAssigned = idPersonAssigned;
    }

    public int getIdCase() {
      return idCase;
    }

    public void setIdCase(int idCase) {
      this.idCase = idCase;
    }

    public String getNmCase() {
      return nmCase;
    }

    public void setNmCase(String nmCase) {
      this.nmCase = nmCase;
    }

    public int getIdStage() {
      return idStage;
    }

    public void setIdStage(int idStage) {
      this.idStage = idStage;
    }

    public String getNmStage() {
      return nmStage;
    }

    public void setNmStage(String nmStage) {
      this.nmStage = nmStage;
    }

    public String getCdStage() {
      return cdStage;
    }

    public void setCdStage(String cdStage) {
      this.cdStage = cdStage;
    }

    public String getCdStageProgram() {
      return cdStageProgram;
    }

    public void setCdStageProgram(String cdStageProgram) {
      this.cdStageProgram = cdStageProgram;
    }

    public String getCdStageType() {
      return cdStageType;
    }

    public void setCdStageType(String cdStageType) {
      this.cdStageType = cdStageType;
    }

    public int getIdEvent() {
      return idEvent;
    }

    public void setIdEvent(int idEvent) {
      this.idEvent = idEvent;
    }

    public String getCdEventStatus() {
      return cdEventStatus;
    }

    public void setCdEventStatus(String cdEventStatus) {
      this.cdEventStatus = cdEventStatus;
    }

    public String getCdTask() {
      return cdTask;
    }

    public void setCdTask(String cdTask) {
      this.cdTask = cdTask;
    }

    public String getCdTaskEventType() {
      return cdTaskEventType;
    }

    public void setCdTaskEventType(String cdTaskEventType) {
      this.cdTaskEventType = cdTaskEventType;
    }

    public boolean isIndStageClosure() {
      return indStageClosure;
    }

    public void setIndStageClosure(boolean indStageClosure) {
      this.indStageClosure = indStageClosure;
    }

    public String getTxtEventDetailUrl() {
      return txtEventDetailUrl;
    }

    public void setTxtEventDetailUrl(String txtEventDetailUrl) {
      this.txtEventDetailUrl = txtEventDetailUrl;
    }
  }

  /** Inner class for holding information about a case */
  public static class Stage implements Serializable {

    private int idStage = 0;
    private int idCase = 0;
    private int idSituation = 0;
    private String nmStage = "";
    private String cdStage = "";
    private String cdStageType = "";
    private String cdStageProgram = "";
    private org.exolab.castor.types.Date dtStart = null;
    private org.exolab.castor.types.Date dtClose = null;
    private String indStageClose = "";
    private String cdStageReasonClosed = "";
    private String nmCase = null;
    private String indSealed = "";
    private String indSensitive = ""; 
    private org.exolab.castor.types.Date dtSealed = null;

    /**
     * Required because it must be serializable.
     */
    public Stage() {
    }

    public Stage(int idStage, int idCase, int idSituation, String nmStage, String cdStage, String cdStageType,
                 String cdStageProgram, String dtStart, String dtClose, String indStageClose,
                 String cdStageReasonClosed, String nmCase, String indSealed, String indSensitive, String dtSealed) {
      this.idStage = idStage;
      this.idCase = idCase;
      this.idSituation = idSituation;
      this.nmStage = nmStage;
      this.cdStage = cdStage;
      this.cdStageType = cdStageType;
      this.cdStageProgram = cdStageProgram;
      this.dtStart = DateHelper.toCastorDateSafe(dtStart);
      this.dtClose = DateHelper.toCastorDateSafe(dtClose);
      this.indStageClose = indStageClose;
      this.cdStageReasonClosed = cdStageReasonClosed;
      this.nmCase = nmCase;
      this.indSealed = indSealed;
      this.indSensitive = indSensitive;
      this.dtSealed = DateHelper.toCastorDateSafe(dtSealed);
    }

    public int getIdStage() {
      return idStage;
    }

    public void setIdStage(int idStage) {
      this.idStage = idStage;
    }

    public int getIdCase() {
      return idCase;
    }

    public void setIdCase(int idCase) {
      this.idCase = idCase;
    }

    public String getNmStage() {
      return nmStage;
    }

    public void setNmStage(String nmStage) {
      this.nmStage = nmStage;
    }

    public String getCdStage() {
      return cdStage;
    }

    public void setCdStage(String cdStage) {
      this.cdStage = cdStage;
    }

    public String getCdStageType() {
      return cdStageType;
    }

    public void setCdStageType(String cdStageType) {
      this.cdStageType = cdStageType;
    }

    public String getCdStageProgram() {
      return cdStageProgram;
    }

    public void setCdStageProgram(String cdStageProgram) {
      this.cdStageProgram = cdStageProgram;
    }

    public org.exolab.castor.types.Date getDtStart() {
      return dtStart;
    }

    public void setDtStart(org.exolab.castor.types.Date dtStart) {
      this.dtStart = dtStart;
    }

    public org.exolab.castor.types.Date getDtClose() {
      return dtClose;
    }

    public void setDtClose(org.exolab.castor.types.Date dtClose) {
      this.dtClose = dtClose;
    }

    public String getIndStageClose() {
      return indStageClose;
    }

    public void setIndStageClose(String indStageClose) {
      this.indStageClose = indStageClose;
    }

    public String getCdStageReasonClosed() {
      return cdStageReasonClosed;
    }

    public void setCdStageReasonClosed(String cdStageReasonClosed) {
      this.cdStageReasonClosed = cdStageReasonClosed;
    }

    public String getNmCase() {
      return nmCase;
    }

    public void setNmCase(String nmCase) {
      this.nmCase = nmCase;
    }

    /** sets the id situation */
    public void setIdSituation(int idSituation) {
      this.idSituation = idSituation;
    }

    /** gets the id for the situation */
    public int getIdSituation() {
      return this.idSituation;
    }

    public String getIndSealed() {
      return indSealed;
    }

    public void setIndSealed(String indSealed) {
      this.indSealed = indSealed;
    }

    public String getIndSensitive() {
      return indSensitive;
    }

    public void setIndSensitive(String indSensitive) {
      this.indSensitive = indSensitive;
    }

    public org.exolab.castor.types.Date getDtSealed() {
      return dtSealed;
    }

    public void setDtSealed(org.exolab.castor.types.Date dtSealed) {
      this.dtSealed = dtSealed;
    }
  }

  /**
   * Returns the role of a person in a stage, provided the case is in that person's workload. If the person does not
   * have a role, or the stage is no in their workload, will return empty string (""). Should always return PRIMARY
   * ("PR") or SECONDARY ("SE").
   *
   * @param ulIdPerson
   * @param ulIdStage
   * @return the role of the person in that stage in their workload.
   */
  public static String getRoleInWorkloadStage(int ulIdStage, int ulIdPerson) {
    Connection connection = null;
    try {
      connection = JdbcHelper.getConnection();
      return getRoleInWorkloadStage(ulIdStage, ulIdPerson, connection);
    } catch (SQLException sqle) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception closing statement or connection: " + sqle.getMessage());
      throw new RuntimeWrappedException(sqle);
    } finally {
      cleanup(connection, null, null);
    }
  }

  /**
   * Returns the role of a person in a stage, provided the case is in that person's workload. If the person does not
   * have a role, or the stage is no in their workload, will return empty string (""). Should always return PRIMARY
   * ("PR") or SECONDARY ("SE").
   *
   * @param ulIdPerson
   * @param ulIdStage
   * @param connection
   * @return the role of the person in that stage in their workload.
   * @throws SQLException
   */
  protected static String getRoleInWorkloadStage(int ulIdStage, int ulIdPerson, Connection connection)
          throws SQLException {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Create the sql statement
      String sql = "select id_wkld_stage, cd_wkld_stage_pers_role  from workload " +
                   "where id_wkld_stage = ? and id_wkld_person = ?";

      preparedStatement = connection.prepareStatement(sql);

      // Add variables to statement
      preparedStatement.setInt(1, ulIdStage);
      preparedStatement.setInt(2, ulIdPerson);

      // Execute the sql
      preparedStatement.execute();
      /*
       * select id_wkld_stage from workload where id_wkld_stage = :id_stage and id_wkld_person = :id_person;
       */

      // Get the result set
      resultSet = preparedStatement.getResultSet();

      // Get the role from the resultSet
      String role = "";
      if (resultSet.next()) {
        role = resultSet.getString("cd_wkld_stage_pers_role");
      }
      // Log Performance time for first sql
      return role;
    } finally {
      cleanup(null, preparedStatement, resultSet);
    }
  }

  /**
   * Method getCaseCheckoutStatus<p/>Written by Patrick Coogan
   * <p/>
   * SIR 23572 - This method checks if the passed stage is currently checked out to the MPS Mobile device and returns a
   * boolean value. The indicator for checked out cases is the CD_MOBILE_STATUS column on the Workload table.
   * <p/>
   * SIR 23726 - Check for SVC as well as INV stages
   *
   * @param ulIdStage Stage ID
   * @return Boolean
   */
  public static boolean getCaseCheckoutStatus(int ulIdStage) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".getCaseCheckoutStatus");
    performanceTrace.enterScope();
    String status = null;
    String checkoutstatus = "OT"; // Indicator in Workload table for checked out case
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean checkout = false;

    try {
      connection = JdbcHelper.getConnection();

      String sql = GET_CHECKOUT_STATUS_SQL;

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, ulIdStage);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        status = resultSet.getString(1);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    if (status != null && status.equals(checkoutstatus)) {
      checkout = true;
    }

    performanceTrace.exitScope();
    return checkout;
  }

  /**
   * Method getCaseCheckoutStatus(List UlIdStages)<p/>Written by Patrick Coogan
   * <p/>
   * SIR 23726 - Method getCaseCheckoutStatus - returns boolean true if any member of a passed integer array of
   * stageID's is checked out to MPS, using the getCheckedOutStages method
   *
   * @param ulIdStages List Stage ID's
   * @return Boolean
   */

  public static boolean getCaseCheckoutStatus(List ulIdStages) {
    boolean checkedout = false;

    if (!getCheckedOutStages(ulIdStages).isEmpty()) {
      checkedout = true;
    }
    return checkedout;
  }

  /**
   * Method getCheckedOutStages<p/>Written by Patrick Coogan
   * <p/>
   * SIR 23726 returns an integer array of stage ID's representing the subset of a passed integer array of stage ID's
   * that are currently checked out to MPS
   *
   * @param ulIdStages List Stage ID's
   * @return Integer List Stage ID's
   */

  public static List<Integer> getCheckedOutStages(List ulIdStages) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".getCheckedOutStages");
    performanceTrace.enterScope();

    List<Integer> outStagesList = new ArrayList<Integer>();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      StringBuffer sql = new StringBuffer();

      sql.append("SELECT ID_WKLD_STAGE ");
      sql.append("FROM WORKLOAD ");
      sql.append("WHERE ");
      sql.append("CD_WKLD_STAGE_PERS_ROLE = 'PR' ");
      sql.append("AND CD_MOBILE_STATUS = 'OT' ");
      sql.append("AND (CD_WKLD_STAGE = 'INV' ");
      sql.append("OR CD_WKLD_STAGE = 'SVC') ");
      sql.append("AND ID_WKLD_STAGE IN ( ");
      sql.append(SqlHelper.toSetString(ulIdStages.size()));
      sql.append(" ) GROUP BY ID_WKLD_STAGE");

      String stringSql = sql.toString();

      connection = JdbcHelper.getConnection();
      preparedStatement = connection.prepareStatement(stringSql);
      int i = 0;

      for (Iterator iterator = ulIdStages.iterator(); iterator.hasNext();) {
        preparedStatement.setInt(i + 1, (Integer) iterator.next());
        i++;
      }

      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        outStagesList.add(resultSet.getInt(1));
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    performanceTrace.exitScope();
    return outStagesList;
  }

  /**
   * Method getCheckedOutPersonStatus<p/>Written by Patrick Coogan
   * <p/>
   * SIR 23726 - returns an a boolean value based on whether or not either of the two passed person ID's is tied to a
   * stage currently checked out to MPS
   *
   * @param firstPerson  Person ID
   * @param secondPerson Person ID
   * @return Boolean
   */
  public static boolean getCheckedOutPersonStatus(int firstPerson, int secondPerson) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".getCheckedOutPersonStatus");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean checkedOut = false;

    int stages = 0;

    try {
      connection = JdbcHelper.getConnection();

      String sql = GET_CHECKEDOUT_PERSON_STATUS_SQL;

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, firstPerson);
      preparedStatement.setInt(2, secondPerson);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        stages = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    if (stages > 0) {
      checkedOut = true;
    }

    performanceTrace.exitScope();
    return checkedOut;
  }

  /**
   * SIR 23966 The getAFCPendingStatus method has been added as a part of SIR 23966 (MPS Phase III Lockdown Changes) to
   * determine if any AFC stage approval event is currently in PROC status. This is necessary because of the possibility
   * of multiple stage approval submissions in AFC.
   *
   * @param ulIdCase
   * @return boolean
   */
  public static boolean getAFCPendingStatus(int ulIdCase) {
    PerformanceTrace performanceTrace = new PerformanceTrace(CaseUtility.TRACE_TAG, ".getAFCPendingStatus");
    performanceTrace.enterScope();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean pend = false;
    int events = 0;

    try {
      connection = JdbcHelper.getConnection();

      String sql = GET_AFC_PENDING_STATUS_SQL;

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, ulIdCase);

      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        events = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }

    if (events > 0) {
      pend = true;
    }
    performanceTrace.exitScope();
    return pend;
  }

  protected static void cleanup(Connection connection, Statement statement, ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing result set.", e);
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing statement.", e);
    }
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
    } catch (Exception e) {
      GLOBAL_EXCEPTION_LOGGER.log(GrndsLevel.ALERT, "Failure closing connection.", e);
    }
  }

  /** Inner class for holding the idEvent and the Event status */
  public static class Event implements Serializable {

    private int idEvent = 0;
    private int idStage = 0;
    private String cdEventStatus = null;
    private String cdTask = null;
    private String txtEventDesc = null;
    private java.util.Date dtLastUpdate = null;
    private java.util.Date dtEventOccurred = null;

    /** empty constructor for the event */
    public Event() {
    }

    /**
     * Constructor
     *
     * @noinspection OverridableMethodCallInConstructor
     */
    public Event(int idEvent, String cdEventStatus) {
      setIdEvent(idEvent);
      setCdEventStatus(cdEventStatus);
    }

    /** gets the id for the event */
    public int getIdEvent() {
      return this.idEvent;
    }
    
    /** gets the idStage for the event */
    public int getIdStage() {
      return this.idStage;
    }

    /** gets the id for the event as a string */
    public String getIdEventAsString() {
      if (this.idEvent != 0) {
        return Integer.toString(this.idEvent);
      }
      return null;
    }

    /** gets the event status */
    public String getCdEventStatus() {
      return this.cdEventStatus;
    }

    /** sets the id event */
    public void setIdEvent(int idEvent) {
      this.idEvent = idEvent;
    }
    
    /** sets the id event */
    public void setIdStage(int idStage) {
      this.idStage = idStage;
    }

    /** sets the event status */
    public void setCdEventStatus(String cdEventStatus) {
      this.cdEventStatus = cdEventStatus;
    }

    /** returns a string with the id and status */
    public String toString() {
      return "idEvent:" + idEvent + "\ncdEventStatus:" + cdEventStatus;
    }

    public String getCdTask() {
      return cdTask;
    }

    public void setCdTask(String cdTask) {
      this.cdTask = cdTask;
    }

    public java.util.Date getDtLastUpdate() {
      return dtLastUpdate;
    }

    public void setDtLastUpdate(java.util.Date dtLastUpdate) {
      this.dtLastUpdate = dtLastUpdate;
    }

    public java.util.Date getDtEventOccurred() {
      return dtEventOccurred;
    }

    public void setDtEventOccurred(java.util.Date dtEventOccurred) {
      this.dtEventOccurred = dtEventOccurred;
    }

    public String getTxtEventDesc() {
      return txtEventDesc;
    }

    public void setTxtEventDesc(String txtEventDesc) {
      this.txtEventDesc = txtEventDesc;
    }
  }

}
