package gov.georgia.dhr.dfcs.sacwis.dao.document.cfp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;

/**
 * Handles getting data from cfp_status and stage table
 * <pre>
 * Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  11/26/03    dejuanr   SIR 19870 - Modifed call for queue list.  It needs
 *                        to make two sql calls now.  One for the count and
 *                        one for the info.
 * </pre>
 */
public class CfpDao extends BaseDao {
  public static final String TRACE_TAG = "CfpDao";
  public static final int MAX_COMPLETED_IN_QUEUEVIEWER = 100;

  //ORDERED hint relies on the smallest table being first in the list
  protected static final String CFP_STATUS_SELECT = "select /*+ ORDERED */ \n" +
                                                    "       cfp_status.ID_CFP_STATUS, \n" +
                                                    "       cfp_status.ID_CASE, \n" +
                                                    "       cfp_status.ID_STAGE, \n" +
                                                    "       cfp_status.ID_PERSON, \n" +
                                                    "       cfp_status.DT_SUBMIT_TIME, \n" +
                                                    "       cfp_status.DT_COMPLETION_TIME, \n" +
                                                    "       cfp_status.DT_LAST_UPDATE, \n" +
                                                    "       cfp_status.CD_STATUS, \n" +
                                                    "       cfp_status.TXT_PROGRESS, \n" +
                                                    "       cfp_status.TXT_PATH, \n" +
                                                    "       cfp_status.TXT_ERROR_DESCRIPTION, \n" +
                                                    "       employee.NM_EMPLOYEE_FIRST, \n" +
                                                    "       employee.NM_EMPLOYEE_MIDDLE, \n" +
                                                    "       employee.NM_EMPLOYEE_LAST, \n" +
                                                    "       caps_case.NM_CASE, \n" +
                                                    "       cfp_status.CD_STAGE \n" +
                                                    "from cfp_status, \n" +
                                                    "     employee, \n" +
                                                    "     caps_case \n" +
                                                    "where cfp_status.ID_PERSON = employee.ID_PERSON \n" +
                                                    "  and cfp_status.ID_CASE = caps_case.ID_CASE \n";

  public CfpDao(Connection connection) {
    super(connection);
  }

  /** Delete cfp_status for cfpId Errors if cfpId not in SUBMITTED state. */
  public void deleteCfpStatus(int cfpId, int userId) throws CannotDeleteCfpException, SQLException {
    Connection connection = super.getConnection();
    PreparedStatement statement = null;
    try {
      String sql = "delete from cfp_status \n" +
                   "where id_cfp_status = ? \n" +
                   "  and id_person = ? \n" +
                   "  and cd_status = '" + CfpStatusDB.SUBMITTED + "'\n";
      statement = connection.prepareStatement(sql);
      statement.setInt(1, cfpId);
      statement.setInt(2, userId);
      GrndsTrace.msg(TRACE_TAG, 7, ".deleteCfpStatus sql: \n" + sql + "\n" + "\t id_cfp_status: " + cfpId + "\n" +
                                   "\t id_person: " + userId);
      int rowCount = statement.executeUpdate();
      if (rowCount == 0) {
        throw new CannotDeleteCfpException();
      }
    } finally {
      cleanup(statement);
    }
  }

  /** Get CfpStatus for cfpId */
  public CfpStatusDB getCfpStatus(int cfpId) throws SQLException {
    String sql = CFP_STATUS_SELECT +
                 "  and cfp_status.ID_CFP_STATUS = ? \n";
    List list = getStatuses(sql, new int[] {cfpId});
    return (CfpStatusDB) list.get(0);
  }

  /**
   * Used to determine if user exceeds QUEUE_LIMIT Get vector of CfpStatusDB for userId in SUBMITTED or IN_PROGRESS
   * state
   */
  public List getQueuedCfpStatusForUser(int userId) throws SQLException {
    String sql = CFP_STATUS_SELECT +
                 "  and cfp_status.ID_PERSON = ? \n" +
                 "  and employee.ID_PERSON = ? \n" +
                 "  and cfp_status.CD_STATUS in ('" +
                 CfpStatusDB.SUBMITTED + "', '" +
                 CfpStatusDB.IN_PROGRESS + "')\n";
    return getStatuses(sql, new int[] {userId, userId});
  }

