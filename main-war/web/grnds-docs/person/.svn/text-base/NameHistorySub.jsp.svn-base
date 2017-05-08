<%--
//*  JSP Name:     Name History Submodule
//*  Created by:   Heather Dean
//*  Date Created: 12/11/02
//*
//*  Description:
//*  Included submodule to display the name history list.
//*
//*  Code to include this submodule:
//*     <impact:include page="/submodule/NameHistorySubmoduleConversation/displayNameHistory" callingPage="/test/NameHistorySubmodTest/display" tabIndex="1" includingForm="frmNameHistSub">
//*      <impact:attribute name="intakeIndicator" value="<%= bIntakeIndicator %>" />
//*     </impact:include>
//*
//*  where bIntakeIndicator has been set to a value of 'N' or 'Y'
//*
//*  Note: If the intakeIndicator attribute is not included, an error will be displayed.
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*  12/11/02  Heather Dean      Initial jsp creation
//*
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistoryConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation" %>

<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<% BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

CINV25SO cinv25so = (CINV25SO) state.getAttribute( "CINV25SO", request );

ROWCINV25SOG00_ARRAY rowArray = cinv25so.getROWCINV25SOG00_ARRAY();

Enumeration nameEnumeration1 = rowArray.enumerateROWCINV25SOG00();

String includingFormName = (String) request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );

// Get the page mode that was passed to the submodule by the including JSP.
String pageMode = (String)state.getAttribute( NameHistorySubmoduleConversation.PAGE_MODE_KEY, request );

int loopCount = 0;

String tabindexString = (String) request.getAttribute( "tabIndex" );
int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
%>

<script type="text/javascript" language="JavaScript1.2">

window.onload = function ()
{
  <%= includingFormName %>.isAdd.value = "";
};

function launchDetail( index )
{
  <%= includingFormName %>.arrayIndex.value = index;
  // to prevent isAdd=true carried over when user first clicked Add then Back then clicks on a Name hyperlink
  // causong blank page to display;
  // found when fixing STGAP00004856
  <%= includingFormName %>.isAdd.value = "";
  // end STGAP00004856
  disableValidation( '<%= includingFormName %>' );
  submitValidateForm('<%= includingFormName %>', '/person/NameHistory/displayNameHistoryDetail');
}

function addDetail()
{
  <%= includingFormName %>.isAdd.value = "true";
  return true;
}
</script>


<impact:validateInput type="hidden" name="arrayIndex" value=""/>
<impact:validateInput type="hidden" name="isAdd" />

<impact:ExpandableSectionTag name="NameHistory" id="nameHistoryItem_0" label="Name History" tabIndex="<%= tabIndex++ %>" >

<div id="scrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">

<table width="100%" cellspacing="0" cellpadding="3" border="0">
<tr>
 <th class="thList">Primary</th>
 <th class="thList">Invalid</th>
 <th class="thList">Name</th>
 <th class="thList">Suffix</th>
 <th class="thList">Start Date</th>
 <th class="thList">End Date</th>
</tr>
<%

ROWCINV25SOG00 nameRow = null;
if( !FormValidation.pageHasErrorMessages( request ))
{
  if ( !nameEnumeration1.hasMoreElements() )
  {
%>
    <tr class="odd">
      <td colspan="7">
       <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
      </td>
    </tr>
<%
  }
  else
  {
    while( nameEnumeration1.hasMoreElements() )
    {
      nameRow = (ROWCINV25SOG00) nameEnumeration1.nextElement();
%>
      <tr class="<%=FormattingHelper.getRowCss( loopCount + 1)%>">
      <td align="center">
<%
      if("Y".equals(nameRow.getBIndNamePrimary()) )
      {
%>
        <img alt="checkmark" src="/grnds-docs/images/shared/checkMark_short.gif" >
<%    }
%>
      </td>

      <td align="center">
<%      if("Y".equals(nameRow.getBIndNameInvalid()) )
        {
%>
           <img alt="checkmark" src="/grnds-docs/images/shared/checkMark_short.gif" >
<%      }
%>
      </td>
<%    String first = "";
      String middle = "";
      String last = "";
      if ( !"".equals(nameRow.getSzNmNameLast()) )
      {
        last = nameRow.getSzNmNameLast();
      }
      if ( !"".equals(nameRow.getSzNmNameFirst()) )
      {
        first = ", "+nameRow.getSzNmNameFirst();
      }
      if ( !"".equals(nameRow.getSzNmNameMiddle()) )
      {
        if ("".equals(first) )
        {
          middle = ", "+nameRow.getSzNmNameMiddle();
        }
        else
        {
          middle = " "+nameRow.getSzNmNameMiddle();
        }
      }
      String fullName = last + first + middle;
      String listItemId = "nameHistoryItem_" + loopCount; %>
      <td><a href="javascript:launchDetail(<%= loopCount %>)"
         tabIndex="<%= tabIndex %>" id="<%= listItemId %>"><%= fullName %></a>
      </td>
      <td><%= Lookup.simpleDecodeSafe( CodesTables.CSUFFIX, nameRow.getSzCdNameSuffix() ) %>
      </td>
      <td><%= FormattingHelper.formatDate( nameRow.getDtDtNameStartDate() ) %></td>
      <td><%= FormattingHelper.formatDate( nameRow.getDtDtNameEndDate() ) %></td>
      </tr>
<%
      loopCount++;
    } // end while enumeration has more elements
  } //end big else
} // end !FormValidation.pageHasErrorMessages
%>
  </table>
</div>

<%
if ( !pageMode.equals( PageModeConstants.VIEW ) )
{%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td align="right">
        <impact:ButtonTag
                name="btnAddNewName"
                restrictRepost ="true"
                navAwayCk="true"
                img="btnAdd"
                align="right"
                form="<%= includingFormName %>"
                function="return addDetail();"
                action="/person/NameHistory/addName"
                tabIndex="<%= tabIndex %>"/>
      </td>
    </tr>
  </table>
<%
}
%>
</impact:ExpandableSectionTag>


