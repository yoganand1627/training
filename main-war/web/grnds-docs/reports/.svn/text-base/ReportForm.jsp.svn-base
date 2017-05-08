<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.reports.ReportListTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>

<%
  UserProfile user = UserProfileHelper.getUserProfile (request);
%>

<h3>
Available Reports:
</h3>
<a href="/admin/Reports/reportList?ulIdPerson=<%=user.getUserID()%>&cSysIndRptRtrvType=Y&resultsPerPage=10">Report List</a>

<impact:reportList tabIndex="1" personId="<%=user.getUserID()%>">
  <impact:report useHiddenParameters="true" reportName="ccf02o00" />
  <impact:report useHiddenParameters="true" reportName="ccf03o00" />
  <impact:report useHiddenParameters="false" reportName="cfn51o01" >
    <impact:reportParameter value="5600240"/>
  </impact:report>
  <impact:report useHiddenParameters="false" reportName="cfn05o01" >
    <impact:reportParameter value="03"/>
    <impact:reportParameter value="/opt/impact/config/devl/applications/impact/xmlTest/reports"/>
  </impact:report>
</impact:reportList>

<form>
<table>
<tr>
<td>
<input type="radio" name="id" checked onClick="setReportParameters('param','18022007');">
</td>
<td>
STAGE
</td>
</tr>
<tr>
<td>
<input type="radio" name="id" onClick="setReportParameters('param','18001988');">
</td>
<td>
INVOICE
</td>
</tr>
</table>
</form>

<%--
<impact:formList personId="<%=user.getUserID()%>">
  <impact:form formName="Case File Cover Sheet" smartName="ccf02o">
    <impact:formParameter name="ulIdPerson" value="<%=cres03so.getUlIdPerson()%>"/>
  </impact:form>
  <impact:form formName="PAL Case Summary" sqrName="ccf03o" sqrVersion="00" >
    <impact:formParameter value="24544096"/>
  </impact:form>
</impact:formList>
--%>



