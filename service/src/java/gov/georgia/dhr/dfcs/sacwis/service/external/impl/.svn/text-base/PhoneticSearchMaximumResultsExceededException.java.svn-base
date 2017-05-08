package gov.georgia.dhr.dfcs.sacwis.service.external.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

/**
 * Exception indicating that a phonetic search performed on the ids server exceeds the value defined by the
 * ids-maximum-results property in the architecture.properties file.
 *
 * @author Todd G. Tomkinson, May 23, 2003
 */
public class PhoneticSearchMaximumResultsExceededException extends ServiceException {
  /**
   * This constructor takes a message and an exception.
   *
   * @param message The message to add to the exception.
   * @param e       The exception to wrap.
   */
  public PhoneticSearchMaximumResultsExceededException(String message, Exception e) {
    super(message, null, DEFAULT_PRIORITY_LEVEL);
  }

  /**
   * This constructor takes a message.
   *
   * @param message The message to add to the exception.
   */
  public PhoneticSearchMaximumResultsExceededException(String message) {
    this(message, null);
  }
}
