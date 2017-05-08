<%
/**
 * JSP Name:     SubcontractorDetail.jsp
 * Created by:   lingamnr
 * Date Created: 08/22/02
 *
 * Description:
 * The Subcontractor Detail page will display detailed information for the
 * subcontractor selected on the Resource Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
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
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  String TRACE_TAG = "DisplaySubcontractorDetail.jsp";
  String tmpSzNmResource = "";
  Date tmpTsLastUpdate = null;
  String tmpsubcontractorRowService = "";
  String idIndex = "0";
  String szCReqFuncCd = "";
  String tmpUIdRsrcLinkChild = "";
  String tmpUIdRsrcLink = "";
  String tmpcReqFuncCd = "";
  String txtuIdRsrcLinkParent = "";
  String txtUlIdResource = "";
  String classResource = "false";
  String fadResource = "false";
  String childPlacingAgency = "false";
  //String pageMode = PageMode.VIEW;

  String subContractorIdDisable = "false";
  String serviceDisable = "false";
  boolean validateButtonHide = false;
  boolean saveButtonHide = false;
  boolean deleteButtonHide = false;

  ROWCCON15SOG00_ARRAY subcontractorArray = null;
  ROWCCON15SOG01_ARRAY subcontractorServiceArray = null;
  ROWCCON15SOG00 subcontractorRow = null;
  ROWCCON15SOG01 subcontractorRowService = null;
  int isubcontractorServiceArraySize = 0;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );

  String pageMode = PageMode.getPageMode(request);

  if( request.getParameter( "cReqFuncCd" ) != null )
  {
    szCReqFuncCd = request.getParameter( "cReqFuncCd" );
  }

  CCON17SO ccon17so = (CCON17SO) request.getAttribute( "CCON17S_SubcontractorValidate" );
  if ( ccon17so == null )
  {
    ccon17so = new CCON17SO();
  }
  CCON15SO ccon15so = (CCON15SO) state.getAttribute( "CCON15S_resourceDetail", request );//SR-

  ROWCRES05SOG00_ARRAY servicesStruct = (ROWCRES05SOG00_ARRAY) request.getAttribute( "ROWCRES05SOG00_ARRAY_subcontractorDetail" );
  int serviceSize = 0;
  if( servicesStruct != null )
  {
    serviceSize = servicesStruct.getUlRowQty();
  }
  String[] servicesList = new String[serviceSize];
  if( servicesStruct != null )
  {
    //Loop through and get all services for the resource
    for(int i=0; i<servicesStruct.getUlRowQty(); i++ )
    {
      servicesList[i] = servicesStruct.getROWCRES05SOG00(i).getSzCdRsrcSvcService();
    }
  }


 if( request.getParameter("servicesArray") != null )
  {
    servicesList = (String[])SerializationHelper.deserializeObject(request.getParameter("servicesArray"));
  }

  if (ccon15so != null)
  {
    subcontractorArray = ccon15so.getROWCCON15SOG00_ARRAY();
    subcontractorServiceArray = ccon15so.getROWCCON15SOG01_ARRAY();
    if ("A".equalsIgnoreCase(szCReqFuncCd) )
    {
      tmpSzNmResource = "";
      tmpUIdRsrcLinkChild = null;
    }
    else
    {
      subcontractorRow = subcontractorArray.getROWCCON15SOG00( Integer.parseInt( idIndex ) );
      if( subcontractorRow.getSzCdRsrcLinkService() != null )
      {
        tmpsubcontractorRowService = subcontractorRow.getSzCdRsrcLinkService();
      }
      tmpSzNmResource = subcontractorRow.getSzNmResource();
      tmpUIdRsrcLinkChild = String.valueOf( subcontractorRow.getUIdRsrcLinkChild());
      tmpUIdRsrcLink = String.valueOf(subcontractorRow.getUIdRsrcLink());
      tmpTsLastUpdate = subcontractorRow.getTsLastUpdate();
    }
  }

  if (ccon17so != null)
  {
    if( ccon17so.getSzNmResource()!=null )
    {
      tmpSzNmResource = ccon17so.getSzNmResource();
    }
    tmpUIdRsrcLinkChild = request.getParameter("txtNewIdResource");
  }

  if("A".equalsIgnoreCase(szCReqFuncCd))
  {
    deleteButtonHide = true;
  }
  if("true".equalsIgnoreCase(childPlacingAgency) && "U".equalsIgnoreCase(szCReqFuncCd) )
  {
    subContractorIdDisable = "true";
    serviceDisable = "true";
    deleteButtonHide = true;
    validateButtonHide = true;
    saveButtonHide = true;
  } else if("false".equalsIgnoreCase(childPlacingAgency) && "U".equalsIgnoreCase(szCReqFuncCd) )
  {
    subContractorIdDisable = "true";
    validateButtonHide = true;
  }
  if( pageMode.equals(PageModeConstants.VIEW) )
  {
    validateButtonHide = true;
    deleteButtonHide = true;
    saveButtonHide = true;
  }

  if( request.getParameter("classResource") != null && "true".equalsIgnoreCase(request.getParameter("classResource")) )
  {
    classResource = "true";
    deleteButtonHide = true;
  }

  int tabIndex = 1;

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<SCRIPT LANGUAGE=JavaScript>
var serviceCodesArray = new Array();
<%
if( servicesList != null && servicesList.length > 0 )
{
  servicesList = StringHelper.removeDuplicates( servicesList );
  for( int i = 0; i < servicesList.length; i++ )
  {
    %>
    serviceCodesArray[<%=i%>] = '<%=servicesList[i]%>'+'|'+ '<%=Lookup.simpleDecodeSafe("CSVCCODE", servicesList[i] )%>';
    <%
  }
}
else{
%>
  serviceCodesArray = null;
<%}%>

 /*
  * This function is called when the page loads.
  */
  window.attachEvent('onload', populateDD );
  function populateDD()
  {
    populateServiceDropDown();
  }

 /*
  * This function is called before the page unloads.
  */
  window.attachEvent('onbeforeunload', populateDD );
  function setDirty()
  {
    IsDirty();
  }


 /*
  *This function is used to populate the services drop down.
  */
