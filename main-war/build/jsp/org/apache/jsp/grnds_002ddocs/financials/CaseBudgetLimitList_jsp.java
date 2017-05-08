package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CaseBudgetLimitRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CaseBudgetLimitBean;
import java.util.List;
import java.util.Iterator;

public final class CaseBudgetLimitList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*  JSP Name:     Case Budget Limit List JSP
      //*  Created by:   Vishala Devarakonda
      //*  Date Created: 04/06/07
      //*
      //*  Description:
      //* The Case Budget Limit List page contains display only information regarding current Case Budget Limits.  
      //* The information contained in the list is populated by several different pieces of financial processing
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      /*  GET OBJECTS FROM REQUEST */
      CaseBudgetLimitRetrieveSO caseBudgetLimitRetrieveSO = (CaseBudgetLimitRetrieveSO) state.getAttribute("caseBudgetLimitRetrieveSO", request);
      List<CaseBudgetLimitBean> caseBudgetLimitBeanList = caseBudgetLimitRetrieveSO.getCaseBudgetLimitList();

      
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseBdgtList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/CaseBudgetLimitList/displayCaseBudgetLimit");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
/* Changed to 100% width for SIR 23639 */

      
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/financials/CaseBudgetLimitList/displayCaseBudgetLimit");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<div id=\"scrollBar2\" style=\"height:210px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t<tr>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tUAS Code\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tEntitlement/Service Code\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tBudgeted Amount\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tAmount Spent\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tRemaining Amount Authorized\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tWaiver Amount\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tAmount Pending Authorization\r\n\t\t\t\t\t</th>\r\n\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\tRemaining Balance\r\n\t\t\t\t\t</th>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");
if (caseBudgetLimitBeanList == null || caseBudgetLimitBeanList.isEmpty()) {

              out.write("\r\n\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t<td colspan=\"14\">\r\n\t\t\t\t\t\t");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");
} else {
        for (Iterator it = caseBudgetLimitBeanList.iterator(); it.hasNext();) {
          CaseBudgetLimitBean caseBudgetLimitBean = (CaseBudgetLimitBean) it.next();
          String svcCode = FormattingHelper.formatString(caseBudgetLimitBean.getCdSvcCode());
          String uasCode = svcCode.substring(0, 3);
          String uasDecode = Lookup.simpleDecodeSafe("CPRGCODE", uasCode);
          String entCode = svcCode.substring(3);
          String entDecode = "";
          // STGAP00010529  UAS code should show even if its a line number 
          if (svcCode.length() == 6) {
            entDecode = Lookup.simpleDecodeSafe("CSVCCODE", svcCode).substring(3);
          } else {
            entDecode = Lookup.simpleDecodeSafe("CENTCODE", entCode);
          }

              out.write("\r\n\t\t\t\t<tr valign=\"top\">\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(uasDecode));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatString(entDecode));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtBudgt()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtSpent()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtRemain()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtWaiver()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtPendAuth()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t\t<td>\r\n\t\t\t\t\t\t");
              out.print(FormattingHelper.formatDouble(caseBudgetLimitBean.getAmtBalance()));
              out.write("\r\n\t\t\t\t\t</td>\r\n\t\t\t\t</tr>\r\n\t\t\t\t");
}

      }
              out.write("\r\n\t\t\t</table>\r\n\t\t</div>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
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
    _jspx_th_impact_validateInput_0.setName("hdnPersonLoopCount");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
