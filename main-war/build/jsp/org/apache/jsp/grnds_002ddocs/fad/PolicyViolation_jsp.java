package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NcPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NcCbx;
import gov.georgia.dhr.dfcs.sacwis.web.fad.CorrectiveActionPlanConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import java.util.Arrays;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.fad.PolicyViolationConversation;

public final class PolicyViolation_jsp extends org.apache.jasper.runtime.HttpJspBase
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


//*--------------------------------------------------------------------------------
//*  JSP Name:     Policy Violation
//*  Created by:   ssubram
//*  Date Created: 06/05/08
//*
//*  Description:
//*  This JSP displays the Policy Violation.
//*
//*  Change History:
//*  Date      User       Description
//*  --------  ---------- ---------------------------------------------------------
//*  03/19/08  ssubram   - Initial Development
//*  08/26/08  vvo       - STGAP00009837 - change Violation Date field to be required field
//*  05/19/2010 arege    SMS#52234  SaveAndSubmit button should not be available if the page mode is VIEW
//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  String SPACES = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  
  String pageMode = PageModeConstants.VIEW;
  if( PageMode.getPageMode( request ) != null )
  {
    pageMode = PageMode.getPageMode( request );
  }

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile(request);
  
  //==================================================================================
  String eventStatus = "";
  String county = ContextHelper.getStringSafe(request, "selCounty");
  if("".equals(county)){
    county = user.getUserCounty();
  }
  String homeType = ContextHelper.getStringSafe(request, "homeType");
  String dateAchievement = ContextHelper.getStringSafe(request, "txtDtFiled");
  String editableMode = ContextHelper.getStringSafe(request, "editableMode");
  String resultsDesc =  ContextHelper.getStringSafe(request, "resultsDesc");
  String violationDate = ContextHelper.getStringSafe(request, "dtViolation");
  String effectFromDate = ContextHelper.getStringSafe(request, "dtEffectFrom");
  String effectToDate = ContextHelper.getStringSafe(request, "dtEffectTo");
  String dtLastUpdate = ContextHelper.getStringSafe(request, "dtLastUpdate");
  Iterator iter = null;
  int loopCounter = 0;
  Map<Integer, String> childrenInHomeHashmap = null;
  List policyViolationList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbxPolViolation_")); //-- NEW
  List<String> polVioList = new ArrayList<String>();
  String isDocumentCompleted = "false";
  String isStOffCon = "false";
  boolean isSecStCpaCon = false;
  boolean bProtectForm = (Boolean) state.getAttribute(PolicyViolationConversation.PROTECT_FORM, request);
  if("on".equals(ContextHelper.getStringSafe(request, "cbxDocumentCompleted"))) //-- NEW
  {
    isDocumentCompleted = "true";
  }
  
  int tabIndex = 1;
  //==================================================================================

  String s;
  java.util.Date d = null;
  java.text.SimpleDateFormat df = DateHelper.SLASH_FORMAT;
  NonComplianceSO nonComplianceSO = null;
  nonComplianceSO = (NonComplianceSO) state.getAttribute("nonComplianceSO",request);
  
  // Create a hashmap for the Children in the Home. The map will be
  // used to determine whether or not a child should selected in the
  // "Children in the Home" listbox.
  childrenInHomeHashmap = new HashMap<Integer, String>();
  if ( nonComplianceSO.getChildrenInHome() != null ){
	iter = nonComplianceSO.getChildrenInHome().iterator();
	while ( iter.hasNext() ){
	  NcPerson ncPerson = (NcPerson)iter.next();
	  childrenInHomeHashmap.put(ncPerson.getIdPerson(), ncPerson.getNmPersonFull());
	}
  }
  
  if (nonComplianceSO != null){
  	//Populate page from the retrieved data
  	//Home Type
  	s = nonComplianceSO.getHomeType();
  	if(s != null && !s.equals("")){
      homeType = s;
    }
  	//Achievement Date
  	d = nonComplianceSO.getDtTracking();
  	if(!DateHelper.isNull(d)){
  	  dateAchievement = df.format(d);
  	}
  	//Violation Date
  	d = nonComplianceSO.getDtOfViolation();
  	if(!DateHelper.isNull(d)){
  	  violationDate = df.format(d);
  	}
  	//Effect From Date
  	d = nonComplianceSO.getDtEffectFrom();
  	if(!DateHelper.isNull(d)){
  	  effectFromDate = df.format(d);
  	}
  	//Effect To Date
  	d = nonComplianceSO.getDtEffectTo();
  	if(!DateHelper.isNull(d)){
  	  effectToDate = df.format(d);
  	}
  	//Date Last Update
  	d = nonComplianceSO.getDtLastUpdate();
  	if(!DateHelper.isNull(d)){
  	  dtLastUpdate = df.format(d);
  	}  	
  	//Result Description
  	s = nonComplianceSO.getTxtComments();
  	if(s != null && !s.equals("")){
      resultsDesc = s;
    }
    //County
    s = nonComplianceSO.getCdCounty();
    if(s != null && !s.equals("")){
      county = s;
    }
    //Document Completed
    s = nonComplianceSO.getIndDocCompleted();
    if(s != null && !s.equals("")){
      if (s.equalsIgnoreCase("Y")){
        isDocumentCompleted = "true";
      }else{
        isDocumentCompleted = "false";
      }
    }
    //State Office Concurrence
    s = nonComplianceSO.getIndStOffCon();
    if(s != null && !s.equals("")){
      if (s.equalsIgnoreCase("Y")){
        isStOffCon = "true";
      }else{
        isStOffCon = "false";
      }
    }   
	//Get the Security Attribute for State office Concurrence
	s = nonComplianceSO.getSecurityStCpaCon();
	if(s != null && !s.equals("")){
      if (s.equalsIgnoreCase("Y")){
        isSecStCpaCon = false;
      }else{
        isSecStCpaCon = true;
      }
    }   
    //Get the Policy Violation list
    if(nonComplianceSO.getNcCbx() != null && nonComplianceSO.getNcCbx().size() > 0){
     
     iter = nonComplianceSO.getNcCbx().iterator();
	 while ( iter.hasNext() ){
	   NcCbx ncCbx = (NcCbx)iter.next();
	   polVioList.add(ncCbx.getCdNonComplianceCbx());
	 }
     // policyViolationList = Arrays.asList(PolVioList);
    }
    //Get Event Status
    if (nonComplianceSO.getNcEvent() != null){
	    s = nonComplianceSO.getNcEvent().getEventStatusCode();
	    if(s != null && !s.equals("")){
	      eventStatus = s;
	    }else{
	      eventStatus = "";
	    }
    }else {
    	eventStatus = "";
    }
  }
  
  if(eventStatus.equals("")){
    eventStatus = CodesTables.CEVTSTAT_NEW;
  }
  

      out.write('\r');
      out.write('\n');
 /* Needed for Form Launch Custom tag */ 
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n");
 /* Start Javascript Section */ 
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  /*\r\n   * This function is called before the page unloads. It creates the\r\n   * \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n   */\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n");

