package org.apache.jsp.grnds_002ddocs.document.cfp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.util.Set;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;
import gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation;

public final class cfp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/document/cfp/OpenQueueStatus.jsp");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

try
{
  int tabIndex = 1;
  String formName = "cfp";
  StageDB stageDB = (StageDB) request.getAttribute(CfpConversation.CFP_STAGE);

  DocumentTypeDB[] documentTypes = (DocumentTypeDB[])
    request.getAttribute(CfpConversation.CFP_DOCUMENT_TYPES);

      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n");

//Matthew McClain 5/2/2003
//I could have made this a .js, but I didn't want to mess with the problem
//of the .js not loading before the button was clicked or the method was called.

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n<!--\r\nfunction openQueueStatus()\r\n{\r\n  //http://www.devguru.com/technologies/ecmascript/quickref/win_open.html\r\n  var width = 760;\r\n  var height = 350;\r\n  var left = screen.availWidth - width - 10;\r\n  var top = 0;\r\n  var queueStatus = window.open(\"");
      out.print( CfpConversation.QUEUE_STATUS );
      out.write("\",\r\n                                \"queueStatus\",\r\n                                \"menubar=no,\" +\r\n                                \"location=no,\" +\r\n                                \"resizable=yes,\" +\r\n                                \"scrollbars=yes,\" +\r\n                                \"width=\" + width + \",\" +\r\n                                \"height=\" + height + \",\" +\r\n                                \"left=\" + left + \",\" +\r\n                                \"top=\" + top);\r\n  queueStatus.focus();\r\n  return false;\r\n}\r\n//-->\r\n</script>\r\n");
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n<!--Insert Java Script here\r\nfunction selectAll()\r\n{\r\n  var cfpForm = document.all['");
      out.print( formName );
      out.write("'];\r\n  for (var i = 0; i < cfpForm.outputCode.length; i++)\r\n  {\r\n    cfpForm.outputCode[i].checked = true;\r\n  }\r\n  return false;\r\n}\r\n\r\n\r\nfunction deselectAll()\r\n{\r\n  var cfpForm = document.all['");
      out.print( formName );
      out.write("'];\r\n  for (var i = 0; i < cfpForm.outputCode.length; i++)\r\n  {\r\n    cfpForm.outputCode[i].checked = false;\r\n  }\r\n  return false;\r\n}\r\n//End Java Script-->\r\n</script>\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( formName );
      _jspx_th_impact_validateForm_0.setAction( CfpConversation.SUBMIT_CFP );
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName( ServerSideValidationUtility.FORM_VALIDATION_PREV_URL );
          _jspx_th_impact_validateInput_0.setValue( ContextHelper.getStringSafe(request, ServerSideValidationUtility.FORM_VALIDATION_PREV_URL) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">Type</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n       <tr>\r\n         <td class=\"formLabel\" width=\"70\">Program:</td>\r\n         <td>");
          out.print( stageDB.getProgramName() );
          out.write("</td>\r\n\r\n");
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest( stageDB.getStageCode() != null );
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n         <td class=\"formLabel\" width=\"60\">Stage:</td>\r\n         <td>");
              out.print( Lookup.simpleDecodeSafe("CSTAGES", stageDB.getStageCode()) );
              out.write("</td>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n        <tr>\r\n          <th class=\"thList\" colspan=\"2\">Outputs</th>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td>\r\n            <div id=\"reports\" style=\"height:155; width:100%; overflow:auto\" class=\"tableborderList\">\r\n              <table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n");

  String[] outputCodes = (String[])
  request.getAttribute(CfpConversation.CFP_OUTPUT_CODES);

  Set outputCodesSet = CfpConversation.arrayToSet(outputCodes);

  for (int i = 0; i < documentTypes.length; i++)
  {
    String outputCode = documentTypes[i].getOutputCode();
    String checked = "";
    if (outputCodesSet.contains(outputCode))
    {
      checked = "checked";
    }
    String trClass = "odd";
    if (i % 2 == 1)
    {
      trClass = "even";
    }

          out.write("\r\n    <tr class=\"");
          out.print( trClass );
          out.write("\"><!-- used regular checkboxes here so I can get array of selected -->\r\n      <td><input tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\"\r\n                 type=\"checkbox\"\r\n                 ");
          out.print( checked );
          out.write("\r\n                 name=\"outputCode\"\r\n                 value=\"");
          out.print( outputCode );
          out.write("\"/></td>\r\n      <td colspan=\"2\">");
          out.print( documentTypes[i].getOutputName() );
          out.write("</td>\r\n    </tr>\r\n");

  }

          out.write("\r\n              </table>\r\n            </div>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("QueueStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setFunction("return openQueueStatus();");
          _jspx_th_impact_ButtonTag_0.setAction("/not/a/real/path");
          _jspx_th_impact_ButtonTag_0.setForm( formName );
          _jspx_th_impact_ButtonTag_0.setImg("btnQueueViewer");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("SelectAll");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setFunction("return selectAll();");
          _jspx_th_impact_ButtonTag_1.setAction("/not/a/real/path");
          _jspx_th_impact_ButtonTag_1.setForm( formName );
          _jspx_th_impact_ButtonTag_1.setImg("btnSelectAll");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("DeselectAll");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setFunction("return deselectAll();");
          _jspx_th_impact_ButtonTag_2.setAction("/not/a/real/path");
          _jspx_th_impact_ButtonTag_2.setForm( formName );
          _jspx_th_impact_ButtonTag_2.setImg("btnDeselectAll");
          _jspx_th_impact_ButtonTag_2.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("Launch");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_3.setAction( CfpConversation.SUBMIT_CFP );
          _jspx_th_impact_ButtonTag_3.setForm( formName );
          _jspx_th_impact_ButtonTag_3.setImg("btnLaunch");
          _jspx_th_impact_ButtonTag_3.setEditableMode( EditableMode.EDIT );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

}
catch(Throwable e)
{
  out.println("<pre>");
  e.printStackTrace(new PrintWriter(out));
  out.println("</pre>");
}

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

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
