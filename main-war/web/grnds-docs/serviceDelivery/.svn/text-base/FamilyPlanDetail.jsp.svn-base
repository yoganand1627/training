<%
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
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables,
                 gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup,
                 gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup,
                 gov.georgia.dhr.dfcs.sacwis.core.message.Messages,
                 gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
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


%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};

window.onload = function ()
{
  <%
  // If the user just added or deleted an employee, achor the
  // page to the Employees listbox.
  if ( goToFamilyPlanItemList &&
      !FormValidation.pageHasErrorMessages( request ) &&
      !FormValidation.pageHasValidationMessages( "frmFamilyPlan", request ) )
  {%>
    goToFamilyPlanItemList.click();
  <%
  }
  %>
}

// SIR 22881 This function serves to prevent entering a future date in the Date
// Plan Completed date field and in the Current Review Completed date field.
// GA Shines: 'Date Plan Completed' has been changed to 'Date Plan Prepared'

function futureDateCompletedInvalid( field )
{
  if ( field.value != "")
  {
    var startingDateAsString = validateDateString( field.value );
    var fieldName = "document.frmFamilyPlan."+field.name;
    var validValue = "document.frmFamilyPlan."+fieldName+".value = "+"startingDateAsString;";
    var refocus = "document.frmFamilyPlan."+fieldName+".blur();";
    var reselect = "document.frmFamilyPlan."+fieldName+".select();";
    var today = new Date();
    // If input is invalid, pop message,blank field value, put cursor back in field.
    if ( startingDateAsString == "INVALID" ||
       (new Date( Date.parse(startingDateAsString) ) > today ) )
    {
      alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_FP_DATE_BEFORE_SAME_CURR ) %>');
      eval(refocus); eval(reselect);
    }
    // If the input value is a valid date, put in the validated format.
    else
    {
      eval(validValue);
      // Only if Next Review Date is blank is it autofilled. If plan is APRV, mode
      // allows startingDateAsString only from fieldName=txtDateReviewedWithFamily.
      if ( document.frmFamilyPlan.txtDateNextReviewDue.value == "" )
      {
        autofillNextReviewDue(startingDateAsString);
      }
    }
  }
}

function futureDatePreparedInvalid( field )
{
  if ( field.value != "")
  {
    var startingDateAsString = validateDateString( field.value );
    var fieldName = "document.frmFamilyPlan."+field.name;
    var validValue = "document.frmFamilyPlan."+fieldName+".value = "+"startingDateAsString;";
    var refocus = "document.frmFamilyPlan."+fieldName+".blur();";
    var reselect = "document.frmFamilyPlan."+fieldName+".select();";
    var today = new Date();
    // If input is invalid, pop message,blank field value, put cursor back in field.
    if ( startingDateAsString == "INVALID" ||
       (new Date( Date.parse(startingDateAsString) ) > today ) )
    {
      alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_FP_DATE_BEFORE_SAME_CURR ) %>');
      eval(refocus); eval(reselect);
    }
    // If the input value is a valid date, put in the validated format.
    else
    {
      eval(validValue);
    }
  }
}

// This function auto-fills the Next Review Due date field is followed:
// It is 90 days / 3 months from the Last Review date which is Date Reviewed with Family
function autofillNextReviewDue(startingDateAsString)
{
  var startingDateInMilliseconds = Date.parse( startingDateAsString );
  var nextReviewDate = new Date( startingDateInMilliseconds );
  var today = new Date();

  nextReviewDate.setMonth( nextReviewDate.getMonth() + 3 );
  document.frmFamilyPlan.txtDateNextReviewDue.value = (nextReviewDate.getMonth()+1) + "/" +nextReviewDate.getDate() + "/" +nextReviewDate.getYear();
}

// Takes the user to the Family Plan Item Detail page for the selected item.
function goToFamilyPlanItemDetailPage( areaOfConcernCode )
{
  document.frmFamilyPlan.selectedAreaOfConcernCode.value = areaOfConcernCode;
  setState('frmFamilyPlan');
  setValidationUrl('frmFamilyPlan', '/serviceDelivery/FamilyPlan/displayFamilyPlanItem');
  document.frmFamilyPlan.submit();
}

