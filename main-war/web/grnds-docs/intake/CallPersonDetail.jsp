<%//*  JSP Name:     Call Person Detail
      //*  Created by:   Jenn M. Casdorph
      //*  Date Created: 02/06/2003
      //*
      //*  Description:
      //*  This JSP will be used to maintain call person information in the IMPACT system.
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  07/24/03  CASDORJM          SIR 19068 - Added calculateAge() function to the DOB field
      //**  08/06/03  CASDORJM          SIR 19332 - Added navAwayCk to Address and Phone submodule and
      //**                              removed the Phone hyperlink/anchor tag from the page.
      //**                              NOTE: I removed all references to the phone hyperlink.
      //**                              See Revision 1.38 for original.
      //**  10/8/2003  Dickmaec    SIR 19805 - The extension textbox needed to be able to handle an eight
      //**                              character extension. Changed maxlength and size equal to eight.
      //**  10/21/2003 CASDORJM         SIR 22324 - Added logic to disable address and phone when the person
      //**                              has been related.
      //**  11/07/2003 CASDORJM         Added hot keys for the Add(1), Continue(2), and Save(3) buttons.
      //**  03/16/2004 dejuanr          EREPORT INTAKE Project: Enabled reporter check box all the time.
      //**  09/09/04   dejuanr          SIR 23110 - Added code to notify user to validate address
      //**  11/01/04   CORLEYAN         SIR 23041 - When calling populate dropdown for the rel/int,
      //**                              added a parameter to tell the function to display codes and decodes
      //**  03/29/05   OCHUMD            Sir 23461 Added updateRelInt()to window.onload function so that each
      //**                              the page reloads updateRelInt() is called.
      //**  07/15/05  Ochumd            Sir 23711 - Added Role of CL (Client) in the Role drop dowm
      //**                              APS CRSR cases only.
      //**  07/28/05 ochumd             Removed SystemOutPrintln from this file attached to sir 23801 for
      //**                              promotion purposes.
      //** 08/02/05  ochumd             sir 23843  Get the Special Request out of the request and
      //**                              store in a hidden field so that in the case where the page has validation
      //**                              error, we get from the hidden field.
      //** 08/03/05  ochumd             oracle.jdbc.xa.client.OracleXADataSource - Rel/Int from callInformation page was conflicting with Rel/Int
      //**                              on this page.
      //** 09/28/05  dunawakl           SIR 24002 - added Disaster Relief Field
      //** 09/30/09  bgehlot            STGAP00015485: MR-056 Added new field "Member of Primary Caretaker's Household"
      //** 06/08/10  mxpatel            MR-066.1:  added code to avoid adding duplicated persons.
      //** 06/09/10  bgehlot            SMS 56841 Relationship field is now saving
      //** 06/10/10  bgehlot            SMS# 56841 SSN field only shows in ADD mode. Also Page is now saving after clicking OK on confirmation message
      //** 06/15/10  bgehlot            SMS 57646 Display SSN only when Person has not been saved.
      //** 06/17/10  bgehlot            SMS 57786 On clicking OK on confirmation message for Duplicates, page takes the action depending on
      //**                              on the button clciked (Save And Copy, Continue, Save)
      //** 06/18/2010 bgehlot           SMS# 57787 Changed the duplicate message.
      //** 09/20/2010 wjcochran         SMS#50402: Removed 'No County' option

      %>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PersListRtrvStruct" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.intake.IntakeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation" %>
