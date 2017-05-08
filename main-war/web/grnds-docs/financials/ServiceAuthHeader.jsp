<%
//*  JSP Name:     Service Authorization Header
      //*  Created by:   Anna Grimshaw
      //*  Date Created: 02/17/2003
      //*
      //*  Description:
      //*  This JSP is used to maintain Service Authorization Information
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  05/01/03  GRIMSHAN          SIR #16978 Added condition to hide the save and
      //**                              submit pushbutton if the Event Status is approved
      //**  05/08/03  GRIMSHAN          SIR 17377 changed the call of setReadyforComplete
      //**                              so that it is not called if the page is in new mode
      //**  05/20/03  GRIMSHAN          SIR 17603 Display approval status button if the
      //**                              page has been previously submitted for approval.
      //**  05/29/03  GRIMSHAN          SIR 17858 add expand all and collapse all
      //**  06/02/03  GRIMSHAN          SIR 17944 Display save and submit unless the
      //**                              page mode is new, or the event has been previously
      //**                              approved
      //**  06/05/03  GRIMSHAN          SIR 17894 Set enable validation on save and
      //**                              save and submit so that if the user selects a resource
      //**                              and then saves, validation will be re-enabled.
      //**  06/13/03  GRIMSHAN          SIR 18306 Display different region message only when the
      //**                              user is saving the page for the first time
      //**  06/24/03  GRIMSHAN          SIR 18416 Set editable mode to all for approval
      //**                              status button
      //**  07/01/03  GRIMSHAN          SIR 18626 a javascript popup will be called if the
      //**                              user is adding a verbal referal date that is greater
      //**                              than 7 days before today's date.
      //**  07/08/03  GRIMSHAN          SIR 18773 Make sure the javascript popup is not called
      //**                              if the program is not aps
      //**  09/16/03  A.Corley          SIR 19779 If the page mode is not new, place the first
      //**                              person available from the list into the primary client
      //**                              this is done so that if there is a problem with merged
      //**                              persons in the service a person will still appear in the
      //**                              dropdown.
      //**  11/05/03  A.Corley          SIR 22385 If Region 99 is selected, the county dropdown
      //**                              should say 'Out of State'
      //**  05/01/04  A.Corley          SIR 19608 Set static width to Client drop down so that
      //**                              suffix will be displayed.
      //**  07/19/04  CORLEYAN          SIR 22573 Add New Using to the Service Auth Detail list
      //**                              so that the users can new use existing rows.
      //**  04/20/05  CORLYEAN          SIR 23538 - Added new resource Search Criteria,
      //**                              Donated Community Service that will display for APS
      //**                              only.  When this new type is selected, the resource search
      //**                              will search based on resource_service instead of contract_county
      //**                              if this type is saved, only the subcontractor list and new
      //**                              section Estimated Value will display.
      //**  08/04/05  reedlg            SIR 23741 - add new category "35- IV-E Admin/Training"
      //**  08/30/05  thompswa          SIR 23662 edits not requested for Header.
      //**  06/26/08  PCOOGAN           STGAP00008445 - added 80 to the 518 array to allow 51880 as an
      //**                              allowable service authorization.
      //**
      //**
      //**  07/24/08  Cwells            STGAP00008182 - When we are pulling back a policy waiver check
      //** 	      				        The waiver required selection.    
      //**  01/02/09  arege             STGAP00006612 In Service Auth List expandable section, Fixed the
      //**                              alignment of the Requested Units,Amount, UnitType, Period,
      //**                              Frequency, Sugg Units, Units Used fields.
      //**  03/23/09  pcoogan           STGAP00013039 - Added hashmap arrays for UAS 515,617, and 618 and
      //**                              corrected to allow 52200 to be visible.
      //**  08/03/09  arege             STGAP00014580 Entitlement Codes of 10 - Unusual Medical/Burial, 11 - Child Resistant Device
      //**                              99 - Written Waiver Item are populated in the dropdown when UAS program 576 is selected.
      //**  10/02/09  mxpatel           STGAP00015471 - added new service codes
      //**  12/30/09  mchillman         Change to support performing full search from SerAuth page for Ado 510 - 512 service codes
      //**  03/19/10  arege             SMS#48357 For category of 512 and service codes of 57 and 77, the Select Resource button should lead to Search Results page with all Providers
      //**  03/28/10  arege             For category 531 the Select Resource button should lead to Search Results page with  providers.
      //**  08/25/11  htvo              STGAP00017019: ECEM 5.0: convert hardcoded service code list to DB approach to allow online update to service code be reflected here
      //**  01/19/12  vcollooru			STGAP00017831: MR-102: Modified to make the following Service Authorization Header changes
      //**											i) added a display-only contract ID field.
      //**											ii) modified the Referral Comments field length to 1000 characters.
      //**											iii) to display the Forms section only for approved service authorizations
      
      
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
       for Tuxedo service calls.  Xml output structs corresponding to the services
       called to retrieve data for this page should be used on this page and
       therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON24SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON21SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthConversation"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>

