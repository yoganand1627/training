<%
//*  JSP Name:     Age And Citizenship
//*  Created by:   Michael Ochu
//*  Date Created: 10/05/2002
//*
//*  Description:
//*  This JSP is used to verify age and citizenship information
//*  of a given child.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  6/17/08   charden			  STGAP00008647: wrote if statement to check if ageCitizenshipDB is null and
//**							  if it is null, to create a new ageCitizenshipDB object

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityList" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes"%>
<%
{
  boolean evalConcApprvdCheckButtonHide = false;
  String evalConcApprvdDisabled = "false";

  int tabIndex = 1;

  UserProfile user = UserProfileHelper.getUserProfile(request);

  String pageMode = PageMode.getPageMode(request);
	
  AgeCitizenshipDB ageCitizenshipDB = (AgeCitizenshipDB)
    request.getAttribute("AgeCitizenship");
    
  //STGAP00008647 creates new ageCitizenshipDB object if it is null to guard against JSP Error
  if (ageCitizenshipDB == null){
     ageCitizenshipDB = new AgeCitizenshipDB();
    }

  PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO = (PersonCitizenshipIdentitylRetrieveSO) request.getAttribute("personCitizenshipIdentitylRetrieveSO");
  if (personCitizenshipIdentitylRetrieveSO == null)
   {
     personCitizenshipIdentitylRetrieveSO = new PersonCitizenshipIdentitylRetrieveSO();
   } 
   
  PersonCitizenshipIdentityList personCitizenshipIdentityBean = personCitizenshipIdentitylRetrieveSO.getPersonCitizenshipIdentityBean(); 
  
  boolean evalConclusionCheckedAge = false;
     
  
   //Method of Age Verification
        Map<String, String> methodAgeVerificationList = new HashMap<String, String>();
        List<CodeAttributes> ageVerificationList = Lookup.getCategoryCollection(CodesTables.CAGEVERF);
        Iterator<CodeAttributes> ageVerificationList_it = ageVerificationList.iterator();
        while (ageVerificationList_it.hasNext()){
          CodeAttributes attribute = ageVerificationList_it.next();
          String code = attribute.getCode();
          if ("ABC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdUsBirthCert");
          } else if ("ABP".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdBaptismCert");
          } else if ("ACF".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdForeignCert");
          } else if ("AEC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeJustifiedEval");
          } else if ("AHC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdHospitalCert");
          } else if ("ANC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdNtrlztnCert");
          } else if ("ARC".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdResidentCard");
          } else if ("AUS".equals(code)){
            methodAgeVerificationList.put(code, "indAgeVrfdPassport");
          }
        }
        
        
   String[] checkedMethodOfAgeVerification = null;  
   
   if(personCitizenshipIdentityBean != null){
     if(personCitizenshipIdentityBean.getMethodAgeVerifications() != null)
      {
        checkedMethodOfAgeVerification = personCitizenshipIdentityBean.getMethodAgeVerifications();
      }
   }
  // 
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};


/* Child found in U.S under age five, parents unknown, display an alert to inform
** the user to refer the case to a Regional Attorney immediately.
*/
function displayAlert()
{
  var x = document.frmAgeCitizenship;
  if ( x.indCtznshpChldFound.value == "true")
  {
    //!!! MessageLookup?
    alert(" Refer the case immediately to a Regional Attorney.  Unless the child applies for a citizenship certificate or, if not eligible, for Special Juvenile Immigrant Status, the child will have no proof of status.");
    return true;
  }
}
/* If the application is in COMP status, have the user confirm they want to 
** open the narrative in edit mode (or create it, if no narrative exists).
** checkCreateNarrativeConfirm()
*/
function checkCreateNarrativeConfirm()
{
<%
if ("COMP".equals(ageCitizenshipDB.getCdEventStatus()) && PageModeConstants.EDIT.equals(pageMode))
{
  if (ageCitizenshipDB.getIndEvaluationConclusion())
  {
%>
  var userDecision = confirm('If you wish to demote the FCE Application\'s event status to PEND and\n' +
                             'open the Evaluative Conclusion Narrative in Edit mode, click \'OK\'.\n\n' +
                             'Otherwise, click \'Cancel\' to open in View mode.');
  if (userDecision)
  {
    document.frmAgeCitizenship.userConfirmNarrative.value = userDecision;  
    submitValidateForm("frmAgeCitizenship", "/fce/AgeCitizenship/saveAndStayAgeCitizenship");
    return false;
  }
  return true;
<%
  }
  else
  {
%>
  var userDecision = confirm('No Evaluative Conclusion Narrative exists for this application.\n\n' + 
                             'If you wish to demote the FCE Application\'s event status to PEND\n' +
                             'and create a new Evaluative Conclusion Narrative, click \'OK\'.\n\n' +
                             'Otherwise, click \'Cancel\'.');
  if (userDecision)
  {
    document.frmAgeCitizenship.userConfirmNarrative.value = userDecision;  
    submitValidateForm("frmAgeCitizenship", "/fce/AgeCitizenship/saveAndStayAgeCitizenship");
    return false;
  }
  return false;
<%
  }
}
else
{
%>
  return true;
<%
}
%>
}
</script>

