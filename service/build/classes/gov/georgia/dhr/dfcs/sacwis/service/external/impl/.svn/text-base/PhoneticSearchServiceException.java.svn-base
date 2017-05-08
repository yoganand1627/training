/*
 * $Workfile:   PhoneticSearchServiceException.java  $
 */
package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

// -- Service Exception classes --

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

/** The base phonetic search service exception. */
public class PhoneticSearchServiceException extends ServiceException {
  /**
   * This constructor takes a message and an exception.
   *
   * @param message The message to add to the exception.
   * @param e       The exception to wrap.
   */
  public PhoneticSearchServiceException(String message, Exception e) {
    super(message, e, DEFAULT_PRIORITY_LEVEL);
  }

  /**
   * This constructor takes a message.
   *
   * @param message The message to add to the exception.
   */
  public PhoneticSearchServiceException(String message) {
    this(message, null);
  }

  public PhoneticSearchServiceException(int messageNumber) {
    super(messageNumber);
  }

  public PhoneticSearchServiceException(int messageNumber, Throwable t) {
    super(messageNumber, t);
  }
}
