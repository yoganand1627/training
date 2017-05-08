package gov.georgia.dhr.dfcs.sacwis.core.lookup;

// java classes

import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;

import java.io.Serializable;

/**
 * This file contains the CodeAttributes class which encapsulates all of the read-only attributes in the database
 * associated with a given code/decode pair.
 *
 * @author Daniel L. Boxwell, September 24, 2001
 */
public final class CodeAttributes implements Serializable, Mapping {
  /**
   * Public Constructor
   *
   * @param codeCategory The code's category
   * @param code         The encoded value
   * @param decode       The decoded value
   */
  public CodeAttributes(String codeCategory,
                        String code,
                        String decode) {
    this.codeCategory = codeCategory;
    this.code = code;
    this.decode = decode;
  }

  /** @return The Code's Category */
  public String getCodeCategory() {
    return this.codeCategory;
  }

  /** @return The encoded value */
  public String getCode() {
    return this.code;
  }

  /** @return The decoded value */
  public String getDecode() {
    return this.decode;
  }

  /** @return The code's custom ordering */
  public Integer getOrdering() {
    return this.ordering;
  }

  /** Implementation of Mapping Interface method getKey */
  public String getKey() {
    return this.code;
  }

  /** Implementation of Mapping Interface method getValue */
  public String getValue() {
    return this.decode;
  }

  public boolean equals(Object other) {
    if (other != null && other.getClass() == CodeAttributes.class) {
      CodeAttributes otherCodeAttributes = (CodeAttributes) other;
      return ((codeCategory == null ? otherCodeAttributes.codeCategory == null : codeCategory.equals(
              otherCodeAttributes.codeCategory)) &&
                                                 (code == null ? otherCodeAttributes.code == null : code.equals(
                                                         otherCodeAttributes.code)) &&
                                                                                    (decode == null ?
                                                                                            otherCodeAttributes
                                                                                                    .decode == null :
                                                                                            decode.equals(
                                                                                                    otherCodeAttributes.decode)) &&
                                                                                                                                 (ordering ==
                                                                                                                                  null ?
                                                                                                                                         otherCodeAttributes
                                                                                                                                                 .ordering ==
                                                                                                                                                           null :
                                                                                                                                         ordering.equals(
                                                                                                                                                 otherCodeAttributes.ordering)));
    } else {
      return false;
    }
  }


  //
  // Instance Variables
  //
  private String codeCategory;
  private String code;
  private String decode;
  private Integer ordering;

}




