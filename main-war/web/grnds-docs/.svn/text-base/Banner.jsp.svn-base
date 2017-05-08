<%
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

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.Screen" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.IdTriple" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.Nav" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.NavTask" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.TabInfo" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%-- It seems necessary to make special provisions for intake navigation inside the metaphor.  --%>
<%
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
%>
<script type="text/javascript" src="/grnds-docs/js/shared/RoboHelp_CSH.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  var METAPHOR_LEVEL_1 = '<%= MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME %>';
  var HIDDEN_FIELD_KEY = '<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>';
  var METAPHOR_LEVEL_2 = '<%= MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME %>';
  var METAPHOR_LEVEL_3 = '<%= MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME %>';
  var FORMS_ONLINE_URL = '<%= FORMS_ONLINE_URL %>';
  var POLICY_HANDBOOK_URL = '<%= POLICY_HANDBOOK_URL %>';
  var IDS_URL = '<%= IDS_URL %>';
  var GHP_URL = '<%= GHP_URL %>';
</script>
<%--****************** BEGIN TABS ******************--%>

<%--****************** BEGIN LEVEL 1 TABS ******************--%>
<table width="780" cellpadding="0" cellspacing="0" height="60" border="0"
       background="/grnds-docs/images/metaphor/SHINES_word_header.jpg">
  <tr>
    <td align="right"><img src="/grnds-docs/images/dhr_dfcs_logo.gif"></td>
  </tr >
  <tr >
    <td>
      <table width="780" cellpadding="0" cellspacing="0" border="0">
      <tr class="even" height ="20">
       <td align="left" width="80%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	   <a class="header" href='http://www.georgia.gov' target='_blank'>Georgia.gov</a>&nbsp;&gt;&nbsp;
 	   <a class="header" href='http://www.georgia.gov/00/topic_index_channel/0,2092,4802_937045,00.html' target='_blank'>Agencies & Organizations</a>&nbsp;&gt;&nbsp;
 	   <a class="header" href='http://www.dhs.georgia.gov' target='_blank'>Department of Human Services</a>&nbsp;&gt;&nbsp;
 	   <a class="header" href='http://www.dfcs.dhs.georgia.gov' target='_blank'> DFCS</a>&nbsp;&gt;&nbsp;SHINES Portal
       </td>
       <td align="center" width="10%"><a class="header" 
              href="javaScript:RH_ShowHelp(0, '<%=WEB_HELP%>', HH_HELP_CONTEXT, <impact:WebHelpURL/>)">
              Help</a></td>
      <td align="center" width="10%"><a class="header" href="/login/Login/logout"
               onclick="return confirm( '<%= MessageLookup.getMessageByNumber( Messages.MSG_LOGOFF_CONFIRM ) %>' );">Logout</a></td>
     
     </tr>
     <tr class="odd"><td colspan="3">&nbsp;</td></tr>
     </table>
    </td>
    </tr>   
  <tr>
    <td align="left">
      <table width ="780" border="0" cellspacing="0" cellpadding="0" height="25" bgcolor="white">

        <tr>
          <%
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
          %><td height="25" width="111"><a href="<%=tabHREF%>" tabIndex="-1"><img src="/grnds-docs/images/metaphor/<%= imageName %>"
                                                                      alt="<%= altTag %>" height="25" width="111"
                                                                      border="0"></a></td>

          <%
            } // end for loop
          %>
        <td height="25" width="558">&nbsp;</td>  
        </tr>
      </table>
    </td>
  </tr>
</table>
<%--****************** END LEVEL 1 TABS ******************--%>
<%--****************** BEGIN LEVEL 2 TAB DISPLAY ******************--%>
<table width="780" cellpadding="0" cellspacing="0" border="0">
<tr>
<td class="SecondLevel">
<table border="0" cellpadding="0" cellspacing="0" align="left">
<tr>
<%
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

