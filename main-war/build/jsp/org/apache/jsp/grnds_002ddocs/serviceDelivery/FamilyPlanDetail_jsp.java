package org.apache.jsp.grnds_002ddocs.serviceDelivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class FamilyPlanDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
//*  JSP Name:     Family Plan Detail
//*  Created by:   Jason Rios
//*  Date Created: 02/05/03
//*
//*  Description:
//*  This JSP displays the Family Plan Details.
//*
//*  Change History:
//*  Date      User       Description
//*  --------  ---------- ---------------------------------------------------------
//*  06/24/03  GRIMSHAN   SIR 18416 Set editable mode to all for approval status
//*                       button
//*
//*  06/18/04  thompswa   SIR 22881 The user now is prevented from entering a future
//*                       date in the Date Plan Completed date field and in the Current
//*                       Review Completed date field.  The onChange tag attribute
//*                       function, autofillNextReviewDue() change includes moving
//*                       code to the new futureDateCompletedInvalid().
//*
//*  06/22/04  RIOSJA     SIR 18164 - 'If clients did not participate' and 'Description
//*                       of Family Strengths and Resources' fields should be editable
//*                       for evaluations.
//*
//*  06/23/04  RIOSJA     SIR 19002 - Workers can now evaluate a family plan that
//*                       was created and approved in any family stage in the same
//*                       progression of stages (stages that originate from the same
//*                       INV stage).
//*
//*  11/04/04  thompswa   SIR 22812 - Change maxLength szTxtReasonCPSInvolvment,
//*                       szTxtStrengthRsrcs,szTxtNotParticipate to "1000".
//*
//*  02/03/05  thompswa   SIR 23171 - added hdnEvaluationCompletedDate
//*
//*  08/19/05  dunawakl   SIR 23676 - added field to form output
//*
//*  10/31/06  voht       GA Shines: Date Plan Completed relabeled Date Plan Prepared
//*                                  Added new field Date Plan Completed
//*                                  see design doc for more info and changes
//*
//*  03/19/08  vdevarak   SIR 7318 - The condition that sets the page mode to view only   
//*                                  looks for APRV or COMP status.Changed the condition  
//*                                  to look at the APRV status or the date complete 
//*                                  to be valid to set the page mode to view.
//*
//* 10/20/08    cwells    STGAP00010597: the plan should not become non-modifiable prior to supervisory approval.
//*
//* 11/25/08    cwells    STGAP00010568: Only displaying the Principals on Plan that are checked.  Also prompting user to save page before
//*                       attempting to launch form when a change is made to page. 
//* 02/11/09    cwells    STGAP00010597 Complete updated Family Plan details still will have the date complete editable.  

//*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
int loopCounter = 0;
int tabIndex = 1;
FamilyPlanValueBean familyPlanBean = null;
Map<Integer, String> principalsForEventHashmap = null;
Map<Integer, PersonValueBean> principalsForFormHashMap = null;
EventValueBean riskAssmtEvent = null;
java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat( "MM/dd/yyyy" );
Iterator iter = null;
String dateAsString = null;
String intAsString = null;
String permanencyEventID = null;
//SIR 23767 - dunawakl - added variable to hold event id dependent upon type of form
String idEventValue = null;
//end SIR 23767
int editableMode = 0;
String fieldsToBeSpellChecked = "txtExplanationOfClientNonParticipation, txtReasonForInvolvement, txtStrengthsResources";
boolean goToFamilyPlanItemList = false;
String onClickFunction = null;
String dtSzInitialDueDate = "";
String szCReqFuncCd = "";
boolean isUpdateMode = false; // when Update button was clicked
boolean isNewUsingMode = false; // when Copy button was clicked
boolean isUpdatedPlan; // the plan is an updated plan i.e. created using Update


//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

familyPlanBean = ( FamilyPlanValueBean )state.getAttribute( "familyPlanBean", request );
riskAssmtEvent = ( EventValueBean )state.getAttribute( "riskAssmtEvent", request );
// Leave this code - this features may come back
//bVisitationPlanExists = ( Boolean )state.getAttribute( "bVisitationPlanExists", request );

// Create a hashmap of the principals for the event. The map will be
// used to determine whether or not a principal should selected in the
// "Principals on the Plan" listbox.
principalsForEventHashmap = new HashMap<Integer, String>();
if ( familyPlanBean.getPrincipalsForEvent() != null )
{
  iter = familyPlanBean.getPrincipalsForEvent().iterator();
  while ( iter.hasNext() )
  {
    PersonValueBean person = ( PersonValueBean )iter.next();
    principalsForEventHashmap.put(person.getPersonId(), person.getFullName() );
  }
}

