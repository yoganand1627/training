package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsRuntimeException;

/** Exception that is thrown if there is an error in the state managment framework */
public class StateException extends BasePrsRuntimeException {

  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public StateException(String msg, Exception e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  /**
   * This constructor will take a message and a priority level.
   *
   * @param msg           The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public StateException(String msg, int priorityLevel) {
    this(msg, null, priorityLevel);
  }

}
