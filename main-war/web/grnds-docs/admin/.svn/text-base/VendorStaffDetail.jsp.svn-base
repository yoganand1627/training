<%--
JSP Name:     VendorStaffDetail

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
08/21/2010 schoi			SMS #66384: MR-067 Updated code to display the User Profile page
                            to the NYTD User  
01/10/2011 schoi            SMS #90714 Updated maximum length of the Ext. field from 10 to 8 per detailed design                                         
--%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.VendorStaffDetailConversation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;
  int resourceCount = 0;
  //Same as in the VendorStaffDetailConversation.java
  String PORTAL_STAFF_LIST = "portalActive";
  String PORTAL_PENDING_STAFF_LIST = "portalPending";  
  //Same as in the UserProfile.java
  String PLCMNT_PRV_ADMIN = UserProfile.PLCMNT_PRV_ADMIN;
  String PLCMNT_PRV_USRER = UserProfile.PLCMNT_PRV_USRER;
  // SMS #66384: MR-067
  String NYTD_USER = UserProfile.NYTD_USER;
  // Get the serialized request
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
  
  // Get the flag from conversation to display informational message after the save
  Boolean toSurveyPageFlag = (Boolean)request.getAttribute("navToSurveyFlag");
  Boolean isInSurveyPeriod = (Boolean)request.getAttribute("isSurveyPeriod");
  Boolean isSurveyComplete = (Boolean)request.getAttribute("isSurveyComp");
  Boolean isPassMessageToJsp = (Boolean)request.getAttribute("passMessageToJsp");
  

  List resourceIDList = new ArrayList();
  Map<Integer, String> activeRsrcListMap = new HashMap<Integer, String>();
  String idVendor = StringHelper.EMPTY_STRING;
  String nmUserFirst = StringHelper.EMPTY_STRING;
  String nmUserMiddle = StringHelper.EMPTY_STRING;
  String nmUserLast = StringHelper.EMPTY_STRING;
  String disableUsrTyp = "false";
  String disableStatus = "false";
  String disableAssocVndrRadio = "false";
  String txtTitle = StringHelper.EMPTY_STRING;
  String txtUserEmail = StringHelper.EMPTY_STRING;
  String nbrUserPhone = StringHelper.EMPTY_STRING;
  String nbrUserPhoneExtension = StringHelper.EMPTY_STRING;
  String addrUserAddrStLn1 = StringHelper.EMPTY_STRING;
  String addrUserAddrStLn2 = StringHelper.EMPTY_STRING;
  String addrUserAddrCity = StringHelper.EMPTY_STRING;
  String addrUserAddrZip = StringHelper.EMPTY_STRING;
  String addrUserAddrZipStuff = StringHelper.EMPTY_STRING;
  String cdUserAddrState = StringHelper.EMPTY_STRING;
  String cdUserAddrCounty = StringHelper.EMPTY_STRING;
  
  // SMS #66384: MR-067
  String txtUserFB = StringHelper.EMPTY_STRING;
  String txtUserMS = StringHelper.EMPTY_STRING;
  String txtUserTW = StringHelper.EMPTY_STRING;
  String txtOthrSt = StringHelper.EMPTY_STRING;
  String txtOthrStUsrNm = StringHelper.EMPTY_STRING;    
  String TxtUsrPhnBst = StringHelper.EMPTY_STRING;
  String TxtUsrPhnBstExt = StringHelper.EMPTY_STRING;
  String TxtUsrPhnBstType = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt1 = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt1Ext = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt1Type = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt2 = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt2Ext = StringHelper.EMPTY_STRING;
  String TxtUsrPhnAlt2Type = StringHelper.EMPTY_STRING;
  String TxtCtByTxt = StringHelper.EMPTY_STRING;
  String TxtEmrContact = StringHelper.EMPTY_STRING;
  String TxtDtDOB = StringHelper.EMPTY_STRING;
  // End SMS #66384: MR-067
          
  String selectedPuvlId = StringHelper.EMPTY_STRING;
  String selectedRsrcNm = StringHelper.EMPTY_STRING;
  String selectedRsrcId = StringHelper.EMPTY_STRING;
  String selectedType = StringHelper.EMPTY_STRING;
  String selectedStatus = StringHelper.EMPTY_STRING;
  String selectedStartDt = StringHelper.EMPTY_STRING;
  String selectedEndDt = StringHelper.EMPTY_STRING;
  String populateFields = StringHelper.EMPTY_STRING;
  String userAccessType = StringHelper.EMPTY_STRING;
  String seqQues1 = StringHelper.EMPTY_STRING;
  String seqQues2 = StringHelper.EMPTY_STRING;
  String seqQues3 = StringHelper.EMPTY_STRING;
  String seqAns1 = StringHelper.EMPTY_STRING;
  String seqAns2 = StringHelper.EMPTY_STRING;
  String seqAns3 = StringHelper.EMPTY_STRING;
  String radioRsrcChecked = StringHelper.EMPTY_STRING;
  if (retrieveVendorStaffDetailSO!=null){
  	resourceIDList = retrieveVendorStaffDetailSO.getResourceList();
  	activeRsrcListMap = retrieveVendorStaffDetailSO.getActiveRsrcListMap();
  	if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_STAFF_LIST)||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST))){
  	  disableUsrTyp = "true";		 
  	  disableStatus = retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST)?"true":"false";
  	  userAccessType = retrieveVendorStaffDetailSO.getUserAccessType();
  	  nmUserFirst = retrieveVendorStaffDetailSO.getNmUserFirst();
  	  nmUserMiddle = retrieveVendorStaffDetailSO.getNmUserMiddle();
  	  nmUserLast = retrieveVendorStaffDetailSO.getNmUserLast();
  	  txtTitle = retrieveVendorStaffDetailSO.getTxtTitle();
  	  txtUserEmail = retrieveVendorStaffDetailSO.getTxtUserEmail();
  	  nbrUserPhone = retrieveVendorStaffDetailSO.getNbrUserPhone();
  	  nbrUserPhoneExtension = retrieveVendorStaffDetailSO.getNbrUserPhoneExtension();
  	  addrUserAddrStLn1 = retrieveVendorStaffDetailSO.getAddrUserAddrStLn1();
  	  addrUserAddrStLn2 = retrieveVendorStaffDetailSO.getAddrUserAddrStLn2();
  	  addrUserAddrCity = retrieveVendorStaffDetailSO.getAddrUserAddrCity();
  	  if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 9) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  	addrUserAddrZipStuff = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(5);
  	  }else if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() < 9 
  	  				&& retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 5) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  }
  	  cdUserAddrState = retrieveVendorStaffDetailSO.getCdUserAddrState();
  	  cdUserAddrCounty = retrieveVendorStaffDetailSO.getCdUserAddrCounty();
  	  // SMS #66384: MR-067
  	  txtUserFB = retrieveVendorStaffDetailSO.getTxtUserFB();
  	  txtUserMS = retrieveVendorStaffDetailSO.getTxtUserMS();
  	  txtUserTW = retrieveVendorStaffDetailSO.getTxtUserTW();
      txtOthrSt = retrieveVendorStaffDetailSO.getTxtUserOthSite();
	  txtOthrStUsrNm = retrieveVendorStaffDetailSO.getTxtUserNameOthSite();
	  TxtUsrPhnBst = retrieveVendorStaffDetailSO.getTxtUserPhnBest();
	  TxtUsrPhnBstExt = retrieveVendorStaffDetailSO.getTxtUserPhnBestExt();
	  TxtUsrPhnBstType = retrieveVendorStaffDetailSO.getTxtUserPhnBestType();
	  TxtUsrPhnAlt1 = retrieveVendorStaffDetailSO.getTxtUserPhnAlt1();
	  TxtUsrPhnAlt1Ext = retrieveVendorStaffDetailSO.getTxtUserPhnAlt1Ext();
	  TxtUsrPhnAlt1Type = retrieveVendorStaffDetailSO.getTxtUserPhnAlt1Type();
	  TxtUsrPhnAlt2 = retrieveVendorStaffDetailSO.getTxtUserPhnAlt2();
	  TxtUsrPhnAlt2Ext = retrieveVendorStaffDetailSO.getTxtUserPhnAlt2Ext();
	  TxtUsrPhnAlt2Type = retrieveVendorStaffDetailSO.getTxtUserPhnAlt2Type();
	  TxtCtByTxt = retrieveVendorStaffDetailSO.getTxtCntctByText();   
	  TxtEmrContact = retrieveVendorStaffDetailSO.getTxtEmerContact(); 
	  TxtDtDOB = FormattingHelper.formatDate(retrieveVendorStaffDetailSO.getDtDOB());
      // End SMS #66384: MR-067
            	  
  	  if (retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_USRER)
  	  					|| retrieveVendorStaffDetailSO.getUserAccessType().equals(NYTD_USER)
  	  					|| (retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_ADMIN) &&
  										retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser()))){
  	  	disableAssocVndrRadio = "true";
  	  	seqQues1 = retrieveVendorStaffDetailSO.getCdQuestion1();
  	  	seqQues2 = retrieveVendorStaffDetailSO.getCdQuestion2();
  	  	seqQues3 = retrieveVendorStaffDetailSO.getCdQuestion3();
  	  	seqAns1 = retrieveVendorStaffDetailSO.getTxtAnswer1();
  	  	seqAns2 = retrieveVendorStaffDetailSO.getTxtAnswer2();
  	  	seqAns3 = retrieveVendorStaffDetailSO.getTxtAnswer3();
  	  }
  	}
  }  
