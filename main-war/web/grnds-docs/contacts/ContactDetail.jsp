<%
/**
 * JSP Name:     Portal Contact Detail
 * Created by:   Patrick Coogan 
 * Date Created: 10/06/03
 *
 * Description:
 * This page displays the Detail version of the Contact page.
 *
 * Change History:
 * Date      User              Description
 * --------  ----------------  -----------------------------------------------
 * 10/27/09  Patrick Coogan	   Created file as a copy of main-war ContactDetail
 *                             and made changes as necessary to support the SHINES
 *                             portal initial release (ECEM).
 * 01/17/12  vcollooru         STGAP00017830: Enhancement Request - MR-101 Portal Contacts
 *                                 
 */
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Time" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.TmScrTmCntct_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="java.util.Date"%>

<%
  {
    int tabIndex = 1;

    String szCdStage = GlobalData.getSzCdStage(request);

    BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                     .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    CSYS08SO csys08so = (CSYS08SO) state.getAttribute("CSYS08SO", request);
    if (csys08so == null) {
      csys08so = new CSYS08SO();
    }

    String pageMode = PageMode.getPageMode(request);

    String selSzCdContactType = PortalContactDetailConversation.getSelSzCdContactType(request);

    // SIR 22860 - The csys08SO object now returns the right Intake Start Date
    String hdnIntakeDate = FormattingHelper.formatDate(csys08so.getDtDtIntStart());
    // STGAP00011640 Will pass time also , ealier hdnIntakeDate was passing only
    //               the date.
    String hdnIntakeTime = FormattingHelper.formatTime(csys08so.getDtDtIntStart());
    //STGAP00007854 - never show the approval status button, not applicable
    boolean approvalStatus = false;
    

    String tsLastUpdate = FormattingHelper.formatDate(csys08so.getTsLastUpdate());
    String txtDtDtContactOccurred = FormattingHelper.formatDate(csys08so.getDtDTContactOccurred());
 
    if ((GlobalData.getUlIdEvent(request) == 0) ) {
      txtDtDtContactOccurred = "";
    }

    TmScrTmCntct_ARRAY timeArray = csys08so.getTmScrTmCntct_ARRAY();
    if (timeArray == null) {
      timeArray = new TmScrTmCntct_ARRAY();
    }
    String txtTmScrTmCntct = FormattingHelper
                                             .formatString(timeArray.getTmScrTmCntctCount() > 0 ? timeArray
                                                                                                           .getTmScrTmCntct(0)
                                                                                               : null);

    String cbxBIndContactAttempted = FormattingHelper.formatString(csys08so.getBIndContactAttempted());
    String cbxBIndExtComment = FormattingHelper.formatString(csys08so.getIndExtDocAccepted());
    if ("".equals(cbxBIndExtComment)) {
      cbxBIndExtComment = "N";
    }
    
    String szNmPersonFull = FormattingHelper.formatString(csys08so.getSzNmPersonFull()); //MR-024 this is populated on Entered by field
    if ((csys08so.getSzNmPersonFull() == null)||"".equals(csys08so.getSzNmPersonFull())){
    szNmPersonFull = FormattingHelper.formatString(csys08so.getSzNmPortalUserFull());
    }
    String szNmContactedBy = FormattingHelper.formatString(csys08so.getSzNmContactedBy()); //MR-024
    String txtDtDtContactEntered = FormattingHelper.formatDate(csys08so.getDtDTContactEntered()); //MR-024
    String hdnEnteredOn = FormattingHelper.formatDate(csys08so.getDtDTContactEntered()); //MR-024
    
    boolean timeDisabled = false;
    String dateDisabled = "false";
    String disableAttempted = "false";
 
    String presentationMode = PortalContactDetailConversation.getPresentationMode(request);
    boolean detailMode = PortalContactDetailConversation.DETAIL_CONTACT.equals(presentationMode);
    boolean extComment = true;
    
    String checkedContactedBy = StringHelper.EMPTY_STRING;
    if (request.getParameter("rbContactedBy")!= null) {
        checkedContactedBy = request.getParameter("rbContactedBy");
      } else {
        if (StringHelper.isValid(csys08so.getSzCdContactedBy())) {
          checkedContactedBy = csys08so.getSzCdContactedBy();
        } else {
          checkedContactedBy = CodesTables.CCCONTBY_DFC;
        }
      }
    
  String contactedbystaff = "none";
  String contactedbyCCA = "none";
  String nameContactedbyCCA = "none";
  String contactedbystaffbutton = "none";
  String contactedbyXXX = "none";
  String nameContactedbyXXX = "none";
  
  Integer hdnUlIdPlcmtFacil = ContextHelper.getIntSafe(request,"hdnUlIdPlcmtFacil");
  Integer hdnUlIdPlcmtAgency = ContextHelper.getIntSafe(request,"hdnUlIdPlcmtAgency");
  
  
  if(CodesTables.CCCONTBY_CCA.equals(checkedContactedBy) ||CodesTables.CCCONTBY_XXX.equals(checkedContactedBy)){
  contactedbystaffbutton = "block";
  contactedbystaff = "block";  
  }
  
  if(CodesTables.CCCONTBY_DFC.equals(checkedContactedBy)){
 contactedbyCCA = "block";
  }
   
    String indSauSealedHomeAndWorker = (String) state.getAttribute("SAUSEALEDHOMEANDWORKER", request);  
    String editAllowedSevenDays = (String) state.getAttribute("EDITALLOWEDFORSEVENDAYS",request);
    String editAllowed = (String) state.getAttribute("EDITALLOWED", request);
    String isContactBeforeStageClosure = (String) state.getAttribute("ISDATEBEFORESTAGECLOSE", request);
    request.setAttribute("ISDATEBEFORESTAGECLOSESUB", isContactBeforeStageClosure);
    request.setAttribute("EDITALLOWEDSUB", editAllowed); 
    request.setAttribute("SAUSEALEDHOMEANDWORKERSUB", indSauSealedHomeAndWorker); 
    request.setAttribute("EDITALLOWEDFORSEVENDAYSSUB", editAllowedSevenDays);  
      if ( ("true".equals(editAllowed) && "false".equals(isContactBeforeStageClosure)) || 
              ("true".equals(indSauSealedHomeAndWorker) && "true".equals(editAllowedSevenDays) && "false".equals(isContactBeforeStageClosure))) {
      timeDisabled = false;
      dateDisabled = "false";
      disableAttempted = "false";
    }
	
    //Narrative Type check boxes
    String checkedNarrativeType = StringHelper.EMPTY_STRING;
    if (csys08so.getSzCdContactNarr() != null) {
       checkedNarrativeType = csys08so.getSzCdContactNarr();
    } else if(CodesTables.CSTAGES_ADO.equals(szCdStage) || CodesTables.CSTAGES_FSU.equals(szCdStage)
               || CodesTables.CSTAGES_SUB.equals(szCdStage)) {
       checkedNarrativeType = CodesTables.CCONNARR_SPW;
    } else {
       checkedNarrativeType = CodesTables.CCONNARR_STD;
    }

     String modDisabled = "false";
      if (ArchitectureConstants.Y.equals(csys08so.getIndExtDocAccepted())){
     modDisabled = "true";
   }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="JavaScript1.2">
  window.onbeforeunload = function ()
  {      
   IsDirty();
   }
   
  window.onload = function()
{
 var varRbContactedBy = document.getElementsByName('rbContactedBy');
if (varRbContactedBy.length > 1){
 if(document.frmContactDetail.rbContactedBy[0].checked)
     {
      toggleVisibility('contactedbystaffbutton', 'block');
      toggleVisibility('contactedbystaff', 'block');
      toggleVisibility('contactedbyCCA', 'none');
      toggleVisibility('contactedbyXXX', 'none');
      toggleVisibility('nameContactedbyCCA', 'none');
      toggleVisibility('nameContactedbyXXX', 'none');
     } else if(document.frmContactDetail.rbContactedBy[1].checked){
      toggleVisibility('contactedbyCCA', 'block');
      toggleVisibility('nameContactedbyCCA', 'block');
      toggleVisibility('contactedbystaff', 'none');
      toggleVisibility('contactedbystaffbutton', 'none');
      toggleVisibility('contactedbyXXX', 'none');
      toggleVisibility('nameContactedbyXXX', 'none');
      } else if(document.frmContactDetail.rbContactedBy[2].checked){
      toggleVisibility('contactedbyXXX', 'block');
      toggleVisibility('nameContactedbyXXX', 'block');
      toggleVisibility('contactedbystaff', 'none');
      toggleVisibility('contactedbystaffbutton', 'none');
      toggleVisibility('contactedbyCCA', 'none');
      toggleVisibility('nameContactedbyCCA', 'none');
      }     
   }else{
    if(document.frmContactDetail.rbContactedBy_Disabled[0].checked)
     {
      toggleVisibility('contactedbystaffbutton', 'block');
      toggleVisibility('contactedbystaff', 'block');
      toggleVisibility('contactedbyCCA', 'none');
      toggleVisibility('contactedbyXXX', 'none');
      toggleVisibility('nameContactedbyCCA', 'none');
      toggleVisibility('nameContactedbyXXX', 'none');
     } else if(document.frmContactDetail.rbContactedBy_Disabled[1].checked){
      toggleVisibility('contactedbyCCA', 'block');
      toggleVisibility('nameContactedbyCCA', 'block');
      toggleVisibility('contactedbystaff', 'none');
      toggleVisibility('contactedbystaffbutton', 'none');
      toggleVisibility('contactedbyXXX', 'none');
      toggleVisibility('nameContactedbyXXX', 'none');
      } else if(document.frmContactDetail.rbContactedBy_Disabled[2].checked){
      toggleVisibility('contactedbyXXX', 'block');
      toggleVisibility('nameContactedbyXXX', 'block');
      toggleVisibility('contactedbystaff', 'none');
      toggleVisibility('contactedbystaffbutton', 'none');
      toggleVisibility('contactedbyCCA', 'none');
      toggleVisibility('nameContactedbyCCA', 'none');
      }
   }
 }
  
  function onClickOfDFC(){
     if(document.frmContactDetail.rbContactedBy[0].checked)
      {
      toggleVisibility('contactedbystaff', 'block');
      toggleVisibility('contactedbystaffbutton', 'block');
      toggleVisibility('contactedbyCCA', 'none');
      toggleVisibility('contactedbyXXX', 'none');
      toggleVisibility('nameContactedbyCCA', 'none');
      toggleVisibility('nameContactedbyXXX', 'none');
      updateDisplayOnlyField("frmContactDetail", "szNmContactedByStaff", "");
      }
   }
  
   function onClickOfCCA(){
       if(document.frmContactDetail.rbContactedBy[1].checked){
       toggleVisibility('contactedbyCCA', 'block');
       toggleVisibility('nameContactedbyCCA', 'block');
       toggleVisibility('contactedbystaff', 'none');
       toggleVisibility('contactedbystaffbutton', 'none');
       toggleVisibility('contactedbyXXX', 'none');
       toggleVisibility('nameContactedbyXXX', 'none');
       document.frmContactDetail.szNmContactedByCCA.value = "";              
       }  
    }
  
    function onClickOfXXX(){  
       if(document.frmContactDetail.rbContactedBy[2].checked ){
       toggleVisibility('contactedbyXXX', 'block');
       toggleVisibility('nameContactedbyXXX', 'block');
       toggleVisibility('contactedbystaff', 'none');
       toggleVisibility('contactedbystaffbutton', 'none');
       toggleVisibility('contactedbyCCA', 'none');
       toggleVisibility('nameContactedbyCCA', 'none');
       document.frmContactDetail.szNmContactedByXXX.value = "";       
       }  
    } 

</script>


<impact:validateForm name="frmContactDetail"
                     method="post"
                     action="/contacts/PortalContactDetail/displayContact"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.contacts.PortalContactDetailCustomValidation"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd">

<impact:validateErrors/>
<table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
  <tr>
    <th colspan="8">Contact Information</th>
  </tr>
  <tr>
     <td width="15%">
      <impact:validateDisplayOnlyField
        name="selSzCdContactType"
        codesTable="<%=CodesTables.CCNTCTYP%>"
        label="Contact/Summary Type"
        value="<%=selSzCdContactType%>"
      />
    </td>
  </tr>
  
 <tr>
  <td>
   
      <impact:validateDisplayOnlyField	
        label="Entered By"
        name="szNmEnteredBy"
        width="30%"
        value="<%=szNmPersonFull%>"
      />
   
   </td>
  <td>
    <impact:ifThen test='<%=detailMode%>'>
      <impact:validateDisplayOnlyField
        label="Entered On"
        width="30%"
         name="txtDtDtContactEntered"               
        value="<%=txtDtDtContactEntered%>"
      />
      </impact:ifThen>
    </td>    
   </tr>
<tr>
    <td>
      <impact:ifThen test='<%=detailMode && ((csys08so.getSzCdJobTitle()!= null)&&!("".equals(csys08so.getSzCdJobTitle())))%>'>
        <impact:validateDisplayOnlyField
          label="Title"
          name="szCdJobTitle"
          colspan="4"
          value="<%=csys08so.getSzCdJobTitle()%>"
          codesTable="CEMPJBCL"
        />
      </impact:ifThen>
    </td>
  </tr> 
  <tr>
    <td>
      <impact:ifThen test='<%=detailMode && ((csys08so.getSzCdJobTitle()== null)||"".equals(csys08so.getSzCdJobTitle()))%>'>
        <impact:validateDisplayOnlyField
          label="Title"
          name="szCdJobTitle"
          colspan="4"
          value="<%=csys08so.getSzTitlePortalUser()%>"
         />
      </impact:ifThen>
    </td>
  </tr> 
<impact:ifThen test='<%=detailMode%>'>
  <tr> 
    <td width="25%"> Contacted By: 
     </td>
	 <td width="33%">	
	  	<impact:validateInput checked="<%=CodesTables.CCCONTBY_DFC.equals(checkedContactedBy) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CCCONTBY_DFC%>" type="radio" name="rbContactedBy" label="DFCS Staff" cssClass="formInput" 
				disabled="true" onClick="onClickOfDFC()"/>
	 </td>
	 
 <td width="25%" id="contactedbystaff" style="display: <%= contactedbystaff %>">
 &nbsp;
 </td>
 
 <td width ="12%" id="contactedbystaffbutton" style="display: <%= contactedbystaffbutton %>">
          &nbsp;
  </td>	 
 </tr>
  
  <tr>
	 <td width="25%"> </td> <td width="33%">
		<impact:validateInput checked="<%=CodesTables.CCCONTBY_CCA.equals(checkedContactedBy) ? "true" : "false"%>" tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CCCONTBY_CCA%>" type="radio" name="rbContactedBy" label="CPA/CCI Authorized Case Worker" cssClass="formInput" 
				disabled="true" onClick="onClickOfCCA()"/>
	 </td>
		 
	 <td> 	 
		 <impact:ifThen test='<%=detailMode%>'>
		   <impact:validateInput label="Name of Worker" type="text" conditionallyRequired="true" name="szNmContactedByCCA"  value="<%=szNmContactedBy%>" />   
	     </impact:ifThen>
     </td>
	 
 </tr>

 <tr>
	 <td width="25%"> </td> <td width="33%">
		<impact:validateInput checked="<%=CodesTables.CCCONTBY_XXX.equals(checkedContactedBy) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CCCONTBY_XXX%>" type="radio" name="rbContactedBy" label="Other" cssClass="formInput"
				disabled="true" onClick="onClickOfXXX()" />
	</td>
	<td id="nameContactedbyXXX" width="25%" style="display: <%= nameContactedbyXXX %>"> 	 
	  <impact:ifThen test='<%=detailMode%>'>
		     <impact:validateDisplayOnlyField label="Name    "  conditionallyRequired="true" name=""  value=""/>   
	  </impact:ifThen>
    </td>
	
    <td id="contactedbyXXX" width="12%" style="display: <%= contactedbyXXX %>"> 
      <impact:ifThen test='<%=detailMode%>'>
        <impact:validateInput label="" tabIndex="<%=tabIndex++%>"  type="text"
                              name="szNmContactedByXXX" disabled="<%=disableAttempted%>" value="<%=szNmContactedBy%>" />   
     </impact:ifThen>
    </td>
</tr>
</impact:ifThen>



  <tr>
    <td>
      <impact:validateDate label="Contact Date"
                           constraint="Date"
                           name="txtDtDtContactOccurred"
                           value="<%=txtDtDtContactOccurred%>"
                           required="true"
                           size="8"
                           tabIndex="<%=tabIndex++%>"
                           disabled="<%=dateDisabled%>"/>
    </td>
    <td>
      <impact:validateTime label="Time"
                           name="txtTmScrTmCntct"
                           value="<%=txtTmScrTmCntct%>"
                           disabled="<%=String.valueOf(timeDisabled)%>"
                           required="true"
                           tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:ifThen test='<%=detailMode%>'>
        <impact:validateInput label="Attempted"
                              name="cbxBIndContactAttempted"
                              type="checkbox"
                              disabled="<%=disableAttempted%>"
                              checked="<%=cbxBIndContactAttempted%>"
                              value="<%=cbxBIndContactAttempted%>"
                              tabIndex="<%=tabIndex++%>"/>
      </impact:ifThen>
    </td>
  </tr>
  <%
    request.setAttribute("tabIndex", tabIndex);
  %>
  <impact:if test='<%=detailMode%>'>
    <impact:then>
      <%@ include file="/grnds-docs/contacts/DetailContactSub.jsp" %>
      <%-- jsp:include page="/grnds-docs/contacts/DetailContactSub.jsp" / --%>
    </impact:then>
  </impact:if>
  <%
    tabIndex = (Integer) request.getAttribute("tabIndex");

        // Moved table close tag down here.
  %>
</table>

<%
  // All Contacts have a modifiable Date except the AFC Contacts EDOC, EENV,
      // EEXR, EFAC, EPHY which all prefill with the current date and are locked.
      //
      // CPS cases do not have a Time.
      //
      // APS cases have a modifiable Time except the AFC Contacts EDOC, EENV, EEXR,
      // EFAC , EPHY, CLEV, CLES (SIR 23410) which prefill with the currente time and are non-modifiable.
      //
      // Initial Presentation Mode:
      // A Contact Type can be selected and the Continue Button is shown.
      //
      // Detail Presentation Mode:
      // The Select Staff Button allows you to change Contacted By.
      // The Attempted & Attempted checkbox, Purpose, Method, Location,
      // Attempted and Principal Collaterals checkboxes are modifiable.
      // The Purpose, Method, Location, and Others Contacted fields are modifiable
      // for the programs except for CLES and CLEV (SIR 23410).
      //
      // Summary Presentation Mode:
      // The Select Staff Button, Attempted checkbox, Purpose, Method, Location,
      // Others fields and Principal/Collaterals checkboxes don't exist.
      // The following Summary Contacts have a Summary Period: EEXR, BMTH, GMTH,
      // HMTH, JMTH, IREZ, IATZ, IDVZ, IPHZ, IMAZ, IQUZ, IREE, ISEZ, IVAZ, IVIZ.
      //
      //
      //SIR 23298 added AGR to  and submit
      String[] Submit = { "EXR", "MTH", "AGR" };
      String[] SubmitFAD = { "ATP", "ATZ", "CMP", "DVP", "DVZ", "FCL", "MAS", "MAZ", "PHS", "PHZ", "QUV", "QUZ",
                            "REA", "REE", "REG", "REZ", "SEI", "SEZ", "STS", "VAR", "VAZ", "VIO", "VIZ" };

      boolean display = true;
      // SIR 18274 - For an Extension Request Hide the  Button if there is a
      // UlIdEvent, if there is not, hide the  and Submit Button.
      if (CodesTables.CCNTCTYP_EEXR.equals(selSzCdContactType) && GlobalData.getUlIdEvent(request) != 0) {
        display = false;
      }

      // Grab charcters two to four of selSzCdContact Type for comparisons.  The
      // first character is a key to determine the type of case and stage and we
      // don't need to compare that.  Example:  AREG is a Contact for a CPS INV
      // Case, and a BREG is a Contact for a CPS FPR Case.
      //String contactType = selSzCdContactType.substring( 1, 4 );
      String contactType = selSzCdContactType.substring(0, 3);

      boolean displaySubmit = false;
      // Set displaySubmit to true if AndSubmit button should be shown
      for (int i = 0; i < Submit.length; i++) {
        if (contactType.equals(Submit[i])) {
          displaySubmit = true;
        }
      }

      //Set true if it's a FAD Program and one of the types in the array
      if (szCdStage.equals(CodesTables.CSTAGES_FAD)) {
        for (int i = 0; i < SubmitFAD.length; i++) {
          if (contactType.equals(SubmitFAD[i])) {
            displaySubmit = true;
          }
        }
      }

      if (CodesTables.CCNTCTYP_EEXR.equals(selSzCdContactType) && GlobalData.getUlIdEvent(request) == 0) {
        displaySubmit = false;
      }

      // SIR 17669 Do not display the  and submit pushbutton when the
      // page is in approval mode either
      if (GlobalData.isApprovalMode(request)) {
        displaySubmit = false;
      }
%>

<script type="text/JavaScript" language="javascript">
  <%--
    SIR 18373 - This function has been added to ask the user if they selected
                all the principals the TCM contact was with and/or about?
   MR - 024 STGAP00014326  This function is no longer required as all the codes mentioned
   in the tcmArray are enddated from the Purpose codes. 
   Removed function call  function="return confirm()" from btnSave widge  

  function confirm()
  {
  <impact:ifThen test='<%=detailMode%>'>
    var purpose = frmContactDetail.selSzCdContactPurpose.value

    var tcmArray = new Array("AAMT", "AMON", "APLN", "AREA", "GAMT", "GMON",
            "GPLN", "GREA", "HAMT", "HAPR", "HCPR", "HPCN",
            "HPLD", "HPLS", "HPPC", "HPPR", "HPSS");

    for( i = 0; i < tcmArray.length; i++ )
    {
      if( purpose == tcmArray[i] )
      {
        return confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_SVC_SELECT_TCM_PRN)%>");
      }
    }
  </impact:ifThen>

    return true;
  }  --%>
  
 function onClickOfNarrType()
  { 
  var narrType = "<%= csys08so.getSzCdContactNarr() %>";
  var narrTypeSelected = "";
  var docTypeNarr = "";
  
  if(document.frmContactDetail.rbNarrType[0].checked){
     narrTypeSelected = "STD";
     docTypeNarr = "BLANKNAR";
  }else if(document.frmContactDetail.rbNarrType[1].checked){
     narrTypeSelected = "PCV";
     docTypeNarr = "cvisitn";
  }else {
    narrTypeSelected = "SPW";
    docTypeNarr = "spwbnarr";
  }
  
  // If the same radio button is clicked that was selected when the page loaded then ignore.
  if (narrType == narrTypeSelected){
    return true;
  } else {
    document.frmDocument.promptSavePage.value = 'frmContactDetail';
  } 

  if (document.frmDocument.docExists.value == 'true' && (narrType != narrTypeSelected)){
      if (confirm('The existing narrative will be deleted and all the information will be lost if the narrative type is changed. Are you sure you want to change the narrative type?  Click OK to continue.'))
      {
         document.frmDocument.promptSavePage.value = 'frmContactDetail';
         document.frmContactDetail.hidDeleteDocument.value = 'true';
      }
      else
      {
         //Set the radio button back
         if (narrType == "STD") {
           document.frmContactDetail.rbNarrType[0].checked = true;
         } else if (narrType == "PCV") {
           document.frmContactDetail.rbNarrType[1].checked = true;
         } else if (narrType == "SPW") {
           document.frmContactDetail.rbNarrType[2].checked = true;
         }
       }
  }   
}
    
  
</script>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
<tr>
   
  
 </td>
 <td align="right" width="10%">
      <impact:ButtonTag name="btnSave"
                        img="btnSave"
                        action="/contacts/PortalContactDetail/saveContact"
                        form="frmContactDetail"
                        align="right"
                        restrictRepost="true"
                        preventDoubleClick="true"
                        tabIndex="<%=tabIndex++%>"/>
 </td>
</tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width= "100%" class="tableBorder" >
  	  <tr> 
         <td width="20%">Narrative Type: 
        </td> 
  		  	<td></td><td width="20%">	   
				<impact:validateInput checked="<%=CodesTables.CCONNARR_STD.equals(checkedNarrativeType) ? "true" : "false"%>" tabIndex="<%=tabIndex++%>" 
                value="STD" type="radio" name="rbNarrType" label="Standard" cssClass="formInput"
				onClick="return onClickOfNarrType();" disabled="<%=disableAttempted%>"/>
			</td>
		    <td></td><td width="25%">
				<impact:validateInput checked="<%=CodesTables.CCONNARR_PCV.equals(checkedNarrativeType) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="PCV" type="radio" name="rbNarrType" label="Parent/Child Visitation" cssClass="formInput"
				onClick="return onClickOfNarrType();" disabled="<%=disableAttempted%>"/>
			</td>
			<td></td><td width="35%">
				<impact:validateInput checked="<%=CodesTables.CCONNARR_SPW.equals(checkedNarrativeType) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="SPW" type="radio" name="rbNarrType" label="Safety, Permanency and Wellbeing" cssClass="formInput"
				onClick="return onClickOfNarrType();" disabled="<%=disableAttempted%>"/>
			</td><td></td>
		</tr>
