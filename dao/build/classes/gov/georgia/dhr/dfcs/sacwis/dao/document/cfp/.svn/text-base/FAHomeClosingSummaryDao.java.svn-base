package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;

public class FAHomeClosingSummaryDao extends BaseDao {
  public static final String TRACE_TAG = "FAHomeClosingSummaryDao";

  public FAHomeClosingSummaryDao(Connection connection) {
    super(connection);
  }

  /** Returns vector of event Ids which are F/A Home Closing Summary events associated with this caseId */
  public List<String> getFAHomeClosingSummaryEventIds(int caseId) throws SQLException {
    List<String> vector = new ArrayList<String>();
    String query = "select id_event \n" +
                   "from event \n" +
                   "where cd_event_type = 'CON' \n" +
                   "  and txt_event_descr = 'F/A Home Closing Summary' \n" +
                   "  and id_case = ? \n";
    GrndsTrace.msg(TRACE_TAG, 7, "query: " + query + "\n" + "caseId: " + caseId);
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      Connection connection = super.getConnection();
      statement = connection.prepareStatement(query);
      statement.setInt(1, caseId);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        vector.add(resultSet.getString(1));
      }
      return vector;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }
}
