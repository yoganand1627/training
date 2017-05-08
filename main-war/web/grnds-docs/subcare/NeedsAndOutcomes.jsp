<%--
JSP Name:     Needs And Outcomes
Created by:   Nandita Hegde
Date Created: 12/06/06

Description:
This JSP serves as a source of clean code that can be used to build other JSPs.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>


<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.NeedsAndOutcomesRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.NeedsAndOutcomesList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesCustomValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>

<%@ page import="java.util.ArrayList"%>


<%
  

//*********************
//*** SET PAGE MODE ***
//*********************

       String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
      pageMode = PageMode.getPageMode(request);
      }

//*******************************
//*** DECLARE LOCAL VARIABLES ***
//*******************************
      
  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  String assessorName =  "";
  String assessorTitle = "";
  String referralDate = "";
  String assessmentCompletionDate = "";
  String cCFARecUnused = "";
  String cCFAEduAssmt = "";
  String generalRec = "";
  String placementRec = "";
  String isAdd = "";
  String tsLastUpdate = "";
  String saTsLastUpdate = "";
  String agencyName = "";
  String cCFAAgency = "";
  String cCFAEduAssmtDate = "";
  String txtBelowSchoolAge = "";
  String txtUnderFour = "";
  int size = 0;
  int uIdEvent = 0;
  int uIdStage = 0;
  int loopCount = 0;
  String personNm = null;

  List<NeedsAndOutcomesList> needsOutcomesDetail = new ArrayList();
  int arrayIndex = ContextHelper.getIntSafe(request, "needsoutcomesIndex");
  
  
 //***********************************
 //*** RETRIEVE HIDDEN STATE FIELD ***
 //***********************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
              
              
                                                                       
//**************************
//*** RETRIEVE PAGE DATA ***
//**************************                                                                      

    String includingFormName = (String) request.getAttribute(IncludeTag.INCLUDING_FORM_NAME_KEY);
   NeedsAndOutcomesRetrieveSO needsOutcomes = (NeedsAndOutcomesRetrieveSO) state.getAttribute("NeedsAndOutcomesRetrieveSO", request);
   if(needsOutcomes.getNaoBeanList() != null)
   {
     needsOutcomesDetail =needsOutcomes.getNaoBeanList();
     size = needsOutcomesDetail.size();
   }
  
   
   //check for approval status

 boolean approvalStatus = true;
      // Get the Needs and outcomes bean from the request
      if (state.getAttribute("NeedsAndOutcomesRetrieveSO", request) != null) {
        needsOutcomes = (NeedsAndOutcomesRetrieveSO) state.getAttribute("NeedsAndOutcomesRetrieveSO", request);
        if (needsOutcomes.getROWCCMN45DO() != null) {
          tsLastUpdate = DateHelper.toISOString(needsOutcomes.getROWCCMN45DO().getTsLastUpdate());
          saTsLastUpdate = DateHelper.toISOString(needsOutcomes.getDtLastUpdate());
        }
        ROWCCMN45DO eventDetails = needsOutcomes.getROWCCMN45DO();
        if ((eventDetails == null)
            || pageMode.equals(PageModeConstants.NEW)
            || (!NeedsAndOutcomesConversation.EVENT_STATUS_PEND.equals(eventDetails.getSzCdEventStatus()) && !NeedsAndOutcomesConversation.EVENT_STATUS_APPROVED
                                                                                                                                                                .equals(eventDetails
                                                                                                                                                                .getSzCdEventStatus()))) {
          approvalStatus = false;
        }
      }
   
    
    if(needsOutcomes!=null)
     {
        assessorName = needsOutcomes.getTxtAssessorName();
        assessorTitle = needsOutcomes.getTxtAssessorTitle();
        uIdEvent = needsOutcomes.getUlIdEvent();
        uIdStage = needsOutcomes.getUlIdStage();
        referralDate = FormattingHelper.formatDate(needsOutcomes.getDtReferral());
        assessmentCompletionDate = FormattingHelper.formatDate(needsOutcomes.getDtAssessmentCompletion());
        cCFAEduAssmtDate = FormattingHelper.formatDate(needsOutcomes.getDtCCFAEduAssmt());
        if(needsOutcomes.getTxtCCFARecNotUsed()!=null)
        {
          cCFARecUnused =needsOutcomes.getTxtCCFARecNotUsed();
        }
        if(needsOutcomes.getTxtGeneralRec()!=null)  
        {
          generalRec = needsOutcomes.getTxtGeneralRec() ;
        }
        if( needsOutcomes.getTxtPlacementRec()!=null)
        {
         placementRec = needsOutcomes.getTxtPlacementRec();
        } 
        if( needsOutcomes.getNMResource()!=null)
        {
          agencyName =  needsOutcomes.getNMResource();
        }
        if( needsOutcomes.getTxtCCFAEduAssmt()!=null)
        {
          cCFAEduAssmt = needsOutcomes.getTxtCCFAEduAssmt();
        } 
        if(needsOutcomes.getIndCCFAAgency()!=null)
         {  
          cCFAAgency = needsOutcomes.getIndCCFAAgency();
        }  
        
        if(needsOutcomes.getTxtUnder4NoDevSrcCmnt()!=null)
        {  
          txtUnderFour = needsOutcomes.getTxtUnder4NoDevSrcCmnt();
        }  
        
        if(needsOutcomes.getTxtUndSchoolageNoDevAss()!=null)
        {  
          txtBelowSchoolAge = needsOutcomes.getTxtUndSchoolageNoDevAss();
        }  
     }
    personNm = GlobalData.getSzNmPersonFull(request);
    
     if(needsOutcomes.getUlIdEvent()==0)
      {
        uIdEvent = GlobalData.getUlIdEvent(request);
        uIdStage = GlobalData.getUlIdStage(request);
     }
     
   //Get Data for CCFA Eucational Assessment Ind  
   String cCFAEdu_Yes = ArchitectureConstants.FALSE;
   String cCFAEdu_No = ArchitectureConstants.FALSE; 
  
   String ind_CCFAEdu= needsOutcomes.getIndCCFAEduAssmt();
   if (ind_CCFAEdu != null)
     {
        if (ind_CCFAEdu.equals(ArchitectureConstants.N)) {
           cCFAEdu_No = ArchitectureConstants.TRUE;
            } else {
           cCFAEdu_Yes = ArchitectureConstants.TRUE;
          }
      }  
  String personIdForPullback = StringUtils.defaultString(needsOutcomes.getPersonIdForPullback());
  String resourceIdForPullback = StringUtils.defaultString(needsOutcomes.getResourceIdForPullback());  
  String resourceName = StringUtils.defaultString(needsOutcomes.getNMResource());  

