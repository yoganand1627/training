
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.VendorStaffDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%
  // Initialize tabIndex
  int tabIndex = 1;
  String disableTxtOther = "false";
  int resourceCount = 0;
  //Same as in the VendorStaffDetailConversation.java
    //Note: the following are only used in SHINES
  String SHINES_STAFF_LIST = "shinesActive";
  
  String SHINES_PENDING_STAFF_LIST = "shinesPending";
  
  String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  
  String SEC_VENDOR_STAFF_ACCESS = "SEC_VENDOR_STAFF_ACCESS";

  String FROM_LIST_PAGE = "FROM_LIST_PAGE";
  
  String FROM_RSRC_SEARCH = "FROM_RSRC_SEARCH";
  // Get the serialized request
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  //Get the SO object
  RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = (RetrieveVendorStaffDetailSO)state.getAttribute("retrieveVendorStaffDetailSO",request);
  List resourceIDList = new ArrayList();
  String idVendor = StringHelper.EMPTY_STRING;
  String nmUserFirst = StringHelper.EMPTY_STRING;
  String nmUserMiddle = StringHelper.EMPTY_STRING;
  String nmUserLast = StringHelper.EMPTY_STRING;
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
  String selectedPuvlId = StringHelper.EMPTY_STRING;
  String selectedRsrcNm = StringHelper.EMPTY_STRING;
  String selectedRsrcId = StringHelper.EMPTY_STRING;
  String selectedType = StringHelper.EMPTY_STRING;
  String selectedStatus = StringHelper.EMPTY_STRING;
  String selectedStartDt = StringHelper.EMPTY_STRING;
  String selectedEndDt = StringHelper.EMPTY_STRING;
  String populateFields = StringHelper.EMPTY_STRING;
  String userAccessType = StringHelper.EMPTY_STRING;
  String cdReqType = StringHelper.EMPTY_STRING;
  String txtOther = StringHelper.EMPTY_STRING;
  String selectFlagVal = StringHelper.BOOLEAN_TRUE;
  String addFlagVal = StringHelper.BOOLEAN_FALSE;
  String destinationUrl = StringHelper.EMPTY_STRING;
  String radioRsrcChecked = StringHelper.EMPTY_STRING;
  if (retrieveVendorStaffDetailSO!=null){
  	resourceIDList = retrieveVendorStaffDetailSO.getResourceList();
  	if (resourceIDList != null && resourceIDList.size() > 0){
  	  Option option = (Option)resourceIDList.get(0);
  	  idVendor = String.valueOf(option.getKey());
  	}
  	if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST))){
  	  if (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST)){
  	   destinationUrl = "/resource/VendorStaffDetail/setResourcePending";
  	  }else if (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST)){
  	   destinationUrl = "/resource/VendorStaffDetail/setResource";
  	  }else if (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)){
  	   destinationUrl = "/resource/VendorStaffDetail/setResourceStaff";
  	  }
  	  disableStatus = (retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST)||
  	  					retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST))?
  	  																				"true":"false";		 
  	  userAccessType = retrieveVendorStaffDetailSO.getUserAccessType();
  	  cdReqType = retrieveVendorStaffDetailSO.getCdRequestType();
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
  	  txtOther = retrieveVendorStaffDetailSO.getTxtOther();
  	  if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 9) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  	addrUserAddrZipStuff = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(5);
  	  }else if (retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() < 9 
  	  				&& retrieveVendorStaffDetailSO.getAddrUserAddrZip().length() >= 5) {
  	  	addrUserAddrZip = retrieveVendorStaffDetailSO.getAddrUserAddrZip().substring(0,5);
  	  }
  	  
  	  cdUserAddrState = retrieveVendorStaffDetailSO.getCdUserAddrState();
  	  cdUserAddrCounty = retrieveVendorStaffDetailSO.getCdUserAddrCounty();
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
        if (("selStatus"!= eElem.name && "selUserType"!= eElem.name) && eOpt.selected != eOpt.defaultSelected) {
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
	document.frmVndrStaffDtl.hdnSelUserType.value = cdAccessType;
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
	document.frmVndrStaffDtl.selUserType.value = document.frmVndrStaffDtl.hdnSelUserType.value;
	document.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;
	document.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;
	document.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;
	//Setting the new selecte row value to the display hidden variables
	document.frmVndrStaffDtl.hdnDisplayPuvlId.value = document.frmVndrStaffDtl.hdnSelectedPuvlId.value;
	document.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;
	document.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;
	document.frmVndrStaffDtl.hdnDisplayUserType.value = document.frmVndrStaffDtl.hdnSelUserType.value;
	document.frmVndrStaffDtl.hdnDisplayStatus.value = document.frmVndrStaffDtl.hdnSelStatus.value;
	document.frmVndrStaffDtl.hdnDisplayDtStart.value = document.frmVndrStaffDtl.hdnDtStart.value;
	document.frmVndrStaffDtl.hdnDisplayDtEnd.value = document.frmVndrStaffDtl.hdnDtEnd.value;   
  }
  function checkIsDirty(){
  	var booDirty = false;
    if (document.frmVndrStaffDtl.selUserType.value != document.frmVndrStaffDtl.hdnDisplayUserType.value||
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
	document.frmVndrStaffDtl.hdnAddNewUserType.value = "<%= CodesTables.CUSRTYP_PUS %>";
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
	document.frmVndrStaffDtl.selUserType.value = document.frmVndrStaffDtl.hdnAddNewUserType.value;
	document.frmVndrStaffDtl.selStatus.value = document.frmVndrStaffDtl.hdnAddNewStatus.value;
	document.frmVndrStaffDtl.dtStart.value = document.frmVndrStaffDtl.hdnAddNewDtStart.value;
	document.frmVndrStaffDtl.dtEnd.value = document.frmVndrStaffDtl.hdnAddNewDtEnd.value;
	//Setting the new selecte row value to the display hidden variables
	document.frmVndrStaffDtl.hdnDisplayPuvlId.value = "0";
	document.frmVndrStaffDtl.hdnDisplayRsrcNm.value = document.frmVndrStaffDtl.hdnAddNewRsrcNm.value;
	document.frmVndrStaffDtl.hdnDisplayRsrcId.value = document.frmVndrStaffDtl.hdnAddNewRsrcId.value;
	document.frmVndrStaffDtl.hdnDisplayUserType.value = document.frmVndrStaffDtl.hdnAddNewUserType.value;
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
<impact:validateForm name="frmVndrStaffDtl" 
						method="post" 
						action="/resource/VendorStaffDetail/saveVendorStaffDetail"
                     	validationClass="gov.georgia.dhr.dfcs.sacwis.web.resource.VendorStaffDetailCustomValidation"
                     	schema="/WEB-INF/Constraints.xsd" 
                     	pageMode="<%= PageModeConstants.EDIT %>">
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
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
		                                            label="Email" size="50" maxLength="320"  required="true"
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
		                                            label="Ext" size="10" maxLength="10"
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
	<impact:ifThen test='<%=(retrieveVendorStaffDetailSO.getScreenName()!=null &&
    							!retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)) %>'>
    							
		<tr>
		  <td>
			  <table border="0" cellpadding="3" cellspacing="0" class="tableBorder" align="center">
			    <tr>
			    	<th colspan="2">Access Request</th>
			  	</tr>
			    <tr>
			     <td><impact:validateSelect tabIndex="<%=tabIndex++%>"
			                                            name="selReqType"
			                                            label="Request Type"
			                                            codesTable="CUSRTYP"
			                                            disabled="true"
			                                            value="<%=cdReqType %>"
			                                            editableMode="<%=EditableMode.ALL %>"/></td>
			    </tr>
				  <tr>    
				    <td><impact:validateSelect
				                               style="WIDTH: 160px"
				                               label="Vendor"
				                               name="selVendor"
				                               style="WIDTH: 240px"
				                               overrideDisplayBadCodes="true"
				                               conditionallyRequired="true"
				                               value="<%=FormattingHelper.formatString(idVendor)%>"
				                               tabIndex="<%= tabIndex++ %>"
				                               editableMode="<%= EditableMode.ALL %>"
				                               disabled="true"
				                               options="<%=resourceIDList%>"/>
				    </td>    
				  </tr>		
			    <tr>
			     <td><impact:validateInput type="text" tabIndex="<%=tabIndex++%>" constraint="Address"
			                                            name="txtOther"
			                                            label="Other" size="30" maxLength="30"
			                                            value="<%=txtOther%>"
			                                            editableMode="<%=EditableMode.ALL %>"
			                                            disabled="true"/></td>
			    </tr>
			    <tr>
			     <td colspan=2>
			     	If you work for multiple resources under an umbrella organization, please submit a registration for access to one resource first. Your administrator will then be able to link you to multiple resources.
			     </td>
			     </tr>     
			  </table>
		  </td>
		</tr>
	</impact:ifThen>	
	<% 
		if (retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST))){
  			List<RetrieveVendorStaffLinkDetailBean> resourceListForUser = retrieveVendorStaffDetailSO.getResourceListforUser();
  	%>
	<tr>      
	  <td>
		  <table border="0" cellpadding="3" cellspacing="0" align="left">
		  	<tr>
		  		<td></td>
		  		<td width="100%">
		  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
		  							action="/resource/VendorStaffDetail/saveVendorStaffDetail"
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
			              
			            </td>
			          </tr>
			      	<tr>
			          <%
			      		} else {
			      			for (Iterator<RetrieveVendorStaffLinkDetailBean> it = resourceListForUser.iterator();it.hasNext();){
					          RetrieveVendorStaffLinkDetailBean vendorStaffLinkDetBean = 
					          			(RetrieveVendorStaffLinkDetailBean) it.next();
							  radioRsrcChecked = "false";					          			
					          //Get the first row and load it during the initial load
					          if (resourceCount == 0){
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
    <impact:ifThen test='<%=(resourceListForUser.size() > 0 && userAccessType.equals(SEC_VENDOR_STAFF_ACCESS)) %>'>
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
			  							action="/resource/VendorStaffDetail/deleteVendor" function="disableValidate();"
			                            restrictRepost="true" tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
   	</impact:ifThen>
    <impact:ifThen test='<%=(userAccessType.equals(SEC_VENDOR_STAFF_ACCESS)) %>'> 
    <%
    	//Set the Resource Name and Resource ID if the page pulled back from the Resource Search
    	//Otherwise use the default Retrieved resource Name and ID from the DB
    	if (FROM_RSRC_SEARCH.equals(retrieveVendorStaffDetailSO.getFromPage())){
    		selectedRsrcNm = FormattingHelper.formatString(
    							retrieveVendorStaffDetailSO.getNmResource()!=null?
    							retrieveVendorStaffDetailSO.getNmResource():selectedRsrcNm);
    		selectedRsrcId = retrieveVendorStaffDetailSO.getIdResource()!=null?
    						String.valueOf(retrieveVendorStaffDetailSO.getIdResource()):selectedRsrcId;
    		selectedType = StringHelper.EMPTY_STRING;
    		selectedStatus = retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST)?CodesTables.CUSRSTAT_ACT:CodesTables.CUSRSTAT_PEN;
    		selectFlagVal = StringHelper.BOOLEAN_FALSE;
    		addFlagVal = StringHelper.BOOLEAN_TRUE;
  			selectedStartDt = StringHelper.EMPTY_STRING;
  			selectedEndDt = StringHelper.EMPTY_STRING;
    	}
     %>
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
	                                            name="selUserType"
	                                            label="User Type"
	                                            codesTable="CUSRTYP"
	                                            conditionallyRequired="true"
	                                            value="<%=selectedType%>"
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
	                                            disabled="<%=disableStatus %>"
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
			  		<td>
			  			<impact:ButtonTag name="SelectResource" img="btnSelectResource" align="left" form="frmVndrStaffDtl" 
			  							action="/resource/VendorStaffDetail/selectResource"
			  							function="disableValidate()"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  		<td width="100%">
			  			<impact:ButtonTag name="Save" img="btnSave" align="right" form="frmVndrStaffDtl" 
			  							action="/resource/VendorStaffDetail/saveVendorStaffDetail"
			                            tabIndex="<%=tabIndex++%>"/>
			  		</td>
			  	</tr>
			  </table>
		  </td>
		</tr>
		<impact:ifThen test='<%=(retrieveVendorStaffDetailSO.getScreenName()!=null && 
	  							retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_STAFF_LIST))%>'>
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
				  							action="/resource/VendorStaffDetail/resetPassword" function="return warnPasswordReset();"
				                            tabIndex="<%=tabIndex++%>"/>
				  		</td>
				  	 </tr>		     		  	
				  </table>
			  </td>
			</tr>  
		</impact:ifThen>		
    	<impact:ifThen test='<%=(retrieveVendorStaffDetailSO.getScreenName()!=null && 
  			(retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_ADMIN_LIST) ||
  			 retrieveVendorStaffDetailSO.getScreenName().equals(SHINES_PENDING_STAFF_LIST))) %>'> 		
			<tr>
			  <td>
				  <table border="0" cellpadding="3" cellspacing="0" align="left">
				  	<tr>
				  		<td width="100%">
				  			<impact:ButtonTag name="Approve" img="btnApprove" align="right" form="frmVndrStaffDtl" 
				  							action="/resource/VendorStaffDetail/approveVendorStaffDetail"
				  							restrictRepost="true"
				                            tabIndex="<%=tabIndex++%>"/>
				        </td>
				  		<td width="100%">
				  			<impact:ButtonTag name="Disapprove" img="btnDisapprove" align="right" form="frmVndrStaffDtl" 
				  							action="/resource/VendorStaffDetail/disapproveVendorStaffDetail"
				  							restrictRepost="true"
				                            tabIndex="<%=tabIndex++%>"/>
				  		</td>
				  	</tr>
				  </table>
			  </td>
			</tr>
		</impact:ifThen>	
	</impact:ifThen>					 	  	
	<%
		}
  	%>  	
