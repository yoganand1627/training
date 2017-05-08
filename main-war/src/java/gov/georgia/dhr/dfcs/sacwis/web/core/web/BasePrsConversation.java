package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsBasicHttpConversation;
import org.grnds.structural.web.GrndsExchangeContext;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsRuntimeException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.audit.AuditInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.audit.AuditLogger;
import gov.georgia.dhr.dfcs.sacwis.web.core.audit.AuditRecord;
import gov.georgia.dhr.dfcs.sacwis.web.core.audit.URICommand;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.ScreenDefinitionsXmlDao;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.SpecificExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;

/**
 * This conversation extends the GrndsBasicHttpConversation, adding methods for easily storing output beans to the
 * request.
 */
public abstract class BasePrsConversation extends GrndsBasicHttpConversation {

  private static final String COMMITTED_RESPONSE_EXCEPTION_MESSAGE = "Cannot forward after response has been committed";

  private static AtomicInteger messageCount = new AtomicInteger(0);
  public static final String TRACE_TAG = "BasePrsConversation";
  public static final String ERROR_MESSAGES = "ErrorMessages";
  public static final String INFO_MESSAGES = "InfoMessages";
  public static final String POPUP_MESSAGES = "PopupMessages";
  public static final String ERROR_DESTINATION = "ErrorDestination";
  public static final String GRNDS_QNAME_ATTRIBUTE = "grnds.request.qname";

  /** Used to set a message number in the request for the audit message that will be logged. */
  public static final String NBR_MSG_AUDIT = TRACE_TAG + ".nbrMsgAudit";

  // The request can get cleared; this will avoid the problems with using it to track forwards
  private static ThreadLocal<Set<String>> safeForwardMapThreadLocal = new ThreadLocal<Set<String>>();

  /**
   * Auditing is done here for two reasons:<ol><li>The information in Global Data has been updated, so we know that we
   * are dealing with the right information.</li><li>The page is already drawn at this point, so pauses for writing to
   * the database will go unnoticed by users.</li></ol>
   *
   * @param ctx_
   */
  protected void doEndResponse(GrndsExchangeContext ctx_) {
    super.doEndResponse(ctx_);
    HttpServletRequest request = ctx_.getRequest();
    int userId = getUserID(request);
    String ipAddr = request.getRemoteAddr();
    int idCommand = AuditInit.getURICommandId(URICommand.parseURI(request.getRequestURI()));
    Integer nbrMessage = (Integer) request.getAttribute(NBR_MSG_AUDIT);
    int idCase = GlobalData.getUlIdCase(request);
    int idStage = GlobalData.getUlIdStage(request);
    int idEvent = GlobalData.getUlIdEvent(request);
    int idPerson = GlobalData.getUlIdPerson(request);
    int idResource = GlobalData.getUlIdResource(request);
    int idParentRsrc = GlobalData.getUlIdParentRsrc(request);
    AuditLogger.log(new AuditRecord(idPerson, ipAddr, idCommand, nbrMessage, idCase, idStage, idEvent, userId,idResource,idParentRsrc), ctx_);
  }

