<%
  //*-----------------------------------------------------------------------------
//*  JSP Name:     Phone Detail
//*  Created by:   Matthew McClain
//*  Date Created: 03/01/2003
//*
//*  Description:
//*  The Phone Detail page, accessed only through the sub-module, will provide a
//*  facility for users to add and maintain a phone number for a person in
//*  IMPACT.  The Phone Detail page will add or contain information on whether
//*  a number is the primary phone number for the person, whether it is valid,
//*  the type of phone number, the actual phone number, extension, the Start
//*  Date, and the End Date.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  -----------------------------------------------
//*  06/18/03  GRIMSHAN          SIR 18308 -- Invalid should be enabled for
//*                              primary phones
//*  08/06/03  Todd Reser        Added Description to Flowerbox.
//*  09/02/03  A.Corley          Changed hidden field session state manager to
//*                              increase performance.
//*  09/18/08  alwilliams        STGAP00006793 - Validation should be allowed if user has
//*                              SEC_MNTN_PERSON rights. Set disableValidation to false. 
//*-----------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.common.PhoneDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneConversation" %>
<%@ page import="org.exolab.castor.types.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  int tabIndex = 1;
  String formName = "PhoneDetail";
  String returnUrl = request.getParameter(PhoneConversation.RETURN_URL);

  UserProfile userProfile = PhoneConversation.getUserProfile(request);

  int stageId = GlobalData.getUlIdStage(request);
  String pageMode = (String) request.getAttribute(PhoneConversation.PAGE_MODE);

  PhoneDB phoneDB = (PhoneDB)
          request.getAttribute(PhoneConversation.PHONE_DETAIL_PHONE);

  boolean inEditMode = PageModeConstants.EDIT.equals(pageMode);
  boolean isNewNumber = (phoneDB.getPhoneId() == 0);
  boolean isActive = (phoneDB.getInvalid() == false);
  boolean isEndDate = true;

//view mode
  boolean disableType = true;
  boolean disablePrimary = true;
  boolean disableInvalid = true;
  boolean disableNumber = true;
  boolean disableExtension = true;
  boolean disableComments = true;
  boolean disableSetEndDateButton = true;
  boolean disableSaveButton = true;
  boolean disableNewUsingButton = true;
  boolean disableValidation = false;
  Date endDate =DateHelper.toCastorDate(phoneDB.getEndDate());
  String endDateString = phoneDB.getEndDateString();
  if(endDate == null || endDate.equals( DateHelper.MAX_CASTOR_DATE))
  {
    endDateString = "";
    isEndDate = false;
  }

//state 1 and 1a (modify): new number
  if ((inEditMode) &&
      (isNewNumber)) {
    disableType = false;
    disablePrimary = false;
    disableInvalid = false;
    disableNumber = false;
    disableExtension = false;
    disableComments = false;
    disableSetEndDateButton = true;
    disableSaveButton = false;
    disableNewUsingButton = (stageId == 0);
  }
