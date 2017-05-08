package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;


/**
 * Indicates that a string representation of data does not represent the desired data type.
 *
 * @author Nick Sharples
 */
public class InvalidTypeException extends DataFormatException {
  /**
   * Constructor for the InvalidTypeException object
   *
   * @param c    the <code>Constraint</code> causing the exception
   * @param data the data being validated by the constraint
   */
  public InvalidTypeException(Constraint c, String data) {
    super(createMessageString(c, data));
  }


  static String createMessageString(Constraint c, String data) {
    String result = null;

    if (c.hasDescription()) {
      result = c.getDescription();
    } else {
      result = "[" + c.getName() + "] " + data + " is not of type " + c.getDataType();
    }

    return result;
  }
}












