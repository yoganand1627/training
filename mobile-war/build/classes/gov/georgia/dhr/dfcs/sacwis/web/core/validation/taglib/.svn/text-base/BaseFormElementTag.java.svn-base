package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import javax.servlet.jsp.JspException;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * The BaseFormElementTag class is the source of all architecture tags replacing standard HTML  form element tags.  Tags
 * extending BaseTag will perfom validation on input submission.
 *
 * @author Kelly J. Mayes
 */
public abstract class BaseFormElementTag extends BaseHtmlTag {
  private static final GrndsConfiguration configuration = GrndsConfiguration.getInstance();
  private static final String TRACE_TAG = "BaseFormElementTag";
  protected static final String LABEL_AND_TAG_BREAK =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.label.and.tag.break");
  protected static final String LABEL_AND_TAG_DELIMITER =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.label.and.tag.delimiter");
  protected static final String LABEL_STYLE =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.label.style");
  protected static final String MARK_AS_REQUIRED =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.mark.as.required");
  protected static final String DEFAULT_INITIAL_DISPLAY =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.default.initial.display");
  protected static final String MARK_AS_CONDITIONALLY_REQUIRED =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.mark.as.conditionally.required");

  private int editableMode;
  private String constraint;
  private String value;
  private boolean required;
  private boolean conditionallyRequired;
  private String colspan;
  private String width;
  private boolean disabledInd = false;

