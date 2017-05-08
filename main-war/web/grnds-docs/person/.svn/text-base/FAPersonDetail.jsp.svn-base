<%--
JSP Name:     FA Person Detail
Created by:   Lata Lokhande
Date Created: 01/26/2007

Description:
Jsp page to for F/A Person Detail Page.

Change History:
Date        User              Description
----------  ----------------  --------------------------------------------------
02/23/2011  Hai Nguyen        SMS#97850: MR-075 Removed old Criminal Record Checks
                              fields and added new GCIC and NCIC fields.  Set all
                              date fields to be calculated and display only.
04/21/2011  schoi             SMS #106551: MR-075 Updated the checkbox label 
                              from "Annual Medical Examination Form Required (65 yrs or older/health issue.)" 
                              to "Annual Medical Examination Form/Medical Health Statement Required for health concerns"                              
                              
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="java.util.Date"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailRetrieveSO"%>

<%
      String cbxMedFormReq = null;
      Date medRecCheckDueDt = null;
      Date criminalRecDueDt = null;
      Date lastMedCheckDt = null;
      Date dtLastGcicRecCheck = null;
      Date dtGcicRecCheckDue = null;
      Date dtLastNcicRecCheck = null;
      Date dtNcicRecCheckDue = null;
      boolean showSaveBtn = false;
      String disableField = "false";

      //get the RetrieveSO object from state
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      FAPersonDetailRetrieveSO faPersonDtlRetrieveSO = (FAPersonDetailRetrieveSO) state
                                                                                       .getAttribute(
                                                                                                     "FAPersonDetailRetrieveSO",
                                                                                                     request);

      //get the field values from RetrieveSO.
      if (faPersonDtlRetrieveSO != null) {
        cbxMedFormReq = faPersonDtlRetrieveSO.getAnnualMedFormRequired();
        medRecCheckDueDt = faPersonDtlRetrieveSO.getMedCheckDueDt();
        criminalRecDueDt = faPersonDtlRetrieveSO.getCriminalRecCheckDueDt();
        lastMedCheckDt = faPersonDtlRetrieveSO.getDtLastMedRecCheck();
        dtLastGcicRecCheck = faPersonDtlRetrieveSO.getDtLastGcicRecCheck();
        dtGcicRecCheckDue = faPersonDtlRetrieveSO.getDtGcicRecCheckDue();
        dtLastNcicRecCheck = faPersonDtlRetrieveSO.getDtLastNcicRecCheck();
        dtNcicRecCheckDue = faPersonDtlRetrieveSO.getDtNcicRecCheckDue();

      }

      String pageMode = (String) state.getAttribute("PageMode", request);
      if (pageMode == null) {
        pageMode = PageMode.getPageMode(request);
      }

      if (PageModeConstants.EDIT.equals(pageMode) || PageModeConstants.MODIFY.equals(pageMode)) {
        showSaveBtn = true;
        disableField = "false";

      } else if (pageMode.equals(PageModeConstants.VIEW)) {
        showSaveBtn = false;
        disableField = "true";
      }

      // Create a 1-based tab index variable that can be used to set tab indices down the page.
      int tabIndex = 1;
%>
<impact:validateErrors />
<impact:validateForm name="frmFAPersonDetail" method="post"
  action="/person/FAPersonDetail/displayFAPersonDetail"
  pageMode="<%=pageMode%>"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.FAPersonDetailCustomValidation"
  schema="/WEB-INF/Constraints.xsd">

  <%-- Begin Detail --%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%"
    class="tableBorder">
    <tr>
      <th colspan="4">
        Medical Information
      </th>
    </tr>
    <tr>
      <td width="40%">
        <impact:validateInput
          label="Annual Medical Examination Form/Medical Health Statement Required for health concerns"
          name="cbxMedFormReq" type="checkbox" conditionallyRequired="false"
          checked="<%=cbxMedFormReq%>" value="<%=cbxMedFormReq%>"
          disabled="<%=disableField%>" tabIndex="<%=tabIndex++%>" />
      </td>

    </tr>

  </table>
  <table border="0" cellspacing="0" cellpadding="3" width="100%"
    class="tableBorder">
    <tr>
      <td width="40%">
        <impact:validateDisplayOnlyField name="txtDtLastMedRecCheck"
          label="Previous (Last) Medical Records Check Date"
          value="<%=FormattingHelper.formatDate(lastMedCheckDt)%>" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtDtMedRecDue"
          label="Next Medical Records Check Due Date"
          value="<%=FormattingHelper.formatDate(medRecCheckDueDt)%>" />
      </td>

    </tr>
    <tr>
      <th colspan="4">
        Criminal Records Information
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtDtLastGcicRecCheck"
          label="Previous (Last) GCIC Records Check"
          value="<%=FormattingHelper.formatDate(dtLastGcicRecCheck)%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtDtGcicRecCheckDue"
          label="Next GCIC Records Check Due Date"
          value="<%=FormattingHelper.formatDate(dtGcicRecCheckDue)%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtDtLastNcicRecCheck"
          label="Previous (Last) NCIC Records Check"
          value="<%=FormattingHelper.formatDate(dtLastNcicRecCheck)%>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="txtDtNcicRecCheckDue"
          label="Next NCIC Records Check Due Date"
          value="<%=FormattingHelper.formatDate(dtNcicRecCheckDue)%>" />
      </td>
    </tr>
  </table>
  <%
  if (showSaveBtn) {
  %>

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td align="right" width="10%">
        <impact:ButtonTag name="btnSave" img="btnSave"
          action="/person/FAPersonDetail/saveFAPersonDetail"
          form="frmFAPersonDetail" align="right" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
  </table>
  <%
  }
  %>
  <impact:validateInput type="hidden" name="hdnPersonLoopCount" value="" />
  <impact:validateInput type="hidden" name="hdnUlIdPerson" value="" />
  <input type="hidden"
    name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
