<%--
JSP Name:     Placement Referral Log
Created by:   Lata Lokhande
Date Created: 02/12/2007

Description:
JSP file for Placement Referral Log page.

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementReferralLogList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%
      Integer idPlacementReferral = 0;
      Date dtLastUpdate = null;
      Integer idPerson = 0;
      Integer idResource = 0;
      Integer idEmployee = 0;
      Date dtBegin = null;
      Date dtExpiration = null;
      String cdStatus = null;
      String cdPlacementType = null;
      String nmPersonFull = null;
      String nmEmployeeFull = null;
      Integer nbrPersonAge = 0;
      String cdPersonSex = null;
      Date dtPersonBirth = null;

      boolean showAddPB = true;
      String hdnIdPlacementReferral = null;

      PlacementReferralLogRetrieveSO placementReferralLogRetrieveSO;

      //get the RetrieveSO object from state
      BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      placementReferralLogRetrieveSO = (PlacementReferralLogRetrieveSO) state.getAttribute("PlacementReferralLogRetrieveSO", request);

      //handle the null object
      if (placementReferralLogRetrieveSO == null) {
        placementReferralLogRetrieveSO = new PlacementReferralLogRetrieveSO();

      }

      if (placementReferralLogRetrieveSO.getPlacementReferralLogList() != null) {
        idResource = placementReferralLogRetrieveSO.getIdResource();
      }
      String pageMode = PageModeConstants.VIEW;

      if (PageMode.getPageMode(request) != null) {
        pageMode = PageMode.getPageMode(request);
      }

      if (pageMode.equals(PageModeConstants.VIEW)) {
        showAddPB = false;
      }

      int tabIndex = 1;
      int loopCount = 0;
      
      String context = "";
      String displayReferralDetailURL = "";
      String displayPersonDetailURL = "";
      String submitURL = "";
      if (CodesTables.CSTAGES_FAD.equals(GlobalData.getSzCdStage(request))){
        context = "/fad";
      }
      else{
        context = "/resource";
      }
      displayReferralDetailURL = context+"/PlacementReferralDetail/displayPlacementReferralDetail";
      submitURL = context+"/PlacementReferralLog/displayPlacementReferralLog";
      displayPersonDetailURL = context+"/PlacementReferralLog/callPersonDetail";
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2"> 
  
  function displayPlacementReferralDetail(idPlacementReferral, displayReferralDetailURL)
  {
    document.frmPlacementReferralLog.hdnIdPlacementReferral.value = idPlacementReferral;
    disableValidation("frmPlacementReferralLog");
    submitValidateForm("frmPlacementReferralLog", displayReferralDetailURL);
  }
  
  function submitToPersonDetail(personId, name, displayInfo,displayPersonDetailURL )
  {
    document.frmPlacementReferralLog.hdnUlIdPerson.value = personId;
    document.frmPlacementReferralLog.hdnFullName.value = name;
    document.frmPlacementReferralLog.bSysIndViewPersonInfo.value = displayInfo;
    submitValidateForm( "frmPlacementReferralLog", displayPersonDetailURL );
  }
  
  </script>