%>


<%//******************
  //*** JAVASCRIPT ***
  //******************
 %>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">

// This function is called before the page unloads. It creates the
// "Are you sure you want to navigate away from this page..." pop-up
// message.
window.onbeforeunload = function ()
{
  IsDirty();
}

 //Message for when a user wants to delete a needs outcomes and gives the user an alert, the if the
  //radio button was not selected by the user.
  function Delete()
  {
    var cont;
    if( checkForSelection('document.frmNeedsAndOutcomes.rbNeedsIndex'))
    {
         cont = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>');
    }
    else
    {
         alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>');
         cont = false;
    }
    return cont;
  }

  
 //Allows for the needs outcomes to be selected out of the radio button
  function checkForSelection( objName )
  {
    var buttonChecked = false;
    var obj = eval(objName);

    if (obj != null)
    {
      if (obj.length == null)
      {
        if (obj.checked != false)
          buttonChecked = true;
      }
      else
      {
        for (var i = 0; i < obj.length; ++i)
        {
          buttonChecked = buttonChecked || obj[i].checked;
        }
      }
    }

  return (buttonChecked);
} 

function submitNeedsOutcomeDetail( idNeedsOutcome, idEvent, idStage, personNm ){
  document.frmNeedsAndOutcomes.hdnIdNeedsOutcomes.value = idNeedsOutcome;
  document.frmNeedsAndOutcomes.hdnUIdEvent.value = idEvent;
  document.frmNeedsAndOutcomes.hdnUIdStage.value = idStage;
  document.frmNeedsAndOutcomes.hdnPersonNm.value = personNm;
  submitValidateForm( "frmNeedsAndOutcomes", "/subcare/NeedsAndOutcomes/displayNeedsAndOutcomesDetail" );
  }
  
</script>




<%    //**************************
      //**** FORM STARTS HERE ****
      //**************************

 %>
<impact:validateErrors />
<impact:validateForm name="frmNeedsAndOutcomes" method="post" action="/subcare/NeedsAndOutcomes/displayNeedsAndOutcomes" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.NeedsAndOutcomesCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

  <% /*  Always include this hidden field in your form */ %>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
  <impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= tsLastUpdate %>" />
  <input type="hidden" name="hdnResourceIdForPullback" value="<%=resourceIdForPullback%>" />
  <input type="hidden" name="hdnPersonIdForPullback" value="<%=personIdForPullback%>" />
  <input type="hidden" name="hdnResourceName" value="<%=resourceName%>" />
  <input type="hidden" name="hdnPageName" value="NeedsOutcomes" />
  <input type="hidden" name="hdnIdNeedsOutcomes">
  <input type="hidden" name="hdnUIdEvent" value="<%=uIdEvent%>">
  <input type="hidden" name="hdnUIdStage" value="<%=uIdStage%>">
  <input type="hidden" name="hdnPersonNm" value="<%=personNm%>">
  <input type="hidden" name="hdnSize" value="<%=size%>">


  <% // Begin Detail