<impact:validateForm name="frmAgeCitizenship"
     method="post"
     action="/fce/AgeCitizenship/displayAgeCitizenship"
     validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.AgeCitizenshipValidation"
     schema="/WEB-INF/Constraints.xsd"
     redisplayParameters="true"
     pageMode="<%= pageMode %>">

<impact:validateErrors formName="frmAgeCitizenship"/>

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr>
    <th colspan="3">Child's Age</th>
  </tr>
  <tr>
    <td width="15%">
      <label cssClass="formInput">Age</label>
    </td>
    <td width="10%" >
      <%= ageCitizenshipDB.getNbrAge() %>
    </td>
    <td width="75%">&nbsp;</td>
  </tr>
  <tr>
    <td>
      <label cssClass="formInput">Date of Birth</label>
    </td>
    <td >
      <%= ageCitizenshipDB.getDtBirthString() %>
    </td>
    <td>
      <impact:ButtonTag
         onClick="javascript:disableValidation('frmAgeCitizenship')"
         name="btnDetailFinal"
         img="btnDetail"
         align="left"
         form="frmAgeCitizenship"
         action="/fce/AgeCitizenship/callPersonDetail"
         function="disableValidation('frmAgeCitizenship')"
         tabIndex="<%= tabIndex++ %>"/>
    </td>
   </tr>
  <tr>
 <td>Approximate?</td>
 <td colspan="2">
   <impact:ifThen test="<%= (ageCitizenshipDB.getIndDobApprox()) %>">
     <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif"/>
   </impact:ifThen>
 </td>
</tr>
 </table>
<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%"> 
  <tr>
   <th colspan="4">Method of Verification</th>
 </tr>
 <%
  if (checkedMethodOfAgeVerification == null || checkedMethodOfAgeVerification.length == 0){
 %>
 <tr>
   <td colspan="2">N/A</td>
 </tr>
 <%
  } else {
    for (int i = 1; i <= checkedMethodOfAgeVerification.length; i++) {
      int rem = 0;
      if ((rem = i%2) != 0 ){
 %>
  <tr>
    <td width="50%"><%=Lookup.simpleDecodeSafe(CodesTables.CAGEVERF, checkedMethodOfAgeVerification[i-1])%></td>
<%
        if (i == checkedMethodOfAgeVerification.length){
%>
    <td>&nbsp;</td>
  </tr>
<%
        }
      } else {
%>
    <td><%=Lookup.simpleDecodeSafe(CodesTables.CAGEVERF, checkedMethodOfAgeVerification[i-1])%></td>
  </tr>
<%
      }
%>    
      <impact:validateInput type="hidden" 
                      name="<%=  methodAgeVerificationList.get(checkedMethodOfAgeVerification[i-1]) %>" 
                      value="true"/>
<%    
      if ("AEC".equals(checkedMethodOfAgeVerification[i-1])){
        evalConclusionCheckedAge = true;
      }                  
    }
  }
 
%>             
 </table>             
 <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%"> 
  <tr>
   <th colspan="4">Verified by Eligibility Specialist</th>
 </tr>
 <tr>
    <td colspan="2">If any of the selections below are checked, Please ensure results are documented in Records Checked</td>
 </tr>
 <tr>
    <td width="50%">
               <impact:validateInput
               label="SUCCESS System"
               name="indAgeVrfdSuccessSystem"
               tabIndex="<%= tabIndex++ %>"
               value="true"
               checked="<%= ageCitizenshipDB.getIndAgeVrfdSuccessSystemString() %>"
               type="checkbox"
               disabled="false"
               cssClass="formInput" />
           </td>
            <td>
               <impact:validateInput
               label="SAVE System"
               name="indAgeVrfdSaveSystem"
               tabIndex="<%= tabIndex++ %>"
               value="true"
               checked="<%= ageCitizenshipDB.getIndAgeVrfdSaveSystemString() %>"
               type="checkbox"
               cssClass="formInput" />
           </td>
    </tr>
 </table>
 <br>
   <% /*begin  Expandable section */ %>
<impact:ExpandableSectionTag name="ageCitizenship" 
                      id="AgeCitizenship_id"  
                      label="If birth verification document is not being sent to worker, complete this section." 
                      tabIndex="<%= tabIndex++ %>">

