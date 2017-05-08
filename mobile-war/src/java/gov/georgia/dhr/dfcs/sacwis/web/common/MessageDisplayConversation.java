package gov.georgia.dhr.dfcs.sacwis.web.common;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/** This class is currently only a placeholder to support the Grnds framework, which */
public class MessageDisplayConversation extends BaseHiddenFieldStateConversation {
  public void displayMessage_xa(GrndsExchangeContext context) {
    GrndsTrace.enterScope(TRACE_TAG + ".display_xa");
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    // If the user is null, display the message page with the login banner.
    //   In theory, this should very rarely happen, as the only ways to
    //   display the message page are from conversations, which generally
    //   require that the user be set, and the exception handler, which only
    //   displays the message page with the login banner if state could not
    //   be deserialized AND the user's session has timed out.
    if (user == null) {
      setPresentationBranch(NO_SESSION_BRANCH, context);
    }
    GrndsTrace.exitScope();
  }

  public static final String NO_SESSION_BRANCH = "no_session";
}