function populateServiceDropDown()
{
  var fieldName = "selCdRsrcSvcService";
  if( document.frmSubcontractorDetail.selCdRsrcSvcService.type != "select-one" )
  {
    fieldName = "selCdRsrcSvcService_Disabled";
  }
  if( serviceCodesArray != null )
  {
    eval("document.frmSubcontractorDetail."+fieldName+".options.length = serviceCodesArray.length +1;");
    for( var j=0; j < serviceCodesArray.length; j++){
      //populates the drop-down box with the values from the serviceCodesArray
      alert(serviceCodesArray[j]);
      eval("document.frmSubcontractorDetail."+fieldName+".options[j].value = serviceCodesArray[j].substring(0,serviceCodesArray[j].indexOf(\"|\"));");
      eval("document.frmSubcontractorDetail."+fieldName+".options[j].defaultSelected = false");
      eval("document.frmSubcontractorDetail."+fieldName+".options[j].text = serviceCodesArray[j].substring(serviceCodesArray[j].indexOf(\"|\")+1,serviceCodesArray[j].length);");
    }

    eval("document.frmSubcontractorDetail."+fieldName+".value = \"<%=tmpsubcontractorRowService%>\"");

    if(  eval("document.frmSubcontractorDetail."+fieldName+".selectedIndex != -1"))
    {
      eval("document.frmSubcontractorDetail."+fieldName+".options[document.frmSubcontractorDetail."+fieldName+".selectedIndex].defaultSelected = true");
    }
  }

}

 /*
  *This function is used to save subcontractor detail.
  */
function submitSubcontractorDetail()
{
  var doSave = false;

   window.onbeforeunload = null;
   var x = document.frmSubcontractorDetail;
   if( x.tmpSzNmResource.value != null && x.tmpSzNmResource.value != "" )
   {
     x.txtNewIdResource.value = x.txtuIdRsrcLinkChild.value;
     doSave = true;
   }
   else
   {
      setInformationalMessage("<%=MessageLookup.getMessageByName("SSM_VALIDATE_SUBCONTRACTOR")%>");
   }

   return doSave;
}

 /*
  *This function is used to submit the form to validate the subcontractor id.
  */
function validateSubContractor()
{
  window.onbeforeunload = null;
  var x = document.frmSubcontractorDetail;
  disableValidation('frmSubcontractorDetail');
  x.txtNewIdResource.value = x.txtuIdRsrcLinkChild.value;
  return true;
}

 /*
  *This function is used to submit the form to delete a subcontractor record.
  */
function deleteSubcontractorRow()
{
  var doDelete = false;

  window.onbeforeunload = null;
  var cnfrm = window.confirm("<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>")
  if(cnfrm)
  {
    document.frmSubcontractorDetail.cReqFuncCd.value = 'D';
    disableValidation('frmSubcontractorDetail');
    doDelete = true;
  }

  return doDelete;
}

