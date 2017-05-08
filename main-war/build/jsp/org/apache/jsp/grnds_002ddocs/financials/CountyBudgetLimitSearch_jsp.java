package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CountyBudgetLimitRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.financials.CountyBudgetLimitSearchConversation;

public final class CountyBudgetLimitSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\"  language=\"JavaScript1.2\">\r\n\r\n  //Forwards the user to the Contract Header page via the add push button or\r\n  // the hyperlink in the pagination section.\r\n  function submitCountyBudgetID( countyBudgetLimitID)\r\n  {\r\n          document.frmCountyBudgetLimitSearchResults.hdnCountyBudgetLimitID.value = countyBudgetLimitID;\r\n          submitValidateForm('frmCountyBudgetLimitSearchResults', '/financials/CountyBudgetLimit/forwardCountyBudgetLimitDetail');\r\n  }\r\n</script>\r\n\r\n");

    BaseSessionStateManager state = CountyBudgetLimitSearchConversation.getSessionStateManager(request);
    String disabledAddButton = "true";
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    if (userProfile.hasRight(UserProfile.SEC_MODIFY_COUNTY_BUDGET_LIMIT)){
      disabledAddButton = "false";
    }
    //Sets page mode to Edit
    String pageMode = PageModeConstants.EDIT;
    int tabIndex = 1;
    String county = ContextHelper.getStringSafe(request, "selCdCounty");
    String program = ContextHelper.getStringSafe(request, "selCdProgram");
    String fiscalYear = ContextHelper.getStringSafe(request, "txtFiscalYear");
    List<CountyBudgetLimitRetrieveSO> list1 = 
      (List<CountyBudgetLimitRetrieveSO>)state.getAttribute(CountyBudgetLimitSearchConversation.SEARCH_RESULTS, request);

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
      _jspx_th_impact_validateForm_0.setName("frmCountyBudgetLimitSearch");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setDefaultButton( String.valueOf(list1 == null) );
      _jspx_th_impact_validateForm_0.setAction("/financials/CountyBudgetLimit/displayCountyBudgetLimitSearch");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.CountyBudgetLimitSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\"/>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n  <tr>\r\n    <th colspan=\"4\">\r\n      County Budget Limit Search\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setName("selCdCounty");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_0.setValue( county );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setLabel("Fiscal Year");
          _jspx_th_impact_validateInput_0.setConstraint("Year");
          _jspx_th_impact_validateInput_0.setName("txtFiscalYear");
          _jspx_th_impact_validateInput_0.setValue( fiscalYear );
          _jspx_th_impact_validateInput_0.setSize("4");
          _jspx_th_impact_validateInput_0.setMaxLength("4");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("Program");
          _jspx_th_impact_validateSelect_1.setName("selCdProgram");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CPRGAREA );
          _jspx_th_impact_validateSelect_1.setColspan("3");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setValue( program );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmCountyBudgetLimitSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/financials/CountyBudgetLimit/searchCountyBudgetLimit");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  if(list1 != null) {

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmCountyBudgetLimitSearchResults");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/financials/CountyBudgetLimit/displayCountyBudgetLimitSearch");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          if (_jspx_meth_impact_validateErrors_1(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_1, _jspx_page_context))
            return;
          out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableborder\">\r\n      <tr>\r\n         <td class=\"tableBG\">\r\n           <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n           <tr>\r\n             <th class=\"thList\">Program</th>\r\n             <th class=\"thList\">County</th>\r\n             <th class=\"thList\">Budgeted Amount</th>\r\n             <th class=\"thList\">Amount Spent</th>\r\n             <th class=\"thList\">Amount Obligated</th>\r\n             <th class=\"thList\">Remaining Balance</th>\r\n           </tr>\r\n  ");

    int loopCount = 0;
    CountyBudgetLimitRetrieveSO countyBudgetSearchRow = null;
    Iterator<CountyBudgetLimitRetrieveSO> iterator = list1.iterator();

    if ( list1.size()==0)
{
  
          out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"6\">\r\n                ");
          out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
          out.write("\r\n              </td>\r\n            </tr>\r\n  ");

    }
    else
    {
      while( iterator.hasNext() )
      {
        countyBudgetSearchRow = (CountyBudgetLimitRetrieveSO) iterator.next();
  
          out.write("\r\n             <tr class=\"");
          out.print(FormattingHelper.getRowCss( loopCount + 1 ));
          out.write("\" valign=\"top\">\r\n               ");
 if ("false".equals(disabledAddButton)) { 
          out.write("\r\n               <td>\r\n                 <a href=\"javascript:submitCountyBudgetID('");
          out.print(countyBudgetSearchRow.getIdCountyBudgetLimit());
          out.write("');\">\r\n                   ");
          out.print( FormattingHelper.formatString(countyBudgetSearchRow.getProgram()) );
          out.write("</a>\r\n               </td>\r\n               ");
 } else { 
          out.write("\r\n               <td>\r\n                  ");
          out.print( FormattingHelper.formatString(countyBudgetSearchRow.getProgram()) );
          out.write("\r\n               </td>\r\n               ");
} 
          out.write("\r\n               <td>\r\n                 ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CCOUNT, countyBudgetSearchRow.getCounty()) );
          out.write("\r\n               </td>\r\n               <td>\r\n                 ");
          out.print( FormattingHelper.formatMoney(countyBudgetSearchRow.getBudgetedAmount()) );
          out.write("\r\n               </td>\r\n               <td>\r\n                 ");
          out.print( FormattingHelper.formatMoney(countyBudgetSearchRow.getAmountSpent()) );
          out.write("\r\n               </td>\r\n               <td>\r\n                 ");
          out.print( FormattingHelper.formatMoney(countyBudgetSearchRow.getAmountObligated()) );
          out.write("\r\n               </td>\r\n               <td>\r\n                 ");
          out.print( FormattingHelper.formatMoney(countyBudgetSearchRow.getRemainingBalance()) );
          out.write("\r\n               </td>\r\n             </tr>\r\n               ");

                 loopCount++;
               } // end while
              }
               
          out.write("\r\n             </table>\r\n  </td>\r\n</tr>\r\n</table>    \r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnAdd");
          _jspx_th_impact_ButtonTag_1.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmCountyBudgetLimitSearchResults");
          _jspx_th_impact_ButtonTag_1.setAction("/financials/CountyBudgetLimit/forwardCountyBudgetLimitDetail");
          _jspx_th_impact_ButtonTag_1.setFunction("document.frmCountyBudgetLimitSearchResults.hdnCountyBudgetLimitID.value = '0'");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setDisabled( disabledAddButton );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>       \r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
 } 
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
    _jspx_th_impact_validateErrors_0.setFormName("frmCountyBudgetLimitSearch");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateErrors_1.setFormName("frmCountyBudgetLimitSearchResults");
    int _jspx_eval_impact_validateErrors_1 = _jspx_th_impact_validateErrors_1.doStartTag();
    if (_jspx_th_impact_validateErrors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnCountyBudgetLimitID");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
