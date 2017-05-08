package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN29SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN29SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.workload.UnitSummaryConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.UnitSummarySearchBean;
import java.util.Enumeration;
import java.util.StringTokenizer;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicUnitEmpLinkDAO;

public final class UnitSummary_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  //*  JSP Name:     Unit Summary
  //*  Created by:   Michael Ochu
  //*  Date Created: 12/14/2002
  //*
  //*  Description:
  //*  This JSP is used by users with appropriate security profile
  //* and approval responsibility for a unit to view their unit's current activity.
  //* The user can then enter their workers' To-Do List and Assigned Workload in order to
  //* view or modify anything within their unit's responsibility
  //*
  //** Change History:
  //**  Date      User              Description
  //**  --------  ----------------  --------------------------------------------------
  //**  05/27/03  GRIMSHAN          SIR 17787 -- Make the list box one long section
  //**                              that does not scroll
  //**
  //**  07/09/03  DOUGLACS          SIR 18728 - hyperlink doesn't work if name includes
  //**                              apostrophe
  //**
  //**  03/07/05  thompswa          SIR 18096 - Unit field on Unit Summary page
  //**                              should default to user's unit.
  //**
  //**  06/29/05  casdorjm          SIR 23689 - added two new columns INV+30 and SVC+60
  //**                              and hyperlinks on both.  Also modified the submitPersonId()
  //**                              method to include the filterBy parameter.  These new links
  //**                              will only be displayed for APS units
  //**
  //**  08/23/06  abgoode        Updates for GA SACWIS completed, including:
  //**                - Program replaced by County
  //**                - Assignments per stage added to search results, sortable
  //**  03/17/08 	aroberts		  Renamed the RD_COLUMN to FAD_COLUMN and added the PFC COLUMN to be displayed
  //**  07/17/08  wjcochran		   Added 'Direct Reporting Units' information as per MR-017
  //**	12/03/08  wjcochran		   STGAP00010660: modified direct reporting region to read from the
  //**								actual unit region and not the region of the currently displayed unit.


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);

  String szCdUnitCounty = userProfile.getUserCounty();
  String szCdUnitRegion = userProfile.getUserRegion();
  String txtszNbrUnit = userProfile.getUserUnit(); // SIR 18096
  String rbSameName = "";
  String primaryAssignment = "false";
  String totalAssignment = "false";
  boolean hasChildUnits = true;

  UnitSummarySearchBean unitSummarySearchBean = (UnitSummarySearchBean) request
                                                                               .getAttribute(UnitSummaryConversation.UNIT_SUMMARY_BEAN);

  if (unitSummarySearchBean != null) {
    szCdUnitCounty = unitSummarySearchBean.getCounty();
    szCdUnitRegion = unitSummarySearchBean.getRegion();
    txtszNbrUnit = unitSummarySearchBean.getUnit();
    rbSameName = unitSummarySearchBean.getAssignments();
    //UnitSummarySearchBean is already in global data, if the search was successful
    //since we no longer need the value in the request, we remove it
    request.removeAttribute(UnitSummaryConversation.UNIT_SUMMARY_BEAN);
  }

  if ("1".equals(rbSameName)) {
    primaryAssignment = "false";
    totalAssignment = "true";
  } else if ("2".equals(rbSameName)) {
    totalAssignment = "false";
    primaryAssignment = "true";
  }

  int tabIndex = 1;
  int loopCount = 0;

  CCMN29SO ccmn29so = (CCMN29SO) state.getAttribute("CCMN29SO", request);
  ROWCCMN29SOG01_ARRAY unitArray = null;
  if (ccmn29so == null) {
    ccmn29so = new CCMN29SO();
  }
  if (ccmn29so.getROWCCMN29SOG01_ARRAY() != null) {
    unitArray = ccmn29so.getROWCCMN29SOG01_ARRAY();
  } else {
    unitArray = new ROWCCMN29SOG01_ARRAY();
  }
  
  // Contains child unit information
  CCMN24SO ccmn24so = (CCMN24SO) state.getAttribute("CCMN24SO", request);

  // Initialize the row and array objects
  if (ccmn24so == null) {
	ccmn24so = new CCMN24SO();
	hasChildUnits = false;
  }

  ROWCCMN24SOG01_ARRAY reportingUnitsInfoRowArray = null;

  // Null catch for ROW objects, if not null get rows
  if ( ccmn24so.getROWCCMN24SOG01_ARRAY() != null 
  		&& ccmn24so.getROWCCMN24SOG01_ARRAY().getROWCCMN24SOG01Count() > 0)
  {
    reportingUnitsInfoRowArray = ccmn24so.getROWCCMN24SOG01_ARRAY();
  } else
  {
    reportingUnitsInfoRowArray = new ROWCCMN24SOG01_ARRAY();
    hasChildUnits = false;
  }
  
  

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n// This function is used to pass the person id and person name to the assigned\r\n// workload page.\r\nfunction submitPersonID( personId, personNmWorkload, filter )\r\n{\r\n  document.frmUnitSummary.personId.value = personId;\r\n  document.frmUnitSummary.personNmWorkload.value = personNmWorkload;\r\n  document.frmUnitSummary.filterBy.value = filter;\r\n  disableValidation( \"frmUnitSummary\" );\r\n  submitValidateForm( \"frmUnitSummary\", \"/workload/UnitSummary/callAssignedWorkload\" );\r\n}\r\n\r\n// Custom function to handle submitting the form via links in a list\r\nfunction submitFormUnitSummary( counter )\r\n{\r\n    document.frmUnitSummary.counter.value = counter;\r\n        // then call submitValidateForm()\r\n    submitValidateForm( \"frmUnitSummary\", \"/workload/UnitSummary/displayUnitSummary\" );\r\n}\r\n\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmUnitSummary");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/UnitSummary/searchUnitSummary");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\"\r\n\t\twidth=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tSearch Criteria\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCounty");
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue(szCdUnitCounty);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selRegDiv");
          _jspx_th_impact_validateSelect_1.setLabel("Reg/Div");
          _jspx_th_impact_validateSelect_1.setCodesTable("CREGDIV");
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setValue(szCdUnitRegion);
          _jspx_th_impact_validateSelect_1.setContentType(SelectTag.CODES_DECODES);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setValue("1");
          _jspx_th_impact_validateInput_0.setChecked(totalAssignment);
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setName("rbSameName");
          _jspx_th_impact_validateInput_0.setLabel("");
          _jspx_th_impact_validateInput_0.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\tTotal Assignments\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setValue("2");
          _jspx_th_impact_validateInput_1.setChecked(primaryAssignment);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName("rbSameName");
          _jspx_th_impact_validateInput_1.setLabel("");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t\tTotal Primary Assignments\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setName("txtszNbrUnit");
          _jspx_th_impact_validateInput_2.setConstraint("AlphaNumeric2Unit");
          _jspx_th_impact_validateInput_2.setLabel("Unit");
          _jspx_th_impact_validateInput_2.setRequired("true");
          _jspx_th_impact_validateInput_2.setValue(txtszNbrUnit);
          _jspx_th_impact_validateInput_2.setSize("2");
          _jspx_th_impact_validateInput_2.setMaxLength("2");
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSearchFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnSearch");
          _jspx_th_impact_ButtonTag_0.setBackSafe("true");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setForm("frmUnitSummary");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/UnitSummary/searchUnitSummary");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t");

	  ROWCCMN29SOG01_ARRAY rowccmn29sog01_array = ccmn29so.getROWCCMN29SOG01_ARRAY();
	    if ((rowccmn29sog01_array != null) && (rowccmn29sog01_array.getUlRowQty() > 0)) {
	
          out.write("\r\n\t<br>\r\n\t");

	  /* Begin Result List Division  */
	      // SIR 17787 GRIMSHAN Remove the scroll bar, make it one long displayed section
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/workload/UnitSummary/displayUnitSummary");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\t\tclass=\"tableborder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"tableBG\">\r\n\t\t\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\t\t\t\t\tclass=\"tableborderList\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tName\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\" align=\"center\">\r\n\t\t\t\t\t\t\t\tIn Unit\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t    <th class=\"thList\">\r\n\t\t\t\t\t\t  \t  <span style=\"color:red\">E</span>&nbsp;/&nbsp;<span style=\"color:blue\">W</span>&nbsp;\r\n\t\t\t\t\t\t    </th>\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tINT&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(DynamicUnitEmpLinkDAO.INT_COLUMN);
              _jspx_th_impact_sortableColumnHeader_0.setIsDefault("true");
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tINV&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(DynamicUnitEmpLinkDAO.INV_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tDIV&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(DynamicUnitEmpLinkDAO.DIV_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tONG&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_3.setOrderBy(DynamicUnitEmpLinkDAO.ONG_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_3 = _jspx_th_impact_sortableColumnHeader_3.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tFC&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_4.setOrderBy(DynamicUnitEmpLinkDAO.FC_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_4 = _jspx_th_impact_sortableColumnHeader_4.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tADO&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_5.setOrderBy(DynamicUnitEmpLinkDAO.ADO_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_5 = _jspx_th_impact_sortableColumnHeader_5.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tPAD&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_6.setOrderBy(DynamicUnitEmpLinkDAO.PAD_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_6 = _jspx_th_impact_sortableColumnHeader_6.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t");

							  // STGAP00006019 Change the RD heading to FAD and add PFC stage  to view
							
              out.write("\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tFAD&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_7.setOrderBy(DynamicUnitEmpLinkDAO.FAD_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_7 = _jspx_th_impact_sortableColumnHeader_7.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tPFC&nbsp;\r\n\t\t\t\t\t\t\t\t");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_8.setOrderBy(DynamicUnitEmpLinkDAO.PFC_COLUMN);
              int _jspx_eval_impact_sortableColumnHeader_8 = _jspx_th_impact_sortableColumnHeader_8.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thList\">\r\n\t\t\t\t\t\t\t\tTotal\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t\t<th class=\"thListRight\">\r\n\t\t\t\t\t\t\t\tStaff ID\r\n\t\t\t\t\t\t\t</th>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  loopCount = 0;
						        Enumeration unitEnumeration5 = unitArray.enumerateROWCCMN29SOG01();
						        ROWCCMN29SOG01 unitRow = null;

						        while (unitEnumeration5.hasMoreElements()) {
						          unitRow = (ROWCCMN29SOG01) unitEnumeration5.nextElement();
						          //SIR 18728 - hyperlink doesn't work with names that include apostrophe
						          StringBuffer strTemp = new StringBuffer();
						          StringTokenizer split = new StringTokenizer(unitRow.getSzNmPersonFull(), "'");
						          strTemp.append(split.nextToken());
						          while (split.hasMoreTokens()) {
						            strTemp.append("\\'");
						            strTemp.append(split.nextToken());
						          }
						
              out.write("\r\n\t\t\t\t\t\t<tr class=\"");
              out.print(FormattingHelper.getRowCss(loopCount + 1));
              out.write("\"\r\n\t\t\t\t\t\t\tvalign=\"top\">\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t<a\r\n\t\t\t\t\t\t\t\t\thref=\"javascript: submitPersonID('");
              out.print(unitRow.getUlIdPerson());
              out.write("' , '");
              out.print(strTemp);
              out.write("', '' )\">");
              out.print(unitRow.getSzNmPersonFull());
              out.write("</a>\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td align=\"center\">\r\n\t\t\t\t\t\t\t\t");

								  if ("IN".equalsIgnoreCase(unitRow.getSzCdUnitMemberInOut())) {
								
              out.write("<img\r\n\t\t\t\t\t\t\t\t\talt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\"\r\n\t\t\t\t\t\t\t\t\tborder=\"0\">\r\n\t\t\t\t\t\t\t\t");

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t    ");
              out.write("\r\n\t\t\t\t\t\t    <td width=60px>\r\n\t\t\t\t\t\t      ");
              //  impact:ifThen
              gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
              _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_ifThen_0.setTest(((unitRow.getNbrErrors() > 0)||(unitRow.getNbrWarnings() > 0)));
              int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
              if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\t\t\t\t\t\t  \t    <span style=\"color:red\">");
                  out.print(unitRow.getNbrErrors() > 0 ? unitRow.getNbrErrors() : "0");
                  out.write("</span>&nbsp;/&nbsp;\r\n\t\t\t\t\t\t  \t    <span style=\"color:blue\">");
                  out.print(unitRow.getNbrWarnings() > 0 ? unitRow.getNbrWarnings() : "0");
                  out.write("</span>\r\n\t\t\t\t\t\t      ");
                  int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n\t\t\t\t\t\t    </td>\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  //-- a value of -1 in these fields represents "data not found or available"
								          //-- refer to RetrieveUnitSummaryImpl.findUnitEmp
								          if (unitRow.getUlNbrINT() != -1) {
								
              out.print(unitRow.getUlNbrINT());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrINV() != -1) {
								
              out.print(unitRow.getUlNbrINV());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrDIV() != -1) {
								
              out.print(unitRow.getUlNbrDIV());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrONG() != -1) {
								
              out.print(unitRow.getUlNbrONG());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrFC() != -1) {
								
              out.print(unitRow.getUlNbrFC());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrADO() != -1) {
								
              out.print(unitRow.getUlNbrADO());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrPAD() != -1) {
								
              out.print(unitRow.getUlNbrPAD());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrFAD() != -1) {
								
              out.print(unitRow.getUlNbrFAD());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlNbrPFC() != -1) {
								
              out.print(unitRow.getUlNbrPFC());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");

								  if ("true".equals(primaryAssignment) || "true".equals(totalAssignment)) {
								
              out.write("\r\n\t\t\t\t\t\t\t\t");
              out.print(unitRow.getUsScrNbrTotPAssignments());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td align=\"right\">\r\n\t\t\t\t\t\t\t\t");

								  if (unitRow.getUlIdPerson() != -1) {
								
              out.print(unitRow.getUlIdPerson());
              out.write("\r\n\t\t\t\t\t\t\t\t");

								  } else {
								
              out.write('n');
              out.write('/');
              out.write('a');

								  }
								
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

						  loopCount++;
						        } // end while
						
              out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<br>\r\n\r\n\t");

	  }
	
          out.write("\r\n\t<input type=\"hidden\" name=\"filterBy\" value=\"\">\r\n\t<input type=\"hidden\" name=\"personId\" value=\"\">\r\n\t<input type=\"hidden\" name=\"personNmWorkload\" value=\"\">\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n");

  if (hasChildUnits) {

          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborderList\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tDirect Reporting Units\r\n\t\t\t\t</th>\r\n\t\t\t<tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorderList\">\r\n\t\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t\t<td class=\"thList\">\r\n\t\t\t\t\t\t\t\tUnit\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td class=\"thList\">\r\n\t\t\t\t\t\t\t\tUnit Approver\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td class=\"thList\">\r\n\t\t\t\t\t\t\t\tSpecialization\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");
int reportingUnitsLoopCount = 0;
						for (Enumeration<ROWCCMN24SOG01> e = reportingUnitsInfoRowArray.enumerateROWCCMN24SOG01(); e.hasMoreElements();) {
          ROWCCMN24SOG01 reportingUnitsInfoRow =  e.nextElement();
          String ruSzNmPersonFull = FormattingHelper.formatString(reportingUnitsInfoRow.getSzNmPersonFull());
 		  String ruSzCdUnitSpecialization = FormattingHelper.formatString(reportingUnitsInfoRow.getSzCdUnitSpecialization());
          
          out.write("\r\n\t\t\t\t\t\t<tr class=\"");
          out.print( FormattingHelper.getRowCss( reportingUnitsLoopCount + 1 ) );
          out.write("\">\r\n\t\t\t\t\t      <td>\r\n\t\t\t\t\t      ");
 int ruIdUnit = reportingUnitsInfoRow.getUlIdUnit();
        					 String ruNbrUnit = reportingUnitsInfoRow.getSzNbrUnit();
        					 String ruCounty = reportingUnitsInfoRow.getSzCdUnitCounty();
        					 // Need to get ru Region, using the user's region could cause errors
        					 // in case of viewing regional directors' units
        					 String ruRegion = reportingUnitsInfoRow.getSzCdUnitRegion();
        				 	 if(ruIdUnit >= 0 && ruNbrUnit != null){
					      
          out.write("\r\n\t\t\t\t          <a href=\"/workload/UnitSummary/searchUnitSummary?txtszNbrUnit=");
          out.print( ruNbrUnit );
          out.write("&selCounty=");
          out.print( ruCounty );
          out.write("&selRegDiv=");
          out.print( ruRegion );
          out.write("\" >\r\n\t\t\t\t            ");
          out.print( ruNbrUnit );
          out.write("\r\n\t\t\t\t          </a>\r\n                          ");
 } else{ 
          out.write("\r\n                               &nbsp;\r\n                          ");
 } 
          out.write("\r\n                          </td>\r\n                          <td>\r\n                          ");
  if (ruSzNmPersonFull.equals("") || ruSzNmPersonFull == null) { 
          out.write("\r\n                                 &nbsp;\r\n                          ");
  } else { 
          out.write("\r\n                                ");
          out.print( ruSzNmPersonFull );
          out.write("\r\n                          ");
  } 
          out.write("\r\n                          </td>\r\n                          <td>\r\n                          ");
 if(ruSzCdUnitSpecialization != null){ 
          out.write("\r\n                          ");
          out.print( ( ruSzCdUnitSpecialization.length() != 0 ) ? Lookup.simpleDecode( CodesTables.CSPCUNTS, ruSzCdUnitSpecialization ) : "" );
          out.write("\r\n                          ");
 } else{ 
          out.write("\r\n                          ");
          out.print( "" );
          out.write("\r\n                          ");
 } 
          out.write("\r\n                          </td>\r\n\t\t\t\t\t\t</tr>\r\n\r\n");

          reportingUnitsLoopCount++;
        }

          out.write("\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t</table>\r\n");

  }

          out.write("\r\n\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

  /* Close Validate Form Custom Tag */

      out.write("\r\n\r\n\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmUnitSummary");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
