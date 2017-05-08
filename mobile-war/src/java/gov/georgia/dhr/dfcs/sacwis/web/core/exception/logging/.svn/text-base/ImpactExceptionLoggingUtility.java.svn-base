package gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.grnds.facility.config.GrndsConfiguration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.NonPrsExceptionWrapper;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/** User: mkw Date: Sep 22, 2003 Time: 9:05:57 AM */
public class ImpactExceptionLoggingUtility {
  public static final String DETAILED_EXCEPTION_LOGGER =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                       "exception.detailedLogger");
  public static final String ERROR_LOGGING_DEFAULT =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                       "exception.detailedLogger.enabled");
  public static boolean ERROR_LOGGING_ENABLED = "true".equals(ERROR_LOGGING_DEFAULT);

  public static void logImpactExceptionLogRecord(ImpactExceptionLogRecord impactExceptionLogRecord) {
    try {
      if (!impactExceptionLogRecord.isWritten()) {
        Logger detailedExceptionLogger = Logger.getLogger(DETAILED_EXCEPTION_LOGGER);
        detailedExceptionLogger.log(impactExceptionLogRecord);
      }
    }
    catch (Throwable throwable) {
      // do nothing
    }
  }

  /**
   * The purpose of this method is to create a LogRecord with the appropriate information for logging with an instance
   * of java.util.logging.Logger.  Because record creation is relatively expensive, the record is <i>only</i> created if
   * it meets the current requirements for actually logging an exception.
   * <p/>
   * It creates an instance of ImpactExceptionLogRecord, which stores more information than its superclass,
   * java.util.logging.LogRecord.
   * <p/>
   * This method logs the following data: 1) All available information about the Throwable object 2) Request headers 3)
   * Request parameters 4) Request attributes 5) State Attributes 6) Global Data 7) Other State Context Parameters 8)
   * The UserProfile object 9) Other Session Data This information is encoded into the
   *
   * @param request
   * @param basePrsException
   * @return A {@link ImpactExceptionLogRecord} storing information about the exception.
   */
  public static ImpactExceptionLogRecord createLogRecord(HttpServletRequest request, PrsException basePrsException) {
    // Before we do anything, extract the actual exception if it was wrapped in a NonPrsExceptionWrapper()
    Throwable throwable = basePrsException instanceof NonPrsExceptionWrapper ?
                          ((Throwable) basePrsException).getCause() : (Throwable) basePrsException;
    ImpactExceptionLogRecord record = null;
    try {
      if (request != null && throwable != null) {
        if (request != null) {
          // Get the BaseSessionStateManager object
          BaseSessionStateManager state = BaseHiddenFieldStateConversation.getSessionStateManager(request);

          // Create the new ImpactExceptionLogRecord
          record = new ImpactExceptionLogRecord(Level.WARNING, throwable.getMessage());

          // Set the basePrsException that caused the error, not the throwable,
          //   because the unique id is stored in the basePrsException, and we
          //   don't want to lose it.
          record.setThrown((Throwable) basePrsException);

          // Make a best effort to find the Class, Method, and Line at which processSevereException() was called
          try {
            StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
            int stackTraceElementsLength = stackTraceElements.length;
            for (int i = 0; i < stackTraceElementsLength; i++) {
              StackTraceElement stackTraceElement = stackTraceElements[i];
              if ("gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation".equals(
                      stackTraceElement.getClassName())
                  && "processSevereException".equals(stackTraceElement.getMethodName())) {
                //noinspection AssignmentToForLoopParameter
                if (++i < stackTraceElementsLength) {
                  stackTraceElement = stackTraceElements[i];
                  record.setSourceClassName(stackTraceElement.getClassName());
                  record.setSourceMethodName(stackTraceElement.getMethodName());
                  record.setSourceFileName(stackTraceElement.getFileName());
                  record.setSourceLineNumber(stackTraceElement.getLineNumber());
                }
                break;
              }
            }
          }
          catch (Throwable t1) {
            // Do nothing
          }

          // Get the request headers
          Enumeration headerEnumeration = request.getHeaderNames();
          while (headerEnumeration.hasMoreElements()) {
            String name = (String) headerEnumeration.nextElement();
            record.addRequestHeader(name, request.getHeaders(name));
          }

          // Get the request parameters
          Enumeration requestParametersEnumeration = request.getParameterNames();
          while (requestParametersEnumeration.hasMoreElements()) {
            String name = (String) requestParametersEnumeration.nextElement();
            record.addRequestParameter(name, request.getParameterValues(name));
          }

          // Get the request attributes
          Enumeration requestAttributesEnumeration = request.getAttributeNames();
          while (requestAttributesEnumeration.hasMoreElements()) {
            String name = (String) requestAttributesEnumeration.nextElement();
            record.addRequestAttribute(name, request.getAttribute(name));
          }

          // Get the state attributes
          for (Iterator attributeNamesIterator = state.getAttributeNames(request);
               attributeNamesIterator.hasNext();) {
            String name = (String) attributeNamesIterator.next();
            record.addStateAttribute(name, state.getAttribute(name, request));
          }

          // Get GlobalData information (extra catch statements because reflection is risky)
          setGlobalDataInfo(request, record);

          // Get other state context parameters
          for (Iterator contextParametersIterator = state.getContextParameterNames(request);
               contextParametersIterator.hasNext();) {
            String name = (String) contextParametersIterator.next();
            record.addStateContextParameter(name, state.getContextParameter(name, request));
          }

          // Set the user into the log record
          UserProfile userProfile = UserProfileHelper.getUserProfile(request);
          record.setUser(userProfile);

          // Get other session data
          HttpSession session = request.getSession(false);
          if (session != null) {
            Enumeration sessionAttributesEnumeration = session.getAttributeNames();
            while (sessionAttributesEnumeration.hasMoreElements()) {
              String name = (String) sessionAttributesEnumeration.nextElement();
              record.addSessionAttribute(name, session.getAttribute(name));
            }
          }
          // Use the throwable directly, not the NonPrsExceptionWrapper (if it's a non-Prs exception),
          //   as that gives us better control on whether or not to log.
          if (isAutomaticallyLogged(request, throwable)) {
            ImpactExceptionLoggingUtility.logImpactExceptionLogRecord(record);
          }
        }
      }
    }
    catch (Throwable t4) {
      // Fail silently; this should never happen, and we do NOT want
      //   to throw any sort of exception when trying to log one.
    }
    return record;
  }

  private static void setGlobalDataInfo(HttpServletRequest request, ImpactExceptionLogRecord record) {
    try {
      Class globalDataClass = GlobalData.class;
      Method[] globalDataMethods = globalDataClass.getMethods();
      for (int i = 0; i < globalDataMethods.length; i++) {
        try {
          Method globalDataMethod = globalDataMethods[i];
          if (Modifier.isStatic(globalDataMethod.getModifiers())) {
            // filter out toString()
            String globalDataMethodName = globalDataMethod.getName();
            if (!"toString".equals(globalDataMethodName)) {
              Class returnType = globalDataMethod.getReturnType();
              if (returnType != null) {
                Class[] parameterTypes = globalDataMethod.getParameterTypes();
                if (parameterTypes.length == 1 && HttpServletRequest.class.equals(parameterTypes[0])) {
                  Object object = globalDataMethod.invoke(null, request);
                  // find the first upper-case letter in the method name
                  int globalDataMethodNameLength = globalDataMethodName.length();
                  int j;
                  for (j = 0; j < globalDataMethodNameLength; j++) {
                    char c = globalDataMethodName.charAt(j);
                    if (Character.isUpperCase(c)) {
                      break;
                    }
                  }
                  if (j < globalDataMethodNameLength - 1) {
                    record.addGlobalData(globalDataMethodName.substring(j, globalDataMethodNameLength),
                                         object);
                  } else {
                    record.addGlobalData(globalDataMethodName, object);
                  }
                }
              }
            }
          }
        }
        catch (Throwable t2) {
          // Do nothing
        }
      }
    }
    catch (Throwable t3) {
      // Do nothing
    }
  }

  @SuppressWarnings({"UnusedDeclaration"})
  public static boolean isAutomaticallyLogged(HttpServletRequest request, Throwable throwable) {
    // todo: make filter on user ids and exception types
    return ERROR_LOGGING_ENABLED;
  }

  /**
   * This method encodes a string to be XML-Safe (only handles <, >, and &, nothing else) and appends it to the
   * StringBuilder that is passed to it and returned.
   *
   * @param string The String to be encoded.
   * @param sb     The StringBuffer to which it should be appended.
   * @return The input buffer.
   */
  public static StringBuilder encodeForXml(String string, StringBuilder sb) {
    if (string != null) {
      int length = string.length();
      for (int i = 0; i < length; i++) {
        char c = string.charAt(i);
        switch (c) {
          case'<':
            sb.append("&lt;");
            break;
          case'>':
            sb.append("&gt;");
            break;
          case'&':
            sb.append("&amp;");
            break;
          default:
            sb.append(c);
        }
      }
    } else {
      sb.append("{null}");
    }
    return sb;
  }
}
