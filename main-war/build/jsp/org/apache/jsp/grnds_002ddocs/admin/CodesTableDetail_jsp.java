package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTableDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CodesTablesStruct;
import gov.georgia.dhr.dfcs.sacwis.web.admin.CodesTablesMntConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import java.util.Iterator;
import java.util.List;

public final class CodesTableDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  int tabIndex = 1;
  String pageMode = PageModeConstants.EDIT;
  CodesTableDetailRetrieveSO codesTableDtl = (CodesTableDetailRetrieveSO) state.getAttribute("codesTableDtl",
                                                                                             request);
  List<CodesTablesStruct> codesTblStructList = null;
  String codeType = "";
  String transType = "";
  String description = "";
  String disabled = "false";
  if (codesTableDtl != null) {
    codesTblStructList = codesTableDtl.getCodesTablesStructList();
    codeType = FormattingHelper.formatString(codesTableDtl.getCodeType());
    transType = FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCTUPDT,
                                                                      codesTableDtl.getTransType()));
    description = FormattingHelper.formatString(codesTableDtl.getDesc());
    if (CodesTables.CCTUPDT_L.equals(codesTableDtl.getTransType())) {
      disabled = "true";
    }
  }
  Iterator codeTblIterator = codesTblStructList != null ? codesTblStructList.iterator() : null;

      out.write("\r\n<script type=\"text/javascript\" language=\"javascript\">\r\nfunction setArrayIndex(code)\r\n  {\r\n    frmCodesTableDetail.hdnCode.value = code;\r\n  }\r\nfunction edit()\r\n{\r\n    var bChecked = false;\r\n    var rs = ");
      out.print(codesTblStructList.size());
      out.write(";\r\n      if ( rs <= 1 )\r\n      {\r\n        if ( frmCodesTableDetail.rbCodesTableDetail.checked == false )\r\n        {\r\n          alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n        }\r\n        else\r\n        {\r\n          bChecked = true;\r\n        }\r\n\r\n      } else {\r\n\r\n        for ( var i = 0; i < rs; i++ )\r\n        {\r\n          if (frmCodesTableDetail.rbCodesTableDetail[i].checked)\r\n          {\r\n             bChecked = true;\r\n          }\r\n        }\r\n\r\n        if ( bChecked == false )\r\n        {\r\n          alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n        }\r\n      }\r\n      return bChecked;\r\n  }\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCodesTableDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setAction("/admin/CodesTablesMnt/displayCodesTableDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    \r\n\t");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n             <th class=\"thList\">&nbsp;</th>   \r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\"></th>\r\n             <th class=\"thList\"></th> \r\n        </tr>             \r\n        <tr>                    \r\n            <td>\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspCodesTableName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Codes Table Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(codeType);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td>\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspTransType");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Transaction Type");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(transType);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n        <tr>\r\n            <td>\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspDescription");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Description");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(description);
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n    </table>\r\n    ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/admin/CodesTablesMnt/displayCodesTableDetail");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    <div id=\"scrollBar2\" style=\"height:210px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\t\r\n        <tr>\r\n             <th class=\"thList\" style=\"white-space: nowrap;\">&nbsp;</th>\r\n             <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Code\r\n       ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(CodesTablesMntConversation.SORT_BY_CODE);
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\" style=\"white-space: nowrap;\">\r\n            Decode\r\n       ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(CodesTablesMntConversation.SORT_BY_DECODE);
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n             <th class=\"thList\" style=\"white-space: nowrap;\">\r\n          End Date\r\n       ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(CodesTablesMntConversation.SORT_BY_END_DATE);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n             </th>\r\n        </tr>\r\n");

  int counter = 0;
      if (codeTblIterator != null && codeTblIterator.hasNext()) {
        while (codeTblIterator.hasNext()) {
          CodesTablesStruct codesTablesStruct = (CodesTablesStruct) codeTblIterator.next();
          String radioId = "rbCodesTableDetail_" + counter;
          String onClick = "setArrayIndex( '" + codesTablesStruct.getCode() + "')";

              out.write("\r\n        <tr class=\"");
              out.print(FormattingHelper.getRowCss(counter + 1));
              out.write("\" valign=\"top\">\r\n            <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_1.setType("radio");
              _jspx_th_impact_validateInput_1.setId(radioId);
              _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_1.setOnClick(onClick);
              _jspx_th_impact_validateInput_1.setName("rbCodesTableDetail");
              _jspx_th_impact_validateInput_1.setValue(String.valueOf(counter));
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              out.print(FormattingHelper.formatString(codesTablesStruct.getCode()));
              out.write("</td>\r\n            <td>");
              out.print(FormattingHelper.formatString(codesTablesStruct.getDecode()));
              out.write("</td>                          \r\n            <td>");
              out.print(FormattingHelper.formatDate(codesTablesStruct.getEndDate()));
              out.write("</td>\r\n        </tr>\r\n\r\n ");

   }
       }
 
              out.write("\r\n    </table>\r\n    </div>");
 /* this is where the "scrollBar" div tag ends */ 
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <table border=\"0\" cellpadding=\"3\" class=\"tableNoBorder\" width=\"100%\" >\r\n        <tr>\r\n            <td class=\"alignRight\">\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnUpdateCancel");
          _jspx_th_impact_ButtonTag_0.setImg("btnCancel");
          _jspx_th_impact_ButtonTag_0.setForm("frmCodesTableDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/CodesTablesMnt/cancel");
          _jspx_th_impact_ButtonTag_0.setDisabled("false");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnCodeEdit");
          _jspx_th_impact_ButtonTag_1.setImg("btnEdit");
          _jspx_th_impact_ButtonTag_1.setForm("frmCodesTableDetail");
          _jspx_th_impact_ButtonTag_1.setFunction("return edit();");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/CodesTablesMnt/displayCodeDetail");
          _jspx_th_impact_ButtonTag_1.setDisabled("false");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnAdd");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setForm("frmCodesTableDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/admin/CodesTablesMnt/displayCodeDetail");
          _jspx_th_impact_ButtonTag_2.setDisabled(disabled);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n        </tr>\r\n    </table>\r\n    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnCode");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
