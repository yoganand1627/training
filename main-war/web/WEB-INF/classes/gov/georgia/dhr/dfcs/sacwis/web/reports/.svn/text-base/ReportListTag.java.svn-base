package gov.georgia.dhr.dfcs.sacwis.web.reports;

// java classes

import gov.georgia.dhr.dfcs.sacwis.web.core.tags.BaseDocListTag;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class ReportListTag extends BaseDocListTag {
  // variables that must be overridden by subclasses
  public static final String FORM_NAME = "Reports";
  public static final String DESTINATION = "/admin/Reports/confirm";
  public static final String SELECT_NAME = "report_CLEAN";
  public static final String TEXT_UPPER = "Report";
  public static final String TEXT_LOWER = "report";
  public static final String CFP_STAMP = "ulRptLstCfpStamp";
  public static final String TRACE_TAG = "ReportListTag";

  private long cfpStamp = 0;

  public ReportListTag() {
    super();
  }

  public String getTextUpper() {
    return TEXT_UPPER;
  }

  public String getTextLower() {
    return TEXT_LOWER;
  }

  public String getDestination() {
    return DESTINATION;
  }

  public String getSelectName() {
    return SELECT_NAME;
  }

  public String getFormName() {
    return FORM_NAME;
  }

  public void setCfpStamp(long stamp) {
    cfpStamp = stamp;
  }

  public long getCfpStamp() {
    return cfpStamp;
  }
}