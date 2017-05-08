<%//*  JSP Name:     ThirdPartyHI.jsp 
      //*  Created by:   Guatami Rout
      //*  Date Created: 12/18/06
      //*
      //*  Description:
      //*  This page allows a user to enter a Child's Health Insurance Information
      //*  which includes Child Information, Address of the Home of Removal, List of
      //*  Principals, Responsibility for Child Care, Health Insurance, and Most
      //*  Recent Placements.
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       
       */

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Option"%>
<%String pageMode = PageMode.getPageMode(request);
      int tabIndex = 1;
      String TRUE = "true";
      ThirdPartyHealthInsuranceDB populateBean = (ThirdPartyHealthInsuranceDB) request
                                                                                      .getAttribute("ThirdPartyHealthInsuranceDB");
      if (populateBean == null) {
        populateBean = new ThirdPartyHealthInsuranceDB();
      }
     
      String healthZip = populateBean.getAddrZip();
      String healthZipSuff = "";
      if (healthZip.length() > 5) {
        healthZipSuff = healthZip.substring(5);
        healthZip = healthZip.substring(0, 5);
      }
      
      String errorMsg = (String)request.getAttribute("Error");
      
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};


function disablePage()
{
  var x = document.frmThirdPartyHealthInsurance;
  
  x.cdType.disabled = true;
  x.nmCompany.disabled = true;
  x.nbrPolicy.disabled = true;
  x.nbrGroup.disabled = true;
  x.addrStLn1.disabled = true;
  x.addrStLn2.disabled = true;
  x.addrCity.disabled = true;
  x.addrState.disabled = true;
  x.addrZip.disabled = true;
  x.addrZipSuff.disabled = true;
  x.nbrPhone.disabled = true;
  x.cdPolicyHldr.disabled = true;
  x.dtBegin.disabled = true;
  x.dtEnd.disabled = true;
  x.nmEmployer.disabled = true;
  x.nmEmployeeNm.disabled = true;
  x.indAuthRelease.disabled = true;
  x.dtAuthReleaseDate.disabled = true;
  x.indAuthAssign.disabled = true;
  x.dtAuthAssignDate.disabled = true;
  x.indChangeCancel[0].disabled = true;
  x.indChangeCancel[1].disabled = true;
  x.dtChangeCancel.disabled = true;
  for (i = 0; i < x.numberOfPrinciples.value; i++){
    var check = 'cbThirdPartyHealthIns_'; 
    var box = eval('document.frmThirdPartyHealthInsurance.'+ check + i);
    box.disabled = true; 
  }
}
function enablePage()
{
  var x = document.frmThirdPartyHealthInsurance;
  x.cdType.disabled = false;
  x.nmCompany.disabled = false;
  x.nbrPolicy.disabled = false;
  x.nbrGroup.disabled = false;
  x.addrStLn1.disabled = false;
  x.addrStLn2.disabled = false;
  x.addrCity.disabled = false;
  x.addrState.disabled = false;
  x.addrZip.disabled = false;
  x.addrZipSuff.disabled = false;
  x.nbrPhone.disabled = false;
  x.cdPolicyHldr.disabled = false;
  x.dtBegin.disabled = false;
  x.dtEnd.disabled = false;
  x.nmEmployer.disabled = false;
  x.nmEmployeeNm.disabled = false;
  x.indAuthRelease.disabled = false;
  x.dtAuthReleaseDate.disabled = false;
  x.indAuthAssign.disabled = false;
  x.dtAuthAssignDate.disabled = false;
  x.indChangeCancel[0].disabled = false;
  x.indChangeCancel[1].disabled = false;
  x.dtChangeCancel.disabled = false;
  for (i = 0; i < x.numberOfPrinciples.value; i++){
    var check = 'cbThirdPartyHealthIns_'; 
    var box = eval('document.frmThirdPartyHealthInsurance.' + check + i);
    box.disabled = false;
  }
}

</script>