  /** Default Constructor. */
  public BaseFormElementTag() {
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    this.required = false;
    this.value = new String();
    this.editableMode = EditableMode.DEFAULT;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: class See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute assigns a class name to an element.
   */
  public void setCssClass(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setCssClass");
    super.setAttribute("class", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: lang See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute specifies the base language of an element's attribute values and text content.
   */
  public void setLang(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setLang");
    super.setAttribute("lang", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: style See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute specifies style information for the current element.
   */
  public void setStyle(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setStyle");
    super.setAttribute("style", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML input tag attribute: value See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str Initial value to display in the input
   */
  public void setValue(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setValue");
    this.value = null;
    if (str != null) {
      this.value = StringEscapeUtils.escapeHtml(str.trim());
    }
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML input tag tabIndex attribute. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   *
   * @param tabIndex the tab order of this input in the current form
   */
  public void setTabIndex(int tabIndex) {
    GrndsTrace.enterScope(TRACE_TAG + ".setTabIndex");
    super.setAttribute("tabindex", String.valueOf(tabIndex));
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML input tag attribute: accessKey See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str The access key to assign to this input
   */
  public void setAccessKey(String str) {
    super.setAttribute("accesskey", str);
  }

  /**
   * Sets the standard HTML input tag readOnly attribute. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   */
  public void setReadOnly(String str) {
    if (StringHelper.isTrue(str)) {
      super.setAttribute("readonly", "true");
    }
  }

  /**
   * Sets the standard HTML input tag attribute: disabled See the <a href="http://www.w3.org/TR/html4/">HTML 4.01
   * specification</a>
   *
   * @param str indicating whether the input should be disabled
   */
  public void setDisabled(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setDisabled(string)");
    if (isTrue(str)) {
      this.setAttribute("disabled", "");
      this.setDisabledInd(true);
    } else {
      this.removeAttribute("disabled");
      this.setDisabledInd(false);
    }
    GrndsTrace.exitScope( /*str*/);
  }

  /**
   * Sets the standard HTML tag attribute: onClick See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onClick event occurs when the pointing device button is clicked over an element.
   */
  public void setOnClick(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnClick");
    if (StringHelper.isValid(str)) {
      super.setAttribute("onClick", str);
    }
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: ondblclick See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The ondblclick event occurs when the pointing device button is double clicked over an element.
   */
  public void setOndblclick(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOndblclick");
    super.setAttribute("ondblclick", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onkeydown See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onkeydown event occurs when a key is pressed down over an element.
   */
  public void setOnkeydown(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnkeydown");
    super.setAttribute("onkeydown", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onkeypress See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onkeypress event occurs when a key is pressed and released over an element.
   */
  public void setOnkeypress(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnkeypress");
    super.setAttribute("onkeypress", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onkeyup See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onkeyup event occurs when a key is released over an element.
   */
  public void setOnkeyup(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnkeyup");
    super.setAttribute("onkeyup", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmousedown See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmousedown event occurs when the pointing device button is pressed over an element.
   */
  public void setOnmousedown(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmousedown");
    super.setAttribute("onmousedown", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmousemove See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmousemove event occurs when the pointing device is moved while it is over an element.
   */
  public void setOnmousemove(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmousemove");
    super.setAttribute("onmousemove", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmouseout See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmouseout event occurs when the pointing device is moved away from an element.
   */
  public void setOnmouseout(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmouseout");
    super.setAttribute("onmouseout", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmouseover See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmouseover event occurs when the pointing device is moved onto an element.
   */
  public void setOnmouseover(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmouseover");
    super.setAttribute("onmouseover", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmouseup See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmouseup event occurs when the pointing device button is released over an element.
   */
  public void setOnmouseup(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmouseup");
    super.setAttribute("onmouseup", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML input tag onFocus attribute. See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str javascript invoked when the input recieves focus
   */
  public void setOnfocus(String str) {
    super.setAttribute("onfocus", str);
  }

  /**
   * Sets the standard HTML input tag onBlur attribute. See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str javascript invoked when the input loses focus
   */
  public void setOnBlur(String str) {
    super.setAttribute("onBlur", str);
  }

  /**
   * Sets the standard HTML input tag onChange attribute. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   *
   * @param str javascript invoked when the input value is changed
   */
  public void setOnChange(String str) {
    super.setAttribute("onchange", str);
  }

  /**
   * Sets the standard HTML input tag onSelect attribute. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   *
   * @param str javascript invoked when the input is selected
   */
  public void setOnselect(String str) {
    super.setAttribute("onselect", str);
  }

  /**
   * Sets the custom text area tag constraint attribute.
   *
   * @param str the name of the constraint that will be used to validate this text area. If no constraint is specified
   *            no automatic validation will take place.
   */
  public void setConstraint(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setConstraint");
    this.constraint = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom text area tag editableMode attribute. Defaults to EditableMode.VIEW
   *
   * @param editableMode the editable mode
   */
  public void setEditableMode(int editableMode) {
    GrndsTrace.enterScope(TRACE_TAG + ".setEditableMode");

    this.editableMode = editableMode;

    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom text area tag required attribute. If this is set a null value or empty string will not be
   * considered valid input. If this is not set a null value or empty string will be considered valid.
   *
   * @param str "true' if the input field is required
   */
  public void setRequired(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setRequired String");
    this.required = isTrue(str);
    GrndsTrace.exitScope( /*str*/);
  }

  /**
   * Sets the custom input tag attribute: conditionallyRequired If this is set a conditionally required indicator will
   * be placed on the field. The indicator will display the text specified by this tag when it is clicked.
   *
   * @param str True or False
   */
  public void setConditionallyRequired(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setConditionallyRequired");
    this.conditionallyRequired = isTrue(str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard colspan for the td separating the label and input. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   *
   * @param str This should be a number from 1 to however many columns the input tag table cell should span
   */
  public void setColspan(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setColspan");
    this.colspan = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard width for the td separating the label and input. See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   *
   * @param str This should be a number from 1 to however many pixels
   */
  public void setWidth(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setWidth");
    this.width = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the custom text area tag label attribute. This is not necessary on fields that have a label as it will
   * automatically get set when setting the label.  The title will be displayed in the validation error message as the
   * name of the field on which the error occurred.
   *
   * @param str the text to display as the label
   */
  public void setTitle(String str) {
    setAttribute("title", str);
  }

  /**
   * The createLabelHtml method returns an HTML String which may consist of none, some, or all of the following: the
   * label attribute, the label and tag delimiter, the label and tag break, the mark as required symbol, and a break
   * line.  Subclasses will use this to prepend a formatted label to custom JSP tags.
   *
   * @return a String containing HTML for the label
   */
  protected String createLabelHtml() {
    GrndsTrace.enterScope(TRACE_TAG + ".createLabelHtml");
    StringBuffer buffer = new StringBuffer();

    if (this.required) {
      buffer.append(BaseFormElementTag.MARK_AS_REQUIRED);
    }
    if (this.conditionallyRequired) {
      buffer.append(BaseFormElementTag.MARK_AS_CONDITIONALLY_REQUIRED);
    }
    //FIXME - do we need code to put the delimiter in front if its a checkbox or radio button?
    if (StringHelper.isValid(super.getLabel())) {
      buffer.append("<label name=\"label_");
      buffer.append(super.getName());
      buffer.append("\" id=\"label_");
      buffer.append(super.getId());
      buffer.append("\" for=\"");
      buffer.append(super.getId());
      buffer.append("\" class=\"");
      buffer.append(BaseFormElementTag.LABEL_STYLE);
      buffer.append("\" value=\"");
      buffer.append(super.getLabel());
      buffer.append("\">");
      buffer.append(super.getLabel());
      buffer.append(BaseFormElementTag.LABEL_AND_TAG_DELIMITER);
      buffer.append("</label>");

      //buffer.append( BaseFormElementTag.LABEL_AND_TAG_BREAK );
      buffer.append("</td>");
      if (this.colspan != null || this.width != null) {
        buffer.append("<td ");
        if (this.colspan != null) {
          buffer.append("colspan=\"");
          buffer.append(this.colspan);
          buffer.append("\" ");
        }
        if (this.width != null) {
          buffer.append("width=\"");
          buffer.append(this.width);
          buffer.append("\" ");
        }
        buffer.append(">");
      } else {
        buffer.append("<td>");
      }
    }
    GrndsTrace.exitScope( /*buffer.toString()*/);
    return buffer.toString();
  }

  /**
   * This method creates a hidden field that will allow a view mode value to be passed on to another page via the
   * request.  The name and value of the hidden field correspond to the name and value of the InputTag
   *
   * @return a String containing HTML for a hidden field
   */
  protected String createViewModeHiddenField() {
    StringBuffer buffer = new StringBuffer();
    //BEE - create hidden field regardless of value
    //    if ( StringHelper.isValid( this.value ) )
    //    {
    buffer.append(ArchitectureConstants.LINE_BREAK);
    buffer.append("<input type=\"hidden\"");
    buffer.append(" name=\"");
    buffer.append(super.getName());
    buffer.append("\" value=\"");
    buffer.append(this.value);
    buffer.append("\">");
    //    }

    return buffer.toString();
  }

  /**
   * Creates an InputValidation object to hold information about this input and adds it to the parent form. The
   * InputValidaton object should contain the corect value of the input.
   * <p/>
   * If the parent form value equals the the value in the request, that means the page is being re-displayed due to
   * invalid data. The value should be taken from the request rather than the value set to the tag inthe JSP.
   * <p/>
   * If the parent form value exists, but the value does not exist in the request, then this page is being re-displayed
   * for some other reason and the JSP tag value should be used.
   * <p/>
   * If the request attribute exists but the parent form attribute does not, that means that this page is being
   * displayed for the first time and the previous page happens to have an input with th same name.  The JSP value
   * should be used.
   */
  protected abstract void createInput() throws JspException;

  /**
   * Determines if the input is currently editable.
   *
   * @return true if the input is editable, false otherwise
   */
  protected boolean isEditable() {
    GrndsTrace.enterScope(TRACE_TAG + ".isEditable");

    FormTag parent = getParentFormTag(this.pageContext.getRequest(), this);
    GrndsTrace.msg(TRACE_TAG, 10, "1");
    String parentPageMode = parent.getPageModeAttribute();
    GrndsTrace.msg(TRACE_TAG, 10, "2: parentPageMode " + parentPageMode + " pageModeAsInt: "
                                  + Integer.toBinaryString(EditableMode.getPageModeAsInt(parentPageMode))
                                  + " editableMode:" + Integer.toHexString(this.editableMode));
    boolean editable = EditableMode.isCompatibleWith(parentPageMode, this.editableMode);

    GrndsTrace.exitScope(editable);
    return editable;
  }

  public String getConstraint() {
    return constraint;
  }

  public int getEditableMode() {
    return editableMode;
  }

  public boolean getConditionallyRequiredBoolean() {
    return conditionallyRequired;
  }

  public String getConditionallyRequired() {
    return String.valueOf(conditionallyRequired);
  }

  public boolean getRequiredBoolean() {
    return required;
  }

  public String getRequired() {
    return String.valueOf(required);
  }

  public String getValue() {
    return value;
  }

  public String getColspan() {
    return colspan;
  }

  public String getWidth() {
    return width;
  }

  public boolean getDisabledInd() {
    return disabledInd;
  }

  public void setDisabledInd(boolean disabledInd) {
    this.disabledInd = disabledInd;
  }

  //unlike StringHelper, allows null; also trims input
  private static boolean isTrue(String string) {
    if (string != null) {
      string = string.trim();
    }
    return "true".equalsIgnoreCase(string);
  }
}
