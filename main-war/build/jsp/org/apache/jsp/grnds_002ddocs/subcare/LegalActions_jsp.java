package org.apache.jsp.grnds_002ddocs.subcare;

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
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AttendeePerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB38SOG01;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.LegalActionsConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.ArrayList;
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

public final class LegalActions_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/**
 * JSP Name:     LegalActions.jsp
 * Created by:   Carolyn Douglass
 * Date Created: 03/03/03
 *
 * Description:
 * The user will be able to enter, modify and browse the legal activity
 * information.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  04/13/04  C. Douglass       SIR 22658 - add new codes table CCAA, CCUU
  05/10/04  C. Douglass       SIR 22891 - end dated codes table items
                              not showing up in dropdowns.  Add value =
                              subtype to code arrays.
  06/17/04  C. Douglass       SIR 22873 - disable Date Filed and Outcome
                              for CPS to simplify entry
  09/12/06  abgoode           The page has been completely overhauled for
                              Release 1 of GA SACWIS
  11/04/08  arege             Per STGAP000010758 Legal Action and Outcome Detail Design Document.
                              The SaveAndSubmit button should not be displayed for the Supervisor in Approval Mode.
                              This will prevent an extra To-Do being created.
  05/05/09  hjbaptiste        STGAP00013538 - Added preventDoubleClick property to the Save and Save and Submit buttons. 
                              Also place the buttons into their own column    
  09/02/09  bgehlot           STGAP00015257: When copying legal action (Court Order Signed, Amendment to Court Order, 
                              Update to Previous Action )three checkboxes should be copied too  
  02/08/10  mxpatel           CAPTA: Added validations for CAPTA changes. Added new fields on the page                                                    
  02/10/10  mxpatel           STGAP00015776: Modify the label to display "CASA or Atty/GAL) Assigned" instead of "CASA or Atty/Gua Ad Litem) Appointed"
  03/16/10  arege             SMS#48132: Changed label No Representation Assigned on Legal Actions page.
  12/12/10  hnguyen           SMS#81144: Corrected population for Continuance Date.
  
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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
  String usState = ContextHelper.getStringSafe(request, "selState"); //-- NEW
  if("".equals(usState)){
    usState = CodesTables.CSTATE_GA;
  }
  
  int courtFileNumber = ContextHelper.getIntSafe(request, "ulCtFileNum");
  String dateFiled = ContextHelper.getStringSafe(request, "txtDtFiled");
  String courtCaseNumber = ContextHelper.getStringSafe(request, "ulCtCaseNum");
  String courtActionDate = ContextHelper.getStringSafe(request, "dtCtActDate");
  String courtType = ContextHelper.getStringSafe(request, "selCtType");
  String action = ContextHelper.getStringSafe(request, "selLegalAction");
  String hTypeCtOrder = ContextHelper.getStringSafe(request, "selHTypeCtOrder");
  String nxtCtHDate = ContextHelper.getStringSafe(request, "dtNxtCtHDate");
  String contDate = ContextHelper.getStringSafe(request, "dtContDate");
  String ctOrderDate = ContextHelper.getStringSafe(request, "dtCtOrderDate");
  String pubDate = ContextHelper.getStringSafe(request, "dtPubDate");
  String scaDate = ContextHelper.getStringSafe(request, "dtShelterCareAuth"); //-- NEW
  String scaTime = ContextHelper.getTimeSafe(request, "tmShelterCareAuth"); //-- NEW
  String ctOrderPrepBy = ContextHelper.getStringSafe(request, "szCtOrderPrepBy"); //-- NEW
  List outcomeList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbgOutcome_")); //-- NEW
  List ctOrdLangList = Arrays.asList(CheckboxHelper.getCheckedValues(request, "cbgCtOrdLang_")); //-- NEW
  String szCdStage = GlobalData.getSzCdStage(request);
  String isUpdate = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxUpdate")))
  {
    isUpdate = "true";
  }
  
  String isInCaseFile = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "ckInCaseFile")))
  {
    isInCaseFile = "true";
  }
  
  String isComplete = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxComplete")))
  {
    isComplete = "true";
  }
  
  String isRepAppointed = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxBIndNoRepAppointed")))
  {
    isRepAppointed = "true";
  }
  
  String isSigned = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxCtOrderSigned"))) //-- NEW
  {
    isSigned = "true";
  }
  
  String isAmendment = "false";
  if("on".equals(ContextHelper.getStringSafe(request, "cbxAmendment"))) //-- NEW
  {
    isAmendment = "true";
  }
  
  AttendeePerson_Array attendees = null;  
  CSUB38SO csub38so = null;
  int tabIndex = 1;
  //==================================================================================

  String s;
  java.util.Date d = null;
  org.exolab.castor.types.Date cd = null;
  java.text.SimpleDateFormat df = DateHelper.SLASH_FORMAT;

  csub38so = (CSUB38SO) state.getAttribute("CSUB38SO", request);
  if(csub38so != null ){
    if(csub38so.getSzCdOutcome_Array() != null && csub38so.getSzCdOutcome_Array().getUlRowQty() > 0){
      outcomeList = Arrays.asList(csub38so.getSzCdOutcome_Array().getSzCdOutcome());
    }
    
    if(csub38so.getSzCdCrtLang_Array() != null && csub38so.getSzCdCrtLang_Array().getUlRowQty() > 0){
      ctOrdLangList = Arrays.asList(csub38so.getSzCdCrtLang_Array().getSzCdCrtLang());
    }
    
    if(csub38so.getAttendeePerson_Array() != null){
      attendees = csub38so.getAttendeePerson_Array();
    }
    
    if(csub38so.getROWCSUB38SOG00() != null){
      s = csub38so.getROWCSUB38SOG00().getSzCdEventStatus();
      if(s != null && !s.equals("")){
        eventStatus = s;
      }
    }
    
    if(csub38so.getROWCSUB38SOG01() != null){
      ROWCSUB38SOG01 legalAction = csub38so.getROWCSUB38SOG01();
      
      //county
      s = legalAction.getSzCdCounty();
      if(s != null && !s.equals("")){
        county = s;
      }
      
      //courtFileNumber
      int i = legalAction.getUlNbrCrtFile();
      courtFileNumber = i>0 ? i : courtFileNumber;
      
      //dateFiled
      cd = legalAction.getDtDtLegalActDateFiled();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        dateFiled = df.format(d);
      }
      
      //courtCaseNumber
      s = legalAction.getSzCdCrtCaseNbr();
      if(s != null && !s.equals("")){
        courtCaseNumber = s;
      }
      
      //courtActionDate
      cd = legalAction.getDtCrtActDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        courtActionDate = df.format(d);
      }
      
      //courtType
      s = legalAction.getSzCdCrtType();
      if(s != null && !s.equals("")){
        courtType = s;
      }
      
      //action
      s = legalAction.getSzCdLegalActAction();
      if(s != null && !s.equals("")){
        action = s;
      }
      
      //hTypeCtOrder
      s = legalAction.getSzCdHrTypCrtOrd();
      if(s != null && !s.equals("")){
        hTypeCtOrder = s;
      }
      
      //nxtCtHDate
      cd = legalAction.getDtNxtHearDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        nxtCtHDate = df.format(d);
      }
      
      //contDate
      cd = legalAction.getDtContinDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        contDate = df.format(d);
      }
      
      //ctOrderDate
      cd = legalAction.getDtCrtOrdDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        ctOrderDate = df.format(d);
      }
      
      //pubDate
      cd = legalAction.getDtPubDate();
      if(!DateHelper.isNull(cd)){
        d = cd.toDate();
        pubDate = df.format(d);
      }
      
      //usState
      s = legalAction.getSzCdState();
      if(s != null && !s.equals("")){
        usState = s;
      }
      
      //scaDate and scaTime
      d = legalAction.getTsDtShelterCareAuth();
      if(!DateHelper.isNull(d)){
        scaDate = df.format(d);
        scaTime = DateHelper.AM_PM_TIME_FORMAT.format(d);
      }
      
      //ctOrderPrepBy
      s = legalAction.getNmCrtOrdPrepBy();
      if(s != null && !s.equals("")){
        ctOrderPrepBy = s;
      }
      
      //isUpdate, isInCaseFile, isComplete      
      s = legalAction.getCIndLegalActDocsNCase();
      if(s != null && s.equals(LegalActionsConversation.INDICATOR_YES)){
        isInCaseFile = "true";
      }
      
      //STGAP00015257: When copying legal action below three checkboxes should be copied too.
      s = legalAction.getIndUpPrevAct();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isUpdate = "true";
      }
        
      s = legalAction.getIndCrtOrdSigned();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isSigned = "true";
      }
      
      s = legalAction.getBIndNoRepAppointed();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isRepAppointed = "true";
      }
        
      s = legalAction.getIndAmendment();
      if(LegalActionsConversation.INDICATOR_YES.equals(s)){
          isAmendment = "true";
      }
      
      if(!(pageMode.equals(PageModeConstants.NEW_USING) || pageMode.equals(PageModeConstants.NEW))){
        s = legalAction.getIndComplete();
        if(LegalActionsConversation.INDICATOR_YES.equals(s) && !LegalActionsConversation.STATUS_PENDING.equals(eventStatus)){
          isComplete = "true";
        }
      }
    }
  }
  
  if(eventStatus.equals("")){
    eventStatus = LegalActionsConversation.STATUS_NEW;
  }
  
  // if Event Status is COMP, and pagemode is not NEW USING, page should be in INQUIRE mode
  if ((eventStatus.equals(LegalActionsConversation.STATUS_COMPLETE) || eventStatus.equals(LegalActionsConversation.STATUS_APPROVED)) && 
      !pageMode.equals(PageModeConstants.NEW_USING)){
    pageMode = PageModeConstants.INQUIRE;
  }

      out.write('\r');
      out.write('\n');
 /* Needed for Form Launch Custom tag */ 
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n");
 /* Start Javascript Section */ 
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  /*\r\n   * This function is called before the page unloads. It creates the\r\n   * \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n   */\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n}\r\n</script>\r\n");

