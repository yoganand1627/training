package gov.georgia.dhr.dfcs.sacwis.web.reports;

import java.util.HashSet;
import java.util.Set;

import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;

/** Handles page flow and calls necessary logic for EventList/EventSearch */
public class ReportTestConversation
        extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "ReportTestConversation";

  public static final String CONVERSATION_URL = "/admin/ReportTest/";

  //conversation URLS
  public static final String EXECUTE_REPORT = getUrl("executeReport");
  public static final String REPORT_LIST = getUrl("displayReportList");
  public static final String REPORT_FORM = getUrl("displayReportForm");

  /** Scaffolding */
  public void blank_xa(GrndsExchangeContext context) {
    clearState(context);
  }

  public static boolean isDateParameter(String parameterName) {
    Set set = new HashSet();
    set.add("DATE_END");
    set.add("DATE_FROM");
    set.add("DATE_START");
    set.add("DATE_TO");
    set.add("DT_MONTH");
    set.add("INPUT_DATE");

    return (set.contains(parameterName));
  }

  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }

  /** Similar to StringHelper.toInteger, except it handles null and returns int */
  protected static int stringToInt(String string) {
    if (string == null) {
      return 0;
    }
    return Integer.parseInt(string);
  }
}