// Get the status of the event.
String eventStatus = CodesTables.CEVTSTAT_NEW;
if ( familyPlanBean.getFamilyPlanEvent().getEventStatusCode() != null )
{
  eventStatus = familyPlanBean.getFamilyPlanEvent().getEventStatusCode();
}

if( request.getAttribute( "goToFamilyPlanItemList" ) != null )
{
  goToFamilyPlanItemList = (Boolean) request.getAttribute("goToFamilyPlanItemList");
}

//*********************
//*** SET PAGE MODE ***
//*********************
boolean isSetE = Sets.isInSet( Sets.E, request ); // Update button was clicked
boolean isApprovedPlan = CodesTables.CEVTSTAT_APRV.equals( eventStatus );
boolean isCompEventStatus = CodesTables.CEVTSTAT_COMP.equals( eventStatus );
int dtPlanCompletedMode = EditableMode.NONE;
String pageSet = Sets.getPageSet(request);
String pageMode = PageModeConstants.VIEW;
org.exolab.castor.types.Date dtfamilyPlanComplete = null;
if(familyPlanBean!=null){
dtfamilyPlanComplete = familyPlanBean.getDatePlanCompleted();
}
if ( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}
isUpdatedPlan = familyPlanBean.isUpdatedPlan();
isNewUsingMode = Sets.isInSet( Sets.N, request) || PageModeConstants.NEW_USING.equals(pageMode);
// Date complete is uneditable at all time except when it is an updated plan that has not been completed 

// STGAP00010597 Displaying the Date Plan Completed when the event status is COMP as well  
  if ( isSetE || (isUpdatedPlan && !isApprovedPlan) ) {
     isUpdateMode = true; // used as combined mode for Update or Regular Modify for an Updated plan
     dtPlanCompletedMode = EditableMode.ALL;
  }
  // in Copy mode, everything is enabled, like NEW (Add) mode
  if ( isNewUsingMode ) {
     isUpdateMode = false; // reset update mode if an updated plan is being copied and not saved yet, so can display right
     Sets.setPageSet(Sets.N, request);
     editableMode = EditableMode.ALL;
  }


// If the family plan has been approved, set an 'editableMode'
// indicator to not-editable so it can be used for the protected fields.
// However, in Edit/Update mode event status still is APRV so need to consider that too
// In Copy mode, status might be APRV if an APRV was copied
// APRV status will be corrected when save (to PROC)

editableMode = EditableMode.NEW + EditableMode.EDIT + EditableMode.NEW_USING;
// No edit if plan status is APRV and is accessed through hyperlink
// Use editableMode since all fields are controlled through editableMode attribute
// Note that when Copy or Update first clicked, a plan will still have APRV status until saved, then
// status will be changed toPROC
//STGAP00007318: Changed the condition to look at the date complete instead of COMP status 
//STGAP00010597: the plan should not become non-modifiable prior to supervisory approval.
if ( ( isApprovedPlan && !isSetE && !isNewUsingMode )
      || (dtfamilyPlanComplete!=null && CodesTables.CEVTSTAT_APRV.equals( eventStatus )))
{
  editableMode = EditableMode.NONE; // view an approved plan

}



      out.write("\r\n\r\n");