//-- one boolean for each button to represent if the button should be displayed
boolean approvalStatus = true;
boolean narrative = true;
boolean save = true;
boolean saveAndSubmit = true;
boolean docExists = false;
//-- one String to represent if fields should be disabled
String disableFields = "false";
if( ArchitectureConstants.TRUE.equals( request.getAttribute( LegalActionsConversation.DOCEXISTS) ) )
{
    docExists = true;
}

    
String rej = (String) request.getAttribute("approvalRejected");
if( pageMode.equals(PageModeConstants.NEW) ||
    pageMode.equals(PageModeConstants.NEW_USING) ||
  (!eventStatus.equals(LegalActionsConversation.STATUS_PENDING) &&
   !eventStatus.equals(LegalActionsConversation.STATUS_APPROVED) &&
   !"true".equals(rej))){
    approvalStatus = false;
}
if(pageMode.equals(PageModeConstants.INQUIRE)){
  narrative = false;
  save = false;
  saveAndSubmit = false;
  disableFields = "true";
}

//-- The SaveAndSubmit button should not be displayed for the Supervisor in Approval Mode.
//-- This will prevent an extra To-Do being created.
//-- Per STGAP000010758 Legal Action and Outcome Detail Design Document.
if(GlobalData.isApprovalMode(request)){
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
      _jspx_th_impact_validateForm_0.setName("frmLegalActions");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/LegalActions/displayLegalActions");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.LegalActionsCustomValidation");
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
          _jspx_th_impact_ButtonTag_0.setForm("frmLegalActions");
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

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n<tr>\r\n  <th colspan=\"");
          out.print( entireColspan );
          out.write("\">Legal Action</th>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selCounty");
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CCOUNT );
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setValue( county );
          _jspx_th_impact_validateSelect_0.setDisabled( disableFields );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName("selState");
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CSTATE );
          _jspx_th_impact_validateSelect_1.setBlankValue("false");
          _jspx_th_impact_validateSelect_1.setContentType( SelectTag.CODES );
          _jspx_th_impact_validateSelect_1.setValue( usState );
          _jspx_th_impact_validateSelect_1.setDisabled( disableFields );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("txtDtFiled");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setLabel("Date Filed");
          _jspx_th_impact_validateDate_0.setSize("7");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setValue( dateFiled );
          _jspx_th_impact_validateDate_0.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setName("ulCtFileNum");
          _jspx_th_impact_validateInput_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_0.setLabel("Court File Number");
          _jspx_th_impact_validateInput_0.setType("text");
          _jspx_th_impact_validateInput_0.setSize("8");
          _jspx_th_impact_validateInput_0.setMaxLength("10");
          _jspx_th_impact_validateInput_0.setConstraint("Digit10");
          _jspx_th_impact_validateInput_0.setValue( courtFileNumber <= 0 ? "" : ""+courtFileNumber );
          _jspx_th_impact_validateInput_0.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("dtCtActDate");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setLabel("Court/Action Date");
          _jspx_th_impact_validateDate_1.setSize("7");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setRequired("true");
          _jspx_th_impact_validateDate_1.setValue( courtActionDate );
          _jspx_th_impact_validateDate_1.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setName("ulCtCaseNum");
          _jspx_th_impact_validateInput_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_1.setLabel("Court Case Number");
          _jspx_th_impact_validateInput_1.setType("text");
          _jspx_th_impact_validateInput_1.setSize("17");
          _jspx_th_impact_validateInput_1.setMaxLength("15");
          _jspx_th_impact_validateInput_1.setConstraint("Any15");
          _jspx_th_impact_validateInput_1.setValue( courtCaseNumber );
          _jspx_th_impact_validateInput_1.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName("selLegalAction");
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setLabel("Action");
          _jspx_th_impact_validateSelect_2.setCodesTable( CodesTables.CLEGCPS );
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setRequired("true");
          _jspx_th_impact_validateSelect_2.setValue( action );
          _jspx_th_impact_validateSelect_2.setDisabled( disableFields );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName("selHTypeCtOrder");
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setLabel("Hearing Type/Court Order");
          _jspx_th_impact_validateSelect_3.setCodesTable( CodesTables.CLHECOT );
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setValue( hTypeCtOrder );
          _jspx_th_impact_validateSelect_3.setDisabled( disableFields );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setName("dtShelterCareAuth");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setLabel("Date Shelter Care Authorized");
          _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_2.setSize("7");
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          _jspx_th_impact_validateDate_2.setValue( scaDate );
          _jspx_th_impact_validateDate_2.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateTime
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag _jspx_th_impact_validateTime_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TimeTag();
          _jspx_th_impact_validateTime_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTime_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTime_0.setName("tmShelterCareAuth");
          _jspx_th_impact_validateTime_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTime_0.setLabel("Time Shelter Care Authorized");
          _jspx_th_impact_validateTime_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTime_0.setValue( scaTime );
          _jspx_th_impact_validateTime_0.setDisabled( disableFields );
          int _jspx_eval_impact_validateTime_0 = _jspx_th_impact_validateTime_0.doStartTag();
          if (_jspx_th_impact_validateTime_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setName("dtNxtCtHDate");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_3.setLabel("Next Court Hearing Date");
          _jspx_th_impact_validateDate_3.setSize("7");
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          _jspx_th_impact_validateDate_3.setValue( nxtCtHDate );
          _jspx_th_impact_validateDate_3.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setName("selCtType");
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setLabel("Court Type");
          _jspx_th_impact_validateSelect_4.setCodesTable( CodesTables.CCRTTYPE );
          _jspx_th_impact_validateSelect_4.setBlankValue("true");
          _jspx_th_impact_validateSelect_4.setValue( courtType );
          _jspx_th_impact_validateSelect_4.setDisabled( disableFields );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setName("dtContDate");
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_4.setLabel("Continuance Date");
          _jspx_th_impact_validateDate_4.setSize("7");
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          _jspx_th_impact_validateDate_4.setValue( contDate );
          _jspx_th_impact_validateDate_4.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setName("dtPubDate");
          _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_5.setLabel("Publication Start Date");
          _jspx_th_impact_validateDate_5.setSize("7");
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          _jspx_th_impact_validateDate_5.setValue( pubDate );
          _jspx_th_impact_validateDate_5.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setName("szCtOrderPrepBy");
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_2.setLabel("Court Order Prepared By");
          _jspx_th_impact_validateInput_2.setType("text");
          _jspx_th_impact_validateInput_2.setSize("27");
          _jspx_th_impact_validateInput_2.setMaxLength("40");
          _jspx_th_impact_validateInput_2.setConstraint("Name40");
          _jspx_th_impact_validateInput_2.setValue( ctOrderPrepBy );
          _jspx_th_impact_validateInput_2.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n    ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_6.setName("dtCtOrderDate");
          _jspx_th_impact_validateDate_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_6.setLabel("Court Order Date");
          _jspx_th_impact_validateDate_6.setSize("7");
          _jspx_th_impact_validateDate_6.setConstraint("Date");
          _jspx_th_impact_validateDate_6.setValue( ctOrderDate );
          _jspx_th_impact_validateDate_6.setDisabled( disableFields );
          int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
          if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"");
          out.print( entireColspan/2 );
          out.write("\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setName("cbxCtOrderSigned");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setLabel("Court Order Signed");
          _jspx_th_impact_validateInput_3.setType("checkbox");
          _jspx_th_impact_validateInput_3.setChecked( isSigned );
          _jspx_th_impact_validateInput_3.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td colspan=\"");
          out.print( entireColspan/2 );
          out.write("\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setName("cbxAmendment");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setLabel("Amendment to Court Order");
          _jspx_th_impact_validateInput_4.setType("checkbox");
          _jspx_th_impact_validateInput_4.setChecked( isAmendment );
          _jspx_th_impact_validateInput_4.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"");
          out.print( entireColspan/2 );
          out.write("\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setName("ckInCaseFile");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setLabel("Document in Case File");
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setChecked( isInCaseFile );
          _jspx_th_impact_validateInput_5.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td colspan=\"");
          out.print( entireColspan/2 );
          out.write("\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setName("cbxUpdate");
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setLabel("Update to Previous Action");
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setChecked( isUpdate );
          _jspx_th_impact_validateInput_6.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr><td colspan=\"");
          out.print( entireColspan );
          out.write("\"><br></td></tr>\r\n<tr class=\"tableBG\">\r\n  <th colspan=\"");
          out.print( entireColspan );
          out.write("\">Court Order Language</th>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"");
          out.print( entireColspan );
          out.write("\">\r\n    ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName("cbgCtOrdLang_");
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_codesCheckbox_0.setCodesTableName( CodesTables.CCRTLANG );
          _jspx_th_impact_codesCheckbox_0.setColumns(1);
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes( ctOrdLangList );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr><td colspan=\"");
          out.print( entireColspan );
          out.write("\"><br></td></tr>\r\n<tr class=\"tableBG\">\r\n  <th colspan=\"");
          out.print( entireColspan );
          out.write("\">Outcomes</th>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"");
          out.print( entireColspan );
          out.write("\">\r\n    ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_1.setName("cbgOutcome_");
          _jspx_th_impact_codesCheckbox_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_codesCheckbox_1.setCodesTableName( CodesTables.CLEGLOUT );
          _jspx_th_impact_codesCheckbox_1.setColumns(3);
          _jspx_th_impact_codesCheckbox_1.setDefaultCodes( outcomeList );
          int _jspx_eval_impact_codesCheckbox_1 = _jspx_th_impact_codesCheckbox_1.doStartTag();
          if (_jspx_th_impact_codesCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr><td colspan=\"");
          out.print( entireColspan );
          out.write("\"><br></td></tr>\r\n<tr class=\"tableBG\">\r\n  <th colspan=\"");
          out.print( entireColspan );
          out.write("\">Attendees/Involved Parties</th>\r\n</tr>\r\n<tr>\r\n  <td colspan=\"");
          out.print( entireColspan );
          out.write("\">\r\n    <div id=\"scrollableList\" style=\"height:130px;width:100%;overflow-x:hidden;overflow-y:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n");

if(attendees != null)
{

          out.write("\r\n      <tr>\r\n        <th class=\"thList\">Name</th>\r\n        <th class=\"thList\">Type</th>\r\n        <th class=\"thList\">Role</th>\r\n        <th class=\"thList\">Relation/Interest</th>\r\n      </tr>\r\n");

  int i = 0;
  for(Enumeration e=attendees.enumerateAttendeePerson(); e.hasMoreElements();)
  {
    AttendeePerson person = (AttendeePerson) e.nextElement();

          out.write("\r\n      <tr class=\"");
          out.print( FormattingHelper.getRowCss(i++) );
          out.write("\">\r\n        <td>\r\n          ");
 String cbxId = "cbxAttendee"+i; 
          out.write("\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setName( cbxId );
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setChecked( person.getUlIndIsAttendee() == 0 ? "false" : "true" );
          _jspx_th_impact_validateInput_7.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.print( person.getSzNmPersonFull() );
          out.write("\r\n        </td>\r\n        <td>");
          out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe(CodesTables.CPRSNTYP, person.getSzCdStagePersType())) );
          out.write("</td>\r\n        <td>");
          out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe(CodesTables.CROLEALL, person.getSzCdStagePersRole())) );
          out.write("</td>\r\n        <td>");
          out.print( FormattingHelper.changeCase(Lookup.simpleDecodeSafe(CodesTables.CRPTRINT, person.getSzCdStagePersRelInt())) );
          out.write("</td>\r\n      </tr>\r\n");

  }
}
else
{

          out.write("\r\n      <tr><td class=\"formInstruct\">No attendees/involved parties associated to the legal action.</td></tr>\r\n");

}

          out.write("\r\n    </table>\r\n    </div>\r\n  </td>\r\n</tr>\r\n</table>\r\n");
