package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.RepostCheckUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import java.io.IOException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.test.TestHelper;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  protected void infoBoxRow(JspWriter out, String name, int value) throws IOException {
    String valueString = null;
    if (value != 0) {
      valueString = "" + value;
    }
    infoBoxRow(out, name, valueString);
  }

  protected void infoBoxRow(JspWriter out, String name, String value) throws IOException {
    out.println("    <tr>");
    out.println("        <td class=\"infoBox\" width=\"40%\">" + name + ":&nbsp;</td>");
    out.println("        <td class=\"infoBox\" width=\"60%\">");
    if ((value != null) && ("".equals(value) == false)) {
      out.println(value);
    } else {
      out.println("&nbsp;");
    }
    out.println("                </td>");
    out.println("    </tr>");
  }


  private static final boolean DEBUG =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP"));

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(7);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/InfoBox.jsp");
    _jspx_dependants.add("/grnds-docs/Legend.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugGlobalData.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugRequestParameters.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugRequestAttributes.jsp");
    _jspx_dependants.add("/WEB-INF/debug.tld");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Global try-catch block
  try {

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_2(_jspx_page_context))
        return;
      out.write("\r\n<html>\r\n<head>\r\n  <title>");
      if (_jspx_meth_impact_insert_0(_jspx_page_context))
        return;
      out.write("</title>\r\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=\"stylesheet\">\r\n  <SCRIPT type=\"text/javascript\" language=\"JavaScript1.2\" src=\"/grnds-docs/js/shared/prsValidation.js\"></script>\r\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/syncscroll.js\"></script>\r\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/timer.js\"></script>\r\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n  <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
      out.write('\r');
      out.write('\n');

    final String SESSION_ID_NAME = "JSESSIONID";
    String jSessionId = session.getId();
// FIXME: Determine how to fix this in SJSAS.
// hopefully the mechanism for changing the sessionId to the id in the JSESSIONID cookie won't change
//
//    int lastIndexOfBang = jSessionId.lastIndexOf("!");
//    jSessionId = jSessionId.substring(0, lastIndexOfBang);

    //Set the user's logon id into the response as a cookie.  ...used in apache audit logging.
    gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile user = gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper.getUserProfile( request );
    if( user != null ) {

      out.write("\r\n      var today = new Date()\r\n      var expires = new Date()\r\n      //Set cookie expiration to 10 hours\r\n      expires.setTime(today.getTime() + 1000*60*60*10 )\r\n      setCookie('IMPACTLogonID', '");
      out.print(user.getUserLogonID() );
      out.write("', expires);\r\n");

    }

      out.write("\r\n    var oldSessionId = \"");
      out.print( jSessionId );
      out.write("\";\r\n    var newSessionId = getCookie(\"");
      out.print( SESSION_ID_NAME );
      out.write("\");\r\n    if ((oldSessionId != \"\") && (oldSessionId != newSessionId)) {\r\n      document.location = \"");
      out.print( AuthenticatedPrsHttpServlet.LOGIN_URL );
      out.write("\";\r\n    }\r\n");
      out.write("\r\n    function callErrorListFormSubmit() {\r\n      ErrorListForm.");
      out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
      out.write(".value=hiddenFieldStateForm.");
      out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
      out.write(".value;\r\n      var errorList = window.open('about:blank','errorWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=550,height=250');\r\n      ErrorListForm.target = \"errorWin\";\r\n      if( window.focus ) {\r\n        errorList.focus();\r\n      }\r\n      ErrorListForm.submit();\r\n    }\r\n\r\n    var pageHasLoaded = false;\r\n    //End Java Script\r\n  </script>\r\n</head>\r\n");

    String serializedErrorList = "";
    if(request.getAttribute(ErrorList.ERROR_LIST_ATTR) != null) {
      serializedErrorList = SerializationHelper.serializeObject(request.getAttribute(ErrorList.ERROR_LIST_ATTR));
      request.removeAttribute(ErrorList.ERROR_LIST_ATTR);

      out.write("\r\n<body topmargin=\"10px\" onload=\"callErrorListFormSubmit()\">\r\n");

    }
    else {

      out.write("\r\n<body topmargin=\"10px\">\r\n");

    }

      out.write("\r\n<div align=\"center\">\r\n  ");
      if (_jspx_meth_impact_insert_1(_jspx_page_context))
        return;
      out.write("\r\n  <table width=\"780\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"  background=\"/grnds-docs/images/bg.gif\" >\r\n    <tr>\r\n      <td>\r\n        <!-- Begin Title and Legend table-->\r\n        <table width=\"770\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\" class=\"parentTable\">\r\n          <tr>\r\n            <td width=\"33%\">\r\n              ");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
      if (_jspx_meth_impact_setAttribute_3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"infoBox\">\r\n");

  String info1 = (String) request.getAttribute("Info1");
  String info2 = (String) request.getAttribute("Info2");
  String info3 = (String) request.getAttribute("Info3");
  for (int i = 0; i < 3; i++) {
    String info = info1;
    if (i == 1) {
      info = info2;
    } else if (i == 2) {
      info = info3;
    }
    if (info == null) {
      info = "";

      out.write("\r\n<tr>\r\n  <td width=\"40%\">&nbsp;</td>\r\n  <td width=\"60%\">&nbsp;</td>\r\n</tr>\r\n");

    }
    //mdm: I could have made this a hashtable lookup based on info,
    // but I didn't know if the INFO STRING will ever be DIFFERENT THAN the DISPLAY STRING
    if ("User Name".equals(info)) {
      UserProfile infoBoxUser = UserProfileHelper.getUserProfile(request);
      infoBoxRow(out, "User Name", infoBoxUser.getUserFullName());
    } else if ("User ID".equals(info)) {
      UserProfile infoBoxUser = UserProfileHelper.getUserProfile(request);
      infoBoxRow(out, "User ID", infoBoxUser.getUserID());
    } else if ("CaseID".equals(info)) {
      infoBoxRow(out, "Case ID", GlobalData.getUlIdCase(request));
    } else if ("Stage Name".equals(info)) {
      infoBoxRow(out, "Stage Name", GlobalData.getSzNmStage(request));
    } else if ("Person Name".equals(info)) {
      infoBoxRow(out, "Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Case Name".equals(info)) {
      infoBoxRow(out, "Case Name", GlobalData.getSzNmCase(request));
    } else if ("Case or Stage Name".equals(info)) {
      infoBoxRow(out, "Case Name", GlobalData.getSzNmCase(request));
      infoBoxRow(out, "Stage Name", GlobalData.getSzNmStage(request));
    } else if ("Staff Name".equals(info)) {
      infoBoxRow(out, "Staff Name", GlobalData.getSzNmStaff(request));
    } else if ("Person Reviewed".equals(info)) {
      infoBoxRow(out, "Person Reviewed", GlobalData.getSzNmPersonFull(request));
    } else if ("Service".equals(info)) {
      infoBoxRow(out, "Service", GlobalData.getSzServiceDecode(request));
    } else if ("Resource Name".equals(info)) {
      infoBoxRow(out, "Resource Name", GlobalData.getSzNmResource(request));
    } else if ("Resource ID".equals(info)) {
      infoBoxRow(out, "Resource ID", GlobalData.getUlIdResource(request));
    } else if ("Full Name of Principal".equals(info)) {
      infoBoxRow(out, "Principal Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Full Person Name".equals(info)) {
      infoBoxRow(out, "Name", GlobalData.getSzNmPersonFull(request));
    } else if ("Account Number".equals(info)) {
      infoBoxRow(out, "Account Number", GlobalData.getSzNbrFinAccount(request));
    } else if ("Invoice ID".equals(info)) {
      infoBoxRow(out, "Invoice ID", GlobalData.getUlIdInvoice(request));
    } else if ("Invoice Phase".equals(info)) {
      infoBoxRow(out, "Invoice Phase", GlobalData.getSzCdInvoPhase(request));
    } else if ("Contract ID".equals(info)) {
      infoBoxRow(out, "Contract ID", GlobalData.getUlIdContract(request));
    } else if ("Period".equals(info)) {
      infoBoxRow(out, "Period", GlobalData.getUlNbrCnperPeriod(request));
    } else if ("Version".equals(info)) {
      infoBoxRow(out, "Version", GlobalData.getUlNbrCnverVersion(request));
    } else if ("Stage Code".equals(info)) {
      infoBoxRow(out, "Stage Code", Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, GlobalData.getSzCdStage(request)));
    } else if ("Stage ID".equals(info)) {
      infoBoxRow(out, "Stage ID", GlobalData.getUlIdStage(request));
    } else if ("Person ID".equals(info)) {
      infoBoxRow(out, "Person ID", GlobalData.getUlIdPerson(request));
    } else if ("Call ID".equals(info)) {
      infoBoxRow(out, "Call ID", GlobalData.getUlIdStage(request));
    } else if ("Waiver ID".equals(info)) {
      infoBoxRow(out, "Waiver ID", GlobalData.getUlIdEvent(request));
    } else if ("County".equals(info)) {
      infoBoxRow(out, "County", Lookup.simpleDecodeSafe(CodesTables.CCOUNT, GlobalData.getSzCdCounty(request)));
    } else if ("CRS ID".equals(info)) {
      infoBoxRow(out, "CRS ID", GlobalData.getUlIdCrs(request));
    }
  }

      out.write("\r\n</table>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n            </td>\r\n            <td width=\"33%\" class=\"pageTitle\">\r\n              ");
      if (_jspx_meth_impact_insert_2(_jspx_page_context))
        return;
      out.write("\r\n            </td>\r\n            <td width=\"33%\">\r\n              ");
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_setAttribute_6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_setAttribute_7(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

  String legend1 = (String)request.getAttribute( "Legend1" );
  String legend2 = (String)request.getAttribute( "Legend2" );

      out.write('\r');
      out.write('\n');
 
//*  JSP Name:     Legend
//*  Created by:   Stephan Brauchli
//*  Date Created: 11/04/02
//*
//*  Description:
//*  This JSP is used to case on the legend attributes set in a JSP's 
//*  ScreenDefinitions xml file to determine what data to display.
//*
//*  Values Supported:
//*  condRequired
//*  required
//*  newStage
//*  Reporter
//*  New Case or New Stage
//*  Superintendent
//*  Submitted Events
//*  Returned is Created
//*  
//*  
 
      out.write("\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n");

  for( int i = 0; i < 2; i++ )
  {
    String legend = legend1;
  if( i == 1 )
  {
    legend = legend2;
  }
  if( legend == null )
  {
    legend  = "";

      out.write("\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    </tr>\r\n");

  }
  if ("required".equals(legend) )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formRequiredText\">*</span>&nbsp;required field</td>\r\n    </tr>\r\n");

    }
    else if ("condRequired".equals(legend)  )
    {

      out.write("\r\n    <tr>\r\n      <td class=\"requiredInst\">\r\n      <span class=\"formCondRequiredText\">&#135;</span>&nbsp;conditionally required field\r\n    </td>\r\n    </tr>\r\n");

    }
    else if ("newStage".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;New Assignment</td>\r\n    </tr>\r\n");

    }
    else if ("Reporter".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;Reporter</td>\r\n    </tr>\r\n");

    }
    else if ("New Case or New Stage".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;New Case or New Stage of Case</td>\r\n    </tr>\r\n");

    }
    else if ("Superintendent".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">&clubs;</span>&nbsp;Superintendent (APS)</td>\r\n    </tr>\r\n");

    }
    else if ("Submitted Events".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;Submitted Events</td>\r\n    </tr>\r\n");

    }
    else if ("Returned is Created".equals(legend)  )
    {

      out.write("\r\n  <tr>\r\n    <td class=\"requiredInst\"><span class=\"formBoldedText\">#</span>&nbsp;Person Returned is Same Person just created</td>\r\n    </tr>\r\n");
   }
  }

      out.write("\r\n</table> \r\n");
      out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n        <!-- End Title and Legend table-->\r\n        <!-- Begin Parent table-->\r\n        <table width=\"770\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"parentTable\">\r\n          <tr>\r\n            <td>\r\n        <!--- BEGIN HtmlBody insertion (index.jsp) --->\r\n              ");
      if (_jspx_meth_impact_insert_3(_jspx_page_context))
        return;
      out.write("<br/>\r\n        <!--- END HtmlBody insertion (index.jsp)-- END Parent Table --->\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" background=\"/grnds-docs/images/metaphor/SACWIS_Footer.jpg\">\r\n    <tr><td>&nbsp;</td></tr>\r\n  </table>\r\n</div>  \r\n  <!--Begin Footer-->\r\n<br/>\r\n<div align=\"center\" class = \"footer\">\r\n \t<a class=\"footer\" href=\"http://www.georgia.gov/00/home/0,2061,4802,00.html\" target='_blank'>georgia.gov</a> |<a class=\"footer\" href=\"http://www.georgia.gov/00/topic_index_channel/0,2092,4802_937045,00.html\" target='_blank'>Agencies</a> |<a class=\"footer\" href=\"http://www.georgia.gov/00/static/0,2085,4802_0_0_Privacy,00.html\" target='_blank'>Privacy/Security</a> |<a class=\"footer\" href=\"http://www.georgia.gov/00/static/0,2085,4802_0_0_Important-Notices,00.html\" target='_blank'>Notices</a> |<a class=\"footer\" href=\"http://www.georgia.gov/00/static/0,2085,4802_0_0_Accessibility,00.html\" target='_blank'>Accessibility</a> |<a class=\"footer\"  href=\"http://www.georgia.gov/00/contact_us/0,2603,4802,00.html\" target='_blank'>Contact georgia.gov</a>\r\n");
      out.write("</div>\r\n<!--End Footer-->\r\n<br/>\r\n  \r\n\r\n");
 //Don't write Repost Check cookie unless it has a value.  ...This allows the
   //  cookie to not be overwritten after a session timeout
   String repostCodeKeyString = RepostCheckUtility.getCodeKeyString( request );
   if( repostCodeKeyString != null && !"".equals( repostCodeKeyString ) ) {

      out.write("\r\n  <script type=\"text/javascript\" language=\"javascript\" >\r\n      //This RepostCheckUtility Cookie holds the values of the Repost key code pairs\r\n      var myday = new Date()\r\n      var cookieExpires = new Date()\r\n      //Set cookie expiration to 10 hours\r\n      cookieExpires.setTime( myday.getTime() + 1000*60*60*10 )\r\n      setCookie('");
      out.print(RepostCheckUtility.COOKIE_NAME);
      out.write("', '");
      out.print( repostCodeKeyString );
      out.write("', cookieExpires);\r\n  </script>\r\n");
  } //End check for repostCodeKeyString

      out.write('\r');
      out.write('\n');
      out.write("\r\n  <form name=\"hiddenFieldStateForm\">\r\n    <input type=\"hidden\" name=\"requestStartTime\" value='");
      out.print(request.getParameter("requestStartTime") );
      out.write("'>\r\n    <input type=\"hidden\" name=\"requestTotalTime\">\r\n    ");
      if (_jspx_meth_impact_hiddenFieldSessionStateManager_0(_jspx_page_context))
        return;
      out.write("\r\n    <input type=\"hidden\" name=\"bSubmitted\" value=\"false\">\r\n  </form>\r\n  ");
      out.write("\r\n\r\n");

  String debugJsp = GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP");
  if ("true".equals(debugJsp))
    if (DEBUG) {

      out.write("\r\n  <div align=\"center\">\r\n  <table width=\"780\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n    <tr>\r\n      <th>Debugging Information:</th>\r\n    </tr>\r\n    <tr>\r\n     <td>\r\n       ");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugGlobalDataRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: GLOBAL DATA ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("GlobalData");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Global Data");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Field Name</th>\r\n      <th>Field Value</th>\r\n      <th>Field Name</th>\r\n      <th>Field Value</th>\r\n    </tr>\r\n    ");

      boolean newRow = true;
      Map globalDataGetters = TestHelper.getGlobalDataGetters();
      Iterator nameIt = globalDataGetters.keySet().iterator();
      while( nameIt.hasNext() )
      {
        if( newRow )
        {
          
          out.write("<tr class=\"");
          out.print( FormattingHelper.getRowCss( debugGlobalDataRowCss++ ) );
          out.write('"');
          out.write('>');

        }
        String name = (String)nameIt.next();
        
          out.write("<td>");
          out.print(name);
          out.write("</td>");

        Method getMethod = (Method)globalDataGetters.get( name );
        Class returnType = getMethod.getReturnType();
        if( returnType == Integer.TYPE )
        {
          int intValue = (Integer) getMethod.invoke(null, new Object[] {request});
          
          out.write("\r\n            <td>");
          out.print(FormattingHelper.formatInt( intValue ));
          out.write("</td>\r\n          ");

        }
        else if( returnType == String.class )
        {
          String stringValue = (String)getMethod.invoke( null, request);
          
          out.write("\r\n            <td>");
          out.print(FormattingHelper.formatString( stringValue ));
          out.write("</td>\r\n          ");

        }
        else if( returnType == Boolean.TYPE )
        {
          boolean booleanValue = (Boolean) getMethod.invoke(null, new Object[] {request});
          
          out.write("\r\n            <td>");
          out.print(booleanValue ? "True" : "False");
          out.write("</td>\r\n          ");

        }
        else if( returnType ==  org.exolab.castor.types.Date.class )
        {
          org.exolab.castor.types.Date date = (org.exolab.castor.types.Date)getMethod.invoke( null,
                                                                                              request);
          
          out.write("\r\n            <td>");
          out.print(FormattingHelper.formatDate( date ));
          out.write("</td>\r\n          ");

        }
        if( newRow )
        {
          newRow = false;
        }
        else
        {
          newRow = true;
          
          out.write("</tr>");

        }
      }
      if( !newRow )
      {
        
          out.write("\r\n          <tr><td>&nbsp;</td><td>&nbsp;</td></tr>\r\n        ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: GLOBAL DATA ***********/ 
      out.write('\r');
      out.write('\n');
      out.write("\r\n       ");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestParametersRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: REQUEST PARAMETERS ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_1.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_1.setName("Request Parameters");
      _jspx_th_impact_ExpandableSectionTag_1.setLabel("Request Parameters");
      _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Parameter Name</th>\r\n      <th>Parameter Value</th>\r\n    </tr>\r\n    ");

      Iterator params = request.getParameterMap().keySet().iterator();
      while ( params.hasNext() )
      {
        String paramName = (String) params.next();
        String paramString = request.getParameter( paramName );
    
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugRequestParametersRowCss++ ) );
          out.write("\">\r\n      <td>\r\n      ");
          out.print( paramName );
          out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if ( paramString.length() > 70 )
        {
          String shortParamString = paramString.substring(0,30) + "...";
          String functionName = "displayAttribute_" + Math.abs( new Random( System.currentTimeMillis() ).nextInt() );
          StringBuffer sb = new StringBuffer( paramString );
          for( int i = 0; i < sb.length(); i++ )
          {
            switch( sb.charAt( i ) )
            {
              case '\'':
                sb.replace( i, i + 1, "&apos;" );
                break;
              case '\"':
                sb.replace( i, i + 1, "&quot;" );
                break;
              case '<':
                sb.replace( i, i + 1, "&lt;" );
                break;
              case '>':
                sb.replace( i, i + 1, "&gt;" );
                break;
              case '&':
                sb.replace( i, i + 1, "&amp;" );
                break;
            }
          }
          paramString = sb.toString();
          
          out.write("\r\n          <SCRIPT LANGUAGE=\"javascript\">\r\n            function ");
          out.print(functionName);
          out.write("()\r\n            {\r\n              var descriptor = \"\";\r\n              descriptor += \"width=450,\";\r\n              descriptor += \"height=600,\";\r\n              descriptor += \"channelmode=0,\";\r\n              descriptor += \"dependent=0,\";\r\n              descriptor += \"directories=0,\";\r\n              descriptor += \"fullscreen=0,\";\r\n              descriptor += \"location=0,\";\r\n              descriptor += \"menubar=0,\";\r\n              descriptor += \"resizable=1,\";\r\n              descriptor += \"scrollbars=1,\";\r\n              descriptor += \"status=0,\";\r\n              descriptor += \"toolbar=0\";\r\n              var newWindow = window.open( '', '_blank', descriptor );\r\n              newWindow.document.title.innerHTML = '\" + beanName + \".xml';\r\n              ");

                StringTokenizer st = new StringTokenizer( paramString, "\n\r\f", false );
                while( st.hasMoreTokens() )
                {
                  
          out.write("\r\n                    newWindow.document.write( '");
          out.print(st.nextToken());
          out.write("' );\r\n                  ");

                  if( st.hasMoreTokens() )
                  {
                    
          out.write("\r\n                      newWindow.document.writeln( '<br>' );\r\n                    ");

                  }
                }
              
          out.write("\r\n            }\r\n          </SCRIPT>\r\n          <a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:");
          out.print(functionName);
          out.write("()\">");
          out.print(shortParamString);
          out.write("</a>\r\n          ");

        }
        else
        {
          out.print( paramString );
        }
      
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: REQUEST PARAMETERS ***********/ 
      out.write('\r');
      out.write('\n');
      out.write("\r\n       ");
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestAttributesRowCss=0;

      out.write("\r\n\r\n");
/********* BEGIN: REQUEST ATTRIBUTES ***********/ 
      out.write("\r\n<br>\r\n");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_2.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_2.setName("Request Attributes");
      _jspx_th_impact_ExpandableSectionTag_2.setLabel("Request Attributes");
      _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(-1);
      int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Attribute Name</th>\r\n      <th>Attribute Value</th>\r\n    </tr>\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugRequestAttributesRowCss++ ) );
          out.write("\">\r\n      <td align=\"top\">PageMode (in state)</td>\r\n      <td>");
          out.print( PageMode.getPageMode(request) );
          out.write("</td>\r\n    </tr>\r\n    ");

      Enumeration attributes = request.getAttributeNames();
      while ( attributes.hasMoreElements() )
      {
        String attName = (String) attributes.nextElement();
        Object attVal = request.getAttribute( attName );
        String attString ="";

    
          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss( debugRequestAttributesRowCss++ ) );
          out.write("\">\r\n      <td align=\"top\">\r\n      ");
          out.print( attName );
          out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
        
          out.write("\r\n          ");
          //  debug:displayXmlValueBean
          gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_0 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
          _jspx_th_debug_displayXmlValueBean_0.setPageContext(_jspx_page_context);
          _jspx_th_debug_displayXmlValueBean_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
          _jspx_th_debug_displayXmlValueBean_0.setXmlValueBean((XmlValueBean)attVal);
          int _jspx_eval_debug_displayXmlValueBean_0 = _jspx_th_debug_displayXmlValueBean_0.doStartTag();
          if (_jspx_th_debug_displayXmlValueBean_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");

        }
        else
        {
          attString = attVal.toString();
          if ( attString.length() > 70 )
          {
            String shortAttString = attString.substring(0,30) + "...";
            String functionName = "displayAttribute_" + Math.abs( new Random( System.currentTimeMillis() ).nextInt() );
            StringBuffer sb = new StringBuffer( attString );
            for( int i = 0; i < sb.length(); i++ )
            {
              switch( sb.charAt( i ) )
              {
                case '\'':
                  sb.replace( i, i + 1, "&apos;" );
                  break;
                case '\"':
                  sb.replace( i, i + 1, "&quot;" );
                  break;
                case '<':
                  sb.replace( i, i + 1, "&lt;" );
                  break;
                case '>':
                  sb.replace( i, i + 1, "&gt;" );
                  break;
                case '&':
                  sb.replace( i, i + 1, "&amp;" );
                  break;
              }
            }
            attString = sb.toString();
            
          out.write("\r\n            <SCRIPT LANGUAGE=\"javascript\">\r\n              function ");
          out.print(functionName);
          out.write("()\r\n              {\r\n                var descriptor = \"\";\r\n                descriptor += \"width=450,\";\r\n                descriptor += \"height=600,\";\r\n                descriptor += \"channelmode=0,\";\r\n                descriptor += \"dependent=0,\";\r\n                descriptor += \"directories=0,\";\r\n                descriptor += \"fullscreen=0,\";\r\n                descriptor += \"location=0,\";\r\n                descriptor += \"menubar=0,\";\r\n                descriptor += \"resizable=1,\";\r\n                descriptor += \"scrollbars=1,\";\r\n                descriptor += \"status=0,\";\r\n                descriptor += \"toolbar=0\";\r\n                var newWindow = window.open( '', '_blank', descriptor );\r\n                newWindow.document.title.innerHTML = '\" + beanName + \".xml';\r\n                ");

                  StringTokenizer st = new StringTokenizer( attString, "\n\r\f", false );
                  while( st.hasMoreTokens() )
                  {
                    
          out.write("\r\n                      newWindow.document.write( '");
          out.print(st.nextToken());
          out.write("' );\r\n                    ");

                    if( st.hasMoreTokens() )
                    {
                      
          out.write("\r\n                        newWindow.document.writeln( '<br>' );\r\n                      ");

                    }
                  }
                
          out.write("\r\n              }\r\n            </SCRIPT>\r\n            <a onClick=\"hrefDirtyBypass=true;\" href=\"javascript:");
          out.print(functionName);
          out.write("()\">");
          out.print(shortAttString);
          out.write("</a>\r\n            ");

          }
          else
          {
            out.print( attString );
          }
        }
      
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");

      }
    
          out.write("\r\n  </table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
/********* END: REQUEST ATTRIBUTES ***********/ 
      out.write('\r');
      out.write('\n');
      out.write("\r\n       ");
      out.write("\r\n       ");
      out.write("\r\n     </td>\r\n    </tr>\r\n  </table>\r\n  </div>\r\n");

    } //End debug check

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

    // BEGIN: Create javascript alert for any messages set into popup messages
    if ( request.getAttribute( BasePrsConversation.POPUP_MESSAGES ) != null ) {
      StringBuffer popupMessage = new StringBuffer();
      java.util.Map popupsMap = (java.util.Map) request.getAttribute( BasePrsConversation.POPUP_MESSAGES );
      java.util.Collection popupMsgs = popupsMap.values();
      java.util.Iterator popupMsgsIterator = popupMsgs.iterator();
      while ( popupMsgsIterator.hasNext() ) {
        popupMessage.append( (String) popupMsgsIterator.next() );
        popupMessage.append( "\\n" );
      }
      String message = popupMessage.toString();

      out.write("\r\n  <script type=\"text/javascript\" language=\"javascript\" >\r\n    alert( \"");
      out.print(message);
      out.write("\" );\r\n  </script>\r\n");

    }
    // END: Create javascript alert for any messages set into popup messages

      out.write("\r\n  <form name=\"ErrorListForm\" method=\"post\" action=\"/errorlist/ErrorList/display\">\r\n    <input type=\"hidden\" name=\"");
      out.print( ErrorList.ERROR_LIST_PARAM );
      out.write("\" value=\"");
      out.print( serializedErrorList );
      out.write("\" />\r\n    <input type=\"hidden\" name=\"");
      out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
      out.write("\" value=\"\" />\r\n  </form>\r\n  <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n    // toggleBody();\r\n    window.attachEvent('onload', setPerformanceStop );\r\n    window.attachEvent('onload', setIsDirtyCalledFalse );\r\n    function setIsDirtyCalledFalse() {\r\n      setIsDirtyCalled(false);\r\n    }\r\n    pageHasLoaded = true;\r\n  </script>\r\n<font color=\"#164861\">");
      out.print( request.getServerName() + ":" + request.getServerPort() );
      out.write("</font>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n");

   // If in BrownOut Mode then add the function to disable widgets
   // to the onLoad page event.
   if (ArchitectureConstants.BROWNOUT_MODE) {

      out.write("\r\n    <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n      window.attachEvent('onload', disableWidgets);\r\n    </script>\r\n");

  }

      out.write("\r\n\r\n</body>\r\n</html>\r\n");

  } catch (Exception e) {
    out.println("<h2>Your JSP generated an exception: </h2>");
    // Attempt to loop through and recursively unwrap the root causes of exceptions
    StringBuffer sb = new StringBuffer();
    sb.append(" ");
    // Start with the caught exception
    Throwable throwable = e;
    do {
      sb.insert(0, "\n</pre>\n");
      sb.insert(0, BasePrsException.getStackTrace(throwable));
      sb.insert(0, "\n<pre>\n");
      // Start by trying to get the JDK 1.4+ wrapped cause (usually works).
      throwable = throwable.getCause();
      if (throwable == null) {
        // This try attempts to execute the "getRootCause" method on the exception using reflection.
        try {
          throwable = (Throwable) throwable.getClass().getMethod("getRootCause").invoke(throwable);
        } catch (NoSuchMethodException nsme) {
          try {
            // Check to see if there is a getEnclosedError method (if this is wrapped by GrndsException, there might be.
            throwable = (Throwable) throwable.getClass().getMethod("getEnclosedError").invoke(throwable);
          } catch (Exception e1) {
            try {
              throwable = (Throwable) throwable.getClass().getMethod("getThrowable").invoke(throwable);
            } catch (Exception e2) {
              try {
                // None of the known methods to extract wrapped exceptions exist; loop through the methods that the
                //   object does have to find one that returns Throwable and use the first one that we find.
                Method[] methods = throwable.getClass().getMethods();
                Throwable newThrowable = null;
                for (int i = 0; i < methods.length; i++) {
                  Method method = methods[i];
                  Class returnType = method.getReturnType();
                  if (throwable.getClass().isAssignableFrom(returnType) && method.getParameterTypes().length == 0) {
                    newThrowable = (Throwable) method.invoke(throwable);
                    break;
                  }
                }
                throwable = newThrowable;
              } catch (Exception e3) {
                // There is no wrapped exception; end the loop by setting e to null
                //noinspection AssignmentToNull
                throwable = null;
              }
            }
          }
        } catch (Exception e3) {
          // Something odd happened; set e to null to end the loop.
          //noinspection AssignmentToNull
          throwable = null;
        }
      }
      if (throwable != null) {
        sb.insert(0, "\nWas the cause of:\n");
      }
    } while (throwable != null);
    out.println(sb.toString());
  }

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

  private boolean _jspx_meth_impact_setAttribute_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_0.setParent(null);
    _jspx_th_impact_setAttribute_0.setParameter("level1Tab");
    int _jspx_eval_impact_setAttribute_0 = _jspx_th_impact_setAttribute_0.doStartTag();
    if (_jspx_th_impact_setAttribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_1.setParent(null);
    _jspx_th_impact_setAttribute_1.setParameter("level2Tab");
    int _jspx_eval_impact_setAttribute_1 = _jspx_th_impact_setAttribute_1.doStartTag();
    if (_jspx_th_impact_setAttribute_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_2.setParent(null);
    _jspx_th_impact_setAttribute_2.setParameter("level3Tab");
    int _jspx_eval_impact_setAttribute_2 = _jspx_th_impact_setAttribute_2.doStartTag();
    if (_jspx_th_impact_setAttribute_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_0.setParent(null);
    _jspx_th_impact_insert_0.setParameter("HtmlTitle");
    int _jspx_eval_impact_insert_0 = _jspx_th_impact_insert_0.doStartTag();
    if (_jspx_th_impact_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_1.setParent(null);
    _jspx_th_impact_insert_1.setParameter("HtmlBanner");
    int _jspx_eval_impact_insert_1 = _jspx_th_impact_insert_1.doStartTag();
    if (_jspx_th_impact_insert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_3.setParent(null);
    _jspx_th_impact_setAttribute_3.setParameter("Info1");
    int _jspx_eval_impact_setAttribute_3 = _jspx_th_impact_setAttribute_3.doStartTag();
    if (_jspx_th_impact_setAttribute_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_4.setParent(null);
    _jspx_th_impact_setAttribute_4.setParameter("Info2");
    int _jspx_eval_impact_setAttribute_4 = _jspx_th_impact_setAttribute_4.doStartTag();
    if (_jspx_th_impact_setAttribute_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_5.setParent(null);
    _jspx_th_impact_setAttribute_5.setParameter("Info3");
    int _jspx_eval_impact_setAttribute_5 = _jspx_th_impact_setAttribute_5.doStartTag();
    if (_jspx_th_impact_setAttribute_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_2.setParent(null);
    _jspx_th_impact_insert_2.setParameter("HtmlTitle");
    int _jspx_eval_impact_insert_2 = _jspx_th_impact_insert_2.doStartTag();
    if (_jspx_th_impact_insert_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_6.setParent(null);
    _jspx_th_impact_setAttribute_6.setParameter("Legend1");
    int _jspx_eval_impact_setAttribute_6 = _jspx_th_impact_setAttribute_6.doStartTag();
    if (_jspx_th_impact_setAttribute_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_setAttribute_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:setAttribute
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag _jspx_th_impact_setAttribute_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.SetTabTag();
    _jspx_th_impact_setAttribute_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_setAttribute_7.setParent(null);
    _jspx_th_impact_setAttribute_7.setParameter("Legend2");
    int _jspx_eval_impact_setAttribute_7 = _jspx_th_impact_setAttribute_7.doStartTag();
    if (_jspx_th_impact_setAttribute_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_insert_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:insert
    gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag _jspx_th_impact_insert_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.InsertTag();
    _jspx_th_impact_insert_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_insert_3.setParent(null);
    _jspx_th_impact_insert_3.setParameter("HtmlBody");
    int _jspx_eval_impact_insert_3 = _jspx_th_impact_insert_3.doStartTag();
    if (_jspx_th_impact_insert_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_hiddenFieldSessionStateManager_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:hiddenFieldSessionStateManager
    gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag _jspx_th_impact_hiddenFieldSessionStateManager_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateTag();
    _jspx_th_impact_hiddenFieldSessionStateManager_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_hiddenFieldSessionStateManager_0.setParent(null);
    int _jspx_eval_impact_hiddenFieldSessionStateManager_0 = _jspx_th_impact_hiddenFieldSessionStateManager_0.doStartTag();
    if (_jspx_th_impact_hiddenFieldSessionStateManager_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