%>

<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">
function nameContains(eElem, str) {
  var bContains = false;
  bContains = (-1 != (eElem.name.indexOf(str)));
  return bContains;
}

/*
*  Function Name:  CheckWidget
*  Parameters:  eElem - HTML Widget
*  Returns:  Boolean - True if widget changed, False if widget is the same
*
*  Description:  Evaluates present value of widget against default value to determine
*  if there has been a change. Exludes any widget that end in the _CLEAN Suffix
*  so that certain fields will not dirty the page.
*/
function CheckWidget(eElem) {

  // Variable which is returned
  var booChange = false;
  // if this variable has a _CLEAN in the name, do nothing
  if (!nameContains(eElem, "CLEAN")) {
    if ("text" == eElem.type || "TEXTAREA" == eElem.tagName) {
      if (("dtStart"!=eElem.name && "dtEnd"!=eElem.name) && eElem.value != eElem.defaultValue) {
        booChange = true;
      }
    } else if ("SELECT" == eElem.tagName) {
      var cOpts = eElem.options;
      var iNumOpts = cOpts.length;
      for (var j = 0; j < iNumOpts; j++) {
        var eOpt = cOpts[j];
        if (("selStatus"!= eElem.name && "selReqType"!= eElem.name) && eOpt.selected != eOpt.defaultSelected) {
          booChange = true;

        }
      }
    }
  }

  return booChange;
}

/*
*  Function Name:  isFormChanged
*  Parameters:  None
*  Returns:  Boolean
*
*  Description:  Evaluates a form to see if anything in the form has changed.
*  Returns true if something has changed.
*/
function isFormChanged(form) {
  var booDirtyForm = false;
  var iNumElements = form.elements.length;

  //  Loop through the form elements
  for (x = 0; x < iNumElements; x++) {
    if (!form.elements[x].disabled && CheckWidget(form.elements[x])) {
      //alert ('Widget changed!!!');
      booDirtyForm = true;
      break;
    }
  }
  return booDirtyForm;
}

/*
*  Function Name:  isFormChanged
*  Parameters:  None
*  Returns:  Boolean
*
*  Description:  Evaluates a form to page has changed by looping through all
*  the forms to see if they have changed.
*  Returns true if something has changed.
*/
function isPageChanged() {
  var iNumForms = document.forms.length;
  var booDirtyForm = false;
  //  For each form loop through its elements
  for (i = 0; i < iNumForms; i++) {
    if (isFormChanged(document.forms[i])) {
      //alert ('Form changed!!!');
      booDirtyForm = true;
      break;
    }
  }
  return booDirtyForm;
}

/*
*  User can set page to present IsDirty popup message by calling
*  setPageDirtyFlag( true );  Useful for pullbacks where page
*  loads clean but data has actually changed prior to pullback, 
*  or for display-only field changes.
*/
var pageDirtyFlag = false;

function setPageDirtyFlag(dirty) {
  pageDirtyFlag = dirty;
}

