<%
/** JSP Name:     DisplayAddressList.jsp
 *  Created by:   ? (Habib maybe)
 *  Date Created: 02/05/03
 *
 *  General:
 *  ANY MODIFICATIONS MADE TO THIS FILE MUST BE REVIEWED IN FILE
 *  DisplayAddressList.jsp--Mobile FOR NECESSARY MOBILE CHANGES
 *
 *  Description:
 *  The Address List/Detail sub-module will provide an application-wide facility
 *  for users to store multiple addresses for persons (e.g., principles,
 *  collaterals, employees).  The information will be an expandable section on
 *  the including page and will display a list of the addresses for a given
 *  person with information on whether it is the primary address for the person,
 *  whether it is still valid, address type, the actual address, the Start Date,
 *  and the End Date.
 *  A row may be added by clicking the Add button at the bottom of the list.
 *  This will take the user to a blank address detail page to enter the desired
 *  information.  To Edit an address, the user will click the link in the
 *  Address Type column of the address list.  This will take the user to the
 *  Address Detail page with the information populated from the selected
 *  address.  This page allows a user to edit and delete the Phone Detail
 *  information.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  06/20/03  Todd Reser        SIR 18345 - Had to remove ++ from all occurances
                              of tabIndex because you aren't supposed to
                              increment tabIndex in submodules.  The browser
                              will handle the tab order of all items having the
                              same tabIndex.
  08/06/03  Todd Reser        Added Flowerbox.
  08/26/05  floresrj          SIR 23936 Modified to reconcile both IMPACT and Mobile versions.
                              Implemented Mobile Phase II changes in IMPACT.  The Mobile
                              version of DisplayAddressList.jsp  is scheduled to no longer be used
                              in the future, since the problem with submodules has been
                              resolved. ***** But until such notice, any changes to either
                              version must be duplicated in the other DisplayAddressList.jsp file *****.
  08/29/05  anandv            Added MOBILE-IMPACT comments at the General section.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="org.exolab.castor.types.Date" %>
<%@ page import="org.grnds.facility.log.GrndsTrace" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PlatformConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN42SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  /* Code to include this submodule:
  * impact:include page="/submodule/AddressListSubmodule/displayAddressList" callingPage=" " tabIndex="1" includingForm=" "
  * impact:attribute name="AddressListIncludePage" value=" WindowName "
  * impact:include
  * where WindowName can be set to a value of "STAFF_DETAIL_WINDOW"
  * or "ON_CALL_DETAIL_WINDOW"  or "" depending on which screen is including page
  */
  String TRACE_TAG = "displayAddressList.jsp";
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
  String szCReqFuncCd = "";
  String rowCss = "altColor";
  int MaxNumberOfAddress = 65;
  boolean bHideAddButton = false;
  boolean navAwayCk = StringHelper.isTrue( (String) request.getAttribute( ArchitectureConstants.SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME  ) );
  ROWCCMN42SOG00_ARRAY addressArray = null;

  // Since this is a submodule, it should use the page mode that
  // was passed to it from the including JSP.
  String pageMode = (String)state.getAttribute( AddressListConversation.PAGE_MODE_KEY, request );
  // Get the including page's form name and display command
  // and put them in state for redisplay
  String formName = (String)request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );
  if( formName != null )
  {
    state.setAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY, formName, request );
  }

  String includingPageDisplayURI = (String)request.getAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY );
  if( includingPageDisplayURI != null )
  {
    state.setAttribute( IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, includingPageDisplayURI, request );
  }

  CCMN42SO ccmn42so = (CCMN42SO)state.getAttribute(AddressListConversation.ADDRESS_LIST, request);
  if (ccmn42so.getROWCCMN42SOG00_ARRAY()== null )
  {
    addressArray = new ROWCCMN42SOG00_ARRAY();
  }
  else
  {
    addressArray = ccmn42so.getROWCCMN42SOG00_ARRAY();
    //Defect STGAP00000220:No Address Subsection exists on the Intake Person Detail page
    //Resolution:Check the addressArray is null or not.
    if (addressArray!= null)
    {
      bHideAddButton = addressArray.getUlRowQty() >= MaxNumberOfAddress;
    }
  }
%>

<title>Address</title>
<script type="text/javascript" language="JavaScript1.2">

/*
*This function submits the form to bring up address detail page.
*/
function submitFormToAddressDetail( indexNum, cReqFuncCd)
{
  setupFormForAddressDetail( indexNum, cReqFuncCd);
  submitValidateForm( "<%=formName%>", "/person/AddressDetail/addressDetail" );
}

/*
*  This function sets up the form information to be submitted.
*/
function setupFormForAddressDetail( indexNum, cReqFuncCd)
{
  var x = document.<%=formName%>;
  x.indexNum.value = indexNum;
  x.cReqFuncCd.value = cReqFuncCd;
  disableValidation( "<%=formName%>" );
}

</script>

