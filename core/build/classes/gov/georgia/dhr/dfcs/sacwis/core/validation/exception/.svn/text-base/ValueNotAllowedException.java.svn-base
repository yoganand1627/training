package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.core.validation.Constraint;


/**
 * Indicates that a set of values was specified for the <code>Constraint</code> and that the data supplied was not
 * valid
 */
public class ValueNotAllowedException extends DataFormatException {
  /**
   * Constructor for the ValueNotAllowedException object
   *
   * @param c    The <code>Constraint</code>
   * @param data The data causing the exception
   */
  public ValueNotAllowedException(Constraint c, String data) {
    super(createMessageString(c, data));
  }


  static String getValuesString(Constraint constraint) {
    StringBuffer vals = new StringBuffer("(");

    for (Iterator allowedValues = constraint.getAllowedValues().iterator();
         allowedValues.hasNext();) {
      vals.append(allowedValues.next());

      if (allowedValues.hasNext()) {
        vals.append("|");
      }
    }

    vals.append(")");
    return vals.toString();
  }


  static String createMessageString(Constraint c, String data) {
    String result = null;

    if (c.hasDescription()) {
      result = c.getDescription();
    } else {
      result = "[" + c.getName() + "] " + data +
               " is not in the collection " + getValuesString(c);
    }

    return result;
  }
}












