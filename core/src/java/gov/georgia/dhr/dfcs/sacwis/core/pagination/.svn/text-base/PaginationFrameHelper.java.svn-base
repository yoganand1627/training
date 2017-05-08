package gov.georgia.dhr.dfcs.sacwis.core.pagination;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This class will be used to pass information from one JSP to a JSP it imports in a frame. It is necessary because the
 * second JSP (which for pagination, will display results) does not have access to the same HttpServletRequest object.
 * Thus, the results from the request must be temporarily saved to the session and then removed immediately when the
 * second page begins to load.  This class contains static methods that will help the application developer to do this.
 * <p/>
 * NOTE:  There is a VERY minor possibility that two database requests on the same exact page that return at the same
 * exact time could cause an overwriting of the results on the session.
 */
public class PaginationFrameHelper {
  /**
   * This method will pull the results from the request and store it to the session.  This should be called near the end
   * of any JSP page that outlines search criteria and has a frame that contains a page to display the results.  The
   * second page should always call placeBackToRequest() very early to remove the results from the session.  The longer
   * the results stay in the session the greater the risk of it being overwritten.
   *
   * @param id      An agreed upon ID that only the master page and sub-page will use.  Each search page and result page
   *                should have a unique ID that they share.
   * @param request The HttpServletRequest object.
   */
  public static void storeToSession(String id, HttpServletRequest request) {
    HttpSession session = request.getSession();
    Object toStore = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
    session.setAttribute(id, toStore);
  }


  /**
   * This method will take the results from the session and place it back in the request. This should be called near the
   * start of any JSP page that displays results and is displayed in a frame within a search criteria page.  This method
   * MUST be called prior to the pagination tag being used on the page.
   *
   * @param id      An agreed upon ID that only the master page and sub-page will use.  Each search page and result page
   *                should have a unique ID that they share.
   * @param request The HttpServletRequest object.
   */
  public static void placeBackToRequest(String id, HttpServletRequest request) {
    if (request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME) == null) {
      HttpSession session = request.getSession();
      Object toStore = session.getAttribute(id);
      session.removeAttribute(id);
      request.setAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME, toStore);
    }
  }
}












