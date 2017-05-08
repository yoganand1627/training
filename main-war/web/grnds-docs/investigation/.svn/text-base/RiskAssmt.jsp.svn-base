<%
/**--------------------------------------------------------------------------------
 *
 * JSP Name:     Risk Assessment
 * Created by:   Jason Rios
 * Date Created: 10/23/02
 *
 * Description:
 * This JSP displays the details for a given Risk Assessment. Depending upon
 * the user's privileges, the user can use this page to view and update Risk
 * Assessments.
*/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  06/09/03  Todd Reser        SIR 18134 Added a <br> and removed unused imports,
                              moved Narrative button to before Reports section.
  03/14/05  CORLEYAN          SIR 23471 - Added a hyperlink at the top of the
                              page which navigates directly to the Risk
                              Assessment Definitions in FYI.
  06/07/09  mchillman		  STGAP00014127: Added Current Level of Risk to the Risk Assessment 
                              page in the ONG stage
  ------------------------------------------------------------------------------
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtPriorHistoryValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************   
int loopCounter = 0;
int tabIndex = 1;
List riskFactorBeansList = null;
RiskAssmtValueBean riskAssmtBean = null;
RiskFactorValueBean riskFactorBean = null;
RiskFactorValueBean currentRiskFactorBean = null;
RiskFactorValueBean nextRiskFactorBean = null;
Iterator factorBeansIterator = null;
Iterator iter = null;
String isChecked = null;
RiskAssmtPriorHistoryValueBean riskAssmtHistoryBean = null;
String previousAreaCode = null;
String previousCategoryCode = null;
String fieldLabel = null;
String fieldName = null;
String fieldValue = null;
String expandedDivName = null;
String collapsedDivName = null;
Map completionCheckMap = null;
String txtDtResponse = "";
String txtTmResponse = null;
String rbHIPPASigned = null;
String rbHIPPAPolicyExplained = null;
String txtDtParentNotified = "";
String rbParentNotified = null;
String txtDtParentsGuide = "";
String rbParentsGuide = null;
String txtDtHIPPASignedAndAck = "";
String rbChildVulnerability = null;
String cbxChildFragilityProtect = null;
String txtDateOfReport = "";
String cbxChildDeathOrSeriousInjury = null;
String txtDtOfClosure = "";
String txtSummaryOfFindings = null;
String txtRiskAssmtJust = null;
String rbCaregiverCapability = null;
String cbxChildBehaviour = null;
String cbxPhysicalCare = null;
String cbxKnowledgeSkills = null;
String cbxControl = null;
String cbxEmotionalCare = null;
String cbxFunctioning = null;
String rbQualityOfCare = null;
String cbxChronicity = null;
String cbxCurrentSeverity = null;
String rbMaltreatmentPattern = null;
String cbxTrend = null;
String rbHomeEnv = null;
String cbxStressors = null;
String cbxDangerousExposure = null;
String rbSocialEnv= null;
String cbxSocialClimate= null;
String cbxSocialViolence = null;
String rbResponseToIntervention = null;
String cbxAttitude = null;
String cbxDeception = null;
String txtRiskAssmtPriorHistory = null;
String txtSummarizeJustificationOfFindings = null;
Boolean areaIsComplete = Boolean.FALSE;
Boolean historyComplete = Boolean.FALSE;
String yIsChecked = "false";
String nIsChecked = "false";
String uIsChecked = "false";
String rbResponseTime = null;
String comments ="";
String Attitude = null;
String commentsHIPPA = "";
String justicationOfFindings = "";
String categoryJustificationOfFindings = "";
String AreaText = "Prior History Report/Screening";
String InvAreaText= "Investigation Actions";
String FmlyStrAreaText= "Assessment of Family Strengths";

Boolean performCompletionCheck = Boolean.FALSE;
int numOfFactors = 0;
int numOfAreas = 0;
List<RiskFactorValueBean> factorBeansInSameArea = new ArrayList<RiskFactorValueBean>();
List<List<RiskFactorValueBean>> factorBeansByArea = new ArrayList<List<RiskFactorValueBean>>();



//***********************************
//*** RETRIEVE HIDDEN STATE FIELD ***
//***********************************
BaseSessionStateManager state = ( BaseSessionStateManager )request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

//*********************
//*** SET PAGE MODE ***
//*********************
String pageMode = PageModeConstants.INQUIRE;
if( PageMode.getPageMode( request ) != null )
{
  pageMode = PageMode.getPageMode( request );
}

//**************************
//*** RETRIEVE PAGE DATA ***
//**************************
UserProfile user = UserProfileHelper.getUserProfile( request );

// Get the Risk Assessment bean from the request
if ( state.getAttribute( "riskAssmtBean" , request ) != null )
{
  riskAssmtBean = ( RiskAssmtValueBean )state.getAttribute( "riskAssmtBean" , request );
}

// Check the request to see if the "performCompletionCheck" indicator
// has been passed to this page. If the indicator has been passed to
// this page and is "true", then a completion check is being performed.
// This page needs to display the appropriate messages.
if ( request.getAttribute("performCompletionCheck") != null )
{
  performCompletionCheck = ( Boolean )request.getAttribute("performCompletionCheck");
}

%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
};

function documentAlert()
{
  alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_ARC_SAVE_PAGE) %>');
  return false;
}

// If a supervisor accessed this page in approval mode and they change
// the Risk Finding, this function will display a message warning them
// that the PENDing Investigation Conclusion will be invalidated if they
// save the page.
function checkRiskFindingValue()
{
  <%
  if( riskAssmtBean.isApprovalMode() )
  {%>
    if( document.frmRiskAssmt.selFinding.value != "<%= FormattingHelper.formatString( riskAssmtBean.getFinding() ) %>" )
    {
      // This hardcoded message needs to be replaced with MessageLookup
      // once MSG_RA_WILL_INVALIDATE_CONCL is available in the Message
      // table.
      alert("If you save the page after changing the Risk Finding, the pending Investigation Conclusion will be invalidated.");
    }
  <%
  }
  %>
}

//-- this function called when clicking on area concern hyperlinks
function callAreaConcernFormSubmit(txt) {
  AreaConcernForm.AreaTxtName.value=txt;
  var errorList = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=auto,resizable=yes,width=600,height=350');
  AreaConcernForm.target = "txtWin";
  if( window.focus ) {
    errorList.focus();
  }
  AreaConcernForm.submit();
}
</script>

<a name="top"></a>

<%
//***********************************
//**** COMPLETION CHECK MESSAGES ****
//***********************************
// This code will handle displaying appropriate messages whenever then user
// performs a Completion Check. If the Risk Assessment is complete, a message
// will be displayed informing them that it is complete. If the Risk Assessment
// is incomplete, then a message will be displayed informing the user which
// sections are incomplete. NOTE: A Risk Assessment is considered complete if
// all factors have been answered and all Scales of Concern have been specified,
// OR if the user selected "Risk Assessment N/A" (Code "04") as the Risk Finding.


