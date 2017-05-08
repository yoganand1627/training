/*
 * $Id: Parameter.java,v 1.3.4.2 2001/03/15 00:40:04 brydon Exp $
 * Copyright 2001 Sun Microsystems, Inc. All rights reserved.
 *
 */

package gov.georgia.dhr.dfcs.sacwis.web.core.decorator;


/**
 * This class holds the values that make up a portion of a screen, whether its a text string or a link to a jsp or html
 * file.
 */
public class Parameter implements java.io.Serializable {

  private final String key;
  private final String value;
  private final boolean direct;

  /**
   * Create a parameter instance.
   *
   * @param key    the parameter's key, how it will be retrieved from the screen map
   * @param value  the parameter's value, either a text string or a url link
   * @param direct true if the parameter is a text string and should be included directly, false if the parameter is a
   *               link and should be included virtually
   */
  public Parameter(String key, String value, boolean direct) {
    this.key = key;
    this.value = value;
    this.direct = direct;
  }

  /**
   * get is direct attribute
   *
   * @return true if the parameter is a text string and should be included directly, false if the parameter is a link
   *         and should be included virtually
   */
  public boolean isDirect() {
    return direct;
  }

  /**
   * get the key for this paramter
   *
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * get the value for this parameter
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  public String toString() {
    return "[Parameter: key=" + key + ", value=" + value + ", direct=" + direct + "]";
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Parameter parameter = (Parameter) o;
    if (direct != parameter.direct) {
      return false;
    }
    if (key != null ? !key.equals(parameter.key) : parameter.key != null) {
      return false;
    }
    if (value != null ? !value.equals(parameter.value) : parameter.value != null) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int result;
    result = (key != null ? key.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    result = 31 * result + (direct ? 1 : 0);
    return result;
  }
}












