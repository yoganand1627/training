<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%
  response.setContentType( "text/html; charset=" + ArchitectureConstants.CHARACTER_ENCODING );
  String html = (String)request.getAttribute( "spellCheckDocument" );
  if( html!= null )
  {
    out.println( html );
  }
  else
  {
    out.println( "Spell Check Failed" );
  }
%>