<%--
JSP Name:     Placement Referral Detail
Created by:   Lata Lokhande
Date Created: 02/12/2007

Description:
JSP file for Placement Referral Log page.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="java.util.Date"%>

<%@ page
  import="gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralDetailRetrieveSO"%>
<%
      Date dtBegin = null;
      Date dtExpiration = null;
      String cdPlacementType = null;
      String nmPersonFull = null;
      
      int defaultExpirationDays_180 = 180;
      int defaultExpirationDays_30 = 30;

      boolean showButton = false;
      String disableField = "true";

      String ICPCAdoptive = CodesTables.CPLMNTYP_ICA;
      String ICPCFoster = CodesTables.CPLMNTYP_ICF;
      String ICPCRelative = CodesTables.CPLMNTYP_ICR;

      // Create a 1-based tab index variable that can be used to set tab indices down the page.
      int tabIndex = 1;

      //get the RetrieveSO object from state
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      PlacementReferralDetailRetrieveSO placementReferralDetailRetrieveSO = (PlacementReferralDetailRetrieveSO) state
                                                                                                                     .getAttribute(
                                                                                                                                   "PlacementReferralDetailRetrieveSO",
                                                                                                                                   request);

      String pageMode = PageModeConstants.EDIT;
      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      } else {
        pageMode = (String) state.getAttribute("PageMode", request);
      }
      //for EDIT and MODIFY mode, enable all fields and show button, otherwise
      //disable fields and hide button.
      if (pageMode.equals(PageModeConstants.EDIT) || pageMode.equals(PageModeConstants.MODIFY)) {
        showButton = true;
        disableField = "false";
      } else {
        showButton = false;
        disableField = "true";
      }

      //handle the null object
      if (placementReferralDetailRetrieveSO == null) {
        placementReferralDetailRetrieveSO = new PlacementReferralDetailRetrieveSO();

      } else {
        dtBegin = placementReferralDetailRetrieveSO.getDtBegin();
        nmPersonFull = placementReferralDetailRetrieveSO.getNmPersonFull();
        cdPlacementType = placementReferralDetailRetrieveSO.getCdPlacementType();
        dtExpiration = placementReferralDetailRetrieveSO.getDtExpiration();
        
      }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

function getDafaultExpirationDate(){
var placementType = document.frmPlacementReferralDetail.selCdPlacementType.value;

  if(placementType != null){
    if( <%=disableField.equals("false")%>) {
      var defaultExpirationDate;

      if(placementType == '<%=ICPCAdoptive%>' || placementType == '<%=ICPCFoster%>'
                          || placementType == '<%=ICPCRelative%>' ) {

        defaultExpirationDate = '<%=FormattingHelper.formatDate(DateHelper.addToDate(new Date(), 0, 0, defaultExpirationDays_180))%>';
      }else {
        defaultExpirationDate = '<%=FormattingHelper.formatDate(DateHelper.addToDate(new Date(), 0, 0, defaultExpirationDays_30))%>';
      }
      document.frmPlacementReferralDetail.txtDtExpiration.value = defaultExpirationDate;

    }

  }
}
</script>
<impact:validateErrors />
<impact:validateForm name="frmPlacementReferralDetail" method="post"
  action="/resource/PlacementReferralDetail/displayPlacementReferralDetail"
  pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">
  <%-- Begin Detail --%>

  <table border="0" cellspacing="0" cellpadding="3" width="100%"
    class="tableBorder">
    <tr>
      <th colspan="6">
        Placement Referral Detail
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspPersonName" label="Name"
          required="true"
          value="<%=FormattingHelper.formatString(nmPersonFull)%>" />
      </td>
      <%
      if (showButton) {
      %>
      <td align="right" width="10%">
        <impact:ButtonTag name="btnSelectPerson" img="btnSelectPerson"
          function="disableValidation('frmPlacementReferralDetail');"
          action="/resource/PlacementReferralDetail/displayPersonList"
          form="frmPlacementReferralDetail" align="left" backSafe="true"
          editableMode='<%=EditableMode.EDIT%>' tabIndex="<%=tabIndex++%>" />
      </td>
      <%
      }
      %>
      <td>
        &nbsp;&nbsp;&nbsp;
      </td>
      <td>
        <impact:validateSelect name="selCdPlacementType"
          label="Placement Type" codesTable="<%=CodesTables.CPLMNTYP%>"
          value="<%=cdPlacementType%>" tabIndex="<%=tabIndex++%>"
          disabled="<%=disableField%>"
          onChange="return getDafaultExpirationDate();" required="true"
          blankValue="true" />
      </td>

    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="dspBiginDate"
          label="Begin Date"
          value="<%=FormattingHelper.formatDate(dtBegin)%>" />
      </td>
      <td>
        &nbsp;&nbsp;&nbsp;
      </td>
      <td></td>
      <td>
        <impact:validateDate name="txtDtExpiration" label="Expiration Date"
          constraint="Date" required="true"
          value="<%=FormattingHelper.formatDate(dtExpiration)%>"
          disabled="<%=disableField%>" size="10" tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>

  </table>
  <%
  if (showButton) {
  %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td align="right" width="10%">
        <impact:ButtonTag name="btnSave" img="btnSave"
          action="/resource/PlacementReferralDetail/savePlacementReferralDetail"
          form="frmPlacementReferralDetail" align="right"
          tabIndex="<%=tabIndex++%>" />
      </td>
    </tr>
  </table>
  <%
  }
  %>

  <impact:validateInput type="hidden" name="hdnContinueBtn" value="true" />
  <impact:validateInput type="hidden"
    name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
</impact:validateForm>



