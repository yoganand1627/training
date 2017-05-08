<%
/**
 * JSP Name:     StaffDetail.jsp
 * Created by:   Jeff Chambers
 * Date Created: 10/15/02
 *
 * Description:
 * This page is used to view and maintain staff information.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  05/29/03  C Douglass        SIR 17614 - If the user doesn't have maintain
                              staff security, they shouldn't have a link on
                              start date to get to job history
  05/29/03  C Douglass        SIR 17835 - added expand all and collapse all
  06/25/03  C Douglass        remove Lead from dropdown - the only place to set
                              a lead is in unit maintenance to make sure that
                              there is always only 1 lead per unit & change to
                              only allow delete of current job history when row
                              is not confirmed by HR
  07/13/03  C Douglass        SIR 18841-corrected pendingHrmis and
                              confirmedHrmis flags
  07/21/03  C Douglass        SIR 19016 - allow users in browse mode to access
                              job history page in browse mode.
  08/01/03  Todd Reser        Modified Change Log and Flowerbox comments.
  10/02/03  C Douglass        SIR 19930 - Trying to access job history for
                              for terminated employees gives error.  Can't access
                              job history for terminated employees in CAPS, so
                              remove hyperlink.
  11/05/03  Todd Reser        SIR 22345 - Had to switch from == to .equals() so
                              the if statement would correctly compare pageMode
                              to PageMode.Edit
  3/26/04   C Douglass        SIR 22542 - added logic to make FTE% required in
                              NEW mode.
  4/7/2004  gerryc            SIR 22808 - added hidden field for the termination date
                              coming from the database.  It is compared to the term
                              date entered in the custom validation.
  3/1/2005  C Douglass        SIR 23024 - remove the ability to delete an employee
  2/27/2008 cjgerry			  STGAP00005269 - allow hire date to be modified by someone with maintain staff security
  5/8/2008  arege             STGAP00005045 - Prevent the user from clicking on the Save button multiple times. This prevents 
                              Staff(people)being created multiple times as a result of clicking save button multiple times.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%-- Import Java classes --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PhoneSubmoduleConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.RaceEthnicitySubDB" %>
<%-- Import xmlstructs --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06" %>
<%-- Import architecture classes --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag" %>
<%-- Import State Management classes --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%-- Import PageMode and other utilities --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%-- Import needed for Messages --%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>

<%
  //Set the page mode
  String pageMode = PageMode.getPageMode(request);

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile user = UserProfileHelper.getUserProfile( request );

  String personId = request.getParameter("hdnUlIdPerson");
  String displayType = request.getParameter("hdnDisplayType");

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript"  language="JavaScript1.2">

  /*
  *This function is called before the page unloads. It creates the
  *"Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  }

  function changeDisplayType()
  {
    frmStaffDetail.hdnDisplayType.value = "Saved";
  }

  function deleteJobHistory()
  {
    return confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CMN_DELETE_JOB) %>');
  }

</script>

<%

  CCMN04SO ccmn04so = new CCMN04SO();

  if (!PageModeConstants.NEW.equalsIgnoreCase( pageMode ))
  {
    // Get the CCMN04SO output object out of the request
    ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);

  }

  // Initialize the row and array objects
  ROWCCMN04SOG00 row00 = null;
  ROWCCMN04SOG01 row01 = null;
  ROWCCMN04SOG04 row04 = null;
  ROWCCMN04SOG05 row05 = null;
  ROWCCMN04SOG06 row06 = null;

  ROWCCMN04SOG02 jobDescription = null;
  String cReqFuncCd = (String) request.getAttribute("hdnCReqFuncCd");
  //String office = "";

  // Null catch for ccmn04so, if null set to blank (initialize)
  if ( ccmn04so == null )
  {
    ccmn04so = new CCMN04SO();
  }

  // Null catch for ROW objects, if not null get rows
  if ( ccmn04so.getROWCCMN04SOG00() != null )
  {
    row00 = ccmn04so.getROWCCMN04SOG00();
    //office = ccmn04so.getSzNmOfficeName();
  } else {
    row00 = new ROWCCMN04SOG00();
  }
  if ( ccmn04so.getROWCCMN04SOG01() != null )
  {
    row01 = ccmn04so.getROWCCMN04SOG01();
  } else {
    row01 = new ROWCCMN04SOG01();
  }
  if ( ccmn04so.getROWCCMN04SOG04() != null )
  {
    row04 = ccmn04so.getROWCCMN04SOG04();
  } else {
    row04 = new ROWCCMN04SOG04();
  }
  if ( ccmn04so.getROWCCMN04SOG05() != null )
  {
    row05 = ccmn04so.getROWCCMN04SOG05();
  } else {
    row05 = new ROWCCMN04SOG05();
  }
  if ( ccmn04so.getROWCCMN04SOG06() != null )
  {
    row06 = ccmn04so.getROWCCMN04SOG06();
  } else {
    row06 = new ROWCCMN04SOG06();
  }
  if ( ccmn04so.getROWCCMN04SOG02() != null )
  {
    jobDescription = ccmn04so.getROWCCMN04SOG02();
  } else {
    jobDescription = new ROWCCMN04SOG02();
  }


  String staffDetailDisabled = "false";
  String hireDateDisabled = "true";
  int tabIndex = 1;

  // If the user does not have the maintain staff security attribute
  // make the hire date field disabled 
  if (user.hasRight( UserProfile.SEC_MNTN_STAFF_GEN ) )
  {
    hireDateDisabled = "false";
  }
  else   
  {
  	//set the ssn number to blank - not used anymore
  	row05.setSzNbrPersonIdNumber("");
  }
  


  if ( ccmn04so.getROWCCMN04SOG00() != null )
  {
    hireDateDisabled = "false";

    
  }


//6/25/03 CSD - remove Lead from dropdown - the only place to set a lead is in unit maintenance
//to make sure that there is always only 1 lead per unit
//6/27/03 - also since the only place to set a lead is in unit maintenence, should not
//let the user change a lead to something else
  String roleCodeType = CodesTables.CUNMBRRL;
  String role = row04.getSzCdUnitMemberRole();
  boolean roleDisabled = CodesTables.CUNMBRRL_40.equals(role);
%>

<impact:validateForm name="frmStaffDetail"
   method="post"
   action="/admin/StaffSearch/displayStaffDetail"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.StaffDetailCustomValidation"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">

<impact:validateErrors formName="frmStaffDetail"/>

<!--- Begin Personal Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
     <td align="right">
         <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
         <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
     </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="6">Personal</th>
  </tr>
  <tr>
  <td><impact:validateInput type="text" label="First" constraint="Name12" required="true" name="txtSzNmNameFirst" disabled="<%= staffDetailDisabled %>" cssClass="formInput" value="<%= row01.getSzNmNameFirst() %>" size="15" maxLength="12" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:validateInput type="text" label="Middle" constraint="Name12" required="false" name="txtSzNmNameMiddle" disabled="<%= staffDetailDisabled %>" cssClass="formInput" value="<%= row01.getSzNmNameMiddle() %>" size="10" maxLength="12" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:validateInput type="text" label="Last" constraint="Name22" required="true" name="txtSzNmNameLast" disabled="<%= staffDetailDisabled %>" cssClass="formInput" value="<%= row01.getSzNmNameLast() %>" size="15" maxLength="22" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
  <td><impact:validateSelect label="Gender" required="true" name="cbocCdPersonSex" codesTable="CSEX" disabled="<%= staffDetailDisabled %>" value="<%= row06.getCCdPersonSex() %>" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
</table>

<!--- Begin Unit Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="4">Unit</th>
  </tr>
  <tr>
  <td><impact:validateSelect label="County" conditionallyRequired="true" name="cboSzCdCounty" codesTable="CCOUNT" disabled="<%= staffDetailDisabled %>" value="<%= ccmn04so.getSzCdCounty() %>" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:validateSelect label="Reg/Div" conditionallyRequired="true" name="cboSzCdUnitRegion" codesTable="CREGDIV" contentType="<%= SelectTag.CODES_DECODES %>" disabled="<%= staffDetailDisabled %>" value="<%= row04.getSzCdUnitRegion() %>" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
        <td><impact:validateInput label="Unit" type="text" constraint="AlphaNumeric" required="true" name="txtSzNbrUnit" disabled="<%= staffDetailDisabled %>" cssClass="formInput" value="<%= row04.getSzNbrUnit() %>" size="4" maxLength="2" tabIndex="<%= tabIndex++ %>"/></td>
  <td><impact:validateSelect label="Role" required="true" name="cboSzCdUnitMemberRole" codesTable="<%= roleCodeType %>" disabled="<%= String.valueOf(roleDisabled) %>" value="<%= role %>" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
</table>
<!--- Begin Work Information Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="5">Work Information</th>
  </tr>
  <tr>
  <td><impact:validateDisplayOnlyField name="txtSzNmOfficeName" label="Office City" value="<%= ccmn04so.getSzAddrMailCodeCity() != null ? ccmn04so.getSzAddrMailCodeCity() : "" %>"/></td>
  <td><impact:validateSelect label="Office Location" orderBy="decode" required="true" name="cboSzCdOfficeLocation" codesTable="COFCNM" disabled="<%= staffDetailDisabled %>" value="<%= ccmn04so.getSzNmOfficeName() %>" tabIndex="<%= tabIndex++ %>"/></td>
   <td width="25%">&nbsp;</td>
   </tr>
</table>
<!--- Begin Active Status Table --->
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="6">Active Status</th>
  </tr>
  <tr>
    <td><impact:validateDate name="txtDtJobHire" label="Hire Date" constraint="Date" required="true" disabled="<%= hireDateDisabled  %>" value="<%= FormattingHelper.formatDate(row00.getDtDtEmpHire()) %>" size="8" tabIndex="<%= tabIndex++ %>" /></td>
    <td><impact:validateDate name="txtDtJobTerm" label="End Date" constraint="Date" required="false" value="<%= FormattingHelper.formatDate(row00.getDtDtEmpTermination()) %>" size="8" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
</table>
<!-- Begin of Job Description -->
<%
  // Declare variables for Job History Detail Section

  String ers = "";
  String jobTitle = "";
  String caseAssignable = "";
  int jobDescriptionId = 0;
  int supervisorId = 0;

  if (PageModeConstants.NEW.equals(pageMode))
  {
    String jobDescriptionDisabled = "false";

%>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <th colspan="8">Job Description</th>
  </tr>
  <tr>
    <td><impact:validateInput type="text" label="ERS" constraint="AlphaNumeric8" required="true" name="txtSzTextERS" disabled="<%= jobDescriptionDisabled %>" cssClass="formInput" value="<%= ers %>" size="15" maxLength="8" tabIndex="<%= tabIndex++ %>"/></td>
    <td><impact:validateSelect label="Title" orderBy="decode" required="true" name="cboSzCdJobTitle" codesTable="CEMPJBCL" disabled="<%= jobDescriptionDisabled %>" value="<%= jobTitle %>" tabIndex="<%= tabIndex++ %>"/></td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="5">&nbsp;</td>
    <td><impact:validateInput value="<%= caseAssignable %>" disabled="<%= jobDescriptionDisabled %>" type="checkbox" checked="<%= caseAssignable %>"  name="cbxbIndCaseAssignable" label="Case Assignable" cssClass="formInput" tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
</table>
<% } // Close the if for PageMode.New %>

<%

  String endDated = "N";
if ( !EditableMode.isCompatibleWith( pageMode, EditableMode.NEW ) )
{

%>

<!-- Begin Job Description Table -->
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
        <tr>
          <th colspan="4" class="thList">Job Description</th>
       </tr>


<%
  int loopCount = 0;
  //Enumeration e = jobDescription.enumerateROWCCMN04SOG02();

 //Display the results if the array is not empty
  //if (!e.hasMoreElements())
  if ( jobDescription == null )
  {
  %>
      <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
        <td colspan="4"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED )%></td>
      </tr>
     </table>
  <%
  }
  else
  {
    jobDescriptionId = jobDescription.getUlIdEmpJobHistory();
    supervisorId = jobDescription.getUlIdJobPersSupv();
  %>
    <tr class="<%= FormattingHelper.getRowCss( loopCount + 1 ) %>">
     <% String startId = "startId_" + loopCount; %>
     <%  //compares value with NULL_JAVA_DATE which used in SHINES to represent a null date
       if ( row00.getDtDtEmpTermination() == null )
       {
     %>
         <% if (pageMode.equalsIgnoreCase(PageModeConstants.MODIFY)) { %>
     <td>Title:&nbsp;&nbsp;<a id="JobDescription_<%= startId %>" onClick="hrefDirtyByPass=true; hrefNavAwayCheckByPass=true;"
            href="javascript:disableValidation('frmStaffDetail');submitValidateForm('frmStaffDetail', '/admin/StaffSearch/displayJobDescriptionDetail?jobHistoryId=<%=jobDescriptionId%>')"><%= Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()) %></a></td>
         <% } else if (pageMode.equalsIgnoreCase(PageModeConstants.VIEW)){ %>
           <td>Title:&nbsp;&nbsp;<%= Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()) %></td>
         <% } else { %>
       <td>Title:&nbsp;&nbsp;<a id="JobDescription_<%= startId %>" onClick="hrefDirtyByPass=true; hrefNavAwayCheckByPass=true;"
             href="javascript:disableValidation('frmStaffDetail');submitValidateForm('frmStaffDetail', '/admin/StaffSearch/displayJobDescriptionDetail?jobHistoryId=<%=jobDescriptionId%>')"><%= Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass())%></a></td>
     <%     } 
        }
        else
        {
     %>
            <td>Title:&nbsp;&nbsp;<%= Lookup.simpleDecodeSafe("CEMPJBCL", jobDescription.getSzCdJobClass()) %></td>
     <% } %>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
     <td>Supervisor:&nbsp;&nbsp;<%= FormattingHelper.formatString(jobDescription.getSzNmPersonFull()) %></td>
    </tr>
    </table><!-- This is where Job Description table ends--> 
<%
    //loopCount++;
  //} //Close the loop
%>
<% } // end if for no results section%>
<%
  }// end if ( not in add mode )
%>

<% if ( !PageModeConstants.NEW.equalsIgnoreCase( pageMode ) && user.hasRight( UserProfile.SEC_MNTN_STAFF_GEN ) ) { %>
<br>
<impact:include page="/submodule/AddressListSubmodule/displayAddressList"
                callingPage="/admin/StaffSearch/displayStaffDetail"
                includingForm="frmStaffDetail"
                tabIndex="<%= tabIndex++ %>">
<impact:attribute name="<%= ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME %>" value="<%= String.valueOf(true) %>"/>
<impact:attribute name="<%= AddressListConversation.PAGE_MODE_KEY %>" value="<%= pageMode %>"/>
<impact:attribute name="<%= AddressListConversation.ADDRESS_LIST_INCLUDE_PAGE_ATTR %>" value="<%= AddressListConversation.STAFF_DETAIL_WINDOW %>"/>
</impact:include>
<% } // End if %>

<% if ( PageModeConstants.EDIT.equalsIgnoreCase( pageMode ) ) { %>
<br>
<impact:include page='<%= PhoneSubmoduleConversation.PHONE_SUB %>'
                callingPage="/admin/StaffSearch/displayStaffDetail"
                includingForm="frmStaffDetail"
                tabIndex="<%= tabIndex++ %>">
<impact:attribute name="<%= ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME %>" value="<%= String.valueOf(true) %>"/>
</impact:include>
<% } // End if %>

<% if ( !PageModeConstants.VIEW.equalsIgnoreCase( pageMode ) ) { %>
<br>
       <%
  RaceEthnicitySubDB raceEthnicitySubDB = new RaceEthnicitySubDB();
  raceEthnicitySubDB.setTabIndex( tabIndex );
  RaceEthnicitySubDB.setIntoRequest( raceEthnicitySubDB, request );
%>
<%@ include file="/grnds-docs/person/RaceEthnicitySub.jsp" %>
<%
  tabIndex = raceEthnicitySubDB.getTabIndex();
  RaceEthnicitySubDB.removeFromRequest( request );
%>

<% } // End if %>
<br>
<%-- Save and Delete Button --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
    <% //SIR 22345 - had to change from == to .equals
       if ( pageMode.equals( PageModeConstants.EDIT ) ) { %>
      <impact:ButtonTag name="btnSave" img="btnSave" function="enableValidation('frmStaffDetail');" editableMode="<%= EditableMode.EDIT %>" align="right" form="frmStaffDetail" action="/admin/StaffSearch/saveStaffDetail"
                         restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>"/>
    <%  } else { %>
      <impact:ButtonTag name="btnSave" img="btnSave" function="changeDisplayType();enableValidation('frmStaffDetail');" editableMode="<%= EditableMode.NEW %>" align="right" form="frmStaffDetail" action="/admin/StaffSearch/addStaffDetail" 
                         restrictRepost="true" preventDoubleClick="true" tabIndex="<%= tabIndex++ %>"/>
    <%  } %>
    </td>
  </tr>
</table>

<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>"/>
<impact:validateInput type="hidden" name="hdnCReqFuncCd" value="<%= cReqFuncCd %>"/>
<impact:validateInput type="hidden" name="hdnEndDated" value="<%= endDated %>"/>
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%= personId %>"/>
<impact:validateInput type="hidden" name="hdnDisplayType" value="<%= displayType %>"/>
<impact:validateInput type="hidden" name="hdnUlIdJobPersSupv" value="<%= String.valueOf( supervisorId ) %>" />
<impact:validateInput type="hidden" name="hdnUlIdEmpJobHistory" value="<%= String.valueOf( jobDescriptionId ) %>" />
<impact:validateInput type="hidden" name="hdnFromDetail" value="Y"/>
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="" />
<impact:validateInput type="hidden" name="hdnlNbrEmpActivePct" value="<%= String.valueOf( row00.getLNbrEmpActivePct() )%>"/>
<impact:validateInput type="hidden" name="hdnDtPrevTermDate" value="<%=FormattingHelper.formatDate(row00.getDtDtEmpTermination())%>"/>
</impact:validateForm>