// Takes the user to the Risk Assessment Detail page for the most recent
// risk assessment in the investigation stage that led to the creation of
// this stage.
function goToRiskAssmtDetailPage()
{
  // Clear GlobalData so the new navigation tabs will be set for the INV stage.
  document.frmFamilyPlan.<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>.value = "";
  setState('frmFamilyPlan');
  disableValidation("frmFamilyPlan");
  setValidationUrl('frmFamilyPlan', '/serviceDelivery/FamilyPlan/displayRiskAssmt');
  document.frmFamilyPlan.submit();
}

function confirmSaveAndSubmit()
{
  var bContinue = true;
  return bContinue;
}

// User must save the family plan before producing the form.
function documentCheck()
{
  <%
  if ( familyPlanBean.getFamilyPlanEvent().getEventId() > 0 )
  {%>
    return true;
  <%
  }
  else
  {%>
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_ARC_NO_FORM_DATA ) %>');
    return false;
  <%
  }
  %>
}

</script>

<%
//*************************
//*** VALIDATION ERRORS ***
//*************************
%>
<impact:validateErrors/>

<%
//***********************************************
//**** FORM (FAMILY PLAN DETAIL) STARTS HERE ****
//***********************************************
%>
<impact:validateForm
  name="frmFamilyPlan"
  method="post"
  action="/serviceDelivery/FamilyPlan/displayFamilyPlan"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanCustomValidation"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<%
// SIR 23171 - added hdnEvaluationCompletedDate
%>
<impact:validateInput
  type="hidden"
  name="selectedAreaOfConcernCode"
  value=""/>

<impact:validateInput
  type="hidden"
  name="hdnPrimaryWorkerId"
  value="<%= FormattingHelper.formatInt( familyPlanBean.getPrimaryWorkerId() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnFamilyPlanId"
  value="<%= FormattingHelper.formatInt( familyPlanBean.getFamilyPlanId() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnFamilyPlanDateLastUpdate"
  value="<%= isNewUsingMode ? "" : DateHelper.toISOString( familyPlanBean.getFamilyPlanDateLastUpdate() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnCaseId"
  value="<%= String.valueOf( familyPlanBean.getCaseId() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnStageId"
  value="<%= String.valueOf( familyPlanBean.getStageId() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnStageCode"
  value="<%= FormattingHelper.formatString( familyPlanBean.getStageCode() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnStageTypeCode"
  value="<%= FormattingHelper.formatString( familyPlanBean.getStageTypeCode() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnStageName"
  value="<%= FormattingHelper.formatString( familyPlanBean.getStageName() ) %>"/>

<impact:validateInput
  type="hidden"
  name="hdnIsUpdatedPlan"
  value="<%= FormattingHelper.formatString( String.valueOf(familyPlanBean.isUpdatedPlan()) ) %>"/>

<%
// RIOSJA, SIR 19002 - We need to keep track of the stage Start
// Date so that we can display an informational message if the
// worker attemps to evaluate a family plan that was created in
// a newer stage.
dateAsString = "";
if ( familyPlanBean.getDateStageStarted() != null )
{
  dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateStageStarted() );
}
%>
<impact:validateInput
  type="hidden"
  name="hdnDateStageStarted"
  value="<%= dateAsString %>"/>


<%
// Family plan evaluation event fields.
intAsString = "";
dateAsString = "";
permanencyEventID = "";
permanencyEventID = FormattingHelper.formatInt(familyPlanBean.getFamilyPlanEvent().getEventId() );

%>
<impact:validateInput
  type="hidden"
  name="<%= FamilyPlanConversation.EVENT_STATUS_FIELD_NAME %>"
  value="<%= FormattingHelper.formatString( eventStatus ) %>"/>

<%
//****************************
//**** FAMILY PLAN DETAIL ****
//****************************
// Display the 'Approval Status' button if the event has ever been
// submitted for approval.
if ( CaseUtility.hasBeenSubmittedForApproval( GlobalData.getUlIdEvent( request ) ) && !isNewUsingMode && !isSetE)
{
  String actionString = ApprovalStatusConversation.DISPLAY_URI;
  %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td>
        <impact:ButtonTag
          name="btnApprovalStatusFinal"
          img="btnApprovalStatus"
          form="frmFamilyPlan"
          action="<%= actionString %>"
          editableMode="<%= EditableMode.ALL %>"
          navAwayCk="true"
          tabIndex="<%= tabIndex %>"/>
      </td>
    </tr>
  </table>
<%
}
%>

