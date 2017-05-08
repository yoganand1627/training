<%--
JSP Name:     Output Launch
Created by:   Ronnie Phelps
Date Created: 11/15/07

Description:
This JSP allows the user to view the Report Launch List page

Change History:
Date      User              Description
--------  ----------------  --------------------------------------------------
11/15/07  Ronnie Phelps     Initial jsp creation
11/26/07  Stephen Roberts   Added grouping to report types.  Cleaned up some code from a previous template/page.
03/18/08  Van Vo			Made each report type group collapse - STGAP00007312
10/22/08  Van Vo			Enabled report hyperlink only when user has access - STGAP00010625 
                            (access determined based on type of report and user profile, done in retrieve service)
06/11/10  Van Vo			SMS#49899: re-direct batch report launch link (Financial Exception) to the Pickup List.                         
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportPageSO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation" %>

<%
  List<RetrieveReportPageSO> reportPageList = (List<RetrieveReportPageSO>) request.getAttribute("REPORT_PAGE_LIST");
  int loopCount = 0;
  int tabIndex = 1;
  // Defect #
  UserProfile user = UserProfileHelper.getUserProfile(request);
  Object[] reportPageListArray = reportPageList.toArray();
  int reportIndex = 0;
%>

<impact:validateErrors/>
<impact:validateForm name="frmReportLaunch" method="post" action="/admin/Reports/displayReportParameterDetail" schema="/WEB-INF/Constraints.xsd"> 
<impact:validateInput type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="hdnNmRptSqrName"/>
<impact:validateInput type="hidden" name="hdnNmRptSqrVer"/>
<impact:validateInput type="hidden" name="hdnNmOfReport"/>
<impact:validateInput type="hidden" name="hdnIndexOfReport"/> 
<impact:validateInput type="hidden" name="hdnNmRptType"/>

<%
if (reportPageList == null || reportPageList.isEmpty()) {
%>
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorderList">
  <tr>
    <th class="thList">Name</th>
    <th class="thList">Description</th>
    <th class="thList">Type</th>
  </tr>
  <tr>
    <td colspan="7">
      <%=MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED")%>
    </td>
  </tr>
</table>
<%
} else {
%>  
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
      <a tabIndex="<%= tabIndex++ %>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
    </td>
  </tr>
</table>

  <%
  String reportArea = "";
  //Object[] reportPageListArray = reportPageList.toArray();
  int arraySize = reportPageListArray.length;
  for (int arrayIndex = 0; arrayIndex < arraySize ; arrayIndex++) { 
    RetrieveReportPageSO rowTagLabel = (RetrieveReportPageSO) reportPageListArray[arrayIndex];
  %> 
<impact:ExpandableSectionTag name="<%=rowTagLabel.getTxtRptAreaType() %>" label="<%=rowTagLabel.getTxtRptAreaType() %>" tabIndex="<%=tabIndex++ %>" >
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableborderList">   
  <tr>
    <th class="thList">Name</th>
    <th class="thList">Description</th>
    <th class="thList">Type</th>
  </tr>
  <%
  for (int subArrayIndex = arrayIndex; subArrayIndex < arraySize; subArrayIndex++) {
  
    loopCount++;
    String rowCss = loopCount % 2 == 1 ? "altColor" : "odd";
    RetrieveReportPageSO row = (RetrieveReportPageSO) reportPageListArray[subArrayIndex];
    String sqrName = row.getNmRptSqrName();
    String sqrVer = row.getNmRptSqrVer();
    String rptFullName = row.getTxtRptFullName();
    String rptDecs = row.getTxtRptDesc();
    String rptAreaType = row.getTxtRptAreaType();
    String rptType = row.getNmRptType();
    reportIndex = subArrayIndex;
    String rptIndAccessAllowed = row.getIndAccessAllowed();
    
    if (ReportsConversation.BATCH_REPORTS.containsKey(sqrName)) {
 %>      
    <tr class="<%=rowCss%>">
      <td width="20%" valign="top"><a href="javascript:submitForm()" <%= tabIndex++ %>" ><%= rptFullName %></a></td>
      <td width="65%" valign="top"><%= rptDecs %></td>
      <td width="15%" valign="top"><%= rptAreaType %></td>
    </tr>
 <%   }  else if ("Y".equals(rptIndAccessAllowed)) { %>

    <tr class="<%=rowCss%>">
      <td width="20%" valign="top"><a href="javascript:submitReportParameterDetails( '<%= sqrName%>','<%= sqrVer%>','
      <%= rptFullName%>', '<%= rptType%>')" <%= tabIndex++ %>"><%= rptFullName %></a></td>
      <td width="65%" valign="top"><%= rptDecs %></td>
      <td width="15%" valign="top"><%= rptAreaType %></td>
    </tr>
  <%  }  else {  %>
    <tr class="<%=rowCss%>">
      <td width="20%" valign="top"><%= rptFullName %></td>
      <td width="65%" valign="top"><%= rptDecs %></td>
      <td width="15%" valign="top"><%= rptAreaType %></td>
    </tr>
  <% }  %>
  <% 
    reportArea = (rptAreaType == null) ? "" : rptAreaType;
    RetrieveReportPageSO lookaheadRow;
    if (subArrayIndex+1 < arraySize) {
      lookaheadRow = (RetrieveReportPageSO) reportPageListArray[subArrayIndex+1];
    } else {
      lookaheadRow = new RetrieveReportPageSO();
    }  
    String lookaheadReportArea = (lookaheadRow.getTxtRptAreaType() == null) ? "" : lookaheadRow.getTxtRptAreaType();
    if (!reportArea.equals(lookaheadReportArea)) { 
      arrayIndex = subArrayIndex; break;
    } // End comparing lookahead 
  } // End subArrayIndex for loop %>
</table>
</impact:ExpandableSectionTag></br>
<%} // End arrayIndex for loop %>
<%} //end big else (inputs, outputs not null) %>
</impact:validateForm>
<script type="text/javascript" language="JavaScript">
  function submitReportParameterDetails(hdnNmRptSqrName,hdnNmRptSqrVer,hdnNmOfReport, hdnNmRptType)
  {
    document.frmReportLaunch.hdnNmRptSqrName.value = hdnNmRptSqrName;
    document.frmReportLaunch.hdnNmRptSqrVer.value = hdnNmRptSqrVer;
    document.frmReportLaunch.hdnNmOfReport.value = hdnNmOfReport;
    document.frmReportLaunch.hdnNmRptType.value = hdnNmRptType;
    submitValidateForm( "frmReportLaunch", "/admin/Reports/displayReportParameterDetail" );
  }
  
  function submitForm ()
  {
    submitValidateForm( "frmReportLaunch", "/admin/Reports/reportList" );
  }
</script>
