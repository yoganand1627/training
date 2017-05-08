package gov.georgia.dhr.dfcs.sacwis.core.ant;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

public class GenerateCodesTablesTask extends GenerateCodeTask {
  /** Timestamp used to mark when the codes tables were generated for deprecation. */
  private static final long NOW = new Date().getTime();

  private static final String SELECT_CODES_TABLES = "  SELECT CODE_TYPE, " +
                                                    "         CODE, " +
                                                    "         DT_END " +
                                                    "    FROM CODES_TABLES " +
                                                    "ORDER BY CODE_TYPE, CODE";

  private int codeTypesPerGroup = 20; //-- default to 20 code types per facade (code type group)
  private boolean deprecation = false;
  private String interfaceGroupName = "CodeTypes"; //-- default facade base name

  public void setCodeTypesPerGroup(int codeTypesPerGroup) {
    if (codeTypesPerGroup > 0) {
      this.codeTypesPerGroup = codeTypesPerGroup;
    }
  }

  public void setDeprecation(boolean deprecation) {
    this.deprecation = deprecation;
  }

  public void setInterfaceGroupName(String interfaceGroupName) {
    this.interfaceGroupName = interfaceGroupName;
  }

  protected void generate() {
    long start = System.currentTimeMillis();
    Connection conn = null;
    String className = getSimpleClassName();
    PrintWriter pw = null;
    boolean pwOpen = false;
    int totalConstants = 0;
    int numberOfInterfaces = 0;
    File packageDir = getPackageDir();
    String packageName = getPackageName();
    try {
      conn = getConnection();

      //-- retrieve codes to build as constants
      Map<String, SortedMap<String, Date>> codeMap = getCodes(conn);
      Set<String> codeTypeSet = codeMap.keySet();
      int numberCodeTypes = codeTypeSet.size();

      String interfacePackageSuffix = className.toLowerCase();
      File interfacePackageDir = new File(packageDir, interfacePackageSuffix);
      if (interfacePackageDir.exists() && interfacePackageDir.isDirectory()) {
        deleteDir(interfacePackageDir); //-- recursively deletes dir and its contents
      }
      interfacePackageDir.mkdir();
      String interfacePackageName = packageName + "." + interfacePackageSuffix;
      StringBuilder classImports = new StringBuilder();
      StringBuilder classImplements = new StringBuilder("implements\n  ");
      StringBuilder facadeExtends = new StringBuilder("extends ");

      int facadeCount = 0;

      //-- build a separate interface for each code type
      for (String codeType : codeTypeSet) {
        String interfaceName = codeType.substring(0, 1).toUpperCase() + codeType.substring(1).toLowerCase();
        File interfaceSourceFile = new File(interfacePackageDir, interfaceName + ".java");
        interfaceSourceFile.createNewFile();
        pw = new PrintWriter(interfaceSourceFile);
        pwOpen = true;

        //-- interface header
        pw.println("package " + interfacePackageName + ";");
        pw.println();
        pw.println("public interface " + interfaceName + " {");
        pw.println();

        //-- constant for codeType name
        pw.println("  public static final String " + codeType + " = " + "\"" + codeType + "\";");
        totalConstants++;

        SortedMap<String, Date> codeCategoryMap = codeMap.get(codeType);
        Set<String> codeSet = codeCategoryMap.keySet();
        for (String code : codeSet) {
          // We need to convert the code into a legal java identifier; we will also replace "#" with "NUMBER"
          StringBuilder sb = new StringBuilder();
          sb.append(codeType).append('_');
          for (int index = 0; index < code.length(); index++) {
            char c = code.charAt(index);
            sb.append(Character.isJavaIdentifierPart(c) ? String.valueOf(Character.toUpperCase(c)) :
                      Character.isWhitespace(c) ? "_" : c == '#' ? "NUMBER" : "");
          }
          // Strip trailing non-alphanumerics
          while (!Character.isLetterOrDigit(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
          }
          // Deprecate the code if it is end-dated
          Date dtEnd = codeCategoryMap.get(code);
          if (deprecation && dtEnd != null && dtEnd.getTime() < NOW) {
            pw.println("  /** @deprecated This code has been end-dated; it should not be used.  */");
            pw.println("  @Deprecated");
          }
          pw.println("  public static final String " + sb.toString() + " = " + "\"" + code + "\";");
          totalConstants++;
        }

        //-- interface closer, flush and close PrintWriter for interface
        pw.println("\n}");
        pw.flush();
        pw.close();
        pwOpen = false;
        numberOfInterfaces++;

        facadeExtends.append(interfaceName).append(", ");

        //-- group each set of 20 code type interfaces into one facade
        if (numberOfInterfaces % codeTypesPerGroup == 0 || numberOfInterfaces == numberCodeTypes) {
          String facadeName = interfaceGroupName + (facadeCount++);
          File facadeSourceFile = new File(interfacePackageDir, facadeName + ".java");
          facadeSourceFile.createNewFile();
          pw = new PrintWriter(facadeSourceFile);
          pwOpen = true;

          String extendsString = facadeExtends.substring(0, facadeExtends.length() - 2);
          facadeExtends = new StringBuilder("extends ");

          pw.println("package " + interfacePackageName + ";");
          pw.println();
          pw.println("public interface " + facadeName + " " + extendsString + " {}");
          pw.flush();
          pw.close();
          pwOpen = false;

          //-- add code type facade to class statements
          classImports.append("import ").append(interfacePackageName).append(".").append(facadeName).append(";\n");
          String implementsLineEnd = facadeCount % 5 == 0 ? "\n  " : "";
          if (numberOfInterfaces < numberCodeTypes) {
            classImplements.append(facadeName).append(", ").append(implementsLineEnd);
          } else {
            classImplements.append(facadeName).append(implementsLineEnd);
          }
        }
      }

      //-- build empty class
      pw = new PrintWriter(new File(packageDir, className + ".java"));
      pwOpen = true;

      //-- class header and declaration
      pw.println("package " + packageName + ";");
      pw.println();
      pw.println(classImports.toString());
      //pw.println("import " + interfacePackageName + ".*;\n");
      pw.println("public class " + className + " " + classImplements.toString() + " {}");
      pw.flush();
      pw.close();
      pwOpen = false;
    }
    catch (IOException e) {
      throw new BuildException("Error writing '" + className + "' source files.", e);
    }
    catch (SQLException e) {
      throw new BuildException("SQL error generating constants.", e);
    } finally {
      if (pwOpen && pw != null) {
        pw.flush();
        pw.close();
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
    log("Successfully generated " + numberOfInterfaces + " code type interfaces with " + totalConstants +
        " codes constants in " + (System.currentTimeMillis() - start) + " ms.",
        Project.MSG_INFO);
  }

  private Map<String, SortedMap<String, Date>> getCodes(Connection conn) throws SQLException {
    SortedMap<String, SortedMap<String, Date>> codeMap = new TreeMap<String, SortedMap<String, Date>>();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = conn.prepareStatement(SELECT_CODES_TABLES);
      //ASC 04/18/2005 - for Oracle 10g driver.
      stmt.setFetchSize(2000);
      rs = stmt.executeQuery();
      rs.setFetchSize(2000);
      while (rs.next()) {
        String codeType = rs.getString("CODE_TYPE");
        SortedMap<String, Date> codeSet = codeMap.get(codeType);
        if (codeSet == null) {
          codeSet = new TreeMap<String, Date>();
          codeMap.put(codeType, codeSet);
        }
        codeSet.put(rs.getString("CODE"), rs.getTimestamp("DT_END"));
      }
    }
    catch (SQLException e) {
      throw new BuildException("Error querying for codes.", e);
    }
    finally {
      if (rs != null) {
        rs.close();
      }
      if (stmt != null) {
        stmt.close();
      }
    }
    return codeMap;
  }

  private void deleteDir(File dir) {
    File[] files = dir.listFiles();
    if (files != null && files.length > 0) {
      for (File file : files) {
        if (file.isDirectory()) {
          deleteDir(file);
        } else {
          file.delete();
        }
      }
    }
    dir.delete();
  }

}