<%@ page import="java.util.StringTokenizer" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryRtrvOut"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct"%>
<%int tabIndex = 1;
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

      String pageMode = PageMode.getPageMode(request);

      PersListRtrvStruct personListRow = (PersListRtrvStruct) state.getAttribute("personListRow", request);
      if (personListRow == null) {
        personListRow = new PersListRtrvStruct();
      }

      // ochumd Sir 23711 A Role of CL Client was added to the Role drop down for APS
      // CRSR
      // sir 23843  Get the Special Request out of the request and
      // store in a hidden field so that in the case where the page has validation
      // error, we get from the hidden field.
      String SzCdSpclReq = request.getParameter("selSzCdSpclReq");
      if (SzCdSpclReq == null) {
        SzCdSpclReq = request.getParameter("hdnSpecialRequest");
      }
      if (SzCdSpclReq == null) {
        SzCdSpclReq = (String) state.getAttribute("specialRequest", request);
      }

      String cintRole = CodesTables.CINTROLE;
      List<String> exOptions = new ArrayList<String>();
      if (("CDD".equals(SzCdSpclReq)) || ("CLE".equals(SzCdSpclReq)) || ("CAC".equals(SzCdSpclReq))
          || ("CST".equals(SzCdSpclReq))) {
        exOptions.add("AP");
        exOptions.add("UK");
        exOptions.add("VC");
        exOptions.add("VP");
      } else {
        exOptions.add("CL");
      }
      // Sir 23711 End
      String multipleModify = (String) request.getAttribute("multipleModify");
      boolean disableMultiMod = false;

      if (multipleModify != null && "true".equals(multipleModify)) {
        disableMultiMod = true;
      }

      String personIsCaller = IntakeConstants.INDICATOR_NO;
      String callEntryRelInt = StringHelper.EMPTY_STRING;
      if ((personListRow.getSzCdStagePersLstSort() != null)
          && (personListRow.getSzCdStagePersLstSort().equals(IntakeConstants.CALLER_SORT))) {

        personIsCaller = IntakeConstants.INDICATOR_YES;
        callEntryRelInt = request.getParameter("selszCdIncmgCallerInt");
      }
      //  ochumd - sir 23461 Begin
      String persRole = personListRow.getSzCdStagePersRole();

      //if (StringHelper.isValid(request.getParameter("selSzCdStagePersRole"))) {
      //  persRole = request.getParameter("selSzCdStagePersRole");
      //}
      //  ochumd - sir 23461 End.
      String personInAlleg = (String) request.getAttribute(IntakeConstants.PERSON_IN_ALLEG);
      String cReqFuncCd = (String) request.getAttribute("cReqFuncCd");
      boolean personIsRelated = false;
      if ((CodesTables.CSRCHSTA_R).equals(personListRow.getSzCdStagePersSearchInd())) {
        personIsRelated = true;
      }

      // The following code is always run on load of the page to attach the correct codes tables
      // to the Role and Rel/Int drop down boxes depending on what is retrieved for Type.
      // If the person is involved in an allegation the personInAlleg indicator will be valid, meaning
      // that the Type and Role fields will be disabled.  The only way a person can be involved in an
      // allegation is if their person Type is PRN - Therefore we always attach the CPRSNTYP_PRN codes
      // table to Rel/Int if the personInAlleg indicator is true.

      String relintCodesTable = "";
      if (StringHelper.isValid(personInAlleg)) {
        relintCodesTable = CodesTables.CRELVICT;
      } else if ((CodesTables.CPRSNTYP_COL).equals(personListRow.getSzCdStagePersType())) {
        relintCodesTable = CodesTables.CSRCRPTR;
      } else if ((CodesTables.CPRSNTYP_PRN).equals(personListRow.getSzCdStagePersType())) {
        relintCodesTable = CodesTables.CRELVICT;
      }

      String szCdStagePersRelInt = StringHelper.EMPTY_STRING;

      if (FormValidation.pageHasValidationMessages("frmCallPersonDetail", request)) {
        szCdStagePersRelInt = request.getParameter("selSzCdStagePersRelInt");
      } else {
        szCdStagePersRelInt = FormattingHelper.formatString(personListRow.getSzCdStagePersRelInt());
      }

      // ochumd Sir 23843 - Redisplay is prefilling type drop down with COL.
      String persType = personListRow.getSzCdStagePersType();
      //if (((personListRow.getSzCdStagePersRelInt() == null) || ("".equals(personListRow.getSzCdStagePersRelInt())))
      //    && (persType != null)) {
      //  persType = null;
      //}
      //   If there is no ulIdPerson this person has not been saved yet, therefore
      //   we don't want to allow the user to attempt to delete the person or access any submodules
      //   (since the submodules need ulIdPerson to display/save.  Also, if we are
      //   in multiple modify mode we do not want to be able to delete or access the submodules.  If the
      //   user pushed the Add button to arrive at this page, this is also a new person.
      String hideDelete_Subs = "false";
      if ((GlobalData.getUlIdPerson(request) == 0) || (disableMultiMod)
          || (StringHelper.isValid(ContextHelper.getStringSafe(request, "btnAdd.x")))) {
        hideDelete_Subs = "true";
      }

      
      String secondaryCaretaker =String.valueOf(personListRow.getUlIdSecondaryCareGiver());
      if  (secondaryCaretaker.equals("0"))secondaryCaretaker ="";
      
      String approximate = personListRow.getBIndPersonDobApprox();
      String reasonForDeath =personListRow.getSzCdPersonDeath();
      String matchType = personListRow.getSzCdIncmgPersMatchType();
      String proofCtnshp = personListRow.getSzCdIncmgPersPrfCitizenship();
      String usCitizen = personListRow.getCIndIncmgPersUsCitizen();
      String countryofOrigin =personListRow.getSzCdIncmgPersCntryOrigin();
      String immgrtnStatus =personListRow.getSzCdIncmgPersImmgrtnStatus();
      
     List relationshipList = (List)state.getAttribute("relationshipList", request);  
      
      if (relationshipList == null) {
        relationshipList = new ArrayList();
      }
      
    CallEntryRtrvOut callEntryRtrvOut = (CallEntryRtrvOut) state.getAttribute("CallEntryRtrvOut", request);
    if (callEntryRtrvOut == null) {
      callEntryRtrvOut = new CallEntryRtrvOut();
    }
    CallEntrySvcStruct callEntryData = callEntryRtrvOut.getCallEntrySvcStruct();
    if (callEntryData == null) {
      callEntryData = new CallEntrySvcStruct();
    }
    String nonIncReqType = FormattingHelper.formatString(callEntryData.getSzCdNonRsdntReqType());
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


//SIR 23110 Start
// This function will set the valdiated flag to false and notify the user to validate
// the address.
function validateEReportAddress()
{
<%
  Map validateMap = (Map) state.getAttribute( "validateMap" , request );
  validateMap = validateMap == null ? new HashMap() : validateMap;
  String flag = (String) validateMap.get( GlobalData.getUlIdPersonAsString( request ) );
  if ( "0".equals( flag ) )
  {
%>
  changeValidAddress( "frmCallPersonDetail" , "" );
<%
  }
%>
}
//SIR 23110 End

<impact:codeArray codeName="<%= CodesTables.CSRCRPTR %>" arrayName="colRelInt" blankValue="true"/>

