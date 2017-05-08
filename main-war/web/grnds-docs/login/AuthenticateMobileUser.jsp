<?xml version='1.0'?>
<!DOCTYPE result [
   <!ELEMENT result (success|failure)>
   <!ELEMENT success (#PCDATA)>
   <!ELEMENT failure (#PCDATA)>
]>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.LoginConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.LoginConversation"%>
<%
// This jsp will display login authentication result.
// SIR 23751, Hari Maralla (07/14/05). Refactor the MPS Login for impact design standard.
  out.print( "<result>" );
  out.print(request.getAttribute( LoginConversation.AUTHENTICATE_RESULT ));
  out.print( "</result>" );
%>
