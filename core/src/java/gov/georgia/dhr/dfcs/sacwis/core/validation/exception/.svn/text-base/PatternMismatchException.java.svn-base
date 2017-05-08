package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;

/** Indicates that data does not match a regular expression */
public class PatternMismatchException extends DataFormatException {
  /**
   * Constructor for the PatternMismatchException object
   *
   * @param c    The <code>Constraint</code>
   * @param data The data causing the exception
   */
  public PatternMismatchException(Constraint c, String data) {
    super(createMessageString(c, data));
  }


  static String createMessageString(Constraint c, String data) {
    String result = "\\'" + data + "\\' is not valid. ";

    if (c.hasDescription()) {
      result = result + c.getDescription();
    }

    return result;
  }
}












