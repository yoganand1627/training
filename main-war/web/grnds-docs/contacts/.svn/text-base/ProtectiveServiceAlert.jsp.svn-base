<%--
JSP Name:     Protective Service Alert
Created by:   Lata Lokhande
Date Created: 09/13/2006

Description:
This JSP displays Protective Service Alert page

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
11-01-06  abgoode           Reformatted code
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.PersonProtectiveServiceAlertList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%
      String SPACES = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                      "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                      "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

      //-- inputs
      String psaDate = ContextHelper.getStringSafe(request, "psaDate");
      String psaTime = ContextHelper.getTimeSafe(request, "psaTime");
      String dateAbsconded = ContextHelper.getStringSafe(request, "dateAbsconded");
      String selReasonForAlert = ContextHelper.getStringSafe(request, "selReasonForAlert");
      String cbxAllPersonsLocated = ContextHelper.getStringSafe(request, "cbxAllPersonsLocated");
      String txtComments = ContextHelper.getStringSafe(request, "txtComments");

      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      ProtectiveServiceAlertRetrieveSO psaRetrieveSO = (ProtectiveServiceAlertRetrieveSO) state.getAttribute("ProtectiveServiceAlertRetrieveSO",
                                                                                                             request);

      //-- display only (always populated)
      String cdStage = psaRetrieveSO.getCdStage();
      String nmUserCreatedBy = psaRetrieveSO.getNmUserCreatedBy();
      String titleDecode = psaRetrieveSO.getTitleDecode();

      if (psaRetrieveSO.getIdStage() > 0) {
        //-- reset input values from output object
        Date date = psaRetrieveSO.getDate();
        psaDate = DateHelper.isNull(date) ? "" : DateHelper.SLASH_FORMAT.format(date);
        psaTime = DateHelper.isNull(date) ? "" : psaRetrieveSO.getTime();

        Date absconded = psaRetrieveSO.getDateAbsconded();
        dateAbsconded = DateHelper.isNull(absconded) ? "" : DateHelper.SLASH_FORMAT.format(absconded);

        selReasonForAlert = psaRetrieveSO.getCdReasonForAlert();
        cbxAllPersonsLocated = psaRetrieveSO.getIndAllPersonsLocated();
        txtComments = psaRetrieveSO.getComments();
      }

      //-- determine page mode and input enabling
      String pageMode = PageMode.getPageMode(request);

      String psiDisabled = "true";
      String allPersonLocatedDisabled = "true";
      boolean personListViewOnly = false;
      if (pageMode.equals(PageModeConstants.NEW)) {
        psiDisabled = "false";
      } else if (pageMode.equals(PageModeConstants.MODIFY)) {
        allPersonLocatedDisabled = "false";
      } else{ //-- everything defaults to view-only
        personListViewOnly = true;
      }

      int tabIndex = 1;
%>
<%--
Create javascript functions here for page specific actions on the page. All form submits should use the
  submitValidateForm function to submit which is included in the JavaScript files included in index.jsp.
--%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  }

  // This function is called when the user clicks a hyperlink in the list.
  function personListHyperlink (index)
  {
    frmProtectiveServiceAlert.hdnPersonLoopCount.value = index;
  }

  function displayPersonDetail(personId)
  {
    document.frmProtectiveServiceAlert.hdnUlIdPerson.value = personId;
    disableValidation("frmProtectiveServiceAlert");
    submitValidateForm("frmProtectiveServiceAlert", "/contacts/ProtectiveServiceAlert/displayPersonDetail");
  }
