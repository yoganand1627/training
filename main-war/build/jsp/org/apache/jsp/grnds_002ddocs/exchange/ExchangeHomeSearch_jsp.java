package org.apache.jsp.grnds_002ddocs.exchange;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeHomeSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeHomeSearchDao;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public final class ExchangeHomeSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n");

  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );  
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  Object results = null;
  
  String formName = "frmExchangeHomeSearch";
  
  SortedMap years = new TreeMap();
  if (state.getAttribute("yearsrange", request) != null) {
  	years = (SortedMap) state.getAttribute("yearsrange", request);
  }
  SortedMap months = new TreeMap();
  if (state.getAttribute("monthsrange", request) != null) {
   months = (SortedMap) state.getAttribute("monthsrange", request);
  }
 
  Collection yearOptions = years.values();
  Collection monthOptions = months.values();
  
  ExchangeHomeValueBean homeSearchValueBean = (ExchangeHomeValueBean)request.getAttribute(ExchangeHomeSearchConversation.EXCHANGE_HOME_SEARCH_BEAN);
  
  int numberOfResources = 0;
  List<ExchangeHomeValueBean> exchangeHomeList = null;
  
  if (request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME) != null) {
  	results = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
  }
  
  if (request.getAttribute(ExchangeHomeSearchConversation.EXCHANGE_HOME_LIST) != null) {
    exchangeHomeList = ((PaginationResultBean) results).getResults();
  }
  
  boolean pullBackMode = false;
  String sPullBackMode = (String) state.getAttribute("pullBackMode", request);
  if (ArchitectureConstants.TRUE.equals(sPullBackMode)) {
    pullBackMode = true;
  }  
  
  String resultsPerPageName = DatabaseResultDetails.RESULTS_PER_PAGE_NAME;
  String resultsPerPage = new Integer(ExchangeHomeSearchConversation.SEARCH_RESULTS_PER_PAGE).toString();
  // STGAP00012764: Exclude these two types of statuses when performing a search
  List excludeStatus = new ArrayList();
  excludeStatus.add(CodesTables.CFAHMSTA_PTA); // Hide Pending Temporary Approval
  excludeStatus.add(CodesTables.CFAHMSTA_ATA); // Hide Approved (Temp) - Active

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction() {\r\n  if (document.getElementById(\"exchangeHomSearchResults\")) {\r\n  \tdocument.getElementById(\"exchangeHomSearchResults\").focus();\r\n  }\r\n}\r\n\r\n\r\nfunction navigateToExchangeHomeDetail( indexNum ) {\r\n  ");
      out.print( formName );
      out.write(".indexNum.value = indexNum;\r\n  submitValidateForm( \"");
      out.print( formName );
      out.write("\", \"/exchange/ExchangeHomeSearch/displayExchangeHomeDetail\" );\r\n}\r\n\r\nfunction navigateToHomeInformation( indexNum ) {\r\n  ");
      out.print( formName );
      out.write(".indexNum.value = indexNum;\r\n  submitValidateForm( \"");
      out.print( formName );
      out.write("\", \"/exchange/ExchangeHomeSearch/displayHomeInformationDetail\" );\r\n}\r\n\r\nfunction checkIfSelected(numberOfRows) {\r\n  var bCB= false;\r\n  for ( i = 0; i < numberOfRows ; i++ ) {\r\n  \tvar listCb = document.getElementById(\"cbContinue_\" + i);\r\n    bCB = listCb.checked;\r\n    if ( bCB ) {\r\n     break;\r\n    }\r\n  }\r\n  if ( !bCB )  {\r\n    alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n  }\r\n  return bCB\r\n}\r\n\r\n  //STGAP00018067 - Removed references to regions 16 and 17\r\n  //Get county code/decode array with all data\r\n  ");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 01\r\n  ");
      if (_jspx_meth_impact_codeArray_1(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 02\r\n  ");
      if (_jspx_meth_impact_codeArray_2(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 03\r\n  ");
      if (_jspx_meth_impact_codeArray_3(_jspx_page_context))
        return;
      out.write("  \r\n  //Get county code/decode array filtered for region 04\r\n  ");
      if (_jspx_meth_impact_codeArray_4(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 05\r\n  ");
      if (_jspx_meth_impact_codeArray_5(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 06\r\n  ");
      if (_jspx_meth_impact_codeArray_6(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 07\r\n  ");
      if (_jspx_meth_impact_codeArray_7(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 08\r\n  ");
      if (_jspx_meth_impact_codeArray_8(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 09\r\n  ");
      if (_jspx_meth_impact_codeArray_9(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 10\r\n  ");
      if (_jspx_meth_impact_codeArray_10(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 11\r\n  ");
      if (_jspx_meth_impact_codeArray_11(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 12\r\n  ");
      if (_jspx_meth_impact_codeArray_12(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 13\r\n  ");
      if (_jspx_meth_impact_codeArray_13(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 14\r\n  ");
      if (_jspx_meth_impact_codeArray_14(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 15\r\n  ");
      if (_jspx_meth_impact_codeArray_15(_jspx_page_context))
        return;
      out.write("\r\n  //Get county code/decode array filtered for region 98\r\n  ");
      if (_jspx_meth_impact_codeArray_16(_jspx_page_context))
        return;
      out.write("\r\n\r\nfunction populateCounty(onPageLoad) {\r\n  if ( ");
      out.print(formName);
      out.write(".selSzCdRsrcRegion.value == ");
      out.print( CodesTables.CCOUNT_099 );
      out.write(" ||\r\n       ");
      out.print(formName);
      out.write(".selSzCdRsrcRegion.value == \"\") {\r\n    clearDropdown ( ");
      out.print(formName);
      out.write(".selSzCdRsrcCnty );\r\n  } else {\r\n    var dropdownValue = \"\";\r\n    populateDropdown(");
      out.print(formName);
      out.write(".selSzCdRsrcCnty, dropdownValue, eval(\"CCOUNT\"+");
      out.print(formName);
      out.write(".selSzCdRsrcRegion.value) );\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExchangeHomeSearch");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/exchange/ExchangeHomeSearch/searchExchangeHome");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeHomeSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("indexNum");
          _jspx_th_impact_validateInput_0.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\r\n\t");
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\t  <tr>\r\n\t        <th colspan=\"4\">Home Locate</th>\r\n\t  </tr>\r\n\t  <tr>\r\n\t  \t<td class=\"formInstruct\" colspan=\"4\">\r\n\t  \t\tEnter Search Criteria to find an Exchange Home if a Resource ID is entered the search will use only the identification number to find a match\r\n\t  \t</td>\r\n\t  </tr>\r\n\t  <tr>\r\n      \t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setDisabled("false");
          _jspx_th_impact_validateInput_1.setName("txtHomeName");
          _jspx_th_impact_validateInput_1.setLabel("Home Name");
          _jspx_th_impact_validateInput_1.setValue(FormattingHelper.formatString(homeSearchValueBean.getHomeName()));
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setMaxLength("30");
          _jspx_th_impact_validateInput_1.setSize("20");
          _jspx_th_impact_validateInput_1.setConditionallyRequired("true");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      \t<td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setDisabled("false");
          _jspx_th_impact_validateInput_2.setName("txtResourceId");
          _jspx_th_impact_validateInput_2.setLabel("Resource Id");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatInt((homeSearchValueBean.getIdResource() != null) ? homeSearchValueBean.getIdResource() : 0));
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setMaxLength("16");
          _jspx_th_impact_validateInput_2.setSize("16");
          _jspx_th_impact_validateInput_2.setConstraint("Digit16Less");
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>\r\n        \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdRsrcFaHomeStatus");
          _jspx_th_impact_validateSelect_0.setLabel("Status");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeStatus);
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CFAHMSTA);
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(homeSearchValueBean.getCdStatus()));
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setDisabled("false");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      \t<td>\r\n        \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selSzCdRsrcCategory");
          _jspx_th_impact_validateSelect_1.setLabel("Category");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable(CodesTables.CFACATEG);
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(homeSearchValueBean.getCdCategory()));
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setDisabled("false");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>\r\n        \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selSzCdRsrcRegion");
          _jspx_th_impact_validateSelect_2.setLabel("Region");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setCodesTable(CodesTables.CREGIONS);
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(homeSearchValueBean.getCdRegion()));
          _jspx_th_impact_validateSelect_2.setOnChange("populateCounty(false)");
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      \t<td>\r\n        \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("selSzCdRsrcCnty");
          _jspx_th_impact_validateSelect_3.setLabel("County");
          _jspx_th_impact_validateSelect_3.setRequired("false");
          _jspx_th_impact_validateSelect_3.setCodesTable(CodesTables.CCOUNT);
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(homeSearchValueBean.getCdCounty()));
          _jspx_th_impact_validateSelect_3.setStyle("width: 150px");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>\r\n        \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setValue(homeSearchValueBean.getAgencyCode());
          _jspx_th_impact_validateInput_3.setDisabled("false");
          _jspx_th_impact_validateInput_3.setName("txtAgencyCode");
          _jspx_th_impact_validateInput_3.setLabel("Agency Code");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setMaxLength("30");
          _jspx_th_impact_validateInput_3.setSize("20");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      \t<td>\r\n        \t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("selSzAgecy");
          _jspx_th_impact_validateSelect_4.setLabel("Agency");
          _jspx_th_impact_validateSelect_4.setCodesTable("");
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(homeSearchValueBean.getAgency()));
          _jspx_th_impact_validateSelect_4.setCodesTable(CodesTables.CADOAGEN);
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_4.setDisabled("false");
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      </tr>\r\n      <tr>\r\n      \t<td>\r\n      \t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Inquiry Date");
          _jspx_th_impact_validateDate_0.setName("dtInquiry");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(homeSearchValueBean.getDtInquired()));
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConditionallyRequired("false");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      \t</td>\r\n      \t<td>\r\n      \t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Number of Children Approved For");
          _jspx_th_impact_validateInput_4.setName("txtNbrOfChldrn");
          _jspx_th_impact_validateInput_4.setDisabled("false");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatInt((homeSearchValueBean.getNumOfChildren() != null) ? homeSearchValueBean.getNumOfChildren() : 0));
          _jspx_th_impact_validateInput_4.setConstraint("Numeric");
          _jspx_th_impact_validateInput_4.setSize("3");
          _jspx_th_impact_validateInput_4.setMaxLength("3");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n      </tr>\r\n   \t</table>\r\n");
          out.write("\r\n\t<br>\r\n");
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE2\">\r\n\t  <tr>\r\n\t        <th colspan=\"4\">Non-Avail Codes</th>\r\n\t  </tr>\r\n\t  <tr class=\"subDetail\">\r\n\t\t  \t\t <td>\r\n\t\t\t      ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbNonAvailCodes");
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(homeSearchValueBean.getLstCdNonAvaCodes());
          _jspx_th_impact_codesCheckbox_0.setCodesTableName(CodesTables.CANONAV);
          _jspx_th_impact_codesCheckbox_0.setColumns(4);
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_0.setDisabled("flase");
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t   \t</td>\r\n\t  \t</tr>\r\n\t</table>\r\n");
          out.write("\r\n\t<br>\r\n");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("searchChildNeeds");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Search Child Needs");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE4\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Special Needs Characteristics </th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("checkbox");
              _jspx_th_impact_validateInput_5.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01));
              _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_5.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndMentalRetardation())) ? "true" : "false" );
              _jspx_th_impact_validateInput_5.setValue("Y");
              _jspx_th_impact_validateInput_5.setName("cbxMentalRetardation");
              _jspx_th_impact_validateInput_5.setDisabled("false");
              _jspx_th_impact_validateInput_5.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setName("selSzCdMentalRetardation");
              _jspx_th_impact_validateSelect_5.setColspan("1");
              _jspx_th_impact_validateSelect_5.setValue( FormattingHelper.formatString(homeSearchValueBean.getCdLevelMentalRetardation()) );
              _jspx_th_impact_validateSelect_5.setRequired("false");
              _jspx_th_impact_validateSelect_5.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_5.setDisabled("false");
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<b> Background Factors</b>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setType("checkbox");
              _jspx_th_impact_validateInput_6.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02));
              _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_6.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndVisualHearingImpairments())) ? "true" : "false" );
              _jspx_th_impact_validateInput_6.setValue("Y");
              _jspx_th_impact_validateInput_6.setName("cbxVisualHearingImpairments");
              _jspx_th_impact_validateInput_6.setDisabled("false");
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setName("selSzCdVisualHearingImpairments");
              _jspx_th_impact_validateSelect_6.setColspan("1");
              _jspx_th_impact_validateSelect_6.setValue( FormattingHelper.formatString(homeSearchValueBean.getCdLevelVisualHearingImpairments()) );
              _jspx_th_impact_validateSelect_6.setRequired("false");
              _jspx_th_impact_validateSelect_6.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_6.setDisabled("false");
              _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("checkbox");
              _jspx_th_impact_validateInput_7.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06));
              _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_7.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndFamilyHxofDrugsAlcohol())) ? "true" : "false" );
              _jspx_th_impact_validateInput_7.setValue("Y");
              _jspx_th_impact_validateInput_7.setName("cbxFamilyHxofDrugsAlcohol");
              _jspx_th_impact_validateInput_7.setDisabled("false");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_8.setType("checkbox");
              _jspx_th_impact_validateInput_8.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03));
              _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_8.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndPhysicallyDisabled())) ? "true" : "false" );
              _jspx_th_impact_validateInput_8.setValue("Y");
              _jspx_th_impact_validateInput_8.setName("cbxPhysicallyDisabled");
              _jspx_th_impact_validateInput_8.setDisabled("false");
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setName("selSzCdPhysicallyDisabled");
              _jspx_th_impact_validateSelect_7.setColspan("1");
              _jspx_th_impact_validateSelect_7.setValue( FormattingHelper.formatString(homeSearchValueBean.getCdLevelPhysicallyDisabled()) );
              _jspx_th_impact_validateSelect_7.setRequired("false");
              _jspx_th_impact_validateSelect_7.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_7.setDisabled("false");
              _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setType("checkbox");
              _jspx_th_impact_validateInput_9.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07));
              _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_9.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndFamilyHxofMentalIllness())) ? "true" : "false" );
              _jspx_th_impact_validateInput_9.setValue("Y");
              _jspx_th_impact_validateInput_9.setName("cbxFamilyHxofMentalIllness");
              _jspx_th_impact_validateInput_9.setDisabled("false");
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setType("checkbox");
              _jspx_th_impact_validateInput_10.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04));
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndEmotionallyDisturbed())) ? "true" : "false" );
              _jspx_th_impact_validateInput_10.setValue("Y");
              _jspx_th_impact_validateInput_10.setName("cbxEmotionallyDisturbed");
              _jspx_th_impact_validateInput_10.setDisabled("false");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setName("selSzCdEmotionallyDisturbed");
              _jspx_th_impact_validateSelect_8.setColspan("1");
              _jspx_th_impact_validateSelect_8.setValue( FormattingHelper.formatString(homeSearchValueBean.getCdLevelEmotionallyDisturbed()) );
              _jspx_th_impact_validateSelect_8.setRequired("false");
              _jspx_th_impact_validateSelect_8.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_8.setDisabled("false");
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setType("checkbox");
              _jspx_th_impact_validateInput_11.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08));
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_11.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndFamilyHxofMR())) ? "true" : "false" );
              _jspx_th_impact_validateInput_11.setValue("Y");
              _jspx_th_impact_validateInput_11.setName("cbxFamilyHxofMR");
              _jspx_th_impact_validateInput_11.setDisabled("false");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t  \t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setType("checkbox");
              _jspx_th_impact_validateInput_12.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05));
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_12.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndOtherMedicalDiagnoses())) ? "true" : "false" );
              _jspx_th_impact_validateInput_12.setValue("Y");
              _jspx_th_impact_validateInput_12.setName("cbxOtherMedicalDiagnoses");
              _jspx_th_impact_validateInput_12.setDisabled("false");
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_9.setName("selSzCdOtherMedicalDiagnoses");
              _jspx_th_impact_validateSelect_9.setColspan("1");
              _jspx_th_impact_validateSelect_9.setValue( FormattingHelper.formatString(homeSearchValueBean.getCdlevelOtherMedicalDiagnoses()) );
              _jspx_th_impact_validateSelect_9.setRequired("false");
              _jspx_th_impact_validateSelect_9.setCodesTable(CodesTables.CADSEVER);
              _jspx_th_impact_validateSelect_9.setDisabled("false");
              _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setType("checkbox");
              _jspx_th_impact_validateInput_13.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09));
              _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_13.setChecked( (ArchitectureConstants.Y.equals(homeSearchValueBean.getIndChilsHxofSexualAbuse())) ? "true" : "false" );
              _jspx_th_impact_validateInput_13.setValue("Y");
              _jspx_th_impact_validateInput_13.setName("cbxChilsHxofSexualAbuse");
              _jspx_th_impact_validateInput_13.setDisabled("false");
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE5\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Child Race</th>\r\n\t  \t\t</tr>\r\n\t\t  \t<tr class=\"subDetail\">\r\n\t\t  \t\t <td>\r\n\t\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_1.setName("cbxRace");
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes(homeSearchValueBean.getChildRacePref());
              _jspx_th_impact_codesCheckbox_1.setCodesTableName(CodesTables.CADRACE);
              _jspx_th_impact_codesCheckbox_1.setColumns(2);
              _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_1.setDisabled("false");
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t   \t</td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE6\">\r\n\t  \t\t<tr>\r\n\t        \t<th colspan=\"4\">Child Ethnicity</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t  \t\t <td>\r\n\t\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_2.setName("cbxEth");
              _jspx_th_impact_codesCheckbox_2.setDefaultCodes(homeSearchValueBean.getChildEthnicityPerf());
              _jspx_th_impact_codesCheckbox_2.setCodesTableName(CodesTables.CINDETHN);
              _jspx_th_impact_codesCheckbox_2.setColumns(3);
              _jspx_th_impact_codesCheckbox_2.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_2.setDisabled("false");
              int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
              if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t   \t</td>\r\n\t  \t\t</tr>\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  \t\t\t<tr>\r\n    \t\t\t<th colspan=\"8\">Child Demographics</th>\r\n  \t\t\t</tr>\r\n  \t\t\t<tr class=\"subDetail\">\r\n  \t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_10.setName("selSzCdGender");
              _jspx_th_impact_validateSelect_10.setLabel("Gender");
              _jspx_th_impact_validateSelect_10.setColspan("1");
              _jspx_th_impact_validateSelect_10.setValue( FormattingHelper.formatString(homeSearchValueBean.getCdGender()) );
              _jspx_th_impact_validateSelect_10.setRequired("false");
              _jspx_th_impact_validateSelect_10.setCodesTable(CodesTables.CRSRCSEX);
              _jspx_th_impact_validateSelect_10.setDisabled("false");
              _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"6\"/>\r\n  \t\t\t</tr>\r\n  \t\t\t<tr class=\"subDetail\">\r\n\t            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setValue("");
              _jspx_th_impact_validateSelect_11.setName("selMinYear");
              _jspx_th_impact_validateSelect_11.setLabel("Min Year");
              _jspx_th_impact_validateSelect_11.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_11.setDisabled("false");
              _jspx_th_impact_validateSelect_11.setValue(FormattingHelper.formatString((homeSearchValueBean.getMinRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMinRangeInMonths()/12) : null));
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            </td>\r\n\t            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setValue("");
              _jspx_th_impact_validateSelect_12.setName("selMinMonth");
              _jspx_th_impact_validateSelect_12.setLabel("Min Month");
              _jspx_th_impact_validateSelect_12.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_12.setDisabled("false");
              _jspx_th_impact_validateSelect_12.setValue(FormattingHelper.formatString((homeSearchValueBean.getMinRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMinRangeInMonths()%12) : null));
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            </td>\r\n\t            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_13.setValue("");
              _jspx_th_impact_validateSelect_13.setName("selMaxYear");
              _jspx_th_impact_validateSelect_13.setLabel("Max Year");
              _jspx_th_impact_validateSelect_13.setOptions( yearOptions );
              _jspx_th_impact_validateSelect_13.setDisabled("false");
              _jspx_th_impact_validateSelect_13.setValue(FormattingHelper.formatString((homeSearchValueBean.getMaxRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMaxRangeInMonths()/12) : null));
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            </td>\r\n\t            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_14.setValue("");
              _jspx_th_impact_validateSelect_14.setName("selMaxMonth");
              _jspx_th_impact_validateSelect_14.setLabel("Max Month");
              _jspx_th_impact_validateSelect_14.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_14.setDisabled("false");
              _jspx_th_impact_validateSelect_14.setValue(FormattingHelper.formatString((homeSearchValueBean.getMaxRangeInMonths() != null) ? String.valueOf(homeSearchValueBean.getMaxRangeInMonths()%12) : null));
              int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
              if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t            </td>\r\n          \t</tr>\r\n  \t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td colspan=\"4\">\r\n        <br>\r\n        <hr>\r\n      </td>\r\n    </tr>\r\n\t\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmExchangeHomeSearch");
          _jspx_th_impact_ButtonTag_0.setAction("/exchange/ExchangeHomeSearch/searchExchangeHome");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n   </table>\r\n  <br>\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />  \r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmExchangeHomeResult");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/exchange/ExchangeHomeSearch/searchExchangeHome");
      _jspx_th_impact_validateForm_1.setPageMode( pageMode );
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("indexNum");
          _jspx_th_impact_validateInput_14.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          out.write("\r\n  ");