//******************
//*** JAVASCRIPT ***
//******************

      out.write("\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nwindow.onload = function ()\r\n{\r\n  ");

  // If the user just added or deleted an employee, achor the
  // page to the Employees listbox.
  if ( goToFamilyPlanItemList &&
      !FormValidation.pageHasErrorMessages( request ) &&
      !FormValidation.pageHasValidationMessages( "frmFamilyPlan", request ) )
  {
      out.write("\r\n    goToFamilyPlanItemList.click();\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n// SIR 22881 This function serves to prevent entering a future date in the Date\r\n// Plan Completed date field and in the Current Review Completed date field.\r\n// GA Shines: 'Date Plan Completed' has been changed to 'Date Plan Prepared'\r\n\r\nfunction futureDateCompletedInvalid( field )\r\n{\r\n  if ( field.value != \"\")\r\n  {\r\n    var startingDateAsString = validateDateString( field.value );\r\n    var fieldName = \"document.frmFamilyPlan.\"+field.name;\r\n    var validValue = \"document.frmFamilyPlan.\"+fieldName+\".value = \"+\"startingDateAsString;\";\r\n    var refocus = \"document.frmFamilyPlan.\"+fieldName+\".blur();\";\r\n    var reselect = \"document.frmFamilyPlan.\"+fieldName+\".select();\";\r\n    var today = new Date();\r\n    // If input is invalid, pop message,blank field value, put cursor back in field.\r\n    if ( startingDateAsString == \"INVALID\" ||\r\n       (new Date( Date.parse(startingDateAsString) ) > today ) )\r\n    {\r\n      alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FP_DATE_BEFORE_SAME_CURR ) );
      out.write("');\r\n      eval(refocus); eval(reselect);\r\n    }\r\n    // If the input value is a valid date, put in the validated format.\r\n    else\r\n    {\r\n      eval(validValue);\r\n      // Only if Next Review Date is blank is it autofilled. If plan is APRV, mode\r\n      // allows startingDateAsString only from fieldName=txtDateReviewedWithFamily.\r\n      if ( document.frmFamilyPlan.txtDateNextReviewDue.value == \"\" )\r\n      {\r\n        autofillNextReviewDue(startingDateAsString);\r\n      }\r\n    }\r\n  }\r\n}\r\n\r\nfunction futureDatePreparedInvalid( field )\r\n{\r\n  if ( field.value != \"\")\r\n  {\r\n    var startingDateAsString = validateDateString( field.value );\r\n    var fieldName = \"document.frmFamilyPlan.\"+field.name;\r\n    var validValue = \"document.frmFamilyPlan.\"+fieldName+\".value = \"+\"startingDateAsString;\";\r\n    var refocus = \"document.frmFamilyPlan.\"+fieldName+\".blur();\";\r\n    var reselect = \"document.frmFamilyPlan.\"+fieldName+\".select();\";\r\n    var today = new Date();\r\n    // If input is invalid, pop message,blank field value, put cursor back in field.\r\n");
      out.write("    if ( startingDateAsString == \"INVALID\" ||\r\n       (new Date( Date.parse(startingDateAsString) ) > today ) )\r\n    {\r\n      alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_FP_DATE_BEFORE_SAME_CURR ) );
      out.write("');\r\n      eval(refocus); eval(reselect);\r\n    }\r\n    // If the input value is a valid date, put in the validated format.\r\n    else\r\n    {\r\n      eval(validValue);\r\n    }\r\n  }\r\n}\r\n\r\n// This function auto-fills the Next Review Due date field is followed:\r\n// It is 90 days / 3 months from the Last Review date which is Date Reviewed with Family\r\nfunction autofillNextReviewDue(startingDateAsString)\r\n{\r\n  var startingDateInMilliseconds = Date.parse( startingDateAsString );\r\n  var nextReviewDate = new Date( startingDateInMilliseconds );\r\n  var today = new Date();\r\n\r\n  nextReviewDate.setMonth( nextReviewDate.getMonth() + 3 );\r\n  document.frmFamilyPlan.txtDateNextReviewDue.value = (nextReviewDate.getMonth()+1) + \"/\" +nextReviewDate.getDate() + \"/\" +nextReviewDate.getYear();\r\n}\r\n\r\n// Takes the user to the Family Plan Item Detail page for the selected item.\r\nfunction goToFamilyPlanItemDetailPage( areaOfConcernCode )\r\n{\r\n  document.frmFamilyPlan.selectedAreaOfConcernCode.value = areaOfConcernCode;\r\n  setState('frmFamilyPlan');\r\n");
      out.write("  setValidationUrl('frmFamilyPlan', '/serviceDelivery/FamilyPlan/displayFamilyPlanItem');\r\n  document.frmFamilyPlan.submit();\r\n}\r\n\r\n// Takes the user to the Risk Assessment Detail page for the most recent\r\n// risk assessment in the investigation stage that led to the creation of\r\n// this stage.\r\nfunction goToRiskAssmtDetailPage()\r\n{\r\n  // Clear GlobalData so the new navigation tabs will be set for the INV stage.\r\n  document.frmFamilyPlan.");
      out.print( HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY );
      out.write(".value = \"\";\r\n  setState('frmFamilyPlan');\r\n  disableValidation(\"frmFamilyPlan\");\r\n  setValidationUrl('frmFamilyPlan', '/serviceDelivery/FamilyPlan/displayRiskAssmt');\r\n  document.frmFamilyPlan.submit();\r\n}\r\n\r\nfunction confirmSaveAndSubmit()\r\n{\r\n  var bContinue = true;\r\n  return bContinue;\r\n}\r\n\r\n// User must save the family plan before producing the form.\r\nfunction documentCheck()\r\n{\r\n  ");

  if ( familyPlanBean.getFamilyPlanEvent().getEventId() > 0 )
  {
      out.write("\r\n    return true;\r\n  ");

  }
  else
  {
      out.write("\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_ARC_NO_FORM_DATA ) );
      out.write("');\r\n    return false;\r\n  ");

  }
  
      out.write("\r\n}\r\n\r\n</script>\r\n\r\n");

//*************************
//*** VALIDATION ERRORS ***
//*************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");

//***********************************************
//**** FORM (FAMILY PLAN DETAIL) STARTS HERE ****
//***********************************************

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmFamilyPlan");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/serviceDelivery/FamilyPlan/displayFamilyPlan");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

// SIR 23171 - added hdnEvaluationCompletedDate

          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnPrimaryWorkerId");
          _jspx_th_impact_validateInput_1.setValue( FormattingHelper.formatInt( familyPlanBean.getPrimaryWorkerId() ) );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("hdnFamilyPlanId");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt( familyPlanBean.getFamilyPlanId() ) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("hdnFamilyPlanDateLastUpdate");
          _jspx_th_impact_validateInput_3.setValue( isNewUsingMode ? "" : DateHelper.toISOString( familyPlanBean.getFamilyPlanDateLastUpdate() ) );
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdnCaseId");
          _jspx_th_impact_validateInput_4.setValue( String.valueOf( familyPlanBean.getCaseId() ) );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnStageId");
          _jspx_th_impact_validateInput_5.setValue( String.valueOf( familyPlanBean.getStageId() ) );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("hdnStageCode");
          _jspx_th_impact_validateInput_6.setValue( FormattingHelper.formatString( familyPlanBean.getStageCode() ) );
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("hdnStageTypeCode");
          _jspx_th_impact_validateInput_7.setValue( FormattingHelper.formatString( familyPlanBean.getStageTypeCode() ) );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnStageName");
          _jspx_th_impact_validateInput_8.setValue( FormattingHelper.formatString( familyPlanBean.getStageName() ) );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnIsUpdatedPlan");
          _jspx_th_impact_validateInput_9.setValue( FormattingHelper.formatString( String.valueOf(familyPlanBean.isUpdatedPlan()) ) );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

// RIOSJA, SIR 19002 - We need to keep track of the stage Start
// Date so that we can display an informational message if the
// worker attemps to evaluate a family plan that was created in
// a newer stage.
dateAsString = "";
if ( familyPlanBean.getDateStageStarted() != null )
{
  dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateStageStarted() );
}

          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("hdnDateStageStarted");
          _jspx_th_impact_validateInput_10.setValue( dateAsString );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n");

// Family plan evaluation event fields.
intAsString = "";
dateAsString = "";
permanencyEventID = "";
permanencyEventID = FormattingHelper.formatInt(familyPlanBean.getFamilyPlanEvent().getEventId() );


          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("hidden");
          _jspx_th_impact_validateInput_11.setName( FamilyPlanConversation.EVENT_STATUS_FIELD_NAME );
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatString( eventStatus ) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");

//****************************
//**** FAMILY PLAN DETAIL ****
//****************************
// Display the 'Approval Status' button if the event has ever been
// submitted for approval.
if ( CaseUtility.hasBeenSubmittedForApproval( GlobalData.getUlIdEvent( request ) ) && !isNewUsingMode && !isSetE)
{
  String actionString = ApprovalStatusConversation.DISPLAY_URI;
  
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmFamilyPlan");
          _jspx_th_impact_ButtonTag_0.setAction( actionString );
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}

          out.write("\r\n\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th colspan=\"2\">Family Plan Detail</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");

      //-----------------
      //--- Plan Type ---
      //-----------------
      // Display the plan type as display-only field.
      //String planTypeDecode = Lookup.simpleDecodeSafe( "CPLNTYPE", familyPlanBean.getPlanTypeCode() );
      String planTypeDecode = "Family Plan for CPS Ongoing";
      
          out.write("\r\n      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td colspan=\"2\">\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Plan Type");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtPlanType");
          _jspx_th_impact_validateDisplayOnlyField_0.setRequired(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( planTypeDecode );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("hidden");
          _jspx_th_impact_validateInput_12.setName("hdnPlanTypeCode");
          _jspx_th_impact_validateInput_12.setValue( familyPlanBean.getPlanTypeCode() );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"2\">\r\n          ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Outcome");
          _jspx_th_impact_validateSelect_0.setName("selSzCdOutcome");
          _jspx_th_impact_validateSelect_0.setRequired(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateSelect_0.setEditableMode( editableMode );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setCodesTable("CFAMOUT");
          _jspx_th_impact_validateSelect_0.setValue( FormattingHelper.formatString( familyPlanBean.getCdOutcome() ));
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n\r\n        </tr>\r\n      </table>\r\n    </td>\r\n    <td align = center>\r\n        ");

        String isCourtOrdered = ArchitectureConstants.FALSE;
              if ( familyPlanBean.getIndCourtOrdered() )
              {
                isCourtOrdered = ArchitectureConstants.TRUE;
              }
        
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("checkbox");
          _jspx_th_impact_validateInput_13.setLabel("Court Ordered");
          _jspx_th_impact_validateInput_13.setName("cbxCourtOrdered");
          _jspx_th_impact_validateInput_13.setChecked( isCourtOrdered );
          _jspx_th_impact_validateInput_13.setValue("Y");
          _jspx_th_impact_validateInput_13.setEditableMode( editableMode );
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"50%\">\r\n      <table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" height=\"135\" class=\"tableborder\">\r\n        <tr>\r\n          <th><span class=\"formRequiredText\">*</span>Principals on the Plan</th>\r\n        </tr>\r\n        <tr>\r\n          <td colspan=\"2\">\r\n            <div style=\"overflow:auto; WIDTH: 375px; HEIGHT: 135px\" class=\"tableborderList\">\r\n              <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" >\r\n                <tr>\r\n                  <th class=\"thList\">Name</th>\r\n                  <th class=\"thList\">Relationship</th>\r\n                </tr>\r\n                ");

                //------------------------------
                //--- Principals on the Plan ---
                //------------------------------
                // Iterate through the principals and display then.
                loopCounter = 0;
                String isSelected = null;
                iter = familyPlanBean.getPrincipalsForStage().iterator();
                while ( iter.hasNext() )
                {
                  PersonValueBean personBean = ( PersonValueBean )iter.next();
                  String checkboxName = "cbxPrincipalsOnPlan_" + loopCounter;

                  // If this principal is associated with this event, or if this
                  // is a new family plan, select the principal.
                  isSelected = ArchitectureConstants.FALSE;
                  if ( principalsForEventHashmap.containsKey(personBean.getPersonId() ) ||
                       familyPlanBean.getFamilyPlanId() == 0 )
                  {
                    isSelected = ArchitectureConstants.TRUE;
                    
                  }
                  
          out.write("\r\n                  <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCounter + 1 ) );
          out.write("\">\r\n                    <td>\r\n                      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("checkbox");
          _jspx_th_impact_validateInput_14.setName( checkboxName );
          _jspx_th_impact_validateInput_14.setLabel( personBean.getFullName() );
          _jspx_th_impact_validateInput_14.setValue( String.valueOf( personBean.getPersonId() ) );
          _jspx_th_impact_validateInput_14.setChecked( isSelected );
          _jspx_th_impact_validateInput_14.setEditableMode( isUpdateMode ? EditableMode.NONE : editableMode );
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                    </td>\r\n                    <td>");
          out.print( personBean.getRelationshipInterestCode() );
          out.write("</td>\r\n                  </tr>\r\n                  ");

                  loopCounter++;
                } // end while ( iter.hasNext() )
                
          out.write("\r\n              </table>\r\n            </div>\r\n          </td>\r\n        </tr>\r\n\r\n      </table>\r\n    </td>\r\n    <td width=\"50%\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" height=\"134\" width=\"100%\" class=\"tableBorder\">\r\n        <th height=\"28\" colspan=\"2\">Family Plan Dates</th>\r\n        <tr>\r\n          <td width=\"47%\">\r\n          ");

            //---------------------------
            //--- Initial Due Date ---
            //---------------------------
            dateAsString = "";
            if ( familyPlanBean.getDateInitialDueDate() != null )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateInitialDueDate() );
            }
            else
            {
              dateAsString = dtSzInitialDueDate;
            }
            
          out.write("\r\n            ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Initial Due Date: ");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtInitialDueDate");
          _jspx_th_impact_validateDisplayOnlyField_1.setRequired(ArchitectureConstants.FALSE);
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( dateAsString );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"47%\">\r\n            ");

            //---------------------------
            //--- Date Plan Prepared ---
            //---------------------------
            dateAsString = "";
            if ( familyPlanBean.getDatePlanPrepared() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDatePlanPrepared() );
            }
            
          out.write("\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Date Plan Prepared");
          _jspx_th_impact_validateDate_0.setName("txtDatePlanPrepared");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( dateAsString );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConditionallyRequired(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateDate_0.setEditableMode( isUpdateMode ? EditableMode.NONE : editableMode );
          _jspx_th_impact_validateDate_0.setOnChange("futureDatePreparedInvalid(this);");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");

            //-----------------------
            //--- Next Review Due ---
            //-----------------------
            dateAsString = "";
            if ( familyPlanBean.getDateNextEvalDue() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateNextEvalDue() );
            }
            
          out.write("\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("Next Review Due");
          _jspx_th_impact_validateDate_1.setName("txtDateNextReviewDue");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( dateAsString );
          _jspx_th_impact_validateDate_1.setEditableMode( isUpdateMode ? EditableMode.NONE : editableMode );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setConditionallyRequired(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td>\r\n            ");

            //--------------------------------
            //--- Date Reviewed with Family ---
            //--------------------------------
            dateAsString = "";
            if (familyPlanBean.getDateCurrentEvalCompleted() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateCurrentEvalCompleted() );
            }
            
          out.write("\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Date Reviewed with Family");
          _jspx_th_impact_validateDate_2.setName("txtDateReviewedWithFamily");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setValue( dateAsString );
          _jspx_th_impact_validateDate_2.setEditableMode( isUpdateMode ? EditableMode.NONE : editableMode );
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setOnChange("futureDateCompletedInvalid(this);");
          _jspx_th_impact_validateDate_2.setConditionallyRequired(ArchitectureConstants.TRUE);
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"47%\">\r\n            ");

            //---------------------------
            //--- Date Plan Completed ---
            //---------------------------
            dateAsString = "";
            if ( familyPlanBean.getDatePlanCompleted() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDatePlanCompleted() );
            }
            
          out.write("\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Date Plan Completed");
          _jspx_th_impact_validateDate_3.setName("txtDatePlanCompleted");
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setValue( dateAsString );
          _jspx_th_impact_validateDate_3.setSize("10");
          _jspx_th_impact_validateDate_3.setEditableMode( dtPlanCompletedMode );
          _jspx_th_impact_validateDate_3.setOnChange("futureDateCompletedInvalid(this);");
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" >\r\n        <tr>\r\n          <td width=\"35%\">If Clients did not participate or sign, Explain:</td>\r\n          <td align=\"right\">\r\n            ");

            //-----------------------
            //--- Client comments ---
            //-----------------------
            String isChecked = ArchitectureConstants.FALSE;
            if ( familyPlanBean.clientGaveComments() )
            {
            isChecked = ArchitectureConstants.TRUE;
            }
            
          out.write("\r\n            ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setLabel("Client comments");
          _jspx_th_impact_validateInput_15.setName("cbxClientComments");
          _jspx_th_impact_validateInput_15.setType("checkbox");
          _jspx_th_impact_validateInput_15.setValue("Y");
          _jspx_th_impact_validateInput_15.setEditableMode( editableMode );
          _jspx_th_impact_validateInput_15.setChecked( isChecked );
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n          </td>\r\n          <td width=\"3%\">&nbsp;</td>\r\n        </tr>\r\n      </table>\r\n   </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      ");

      //-----------------------------------------
      //--- If Clients did not participate... ---
      //-----------------------------------------
      // RIOSJA, SIR 18164 - Field should be editable for evaluations.
      
          out.write("\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtExplanationOfClientNonParticipation");
          _jspx_th_impact_validateTextArea_0.setTitle("If Clients did not participate or sign, Explain");
          _jspx_th_impact_validateTextArea_0.setColspan("1");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setCols("145");
          _jspx_th_impact_validateTextArea_0.setEditableMode( editableMode );
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print( FormattingHelper.formatString( familyPlanBean.getExplanationOfClientNonParticipation() ) );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n");

