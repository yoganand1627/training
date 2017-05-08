/*
* BaseHtmlTag.java
*
* Created on June 11, 2002, 7:18 PM
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * The BaseHtmlTag defines flexible attributes used by all Form Validation Tags.
 *
 * @author Kelly J. Mayes
 */
public class BaseHtmlTag extends TagSupport {
  /** Constructor. Creates a new instance of BaseHtmlTag */
  public BaseHtmlTag() {
    super();
    this.attributes = new HashMap();
  }

  /**
   * Sets the name Automatically set the id of the tag unless the developer has already specified one.  Since the
   * validation framework relies on this id, only in rare cases should a developer actually specify an ID.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the name
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the custom text area tag label attribute.
   *
   * @param str the text to display as the label
   */
  public void setLabel(String str) {
    this.label = str;
    setAttribute("title", str);
  }

  /** Gets the custom text area tag label attribute. */
  public String getLabel() {
    return this.label;
  }

  /**
   * Sets the standard HTML tag attribute: id See the HTML 4.01 specification at http://www.w3.org/TR/html4/
   *
   * @param str This attribute assigns a name to an element. This name must be unique in a document.
   */
  public void setId(String str) {
    if (str == null || "".equals(str.trim())) {
      str = null;
    } else {
      str = str.trim();
    }
    this.id = str;
  }

  /**
   * Gets the id
   *
   * @return the id
   */
  public String getId() {
    //Get the ID that was set unless one was not specific, then create and ID
    //based on the name.  Since the validation framework relies on this id, only
    //in rare cases should a developer actually specify an ID.
    if (this.id == null) {
      return name + "_Id";
    } else {
      return this.id;
    }
  }

  /**
   * Formats the members of the attribute HashMap for embedding within an HTML tag.
   *
   * @return String containing the HTMLfor all attributes
   */
  protected Map getAttributes() {
    return this.attributes;
  }

  /**
   * Formats the members of the attribute HashMap for embedding within an HTML tag.
   *
   * @return String containing the HTMLfor all attributes
   */
  protected String listAttributes() {
    return listAttributes(this.attributes);
  }

  /**
   * Formats the members of the attribute HashMap for embedding within an HTML tag.
   *
   * @return String containing the HTMLfor all attributes
   */
  public static String listAttributes(Map htmlAttributes) {
    StringBuffer buffer = new StringBuffer();

    for (Iterator iterator = htmlAttributes.entrySet().iterator(); iterator.hasNext();) {
      Map.Entry entry = (Map.Entry) iterator.next();
      buffer.append(" ");
      buffer.append(entry.getKey());
      buffer.append("=\"");

      if (entry.getValue() != null) {
        buffer.append(entry.getValue().toString());
      }

      buffer.append("\"");
    }

    return buffer.toString();
  }

  /**
   * Sets an attribute
   *
   * @param name  the name of the attribute
   * @param value the value of the attribute
   */
  protected void setAttribute(String name, String value) {
    this.attributes.put(name, value);
  }

  /**
   * Gets an attribute
   *
   * @param name the name of the attribute
   */
  protected String getAttribute(String name) {
    return (String) this.attributes.get(name);
  }

  /**
   * Checks to see if an attribute is defined
   *
   * @param name the name of the attribute
   * @return true if the attribute exists
   */
  protected boolean hasAttribute(String name) {
    return this.attributes.containsKey(name);
  }

  /**
   * removes an attribute
   *
   * @param name the name of the attribute
   */
  protected void removeAttribute(String name) {
    this.attributes.remove(name);
  }

  /**
   * Finds the parent form using an attribute (for included pages) or findAncestorWithClass (for regular pages); it also
   * caches the parentFormTag for faster performance.
   *
   * @return
   */
  public static FormTag getParentFormTag(ServletRequest request, Tag tag) {
    FormTag parent = (FormTag) request.getAttribute(INCLUDING_PAGE_FORM_KEY);
    return parent != null ? parent : (FormTag) findAncestorWithClass(tag, FormTag.class);
  }

  // Instance variables
  private java.util.Map attributes = null;
  private String name = null;
  private String id = null;
  private String label = null;

  // -- static constants --
  public static final String INCLUDING_PAGE_FORM_KEY = "INCLUDING_PAGE_FORM_KEY";
}