/**
 * Accenture modified code originally found in the Java Petstore Application
 *
 * $Id: Screen.java,v 1.3.4.2 2001/03/15 00:40:04 brydon Exp $
 * Copyright 2001 Sun Microsystems, Inc. All rights reserved.
 *
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A screen is a complete presentation to the user, including navigation bars, text strings like titles, and body
 * content.  Screens are configured in an xml file and read in by the web conversation framework.
 */
public class Screen implements Cloneable, Serializable {
  private String name;
  private Map<String, Parameter> parameters;
  private String template = null;

  /**
   * A screen is named and must be unique for its context (no duplicate screens shared by a servlet).  A screen has a
   * name and a map of parameters
   *
   * @param name the screen's name
   * @parameters a HashMap of Parameter instances that make up the screen
   */
  public Screen(String name, Map<String, Parameter> parameters) {
    this.name = name;
    this.parameters = parameters;
  }

  /**
   * Get the parameters for a screen
   *
   * @return the screen's parameters
   */
  public Map getParameters() {
    return parameters;
  }

  /** Allow you to override parameters set in screen defs. */
  public void setParameter(String key, String value, boolean direct) {
    Parameter parameter = new Parameter(key, value, direct);
    parameters.put(key, parameter);
  }

  /**
   * Get the screen's key
   *
   * @return the screen's key value
   */
  public Parameter getParameter(String key) {
    return parameters.get(key);
  }

  /**
   * Set the template
   *
   * @param template - String that represents the location of the template.
   */
  public void setTemplate(String template) {
    this.template = template;
  }

  /**
   * Get the Screen's template
   *
   * @return the screen's template
   */
  public String getTemplate() {
    return this.template;
  }

  public String toString() {
    return "[Screen: name=" + name + ", parameters=" + parameters + "]";
  }

  public String getName() {
    return name;
  }

  @SuppressWarnings({"NonFinalFieldReferenceInEquals"})
  public boolean equals(Object compare) {
    if ((compare instanceof Screen) == false) {
      return false;
    }
    Screen compareScreen = (Screen) compare;
    String compareName = compareScreen.name;
    if ((name != null && compareName == null) || (name == null && compareName != null)) {
      return false;
    } else if (name != null && !name.equals(compareName)) {
      return false;
    }
    Iterator keys = parameters.keySet().iterator();
    while (keys.hasNext()) {
      String key = (String) keys.next();
      Parameter parameter = this.getParameter(key);
      Parameter compareParameter = compareScreen.getParameter(key);
      if ((parameter != null && compareParameter == null) || (parameter == null && compareParameter != null)) {
        return false;
      } else if (parameter != null && parameter.equals(compareParameter) == false) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings({"unchecked"})
  public Object clone() throws CloneNotSupportedException {
    Screen screen = (Screen) super.clone();
    if (parameters != null) {
      screen.parameters = (Map<String, Parameter>) ((HashMap<String, Parameter>) parameters).clone();
    }
    return screen;
  }
}