if (performCompletionCheck )
{
  if (( riskAssmtBean.isComplete()) && (riskAssmtBean.isInvActionsComplete())
       && (riskAssmtBean.isAssessmentOfFmlyStrComplete()))
  // ||CodesTables.CCRSKFND_04.equals( riskAssmtBean.getFinding() ) )
  {%>
    <table border="0" cellspacing="0" cellpadding="3" width="100%">
      <tr>
        <td>
          <hr>
          <span class="formErrorText"><%= MessageLookup.getMessageByName( "MSG_RA_COMPLETE") %></span>
          <hr>
        </td>
      </tr>
    </table>
  <%
  }
  else
  {%>
    <table border="0" cellspacing="0" cellpadding="3" width="100%">
      <tr><td colspan="2"><hr></td></tr>
      <tr>
        <td colspan="2">
          <span class="formErrorText"><%= MessageLookup.getMessageByName( "MSG_RA_NOT_COMPLETE") %></span><br>
        </td>
      </tr>
   
  <%--  <%
      // If 'Risk Finding' is null, inform the user.
      if ( riskAssmtBean.getFinding() == null )
      { %>
             <tr>
          <td width="7%">&nbsp;</td>
          <td><li><a href="JavaScript:document.frmRiskAssmt.selFinding.focus();">Risk Finding</a> has not been specified.</li></td>
        </tr>  
       <%
       } %>  --%>
       
      <%
      completionCheckMap = riskAssmtBean.getAreaCompletionStatus();

      // Iterate through the Factor beans for this Risk Assessment and check
      // each Area for completion. If the Area is incomplete, then list it as
      // an Area that needs to be completed.
      factorBeansIterator = riskAssmtBean.getFactors().iterator();
      while ( factorBeansIterator.hasNext() )
      {
        riskFactorBean = ( RiskFactorValueBean )factorBeansIterator.next();

        // If the 'previousAreaCode' is null, then we are checking the first
        // Area in the list. Get its "isComplete" indicator. If the current
        // Area is different from the previous Area, then we should check the
        // new Area for completion. Get its "isComplete" indicator.
        if ( previousAreaCode == null || !previousAreaCode.equals( riskFactorBean.getAreaCode() ) )
        {
          areaIsComplete = ( Boolean )completionCheckMap.get( riskFactorBean.getAreaCode() );

          // If the Area is incomplete, then list it as an Area that needs
          // to be completed.
          if ( !areaIsComplete )
          {
            // Dynamically create the names that will be used for the DIV tags
            // for the collapsed and expanded Area tables.
            //
            // When the user clicks on an anchor to go to a particular Area,
            // that Area table must first be expanded. Then the user will be
            // anchored to that Area.
            collapsedDivName = "collapsed" + riskFactorBean.getAreaCode();
            expandedDivName = "expanded" + riskFactorBean.getAreaCode();
            %>
            <tr>
              <td width="7%">&nbsp;</td>
              <td><li><a href="#anchor<%= riskFactorBean.getAreaCode() %>" onClick="toggleVisibility('<%= expandedDivName %>','block','block','block'); toggleVisibility('<%= collapsedDivName%>','none','none','none');"><%= riskFactorBean.getAreaText() %></a></li></td>
            </tr>
          <%
          }
        }

        previousAreaCode = riskFactorBean.getAreaCode(); 
        } // end while 

           collapsedDivName = "collapsedInvestigation Actions";
           expandedDivName = "expandedInvestigation Actions";
           if(riskAssmtBean.isInvActionsComplete())
           {
            //do not display link
           }else{ %>
       <tr>
           <td width="7%">&nbsp;</td>
           <td><li><a href="#anchorInvestigation Actions" onClick="toggleVisibility('<%= expandedDivName %>','block','block','block'); toggleVisibility('<%= collapsedDivName %>','none','none','none');"><%= InvAreaText %></a></li></td>
       </tr>
       <%  }
           collapsedDivName = "collapsedAssessment of Family Strengths";
           expandedDivName = "expandedAssessment of Family Strengths";
           if(riskAssmtBean.isAssessmentOfFmlyStrComplete())
           {
            //do not display link
           }else{%>
            
       <tr>
           <td width="7%">&nbsp;</td>
           <td><li><a href="#anchorAssessment of Family Strengths" onClick="toggleVisibility('<%= expandedDivName %>','block','block','block'); toggleVisibility('<%= collapsedDivName %>','none','none','none');"><%= FmlyStrAreaText %></a></li></td>
       </tr>
       <%}%>
      <tr><td colspan="2"><hr></td></tr>
    </table>
  <%
  }
}

//**************************
//**** FORM STARTS HERE ****
//**************************
%>
<impact:validateErrors/>
<impact:validateForm name="frmRiskAssmt"
  method="post"
  action="/investigation/RiskAssmt/displayRiskAssmt"
  pageMode="<%= pageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.investigation.RiskAssessmentCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

<%/* Create a hidden field with the Risk Assessment Date Last Update */%>
<impact:validateInput type="hidden" name="hdnDateLastUpdate" value="<%= DateHelper.toISOStringSafe( riskAssmtBean.getDateLastUpdate() ) %>"/>
<%/* Create a hidden field with the Risk Assessment Case Id */%>
<impact:validateInput type="hidden" name="hdnCaseId" value="<%= String.valueOf( riskAssmtBean.getCaseId() ) %>"/>
<%/* Create a hidden field with the Risk Assessment Stage Id */%>
<impact:validateInput type="hidden" name="hdnStageId" value="<%= String.valueOf( riskAssmtBean.getStageId() ) %>"/>
<%/* Create a hidden field with the Risk Assessment Event Id */%>
<impact:validateInput type="hidden" name="hdnEventId" value="<%= String.valueOf( riskAssmtBean.getEventId() ) %>"/>
<%/* Create a hidden field with the Risk Assessment Event Date Last Update */%>
<impact:validateInput type="hidden" name="hdnEventDateLastUpdate" value="<%= DateHelper.toISOStringSafe( riskAssmtBean.getEventDateLastUpdate() ) %>"/>
<%/* Create a hidden field with the Risk Assessment Event Status */%>
<impact:validateInput type="hidden" name="hdnEventStatus" value="<%= StringHelper.getNonNullString( riskAssmtBean.getEventStatus() ) %>"/>
<%
//********************************
//**** PURPOSE & RESPONSE DATE ***
//********************************
%>
<%     String ResponseTime_Yes = "false";
       String ResponseTime_No = "false";
       String ind_responseTime= riskAssmtBean.getIndResponse();
       if (ind_responseTime != null)
        {
          if (ind_responseTime.equals("N")) {
         ResponseTime_No = "true";
           } else {
         ResponseTime_Yes = "true";
         }
       } %>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll();">Expand All</a>
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll();">Collapse All</a>
    </td>
  </tr>
</table>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Purpose </th>
  </tr>
  <tr>
    <%
    // The Purpose should default to 'Investigation' if it is null.
    fieldValue = CodesTables.CPURPRSK_INV;
    if ( riskAssmtBean.getPurpose() != null )
    {
      fieldValue = riskAssmtBean.getPurpose();
    }
    if ( riskAssmtBean.getDateResponse()!= null )
     {
       txtDtResponse = FormattingHelper.formatDate(riskAssmtBean.getDateResponse());
       txtTmResponse = riskAssmtBean.getTmResponse();
     }
     if ( riskAssmtBean.getIndResponse()!= null )
     {
       rbResponseTime = riskAssmtBean.getIndResponse();
     } 
   %>
   
   <%
   // Risk assessment created in stage ONG is a Reassessment so set default value of purpose to be Risk ReAssesments if stage is ONG (FPR)
   if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
     fieldValue = CodesTables.CPURPRSK_RRA;
   }
   %>

    <td>
      <impact:validateSelect
        label="Purpose"
        name="selPurpose"
        codesTable="CPURPRSK"
        value="<%= fieldValue %>"
        required="true"
        tabIndex="<%= tabIndex++ %>"/>
     </td>
   </tr>
   <tr>
     <td>
      <impact:validateDate
        label="Response Date"
        type="text"
        size="10"
        value="<%= txtDtResponse %>"
        name="txtDtResponse"
        tabIndex="<%= tabIndex++ %>"
        required="true"
        constraint="Date"/>  
     </td>
   </tr>
   <tr>
     <td>
      <impact:validateTime
        label="Response Time"
        name="txtTmResponse"
        value="<%= txtTmResponse %>"
        tabIndex="<%= tabIndex++ %>"
        required="true"/>
    </td>
   </tr>
  <%-- <tr>
   <td>
    <impact:validateDisplayOnlyField
         label = "Was Response Time Met ?"
         name = "ResponseInd"
         required = "true"
         value = ""/> --%>
        
  <tr>
  <td> <span class="formRequiredText">*</span>Was Response Time Met ? </td>
  <td>
     <impact:validateInput type="radio" label="Yes" id="ResponseTime_Yes" name="rbResponseTime" value="Y" cssClass="formInput" checked="<%= ResponseTime_Yes %>" tabIndex="<%= tabIndex++ %>" />
    <impact:validateInput type="radio" label="No"  id="ResponseTime_No" name="rbResponseTime" value="N" cssClass="formInput" checked="<%= ResponseTime_No %>" tabIndex="<%= tabIndex++ %>" /> 
    </td>
  </tr>
  <% 
  //check if the stage is ongoing to display the Current Level of Risk field
  if(CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) { 
  %>
  <tr>
   <td>
     <impact:validateSelect
       label="Current Level of Risk"
       name="selCurrLvlRisk"
       codesTable="CLVLRSK"
       value="<%= riskAssmtBean.getCdCurrLvlRisk() %>"
       required="true"
       tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
  <% } %> 
