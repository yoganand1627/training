package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

// architecture classes

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;

/**
 * Exception class used by the ReferenceDataInit class.
 *
 * @author Prem Raghupathy, March 4, 2002
 */
public class ReferenceDataInitializerException extends ArchitectureException {
  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param e             - The wrapped exception
   * @param priorityLevel - Error priority for logging purposes
   */
  public ReferenceDataInitializerException(String msg, Exception e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  /**
   * Public Constructor
   *
   * @param msg           - The error message
   * @param priorityLevel - Error priority for logging purposes
   */
  public ReferenceDataInitializerException(String msg, int priorityLevel) {
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






