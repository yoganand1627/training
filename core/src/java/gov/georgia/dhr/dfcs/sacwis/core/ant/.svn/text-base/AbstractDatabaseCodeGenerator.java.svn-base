package gov.georgia.dhr.dfcs.sacwis.core.ant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

/** User: mkw Date: Apr 7, 2003 Time: 9:37:27 AM */
@SuppressWarnings({"UseOfSystemOutOrSystemErr", "CallToPrintStackTrace"})
public abstract class AbstractDatabaseCodeGenerator {
  protected static final Date TODAY = new Date();

  private String propertiesFileName = null;
  private String srcDir = null;
  private String simpleClassName = null;
  private String packageName = null;
  private String packageDir = null;

  /**
   * Implementing classes need to implement the generate method, which uses the properties in this superclass to get a
   * db connection and open a file.
   */
  abstract void generate();

  protected String getSrcDir() {
    return srcDir;
  }

  protected String getPacakageDir() {
    return packageDir;
  }

  protected String getPackageName() {
    return packageName;
  }

  protected String getSimpleClassname() {
    return simpleClassName;
  }

  protected String getPropertiesFileName() {
    return propertiesFileName;
  }

  @SuppressWarnings({"AssignmentToForLoopParameter"})
  void parseArgs(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if ("-srcDir".equals(args[i]) && i <= args.length) {
        this.srcDir = args[++i];
      }
      if ("-properties".equals(args[i]) && i <= args.length) {
        this.propertiesFileName = args[++i];
      }
      if ("-java".equals(args[i]) && i <= args.length) {
        // Convert the java name into a class name by replacing forward and back slashes with dots.
        String classname = args[++i].replace('/', '.').replace('\\', '.');
        // Strip .java
        classname = classname.substring(0, classname.lastIndexOf('.'));
        int lastDotIndex = classname.lastIndexOf(".");
        this.simpleClassName = classname.substring(lastDotIndex + 1);
        this.packageName = classname.substring(0, lastDotIndex);
        this.packageDir = packageName.replace('.', File.separatorChar);
      }
    }
  }

  protected String getPath() {
    return getSrcDir() != null ? getSrcDir() + File.separator + getPacakageDir() : getPacakageDir();
  }

  @SuppressWarnings({"IOResourceOpenedButNotSafelyClosed"})
  protected PrintWriter getWriter(String className) throws IOException {
    File f = new File(getPath(), className + ".java");
    FileWriter fw = new FileWriter(f);
    return new PrintWriter(fw);
  }

  protected Connection getConnection() {
    Connection connection = null;
    String propertiesFileName = getPropertiesFileName();
    Properties props = new Properties();
    InputStream is;
    try {
      is = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
      if (is == null) {
        //noinspection IOResourceOpenedButNotSafelyClosed
        is = new FileInputStream(propertiesFileName);
      }
      props.load(is);
    }
    catch (Exception e) // we get an NPE if "is == null" so catch any exception
    {
      System.err.println("Could not open properties file: " + propertiesFileName);
    }

    String driver = props.getProperty("jdbc.driverClassName");
    try {
      Class.forName(driver);
    }
    catch (ClassNotFoundException e) {
      System.err.println("Could not find database driver with name: " + driver);
    }
    catch (Exception e) {
      System.err.println("Could not register database driver with name: " + driver);
    }

    String url = props.getProperty("jdbc.url");
    try {
      //noinspection CallToDriverManagerGetConnection
      connection = DriverManager.getConnection(url, props.getProperty("jdbc.username"),
                                               props.getProperty("jdbc.password"));
    } catch (SQLException e) {
      System.out.println("Failed to get connection to: " + url);
    }
    if (connection == null) {
      System.out.println("Database connection not available.");
    }
    return connection;
  }
}
