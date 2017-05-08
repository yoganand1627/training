package gov.georgia.dhr.dfcs.sacwis.core.jndihelper;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;

/**
 * This class is the base class for all JNDI exceptions
 *
 * @author Kiran R. Narahari, October 16, 2001
 */

public class JndiHelperException extends ArchitectureException {
  /**
   * This constructor will take a message and a priority level.
   *
   * @param msg           The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public JndiHelperException(String message) {
    super(message, null, ArchitectureException.WARNING_PRIORITY);
  }


  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public JndiHelperException(String message, Exception e) {
    super(message, e, ArchitectureException.WARNING_PRIORITY);
  }

}










