<%
//*  JSP Name:     Name History Detail
//*  Created by:   Heather Dean
//*  Date Created: 12/11/02
//*
//*  Description:
//*  This JSP allows the user to maintain a person's name/alias (or A.K.A) list
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  12/11/02  Heather Dean      Initial jsp creation
//**
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistoryConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV25SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>

<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistorySubmoduleConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<!--Start Main Content-->
<% BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );%>

<impact:validateErrors />


<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script language="Javascript1.2">
// Check for changes before navigating off
window.onbeforeunload = function ()
{
  IsDirty();
};
</script>

<%
int tabIndex = 1;
boolean bIsPrimary = false;
boolean bDisablePrimary = false;
boolean bIsInvalid = false;
boolean bDisableInvalid = false;
boolean bHideEndDateButton = false;
boolean bDisableNameFields = false;
boolean bHideSaveButton = false;
boolean bHideEndDateField = false;
String firstName = "";
String middleName = "";
String lastName = "";
String suffix = "";
org.exolab.castor.types.Date today = DateHelper.toCastorDate( new java.util.Date() );
org.exolab.castor.types.Date startDate = today;
org.exolab.castor.types.Date endDate = null;
String tsLastUpdate = null;
String pageMode = null;
ROWCINV25SOG00_ARRAY rowArray = null;
String isAdd = "";
int arrayIndex = ContextHelper.getIntSafe( request, "arrayIndex" );

// Get the page mode that was passed to the Name History
// submodule by the including JSP.
pageMode = (String)state.getAttribute( NameHistorySubmoduleConversation.PAGE_MODE_KEY, request );

CINV25SO cinv25so = (CINV25SO) state.getAttribute( "CINV25SO", request );
if ( cinv25so != null)
{
  rowArray = cinv25so.getROWCINV25SOG00_ARRAY();

/**  if ( request.getAttribute("isAdd") != null )
  {
    isAdd = (String) request.getAttribute( "isAdd" ) ;
  }
*/

/**
 * Added by SR
 */
////////////////////////////////////////////////////////////////////////////////////////////////////
  if ( request.getParameter("isAdd") != null )
  {
    isAdd = request.getParameter( "isAdd" ) ;
  }

  if( ! "true".equals(isAdd) )
  {
     bDisableNameFields = true;
     ROWCINV25SOG00 selectedName = rowArray.getROWCINV25SOG00( arrayIndex );
     firstName = selectedName.getSzNmNameFirst();
     middleName = selectedName.getSzNmNameMiddle();
     lastName = selectedName.getSzNmNameLast();
     suffix = selectedName.getSzCdNameSuffix();
     startDate = selectedName.getDtDtNameStartDate();
     endDate = selectedName.getDtDtNameEndDate();
     if ( endDate != null )
     {
       bHideEndDateButton = true;
       bDisablePrimary = true;
     }
     if ("Y".equals(selectedName.getBIndNamePrimary()) ){
       bIsPrimary = true;
       bDisablePrimary = true;
       bDisableInvalid = true;
     }
     if ("Y".equals(selectedName.getBIndNameInvalid()) ){
       bIsInvalid = true;
     }
     if ( bIsPrimary && !bIsInvalid && ( endDate == null || DateHelper.MAX_CASTOR_DATE.equals(endDate)))
     {
       bDisableInvalid = true;
       bHideSaveButton = true;
       bHideEndDateButton = true;
       bHideEndDateField = true;
     }
     // STGAP00004856
     bIsPrimary = "Y".equals(selectedName.getBIndNamePrimary()) ? true : false;
     Boolean bIsEndDated = !DateHelper.isNull(endDate);
     // Enable Invalid check box and show Save button at all time if it has not been marked invalid
     if (bIsEndDated && bIsInvalid) {
       bDisableInvalid = true;
       bHideSaveButton = true;
     } else {
       bDisableInvalid = false;
       bHideSaveButton = false;
     }
     if (bIsPrimary || bIsEndDated) {
       bHideEndDateButton = true;
     } else {
       bHideEndDateButton = false;
     }
     if (!bIsPrimary && !bIsEndDated && !bIsInvalid) {
       bDisablePrimary = false;
     } else {
       bDisablePrimary = true;
     }
     // end STGAP00004856
  }
///////////////////////////////////////////////////////////////////////////////////////////////////////
} //end if cinv25so not null
%>