</table>
<br>

<%
//*****************
//**** SUMMARY ****
//*****************
%>
<impact:ExpandableSectionTag
  name="Summary"
  id=""
  label="Summary"
  tabIndex="<%= tabIndex++ %>">

<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
  <tr class="thList">
    <th>Area of Concern</th>
    <th>Scale of Concern</th>
  </tr>
  <%
  // Iterate through the factor beans for this Risk Assessment and display
  // each Area and Category. The factor bean will contain data pertaining
  // to the Factor and the Area and Category to which the factor belongs.
  previousAreaCode = null;
  previousCategoryCode = null;
  factorBeansIterator = riskAssmtBean.getFactors().iterator();
  while ( factorBeansIterator.hasNext() )
  {
    // If 'previousAreaCode' is null, then display the current Area since
    // it is the very first one. Also display the Area if is different from
    // the previous one.
    riskFactorBean = ( RiskFactorValueBean )factorBeansIterator.next();
    if ( previousAreaCode == null || !previousAreaCode.equals( riskFactorBean.getAreaCode() ) )
    {%>
      <tr class="even">
        <td><%= riskFactorBean.getAreaText() %></td>
        <%
        // If the Overall Scale of Concern is not null, then display the
        // appropriate decode. If the Overall Scale of Concern is null,
        // display "Not Complete".
        if ( riskFactorBean.getAreaScaleOfConcern() != null )
        {%>
          <td><%= Lookup.simpleDecodeSafe( "CRISKSOC", riskFactorBean.getAreaScaleOfConcern() ) %></td>
        <%
        }
        else
        {%>
          <td><i>Not Complete</i></td>
        <%
        }
        %>
      </tr>
    <%
    }

    // If 'previousCategoryCode' is null, then display the current Category
    // since it is the very first one for this Area. Also display the Category
    // if is different from the previous one.
    if ( previousCategoryCode == null || !previousCategoryCode.equals( riskFactorBean.getCategoryCode() ) )
    {
      // Dynamically create the names that will be used for the DIV tags
      // for the collapsed and expanded Area tables.
      //
      // When the user clicks on an anchor to go to a particular Category,
      // that Category's Area table must first be expanded. Then the user
      // will be anchored to that Category.
      collapsedDivName = "collapsed" + riskFactorBean.getAreaCode();
      expandedDivName = "expanded" + riskFactorBean.getAreaCode();
      %>
      <tr class="odd">
        <td><a href="#<%= riskFactorBean.getCategoryCode() %>" onClick="toggleVisibility('<%= expandedDivName %>','block','block','block'); toggleVisibility('<%= collapsedDivName%>','none','none','none');" tabIndex="<%= tabIndex++ %>"><%= riskFactorBean.getCategoryText() %></a></td>
        <%
        // If the Overall Scale of Concern is not null, then display the
        // appropriate decode. If the Overall Scale of Concern is null,
        // display "Not Complete".
        if ( riskFactorBean.getCategoryScaleOfConcern() != null )
        {%>
          <td><%= Lookup.simpleDecodeSafe( "CRISKSOC", riskFactorBean.getCategoryScaleOfConcern() ) %></td>
        <%
        }
        else
        {%>
          <td><i>Not Complete</i></td>
        <%
        }
        %>
      </tr>
    <%
    }
    previousAreaCode = riskFactorBean.getAreaCode();
    previousCategoryCode = riskFactorBean.getCategoryCode();
  }// end while
  %>
</table>
</impact:ExpandableSectionTag>

<%
//**************************
//**** AREAS OF CONCERN ****
//**************************
//---------------------------------
//--- GROUP THE FACTORS BY AREA ---
//---------------------------------
// Iterate through the factor beans for this Risk Assessment and display
// each the data as needed. The factor bean will contain data pertaining
// to the Factor and the Area and Category to which the factor belongs.
riskFactorBeansList = (ArrayList)riskAssmtBean.getFactors();
numOfFactors = riskFactorBeansList.size();

for ( int i = 0; i < numOfFactors; i++ )
{
  // Get the current factor bean.
  currentRiskFactorBean = ( RiskFactorValueBean )riskFactorBeansList.get( i );

  // Get the next factor bean if one is available.
  nextRiskFactorBean = null;
  if ( i < ( numOfFactors - 1 ) )
  {
    nextRiskFactorBean = ( RiskFactorValueBean )riskFactorBeansList.get( i + 1 );
  }

  // If this is the first iteration through the loop, then add the current
  // factor bean to the array of factorBeansInSameArea. It will be the first
  // bean in the array.
  if ( i == 0 )
  {
    factorBeansInSameArea.add( currentRiskFactorBean );
  }
  // If the current factor bean is the last bean in the factor beans array,
  // or if the next factor bean is in a different Area from the current factor
  // bean, then the current factor bean is the final bean to be added the
  // factorBeansInSameArea array. Add the bean to the array, and add the array
  // to the factorBeansByArea parent array.
  else if ( nextRiskFactorBean == null ||
            !currentRiskFactorBean.getAreaCode().equals( nextRiskFactorBean.getAreaCode() ) )
  {
    factorBeansInSameArea.add( currentRiskFactorBean );
    factorBeansByArea.add( factorBeansInSameArea );

    // If the current factor bean is not the last bean in the factor beans
    // array, then reset the factorBeansInSameArea array so that we can start
    // adding factor beans to it during the next iteration through the loop.
    factorBeansInSameArea = null;
    if ( nextRiskFactorBean != null )
    {
      factorBeansInSameArea = new ArrayList<RiskFactorValueBean>();
    }
  }
  // Add the current factor bean to the factorBeansInSameArea array.
  else
  {
    factorBeansInSameArea.add( currentRiskFactorBean );
  }
}// end for loop



//-----------------------------------
//--- DISPLAY THE FACTORS BY AREA ---
//-----------------------------------
// Get the total number of Areas in the Risk Assessment.
numOfAreas = factorBeansByArea.size();

// Get the hashtable of "isComplete" indicators.
completionCheckMap = riskAssmtBean.getAreaCompletionStatus();