/*
*  Function Name:  IsDirty
*  Parameters:  None
*  Returns:  None
*
*  Description:  Evaluates all the forms on a web page.  If the form's elements have
*  changed from their default state the user is prompted to save before leaving the page.
*  The isDirtyCalled var is available from impact.js.  It was moved there to ensure its
*  availability on every page, since dirtyForm.js isn't used on each page.  The button
*  tag now references this var instead of nulling the onbeforeunload method.
*/
function IsDirtyhere() {
  if (!hrefDirtyBypass) {
    // Variable to hold all the forms on a page
    var booDirtyForm = false;
    booDirtyForm = isPageChanged();
    var vendorDetailDirty = false;
    vendorDetailDirty = checkIsDirty();
    /*
    * If the form is dirty prompt the user before leaving the page.
    */
    if (( pageDirtyFlag || booDirtyForm || vendorDetailDirty ) && !isDirtyCalled) {
      event.returnValue = "Your unsaved data will be lost.";
      //MessageBox.show("Version: Visual J++ 6.0", "MyNotepad");
    }
    isDirtyCalled = false;
  }
  hrefDirtyBypass = false;
}
  rbSelected = new Boolean(false);
  function populateFields(idPuvl, nmResource, idResource, cdAccessType, cdStatus, dtStart, dtEnd) {
    document.frmVndrStaffDtl.hdnSelectedPuvlId.value = idPuvl;
    document.frmVndrStaffDtl.hdnSelectedRsrcNm.value = nmResource;
	document.frmVndrStaffDtl.hdnSelectedRsrcId.value = idResource;
	document.frmVndrStaffDtl.hdnSelReqType.value = cdAccessType;
	document.frmVndrStaffDtl.hdnSelStatus.value = cdStatus;
	document.frmVndrStaffDtl.hdnDtStart.value = dtStart;
	document.frmVndrStaffDtl.hdnDtEnd.value = dtEnd;
  }
  
  // This function is called before the page unloads.
	window.onbeforeunload = function ()
	{
    	IsDirtyhere();
	}
  function fillFields(){
  	//disableValidation("frmVndrStaffDtl");
	if (checkIsDirty()){
		if (!confirm("Your unsaved data will be lost.")){
			return false;
		}
	}
	//Set the Select Flag True and Add Flag False to mark for Update
	document.frmVndrStaffDtl.hdnSelectFlag.value = "<%= StringHelper.BOOLEAN_TRUE %>";
	document.frmVndrStaffDtl.hdnAddFlag.value = "<%= StringHelper.BOOLEAN_FALSE %>";
	//Rewriting the inner HTML to display the Resource Name and Resource ID  	
  	document.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;
	document.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;
	//Setting the New selected Row
	document.frmVndrStaffDtl.selReqType.value = document.frmVndrStaffDtl.hdnSelReqType.value;
	document.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;
	document.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;
	document.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;
	//Setting the new selecte row value to the display hidden variables
	document.frmVndrStaffDtl.hdnDisplayPuvlId.value = document.frmVndrStaffDtl.hdnSelectedPuvlId.value;
	document.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;
	document.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;
	document.frmVndrStaffDtl.hdnDisplayReqType.value = document.frmVndrStaffDtl.hdnSelReqType.value;
	document.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;
	document.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;
	document.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;   
  }
  function checkIsDirty(){
  	var booDirty = false;
    if (document.frmVndrStaffDtl.selReqType.value != document.frmVndrStaffDtl.hdnDisplayReqType.value||
    	document.frmVndrStaffDtl.selStatus.value != document.frmVndrStaffDtl.hdnDisplayStatus.value ||
    	document.frmVndrStaffDtl.dtStart.value != document.frmVndrStaffDtl.hdnDisplayDtStart.value ||
    	document.frmVndrStaffDtl.dtEnd.value != document.frmVndrStaffDtl.hdnDisplayDtEnd.value){
    	booDirty = true;
    } 
    return booDirty; 	
  }
  
  function getResource(){
    var selNewRsrc = document.frmVndrStaffDtl.selNewVendor.value;
    var selNewRsrcNm = "<%= StringHelper.EMPTY_STRING %>";
    var selNewRsrcId = "<%= StringHelper.EMPTY_STRING %>";
    if (selNewRsrc.length > 0){
    	var commaLocation = selNewRsrc.search(",");
    	if (commaLocation > 0){
    		selNewRsrcNm = selNewRsrc.substring(commaLocation+1);
    		selNewRsrcId = selNewRsrc.substring(0,commaLocation);
    	}
    }
    document.frmVndrStaffDtl.hdnAddNewRsrcNm.value = selNewRsrcNm;
	document.frmVndrStaffDtl.hdnAddNewRsrcId.value = selNewRsrcId;
	//Set default as User and status as Pending  
	document.frmVndrStaffDtl.hdnAddNewReqType.value = "<%= CodesTables.CUSRTYP_PUS %>";
	document.frmVndrStaffDtl.hdnAddNewStatus.value = "<%= CodesTables.CUSRSTAT_PEN %>";
	document.frmVndrStaffDtl.hdnAddNewDtStart.value = "<%= StringHelper.EMPTY_STRING %>";
	document.frmVndrStaffDtl.hdnAddNewDtEnd.value = "<%= StringHelper.EMPTY_STRING %>"; 	
  }
  
  function setNewResource(){
    if (document.frmVndrStaffDtl.selNewVendor.value.length <= 0){
    	alert("Please Choose a vendor before continue...");
    	return false;
    }
    //Set the Select Flag False and Add Flag True to mark for Insert
	document.frmVndrStaffDtl.hdnSelectFlag.value = "<%= StringHelper.BOOLEAN_FALSE %>";
	document.frmVndrStaffDtl.hdnAddFlag.value = "<%= StringHelper.BOOLEAN_TRUE %>";
	//Rewriting the inner HTML to display the Resource Name and Resource ID  	
  	document.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;
	document.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;
	//Setting the New selected Row
	document.frmVndrStaffDtl.selReqType.value = document.frmVndrStaffDtl.hdnAddNewReqType.value;
	document.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;
	document.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;
	document.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;
	//Setting the new selecte row value to the display hidden variables
	document.frmVndrStaffDtl.hdnDisplayPuvlId.value = "0";
	document.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;
	document.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;
	document.frmVndrStaffDtl.hdnDisplayReqType.value = document.frmVndrStaffDtl.hdnAddNewReqType.value;
	document.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;
	document.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;
	document.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;	  
  }
  function disableValidate(){
 	disableValidation("frmVndrStaffDtl");
  }
  function warnPasswordReset()
  {
    disableValidate();
    var returnVal = true;
    returnVal = confirm( "<%=MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_REST_WARN )%>" );
    return returnVal;
  }
</script>
<impact:validateErrors/>
<!--if default button set, action needs to to be updated depends on access type -->
<impact:validateForm name="frmVndrStaffDtl" 
						method="post" 
						action="/admin/VendorStaffDetail/saveVendorStaffDetail"
                     	validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.VendorStaffDetailCustomValidation"
                     	schema="/WEB-INF/Constraints.xsd" 
                     	pageMode="<%= PageModeConstants.EDIT %>">
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
<!-- SMS #66384: MR-067 User Profile Detail for NYTD User  --> 
<% if (retrieveVendorStaffDetailSO.getUserAccessType().equals(NYTD_USER)) {
	%>	       
	<% if (toSurveyPageFlag != null) {
		%>					
		<% if (toSurveyPageFlag) {
		%>
			<% if (isInSurveyPeriod && !isSurveyComplete) {
			%>
				<% if (isPassMessageToJsp) {
				%>
				<table border="0" cellspacing="3" cellpadding="0" width="100%">
			      <tr>
			        <td>
			          <hr>
			          <span class="formInfoText">Attention:</span>
			        </td>
			      </tr>
			      <tr>
			      	<td><font color=#0000ff><li>
			      	<span class="formInfoText"><%= MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_UPDATE ) %></span></font>
			      	</td>
			      </tr>
			      <tr>
			        <td><font color=#0000ff><li>
			          <span class="formInfoText">Your User Profile information has been saved. Your NYTD survey response is not complete. Please <a href="/person/PortalSurveyDetail/displayPortalSurveyDetail">click here</a> to complete the survey.</span></font>
			          <hr>
			        </td>
			      </tr>
			    </table>
				<% 
				} else {
				%>
			 	<table border="0" cellspacing="3" cellpadding="0" width="100%">
			      <tr>
			        <td>
			          <hr>
			          <span class="formInfoText">Attention:</span>
			        </td>
			      </tr>
			      <tr>
			        <td><font color=#0000ff><li>
			          <span class="formInfoText">Your User Profile information has been saved. Your NYTD survey response is not complete. Please <a href="/person/PortalSurveyDetail/displayPortalSurveyDetail">click here</a> to complete the survey.</span></font>
			          <hr>
			        </td>
			      </tr>
			    </table>
			    <%
			    } %>					
		<% }
		else {
		%>
				<% if (isPassMessageToJsp) {
				%>
					<table border="0" cellspacing="3" cellpadding="0" width="100%">
			      <tr>
			        <td>
			          <hr>
			          <span class="formInfoText">Attention:</span>
			        </td>
			      </tr>
			      <tr>
			      	<td><font color=#0000ff><li>
			      	<span class="formInfoText"><%= MessageLookup.getMessageByNumber( Messages.MSG_PORTAL_PWD_UPDATE ) %></span></font>
			      	</td>
			      </tr>
			      <tr>
			        <td><font color=#0000ff><li>
					    <span class="formInfoText">Your User Profile information has been saved.</span></font>
			          <hr>
			        </td>
			      </tr>
			    </table>
				<% 
				} else {
				%>
					 <table border="0" cellspacing="3" cellpadding="0" width="100%">
					     <tr>
					        <td>
					          <hr>
					          <span class="formInfoText">Attention:</span>
					        </td>
					      </tr>
					      <tr>
					        <td><font color=#0000ff><li>
					          	<span class="formInfoText">Your User Profile information has been saved.</span></font>				          
					          <hr>
					        </td>
					     </tr>				     
					  </table>
				<% }
				%>
			<% }
			%>	
			<%					
			request.removeAttribute("navToSurveyFlag"); 
			%>
		 <% }
		 %>
<% }
 %>	 