<impact:codeArray codeName="<%= CodesTables.CRELVICT  %>" arrayName="prnRelInt" blankValue="true"/>


  function updateRelInt()
{
  if (frmCallPersonDetail.selSzCdStagePersType.options == undefined) {
    //STGAP00004481: No Update required since type wasn't selected at
    //at this point in time.
    return;
  }
  
  if (frmCallPersonDetail.selSzCdStagePersType.options.value == "<%=  CodesTables.CPRSNTYP_COL %>")
  {
    frmCallPersonDetail.selSzCdStagePersRole.value = "<%= CodesTables.CINTROLE_NO %>";
    populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, "<%=szCdStagePersRelInt%>", colRelInt, true);
    var rel = frmCallPersonDetail.selSzCdStagePersRelInt.value;
    if(rel == ""|| rel == null){
      frmCallPersonDetail.selSzCdStagePersRelInt.value = "<%=  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  %>";
    }else{
      populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, "<%=szCdStagePersRelInt%>", colRelInt, true);
    }
    
<%
// If this is the first time the user is entering the page for the caller, we want to set Rel/Int
// equal to whatever was entered on the Call Entry page.   If Role is empty we know this page has never
// been saved before, and we use the personIsCaller indicator to tell if the person is the caller.
  if (((personListRow.getSzCdStagePersRole() == null) ||
          ("".equals(personListRow.getSzCdStagePersRole()))) &&
          (personIsCaller.equals(ArchitectureConstants.Y)))
  {
if ((callEntryRelInt==null) || ("".equals(callEntryRelInt)))
{%>
    populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, "<%=szCdStagePersRelInt%>", colRelInt, true);
<%}
else
{%>
   frmCallPersonDetail.selSzCdStagePersRelInt.value = "<%= callEntryRelInt %>";
<%}
}%>

  }
  else if (frmCallPersonDetail.selSzCdStagePersType.options.value == "<%= CodesTables.CPRSNTYP_PRN %>")
  {
   //  ochumd - sir 23461 Begin commented out line below because it was setting
   // field to blank.  Also added szCdStagePersRelInt to the populateDropdownDecode.
    //ochu - frmCallPersonDetail.selSzCdStagePersRole.value = "";
    populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, "<%=szCdStagePersRelInt%>", prnRelInt, true);
    var rel = frmCallPersonDetail.selSzCdStagePersRelInt.value;
    if(rel == "" || rel == null){
      frmCallPersonDetail.selSzCdStagePersRelInt.value = "<%=  ContextHelper.getStringSafe(request, "selSzCdStagePersRelInt")  %>";
    }else{
      populateDropdownDecode(frmCallPersonDetail.selSzCdStagePersRelInt, "<%=szCdStagePersRelInt%>", prnRelInt, true);
    }
    
  }
   //  ochumd - sir 23461 End
  else
  {
    frmCallPersonDetail.selSzCdStagePersRole.value = "";
    clearDropdown(frmCallPersonDetail.selSzCdStagePersRelInt);
  }
}
function getAge()
{
  calculateAge( frmCallPersonDetail.txtDateDtPersonBirth, frmCallPersonDetail.txtLNbrPersonAge );
}



//  Submit the form with the correct cReqFuncCd for deleting.  When the user attempts to delete
//  a person they will be prompted with the message "Are you sure you want to delete.. ".
//  If they select to continue we will disable the validation on Call Person Detail and continue*.
//  See SIR comments below.
//
// SIR 18636 - JMC - Removed lines that disabled the custom validation from this javascript
// function.  I do not know why we chose to disable the validation in the first place.
function deleteCallPerson()
{
        bRetValue = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>');
          if (bRetValue)
          {
            if (<%= personIsCaller.equals(ArchitectureConstants.Y) %>)
            {
              alert('<%= MessageLookup.getMessageByNumber(Messages.MSG_INT_VERIFY_CALL_ENTRY) %>');
            }
          }
          return bRetValue;
}


</script>

<impact:validateErrors/>

<impact:validateForm
    name="frmCallPersonDetail"
    method="post"
    action="/intake/CallInformation/displayCallPersonDetail"
    pageMode="<%= pageMode %>"
    validationClass="gov.georgia.dhr.dfcs.sacwis.web.intake.CallPersonDetailCustomValidation"
    schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="<%= ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL %>" value="<%= (String)request.getAttribute( ArchitectureConstants.DISPLAY_INCOMING_PERSON_DETAIL ) %>" />
<%String newUsingPageMode = (String) request.getAttribute(IntakeConstants.PAGE_MODE_NEW_USING);
      if (newUsingPageMode == null) {
        newUsingPageMode = "false";
      }

      %>

<%/* We use the  */%>
<impact:validateInput type="hidden" name="newUsing" value="<%= newUsingPageMode %>"/>
<impact:validateInput type="hidden" name="hdnSpecialRequest" value="<%= SzCdSpclReq %>"/>
<impact:validateInput type="hidden" name="hdnBIndSsnConfirm" value="true"/>

