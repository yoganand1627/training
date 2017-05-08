package gov.georgia.dhr.dfcs.sacwis.core.jdbchelper;

import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SJSASContextSingletonBeanFactoryLocator;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SpringConstants;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.access.BeanFactoryLocator;

public final class JdbcHelper implements SpringConstants {

  //private static final String TRACE_TAG = JdbcHelper.class.getSimpleName();

  private static final int NUMBER_OF_RETRIES = 1;

  private static final DataSource DATA_SOURCE;

  static {
    BeanFactoryLocator locator = SJSASContextSingletonBeanFactoryLocator.getInstance(SERVICE_CONTEXT_SELECTOR);
    DATA_SOURCE = (DataSource) locator.useBeanFactory(SERVICE_BEAN_FACTORY).getFactory().getBean("dataSource");
  }

  static {
    // Sanity check on load.
    if (DATA_SOURCE == null) {
      String msg = "Default data source is null.  Make sure properties are set and bootstrap process is reading them.";
      throw new RuntimeWrappedException(new LookupException(msg, LookupException.CRITICAL_PRIORITY));
    }
  }

  /** Prevent Instantiation */
  private JdbcHelper() {
  }

  /**
   * Obtains a connection from the Connection pool specified in the properties file.
   *
   * @return Connection
   */
  public static Connection getConnection() {
    Connection connection;
    // Try getting connection a specified number of times; this will allow "retry" of connection getting in case there
    //   are no connections available at the time of the first request.
    int count = 0;
    while (true) {
      try {
        connection = DATA_SOURCE.getConnection();
        break;
      } catch (SQLException e) {
        // Let the loop retry getting a connection unless we are out of retries.
        if (++count >= JdbcHelper.NUMBER_OF_RETRIES) {
          throw new JdbcHelperRuntimeException("Error getting a connection from the DataSource", e);
        }
      }
    }
    return connection;
  }
}
