package gov.georgia.dhr.dfcs.sacwis.web.admin;

// prs architecture classes

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;

public class AdminAddressPhoneBean extends AddressBean {

  private String phone = "";
  private String phoneExt = "";

  public AdminAddressPhoneBean() {
  }

  protected AdminAddressPhoneBean(String addressSubmoduleName,
                                  HttpServletRequest request,
                                  BaseSessionStateManager sessionState) {
    super(addressSubmoduleName, request, sessionState);
    phone = FormattingHelper.decodeFormattedPhoneString(this.getAttribute(PHONE, request, sessionState));
    phoneExt = this.getAttribute(PHONE_EXT, request, sessionState);
  }

  protected AdminAddressPhoneBean(String addressSubmoduleName,
                                  HttpServletRequest request) {
    super(addressSubmoduleName, request);
    phone = FormattingHelper.decodeFormattedPhoneString(this.getAttribute(request, PHONE));
    phoneExt = this.getAttribute(request, PHONE_EXT);
  }

  public static AddressBean getFromRequest(HttpServletRequest request) {
    return AdminAddressPhoneBean.getFromRequest("", request);
  }

  public static AddressBean getFromRequest(String addressSubmoduleName,
                                           HttpServletRequest request) {
    AdminAddressPhoneBean bean = null;

    String beanName = addressSubmoduleName + REQUEST_NAME;

    if (request.getAttribute(beanName) != null) {
      bean = (AdminAddressPhoneBean) request.getAttribute(beanName);
    } else if (AdminAddressPhoneBean.isInRequest(addressSubmoduleName, request)) {
      bean = new AdminAddressPhoneBean(addressSubmoduleName, request);
    }
    return bean;
  }

  public static AddressBean getFromState(HttpServletRequest request) {
    return AdminAddressPhoneBean.getFromState("", request);
  }

  public static AddressBean getFromState(String addressSubmoduleName,
                                         HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);

    AdminAddressPhoneBean bean = null;

    String beanName = addressSubmoduleName + REQUEST_NAME;
    if (sessionState.getAttribute(beanName, request) != null) {
      bean = (AdminAddressPhoneBean) sessionState.getAttribute(beanName, request);
    }
    if (AdminAddressPhoneBean.isInState(addressSubmoduleName, request)) {
      bean = new AdminAddressPhoneBean(addressSubmoduleName, request);
    }
    return bean;
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

  public static final String PHONE = "adminPhonePhone";
  public static final String PHONE_EXT = "adminPhonePhoneExt";
}