//******************************************************
//**** REASON FOR INVOLVEMENT/STRENGTHS & RESOURCES ****
//******************************************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th>Reason for Involvement/Strengths & Resources</th></tr>\r\n  <tr>\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>Reason for CPS Involvement:</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");

      //----------------------------------
      //--- Reason for CPS Involvement ---
      //----------------------------------
      
          out.write("\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtReasonForInvolvement");
          _jspx_th_impact_validateTextArea_1.setTitle("Reason for CPS Involvement");
          _jspx_th_impact_validateTextArea_1.setColspan("1");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setCols("145");
          _jspx_th_impact_validateTextArea_1.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_1.setEditableMode( editableMode );
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print( FormattingHelper.formatString( familyPlanBean.getReasonForCPSInvolvement() ) );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td><span class=\"formCondRequiredText\">&#135;</span>Description of Family Strengths and Resources:</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");

      //-----------------------------------------------------
      //--- Description of Family Strengths and Resources ---
      //-----------------------------------------------------
      // RIOSJA, SIR 18164 - Field should be editable for evaluations.
      
          out.write("\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtStrengthsResources");
          _jspx_th_impact_validateTextArea_2.setTitle("Description of Family Strengths and Resources");
          _jspx_th_impact_validateTextArea_2.setColspan("1");
          _jspx_th_impact_validateTextArea_2.setRows("3");
          _jspx_th_impact_validateTextArea_2.setCols("145");
          _jspx_th_impact_validateTextArea_2.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_2.setEditableMode( editableMode );
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n      ");
              out.print( FormattingHelper.formatString( familyPlanBean.getStrengthsAndResources() ) );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>\r\n\r\n");

