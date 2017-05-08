package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.tagext.TagSupport;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;

/**
 * The BaseTag class is the source of all architecture tags replacing standard HTML tags.  Tags extending BaseTag will
 * perfom validation on input submission.
 *
 * @author Pablo Mitchell
 */
public class BaseTag extends TagSupport {
  private static final GrndsConfiguration configuration = GrndsConfiguration.getInstance();
  protected static final String DEFAULT_INITIAL_DISPLAY =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.default.initial.display");
  protected static final String LABEL_AND_TAG_BREAK =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.label.and.tag.break");
  protected static final String LABEL_AND_TAG_DELIMITER =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.label.and.tag.delimiter");
  protected static final String LABEL_STYLE =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.label.style");
  protected static final String MARK_AS_REQUIRED =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.mark.as.required");
  protected static final String MARK_AS_CONDITIONALLY_REQUIRED =
          configuration.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "validation.mark.as.conditionally.required");
  private static final String TRACE_TAG = "BaseTag";

  protected EditableMode editableMode;
  protected Map<String, String> attributes;
  protected String constraint;
  protected String label;
  protected String colspan;
  protected String name;
  protected String type;
  protected String value;
  protected boolean required;
  protected boolean includeHiddenField;
  protected boolean isConditionallyRequired;
  protected String conditionallyRequired;

  /** Default Constructor. */
  public BaseTag() {
    GrndsTrace.enterScope(TRACE_TAG + ".constructor");
    this.attributes = new HashMap<String, String>();
    this.required = false;
    this.includeHiddenField = false;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: class See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute assigns a class name to an element.
   */
  public void setClass(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setClass");
    this.setAttribute("class", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: id See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute assigns a name to an element. This name must be unique in a document.
   */
  public void setId(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setId");
    this.setAttribute("id", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: lang See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute specifies the base language of an element's attribute values and text content.
   */
  public void setLang(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setLang");
    this.setAttribute("lang", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: name See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute names the element so that it may be referred to from style sheets or scripts.
   */
  public void setName(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setName");
    this.name = str;
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onClick See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onClick event occurs when the pointing device button is clicked over an element.
   */
  public void setOnClick(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnClick");
    this.setAttribute("onClick", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: ondblclick See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The ondblclick event occurs when the pointing device button is double clicked over an element.
   */
  public void setOndblclick(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOndblclick");
    this.setAttribute("ondblclick", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onkeydown See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onkeydown event occurs when a key is pressed down over an element.
   */
  public void setOnkeydown(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnkeydown");
    this.setAttribute("onkeydown", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onkeypress See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onkeypress event occurs when a key is pressed and released over an element.
   */
  public void setOnkeypress(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnkeypress");
    this.setAttribute("onkeypress", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onkeyup See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onkeyup event occurs when a key is released over an element.
   */
  public void setOnkeyup(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnkeyup");
    this.setAttribute("onkeyup", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmousedown See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmousedown event occurs when the pointing device button is pressed over an element.
   */
  public void setOnmousedown(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmousedown");
    this.setAttribute("onmousedown", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmousemove See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmousemove event occurs when the pointing device is moved while it is over an element.
   */
  public void setOnmousemove(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmousemove");
    this.setAttribute("onmousemove", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmouseout See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmouseout event occurs when the pointing device is moved away from an element.
   */
  public void setOnmouseout(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmouseout");
    this.setAttribute("onmouseout", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmouseover See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmouseover event occurs when the pointing device is moved onto an element.
   */
  public void setOnmouseover(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmouseover");
    this.setAttribute("onmouseover", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: onmouseup See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str The onmouseup event occurs when the pointing device button is released over an element.
   */
  public void setOnmouseup(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setOnmouseup");
    this.setAttribute("onmouseup", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: style See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute specifies style information for the current element.
   */
  public void setStyle(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setStyle");
    this.setAttribute("style", str);
    GrndsTrace.exitScope();
  }

  /**
   * Sets the standard HTML tag attribute: title See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute offers advisory information about the element for which it is set.
   */
  public void setTitle(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setTitle");
    this.setAttribute("title", str);
    GrndsTrace.exitScope();
  }

  /** Sets the colspan of a TD tag */
  public void setColspan(String str) {
    GrndsTrace.enterScope(TRACE_TAG + ".setColspan");
    this.colspan = str;
    GrndsTrace.exitScope();
  }

  /** @param str This attribute is used to include a hidden field with */
  public void setIncludeHiddenField(String str) {
    if ("true".equalsIgnoreCase(str)) {
      this.includeHiddenField = true;
    }
  }

  /*
   * The createLabelHtml method returns an HTML String which may consist of none, some, or all of
   * the following: the label attribute, the label and tag delimiter, the label and tag break,
   * the mark as required symbol, and a break line.  Subclasses will use this to prepend a
   * formatted label to custom JSP tags.
   */

  protected String createLabelHtml() {
    StringBuffer buffer = new StringBuffer();
    String labelAndTagDelimiter = LABEL_AND_TAG_DELIMITER;

    if (StringHelper.isValid(this.label)) {
      if (this.required) {
        buffer.append(MARK_AS_REQUIRED);
      } else if (this.isConditionallyRequired) {
        buffer.append(MARK_AS_CONDITIONALLY_REQUIRED);
      }
      buffer.append("<label class=\"");
      buffer.append(LABEL_STYLE);
      //BEE - added id and for parameters
      String id = this.attributes.get("id").toString();
      buffer.append("\" id=\"label_");
      buffer.append(id);
      buffer.append("\" for=\"");
      buffer.append(id);
      buffer.append("\">");
      buffer.append(this.label);

      if (this.typeIsCheckBoxOrRadio()) {
        buffer.append("</label>");
      } else {
        buffer.append(labelAndTagDelimiter);
        if (buffer.length() > 0) {
          buffer.append("</label>");
          buffer.append("</td>");

          if (this.colspan != null) {
            buffer.append("<td colspan=\"");
            buffer.append(this.colspan);
            buffer.append("\">");
          } else {
            buffer.append("<td>");
          }

        }
      }
    }
    return buffer.toString();
  }

  /**
   * This method creates a hidden field that will allow a view mode value to be passed on to another page via the
   * request.  The name and value of the hidden field correspond to the name and value of the InputTag
   *
   * @return String A hidden field
   */
  protected String createViewModeHiddenField() {
    StringBuffer buffer = new StringBuffer();
    if (this.includeHiddenField) {
      buffer.append(ArchitectureConstants.LINE_BREAK);
      buffer.append("<input type=\"hidden\"");
      buffer.append(" name=\"");
      buffer.append(this.name);
      buffer.append("\" value=\"");
      buffer.append(this.value);
      buffer.append("\">");
    }
    return buffer.toString();
  }

  /** Formats the members of the attribute HashMap for embedding within an HTML tag. */
  protected String listAttributes() {
    StringBuffer buffer = new StringBuffer();
    for (Iterator iterator = this.attributes.entrySet().iterator(); iterator.hasNext();) {
      Map.Entry entry = (Map.Entry) iterator.next();
      buffer.append(" ");
      buffer.append(entry.getKey());
      if (entry.getValue().toString().length() > 0) {
        buffer.append("=\"");
        buffer.append(entry.getValue());
        buffer.append("\"");
      }
    }
    return buffer.toString();
  }

  /** required */
  protected boolean required() {
    return this.required;
  }

  /** Put a standard HTML tag attribute in the attributes HasMap. */
  protected void setAttribute(String name, String value) {
    this.attributes.put(name, value);
  }

  /** typeIsButton */
  protected boolean typeIsButton() {
    return (StringHelper.isValid(this.type) && ("button".equalsIgnoreCase(this.type) || "reset".equalsIgnoreCase(
            this.type) || "submit".equalsIgnoreCase(this.type)));
  }

  /** typeIsButtonOrCheckBoxOrRadio */
  protected boolean typeIsButtonOrCheckBoxOrRadio() {
    return (StringHelper.isValid(this.type) && ("button".equalsIgnoreCase(this.type) || "checkbox".equalsIgnoreCase(
            this.type) || "radio".equalsIgnoreCase(this.type)));
  }

  /** typeIsCheckBox */
  protected boolean typeIsCheckBox() {
    return (StringHelper.isValid(this.type) && "checkbox".equalsIgnoreCase(this.type));
  }

  /** typeIsRadio */
  protected boolean typeIsRadio() {
    return (StringHelper.isValid(this.type) && "radio".equalsIgnoreCase(this.type));
  }

  /** typeIsCheckBoxOrRadio */
  protected boolean typeIsCheckBoxOrRadio() {
    return (StringHelper.isValid(this.type) &&
            ("checkbox".equalsIgnoreCase(this.type) || "radio".equalsIgnoreCase(this.type)));
  }

  /**
   * Returns the PageMode of the parent FormTag.
   *
   * @return PageMode The PageMode of the parent FormTag
   */
  protected String getParentFormPageMode() {
    FormTag parent = BaseHtmlTag.getParentFormTag(this.pageContext.getRequest(), this);
    return parent.getPageModeAttribute();
  }
}

