package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class AuthenticatedPrsHttpServlet extends BasePrsHttpServlet {

  private static final String TRACE_TAG = "AuthenticatedPrsHttpServlet";

  public static final String LOGIN_URL = "/login/Login/";
  public static final String SERIALIZED_REQUEST_KEY = TRACE_TAG + "_SERIALIZED_REQUEST_KEY";

  private static final boolean PER_USER_DATASOURCE =
          Boolean.parseBoolean(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                            "perUserSchemaSupport"));
  public static final String LENSES_CASE_ID = "LENSES_CASE_ID";
  /**
   * Override the BasePrsHttpServlet's doPreExchange method so that prior to each exchange we check to see if the static
   * variable BasePrsHttpServlet.servletInfoMap has been initialized.
   *
   * @param ctx
   * @return
   * @throws ServletException
   * @throws IOException
   */
  protected boolean doPreExchange(GrndsExchangeContext ctx) throws ServletException, IOException {
    GrndsTrace.enterScope(AuthenticatedPrsHttpServlet.TRACE_TAG + ".doPreExchange");

    HttpServletRequest request = ctx.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(ctx);
    boolean validImpactSession = user != null;

    if (validImpactSession) {
      // Unconditionally set the id into GlobalData to make sure that it's ALWAYS there.
      UserProfileHelper.setGlobalDataUserId(request, user.getUserID());
      if (PER_USER_DATASOURCE) {
        // Set the username into the context holder for data source selection; it is cleared in base prs servlet
        //   because the doPost() method was already overriden there with a try/catch block.
        UsernameContextHolder.setUsername(user.getUserLogonID());
      }
      // Call super.doPreExchange( ctx ) in order to continue processing.
      return super.doPreExchange(ctx);
    }

    // Handle the session timed out case.
    boolean isDocumentRequest = ("/document".equals(request.getServletPath()));

    // If the session is invalid, it either timed out, or a user tried to access a page directly through a bookmark or
    //   by typing a URL.  Try to find the user id in GlobalData; if that fails, see if we have it as a field (to make
    //   it a little harder to spoof) in the navigation form.  If both fail, just forward to the login page w/o
    //   maintaining the existing request.
    int userId = UserProfileHelper.getGlobalDataUserId(request);
    if (userId == 0 && !isDocumentRequest) {
      String serializedUserId = request.getParameter(UserProfileHelper.METAPHOR_USER_ID_KEY);
      if (serializedUserId != null) {
        try {
          userId = (Integer) SerializationHelper.deserializeObject(serializedUserId);
        }
        catch (Exception e) {
          // Just log the exception
          GrndsTrace.msg(TRACE_TAG, 3, "Failed to deserialize UserID from the banner form.");
        }
      }
    }

    String serializedRequest = null;
    if (userId != 0 || isDocumentRequest) {
      // Serialize the existing request
      serializedRequest = SerializationHelper.serializeObject(new SerializableHttpServletRequest(request));
    }

    // Remove all the attributes except for javax and apache attributes, as when we forward, we want a clean request.
    RequestUtil.removeAllAttributesSafe(request);

    if (userId != 0 || isDocumentRequest) {
      // First, save the current request
      request.setAttribute(SERIALIZED_REQUEST_KEY, serializedRequest);
      // Next, we have a userId, so the session must have timed out; indicate this in the request.
      request.setAttribute(TIMED_OUT_SESSION_KEY, ArchitectureConstants.TRUE);
      // Finally, set a message indicating that the session has timed out
      BasePrsConversation.setInformationalMessage(Messages.MSG_SESSION_TIMED_OUT, request);
    }

    // Remove the grnds qname and forward to the login page.
    request.getRequestDispatcher(LOGIN_URL).forward(request, ctx.getResponse());

    GrndsTrace.exitScope();
    // If there's no valid session, we never return true because we want to stop processing the request.
    return false;
  }
}
