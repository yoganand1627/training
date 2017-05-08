package gov.georgia.dhr.dfcs.sacwis.core.jndihelper;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsRuntimeException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException;

/**
 * This class is the base class for all JNDI exceptions
 *
 * @author Randy O'Neil, May 1, 2002
 */

public class JndiHelperRuntimeException extends BasePrsRuntimeException {
  /**
   * This constructor will take a message and a priority level.
   *
   * @param msg           The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public JndiHelperRuntimeException(String message) {
    super(message, null, PrsException.WARNING_PRIORITY);
    super.setGenericMessage(this.GENERIC_MESSAGE);
  }


  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public JndiHelperRuntimeException(String message, Exception e) {
    super(message, e, PrsException.WARNING_PRIORITY);
    super.setGenericMessage(this.GENERIC_MESSAGE);
  }


  private static final String GENERIC_MESSAGE = "An exception occurred while trying to lookup a resource";

}