<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="2">Family Plan Detail</th></tr>
  <tr>
    <td>
      <%
      //-----------------
      //--- Plan Type ---
      //-----------------
      // Display the plan type as display-only field.
      //String planTypeDecode = Lookup.simpleDecodeSafe( "CPLNTYPE", familyPlanBean.getPlanTypeCode() );
      String planTypeDecode = "Family Plan for CPS Ongoing";
      %>
      <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr>
          <td colspan="2">
            <impact:validateDisplayOnlyField
              label="Plan Type"
              name="txtPlanType"
              required="<%=ArchitectureConstants.FALSE%>"
              value="<%= planTypeDecode %>"/>

            <impact:validateInput
              type="hidden"
              name="hdnPlanTypeCode"
              value="<%= familyPlanBean.getPlanTypeCode() %>"/>
          </td>
        </tr>
        <tr>
          <td colspan="2">
          <impact:validateSelect
            label="Outcome"
            name="selSzCdOutcome"
            required="<%=ArchitectureConstants.TRUE%>"
            editableMode="<%= editableMode %>"
            tabIndex="<%= tabIndex++ %>"
            codesTable="CFAMOUT"
            value="<%= FormattingHelper.formatString( familyPlanBean.getCdOutcome() )%>"/></td>

        </tr>
      </table>
    </td>
    <td align = center>
        <%
        String isCourtOrdered = ArchitectureConstants.FALSE;
              if ( familyPlanBean.getIndCourtOrdered() )
              {
                isCourtOrdered = ArchitectureConstants.TRUE;
              }
        %>
            <impact:validateInput
              type="checkbox"
              label="Court Ordered"
              name="cbxCourtOrdered"
              checked="<%= isCourtOrdered %>"
              value="Y"
              editableMode="<%= editableMode %>"
              tabIndex="<%= tabIndex++ %>"
              cssClass="formInput" />
          </td>
  </tr>
  <tr>
    <td width="50%">
      <table border="0" cellpadding="2" cellspacing="0" width="100%" height="135" class="tableborder">
        <tr>
          <th><span class="formRequiredText">*</span>Principals on the Plan</th>
        </tr>
        <tr>
          <td colspan="2">
            <div style="overflow:auto; WIDTH: 375px; HEIGHT: 135px" class="tableborderList">
              <table border="0" cellpadding="3" cellspacing="0" width="100%" >
                <tr>
                  <th class="thList">Name</th>
                  <th class="thList">Relationship</th>
                </tr>
                <%
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
                  %>
                  <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
                    <td>
                      <impact:validateInput
                        type="checkbox"
                        name="<%= checkboxName %>"
                        label="<%= personBean.getFullName() %>"
                        value="<%= String.valueOf( personBean.getPersonId() ) %>"
                        checked="<%= isSelected %>"
                        editableMode="<%= isUpdateMode ? EditableMode.NONE : editableMode %>"
                        tabIndex="<%= tabIndex++ %>"
                        cssClass="formInput"/>
                    </td>
                    <td><%= personBean.getRelationshipInterestCode() %></td>
                  </tr>
                  <%
                  loopCounter++;
                } // end while ( iter.hasNext() )
                %>
              </table>
            </div>
          </td>
        </tr>

      </table>
    </td>
    <td width="50%">
      <table border="0" cellpadding="3" cellspacing="0" height="134" width="100%" class="tableBorder">
        <th height="28" colspan="2">Family Plan Dates</th>
        <tr>
          <td width="47%">
          <%
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
            %>
            <impact:validateDisplayOnlyField
              label="Initial Due Date: "
              name="txtInitialDueDate"
              required="<%=ArchitectureConstants.FALSE%>"
                  value="<%= dateAsString %>"/>
          </td>
        </tr>
        <tr>
          <td width="47%">
            <%
            //---------------------------
            //--- Date Plan Prepared ---
            //---------------------------
            dateAsString = "";
            if ( familyPlanBean.getDatePlanPrepared() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDatePlanPrepared() );
            }
            %>
            <impact:validateDate
              label="Date Plan Prepared"
              name="txtDatePlanPrepared"
              type="text"
              value="<%= dateAsString %>"
              size="10"
              conditionallyRequired="<%=ArchitectureConstants.TRUE%>"
              editableMode="<%= isUpdateMode ? EditableMode.NONE : editableMode %>"
              onChange="futureDatePreparedInvalid(this);"
              tabIndex="<%= tabIndex++ %>"
              constraint="Date"/>
          </td>
        </tr>
        <tr>
          <td>
            <%
            //-----------------------
            //--- Next Review Due ---
            //-----------------------
            dateAsString = "";
            if ( familyPlanBean.getDateNextEvalDue() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateNextEvalDue() );
            }
            %>
            <impact:validateDate
              label="Next Review Due"
              name="txtDateNextReviewDue"
              type="text"
              value="<%= dateAsString %>"
              editableMode="<%= isUpdateMode ? EditableMode.NONE : editableMode %>"
              size="10"
              conditionallyRequired="<%=ArchitectureConstants.TRUE%>"
              tabIndex="<%= tabIndex++ %>"
              constraint="Date"/>
          </td>
        </tr>
        <tr>
          <td>
            <%
            //--------------------------------
            //--- Date Reviewed with Family ---
            //--------------------------------
            dateAsString = "";
            if (familyPlanBean.getDateCurrentEvalCompleted() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDateCurrentEvalCompleted() );
            }
            %>
            <impact:validateDate
              label="Date Reviewed with Family"
              name="txtDateReviewedWithFamily"
              type="text"
              value="<%= dateAsString %>"
              editableMode="<%= isUpdateMode ? EditableMode.NONE : editableMode %>"
              size="10"
              onChange="futureDateCompletedInvalid(this);"
              conditionallyRequired="<%=ArchitectureConstants.TRUE%>"
              tabIndex="<%= tabIndex++ %>"
              constraint="Date"/>
          </td>
        </tr>
        <tr>
          <td width="47%">
            <%
            //---------------------------
            //--- Date Plan Completed ---
            //---------------------------
            dateAsString = "";
            if ( familyPlanBean.getDatePlanCompleted() != null && !PageModeConstants.NEW_USING.equals(pageMode) )
            {
              dateAsString = FormattingHelper.formatDate( familyPlanBean.getDatePlanCompleted() );
            }
            %>
            <impact:validateDate
              label="Date Plan Completed"
              name="txtDatePlanCompleted"
              type="text"
              value="<%= dateAsString %>"
              size="10"
              editableMode="<%= dtPlanCompletedMode %>"
              onChange="futureDateCompletedInvalid(this);"
              tabIndex="<%= tabIndex++ %>"
              constraint="Date"/>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <table border="0" cellpadding="0" cellspacing="0" width="100%" >
        <tr>
          <td width="35%">If Clients did not participate or sign, Explain:</td>
          <td align="right">
            <%
            //-----------------------
            //--- Client comments ---
            //-----------------------
            String isChecked = ArchitectureConstants.FALSE;
            if ( familyPlanBean.clientGaveComments() )
            {
            isChecked = ArchitectureConstants.TRUE;
            }
            %>
            <impact:validateInput
              label="Client comments"
              name="cbxClientComments"
              type="checkbox"
              value="Y"
              editableMode="<%= editableMode %>"
              checked="<%= isChecked %>"
              cssClass="formInput"
              tabIndex="<%= tabIndex++ %>" />
          </td>
          <td width="3%">&nbsp;</td>
        </tr>
      </table>
   </td>
  </tr>
  <tr>
    <td colspan="2">
      <%
      //-----------------------------------------
      //--- If Clients did not participate... ---
      //-----------------------------------------
      // RIOSJA, SIR 18164 - Field should be editable for evaluations.
      %>
      <impact:validateTextArea
        name="txtExplanationOfClientNonParticipation"
        title="If Clients did not participate or sign, Explain"
        colspan="1"
        rows="3"
        cols="145"
        editableMode="<%= editableMode %>"
        tabIndex="<%= tabIndex++ %>"
        maxLength="1000"
        constraint="Paragraph1000">
      <%= FormattingHelper.formatString( familyPlanBean.getExplanationOfClientNonParticipation() ) %>
      </impact:validateTextArea>
    </td>
  </tr>
