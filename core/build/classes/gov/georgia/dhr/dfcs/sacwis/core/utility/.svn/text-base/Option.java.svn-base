package gov.georgia.dhr.dfcs.sacwis.core.utility;

import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;

import java.io.Serializable;

/**
 * This class extends the Mapping interface that will be implemented by any class that will will be displayed to the
 * user in a drop-down menu.  This will allow developers the ability to pass a generic collection to a validation select
 * tag without having the developer first translate the collection into a map object.
 *
 * @author Bradley Eilers
 */
public class Option implements Mapping, Serializable {

  /**
   * Public Constructor
   *
   * @param code   The encoded value
   * @param decode The decoded value
   */
  public Option(String code, String decode) {
    this.code = code;
    this.decode = decode;
    this.hashCodeSet = false;
  }

  /** @param thisCode The encoded value */
  public void setCode(String thisCode) {
    this.code = thisCode;
    this.hashCodeSet = false;
  }

  /** @param thisDecode The decoded value */
  public void setDecode(String thisDecode) {
    this.decode = thisDecode;
    this.hashCodeSet = false;
  }


  /** @return The encoded value */
  public String getCode() {
    return this.code;
  }

  /** @return The decoded value */
  public String getDecode() {
    return this.decode;
  }


  /** Implementation of Mapping Interface method getKey */
  public String getKey() {
    return this.code;
  }

  /** Implementation of Mapping Interface method getValue */
  public String getValue() {
    return this.decode;
  }

  public int hashCode() {
    if (!hashCodeSet) {
      hashCode = (code == null ? 0 : 8675309 * code.hashCode()) + (decode == null ? 0 : 16661 * decode.hashCode());
      hashCodeSet = true;
    }
    return hashCode;
  }

  public boolean equals(Object obj) {
    if (obj != null && obj.getClass() == Option.class) {
      Option otherOption = (Option) obj;
      return (code == null ? otherOption.getCode() == null : code.equals(otherOption.getCode()))
             && (decode == null ? otherOption.getDecode() == null : decode.equals(otherOption.getDecode()));
    } else {
      return false;
    }
  }


  //
  // Instance Variables
  //
  private String code = null;
  private String decode = null;
  private int hashCode = 0;
  private boolean hashCodeSet = false;
}




