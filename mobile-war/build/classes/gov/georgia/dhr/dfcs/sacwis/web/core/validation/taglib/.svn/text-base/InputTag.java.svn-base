package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.InputValidation;

/**
 * The InputTag class replaces the standard HTML input tag to perfom validation of each form input upon submission.  The
 * input information is stored in an InputValidation object.
 *
 * @author Kelly J. Mayes
 */

/*
* Date        User      Description
* --------    --------  --------------------------------------------------
* 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */

public class InputTag extends BaseFormElementTag {
  /**
   * Returns the PageMode of the parent FormTag.
   *
   * @return PageMode The PageMode of the parent FormTag
   */
  protected String getParentFormPageMode() {
    FormTag parent = getParentFormTag(pageContext.getRequest(), this);
    return parent.getPageModeAttribute();
  }

  /**
   * Sets the standard HTML input tag attribute: type See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str The type of control to create.
   */
  public void setType(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setType");
    this.type = str;
    GrndsTrace.exitScope();
  }

  /**
   * Don't do checkbox change code; This is useful when you absolutely must declare the same checkbox twice in the same
   * page; because you hide one group and show another
   */
  public void setNoCheckboxChange(boolean noCheckboxChange) {
    this.noCheckboxChange = noCheckboxChange;
  }

  /**
   * Sets the standard HTML input tag attribute: size See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str Initial width of the input
   */
  public void setSize(String str) {
    super.setAttribute("size", str);
  }

  /**
   * Sets the standard HTML input tag attribute: maxLength See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str The maxmimum number of characters allows in this input
   */
  public void setMaxLength(String str) {
    super.setAttribute("maxlength", str);
  }

