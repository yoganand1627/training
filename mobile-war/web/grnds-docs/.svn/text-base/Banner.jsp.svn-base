<%
  //  JSP Name:     Banner
  //  Created by:   Stephan Brauchli
  //  Date Created: 02/07/03
  //
  //  General:
  //  ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE
  //  Banner.jsp--Mobile FOR NECESSARY MOBILE CHANGES
  //
  //  Description:
  //  The Banner.jsp contains the navigational metaphor for every page in IMPACT.
  //  It identifies how the page is accessed and sets the tabs accordingly.
  //  There are three cases which determine what tabs are active:
  //  1 - The screendefinitions of a page - used if a page is "always" under the same active tabs
  //  2 - The request parameters for L1/2/3  - populated by clicking on a tab
  //  3 - The task Code from GlobalData - overrides everything.  The task  code uniquely
  //  identifies a set of active tabs
  //
  // Change History:
  //  Date      User       Description
  //  --------  ---------  --------------------------------------------------
  // 04/18/2005 nallavs     SIR -23529 impact access to hand book.Added icon for
  //                       handbook in banner.jsp page
  // 08/30/2005  anandv     Added MOBILE-IMPACT comments in the General section
  // 09/15/2005 ochumd     Sir - 23990 Added http://www.211texas.com as the
  //                       URL for texas 211.
  // 04/26/2007  cooganp   Added link for SUCCESS
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
<%--<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants" %>--%>
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
  var LENSES_URL = '<%= LENSES_URL %>';
</script>
<%--****************** BEGIN TABS ******************--%>

<%--****************** BEGIN LEVEL 1 TABS ******************--%>
<table width="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left">
		    <a href="/workload/AssignedWorkload/displayAssignedWorkload"
		               tabindex="-1"><img alt="Assigned Workload" src="/grnds-docs/images/shared/btnWorkload.gif" border="0"></a>
            <a href="/person/PersonSearch/displayPersonSearch"
               tabindex="-1"><img alt="Person Search" src="/grnds-docs/images/shared/btnSearch.gif" border="0"></a>&nbsp;
    </td>
    <td align="right">
            <a href="/login/Login/logout"
               onclick="return confirm( '<%= MessageLookup.getMessageByNumber( Messages.MSG_LOGOFF_CONFIRM ) %>' );"
               tabindex="-1"><img alt="Log Off" src="/grnds-docs/images/shared/LogOff.gif" border="0"></a>&nbsp;
    </td>
  </tr>
  
</table>
<%--****************** END LEVEL 1 TABS ******************--%>

<%--****************** BEGIN LEVEL 2 TAB DISPLAY ******************--%>

<%--****************** END LEVEL 2 TAB DISPLAY ******************--%>


<%--****************** BEGIN LEVEL 3 TABS ******************--%>

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

  //Access to Lenses Website.
  function showLenses() {
    window.open(LENSES_URL);
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
  // Added Lenses          
  private static final String LENSES_URL = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "lensesPortalURL");          
  public static final boolean ENABLE_SYSTEM_OUT = false;

  public static final boolean DEBUG = false;

  public static final String TRACE_TAG = "Banner.";

%>
