<%--
*  JSP Name:     PersonIdentifiersDetail.jsp
*  Created by:   Michael K. Werle
*  Date Created: 12/09/02
*
*  Description:
*  This page allows a user to edit the type, number and comments of the Person
*  Identifiers Detail and set and End Date.

Change History:
Date      User              Description
--------  ----------------  -------------------------------------------------------------------------------------------
08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
07/11/05  Merle A Demo      Added IndValidateByInterface for Sir23446, It shows when and SSN was validated by the
                            interface.
09/27/05  berkime           SIR 23827 user has to enter comments if they change a DHS interface SSN. Put the error
                            message for SIR 23446 in custom validation.  Added an if statement for javascript error
                            caused by SIR 23446
12/10/08  charden           STGQAP00007204 - corrected message being thrown for duplicate CRS ID's                
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = (String) state.getAttribute(PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY, request);

  int tabIndex = 1;

  int ulIdPersonId = ContextHelper.getIntSafe(request, "hdnUlIdPersonId");

  CINT14WLB cint14wlb = (CINT14WLB) state.getAttribute("cint14wlb", request);

  boolean notNew = ulIdPersonId > 0 && cint14wlb != null;

  //Use newCRS to determin if this is a new CRS number
  boolean newCRS = false;
  String newCRSString = "false";
  if (ulIdPersonId == 0 && cint14wlb != null) {
    newCRS = true;
    newCRSString = "true";
  }
  

  // set variables that are used in multiple places and/or are too long to be readible below
  boolean isInvalid = notNew && cint14wlb.getBIndPersonIDInvalid().equals(ServiceConstants.FND_YES) ? true : false;
  String codeType = notNew ? cint14wlb.getSzCdPersonIdType() : "";
  //if this is  an existing ID Type or if this is a new CRS with a number,
  //set idNumber and codeType to the values retrieved form the object. Else set those values to empty string.
  String idNumber;
  if (notNew || newCRS) {
    idNumber = cint14wlb.getSzNbrPersonIdNumber();
    codeType = cint14wlb.getSzCdPersonIdType();
  } else {
    idNumber = "";
    codeType = "";
  }

  org.exolab.castor.types.Date endDate = notNew ? cint14wlb.getDtPersonIDEnd() : null;

  //Start Sir23446
  // isVerified is used to exclude SSN from drop down when one already exits so another can not be added
  // it is always set false right now but can be changed in PersonIdentifiersConversation so that it can be used
  boolean isVerified = "true".equals(request.getAttribute("VERIFIED_DHS").toString());

  boolean isValidateByInterface = false;
  boolean isSSN = false;
  if (notNew && cint14wlb.getSzDescPersonID() != null && cint14wlb.getSzDescPersonID() != null) {
    isValidateByInterface = ServiceConstants.FND_YES.equals(cint14wlb.getBIndValidateByInterface());
    isSSN = cint14wlb.getSzCdPersonIdType().equals(CodesTables.CNUMTYPE_SSN) ? true : false;
  }

  //Remove SSN from drop down Type when there exit a validated record and the worker does not have the correct profile
  // Get cint14wlb_array out of the request
  //CINT14WLB_ARRAY cint14wlb_array = (CINT14WLB_ARRAY)request.getAttribute( PersonIdentifiersConversation.CINT14WLB_ARRAY_KEY );

  boolean hasUpdateProfile = UserProfileHelper.getUserProfile(request).hasRight(UserProfile.SEC_MNTN_PERSON);

  // Use hasEndDate to disable editing when there is an end date saved
  boolean hasEndDate = endDate != null ? true : false;
  //Sir23446 Future use, Program may want regular user not to update when it is a SSN that has been Validated
  // by the interface isVerified is always set false right now but can be changed in PersonIdentifiersConversation
  // line 557 so that it can be used
  boolean isNotUpdatable = hasEndDate || (isVerified && isSSN && !hasUpdateProfile) || (codeType.equals(
          CodesTables.CNUMTYPE_CRS_IDNUMBER) && notNew);
  //End Sir23446

  // This will be the default display value of the CRS Button which will be toggled
  // by the selection of type of Identifier

  String displayCrsButton = "none";
  String displayDtFields = "inline";
  String displayCrsMod = "inline";
%>

<%-- the following script tag imports the IsDirty() function --%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="Javascript1.2">
// Check for changes before navigating off
window.onbeforeunload = function () {
  IsDirty();
};
//SIR 23827 fixed the javascript runtime error
<%
  if( isValidateByInterface ) {
%>
window.onload = function () {
  //Sir23446 This removes the flaky behavior of the checkbox
  frmPersonIdentifiersDetail.cbxBIndVerifiedInterface.value = " ";
  updateForCrs();
};
<%
  } else {
%>
window.onload = function () {
  updateForCrs();
};
<%
  }