//-- one boolean for each button to represent if the button should be displayed
boolean approvalStatus = true;
boolean save = true;
boolean saveAndSubmit = true;
boolean docExists = false;
boolean bDocCompleted = false;
boolean bDtAchieved = false;
boolean bResultsDesc = false;
boolean bProtectFormDocument = false;

//-- one String to represent if fields should be disabled
String disableFields = "false";
if( ArchitectureConstants.TRUE.equals( request.getAttribute( CorrectiveActionPlanConversation.DOCEXISTS) ) )
{
    docExists = true;
}

    
String rej = (String) request.getAttribute("approvalRejected");
if( pageMode.equals(PageModeConstants.NEW) ||
    pageMode.equals(PageModeConstants.NEW_USING) ||
  (!eventStatus.equals(CodesTables.CEVTSTAT_PEND) &&
   !eventStatus.equals(CodesTables.CEVTSTAT_APRV) &&
   !"true".equals(rej))){
    approvalStatus = false;
}
if(eventStatus.equals(CodesTables.CEVTSTAT_COMP)){
	bDocCompleted = true;
}
if(eventStatus.equals(CodesTables.CEVTSTAT_APRV)){
  saveAndSubmit = false;
  bDocCompleted = true;
  bDtAchieved = false;
  bResultsDesc = false;
  isSecStCpaCon = true;
  disableFields = "true";
}
if(eventStatus.equals(CodesTables.CEVTSTAT_PEND)){
  saveAndSubmit = false;
  bDocCompleted = true;
}

if(PageModeConstants.VIEW.equals(pageMode)){
saveAndSubmit = false;
}

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
      _jspx_th_impact_validateForm_0.setName("frmPolViolation");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/fad/PolicyViolation/displayPolicyViolation");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.fad.PolicyViolationCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