// Display these Options dropdown only if we are in FCC or ADO stage
      if ("SUB".equals(szCdStage) || "ADO".equals(szCdStage)) {

          out.write("\r\n<tr>\r\n<td class=\"alignLeft\"  width=\"30%\" valign=\"bottom\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setName("cbxBIndNoRepAppointed");
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setLabel("No Representation (CASA or GAL Atty or GAL Non-Atty) Assigned");
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setChecked( isRepAppointed );
          _jspx_th_impact_validateInput_8.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          out.print( SPACES );
          out.write("\r\n  </td> \r\n</tr>\t\r\n");
}

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n<tr>\r\n  <td width=\"50%\">\r\n  </td>\r\n  <td class=\"alignRight\"  width=\"30%\" valign=\"bottom\">\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setName("cbxComplete");
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setLabel("Complete");
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setChecked( isComplete );
          _jspx_th_impact_validateInput_9.setDisabled( disableFields );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          out.print( SPACES );
          out.write("\r\n  </td>      \r\n");

if(saveAndSubmit){

          out.write("\r\n   <td class=\"alignRight\" width=\"6%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_1.setForm("frmLegalActions");
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/subcare/LegalActions/saveAndSubmitLegalActions");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>      \r\n");

} else{

          out.print( SPACES );

}

          out.write('\r');
          out.write('\n');

if(save){

          out.write("\r\n   <td class=\"alignRight\" width=\"6%\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setForm("frmLegalActions");
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/LegalActions/saveLegalActions");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

} else{
  out.print(SPACES);
}

          out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
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
      _jspx_th_impact_documentButton_0.setButtonUrl("/grnds-docs/images/shared/btnNarrative.gif");
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
          _jspx_th_impact_document_0.setDisplayName("Legal Actions Narrative");
          _jspx_th_impact_document_0.setProtectDocument( !PageModeConstants.VIEW.equals(pageMode) ? false : true  );
          _jspx_th_impact_document_0.setCheckForNewMode(true);
          _jspx_th_impact_document_0.setDocType("leg01o00");
          _jspx_th_impact_document_0.setWindowName( String.valueOf(GlobalData.getUlIdStage(request)) );
          _jspx_th_impact_document_0.setDocExists( docExists );
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n                    ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("sEvent");
              _jspx_th_impact_documentParameter_0.setValue( String.valueOf(GlobalData.getUlIdEvent(request)) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("               \r\n            ");
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
      out.write("\r\n</td></tr>\r\n\r\n</table>\r\n");
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
}
