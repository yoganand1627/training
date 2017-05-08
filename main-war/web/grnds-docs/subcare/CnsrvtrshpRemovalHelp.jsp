<%
//*  JSP Name:     CnsrvtrshpRemovalHelp Text
//*  Created by:   Hong-van Vo
//*  Date Created: 12/07/2010
//*
//*  Description:
//*  This JSP will be used to display custody removal reason help text.
//*
//** Change History:
//**  Date        User                Description
//**  ----------  ----------------    ----------------------------------------------------
//**  12/07/2010  Hong-van Vo         Creation to support display of AFCARS removal reason
//**                                  help.
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>

<html>
<head>
  <title>Removal Reason Help</title>
</head>

<body bgcolor="#FFFFFF" text="#000000">

<%
  String HelpTxt = request.getParameter("HelpTxtName");
  HelpTxt = URLHelper.decode(HelpTxt);
  out.write(HelpTxt);
%>

</body>

</html>


