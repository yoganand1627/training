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

public class GenerateMessagesTask extends GenerateCodeTask {
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
      stmt.setFetchSize(2000);
      rs = stmt.executeQuery("SELECT NBR_MESSAGE, TXT_MESSAGE_NAME FROM MESSAGE ORDER BY NBR_MESSAGE");
      rs.setFetchSize(2000);
      while (rs.next()) {
        String messageNum = rs.getString("NBR_MESSAGE");
        String messageName = rs.getString("TXT_MESSAGE_NAME");
        messageNum = messageNum.trim();
        messageName = messageName.trim();

        char[] mb = messageName.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mb.length; i++) {
          if (mb[i] == ' ') {
            sb.append('_');
          } else if ((i == 0 && Character.isJavaIdentifierStart(mb[i])) ||
                     Character.isJavaIdentifierPart(mb[i])) {
            sb.append(mb[i]);
          }
        }
        messageName = sb.toString();
        pw.println("  public static final int " + messageName + " = " + messageNum + ";");
        count++;
      }
      pw.println();
      pw.println("}");
    }
    catch (IOException e) {
      throw new BuildException("Error writing to '" + className + ".java" + "'.", e);
    }
    catch (SQLException e) {
      throw new BuildException("Error querying for codes.", e);
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
    log("Successfully generated " + count + " message constants in " + (System.currentTimeMillis() - start) + " ms.",
        Project.MSG_INFO);
  }
}
