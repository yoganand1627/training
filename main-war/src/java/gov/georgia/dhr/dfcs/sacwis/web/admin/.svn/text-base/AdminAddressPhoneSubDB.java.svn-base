package gov.georgia.dhr.dfcs.sacwis.web.admin;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/** User: mkw Date: May 7, 2003 Time: 9:14:55 AM */
public class AdminAddressPhoneSubDB implements Serializable {
  private String formName = null;
  private String pageMode = null;
  private String addressPhoneSectionHeader = null;
  private boolean addressRequired = false;
  private boolean addressDisabled = false;
  private boolean commentsVisible = true;
  private boolean commentsRequired = false;
  private boolean commentsDisabled = false;
  private boolean phoneRequired = false;
  private boolean phoneDisabled = false;
  private String addressSubmoduleName = null;
  private int tabIndex = 1;

  public static final String TRACE_TAG = "AdminAddressPhoneSubDB";
  public static final String ADMIN_ADDRESS_PHONE_SUB_DB_KEY = TRACE_TAG + ".ADMIN_ADDRESS_PHONE_SUB_DB_KEY";

  public static void setIntoRequest(AdminAddressPhoneSubDB adminAddressPhoneSubDB, HttpServletRequest request) {
    request.setAttribute(ADMIN_ADDRESS_PHONE_SUB_DB_KEY, adminAddressPhoneSubDB);
  }

  public static AdminAddressPhoneSubDB getFromRequest(HttpServletRequest request) {
    return (AdminAddressPhoneSubDB) request.getAttribute(ADMIN_ADDRESS_PHONE_SUB_DB_KEY);
  }

  public static void removeFromRequest(HttpServletRequest request) {
    request.removeAttribute(ADMIN_ADDRESS_PHONE_SUB_DB_KEY);
  }

  public String getFormName() {
    return formName;
  }

  public void setFormName(String formName) {
    this.formName = formName;
  }

  public String getPageMode() {
    return pageMode;
  }

  public void setPageMode(String pageMode) {
    this.pageMode = pageMode;
  }

  public String getAddressPhoneSectionHeader() {
    return addressPhoneSectionHeader;
  }

  public void setAddressPhoneSectionHeader(String addressPhoneSectionHeader) {
    this.addressPhoneSectionHeader = addressPhoneSectionHeader;
  }

  public boolean isAddressRequired() {
    return addressRequired;
  }

  public void setAddressRequired(boolean addressRequired) {
    this.addressRequired = addressRequired;
  }

  public boolean isAddressDisabled() {
    return addressDisabled;
  }

  public void setAddressDisabled(boolean addressDisabled) {
    this.addressDisabled = addressDisabled;
  }

  public boolean isCommentsVisible() {
    return commentsVisible;
  }

  public void setCommentsVisible(boolean commentsVisible) {
    this.commentsVisible = commentsVisible;
  }

  public boolean isCommentsRequired() {
    return commentsRequired;
  }

  public void setCommentsRequired(boolean commentsRequired) {
    this.commentsRequired = commentsRequired;
  }

  public boolean isCommentsDisabled() {
    return commentsDisabled;
  }

  public void setCommentsDisabled(boolean commentsDisabled) {
    this.commentsDisabled = commentsDisabled;
  }

  public boolean isPhoneRequired() {
    return phoneRequired;
  }

  public void setPhoneRequired(boolean phoneRequired) {
    this.phoneRequired = phoneRequired;
  }

  public boolean isPhoneDisabled() {
    return phoneDisabled;
  }

  public void setPhoneDisabled(boolean phoneDisabled) {
    this.phoneDisabled = phoneDisabled;
  }

  public String getAddressSubmoduleName() {
    return addressSubmoduleName;
  }

  public void setAddressSubmoduleName(String addressSubmoduleName) {
    this.addressSubmoduleName = addressSubmoduleName;
  }

  public int getTabIndex() {
    return tabIndex;
  }

  public void setTabIndex(int tabIndex) {
    this.tabIndex = tabIndex;
  }
}