PaginationResultBean pPaginationResultBean = (PaginationResultBean) request
                                                                                 .getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
      if (pPaginationResultBean != null) {
        DatabaseResultDetails db = pPaginationResultBean.getResultDetails();
      }
      if (!FormValidation.pageHasErrorMessages(request)
          && !FormValidation.pageHasValidationMessages("frmExchangeHomeResult", request)) {
        if (ExchangeHomeSearchConversation.SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request))
            || ExchangeHomeSearchConversation.DISPLAY_SEARCH_PAGE.equals(ContextHelper.getPreviousUrl(request))
            || pullBackMode == true) {
            
          
          out.write("\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl(ExchangeHomeSearchConversation.SEARCH_PAGE);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t<input type=\"hidden\"  name=\"requestFromListPage\" value=\"ExchangeHomeSearch\"/>\r\n    <table width=\"100%\" cellpading=\"0\" cellspacing=\"0\" border=\"0\">\r\n \t\t<tr>\r\n \t\t <td class=\"alignRight\"><div class=\"formInstruct\">Scroll for more information  --></div></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t  <div id=\"exchangeHomSearchResults\" style=\"height:200px; width:765px; overflow:auto\" class=\"tableborderList\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" id=\"TABLEEXHR\">\r\n        ");

           ExchangeHomeValueBean homeRow = null;
           int iLoopCounter = 0;
           if (exchangeHomeList == null || exchangeHomeList.isEmpty()) {
        
              out.write("\r\n        <tr class=\"thList\">\r\n          <th class=\"thList\">&nbsp;</th>\r\n          <th class=\"thList\">Resource Name</th>\r\n          <th class=\"thList\">Category</th>\r\n          <th class=\"thList\">Availability Code</th>\r\n          <th class=\"thList\">County</th>\r\n          <th class=\"thList\">Agency</th>\r\n          <th class=\"thList\">FA Home Status</th>\r\n          <th class=\"thList\">Date Out</th>\r\n        </tr>\r\n        <tr class=\"tableBG\">\r\n          <td colspan=\"9\" class=\"subDetail\">\r\n            ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");
} else {
        
              out.write("\r\n        <tr class=\"thList\">\r\n          <th class=\"thList\">&nbsp;</th>\r\n          <th class=\"thList\">Resource Name");
              if (_jspx_meth_impact_sortableColumnHeader_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n          <th class=\"thList\">Category");
              if (_jspx_meth_impact_sortableColumnHeader_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n          <th class=\"thList\">Availability Code");
              if (_jspx_meth_impact_sortableColumnHeader_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n          <th class=\"thList\">County");
              if (_jspx_meth_impact_sortableColumnHeader_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n          <th class=\"thList\">Agency");
              if (_jspx_meth_impact_sortableColumnHeader_4(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n          <th class=\"thList\">FA Home Status");
              if (_jspx_meth_impact_sortableColumnHeader_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n          <th class=\"thList\">Date Out");
              if (_jspx_meth_impact_sortableColumnHeader_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n        </tr>\r\n        ");

        		numberOfResources = exchangeHomeList.size();
        		int rowCount = 0;
        		for (rowCount = 0; rowCount < numberOfResources; rowCount++) {
            		ExchangeHomeValueBean exchangeHome = exchangeHomeList.get(rowCount);
            		String cbName = "cbContinue_" + rowCount;
         
              out.write("\r\n        \t<tr class=\"");
              out.print( FormattingHelper.getRowCss(rowCount + 1));
              out.write("\">\r\n         ");

         			if(pullBackMode) { 
         			
              out.write("\r\n         \t\t\t<td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_15.setType("checkbox");
              _jspx_th_impact_validateInput_15.setId("homeCheckBox");
              _jspx_th_impact_validateInput_15.setName(cbName);
              _jspx_th_impact_validateInput_15.setValue( "" + rowCount);
              _jspx_th_impact_validateInput_15.setCssClass("rowCount");
              _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         \t\t\t</td>\r\n         \t\t\t");

         			} else {
         			
              out.write("\r\n         \t\t\t\t<td><nobr></nobr></td>\r\n         \t\t\t");

         			}
         
              out.write("\r\n         \r\n\t          <td>\r\n\t          \t");
 if(pullBackMode) { 
              out.write("\r\n\t          \t  ");
              out.print(FormattingHelper.formatString(exchangeHome.getHomeName()));
              out.write("\r\n\t          \t");
 }else { 
              out.write("\r\n\t\t        <a href=\"javascript:navigateToExchangeHomeDetail('");
              out.print(rowCount);
              out.write("')\" tabIndex=\"");
              out.print(tabIndex++ );
              out.write("\">\r\n\t\t          ");
              out.print(FormattingHelper.formatString(exchangeHome.getHomeName()));
              out.write("\r\n\t\t        </a>\r\n\t\t        ");
 } 
              out.write("\r\n\t\t      </td>\r\n\t\t\t\t\t\t\t\t     \r\n\t          <td>\r\n\t            ");
              out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CFACATEG, exchangeHome.getCdCategory())));
              out.write("\r\n\t          </td>\r\n\t          <td>\r\n\t            ");
              out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CANONAV, exchangeHome.getCdNonAvaCode())));
              out.write("\r\n\t          </td>\r\n\t          <td>\r\n\t            ");
              out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeHome.getCdCounty())));
              out.write("\r\n\t          </td>\r\n\t          <td>\r\n\t            ");
              out.print(FormattingHelper.formatString(exchangeHome.getAgency()));
              out.write("\r\n\t          </td>\r\n\t          <td>\r\n\t            ");
 if(pullBackMode) { 
              out.write("\r\n\t            \t");
              out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, exchangeHome.getCdFAHomeStatus())));
              out.write("\r\n\t            ");
 }else { 
              out.write("\r\n\t\t\t        <a href=\"javascript:navigateToHomeInformation('");
              out.print(rowCount);
              out.write("')\" tabIndex=\"");
              out.print(tabIndex++ );
              out.write("\">\r\n\t\t\t          ");
              out.print(FormattingHelper.formatString(Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, exchangeHome.getCdFAHomeStatus())));
              out.write("\r\n\t\t\t        </a>\r\n\t\t       ");
 } 
              out.write("\r\n\t\t      </td>\r\n\t\t      <td>\r\n\t            ");
              out.print(FormattingHelper.formatDate(exchangeHome.getDateOut()));
              out.write("\r\n\t          </td>\r\n\t        </tr>\r\n\t        ");
}
          }

          
              out.write("\r\n          \r\n      </table>\r\n    </div>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
 String functionContinue = "disableValidation('frmExchangeHomeResult'); return checkIfSelected( "
	                                      + numberOfResources + ");"; 
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n  <input type=\"hidden\" name=\"");
          out.print(resultsPerPageName);
          out.write("\" value=\"");
          out.print(resultsPerPage);
          out.write("\"/>\r\n\r\n  ");
  if( pullBackMode && numberOfResources != 0  ){
          out.write(" \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnContinue");
          _jspx_th_impact_ButtonTag_1.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_1.setFunction(functionContinue);
          _jspx_th_impact_ButtonTag_1.setForm("frmExchangeHomeResult");
          _jspx_th_impact_ButtonTag_1.setAction("/exchange/ExchangeHomeSearch/pullBackExchangeHomeDetail");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
  }
    }
   }
  
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  populateCounty(true);\r\n</script>");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_0.setArrayName("CCOUNT");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_1.setParent(null);
    _jspx_th_impact_codeArray_1.setCodeName("CCOUNT01");
    _jspx_th_impact_codeArray_1.setArrayName("CCOUNT01");
    _jspx_th_impact_codeArray_1.setBlankValue("true");
    int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
    if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_2.setParent(null);
    _jspx_th_impact_codeArray_2.setCodeName("CCOUNT02");
    _jspx_th_impact_codeArray_2.setArrayName("CCOUNT02");
    _jspx_th_impact_codeArray_2.setBlankValue("true");
    int _jspx_eval_impact_codeArray_2 = _jspx_th_impact_codeArray_2.doStartTag();
    if (_jspx_th_impact_codeArray_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_3.setParent(null);
    _jspx_th_impact_codeArray_3.setCodeName("CCOUNT03");
    _jspx_th_impact_codeArray_3.setArrayName("CCOUNT03");
    _jspx_th_impact_codeArray_3.setBlankValue("true");
    int _jspx_eval_impact_codeArray_3 = _jspx_th_impact_codeArray_3.doStartTag();
    if (_jspx_th_impact_codeArray_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_4.setParent(null);
    _jspx_th_impact_codeArray_4.setCodeName("CCOUNT04");
    _jspx_th_impact_codeArray_4.setArrayName("CCOUNT04");
    _jspx_th_impact_codeArray_4.setBlankValue("true");
    int _jspx_eval_impact_codeArray_4 = _jspx_th_impact_codeArray_4.doStartTag();
    if (_jspx_th_impact_codeArray_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_5.setParent(null);
    _jspx_th_impact_codeArray_5.setCodeName("CCOUNT05");
    _jspx_th_impact_codeArray_5.setArrayName("CCOUNT05");
    _jspx_th_impact_codeArray_5.setBlankValue("true");
    int _jspx_eval_impact_codeArray_5 = _jspx_th_impact_codeArray_5.doStartTag();
    if (_jspx_th_impact_codeArray_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_6.setParent(null);
    _jspx_th_impact_codeArray_6.setCodeName("CCOUNT06");
    _jspx_th_impact_codeArray_6.setArrayName("CCOUNT06");
    _jspx_th_impact_codeArray_6.setBlankValue("true");
    int _jspx_eval_impact_codeArray_6 = _jspx_th_impact_codeArray_6.doStartTag();
    if (_jspx_th_impact_codeArray_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_7.setParent(null);
    _jspx_th_impact_codeArray_7.setCodeName("CCOUNT07");
    _jspx_th_impact_codeArray_7.setArrayName("CCOUNT07");
    _jspx_th_impact_codeArray_7.setBlankValue("true");
    int _jspx_eval_impact_codeArray_7 = _jspx_th_impact_codeArray_7.doStartTag();
    if (_jspx_th_impact_codeArray_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_8.setParent(null);
    _jspx_th_impact_codeArray_8.setCodeName("CCOUNT08");
    _jspx_th_impact_codeArray_8.setArrayName("CCOUNT08");
    _jspx_th_impact_codeArray_8.setBlankValue("true");
    int _jspx_eval_impact_codeArray_8 = _jspx_th_impact_codeArray_8.doStartTag();
    if (_jspx_th_impact_codeArray_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_9.setParent(null);
    _jspx_th_impact_codeArray_9.setCodeName("CCOUNT09");
    _jspx_th_impact_codeArray_9.setArrayName("CCOUNT09");
    _jspx_th_impact_codeArray_9.setBlankValue("true");
    int _jspx_eval_impact_codeArray_9 = _jspx_th_impact_codeArray_9.doStartTag();
    if (_jspx_th_impact_codeArray_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_10.setParent(null);
    _jspx_th_impact_codeArray_10.setCodeName("CCOUNT10");
    _jspx_th_impact_codeArray_10.setArrayName("CCOUNT10");
    _jspx_th_impact_codeArray_10.setBlankValue("true");
    int _jspx_eval_impact_codeArray_10 = _jspx_th_impact_codeArray_10.doStartTag();
    if (_jspx_th_impact_codeArray_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_11.setParent(null);
    _jspx_th_impact_codeArray_11.setCodeName("CCOUNT11");
    _jspx_th_impact_codeArray_11.setArrayName("CCOUNT11");
    _jspx_th_impact_codeArray_11.setBlankValue("true");
    int _jspx_eval_impact_codeArray_11 = _jspx_th_impact_codeArray_11.doStartTag();
    if (_jspx_th_impact_codeArray_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_12.setParent(null);
    _jspx_th_impact_codeArray_12.setCodeName("CCOUNT12");
    _jspx_th_impact_codeArray_12.setArrayName("CCOUNT12");
    _jspx_th_impact_codeArray_12.setBlankValue("true");
    int _jspx_eval_impact_codeArray_12 = _jspx_th_impact_codeArray_12.doStartTag();
    if (_jspx_th_impact_codeArray_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_13.setParent(null);
    _jspx_th_impact_codeArray_13.setCodeName("CCOUNT13");
    _jspx_th_impact_codeArray_13.setArrayName("CCOUNT13");
    _jspx_th_impact_codeArray_13.setBlankValue("true");
    int _jspx_eval_impact_codeArray_13 = _jspx_th_impact_codeArray_13.doStartTag();
    if (_jspx_th_impact_codeArray_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_14.setParent(null);
    _jspx_th_impact_codeArray_14.setCodeName("CCOUNT14");
    _jspx_th_impact_codeArray_14.setArrayName("CCOUNT14");
    _jspx_th_impact_codeArray_14.setBlankValue("true");
    int _jspx_eval_impact_codeArray_14 = _jspx_th_impact_codeArray_14.doStartTag();
    if (_jspx_th_impact_codeArray_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_15.setParent(null);
    _jspx_th_impact_codeArray_15.setCodeName("CCOUNT15");
    _jspx_th_impact_codeArray_15.setArrayName("CCOUNT15");
    _jspx_th_impact_codeArray_15.setBlankValue("true");
    int _jspx_eval_impact_codeArray_15 = _jspx_th_impact_codeArray_15.doStartTag();
    if (_jspx_th_impact_codeArray_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_codeArray_16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_16.setParent(null);
    _jspx_th_impact_codeArray_16.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_16.setArrayName("CCOUNT98");
    _jspx_th_impact_codeArray_16.setBlankValue("true");
    int _jspx_eval_impact_codeArray_16 = _jspx_th_impact_codeArray_16.doStartTag();
    if (_jspx_th_impact_codeArray_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    _jspx_th_impact_validateErrors_0.setFormName("frmExchangeHomeSearch");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_0.setOrderBy("cr.NM_RESOURCE");
    int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_1.setOrderBy("cr.CD_RSRC_CATEGORY");
    int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_2.setOrderBy("exh.CD_NON_AVAIL_STATUS");
    int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_3.setOrderBy("cr.CD_RSRC_CNTY");
    int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_4.setOrderBy("cr.NDFCS_CERT_ENTITY");
    int _jspx_eval_impact_sortableColumnHeader_4 = _jspx_th_impact_sortableColumnHeader_4.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_5.setOrderBy("cr.CD_RSRC_FA_HOME_STATUS");
    int _jspx_eval_impact_sortableColumnHeader_5 = _jspx_th_impact_sortableColumnHeader_5.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_sortableColumnHeader_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:sortableColumnHeader
    gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
    _jspx_th_impact_sortableColumnHeader_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_sortableColumnHeader_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_sortableColumnHeader_6.setOrderBy("exh.DT_OUT");
    int _jspx_eval_impact_sortableColumnHeader_6 = _jspx_th_impact_sortableColumnHeader_6.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
