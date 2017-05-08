<%
/**
 * JSP Name:     Subcontractor List Submodule
 * Code shamelessly stolen by:   Wes Thompson
 * Date Created: 11/05/02
 *
 * Description:
 * This JSP serves to display the subcontractor list and to access the
 * Subcontractor Detail page to maintain subcontractor details.
**/
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/01/03  Todd Reser        Moved Flowerbox and Changelog to top of file.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Date" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="java.util.Enumeration" %>


<script type="text/JavaScript" language="JavaScript1.2">
<%
  String SubcontractorSubvfacilityNumber = (String)request.getAttribute( "SubcontractorSubvfacilityNumber" );
  String SubcontractorSubvfacilityType = (String) request.getAttribute("SubcontractorSubvfacilityType");
  String SubcontractorSubvresourceId = (String)request.getAttribute( "SubcontractorSubvidResource" );
  String SubcontractorSubvviewOnly = (String)request.getAttribute( "SubcontractorSubvviewOnly" );

  Date tmpTsLastUpdate = null;
  String SubcontractorSubvtxtSzNmResource = "";
  String SubcontractorSubvindexNum = "";
  String SubcontractorSubvcReqFuncCd = "";
  String SubcontractorSubvtxtUIdRsrcLink = (String)request.getAttribute( "SubcontractorSubvtxtUIdRsrcLink" );
  String SubcontractorSubvtxtUIdRsrcLinkParent = (String)request.getAttribute( "SubcontractorSubvtxtUIdRsrcLinkParent" );
  String SubcontractorSubvchildPlacingAgency = "";
  String SubcontractorSubvaddSubContractorButtonHide = "false";
  String SubcontractorSubvdeleteSubContractorButtonHide = "false";
  String SubcontractorSubvclassResource = "false";

  String SubcontractorSubvpageMode = PageModeConstants.VIEW;
  String SubcontractorSubvrowCss;

// Get tabIndex out of the request
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int tabIndex = tabindexString == null ? 1 : Integer.valueOf( tabindexString );

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );//SR-
  CCON15SO ccon15so_SubcontractorSub = (CCON15SO) state.getAttribute("CCON15S", request);

  ROWCCON15SOG00_ARRAY SubcontractorSubvsubcontractorArray = null;
  ROWCCON15SOG01_ARRAY SubcontractorSubvsubcontractorServiceArray = null;

  boolean SubcontractorSubvbViewOnly = StringHelper.isTrue(SubcontractorSubvviewOnly);

  if ( ccon15so_SubcontractorSub == null )
  {
    ccon15so_SubcontractorSub = new CCON15SO();
  }
  if ( ccon15so_SubcontractorSub.getROWCCON15SOG00_ARRAY() != null )
  {
    SubcontractorSubvsubcontractorArray = ccon15so_SubcontractorSub.getROWCCON15SOG00_ARRAY();
  }
  else
  {
    SubcontractorSubvsubcontractorArray = new ROWCCON15SOG00_ARRAY();
  }

  if (!StringHelper.isValid(SubcontractorSubvtxtUIdRsrcLinkParent))
  {
    SubcontractorSubvtxtUIdRsrcLinkParent = SubcontractorSubvresourceId;
  }

  if (!StringHelper.isValid(SubcontractorSubvfacilityType))
  {
    SubcontractorSubvpageMode = PageModeConstants.VIEW;
  }

  if (!StringHelper.isValid(SubcontractorSubvfacilityNumber))
  {
    SubcontractorSubvpageMode = PageModeConstants.VIEW;
  }

  // Get the form name out of the request
  String SubcontractorSubvincludingFormName = (String)request.getAttribute( IncludeTag.INCLUDING_FORM_NAME_KEY );
// **********************************************************************
// -- SECURITY CHECK --

// Get the page mode from the session state manager
if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request) != null )
{
  SubcontractorSubvpageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
}
//Set the Default page mode if none was passed in
if( (!StringHelper.isValid( SubcontractorSubvpageMode )) || SubcontractorSubvbViewOnly)
{
  SubcontractorSubvpageMode = PageModeConstants.VIEW;
  SubcontractorSubvaddSubContractorButtonHide = "true";
  SubcontractorSubvdeleteSubContractorButtonHide = "true";
}
else
{
  SubcontractorSubvaddSubContractorButtonHide = "false";
  SubcontractorSubvdeleteSubContractorButtonHide = "false";
}


