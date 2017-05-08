<%
//*  JSP Name:     Legacy Application Information
//*  Created by:   Rodrigo DeJuana
//*  Date Created: 03/20/03
//*
//*  Description:
//*  This page will display for children who are currently in Foster Care and
//*  are not currently eligible for Title IV-E when IMPACT rolls out.  The
//*  purpose of this page is to capture the reasons the child is not eligible
//*  from the most recent application when the child comes up for Foster Care
//*  Review.
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Added description to Flowerbox comments.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.LegacyApplicationDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.LegacyApplicationConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  int tabIndex = 1;
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = (BaseSessionStateManager)
    request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  LegacyApplicationDB legacyDB = (LegacyApplicationDB)
    request.getAttribute(LegacyApplicationConversation.LEGACYDB);
%>
<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};
</script>

<impact:validateErrors/>

<impact:validateForm name="frmLegacyApplication"
  method="post"
  action="/fce/LegacyApplication/saveLegacyApplication"
  pageMode="<%= pageMode %>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.LegacyApplicationCustomValidation"
  schema="/WEB-INF/Constraints.xsd">


<!-- Hidden Fields -->
<impact:validateInput type="hidden"
                      name="idFceApplication"
                      value="<%= legacyDB.getIdFceApplicationString() %>" />

<impact:validateInput type="hidden"
                      name="idFceEligibility"
                      value="<%= legacyDB.getIdFceEligibilityString() %>" />

<impact:validateInput type="hidden"
                      name="idStage"
                      value="<%= legacyDB.getIdStageString() %>" />

<impact:validateInput type="hidden"
                      name="idEvent"
                      value="<%= legacyDB.getIdEventString() %>" />

<impact:validateInput type="hidden"
                      name="idLastUpdatePerson"
                      value='<%= "" + LegacyApplicationConversation.getUserID(request) %>' />

<impact:validateInput type="hidden"
                      name="fceEligibilityDtLastUpdateTime"
                      value='<%= ""+ legacyDB.getFceEligibilityDtLastUpdateTime() %>' />

<!--- Begin Detail Table --->
<table border="0" width="100%" cellSpacing="0" cellPadding="3" class="tableBorder">
  <tr>
    <th colspan="2">From the most recent application:</th>
  </tr>
  <tr>
    <td colspan="2" class="formInstruct" >This child is currently NOT Title
IV-E eligible and there is no IMPACT Foster Care Assistance Application
information available for this child.  Please select the reason(s) why the
child was NOT IV-E eligible on his or her most recent Foster Care Assistance
application.
      <br><br>
    </td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indChildUnder18"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndChildUnder18Object()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>The child was 18 years or older.</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indChildQualifiedCitizen"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndChildQualifiedCitizenObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>The child's citizenship/alien status was Undetermined Status.</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indParentalDeprivation"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndParentalDeprivationObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>Parental Deprivation did NOT exist in the Home of Removal.</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indChildLivingPrnt6Mnths"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndChildLivingPrnt6MnthsObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>The child did not live with a Parent(s) or a Specified Relative(s) at any time during the 6
        months prior to the month the court proceedings to remove the child were initiated.</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indHomeIncomeAfdcElgblty"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndHomeIncomeAfdcElgbltyObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>The certified group's income exceeded the allowable AFDC income limit.</td>
  </tr>
  <tr class="odd">
<!-- see ApplicationReasonsNotEligible -->
    <td><impact:validateInput name="indEquity"
                              checked='<%= "" + Boolean.TRUE.equals(legacyDB.getIndEquityObject()) %>'
                              value="true"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>The certified group's resources exceeded $10,000.</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indRemovalChildOrdered"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndRemovalChildOrderedObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>The first order ordering the child's removal from the home did NOT contain the judicial
        determination that removal was "In the Child's Best Interest" or that "Remaining in the Home
        was Contrary to the Welfare of the Child".</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indRsnblEffortPrvtRemoval"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndRsnblEffortPrvtRemovalObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>There was not a judicial determination that "Reasonable Efforts were made to Prevent Removal".</td>
  </tr>
  <tr class="odd">
    <td><impact:validateInput name="indPrsManagingCvs"
                              checked='<%= "" + Boolean.FALSE.equals(legacyDB.getIndPrsManagingCvsObject()) %>'
                              value="false"
                              type="checkbox"
                              cssClass="formInput"
                              tabIndex="<%= tabIndex++ %>"/></td>
    <td>There was NOT a court order giving FPS responsibility for the child's placement and care,
        or managing conservatorship of the child.</td> 
  </tr>
</table>

<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td align="right">
      <impact:ButtonTag name="btnContinue"
                          img="btnContinue"
                          form="frmLegacyApplication"
                          disabled='<%= "" + (PageModeConstants.VIEW.equals(pageMode) == false) %>'
                          editableMode='<%= (EditableMode.EDIT | EditableMode.VIEW) %>'
                          action="/fce/LegacyApplication/continueLegacyApplication"
                          tabIndex="<%= tabIndex++ %>"/>
      <impact:ButtonTag name="btnSave"
                          img="btnSave"
                          form="frmLegacyApplication"
                          disabled='<%= "" + PageModeConstants.VIEW.equals(pageMode) %>'
                          editableMode='<%= EditableMode.EDIT %>'
                          action="/fce/LegacyApplication/saveLegacyApplication"
                          restrictRepost="true"
                          tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>

