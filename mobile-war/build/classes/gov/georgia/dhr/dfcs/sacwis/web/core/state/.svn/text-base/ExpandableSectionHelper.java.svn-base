package gov.georgia.dhr.dfcs.sacwis.web.core.state;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * <p/>
 * Title: ExpandableSectionHelper </p>
 * <p/>
 * <p/>
 * Description: </p>
 *
 * @author Stephan Brauchli
 * @version 1.0
 */
public abstract class ExpandableSectionHelper {
  /** Creates a new StateContext object. */
  public ExpandableSectionHelper() {
  }

  /**
   * Gets the expandable section state from the Expandable Section Map using the xpandKey. 1) the expandable section tag
   * has not been viewed (returns NULL) 2) it's been viewed and is open (returns Boolean.TRUE) 3) it's been viewed and
   * is closed (returns Boolean.FALSE)
   *
   * @return Boolean - bExp
   */
  public static Boolean getExpandableSectionState(HttpSession session, String xpandKey) {
    Boolean bExp = Boolean.FALSE;
    if (session != null) {
      Map xpandMap = (Map) session.getAttribute(EXPANDED_STATE_MAP);
      if (xpandMap != null) {
        if (xpandMap.get(xpandKey) != null) {
          bExp = (Boolean) xpandMap.get(xpandKey);
        } else {
          bExp = null;
        }
      }
    }
    return bExp;
  }

  /**
   * Sets the expandable section state into the Expandable Section Map context parameter
   *
   * @param session
   * @param xpandKey
   * @param bExp
   */
  public static void setExpandableSectionState(HttpSession session, String xpandKey, Boolean bExp) {
    Map xpandMap = (Map) session.getAttribute(EXPANDED_STATE_MAP);
    if (xpandMap == null) {
      xpandMap = new HashMap();
    }
    xpandMap.put(xpandKey, bExp);
    session.setAttribute(EXPANDED_STATE_MAP, xpandMap);
  }

  private static String EXPANDED_STATE_MAP = "expandedStateMap";

}
