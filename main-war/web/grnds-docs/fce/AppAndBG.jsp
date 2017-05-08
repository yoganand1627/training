<%//*  JSP Name:     AppAndBG.jsp
      //*  Created by:   Jonathan Hardy
      //*  Date Created: 3/11/03
      //*
      //*  Description:
      //*  This page allows a user to enter a Foster Care Application or Reapplication
      //*  which includes Child Information, Address of the Home of Removal, List of
      //*  Principals, Responsibility for Child Care, Health Insurance, and Most
      //*  Recent Placements.
      //*
      /* Change History:
       Date      User              Description
       --------  ----------------  --------------------------------------------------
       08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
       11/29/10  Hai Nguyen        SMS#81144: MR-053 Moved case manager info section from
                                   income and expenditures page to this page.  Added page logic
                                   for amended application type. Removed LC column from List 
                                   of Principals.
       01/07/11  Hai Nguyen        SMS#81144: Modified page to force user to choose application type
                                   if event is NEW and if it is an Amended or NOC.  Consequently, 
                                   data will be prefilled accordingly.
       02/04/11  Hai Nguyen        SMS#95235: Disable Amended Application radio if not MES worker,
                                   which prevents case managers from creating an Amended app.
       */

      %>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.fce.PlacementDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fce.ApplicationAndBackgroundConversation"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>

<%String pageMode = PageMode.getPageMode(request);
      int tabIndex = 1;

      ApplicationBackgroundDB populateBean = (ApplicationBackgroundDB) request.getAttribute("AppAndBGDB");
      if (populateBean == null) {
        populateBean = new ApplicationBackgroundDB();
      }
      UserProfile user = UserProfileHelper.getUserProfile(request);
      String eventStatus = populateBean.getCdEventStatus();

      boolean certGroupVisible = EventHelper.PENDING_EVENT.equals(eventStatus)
                                 || EventHelper.COMPLETE_EVENT.equals(eventStatus)
                                 || EventHelper.APPROVED_EVENT.equals(eventStatus);

      boolean certGroupEditable = ((PageModeConstants.EDIT.equals(pageMode)) && ((EventHelper.PENDING_EVENT
                                                                                                           .equals(eventStatus)) || (EventHelper.COMPLETE_EVENT
                                                                                                                                                               .equals(eventStatus))));

      String remZip = populateBean.getAddrRemovalAddrZip();
      String remZipSuff = "";
      if (remZip.length() > 5) {
        remZipSuff = remZip.substring(6);
        remZip = remZip.substring(0, 5);
      }

      String healthZip = populateBean.getAddrHealthAddrZip();
      String healthZipSuff = "";
      if (healthZip.length() > 5) {
        healthZipSuff = healthZip.substring(6);
        healthZip = healthZip.substring(0, 5);
      }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};


function submitPersonDetail( idPerson )
{
    setIsDirtyCalled( true );
    document.frmAppAndBG.hdnPersonDetailId.value = idPerson;
    submitValidateForm( "frmAppAndBG", "/fce/ApplicationAndBackground/forwardPersonDetail" );
}


function forwardPlacementLog()
{
  setIsDirtyCalled( true );
  submitValidateForm('frmAppAndBG', '/fce/ApplicationAndBackground/forwardPlacementLog');
}

<%
    // MR-053
    // the following code is to determine if this is a new application or saved application
    // if new application then it does not display app type selection and forces user to select one to prefill data
    // if saved application then check to see if and changes to app type was made, if so prefill accordingly
    // Keep in mind that any existing data will be replaced with prefilled data, hence the confirmation
    String cdApp = populateBean.getCdApplication();
    String prefilled = (String)request.getAttribute("prefilled");
    if((EventHelper.NEW_EVENT.equals(eventStatus) && "true".equals(prefilled))
        || !EventHelper.NEW_EVENT.equals(eventStatus) ){
        cdApp = populateBean.getCdApplication();
    }else{
        cdApp = StringHelper.EMPTY_STRING;
    }