  /**
   * Sets the standard HTML input tag attribute: checked See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str A <code>String</code> indicating whether the input should be checked. This attribute is only valid for
   *            inputs of type check box or radio button.
   */
  public void setChecked(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setChecked String");
    this.checked = StringHelper.isTrue(str);
    //BEE 12/4/02 If value is not specified, set "on" as value
    if (this.checked && !StringHelper.isValid(super.getValue())) {
      super.setValue("on");
    }
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML input tag attribute: src See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str The path to an image file
   */
  public void setSrc(String str) {
    super.setAttribute("src", str);
  }

  /**
   * Sets the standard HTML input tag attribute: alt See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str Alternate text to display if an image is unavailable
   */
  public void setAlt(String str) {
    super.setAttribute("alt", str);
  }

  /**
   * Sets the standard HTML input tag attribute: usemap See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str This attribute associates a client-side image map with an element.
   */
  public void setUsemap(String str) {
    super.setAttribute("usemap", str);
  }

  /**
   * Sets the standard HTML input tag attribute: isMap See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str This attribute associates a server-side image map with an element.
   */
  public void setIsmap(String str) {
    if ("true".equalsIgnoreCase(str)) {
      super.setAttribute("ismap", "");
    }
  }

  /**
   * Sets the standard HTML input tag attribute: accept See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str A list of content types accepted by this input for file upload
   */
  public void setAccept(String str) {
    super.setAttribute("accept", str);
  }

  /**
   * Creates an InputValidation object to hold all data for this input and adds it to the parent form.  Also prints an
   * HTML input tag to the output stream.
   *
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");
    JspWriter out = super.pageContext.getOut();

    try {
      this.createInput();
      out.print(this.createOpeningHtml());
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();
    //This tag should have no body
    return BaseFormElementTag.SKIP_BODY;
  }

  /**
   * Creates the opening HTML tag for this input.
   *
   * @return String containing HTML
   */
  protected String createOpeningHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createOpeningHtml");
    FormTag parent = getParentFormTag(pageContext.getRequest(), this);
    StringBuffer buffer = new StringBuffer();
    StringBuffer htmlBuffer = new StringBuffer();
    StringBuffer labelBuffer = new StringBuffer(super.createLabelHtml());

    if (this.typeIsRadio()) {
      this.setId(this.getName() + "_Id" + parent.addRadioButtonCount());
    }

    if (this.typeIsCheckBoxOrRadio()) {
      labelBuffer = new StringBuffer(this.createCheckBoxOrRadioLabel(false));
    }

    //If the tag's editable mode is compatible with the parent form tag's
    // page mode, display html...
    /*BEE - If we later change view mode to display as text only, use this code
      if ( super.isEditable() || this.type == "hidden" )
      {
    */
    //For now, view mode will simply have the input disabled.
    if (!super.isEditable() && !"hidden".equals(this.type)) {
      GrndsTrace.msg(TRACE_TAG, 7,
                     "Setting disabled because of either page mode or disabled setting AND field not of type hidden");
      super.setAttribute("disabled", "");
    }
    //Only remove the attribute if it is Editable and Disabled was not explicity set.
    else if (!super.getDisabledInd()) {
      super.removeAttribute("disabled");
    }

    htmlBuffer.append("<input type=\"");
    htmlBuffer.append(this.type);
    htmlBuffer.append("\"");
    htmlBuffer.append(" name=\"");
    htmlBuffer.append(super.getName());
    //If field is disabled, field will not be submitted.  Append disabled to
    //field name and create hidden field with real value
    if (getAttribute("disabled") != null) {
      htmlBuffer.append("_Disabled");
    }
    htmlBuffer.append("\"");
    htmlBuffer.append(" id=\"");
    htmlBuffer.append(super.getId());
    htmlBuffer.append("\"");

    // MKW 11/05 4:18
    // Removed StringHelper.isValid( this.value ) test in order to
    // make sure that input tags always have a value attribute.
    // BEE 11/18
    // If boolean input, only put a value if non-blank.  Default value is "on".
    if (this.typeIsCheckBoxOrRadio()) {
      if (this.checked && !StringHelper.isValid(super.getValue())) {
        super.setValue("on");
      }
      if (StringHelper.isValid(super.getValue())) {
        htmlBuffer.append(" value=\"");
        htmlBuffer.append(StringHelper.getNonNullString(super.getValue()));
        htmlBuffer.append("\"");
      }
    } else {
      htmlBuffer.append(" value=\"");
      htmlBuffer.append(StringHelper.getNonNullString(super.getValue()));
      htmlBuffer.append("\"");
    }

    //BEE - 11/19/02
    // If type is checkbox append hidden field to hold changed indicator
    if ((this.typeIsCheckBox()) && (noCheckboxChange == false)) {
      StringBuffer onClick = new StringBuffer();
      onClick.append("setCbxChange( '");
      onClick.append(parent.getName());
      onClick.append("', this); ");
      // DWW - 04/23/2003
      // this if statement fixes the problem where the onClick event either
      // shows only for the first checkbox, or it stacks onClick events on
      // top of each other.
      if (super.getAttribute("onClick") != null) {
        onClick.append(super.getAttribute("onClick"));
        super.setAttribute("onClick", onClick.toString());
      } else {
        htmlBuffer.append(" onClick=\"").append(onClick.toString()).append("\" ");
      }

      //Create the changed indicator field
      String changedFieldIndName = this.getName() + "_changed";
      buffer.append("<input type=\"hidden\" name=\"");
      buffer.append(changedFieldIndName);
      buffer.append("\" value=\"");
      buffer.append(CheckboxHelper.getChangedIndFieldValue(super.getValue(), parent, this.checked,
                                                           this.pageContext.getRequest().getParameter(
                                                                   this.getName() + "_changed")));
      buffer.append("\">");
    }

    htmlBuffer.append(super.listAttributes());

    if (this.checked) {
      htmlBuffer.append(" checked ");
    }

    htmlBuffer.append(">");
    /*BEE - If we later change view mode to display as text only, use this code
      }
      //display only the value in non-editable mode.
      else if ( !this.typeIsButtonOrCheckBoxOrRadio() ||
      ( this.checked &&
      this.type != "hidden" ) )
      {
      if ( !this.typeIsButtonOrCheckBoxOrRadio() )
      {
      htmlBuffer.append( super.value );
      }
      htmlBuffer.append( super.createViewModeHiddenField() );
      }
      else //if a checkbox or radio button is unchecked in view mode, display nothing
      {
      labelBuffer = new StringBuffer();
      }
    */

    //BEE - For view mode with disabled fields, create hidden field to hold value
    // SPB 11/19/02 9:20 AM  added condition such that radio buttons do not create
    // hidden fields when disabled
    //
    if (getAttribute("disabled") != null) {
      //MDM: 5/8/03 - not having a hidden field breaks javascript
      //If the checkbox is checked the hidden field has the checkbox input value;
      //if it's unchecked it sends ""
      //Note: if the hidden field gets created before the checkbox widget, this
      //will break; you would need to store the old value and set it back after
      //creating the hidden field
      if ((this.checked == false) && this.typeIsCheckBox()) {
        setValue("");
      }
      if (this.checked || !this.typeIsRadio()) {
        htmlBuffer.append(super.createViewModeHiddenField());
      }
    }

    //label is to the right of checkboxes and radio buttons, to the left of everything else.
    if (this.typeIsCheckBoxOrRadio()) {
      buffer.append(htmlBuffer.toString()).append(labelBuffer.toString());
    } else {
      buffer.append(labelBuffer.toString()).append(htmlBuffer.toString());
    }

    GrndsTrace.exitScope();
    return buffer.toString();
  }

