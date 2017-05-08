package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ejb.SessionContext;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

/** SemaphoreUtility EJB. */
public class SemaphoreUtilityBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "SemaphoreUtilityBean";

  /**
   */
  public void createSemaphore(int id, String tableName, String columnName)
          throws EjbValidationException {
    GrndsTrace.enterScope(TRACE_TAG + ".createSemaphore(" + id + ", " + tableName + ", " + columnName + ")");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = getConnection();

      preparedStatement = connection.prepareStatement("insert into " + tableName + "(" + columnName + ") values (?)");

      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
      
    }
    catch (Exception e) {
      SessionContext sessionContext = super.getSessionContext();
      if (sessionContext.getRollbackOnly() == false) {
        sessionContext.setRollbackOnly();
      }

      if ((e instanceof SQLException) &&
          (e.getMessage().indexOf("unique constraint") != -1)) {
        throw new EjbValidationException(Messages.MSG_DOUBLE_CLICK_PREVENTED, e, BasePrsException.WARNING_PRIORITY);
      }
      throw new RuntimeWrappedException(e);
    }
    finally {
      GrndsTrace.exitScope();
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      }
      catch (SQLException e) {
        throw new RuntimeWrappedException(e);
      }
      finally {
        cleanup(connection);
      }
    }
  }

  public void deleteSemaphore(int id, String tableName, String columnName) {
    GrndsTrace.enterScope(TRACE_TAG + ".deleteSemaphore(" + id + ", " + tableName + ", " + columnName + ")");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = getConnection();

      preparedStatement = connection.prepareStatement("delete from " + tableName + " where " + columnName + " = ?");

      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    }
    catch (Exception e) {
      SessionContext sessionContext = super.getSessionContext();
      if (sessionContext.getRollbackOnly() == false) {
        sessionContext.setRollbackOnly();
      }
      throw new RuntimeWrappedException(e);
    }
    finally {
      GrndsTrace.exitScope();
      cleanup(preparedStatement);
      cleanup(connection);
    }
  }

  protected void cleanup(PreparedStatement preparedStatement) {
    try {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
    }
    catch (SQLException e) {
      //ignore this one
      //e.printStackTrace();
    }
  }

  /** Gets a JDBC Tx Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }
}
