package org.apache.jsp.grnds_002ddocs.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.AuthenticatedPrsHttpServlet;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ValidateLoginSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import org.grnds.facility.config.GrndsConfiguration;

public final class ChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final GrndsConfiguration GRNDS_CONFIGURATION = GrndsConfiguration.getInstance();
  private static final boolean LOGON_AS_OTHER_USER =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsOtherUser"));
  private static final boolean LOGON_AS_FIXED_USERS =
          "true".equals(GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "logonAsFixedUsers"));
  // Parse out the fixed users
  private static final Map<Integer, String> FIXED_USERS;

  static {
    if (LOGON_AS_FIXED_USERS) {
      Map<Integer, String> tempMap = new LinkedHashMap<Integer, String>();
      int i = 1;
      String val;
      while (null !=
             (val = GRNDS_CONFIGURATION.getProperty(ArchitectureConstants.GRNDS_DOMAIN, "loginAsFixedUser" + (i++)))) {
        String[] vals = val.split(",");
        tempMap.put(Integer.parseInt(vals[0]), vals[1]);
      }
      FIXED_USERS = tempMap;
    } else {
      //noinspection AssignmentToNull
      FIXED_USERS = null;
    }
  }

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  // Initialize tabIndex
  int tabIndex = 1;

  // Get the serialized request
  String serializedRequestString = (String) request.getAttribute(AuthenticatedPrsHttpServlet.SERIALIZED_REQUEST_KEY);
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  ValidateLoginSO validateLoginSO = (ValidateLoginSO)state.getAttribute("validateLoginSO",request);
  //Randomly choose a question
  Random generator = new Random();
  int randomQuesNum = generator.nextInt(3);
  List<String> questionsList = new ArrayList<String>();
  String currentQuestionDisplayed = "";
  String userName = "";
  String password = "";
  if(validateLoginSO != null){
	  questionsList = validateLoginSO.getCdQuestion();
	  currentQuestionDisplayed = Lookup.simpleDecodeSafe("CSECQUES", questionsList.get(randomQuesNum).trim());
	  userName = validateLoginSO.getUserName();
	  password = "TempPass";
	  validateLoginSO.setRandomQuestionNum(randomQuesNum);
	  //Set validateLoginSO to the state so that the random question number can be validated with the answer
      state.setAttribute("validateLoginSO", validateLoginSO, request);
  }

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmChngPasswd");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/login/Login/displayChangePassword");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.common.ChangePasswordCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.CREATE );
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\"  align=\"center\">\r\n    <tr>\r\n      <td align=\"center\">\r\n        <table>\r\n          <tr>\r\n            <td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setConstraint("Email");
          _jspx_th_impact_validateInput_0.setColspan("2");
          _jspx_th_impact_validateInput_0.setName(UserProfileHelper.LOGIN_NAME_KEY);
          _jspx_th_impact_validateInput_0.setLabel("Email Address");
          _jspx_th_impact_validateInput_0.setMaxLength("320");
          _jspx_th_impact_validateInput_0.setValue(userName );
          _jspx_th_impact_validateInput_0.setEditableMode(EditableMode.VIEW );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            <td>Security Question:</td><td>");
          out.print(currentQuestionDisplayed );
          out.write("</td>\r\n          </tr>          \r\n          <tr>\r\n            <td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setConstraint("Name25");
          _jspx_th_impact_validateInput_1.setColspan("2");
          _jspx_th_impact_validateInput_1.setName(UserProfileHelper.SECURITY_ANSWER_KEY);
          _jspx_th_impact_validateInput_1.setLabel("Answer");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setMaxLength("30");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("password");
          _jspx_th_impact_validateInput_2.setConstraint("Password");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setColspan("2");
          _jspx_th_impact_validateInput_2.setName(UserProfileHelper.NEW_PASSWORD_KEY);
          _jspx_th_impact_validateInput_2.setLabel("New Password");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setMaxLength("20");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n            <td width=\"120\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("password");
          _jspx_th_impact_validateInput_3.setConstraint("Password");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setColspan("2");
          _jspx_th_impact_validateInput_3.setName(UserProfileHelper.NEW_PASSWORD_CONFIRM_KEY);
          _jspx_th_impact_validateInput_3.setLabel("Re-enter New Password");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setMaxLength("20");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n          </tr>\r\n          <tr>\r\n          \t<td></td>\r\n            <td>\r\n\t\t\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("Logon");
          _jspx_th_impact_ButtonTag_0.setImg("btnLogon");
          _jspx_th_impact_ButtonTag_0.setAlign("left");
          _jspx_th_impact_ButtonTag_0.setForm("frmChngPasswd");
          _jspx_th_impact_ButtonTag_0.setAction("/login/Login/changePassword");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <!-- </tr>\r\n  </table> -->\r\n  <input type=\"hidden\" name=\"");
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
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  document.frmChngPasswd.");
      out.print( UserProfileHelper.SECURITY_ANSWER_KEY );
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
    _jspx_th_impact_validateErrors_0.setFormName("chngPasswd");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
