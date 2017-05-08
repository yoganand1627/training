package org.apache.jsp.grnds_002ddocs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.util.Date;
import org.grnds.facility.config.GrndsConfiguration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
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
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;

public final class LogError_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final boolean DEBUG
          = "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "debugJSP"));

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(8);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/test/Debug.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugGlobalData.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugRequestParameters.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugRequestAttributes.jsp");
    _jspx_dependants.add("/WEB-INF/debug.tld");
    _jspx_dependants.add("/grnds-docs/test/DebugStateAttributes.jsp");
    _jspx_dependants.add("/grnds-docs/test/DebugSessionAttributes.jsp");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*  JSP Name:     IMPACT Error page
//*  Created by:   Brad Eilers
//*  Date Created: 19 July 2002
//*
//*
//*  Description:
//*  IMPACT's version of the "Data Access Error" message.
//*
//*
//** Change History:
//**  Date          User        Description
//**  ----------    ----------  --------------------------------------------
//**  07/19/2002    EILERSBE    Initial creation.
//**
//**  06/10/2003        KRD     Corrected the message text to match the
//**                            existing message in CAPS.
//**  0724/2005  MWERLE  SIR 23728 - Updated to handle ServiceException

      out.write("\r\n\r\n<html>\r\n<head>\r\n  <title>ERROR Page</title>\r\n  <SCRIPT type=\"text/javascript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n  <LINK href=\"/grnds-docs/css/impact.css\" rel=stylesheet>\r\n</head>\r\n");

  PrsException e = ( PrsException )request.getAttribute( "exception.display" );

      out.write("\r\n<body bgcolor=\"#FFFFFF\" text=\"#996666\" link=\"#FF0000\" alink=\"#FF9999\" vlink=\"#663333\">\r\n  ");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmLogError");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/common/Error/displayError");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    <table width=\"780\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" background=\"/grnds-docs/images/bg.gif\">\r\n      <tr>\r\n        <td class=\"SecondLevelSides\" height=\"35\" width=\"2\">&nbsp;</td>\r\n        <td class=\"SecondLevel\" height=\"35\" width=\"776\">\r\n          <div align=\"center\" class=\"errorTitle\">IMPACT ERROR</div>\r\n        </td>\r\n        <td class=\"SecondLevelSides\" height=\"35\" width=\"2\">&nbsp;</td>\r\n      </tr>\r\n      <tr>\r\n        <td colspan=\"3\">&nbsp;</td>\r\n      </tr>\r\n      <tr>\r\n        <td colspan=\"3\">\r\n          ");
          out.write("\r\n          <table class=\"tableBorder\" align=\"center\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" width=\"760\">\r\n            <tr>\r\n              <th colspan=\"2\" height=\"20\">The system has generated an error.</th>\r\n            </tr>\r\n            <tr>\r\n              <td colspan=\"2\" class=\"formErrorText\">\r\n                An error has occurred in IMPACT.\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td colspan=\"2\">\r\n                <ul>\r\n                  <li>\r\n                    To go back and try again, please click <a href=\"javascript:history.back(1)\">here</a>\r\n                    or use the \"Back\" button.\r\n                  </li>\r\n                  <li>\r\n                    To reset your Impact session and return to your Assigned Workload, please click\r\n                    <a href=\"/common/Error/displayAssignedWorkload\">here</a>.\r\n                  </li>\r\n                  <li>\r\n                    If you would like assistance with this error, please contact the Customer Service Center\r\n");
          out.write("                    at (877) 642-4777 and provide them with the following information:\r\n                    <br>\r\n                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n                      <tr valign=\"top\">\r\n                        <td class=\"formInfoText\">UniqueID:</td>\r\n                        <td>");
          out.print(e.getUniqueId());
          out.write("</td>\r\n                      </tr>\r\n                      <tr valign=\"top\">\r\n                        <td class=\"formInfoText\">Exception:</td>\r\n                        <td>");
          out.print(e.getClass().getName());
          out.write("</td>\r\n                      </tr>\r\n                      <tr valign=\"top\">\r\n                        <td class=\"formInfoText\">Message:</td>\r\n                        <td>");
          out.print(e.getMessage());
          out.write("</td>\r\n                      </tr>\r\n                      <tr valign=\"top\">\r\n                        <td class=\"formInfoText\">Time:</td>\r\n                        <td>");
          out.print(new Date());
          out.write("</td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"2\" class=\"formInfoText\">\r\n                          If the Customer Service Center is unable to resolve this error, please request\r\n                          the Customer Service Center Ticket ID and enter it in the field below.  Then,\r\n                          press the submit button to record details of the error for the Impact\r\n                          Development Team.\r\n                        </td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"2\" align=\"right\">\r\n                          <table cellpadding=\"3\" cellspacing=\"0\" border=\"0\">\r\n                            <tr>\r\n                              <td>");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n                              <td>");
          if (_jspx_meth_impact_ButtonTag_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("</td>\r\n                            </tr>\r\n                          </table>\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </li>\r\n                </ul>\r\n              </td>\r\n            </tr>\r\n          </table>\r\n        </td>\r\n      </tr>\r\n    </table>\r\n    <table width=\"780\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"\r\n           background=\"/grnds-docs/images/metaphor/SACWIS_Footer.jpg\">\r\n      <tr><td>&nbsp;</td></tr>\r\n    </table>\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  if( DEBUG )
  {

      out.write("\r\n  <br><br>\r\n  ");
      //  impact:ExpandableSectionTag
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
      _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_ExpandableSectionTag_0.setParent(null);
      _jspx_th_impact_ExpandableSectionTag_0.setName("Error");
      _jspx_th_impact_ExpandableSectionTag_0.setId("errorDetail");
      _jspx_th_impact_ExpandableSectionTag_0.setLabel("Error Details");
      _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(1);
      int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
      if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

    if ( e instanceof ServiceException )
    {
      ServiceException se = (ServiceException) e;

          out.write("\r\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n      <tr>\r\n        <td>Error Message Text:</td>\r\n        <td>");
          out.print(  se.getErrorMessage() );
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n        <td>Error Code:</td>\r\n        <td>");
          out.print(  se.getErrorCode() );
          out.write(' ');
          out.write('[');
          out.print( MessageLookup.getMessageByNumber( se.getErrorCode() ) );
          out.write("]</td>\r\n      </tr>\r\n    </table>\r\n");

    }

          out.write("\r\n    <pre>\r\n");

  ((Throwable) e).printStackTrace( new PrintWriter( out ) );
  ((Throwable) e).printStackTrace();

          out.write("\r\n    </pre>\r\n    <br>\r\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n      <tr>\r\n        <th>Debugging Information:</th>\r\n      </tr>\r\n      <tr>\r\n        <td>\r\n          ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugGlobalDataRowCss=0;

          out.write("\r\n\r\n");
/********* BEGIN: GLOBAL DATA ***********/ 
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("GlobalData");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Global Data");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(-1);
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
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
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/********* END: GLOBAL DATA ***********/ 
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestParametersRowCss=0;

          out.write("\r\n\r\n");
/********* BEGIN: REQUEST PARAMETERS ***********/ 
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("Request Parameters");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Request Parameters");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(-1);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
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
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/********* END: REQUEST PARAMETERS ***********/ 
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugRequestAttributesRowCss=0;

          out.write("\r\n\r\n");
/********* BEGIN: REQUEST ATTRIBUTES ***********/ 
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("Request Attributes");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Request Attributes");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(-1);
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
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
              _jspx_th_debug_displayXmlValueBean_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
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
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/********* END: REQUEST ATTRIBUTES ***********/ 
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugStateAttributesRowCss=0;

          out.write("\r\n\r\n");
/********* BEGIN: STATE ATTRIBUTES ***********/ 
          out.write('\r');
          out.write('\n');

  debugStateAttributesRowCss=0;

          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("State Attributes");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("State Attributes");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex(-1);
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Attribute Name</th>\r\n      <th>Attribute Value</th>\r\n    </tr>\r\n    ");

      BaseSessionStateManager debugPageState = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
      Iterator stateAttributes = debugPageState.getAttributeNames( request );
      while ( stateAttributes.hasNext() )
      {
        String attName = (String) stateAttributes.next();
        Object attVal = debugPageState.getAttribute( attName, request );
        String attString ="";

    
              out.write("\r\n    <tr class=\"");
              out.print( FormattingHelper.getRowCss( debugStateAttributesRowCss++ ) );
              out.write("\">\r\n      <td align=\"top\">\r\n      ");
              out.print( attName );
              out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if (attVal == null)
        {
          out.println("null");
        }
        else if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
          attString = attVal.toString().replace('\n', ' ');
        
              out.write("\r\n          ");
              //  debug:displayXmlValueBean
              gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_1 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
              _jspx_th_debug_displayXmlValueBean_1.setPageContext(_jspx_page_context);
              _jspx_th_debug_displayXmlValueBean_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_debug_displayXmlValueBean_1.setXmlValueBean((XmlValueBean)attVal);
              int _jspx_eval_debug_displayXmlValueBean_1 = _jspx_th_debug_displayXmlValueBean_1.doStartTag();
              if (_jspx_th_debug_displayXmlValueBean_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
                case '\f':
                  sb.replace( i, i + 1, "&lt;br>" );
                  break;
                case '\r':
                  sb.replace( i, i + 1, "&lt;br>" );
                  break;
                case '\n':
                  sb.replace( i, i + 1, "&lt;br>" );
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
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/********* END: STATE ATTRIBUTES ***********/ 
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int debugSessionAttributesRowCss=0;

          out.write("\r\n\r\n");
/********* BEGIN: SESSION ATTRIBUTES ***********/ 
          out.write('\r');
          out.write('\n');

  debugSessionAttributesRowCss=0;

          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("Session Attributes");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Session Attributes");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex(-1);
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"760\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <th>Attribute Name</th>\r\n      <th>Attribute Value</th>\r\n    </tr>\r\n    ");

      Enumeration sessionAttributes = session.getAttributeNames();
      while ( sessionAttributes.hasMoreElements() )
      {
        String attName = (String) sessionAttributes.nextElement();
        Object attVal = session.getAttribute( attName );
        String attString ="";

    
              out.write("\r\n    <tr class=\"");
              out.print( FormattingHelper.getRowCss( debugSessionAttributesRowCss++ ) );
              out.write("\">\r\n      <td align=\"top\">\r\n      ");
              out.print( attName );
              out.write("\r\n      </td>\r\n      <td>\r\n      ");

        if (attVal == null)
        {
          out.println("null");
        }
        else if (attVal instanceof String )
        {
          out.println ( (String) attVal );
        }
        else if (attVal instanceof XmlValueBean )
        {
          attString = attVal.toString().replace('\n', ' ');
        
              out.write("\r\n          ");
              //  debug:displayXmlValueBean
              gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag _jspx_th_debug_displayXmlValueBean_2 = new gov.georgia.dhr.dfcs.sacwis.web.test.XmlValueBeanTag();
              _jspx_th_debug_displayXmlValueBean_2.setPageContext(_jspx_page_context);
              _jspx_th_debug_displayXmlValueBean_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_debug_displayXmlValueBean_2.setXmlValueBean((XmlValueBean)attVal);
              int _jspx_eval_debug_displayXmlValueBean_2 = _jspx_th_debug_displayXmlValueBean_2.doStartTag();
              if (_jspx_th_debug_displayXmlValueBean_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
/********* END: SESSION ATTRIBUTES ***********/ 
          out.write('\r');
          out.write('\n');
          out.write("\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  ");
          int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  }
  //Remove the exception b/c some exceptions cannot be encoded and it is not needed any longer.
  request.removeAttribute("exception.display");

      out.write("\r\n</body>\r\n</html>\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setName("txtProblemID");
    _jspx_th_impact_validateInput_0.setType("text");
    _jspx_th_impact_validateInput_0.setRequired("true");
    _jspx_th_impact_validateInput_0.setTabIndex(1);
    _jspx_th_impact_validateInput_0.setLabel("Ticket ID");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ButtonTag_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ButtonTag
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
    _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_ButtonTag_0.setName("btnSubmitFinal");
    _jspx_th_impact_ButtonTag_0.setImg("btnSubmit");
    _jspx_th_impact_ButtonTag_0.setTabIndex(2);
    _jspx_th_impact_ButtonTag_0.setForm("frmLogError");
    _jspx_th_impact_ButtonTag_0.setAction("/error/Error/logError");
    int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
    if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