<%/* Begin Detail */%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
            <a tabIndex="<%= tabIndex++ %>" href="javascript: expandAll()">Expand All</a>&nbsp;
            <a tabIndex="<%= tabIndex++ %>" href="javascript: collapseAll()">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
     <th colspan="8">Name</th>
  </tr>
  <tr>
      <td width="10%"><impact:validateSelect  label="Title"
                               name="selTitle"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CTITLE %>"
                               value="<%= personListRow.getSzCdIncmgPersTitle() %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>" /></td>
  </tr>
  <tr>
   <td width="10%"><impact:validateInput type="text"
                               label="Last"
                               constraint="Name22"
                               conditionallyRequired="true"
                               name="txtSzNmNameLast"
                               cssClass="formInput"
                               value="<%= personListRow.getSzNmNameLast() %>"
                               size="22"
                               maxLength="22"
                               tabIndex="<%= tabIndex++ %>"/></td>
    <td ><impact:validateInput
                               type="text"
                               label="First"
                               name="txtSzNmNameFirst"
                               constraint="Name12"
                               conditionallyRequired="true"
                               cssClass="formInput"
                               value="<%= FormattingHelper.formatString(personListRow.getSzNmNameFirst())%>"
                               size="12"
                               maxLength="12"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/></td>
    <td><impact:validateInput type="text"
                               label="Middle"
                               constraint="Name12"
                               name="txtSzNmNameMiddle"
                               cssClass="formInput"
                               value="<%= FormattingHelper.formatString(personListRow.getSzNmNameMiddle())%>"
                               size="12"
                               maxLength="12"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>" /></td>
    <td><impact:validateSelect label="Suffix"
                               name="selSzCdNameSuffix"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CSUFFIX %>"
                               value="<%= personListRow.getSzCdNameSuffix() %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>" /></td>
  </tr>
  <tr>
    <th colspan="8">Address</th>
  </tr>
  <tr>
    <td colspan="8">
      <%/* BEGIN Address Submodule */%>
      <%AddressSubDB addressSubDB = new AddressSubDB();
      addressSubDB.setFormName("frmCallPersonDetail");
      addressSubDB.setPageMode(pageMode);
      addressSubDB.setAddressSubmoduleName("");
      addressSubDB.setCommentsVisible(false);
      addressSubDB.setCommentsRequired(false);
      addressSubDB.setCommentsDisabled(true);
      addressSubDB.setStreetRequired(false);
      addressSubDB.setZipRequired(false);
      addressSubDB.setAddressRequired(false);
      // SMS #50402: Remove 'No County' Option
      ArrayList<String> excludedCounties = new ArrayList<String>();
      excludedCounties.add(CodesTables.CCOUNT_XXX);
      addressSubDB.setExcludeCounty(excludedCounties);
      if (pageMode.equals(PageModeConstants.VIEW) || personIsRelated) {
        addressSubDB.setAddressDisabled(true);
      } else {
        addressSubDB.setAddressDisabled(false);
      }
      addressSubDB.setTabIndex(tabIndex);
      AddressSubDB.setIntoRequest(addressSubDB, request);

      %>
      <%@ include file="/grnds-docs/common/AddressSub.jsp" %>
      <%tabIndex = addressSubDB.getTabIndex();
      AddressSubDB.removeFromRequest(request);

      %>
      <%/* END Address Submodule */
      %>
    </td>
  </tr>
  <tr>
    <td><impact:validateSelect
                colspan="8" label="Address Type" conditionallyRequired="true"
                name="selSzCdPersAddrLinkType" tabIndex="<%= tabIndex++ %>"
                codesTable="<%= CodesTables.CADDRTYP %>" blankValue="true"
                disabled="<%= String.valueOf( personIsRelated ) %>"
                value="<%= personListRow.getSzCdPersAddrLinkType() %>"/></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
 <tr>
    <th colspan="8">Phone</th>
  </tr>
  <tr>
    <td><impact:validateInput label="Phone"
                               name="txtLBNbrPhone"
                               tabIndex="<%= tabIndex++ %>"
                               value="<%= FormattingHelper.formatPhone(personListRow.getLNbrPhone()) %>"
                               type="text"
                               disabled="<%= String.valueOf( personIsRelated ) %>"
                               cssClass="formInput"
                               size="14"
                               maxLength="14"
                               constraint="Phone"
                               conditionallyRequired="true"/></td>

    <td><impact:validateInput label="Ext."
                               name="txtLNbrPhoneExtension"
                               tabIndex="<%= tabIndex++ %>"
                               value="<%= personListRow.getLNbrPhoneExtension() %>"
                               type="text"
                               cssClass="formInput"
                               disabled="<%= String.valueOf( personIsRelated ) %>"
                               size="8"
                               maxLength="8"
                               constraint="PhoneExtension"/></td>

    <td><impact:validateSelect label="Phone Type"
                               name="selSzCdPhoneType"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CPHNTYP %>"
                               disabled="<%= String.valueOf( personIsRelated ) %>"
                               blankValue="true"
                               value="<%= personListRow.getSzCdPhoneType() %>"
                               conditionallyRequired="true"/></td>
  </tr>
  
  <tr>
    <th colspan="6">Demographics</th>
  </tr>
 
  <tr>
      <td><impact:validateSelect label="Type"
                               name="selSzCdStagePersType"
                               required="<%= String.valueOf(!disableMultiMod) %>"
                               onChange="updateRelInt();"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CPRSNTYP %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               value="<%= persType %>"
                               disabled="<%= String.valueOf(StringHelper.isValid(personInAlleg)) %>"  /></td>

      <td><impact:validateSelect label="Role"
                               name="selSzCdStagePersRole"
                               required="<%= String.valueOf(!disableMultiMod) %>"
                               tabIndex="<%= tabIndex++ %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               codesTable="<%= cintRole %>"
                               excludeOptions="<%= exOptions %>"
                               value="<%= persRole %>"
                               disabled="<%= String.valueOf(StringHelper.isValid(personInAlleg)) %>" /></td>

      <td><impact:validateSelect label="Relationship"
                               name="selSzCdStagePersRelInt"
                               required="<%= String.valueOf(!disableMultiMod) %>"
                               tabIndex="<%= tabIndex++ %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               codesTable="<%= relintCodesTable %>"
                               value="<%= szCdStagePersRelInt %>"
                               style="WIDTH: 200px"/></td>
  </tr>
  
   
  <tr>
    <td>&nbsp;</td>
