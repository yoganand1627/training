package gov.georgia.dhr.dfcs.sacwis.dao.investigation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

/**
 * This is the Data Access Object class used to manage Investigation Conclusion data.
 *
 * @author Jason Rios, December 2, 2002
 *         <p/>
 *         Change History: Date      User         Description --------  ----------- ----------------------------------------------
 *         12/01/03  dejuanr      SIR 19870 - Modifed results set to be type forward.
 */
public class InvCnclsnDAO extends BaseDao {
  // Database column names
  public static final String CASE_ID_COLUMN = "ID_CASE";
  public static final String STAGE_ID_COLUMN = "ID_EVENT_STAGE";
  public static final String EVENT_ID_COLUMN = "ID_EVENT";
  public static final String EVENT_PERSON_ID_COLUMN = "ID_EVENT_PERSON";
  public static final String EVENT_DATE_LAST_UPDATE_COLUMN = "DT_LAST_UPDATE";
  public static final String EVENT_STATUS_COLUMN = "CD_EVENT_STATUS";
  public static final String EVENT_TYPE_COLUMN = "CD_EVENT_TYPE";
  public static final String EVENT_TASK_CODE_COLUMN = "CD_TASK";
  public static final String EVENT_DESCRIPTION_COLUMN = "TXT_EVENT_DESCR";
  public static final String DATE_EVENT_OCCURRED_COLUMN = "DT_EVENT_OCCURRED";
  public static final String INVESTIGATION_CONCLUSION_EVENT_TYPE = "CCL";
  private static final String TRACE_TAG = "InvCnclsnDAO";

  /**
   * Public constructor.
   *
   * @param connection Connection that the BaseDao will use.
   */
  public InvCnclsnDAO(Connection connection) {
    super(connection);
  }

  /**
   * Query the status of the Investigation Conclusion event
   *
   * @param searchBean
   */
  public InvCnclsnEventValueBean queryInvestigationConclusionEvent(InvCnclsnEventValueBean searchBean) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "queryInvestigationConclusionEventStatus");
    performanceTrace.enterScope();

    PreparedStatement preparedStatement = null;
    List<Object> bindVariablesVector = new ArrayList<Object>();
    try {
      StringBuffer sql = new StringBuffer();
      sql.append("SELECT ");
      sql.append(
              "ID_EVENT, DT_LAST_UPDATE, ID_EVENT_STAGE, CD_EVENT_TYPE, ID_CASE, ID_EVENT_PERSON, CD_TASK, TXT_EVENT_DESCR, DT_EVENT_OCCURRED, CD_EVENT_STATUS ");
      sql.append("FROM ");
      sql.append("EVENT ");
      sql.append("WHERE ");
      sql.append("CD_EVENT_TYPE = '" + INVESTIGATION_CONCLUSION_EVENT_TYPE + "' ");
      sql.append("AND ID_CASE = ? ");
      bindVariablesVector.add(new Integer(searchBean.getCaseId()));
      sql.append("AND ID_EVENT_STAGE = ? ");
      bindVariablesVector.add(new Integer(searchBean.getStageId()));
      // Write the SQL string to the trace log
      GrndsTrace.msg(TRACE_TAG, 7, "The Inv Cnclsn DAO queryInvestigationConclusionEvent SQL is " + sql);

      Connection connection = super.getConnection();
      preparedStatement = connection.prepareStatement(sql.toString(),
                                                      ResultSet.TYPE_FORWARD_ONLY,
                                                      ResultSet.CONCUR_READ_ONLY);

      preparedStatement = addBindVariablesToStatement(preparedStatement, bindVariablesVector);
      performanceTrace.getElapsedTime();

      ResultSet resultSet = preparedStatement.executeQuery();
      performanceTrace.getElapsedTime(" Time for SQL execution.");

      /*resultSet.next();

      // Create an Investigation Conclusion Event bean from the row returned.
      return new InvCnclsnEventValueBean(resultSet);*/
      
      // van - 
      if (resultSet.next()) {
        return new InvCnclsnEventValueBean(resultSet);
      }
      else {
        return new InvCnclsnEventValueBean();
      }
      // end van - 
    }
    catch (Exception e) {
      throw new RuntimeWrappedException(e);
    }
    finally {
      cleanup(preparedStatement);
      performanceTrace.exitScope();
    }
  }
}