if(approvalStatus){

          out.write("\r\n    <td>\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setForm("frmPolViolation");
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/displayStatus");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

} else{

          out.write("\r\n    <td>&nbsp;</td>\r\n");

}

          out.write("\r\n    ");
          out.write("\r\n  </tr>\r\n</table>\r\n");

if(approvalStatus){

          out.write("\r\n<br>\r\n");

}
int entireColspan = 4; //-- this must be even

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"");
          out.print( entireColspan + 1);
          out.write("\">Policy Violation Report</th>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    Home Type:\r\n  </td>\r\n  <td>\r\n    ");
          out.print(homeType );
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");

    //----------------------------------
    //--- Staffing Date ---
    //----------------------------------
    
          out.write("\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtAchievement");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setLabel("Staffing Date");
          _jspx_th_impact_validateDate_0.setSize("7");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setDisabled( String.valueOf(bDtAchieved) );
          _jspx_th_impact_validateDate_0.setValue( dateAchievement );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n   <td>\r\n    ");

    //----------------------------------
    //--- Document Completed ---
    //----------------------------------
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setName("cbxDocumentCompleted");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setLabel("Document Completed");
          _jspx_th_impact_validateInput_0.setType("checkbox");
          _jspx_th_impact_validateInput_0.setChecked( isDocumentCompleted );
          _jspx_th_impact_validateInput_0.setDisabled( String.valueOf(bDocCompleted) );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n   <td>\r\n    ");

    //----------------------------------
    //--- State Office Concurrence ---
    //----------------------------------
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setName("cbxIndStOffCon");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setLabel("State Office Concurrence");
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setChecked( isStOffCon );
          _jspx_th_impact_validateInput_1.setDisabled( String.valueOf(isSecStCpaCon) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");

    //----------------------------------
    //--- Staffing Outcomes ---
    //----------------------------------
    
          out.write("\r\n    ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtResultsDescription");
          _jspx_th_impact_validateTextArea_0.setLabel("Staffing Outcomes");
          _jspx_th_impact_validateTextArea_0.setTitle("Staffing Outcomes");
          _jspx_th_impact_validateTextArea_0.setColspan("4");
          _jspx_th_impact_validateTextArea_0.setRows("6");
          _jspx_th_impact_validateTextArea_0.setCols("130");
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf(bResultsDesc) );
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n    ");
              out.print( FormattingHelper.formatString( resultsDesc ) );
              out.write("\r\n    ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n<tr>\r\n  <td>\r\n    ");

    //----------------------------------
    //--- County of Violation ---
    //----------------------------------
    
          out.write("  \r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("countyOfViolation");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setLabel("County of Violation");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setValue( county );
          _jspx_th_impact_validateSelect_0.setDisabled( disableFields );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");

    //----------------------------------
    //--- Violation Date ---
    //----------------------------------
    // STGAP00009837 - change this field to be required field
    
          out.write("   \r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("txtDtViolation");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setLabel("Violation Date");
          _jspx_th_impact_validateDate_1.setSize("7");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setValue( violationDate );
          _jspx_th_impact_validateDate_1.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>  \r\n</tr>\r\n</table>\r\n\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"2\" width=\"100%\" class=\"tableBorder\">\r\n\t<tr>\r\n\t  <td width=\"50%\">\r\n\t    <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" height=\"135\" class=\"tableborder\">\r\n\t      <tr>\r\n\t\t<th>Children in the Home</th>\r\n\t      </tr>\r\n\t      <tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t  <div style=\"overflow:auto; WIDTH: 375px; HEIGHT: 135px\" class=\"tableborderList\">\r\n\t\t    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" >\r\n\t\t      <tr>\r\n\t\t\t\t<th class=\"thList\">Name</th>\r\n\t\t\t\t<th class=\"thList\">Involved In<br>Violation</th>\r\n\t\t\t\t<th class=\"thList\">In Adoptive<br>Process</th>\r\n\t\t      </tr>\r\n                ");

	                //------------------------------
	                //--- Children in the Home ---
	                //------------------------------
	                // Iterate through the Children and display.
	                loopCounter = 0;
	                String isSelectedHV = null;
	                String isSelectedAP = null;
	                iter = nonComplianceSO.getChildrenInHome().iterator();
	                while ( iter.hasNext() ){
	                  NcPerson ncPerson = (NcPerson)iter.next();
	                  isSelectedHV = ncPerson.getIndHomeViolation();
	                  isSelectedAP = ncPerson.getIndAdoptiveProcess();
	                  String checkboxHomeViolation = "cbxHomeViolation_" + loopCounter;
	                  String checkboxAdoptiveProcess = "cbxAdoptiveProcess_" + loopCounter;
                
          out.write("\r\n                <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCounter + 1 ) );
          out.write("\">\r\n                  <td>");
          out.print( ncPerson.getNmPersonFull() );
          out.write("</td>\r\n                  <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("checkbox");
          _jspx_th_impact_validateInput_2.setName( checkboxHomeViolation );
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( ncPerson.getIdPerson() ) );
          _jspx_th_impact_validateInput_2.setChecked( isSelectedHV );
          _jspx_th_impact_validateInput_2.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setDisabled( disableFields );
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>\r\n                  <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setName( checkboxAdoptiveProcess );
          _jspx_th_impact_validateInput_3.setValue( String.valueOf( ncPerson.getIdPerson() ) );
          _jspx_th_impact_validateInput_3.setChecked( isSelectedAP );
          _jspx_th_impact_validateInput_3.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setDisabled( disableFields );
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                  </td>                  \r\n                </tr>\r\n                ");

                  loopCounter++;
                } // end while ( iter.hasNext() )
                
          out.write("\t                \t      \r\n\t\t    </table>\r\n\t\t  </div>\r\n\t\t</td>\r\n\t      </tr>\r\n\t    </table>\r\n\t  </td>\r\n\t  <td width=\"50%\">\r\n\t    <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" height=\"135\" class=\"tableborder\">\r\n\t      <tr>\r\n\t\t<th><span class=\"formRequiredText\">*</span>Policy Violation</th>\r\n\t      </tr>\r\n\t      <tr>\r\n\t\t<td colspan=\"2\">\r\n\t\t  <div style=\"overflow:auto; WIDTH: 375px; HEIGHT: 135px\" class=\"tableborderList\">\r\n\t\t    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" >\r\n\t\t\t\t<tr>\r\n\t\t\t\t  <td colspan=\"");
          out.print( entireColspan );
          out.write("\">\r\n\t\t\t\t    ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbxPolViolation_");
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CPOLVIOL );
          _jspx_th_impact_codesCheckbox_0.setColumns(1);
          _jspx_th_impact_codesCheckbox_0.setDisabled( disableFields );
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes( polVioList );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t  </td>\r\n\t\t\t\t</tr>\r\n\t\t    </table>\r\n\t\t  </div>\r\n\t\t</td>\r\n\t      </tr>\r\n\t    </table>\r\n\t  </td>  \r\n\t</tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">\r\n<tr>\r\n  <td>\r\n    ");

    //----------------------------------
    //--- Last Update Date ---
    //----------------------------------
    
          out.write("\r\n    Last Update Date: &nbsp;&nbsp; ");
          out.print( dtLastUpdate );
          out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr>\r\n  <td>\r\n  </td>\r\n  <td>\r\n    <div class=\"alignRight\">\r\n      ");
          out.print( SPACES );
          out.write('\r');
          out.write('\n');

