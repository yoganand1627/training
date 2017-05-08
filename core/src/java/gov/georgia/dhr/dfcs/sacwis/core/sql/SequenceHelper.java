package gov.georgia.dhr.dfcs.sacwis.core.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

/**
 * General: ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE SequenceHelper.java--Mobile FOR NECESSARY
 * MOBILE CHANGES
 * <pre>
 * Change History:
 *  Date      User      Description
 * --------  --------  ----------------------------------------------------
 * 06/28/05  dejuanr   Initial revision.
 * 06/28/05  robertsw  Now takes connection as param.
 * 08/30/05  anandv    Added MOBILE-IMPACT comments in the General section.
 * 09/09/05  werlem    SIR 23791 Adding exception with message to display
 *                     consitent error handling.
 * </pre>
 */
public class SequenceHelper {

  private static final String TRACE_TAG = "SequenceHelper";

  public static int getSequence(String table, Connection connection) {
    PerformanceTrace performanceTrace = new PerformanceTrace(SequenceHelper.TRACE_TAG, ".getApproversStatus");
    performanceTrace.enterScope();
    int sequence = 0;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      preparedStatement = connection.prepareStatement("SELECT SEQ_" + table + ".NEXTVAL FROM DUAL");
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        sequence = resultSet.getInt(1);
      } else {
        throw new SequenceException(table);
      }
    }
    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    finally {
      cleanup(preparedStatement, resultSet);
    }
    return sequence;
  }

  protected static void cleanup(Statement statement, ResultSet resultSet) {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
    }
    catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception closing statement or connection: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
  }
}
