package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN13DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSearchConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class CaseList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Case List
//*  Created by:   Jonathan Hardy
//*  Date Created: 1/08/03
//*
//*  Description:
//*  This JSP displays the results of a Case Search or a search for cases associated
//*  with a particular user.  If the case is not sensitive, or if it is and the user
//*  can view sensitive cases, the Case ID is included in the list as a hyperlink
//*  that takes the user to Case Summary.
//*
//** Change History:
//**  Date        User              Description
//**  --------    ----------------  --------------------------------------------------
//**  3-21-2002   Eric Dickman      QA Sweep/
//**  6-18-2003   LAURAMC           sir 18133 - corrected Program type from APSFAC to
//**                                AFC by removing the decode request in the td for
//**                                addressRow.getSzCdCaseProgram()
//**  8-08-2005   CASDORJM          SIR 22559 - Added sort capabilities on list
//**  11/21/2008  arege             Per STGAP00010463 changed the style attribute to fix the
//**                                formatting problem.
//**  02/05/2010  wcochran          SMS #43758: Added variable indUseStageCode for use
//**                                in determining which order by clause to use when
//**                                sorting by stage.

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Set the page mode
  String pageMode = PageModeConstants.EDIT;

  // Replacing the old with the below status string as of 07/28/2006
  String status = "";

  int personId = 0;
  int tabIndex = 1;
  try
  {
    Integer personIdFromAttr = (Integer)request.getAttribute("SearchCasePersonID");
    if (personIdFromAttr != null)
    {
      personId = personIdFromAttr;
    }
    else
    {
      String personIdFromParam = request.getParameter("txtUlIdPerson");
      if ((personIdFromParam != null) && !"".equals(personIdFromParam))
      {
        personId = Integer.parseInt(personIdFromParam);
      }
    }
  }
  catch (Exception e)
  {
    
      out.write("<!-- An exception occured trying to retrieve personID from the session. -->");

  }

  String txtUlIdCase = ContextHelper.getStringSafe(request, "txtUlIdCase");
  String txtSzNmCase = ContextHelper.getStringSafe(request, "txtSzNmCase");
  String txtSzNmCaseLast = ContextHelper.getStringSafe(request, "txtSzNmCaseLast");
  String txtSzNmCaseFirst = ContextHelper.getStringSafe(request, "txtSzNmCaseFirst");
  String txtSzNmCaseMiddle = ContextHelper.getStringSafe(request, "txtSzNmCaseMiddle");
  String selSzCdCaseCounty = ContextHelper.getStringSafe(request, "selSzCdCaseCounty");
  String selSzCdCaseProgram = ContextHelper.getStringSafe(request, "selSzCdCaseProgram");
  String selSzCdCaseRegion = ContextHelper.getStringSafe(request, "selSzCdCaseRegion");
  String hdnSzAddrCity = ContextHelper.getStringSafe(request, "hdnSzAddrCity");
  String txtUlIdCaseManager = ContextHelper.getStringSafe( request, "txtUlIdCaseManager");
  String txtSzNmCaseManagerFirst = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerFirst");
  String txtSzNmCaseManagerLast = ContextHelper.getStringSafe( request, "txtSzNmCaseManagerLast");
  String txtDtDtLastUpdate = ContextHelper.getStringSafe( request, "txtDtDtLastUpdate");
  String selSzCdCpsInvstDtlOvrllDisptn = ContextHelper.getStringSafe( request, "selSzCdCpsInvstDtlOvrllDisptn");
  String selSzCdStage = ContextHelper.getStringSafe( request, "selSzCdStage");
  String txtSzNbrUnit = ContextHelper.getStringSafe( request, "txtSzNbrUnit");
  String selRbOpenClose = ContextHelper.getStringSafe( request, "selRbOpenClose");
  String strIndUseStageCode = (String) request.getAttribute("indUseStageCode");

      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/CaseSearch/displayCaseSummary");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_5.setValue(String.valueOf(personId));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("txtUlIdCase");
          _jspx_th_impact_validateInput_6.setValue(txtUlIdCase);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("txtSzNmCase");
          _jspx_th_impact_validateInput_7.setValue(txtSzNmCase);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("txtSzNmCaseLast");
          _jspx_th_impact_validateInput_8.setValue(txtSzNmCaseLast);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("txtSzNmCaseFirst");
          _jspx_th_impact_validateInput_9.setValue(txtSzNmCaseFirst);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("txtSzNmCaseMiddle");
          _jspx_th_impact_validateInput_10.setValue(txtSzNmCaseMiddle);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName("selSzCdCaseCounty");
          _jspx_th_impact_validateInput_11.setValue(selSzCdCaseCounty);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("selSzCdCaseProgram");
          _jspx_th_impact_validateInput_12.setValue(selSzCdCaseProgram);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("hidden");
          _jspx_th_impact_validateInput_13.setName("selSzCdCaseRegion");
          _jspx_th_impact_validateInput_13.setValue(selSzCdCaseRegion);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("hidden");
          _jspx_th_impact_validateInput_14.setName("hdnSzAddrCity");
          _jspx_th_impact_validateInput_14.setValue(hdnSzAddrCity);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("hidden");
          _jspx_th_impact_validateInput_15.setName("txtUlIdCaseManager");
          _jspx_th_impact_validateInput_15.setValue(txtUlIdCaseManager);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("hidden");
          _jspx_th_impact_validateInput_16.setName("txtSzNmCaseManagerFirst");
          _jspx_th_impact_validateInput_16.setValue(txtSzNmCaseManagerFirst);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName("txtSzNmCaseManagerLast");
          _jspx_th_impact_validateInput_17.setValue(txtSzNmCaseManagerLast);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName("txtDtDtLastUpdate");
          _jspx_th_impact_validateInput_18.setValue(txtDtDtLastUpdate);
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName("selSzCdStage");
          _jspx_th_impact_validateInput_19.setValue(selSzCdStage);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName("txtSzNbrUnit");
          _jspx_th_impact_validateInput_20.setValue(txtSzNbrUnit);
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("hidden");
          _jspx_th_impact_validateInput_21.setName("selSzCdCpsInvstDtlOvrllDisptn");
          _jspx_th_impact_validateInput_21.setValue(selSzCdCpsInvstDtlOvrllDisptn);
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("indUseStageCode");
          _jspx_th_impact_validateInput_22.setValue(strIndUseStageCode );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<TEXTAREA ID=\"holdtext\" STYLE=\"display:none;\">\r\n</TEXTAREA>\r\n");

  // Get the CCMN20SO output object out of the request
  CCMN20SO ccmn20so = (CCMN20SO) request.getAttribute("CCMN20SO");
  // Initialize the row and array objects
  ROWCCMN13DO_ARRAY addressArray = null;
  // Null catch for ccmn20so, if null set to blank (initialize)
  if ( ccmn20so == null )
  {
    ccmn20so = new CCMN20SO();
  }
  // Null catch for ROW objects, if not null get rows
  if ( ccmn20so.getROWCCMN13DO_ARRAY() != null )
  {
    addressArray = ccmn20so.getROWCCMN13DO_ARRAY();
  } else
  {
    addressArray = new ROWCCMN13DO_ARRAY();
  }


  // Assign tabIndex
  //unused
  //int tabIndex = 1;
  // needed for for loops
  int loopCount = 0;

  UserProfile user = UserProfileHelper.getUserProfile( request );
  //unused
  //boolean canViewSensitiveCases = user.hasRight(user.SEC_SENSITIVE_CASE_ACCESS);
  //boolean canViewPADStage = user.hasRight(user.)


          out.write("\r\n\r\n<Script Language=\"JavaScript\">\r\n\r\n  function submitCaseSearch(caseId, stageCd, caseNm, caseProgram)\r\n  {\r\n    document.frmCaseList.hdnUlIdCase.value = caseId;\r\n    document.frmCaseList.hdnSzCdStage.value = stageCd;\r\n    document.frmCaseList.hdnSzNmCase.value = caseNm;\r\n    document.frmCaseList.hdnSzCdCaseProgram.value = caseProgram;\r\n    submitValidateForm( \"frmCaseList\", \"/workload/CaseSearch/displayCaseSummary\" );\r\n  }\r\n\r\n  function verifyFiveOrLess(cbx)\r\n  {\r\n    var numChecked = document.frmCaseList.hdnCopyCheckedNum.value;\r\n    if (cbx.checked)\r\n    {\r\n      if (numChecked == 5)\r\n      {\r\n        alert(\"You can select a maximum of 5 rows to copy into the clipboard.\");\r\n        cbx.checked = false;\r\n      }\r\n      else\r\n      {\r\n        document.frmCaseList.hdnCopyCheckedNum.value = ++numChecked;\r\n      }\r\n      return;\r\n    }\r\n    else\r\n    {\r\n      document.frmCaseList.hdnCopyCheckedNum.value = --numChecked;\r\n    }\r\n  }\r\n\r\n  function populateClipboard()\r\n  {\r\n    var firstElement = true;\r\n\r\n    if (document.frmCaseList.hdnCopyCheckedNum.value == 0)\r\n");
          out.write("    {\r\n      alert(\"No Row Selected!\");\r\n    }\r\n    else\r\n    {\r\n      var firstRow = true;\r\n      var clipString = \"\";\r\n      for (var i = 0; i < ");
          out.print( addressArray.getUlRowQty() );
          out.write("; i++)\r\n      {\r\n        var checkbox = eval(\"document.frmCaseList.caseCopy_\" + i);\r\n        if (checkbox.checked)\r\n        {\r\n          if (!firstRow)\r\n          {\r\n            clipString += \"\\n\";\r\n          }\r\n          else\r\n          {\r\n            firstRow = false;\r\n          }\r\n          clipString += checkbox.value;\r\n        }\r\n      }\r\n      var hiddenText = document.getElementById(\"holdText\");\r\n      hiddenText.value = clipString;\r\n      Copied = hiddenText.createTextRange();\r\n      // execCommand is an IE-specific method.  Not supported in Netscape.\r\n      Copied.execCommand(\"Copy\")\r\n      alert(\"Data copied to Clipboard.\");\r\n    }\r\n  }\r\n</Script>\r\n\r\n\r\n");
 /* Begin Result List Division (copy from  // Start RLD to // end RLD) */ 
          out.write('\r');
          out.write('\n');
 /* start pagination custom tag  -- closed after table */ 
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/workload/CaseSearch/searchCase");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div id=\"noScrollResults\" style=\"height:155px; width:767px; overflow:auto\" class=\"tableborderList\">\r\n<!-- My original table -->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <th class=\"thList\">Copy</th>\r\n    <th class=\"thList\">!</th>\r\n    <th class=\"thList\">UTC</th>\r\n    <th class=\"thList\">Case ID</th>\r\n    <th class=\"thList\">Case Name</th>");
//<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_CASE_NAME /%/>"/>
              out.write("\r\n    <th class=\"thList\">Mrg</th>\r\n    <th class=\"thList\">Status</th>");