<%// Import needed for Form Launch
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      //Get the output object from the request
      CCON18SO ccon18so = (CCON18SO) state.getAttribute("CCON18SO", request);
      CCON21SO ccon21so = (CCON21SO) state.getAttribute("CCON21SO", request);
      CRES03SO cres03so = (CRES03SO) state.getAttribute("CRES03SO", request);
      Double totalAmount = 0.00;
      int editableMode = EditableMode.ALL;
      int secondEditableMode = EditableMode.NEW + EditableMode.EDIT;
      int ulIdResource = 0;
      int ulIdWaiverId = 0;
      int ulIdContract = 0;
      List clientList = (List) state.getAttribute("clientList", request);
      ROWCCMN01UIG00 rowccmn01uig00 = null;
      ROWCCON21SOG00_ARRAY serviceArray = null;
      String amount = "";
      String appMode = GlobalData.getAppMode(request);
      String cIndDntdCmmtySvc = "";
      String cIndWaiverReqd = "";
      String cReqFuncCd = (String) state.getAttribute("cReqFuncCd", request);
      String disableApprovalStatus = "true";
      String EMPTY_STRING = "";
      String EVENT_STATUS_APPROVE = "APRV";
      String hasRow = "F";
      String IND_POLICY_WAIVER = "true";
      String indRsrcSelected = (String) state.getAttribute("indRsrcSelected", request);
      String listValue = "";
      String reqd = "true";
      String reqPullBack = request.getParameter("hdnReqPullBack");
      String stage = (String) GlobalData.getUlIdStageAsString(request);
      String szCdErlyCaseTyp = "";
      String szCdPayCnty = "";
      String szCdPupOtcme = "";
      String szCdPupTyp = "";
      String szCdSvcAuthCategory = "";
      String szCdSvcAuthCounty = "";
      String szCdSvcAuthRegion = "";
      String szCdSvcAuthService = "";
      String szNmResource = "";
      String currentCaseCounty = GlobalData.getSzCdCounty(request);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      String pageMode =  PageMode.getPageMode(request);

	  // STGAP00017831: form parameter variable defaulted to the old form parameters
      boolean bDocumentExists = false;
      String szTxtDocType = "fcm06o00";

      // The PUP Outcome Type radio button values are mapped to the following codes:
      // PUP/Homestead - Imminent Risk of Placement : HRP
      // PUP/Homestead - Immediate Reunification : HRU
      // High Risk/Parent Aid : HPA
      // Short Term/Preventative Parent Aid/Early Intervention : SPE

      // SIR 17603 Display the approval status button if the service
      // auth has been submitted for approval.
      if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
        disableApprovalStatus = "false";
      }

      if (ccon18so == null) {
        ccon18so = new CCON18SO();
      } else {
        if (ccon18so.getROWCCMN01UIG00() != null) {
          rowccmn01uig00 = ccon18so.getROWCCMN01UIG00();
          if (EVENT_STATUS_APPROVE.equals(rowccmn01uig00.getSzCdEventStatus()) || GlobalData.isApprovalMode(request)) {
            secondEditableMode = EditableMode.NONE;
          }

        } else {
          rowccmn01uig00 = new ROWCCMN01UIG00();
        }
        szCdSvcAuthCounty = ccon18so.getSzCdSvcAuthCounty();
        szCdSvcAuthCategory = ccon18so.getSzCdSvcAuthCategory();
        szNmResource = ccon18so.getSzNmResource();
        ulIdResource = ccon18so.getUlIdResource();
        ulIdContract = ccon18so.getUlIdContract();
        szCdPayCnty = ccon18so.getSzCdPayCnty();
        szCdPupOtcme = ccon18so.getSzCdPupOtcme();
        szCdPupTyp = ccon18so.getSzCdPupTyp();
        szCdSvcAuthService = ccon18so.getSzCdSvcAuthService();
        //Check if the user is returning from Policy Waiver pullback and set the appropriate waiver id.
        // STGAP00008182 Checking to see if the pullback has saved a waiver id if so then check the 
        // waiver required checkbox
        if (IND_POLICY_WAIVER.equals(reqPullBack)) {
          String tempWaiverId = (String) (request.getParameter("actionEventId"));
          if(!"".equals(tempWaiverId) && tempWaiverId!=null){
          ulIdWaiverId = Integer.parseInt(tempWaiverId);
          ccon18so.setCIndWaiverReqd("Y");
          }
        } else {
          ulIdWaiverId = ccon18so.getUlIdWaiver();
          		if(0 < ulIdWaiverId){
          		 ccon18so.setCIndWaiverReqd("Y");
          		 }
        }
      }

      // Because these two dropdowns are dynamic, fill their values with
      // the value from the request if it was not available from ccon18so.
      if (("").equals(szCdSvcAuthCounty) || szCdSvcAuthCounty == null) {
        szCdSvcAuthCounty = currentCaseCounty;
      }
      if (("").equals(szCdPayCnty) || szCdPayCnty == null) {
      szCdPayCnty = currentCaseCounty;
      }
      if (("").equals(szCdSvcAuthService) || szCdSvcAuthService == null) {
        szCdSvcAuthService = request.getParameter("selSzCdSvcAuthService");
      }

      if (("").equals(szCdSvcAuthCategory) || szCdSvcAuthCategory == null) {
        szCdSvcAuthCategory = request.getParameter("selSzCdSvcAuthCategory");
      }
      if (cres03so != null) {
        szNmResource = cres03so.getSzNmResource();
        ulIdResource = cres03so.getUlIdResource();
      }

      String szIdResource = new Integer(ulIdResource).toString();

      if (ccon21so == null) {
        ccon21so = new CCON21SO();
      }

      if (ccon21so.getROWCCON21SOG00_ARRAY() == null) {
        serviceArray = new ROWCCON21SOG00_ARRAY();
      } else {
        serviceArray = ccon21so.getROWCCON21SOG00_ARRAY();
        int size = serviceArray.getROWCCON21SOG00Count();
        for (int i = 0; i < size; i++) {
          totalAmount = totalAmount + serviceArray.getROWCCON21SOG00(i).getLAmtSvcAuthDtlAmtReq();
        }
        amount = "$" + totalAmount;
      }

      // SIR 19779 If the page mode is not new, place the first client in the list in the
      // dropdown.  This is done so that if there is a person merge problem returned from the
      // service, a person will still be seen in that dropdown.
      if (clientList.size() == 1 || !PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
        Option firstClient = (Option) clientList.get(0);
        listValue = firstClient.getCode();
      } else {
        if (state.getAttribute("primaryClient", request) != null) {
          listValue = (String) state.getAttribute("primaryClient", request);
        }
      }
      // If the page is in new mode, get region from ccon18so, only if it is not null
      // This would only happen after the resource pullback has taken place.  Otherwise
      // Default the field to the user's region.  If the page is not new, use the region
      // from ccon18so (which has been previously saved).
      if (PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {
        if (ccon18so.getSzCdSvcAuthRegion() != null && !"".equals(ccon18so.getSzCdSvcAuthRegion())) {
          szCdSvcAuthRegion = ccon18so.getSzCdSvcAuthRegion();
        } else {
          szCdSvcAuthRegion = FormattingHelper.convertRegionCode(user.getUserRegion());
        }
      } else {

        szCdSvcAuthRegion = ccon18so.getSzCdSvcAuthRegion();
      }
      int ulIdStage = GlobalData.getUlIdStage(request);
      int userID = UserProfileHelper.getUserProfile(request).getUserID();
      if (!CaseUtility.hasStageAccess(userID, ulIdStage)) {
        editableMode = EditableMode.VIEW;
      }
      
      // ECEM:
      Collection<CodeAttributes> uasPrgCodesSA = Lookup.getCategoryCollectionSortedByDecode(CodesTables.CPRGCOD1);
      Iterator itrUasPrgCodesSA = uasPrgCodesSA == null? null : uasPrgCodesSA.iterator();
  
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.attachEvent('onload', updateEntCodes);
function cancelValidation ()
{
  disableValidation('frmServiceHeader');
}
//Added to accomodate the Policy Waiver Pullback.
function setRequest()
{
 cancelValidation();
 document.frmServiceHeader.hdnReqPullBack.value = 'true';
}

function setParms( svcId )
{
 frmServiceHeader.ulIdSvcAuthDtl.value = svcId;
}

function savePage(ulIdSvcAuthDtl)
{
     if (isFormChanged( document.frmServiceHeader ))
     {
       alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) %>');
       return;
     }
     else
     {
       cancelValidation();
       setParms(ulIdSvcAuthDtl);
       submitValidateForm( 'frmServiceHeader', '/financials/ServiceAuth/displayServiceAuthDetail' );
     }
}

