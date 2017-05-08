package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Base64;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;

/**
 * The ServerSideValidationUtility contains methods to facilitate server side validation performed by the custom form
 * tag.
 *
 * @author Kelly J. Mayes
 */
public class ServerSideValidationUtility {
  public static final String ERROR = "Error";
  public static final String INFO = "Info";
  public static final String FORM_VALIDATION_FLAG = "FormValidationFlag";
  public static final String FORM_VALIDATION_FORCE_VALID_FLAG = "FormValidationForceValidFlag";
  public static final String FORM_VALIDATION_URL = "FormValidationUrl";
  public static final String FORM_VALIDATION_CANCEL = "FormValidationCancel";
  public static final String FORM_VALIDATION_DEFINITION = "FormValidationSchema";
  public static final String FORM_VALIDATION_NUM_SUBMITS = "FormValidationNumSubmits";
  public static final String FORM_VALIDATION_PREV_URL = "FormValidationPrevUrl";
  public static final String REFRESH_WIDGETS_FROM_REQUEST = "RefreshWidgetsFromRequest";
  public static final String GRNDS_QNAME_ATTRIBUTE = "grnds.request.qname";
  private static final String TRACE_TAG = "ServerSidevalidationUtility";

  /**
   * This method creates HTML that adds hidden fields to the HTML Form. The hidden fields are used by the CivHttpServlet
   * to locate the FormValidation object stored in the session and to redisplay the page that generated that form.
   *
   * @param formData          the serialized form validation object
   * @param nextUrl           the url of the form action given in the JSP
   * @param schemaUrl         the locationof the constraints schema
   * @param requestAttributes the serialized attributes from the request
   * @return String a String containing the HTML to create the hidden fields
   */
  public static String createHiddenFields(String formData, String nextUrl, String schemaUrl, String requestAttributes,
                                          int numberTimesSubmited, String thisUrl) {
    GrndsTrace.enterScope(TRACE_TAG + ".createHiddenFields");

    StringBuffer buffer = new StringBuffer();
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(FORM_VALIDATION_FLAG);
    buffer.append("\" value=\"");
    buffer.append(formData);
    buffer.append("\"> ");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(FORM_VALIDATION_URL);
    buffer.append("\" value=\"");
    buffer.append(nextUrl);
    buffer.append("\"> ");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(FORM_VALIDATION_DEFINITION);
    buffer.append("\" value=\"");
    buffer.append(schemaUrl);
    buffer.append("\"> ");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(FORM_VALIDATION_CANCEL);
    buffer.append("\" value=\"\" > ");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(RequestAttributes.FORM_ATTRIBUTES_REQUEST_PARAM);
    buffer.append("\" value=\"");
    buffer.append(requestAttributes);
    buffer.append("\" >");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(ServerSideValidationUtility.FORM_VALIDATION_NUM_SUBMITS);
    buffer.append("\" value=\"");
    buffer.append(numberTimesSubmited);
    buffer.append("\" >");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(ServerSideValidationUtility.FORM_VALIDATION_PREV_URL);
    buffer.append("\" value=\"");
    buffer.append(thisUrl);
    buffer.append("\" >");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * This method returns the GRNDS conversation and command name used to genreate this page.
   *
   * @param request the request that generated this page. Grnds keeps attributes in the request to help reconstruct the
   *                url.
   * @return String a String the GRNDS conversation and command name.
   */
  public static String createThisUrl(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + ".createThisUrl");

    //String deployment = DEPLOYMENT_NAME;
    //BEE - Only use conversation and command
    //String servlet = (String)request.getAttribute( GrndsExchangeContext.SERVLET_MAPPING_REQ_ATTRIB );
    String conversation = (String) request.getAttribute(GrndsExchangeContext.CONVERSATION_REQ_ATTRIB);
    String command = (String) request.getAttribute(GrndsExchangeContext.COMAMAND_REQ_ATTRIB);
    String query = request.getQueryString();
    //BEE - Only use conversation and command
    //String thisUrl = "/" + deployment + "/" + servlet + "/" + conversation + "/" + command;
    //String thisUrl = "/" + servlet + "/" + conversation + "/" + command;
    String thisUrl = "/" + conversation + "/" + command;

    //Remove hiddenField from URL if its on there.  hiddenField should never be on the URL
    if (query != null) {
      query = removeHiddenField(query);
      thisUrl.concat("?");
      thisUrl.concat(query);
    }

    GrndsTrace.exitScope( /*thisUrl*/);
    return thisUrl;
  }

