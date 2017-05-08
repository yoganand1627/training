package gov.georgia.dhr.dfcs.sacwis.web.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.facility.xml.GrndsXmlException;
import org.grnds.facility.xml.GrndsXmlReader;
import org.grnds.structural.web.GrndsExchangeContext;
import org.grnds.structural.web.config.GrndsCommandInfo;
import org.grnds.structural.web.config.GrndsConversationInfo;
import org.grnds.structural.web.config.GrndsServletInfo;
import org.grnds.structural.web.config.GrndsWebAppInfo;
import org.grnds.structural.web.config.GrndsWebAppXmlDialect;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SJSASContextSingletonBeanFactoryLocator;
import gov.georgia.dhr.dfcs.sacwis.core.spring.SpringConstants;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.web.common.LoginConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Parameter;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenDefinitionsXmlDao;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.SettableUserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserRight;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * This class is used for testing GRNDS commands.<p/>Jan 2, 2003 Time: 10:41:19 AM
 *
 * @author Michael K. Werle
 */
public class TestConversation extends BaseHiddenFieldStateConversation {
  public static final String DISPLAY_URI = "/test/Test/displayTestData";

  public static final String SUBMODULE_URI_KEY = "TEST_CONVERSATION_SUBMODULE_URI_KEY";
  public static final String PARAMETERS_KEY = "TEST_CONVERSATION_PARAMETERS_KEY";
  public static final String ATTRIBUTES_KEY = "TEST_CONVERSATION_ATTRIBUTES_KEY";
  public static final String SEC_ACTION_NO_CHANGE = "SEC_ACTION_NO_CHANGE";
  public static final String SEC_ACTION_EXACT = "SEC_ACTION_EXACT";
  public static final String SEC_ACTION_INCLUSIVE = "SEC_ACTION_INCLUSIVE";
  public static final String SEC_ACTION_EXCLUSIVE = "SEC_ACTION_EXCLUSIVE";
  public static final String SEC_ATTR_KEY = "SEC_ATTRIBUTES_REQUESTED_KEY";

  public static final String GRNDS_WEB_APP_XCONF_FILE_NAME = "grnds-web-app.xconf";

  private static final String TRACE_TAG = "TestConversation";

