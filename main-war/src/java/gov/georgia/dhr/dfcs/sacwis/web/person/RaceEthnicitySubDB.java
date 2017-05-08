package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/** User: mkw Date: May 7, 2003 Time: 10:36:55 AM */
public class RaceEthnicitySubDB implements Serializable {
  public int tabIndex = 1;
  private boolean isExpanded = false;

  public static final String TRACE_TAG = "RaceEthnicitySubDB";
  public static final String RACE_ETHNICITY_SUB_DB_KEY = TRACE_TAG + ".RACE_ETHNICITY_SUB_DB_KEY";

  public static void setIntoRequest(RaceEthnicitySubDB RaceEthnicitySubDB, HttpServletRequest request) {
    request.setAttribute(RACE_ETHNICITY_SUB_DB_KEY, RaceEthnicitySubDB);
  }

  public static RaceEthnicitySubDB getFromRequest(HttpServletRequest request) {
    return (RaceEthnicitySubDB) request.getAttribute(RACE_ETHNICITY_SUB_DB_KEY);
  }

  public static void removeFromRequest(HttpServletRequest request) {
    request.removeAttribute(RACE_ETHNICITY_SUB_DB_KEY);
  }

  public int getTabIndex() {
    return tabIndex;
  }

  public void setIsExpanded(boolean isExpanded) {
    this.isExpanded = isExpanded;
  }

  public boolean getIsExpanded() {
    return isExpanded;
  }

  public void setTabIndex(int tabIndex) {
    this.tabIndex = tabIndex;
  }
}