//state 2 (modify): modify active number
  else if ((inEditMode) && (!isEndDate) && (isActive) &&
           (phoneDB.getPrimary() == false)) {
    disableType = true;
    disablePrimary = false;
    disableInvalid = false;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = false;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//state 3 (modify): modify end-dated number
  else if ((inEditMode) &&
           (phoneDB.getInvalid() == false) && (isEndDate)) {
    disableType = true;
    disablePrimary = true;
    disableInvalid = false;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = true;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//state 4 (modify) : modify invalid number
  else if ((inEditMode) && (phoneDB.getInvalid())) {
    disableType = true;
    disablePrimary = true;
    disableInvalid = true;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = true;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//HD 5/13/2003 -- SIR 17346 Should be able to set end date for primary number
  else if ((inEditMode) &&
           ( !isEndDate && (isActive) && (phoneDB.getPrimary()))) {
    disableType = true;
    disablePrimary = true;
    disableInvalid = false;
    disableNumber = true;
    disableExtension = true;
    disableComments = false;
    disableSetEndDateButton = false;
    disableSaveButton = false;
    disableNewUsingButton = true;
  }
//SIR 18659 - Users with MNTN_PERSON should have
//edit access to data widgets, after setting button
//access above.
//STGAP00006793 - Validation should be allowed if user has
//SEC_MNTN_PERSON rights. Set disableValidation to false. 
  if (userProfile.hasRight(UserProfile.SEC_MNTN_PERSON)) {
    disableType = false;
    disablePrimary = false;
    disableInvalid = false;
    disableNumber = false;
    disableExtension = false;
    disableComments = false;
    disableSaveButton = false;
    disableValidation = false;
  }
%>
<script src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="javascript">
  window.onbeforeunload = function()
  {  
    return IsDirty();
  }


  function setEndDate()
  {
    var form = document.all["<%= formName %>"];
    
    form.phoneEndDate.value = "<%= DateHelper.toString(new java.util.Date(), DateHelper.SLASH_FORMAT) %>";
    
    disableValidation("<%= formName %>");
    setIsDirtyCalled(true);
    return true;
  }


  function newUsing()
  {
    var form = document.all["<%= formName %>"];
    disableValidation("<%= formName %>");
    return true;
  }

  function save()
  {
    var form = document.all["<%= formName %>"];
  <% if ( disableValidation ) { %>
    disableValidation("<%= formName %>");
  <% } else { %>
    enableValidation("<%= formName %>");
  <% } %>
    return true;
  }



  //  function invalidSave()
  // {
  //    <impact:ifThen test="<%= userProfile.hasRight(UserProfile.SEC_MNTN_PERSON) %>">
  //    var form = document.all["<%= formName %>"];
  //    if(form.phoneInvalid.checked)
  //    {
  //      form.phoneType.value = enabled;
  //      form.phoneType.value = enabled;
  //    }
  //    </impact:ifThen>
  // }
</script>

<impact:validateErrors/>

<impact:validateForm
        name="<%= formName %>"
        method="post"
        pageMode="<%= pageMode %>"
        action='<%= PhoneConversation.PHONE_SAVE %>'
        schema="/WEB-INF/Constraints.xsd">

<!--Start Main Content-->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr><th colspan="5">Phone Information</th></tr>
<tr>
  <td width="15%">
    <impact:validateSelect
            tabIndex="<%= tabIndex++ %>"
            disabled='<%= "" + disableType %>'
            label="Type"
            id="phoneType"
            name="phoneType"
            width="20%"
            value="<%= phoneDB.getPhoneType() %>"
            required="true"
            codesTable="CPHNTYP"/>
  </td>
    <%-- !!!
         values don't just equal 'true' because; if checkboxes are disabled,
         they send their value even if they aren't checked
    --%>
  <td width="15%" class="formBoldedText">
    <impact:validateInput
            tabIndex="<%= tabIndex++ %>"
            disabled='<%= "" + disablePrimary %>'
            type="checkbox"
            name="phonePrimary"
            value='<%= "" + ((disablePrimary == false) || (phoneDB.getPrimary())) %>'
            checked='<%= "" + phoneDB.getPrimary() %>'/>Primary
  </td>
  <td colspan="2" width="50%" class="formBoldedText">
    <impact:validateInput
            tabIndex="<%= tabIndex++ %>"
            disabled='<%= "" + disableInvalid %>'
            type="checkbox"
            name="phoneInvalid"
            value='<%= "" + ((disableInvalid == false) || (phoneDB.getInvalid())) %>'
            checked='<%= "" + phoneDB.getInvalid()  %>'/>Invalid
  </td>
</tr>
<tr>
  <%
    String number = phoneDB.getNumber();
    if ("".equals(number) == false) {
      number = FormattingHelper.formatPhone(number);
    }
  %>
  <td>
    <impact:validateInput
            tabIndex="<%= tabIndex++ %>"
            disabled='<%= "" + disableNumber %>'
            type="text"
            label="Number"
            id="phoneNumber"
            name="phoneNumber"
            size="14"
            maxLength="14"
            constraint="Phone"
            required="true"
            value="<%= number %>"/>
  </td>
  <td>
    <impact:validateInput
            tabIndex="<%= tabIndex++ %>"
            disabled='<%= "" + disableExtension %>'
            type="extension"
            name="phoneExtension"
            label="Extension"
            constraint="PhoneExtension"
            size="8"
            maxLength="8"
            colspan="2"
            value="<%= phoneDB.getExtension() %>"/>
  </td>
</tr>
<tr>
  <td class="FormLabel" valign="top">Comments:</td>
  <td colspan="4">
    <impact:validateTextArea
            tabIndex="<%= tabIndex++ %>"
            disabled='<%= "" + disableComments %>'
            cols="120"
            rows="4"
            maxLength="300"
            constraint="Paragraph300"
            name="phoneComments">
      <%= phoneDB.getComments() %>
    </impact:validateTextArea>
  </td>
</tr>
<tr>
  <td class="FormLabel">Start Date:</td>
  <td>
    <%= phoneDB.getStartDateString() %>
    <impact:validateInput
            type="hidden"
            name="phoneStartDate"
            value="<%= phoneDB.getStartDateString() %>"/>
  </td>
  <td class="FormLabel">
    End Date:
  </td>
  <td width="7%"><%= endDateString %>
    <impact:validateInput
            type="hidden"
            name="phoneEndDate"
            value="<%= endDateString %>"/>
  </td>
  <td>
    <impact:ButtonTag
            name="SetEndDate"
            tabIndex='<%= tabIndex++ %>'
            disabled='<%= "" + disableSetEndDateButton %>'
            action='<%= PhoneConversation.PHONE_DETAIL %>'
            form='<%= formName %>'
            function='<%= "return setEndDate();" %>'
            img="btnSetEndDate"
            editableMode='<%= EditableMode.EDIT %>'
            restrictRepost="true"
            navAwayCk="true"/>
  </td>
</tr>
</table>


<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <impact:ButtonTag
              name="NewUsing"
              tabIndex='<%= tabIndex++ %>'
              disabled='<%= "" + disableNewUsingButton %>'
              action='<%= PhoneConversation.PHONE_PULLBACK %>'
              form='<%= formName %>'
              function='<%= "return newUsing();" %>'
              img="btnNewUsing"
              editableMode='<%= EditableMode.EDIT %>'
              navAwayCk="true"/>
      <impact:ButtonTag
              name="Save"
              accessKey="S"
              tabIndex='<%= tabIndex++ %>'
              disabled='<%= "" + disableSaveButton %>'
              action='<%= PhoneConversation.PHONE_SAVE %>'
              form='<%= formName %>'
              function='<%= "return save();" %>'
              img="btnSave"
              editableMode='<%= EditableMode.EDIT %>'
              restrictRepost="true"/>
    </td>
  </tr>
</table>
<!--End <Main Content-->

<impact:validateInput type="hidden" name="<%= PhoneConversation.RETURN_URL %>" value="<%= returnUrl %>"/>
<impact:validateInput type="hidden" name="phoneId" value='<%= "" + phoneDB.getPhoneId() %>'/>
<impact:validateInput type="hidden" name="phoneLastUpdate" value='<%= "" + phoneDB.getLastUpdateTime() %>'/>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>
<% // If the user pressed the End Date button on the previous page, page is dirty
  if (request.getParameter("SetEndDate.x") != null) { %>
<script language="javascript">
  setPageDirtyFlag(true);
</script>
<% } %>