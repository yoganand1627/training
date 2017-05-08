package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB;
import gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDao;

/** @todo add parameters, etc. to javadocs */

/**
 * Phone EJB.
 *
 * @author Matthew McClain, March 1, 2003
 */
public class PhoneBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "PhoneBean";

  /** Delegates to PhoneDao.getActivePhonesForStage to retrieve all active phones for the stage. */
  public List<PhoneDB> getActivePhonesForStage(int stageId, String stageCode) {
    GrndsTrace.enterScope(TRACE_TAG + ".getActivePhonesForStage");
    Connection connection = null;
    try {
      connection = getConnection();
      PhoneDao dao = new PhoneDao(connection);
      return dao.getActivePhonesForStage(stageId, stageCode);
    }
    catch (SQLException e) {
      throw new RuntimeWrappedException(e);
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(connection);
    }
  }

  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}
