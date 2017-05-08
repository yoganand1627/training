package org.apache.jsp.grnds_002ddocs.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import java.net.URL;
import org.grnds.facility.config.GrndsConfiguration;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  private static final boolean LOGON_AS_OTHER_USER =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser"));

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Initialize tabIndex
  int tabIndex = 1;
  URL url = new URL( request.getRequestURL().toString() );
  String baseURL = url.getPort() >= 0 ?
                   url.getProtocol() + "://" + url.getHost() + ":" + url.getPort() :
                   url.getProtocol() + "://" + url.getHost();
  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n  function warnSecurityPrivacyPolicy()\r\n  {\r\n    var returnVal = true;\r\n    returnVal = confirm( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_LOGIN_CONFIRM ));
      out.write("' );\r\n    return returnVal;\r\n  }\r\n  function warnRegisterNewUser()\r\n  {\r\n    var returnVal = true;\r\n    returnVal = confirm( '");
      out.print(MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_REG_APRV_PROV_CONFIRM ));
      out.write("' );\r\n    return returnVal;\r\n  }\r\n  function displayVendorStaffDetail()\r\n  {\r\n  \tif (warnRegisterNewUser()){\r\n\t\tdisableValidation('frmLogin');\r\n\t\tsubmitValidateForm( 'frmLogin', '/login/Login/displayVendorStaffDetail' );\r\n\t}\r\n  }\r\n  function displayResetPassword()\r\n  {\r\n\t\tdocument.frmLogin.hdnResetPasswordSelected.value = 'Y';\r\n\t\tdisableValidation('frmLogin');\r\n\t\tsubmitValidateForm( 'frmLogin', '/login/Login/displayResetPassword' );\r\n\r\n  }   \r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmLogin");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/login/Login/test");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.common.LoginCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.CREATE );
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" align=\"center\">\r\n    <tr>\r\n      \r\n      <td align=\"center\">\r\n        <table>\r\n          <tr>\r\n            <td width=\"200\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setConstraint("Email");
          _jspx_th_impact_validateInput_0.setColspan("2");
          _jspx_th_impact_validateInput_0.setName(UserProfileHelper.LOGIN_NAME_KEY);
          _jspx_th_impact_validateInput_0.setLabel("E-mail Address");
          _jspx_th_impact_validateInput_0.setRequired("true");
          _jspx_th_impact_validateInput_0.setSize("50");
          _jspx_th_impact_validateInput_0.setMaxLength("320");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"200\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("password");
          _jspx_th_impact_validateInput_1.setConstraint("Password");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setColspan("2");
          _jspx_th_impact_validateInput_1.setName(UserProfileHelper.PASSWORD_KEY);
          _jspx_th_impact_validateInput_1.setLabel("Password");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setSize("30");
          _jspx_th_impact_validateInput_1.setMaxLength("20");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            ");

              if (LOGON_AS_OTHER_USER) {
            
          out.write("\r\n            <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName(UserProfileHelper.CLAIM_USER_ID_KEY );
          _jspx_th_impact_validateInput_2.setLabel("Logon As ( UserID )");
          _jspx_th_impact_validateInput_2.setSize("15");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_2.setRequired("false");
          _jspx_th_impact_validateInput_2.setValue("");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n            ");

            } else {
              // Hidden field needed for fixed users if we have no displayed field.
            
          out.write("\r\n            <td colspan=\"2\">&nbsp;<input type=\"hidden\" name=\"");
          out.print( UserProfileHelper.CLAIM_USER_ID_KEY );
          out.write("\"\r\n                                         value=\"\"/></td>\r\n            ");

              }
            
          out.write("\r\n            <td>");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Logon");
          _jspx_th_impact_ButtonTag_0.setImg("btnLogon");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmLogin");
          _jspx_th_impact_ButtonTag_0.setAction("/login/Login/test");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setFunction("return warnSecurityPrivacyPolicy()");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr><td>&nbsp;</td>\r\n          </tr> \r\n          <tr>\r\n          \t<td colspan=2><a href=\"javascript:displayVendorStaffDetail();\">Click here to register as a new user. This does not apply to NYTD youth user.</a>\r\n          \t</td>\r\n          \t<td></td>\r\n          \t<td><a href=\"javascript:displayResetPassword();\">Click here to reset your password</a>\r\n          \t</td>\r\n          </tr>\t\r\n          \t\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <!-- </tr>\r\n  </table> -->\r\n  <input type=\"hidden\" name=\"hdnResetPasswordSelected\" value=\"\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"hdnFormInformation\" value=\"");
          out.print( request.getParameter( "hdnFormInformation" ) );
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"");
          out.print( AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY );
          out.write("\"\r\n         value=\"");
          out.print( FormattingHelper.formatString( serializedRequestString ));
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  document.frmLogin.");
      out.print( UserProfileHelper.LOGIN_NAME_KEY );
      out.write(".focus();\r\n</script>\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("login");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
