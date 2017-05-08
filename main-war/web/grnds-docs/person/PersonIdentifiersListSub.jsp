<%
/** JSP Name:     PersonIdentifiersListSub.jsp
 *  Created by:   Michael K. Werle
 *  Date Created: 12/09/02
 *
 *  Description:
 *  Person Identifiers is a sub-module that will appear as an expandable section
 *  on the including page.  Expanding the Person Identifiers section will
 *  display a list box containing all of the current identifier rows for a
 *  person in IMPACT.  An Add push button navigates to a Person Identifiers
 *  Detail page to add a new row.  Hyperlinks on the Type fields will navigate
 *  to the Person Identifiers Detail page for editing or viewing an individual
 *  row.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.

  08/26/03  thompswa          SIR 19542 Changed table div id="person-
                              IdentifiersScrollBar" to a set height to match
                              other submodules so that it doesn't get too long.
                              Also added class="subDetail" to "no rows" message.
  07/11/05  Merle A Demo      Added IndValidateByInterface for Sir23446, It shows
                           when and SSN was validated by the interface.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>

<%
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String localPageMode = (String) state.getAttribute(PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY, request);

  // Get tabIndex out of the request
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);


  // Get the including page's display commmand out of state
  String includingDisplayCommand = (String)state.getAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, request );

  // Get the form name out of the request
  String includingFormName = (String)request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );

  // Get cint14wlb_array out of the request
  CINT14WLB_ARRAY cint14wlb_array = (CINT14WLB_ARRAY)request.getAttribute( PersonIdentifiersConversation.CINT14WLB_ARRAY_KEY );

  UserProfile user = UserProfileHelper.getUserProfile( request );
%>

<script language="Javascript">
  function showPersonIDDetail( idPersonId )
  {
    <%=includingFormName%>.hdnUlIdPersonId.value = idPersonId;
    disableValidation('<%=includingFormName%>');
  }
</script>

<impact:ExpandableSectionTag name="personIdentifiersSubmodule" label="Person Identifiers" tabIndex="<%=tabIndex%>" >
  <%-- hidden fields --%>
  <impact:validateInput type="hidden" name="hdnIncludingPageDisplayCommand" value="<%=includingDisplayCommand%>" />
  <impact:validateInput type="hidden" name="hdnUlIdPersonId" />
  <%-- end hidden fields--%>
  <div id="personIdentifiersScrollBar" style="height:165; width:100%; overflow:auto" class="tableborderList">
    <table width="100%" cellspacing="0" cellpadding="3" border="0">
      <tr>
        <th class="thList">Invalid</th>
        <th class="thList">Type</th>
        <th class="thList">Number</th>
        <th class="thList">Start</th>
        <th class="thList">End</th>
  <!--<th class="thList">V</th>
        --><th class="thList">Comments</th>
      </tr>
      <%
        if( cint14wlb_array != null && cint14wlb_array.getCINT14WLBCount() > 0 )
        {
          int loopCount = 0;
          Enumeration cint14wlbEnum = cint14wlb_array.enumerateCINT14WLB();
          while( cint14wlbEnum.hasMoreElements() )
          {
            CINT14WLB cint14wlb = (CINT14WLB)cint14wlbEnum.nextElement();
            String numberType = cint14wlb.getSzCdPersonIdType();
            %>
            <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>">
              <td align="center">
                <%= ServiceConstants.FND_YES.equals( cint14wlb.getBIndPersonIDInvalid() ) ? "<image alt=\"checkmark\" src='/grnds-docs/images/shared/checkMark_short.gif'>" : "&nbsp;"%>
              </td>
              <td>
                      <a href="javascript:showPersonIDDetail(<%=cint14wlb.getUlIdPersonId()%>);submitValidateForm('<%=includingFormName%>','/person/PersonIdentifiers/displayPersonIdDetail');"
                         tabIndex="<%=tabIndex%>">
                        <%=FormattingHelper.formatString( numberType )%>
                      </a>
              </td>
              <td>
                <%
                  if( CodesTables.CNUMTYPE_SSN.equals( numberType ) )
                  {
                    %>
                    <%=FormattingHelper.formatSSN( cint14wlb.getSzNbrPersonIdNumber() )%>
                    <%
                  }
                  else
                  {
                    %>
                      <%=FormattingHelper.formatString( cint14wlb.getSzNbrPersonIdNumber() )%>
                    <%
                  }
                %>
              </td>
              <td>
                <%=FormattingHelper.formatDate( cint14wlb.getDtPersonIDStart() )%>
              </td>
              <td>
                <%=FormattingHelper.formatDate( cint14wlb.getDtPersonIDEnd() )%>
              </td>
         <!--<td align="center">
                <%= ServiceConstants.FND_YES.equals(cint14wlb.getBIndValidateByInterface() ) ? "<image alt=\"checkmark\" src='/grnds-docs/images/shared/checkMark_short.gif'>" : "&nbsp;"%>
              </td>
              --><td>
                <%=FormattingHelper.formatString( cint14wlb.getSzDescPersonID() )%>
              </td>
            </tr>
            <%
            loopCount++;
          }
        }
        else
        {
          %>
            <tr><td class="subDetail" colspan="6"><%=MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED )%></td></tr>
          <%
        }
      %>
    </table>
    </div>

<%

  if(!PageModeConstants.VIEW.equals(localPageMode))
  {
%>

    <table border="0" cellpadding="3" cellspacing="0" width="100%">
       <tr>
          <td align="right">
             <impact:ButtonTag
               name="btnAddFinal"
               img="btnAdd"
               align="right"
               restrictRepost="true"
               navAwayCk="true"
               tabIndex="<%=tabIndex%>"
               function="javascript:showPersonIDDetail( 0 )"
               form="<%=includingFormName%>"
               action="/person/PersonIdentifiers/addPersonIdDetail"
               editableMode="<%= EditableMode.ALL %>"/>
          </td>
       </tr>
    </table>


<%
  }
%>
</impact:ExpandableSectionTag>

