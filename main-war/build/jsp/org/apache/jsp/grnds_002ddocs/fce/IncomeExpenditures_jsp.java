package org.apache.jsp.grnds_002ddocs.fce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.IncomeExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;
import gov.georgia.dhr.dfcs.sacwis.web.fce.IncomeExpendituresConversation;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;

public final class IncomeExpenditures_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/fce/IncomeListSub.jsp");
    _jspx_dependants.add("/grnds-docs/fce/ResourceListSub.jsp");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
String pageMode = PageMode.getPageMode(request);
UserProfile user = UserProfileHelper.getUserProfile(request);
String fceApplicationPageMode = (String)
    request.getAttribute(IncomeExpendituresConversation.FCE_APPLICATION_PAGE_MODE);

      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      IncomeExpendituresDB incomeExpendituresDB = (IncomeExpendituresDB) state
                                                                              .getAttribute(
                                                                                            IncomeExpendituresConversation.INCOME_EXPENDITURES_DB_KEY,
                                                                                            request);
      List<Option> aUMembersOptionsList = (List<Option>) state.getAttribute("aUMembersOptionsList", request);
      List<Option> nonAUMembersOptionsList = (List<Option>) state.getAttribute("nonAUMembersOptionsList", request);                                                                                             

      int tabIndex = 1;
      int loopCount = 0;
      String radioWidth = "7%";
      boolean indSSIForChild = false;

      out.write("\r\n\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction showDhsWorkerNotified()\r\n{\r\n  var workerNotified = document.getElementById( \"dhsWorkerNotified\" );\r\n  workerNotified.style.display = 'block';\r\n}\r\n\r\nfunction hideDhsWorkerNotified()\r\n{\r\n  var x = document.frmIncomeExpenditures;\r\n  var workerNotified = document.getElementById( \"dhsWorkerNotified\" );\r\n  workerNotified.style.display = 'none';\r\n  x.");
      out.print( IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER );
      out.write("[0].checked = false;\r\n  x.");
      out.print( IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER );
      out.write("[1].checked = true;\r\n  x.");
      out.print(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST);
      out.write(".value = '';\r\n  x.");
      out.print(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_MIDDLE);
      out.write(".value = '';\r\n  x.");
      out.print(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST);
      out.write(".value = '';\r\n  x.");
      out.print( IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN );
      out.write(".value = '';\r\n  x.");
      out.print(IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING);
      out.write(".value = '';\r\n}\r\n\r\nfunction showCostCareExceedSection()\r\n{\r\n  var childCostCareExceed = document.getElementById( \"costCareExceed\" );\r\n  childCostCareExceed.style.display = 'block';\r\n}\r\n\r\nfunction hideCostCareExceedSection()\r\n{\r\n  var x = document.frmIncomeExpenditures;\r\n  var childCostCareExceed = document.getElementById( \"costCareExceed\" );\r\n  childCostCareExceed.style.display = 'none';\r\n}\r\n\r\nfunction setupAllocationSection()\r\n{\r\n  // Display the correct rows and blank out the selected/entered data in the \r\n  // related fields based on the Allocation Type\r\n  var x = document.frmIncomeExpenditures;\r\n  var allocType = '';\r\n");