function savePageAdd()
{
         if (isFormChanged( document.frmServiceHeader ))
         {
           alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) %>');
           return false;
         }
         else
         {
           cancelValidation();
           return true;
         }
}

 //  Called onUnload of page to remind user unsaved data will be lost
window.onbeforeunload = function ()
{
      IsDirty();
}

function deleteService ()
{
        var bDelete = confirm('<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>');
        if (bDelete)
        {
          cancelValidation();
        }
        return bDelete;
}

function fieldsBlank()
{
     var sEffDate = validateDateString(frmServiceHeader.txtDtDtSvcAuthEff.value);
     
       if (frmServiceHeader.selSzCdSvcAuthPayCounty.value == "" ||
     frmServiceHeader.selSzCdSvcAuthCounty.value == "" ||
           frmServiceHeader.txtDtDtSvcAuthEff.value == "" ||
           frmServiceHeader.selSzCdSvcAuthCategory.value == "" ||
           frmServiceHeader.selSzCdSvcAuthService.value == "" )
       {
       updateEntCodes();
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SVC_AUTH_RSRC) %>');
        return false;
       }
       else if (sEffDate == "INVALID"){
       updateEntCodes();
        alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_ARC_CONSTR_DATE ) %>');
       }
       else
       {
         cancelValidation();
         return true;
       }
}

function returnResourceSearchURL()
{
	var returnURL = '<%= ServiceAuthConversation.SELECT_RESOURCE %>';
	var category = frmServiceHeader.selSzCdSvcAuthCategory.value;
	if (category == '510' || category == '512') {
       var service = frmServiceHeader.selSzCdSvcAuthService.value;
	   if(service != '57' && service != '77') {
	   returnURL = '<%= ServiceAuthConversation.SELECT_ADO_RESOURCE %>';
	  }
	}
	return returnURL;
}

function returnAddURL()
{
	var returnURL = '<%= ServiceAuthConversation.SELECT_ADD %>';
	var category = frmServiceHeader.selSzCdSvcAuthCategory.value;
	if (category == '510' || category == '512') {
	   var service = frmServiceHeader.selSzCdSvcAuthService.value;
	   if(service != '57' && service != '77') {
	   	returnURL = '<%= ServiceAuthConversation.SELECT_ADO_ADD %>';
	   }
	}
	return returnURL;
}

// SIR 22573 CORLEYAN if the page has been changed, inform the user that
// they must save before continuting, if it has not check is radiochecked to
// make sure that a radiobutton from button group is checked before new using.
function isRadioChecked(arrayLength, buttonGroupName)
{
  if (isFormChanged( document.frmServiceHeader ))
  {
    alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SAVE_BEFORE_CONTINUE ) %>');
    return;
  }
  else
  {
    var bRadio = false;
    var listRb = document.getElementsByName(buttonGroupName);
    for ( i = 0; i < arrayLength ; i++ )
    {
      bRadio = listRb[i].checked;
      if ( bRadio )
      {
        break;
      }
    }
    if ( !bRadio )
    {
      alert('<%= MessageLookup.getMessageByNumber( Messages.MSG_SELECT_ROW_ACTION ) %>');
    }
    return bRadio;
  }
}
function updatePupOutcome(index)
{
var fieldId = "rbCIndPupOutCmTyp" +"_Id" + index;
var rBtnField = eval("document.getElementById(\"" + fieldId + "\")");
var checked = rBtnField.checked;
var count = 1;
if(checked)
{
frmServiceHeader.selSzCdPupOtcme.options.length = 3;
if(index == 1)
{
      frmServiceHeader.selSzCdPupOtcme.options[count].value = "APP";
      frmServiceHeader.selSzCdPupOtcme.options[count].text = "Prevented Placement";
      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = "ADP";
      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = "Did Not Prevent Placement";
      
}else if(index==2){
      frmServiceHeader.selSzCdPupOtcme.options[count].value = "BSR";
      frmServiceHeader.selSzCdPupOtcme.options[count].text = "Successful Reunification";
      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = "BUR";
      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = "Unsuccessful Reunification";
      
}else if(index==3){
      frmServiceHeader.selSzCdPupOtcme.options[count].value = "CIM";
      frmServiceHeader.selSzCdPupOtcme.options[count].text = "Improved";
      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = "CNS";
      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = "No Change";
      
}else if(index==4){
      frmServiceHeader.selSzCdPupOtcme.options[count].value = "DDS";
      frmServiceHeader.selSzCdPupOtcme.options[count].text = "Diverted from Social Services";
      frmServiceHeader.selSzCdPupOtcme.options[count +1].value = "DND";
      frmServiceHeader.selSzCdPupOtcme.options[count+1].text = "Not Diverted from Social Services";
}
}
}
// STGAP00017019: ECEM 5.0: replace manual service code list with internal code map built by LookupInit 
// Note that the encode map is built upon initialization or per nightly refresh. Any update to codes tables 
// can only be seen the next day.
// To build the code array based on current code map values as for 5.0 some codes tables for Financials are updated online
<%if (itrUasPrgCodesSA != null) {
	while (itrUasPrgCodesSA.hasNext()) {
	  CodeAttributes codeAttribute = (CodeAttributes)itrUasPrgCodesSA.next();
	  String code = codeAttribute.getCode();
	  String codeName = CodesTables.CENTCODE + code;
	  String arrayName = "codes" + code;
%>
	  <impact:codeArray codeName="<%=codeName %>" arrayName="<%=arrayName %>" blankValue="true" orderBy="decode"/>
  <%}
}
%>