</script>
<impact:validateErrors />
<impact:validateForm
  name="frmProtectiveServiceAlert"
  method="post"
  action="/contacts/ProtectiveServiceAlert/displayProtectiveServiceAlert"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.contacts.ProtectiveServiceAlertCustomValidation"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">
  <%--<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />--%>
  <%--<impact:validateInput type="hidden" name="hdnCaseId" value="<%= String.valueOf(psaRetrieveSO.getCaseId()) %>" />--%>
  <impact:validateInput
    type="hidden"
    name="hdnStageId"
    value="<%=String.valueOf(psaRetrieveSO.getIdStage())%>"
  />
  <%--<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= tsLastUpdate %>" />--%>
  <%--<impact:validateInput type="hidden" name="hdnPersonId" value="<%= personId %>"/>--%>
  <%--<impact:validateInput type="hidden" name="hdnEventId" value="<%= eventId %>"/>--%>
  <table border="0" cellspacing="0" cellpadding="3" class="tableBorder" width="100%">
    <tr>
      <th colspan="6">Protective Service Information</th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="displayStageCode" label="Stage" value="<%= Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, cdStage) %>" />
      </td>
      <td>
        <impact:validateDate
          label="Date"
          constraint="Date"
          name="psaDate"
          value="<%= psaDate %>"
          required="true"
          size="10"
          disabled="<%= psiDisabled %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
      <td>
        <impact:validateTime
          label="Time"
          name="psaTime"
          value="<%= psaTime %>"
          conditionallyRequired="true"
          disabled="<%= psiDisabled %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDate
          label="Date Absconded"
          constraint="Date"
          name="dateAbsconded"
          value="<%= dateAbsconded %>"
          disabled="<%= psiDisabled %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
      <td>
        <impact:validateSelect
          label="Reason For Alert"
          name="selReasonForAlert"
          codesTable="<%= CodesTables.CREASALT %>"
          required="true"
          disabled="<%= psiDisabled %>"
          value="<%= selReasonForAlert %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
      <td colspan="2">
        <impact:validateInput
          label="All Persons Located"
          name="cbxAllPersonsLocated"
          type="checkbox"
          conditionallyRequired="true"
          checked="<%= cbxAllPersonsLocated %>"
          value="<%= cbxAllPersonsLocated %>"
          disabled="<%= allPersonLocatedDisabled %>"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField
          name="displayUserCreatedBy"
          colspan="5"
          label="Created By"
          value="<%= nmUserCreatedBy %>"
        />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField
          name="displayUserTitle"
          colspan="5"
          label="Title"
          value="<%= titleDecode %>"
        />
      </td>
    </tr>
    <tr>
      <td valign="top">
        <impact:validateTextArea
          name="txtComments"
          colspan="5"
          label="Comments"
          rows="4"
          cols="80"
          maxLength="300"
          required="true"
          tabIndex="<%= tabIndex++ %>"
          disabled="<%= psiDisabled %>"
          constraint="Comments">
            <%= txtComments != null ? txtComments : "" %>
        </impact:validateTextArea>
      </td>
    </tr>
  </table>
  <br>
  <%--/*impact:pagination submitUrl="/contacts/ProtectiveServiceAlert/displayProtectiveServiceAlert" saveState="false"*/--%>
  <table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
    <tr>
      <th>Persons Absconded</th>
    </tr>
    <tr class="subDetail">
      <td width="100%" class="formlabel">
        <div id="scroll3" style="width:100%; height:125px; overflow:auto" class="tableBorderList">
          <table width="100%" border="0" cellspacing="0" cellpadding="3">
            <tr>
              <th class="thList">&nbsp;</th><!-- checkbox -->
              <th class="thList">&nbsp;</th><!-- exclamation mark -->
              <th class="thList">Name</th>
              <th class="thList">DOB</th>
              <th class="thList">SSN</th>
              <th class="thList">Race/Ethnicity</th>
              <th class="thList">Gender</th>
              <th class="thList">Legal Status</th>
            </tr>
