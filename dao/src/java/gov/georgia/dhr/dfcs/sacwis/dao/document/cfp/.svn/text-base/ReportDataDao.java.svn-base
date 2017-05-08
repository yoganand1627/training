package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;

/** Interfaces with report_parameter, reports, report_list tables */
public class ReportDataDao extends BaseDao {

  public static final String TRACE_TAG = "ReportDataDao";

  public ReportDataDao(Connection connection) {
    super(connection);
  }

  /** Get all parameterNames for a given report */
  public String[] getParameterNames(String sqrName, String sqrVersion) throws SQLException {
    String sql = "select nm_rpt_parm_name \n" +
                 "from report_parameter \n" +
                 "where nm_rpt_sqr_name = ? \n" +
                 "  and nm_rpt_sqr_ver = ? \n" +
                 "order by nbr_rpt_parm_seq \n";
    Connection connection = super.getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.prepareStatement(sql);
      statement.setString(1, sqrName);
      statement.setString(2, sqrVersion);
      GrndsTrace.msg(TRACE_TAG, 7, "\tquery1Column: \n" + sql + "\n" +
                                   "\tsqrName: " + sqrName + "\n" +
                                   "\tsqrVersion: " + sqrVersion + "\n");
      resultSet = statement.executeQuery();
      List<String> list = new ArrayList<String>();
      while (resultSet.next()) {
        list.add(resultSet.getString(1));
      }
      String[] array = new String[list.size()];
      array = list.toArray(array);
      return array;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }

  /** Get all reportIds for userId with these cfpStamps */
  public Map<String, String> getReportIds(int userId, String[] cfpStamps) throws SQLException {
    String set = set(cfpStamps);
    if (set == null) {
      return new HashMap<String, String>();
    }
    String sql = "select id_rpt_list, \n" +
                 "       nbr_rpt_lst_cfp_stamp \n" +
                 "from report_list \n" +
                 "where id_person = '" + userId + "' \n" +
                 "  and nbr_rpt_lst_cfp_stamp in (" + set + ") \n" +
                 "order by nbr_rpt_lst_cfp_stamp  \n";
    GrndsTrace.msg(TRACE_TAG, 7, "ReportDataDao.getReportIds, sql: \n" + sql);
    Map<String, String> hashtable = new HashMap<String, String>();
    Connection connection = super.getConnection();
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        int i = 0;
        String reportId = resultSet.getString(++i);
        String cfpStamp = resultSet.getString(++i);
        hashtable.put(cfpStamp, reportId);
      }
      if (hashtable.size() != cfpStamps.length) {
        throw new IllegalStateException("don't have as many reports in the database as expected: " +
                                        hashtable.size() + " != " + cfpStamps.length);
      }
      return hashtable;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }

  /** Turn String[] array into a comma-separated list */
  protected static String set(String[] array) {
    if (array.length == 0) {
      return null;
    }
    String set = array[0];
    for (int i = 1; i < array.length; i++) {
      set += ", " + array[i];
    }
    return set;
  }
}
