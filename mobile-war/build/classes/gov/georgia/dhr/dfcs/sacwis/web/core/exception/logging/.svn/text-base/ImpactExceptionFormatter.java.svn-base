package gov.georgia.dhr.dfcs.sacwis.web.core.exception.logging;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;

import org.grnds.foundation.exception.GrndsException;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.NonPrsExceptionWrapper;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.TempAssignment;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

/**
 * <pre>
 * Date        User      Description
 * --------    --------  --------------------------------------------------
 * 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 * </pre>
 */
public class ImpactExceptionFormatter extends Formatter {

  public static final String ROOT_ELEMENT_OPEN = "<impact_exception_record>";
  public static final String ROOT_ELEMENT_CLOSE = "</impact_exception_record>";

  public String format(LogRecord logRecord) {
    if (logRecord instanceof ImpactExceptionLogRecord) {
      ImpactExceptionLogRecord record = (ImpactExceptionLogRecord) logRecord;
      String formattedString;
      try {
        StringBuilder sb = new StringBuilder(8192); // an initial guess; most will probably be larger
        sb.append(ArchitectureConstants.XML_HEADER);
        sb.append(ROOT_ELEMENT_OPEN);

        // Log information about the log record
        formatLogRecordSummaryInfo(sb, record);

        // Get the exception; strip out the NonPrsExceptionWrapper if it's present;
        //   it's redundant information at this point, as the only reason that we
        //   have it is to get a unique ID.
        Throwable throwable = record.getThrown();
        throwable = throwable instanceof NonPrsExceptionWrapper ? throwable.getCause() : throwable;
        // Log the exception, looking recursively
        formatThrowableInfo(throwable, sb, new HashSet<Throwable>());

        // Log the user, if one is logged in currently
        formatUserInfo(record, sb);

        // Log the information that was stored into the parameters.
        formatLogRecordParameters(record, sb);

        sb.append(ROOT_ELEMENT_CLOSE);
        formattedString = sb.toString();
      }
      catch (Throwable throwable) {
        formattedString = ArchitectureConstants.XML_HEADER + ROOT_ELEMENT_OPEN
                          + "<error_formatting_log_record message=\"" + throwable.getMessage() + "\"/>"
                          + ROOT_ELEMENT_CLOSE;
      }
      return formattedString;
    } else {
      throw new UnsupportedOperationException(
              "ImpactExceptionFormatter requires an instance of ImpactExceptionLogRecord");
    }
  }

  /**
   * @param throwable
   * @param sb
   * @param loggedThrowables
   */
  private void formatThrowableInfo(Throwable throwable, StringBuilder sb, Set<Throwable> loggedThrowables) {
    if (throwable != null && !loggedThrowables.contains(throwable)) {
      // Add the throwable being logged to the current list of logged throwables to prevent recursive loops.
      loggedThrowables.add(throwable);

      // Output the header for this throwable
      sb.append("<throwable>");

      // Output the message for this throwable
      sb.append("<message>");
      ImpactExceptionLoggingUtility.encodeForXml(throwable.getMessage(), sb);
      sb.append("</message>");

      // Output the string representation of the throwable
      sb.append("<string>");
      ImpactExceptionLoggingUtility.encodeForXml(throwable.toString(), sb);
      sb.append("</string>");

      // Log any specific throwable information, looking recursively for causes
      Throwable cause;
      if (throwable instanceof ServiceException) {
        ServiceException serviceException = (ServiceException) throwable;

        // Log the unique id
        sb.append("<unique_id>");
        sb.append(serviceException.getUniqueId());
        sb.append("</unique_id>");

        // Log the error type
        sb.append("<error_type>");
        sb.append(serviceException.getErrorType());
        sb.append("</error_type>");

        // Log specific WtcException information
        sb.append("<error_code code=\"").append(serviceException.getErrorCode()).append("\">");
        ImpactExceptionLoggingUtility.encodeForXml(MessageLookup.getMessageByNumber(serviceException.getErrorCode()),
                                                   sb);
        sb.append("</error_code>");
        sb.append("<error_message>");
        ImpactExceptionLoggingUtility.encodeForXml(serviceException.getErrorMessage(), sb);
        sb.append("</error_message>");

        cause = serviceException.getCause();
      } else if (throwable instanceof BasePrsException) {
        BasePrsException basePrsException = (BasePrsException) throwable;

        // Log the unique id
        sb.append("<unique_id>");
        sb.append(basePrsException.getUniqueId());
        sb.append("</unique_id>");

        // Log the error type
        sb.append("<error_type>");
        sb.append(basePrsException.getErrorType());
        sb.append("</error_type>");

        cause = basePrsException.getCause();
      } else if (throwable instanceof GrndsException) {
        cause = ((GrndsException) throwable).getEnclosedError();
        if (cause == null) {
          cause = throwable.getCause();
        }
      } else if (throwable instanceof ServletException) {
        cause = ((ServletException) throwable).getRootCause();
        if (cause == null) {
          cause = throwable.getCause();
        }
      } else if (throwable instanceof JspException) {
        cause = ((JspException) throwable).getRootCause();
        if (cause == null) {
          cause = throwable.getCause();
        }
      } else {
        cause = throwable.getCause();
      }

      // Output the stack trace
      StackTraceElement[] stackTraceElements = throwable.getStackTrace();
      for (int i = 0; i < stackTraceElements.length; i++) {
        StackTraceElement stackTraceElement = stackTraceElements[i];
        sb.append("<stack_trace_element class=\"").append(stackTraceElement.getClassName());
        sb.append("\" method=\"").append(stackTraceElement.getMethodName());
        sb.append("\" file=\"").append(stackTraceElement.getFileName());
        sb.append("\" line=\"").append(stackTraceElement.getLineNumber());
        sb.append("\"/>");
      }

      formatThrowableInfo(cause, sb, loggedThrowables);

      // output the trailer here so we get nested throwable elements
      sb.append("</throwable>");
    }
  }

