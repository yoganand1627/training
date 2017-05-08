<%
//*  JSP Name:     LinkToPolicy JSP
//*  Created by:   Sujana Nallavadla
//*  Date Created: 04/18/2005
//*
//*  Description:
//*  The Link To Policy Link  page is used to navigate the policy links
//*  depending on task codes and policy links available.
//*
//** Change History:
//**  Date           User              Description
//**  --------  ----------------  --------------------------------------------------
//**
%>

<!--Depending on Task code,conversation sets policylink url to be dynamically displayed,when
once user click hand book button in request object -->

<meta http-equiv="Refresh" content="0; url=<%=request.getAttribute("policyLinkURL")%>">