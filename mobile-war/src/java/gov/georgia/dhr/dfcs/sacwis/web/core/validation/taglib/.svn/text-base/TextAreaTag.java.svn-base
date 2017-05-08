package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;

/**
 * The TextAreaTag class replaces the standard HTML text area tag to perfom validation of each text upon submission. The
 * input information is stored in an InputValidation object.
 *
 * @author Pablo Mitchell
 */
public class TextAreaTag extends BaseFormElementTag implements BodyTag {
  /** Default Constructor. */
  public TextAreaTag() {
    super();
  }

  /**
   * Sets the standard HTML text area cols attribute. See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str A <code>String</code> contining the number of columns in the current text area
   */
  public void setCols(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setCols");
    this.cols = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML text area rows attribute. See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str A <code>String</code>  the number of rows in the current text area
   */
  public void setRows(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setRows");
    this.rows = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML text area rows attribute. See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param maxLength the number of rows in the current text area
   */
  public void setMaxLength(int maxLength) {
    GrndsTrace.enterScope(TRACE_TAG + ".setRows");
    this.maxLength = maxLength;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the body of the Tag
   *
   * @param bodyContent the body content
   */
  public void setBodyContent(BodyContent bodyContent) {
    this.bodyContent = bodyContent;
  }

  /** Performs any necessary processing on the Tag's BodyContent. */
  public void doInitBody() {
  }

  /**
   * Creates an InputValidation object to hold all data for this text area and adds it to the parent form.  Also prints
   * an HTML text area tag to the output stream.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".startTag");

    JspWriter out = super.pageContext.getOut();

    try {
      String html = this.createOpeningHtml();
      out.print(html);
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    return TextAreaTag.EVAL_BODY_BUFFERED;
  }

  /**
   * This method is called after the Body of the text area has been read by the Container.
   *
   * @return an int indicating that the body should not be displayed
   * @throws JspException if anything goes wrong
   */
  public int doAfterBody() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".AfterBodyTag");

    JspWriter out = this.bodyContent.getEnclosingWriter();

    try {
      super.setValue(this.bodyContent.getString().trim());
      this.createInput();
      this.bodyContent.clearBody();
      this.bodyContent.print(super.getValue());
      this.bodyContent.writeOut(out);
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }
    catch (JspException jspe) {
      throw new JspException(jspe.getMessage(), jspe);
    }

    GrndsTrace.exitScope();

    return BaseFormElementTag.SKIP_BODY;
  }

  /**
   * This method is called when the closing TextArea Tag has been reached.
   *
   * @return an int idicating that the page should continue to be processed.
   * @throws JspException if anything goes wrong
   */
  public int doEndTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".endTag");

    JspWriter out = super.pageContext.getOut();

    try {
      String html = this.createClosingHtml();
      out.print(html);
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    return BaseFormElementTag.EVAL_PAGE;
  }

  /**
   * Creates the opening HTML tag for this text area.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml");

    StringBuffer buffer = new StringBuffer();
    buffer.append(super.createLabelHtml());

    String id = super.getId();
    if (id == null) {
      super.setId(super.getName());
    }
    // If the tag's editable mode is compatible with the parent form tag's
    // page mode, dump html.
    /*BEE - If we later change view mode to display as text only, use this code
    if ( super.isEditable() )
    {
    */
    //For now, view mode will simply have the select box disabled.
    // 02-20-02 DPW -- changed from "disabled" to "readonly"
    if (!super.isEditable()) {
      super.setAttribute("readonly", "");
    }
    //Only remove the attribute if it is Editable and Disabled was not explicity set.
    else if (!super.getDisabledInd()) {
      super.removeAttribute("readonly");
    }
    buffer.append("<textarea name=\"");
    // 12/6 MKW: Changed to generate disabled name to distinguish this from the associated hidden field
    buffer.append(super.hasAttribute("disabled") ? super.getName() + "_Disabled" : super.getName());

    buffer.append("\" rows=\"");
    buffer.append(this.rows);
    buffer.append("\" cols=\"");
    buffer.append(this.cols);
    buffer.append("\"");
    buffer.append(" id=\"");
    buffer.append(super.getId());
    buffer.append("\"");
    //If maxLength has been set, use javascript to enforce it.
    if (this.maxLength != 0) {
      buffer.append(" onkeyup='if(this.value.length >= ");
      buffer.append(this.maxLength);
      buffer.append(") { this.value=this.value.substring(0,");
      buffer.append(this.maxLength);
      buffer.append("); }'");
    }
    buffer.append(super.listAttributes());
    buffer.append(">");
    /*BEE - If we later change view mode to display as text only, use this code
    }
    */

    GrndsTrace.exitScope();

    return buffer.toString();
  }

  /**
   * Creates the closing HTML tag for this text area.
   *
   * @return String containing HTML
   */
  protected String createClosingHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createClosingHtml");

    StringBuffer buffer = new StringBuffer();

    buffer.append("</textarea>");

    // If the tag's editable mode is compatible with the parent form tag's
    // page mode, dump html.
    /*BEE - If we later change view mode to display as text only, use this code
    if ( super.isEditable() )
    {
      buffer.append( "</textarea>" );
    }
    else
    {
      buffer.append( super.createViewModeHiddenField() );
    }
    */

    //BEE - For view mode with disabled fields, create hidden field to hold value
    if (getAttribute("disabled") != null) {
      buffer.append(super.createViewModeHiddenField());
    }

    GrndsTrace.exitScope();

    return buffer.toString();
  }

  /**
   * Creates an InputValidation object for this text area and adds it to the parent form.
   *
   * @throws JspException of anything goes wrong
   */
  protected void createInput() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createInput");

    FormTag parent = getParentFormTag(pageContext.getRequest(), this);

    //check that parent not null
    if (parent == null) {
      throw new JspException("Text Area Tag may only be used within a Form Tag");
    }
    InputValidation input = new InputValidation(super.getName(), super.getConstraint(), super.getRequiredBoolean());

    ServletRequest request = this.pageContext.getRequest();
    String existingParameter = request.getParameter(super.getName());
    String parentValue = parent.getInputValue(super.getName());

    //DWW - 1/17/03 - If conversation error, redisplay existing
    //DWW - 3/06/03 - removed the condition that checks that the value is the same
//    String conversationError = (String)request.getAttribute( ServerSideValidationUtility.FORM_VALIDATION_CONVERSATION_ERROR );
//    boolean bConversationError = ( conversationError != null && conversationError.equals( "true" ) );

    if (existingParameter != null &&
        //existingParameter.equals( parentValue ) &&
        parent.getBWidgetsRefreshFromRequest()) {
      super.setValue(existingParameter);
      GrndsTrace.msg(TRACE_TAG, 7, "using previously entered parameter " + super.getName() + "=" + super.getValue());
    }

    input.setValue(super.getValue());
    parent.addInput(input);

    GrndsTrace.exitScope();
  }

  // -- static constant --
  private static final String TRACE_TAG = "TextAreaTag";

  // -- instance variables --
  private String cols;
  private String rows;
  private int maxLength = 0;
  private BodyContent bodyContent;
}