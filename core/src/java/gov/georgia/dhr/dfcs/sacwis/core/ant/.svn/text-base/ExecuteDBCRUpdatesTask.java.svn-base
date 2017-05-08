/**
 * Created on Aug 4, 2006 at 1:08:05 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.ant;

import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.MultiSchemaHelper;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

@SuppressWarnings({"UseOfSystemOutOrSystemErr"})
public class ExecuteDBCRUpdatesTask extends UpdateDatabaseTask {

  protected static final String SQL_SCRIPT_TYPE = "sql";
  protected static final String MULTI_SCHEMA_SCRIPT_POSTFIX = "T";

  private static final Pattern UPDATE_DEFAULT_SCHEMA_PATTERN =
          Pattern.compile("(dbms_utility[.]compile_schema\\s*\\(\\s*')(CAPS)('\\s*\\)\\s*)", Pattern.CASE_INSENSITIVE);

  private static final int PACKAGE_LENGTH = "PACKAGE".length();
  private static final int LOOK_BACK_FROM = 230;
  private static final int NO_SCHEMA = -1;

  private String property;
  private String value;
  private File updateDir;
  private String scriptPrefix;
  private boolean verbose = false;

  public void setProperty(String property) {
    this.property = property;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setUpdateDir(File updateDir) {
    this.updateDir = updateDir;
  }

  public void setScriptPrefix(String scriptPrefix) {
    this.scriptPrefix = scriptPrefix;
  }

  public void setVerbose(boolean verbose) {
    this.verbose = verbose;
  }

  public void execute() throws BuildException {
    // Get the list of schemas
    Connection connection = null;
    Set<String> schemas;
    boolean multiSchema = false;
    try {
      connection = getConnection();
      schemas = MultiSchemaHelper.getSchemaList(connection);
    } catch (SQLException e) {
      throw new BuildException("Failed to retrieve schema list.", e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
    }
    if (schemas.isEmpty() == false) {
      multiSchema = true;
    }
    // First, execute on the defauld schema.
    executeUpdates(MultiSchemaHelper.DEFAULT_SCHEMA, multiSchema);
    // Execute the script on each schema
    for (Iterator<String> it = schemas.iterator(); it.hasNext();) {
      executeUpdates(it.next(), multiSchema);
    }
    // Last, go through and compile invalid objects
    compileInvalidStatements(getInvalidObjectCompileStatements());
  }

  private void compileInvalidStatements(Map<String, String> invalidObjectCompileStatements) {
    Connection connection = getConnection();
    try {
      for (Iterator<String> it = invalidObjectCompileStatements.keySet().iterator(); it.hasNext();) {
        String name = it.next();
        String sql = invalidObjectCompileStatements.get(name);
        PreparedStatement stmt = null;
        try {
          stmt = connection.prepareStatement(sql);
          stmt.execute();
          log("Successfully compiled invalid " + name + ".", Project.MSG_INFO);
        } catch (SQLException e) {
          // Log and continue
          log("Execption executing compile statement '" + sql + "': " + e.getMessage(), Project.MSG_ERR);
        } finally {
          try {
            if (stmt != null) {
              stmt.close();
            }
          } catch (SQLException e) {
            // Ignore this.
          }
        }
      }
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        // Ignore this.
      }
    }
  }

  private Map<String, String> getInvalidObjectCompileStatements() {
    Map<String, String> invalidObjectCompileStatements = new LinkedHashMap<String, String>();
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      connection = getConnection();
      stmt = connection.prepareStatement("   select object_type, " +
                                         "          owner, " +
                                         "          object_name " +
                                         "     from dba_objects " +
                                         "    where status = 'INVALID' " +
                                         "      and (owner = 'CAPS' " +
                                         "        or owner = 'SACWISIFC' " +
                                         "        or owner like 'TRN%') " +
                                         "     and object_type <> 'TABLE' " +
                                         "     and object_type <> 'INDEX' " +
                                         "     and object_type <> 'SYNONYM' " +
                                         "order by object_type, " +
                                         "         object_name ");
      rs = stmt.executeQuery();
      while (rs.next()) {
        String objectType = rs.getString(1);
        String owner = rs.getString(2);
        String objectName = rs.getString(3);
        StringBuilder nameSB = new StringBuilder();
        nameSB.append(objectType).append(", ").append(owner).append(".").append(objectName);
        String name = nameSB.toString();
        System.out.format("Found invalid %s.\n", name);
        System.out.flush();
        boolean isPackage = objectType.contains("PACKAGE");
        StringBuilder alterStatement = new StringBuilder();
        alterStatement.append("alter ");
        alterStatement.append(isPackage ? "PACKAGE" : objectType);
        alterStatement.append(" ");
        alterStatement.append(owner);
        alterStatement.append(".");
        alterStatement.append(objectName);
        alterStatement.append(" compile");
        if(isPackage) {
          alterStatement.append(" PACKAGE");
        }
        invalidObjectCompileStatements.put(name, alterStatement.toString());
        if (isPackage) {
          // Replace "PACKAGE" with "BODY for the 2nd statement.
          int alterStatementLength = alterStatement.length();
          alterStatement.replace(alterStatementLength - PACKAGE_LENGTH, alterStatementLength, "BODY");
          invalidObjectCompileStatements.put(name, alterStatement.toString());
        }
      }
    } catch (SQLException e) {
      throw new BuildException("Failed to retrieve invalid objects list.", e);
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (SQLException e) {
        // Ignore this.
      }
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (SQLException e) {
        // Ignore this.
      }
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        // Ignore this.
      }
    }
    return invalidObjectCompileStatements;
  }

  private void executeUpdates(String schema, boolean multiSchema) {
    File updateScript;
    int schemaVersion;
    // WARNING: Both assignments in this statement are _critical_; it's bad style, but works very well here to get both
    //   the updateScript reference and the schemaVersion reference at exactly the right time.
    while ((updateScript = getNextUpdateScript(schema, multiSchema)) != null) {
      log("Found script: " + updateScript, Project.MSG_INFO);
      // Buffer the contents of the script.
      FileInputStream file = null;
      // Create a conneciton for each script.
      Connection connection = null;
      try {
        file = new FileInputStream(updateScript);
        byte[] b = new byte[file.available()];
        if (0 == file.read(b)) {
          throw new BuildException("Update script is empty.");
        }
        schemaVersion = getFileVersion(updateScript);
        List<SQLStatement> statementList = parseScript(new String(b));
        connection = createConnection();
        executeScriptForSchema(connection, statementList, schema, schemaVersion);
        if (property != null) {
          getProject().setNewProperty(property, value == null ? "true" : value);
        }
        log("Script '" + updateScript + "' updated successfully on the " +
            (schema == null ? MultiSchemaHelper.DEFAULT_SCHEMA : schema) + " schema.",
            Project.MSG_INFO);
      } catch (IOException e) {
        throw new BuildException("Failed to read update script: " + updateScript, e);
      } catch (SQLException e) {
        throw new BuildException("Failed to update schema: " + schema, e);
      } finally {
        try {
          if (connection != null && !connection.isClosed()) {
            connection.close();
          }
        } catch (SQLException e) {
          //noinspection ThrowFromFinallyBlock
          throw new BuildException("Error closing database connection.", e);
        }
        if (file != null) {
          try {
            file.close();
          } catch (IOException e) {
            //noinspection ThrowFromFinallyBlock
            throw new BuildException("Error closing update script file.", e);
          }
        }
      }
    }
  }

  private void executeScriptForSchema(Connection connection, List<SQLStatement> statementList, String schema,
                                      int schemaVersion)
          throws SQLException {
    int totalStatements = statementList.size();
    int currentStatement = 1;
    for (Iterator<SQLStatement> it = statementList.iterator(); it.hasNext();) {
      SQLStatement sqlStatement = it.next();
      execSQL(connection, schema, schemaVersion, sqlStatement, currentStatement++, totalStatements);
      if (sqlStatement.isCommit()) {
        if (verbose) {
          log("Executing commit.", Project.MSG_INFO);
        }
        connection.commit();
        processWarnings(connection);
      }
    }
    // Commit the script at the end automatically.
    if (verbose) {
      log("Executing commit.", Project.MSG_INFO);
    }
    connection.commit();
    processWarnings(connection);
  }

  private List<SQLStatement> parseScript(String rawSqlScript) {
    List<SQLStatement> statementList = new LinkedList<SQLStatement>();
    // Replace all tabs with 2 spaces and normalize all line endings to '\n' to prevent trigger errors.
    String sqlScript = rawSqlScript.replaceAll("\t", "  ").replaceAll("\r\n|\n|\r|\u0085|\u2028|\u2029", "\n").trim();
    // Split statements on semicolons OR / characters on single lines
    Pattern pattern = Pattern.compile("(;\\s*$|^\\s*/\\s*$)", Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(sqlScript);
    boolean inPlSQL = false;
    int previousEnd = 0;
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      String delimeter = sqlScript.substring(start, end).trim();
      // All of our delimiters should have exactly 1 character after being trimmed; this is a sanity-check.
      if (delimeter.length() != 1) {
        throw new BuildException("Unknown delimiter found: " + delimeter);
      }
      String sql;
      boolean commit = false;
      if ("/".equals(delimeter.trim())) {
        if (inPlSQL) {
          inPlSQL = false;
          // Create the SQL statement.
          sql = sqlScript.substring(previousEnd, start);
          // Set commit to true.
          commit = true;
          // Fall through to execute below.
        } else {
          // Start a Pl/SQL block.
          inPlSQL = true;
          // Execute the previous statement.
          sql = sqlScript.substring(previousEnd, start);
        }
      } else if (inPlSQL) {
        // We do not want to execute the individual statement, as we're in a PL/SQL block.
        continue;
      } else {
        // Create a SQL statement minus the trailing semicolon.
        sql = sqlScript.substring(previousEnd, start);
      }
      // Add a trimmed version of the sql statement.
      statementList.add(new SQLStatement(sql.trim(), commit));
      previousEnd = end;
    }
    return statementList;
  }

  /**
   * Borrowed and modified from the Ant {@link org.apache.tools.ant.taskdefs.SQLExec} task.
   *
   * @param sqlStatement
   * @throws java.sql.SQLException
   */
  private void execSQL(Connection conn, String schema, int schemaVersion, SQLStatement sqlStatement,
                       int currentStatement, int totalStatements)
          throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    String sql = sqlStatement.getSql();
    try {
      if (verbose) {
        log("Statement:\n" + sql, Project.MSG_INFO);
      } else {
        System.out.format("Executing statement %d of %d in update %d on the %s schema.\n",
                          currentStatement, totalStatements, schemaVersion, schema);
        System.out.flush();
      }
      // Test for empty statements by stripping comments and calling trim();
      if (sql.replaceAll("(?m)--.*$", "").trim().length() == 0) {
        if (verbose) {
          System.out.println("Skipped empty statement:\n" + sqlStatement.getSql());
        } else {
          System.out.println("Skipped empty statement.");
        }
        System.out.flush();
        // Return; we are done.
        return;
      }
      // Remove comments before the statement.
      while (sql.startsWith("--") && sql.contains("\n")) {
        sql = sql.replaceFirst("(?s)^--.*?\n", "").trim();
      }
      Matcher defaultSchemaMatcher = DEFAULT_SCHEMA_PATTERN.matcher(sql);
      Matcher updateDefaultSchemaMatcher = UPDATE_DEFAULT_SCHEMA_PATTERN.matcher(sql);
      // If we are using a specific schema, do not execute statements unless they contain the default schema.
      if (!MultiSchemaHelper.DEFAULT_SCHEMA.equals(schema) && !defaultSchemaMatcher.find()) {
        if (verbose) {
          System.out.println("Skipped non-schema-specific statement:\n" + sqlStatement.getSql());
        } else {
          System.out.println("Skipped non-schema-specific statement.");
        }
        System.out.flush();
        return;
      } else if (updateDefaultSchemaMatcher.find()) {
        sql = updateDefaultSchemaMatcher.replaceAll("$1" + schema + "$3");
      } else {
        sql = defaultSchemaMatcher.replaceAll(schema + ".");
      }
      stmt = conn.createStatement();
      int updateCountTotal = 0;
      boolean ret = stmt.execute(sql);
      processWarnings(conn);
      int updateCount = stmt.getUpdateCount();
      rs = stmt.getResultSet();
      processWarnings(conn);
      do {
        if (!ret) {
          if (updateCount != -1) {
            updateCountTotal += updateCount;
          }
        } else if (verbose) {
          printResults(rs);
        }
        ret = stmt.getMoreResults();
        processWarnings(conn);
        updateCount = stmt.getUpdateCount();
        processWarnings(conn);
        if (ret) {
          rs = stmt.getResultSet();
        }
      } while (ret || updateCount != -1);
      if (verbose) {
        log(updateCountTotal + " rows affected", Project.MSG_INFO);
      }
    } catch (SQLException e) {
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
      processWarnings(conn);
      throw new BuildException("Failed to update DB on statement:\n" + sql + "\nWith error: " + e.getMessage(), e);
    } finally {
      if (rs != null) {
        rs.close();
      }
      if (stmt != null) {
        stmt.close();
      }
    }
  }

  private void processWarnings(Connection conn) throws SQLException {
    SQLWarning warning = conn.getWarnings();
    while (warning != null) {
      if (verbose) {
        log("SQL warning message: " + warning.getMessage(), Project.MSG_INFO);
        log("SQL warning error code: " + warning.getErrorCode(), Project.MSG_INFO);
        log("SQL warning state: " + warning.getSQLState(), Project.MSG_INFO);
      }
      warning = warning.getNextWarning();
    }
    conn.clearWarnings();
  }

  /**
   * Borrowed and modified from the Ant {@link org.apache.tools.ant.taskdefs.SQLExec} task.
   *
   * @param rs the resultset to print information about
   * @throws SQLException on SQL problems.
   * @since Ant 1.6.3
   */
  protected void printResults(ResultSet rs) throws SQLException {
    if (rs != null) {
      if (verbose) {
        log("Processing new result set.", Project.MSG_INFO);
      }
      ResultSetMetaData md = rs.getMetaData();
      int columnCount = md.getColumnCount();
      StringBuffer output = new StringBuffer();
      for (int col = 1; col < columnCount; col++) {
        output.append(md.getColumnName(col));
        output.append(",");
      }
      output.append(md.getColumnName(columnCount));
      output.append("\n");
      while (rs.next()) {
        boolean first = true;
        for (int col = 1; col <= columnCount; col++) {
          String columnValue = rs.getString(col);
          if (columnValue != null) {
            columnValue = columnValue.trim();
          }

          if (first) {
            first = false;
          } else {
            output.append(",");
          }
          output.append(columnValue);
        }
        output.append("\n");
      }
      output.append("\n");
      if (verbose) {
        log(output.toString(), Project.MSG_INFO);
      }
    }
  }
  
  private int getFileVersion(File theFile){
    int version = NO_SCHEMA;
    if (theFile != null) {
      String fname = theFile.getName();
      // System.out.println("fname in getFileVersion is "+ fname);
      if (fname != null) {
        int firstPos = fname.indexOf('_');
        fname = fname.toUpperCase();
        int secondPos = fname.indexOf('T');
        if (secondPos <= 0) {
          secondPos = fname.indexOf('.');
        }
        if (firstPos >= 0 && secondPos >= firstPos) {
            String segment = fname.substring(firstPos+1, secondPos );
            // System.out.println("segment in getFileVersion is " + segment);
            try {
            version = Integer.parseInt(segment);
            } catch (java.lang.NumberFormatException nfe){
              version = NO_SCHEMA;
            }
        }
      }
    }
    return version;
  }
  
  private File getNextUpdateScript(String schema, boolean multi) {
    File nextFile = null;
    int maxSchemaVersion = getSchemaVersion(schema);
    int gapSchemaVersion = getGapSchemaVersion(schema, maxSchemaVersion-1,LOOK_BACK_FROM);
    if (gapSchemaVersion != NO_SCHEMA) {
      nextFile = getUpdateScript(gapSchemaVersion, multi);
    }
    // See if any files between gap and current
    if (gapSchemaVersion != NO_SCHEMA && nextFile == null) {
      int nextGapSchemaVersion = gapSchemaVersion;
      int nextVersion = 0;
      int topGapVersion =0;
      while (nextGapSchemaVersion != NO_SCHEMA && (nextGapSchemaVersion < (maxSchemaVersion-1)) && nextFile == null) {
        //System.out.println("nextGapSchemaVersion BEFORE: " + nextGapSchemaVersion);
        nextVersion = nextGapSchemaVersion;
        //System.out.println("Initial nextVersion is: " + nextVersion);
        nextGapSchemaVersion = getGapSchemaVersion(schema, maxSchemaVersion-1,nextGapSchemaVersion );
        //System.out.println("nextGapSchemaVersion after: " + nextGapSchemaVersion);
        if (nextGapSchemaVersion == NO_SCHEMA) {
          nextGapSchemaVersion = maxSchemaVersion;
        }
        topGapVersion = getNextSchemaVersion(schema,nextGapSchemaVersion,nextVersion );
        //System.out.println("topGapVersion: " + topGapVersion);
        while((nextVersion < (topGapVersion-1)) && nextFile == null) {
            //System.out.println("Checking on nextVersion of: " + nextVersion);
            nextFile = getUpdateScript(nextVersion, multi);
            nextVersion++;       
        }
      }
    }
    // Now look for what would logically be the next script - current max schema
    if (nextFile == null) {
      nextFile = getUpdateScript(maxSchemaVersion, multi);
    }
    // Add code to look ahead for a script to run
    if (nextFile == null) {
      nextFile = getNextLookAheadScript(maxSchemaVersion, multi);
    }
    return nextFile;
  }
  
  private File getNextLookAheadScript(int schemaVersion, boolean multiSchema) {
    File aheadFile = null;
    try {
    File currDir = updateDir;
    if (currDir != null) {
      // This filter only returns directories
      FileFilter fileFilter = new FileFilter() {
          public boolean accept(File file) {
              String fname = file.getName().toUpperCase();
              int fversion = getFileVersion(file);
              return (fname.startsWith("SACWIS_") &&
                      fname.endsWith(SQL_SCRIPT_TYPE.toUpperCase()) &&
                      fversion != NO_SCHEMA &&
                      fversion > LOOK_BACK_FROM); 
          }
      };
      File[] files = currDir.listFiles(fileFilter);
      if (files != null) {
      // System.out.println("Filter found #files of: " + files.length);
      int lowVersion = 999999999;
      int lowIndex = -1;
      int currVersion = 0;
      boolean isTFile = false;
      for (int i=0; i < files.length; i++) {
        currVersion = getFileVersion(files[i]);
        if (currVersion > schemaVersion && currVersion < lowVersion) {
          isTFile = isTrainingFile(files[i]);
          if ((isTFile==false) || (multiSchema==true)) {
            lowVersion = currVersion;
            lowIndex = i;
          }
        }
      }
      if (lowIndex > 0) {
        aheadFile = files[lowIndex];
      }
    }
      else {
        System.out.println("No lookahead files");
      }
    }
    } catch (Exception ex) {
      System.out.println("Error looking ahead for file: " + ex.getMessage());
      ex.printStackTrace();
    }
    return aheadFile;
  }
  
  private boolean isTrainingFile(File file) {
    boolean trFile = false;
    if (file != null) {
      String fname = file.getName();
      if (fname != null) {
        fname = fname.toUpperCase();
        if (fname.endsWith(MULTI_SCHEMA_SCRIPT_POSTFIX + "." + SQL_SCRIPT_TYPE.toUpperCase() )) {
          trFile = true;
        }
      }
    }
    return trFile;
  }

  private File getUpdateScript(int schemaVersion, boolean multiSchema) {
    log("Schema version is: " + schemaVersion, Project.MSG_VERBOSE);
    log("Searching for update script in: " + updateDir, Project.MSG_VERBOSE);
    // Look for an update script in the same directory using the provided prefix and type.
    // Only handle SQL scripts right now.
    // If multi-schema support is turned on, check for an update script specific to multi-schema environments
    //   and run it if exists instead of regular one.
    File trainingScript =
            multiSchema ? getUpdateScript(
                    scriptPrefix + schemaVersion + MULTI_SCHEMA_SCRIPT_POSTFIX + "." + SQL_SCRIPT_TYPE) : null;
    if (trainingScript != null) {
      return trainingScript;
    }
    // If mult-schema support is disabled, or if no specific version is found, look for the standard script.
    return getUpdateScript(scriptPrefix + schemaVersion + "." + SQL_SCRIPT_TYPE);
  }

  private File getUpdateScript(String fileName) {
    File updateFile = new File(updateDir, fileName);
    return updateFile.isFile() ? updateFile : null;
  }

  private int getSchemaVersion(String schema) {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      connection = getConnection();
      stmt = connection.prepareStatement("SELECT MAX(ID_SCHEMA_VERSION) FROM " + schema + ".SCHEMA_VERSION");
      rs = stmt.executeQuery();
      if (!rs.next()) {
        throw new BuildException("Database corrupt: Schema version not present in schema: " + schema);
      }
      return rs.getInt(1);
    } catch (SQLException e) {
      throw new BuildException("Error checking schema version.", e);
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          //noinspection ThrowFromFinallyBlock
          throw new BuildException("Failed to close connection.", e);
        }
      }
    }
  }
  
  private int getNextSchemaVersion(String schema, int upperLimit, int lowerLimit) {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String gsqlStr = null;
    try {
      connection = getConnection();
      gsqlStr = "SELECT MIN(S.ID_SCHEMA_VERSION) FROM " + schema + ".SCHEMA_VERSION S WHERE S.ID_SCHEMA_VERSION <= " + upperLimit;
      gsqlStr += " and S.ID_SCHEMA_VERSION > " + LOOK_BACK_FROM;
      gsqlStr += " and S.ID_SCHEMA_VERSION > " + lowerLimit;
      //System.out.println("SQL in getNextSchemaVersion: " + gsqlStr);
      stmt = connection.prepareStatement(gsqlStr);
      rs = stmt.executeQuery();
      if (!rs.next()) {
        return NO_SCHEMA;
      }
      int res = rs.getInt(1);
      if (res == 0) {
        res = NO_SCHEMA;
      }
      return res;
    } catch (SQLException e) {
      throw new BuildException("Error checking schema version.", e);
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          //noinspection ThrowFromFinallyBlock
          throw new BuildException("Failed to close connection.", e);
        }
      }
    }
  }
  
  private int getGapSchemaVersion(String schema, int upperLimit, int lowerLimit) {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String gsqlStr = null;
    try {
      connection = getConnection();
      //select max(s.id_schema_version) from schema_version s where s.id_schema_version < 241 and
      //not exists (select s2.ID_SCHEMA_VERSION from schema_version s2 where s2.ID_SCHEMA_VERSION=(s.id_schema_version+1));
      gsqlStr = "SELECT MIN(S.ID_SCHEMA_VERSION) FROM " + schema + ".SCHEMA_VERSION S WHERE S.ID_SCHEMA_VERSION < " + upperLimit;
      gsqlStr += " and S.ID_SCHEMA_VERSION > " + LOOK_BACK_FROM;
      gsqlStr += " and S.ID_SCHEMA_VERSION > " + lowerLimit;
      gsqlStr += " and not exists (select s2.ID_SCHEMA_VERSION from " + schema + ".schema_version s2 where s2.ID_SCHEMA_VERSION=(s.id_schema_version+1))";
      stmt = connection.prepareStatement(gsqlStr);
      rs = stmt.executeQuery();
      if (!rs.next()) {
        return NO_SCHEMA;
      }
      int res = rs.getInt(1);
      if (res == 0) {
        res = NO_SCHEMA;
      }
      return res;
    } catch (SQLException e) {
      throw new BuildException("Error checking schema version.", e);
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          // Ignore this.
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          //noinspection ThrowFromFinallyBlock
          throw new BuildException("Failed to close connection.", e);
        }
      }
    }
  }

  private static class SQLStatement {
    private String sql;
    private boolean commit;

    public SQLStatement(String sql, boolean commit) {
      this.sql = sql;
      this.commit = commit;
    }

    public String getSql() {
      return sql;
    }

    public boolean isCommit() {
      return commit;
    }
  }
}