if (StringHelper.isValid(SubcontractorSubvfacilityType))
{
  //If facility type is PRS F/A Homes or Private Agency Adoptive
  if( "70".equals(SubcontractorSubvfacilityType) || "71".equals(SubcontractorSubvfacilityType) )
  {
    SubcontractorSubvaddSubContractorButtonHide = "true";
    SubcontractorSubvdeleteSubContractorButtonHide = "true";
  }

  //If facility is a child placement agency
  if( "60".equals(SubcontractorSubvfacilityType) )
  {
    SubcontractorSubvchildPlacingAgency = "true";
    SubcontractorSubvaddSubContractorButtonHide = "true";
    SubcontractorSubvdeleteSubContractorButtonHide = "true";
  }
}
//If it's a CLASS resource
if( StringHelper.isValid(SubcontractorSubvfacilityNumber) )
{
  SubcontractorSubvclassResource = "true";
  SubcontractorSubvdeleteSubContractorButtonHide = "true";
}

// *******************************************************************

%>


function SubcontractorSubvsubmitFormToSubDetailWindow(SubcontractorSubvindexNum, SubcontractorSubvcReqFuncCd)
{
  <%=SubcontractorSubvincludingFormName%>.SubcontractorSubvcReqFuncCd.value = SubcontractorSubvcReqFuncCd;
  disableValidation( "<%=SubcontractorSubvincludingFormName%>" );

  if( SubcontractorSubvcReqFuncCd == 'A' )
  {
    return true;
  }
  if( SubcontractorSubvcReqFuncCd == 'U' )
  {
    <%=SubcontractorSubvincludingFormName%>.SubcontractorSubvindexNum.value = SubcontractorSubvindexNum;
    submitValidateForm( "<%=SubcontractorSubvincludingFormName%>", "/resource/SubcontractorSub/displaySubcontractorDetail" );
  }
}


function SubcontractorSubvsubmitFormToSubDelete()
{
  var numCheckBoxes = <%= SubcontractorSubvsubcontractorArray.getROWCCON15SOG00Count() %>;
  var x = document.<%=SubcontractorSubvincludingFormName%>;
  var affirmDelete;

  //Message to confirm a user wants to delete a subcontractor,
  //gives the user an alert if a row was not selected by the user.
  if ( !areAnyChecked( "SubcontractorSub_cbxSubcontractorCheckboxIndex_CLEAN", numCheckBoxes ) )
  {
    alert("<%= MessageLookup.getMessageByNumber(Messages.MSG_SELECT_ROW_ACTION) %>");
    return false;
  }
  else
  {
    affirmDelete = confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE) %>');
    if (affirmDelete)
    {
      <%=SubcontractorSubvincludingFormName%>.SubcontractorSubvcReqFuncCd.value = 'D';
      return true;
    }
   else
   {
     return false;
   }
  }
}
</script>

<% /*  Start ESD */ %>

<%-- hidden fields --%>
  <impact:validateInput type="hidden" name="SubcontractorSubvsubcontractorArray" value="<%=SerializationHelper.serializeObject( SubcontractorSubvsubcontractorArray ) %>"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvsubcontractorServiceArray" value="<%=SerializationHelper.serializeObject( SubcontractorSubvsubcontractorServiceArray )%>"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvindexNum"/>
  <impact:validateInput type="hidden" name="tmpTsLastUpdate"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvcReqFuncCd"/>
  <impact:validateInput type="hidden" name="WindowName" value="SubcontractorListSub"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvtxtUlIdResource" value="<%=SubcontractorSubvresourceId%>"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvtxtUIdRsrcLinkParent" value="<%=SubcontractorSubvresourceId%>"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvtxtUIdRsrcLink" value="<%=SubcontractorSubvtxtUIdRsrcLink%>"/>
  <impact:validateInput type="hidden" name="txtSzNmResource" value="<%=SubcontractorSubvtxtSzNmResource%>"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvclassResource" value="<%=SubcontractorSubvclassResource%>"/>
  <impact:validateInput type="hidden" name="SubcontractorSubvchildPlacingAgency" value="<%=SubcontractorSubvchildPlacingAgency%>"/>
  <impact:validateInput type="hidden" name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>" value="<%=SubcontractorSubvpageMode%>"/>
  <impact:validateInput type="hidden" editableMode="<%=EditableMode.EDIT%>" name="validationOverride"/>
<%-- /end hidden fields --%>
<% /* Begin Expandable Section with Detail */ %>

<impact:ExpandableSectionTag name="subcontractorListSubmodule" label="Service Site/Subcontractor List" tabIndex="<%= tabIndex %>">

<impact:pagination submitUrl="/resource/ResourceDetail/displayResourceDetail">

