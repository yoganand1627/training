<%
/**
 * JSP Name:     JobDescriptionDetail.jsp
 * Created by:   Ade Odutayo
 * Date Created: 07/19/06
 *
 * Description:
 * Allows the user to view and update the ERS number,job title, and case assignable status 
 * for a staff member. The user returns the Staff Detail page after clicking the Save button.
 * This page can only be viewed in MODIFY mode from the StaffDetail.jsp page.
 *
**/
/*
  Change History:
  Date      User                Description
  --------  ----------------    -----------------------------------------------
  7/19/06   aodutayo    Changed the title; working on the connections to the database
  10/05/06  aodutayo    Updated page to ensure that only users with maintain staff
          security attribue can view the page. Fixes SIR 469.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String pageMode = PageMode.getPageMode(request);
  UserProfile user = UserProfileHelper.getUserProfile( request );
  
  // JobDescriptionDetail page can only be viewed in MODIFY mode if and only if user has maintain staff
  // security attribute
  String jobDescriptionDisabled = "true";
  if( user.hasRight( UserProfile.SEC_MNTN_STAFF_GEN ) )
    jobDescriptionDisabled = "false";

  int tabIndex = 1;
  int personId = GlobalData.getUlIdPerson(request);

  ROWCCMN04SOG02 jobDescription;
  if (state.getAttribute("ROWCCMN04SOG02", request) != null &&
      !pageMode.equals(PageModeConstants.NEW)) {
    jobDescription = (ROWCCMN04SOG02) state.getAttribute("ROWCCMN04SOG02", request);
  } else {
    jobDescription = new ROWCCMN04SOG02();
  }

  String ers = jobDescription.getSzBjnJob();
  //String jobTitle = jobDescription.getSzCdJobClass();
  String jobTitle = jobDescription.getSzCdJobTitle();
  String supervisor = "";
  String jobFunction = "";
  int jobDescriptionId = 0;
  int supervisorId = 0;
  java.util.Date lastUpdate = null;
  String caseAssignable = "";

  if (pageMode.equals(PageModeConstants.NEW)) {
    supervisor = (String) request.getAttribute("supervisorName");
    supervisorId = Integer.parseInt((String) request.getAttribute("supervisorId"));
    jobFunction = "";
  } else {
    supervisor = jobDescription.getSzNmPersonFull();
    supervisorId = jobDescription.getUlIdJobPersSupv();
    jobFunction = jobDescription.getSzCdJobFunction();
    jobDescriptionId = jobDescription.getUlIdEmpJobHistory();
  }

  if (jobDescription.getBIndJobAssignable() == null) {
    caseAssignable = "N";
  } else {
    caseAssignable = jobDescription.getBIndJobAssignable();
  }

  String lastUpdateString = "";

  if (lastUpdate == null) {
    lastUpdateString = "";
  } else {
    lastUpdateString = String.valueOf(lastUpdate);
  }
%>

<impact:validateForm name="frmJobDescription"
   defaultButton="true"
   method="post"
   action="/admin/StaffSearch/saveJobDescriptionDetail"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
<impact:validateErrors formName="frmJobDescription"/>
<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= lastUpdateString %>" />
<impact:validateInput type="hidden" name="hdnDisplayType" value="Modify" />
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%= String.valueOf( personId )%>" />
<impact:validateInput type="hidden" name="hdnUlIdJobPersSupv" value="<%= String.valueOf( supervisorId ) %>" />
<impact:validateInput type="hidden" name="hdnSzCdJobFunction" value="<%= String.valueOf( jobFunction ) %>" />
<impact:validateInput type="hidden" name="hdnUlIdEmpJobHistory" value="<%= String.valueOf( jobDescriptionId ) %>" />


<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="6">Job Description</th>
  </tr>
  <tr>
  <td><impact:validateInput type="text" 
                            label="ERS" 
                            constraint="AlphaNumeric8" 
                            required="true" 
                            name="txtSzTextERS"  
                            cssClass="formInput"
                            disabled="<%= jobDescriptionDisabled %>" 
                            value="<%= ers %>" 
                            size="15" 
                            maxLength="8" 
                            tabIndex="<%= tabIndex++ %>"/></td>

  <td><impact:validateSelect label="Title" 
                            orderBy="decode" 
                            required="true" 
                            name="cboSzCdJobTitle" 
                            codesTable="CEMPJBCL"  
                            disabled="<%= jobDescriptionDisabled %>" 
                            value="<%= jobTitle %>" 
                            tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField name="txtSzNmPersonFull" 
                            colspan="3" 
                            label="Supervisor" 
                            value="<%= supervisor %>"/></td>

  <td><impact:validateInput value="<%= caseAssignable %>" 
                            type="checkbox" 
                            checked="<%= caseAssignable %>"  
                            name="cbxbIndCaseAssignable" 
                            label="Case Assignable" 
                            cssClass="formInput"
                            tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
</table>
<%  // Save Button
if( jobDescriptionDisabled.equals("false") )
{
%>
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td class="alignRight">
        <impact:ButtonTag name="btnSave"
            img="btnSave"
            align="right"
            form="frmJobDescription"
            action="/admin/StaffSearch/saveJobDescriptionDetail"
            tabIndex="<%= tabIndex++ %>"/>
      </td>
    </tr>
  </table>
<%
}
%>
</impact:validateForm>