<%
  List<PersonProtectiveServiceAlertList> persons = psaRetrieveSO.getPersons();
  if(persons == null || persons.size() < 1){
%>
            <tr class="odd">
              <td colspan="8">
                <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
              </td>
            </tr>
<%
  } else {
    int counter = 1;
    Iterator<PersonProtectiveServiceAlertList> it = persons.iterator();
    while(it.hasNext()){
      PersonProtectiveServiceAlertList person = it.next();
      boolean display = true;
      if(personListViewOnly){
        display = person.isPsaCurrentlyActive();
      }
      if(display){
%>
            <tr class="<%=FormattingHelper.getRowCss(counter)%>">
              <td>
                <impact:validateInput
                  type="checkBox"
                  tabIndex="<%= tabIndex++ %>"
                  name="<%= "cbxPersonsAbsconded_" + counter %>"
                  checked="<%= ""+person.isPsaCurrentlyActive() %>"
                  disabled="<%= "" + personListViewOnly %>"
                  value="<%= String.valueOf(counter) %>"
                />
              </td>
              <td>
<%
        if(person.isPsaCurrentlyActive()){
%>
                <font color="red">!</font>
<%
        }
%>
              </td>
              <td>
                <a href="javascript:displayPersonDetail('<%= person.getIdPerson() %>')" tabIndex="<%= tabIndex++ %>">
<%
        String nameStr = person.getName() != null && !"".equals(person.getName()) ? person.getName() : SPACES;
        out.print(nameStr);
%>
                </a>
              </td>
              <td>
<%
        String dobStr = DateHelper.isNull(person.getDOB()) ? "" : DateHelper.SLASH_FORMAT.format(person.getDOB());
        out.print(dobStr);
%>
              </td>
              <td><%= person.getSSN() != null && !"".equals(person.getSSN()) ? person.getSSN() : "" %></td>
              <td>
<%
        String personRace = person.getRace() != null && !"".equals(person.getRace()) ? person.getRace() : "__";
        String personEth = person.getEthnicity() != null && !"".equals(person.getEthnicity()) ? person.getEthnicity() : "__";
        out.print(personRace + "/" + personEth);
%>
              </td>
              <td><%= person.getGender() != null && !"".equals(person.getGender()) ? person.getGender() : "" %></td>
              <td><%= person.getLegalStatus() != null && !"".equals(person.getLegalStatus()) ? person.getLegalStatus() : "" %></td>
            </tr>
<%
      }
      counter++;
    }
%>
<%--/*
    int personsAbscondedCount = 0;
    boolean personAbsconded = false;
    boolean activeAlert = false;
    while (personsCount.hasNext()) {
      if (personsAbscondedArrayList.size() > 0){
        PersonProtectiveServiceAlertList personPSAObject = (PersonProtectiveServiceAlertList)personsAbscondedArrayList.get(personsAbscondedCount);
        //personsAbscondedCount++;
        personAbsconded = personPSAObject.isPersonAbsconded();
      }
      if (personsAbscondedListFromRetrieve.size() > 0){
        PersonProtectiveServiceAlertList personPSA = (PersonProtectiveServiceAlertList)personsAbscondedListFromRetrieve.get(personsAbscondedCount);
        //personsAbscondedCount++;
        activeAlert = personPSA.isActiveAlert();
      }
      personsAbscondedCount++;

      Map personMap = personsCount.next();
      String checkBoxId = "cbxPersonsAbsconded_" + loopCount;

      int personId = ((Integer) personMap.get("idPerson")).intValue();
      request.setAttribute("idPerson", personId);
      GlobalData.setUlIdPerson(personId, request);
%>
            <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
<%
      if ((personAbsconded) || (activeAlert) ){
%>
              <td>
                <font color="red">&nbsp;&nbsp;!</font>
              </td>
<%
      } else {
%>
              <td>
                <impact:validateInput
                  type="checkBox"
                  id="<%=checkBoxId%>"
                  tabIndex="<%=tabIndex++%>"
                  name="<%=checkBoxId%>"
                  disabled="<%= ""+personListViewOnly %>"
                  value="<%=String.valueOf(loopCount)%>"
                />
              </td>
<%
      }
%>
              <td>
                <a href="javascript:displayPersonDetailHyperlink('<%=personId%>')" tabIndex="<%=tabIndex++%>">
<%
      //SIR 19455 -- If there is a blank value in the Person's name field
      //a line will display for the user to click on.
      if (StringHelper.isValid((String) personMap.get("nmPersonFull")) == false) {
        out.print(SPACES);
      } else {
        out.print(FormattingHelper.formatString((String) personMap.get("nmPersonFull")));
      }
%>
                </a>
              </td>
              <td>
<%
      if (DateHelper.isNull((Date) personMap.get("dtPersonBirth")) == true) {
        out.print(SPACES);
      } else {
        out.print(FormattingHelper.formatDate((java.util.Date) personMap.get("dtPersonBirth")));
      }
%>
              </td>
              <td>
<%
      if (StringHelper.isValid((String) personMap.get("nbrPersonIdNumber")) == false) {
        out.print(SPACES);
      } else {
        out.print(FormattingHelper.formatSSN((String) personMap.get("nbrPersonIdNumber")));
      }
%>
              </td>
              <td>
<%
      if (StringHelper.isValid((String) personMap.get("cdPersonEthnicGroup")) == false) {
        out.print(SPACES);
      } else {
        out.print(FormattingHelper.formatString((String) personMap.get("cdPersonEthnicGroup")));
      }
%>
              </td>
              <td>
<%
      if (StringHelper.isValid((String) personMap.get("cdPersonsex")) == false) {
        out.print(SPACES);
      } else {
        out.print(FormattingHelper.formatString((String) personMap.get("cdPersonsex")));
      }
%>
              </td>
              <td>
<%
      if (StringHelper.isValid((String) personMap.get("cdPersonStatus")) == false) {
        out.print(SPACES);
      } else {
        out.print(FormattingHelper.formatString((String) personMap.get("cdPersonStatus")));
      }
%>
              </td>
<%
      loopCount++;
    }
*/--%>
<%
  }
%>
          </table>
        </div>
      </td>
    </tr>
  </table>
<%
  if(!personListViewOnly){
%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td align="right" width="10%">
        <impact:ButtonTag
          name="btnSave"
          img="btnSave"
          action="/contacts/ProtectiveServiceAlert/saveProtectiveServiceAlert"
          form="frmProtectiveServiceAlert"
          align="right"
          tabIndex="<%= tabIndex++ %>"
        />
      </td>
    </tr>
  </table>
<%
  }
%>
<%--/* /impact:pagination */--%>
<impact:validateInput type="hidden" name="hdnPersonLoopCount" value="" />
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="" />
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>