<impact:codeArray codeName="CENTCODE" arrayName="entCodes" blankValue="true" orderBy="decode"/>
function updateEntCodes()
{
var category = frmServiceHeader.selSzCdSvcAuthCategory.value;
var service = frmServiceHeader.selSzCdSvcAuthService.value;
var options = frmServiceHeader.selSzCdSvcAuthService.options;
if(category==""){
//New mode so do not need to filter the entitlement codes dropdown
populateDropdown( frmServiceHeader.selSzCdSvcAuthService , "", entCodes );
}else{
var codeArray = eval("codes" + category);
//STGAP00004585 This condition is added to skip the call to populate drop down 
if(options==null){
//Field is disabled so no need to call the populate drop down
}else{
populateDropdown( frmServiceHeader.selSzCdSvcAuthService , "", codeArray );
}
document.frmServiceHeader.selSzCdSvcAuthService.value=service;
}
}

</script>
<%//End Javascript Section

      %>

<%
/* Assign tab-index */
      int tabIndex = 1;
%>
<impact:validateErrors />
<impact:validateForm name="frmServiceHeader" method="post" action="/financials/ServiceAuth/saveServiceAuthHeader" pageMode="<%=PageMode.getPageMode( request )%>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.ServiceAuthHeaderCustomValidation"
	schema="/WEB-INF/Constraints.xsd">
	<impact:validateInput type="hidden" name="hdnReqPullBack" value="" />
	<%/* Begin Detail */

      %>
	<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus" form="frmServiceHeader" action="<%=ApprovalStatusConversation.DISPLAY_URI%>" navAwayCk="true" disabled="<%=disableApprovalStatus%>" editableMode="<%= EditableMode.ALL %>"
		tabIndex="<%=tabIndex%>" />

	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<%/* SIR 17858 added expand all and collapse all */

      %>
				<a tabIndex="<%= tabIndex++ %>" onClick=" setIsDirtyCalled( true )" href="javascript: expandAll()">Expand All</a>&nbsp; <a tabIndex="<%= tabIndex++ %>" onClick=" setIsDirtyCalled( true )" href="javascript: collapseAll()">Collapse All</a>&nbsp;
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
		<tr>
			<th colspan="6">
				Resource Search Criteria
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateSelect label="County" style="WIDTH: 125px" onChange="frmServiceHeader.hdnIndRsrcSelected.value = 'N' " value="<%=FormattingHelper.formatString(szCdSvcAuthCounty)%>" name="selSzCdSvcAuthCounty" required="true"
					editableMode="<%= EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" codesTable="CCOUNT" />
			</td>
			<td>
				<impact:validateDate name="txtDtDtSvcAuthEff" label="Effective" constraint="Date" required="true" onChange="frmServiceHeader.hdnIndRsrcSelected.value = 'N' " value="<%=FormattingHelper.formatDate(ccon18so.getDtDtSvcAuthEff())%>"
					editableMode="<%= EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>

			<td width="90%">
				<impact:validateSelect label="UAS Program" onChange="frmServiceHeader.hdnIndRsrcSelected.value = 'N'" value="<%= szCdSvcAuthCategory %>" name="selSzCdSvcAuthCategory" required="true" tabIndex="<%= tabIndex++ %>"
					onChange="updateEntCodes();" editableMode="<%= EditableMode.NEW %>" codesTable="CPRGCOD1" />
			</td>
		</tr>

		<tr>
			<td width="80%">
				<impact:validateSelect label="Entitlement Code" colspan="2" onChange="frmServiceHeader.hdnIndRsrcSelected.value = 'N' " value="<%=FormattingHelper.formatString(szCdSvcAuthService)%>" name="selSzCdSvcAuthService" required="true"
					tabIndex="<%= tabIndex++ %>" editableMode="<%= EditableMode.NEW %>" codesTable="CENTCODE" />
			</td>
			<td width="20%">
				<impact:ButtonTag name="btnSelectResource" img="btnSelectResource" function="fieldsBlank();" form="frmServiceHeader" action="return returnResourceSearchURL()" editableMode="<%= EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" align="right" />
			</td>
		</tr>
		<tr>
			<td width="50%">
				<impact:validateSelect label="Payment County" style="WIDTH: 125px" onChange="frmServiceHeader.hdnIndRsrcSelected.value = 'N' " value="<%=FormattingHelper.formatString(szCdPayCnty)%>" name="selSzCdSvcAuthPayCounty" required="true"
					editableMode="<%= EditableMode.NEW %>" tabIndex="<%= tabIndex++ %>" codesTable="CCOUNT" />
			</td>
		</tr>


		<tr>
			<th colspan="6">
				Resource Information
			</th>
		</tr>

		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmResource" label="Resource Name" value="<%=FormattingHelper.formatString(szNmResource)%>" />
			</td>

			<td>
				<impact:validateInput checked="<%=FormattingHelper.formatString(ccon18so.getCIndWaiverReqd()) %>" editableMode="<%= secondEditableMode %>" tabIndex="<%= tabIndex++ %>" type="checkbox" name="cbxIndWaiverReqd" value="Y" label="Waiver Required"
					cssClass="formInput" />
			</td>
		</tr>

		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspUlIdResource" label="Resource ID" value="<%=FormattingHelper.formatInt(ulIdResource)%>" />
			</td>

			<td>
				<impact:validateDisplayOnlyField name="dspUlIdWaiver" label="Waiver ID" conditionallyRequired="true" value="<%= FormattingHelper.formatInt(ulIdWaiverId)%>" />
			</td>

			<td>
				<impact:ButtonTag name="btnSelectWaiver" img="btnSelectWaiver" function="setRequest()" form="frmServiceHeader" action="/financials/ServiceAuth/selectWaiver" editableMode="<%= secondEditableMode %>" tabIndex="<%= tabIndex++ %>" />
			</td>

		</tr>

		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspUlIdContract" label="Contract ID" value="<%=FormattingHelper.formatInt(ulIdContract)%>" />
			</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<th colspan="6">
				Information to the Provider
			</th>
		</tr>

		<tr>
			<td colspan="2">
				<span class="formRequiredText">*</span>
				<impact:validateSelect colspan="2" label="Primary Client for Delivery of Services" editableMode="<%= secondEditableMode %>" options="<%=clientList%>" value="<%=FormattingHelper.formatString(listValue)%>" name="selUlIdPrimaryClient"
					tabIndex="<%= tabIndex++ %>" style="WIDTH: 175px" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateInput colspan="2" type="text" label="Preferred Subcontractor" constraint="Paragraph" name="txtSzTxtSvcAuthSecProvdr" cssClass="formInput" editableMode="<%= secondEditableMode %>"
					value="<%=FormattingHelper.formatString(ccon18so.getSzTxtSvcAuthSecProvdr())%>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateDate colspan="2" name="txtDtRefSent" label="Date Referral Sent" constraint="Date" value="<%=FormattingHelper.formatDate(ccon18so.getDtDtRefSent())%>" editableMode="<%= secondEditableMode %>" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<impact:validateDisplayOnlyField colspan="2" name="dspTxtAmtAuthd" label="Total Amount Authorized" value="<%= amount %>" />
			</td>
		</tr>
		<!-- STGAP00017831: Renamed the field label from "Reason for Referral" to "Justification for Referral (For Supervisory Review Only)", moved the field under a new header and to increase the field size to 1000 characters -->		
		<tr>
			<th colspan="6">
				Justification for Referral (For Supervisory Review Only)
			</th>
		</tr>
		<tr>
			<td colspan="1">
				<impact:validateTextArea colspan="5" name="txtSzTxtSvcAuthComments" label="Justification for Referral" rows="3" maxLength="1000" cols="130" editableMode="<%= secondEditableMode %>" tabIndex="<%= tabIndex++ %>" constraint="Paragraph1000">
					<%=FormattingHelper.formatString(ccon18so.getSzTxtSvcAuthComments())%>
				</impact:validateTextArea>
			</td>
		</tr>
	</table>


	<br>

	<%// This list should only be displayed after the header has been saved (the page is not in new mode)
      // SIR 23538 Only display the Service Authorization list if the service is not donated
      if (!PageModeConstants.NEW.equals(PageMode.getPageMode(request))) {

        %>

	<impact:ExpandableSectionTag name="pupInfo" label="PUP and Outcome Information" tabIndex="<%= tabIndex++ %>" id="">
		<div class="alignRight"></div>

		<table width="100%" cellspacing="0" cellpadding="3">
			<tr class="subDetail">
				<td>
					<impact:validateSelect label="Early Intervention Case Type" value="<%=FormattingHelper.formatString(ccon18so.getSzCdErlyCaseTyp())%>" name="selSzCdSvcAuthEICaseType" conditionallyRequired="true" disabled="false"
						editableMode="<%= secondEditableMode %>" tabIndex="<%= tabIndex++ %>" codesTable="CELYINTV" />
				</td>
			</tr>
			<tr class="subDetail">
				<td width="40%">
					<span class="formCondRequiredText">&#135;</span>Outcome Type:
				</td>
				<td>
					<%int index1 = 1;
        String reset1 = "updatePupOutcome('" + index1 + "');";

        %>
					<impact:validateInput checked="<%= "HRP".equals(szCdPupTyp)? "true":"false" %>" disabled="false" tabIndex="<%= tabIndex++ %>" value="HRP" type="radio" name="rbCIndPupOutCmTyp" editableMode="<%= secondEditableMode %>" onChange="<%= reset1 %>"
						label="PUP/Homestead - Imminent Risk of Placement" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
				<td></td>
				<td>
					<%int index2 = 2;
        String reset2 = "updatePupOutcome('" + index2 + "');";

        %>
					<impact:validateInput checked="<%= "HRU".equals(szCdPupTyp)? "true":"false"%>" disabled="false" tabIndex="<%= tabIndex++ %>" value="HRU" type="radio" name="rbCIndPupOutCmTyp" editableMode="<%= secondEditableMode %>" onChange="<%= reset2 %>"
						label="PUP/Homestead - Immediate Reunification" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
				<td></td>
				<td>
					<%int index3 = 3;
        String reset3 = "updatePupOutcome('" + index3 + "');";

        %>
					<impact:validateInput checked="<%= "HPA".equals(szCdPupTyp)? "true":"false"%>" disabled="false" tabIndex="<%= tabIndex++ %>" value="HPA" type="radio" name="rbCIndPupOutCmTyp" editableMode="<%= secondEditableMode %>" label="High Risk/Parent Aide"
						onChange="<%= reset3 %>" cssClass="formInput" />
				</td>
			</tr>
			<tr class="subDetail">
				<td></td>
				<td>
					<%int index4 = 4;
        String reset4 = "updatePupOutcome('" + index4 + "');";

        %>
					<impact:validateInput checked="<%="SPE".equals(szCdPupTyp)? "true":"false"%>" disabled="false" tabIndex="<%= tabIndex++ %>" value="SPE" type="radio" name="rbCIndPupOutCmTyp" editableMode="<%= secondEditableMode %>" onChange="<%= reset4 %>"
						label="Short Term/Preventative Parent Aide/Early Intervention" cssClass="formInput" />
				</td>
			</tr>
<% if(szCdPupTyp!=null && !"".equals(szCdPupTyp)){
Hashtable<String,String> excludeList = new Hashtable<String,String>();
        if("HRP".equals(szCdPupTyp)){
            excludeList.put("Successful Reunification", CodesTables.CPPOUTCM_BSR);
            excludeList.put("Unsuccessful Reunification", CodesTables.CPPOUTCM_BUR);
            excludeList.put("Improved", CodesTables.CPPOUTCM_CIM);
            excludeList.put("No Change", CodesTables.CPPOUTCM_CNC);
            excludeList.put("Diverted from Social Services", CodesTables.CPPOUTCM_DDS);
            excludeList.put("Not Diverted from Social Services", CodesTables.CPPOUTCM_DND);
        }else if("HRU".equals(szCdPupTyp)){
           excludeList.put("Prevented Placement", CodesTables.CPPOUTCM_APP);
            excludeList.put("Did Not Prevent Placement", CodesTables.CPPOUTCM_ADP);
            excludeList.put("Improved", CodesTables.CPPOUTCM_CIM);
            excludeList.put("No Change", CodesTables.CPPOUTCM_CNC);
            excludeList.put("Diverted from Social Services", CodesTables.CPPOUTCM_DDS);
            excludeList.put("Not Diverted from Social Services", CodesTables.CPPOUTCM_DND); 
        }else if("HPA".equals(szCdPupTyp)){
            excludeList.put("Prevented Placement", CodesTables.CPPOUTCM_APP);
            excludeList.put("Did Not Prevent Placement", CodesTables.CPPOUTCM_ADP);
            excludeList.put("Successful Reunification", CodesTables.CPPOUTCM_BSR);
            excludeList.put("Unsuccessful Reunification", CodesTables.CPPOUTCM_BUR);
            excludeList.put("Diverted from Social Services", CodesTables.CPPOUTCM_DDS);
            excludeList.put("Not Diverted from Social Services", CodesTables.CPPOUTCM_DND); 
        }else if("SPE".equals(szCdPupTyp)){
            excludeList.put("Prevented Placement", CodesTables.CPPOUTCM_APP);
            excludeList.put("Did Not Prevent Placement", CodesTables.CPPOUTCM_ADP);
            excludeList.put("Successful Reunification", CodesTables.CPPOUTCM_BSR);
            excludeList.put("Unsuccessful Reunification", CodesTables.CPPOUTCM_BUR);
            excludeList.put("Improved", CodesTables.CPPOUTCM_CIM);
            excludeList.put("No Change", CodesTables.CPPOUTCM_CNC); 
        }%>
        <tr class="subDetail">
				<td>
					<impact:validateSelect label="Outcome" style="WIDTH: 190px" value="<%=FormattingHelper.formatString(ccon18so.getSzCdPupOtcme())%>" name="selSzCdPupOtcme" conditionallyRequired="true" disabled="false" tabIndex="<%= tabIndex++ %>"
						excludeOptions="<%= excludeList.values() %>" editableMode="<%= editableMode %>" codesTable="CPPOUTCM" />
				</td>
			</tr>
        <%}else{%>
			<tr class="subDetail">
				<td>
					<impact:validateSelect label="Outcome" style="WIDTH: 190px" value="<%=Lookup.simpleDecodeSafe(CodesTables.CPPOUTCM, FormattingHelper.formatString(ccon18so.getSzCdPupOtcme()))%>" name="selSzCdPupOtcme" conditionallyRequired="true" disabled="false" tabIndex="<%= tabIndex++ %>"
						editableMode="<%= editableMode %>" codesTable="" />
				</td>
			</tr>
			<%}%>
		</table>
	</impact:ExpandableSectionTag>
	<br>
	<%// Service Auth List
        String listTab = "";
        int loopCount = 0;
        ROWCCON21SOG00 serviceRow = null;
        Enumeration serviceEnumeration = serviceArray.enumerateROWCCON21SOG00();
        if (!serviceEnumeration.hasMoreElements()) {
          listTab = "btnAdd_Id";
        } else {
          listTab = "listLinks0";
        }
%>
	<impact:ExpandableSectionTag name="svcList" label="Service Authorization List" tabIndex="<%= tabIndex++ %>" id="<%=listTab%>">
		<div class="alignRight">
			<div class="formInstruct">
				Scroll for more information 
			</div>
		</div>
		<div id="scrollBar" style="height:165px;width:763px;overflow:auto" class="tableborderList">
			<table width="1200" cellspacing="0" cellpadding="3">
				<tr>
					<%// Only show the radio buttons if the service is not complete
        if (!PageModeConstants.VIEW.equals(PageMode.getPageMode(request))
            && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {

        %>
					<th class="thList"></th>
					<%}

        %>
					<th class="thList">
						SA Detail ID
					</th>
					<th class="thList">
						Name
					</th>
					<th class="thList">
						Service Description
					</th>
					<th class="thList">
						Requested Units
					</th>
					<th class="thList">
						Begin
					</th>
					<th class="thList">
						Term
					</th>
					<th class="thList">
						End
					</th>
					<th class="thList">
						Auth Type
					</th>
					<th class="thList">
						Amount
					</th>
					<th class="thList">
						Unit Type
					</th>
					<th class="thList">
						Period
					</th>
					<th class="thList">
						Frequency
					</th>
					<th class="thList">
						Sugg Units
					</th>
					<th class="thList">
						Units Used
					</th>
				</tr>
				<%
if (!serviceEnumeration.hasMoreElements()) {
%>
				<tr class="odd">
					<td colspan="10">
						<%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
					</td>
				</tr>
				<%
} else {
          while (serviceEnumeration.hasMoreElements()) {
            hasRow = "T";
            serviceRow = (ROWCCON21SOG00) serviceEnumeration.nextElement();

            %>
				<tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
					<%// Only show the radio buttons if the service is not complete
            if (!PageModeConstants.VIEW.equals(PageMode.getPageMode(request))
                && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {

              %>
					<td>
						<impact:validateInput type="radio" name="rbRowsIndex_CLEAN" id='<%="incRadio" + loopCount%>' editableMode="<%= EditableMode.EDIT %>" value="<%=String.valueOf(loopCount)%>" tabIndex="0" cssClass="formInput" />
					</td>
					<%}

            %>
					<td>
						<a id='<%="listLinks" + loopCount%>' tabIndex="<%= tabIndex++ %>" href="javascript:savePage( '<%= serviceRow.getUlIdSvcAuthDtl() %>');"><%=FormattingHelper.formatInt(serviceRow.getUlIdSvcAuthDtl())%></a>
					</td>
					<td>
						<%=FormattingHelper.formatString(serviceRow.getSzNmPersonFull())%>
					</td>
					<td>
						<%=Lookup.simpleDecodeSafe("CSVCCODE", serviceRow.getSzCdSvcAuthDtlSvc())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatDouble(serviceRow.getLNbrSvcAuthDtlUnitReq(), 2)%>
					</td>
					<td>
						<%=FormattingHelper.formatDate(serviceRow.getDtDtSvcAuthDtlBegin())%>
					</td>
					<td>
						<%=FormattingHelper.formatDate(serviceRow.getDtDtSvcAuthDtlTerm())%>
					</td>
					<td>
						<%=FormattingHelper.formatDate(serviceRow.getDtDtSvcAuthDtlEnd())%>
					</td>
					<td>
						<%=FormattingHelper.formatString(serviceRow.getSzCdSvcAuthDtlAuthType())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatMoney(serviceRow.getLAmtSvcAuthDtlAmtReq())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatString(serviceRow.getSzCdSvcAuthDtlUnitType())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatString(serviceRow.getSzCdSvcAuthDtlPeriod())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatDouble(serviceRow.getUNbrSvcAuthDtlFreq())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatDouble(serviceRow.getLNbrSvcAuthDtlSugUnit())%>
					</td>
					<td class="alignLeft">
						<%=FormattingHelper.formatDouble(serviceRow.getLNbrSvcAuthDtlUnitUsed())%>
					</td>
				</tr>
				<%
loopCount++;
          } // end for
        }

        %>
			</table>
		</div>
		<%// Only show the pushbuttons if the service is not complete
        if (!PageMode.getPageMode(request).equals(PageModeConstants.VIEW)
            && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())) {

          %>
		<table width="100%" cellpadding="0" cellspacing="3">
			<tr>
				<%// SIR 22573 - If there is a row in the list, display the new using button
          if ("T".equals(hasRow) ) {

            %>
				<td width="90%">
					<%
String functionString = "cancelValidation(); return isRadioChecked( " + loopCount
                                    + ", 'rbRowsIndex_CLEAN' );";%>
					<div class="alignRight">
						<impact:ButtonTag name="btnNewUsing" img="btnNewUsing" navAwayCk="true" form="frmServiceHeader" function="<%=functionString%>" action="/financials/ServiceAuth/displayServiceAuthDetail" editableMode="<%= EditableMode.EDIT %>"
							tabIndex="<%= tabIndex++ %>" />
					</div>
				</td>
				<%
}

          if(!GlobalData.isApprovalMode(request)){%>
				<td width="10%">
					<div class="alignRight">
						<impact:ButtonTag name="btnAddDetail" editableMode="<%= EditableMode.EDIT %>" img="btnAdd" form="frmServiceHeader" navAwayCk="false" function="return savePageAdd()" action="return returnAddURL()" tabIndex="<%= tabIndex++ %>" />
					</div>
				</td>
				<%}%>
			</tr>
		</table>
		<%
}

      %>
	</impact:ExpandableSectionTag>
	<%}

      %>

	<br />

	<impact:include page="/submodule/SubcontractorSub/displaySubcontractorList" callingPage="/financials/ServiceAuth/displayServiceAuthHeader" includingForm="frmServiceHeader" tabIndex="<%=tabIndex++%>">

		<impact:attribute name="SubcontractorSubvidResource" value="<%=szIdResource%>" />
		<impact:attribute name="SubcontractorSubvpredisplay" value="true" />
		<impact:attribute name="SubcontractorSubvviewOnly" value="true" />
	</impact:include>

	<br />


	<hr>
	<table width="100%" border="0" cellspacing="0" cellpadding="3" cellspacing="0">
		<tr>
			<td width="85%">
				<%// Only show the delete pushbutton if it is not new or view mode, and if the service is not complete
      // Always show the table cell whether the button shows or not - SPB
      if ((!PageMode.getPageMode(request).equals(PageModeConstants.VIEW) && !PageMode.getPageMode(request)
                                                                                     .equals(PageModeConstants.NEW))
          && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())&& !GlobalData.isApprovalMode(request)) {
%>
				<impact:ButtonTag name="btnDelete" restrictRepost="true" function="return deleteService()" img="btnDelete" form="frmServiceHeader" editableMode="<%= EditableMode.EDIT %>" action="/financials/ServiceAuth/deleteAuthHeader" tabIndex="<%= tabIndex++ %>" />
				<%}

      %>
			</td>
			<%
