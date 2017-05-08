package gov.georgia.dhr.dfcs.sacwis.core.ant;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/**
 * This class queries the ERROR_LIST_DEST and generates the TabConstants class which contains TabConstants with their
 * tabIDs.
 *
 * @author Stephan Brauchli
 */
@SuppressWarnings({"UseOfSystemOutOrSystemErr", "CallToPrintStackTrace"})
public class GenerateTabConstantsTask extends GenerateCodeTask {

  protected void generate() {
    long start = System.currentTimeMillis();
    String className = getSimpleClassName();
    Connection conn = null;
    PrintWriter pw = null;
    Statement stmt = null;
    ResultSet rs = null;
    int count = 0;
    try {
      conn = getConnection();
      pw = new PrintWriter(new File(getPackageDir(), className + ".java"));

      // Output class header
      pw.println("package " + getPackageName() + ";");
      pw.println();
      pw.println("public class " + className + "{");

      stmt = conn.createStatement();
      //ASC 04/18/2005 - for Oracle 10g driver.
      stmt.setFetchSize(200);
      //   SELECT A.ID_TAB , B.TXT_TAB_CONSTANT
      //     FROM ERROR_LIST A, METAPHOR B
      //    WHERE A.ID_TAB = B.ID_TAB
      // ORDER BY ID_TAB
      rs = stmt.executeQuery("SELECT ID_TAB, TXT_TAB_CONSTANT FROM METAPHOR ORDER BY ID_TAB");
      rs.setFetchSize(200);
      while (rs.next()) {
        String tabConstant = rs.getString("TXT_TAB_CONSTANT");
        int tabID = rs.getInt("ID_TAB");

        pw.println("  public static final int " + tabConstant + " = " + tabID + ";");
        count++;
      }
      pw.println();
      pw.println("}");
    } catch (IOException e) {
      throw new BuildException("Error writing to '" + className + ".java" + "'.", e);
    } catch (SQLException e) {
      throw new BuildException("Error querying for tab constants.", e);
    } finally {
      // Close the file
      if (pw != null) {
        pw.flush();
        pw.close();
      }
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          // ignore this
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          // ignore this
        }
      }
      try {
        if (conn != null && !conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException e) {
        //noinspection ThrowFromFinallyBlock
        throw new BuildException("Failed to close DB connection.", e);
      }
    }
    log("Successfully generated " + count + " tab constants in " + (System.currentTimeMillis() - start) + " ms.",
        Project.MSG_INFO);
  }
}
