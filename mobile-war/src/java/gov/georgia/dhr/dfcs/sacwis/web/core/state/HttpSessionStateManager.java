package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * This class extends the CivSessionStateManagement class and defines the behavior of a conversation which uses the
 * HttpSession to maintain session state.
 */
public class HttpSessionStateManager extends BaseSessionStateManager {

  /**
   * Returns a HashMap that contains all Context Parameters that the session manager is maintaining.  If the HashMap has
   * not yet been created, create one and store it on the session.
   */
  @SuppressWarnings({"unchecked"})
  Map<String, Serializable> getContextParametersMap(HttpServletRequest request) {
    Map<String, Serializable> contextParameters =
            (Map<String, Serializable>) request.getSession().getAttribute(
                    BaseSessionStateManager.CONTEXT_MANAGEMENT_KEY);
    if (contextParameters == null) {
      contextParameters = new HashMap<String, Serializable>();
      request.getSession().setAttribute(BaseSessionStateManager.CONTEXT_MANAGEMENT_KEY, contextParameters);
    }

    return contextParameters;
  }

  /**
   * Returns a HashMap that contains all attributes that the session manager is maintaining.  If the HashMap has not yet
   * been created, create one and store it on the session.
   */
  @SuppressWarnings({"unchecked"})
  Map<String, Serializable> getAttributesMap(HttpServletRequest request) {
    Map<String, Serializable> attributesMap =
            (Map<String, Serializable>) request.getSession().getAttribute(
                    BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY);
    if (attributesMap == null) {
      attributesMap = new HashMap<String, Serializable>();
      request.getSession().setAttribute(BaseSessionStateManager.STATE_MANAGEMENT_ATTRIBUTES_KEY, attributesMap);
    }
    return attributesMap;
  }
}










