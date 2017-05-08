package gov.georgia.dhr.dfcs.sacwis.web.core.audit;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Destroyable;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.Initializable;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.config.GrndsConfigurationEnvironment;
import org.grnds.facility.log.GrndsTrace;

/** User: mkw Date: Jun 19, 2003 Time: 2:35:16 PM */
public class AuditInit implements Initializable, Destroyable, Serializable {

  private static final String TRACE_TAG = "AuditInit";

  public static final String TRACING_SESSION_ATTRIBUTE = "AUDIT_TRACE";

  private static final String GRNDS_WEB_APP_PARSER_NAME = "/WEB-INF/grnds-web-app.parser.xsl";
  private static final String WEB_XML_NAME = "/WEB-INF/web.xml";

  private static final String AUDIT_FILTER_PREFIX = "audit.filter";

  private static final GrndsConfigurationEnvironment SACWIS_GRNDS_ENVIRONMENT =
          GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
  public static final int BATCH_SIZE = Integer.parseInt(SACWIS_GRNDS_ENVIRONMENT.getProperty("audit.batchsize"));

  // A stringpool
  private static final Map<String, String> stringPool = new HashMap<String, String>();
  // map betwen URI's and their ID's in the database
  private static final Map<URICommand, Integer> uriToIdMap = new HashMap<URICommand, Integer>();
  private static final Map<Integer, URICommand> idToURIMap = new HashMap<Integer, URICommand>();

  public static int getURICommandId(URICommand uriCommand) {
    Integer id = uriToIdMap.get(uriCommand);
    if (id == null) {
      return URICommand.UNKNOWN_URI.getId();
    } else {
      return id;
    }
  }

  public static URICommand getURICommand(URICommand uriCommand) {
    Integer id = uriToIdMap.get(uriCommand);
    if (id == null) {
      return URICommand.UNKNOWN_URI;
    } else {
      return idToURIMap.get(id);
    }
  }

  public static URICommand getURICommand(int id) {
    URICommand uriCommand = idToURIMap.get(id);
    if (uriCommand == null) {
      return URICommand.UNKNOWN_URI;
    } else {
      return uriCommand;
    }
  }

  /**
   * This method flushes the audit log on shutdown.
   *
   * @param config
   * @throws BasePrsException
   */
  @SuppressWarnings({"AssignmentToStaticFieldFromInstanceMethod", "AssignmentToNull"})
  public void destroy(ServletContext config) throws BasePrsException {
    AuditLogger.flush();
    stringPool.clear();
    idToURIMap.clear();
    uriToIdMap.clear();
  }

  public void initialize(ServletContext servletContext) throws BasePrsException {
    parseXConfFiles(servletContext);
    initializeAuditFilters(servletContext);
  }

  private void initializeAuditFilters(ServletContext servletContext) throws InformationalPrsException {
    List<AuditFilter> auditFilters = new LinkedList<AuditFilter>();
    for (int i = 1; ; i++) {
      String className = null;
      try {
        //look up the class names in order for initialization.  If we don't find one for
        //a specific value of "i", we must have initialized all of the classes in the list.
        GrndsTrace.msg(TRACE_TAG, 5, "Class#: " + i);
        className = SACWIS_GRNDS_ENVIRONMENT.getProperty(AUDIT_FILTER_PREFIX + i);
        if (className == null) {
          break;
        }
        GrndsTrace.msg(TRACE_TAG, 7, "ClassName: " + className);
        Class auditFilterClass = Class.forName(className);
        auditFilters.add((AuditFilter) auditFilterClass.newInstance());
      } catch (Exception e) {
        String message = "Failed to initialize audit filter: " + (className != null ? className : "unknown");
        servletContext.log(message, e);
        // This is a blatent misuse of this class, but it really doesn't matter,
        //   as this should only ever be thrown during development.
        throw new InformationalPrsException(message, e, BasePrsException.CRITICAL_PRIORITY);
      }
    }
    if (auditFilters.size() > 0) {
      AuditLogger.setFilterChain(Collections.unmodifiableList(auditFilters));
    }
  }

  private static void parseXConfFiles(ServletContext servletContext) {
    // Parse the xconf files to get a full list of commands.
    Transformer transformer = getTransformer(servletContext.getResourceAsStream(GRNDS_WEB_APP_PARSER_NAME));
    List grndsWebAppXConfNameList =
            getGrndsWebAppXConfNameList(transformer, servletContext.getResourceAsStream(WEB_XML_NAME));
    SortedSet<URICommand> xconfURISet = getXConfURISet(grndsWebAppXConfNameList, servletContext, transformer);
    // add the unknown URI command
    xconfURISet.add(URICommand.UNKNOWN_URI);
    SortedSet dbURISet = getDBURISet();
    updateDB(xconfURISet, dbURISet);
    // get the full URI set from the DB so we have the ID values for all of them
    SortedSet fullURISet = getDBURISet();
    Map<URICommand, Integer> uriToIdMap = new HashMap<URICommand, Integer>();
    Map<Integer, URICommand> idToURIMap = new HashMap<Integer, URICommand>();
    for (Iterator fullURISetIterator = fullURISet.iterator(); fullURISetIterator.hasNext();) {
      URICommand uriCommand = (URICommand) fullURISetIterator.next();
      Integer id = uriCommand.getId();
      uriToIdMap.put(uriCommand, id);
      idToURIMap.put(id, uriCommand);
    }
    // update the cached references
    AuditInit.uriToIdMap.putAll(uriToIdMap);
    AuditInit.idToURIMap.putAll(idToURIMap);
  }