%>
function doDataPrefill()
{
  var originalAppType = "<%= cdApp %>";
  
  var currentSelection = document.getElementsByName("cdApplication");
  for( var i = 0; i < currentSelection.length; i++)
  {
    if(currentSelection[i].checked )
    {
      currentSelection = currentSelection[i].value;
    }
  }
  
  // If same code when first displayed then do nothing
  if (currentSelection == originalAppType){
   return false;
  } else {
    // Need to confirm with user that all data will be replaced
    if ( confirm("Changing application type will replace all current information entered, do you wish to continue?") ){
      setIsDirtyCalled( true );
      document.frmAppAndBG.doPrefill.value = "true";
      disableValidation("frmAppAndBG");
      submitValidateForm( "frmAppAndBG", "/fce/ApplicationAndBackground/displayAppAndBG" );
    }else{
      // user cancelled app type change, so set app type back to previous
      document.frmAppAndBG.doPrefill.value = "false";
      
      var oRadio = document.getElementsByName("cdApplication");
      for( var i = 0; i < oRadio.length; i++)
      {
        if(oRadio[i].value == originalAppType)
        {
          // set it back to original value
          oRadio[i].checked = true;
        }else{
          // clear if not a match to original, there may not be a select for NEW event
          oRadio[i].checked = false;
        }
      }
    }
  }
}

function updateAmendedIndicator()
{
    document.frmAppAndBG.indAmendedApp.value = 'true';
}
</script>

<impact:validateErrors />

