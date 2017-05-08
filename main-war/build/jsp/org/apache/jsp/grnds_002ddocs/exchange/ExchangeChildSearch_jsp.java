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
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;
import gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicityHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchCustomValidation;
import gov.georgia.dhr.dfcs.sacwis.dao.exchange.ExchangeChildValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import java.util.ArrayList;

public final class ExchangeChildSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  Object results = null;

  String formName = "frmExchangeChildSerach";

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

  ExchangeChildValueBean childSearchValueBean = (ExchangeChildValueBean) request
                                                                                .getAttribute(ExchangeChildSearchConversation.EXCHANGE_CHILD_SEARCH_BEAN);
  int nbrResults = 0;
  boolean indPullBackMode = false;
  String pullBackMode = (String) state.getAttribute("pullBackMode", request);
  if (pullBackMode != null && ArchitectureConstants.TRUE.equals(pullBackMode)) {
    indPullBackMode = true;
  }
  int maleMaxMonths = childSearchValueBean.getMaleMaxRangeInMonths();
  int maleMinMonths = childSearchValueBean.getMaleMinRangeInMonths();
  int femaleMaxMonths = childSearchValueBean.getFemaleMaxRangeInMonths();
  int femaleMinMonths = childSearchValueBean.getFemaleMinRangeInMonths();

  List<ExchangeChildValueBean> excChildList = null;

  if (request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME) != null) {
    results = request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);
  }

  if (request.getAttribute(ExchangeChildSearchConversation.EXCHANGE_CHILD_LIST) != null) {
    excChildList = ((PaginationResultBean) results).getResults();
  }
  if (ArchitectureConstants.Y.equals(state.getAttribute("indReturnError", request))) {
    excChildList = new ArrayList<ExchangeChildValueBean>();
    state.removeAttribute("indReturnError", request);
  }

  String resultsPerPageName = DatabaseResultDetails.RESULTS_PER_PAGE_NAME;
  String resultsPerPage = "25";

      out.write("\r\n\r\n<script language=\"JavaScript\">\r\n\r\nwindow.attachEvent('onload', myOnLoadFunction );\r\n\r\nfunction myOnLoadFunction() {\r\n  if (document.getElementById(\"exchangeChildSearchResults\")) {\r\n  \tdocument.getElementById(\"exchangeChildSearchResults\").focus();\r\n  }\r\n}\r\n\r\nfunction checkRowSelected(numberOfRows) {\r\n  var rbSelected = false;\r\n  for ( i = 0; i < numberOfRows ; i++ ) {\r\n  \tvar cbx = document.getElementById(\"ckName_Link\" + i);\r\n    rbSelected = cbx.checked;\r\n    if ( rbSelected ) {\r\n     break;\r\n    }\r\n  }\r\n  if ( !rbSelected )  {\r\n    alert('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION));
      out.write("');\r\n  }\r\n  return rbSelected\r\n}\r\nfunction getExchangeChildDetail(recordIndex, idStage)\r\n{\r\n   ");
      out.print(formName);
      out.write(".hdnRowIndex.value = recordIndex;\r\n   ");
      out.print(formName);
      out.write(".hdnIdStage.value = idStage;\r\n  submitValidateForm( \"");
      out.print(formName);
      out.write("\", \"/exchange/ExchangeChildSearch/displayExchangeChildDetail\" );\r\n}\r\n\r\nfunction getPersonDetail(recordIndex, idStage) {\r\n   ");
      out.print(formName);
      out.write(".hdnRowIndex.value = recordIndex;\r\n   ");
      out.print(formName);
      out.write(".hdnIdStage.value = idStage;\r\n  submitValidateForm(  \"");
      out.print(formName);
      out.write("\", \"/exchange/ExchangeChildSearch/displayPersonDetail\" );\r\n}\r\n\r\nfunction getAdoptionInfo(recordIndex, idStage) {\r\n   ");
      out.print(formName);
      out.write(".hdnRowIndex.value = recordIndex;\r\n   ");
      out.print(formName);
      out.write(".hdnIdStage.value = idStage;\r\n  submitValidateForm(  \"");
      out.print(formName);
      out.write("\", \"/exchange/ExchangeChildSearch/displayAdoInfo\" );\r\n}\r\n\r\n  //STGAP00018067 - Removed references to regions 16 and 17\r\n  //Get county code/decode array with all data\r\n  ");
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
      out.write("\r\n\r\nfunction populateCounty(onPageLoad) {\r\n if ( ");
      out.print(formName);
      out.write(".szCdRegion.value == ");
      out.print(CodesTables.CCOUNT_099);
      out.write(" ||\r\n       ");
      out.print(formName);
      out.write(".szCdRegion.value == \"\") {\r\n    clearDropdown ( ");
      out.print(formName);
      out.write(".szCdCounty );\r\n    } else {    \r\n      ");
 String dropdown = childSearchValueBean.getCdCounty()==null?request.getParameter("szCdCounty"):childSearchValueBean.getCdCounty(); 
      out.write("\r\n      var dropdownValue = \"");
      out.print(dropdown);
      out.write("\";    \r\n      populateDropdown(");
      out.print(formName);
      out.write(".szCdCounty, dropdownValue, eval(\"CCOUNT\"+");
      out.print(formName);
      out.write(".szCdRegion.value) );\r\n}\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExchangeChildSerach");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setAction("/exchange/ExchangeChildSearch/searchExchangeChild");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.exchange.ExchangeChildSearchCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\t<tr>\r\n\t\t\t<th colspan=\"12\">\r\n\t\t\t\tChild Locate\r\n\t\t\t</th>\r\n\t</tr>\r\n\t<tr class = \"subDetail\">\r\n\t<td>\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setName("txtNmFirst");
          _jspx_th_impact_validateInput_2.setLabel("First");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setSize("12");
          _jspx_th_impact_validateInput_2.setMaxLength("12");
          _jspx_th_impact_validateInput_2.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_2.setValue(FormattingHelper.formatString(childSearchValueBean.getNmFirst()));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t\t<td>\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setName("txtNmMiddle");
          _jspx_th_impact_validateInput_3.setLabel("Middle");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setSize("12");
          _jspx_th_impact_validateInput_3.setMaxLength("12");
          _jspx_th_impact_validateInput_3.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatString(childSearchValueBean.getNmMiddle()));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t<td>\r\n\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName("txtNmLast");
          _jspx_th_impact_validateInput_4.setLabel("Last");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setSize("22");
          _jspx_th_impact_validateInput_4.setMaxLength("22");
          _jspx_th_impact_validateInput_4.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString(childSearchValueBean.getNmLast()));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t</tr>\r\n\t<tr class = \"subDetail\">\r\n   \t<td>\r\n\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("szCdRegion");
          _jspx_th_impact_validateSelect_0.setLabel("Region");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setCodesTable("CREGIONS");
          _jspx_th_impact_validateSelect_0.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_0.setOnChange("populateCounty(false)");
          _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(childSearchValueBean.getCdRegion()));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t<td>\r\n\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("szCdCounty");
          _jspx_th_impact_validateSelect_1.setLabel("County");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(childSearchValueBean.getCdCounty()));
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t</tr>\r\n\t</table>\r\n\t");
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" width=\"100%\" id=\"TABLE1\">\r\n\t<tr>\r\n\t\t\t<th colspan=\"12\">\r\n\t\t\t\tSibling Group Locate\r\n\t\t\t</th>\r\n\t</tr>\r\n\t<tr class = \"subDetail\">\r\n\t<td>\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setName("txtIdSibGroup");
          _jspx_th_impact_validateInput_5.setLabel("Sibling Group ID");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setSize("16");
          _jspx_th_impact_validateInput_5.setMaxLength("16");
          _jspx_th_impact_validateInput_5.setConstraint("Paragraph30");
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatInt(childSearchValueBean.getIdSiblingGrp()));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n\t</tr>\r\n\t</table>\r\n\t");
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("FamilyPreferenceInfo");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Search Family Preferences");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n   <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n\t<tr>\r\n\t<th colspan=\"12\"> Demographics </th>\r\n\t</tr>\r\n\t</table>\r\n <table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  <tr>\r\n    <th colspan=\"12\">Male Age Range</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_2.setName("selMaleMinYearInt");
              _jspx_th_impact_validateSelect_2.setLabel("Min Year");
              _jspx_th_impact_validateSelect_2.setBlankValue("false");
              _jspx_th_impact_validateSelect_2.setDisabled("false");
              _jspx_th_impact_validateSelect_2.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_2.setValue(String.valueOf(maleMinMonths / 12));
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_3.setName("selMaleMinMonthInt");
              _jspx_th_impact_validateSelect_3.setLabel("Min Month");
              _jspx_th_impact_validateSelect_3.setBlankValue("false");
              _jspx_th_impact_validateSelect_3.setDisabled("fasle");
              _jspx_th_impact_validateSelect_3.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_3.setValue(String.valueOf(maleMinMonths % 12));
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_4.setName("selMaleMaxYearInt");
              _jspx_th_impact_validateSelect_4.setLabel("Max Year");
              _jspx_th_impact_validateSelect_4.setBlankValue("false");
              _jspx_th_impact_validateSelect_4.setDisabled("false");
              _jspx_th_impact_validateSelect_4.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_4.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_4.setValue(String.valueOf(maleMaxMonths / 12));
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_5.setName("selMaleMaxMonthInt");
              _jspx_th_impact_validateSelect_5.setLabel("Max Month");
              _jspx_th_impact_validateSelect_5.setBlankValue("false");
              _jspx_th_impact_validateSelect_5.setDisabled("false");
              _jspx_th_impact_validateSelect_5.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_5.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_5.setValue(String.valueOf(maleMaxMonths % 12));
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n          </table>\r\n        <table width=\"100%\" class =\"tableborder\" cellspacing=\"0\" cellpadding=\"3\">\r\n        <tr>\r\n          <th colspan=\"12\"> Female Age Range</th>\r\n          </tr>\r\n          <tr class=\"subDetail\">\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_6.setName("selFemaleMinYearInt");
              _jspx_th_impact_validateSelect_6.setLabel("Min Year");
              _jspx_th_impact_validateSelect_6.setBlankValue("false");
              _jspx_th_impact_validateSelect_6.setDisabled("false");
              _jspx_th_impact_validateSelect_6.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_6.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_6.setValue(String.valueOf(femaleMinMonths / 12));
              int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
              if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_7.setValue("");
              _jspx_th_impact_validateSelect_7.setName("selFemaleMinMonthInt");
              _jspx_th_impact_validateSelect_7.setLabel("Min Month");
              _jspx_th_impact_validateSelect_7.setBlankValue("false");
              _jspx_th_impact_validateSelect_7.setDisabled("false");
              _jspx_th_impact_validateSelect_7.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_7.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_7.setValue(String.valueOf(femaleMinMonths % 12));
              int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
              if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_8.setName("selFemaleMaxYearInt");
              _jspx_th_impact_validateSelect_8.setLabel("Max Year");
              _jspx_th_impact_validateSelect_8.setBlankValue("false");
              _jspx_th_impact_validateSelect_8.setDisabled("false");
              _jspx_th_impact_validateSelect_8.setOptions(yearOptions);
              _jspx_th_impact_validateSelect_8.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_8.setValue(String.valueOf(femaleMaxMonths / 12));
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n            <td>");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_9.setName("selFemaleMaxMonthInt");
              _jspx_th_impact_validateSelect_9.setLabel("Max Month");
              _jspx_th_impact_validateSelect_9.setBlankValue("false");
              _jspx_th_impact_validateSelect_9.setDisabled("fasle");
              _jspx_th_impact_validateSelect_9.setOptions(monthOptions);
              _jspx_th_impact_validateSelect_9.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_9.setValue(String.valueOf(femaleMaxMonths % 12));
              int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
              if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n            </td>\r\n          </tr>\r\n  \r\n  </table>\r\n  \t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  \t\t\t<tr class = \"subDetail\">\r\n  \t\t\t<td>\r\n  \t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setName("txtNbrChildren");
              _jspx_th_impact_validateInput_6.setLabel("Number of Children");
              _jspx_th_impact_validateInput_6.setCssClass("formInput");
              _jspx_th_impact_validateInput_6.setSize("2");
              _jspx_th_impact_validateInput_6.setMaxLength("2");
              _jspx_th_impact_validateInput_6.setConstraint("Numeric");
              _jspx_th_impact_validateInput_6.setType("text");
              _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatInt(childSearchValueBean.getNumChildren()));
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  \t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\tLegal Risk?\r\n\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndLegalRisk())) ? "true"
                                                                                                                           : "false");
              _jspx_th_impact_validateInput_7.setCssClass("formInput");
              _jspx_th_impact_validateInput_7.setDisabled("false");
              _jspx_th_impact_validateInput_7.setId("indLegalRisk_Yes");
              _jspx_th_impact_validateInput_7.setLabel("Yes");
              _jspx_th_impact_validateInput_7.setName("rbIndLegalRisk");
              _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_7.setType("radio");
              _jspx_th_impact_validateInput_7.setValue("Y");
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_8.setChecked("fasle");
              _jspx_th_impact_validateInput_8.setCssClass("formInput");
              _jspx_th_impact_validateInput_8.setDisabled("false");
              _jspx_th_impact_validateInput_8.setId("indLegalRisk_No");
              _jspx_th_impact_validateInput_8.setLabel("No");
              _jspx_th_impact_validateInput_8.setName("rbIndLegalRisk");
              _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_8.setType("radio");
              _jspx_th_impact_validateInput_8.setValue("N");
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n  \t</table>\r\n  ");
              out.write("\r\n  ");
              out.write("\r\n          <tr>\r\n          <th colspan=\"12\"> Special Needs</th>\r\n          </tr>\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE3\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_9.setName("cbxMntlRetard");
              _jspx_th_impact_validateInput_9.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01));
              _jspx_th_impact_validateInput_9.setCssClass("formInput");
              _jspx_th_impact_validateInput_9.setType("checkbox");
              _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_9.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndMentalRet())) ? "true"
                                                                                                                           : "false");
              _jspx_th_impact_validateInput_9.setValue("Y");
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_10.setName("szCdMntRetSevLevel");
              _jspx_th_impact_validateSelect_10.setLabel("");
              _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_10.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_10.setValue(FormattingHelper.formatString(childSearchValueBean.getCdMentRetSev()));
              int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
              if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\" style=\"font-weight: bold\">\r\n\t\t\t\t\tBackground Factors:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setName("cbxVislHearImp");
              _jspx_th_impact_validateInput_10.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02));
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              _jspx_th_impact_validateInput_10.setType("checkbox");
              _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_10.setChecked(ArchitectureConstants.Y.equals(childSearchValueBean.getIndVisHearImp()) ? "true" : "false");
              _jspx_th_impact_validateInput_10.setValue("Y");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_11.setName("szCdVisHearSevLevel");
              _jspx_th_impact_validateSelect_11.setLabel("");
              _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_11.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_11.setValue(FormattingHelper.formatString(childSearchValueBean.getCdVisHearImpSev()));
              int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
              if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setName("cbxFamHxDrgAlcohol");
              _jspx_th_impact_validateInput_11.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06));
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setType("checkbox");
              _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_11.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndFamHxDrAlc())) ? "true"
                                                                                                                            : "false");
              _jspx_th_impact_validateInput_11.setValue("Y");
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setName("cbxPhyDisabled");
              _jspx_th_impact_validateInput_12.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03));
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setType("checkbox");
              _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_12.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndPhyDisabled())) ? "true"
                                                                                                                             : "false");
              _jspx_th_impact_validateInput_12.setValue("Y");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_12.setName("szCdPhyDisSevLevel");
              _jspx_th_impact_validateSelect_12.setLabel("");
              _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_12.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_12.setValue(FormattingHelper.formatString(childSearchValueBean.getCdPhyDisbldSev()));
              int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
              if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setName("cbxFamHxMentIll");
              _jspx_th_impact_validateInput_13.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07));
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setType("checkbox");
              _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_13.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndFamHxMentIll())) ? "true"
                                                                                                                              : "false");
              _jspx_th_impact_validateInput_13.setValue("Y");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_14.setName("cbxEmtDisturbed");
              _jspx_th_impact_validateInput_14.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04));
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setType("checkbox");
              _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_14.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndEmotDist())) ? "true"
                                                                                                                          : "false");
              _jspx_th_impact_validateInput_14.setValue("Y");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_13.setName("szCdEmtDistSevLevel");
              _jspx_th_impact_validateSelect_13.setLabel("");
              _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_13.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_13.setValue(FormattingHelper.formatString(childSearchValueBean.getCdEmotDistSev()));
              int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
              if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setName("cbxFamHxMR");
              _jspx_th_impact_validateInput_15.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08));
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setType("checkbox");
              _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_15.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean.getIndFamHxMr())) ? "true"
                                                                                                                         : "false");
              _jspx_th_impact_validateInput_15.setValue("Y");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setName("cbxOthMedDiag");
              _jspx_th_impact_validateInput_16.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05));
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setType("checkbox");
              _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_16.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndOthMedDiag())) ? "true"
                                                                                                                            : "false");
              _jspx_th_impact_validateInput_16.setValue("Y");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_14.setName("szCdOthMedDiagSevLevel");
              _jspx_th_impact_validateSelect_14.setLabel("");
              _jspx_th_impact_validateSelect_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_14.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_14.setValue(FormattingHelper.formatString(childSearchValueBean.getCdOthDiagSev()));
              int _jspx_eval_impact_validateSelect_14 = _jspx_th_impact_validateSelect_14.doStartTag();
              if (_jspx_th_impact_validateSelect_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setName("cbxChHxSxAbuse");
              _jspx_th_impact_validateInput_17.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09));
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setType("checkbox");
              _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_17.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(childSearchValueBean
                                                                                                       .getIndChildHxSexAbuse())) ? "true"
                                                                                                                                 : "false");
              _jspx_th_impact_validateInput_17.setValue("Y");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              out.write("\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n   <th colspan=\"12\">Race</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_0.setName("cbxRace");
              _jspx_th_impact_codesCheckbox_0.setCodesTableName("CADRACE");
              _jspx_th_impact_codesCheckbox_0.setDefaultCodes(childSearchValueBean.getLstRacePrefs());
              _jspx_th_impact_codesCheckbox_0.setColumns(3);
              _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
              if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  </table>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr>\r\n   <th colspan=\"12\">Ethnicity</th>\r\n  </tr>\r\n            <tr>\r\n\t        \t<th colspan=\"4\">Child Ethnicity</th>\r\n\t  \t\t</tr>\r\n\t  \t\t<tr class=\"subDetail\">\r\n\t\t  \t\t <td>\r\n\t\t\t      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_1.setName("cbxEthnicity");
              _jspx_th_impact_codesCheckbox_1.setCodesTableName(CodesTables.CINDETHN);
              _jspx_th_impact_codesCheckbox_1.setDefaultCodes(childSearchValueBean.getLstEthnicityPrefs());
              _jspx_th_impact_codesCheckbox_1.setColumns(3);
              _jspx_th_impact_codesCheckbox_1.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_1.setDisabled("false");
              int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
              if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t   \t</td>\r\n\t  \t\t</tr>\r\n        </table>\r\n<table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n         <tr>\r\n   <th colspan=\"12\">Non-Avail Codes</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
              //  impact:codesCheckbox
              gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
              _jspx_th_impact_codesCheckbox_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_codesCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_codesCheckbox_2.setName("cbxNonAvlCodes");
              _jspx_th_impact_codesCheckbox_2.setCodesTableName("CANONAV");
              _jspx_th_impact_codesCheckbox_2.setDefaultCodes(childSearchValueBean.getLstNonAvailCodes());
              _jspx_th_impact_codesCheckbox_2.setColumns(3);
              _jspx_th_impact_codesCheckbox_2.setIsHorizontal(true);
              _jspx_th_impact_codesCheckbox_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_codesCheckbox_2 = _jspx_th_impact_codesCheckbox_2.doStartTag();
              if (_jspx_th_impact_codesCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n     ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearch");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmExchangeChildSerach");
          _jspx_th_impact_ButtonTag_0.setAction("/exchange/ExchangeChildSearch/searchExchangeChild");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n   </table>\r\n\t");
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />  \r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n  ");
      out.write("\r\n  \r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_1.setParent(null);
      _jspx_th_impact_validateForm_1.setName("frmExchangeChildResult");
      _jspx_th_impact_validateForm_1.setMethod("post");
      _jspx_th_impact_validateForm_1.setAction("/exchange/ExchangeChildSearch/searchExchangeChild");
      _jspx_th_impact_validateForm_1.setPageMode(pageMode);
      _jspx_th_impact_validateForm_1.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_1 = _jspx_th_impact_validateForm_1.doStartTag();
      if (_jspx_eval_impact_validateForm_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");

    if (!FormValidation.pageHasErrorMessages(request)
          && !FormValidation.pageHasValidationMessages("frmExchangeChildResult", request)) {
        if (ExchangeChildSearchConversation.SEARCH_URL.equals(ContextHelper.getPreviousUrl(request))
            || ExchangeChildSearchConversation.DISPLAY_URL.equals(ContextHelper.getPreviousUrl(request))
            || indPullBackMode) {
  
          out.write("\r\n\r\n  ");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_pagination_0.setSubmitUrl(ExchangeChildSearchConversation.SEARCH_URL);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n\t<input type=\"hidden\"  name=\"requestFromListPage\" value=\"ExchangeChildSearch\"/>\r\n    <div class=\"alignRight\">\r\n      <div class=\"formInstruct\">\r\n        Scroll for more information -->\r\n      </div>\r\n    </div>\r\n    <div id=\"exchangeChildSearchResults\" style=\"height:200px; width:765px; overflow:auto\" class=\"tableborderList\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" id=\"TABLEEXCH\">\r\n        ");

          ExchangeChildValueBean childRow = null;
                  int iLoopCounter = 0;
                  if (excChildList == null || excChildList.isEmpty()) {
        
              out.write("\r\n        <tr>\r\n             <th class=\"thList\">&nbsp;</th>\r\n             <th class=\"thList\">Last Name</th>\r\n             <th class=\"thList\">First Name</th>\r\n             <th class=\"thList\">Person ID</th>\r\n             <th class=\"thList\">Sibling Grp ID</th>\r\n             <th class=\"thList\">Availability Code</th>\r\n             <th class=\"thList\">County</th>\r\n             <th class=\"thList\">Date Out</th>\r\n        </tr>\r\n        <tr class=\"tableBG\">\r\n          <td colspan=\"9\" class=\"subDetail\">\r\n            ");
              out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
              out.write("\r\n          </td>\r\n        </tr>\r\n        ");

          } else {
        
              out.write("\r\n        <tr>\r\n             <th class=\"thList\">&nbsp;</th>\r\n             <th class=\"thList\">Last Name");
              if (_jspx_meth_impact_sortableColumnHeader_0(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             <th class=\"thList\">First Name");
              if (_jspx_meth_impact_sortableColumnHeader_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             <th class=\"thList\">Person ID");
              if (_jspx_meth_impact_sortableColumnHeader_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             <th class=\"thList\">Sibling Grp ID");
              if (_jspx_meth_impact_sortableColumnHeader_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             <th class=\"thList\">Availability Code");
              if (_jspx_meth_impact_sortableColumnHeader_4(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             <th class=\"thList\">County");
              if (_jspx_meth_impact_sortableColumnHeader_5(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             <th class=\"thList\">Date Out");
              if (_jspx_meth_impact_sortableColumnHeader_6(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("</th>\r\n             \r\n        </tr>\r\n        ");

          nbrResults = excChildList.size();
                    for (int count = 0; count < nbrResults; count++) {
                      ExchangeChildValueBean childValueBean = excChildList.get(count);
        
              out.write("\r\n        \t<tr>\r\n         ");

           if (indPullBackMode) {
                         String chckBoxName = "ckName_Link" + count;
         
              out.write("\r\n            <td>\r\n            ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_18.setValue(String.valueOf(count));
              _jspx_th_impact_validateInput_18.setType("checkbox");
              _jspx_th_impact_validateInput_18.setChecked("false");
              _jspx_th_impact_validateInput_18.setName(chckBoxName);
              _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t    </td>\r\n         \t\t\t");

         			  } else {
         			
              out.write("\r\n         \t\t\t\t<td><nobr></nobr></td>\r\n         \t\t\t");

         			  }
         			              if (!indPullBackMode) {
         			
              out.write("\r\n            <td>\r\n            <a href=\"javascript:getExchangeChildDetail('");
              out.print(count);
              out.write("', '");
              out.print(childValueBean.getIdStage());
              out.write("')\" onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\">\r\n\t\t          ");
              out.print(FormattingHelper.formatString(childValueBean.getNmLast()));
              out.write("\r\n\t\t    </a></td>\r\n\t\t    <td>\r\n            <a href=\"javascript:getExchangeChildDetail('");
              out.print(count);
              out.write("', '");
              out.print(childValueBean.getIdStage());
              out.write("')\" onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\">\r\n\t\t          ");
              out.print(FormattingHelper.formatString(childValueBean.getNmFirst()) + " " + ((childValueBean.getNmMiddle() == null) || ("".equals(childValueBean.getNmMiddle())) ? "" : FormattingHelper.formatString(childValueBean.getNmMiddle().substring(0,1))));
              out.write("\r\n\t\t    </a></td>\r\n            <td><a href=\"javascript:getPersonDetail('");
              out.print(count);
              out.write("', '");
              out.print(childValueBean.getIdStage());
              out.write("')\" onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\">\r\n\t\t          ");
              out.print(FormattingHelper.formatInt(childValueBean.getIdChild()));
              out.write("\r\n\t\t    </a></td>\r\n\t\t    ");

		      if (childValueBean.getIdSiblingGrp() > 0) {
		    
              out.write("\r\n\t\t    <td><a href=\"javascript:getAdoptionInfo('");
              out.print(count);
              out.write("', '");
              out.print(childValueBean.getIdStage());
              out.write("')\" onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\">\r\n\t\t          ");
              out.print(FormattingHelper.formatInt(childValueBean.getIdSiblingGrp()));
              out.write("\r\n\t\t    </a></td>\r\n\t\t    ");

		      } else {
		    
              out.write("\r\n            <td></td>\r\n            ");

              }
                          } else {
            
              out.write("\r\n            <td>");
              out.print(FormattingHelper.formatString(childValueBean.getNmLast()));
              out.write("</td>\r\n            <td>");
              out.print(FormattingHelper.formatString(childValueBean.getNmFirst()) + " " + ((childValueBean.getNmMiddle() == null) || ("".equals(childValueBean.getNmMiddle())) ? "" : FormattingHelper.formatString(childValueBean.getNmMiddle().substring(0,1))));
              out.write("</td>\r\n            <td>");
              out.print(FormattingHelper.formatInt(childValueBean.getIdChild()));
              out.write("</td>\r\n            <td>");
              out.print(FormattingHelper.formatInt(childValueBean.getIdSiblingGrp()));
              out.write("</td>\r\n            ");

              }
            
              out.write("\r\n            <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CANONAV, childValueBean.getNonAvailCode()));
              out.write("</td>                          \r\n            <td>");
              out.print(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, childValueBean.getCdCounty()));
              out.write("</td>\r\n            <td>");
              out.print(FormattingHelper.formatDate(childValueBean.getDtOut()));
              out.write("</td>\r\n        </tr>\r\n\r\n");

  }
          }

              out.write("\r\n        </table>\r\n    </div>");

      /* this is where the "scrollBar" div tag ends */
    
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(resultsPerPageName);
          out.write("\" value=\"");
          out.print(resultsPerPage);
          out.write("\"/> \r\n     ");

        String functionString = "disableValidation('frmExchangeChildResult'); return checkRowSelected( "
                                      + nbrResults + ");";
              if (indPullBackMode && nbrResults != 0) {
      
          out.write(" \r\n    \t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\r\n    <tr>\r\n      <td class=\"alignRight\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_1);
          _jspx_th_impact_ButtonTag_1.setName("btnContinue");
          _jspx_th_impact_ButtonTag_1.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmExchangeChildResult");
          _jspx_th_impact_ButtonTag_1.setFunction(functionString);
          _jspx_th_impact_ButtonTag_1.setAction("/exchange/ExchangeChildSearch/pullBackExchangeChildDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n   </table>\r\n     ");

       }
           }
         }
     
          out.write("\r\n  <br>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />  \r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmExchangeChildSerach");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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
    _jspx_th_impact_validateInput_0.setName("hdnIdStage");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("hdnRowIndex");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_sortableColumnHeader_0.setOrderBy("NM_PERSON_LAST");
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
    _jspx_th_impact_sortableColumnHeader_1.setOrderBy("NM_PERSON_FIRST");
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
    _jspx_th_impact_sortableColumnHeader_2.setOrderBy("ID_PERSON");
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
    _jspx_th_impact_sortableColumnHeader_3.setOrderBy("ID_SIBLING_GROUP");
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
    _jspx_th_impact_sortableColumnHeader_4.setOrderBy("CD_NON_AVAIL_STATUS");
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
    _jspx_th_impact_sortableColumnHeader_5.setOrderBy("CD_LEGAL_STAT_CNTY");
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
    _jspx_th_impact_sortableColumnHeader_6.setOrderBy("DT_OUT");
    int _jspx_eval_impact_sortableColumnHeader_6 = _jspx_th_impact_sortableColumnHeader_6.doStartTag();
    if (_jspx_th_impact_sortableColumnHeader_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