<impact:validateErrors />
<impact:validateForm name="frmPlacementReferralLog" method="post"
  action="<%=submitURL%>"
  pageMode="<%=pageMode%>" schema="/WEB-INF/Constraints.xsd">

  <impact:pagination
    submitUrl="<%=submitURL%>">
    <div id="scrollBar2" style="height:210px;width:100%;overflow:auto"
      class="tableborderList">

      <table width="100%" cellspacing="0" cellpadding="3" border="0">
        <tr>
          <th class="thList">
            Begin Date
          </th>
          <th class="thList">
            Expiration Date
          </th>
          <th class="thList">
            Status
          </th>
          <th class="thList">
            Person ID
          </th>
          <th class="thList">
            Name
          </th>
          <th class="thList">
            Gender
          </th>
          <th class="thList">
            DOB
          </th>
          <th class="thList">
            Age
          </th>
          <th class="thList">
            Placement Type
          </th>
          <th class="thList">
            Last Updated By
          </th>

        </tr>
        <%
                                                                                                  List<PlacementReferralLogList> pReferralLogList = placementReferralLogRetrieveSO
                                                                                                  .getPlacementReferralLogList();
                  if (pReferralLogList == null || pReferralLogList.size() < 1) {
        %>
        <tr class="odd">
          <td colspan="8">
            <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
          </td>
        </tr>
        <%
                    } else {
                    int counter = 1;
                    Iterator<PlacementReferralLogList> it = pReferralLogList.iterator();
                    while (it.hasNext()) {
                      PlacementReferralLogList prLogList = it.next();
                      idPlacementReferral = prLogList.getIdPlacementReferral();
        %>
        <tr>
          <td>
            <a
              href="javascript:displayPlacementReferralDetail('<%=idPlacementReferral%>','<%=displayReferralDetailURL%>')"
              tabIndex="<%=tabIndex++%>"> <%=DateHelper.isNull(prLogList.getDtBegin()) ? ""
                                                                      : DateHelper.SLASH_FORMAT.format(prLogList.getDtBegin())%>
          </td>

          <td>
            <%=DateHelper.isNull(prLogList.getDtExpiration()) ? "" : DateHelper.SLASH_FORMAT.format(prLogList.getDtExpiration())%>
          </td>

          <td>
            <%=(prLogList.getCdStatus() == null) ? "" : FormattingHelper.formatString(prLogList.getCdStatus())%>
          </td>
          <td>
            <%=(prLogList.getIdPerson() == 0) ? "" : FormattingHelper.formatInt(prLogList.getIdPerson())%>
          </td>
          <td>
            <a
              href="javascript:disableValidation('frmPlacementReferralLog'); submitToPersonDetail( '<%=prLogList.getIdPerson()%>', '<%=prLogList.getNmPersonFull()%>', '<%=ArchitectureConstants.Y%>','<%=displayPersonDetailURL%>' )">
              <%=(prLogList.getNmPersonFull() == null) ? ""  : FormattingHelper.formatString(prLogList.getNmPersonFull())%>
          </td>
          <td>
            <%=(prLogList.getCdPersonSex() == null) ? "" : FormattingHelper.formatString(prLogList.getCdPersonSex())%>
          </td>
          <td>
            <%=DateHelper.isNull(prLogList.getDtPersonBirth()) ? "" : DateHelper.SLASH_FORMAT.format(prLogList.getDtPersonBirth())%>
          </td>
          <td>
            <%=(prLogList.getNbrPersonAge() == 0) ? "" : FormattingHelper.formatInt(prLogList.getNbrPersonAge())%>
          </td>
          <td>
            <%=(prLogList.getCdPlacementType() == null) ? "" : FormattingHelper.formatString(prLogList.getCdPlacementType())%>
          </td>
          <td>
            <%=(prLogList.getNmEmployeeFull() == null) ? "" : FormattingHelper.formatString(prLogList.getNmEmployeeFull())%>
          </td>

          <%
                      loopCount++;
                      }
          %>
        </tr>
        <%
        }
        %>

      </table>
    </div>

  </impact:pagination>
  <%
  if (showAddPB) {
  %>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignRight" width="8%">
        <impact:ButtonTag name="btnAdd" img="btnAdd" align="right"
          form="frmPlacementReferralLog"
          action="<%=displayReferralDetailURL%>"
          tabIndex="<%=tabIndex++%>" />
    </tr>
  </table>

  <%
  }
  %>

  <input type="hidden"
    name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
  <%--<impact:validateInput type="hidden" name="hdnIdPlacementReferral" value=" <%= idPlacementReferral %> " />--%>
  <impact:validateInput type="hidden" name="hdnIdPlacementReferral"
    value="" />
  <impact:validateInput type="hidden" name="hdnIdResource"
    value=" <%=idResource%> " />
  <impact:validateInput type="hidden" name="hdnUlIdPerson" value="" />
  <impact:validateInput type="hidden" name="hdnFullName" />
  <impact:validateInput type="hidden" name="hdnUlIdStage" value="" />
  <impact:validateInput type="hidden" name="bIndActiveStatus" value="" />
  <impact:validateInput type="hidden" name="bSysIndViewPersonInfo" value="" />
</impact:validateForm>
