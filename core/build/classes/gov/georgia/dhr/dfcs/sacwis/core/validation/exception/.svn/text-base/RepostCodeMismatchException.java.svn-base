package gov.georgia.dhr.dfcs.sacwis.core.validation.exception;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ArchitectureException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;

/**
 * A <code>DataFormatException</code> is thrown when the repost code posted in the request doesn't match the repost code
 * stored in session, indicating a repost of old parameters adding an object.
 */
public class RepostCodeMismatchException extends ArchitectureException {
  /** Constructor for the DataFormatException object */
  public RepostCodeMismatchException() {
    super(MessageLookup.getMessageByNumber(Messages.MSG_REPEATED_ACTION), BasePrsException.CRITICAL_PRIORITY);
  }

  /**
   * Constructor for the DataFormatException object
   *
   * @param sMessage Description of Parameter
   */
  public RepostCodeMismatchException(String message) {
    super(message, BasePrsException.CRITICAL_PRIORITY);
  }
}












