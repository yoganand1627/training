package gov.georgia.dhr.dfcs.sacwis.core.exception;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;


/**
 * This exception is thrown by classes implementing a data accessor interface to indicate that an exception has occurred
 * during access of collaborator data.
 *
 * @author Jason Rios
 */
public class DaoException extends BasePrsException {
  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param message       The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public DaoException(String message,
                      Exception e,
                      int priorityLevel) {
    super(message, e, priorityLevel);
  }

  /**
   * This constructor will take a message and a priority level.
   *
   * @param message       The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public DaoException(String message,
                      int priorityLevel) {
    this(message, null, priorityLevel);
  }

  /**
   * @param message explanation of the exception
   * @param e       the original exception, if any
   * @deprecated this should no longer be used! Constructor simply calls the super class, passing input parameters
   */
  public DaoException(String message,
                      Exception e) {
    this(message, e, BasePrsException.WARNING_PRIORITY);
  }
}