<impact:validateInput type="hidden" name="indexNum" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="cReqFuncCd" editableMode="<%=EditableMode.EDIT%>" value="<%=szCReqFuncCd%>" />
<impact:validateInput type="hidden" name="txtUlIdPerson" value="25046278" editableMode="<%=EditableMode.EDIT%>" />

<impact:ExpandableSectionTag name="AddressList" id="lbAddressList_Id" label="Address" tabIndex="<%= tabIndex %>">
<div id="idAddressListScrollBar" style="height:165px;width:100%;overflow:auto" class="tableborderList">
<table border="0" cellspacing="0" cellpadding="3" width="100%">

      <tr>
      <th class="thList">Primary</th>
      <th class="thList">Invalid</th>
      <th class="thList">Type</th>
      <th class="thList">Street</th>
      <th class="thList">City</th>
      <th class="thList">State</th>
      <th class="thList">Start Date</th>
      <th class="thList">End Date</th>
      <!-- SIR 23936  -->
    <impact:ifServerImpact>
         <th class="thList">Comments</th>
    </impact:ifServerImpact>
      <impact:ifMobileImpact>
         <th class="thList">&nbsp;</th>
      </impact:ifMobileImpact>
      </tr>
  <%

      ROWCCMN42SOG00 addressRow = null;
      int iLoopCounter = 0;
      
    if( !FormValidation.pageHasErrorMessages( request ) )
    {
    //Defect STGAP00000220:No Address Subsection exists on the Intake Person Detail page
    //Resolution:Check the addressArray is null or not.
      if (addressArray == null || addressArray.getROWCCMN42SOG00Count() == 0  )
      {%>
        <tr class="odd">
          <td colspan="9">
           <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
          </td>
        </tr>
      <%}
      else
      {
        for (Enumeration e = addressArray.enumerateROWCCMN42SOG00(); e.hasMoreElements(); )
        {
          addressRow = (ROWCCMN42SOG00)e.nextElement();
  %>
          <tr class="<%=FormattingHelper.getRowCss( iLoopCounter + 1 )%>" valign="top">
          <td align="center"><%if( addressRow.getBIndPersAddrLinkPrimary().compareToIgnoreCase("Y") == 0 ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
          <td align="center"><%if( addressRow.getBIndPersAddrLinkInvalid().compareToIgnoreCase("Y") == 0 ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
          <!-- SIR 23936  -->
        <impact:ifServerImpact>
<% /* SIR 18345 - Had to add tabIndex to the a href */ %>
          <td><a href="javascript:submitFormToAddressDetail( '<%=iLoopCounter%>','U')"<% if ( !navAwayCk ) { %> onClick="setIsDirtyCalled( true );"<% } %> tabIndex="<%= tabIndex %>"><%=Lookup.simpleDecodeSafe("CADDRTYP", addressRow.getSzCdPersAddrLinkType() )%></a>&nbsp;</td>
          </impact:ifServerImpact>
          <impact:ifMobileImpact>
        <td><%=Lookup.simpleDecodeSafe("CADDRTYP", addressRow.getSzCdPersAddrLinkType() )%>&nbsp;</td>
          </impact:ifMobileImpact>
          <td><%=addressRow.getSzAddrPersAddrStLn1()%>
          <td><%=addressRow.getSzAddrCity()%>
          <td><%=addressRow.getSzCdAddrState()%>
          <td><%=FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkStart())%>
          <!-- SIR 23936  -->
        <impact:ifServerImpact>
          <td><%=FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkEnd())%>
          <td align="center"><%if( addressRow.getSzTxtPersAddrCmnts() != null && !"".equals(
                  addressRow.getSzTxtPersAddrCmnts()) ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
          </impact:ifServerImpact>
          <impact:ifMobileImpact>
          <%
            if ( addressRow.getDtDtPersAddrLinkEnd().toString().equals( DateHelper.MAX_CASTOR_DATE.toString() ) )
            {
          %>
             <td>&nbsp;</td>
         <% } else
              { %>
           <td><%=FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkEnd())%>
            <%}%>
          <td>&nbsp;</td>
          </impact:ifMobileImpact>
          </tr>
  <%
          iLoopCounter++;
        } // end for
      }// end if addressArray.getROWCCMN42SOG00Count() == 0
    } // end if !FormValidation.pageHasErrorMessages( request )
  %>

  </table>
</div>

<%
if ( !bHideAddButton && PageModeConstants.EDIT.equals( pageMode ) )
{%>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td align="right">
          <!-- SIR 23936  -->
        <impact:ifServerImpact>
        <impact:ButtonTag
                name="btnAdd"
                img="btnAdd"
                function="setupFormForAddressDetail('0', 'A');"
                form="<%=formName%>"
                action="/person/AddressDetail/addressDetail"
                navAwayCk="<%=navAwayCk%>"
                tabIndex="<%= tabIndex %>"/>
        </impact:ifServerImpact>
      </td>
    </tr>
  </table>
<%
}
%>
</impact:ExpandableSectionTag>

