package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;

/** Thrown if a numerical range is not adhered to by data supplied by the client */
public class OutOfRangeException extends DataFormatException {
  /**
   * Constructor for the OutOfRangeException object
   *
   * @param c    The <code>Constraint</code>
   * @param data The data causing the exception
   */
  public OutOfRangeException(Constraint c, String data) {
    super(createMessageString(c, data));
  }


  public static String getRangeString(Constraint constraint) {
    StringBuffer message = new StringBuffer();

    if (constraint.hasMinInclusive()) {
      message.append(" min:");
      message.append(constraint.getMinInclusive());
      message.append(" - ");
    } else if (constraint.hasMinExclusive()) {
      message.append(" min:");
      message.append(constraint.getMinExclusive() + 1);
      message.append(" - ");
    } else {
      message.append(" - ");
    }

    if (constraint.hasMaxInclusive()) {
      message.append("max:");
      message.append(constraint.getMaxInclusive());
    }

    if (constraint.hasMaxExclusive()) {
      message.append("max:");
      message.append(constraint.getMaxInclusive() - 1);
    }

    return message.toString();
  }


  static String createMessageString(Constraint c, String data) {
    String result = null;

    if (c.hasDescription()) {
      result = c.getDescription();
    } else {
      result = "[" + c.getName() + "] Valid range is [" + getRangeString(c) + " ]";
    }

    return result;
  }
}