// Loop through the array of factorBeansByArea. Get each factorBeansInSameArea
// array which contains all the factors in the same area. Then loop through each
// of those arrays and display the Areas of Concern one at a time. Each Area of
// Concern will appear in its own expandable section.
for ( int j = 0; j < numOfAreas; j++ )
{
  loopCounter = 1;
  factorBeansInSameArea = factorBeansByArea.get( j );

  areaIsComplete = ( Boolean )completionCheckMap.get( (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaCode() );

  // Each iteration through the parent loop will create a new Area of Concern
  // expandable section. Start the expandable section here.
  %>
  <br>
  <impact:ExpandableSectionTag
    name="<%= (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaCode() %>"
    id=""
    label="<%= (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaText() %>"
    tabIndex="<%= tabIndex++ %>"
    anchor="<%= (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getAreaCode() %>"
    isComplete="<%= areaIsComplete.booleanValue() %>">

  <%
  // Display the header for this Area of Concern's first Category.
  %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderExpand">
    <tr class="thList">
      <th>Y</th>
      <th>N</th>
      <th>U</th>
      <th width="100%"><a name="<%= (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getCategoryCode() %>"></a>
        <%= (( RiskFactorValueBean )factorBeansInSameArea.get( 0 )).getCategoryText() %>
      </th>
    </tr>

  <%
  numOfFactors = factorBeansInSameArea.size();
  for ( int k = 0; k < numOfFactors; k++ )
  {
    // Get the current factor bean.
    currentRiskFactorBean = ( RiskFactorValueBean )factorBeansInSameArea.get( k );

    // Get the next factor bean if one is available.
    nextRiskFactorBean = null;
    if ( k < ( numOfFactors - 1 ) )
    {
      nextRiskFactorBean = ( RiskFactorValueBean )factorBeansInSameArea.get( k + 1 );
    }

    // Display the current factor. (Also, temporarily save the class
    // used for this table row so that if this factor has comments,
    // the comments row, which is the next table row, will have the
    // same background color.)
    String tableRowClass = FormattingHelper.getRowCss( loopCounter++ );
    %>
    <tr class="<%= tableRowClass %>">
      <%
      // Dynamically create the name to be used for the Factor's
      // possible responses radio buttons.
      fieldName = "rb" + currentRiskFactorBean.getFactorCode() + "Response";
      // Set the "is checked" indicator for each possible response
      // based upon the response value retrieved from the database.
      yIsChecked = "false";
      nIsChecked = "false";
      uIsChecked = "false";
      if ( currentRiskFactorBean.getFactorResponse() != null )
      {
        if ("0".equals(currentRiskFactorBean.getFactorResponse()) )
        {
          yIsChecked = "true";
        }
        else if ("1".equals(currentRiskFactorBean.getFactorResponse()) )
        {
          nIsChecked = "true";
        }
        else if ("2".equals(currentRiskFactorBean.getFactorResponse()) )
        {
          uIsChecked = "true";
        }
      }
     
      %>
      <%/* Create the radio buttons for the Factor's possible responses. */%>
      <td><impact:validateInput type="radio" checked="<%= yIsChecked %>" tabIndex="<%= tabIndex++ %>" value="0" name="<%= fieldName %>" cssClass="formInput" /></td>
      <td><impact:validateInput type="radio" checked="<%= nIsChecked %>" tabIndex="<%= tabIndex++ %>" value="1" name="<%= fieldName %>" cssClass="formInput" /></td>
      <td><impact:validateInput type="radio" checked="<%= uIsChecked %>" tabIndex="<%= tabIndex++ %>" value="2" name="<%= fieldName %>" cssClass="formInput" /></td>
      <td>
         <% String FactorText = currentRiskFactorBean.getFactorText();
            String AreaConcernTxt =  currentRiskFactorBean.getAreaConcernText();
           
            String code = "";
            String Desc = "";
            int i  = FactorText.indexOf('-');
             if( i == 7)
              {
               code = FactorText.substring(0,i); 
               Desc = FactorText.substring(i);
               AreaConcernTxt = URLHelper.encode(AreaConcernTxt);
           %>
         <a name="<%= code %>" href="#<%= code %>" onClick = "callAreaConcernFormSubmit('<%= AreaConcernTxt %>')"> <%= code %> </a><%= Desc%> <%} else {%>
          <%= FactorText%> <%}%>
          
        <%
        // Dynamically create the name to be used for the Factor's id
        // hidden field.
        fieldName = "hdn" + currentRiskFactorBean.getFactorCode() + "Id";
        %>
        <impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= FormattingHelper.formatInt( currentRiskFactorBean.getFactorId() ) %>"/>
        <%
        // Dynamically create the name to be used for the Factor's Date
        // Last Update hidden field.
        fieldName = "hdn" + currentRiskFactorBean.getFactorCode() + "DateLastUpdate";
        %>
        <impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= DateHelper.toISOStringSafe( currentRiskFactorBean.getFactorDateLastUpdate() ) %>"/>
      </td>
    </tr>

    <%
    // Legacy risk assessments could have comments associated with the
    // factor. If this factor has comments, display them.
    if ( currentRiskFactorBean.getFactorComment() != null &&
        !"".equals(currentRiskFactorBean.getFactorComment()) )
    {
    %>
      <tr class="<%= tableRowClass %>">
        <td colspan="3">Comments:</td>
        <td><%= currentRiskFactorBean.getFactorComment() %></td>
      </tr>
    <%
    }
    %>

    <%
    // If there are no more factors in the current Category, then finish the
    // Category by displaying the Category Overall Scale of Concern.
    if ( nextRiskFactorBean == null ||
         !currentRiskFactorBean.getCategoryCode().equals( nextRiskFactorBean.getCategoryCode() ) )
    {%>
      <tr class="odd">
        <td colspan="4">
          <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
              <td width="40%">
                <%
                // Dynamically create the name to be used for the Category's id
                // hidden field.
                fieldName = "hdn" + currentRiskFactorBean.getCategoryCode() + "Id";
                %>
                <impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= FormattingHelper.formatInt( currentRiskFactorBean.getCategoryId() ) %>"/>
                <%
                // Dynamically create the name to be used for the Category's
                // Date Last Update hidden field.
                fieldName = "hdn" + currentRiskFactorBean.getCategoryCode() + "DateLastUpdate";
                %>
                <impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= DateHelper.toISOStringSafe( currentRiskFactorBean.getCategoryDateLastUpdate() ) %>"/>
                <%
                // Dynamically create the name and label to be used for the
                // Category's Overall Scale of Concern drop-down field.
                fieldLabel = currentRiskFactorBean.getCategoryText() + " Scale of Concern";
                fieldName = "sel" + currentRiskFactorBean.getCategoryCode() + "ScaleOfConcern";
                %>
                <%
                if ( currentRiskFactorBean.getCategoryScaleOfConcern() == null )
                {%>
                  <impact:validateSelect blankValue="true" label="<%= fieldLabel %>" required="false" name="<%= fieldName%>" tabIndex="<%= tabIndex++ %>" codesTable="CRISKSOC" value="<%= FormattingHelper.formatString( currentRiskFactorBean.getCategoryScaleOfConcern() ) %>"/>
                <%
                }
                else
                {%>
                  <impact:validateSelect blankValue="false" label="<%= fieldLabel %>" required="false" name="<%= fieldName%>" tabIndex="<%= tabIndex++ %>" codesTable="CRISKSOC" value="<%= FormattingHelper.formatString( currentRiskFactorBean.getCategoryScaleOfConcern() ) %>"/>
                <%
                }
                %>
              </td>
              <td width="40%">&nbsp;</td>
            </tr>
          </table>
        </td>
      </tr>
    <%
    }

    // If a new Category will start in the next iteration of the loop,
    // then display the Category header here.
    if ( nextRiskFactorBean != null &&
         !currentRiskFactorBean.getCategoryCode().equals( nextRiskFactorBean.getCategoryCode() ) )
    {
      loopCounter = 1;
      %>

      <tr class="thList">
        <th>Y</th>
        <th>N</th>
        <th>U</th>
        <th>
          <a name="<%= nextRiskFactorBean.getCategoryCode() %>"></a>
          <%= nextRiskFactorBean.getCategoryText() %>
        </th>
      </tr>
    <%
    }

    // If there are no more factors in this Area of Concern, then finish
    // the Area of Concern by displaying the Area of Concern's Overall
    // Scale of Concern.
    if ( nextRiskFactorBean == null )
    {%>
        <tr>
          <th colspan="4">
            <%= currentRiskFactorBean.getAreaText() %>&nbsp;Overall Scale of Concern
          </th>
        </tr>
        <tr class="odd">
          <td colspan="4">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr>
                <td width="40%">
                  <%
                  // Dynamically create the name to be used for the Area's id
                  // hidden field.
                  fieldName = "hdn" + currentRiskFactorBean.getAreaCode() + "Id";
                  %>
                  <impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= FormattingHelper.formatInt( currentRiskFactorBean.getAreaId() ) %>"/>
                  <%
                  // Dynamically create the name to be used for the Area's
                  // Date Last Update hidden field
                  fieldName = "hdn" + currentRiskFactorBean.getAreaCode() + "DateLastUpdate";
                  %>
                  <%/* Create the Area's Date Last Update hidden field */%>
                  <impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= DateHelper.toISOStringSafe( currentRiskFactorBean.getAreaDateLastUpdate() ) %>"/>
                  <%
                  // Dynamically create the name and label to be used for the
                  // Area's Overall Scale of Concern drop-down field.
                  fieldLabel = currentRiskFactorBean.getAreaText() + " Overall Scale of Concern";
                  fieldName = "sel" + currentRiskFactorBean.getAreaCode() + "ScaleOfConcern";
                  %>
                  <%
                  if ( currentRiskFactorBean.getAreaScaleOfConcern() == null )
                  {%>
                    <impact:validateSelect blankValue="true" label="<%= fieldLabel %>" required="false" name="<%= fieldName %>" tabIndex="<%= tabIndex++ %>" codesTable="CRISKSOC" value="<%= FormattingHelper.formatString( currentRiskFactorBean.getAreaScaleOfConcern() ) %>"/>
                  <%
                  }
                  else
                  {%>
                    <impact:validateSelect blankValue="false" label="<%= fieldLabel %>" required="false" name="<%= fieldName %>" tabIndex="<%= tabIndex++ %>" codesTable="CRISKSOC" value="<%= FormattingHelper.formatString( currentRiskFactorBean.getAreaScaleOfConcern() ) %>"/>
                  <%
                  }
                  %>
                </td>
                
                <td width="40%">&nbsp;</td>
              </tr>
              <tr><td>&nbsp;</td></tr>
              
              <tr>
                 <td> 
                    <impact:validateTextArea 
                       label = "Justification Of Findings"
                       name="<%= "txt" + currentRiskFactorBean.getAreaCode() + "justification" %>"
                       tabIndex="<%= tabIndex++ %>"
                       constraint="Comments"
                       cols = "50"
                       rows = "5"><%= FormattingHelper.formatString(currentRiskFactorBean.getCategoryJustificationOfFindings())%></impact:validateTextArea>
                 </td>
              </tr>
              
            </table>
          </td>
        </tr>
      </table>
      <%/* "Back to Top" anchor & Save Button */%>
      <table border="0" cellpadding="3" cellspacing="0" width="100%">
        <tr>
          <td><a href="#top">Back to Top</a></td>
          <%
          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            %>
            <td>
              <impact:ButtonTag
                  name="<%= fieldName %>"
                  img="btnSave"
                  align="right"
                  form="frmRiskAssmt"
                  action="/investigation/RiskAssmt/saveRiskAssmt"
                  restrictRepost="true"
                  preventDoubleClick="true"
                  tabIndex="<%= tabIndex++ %>"/>
            </td>
          <%
          }
          %>
        </tr>
      </table>
    <%
    }// end if
  }// end for

  // Each iteration through the parent loop will create a new Area of Concern
  // expandable section. End the expandable section here.
  %>
  </impact:ExpandableSectionTag>
  
<%
}// end for
%>