//*******************************
//**** FAMILY PLAN ITEM LIST ****
//*******************************

          out.write("\r\n<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th>\r\n      <a href=\"#goToFamilyPlanItemList\" name=\"goToFamilyPlanItemList\"></a>\r\n      Family Plan Item List\r\n    </th>\r\n    <td align=\"right\">\r\n      ");

      if ( riskAssmtEvent != null &&
           riskAssmtEvent.getEventId() > 0 )
      {
          out.write("\r\n        <a href=\"JavaScript:goToRiskAssmtDetailPage();\">Risk Assessment</a>\r\n      ");

      }
      else
      {
          out.write("\r\n        <a href=\"JavaScript:alert('No risk assessment exists.');\">Risk Assessment</a>\r\n      ");

      }
      
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableborderList\">\r\n        <tr>\r\n          <th width=\"20%\" class=\"thList\">Identified in Risk Assessment</th>\r\n          <th width=\"25%\" class=\"thList\">Area of Concern</th>\r\n          <th width=\"20%\" class=\"thList\">Initial Scale of Concern</th>\r\n          <th width=\"20%\" class=\"thList\">Initially Addressed</th>\r\n          <th width=\"15%\" class=\"thList\">Current Scale of Concern</th>\r\n        </tr>\r\n\r\n        ");

        // Iterate through the family plan items and display then.
        loopCounter = 0;
        iter = familyPlanBean.getFamilyPlanItemList().iterator();
        while ( iter.hasNext() )
        {
          FamilyPlanItemValueBean itemBean = ( FamilyPlanItemValueBean )iter.next();
          
          out.write("\r\n          <tr class=\"");
          out.print( FormattingHelper.getRowCss( loopCounter + 1 ) );
          out.write("\">\r\n            ");

            //-------------------------------------
            //--- Identified in Risk Assessment ---
            //-------------------------------------
            if ( itemBean.isIdentifiedInRiskAssessment() )
            {
          out.write("\r\n              <td>\r\n                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\" border=\"0\">\r\n              </td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>&nbsp;</td>\r\n            ");

            }
            
          out.write("\r\n\r\n            ");

            //-----------------------
            //--- Area of Concern ---
            //-----------------------
            // Family plans must be saved to the
            // database at least once before the user can navigate to the Family
            // Plan Item Detail page.
            // Van - Need to add condition for New Using and Update Initial where plan ID is not zero but page never saved
            if ( familyPlanBean.getFamilyPlanId() == 0 || isSetE || isNewUsingMode)
            {
          out.write("\r\n              <td>\r\n                <a name=\"");
          out.print( itemBean.getAreaOfConcernCode() );
          out.write("\"></a>\r\n                <a href=\"JavaScript:alert('");
          out.print( MessageLookup.getMessageByNumber( Messages.MSG_SVC_SAVE_FAM_PLAN ) );
          out.write("');\">");
          out.print( itemBean.getAreaOfConcernText() );
          out.write("</a>\r\n              </td>\r\n            ");
}
            else
            {
          out.write("\r\n              <td>\r\n                <a name=\"");
          out.print( itemBean.getAreaOfConcernCode() );
          out.write("\"></a>\r\n                <a href=\"JavaScript:goToFamilyPlanItemDetailPage('");
          out.print( itemBean.getAreaOfConcernCode() );
          out.write("');\">");
          out.print( itemBean.getAreaOfConcernText() );
          out.write("</a>\r\n              </td>\r\n            ");

            }
            
          out.write("\r\n\r\n\r\n            ");

            //--------------------------------
            //--- Initial Level of Concern ---
            //--------------------------------
            if ( itemBean.getInitialLevelOfConcernScale() != null )
            {
          out.write("\r\n              <td>");
          out.print( Lookup.simpleDecodeSafe( "CRISKSOC", itemBean.getInitialLevelOfConcernScale() ) );
          out.write("</td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>&nbsp;</td>\r\n            ");

            }
            
          out.write("\r\n\r\n            ");

            //---------------------------
            //--- Initially Addressed ---
            //---------------------------
            if ( itemBean.getDateInitiallyAddressed() != null )
            {
          out.write("\r\n              <td>");
          out.print( dateFormatter.format( itemBean.getDateInitiallyAddressed() ) );
          out.write("</td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>&nbsp;</td>\r\n            ");

            }
            
          out.write("\r\n\r\n            ");

            //--------------------------------
            //--- Current Level of Concern ---
            //--------------------------------
            if ( itemBean.getCurrentLevelOfConcernScale() != null )
            {
          out.write("\r\n              <td>");
          out.print( Lookup.simpleDecodeSafe( "CRISKSOC", itemBean.getCurrentLevelOfConcernScale() ) );
          out.write("</td>\r\n            ");

            }
            else
            {
          out.write("\r\n              <td>&nbsp;</td>\r\n            ");

            }
            
          out.write("\r\n\r\n          </tr>\r\n          ");

          loopCounter++;
        } // end while ( iter.hasNext() )
        
          out.write("\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");