</table>
  <impact:validateInput type="hidden" name="hdnScreenName" value="<%= retrieveVendorStaffDetailSO.getScreenName() %>" />
  <impact:validateInput type="hidden" name="hdnSelectFlag" value="<%= selectFlagVal %>" />
  <impact:validateInput type="hidden" name="hdnAddFlag" value="<%= addFlagVal %>" />
  <impact:validateInput type="hidden" name="hdnSelectedPuvlId" value="<%= selectedPuvlId %>" />
  <impact:validateInput type="hidden" name="hdnSelectedRsrcNm" value="<%= selectedRsrcNm %>" />
  <impact:validateInput type="hidden" name="hdnSelectedRsrcId" value="<%= selectedRsrcId %>" />
  <impact:validateInput type="hidden" name="hdnSelUserType" value="<%= selectedType %>" />
  <impact:validateInput type="hidden" name="hdnSelStatus" value="<%= selectedStatus %>" />
  <impact:validateInput type="hidden" name="hdnDtStart" value="<%= selectedStartDt %>" />
  <impact:validateInput type="hidden" name="hdnDtEnd" value="<%= selectedEndDt %>" />
  <impact:validateInput type="hidden" name="hdnDisplayPuvlId" value="<%= selectedPuvlId %>" />
  <impact:validateInput type="hidden" name="hdnDisplayRsrcNm" value="<%= selectedRsrcNm %>" />
  <impact:validateInput type="hidden" name="hdnDisplayRsrcId" value="<%= selectedRsrcId %>" />
  <impact:validateInput type="hidden" name="hdnDisplayUserType" value="<%= selectedType %>" />
  <impact:validateInput type="hidden" name="hdnDisplayStatus" value="<%= selectedStatus %>" />
  <impact:validateInput type="hidden" name="hdnDisplayDtStart" value="<%= selectedStartDt %>" />
  <impact:validateInput type="hidden" name="hdnDisplayDtEnd" value="<%= selectedEndDt %>" />
  <impact:validateInput type="hidden" name="hdnAddNewRsrcNm" value="<%= selectedRsrcNm %>" />
  <impact:validateInput type="hidden" name="hdnAddNewRsrcId" value="<%= selectedRsrcId %>" />
  <impact:validateInput type="hidden" name="hdnAddNewUserType" value="<%= selectedType %>" />
  <impact:validateInput type="hidden" name="hdnAddNewStatus" value="<%= selectedStatus %>" />
  <impact:validateInput type="hidden" name="hdnAddNewDtStart" value="<%= selectedStartDt %>" />
  <impact:validateInput type="hidden" name="hdnAddNewDtEnd" value="<%= selectedEndDt %>" />  
  <impact:validateInput type="hidden" name="destinationUrl" value="<%= destinationUrl %>" />
    
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">
  document.frmVndrStaffDtl.txtFirstName.focus();
  //Rewriting the inner HTML to display the Resource Name and Resource ID  	
  document.getElementById('rsrcNm_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcNm.value;
  document.getElementById('rsrcId_id').innerHTML = document.frmVndrStaffDtl.hdnSelectedRsrcId.value;
</script>