//End Java Script-->
</script>
<impact:validateErrors/>
<impact:validateForm name="frmSubcontractorDetail"
   method="post"
   action="/resource/ResourceDetail/saveSubcontractorDetail"
   pageMode="<%=pageMode%>"
   schema="/WEB-INF/Constraints.xsd">
     <impact:validateInput type="hidden" name="txtuIdRsrcLinkParent" value="<%=txtuIdRsrcLinkParent%>"/>
     <impact:validateInput type="hidden" name="txtuIdRsrcLink" value="<%=tmpUIdRsrcLink%>"/>
     <impact:validateInput type="hidden" name="txtUlIdResource" value="<%=txtUlIdResource%>"/>
     <impact:validateInput type="hidden" name="indexNum" value="<%=idIndex%>"/>
     <impact:validateInput type="hidden" name="rbSubcontractorCheckboxIndex" value="<%=idIndex%>"/>
     <impact:validateInput type="hidden" name="txtTsLastUpdate" value="<%=SerializationHelper.serializeObject( tmpTsLastUpdate )%>"/>
     <impact:validateInput type="hidden" name="txtNewIdResource" />
     <impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>"/>
     <impact:validateInput type="hidden" name="validationOverride" />
     <impact:validateInput type="hidden" name="classResource" value="<%=classResource%>"/>
     <impact:validateInput type="hidden" name="fadResource" value="<%=fadResource%>"/>
     <impact:validateInput type="hidden" name="childPlacingAgency" value="<%=childPlacingAgency%>"/>
     <impact:validateInput type="hidden" name="servicesArray" value="<%=SerializationHelper.serializeObject(servicesList)%>"/>


   <table width="100%" class="tableborder" cellSpacing="0" cellPadding="3" border="0">
     <tr>
             <td><impact:validateInput type="text" label="Resource ID" name="txtuIdRsrcLinkChild" id="txtuIdRsrcLinkChild_Id" required="true" disabled="<%=subContractorIdDisable%>" value="<%=tmpUIdRsrcLinkChild%>" constraint="Numeric" tabIndex="1"/>
                       <%if( !validateButtonHide ){%>
                            &nbsp;&nbsp;<impact:ButtonTag name="btnValidateSubcontractorRow" img="btnValidate" editableMode="<%= EditableMode.EDIT %>" function="return validateSubContractor();"  form="frmSubcontractorDetail" action="/resource/ResourceDetail/validateSubcontractorId" tabIndex="<%=tabIndex++%>"/>
              </td>
                       <%}%>
     </tr>
     <tr>
             <td class="FormLabel" name="txtszNmResource" width="150">Resource Name:</td>
             <td><%=tmpSzNmResource%></td>
                  <impact:validateInput type="hidden" name="tmpSzNmResource" value="<%=tmpSzNmResource%>"/>
     </tr>
     <tr>
             <td><impact:validateSelect name="selCdRsrcSvcService" label="Service" 
                  codesTable="CSVCCODE" style="WIDTH: 200px" required="true" id="selCdRsrcSvcService" disabled="<%=serviceDisable%>" tabIndex="3"/></td>
     </tr>
    </table>

    <table width="100%" cellSpacing="0" cellPadding="3" border="0">
      <tr>
          <td align="left">
                        <%if( !deleteButtonHide ){%>
                            <impact:ButtonTag name="btnDeleteSubcontractorRow" img="btnDelete" align="left" editableMode="<%= EditableMode.EDIT %>" function="return deleteSubcontractorRow();"  form="frmSubcontractorDetail" action="/resource/ResourceDetail/deleteSubcontractorDetail" tabIndex="<%=tabIndex++%>"/>
                        <%} else{%>
                &nbsp;
                        <%}%>
                      </td>
                      <td align="right">
             <%if( !saveButtonHide ){%>
                            <impact:ButtonTag name="btnSaveSubcontractorRow"
                                img="btnSave"
                        align="right"
                        editableMode="<%= EditableMode.EDIT %>"
                                              function="return submitSubcontractorDetail();"
                                              form="frmSubcontractorDetail"
                                              action="/resource/ResourceDetail/saveSubcontractorDetail"
                        restrictRepost="true"
                                              tabIndex="<%=tabIndex++%>"/>
      <%} else{%>
                            &nbsp;
            <%}%>
              </td>
      </tr>
     </table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