<table border="0" cellSpacing="0" cellPadding="3" width="100%" class="tableBorder">
  <tr class="subDetail">
     <td>
       <table border="0" cellspacing="0" cellpadding="3">
     <tr>
     <td><impact:validateInput type="text" 
                      name="nmHospital" 
                      label="Hospital Name"  
                      value="<%= ageCitizenshipDB.getNmHospital() %>" 
                      size="50" 
                      maxLength="50" 
                      tabIndex="<%= tabIndex++ %>" /></td>
     </tr>
     <tr>
       <td><impact:validateInput type="text" 
                      name="nmMotherMaiden" 
                      label="Mother's Maiden Name"  
                      value="<%= ageCitizenshipDB.getNmMotherMaiden() %>" 
                      size="22" 
                      maxLength="22" 
                      tabIndex="<%= tabIndex++ %>" /></td>
       <td><impact:validateInput type="text" 
                      label="City" 
                      constraint="Name20" 
                      name="nmHospitalCity"  
                      cssClass="formInput"
                      value="<%= ageCitizenshipDB.getNmHospitalCity() %>" 
                      size="20" 
                      maxLength="20" 
                      tabIndex="<%= tabIndex++ %>"/></td>
   </tr>
   <tr>
    <td> <impact:validateSelect
                    label="State"
                    name="cdState"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CSTATE"
                    value="<%= ageCitizenshipDB.getCdState() %>"/>
    </td>
    <td> <impact:validateSelect
                    label="County"
                    name="cdCountyHospital"
                    tabIndex="<%= tabIndex++ %>"
                    codesTable="CCOUNT"
                    value="<%= ageCitizenshipDB.getCdCountyHospital() %>"/>
    </td>
   </tr>
   </table>
 </td>
 </tr>
 </table>
</impact:ExpandableSectionTag>
<br>

<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr>
   <th colspan="4">Child's Citizenship/Alien Status</th>
  </tr>
  <tr>
  <td width="20%">
    <label class="formInput">Citizenship/Alien Status</label>
  </td>
  <td width="10%" align="right">
    <nobr><%= Lookup.simpleDecodeSafe("CCTZNSTA",
                                      ageCitizenshipDB.getFceEligibilityCdPersonCitizenship()) %></nobr>
  </td>
  <td width="70%">           
     <impact:ButtonTag
         name="btnDetailFinal"
         img="btnDetail"
         align="left"
         form="frmAgeCitizenship"
         action="/fce/AgeCitizenship/callPersonCitizenshipIdentity"
         function="disableValidation('frmAgeCitizenship')"
         tabIndex="<%= tabIndex++ %>"/>
 </td>
 </tr>
</table>
<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
 <tr>
  <th colspan="2">Method of Verification</th>
 </tr>
 <tr>
  <td>
<%
 request.setAttribute("tabIndex", tabIndex);
 request.setAttribute("fceEligibilityDB", ageCitizenshipDB.getFceEligibility());
%>
<%@ include file="/grnds-docs/fce/CitizenshipSub.jsp" %>
<%
 tabIndex = (Integer) request.getAttribute("tabIndex");
 boolean evalConclusionCheckedCitizenship = (Boolean) request.getAttribute("evalConclusionCheckedCitizenship");
 
 // The Evaluative Conclusion Approved checkbox should not appear on the page
 // until the Application is in PEND mode, there is an Evaluative Conclusion,
 //  and the user has the SEC_ELIGIBILITY security attribute.
 if (("NEW".equalsIgnoreCase(ageCitizenshipDB.getCdEventStatus())) ||
     ("PROC".equalsIgnoreCase(ageCitizenshipDB.getCdEventStatus())) ||
     (!evalConclusionCheckedAge && !evalConclusionCheckedCitizenship))
 {
   evalConcApprvdCheckButtonHide = true;
 }

 if ("PEND".equalsIgnoreCase(ageCitizenshipDB.getCdEventStatus()) &&
     (user.hasRight(UserProfile.SEC_ELIGIBILITY)))
 {
   evalConcApprvdDisabled = "false";
 }
 else
 {
   evalConcApprvdDisabled = "true";
 }
%>
 </td>
</tr>
</table>
 <br>

  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <tr>
     <th colspan="3">Evaluative Conclusion</th>
</tr>
 <tr>
 <td>If the child's age or U.S citizenship cannot be verified by one of the above verification methods,
     check if the child meets the criteria for evaluative conclusion (see Narrative).</td>
 </tr>
 <tr>

  <td>
    <impact:ifThen test="<%= !evalConcApprvdCheckButtonHide %>">