</table>
<br>

<%
//******************************************************
//**** REASON FOR INVOLVEMENT/STRENGTHS & RESOURCES ****
//******************************************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th>Reason for Involvement/Strengths & Resources</th></tr>
  <tr>
    <td><span class="formCondRequiredText">&#135;</span>Reason for CPS Involvement:</td>
  </tr>
  <tr>
    <td>
      <%
      //----------------------------------
      //--- Reason for CPS Involvement ---
      //----------------------------------
      %>
      <impact:validateTextArea
        name="txtReasonForInvolvement"
        title="Reason for CPS Involvement"
        colspan="1"
        rows="3"
        cols="145"
        maxLength="1000"
        editableMode="<%= editableMode %>"
        tabIndex="<%= tabIndex++ %>"
        constraint="Paragraph1000">
      <%= FormattingHelper.formatString( familyPlanBean.getReasonForCPSInvolvement() ) %>
      </impact:validateTextArea>
    </td>
  </tr>
  <tr>
    <td><span class="formCondRequiredText">&#135;</span>Description of Family Strengths and Resources:</td>
  </tr>
  <tr>
    <td>
      <%
      //-----------------------------------------------------
      //--- Description of Family Strengths and Resources ---
      //-----------------------------------------------------
      // RIOSJA, SIR 18164 - Field should be editable for evaluations.
      %>
      <impact:validateTextArea
        name="txtStrengthsResources"
        title="Description of Family Strengths and Resources"
        colspan="1"
        rows="3"
        cols="145"
        maxLength="1000"
        editableMode="<%= editableMode %>"
        tabIndex="<%= tabIndex++ %>"
        constraint="Paragraph1000">
      <%= FormattingHelper.formatString( familyPlanBean.getStrengthsAndResources() ) %>
      </impact:validateTextArea>
    </td>
  </tr>
