package gov.georgia.dhr.dfcs.sacwis.web.admin;

// prs architecture classes

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class AdminPhoneBean {

  private String phone = "";
  private String phoneExt = "";

  public AdminPhoneBean() {
  }

  protected AdminPhoneBean(HttpServletRequest request,
                           BaseSessionStateManager sessionState) {
    phone = FormattingHelper.formatString((String) sessionState.getAttribute(PHONE, request));
    phoneExt = FormattingHelper.formatString((String) sessionState.getAttribute(PHONE_EXT, request));
  }

  protected AdminPhoneBean(HttpServletRequest request) {
    phone = ContextHelper.getStringSafe(request, PHONE);
    phoneExt = ContextHelper.getStringSafe(request, PHONE_EXT);
  }

  public void addToRequest(HttpServletRequest request) {
    request.setAttribute(REQUEST_NAME, this);
    request.setAttribute(IN_REQUEST, IN_REQUEST);
  }

  public static AdminPhoneBean getFromRequest(HttpServletRequest request) {
    AdminPhoneBean bean = null;
    if (request.getAttribute(REQUEST_NAME) != null) {
      bean = (AdminPhoneBean) request.getAttribute(REQUEST_NAME);
    } else if (AdminPhoneBean.isInRequest(request)) {
      bean = new AdminPhoneBean(request);
    }
    return bean;
  }

  public void addToState(HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);
    sessionState.setAttribute(REQUEST_NAME, this, request);
    request.setAttribute(IN_STATE, IN_STATE);
  }

  public static AdminPhoneBean getFromState(HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);
    AdminPhoneBean bean = null;
    if (sessionState.getAttribute(REQUEST_NAME, request) != null) {
      bean = (AdminPhoneBean) sessionState.getAttribute(REQUEST_NAME, request);
    }
    if (AdminPhoneBean.isInState(request)) {
      bean = new AdminPhoneBean(request);
    }
    return bean;
  }

  public static boolean isInRequest(HttpServletRequest request) {
    boolean inState = false;
    inState = StringHelper.isValid((String) request.getAttribute(IN_REQUEST)) ||
              StringHelper.isValid(request.getParameter(IN_REQUEST));
    return inState;
  }

  public static boolean isInState(HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);
    boolean inState = false;
    inState = StringHelper.isValid((String)
            sessionState.getAttribute(IN_STATE, request));
    return inState;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPhoneExt(String phoneExt) {
    this.phoneExt = phoneExt;
  }

  public String getPhoneExt() {
    return phoneExt;
  }

  public static final String PHONE = "admin_phone_phone";
  public static final String PHONE_EXT = "admin_phone_phone_ext";

  public static final String REQUEST_NAME = "admin_phone_bean";
  public static final String IN_REQUEST = "admin_phone_in_request";
  public static final String IN_STATE = "admin_phone_in_state";
}