<table border="0"  cellpadding="3" cellspacing="0" align="center">
	<tr>
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
		  	<tr>
		    	<th colspan="6">Basic Data</th>
		  	</tr>
		    <tr>
		     <td>
		      <table border="0" width="100%" cellpadding="3" cellspacing="0" align="center">
		        <tr>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
				                                            name="txtFirstName"
				                                            label="First Name" size="12" maxLength="12" required="true"
				                                            value="<%=FormattingHelper.formatString(nmUserFirst)%>" 
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
				                                            name="txtMiddleInitial"
				                                            label="Middle Initial" size="2" maxLength="1"
				                                            value="<%=FormattingHelper.formatString(nmUserMiddle)%>" 
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
				                                            name="txtLastName"
				                                            label="Last Name" size="22" maxLength="22"  required="true"
				                                            value="<%=FormattingHelper.formatString(nmUserLast)%>" 
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				</tr>
		        </table>		                                           
		       </td>
		     </tr>		     
		     <tr>
		      <td>                   
				  <table border="0" width="100%" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
				  	<tr>
				    	<th colspan="6">Online Contact Information</th>
				  	</tr>
				     <tr>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Email"
				                                            name="txtEmail"
				                                            label="Email" size="50" maxLength="70" required="true"
				                                            value="<%=FormattingHelper.formatString(txtUserEmail)%>" 
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				     </tr>    
	                  <tr>
			             <td>
	      			       <img align="bottom" alt="Facebook User Name" src="/grnds-docs/images/shared/facebookicon.jpg"/>
	     			     </td>
			             <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" 
			                                       name="szTxtFacebook"
			                                       size="50" maxLength="70" required="false"
			                                       value="<%=FormattingHelper.formatString(txtUserFB)%>" 
			                                       editableMode="<%=EditableMode.ALL %>"/></td>     			                                   
			          </tr>
	                  <tr>
			             <td>
	      			       <img align="bottom" alt="MySpace User Name" src="/grnds-docs/images/shared/myspaceicon.gif"/>
	     			     </td>
			             <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" 
			                                       name="szTxtMySpace"
			                                       size="50" maxLength="70" required="false"
			                                       value="<%=FormattingHelper.formatString(txtUserMS)%>" 
			                                       editableMode="<%=EditableMode.ALL %>"/></td>     			                                   
			          </tr>
	                  <tr>
			             <td>
	      			       <img align="bottom" alt="Twitter User Name" src="/grnds-docs/images/shared/twittericon.jpg"/>
	     			     </td>
			             <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" 
			                                       name="szTxtTwitter"
			                                       size="50" maxLength="70" required="false"
			                                       value="<%=FormattingHelper.formatString(txtUserTW)%>" 
			                                       editableMode="<%=EditableMode.ALL %>"/></td>     			                                   
			          </tr>					     
				      <tr>
			             <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" 
			                                       name="szTxtOtherSite"
			                                       label="Other Site" size="50" maxLength="70"  required="false"
			                                       value="<%=FormattingHelper.formatString(txtOthrSt)%>" 
			                                       editableMode="<%=EditableMode.ALL %>"/></td>     			                                   
			             <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" 
			                                       label="User Name" name="szTxtUserName"
			                                       size="50" maxLength="70" conditionallyRequired="true"
			                                       value="<%=FormattingHelper.formatString(txtOthrStUsrNm)%>" 
			                                       editableMode="<%=EditableMode.ALL %>"/></td>   
			          </tr>					     
				  </table>
			  </td>		   
		     </tr>
		     <tr>
		      <td>                   
				  <table border="0" width="100%" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
				     <tr>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Phone"
				                                            name="nbrPhoneBest"
				                                            label="Best Contact Phone Number" size="15" maxLength="15" required="true"
				                                            value="<%=FormattingHelper.formatPhone(TxtUsrPhnBst)%>" 
				                                            cssClass="formInput"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>                                                                   			             				                                            
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="PhoneExtension"
				                                            name="nbrPhoneExtBest"
				                                            label="Ext." size="8" maxLength="8"
				                                            value="<%=FormattingHelper.formatString(TxtUsrPhnBstExt)%>"
				                                            cssClass="formInput"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				       <td>				       
				              <impact:validateInput type="radio" label="Home" name="rbIndPhoneBest" cssClass="formInput"
				                                    checked="<%=String.valueOf(CodesTables.CUSRPHN_HM.equals(FormattingHelper.formatString(TxtUsrPhnBstType)))%>"
				              						value="<%=CodesTables.CUSRPHN_HM%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				              <impact:validateInput type="radio" label="Cell" name="rbIndPhoneBest" cssClass="formInput"
				              						checked="<%=String.valueOf(CodesTables.CUSRPHN_CL.equals(FormattingHelper.formatString(TxtUsrPhnBstType)))%>"
				              						value="<%=CodesTables.CUSRPHN_CL%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				              <impact:validateInput type="radio" label="Work" name="rbIndPhoneBest" cssClass="formInput"
				                                    checked="<%=String.valueOf(CodesTables.CUSRPHN_WK.equals(FormattingHelper.formatString(TxtUsrPhnBstType)))%>"
				              						value="<%=CodesTables.CUSRPHN_WK%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				       </td>				       
				     </tr>
				     <tr>
				     	<td><font color="#808080" size="-1">(###) ###-####</td>
				     </tr>
				     <tr>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Phone"
				                                            name="nbrPhoneAltOne"
				                                            label="Alternate Phone Number 1" size="15" maxLength="15" required="false"
				                                            value="<%=FormattingHelper.formatPhone(TxtUsrPhnAlt1)%>" 
				                                            cssClass="formInput"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="PhoneExtension"
				                                            name="nbrPhoneExtAltOne"
				                                            label="Ext." size="8" maxLength="8"
				                                            value="<%=FormattingHelper.formatString(TxtUsrPhnAlt1Ext)%>"
				                                            cssClass="formInput"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>  				                                            
				       <td>				       
				              <impact:validateInput type="radio" label="Home" name="rbIndPhoneAltOne" cssClass="formInput"
				                                    checked="<%=String.valueOf(CodesTables.CUSRPHN_HM.equals(FormattingHelper.formatString(TxtUsrPhnAlt1Type)))%>"
				              						value="<%=CodesTables.CUSRPHN_HM%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				              <impact:validateInput type="radio" label="Cell" name="rbIndPhoneAltOne" cssClass="formInput"
				              						checked="<%=String.valueOf(CodesTables.CUSRPHN_CL.equals(FormattingHelper.formatString(TxtUsrPhnAlt1Type)))%>"
				              						value="<%=CodesTables.CUSRPHN_CL%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				              <impact:validateInput type="radio" label="Work" name="rbIndPhoneAltOne" cssClass="formInput"
				                                    checked="<%=String.valueOf(CodesTables.CUSRPHN_WK.equals(FormattingHelper.formatString(TxtUsrPhnAlt1Type)))%>"
				              						value="<%=CodesTables.CUSRPHN_WK%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				       </td>	
				     </tr>
				     <tr>
				     	<td><font color="#808080" size="-1">(###) ###-####</td>
				     </tr>
				     <tr>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Phone"
				                                            name="nbrPhoneAltTwo"
				                                            label="Alternate Phone Number 2" size="15" maxLength="15" required="false"
				                                            value="<%=FormattingHelper.formatPhone(TxtUsrPhnAlt2)%>" 
				                                            cssClass="formInput"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="PhoneExtension"
				                                            name="nbrPhoneExtAltTwo"
				                                            label="Ext." size="8" maxLength="8"
				                                            value="<%=FormattingHelper.formatString(TxtUsrPhnAlt2Ext)%>"
				                                            cssClass="formInput"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>	
				       <td>				       
				              <impact:validateInput type="radio" label="Home" name="rbIndPhoneAltTwo" cssClass="formInput"
				                                    checked="<%=String.valueOf(CodesTables.CUSRPHN_HM.equals(FormattingHelper.formatString(TxtUsrPhnAlt2Type)))%>"
				              						value="<%=CodesTables.CUSRPHN_HM%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				              <impact:validateInput type="radio" label="Cell" name="rbIndPhoneAltTwo" cssClass="formInput"
				              						checked="<%=String.valueOf(CodesTables.CUSRPHN_CL.equals(FormattingHelper.formatString(TxtUsrPhnAlt2Type)))%>"
				              						value="<%=CodesTables.CUSRPHN_CL%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				              <impact:validateInput type="radio" label="Work" name="rbIndPhoneAltTwo" cssClass="formInput"
				                                    checked="<%=String.valueOf(CodesTables.CUSRPHN_WK.equals(FormattingHelper.formatString(TxtUsrPhnAlt2Type)))%>"
				              						value="<%=CodesTables.CUSRPHN_WK%>"
				              						tabIndex="<%= tabIndex++ %>"/>
				       </td>	       				       			                                            
				     </tr>
				     <tr>
				     	<td><font color="#808080" size="-1">(###) ###-####</td>
				     </tr>
				     <tr>
				     	<td>
						<span class="formCondRequiredText">&#8225;</span>Can DFCS contact you by text?
						</td>
					    <td>
			        		<impact:validateInput type="radio" label="Yes" name="rbIndText" cssClass="formInput"
			                              	checked="<%=String.valueOf(ArchitectureConstants.Y.equals(TxtCtByTxt)) %>" 
                          					value="<%= ArchitectureConstants.Y %>" tabIndex="<%= tabIndex++ %>"/>

			        		<impact:validateInput type="radio" label="No" name="rbIndText" cssClass="formInput"
			                              	checked="<%=String.valueOf(ArchitectureConstants.N.equals(TxtCtByTxt))%>" 
                          					value="<%= ArchitectureConstants.N %>" tabIndex="<%= tabIndex++ %>"/>
			      		</td>	                          		      		
				     </tr>				     
				  </table>
			  </td>		   
		     </tr>			     
		     <tr>
		      <td>                   
				  <table border="0" width="100%" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
				     <tr>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address"
				                                            name="txtAddress1"
				                                            label="Address" size="30" maxLength="30" required="false"
				                                            value="<%=FormattingHelper.formatString(addrUserAddrStLn1)%>" 
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				     </tr>
				     <tr>
				       <td></td>
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address2"
				                                            name="txtAddress2"
				                                            size="30" maxLength="30"
				                                            value="<%=FormattingHelper.formatString(addrUserAddrStLn2)%>"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				     </tr>
				     <tr>                                            
				       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="City"
				                                            name="txtCity"
				                                            label="City" size="20" maxLength="20"  required="false"
				                                            value="<%=FormattingHelper.formatString(addrUserAddrCity)%>"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>
				       <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
				                                            name="selState"
				                                            label="State"
				                                            codesTable="CSTATE"
				                                            value="<%=FormattingHelper.formatString(cdUserAddrState)%>"
				                                            required="false"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
				     </tr>
				     <tr>                                            
				       <td>
				       	<impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Zip"
				                                            name="txtZip"
				                                            label="Zip" size="5" maxLength="5"  required="false"
				                                            value="<%=FormattingHelper.formatString(addrUserAddrZip)%>"
				                                            editableMode="<%=EditableMode.ALL %>"/>
				       	&nbsp;&nbsp; - &nbsp;&nbsp;
				       	<impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="ZipSuff"
				                                            name="txtZipSuff"
				                                            size="4" maxLength="4"
				                                            value="<%=FormattingHelper.formatString(addrUserAddrZipStuff)%>"
				                                            editableMode="<%=EditableMode.ALL %>"/>
				       </td>
				       <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
				                                            name="selCounty"
				                                            label="County"
				                                            codesTable="CCOUNT"
				                                            value="<%=FormattingHelper.formatString(cdUserAddrCounty)%>"
				                                            required="false"
				                                            editableMode="<%=EditableMode.ALL %>"/></td>       
				     </tr> 
				  </table>
			  </td>		   
		     </tr>
		     <tr>
		      <td>                   
				  <table border="0" width="100%" cellpadding="3" cellspacing="0" align="center">
				     <tr>
				     	<td>
						<span class="formRequiredText">*</span>If we cannot locate you, who is a reliable adult who knows where you are? (Name and Contact Information):
						</td>
					</tr>
			      	<tr>   				     
					    <td><!--- Text Area Custom Tag --->
					    <impact:validateTextArea name="szTxtEmerContact" rows="4" cols="140" maxLength="300"
					                             tabIndex="<%= tabIndex++ %>"
					                             constraint="Comments"
					                             editableMode="<%=EditableMode.ALL %>">
					                             <%= FormattingHelper.formatString(TxtEmrContact)%>				                             					      
					    </impact:validateTextArea>
					  </td>	 				                                            
				     </tr>	 			     
				  </table>
			  </td>		   
		     </tr>	     	     		     	     	     		     
		  </table>
	  </td>	  
	</tr>
 		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
			    <tr>
			    	<th colspan="3">Current Password</th>
			  	</tr>	
		        <tr>
	            	<td width="120"><impact:validateInput type="password" tabIndex="<%=tabIndex++%>"
	                                                 colspan="2" name="txtCurrentPassword" conditionallyRequired="true"
	                                                 label="Password" maxLength="20"/></td>
	          	</tr>
			  </table>
		  </td>
		</tr>  	
		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
			    <tr>
			    	<th colspan="3">New Password</th>
			  	</tr>	
		        <tr>
	            	<td width="120"><impact:validateInput type="password" tabIndex="<%=tabIndex++%>"
	                                                 colspan="2" name="txtNewPassword" 
	                                                 label="New Password" maxLength="20"/></td>
	          	</tr>
	          	<tr>
	            	<td width="120"><impact:validateInput type="password" tabIndex="<%=tabIndex++%>"
	                                                 colspan="2" name="txtNewPasswordConfirm"  conditionallyRequired="true"
	                                                 label="Re-Enter New Password" maxLength="20"/></td>
	          	</tr>
			  </table>
		  </td>
		</tr>
		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="left">
			    <tr>
			    	<th colspan="6">Security Questions</th>
			  	</tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selSecQues1"
			                                            codesTable="CSECQUES"
			                                            required="true"
			                                            label ="Question 1"
			                                            value="<%=seqQues1%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
			                                            name="txtSecAns1"
			                                            size="30" maxLength="30"
			                                            required="true"
			                                            label="Answer 1"
			                                            value="<%=seqAns1%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
			    </tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selSecQues2"
			                                            codesTable="CSECQUES"
			                                            required="true"
			                                            label ="Question 2"
			                                            value="<%=seqQues2%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
			                                            name="txtSecAns2"
			                                            size="30" maxLength="30"
			                                            required="true"
			                                            label ="Answer 2"
			                                            value="<%=seqAns2%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
			    </tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selSecQues3"
			                                            codesTable="CSECQUES"
			                                            required="true"
			                                            label ="Question 3"
			                                       		value="<%=seqQues3%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
			                                            name="txtSecAns3"
			                                            label ="Answer 3"
			                                            size="30" maxLength="30"
			                                            required="true"
			                                            value="<%=seqAns3%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
			    </tr>                     
			  </table>
		  </td>
		</tr>
		<tr>      
		  <td>
			  <table border="0" cellpadding="3" cellspacing="0" align="left">
			  	<tr>
			  		<td></td>
			  		<td width="100%">
			  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/saveUserProfileDetail"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
</table>	     
<% } else {  %>
<table border="0"  cellpadding="3" cellspacing="0" align="center">
	<tr>
	  <td>                   
		  <table border="0" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
		  	<tr>
		    	<th colspan="6">Basic Data</th>
		  	</tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtFirstName"
		                                            label="First Name" size="12" maxLength="12" required="true"
		                                            value="<%=FormattingHelper.formatString(nmUserFirst)%>" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtMiddleInitial"
		                                            label="Middle Initial" size="2" maxLength="1"
		                                            value="<%=FormattingHelper.formatString(nmUserMiddle)%>" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtLastName"
		                                            label="Last Name" size="22" maxLength="22"  required="true"
		                                            value="<%=FormattingHelper.formatString(nmUserLast)%>" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Name"
		                                            name="txtTitle"
		                                            label="Title" size="20" maxLength="20"  required="true"
		                                            value="<%=FormattingHelper.formatString(txtTitle)%>" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Email"
		                                            name="txtEmail"
		                                            label="Email" size="50" maxLength="70" required="true"
		                                            value="<%=FormattingHelper.formatString(txtUserEmail)%>" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Phone"
		                                            name="txtPhoneNumber"
		                                            label="Phone Number" size="15" maxLength="15" required="true"
		                                            value="<%=FormattingHelper.formatPhone(nbrUserPhone)%>" 
		                                            cssClass="formInput"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="PhoneExtension"
		                                            name="txtPhoneExtension"
		                                            label="Ext" size="8" maxLength="8"
		                                            value="<%=FormattingHelper.formatString(nbrUserPhoneExtension)%>"
		                                            cssClass="formInput"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address"
		                                            name="txtAddress1"
		                                            label="Office Address" size="30" maxLength="30" required="true"
		                                            value="<%=FormattingHelper.formatString(addrUserAddrStLn1)%>" 
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>
		       <td></td>
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address2"
		                                            name="txtAddress2"
		                                            size="30" maxLength="30"
		                                            value="<%=FormattingHelper.formatString(addrUserAddrStLn2)%>"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		     </tr>
		     <tr>                                            
		       <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="City"
		                                            name="txtCity"
		                                            label="City" size="20" maxLength="20"  required="true"
		                                            value="<%=FormattingHelper.formatString(addrUserAddrCity)%>"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>
		       <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selState"
		                                            label="State"
		                                            codesTable="CSTATE"
		                                            value="<%=FormattingHelper.formatString(cdUserAddrState)%>"
		                                            required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
		     </tr>
		     <tr>                                            
		       <td>
		       	<impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Zip"
		                                            name="txtZip"
		                                            label="Zip" size="5" maxLength="5"  required="true"
		                                            value="<%=FormattingHelper.formatString(addrUserAddrZip)%>"
		                                            editableMode="<%=EditableMode.ALL %>"/>
		       	&nbsp;&nbsp; - &nbsp;&nbsp;
		       	<impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="ZipSuff"
		                                            name="txtZipSuff"
		                                            size="4" maxLength="4"
		                                            value="<%=FormattingHelper.formatString(addrUserAddrZipStuff)%>"
		                                            editableMode="<%=EditableMode.ALL %>"/>
		       </td>
		       <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
		                                            name="selCounty"
		                                            label="County"
		                                            codesTable="CCOUNT"
		                                            value="<%=FormattingHelper.formatString(cdUserAddrCounty)%>"
		                                            required="true"
		                                            editableMode="<%=EditableMode.ALL %>"/></td>       
		     </tr> 
		  </table>
	  </td>
	</tr>
	<% 
		if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_STAFF_LIST)||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST))){
  			List<RetrieveVendorStaffLinkDetailBean> resourceListForUser = retrieveVendorStaffDetailSO.getResourceListforUser();
  			//If they are an active admin of any agency, we will restrict the right of the current user to reset the password
  			boolean isActiveAdmin = false;
  	%>
	<tr>      
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" align="left">
		  	<tr>
		  		<td></td>
		  		<td width="100%">
		  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
		  							action="/admin/VendorStaffDetail/saveVendorStaffDetail"
		                            tabIndex="<%=tabIndex++%>"/>
		  		</td>
		  	</tr>
		  </table>
	  </td>
	</tr>  	
	<tr>
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" class="tableBorder" width="100%" align="center">
		    <tr>
		    	<th>Associated Vendors</th>
		  	</tr>
		  	<tr>
		  	  <td>
		  	    <div id="noScrollResults" style="height:190px; width:100%; overflow:auto" class="tableborderList">
				    <table width="100%" cellspacing="0" cellpadding="3">
				      <tr>
				        <th class="thList">&nbsp;</th>
				        <th class="thList">Resource Name</th>
				        <th class="thList">Resource ID</th>
				        <th class="thList">Type</th>
				        <th class="thList">Status</th>
				        <th class="thList">Start Date</th>
				        <th class="thList">End Date</th>
				      </tr>
			      <%
			         if (resourceListForUser.size() <= 0){
			      %>
			          <tr class="odd">
			            <td colspan="4">
			              <%= MessageLookup.getMessageByNumber( Messages.MSG_SVC_NO_EXT_DOC_MATCH ) %>
			            </td>
			          </tr>
			      	<tr>
			          <%
			      		} else {
			      		    boolean firstEnabledRowSelected = false;
			      			for (Iterator<RetrieveVendorStaffLinkDetailBean> it = resourceListForUser.iterator();it.hasNext();){
			      			  boolean vendorAdmin = false;
					          RetrieveVendorStaffLinkDetailBean vendorStaffLinkDetBean = 
					          			(RetrieveVendorStaffLinkDetailBean) it.next();
					          //Disabling the radio button for not allowing to select if the user is not an admin
					          //for the resource

				          	  if ((activeRsrcListMap.containsKey(vendorStaffLinkDetBean.getIdResource())) 
		          					&& !(retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_USRER)
  										|| (retrieveVendorStaffDetailSO.getUserAccessType().equals(PLCMNT_PRV_ADMIN) &&
												retrieveVendorStaffDetailSO.getIdUser().
 														equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())))){
 								disableAssocVndrRadio = "false";
				          		vendorAdmin = true;
				          	  }
					          if (!vendorAdmin){
					          	disableAssocVndrRadio = "true";
					          }
					          
					          //Determine if they are an active administrator of any agency
					          if ((CodesTables.CUSRTYP_PAD.equals(vendorStaffLinkDetBean.getCdAccessType() != null ? vendorStaffLinkDetBean.getCdAccessType() : ""))&&
					          (CodesTables.CUSRSTAT_ACT.equals(vendorStaffLinkDetBean.getCdStatus() != null ? vendorStaffLinkDetBean.getCdStatus() : ""))) {
					 
					             isActiveAdmin = true;
					 
					          }
					          
					          
					          radioRsrcChecked = "false";
					          //Get the first row and load it during the initial load
					          if (!firstEnabledRowSelected && vendorAdmin){
					            firstEnabledRowSelected = true;
					            radioRsrcChecked = "true";
					            selectedPuvlId = FormattingHelper.formatString(
	  														String.valueOf(vendorStaffLinkDetBean.getIdPortalUserVendorLink()));
			            	  	selectedRsrcNm = vendorStaffLinkDetBean.getNmResource();
	  							selectedRsrcId = FormattingHelper.formatString(
	  														String.valueOf(vendorStaffLinkDetBean.getIdResource()));
						  	  	selectedType = vendorStaffLinkDetBean.getCdAccessType();
						  	  	selectedStatus = vendorStaffLinkDetBean.getCdStatus();
						  	  	selectedStartDt = FormattingHelper.formatString(
						  	  						String.valueOf(vendorStaffLinkDetBean.getDtStart()).equals("null")?
						  	  						StringHelper.EMPTY_STRING:String.valueOf(DateHelper.SLASH_FORMAT.format(vendorStaffLinkDetBean.getDtStart())));
						  	  	selectedEndDt = FormattingHelper.formatString(
						  	  						String.valueOf(vendorStaffLinkDetBean.getDtEnd()).equals("null")?
						  	  						StringHelper.EMPTY_STRING:String.valueOf(DateHelper.SLASH_FORMAT.format(vendorStaffLinkDetBean.getDtEnd())));
					          }
					          String rowCss = FormattingHelper.getRowCss(resourceCount + 1);
					          populateFields = "populateFields('" + String.valueOf( vendorStaffLinkDetBean.getIdPortalUserVendorLink() )
					          								+ "','"+ FormattingHelper.formatString(vendorStaffLinkDetBean.getNmResource()).replaceAll("'","") 
					          								+ "','"+String.valueOf( vendorStaffLinkDetBean.getIdResource() )
					          								+ "','"+FormattingHelper.formatString(vendorStaffLinkDetBean.getCdAccessType())
					          								+ "','"+FormattingHelper.formatString(vendorStaffLinkDetBean.getCdStatus())
					          								+ "','"+FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtStart())
					          								+ "','"+FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtEnd())
					          								+ "');";
			      	  %>
			      <tr class="<%=rowCss%>">
			        <td width="5%">
			          <impact:validateInput
			                  type="radio"
			                  name="rbResource"
			                  checked="<%=radioRsrcChecked%>"
			                  value="<%= String.valueOf( vendorStaffLinkDetBean.getIdPortalUserVendorLink() ) %>"
			                  onClick="<%=populateFields%>"
			                  disabled="<%=disableAssocVndrRadio%>"
			                  tabIndex="<%= tabIndex++ %>"/>
					</td>
			        <td><%= FormattingHelper.formatString(vendorStaffLinkDetBean.getNmResource()) %>
			        </td>
			        <td><%= FormattingHelper.formatString(String.valueOf(vendorStaffLinkDetBean.getIdResource())) %>
			        </td>
			        <td><%= vendorStaffLinkDetBean.getCdAccessType() != null ?
                			Lookup.simpleDecodeSafe("CUSRTYP", vendorStaffLinkDetBean.getCdAccessType()) : "&nbsp;" %>
			        </td>
			        <td><%= vendorStaffLinkDetBean.getCdStatus() != null ?
                			Lookup.simpleDecodeSafe("CUSRSTAT", vendorStaffLinkDetBean.getCdStatus()) : "&nbsp;" %>
			        </td>
			        <td><%= FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtStart()) %></td>
			        <td><%= FormattingHelper.formatDate(vendorStaffLinkDetBean.getDtEnd()) %></td>
			      </tr>
			      <%
			        resourceCount++;
			      	}
			        }%>
			    </table>
			  </div>	
			 </td>
		    </tr>   
		  </table>
	  </td>
	</tr>
    <impact:ifThen test='<%=(resourceListForUser.size() > 0 && userAccessType.equals(PLCMNT_PRV_ADMIN)
    						&& !retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())) %>'>
		<tr>      
		  <td>
			  <table border="0" cellpadding="3" cellspacing="0" align="left">
			  	<tr>
			  	
			  		<td width="100%">
			  			<img align="left" src="/grnds-docs/images/shared/btnSelect.gif" name="select" 
			  					onclick="return fillFields();" >
			        </td>
			  		<td width="100%">
			  			<impact:ButtonTag name="Delete" img="btnDelete" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/deleteVendor" function="disableValidate();"
			                            restrictRepost="true" tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
   	</impact:ifThen>
    <impact:ifThen test='<%=(userAccessType.equals(PLCMNT_PRV_ADMIN)
    							&& !retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())) %>'> 
		<tr>
		  <td>                   
			  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" align="center">
			  	<tr>
			    	<th colspan="6">Selected Vendor Detail</th>
			  	</tr>
			     <tr>
			       <td>
			       		<impact:validateDisplayOnlyField 
							name="rsrcNm" 
							label="Resource Name" 
							value="<%=selectedRsrcNm %>" />		       
			       		
					</td>
			     </tr>
			     <tr>
			       	<td>
						<impact:validateDisplayOnlyField 
	  		     			name="rsrcId" 
	  						label="Resource ID" 
							value="<%=selectedRsrcId %>" />
					</td>		                                            
			     </tr>
			     <tr>
			       <td></td>
			     </tr>
			     <tr>		                                            
	       		     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
	                                            name="selReqType"
	                                            label="User Type"
	                                            codesTable="CUSRTYP"
	                                            conditionallyRequired="true"
	                                            value="<%=selectedType%>"
	                                            disabled="<%=disableUsrTyp%>"
	                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     </tr>
			     <tr>		                                            
	       		     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
	                                            name="selStatus"
	                                            label="Status"
	                                            codesTable="CUSRSTAT"
	                                            conditionallyRequired="true"
	                                            options="<%= VendorStaffDetailConversation.getMethodOptions(retrieveVendorStaffDetailSO.getScreenName() !=null ? retrieveVendorStaffDetailSO.getScreenName(): "") %>"
	                                            value="<%=selectedStatus%>"
	                                            disabled="<%=disableStatus%>"
	                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     </tr>		     
			     <tr>
			       <td><impact:validateDate name="dtStart" 
			       							label="Start Date" 
			       							conditionallyRequired="true" 
			       							value="<%=selectedStartDt%>" 
			       							size="10" constraint="Date" 
			       							tabIndex="<%= tabIndex++ %>"/></td>
			     </tr>
			     <tr>
			       <td><impact:validateDate name="dtEnd" 
			       							label="End Date" 
			       							value="<%=selectedEndDt%>" 
			       							conditionallyRequired="true"
			       							size="10" constraint="Date" 
			       							tabIndex="<%= tabIndex++ %>"/></td>
			     </tr>
			  </table>
		  </td>
		</tr>
		<tr>      
		  <td>
			  <table border="0" cellpadding="3" cellspacing="0" align="left">
			  	<tr>
			  		<td></td>
			  		<td width="100%">
			  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/saveVendorStaffDetail"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
		<tr>
		  <td>                   
			  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" align="center">
			  	<tr>
			    	<th colspan="6">Associate New Vendor</th>
			  	</tr>
			     <tr>		                                            
				    <td><impact:validateSelect
				                               style="WIDTH: 160px"
				                               label="New Vendor"
				                               name="selNewVendor"
				                               style="WIDTH: 240px"
				                               value="<%=FormattingHelper.formatString(idVendor)%>"
				                               tabIndex="<%= tabIndex++ %>"
				                               editableMode="<%= EditableMode.ALL %>"
				                               disabled="false"
				                               onChange="getResource();"
				                               options="<%=resourceIDList%>"/>
				    </td>
			  		<td width="100%">
			  			<img align="right" src="/grnds-docs/images/shared/btnAdd.gif" name="add" 
			  					onclick="return setNewResource();" >
			        </td>			    
			  	 </tr>		     		  	
			  </table>
		  </td>
		</tr>
	</impact:ifThen>
	<impact:ifThen test='<%=(retrieveVendorStaffDetailSO.getScreenName()!=null && 
  							(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_STAFF_LIST)) && 
  							(userAccessType.equals(PLCMNT_PRV_ADMIN))
  							&& !retrieveVendorStaffDetailSO.getIdUser().
 								equals(retrieveVendorStaffDetailSO.getIdLoggedInUser()) &&
 								!isActiveAdmin) %>'>
		<tr>
		  <td>                   
			  <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" align="center">
			  	<tr>
			    	<th colspan="6">Password Reset</th>
			  	</tr>
			     <tr>		                                            
				     <td align="left">
				        Click the reset button to reset this user's password with a temporary password and e-mail the temporary password to the e-mail address above.
				     </td>
			  		<td>
			  			<impact:ButtonTag name="Reset" img="btnReset" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/resetPassword" function="return warnPasswordReset();"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	 </tr>		     		  	
			  </table>
		  </td>
		</tr>  
	</impact:ifThen>
	<impact:ifThen test='<%=(userAccessType.equals(PLCMNT_PRV_ADMIN)
								&& !retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser())) %>'> 	
		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
			    <tr>
			    	<th colspan="2">Administrator Agreement</th>
			  	</tr>
			    <tr>
			     <td align="left">
			        By clicking on the checkbox below, the administrator confirms that the person to whom they are granting access shall abide by all state and federal laws, rules, and regulations, and the Department of Human Services policy on respecting the confidentiality of an individual's records.  These citations include, but are not limited to, O.C.G.A Sections 49-4-14, 49-5-40, 49-5-41, 50-18-72, and 45 CFR 205.5.  The administrator understands that all records concerning children placed in the custody of the Department of Human Services or all individuals who are the subject of or are included in a child protective services investigation are made confidential by O.C.G.A  Section 49-5-40 and may not be released to anyone except in compliance with O.C.G.A Section 49-5-41.  The administrator also understands that information concerning recipients of TANF, Food Stamps, and Medicaid may only be disclosed pursuant to O.C.G.A Section 49-4-14.
			     </td>
			    </tr>
			    <tr>
			     <td>
			        <impact:validateInput
			              tabIndex="<%= tabIndex++ %>"
			              label="I accept the agreement"
			              type="checkbox"
			              id="idUsrAgrmnt"
			              name="cbxUsrAgrmnt"
			              conditionallyRequired="true"
			              editableMode="<%=EditableMode.ALL %>"/>
			     </td>
			    </tr>             
			  </table>
		  </td>
		</tr>
	</impact:ifThen>	
	<impact:ifThen test='<%=(retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(PORTAL_PENDING_STAFF_LIST))) %>'>
		<tr>      
		  <td>
			  <table border="0" cellpadding="3" cellspacing="0" align="left">
			  	<tr>
			  		<td width="100%">
			  			<impact:ButtonTag name="Approve" img="btnApprove" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/approveVendorStaffDetail"
			  							restrictRepost="true"
			                            tabIndex="<%=tabIndex++%>"/>
			        </td>
			  		<td width="100%">
			  			<impact:ButtonTag name="Disapprove" img="btnDisapprove" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/disapproveVendorStaffDetail"
			  							restrictRepost="true"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
	</impact:ifThen>					 	  	
	<%
		}
  	%>  	
  	<impact:ifThen test='<%=(userAccessType.equals(PLCMNT_PRV_USRER) 
  								|| (userAccessType.equals(PLCMNT_PRV_ADMIN) &&
  										retrieveVendorStaffDetailSO.getIdUser().
    									equals(retrieveVendorStaffDetailSO.getIdLoggedInUser()))) %>'>
		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
			    <tr>
			    	<th colspan="3">Current Password</th>
			  	</tr>	
		        <tr>
	            	<td width="120"><impact:validateInput type="password" tabIndex="<%=tabIndex++%>"
	                                                 colspan="2" name="txtCurrentPassword" conditionallyRequired="true"
	                                                 label="Password" maxLength="20"/></td>
	          	</tr>
			  </table>
		  </td>
		</tr>  	
		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="center">
			    <tr>
			    	<th colspan="3">Password</th>
			  	</tr>	
		        <tr>
	            	<td width="120"><impact:validateInput type="password" tabIndex="<%=tabIndex++%>"
	                                                 colspan="2" name="txtNewPassword" 
	                                                 label="New Password" maxLength="20"/></td>
	          	</tr>
	          	<tr>
	            	<td width="120"><impact:validateInput type="password" tabIndex="<%=tabIndex++%>"
	                                                 colspan="2" name="txtNewPasswordConfirm"  conditionallyRequired="true"
	                                                 label="Re-Enter New Password" maxLength="20"/></td>
	          	</tr>
			  </table>
		  </td>
		</tr>
		<tr>      
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" align="left">
		  	<tr>
		  		<td></td>
		  		<td width="100%">
		  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
		  							action="/admin/VendorStaffDetail/saveVendorStaffDetail"
		                            tabIndex="<%=tabIndex++%>"/>
		  		</td>
		  	</tr>
		  </table>
	  </td>
	</tr>
		<tr>
		  <td>  
			  <table border="0" cellpadding="3" width="100%" cellspacing="0" class="tableBorder" align="left">
			    <tr>
			    	<th colspan="6">Security Questions</th>
			  	</tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selSecQues1"
			                                            codesTable="CSECQUES"
			                                            required="true"
			                                            label ="Question 1"
			                                            value="<%=seqQues1%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
			                                            name="txtSecAns1"
			                                            size="30" maxLength="30"
			                                            required="true"
			                                            label="Answer 1"
			                                            value="<%=seqAns1%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
			    </tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selSecQues2"
			                                            codesTable="CSECQUES"
			                                            required="true"
			                                            label ="Question 2"
			                                            value="<%=seqQues2%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
			                                            name="txtSecAns2"
			                                            size="30" maxLength="30"
			                                            required="true"
			                                            label ="Answer 2"
			                                            value="<%=seqAns2%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
			    </tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selSecQues3"
			                                            codesTable="CSECQUES"
			                                            required="true"
			                                            label ="Question 3"
			                                       		value="<%=seqQues3%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>"
			                                            name="txtSecAns3"
			                                            label ="Answer 3"
			                                            size="30" maxLength="30"
			                                            required="true"
			                                            value="<%=seqAns3%>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>                                            
			    </tr>                     
			  </table>
		  </td>
		</tr>
		<tr>      
		  <td>
			  <table border="0" cellpadding="3" cellspacing="0" align="left">
			  	<tr>
			  		<td></td>
			  		<td width="100%">
			  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
			  							action="/admin/VendorStaffDetail/saveVendorStaffDetail"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
	</impact:ifThen>
