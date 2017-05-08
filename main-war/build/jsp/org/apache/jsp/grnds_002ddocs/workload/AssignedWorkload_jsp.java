package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicWorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.AssignedWorkloadConversation;

public final class AssignedWorkload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  public static final String TWENTY_FOUR_NON_BREAKING_SPACES
          = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state
          = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile user = UserProfileHelper.getUserProfile(request);

  // PAGE MODE LOGIC BEGIN
  String pageMode;
  pageMode = user.hasRight(UserProfile.SEC_ASSIGN_WORKLOAD) ? PageModeConstants.EDIT : PageModeConstants.VIEW;

  //  GET OBJECTS FROM REQUEST AND PERFORM NULL CATCH

  CCMN14SO ccmn14so = (CCMN14SO) state.getAttribute("CCMN14SO", request);

  if (ccmn14so == null) {
    ccmn14so = new CCMN14SO();
  }
  ROWCCMN37DO_ARRAY rowccmn37doArray;
  rowccmn37doArray =
          ccmn14so.getROWCCMN37DO_ARRAY() != null ? ccmn14so.getROWCCMN37DO_ARRAY() : new ROWCCMN37DO_ARRAY();

  // SIR 19749 get the variables from state so the workload report can generate
  Integer workloadPersonID = (Integer) state.getAttribute("workloadPersonID", request);
  String workloadPersonName = (String) state.getAttribute("workloadPersonName", request);
  // SIR 22876 add sort order to the report
  String workloadSortOrder = (String) state.getAttribute("workloadSortOrder", request);

  int tabIndex = 1;
  int loopCount;

  String focusElement = null;
  if (FormValidation.pageHasErrorMessages(request) ||
      FormValidation.pageHasValidationMessages("frmAssignedWorkload", request)) {
    Enumeration params = request.getParameterNames();
    while (params.hasMoreElements()) {
      String paramName = (String) params.nextElement();
      if (paramName.startsWith("cbx") && !paramName.endsWith("_changed")) {
        focusElement = paramName;
        break;
      }
    }
  }



      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  //  This function is called when the user clicks a hyperlink in the list for a stage with a Case ID.\r\n  //  It takes the user to the Call Summary page.  Sir 17116 - lauramc added stageId to caseSummaryHyperlink\r\n  function caseSummaryHyperlink(index, stageId)\r\n  {\r\n    disableValidation(\"frmAssignedWorkload\");\r\n    submitValidateForm(\"frmAssignedWorkload\", \"/workload/AssignedWorkload/callCaseSummary?index=\" + index);\r\n  }\r\n  //  This function is called when the user clicks a hyperlink in the list for a stage without a Case ID.\r\n  //    It takes the user to the Event List page.\r\n  function eventListHyperlink(index)\r\n  {\r\n    disableValidation(\"frmAssignedWorkload\");\r\n    submitValidateForm(\"frmAssignedWorkload\", \"/workload/AssignedWorkload/callEventListNoCaseId?index=\" + index);\r\n  }\r\n\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAssignedWorkload");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/AssignedWorkload/displayAssignedWorkload");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.AssignedWorkloadCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

  String paginationDestination = "/workload/AssignedWorkload/displayAssignedWorkload";
  String currentCommand = (String) request.getAttribute("grnds_command");
  if ("displayOtherAssignedWorkload".equals(currentCommand)) {
    paginationDestination = "/workload/AssignedWorkload/displayOtherAssignedWorkload";
  }

          out.write("\r\n<input type=\"hidden\" name=\"filterBy\" value=\"");
          out.print(request.getAttribute("filterBy"));
          out.write("\">\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl(paginationDestination);
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div class=\"alignRight\">\r\n  <div class=\"formInstruct\">Scroll for more information --></div>\r\n</div>\r\n<div id=\"scrollBar2\" style=\"height:210px;width:763px;overflow:auto\" class=\"tableborderList\">\r\n<table width=\"1300\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n<tr>\r\n    ");
              out.write("\r\n  <th class=\"thList\">&nbsp;</th>\r\n  <th class=\"thList\">!</th>\r\n  <th class=\"thList\">P/S&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(DynamicWorkloadDAO.SORT_BY_PRIMARY_SECONDARY);
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Stage Name&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(DynamicWorkloadDAO.SORT_BY_STAGENAME);
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Stage&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(DynamicWorkloadDAO.SORT_BY_SERVICE_STAGE);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">FAD IV-E&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy(DynamicWorkloadDAO.SORT_BY_FAD_IVE);
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Status&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_4.setOrderBy(DynamicWorkloadDAO.SORT_BY_FA_HOME_STATUS);
              int _jspx_eval_impact_sortableColumnHeader_4 = _jspx_th_impact_sortableColumnHeader_4.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">\r\n  \t<span style=\"color:red\">E</span>&nbsp;/&nbsp;<span style=\"color:blue\">W</span>&nbsp;\r\n  </th>  \r\n  <th class=\"thList\">Level&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_5.setOrderBy(DynamicWorkloadDAO.SORT_BY_LEVEL);
              int _jspx_eval_impact_sortableColumnHeader_5 = _jspx_th_impact_sortableColumnHeader_5.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">RT&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_6.setOrderBy(DynamicWorkloadDAO.SORT_BY_RT);
              int _jspx_eval_impact_sortableColumnHeader_6 = _jspx_th_impact_sortableColumnHeader_6.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Assigned&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_7.setOrderBy(DynamicWorkloadDAO.SORT_BY_DATE);
              int _jspx_eval_impact_sortableColumnHeader_7 = _jspx_th_impact_sortableColumnHeader_7.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Case ID&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_8.setOrderBy(DynamicWorkloadDAO.SORT_BY_CASE);
              int _jspx_eval_impact_sortableColumnHeader_8 = _jspx_th_impact_sortableColumnHeader_8.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">County&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_9.setOrderBy(DynamicWorkloadDAO.SORT_BY_COUNTY);
              int _jspx_eval_impact_sortableColumnHeader_9 = _jspx_th_impact_sortableColumnHeader_9.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Unit&nbsp;\r\n    ");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_10.setOrderBy(DynamicWorkloadDAO.SORT_BY_UNIT);
              int _jspx_eval_impact_sortableColumnHeader_10 = _jspx_th_impact_sortableColumnHeader_10.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </th>\r\n  <th class=\"thList\">Region</th>\r\n  <th class=\"thList\">Stage ID</th>\r\n</tr>\r\n");

  /* SIR 23265 */
  loopCount = 0;
  Enumeration workLoadEnum = rowccmn37doArray.enumerateROWCCMN37DO();
  ROWCCMN37DO workloadRow = null;
  if (workLoadEnum == null || !(workLoadEnum.hasMoreElements())) {

              out.write("\r\n<tr class=\"odd\">\r\n  <td colspan=\"14\">\r\n    ");
              out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_EMPTY_WORKLOAD));
              out.write("\r\n  </td>\r\n</tr>\r\n");

} else {
  while (workLoadEnum.hasMoreElements()) {
    workloadRow = (ROWCCMN37DO) workLoadEnum.nextElement();

    String cdRecidivism = workloadRow.getSzCdRecidivism();
    String cdRcvm;
    if (CodesTables.CAPSRCM_1.equals(cdRecidivism)) {
      cdRcvm = "M";
    } else if (CodesTables.CAPSRCM_2.equals(cdRecidivism)) {
      cdRcvm = "O";
    } else if (CodesTables.CAPSRCM_3.equals(cdRecidivism)) {
      cdRcvm = "O/M";
    }



              out.write("\r\n<tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n  ");
String checkId = "cbx_" + loopCount;
              out.write("\r\n  <td>\r\n      ");
              out.write("\r\n    ");

      if (!"OT".equals(workloadRow.getSzCdMobileStatus())) {
        if (pageMode.equals(PageModeConstants.VIEW)) {
    
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_0.setType("checkbox");
              _jspx_th_impact_validateInput_0.setValue(String.valueOf( loopCount ));
              _jspx_th_impact_validateInput_0.setId(checkId);
              _jspx_th_impact_validateInput_0.setName(checkId);
              _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_0.setDisabled("true");
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    ");
} else {
              out.write("\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_1.setType("checkbox");
              _jspx_th_impact_validateInput_1.setValue(String.valueOf( loopCount ));
              _jspx_th_impact_validateInput_1.setId(checkId);
              _jspx_th_impact_validateInput_1.setName(checkId);
              _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n    ");

        }
      }
    
              out.write("\r\n  </td>\r\n  <td align=\"center\">");
              out.print("Y".equals(workloadRow.getBIndCaseSensitive())
                        ? "<div class=\"formSensitiveText\">!</div>" : "");
              out.write("\r\n  </td>\r\n  <td>");
              out.print("PR".equals(workloadRow.getSzCdStagePersRole()) ? "P" : "S");
              out.write("\r\n  </td>\r\n    ");
              out.write("\r\n  <td>");
              out.print(AssignedWorkloadConversation.NEW_INDICATORS.contains(workloadRow.getBIndStagePersEmpNew())
         ? "<b>#</b>" : "");
              out.write("<a href='");
              out.print(workloadRow.getUlIdCase() != 0
                                              ? "javascript:caseSummaryHyperlink( \"" + loopCount + "\", \""
                                                + GlobalData.getUlIdStage( request ) + "\" );"
                                              : "javascript:eventListHyperlink( \"" + loopCount + "\" );");
              out.write("'\r\n                               onClick=\"window.onBeforeUnload=null;\" tabIndex=\"");
              out.print(tabIndex++);
              out.write("\"\r\n          >");
              out.print(StringHelper.isValid(workloadRow.getSzNmStage())
              ? workloadRow.getSzNmStage() : TWENTY_FOUR_NON_BREAKING_SPACES);
              out.write("\r\n  </a></td>\r\n  <td>");
              out.print(workloadRow.getSzCdStage() != null ? Lookup.simpleDecodeSafe("CTXTOGA", workloadRow.getSzCdStage()) : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getBIndHomeIveReimbursable() != null ? workloadRow.getBIndHomeIveReimbursable() : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td><span title='");
              out.print(workloadRow.getSzCdRsrcFaHomeStatus() != null ? Lookup.simpleDecodeSafe("CFAHMSTA", workloadRow.getSzCdRsrcFaHomeStatus()) : "" );
              out.write("'>\r\n        ");
              out.print(workloadRow.getSzCdRsrcFaHomeStatus() != null ? workloadRow.getSzCdRsrcFaHomeStatus() : "&nbsp;");
              out.write("\r\n      </span>\r\n  </td>\r\n  ");
              out.write("\r\n  <td>\r\n    ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_0.setTest(((workloadRow.getNbrErrors() > 0)||(workloadRow.getNbrWarnings() > 0)));
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n  \t  <span style=\"color:red\">");
                  out.print(workloadRow.getNbrErrors() > 0 ? workloadRow.getNbrErrors() : "0");
                  out.write("</span>&nbsp;/&nbsp;\r\n  \t  <span style=\"color:blue\">");
                  out.print(workloadRow.getNbrWarnings() > 0 ? workloadRow.getNbrWarnings() : "0");
                  out.write("</span>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n  </td> \r\n\r\n  <td>");
              out.print(workloadRow.getSzCdRiskLvl() != null ? workloadRow.getSzCdRiskLvl() : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getSzCdStageCurrPriority() != null ? workloadRow.getSzCdStageCurrPriority() : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getDtDtStagePersLink() != null ? FormattingHelper.formatDate(workloadRow.getDtDtStagePersLink()) :
         "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getUlIdCase() != 0 ? FormattingHelper.formatInt(workloadRow.getUlIdCase()) : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(FormattingHelper.changeCase(Lookup.simpleDecodeSafe("CCOUNT", workloadRow.getSzCdStageCnty())));
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getSzNbrUnit() != null ? workloadRow.getSzNbrUnit() : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getSzCdStageRegion() != null ? workloadRow.getSzCdStageRegion() : "&nbsp;");
              out.write("\r\n  </td>\r\n  <td>");
              out.print(workloadRow.getUlIdStage() != 0 ? FormattingHelper.formatInt(workloadRow.getUlIdStage()) : "&nbsp;" );
              out.write("\r\n  </td>\r\n</tr>\r\n");

      loopCount++;
    }
  }

              out.write("\r\n</table>\r\n</div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("totalStages");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Total Stages");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatInt(ccmn14so.getUlWorkloadCount()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
 if (ccmn14so.getBIndOverPolicyLimit() == true) {
          out.write("\r\n    <td>*</td>\r\n    ");
 } 
          out.write("\r\n  </tr>\r\n</table>\r\n");

  //*****************
  //**** BUTTONS ****
  //*****************
  // Display the Assign and Stage Progression buttons unless the page mode is VIEW. If page
  // mode is VIEW, display a <br> to put a empty line.
  if (!pageMode.equals(PageModeConstants.VIEW)) {
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"72%\">&nbsp;</td>\r\n    <td class=\"alignRight\" width=\"10%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnAssign");
          _jspx_th_impact_ButtonTag_0.setImg("btnAssign");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmAssignedWorkload");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/AssignedWorkload/assignStage");
          _jspx_th_impact_ButtonTag_0.setFunction("enableValidation( 'frmAssignedWorkload' );");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\" width=\"18%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnStageProgression");
          _jspx_th_impact_ButtonTag_1.setImg("btnStageProgression");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmAssignedWorkload");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/AssignedWorkload/stageProgression");
          _jspx_th_impact_ButtonTag_1.setFunction("enableValidation( 'frmAssignedWorkload' );");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

} else {
          out.write("\r\n<br>\r\n");

  }

          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
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
      out.write("      \r\n<br>      \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">      \r\n  <tr>      \r\n     <th colspan=\"4\">Reports</th>      \r\n   </tr>      \r\n   <tr>      \r\n     <td>      \r\n       ");
      //  impact:reportList
      gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag _jspx_th_impact_reportList_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag();
      _jspx_th_impact_reportList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_reportList_0.setParent(null);
      _jspx_th_impact_reportList_0.setPersonId( user.getUserID() );
      _jspx_th_impact_reportList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_reportList_0 = _jspx_th_impact_reportList_0.doStartTag();
      if (_jspx_eval_impact_reportList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("      \r\n         ");
          //  impact:report
          gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag _jspx_th_impact_report_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportTag();
          _jspx_th_impact_report_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_report_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_reportList_0);
          _jspx_th_impact_report_0.setUseHiddenParameters(false);
          _jspx_th_impact_report_0.setReportName("WorkloadReport00");
          _jspx_th_impact_report_0.setEmailMessage( "Workload Report: " + workloadPersonName );
          int _jspx_eval_impact_report_0 = _jspx_th_impact_report_0.doStartTag();
          if (_jspx_eval_impact_report_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("      \r\n           ");
              //  impact:reportParameter
              gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
              _jspx_th_impact_reportParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_reportParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_0);
              _jspx_th_impact_reportParameter_0.setValue( "" + workloadPersonID );
              int _jspx_eval_impact_reportParameter_0 = _jspx_th_impact_reportParameter_0.doStartTag();
              if (_jspx_th_impact_reportParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("         \r\n           ");
              if (_jspx_meth_impact_reportParameter_1(_jspx_th_impact_report_0, _jspx_page_context))
                return;
              out.write("       \r\n         ");
              int evalDoAfterBody = _jspx_th_impact_report_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_report_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("      \r\n       ");
          int evalDoAfterBody = _jspx_th_impact_reportList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_reportList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("      \r\n     </td>      \r\n   </tr>      \r\n   </table>      \r\n");
      out.write("  \r\n\r\n");

  if (focusElement != null) {

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  function focusOnCheck()\r\n  {\r\n    document.frmAssignedWorkload.");
      out.print(focusElement);
      out.write(".focus();\r\n  }\r\n  window.attachEvent(\"onload\", focusOnCheck);\r\n</script>\r\n");

  }

      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_impact_reportParameter_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_report_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:reportParameter
    gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag _jspx_th_impact_reportParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.reports.ReportParameterTag();
    _jspx_th_impact_reportParameter_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_reportParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_report_0);
    _jspx_th_impact_reportParameter_1.setValue("0");
    int _jspx_eval_impact_reportParameter_1 = _jspx_th_impact_reportParameter_1.doStartTag();
    if (_jspx_th_impact_reportParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