<%// The Reporter Custom Tag wants a yes or no string variable for the checked attributes
      // so we do a null check to make sure Y or N was retrieved.
      String reporter = personListRow.getBIndStagePersReporter();
      if (reporter == null || "".equals(reporter)) {
        reporter = IntakeConstants.INDICATOR_NO;
      }
      // If the person is the caller, the user should not be able to uncheck the "reporter" checkbox.
      // Since the checkbox will not submit it's value into the request when it is disabled, we use
      // the hidden field hdnPersonIsCaller in the save activity method to make sure the check is not
      // lost.  (In other words, if Reporter Checkbox == null but hdnPersonIsCaller == Y, save Reporter == yes)
      boolean disableReporter = false;
      if (personIsCaller.equals(IntakeConstants.INDICATOR_YES)) {
        disableReporter = true;
      }
%>
<impact:validateInput type="hidden"
                      name="hdnPersonIsCaller"
                       value="<%= personIsCaller %>"/>

    <td><impact:validateInput  type="checkbox"
                               label="Reporter"
                               tabIndex="<%= tabIndex++ %>"
                               checked="<%= reporter  %>"
                               value="Y"
                               name="cbxBIndStagePersReporter"
                               disabled="<%= String.valueOf(disableMultiMod || disableReporter) %>"/>
    </td>
    <%//STGAP00015485: MR-056 for a non-incident intake "Member of Primary Caretaker's Household" will be hidden
     if(nonIncReqType != null && nonIncReqType.length() > 0){%>
      <td>&nbsp;</td>
    <%}else{%>
      <td><impact:validateSelect label="Member of Primary Caretaker's Household"
                               name="selCdStagePersMbrPrimCareHhl"
                               required="<%= String.valueOf(!disableMultiMod) %>"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CMBRPCHH %>"
                               value="<%= personListRow.getCdPKHouseholdMember() %>"/>
      </td>
    <%}%>
    <td>&nbsp;</td>
<%String inLaw = personListRow.getBIndStagePersInLaw();
      if (inLaw == null || "".equals(inLaw)) {
        inLaw = IntakeConstants.INDICATOR_NO;
      }
%>
    <td colspan="2"><impact:validateInput  label="Safety Resource"
                               name="cbxBIndStagePersInLaw"
                               value="Y"
                               type="checkbox"
                               tabIndex="<%= tabIndex++ %>"
                               checked="<%= inLaw %>"  />
    </td>
  </tr>
 

     <tr>
      <td><impact:validateSelect label="Secondary Caretaker"
                               name="selSecondaryCaretaker"
                               tabIndex="<%= tabIndex++ %>"
                               style="width:140px;overflow:hidden;border-right:1px solid gray;"
                               value="<%= secondaryCaretaker %>"
                               disabled="<%= String.valueOf(StringHelper.isValid(personInAlleg)) %>"
                               options="<%= relationshipList %>"  /></td>
                               
     <td><impact:validateTextArea colspan="4"label="Other Relationship"
                               name="txtOtherRelationships"
                               rows="4"
                               cols="55"
                               tabIndex="<%= tabIndex++ %>"
                               constraint="Comments"
                          maxLength="300"
                               disabled="<%= String.valueOf(disableMultiMod) %>"><%=FormattingHelper.formatString(personListRow.getSzTxtStagePersOthRelations())%> </impact:validateTextArea>
        </td>
  
  </tr>
  

  <tr>
    <td><impact:validateInput label="Age"
                               name="txtLNbrPersonAge"
                               constraint="Digit3Less"
                               value="<%= FormattingHelper.formatInt(personListRow.getLNbrPersonAge()) %>"
                               type="text"
                               size="3"
                               maxLength="3"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>" /></td>
  <%String dob = FormattingHelper.formatDate(personListRow.getDtDtPersonBirth());
  %>
    <td><impact:validateDate label="DOB"
                               name="txtDateDtPersonBirth"
                               constraint="Date"
                               value="<%= dob  %>"
                               size="10"
                               tabIndex="<%= tabIndex++ %>"
                               onBlur="getAge( );"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/></td>
    <td><impact:validateDate label="DOD"
                               name="txtDateDtPersonDeath"
                               constraint="Date"
                               value="<%= FormattingHelper.formatDate(personListRow.getDtDtPersonDeath()) %>"
                               size="10"
                               tabIndex="<%= tabIndex++ %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>" /></td>
 </tr>
 
 <tr>
   <td>&nbsp;</td>
   <td><impact:validateInput type="checkbox"
                               label="Approximate"
                               tabIndex="<%= tabIndex++ %>"
                               checked="<%=approximate  %>"
                               value="Y"
                               name="cbxBlndStageApprox"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/>
    </td>
     
    <td>&nbsp;</td>
    
    <td><impact:validateSelect colspan="3" label="Reason for Death"
                               name="selSzCdStageResForDeath"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CRSNFDTH %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               value="<%= reasonForDeath %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"  /></td>
 
 </tr>
 
 <tr>
    <td><impact:validateSelect label="Marital"
                               name="selSzCdPersonMaritalStatus"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CMARSTAT%>"
                               value="<%= personListRow.getSzCdPersonMaritalStatus()%>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/></td>

    <td><impact:validateSelect label="Gender"
                               name="selCdPersonSex"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CSEX %>"
                               value="<%= personListRow.getCCdPersonSex() %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/></td>
                               