if ((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus())))) {

      out.write(" \r\n  allocType = x.");
      out.print(IncomeExpendituresDB.CD_ALLOC_TYPE);
      out.write(".value;\r\n");

} else {

      out.write("\r\n  allocType = x.");
      out.print(IncomeExpendituresDB.CD_ALLOC_TYPE);
      out.write('[');
      out.write('x');
      out.write('.');
      out.print(IncomeExpendituresDB.CD_ALLOC_TYPE);
      out.write(".selectedIndex].value;\r\n");

}

      out.write("\r\n  var allocSingleMultiple = document.getElementById( \"allocSingleMultiple\" );\r\n  var allocMutual = document.getElementById( \"allocMutual\" );\r\n  var allocMultiple = document.getElementById( \"allocMultiple\" );\r\n \r\n  // Single Parent Allocation\r\n  if ('SGLP' == allocType) {       \r\n    allocSingleMultiple.style.display = 'block';\r\n    allocMutual.style.display = 'none';\r\n    allocMultiple.style.display = 'none';  \r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2);
      out.write(".value = '';\r\n  } \r\n  // Mutual Parents Allocation\r\n  else if ('MUTP' == allocType) {\r\n    allocSingleMultiple.style.display = 'none';\r\n    allocMutual.style.display = 'block';\r\n    allocMultiple.style.display = 'none';  \r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2);
      out.write(".value = '';\r\n  }\r\n  // Multiple Parents Allocation\r\n  else if ('MULP' == allocType) {\r\n    allocSingleMultiple.style.display = 'block';\r\n    allocMutual.style.display = 'none';\r\n    allocMultiple.style.display = 'block';  \r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL);
      out.write(".value = '';\r\n  } \r\n  // Mutual Parents and Single Parent Allocation\r\n  else if ('MSGL' == allocType) {\r\n    allocSingleMultiple.style.display = 'block';\r\n    allocMutual.style.display = 'block';\r\n    allocMultiple.style.display = 'none';  \r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2);
      out.write(".value = '';\r\n  }\r\n  // Mutual Parents and Multiple Parents Allocation\r\n  else if ('MMUL' == allocType) {\r\n    allocSingleMultiple.style.display = 'block';\r\n    allocMutual.style.display = 'block';\r\n    allocMultiple.style.display = 'block';  \r\n  } \r\n  // No selection has been made. Blank/hide all of the fields\r\n  else {\r\n    allocSingleMultiple.style.display = 'none';\r\n    allocMutual.style.display = 'none';\r\n    allocMultiple.style.display = 'none'; \r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2);
      out.write(".value = '';\r\n  }\r\n}\r\n\r\nfunction setupDeemingSection()\r\n{\r\n  var x = document.frmIncomeExpenditures;\r\n  var deemType = '';\r\n  ");

if ((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus())))) {

      out.write(" \r\n  deemType = x.");
      out.print(IncomeExpendituresDB.CD_DEEM_RESP_TYPE);
      out.write(".value;\r\n");

} else {

      out.write("\r\n  deemType = x.");
      out.print(IncomeExpendituresDB.CD_DEEM_RESP_TYPE);
      out.write('[');
      out.write('x');
      out.write('.');
      out.print(IncomeExpendituresDB.CD_DEEM_RESP_TYPE);
      out.write(".selectedIndex].value;\r\n");

}

      out.write("\r\n  var deemIndiv1Label = document.getElementById( \"deemIndiv1Label\" );\r\n  var deemIndiv1 = document.getElementById( \"deemIndiv1\" );\r\n  var deemIndiv2Label = document.getElementById( \"deemIndiv2Label\" );\r\n  var deemIndiv2 = document.getElementById( \"deemIndiv2\" );\r\n  var rowNbrDeemChildNotInAU = document.getElementById( \"rowNbrDeemChildNotInAU\" );\r\n  var rowNbrDeemTaxDependNotInAU = document.getElementById( \"rowNbrDeemTaxDependNotInAU\" );\r\n  var rowNbrDeemResponseIndiv = document.getElementById( \"rowNbrDeemResponseIndiv\" );\r\n  var rowAmtDeemTaxDependOutHh = document.getElementById( \"rowAmtDeemTaxDependOutHh\" );\r\n  var rowAmtDeemAlimonyOutsideHh = document.getElementById( \"rowAmtDeemAlimonyOutsideHh\" );\r\n\r\n    // One Responsible Individual deeming. Hide the second person responsible for deeming \r\n    // and blank out the selected/entered data in the related fields\r\n  if ('ONE' == deemType) {\r\n    deemIndiv1Label.style.display = 'block';\r\n    deemIndiv1.style.display = 'block';   \r\n    deemIndiv2Label.style.display = 'none';\r\n");
      out.write("    deemIndiv2.style.display = 'none';\r\n    rowNbrDeemChildNotInAU.style.display = 'block';  \r\n    rowNbrDeemTaxDependNotInAU.style.display = 'block';  \r\n    rowNbrDeemResponseIndiv.style.display = 'block';  \r\n    rowAmtDeemTaxDependOutHh.style.display = 'block';  \r\n    rowAmtDeemAlimonyOutsideHh.style.display = 'block';  \r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.CD_DEEM_INDIV_REL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV);
      out.write(".value = '1';\r\n  } \r\n  // Two Responsible Individuals deeming. Show the second person responsible for deeming \r\n    // and the related fields\r\n  else if ('TWO' == deemType) {\r\n    deemIndiv1Label.style.display = 'block';\r\n    deemIndiv1.style.display = 'block';   \r\n    deemIndiv2Label.style.display = 'block';\r\n    deemIndiv2.style.display = 'block';\r\n    rowNbrDeemChildNotInAU.style.display = 'block';  \r\n    rowNbrDeemTaxDependNotInAU.style.display = 'block';  \r\n    rowNbrDeemResponseIndiv.style.display = 'block';  \r\n    rowAmtDeemTaxDependOutHh.style.display = 'block';  \r\n    rowAmtDeemAlimonyOutsideHh.style.display = 'block';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV);
      out.write(".value = '2';  \r\n  }\r\n  // No selection is made. Hide both persons responsible for deeming \r\n  // and blank out the selected/entered data in all of the fields\r\n  else {\r\n    deemIndiv1Label.style.display = 'none';\r\n    deemIndiv1.style.display = 'none';   \r\n    deemIndiv2Label.style.display = 'none';        \r\n    deemIndiv2.style.display = 'none';\r\n    rowNbrDeemChildNotInAU.style.display = 'none';\r\n    rowNbrDeemTaxDependNotInAU.style.display = 'none';\r\n    rowNbrDeemResponseIndiv.style.display = 'none';\r\n    rowAmtDeemTaxDependOutHh.style.display = 'none';\r\n    rowAmtDeemAlimonyOutsideHh.style.display = 'none';\r\n    x.");
      out.print(IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.CD_DEEM_INDIV_REL_2);
      out.write(".selectedIndex = 0;\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_DEEM_CHILD_NOT_IN_AU);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_DEEM_TAX_DEPEND_NOT_IN_AU);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.AMT_DEEM_TAX_DEPEND_OUT_HH);
      out.write(".value = '';\r\n    x.");
      out.print(IncomeExpendituresDB.AMT_DEEM_ALIMONY_OUTSIDE_HH);
      out.write(".value = '';\r\n  }\r\n}\r\n\r\nfunction emptyQuestions()\r\n{\r\n  var x = document.frmIncomeExpenditures;\r\n  x.");
      out.print(IncomeExpendituresDB.IND_OUT_HOME_CARE);
      out.write(".value = '';\r\n  x.");
      out.print(IncomeExpendituresDB.IND_EMANCIPATION);
      out.write(".value = '';\r\n  x.");
      out.print(IncomeExpendituresDB.IND_ADOPTION);
      out.write(".value = '';\r\n}\r\n\r\nfunction navigateToPersonDetail(idPerson)\r\n{\r\n  setIsDirtyCalled(true);\r\n  frmIncomeExpenditures.");
      out.print(IncomeExpendituresConversation.ID_PERSON_SELECTED);
      out.write(".value = idPerson;\r\n  disableValidation('frmIncomeExpenditures');\r\n  submitValidateForm('frmIncomeExpenditures', '");
      out.print(IncomeExpendituresConversation.DISPLAY_PERSON_DETAIL_COMMAND);
      out.write("');\r\n  return false;\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmIncomeExpenditures");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fce.IncomeExpendituresCustomValidation");
      _jspx_th_impact_validateForm_0.setAction("/fce/IncomeExpenditures/displayIncomeExpenditures");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setOnSubmit("if (this.submitted) return false; this.submitted = true; return true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(IncomeExpendituresConversation.ID_PERSON_SELECTED);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th>\r\n        Received Income Assistance at Time of Removal\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        Removal Date: <b>");
          out.print(incomeExpendituresDB.getDtRemovalDateString());
          out.write("</b>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n          <tr>\r\n            <td width=\"");
          out.print( radioWidth );
          out.write("\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setLabel("Yes");
          _jspx_th_impact_validateInput_1.setName(IncomeExpendituresDB.IND_INCOME_ASSISTANCE);
          _jspx_th_impact_validateInput_1.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setOnClick("showDhsWorkerNotified()");
          _jspx_th_impact_validateInput_1.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndIncomeAssistanceString()) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td width=\"");
          out.print( radioWidth );
          out.write("\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setLabel("No");
          _jspx_th_impact_validateInput_2.setOnClick("hideDhsWorkerNotified()");
          _jspx_th_impact_validateInput_2.setName(IncomeExpendituresDB.IND_INCOME_ASSISTANCE);
          _jspx_th_impact_validateInput_2.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setChecked( "" +
       ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndIncomeAssistanceString()) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n            <td>\r\n              Did the child receive Income Assistance during that month? (TANF, Food Stamps, Medicaid)\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        <div id=\"dhsWorkerNotified\" style=\"display:none\">\r\n          <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n            <tr>\r\n              <td width=\"");
          out.print( radioWidth );
          out.write("\">\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setLabel("Yes");
          _jspx_th_impact_validateInput_3.setName( IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER );
          _jspx_th_impact_validateInput_3.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setOnClick("javascript:expandCollapsed('expandednotifiedInformation', 'collapsednotifiedInformation');");
          _jspx_th_impact_validateInput_3.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndNotifiedDhsWorkerString()) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              <td width=\"");
          out.print( radioWidth );
          out.write("\">\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setLabel("No");
          _jspx_th_impact_validateInput_4.setName(IncomeExpendituresDB.IND_NOTIFIED_DHS_WORKER);
          _jspx_th_impact_validateInput_4.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setOnClick("javascript:collapseExpanded('expandednotifiedInformation', 'collapsednotifiedInformation');");
          _jspx_th_impact_validateInput_4.setChecked( "" +
       ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndNotifiedDhsWorkerString()) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              <td>\r\n                Was the Family Independence Case Manager notified of child's removal from the home?\r\n              </td>\r\n            </tr>\r\n            <tr>\r\n              <td colspan=\"3\">\r\n                ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("notifiedInformation");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded( incomeExpendituresDB.getIndNotifiedDhsWorker() );
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Family Independence Case Manager Notified Information");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                  <table cellPadding=\"3\" cellSpacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n                    <tr class=\"subDetail\">\r\n                      <td>\r\n                        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_5.setType("text");
              _jspx_th_impact_validateInput_5.setName(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_FIRST);
              _jspx_th_impact_validateInput_5.setSize("12");
              _jspx_th_impact_validateInput_5.setMaxLength("12");
              _jspx_th_impact_validateInput_5.setConstraint("Name12");
              _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_5.setLabel("First");
              _jspx_th_impact_validateInput_5.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_5.setValue(incomeExpendituresDB.getNmNotifiedDhsWrkrFirst());
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                      </td>\r\n                      <td>\r\n                        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_6.setType("text");
              _jspx_th_impact_validateInput_6.setName(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_MIDDLE);
              _jspx_th_impact_validateInput_6.setSize("12");
              _jspx_th_impact_validateInput_6.setMaxLength("12");
              _jspx_th_impact_validateInput_6.setConstraint("Name12");
              _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_6.setLabel("Middle");
              _jspx_th_impact_validateInput_6.setValue(incomeExpendituresDB.getNmNotifiedDhsWrkrMiddle());
              int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
              if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                      </td>\r\n                      <td>\r\n                        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_7.setType("text");
              _jspx_th_impact_validateInput_7.setName(IncomeExpendituresDB.NM_NOTIFIED_DHS_WRKR_LAST);
              _jspx_th_impact_validateInput_7.setSize("22");
              _jspx_th_impact_validateInput_7.setMaxLength("22");
              _jspx_th_impact_validateInput_7.setConstraint("Name22");
              _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_7.setLabel("Last");
              _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_7.setValue(incomeExpendituresDB.getNmNotifiedDhsWrkrLast());
              int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
              if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                      </td>\r\n                    </tr>\r\n                    <tr class=\"subDetail\">\r\n                      <td>\r\n                        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_8.setType("text");
              _jspx_th_impact_validateInput_8.setName( IncomeExpendituresDB.NBR_NOTIFIED_DHS_WRKR_PHN );
              _jspx_th_impact_validateInput_8.setSize("14");
              _jspx_th_impact_validateInput_8.setMaxLength("14");
              _jspx_th_impact_validateInput_8.setConstraint("Phone");
              _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_8.setLabel("Phone Number");
              _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatPhone(incomeExpendituresDB.getNbrNotifiedDhsWrkrPhn()));
              int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
              if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                      </td>\r\n                      <td colspan=\"2\">\r\n                        &nbsp;\r\n                      </td>\r\n                      <td>\r\n                        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setName(IncomeExpendituresDB.DT_NOTIFIED_WORKER_STRING);
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_0.setLabel("Date Notified");
              _jspx_th_impact_validateDate_0.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_0.setValue(incomeExpendituresDB.getDtNotifiedWorkerString());
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                      </td>\r\n                    </tr>\r\n                  </table>\r\n                ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n            </tr>\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br />\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th>\r\n        Income for Child\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
request.setAttribute("tabIndex", tabIndex);

      request.setAttribute("disableRadios", "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request));

      request.setAttribute("disableNoIncome", "false");
      request.setAttribute("incomeList", incomeExpendituresDB.getIncomeForChild());
      request.setAttribute("baseNameSuffix", IncomeExpendituresConversation.CHILD_INCOME_CONTROL_NAME_SUFFIX_BASE);
      List incomeForChildList = incomeExpendituresDB.getIncomeForChild();
      if (incomeForChildList != null) {
        Iterator incomeForChildIterator = incomeForChildList.iterator();
        while (incomeForChildIterator.hasNext()) {
          FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeForChildIterator.next();
          //Set an indicator if the Income Type is SSI
          if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType())) {
           indSSIForChild= true;
           //STGAP00004272  - Set an indicator if the Income Type is SSI and the child is in the
           //Certified Group(Assistance Unit) so CustomValidation can throw an error message
           if (fceIncomeDB.getIndCertifiedGroup()) {
          out.write("\r\n                ");
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n           ");
  }
           break;
          }
          
        }
      }
      
          out.write("\r\n        ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  boolean _disableNoIncome =
          Boolean.valueOf((String) request.getAttribute("disableNoIncome"));

  List _incomeList = (List) request.getAttribute("incomeList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

          out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">No&nbsp;Income</th>\r\n      <th class=\"thList\">Earned/Unearned</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");

  Iterator _iterator = _incomeList.iterator();
  int _loopCount = 0;
  while (_iterator.hasNext())
  {
    FceIncomeDB _fceIncomeDB = (FceIncomeDB) _iterator.next();
    boolean incomeZero = (_fceIncomeDB.getAmtIncome() == 0.0);
    boolean disableIncome = _disableNoIncome || (incomeZero == false);

    String nameSuffix = _baseNameSuffix + _loopCount;

          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss(_loopCount + 1) );
          out.write("\">\r\n      <td>\r\n        <a href=\"javascript:navigateToPersonDetail(");
          out.print( _fceIncomeDB.getIdPerson() );
          out.write(")\" \r\n           onclick=\"setIsDirtyCalled(true)\" \r\n           tabIndex=\"");
          out.print( _tabIndex++ );
          out.write("\">\r\n          ");
          out.print(_fceIncomeDB.getNmPersonFull());
          out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CINC, _fceIncomeDB.getCdType()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatMoney(_fceIncomeDB.getAmtIncome()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( _fceIncomeDB.getTxtSource() );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setName( FceIncomeDB.IND_NONE + nameSuffix );
          _jspx_th_impact_validateInput_10.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_10.setChecked( _fceIncomeDB.getIndNoneString() );
          _jspx_th_impact_validateInput_10.setDisabled( String.valueOf(disableIncome) );
          _jspx_th_impact_validateInput_10.setValue( ArchitectureConstants.TRUE );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("Earned");
          _jspx_th_impact_validateInput_11.setName( FceIncomeDB.IND_EARNED + nameSuffix );
          _jspx_th_impact_validateInput_11.setValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_11.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_11.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_11.setChecked( "" + _fceIncomeDB.getIndEarned() );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setLabel("Unearned");
          _jspx_th_impact_validateInput_12.setName( FceIncomeDB.IND_EARNED + nameSuffix );
          _jspx_th_impact_validateInput_12.setValue( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_12.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_12.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_12.setChecked( "" + Boolean.FALSE.equals(_fceIncomeDB.getIndEarnedObject()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("Countable");
          _jspx_th_impact_validateInput_13.setName( FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_13.setValue( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_13.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_13.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_13.setChecked( "" + Boolean.TRUE.equals(_fceIncomeDB.getIndCountableObject()) );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("Exempt");
          _jspx_th_impact_validateInput_14.setName( FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_14.setValue( ArchitectureConstants.FALSE );
          _jspx_th_impact_validateInput_14.setTabIndex( _tabIndex++ );
          _jspx_th_impact_validateInput_14.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_14.setChecked( "" + Boolean.FALSE.equals(_fceIncomeDB.getIndCountableObject()) );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n");

    _loopCount++;
  }

          out.write("\r\n  </table>\r\n</div>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n        ");
tabIndex = (Integer) request.getAttribute("tabIndex");

      
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  <br />\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th colspan=\"2\">\r\n        Income for Family\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        <div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n          <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n            <tr>\r\n              <th class=\"thList\">\r\n                Name\r\n              </th>\r\n              <th class=\"thList\">\r\n                Relationship\r\n                <br />\r\n                to Child\r\n              </th>\r\n              <th class=\"thList\">\r\n                Age\r\n              </th>\r\n              <th class=\"thList\">\r\n                Type\r\n              </th>\r\n              <th class=\"thList\">\r\n                Amount\r\n              </th>\r\n              <th class=\"thList\">\r\n                Source\r\n              </th>\r\n              <th class=\"thList\">\r\n                No\r\n");
          out.write("                <br />\r\n                Income\r\n              </th>\r\n              <th class=\"thList\">\r\n                Earned/\r\n                <br />\r\n                Unearned\r\n              </th>\r\n              <th class=\"thList\">\r\n                Countable/\r\n                <br />\r\n                Exempt\r\n              </th>\r\n            </tr>\r\n            ");
List incomeForFamilyList = incomeExpendituresDB.getIncomeForFamily();
      loopCount = 0;
      if (incomeForFamilyList == null) {

          out.write("\r\n            <tr class=\"odd\">\r\n              <td colspan=\"9\">\r\n                ");
          out.print(MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED"));
          out.write("\r\n              </td>\r\n            </tr>\r\n            ");
} else {
        Iterator incomeForFamilyIterator = incomeForFamilyList.iterator();
        while (incomeForFamilyIterator.hasNext()) {
          FceIncomeDB fceIncomeDB = (FceIncomeDB) incomeForFamilyIterator.next();
          String nameSuffix = IncomeExpendituresConversation.FAMILY_INCOME_CONTROL_NAME_SUFFIX_BASE + loopCount;

          //copied from AppAndBG.jsp
          String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", fceIncomeDB.getCdRelInt());
          if ("".equals(relationDecode)) {
            relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", fceIncomeDB.getCdRelInt());
          }

          out.write("\r\n            <tr class=\"");
          out.print(FormattingHelper.getRowCss(loopCount + 1));
          out.write("\">\r\n              <td>\r\n                <a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"javascript:navigateToPersonDetail(");
          out.print(fceIncomeDB.getIdPerson() );
          out.write(")\" onclick=\"setIsDirtyCalled(true)\"> ");
          out.print(fceIncomeDB.getNmPersonFull());
          out.write(" </a>\r\n              </td>\r\n              <td>\r\n                ");
          out.print(relationDecode);
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          out.print(fceIncomeDB.getNbrAgeString());
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
//SIR 23543 - Set an indicator if the Income Type is SSI and they are in the
          //Certified Group so CustomValidation can throw an error message
          if (CodesTables.CINCRSRC_SSI.equals(fceIncomeDB.getCdType()) && fceIncomeDB.getIndCertifiedGroup()) {
          out.write("\r\n                ");
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n                ");
}
          out.write("\r\n                ");
          out.print(Lookup.simpleDecodeSafe(CodesTables.CINC, fceIncomeDB.getCdType()));
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          out.print(FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome()));
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          out.print(fceIncomeDB.getTxtSource());
          out.write("\r\n              </td>\r\n              <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("checkbox");
          _jspx_th_impact_validateInput_16.setName(FceIncomeDB.IND_NONE + nameSuffix);
          _jspx_th_impact_validateInput_16.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_16.setDisabled( "" + (fceIncomeDB.getAmtIncome() != 0) );
          _jspx_th_impact_validateInput_16.setChecked( "" + fceIncomeDB.getIndNone() );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              </td>\r\n              <td>\r\n                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n                  <tr>\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setLabel("Earned");
          _jspx_th_impact_validateInput_17.setName(FceIncomeDB.IND_EARNED + nameSuffix);
          _jspx_th_impact_validateInput_17.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) );
          _jspx_th_impact_validateInput_17.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_17.setChecked( "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndEarnedString()) );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    </td>\r\n                  </tr>\r\n                  <tr>\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setLabel("Unearned");
          _jspx_th_impact_validateInput_18.setName(FceIncomeDB.IND_EARNED + nameSuffix);
          _jspx_th_impact_validateInput_18.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) );
          _jspx_th_impact_validateInput_18.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_18.setChecked( "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndEarnedString()) );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    </td>\r\n                  </tr>\r\n                </table>\r\n              </td>\r\n              <td>\r\n                <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n                  <tr>\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setLabel("Countable");
          _jspx_th_impact_validateInput_19.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix);
          _jspx_th_impact_validateInput_19.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) );
          _jspx_th_impact_validateInput_19.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setChecked( "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    </td>\r\n                  </tr>\r\n                  <tr>\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setLabel("Exempt");
          _jspx_th_impact_validateInput_20.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix);
          _jspx_th_impact_validateInput_20.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request) );
          _jspx_th_impact_validateInput_20.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_20.setChecked( "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    </td>\r\n                  </tr>\r\n                </table>\r\n              </td>\r\n            </tr>\r\n            ");
loopCount++;
        }
      }

          out.write("\r\n          </table>\r\n        </div>\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        If the family has $0 monthly income, explain how the family's monthly living expenses including housing, food and, clothing are met. Case Manager should use best judgment based on observation of the home environment and social history to\r\n        determine how the family's needs are being met. (For example, do they receive government benefits or cash contributions from someone outside the home, or does someone else they live with provide their living expenses.) Comments:\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName(IncomeExpendituresDB.TXT_NO_INCOME_EXPLANATION);
          _jspx_th_impact_validateTextArea_0.setCols("145");
          _jspx_th_impact_validateTextArea_0.setRows("2");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(incomeExpendituresDB.getTxtNoIncomeExplanation());
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        Specify how the family's and child's income(s) were determined:\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"2\">\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName(IncomeExpendituresDB.TXT_INCOME_DTRMNTN_COMMENTS);
          _jspx_th_impact_validateTextArea_1.setCols("145");
          _jspx_th_impact_validateTextArea_1.setRows("2");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(incomeExpendituresDB.getTxtIncomeDtrmntnComments());
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
if (Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request)) {

          out.write("\r\n    <tr>\r\n      <td width=\"30%\">\r\n        Total Living in the Removal Home:\r\n      </td>\r\n      <td width=\"70%\">\r\n        ");
          out.print(incomeExpendituresDB.getNbrLivingAtHomeString());
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        Total Number in Assistance Unit (AU):\r\n      </td>\r\n      <td>\r\n        ");
          out.print(incomeExpendituresDB.getNbrCertifiedGroupObject() != null ? incomeExpendituresDB.getNbrCertifiedGroupString() : "0");
          out.write("\r\n      </td>\r\n    </tr>\r\n    ");
}

      
          out.write("\r\n  </table>\r\n  <br />\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th>\r\n        Resources for Child\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
request.setAttribute("tabIndex", tabIndex);

      request.setAttribute("disableRadios", "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request));

      request.setAttribute("resourcesList", incomeExpendituresDB.getResourcesForChild());
      request.setAttribute("baseNameSuffix", IncomeExpendituresConversation.CHILD_RESOURCE_CONTROL_NAME_SUFFIX_BASE);

      
          out.write("\r\n        ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  List _resourcesList = (List) request.getAttribute("resourcesList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

          out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">Verification Method</th>\r\n      <th class=\"thList\">Accessible?</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");
  
  if (_resourcesList == null)
  {

          out.write("\r\n    <tr class=\"odd\">\r\n      <td colspan=\"7\">\r\n        ");
          out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
          out.write("\r\n      </td>\r\n    </tr>\r\n");

  }
  else
  {
    int _loopCount = 0;
    Iterator _iterator = _resourcesList.iterator();
    while(_iterator.hasNext())
    {
      FceIncomeDB fceIncomeDB = (FceIncomeDB)_iterator.next();
      String nameSuffix = _baseNameSuffix + _loopCount;

          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss(_loopCount + 1) );
          out.write("\">\r\n      <td>\r\n        <a tabIndex=\"");
          out.print(_tabIndex++);
          out.write("\" \r\n           href=\"javascript:navigateToPersonDetail(");
          out.print(fceIncomeDB.getIdPerson() );
          out.write(")\"\r\n           onclick=\"setIsDirtyCalled(true)\">\r\n          ");
          out.print( fceIncomeDB.getNmPersonFull() );
          out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CRSRC, fceIncomeDB.getCdType()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getTxtSource() );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getTxtVerificationMethod() );
          out.write("\r\n      </td>\r\n      ");
 // STGAP00004122 - change col label from Inaccessible (above) to Accessible and modify display logic accordingly 
          out.write("\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getIndNotAccessible() ? "No" : "Yes" );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setLabel("Countable");
          _jspx_th_impact_validateInput_21.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_21.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_21.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_21.setTabIndex(_tabIndex++);
          _jspx_th_impact_validateInput_21.setChecked( "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setLabel("Exempt");
          _jspx_th_impact_validateInput_22.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_22.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_22.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_22.setTabIndex(_tabIndex++);
          _jspx_th_impact_validateInput_22.setChecked( "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n");

      _loopCount++;
    }
  }

          out.write("\r\n  </table>\r\n</div>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n        ");
tabIndex = (Integer) request.getAttribute("tabIndex");

      
          out.write("\r\n      </td>\r\n    </tr>   \r\n  </table>\r\n  <br />\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n    <tr>\r\n      <th>\r\n        Resources for Family\r\n      </th>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
request.setAttribute("tabIndex", tabIndex);

      request.setAttribute("disableRadios", "" + !Sets.isInSet(IncomeExpendituresConversation.INCOMES_SET, request));

      request.setAttribute("resourcesList", incomeExpendituresDB.getResourcesForFamily());
      request.setAttribute("baseNameSuffix", IncomeExpendituresConversation.FAMILY_RESOURCE_CONTROL_NAME_SUFFIX_BASE);

      
          out.write("\r\n        ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

{
  int _tabIndex = (Integer) request.getAttribute("tabIndex");
  String _disableRadios = (String) request.getAttribute("disableRadios");

  List _resourcesList = (List) request.getAttribute("resourcesList");
  String _baseNameSuffix = (String) request.getAttribute("baseNameSuffix");

          out.write("\r\n<div id=\"scrollBar\" style=\"height:155;width:100%;overflow:auto\" class=\"tableborderList\">\r\n  <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n    <tr>\r\n      <th class=\"thList\">Name</th>\r\n      <th class=\"thList\">Type</th>\r\n      <th class=\"thList\">Amount</th>\r\n      <th class=\"thList\">Source</th>\r\n      <th class=\"thList\">Verification Method</th>\r\n      <th class=\"thList\">Accessible?</th>\r\n      <th class=\"thList\">Countable/Exempt</th>\r\n    </tr>\r\n");
  
  if (_resourcesList == null)
  {

          out.write("\r\n    <tr class=\"odd\">\r\n      <td colspan=\"7\">\r\n        ");
          out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
          out.write("\r\n      </td>\r\n    </tr>\r\n");

  }
  else
  {
    int _loopCount = 0;
    Iterator _iterator = _resourcesList.iterator();
    while(_iterator.hasNext())
    {
      FceIncomeDB fceIncomeDB = (FceIncomeDB)_iterator.next();
      String nameSuffix = _baseNameSuffix + _loopCount;

          out.write("\r\n    <tr class=\"");
          out.print( FormattingHelper.getRowCss(_loopCount + 1) );
          out.write("\">\r\n      <td>\r\n        <a tabIndex=\"");
          out.print(_tabIndex++);
          out.write("\" \r\n           href=\"javascript:navigateToPersonDetail(");
          out.print(fceIncomeDB.getIdPerson() );
          out.write(")\"\r\n           onclick=\"setIsDirtyCalled(true)\">\r\n          ");
          out.print( fceIncomeDB.getNmPersonFull() );
          out.write("\r\n        </a>\r\n      </td>\r\n      <td>\r\n        ");
          out.print( Lookup.simpleDecodeSafe(CodesTables.CRSRC, fceIncomeDB.getCdType()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( FormattingHelper.formatMoney(fceIncomeDB.getAmtIncome()) );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getTxtSource() );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getTxtVerificationMethod() );
          out.write("\r\n      </td>\r\n      ");
 // STGAP00004122 - change col label from Inaccessible (above) to Accessible and modify display logic accordingly 
          out.write("\r\n      <td>\r\n        ");
          out.print( fceIncomeDB.getIndNotAccessible() ? "No" : "Yes" );
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setLabel("Countable");
          _jspx_th_impact_validateInput_23.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_23.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_23.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_23.setTabIndex(_tabIndex++);
          _jspx_th_impact_validateInput_23.setChecked( "" + ArchitectureConstants.TRUE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        <br/>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setLabel("Exempt");
          _jspx_th_impact_validateInput_24.setName(FceIncomeDB.IND_COUNTABLE + nameSuffix );
          _jspx_th_impact_validateInput_24.setDisabled( _disableRadios );
          _jspx_th_impact_validateInput_24.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_24.setTabIndex(_tabIndex++);
          _jspx_th_impact_validateInput_24.setChecked( "" + ArchitectureConstants.FALSE.equals(fceIncomeDB.getIndCountableString()) );
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n");

      _loopCount++;
    }
  }

          out.write("\r\n  </table>\r\n</div>\r\n");

 request.setAttribute("tabIndex", _tabIndex);
}

          out.write('\r');
          out.write('\n');
          out.write("\r\n        ");
tabIndex = (Integer) request.getAttribute("tabIndex");

      
          out.write("\r\n      </td>\r\n    </tr>\r\n  ");
if (indSSIForChild == true){ 
          out.write("\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n            <th>\r\n              Child's Cost of Care\r\n            </th>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setLabel("Yes");
          _jspx_th_impact_validateInput_25.setName( IncomeExpendituresDB.IND_CHILD_CARE );
          _jspx_th_impact_validateInput_25.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_25.setOnClick("showCostCareExceedSection();");
          _jspx_th_impact_validateInput_25.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndChildCareString()) );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              &nbsp;\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setLabel("No");
          _jspx_th_impact_validateInput_26.setName(IncomeExpendituresDB.IND_CHILD_CARE);
          _jspx_th_impact_validateInput_26.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setOnClick("hideCostCareExceedSection(); emptyQuestions();");
          _jspx_th_impact_validateInput_26.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndChildCareString()) );
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              &nbsp; Does the child's cost of care exceed $853.00?\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              <div id=\"costCareExceed\" style=\"display:none\">\r\n                <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n                  <tr class=\"subDetail\">\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setLabel("Yes");
          _jspx_th_impact_validateInput_27.setName( IncomeExpendituresDB.IND_OUT_HOME_CARE );
          _jspx_th_impact_validateInput_27.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndOutOfHomeCareString()) );
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      &nbsp;\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setLabel("No");
          _jspx_th_impact_validateInput_28.setName(IncomeExpendituresDB.IND_OUT_HOME_CARE);
          _jspx_th_impact_validateInput_28.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_28.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndOutOfHomeCareString()) );
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      &nbsp; Is the child expected to be in out-of-home care for a short period of time?\r\n                  </tr>\r\n                  <tr class=\"subDetail\">\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setLabel("Yes");
          _jspx_th_impact_validateInput_29.setName( IncomeExpendituresDB.IND_EMANCIPATION );
          _jspx_th_impact_validateInput_29.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_29.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndEmancipationString()) );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      &nbsp;\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setLabel("No");
          _jspx_th_impact_validateInput_30.setName(IncomeExpendituresDB.IND_EMANCIPATION);
          _jspx_th_impact_validateInput_30.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_30.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndEmancipationString()) );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      &nbsp; Is the child approaching emancipation?\r\n                  </tr>\r\n                  <tr class=\"subDetail\">\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("radio");
          _jspx_th_impact_validateInput_31.setLabel("Yes");
          _jspx_th_impact_validateInput_31.setName( IncomeExpendituresDB.IND_ADOPTION );
          _jspx_th_impact_validateInput_31.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_31.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndAdoptionString()) );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      &nbsp;\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setLabel("No");
          _jspx_th_impact_validateInput_32.setName(IncomeExpendituresDB.IND_ADOPTION);
          _jspx_th_impact_validateInput_32.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_32.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndAdoptionString()) );
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                      &nbsp; Is the child in the process of being adopted?\r\n                  </tr>\r\n                </table>\r\n              </div>\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n    ");
}
          out.write("\r\n    <tr>\r\n      <td>\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n            <th>\r\n              Child Care/Disabled Adult Care Section\r\n            </th>\r\n          </tr>\r\n          <tr>\r\n            <td>\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("radio");
          _jspx_th_impact_validateInput_33.setLabel("Yes");
          _jspx_th_impact_validateInput_33.setName( IncomeExpendituresDB.IND_PAY_FOR_CARE );
          _jspx_th_impact_validateInput_33.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_33.setOnClick("javascript:expandCollapsed('expandedexpendituresInformation', 'collapsedexpendituresInformation');");
          _jspx_th_impact_validateInput_33.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndPayForCareString()) );
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              &nbsp;\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("radio");
          _jspx_th_impact_validateInput_34.setLabel("No");
          _jspx_th_impact_validateInput_34.setName(IncomeExpendituresDB.IND_PAY_FOR_CARE);
          _jspx_th_impact_validateInput_34.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_34.setOnClick("javascript:collapseExpanded('expandedexpendituresInformation', 'collapsedexpendituresInformation');");
          _jspx_th_impact_validateInput_34.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndPayForCareString()) );
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n              &nbsp; Does anyone working in the removal home, pay for child care or for the care of a disabled adult living in the removal home?\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"3\">\r\n              ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("expendituresInformation");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ExpandableSectionTag_1.setIsExpanded( incomeExpendituresDB.getIndPayForCare() );
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Expenditures Information");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                <table cellPadding=\"3\" cellSpacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n                  <tr>\r\n                    <th class=\"thList\">\r\n                      Person Responsible for Payment\r\n                    </th>\r\n                    <th class=\"thList\">\r\n                      Person Receiving Care\r\n                    </th>\r\n                    <th class=\"thList\">\r\n                      Service Provider Name\r\n                    </th>\r\n                    <th class=\"thList\">\r\n                      Monthly Amount Paid\r\n                    </th>\r\n                  </tr>\r\n                  ");
List principals = incomeExpendituresDB.getPrincipals();
      List personNameList = new ArrayList();
      List personCareReceiveNameList = new ArrayList();
      for (int i = 0; i < principals.size(); i++) {
        FcePersonDB principal = (FcePersonDB) principals.get(i);
        personNameList.add(new Option(String.valueOf(principal.getIdPerson()), principal.getNmPersonFull()));
        personCareReceiveNameList.add(new Option(String.valueOf(principal.getIdPerson()), principal.getNmPersonFull()));
      }

      List expendituresList = incomeExpendituresDB.getExpenditures();
      FceExpendituresDB fceExpendituresArray[] = new FceExpendituresDB[5];
      if (!expendituresList.isEmpty() && expendituresList != null) {
        int count = 0;
        Iterator expendituresIterator = expendituresList.iterator();
        while (expendituresIterator.hasNext()) {
          FceExpendituresDB fceExpendituresDB = (FceExpendituresDB) expendituresIterator.next();
          fceExpendituresArray[count] = fceExpendituresDB;
          count++;
        }
      }
      for (int i = 0; i < 5; i++) {
        String principalsId = IncomeExpendituresDB.PRINCIPALS + i;
        String personCareReceiveId = IncomeExpendituresDB.ID_PERSON_CARE_RECEIVE + i;
        String nmServiceProviderId = FceExpendituresDB.NM_SERVICE_PROVIDER + i;
        String amtPdMonthlyId = FceExpendituresDB.AMT_PD_MONTHLY + i;
        if (fceExpendituresArray[i] != null) {
      
              out.write("\r\n\t\t\t\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_0.setName(principalsId);
              _jspx_th_impact_validateSelect_0.setOptions(personNameList);
              _jspx_th_impact_validateSelect_0.setBlankValue("true");
              _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_0.setValue(FormattingHelper.formatLong(fceExpendituresArray[i].getIdPerson()));
              _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 180px");
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_1.setName(personCareReceiveId);
              _jspx_th_impact_validateSelect_1.setOptions(personCareReceiveNameList);
              _jspx_th_impact_validateSelect_1.setBlankValue("true");
              _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatLong(fceExpendituresArray[i].getIdPersonCareReceive()));
              _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 180px");
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_35.setType("text");
              _jspx_th_impact_validateInput_35.setName(nmServiceProviderId);
              _jspx_th_impact_validateInput_35.setSize("40");
              _jspx_th_impact_validateInput_35.setMaxLength("40");
              _jspx_th_impact_validateInput_35.setConstraint("Paragraph40");
              _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_35.setValue(fceExpendituresArray[i].getNmServiceProvider());
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_36.setType("text");
              _jspx_th_impact_validateInput_36.setName(amtPdMonthlyId);
              _jspx_th_impact_validateInput_36.setSize("13");
              _jspx_th_impact_validateInput_36.setMaxLength("13");
              _jspx_th_impact_validateInput_36.setConstraint("Money11");
              _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_36.setValue(FormattingHelper.formatMoney(fceExpendituresArray[i].getAmtPdMonthly()));
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t \r\n\t\t\t\t\t\t\t\t\t");
} else {
         
              out.write("\r\n\t\t\t\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_2.setName(principalsId);
              _jspx_th_impact_validateSelect_2.setOptions(personNameList);
              _jspx_th_impact_validateSelect_2.setBlankValue("true");
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_2.setStyle("WIDTH: 180px");
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_3.setName(personCareReceiveId);
              _jspx_th_impact_validateSelect_3.setOptions(personCareReceiveNameList);
              _jspx_th_impact_validateSelect_3.setBlankValue("true");
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 180px");
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_37.setType("text");
              _jspx_th_impact_validateInput_37.setName(nmServiceProviderId);
              _jspx_th_impact_validateInput_37.setSize("40");
              _jspx_th_impact_validateInput_37.setMaxLength("40");
              _jspx_th_impact_validateInput_37.setConstraint("Paragraph40");
              _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_37.setValue(" ");
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_38.setType("text");
              _jspx_th_impact_validateInput_38.setName(amtPdMonthlyId);
              _jspx_th_impact_validateInput_38.setSize("13");
              _jspx_th_impact_validateInput_38.setMaxLength("13");
              _jspx_th_impact_validateInput_38.setConstraint("Money11");
              _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_38.setValue(FormattingHelper.formatMoney(0));
              int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
              if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t\t\t\t");
}

      }
              out.write("\r\n                </table>\r\n              ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n        </table>\r\n      </td>\r\n    </tr>\r\n\t</table>\r\n\t<br />\r\n\t\r\n<!--- Begin Allocation and Deeming Table --->\r\n");

String bDisabled = "" + PageModeConstants.VIEW.equals(fceApplicationPageMode);
if (((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus()))) ||
     ((user.hasRight(UserProfile.SEC_ELIGIBILITY)) &&
      ((EventHelper.PENDING_EVENT.equals(incomeExpendituresDB.getCdEventStatus())) ||
       (EventHelper.COMPLETE_EVENT.equals(incomeExpendituresDB.getCdEventStatus())))))
       && "A".equals(incomeExpendituresDB.getCdApplication()))
{

          out.write("\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n            <th colspan=\"4\"  class=\"thList\">\r\n              Determination of Standard Of Need for Allocation Budget\r\n            </th>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"4\">\r\n              Use this section when one or more members of the AU is allocationg money to individual(s) who are not eligibible to be part of the AU but were in the removal home at the time of  removal. All AU Members and at least one spouse or one child is required for each row if an Allocation Type is selected.\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n\t\t    <td>\r\n\t\t    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setLabel("Allocation Type");
          _jspx_th_impact_validateSelect_4.setName( IncomeExpendituresDB.CD_ALLOC_TYPE );
          _jspx_th_impact_validateSelect_4.setOrderBy("decode");
          _jspx_th_impact_validateSelect_4.setCodesTable("CALOCTYP");
          _jspx_th_impact_validateSelect_4.setOnChange("setupAllocationSection()");
          _jspx_th_impact_validateSelect_4.setValue(incomeExpendituresDB.getCdAllocType() );
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t    <td colspan=\"2\"></td>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"2\">AU Member responsible for Allocation</td>\r\n\t\t\t<td>Number of Ineligible Spouse</td>\r\n\t\t\t<td>Number of Ineligible Child(ren)</td>\r\n          </tr> \r\n          <tr id=\"allocMutual\" style=\"display: none\">\r\n\t\t\t       <td rowspan=\"2\"  colspan=\"2\">\r\n\t\t\t  \t\t ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setName( IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_1 );
          _jspx_th_impact_validateSelect_5.setOptions(aUMembersOptionsList);
          _jspx_th_impact_validateSelect_5.setBlankValue("true");
          _jspx_th_impact_validateSelect_5.setValue(incomeExpendituresDB.getIdPersonAllocMutual1String() );
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("<br>\r\n\t\t\t\t\t ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setName( IncomeExpendituresDB.ID_PERSON_ALLOC_MUTUAL_2 );
          _jspx_th_impact_validateSelect_6.setOptions(aUMembersOptionsList);
          _jspx_th_impact_validateSelect_6.setBlankValue("true");
          _jspx_th_impact_validateSelect_6.setValue(incomeExpendituresDB.getIdPersonAllocMutual2String() );
          _jspx_th_impact_validateSelect_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t   </td>\r\n\t\t\t  \t   <td>   \r\n\t\t\t  \t     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setType("text");
          _jspx_th_impact_validateInput_39.setLabel("");
          _jspx_th_impact_validateInput_39.setName( IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_MUTUAL );
          _jspx_th_impact_validateInput_39.setCssClass("formInput");
          _jspx_th_impact_validateInput_39.setValue(incomeExpendituresDB.getNbrIneligSpouseAllocMutualObject() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligSpouseAllocMutual() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_39.setSize("2");
          _jspx_th_impact_validateInput_39.setMaxLength("2");
          _jspx_th_impact_validateInput_39.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t       </td>\r\n\t\t\t       <td>\r\n\t\t\t         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setType("text");
          _jspx_th_impact_validateInput_40.setLabel("");
          _jspx_th_impact_validateInput_40.setName( IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_MUTUAL );
          _jspx_th_impact_validateInput_40.setCssClass("formInput");
          _jspx_th_impact_validateInput_40.setValue(incomeExpendituresDB.getNbrIneligChildAllocMutualObject() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligChildAllocMutual() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_40.setSize("2");
          _jspx_th_impact_validateInput_40.setMaxLength("2");
          _jspx_th_impact_validateInput_40.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t       </td>\r\n\t\t  <tr>\r\n\t\t\t       <td colspan=\"2\"></td>\r\n\t\t  </tr>\r\n\t\t  <tr id=\"allocSingleMultiple\" style=\"display: none\">\r\n                   <td colspan=\"2\">\r\n                     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setName( IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_1 );
          _jspx_th_impact_validateSelect_7.setOptions(aUMembersOptionsList);
          _jspx_th_impact_validateSelect_7.setBlankValue("true");
          _jspx_th_impact_validateSelect_7.setValue(incomeExpendituresDB.getIdPersonAllocSngl1String() );
          _jspx_th_impact_validateSelect_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                   </td>\r\n\t\t\t       <td>\r\n\t\t\t         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setType("text");
          _jspx_th_impact_validateInput_41.setLabel("");
          _jspx_th_impact_validateInput_41.setName( IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_1 );
          _jspx_th_impact_validateInput_41.setCssClass("formInput");
          _jspx_th_impact_validateInput_41.setValue(incomeExpendituresDB.getNbrIneligSpouseAllocSngl1Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligSpouseAllocSngl1() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_41.setSize("2");
          _jspx_th_impact_validateInput_41.setMaxLength("2");
          _jspx_th_impact_validateInput_41.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t       </td>\r\n                   <td>\r\n                     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setType("text");
          _jspx_th_impact_validateInput_42.setLabel("");
          _jspx_th_impact_validateInput_42.setName( IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_1 );
          _jspx_th_impact_validateInput_42.setCssClass("formInput");
          _jspx_th_impact_validateInput_42.setValue(incomeExpendituresDB.getNbrIneligChildAllocSngl1Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligChildAllocSngl1() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_42.setSize("2");
          _jspx_th_impact_validateInput_42.setMaxLength("2");
          _jspx_th_impact_validateInput_42.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                   </td>\r\n          </tr>\r\n\t      <tr id=\"allocMultiple\" style=\"display: none\">\r\n\t\t\t  \t   <td colspan=\"2\">\r\n                     ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setName( IncomeExpendituresDB.ID_PERSON_ALLOC_SNGL_2 );
          _jspx_th_impact_validateSelect_8.setOptions(aUMembersOptionsList);
          _jspx_th_impact_validateSelect_8.setBlankValue("true");
          _jspx_th_impact_validateSelect_8.setValue(incomeExpendituresDB.getIdPersonAllocSngl2String() );
          _jspx_th_impact_validateSelect_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                   </td>\r\n\t\t\t       <td>\r\n\t\t\t         ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("text");
          _jspx_th_impact_validateInput_43.setLabel("");
          _jspx_th_impact_validateInput_43.setName( IncomeExpendituresDB.NBR_INELIG_SPOUSE_ALLOC_SNGL_2 );
          _jspx_th_impact_validateInput_43.setCssClass("formInput");
          _jspx_th_impact_validateInput_43.setValue(incomeExpendituresDB.getNbrIneligSpouseAllocSngl2Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligSpouseAllocSngl2() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_43.setSize("2");
          _jspx_th_impact_validateInput_43.setMaxLength("2");
          _jspx_th_impact_validateInput_43.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t       </td>\r\n                   <td>\r\n                     ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("text");
          _jspx_th_impact_validateInput_44.setLabel("");
          _jspx_th_impact_validateInput_44.setName( IncomeExpendituresDB.NBR_INELIG_CHILD_ALLOC_SNGL_2 );
          _jspx_th_impact_validateInput_44.setCssClass("formInput");
          _jspx_th_impact_validateInput_44.setValue(incomeExpendituresDB.getNbrIneligChildAllocSngl2Object() != null ?
                                 "" + incomeExpendituresDB.getNbrIneligChildAllocSngl2() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_44.setSize("2");
          _jspx_th_impact_validateInput_44.setMaxLength("2");
          _jspx_th_impact_validateInput_44.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                   </td>\r\n          </tr>\r\n      </table>\r\n        <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n          <tr>\r\n            <th colspan=\"4\">\r\n              Determination Of Standard Of Need for Deeming Budget\r\n            </th>\r\n          </tr>\r\n          <tr>\r\n            <td colspan=\"4\">\r\n              Use this section when one or more responsible individuals, who is not part of the AU but were in the removal home at the time of  removal, is deeming money to the AU. The whole section is required if a Deeming Type is selected.\r\n            </td>\r\n          </tr>\r\n          <tr>\r\n      <td>\r\n         ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setName( IncomeExpendituresDB.CD_DEEM_RESP_TYPE );
          _jspx_th_impact_validateSelect_9.setLabel("1. Deeming Type");
          _jspx_th_impact_validateSelect_9.setOrderBy("decode");
          _jspx_th_impact_validateSelect_9.setCodesTable("CDEEMTYP");
          _jspx_th_impact_validateSelect_9.setOnChange("setupDeemingSection()");
          _jspx_th_impact_validateSelect_9.setValue(incomeExpendituresDB.getCdDeemRespType() );
          _jspx_th_impact_validateSelect_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td colspan=\"2\"></td>\r\n  </tr>\r\n  <tr id=\"deemIndiv1Label\" style=\"display: none\">\r\n     <td colspan=\"3\">Select the Responsible Individual whose income is deemed into the AU</td>\r\n    <td>Relationship</td>\r\n  </tr>\r\n  <tr id=\"deemIndiv1\" style=\"display: none\">\r\n  <td colspan=\"3\">\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setName( IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_1 );
          _jspx_th_impact_validateSelect_10.setOptions(nonAUMembersOptionsList);
          _jspx_th_impact_validateSelect_10.setBlankValue("true");
          _jspx_th_impact_validateSelect_10.setValue(incomeExpendituresDB.getIdPersonDeemIndiv1String() );
          _jspx_th_impact_validateSelect_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_11.setName( IncomeExpendituresDB.CD_DEEM_INDIV_REL_1 );
          _jspx_th_impact_validateSelect_11.setOrderBy("decode");
          _jspx_th_impact_validateSelect_11.setCodesTable("CDEEMREL");
          _jspx_th_impact_validateSelect_11.setValue(incomeExpendituresDB.getCdDeemIndivRel1() );
          _jspx_th_impact_validateSelect_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_11 = _jspx_th_impact_validateSelect_11.doStartTag();
          if (_jspx_th_impact_validateSelect_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  </tr>\r\n  <tr id=\"deemIndiv2Label\" style=\"display: none\">\r\n     <td colspan=\"3\">Select the Responsible Individual whose income is deemed into the AU</td>\r\n    <td>Relationship</td>\r\n  </tr>\r\n   <tr id=\"deemIndiv2\" style=\"display: none\">\r\n  <td colspan=\"3\">\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_12.setName( IncomeExpendituresDB.ID_PERSON_DEEM_INDIV_2 );
          _jspx_th_impact_validateSelect_12.setOptions(nonAUMembersOptionsList);
          _jspx_th_impact_validateSelect_12.setBlankValue("true");
          _jspx_th_impact_validateSelect_12.setValue(incomeExpendituresDB.getIdPersonDeemIndiv2String() );
          _jspx_th_impact_validateSelect_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_12 = _jspx_th_impact_validateSelect_12.doStartTag();
          if (_jspx_th_impact_validateSelect_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_13.setName( IncomeExpendituresDB.CD_DEEM_INDIV_REL_2 );
          _jspx_th_impact_validateSelect_13.setCodesTable("CDEEMREL");
          _jspx_th_impact_validateSelect_13.setValue(incomeExpendituresDB.getCdDeemIndivRel2() );
          _jspx_th_impact_validateSelect_13.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_13 = _jspx_th_impact_validateSelect_13.doStartTag();
          if (_jspx_th_impact_validateSelect_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  </tr> \r\n  <tr id=\"rowNbrDeemChildNotInAU\" style=\"display: none\">\r\n     <td colspan=\"3\" width=\"75%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setType("text");
          _jspx_th_impact_validateInput_45.setLabel("2. Number of Responsible Individual's children who live in the home but are not included in the AU");
          _jspx_th_impact_validateInput_45.setName( IncomeExpendituresDB.NBR_DEEM_CHILD_NOT_IN_AU );
          _jspx_th_impact_validateInput_45.setCssClass("formInput");
          _jspx_th_impact_validateInput_45.setValue(incomeExpendituresDB.getNbrDeemChildNotInAUObject() != null ?
                                 "" + incomeExpendituresDB.getNbrDeemChildNotInAU() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_45.setSize("2");
          _jspx_th_impact_validateInput_45.setMaxLength("2");
          _jspx_th_impact_validateInput_45.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n             </td>\r\n          </tr>\r\n          <tr id=\"rowNbrDeemTaxDependNotInAU\" style=\"display: none\">\r\n            <td colspan=\"3\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_46.setType("text");
          _jspx_th_impact_validateInput_46.setLabel("3. Number of other dependents in the home who are claimed or could be claimed as tax dependents and are not included in the AU");
          _jspx_th_impact_validateInput_46.setName( IncomeExpendituresDB.NBR_DEEM_TAX_DEPEND_NOT_IN_AU );
          _jspx_th_impact_validateInput_46.setCssClass("formInput");
          _jspx_th_impact_validateInput_46.setValue(incomeExpendituresDB.getNbrDeemTaxDependNotInAUObject() != null ?
                                 "" + incomeExpendituresDB.getNbrDeemTaxDependNotInAU() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_46.setSize("2");
          _jspx_th_impact_validateInput_46.setMaxLength("2");
          _jspx_th_impact_validateInput_46.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n          </tr>\r\n          <tr id=\"rowNbrDeemResponseIndiv\" style=\"display: none\">\r\n              <td colspan=\"3\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setType("text");
          _jspx_th_impact_validateInput_47.setLabel("4. Number of Responsible Individuals");
          _jspx_th_impact_validateInput_47.setName( IncomeExpendituresDB.NBR_DEEM_RESPONSE_INDIV );
          _jspx_th_impact_validateInput_47.setDisabled("true");
          _jspx_th_impact_validateInput_47.setCssClass("formInput");
          _jspx_th_impact_validateInput_47.setValue(incomeExpendituresDB.getNbrDeemResponseIndivObject() != null ?
                                 "" + incomeExpendituresDB.getNbrDeemResponseIndiv() :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_47.setSize("2");
          _jspx_th_impact_validateInput_47.setMaxLength("2");
          _jspx_th_impact_validateInput_47.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
          if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr id=\"rowAmtDeemTaxDependOutHh\" style=\"display: none\">\r\n              <td colspan=\"3\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_48.setType("text");
          _jspx_th_impact_validateInput_48.setLabel("5. Amount paid to dependents outside the household who are claimed or could be claimed as tax dependents");
          _jspx_th_impact_validateInput_48.setName( IncomeExpendituresDB.AMT_DEEM_TAX_DEPEND_OUT_HH );
          _jspx_th_impact_validateInput_48.setCssClass("formInput");
          _jspx_th_impact_validateInput_48.setValue(incomeExpendituresDB.getAmtDeemTaxDependOutHhObject() != null ?
                                 FormattingHelper.formatMoney(incomeExpendituresDB.getAmtDeemTaxDependOutHh()) :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_48.setSize("13");
          _jspx_th_impact_validateInput_48.setMaxLength("13");
          _jspx_th_impact_validateInput_48.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
          if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr id=\"rowAmtDeemAlimonyOutsideHh\" style=\"display: none\">\r\n              <td colspan=\"3\">\r\n              ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_49.setType("text");
          _jspx_th_impact_validateInput_49.setLabel("6. Alimony and/or child support paid to person(s) outside of the household");
          _jspx_th_impact_validateInput_49.setName( IncomeExpendituresDB.AMT_DEEM_ALIMONY_OUTSIDE_HH );
          _jspx_th_impact_validateInput_49.setCssClass("formInput");
          _jspx_th_impact_validateInput_49.setValue(incomeExpendituresDB.getAmtDeemAlimonyOutsideHhObject() != null ?
                                 FormattingHelper.formatMoney(incomeExpendituresDB.getAmtDeemAlimonyOutsideHh()) :
                                 StringHelper.EMPTY_STRING );
          _jspx_th_impact_validateInput_49.setSize("13");
          _jspx_th_impact_validateInput_49.setMaxLength("13");
          _jspx_th_impact_validateInput_49.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n");
}
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setName("documentationChecklist");
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Documentation Checklist");
          _jspx_th_impact_ExpandableSectionTag_2.setIsExpanded(true);
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_50.setType("radio");
              _jspx_th_impact_validateInput_50.setName(IncomeExpendituresDB.IND_PROOF_AGE_SENT_ES);
              _jspx_th_impact_validateInput_50.setLabel("Yes");
              _jspx_th_impact_validateInput_50.setValue(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_50.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofAgeSentEsString()) );
              int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
              if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_51.setType("radio");
              _jspx_th_impact_validateInput_51.setName(IncomeExpendituresDB.IND_PROOF_AGE_SENT_ES);
              _jspx_th_impact_validateInput_51.setLabel("No");
              _jspx_th_impact_validateInput_51.setValue(ArchitectureConstants.FALSE);
              _jspx_th_impact_validateInput_51.setLabel("No");
              _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_51.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofAgeSentEsString()) );
              int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
              if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp; <span>Is the proof of birth/child's age being sent to the Eligibility Specialist?</span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_1.setName(IncomeExpendituresDB.DT_PROOF_AGE_SENT_ES_STRING);
              _jspx_th_impact_validateDate_1.setLabel("Date");
              _jspx_th_impact_validateDate_1.setValue(incomeExpendituresDB.getDtProofAgeSentEsString());
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_1.setConditionallyRequired(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateDate_1.setDoNotReuse("true");
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_2.setName(IncomeExpendituresDB.TXT_PROOF_AGE_SENT_ES);
              _jspx_th_impact_validateTextArea_2.setCols("75");
              _jspx_th_impact_validateTextArea_2.setRows("2");
              _jspx_th_impact_validateTextArea_2.setLabel("Comments");
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_2.setConditionallyRequired(ArchitectureConstants.TRUE);
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(incomeExpendituresDB.getTxtProofAgeSentEs());
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
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_52.setType("radio");
              _jspx_th_impact_validateInput_52.setName(IncomeExpendituresDB.IND_PROOF_CITIZENSHIP_SENT_ES);
              _jspx_th_impact_validateInput_52.setLabel("Yes");
              _jspx_th_impact_validateInput_52.setValue(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_52.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofCitizenshipSentEsString()) );
              int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
              if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_53.setType("radio");
              _jspx_th_impact_validateInput_53.setName(IncomeExpendituresDB.IND_PROOF_CITIZENSHIP_SENT_ES);
              _jspx_th_impact_validateInput_53.setLabel("No");
              _jspx_th_impact_validateInput_53.setValue(ArchitectureConstants.FALSE);
              _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_53.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofCitizenshipSentEsString()) );
              int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
              if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp; <span>Are copies of all documents used to verify the child's Citizenship/Alien Status being sent to the Eligibility Specialist?</span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_2.setName(IncomeExpendituresDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING);
              _jspx_th_impact_validateDate_2.setLabel("Date");
              _jspx_th_impact_validateDate_2.setValue(incomeExpendituresDB.getDtProofCitizenshipSentEsString());
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_2.setConditionallyRequired(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateDate_2.setDoNotReuse("false");
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_3.setName(IncomeExpendituresDB.TXT_PROOF_CITIZENSHIP_SENT_ES);
              _jspx_th_impact_validateTextArea_3.setCols("75");
              _jspx_th_impact_validateTextArea_3.setRows("2");
              _jspx_th_impact_validateTextArea_3.setLabel("Comments");
              _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_3.setMaxLength(300);
              _jspx_th_impact_validateTextArea_3.setConditionallyRequired(ArchitectureConstants.TRUE);
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(incomeExpendituresDB.getTxtProofCitizenshipSentEs());
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
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_54.setType("radio");
              _jspx_th_impact_validateInput_54.setName(IncomeExpendituresDB.IND_PROOF_CHILD_ID_SENT_ES);
              _jspx_th_impact_validateInput_54.setLabel("Yes");
              _jspx_th_impact_validateInput_54.setValue(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_54.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofChildIdSentEsString()) );
              int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
              if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_55.setType("radio");
              _jspx_th_impact_validateInput_55.setName(IncomeExpendituresDB.IND_PROOF_CHILD_ID_SENT_ES);
              _jspx_th_impact_validateInput_55.setLabel("No");
              _jspx_th_impact_validateInput_55.setValue(ArchitectureConstants.FALSE);
              _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_55.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofChildIdSentEsString()) );
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp; <span>Are copies of all documents used to verify the child's Identity being provided to the Eligibility Specialist?</span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_3.setName(IncomeExpendituresDB.DT_PROOF_CHILD_ID_SENT_ES_STRING);
              _jspx_th_impact_validateDate_3.setLabel("Date");
              _jspx_th_impact_validateDate_3.setValue(incomeExpendituresDB.getDtProofChildIdSentEsString());
              _jspx_th_impact_validateDate_3.setSize("10");
              _jspx_th_impact_validateDate_3.setConstraint("Date");
              _jspx_th_impact_validateDate_3.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_3.setConditionallyRequired(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateDate_3.setDoNotReuse("false");
              int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
              if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_4.setName(IncomeExpendituresDB.TXT_PROOF_CHILD_ID_SENT_ES);
              _jspx_th_impact_validateTextArea_4.setCols("75");
              _jspx_th_impact_validateTextArea_4.setRows("2");
              _jspx_th_impact_validateTextArea_4.setLabel("Comments");
              _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_4.setMaxLength(300);
              _jspx_th_impact_validateTextArea_4.setConditionallyRequired(ArchitectureConstants.TRUE);
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(incomeExpendituresDB.getTxtProofChildIdSentEs());
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
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_56.setType("radio");
              _jspx_th_impact_validateInput_56.setName(IncomeExpendituresDB.IND_LEGAL_DOCS_SENT_ES);
              _jspx_th_impact_validateInput_56.setLabel("Yes");
              _jspx_th_impact_validateInput_56.setValue(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_56.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndLegalDocsSentEsString()) );
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_57.setType("radio");
              _jspx_th_impact_validateInput_57.setName(IncomeExpendituresDB.IND_LEGAL_DOCS_SENT_ES);
              _jspx_th_impact_validateInput_57.setLabel("No");
              _jspx_th_impact_validateInput_57.setValue(ArchitectureConstants.FALSE);
              _jspx_th_impact_validateInput_57.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_57.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndLegalDocsSentEsString()) );
              int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
              if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp; <span>Have all legal documents been sent to the Eligibility Specialist including the Affidavit, Petition, and Court Order?</span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_4.setName(IncomeExpendituresDB.DT_LEGAL_DOCS_SENT_ES_STRING);
              _jspx_th_impact_validateDate_4.setLabel("Date");
              _jspx_th_impact_validateDate_4.setValue(incomeExpendituresDB.getDtLegalDocsSentEsString());
              _jspx_th_impact_validateDate_4.setSize("10");
              _jspx_th_impact_validateDate_4.setConstraint("Date");
              _jspx_th_impact_validateDate_4.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_4.setConditionallyRequired(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateDate_4.setDoNotReuse("false");
              int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
              if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_5.setName(IncomeExpendituresDB.TXT_LEGAL_DOCS_SENT_ES);
              _jspx_th_impact_validateTextArea_5.setCols("75");
              _jspx_th_impact_validateTextArea_5.setRows("2");
              _jspx_th_impact_validateTextArea_5.setLabel("Comments");
              _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_5.setMaxLength(300);
              _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_5.setConditionallyRequired(ArchitectureConstants.TRUE);
              int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
              if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_5.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(incomeExpendituresDB.getTxtLegalDocsSentEs());
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
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_58.setType("radio");
              _jspx_th_impact_validateInput_58.setName(IncomeExpendituresDB.IND_PROOF_PREGNANCY_SENT_ES);
              _jspx_th_impact_validateInput_58.setLabel("Yes");
              _jspx_th_impact_validateInput_58.setValue(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateInput_58.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_58.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndProofPregnancySentEsString()) );
              int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
              if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateInput_59.setType("radio");
              _jspx_th_impact_validateInput_59.setName(IncomeExpendituresDB.IND_PROOF_PREGNANCY_SENT_ES);
              _jspx_th_impact_validateInput_59.setLabel("No");
              _jspx_th_impact_validateInput_59.setValue(ArchitectureConstants.FALSE);
              _jspx_th_impact_validateInput_59.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_59.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndProofPregnancySentEsString()) );
              int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
              if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp; <span>Are copies of all documents used to verify the child's pregnancy being provided to the Eligibility Specialist? </span>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateDate_5.setName(IncomeExpendituresDB.DT_PROOF_PREGNANCY_SENT_ES_STRING);
              _jspx_th_impact_validateDate_5.setLabel("Date");
              _jspx_th_impact_validateDate_5.setValue(incomeExpendituresDB.getDtProofPregnancySentEsString());
              _jspx_th_impact_validateDate_5.setSize("10");
              _jspx_th_impact_validateDate_5.setConstraint("Date");
              _jspx_th_impact_validateDate_5.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_5.setConditionallyRequired(ArchitectureConstants.TRUE);
              _jspx_th_impact_validateDate_5.setDoNotReuse("false");
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
              _jspx_th_impact_validateTextArea_6.setName(IncomeExpendituresDB.TXT_PROOF_PREGNANCY_SENT_ES);
              _jspx_th_impact_validateTextArea_6.setCols("75");
              _jspx_th_impact_validateTextArea_6.setRows("2");
              _jspx_th_impact_validateTextArea_6.setLabel("Comments");
              _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_6.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_6.setMaxLength(300);
              _jspx_th_impact_validateTextArea_6.setConditionallyRequired(ArchitectureConstants.TRUE);
              int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
              if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_6.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(incomeExpendituresDB.getTxtProofPregnancySentEs());
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br />\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tCourt Ordered Child Support\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_60.setType("radio");
          _jspx_th_impact_validateInput_60.setName(IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDER);
          _jspx_th_impact_validateInput_60.setLabel("Yes");
          _jspx_th_impact_validateInput_60.setValue(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateInput_60.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_60.setChecked( "" + ArchitectureConstants.TRUE.equals(incomeExpendituresDB.getIndChildSupportOrderString()) );
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setType("radio");
          _jspx_th_impact_validateInput_61.setName(IncomeExpendituresDB.IND_CHILD_SUPPORT_ORDER);
          _jspx_th_impact_validateInput_61.setLabel("No");
          _jspx_th_impact_validateInput_61.setValue(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateInput_61.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_61.setChecked( "" + ArchitectureConstants.FALSE.equals(incomeExpendituresDB.getIndChildSupportOrderString()) );
          int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
          if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp;&nbsp;Was child support court ordered?\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br />\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmIncomeExpenditures");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setAccessKey("S");
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.SAVE_SET, request));
          _jspx_th_impact_ButtonTag_0.setAction(IncomeExpendituresConversation.SAVE_INCOME_EXPENDITURES_DETAIL_COMMAND);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t    ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSubmitApplicationFinal");
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setForm("frmIncomeExpenditures");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setAccessKey("U");
          _jspx_th_impact_ButtonTag_1.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.SUBMIT_SET, request));
          _jspx_th_impact_ButtonTag_1.setAction(IncomeExpendituresConversation.SUBMIT_APPLICATION_COMMAND);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnContinueFinal");
          _jspx_th_impact_ButtonTag_2.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_2.setForm("frmIncomeExpenditures");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setAccessKey("C");
          _jspx_th_impact_ButtonTag_2.setDisabled( "" + !Sets.isInSet(IncomeExpendituresConversation.CALCULATE_SET, request) );
          _jspx_th_impact_ButtonTag_2.setAction(IncomeExpendituresConversation.CALCULATE_COMMAND);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<input type=\"hidden\" name=\"");
          out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n");
      //  impact:if
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
      _jspx_th_impact_if_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_if_0.setParent(null);
      _jspx_th_impact_if_0.setTest( (pageMode.equals(PageModeConstants.VIEW) == false) );
      int _jspx_eval_impact_if_0 = _jspx_th_impact_if_0.doStartTag();
      if (_jspx_eval_impact_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_then_0(_jspx_th_impact_if_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:else
          gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag _jspx_th_impact_else_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ElseTag();
          _jspx_th_impact_else_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_else_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
          int _jspx_eval_impact_else_0 = _jspx_th_impact_else_0.doStartTag();
          if (_jspx_eval_impact_else_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n    ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_else_0);
              _jspx_th_impact_ifThen_0.setTest( incomeExpendituresDB.getIndIncomeAssistance() );
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\nshowDhsWorkerNotified();\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_else_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_else_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n// MR-053\r\n");
      //  impact:if
      gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag _jspx_th_impact_if_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfTag();
      _jspx_th_impact_if_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_if_1.setParent(null);
      _jspx_th_impact_if_1.setTest( ((pageMode.equals(PageModeConstants.VIEW)) &&
    ((EventHelper.APPROVED_EVENT.equals(incomeExpendituresDB.getCdEventStatus()))) ||
     ((user.hasRight(UserProfile.SEC_ELIGIBILITY)) &&
      ((EventHelper.PENDING_EVENT.equals(incomeExpendituresDB.getCdEventStatus())) ||
       (EventHelper.COMPLETE_EVENT.equals(incomeExpendituresDB.getCdEventStatus()))))) );
      int _jspx_eval_impact_if_1 = _jspx_th_impact_if_1.doStartTag();
      if (_jspx_eval_impact_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  ");
          if (_jspx_meth_impact_then_1(_jspx_th_impact_if_1, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n</script>\r\n\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmIncomeExpenditures");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("indSSI");
    _jspx_th_impact_validateInput_9.setValue("true");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("indSSI");
    _jspx_th_impact_validateInput_15.setValue("true");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_then_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:then
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
    _jspx_th_impact_then_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_then_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_0);
    int _jspx_eval_impact_then_0 = _jspx_th_impact_then_0.doStartTag();
    if (_jspx_eval_impact_then_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\nif (document.frmIncomeExpenditures.indIncomeAssistance[0].checked)\r\n{\r\n  showDhsWorkerNotified();\r\n}\r\n  ");
        int evalDoAfterBody = _jspx_th_impact_then_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_then_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_then_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:then
    gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag _jspx_th_impact_then_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.ThenTag();
    _jspx_th_impact_then_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_then_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_if_1);
    int _jspx_eval_impact_then_1 = _jspx_th_impact_then_1.doStartTag();
    if (_jspx_eval_impact_then_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n    setupAllocationSection(); \r\n    setupDeemingSection();\r\n  ");
        int evalDoAfterBody = _jspx_th_impact_then_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_impact_then_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