<br>

<%
//***************************************
//**** PRIOR HISTORY REPORT\SCREENING****
//***************************************
%>

    <impact:ExpandableSectionTag 
    label = "Prior History Report/Screening" 
    name = "Prior History Report/Screening" 
    id=""
    anchor="Prior History Report/Screening"
    isComplete="<%= riskAssmtBean.isPriorHistoryComplete() %>"
    tabIndex="<%= tabIndex++ %>"> 
  <table border="0" cellpadding="0" cellspacing="0" width = "100%" class="subDetail">
  
   <%
  // Display the task/services.
     
     iter = riskAssmtBean.getReports().iterator();
     loopCounter = 0;
      while ( iter.hasNext() )
      {
        RiskAssmtPriorHistoryValueBean reportsBean = ( RiskAssmtPriorHistoryValueBean )iter.next();
   %>
     <tr <% if ( loopCounter%2 == 1 ) { %>class="even"<% } %>> 
     </tr>
     <tr>
     <td>&nbsp;</td>
     </tr>
     <tr>
       <td>
          <%
             //-----------------------
             //--- Date Of Report ----
             //-----------------------
           if ( reportsBean.getDateOfReport() != null )
              {
                txtDateOfReport = FormattingHelper.formatDate( reportsBean.getDateOfReport() );
              }   
           fieldName = "txtDateOfReport" + loopCounter;
          %>
          <impact:validateDate
           label="Date Of Report"
           type="text"
           size="10"
           value="<%= txtDateOfReport %>"
           name="<%= fieldName %>"
           tabIndex="<%= tabIndex++ %>"
           cssClass="formInput"
           constraint="Date"/>
     </tr>
     <tr>
      <td >
        Child death\serious injury:
      </td>
       <td>
          <%
              //-----------------------------------
              //---  Child death\serious injury ---
              //-----------------------------------
              isChecked = "false";
             
                String indChild =  FormattingHelper.formatString(reportsBean.getIndChildHistoryReport());
              
              fieldName = "cbxChildDeathOrSeriousInjury" + loopCounter;
              %>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(indChild)) || ("N".equals(indChild))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="<%= fieldName %>" 
           cssClass="formInput"/>
       </td>   
    </tr>
    <tr>
       <td>
         <%
            //------------------------
            //--- Date Of Closure ----
            //-------------------------
           if ( reportsBean.getDateOfClosure() != null )
              {
                txtDtOfClosure = FormattingHelper.formatDate( reportsBean.getDateOfClosure() );
              }   
           fieldName = "txtDtOfClosure" + loopCounter;
          %>
          <impact:validateDate
           cssClass="formInput"
           label="Date Of Closure"
           type="text"
           size="10"
           value="<%= txtDtOfClosure %>"
           name="<%= fieldName %>"
           tabIndex="<%= tabIndex++ %>"
           constraint="Date"/>
        </td>
    </tr>
    <tr>
       <td  colspan = "2">
        <impact:validateDisplayOnlyField
         label = "Summary of findings(include date,allegation of who did what to whom, court involvement,services provided and outcome for each
          previous report)"
         name = "Summary"
         conditionallyRequired = "true"/>
        </td>
     </tr>
    
     <tr>
       <td></td>
     <td>
          <%
            //------------------------
            //--- Summary ----
            //-------------------------
           fieldName = "txtRiskAssmtPriorHistory" + loopCounter;
          %>
          <impact:validateTextArea 
           name="<%= fieldName %>"
           tabIndex="<%= tabIndex++ %>"
           constraint="Comments"
           maxLength="300"
           colspan = "6"
           cols = "100"
           rows = "5"><%=FormattingHelper.formatString( reportsBean.getFindingHistoryReport())%>
           </impact:validateTextArea>  
      </td>  
    </tr>
    <%
    
     //risk history report id 
     String historyReportID = FormattingHelper.formatInt(reportsBean.getRiskHistoryReportId());
     fieldName = "hdnHistoryReportID" + loopCounter;
    %>
 
  <impact:validateInput
    type="hidden"
    name="<%=fieldName%>"
    value="<%=historyReportID%>"/> 
     
   <% fieldName = "hdnDateLastUpdateHistoryReport" + loopCounter;  %> 
      <impact:validateInput type="hidden" name="<%=fieldName%>"  value="<%= DateHelper.toISOStringSafe( reportsBean.getLastUpdateDate()) %>"/> 
    <%
    loopCounter++;
   } // end while ( iter.hasNext() )
  %>  
</table>
 <%/* "Back to Top" anchor & Save Button */%>
      <table border="0" cellpadding="3" cellspacing="0" width="100%">
        <tr>
          <td nowrap><a href="#top">Back to Top</a></td>
          <%
          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            %>
            <td width="80%" align="right">
              <impact:ButtonTag
                  name="addPriorHistory"
                  img="btnAdd"
                  align="right"
                  form="frmRiskAssmt"
                  action="/investigation/RiskAssmt/addPriorHistory"
                  restrictRepost="true"
                  preventDoubleClick="true"
                  tabIndex="<%= tabIndex++ %>"/>
            </td>
            
            <td align="right">
              <impact:ButtonTag
                  name="savePriorHistory"
                  img="btnSave"
                  align="right"
                  form="frmRiskAssmt"
                  action="/investigation/RiskAssmt/saveRiskAssmt"
                  restrictRepost="true"
                  preventDoubleClick="true"
                  tabIndex="<%= tabIndex++ %>"/>
            </td>
          <%
          }
          %>
        </tr>
      </table>
    <br>
<%
// The reports counter should be the number of reports in the
// Collection plus 1 since the Collection is zero-based.
%>
 <impact:validateInput
  type="hidden"
  name="numOfReports"
  value="<%= String.valueOf( loopCounter ) %>"/>
      
 
      
 </impact:ExpandableSectionTag> 


<%
//***************************************
//**** INVESTIGATION ACTIONS*************
//***************************************
%>

