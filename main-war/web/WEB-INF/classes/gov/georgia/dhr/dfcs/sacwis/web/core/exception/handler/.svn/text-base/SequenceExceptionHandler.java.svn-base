/**
 * Created on Jun 6, 2005 at 6:02:16 PM
 *
 * Created by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.sql.SequenceException;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

/**
 * <pre>
 * Date        User      Description
 * --------    --------  --------------------------------------------------
 * 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add
 *                       Contact List and Detail to MPS.
 * 09/08/2005  werlem    SIR 23971 Added special handling for running out
 *                       of sequences.
 * </pre>
 */
public class SequenceExceptionHandler implements SpecificExceptionHandler {
  public SequenceExceptionHandler(Throwable throwable) {
    setThrowable(throwable);
  }

  /** This generic method will handle the exception. */
  public void handle() {
    EXCEPTION_LOGGER.log(GrndsLevel.CRITICAL, sequenceException.getMessage(), sequenceException);
  }

  public void presentErrorMessage(GrndsExchangeContext context) {
    // The message is set correctly by service exceptions, so this is ok.
    BasePrsConversation.displayMessagePage(getThrowable().getMessage(), context);
  }

  public void setThrowable(Throwable throwable) {
    if (throwable instanceof SequenceException) {
      this.sequenceException = (SequenceException) throwable;
    } else {
      //noinspection ProhibitedExceptionThrown
      throw new ClassCastException(
              "The ServiceExceptionHandler class can only be used to handle SequenceException's.");
    }
  }

  /** Used to get the throwable that this handler will handle. */
  public Throwable getThrowable() {
    return this.sequenceException;
  }

  private SequenceException sequenceException = null;
  private static final GrndsLogger EXCEPTION_LOGGER = GrndsLogger.getLogger(ExceptionHandler.GLOBAL_EXCEPTION_LOGGER);
}
