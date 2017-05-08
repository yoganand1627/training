package gov.georgia.dhr.dfcs.sacwis.core.lookup;

/**
 * Exception class used to catch a generic ReferenceData exception instead of more specific exceptions that are derived
 * from this class.
 *
 * @author Prem Raghupathy, March 11, 2002
 */

public class ReferenceDataException extends ReferenceException {
  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param e             - The wrapped exception
   * @param priorityLevel - Error priority for logging purposes
   */
  public ReferenceDataException(String msg, Exception e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param priorityLevel - Error priority for logging purposes
   */
  public ReferenceDataException(String msg, int priorityLevel) {
    super(msg, priorityLevel);
  }

  /**
   * ReferenceDataException MUST override the BasePrsException getErrorCode method. The superclass' method uses a
   * CodesTableLookup to find the error code which for a ReferenceDataException could be bad news.
   * ReferenceDataException simply returns the class name as the error code.
   *
   * @return The error code
   */
  public String getErrorCode() {
    return this.getClass().getName();
  }
}






