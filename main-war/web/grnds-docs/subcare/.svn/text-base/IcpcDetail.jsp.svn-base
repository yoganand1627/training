<%
  //
  //----------------------------------------------------------------------------
  //*  JSP Name:     Icpc Detail - ICPC Detail in SHINES
  //*  Created by:   Ashwini Rege
  //*  Date Created: 12/28/2011
  //*
  //*  Description:
  //*  This JSP is used to maintain a ICPC Detail Page information
  //*   Change History:
  //*   Date         User      Description
  //*   --------   --------    --------------------------------------------------
  //*   12/28/2011  arege	    STGAP00017827: MR-085 Initial Creation
  //*   01/27/2012  arege	    STGAP00017827: MR-085 Changes
  //*   02/02/2012  arege       STGAP00017827: MR-085 Changes
  //*   02/02/2012  arege       STGAP00017827: MR-085 Do not display complete button when event status is COMP
  //*   02/02/2012  arege       STGAP00017827: MR-085 Made formatting changes
  //*   02/03/2012  hjbaptiste  STGAP00017827: MR-085 When user clicks into any of the Address fields, displaying
  //*                           javascript alert that indicates modification can only be made on the selected person's 
  //*                           Person Detail page. Added javascript message. Turn Address fields into input text fields.
  //*                           In the process of fixing formatting of page.
  //*   02/02/2012  arege       STGAP00017827: MR-085 Added ? hyperlink to display Reference Guide for ICPC Forms
  //*   02/02/2012  hjbaptiste  STGAP00017827: MR-085 Made additional Formatting changes
  //*   02/06/2012  hjbaptiste  STGAP00017827: MR-085 Finish formatting for Form 100B
  //*   02/06/2012  arege       STGAP00017827: Mr-085 Fixed saving of iveDeterm and Adoption fields to database and removed hidden field for iveDetem
  //*   02/07/2012  arege       STGAP00017827: Mr-085 Right aligned the External Documentation hyperlink, added conditionally reqd sign to adoption field and 
  //*                           correct format for dt last updated
  //*   02/09/2012  arege       STGAP00017827: Modified Case manager's section to correctly align the date last updated and date completed fields.
  //*   02/09/2012  arege       STGAP00017827: Added 'or resource' to the Address fields pop-up message.
  //*   02/10/2012  arege       STGAP00017827: Removed an extra ; at line 256, this will prevent 'Are you sure you want to navigate away...' message to be displayed 
  //*                           if the page is not dirty.
  //*   02/13/2012  arege       STGAP00017827: Added hidden field dspIVEDeterm so that the validation for Title IV-E Determination is displayed correctly.
  //*   02/14/2012  arege       STGAP00017898: Page is saved on change of primary person or Resource so that the related address fields are prepopulated and 
  //*                           correctly aligned mother and father name fields.
  //*   02/16/2012  arege       STGAP00017910: Added maxLength="300" to widget txtOtherTermRsn to resolve system error
  //*   02/21/2012  arege       STGAP00017827: After confirming with Pat, made all the 'required' fields to be validated on click of Save.
  //*   02/27/2012  arege       STGAP00017958: Changed the label from  "Name of Person(s) with whom child is to be placed" to "Name of Person(s) with whom Child is to be placed"
  //*   02/29/2012  arege       STGAP00017960: Adoption Subsidy value should not display the decode value
  //*   02/29/2012  arege       STGAP00017956 and STGAP00017948: Added functions onChangeOfPrimary(), onChangeOfSpouse(), onChangeOfResource()
  //*   03/02/2012  arege       STGAP00017961: Adoption value should display for Adoptive Home Study alone
  //*   03/02/2012  arege       STGAP00017975: Increased Street field length
  //*   03/05/2012  arege       STGAP00017956: Increased Phone field length to display extension
  //*   03/07/2012  arege       STGAP00017977: Checkboxes and radio buttons should be enabled only if the corresponding compact placement termination reason is selected.
  //*   03/11/2012  arege       STGAP00018011: Disable validation on Save so that the page can be saved even if the required fields are not entered.
  //*   03/12/2012  arege       STGAP00018019: ICPC 100A To Be Finalized In incorrectly has conditionally required sign
  //*   03/12/2012  vcollooru	STGAP00018018: Modified to fix the alignment issue of the fiels associated with Adoptive Home Study and also modified the js associated with these elements to retrieve them based on the name instead of id.
  //*   04/19/2012  arege       STGAP00017951: Street, City , State , Zip and Phone fields are not required on Save
  //*   04/23/2012  schoi       STGAP00018065: MR-104 Updated JSP fields and added Delete button and Forms section 
  //*                           to launch the ICPC Form 100A/ICPC Form 100B
  //*
  //**
%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailRetrieveSO"%>      
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.Date"%>


