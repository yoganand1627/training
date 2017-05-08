package gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler;

import javax.servlet.ServletException;

import org.grnds.facility.log.GrndsLevel;
import org.grnds.facility.log.GrndsLogger;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.StateException;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;

/**
 * <pre>
 *  JSP Name:     IMPACT Error page
 *  Created by:   Mike Werle
 *  Date Created: 18 September 2003
 * <p/>
 * Description:
 * This Excetion Handler is used to display StateExceptions and SocketExceptions
 * that are wrapped as StateExceptions.
 * <p/>
 *  Change History:
 *  Date          User        Description
 *  ----------    ----------  --------------------------------------------
 *  09/18/2003    WERLEMK     Initial creation.
 *  03/22/2004    EILERSBE    It now uses a JSP to display minimal error information
 *                            in cases where we need to forward directly to a JSP vs. using a
 *                            servlet.  The JSP should be safer and be able to
 *                            handle system errors more easily.
 * </pre>
 */
public class StateExceptionHandler implements SpecificExceptionHandler {
  /** The stateException that is being handled. */
  private StateException stateException;

  public static final String TRACE_TAG = "SpecificExceptionHandler";

  /**
   * Users should not create their own instances of the handler.  This class will be created and managed by the
   * ExceptionHandler class.
   */
  public StateExceptionHandler(StateException stateException) {
    this.stateException = stateException;
  }

  public void handle() {
    GrndsTrace.enterScope(TRACE_TAG + ".handle");
    GrndsLogger.getLogger(ExceptionHandler.GLOBAL_EXCEPTION_LOGGER).log(GrndsLevel.WARNING,
                                                                        "Unique ID: "
                                                                        + stateException.getUniqueId()
                                                                        + " -- " + stateException.getMessage(),
                                                                        stateException);
    GrndsTrace.exitScope();
  }

  /**
   * This method provides a safe way to display the StateException without requiring that the error display use the
   * BasePrsHttpServlet that could have originially forced this exception.  By going directly to a JSP, it is garunteed
   * that the request will end, and not go into a recursive loop.
   *
   * @param context - GRNDS Exchange Context
   */
  public void presentErrorMessage(GrndsExchangeContext context) {
    //Safely create the URL used to display the message
    String url = "/grnds-docs/SafeError.jsp";
    if (stateException != null) {
      url += ("?uniqueID=" + stateException.getUniqueId() + "&errorName=StateException" + "&message=" +
              URLHelper.encode(gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup.getMessageByNumber(
                      Messages.MSG_NETWORK_ERROR)));
    } else {
      url += ("?message=" + URLHelper.encode(gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup.getMessageByNumber(
              Messages.MSG_NETWORK_ERROR)));
    }

    //Forward on to the url
    try {
      BasePrsConversation.forward(url, context.getRequest(), context.getResponse());
    } catch (ServletException ex) {
      //If there is a problem doing the forward, do nothing
    }
  }

  public Throwable getThrowable() {
    return stateException;
  }

  public void setThrowable(Throwable throwable) {
    this.stateException = (StateException) throwable;
  }
}