%>

function confirmAddWhenExistingOfSameType(type, comment, bHasEnddate)
{
  var returnedValue = true;
  var existingTypes = new Array(<%=(String) request.getAttribute("existingTypes")%>);

  for (var i = 0; i < existingTypes.length; i++)
  {
    if (existingTypes[ i ] == type && !bHasEnddate)
    {
      returnedValue = confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_INT_ACTIVE_TYPE_EXISTS)%>')
      if (returnedValue) {
        if (type == '<%=CodesTables.CNUMTYPE_CRS_IDNUMBER%>') {
          returnedValue =
          confirm('You are about to add another CRS ID as an identifier for the same person!  Are you sure ?');
        }
      }
    }
  }
  return returnedValue;
}

function updatePersonIdentifierFields(selectControl)
{
  // We only need to execute this if we are editing an existing one;
  // it sets hdnIsNew to true, which will prevent it from running more than once
  if (frmPersonIdentifiersDetail.hdnIsNew.value != "true")
  {
    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value = "";
    updateDisplayOnlyField('frmPersonIdentifiersDetail', 'dspDtPersonIDStart', '<%=FormattingHelper.formatDate(new Date())%>');
    updateDisplayOnlyField('frmPersonIdentifiersDetail', 'dspDtPersonIDEnd', '');
    frmPersonIdentifiersDetail.txtSzDescPersonID.value = "";
    frmPersonIdentifiersDetail.cbxBIndPersonIDInvalid.checked = false;
    //frmPersonIdentifiersDetail.cbxBIndVerifiedInterface.checked = false;
    frmPersonIdentifiersDetail.hdnIsNew.value = true;
    frmPersonIdentifiersDetail.hdnUlIdPersonId.value = 0;
    frmPersonIdentifiersDetail.hdnTsLastUpdate2.value = "";

  }
  if (selectControl.value == "<%=CodesTables.CNUMTYPE_DRIVERS_LICENSE_NUMBER%>"
          && frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value == "")
  {
    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value = "GA";
  }
  else
  {
    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value = "";
  }
  updateForCrs();
}

function updateForCrs()
{
  if (<%=newCRS%>) {
    frmPersonIdentifiersDetail.selSzCdPersonIdType.value = '<%=CodesTables.CNUMTYPE_CRS_IDNUMBER%>';
  }
  // Now if the CRS ID is the Type selected then perfom the following logic
  if ((frmPersonIdentifiersDetail.selSzCdPersonIdType.value == "<%=CodesTables.CNUMTYPE_CRS_IDNUMBER%>" || <%=newCRS%>)
          && "<%=!isNotUpdatable%>")
  {
<%
  displayCrsButton = "inline";
  displayDtFields = "none";
  displayCrsMod= (!newCRS ? "none":"inline");
%>
    crsBtnSpanId.style.display = "<%=displayCrsButton%>";
    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.disabled = true;
    frmPersonIdentifiersDetail.dspDtPersonIDStart.visible = false;
    frmPersonIdentifiersDetail.dspDtPersonIDEnd.visible = false;
  }
  else
  {
<%
  displayCrsButton = "none";
  displayDtFields = "inline";
  displayCrsMod= "inline";
%>
    crsBtnSpanId.style.display = "<%=displayCrsButton%>";
    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.disabled = false;
  }
}

</script>

<%
  /* Include custom tag for displaying errors on the page */
%>
<impact:validateErrors/>
<%-- Begin Approval Status Form
//SIR 23827 added the hidden field hdnSSN--%>
<impact:validateForm name="frmPersonIdentifiersDetail" method="post"
                     action="/person/PersonIdentifiers/displayPersonIdDetail"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersCustomValidation"
                     pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">
<impact:validateInput type="hidden" name="hdnSSN" value='<%=notNew ? cint14wlb.getSzNbrPersonIdNumber() : ""%>'/>
<impact:validateInput type="hidden" name="hdnIncludingPageDisplayCommand"
                      value='<%=(String) request.getAttribute("includingPageDisplayCommand")%>'/>
