package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;


/** Indicates that a <code>null</code> string was supplied instead of valid data */
public class NullStringException extends DataFormatException {
  /**
   * Constructor for the NullStringException object
   *
   * @param c the constraint being validated
   */
  public NullStringException(Constraint c) {
    super(createMessageString(c));
  }

  static String createMessageString(Constraint c) {
    String result = null;

    if (c.hasDescription()) {
      result = c.getDescription();
    } else {
      result = "[" + c.getName() + "] Cannot check null string";
    }

    return result;
  }
}