  private Admin admin;

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  public void validateXConf_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayTestData_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".displayTestData_xa()");

    HttpServletRequest request = context.getRequest();

    // Read the grnds-web-app.xconf file and parse servlets, conversations, and commands
    GrndsWebAppInfo grndsWebAppInfo = parseXConfFile(context);

    if (grndsWebAppInfo != null) {
      GrndsServletInfo[] grndsServletInfoArray = grndsWebAppInfo.getServlets();
      for (int i = 0; i < grndsServletInfoArray.length; i++) {
        GrndsServletInfo grndsServletInfo = grndsServletInfoArray[i];
        validateServlet(context, grndsServletInfo);

      }
    }

    // Only forward if we do not have an error
    if (getPresentationBranch(context) == null) {
      try {
        forward(DISPLAY_URI, request, context.getResponse());
      }
      catch (ServletException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
        processSevereException(context, e);
      }
    }

    GrndsTrace.exitScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void populateUserSecurity_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateUserSecurity_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".populateUserSecurity_xa()");

    HttpServletRequest request = context.getRequest();

    // This is only relevant for server impact.
    //noinspection ConstantConditions
    if (PlatformConstants.SERVER_IMPACT) {
      // update employee table with userid
      int claimedUserId = ContextHelper.getIntSafe(request, UserProfileHelper.CLAIM_USER_ID_KEY);
      String username = ContextHelper.getStringSafe(request, UserProfileHelper.LOGIN_NAME_KEY).toUpperCase().trim();
      if (claimedUserId != 0 && username.length() > 0) {
        if (!claimUserId(context, username, claimedUserId)) {
          setPresentationBranch("error", context);
        }
      }
    }

    // Process the login
    processLogin(context);

    UserProfile profile = UserProfileHelper.getUserProfile(request);
    if (profile != null) {
      Iterator rightItr = TestHelper.getUserRightSet().iterator();
      while (rightItr.hasNext()) {
        UserRight right = (UserRight) rightItr.next();
        boolean hasRight = profile.hasRight(right.getRightIndex());
        GrndsTrace.msg(TRACE_TAG, 8,
                       "User does " + (hasRight ? "" : "NOT ") + "have right " + right.getRightName() + ".");
      }
      request.setAttribute(SEC_ATTR_KEY, profile);
    }
    forwardToDisplay(context);

    GrndsTrace.exitScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private boolean claimUserId(GrndsExchangeContext context, String username, int claimedUserId) {
    boolean result;
    try {
      // Use reflection to allow this to be imported to MPS.
      Class loginConversationClass = Class.forName("gov.georgia.dhr.dfcs.sacwis.web.common.LoginConversation");
      Method updateEmployeeTableMethod
              = loginConversationClass.getMethod("updateEmployeeTable",
                                                 context.getClass(),
                                                 String.class, Integer.TYPE);
      Object[] params = new Object[] {context, username, claimedUserId};
      Boolean boolResult = (Boolean) updateEmployeeTableMethod.invoke(null, params);
      result = boolResult != null && boolResult;
    }
    catch (NoSuchMethodException e) {
      setPresentationBranch("error", context);
      result = false;
    }
    catch (ClassNotFoundException e) {
      setPresentationBranch("error", context);
      result = false;
    }
    catch (IllegalAccessException e) {
      setPresentationBranch("error", context);
      result = false;
    }
    catch (InvocationTargetException e) {
      setPresentationBranch("error", context);
      result = false;
    }
    return result;
  }

  private void validateServlet(GrndsExchangeContext context, GrndsServletInfo grndsServletInfo) {
    String servletName = grndsServletInfo.getMapping();
    // get screen stuff here; do not validate screens below if we can't get screen defs here
    Map screenMap = getScreenMap(servletName, context);

    GrndsConversationInfo[] grndsConversationInfoArray = grndsServletInfo.getConversations();
    for (int j = 0; j < grndsConversationInfoArray.length; j++) {
      GrndsConversationInfo grndsConversationInfo = grndsConversationInfoArray[j];
      validateConversation(context, grndsConversationInfo, screenMap, servletName);
      continue;
    }
  }

  private void validateConversation(GrndsExchangeContext context, GrndsConversationInfo grndsConversationInfo,
                                    Map screenMap, String servletName) {
    HttpServletRequest request = context.getRequest();
    String conversationName = grndsConversationInfo.getName();
    String conversationClassName = grndsConversationInfo.getClassname();
    Class conversationClass;
    try {
      conversationClass = getClass().getClassLoader().loadClass(conversationClassName);
    }
    catch (ClassNotFoundException e) {
      setErrorMessage(
              "Could not find class '" + conversationClassName + "' for conversation '/" + servletName + "/"
              + conversationName
              + "'",
              DISPLAY_URI, request);
      setPresentationBranch("error", context);
      return;
    }
    GrndsCommandInfo[] grndsCommandInfoArray = grndsConversationInfo.getCommands();
    for (int k = 0; k < grndsCommandInfoArray.length; k++) {
      GrndsCommandInfo grndsCommandInfo = grndsCommandInfoArray[k];
      validateCommand(context, screenMap, grndsCommandInfo, conversationClass, servletName, conversationName);
      continue;
    }
  }

  private void validateCommand(GrndsExchangeContext context, Map screenMap, GrndsCommandInfo grndsCommandInfo,
                               Class conversationClass, String servletName, String conversationName) {
    String conversationClassName = conversationClass.getName();
    HttpServletRequest request = context.getRequest();
    String commandName = grndsCommandInfo.getName();
    int activityType = grndsCommandInfo.getActivityType();
    if (activityType == GrndsCommandInfo.A_METHOD_TYPE) {
      String activityMethodName = grndsCommandInfo.getActivityValue();
      Method[] conversationMethodArray = conversationClass.getMethods();
      Map<String, Method> conversationMethodMap = new HashMap<String, Method>();
      Method conversationMethod;
      for (int l = 0; l < conversationMethodArray.length; l++) {
        conversationMethod = conversationMethodArray[l];
        conversationMethodMap.put(conversationMethod.getName(), conversationMethod);
      }
      if (!conversationMethodMap.containsKey(activityMethodName)) {
        setErrorMessage(
                "Command '/" + servletName + "/" + conversationName + "/" + commandName + "' requests method '"
                + activityMethodName
                + "' of class '"
                + conversationClassName
                + "' that cannot be found.",
                DISPLAY_URI, request);
        setPresentationBranch("error", context);
        return;
      }
      conversationMethod = conversationMethodMap.get(activityMethodName);
      Class[] conversationMethodParameterTypes = conversationMethod.getParameterTypes();
      if (conversationMethodParameterTypes.length != 1
          || !conversationMethodParameterTypes[0].equals(GrndsExchangeContext.class)) {
        setErrorMessage(
                "Method '" + activityMethodName + "' exists in class '" + conversationClassName
                + "' but does not have an overloaded version that accepts a single GrndsExchangeContext object.",
                DISPLAY_URI, request);
        setPresentationBranch("error", context);
        return;
      }

      Enumeration branchEnum = grndsCommandInfo.getPresentationBranches();
      while (branchEnum.hasMoreElements()) {
        String branchName = (String) branchEnum.nextElement();
        validateBranch(context, grndsCommandInfo, screenMap, servletName, conversationName, branchName);
        continue;
      }
    }
  }

  private void validateBranch(GrndsExchangeContext context, GrndsCommandInfo grndsCommandInfo, Map screenMap,
                              String servletName, String conversationName, String branchName) {
    String commandName = grndsCommandInfo.getName();
    HttpServletRequest request = context.getRequest();
    int branchType = grndsCommandInfo.getPresentationType(branchName);
    if (branchType == GrndsCommandInfo.P_CLASS_TYPE) {
      String presentationScreenName = grndsCommandInfo.getPresentationScreenValue(branchName);
      if (presentationScreenName == null) {
        setErrorMessage(
                "The screen name for default branch of command '/" + servletName + "/" + conversationName + "/"
                + commandName
                + "' is null (missing).",
                DISPLAY_URI, request);
        return;
      }
      Screen screen = (Screen) screenMap.get(presentationScreenName);
      if (screen == null) {
        if ("".equals(branchName)) {
          setErrorMessage(
                  "Screen was null for the default branch of command '/" + servletName + "/" + conversationName
                  + "/"
                  + commandName
                  + "'",
                  DISPLAY_URI, request);
        } else {
          setErrorMessage(
                  "Screen was null for branch '" + branchName + "' of command '/" + servletName + "/"
                  + conversationName
                  + "/"
                  + commandName
                  + "'",
                  DISPLAY_URI, request);
        }
        setPresentationBranch("error", context);
      } else {
        Parameter htmlBody = screen.getParameter("HtmlBody");
        String htmlBodyValue = htmlBody.getValue();
        String htmlBodyPath = context.getServletContext().getRealPath(htmlBodyValue);
        File f = new File(htmlBodyPath);
        if (!f.exists()) {
          if ("".equals(branchName)) {
            setErrorMessage(
                    "Screen '" + presentationScreenName + "' of the default branch of command '/" + servletName + "/"
                    + conversationName
                    + "/"
                    + commandName
                    + "' referrs to file '"
                    + htmlBodyValue
                    + "' that cannot be found.",
                    DISPLAY_URI, request);
          } else {
            setErrorMessage(
                    "Screen '" + presentationScreenName + "' for branch '" + branchName + "' of command '/"
                    + servletName
                    + "/"
                    + conversationName
                    + "/"
                    + commandName
                    + "' referrs to file '"
                    + htmlBodyValue
                    + "' that cannot be found.",
                    DISPLAY_URI, request);
          }
          setPresentationBranch("error", context);
        }
      }
      return;
    }
  }

  private Map getScreenMap(String servletName, GrndsExchangeContext context) {
    Map screenMap = null;
    HttpServletRequest request = context.getRequest();
    String screenDefFileName = "/WEB-INF/" + servletName + "ScreenDefinitions.xml";
    try {
      screenMap = ScreenDefinitionsXmlDao.loadScreenDefinitions(context, screenDefFileName);
    }
    catch (Exception e) {
      setErrorMessage(
              "Could not load screen definitions from file '" + screenDefFileName + "': " + e.getMessage()
              + "<br><i>Screen definitions for servlet '"
              + servletName
              + "' were not validated.</i>",
              DISPLAY_URI, request);
      setPresentationBranch("error", context);
    }
    // This is here so that, if the first screen definition file is missing, we don't get a NullPointerException
    screenMap = screenMap == null ? new HashMap() : screenMap;

    return screenMap;
  }

  private GrndsWebAppInfo parseXConfFile(GrndsExchangeContext context) {
    GrndsWebAppInfo grndsWebAppInfo = null;
    HttpServletRequest request = context.getRequest();

    InputStream xconfInputStream = null;
    GrndsXmlReader grndsXmlReader = null;
    try {
      String grndsWebAppXConfFileName = context.getServletContext().getRealPath("/") + File.separator + "WEB-INF"
                                        + File.separator
                                        + GRNDS_WEB_APP_XCONF_FILE_NAME;
      File grndsWebAppXConfFile = new File(grndsWebAppXConfFileName);
      if (grndsWebAppXConfFile.exists()) {
        xconfInputStream = new FileInputStream(grndsWebAppXConfFile);
        setErrorMessage("Using xconf file at: '" + grndsWebAppXConfFileName.replace('\\', '/') + "'", DISPLAY_URI,
                        request);
      } else {
        URL xconfURL = getClass().getClassLoader().getResource(GRNDS_WEB_APP_XCONF_FILE_NAME);
        xconfInputStream = xconfURL.openStream();
        setErrorMessage("Using xconf file at: '" + xconfURL.toExternalForm().replace('\\', '/') + "'", DISPLAY_URI,
                        request);
      }

      if (xconfInputStream != null) {
        grndsXmlReader = new GrndsXmlReader(new InputStreamReader(xconfInputStream));
        grndsXmlReader.addDialect(new GrndsWebAppXmlDialect());
        grndsWebAppInfo = (GrndsWebAppInfo) grndsXmlReader.readObject();
      } else {
        throw new IllegalStateException("Attempt to read xconf returned null.");
      }
    }
    catch (ClassNotFoundException e) {
      setErrorMessage("Could not find class:" + GrndsWebAppInfo.class, DISPLAY_URI, request);
      setPresentationBranch("error", context);
    }
    catch (GrndsXmlException e) {
      setErrorMessage("Could not process XML web application " + "map", DISPLAY_URI, request);
      setPresentationBranch("error", context);
    }
    catch (IOException e) {
      setErrorMessage("Could not read: " + GRNDS_WEB_APP_XCONF_FILE_NAME, DISPLAY_URI, request);
      setPresentationBranch("error", context);
    }
    finally {
      if (xconfInputStream != null) {
        try {
          xconfInputStream.close();
        }
        catch (IOException e) {
          // Ignore this.
        }
      }
      if (grndsXmlReader != null) {
        try {
          grndsXmlReader.close();
        }
        catch (IOException e) {
          // Ignore this.
        }
      }
    }
    return grndsWebAppInfo;
  }

  public void requestClassRefresh_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".requestClassRefresh_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".requestClassRefresh()");

    try {
      // Logoff before we even try this
      UserProfileHelper.logoff(context.getRequest());
      // Clear the converstaion factories.
      ServletContext servletContext = context.getServletContext();
      Enumeration attributeNamesEnum = servletContext.getAttributeNames();
      while (attributeNamesEnum.hasMoreElements()) {
        String attributeName = (String) attributeNamesEnum.nextElement();
        if (attributeName.startsWith(GrndsExchangeContext.CONVERSATION_SESSION_PREFIX)) {
          servletContext.removeAttribute(attributeName);
        }
      }
      // Todo: Put these magic strings more useful.
      BeanFactoryLocator beanFactoryLocator =
              SJSASContextSingletonBeanFactoryLocator.getInstance(SpringConstants.SERVICE_CONTEXT_SELECTOR);
      BeanFactoryReference beanFactoryReference =
              beanFactoryLocator.useBeanFactory(SpringConstants.SERVICE_BEAN_FACTORY);
      ConfigurableApplicationContext springContext = (ConfigurableApplicationContext) beanFactoryReference.getFactory();
      springContext.refresh();
      forwardToDisplay(context);
    }
    catch (Exception e) {
      setErrorMessage("Class refresh failed.", DISPLAY_URI, context.getRequest());
      setPresentationBranch("error", context);
    }
    GrndsTrace.exitScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private void forwardToDisplay(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    try {
      forward(encodeRequestURI(DISPLAY_URI, request), request, context.getResponse());
    }
    catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure redisplaying '" + DISPLAY_URI + "':" + e.getMessage());
      processSevereException(context, e);
    }
  }

  public void executeTest_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".executeTest_xa()");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".executeTest_xa()");

    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);

    // update employee table with userid
    int claimedUserId = ContextHelper.getIntSafe(request, UserProfileHelper.CLAIM_USER_ID_KEY);
    String username = ContextHelper.getStringSafe(request, UserProfileHelper.LOGIN_NAME_KEY).toUpperCase().trim();
    if (claimedUserId != 0 && username.length() > 0) {
      if (!claimUserId(context, username, claimedUserId)) {
        setPresentationBranch("error", context);
      }
    }

    // Process the login
    processLogin(context);

    // Get the URI of what we should test and find out if it is a submodule
    // Note that the presentation branch will be overridden by any errors below
    String URI = ContextHelper.getStringSafe(request, "txtURI");
    boolean isSubmodule = ContextHelper.getBooleanSafe(request, "cbxIsSubmodule");
    if (isSubmodule) {
      state.setAttribute(SUBMODULE_URI_KEY, URI, request);
      URI = "/test/Test/displaySubModuleTest";

      // Set the attributes key
      state.setAttribute(ATTRIBUTES_KEY, getUserAttributeMap(request), request);
    } else {
      // Set the user attributes on the request
      setRequestAttributes(request);

      // Encode and set user parameters on the reqeust
      URI = encodeUserParameters(URI, request);
    }

    // Process security access changes
    processSecurity(context);
    GrndsTrace.msg(TRACE_TAG, 8, "Done processing security.");

    // Get objects for setting GlobalData
    Map gdMethodMap = TestHelper.getGlobalDataSetters();
    Set exceptionNameSet = TestHelper.getExcptionNames();

    // Set the special values of GlobalData first
    String appMode = ContextHelper.getStringSafe(request, "selGlobalDataAppMode");
    if ("O".equals(appMode)) {
      appMode = ContextHelper.getStringSafe(request, "txtAppModeOther");
    }
    GlobalData.setAppMode(appMode, request);

    boolean hasStageAccess = ContextHelper.getBooleanSafe(request, "cbxHasStageAccess");
    GlobalData.setStageAccess(hasStageAccess, request);

    // Use reflection to set the rest of Globabl Data
    Iterator methodIt = gdMethodMap.keySet().iterator();
    while (methodIt.hasNext()) {
      String methodName = (String) methodIt.next();
      if (!exceptionNameSet.contains(methodName)) {
        String value = ContextHelper.getStringSafe(request, "txtGlobalData" + methodName);
        if (!"".equals(value)) {
          //If a user explicitly enters the String "NULL", an empty string will
          // be placed into GlobalData, allowing data to be cleared.
          if ("NULL".equals(value)) {
            value = "";
          }
          Method method = (Method) gdMethodMap.get(methodName);
          Class[] paramTypes = method.getParameterTypes();
          try {
            // check the first parameter type, as that contains the value
            if (paramTypes.length == 2 && paramTypes[0].equals(String.class)) {
              method.invoke(null, value, request);
            } else if (paramTypes.length == 2 && paramTypes[0].equals(Integer.TYPE)) {
              Integer intValue = Integer.valueOf(value);
              method.invoke(null, intValue, request);
            }
          }
          catch (Exception e) {
            GrndsTrace.msg(TRACE_TAG, 7, "Failure setting GlobalData using reflection:" + e.getMessage());
            setPresentationBranch("error", context);
            setErrorMessage(e.getMessage(), "DISPLAY_URI", request);
          }
        }
      }
    }

    // Set PageMode into state with PageMode
    String pageMode = ContextHelper.getStringSafe(request, "selPageMode");
    if ("O".equals(pageMode)) {
      pageMode = ContextHelper.getStringSafe(request, "txtPageModeOther");
    }
    if (!"".equals(pageMode)) {
      PageMode.setPageMode(pageMode, request);
    }

    // check to see if we have an error (presentation branch will be non-null); if not, forward to the value in URI
    if (getPresentationBranch(context) == null) {
      try {
        forward(URI, request, context.getResponse());
      }
      catch (ServletException e) {
        GrndsTrace.msg(TRACE_TAG, 7, "Failure forwarding to URI '" + URI + "' with error:" + e.getMessage());
        setPresentationBranch("error", context);
        setErrorMessage(e.getMessage(), "DISPLAY_URI", request);
      }
    }

    GrndsTrace.exitScope();
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private String encodeUserParameters(String URI, HttpServletRequest request) {
    StringBuffer sb = new StringBuffer(URI).append('?');
    Map userParameterMap = getUserParameterMap(request);
    Iterator it = userParameterMap.keySet().iterator();
    while (it.hasNext()) {
      String name = (String) it.next();
      String value = (String) userParameterMap.get(name);
      sb.append(URLHelper.encode(name));
      sb.append('=');
      sb.append(URLHelper.encode(value));
      sb.append('&');
    }
    return sb.substring(0, sb.length() - 1);
  }

  private Map getUserParameterMap(HttpServletRequest request) {
    Map<String, String> userParameterMap = new HashMap<String, String>();
    Set paramNameSet = request.getParameterMap().keySet();
    Iterator it = paramNameSet.iterator();
    while (it.hasNext()) {
      String paramNameKey = (String) it.next();
      if (paramNameKey.startsWith("txtUserParameterName")) {
        String paramNameKeySuffix = paramNameKey.substring(20, paramNameKey.length());
        String paramValueKey = "txtUserParameterValue" + paramNameKeySuffix;
        //If user parameter already exists, it was created via javascript on JSP
        // and doesn't need to be parsed to go into request.
        if (!paramNameSet.contains(request.getParameter(paramNameKey))) {
          //If user parameter doesn't exist yet, check to make sure a value was
          // entered by user, and if so, put name and value into map.
          if (paramNameSet.contains(paramValueKey)) {
            userParameterMap.put(request.getParameter(paramNameKey), request.getParameter(paramValueKey));
          }
        }
      }
    }
    return userParameterMap;
  }

  private String encodeRequestURI(String URI, HttpServletRequest request) {
    StringBuffer sb = new StringBuffer(URI).append('?');
    Set paramNameSet = request.getParameterMap().keySet();
    Iterator it = paramNameSet.iterator();
    while (it.hasNext()) {
      String paramNameKey = (String) it.next();
      if (paramNameKey.startsWith("txtUserParameterName")) {
        String paramNameKeySuffix = paramNameKey.substring(20, paramNameKey.length());
        String paramValueKey = "txtUserParameterValue" + paramNameKeySuffix;
        if (paramNameSet.contains(paramValueKey)) {
          sb.append(URLHelper.encode(request.getParameter(paramNameKey)));
          sb.append('=');
          sb.append(URLHelper.encode(request.getParameter(paramValueKey)));
          sb.append('&');
        }
      }
    }
    return sb.substring(0, sb.length() - 1);
  }

  private void setRequestAttributes(HttpServletRequest request) {
    Map userAttributeMap = getUserAttributeMap(request);
    Iterator it = userAttributeMap.keySet().iterator();
    while (it.hasNext()) {
      String name = (String) it.next();
      request.setAttribute(name, userAttributeMap.get(name));
    }
  }

  private Map getUserAttributeMap(HttpServletRequest request) {
    Map<String, String> userAttributeMap = new HashMap<String, String>();
    Set attributeNameSet = request.getParameterMap().keySet();
    Iterator it = attributeNameSet.iterator();
    while (it.hasNext()) {
      String attributeNameKey = (String) it.next();
      if (attributeNameKey.startsWith("txtUserAttributeName")) {
        String attributeNameKeySuffix = attributeNameKey.substring(20, attributeNameKey.length());
        String attributeValueKey = "txtUserAttributeValue" + attributeNameKeySuffix;
        if (attributeNameSet.contains(attributeValueKey)) {
          userAttributeMap.put(request.getParameter(attributeNameKey), request.getParameter(attributeValueKey));
        }
      }
    }
    return userAttributeMap;
  }

  private void processLogin(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    try {
      // Logoff first, just in case
      UserProfileHelper.logoff(request);
      LoginConversation.createUser(context, admin);
    }
    catch (SecurityException se) {
      setPresentationBranch("error", context);
      setErrorMessage(se.getMessage(), "DISPLAY_URI", request);
    }
    catch (Exception e) {
      processSevereException(context, e);
    }
  }

  /** @noinspection UseOfSystemOutOrSystemErr */
  private void processSecurity(GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    UserProfile profile = UserProfileHelper.getUserProfile(context);
    if (profile != null) {
      SettableUserProfile settable = new SettableUserProfile(profile);

      //Get the type of action to take on the security settings:
      String securityAction = ContextHelper.getStringSafe(request, "rbSecurityAction");

      if (!securityAction.equals(SEC_ACTION_NO_CHANGE)) {
        GrndsTrace.msg(TRACE_TAG, 8, "User chose a modifying security action.");
        String checkBoxNameBase = "cbxUserSecurityAttribute_";

        Iterator userRightIterator = TestHelper.getUserRightSet().iterator();
        while (userRightIterator.hasNext()) {
          UserRight userRight = (UserRight) userRightIterator.next();
          String rightName = userRight.getRightName();
          int rightIndex = userRight.getRightIndex();
          String checkedValue = CheckboxHelper.getCheckboxValue(context.getRequest(), checkBoxNameBase + rightIndex);
          if ("Y".equals(checkedValue)) {
            if (securityAction.equals(SEC_ACTION_EXACT) || securityAction.equals(SEC_ACTION_INCLUSIVE)) {
              GrndsTrace.msg(TRACE_TAG, 8, "Granting right " + rightName + ".");
              try {
                settable.grantRight(rightIndex);
              }
              catch (gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException ipe) {
                GrndsTrace.msg(TRACE_TAG, 8, "Could not grant right " + rightName + ".");
                ipe.printStackTrace(System.out);
              }
            }
          } else {
            if (securityAction.equals(SEC_ACTION_EXACT) || securityAction.equals(SEC_ACTION_EXCLUSIVE)) {
              GrndsTrace.msg(TRACE_TAG, 8, "Revoking right " + rightName + ".");
              try {
                settable.revokeRight(rightIndex);
              }
              catch (gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException ipe) {
                GrndsTrace.msg(TRACE_TAG, 8, "Could not revoke right " + rightName + ".");
                ipe.printStackTrace(System.out);
              }
            }
          }
        }
      }
      //For No Change and Inclusive, add Region 14 Access (right #30) to
      // enable performance tracking.
      if (!securityAction.equals(SEC_ACTION_EXACT) && !securityAction.equals(SEC_ACTION_EXCLUSIVE)) {
        try {
          GrndsTrace.msg(TRACE_TAG, 8, "Granting Region 14 Access to user to turn on performance logging.");
          settable.grantRight(30);
        }
        catch (gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException ipe) {
          GrndsTrace.msg(TRACE_TAG, 8, "Could not grant right Region 14 Access.");
          ipe.printStackTrace(System.out);
        }
      }
      HttpSession session = request.getSession(false); // session MUST exist at this point (to get the profile above )
      session.setAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID, settable);
    }
  }
}
