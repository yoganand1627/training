package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.config.GrndsConfigurationEnvironment;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsBasicHttpConversation;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsHttpServlet;
import org.w3c.dom.Element;

public class ScreenMapping implements Serializable {
  private static final String FILE_PREFIX = "/WEB-INF/";
  private static final String FILE_SUFFIX = "ScreenDefinitions.xml";
  private static final String TRACE_TAG = "ScreenMapping";
  protected static final Map<String, Map<String, Screen>> screenMap = new HashMap<String, Map<String, Screen>>();
  protected static final Map<String, String> templatesMap = new HashMap<String, String>();

  public static Screen getScreenData(GrndsExchangeContext context) throws ServletException {
    HttpServletRequest request = context.getRequest();
    initialize(context);
    Screen screen = (Screen) request.getAttribute(ScreenDefinitionsXmlDao.SCREEN);
    if (screen != null) {
      return screen;
    }
    String screenName = determineWhichScreen(context);
    screen = getScreenData(context, screenName);
    if (screen == null) {
      String servletConversationName = context.getConversationName();
      String commandName = context.getCommandName();
      String commandBranch = (String) request.getAttribute(GrndsBasicHttpConversation.COMMAND_BRANCH_ATTRIBUTE);
      String commandPath = "/" + servletConversationName + "/" + commandName +
                           (StringHelper.isValid(commandBranch) ? "." + commandBranch : "");
      String errorString = "Screen: " + screenName + " not defined in map for command '" + commandPath +
                           "'  Check xconf and screen defs files";
      throw new ServletException(errorString);
    }
    // Clone the screen object to avoid race conditions where a jsp invoked twice
    //   at the same time won't change values on each other.
    try {
      screen = (Screen) screen.clone();
    } catch (CloneNotSupportedException e) {
      // Pass the exception back through the invocation chain.
      throw new ServletException("Failed to forward to screen: " + screenName, e);
    }
    request.setAttribute(ScreenDefinitionsXmlDao.SCREEN, screen);
    return screen;
  }

  public static String getTemplate(GrndsExchangeContext context) {
    return templatesMap.get(context.getServletMapping());
  }

  /** Method to match a screen name with a particular servlet mapping, conversation, command, and branch. */
  protected static String determineWhichScreen(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".determineWhichScreen()");
    HttpServletRequest request = context.getRequest();
    String mapping = context.getServletMapping();
    String conversation = context.getConversationName();
    String command = context.getCommandName();
    String branch = (String) request.getAttribute(GrndsBasicHttpConversation.COMMAND_BRANCH_ATTRIBUTE);

    if (branch == null) {
      branch = "";
    }
    GrndsTrace.msg(TRACE_TAG, 9, "Mapping: " + mapping + "; Conversation: " + conversation + "; Command: " + command +
                                 "; Branch: " + branch);
    String screenName = BasePrsHttpServlet.getScreenName(mapping, conversation, command, branch);
    GrndsTrace.exitScope(screenName);
    return screenName;
  }

  /**
   * From the map of screen definition maps, return a Screen instance which corresponds to the current request and
   * screen name.
   *
   * @param context the current GrndsExchangeContext
   * @param name    the name of the screen
   * @return the corresponding Screen instance
   */
  protected static Screen getScreenData(GrndsExchangeContext context, String name) {
    GrndsTrace.enterScope(TRACE_TAG + ".getScreenData()");
    GrndsTrace.msg(TRACE_TAG, 7, "Getting screen for mapping: " + context.getServletMapping());
    Map<String, Screen> screensForThisServlet = screenMap.get(context.getServletMapping());
    if (screensForThisServlet != null) {
      return screensForThisServlet.get(name);
    }
    GrndsTrace.exitScope();
    return null;
  }

  /**
   * Initialize the framework by reading in all the screen definitions listed in the properties file.
   *
   * @param context the current grnds exchange context
   * @throws ServletException if an exception occurs while reading or parsing the screen definitions files
   */
  protected static void initialize(GrndsExchangeContext context) throws ServletException {
    try {
      if (screenMap.get(context.getServletMapping()) != null) {
        return;
      }
      GrndsTrace.enterScope(TRACE_TAG + ".initialize()");
      String screenDefinitionsPrefix = "ScreenDefinitions";
      GrndsConfigurationEnvironment config =
              GrndsConfiguration.getInstance().getEnvironment(ArchitectureConstants.GRNDS_DOMAIN);
      for (int i = 1; ; i++) {
        // Look up the screen definition files in order for initialization.  If we don't find one for a specific
        //  value of "i", we must have parsed all the files in the list.
        GrndsTrace.msg(TRACE_TAG, 5, "Loading " + screenDefinitionsPrefix + i);
        String screenDefinitionsPath = config.getProperty(screenDefinitionsPrefix + i);
        if (screenDefinitionsPath == null) {
          break;
        }
        GrndsTrace.msg(TRACE_TAG, 5, "ScreenDefinitionsPath: " + screenDefinitionsPath);
        // load screen definitions for the current file
        loadScreenDefinitions(context, screenDefinitionsPath);
      }
      GrndsTrace.exitScope();
    } catch (DecoratorException e) {
      throw new ServletException("Exception occured parsing screen definitions.", e);
    }
  }

  /**
   * This method makes use of the ScreenDefinitionsXmlDao to parse the xml file found at the given path and save the
   * data in a class variable. This method will be executed once for every screen definitions file listed in
   * architecture.properties.
   *
   * @param context the context for the current request
   * @param path    path of the screen definitions file to be read
   * @throws DecoratorException if an exception occurs while reading or parsing the screen definitions file
   */
  protected static void loadScreenDefinitions(GrndsExchangeContext context, String path) throws DecoratorException {
    GrndsTrace.enterScope(TRACE_TAG + ".loadScreenDefinitions()");
    try {
      Element element = ScreenDefinitionsXmlDao.loadDocument(context, path);
      Map<String, Screen> screensMap = ScreenDefinitionsXmlDao.getScreens(element);
      GrndsTrace.msg(TRACE_TAG, 7, "Putting into screenMap for key: " + getMappingFromPath(path));
      screenMap.put(getMappingFromPath(path), screensMap);
      GrndsTrace.msg(TRACE_TAG, 7, "Screen Map for: " + getMappingFromPath(path) + "=" + screensMap);
      Screen screen = screensMap.get(ScreenDefinitionsXmlDao.TEMPLATE_DEFAULT);
      String template = screen != null ? screen.getTemplate() : null;
      templatesMap.put(getMappingFromPath(path), template);
      GrndsTrace.msg(TRACE_TAG, 7, "Template for: " + getMappingFromPath(path) + "=" + template);
    } catch (FileNotFoundException e) {
      // just log the fact that no screen defs file found
      GrndsTrace.msg(TRACE_TAG, 7, "No screen defs file found at: " + path + " Exception: " + e);
    }
    GrndsTrace.exitScope();
  }

  protected static String getMappingFromPath(String path) {
    // extract the mapping from the screen definitions file's path
    return path.substring(FILE_PREFIX.length(), path.indexOf(FILE_SUFFIX));
  }
}