<%
   
  int tabIndex = 1;

  String CD_INITIAL_PLACEMENT ="I";
  String CD_PLACEMENT_CHANGE = "C";
  UserProfile userProfile = UserProfileHelper.getUserProfile(request);
  int userId = userProfile.getUserID();

  String pageMode = PageModeConstants.MODIFY;
    if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }
  boolean displayFormType = true;
  boolean displayContinue = true;
  boolean save = true;
  String disableComplete = ArchitectureConstants.FALSE;
  // STGAP00018065: MR-104 
  // Delete button
  String disableDelete = ArchitectureConstants.FALSE;

  String disableICPCFormType = "false";
  String formType = "";

  String dtDtEventOccurred = "";
  int ulIdEvent = 0;
  int ulIdStage = 0;
  int ulIdPerson = 0;
  String szTxtEventDescr = StringHelper.EMPTY_STRING;
  String szCdTask = StringHelper.EMPTY_STRING;
  String szCdEventStatus = StringHelper.EMPTY_STRING;
  String evtsLastUpdate = StringHelper.EMPTY_STRING;
  String childName = StringHelper.EMPTY_STRING;
  String szCdEventType = StringHelper.EMPTY_STRING;

  String nmFirst = StringHelper.EMPTY_STRING;
  String nmLast = StringHelper.EMPTY_STRING;
  String nmMiddle = StringHelper.EMPTY_STRING;
  Date DOB = null;
  String cdGender = StringHelper.EMPTY_STRING;
  String ssn = StringHelper.EMPTY_STRING;
  String cdRace = StringHelper.EMPTY_STRING;
  String cdEthnicity = StringHelper.EMPTY_STRING;
  String cdIVEDetermination = StringHelper.EMPTY_STRING;
  String nmMotherFull = StringHelper.EMPTY_STRING;
  String nmFatherFull = StringHelper.EMPTY_STRING;
  String indICWAEligible = StringHelper.EMPTY_STRING;
  String relationship = StringHelper.EMPTY_STRING;
  String szDtComplete = StringHelper.EMPTY_STRING;
  String nmCaseManager = StringHelper.EMPTY_STRING;
  String szDtLastUpdate = StringHelper.EMPTY_STRING;
  String cdTypeOfCare = StringHelper.EMPTY_STRING;
  String indPlacementStatus = StringHelper.EMPTY_STRING;
  String dtPlacedRecState = StringHelper.EMPTY_STRING;
  String dtEffectDtChange = StringHelper.EMPTY_STRING;
  String idPrimaryPerson = StringHelper.EMPTY_STRING;
  String idSpouse = StringHelper.EMPTY_STRING;
  String sideOfFamily = StringHelper.EMPTY_STRING;
  String ssnPrimary = StringHelper.EMPTY_STRING;
  String ssnSpouse = StringHelper.EMPTY_STRING;  
  String addrStreetLn1 = StringHelper.EMPTY_STRING;
  String addrStreetLn2 = StringHelper.EMPTY_STRING;
  String addrCity = StringHelper.EMPTY_STRING;
  String addrState = StringHelper.EMPTY_STRING;
  String addrZip = StringHelper.EMPTY_STRING;
  String phone = StringHelper.EMPTY_STRING;
  String cdInitReportReq = StringHelper.EMPTY_STRING;
  String indFinalizedIn = StringHelper.EMPTY_STRING;
  List<String> savedReqCbx = new ArrayList<String>();
  List<String> savedAplCbx = new ArrayList<String>();
  String cdPlacementTermReason = StringHelper.EMPTY_STRING;
  String indCourtOrderAttachAF = StringHelper.EMPTY_STRING;
  String indCourtOrderAttachLCRP = StringHelper.EMPTY_STRING;
  String indCourtOrderAttachLCGR = StringHelper.EMPTY_STRING;
  String dtDateTermination = StringHelper.EMPTY_STRING;
  Date dtLastUpdate = null;
  String aaFundingDeterm = StringHelper.EMPTY_STRING;
  String indFinalizedDisabled = ArchitectureConstants.FALSE;
  String indFinInAndCrtOrdAttDisabled = ArchitectureConstants.FALSE;
  String disableDtTerm = ArchitectureConstants.FALSE;
  
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  IcpcDetailRetrieveSO icpcDetailRet = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);
  List principalsToDisplayList = (List) state.getAttribute("PRNTODISPLIST", request);
  
  formType = icpcDetailRet.getCdFormType();
  nmFirst = icpcDetailRet.getNmFirst();
  nmMiddle = icpcDetailRet.getNmMiddle();
  nmLast = icpcDetailRet.getNmLast();
  DOB = icpcDetailRet.getDtPersonBirth();
  cdGender = icpcDetailRet.getCdGender();
  ssn = icpcDetailRet.getSsn();
  cdRace =  icpcDetailRet.getCdRace();
  cdEthnicity =  icpcDetailRet.getCdEthnicity();
  cdIVEDetermination = icpcDetailRet.getCdIVEDetermination();
  String dspIVEDeterm = StringHelper.EMPTY_STRING;
  if(CodesTables.CELIGIBI_010.equals(cdIVEDetermination)){
  dspIVEDeterm = "Yes";
  }else if(!StringHelper.isEmptyOrNull(cdIVEDetermination)){
  dspIVEDeterm = "No";
  }else{
  dspIVEDeterm = "Pending";
  }
  
  nmMotherFull = icpcDetailRet.getNmMotherFull();
  nmFatherFull = icpcDetailRet.getNmFatherFull();
  indICWAEligible = icpcDetailRet.getIndICWAEligible();  
  cdTypeOfCare = icpcDetailRet.getCdTypeCare();
  indPlacementStatus = icpcDetailRet.getIndPlcmtStatus();
  dtDateTermination = FormattingHelper.formatDate(icpcDetailRet.getDtTermination());
  if(CD_INITIAL_PLACEMENT.equals(indPlacementStatus)){
  dtPlacedRecState = FormattingHelper.formatDate(icpcDetailRet.getDtChildPlaced());
  }else if(CD_PLACEMENT_CHANGE.equals(indPlacementStatus)){
  dtEffectDtChange = FormattingHelper.formatDate(icpcDetailRet.getDtChildPlaced());
  }
  szDtComplete = FormattingHelper.formatDate(icpcDetailRet.getDtComplete());
  nmCaseManager = icpcDetailRet.getNmCaseManager();

  idPrimaryPerson = String.valueOf(icpcDetailRet.getIdPrimaryPerson());
  relationship = icpcDetailRet.getCdRelPrimaryPerson();
  idSpouse = String.valueOf(icpcDetailRet.getIdSpouse());
  sideOfFamily = icpcDetailRet.getCdSideOfFam();
  ssnPrimary = icpcDetailRet.getSsnPrimaryPerson();
  ssnSpouse = icpcDetailRet.getSsnSpouse();
  addrStreetLn1 = icpcDetailRet.getAddrStreetLn1();
  addrStreetLn2 = icpcDetailRet.getAddrStreetLn2();
  addrCity = icpcDetailRet.getAddrCity();
  addrState = icpcDetailRet.getAddrState();
  addrZip = FormattingHelper.formatString(icpcDetailRet.getAddrZip());
  phone = icpcDetailRet.getNbrPhone();
  cdInitReportReq = icpcDetailRet.getCdInitReportReq();
  indFinalizedIn = icpcDetailRet.getIndFinalizedIn();
  cdPlacementTermReason = icpcDetailRet.getCdPlcmtTermRsn();
  indCourtOrderAttachAF = icpcDetailRet.getIndCrtOrderAf();
  indCourtOrderAttachLCRP = icpcDetailRet.getIndCrtOrderLcrp();
  indCourtOrderAttachLCGR = icpcDetailRet.getIndCrtOrderLcgr();
  aaFundingDeterm = icpcDetailRet.getAaFundingDeterm();
  savedReqCbx = icpcDetailRet.getSavedReqCbx();
  savedAplCbx = icpcDetailRet.getSavedAplCbx();
  //STGAP00017960: Adoption Subsidy value should not display the decode value
  if(CodesTables.CAAFDTYP_IVE.equals(aaFundingDeterm)){
  aaFundingDeterm = "IV-E Subsidy";
  }else if(CodesTables.CAAFDTYP_PST.equals(aaFundingDeterm)){
  aaFundingDeterm = "Non IV-E Subsidy";
  }  
  
  //STGAP00017961: Adoption value should display for Adoptive Home Study alone
  if (StringHelper.isNotEmptyOrNull(cdInitReportReq) && !CodesTables.CINRPTRQ_IRC.equals(cdInitReportReq)){
  indFinalizedDisabled = ArchitectureConstants.TRUE;
  }
  
  //STGAP00017977: Sending State, Receiving State and Court Order Attached should only be enabled when the Compact Placement Termination reason of Adoption Finalized is selected
  if(StringHelper.isNotEmptyOrNull(cdPlacementTermReason) && !CodesTables.CTERMRSN_TRA.equals(cdPlacementTermReason)){
  indFinInAndCrtOrdAttDisabled = ArchitectureConstants.TRUE;
  }
  
  if(StringHelper.isNotEmptyOrNull(cdPlacementTermReason)){  
  disableDtTerm = ArchitectureConstants.FALSE;
  }
  
  
  
   ROWCCMN45DO eventDetails = null;
  if (icpcDetailRet.getRowccmn45do() == null) {
    eventDetails = new ROWCCMN45DO();
  } else {
    eventDetails = icpcDetailRet.getRowccmn45do();
  }

  // Retrieved data from the event table.
  if (eventDetails != null && eventDetails.getUlIdEvent() != 0) {
    szCdEventType = eventDetails.getSzCdEventType();
    dtDtEventOccurred = FormattingHelper.formatDate(eventDetails.getDtDtEventOccurred());
    ulIdEvent = eventDetails.getUlIdEvent();
    ulIdStage = eventDetails.getUlIdStage();
    ulIdPerson = eventDetails.getUlIdPerson();
    szTxtEventDescr = eventDetails.getSzTxtEventDescr();
    szCdTask = eventDetails.getSzCdTask();
    szCdEventStatus = eventDetails.getSzCdEventStatus();
    evtsLastUpdate = DateHelper.toISOStringSafe(eventDetails.getTsLastUpdate());
    dtLastUpdate = eventDetails.getTsLastUpdate();
  }

