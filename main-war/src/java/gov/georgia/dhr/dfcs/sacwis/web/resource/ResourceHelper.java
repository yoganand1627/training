package gov.georgia.dhr.dfcs.sacwis.web.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;

/**
 * A utility class for Resource Search
 *
 * @author Tony Piazza
 */
public class ResourceHelper {
  private static final String TRACE_TAG = "ResourceHelper";

  private static final String AFC_WORKLOAD_SQL = "SELECT COUNT(*) FROM WORKLOAD WHERE CD_WKLD_STAGE_PROGRAM = 'AFC'";
  private static final String APS_WORKLOAD_SQL = "SELECT COUNT(*) FROM WORKLOAD WHERE CD_WKLD_STAGE_PROGRAM = 'APS'";

  private ResourceHelper() {
    // prevents instantiation
  }

  /**
   * Determines whether or not the employee has AFC cases on their workload.
   *
   * @return true if user has AFC cases, false otherwise
   */
  public static boolean userHasAfcWorkloadCases() {
    GrndsTrace.enterScope(TRACE_TAG + ".initialize");
    boolean result = false;
    Connection con = JdbcHelper.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = con.prepareStatement(AFC_WORKLOAD_SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery();

      if (rs.next()) {
        result = (rs.getInt(1) > 0);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 5, e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (Exception e) {
      }
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (Exception e) {
      }
      try {
        if (con != null && !con.isClosed()) {
          con.close();
        }
      } catch (Exception e) {
      }
    }
    GrndsTrace.exitScope();
    return result;
  }

  /**
   * Determines whether or not the employee has APS cases on their workload.
   *
   * @return true if user has APS cases, false otherwise
   */
  public static boolean userHasApsWorkloadCases() {
    GrndsTrace.enterScope(TRACE_TAG + ".initialize");

    boolean result = false;
    Connection con = JdbcHelper.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = con.prepareStatement(APS_WORKLOAD_SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery();

      if (rs.next()) {
        result = (rs.getInt(1) > 0);
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 5, e.getMessage());
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (Exception e) {
      }
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (Exception e) {
      }
      try {
        if (con != null && !con.isClosed()) {
          con.close();
        }
      } catch (Exception e) {
      }
    }

    GrndsTrace.exitScope();

    return result;
  }
}