<impact:validateInput type="hidden" name="hdnIsNew" value='<%=notNew ? "false" : "true"%>'/>
<impact:validateInput type="hidden" name="hdnUlIdPersonId" value="<%=FormattingHelper.formatInt(ulIdPersonId)%>"/>
<impact:validateInput type="hidden" name="newCRSString" value="<%=newCRSString%>" />
<impact:validateInput type="hidden" name="hdnTsLastUpdate2"
                      value='<%=notNew ? String.valueOf(cint14wlb.getTsSysTsLastUpdate2()) : ""%>'/>
<%--<impact:validateInput type="hidden" name="hdnIsValidated"  value="<%=notNew ? String.valueOf(cint14wlb.getBIndValidateByInterface()) : ServiceConstants.FND_NO%>" />
   --%>
<table class="tableBorder" width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
  <th colspan="5">
    Person Identifiers Detail
  </th>
</tr>
<tr>
  <%
    Set<String> excludeOptions = new HashSet<String>();
    if (pageMode.equals(PageModeConstants.NEW)
        || (pageMode.equals(PageModeConstants.EDIT) && !codeType.equals(CodesTables.CNUMTYPE_PACE_PROJECT_CLIENT))) {
      excludeOptions.add(CodesTables.CNUMTYPE_PACE_PROJECT_CLIENT);
    }

    //Sir23446 exclude SSN once it is verified by DHS
    if (isVerified && !hasUpdateProfile) {
      excludeOptions.add(CodesTables.CNUMTYPE_SSN);
    }
    if (!newCRS) {
  %>
  <td>
    <impact:validateSelect name="selSzCdPersonIdType" tabIndex="<%=tabIndex++%>" required="true"
                           value="<%=codeType%>" label="Type" codesTable="<%=CodesTables.CNUMTYPE%>"
                           contentType="<%=SelectTag.CODES%>" valueType="<%=SelectTag.CODES%>"
                           onChange="updatePersonIdentifierFields( this )"
                           disabled="<%=String.valueOf(isNotUpdatable)%>" excludeOptions="<%=excludeOptions%>"/>
  </td>
  <%
  } else {
  %>
  <td>
    <impact:validateDisplayOnlyField name="selSzCdPersonIdType" label="Type" value="<%=codeType %>"
                                     label="Type" required="true"/>
    <input type="hidden" name="selSzCdPersonIdType" value="<%=idNumber%>  ">
  </td>
  <%
    }
  %>
    <%--
        <td>
          <impact:validateInput type="text" name="txtSzNbrPersonIdNumber" size="15" maxLength="15"
            tabIndex="<%=tabIndex++%>" label="Number" value="<%=idNumber%>"
            disabled="<%=String.valueOf(isNotUpdatable)%>" required="true" />
          <input type="hidden" name="txtSzNbrPersonIdNumber" value="<%=idNumber%>">
        </td>
        --%>


  <%
    if (!newCRS) {
  %>

  <td>
    <impact:validateInput type="text" name="txtSzNbrPersonIdNumber" size="15" maxLength="15"
                          tabIndex="<%=tabIndex++%>" label="Number" value="<%=idNumber%>"
                          disabled="<%=String.valueOf(isNotUpdatable)%>" required="true"/>
  </td>
    <%-- If this is a new CRS ID make number field as display only --%>
  <%
  } else {
  %>
  <td>
    <impact:validateDisplayOnlyField name="txtSzNbrPersonIdNumber" label="Number"
                                     value="<%=idNumber%>" required="true"/>
    <input type="hidden" name="txtSzNbrPersonIdNumber" value="<%=idNumber%>">
  </td>
  <%
    }
  %>
</tr>
<tr>
  <td>
      <%-- <span id="dspDtPersonIDStartSpan" style="<%="display:"+ displayDtFields%>">  --%>
    <impact:validateDisplayOnlyField name="dspDtPersonIDStart" label="Start Date"
                                     value='<%=notNew ? FormattingHelper.formatDate(cint14wlb.getDtPersonIDStart())
                           : FormattingHelper.formatDate(DateHelper.getTodayCastorDate())%>'/>
  </td>
  <td>
      <%-- No need to check for notNew here; FormattingHelper handles the null check. --%>
      <%-- <span id="dspDtPersonIDEndSpan" style="<%="display:"+ displayDtFields%>" >  --%>
    <impact:validateDisplayOnlyField name="dspDtPersonIDEnd" label="End Date"
                                     value='<%=FormattingHelper.formatDate(endDate)%>'/>
  </td>
  <td width="10%">
    <%
      if (!isNotUpdatable && (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.EDIT))) {
        String updateDisplayJS =
                "javascript:updateDisplayOnlyField( 'frmPersonIdentifiersDetail', 'dspDtPersonIDEnd', '"
                + FormattingHelper.formatDate(new Date()) + "' );setPageDirtyFlag(true);";
    %>
    <a href="<%=updateDisplayJS%>" onClick="setIsDirtyCalled(true);" tabIndex="<%=tabIndex++%>"><img
            src="/grnds-docs/images/shared/btnSetEndDate.gif" class="md" border="0">
    </a>
    <%
      }
    %>
  </td>