  /**
   * Creates the InputValidation object to hold all information about this input and adds it to the parent form.
   *
   * @throws JspException if anything goes wrong
   */
  protected void createInput() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createInput");

    FormTag parent = getParentFormTag(pageContext.getRequest(), this);

    //check that parent not null
    if (parent == null) {
      throw new JspException("Input Tag may only be used within a Form Tag");
    }

    InputValidation input;

    if (!this.typeIsCheckBoxOrRadio()) {
      input = this.createTextInput(parent);
    } else {
      input = this.createBooleanInput(parent);
    }

    parent.addInput(input);
    GrndsTrace.exitScope();
  }

  /**
   * Creates the InputValidation object for a text (non-boolean) input
   *
   * @param parent the parent Form Tag
   * @return an Input Validation object
   */
  private InputValidation createTextInput(FormTag parent) {
    GrndsTrace.enterScope(TRACE_TAG + ".createTextInput");
    InputValidation input = new InputValidation(super.getName(), super.getConstraint(), super.getRequiredBoolean());

    ServletRequest request = this.pageContext.getRequest();
    String existingParameter = request.getParameter(super.getName());
    //String parentValue = parent.getInputValue( super.getName() );

    //BEE - 1/8/03 - If conversation error, redisplay existing
    //DWW - 3/06/03 - removed the condition that checks that the value is the same
//        String conversationError = (String)request.getAttribute( ServerSideValidationUtility.FORM_VALIDATION_CONVERSATION_ERROR );
//        boolean bConversationError = ( conversationError != null && conversationError.equals( "true" ) );

    if (existingParameter != null &&
        //existingParameter.equals( parentValue ) &&
        parent.getBWidgetsRefreshFromRequest()) {
      super.setValue(existingParameter);
      GrndsTrace.msg(TRACE_TAG, 7, "using previously entered parameter " + super.getName() + "=" + super.getValue());
    }

    input.setValue(super.getValue());
    GrndsTrace.exitScope();
    return input;
  }

  /**
   * Creates the InputValidation object for a boolean (checkbox or radio button) input
   *
   * @param parent the parent Form Tag
   * @return an Input Validation object
   */
  private InputValidation createBooleanInput(FormTag parent) {
    GrndsTrace.enterScope(TRACE_TAG + ".createBooleanInput");
    InputValidation input = null;
    ServletRequest request = this.pageContext.getRequest();
    String[] httpValues = request.getParameterValues(super.getName());
    List parentValue = parent.getInputValues(super.getName());
    List existingParameter = null;

    //If a value or values exist on the request for this input name, get them
    if (httpValues != null) {
      existingParameter = Arrays.asList(httpValues);
      GrndsTrace.msg(TRACE_TAG, 10, "existingParameter is:" + existingParameter);
    }

    //If this is redisplay after a validation or conversation error
    if (parent.getBWidgetsRefreshFromRequest()) {
      if (existingParameter != null) {
        GrndsTrace.msg(TRACE_TAG, 10, "existing param:" + existingParameter);

        //uncommented 4/21/03 MDM - otherwise radio buttons weren't checked properly
        // on validation errors
        this.checked = existingParameter.contains(super.getValue());

        GrndsTrace.msg(TRACE_TAG, 10,
                       "using previous param - this.checked=" + this.checked);
      }
      //Otherwise, default to false
      else {
        this.checked = false;
      }
    }

    //If parentValue is null(no input was created yet), create input
    if (parentValue == null) {
      input = new InputValidation(super.getName(), this.getConstraint(), this.getRequiredBoolean());
    }

    //If this is checked set value
    if (this.checked) {
      if (input == null) {
        input = new InputValidation(super.getName(), super.getConstraint(), super.getRequiredBoolean());
      }
      input.setValue(super.getValue());
      GrndsTrace.msg(TRACE_TAG, 7, "set input value - " + input.getName() + "=" + super.getValue());
    }

    GrndsTrace.exitScope();
    return input;
  }

  /**
   * This method creates a label unique to checkboxes and radio buttons
   *
   * @return String The label for a checkbox or radio button
   */
  protected String createCheckBoxOrRadioLabel(boolean separateCells) {
    String labelStyle = "formCheckBoxAndRadioLabel";
    StringBuffer label = new StringBuffer();
    // If label and checkbox should be in separate cells, add cell breaks.
    if (separateCells) {
      label.append("</td><td>");
    }
    if (StringHelper.isValid(super.getLabel())) {
      if (super.getRequiredBoolean()) {
        label.append(BaseFormElementTag.MARK_AS_REQUIRED);
      }
      if (this.getConditionallyRequiredBoolean()) {
        label.append(BaseFormElementTag.MARK_AS_CONDITIONALLY_REQUIRED);
      }
      label.append("<label name=\"label_");
      label.append(super.getName());
      label.append("\" id=\"label_");
      label.append(super.getName());
      label.append("\" for=\"");
      label.append(super.getId());
      label.append("\" class=\"");
      label.append(labelStyle);
      label.append("\" value=\"");
      label.append(super.getLabel());
      label.append("\">");
      label.append(super.getLabel());
      label.append("</label>");
    }

    return label.toString();
  }

  /**
   * determines the type of the input
   *
   * @return true if this input is a button
   */
  protected boolean typeIsButton() {
    return (StringHelper.isValid(this.type) &&
            ("button".equalsIgnoreCase(this.type) ||
             "reset".equalsIgnoreCase(this.type) ||
             "submit".equalsIgnoreCase(this.type)));
  }

  /**
   * determines the type of the input
   *
   * @return true if this input is a button, checkbox, or radio button
   */
  protected boolean typeIsButtonOrCheckBoxOrRadio() {
    return (StringHelper.isValid(this.type) &&
            ((typeIsButton() ||
              typeIsCheckBox() ||
              typeIsRadio())));
  }

  /**
   * determines the type of the input
   *
   * @return true if this input is a checkbox
   */
  protected boolean typeIsCheckBox() {
    return (StringHelper.isValid(this.type) && "checkbox".equalsIgnoreCase(this.type));
  }

  /**
   * determines the type of the input
   *
   * @return true if this input is a radio button
   */
  protected boolean typeIsRadio() {
    return (StringHelper.isValid(this.type) && "radio".equalsIgnoreCase(this.type));
  }

  /**
   * determines the type of the input
   *
   * @return true if this input is a checkbox or a radio button
   */
  protected boolean typeIsCheckBoxOrRadio() {
    return (StringHelper.isValid(this.type) && (typeIsCheckBox() || typeIsRadio()));
  }

  public void setMin(String str) {
    if (str == null || "".equals(str)) {
      str = null;
    } else {
      str = str.trim();
    }
    this.min = str;
  }
  
  public String getMin() {
    String str = "";
    if (this.min != null) {
      str = this.min;
    }
    return str;
  }

  public void setMax(String str) {
    if (str == null || "".equals(str)) {
      str = null;
    } else {
      str = str.trim();
    }
    this.max = str;
  }

  public String getMax() {
    String str = "";
    if (this.max != null) {
      str = this.max;
    }
    return str;
  }

  private static final String TRACE_TAG = "InputTag";
  protected boolean noCheckboxChange = false;
  protected String type = null;
  private boolean checked = false;
  private String min = null;
  private String max = null;
}
