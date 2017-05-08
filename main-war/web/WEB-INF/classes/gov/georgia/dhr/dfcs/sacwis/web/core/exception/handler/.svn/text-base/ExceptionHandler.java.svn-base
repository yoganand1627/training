package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.StateException;

import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJBException;
import javax.servlet.ServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This class provides static methods for handling and presenting exceptions.  It will do a lookup of the best handler
 * to use for the specific exception, and then call the handle() method on that handler.
 */
public class ExceptionHandler {
  private static final String EXCEPTION_HANDLER_CLASS_NAME = ExceptionHandler.class.getName();
  private static final String EXCEPTION_HANDLER_PACKAGE_NAME =
          EXCEPTION_HANDLER_CLASS_NAME.substring(0, EXCEPTION_HANDLER_CLASS_NAME.lastIndexOf(".") + 1);

  private static final String HANDLER = "Handler";
  private static final String TRACE_TAG = ExceptionHandler.class.getSimpleName(); //for tracing

  public static final String ERROR_URL_REQUEST_ATTRIBUTE = "exception.url";
  public static final String ERROR_MESSAGE_REQUEST_ATTRIBUTE = "exception.msg";

  public static final String GLOBAL_EXCEPTION_LOGGER =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "exception.globalLogger");

  // Used to speed the lookup of exception handler classes.
  private static final Map<Class, Class> exceptionHandlerClassMap = new HashMap<Class, Class>();
  private static final Map<Class, Constructor> exceptionHandlerConstructorMap = new HashMap<Class, Constructor>();

  /**
   * This method will perform generic exception handling by finding the generic handler for this class (or one of its
   * parent classes).  It will then call handle() on the generic handler that it finds.
   *
   * @param throwable The exception object to be handled
   */
  public static SpecificExceptionHandler handle(Throwable throwable) {
    if (throwable == null) {
      // Create an exception for nulls so we do not cause another exception.
      String msg = "Null throwable passed to " + TRACE_TAG + ".";
      //noinspection ThrowableInstanceNeverThrown
      IllegalArgumentException e = new IllegalArgumentException(msg);
      logInternalException(msg, e);
      // Do nothing with the exception.
      return new NullExceptionHandler(e);
    }
    SpecificExceptionHandler specificHandler = loadExceptionHandler(throwable);
    specificHandler.handle();
    return specificHandler;
  }

  /**
   * This method gets the class of the exception that was thrown and calls the findSpecificHandler() method.
   *
   * @param throwable The exception object being handled
   * @return PrsExceptionHandler a class implementing the PrsExceptionHandler interface
   */
  static SpecificExceptionHandler loadExceptionHandler(Throwable throwable) {
    GrndsTrace.enterScope(TRACE_TAG + ".loadExceptionHandler");
    Throwable processedThrowable = processThrowable(throwable);
    SpecificExceptionHandler specificExceptionHandler;
    try {
      if (processedThrowable != null) {
        Class processedThrowableClass;
        Class specificExceptionHandlerClass;
        processedThrowableClass = processedThrowable.getClass();
        specificExceptionHandlerClass = exceptionHandlerClassMap.get(processedThrowableClass);
        if (specificExceptionHandlerClass == null) {
          specificExceptionHandlerClass = findSpecificHandlerClass(processedThrowableClass);
          // Cache the result, as it will never change.
          exceptionHandlerClassMap.put(processedThrowableClass, specificExceptionHandlerClass);
        }
        // Instantiate the class that we just found; we can assume that we always find a class because of the
        //   combination of the NonPrsExceptionWrapper and the NullExceptionHandler classes.
        Constructor exceptionHandlerConstructor = exceptionHandlerConstructorMap.get(specificExceptionHandlerClass);
        if (exceptionHandlerConstructor == null) {
          // Loop through the existing constructors to look for one with
          Constructor[] constructors = specificExceptionHandlerClass.getDeclaredConstructors();
          for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(processedThrowableClass)) {
              exceptionHandlerConstructor = constructor;
              // we're done
              break;
            }
          }
          // If we get here and there was no result; use the default constructor instead;
          //   this will throw an exception if there is no default constructor, but that
          //   is good, as we can't do anything, anyway, in that case.
          exceptionHandlerConstructor = exceptionHandlerConstructor == null
                                        ? specificExceptionHandlerClass.getConstructor()
                                        : exceptionHandlerConstructor;
          // Cache the result
          exceptionHandlerConstructorMap.put(specificExceptionHandlerClass, exceptionHandlerConstructor);
        }
        if (exceptionHandlerConstructor.getParameterTypes().length == 1) {
          specificExceptionHandler =
                  (SpecificExceptionHandler) exceptionHandlerConstructor.newInstance(processedThrowable);
        } else {
          // If there is no such constructor, attempt to instantiate the class with the default constructor
          specificExceptionHandler = (SpecificExceptionHandler) specificExceptionHandlerClass.newInstance();
        }
      } else {
        // If processThrowable returns a null exception use the NullExceptionHandler becuase it means that we neither
        //   want to log nor present this exception.
        specificExceptionHandler = new NullExceptionHandler(throwable);
      }
    }
    catch (Throwable internalThrowable) {
      logInternalException("Error finding or instantiating Handler class.", internalThrowable);
      // Return a null handler to prevent causing another exception after we return.
      specificExceptionHandler = new NullExceptionHandler(throwable);
    }
    GrndsTrace.exitScope();
    return specificExceptionHandler;
  }

  private static Throwable processThrowable(Throwable throwable) {
    Throwable processedThrowable;
    // A HashSet that is used to get causes recurisvely.
    Set<Throwable> throwableSet = new HashSet<Throwable>();
    if (throwable instanceof BasePrsException || throwable instanceof ServiceException) {
      // Note that this is done both in this method and loadExceptionHandler(); this is not ideal, but it will gurantee
      //   that the exception does not get wrapped seperately in handle() and presentErrorMessage(), as doing so
      //   results in two different unique id's being generated, one in the log and one that is presented to the user;
      //   obviously, this double-generation would make the unique id effectively useless.
      processedThrowable = throwable;
    } else if (throwable instanceof StateException) {
      // These are processed in StateExceptionHandler; we must check for these because we do not want to unwrap them
      //   below and unlike all other exceptions with their own subclass of SpecificExceptionHandler, StateException's
      //   are a subclass of BasePrsRuntimeException, not BasePrsException.
      processedThrowable = throwable;
    } else if (recurisiveCauseTypeCheck(throwable, SocketException.class, throwableSet)) {
      // Attempt to eliminate reporting of SocketExceptions, as they are caused every time the user stops the current
      //   request (e.g. clicks in another place, closes the browser, presses back, or presses stop) before it
      //   completes, so it's impossible to display anything, anyway. Note that getCause() works for both JspException
      //   and ServletException, as well as several other exceptions.  Therefore, doing this single check should catch
      //   the bulk of exceptions that are wrapped.

      // Deliberately assign to null to stop processing
      //noinspection AssignmentToNull
      processedThrowable = null;
    } else if (recurisiveCauseTypeCheck(throwable, SocketTimeoutException.class, throwableSet)) {
      // Capture SocketTimeoutExceptions and wrap them as StateExceptions so they are displayed by going directly to an
      //   error JSP.  This garauntees that the request will end and not go into a recursive loop.
      SocketTimeoutException socketTimeoutException = (SocketTimeoutException) throwableSet.iterator().next();
      //noinspection ThrowableInstanceNeverThrown
      processedThrowable = new StateException("SocketTimeoutException caught.",
                                              socketTimeoutException, BasePrsException.WARNING_PRIORITY);
    } else if (recurisiveCauseTypeCheck(throwable, StreamCorruptedException.class, throwableSet)) {
      // Generally, StreamCorruptedException will be caught when processing state and automatically be wrapped in a
      //   StateException becuase of the relative size of state compared to the request.  However, occassionally, this
      //   error happens elsewhere.  Because the message displayed is sufficiently generic, wrap the throwable in a
      //   StateException, which will result in the correct processing instructions.  Do the check recursively.
      StreamCorruptedException streamCorruptedException = (StreamCorruptedException) throwableSet.iterator().next();
      //noinspection ThrowableInstanceNeverThrown
      processedThrowable = new StateException("StreamCorruptedException caught outside of state deserialization.",
                                              streamCorruptedException, BasePrsException.WARNING_PRIORITY);
    } else if (throwable instanceof RemoteException || throwable instanceof RuntimeWrappedException ||
               throwable instanceof EJBException) {
      // These exceptions wrap their causes but really add no information to either the user or developer, so remove
      //   them whenever we don't encounter a more specific condition above.
      Set<Throwable> unwrappedSet = new HashSet<Throwable>();
      processedThrowable = throwable;
      Throwable cause = processedThrowable.getCause();
      // This unwrapping is done until we reach a non-RuntimeWrappedException AND non-RemoteException case.
      while (cause != null && !unwrappedSet.contains(cause) &&
             (processedThrowable instanceof RuntimeWrappedException ||
              processedThrowable instanceof RemoteException)) {
        unwrappedSet.add(processedThrowable);
        processedThrowable = cause;
        cause = processedThrowable.getCause();
      }
    } else {
      // Return the raw exception.
      processedThrowable = throwable;
    }
    return processedThrowable;
  }

  static Class findSpecificHandlerClass(Class exceptionClass) {
    GrndsTrace.enterScope(TRACE_TAG + ".findSpecificHandlerClass");
    // The name of the exception handler should be the name of the exception + "Handler"
    String exceptionHandlerName = exceptionClass.getName() + HANDLER;
    Class specificExceptionHandlerClass = null;
    try {
      if("java.lang".equals(exceptionClass.getPackage().getName())) {
        specificExceptionHandlerClass = NonPrsExceptionHandler.class;
      } else {
        specificExceptionHandlerClass = Class.forName(exceptionHandlerName);
      }
    }
    catch (ClassNotFoundException cnfe1) {
      // Handler classes often must be in the web package becuase they modify the display of messages; search the
      //   the package containing this class for handlers that cannot be located with their exceptions.
      try {
        exceptionHandlerName = EXCEPTION_HANDLER_PACKAGE_NAME + exceptionClass.getSimpleName() + HANDLER;
        specificExceptionHandlerClass = Class.forName(exceptionHandlerName);
      }
      catch (ClassNotFoundException cnfe2) {
        // Since there is no handler for this class, get the name of the parent of this exception
        Class exceptionSuperClass = exceptionClass.getSuperclass();

        // Attempt to load the parent class's exception handler.  This method is recursive and will continue until it
        //   finds a match or reaches the Object class (becuase Object.getSuperClass == null); in the case that it
        //   reaches the object class, it will return the NonPrsExceptionHandler class.
        specificExceptionHandlerClass = exceptionSuperClass != null ? findSpecificHandlerClass(exceptionSuperClass) :
                                        NonPrsExceptionHandler.class;
      }
    }
    catch (Throwable throwable) {
      logInternalException("Unexpected exception in the exception handling framework while " +
                           "obtaining the specific handler", throwable);
    }
    GrndsTrace.exitScope();
    return specificExceptionHandlerClass;
  }

  /**
   * This method is designed to check of the presence of an exception of a specific type in the exception cause stack.
   *
   * @param throwable         The throwable to check.
   * @param throwableType     The class object for which this method is searching in the exception stack.
   * @param visitedThrowables This set is used to prevent cyclcal recursion in the case that there is a cycle in the
   *                          exception causes (should never happen); the method assumes that the set is empty when it
   *                          is first called; if a match is found, this set will have a single throwable object when
   *                          the method returns; otherwise, it will be empty.
   * @return The exception of the requested type if it is found; otherwise null.
   */
  public static boolean recurisiveCauseTypeCheck(Throwable throwable, Class throwableType,
                                                 Set<Throwable> visitedThrowables) {
    if (throwable == null) {
      // Clear the set before returning so it can be reused.
      visitedThrowables.clear();
      return false;
    } else if (throwable.getClass().isAssignableFrom(throwableType)) {
      // Clear the set before returning so it can be reused.
      visitedThrowables.clear();
      // Add the found throwable to match the contract in the Javadoc.
      visitedThrowables.add(throwable);
      return true;
    } else {
      Throwable cause = throwable.getCause();
      if (!visitedThrowables.contains(cause)) {
        // Add the current throwable to the set to prevent checking the same exception twice.
        visitedThrowables.add(cause);
        // Check the next level deep; the null check is done in the next method call.
        return recurisiveCauseTypeCheck(cause, throwableType, visitedThrowables);
      } else {
        // Clear the set before returning so it can be reused.
        visitedThrowables.clear();
        return false;
      }
    }
  }

  /**
   * This method will return true if the path of execution has been set to present an exception.  It can be used in
   * conversation classes to discern whether or not logic should be processed following a possible exception.
   *
   * @param context the GrndsExchangeContext to check.
   */
  public static boolean hasExceptionToPresent(GrndsExchangeContext context) {
    ServletRequest request = context.getRequest();
    return (request.getAttribute(ExceptionHandler.ERROR_URL_REQUEST_ATTRIBUTE) != null);
  }

  static void logInternalException(String message, Throwable e) {
    GrndsLogger globalExceptionLogger = GrndsLogger.getLogger(ExceptionHandler.GLOBAL_EXCEPTION_LOGGER);
    globalExceptionLogger.log(GrndsLevel.CRITICAL, message, e);
  }

  public static String getStackTraceHTML(Throwable throwable) {
    return "<pre>" + getStackTrace(throwable) + "</pre>";
  }

  public static String getStackTrace(Throwable throwable) {
    PrintWriter pw = null;
    try {
      StringWriter sw = new StringWriter();
      pw = new PrintWriter(sw);
      throwable.printStackTrace(pw);
      return sw.toString();
    }
    catch (Throwable e) {
      return "No stack trace available.";
    }
    finally {
      if (pw != null) {
        pw.close();
      }
    }
  }
}