<impact:validateErrors formName="frmThirdPartyHealthInsurance" />
<impact:validateForm name="frmThirdPartyHealthInsurance" method="post" validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.ThirdPartyHealthInsuranceCustomValidation" action="/fce/ThirdPartyHealthInsurance/displayThirdPartyHealthInsurance"
  schema="/WEB-INF/Constraints.xsd" redisplayParameters="true" pageMode="<%= pageMode %>">

  <impact:validateInput type="hidden" name="idLastUpdatePerson" value="<%=populateBean.getIdLastUpdatePersonString()%>" />
  <impact:validateInput type="hidden" name="idEvent" value="<%=populateBean.getIdEventString()%>" />
  <impact:validateInput type="hidden" name="idFceApplication" value="<%=populateBean.getIdFceApplicationString()%>" />
  <impact:validateInput type="hidden" name="idFceEligibility" value="<%=populateBean.getIdFceEligibilityString()%>" />
  <impact:validateInput type="hidden" name="idPerson" value="<%=populateBean.getIdPersonString()%>" />
  <impact:validateInput type="hidden" name="idStage" value="<%=populateBean.getIdStageString()%>" />
  <impact:validateInput type="hidden" name="idLastUpdatePerson" value='<%= "" + BasePrsConversation.getUserID(request) %>' />
  <impact:validateInput type="hidden" name="cdApplication" value="<%=populateBean.getCdApplication()%>" />

  <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan=6>
        Child's Health Insurance Coverage
      </th>
    </tr>
    <tr>
      <td colspan="6">
        <table width="100%">
          <tr>
            <td width="15%">
              <%Boolean indChildCoverage = populateBean.getIndChildCoverageObject();
      boolean yesChecked = false;
      boolean noChecked = false;

      if (indChildCoverage == null) {
        yesChecked = false;
        noChecked = true;
      } else {
        yesChecked = populateBean.getIndChildCoverage();
        noChecked = !populateBean.getIndChildCoverage();
      }
      
      if(TRUE.equals(errorMsg)){
        noChecked = false;
      }
     %>
              <impact:validateInput type="radio" id="rbHealthInsuranceYes" tabIndex="<%= tabIndex++ %>" name="indChildCoverage" value="true" label="Yes" checked="<%=String.valueOf(yesChecked)%>" onClick="enablePage()" />
              <impact:validateInput type="radio" id="rbHealthInsuranceNo" tabIndex="<%= tabIndex++ %>" name="indChildCoverage" value="false" label="No" checked="<%=String.valueOf(noChecked)%>" onClick="disablePage()" />
            </td>
            <td>
              Is the child covered by any health insurance other than Medicaid?
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td colspan=6>
        If yes, please complete the following section:
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect label="Type" name="cdType" tabIndex="<%= tabIndex++ %>" codesTable="CINSTYPE" value="<%= populateBean.getCdType() %>"/>
      <td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" label="Company Name" name="nmCompany" cssClass="formInput" value="<%= populateBean.getNmCompany() %>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateInput type="text" label="Policy No." name="nbrPolicy" cssClass="formInput" value="<%= String.valueOf(populateBean.getNbrPolicy()) %>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateInput type="text" label="Group No." name="nbrGroup" cssClass="formInput" value="<%= String.valueOf(populateBean.getNbrGroup()) %>" size="20" maxLength="20" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" label="Street" constraint="Address" name="addrStLn1" cssClass="formInput" value="<%= populateBean.getAddrStLn1() %>" size="30" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        &nbsp;
      </td>
      <td>
        <impact:validateInput type="text" label="" constraint="Address" name="addrStLn2" cssClass="formInput" value="<%= populateBean.getAddrStLn2() %>" size="30" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" label="City" constraint="City" name="addrCity" cssClass="formInput" value="<%= populateBean.getAddrCity() %>" size="20" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateSelect label="State" name="addrState" tabIndex="<%= tabIndex++ %>" codesTable="CSTATE" value="<%= populateBean.getAddrState() %>" />
      <td>
        <impact:validateInput type="text" label="Zip" constraint="Zip" name="addrZip" cssClass="formInput" value="<%= healthZip %>" size="5" maxLength="5" tabIndex="<%= tabIndex++ %>" />
        -
        <impact:validateInput type="text" constraint="ZipSuff" name="addrZipSuff" cssClass="formInput" value="<%= healthZipSuff %>" size="4" maxLength="4" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>

    <tr>
      <td>
        <impact:validateInput type="text" label="Phone" constraint="Phone" name="nbrPhone" cssClass="formInput" value="<%=FormattingHelper.formatPhone(populateBean.getNbrPhone())%>" size="10" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <%List principals = populateBean.getPrinciples();
      String numPrinciples = principals.size() + "";
      List personNameList = new ArrayList();
      for (int i = 0; i < principals.size(); i++) {
        FcePersonDB principal = (FcePersonDB) principals.get(i);
        personNameList.add(new Option(String.valueOf(principal.getNmPersonFull()), principal.getNmPersonFull()));
      }%>
    <tr>
      <td>
        <impact:validateSelect label="Policy Holder" name="cdPolicyHldr" options="<%=personNameList%>" blankValue="true" tabIndex="<%=tabIndex++%>" value="<%=populateBean.getCdPolicyHldr()%>" style="WIDTH: 180px" />
      </td>
      <td>
        <impact:validateDate name="dtBegin" disabled="false" label="Begin Date" required="false" value="<%= populateBean.getDtBeginString() %>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateDate name="dtEnd" disabled="false" label="End Date" required="false" value="<%= populateBean.getDtEndString() %>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" colspan="2" label="Employer's Name" name="nmEmployer" cssClass="formInput" value="<%= populateBean.getNmEmployer() %>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:validateInput colspan="2" type="text" label="Employee's Name" name="nmEmployeeNm" cssClass="formInput" value="<%= populateBean.getNmEmployeeNm() %>" size="30" maxLength="50" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="6">
        Principals Covered by Health Insurance Policy
      </th>
    </tr>
    <tr>
      <td colspan="6">
        <div id="scrollBar" style="height:155;width:100%;overflow:auto" class="tableborderList">
          <table width="100%" cellspacing="0" cellpadding="3" border="0">
            <tr>
              <th class="thList">
                Name
              </th>
              <th class="thList">
                Relationship
              </th>
              <th class="thList">
                Date of Birth
              </th>
            </tr>
            <%principals = populateBean.getPrinciples();
      if (principals == null || principals.size() == 0) {
%>
            <tr class="odd">
              <td colspan="3">
                <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
              </td>
            </tr>
            <%} else {

        for (int i = 0; i < principals.size(); i++) {
          String thirdPartyHealthCbxName = "cbThirdPartyHealthIns_" + i;
          String hiddenPersonIdName = "principalPersonId_" + i;
          String hiddenFcePersonIdName = "principalFcePersonId_" + i;
          String hiddenTsLastUpdateName = "principalLastUpdate_" + i;
          String relationName = "cdRelInt_" + i;
          String hiddenRelationName = "hdnRelInt_" + i;
          FcePersonDB principal = (FcePersonDB) principals.get(i);
          String relationDecode = Lookup.simpleDecodeSafe("CRELVICT", principal.getCdRelInt());
          if ("".equals(relationDecode)) {
            relationDecode = Lookup.simpleDecodeSafe("CRELPRN2", principal.getCdRelInt());
          }

          %>
            <tr class="<%=FormattingHelper.getRowCss( i + 1 )%>" valign="top">
              <impact:validateInput type="hidden" name="<%=hiddenPersonIdName%>" value="<%=principal.getIdPersonString()%>" />
              <impact:validateInput type="hidden" name="<%=hiddenFcePersonIdName%>" value="<%=principal.getIdFcePersonString()%>" />
              <impact:validateInput type="hidden" name="<%=hiddenTsLastUpdateName%>" value="<%=String.valueOf(principal.getDtLastUpdateTime())%>" />
              <impact:validateInput type="hidden" name="<%=hiddenRelationName%>" value="<%=principal.getCdRelInt()%>" />
              <td>
                <impact:validateInput type="checkbox" checked="<%= principal.getIndThirdPartyInsuranceString()%>" tabIndex="<%= tabIndex++ %>" id="<%= thirdPartyHealthCbxName %>" name="<%= thirdPartyHealthCbxName %>" value="<%= String.valueOf( i ) %>" />
                &nbsp;
                <%=principal.getNmPersonFull()%>
              </td>
              <td>
                <impact:validateDisplayOnlyField name="<%=relationName%>" value="<%= relationDecode %>" />
              </td>
              <td>
                <%=principal.getDtBirthString()%>
              </td>
            </tr>
            <%} // end while
      }