</table>
<br/>
<impact:ifThen test="<%=extComment%>">
<table border="0" cellspacing="0" cellpadding="3" align="right" width= "100%" class="tableBorder" >
  			<tr>
  			<td> 
				<impact:validateInput checked="<%=cbxBIndExtComment%>" 
				value="<%=cbxBIndExtComment%>" type="checkbox" label="External  User Comments Accepted" name="cbxBIndExtComment" cssClass="formInput"
				disabled="true"/>
				</td>
			</tr>
			<tr>
			<td width="20%">Checking this box indicates that the documentation has been received by the case manager and that the documentation is complete.
			</td>
			</tr>
</table>
</impact:ifThen>

<impact:validateInput name="hidDeleteDocument" type="hidden" value="false"/>
<impact:validateInput type="hidden" name="hdnDocExists" value= "false" /> <%-- MR-024 --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<%-- these 2  used by document framework for new using --%>
<impact:validateInput type="hidden" name="nEvent" value='<%=(String) request.getAttribute("nEvent")%>'/>
<impact:validateInput type="hidden" name="nCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>"/>
<impact:validateInput type="hidden" name="docType" value=""/>
<%-- this used by custom validation --%>
<impact:validateInput type="hidden" name="IntakeDate" value="<%=hdnIntakeDate%>"/>
<%--Added per STGAP00011640 hdnIntakeTime to use in CustomValidation  --%>
<impact:validateInput type="hidden" name="hdnIntakeTime" value="<%=hdnIntakeTime%>"/>
<%-- other hidden inputs --%>
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%=tsLastUpdate%>"/>
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%=String.valueOf(GlobalData.getUlIdPerson(request))%>"/>
<impact:validateInput type="hidden" name="hdnEnteredOn" value="<%=hdnEnteredOn%>"/> <%-- MR-024 --%>
<impact:validateInput type="hidden" name="hdnUlIdPlcmtFacil" value="<%= FormattingHelper.formatLong(hdnUlIdPlcmtFacil)%>" />
<impact:validateInput type="hidden" name="hdnUlIdPlcmtAgency" value="<%= FormattingHelper.formatLong(hdnUlIdPlcmtAgency)%>" />

