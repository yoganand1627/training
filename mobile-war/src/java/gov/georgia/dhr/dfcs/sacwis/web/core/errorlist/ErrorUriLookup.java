package gov.georgia.dhr.dfcs.sacwis.web.core.errorlist;

import java.util.HashMap;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.Nav;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabInfo;

/**
 * <p>Title: ErrorListLinkBean </p> <p>Description: Used to construct URIs and their respective task Codes for links in
 * ErrorList</p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author Stephan Brauchli
 * @version 1.0
 */
public class ErrorUriLookup {

  public static final String TRACE_TAG = "ErrorLinkLookup";

  static Map<ErrorListTriple, Integer> TRIPLE_TO_TAB_ID_MAP = new HashMap<ErrorListTriple, Integer>();
  static Map<ErrorListTriple, String> TRIPLE_TO_TASK_CD_MAP = new HashMap<ErrorListTriple, String>();

  public static String lookupURI(Integer messageId, String strPrgmCD, String strStageCD) {

    // Get TabId using ErrorListTriple( int msgId, String prgmCd, String stgCd )
    ErrorListTriple errTrip = new ErrorListTriple(messageId, strPrgmCD, strStageCD);
    // System.out.println("Just got errTrip(" + messageId.toString() + ", " + strPrgmCD + ", " + strStageCD + ")" );

    String strTabUri = null;
    String strLinkTask = "";
    TabInfo tabInfo = null;
    int tabID;
    if (TRIPLE_TO_TAB_ID_MAP.get(errTrip) != null) {
      tabID = TRIPLE_TO_TAB_ID_MAP.get(errTrip);
      if (strPrgmCD == null) {
        //noinspection AssignmentToNull
        strLinkTask = null;
      } else {
        strLinkTask = TRIPLE_TO_TASK_CD_MAP.get(errTrip);
      }
      // System.out.println("strLinkTask:" + strLinkTask + ".");
      // System.out.println("tabID:" + tabID + ".");
      tabInfo = Nav.getTabInfo(tabID);
    }
    // Now get URL for tab from tabID
    if (tabInfo != null) {
      // System.out.println("strTabUri = tabInfo.getUrl() :" + tabInfo.getUrl() + ".");
      strTabUri = tabInfo.getUrl();
    }
    // Concatenate the URI and the task code so that both can be returned
    return strTabUri + "-" + strLinkTask;
  }

}