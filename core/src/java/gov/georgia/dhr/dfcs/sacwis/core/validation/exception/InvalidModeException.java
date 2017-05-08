package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

// -- copyright --

// -- prs classes --

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;

/**
 * This is the base class for all logger exceptions.
 *
 * @author Pablo Mitchell, 25 April 2002
 */
public class InvalidModeException extends ArchitectureException {
  /**
   * This constructor takes a message and an exception.
   *
   * @param message The message to add to the exception.
   * @param e       The exception to wrap.
   */
  public InvalidModeException(String message, Exception e) {
    super(message, e, ArchitectureException.WARNING_PRIORITY);
  }

  /**
   * This constructor takes a messages.
   *
   * @param message The message to add to the exception.
   */
  public InvalidModeException(String message) {
    this(message, null);
  }
}





