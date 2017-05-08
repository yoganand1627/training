package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;

/** @author Kelly J. Mayes */
public class PhoneNumberTag extends InputTag {

  /** Default Constructor. */
  public PhoneNumberTag() {
    super();
  }

  /**
   * Sets the standard HTML input tag attribute: tabIndex See the HTML 4.01 specification at
   * http://www.w3.org/TR/html4/
   *
   * @param str The tab order of this input in the current form
   */
  public void setTabIndex(String str) {
    setAttribute("tabindex", str);

    if (StringHelper.isValid(str)) {
      this.baseTabIndex = new Integer(str);
    }
  }

  public void setBaseName(String str) {
    this.baseName = str;
  }

  /**
   * @return TagSupport constant indicating how to process the rest of the JSP page
   * @throws JspException if anything goes wrong
   */
  public int doStartTag() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".doStartTag");

    JspWriter out = this.pageContext.getOut();
    this.setType("text");

    try {
      out.print(this.createHtml());
    }
    catch (IOException ioe) {
      throw new JspException("Unable to write to JSP output", ioe);
    }

    GrndsTrace.exitScope();

    //This tag should have no body
    return super.SKIP_BODY;
  }

  /**
   * Creates the HTML tag for this input.
   *
   * @return String containing HTML
   * @throws JspException DOCUMENT ME!
   */
  protected String createHtmlInput() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createHtmlInput");

    StringBuffer buffer = new StringBuffer();
    StringBuffer htmlBuffer = new StringBuffer();
    String parentPageMode = super.getParentFormPageMode();

    //Create the form validation for this input and set value in case of invalid form
    this.createInput();

    //If the tag's editable mode is compatible with the parent form tag's
    // page mode, display html...
    if (!EditableMode.isCompatibleWith(parentPageMode, super.getEditableMode())) {
      setDisabled("true");
    }

    htmlBuffer.append("<input type=\"");
    htmlBuffer.append(this.type);
    htmlBuffer.append("\"");
    htmlBuffer.append(" name=\"");
    htmlBuffer.append(this.getName());
    htmlBuffer.append("\"");

    if (StringHelper.isValid(super.getValue())) {
      htmlBuffer.append(" value=\"");
      htmlBuffer.append(super.getValue());
      htmlBuffer.append("\"");
    }

    htmlBuffer.append(super.listAttributes());
    htmlBuffer.append(">");
    buffer.append(htmlBuffer.toString());
    GrndsTrace.exitScope();

    return buffer.toString();
  }

  /**
   * Creates the HTML tag for this input.
   *
   * @return String containing HTML
   * @throws JspException DOCUMENT ME!
   */
  protected String createHtml() throws JspException {
    GrndsTrace.enterScope(TRACE_TAG + ".createHtml");

    StringBuffer buffer = new StringBuffer();
    StringBuffer valueBuffer = new StringBuffer();
    StringBuffer labelBuffer = new StringBuffer();
    GrndsTrace.msg(TRACE_TAG, 10, "Get value character array");

    char[] charArray = new char[super.getValue().length()];
    charArray = super.getValue().toCharArray();
    GrndsTrace.msg(TRACE_TAG, 10, "Loop through value character array");

    for (int i = 0; i < charArray.length; i++) {

      if ((charArray[i] >= '0') && (charArray[i] <= '9')) {
        valueBuffer.append(charArray[i]);
      }
    }

    //buffer is a valid phone number
    GrndsTrace.msg(TRACE_TAG, 10, "If value length size > 10 continue");

    if (valueBuffer.length() == 10) {

      //Set name before creating label
      GrndsTrace.msg(TRACE_TAG, 10, "set id");
      this.setAttribute("id", baseName + "_Id");
      GrndsTrace.msg(TRACE_TAG, 10, "create label");
      labelBuffer.append(super.createLabelHtml());
      GrndsTrace.msg(TRACE_TAG, 10, "append label");
      buffer.append(labelBuffer.toString());

      //Create input for Area Code
      GrndsTrace.msg(TRACE_TAG, 10, "create first input");
      this.setName(baseName + this.AREACODE);
      this.setAttribute("id", baseName + "_Id");
      this.setConstraint("Digit3");
      this.setValue(valueBuffer.substring(0, 3));
      this.setSize("3");
      this.setMaxLength("3");

      if (baseTabIndex != 0) {
        setAttribute("tabindex", Integer.toString(baseTabIndex));
      }

      buffer.append(this.createHtmlInput());

      //Create input for Prefix
      GrndsTrace.msg(TRACE_TAG, 10, "create 2nd input");
      buffer.append("-");
      this.setName(baseName + this.PREFIX);
      this.setAttribute("id", baseName + "_Id");
      this.setValue(valueBuffer.substring(3, 6));

      if (baseTabIndex != 0) {
        setAttribute("tabindex", Integer.toString(baseTabIndex + 1));
      }

      buffer.append(this.createHtmlInput());

      //Create input for base number - don't call it extension because there is
      //already an extension field for some phone numbers
      GrndsTrace.msg(TRACE_TAG, 10, "create 3rd input");
      buffer.append("-");
      this.setConstraint("Digit4");
      this.setName(baseName + this.NUMBER);
      this.setAttribute("id", baseName + "_Id");
      this.setValue(valueBuffer.substring(6, 10));
      this.setSize("4");
      this.setMaxLength("4");

      if (baseTabIndex != 0) {
        setAttribute("tabindex", Integer.toString(baseTabIndex + 2));
      }

      buffer.append(this.createHtmlInput());
    }

    GrndsTrace.exitScope();

    return buffer.toString();
  }

  public String toString() {

    return createOpeningHtml();
  }

  //Static constant
  private static final String TRACE_TAG = "PhoneNumberTag";

  public static final String AREACODE = "AreaCode";
  public static final String PREFIX = "Prefix";
  public static final String NUMBER = "Number";

  //  private static final String DEFAULT_INITIAL_DISPLAY = "Choose One...";
  //Instace variables
  private String baseName;
  private int baseTabIndex = 0;
}
