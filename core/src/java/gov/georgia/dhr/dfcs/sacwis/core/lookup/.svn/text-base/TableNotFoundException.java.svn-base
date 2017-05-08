package gov.georgia.dhr.dfcs.sacwis.core.lookup;

/**
 * This exception is thrown when the specific table is not found in the cache.
 *
 * @author Prem Raghupathy, March 12, 2002
 */

public final class TableNotFoundException extends ReferenceDataException {
  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param e             - The wrapped exception
   * @param priorityLevel - Error priority for logging purposes
   */
  public TableNotFoundException(String msg, Exception e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param priorityLevel - Error priority for logging purposes
   */
  public TableNotFoundException(String msg, int priorityLevel) {
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