  /**
   * This method removes the "hiddenField" parameter from the url.
   *
   * @param query current query string
   * @return String query string without "hiddenfield=somevalue"
   */
  static String removeHiddenField(String query) {
    GrndsTrace.enterScope(TRACE_TAG + ".removeHiddenField( " + query + ")");
    // hiddenField=&hiddenField=test
    int startIndex = query.indexOf(
            HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
    int firstAmpersand = query.indexOf("&");
    int ampersandAfterHiddenField = query.indexOf("&", startIndex);

    if (startIndex >= 0) {

      //handle case with hiddenField=something&param=value
      if (startIndex == 0 && firstAmpersand > 0) {
        query = query.substring(firstAmpersand + 1);
      }

      //handle case with hiddenField=something
      else if (startIndex == 0) {
        query = "";
      }

      //handle case with param1=value&hiddenField=something&param2=value
      else if (ampersandAfterHiddenField > 0) {
        query = query.substring(0, startIndex - 1) +
                query.substring(ampersandAfterHiddenField, query.length());
      }

      //handle case with param1=value&hiddenField=something
      else {
        query = query.substring(0, startIndex - 1);
      }
    }
    GrndsTrace.exitScope( /*query*/);
    return query;
  }

  /**
   * This method creates a FormValidation object which is used by the form tag to store all information about the form.
   *
   * @param className the name of the FormValidation subclass to use to validate this form
   * @param formName  the name of the form
   * @param request   the request that generated this page.
   * @return Formvalidation a new FormValidation object if this form has not been displayed before or an existing
   *         FormValidation object containing previously enetered data if the form has been displayed before.
   * @throws JspException it cannot instantiate the FormValidation Object or locate the XML Schema
   */
  public static FormValidation createValidationObj(String className, String formName, HttpServletRequest request)
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createValidationObject");
    GrndsTrace.msg(TRACE_TAG, 7, "request = " + request);

    //An object will exist in the request if the page has been displayed before.
    FormValidation result = (FormValidation) request.getAttribute(formName);
    boolean firstTime = (result == null);

    if (firstTime) {
      GrndsTrace.msg(TRACE_TAG, 7, "this form has not been displayed before");

      try {
        result = (FormValidation) Class.forName(className).newInstance();
        result.setName(formName);
      }
      catch (ClassNotFoundException cnfe) {
        throw new JspException("Could not find class " + className, cnfe);
      }
      catch (InstantiationException ie) {
        throw new JspException("Could not instantiate class " + className, ie);
      }
      catch (IllegalAccessException iae) {
        throw new JspException("Could not access class " + className, iae);
      }
    }

    result.invalidate();
    GrndsTrace.exitScope( /*result*/);
    return result;
  }

