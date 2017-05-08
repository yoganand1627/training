//
// COPYRIGHT
//

package gov.georgia.dhr.dfcs.sacwis.core.lookup;

// architecture classes

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;

/**
 * Exception class used by the Lookup service.
 *
 * @author Kelly J. Mayes, October 2001
 */

public final class LookupException extends ArchitectureException {
  /**
   * Public Constructor
   *
   * @param msg           The error message
   * @param e             The wrapped exception
   * @param priorityLevel Error priority for logging purposes
   */
  public LookupException(String msg, Exception e, int priorityLevel) {
    super(msg, e, priorityLevel);
  }

  /**
   * Public Constructor
   *
   * @param msg           The error message
   * @param priorityLevel Error priority for logging purposes
   */
  public LookupException(String msg, int priorityLevel) {
    super(msg, priorityLevel);
  }

  /**
   * LookupException MUST override the BasePrsException getErrorCode method. The superclass' method uses a
   * CodesTableLookup to find the error code which for a LookupException could be bad news. LookupException simply
   * returns the class name as the error code.
   *
   * @return The error code
   */
  public String getErrorCode() {
    return this.getClass().getName();
  }
}




