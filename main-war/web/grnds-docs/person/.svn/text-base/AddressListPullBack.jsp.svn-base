<%
/** JSP Name:     AddressListPullBack.jsp
 *  Created by:   ?
 *  Date Created: ??
 *
 *  Description:
 *  The Address Pullback List portion of the Address List/Detail Sub-module
 *  exists in the modify mode only.  It will provide a facility for users to
 *  copy addresses for persons sharing an address, such as the multiple members
 *  of families involved together in an IMPACT stage context.  The information
 *  list will be a child page of the Address Detail page.  This page is a
 *  replacement for the existing copy/paste utility in CAPS.
 *  The Address Pullback List will display the active phone numbers of all
 *  persons in the stage of the current person.  Each Pullback List row displays
 *  the Full Name of a person in the stage and will contain a checkmark
 *  indicator if it is the Primary address for the person, address Type, Street,
 *  and City.  Selecting a row and clicking the Continue pushbutton will return
 *  the user to the Address Detail page with the details of the selected row
 *  populating the appropriate fields.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Added Flowerbox and Change Log.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.List"%>

<%@ page import="org.grnds.facility.log.GrndsTrace" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.person.AddressValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressDetailConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  String TRACE_TAG = "displayAddressListPullBack.jsp";
  int tabIndex = 1;
//  String szCReqFuncCd = "";
  String pageMode = PageModeConstants.EDIT;
//  String rowCss = "altColor";
  String txtSzAddrPersAddrAttn = "";
  String txtSzCdPersAddrLinkType = "";
  String txtDtDtPersAddrLinkStart = "";
  String txtDtDtPersAddrLinkEnd = "";
  String bIndPersAddrLinkPrimary = "";
  String bIndPersAddrLinkInvalid = "";

  GrndsTrace.msg(TRACE_TAG, 10, "inside AddressListPullBack.jsp \n" );

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  List addressList = (List)state.getAttribute(AddressDetailConversation.ADDRESS_LIST_PULLBACK, request);
  //pageMode = PageMode.getPageMode(request);
  pageMode = GlobalData.getAppMode(request);
  GrndsTrace.msg( TRACE_TAG, 10,  "AddressPullBack.jsp_PageMode :\n" + pageMode );

  GrndsTrace.msg( TRACE_TAG, 10,  "request.getParameter(txtSzAddrPersAddrAttn) is: " + request.getParameter("txtSzAddrPersAddrAttn") );

  if( request.getParameter("txtSzAddrPersAddrAttn") != null )
  {
    txtSzAddrPersAddrAttn = request.getParameter("txtSzAddrPersAddrAttn");
  }
  if( request.getParameter("selSzCdPersAddrLinkType") != null )
  {
    txtSzCdPersAddrLinkType = request.getParameter("selSzCdPersAddrLinkType");
  }
  if( request.getParameter("txtDtDtPersAddrLinkStart") != null )
  {
    txtDtDtPersAddrLinkStart = request.getParameter("txtDtDtPersAddrLinkStart");
  }
  if( request.getParameter("txtDtDtPersAddrLinkEnd") != null )
  {
    txtDtDtPersAddrLinkEnd = request.getParameter("txtDtDtPersAddrLinkEnd");
  }
  if( request.getParameter("cbxBIndPersAddrLinkPrimary") != null )
  {
    bIndPersAddrLinkPrimary = request.getParameter("cbxBIndPersAddrLinkPrimary");
  }
  if( request.getParameter("cbxBIndPersAddrLinkInvalid") != null )
  {
    bIndPersAddrLinkInvalid = request.getParameter("cbxBIndPersAddrLinkInvalid");
  }

%>

<title>Address PullBack List</title>
<script type="text/javascript" language="JavaScript1.2">

/*
*This function submits the form to bring up address detail page.
*/
function submitFormToAddressDetail()
{
  var x = document.frmAddressListPullBack;
  x.cReqFuncCd.value = "C";
  enableValidation( "frmAddressListPullBack" );
  return true;
}

function setRow( type , attn )
{
  var x = document.frmAddressListPullBack;
  x.txtSzAddrPersAddrAttn.value = attn;
  x.selSzCdPersAddrLinkType.value = type;
}

</script>

<impact:validateErrors/>
<impact:validateForm name="frmAddressListPullBack"
       method="post"
       defaultButton="true"
       validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.AddressListPullBackCustomValidation"
       action="/person/AddressDetail/addressDetail"
       schema="/WEB-INF/Constraints.xsd"
       pageMode="<%=pageMode%>">

<impact:validateInput type="hidden" name="indexNum" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="cReqFuncCd" editableMode="<%=EditableMode.EDIT%>" value="C" />
<impact:validateInput type="hidden" name="txtDtDtPersAddrLinkStart" value="<%=txtDtDtPersAddrLinkStart%>" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="txtDtDtPersAddrLinkEnd"  value="<%=txtDtDtPersAddrLinkEnd%>" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="txtSzAddrPersAddrAttn"  value="" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="cbxBIndPersAddrLinkPrimary" value="<%=bIndPersAddrLinkPrimary%>" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="cbxBIndPersAddrLinkInvalid" value="<%=bIndPersAddrLinkInvalid%>" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="selSzCdPersAddrLinkType" value="" editableMode="<%=EditableMode.EDIT%>" />


<table border="0" cellspacing="0" cellpadding="3" width="750" class="tableBorder">

      <tr>
      <th class="thList">Full Name</th>
      <th class="thList">Primary</th>
      <th class="thList">Type</th>
      <th class="thList">Street</th>
      <th class="thList">City</th>
      <th class="thList">State</th>
      </tr>
  <%
    GrndsTrace.msg( TRACE_TAG, 10,  "AddressPullBack.jsp_before_addressRow :\n" );

      AddressValueBean addressRow = null;
      int iLoopCounter = 0;
        GrndsTrace.msg( TRACE_TAG, 10,  "AddressPullBack.jsp_inside_if :\n" );
        if ( addressList == null)
        {%>
          <tr class="odd">
            <td colspan="9">
            <%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %>
            </td>
          </tr>
       <%}
        else
        {
          for (iLoopCounter = 0; iLoopCounter < addressList.size(); iLoopCounter++)
          {
            addressRow = (AddressValueBean) addressList.get(iLoopCounter);
          %>
           <tr class="<%=FormattingHelper.getRowCss( iLoopCounter + 1 )%>" valign="top">
           <%
           String setRow = "setRow('" + addressRow.getAddressType() + "' , '" + FormattingHelper.formatString( addressRow.getAttention() ) + "');";
           %>
           <td><impact:validateInput type="radio" name="rbAddressRadioIndex" value="<%= String.valueOf( iLoopCounter ) %>" onClick="<%=setRow  %>" tabIndex="<%= tabIndex++ %>"/><%=addressRow.getPeronFullName()%></td>
           <td align="center"><%if( addressRow.getPrimary().compareToIgnoreCase("Y") == 0 ){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
           <td><%=Lookup.simpleDecodeSafe("CADDRTYP", addressRow.getAddressType() )%>&nbsp;</td>
           <td><%=addressRow.getStreetLn1()%>
           <td><%=addressRow.getCity()%>
           <td><%=addressRow.getState()%>
           </tr>
          <%
          } // end for
        }// end else

  %>

  </table>
   <table width="760">
       <td align="right">
       <impact:ButtonTag name="btnContinue" img="btnContinue" function="return submitFormToAddressDetail();" form="frmAddressListPullBack" action="/person/AddressDetail/addressDetail" tabIndex="<%= tabIndex++ %>"/>
       </td>
   </table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