<impact:validateForm name="frmNameHistoryDetail"
          method="post"
          action="/person/NameHistory/saveNameHistory"
          validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.NameHistoryCustomValidation"
          pageMode="<%= pageMode %>"
          schema="/WEB-INF/Constraints.xsd">

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<impact:validateInput type="hidden" name="cinv25so_array" value="<%= SerializationHelper.serializeObject( rowArray ) %>"/>
<impact:validateInput type="hidden" name="isAdd" value="<%= isAdd %>"/>
<impact:validateInput type="hidden" name="arrayIndex" value="<%= FormattingHelper.formatInt(arrayIndex) %>"/>

<impact:validateInput type="hidden" name="hdnIsInvalid" value="<%= String.valueOf( bIsInvalid )%>"/>
<impact:validateInput type="hidden" name="hdnIsPrimary" value="<%= String.valueOf( bIsPrimary )%>"/>

   <table width="100%" class="tableborder" cellpadding="3" cellspacing="0">
        <tr>
          <th colspan="8">Name History Detail
        </th>
         <TR>
            <TD><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= firstName  %>"
                 type="text"
                 name="txtNameHistFirst"
                 label="First"
                 conditionallyRequired="true"
                 disabled="<%= String.valueOf( bDisableNameFields ) %>"
                 cssClass="formInput"
                 size="12"
                 maxLength="12"
                 constraint="Name12"/></TD>
            <TD><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= middleName  %>"
                 type="text"
                 name="txtNameHistMiddle"
                 label="Middle"
                 conditionallyRequired="false"
                 disabled="<%= String.valueOf( bDisableNameFields ) %>"
                 cssClass="formInput"
                 size="12"
                 maxLength="12"
                 constraint="Name12"/></TD>
            <TD><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= lastName  %>"
                 type="text"
                 name="txtNameHistLast"
                 label="Last"
                 conditionallyRequired="true"
                 disabled="<%= String.valueOf( bDisableNameFields ) %>"
                 cssClass="formInput"
                 size="22"
                 maxLength="22"
                 constraint="Name22"/></TD>
            <TD><impact:validateSelect
                 tabIndex="<%= tabIndex++ %>"
                 value="<%= suffix %>"
                 name="selNameHistSuffix"
                 label="Suffix"
                 disabled="<%= String.valueOf( bDisableNameFields ) %>"
                 codesTable="<%= CodesTables.CSUFFIX %>"
                 blankValue="true"/></TD>
        </TR>

        <tr>
            <td><impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 type="checkbox"
                 colspan="4"
                 checked="<%= String.valueOf( bIsPrimary ) %>"
                 disabled="<%= String.valueOf( bDisablePrimary ) %>"
                 name="cbxPrimary"
                 label="Primary"
                 cssClass="formInput" /></td>
            <td>
            <impact:validateInput
                 tabIndex="<%= tabIndex++ %>"
                 type="checkbox"
                 colspan="4"
                 checked="<%= String.valueOf( bIsInvalid ) %>"
                 disabled="<%= String.valueOf( bDisableInvalid ) %>"
                 name="cbxInvalid"
                 label="Invalid"
                 cssClass="formInput" /></td>
        </tr>

        <TR>
            <td><impact:validateDisplayOnlyField name="dspStartDate" label="Start Date"
                  value="<%= FormattingHelper.formatDate( startDate ) %>" /></td>
            <%if (!bHideEndDateField) {%>
            <td><impact:validateDisplayOnlyField name="dspEndDate" label="End Date"
                  value="<%= FormattingHelper.formatDate( endDate ) %>" /></td>
            <%}%>
            <td colspan="2">
            <% if ( !bHideEndDateButton && !PageMode.getPageMode( request ).equals( PageModeConstants.VIEW ) )
            {%>
            <a onClick="javascript:updateDisplayOnlyField( 'frmNameHistoryDetail', 'dspEndDate', '<%= FormattingHelper.formatDate( new java.util.Date() ) %>' )" tabIndex="<%=tabIndex++%>" >
              <img src="/grnds-docs/images/shared/btnSetEndDate.gif" class="md" border="0" >
            </a>
            <%}%>
            </td>
        </TR>
    </table>
    <%
    if ( !bHideSaveButton )
    {%>
      <table border="0" cellpadding="3" cellspacing="0" width="100%">
        <tr>
          <td align="right">
            <impact:ButtonTag
                    name="btnSave1"
                    img="btnSave"
                    form="frmNameHistoryDetail"
                    action="/person/NameHistory/saveNameHistory"
                    restrictRepost="true"
                    preventDoubleClick="true"
                    tabIndex="<%= tabIndex++ %>"/>
          </td>
        </tr>
      </table>
    <%
    }
    %>
</impact:validateForm>