  private static void updateDB(SortedSet xconfURISet, SortedSet dbURISet) {
    SortedSet<URICommand> updateSet = new TreeSet<URICommand>();
    for (Iterator xconfURIIterator = xconfURISet.iterator(); xconfURIIterator.hasNext();) {
      URICommand uriCommand = (URICommand) xconfURIIterator.next();
      if (!dbURISet.contains(uriCommand)) {
        updateSet.add(uriCommand);
      }
    }
    Connection connection = null;
    PreparedStatement newCommandsStatement = null;
    PreparedStatement defaultBranchStatement = null;
    try {
      connection = JdbcHelper.getConnection();
      if (updateSet.size() > 0) {
        String sql = "INSERT INTO " +
                     "SACWIS_COMMAND ( NM_SERVLET, NM_CONVERSATION, NM_COMMAND, NM_BRANCH ) " +
                     "VALUES ( ?, ?, ?, ? )";
        newCommandsStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
                                                           ResultSet.CONCUR_READ_ONLY);
        for (Iterator updateSetIterator = updateSet.iterator(); updateSetIterator.hasNext();) {
          URICommand uriCommand = (URICommand) updateSetIterator.next();
          newCommandsStatement.setString(1, uriCommand.getServlet());
          newCommandsStatement.setString(2, uriCommand.getConversation());
          newCommandsStatement.setString(3, uriCommand.getCommand());
          newCommandsStatement.setString(4, uriCommand.getBranch());
          newCommandsStatement.addBatch();
        }
        newCommandsStatement.executeBatch();
        connection.commit();
      }
      defaultBranchStatement =
              connection.prepareStatement("INSERT INTO SACWIS_COMMAND \n" +
                                          "( NM_SERVLET, NM_CONVERSATION, NM_COMMAND, NM_BRANCH ) \n" +
                                          "SELECT ALL_COMMANDS.NM_SERVLET, \n" +
                                          "       ALL_COMMANDS.NM_CONVERSATION, \n" +
                                          "       ALL_COMMANDS.NM_COMMAND, \n" +
                                          "       'default' AS NM_BRANCH \n" +
                                          "FROM \n" +
                                          "  ( SELECT NM_SERVLET, NM_CONVERSATION, NM_COMMAND \n" +
                                          "    FROM SACWIS_COMMAND \n" +
                                          "    GROUP BY NM_SERVLET, NM_CONVERSATION, NM_COMMAND ) ALL_COMMANDS, \n" +
                                          "  ( SELECT NM_SERVLET, NM_CONVERSATION, NM_COMMAND \n" +
                                          "    FROM SACWIS_COMMAND \n" +
                                          "    WHERE NM_BRANCH = 'default' \n" +
                                          "    GROUP BY NM_SERVLET, NM_CONVERSATION, NM_COMMAND ) DEFAULT_COMMANDS \n" +
                                          "WHERE ALL_COMMANDS.NM_SERVLET = DEFAULT_COMMANDS.NM_SERVLET (+) \n" +
                                          "  AND ALL_COMMANDS.NM_CONVERSATION = DEFAULT_COMMANDS.NM_CONVERSATION (+) \n" +
                                          "  AND ALL_COMMANDS.NM_COMMAND = DEFAULT_COMMANDS.NM_COMMAND(+) \n" +
                                          "  AND ( DEFAULT_COMMANDS.NM_SERVLET IS NULL \n" +
                                          "        OR DEFAULT_COMMANDS.NM_CONVERSATION IS NULL \n" +
                                          "        OR DEFAULT_COMMANDS.NM_COMMAND IS NULL )");
      defaultBranchStatement.executeUpdate();
      connection.commit();
    } catch (Exception e) {
      throw new RuntimeException("Failed to load commands from performance table.", e);
    } finally {
      try {
        if (defaultBranchStatement != null) {
          defaultBranchStatement.close();
        }
      } catch (SQLException sqle) {
        // Ignore this.
      }
      try {
        if (newCommandsStatement != null) {
          newCommandsStatement.close();
        }
      } catch (SQLException sqle) {
        // Ignore this.
      }
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException sqle) {
        // Ignore this.
      }
    }
  }

  private static SortedSet getDBURISet() {
    GrndsTrace.enterScope(TRACE_TAG + ".buildCodeTrees");

    SortedSet<URICommand> dbURISet = new TreeSet<URICommand>();

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet results = null;
    try {
      connection = JdbcHelper.getConnection();
      String sql = "SELECT ID_COMMAND, NM_SERVLET, NM_CONVERSATION, NM_COMMAND, NM_BRANCH FROM SACWIS_COMMAND";
      statement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      //ASC 04/18/2005 - for Oracle 10g driver.
      statement.setFetchSize(500);
      results = statement.executeQuery();
      // Set te prefetch because we expect a lot of data
      results.setFetchSize(500);

      while (results.next()) {
        int id = results.getInt("ID_COMMAND");
        String servlet = produceString(results.getString("NM_SERVLET"));
        String conversation = produceString(results.getString("NM_CONVERSATION"));
        String command = produceString(results.getString("NM_COMMAND"));
        String branch = produceString(results.getString("NM_BRANCH"));
        dbURISet.add(new URICommand(id, servlet, conversation, command, branch));
      }
    } catch (Exception e) {
      throw new RuntimeException("Failed to load commands from performance table.", e);
    } finally {
      try {
        if (results != null) {
          results.close();
        }
        if (statement != null) {
          statement.close();
        }
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException sqle) {
        // Ignore this.
      }
    }
    return dbURISet;
  }

  private static SortedSet<URICommand> getXConfURISet(List grndsWebAppXConfNameList, ServletContext servletContext,
                                                      Transformer transformer) {
    SortedSet<URICommand> uriSet = new TreeSet<URICommand>();
    for (Iterator xconfNameIterator = grndsWebAppXConfNameList.iterator(); xconfNameIterator.hasNext();) {
      String xconfName = (String) xconfNameIterator.next();
      InputStream xconf = servletContext.getResourceAsStream(xconfName);
      if (xconf == null) {
        throw new RuntimeWrappedException(new FileNotFoundException("Cannot find: " + xconfName));
      }
      StreamSource xconfStreamSource = new StreamSource(xconf);
      ByteArrayOutputStream xconfOutputStream = new ByteArrayOutputStream();
      StreamResult xconfStreamResult = new StreamResult(xconfOutputStream);
      try {
        transformer.transform(xconfStreamSource, xconfStreamResult);
      } catch (TransformerException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure executing transform on '" + xconfName + "':" + e.getMessage());
        throw new RuntimeWrappedException(e);
      }
      StringTokenizer st = new StringTokenizer(xconfStreamResult.getOutputStream().toString());
      while (st.hasMoreTokens()) {
        String uri = st.nextToken().trim();
        URICommand uriCommand = URICommand.parseURI(uri);
        if (uriCommand != null) {
          // add the resulting uri command to the set
          uriSet.add(uriCommand);
        }
      }
    }
    return uriSet;
  }

  private static List getGrndsWebAppXConfNameList(Transformer transformer, InputStream webXml) {
    if (webXml == null) {
      throw new RuntimeWrappedException(new FileNotFoundException("Cannot find: " + WEB_XML_NAME));
    }
    StreamSource webStreamSource = new StreamSource(webXml);
    ByteArrayOutputStream webOutputStream = new ByteArrayOutputStream();
    StreamResult webStreamResult = new StreamResult(webOutputStream);

    try {
      transformer.transform(webStreamSource, webStreamResult);
    } catch (TransformerException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure executing transform on '" + WEB_XML_NAME + "':" + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    List<String> grndsWebAppXConfNameList = new LinkedList<String>();
    StringTokenizer st = new StringTokenizer(webStreamResult.getOutputStream().toString(), ",", false);
    while (st.hasMoreTokens()) {
      String tok = st.nextToken().trim();
      if (tok.length() > 0) {
        grndsWebAppXConfNameList.add(tok);
      }
    }
    return grndsWebAppXConfNameList;
  }

  private static Transformer getTransformer(InputStream grndsWebAppParserXsl) {
    if (grndsWebAppParserXsl == null) {
      throw new RuntimeWrappedException(new FileNotFoundException("Cannot find: " + GRNDS_WEB_APP_PARSER_NAME));
    }
    StreamSource grndsWebAppParserStreamSource = new StreamSource(grndsWebAppParserXsl);

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer;
    try {
      transformer = transformerFactory.newTemplates(grndsWebAppParserStreamSource).newTransformer();
    } catch (TransformerConfigurationException e) {
      GrndsTrace.msg(TRACE_TAG, 7,
                     "Failure creating transformer '" + GRNDS_WEB_APP_PARSER_NAME + "':" + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    return transformer;
  }

  /**
   * This is a very primitive string factory method used to prevent storage of huge numbers of the same String objects.
   *
   * @param in The String object to be run through the factory method
   * @return The unique String object
   */
  private static String produceString(String in) {
    String out = stringPool.get(in);
    if (out == null) {
      out = in;
      stringPool.put(out, out);
    }
    return out;
  }
}
