package org.apache.jsp.grnds_002ddocs.investigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV44SOG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.web.investigation.AllgtnConversation;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact;
import gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegationEvidence;

public final class AllgtnList_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*  JSP Name:     Allegation List
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 11/19/02
//*
//*  Description:
//*   Displays a listing of all allegations for a given stage.
//*   Also calculates overall roles and the stage's overall
//*   disposition if all allegations in the stage have been
//*   addressed.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  06/30/05  floresrj          SIR 23729 Refactored class for Phase II implementation.
//**  08/31/05  floresrj          SIR 23956 Phase III Mobile implementation.
//**  10/17/05  floresrj        SIR 24049 Handle NULL value for Alleged Perpetrator id.
//**  09/08/2009  bgehlot       STGAP00015366: Removed the Alleged Maltreator. 
//**

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
  //  to see how the page functions, but it should always be initialized to view mode.
  //String pageMode = PageMode.VIEW;
  String pageMode = PageModeConstants.EDIT;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request ) != null )
  {
    pageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
  }

  int tabIndex = 1;

      out.write("\r\n\r\n");

  CINV44SO cinv44so = (CINV44SO) request.getAttribute("CINV44SO");
  ROWCINV44SOG_ARRAY allgtnListArray = (ROWCINV44SOG_ARRAY) state.getAttribute( "allgtnListArray", request);
  Enumeration allgtnListEnumerator = null;

  if (cinv44so == null)
  {
    cinv44so = new CINV44SO();
  }
  if (allgtnListArray == null)
  {
    allgtnListArray = new ROWCINV44SOG_ARRAY();
  }
  if (allgtnListArray.enumerateROWCINV44SOG() != null)
  {
    allgtnListEnumerator = allgtnListArray.enumerateROWCINV44SOG();
  }
  String strFacility = "";
  //Facility Mode
  if ( GlobalData.getSzCdStageProgram( request ).equals( CodesTables.CPGRMSFM_AFC ) )
  {
    strFacility = "Facility";
  }

  boolean bDeleteButton = false;
  boolean bDetailButton = false;
  boolean bAddButton = false;

  if ( pageMode.equals( PageModeConstants.MODIFY ))
  {
    bDeleteButton = false;
    bDetailButton = false;
    bAddButton = false;
  }
  else if ( pageMode.equals( PageModeConstants.VIEW ) )
  {
    bDeleteButton = true;
    bDetailButton = true;
    bAddButton = true;
  }

  if (GlobalData.getSzCdStage( request ).equals( CodesTables.CSTAGES_ARI ) )
  {
    bDeleteButton = true;
    bDetailButton = false;
    bAddButton = true;
  }


  //Variable to hold the css class for the each row in the lists
  String rowCss = "odd";
  int allgtnCount = 0;

      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nfunction displayAllgtnDetail(idAllgtn)\r\n{\r\n  document.frmAllgtnList.hdnUlIdAllgtn.value = idAllgtn;\r\n  submitValidateForm( \"frmAllgtnList\", \"/investigation/Allegation/display");
      out.print( strFacility );
      out.write("AllgtnDetail\" );\r\n}\r\n\r\nfunction deleteConfirm()\r\n{\r\n  return confirm('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("');\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAllgtnList");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/investigation/Allegation/displayAllgtnDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/investigation/Allegation/displayAllgtnList");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n<!-- Hidden Fields -->\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_0.setType("hidden");
              _jspx_th_impact_validateInput_0.setName("hdnOverallDisp");
              _jspx_th_impact_validateInput_0.setValue( cinv44so.getCdAllegDisposition() );
              int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
              if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_1.setType("hidden");
              _jspx_th_impact_validateInput_1.setName("hdnValidationOverride");
              _jspx_th_impact_validateInput_1.setEditableMode(EditableMode.EDIT);
              int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
              if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write('\r');
              out.write('\n');
              if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n\r\n");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_4.setType("hidden");
              _jspx_th_impact_validateInput_4.setName("hdnPageMode");
              _jspx_th_impact_validateInput_4.setValue(pageMode);
              int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
              if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n   <div id=\"noScrollResults\" style=\"height:100%; width:100%; overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n      <tr class=\"thList\">\r\n        <th>&nbsp;</th>\r\n        <th>Maltreatment Code</th>\r\n        <th>Alleged Maltreated Child</th>\r\n        <th>Disposition</th>\r\n        <th>Evidence Code</th>\r\n        <th>Stage</th>\r\n        <th>Child ID</th>\r\n      </tr>\r\n      ");

      if ( request.getAttribute( "noRowsReturned" ) != null )
      {
              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"9\">");
              out.print( MessageLookup.getMessageByNumber( Messages.MSG_NO_ROWS_RETURNED ) );
              out.write("</td>\r\n      </tr>\r\n    ");
}
      else
      {
        while( allgtnListEnumerator.hasMoreElements() )
        {
          ROWCINV44SOG allgtnListDetail = (ROWCINV44SOG) allgtnListEnumerator.nextElement();
          rowCss = FormattingHelper.getRowCss( allgtnCount++ + 1 );

          String nmAllgtn = "cbxAllgtn_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
          String nmTS = "hdnTs_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
          String nmTS4 = "hdnTs4_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
          String nmVic = "hdnVic_" + Integer.toString(allgtnListDetail.getUlIdAllegation());
                     
          String evidenceCode = "";
          int allegEvidenceCount = allgtnListDetail.getAllegEvidence_ARRAY().getUlRowQty();
          for (int t = 0; t < allegEvidenceCount; t++) {
            AllegationEvidence allegEvidence = allgtnListDetail.getAllegEvidence_ARRAY().getAllegationEvidence(t);
            evidenceCode =  evidenceCode + allegEvidence.getSzCdEvidenceCode() + " ";
          }
      
              out.write("\r\n      <!-- Allegation Timestamp -->\r\n      ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_5.setType("hidden");
              _jspx_th_impact_validateInput_5.setName( nmTS );
              _jspx_th_impact_validateInput_5.setValue( allgtnListDetail.getTsLastUpdate().toString() );
              int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
              if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      \r\n      <!-- Facility Allegation Timestamp -->\r\n      ");
              //  impact:ifMobileImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
              _jspx_th_impact_ifMobileImpact_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifMobileImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifMobileImpact_0 = _jspx_th_impact_ifMobileImpact_0.doStartTag();
              if (_jspx_eval_impact_ifMobileImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\r\n          ");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifMobileImpact_0);
                _jspx_th_impact_validateInput_6.setType("hidden");
                _jspx_th_impact_validateInput_6.setName( nmTS4 );
                _jspx_th_impact_validateInput_6.setValue( DateHelper.toISOString(allgtnListDetail.getTsSysTsLastUpdate2()) );
                int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
                if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n      ");
              }
              if (_jspx_th_impact_ifMobileImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n       ");
              //  impact:ifServerImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_0 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
              _jspx_th_impact_ifServerImpact_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifServerImpact_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifServerImpact_0 = _jspx_th_impact_ifServerImpact_0.doStartTag();
              if (_jspx_eval_impact_ifServerImpact_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\r\n            ");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_0);
                _jspx_th_impact_validateInput_7.setType("hidden");
                _jspx_th_impact_validateInput_7.setName( nmTS4 );
                _jspx_th_impact_validateInput_7.setValue( allgtnListDetail.getTsSysTsLastUpdate2().toString() );
                int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
                if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("\r\n       ");
              }
              if (_jspx_th_impact_ifServerImpact_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n      <tr class=\"");
              out.print(rowCss);
              out.write("\">\r\n      ");
              if (_jspx_meth_impact_ifMobileImpact_1(_jspx_th_impact_pagination_0, _jspx_page_context))
                return;
              out.write("\r\n    ");
              //  impact:ifServerImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
              _jspx_th_impact_ifServerImpact_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifServerImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifServerImpact_1 = _jspx_th_impact_ifServerImpact_1.doStartTag();
              if (_jspx_eval_impact_ifServerImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\r\n            <td width=\"5%\">");
                //  impact:validateInput
                gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
                _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_1);
                _jspx_th_impact_validateInput_8.setType("checkbox");
                _jspx_th_impact_validateInput_8.setName(nmAllgtn);
                _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatInt( allgtnListDetail.getUlIdAllegation() ) );
                _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
                int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
                if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                  return;
                out.write("</td>\r\n    ");
              }
              if (_jspx_th_impact_ifServerImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n        ");
              //  impact:ifServerImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_2 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
              _jspx_th_impact_ifServerImpact_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifServerImpact_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifServerImpact_2 = _jspx_th_impact_ifServerImpact_2.doStartTag();
              if (_jspx_eval_impact_ifServerImpact_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\r\n          <td><a href=\"#\" tabIndex=\"");
                out.print(tabIndex++);
                out.write("\" onClick=\"displayAllgtnDetail(");
                out.print( allgtnListDetail.getUlIdAllegation());
                out.write(");\">");
                out.print( allgtnListDetail.getSzCdAllegType() );
                out.write("</a></td>\r\n        ");
              }
              if (_jspx_th_impact_ifServerImpact_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n        <td>");
              out.print( allgtnListDetail.getSzScrPersVictim() );
              out.write("</td>\r\n        ");
              //  impact:ifServerImpact
              gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_3 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
              _jspx_th_impact_ifServerImpact_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ifServerImpact_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              int _jspx_eval_impact_ifServerImpact_3 = _jspx_th_impact_ifServerImpact_3.doStartTag();
              if (_jspx_eval_impact_ifServerImpact_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                out.write("\r\n          <td>");
                out.print( allgtnListDetail.getCdAllegDisposition() );
                out.write("</td>\r\n        ");
              }
              if (_jspx_th_impact_ifServerImpact_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    <td>");
              out.print(evidenceCode );
              out.write("</td>\r\n        <td>");
              out.print( allgtnListDetail.getSzCdAllegIncidentStage() );
              out.write("</td>\r\n        <td>");
              out.print( allgtnListDetail.getUlIdVictim() );
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_9.setType("hidden");
              _jspx_th_impact_validateInput_9.setName(nmVic);
              _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatInt( allgtnListDetail.getUlIdVictim() ));
              int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
              if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("</td>\r\n      </tr>\r\n      ");
 }
       } 
              out.write("\r\n    </table>\r\n    </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<table cellspacing=\"0\" cellPadding=\"3\" width=\"100%\" border=\"0\">\r\n  <tr>\r\n    <td class=\"alignLeft\">\r\n      ");

        String deleteAction = "/investigation/Allegation/delete" + strFacility + "AllgtnList";
      
          out.write("\r\n    <!--  // SIR 23729 Start -->\r\n    ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_4 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_4 = _jspx_th_impact_ifServerImpact_4.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n          ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_4);
            _jspx_th_impact_ButtonTag_0.setName("btnDelete");
            _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
            _jspx_th_impact_ButtonTag_0.setDisabled( String.valueOf( bDeleteButton ) );
            _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
            _jspx_th_impact_ButtonTag_0.setForm("frmAllgtnList");
            _jspx_th_impact_ButtonTag_0.setFunction("return deleteConfirm();");
            _jspx_th_impact_ButtonTag_0.setAction( deleteAction );
            _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
            int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
            if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n    ");
          }
          if (_jspx_th_impact_ifServerImpact_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <!-- // SIR 23729 end -->\r\n    </td>\r\n    <td class=\"alignRight\">\r\n      ");
 String displayAction = "/investigation/Allegation/display" + strFacility + "AllgtnDetail"; 
          out.write("\r\n      <!--  // SIR 23729 Start -->\r\n    ");
          //  impact:ifServerImpact
          gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact _jspx_th_impact_ifServerImpact_5 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfServerImpact();
          _jspx_th_impact_ifServerImpact_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifServerImpact_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          int _jspx_eval_impact_ifServerImpact_5 = _jspx_th_impact_ifServerImpact_5.doStartTag();
          if (_jspx_eval_impact_ifServerImpact_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n        ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_5);
            _jspx_th_impact_ButtonTag_1.setName("btnDetail");
            _jspx_th_impact_ButtonTag_1.setImg("btnDetail");
            _jspx_th_impact_ButtonTag_1.setDisabled( String.valueOf( bDetailButton ) );
            _jspx_th_impact_ButtonTag_1.setForm("frmAllgtnList");
            _jspx_th_impact_ButtonTag_1.setAction( displayAction );
            _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
            int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
            if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n          ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_5);
            _jspx_th_impact_ButtonTag_2.setName("btnNewUsing");
            _jspx_th_impact_ButtonTag_2.setImg("btnNewUsing");
            _jspx_th_impact_ButtonTag_2.setDisabled( String.valueOf( bAddButton ) );
            _jspx_th_impact_ButtonTag_2.setForm("frmAllgtnList");
            _jspx_th_impact_ButtonTag_2.setAction( displayAction );
            _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
            int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
            if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n          ");
            //  impact:ButtonTag
            gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
            _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
            _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ifServerImpact_5);
            _jspx_th_impact_ButtonTag_3.setName("btnAdd");
            _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
            _jspx_th_impact_ButtonTag_3.setDisabled( String.valueOf( bAddButton ) );
            _jspx_th_impact_ButtonTag_3.setForm("frmAllgtnList");
            _jspx_th_impact_ButtonTag_3.setAction( displayAction );
            _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
            int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
            if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
            out.write("\r\n    ");
          }
          if (_jspx_th_impact_ifServerImpact_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <!-- // SIR 23729 end -->\r\n    </td>\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
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

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("hdnUlIdAllgtn");
    _jspx_th_impact_validateInput_2.setValue("0");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnDisplayMode");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_ifMobileImpact_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_pagination_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:ifMobileImpact
    gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact _jspx_th_impact_ifMobileImpact_1 = new gov.georgia.dhr.dfcs.sacwis.core.utility.IfMobileImpact();
    _jspx_th_impact_ifMobileImpact_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_ifMobileImpact_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
    int _jspx_eval_impact_ifMobileImpact_1 = _jspx_th_impact_ifMobileImpact_1.doStartTag();
    if (_jspx_eval_impact_ifMobileImpact_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n      <td>&nbsp;</td>\r\n     ");
    }
    if (_jspx_th_impact_ifMobileImpact_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