  /** Get vector of CfpStatusDB where SUBMITTED or IN_PROGRESS state */
  public List getQueuedCfpStatus() throws SQLException {
    String sql = CFP_STATUS_SELECT +
                 "  and cfp_status.CD_STATUS in ('" +
                 CfpStatusDB.SUBMITTED + "', '" +
                 CfpStatusDB.IN_PROGRESS + "')\n" +
                 "order by DT_SUBMIT_TIME desc";
    return getStatuses(sql, new int[0]);
  }

  /** Get vector of CfpStatusDB where in ERROR or COMPLETE state */
  public List getCompletedCfpStatus() throws SQLException {
    //!!! need pagination?
    String sql = "select * from (\n" +
                 CFP_STATUS_SELECT +
                 "  and cfp_status.CD_STATUS in ('" +
                 CfpStatusDB.COMPLETE + "', '" +
                 CfpStatusDB.ERROR + "')\n" +
                 "order by DT_SUBMIT_TIME desc\n" +
                 ") where rownum < " + MAX_COMPLETED_IN_QUEUEVIEWER + "\n";
    return getStatuses(sql, new int[0]);
  }

  /** Produces the "current page" of results of QueueStatus */
  public PaginationResultBean getQueueCfpStatus(int userId, DatabaseResultDetails details) throws SQLException {
    List<CfpStatusDB> arrayList = new ArrayList<CfpStatusDB>();
    PaginationResultBean paginationResultBean = new PaginationResultBean();
    paginationResultBean.setResults(arrayList);
    paginationResultBean.setResultDetails(details);

    Connection connection = super.getConnection();
    PreparedStatement statement1 = null;
    ResultSet resultSet1 = null;
    try {
      String sql = getQueueCfpStatusSql(true);
      GrndsTrace.msg(TRACE_TAG, 7, ".getQueueCfpStatus sql: \n" + sql + "\n" + "\t id_person: " + userId);
      statement1 = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      statement1.setInt(1, userId);
      statement1.setInt(2, userId);
      resultSet1 = statement1.executeQuery();

      //positions cursor of resultSet2; reads # of rows
      resultSet1.next();
      int numberOfResults = resultSet1.getInt(1);
      details.setNumberOfResults(numberOfResults);
    } finally {
      cleanup(resultSet1);
      cleanup(statement1);
    }
    PreparedStatement statement2 = null;
    ResultSet resultSet2 = null;
    try {
      String sql = getQueueCfpStatusSql(false);
      GrndsTrace.msg(TRACE_TAG, 7, ".getQueueCfpStatus sql: \n" + sql + "\n" +
                                   "\t id_person: " + userId);
      statement2 = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      statement2.setInt(1, userId);
      statement2.setInt(2, userId);
      resultSet2 = statement2.executeQuery();

      details.readUpToFirstResult(resultSet2);

      int lastResult = details.getLastResultRequested();

      while (resultSet2.next() && resultSet2.getRow() <= lastResult) {
        arrayList.add(readCfpStatus(resultSet2));
      }
    } finally {
      cleanup(resultSet2);
      cleanup(statement2);
    }
    return paginationResultBean;
  }