// SIR 17944 GRIMSHAN -- Do not show the save and submit button if the page mode is new
      // SIR 16978 GRIMSHAN -- Since the page can be in modify mode when the Event is approved, we need
      // to make sure that the save and submit button never displays when the event status is approved.
      // SIR 17678 GRIMSHAN -- Do not show the save and submit button if the page mode is approval.
      // SIR 23538 Only display the Save and Submit Button if the service is not donated.
      if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW)
          && !EVENT_STATUS_APPROVE.equals(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus())
          && !GlobalData.isApprovalMode(request)) {
%>
			<td width="10%">
				<impact:ButtonTag name="btnSaveSubmit" img="btnSaveAndSubmit" restrictRepost="true" function="enableValidation( 'frmServiceHeader' )" align="right" form="frmServiceHeader" editableMode="<%= EditableMode.EDIT %>"
					action="/financials/ServiceAuth/saveServiceAuthHeader" tabIndex="<%= tabIndex++ %>" />
			</td>
			<%}

     if(!GlobalData.isApprovalMode(request)){ %>
			<td width="5%">
				<impact:ButtonTag name="btnSave" img="btnSave" align="right" restrictRepost="true" function="enableValidation( 'frmServiceHeader' );" form="frmServiceHeader" editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
					action="/financials/ServiceAuth/saveServiceAuthHeader" tabIndex="<%= tabIndex++ %>" />
			</td>
			<%}%>
		</tr>
	</table>

	<%--  Include any hidden fields needed on the page
      Hidden fields are used for variables passed into the page as request parameters
      AND for hidden fields that need to be used for saving or deleting the detail on this page.
  --%>
	<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= DateHelper.toISOString(ccon18so.getTsLastUpdate()) %>" />
	<impact:validateInput type="hidden" name="hdnEventTsLastUpdate" value="<%= DateHelper.toISOString(rowccmn01uig00.getTsLastUpdate()) %>" />
	<impact:validateInput type="hidden" name="hdnUlIdSvcAuth" value="<%= FormattingHelper.formatInt(ccon18so.getUlIdSvcAuth())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtSituationOpened" value="<%= FormattingHelper.formatDate(ccon18so.getDtDtSituationOpened())%>" />
	<impact:validateInput type="hidden" name="hdnDtDtStageClose" value="<%= FormattingHelper.formatDate(ccon18so.getDtDtStageClose())%>" />
	<impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>" />
	<impact:validateInput type="hidden" name="hdnIndDifRegion" value="" />
	<impact:validateInput type="hidden" name="ulIdSvcAuthDtl" value="" />
	<impact:validateInput type="hidden" name="hdnHasRow" value="<%=FormattingHelper.formatString(hasRow)%>" />
	<impact:validateInput type="hidden" name="hdnIndRsrcSelected" value="<%=FormattingHelper.formatString(indRsrcSelected) %>" />
	<impact:validateInput type="hidden" name="hdnStageProgram" value="<%=FormattingHelper.formatString(GlobalData.getSzCdStageProgram ( request )) %>" />
	<%/*  Always include this hidden field in your form */

      %>
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>
<%/* Close Validate Form Custom Tag */

      %>