%>

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <%if (approvalStatus) {

        %>
      <td class="alignLeft" width="85%">
        <impact:ButtonTag name="btnApprovalStatus" tabIndex="<%= tabIndex++ %>" img="btnApprovalStatus" editableMode="<%=EditableMode.ALL%>" form="frmNeedsAndOutcomes" action="/workload/ApprovalStatus/displayStatus" />
      </td>
      <%} else { %>
      <td class="alignLeft" width="85%">
        &nbsp;
      </td>
      <% } %>
    </tr>
  </table>

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborderList">
    <tr>
      <th colspan="8">
        <span class="formRequiredText">*</span> Needs And Outcomes List
      </th>
    </tr>
    <tr></tr>
    <tr>
      <th class="thList"></th>
      <th class="thList">
        Identified Need
      </th>
      <th class="thList">
        CCFA Need
      </th>
      <th class="thList">
        Service Recommended
      </th>
      <th class="thList">
        Service Provided
      </th>
      <th class="thList">
        Need Met
      </th>
    </tr>

    <%
          if (!FormValidation.pageHasErrorMessages(request)) {
          if (size == 0) {
         %>
    <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
      <td colspan="10">
        <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
      </td>
    </tr>
    <%} else {
          for (Iterator<NeedsAndOutcomesList> it = needsOutcomesDetail.iterator(); it.hasNext();) {
          NeedsAndOutcomesList needsRow = (NeedsAndOutcomesList) it.next();
          String idNeedsOutcomes = String.valueOf( needsRow.getIdNeedsAndOutcomes());
         
       %>
    <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
      <td>
        <impact:validateInput type="radio" name="rbNeedsIndex" value="<%= idNeedsOutcomes%>" tabIndex="<%= tabIndex++%>" />
      </td>
      <td>
        <%=FormattingHelper.formatString( needsRow.getTxtIdentifiedNeed())%>
      </td>
      <td>
        <%= FormattingHelper.formatString( needsRow.getIndCCFANeed())%>
      </td>
      <td align="left">
        <%
                  String serviceRecommended = "";
                  serviceRecommended = FormattingHelper.formatString(needsRow.getTxtServiceRecommended());
                  String listItemId = "needsItem_" + loopCount;
                 %>
        <a href="javascript:submitNeedsOutcomeDetail('<%= idNeedsOutcomes %>','<%=uIdEvent%>','<%=uIdStage%>','<%=personNm%>')"><%=serviceRecommended%></a>
      </td>
      <td>
        <%= FormattingHelper.formatString(needsRow.getIndServiceProvided())%>
      </td>
      <td>
        <%= FormattingHelper.formatString(needsRow.getIndNeedMet())%>
      </td>

    </tr>
    <%loopCount++;
       }
           } //end big else
      } // end !FormValidation.pageHasErrorMessages

      %>
  </table>


  <% //*****************
      //**** BUTTONS ****
      //*****************

  if (!pageMode.equals(PageModeConstants.VIEW)) {%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td align="left">
        <impact:ButtonTag form="frmNeedsAndOutcomes" img="btnDelete" name="delete" action="/subcare/NeedsAndOutcomes/deleteNeedsAndOutcomes" function="return Delete()" tabIndex="<%=tabIndex++%>" />
      </td>
      <td width="80%">
        &nbsp;
      </td>
      <td>
        <impact:ButtonTag form="frmNeedsAndOutcomes" img="btnAdd" name="needs" action="/subcare/NeedsAndOutcomes/addNeedsAndOutcomesDetail" preventDoubleClick="true" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
  </table>
  <%}%>
  <br/>

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="8" align="left">
        CCFA Agency
      </th>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateDisplayOnlyField name="txtAgencyNm" label="Agency Name" value="<%= agencyName %>" cssClass="formInput" />

      </td>
      <td align="right" colspan="2">
        <impact:ButtonTag form="frmNeedsAndOutcomes" img="btnSelectResource" name="SelectResource" action="/subcare/NeedsAndOutcomes/retrieveResource" restrictRepost="true" preventDoubleClick="true" tabIndex="<%=tabIndex++%>" />
      </td>
      <td>
        &nbsp;
      </td>
      <td>
        <impact:validateInput type="checkbox" cssClass="formInput" label="CCFA Agency" checked="<%= (("".equals(cCFAAgency)) || (ArchitectureConstants.N.equals(cCFAAgency))) ? "false" : "true" %>" tabIndex="<%= tabIndex++ %>" value="Y" name="chkCCFAAgency" cssClass="formInput" />
      </td>

    </tr>
    <tr>
      <td colspan="2">
        <impact:validateInput type="text" name="txtAssessorName" label="Assessor Name" cssClass="formInput" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" value="<%= assessorName %>" />
      </td>
      <td colspan="2">
        <impact:validateInput type="text" name="txtAssessorTitle" label="Assessor Title" cssClass="formInput" size="30" maxLength="30" tabIndex="<%= tabIndex++ %>" value="<%= assessorTitle %>" />
      </td>
    </tr>
  </table>
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="8" align="left">
        CCFA Assessment
      </th>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateDate label="Referral Date" type="text" size="10" value="<%= referralDate %>" name="dtReferral" tabIndex="<%= tabIndex++ %>" constraint="Date" />
      </td>
      <!--     <td colspan="1">Assessment Completion Date</td> -->
      <td colspan="1">
        <impact:validateDate type="text" label="Assessment Completion Date" size="10" value="<%= assessmentCompletionDate %>" name="dtAssessmentCompletion" tabIndex="<%= tabIndex++ %>" constraint="Date" />
      </td>
    </tr>
    <tr>
      <td>
        General Recommendations:
      </td>
      <td colspan="2">
        <impact:validateTextArea name="txtGeneralRec" tabIndex="<%= tabIndex++ %>" constraint="Paragraph300" maxLength="300" colspan="2" cols="60" rows="5">
          <%=generalRec%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        Placement Recommendations:
      </td>
      <td colspan="2">
        <impact:validateTextArea name="txtPlacementRec" tabIndex="<%= tabIndex++ %>" constraint="Paragraph300" maxLength="300" colspan="2" cols="60" rows="5">
          <%=placementRec%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        CCFA Recommendations that were not used as a step to accomplish the case plan:
      </td>
      <td colspan="2">
        <impact:validateTextArea name="txtCCFARecUnused" tabIndex="<%= tabIndex++ %>" constraint="Paragraph300" maxLength="300" colspan="2" cols="60" rows="5">
          <%=cCFARecUnused%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        Has the CCFA Educational Assessment been performed?
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="cCFAEdu_Yes" name="rbCCFAEdu" value="Y" cssClass="formInput" checked="<%= cCFAEdu_Yes %>" tabIndex="<%= tabIndex++ %>" />
        &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
        <impact:validateInput type="radio" label="No" id="cCFAEdu_No" name="rbCCFAEdu" value="N" cssClass="formInput" checked="<%= cCFAEdu_No %>" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td colspan="1">
        <impact:validateTextArea name="txtCCFAEduAssmt" label="If no,explain" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>" constraint="Paragraph300" maxLength="300" colspan="2" cols="60" rows="5">
          <%=cCFAEduAssmt%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate label="Date of CCFA Educational Assessment" conditionallyRequired="true" type="text" size="10" value="<%= cCFAEduAssmtDate %>" name="dtCCFAEduAssmt" tabIndex="<%= tabIndex++ %>" constraint="Date" />
      </td>
    </tr>
    <tr>
      <td>
        If the child is under 4 years old, and there has not been a Developmental Screening, explain:
      </td>
      <td colspan="2">
        <impact:validateTextArea name="txtUnderFour" tabIndex="<%= tabIndex++ %>" constraint="Paragraph500" maxLength="300" colspan="2" cols="60" rows="5">
          <%=txtUnderFour%>
        </impact:validateTextArea>
      </td>
    </tr>
    <tr>
      <td>
        If the child is below school age and there has not been a Developmental Assessment, explain:
      </td>
      <td colspan="2">
        <impact:validateTextArea name="txtBelowSchoolAge" tabIndex="<%= tabIndex++ %>" constraint="Paragraph500" maxLength="300" colspan="2" cols="60" rows="5">
          <%=txtBelowSchoolAge%>
        </impact:validateTextArea>
      </td>
    </tr>
    

  </table>

  <%//*****************
      //**** BUTTONS ****
      //*****************
     
      // Display the Save and Submit and Save buttons unless the page mode is VIEW.  %>

  <table border="0" cellspacing="0" cellpadding="2" width="100%">
    <tr>
      <td width="70%">
        &nbsp;
      </td>
      <%  if ((!pageMode.equals(PageModeConstants.VIEW)) && (!approvalStatus) && (!pageMode.equals(PageModeConstants.NEW))) {%>
      <td>
        <impact:ButtonTag name="btnSaveSubmit" img="btnSaveAndSubmit" form="frmNeedsAndOutcomes" action="/subcare/NeedsAndOutcomes/saveAndSubmitNeedsAndOutcomes" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
      <%} if (!pageMode.equals(PageModeConstants.VIEW)){ %>
      <td align="right">
        <impact:ButtonTag name="btnSave" img="btnSave" form="frmNeedsAndOutcomes" action="/subcare/NeedsAndOutcomes/saveNeedsAndOutcomes" restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>
  <%}%>

  <br>
</impact:validateForm>