  /** Get vector of CfpStatusDB based on sql */
  protected List getStatuses(String sql, int[] bindVariables) throws SQLException {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      Connection connection = super.getConnection();
      statement = connection.prepareStatement(sql);
      for (int i = 0; i < bindVariables.length; i++) {
        statement.setInt(i + 1, bindVariables[i]);
      }
      resultSet = statement.executeQuery();
      List<CfpStatusDB> vector = new ArrayList<CfpStatusDB>();
      while (resultSet.next()) {
        vector.add(readCfpStatus(resultSet));
      }
      return vector;
    } finally {
      cleanup(resultSet);
      cleanup(statement);
    }
  }

  /** read one row from the resultSet to produce a CfpStatusDB */
  protected CfpStatusDB readCfpStatus(ResultSet resultSet) throws SQLException {
    CfpStatusDB cfpStatus = new CfpStatusDB();
    int i = 0;
    cfpStatus.setStatusId(resultSet.getInt(++i));
    cfpStatus.setCaseId(resultSet.getInt(++i));
    cfpStatus.setStageId(resultSet.getInt(++i));
    cfpStatus.setPersonId(resultSet.getInt(++i));
    cfpStatus.setSubmissionTimeDate(resultSet.getTimestamp(++i));
    cfpStatus.setCompletionTimeDate(resultSet.getTimestamp(++i));
    cfpStatus.setLastUpdatedDate(resultSet.getTimestamp(++i));
    cfpStatus.setStatus(resultSet.getString(++i));
    cfpStatus.setProgress(resultSet.getString(++i));
    cfpStatus.setPath(resultSet.getString(++i));
    cfpStatus.setErrorDescription(resultSet.getString(++i));
    String firstName = resultSet.getString(++i);
    String middleName = resultSet.getString(++i);
    String lastName = resultSet.getString(++i);
    cfpStatus.setStaffName(getFullName(firstName, middleName, lastName));
    cfpStatus.setCaseName(resultSet.getString(++i));
    String stageCode = resultSet.getString(++i);
    if (resultSet.wasNull()) {
      stageCode = "";
    }
    cfpStatus.setStageCode(stageCode);
    return cfpStatus;
  }

  /**
   * Create a row in cfp_status given data in cfpStatusDB Sets StatusId and SubmissionTimeDate on cfpStatusDB and
   * returns it
   */
  public CfpStatusDB createCfpStatus(CfpStatusDB cfpStatusDB) throws SQLException {
    PreparedStatement sequenceStmt = null;
    ResultSet sequenceResultSet = null;
    PreparedStatement queryStmt = null;
    ResultSet resultSet = null;
    try {
      String sql = "select seq_cfp_status.nextval, SysDate from dual";
      GrndsTrace.msg(TRACE_TAG, 7, "sql: " + sql);
      Connection connection = super.getConnection();
      sequenceStmt = connection.prepareStatement(sql);
      sequenceResultSet = sequenceStmt.executeQuery();
      sequenceResultSet.next();
      cfpStatusDB.setStatusId(sequenceResultSet.getInt(1));
      cfpStatusDB.setSubmissionTimeDate(sequenceResultSet.getTimestamp(2));
      sql = "insert into cfp_status (ID_CFP_STATUS, \n" +
            "                        ID_CASE, \n" +
            "                        ID_STAGE, \n" +
            "                        ID_PERSON, \n" +
            "                        DT_SUBMIT_TIME, \n" +
            "                        DT_COMPLETION_TIME, \n" +
            "                        DT_LAST_UPDATE, \n" +
            "                        CD_STATUS, \n" +
            "                        TXT_PROGRESS, \n" +
            "                        TXT_PATH, \n" +
            "                        TXT_ERROR_DESCRIPTION, \n" +
            "                        CD_STAGE) \n" +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";
      GrndsTrace.msg(TRACE_TAG, 7, "sql: " + sql);
      queryStmt = connection.prepareStatement(sql);
      int i = 0;
      queryStmt.setInt(++i, cfpStatusDB.getStatusId());
      queryStmt.setInt(++i, cfpStatusDB.getCaseId());
      queryStmt.setInt(++i, cfpStatusDB.getStageId());
      queryStmt.setInt(++i, cfpStatusDB.getPersonId());
      setTimestamp(++i, cfpStatusDB.getSubmissionTimeDate(), queryStmt);
      setTimestamp(++i, cfpStatusDB.getCompletionTimeDate(), queryStmt);
      setTimestamp(++i, cfpStatusDB.getLastUpdatedDate(), queryStmt);
      setString(++i, cfpStatusDB.getStatus(), queryStmt);
      setString(++i, cfpStatusDB.getProgress(), queryStmt);
      setString(++i, cfpStatusDB.getPath(), queryStmt);
      setString(++i, cfpStatusDB.getErrorDescription(), queryStmt);
      setString(++i, cfpStatusDB.getStageCode(), queryStmt);
      queryStmt.execute();
      return cfpStatusDB;
    } finally {
      cleanup(sequenceResultSet);
      cleanup(sequenceStmt);
      cleanup(resultSet);
      cleanup(queryStmt);
    }
  }

  /** Update the cfp_status.txt_progress field for this cfpId */
  public void updateProgress(int cfpId, String progress) throws SQLException {
    Connection connection = super.getConnection();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "update cfp_status \n" +
                   "set TXT_PROGRESS = ? \n" +
                   "where ID_CFP_STATUS = ? \n";
      GrndsTrace.msg(TRACE_TAG, 7, "sql: " + sql);
      preparedStatement = connection.prepareStatement(sql);
      int i = 0;
      setString(++i, progress, preparedStatement);
      preparedStatement.setInt(++i, cfpId);
      preparedStatement.execute();
    } finally {
      cleanup(preparedStatement);
    }
  }

  /** Sets cfp_status row to ERROR state. */
  public void setError(int cfpId, String errorMessage) throws SQLException {
    Connection connection = super.getConnection();
    PreparedStatement preparedStatement = null;
    try {
      String sql = "update cfp_status \n" +
                   "set TXT_ERROR_DESCRIPTION = ?, \n" +
                   "    CD_STATUS = '" + CfpStatusDB.ERROR + "', \n" +
                   "    DT_COMPLETION_TIME = SysDate \n" +
                   "where ID_CFP_STATUS = ? \n";
      GrndsTrace.msg(TRACE_TAG, 7, "sql: " + sql);
      preparedStatement = connection.prepareStatement(sql);
      int i = 0;
      setString(++i, errorMessage, preparedStatement);
      preparedStatement.setInt(++i, cfpId);
      preparedStatement.execute();
    } finally {
      cleanup(preparedStatement);
    }
  }

  /** Get StageDB for caseId and stageId */
  public StageDB getStageDB(int caseId, int stageId) throws SQLException {
    Connection connection = super.getConnection();
    PreparedStatement statement1 = null;
    ResultSet resultSet1 = null;
    if (stageId != 0) {
      try {
        String stageSelectSql = "select \n" +
                                "       caps_case.nm_case, \n" +
                                "       caps_case.id_case, \n" +
                                "       stage.cd_stage_program, \n" +
                                "       stage.cd_stage, \n" +
                                "       stage.cd_stage_type, \n" +
                                "       stage.nm_stage \n" +
                                "from stage, caps_case \n" +
                                "where stage.id_stage = ?\n" +
                                "  and stage.id_case = caps_case.id_case \n";
        GrndsTrace.msg(TRACE_TAG, 7, "getStageDB:\n" + stageSelectSql);
        statement1 = connection.prepareStatement(stageSelectSql);
        statement1.setInt(1, stageId);
        resultSet1 = statement1.executeQuery();
        if (resultSet1.next()) {
          StageDB stageDB = new StageDB();
          int i = 0;
          stageDB.setCaseName(resultSet1.getString(++i));
          stageDB.setCaseId(resultSet1.getInt(++i));
          stageDB.setProgramName(resultSet1.getString(++i));
          stageDB.setStageCode(resultSet1.getString(++i));
          stageDB.setStageType(resultSet1.getString(++i));
          stageDB.setStageName(resultSet1.getString(++i));
          stageDB.setStageId(stageId);
          return stageDB;
        }
      } finally {
        cleanup(resultSet1);
        cleanup(statement1);
      }
      GrndsTrace.msg(TRACE_TAG, 7, "unidentified stageId: " + stageId);

      PreparedStatement statement2 = null;
      ResultSet resultSet2 = null;
      //if stage not found, likely it didn't have a caseId
      try {
        String stageSelectSql = "select \n" +
                                "       stage.cd_stage_program, \n" +
                                "       stage.cd_stage, \n" +
                                "       stage.cd_stage_type, \n" +
                                "       stage.nm_stage \n" +
                                "from stage \n" +
                                "where stage.id_stage = ?\n";

        GrndsTrace.msg(TRACE_TAG, 7, "getStageDB:\n" + stageSelectSql);
        statement2 = connection.prepareStatement(stageSelectSql);
        statement2.setInt(1, stageId);
        resultSet2 = statement2.executeQuery();
        if (resultSet2.next()) {
          StageDB stageDB = new StageDB();
          int i = 0;
          stageDB.setCaseId(caseId);
          stageDB.setProgramName(resultSet2.getString(++i));
          stageDB.setStageCode(resultSet2.getString(++i));
          stageDB.setStageType(resultSet2.getString(++i));
          stageDB.setStageName(resultSet2.getString(++i));
          stageDB.setStageId(stageId);
          return stageDB;
        }
      } finally {
        cleanup(resultSet2);
        cleanup(statement2);
      }
      GrndsTrace.msg(TRACE_TAG, 7, "unidentified stageId: " + stageId);
    }

    PreparedStatement statement3 = null;
    ResultSet resultSet3 = null;
    try {
      String caseSelectSql = "select cd_case_program, \n" +
                             "       nm_case \n" +
                             "from caps_case \n" +
                             "where id_case = ?\n";

      GrndsTrace.msg(TRACE_TAG, 7, "getStageDB:\n" + caseSelectSql);
      statement3 = connection.prepareStatement(caseSelectSql);
      statement3.setInt(1, caseId);
      resultSet3 = statement3.executeQuery();
      if (resultSet3.next() == false) {
        throw new IllegalStateException
                ("could not find program, case for caseId: " + caseId);
      }
      StageDB stageDB = new StageDB();
      int i = 0;
      stageDB.setProgramName(resultSet3.getString(++i));
      stageDB.setCaseName(resultSet3.getString(++i));
      //relied upon by other code to be null and not ""
      stageDB.setStageCode(null);
      stageDB.setStageType(null);
      stageDB.setStageName(null);
      stageDB.setStageId(0);
      stageDB.setCaseId(caseId);
      return stageDB;
    } finally {
      cleanup(resultSet3);
      cleanup(statement3);
    }
  }

  /** Concat last, first, middle names */
  protected static String getFullName(String firstName, String middleName, String lastName) {
    String fullName = "";
    if (lastName != null) {
      fullName = lastName + ", ";
    }
    if (firstName != null) {
      fullName += firstName + " ";
    }
    if (middleName != null) {
      fullName += middleName;
    }
    return fullName;
  }

  protected static String getQueueCfpStatusSql(boolean count) {
    //07/02/2003, Matthew McClain
    //While this query is long and looks nasty,
    //it's actually more efficient than the shorter
    //query which has ((cfp_status.CD_STATUS in ('0', '1')) OR
    //                 ((cfp_status.CD_STATUS in ('3', '2')) AND
    //                  (cfp_status.ID_PERSON = &1)))
    //That query confuses Oracle, and it does a full table scan.
    //The query below correctly uses indexes.
    String sql = "";
    if (count) {
      sql += "select count(1) from (\n";
    } else {
      sql += "select * from (\n";
    }
    sql += CFP_STATUS_SELECT +
           "  and cfp_status.CD_STATUS in ('" + CfpStatusDB.SUBMITTED + "', \n" +
           "                               '" + CfpStatusDB.IN_PROGRESS + "')\n" +
           "UNION\n" +
           CFP_STATUS_SELECT +
           "  and cfp_status.CD_STATUS in ('" + CfpStatusDB.COMPLETE + "', \n" +
           "                               '" + CfpStatusDB.ERROR + "')\n" +
           "  and cfp_status.ID_PERSON = ?\n" +
           "  and employee.ID_PERSON = ?\n" +
           ")\n" +
           "order by DT_SUBMIT_TIME desc, \n" +
           "         CD_STATUS asc \n";
    return sql;
  }
}