<br>
  <impact:ExpandableSectionTag 
    label = "Investigation Actions" 
    name = "Investigation Actions" 
    id=""
    anchor="Investigation Actions"
    isComplete="<%= riskAssmtBean.isInvActionsComplete() %>"
    tabIndex="<%= tabIndex++ %>">
    
    <% String ParentsGuide_Yes = "false";
       String ParentsGuide_No = "false";
       String ParentsGuide_NA = "false";
       String ind_ParentsGuide= riskAssmtBean.getIndParentsGuide();
       if (ind_ParentsGuide != null)
        {
          if (ind_ParentsGuide.equals("N")) {
         ParentsGuide_No = "true";
           } else if (ind_ParentsGuide.equals("Y")){
         ParentsGuide_Yes = "true";
         }else {
         ParentsGuide_NA = "true";
         }
       }

       String ParentNotified_Yes = "false";
       String ParentNotified_No = "false";
       String ParentNotified_NA = "false";
       String ind_ParentNotified= riskAssmtBean.getIndParentsNotified();
       if (ind_ParentNotified != null)
        {
          if (ind_ParentNotified.equals("N")) {
         ParentNotified_No = "true";
           } else if (ind_ParentNotified.equals("Y")){
          ParentNotified_Yes = "true";
         }else {
         ParentNotified_NA= "true";
         }
       }
       String HIPPAPolicyExplained_Yes = "false";
       String HIPPAPolicyExplained_No = "false";
       String ind_HIPPAPolicyExplained= riskAssmtBean.getIndHIPPAPolicyExp();
       if (ind_HIPPAPolicyExplained != null)
        {
          if (ind_HIPPAPolicyExplained.equals("N")) {
         HIPPAPolicyExplained_No = "true";
           } else {
         HIPPAPolicyExplained_Yes = "true";
         }
       }
       String HIPPASigned_Yes = "false";
       String HIPPASigned_No = "false";
       String ind_HIPPASigned= riskAssmtBean.getIndHIPPAPolicySigned();
       if (ind_HIPPASigned != null)
        {
          if (ind_HIPPASigned.equals("N")) {
         HIPPASigned_No = "true";
           } else {
         HIPPASigned_Yes = "true";
        }
       }


      if( riskAssmtBean.getDateParentsGuide()!=null)
       {
         txtDtParentsGuide = FormattingHelper.formatDate(riskAssmtBean.getDateParentsGuide());
       }
      if(riskAssmtBean.getDateParentsNotified()!=null)
      {
        txtDtParentNotified = FormattingHelper.formatDate(riskAssmtBean.getDateParentsNotified());
      }
      if( riskAssmtBean.getDateHIPPASignedAndAck()!=null)
      {
        txtDtHIPPASignedAndAck = FormattingHelper.formatDate(riskAssmtBean.getDateHIPPASignedAndAck());
      }
      if(riskAssmtBean.getCommentsHIPPA()!=null)
        { 
         commentsHIPPA = FormattingHelper.formatString(riskAssmtBean.getCommentsHIPPA());
        }  

       %>
   <table border="0" cellpadding="3" cellspacing="0" width = "100%" class="subDetail">
    <tr>
      <td >
        Parents Guide has been given to parents
      </td>
      <td>
      <impact:validateInput type="radio" label="Yes" id="ParentsGuide_Yes" name="rbParentsGuide" value="Y" cssClass="formInput" checked="<%= ParentsGuide_Yes %>" tabIndex="<%= tabIndex++ %>" />
      <impact:validateInput type="radio" label="No"  id="ParentsGuide_No" name="rbParentsGuide" value="N" cssClass="formInput" checked="<%= ParentsGuide_No %>" tabIndex="<%= tabIndex++ %>" /> 
      <impact:validateInput type="radio" label="N/A"  id="ParentsGuide_NA" name="rbParentsGuide" value="X" cssClass="formInput" checked="<%= ParentsGuide_NA %>" tabIndex="<%= tabIndex++ %>" />
      </td>
       
    </tr>
    <tr>
       <td>
          <impact:validateDate
           label="Date copy of Parents Guide was given to the parents"
           type="text"
           size="10"
           value="<%= txtDtParentsGuide %>"
           name="txtDtParentsGuide"
           tabIndex="<%= tabIndex++ %>"
           cssClass="formInput"
           conditionallyRequired = "true"          
           constraint="Date"/>
        </td>
     </tr>
     <tr>
      <td >
        Parent was notified of interview or examination of a child immediately after contact with child
      </td>
      <td>
      <impact:validateInput type="radio" label="Yes" id="ParentNotified_Yes" name="rbParentNotified" value="Y" cssClass="formInput" checked="<%= ParentNotified_Yes %>" tabIndex="<%= tabIndex++ %>" />
      <impact:validateInput type="radio" label="No"  id="ParentNotified_No"  name="rbParentNotified" value="N" cssClass="formInput" checked="<%= ParentNotified_No %>" tabIndex="<%= tabIndex++ %>" /> 
      <impact:validateInput type="radio" label="N/A" id="ParentNotified_NA" name="rbParentNotified" value="X" cssClass="formInput" checked="<%= ParentNotified_NA %>" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
       <td>
          <impact:validateDate
           label="Date parent was notified of interview or examination of a child immediately after contact with child"
           type="text"
           size="10"
           value="<%= txtDtParentNotified %>"
           name="txtDtParentNotified"
           tabIndex="<%= tabIndex++ %>"
           cssClass="formInput"
           conditionallyRequired = "true"          
           constraint="Date"/>
        </td>
     </tr>
      <tr>
      <td >
        HIPPA was explained at initial contact with the primary caretaker
      </td>
      <td>
      <impact:validateInput type="radio" label="Yes" id="HIPPAPolicyExplained_Yes" name="rbHIPPAPolicyExplained" value="Y" cssClass="formInput" checked="<%= HIPPAPolicyExplained_Yes %>" tabIndex="<%= tabIndex++ %>" />
      <impact:validateInput type="radio" label="No"  id="HIPPAPolicyExplained_No"  name="rbHIPPAPolicyExplained" value="N" cssClass="formInput" checked="<%= HIPPAPolicyExplained_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td>
      </tr>
    <tr>
      <td >
         Primary caretaker signed HIPPA agreement
      </td>
      <td>
      <impact:validateInput type="radio" label="Yes" id="HIPPASigned_Yes" name="rbHIPPASigned" value="Y" cssClass="formInput" checked="<%= HIPPASigned_Yes %>" tabIndex="<%= tabIndex++ %>" />
      <impact:validateInput type="radio" label="No"  id="HIPPASigned_No"  name="rbHIPPASigned" value="N" cssClass="formInput" checked="<%= HIPPASigned_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td>
       
    </tr>
     <tr>
       <td>
          <impact:validateDate
           label="Date HIPPA was acknowledge and signed"
           type="text"
           size="10"
           value="<%= txtDtHIPPASignedAndAck %>"
           name="txtDtHIPPASignedAndAck"
           tabIndex="<%= tabIndex++ %>"
           cssClass="formInput"
           conditionallyRequired = "true"          
           constraint="Date"/>
        </td>
     </tr>
    <tr>
    
      <td  colspan = "2">
          Comments regarding HIPPA policy explanation with primary caretaker:
      </td>
     </tr>
     <tr>
     <td>
          <impact:validateTextArea 
           name="txtCommentsOnHIPPA"
           tabIndex="<%= tabIndex++ %>"
           constraint="Comments"
           maxLength="300"
           colspan = "2"
           cols = "100"
           rows = "5"><%=commentsHIPPA%>
         </impact:validateTextArea>  
      </td>  
    </tr> 
   </table> 
   <%/* "Back to Top" anchor & Save Button */%>
      <table border="0" cellpadding="3" cellspacing="0" width="100%">
        <tr>
          <td><a href="#top">Back to Top</a></td>
          <%
          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            %>
            <td>
              <impact:ButtonTag
                  name="saveInvActions"
                  img="btnSave"
                  align="right"
                  form="frmRiskAssmt"
                  action="/investigation/RiskAssmt/saveRiskAssmt"
                  restrictRepost="true"
                  preventDoubleClick="true"
                  tabIndex="<%= tabIndex++ %>"/>
            </td>
         <%
          }
          %>
        </tr>
      </table>
      
      <impact:validateInput type="hidden" name="hdnDateLastUpdateInvActions"  value="<%= DateHelper.toISOStringSafe( riskAssmtBean.getDateLastUpdateInvActions()) %>"/> 
  </impact:ExpandableSectionTag> 
  <br>
  
  <%