<%
//*****************
      //**** REPORTS ****
      //*****************
      %>
<%
boolean hideAPSFrm = true;
      boolean hideCPSFrm = true;

      if ("CPS".equals(GlobalData.getSzCdStageProgram(request))) {
        hideCPSFrm = false;
      }
      if ("APS".equals(GlobalData.getSzCdStageProgram(request))) {
        hideAPSFrm = false;
      }

      %>

<%/* Do not show the forms and reports section unless the header has been saved as complete */
      if (!PageMode.getPageMode(request).equals(PageModeConstants.NEW)) {

        %>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
	<tr>
		<th colspan="2">
			Forms
		</th>
	</tr>
	<tr>
		<td>
			<impact:documentList tabIndex="<%= tabIndex++ %>" pageMode="<%= PageModeConstants.EDIT %>">
				<impact:document displayName="Service Authorization" docType="fcm06o00" docExists="false" protectDocument="true" postInSameWindow="false" promptSavePage="frmServiceHeader" hideInWidget="<%=hideCPSFrm%>">
					<impact:documentParameter name="pEvent" value="<%= String.valueOf( GlobalData.getUlIdEvent( request ) )  %>" />
					<impact:documentParameter name="pStage" value="<%= String.valueOf( GlobalData.getUlIdStage( request ) )  %>" />
					<impact:documentParameter name="pSvcAuth" value="<%= FormattingHelper.formatInt(ccon18so.getUlIdSvcAuth())%>" />
				</impact:document>
				<impact:document displayName="Service Authorization" docType="fcm06o00v2" docExists="false" protectDocument="false" postInSameWindow="false" promptSavePage="frmServiceHeader" hideInWidget="<%=hideCPSFrm%>">
					<impact:documentParameter name="pEvent" value="<%= String.valueOf( GlobalData.getUlIdEvent( request ) )  %>" />
					<impact:documentParameter name="pStage" value="<%= String.valueOf( GlobalData.getUlIdStage( request ) )  %>" />
					<impact:documentParameter name="pCase" value="<%= String.valueOf( GlobalData.getUlIdCase( request ) )  %>" />
					<impact:documentParameter name="pSvcAuth" value="<%= FormattingHelper.formatInt(ccon18so.getUlIdSvcAuth())%>" />
				</impact:document>
				<impact:document displayName="Emergency Client Service Referral" docType="ccn02o00" docExists="false" protectDocument="true" postInSameWindow="false" promptSavePage="frmServiceHeader" hideInWidget="<%=hideAPSFrm%>">
					<impact:documentParameter name="pEvent" value="<%= String.valueOf( GlobalData.getUlIdEvent( request ) )  %>" />
				</impact:document>
			</impact:documentList>
		</td>
	</tr>
</table>
<br>
<%} /* end if in new mode or employee mode, don't display forms or reports */

    %>

