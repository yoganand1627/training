package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludePresentation;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.SpecificExceptionHandler;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.ExpandableSectionHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RequestAttributes;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.Validator;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.foundation.exception.GrndsErrorSupport;
import org.grnds.structural.web.GrndsExchangeActivity;
import org.grnds.structural.web.GrndsExchangeContext;
import org.grnds.structural.web.GrndsExchangePresentation;
import org.grnds.structural.web.GrndsHttpConversation;
import org.grnds.structural.web.GrndsHttpServlet;
import org.grnds.structural.web.GrndsUnrecognizedRequestException;
import org.grnds.structural.web.config.GrndsCommandInfo;
import org.grnds.structural.web.config.GrndsServletInfo;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class BasePrsHttpServlet extends GrndsHttpServlet {
  private static final String TRACE_TAG = "BasePrsHttpServlet";
  private static final String TASK_CODE_SET_FOR_REQUEST = "TASK_CODE_SET_FOR_REQUEST";

  public static final String TIMED_OUT_SESSION_KEY = TRACE_TAG + ".TIMED_OUT_SESSION_KEY";

  private static final Object servletInfoMapSyncObj = new Object(); // used only for synchronization

  private static final Map<String, Map<String, GrndsHttpConversation>> conversationCache =
          new HashMap<String, Map<String, GrndsHttpConversation>>();

  private static final boolean PER_USER_DATASOURCE =
          Boolean.parseBoolean(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                            "perUserSchemaSupport"));
  private static Map<String, GrndsServletInfo> servletInfoMap = null;

  protected String expSectionHiddenFieldName = "expSectionHiddenFieldName";
  protected String formName = "formName";

  /**
   * We use the {@link GrndsSpringConversationFactory} to let our conversations be Spring-aware.
   *
   * @return The  {@link gov.georgia.dhr.dfcs.sacwis.web.core.web.GrndsSpringConversationFactory} class.
   */
  protected Class getDefaultGrndsHttpConversationFactoryClass() {
    return GrndsSpringConversationFactory.class;
  }

  /**
   * Unlike the overridden version of this method, this version does not put the conversation in session and does not
   * ever call the init() method on it.
   * <p/>
   * Instead it searches a conversation cache, returns the result if found, or creates and caches a conversation if
   * ncessary.
   *
   * @param ctx
   * @return
   * @throws ServletException
   * @throws IOException
   */
  protected GrndsHttpConversation getConversation(GrndsExchangeContext ctx) throws ServletException, IOException {
    GrndsHttpConversation conversation = getCachedConversation(ctx);
    if (conversation != null) {
      return conversation;
    }
    // If we got here, we need to cache the conversation
    return cacheConversation(ctx);
  }

  /**
   * Checks the cache for an already created conversation and returns it if available.
   *
   * @param ctx
   * @return
   */
  private GrndsHttpConversation getCachedConversation(GrndsExchangeContext ctx) {
    Map<String, GrndsHttpConversation> servletConversationCache = conversationCache.get(getServletName());
    if (servletConversationCache != null) {
      GrndsHttpConversation conversation = servletConversationCache.get(ctx.getConversationSessionName());
      if (conversation != null) {
        return conversation;
      }
    }
    return null;
  }

  /**
   * Creates and caches a new conversation object.  Returns the result.
   *
   * @param ctx
   * @return
   * @throws IOException
   * @throws ServletException
   */
  private synchronized GrndsHttpConversation cacheConversation(GrndsExchangeContext ctx)
          throws IOException, ServletException {
    GrndsHttpConversation conversation = getCachedConversation(ctx);
    if (conversation != null) {
      return conversation;
    }
    // If we got here, we need to cache the conversation.
    final String servletName = getServletName();
    Map<String, GrndsHttpConversation> servletConversationCache = conversationCache.get(servletName);
    if (servletConversationCache == null) {
      servletConversationCache = new HashMap<String, GrndsHttpConversation>();
      conversationCache.put(servletName, servletConversationCache);
    }
    conversation = doCreateConversation(ctx);
    servletConversationCache.put(ctx.getConversationSessionName(), conversation);
    return conversation;
  }

  /** Method that will return a screen name for a particular servletMapping, conversation, commandName, and branch. */
  public static String getScreenName(String servletMapping, String conversation, String commandName, String branch) {
    GrndsTrace.enterScope(BasePrsHttpServlet.TRACE_TAG + ".getScreenName");
    GrndsTrace.msg(BasePrsHttpServlet.TRACE_TAG, 5,
                   "Trying to find the command info for " + servletMapping + "; " + conversation + "; " + commandName);
    GrndsServletInfo servletInfo;
    GrndsCommandInfo[] commands;
    GrndsCommandInfo command;
    String screenName = null;

    if (BasePrsHttpServlet.servletInfoMap != null) {
      servletInfo = BasePrsHttpServlet.servletInfoMap.get(servletMapping);

      if (servletInfo != null) {
        conversation = BasePrsHttpServlet.extractConversationName(conversation);
        commands = servletInfo.getConversation(conversation).getCommands();
        if (commands != null) {
          command = BasePrsHttpServlet.getCommand(commands, commandName);

          if (command != null) {
            screenName = command.getPresentationScreenValue(branch);
          }
        }
      }
    }

    GrndsTrace.exitScope( /*screenName*/);
    return screenName;

  }

  /** This method overrides the doGet() method of the GrndsHttpServlet class to include custom exception handling. */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * This method overrides the doPost() method of the GrndsHttpServlet class to include custom exception handling and
   * correctly set the character set for the request and response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      // Set the character encodings for the request and response.
      //
      request.setCharacterEncoding(ArchitectureConstants.CHARACTER_ENCODING);
      super.doPost(request, response);
    } catch (Exception e) {
      this.handleException(request, response, e);
    } finally {
      if (PER_USER_DATASOURCE) {
        // This is cleared here because there is already a try/catch here, so adding a finally here is faster than
        //   adding another try clause in the authenticated server.
        // It is ok if this is chained because the authenticated servlet always sets it before user code is executed.
        UsernameContextHolder.clearUsername();
      }
    }
  }

  /** This method will perform the handling for an exception. */
  protected void handleException(HttpServletRequest request, HttpServletResponse response, Throwable throwable)
          throws ServletException, IOException {
    try {
      //this was handleServletException
      if (throwable instanceof ServletException) {
        Throwable nestedError = GrndsErrorSupport.getNestedError(throwable);

        if (nestedError != null) {
          throwable = nestedError;
        }
      }

      //Create a GrndsExchangeContext for presenting the error...
      GrndsExchangeContext context = createExchangeContext(request, response);

      GrndsTrace.msg(BasePrsHttpServlet.TRACE_TAG, 7, "Error in BasePrsHttpServlet: " + throwable.getMessage());
      SpecificExceptionHandler specificExceptionHandler = ExceptionHandler.handle(throwable);
      specificExceptionHandler.presentErrorMessage(context);
    } catch (Throwable e) {
      // Eat these -- they should never happen.
      //noinspection CallToPrintStackTrace
      e.printStackTrace();
    }
  }

  /**
   * Override GrndsHttpServlet's getSerlvetInfo method so that the static variable BasePrsHttpServlet.servletInfoMap can
   * be set, allowing screen names to be matched from the grnds-web-app.xconf file
   */
  protected GrndsServletInfo getSerlvetInfo(GrndsExchangeContext ctx_) throws ServletException, IOException {
    GrndsTrace.enterScope(BasePrsHttpServlet.TRACE_TAG + ".getServletInfo");
    GrndsTrace.msg(BasePrsHttpServlet.TRACE_TAG, 5, "Context is -> " + ctx_);
    GrndsServletInfo result;
    String servletMapping = ctx_.getServletMapping();

    if (BasePrsHttpServlet.servletInfoMap == null) {
      synchronized (BasePrsHttpServlet.servletInfoMapSyncObj) {
        // do a double null check because someone might have created the map while we were busy getting a lock
        if (BasePrsHttpServlet.servletInfoMap == null) {
          //noinspection AssignmentToStaticFieldFromInstanceMethod
          BasePrsHttpServlet.servletInfoMap = new HashMap<String, GrndsServletInfo>();
        }
      }
    }

    result = BasePrsHttpServlet.servletInfoMap.get(servletMapping);
    if (result == null) {
      synchronized (BasePrsHttpServlet.servletInfoMapSyncObj) {
        // do a double null check because someone might have updated the map while we were busy getting a lock
        result = BasePrsHttpServlet.servletInfoMap.get(servletMapping);
        if (result == null) {
          result = super.getSerlvetInfo(ctx_);
          GrndsTrace.msg(BasePrsHttpServlet.TRACE_TAG, 5,
                         "Adding entry to map for servlet " + "mapping:" + servletMapping + " result:" + result);
          BasePrsHttpServlet.servletInfoMap.put(servletMapping, result);
        }
      }
    }

    GrndsTrace.exitScope();
    return result;
  }

  /**
   * Override the GrndsHttpServlet's doPreExchange method so that prior to each exchange we check to see if the static
   * variable BasePrsHttpServlet.servletInfoMap has been initialized.
   */
  protected boolean doPreExchange(GrndsExchangeContext ctx) throws ServletException, IOException {
    GrndsTrace.enterScope(BasePrsHttpServlet.TRACE_TAG + ".doPreExchange");
    String servletMapping = ctx.getServletMapping();
    if (BasePrsHttpServlet.servletInfoMap == null || BasePrsHttpServlet.servletInfoMap.get(servletMapping) == null) {
      this.getSerlvetInfo(ctx);
    }

    // declare a boolean to hold the results of validation
    boolean result = true;
    HttpServletRequest request = ctx.getRequest();

    String lensesCaseIdStr = request.getParameter("caseId");

    // Skip execution of the bulk of this method if we have a timed-out session,
    //   since the results will be thrown away, anyway.
    if (!ArchitectureConstants.TRUE.equals(request.getAttribute(TIMED_OUT_SESSION_KEY))) {
      // Put the task code in the request attribute space for the metaphor
      String taskCD = request.getParameter("taskCD");
      GrndsTrace.msg(TRACE_TAG, 8, "taskCD in BasePrsHttpServlet is :" + taskCD + ".");
      Boolean taskCDSet = (Boolean) request.getAttribute(TASK_CODE_SET_FOR_REQUEST);
      if (taskCDSet == null &&
          taskCD != null && !"".equals(taskCD)) {
        if ("NULL".equalsIgnoreCase(taskCD)) {
          taskCD = "";
        }
        GlobalData.setSzCdTask(taskCD, request);
        request.setAttribute(TASK_CODE_SET_FOR_REQUEST, Boolean.TRUE);
      }

      // Process expandable section state
      String frmName = request.getParameter("formName");
      String[] xpandNames = request.getParameterValues("expSectionHiddenFieldName");
      if (xpandNames != null) {
        for (int j = 0; j < xpandNames.length; j++) {
          String xpandSection = xpandNames[j];
          String xpandKey = frmName != null ? frmName + xpandSection : xpandSection;
          Boolean bExp = StringHelper.isTrue(request.getParameter("xpand" + xpandSection)) ?
                         Boolean.TRUE : Boolean.FALSE;
          ExpandableSectionHelper.setExpandableSectionState(request.getSession(), xpandKey, bExp);
        }
      }

      // Validate forms, as necessary.
      result = validateForm(ctx);
    }

    if (StringHelper.isValid(lensesCaseIdStr)) {
      int lensesCaseId = 0;
      try{
        lensesCaseId = Integer.valueOf(lensesCaseIdStr);
      }catch (NumberFormatException nfe){
        lensesCaseId = 0;
      }
      if (lensesCaseId > 0) {
        // Set the Lenses Case ID back to the request.
        GrndsTrace.msg(TRACE_TAG, 7, "Set Lenses Case ID");
        request.setAttribute(AuthenticatedPrsHttpServlet.LENSES_CASE_ID, lensesCaseIdStr);
        GlobalData.setUlIdCase(lensesCaseId, request);
      }
    }

    GrndsTrace.exitScope();
    return result;
  }

  /**
   * Removes the trailing slash from the conversation name and returns it to the user
   *
   * @return String The conversation name less the trailing slash("/") character
   */
  static String extractConversationName(String conversation) {
    // separate servlet mapping from conversation name
    int lastSlash = conversation.lastIndexOf((int) '/');
    conversation = conversation.substring(lastSlash + 1);
    GrndsTrace.msg(BasePrsHttpServlet.TRACE_TAG, 9, "Conversation is now: " + conversation);
    return conversation;
  }

  /**
   * Determines if a specified command name is present in an array of command names and returns it to the user.
   *
   * @param commands    A GrndsCommandInfo array
   * @param commandName The specified command name to find in the array
   */
  static GrndsCommandInfo getCommand(GrndsCommandInfo[] commands, String commandName) {
    GrndsCommandInfo command = null;
    for (int count = 0; count < commands.length; count++) {
      if (commands[count].getName().equals(commandName)) {
        command = commands[count];
        break;
      }
    }
    return command;
  }

  /**
   * validates a form object in the session if one exists and conditionally redisplayes the form if invalid data has
   * been entered.
   *
   * @param ctx The GrndsExchangeContext context
   * @return true if the request should be handled by the parent class, false if the request was handled by this
   *         method.
   * @throws IOException      if anything goes wrong
   * @throws ServletException if anything goes wrong
   */
  boolean validateForm(GrndsExchangeContext ctx) throws IOException, ServletException {
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");
    boolean finishRequest = true;
    HttpServletRequest request = ctx.getRequest();

    String formData = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_FLAG);
    String valid = (String) request.getAttribute(ServerSideValidationUtility.FORM_VALIDATION_FORCE_VALID_FLAG);
    String cancelForm = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_CANCEL);

    boolean formExists = formData != null;
    boolean formIsValid = valid != null;
    boolean formIsCanceled = StringHelper.isValid(cancelForm);

    if (formExists && !formIsValid) {
      GrndsTrace.msg(TRACE_TAG, 7, "serialized validation data obtained from request");
      FormValidation form = ServerSideValidationUtility.deserializeValidationObj(formData);
      GrndsTrace.msg(TRACE_TAG, 7, "validation object deserailized successfully");

      //1/7/03 - BEE Clear error messages before putting into request.  Only need inputs.
      form.getErrorMessages().clear();
      finishRequest = false;

      //If validation is cancelled, don't validate
      if (!formIsCanceled) {
        Validator validator = this.getValidator(request);
        form.setInputValues(getRequestParamNames(request), request);
        form.setGrndsExchangeContext(ctx);
        form.validate(validator);
      }

      // remove the context object from the ValidateForm instance so it does not get serialized
      form.removeGrndsExchangeContext();

      //If form has successfully validated or was cancelled, perform the action
      if (form.isValid() || formIsCanceled) {
        request.setAttribute(ServerSideValidationUtility.FORM_VALIDATION_FORCE_VALID_FLAG, ArchitectureConstants.TRUE);
        //Since the page was successfully validated, the previous form Validation
        //object is not needed.  Instead, a new one will be created when the next JSP loads.
        //request.setAttribute(form.getName(), form);
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, false);
        this.performAction(ctx);
      } else {
        //Otherwise, form was unsuccessfully validated, so redisplay page
        reinstateRequestAttributes(request);
        Map infoMessages = (Map) request.getAttribute(BasePrsConversation.INFO_MESSAGES);
        Map popupMessages = (Map) request.getAttribute(BasePrsConversation.POPUP_MESSAGES);
        Map errorMessages = (Map) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
        if (infoMessages != null) {
          infoMessages.clear();
        }
        if (popupMessages != null) {
          popupMessages.clear();
        }
        if (errorMessages != null) {
          errorMessages.clear();
        }
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        request.setAttribute(form.getName(), form);
        this.redisplayPage(ctx);
      }
    }
    GrndsTrace.exitScope(finishRequest);
    return (finishRequest);
  }

  /**
   * Re-populates the Http Request with its old attributes for when a page is redisplayed.
   *
   * @param request the Http Request
   * @throws ServletException if anything goes wrong
   */
  public static void reinstateRequestAttributes(HttpServletRequest request) throws ServletException {
    String encodedRequestAttributes = request.getParameter(RequestAttributes.FORM_ATTRIBUTES_REQUEST_PARAM);
    boolean formHasAttributes = encodedRequestAttributes != null;

    if (formHasAttributes) {
      GrndsTrace.msg(TRACE_TAG, 7, "encoded attributes obtained from request");
      RequestAttributes requestAttributes = new RequestAttributes();
      requestAttributes.decodeRequestAttributes(encodedRequestAttributes);
      requestAttributes.restoreRequestAttributesToRequest(request);
      GrndsTrace.msg(TRACE_TAG, 7, "attributes decoded and set back to request");
    }

  }

  /**
   * Redisplays the page that sent the request. This is used by the form validation component to execute the
   * presentation without executing the activity if a form needs to be re-displayed.
   *
   * @param ctx The GrndsExchangeContext
   */
  void redisplayPage(GrndsExchangeContext ctx) throws IOException, ServletException {
    GrndsTrace.enterScope(TRACE_TAG + "redisplayPage");

    GrndsHttpConversation conversation = super.getConversation(ctx);
    HttpServletRequest request = ctx.getRequest();

    String command = super.getRequestQName(request).getLocal();

    conversation.beginResponse(ctx);
    super.executePresentation(conversation, command, ctx);
    conversation.endResponse(ctx);

    GrndsTrace.exitScope();

  }

  /**
   * This is used by the form validation component to perform the 'action' of the form once the form has been validated.
   * It forwards the request to the url specified by the action.
   *
   * @param ctx The GrndsExchangeContext context
   */
  void performAction(GrndsExchangeContext ctx) throws IOException, ServletException {
    GrndsTrace.enterScope(TRACE_TAG + "performAction");

    HttpServletRequest request = ctx.getRequest();
    HttpServletResponse response = ctx.getResponse();

    //remove grnds conversation and command info from the request
    request.removeAttribute(ServerSideValidationUtility.GRNDS_QNAME_ATTRIBUTE);

    //forward
    String nextUrl = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_URL);
    GrndsTrace.msg(TRACE_TAG, 7, "forwarding to " + nextUrl);
    Monitor monitor = MonitorFactory.start(nextUrl);
    try {
      RequestDispatcher dispatcher = request.getRequestDispatcher(nextUrl);
      dispatcher.forward(request, response);
    } finally {
      monitor.stop();
      GrndsTrace.exitScope();
    }
  }

  @SuppressWarnings({"unchecked"})
  Set getRequestParamNames(HttpServletRequest request) {
    GrndsTrace.enterScope(BasePrsHttpServlet.TRACE_TAG + ".getRequestParams");
    Set parameterNames = new HashSet(request.getParameterMap().keySet());
    parameterNames.remove(ServerSideValidationUtility.FORM_VALIDATION_DEFINITION);
    parameterNames.remove(ServerSideValidationUtility.FORM_VALIDATION_FLAG);
    parameterNames.remove(ServerSideValidationUtility.FORM_VALIDATION_URL);
    GrndsTrace.exitScope( /*parameters*/);
    return parameterNames;
  }

  /** This method creates a Validator object from a schema parameter in the request. */
  public Validator getValidator(HttpServletRequest request) throws ServletException {
    GrndsTrace.enterScope(TRACE_TAG + ".getValidator()");
    String schemaUrl = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_DEFINITION);
    ServletContext context = super.getServletContext();
    Validator result;
    try {
      URL url = ServerSideValidationUtility.locateResource(context, schemaUrl);
      result = Validator.getInstance(url);
    } catch (Exception e) {
      throw new ServletException("Unable to create Validator object", e);
    }
    GrndsTrace.exitScope();
    return result;
  }

  /**
   * Executes the activity portion of the exchange response.
   *
   * @param conv_ GrndsHttpConversation
   * @param cmd_  java.lang.String
   * @param ctx_  GrndsExchangeContext
   * @throws javax.servlet.ServletException
   * @throws java.io.IOException
   */
  protected void executeActivity(GrndsHttpConversation conv_, String cmd_, GrndsExchangeContext ctx_)
          throws ServletException, IOException {
    GrndsTrace.enterScope("BasePrsHttpServlet.executeActivity(local)");
    GrndsExchangeActivity grndsExchangeActivity = conv_.getExchangeActivity(cmd_, ctx_);
    Monitor monitor = MonitorFactory.start(grndsExchangeActivity != null ?
                                           grndsExchangeActivity.toString() : "no-grnds-activity");
    try {
      super.executeActivity(conv_, cmd_, ctx_);
    } finally {
      monitor.stop();
      GrndsTrace.exitScope();
    }
  }

  /**
   * Executes the presentation portion of the exchange response.
   *
   * @param conv_ GrndsHttpConversation
   * @param cmd_  java.lang.String
   * @param ctx_  GrndsExchangeContext
   * @throws javax.servlet.ServletException
   * @throws java.io.IOException
   */
  protected void executePresentation(GrndsHttpConversation conv_, String cmd_, GrndsExchangeContext ctx_)
          throws ServletException, IOException {
    GrndsTrace.enterScope("GrndsHttpServlet.executePresentation()");
    boolean doForward = false; // don't forward by default
    // Need to check to see if the response has been committed before we forward.
    if (ctx_.getResponse().isCommitted()) {
      // Execute the presentation, even if the response has been committed,
      //    for include presentations only.
      GrndsExchangePresentation p;
      try {
        p = conv_.getExchangePresentation(cmd_, ctx_);
        if (p instanceof IncludePresentation) {
          // forward for include presentations
          doForward = true;
        }
      } catch (GrndsUnrecognizedRequestException e) {
        // Fail silently on errors producing the presentation because
        //   we don't want to throw an exception if the request has
        //   been forwarded and there is no prsentation.
      }
    } else {
      doForward = true;
    }

    if (doForward) {
      super.executePresentation(conv_, cmd_, ctx_);
    }

    GrndsTrace.exitScope();
  }
}