//***************************************
//**** ASSESSMENT OF FAMILY STRENGTHS****
//***************************************
%>
  
  <impact:ExpandableSectionTag 
    label = "Assessment of Family Strengths" 
    name = "Assessment of Family Strengths" 
    id=""
    anchor="Assessment of Family Strengths"
    isComplete="<%= riskAssmtBean.isAssessmentOfFmlyStrComplete() %>"
    tabIndex="<%= tabIndex++ %>">
    <%
    
       String ChildVulnerability_Yes = "false";
       String ChildVulnerability_No = "true";
       String ind_ChildVulnerability= riskAssmtBean.getIndchildVulnerability();
       if (ind_ChildVulnerability != null)
        {
          if (ind_ChildVulnerability.equals("N")) {
         ChildVulnerability_No = "true";
           } else {
         ChildVulnerability_Yes = "true";
         ChildVulnerability_No = "false";
         }
       }

       String CaregiverCapability_Yes = "false";
       String CaregiverCapability_No = "true";
       String ind_CaregiverCapability = riskAssmtBean.getIndCaregiverCapability();
       if (ind_CaregiverCapability != null)
        {
          if (ind_CaregiverCapability.equals("N")) {
         CaregiverCapability_No = "true";
           } else {
         CaregiverCapability_Yes = "true";
         CaregiverCapability_No = "false";
         }
       }

       String QualityOfCare_Yes = "false";
       String QualityOfCare_No = "true";
       String ind_QualityOfCare = riskAssmtBean.getIndQualityOfCare();
       if (ind_QualityOfCare != null)
        {
          if (ind_QualityOfCare.equals("N")) {
         QualityOfCare_No = "true";
           } else {
         QualityOfCare_Yes = "true";
         QualityOfCare_No = "false";
         }
       }
       String MaltreatmentPattern_Yes = "false";
       String MaltreatmentPattern_No= "true";
       String ind_MaltreatmentPattern = riskAssmtBean.getIndMaltreatmentPattern();
       if (ind_MaltreatmentPattern != null)
        {
          if (ind_MaltreatmentPattern.equals("N")) {
         MaltreatmentPattern_No = "true";
           } else {
         MaltreatmentPattern_Yes = "true";
         MaltreatmentPattern_No = "false";
         }
       }

       String HomeEnv_Yes = "false";
       String HomeEnv_No= "true";
       String ind_HomeEnv = riskAssmtBean.getIndHomeEnv();
       if (ind_HomeEnv != null)
        {
          if (ind_HomeEnv.equals("N")) {
         HomeEnv_No = "true";
           } else {
         HomeEnv_Yes = "true";
         HomeEnv_No = "false";
         }
       }

       String SocialEnv_Yes = "false";
       String SocialEnv_No= "true";
       String ind_SocialEnv = riskAssmtBean.getIndSocialEnv();
       if (ind_SocialEnv != null)
        {
          if (ind_SocialEnv.equals("N")) {
         SocialEnv_No = "true";
           } else {
         SocialEnv_Yes = "true";
         SocialEnv_No = "false";
         }
       }
       String ResponseToIntervention_yes = "false";
       String ResponseToIntervention_No= "true";
       String ind_ResponseToIntervention = riskAssmtBean.getIndResponseToIntervention();
       if (ind_ResponseToIntervention != null)
        {
          if (ind_ResponseToIntervention.equals("N")) {
         ResponseToIntervention_No = "true";
           } else {
         ResponseToIntervention_yes = "true";
         ResponseToIntervention_No = "false";
         }
       }

         if ( request.getParameter("cbxAttitude") != null )
           {
              Attitude = "true";
           }
          else
          {
            Attitude = "false";
          }
          
          if(riskAssmtBean.getCommentsAssessmentOfFmlyStr()!=null)
          { 
           justicationOfFindings = FormattingHelper.formatString(riskAssmtBean.getCommentsAssessmentOfFmlyStr());
          }  
    
               
         String ChildFragilityProtect = FormattingHelper.formatString(riskAssmtBean.getIndChildFragilityProtection());
         String ChildBehaviour = FormattingHelper.formatString(riskAssmtBean.getIndChildBehaviour());
         String KnowledgeSkills =  FormattingHelper.formatString(riskAssmtBean.getIndKnowledgeSkills());
         String Control = FormattingHelper.formatString(riskAssmtBean.getIndControl());
         String Functioning = FormattingHelper.formatString(riskAssmtBean.getIndFunctioning());
         String EmotionalCare =  FormattingHelper.formatString(riskAssmtBean.getIndEmotionalCare());
         String PhysicalCare =  FormattingHelper.formatString(riskAssmtBean.getIndPhysicalCare());     
         String Trend = FormattingHelper.formatString(riskAssmtBean.getIndTrend());  
         String CurrentSeverity =  FormattingHelper.formatString(riskAssmtBean.getIndCurrentSeverity());   
         String Chronicity =  FormattingHelper.formatString(riskAssmtBean.getIndChronicity());   
         String DangerousExposure =  FormattingHelper.formatString(riskAssmtBean.getIndDangerousExposure());
         String Stressors=  FormattingHelper.formatString(riskAssmtBean.getIndStressors());
         String SocialClimate =  FormattingHelper.formatString(riskAssmtBean.getIndSocialClimate());
         String SocialViolence =  FormattingHelper.formatString(riskAssmtBean.getIndSocialViolence());
         String Deception = FormattingHelper.formatString(riskAssmtBean.getIndDeception());
         Attitude = FormattingHelper.formatString(riskAssmtBean.getIndAttitude());
         rbChildVulnerability = FormattingHelper.formatString(riskAssmtBean.getIndchildVulnerability());
         rbCaregiverCapability = FormattingHelper.formatString(riskAssmtBean.getIndCaregiverCapability());
         rbQualityOfCare = FormattingHelper.formatString(riskAssmtBean.getIndQualityOfCare());
         rbMaltreatmentPattern = FormattingHelper.formatString(riskAssmtBean.getIndMaltreatmentPattern());
         rbHomeEnv = FormattingHelper.formatString(riskAssmtBean.getIndHomeEnv());
         rbSocialEnv = FormattingHelper.formatString(riskAssmtBean.getIndSocialEnv());
         rbResponseToIntervention = FormattingHelper.formatString(riskAssmtBean.getIndResponseToIntervention());
         
        
         
    %>
    
    <table border="0" cellpadding="3" cellspacing="0" width = "100%" class="subDetail">
    <tr class="even">
      <td >
        Child Vulnerability
      </td>
     
      <td>
      <impact:validateInput type="radio" label="Yes" id="ChildVulnerability_Yes" name="rbChildVulnerability" value="Y" cssClass="formInput" checked="<%= ChildVulnerability_Yes %>" tabIndex="<%= tabIndex++ %>" />
      <impact:validateInput type="radio" label="No"  id="ChildVulnerability_No"  name="rbChildVulnerability" value="N" cssClass="formInput" checked="<%= ChildVulnerability_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td>
    </tr> 
    <tr>
      <td >
        Child Fragility/Protection
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(ChildFragilityProtect)) || ("N".equals(ChildFragilityProtect))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxChildFragilityProtect" 
           cssClass="formInput"/>
       </td>
    </tr> 
    <tr>
      <td >
        Child Behavior
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(ChildBehaviour)) || ("N".equals(ChildBehaviour))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxChildBehaviour" 
           cssClass="formInput"/>
       </td>   
    </tr>
    <tr class="even">
      <td >
        Caregiver Capability
      </td>
       <td>
        <impact:validateInput type="radio" label="Yes" id="CaregiverCapability_Yes" name="rbCaregiverCapability" value="Y" cssClass="formInput" checked="<%= CaregiverCapability_Yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="CaregiverCapability_No"  name="rbCaregiverCapability" value="N" cssClass="formInput" checked="<%= CaregiverCapability_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
    </tr> 
    <tr>
      <td >
        Knowledge Skills
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(KnowledgeSkills)) || ("N".equals(KnowledgeSkills))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="cbxKnowledgeSkills" 
           name="cbxKnowledgeSkills" 
           cssClass="formInput"/>
       </td>   
    </tr> 
     <tr>
      <td >
        Control
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(Control)) || ("N".equals(Control))) ? "false" : "true" %>"  
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxControl" 
           cssClass="formInput"/>
       </td>   
    </tr>
      <tr>
      <td >
        Functioning
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(Functioning)) || ("N".equals(Functioning))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxFunctioning" 
           cssClass="formInput"/>
       </td>   
    </tr>
      <tr class="even">
      <td >
        Quality of Care
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="QualityOfCare_Yes" name="rbQualityOfCare" value="Y" cssClass="formInput" checked="<%= QualityOfCare_Yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="QualityOfCare_No"  name="rbQualityOfCare" value="N" cssClass="formInput" checked="<%= QualityOfCare_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
    </tr> 
      <tr>
      <td >
        Emotional Care
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(EmotionalCare)) || ("N".equals(EmotionalCare))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxEmotionalCare" 
           cssClass="formInput"/>
       </td>   
    </tr>
    <tr>
      <td >
       Physical Care
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(PhysicalCare)) || ("N".equals(PhysicalCare))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxPhysicalCare" 
           cssClass="formInput"/>
       </td>   
    </tr>
    <tr class="even">
      <td >
        Maltreatment Pattern
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="MaltreatmentPattern_Yes" name="rbMaltreatmentPattern" value="Y" cssClass="formInput" checked="<%= MaltreatmentPattern_Yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="MaltreatmentPattern_No"  name="rbMaltreatmentPattern" value="N" cssClass="formInput" checked="<%= MaltreatmentPattern_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
     </tr>
    <tr>
      <td >
       Current Severity
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(CurrentSeverity)) || ("N".equals(CurrentSeverity))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxCurrentSeverity" 
           cssClass="formInput"/>
       </td>   
    </tr>
    <tr>
      <td >
       Chronicity
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(Chronicity)) || ("N".equals(Chronicity))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxChronicity" 
           cssClass="formInput"/>
       </td>   
    </tr>
    <tr>
      <td >
       Trend
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(Trend)) || ("N".equals(Trend))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxTrend" 
           cssClass="formInput"/>
       </td>   
    </tr>
     <tr class="even">
      <td >
        Home Environment
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="HomeEnv_Yes" name="rbHomeEnv" value="Y" cssClass="formInput" checked="<%= HomeEnv_Yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="HomeEnv_No"  name="rbHomeEnv" value="N" cssClass="formInput" checked="<%= HomeEnv_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
       
    </tr>
    <tr>
      <td >
       Stressors
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(Stressors)) || ("N".equals(Stressors))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxStressors" 
           cssClass="formInput"/>
       </td>   
    </tr> 
    <tr>
      <td >
       Dangerous Exposure
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(DangerousExposure)) || ("N".equals(DangerousExposure))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxDangerousExposure" 
           cssClass="formInput"/>
       </td>   
    </tr> 
    <tr class="even">
      <td >
       Social Environment
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="SocialEnv_Yes" name="rbSocialEnv" value="Y" cssClass="formInput" checked="<%= SocialEnv_Yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="SocialEnv_No"  name="rbSocialEnv" value="N" cssClass="formInput" checked="<%= SocialEnv_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
            
    </tr>
    <tr>
      <td >
       Social Climate
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(SocialClimate)) || ("N".equals(SocialClimate))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxSocialClimate" 
           cssClass="formInput"/>
       </td>   
    </tr> 
    <tr>
      <td >
       Social Violence
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(SocialViolence)) || ("N".equals(SocialViolence))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxSocialViolence" 
           cssClass="formInput"/>
       </td>   
    </tr> 
     <tr class="even">
      <td >
       Response to Intervention
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="ResponseToIntervention_yes" name="rbResponseToIntervention" value="Y" cssClass="formInput" checked="<%= ResponseToIntervention_yes %>" tabIndex="<%= tabIndex++ %>" />
        <impact:validateInput type="radio" label="No"  id="ResponseToIntervention_No"  name="rbResponseToIntervention" value="N" cssClass="formInput" checked="<%= ResponseToIntervention_No %>" tabIndex="<%= tabIndex++ %>" /> 
      </td> 
    
    </tr>
     <tr>
      <td >
       Attitude
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%=Attitude %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="cbxAttitude" 
           name="cbxAttitude" 
           cssClass="formInput"/>
       </td>   
    </tr> 
     <tr>
      <td >
       Deception
      </td>
       <td>
          <impact:validateInput type="checkbox" 
           cssClass="formInput"
           checked="<%= (("".equals(Deception)) || ("N".equals(Deception))) ? "false" : "true" %>" 
           tabIndex="<%= tabIndex++ %>" 
           value="Y" 
           name="cbxDeception" 
           cssClass="formInput"/>
       </td>   
    </tr> 
  
  <%--  <tr class="even">
        <td  colspan = "2">
        <impact:validateDisplayOnlyField
         label = "Summarize and provide justification for each area checked"
         name = "Summary"
         required = "true"/>
             
      </td>
     </tr>--%>
     <tr>
     <td> <span class="formRequiredText">*</span> Summarize and provide justification for each area checked </td></tr>
     <tr>
     <td>
          <impact:validateTextArea 
           name="txtSummarizeJustificationOfFindings"
           tabIndex="<%= tabIndex++ %>"
           constraint="Comments"
           maxLength="300"
           colspan = "2"
           cols = "100"
           rows = "5"><%=justicationOfFindings%>
          </impact:validateTextArea>  
      </td> 
    </tr> 
   </table> 
   <%/* "Back to Top" anchor & Save Button */%>
      <table border="0" cellpadding="3" cellspacing="0" width="100%">
        <tr>
          <td><a href="#top">Back to Top</a></td>
          <%
          // Do not display the Save button if the Page Mode is VIEW
          if ( !pageMode.equals( PageModeConstants.VIEW ) )
          {
            fieldName = "btnSave" + tabIndex;
            %>
            <td>
              <impact:ButtonTag
                  name="saveAssmtFmlyStr"
                  img="btnSave"
                  align="right"
                  form="frmRiskAssmt"
                  action="/investigation/RiskAssmt/saveRiskAssmt"
                  restrictRepost="true"
                  preventDoubleClick="true"
                  tabIndex="<%= tabIndex++ %>"/>
            </td>
         <%
          }
          %>
        </tr> 
     <impact:validateInput type="hidden" name="hdnDateLastUpdateFmlyStr"  value="<%= DateHelper.toISOStringSafe( riskAssmtBean.getDateLastUpdateFmlyStr()) %>"/>    
  </table>  
 </impact:ExpandableSectionTag> 