//*****************
//**** BUTTONS ****
//*****************
// Do not display the 'Save and Submit' button if this is a new family
// plan or if the supervisor is accessing the page via a family plan
// approval todo.
String bDisableSaveAndSubmit = ArchitectureConstants.FALSE;
if ( //GlobalData.getUlIdEvent( request ) == 0 || isSetE || isNewUsingMode || 
    (GlobalData.isApprovalMode( request ) &&
    !GlobalData.isStageClosureBeingApproved( request )) )
{
  bDisableSaveAndSubmit = ArchitectureConstants.TRUE;
}
//STGAP00010597 the plan should not become non-modifiable prior to supervisory approval.
boolean isDtfamilyPlanComplete = false;
if(!DateHelper.isNull(dtfamilyPlanComplete) && isApprovedPlan){
 isDtfamilyPlanComplete = true;
}
// Hide the buttons if the event has been approved.
// SHINES: Or if it is in New Using mode
// Beawre if it New Using/Update on page never been saved or existing record
//STGAP00007318: Changed the condition to look at the date complete instead of COMP status
if ( !isDtfamilyPlanComplete || isSetE || isNewUsingMode)
{
          out.write("\r\n  <br>\r\n  <hr>\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td width=\"100%\" align=\"right\">\r\n        ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmFamilyPlan");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck( fieldsToBeSpellChecked );
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName( FamilyPlanConversation.SAVE_SUBMIT_BUTTON );
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmFamilyPlan");
          _jspx_th_impact_ButtonTag_1.setDisabled( bDisableSaveAndSubmit );
          _jspx_th_impact_ButtonTag_1.setAction("/serviceDelivery/FamilyPlan/saveAndSubmitFamilyPlan");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setFunction("return confirmSaveAndSubmit()");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName( FamilyPlanConversation.SAVE_BUTTON_ON_DETAIL_PAGE );
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setForm("frmFamilyPlan");
          _jspx_th_impact_ButtonTag_2.setAction("/serviceDelivery/FamilyPlan/saveFamilyPlan");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");

}

          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');

