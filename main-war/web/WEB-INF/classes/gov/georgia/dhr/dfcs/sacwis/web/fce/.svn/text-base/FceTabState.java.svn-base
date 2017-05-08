package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.io.Serializable;

public class FceTabState implements Serializable {
  public static final String APPLICATION_TAB_SET = "APP";
  public static final String REVIEW_TAB_SET = "REV";

  protected String eventStatus = null;
  protected String tabSet = null;
  protected boolean showChecklist = false;

  public boolean showApplicationTabSet() {
    return (APPLICATION_TAB_SET.equals(tabSet));
  }

  public boolean showReviewTabSet() {
    return (REVIEW_TAB_SET.equals(tabSet));
  }

  public String getEventStatus() {
    return eventStatus;
  }

  public void setEventStatus(String eventStatus) {
    this.eventStatus = eventStatus;
  }

  public String getTabSet() {
    return tabSet;
  }

  public void setTabSet(String tabSet) {
    this.tabSet = tabSet;
  }

  public boolean getShowChecklist() {
    return showChecklist;
  }

  public void setShowChecklist(boolean showChecklist) {
    this.showChecklist = showChecklist;
  }
}