if(CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus)){
pageMode = PageModeConstants.VIEW;
disableComplete = ArchitectureConstants.TRUE;
  // STGAP00018065: MR-104
  disableDelete = ArchitectureConstants.TRUE;
}

if (CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus) && ArchitectureConstants.TRUE.equals(icpcDetailRet.getIndIcpcUnitMember()) ){
 pageMode = PageModeConstants.EDIT;       
}
      
  if ("".equals(formType) || formType == null) {
    displayFormType = true;
    displayContinue = true;
  } else {
    displayFormType = false;
    displayContinue = false;
  }

  if (!("".equals(formType)) && (formType != null)) {
    disableICPCFormType = "true";
  }
%>
  
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">
   
   /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
 window.onbeforeunload = function ()
  {
    IsDirty();
  }
  
   window.onload = function ()
   {
   onPageRefreshOrLoad();
   }

function noValidationOnSave()
{
  disableValidation("frmIcpcDetail");
}

function preventModify(fieldLabel, fieldName)
{
  alert(fieldLabel + " " + "can only be updated from the \'Person Detail\' page of the selected primary person or resource.");
  //Reset the particular field to the original value
  if(fieldLabel == 'Street') {
    fieldName.value = '<%=FormattingHelper.formatString(addrStreetLn1)%>';     
  } else if(fieldLabel == 'City') {
    fieldName.value = ' <%=FormattingHelper.formatString(addrCity)%>';
  } else if(fieldLabel == 'State') {
    fieldName.value = '<%=FormattingHelper.formatString(addrState)%>';
  } else if(fieldLabel == 'Zip') {
    fieldName.value = '<%=FormattingHelper.formatString(addrZip)%>';
  } else if(fieldLabel == 'Phone') {
    fieldName.value = '<%=FormattingHelper.formatPhone(phone)%>';
  } 
  return false;
}

 function displayReferenceGuide(){
  var descriptor = "";
  
  // describe the window properties
  descriptor += "width=450,";
  descriptor += "height=350,";
  descriptor += "channelmode=0,";
  descriptor += "dependent=0,";
  descriptor += "directories=1,";
  descriptor += "fullscreen=0,";
  descriptor += "location=1,";
  descriptor += "menubar=0,";
  descriptor += "resizable=1,";
  descriptor += "scrollbars=1,";
  descriptor += "status=1,";
  descriptor += "toolbar=0";
  
  // open ICPCReferenceGuide page
  return window.open('/subcare/Icpc/displayIcpcReferenceGuide', "", descriptor);
}

function onChangeOfPrimary(){
if(document.frmIcpcDetail.selPrimaryPerson.value == ""){
 updateDisplayOnlyField("frmIcpcDetail", "dspSSNPrimaryPerson", "");
 updateDisplayOnlyField("frmIcpcDetail", "dspRelationship", "");
 updateDisplayOnlyField("frmIcpcDetail", "dspSideOfFamily", "");
 document.frmIcpcDetail.dspStreet.value = "";
 updateDisplayOnlyField("frmIcpcDetail", "dspStreet2", "");        
 document.frmIcpcDetail.dspCity.value = "";
 document.frmIcpcDetail.dspState.value = "";
 document.frmIcpcDetail.dspZip.value = "";
 document.frmIcpcDetail.dspPhone.value = ""; 
}else{
      disableValidation("frmIcpcDetail");
      submitValidateForm("frmIcpcDetail", "/subcare/Icpc/addIcpcDetail");
      }
}

function onChangeOfSpouse(){
if(document.frmIcpcDetail.selSpouse.value == ""){
   updateDisplayOnlyField("frmIcpcDetail","dspSSNSpouse", "");
}else{
  disableValidation("frmIcpcDetail");
  submitValidateForm("frmIcpcDetail", "/subcare/Icpc/addIcpcDetail");
}
}

function onChangeOfResource(){
if(document.frmIcpcDetail.selPrimaryPerson.value == ""){
 updateDisplayOnlyField("frmIcpcDetail", "dspRelationship", "");
 document.frmIcpcDetail.dspStreet.value = "";
 updateDisplayOnlyField("frmIcpcDetail", "dspStreet2", "");        
 document.frmIcpcDetail.dspCity.value = "";
 document.frmIcpcDetail.dspState.value = "";
 document.frmIcpcDetail.dspZip.value = "";
 document.frmIcpcDetail.dspPhone.value = ""; 
}else{
disableValidation("frmIcpcDetail");
submitValidateForm("frmIcpcDetail", "/subcare/Icpc/addIcpcDetail");
}
}

function onClickOfAdoptiveStudy(){
if('100A' == document.frmIcpcDetail.formType.value){
    var finalizedInElements = document.getElementsByName("rbIndFinalizedIn");
    if(finalizedInElements.length == 0)
    	finalizedInElements = document.getElementsByName("rbIndFinalizedIn_Disabled");
    var counter = 0;
	while(counter < finalizedInElements.length) {
		finalizedInElements[counter].disabled = false;
		counter++;
	}
    updateDisplayOnlyField("frmIcpcDetail", "cdADOSubsidy", "<%=aaFundingDeterm %>");
}
}

function onClickOfParRelOrFosterStudy(){
if('100A' == document.frmIcpcDetail.formType.value){
    var finalizedInElements = document.getElementsByName("rbIndFinalizedIn");
    if(finalizedInElements.length == 0)
		finalizedInElements = document.getElementsByName("rbIndFinalizedIn_Disabled");
    var counter = 0;
	while(counter < finalizedInElements.length) {
		finalizedInElements[counter].checked = false;
		finalizedInElements[counter].disabled = true;
		counter++;
	}
    updateDisplayOnlyField("frmIcpcDetail", "cdADOSubsidy", "");
    }
}

function onClickOfCompPlaceTermReasons(){
if('100B' == document.frmIcpcDetail.formType.value){
if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id6.checked){
document.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;
document.frmIcpcDetail.txtOtherTermRsn_Id.value = "";
document.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;
}
else if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id10.checked){
document.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;
document.frmIcpcDetail.txtOtherTermRsn_Id.value = "";
document.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;

document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = false;
}
else if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id11.checked){
document.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = false;
document.frmIcpcDetail.txtOtherTermRsn_Id.value = "";
document.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;
}
else if (true == document.frmIcpcDetail.rbCdPlacementTermReason_Id19.checked){
document.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;
document.frmIcpcDetail.txtOtherTermRsn_Id.disabled = false;
}
else {
document.frmIcpcDetail.rbIndFinalizedIn_Id7.checked = false;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.checked = false;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.checked = false;
document.frmIcpcDetail.txtOtherTermRsn_Id.value = "";
document.frmIcpcDetail.rbIndFinalizedIn_Id7.disabled = true;
document.frmIcpcDetail.rbIndFinalizedIn_Id8.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachAF.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCRP.disabled = true;
document.frmIcpcDetail.cbxIndCourtOrderAttachLCGR.disabled = true;
document.frmIcpcDetail.txtOtherTermRsn_Id.disabled = true;
}
if ('' != getSelectedRadioValue(document.frmIcpcDetail.rbCdPlacementTermReason)) {
if ('COMP' != '<%=eventDetails.getSzCdEventStatus()%>' ){
enableDateField(document.frmIcpcDetail, document.frmIcpcDetail.dtDateTermination);
}
} else {
disableDateField(document.frmIcpcDetail, document.frmIcpcDetail.dtDateTermination);
document.frmIcpcDetail.dtDateTermination.value = '';
}

}
}