</tr>
<tr>
  <td>
    <impact:validateInput type="text" name="txtSzDescPersonID" size="40" maxLength="40"
                          tabIndex="<%=tabIndex++%>" colspan="2" label="Comments"
                          disabled="<%=String.valueOf(isNotUpdatable)%>" conditionallyRequired="true"
                          value='<%=notNew ? cint14wlb.getSzDescPersonID() : ""%>'/>
  </td>
</tr>
<tr>
  <td>
    <%
      // To enable Invalid check box in Update mode if ID is end-dated/inactive
      //Before, Invalid was disabled in Update mode if ID is end-dated/inactive (page must have been set VIEW only)
      if (!DateHelper.isNull(endDate) || !newCRS) {
    %>
    <impact:validateInput type="checkbox" name="cbxBIndPersonIDInvalid" label="Invalid"
                          tabIndex="<%=tabIndex++%>" disabled="false" checked='<%=isInvalid ? "true" : "false"%>'/>
    <%
    } else {
    %>
    <impact:validateInput type="checkbox" name="cbxBIndPersonIDInvalid" label="Invalid"
                          tabIndex="<%=tabIndex++%>" disabled="<%=String.valueOf(isNotUpdatable)%>"
                          checked='<%=isInvalid ? "true" : "false"%>'/>
    <%
      }
    %>
  </td>
  <td colspan="4">
    &nbsp;
  </td>
</tr>
</table>
<br>
<%
  String functionString = "";
  if (!newCRS) {
    functionString =
            "javascript:return confirmAddWhenExistingOfSameType(frmPersonIdentifiersDetail.selSzCdPersonIdType.value, "
            + "frmPersonIdentifiersDetail.txtSzDescPersonID.value, " + hasEndDate + ");";
  } else {

    functionString = "javascript:return confirmAddWhenExistingOfSameType('" + codeType + "', "
                     + "frmPersonIdentifiersDetail.txtSzDescPersonID.value, " + hasEndDate + ");";
  }
%>
<Table align="right">
  <Tr>
    <%
      // To enable Save button in Update mode if ID is end-dated/inactive (page must have been set VIEW only)
      // Before, Save button was hidden in Update mode if ID is end-dated/inactive
      if (!DateHelper.isNull(endDate) && !newCRS) {
    %>
    <!-- STGAP00003954 display save button when -->
    <td>
        <span id="btnSaveFinalSpanId" style="<%="display:" + displayCrsMod%>">
        <impact:ButtonTag name="btnSaveFinal" img="btnSave" restrictRepost="true"
                          tabIndex="<%=tabIndex++%>" align="right" disabled="false" function="<%=functionString%>"
                          form="frmPersonIdentifiersDetail" action="/person/PersonIdentifiers/savePersonIdDetail"/>
        </span>
    </td>
    <%
    } else {
    %>
    <!-- Add a Get CRS ID button which will only display when the ID Type is CRS ID (using span-display) -->
    <td>
        <span id="crsBtnSpanId" style="<%="display:" + displayCrsButton%>">
        <impact:ButtonTag
                function="javascript:disableValidation('frmPersonIdentifiersDetail');" name="btnCrsId"
                img="btnCRSRequest" restrictRepost="true" tabIndex="<%=tabIndex++%>" align="right"
                disabled="<%=String.valueOf(isNotUpdatable)%>" form="frmPersonIdentifiersDetail"
                action="/person/PersonIdentifiers/displayCrsInquiryScreen"/> </span>
    </td>
    <td>
        <span id="btnSaveFinalSpanId" style="<%="display:" + displayCrsMod%>">
        <impact:ButtonTag name="btnSaveFinal" img="btnSave" restrictRepost="true"
                          tabIndex="<%=tabIndex++%>" align="right" disabled="<%=String.valueOf(isNotUpdatable)%>"
                          function="<%=functionString%>" form="frmPersonIdentifiersDetail"
                          action="/person/PersonIdentifiers/savePersonIdDetail"/>
        </span>
    </Td>
    <%
      }
    %>
  </Tr>
</Table>

<%-- This hidden field is used within the impact:validateForm tag to generate client-side state information --%>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
