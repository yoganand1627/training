<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CfpStatusDB" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.document.cfp.CfpConversation" %>
<%
  try {
    // Set character encoding before printing anything out; this MUST
    response.setContentType("text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING);

    List list = (List)
            request.getAttribute(CfpConversation.QUEUE_STATUS_DATABEAN);

    int userId = BasePrsConversation.getUserID(request);
    int tabIndex = 1;
    String formName = "queueStatus";
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=<%=ArchitectureConstants.CHARACTER_ENCODING%>">
  <title>Case File Print - Queue Viewer</title>
  <link href="/grnds-docs/css/impact.css" rel=stylesheet>
  <script src="/grnds-docs/js/shared/impact.js" type="text/javascript"></script>
</head>

<%-- Header copied from ErrorList --%>
<body bgcolor="#FFFFFF" text="#996666" link="#FF0000" alink="#FF9999" vlink="#663333">


<%-- copied from Index.jsp so Refresh button wouldn't error --%>
<!-- BEGIN HiddenFieldState form -->
<form name="hiddenFieldStateForm" action="#">
  <input type="hidden" name="requestStartTime" value='<%=request.getParameter("requestStartTime") %>'>
  <input type="hidden" name="requestTotalTime">
  <impact:hiddenFieldSessionStateManager/>
  <input type="hidden" name="bSubmitted" value="false">
</form>
<!-- END HiddenFieldState form -->


<script type="text/javascript" language="JavaScript1.2">
  <!--Insert Java Script here
  function cancelCfp(cfpId)
  {
    document.all["<%= formName %>"].cfpId.value = cfpId;
    disableValidation("<%= formName %>");
    submitValidateForm('<%= formName %>', '<%= CfpConversation.CANCEL_CFP %>');
    return false;
  }


  function refresh()
  {
    disableValidation("<%= formName %>");
    submitValidateForm('<%= formName %>', '<%= CfpConversation.QUEUE_STATUS %>');
    return false;
  }
  //http://developer.irt.org/script/1563.htm
  //refresh after 30 seconds
  setTimeout('refresh()', (30 * 1000));
  //-->
</script>

<impact:validateErrors/>

<impact:validateForm name="<%= formName %>"
                     action='/not/a/real/path'
                     defaultButton="true"
                     method="post"
                     pageMode="<%= PageModeConstants.EDIT %>"
                     schema="/WEB-INF/Constraints.xsd">

<impact:pagination submitUrl="<%= CfpConversation.QUEUE_STATUS %>" saveState="false">

  <table cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
    <tr>
      <th class="thList"><nobr>Staff Name</nobr></th>
      <th class="thList"><nobr>Case Name</nobr></th>
      <th class="thList">Status</th>
      <th class="thList">Case ID</th>
      <th class="thList">Stage</th>
      <th class="thList">Progress</th>
      <th class="thList">Submitted&nbsp;&nbsp;</th>
      <th class="thList">Completed&nbsp;&nbsp;</th>
      <th class="thList">Message/Cancel</th>
      <!--      <th class="thList">Cancel</th> -->
    </tr>
    <%
      int i = -1;

      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        CfpStatusDB cfpStatus = (CfpStatusDB) iterator.next();

        i++;
        String trClass = "odd";
        if (i % 2 == 1) {
          trClass = "even";
        }

        String errorDescription = "&nbsp;";
        if (cfpStatus.isComplete()) {
          errorDescription = "Success";
        }
        if (cfpStatus.isError()) {
          errorDescription = cfpStatus.getErrorDescription();
        }

        String completionTime = "&nbsp;";
        if (cfpStatus.isError() ||
            cfpStatus.isComplete()) {
          completionTime = cfpStatus.getCompletionTime();
        }
    %>
    <tr class="<%= trClass %>">
      <td><%= cfpStatus.getStaffName() %></td>

      <impact:if test="<%= ((cfpStatus.getPersonId() == userId) && (cfpStatus.isComplete())) %>">
        <impact:then>
          <td><a tabIndex="<%= tabIndex++ %>"
                 target="_blank"
                 href="<%= getHttpPath(cfpStatus.getPath()) %>"><%= cfpStatus.getCaseName() %></a></td>
        </impact:then>
        <impact:else>
          <td><%= cfpStatus.getCaseName() %></td>
        </impact:else>
      </impact:if>

      <td><%= cfpStatus.getDescriptiveStatus() %></td>
      <td><%= cfpStatus.getCaseId() %></td>
      <td><%= cfpStatus.getStageCode() %></td>
      <td><%= cfpStatus.getProgress() %></td>
      <td><%= cfpStatus.getSubmissionTime() %></td>
      <td><%= completionTime %></td>
      <!--      <td><%= errorDescription %></td> -->

      <impact:if test="<%= ((cfpStatus.getPersonId() == userId) && (cfpStatus.isSubmitted())) %>">
        <impact:then>
          <td><a href='javascript:cancelCfp("<%= cfpStatus.getStatusId() %>")'
                 tabIndex="<%= tabIndex++ %>">Cancel</a></td>
        </impact:then>
        <impact:else>
          <td><%= errorDescription %></td>
          <!-- <td>&nbsp;</td> -->
        </impact:else>
      </impact:if>
    </tr>
    <%
      }
    %>
  </table>
</impact:pagination>

<table width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td align="right">
      <impact:ButtonTag name="Refresh"
                        tabIndex='<%= tabIndex++ %>'
                        function='return refresh();'
                        action='/not/a/real/path'
                        form='<%= formName %>'
                        img="btnRefresh"
                        editableMode='<%= EditableMode.EDIT %>'/>
    </td>
  </tr>
</table>

<impact:validateInput type="hidden" name="cfpId"/>
<input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">
</impact:validateForm>


</body>
</html>

<%
  }
  catch (Throwable e) {
    out.println("<pre>");
    e.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
  }
%>

<%!
  protected static final String CFP_HTTP_FILE_LOCATION =
          GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN, "cfp.http.file.location");

  /**
   * Derived value based on Path.
   * Location to serve up cfp document via http.
   */
  public String getHttpPath(String path) {
    if (path == null) {
      return null;
    }
    int index = path.replace('\\', '/').lastIndexOf("/");
    return CFP_HTTP_FILE_LOCATION + path.substring(index + 1);
  }
%>