  private void formatLogRecordParameters(ImpactExceptionLogRecord record, StringBuilder sb) {
    try {
      Object[] parameters = record.getParameters();
      if (parameters.length > 0) {
        sb.append("<request_information>");
        for (int i = 0; i < parameters.length; i++) {
          try {
            // These are all XML fragments, so they do not need any additional processing.
            sb.append(parameters[i]);
          }
          catch (Throwable t3) {
            // Do nothing
          }
        }
        sb.append("</request_information>");
      }
    }
    catch (Throwable t4) {
      // Do nothing
    }
  }

  private void formatUserInfo(ImpactExceptionLogRecord record, StringBuilder sb) {
    UserProfile user = record.getUser();
    if (user != null) {
      sb.append("<user>");
      try {
        Class userProfileClass = UserProfile.class;
        Method[] userProfileMethods = userProfileClass.getMethods();
        for (int i = 0; i < userProfileMethods.length; i++) {
          try {
            Method userProfileMethod = userProfileMethods[i];
            String userProfileMethodName = userProfileMethod.getName();
            // Handle the temporary assignments specially
            if ("getTempAssignments".equals(userProfileMethodName)) {
              List tempAssignments = user.getTempAssignments();
              for (Iterator iterator = tempAssignments.iterator(); iterator.hasNext();) {
                TempAssignment tempAssignment = (TempAssignment) iterator.next();
                sb.append("<temp_assignment>");
                sb.append("<designator_id>");
                ImpactExceptionLoggingUtility.encodeForXml(tempAssignment.getTempDesignatorID(), sb);
                sb.append("</designator_id>");
                sb.append("<exp_date>");
                ImpactExceptionLoggingUtility.encodeForXml(String.valueOf(tempAssignment.getTempExpDate()), sb);
                sb.append("</exp_date>");
                sb.append("<funciton>");
                ImpactExceptionLoggingUtility.encodeForXml(tempAssignment.getTempFunction(), sb);
                sb.append("</funciton>");
                sb.append("<security_class>");
                ImpactExceptionLoggingUtility.encodeForXml(tempAssignment.getTempSecurityClass(), sb);
                sb.append("</security_class>");
                sb.append("</temp_assignment>");
              }
            } else if (userProfileMethodName != null && userProfileMethodName.startsWith("get")) {
              // use only no-arg get methods to create the xml representation
              Class[] parameterTypes = userProfileMethod.getParameterTypes();
              if (parameterTypes.length == 0) {
                // get only methods that are actually declared in the UserProfile class,
                //   as it in herits from java.lang.Object
                //noinspection ObjectEquality
                if (userProfileMethod.getDeclaringClass() == UserProfile.class) {
                  Object result = userProfileMethod.invoke(user);
                  int userProfileMethodNameLength = userProfileMethodName.length();
                  String tag = userProfileMethodNameLength > 3
                               ? userProfileMethodName.substring(3, userProfileMethodNameLength) : "get";
                  sb.append("<").append(tag).append(">");
                  ImpactExceptionLoggingUtility.encodeForXml(String.valueOf(result), sb);
                  sb.append("</").append(tag).append(">");
                }
              }
            }
          }
          catch (Throwable t1) {
            // Do nothing
          }
        }
      }
      catch (Throwable t2) {
        // Do nothing
      }
      sb.append("</user>");
    }
  }

  private void formatLogRecordSummaryInfo(StringBuilder sb, ImpactExceptionLogRecord record) {
    sb.append("<impact_exception_log_record>");
    sb.append("<message>");
    ImpactExceptionLoggingUtility.encodeForXml(record.getMessage(), sb);
    sb.append("</message>");
    sb.append("<time_stamp>");
    sb.append(FormattingHelper.formatDate(new Date(record.getMillis())));
    sb.append("</time_stamp>");
    sb.append("<source_class_name>");
    sb.append(record.getSourceClassName());
    sb.append("</source_class_name>");
    sb.append("<source_method_name>");
    sb.append(record.getSourceMethodName());
    sb.append("</source_method_name>");
    sb.append("<source_file_name>");
    sb.append(record.getSourceFileName());
    sb.append("</source_file_name>");
    sb.append("<source_line_number>");
    sb.append(record.getSourceLineNumber());
    sb.append("</source_line_number>");
    sb.append("<thread_id>");
    sb.append(record.getThreadID());
    sb.append("</thread_id>");
    sb.append("<sequence_number>");
    sb.append(record.getSequenceNumber());
    sb.append("</sequence_number>");
    sb.append("</impact_exception_log_record>");
  }
}
