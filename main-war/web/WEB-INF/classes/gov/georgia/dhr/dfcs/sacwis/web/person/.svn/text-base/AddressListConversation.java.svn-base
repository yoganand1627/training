package gov.georgia.dhr.dfcs.sacwis.web.person;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * Handles activities related to display the Address submodule. <p/>
 * 
 * <pre>
 *  Change History:
 *  Date      User         Description
 *  --------  -----------  ----------------------------------------------
 *  09/12/03  CASDORJM    SIR 19772 - Made populateAddressList() static so
 *  it can be called statically from Intake - Call Info Convo.
 *  07/05/05 florerj      SIR 23727 - Refactored for Mobile implementation.
 *  &lt;/pre
 * 
 */
public class AddressListConversation extends BaseHiddenFieldStateConversation {

  public static final String REQ_FUNC_CD_ADD = "A";

  protected static final String REQ_FUNC_CD_UPDATE = "U";

  protected static final String REQ_FUNC_CD_NEW_USING = "N";

  protected static final String REQ_FUNC_CD_CONTINUE = "C";

  public static final String STAFF_DETAIL_WINDOW = "STAFF_DETAIL_WINDOW";

  protected static final String ON_CALL_DETAIL_WINDOW = "ON_CALL_DETAIL_WINDOW";

  public static final String ADDRESS_LIST = "CCMN42S_AddressList";

  public static final String TRACE_TAG = "AddressListConversation";

  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  public static final String ADDRESS_LIST_INCLUDE_PAGE_ATTR = "AddressListIncludePage";

  private Person person;

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * Queries the list of addresses to be displayed in the submodule.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void displayAddressList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAddressList_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // Get the page mode that was passed to the submodule from the including
    // JSP, and put it into state so the submodule, and possibly the Address
    // Detail page, can use it. If no page mode was passed in, use the PageMode
    // from state.
    String pageMode = PageMode.getPageMode(request);
    if (request.getAttribute(PAGE_MODE_KEY) != null) {
      pageMode = (String) request.getAttribute(PAGE_MODE_KEY);
    }
    state.setAttribute(PAGE_MODE_KEY, pageMode, request);

    // Get the addresses and store it to request and state
    CCMN42SO ccmn42so = this.populateAddressList(context, person);
    state.setAttribute(ADDRESS_LIST, ccmn42so, request);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Returns the page mode.
   * 
   * @param request
   *          The HttpServletRequest object.
   * @param WindowName
   * @return pageMode
   */
  protected static String getPageMode(HttpServletRequest request, String WindowName) {
    String cReqFuncCd = ContextHelper.getStringSafe(request, "cReqFuncCd");
    BaseSessionStateManager state = getSessionStateManager(request);
    String pageMode;
    if (cReqFuncCd.compareToIgnoreCase(REQ_FUNC_CD_ADD) == 0
        || cReqFuncCd.compareToIgnoreCase(REQ_FUNC_CD_CONTINUE) == 0) {
      pageMode = PageModeConstants.NEW_USING;
      if (WindowName != null) {
        if (WindowName.compareToIgnoreCase(STAFF_DETAIL_WINDOW) == 0
            || WindowName.compareToIgnoreCase(ON_CALL_DETAIL_WINDOW) == 0) {
          pageMode = PageModeConstants.NEW;
        }
      }
    } else if (cReqFuncCd.compareToIgnoreCase(REQ_FUNC_CD_UPDATE) == 0) {
      if (WindowName != null && WindowName.equalsIgnoreCase(STAFF_DETAIL_WINDOW)
          && state.getAttribute(PAGE_MODE_KEY, request) != null) {
        pageMode = (String) state.getAttribute(PAGE_MODE_KEY, request);
      } else {
        pageMode = GlobalData.getAppMode(request);
      }
    } else {
      pageMode = PageModeConstants.VIEW;
    }

    GrndsTrace.msg(TRACE_TAG, 10, "pageMode_in_func_is:  " + pageMode);
    return pageMode;
  }

  /**
   * Call person.retrievePersonAddressList() to populate the address list
   * 
   * @param context
   * @param person
   *          service interface passed so this can be called from outside of this conversation
   * @return
   */
  // STGAP00004886 - pass person service interface here when called from different convrsation: CallInformationConversation
  public CCMN42SO populateAddressList(GrndsExchangeContext context, Person person) {
    CCMN42SO ccmn42so = null;

    GrndsTrace.enterScope(TRACE_TAG + ".populateAddressList");
    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      CCMN42SI ccmn42si = new CCMN42SI();
      UserProfile user = UserProfileHelper.getUserProfile(context);
      ArchInputStruct input = new ArchInputStruct();
      ArchOutputStruct output = new ArchOutputStruct();
      output.setUlRowQty(90);

      input.setBPerfInd("Y");
      input.setBDataAcsInd("Y");
      input.setUsPageNbr(1);
      input.setUlPageSizeNbr(65);
      input.setSzUserId(user.getUserLogonID());
      ccmn42si.setArchInputStruct(input);
      ccmn42si.setUlIdPerson(GlobalData.getUlIdPerson(request));
      String WindowName = (String) request.getAttribute(ADDRESS_LIST_INCLUDE_PAGE_ATTR);
      GrndsTrace.msg(TRACE_TAG, 10, "WindowName_Attr_is: " + WindowName);
      state.setAttribute("txtUlIdPerson", Integer.toString(GlobalData.getUlIdPerson(request)), request);
      state.setAttribute(ADDRESS_LIST_INCLUDE_PAGE_ATTR, request.getAttribute(ADDRESS_LIST_INCLUDE_PAGE_ATTR), request);

      ccmn42so = person.retrievePersonAddressList(ccmn42si);

    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.SSM_NO_ROWS_RETURNED:
        ccmn42so = null;

        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    }

    GrndsTrace.exitScope( /* ccmn42so */);
    return ccmn42so;
  }/* end populateAddressList */

}
