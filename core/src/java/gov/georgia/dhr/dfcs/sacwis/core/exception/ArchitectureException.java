package gov.georgia.dhr.dfcs.sacwis.core.exception;


/** This class is the base class for all architecture exceptions in the PRS system. */
public abstract class ArchitectureException extends BasePrsException {
  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public ArchitectureException(String msg,
                               Throwable e,
                               int priorityLevel) {
    super(msg, e, priorityLevel);
  }


  /**
   * This constructor will take a message and a priority level.
   *
   * @param msg           The message to add to the exception
   * @param priorityLevel The priority of this exception
   */
  public ArchitectureException(String msg,
                               int priorityLevel) {
    this(msg, null, priorityLevel);
  }
}
