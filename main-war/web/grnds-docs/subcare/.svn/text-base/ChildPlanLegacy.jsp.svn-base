<%
  //*--------------------------------------------------------------------------------
//*  JSP Name:     Child Plan Legacy
//*  Created by:   Bryon Jacob
//*  Date Created: 03/01/03
//*
//*  Description:
//*  This JSP displays the Child Plan form for legacy child plans.
//*
//*  Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  int tabIndex = 1;
  UserProfile user = UserProfileHelper.getUserProfile(request);
  String pageMode = PageModeConstants.INQUIRE;
%>

<%
  //***************
//**** FORMS ****
//***************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="3">Child Plan Detail</th></tr>
  <tr>
    <td>
      <%= MessageLookup.getMessageByNumber(Messages.MSG_CP_LEGACY_DATA) %>
    </td>
  </tr>
</table>
<br>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr><th>Forms</th></tr>
  <tr>
    <td>
      <impact:documentList pageMode="<%= pageMode %>" tabIndex="<%= tabIndex++ %>">
        <%
          // By default, use the legacy child plan template (csc18o00).
          // For Adoption plans, use the legacy adoption plan template (csc26o00).
          String documentType = "csc18o00";
          String planTypeCode = (String) request.getAttribute("planTypeCode");
          if (CodesTables.CCPPLNTP_ADP.equals(planTypeCode)) {
            documentType = "csc26o00";
          }
        %>
        <impact:document
                displayName="Child Plan"
                docType="<%= documentType %>"
                docExists="false"
                protectDocument="true">

          <impact:documentParameter
                  name="pEvent"
                  value="<%= FormattingHelper.formatInt( GlobalData.getUlIdEvent( request ) ) %>"/>

          <impact:documentParameter
                  name="pPerson"
                  value="<%= FormattingHelper.formatInt( user.getUserID() ) %>"/>

          <impact:documentParameter
                  name="pStage"
                  value="<%= FormattingHelper.formatInt( GlobalData.getUlIdStage( request ) ) %>"/>
        </impact:document>
      </impact:documentList>
    </td>
  </tr>
</table>
<br>