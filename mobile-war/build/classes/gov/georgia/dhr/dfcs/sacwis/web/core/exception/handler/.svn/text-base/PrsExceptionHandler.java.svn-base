package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsBasicHttpConversation;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.NonPrsExceptionWrapper;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLogRecord;
import gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging.ImpactExceptionLoggingUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

/**
 * This is the base exception handler for all PRS exceptions.  It will be called to perform generic exception handling
 * for any exception that subclasses BasePrsException and does not have a more specific handler in its class hierarchy.
 */
public class PrsExceptionHandler implements SpecificExceptionHandler {
  /** The basePrsException that is being handled. */
  private PrsException prsException;

  /** The logger to use. */
  private GrndsLogger globalExceptionLogger;

  private static final String TRACE_TAG = "PrsExceptionHandler"; //for tracing
  public static final String BASE_PRS_EXCEPTION_LOG_RECORD_KEY = TRACE_TAG + "_BASE_PRS_EXCEPTION_LOG_RECORD_KEY";
  public static final String BASE_PRS_EXCEPTION_LOG_RECORD_INDEX_KEY =
          TRACE_TAG + "BASE_PRS_EXCEPTION_LOG_RECORD_INDEX_KEY";
  public static final String BASE_ERROR_URL =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "exception.defaultPage");

  /**
   * Users should not create their own instances of the handler.  This class will be created and managed by the
   * ExceptionHandler class.
   */
  public PrsExceptionHandler(Throwable throwable) {
    if (throwable instanceof PrsException) {
      this.prsException = (PrsException) throwable;
    } else {
      this.prsException = new NonPrsExceptionWrapper("NonPrsExceptionWrapper wrapping: " + throwable.getClass(),
                                                     throwable, BasePrsException.WARNING_PRIORITY);
    }
  }

  /**
   * This generic method will handle the exception.  If the exception is high priority, it will be logged to the
   * exception log.
   */
  public void handle() {
    GrndsTrace.enterScope(TRACE_TAG + ".handle");
    log(prsException);
    GrndsTrace.exitScope();
  }

  /**
   * This method will store the exception to be displayed in the HttpServletRequest and forward to a JSP that will get
   * the message from the request and display it to the user.
   *
   * @param context The message will be stored to the context so that it can be diplayed by the presentation JSP
   */
  public void presentErrorMessage(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".presentErrorMessage");
    try {
      HttpServletRequest request = context.getRequest();
      // Remove any presentation branch that has already been set
      request.removeAttribute(GrndsBasicHttpConversation.COMMAND_BRANCH_ATTRIBUTE);
      // Put the exception itself in the request
      request.setAttribute(SpecificExceptionHandler.EXCEPTION_REQUEST_LOOKUP, prsException);
      // Set the error URL so that the decoration framework knows to show the error page
      request.setAttribute(ExceptionHandler.ERROR_URL_REQUEST_ATTRIBUTE, BASE_ERROR_URL);
      // Skip vlaidation by forcing the form to be valid
      request.setAttribute(ServerSideValidationUtility.FORM_VALIDATION_FORCE_VALID_FLAG, ArchitectureConstants.TRUE);
      // Create the exception record and put it or its key in the request, as appropriate
      ImpactExceptionLogRecord record = ImpactExceptionLoggingUtility.createLogRecord(request, prsException);
      if (record.isWritten()) {
        request.setAttribute(BASE_PRS_EXCEPTION_LOG_RECORD_INDEX_KEY, String.valueOf(record.getIdError()));
      } else {
        // Don't bother putting it in the request if it's already been logged
        request.setAttribute(BASE_PRS_EXCEPTION_LOG_RECORD_KEY, record);
      }
      // Forward the conversation
      BasePrsConversation.forwardSafe(BASE_ERROR_URL, request, context.getResponse());
    } catch (Throwable t) {
      //because otherwise we lose what exception triggered this chain of events
      //noinspection CallToPrintStackTrace
      ((Throwable) prsException).printStackTrace();
      throw new RuntimeWrappedException(t);
    }
    GrndsTrace.exitScope();
  }

  /**
   * This method logs a message to the global exception logger with a priority.
   *
   * @param e The exception
   */
  protected void log(PrsException e) {
    String message = e.getMessage();
    int priority = e.getPriorityLevel();
    prepareLogger();
    globalExceptionLogger.log(this.translateExceptionPriority(priority), getUniqueIdString(e) + message, (Throwable) e);
  }

  /**
   * This method logs a CRITICAL message to the global exception logger if an exception occurred while trying to handle
   * an exception (the framework has failed).
   *
   * @param e   The internal exception that occurred
   * @param bce The exception that the framework was attempting to handle
   */
  protected void logInternalError(Throwable e, BasePrsException bce) {
    String message = "Internal error during exception handling prevented the display of unique exception: "
                     + getUniqueIdString(bce);

    prepareLogger();
    globalExceptionLogger.log(GrndsLevel.CRITICAL, message, e);
  }

  /**
   * This method gets the UniqueId value from the exception and formats it in a standard way for logging.
   *
   * @param e The exception that will be logged
   * @return String the exception's UniqueId, formatted specifically to be logged
   */
  protected String getUniqueIdString(PrsException e) {
    return ("ExceptionId#" + e.getUniqueId() + ": ");
  }

  /**
   * This method translates an exception priority to a logging priority.
   *
   * @param exceptionPriority The exception priority to translate
   * @return GrndsLevel The GRNDS logging priority that maps to the exception priority.
   */
  protected GrndsLevel translateExceptionPriority(int exceptionPriority) {
    GrndsLevel level = GrndsLevel.INFO;

    if (exceptionPriority == BasePrsException.CRITICAL_PRIORITY) {
      level = GrndsLevel.CRITICAL;
    } else if (exceptionPriority == BasePrsException.WARNING_PRIORITY) {
      level = GrndsLevel.WARNING;
    }

    return level;
  }

  /** This method sets the reference to the global exception logger if it currently doesn't exist. */
  void prepareLogger() {
    if (globalExceptionLogger == null) {
      globalExceptionLogger = GrndsLogger.getLogger(ExceptionHandler.GLOBAL_EXCEPTION_LOGGER);
    }
  }

  public Throwable getThrowable() {
    return (Throwable) prsException;
  }

  public void setThrowable(Throwable throwable) {
    this.prsException = (BasePrsException) throwable;
  }
}
