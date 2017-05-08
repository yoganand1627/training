<%
//*  JSP Name:     Case Watch Factor Help Text
//*  Created by:   Patrick Coogan
//*  Date Created: 11/12/09
//*
//*  Description:
//*  This JSP will be used to display case watch factor help text.
//*
//** Change History:
//**  Date      User                Description
//**  --------  ----------------    --------------------------------------------------
//**  11/13/09  Patrick Coogan      Creation to support display of Case Watch factor
//**                                help.
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>

<html>
<head>
  <title>Case Watch Factor Help</title>
</head>

<body bgcolor="#FFFFFF" text="#000000">

<%
  String HelpTxt = request.getParameter("HelpTxtName");
  HelpTxt = URLHelper.decode(HelpTxt);
  out.write(HelpTxt);
%>

</body>

</html>


