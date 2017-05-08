<%--
//*  JSP Name:     Error List
//*  Created by:   Stephan Brauchli
//*  Date Created: 10/18/02
//*
//*  Description:
//*  This JSP will be used to display error messages
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/13/04  CORLEYAN          SIR 22985 - Added warning to top of error list
//**                              telling users that if they navigate away the links
//**                              will not work
//**
//**
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorListMessage" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="java.util.List" %>
<html>
<head>
  <title>Error List Page</title>
  <LINK href="/grnds-docs/css/impact.css" rel=stylesheet>
  <SCRIPT type="text/javascript" src="/grnds-docs/js/shared/impact.js"></script>
</head>

<body bgcolor="#FFFFFF" text="#996666" link="#FF0000" alink="#FF9999" vlink="#663333">
<script type="text/javascript" language="JavaScript1.2">
  function callParent(url) {
    self.opener.processErrorListSubmit(url);
  }
</script>
<div id="errorList" style="height:185px;width:528px;overflow:auto" class="tableborderList">
  <table width="100%" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <th class="thList">Error List - <span class="formInstruct">Links may not work if you navigate away from the page before resolving errors.</span>
      </th>
    </tr>
    <%
      int loopCount = 0;
      String serializedErrorList = ContextHelper.getStringSafe(request, ErrorList.ERROR_LIST_PARAM);
      if (StringHelper.isValid(serializedErrorList)) {
        List errorArray = (List) SerializationHelper.deserializeObject(serializedErrorList);
        int errorNum = errorArray.size();

        for (int i = 0; i < errorNum; i++) {
    %>
    <tr <% if ( loopCount % 2 == 1 ) { %>class="altcolor"<% } %> >
      <td>
        <%
          // cast as bean then call gets on bean
          ErrorListMessage errorListMessage = (ErrorListMessage) errorArray.get(i);
          String url = errorListMessage.getMsgURL();
          String taskCode = errorListMessage.getTaskCD();
          if (!"null".equals(url)) {
        %>
        <span class="formErrorListText">
        <a href="#" onClick="callParent('<%= getUrl( url, taskCode ) %>');"><%= errorListMessage.getErrorMessage() %>
        </a><br>
        </span>

        <%
        } else {
        %>
        <span class="formErrorListText">
        <%= errorListMessage.getErrorMessage() %><br>
        </span>

        <%
          }
        %>
      </td>
    </tr>
    <%
        loopCount++;
      }
    } else {
    %>
    <tr>
      <td>
        No error list messages found.
      </td>
    </tr>
    <%
      }
    %>
  </table>

</div>
<br>
<br>

<div align="center">
  <a href="javascript: window.close();" tabIndex="1">Close this page</a>
</div>
<br>
<%!
  protected static String getUrl(String url, String linkTaskCode) {
    String linkUrl = url;
    linkUrl += "?taskCD=";

    if (linkTaskCode == null || "NULL".equalsIgnoreCase(linkTaskCode)) {
      return linkUrl + "NULL";
    }
    return linkUrl + linkTaskCode;
  }
%>
</body>
</html>