<%//MR-066 Display SSN only when Person has not been saved.
      if (GlobalData.getUlIdPerson(request) == 0) {
%>
    <td><impact:validateInput label="SSN"
                               name="txtSzNbrPersonIdNumber"
                               type="text"
                               constraint="SocialSecurityNumber"
                               size="11"
                               maxLength="11"
                               tabIndex="<%= tabIndex++ %>"
                               value="<%= FormattingHelper.formatSSN(personListRow.getSzNbrPersonIdNumber()) %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/></td>
 <%} %>
  </tr>

<tr>
    <td colspan="6">
        <table border="0" cellspacing="0" cellpadding="3" width="100%">

          <tr>

            <%// If this is a new person, we want to default language to "English"
      String language = personListRow.getSzCdPersonLanguage();
      if (personListRow.getUlIdPerson() == 0 && (language ==null ||language.equals(StringHelper.EMPTY_STRING))) {
        language = CodesTables.CLANG_EN;
      }
      //SIR 24002 - dunawakl - added Disaster Relief Field
      String disaster = personListRow.getSzCdDisasterRlf();

      %>
            <td>
              <TABLE border="0" cellpadding="0" cellspacing="0" width="100%">
                <TR>

                  <td>
                    <impact:validateSelect label="Language" name="selSzCdPersonLanguage" tabIndex="<%= tabIndex++ %>" codesTable="<%= CodesTables.CLANG%>" value="<%= language %>" />
                  </td>
                  <TD rowspan="2">
                  <td>
                    <impact:validateTextArea label="Person Notes" name="txtSzTxtStagePersNotes" rows="4" cols="55" tabIndex="<%= tabIndex++ %>" constraint="Comments" maxLength="300" disabled="<%= String.valueOf(disableMultiMod) %>">
                      <%=FormattingHelper.formatString(personListRow.getSzTxtStagePersNotes())%>
                    </impact:validateTextArea>
                  </td>

                </TR>
                <TR>
                  <td>
                    <impact:validateSelect label="Match Type" 
                    name="selSzCdMatchtype" 
                    tabIndex="<%= tabIndex++ %>" 
                    codesTable="<%= CodesTables.CMATTYPE%>" 
                    disabled="<%= String.valueOf( !personIsRelated )%>"
                    value="<%= matchType %>" />
                  </td>
                </TR>
              </TABLE>
            </td>



          </tr>

        </table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
    <th colspan="6">Citizenship</th>
</tr>
<tr>
      <td><impact:validateSelect label="Proof of Citizenship"
                               name="selProofCtnshp"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CPRFCTN %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               value="<%= proofCtnshp %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"  /></td>

       <td><impact:validateInput type="checkbox"
                               label="Non-US Born"
                               tabIndex="<%= tabIndex++ %>"
                               checked="<%=usCitizen  %>"
                               value="Y"
                               name="chkUsCitizen"
                               disabled="<%= String.valueOf(disableMultiMod) %>"/>

<tr>
<tr>
      <td><impact:validateSelect label="Citizenship/Alien Status"
                               name="selImmgrtnStatus"
                               tabIndex="<%= tabIndex++ %>"
                               codesTable="<%= CodesTables.CCTZNSTA %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               value="<%= immgrtnStatus %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>"  /></td>

      <td><impact:validateSelect label="Birth Country"
                               name="selCountryOfOrigin"
                               tabIndex="<%= tabIndex++ %>"
                               contentType="<%= SelectTag.CODES_DECODES %>"
                               orderBy="decode"
                               codesTable="<%= CodesTables.CCNTRY %>"
                               excludeOptions="<%= exOptions %>"
                               value="<%= countryofOrigin %>"
                               disabled="<%= String.valueOf(disableMultiMod) %>" /></td>

<tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">

<%/* The race/ethnicity submodule should be visible when there is no ulIdPerson, but should not be modifiable
       when the user is attempting a multiple modify. */%>
<%if (!disableMultiMod) {%>
      <tr>
        <td colspan="6">
          <%RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
        raceEthnicitySubDB.setTabIndex(tabIndex);
        RaceEthnicitySubDB.setIntoRequest(raceEthnicitySubDB, request);

        %>
          <%@ include file="/grnds-docs/person/RaceEthnicitySub.jsp" %>
          <%tabIndex = raceEthnicitySubDB.getTabIndex();
        RaceEthnicitySubDB.removeFromRequest(request);

      %>
        </td>
      </tr>
<%}%>
    </table>

