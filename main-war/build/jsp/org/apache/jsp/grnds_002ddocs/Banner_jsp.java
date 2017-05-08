package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.IdTriple;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.Nav;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.NavTask;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabInfo;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;

public final class Banner_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  protected static String getUrl(TabInfo tab, String linkTaskCode) {
    String url = tab.getUrl();
    url += "?taskCD=";

    if (linkTaskCode == null) {
      return url + "NULL";
    }
    return url + linkTaskCode;
  }

  protected static String getStageType(HttpServletRequest request, NavTask navTask) {
    String stageType = GlobalData.getSzCdStage(request);
    //If no stage type was specified as an attribute, check for one as a parameter
    if (!StringHelper.isValid(stageType)) {
      if (stageType == null) {
        if (navTask != null) {
          stageType = navTask.getStageType();
        } else {
          stageType = request.getParameter(MetaphorTabs.STAGE_TYPE_ATTRIBUTE_NAME);
          if (stageType == null) {
            stageType = GlobalData.getSzCdStage(request);
          }
        }
      }
    }
    return stageType;
  }

  protected static int constantToTabId(String constant) {
    if (constant == null || "".equals(constant) || "null".equals(constant) || "NO_TAB".equalsIgnoreCase(constant)) {
      return 0;
    }
    String tabId = Nav.getTabIdUsingConstant(constant);
    return stringToInt(tabId);
  }

  public static void trace(String string) {
    //EILERSBE: NEVER CHECK THIS FILE IN WITH THESE LINES UNCOMMENTED

    // Changing to avoid System.out.println grep and to indicate safe usage.
    //if( ENABLE_SYSTEM_OUT )
    //{
    //System.out.println( string );
    //}

    //EILERSBE: NEVER CHECK THIS FILE IN WITH THESE LINES UNCOMMENTED
    //GrndsTrace.msg( TRACE_TAG, 7, string );
  }

  //!!! TODO This goes in a common function somewhere
  public static int stringToInt(String string) {
    try {
      return Integer.parseInt(string);
    } catch (NumberFormatException nfe) {
      if (DEBUG) {
        trace("Banner threw java.lang.NumberFormatException: " +
              "Try not using the test page, use the metaphor instead : ) " + nfe.getMessage());
      }
      nfe.printStackTrace();
      return 0;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  private static final String WEB_HELP = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "webHelp");
  private static final String FORMS_ONLINE_URL = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "formsOnLine");
  private static final String POLICY_HANDBOOK_URL = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "defaultPolicyURL");
  private static final String IDS_URL = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "idsOnlineURL");
  private static final String GHP_URL = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "ghpPortalURL");
  public static final boolean ENABLE_SYSTEM_OUT = false;

  public static final boolean DEBUG = false;

  public static final String TRACE_TAG = "Banner.";


  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


  //  JSP Name:     Banner (Portal)
  //  Created by:   Patrick Coogan
  //  Date Created: 08/26/09
  //
  //  General:
  //  Significant changes to this file should be reviewed in primary application
  //  Banner.jsp
  //
  //  Description:
  //  The Banner.jsp contains the navigational metaphor for
  //  pages in the SHINES vendor portal.
  //
  //
  // Change History:
  //  Date      User       Description
  //  --------  ---------  --------------------------------------------------
  //  09/06/2010 htvo		MR-067: Increased nbsp in tab display to compensate for NYTD youth screen 
  //                        that has only 2 tabs.
  //  08/26/2009 cooganp   Creation
  //


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      out.write('\r');
      out.write('\n');

  if (DEBUG) {
    String resourceName = "/" + this.getClass().getName().replace('.', '/') + ".class";
    trace("servlet: " + this.getClass().getResource(resourceName));
  }

  Screen screenObj = (Screen) request.getAttribute("screen");
  String screenName = screenObj.getName();

  UserProfile user = UserProfileHelper.getUserProfile(request);

  int lev1TabId = 0;
  int lev2TabId = 0;
  int lev3TabId = 0;
  String strLevel1Constant;
  String strLevel2Constant;
  String strLevel3Constant = "";

  //dropDownDivs gets appended to each time through the loop
  StringBuffer dropDownDivs = new StringBuffer("");
  String dropDownDivString = "";
  String linkTaskCode = null; // Task Code which varies from tab to tab and is set in GD when tab is clicked
  NavTask navTask = null;

  // Get TaskCode from GlobalData - used to identify active tabs
  String currentTaskCode = GlobalData.getSzCdTask(request);

  if (DEBUG) {
    trace("taskCode in Banner:'" + currentTaskCode + "'");
  }

  // If there is a TaskCode always use it 1st
  if ((!"0".equals(currentTaskCode) && !"".equals(currentTaskCode))) {
    if (DEBUG) {
      trace("");
      trace("1 currentTaskCode: '" + currentTaskCode + "'");
    }

    navTask = Nav.getNavTask(currentTaskCode);
    if (navTask != null) {
      lev1TabId = navTask.getLevel1Id();
      lev2TabId = navTask.getLevel2Id();
      lev3TabId = navTask.getLevel3Id();
    }
    strLevel1Constant = Nav.getTabConstantUsingTabId(String.valueOf(lev1TabId));
    strLevel2Constant = Nav.getTabConstantUsingTabId(String.valueOf(lev2TabId));

    if (lev3TabId != 0) {
      strLevel3Constant = Nav.getTabConstantUsingTabId(String.valueOf(lev3TabId));
    }
  } else // if no task code, get constants from screendefs
  {
    if (DEBUG) {
      trace("There is NO TASK CODE");
      trace("Get L constants from SCREENDEFS");
      trace("MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME: " + MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
      trace("MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME: " + MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
      trace("MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME: " + MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    }

    strLevel1Constant = (String) request.getAttribute(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
    strLevel2Constant = (String) request.getAttribute(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
    strLevel3Constant = (String) request.getAttribute(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);

    if (DEBUG) {
      trace("L1/L2/L3: after screendefs" + strLevel1Constant + "/" + strLevel2Constant + "/" + strLevel3Constant
            + ".");
    }
    // if L1 Constant was NOT in screendefs
    if (strLevel1Constant == null || "".equals(strLevel1Constant)) {
      if (DEBUG) {
        trace("2 stringLevel1Constant == null");
      }
      // Get active tabs if user clicked on metaphor OR if linked to page w/o screendefs persist previous L1 constant
      strLevel1Constant = request.getParameter(MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME);
      strLevel2Constant = request.getParameter(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);

      // in some cases only L3 Constant is specified in screendefs do not override these
      if (strLevel3Constant == null || "".equals(strLevel3Constant)) {
        if (DEBUG) {
          trace("3 stringLevel3Constant == null");
        }
        strLevel3Constant = request.getParameter(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
        if (DEBUG) {
          trace("strLevel3Constant in if strLevel3Constant == null =:" + strLevel3Constant + ".");
        }
      }
    } else if (strLevel2Constant == null || "".equals(strLevel2Constant)) {
      if (DEBUG) {
        trace("4 stringLevel2Constant == null");
      }
      // Get active tabs if user clicked on metaphor but L1 was specified in screendefs.xml
      strLevel2Constant = request.getParameter(MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME);
      if ("".equals(strLevel3Constant)) {
        if (DEBUG) {
          trace("5 stringLevel3Constant == null");
        }
        strLevel3Constant = request.getParameter(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
      }
      if (DEBUG) {
        trace("Level 1,2,3 Tabs clicked if L2 and L3 = null are  = " + strLevel1Constant + " , "
              + strLevel2Constant + " , " + strLevel3Constant);
      }
    }
    // in some cases only L3 Constant is specified in screendefs do not override these
    else if (strLevel3Constant == null || "".equals(strLevel3Constant)) {
      if (DEBUG) {
        trace("6 stringLevel3Constant == null");
      }
      strLevel3Constant = (String) request.getAttribute(MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME);
    }
  }

  if (DEBUG) {
    trace("L1/L2/L3 outside:" + strLevel1Constant + "/" + strLevel2Constant + "/" + strLevel3Constant + ".");
  }

  String stageType = getStageType(request, navTask);

      out.write("\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/RoboHelp_CSH.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  var METAPHOR_LEVEL_1 = '");
      out.print( MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME );
      out.write("';\r\n  var HIDDEN_FIELD_KEY = '");
      out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
      out.write("';\r\n  var METAPHOR_LEVEL_2 = '");
      out.print( MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME );
      out.write("';\r\n  var METAPHOR_LEVEL_3 = '");
      out.print( MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME );
      out.write("';\r\n  var FORMS_ONLINE_URL = '");
      out.print( FORMS_ONLINE_URL );
      out.write("';\r\n  var POLICY_HANDBOOK_URL = '");
      out.print( POLICY_HANDBOOK_URL );
      out.write("';\r\n  var IDS_URL = '");
      out.print( IDS_URL );
      out.write("';\r\n  var GHP_URL = '");
      out.print( GHP_URL );
      out.write("';\r\n</script>\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n<table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" height=\"60\" border=\"0\"\r\n       background=\"/grnds-docs/images/metaphor/SHINES_word_header.jpg\">\r\n  <tr>\r\n    <td align=\"right\"><img src=\"/grnds-docs/images/dhr_dfcs_logo.gif\"></td>\r\n  </tr >\r\n  <tr >\r\n    <td>\r\n      <table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n      <tr class=\"even\" height =\"20\">\r\n       <td align=\"left\" width=\"80%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n \t   <a class=\"header\" href='http://www.georgia.gov' target='_blank'>Georgia.gov</a>&nbsp;&gt;&nbsp;\r\n \t   <a class=\"header\" href='http://www.georgia.gov/00/topic_index_channel/0,2092,4802_937045,00.html' target='_blank'>Agencies & Organizations</a>&nbsp;&gt;&nbsp;\r\n \t   <a class=\"header\" href='http://www.dhs.georgia.gov' target='_blank'>Department of Human Services</a>&nbsp;&gt;&nbsp;\r\n \t   <a class=\"header\" href='http://www.dfcs.dhs.georgia.gov' target='_blank'> DFCS</a>&nbsp;&gt;&nbsp;SHINES Portal\r\n       </td>\r\n       <td align=\"center\" width=\"10%\"><a class=\"header\" \r\n              href=\"javaScript:RH_ShowHelp(0, '");
      out.print(WEB_HELP);
      out.write("', HH_HELP_CONTEXT, ");
      if (_jspx_meth_impact_WebHelpURL_0(_jspx_page_context))
        return;
      out.write(")\">\r\n              Help</a></td>\r\n      <td align=\"center\" width=\"10%\"><a class=\"header\" href=\"/login/Login/logout\"\r\n               onclick=\"return confirm( '");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_LOGOFF_CONFIRM ) );
      out.write("' );\">Logout</a></td>\r\n     \r\n     </tr>\r\n     <tr class=\"odd\"><td colspan=\"3\">&nbsp;</td></tr>\r\n     </table>\r\n    </td>\r\n    </tr>   \r\n  <tr>\r\n    <td align=\"left\">\r\n      <table width =\"780\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"25\" bgcolor=\"white\">\r\n\r\n        <tr>\r\n          ");

            if (DEBUG) {
              trace("START L1 Tab Generation  : " + strLevel1Constant);
            }
            lev1TabId = constantToTabId(strLevel1Constant);
            //TabInfo activeTab = Nav.getTabInfoForId( String.valueOf( lev1TabId ) );
            if (DEBUG) {
              trace("L1:   lev1TabId  : " + lev1TabId);
            }
            for (Iterator<TabInfo> iterator = MetaphorTabs.getLevel1Tabs(user); iterator.hasNext();) {
              TabInfo tab = iterator.next();
              //String version = "0";
              int iTabId = tab.getTabId();

              if (DEBUG) {
                trace("lev1TabId :" + lev1TabId + "getTabIdUsingConstant( strLevel1Constant ) == " + iTabId
                      + " / getTabConstantUsingTabId( iTabId ) : " + Nav.getTabConstantUsingTabId(String.valueOf(
                        iTabId)));
              }

              String imageName = tab.getInactiveImageName();
              if (iTabId == lev1TabId) {
                imageName = tab.getActiveImageName();
              }
              int imgNameLen = imageName.length();
              String altTag = imageName.substring(3, (imgNameLen - 6));
              // This is done by creating a string and putting the string in below because the formatting works better.
              String tabHREF = "javascript:setLevel1Tab('" + Nav.getTabConstantUsingTabId(String.valueOf(iTabId)) +
                                    "', '" + tab.getUrl() + "')";
          
      out.write("<td height=\"25\" width=\"111\"><a href=\"");
      out.print(tabHREF);
      out.write("\" tabIndex=\"-1\"><img src=\"/grnds-docs/images/metaphor/");
      out.print( imageName );
      out.write("\"\r\n                                                                      alt=\"");
      out.print( altTag );
      out.write("\" height=\"25\" width=\"111\"\r\n                                                                      border=\"0\"></a></td>\r\n\r\n          ");

            } // end for loop
          
      out.write("\r\n        <td height=\"25\" width=\"558\">&nbsp;</td>  \r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n<table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n<tr>\r\n<td class=\"SecondLevel\">\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\">\r\n<tr>\r\n");

  String metaphorLinkStyle =
          "style=\"font-family : Arial, Helvetica, Verdana, sans-serif; color: white; font-size: 9pt;\"";
          
  String metaphorLinkStyleBlue =
          "style=\"font-family : Arial, Helvetica, Verdana, sans-serif; color: blue; font-size: 9pt;\"";
                  
  if (DEBUG) {
    trace("START L2 Tab Generation: " + strLevel2Constant + ".");
  }
  boolean first = true;
  int dropDownNumber = 0;

  lev2TabId = constantToTabId(strLevel2Constant);

  Iterator<TabInfo> iterator = MetaphorTabs.getLevel2Tabs(user, lev1TabId, lev2TabId, stageType, request);
  while (iterator.hasNext()) {
    TabInfo tab = iterator.next();
    int iTabId = tab.getTabId();

    //it's only 0 the first time through the loop
    if (lev2TabId == 0) {
      lev2TabId = iTabId;
    }

    //if (lev1TabId == TabConstants.CASE_CASESEARCH) {
    //  String program = GlobalData.getSzCdStageProgram(request);
    //  IdTriple iTrip = new IdTriple(program, stageType, String.valueOf(iTabId));
    //  linkTaskCode = Nav.getTaskCodeForTriple(iTrip);
    //}
    // Call filter classes to determine whether tab is visible or not
    if (Nav.showTab(String.valueOf(iTabId), request)) {
      if (!first) {


      out.write("\r\n<td class=\"SecondLevel\" width=\"5\"></td>\r\n<td class=\"SecondLevelBar\" width=\"1\"></td>\r\n<td class=\"SecondLevel\" width=\"5\"></td>\r\n");

} else {


      out.write("\r\n<td class=\"SecondLevelSides\" width=\"2\"></td>\r\n<td class=\"SecondLevel\" width=\"4\"></td>\r\n<td class=\"SecondLevel\" width=\"4\"></td>\r\n");

  }
  //String strTabText = tab.getName();
  // Create link
  String href = "javascript:setLevel2Tab( " + "'" + Nav.getTabConstantUsingTabId(String.valueOf(iTabId))
                + "'," + "'" + getUrl(tab, linkTaskCode) + "' );";

  // Special provision for Intake navigation.  Page forms must be
  // submitted for auto-saving between second level tabs.

  String onClick = "";

//  if (("CALL_INFORMATION".equals(screenName) || "INTAKE_ACTIONS".equals(screenName))
//      && !PageModeConstants.VIEW.equals(PageMode.getPageMode(request))) {
//    String formName = IntakeConstants.FRM_CALL_INFO;
//    /*if (lev2TabId == TabConstants.INTAKE_ACTIONS_INTAKEACTIONS) {
//      formName = IntakeConstants.FRM_INTAKE_ACTIONS;
//    }*/
//    href = "javascript:setIntakeLevel2Tab( '" + Nav.getTabConstantUsingTabId(String.valueOf(iTabId)) + "', '"
//           + formName + "', '" + tab.getUrl() + "' );";
//    onClick = " onClick='setIsDirtyCalled( true );'";
//  }

  String hotKey = "";
  // If the tab is Call Info assign Alt-C as hot key
  // If the tab is Intake Actions assign Alt-I as hot key
//  /*if (iTabId == TabConstants.CALL_INFORMATION_CALLINFRMTN) {
//    hotKey = " accessKey=\"C\" onFocus=\"if( event.altKey ) { this.click() }\"";
//  }
//  if (iTabId == TabConstants.INTAKE_ACTIONS_INTAKEACTIONS) {
//    hotKey = " accessKey=\"I\" onFocus=\"if( event.altKey ) { this.click() }\"";
 // }*/

  if (iTabId == lev2TabId) {
    // draw active tab


      out.write("\r\n<td>\r\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"SecondLevelActL\" width=\"5\" height=\"38\">\r\n        <img src=\"/grnds-docs/images/metaphor/clear.gif\" width=\"5\" tabindex=\"-1\">\r\n      </td>\r\n      <td class=\"SecondLevelActBody\" width=\"100%\">\r\n        <div class=\"SecondLevelActTxt\">\r\n          <a ");
      out.print( metaphorLinkStyle );
      out.write(" href=\"");
      out.print( href );
      out.write('"');
      out.write(' ');
      out.print( hotKey );
      out.write(' ');
      out.print( onClick );
      out.write(" class=\"SecondLevelTxt\"\r\n                                      tabIndex=\"-1\">");
      out.print(tab.getName());
      out.write("\r\n          </a>\r\n        </div>\r\n      </td>\r\n      <td class=\"SecondLevelActR\" width=\"5\">\r\n        <img src=\"/grnds-docs/images/metaphor/clear.gif\" width=\"5\" tabindex=\"-1\">\r\n      </td>\r\n    </tr>\r\n  </table>\r\n</td>\r\n");

} else {
  String mouseOver = "";
  //if this is second level tabs for level 1 case tab, add js hints
  //if (lev1TabId == TabConstants.CASE_CASESEARCH) {
  //  mouseOver = " onMouseOut=\"MM_showHideLayers( 'dropDown" + dropDownNumber + "', '', 'hide' )\" "
  //              + "onMouseOver=\"MM_showHideLayers( 'dropDown" + dropDownNumber + "', '', 'show' )\" ";
  //}
  // Draw inactive tabs


      out.write("\r\n<td class=\"SecondLevel\" height=\"38\"><a\r\n        href=\"");
      out.print( href );
      out.write('"');
      out.write(' ');
      out.print( metaphorLinkStyleBlue );
      out.write(' ');
      out.print( mouseOver );
      out.write(' ');
      out.print( hotKey );
      out.write(' ');
      out.print( onClick );
      out.write(" class=\"SecondLevelTxt\"\r\n        tabIndex=\"-1\">");
      out.print(tab.getName());
      out.write("\r\n</a></td>\r\n");

      }
    } // end call filter classes

    //  *************************  START create dropdown divs **************************************************************
    dropDownDivs.append("<div id=\"" + "dropDown").append(dropDownNumber).append("\" style=\"position:absolute; ");
    dropDownDivs.append("left:232px; top:142px; width:780px; z-index:1; ");
    dropDownDivs.append("background-color: #ABC0CF; layer-background-color: ");
    dropDownDivs.append("#FFFF99; border: 1px none #000000; visibility: hidden\">\n");
    dropDownDivs.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\"");
    dropDownDivs.append(" cellpadding=\"0\" class=\"CSSbox\">\n");

    int rowCount = 0;
    StringBuffer tableRows = new StringBuffer("");

    Iterator<TabInfo> dropDownIterator = MetaphorTabs.getLevel3Tabs(user, lev1TabId, iTabId, stageType, request);
    if (dropDownIterator.hasNext()) {
      while (dropDownIterator.hasNext()) {
        TabInfo dropDownInfo = dropDownIterator.next();
        tableRows.append("<tr>\n");
        tableRows.append("<td width=\"5\">&nbsp;</td>\n");
        tableRows.append("<td class=\"CSSbox\">").append(dropDownInfo.getName()).append("</td>\n");
        tableRows.append("</tr>\n");
        rowCount++;
      }
      if (rowCount == 1) {
        tableRows.append("<tr>\n");
        tableRows.append("<td>&nbsp;</td>\n");
        tableRows.append("<td >&nbsp;</td>\n");
        tableRows.append("</tr>\n");
      }
    } else {
      tableRows.append("<tr>\n");
      tableRows.append("<td width=\"10\">&nbsp;</td>\n");
      tableRows.append("<td class=\"CSSbox\">").append(tab.getUnbrokenText()).append("</td>\n");
      tableRows.append("</tr>\n");
      tableRows.append("<tr>\n");
      tableRows.append("<td width=\"10\">&nbsp;</td>\n");
      tableRows.append("<td >&nbsp;</td>\n");
      tableRows.append("</tr>\n");
    }
    dropDownDivs.append(tableRows.toString());
    dropDownDivs.append("</table>\n");
    dropDownDivs.append("</div>\n");
    dropDownDivString = dropDownDivs.toString();
    first = false;
    dropDownNumber++;
  } //end for loop
  //  *************************  END create dropdown divs ****************************************************************


      out.write("\r\n</tr>\r\n</table>\r\n</td>\r\n<td class=\"SecondLevel\" width=\"2\"></td>\r\n<td class=\"SecondLevelSides\" width=\"2\"></td>\r\n</tr>\r\n</table>\r\n");
      out.write("\r\n\r\n\r\n");
      out.write("\r\n<table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n  <tr class=\"ThirdLevelRow\">\r\n    <td colspan=\"7\" height=\"25\">\r\n      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          ");

            if (DEBUG) {
              trace("START L3 Tab Generation : " + strLevel3Constant);
              trace("GD contents are : " + GlobalData.toString(request) + ".");
            }
            //Create blue side bar on left below:

          
      out.write("\r\n          <td class=\"SecondLevelSides\" width=\"2\" height=\"25\"></td>\r\n          ");

            lev3TabId = constantToTabId(strLevel3Constant);
            iterator = MetaphorTabs.getLevel3Tabs(user, lev1TabId, lev2TabId, stageType, request);

            while (iterator.hasNext()) {
              TabInfo tab = iterator.next();
              int iTabId = tab.getTabId();

              //it's only 0 the first time through the loop
              if (lev3TabId == 0) {
                lev3TabId = iTabId;
              }

              if (Nav.showTab(String.valueOf(iTabId), request)) {
                String href = "javascript:setLevel3Tab( " + "'" + Nav.getTabConstantUsingTabId(String.valueOf(iTabId))
                              + "'," + "'" + getUrl(tab, linkTaskCode) + "' );";

                if (iTabId == lev3TabId) {
          
      out.write("\r\n          <td>\r\n            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"25\" width=\"100%\">\r\n              <tr>\r\n                <td width=\"5\" class=\"ThirdLevelActL\"></td>\r\n                <td class=\"ThirdLevelActBody\">\r\n                  <span class=\"ThirdLevelTxtSelected\"> <a href=\"");
      out.print( href );
      out.write('"');
      out.write(' ');
      out.print( metaphorLinkStyleBlue );
      out.write("\r\n                                                          class=\"ThirdlevelTxt\" tabIndex=\"-1\">");
      out.print(tab.getName());
      out.write("\r\n                  </a> </span>\r\n                </td>\r\n                <td width=\"5\" class=\"ThirdLevelActR\"></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          ");
} else {
      out.write("\r\n          <td width=\"5\"></td>\r\n          <td>\r\n            <a href=\"");
      out.print( href );
      out.write('"');
      out.write(' ');
      out.print( metaphorLinkStyle );
      out.write(" class=\"ThirdlevelTxt\" tabIndex=\"-1\">");
      out.print(tab.getName());
      out.write("\r\n            </a>\r\n          </td>\r\n          <td width=\"5\"></td>\r\n          ");

                }
              } // end if visible
            } // end for

          
      out.write("\r\n        </tr>\r\n      </table>\r\n    </td>\r\n    <td class=\"SecondLevelSides\" width=\"2\"></td>\r\n  </tr>\r\n</table>\r\n");
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function setHiddenTabs() {\r\n    navigationForm.");
      out.print( MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME );
      out.write(".value = '");
      out.print( strLevel1Constant );
      out.write("';\r\n    navigationForm.");
      out.print( MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME );
      out.write(".value = '");
      out.print( strLevel2Constant );
      out.write("';\r\n    navigationForm.");
      out.print( MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME );
      out.write(".value = '");
      out.print( strLevel3Constant );
      out.write("';\r\n  }\r\n  window.attachEvent('onload', setHiddenTabs);\r\n  //SIR 23529 --Impact access to hand book,This method is called,when user clicks Handbook icon.\r\n  function showBook() {\r\n    var myleft = screen.availWidth * 0.20;\r\n    var mywidth = screen.availWidth - myleft - 10;\r\n    var mytop = 1;\r\n    var myheight = screen.availHeight - 100;\r\n\r\n    window.open(POLICY_HANDBOOK_URL, \"_blank\",\r\n            \"dependent=yes,directories=no,height=\" + myheight + \",left=\" + myleft\r\n                    + \",width=\" + mywidth + \",top=\" + mytop\r\n                    + \",location=no,menubar=no,personalbar=no,resizable=yes,scrollbars=yes,status=yes,toolbar=yes\");\r\n  }\r\n  \r\n  //Access to IDS Website.\r\n  function showIDS() {\r\n    window.open(IDS_URL);\r\n  }\r\n  \r\n  //Access to Georgia Health Partnership Website.\r\n  function showGHP() {\r\n    window.open(GHP_URL);\r\n  } \r\n  \r\n</script>\r\n\r\n<!--- BEGIN Navigation Form --->\r\n<form name=\"navigationForm\" class=\"nomargins\" action=\"/login/Login/lobby\" method=\"post\">\r\n  <input type=\"hidden\" name=\"stageType\" value=\"");
      out.print( stageType );
      out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
      out.print( MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME );
      out.write("\" value=\"");
      out.print( strLevel1Constant );
      out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
      out.print( MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME );
      out.write("\" value=\"");
      out.print( strLevel2Constant );
      out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
      out.print( MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME );
      out.write("\" value=\"");
      out.print( strLevel3Constant );
      out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
      out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
      out.write("\">\r\n  <!-- The following field's value is serialized to make it slightly harder to spoof. -->\r\n  <input type=\"hidden\" name=\"");
      out.print( UserProfileHelper.METAPHOR_USER_ID_KEY );
      out.write("\"\r\n         value=\"");
      out.print( SerializationHelper.serializeObject( user.getUserID() ));
      out.write("\">\r\n</form>\r\n<!--BEGIN Drop Down Menu Divs and Tables-->\r\n");
      out.print(dropDownDivString);
      out.write("\r\n<!--Insert Drop Down Menu Divs and Tables-->\r\n<!--- END Navigation Form--->\r\n\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_WebHelpURL_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:WebHelpURL
    gov.georgia.dhr.dfcs.sacwis.web.core.tags.WebHelpURLTag _jspx_th_impact_WebHelpURL_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.tags.WebHelpURLTag();
    _jspx_th_impact_WebHelpURL_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_WebHelpURL_0.setParent(null);
    int _jspx_eval_impact_WebHelpURL_0 = _jspx_th_impact_WebHelpURL_0.doStartTag();
    if (_jspx_th_impact_WebHelpURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
