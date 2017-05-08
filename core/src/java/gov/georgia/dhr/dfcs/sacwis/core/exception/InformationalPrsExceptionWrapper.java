package gov.georgia.dhr.dfcs.sacwis.core.exception;

/**
 * This class is an architecture exception and should only be used by the Exception Handling Framework. This class will
 * be used by the Exception Handling framework to wrap an Exception that does not inherit from BasePrsException.  This
 * will allow the exception to be handled, logged, and presented as any BasePrsException is.
 */
public class InformationalPrsExceptionWrapper extends ArchitectureException {
  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param msg           The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public InformationalPrsExceptionWrapper(String msg, Throwable e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }


  /**
   * This method will return "Not a PRS Exception" for the error code since this exception should not be in the code
   * table lookup framework.
   */
  public String getErrorCode() {
    Throwable cause = super.getCause();
    return cause != null ? cause.getClass().getName() : "Missing cause.";
  }
}
