package gov.georgia.dhr.dfcs.sacwis.core.lookup;

/**
 * Exception class used by the ReferenceDataLookup class.
 *
 * @author Prem Raghupathy, March 7, 2002
 */

public class ReferenceDataLookupException extends ReferenceException {
  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param e             - The wrapped exception
   * @param priorityLevel - Error priority for logging purposes
   */
  public ReferenceDataLookupException(String msg, Exception e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param priorityLevel - Error priority for logging purposes
   */
  public ReferenceDataLookupException(String msg, int priorityLevel) {
    super(msg, priorityLevel);
  }

  /**
   * ReferenceDataLookupException MUST override the BasePrsException getErrorCode method. The superclass' method uses a
   * CodesTableLookup to find the error code which for a ReferenceDataLookupException could be bad news.
   * ReferenceDataLookupException simply returns the class name as the error code.
   *
   * @return The error code
   */
  public String getErrorCode() {
    return this.getClass().getName();
  }
}






