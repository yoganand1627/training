package gov.georgia.dhr.dfcs.sacwis.service.admin;

import java.sql.Connection;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntListDao;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntValueBean;

/** Used to handle CFMgmnt */
public class CFMgmntListBean extends BaseServiceEjb {

  public static final String TRACE_TAG = "CFMgmntListBean";

  /** Retrieve the Locating Information */
  public CFMgmntValueBean getCFMgmntInfo(CFMgmntValueBean searchBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".getCFMgmntList function");
    Connection connection = null;
    CFMgmntValueBean returnBean = null;
    try {
      connection = JdbcHelper.getConnection();
      if (connection == null) {
        GrndsTrace.msg(TRACE_TAG, 7, "Connection is null");
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Connection is NOT null");
      }
      CFMgmntListDao cfMgmntListDao = new CFMgmntListDao(connection);
      returnBean = cfMgmntListDao.getCFMgmntList(searchBean);
      return returnBean;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      if (connection == null) {
        GrndsTrace.msg(TRACE_TAG, 7, "Connection is null");
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Connection is NOT null" + connection.toString());
      }
      throw new RuntimeException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
}
