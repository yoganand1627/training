package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

// -- copyright --

// -- prs classes --

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ClientSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RequestAttributes;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.Validator;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

/**
 * The FormTag class replaces the standard HTML form tag to perfom validation of each form upon submission.  The form
 * stores all of its data in a FormValiation object.
 *
 * @author Kelly J. Mayes
 */
public class FormTag extends BaseHtmlTag {
  // -- static constants --
  private int submissionCount;
  private int radioButtonCount;
  private static final String METHOD = "post";
  private static final String TRACE_TAG = "FormTag";
  private static final String VALIDATION_CLASS = "gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation";

  // -- instance variables --
  private FormValidation formValidator;
  private String pageMode;
  private String action;
  private String method;
  private String onSubmit;
  private String schema;
  private String target;
  private String validationClass;
  private boolean clientValidationEnabled;
  private boolean bWidgetsRefreshFromRequest;
  private boolean defaultButton;

  /** Default Constructor */
  public FormTag() {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".constructor");

    this.submissionCount = 1;
    this.radioButtonCount = 1;
    pageMode = PageModeConstants.VIEW;
    method = FormTag.METHOD;
    validationClass = FormTag.VALIDATION_CLASS;
    clientValidationEnabled = false;

    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom form tag pageMode attribute.
   *
   * @param mode the display mode for the current page.  This determines how children tags will be displayed on the
   *             page. Defaults to PageMode.VIEW
   */
  public void setPageMode(String mode) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setPageMode");

    if (mode == null) {
      this.pageMode = PageModeConstants.VIEW;
    } else {
      this.pageMode = mode;
    }

