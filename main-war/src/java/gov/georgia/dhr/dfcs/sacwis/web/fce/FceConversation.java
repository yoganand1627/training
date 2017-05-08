package gov.georgia.dhr.dfcs.sacwis.web.fce;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/** Common methods shared by all FCE Conversations */
public class FceConversation
        extends BaseHiddenFieldStateConversation {
  protected String traceTag = null;

  public FceConversation(String traceTag) {
    this.traceTag = traceTag;
  }

  protected void handleException(GrndsExchangeContext context,
                                 Exception exception) {
    if (FceUtility.ENABLE_SYSTEM_OUT) {
      exception.printStackTrace();
    }

    if (exception instanceof EjbValidationException) {
      EjbValidationException ejbValidationException =
              (EjbValidationException) exception;

      int errorCode = ejbValidationException.getErrorCode();
      if (errorCode == Messages.MSG_DOUBLE_CLICK_PREVENTED) {
        String errorMessage = MessageLookup.getMessageByNumber(errorCode);
        displayMessagePage(errorMessage, context);
        return;
      }
      if (errorCode != 0) {
        setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(ejbValidationException.getErrorMessage(),
                        context.getRequest());

        return;
      }
    }
    trace("Failure in " + traceTag + ":" + exception.getMessage());
    processSevereException(context, exception);
  }

  /** Allows me to optionally print to System.out as well as to impact-trace.log */
  private final void trace(String string) {
    FceUtility.trace(traceTag, string);
  }
}

  
