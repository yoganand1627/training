package gov.georgia.dhr.dfcs.sacwis.web.core.errorlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Initializable;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Destroyable;

public class ErrorUriLookupInit implements Initializable, Destroyable {

  private static final String TRACE_TAG = "ErrorLinkInit";

  private static final String SELECT_SQL =
          "Select NBR_MESSAGE, TXT_STAGE_CD, TXT_PRGM_CD, ID_TAB, CD_TASK from ERROR_LIST";

  /**
   * Loops through result set from ERROR_LIST and populates the tripleToTabIdMap with a Triple containing the idMsg,
   * pgmCd and stageCd as a key, and the tabId as a value.  Also creates the tripleToTaskCdMap mapping the same Triples
   * to task Codes. The Task Code is needed for tabs that set the task code. SPB 2/11/03
   */
  public void initialize(ServletContext servletContext) throws LookupException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet results = null;
    GrndsTrace.enterScope(TRACE_TAG + ".initialize()");
    try {

      connection = JdbcHelper.getConnection();

      statement = connection.prepareStatement(SELECT_SQL);
      results = statement.executeQuery();

      while (results.next()) {
        int idTab = (results.getInt("ID_TAB"));
        String linkTaskCd = (results.getString("CD_TASK"));
        // System.out.println( "linkTaskCd in Init:" + linkTaskCd + "." );
        String stageCd = (results.getString("TXT_STAGE_CD"));
        String pgmCd = (results.getString("TXT_PRGM_CD"));
        if (pgmCd == null) {
          pgmCd = "0";
        }
        int idMsg = (results.getInt("NBR_MESSAGE"));
        // System.out.println("#### triple:" + idMsg + "." + pgmCd + "." + stageCd + ". idTab=" + idTab + "/" );

        ErrorUriLookup.TRIPLE_TO_TASK_CD_MAP.put(new ErrorListTriple(idMsg, pgmCd, stageCd), linkTaskCd);
        ErrorUriLookup.TRIPLE_TO_TAB_ID_MAP.put(new ErrorListTriple(idMsg, pgmCd, stageCd), idTab);
        // System.out.println("tripleToTabIdMap : ( " + idMsg + "/" + pgmCd + "/" + stageCd + " )" );
      }
      //noinspection AssignmentToStaticFieldFromInstanceMethod
      ErrorUriLookup.TRIPLE_TO_TASK_CD_MAP = Collections.unmodifiableMap(ErrorUriLookup.TRIPLE_TO_TASK_CD_MAP);
      //noinspection AssignmentToStaticFieldFromInstanceMethod
      ErrorUriLookup.TRIPLE_TO_TAB_ID_MAP = Collections.unmodifiableMap(ErrorUriLookup.TRIPLE_TO_TAB_ID_MAP);
    } catch (SQLException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure running SQL statement: " + se.getMessage());
      throw new LookupException("Failure running SQL statement in : " + TRACE_TAG, se, 1);
    } finally {
      try {
        if (results != null) {
          results.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure closing connection: " + e.getMessage());
      }
    }
    GrndsTrace.exitScope();
  }

  @SuppressWarnings({"AssignmentToStaticFieldFromInstanceMethod", "AssignmentToNull"})
  public void destroy(ServletContext config) throws BasePrsException {
    ErrorUriLookup.TRIPLE_TO_TAB_ID_MAP = null;
    ErrorUriLookup.TRIPLE_TO_TASK_CD_MAP = null;
  }
}