<impact:validateInput
               label="Evaluative Conclusion Approved"
               name="indNarrativeApproved"
               tabIndex="<%= tabIndex++ %>"
               value="true"
               disabled="<%=evalConcApprvdDisabled%>"
               checked="<%= ageCitizenshipDB.getIndNarrativeApprovedString() %>"
               type="checkbox"
               cssClass="formInput" />
    </impact:ifThen>      
  </td>

  </tr>
 </table>
 <table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>

  <td class="alignRight">
 <impact:ButtonTag name="btnSaveFinal" 
                   img="btnSave" 
                   align="right"
                   form="frmAgeCitizenship"
                   action="/fce/AgeCitizenship/saveAgeCitizenship"
                   tabIndex="<%= tabIndex++ %>"/>
</td>
 </tr>
</table>
</table>
<impact:validateInput type="hidden" 
                      name="idFceApplication" 
                      value="<%=  ageCitizenshipDB.getIdFceApplicationString() %>"/>
<impact:validateInput type="hidden" 
                      name="idFceEligibility" 
                      value="<%= ageCitizenshipDB.getIdFceEligibilityString() %>"/>
<impact:validateInput type="hidden" 
                      name="idPerson" 
                      value="<%= ageCitizenshipDB.getIdPersonString() %>"/>
<impact:validateInput type="hidden" 
                      name="idEvent" 
                      value="<%= ageCitizenshipDB.getIdEventString() %>"/>
<impact:validateInput type="hidden" 
                      name="idStage" 
                      value="<%= ageCitizenshipDB.getIdStageString() %>"/>
<impact:validateInput type="hidden" 
                      name="fceEligibilityCdPersonCitizenship" 
                      value="<%= ageCitizenshipDB.getFceEligibilityCdPersonCitizenship() %>"/>
<impact:validateInput type="hidden" 
                      name="fceApplicationDtLastUpdateTime" 
                      value="<%= FormattingHelper.formatLong(ageCitizenshipDB.getFceApplicationDtLastUpdateTime()) %>"/>
<impact:validateInput type="hidden" 
                      name="fceEligibilityDtLastUpdateTime" 
                      value="<%= FormattingHelper.formatLong(ageCitizenshipDB.getFceEligibilityDtLastUpdateTime()) %>"/>
<impact:validateInput type="hidden" 
                      name="idLastUpdatePerson" 
                      value="<%= FormattingHelper.formatInt(BasePrsConversation.getUserID(request))%>"/>
<impact:validateInput type="hidden" 
                      name="dtBirth" 
                      value="<%= ageCitizenshipDB.getDtBirthString() %>"/>
<impact:validateInput type="hidden" 
                      name="userConfirmNarrative" 
                      value="false"/>
<impact:validateInput type="hidden" 
                      name="indCtznshpChldFound" 
                      value="<%= "" + ageCitizenshipDB.getIndCtznshpChldFound() %>"/>                      


<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

<%
//****************************
//**** REPORTS START HERE ****
//****************************
%>
<%/* BEGIN: Forms and Reports */%>
<%
/* Narrative should be protected if the page is in VIEW mode, OR
** if the event status is COMP.  If the application is in COMP and
** the user confirms they want to edit the narrative and reset status
** to PEND, the page is submitted for saving and the status is reset to
** PEND before redisplaying, so the logic here is simple. 
*/
boolean protectDoc = (PageModeConstants.VIEW.equals(pageMode)) || (("COMP".equals(ageCitizenshipDB.getCdEventStatus()) && ageCitizenshipDB.getIndEvaluationConclusion()));
%>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
<td>
<impact:documentButton
        pageMode="<%= pageMode %>"
        tabIndex="<%= tabIndex++ %>">

  <impact:document displayName="Age and Citizenship"
                   name="frmDocumentTag"
                   protectDocument="<%= protectDoc %>"
                   checkForNewMode="true"
                   checkStage="<%= GlobalData.getUlIdStage(request) %>"
                   docType="EVALCNCL"
                   onClick="checkCreateNarrativeConfirm()"
                   action="/fce/AgeCitizenship/launchEvaluativeConclusionNarrative"
                   docExists="<%= ageCitizenshipDB.getIndEvaluationConclusion() %>">

    <impact:documentParameter name="sEvent" value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
    <impact:documentParameter name="sStage" value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
  </impact:document>
</impact:documentButton>

</td>
</tr>
</table>

<%
String userConfirmNarrative = request.getParameter("userConfirmNarrative");
if (userConfirmNarrative != null && "true".equals(userConfirmNarrative) && !FormValidation.pageHasValidationMessages("frmAgeCitizenship", request) && !FormValidation.pageHasErrorMessages(request))
{
%>
<script type="text/javascript" language="JavaScript1.2">
function launchNarrative()
{
  document.getElementById('btnSubmit').click();
}
window.attachEvent( 'onload', launchNarrative );
</script>
<%
}
%>

<%
}
%>