//*********************************************
//**** FORM (FAMILY PLAN DETAIL) ENDS HERE ****
//*********************************************

      out.write("\r\n\r\n");

//***************
//**** FORMS ****
//***************

      out.write("\r\n<br>\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><th>Forms Launch</th></tr>\r\n  <tr>\r\n    <td>\r\n      ");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode( PageModeConstants.EDIT );
      _jspx_th_impact_documentList_0.setTabIndex( tabIndex++ );
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n        ");

        // The document name will be: 1) "Family Plan" if the family plan
        // has not yet been saved, 2) the family plan event description
        String documentDisplayName = "Family Plan";
        if ( familyPlanBean.getFamilyPlanEvent().getEventId() > 0 )
        {
          documentDisplayName = familyPlanBean.getFamilyPlanEvent().getEventDescription();
        }
        
          out.write("\r\n        ");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Family Service Plan");
          _jspx_th_impact_document_0.setDocType("cfsd0500");
          _jspx_th_impact_document_0.setDocExists(false);
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setPromptSavePage("frmFamilyPlan");
          _jspx_th_impact_document_0.setOnClick("documentCheck()");
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pEvent");
              _jspx_th_impact_documentParameter_0.setValue( FormattingHelper.formatInt(familyPlanBean.getFamilyPlanEvent().getEventId() ) );
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n          ");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue( FormattingHelper.formatInt(familyPlanBean.getFamilyPlanEvent().getStageId() ) );
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br>");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("selectedAreaOfConcernCode");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