<%//   We want to default Perform Search to checked if this is the first time we enter the page for a person.
      //   Since Role is a required field to save the page we can check to see if it is null or not.  We cannot use
      //   personId as an indicator since the two persons from Call Entry will already have a personId the first time
      //   the user enters the Call Person Detail page for them.  Role will always be blank the first time the user
      //   enters the page and never blank on re-entry (since it is required to save).
      String performSearch = "false";
      if ((personListRow.getSzCdStagePersRole() == null) || ("".equals(personListRow.getSzCdStagePersRole()))
          || ("true".equals(newUsingPageMode))) {
        performSearch = "true";
      }
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td width="50%"><impact:ButtonTag
                               name="btnUpdateRelatedAddressPhoneInfo"
                               img="btnUseIncomingPersonInformation"
                               align="right"
                               form="frmCallPersonDetail"
                               action="/intake/CallInformation/updateRelatedAddressPhoneInfo"
                               restrictRepost="true"
                               disabled="<%= String.valueOf( !personIsRelated )%>"
                               tabIndex="<%= tabIndex++ %>"/></td>
    <td align="right" nowrap>
                    <impact:validateInput
                               type="checkbox"
                               label="Perform Search"
                               tabIndex="<%= tabIndex++ %>"
                               checked="<%= performSearch %>"
                               value="Y"
                               name="cbxSzCdStagePersSearchInd"/></td>

    <td align="right"><impact:ButtonTag
                               name="btnSaveAndCopy"
                               img="btnSaveAndCopy"
                               align="right"
                               form="frmCallPersonDetail"
                               function="return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveAndAddCallPersonDetail', '', this.name)"
                               action="/intake/CallInformation/saveAndAddCallPersonDetail"
                               restrictRepost="true"
                               accessKey="1"
                               disabled="<%= String.valueOf(disableMultiMod)%>"
                               tabIndex="<%= tabIndex++ %>"/></td>

    <td align="right"><%if (disableMultiMod) {%>
                   <impact:ButtonTag
                           name="btnContinueMultiple"
                           img="btnContinue"
                           align="right"
                           form="frmCallPersonDetail"
                           function="return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveMultipleCallPersonDetail', '', this.name)"
                           action="/intake/CallInformation/saveMultipleCallPersonDetail"
                           restrictRepost="true"
                           accessKey="1"
                           tabIndex="<%= tabIndex++ %>"/>

                    <%} else {
        %>
                   <impact:ButtonTag
                            name="btnContinue"
                            img="btnContinue"
                            align="right"
                            form="frmCallPersonDetail"
                            function="return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveAndContinueCallPersonDetail', '', this.name)"
                            action="/intake/CallInformation/saveAndContinueCallPersonDetail"
                            restrictRepost="true"
                            accessKey="2"
                            tabIndex="<%= tabIndex++ %>"/><%}%></td>

    <td align="right"><impact:ButtonTag
                            name="btnSaveCallPersonDetail" img="btnSave"
                            function="return validateAddressOnSave('frmCallPersonDetail', '/intake/CallInformation/saveAndStayCallPersonDetail', '', this.name)"
                            action="/intake/CallInformation/saveAndStayCallPersonDetail"
                            align="right" form="frmCallPersonDetail"
                            restrictRepost="true"
                            accessKey="3"
                            disabled="<%= String.valueOf(disableMultiMod) %>"
                            tabIndex="<%= tabIndex++ %>"  /></td>
</table>

<%// We should only show the address, name, person id, and phone submodules if the
      // hideDelete_Subs indicator is FALSE.
        String intakeIndicator = "N";
      if ("false".equals(hideDelete_Subs)) {
         //intakeIndicator = "Y";
%>
<br>
<impact:include page="/submodule/AddressListSubmodule/displayAddressList"
                               callingPage="/intake/CallInformation/redisplayCallPersonDetail"
                               includingForm="frmCallPersonDetail"
                               tabIndex="<%=tabIndex++%>">
<impact:attribute
        name="<%= ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME %>"
        value="true"/>
<impact:attribute
        name="<%= AddressListConversation.PAGE_MODE_KEY %>"
        value="<%= pageMode %>"/>
</impact:include>
<br>
<impact:include page='<%= PhoneSubmoduleConversation.PHONE_SUB %>'
                               callingPage="/intake/CallInformation/redisplayCallPersonDetail"
                               includingForm="frmCallPersonDetail"
                               tabIndex="<%=tabIndex++%>" >
<impact:attribute
        name="<%= ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME %>"
        value="true"/>
<impact:attribute
        name="<%= PhoneSubmoduleConversation.PAGE_MODE %>"
        value="<%= pageMode %>"/>
</impact:include>
<br>
<impact:include page="/submodule/NameHistorySubmoduleConversation/displayNameHistory"
                               callingPage="/intake/CallInformation/redisplayCallPersonDetail"
                               tabIndex="<%= tabIndex++ %>"
                               includingForm="frmCallPersonDetail">

   <impact:attribute name="intakeIndicator" value="<%= intakeIndicator %>" />

<impact:attribute
        name="<%= NameHistorySubmoduleConversation.PAGE_MODE_KEY %>"
        value="<%= pageMode %>"/>
</impact:include>
<br>
 <impact:include page="/submodule/PersonIdentifiersSubmodule/displayPersonIDsListSubmodule"
                               callingPage="/intake/CallInformation/redisplayCallPersonDetail"
                               tabIndex="<%= tabIndex++ %>"
                               includingForm="frmCallPersonDetail">
 <impact:attribute
         name="<%= PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY %>"
         value="<%= pageMode %>" />
</impact:include>
<%}%>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<script type="text/javascript" language="JavaScript1.2">

<% /* begin areFieldsDeleted() logic.
      This section of code utilizes the areFieldsDeleted() submethod on the
      CallPersonDetailCustomValidation  class.  For an explanation of what is
      going on, please see the javadocs for that class.  We have to check to make sure
      deleteIndicators != null because if one of the required fields is blank when the user
      submits the form or if one of the fields violates it's constraint, when the page
      reloads, FormValidation.paseHasValidationMessages will be true, but since the page
      never made it to Custom Validation deletedIndicators will be null.  In
      this case we don't want to execute any of the logic (since we would get a null pointer exception).  */ %>
