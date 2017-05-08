package gov.georgia.dhr.dfcs.sacwis.web.metaphor;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.Event;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.ShowTab;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.facility.log.GrndsTrace;

/**
 * @author Herve Jean-Baptiste  June 03, 2011
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------           
 *   01/26/2012   hjbaptiste               STGAP00017829: MR-097 Displaying the tab if unsubstantiated maltreatment
 *                                         in care exists
 * </pre>
 * 
 */

public class SpclInvShowTab implements ShowTab {

  private static final GrndsLogger GLOBAL_EXCEPTION_LOGGER =
    GrndsLogger.getLogger(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                       "exception.globalLogger"));
  private static final String TRACE_TAG = "SpclInvShowTab";
  public static final String SPECIAL_INVESTIGATION_TASK = "2270";
  public static final String CPS_INV_CONCL_TASK_CODE = "2330";
  
  public boolean showTab(String tabId, HttpServletRequest request) throws RuntimeWrappedException {
    
    boolean showMe = false;
    int idStage = GlobalData.getUlIdStage(request);
    int idCase = GlobalData.getUlIdCase(request);
    // Make sure that this stage is the Investigation stage
    if (CodesTables.CSTAGES_INV.equals(GlobalData.getSzCdStage(request))){
      // Get the Special Investigation event. If it exists, then always show the tab
      int idEvent = CaseUtility.getEvent(idStage, SPECIAL_INVESTIGATION_TASK).getIdEvent();
      if (idEvent > 0){
        showMe = true;
      } 
      // If the Special Investigation event doesn't exist, only show the tab if the CPS Investigation Conclusion page, 
      // within the current stage, has both:  been approved (in APRV status) and has a response of "Yes" to either 
      // the "Is this Maltreatment in Care?" or "Is this a Policy Violation?" question or it is an unsubstantiated MIC.
      else {
        Event cpsInvConclEvent = CaseUtility.getEvent(idStage, CPS_INV_CONCL_TASK_CODE);
        if (CodesTables.CEVTSTAT_APRV.equals(cpsInvConclEvent.getCdEventStatus())) {
          // Analyze the record associated with the stage's conclusion event and determine whether
          // to show the tab
          showMe = displayTab(cpsInvConclEvent.getIdEvent());
        }
      }
    }
    return showMe;
  }
  
  /**
   * This method Determines if the Special Investigation Tab should show. It retrieves the
   * CPS Investigation Conclusion and checks to see if the response of "Yes" is answered 
   * to either the "Is this Maltreatment in Care?" or "Is this a Policy Violation?" questions
   * on the page. It uses a jdbc connection to get the record associated with the current 
   * stage's conclusion event. It finally closes all sql objects.
   * 
   * @param idEvent
   * @return
   */
  public static boolean displayTab(int idEvent) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayTab");
    performanceTrace.enterScope();
    boolean displayTab = false;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      connection = JdbcHelper.getConnection();

      String sql = "SELECT * " +
                   "FROM CPS_INVST_DETAIL i " +
                   "WHERE i.ID_EVENT = ? ";

      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idEvent);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        String indInvMaltreatInCare = resultSet.getString("IND_INV_MALTREAT_IN_CARE");
        String indPolicyViolation = resultSet.getString("IND_POLICY_VIOLATION");
        String indUnsubMIC = resultSet.getString("IND_UNSUB_MIC");
        // If either is set to 'Yes', show the tab
        if (ArchitectureConstants.Y.equals(indInvMaltreatInCare) || 
                        ArchitectureConstants.Y.equals(indPolicyViolation)|| 
                        ArchitectureConstants.Y.equals(indUnsubMIC)) {
          displayTab = true;
        }
      }
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection running sql: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection, preparedStatement, resultSet);
    }
    performanceTrace.exitScope();
    return displayTab;
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
}