</impact:validateForm>
<%
    boolean docExists = false;
    boolean bProtect = true;
    boolean stageIsOpen = false;
    boolean commentMode = false;
    if (ArchitectureConstants.TRUE.equals(request.getAttribute(PortalContactDetailConversation.DOCEXISTS))) {
      docExists = true;
    }
    
    // SIR 18384 - Had to set bProtect to false if in Approval mode
    String sDate = FormattingHelper.formatTimestamp(csys08so.getTsLastUpdate());
    if (csys08so.getDtDtStageClose() == null) {
      stageIsOpen = true;
    }    
    
    // editAllowed = If it is within 7 days, the user is the original author, not TCM billed.
    // i.e stage was still open while contact was updated
    //ISDATEBEFORESTAGECLOSE will take into account if the stage was closed or open and if the stage was closed
    //check if the contact was entered before or after stage closure.
    if(ArchitectureConstants.TRUE.equals(editAllowed)  &&  ArchitectureConstants.FALSE.equals(state.getAttribute("ISDATEBEFORESTAGECLOSE", request))
    || ("true".equals(indSauSealedHomeAndWorker) && "true".equals(editAllowedSevenDays) && "false".equals(isContactBeforeStageClosure))){
      bProtect = false;
      commentMode = true;
    }     
      
    if (GlobalData.isApprovalMode(request)) {
      bProtect = false;
      commentMode = true;    
    }
    
    // If it is NOT within 7 days, the user is the original author,has stage access and has ever been assigned.
    if(ArchitectureConstants.FALSE.equals(editAllowed) || ArchitectureConstants.TRUE.equals(state.getAttribute("ISDATEBEFORESTAGECLOSE", request))  ){ // If it is NOT  (within 7 days && the user is the original author and not TCM billed) 
     if (ArchitectureConstants.TRUE.equals(state.getAttribute("FORMCOMMENTSACCESS", request)) || "true".equals(indSauSealedHomeAndWorker) ){
      bProtect = true;
      commentMode = true;
    }
    }
    
    
        
    
   
    // SIR 18956 - We have to moneky around with the Narrative that will be
    // displayed because CIFF use to be able to be either a FACTOFAC or NORMAL,
    // and C24H could have been 24HOUR or NORMAL, so we added C24N (NORMAL) and
    // CFTF (FACTOFAC).  All of this has to do with APS SVC vs APS INV stages.
    String docType = selSzCdContactType;
    String docTypeNarr = "BLANKNAR";
    //docType will be set to "CIFF" by default, change it to "CFTF" if needed
    if (CodesTables.CCNTCTYP_CIFF.equals(docType) && CodesTables.CSTAGES_INV.equals(szCdStage)) {
      docType = CodesTables.CCNTCTYP_CFTF;
    }

    if ("PVC".equals(docType.substring(1, 4)) || CodesTables.CCONNARR_PCV.equals(checkedNarrativeType)) {
      docTypeNarr = "cvisitn";
    }
    
    if(CodesTables.CCONNARR_STD.equals(checkedNarrativeType)){
      docTypeNarr = "BLANKNAR";
    }
    
    if(CodesTables.CCONNARR_SPW.equals(checkedNarrativeType)){
      docTypeNarr = "spwbnarr";
    }

    //  MR - 024 SafetyResourceAssessment narrative has been removed from this page.
    //if ("SRA".equals(docType.substring(1, 4))) {
    //  docTypeNarr = "fas05o00";
    //  }
    
    
    //docType will be set to "C24H" by default, change it to "C24N" if needed
    if (CodesTables.CCNTCTYP_C24H.equals(docType) && CodesTables.CSTAGES_SVC.equals(szCdStage)) {
      docType = CodesTables.CCNTCTYP_C24N;
    }

    String szCdStageType = GlobalData.getSzCdStageType(request);
    boolean displayNarrativeButton = true;
    // SIR 18974 - There is no narrative button for PAL Notifications (JNOT)
    // If logic was erroneously comparing JNOT to Stage instead of Contact Type
    // Sir 23686 - For APS, when contact Types are C24N,CMST and CIFF display narrative
    // button only if documemt already exist or stage type is C-REG or C-GUA.

    if ((CodesTables.CCNTCTYP_JNOT.equals(selSzCdContactType))
        || (CodesTables.CPGRMSFM_APS.equals(GlobalData.getSzCdStageProgram(request)) && ((!CodesTables.CSTGTYPE_CGUA
                                                                                                                    .equals(szCdStageType) && !CodesTables.CSTGTYPE_CREG
                                                                                                                                                                        .equals(szCdStageType))
                                                                                         && (CodesTables.CCNTCTYP_C24N
                                                                                                                      .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_C24H
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_CMST
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_EIFF
                                                                                                                         .equals(docType)
                                                                                             || CodesTables.CCNTCTYP_CFTF
                                                                                                                         .equals(docType) || CodesTables.CCNTCTYP_CIFF
                                                                                                                                                                      .equals(docType)) && !docExists))) {
      displayNarrativeButton = false;
    }

    // You always show the Narrative button for a Closed Stage Addendum but you
    // shouldn't pass in checkStage.  This way anyone can edit a FCCA Narrative.
    int checkStage = GlobalData.getUlIdStage(request);
    if (CodesTables.CCNTCTYP_FCCA.equals(selSzCdContactType)) {
      checkStage = 0;
    }

    if (CodesTables.CCNTCTYP_FCCA.equals(selSzCdContactType) || displayNarrativeButton) {
%>
<tr>
  <td>
    <br>
    <impact:documentButton pageMode="<%=pageMode%>" tabIndex="<%=tabIndex++%>">
      <impact:document displayName="Document"
                       checkForNewMode="true"
                       name="frmDocument"
                       checkStage="<%=checkStage%>"
                       protectDocument="<%=bProtect%>"
                       commentMode="<%=commentMode%>"
                       deleteDocument="false"                   
                       docType="<%=docTypeNarr%>"
                       docExists="<%=docExists%>">

        <impact:documentParameter name="sEvent" value="<%=String.valueOf(GlobalData.getUlIdEvent(request))%>"/>
        <impact:documentParameter name="sCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>"/>
        <impact:documentParameter name="sTimestamp" value="<%= sDate %>"/>
        <impact:documentParameter name="pCase" value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>"/>
        <impact:documentParameter name="pStage" value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>"/>
        <impact:documentParameter name="pCdStage" value="<%=String.valueOf(GlobalData.getSzCdStage(request))%>"></impact:documentParameter>
      </impact:document>
    </impact:documentButton>
  </td> 
</tr>
</table>
<script type="text/JavaScript" language="javascript">

  document.frmContactDetail.hdnDocExists.value = '<%=docExists%>';

  function setDocTypeParam() {
    document.frmContactDetail.docType.value = '<%=docTypeNarr%>';
  }
  window.attachEvent('onload', setDocTypeParam);
</script>
<%
  }
%>
<%
  }
%>