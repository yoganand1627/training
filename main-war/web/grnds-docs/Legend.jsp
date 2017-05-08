<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<impact:setAttribute parameter="Legend1"/>
<impact:setAttribute parameter="Legend2"/>
<%
  String legend1 = (String)request.getAttribute( "Legend1" );
  String legend2 = (String)request.getAttribute( "Legend2" );
%>
<% 
//*  JSP Name:     Legend
//*  Created by:   Stephan Brauchli
//*  Date Created: 11/04/02
//*
//*  Description:
//*  This JSP is used to case on the legend attributes set in a JSP's 
//*  ScreenDefinitions xml file to determine what data to display.
//*
//*  Values Supported:
//*  condRequired
//*  required
//*  newStage
//*  Reporter
//*  New Case or New Stage
//*  Superintendent
//*  Submitted Events
//*  Returned is Created
//*  
//*  
 %>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
<%
  for( int i = 0; i < 2; i++ )
  {
    String legend = legend1;
  if( i == 1 )
  {
    legend = legend2;
  }
  if( legend == null )
  {
    legend  = "";
%>
  <tr>
    <td>&nbsp;</td>
    </tr>
<%
  }
  if ("required".equals(legend) )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formRequiredText">*</span>&nbsp;required field</td>
    </tr>
<%
    }
    else if ("condRequired".equals(legend)  )
    {
%>
    <tr>
      <td class="requiredInst">
      <span class="formCondRequiredText">&#135;</span>&nbsp;conditionally required field
    </td>
    </tr>
<%
    }
    else if ("newStage".equals(legend)  )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formBoldedText">#</span>&nbsp;New Assignment</td>
    </tr>
<%
    }
    else if ("Reporter".equals(legend)  )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formBoldedText">#</span>&nbsp;Reporter</td>
    </tr>
<%
    }
    else if ("New Case or New Stage".equals(legend)  )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formBoldedText">#</span>&nbsp;New Case or New Stage of Case</td>
    </tr>
<%
    }
    else if ("Superintendent".equals(legend)  )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formBoldedText">&clubs;</span>&nbsp;Superintendent (APS)</td>
    </tr>
<%
    }
    else if ("Submitted Events".equals(legend)  )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formBoldedText">#</span>&nbsp;Submitted Events</td>
    </tr>
<%
    }
    else if ("Returned is Created".equals(legend)  )
    {
%>
  <tr>
    <td class="requiredInst"><span class="formBoldedText">#</span>&nbsp;Person Returned is Same Person just created</td>
    </tr>
<%   }
  }
%>
</table> 