<impact:validateForm name="frmAppAndBG" method="post" action="/fce/ApplicationAndBackground/displayAppAndBG" validationClass="gov.georgia.dhr.dfcs.sacwis.web.fce.ApplicationAndBackgroundCustomValidation" pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">

  <impact:validateInput type="hidden" name="idLastUpdatePerson" value="<%=populateBean.getIdLastUpdatePersonString()%>" />
  <impact:validateInput type="hidden" name="idEvent" value="<%=populateBean.getIdEventString()%>" />
  <impact:validateInput type="hidden" name="idFceApplication" value="<%=populateBean.getIdFceApplicationString()%>" />
  <impact:validateInput type="hidden" name="idFceEligibility" value="<%=populateBean.getIdFceEligibilityString()%>" />
  <impact:validateInput type="hidden" name="idPerson" value="<%=populateBean.getIdPersonString()%>" />
  <impact:validateInput type="hidden" name="idStage" value="<%=populateBean.getIdStageString()%>" />
  <impact:validateInput type="hidden" name="fceApplicationDtLastUpdate" value="<%=String.valueOf(populateBean.getFceApplicationDtLastUpdate())%>" />
  <impact:validateInput type="hidden" name="fceApplicationDtLastUpdateTime" value="<%=String.valueOf(populateBean.getFceApplicationDtLastUpdateTime())%>" />
  <impact:validateInput type="hidden" name="idLastUpdatePerson" value='<%= "" + BasePrsConversation.getUserID(request) %>' />
  <impact:validateInput type="hidden" name="hdnPersonDetailId" value="<%=populateBean.getIdPersonString()%>" />
  <impact:validateInput type="hidden" name="doPrefill" value="" />
  <impact:validateInput type="hidden" name="indAmendedApp" value="<%=populateBean.getIndAmendedAppString()%>" />

  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td align="right">
        <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp; <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
      </td>
    </tr>


  </table>

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan=10>
        Status
      </th>
    </tr>
    <tr>
      <td colspan="2">
        <impact:validateInput 
          type="radio" 
          required="true" 
          checked="<%= String.valueOf( ApplicationAndBackgroundConversation.APPLICATION_TYPE.equals(populateBean.getCdApplication()) ) %>" 
          tabIndex="<%= tabIndex++ %>"
          value="<%=ApplicationAndBackgroundConversation.APPLICATION_TYPE%>" 
          name="cdApplication" 
          label="<%= (populateBean.getIndAmendedApp() ? "Amended Application" : "Initial Application")%>" 
          cssClass="formInput" 
          onClick="<%= (populateBean.getIndAmendedApp() ? "doDataPrefill();" : "")  %>"
          disabled="<%=String.valueOf(!user.hasRight(UserProfile.SEC_REG_FAM_INDP_STF) 
                                      && !user.hasRight(UserProfile.SEC_REG_FAM_INDP_MGMNT_STF) 
                                      && populateBean.getIndAmendedApp()) %>"
        />
      </td>
      <td>
        <impact:validateInput 
          type="radio" 
          checked="<%= String.valueOf( ApplicationAndBackgroundConversation.REAPPLICATION_TYPE.equals(populateBean.getCdApplication()) ) %>" 
          tabIndex="<%= tabIndex++ %>"
          value="<%=ApplicationAndBackgroundConversation.REAPPLICATION_TYPE%>" 
          name="cdApplication" 
          label="Notification of Change" 
          cssClass="formInput" 
          onClick="updateAmendedIndicator(); doDataPrefill();" 
          disabled="<%=String.valueOf(!populateBean.getIndAmendedApp()) %>"
        />
      </td>
    </tr>
    <tr>
        <th colspan="10">
            Case Manager Information
        </th>
    </tr>
    <tr>
        <td>
            <impact:validateDisplayOnlyField name="<%=ApplicationBackgroundDB.NM_EMPLOYEE_PERSON_FULL%>" label="Case Manager's Name" value="<%=populateBean.getNmEmployeePersonFull()%>" />
        </td>
        <td>
            <impact:validateDisplayOnlyField name="<%=ApplicationBackgroundDB.NBR_EMPLOYEE_PERSON_PHONE%>" label="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Case Manager's Phone" value="<%=FormattingHelper.formatPhone(populateBean.getNbrEmployeePersonPhone())%>" />
        </td>
    </tr>
    <tr>
        <td>
            <impact:validateTextArea name="<%=ApplicationBackgroundDB.TXT_EMPLOYEE_COMMENTS%>" cols="90" rows="4" label="Comments" colspan="8" tabIndex="<%=tabIndex++%>" constraint="Comments" maxLength="300" conditionallyRequired="true">
                <%=populateBean.getTxtEmployeeComments()%>
            </impact:validateTextArea>
        </td>
    </tr>
    <tr>
      <th colspan=10>
        Child Information
      </th>
    </tr>
    <tr>
      <td>
        <impact:validateDisplayOnlyField name="ChildName" colspan="2" label="Child's Name" value="<%=populateBean.getNmPersonFull()%>" />
      </td>
      <td>
        <impact:validateDisplayOnlyField name="dtBirth" label="Date of Birth" value="<%= populateBean.getDtBirthString()%>" />
      </td>
    </tr>
    <tr>
      <td>

        <impact:validateDisplayOnlyField name="nbrSocialSecurity" colspan="2" label="Social Security Number" value="<%=populateBean.getNbrSocialSecurity()%>" />

      </td>
      <td>
        <impact:validateDisplayOnlyField name="nbrCrsId" label="CRS ID" value="<%=populateBean.getNbrCrsId()%>" />

      </td>
    </tr>
    <tr>
      <td>

        <impact:validateDisplayOnlyField name="mhnNumber" colspan="2" label="MHN Number" value="<%=populateBean.getNbrMhn()%>" />

      </td>
      <td>
        <impact:validateDisplayOnlyField name="medicaidAppMonth" label="Medicaid Application Month" value="<%=populateBean.getMedAppMonth()%>" />
      </td>
    </tr>
        <tr>
      <td>
        <impact:validateDisplayOnlyField name="idPerson" colspan="2" label="Person ID" value="<%=String.valueOf(populateBean.getIdPerson())%>" />
      </td>
      <%String detailButtonFunction = "document.frmAppAndBG.hdnPersonDetailId.value='" + populateBean.getIdPersonString()
                                    + "'";
      String bDisableDetail = EventHelper.APPROVED_EVENT.equals(eventStatus) ? "true" : "false";

      %>
      <td>
        &nbsp;
      </td>
      <td>
        <impact:ButtonTag name="btnChildDetail" img="btnDetail" align="right" form="frmAppAndBG" action="/fce/ApplicationAndBackground/forwardPersonDetail" function="<%=detailButtonFunction%>" editableMode="<%=EditableMode.ALL%>" tabIndex="<%= tabIndex++ %>"
          disabled="<%= bDisableDetail %>" />
      </td>
    </tr>
    <tr>
      <th colspan=10>
        Address of Home of Removal
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" disabled="true" label="Street" colspan="8" constraint="Address" name="addrRemovalStLn1" cssClass="formInput" value="<%=populateBean.getAddrRemovalStLn1()%>" size="30" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr>
      <td>
        &nbsp;
      </td>
      <td>
        <impact:validateInput type="text" disabled="true" label="" colspan="8" constraint="Address" name="addrRemovalStLn2" cssClass="formInput" value="<%=populateBean.getAddrRemovalStLn2()%>" size="30" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        &nbsp;
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateInput type="text" disabled="true" label="City" constraint="City" name="addrRemovalCity" cssClass="formInput" value="<%=populateBean.getAddrRemovalCity()%>" size="20" maxLength="" tabIndex="<%= tabIndex++ %>" />
      </td>
      <%  // default the state to Georgia, override default if the state is set
          String stateDefault = CodesTables.CSTATE_GA;
          if ( StringHelper.isValid( populateBean.getCdRemovalAddrState()) )
          {
            stateDefault = populateBean.getCdRemovalAddrState();
          }
      %>
      <td>
        <impact:validateSelect disabled="true" label="State" name="cdRemovalAddrState" tabIndex="<%= tabIndex++ %>" codesTable="CSTATE" value="<%=FormattingHelper.formatString( stateDefault )%>" blankValue="true" />
      </td>
    </tr>
    <tr>
      <td>
        <impact:validateSelect disabled="true" label="County" name="cdRemovalAddrCounty" tabIndex="<%= tabIndex++ %>" codesTable="CCOUNT" value="<%=populateBean.getCdRemovalAddrCounty()%>" blankValue="true" />
      <td>
        <impact:validateInput disabled="true" type="text" label="Zip" constraint="Zip" name="addrRemovalAddrZip" cssClass="formInput" value="<%=remZip%>" size="5" maxLength="5" tabIndex="<%= tabIndex++ %>" />
        -
        <impact:validateInput disabled="true" type="text" constraint="ZipSuff" name="addrRemovalAddrZipSuff" cssClass="formInput" value="<%=remZipSuff%>" size="4" maxLength="4" tabIndex="<%= tabIndex++ %>" />
      </td>
      <td>
        <impact:ButtonTag name="btnChildDetail" img="btnDetail" align="right" form="frmAppAndBG" action="/fce/ApplicationAndBackground/forwardPersonDetail" function="<%=detailButtonFunction%>" editableMode="<%=EditableMode.ALL%>" tabIndex="<%= tabIndex++ %>"
          disabled="<%= bDisableDetail %>" />
      </td>
    </tr>
  </table>
  <br>
  <%/*  Begin Expandable Section with List Table */

      %>
  <impact:ExpandableSectionTag anchor="test" name="PrincipalsList" id="PrincipalsList" label="List of Principals" tabIndex="<%= tabIndex++ %>">
    <div id="scrollBar" style="height:250;width:100%;overflow:auto" class="tableborderList">
      <table width="100%" cellspacing="0" cellpadding="3" border="0">
        <tr>
          <th class="thList">
            Living In Home
            <br>
            of Removal
          </th>
          <th class="thList">
            Name
          </th>
          <th class="thList">
            Relationship
          </th>
          <th class="thList">
            Date of Birth
          </th>
          <th class="thList">
            Current Address
          </th>
          <%if (certGroupVisible) {

      %>
          <th class="thList">
            Member of
            <br>
            Assistance Unit
          </th>
          <%}

      %>
        </tr>
        <%List principals = populateBean.getPrinciples();
      if (principals == null || principals.size() == 0) {
%>
        <tr class="odd">
          <td colspan="7">
            <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
          </td>
        </tr>
        <%} else {

        for (int i = 0; i < principals.size(); i++) {
          String livingCbxName = "cbLivingInHome_" + i;
          String certCbxName = "cbMemCertGrp_" + i;
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
          String checkedString = principal.getIndCertifiedGroupString();

          %>
        <tr class="<%=FormattingHelper.getRowCss( i + 1 )%>" valign="top">
          <impact:validateInput type="hidden" name="<%=hiddenPersonIdName%>" value="<%=principal.getIdPersonString()%>" />
          <impact:validateInput type="hidden" name="<%=hiddenFcePersonIdName%>" value="<%=principal.getIdFcePersonString()%>" />
          <impact:validateInput type="hidden" name="<%=hiddenTsLastUpdateName%>" value="<%=String.valueOf(principal.getDtLastUpdateTime())%>" />
          <impact:validateInput type="hidden" name="<%=hiddenRelationName%>" value="<%=principal.getCdRelInt()%>" />
          <td>
            <impact:validateInput type="checkbox" checked="<%= principal.getIndPersonHmRemovalString()%>" tabIndex="<%= tabIndex++ %>" name="<%= livingCbxName %>" value="<%= String.valueOf( i ) %>" />
          </td>
          <td>
            <a href="javascript: submitPersonDetail( '<%= principal.getIdPersonString() %>')" tabIndex="<%= tabIndex++ %>" onclick="setIsDirtyCalled(true)"><%=principal.getNmPersonFull()%></a>
          </td>
          <td>
            <impact:validateDisplayOnlyField name="<%=relationName%>" value="<%= relationDecode %>" />
          </td>
          <td>
            <%=principal.getDtBirthString()%>
          </td>
          <td>
            <%=principal.getAddrPersonStLn1()%>
            <br>
            <%=principal.getAddrPersonCity()%>
            ,
            <%=principal.getCdPersonState()%>&nbsp;
            <%=principal.getAddrPersonZip()%>
          </td>
          <%if (certGroupEditable) {

            %>
          <td>
            <impact:validateInput type="checkbox" checked="<%= checkedString %>" tabIndex="<%= tabIndex++ %>" name="<%= certCbxName %>" value="<%= String.valueOf( i ) %>" />
          </td>
          <%} else if (certGroupVisible) {
            if (StringHelper.isTrue(checkedString)) {

            %>
          <td align="center" valign="center">
            <img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif">
          </td>
          <%} else {

            %>
          <td>
            &nbsp;
          </td>
          <%}
          }

        %>
        </tr>
        <%} // end while
      }

      %>
      </table>
    </div>
    <%/* this is where the "scrollBar" div tag ends */

      %>
    <table cellpadding="3" cellspacing="0" width="100%">
      <tr>
        <td colspan="4" class="tableBG">
          <impact:ButtonTag name="btnAdd1" img="btnAdd" form="frmAppAndBG" action="/fce/ApplicationAndBackground/forwardPersonSearch" align="right" tabIndex="<%= tabIndex++ %>" />
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>
  <%/* this is where the "xpandListTable" div tag ends end ESLT */

      %>
  <br>
  <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan=6>
        Care and Custody Information
      </th>
    </tr>
    <tr>
      <td width="15%">
        <%
        boolean yesChecked = false;
      boolean noChecked = false;
      Boolean indMinorParent = populateBean.getIndMinorParentObject();
      
      if (indMinorParent != null) {
        yesChecked = populateBean.getIndMinorParent();
        noChecked = !populateBean.getIndMinorParent();
      }

      %>
        <impact:validateInput type="radio" id="rbLiveWithMinorParentYes" tabIndex="<%= tabIndex++ %>" name="indMinorParent" value="true" label="Yes" checked="<%=String.valueOf( yesChecked )%>" />
        <impact:validateInput type="radio" id="rbLiveWithMinorParentNo" tabIndex="<%= tabIndex++ %>" name="indMinorParent" value="false" label="No" checked="<%=String.valueOf( noChecked )%>" />
      </td>
      <td colspan="5">
        <%/* SIR 22492 PRS --> FPS */

      %>
        Does the child live with a minor parent who is in DFCS custody? If yes, forward a copy of the most recent court order documenting the minor parent's custody status.
      </td>
    </tr>
    <tr class="even">
      <td width="15%">
        <%Boolean indHospital = populateBean.getIndHospitalObject();
      if (indHospital == null) {
        yesChecked = false;
        noChecked = false;
      } else {
        yesChecked = populateBean.getIndHospital();
        noChecked = !populateBean.getIndHospital();
      }

      %>
        <impact:validateInput type="radio" id="rbChildInHospitalYes" tabIndex="<%= tabIndex++ %>" name="indHospital" value="true" label="Yes" checked="<%=String.valueOf( yesChecked )%>" />
        <impact:validateInput type="radio" id="rbChildInHospitalNo" tabIndex="<%= tabIndex++ %>" name="indHospital" value="false" label="No" checked="<%=String.valueOf( noChecked )%>" />
      </td>
      <td colspan="5">
        Was the child in a hospital when DFCS obtained custody?
      </td>
    </tr>
    <tr class="even">
      <td colspan="6">
        <table width="100%" cellpadding="0" cellspacing="0" border="0">
          <tr>
            <td width="15%">
              &nbsp;
            </td>
            <td>
              <impact:validateDate name="dtHospitalAdmissionString" disabled="false" label="Admission Date" conditionallyRequired="true" value="<%=populateBean.getDtHospitalAdmissionString()%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
            </td>
            <td>
              <impact:validateDate name="dtHospitalDischargeString" disabled="false" label="Discharge Date" required="false" value="<%=populateBean.getDtHospitalDischargeString()%>" size="10" constraint="Date" tabIndex="<%= tabIndex++ %>" />
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td width="15%">
        <%Boolean indManagCvs = populateBean.getIndManagingCvsObject();
      if (indManagCvs == null) {
        yesChecked = false;
        noChecked = false;
      } else {
        yesChecked = populateBean.getIndManagingCvs();
        noChecked = !populateBean.getIndManagingCvs();
      }

      %>
        <impact:validateInput type="radio" id="rbIndManagingCvsYes" tabIndex="<%= tabIndex++ %>" name="indManagingCvs" value="true" label="Yes" checked="<%= String.valueOf( yesChecked ) %>" />
        <impact:validateInput type="radio" id="rbIndManagingCvsNo" tabIndex="<%= tabIndex++ %>" name="indManagingCvs" value="false" label="No" checked="<%= String.valueOf( noChecked ) %>" />
      </td>
      <td colspan="3">
        Was medical assistance needed for the child within the 3 months prior to removal?
      </td>
    </tr>
    <td>
        <impact:validateInput type="text" label="Months" constraint="Paragraph80" conditionallyRequired="true" colspan="8" name="txtPriorRemovalMonths" cssClass="formInput"  value="<%=populateBean.getTxtPriorRemovalMonths()%>" size="50" maxLength="" tabIndex="<%= tabIndex++ %>" />

    </td>
      </table>
  <br />
  <%/*  Begin Expandable Section with List Table */

      %>
  <impact:ExpandableSectionTag anchor="test" name="Placements" id="Placements" label="Placements" tabIndex="<%= tabIndex++ %>">


    <div id="scrollBar" style="height:80;width:100%;overflow:auto" class="tableborderList">
      <table width="100%" cellspacing="0" cellpadding="3" border="0">
        <tr>
          <th class="thList">
            Date Entered
          </th>
          <th class="thList">
            Status
          </th>
          <th class="thList">
            Description
          </th>
          <th class="thList">
            Entered By
          </th>
        </tr>
        <%List placements = populateBean.getPlacements();
      if (placements == null || placements.size() == 0) {
%>
        <tr class="odd">
          <td colspan="7">
            <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
          </td>
        </tr>
        <%} else {
        for (int i = 0; i < placements.size(); i++) {
          PlacementDB placement = (PlacementDB) placements.get(i);
%>
        <tr class="<%=FormattingHelper.getRowCss( i + 1 )%>" valign="top">
          <td>
            <%=placement.getDtEventOccurredString()%>
          </td>
          <td>
            <%=placement.getCdEventStatus()%>
          </td>
          <td>
            <%=placement.getTxtDescription()%>
          </td>
          <td>
            <%=placement.getNmPersonFull()%>
          </td>
        </tr>
        <%} // end while
      }

      %>
      </table>
    </div>
    <%/* this is where the "scrollBar" div tag ends */

      %>
  </impact:ExpandableSectionTag>
  <%/* this is where the "xpandListTable" div tag ends end ESLT */

      %>
  <hr />

  <table cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td>
        <impact:ButtonTag name="btnSave" img="btnSave" form="frmAppAndBG" action="/fce/ApplicationAndBackground/saveAppAndBG" align="right" tabIndex="<%= tabIndex++ %>" />
      </td>
    </tr>
  </table>

  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>
<script type="text/javascript" language="JavaScript1.2">
expandCollapsed('expandedPrincipalsList', 'collapsedPrincipalsList');
</script>