if(saveAndSubmit){

          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_1.setForm("frmPolViolation");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/fad/PolicyViolation/saveSubmitPolicyViolation");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

} else{

          out.print( SPACES );

}

          out.write('\r');
          out.write('\n');

if(save){

          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setForm("frmPolViolation");
          _jspx_th_impact_ButtonTag_2.setAction("/fad/PolicyViolation/savePolicyViolation");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

} else{
  out.print(SPACES);
}

          out.write("\r\n    </div>\r\n  </td>\r\n</tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<table>\r\n<tr><td>\r\n\r\n");
      //  impact:documentButton
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag _jspx_th_impact_documentButton_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentButtonTag();
      _jspx_th_impact_documentButton_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentButton_0.setParent(null);
      _jspx_th_impact_documentButton_0.setPageMode( pageMode );
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnDocument.gif");
      _jspx_th_impact_documentButton_0.setTabIndex( tabIndex++ );
      _jspx_th_impact_documentButton_0.setAccessKey("W");
      int _jspx_eval_impact_documentButton_0 = _jspx_th_impact_documentButton_0.doStartTag();
      if (_jspx_eval_impact_documentButton_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n                               \r\n       ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentButton_0);
          _jspx_th_impact_document_0.setDisplayName("Policy Violation Document");
          _jspx_th_impact_document_0.setProtectDocument( bProtectForm );
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setDocType("cfa09o00");
          _jspx_th_impact_document_0.setPreFillAlways(true);
          _jspx_th_impact_document_0.setDocExists( docExists );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pCase");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("  \r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( String.valueOf(GlobalData.getUlIdStage(request)) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write(" \r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pEvent");
              _jspx_th_impact_documentParameter_2.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("   \r\n                               \r\n                     ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pNonCompliance");
              _jspx_th_impact_documentParameter_3.setValue( String.valueOf(nonComplianceSO.getIdNonCompliance()) );
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("                                                                                \r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_4.setName("sEvent");
              _jspx_th_impact_documentParameter_4.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("               \r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_5.setName("sCase");
              _jspx_th_impact_documentParameter_5.setValue( String.valueOf(GlobalData.getUlIdCase(request)) );
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("   \r\n\r\n            ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          int evalDoAfterBody = _jspx_th_impact_documentButton_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentButton_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n</td></tr>\r\n\r\n</table>");
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
}
