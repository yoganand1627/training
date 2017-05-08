package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;

/** Indicates that a String expression does not contain the minimum amount of characters */
public class StringTooShortException extends DataFormatException {
  /**
   * Constructor for the StringTooShortException object
   *
   * @param c    the <code>Constraint</code> causing the exception
   * @param data the data being validated by the constraint
   */
  public StringTooShortException(Constraint c, String data) {
    super(createMessageString(c, data));
  }

  static String createMessageString(Constraint c, String data) {
    String result = "String too short (or empty)";
    
    if (c != null){
      if (c.hasDescription()) {
        result = c.getDescription();
      } else {
        result = "[" + c.getName() + "] Value is too short [Min. length: " +
               (int) c.getMinLength() + "]";
      }
    }

    return result;
  }
}











