<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="org.grnds.facility.config.GrndsConfiguration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>

<%

String WEB_HELP = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "webHelp");


%>

<script type="text/javascript" src="/grnds-docs/js/shared/RoboHelp_CSH.js"></script>
<table width="780" cellpadding="0" cellspacing="0" height="60" border="0"
 background = "/grnds-docs/images/metaphor/SHINES_word_header.jpg">
      <tr><td align = "right"><img src="/grnds-docs/images/dhr_dfcs_logo.gif"></td></tr>
      </table>
    </td>
  </tr >
  <tr >
    <td>
      <table width="780" cellpadding="0" cellspacing="0" border="0">
      <tr class="even" height ="20">
       <td align="left" width="80%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	   <a class="header" href='http://www.georgia.gov' target='_blank'>Georgia.gov</a>&nbsp;&gt;&nbsp;
 	   <a class="header" href='http://www.georgia.gov/00/topic_index_channel/0,2092,4802_937045,00.html' target='_blank'>Agencies & Organizations</a>&nbsp;&gt;&nbsp;
 	   <a class="header" href='http://www.dhs.georgia.gov' target='_blank'>Department of Human Services</a>&nbsp;&gt;&nbsp;
 	   <a class="header" href='http://www.dfcs.dhs.georgia.gov' target='_blank'> DFCS</a>&nbsp;&gt;&nbsp;SHINES Portal
       </td>
       <td align="center" width="10%"><a class="header" 
              href="javaScript:RH_ShowHelp(0, '<%=WEB_HELP%>', HH_HELP_CONTEXT, <impact:WebHelpURL/>)">
              Help</a></td>
     </tr>
    
     </table>
     <table border="0" width="780" cellspacing="0" cellpadding="0">
  <tr>
    <td width="780"><img src="/grnds-docs/images/metaphor/SHINES_Header.jpg"></td>
  </table>
  </tr>
</table>

     