%>
          </table>
        </div>
      </td>
    </tr>
    <tr>
      <td colspan="6">
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
          <tr>
            <th colspan="6">
              Authorization
            </th>
          </tr>

          <tr>
            <td colspan="2">
              <impact:validateInput type="checkbox" id="indAuthRelease" tabIndex="<%= tabIndex++ %>" name="indAuthRelease" value="true"
                label="I authorize the release of information necessary to recover health insurance benefits to the Department of Community Health. I also certify that the above information is correct."
                checked='<%= "" + ArchitectureConstants.TRUE.equals(populateBean.getIndAuthReleaseString()) %>' />

            </td>
          </tr>
          <tr>
            <td width=20%>
              <impact:validateDate name="dtAuthReleaseDate" disabled="false" label="Date of Authorization" conditionallyRequired="true" value="<%=populateBean.getDtAuthReleaseDateString()%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>

          <tr>

            <td colspan="2">
              <impact:validateInput type="checkbox" id="indAuthAssign" tabIndex="<%= tabIndex++ %>" name="indAuthAssign" value="true" label="I authorize and assign payment of medical benefits to the Department of Community Health."
                checked='<%= "" + ArchitectureConstants.TRUE.equals(populateBean.getIndAuthAssignString()) %>' />

            </td>
          </tr>
          <tr>
            <td width=20%>
              <impact:validateDate name="dtAuthAssignDate" disabled="false" label="Date of Authorization" conditionallyRequired="true" value="<%=populateBean.getDtAuthAssignDateString()%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <%String displayStyle = "";
      if ("A".equals(populateBean.getCdApplication())) {
        displayStyle = "display:none";
      } else {
        displayStyle = "display:block";
      }

      %>
      <td colspan="6">
        <div id="showDateOfChangeSource" style="<%=displayStyle%>">
          <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
            <tr>
              <th colspan="4">
                Date of Health Insurance Change/Cancellation
              </th>
            </tr>
            <tr>
              <td>
                <impact:validateInput type="radio" id="indChange" tabIndex="<%= tabIndex++ %>" name="indChangeCancel" value="true" label="Change" checked='<%= "" + ArchitectureConstants.TRUE.equals(populateBean.getIndChangeCancelString()) %>' />
                <impact:validateInput type="radio" id="indCancel" tabIndex="<%= tabIndex++ %>" name="indChangeCancel" value="false" label="Cancellation" checked='<%= "" + ArchitectureConstants.TRUE.equals(populateBean.getIndChangeCancelString()) %>' />
              </td>
            </tr>
            <tr>
              <td width=30%>
                <impact:validateDate name="dtChangeCancel" disabled="false" label="Effective Date of Change/Cancellation" value="<%=populateBean.getDtChangeCancelString()%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
              </td>
              <td colspan="2">
                &nbsp;
              </td>
            </tr>
          </table>
        </div>
      </td>
    </tr>
    <tr>
      <td>
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
          <tr>
            <th colspan="4">
              Case Manager Information
            </th>
          </tr>
          <tr>
            <td width="20%">
              <impact:validateDisplayOnlyField name="nmEmployeePersonFull" label="Case Manager's Name" width="30%" value="<%=populateBean.getNmEmployeePersonFull()%>" />
            </td>
            <td width="20%">
              <impact:validateDisplayOnlyField name="nbrEmployeePersonPhone" label="Case Manager's Phone" width="30%" value="<%= FormattingHelper.formatPhone(populateBean.getNbrEmployeePersonPhone())%>" />
            </td>
          </tr>
          <tr>
            <td>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td colspan="6">
        <table cellpadding="3" cellspacing="0" width="100%">
          <tr>
            <td>
              <impact:ButtonTag name="btnSave" img="btnSave" form="frmThirdPartyHealthInsurance" action="/fce/ThirdPartyHealthInsurance/saveThirdPartyHealthInsurance" align="right" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <impact:validateInput type="hidden" name="numberOfPrinciples" value="<%= numPrinciples %>" />
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
  <% if (noChecked == true) {%>
     <script language="javascript">
       disablePage();
     </script>
  <%   } %>
</impact:validateForm>
