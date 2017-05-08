/**
 * Created on Jun 27, 2007 at 3:42:27 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BatchLockInterceptor implements MethodInterceptor, Serializable {

  private static final String SERVICE_CACHE_QUERY = "SELECT DISTINCT NM_SERVICE_NAME FROM BATCH_SERVICE_LOCKS";
  private static final String SERVICE_LOCK_QUERY =
          "SELECT 'x' FROM BATCH_SERVICE_LOCKS WHERE NM_SERVICE_NAME=? AND IND_SERVICE_LOCKED='Y'";

  /** The list of lockable services; it caches the services that can be locked on startup. */
  private Set<String> lockableServices = null;
  private DataSource dataSource;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void initialize() throws SQLException {
    // Cache the list of services that can be locked
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Set<String> lockableServices = new HashSet<String>();
    try {
      connection = dataSource.getConnection();
      stmt = connection.prepareStatement(SERVICE_CACHE_QUERY);
      rs = stmt.executeQuery();
      while (rs.next()) {
        lockableServices.add(rs.getString(1));
      }
    } catch (IllegalStateException e) {
      // Ignore this; it only happens on startup.
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (connection != null) {
          connection.close();
        }
      } catch (Exception e) {
        // Just log the exception
        String grndsLoggerName =
                GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                             "exception.globalLogger");
        GrndsLogger logger = GrndsLogger.getLogger(grndsLoggerName);
        logger.log(GrndsLevel.ALERT, "Failure closing JDBC resources when caching lockable services.", e);
      }
    }
    this.lockableServices = Collections.unmodifiableSet(lockableServices);
  }

  /**
   * This method checks for batch service locks.  Because services should not proceed unless the check is successful,
   * exceptions doing the check are not caught.
   *
   * @param invocation
   * @return
   * @throws Throwable
   */
  @SuppressWarnings({"ProhibitedExceptionDeclared"})
  public Object invoke(MethodInvocation invocation) throws Throwable {
    String serviceName = invocation.getMethod().getDeclaringClass().getName();
    // Only do the DB query if the service is in the cached lockable set.
    if (lockableServices.contains(serviceName)) {
      Connection connection = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      try {
        connection = JdbcHelper.getConnection();
        stmt = connection.prepareStatement(SERVICE_LOCK_QUERY);
        stmt.setString(1, serviceName);
        rs = stmt.executeQuery();
        // It's locked if there are any rows.
        if (rs.next()) {
          throw new ServiceException(Messages.ARC_BAT_SERVICE_BLOCKED);
        }
      } finally {
        try {
          if (rs != null) {
            rs.close();
          }
          if (stmt != null) {
            stmt.close();
          }
          if (connection != null) {
            connection.close();
          }
        } catch (Exception e) {
          // Just log the exception
          String exceptionLoggerName = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                                    "exception.globalLogger");
          GrndsLogger exceptionLogger = GrndsLogger.getLogger(exceptionLoggerName);
          exceptionLogger.log(GrndsLevel.ALERT, "Failure closing JDBC resources in BatchLockInterceptor.", e);
        }
      }
    }
    return invocation.proceed();
  }
}