function onPageRefreshOrLoad(){
if('100A' == document.frmIcpcDetail.formType.value){
if (true == document.frmIcpcDetail.rbCdInitialReportReq_Id5.checked){
    var finalizedInElements = document.getElementsByName("rbIndFinalizedIn");
    if(finalizedInElements.length == 0)
    	finalizedInElements = document.getElementsByName("rbIndFinalizedIn_Disabled");
    var counter = 0;
	while(counter < finalizedInElements.length && 'COMP' != '<%=eventDetails.getSzCdEventStatus()%>') {
		finalizedInElements[counter].disabled = false;
		counter++;
	}
    updateDisplayOnlyField("frmIcpcDetail", "cdADOSubsidy", "<%=aaFundingDeterm %>");
}else{
    updateDisplayOnlyField("frmIcpcDetail", "cdADOSubsidy", "");
}
}else if ('100B' == document.frmIcpcDetail.formType.value){
onClickOfCompPlaceTermReasons();

}
}


  </script>
  <impact:validateErrors />

<impact:validateForm name="frmIcpcDetail" schema="/WEB-INF/Constraints.xsd" 
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.IcpcCustomValidation"
  method="post" action="/subcare/Icpc/saveIcpcDetail" pageMode="<%=pageMode%>">

<%--  Always include this hidden field in your form --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>

 <% //if (displayContinue) { %>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th>
				ICPC Form Type
			</th>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<tr>
						<td>
							<impact:validateSelect 
							  label="Type" 
							  name="formType" 
							  required="true"
							  codesTable="<%=CodesTables.CICPCTYP%>" 
							  value="<%=formType%>" 
							  disabled="<%=disableICPCFormType%>" 
							  tabIndex="<%=tabIndex++%>" />
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
</table>
	<%
	//}
	    if (displayContinue) {
	%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
				<impact:ButtonTag 
				  name="btnContinue" 
				  img="btnContinue" 
				  align="right" 
				  form="frmIcpcDetail" 
				  action="/subcare/Icpc/reloadIcpcDetail" 
				  tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	
	<%
	  } //end display form type
	
	
		  if(CodesTables.CICPCTYP_100A.equals(formType)) {  
		%>          
<br>		        
		
<table border="0" cellspacing="0" cellpadding="0" class="tableBorder" width="100%" >
		<tr><td align="right"><a href="javascript:disableValidation('frmIcpcDetail');submitValidateForm('frmIcpcDetail', '/multipart/ExternalDcmnttn/displayExtDocList')">Link To External Documentation List</a></td></tr>
  <tr class="subDetail">
	  <th colspan="5">Child Identifying Data</th>
  </tr>
		<tr class="subDetail">	
		    <td colspan="5">
			    <table border="0" width="100%" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td >	<impact:validateDisplayOnlyField name="dspNmFirst" label="First Name"/></td>
						<td align="left"><%=FormattingHelper.formatString(nmFirst)%></td>
						<td ><impact:validateDisplayOnlyField name="dspNmMiddle" label="Middle" /></td>
						<td align="left" ><%=FormattingHelper.formatString(nmMiddle)%></td>
						<td><impact:validateDisplayOnlyField name="dspNmLast" label="Last" /></td>
						<td width="20%" align="left" ><%=FormattingHelper.formatString(nmLast)%>	</td>
                   </tr>
                   <tr>
						<td> <impact:validateDisplayOnlyField name="dtDOB" label="DOB" /> </td>
						<td align="left" > <%=FormattingHelper.formatDate(icpcDetailRet.getDtPersonBirth())%></td>												
						<td ><impact:validateDisplayOnlyField name="dspGender" label="Gender" /></td>
						<td align="left" > <%=Lookup.simpleDecodeSafe(CodesTables.CSEX, cdGender)%></td>					    
					    <td ><impact:validateDisplayOnlyField name="dspSSN" label="SSN" /></td>
					    <td align="left"> <%=FormattingHelper.formatSSN(ssn)%></td>
					</tr>
					

					<tr>
						<td ><impact:validateDisplayOnlyField name="dspRace" label="Race" /></td>
						<td align="left" ><%=cdRace%></td>
						<td ><impact:validateDisplayOnlyField name="dspEthnicity" label="Ethnicity" /></td>
					    <td align="left" > <%=cdEthnicity%></td>
					    <td width="20%"><impact:validateDisplayOnlyField name="dspIVEDetermination" label="Title IV-E Determination" /></td>
					    <td align="left" > <%=FormattingHelper.formatString(dspIVEDeterm)%></td>
					</tr>
					<tr>
						<td><impact:validateDisplayOnlyField name="dspNmMotherFull" label="Mother" /></td>
                        <td align="left" ><%=nmMotherFull%></td>
						<td ><impact:validateDisplayOnlyField name="" label="" /></td>
					    <td align="left" >&nbsp;</td>
					    <td width="20%"><impact:validateDisplayOnlyField name="" label="" /></td>
					    <td align="left" >&nbsp;</td>
                   </tr>
                   <tr>
						<td><impact:validateDisplayOnlyField name="dspNmFatherFull" label="Father" /></td>
                        <td align="left" ><%=nmFatherFull%></td>
						<td ><impact:validateDisplayOnlyField name="" label="" /></td>
					    <td align="left" >&nbsp;</td>
					    <td width="20%"><impact:validateDisplayOnlyField name="" label="" /></td>
					    <td align="left" >&nbsp;</td>
                   </tr>
		        </table> 
		     </td>
		</tr>
    <tr>
      <td colspan="5">&nbsp;</td>
	</tr>

	<tr class="subDetail">
	<th colspan="5">Form 100A  <a href="#" onClick = "displayReferenceGuide()">?</a></th>
	</tr>
	<tr>	
		 <td colspan="5">
			     <table border="0"  cellpadding="0" cellspacing="0" width="50%">
					<tr>
						<td width="25%%"><impact:validateDisplayOnlyField name="" label="ICWA Eligible" required="true" /></td>
						<td>
							<impact:validateInput
								checked="<%=ArchitectureConstants.Y.equals(indICWAEligible) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="Y" type="radio" 
								name="rbICWAEligible" disabled="false" id="indICWAEligible"
								label="Yes" cssClass="formInput" />
							<impact:validateInput
								checked="<%=ArchitectureConstants.N.equals(indICWAEligible) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="N" type="radio"
								name="rbICWAEligible" disabled="false" id="indICWAEligible"
								label="No" cssClass="formInput" />
						</td>					
                    </tr>                             		
		           </table> 
		   </td>
	</tr>
	<tr>	
		 <td colspan="5">&nbsp;</td>
	</tr>
	<tr class="subDetail">
	  <th colspan="5">Placement Information</th>
	</tr>
	<tr>
		<td><impact:validateDisplayOnlyField name="dspNmPerChldPlcdWith" label="Name of Person(s) with whom Child is to be placed" /></td>					
	</tr>	   
	<tr class="subDetail">	
			<td colspan="5">
				   <table border="0"  cellpadding="1" cellspacing="0" width="100%">					                            		
							<tr>    
	   						 <td width="20%"><impact:validateSelect
	                               label="Primary Person"
	                               name="selPrimaryPerson"
	                               style="WIDTH: 182px"
	                               overrideDisplayBadCodes="true"
	                               required="<%=ArchitectureConstants.TRUE%>"
	                               value="<%=FormattingHelper.formatString(idPrimaryPerson)%>"  
	                               onChange=" onChangeOfPrimary(); "
	                               tabIndex="<%=tabIndex++%>"     
	                               options="<%=principalsToDisplayList%>"/>	
	   							 </td>	
	   							 <td><impact:validateDisplayOnlyField name = "dspSSNPrimaryPerson" label="SSN" 
								value="<%=FormattingHelper.formatSSN(ssnPrimary)%>" /> </td>   						
	   							<td width="12%"><impact:validateDisplayOnlyField name="dspRelationship" 
	   							label="Relationship" value="<%=Lookup.simpleDecodeSafe(CodesTables.CRELVICT, relationship)	 %>" /></td>
	   						</tr>
							<tr>
							   <td colspan="2">&nbsp;</td>
							   <td colspan="2">&nbsp;</td>
							   <td> <impact:validateDisplayOnlyField name="dspSideOfFamily" label="Side of Family" 
								value="<%=Lookup.simpleDecodeSafe(CodesTables.CSIDEFAM,sideOfFamily) %>" /> </td>
							</tr>  
	                       
	    					<tr>   <td><impact:validateSelect
	                               label="Other Caretaker in the Home (if applicable)"
	                               name="selSpouse"
	                               style="WIDTH: 182px"	 
	                               overrideDisplayBadCodes="true"	                               
	                               value="<%=FormattingHelper.formatString(idSpouse)%>"                                
	                               tabIndex="<%=tabIndex++%>"
	                               onChange="onChangeOfSpouse();"
	                               options="<%=principalsToDisplayList%>" /></td>
	                              <td>  <impact:validateDisplayOnlyField name = "dspSSNSpouse" label="SSN"
	                              value="<%=FormattingHelper.formatSSN(ssnSpouse) %>" /> </td>
	                              <td colspan="2">&nbsp;</td>
	      					</tr>  
	      					<tr><td><impact:validateInput type="text" name="dspStreet" label="Street"  style="WIDTH: 215px" 
		onChange="preventModify('Street', this);" value="<%=FormattingHelper.formatString(addrStreetLn1)%>"/></td> <td colspan="4"> </td></tr>
	 	<tr><td><impact:validateDisplayOnlyField name="dspStreet2" label="Street[#2]"
	 	value="<%=FormattingHelper.formatString(addrStreetLn2)%>"/></td> <td> </td></tr> 
	 		<tr><td><impact:validateInput type="text" name="dspCity" label="City" 
	 	onChange="preventModify('City', this);" value="<%=FormattingHelper.formatString(addrCity)%>"/></td> <td colspan="4"> </td></tr>
	 	<tr><td><impact:validateInput type="text" name="dspState" label="State" 
	 	onChange="preventModify('State', this);" value="<%=FormattingHelper.formatString(addrState)%>" /></td> <td colspan="4"> </td></tr>	 	 
	 	<tr><td><impact:validateInput type="text" name="dspZip" label="Zip"
	 	onChange="preventModify('Zip', this);" value="<%=FormattingHelper.formatString(addrZip)%>" /></td> <td colspan="4"> </td></tr>
	    <tr><td><impact:validateInput type="text" name="dspPhone" label="Phone" style="WIDTH: 172px"
	    onChange="preventModify('Phone', this);" value="<%=FormattingHelper.formatPhone(phone)%>"/></td> <td colspan="4"> </td></tr>
	    <tr><td colspan="4">&nbsp;</td></tr>
	    
			</table> 
		</td>
	</tr>
	<tr class="subDetail">
	  <th colspan="5">Services Requested</th>
	</tr>
	<tr>
		<td colspan="5">
          <table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
				        <td colspan="6">
				         <span class="formRequiredText">*</span>   
						  <b>Initial Report Requested:</b>
				  		 </td>	  
						</tr>
						 <tr>
				   		 <td>				    
				        <impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRA)%>" 
						  checked="<%=CodesTables.CINRPTRQ_IRA.equals(cdInitReportReq) ? "true" : "false"%>"						  
						  id="initRepReq" 
						  name="rbCdInitialReportReq"
						  value="<%=CodesTables.CINRPTRQ_IRA%>" 
						  onClick="onClickOfParRelOrFosterStudy(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />	
						  </td>
						  <td colspan="3">&nbsp;</td>
						  </tr>
				<tr>
						  <td>					  
						     <impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRB)%>" 
						  checked="<%=CodesTables.CINRPTRQ_IRB.equals(cdInitReportReq) ? "true" : "false"%>"						  
						  id="initRepReq" 
						  name="rbCdInitialReportReq" 
						  value="<%=CodesTables.CINRPTRQ_IRB%>" 
						  onClick="onClickOfParRelOrFosterStudy(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />
						  </td>
						 <td colspan="3">&nbsp;</td>
			   </tr>
			   <tr>
						  <td>
						     <impact:validateInput 
						  type="radio" 						  
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRC)%>" 
						  checked="<%=CodesTables.CINRPTRQ_IRC.equals(cdInitReportReq) ? "true" : "false"%>"			  
						  id="initRepReq" 
						  name="rbCdInitialReportReq" 	  value="<%=CodesTables.CINRPTRQ_IRC%>" 
						  onClick="onClickOfAdoptiveStudy(); "						  
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />
							</td>
						  	<td> <span class="formCondRequiredText">&#135; </span> <b>Adoption: </b>
						  		 <impact:validateDisplayOnlyField label="" name="cdADOSubsidy" value="<%=FormattingHelper.formatString(aaFundingDeterm) %>"/>
						 	</td>
							<td>&nbsp;</td>
						  	<td> <b>To Be Finalized In: </b>
						  		 <impact:validateDisplayOnlyField label="" name="" value=""/>
						 	</td>
			   </tr>
		       <tr>
					  	<td>
						  <impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CINRPTRQ, CodesTables.CINRPTRQ_IRD)%>" 
						  checked="<%=CodesTables.CINRPTRQ_IRD.equals(cdInitReportReq) ? "true" : "false"%>"						  
						  id="initRepReq" 
						  name="rbCdInitialReportReq" value="<%=CodesTables.CINRPTRQ_IRD%>"
						  onClick=" onClickOfParRelOrFosterStudy();"						  
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />						
				   	 	</td>
				   	 	<td colspan="2">&nbsp;</td>
				   	 	<td style="padding-left:10px;">
						 <impact:validateInput 
						  type="radio" 
						  label="Sending State" 
						  checked="<%="S".equals(indFinalizedIn) ? "true" : "false"%>" 
						  id="idIndFinalizedIn" 
						  name="rbIndFinalizedIn" value="S" 
						  disabled="<%=indFinalizedDisabled %>" 
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />
						</td>
							 </tr>	
			<tr>
				<td colspan="3">&nbsp;</td>
				<td style="padding-left:10px;">
					<impact:validateInput
					 type="radio" 
					 label="Receiving State" 
					 checked="<%="R".equals(indFinalizedIn) ? "true" : "false"%>" 						  
					 id="idIndFinalizedIn"  
					 name="rbIndFinalizedIn" value="R" 
					 disabled="<%=indFinalizedDisabled %>" 
					 cssClass="formInput"  
					 tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
							 
		</table>
     </td> 								 
   </tr>						  	
	<tr>
	<td colspan="5">&nbsp;</td>
	</tr>	
   <tr>
  <td colspan="5"><b>Documents Enclosed</b> <impact:validateDisplayOnlyField name="" label="" /></td>	
  <tr><td colspan="5"><span style="font-style:italic"><font color="#FF0000">
						The following documents are an essential part of the ICPC packet and all, except the Case Plan and the IV-E Eligibility Documentation, must be uploaded into External Documents.  See '?' for additional details.</font></span></td>
  </tr>
						
  <tr>
	  <td colspan="5">
		 <table border="0" cellspacing="0" cellpadding="0"width="100%">						
			<tr>
			   <td><impact:codesCheckbox codesTableName="<%=CodesTables.CDREQCBX%>" columns="4" 
					name="cbxReqDoc" isHorizontal="true" tabIndex="<%=tabIndex++%>" defaultCodes="<%=savedReqCbx%>"/></td>
			</tr>
		 </table>
	  </td>
	</tr>	
						
  <tr>
	  <td colspan="5">
		 <table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr><td><impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="cbxAplDoc1"
						                    label="<%=Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APA)%>" 
						                    checked="<%=savedAplCbx.contains(CodesTables.CDAPLCBX_APA) ? "true" : "false"%>"						  
											 value="<%=CodesTables.CDAPLCBX_APA%>" />
				</td>
			    <td><impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="cbxAplDoc2"
						                    label="<%=Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APB)%>" 
						                    checked="<%=savedAplCbx.contains(CodesTables.CDAPLCBX_APB) ? "true" : "false"%>"						  
											 value="<%=CodesTables.CDAPLCBX_APB%>" />
				</td>
				<td><span class="formCondRequiredText">&#135;</span><impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="cbxAplDoc3"
						                    label="<%=Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APC)%>" 
						                    checked="<%=savedAplCbx.contains(CodesTables.CDAPLCBX_APC) ? "true" : "false"%>"						  
											 value="<%=CodesTables.CDAPLCBX_APC%>" />
				</td>
				<td><impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="cbxAplDoc4"
						                    label="<%=Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APD)%>" 
						                    checked="<%=savedAplCbx.contains(CodesTables.CDAPLCBX_APD) ? "true" : "false"%>"						  
											 value="<%=CodesTables.CDAPLCBX_APD%>" />
				</td>
			</tr>
		<tr><td><impact:validateInput tabIndex="<%=tabIndex++%>"
											type="checkbox" name="cbxAplDoc5"
						                    label="<%=Lookup.simpleDecodeSafe(CodesTables.CDAPLCBX, CodesTables.CDAPLCBX_APE)%>" 
						                    checked="<%=savedAplCbx.contains(CodesTables.CDAPLCBX_APE) ? "true" : "false"%>"						  
											 value="<%=CodesTables.CDAPLCBX_APE%>" />
				</td>
			</tr>
		</table>
     </td>
   </tr>