<%
  if (FormValidation.pageHasValidationMessages("frmCallPersonDetail", request))
  {
    boolean[] deletedIndicators = (boolean[])request.getAttribute("deletedIndicators");
    if (deletedIndicators != null)
    {
      if (deletedIndicators[ IntakeConstants.NAME_INDEX ])
      {
%>
      frmCallPersonDetail.txtSzNmNameFirst.value = '<%= personListRow.getSzNmNameFirst() %>';
      frmCallPersonDetail.txtSzNmNameMiddle.value = '<%= personListRow.getSzNmNameMiddle() %>';
      frmCallPersonDetail.txtSzNmNameLast.value = '<%= personListRow.getSzNmNameLast() %>';
<%}
  if (deletedIndicators[ IntakeConstants.ADDRESS_1_INDEX ])
{%>
    frmCallPersonDetail.addressAddress1.value = '<%= personListRow.getSzAddrPersAddrStLn1() %>';
<%}
  if (deletedIndicators[ IntakeConstants.ADDRESS_2_INDEX ])
{%>
   frmCallPersonDetail.addressAddress2.value = '<%= personListRow.getSzAddrPersAddrStLn2() %>';
<%}
  if (deletedIndicators[ IntakeConstants.CITY_INDEX ])
{%>
  frmCallPersonDetail.addressCity.value = '<%= personListRow.getSzAddrCity() %>';
<%}
  if (deletedIndicators[ IntakeConstants.STATE_INDEX ])
{%>
  frmCallPersonDetail.addressState.value = '<%= personListRow.getSzCdAddrState() %>';
<%}
  if (deletedIndicators[ IntakeConstants.ZIP_INDEX ])
  {
    java.util.StringTokenizer strTok = new StringTokenizer(personListRow.getLAddrZip(), "-");
    String zip = "";
    String zipSuff = "";
    if (strTok.hasMoreTokens())
    {
      zip = strTok.nextToken();
    }
    if (strTok.hasMoreTokens())
    {
      zipSuff = strTok.nextToken();
    }
%>
  frmCallPersonDetail.addressZip.value = '<%= zip %>';
  frmCallPersonDetail.addressZipSuff.value = '<%= zipSuff %>';
<%}
  if (deletedIndicators[ IntakeConstants.COUNTY_INDEX ])
{%>
  frmCallPersonDetail.addressCounty.value = '<%= personListRow.getSzCdAddrCounty() %>';
<%}
  if (deletedIndicators[ IntakeConstants.ADDRESS_TYPE_INDEX ])
{%>
  frmCallPersonDetail.selSzCdPersAddrLinkType.value = '<%= personListRow.getSzCdPersAddrLinkType() %>';
<%}
  if (deletedIndicators[ IntakeConstants.PHONE_INDEX ])
{%>
  frmCallPersonDetail.txtLBNbrPhone.value = '<%= FormattingHelper.formatPhone(personListRow.getLNbrPhone()) %>';
<%}
  if (deletedIndicators[ IntakeConstants.PHONE_EXT_INDEX ])
{%>
  frmCallPersonDetail.txtLNbrPhoneExtension.value = '<%=  personListRow.getLNbrPhoneExtension()!= null ? personListRow.getLNbrPhoneExtension(): StringHelper.EMPTY_STRING %>';
<%}
  if (deletedIndicators[ IntakeConstants.PHONE_TYPE_INDEX ])
{%>
  frmCallPersonDetail.selSzCdPhoneType.value = '<%= personListRow.getSzCdPhoneType() %>';
<%
  }
 } // End bracket for if (deletedIndicators != null)

} // End bracket for if (pageHasErrorMessages)
%>
<%/* end areFieldsDeleted() logic  */%>

// SIR 23110 Start
// There is a an onload that is created in one of teh submodules so here we take
// the code that is in it and evaluate it in our onload.
previousOnload = new String( window.onload );
previousOnload = previousOnload.substring( previousOnload.indexOf('{')+1, previousOnload.lastIndexOf('}') );

    
function confirmDuplicate() {
  var errorCode = '<%= (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") %>';
  if (errorCode == '<%= Messages.MSG_INT_DUPLICATE_NOT_ALLOWED %>')
    {
    if (confirm( "<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_DUPLICATE_NOT_ALLOWED)%>" )) {
       document.getElementById('hdnBIndSsnConfirm_Id').value = 'false';
       //SMS 57786 If  Save button is clicked
       if ('true' == '<%= StringHelper.isValid(request.getParameter("btnSaveCallPersonDetail" + ".x"))%>' ) {
        submitValidateForm('frmCallPersonDetail', '/intake/CallInformation/saveAndStayCallPersonDetail');
      }
      //SMS 57786 If  Save And Copy button is clicked 
      else if ('true' == '<%= StringHelper.isValid(request.getParameter("btnSaveAndCopy" + ".x"))%>' ) { 
        submitValidateForm('frmCallPersonDetail', '/intake/CallInformation/saveAndAddCallPersonDetail');
      } 
      //SMS 57786 If  Continue button is clicked
      else if ('true' == '<%= StringHelper.isValid(request.getParameter("btnContinue" + ".x"))%>' ) {
       submitValidateForm('frmCallPersonDetail', '/intake/CallInformation/saveAndContinueCallPersonDetail');
     }
   }
 }
}

window.onload = function()
{
  eval(previousOnload);
  validateEReportAddress();
  updateRelInt();
  confirmDuplicate();
}
// SIR 23110 End

</script>


