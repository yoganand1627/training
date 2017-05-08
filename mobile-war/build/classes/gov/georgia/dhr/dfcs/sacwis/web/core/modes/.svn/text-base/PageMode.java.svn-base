package gov.georgia.dhr.dfcs.sacwis.web.core.modes;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;

/**
 * The <code>PageMode</code> class provides definitions governing the display of custom JSP tags within a page.  A
 * <code>PageMode</code> is assigned to the pageMode attribute of custom tag <code>FormTag</code>.
 * <p/>
 * Specifically, the <code>PageMode</code> (in conjunction with <code>EditableMode</code>) determines how tags
 * encapsulated within <code>FormTag</code> are displayed.
 *
 * @author Pablo Mitchell, 24 April 2002
 */
public abstract class PageMode
        implements Serializable {
  public static String getDebugPageMode(String pageMode) {
    if ((pageMode == null) || "".equals(pageMode)) {
      return "NO PAGE MODE";
    } else if (PageModeConstants.CREATE.equals(pageMode)) // aka NEW
    {
      return "CREATE/VIEW";
    } else if (PageModeConstants.EDIT.equals(pageMode)) // aka MODIFY
    {
      return "EDIT/MODIFY";
    } else if (PageModeConstants.VIEW.equals(pageMode)) // aka INQUIRE
    {
      return "VIEW/INQUIRE";
    } else if (PageModeConstants.APPROVE.equals(pageMode)) {
      return "APPROVE";
    } else if (PageModeConstants.NEW_USING.equals(pageMode)) {
      return "NEW_USING";
    } else {
      return "NON-STANDARD PAGE MODE: '" + pageMode + "'";
    }
  }

  /**
   * Used within a conversation to persist the page mode. This page mode has the scope of the state, meaning that it
   * persists within a conversation, but is generally cleared as the next conversation is called. (With the exception of
   * pullback conversations). If the pageMode is not set, this method will set the page mode to PageMode.VIEW and return
   * that value.
   *
   * @param request
   * @return the page mode that is pulled back from state
   */
  public static String getPageMode(HttpServletRequest request) {
//    BaseSessionStateManager state =
//            (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
    //Since Page Mode is in State, first get state.
    BaseSessionStateManager state;
    if (request != null) {
      state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      if (state == null) {
        state = new HiddenFieldSessionStateManager(request);
      }
    } else {
      state = new HiddenFieldSessionStateManager();
    }
    String pageMode = (String) state.getAttribute(ATTRIBUTE_NAME, request);
    if (pageMode == null || "".equals(pageMode)) {
      PageMode.setPageMode(PageModeConstants.VIEW, request);
      pageMode = PageModeConstants.VIEW;
    }
    return pageMode;
  }

  private static final String ATTRIBUTE_NAME = "pageModeAttributeName";

  private static final String TRACE_TAG = "PageMode";

  /**
   * String constant to be used as the key name in setting and retrieving the <code>PageMode</code> object to and from
   * the request.
   */
  public static final String PAGE_MODE_ATTRIBUTE_NAME = "pageMode";

  /**
   * Used to set the pageMode within a given converstation. This pageMode value has the same scope as the state object,
   * meaning that it generally persists throughout a conversation, but is cleared by the next conversation. If this
   * pageMode is set to something that is not one of the PageModes constants for this class, it will set the page mode
   * to a default value of PageMode.VIEW.
   *
   * @param pageMode one of the PageMode constants from this class, to set the page mode
   * @param request
   */
  public static void setPageMode(String pageMode, HttpServletRequest request) {
    BaseSessionStateManager state =
            (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    // if it is an acceptible mode, set the mode to that mode
    if (PageModeConstants.VALID_PAGE_MODES.contains(pageMode)) {
      state.setAttribute(ATTRIBUTE_NAME, pageMode, request);
    } else {
      // if it is not an acceptible mode, set the mode to VIEW
      state.setAttribute(ATTRIBUTE_NAME, PageModeConstants.VIEW, request);
    }
  }
}
