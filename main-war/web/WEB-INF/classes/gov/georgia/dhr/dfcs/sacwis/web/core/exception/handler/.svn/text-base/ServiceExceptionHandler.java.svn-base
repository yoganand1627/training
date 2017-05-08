/**
 * Created on Jun 6, 2005 at 6:02:16 PM
 *
 * Created by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
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
public class ServiceExceptionHandler extends PrsExceptionHandler {
  public ServiceExceptionHandler(Throwable throwable) {
    super(throwable);
  }

  public void presentErrorMessage(GrndsExchangeContext context) {
    ServiceException serviceException = (ServiceException) getThrowable();
    switch (serviceException.getErrorCode()) {
      case Messages.ARC_BAT_SERVICE_BLOCKED:
      case Messages.ARC_BAT_INSUFFICIENT_PRIVILEGES:
        BasePrsConversation.displayMessagePage(Messages.ARC_BAT_SERVICE_BLOCKED, context);
        break;
      default:
        super.presentErrorMessage(context);
        break;
    }
  }

  public void setThrowable(Throwable throwable) {
    if (throwable instanceof ServiceException) {
      super.setThrowable(throwable);
    } else {
      //noinspection ProhibitedExceptionThrown
      throw new ClassCastException("The ServiceExceptionHandler class can only be used to handle ServiceException's.");
    }
  }
}
