package gov.georgia.dhr.dfcs.sacwis.web.common;

// prs architecture classes

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public class AddressBean implements java.io.Serializable {

  // this allows you to have multiple addresses on a single page
  private String addressSubmoduleName = "";

  private String address1 = "";
  private String address2 = "";
  private String city = "";
  private String state = "";
  private String zip = "";
  private String zipSuff = "";
  private String county = "";
  private String comments = "";

  public static final String REQUEST_NAME = "addressBean";

  public static final String IN_REQUEST = "addressInRequest";

  public static final String IN_STATE = "addressInState";

  public static final String IS_VALID = "addressIsValid";
  public static final String FORM_ACTION = "addressAction";

  public static final String MULT_COUNTY = "addressMultCounty";

  public static final String ADDRESS_SUBMODULE_NAME = "addressSubmoduleName";
  public static final String SAVE_OR_VALIDATE = "addressSaveOrValidate";
  public static final String ADDRESS1 = "addressAddress1";
  public static final String ADDRESS2 = "addressAddress2";
  public static final String CITY = "addressCity";
  public static final String STATE = "addressState";
  public static final String ZIP = "addressZip";
  public static final String ZIP_SUFF = "addressZipSuff";
  public static final String COUNTY = "addressCounty";
  public static final String COMMENTS = "addressComments";

  protected AddressBean(String addressSubmoduleName,
                        HttpServletRequest request,
                        BaseSessionStateManager sessionState) {
    // get the prefix
    this.addressSubmoduleName = addressSubmoduleName;

    // use the prefix and the field names to get the values
    this.address1 = this.getAttribute(ADDRESS1, request, sessionState);
    this.address2 = this.getAttribute(ADDRESS2, request, sessionState);
    this.city = this.getAttribute(CITY, request, sessionState);
    this.state = this.getAttribute(STATE, request, sessionState);
    this.zip = this.getAttribute(ZIP, request, sessionState);
    this.zipSuff = this.getAttribute(ZIP_SUFF, request, sessionState);
    this.county = this.getAttribute(COUNTY, request, sessionState);
    this.comments = this.getAttribute(COMMENTS, request, sessionState);
  }

  protected AddressBean(String addressSubmoduleName,
                        HttpServletRequest request) {
    // get the prefix
    this.addressSubmoduleName = addressSubmoduleName;

    // use the prefix and the field names to get the values
    this.address1 = this.getAttribute(request, ADDRESS1);
    this.address2 = this.getAttribute(request, ADDRESS2);
    this.city = this.getAttribute(request, CITY);
    this.state = this.getAttribute(request, STATE);
    this.zip = this.getAttribute(request, ZIP);
    this.zipSuff = this.getAttribute(request, ZIP_SUFF);
    this.county = this.getAttribute(request, COUNTY);
    this.comments = this.getAttribute(request, COMMENTS);
  }

  public AddressBean(String addressSubmoduleName) {
    this.addressSubmoduleName = addressSubmoduleName;
  }

  public AddressBean() {
  }

  protected String getAttribute(String name,
                                HttpServletRequest request,
                                BaseSessionStateManager sessionState) {
    String attName = getAttributeName(name);
    String att = (String) sessionState.getAttribute(attName, request);
    FormattingHelper.formatString(att);
    return att;
  }

  protected String getAttribute(HttpServletRequest request, String name) {
    String attName = getAttributeName(name);
    String att = ContextHelper.getStringSafe(request, attName);
    return att;
  }

  public String getAttributeName(String name) {
    String attName = this.getAddressSubmoduleName() + name;
    return attName;
  }

  public void addToRequest(HttpServletRequest request) {
    request.setAttribute(getAttributeName(REQUEST_NAME), this);
    request.setAttribute(getAttributeName(IN_REQUEST), IN_REQUEST);
  }

  public static AddressBean getFromRequest(HttpServletRequest request) {
    return getFromRequest("", request);
  }

  public static AddressBean getFromRequest(String addressSubmoduleName,
                                           HttpServletRequest request) {
    AddressBean bean = null;

    String beanName = addressSubmoduleName + REQUEST_NAME;

    if (request.getAttribute(beanName) != null) {
      bean = (AddressBean) request.getAttribute(beanName);
    } else if (AddressBean.isInRequest(addressSubmoduleName, request)) {
      bean = new AddressBean(addressSubmoduleName, request);
    }
    return bean;
  }

  public void addToState(HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);
    sessionState.setAttribute(getAttributeName(REQUEST_NAME), this, request);
    request.setAttribute(getAttributeName(IN_STATE), IN_STATE);
  }

  public static AddressBean getFromState(HttpServletRequest request) {
    return getFromState("", request);
  }

  public static AddressBean getFromState(String addressSubmoduleName,
                                         HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);
    AddressBean bean = null;

    String beanName = addressSubmoduleName + REQUEST_NAME;
    if (sessionState.getAttribute(beanName, request) != null) {
      bean = (AddressBean) sessionState.getAttribute(beanName, request);
    }
    if (AddressBean.isInState(addressSubmoduleName, request)) {
      bean = new AddressBean(addressSubmoduleName, request);
    }
    return bean;
  }

  public static boolean isInRequest(String addressSubmoduleName, HttpServletRequest request) {
    boolean inState = false;

    String beanName = addressSubmoduleName + IN_REQUEST;

    inState = StringHelper.isValid((String) request.getAttribute(beanName)) ||
              StringHelper.isValid(request.getParameter(beanName));
    return inState;
  }

  public static boolean isInState(String addressSubmoduleName, HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(
                    BaseSessionStateManager.STATE_MANAGER_KEY);
    boolean inState = false;

    String beanName = addressSubmoduleName + IN_STATE;

    inState = StringHelper.isValid((String)
            sessionState.getAttribute(beanName, request));
    return inState;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getAddress2() {
    return address2;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getZip() {
    return zip;
  }

  public void setZipSuff(String zipSuff) {
    this.zipSuff = zipSuff;
  }

  public String getZipSuff() {
    return zipSuff;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getCounty() {
    return county;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getComments() {
    return comments;
  }

  public void setZipAndSuff(String zip) {
    if (zip == null) {
      this.zip = zip;
    } else {
      java.util.StringTokenizer strtok = new java.util.StringTokenizer(zip, "-");
      if (strtok.hasMoreTokens()) {
        this.zip = strtok.nextToken();
      }
      if (strtok.hasMoreTokens()) {
        this.zipSuff = strtok.nextToken();
      }
    }
  }

  public String getZipAndSuff() {
    String zipAndSuff = "";
    if ((zip != null) && (zip.length() == 5)) {
      zipAndSuff += zip;
      if ((zipSuff != null) && (zipSuff.length() == 4)) {
        zipAndSuff += "-" + zipSuff;
      }
    }
    return zipAndSuff;
  }

  public String getAddressSubmoduleName() {
    if (this.addressSubmoduleName == null) {
      return "";
    }
    return addressSubmoduleName;
  }

  public void setAddressSubmoduleName(String addressSubmoduleName) {
    this.addressSubmoduleName = addressSubmoduleName;
  }
}