  /**
   * Serializes a FormVaildation object
   *
   * @param formObj the object to serailize
   * @return the serialized object
   * @throws JspException if the object cannot be serialized
   */
  public static String serializeValidationObj(FormValidation formObj) throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".serializeValidationObj()");
    String formData;

    try {
      ObjectOutputStream objectOut = null;
      try {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        objectOut = new ObjectOutputStream(byteOut);
        objectOut.writeObject(formObj);
        byte[] byteArray = byteOut.toByteArray();
        formData = Base64.encode(byteArray);
      } finally {
        if (objectOut != null) {
          objectOut.close();
        }
      }
    } catch (IOException e) {
      throw new JspException("Unable to serialize FormValidation object", e);
    }

    GrndsTrace.exitScope();
    return formData;
  }

  /**
   * De-serializes a FormVaildation object
   *
   * @param formData the string to de-serialize
   * @return the formValidation object
   * @throws IOException if the string cannot be de-serialized
   */
  public static FormValidation deserializeValidationObj(String formData)
          throws IOException {
    GrndsTrace.enterScope(TRACE_TAG + ".deserializeValidationObj()");
    FormValidation formObj;

    try {
      ObjectInputStream objectIn = null;
      try {
        byte[] serializedBytes = Base64.decode(formData);
        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(serializedBytes);
        objectIn = new ObjectInputStream(byteArrayIn);
        formObj = (FormValidation) objectIn.readObject();
      } finally {
        if (objectIn != null) {
          objectIn.close();
        }
      }
    }
    catch (Exception e) {
      IOException ioException = new IOException(e.getMessage());
      ioException.initCause(e);
      throw ioException;
    }

    GrndsTrace.exitScope();
    return formObj;
  }

  /**
   * This method creates a URL for a given resource in the given context. It is used by the formTag to locate the XML
   * Schema used to initialize a Validator.
   *
   * @param context  the current servlet context
   * @param resource the path to the resource in the current context
   * @return URL object identifying the resource
   * @throws JspException if it cannot locate the resource
   */
  public static URL locateResource(ServletContext context, String resource)
          throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".locateResource()");
    GrndsTrace.msg(TRACE_TAG, 7, "looking for resource " + resource + " in context " + context);

    URL url;

    if (resource != null) {
      try {
        url = context.getResource(resource);
      }
      catch (java.net.MalformedURLException mue) {
        throw new JspException(mue.toString(), mue);
      }
    } else {
      throw new JspException("No resource specified");
    }

    GrndsTrace.exitScope( /*url*/);
    return url;
  }

  /**
   * This method creates HTML that adds javascript to the Form that sets the Label to red of HTML Input fields that have
   * errors..
   *
   * @param formName         the name of the form
   * @param allErrorMessages all of the errors that have been found on the page.
   * @return String a String containing the javascript to make labels indicate an error.
   */
  public static String createErrorLabelIndicator(String formName, Map allErrorMessages) {
    StringBuffer buffer = new StringBuffer();
    if (allErrorMessages != null) {
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("<script language=\"JavaScript\">");
      buffer.append(ArchitectureConstants.LINE_BREAK);
      for (Iterator iterator = allErrorMessages.keySet().iterator(); iterator.hasNext();) {
        String element = (String) iterator.next();
        buffer.append("eval(\"document.all.label_\"+document.");
        buffer.append(formName);
        buffer.append(".");
        buffer.append(element);
        buffer.append(".name+\".className='formErrorText'\");\n");
      }
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("</script>");
    }
    return buffer.toString();
  }

  /**
   * Creates a string with javascript for writing the error messages to the page.
   *
   * @param formName the name of the form that generated this error
   * @param form     the for for which to display error messages
   * @return String a String containing the javascript that displays the error.
   * @deprecated
   */
  public static String createErrorMessageDisplay(String formName, FormValidation form) {
    GrndsTrace.enterScope(TRACE_TAG + ".createErrorMessageDisplay");

    Map allErrorMessages = form.getErrorMessages();

    return (createErrorMessageDisplay(formName, allErrorMessages));
  }

  public static String createInfoMessageDisplay(String formName, Map allInfoMessages) {
    return createMessageDisplay(formName, allInfoMessages, ServerSideValidationUtility.INFO);
  }

  public static String createErrorMessageDisplay(String formName, Map allErrorMessages) {
    return createMessageDisplay(formName, allErrorMessages, ServerSideValidationUtility.ERROR);
  }

  /**
   * Creates a string with javascript for writing the error messages to the page.
   *
   * @param formName    the name of the form that generated this error
   * @param allMessages error messages for the form.
   * @return String a String containing the javascript that displays the error.
   */
  protected static String createMessageDisplay(String formName, Map allMessages, String messageType) {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    StringBuffer buffer = new StringBuffer();
    String sTotalMsg = "sTotalMsg" + messageType;
    if (allMessages != null) {
    	buffer.append("<table width=\"100%\" cellpadding=\"1\"><tr><td class=\"formErrorText\">");
    	buffer.append("<hr noshade size=\"1\">");
    	buffer.append("<span class=\"formLabelError\">Please correct the following error(s):</span>");
    	buffer.append("<p>");
    	for (Iterator iterator = allMessages.keySet().iterator(); iterator.hasNext();) {
    		String element = (String) iterator.next();
    		String error = (String) allMessages.get(element);
    		//Pull unique identifier from the beginning of the element name
    		element = element.substring(element.indexOf("_") + 1);
    		if("UnspecifiedInputField".equals(element) == false) {
    			buffer.append(element);
        		buffer.append(" - ");
    		}
    		buffer.append(error);
    		if (iterator.hasNext()) {
    			buffer.append("<br/>");
    		}
    	}
    	buffer.append("<p/>");
    	buffer.append("<hr noshade size=\"1\">");
    	buffer.append("</td></tr></table>");
    	  
//      //Start Javascript section
//      buffer.append(ArchitectureConstants.LINE_BREAK);
//      buffer.append("<script language=\"JavaScript\">");
//      buffer.append(ArchitectureConstants.LINE_BREAK);
//
//      //sTotalMsg = "";
//      buffer.append("  var ").append(sTotalMsg).append(" = ''; ");
//      buffer.append(ArchitectureConstants.LINE_BREAK);
//      for (Iterator iterator = allMessages.keySet().iterator(); iterator.hasNext();) {
//        String element = (String) iterator.next();
//        String error = (String) allMessages.get(element);
//        //Pull unique identifier from the beginning of the element name
//        element = element.substring(element.indexOf("_") + 1);
//        buffer.append(writeMessageLine(element, formName, error, messageType));
//      }
//      //displayErrors( sTotalMsg, frmTest );
//      buffer.append("  display").append(messageType).append("Msgs( ").append(sTotalMsg).append(", ");
//      buffer.append(formName);
//      buffer.append(" );");
//      buffer.append(ArchitectureConstants.LINE_BREAK);
//
//      //Close Javascript
//      buffer.append(ArchitectureConstants.LINE_BREAK);
//      buffer.append("</script>");
    }
    GrndsTrace.exitScope();
    return (buffer.toString());
  }

  /**
   * Creates javascript to display an error to the user. The message is displayed using an externally defined 'Error'
   * style, which should be defined in the impact.css file and must be included in the JSP page header. The javascript
   * also highlights the offending input field when clicked.
   *
   * @param element  the name of the element that generated this error
   * @param formName the name of the form that generated this error
   * @param error    the error message to display
   * @return String a String containing the javascript that displays the error.
   */
  static String writeMessageLine(String element, String formName, String error, String messageType) {
    StringBuffer buffer = new StringBuffer();
    boolean isFieldRelated = false;
    if (element.startsWith(InputValidation.UNSPECIFIED_INPUT_FIELD)) {
      isFieldRelated = false;
    }

    String sTotalMsg = "sTotalMsg" + messageType;
    String setMsg = "setMsg";//"set" + messageType + "Msg";
    //1. sTotalMsg = setMsg( sTotalMsg, getFieldMsg( 'This is a test message', frmTest, frmTest.InputName ) );
    //2. sTotalMsg = setMsg( sTotalMsg, getMsg( 'This is a test message', frmTest ) );
    if (isFieldRelated) {
      buffer.append(sTotalMsg).append(" = ").append(setMsg).append("( ").append(sTotalMsg).append(", getFieldMsg( \"");
    } else {
      buffer.append(sTotalMsg).append(" = ").append(setMsg).append("( ").append(sTotalMsg).append(", getMsg( \"");
    }
    buffer.append(error.trim());
    buffer.append("\"");

    if (isFieldRelated) {
      buffer.append(", ");
      buffer.append(formName);
      buffer.append(", ");
      buffer.append(formName);
      buffer.append(".");
      buffer.append(element);
    }

    buffer.append(" ) );");
    buffer.append(ArchitectureConstants.LINE_BREAK);

    return buffer.toString();
  }

  public static boolean getBRefreshWidgetsFromRequest(HttpServletRequest request) {
    //BEE - 1/8/03 - set conversationError flag so that it can be used by all inputs
    //rather than each input determining the value from this attribute
    String conversationError = (String) request.getAttribute(ServerSideValidationUtility.REFRESH_WIDGETS_FROM_REQUEST);
    return (conversationError != null && "true".equals(conversationError));
  }

  public static void setBRefreshWidgetsFromRequest(HttpServletRequest request, boolean value) {
    request.setAttribute(ServerSideValidationUtility.REFRESH_WIDGETS_FROM_REQUEST, "" + value);
  }
}