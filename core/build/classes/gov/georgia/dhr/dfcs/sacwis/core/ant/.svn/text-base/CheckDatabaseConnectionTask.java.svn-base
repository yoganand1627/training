/**
 * Created on Aug 4, 2006 at 10:40:17 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.JDBCTask;

public class CheckDatabaseConnectionTask extends JDBCTask {

  private String property;
  private String value;

  /**
   * The name of the property to set. Required.
   *
   * @param property the name of the property
   */
  public void setProperty(String property) {
    this.property = property;
  }

  /**
   * The value for the property to set, if condition evaluates to true. Defaults to "true".
   *
   * @param value the value of the property
   */
  public void setValue(String value) {
    this.value = value;
  }

  public void execute() throws BuildException {
    Connection connection = null;
    try {
      log("Checking database connection...", Project.MSG_INFO);
      connection = getConnection();
      if (isValidRdbms(connection)) {
        getProject().setNewProperty(property, value == null ? "true" : value);
        log("Database connection is available.", Project.MSG_INFO);
      } else {
        log("Database connection not available.", Project.MSG_INFO);
      }
    } catch (BuildException e) {
      Throwable cause = e.getCause();
      if (cause instanceof SQLException) {
        log("Database connection not available.", Project.MSG_WARN);
      } else {
        log("Unknown error checking database connection.", Project.MSG_ERR);
        throw new BuildException(e);
      }
    } finally {
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        //noinspection ThrowFromFinallyBlock
        throw new BuildException("Failed to close test connection.", e);
      }
    }
  }
}