<%
//*****************
//**** BUTTONS ****
//*****************
// Display the Complete and Save buttons unless the page mode is VIEW. If page
// mode is VIEW, display a <br> to put a empty line above the Narrative button.
if ( !pageMode.equals( PageModeConstants.VIEW ) )
{%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr><td colspan="3"><br><hr></td></tr>
    <tr>
      <td width="80%">&nbsp;</td>
      <td align="right">
        <impact:ButtonTag
            name="btnCompletionCheck"
            img="btnCompleteQ"
            align="right"
            form="frmRiskAssmt"
            action="/investigation/RiskAssmt/checkRiskAssmt"
            restrictRepost="true"
            preventDoubleClick="true"
            tabIndex="<%= tabIndex++ %>"/>
      </td>
      <td align="right">
        <impact:ButtonTag
            name="btnSave"
            img="btnSave"
            align="right"
            form="frmRiskAssmt"
            action="/investigation/RiskAssmt/saveRiskAssmt"
            restrictRepost="true"
            preventDoubleClick="true"
            tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
else
{%>
  <br>
<%
}
%>




<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>

<%-- This separate form is used to post area concern text to RiskAreaConcernTxt.jsp for display --%>
<form name="AreaConcernForm" method="post" action="/investigation/RiskAssmt/displayAreaConcern">
  <input type="hidden" name="AreaTxtName" value="" />
</form>

<% //************************
  //**** FORM ENDS HERE ****
  //************************ %>
<impact:ifServerImpact>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Form and Report Launch</th>
  </tr>
  <tr>
    <td>
      <impact:documentList pageMode="2" tabIndex="<%= tabIndex++ %>">
        <impact:document displayName="Risk Assessment Form"
                         protectDocument="true"
                         checkForNewMode="false"
                         docType="FAS02O00"
                         docExists="false">
          <impact:documentParameter name="pCase"  value="<%=String.valueOf( riskAssmtBean.getCaseId() ) %>"/>
          <impact:documentParameter name="pStage" value="<%=String.valueOf( riskAssmtBean.getStageId() )%>"/>
          <impact:documentParameter name="pEvent" value="<%=String.valueOf( riskAssmtBean.getEventId() )%>"/>
        </impact:document>
      </impact:documentList>
      </td>
  </tr>
</table>

<br>
<% /* end Forms and Reports */ %>
</impact:ifServerImpact>

  

