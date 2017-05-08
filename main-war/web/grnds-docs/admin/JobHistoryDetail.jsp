<%
/**
 * JSP Name:     JobHistoryDetail.jsp
 * Created by:   Jeff Chambers
 * Date Created: 10/23/02
 *
 * Description:
 * Allows the user to enter Job information and use the Save button to save the
 * job history row and return to the Staff Detail page.
 *
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/01/03  Todd Reser        Added Change Log and Flowerbox comments.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String pageMode = PageMode.getPageMode( request );

  int tabIndex = 1;
  int personId = GlobalData.getUlIdPerson( request );

//if pagemode is ADD, all fields should be enabled
//if pagemode is Modify and index = 0, can only modify case assignable
//and end date
//otherwise pagemode is browse
  String jobHistoryDisabled = "false";

  if (  ContextHelper.getIntSafe( request, "jobHistoryIndex" ) != 0 )
  {
    pageMode = PageModeConstants.INQUIRE;
  }
  else
  {
    if ( !pageMode.equals(PageModeConstants.NEW) )
    {
    jobHistoryDisabled = "true";
    }
  }

  ROWCCMN04SOG02 jobHistory = null;

  if ( request.getAttribute( "ROWCCMN04SOG02" ) != null &&
      !pageMode.equals(PageModeConstants.NEW) )
  {
    jobHistory = (ROWCCMN04SOG02)request.getAttribute("ROWCCMN04SOG02");
  }
  else
  {
    jobHistory = new ROWCCMN04SOG02();
  }

  String pcn = jobHistory.getSzBjnJob();
  String jobClass = jobHistory.getSzCdJobClass();
  String endDate = FormattingHelper.formatDate(jobHistory.getDtDtJobEnd());
  String supervisor = "";
  String jobFunction = "";
  int jobHistoryId = 0;
  int supervisorId = 0;
  // ***** int JobId = jobHistory.getUlIdEmpJobHistory();
  java.util.Date lastUpdate = null;
  String jobAssignable = "";

  org.exolab.castor.types.Date startDate = null;
  if (pageMode.equals(PageModeConstants.NEW))
  {
    supervisor = (String) request.getAttribute("supervisorName");
    supervisorId = Integer.parseInt((String) request.getAttribute("supervisorId"));
    jobFunction = "";
    lastUpdate = null;
    startDate = DateHelper.toCastorDate(new java.util.Date());
  }
  else
  {
    supervisor = jobHistory.getSzNmPersonFull();
    supervisorId = jobHistory.getUlIdJobPersSupv();
    jobFunction = jobHistory.getSzCdJobFunction();
    lastUpdate = jobHistory.getTsLastUpdate();
    startDate = jobHistory.getDtDtJobStart();
    jobHistoryId = jobHistory.getUlIdEmpJobHistory();
  }

  if (jobHistory.getBIndJobAssignable() == null)
  {
    jobAssignable = "N";
  }
  else
  {
    jobAssignable = jobHistory.getBIndJobAssignable();
  }

  String lastUpdateString = "";

  if ( lastUpdate == null )
  {
    lastUpdateString = "";
  }
  else
  {
    lastUpdateString = String.valueOf( lastUpdate );
  }

String pcn_prev = "";
String jobClass_prev = "";
String supervisor_prev = "";
org.exolab.castor.types.Date startDate_prev = null;
org.exolab.castor.types.Date endDate_prev = null;
String endDatePrevDisabled = "true";
String jobAssignable_prev = "";
if( pageMode.equals(PageModeConstants.NEW))
{
  CCMN04SO ccmn04so = (CCMN04SO) state.getAttribute("CCMN04SO", request);
  pcn_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getSzBjnJob();
  jobClass_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getSzCdJobClass();
  supervisor_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getSzNmPersonFull();
  startDate_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getDtDtJobStart();
  if(ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getDtDtJobEnd() == null)
  {
    endDate_prev = null;
  }
  else
  {
    endDate_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getDtDtJobEnd();
  }
  //use end date from service if not null and pagemode is new
  //if end date is already filled, should not be editable????
  if (endDate_prev == null )
  {
    endDatePrevDisabled = "false";
  }
  if(endDate_prev == null && pageMode.equals(PageModeConstants.NEW) )
  {
    endDate_prev = startDate;
  }


  if ( ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getBIndJobAssignable() == null)
  {
    jobAssignable_prev = "N";
  }
  else
  {
    jobAssignable_prev = ccmn04so.getROWCCMN04SOG02_ARRAY().getROWCCMN04SOG02(0).getBIndJobAssignable();
  }
}
%>

<impact:validateForm name="frmJobHistory"
   defaultButton="true"
   method="post"
   action="/admin/StaffSearch/saveJobHistoryDetail"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.JobHistoryCustomValidation"
   pageMode="<%= pageMode %>"
   schema="/WEB-INF/Constraints.xsd"
   redisplayParameters="true">
<impact:validateErrors formName="frmJobHistory"/>
<%-- Hidden Fields --%>
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnTsLastUpdate" value="<%= lastUpdateString %>" />
<impact:validateInput type="hidden" name="hdnDisplayType" value="Modify" />
<impact:validateInput type="hidden" name="hdnUlIdPerson" value="<%= String.valueOf( personId )%>" />
<impact:validateInput type="hidden" name="hdnUlIdJobPersSupv" value="<%= String.valueOf( supervisorId ) %>" />
<impact:validateInput type="hidden" name="hdnSzCdJobFunction" value="<%= String.valueOf( jobFunction ) %>" />
<impact:validateInput type="hidden" name="hdnUlIdEmpJobHistory" value="<%= String.valueOf( jobHistoryId ) %>" />


<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
  <% if (pageMode.equals(PageModeConstants.NEW))
    { %>
  <th colspan="6">New Job History</th>
   <% }
   else
   { %>
  <th colspan="6">Job History</th>
   <% } %>
  </tr>
  <tr>
  <td><impact:validateInput type="text" 
                            label="PCN" 
                            constraint="AlphaNumeric8" 
                            required="true" 
                            name="txtSzBjnJob"  
                            cssClass="formInput"
                            disabled="<%= jobHistoryDisabled %>" 
                            value="<%= pcn %>" 
                            size="15" 
                            maxLength="8" 
                            tabIndex="<%= tabIndex++ %>"/></td>

  <td><impact:validateSelect label="Class" 
                            orderBy="decode" 
                            required="true" 
                            name="cboSzCdJobClass" 
                            codesTable="CEMPJBCL"  
                            disabled="<%= jobHistoryDisabled %>" 
                            value="<%= jobClass %>" 
                            tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
     <td><impact:validateDate name="txtDtJobStart" 
                            label="Start Date" 
                            constraint="Date" 
                            required="true" 
                            disabled="<%= jobHistoryDisabled %>" 
                            value="<%= FormattingHelper.formatDate( startDate ) %>"
                            size="8" 
                            tabIndex="<%= tabIndex++ %>"/></td>

    <td><impact:validateDate name="txtDtJobEnd" 
                            label="End Date" 
                            constraint="Date" 
                            required="false" 
                            value="<%= endDate %>" 
                            size="8" 
                            tabIndex="<%= tabIndex++ %>" 
                            colspan="2"/></td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField name="txtSzNmPersonFull" 
                            colspan="3" 
                            label="Supervisor" 
                            value="<%= supervisor %>"/></td>

  <td><impact:validateInput value="<%= jobAssignable %>" 
                            type="checkbox" 
                            checked="<%= jobAssignable %>"  
                            name="cbxbIndJobAssignable" 
                            label="Case Assignable" 
                            cssClass="formInput"
                            tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <% if (pageMode.equals(PageModeConstants.NEW))
    { %>
    <tr>
  <th colspan="6">Existing Job History</th>
  </tr>
  <tr>
  <td><impact:validateInput type="text" 
                            label="PCN" 
                            constraint="AlphaNumeric8" 
                            name="txtSzBjnJob_prev"  
                            cssClass="formInput"
                            disabled="true" 
                            value="<%= pcn_prev %>" 
                            size="15" 
                            maxLength="8" 
                            tabIndex="<%= tabIndex++ %>"/></td>

  <td><impact:validateSelect label="Class" 
                            orderBy="decode" 
                            name="cboSzCdJobClass_prev" 
                            codesTable="CEMPJBCL"  
                            disabled="true" 
                            value="<%= jobClass_prev %>" 
                            tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
  <tr>
     <td><impact:validateDate name="txtDtJobStart_prev" 
                            label="Start Date" 
                            constraint="Date"  
                            disabled="true" 
                            value="<%= FormattingHelper.formatDate( startDate_prev ) %>" 
                            size="8" 
                            tabIndex="<%= tabIndex++ %>"/></td>

     <td><impact:validateDate name="txtDtJobEnd_prev" 
                            label="End Date" 
                            constraint="Date" 
                            required="false" 
                            value="<%= FormattingHelper.formatDate( endDate_prev ) %>" 
                            disabled="<%= endDatePrevDisabled %>"
                            size="8" 
                            tabIndex="<%= tabIndex++ %>" 
                            colspan="2"/></td>
  </tr>
  <tr>
    <td><impact:validateDisplayOnlyField name="txtSzNmPersonFull_prev" 
                            colspan="3" 
                            label="Supervisor" 
                            value="<%= supervisor_prev %>"/></td>

    <td><impact:validateInput value="<%= jobAssignable %>" 
                            type="checkbox" 
                            disabled="true" 
                            checked="<%= jobAssignable_prev %>"  
                            name="cbxbIndJobAssignable_prev" 
                            label="Case Assignable" 
                            cssClass="formInput"
                            tabIndex="<%= tabIndex++ %>"/></td>
  </tr>
<% } %>
</table>
<%-- Continue Button --%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td class="alignRight">
      <impact:ButtonTag name="btnSave" 
                            img="btnSave" 
                            align="right" 
                            form="frmJobHistory" 
                            action="/admin/StaffSearch/saveJobHistoryDetail" 
                            tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
</impact:validateForm>
