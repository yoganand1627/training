package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO;

public final class CaretakerDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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


  /**
   * JSP Name:     CaretakerDetail.jsp
   * Created by:   lingamnr
   * Date Created: 08/15/02
   *
   * Description:
   * This page is accessed from the CaretakerInformation Page.  It allows users to
   * users to view, delete or modify Caretaker Information.
   **/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/11/03  Todd Reser        Added flowerbox, description and Change log.
  10/28/03  CORLEYAN        SIR 19857 validation for this conversation is no
                              longer needed since the date constraint is available.
  02/18/04  Linda Reed        SIR 22625- added txtChildResourceId so Home ResourceId
                              passed on to following pages.
  08/31/05  Linda Reed        SIR 23777 - splitting out Race from Ethnicity for
                              AFGARS and CLASS Agency Home web page.
  04/05/07  Lata Lokhande     Added End Date field, removed Race field. Changed code 
  							  for Ethnicity to CETHNIC. 
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  
  String pageMode = PageMode.getPageMode(request);

  //Initialize the display variables for the page
  String cReqFuncCd = "";
  String cdHomeMaritalStatus = "";
  String szNmCaretkrFname = "";
  String szNmCaretkrMname = "";
  String szNmCaretkrLname = "";
  String cdCaretkrEthnic = "";
  String cdCaretkrSex = "";
  String dateOfBirth = "";
  String idCaretaker = "";
  String originalMaritalStatus = "";
  String endDate = "";
  String caretakerCount = request.getParameter("caretakerCount");
  String caretakerIndex = request.getParameter("caretakerIndex");
  String txtChildResourceId = request.getParameter("txtChildResourceId");
  if (request.getParameter("cReqFuncCd") != null) {
    cReqFuncCd = request.getParameter("cReqFuncCd");
  }
  //Initialize the variables for the page if its in modify mode(a caretaker has
  //  been set on the request as an attribute)
  ROWCRES55DO caretakerDetail = (ROWCRES55DO) request.getAttribute("ROWCRES55DO");
  if (caretakerDetail != null) {
    cdHomeMaritalStatus = caretakerDetail.getCd_Home_Marital_Status();
    originalMaritalStatus = cdHomeMaritalStatus;
    szNmCaretkrFname = caretakerDetail.getSzNmCaretkrFname();
    szNmCaretkrMname = caretakerDetail.getSzNmCaretkrMname();
    szNmCaretkrLname = caretakerDetail.getSzNmCaretkrLname();
    cdCaretkrEthnic = caretakerDetail.getCdCaretkrEthnic();
    cdCaretkrSex = caretakerDetail.getCdCaretkrSex();
    dateOfBirth = FormattingHelper.formatDate(caretakerDetail.getDtCaretkrBirth());
    idCaretaker = Integer.toString(caretakerDetail.getIdCaretaker());
    endDate = FormattingHelper.formatDate(caretakerDetail.getDtEnd());
    
  } else {
    originalMaritalStatus = request.getParameter("originalMaritalStatus");
  }

  int tabIndex = 1;

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n  function saveCaretaker()\r\n  {\r\n    if ( document.frmCaretakerDetail.selHomeMarital.value != ");
      out.print(originalMaritalStatus);
      out.write(" &&\r\n            frmCaretakerDetail.caretakerCount.value > 1 &&\r\n            (frmCaretakerDetail.cReqFuncCd.value != 'A' ||\r\n            frmCaretakerDetail.cReqFuncCd.value != 'a') ) {\r\n            \r\n       \r\n        if (confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_RSRC_UPD_HOME_MARITAL") );
      out.write("')) {\r\n        \twindow.onbeforeunload = null;\r\n            return true;\r\n        } else {\r\n        \treturn false;\r\n        }\r\n    } else {\r\n    \twindow.onbeforeunload = null;\r\n        return true;\r\n     }\r\n  }\r\n\r\n  function deleteCaretakerDetail()\r\n  {\r\n    if (confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") );
      out.write("'))\r\n    {\r\n      window.onbeforeunload = null;\r\n      document.frmCaretakerDetail.cReqFuncCd.value = 'D'\r\n      return true;\r\n    }\r\n    else\r\n    {\r\n      return false;\r\n    }\r\n  }\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaretakerDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/Caretaker/saveCaretakerDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.resource.CaretakerValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n  <input type=\"hidden\" name=\"cReqFuncCd\" value=\"");
          out.print(cReqFuncCd);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"txtChildResourceId\" value=\"");
          out.print(txtChildResourceId);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"caretakerCount\" value=\"");
          out.print(caretakerCount);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"caretakerIndex\" value=\"");
          out.print(caretakerIndex);
          out.write("\"/>\r\n  <input type=\"hidden\" name=\"originalMaritalStatus\" value=\"");
          out.print(originalMaritalStatus);
          out.write("\"/>\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("idCaretaker");
          _jspx_th_impact_validateInput_0.setValue(idCaretaker);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" style=\"WIDTH: 760px; HEIGHT: 50px\">\r\n    <tr>\r\n      <th class=\"formLabel\" colspan=\"4\">Home Family Structure</th>\r\n    </tr>\r\n    <tr>\r\n      <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selHomeMarital");
          _jspx_th_impact_validateSelect_0.setLabel("Home Marital Status");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CFAMSTRC");
          _jspx_th_impact_validateSelect_0.setValue(cdHomeMaritalStatus);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" style=\"WIDTH: 760px; HEIGHT: 50px\">\r\n    <tr>\r\n      <th class=\"formLabel\" colspan=\"10\">Caretaker Information</th>\r\n    </tr>\r\n    <!-- Added new field in R2 Release -->\r\n    <tr>\r\n    \t<td colspan=\"2\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("txtDateEnd");
          _jspx_th_impact_validateDate_0.setLabel("End Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setRequired("false");
          _jspx_th_impact_validateDate_0.setValue(endDate);
          _jspx_th_impact_validateDate_0.setSize("8");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    \t</td>\r\n      \r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setName("txtFirstName");
          _jspx_th_impact_validateInput_1.setLabel("First");
          _jspx_th_impact_validateInput_1.setRequired("true");
          _jspx_th_impact_validateInput_1.setConstraint("Name12");
          _jspx_th_impact_validateInput_1.setValue(szNmCaretkrFname);
          _jspx_th_impact_validateInput_1.setSize("12");
          _jspx_th_impact_validateInput_1.setMaxLength("12");
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("txtMiddleName");
          _jspx_th_impact_validateInput_2.setLabel("Middle");
          _jspx_th_impact_validateInput_2.setConstraint("Name12");
          _jspx_th_impact_validateInput_2.setValue(szNmCaretkrMname);
          _jspx_th_impact_validateInput_2.setSize("12");
          _jspx_th_impact_validateInput_2.setMaxLength("12");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td colspan=\"2\">");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("txtLastName");
          _jspx_th_impact_validateInput_3.setLabel("Last");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setConstraint("Name22");
          _jspx_th_impact_validateInput_3.setValue(szNmCaretkrLname);
          _jspx_th_impact_validateInput_3.setSize("22");
          _jspx_th_impact_validateInput_3.setMaxLength("22");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("txtDateBirth");
          _jspx_th_impact_validateDate_1.setLabel("Date of Birth");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setValue(dateOfBirth);
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      <td colspan=\"2\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selEthnicity");
          _jspx_th_impact_validateSelect_1.setLabel("Ethnicity");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CETHNIC");
          _jspx_th_impact_validateSelect_1.setValue(cdCaretkrEthnic);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 160px");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n       <td colspan=\"2\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selGender");
          _jspx_th_impact_validateSelect_2.setLabel("Gender");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setCodesTable("CSEX");
          _jspx_th_impact_validateSelect_2.setValue(cdCaretkrSex);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    </tr>\r\n  </table>\r\n  \r\n   <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>      \r\n      <td align=\"right\" colspan=\"5\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSaveCaretaker");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setForm("frmCaretakerDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("return saveCaretaker();");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/Caretaker/saveCaretakerDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td> \r\n    </tr> \r\n  </table> \r\n\r\n  <input type=\"hidden\" name=\"");
          out.print(PageMode.PAGE_MODE_ATTRIBUTE_NAME);
          out.write("\" value=\"");
          out.print(pageMode);
          out.write("\">\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