  /**
   * This helper method stores a BaseValueBean object to the HttpServletRequest. The resulting JSP should retrieve the
   * results from the request using the name: BaseValueBean.REQUEST_ATTRIBUTE_NAME. This method should only be used when
   * storing a bean to the request for pagination. If multiple objects need to be stored to the request, specify a
   * unique name for each one using the other store method.
   *
   * @param context       The GrndsExchangeContext object.
   * @param baseValueBean The BaseValueBean object, contains a list of results
   */
  public static void storePaginationBeanToRequest(GrndsExchangeContext context, BaseValueBean baseValueBean) {
    context.getRequest().setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, baseValueBean);
  }

  /**
   * This helper method stores a BaseValueBean object to the HttpServletRequest based on the specified name. The
   * resulting JSP should use request.getAttribute to retrieve this object from the request using the specified name.
   *
   * @param context       The GrndsExchangeContext object.
   * @param baseValueBean The BaseValueBean or a decendent of it.
   * @deprecated - use request.setAttribute
   */
  public static void storeValueBeanToRequest(GrndsExchangeContext context, BaseValueBean baseValueBean, String name) {
    HttpServletRequest request = context.getRequest();

    if (!ExceptionHandler.hasExceptionToPresent(context)) {
      // Put the results in the request
      GrndsTrace.msg(TRACE_TAG, 7, "Placing the value bean object on the request.");
      request.setAttribute(name, baseValueBean);
    }
  }

  /**
   * Checks if the Throwable is the message ARC_BAT_SERVICE_BLOCKED in a WtcException. This exception is thrown by a
   * service when the service is blocked by the batch architecture. When that happens, this method will display a page
   * with just the ARC_BAT_SERVICE_BLOCKED message displayed. Otherwise, this page displays a page with a stack trace of
   * the error. ARC_BAT_INSUFFICIENT_PRIVILEDGES now behaves same as ARC_BAT_SERVICE_BLOCKED
   *
   * @param context
   * @param throwable The exception to be handled
   */
  public static void processSevereException(GrndsExchangeContext context, Throwable throwable) {
    GrndsTrace.enterScope(TRACE_TAG + ".processSevereException");
    SpecificExceptionHandler specificExceptionHandler = ExceptionHandler.handle(throwable);
    specificExceptionHandler.presentErrorMessage(context);
    GrndsTrace.exitScope();
  }

  /**
   * This method will set the informational message onto the request for display. Note: This is currently just a wrapper
   * for the setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param infoMessageCode Message Number of information to be displayed
   * @param request         Request that is placeholder for error messages.
   */
  public static void setInformationalMessage(int infoMessageCode, HttpServletRequest request) {
    String message = MessageLookup.getMessageByNumber(infoMessageCode);
    setInformationalMessage(message, request);
  }

  /**
   * This method will set the informational message onto the request for display. Note: This is currently just a wrapper
   * for the setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param infoMessage text of the information to be displayed
   * @param request     Request that is placeholder for error messages.
   */
  public static void setInformationalMessage(String infoMessage, HttpServletRequest request) {
    setInformationalMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, infoMessage, null, request);
  }

  /**
   * This method will set the informational message onto the request for display. Note: This is currently just a wrapper
   * for the setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param infoMessageCode Message Number of information to be displayed
   * @param infoDestination Destination servlet/Conversation/Command for the message. This is the original url for the
   *                        JSP that the error is being displayed on. This will set the form action so that the page
   *                        will submit to itself, so that it will validate correclty.
   * @param request         Request that is placeholder for error messages.
   */
  public static void setInformationalMessage(int infoMessageCode, String infoDestination, HttpServletRequest request) {
    String message = MessageLookup.getMessageByNumber(infoMessageCode);

    setInformationalMessage(message, infoDestination, request);
  }

  /**
   * This method will set the informational message onto the request for display. Note: This is currently just a wrapper
   * for the setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param infoMessage     text of the information to be displayed
   * @param infoDestination Destination servlet/Conversation/Command for the message. This is the original url for the
   *                        JSP that the error is being displayed on. This will set the form action so that the page
   *                        will submit to itself, so that it will validate correclty.
   * @param request         Request that is placeholder for error messages.
   */
  public static void setInformationalMessage(String infoMessage, String infoDestination, HttpServletRequest request) {
    setInformationalMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, infoMessage, infoDestination, request);
    setErrorDestination(infoDestination, request);
  }

  /**
   * This method will set the informational message onto the request for display. Note: This is currently just a wrapper
   * for the setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param inputName       The name of the input field to which the information will be linked
   * @param infoMessage     text of the information to be displayed
   * @param infoDestination Destination servlet/Conversation/Command for the message. This is the original url for the
   *                        JSP that the error is being displayed on. This will set the form action so that the page
   *                        will submit to itself, so that it will validate correclty.
   * @param request         Request that is placeholder for error messages.
   */
  public static void setInformationalMessage(String inputName, String infoMessage, String infoDestination,
                                             HttpServletRequest request) {
    //noinspection unchecked
    Map<String, String> map = (Map<String, String>) request.getAttribute(BasePrsConversation.INFO_MESSAGES);
    if (map == null) {
      map = new HashMap<String, String>();
    }

    //Prepend a unique identifier to the name in the hashmap
    inputName = getMessageCount() + "_" + inputName;

    map.put(inputName, infoMessage);
    request.setAttribute(BasePrsConversation.INFO_MESSAGES, map);
    setErrorDestination(infoDestination, request);
  }

  /**
   * This method will set the popup message onto the request for display. Note: This is currently just a wrapper for the
   * setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param messageNumber message number of the information to be displayed
   * @param request       Request that is placeholder for error messages.
   */
  public static void setPopUpMessage(int messageNumber, HttpServletRequest request) {
    String message = MessageLookup.getMessageByNumber(messageNumber);
    setPopUpMessage(message, request);
  }

  /**
   * This method will set the popup message onto the request for display. Note: This is currently just a wrapper for the
   * setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param popupMessage text of the information to be displayed
   * @param request      Request that is placeholder for error messages.
   */
  public static void setPopUpMessage(String popupMessage, HttpServletRequest request) {
    setPopUpMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, popupMessage, null, request);
  }

  /**
   * This method will set the popup message onto the request for display. Note: This is currently just a wrapper for the
   * setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param popupMessage     text of the information to be displayed
   * @param popupDestination Destination servlet/Conversation/Command for the message. This is the original url for the
   *                         JSP that the error is being displayed on. This will set the form action so that the page
   *                         will submit to itself, so that it will validate correclty.
   * @param request          Request that is placeholder for error messages.
   */
  public static void setPopUpMessage(String popupMessage, String popupDestination, HttpServletRequest request) {
    setPopUpMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, popupMessage, popupDestination, request);
    setErrorDestination(popupDestination, request);
  }

  /**
   * This method will set the informational message onto the request for display. Note: This is currently just a wrapper
   * for the setErrorMessage method; it should be updated to have its own hashmap.
   *
   * @param inputName        The name of the input field to which the information will be linked
   * @param popupMessage     text of the information to be displayed
   * @param popupDestination Destination servlet/Conversation/Command for the message. This is the original url for the
   *                         JSP that the error is being displayed on. This will set the form action so that the page
   *                         will submit to itself, so that it will validate correclty.
   * @param request          Request that is placeholder for error messages.
   */
  public static void setPopUpMessage(String inputName, String popupMessage, String popupDestination,
                                     HttpServletRequest request) {
    //noinspection unchecked
    Map<String, String> map = (Map<String, String>) request.getAttribute(BasePrsConversation.POPUP_MESSAGES);
    if (map == null) {
      map = new HashMap<String, String>();
    }

    //Prepend a unique identifier to the name in the hashmap
    inputName = getMessageCount() + "_" + inputName;

    map.put(inputName, popupMessage);
    request.setAttribute(BasePrsConversation.POPUP_MESSAGES, map);
    setErrorDestination(popupDestination, request);
  }

  /**
   * This method will set the error message onto the request for display
   *
   * @param errorCode        Message Number of error to be displayed
   * @param errorDestination Destination servlet/Conversation/Command for the error. This is the original url for the
   *                         JSP that the error is being displayed on. This will set the form action so that the page
   *                         will submit to itself, so that it will validate correclty.
   * @param request          Request that is placeholder for error messages.
   */
  public static void setErrorMessage(int errorCode, String errorDestination, HttpServletRequest request) {
    String message = MessageLookup.getMessageByNumber(errorCode);

    setErrorMessage(message, errorDestination, request);
  }

  public static void displayMessagePage(int messageId, GrndsExchangeContext context) {
    String message = MessageLookup.getMessageByNumber(messageId);
    BasePrsConversation.displayMessagePage(message, context);
  }

  public static final String MESSAGE_PAGE_LOCATION = "/error/MessageDisplay/messageDisplay";

  public static void displayMessagePage(String message, GrndsExchangeContext context) {
    try {
      BasePrsConversation.setInformationalMessage(message, MESSAGE_PAGE_LOCATION, context.getRequest());
      BasePrsConversation.forward(MESSAGE_PAGE_LOCATION, context.getRequest(), context.getResponse());
    } catch (Exception e) {
      BasePrsConversation.processSevereException(context, e);
    }
  }

  /**
   * This method will set the error message onto the request for display
   *
   * @param errorMessage     Description of the error to be displayed
   * @param errorDestination Destination servlet/Conversation/Command for the error. This is the original url for the
   *                         JSP that the error is being displayed on. This will set the form action so that the page
   *                         will submit to itself, so that it will validate correclty.
   * @param request          Request that is placeholder for error messages.
   */
  public static void setErrorMessage(String errorMessage, String errorDestination, HttpServletRequest request) {
    setErrorMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, errorMessage, errorDestination, request);
    setErrorDestination(errorDestination, request);
  }

  /**
   * This method will set the error message onto the request for display
   *
   * @param errorCode Number of the error to be displayed
   * @param request   Request that is placeholder for error messages.
   */
  public static void setErrorMessage(int errorCode, HttpServletRequest request) {
    String message = MessageLookup.getMessageByNumber(errorCode);

    setErrorMessage(message, request);
  }

  /**
   * This method will set the error message onto the request for display
   *
   * @param errorMessage Description of the error to be displayed
   * @param request      Request that is placeholder for error messages.
   */
  public static void setErrorMessage(String errorMessage, HttpServletRequest request) {
    setErrorMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, errorMessage, null, request);
  }

  /**
   * This method will add the error message onto the request for display without setting
   *
   * @param errorCode int of the error to be displayed
   * @param request   Request that is placeholder for error messages.
   */
  public static void addErrorMessage(int errorCode, HttpServletRequest request) {
    BasePrsConversation.addErrorMessage(InputValidation.UNSPECIFIED_INPUT_FIELD,
                                        MessageLookup.getMessageByNumber(errorCode),
                                        request);
  }

  /**
   * This method will add the error message onto the request for display without setting
   *
   * @param errorMessage Description of the error to be displayed
   * @param request      Request that is placeholder for error messages.
   */
  public static void addErrorMessage(String errorMessage, HttpServletRequest request) {
    BasePrsConversation.addErrorMessage(InputValidation.UNSPECIFIED_INPUT_FIELD, errorMessage, request);
  }

  /**
   * This method will add the error message onto the request for display without setting
   *
   * @param inputName    The name of the input field to which the error will be linked
   * @param errorMessage Description of the error to be displayed
   * @param request      Request that is placeholder for error messages.
   */
  public static void addErrorMessage(String inputName, String errorMessage, HttpServletRequest request) {
    //noinspection unchecked
    Map<String, String> map = (Map<String, String>) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
    if (map == null) {
      map = new HashMap<String, String>();
    }

    //Prepend a unique identifier to the name in the hashmap
    inputName = getMessageCount() + "_" + inputName;

    map.put(inputName, errorMessage);
    request.setAttribute(BasePrsConversation.ERROR_MESSAGES, map);
  }

  /**
   * This method will set the error message onto the request for display
   *
   * @param inputName        The name of the input field to which the error will be linked
   * @param errorMessage     Description of the error to be displayed
   * @param errorDestination Destination servlet/Conversation/Command for the error. This is the original url for the
   *                         JSP that the error is being displayed on. This will set the form action so that the page
   *                         will submit to itself, so that it will validate correclty.
   * @param request          Request that is placeholder for error messages.
   */
  public static void setErrorMessage(String inputName, String errorMessage, String errorDestination,
                                     HttpServletRequest request) {
    //noinspection unchecked
    Map<String, String> map = (Map<String, String>) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
    if (map == null) {
      map = new HashMap<String, String>();
    }

    //Prepend a unique identifier to the name in the hashmap
    inputName = getMessageCount() + "_" + inputName;

    try {
      BasePrsHttpServlet.reinstateRequestAttributes(request);
      map.put(inputName, errorMessage);
      request.setAttribute(BasePrsConversation.ERROR_MESSAGES, map);

      //BEE 1/8/03 - Set errorMessageFlag attribute
      ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);

      //EILERSBE 8/6/03 - If Error Destinatin is null, set it to previous URL
      if (errorDestination == null) {
        errorDestination = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);
      }
      setErrorDestination(errorDestination, request);

    } catch (ServletException se) {
      throw new BasePrsRuntimeException(TRACE_TAG, se, 1);
    }
  }

  /**
   * This method will set the error message onto the request for display
   *
   * @param errorDestination Destination servlet/Conversation/Command for the error. This is the original url for the
   *                         JSP that the error is being displayed on. This will set the form action so that the page
   *                         will submit to itself, so that it will validate correclty.
   * @param request          Request that is placeholder for error messages.
   */
  public static void setErrorDestination(String errorDestination, HttpServletRequest request) {
    request.setAttribute(BasePrsConversation.ERROR_DESTINATION, errorDestination);
  }

  /** This method checks to see if errorMessage is inside the request ERROR_MESSAGES hashMap as a value. */
  public static boolean hasErrorMessage(String errorMessage, HttpServletRequest request) {
    Map map = (Map) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
    return map != null && map.containsValue(errorMessage);
  }

  /** This method checks to see if message is inside the request INFO_MESSAGES hashMap as a value. */
  public static boolean hasInformationalMessage(String message, HttpServletRequest request) {
    Map map = (Map) request.getAttribute(BasePrsConversation.INFO_MESSAGES);
    return map != null && map.containsValue(message);
  }

  /**
   * This methods is a convenience method for forwarding between conversations; it resets with the GrndsQName
   * attribute.
   *
   * @param url      The URL <code>String</code>
   * @param request  The <code>ServletRequest</code> object
   * @param response The <code>ServletResponse</code> object
   * @throws ServletException Thrown by the <code>RequestDispatcher</code> if an exception is thrown in the page to
   *                          which the forward is made.
   */
  public static void forward(String url, ServletRequest request, ServletResponse response) throws ServletException {
    GrndsTrace.msg(TRACE_TAG, 7, "forwarding to: " + url);
    RequestDispatcher dispatch = request.getRequestDispatcher(url);
    request.removeAttribute(BasePrsConversation.GRNDS_QNAME_ATTRIBUTE);
    request.removeAttribute(ScreenDefinitionsXmlDao.SCREEN);
    Monitor monitor = MonitorFactory.start(url);
    // Need to catch IllegalStateException and attempt an include in case we are in a submodule
    try {
      try {
        dispatch.forward(request, response);
      } catch (IllegalStateException ise) {
        // This is a Sun-specific error message; a different server would require a different message.
        if(COMMITTED_RESPONSE_EXCEPTION_MESSAGE.equals(ise.getMessage())) {
          dispatch.include(request, response);
        }
      }
    } catch (ServletException e) {
      // Pass ServletExceptions through
      throw e;
    } catch (Exception e) {
      // Wrap all other exceptions in ServletException, which is handled properly
      throw new ServletException("BasePrsConversation: Forwarding failed because of an IO Error.", e);
    } finally {
      monitor.stop();
    }
  }

  /**
   * This methods is a convenience method for forwarding between conversations; it prevents recursive forwarding by
   * storing the url being forwarded in a Set stored in a ThreadLocal.
   *
   * @param url      The URL <code>String</code>
   * @param request  The <code>ServletRequest</code> object
   * @param response The <code>ServletResponse</code> object
   * @throws ServletException Thrown by the <code>RequestDispatcher</code> if an exception is thrown in the page
   *                          forwarded to.
   */
  public static void forwardSafe(String url, ServletRequest request, ServletResponse response) throws ServletException {
    boolean doForward = false;
    // We want to attempt to forward to a URL, but never include it recursively.
    Set<String> forwardIncludeSet = safeForwardMapThreadLocal.get();
    // If the set is null, initialize it and do the forward
    if (forwardIncludeSet == null) {
      forwardIncludeSet = new HashSet<String>();
      safeForwardMapThreadLocal.set(forwardIncludeSet);
      doForward = true;
    } else if (!forwardIncludeSet.contains(url)) {
      doForward = true;
    }
    if (doForward) {
      try {
        forwardIncludeSet.add(url);
        forward(url, request, response);
      }
      finally {
        forwardIncludeSet.remove(url);
      }
    }
  }

  private static int getMessageCount() {
    return (messageCount.incrementAndGet() % 10000);
  }

  /** Creates a url given a baseUrl and a hashtable of parameters */
  public static String getUrl(String baseUrl, Map parameters) {
    GrndsTrace.enterScope(TRACE_TAG + ".getUrl\n" + "\t pageName: " + baseUrl + "\n " +
                          "\t parameters: " + parameters + "\n ");
    String url = baseUrl;
    if (parameters == null) {
      return url;
    }
    String ampersand = "?";
    Iterator iterator = parameters.keySet().iterator();
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      Object object = parameters.get(key);
      if (object instanceof String) {
        String value = (String) object;
        url += (ampersand + key + "=" + URLHelper.encode(value));
        ampersand = "&";
      } else {
        String[] array = (String[]) object;
        for (int i = 0; i < array.length; i++) {
          url += (ampersand + key + "=" + URLHelper.encode(array[i]));
          ampersand = "&";
        }
      }
    }
    GrndsTrace.exitScope();
    return url;
  }

  /** Returns the UserID associated with the request */
  public static int getUserID(HttpServletRequest request) {
    UserProfile userProfile = getUserProfile(request);
    if (userProfile == null) {
      return 0;
    }
    return userProfile.getUserID();
  }

  /** Returns the UserLoginId associated with the request */
  public static String getUserLogonID(HttpServletRequest request) {
    UserProfile userProfile = getUserProfile(request);
    if (userProfile == null) {
      return null;
    }
    return userProfile.getUserLogonID();
  }

  /** Returns the UserProfile associated with the request */
  public static UserProfile getUserProfile(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return null;
    }
    return (UserProfile) session.getAttribute(UserProfileHelper.USER_PROFILE_SESSION_ID);
  }
}
