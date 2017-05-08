package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.web.workload.AdmnReviewConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public final class AdmnReviewAppeal_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n");

//*  JSP Name:     Admin Review & Appeal
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 12/20/02
//*
//*  Description:
//*   The Administrative Review and Appeal page
//*   allows users to record or view information about the
//*   status of an Administrative Review. Administrative
//*   reviews may be recorded for Investigations, the
//*   Release Hearing process, and Foster/Adoptive Home decisions.
//*   This page will allow for the identification of
//*   the Person Reviewed (for Investigations or Release
//*   Hearings), the applicable tracking dates, the
//*   Authority making a determination, the status of the
//*   review, and a result code. If applicable, information
//*   on the Release Hearing process can also be tracked.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  ----------------------------------------------
//**  06/09/03  GRIMSHAN          SIR 16979 Get pagemode from page mode instead
//**                              of from page mode attribute name
//**  06/18/03  LAURAMC           SIR 18219 Address style issues.  Remove extra
//**                              br, hr and left align narrative button
//**  02/19/04  thompswa          SIR 22585 Add a new type of review called
//**                              "Preponderance Review".  (For CPS only).
//**  02/20/04  thompswa          SIR 22654 Add a new type of review called
//**                              "Employee Misconduct Registry".(For APS, AFC).
//**  02/23/04  thompswa          SIR 22678 Removed "disabled" attribute from
//**                              the tag for the "Reviewed Person Notifed On"
//**                              field.
//**  06/28/04  Todd Reser        SIR 22937 - Switch between CPS & APS versions
//**                              of Cover Letter to Requestor and Notif to
//**                              Parent/Prof Reporter (Spanish or English)
//**  02/16/10  hnguyen			  STGAP00015822 Add form launch for Response 
//**							  to Case Review Request and Administrative 
//**							  Review Decision Letter forms.

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


  String pageMode = PageMode.getPageMode( request );
  BaseSessionStateManager state =
         (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //If the mode was set in the activity method, get it
  //Everything above this point should be in every page.
  int tabIndex = 1;

      out.write("\r\n\r\n");

  CCFC43SO ccfc43so = (CCFC43SO) state.getAttribute( "CCFC43SO", request );
  if ( ccfc43so == null )
  {
    ccfc43so = new CCFC43SO();
  }
  CCFC43SOG00 ARIDetail = (ccfc43so.getCCFC43SOG00() != null) ? ccfc43so.getCCFC43SOG00() : new CCFC43SOG00();
  
  ROWCCMN01UIG00 EventStatus = ( ccfc43so.getROWCCMN01UIG00() != null ) ? ccfc43so.getROWCCMN01UIG00() : new ROWCCMN01UIG00();

  String bAFC = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_AFC) ) ? "true" : "false" ;
  String bARF = ( GlobalData.getSzCdStage( request ).equals(AdmnReviewConversation.ADMIN_REVIEW_ARF) ) ? "true" : "false" ;
  boolean bARI = ( GlobalData.getSzCdStage( request ).equals(AdmnReviewConversation.ADMIN_REVIEW_ARI) ) ? true : false ;
