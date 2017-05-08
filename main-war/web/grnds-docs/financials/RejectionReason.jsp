<%
//*  JSP Name:     Rejection Reason
//*  Created by:   Anna Grimshaw
//*  Date Created: 01/20/2002
//*
//*  Description:
//*  This JSP is used view Rejection Reasons
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------

%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%
/* Import xmlstructs used on the page. Xmlstructs hold the input and output data
     for Tuxedo service calls.  Xml output structs corresponding to the services
     called to retrieve data for this page should be used on this page and
     therefore imported here */
%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN09SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN09SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFIN09SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="java.util.Enumeration"%>
<%// Import needed for Form Launch


//Get the output object from the request
CFIN09SO cfin09so = (CFIN09SO) request.getAttribute("CFIN09SO");
ROWCFIN09SOG00_ARRAY rejectionArray = null;

if (cfin09so == null) {
 cfin09so = new CFIN09SO();
}

if (cfin09so.getROWCFIN09SOG00_ARRAY() == null) {
  rejectionArray = new ROWCFIN09SOG00_ARRAY();
} else {
  rejectionArray = cfin09so.getROWCFIN09SOG00_ARRAY();
 }
%>
<% // Start Javascript Section
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
</script>
<% //End Javascript Section
%>

<%
  //Declare and initialize control variables for the page
  /* Assign tab-index */
  int tabIndex = 1;


  //Initialize the variables that will specify the display rules for individual fields

  int loopCount=0;
  ROWCFIN09SOG00 rejectionRow = null;
  Enumeration rejectionEnumeration = rejectionArray.enumerateROWCFIN09SOG00();
%>

                 <table width="100%" cellspacing="0" cellpadding="3" class="tableBorderList">
                           <tr>
                           <th class="thList">RR</th>
                           <th class="thList">Rejection Reason</th>
                        </tr>
<%
                  if ( !rejectionEnumeration.hasMoreElements() )
                  {
%>
                      <tr class="odd">
                        <td colspan="10">
                           <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
                        </td>
                      </tr>
<%
                  }
                    else
                  {
                    while ( rejectionEnumeration.hasMoreElements() )
                    {
                      rejectionRow = (ROWCFIN09SOG00) rejectionEnumeration.nextElement();

%>
                        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
                            <td><%= rejectionRow.getSzCdRejRsn() %></td>
                            <td><%= Lookup.simpleDecodeSafe(CodesTables.CRJCTRSN, rejectionRow.getSzCdRejRsn())%></td>
                        </tr>
<%
                     loopCount++;
                    } // end for
                  }
%>
           </table>





