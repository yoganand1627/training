<%
//*--------------------------------------------------------------------------------
//*  JSP Name:     Subcontractor Detail
//*  Created by:   Donald Wilson
//*  Date Created: 04/02/03
//*
//*  Description:
//*  This JSP displays the Subcontractor Details.
//*
//*  Change History:
//*  Date      User         Description
//*  --------  -----------  -------------------------------------------------------
//*  07/08/03  JRIOS        Added code to populate the 'Service' drop-down list with
//*                         the services provided by the Prime Resource because those
//*                         are the only ones that should be provided by the sub-
//*                         contractor.
//*--------------------------------------------------------------------------------
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON17SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  String SubcontractorSubvtmpSzNmResource = "";
  java.util.Date SubcontractorSubvtmpTsLastUpdate = null;
  String SubcontractorSubvtmpsubcontractorRowService = "";
  String SubcontractorSubvidIndex = "0";
  String SubcontractorSubvszCReqFuncCd = "";
  String SubcontractorSubvtmpUIdRsrcLinkChild = "";
  String SubcontractorSubvtmpUIdRsrcLink = "";
  String SubcontractorSubvtxtUIdRsrcLinkParent = "";
  String SubcontractorSubvtxtUlIdResource = "";
  String SubcontractorSubvclassResource = "false";
  String SubcontractorSubvfadResource = "false";
  String SubcontractorSubvchildPlacingAgency = "false";
  String SubcontractorSubvsubContractorIdDisable = "false";
  String SubcontractorSubvserviceDisable = "false";
  boolean SubcontractorSubvvalidateButtonHide = false;
  boolean SubcontractorSubvsaveButtonHide = false;
  boolean SubcontractorSubvdeleteButtonHide = false;
  ROWCCON15SOG01_ARRAY primeResourceSvcsArray = null;

  ROWCCON15SOG00_ARRAY SubcontractorSubvsubcontractorArray = null;
  ROWCCON15SOG00 SubcontractorSubvsubcontractorRow = null;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  String SubcontractorSubvpageMode = PageMode.getPageMode(request);

  if( StringHelper.isValid(request.getParameter( "SubcontractorSubvtxtUIdRsrcLinkParent" ) ) )
  {
    SubcontractorSubvtxtUIdRsrcLinkParent =  request.getParameter( "SubcontractorSubvtxtUIdRsrcLinkParent" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvselCdRsrcSvcService" ) ) )
  {
    SubcontractorSubvtmpsubcontractorRowService = request.getParameter( "SubcontractorSubvselCdRsrcSvcService" );
  }
  if( StringHelper.isValid(request.getParameter( "SubcontractorSubvindexNum" ) ) )
  {
    SubcontractorSubvidIndex = request.getParameter( "SubcontractorSubvindexNum" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvcReqFuncCd" ) ) )
  {
    SubcontractorSubvszCReqFuncCd = request.getParameter( "SubcontractorSubvcReqFuncCd" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtxtUlIdResource" ) ) )
  {
    SubcontractorSubvtxtUlIdResource = request.getParameter( "SubcontractorSubvtxtUlIdResource" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtxtNewIdResource" ) ) )
  {
    SubcontractorSubvtmpUIdRsrcLinkChild = request.getParameter( "SubcontractorSubvtxtNewIdResource" );
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvchildPlacingAgency" )) && StringHelper.isTrue(request.getParameter( "SubcontractorSubvchildPlacingAgency" )))
  {
    SubcontractorSubvchildPlacingAgency = "true";
  }
  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtmpSzNmResource" ))  )
  {
    SubcontractorSubvtmpSzNmResource = request.getParameter( "SubcontractorSubvtmpSzNmResource" );
  }

  if( StringHelper.isValid (request.getParameter( "SubcontractorSubvtxtTsLastUpdate" ))  )
  {
    if (SerializationHelper.deserializeObject(request.getParameter( "SubcontractorSubvtxtTsLastUpdate" )) != null)
    {
      SubcontractorSubvtmpTsLastUpdate = (java.util.Date) SerializationHelper.deserializeObject(request.getParameter( "SubcontractorSubvtxtTsLastUpdate" ));
    }
  }

  CCON17SO ccon17so_SubcontractorSub = (CCON17SO) request.getAttribute( "CCON17S_SubcontractorValidate" );
  request.removeAttribute( "CCON17S_SubcontractorValidate" );


  ROWCRES05SOG00_ARRAY SubcontractorSubvservicesStruct = (ROWCRES05SOG00_ARRAY) request.getAttribute( "ROWCRES05SOG00_ARRAY_subcontractorDetail" );
  int SubcontractorSubvserviceSize = 0;
  if( SubcontractorSubvservicesStruct != null )
  {
    SubcontractorSubvserviceSize = SubcontractorSubvservicesStruct.getROWCRES05SOG00Count();
  }
  String[] SubcontractorSubvservicesList = new String[SubcontractorSubvserviceSize];
  if( SubcontractorSubvservicesStruct != null )
  {
    //Loop through and get all services for the resource
    for(int i=0; i<SubcontractorSubvservicesStruct.getROWCRES05SOG00Count(); i++ )
    {
      SubcontractorSubvservicesList[i] = SubcontractorSubvservicesStruct.getROWCRES05SOG00(i).getSzCdRsrcSvcService();
    }
  }

  if( request.getParameter("SubcontractorSubvservicesArray") != null )
  {
    SubcontractorSubvservicesList = (String[])SerializationHelper.deserializeObject(request.getParameter("SubcontractorSubvservicesArray"));
  }

  CCON15SO ccon15so = (CCON15SO)state.getAttribute( "CCON15S", request );
  if (ccon15so != null)
  {
    SubcontractorSubvsubcontractorArray = ccon15so.getROWCCON15SOG00_ARRAY();

    if ("A".equalsIgnoreCase(SubcontractorSubvszCReqFuncCd))
    {
      SubcontractorSubvtmpSzNmResource = "";
      SubcontractorSubvtmpUIdRsrcLinkChild = null;
    }
    else
    {
      SubcontractorSubvsubcontractorRow = SubcontractorSubvsubcontractorArray.getROWCCON15SOG00(Integer.parseInt(SubcontractorSubvidIndex));

      if( SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService() != null )
      {
        SubcontractorSubvtmpsubcontractorRowService = SubcontractorSubvsubcontractorRow.getSzCdRsrcLinkService();
      }
      SubcontractorSubvtmpSzNmResource = SubcontractorSubvsubcontractorRow.getSzNmResource();
      SubcontractorSubvtmpUIdRsrcLinkChild = String.valueOf( SubcontractorSubvsubcontractorRow.getUIdRsrcLinkChild());
      SubcontractorSubvtmpUIdRsrcLink = String.valueOf(SubcontractorSubvsubcontractorRow.getUIdRsrcLink());
      SubcontractorSubvtmpTsLastUpdate =  SubcontractorSubvsubcontractorRow.getTsLastUpdate();
    }

    // SIR 18632, JRIOS - Retrieve the list of services provided
    // by the Prime Resource.
    if ( ccon15so.getROWCCON15SOG01_ARRAY() != null )
    {
      primeResourceSvcsArray = ccon15so.getROWCCON15SOG01_ARRAY();
    }
  }

  if (ccon17so_SubcontractorSub != null)
  {
    if( ccon17so_SubcontractorSub.getSzNmResource()!=null )
    {
      SubcontractorSubvtmpSzNmResource = ccon17so_SubcontractorSub.getSzNmResource();
    }
    SubcontractorSubvtmpUIdRsrcLinkChild = request.getParameter("SubcontractorSubvtxtNewIdResource");
  }

  if("A".equalsIgnoreCase(SubcontractorSubvszCReqFuncCd))
  {
    SubcontractorSubvdeleteButtonHide = true;
  }

  if( StringHelper.isTrue(SubcontractorSubvchildPlacingAgency) && "U".equalsIgnoreCase(SubcontractorSubvszCReqFuncCd) )
  {
    SubcontractorSubvsubContractorIdDisable = "true";
    SubcontractorSubvserviceDisable = "true";
    SubcontractorSubvdeleteButtonHide = true;
    SubcontractorSubvvalidateButtonHide = true;
    SubcontractorSubvsaveButtonHide = true;
  }
  else if("false".equalsIgnoreCase(SubcontractorSubvchildPlacingAgency) && "U".equalsIgnoreCase(
          SubcontractorSubvszCReqFuncCd) )
  {
    SubcontractorSubvsubContractorIdDisable = "true";
    SubcontractorSubvvalidateButtonHide = true;
  }

  if( SubcontractorSubvpageMode.equals(PageModeConstants.VIEW) )
  {
    SubcontractorSubvvalidateButtonHide = true;
    SubcontractorSubvdeleteButtonHide = true;
    SubcontractorSubvsaveButtonHide = true;
  }

  if( request.getParameter("SubcontractorSubvclassResource") != null && "true".equalsIgnoreCase(request.getParameter(
          "SubcontractorSubvclassResource")) )
  {
    SubcontractorSubvclassResource = "true";
    SubcontractorSubvdeleteButtonHide = true;
  }

  // Get tabIndex out of the request
  String tabindexString = (String)request.getAttribute( "tabIndex" );
  int SubcontractorSubvtabIndex = tabindexString == null ? 1 : Integer.valueOf(tabindexString);
%>

<%
//******************
//*** JAVASCRIPT ***
//******************
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
// This function is called when the page loads.
window.onload = function ()
{
  SubcontractorSubvpopulateServiceDropDown();
}

// This function is called before the page unloads.
window.onbeforeunload = function ()
{
    IsDirty();
}

<%
// SIR 18632, JRIOS - Added this JavaScript to create an array of
// the services provided by the Prime Resource. This array is used
// to populate the 'Service' drop-down list.
if( primeResourceSvcsArray != null )
{%>
  var SubcontractorSubvserviceCodesArray = new Array();
  <%
  int i = 0;
  Enumeration enumeration = primeResourceSvcsArray.enumerateROWCCON15SOG01();
  while( enumeration.hasMoreElements() )
  {
    ROWCCON15SOG01 service = (ROWCCON15SOG01)enumeration.nextElement();
    if("G".equalsIgnoreCase(service.getSzCdRsrcSvcServiceType())){
    %>
    SubcontractorSubvserviceCodesArray[<%=i%>] = "<%= service.getSzCdRsrcSvcService() %>" + "|" + "<%= Lookup.simpleDecodeSafe( CodesTables.CGLSVCCD, service.getSzCdRsrcSvcService() ) %>";
    <%
    }
    i++;
  }
}
%>

// This function is used to populate the 'Services' drop-down list.
function SubcontractorSubvpopulateServiceDropDown()
{
  var fieldName = "SubcontractorSubvselCdRsrcSvcService";
  if( document.SubcontractorSubvfrmSubcontractorDetail.SubcontractorSubvselCdRsrcSvcService.type != "select-one" )
  {
    fieldName = "SubcontractorSub_selCdRsrcSvcService_Disabled";
  }

  if( SubcontractorSubvserviceCodesArray != null )
  {
    eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".options.length = SubcontractorSubvserviceCodesArray.length + 1;");
    for( var j=0; j < SubcontractorSubvserviceCodesArray.length; j++)
    {
      // Populates the drop-down list with the values from the serviceCodesArray.
      eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".options[j].value = SubcontractorSubvserviceCodesArray[j].substring(0,SubcontractorSubvserviceCodesArray[j].indexOf(\"|\"));");
      eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".options[j].defaultSelected = false");
      eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".options[j].text = SubcontractorSubvserviceCodesArray[j].substring(SubcontractorSubvserviceCodesArray[j].indexOf(\"|\")+1,SubcontractorSubvserviceCodesArray[j].length);");
    }

    eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".value = \"<%=SubcontractorSubvtmpsubcontractorRowService%>\"");
    if( eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".selectedIndex != -1") )
    {
      eval("document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".options[document.SubcontractorSubvfrmSubcontractorDetail."+fieldName+".selectedIndex].defaultSelected = true");
    }
  }
}

// This function is used to save subcontractor detail.
function SubcontractorSubvsubmitSubcontractorDetail()
{
  var doSave = false;

   window.onbeforeunload = null;
   var x = document.SubcontractorSubvfrmSubcontractorDetail;
   if( x.SubcontractorSubvtmpSzNmResource.value != null &&
       x.SubcontractorSubvtmpSzNmResource.value != "" &&
       x.SubcontractorSubvtxtUIdRsrcLinkChild.value != "" )
   {
     x.SubcontractorSubvtxtNewIdResource.value = x.SubcontractorSubvtxtUIdRsrcLinkChild.value;
     doSave = true;
   }
   else
   {
      if ( x.SubcontractorSubvtxtUIdRsrcLinkChild.value != "" )
      {
        setInformationalMessage("<%=MessageLookup.getMessageByName("SSM_VALIDATE_SUBCONTRACTOR")%>");
      }else
      {
        setInformationalMessage("Please enter a Subcontractor Id and validate.");
      }
   }

   return doSave;
}

// This function is used to submit the form to validate the subcontractor id.
function SubcontractorSubvvalidateSubContractor()
{
  window.onbeforeunload = null;
  var x = document.SubcontractorSubvfrmSubcontractorDetail;
  disableValidation('SubcontractorSubvfrmSubcontractorDetail');
  x.SubcontractorSubvtxtNewIdResource.value = x.SubcontractorSubvtxtUIdRsrcLinkChild.value;
  return true;
}

// This function is used to submit the form to delete a subcontractor record.
function SubcontractorSubvdeleteSubcontractorRow()
{
  var doDelete = false;

  window.onbeforeunload = null;
  var cnfrm = window.confirm("<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>");
  if(cnfrm)
  {
    document.SubcontractorSubvfrmSubcontractorDetail.SubcontractorSubvcReqFuncCd.value = 'D';
    disableValidation('SubcontractorSubvfrmSubcontractorDetail');
    doDelete = true;
  }

  return doDelete;
}
//End Java Script-->
</script>


<impact:validateForm name="SubcontractorSubvfrmSubcontractorDetail"
   method="post"
   action="/resource/ResourceDetail/saveSubcontractorDetail"
   pageMode="<%=SubcontractorSubvpageMode%>"
   schema="/WEB-INF/Constraints.xsd">
     <impact:validateInput type="hidden" name="SubcontractorSubvtxtUIdRsrcLinkParent" value="<%=SubcontractorSubvtxtUIdRsrcLinkParent%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvtxtUIdRsrcLink" value="<%=SubcontractorSubvtmpUIdRsrcLink%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvtxtUlIdResource" value="<%=SubcontractorSubvtxtUlIdResource%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvindexNum" value="<%=SubcontractorSubvidIndex%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvrbSubcontractorCheckboxIndex" value="<%=SubcontractorSubvidIndex%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvtxtTsLastUpdate" value="<%=SerializationHelper.serializeObject(SubcontractorSubvtmpTsLastUpdate)%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvtxtNewIdResource" />
     <impact:validateInput type="hidden" name="SubcontractorSubvcReqFuncCd" value="<%=SubcontractorSubvszCReqFuncCd%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvvalidationOverride" />
     <impact:validateInput type="hidden" name="SubcontractorSubvclassResource" value="<%=SubcontractorSubvclassResource%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvfadResource" value="<%=SubcontractorSubvfadResource%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvchildPlacingAgency" value="<%=SubcontractorSubvchildPlacingAgency%>"/>
     <impact:validateInput type="hidden" name="SubcontractorSubvservicesArray" value="<%=SerializationHelper.serializeObject(SubcontractorSubvservicesList)%>"/>


  <impact:validateErrors formName="SubcontractorSubvfrmSubcontractorDetail"/>

  <table width="100%" class="tableborder" cellSpacing="0" cellPadding="3" border="0">
    <tr>
      <th colspan="2">Service Site/Subcontractor Detail</th></tr>
      <tr>
        <td width="20%">
          <impact:validateInput type="text"
                                label="Resource ID"
                                size="10"
                                maxLength="10"
                                name="SubcontractorSubvtxtUIdRsrcLinkChild"
                                id="SubcontractorSub_txtUIdRsrcLinkChild_Id"
                                required="true"
                                disabled="<%=SubcontractorSubvsubContractorIdDisable%>"
                                value="<%=SubcontractorSubvtmpUIdRsrcLinkChild%>"
                                constraint="ID"
                                tabIndex="<%=SubcontractorSubvtabIndex%>"/>
          <%
          if ( !SubcontractorSubvvalidateButtonHide )
          {%>
            &nbsp;&nbsp;
            <impact:ButtonTag name="SubcontractorSubvbtnValidateSubcontractorRow"
                              img="btnValidate"
                              restrictRepost="true"
                              navAwayCk="true"
                              editableMode="<%= EditableMode.EDIT %>"
                              function="return SubcontractorSubvvalidateSubContractor();"
                              form="SubcontractorSubvfrmSubcontractorDetail"
                              action="/resource/SubcontractorSub/validateSubcontractorId"
                              tabIndex="<%=SubcontractorSubvtabIndex%>"/>
          <%}%>
        </td>
      </tr>
      <tr>
        <td>
          <impact:validateDisplayOnlyField label="Resource Name"
                                          name="SubcontractorSubvtmpSzNmResource"
                                          value="<%=SubcontractorSubvtmpSzNmResource%>" />
        </td>
      </tr>
      <tr>
        <td>
          <impact:validateSelect name="SubcontractorSubvselCdRsrcSvcService"
                                 label="Service"
                                 required="false"
                                 id="SubcontractorSub_selCdRsrcSvcService_Id"
                                 disabled="<%=SubcontractorSubvserviceDisable%>"
                                 tabIndex="<%=SubcontractorSubvtabIndex%>"
                                 style="WIDTH: 180px" />
        </td>
    </tr>
  </table>

  <table width="100%" cellSpacing="0" cellPadding="3" border="0">
    <tr>
      <td align="left">
        <%if( !SubcontractorSubvdeleteButtonHide ){%>
          <impact:ButtonTag name="SubcontractorSubvbtnDeleteSubcontractorRow"
                            img="btnDelete"
                            navAwayCk="true"
                            restrictRepost="true"
                            align="left"
                            editableMode="<%= EditableMode.EDIT %>"
                            function="return SubcontractorSubvdeleteSubcontractorRow();"
                            form="SubcontractorSubvfrmSubcontractorDetail"
                            action="/resource/SubcontractorSub/deleteSubcontractorDetail"
                            tabIndex="<%=SubcontractorSubvtabIndex%>"/>
        <%} else {%>
          &nbsp;
        <%}%>
      </td>
      <td align="right">
        <% if( !SubcontractorSubvsaveButtonHide ){%>
          <impact:ButtonTag name="SubcontractorSubvbtnSaveSubcontractorRow"
                            img="btnSave"
                            restrictRepost="true"
                            align="right"
                            editableMode="<%= EditableMode.EDIT %>"
                            function="return SubcontractorSubvsubmitSubcontractorDetail();"
                            form="SubcontractorSubvfrmSubcontractorDetail"
                            action="/resource/SubcontractorSub/saveSubcontractorDetail"
                            tabIndex="<%=SubcontractorSubvtabIndex%>"/>
        <%} else {%>
          &nbsp;
        <%}%>
      </td>
    </tr>
  </table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