    GrndsTrace.exitScope();
  }

  /**
   * Gets the custom form tag pageMode attribute.
   *
   * @return the display mode for the current page.  This determines how children tags will be displayed on the page.
   */
  public String getPageModeAttribute() {
    return this.pageMode;
  }

  /**
   * Sets the standard HTML tag attribute: action See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute specifies a form processing agent.
   */
  public void setAction(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setAction");
    this.action = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: method See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   * Defaults to POST
   *
   * @param method This attribute specifies which HTTP method will be used to submit the form data set.
   */
  public void setMethod(String method) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setMethod");
    this.method = method;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onsubmit See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onsubmit event occurs when a form is submitted.
   */
  public void setOnSubmit(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setOnsubmit");
    this.onSubmit = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom tag attribute: schema
   *
   * @param str the complete path and file name of the XSL schema that contains the constraint definitions used to
   *            validate this form.
   */
  public void setSchema(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setSchema");
    this.schema = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: target See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param target the command to be called upon valid submission of the form
   */
  public void setTarget(String target) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setTarget");
    this.target = target;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom tag attribute: validationClass
   *
   * @param str the complete package and class name of the class that will be used to validate this form. Defaults to
   *            gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation
   */
  public void setValidationClass(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setValidationClass");
    this.validationClass = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom form tag clientValidationEnabled attribute. If this method is set then javascript will be generated
   * to perfom simple validation of all form input fields prior to submitting the form.
   */
  public void setClientValidation(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setClientValidation");
    if ("true".equalsIgnoreCase(str)) {
      this.clientValidationEnabled = true;
    } else {
      this.clientValidationEnabled = false;
    }
    GrndsTrace.exitScope();
  }

  /** Sets the custom form tag defaultButton attribute. */
  public void setDefaultButton(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setDefaultButton");
    if ("true".equalsIgnoreCase(str)) {
      this.defaultButton = true;
    } else {
      this.defaultButton = false;
    }
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: accept See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The list of acceptable content-types.
   */
  public void setAccept(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setAccept");
    super.setAttribute("accept", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: charset See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The list of acceptable character encodings.
   */
  public void setCharset(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setCharset");
    super.setAttribute("accept-charset", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: enctype See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The acceptable encoding type.
   */
  public void setEncType(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setEnctype");
    super.setAttribute("enctype", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onReset See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str JavaScript code that will be invoked upon reset.
   */
  public void setOnReset(String str) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".setOnreset");
    super.setAttribute("onReset", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom form tag redisplayParameters attribute. If this method is set then the page will display parameters
   * that exist in the request.
   */
  public void setRedisplayParameters(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setRedisplayParameters");
    //FIXME - is this still necessary?
//         this.redisplayParameters = true;
    GrndsTrace.exitScope();
  }

  /**
   * Creates a FormValidation object to hold all data for this form and prints the form opening HTML tag to the output
   * stream.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    // cactus has a bug that the PageContext contians a null session.
    // to work around that bug we get the session via the request object.
    HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();

    this.bWidgetsRefreshFromRequest = ServerSideValidationUtility.getBRefreshWidgetsFromRequest(request);

    this.incrementSubmissionCount(request);
    String startHtmlForm = this.createOpeningHtml(request);
    JspWriter out = super.pageContext.getOut();

    try {
      this.formValidator = ServerSideValidationUtility.createValidationObj(
              this.validationClass,
              super.getName(),
              request);

      out.println(startHtmlForm);
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    //evaluate the body content of this tag
    return BaseHtmlTag.EVAL_BODY_INCLUDE;
  }

  /**
   * Prints the form closing HTML tag to the output stream along with HTML for custom hidden fields and javascript
   * validation if necessary.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doEndTag");
    JspWriter out = super.pageContext.getOut();

    try {
      String hiddenTags = this.createHiddenHtml();
      String endHtmlForm = this.createClosingHtml();
      out.println(hiddenTags);
      out.println(endHtmlForm);
    }
    catch (java.io.IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    //Evaluate the rest of the page.
    return BaseHtmlTag.EVAL_PAGE;
  }

  /**
   * Used by the Form Element Tags to add an input to this form for validating.
   *
   * @param input an InputValidation that contains the input name and constraint (but not the value)
   */
  protected void addInput(InputValidation input) {
    GrndsTrace.enterScope(FormTag.TRACE_TAG + ".addInput");
    if (input != null) {
      this.formValidator.addInput(input);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Used by the InputTag class to display the previously entered value for an input.
   *
   * @param inputName the name of the input
   * @return String the value of the input
   */
  public String getInputValue(String inputName) {
    return this.formValidator.getInputValue(inputName);
  }

  /**
   * Used by the InputTag class to display the previously entered values for an input.
   *
   * @param inputName the name of the input
   * @return List the values of the input
   */
  public List getInputValues(String inputName) {
    return this.formValidator.getInputValues(inputName);
  }

  /** @return radio button count and postincrement the count */
  public int addRadioButtonCount() {
    return this.radioButtonCount++;
  }

  /** @return submission count */
  public int getSubmissionCount() {
    return this.submissionCount;
  }

  /**
   * This method keeps track of the number of times a form has been submitted. If the form has never been submitted the
   * count will be reset to 0
   *
   * @param request The current request object
   */
  void incrementSubmissionCount(HttpServletRequest request) {
    //An object will exist in the request if the page has been displayed before.
    FormValidation result = (FormValidation) request.getAttribute(super.getName());
    boolean firstTime = (result == null);

    if (!firstTime) {
      String previousCount = request.getParameter(ServerSideValidationUtility.FORM_VALIDATION_NUM_SUBMITS);
      this.submissionCount = Integer.parseInt(previousCount) + 1;
    } else {
      this.submissionCount = 1;
    }
  }

  /**
   * Creates the HTML tag that opens the form.
   *
   * @return String containing HTML
   */
  String createOpeningHtml(HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + ".createHtmlForm");
    StringBuffer buffer = new StringBuffer();
    buffer.append("<script language=\"JavaScript1.2\">");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("function callEnableValidation_").append(super.getName()).append("()");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("{").append(ArchitectureConstants.LINE_BREAK);
    buffer.append("enableValidation('").append(super.getName()).append("');").append(ArchitectureConstants.LINE_BREAK);
    buffer.append("}").append(ArchitectureConstants.LINE_BREAK);
    buffer.append("window.attachEvent('onload', callEnableValidation_").append(super.getName()).append(" );");
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("</script>").append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<form name=\"");
    buffer.append(super.getName());
    //BEE - turn autocomplete off for all forms.
    buffer.append("\" AUTOCOMPLETE=\"off\" class=\"nomargins\" method=\"");
    buffer.append(this.method);
    buffer.append("\" action=\"");
    buffer.append(ServerSideValidationUtility.createThisUrl(request));
    buffer.append("\" ");

    if (this.target != null) {
      buffer.append("target=\"");
      buffer.append(this.target);
      buffer.append("\" ");
    }

    if (this.getId() != null) {
      buffer.append("id=\"");
      buffer.append(this.getId());
      buffer.append("\" ");
    }

    if (createSubmitFunction().length() > 0) {
      buffer.append("onSubmit=\"");
      buffer.append(this.createSubmitFunction());
      buffer.append("\" ");
    }

    if (!this.getDefaultButtonBoolean()) {
      buffer.append(
              "onkeypress=\"if(window.event.keyCode==13 && 'TEXTAREA' != window.event.srcElement.tagName && 'A' != window.event.srcElement.tagName && !( 'INPUT' == window.event.srcElement.tagName && 'image' == window.event.srcElement.type ) ) { event.returnValue=false;event.cancel = true; }\" ");
    }

    buffer.append(super.listAttributes());

    buffer.append(">");
           
    buffer.append(getServerSideValidation());
    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Creates the HTML tags to add standard hidden fields to the form
   *
   * @return String containing HTML
   * @throws JspException the schema file cannot be located
   */
  String createHiddenHtml() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createHiddenHtml");

    HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();
    RequestAttributes requestAttributes = new RequestAttributes();
    requestAttributes.setRequestAttributesFromRequest(request);

    StringBuffer buffer = new StringBuffer();

    String formData = ServerSideValidationUtility.serializeValidationObj(this.formValidator);
    String attributesString = requestAttributes.encodeRequestAttributes();

    buffer.append(ServerSideValidationUtility.createHiddenFields(formData,
                                                                 this.action,
                                                                 this.schema,
                                                                 attributesString,
                                                                 this.submissionCount,
                                                                 ServerSideValidationUtility.createThisUrl(request)));

    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Creates the HTML tags to close the form, and provide javascript validation if necessary.
   *
   * @return String containing HTML
   * @throws JspException the schema file cannot be located
   */
  String createClosingHtml() throws JspException {
    HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();

    // Grab tab ID's out of attributes, or if not there, out of parameters.
    String level1Tab = (String) request.getAttribute(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    if (level1Tab == null || level1Tab.length() == 0) {
      level1Tab = request.getParameter(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    }
    String level2Tab = (String) request.getAttribute(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    if (level2Tab == null || level2Tab.length() == 0) {
      level2Tab = request.getParameter(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    }
    String level3Tab = (String) request.getAttribute(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    if (level3Tab == null || level3Tab.length() == 0) {
      level3Tab = request.getParameter(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    }

    StringBuffer buffer = new StringBuffer();
    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    buffer.append("\" value=\"");
    buffer.append(level1Tab);
    buffer.append("\" />");
    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    buffer.append("\" value=\"");
    buffer.append(level2Tab);
    buffer.append("\" />");
    buffer.append("<input type=\"hidden\" name=\"");
    buffer.append(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    buffer.append("\" value=\"");
    buffer.append(level3Tab);
    buffer.append("\" />");
    buffer.append("<input type=\"hidden\" name=\"formName\"");
    buffer.append(" value=\"");
    buffer.append(super.getName());
    buffer.append("\" />");
    buffer.append("</form>");

    if (this.clientValidationEnabled) {
      try {
        ServletContext context = this.pageContext.getServletContext();
        URL schemaUrl = ServerSideValidationUtility.locateResource(context, this.schema);
        buffer.append(ClientSideValidationUtility.createValidationJavascript(super.getName(), this.formValidator,
                                                                             Validator.getInstance(schemaUrl)));
      } catch (Exception e) {
        GrndsTrace.msg(TRACE_TAG, 5,
                       "Exception getting the Constraints for the Client-side Validation " + e.getMessage());
        GrndsTrace.exitScope();
        throw new JspException("Exception getting the Constraints for the Client-side Validation " + e.getMessage(), e);
      }
    }

/* Replace c-iv server side validation output with prs version
    //Write javascript to write any server-side validation error messages to the page.
    HttpServletRequest request = ( HttpServletRequest )this.pageContext.getRequest();
    FormValidation form = ( FormValidation )request.getAttribute( super.getName() );

    //Only write out the error messages if the form exists and it is not valid.
    if ( form != null && !form.isValid() )
    {
      buffer.append( ServerSideValidationUtility.createErrorMessageDisplay( super.getName(), form ) );
    }
*/
    //Append Server-Side Validation
    //buffer.append(getServerSideValidation());

    return buffer.toString();
  }

  /**
   * Creates the HTML with any server-side validation error messages for the page.
   *
   * @return String containing HTML
   */
  @SuppressWarnings({"unchecked"})
  String getServerSideValidation() {
    StringBuffer buffer = new StringBuffer();
    HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
    FormValidation form = (FormValidation) request.getAttribute(this.getName());
    Map errorMessages = null;
    Map nonValidationErrorMessages = (Map) request.getAttribute(BasePrsConversation.ERROR_MESSAGES);
    Map informationalMessages = (Map) request.getAttribute(BasePrsConversation.INFO_MESSAGES);

    //Only write out the error messages if the form exists and it is not valid.
    if (form != null && !form.isValid()) {
      errorMessages = form.getErrorMessages();
    }
    //Add the non-validation error messages
    if (nonValidationErrorMessages != null) {
      if (errorMessages != null) {
        errorMessages.putAll(nonValidationErrorMessages);
      } else {
        errorMessages = nonValidationErrorMessages;
      }
    }

    //Generate informational javascript for messages if necessary
    if (informationalMessages != null) {
      buffer.append("<!-- DISPLAYING INFO MESSAGES -->");
      buffer.append(ServerSideValidationUtility.createInfoMessageDisplay(this.getName(), informationalMessages));
    }

    //Generate error javascript for messages if necessary
    if (errorMessages != null) {
      buffer.append("<!-- DISPLAYING ERROR MESSAGES -->");
      buffer.append(ServerSideValidationUtility.createErrorMessageDisplay(this.getName(), errorMessages));
      buffer.append(ArchitectureConstants.LINE_BREAK);
      if (request.getAttribute(BasePrsConversation.ERROR_DESTINATION) != null) {
        buffer.append("<script language=\"JavaScript\">");
        buffer.append(ArchitectureConstants.LINE_BREAK);
        buffer.append("document.");
        buffer.append(this.getName());
        buffer.append(".action='");
        buffer.append(request.getAttribute(BasePrsConversation.ERROR_DESTINATION));
        buffer.append("';");
        buffer.append(ArchitectureConstants.LINE_BREAK);
        buffer.append("</script>");
      }
    }

    return buffer.toString();
  }

  /**
   * This method is called to create any JavaScript methods that need to be invoked when the form is submitted.
   *
   * @return String containing JavaScript
   */
  protected String createSubmitFunction() {
    String submitFunction = new String();
    if (this.clientValidationEnabled) {
      submitFunction = "return validate" + super.getName() + "();";
    }
    if (this.onSubmit != null) {
      submitFunction = this.onSubmit + submitFunction;
    }
    submitFunction = "setState('" + super.getName() + "');" + submitFunction;

    return submitFunction;
  }

  /** Returns value of bWidgetsRefreshFromRequest flag */
  public boolean getBWidgetsRefreshFromRequest() {
    return this.bWidgetsRefreshFromRequest;
  }

  /** Returns value of defaultButton flag */
  public String getDefaultButton() {
    return String.valueOf(this.defaultButton);
  }

  /** Returns value of defaultButton flag */
  public boolean getDefaultButtonBoolean() {
    return this.defaultButton;
  }
}