</table>
<br>

<%
//*******************************
//**** FAMILY PLAN ITEM LIST ****
//*******************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr>
    <th>
      <a href="#goToFamilyPlanItemList" name="goToFamilyPlanItemList"></a>
      Family Plan Item List
    </th>
    <td align="right">
      <%
      if ( riskAssmtEvent != null &&
           riskAssmtEvent.getEventId() > 0 )
      {%>
        <a href="JavaScript:goToRiskAssmtDetailPage();">Risk Assessment</a>
      <%
      }
      else
      {%>
        <a href="JavaScript:alert('No risk assessment exists.');">Risk Assessment</a>
      <%
      }
      %>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableborderList">
        <tr>
          <th width="20%" class="thList">Identified in Risk Assessment</th>
          <th width="25%" class="thList">Area of Concern</th>
          <th width="20%" class="thList">Initial Scale of Concern</th>
          <th width="20%" class="thList">Initially Addressed</th>
          <th width="15%" class="thList">Current Scale of Concern</th>
        </tr>

        <%
        // Iterate through the family plan items and display then.
        loopCounter = 0;
        iter = familyPlanBean.getFamilyPlanItemList().iterator();
        while ( iter.hasNext() )
        {
          FamilyPlanItemValueBean itemBean = ( FamilyPlanItemValueBean )iter.next();
          %>
          <tr class="<%= FormattingHelper.getRowCss( loopCounter + 1 ) %>">
            <%
            //-------------------------------------
            //--- Identified in Risk Assessment ---
            //-------------------------------------
            if ( itemBean.isIdentifiedInRiskAssessment() )
            {%>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" border="0">
              </td>
            <%
            }
            else
            {%>
              <td>&nbsp;</td>
            <%
            }
            %>

            <%
            //-----------------------
            //--- Area of Concern ---
            //-----------------------
            // Family plans must be saved to the
            // database at least once before the user can navigate to the Family
            // Plan Item Detail page.
            // Van - Need to add condition for New Using and Update Initial where plan ID is not zero but page never saved
            if ( familyPlanBean.getFamilyPlanId() == 0 || isSetE || isNewUsingMode)
            {%>
              <td>
                <a name="<%= itemBean.getAreaOfConcernCode() %>"></a>
                <a href="JavaScript:alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SVC_SAVE_FAM_PLAN ) %>');"><%= itemBean.getAreaOfConcernText() %></a>
              </td>
            <%}
            else
            {%>
              <td>
                <a name="<%= itemBean.getAreaOfConcernCode() %>"></a>
                <a href="JavaScript:goToFamilyPlanItemDetailPage('<%= itemBean.getAreaOfConcernCode() %>');"><%= itemBean.getAreaOfConcernText() %></a>
              </td>
            <%
            }
            %>


            <%
            //--------------------------------
            //--- Initial Level of Concern ---
            //--------------------------------
            if ( itemBean.getInitialLevelOfConcernScale() != null )
            {%>
              <td><%= Lookup.simpleDecodeSafe( "CRISKSOC", itemBean.getInitialLevelOfConcernScale() ) %></td>
            <%
            }
            else
            {%>
              <td>&nbsp;</td>
            <%
            }
            %>

            <%
            //---------------------------
            //--- Initially Addressed ---
            //---------------------------
            if ( itemBean.getDateInitiallyAddressed() != null )
            {%>
              <td><%= dateFormatter.format( itemBean.getDateInitiallyAddressed() ) %></td>
            <%
            }
            else
            {%>
              <td>&nbsp;</td>
            <%
            }
            %>

            <%
            //--------------------------------
            //--- Current Level of Concern ---
            //--------------------------------
            if ( itemBean.getCurrentLevelOfConcernScale() != null )
            {%>
              <td><%= Lookup.simpleDecodeSafe( "CRISKSOC", itemBean.getCurrentLevelOfConcernScale() ) %></td>
            <%
            }
            else
            {%>
              <td>&nbsp;</td>
            <%
            }
            %>

          </tr>
          <%
          loopCounter++;
        } // end while ( iter.hasNext() )
        %>
      </table>
    </td>
  </tr>
