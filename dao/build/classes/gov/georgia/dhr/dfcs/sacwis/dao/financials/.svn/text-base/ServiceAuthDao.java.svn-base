package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.sql.SqlHelper;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

/**
 * This Data Access Object class manages requests of Service Authorization data.
 *
 * @author Wes Thompson, create date:  08/11/2005
 */
public class ServiceAuthDao extends BaseDao {

  private static final String TRACE_TAG = "ServiceAuthDao";

  // Placement
  public static String LIVING_ARRANGEMENT_COLUMN = "CD_PLCMT_LIV_ARR";

  // Legal Status
  public static String STATUS_CODE_COLUMN = "CD_LEGAL_STAT_STATUS";

  /**
   * Public constructor.
   *
   * @param connection Connection that the BaseDao will use.
   */
  public ServiceAuthDao(Connection connection) {
    super(connection);
  }

  @SuppressWarnings({"deprecation"})
  public Map<String, Object> queryLegalStatusForChild(int personId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryLegalStatusForChild");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Map<String, Object> legalStatusRow = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      bindVariablesVector.add(personId);
      preparedStatement = super.getConnection().prepareStatement("select * \n" +
                                                                 "from legal_status \n" +
                                                                 "where id_person = ? \n" +
                                                                 "order by dt_legal_stat_status_dt desc \n");
      // Add bind variables (only applicable for prepared statements)
      addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      performanceTrace.getElapsedTime();
      // This will get all rows.  Only need it to get 1.
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      List<Map<String, Object>> list = SqlHelper.createListFromQuery(preparedStatement);
      if (list.size() == 0) {
        return new HashMap<String, Object>();
      }
      legalStatusRow = list.get(0);
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return legalStatusRow;
  }

  /**
   * Queries the child's Placement with the greatest start date ( for the person and resource combination ).
   *
   * @param personId The person id of the child whose Placement will be retrieved.
   * @return String The row of placement data with the greatest start date, if exists.
   */
  @SuppressWarnings({"deprecation"})
  public Map<String, Object> queryPlacementWithGreatestStartDate(int personId) throws SQLException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryPlacementWithGreatestStartDate");
    performanceTrace.enterScope();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Map<String, Object> placementRow = null;
    try {
      List<Object> bindVariablesVector = new ArrayList<Object>();
      bindVariablesVector.add(personId);
      preparedStatement = super.getConnection().prepareStatement("SELECT * \n" +
                                                                 "FROM PLACEMENT \n" +
                                                                 "WHERE ID_PLCMT_CHILD = ? \n " +
                                                                 "AND TRUNC( DT_PLCMT_END ) = '12/31/4712' \n " +
                                                                 "AND CD_PLCMT_ACT_PLANNED = 'A' \n " +
                                                                 "ORDER BY DT_PLCMT_START DESC, ID_PLCMT_EVENT DESC");
      // Add bind variables (only applicable for prepared statements)
      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      performanceTrace.getElapsedTime();
      // This gets all rows when I only need it to get 1
      resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");
      List<Map<String, Object>> list = SqlHelper.createListFromQuery(preparedStatement);
      if (list.size() == 0) {
        return new HashMap<String, Object>();
      }
      placementRow = list.get(0);
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
    return placementRow;
  }
}
