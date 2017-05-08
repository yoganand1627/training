package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.grnds.facility.log.GrndsTrace;

public class AbuseNeglectReportDao extends BaseDao {
  public static final String TRACE_TAG = "AbuseNeglectReportDao";

  public AbuseNeglectReportDao(Connection connection) {
    super(connection);
  }

  /** Returns whether a review of a contact has occurred */
  public boolean hasReviewContact(int caseId) throws SQLException {
    String query = "select min(dt_contact_occurred) \n" +
                   "from contact \n" +
                   "where cd_contact_type = 'EREV' \n" +
                   "and id_case = ? \n";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      Connection connection = super.getConnection();
      statement = connection.prepareStatement(query);
      statement.setInt(1, caseId);
      GrndsTrace.msg(TRACE_TAG, 7, ".hasReviewContact sql: \n" + query + "\n" + "\t caseId: " + caseId + "\n");
      resultSet = statement.executeQuery();
      resultSet.next();
      // ResultSet#getObject() can safely be used here because the returned data type doesn't matter.
      resultSet.getObject(1);
      if (resultSet.wasNull() == false) {
        return true;
      }
      return false;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }
}