<div id="scroll3_sub" style="OVERFLOW: auto; WIDTH:100%; HEIGHT: 100px" class="tableborderList">


    <table border="0" cellspacing="0" cellpadding="3" width="100%" >
            <tr>
                <th class="thList">&nbsp;</th>
                <th class="thList">Resource Name</th>
                <th class="thList">Resource ID</th>
                <th class="thList">Service      </th>
            </tr>


<% //Variable to hold the css class for the each row in the lists
//String rowCss = "odd";
//int SubcontractorSubvloopCount = 0;
//int SubcontractorSubvsubcontractorCount = 0;
// end definitions

 Enumeration eSubcontractorSubvsubcontractorArray= SubcontractorSubvsubcontractorArray.enumerateROWCCON15SOG00();

 if (eSubcontractorSubvsubcontractorArray.hasMoreElements())
    {
    ROWCCON15SOG00 SubcontractorSubvsubcontractorRow = null;
   // int SubcontractorSubvsubcontractorArraySize = SubcontractorSubvsubcontractorArray.getUlRowQty( );
     int loopCount = 0;
     while (eSubcontractorSubvsubcontractorArray.hasMoreElements())
       {
     
        SubcontractorSubvsubcontractorRow =   (ROWCCON15SOG00) eSubcontractorSubvsubcontractorArray.nextElement();
        SubcontractorSubvrowCss = FormattingHelper.getRowCss( loopCount + 1 );
        String serviceCodeCategory = CodesTables.CGLSVCCD;
        if(Lookup.isValidCode(CodesTables.CSVCCODE, SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService())){
        	serviceCodeCategory = CodesTables.CSVCCODE;
        }
%>

<%if ( SubcontractorSubvbViewOnly )
  { %>
    <tr class="<%=SubcontractorSubvrowCss%>">
        <td><nobr></td>
        <td><nobr><%=SubcontractorSubvsubcontractorRow.getSzNmResource()%></td>
        <td><nobr><%=SubcontractorSubvsubcontractorRow.getUIdRsrcLinkChild()%></td>
        <td><nobr><%=Lookup.simpleDecodeSafe(serviceCodeCategory, SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService() )%></td>
    </tr>
<% }
   else
   {
%>
    <tr class="<%=SubcontractorSubvrowCss%>">
        <td><nobr><impact:validateInput type="checkbox" name='<%= "SubcontractorSub_cbxSubcontractorCheckboxIndex_CLEAN" + (loopCount+1) %>' value="<%=Integer.toString(loopCount)%>" tabIndex="<%= tabIndex %>"/></td>
        <td><nobr><a tabIndex="<%= tabIndex %>" href="javascript:SubcontractorSubvsubmitFormToSubDetailWindow( '<%=loopCount%>','U')"><%=SubcontractorSubvsubcontractorRow.getSzNmResource()%></a></td>
        <td><nobr><%=SubcontractorSubvsubcontractorRow.getUIdRsrcLinkChild()%></td>
        <td><nobr><%=Lookup.simpleDecodeSafe(serviceCodeCategory, SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService() )%></td>
    </tr>
<%}%>

<%
    loopCount=loopCount+1;
      }//end for
  }
  else
  {
    SubcontractorSubvdeleteSubContractorButtonHide ="true";
%>
  <tr class="odd">
    <td colspan="4"><%= MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) %></td>
  </tr>
<%  } %>
 </table>
</div>
</impact:pagination>

<table width="100%" cellpadding="3" cellspacing="0">
  <tr>
    <td  align="left" colspan="2">
      <impact:ButtonTag name="btnDeleteSubcontractorDetail" backSafe="true" disabled="<%=SubcontractorSubvdeleteSubContractorButtonHide%>" function="return SubcontractorSubvsubmitFormToSubDelete();" img="btnDelete" form="<%=SubcontractorSubvincludingFormName%>" action="/resource/SubcontractorSub/deleteSubcontractorDetail" tabIndex="<%= tabIndex %>"/>
    </td>
    <td align="right" colspan="3">
      <impact:ButtonTag name="btnAddSubcontractorDetail" disabled="<%=SubcontractorSubvaddSubContractorButtonHide%>" function="return SubcontractorSubvsubmitFormToSubDetailWindow( '','A');" img="btnAdd" align="right" form="<%=SubcontractorSubvincludingFormName%>" action="/resource/SubcontractorSub/displaySubcontractorDetail" tabIndex="<%= tabIndex %>"/>
    </td>
  </tr>
</table>
</impact:ExpandableSectionTag>

<% /*  End xpandDetailTable div */ %>
 <% /* End ESD */ %>

