package gov.georgia.dhr.dfcs.sacwis.core.exception;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;


/**
 * This class is the base class for all architecture exceptions in the PRS system.
 *
 * @author Randy O'Neil, October 3, 2001
 */
public class InformationalPrsException extends BasePrsException {

  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public InformationalPrsException(String msg,
                                   Exception e,
                                   int priorityLevel) {
    super(msg, e, priorityLevel);
  }


  /**
   * This constructor will take a message
   *
   * @param msg The message to add to the exception
   */
  public InformationalPrsException(String msg) {
    this(msg, null, BasePrsException.INFORMATIONAL_PRIORITY);
  }

  /**
   * This constructor will take a message and a priority level.
   *
   * @param msg           The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public InformationalPrsException(String msg,
                                   int priorityLevel) {
    this(msg, null, priorityLevel);
  }

  /**
   * @param message explanation of the exception
   * @param e       the original exception, if any
   * @deprecated this should no longer be used! Constructor simply calls the super class, passing input parameters.
   */
  public InformationalPrsException(String message,
                                   Exception e) {
    this(message, e, BasePrsException.INFORMATIONAL_PRIORITY);
  }

}





















