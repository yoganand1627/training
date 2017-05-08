<%
//*  JSP Name:     SimpleHelpTextPage
//*  Created by:   Hong-van Vo
//*  Date Created: 03/10/2011
//*
//*  Description:
//*  This JSP will be used to display simple help text in another window. This is a generic page.
//*
//** Change History:
//**  Date        User                Description
//**  ----------  ----------------    ----------------------------------------------------
//**  03/10/2011  Hong-van Vo         Initial Creation 
//**                                  
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.URLHelper" %>

<html>
<head>
<%
  String winName = request.getParameter(ArchitectureConstants.SIMPLE_HELP_TEXT_WIN_NAME);
%>
  <title><%=winName %></title>
</head>

<body bgcolor="#FFFFFF" text="#000000">

<%
  String helpText = request.getParameter(ArchitectureConstants.SIMPLE_HELP_TEXT_DISPLAY);
  helpText = URLHelper.decode(helpText);
  out.write(helpText);
%>

</body>

</html>