</table>

<%
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
{%>
  <br>
  <hr>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td width="100%" align="right">
        <impact:spellCheck
          formToSpellCheck="frmFamilyPlan"
          fieldsToSpellCheck="<%= fieldsToBeSpellChecked %>"
          tabIndex="<%=tabIndex++%>"/>
      </td>
      <td align="right">
        <impact:ButtonTag
          name="<%= FamilyPlanConversation.SAVE_SUBMIT_BUTTON %>"
          img="btnSaveAndSubmit"
          align="right"
          form="frmFamilyPlan"
          disabled="<%= bDisableSaveAndSubmit %>"
          action="/serviceDelivery/FamilyPlan/saveAndSubmitFamilyPlan"
          restrictRepost="true"
          preventDoubleClick="true"
          function="return confirmSaveAndSubmit()"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td align="right">
        <impact:ButtonTag
          name="<%= FamilyPlanConversation.SAVE_BUTTON_ON_DETAIL_PAGE %>"
          img="btnSave"
          align="right"
          form="frmFamilyPlan"
          action="/serviceDelivery/FamilyPlan/saveFamilyPlan"
          restrictRepost="true"
          preventDoubleClick="true"
          tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
<%
//*********************************************
//**** FORM (FAMILY PLAN DETAIL) ENDS HERE ****
//*********************************************
%>

<%
//***************
//**** FORMS ****
//***************
%>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr><th>Forms Launch</th></tr>
  <tr>
    <td>
      <impact:documentList pageMode="<%= PageModeConstants.EDIT %>" tabIndex="<%= tabIndex++ %>" >
        <%
        // The document name will be: 1) "Family Plan" if the family plan
        // has not yet been saved, 2) the family plan event description
        String documentDisplayName = "Family Plan";
        if ( familyPlanBean.getFamilyPlanEvent().getEventId() > 0 )
        {
          documentDisplayName = familyPlanBean.getFamilyPlanEvent().getEventDescription();
        }
        %>
        <impact:document
          displayName="Family Service Plan"
          docType="cfsd0500"
          docExists="false"
          protectDocument="true"
          promptSavePage="frmFamilyPlan"
          onClick="documentCheck()">

          <impact:documentParameter
            name="pEvent"
            value="<%= FormattingHelper.formatInt(familyPlanBean.getFamilyPlanEvent().getEventId() ) %>"/>

          <impact:documentParameter
            name="pStage"
            value="<%= FormattingHelper.formatInt(familyPlanBean.getFamilyPlanEvent().getStageId() ) %>"/>
        </impact:document>
      </impact:documentList>

    </td>
  </tr>
</table>
<br>