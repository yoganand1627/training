/*
 * $Workfile:   c:\dev\impact\pvcs\WEB-INF\java\org\prs\impact\resource\ResourceSearchDaoException.java  $
 * $Revision:   1.3  $
 * $Date:   15 Mar 2003 18:05:36  $
 */

package gov.georgia.dhr.dfcs.sacwis.dao.resource;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/**
 * This exception is thrown by classes implementing the ResourceDataAccess interface to indicate an exception has
 * occurred during access of collaborator data.
 *
 * @author Randy J. O'Neil
 */
public class ResourceSearchDaoException extends BasePrsException {
  //
  // Constructors
  //

  /**
   * This constructor will take a message, a priority level, and an exception to wrap.
   *
   * @param message       The message to add to the exception
   * @param e             The exception to wrap
   * @param priorityLevel The priority of this exception
   */
  public ResourceSearchDaoException(String message,
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
  public ResourceSearchDaoException(String message,
                                    int priorityLevel) {
    this(message, null, priorityLevel);
  }

  /**
   * @param message explanation of the exception
   * @param e       the original exception, if any
   * @deprecated this should no longer be used! Constructor simply calls the super class, passing input parameters
   */
  public ResourceSearchDaoException(String message,
                                    Exception e) {
    this(message, e, BasePrsException.WARNING_PRIORITY);
  }
}