</table>
<br>
<%
  } else if (CodesTables.CICPCTYP_100B.equals(formType)){//Start if 100B ICPC form
%>
<br>
<table border="0" cellspacing="0" cellpadding="0" class="tableBorder" width="100%">
		<tr><td colspan="6" align="right"><a href="javascript:disableValidation('frmIcpcDetail');submitValidateForm('frmIcpcDetail', '/multipart/ExternalDcmnttn/displayExtDocList')">Link To External Documentation List</a></td></tr>

		<tr class="subDetail">
			<th colspan="6">Child Identifying Data</th>
		</tr>
		<tr class="subDetail">	
		    <td colspan="5">
			    <table border="0" width="100%" cellpadding="0" cellspacing="0" width="100%">
			    <tr><td>&nbsp;</td></tr>
						<tr>
						<td><impact:validateDisplayOnlyField name="dspNmFirst" label="First Name" /></td>
						<td align="left"><%=FormattingHelper.formatString(nmFirst)%></td>
						<td><impact:validateDisplayOnlyField name="dspNmMiddle" label="Middle" /></td>
						<td align="left" ><%=FormattingHelper.formatString(nmMiddle)%></td>
						<td><impact:validateDisplayOnlyField name="dspNmLast" label="Last" /></td>
						<td width="15%" align="left" ><%=FormattingHelper.formatString(nmLast)%>	</td>
                   </tr>
                   <tr>
						<td> <impact:validateDisplayOnlyField name="dtDOB" label="DOB" /> </td>
						<td align="left" ><%=FormattingHelper.formatDate(icpcDetailRet.getDtPersonBirth())%></td>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
		           <td width="15%"><impact:validateDisplayOnlyField name="dspNmMotherFull" label="Mother"/></td>
						<td align="left"><%=FormattingHelper.formatString(nmMotherFull)%></td>
               </tr>    
               <tr>
			       <td width="15%"><impact:validateDisplayOnlyField name="dspNmFatherFull" label="Father"/></td>
						<td align="left"><%=FormattingHelper.formatString(nmFatherFull)%></td>
		       </tr>
		        </table> 
		      </td>
	</tr>
    <tr class="subDetail">
       <td colspan="6">&nbsp;</td>
    </tr>
	<tr class="subDetail">
	   <th colspan="6">Form 100B  <a href="#" onClick = "displayReferenceGuide()">?</a></th>
	</tr>	

	<tr class="subDetail">	
       <td colspan="6">
		  <table border="0"  cellpadding="0" cellspacing="0" width="100%">					                            		
			 <tr>    
	   			 <td width="20%"><impact:validateSelect
	                               style="WIDTH: 182px"
	                               label="Name of Resource"
	                               name="selPrimaryPerson"
	                               overrideDisplayBadCodes="true"
	                               required="<%=ArchitectureConstants.TRUE%>"  
	                               tabIndex="<%=tabIndex++%>"     
	                               options="<%=principalsToDisplayList%>"    
	                               value="<%=FormattingHelper.formatString(idPrimaryPerson)%>"
	                               onChange="onChangeOfResource();"/></td>                              

	   			  <td align="left"> <impact:validateDisplayOnlyField name="dspRelationship" label="Relationship" 
					   value="<%=Lookup.simpleDecodeSafe(CodesTables.CRELVICT, relationship)%>" /></td>
			 </tr>   
			 <tr>
			     <td><impact:validateInput type="text" name="dspStreet" label="Street" style="WIDTH: 215px"
		              onChange="preventModify('Street', this);" value="<%=FormattingHelper.formatString(addrStreetLn1)%>"/></td>
		         <td colspan="2">&nbsp;</td>
		     </tr>
	 	     <tr>
	 	         <td><impact:validateDisplayOnlyField name="dspStreet2" label="Street[#2]" 
	 	              value="<%=FormattingHelper.formatString(addrStreetLn2)%>"/></td> 
	 	         <td colspan="2">&nbsp;</td>
	 	     </tr>
	 	     <tr>
	 	         <td><impact:validateInput type="text" name="dspCity" label="City" 
	 	              onChange="preventModify('City', this);" value="<%=FormattingHelper.formatString(addrCity)%>"/></td>
	 	         <td colspan="2">&nbsp;</td>
	 	     </tr>
	 	     <tr>
	 	         <td><impact:validateInput type="text" name="dspState" label="State" 
	 	              onChange="preventModify('State', this);" value="<%=FormattingHelper.formatString(addrState)%>" /></td>
	 	         <td colspan="2">&nbsp;</td>
	 	     </tr>	 	 
	 	     <tr>
	 	         <td><impact:validateInput type="text" name="dspZip" label="Zip" 
	 	              onChange="preventModify('Zip', this);" value="<%=FormattingHelper.formatString(addrZip)%>" /></td> 
	 	         <td colspan="2">&nbsp;</td>
	 	     </tr>
	         <tr>
	             <td><impact:validateInput type="text" name="dspPhone" label="Phone" style="WIDTH: 172px"
	                  onChange="preventModify('Phone', this);" value="<%=FormattingHelper.formatPhone(phone)%>"/></td> 
	             <td colspan="2">&nbsp;</td>
	         </tr>	
			</table> 
		</td>
	</tr>
	<tr class="subDetail">
       <td colspan="6">&nbsp;</td>
    </tr>
    <tr class="subDetail">
		<td colspan="6"><span class="formRequiredText">*</span><impact:validateDisplayOnlyField name="cdTypeOfCare" label="Type of Care"/></td>
	</tr>
	<tr>
		<td><impact:validateInput
				checked="<%=CodesTables.CTYPCARE_FFH.equals(cdTypeOfCare) ? "true" : "false"%>"
				tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CTYPCARE_FFH%>" type="radio"
				name="rbTypeOfCare" id="idTypeOfCare"
				label="<%=Lookup.simpleDecodeSafe(CodesTables.CTYPCARE,CodesTables.CTYPCARE_FFH)%>" cssClass="formInput" /></td>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr><td><impact:validateInput
					checked="<%=CodesTables.CTYPCARE_PAR.equals(cdTypeOfCare) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CTYPCARE_PAR%>" type="radio"
					name="rbTypeOfCare" id="idTypeOfCare"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CTYPCARE,CodesTables.CTYPCARE_PAR)%>" cssClass="formInput" /></td>
		<td colspan="4">&nbsp;</td>	
	</tr>
	<tr>
	    <td><impact:validateInput
					checked="<%=CodesTables.CTYPCARE_REL.equals(cdTypeOfCare) ? "true" : "false"%>"
					tabIndex="<%=tabIndex++%>" value="<%=CodesTables.CTYPCARE_REL%>" type="radio"
					name="rbTypeOfCare" id="idTypeOfCare"
					label="<%=Lookup.simpleDecodeSafe(CodesTables.CTYPCARE,CodesTables.CTYPCARE_REL)%>" cssClass="formInput" /></td>
	    <td colspan="4">&nbsp;</td>
	</tr>
	<tr class="subDetail">
       <td colspan="6">&nbsp;</td>
    </tr>
    <tr class="subDetail">
		<th colspan="6">&nbsp;</th>
	</tr>
		<tr class="subDetail">
			<td colspan="6">
				<span><font color="#FF0000"> Please select <b>only one</b> 
				of the following: a radio button for Initial Placement, a radio button 
				for Placement Change or a radio button for Compact Placement Termination.</font>
				</span>
			</td>
		</tr>
		<tr class="subDetail">
		<th colspan="6">Placement Status</th>
	</tr>		 
	<tr class="subDetail">
		<td colspan="3"><impact:validateInput							
								checked="<%=CD_INITIAL_PLACEMENT.equals(indPlacementStatus) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="<%=CD_INITIAL_PLACEMENT%>" type="radio"
								name="rbIndPlacementStatus" id="idIndPlacementStatus"
								label="Initial Placement of Child in Receiving State" cssClass="formInput" /></td>
		<td colspan="3"><impact:validateInput
								checked="<%=CD_PLACEMENT_CHANGE.equals(indPlacementStatus) ? "true" : "false"%>"
								tabIndex="<%=tabIndex++%>" value="<%=CD_PLACEMENT_CHANGE%>" type="radio"
								name="rbIndPlacementStatus" id="idIndPlacementStatus"
								label="Placement Change" cssClass="formInput" /></td>
	</tr>
	<tr>
		<td width="30%"><impact:validateDisplayOnlyField name="" conditionallyRequired="true" label="Date Child Placed in Receiving State"/></td>
		<td><impact:validateDate type="text" name="dtPlacedRecState"
					label="" constraint="Date" value="<%=dtPlacedRecState%>" size="10"
					tabIndex="<%=tabIndex++%>" /></td>	
        <td width="22%"><impact:validateDisplayOnlyField name="" conditionallyRequired="true" label="Effective Date of Change"/></td>
        <td><impact:validateDate type="text" name="dtEffectDtChange"
							label="" constraint="Date" value="<%=dtEffectDtChange%>" size="10"
							tabIndex="<%=tabIndex++%>" /></td>
	</tr>
	<tr>
		<td colspan="6">&nbsp;</td>
	</tr>	
	<tr>
		<th colspan="6">Compact Placement Termination</th>
	</tr>
	<tr class="subDetail">	
	    <td colspan="6"><span style="font-style:italic"><font color="#FF0000">
			      All Attached Court Orders must be uploaded into External Documentation.</font></span></td>
	</tr>
	<tr>
	   <td colspan="6">
	       <table border="0" cellspacing="0" cellpadding="0"width="100%">
	          <tr> 
	             <td><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRA)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRA.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRA%>" 
						  onClick="onClickOfCompPlaceTermReasons();"
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />
	            </td>
	            <td><impact:validateInput 
						  type="radio" 
						  label="Sending State" 
						  checked="<%="S".equals(indFinalizedIn) ? "true" : "false"%>"						  
						  id="idIndFinalizedIn" 
						  name="rbIndFinalizedIn" value="S"
						  disabled="<%=indFinInAndCrtOrdAttDisabled %>"
						  cssClass="formInput"
						  conditionallyRequired="true" 
						  tabIndex="<%=tabIndex++%>" /></td>
	            <td><impact:validateInput 
						  type="radio" 
						  label="Receiving State" 
						  checked="<%="R".equals(indFinalizedIn) ? "true" : "false"%>"						  
						  id="idIndFinalizedIn" 
						  name="rbIndFinalizedIn" value="R"
						  disabled="<%=indFinInAndCrtOrdAttDisabled %>"
						  cssClass="formInput" 
						  conditionallyRequired="true"
						  tabIndex="<%=tabIndex++%>" /></td>
			     <td><impact:validateInput 
				     label="Court Order Attached" 
				     name="cbxIndCourtOrderAttachAF" 
				     type="checkbox" 
				     value="Y"				  
				     tabIndex="<%= tabIndex++ %>" 
				     editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"		
				     checked="<%=ArchitectureConstants.Y.equals(indCourtOrderAttachAF)? "true" : "false"%>" />			
			     </td>
	          </tr>
	          <tr><td colspan="4"><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRB)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRB.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRB%>" 
						  onClick="onClickOfCompPlaceTermReasons(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /></td>
		      </tr>
	          <tr>
	             <td><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRC)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRC.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRC%>" 
						  onClick="onClickOfCompPlaceTermReasons(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" />
	             </td>
	             <td><impact:validateInput 
				      label="Court Order Attached" 
				      name="cbxIndCourtOrderAttachLCRP" 
				      type="checkbox" 	
				      value="Y"			  
				      tabIndex="<%= tabIndex++ %>" 
				      editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
				      checked="<%=ArchitectureConstants.Y.equals(indCourtOrderAttachLCRP)? "true" : "false"%>" />			
	             </td>
	             <td colspan="2">&nbsp;</td>
	          </tr>	
	          <tr>
	             <td><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRD)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRD.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRD%>" 
						  onClick="onClickOfCompPlaceTermReasons(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /> </td>	      
	             <td><impact:validateInput 
				      label="Court Order Attached" 
				      name="cbxIndCourtOrderAttachLCGR" 
				      type="checkbox" 
				      value="Y"				  
			     	  tabIndex="<%= tabIndex++ %>" 
				      editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
				      checked="<%=ArchitectureConstants.Y.equals(indCourtOrderAttachLCGR)? "true" : "false"%>" />	
		         </td>
		         <td colspan="2">&nbsp;</td>		
	          </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						          type="radio" 
						          label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRE)%>" 
						          checked="<%=CodesTables.CTERMRSN_TRE.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
					        	  id="idCdPlcmtTermRsn" 
					          	  name="rbCdPlacementTermReason"
				        		  value="<%=CodesTables.CTERMRSN_TRE%>" 
				        		  onClick="onClickOfCompPlaceTermReasons(); "
				       		      cssClass="formInput" 
						          tabIndex="<%=tabIndex++%>" /> </td>
			  </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						          type="radio" 
						          label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRF)%>" 
						          checked="<%=CodesTables.CTERMRSN_TRF.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						          id="idCdPlcmtTermRsn" 
						          name="rbCdPlacementTermReason"
						          value="<%=CodesTables.CTERMRSN_TRF%>" 
						          onClick="onClickOfCompPlaceTermReasons(); "
						          cssClass="formInput" 
						          tabIndex="<%=tabIndex++%>" /></td>
			  </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						          type="radio" 
						          label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRG)%>" 
						          checked="<%=CodesTables.CTERMRSN_TRG.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						          id="idCdPlcmtTermRsn" 
						          name="rbCdPlacementTermReason"
						          value="<%=CodesTables.CTERMRSN_TRG%>" 
						          onClick="onClickOfCompPlaceTermReasons(); "
						          cssClass="formInput" 
						          tabIndex="<%=tabIndex++%>" /></td>
	          </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRH)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRH.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRH%>" 
						  onClick="onClickOfCompPlaceTermReasons();"
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /></td>
		      </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRI)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRI.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRI%>" 
						  onClick="onClickOfCompPlaceTermReasons();"
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /></td>
		      </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRJ)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRJ.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRJ%>" 
						  onClick="onClickOfCompPlaceTermReasons(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /></td>
		      </tr>
	          <tr>
	             <td colspan="4"><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRK)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRK.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRK%>" 
						  onClick="onClickOfCompPlaceTermReasons();"
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /></td>
		      </tr>
	       </table>
	       <table>
	          <tr>
	             <td width="20%"><impact:validateInput 
						  type="radio" 
						  label="<%=Lookup.simpleDecodeSafe(CodesTables.CTERMRSN, CodesTables.CTERMRSN_TRL)%>" 
						  checked="<%=CodesTables.CTERMRSN_TRL.equals(cdPlacementTermReason) ? "true" : "false"%>"						  
						  id="idCdPlcmtTermRsn" 
						  name="rbCdPlacementTermReason"
						  value="<%=CodesTables.CTERMRSN_TRL%>" 
						  onClick="onClickOfCompPlaceTermReasons(); "
						  cssClass="formInput" 
						  tabIndex="<%=tabIndex++%>" /></td>
	             <td><impact:validateTextArea name="txtOtherTermRsn" label="" conditionallyRequired="true"
					  rows="4" cols="80" tabIndex="<%=tabIndex++%>" maxLength="300"
					  constraint="Paragraph300"><%=FormattingHelper.formatString(icpcDetailRet.getTxtOtherSpecify())%></impact:validateTextArea></td>
	          </tr>
	          <tr>
			     <td><impact:validateDate type="text" name="dtDateTermination"
					  label="Date of Termination" constraint="Date" 
					  value="<%=dtDateTermination%>" size="10" conditionallyRequired="true"
					  disabled="<%=disableDtTerm %>" tabIndex="<%=tabIndex++%>" />
				 </td>
								 
			  </tr>	      
	       </table>
	   </td>
	</tr>	
