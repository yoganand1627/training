package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExcChildAdoInfoCbxStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExchangeChildStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildLinkStruct;
import gov.georgia.dhr.dfcs.sacwis.web.person.ExchangeChildDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ExchangeChildDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Initialize all display variables for the page
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  ExchangeChildDetailRetrieveSO exchangeChildDetailRetSO = (ExchangeChildDetailRetrieveSO) state
                                                                                                .getAttribute(
                                                                                                              ExchangeChildDetailConversation.EXCHANGE_CHILD_DETAIL,
                                                                                                              request);
  String pageMode = PageMode.getPageMode(request);
  int tabIndex = 1;
  boolean iterator = false;
  String birthNameToDisplay = "";
  int loopCount = 0;
  int hasBeenLoopCount = 0;
  String nonAvailRsnCode = "";
  String linkNonAvailRsnCode = "";
  Date dateOut = null;
  int idEvent = 0;
  int idStage = GlobalData.getUlIdStage(request);
  boolean indMatching = false;
  ExchangeChildStruct excChildStruct = new ExchangeChildStruct();
  List<ChildLinkStruct> childLinkStructList = new ArrayList<ChildLinkStruct>();
  List<ChildLinkStruct> hasBeenChildLinkStructList = new ArrayList<ChildLinkStruct>();
  Map<String,List<ExcChildAdoInfoCbxStruct>> savedRecActivitiesDatesState = new HashMap<String,List<ExcChildAdoInfoCbxStruct>>();
  if (exchangeChildDetailRetSO == null) {
    exchangeChildDetailRetSO = new ExchangeChildDetailRetrieveSO();
  } else {
    if (exchangeChildDetailRetSO.getExchangeChildStruct() != null) {
      excChildStruct = exchangeChildDetailRetSO.getExchangeChildStruct();
      nonAvailRsnCode = excChildStruct.getCdNonAvailStatus();
      idEvent = excChildStruct.getIdChildEvent();
    }
    if (exchangeChildDetailRetSO.getChildLinkStructList() != null) {
      childLinkStructList = exchangeChildDetailRetSO.getChildLinkStructList();
    }
    if (exchangeChildDetailRetSO.getHasBeenChildLinkStructList() != null) {
      hasBeenChildLinkStructList = exchangeChildDetailRetSO.getHasBeenChildLinkStructList();
    }
    if (exchangeChildDetailRetSO.getDtDissolution() != null) {
      birthNameToDisplay = excChildStruct.getTxtBirthName();
    } else {
      birthNameToDisplay = "";
    }
    if(exchangeChildDetailRetSO.getSavedRecActivitiesDates() != null)
    {
      savedRecActivitiesDatesState = exchangeChildDetailRetSO.getSavedRecActivitiesDates();
    }
  }
  if (childLinkStructList != null && childLinkStructList.size() > 0) {
    Iterator iter = childLinkStructList.iterator();
    while (iter.hasNext()) {
      ChildLinkStruct childLinkStruct = (ChildLinkStruct) iter.next();
      if (!childLinkStruct.isIndLinked()) {
        indMatching = true;
        break;
      }
    }
  }
  if (indMatching) {
    linkNonAvailRsnCode = CodesTables.CANONAV_03;
  } else {
    linkNonAvailRsnCode = CodesTables.CANONAV_00;
  }
  // MR-074-2
  boolean multiPutativePather = exchangeChildDetailRetSO.isMultiPutFather() ? true : false;

  // MR-083
  String cdStateActivelyRecruiting = exchangeChildDetailRetSO.getCdStateActivelyRecruiting();
  List<CodeAttributes> activityCodesList = Lookup.getCategoryCollection(CodesTables.CADRACS);
  

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"Javascript1.2\">\r\n// Check for changes before navigating off\r\nwindow.onbeforeunload = function ()\r\n{\r\n   IsDirty();\r\n};\r\n\r\nfunction checkSave() {\r\n if(isPageChanged()) {\r\n \talert(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_SAVE_BEFORE_MATCH));
      out.write("\");\r\n \treturn false;\r\n }\r\n \r\n return true;\r\n}\r\n\r\nfunction getExchangeChildDetail(idHomeEvent, idResource, nmHome)\r\n{\r\n  frmExchangeChildDetail.hdnIdHomeEvent.value = idHomeEvent;\r\n  frmExchangeChildDetail.hdnIdResource.value = idResource;\r\n  frmExchangeChildDetail.hdnIdHomeName.value = nmHome\r\n  submitValidateForm( \"frmExchangeChildDetail\", \"/person/ExchangeChildDetail/displayHomeDetail\" );\r\n}\r\n\r\nfunction getAdoInfoPage(idChildEvent, idStage)\r\n{\r\n  frmExchangeChildDetail.hdnIdChildEvent.value = idChildEvent;\r\n  frmExchangeChildDetail.hdnIdStage.value = idStage;\r\n  submitValidateForm( \"frmExchangeChildDetail\", \"/person/ExchangeChildDetail/displayAdoInfo\" );\r\n}\r\n\r\nfunction confirmDelete() {\r\n return confirm('");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("');\r\n}\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmExchangeChildDetail");
      _jspx_th_impact_validateForm_0.setAction("/person/ExchangeChildDetail/saveExchangeChildDetail");
      _jspx_th_impact_validateForm_0.setClientValidation("true");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.ExchangeChildDetailCustomValidation");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCdReasonClosed");
          _jspx_th_impact_validateInput_4.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getExchangeChildStruct().getCdRsnClosed()));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnTxtBirthName");
          _jspx_th_impact_validateInput_5.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getExchangeChildStruct().getTxtBirthName()));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnIdSiblGroup");
          _jspx_th_impact_validateInput_6.setValue(FormattingHelper.formatInt(exchangeChildDetailRetSO.getIdSiblingGroup()));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:expandAll()\">Expand All</a>&nbsp; <a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" onClick=\"hrefDirtyBypass=true;\" href=\"javascript:collapseAll()\">Collapse All</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\twidth=\"100%\" id=\"TABLE1\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"12\">\r\n\t\t\t\tChild Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspNmChild");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Child Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getNmChild()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspGender");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Gender");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(Lookup.simpleDecodeSafe(CodesTables.CSEX, exchangeChildDetailRetSO.getCdGender()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspStatus");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Status");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(Lookup.simpleDecodeSafe(CodesTables.CANONAV, excChildStruct.getCdNonAvailStatus()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspAge");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Age");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatInt(exchangeChildDetailRetSO.getChildAge()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspDtBirth");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Date of Birth");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBirthChild()));
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t");
 int idSibGrp = exchangeChildDetailRetSO.getIdSiblingGroup();
		if(idSibGrp>0){ 
          out.write("\r\n\t\t  <td>\r\n\t\t   Sibling Group ID:\r\n\t\t\t<a href=\"javascript:getAdoInfoPage('");
          out.print(exchangeChildDetailRetSO.getExchangeChildStruct().getIdChildEvent());
          out.write("', '");
          out.print(idStage);
          out.write("')\" \r\n\t\t\t   onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\">\r\n\t\t\t\t  ");
          out.print(FormattingHelper.formatInt(idSibGrp));
          out.write("\r\n\t\t    </a></td>\r\n\t\t");
 }else{ 
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspIdSiblGroup");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Sibling Group ID");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(FormattingHelper.formatInt(idSibGrp));
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t   ");
 } 
          out.write("\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("dspCaseWorkerInfo");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Case Worker");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getCaseWorkerInfo()));
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dspRace");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Race");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getChildRace()));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("dspEthnicity");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Ethnicity");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getChildEthnicity()));
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tChild Has Legal Risk?\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndLegalRisk())) ? "true"
                                                                                                                      : "false");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setDisabled("false");
          _jspx_th_impact_validateInput_8.setId("indLegalRisk_Yes");
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setName("rbIndLegalRisk");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setValue("Y");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setChecked(ArchitectureConstants.N.equals(FormattingHelper.formatString(excChildStruct.getIndLegalRisk())) ? "true"
                                                                                                                      : "false");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setDisabled("false");
          _jspx_th_impact_validateInput_9.setId("indLegalRisk_No");
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setName("rbIndLegalRisk");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setValue("N");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("RegistrationInfo");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Registration Information");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE2\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_9.setName("dspDtLastEntry");
              _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Last Entry Into Foster Care");
              _jspx_th_impact_validateDisplayOnlyField_9.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtLastEntryFc()));
              int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_10.setName("dspDtNotified");
              _jspx_th_impact_validateDisplayOnlyField_10.setLabel("Date Notified");
              _jspx_th_impact_validateDisplayOnlyField_10.setValue(FormattingHelper.formatDate(excChildStruct.getDtNotified()));
              int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_11.setName("dspDtApproved");
              _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Date Approved");
              _jspx_th_impact_validateDisplayOnlyField_11.setValue(FormattingHelper.formatDate(excChildStruct.getDtApproved()));
              int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setName("txtDtRegistered");
              _jspx_th_impact_validateDate_0.setLabel("Date Registered");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(excChildStruct.getDtRegistered()));
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_1.setName("txtDtReRegistered");
              _jspx_th_impact_validateDate_1.setLabel("Date Re-Registered");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(excChildStruct.getDtReRegistered()));
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_12.setName("dspDtUpdated");
              _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Date Updated");
              _jspx_th_impact_validateDisplayOnlyField_12.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtUpdated()));
              int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"9\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setName("cbxAdoDissolution");
              _jspx_th_impact_validateInput_10.setLabel("Previous Adoption Dissolution");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              _jspx_th_impact_validateInput_10.setType("checkbox");
              _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_10.setDisabled("true");
              _jspx_th_impact_validateInput_10.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper
                                                                     .formatString(exchangeChildDetailRetSO
                                                                                                           .getIndAdoptDissol())) ? "true"
                                                                                                                                 : "false");
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"1\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_13.setName("dspDtPrevDissolution");
              _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Previous Dissolution Date");
              _jspx_th_impact_validateDisplayOnlyField_13.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDissolution()));
              int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setName("txtNmBirth");
              _jspx_th_impact_validateInput_11.setLabel("Birth Name");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setSize("30");
              _jspx_th_impact_validateInput_11.setMaxLength("30");
              _jspx_th_impact_validateInput_11.setConstraint("Paragraph30");
              _jspx_th_impact_validateInput_11.setType("text");
              _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_11.setValue(birthNameToDisplay);
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE2\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"9\">\r\n\t\t\t\t\tResponsible County\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_14.setName("dspNmCounty");
              _jspx_th_impact_validateDisplayOnlyField_14.setLabel("County Name");
              _jspx_th_impact_validateDisplayOnlyField_14.setValue(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeChildDetailRetSO.getNbrRspCounty()));
              int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_15.setName("dspNbrCounty");
              _jspx_th_impact_validateDisplayOnlyField_15.setLabel("County Number");
              _jspx_th_impact_validateDisplayOnlyField_15.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getNbrRspCounty()));
              int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_16.setName("dspRegion");
              _jspx_th_impact_validateDisplayOnlyField_16.setLabel("Region");
              _jspx_th_impact_validateDisplayOnlyField_16.setValue(Lookup.simpleDecodeSafe(CodesTables.CREGIONS, exchangeChildDetailRetSO.getCdRspRegion()));
              int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"9\">\r\n\t\t\t\t\tBoarding County\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_17.setName("dspNmBrdCounty");
              _jspx_th_impact_validateDisplayOnlyField_17.setLabel("County Name");
              _jspx_th_impact_validateDisplayOnlyField_17.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getNmBrdCounty()));
              int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_18.setName("dspNbrBrdCounty");
              _jspx_th_impact_validateDisplayOnlyField_18.setLabel("County Number");
              _jspx_th_impact_validateDisplayOnlyField_18.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getNbrBrdCounty()));
              int _jspx_eval_impact_validateDisplayOnlyField_18 = _jspx_th_impact_validateDisplayOnlyField_18.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_19.setName("dspBrdRegion");
              _jspx_th_impact_validateDisplayOnlyField_19.setLabel("Region");
              _jspx_th_impact_validateDisplayOnlyField_19.setValue(Lookup.simpleDecodeSafe(CodesTables.CREGIONS, exchangeChildDetailRetSO.getCdBrdRegion()));
              int _jspx_eval_impact_validateDisplayOnlyField_19 = _jspx_th_impact_validateDisplayOnlyField_19.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("SpecialNeedsChar");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Special Needs Characteristics");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_1.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE3\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_12.setName("cbxMntlRetard");
              _jspx_th_impact_validateInput_12.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_01));
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setType("checkbox");
              _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_12.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndMntlRetard())) ? "true"
                                                                                                                      : "false");
              _jspx_th_impact_validateInput_12.setValue("Y");
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_0.setName("szCdMntRetSevLevel");
              _jspx_th_impact_validateSelect_0.setLabel("");
              _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_0.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatString(excChildStruct.getCdMntlSevLevel()));
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\" style=\"font-weight: bold\">\r\n\t\t\t\t\tBackground Factors:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_13.setName("cbxVislHearImp");
              _jspx_th_impact_validateInput_13.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_02));
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setType("checkbox");
              _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_13.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndVisHearImp())) ? "true"
                                                                                                                      : "false");
              _jspx_th_impact_validateInput_13.setValue("Y");
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_1.setName("szCdVisHearSevLevel");
              _jspx_th_impact_validateSelect_1.setLabel("");
              _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_1.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(excChildStruct.getCdVisHearSevLevel()));
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_14.setName("cbxFamHxDrgAlcohol");
              _jspx_th_impact_validateInput_14.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_06));
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setType("checkbox");
              _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_14.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndFamHxDrugs())) ? "true"
                                                                                                                      : "false");
              _jspx_th_impact_validateInput_14.setValue("Y");
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_15.setName("cbxPhyDisabled");
              _jspx_th_impact_validateInput_15.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_03));
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setType("checkbox");
              _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_15.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndPhyDisabled())) ? "true"
                                                                                                                       : "false");
              _jspx_th_impact_validateInput_15.setValue("Y");
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_2.setName("szCdPhyDisSevLevel");
              _jspx_th_impact_validateSelect_2.setLabel("");
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_2.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString(excChildStruct.getCdPhySevLevel()));
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_16.setName("cbxFamHxMentIll");
              _jspx_th_impact_validateInput_16.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_07));
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setType("checkbox");
              _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_16.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndFamHxIll())) ? "true"
                                                                                                                       : "false");
              _jspx_th_impact_validateInput_16.setValue("Y");
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_17.setName("cbxEmtDisturbed");
              _jspx_th_impact_validateInput_17.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_04));
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setType("checkbox");
              _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_17.setChecked(ArchitectureConstants.Y
                                             .equals(FormattingHelper.formatString(excChildStruct.getIndEmtDisturbed())) ? "true"
                                                                                                                        : "false");
              _jspx_th_impact_validateInput_17.setValue("Y");
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_3.setName("szCdEmtDistSevLevel");
              _jspx_th_impact_validateSelect_3.setLabel("");
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_3.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(excChildStruct.getCdEmtSevLevel()));
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_18.setName("cbxFamHxMR");
              _jspx_th_impact_validateInput_18.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_08));
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setType("checkbox");
              _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_18.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndFamHxMr())) ? "true"
                                                                                                                      : "false");
              _jspx_th_impact_validateInput_18.setValue("Y");
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_19.setName("cbxOthMedDiag");
              _jspx_th_impact_validateInput_19.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADCHAR, CodesTables.CADCHAR_05));
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setType("checkbox");
              _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_19.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndOthMed())) ? "true"
                                                                                                                     : "false");
              _jspx_th_impact_validateInput_19.setValue("Y");
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_4.setName("szCdOthMedDiagSevLevel");
              _jspx_th_impact_validateSelect_4.setLabel("");
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_4.setCodesTable("CADSEVER");
              _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(excChildStruct.getCdOthSevLevel()));
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_20.setName("cbxChHxSxAbuse");
              _jspx_th_impact_validateInput_20.setLabel(Lookup.simpleDecodeSafe(CodesTables.CADBKRNF, CodesTables.CADBKRNF_09));
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setType("checkbox");
              _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_20.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(excChildStruct.getIndChHxSxAbuse())) ? "true"
                                                                                                                       : "false");
              _jspx_th_impact_validateInput_20.setValue("Y");
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_0.setColspan("5");
              _jspx_th_impact_validateTextArea_0.setName("txtSpclNeedsCmnts");
              _jspx_th_impact_validateTextArea_0.setRows("4");
              _jspx_th_impact_validateTextArea_0.setCols("77");
              _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_0.setMaxLength(500);
              _jspx_th_impact_validateTextArea_0.setDisabled("false");
              _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph500");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(excChildStruct.getTxtSpclNeedsCmnts()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("ChildAvlbty");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Child Availability");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_2.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE4\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateSelect_5.setName("szCdNonAvailRsnCode");
              _jspx_th_impact_validateSelect_5.setLabel("Non-Availability Reason Code");
              _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_5.setCodesTable("CANONAV");
              _jspx_th_impact_validateSelect_5.setRequired("true");
              _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(nonAvailRsnCode));
              int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
              if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDisplayOnlyField_20.setName("dspDtOut");
              _jspx_th_impact_validateDisplayOnlyField_20.setLabel("Date Out");
              _jspx_th_impact_validateDisplayOnlyField_20.setValue(FormattingHelper.formatDate(excChildStruct.getDtOut()));
              int _jspx_eval_impact_validateDisplayOnlyField_20 = _jspx_th_impact_validateDisplayOnlyField_20.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDisplayOnlyField_21.setName("dspDaysOut");
              _jspx_th_impact_validateDisplayOnlyField_21.setLabel("Days Out");
              _jspx_th_impact_validateDisplayOnlyField_21.setValue(FormattingHelper.formatString(excChildStruct.getTxtDaysOut()));
              int _jspx_eval_impact_validateDisplayOnlyField_21 = _jspx_th_impact_validateDisplayOnlyField_21.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"1\">\r\n\t\t\t\t\tComments:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"8\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_1.setColspan("8");
              _jspx_th_impact_validateTextArea_1.setName("txtChAvlCmnts");
              _jspx_th_impact_validateTextArea_1.setRows("4");
              _jspx_th_impact_validateTextArea_1.setCols("77");
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_1.setMaxLength(2000);
              _jspx_th_impact_validateTextArea_1.setDisabled("false");
              _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph2000");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(excChildStruct.getTxtAvailCmnts()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"1\">\r\n\t\t\t\t\tChild is Linked:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"8\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_2.setColspan("8");
              _jspx_th_impact_validateTextArea_2.setName("txtChLnkCmnts");
              _jspx_th_impact_validateTextArea_2.setRows("4");
              _jspx_th_impact_validateTextArea_2.setCols("77");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setMaxLength(500);
              _jspx_th_impact_validateTextArea_2.setDisabled("false");
              _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph500");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(excChildStruct.getTxtChLinked()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"9\" class=\"alignRight\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_0.setName("btnMatch");
              _jspx_th_impact_ButtonTag_0.setAlign("right");
              _jspx_th_impact_ButtonTag_0.setImg("btnMatch");
              _jspx_th_impact_ButtonTag_0.setForm("frmExchangeChildDetail");
              _jspx_th_impact_ButtonTag_0.setAction("/person/ExchangeChildDetail/matchHomes");
              _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_0.setFunction("return checkSave();");
              _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
              if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t");
              //  impact:pagination
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
              _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_pagination_0.setSubmitUrl("/person/ExchangeChildDetail/displayExchangeChildDetail");
              int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
              if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t<div id=\"scrollBar\" style=\"height: 155; width: 100%; overflow: auto\"\r\n\t\t\t\tclass=\"tableborderList\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t\t\t<br>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"9\">\r\n\t\t\t\t\t\t\tNow Being Considered By\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tUnlink\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tResource ID\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thListNoWrap\">\r\n\t\t\t\t\t\t\tNon-Availability Reason Code\r\n\t\t\t\t\t\t\t");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_0.setOrderBy(ExchangeChildDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE);
                  _jspx_th_impact_sortableColumnHeader_0.setIsDefault("false");
                  int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tCounty\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thListNoWrap\">\r\n\t\t\t\t\t\t\tDate Out\r\n\t\t\t\t\t\t\t");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_1.setOrderBy(ExchangeChildDetailConversation.SORT_BY_DT_OUT);
                  _jspx_th_impact_sortableColumnHeader_1.setIsDefault("true");
                  int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

					  if (childLinkStructList != null && childLinkStructList.size() > 0) {
					          Iterator it = childLinkStructList.iterator();
					          while (it.hasNext()) {
					            ChildLinkStruct childLinkStruct = (ChildLinkStruct) it.next();

					            String chkBoxName = "cbxUnLink" + loopCount;
					
                  out.write("\r\n\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t");

						  if (childLinkStruct.isIndLinked()) {
						
                  out.write("\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateInput_21.setValue(String.valueOf(loopCount));
                  _jspx_th_impact_validateInput_21.setType("checkbox");
                  _jspx_th_impact_validateInput_21.setChecked("false");
                  _jspx_th_impact_validateInput_21.setName(chkBoxName);
                  _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_21.setCssClass("formInput");
                  int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
                  if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t");

						  } else {
						
                  out.write("\r\n\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t");

						  }
						
                  out.write("\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t<a href=\"javascript:getExchangeChildDetail('");
                  out.print(childLinkStruct.getIdHomeEvent());
                  out.write("' ,'");
                  out.print(childLinkStruct.getIdResource());
                  out.write('\'');
                  out.write(',');
                  out.write('\'');
                  out.print(FormattingHelper.formatString(childLinkStruct.getNmResource()));
                  out.write("')\" \r\n\t\t\t\t\t\t   onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\">\r\n\t\t\t\t\t\t ");
                  out.print(FormattingHelper.formatInt(childLinkStruct.getIdResource()));
                  out.write("\r\n\t\t\t\t\t    </a></td>\r\n\t\t\t\t\t\t<td>");
                  out.print(FormattingHelper.formatString(childLinkStruct.getNmResource()));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(Lookup.simpleDecodeSafe(CodesTables.CANONAV, (childLinkStruct.getNonAvlRsnCode())));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, (childLinkStruct.getCounty())));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(FormattingHelper.formatDate(childLinkStruct.getDtOut()));
                  out.write("</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

					  // increment the loop counter
					            loopCount++;
					          }

					        } else {
					
                  out.write("\r\n\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t<td colspan=\"8\">\r\n\t\t\t\t\t\t\tNo Results Found\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

					  }
					
                  out.write("\r\n\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE2\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateSelect_6.setName("szCdNonAvailRsn");
                  _jspx_th_impact_validateSelect_6.setLabel("Non-Availability Reason");
                  _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateSelect_6.setCodesTable("CANONAV");
                  _jspx_th_impact_validateSelect_6.setValue(linkNonAvailRsnCode);
                  int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
                  if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateDate_2.setName("txtDtOutLink");
                  _jspx_th_impact_validateDate_2.setLabel("Date Out");
                  _jspx_th_impact_validateDate_2.setConstraint("Date");
                  _jspx_th_impact_validateDate_2.setConditionallyRequired("false");
                  _jspx_th_impact_validateDate_2.setSize("10");
                  _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(new Date()));
                  int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
                  if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_1.setName("btnLink");
                  _jspx_th_impact_ButtonTag_1.setAlign("right");
                  _jspx_th_impact_ButtonTag_1.setImg("btnLink");
                  _jspx_th_impact_ButtonTag_1.setForm("frmExchangeChildDetail");
                  _jspx_th_impact_ButtonTag_1.setAction("/person/ExchangeChildDetail/linkHomes");
                  _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
                  if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
                  //  impact:validateSelect
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
                  _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateSelect_7.setName("szCdNonSelRsn");
                  _jspx_th_impact_validateSelect_7.setLabel("Non-Selection Reason");
                  _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateSelect_7.setCodesTable("CADNSLCT");
                  _jspx_th_impact_validateSelect_7.setValue("");
                  int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
                  if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_2.setName("btnUnlink");
                  _jspx_th_impact_ButtonTag_2.setAlign("right");
                  _jspx_th_impact_ButtonTag_2.setImg("btnUnlink");
                  _jspx_th_impact_ButtonTag_2.setForm("frmExchangeChildDetail");
                  _jspx_th_impact_ButtonTag_2.setAction("/person/ExchangeChildDetail/unLinkHomes");
                  _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
                  if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t\t");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_ButtonTag_3.setName("btnDeleteNowConsidering");
                  _jspx_th_impact_ButtonTag_3.setAlign("right");
                  _jspx_th_impact_ButtonTag_3.setImg("btnDelete");
                  _jspx_th_impact_ButtonTag_3.setForm("frmExchangeChildDetail");
                  _jspx_th_impact_ButtonTag_3.setAction("/person/ExchangeChildDetail/deleteNowConsidering");
                  _jspx_th_impact_ButtonTag_3.setRestrictRepost(true);
                  _jspx_th_impact_ButtonTag_3.setPreventDoubleClick(true);
                  _jspx_th_impact_ButtonTag_3.setFunction("return confirmDelete();");
                  _jspx_th_impact_ButtonTag_3.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
                  if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t\t<div id=\"scrollBar\" style=\"height: 155; width: 100%; overflow: auto\"\r\n\t\t\t\tclass=\"tableborderList\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t\t\t<br>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th colspan=\"9\" class=\"thList\">\r\n\t\t\t\t\t\t\tHas been Considered By\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tResource ID\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thListNoWrap\">\r\n\t\t\t\t\t\t\tNon-Availability Reason Code\r\n\t\t\t\t\t\t\t");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_2.setOrderBy(ExchangeChildDetailConversation.SORT_BY_NON_AVAIL_RSN_CODE);
                  _jspx_th_impact_sortableColumnHeader_2.setIsDefault("false");
                  int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tNon-Selection Reason\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tCounty\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thListNoWrap\">\r\n\t\t\t\t\t\t\tDate Out\r\n\t\t\t\t\t\t\t");
                  //  impact:sortableColumnHeader
                  gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
                  _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_sortableColumnHeader_3.setOrderBy(ExchangeChildDetailConversation.SORT_BY_DT_OUT);
                  _jspx_th_impact_sortableColumnHeader_3.setIsDefault("true");
                  int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
                  if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\tUnlink Date\r\n\t\t\t\t\t\t</th>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

					  if (hasBeenChildLinkStructList != null && hasBeenChildLinkStructList.size() > 0) {
					          Iterator it = hasBeenChildLinkStructList.iterator();
					          while (it.hasNext()) {
					            ChildLinkStruct hasBeenChildLinkStruct = (ChildLinkStruct) it.next();
					            String chkBoxName = "cbxDelete" + hasBeenLoopCount;
					
                  out.write("\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t   <td>\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
                  _jspx_th_impact_validateInput_22.setValue(String.valueOf(loopCount));
                  _jspx_th_impact_validateInput_22.setType("checkbox");
                  _jspx_th_impact_validateInput_22.setChecked("false");
                  _jspx_th_impact_validateInput_22.setName(chkBoxName);
                  _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_22.setCssClass("formInput");
                  int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
                  if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t   <td>\r\n\t\t\t\t\t\t<a href=\"javascript:getExchangeChildDetail('");
                  out.print(hasBeenChildLinkStruct.getIdHomeEvent());
                  out.write("' , '");
                  out.print(hasBeenChildLinkStruct.getIdResource());
                  out.write("', '");
                  out.print(FormattingHelper.formatString(hasBeenChildLinkStruct.getNmResource()));
                  out.write("')\" \r\n\t\t\t\t\t\t   onclick=\"setIsDirtyCalled(true)\" tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\">\r\n\t\t\t\t\t\t\t  ");
                  out.print(FormattingHelper.formatInt(hasBeenChildLinkStruct.getIdResource()));
                  out.write("\r\n\t\t\t\t\t    </a></td>\r\n\t\t\t\t\t\t<td>");
                  out.print(FormattingHelper.formatString(hasBeenChildLinkStruct.getNmResource()));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(Lookup.simpleDecodeSafe(CodesTables.CANONAV, hasBeenChildLinkStruct.getNonAvlRsnCode()));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(Lookup.simpleDecodeSafe(CodesTables.CADNSLCT, hasBeenChildLinkStruct.getNonSelRsn()));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, hasBeenChildLinkStruct.getCounty()));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(FormattingHelper.formatDate(hasBeenChildLinkStruct.getDtOut()));
                  out.write("</td>\r\n\t\t\t\t\t\t<td>");
                  out.print(FormattingHelper.formatDate(hasBeenChildLinkStruct.getDtLastUpdate()));
                  out.write("</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

					  // increment the loop counter
					            hasBeenLoopCount++;
					          }
					        } else {
					
                  out.write("\r\n\t\t\t\t\t<tr class=\"odd\">\r\n\t\t\t\t\t\t<td colspan=\"8\">\r\n\t\t\t\t\t\t\tNo Results Found\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t");

					  }
					
                  out.write("\r\n\t\t\t\t</table>\r\n\t\t\t</div>\r\n\t\t");
                  int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE2\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t\t");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_ButtonTag_4.setName("btnDeleteHasConsidered");
              _jspx_th_impact_ButtonTag_4.setAlign("right");
              _jspx_th_impact_ButtonTag_4.setImg("btnDelete");
              _jspx_th_impact_ButtonTag_4.setForm("frmExchangeChildDetail");
              _jspx_th_impact_ButtonTag_4.setAction("/person/ExchangeChildDetail/deleteHasConsidered");
              _jspx_th_impact_ButtonTag_4.setRestrictRepost(true);
              _jspx_th_impact_ButtonTag_4.setPreventDoubleClick(true);
              _jspx_th_impact_ButtonTag_4.setFunction("return confirmDelete();");
              _jspx_th_impact_ButtonTag_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
              if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setName("StsOfPrntlRights");
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Status Of Parental Rights");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_3.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tMother\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_22.setName("dspMotherDOB");
              _jspx_th_impact_validateDisplayOnlyField_22.setLabel("Date of Birth");
              _jspx_th_impact_validateDisplayOnlyField_22.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthMother()));
              int _jspx_eval_impact_validateDisplayOnlyField_22 = _jspx_th_impact_validateDisplayOnlyField_22.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_23.setName("dspMotherDOD");
              _jspx_th_impact_validateDisplayOnlyField_23.setLabel("Date of Death");
              _jspx_th_impact_validateDisplayOnlyField_23.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthMother()));
              int _jspx_eval_impact_validateDisplayOnlyField_23 = _jspx_th_impact_validateDisplayOnlyField_23.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_24.setName("dspMotherRace");
              _jspx_th_impact_validateDisplayOnlyField_24.setLabel("Race");
              _jspx_th_impact_validateDisplayOnlyField_24.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtMotherRace()));
              int _jspx_eval_impact_validateDisplayOnlyField_24 = _jspx_th_impact_validateDisplayOnlyField_24.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_25.setName("dspMotherEthnicity");
              _jspx_th_impact_validateDisplayOnlyField_25.setLabel("Ethnicity");
              _jspx_th_impact_validateDisplayOnlyField_25.setValue(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtMthEthnicity()));
              int _jspx_eval_impact_validateDisplayOnlyField_25 = _jspx_th_impact_validateDisplayOnlyField_25.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_26.setName("dspDtTprMother");
              _jspx_th_impact_validateDisplayOnlyField_26.setLabel("TPR Date");
              _jspx_th_impact_validateDisplayOnlyField_26.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprMother()));
              int _jspx_eval_impact_validateDisplayOnlyField_26 = _jspx_th_impact_validateDisplayOnlyField_26.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_27.setName("dspTprCodeMother");
              _jspx_th_impact_validateDisplayOnlyField_27.setLabel("TPR Code");
              _jspx_th_impact_validateDisplayOnlyField_27.setValue(Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodeMother()));
              int _jspx_eval_impact_validateDisplayOnlyField_27 = _jspx_th_impact_validateDisplayOnlyField_27.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_28.setName("dspDtTermFiled");
              _jspx_th_impact_validateDisplayOnlyField_28.setLabel("Date TPR Order Filed");
              _jspx_th_impact_validateDisplayOnlyField_28.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledMoth()));
              int _jspx_eval_impact_validateDisplayOnlyField_28 = _jspx_th_impact_validateDisplayOnlyField_28.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_29.setName("dspIndMothMarr");
              _jspx_th_impact_validateDisplayOnlyField_29.setLabel("Mother married at time of child's birth");
              _jspx_th_impact_validateDisplayOnlyField_29.setValue(Lookup.simpleDecodeSafe(CodesTables.CMOTHMAR, exchangeChildDetailRetSO.getIndMothMarried()));
              int _jspx_eval_impact_validateDisplayOnlyField_29 = _jspx_th_impact_validateDisplayOnlyField_29.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tBiological Father\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_30.setName("dspBioFatherDOB");
              _jspx_th_impact_validateDisplayOnlyField_30.setLabel("Date of Birth");
              _jspx_th_impact_validateDisplayOnlyField_30.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthBioFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_30 = _jspx_th_impact_validateDisplayOnlyField_30.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_31.setName("dspBioFatherDOD");
              _jspx_th_impact_validateDisplayOnlyField_31.setLabel("Date of Death");
              _jspx_th_impact_validateDisplayOnlyField_31.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthBioFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_31 = _jspx_th_impact_validateDisplayOnlyField_31.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_32.setName("dspBioFatherRace");
              _jspx_th_impact_validateDisplayOnlyField_32.setLabel("Race");
              _jspx_th_impact_validateDisplayOnlyField_32.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtBioFthRace()));
              int _jspx_eval_impact_validateDisplayOnlyField_32 = _jspx_th_impact_validateDisplayOnlyField_32.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_33.setName("dspBioFatherEthnicity");
              _jspx_th_impact_validateDisplayOnlyField_33.setLabel("Ethnicity");
              _jspx_th_impact_validateDisplayOnlyField_33.setValue(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtBioFthEthnicity()));
              int _jspx_eval_impact_validateDisplayOnlyField_33 = _jspx_th_impact_validateDisplayOnlyField_33.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_34.setName("dspDtBioFatherTpr");
              _jspx_th_impact_validateDisplayOnlyField_34.setLabel("TPR Date");
              _jspx_th_impact_validateDisplayOnlyField_34.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprBioFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_34 = _jspx_th_impact_validateDisplayOnlyField_34.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_35.setName("dspBioFatherTprCode");
              _jspx_th_impact_validateDisplayOnlyField_35.setLabel("TPR Code");
              _jspx_th_impact_validateDisplayOnlyField_35.setValue(Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodeBioFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_35 = _jspx_th_impact_validateDisplayOnlyField_35.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t");

							  String indBioLegFather = "";
							      if (ArchitectureConstants.Y.equals(exchangeChildDetailRetSO.getIndBioFthIsLegFth())) {
							        indBioLegFather = ArchitectureConstants.YES;
							      }
							
              out.write("\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_36.setName("dspDtTermFiledBioFath");
              _jspx_th_impact_validateDisplayOnlyField_36.setLabel("Date TPR Order Filed");
              _jspx_th_impact_validateDisplayOnlyField_36.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledBioFath()));
              int _jspx_eval_impact_validateDisplayOnlyField_36 = _jspx_th_impact_validateDisplayOnlyField_36.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_37.setName("dspIndBioLeg");
              _jspx_th_impact_validateDisplayOnlyField_37.setLabel("Biological Father is Legal Father");
              _jspx_th_impact_validateDisplayOnlyField_37.setValue(indBioLegFather);
              int _jspx_eval_impact_validateDisplayOnlyField_37 = _jspx_th_impact_validateDisplayOnlyField_37.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tLegal Father\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_38.setName("dspLegFatherDOB");
              _jspx_th_impact_validateDisplayOnlyField_38.setLabel("Date of Birth");
              _jspx_th_impact_validateDisplayOnlyField_38.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthLegFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_38 = _jspx_th_impact_validateDisplayOnlyField_38.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_39.setName("dspLegFatherDOD");
              _jspx_th_impact_validateDisplayOnlyField_39.setLabel("Date of Death");
              _jspx_th_impact_validateDisplayOnlyField_39.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthLegFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_39 = _jspx_th_impact_validateDisplayOnlyField_39.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_40.setName("dspLegFatherRace");
              _jspx_th_impact_validateDisplayOnlyField_40.setLabel("Race");
              _jspx_th_impact_validateDisplayOnlyField_40.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtLegFthRace()));
              int _jspx_eval_impact_validateDisplayOnlyField_40 = _jspx_th_impact_validateDisplayOnlyField_40.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_41.setName("dspLegFatherEthnicity");
              _jspx_th_impact_validateDisplayOnlyField_41.setLabel("Ethnicity");
              _jspx_th_impact_validateDisplayOnlyField_41.setValue(Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtLegFthEthnicity()));
              int _jspx_eval_impact_validateDisplayOnlyField_41 = _jspx_th_impact_validateDisplayOnlyField_41.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_42.setName("dspDtLegFatherTpr");
              _jspx_th_impact_validateDisplayOnlyField_42.setLabel("TPR Date");
              _jspx_th_impact_validateDisplayOnlyField_42.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprLegFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_42 = _jspx_th_impact_validateDisplayOnlyField_42.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_43.setName("dspLegFatherTprCode");
              _jspx_th_impact_validateDisplayOnlyField_43.setLabel("TPR Code");
              _jspx_th_impact_validateDisplayOnlyField_43.setValue(Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodeLegFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_43 = _jspx_th_impact_validateDisplayOnlyField_43.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_44.setName("dspDtTermFiledLegFath");
              _jspx_th_impact_validateDisplayOnlyField_44.setLabel("Date TPR Order Filed");
              _jspx_th_impact_validateDisplayOnlyField_44.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledLegFath()));
              int _jspx_eval_impact_validateDisplayOnlyField_44 = _jspx_th_impact_validateDisplayOnlyField_44.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"6\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<th>\r\n\t\t\t\t\tPutative Father\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_45.setName("dspLegFatherDOB");
              _jspx_th_impact_validateDisplayOnlyField_45.setLabel("Date of Birth");
              _jspx_th_impact_validateDisplayOnlyField_45.setValue(multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtBthPutFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_45 = _jspx_th_impact_validateDisplayOnlyField_45.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_46.setName("dspLegFatherDOD");
              _jspx_th_impact_validateDisplayOnlyField_46.setLabel("Date of Death");
              _jspx_th_impact_validateDisplayOnlyField_46.setValue(multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDthPutFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_46 = _jspx_th_impact_validateDisplayOnlyField_46.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_47.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_47.setName("dspLegFatherRace");
              _jspx_th_impact_validateDisplayOnlyField_47.setLabel("Race");
              _jspx_th_impact_validateDisplayOnlyField_47.setValue(multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : FormattingHelper.formatString(exchangeChildDetailRetSO.getTxtPutFthRace()));
              int _jspx_eval_impact_validateDisplayOnlyField_47 = _jspx_th_impact_validateDisplayOnlyField_47.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_48.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_48.setName("dspLegFatherEthnicity");
              _jspx_th_impact_validateDisplayOnlyField_48.setLabel("Ethnicity");
              _jspx_th_impact_validateDisplayOnlyField_48.setValue(multiPutativePather ? ExchangeChildDetailConversation.MULTI_PUTATIVE_FATHER : Lookup.simpleDecodeSafe(CodesTables.CINDETHN, exchangeChildDetailRetSO.getTxtPutFthEthnicity()));
              int _jspx_eval_impact_validateDisplayOnlyField_48 = _jspx_th_impact_validateDisplayOnlyField_48.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_49.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_49.setName("dspDtLegFatherTpr");
              _jspx_th_impact_validateDisplayOnlyField_49.setLabel("TPR Date");
              _jspx_th_impact_validateDisplayOnlyField_49.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtTprPutFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_49 = _jspx_th_impact_validateDisplayOnlyField_49.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_50.setName("dspLegFatherTprCode");
              _jspx_th_impact_validateDisplayOnlyField_50.setLabel("TPR Code");
              _jspx_th_impact_validateDisplayOnlyField_50.setValue(Lookup.simpleDecodeSafe(CodesTables.CTPRCODE, exchangeChildDetailRetSO.getCdTprCodePutFather()));
              int _jspx_eval_impact_validateDisplayOnlyField_50 = _jspx_th_impact_validateDisplayOnlyField_50.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_51.setName("dspDtTermFiledLegFath");
              _jspx_th_impact_validateDisplayOnlyField_51.setLabel("Date TPR Order Filed");
              _jspx_th_impact_validateDisplayOnlyField_51.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtOrdTermFiledPutFath()));
              int _jspx_eval_impact_validateDisplayOnlyField_51 = _jspx_th_impact_validateDisplayOnlyField_51.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"6\"></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setName("RecActivities");
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Recruitment Activities");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_4.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE5\">\r\n\t\t\t");
 // MR-083 Added new question and cleaned up code 
              out.write("\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\tActively Recruiting?\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_23.setType("radio");
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setName("rbStateActRecruiting");
              _jspx_th_impact_validateInput_23.setLabel("Yes");
              _jspx_th_impact_validateInput_23.setValue("Y");
              _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_23.setChecked( String.valueOf(CodesTables.CYESNONA_Y.equals(cdStateActivelyRecruiting)) );
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setType("radio");
              _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_24.setName("rbStateActRecruiting");
              _jspx_th_impact_validateInput_24.setLabel("No");
              _jspx_th_impact_validateInput_24.setValue("N");
              _jspx_th_impact_validateInput_24.setChecked( String.valueOf(CodesTables.CYESNONA_N.equals(cdStateActivelyRecruiting)) );
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setType("radio");
              _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_25.setName("rbStateActRecruiting");
              _jspx_th_impact_validateInput_25.setLabel("N/A");
              _jspx_th_impact_validateInput_25.setValue("A");
              _jspx_th_impact_validateInput_25.setChecked( String.valueOf(CodesTables.CYESNONA_A.equals(cdStateActivelyRecruiting) || cdStateActivelyRecruiting == null) );
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"5\"></td>\r\n\t\t\t</tr>\r\n\t\t\t");

              int iLoopCounter = 0;
              
			  for (int i = 0; i < activityCodesList.size(); ++i) {
			        CodeAttributes att = (CodeAttributes) activityCodesList.get(i);
                    
			        List<ExcChildAdoInfoCbxStruct> recActDatesToDisplay = null;
			        
			        if(savedRecActivitiesDatesState != null){
			         recActDatesToDisplay = savedRecActivitiesDatesState.get(att.getCode());
			        }

			        int sizeOfDateList = 0;

			        if (recActDatesToDisplay != null) {
			          sizeOfDateList = recActDatesToDisplay.size();
			        }
			
              out.write("\r\n\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(iLoopCounter));
              out.write("\">\r\n\t\t\t\t<td width=\"25%\" colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_3.setLabel(att.getDecode());
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setValue("");
              _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_3.setName("dtRecActState" + att.getCode());
              _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_3.setCssClass("formInput");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_26.setConstraint("Date");
              _jspx_th_impact_validateInput_26.setType("text");
              _jspx_th_impact_validateInput_26.setName("Date0_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setSize("8");
              _jspx_th_impact_validateInput_26.setValue(((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(0).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_27.setType("hidden");
              _jspx_th_impact_validateInput_27.setName("Date0_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_27.setValue( ((sizeOfDateList > 0)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(0).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_28.setConstraint("Date");
              _jspx_th_impact_validateInput_28.setType("text");
              _jspx_th_impact_validateInput_28.setName("Date1_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setSize("8");
              _jspx_th_impact_validateInput_28.setValue(((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(1).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_29.setType("hidden");
              _jspx_th_impact_validateInput_29.setName("Date1_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_29.setValue( ((sizeOfDateList > 1)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(1).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_30.setConstraint("Date");
              _jspx_th_impact_validateInput_30.setType("text");
              _jspx_th_impact_validateInput_30.setName("Date2_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setSize("8");
              _jspx_th_impact_validateInput_30.setValue(((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(2).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_31.setType("hidden");
              _jspx_th_impact_validateInput_31.setName("Date2_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_31.setValue( ((sizeOfDateList > 2)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(2).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_32.setConstraint("Date");
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setName("Date3_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setSize("8");
              _jspx_th_impact_validateInput_32.setValue(((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(3).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_33.setType("hidden");
              _jspx_th_impact_validateInput_33.setName("Date3_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_33.setValue( ((sizeOfDateList > 3)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(3).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_34.setConstraint("Date");
              _jspx_th_impact_validateInput_34.setType("text");
              _jspx_th_impact_validateInput_34.setName("Date4_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setSize("8");
              _jspx_th_impact_validateInput_34.setValue(((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(4).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_35.setType("hidden");
              _jspx_th_impact_validateInput_35.setName("Date4_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_35.setValue( ((sizeOfDateList > 4)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(4).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(iLoopCounter++));
              out.write("\">\r\n\t\t\t\t<td colspan=\"3\"></td>\r\n\t\t\t\t<td>\r\n\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_36.setConstraint("Date");
              _jspx_th_impact_validateInput_36.setType("text");
              _jspx_th_impact_validateInput_36.setName("Date5_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              _jspx_th_impact_validateInput_36.setSize("8");
              _jspx_th_impact_validateInput_36.setValue(((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(5).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_37.setType("hidden");
              _jspx_th_impact_validateInput_37.setName("Date5_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_37.setValue( ((sizeOfDateList > 5)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(5).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_38.setConstraint("Date");
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setName("Date6_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_38.setCssClass("formInput");
              _jspx_th_impact_validateInput_38.setSize("8");
              _jspx_th_impact_validateInput_38.setValue(((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(6).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_39.setType("hidden");
              _jspx_th_impact_validateInput_39.setName("Date6_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_39.setValue( ((sizeOfDateList > 6)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(6).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
              if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_40.setConstraint("Date");
              _jspx_th_impact_validateInput_40.setType("text");
              _jspx_th_impact_validateInput_40.setName("Date7_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_40.setCssClass("formInput");
              _jspx_th_impact_validateInput_40.setSize("8");
              _jspx_th_impact_validateInput_40.setValue(((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(7).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
              if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_41.setType("hidden");
              _jspx_th_impact_validateInput_41.setName("Date7_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_41.setValue( ((sizeOfDateList > 7)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(7).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
              if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_42.setConstraint("Date");
              _jspx_th_impact_validateInput_42.setType("text");
              _jspx_th_impact_validateInput_42.setName("Date8_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_42.setCssClass("formInput");
              _jspx_th_impact_validateInput_42.setSize("8");
              _jspx_th_impact_validateInput_42.setValue(((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(8).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
              if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_43.setType("hidden");
              _jspx_th_impact_validateInput_43.setName("Date8_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_43.setValue( ((sizeOfDateList > 8)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(8).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
              if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_44.setConstraint("Date");
              _jspx_th_impact_validateInput_44.setType("text");
              _jspx_th_impact_validateInput_44.setName("Date9_dtRecActState" + att.getCode());
              _jspx_th_impact_validateInput_44.setCssClass("formInput");
              _jspx_th_impact_validateInput_44.setSize("8");
              _jspx_th_impact_validateInput_44.setValue(((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatDate((Date) recActDatesToDisplay
                                                                                                     .get(9).getDtPerformed()) : "");
              _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
              if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateInput_45.setType("hidden");
              _jspx_th_impact_validateInput_45.setName("Date9_idInfoChar" + att.getCode());
              _jspx_th_impact_validateInput_45.setValue( ((sizeOfDateList > 9)) ? FormattingHelper
                                                                    .formatInt(recActDatesToDisplay.get(9).getIdInfoChar()) : "0");
              int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
              if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\t\t\t");

			  }
			
              out.write("\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE2\">\r\n\t\t\t<tr class=\"subdetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_3.setLabel("Comments");
              _jspx_th_impact_validateTextArea_3.setName("txtRecActCmnts");
              _jspx_th_impact_validateTextArea_3.setRows("4");
              _jspx_th_impact_validateTextArea_3.setCols("77");
              _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_3.setMaxLength(1000);
              _jspx_th_impact_validateTextArea_3.setDisabled("false");
              _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph1000");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(excChildStruct.getTxtRecCmnts()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\t<br>\r\n\t");
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_5.setName("closeRecords");
          _jspx_th_impact_ExpandableSectionTag_5.setLabel("Close Records");
          _jspx_th_impact_ExpandableSectionTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_5 = _jspx_th_impact_ExpandableSectionTag_5.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tClosed No Placement\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDate_4.setLabel("Date");
              _jspx_th_impact_validateDate_4.setName("txtDtClosedNP");
              _jspx_th_impact_validateDate_4.setType("text");
              _jspx_th_impact_validateDate_4.setValue(FormattingHelper.formatDate(excChildStruct.getDtClose()));
              _jspx_th_impact_validateDate_4.setSize("10");
              _jspx_th_impact_validateDate_4.setConditionallyRequired("false");
              _jspx_th_impact_validateDate_4.setDisabled("false");
              _jspx_th_impact_validateDate_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateSelect_8.setName("szCdRsnClosed");
              _jspx_th_impact_validateSelect_8.setLabel("Reason Closed");
              _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_8.setCodesTable("CADEXCLD");
              _jspx_th_impact_validateSelect_8.setValue(FormattingHelper.formatString(excChildStruct.getCdRsnClosed()));
              int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
              if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateTextArea_4.setName("txtExplNpCmnts");
              _jspx_th_impact_validateTextArea_4.setColspan("4");
              _jspx_th_impact_validateTextArea_4.setLabel("Explanation");
              _jspx_th_impact_validateTextArea_4.setRows("4");
              _jspx_th_impact_validateTextArea_4.setCols("110");
              _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_4.setDisabled("false");
              _jspx_th_impact_validateTextArea_4.setMaxLength(500);
              _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(excChildStruct.getTxtExplNoPlcmt()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\t\twidth=\"100%\" id=\"TABLE14\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tClosed With Placement\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_52.setName("txtRsrcChildPlcd");
              _jspx_th_impact_validateDisplayOnlyField_52.setLabel("Family With Whom Child is Placed");
              _jspx_th_impact_validateDisplayOnlyField_52.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getNmPlcmtRsrc()));
              int _jspx_eval_impact_validateDisplayOnlyField_52 = _jspx_th_impact_validateDisplayOnlyField_52.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_53.setName("txtNmPrvtAgency");
              _jspx_th_impact_validateDisplayOnlyField_53.setLabel("Private Agency Name");
              _jspx_th_impact_validateDisplayOnlyField_53.setValue(FormattingHelper.formatString(exchangeChildDetailRetSO.getNmPrvtAgency()));
              int _jspx_eval_impact_validateDisplayOnlyField_53 = _jspx_th_impact_validateDisplayOnlyField_53.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_54.setName("txtDatePlacedCWP");
              _jspx_th_impact_validateDisplayOnlyField_54.setLabel("Date Placed");
              _jspx_th_impact_validateDisplayOnlyField_54.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtPlaced()));
              int _jspx_eval_impact_validateDisplayOnlyField_54 = _jspx_th_impact_validateDisplayOnlyField_54.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_55.setName("dtPermissionToFileCWP");
              _jspx_th_impact_validateDisplayOnlyField_55.setLabel("Permission To File");
              _jspx_th_impact_validateDisplayOnlyField_55.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtPermToFile()));
              int _jspx_eval_impact_validateDisplayOnlyField_55 = _jspx_th_impact_validateDisplayOnlyField_55.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_56.setName("dtDocSendCWP");
              _jspx_th_impact_validateDisplayOnlyField_56.setLabel("Documents Sent Date");
              _jspx_th_impact_validateDisplayOnlyField_56.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDocSent()));
              int _jspx_eval_impact_validateDisplayOnlyField_56 = _jspx_th_impact_validateDisplayOnlyField_56.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_57.setName("txtCountyCWP");
              _jspx_th_impact_validateDisplayOnlyField_57.setLabel("County");
              _jspx_th_impact_validateDisplayOnlyField_57.setValue(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, exchangeChildDetailRetSO.getLegStatCnty()));
              int _jspx_eval_impact_validateDisplayOnlyField_57 = _jspx_th_impact_validateDisplayOnlyField_57.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateInput_46.setType("text");
              _jspx_th_impact_validateInput_46.setName("txtAFileNumCWP");
              _jspx_th_impact_validateInput_46.setLabel("A-file #");
              _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_46.setMaxLength("16");
              _jspx_th_impact_validateInput_46.setSize("16");
              _jspx_th_impact_validateInput_46.setValue(FormattingHelper.formatString(excChildStruct.getNbrAfile()));
              int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
              if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_58.setName("txtDtFinalCWP");
              _jspx_th_impact_validateDisplayOnlyField_58.setLabel("Date Final");
              _jspx_th_impact_validateDisplayOnlyField_58.setValue(FormattingHelper.formatDate(excChildStruct.getDtFinal()));
              int _jspx_eval_impact_validateDisplayOnlyField_58 = _jspx_th_impact_validateDisplayOnlyField_58.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_59.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_59.setName("txtDtFinalEnteredCWP");
              _jspx_th_impact_validateDisplayOnlyField_59.setLabel("Date Final Entered");
              _jspx_th_impact_validateDisplayOnlyField_59.setValue(FormattingHelper.formatDate(excChildStruct.getDtFnEntered()));
              int _jspx_eval_impact_validateDisplayOnlyField_59 = _jspx_th_impact_validateDisplayOnlyField_59.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_60.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDisplayOnlyField_60.setName("dtDisruptionCWP");
              _jspx_th_impact_validateDisplayOnlyField_60.setLabel("Disruption");
              _jspx_th_impact_validateDisplayOnlyField_60.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getDtDisruption()));
              int _jspx_eval_impact_validateDisplayOnlyField_60 = _jspx_th_impact_validateDisplayOnlyField_60.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateDate_5.setName("dtDissolutionCWP");
              _jspx_th_impact_validateDate_5.setLabel("Dissolution");
              _jspx_th_impact_validateDate_5.setType("text");
              _jspx_th_impact_validateDate_5.setConstraint("Date");
              _jspx_th_impact_validateDate_5.setSize("10");
              _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_5.setValue(FormattingHelper.formatDate(exchangeChildDetailRetSO.getExchangeChildStruct()
                                                                          .getDtDissolutionCWP()));
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_5);
              _jspx_th_impact_validateTextArea_5.setName("txtChPlcWithCmnts");
              _jspx_th_impact_validateTextArea_5.setColspan("4");
              _jspx_th_impact_validateTextArea_5.setLabel("Children Placed with");
              _jspx_th_impact_validateTextArea_5.setRows("4");
              _jspx_th_impact_validateTextArea_5.setCols("110");
              _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_5.setDisabled("false");
              _jspx_th_impact_validateTextArea_5.setMaxLength(500);
              _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
              int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
              if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_5.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(excChildStruct.getTxtChPlcdWith()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write("\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\twidth=\"100%\" id=\"TABLE2\">\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t");

			  if (!PageModeConstants.VIEW.equals(pageMode)) {
			
          out.write("\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSave");
          _jspx_th_impact_ButtonTag_5.setAlign("right");
          _jspx_th_impact_ButtonTag_5.setImg("btnSave");
          _jspx_th_impact_ButtonTag_5.setForm("frmExchangeChildDetail");
          _jspx_th_impact_ButtonTag_5.setAction("/person/ExchangeChildDetail/saveExchangeChildDetail");
          _jspx_th_impact_ButtonTag_5.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_5.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");

			  }
			
          out.write("\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmExchangeChildDetail");
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
    _jspx_th_impact_validateInput_0.setName("hdnIdHomeEvent");
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
    _jspx_th_impact_validateInput_1.setName("hdnIdChildEvent");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnIdStage");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnIdResource");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnIdHomeName");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