//SIR 22585 Add boolean and exOptions for CPS only for CARVTYPE_050.
//SIR 22654 Add boolean and exOptions for APS, AFC for CARVTYPE_060.
  boolean bCps = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_CPS) ) ? true : false ;
  boolean bAps = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_APS) ) ? true : false ;
  boolean bAfc = ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_AFC) ) ? true : false ;

  List exOptions = new ArrayList();
  if ( bARI )
  {
   // exOptions.add(CodesTables.CARVTYPE_020);
    if ( !bCps )
    {
    //  exOptions.add(CodesTables.CARVTYPE_050);
    }
    if ( !bAps && !bAfc)
    {
      exOptions.add(CodesTables.CARVTYPE_060);
    }
  }
  

  boolean bFindings = Boolean.valueOf((String) request.getAttribute("bFindings"));
  boolean bReqParent = Boolean.valueOf((String) request.getAttribute("bReqParent"));
  boolean bNotif = Boolean.valueOf((String) request.getAttribute("bNotif"));
  boolean bLic = Boolean.valueOf((String) request.getAttribute("bLic"));
  String eventID = (String)request.getAttribute( "AdminReviewEventID" );
  String txtRsnApprvDeny = ARIDetail.getSztxtRsnApprvDeny();
  String originalINVStage = String.valueOf(ARIDetail.getUlIdStageRelated());
  String caseID = String.valueOf(ARIDetail.getUlIdCase());
    
  
  boolean showInitOnly = (ARIDetail.getSzCdAdminRvAppealType() == null || ARIDetail.getSzCdAdminRvAppealType().length() == 0) ? true : false;
  boolean showNonAdminReview = ((showInitOnly == false) && (CodesTables.CARVTYPE_020.equals(ARIDetail.getSzCdAdminRvAppealType())) == false) ? true :false;
  boolean shownIntermediateAdminMode = (CodesTables.CARVTYPE_020.equals(ARIDetail.getSzCdAdminRvAppealType()) == true) ? true :false;
  boolean shownIntermediateAdminModeOnly = (shownIntermediateAdminMode == true && (ARIDetail.getSzCdAdminRvIndLevel() == null || ARIDetail.getSzCdAdminRvIndLevel().length() == 0));
  
  boolean showSaveSubmit = (showInitOnly == true || shownIntermediateAdminModeOnly == true) ? false : true;
  
  boolean showForms = (shownIntermediateAdminMode == true && shownIntermediateAdminModeOnly == false);
  boolean protectDocument = (PageModeConstants.VIEW.equals(pageMode) == true) ? true : false;
  boolean showLevelOneOnly = "1".equals(ARIDetail.getSzCdAdminRvIndLevel()) && shownIntermediateAdminMode == true;
  boolean showLevelTwoThree = "2".equals(ARIDetail.getSzCdAdminRvIndLevel()) && shownIntermediateAdminMode == true;
  boolean showLevelThree =  "2".equals(ARIDetail.getSzCdAdminRvIndLevel()) && "Y".equals(ARIDetail.getBInd2lvlAdmRvComp());
  Boolean disableFirstLevel = (PageModeConstants.VIEW.equals(pageMode) == true) || (showLevelTwoThree == true);
  Boolean disableSecondLevel = (PageModeConstants.VIEW.equals(pageMode) == true) || "Y".equals(ARIDetail.getBInd2lvlAdmRvComp());
  Boolean disableThridLevel = (PageModeConstants.VIEW.equals(pageMode) == true);
  Integer ulIdCommisDes = (request.getAttribute("hdnUlIdCommisDes") != null) ? (Integer) request.getAttribute("hdnUlIdCommisDes") : new Integer(0);
  
  if(showLevelTwoThree == true && disableSecondLevel == false) {
  	showSaveSubmit = false;
  }
  
  String cdAdminRvStatusValue = (showInitOnly == true) ? CodesTables.CARVSTAT_010 : ARIDetail.getSzCdAdminRvStatus();
  List<String> exStatusOptions = new ArrayList<String>();
  if(showInitOnly == true) {
  	exStatusOptions.add(CodesTables.CARVSTAT_020);
  	exStatusOptions.add(CodesTables.CARVSTAT_040);
  	exStatusOptions.add(CodesTables.CARVSTAT_050);
  	exStatusOptions.add(CodesTables.CARVSTAT_060);
  }
  
  
  
  // This initially checks the Staff Radio Buttons
  String Lgl_No   = "false";
  String Lgl_Yes   = "false";
  String SAAG_No    = "true";
  String SAAG_Yes    = "false";

  //SIR 19794 - Added Sets.H

  // Check the request, if a search has been performed pull it out of there
    if ("Y".equalsIgnoreCase(ARIDetail.getBIndLglRepresentation()))
    {
      Lgl_Yes = "true";
      Lgl_No  = "false";
    }
    else if  ("N".equalsIgnoreCase(ARIDetail.getBIndLglRepresentation()))
    {
      Lgl_No  = "true";
      Lgl_Yes = "false";
    }
    
  if ("Y".equalsIgnoreCase(ARIDetail.getBIndSaagNotification()))
    {
      SAAG_Yes = "true";
      SAAG_No  = "false";
    }
    else if ("N".equalsIgnoreCase(ARIDetail.getBIndSaagNotification()))
    {
      SAAG_No = "true";
      SAAG_Yes = "false";
    }

  // This initially checks the 1st levl Staff Radio Buttons
  String Lgl1lvl_No   = "false";
  String Lgl1lvl_Yes   = "false";
  String SAAG1lvl_No    = "false";
  String SAAG1lvl_Yes    = "false";

  //SIR 19794 - Added Sets.H

  // Check the request, if a search has been performed pull it out of there
    if ("Y".equalsIgnoreCase(ARIDetail.getBInd1lvlLglRepresentation()))
    {
      Lgl1lvl_Yes = "true";
      Lgl1lvl_No  = "false";
    }
    else if  ("N".equalsIgnoreCase(ARIDetail.getBInd1lvlLglRepresentation()))
    {
      Lgl1lvl_No  = "true";
      Lgl1lvl_Yes = "false";
    }
    
  if ("Y".equalsIgnoreCase(ARIDetail.getBInd1lvlSaagNotification()))
    {
      SAAG1lvl_Yes = "true";
      SAAG1lvl_No  = "false";
    }
    else if ("N".equalsIgnoreCase(ARIDetail.getBInd1lvlSaagNotification()))
    {
      SAAG1lvl_No = "true";
      SAAG1lvl_Yes = "false";
    }
    
    // This initially checks the 1st levl Staff Radio Buttons
  String Lgl2lvl_No   = "false";
  String Lgl2lvl_Yes   = "false";
  String SAAG2lvl_No    = "false";
  String SAAG2lvl_Yes    = "false";

  //SIR 19794 - Added Sets.H

  // Check the request, if a search has been performed pull it out of there
    if ("Y".equalsIgnoreCase(ARIDetail.getBInd2lvlLglRepresentation()))
    {
      Lgl2lvl_Yes = "true";
      Lgl2lvl_No  = "false";
    }
    else if  ("N".equalsIgnoreCase(ARIDetail.getBInd2lvlLglRepresentation()))
    {
      Lgl2lvl_No  = "true";
      Lgl2lvl_Yes = "false";
    }
    
  if ("Y".equalsIgnoreCase(ARIDetail.getBInd2lvlSaagNotification()))
    {
      SAAG2lvl_Yes = "true";
      SAAG2lvl_No  = "false";
    }
    else if ("N".equalsIgnoreCase(ARIDetail.getBInd2lvlSaagNotification()))
    {
      SAAG2lvl_No = "true";
      SAAG2lvl_Yes = "false";
    }
    
    ROWCCMN01UIG02_ARRAY rowccmn01uig02_array = ARIDetail.getROWCCMN01UIG02_ARRAY();
    List<Option> stageList = new ArrayList<Option>();
    if(rowccmn01uig02_array != null && rowccmn01uig02_array.getROWCCMN01UIG02Count() > 0) {
    	Iterator<ROWCCMN01UIG02> itRow = rowccmn01uig02_array.iterateROWCCMN01UIG02();
    	while (itRow.hasNext()) {
    		ROWCCMN01UIG02 rowccmn01uig02 = itRow.next();
    		stageList.add(new Option(""+rowccmn01uig02.getUlIdStage(), rowccmn01uig02.getUlIdStage() + " - " + rowccmn01uig02.getSzNmStage()));
    	}
    }  
    String priorStage = (ARIDetail.getUlAdmRev2lvlPriorStage() > 0) ? ""+ARIDetail.getUlAdmRev2lvlPriorStage() : "";

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onbeforeunload = function ()\r\n  {\r\n      IsDirty();\r\n  };\r\n\r\nfunction setDueDate(value)\r\n{\r\n  var dateString = validateDateString(value);\r\n  date = new Date(dateString);\r\n  var year = date.getYear();\r\n  if (year < 2000)\r\n  {\r\n    year += 1900;\r\n  }\r\n  if ( ( date.getMonth() >= 0 && date.getMonth() < 12 ) &&\r\n       ( date.getDate() > 0 && date.getDate() < 32 ) &&\r\n       ( year > 1970 ) )\r\n  {\r\n    date = new Date(date.valueOf() + 2592000000);\r\n    year = date.getYear();\r\n    if (year < 2000)\r\n    {\r\n      year += 1900;\r\n    }\r\n    newDate = date.getMonth()+1 + \"/\" + date.getDate() + \"/\" + year;\r\n    document.frmAdmnReview.txtDtDtAdminRvDue.value = newDate;\r\n  }\r\n  document.frmAdmnReview.txtDtDtAdminRvReqAppeal.value = dateString;\r\n}\r\n\r\nfunction set1LvlDueDate(value)\r\n{\r\n  var dateString = validateDateString(value);\r\n  date = new Date(dateString);\r\n  var year = date.getYear();\r\n");
      out.write("  if (year < 2000)\r\n  {\r\n    year += 1900;\r\n  }\r\n  if ( ( date.getMonth() >= 0 && date.getMonth() < 12 ) &&\r\n       ( date.getDate() > 0 && date.getDate() < 32 ) &&\r\n       ( year > 1970 ) )\r\n  {\r\n    date = new Date(date.valueOf() + 2592000000);\r\n    year = date.getYear();\r\n    if (year < 2000)\r\n    {\r\n      year += 1900;\r\n    }\r\n    newDate = date.getMonth()+1 + \"/\" + date.getDate() + \"/\" + year;\r\n    document.frmAdmnReview.txtDtDt1lvlAdminRvDue.value = newDate;\r\n  }\r\n  document.frmAdmnReview.txtDtDt1lvlAdminRvReqAppeal.value = dateString;\r\n}\r\n\r\nfunction set2LvlDueDate(value)\r\n{\r\n  var dateString = validateDateString(value);\r\n  date = new Date(dateString);\r\n  var year = date.getYear();\r\n  if (year < 2000)\r\n  {\r\n    year += 1900;\r\n  }\r\n  if ( ( date.getMonth() >= 0 && date.getMonth() < 12 ) &&\r\n       ( date.getDate() > 0 && date.getDate() < 32 ) &&\r\n       ( year > 1970 ) )\r\n  {\r\n    date = new Date(date.valueOf() + 3888000000);\r\n    year = date.getYear();\r\n    if (year < 2000)\r\n    {\r\n      year += 1900;\r\n    }\r\n");
      out.write("    newDate = date.getMonth()+1 + \"/\" + date.getDate() + \"/\" + year;\r\n    document.frmAdmnReview.txtDtDt2lvlAdminRvDue.value = newDate;\r\n  }\r\n  document.frmAdmnReview.txtDtDt2lvlAdminRvReqAppeal.value = dateString;\r\n}\r\n\r\nfunction closePage(){\r\n\t");
 if(showForms) { 
      out.write("\r\n\treturn confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARI_FORMS_UPDATE));
      out.write("');\r\n\t");
 } 
      out.write("\r\n\treturn true;\r\n}\r\n\r\nfunction savePage(){\r\n    ");
 if(showInitOnly == false) { 
      out.write("\r\n    var origType = '");
      out.print(ARIDetail.getSzCdAdminRvAppealType());
      out.write("';\r\n    if( origType != frmAdmnReview.selSzCdAdminRvAppealType.value ) {\r\n     var conf = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARI_REVIEW_TYPE_CHANGE));
      out.write("');\r\n     if(conf == true) {\r\n     \tdisableValidation( \"frmAdmnReview\" );\r\n     }\r\n     return conf;\r\n    }\r\n\t");
 } 
      out.write("\r\n\t\r\n\t");
 if(shownIntermediateAdminModeOnly == false && shownIntermediateAdminMode == true) { 
      out.write("\r\n    var origLevel = '");
      out.print(ARIDetail.getSzCdAdminRvIndLevel());
      out.write("';\r\n    if((origLevel == '1' && frmAdmnReview.rbIndAdminLevel[1].checked) || (origLevel == '2' && frmAdmnReview.rbIndAdminLevel[0].checked)) {\r\n     var conf =  confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARI_REVIEW_TYPE_CHANGE));
      out.write("');\r\n      if(conf == true) {\r\n     \tdisableValidation( \"frmAdmnReview\" );\r\n     }\r\n     return conf;\r\n    }\r\n    ");
 } 
      out.write("\r\n    ");
 if(showLevelTwoThree == true && disableSecondLevel == false) { 
      out.write("\r\n    if((frmAdmnReview.cb2lvlAdmRv2ndStageComp.checked)) {\r\n     return confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ARI_SEC_LEVEL_COMPLETE));
      out.write("');\r\n    }    \r\n\t");
 } 
      out.write("\r\n\treturn true;\r\n}\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmAdmnReview");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/AdmnReview/saveAdmnReview");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.AdmnReviewCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\r\n<!-- Hidden Fields -->\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("hdnProgram");
          _jspx_th_impact_validateInput_0.setValue( GlobalData.getSzCdStageProgram( request ) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIntOnly");
          _jspx_th_impact_validateInput_1.setValue( Boolean.toString(showInitOnly) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnUlIdCommisDes");
          _jspx_th_impact_validateInput_2.setValue(ulIdCommisDes.toString());
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Review and Appeal</th>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Person Reviewed");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( ccfc43so.getSzNmPersonFull() );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Original INV Stage");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( originalINVStage );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");
          out.write("\r\n  </tr>\r\n  <tr>\r\n    <td width=\"21%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setWidth("31%");
          _jspx_th_impact_validateSelect_0.setName("selSzCdAdminRvAppealType");
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setValue( ARIDetail.getSzCdAdminRvAppealType() );
          _jspx_th_impact_validateSelect_0.setExcludeOptions( exOptions );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CARVTYPE");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"21%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setWidth("31%");
          _jspx_th_impact_validateSelect_1.setName("selSzCdAdminRvStatus");
          _jspx_th_impact_validateSelect_1.setLabel("Status");
          _jspx_th_impact_validateSelect_1.setValue( cdAdminRvStatusValue );
          _jspx_th_impact_validateSelect_1.setExcludeOptions( exStatusOptions );
          _jspx_th_impact_validateSelect_1.setRequired("true");
          _jspx_th_impact_validateSelect_1.setCodesTable("CARVSTAT");
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
 if(showNonAdminReview == true) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Panel/Child Death/Near Fatality/Serious Injury Review</th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setWidth("26%");
          _jspx_th_impact_validateDate_0.setName("txtDtDtDeterminationLtr");
          _jspx_th_impact_validateDate_0.setLabel("Determination Letter Generation Date");
          _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate( ARIDetail.getDtDtDeterminationLtr() ) );
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    \r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setWidth("31%");
          _jspx_th_impact_validateDate_1.setName("txtDtDtAdminRvReqAppeal");
          _jspx_th_impact_validateDate_1.setLabel("Request Received Date");
          _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvReqAppeal() ) );
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setOnChange("setDueDate(this.value)");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setWidth("31%");
          _jspx_th_impact_validateDate_2.setName("txtDtDtAdminRvAppealReview");
          _jspx_th_impact_validateDate_2.setLabel("Review Date");
          _jspx_th_impact_validateDate_2.setValue( FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvAppealReview() ) );
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setWidth("31%");
          _jspx_th_impact_validateDate_3.setName("txtDtDtAdminRvDue");
          _jspx_th_impact_validateDate_3.setLabel("Conduct Review By");
          _jspx_th_impact_validateDate_3.setValue( FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvDue() ) );
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <span class=\"formCondRequiredText\">&#135;</span><LABEL>Legal Representation</LABEL>      \r\n    </td>\r\n    <td colspan=\"1\">\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setDisabled("");
          _jspx_th_impact_validateInput_3.setLabel("No");
          _jspx_th_impact_validateInput_3.setId("Lgl_No");
          _jspx_th_impact_validateInput_3.setName("rbIndLglRepresentation");
          _jspx_th_impact_validateInput_3.setValue("N");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setChecked( Lgl_No );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setDisabled("");
          _jspx_th_impact_validateInput_4.setLabel("Yes");
          _jspx_th_impact_validateInput_4.setId("Lgl_Yes");
          _jspx_th_impact_validateInput_4.setName("rbIndLglRepresentation");
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setChecked( Lgl_Yes );
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      <span class=\"formCondRequiredText\">&#135;</span><LABEL>SAAG Notification</LABEL>      \r\n    </td>\r\n    <td colspan=\"1\">\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setDisabled("");
          _jspx_th_impact_validateInput_5.setLabel("No");
          _jspx_th_impact_validateInput_5.setId("SAA_No");
          _jspx_th_impact_validateInput_5.setName("rbIndSAAGNotification");
          _jspx_th_impact_validateInput_5.setValue("N");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setChecked( SAAG_No );
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setDisabled("");
          _jspx_th_impact_validateInput_6.setLabel("Yes");
          _jspx_th_impact_validateInput_6.setId("SAAG_Yes");
          _jspx_th_impact_validateInput_6.setName("rbIndSAAGNotification");
          _jspx_th_impact_validateInput_6.setValue("Y");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setChecked( SAAG_Yes );
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">Result</th>\r\n  </tr>\r\n  <tr>\r\n           <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Result");
          _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_7.setConstraint("Comments");
          _jspx_th_impact_validateInput_7.setName("txtSzAdminRvAppealResult");
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue(  ARIDetail.getSztxtAppealResult() );
          _jspx_th_impact_validateInput_7.setSize("80");
          _jspx_th_impact_validateInput_7.setMaxLength("80");
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n             </td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setName("txtDtDtAdminRvAppealNotif");
          _jspx_th_impact_validateDate_4.setLabel("Reviewed Person Notifed On");
          _jspx_th_impact_validateDate_4.setValue( FormattingHelper.formatDate( ARIDetail.getDtDtAdminRvAppealNotif() ) );
          _jspx_th_impact_validateDate_4.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtSzTxtRsnApprvDeny");
          _jspx_th_impact_validateTextArea_0.setLabel("Reason for Aproval/Denial");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("113");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n              ");
              out.print( FormattingHelper.formatString( txtRsnApprvDeny ) );
              out.write("\r\n       ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } //if(showNonAdminReview == true) { 
          out.write("\r\n\r\n");
 if(shownIntermediateAdminMode == true) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Administrative Review</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      <span class=\"formRequiredText\">*</span>\r\n       ");
          if (_jspx_meth_impact_validateDisplayOnlyField_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("    \r\n    </td>\r\n    <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setDisabled("");
          _jspx_th_impact_validateInput_8.setLabel("1st Level Review ");
          _jspx_th_impact_validateInput_8.setId("AL_1");
          _jspx_th_impact_validateInput_8.setName("rbIndAdminLevel");
          _jspx_th_impact_validateInput_8.setValue("1");
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setChecked("1".equals(ARIDetail.getSzCdAdminRvIndLevel()) ? "true" : "false" );
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    </td>\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setDisabled("");
          _jspx_th_impact_validateInput_9.setLabel("2nd and 3rd Level Review ");
          _jspx_th_impact_validateInput_9.setId("AL_23");
          _jspx_th_impact_validateInput_9.setName("rbIndAdminLevel");
          _jspx_th_impact_validateInput_9.setValue("2");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setChecked("2".equals(ARIDetail.getSzCdAdminRvIndLevel()) ? "true" : "false" );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } //if(shownIntermediateAdminMode == true) { 
          out.write("\r\n\r\n\r\n");
  if (showLevelOneOnly == true || showLevelTwoThree == true) {
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("firstLevelAdministrativeReview");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("1st Level Administrative Review");
          _jspx_th_impact_ExpandableSectionTag_0.setIsExpanded((showLevelOneOnly == true) ? true : false);
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  ");
 if (showLevelTwoThree == true) {
              out.write("\r\n  <tr class=\"subDetail\">\r\n    <td width=\"21%\">");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setWidth("31%");
              _jspx_th_impact_validateSelect_2.setName("sel1lvlARIStage");
              _jspx_th_impact_validateSelect_2.setLabel("1st Level ARI Stage");
              _jspx_th_impact_validateSelect_2.setDisabled(disableSecondLevel.toString());
              _jspx_th_impact_validateSelect_2.setValue(priorStage);
              _jspx_th_impact_validateSelect_2.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
              _jspx_th_impact_validateSelect_2.setOptions(stageList);
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n    </td>\r\n    <td>\r\n    </td>\r\n  </tr>\r\n  ");
 } //if(showLevelTwoThree == true) { 
              out.write("\r\n  <tr class=\"subDetail\">\r\n  \t<td>\r\n  \t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_3.setName("");
              _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Assigned Subject Matter Expert");
              _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatString( ARIDetail.getSzNmPersonFullAmdRev1lSME() ) );
              int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  \t</td>\r\n  \t<td>\r\n    </td>\r\n    <td>\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td width=\"25%\">");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_5.setWidth("26%");
              _jspx_th_impact_validateDate_5.setName("txtDtDt1lvlDeterminationLtr");
              _jspx_th_impact_validateDate_5.setLabel("Determination Letter Generation Date");
              _jspx_th_impact_validateDate_5.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateDate_5.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt1lvlDeterminationLtr() ) );
              _jspx_th_impact_validateDate_5.setRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
              if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    \r\n    <td width=\"21%\">");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_6.setWidth("31%");
              _jspx_th_impact_validateDate_6.setName("txtDtDt1lvlAdminRvReqAppeal");
              _jspx_th_impact_validateDate_6.setLabel("Request Received Date");
              _jspx_th_impact_validateDate_6.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateDate_6.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvReqAppeal() ) );
              _jspx_th_impact_validateDate_6.setRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateDate_6.setOnChange("set1LvlDueDate(this.value)");
              _jspx_th_impact_validateDate_6.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
              if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td width=\"21%\">");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_7.setWidth("31%");
              _jspx_th_impact_validateDate_7.setName("txtDtDt1lvlAdminRvAppealReview");
              _jspx_th_impact_validateDate_7.setLabel("Review Date");
              _jspx_th_impact_validateDate_7.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateDate_7.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvAppealReview() ) );
              _jspx_th_impact_validateDate_7.setConditionallyRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateDate_7.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
              if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td width=\"21%\">");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_8.setWidth("31%");
              _jspx_th_impact_validateDate_8.setName("txtDtDt1lvlAdminRvDue");
              _jspx_th_impact_validateDate_8.setLabel("Conduct Review By");
              _jspx_th_impact_validateDate_8.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateDate_8.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvDue() ) );
              _jspx_th_impact_validateDate_8.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_8 = _jspx_th_impact_validateDate_8.doStartTag();
              if (_jspx_th_impact_validateDate_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n    ");
if (showLevelTwoThree == true) { 
              out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Legal Representation</LABEL>      \r\n    ");
} else { 
              out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Legal Representation</LABEL>      \r\n    ");
}
              out.write("\r\n    </td>\r\n    <td colspan=\"1\">\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_10.setType("radio");
              _jspx_th_impact_validateInput_10.setDisabled("");
              _jspx_th_impact_validateInput_10.setLabel("No");
              _jspx_th_impact_validateInput_10.setId("Lgl1lvl_No");
              _jspx_th_impact_validateInput_10.setName("rbInd1lvlLglRepresentation");
              _jspx_th_impact_validateInput_10.setValue("N");
              _jspx_th_impact_validateInput_10.setCssClass("formInput");
              _jspx_th_impact_validateInput_10.setChecked( Lgl1lvl_No );
              _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_10.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
              if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_11.setType("radio");
              _jspx_th_impact_validateInput_11.setDisabled("");
              _jspx_th_impact_validateInput_11.setLabel("Yes");
              _jspx_th_impact_validateInput_11.setId("Lgl1lvl_Yes");
              _jspx_th_impact_validateInput_11.setName("rbInd1lvlLglRepresentation");
              _jspx_th_impact_validateInput_11.setValue("Y");
              _jspx_th_impact_validateInput_11.setCssClass("formInput");
              _jspx_th_impact_validateInput_11.setChecked( Lgl1lvl_Yes );
              _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_11.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
              if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n    <td>\r\n     ");
if (showLevelTwoThree == true) { 
              out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>SAAG Notification</LABEL>   \r\n    ");
} else { 
              out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>SAAG Notification</LABEL>   \r\n    ");
}
              out.write("\r\n    </td>\r\n    </td>\r\n    <td colspan=\"1\">\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_12.setType("radio");
              _jspx_th_impact_validateInput_12.setDisabled("");
              _jspx_th_impact_validateInput_12.setLabel("No");
              _jspx_th_impact_validateInput_12.setId("SAA1lvl_No");
              _jspx_th_impact_validateInput_12.setName("rbInd1lvlSAAGNotification");
              _jspx_th_impact_validateInput_12.setValue("N");
              _jspx_th_impact_validateInput_12.setCssClass("formInput");
              _jspx_th_impact_validateInput_12.setChecked( SAAG1lvl_No );
              _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_12.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
              if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_13.setType("radio");
              _jspx_th_impact_validateInput_13.setDisabled("");
              _jspx_th_impact_validateInput_13.setLabel("Yes");
              _jspx_th_impact_validateInput_13.setId("SAAG1lvl_Yes");
              _jspx_th_impact_validateInput_13.setName("rbInd1lvlSAAGNotification");
              _jspx_th_impact_validateInput_13.setValue("Y");
              _jspx_th_impact_validateInput_13.setCssClass("formInput");
              _jspx_th_impact_validateInput_13.setChecked( SAAG1lvl_Yes );
              _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_13.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
              if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr class=\"subDetail\">\r\n    <th colspan=\"4\">Result</th>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n  \t<td>\r\n    ");
if (showLevelTwoThree == true) { 
              out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Disposition</LABEL> \r\n    ");
} else { 
              out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Disposition</LABEL>    \r\n    ");
}
              out.write("\r\n    </td>\r\n    <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_14.setType("radio");
              _jspx_th_impact_validateInput_14.setDisabled("");
              _jspx_th_impact_validateInput_14.setLabel("I agree with the county's case determination of substantiation");
              _jspx_th_impact_validateInput_14.setId("DP1_1");
              _jspx_th_impact_validateInput_14.setName("rbInd1lvlDisp");
              _jspx_th_impact_validateInput_14.setValue("Y");
              _jspx_th_impact_validateInput_14.setCssClass("formInput");
              _jspx_th_impact_validateInput_14.setChecked("Y".equals(ARIDetail.getSzCd1lvlAdminRvDisp()) ? "true" : "false" );
              _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_14.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
              if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_15.setType("radio");
              _jspx_th_impact_validateInput_15.setDisabled("");
              _jspx_th_impact_validateInput_15.setLabel("I do not agree with the action the county has taken and therefore the allegations will be unsubstantiated");
              _jspx_th_impact_validateInput_15.setId("DP2_1");
              _jspx_th_impact_validateInput_15.setName("rbInd1lvlDisp");
              _jspx_th_impact_validateInput_15.setValue("N");
              _jspx_th_impact_validateInput_15.setCssClass("formInput");
              _jspx_th_impact_validateInput_15.setChecked("N".equals(ARIDetail.getSzCd1lvlAdminRvDisp()) ? "true" : "false" );
              _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_15.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
              if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setType("radio");
              _jspx_th_impact_validateInput_16.setDisabled("");
              _jspx_th_impact_validateInput_16.setLabel("N/A: Review denied");
              _jspx_th_impact_validateInput_16.setId("DP3_1");
              _jspx_th_impact_validateInput_16.setName("rbInd1lvlDisp");
              _jspx_th_impact_validateInput_16.setValue("A");
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setChecked("A".equals(ARIDetail.getSzCd1lvlAdminRvDisp()) ? "true" : "false" );
              _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_16.setDisabled(disableFirstLevel.toString());
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td width=\"21%\">");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_3.setWidth("31%");
              _jspx_th_impact_validateSelect_3.setName("selSzCd1lvlRsDisg");
              _jspx_th_impact_validateSelect_3.setLabel("Reason for Disagreement");
              _jspx_th_impact_validateSelect_3.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(ARIDetail.getSzCd1lvlAdminRsDisg()));
              _jspx_th_impact_validateSelect_3.setConditionallyRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateSelect_3.setCodesTable("COVERTUR");
              _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
              if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n   <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setType("text");
              _jspx_th_impact_validateInput_17.setLabel("Result");
              _jspx_th_impact_validateInput_17.setConditionallyRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateInput_17.setConstraint("Comments");
              _jspx_th_impact_validateInput_17.setName("txtSz1lvlAdminRvAppealResult");
              _jspx_th_impact_validateInput_17.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setValue( FormattingHelper.formatString(ARIDetail.getSzTxt1lvlAdminRevResults()) );
              _jspx_th_impact_validateInput_17.setSize("80");
              _jspx_th_impact_validateInput_17.setMaxLength("80");
              _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n   </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n   <td width=\"21%\">");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_9.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_9.setWidth("31%");
              _jspx_th_impact_validateDate_9.setName("txtDtDt1lvlAdminRvPersonNoti");
              _jspx_th_impact_validateDate_9.setLabel("Reviewed Person Notified On");
              _jspx_th_impact_validateDate_9.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateDate_9.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt1lvlAdminRvPersonNotif()) );
              _jspx_th_impact_validateDate_9.setConditionallyRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateDate_9.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateDate_9 = _jspx_th_impact_validateDate_9.doStartTag();
              if (_jspx_th_impact_validateDate_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n   <td>\r\n\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setName("szTxt1lvlAdminRevResAppDen");
              _jspx_th_impact_validateTextArea_1.setLabel("Reason for Approval/Denial");
              _jspx_th_impact_validateTextArea_1.setDisabled(disableFirstLevel.toString());
              _jspx_th_impact_validateTextArea_1.setConditionallyRequired( (showLevelTwoThree == true) ? "false" : "true" );
              _jspx_th_impact_validateTextArea_1.setCols("92");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_1.setMaxLength(4000);
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.print( FormattingHelper.formatString(ARIDetail.getSzTxt1lvlAdminRevResAppDen()));
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t</td>\r\n  </tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 } //if((showLevelOneOnly == true || showLevelTwoThree == true)) { 
          out.write("\r\n\r\n\r\n");
  if (showLevelTwoThree == true) {
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">2nd Level Administrative Review</th>\r\n  </tr>\r\n  <tr>\r\n   <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setLabel("Assigned Administrative Review Officer");
          _jspx_th_impact_validateInput_18.setRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateInput_18.setConstraint("Comments");
          _jspx_th_impact_validateInput_18.setName("txtSz2lvlAdminRvOff");
          _jspx_th_impact_validateInput_18.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateInput_18.setCssClass("formInput");
          _jspx_th_impact_validateInput_18.setValue( FormattingHelper.formatString(ARIDetail.getSzTxt2lvlAdminRevOff()) );
          _jspx_th_impact_validateInput_18.setSize("25");
          _jspx_th_impact_validateInput_18.setMaxLength("25");
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_19.setType("checkbox");
          _jspx_th_impact_validateInput_19.setName("cb1lvlAdmRv21lvlStage");
          _jspx_th_impact_validateInput_19.setLabel("No 1st Level ARI Stage");
          _jspx_th_impact_validateInput_19.setCssClass("formInput");
          _jspx_th_impact_validateInput_19.setValue("Y");
          _jspx_th_impact_validateInput_19.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateInput_19.setChecked(("Y".equals(ARIDetail.getBInd1lvlAdmRv21lvlStag())) ? "true" : "false");
          _jspx_th_impact_validateInput_19.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n  \t<td>\r\n  \t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Person Completing SHINES Documentation");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatString( ARIDetail.getSzNmAdmRvPersonFullAmdComp() ) );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t</td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"25%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_10.setWidth("26%");
          _jspx_th_impact_validateDate_10.setName("txtDtDt2lvlDecisionLtr");
          _jspx_th_impact_validateDate_10.setLabel("Date 1st Level Administrative Decision Letter Received by Requestor");
          _jspx_th_impact_validateDate_10.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateDate_10.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdmRvDecLtr() ) );
          _jspx_th_impact_validateDate_10.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_10 = _jspx_th_impact_validateDate_10.doStartTag();
          if (_jspx_th_impact_validateDate_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    \r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_11.setWidth("31%");
          _jspx_th_impact_validateDate_11.setName("txtDtDt2lvlAdminRvReqAppeal");
          _jspx_th_impact_validateDate_11.setLabel("Request Received Date");
          _jspx_th_impact_validateDate_11.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateDate_11.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvReqAppeal() ) );
          _jspx_th_impact_validateDate_11.setRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_11.setOnChange("set2LvlDueDate(this.value)");
          _jspx_th_impact_validateDate_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_11 = _jspx_th_impact_validateDate_11.doStartTag();
          if (_jspx_th_impact_validateDate_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n  \t<td>\r\n    ");
if (disableSecondLevel == true) { 
          out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Review Type</LABEL> \r\n    ");
} else { 
          out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Review Type</LABEL>    \r\n    ");
}
          out.write("\r\n    </td>\r\n    <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setDisabled("");
          _jspx_th_impact_validateInput_20.setLabel("Desk Review");
          _jspx_th_impact_validateInput_20.setId("RT_2");
          _jspx_th_impact_validateInput_20.setName("rbInd2lvlRevType");
          _jspx_th_impact_validateInput_20.setValue("D");
          _jspx_th_impact_validateInput_20.setCssClass("formInput");
          _jspx_th_impact_validateInput_20.setChecked("D".equals(ARIDetail.getSzCd2lvlAdminRvType()) ? "true" : "false" );
          _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_20.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setDisabled("");
          _jspx_th_impact_validateInput_21.setLabel("Face to Face Review");
          _jspx_th_impact_validateInput_21.setId("RT_2");
          _jspx_th_impact_validateInput_21.setName("rbInd2lvlRevType");
          _jspx_th_impact_validateInput_21.setValue("F");
          _jspx_th_impact_validateInput_21.setCssClass("formInput");
          _jspx_th_impact_validateInput_21.setChecked("F".equals(ARIDetail.getSzCd2lvlAdminRvType()) ? "true" : "false" );
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_21.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_12.setWidth("31%");
          _jspx_th_impact_validateDate_12.setName("txtDtDt2lvlAdminSchRevIntrv");
          _jspx_th_impact_validateDate_12.setLabel("Scheduled Interview Date");
          _jspx_th_impact_validateDate_12.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateDate_12.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvReqIntrv() ) );
          _jspx_th_impact_validateDate_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_12 = _jspx_th_impact_validateDate_12.doStartTag();
          if (_jspx_th_impact_validateDate_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_13.setWidth("31%");
          _jspx_th_impact_validateDate_13.setName("txtDtDt2lvlAdminRvAppealReview");
          _jspx_th_impact_validateDate_13.setLabel("Review Date");
          _jspx_th_impact_validateDate_13.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateDate_13.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvAppealReview() ) );
          _jspx_th_impact_validateDate_13.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_13 = _jspx_th_impact_validateDate_13.doStartTag();
          if (_jspx_th_impact_validateDate_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_14.setWidth("31%");
          _jspx_th_impact_validateDate_14.setName("txtDtDt2lvlAdminRvDue");
          _jspx_th_impact_validateDate_14.setLabel("Conduct Review By");
          _jspx_th_impact_validateDate_14.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateDate_14.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvDue() ) );
          _jspx_th_impact_validateDate_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_14 = _jspx_th_impact_validateDate_14.doStartTag();
          if (_jspx_th_impact_validateDate_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    ");
if (disableSecondLevel == true) { 
          out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Legal Representation</LABEL>      \r\n    ");
} else { 
          out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Legal Representation</LABEL>      \r\n    ");
}
          out.write("\r\n    </td>\r\n    <td colspan=\"1\">\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setDisabled("");
          _jspx_th_impact_validateInput_22.setLabel("No");
          _jspx_th_impact_validateInput_22.setId("Lgl2lvl_No");
          _jspx_th_impact_validateInput_22.setName("rbInd2lvlLglRepresentation");
          _jspx_th_impact_validateInput_22.setValue("N");
          _jspx_th_impact_validateInput_22.setCssClass("formInput");
          _jspx_th_impact_validateInput_22.setChecked( Lgl2lvl_No );
          _jspx_th_impact_validateInput_22.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_22.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setDisabled("");
          _jspx_th_impact_validateInput_23.setLabel("Yes");
          _jspx_th_impact_validateInput_23.setId("Lgl2lvl_Yes");
          _jspx_th_impact_validateInput_23.setName("rbInd2lvlLglRepresentation");
          _jspx_th_impact_validateInput_23.setValue("Y");
          _jspx_th_impact_validateInput_23.setCssClass("formInput");
          _jspx_th_impact_validateInput_23.setChecked( Lgl2lvl_Yes );
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_23.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n     ");
if (disableSecondLevel == true) { 
          out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>SAAG Notification</LABEL>   \r\n    ");
} else { 
          out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>SAAG Notification</LABEL>   \r\n    ");
}
          out.write("\r\n    </td>\r\n    </td>\r\n    <td colspan=\"1\">\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setDisabled("");
          _jspx_th_impact_validateInput_24.setLabel("No");
          _jspx_th_impact_validateInput_24.setId("SAA2lvl_No");
          _jspx_th_impact_validateInput_24.setName("rbInd2lvlSAAGNotification");
          _jspx_th_impact_validateInput_24.setValue("N");
          _jspx_th_impact_validateInput_24.setCssClass("formInput");
          _jspx_th_impact_validateInput_24.setChecked( SAAG2lvl_No );
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_24.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setDisabled("");
          _jspx_th_impact_validateInput_25.setLabel("Yes");
          _jspx_th_impact_validateInput_25.setId("SAAG2lvl_Yes");
          _jspx_th_impact_validateInput_25.setName("rbInd2lvlSAAGNotification");
          _jspx_th_impact_validateInput_25.setValue("Y");
          _jspx_th_impact_validateInput_25.setCssClass("formInput");
          _jspx_th_impact_validateInput_25.setChecked( SAAG2lvl_Yes );
          _jspx_th_impact_validateInput_25.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_25.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Result</th>\r\n  </tr>\r\n  <tr>\r\n  \t<td>\r\n    ");
if (disableSecondLevel == true) { 
          out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Disposition</LABEL> \r\n    ");
} else { 
          out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Disposition</LABEL>    \r\n    ");
}
          out.write("\r\n    </td>\r\n    <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setDisabled("");
          _jspx_th_impact_validateInput_26.setLabel("I agree with the county's case determination of substantiation");
          _jspx_th_impact_validateInput_26.setId("DP1_2");
          _jspx_th_impact_validateInput_26.setName("rbInd2lvlDisp");
          _jspx_th_impact_validateInput_26.setValue("Y");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setChecked("Y".equals(ARIDetail.getSzCd2lvlAdminRvDisp()) ? "true" : "false" );
          _jspx_th_impact_validateInput_26.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_26.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setDisabled("");
          _jspx_th_impact_validateInput_27.setLabel("I do not agree with the action the county has taken and therefore the allegations will be unsubstantiated");
          _jspx_th_impact_validateInput_27.setId("DP2_2");
          _jspx_th_impact_validateInput_27.setName("rbInd2lvlDisp");
          _jspx_th_impact_validateInput_27.setValue("N");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setChecked("N".equals(ARIDetail.getSzCd2lvlAdminRvDisp()) ? "true" : "false" );
          _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_27.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setDisabled("");
          _jspx_th_impact_validateInput_28.setLabel("N/A: Review denied");
          _jspx_th_impact_validateInput_28.setId("DP3_2");
          _jspx_th_impact_validateInput_28.setName("rbInd2lvlDisp");
          _jspx_th_impact_validateInput_28.setValue("A");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setChecked("A".equals(ARIDetail.getSzCd2lvlAdminRvDisp()) ? "true" : "false" );
          _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_28.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"21%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setWidth("31%");
          _jspx_th_impact_validateSelect_4.setName("selSzCd2lvlRsDisg");
          _jspx_th_impact_validateSelect_4.setLabel("Reason for Disagreement");
          _jspx_th_impact_validateSelect_4.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(ARIDetail.getSzCd2lvlAdminRsDisg()));
          _jspx_th_impact_validateSelect_4.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateSelect_4.setCodesTable("COVERTUR");
          _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("text");
          _jspx_th_impact_validateInput_29.setLabel("Result");
          _jspx_th_impact_validateInput_29.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateInput_29.setConstraint("Comments");
          _jspx_th_impact_validateInput_29.setName("txtSz2lvlAdminRvAppealResult");
          _jspx_th_impact_validateInput_29.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateInput_29.setCssClass("formInput");
          _jspx_th_impact_validateInput_29.setValue( FormattingHelper.formatString(ARIDetail.getSzTxt2lvlAdminRevResults()) );
          _jspx_th_impact_validateInput_29.setSize("80");
          _jspx_th_impact_validateInput_29.setMaxLength("80");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n  </tr>\r\n  <tr>\r\n   <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_15.setWidth("31%");
          _jspx_th_impact_validateDate_15.setName("txtDtDt2lvlAdminRvPersonNoti");
          _jspx_th_impact_validateDate_15.setLabel("Reviewed Person Notified On");
          _jspx_th_impact_validateDate_15.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateDate_15.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt2lvlAdminRvPersonNotif()) );
          _jspx_th_impact_validateDate_15.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_15 = _jspx_th_impact_validateDate_15.doStartTag();
          if (_jspx_th_impact_validateDate_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <td>\r\n\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("szTxt2lvlAdminRevResAppDen");
          _jspx_th_impact_validateTextArea_2.setLabel("Reason for Approval/Denial");
          _jspx_th_impact_validateTextArea_2.setDisabled(disableSecondLevel.toString());
          _jspx_th_impact_validateTextArea_2.setConditionallyRequired( (disableSecondLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateTextArea_2.setCols("92");
          _jspx_th_impact_validateTextArea_2.setRows("3");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setMaxLength(4000);
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.print( FormattingHelper.formatString(ARIDetail.getSzTxt2lvlAdminRevResAppDen()));
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n  <tr>\r\n  <td>\r\n  </td>\r\n  <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_30.setType("checkbox");
          _jspx_th_impact_validateInput_30.setName("cb2lvlAdmRv2ndStageComp");
          _jspx_th_impact_validateInput_30.setLabel("2nd Level Review Complete");
          _jspx_th_impact_validateInput_30.setCssClass("formInput");
          _jspx_th_impact_validateInput_30.setValue("Y");
          _jspx_th_impact_validateInput_30.setChecked(("Y".equals(ARIDetail.getBInd2lvlAdmRvComp())) ? "true" : "false");
          _jspx_th_impact_validateInput_30.setDisabled(disableSecondLevel.toString());
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");
 } //if(showLevelTwoThree == true) { 
          out.write('\r');
          out.write('\n');
  if (showLevelThree == true) {
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">3rd Level Administrative Review</th>\r\n  </tr>\r\n  <tr>\r\n  \t<td>\r\n  \t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Assigned DHS Commissioner/Designee");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString( ARIDetail.getSzTxt3lvlAdminRevCommDes() ) );
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t</td>\r\n  \t <td>\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_ButtonTag_0.setFunction("javascript:disableValidation( 'frmAdmnReview' );");
          _jspx_th_impact_ButtonTag_0.setForm("frmAdmnReview");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setAction("/workload/AdmnReview/displayStaffSearch");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       </td>\r\n  </tr>\r\n  <tr>\r\n  \t<td>\r\n  \t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Person Completing SHINES Documentation");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( FormattingHelper.formatString( ARIDetail.getSzTxt3lvlAdminRevCompDoc() ) );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  \t</td>\r\n  </tr>\r\n  <tr>\r\n     <td width=\"25%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_16.setWidth("26%");
          _jspx_th_impact_validateDate_16.setName("txtDtDt3lvlDecisionLtr");
          _jspx_th_impact_validateDate_16.setLabel("Date 2nd Level Administrative Decision Letter Received by Requestor");
          _jspx_th_impact_validateDate_16.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateDate_16.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdmRvDecLtr() ) );
          _jspx_th_impact_validateDate_16.setRequired( (disableThridLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_16 = _jspx_th_impact_validateDate_16.doStartTag();
          if (_jspx_th_impact_validateDate_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_17.setWidth("31%");
          _jspx_th_impact_validateDate_17.setName("txtDtDt3lvlAdminRvAppealReview");
          _jspx_th_impact_validateDate_17.setLabel("Review Date");
          _jspx_th_impact_validateDate_17.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateDate_17.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdminRvAppealReview() ) );
          _jspx_th_impact_validateDate_17.setConditionallyRequired( (disableThridLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_17 = _jspx_th_impact_validateDate_17.doStartTag();
          if (_jspx_th_impact_validateDate_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_18.setWidth("31%");
          _jspx_th_impact_validateDate_18.setName("txtDtDt3lvlAdminRvDue");
          _jspx_th_impact_validateDate_18.setLabel("Conduct Review By");
          _jspx_th_impact_validateDate_18.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateDate_18.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdminRvDue() ) );
          _jspx_th_impact_validateDate_18.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_18 = _jspx_th_impact_validateDate_18.doStartTag();
          if (_jspx_th_impact_validateDate_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Result</th>\r\n  </tr>\r\n  <tr>\r\n  \t<td>\r\n    ");
if (disableThridLevel == true) { 
          out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Disposition</LABEL> \r\n    ");
} else { 
          out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Disposition</LABEL>    \r\n    ");
}
          out.write("\r\n    </td>\r\n    <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("radio");
          _jspx_th_impact_validateInput_31.setDisabled("");
          _jspx_th_impact_validateInput_31.setLabel("I agree with the administrative review officers determination");
          _jspx_th_impact_validateInput_31.setId("DP1_3");
          _jspx_th_impact_validateInput_31.setName("rbInd3lvlDisp");
          _jspx_th_impact_validateInput_31.setValue("Y");
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setChecked("Y".equals(ARIDetail.getSzCd3lvlAdminRvDisp()) ? "true" : "false" );
          _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_31.setDisabled(disableThridLevel.toString());
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setDisabled("");
          _jspx_th_impact_validateInput_32.setLabel("I do not agree with the administrative review officers determination");
          _jspx_th_impact_validateInput_32.setId("DP2_3");
          _jspx_th_impact_validateInput_32.setName("rbInd3lvlDisp");
          _jspx_th_impact_validateInput_32.setValue("N");
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          _jspx_th_impact_validateInput_32.setChecked("N".equals(ARIDetail.getSzCd3lvlAdminRvDisp()) ? "true" : "false" );
          _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_32.setDisabled(disableThridLevel.toString());
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    ");
if (disableThridLevel == true) { 
          out.write("\r\n      <span class=\"formCondRequiredText\"></span><LABEL>Final Decision</LABEL> \r\n    ");
} else { 
          out.write("\r\n       <span class=\"formCondRequiredText\">&#135;</span><LABEL>Final Decision</LABEL>    \r\n    ");
}
          out.write("\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("radio");
          _jspx_th_impact_validateInput_33.setDisabled("");
          _jspx_th_impact_validateInput_33.setLabel("I agree with the county's case determination of substantiation");
          _jspx_th_impact_validateInput_33.setId("FD1_3");
          _jspx_th_impact_validateInput_33.setName("rbInd3lvlFinDec");
          _jspx_th_impact_validateInput_33.setValue("Y");
          _jspx_th_impact_validateInput_33.setCssClass("formInput");
          _jspx_th_impact_validateInput_33.setChecked("Y".equals(ARIDetail.getSzCd3lvlAdminRvFnDec()) ? "true" : "false" );
          _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_33.setDisabled(disableThridLevel.toString());
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n    </td>\r\n  \t<td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("radio");
          _jspx_th_impact_validateInput_34.setDisabled("");
          _jspx_th_impact_validateInput_34.setLabel("I do not agree with the actions the county has taken and the allegations will be unsubstantiated ");
          _jspx_th_impact_validateInput_34.setId("FD2_3");
          _jspx_th_impact_validateInput_34.setName("rbInd3lvlFinDec");
          _jspx_th_impact_validateInput_34.setValue("N");
          _jspx_th_impact_validateInput_34.setCssClass("formInput");
          _jspx_th_impact_validateInput_34.setChecked("N".equals(ARIDetail.getSzCd3lvlAdminRvFnDec()) ? "true" : "false" );
          _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_34.setDisabled(disableThridLevel.toString());
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"21%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setWidth("31%");
          _jspx_th_impact_validateSelect_5.setName("selSzCd3lvlRsDisg");
          _jspx_th_impact_validateSelect_5.setLabel("Reason for Disagreement");
          _jspx_th_impact_validateSelect_5.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateSelect_5.setValue(FormattingHelper.formatString(ARIDetail.getSzCd3lvlAdminRsDisg()));
          _jspx_th_impact_validateSelect_5.setConditionallyRequired( (disableThridLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateSelect_5.setCodesTable("COVERTUR");
          _jspx_th_impact_validateSelect_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("text");
          _jspx_th_impact_validateInput_35.setLabel("Result");
          _jspx_th_impact_validateInput_35.setConditionallyRequired( (disableThridLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateInput_35.setConstraint("Comments");
          _jspx_th_impact_validateInput_35.setName("txtSz3lvlAdminRvAppealResult");
          _jspx_th_impact_validateInput_35.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateInput_35.setCssClass("formInput");
          _jspx_th_impact_validateInput_35.setValue( FormattingHelper.formatString(ARIDetail.getSzTxt3lvlAdminRevResults()) );
          _jspx_th_impact_validateInput_35.setSize("80");
          _jspx_th_impact_validateInput_35.setMaxLength("80");
          _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n  </tr>\r\n  <tr>\r\n   <td width=\"21%\">");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_19.setWidth("31%");
          _jspx_th_impact_validateDate_19.setName("txtDtDt3lvlAdminRvPersonNoti");
          _jspx_th_impact_validateDate_19.setLabel("Reviewed Person Notified On");
          _jspx_th_impact_validateDate_19.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateDate_19.setValue( FormattingHelper.formatDate( ARIDetail.getDtDt3lvlAdminRvPersonNotif()) );
          _jspx_th_impact_validateDate_19.setConditionallyRequired( (disableThridLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateDate_19.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_19 = _jspx_th_impact_validateDate_19.doStartTag();
          if (_jspx_th_impact_validateDate_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n   <td>\r\n\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("szTxt3lvlAdminRevResAppDen");
          _jspx_th_impact_validateTextArea_3.setLabel("Reason for Approval/Denial");
          _jspx_th_impact_validateTextArea_3.setDisabled(disableThridLevel.toString());
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired( (disableThridLevel == true) ? "false" : "true" );
          _jspx_th_impact_validateTextArea_3.setCols("92");
          _jspx_th_impact_validateTextArea_3.setRows("3");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setMaxLength(4000);
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.print( FormattingHelper.formatString(ARIDetail.getSzTxt3lvlAdminRevResAppDen()));
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t</td>\r\n  </tr>\r\n</table>\r\n\r\n");
 } //if(showLevelThree == true) { 
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td>\r\n    </td>\r\n    <td class=\"alignRight\">\r\n    ");
if (showSaveSubmit == true) {
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndClose");
          _jspx_th_impact_ButtonTag_1.setForm("frmAdmnReview");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/AdmnReview/saveAdmnReview");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setFunction("return closePage()");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
} // if (showSaveSubmit == true) 
          out.write("  \r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setForm("frmAdmnReview");
          _jspx_th_impact_ButtonTag_2.setAction("/workload/AdmnReview/saveAdmnReview");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setFunction("return savePage()");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<!--- End Detail Table --->\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
 if (showForms == true) { 
      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\tclass=\"tableBorder\">\r\n\t<tr>\r\n\t\t");
      out.write("\r\n\t\t<th colspan=\"4\">\r\n\t\t\tForms Launch\r\n\t\t</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode( pageMode );
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t");
if (showLevelOneOnly == false) { 
          out.write("\r\n\t\t\t\t ");
if(showLevelThree == true) {
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("CPS Administrative Review Decision Letter - 3rd Level");
          _jspx_th_impact_document_0.setProtectDocument(protectDocument);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("adminmemo3");
          _jspx_th_impact_document_0.setDocExists(true);
          _jspx_th_impact_document_0.setPreFillAlways(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pCase");
              _jspx_th_impact_documentParameter_0.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pEvent");
              _jspx_th_impact_documentParameter_2.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pPerson");
              _jspx_th_impact_documentParameter_3.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              if (_jspx_meth_impact_documentParameter_4(_jspx_th_impact_document_0, _jspx_page_context))
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t ");
} //if (showLevelThree == true)
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName("CPS Administrative Review Decision Letter - 2nd Level");
          _jspx_th_impact_document_1.setProtectDocument(protectDocument || disableSecondLevel);
          _jspx_th_impact_document_1.setCheckForNewMode(false);
          _jspx_th_impact_document_1.setDocType("adminmemo2");
          _jspx_th_impact_document_1.setDocExists(true);
          _jspx_th_impact_document_1.setPreFillAlways(true);
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_5.setName("pCase");
              _jspx_th_impact_documentParameter_5.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) );
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_6.setName("pStage");
              _jspx_th_impact_documentParameter_6.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) );
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_7.setName("pEvent");
              _jspx_th_impact_documentParameter_7.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) );
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_8 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_8.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_8.setName("pPerson");
              _jspx_th_impact_documentParameter_8.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) );
              int _jspx_eval_impact_documentParameter_8 = _jspx_th_impact_documentParameter_8.doStartTag();
              if (_jspx_th_impact_documentParameter_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              if (_jspx_meth_impact_documentParameter_9(_jspx_th_impact_document_1, _jspx_page_context))
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
} else { //<%if (showLevelOneOnly == false) 
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_2.setDisplayName("CPS Administrative Review Decision Letter - 1st Level");
          _jspx_th_impact_document_2.setProtectDocument(protectDocument);
          _jspx_th_impact_document_2.setCheckForNewMode(false);
          _jspx_th_impact_document_2.setDocType("adminmemo");
          _jspx_th_impact_document_2.setDocExists(true);
          _jspx_th_impact_document_2.setPreFillAlways(true);
          int _jspx_eval_impact_document_2 = _jspx_th_impact_document_2.doStartTag();
          if (_jspx_eval_impact_document_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_10 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_10.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
              _jspx_th_impact_documentParameter_10.setName("pCase");
              _jspx_th_impact_documentParameter_10.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) );
              int _jspx_eval_impact_documentParameter_10 = _jspx_th_impact_documentParameter_10.doStartTag();
              if (_jspx_th_impact_documentParameter_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_11 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_11.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
              _jspx_th_impact_documentParameter_11.setName("pStage");
              _jspx_th_impact_documentParameter_11.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) );
              int _jspx_eval_impact_documentParameter_11 = _jspx_th_impact_documentParameter_11.doStartTag();
              if (_jspx_th_impact_documentParameter_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_12 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_12.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
              _jspx_th_impact_documentParameter_12.setName("pEvent");
              _jspx_th_impact_documentParameter_12.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) );
              int _jspx_eval_impact_documentParameter_12 = _jspx_th_impact_documentParameter_12.doStartTag();
              if (_jspx_th_impact_documentParameter_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_13 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_13.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
              _jspx_th_impact_documentParameter_13.setName("pPerson");
              _jspx_th_impact_documentParameter_13.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) );
              int _jspx_eval_impact_documentParameter_13 = _jspx_th_impact_documentParameter_13.doStartTag();
              if (_jspx_th_impact_documentParameter_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              if (_jspx_meth_impact_documentParameter_14(_jspx_th_impact_document_2, _jspx_page_context))
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
} //<%if (showLevelOneOnly == false) 
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_3.setDisplayName("Response to Case Review Request");
          _jspx_th_impact_document_3.setProtectDocument(protectDocument);
          _jspx_th_impact_document_3.setCheckForNewMode(false);
          _jspx_th_impact_document_3.setDocType("respareq");
          _jspx_th_impact_document_3.setDocExists(true);
          _jspx_th_impact_document_3.setPreFillAlways(true);
          int _jspx_eval_impact_document_3 = _jspx_th_impact_document_3.doStartTag();
          if (_jspx_eval_impact_document_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_15 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_3);
              _jspx_th_impact_documentParameter_15.setName("pCase");
              _jspx_th_impact_documentParameter_15.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdCase() ) );
              int _jspx_eval_impact_documentParameter_15 = _jspx_th_impact_documentParameter_15.doStartTag();
              if (_jspx_th_impact_documentParameter_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_16 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_3);
              _jspx_th_impact_documentParameter_16.setName("pStage");
              _jspx_th_impact_documentParameter_16.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdStage() ) );
              int _jspx_eval_impact_documentParameter_16 = _jspx_th_impact_documentParameter_16.doStartTag();
              if (_jspx_th_impact_documentParameter_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_17 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_3);
              _jspx_th_impact_documentParameter_17.setName("pEvent");
              _jspx_th_impact_documentParameter_17.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdEvent()  ) );
              int _jspx_eval_impact_documentParameter_17 = _jspx_th_impact_documentParameter_17.doStartTag();
              if (_jspx_th_impact_documentParameter_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_18 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_3);
              _jspx_th_impact_documentParameter_18.setName("pPerson");
              _jspx_th_impact_documentParameter_18.setValue( FormattingHelper.formatInt( ARIDetail.getUlIdPersonRequestor()  ) );
              int _jspx_eval_impact_documentParameter_18 = _jspx_th_impact_documentParameter_18.doStartTag();
              if (_jspx_th_impact_documentParameter_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");
} //if (showForms == true)
      out.write("\r\n<br>\r\n");
 /* end Forms and Reports */ 
      out.write('\r');
      out.write('\n');

  if ( !bFindings  ||
       !bReqParent ||
       !bNotif     ||
       !bLic )
  {
    // SIR 22937 - Switch between CPS & APS versions of Cover Letter to
    // Requestor and Notif to Parent/Prof Reporter (Spanish or English)
    String CovLetReqEng = StringHelper.EMPTY_STRING;
    String CovLetReqSpa = StringHelper.EMPTY_STRING;
    String NotiToParEng = StringHelper.EMPTY_STRING;
    String NotiToParSpa = StringHelper.EMPTY_STRING;
    if ( GlobalData.getSzCdStageProgram( request ).equals(AdmnReviewConversation.PROG_CPS) )
    {
      //if CPS
      CovLetReqEng = AdmnReviewConversation.ADMIN_REV_REQSTR_ENG_CPS;
      CovLetReqSpa = AdmnReviewConversation.ADMIN_REV_REQSTR_SPA_CPS;
      NotiToParEng = AdmnReviewConversation.ADMIN_REV_PARENT_ENG_CPS;
      NotiToParSpa = AdmnReviewConversation.ADMIN_REV_PARENT_SPA_CPS;
    } else {
      //if !CPS
      CovLetReqEng = AdmnReviewConversation.ADMIN_REV_REQSTR_ENG;
      CovLetReqSpa = AdmnReviewConversation.ADMIN_REV_REQSTR_SPA;
      NotiToParEng = AdmnReviewConversation.ADMIN_REV_PARENT_ENG;
      NotiToParSpa = AdmnReviewConversation.ADMIN_REV_PARENT_SPA;
    }
}

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
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateDisplayOnlyField_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateDisplayOnlyField
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
    _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateDisplayOnlyField_2.setName("lbLevel");
    _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Level");
    int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
    if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
    _jspx_th_impact_documentParameter_4.setName("pSzCdAdRevType");
    _jspx_th_impact_documentParameter_4.setValue("3");
    int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
    if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_9 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
    _jspx_th_impact_documentParameter_9.setName("pSzCdAdRevType");
    _jspx_th_impact_documentParameter_9.setValue("2");
    int _jspx_eval_impact_documentParameter_9 = _jspx_th_impact_documentParameter_9.doStartTag();
    if (_jspx_th_impact_documentParameter_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_documentParameter_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_document_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:documentParameter
    gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_14 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
    _jspx_th_impact_documentParameter_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_documentParameter_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_2);
    _jspx_th_impact_documentParameter_14.setName("pSzCdAdRevType");
    _jspx_th_impact_documentParameter_14.setValue("1");
    int _jspx_eval_impact_documentParameter_14 = _jspx_th_impact_documentParameter_14.doStartTag();
    if (_jspx_th_impact_documentParameter_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