%>
<td class="SecondLevel" width="5"></td>
<td class="SecondLevelBar" width="1"></td>
<td class="SecondLevel" width="5"></td>
<%
} else {

%>
<td class="SecondLevelSides" width="2"></td>
<td class="SecondLevel" width="4"></td>
<td class="SecondLevel" width="4"></td>
<%
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

%>
<td>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td class="SecondLevelActL" width="5" height="38">
        <img src="/grnds-docs/images/metaphor/clear.gif" width="5" tabindex="-1">
      </td>
      <td class="SecondLevelActBody" width="100%">
        <div class="SecondLevelActTxt">
          <a <%= metaphorLinkStyle %> href="<%= href %>" <%= hotKey %> <%= onClick %> class="SecondLevelTxt"
                                      tabIndex="-1"><%=tab.getName()%>
          </a>
        </div>
      </td>
      <td class="SecondLevelActR" width="5">
        <img src="/grnds-docs/images/metaphor/clear.gif" width="5" tabindex="-1">
      </td>
    </tr>
  </table>
</td>
<%
} else {
  String mouseOver = "";
  //if this is second level tabs for level 1 case tab, add js hints
  //if (lev1TabId == TabConstants.CASE_CASESEARCH) {
  //  mouseOver = " onMouseOut=\"MM_showHideLayers( 'dropDown" + dropDownNumber + "', '', 'hide' )\" "
  //              + "onMouseOver=\"MM_showHideLayers( 'dropDown" + dropDownNumber + "', '', 'show' )\" ";
  //}
  // Draw inactive tabs

%>
<td class="SecondLevel" height="38"><a
        href="<%= href %>" <%= metaphorLinkStyleBlue %> <%= mouseOver %> <%= hotKey %> <%= onClick %> class="SecondLevelTxt"
        tabIndex="-1"><%=tab.getName()%>
</a></td>
<%
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

%>
</tr>
</table>
</td>
<td class="SecondLevel" width="2"></td>
<td class="SecondLevelSides" width="2"></td>
</tr>
</table>
<%--****************** END LEVEL 2 TAB DISPLAY ******************--%>


<%--****************** BEGIN LEVEL 3 TABS ******************--%>
<table width="780" cellpadding="0" cellspacing="0" border="0">
  <tr class="ThirdLevelRow">
    <td colspan="7" height="25">
      <table border="0" cellpadding="0" cellspacing="0">
        <tr>
          <%
            if (DEBUG) {
              trace("START L3 Tab Generation : " + strLevel3Constant);
              trace("GD contents are : " + GlobalData.toString(request) + ".");
            }
            //Create blue side bar on left below:

          %>
          <td class="SecondLevelSides" width="2" height="25"></td>
          <%
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
          %>
          <td>
            <table border="0" cellpadding="0" cellspacing="0" height="25" width="100%">
              <tr>
                <td width="5" class="ThirdLevelActL"></td>
                <td class="ThirdLevelActBody">
                  <span class="ThirdLevelTxtSelected"> <a href="<%= href %>" <%= metaphorLinkStyleBlue %>
                                                          class="ThirdlevelTxt" tabIndex="-1"><%=tab.getName()%>
                  </a> </span>
                </td>
                <td width="5" class="ThirdLevelActR"></td>
              </tr>
            </table>
          </td>
          <%} else {%>
          <td width="5"></td>
          <td>
            <a href="<%= href %>" <%= metaphorLinkStyle %> class="ThirdlevelTxt" tabIndex="-1"><%=tab.getName()%>
            </a>
          </td>
          <td width="5"></td>
          <%
                }
              } // end if visible
            } // end for

          %>
        </tr>
      </table>
    </td>
    <td class="SecondLevelSides" width="2"></td>
  </tr>
</table>
<%-- Prevent this comment from writing out on every page display
<!--  ******************   END LEVEL 3 TABS  ******************  -->

<!--  ******************   ONLOAD MAGIC  **********************
      SPB - 7/9/2003 - SIR 18758
      onClick of a tab the tab's 1st, 2nd, and 3rd level constants are set into
      the hidden fields below, and the page is submitted to navigate according
      to the tab click.  If the user clicks the back button, the values set into
      the hidden fields by the tab click were persisted, such that if a 3rd level
      tab were then clicked, it would display under the tabs of the previous navigation
      (before clicking the back button.  setHiddenTabs() gets called onload of the page,
      including back button navigation, and sets the value of the hidden fields to
      reflect the state of the tabs when the page was first rendered, effectively
      disregarding the tab-click -> back button setting.
-->
--%>
<script type="text/javascript" language="JavaScript1.2">
  function setHiddenTabs() {
    navigationForm.<%= MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME %>.value = '<%= strLevel1Constant %>';
    navigationForm.<%= MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME %>.value = '<%= strLevel2Constant %>';
    navigationForm.<%= MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME %>.value = '<%= strLevel3Constant %>';
  }
  window.attachEvent('onload', setHiddenTabs);
  //SIR 23529 --Impact access to hand book,This method is called,when user clicks Handbook icon.
  function showBook() {
    var myleft = screen.availWidth * 0.20;
    var mywidth = screen.availWidth - myleft - 10;
    var mytop = 1;
    var myheight = screen.availHeight - 100;

    window.open(POLICY_HANDBOOK_URL, "_blank",
            "dependent=yes,directories=no,height=" + myheight + ",left=" + myleft
                    + ",width=" + mywidth + ",top=" + mytop
                    + ",location=no,menubar=no,personalbar=no,resizable=yes,scrollbars=yes,status=yes,toolbar=yes");
  }
  
  //Access to IDS Website.
  function showIDS() {
    window.open(IDS_URL);
  }
  
  //Access to Georgia Health Partnership Website.
  function showGHP() {
    window.open(GHP_URL);
  } 
  
</script>

<!--- BEGIN Navigation Form --->
<form name="navigationForm" class="nomargins" action="/login/Login/lobby" method="post">
  <input type="hidden" name="stageType" value="<%= stageType %>"/>
  <input type="hidden" name="<%= MetaphorTabs.LEVEL_1_TAB_ATTRIBUTE_NAME %>" value="<%= strLevel1Constant %>"/>
  <input type="hidden" name="<%= MetaphorTabs.LEVEL_2_TAB_ATTRIBUTE_NAME %>" value="<%= strLevel2Constant %>"/>
  <input type="hidden" name="<%= MetaphorTabs.LEVEL_3_TAB_ATTRIBUTE_NAME %>" value="<%= strLevel3Constant %>"/>
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
  <!-- The following field's value is serialized to make it slightly harder to spoof. -->
  <input type="hidden" name="<%= UserProfileHelper.METAPHOR_USER_ID_KEY %>"
         value="<%= SerializationHelper.serializeObject( user.getUserID() )%>">
</form>
<!--BEGIN Drop Down Menu Divs and Tables-->
<%=dropDownDivString%>
<!--Insert Drop Down Menu Divs and Tables-->
<!--- END Navigation Form--->

<%-- Static methods and constants --%>
<%!
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

%>