</table>
<br>	
<%  } %>

<%

  if (!displayContinue) {
%>
<table width="100%">   
	<tr class="subDetail">
		<th colspan="6">Case Manager's Signature</th>
    </tr>
    <tr>
	   <td width="20%">
	   <impact:validateDisplayOnlyField name="txtNmCaseMnger"label="Case Manager's Name" value="<%=FormattingHelper.formatString(nmCaseManager)%>" />
	   </td>
	   <td width="20%">
	   <impact:validateDisplayOnlyField name="dtDateComplete"  label="Date Completed" value="<%=szDtComplete%>" />
	   </td>
	</tr>
	<tr>
		<th colspan="6">&nbsp;</th>
	</tr>							
	
	<tr> 
	<td align="left" width="20%">
		<impact:ButtonTag name="btnDelete" img="btnDelete"
											form="frmIcpcDetail" restrictRepost="true"
											preventDoubleClick="true"
											disabled="<%=disableDelete%>"
											action=""
											tabIndex="<%=tabIndex++%>" />
	</td>
	<td> &nbsp; </td>	
	<td width="20%"><impact:validateDisplayOnlyField name="dtDateLastUpdate" label="Date Last Updated" value="<%=FormattingHelper.formatDate(dtLastUpdate)%>" /></td>
	<td align="right" width="7%">
		<impact:ButtonTag name="btnComplete" img="btnCompleteQ"
											form="frmIcpcDetail" restrictRepost="true"
											preventDoubleClick="true"
											disabled="<%=disableComplete%>"
											action="/subcare/Icpc/saveIcpcDetail"
											tabIndex="<%=tabIndex++%>" />
	</td>
	<td align="right"  width="5%">
		<impact:ButtonTag name="btnSave" img="btnSave"
											form="frmIcpcDetail" restrictRepost="true"
											action="/subcare/Icpc/saveIcpcDetail" align="right"
											tabIndex="<%=tabIndex++%>"  
		/>
	</td>
	</tr>
</table>

<!--<%-->
  // STGAP00018065: MR-104 ICPC Forms
  // Added the forms section to launch the ICPC Form 100A/ICPC Form 100B
<!--%>-->  
<%
	// only show forms if event is COMP
	if(CodesTables.CEVTSTAT_COMP.equals(szCdEventStatus)) {
%>    
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
	<% /* begin Forms  */ %>
  	<tr>
    	<th colspan="2">Forms</th>
  	</tr>
  	<tr>
    	<td>
    	<impact:documentList pageMode="edit" tabIndex="<%= tabIndex++ %>">
    	<%
				if (CodesTables.CICPCTYP_100A.equals(formType)) {
    	%>
			  <impact:document displayName="ICPC Form 100A"
			  				   protectDocument="true" 
			  				   docType="adoassistagrmnt"
			  				   preFillAlways="true" 
			  				   docExists="true">
			    <impact:documentParameter name="pStage"
			                        value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
			    <impact:documentParameter name="pCase"
			                        value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
			    <impact:documentParameter name="pEvent"
			                        value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
			  </impact:document>
    		<%
  				} else if (CodesTables.CICPCTYP_100B.equals(formType)){ //Start if 100B ICPC form
			%>			  
			  
			  <impact:document displayName="ICPC Form 100B"
			                   protectDocument="true" 
			  				   docType="adoassistagrmnt"
			  				   preFillAlways="true" 
			  				   docExists="true">
			    <impact:documentParameter name="pStage"
			                        value="<%= String.valueOf(GlobalData.getUlIdStage(request)) %>"/>
			    <impact:documentParameter name="pCase"
			                        value="<%= String.valueOf(GlobalData.getUlIdCase(request)) %>"/>
			    <impact:documentParameter name="pEvent"
			                        value="<%= String.valueOf(GlobalData.getUlIdEvent(request)) %>"/>
			  </impact:document>
	    	<%
				}	   	     
	    %>	
			</impact:documentList>
	    </td>
  	</tr>
<% /* end Forms */ %>
</table>
<%	   	     
	}
%>

<%
  }
%>
	<input type="hidden" name="dtDtEventOccurred"	value="<%=dtDtEventOccurred%>">
	<input type="hidden" name="ulIdEvent" value="<%=ulIdEvent%>">
	<input type="hidden" name="ulIdStage" value="<%=ulIdStage%>">
	<input type="hidden" name="ulIdPerson" value="<%=ulIdPerson%>">
	<input type="hidden" name="szCdTask" value="<%=szCdTask%>">
	<input type="hidden" name="szCdEventStatus"	value="<%=szCdEventStatus%>">
	<input type="hidden" name="evtsLastUpdate" value="<%=evtsLastUpdate%>">
	<input type="hidden" name="dspIVEDeterm" value="<%=dspIVEDeterm%>">

</impact:validateForm>
		