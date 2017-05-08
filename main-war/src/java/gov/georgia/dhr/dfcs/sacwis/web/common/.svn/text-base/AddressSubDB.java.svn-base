package gov.georgia.dhr.dfcs.sacwis.web.common;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 *  Change History:
 *  Date         User      Description
 *  --------   --------  --------------------------------------------------
 *  02/27/2009  bgehlot  STGAP00012734: Remove the -None- from the County DropDown Box on Address Detail Page.
 *                                      Added these methods to get and set the county to be excluded in this case -None- 
 */

/** User: mkw Date: May 7, 2003 Time: 9:52:25 AM */
public class AddressSubDB implements Serializable {
  private String formName = null;
  private String pageMode = null;
  private boolean addressRequired = false;
  private boolean commentsRequired = false;
  private boolean streetRequired = false;
  private boolean zipRequired = false;
  private boolean addressDisabled = false;
  private boolean commentsDisabled = false;
  private boolean commentsVisible = false;
  private String addressSubmoduleName = null;
  private int tabIndex = 1;
  private ArrayList<String> excludeCounty = new ArrayList<String>();

  public static final String TRACE_TAG = "AddressSubDB";
  public static final String ADDRESS_SUB_DB_KEY = TRACE_TAG + ".ADDRESS_SUB_DB_KEY";

  public static void setIntoRequest(AddressSubDB AddressSubDB, HttpServletRequest request) {
    request.setAttribute(ADDRESS_SUB_DB_KEY, AddressSubDB);
  }

  public static AddressSubDB getFromRequest(HttpServletRequest request) {
    return (AddressSubDB) request.getAttribute(ADDRESS_SUB_DB_KEY);
  }

  public static void removeFromRequest(HttpServletRequest request) {
    request.removeAttribute(ADDRESS_SUB_DB_KEY);
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

  public boolean isAddressRequired() {
    return addressRequired;
  }

  public void setAddressRequired(boolean addressRequired) {
    this.addressRequired = addressRequired;
  }

  public boolean isCommentsRequired() {
    return commentsRequired;
  }

  public void setCommentsRequired(boolean commentsRequired) {
    this.commentsRequired = commentsRequired;
  }

  public boolean isAddressDisabled() {
    return addressDisabled;
  }

  public void setAddressDisabled(boolean addressDisabled) {
    this.addressDisabled = addressDisabled;
  }

  public boolean isCommentsDisabled() {
    return commentsDisabled;
  }

  public void setCommentsDisabled(boolean commentsDisabled) {
    this.commentsDisabled = commentsDisabled;
  }

  public boolean isCommentsVisible() {
    return commentsVisible;
  }

  public void setCommentsVisible(boolean commentsVisible) {
    this.commentsVisible = commentsVisible;
  }

  public String getAddressSubmoduleName() {
    return addressSubmoduleName;
  }

  public void setAddressSubmoduleName(String addressSubmoduleName) {
    this.addressSubmoduleName = addressSubmoduleName;
  }

  /*start hadjimh */
  public boolean isStreetRequired() {
    return streetRequired;
  }

  public void setStreetRequired(boolean streetRequired) {
    this.streetRequired = streetRequired;
  }

  public boolean isZipRequired() {
    return zipRequired;
  }

  public void setZipRequired(boolean zipRequired) {
    this.zipRequired = zipRequired;
  }

  /* end hadjimh */
  public int getTabIndex() {
    return tabIndex;
  }

  public void setTabIndex(int tabIndex) {
    this.tabIndex = tabIndex;
  }
  
  // STGAP00012734: Added these methods to get and set the county to be excluded in this case -None- 
  public ArrayList<String> getExcludeCounty() {
    return excludeCounty;
  }

  public void setExcludeCounty(ArrayList<String> excludeCounty) {
    this.excludeCounty = excludeCounty;
  }
}