</table>
<% } %>
  <impact:validateInput type="hidden" name="hdnScreenName" value="<%= retrieveVendorStaffDetailSO.getScreenName() %>" />
  <impact:validateInput type="hidden" name="hdnSelectFlag" value="<%= StringHelper.BOOLEAN_TRUE %>" />
  <impact:validateInput type="hidden" name="hdnAddFlag" value="<%= StringHelper.BOOLEAN_FALSE %>" />
  <impact:validateInput type="hidden" name="hdnSelectedPuvlId" value="<%= selectedPuvlId %>" />
  <impact:validateInput type="hidden" name="hdnSelectedRsrcNm" value="<%= selectedRsrcNm %>" />
  <impact:validateInput type="hidden" name="hdnSelectedRsrcId" value="<%= selectedRsrcId %>" />
  <impact:validateInput type="hidden" name="hdnSelReqType" value="<%= selectedType %>" />
  <impact:validateInput type="hidden" name="hdnSelStatus" value="<%= selectedStatus %>" />
  <impact:validateInput type="hidden" name="hdnDtStart" value="<%= selectedStartDt %>" />
  <impact:validateInput type="hidden" name="hdnDtEnd" value="<%= selectedEndDt %>" />
  <impact:validateInput type="hidden" name="hdnDisplayPuvlId" value="<%= selectedPuvlId %>" />
  <impact:validateInput type="hidden" name="hdnDisplayRsrcNm" value="<%= selectedRsrcNm %>" />
  <impact:validateInput type="hidden" name="hdnDisplayRsrcId" value="<%= selectedRsrcId %>" />
  <impact:validateInput type="hidden" name="hdnDisplayReqType" value="<%= selectedType %>" />
  <impact:validateInput type="hidden" name="hdnDisplayStatus" value="<%= selectedStatus %>" />
  <impact:validateInput type="hidden" name="hdnDisplayDtStart" value="<%= selectedStartDt %>" />
  <impact:validateInput type="hidden" name="hdnDisplayDtEnd" value="<%= selectedEndDt %>" />
  <impact:validateInput type="hidden" name="hdnAddNewRsrcNm" value="<%= selectedRsrcNm %>" />
  <impact:validateInput type="hidden" name="hdnAddNewRsrcId" value="<%= selectedRsrcId %>" />
  <impact:validateInput type="hidden" name="hdnAddNewReqType" value="<%= selectedType %>" />
  <impact:validateInput type="hidden" name="hdnAddNewStatus" value="<%= selectedStatus %>" />
  <impact:validateInput type="hidden" name="hdnAddNewDtStart" value="<%= selectedStartDt %>" />
  <impact:validateInput type="hidden" name="hdnAddNewDtEnd" value="<%= selectedEndDt %>" />
      
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  document.frmVndrStaffDtl.txtFirstName.focus();
  //Rewriting the inner HTML to display the Resource Name and Resource ID  	
  document.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;
  document.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;
	  
</script>