//<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_STATUS/%/>"/>
              out.write("\r\n    <th class=\"thList\">Date");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_0.setOrderBy(CaseSearchConversation.SORT_BY_DATE );
              int _jspx_eval_impact_sortableColumnHeader_0 = _jspx_th_impact_sortableColumnHeader_0.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n    <th class=\"thList\">Stage");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_1.setOrderBy(CaseSearchConversation.SORT_BY_STAGE );
              int _jspx_eval_impact_sortableColumnHeader_1 = _jspx_th_impact_sortableColumnHeader_1.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n    <th class=\"thList\">County</th>");
//<impact:sortableColumnHeader orderBy="<%=CaseSearchConversation.SORT_BY_COUNTY/%/>"/>
              out.write("\r\n    <th class=\"thList\">Region</th> \r\n    <th class=\"thList\">Case Mgr");
              //  impact:sortableColumnHeader
              gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag _jspx_th_impact_sortableColumnHeader_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.SortableColumnTag();
              _jspx_th_impact_sortableColumnHeader_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_sortableColumnHeader_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_sortableColumnHeader_2.setOrderBy(CaseSearchConversation.SORT_BY_CASE_MANAGER);
              int _jspx_eval_impact_sortableColumnHeader_2 = _jspx_th_impact_sortableColumnHeader_2.doStartTag();
              if (_jspx_th_impact_sortableColumnHeader_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</th>\r\n  </tr>\r\n");


                  loopCount = 0;
                  ROWCCMN13DO addressRow = null;
                  Enumeration addressEnumeration1 = addressArray.enumerateROWCCMN13DO();
                  if ( !addressEnumeration1.hasMoreElements() )
                  {

              out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"7\">\r\n                           ");
              out.print( MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) );
              out.write("\r\n                        </td>\r\n                      </tr>\r\n");

                  }
                    else
                  {

                    while( addressEnumeration1.hasMoreElements() )
                    {
                      addressRow = (ROWCCMN13DO) addressEnumeration1.nextElement();

                      boolean linkRow = true;
                      boolean bUTC = "Y".equals( addressRow.getCScrIndCaseUTC() );
                      String caseName = FormattingHelper.formatStringSpecialChars( addressRow.getSzNmCase(), "'\"\\" );
                      if(addressRow.getDtDtCaseClosed() == null)
                      {
                        status = CodesTables.CINCMGST_OPN;
                      }else{
                        status = CodesTables.CINCMGST_CLD;
                      }
                      if ("Y".equalsIgnoreCase(addressRow.getBIndCaseSensitive()) && !user.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS))
                      {
                        linkRow = false;
                      }
                      if ("FAD".equals(addressRow.getSzCdStage()) && !user.hasRight(UserProfile.SEC_MTN_HOME))
                      {
                        linkRow = false;
                      }
                      String tab = "   ";
                      StringBuffer caseData = new StringBuffer();
                      caseData.append("N".equals(addressRow.getBIndCaseSensitive())?"   ":" !");
                      caseData.append(tab);
                      caseData.append( bUTC ? "UTC" : "       " );
                      caseData.append(tab);
                      caseData.append(addressRow.getUlIdCase());
                      caseData.append(tab);
                      caseData.append(caseName);
                      caseData.append(tab);
                      caseData.append("Y".equals(addressRow.getCScrIndStageMerged())?"MRG":"       ");
                      caseData.append(tab);
                      caseData.append(status);
                      caseData.append(tab);
                      caseData.append(CodesTables.CINCMGST_CLD.equals(status) ? addressRow.getDtDtCaseClosed() : addressRow.getDtDtCaseOpened());
                      caseData.append(tab);
                      caseData.append(Lookup.simpleDecodeSafe(CodesTables.CSTAGES, addressRow.getSzCdStage()));
                      caseData.append(tab);
                      caseData.append(Lookup.simpleDecodeSafe(CodesTables.CCOUNT, addressRow.getSzCdCaseCounty()));
                      caseData.append(tab);
                      caseData.append(Lookup.simpleDecodeSafe(CodesTables.CREGIONS, addressRow.getSzCdCaseRegion()));
                      caseData.append(tab);
                      caseData.append(FormattingHelper.formatStringSpecialChars(addressRow.getSzScrWorkerPrim(), "'\""));
                      caseData.append(tab);
                      String cbNameData = caseData.toString();
                      String checkboxName = "caseCopy_"+loopCount;

              out.write("\r\n\r\n            <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n                <td>\r\n                  ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_23.setType("checkbox");
              _jspx_th_impact_validateInput_23.setValue(cbNameData);
              _jspx_th_impact_validateInput_23.setId(checkboxName);
              _jspx_th_impact_validateInput_23.setName(checkboxName);
              _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_23.setOnClick("verifyFiveOrLess(this)");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n                </td>\r\n                <td>");
 if ("N".equals(addressRow.getBIndCaseSensitive())) {
              out.write("&nbsp;");
} else {
              out.write('!');
}
              out.write("</td>\r\n                <td>");
              out.print( bUTC ? "<img alt='UTC' src='/grnds-docs/images/shared/stopLight.gif'>" : "&nbsp;" );
              out.write("</td> \r\n                <td>");
 if ( linkRow ) { 
              out.write("\r\n          <script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n            var caseName");
              out.print(loopCount);
              out.write(" = '");
              out.print(caseName);
              out.write("';\r\n          </script>\r\n                  <a href=\"javascript:submitCaseSearch('");
              out.print(addressRow.getUlIdCase());
              out.write("', '");
              out.print(addressRow.getSzCdStage());
              out.write("', caseName");
              out.print(loopCount);
              out.write(',');
              out.write(' ');
              out.write('\'');
              out.print(addressRow.getSzCdCaseProgram());
              out.write("')\" tabIndex='");
              out.print(tabIndex++);
              out.write('\'');
              out.write('>');
              out.print( addressRow.getUlIdCase() );
              out.write("</a>\r\n                  ");
 } else { 
              out.write("\r\n                  ");
              out.print( addressRow.getUlIdCase() );
              out.write(' ');
 } 
              out.write("\r\n              </td>\r\n                <td>");
              out.print( addressRow.getSzNmCase() != null? addressRow.getSzNmCase(): "&nbsp;" );
              out.write("</td>\r\n                <td>");
 if("Y".equals(addressRow.getCScrIndStageMerged())) { 
              out.write("\r\n                    <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\"> ");
 } else { 
              out.write("&nbsp;");
 } 
              out.write("\r\n                </td>\r\n                <td>");
              out.print( status );
              out.write("</td>\r\n               <td>");
 if(CodesTables.CINCMGST_CLD.equals(status)) { 
              out.write("\r\n                  ");
              out.print(  FormattingHelper.formatDate( addressRow.getDtDtCaseClosed() ) );
              out.write(' ');
 } else {
              out.write("\r\n                  ");
              out.print( FormattingHelper.formatDate( addressRow.getDtDtCaseOpened() ) );
              out.write(' ');
 }
              out.write("\r\n               </td>\r\n                <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CSTAGES, addressRow.getSzCdStage()) );
              out.write("</td>\r\n                <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CCOUNT, addressRow.getSzCdCaseCounty()) );
              out.write("</td>\r\n                <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CREGIONS, addressRow.getSzCdCaseRegion()));
              out.write("</td>\r\n                <td>");
              out.print( addressRow.getSzScrWorkerPrim() );
              out.write("</td>\r\n            </tr>\r\n");

                     loopCount++;
                    } // end while
                  }

              out.write("\r\n           </table>\r\n</div>");
 /* end div noScrollResults */ 
              out.write('\r');
              out.write('\n');
 /* CLOSE thE ROW thAT HOLDS thE SCROLL BOX */ 
              out.write('\r');
              out.write('\n');
 /* close pagination custom tag */ 
              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("copyToClipboardBottom");
          _jspx_th_impact_ButtonTag_0.setImg("btnCopyToClipboard");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseList");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/CaseSearch/displayCaseSummary");
          _jspx_th_impact_ButtonTag_0.setFunction("populateClipboard();return false;");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 /* end RLD */ 
          out.write('\r');
          out.write('\n');
 /*  Always include this hidden field in your form */ 
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<Script Language=\"JavaScript\">\r\n</Script>\r\n\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmCaseList");
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
    _jspx_th_impact_validateInput_0.setName("hdnUlIdCase");
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
    _jspx_th_impact_validateInput_1.setName("hdnSzCdStage");
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
    _jspx_th_impact_validateInput_2.setName("hdnSzNmCase");
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
    _jspx_th_impact_validateInput_3.setName("hdnSzCdCaseProgram");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnCopyCheckedNum");
    _jspx_th_impact_validateInput_4.setValue("0");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
