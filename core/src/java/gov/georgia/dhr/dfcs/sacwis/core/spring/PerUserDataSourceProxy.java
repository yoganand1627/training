package gov.georgia.dhr.dfcs.sacwis.core.spring;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.MultiSchemaHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

public class PerUserDataSourceProxy implements DataSource, InitializingBean, Referenceable, Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private DataSource dataSource;
  private String defaultSchema;
  private Set<String> schemas;

  public PerUserDataSourceProxy(DataSource dataSource, String defaultSchema) {
    this.dataSource = dataSource;
    this.defaultSchema = defaultSchema.toLowerCase();
  }

  public void afterPropertiesSet() throws SQLException {
    // Cache the valid schemas so we can quickly reject invalid schemas.
    Connection conn = null;
    try {
      conn = getConnection();
      Set<String> schemas = MultiSchemaHelper.getSchemaList(conn);
      // Run throught the list and make them all lower case.
      Set<String> lowercaseSchemas = new LinkedHashSet<String>(schemas.size());
      for (String schema : schemas) {
        lowercaseSchemas.add(schema.toLowerCase());
      }
      this.schemas = Collections.unmodifiableSet(lowercaseSchemas);
    } finally {
      if (conn != null) {
        conn.close();
      }
    }
  }

  private void setPerUserSchema(Connection connection, String schema) throws SQLException {
    if (schema == null) {
      throw new IllegalStateException("Schema cannot be null.");
    }
    // We need to alter the default schema.
    PreparedStatement statement = null;
    try {
      // Not sure why, but the schema cannot be set as a bound variable; it must be part of the SQL text.
      statement = connection.prepareStatement("ALTER SESSION SET CURRENT_SCHEMA=" + schema);
      statement.executeUpdate();
    } finally {
      if (statement != null) {
        statement.close();
      }
    }
  }

  private String normalizeUser(String username) {
    // If the username starts with the default schema name, set the default schema;
    //   this supports caps, capson, and capsbat.
    if (username == null) {
      return defaultSchema;
    }
    username = username.toLowerCase();
    if (schemas.contains(username)) {
      return username;
    } else if (username.length() >= 4 && username.startsWith(defaultSchema)) {
      return defaultSchema;
    }
    // If we got here, it means that the username did not match a schema or start with CAPS; throw an exception.
    // Note that this is somewhat dangerous, as if this were ever thrown during the message startup,
    //   there would be some very odd problems.  However, because CAPS is a valid schema, that doesn't seem to happen.
    throw new SecurityException(MessageLookup.getMessageByNumber(Messages.MSG_CMN_NOT_CAPS_USER));
  }

  public Connection getConnection() throws SQLException {
    // Get the username first so an exception is thrown BEFORE the conection is retrieved from the pool
    //   if the username is invalid.
    String username = normalizeUser(UsernameContextHolder.getUsername());
    Connection connection = dataSource.getConnection();
    try {
      setPerUserSchema(connection, username);
    } catch (Exception e) {
      if (connection != null) {
        connection.close();
      }
      // Re-throw the exception
      if (e instanceof SQLException) {
        throw (SQLException) e;
      } else if (e instanceof RuntimeException) {
        throw (RuntimeException) e;
      }
      SQLException sqlException = new SQLException("Unknown exception setting the current schema.");
      sqlException.initCause(e);
      throw sqlException;
    }
    return connection;
  }

  public Connection getConnection(String username, String password) throws SQLException {
    // Get the username first so an exception is thrown BEFORE the conection is retrieved from the pool
    //   if the username is invalid.
    username = normalizeUser(username);
    Connection connection = dataSource.getConnection(username, password);
    try {
      setPerUserSchema(connection, username);
    } catch (Exception e) {
      if (connection != null) {
        connection.close();
      }
      // Re-throw the exception
      if (e instanceof SQLException) {
        throw (SQLException) e;
      } else if (e instanceof RuntimeException) {
        throw (RuntimeException) e;
      }
      SQLException sqlException = new SQLException("Unknown exception setting the current schema.");
      sqlException.initCause(e);
      throw sqlException;
    }
    return connection;
  }

  public int getLoginTimeout() throws SQLException {
    return dataSource.getLoginTimeout();
  }

  public PrintWriter getLogWriter() throws SQLException {
    return dataSource.getLogWriter();
  }

  public void setLoginTimeout(int seconds) throws SQLException {
    dataSource.setLoginTimeout(seconds);
  }

  public void setLogWriter(PrintWriter output) throws SQLException {
    dataSource.setLogWriter(output);
  }

  public Reference getReference() throws NamingException {
    return ((Referenceable) dataSource).getReference();
  }

@Override
public Logger getParentLogger() throws SQLFeatureNotSupportedException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean isWrapperFor(Class<?> arg0) throws SQLException {
	// TODO Auto-generated method stub
	return false;
}

@Override
public <T> T unwrap(Class<T> arg0) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}