/**
 * Created on Jul 19, 2007 at 3:12:50 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.MultiSchemaHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.JDBCTask;

public abstract class UpdateDatabaseTask extends JDBCTask {
  protected static final Pattern DEFAULT_SCHEMA_PATTERN =
          Pattern.compile("\\b" + MultiSchemaHelper.DEFAULT_SCHEMA + "[.]", Pattern.CASE_INSENSITIVE);

  protected Connection createConnection() {
    Connection connection = null;
    // Do not use auto-commit;
    try {
      connection = getConnection();
      connection.setAutoCommit(false);
    } catch (Exception e) {
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e1) {
        // Ignore it.
      }
      throw new BuildException("Cannot turn off auto commit.", e);
    }
    return connection;
  }
}
