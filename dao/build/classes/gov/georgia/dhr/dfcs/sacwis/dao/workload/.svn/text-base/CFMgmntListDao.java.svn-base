package gov.georgia.dhr.dfcs.sacwis.dao.workload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseDao;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;

public class CFMgmntListDao extends BaseDao {

  protected static final String ID_CASE_FILE_CASE_COLUMN = "ID_CASE_FILE_CASE";
  protected static final String TXT_CASE_FILE_LOCATE_INFO_COLUMN = "TXT_CASE_FILE_LOCATE_INFO";

  public static final String TRACE_TAG = "CFMgmntListDao";
  protected static final String TRUE = "Y";

  /**
   * Public constructor.
   *
   * @param connection Connection that the BaseDao will use.
   */
  public CFMgmntListDao(Connection connection) {
    super(connection);
  }

  /**
   * @param searchBean CFMgmntValueBean object input.
   * @return
   * @throws SQLException
   * @throws DaoException
   */
  public CFMgmntValueBean getCFMgmntList(CFMgmntValueBean searchBean) throws SQLException, DaoException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "getCFMgmntList");
    performanceTrace.enterScope();
    Integer id = 0;
    if (searchBean.getCaseId() != 0) {
      id = (searchBean.getCaseId());
    }
    CFMgmntValueBean returnBean = null;
    Connection connection = super.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      // Create the SQL statement
      List<CFMgmntValueBean> vector = new ArrayList<CFMgmntValueBean>();
      boolean bMoreRecord = true;
      List<Integer> caseIds = new ArrayList<Integer>();
      caseIds.add(id);

      while (bMoreRecord && (caseIds.size() > 0)) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT ID_CASE_FILE_CASE, TXT_CASE_FILE_LOCATE_INFO ");
        sql.append(" FROM CASE_FILE_MANAGEMENT ");
        sql.append(" WHERE CASE_FILE_MANAGEMENT.ID_CASE_FILE_CASE IN ");
        sql.append(" (SELECT C.ID_CASE_MERGE_FROM ");
        sql.append(" FROM CASE_MERGE C ");
        sql.append(" WHERE C.ID_CASE_MERGE_TO IN (");
        int k = 0;
        int paramNumber = 0;
        if (caseIds.get(k) != null) {
          for (k = 0; k < caseIds.size(); k++) {
            sql.append(" ? ");
            if ((k + 1) != caseIds.size()) {
              sql.append(", ");
            }
          }
          sql.append(" ) ");
          sql.append(" GROUP BY C.ID_CASE_MERGE_FROM ) ");
        }
        preparedStatement = connection.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
        GrndsTrace.msg(TRACE_TAG, 7, "id_case: " + caseIds.toString() + "\n" + "The CFMgmntList DAO SQL is: \n" + sql);
        for (k = 0; k < caseIds.size(); k++) {
          paramNumber++;
          preparedStatement.setInt(paramNumber, Integer.parseInt(caseIds.get(k).toString()));
        }

        performanceTrace.getElapsedTime();
        // Execute the query
        resultSet = preparedStatement.executeQuery();
        performanceTrace.getElapsedTime(" Time for SQL execution.");
        // Get the number of results returned
        resultSet.last();

        int numberOfResults = resultSet.getRow();
        caseIds.clear();
        if (numberOfResults > 0) {
          resultSet.first();
          returnBean = new CFMgmntValueBean(resultSet);
          resultSet.beforeFirst();
          while (resultSet.next()) {
            returnBean = new CFMgmntValueBean(resultSet);
            if (returnBean.getLocatingInformation() != null) {
              vector.add(returnBean);
            }
            caseIds.add(returnBean.getCaseId());
          }
          returnBean.setLocatingInfo(vector);
        } else {
          bMoreRecord = false;
        }
      }
      removeDuplicateRecord(vector);
      return returnBean;
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "in CFMgmntListDao SQLException message is: " + e.getMessage());
      GrndsTrace.msg(TRACE_TAG, 7, "in CFMgmntListDaoSQLException ErrorCode is: " + e.getErrorCode());
      throw e;
    } finally {
      cleanup(resultSet);
      cleanup(preparedStatement);
      performanceTrace.getTotalTime();
      performanceTrace.exitScope();
    }
  }

  /**
   * This routine gets rid of location informations that are the same
   *
   * @param cfMgmtValueBeanList object input.
   */
  private void removeDuplicateRecord(List cfMgmtValueBeanList) {
    int iArraySize = cfMgmtValueBeanList.size();
    for (int i = 0; i < iArraySize; i++) {
      CFMgmntValueBean returnBean1 = (CFMgmntValueBean) cfMgmtValueBeanList.get(i);
      for (int j = i + 1; j < iArraySize; j++) {
        CFMgmntValueBean returnBean2 = (CFMgmntValueBean) cfMgmtValueBeanList.get(j);
        if (returnBean1.getCaseId() == returnBean2.getCaseId() ||
            returnBean1.getLocatingInformation().compareToIgnoreCase(returnBean2.getLocatingInformation()) == 0) {
          cfMgmtValueBeanList.remove(j);
          iArraySize = cfMgmtValueBeanList.size();
          break;
        }
      }
    }
  }
}
