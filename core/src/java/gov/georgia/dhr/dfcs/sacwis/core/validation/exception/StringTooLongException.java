package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;

/** Indicates that a String expression exceeds a certain number of characters */
public class StringTooLongException extends DataFormatException {
  /**
   * Constructor for the StringTooLongException object
   *
   * @param c    The <code>Constraint</code>
   * @param data The data causing the exception
   */
  public StringTooLongException(Constraint c, String data) {
    super(createMessageString(c, data));
  }

  static String createMessageString(Constraint c, String data) {
    String result = "String too long";

    if (c != null){
      if (c.hasDescription()) {
        result = c.getDescription();
      } else {
        result = "[" + c.getName() + "] Value is too long [Max. length: " +
               (int) c.getMaxLength() + "]";
      }
    }
    return result;
  }
}












