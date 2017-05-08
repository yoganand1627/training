
<%
/**
 * JSP Name:     ServicesByAreaList.jsp
 * Created by:   Donald Wilson
 * Date Created: 09/27/02
 *
 * Description:
 * This page displays the results of a Services by Area Search, and allows the
 * user to Add or Delete Services by Area Detail.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  01/30/07  Ade Odutayo       Modifications to the page based on the SHINES designs
  11/30/07  Ernest Imomio     STGAP00005831: Services By Area pagination implement
  01/06/09  Mital Patel       STGAP00005460: Added code to display horizontal scroll bar.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07SOG_ARRAY"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  int checkpoint = 0;
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  //Set the selectedServiceIndex.  It will be 0 unless a different service is
  //selected on the page
  int selectedServiceIndex = 0;
  int loopCount = 0;

  if (((!StringHelper.checkForEquality(ContextHelper.getStringSafe(request, "SzCdScrDataAction"), "D")) ||
       (StringHelper.isValid(ContextHelper.getStringSafe(request, "selectedCharacteristicIndex")))) &&
                                                                                                    (StringHelper.isValid(ContextHelper.getStringSafe(request, "selectedServiceIndex"))))

  {
    selectedServiceIndex = ContextHelper.getIntSafe(request, "selectedServiceIndex");
  }

  // get current page, if any

  int currPage = 1;
  if (StringHelper.isValid(ContextHelper.getStringSafe(request, "page")))
  {
    currPage = ContextHelper.getIntSafe(request, "page");
  }

  if (StringHelper.isValid((String) request.getAttribute("tmpPageNum")))
  {
    currPage = Integer.parseInt((String) request.getAttribute("tmpPageNum"));
    request.removeAttribute("tmpPageNum");
  }

  //Get the services data for the page
  CRES05SO cres05so = (CRES05SO)request.getAttribute("CRES05SO");
  ROWCRES05SOG00_ARRAY servicesArray = null;
  ROWCRES05SOG00 selectedService = null;

  String serviceId = "";
  String serviceCode = "";
  String serviceCategory = "";
  Enumeration services = null;
  boolean currServiceIsContracted = false;
  String selectedServiceName = "";
  String selectedServiceType = "";
  if (cres05so != null)
  {
    servicesArray = cres05so.getROWCRES05SOG00_ARRAY();
    request.setAttribute("CRES05SO", cres05so);
    //check to see if array is empty
    if( servicesArray.getROWCRES05SOG00Count() > 0 ){
      ROWCRES05SOG00 serviceRow1 = servicesArray.getROWCRES05SOG00(0);
      serviceId = String.valueOf(serviceRow1.getUlIdResourceService());
    }    
  }
  if (StringHelper.isValid(ContextHelper.getStringSafe(request, "servicesList")))
  {
    serviceId = ContextHelper.getStringSafe(request, "servicesList");
  }
  if (servicesArray != null && servicesArray.getROWCRES05SOG00Count() > 0 )
  {
    if (selectedServiceIndex >= servicesArray.getROWCRES05SOG00Count())
    {
      selectedServiceIndex = 0;
    }

    selectedServiceType = servicesArray.getROWCRES05SOG00(selectedServiceIndex).getSzCdRsrcSvcServiceType();
    selectedServiceName = servicesArray.getROWCRES05SOG00(selectedServiceIndex).getSzCdRsrcSvcService();
  }
  else
  {
    servicesArray = new ROWCRES05SOG00_ARRAY();
  }

  
  services = servicesArray.enumerateROWCRES05SOG00();
  String ResourceID = GlobalData.getUlIdResourceAsString( request );
  String ResourceName = GlobalData.getSzNmResource(request);

  Boolean  servicesRecordFound =services.hasMoreElements();

  //Get the characteristics data for the page
  CRES07SO cres07so = (CRES07SO)request.getAttribute("CRES07SO");
  ROWCRES07SOG_ARRAY characteristicsArray = null;
  Enumeration characteristics = null;
  int characteristicsCount = 0;

  if (cres07so != null)
  {
    characteristicsArray = cres07so.getROWCRES07SOG_ARRAY();

  }
  if (characteristicsArray == null)
  {
    characteristicsArray = new ROWCRES07SOG_ARRAY();
  }

  characteristics = characteristicsArray.enumerateROWCRES07SOG();
  
   Boolean  characteristicsRecourdFound =characteristics.hasMoreElements();

  String pageMode = GlobalData.getAppMode(request);

  //Variable to hold the css class for the each row in the lists
  String rowCss = "altColor";


%>


<!-- Begin Population List-->
<script type="text/javascript" language="JavaScript1.2">
//Submit Services form to redisplay this page with the characteristics for the
//newly selected service

window.onload = function ()
{
  if (document.pagination != null)
  {
    document.frmServices.orderBy.value = document.pagination.orderBy.value;
    document.frmServices.orderByDirection.value = document.pagination.orderByDirection.value;
  }

  if (document.frmServices.page != null && document.frmServices.lastPage.value != document.frmServices.page.value)
  {
    document.frmServices.selectedServiceIndex.value = "0";
  }

  // This scrolls to the approximate location of the service radio button that was clicked.
  if (document.frmServices.rbServicesList != null &&
      document.frmServices.rbServicesList.length != null &&
      <%=selectedServiceIndex%> > 0)
  {
    // this is the div!
    document.frmServices.rbServicesList[<%=selectedServiceIndex%>].parentNode.parentNode.scrollIntoView();

  }

};


window.onbeforeunload = function ()
{
  if (document.frmServices.page != null)
  {
    document.frmServices.lastPage.value = document.frmServices.page.value;
  }

  if (document.pagination != null)
  {
    if (document.pagination.selectedServiceIndex != null)
    {
      document.pagination.selectedServiceIndex.value = "0";
    }
  }
};


function getState()
{
  return document.frmServices.State.value;
}

function getRegionCode()
{
  return document.frmServices.RegionCode.value;
}

function getCounty()
{
  return document.frmServices.County.value;
}

function checkForSelection(objName)
{
  var buttonChecked = false;
  var obj = eval(objName);

  if (obj != null)
  {
    if (obj.length == null)
    {
      if (obj.checked != false)
        buttonChecked = true;
    }
    else
    {
      for (var i = 0; i < obj.length; ++i)
      {
        buttonChecked = buttonChecked || obj[i].checked;
      }
    }
  }

  return (buttonChecked);
}

function whichButtonChecked(objName)
{
  var whichChecked = -1;
  var obj = eval(objName);

  if (obj != null)
  {
    if (obj.length == null)
    {
      if (obj.checked != false)
        whichChecked = 0;
    }
    else
    {
      for (var i = 0; i < obj.length; ++i)
      {
        if (obj[i].checked)
          whichChecked = i;
      }
    }
  }

  return (whichChecked);
}

function serviceIsContracted()
{
  var contracted = false;

  if (document.frmServices.isContracted.value == 'true')
  {
    contracted = true;
  }

  return contracted;
}

function updateSelectedService(index)
{
  document.frmServices.selectedServiceIndex.value = index;
  disableValidation('frmServices');
  submitValidateForm('frmServices', '/resource/ServicesByArea/refreshCharacteristicList');
}

function updateSelectedCharacteristic(index)
{
  document.frmCharacteristics.selectedCharacteristicIndex.value = index;
}

//submit Services form to go to the services detail page
function goToServicesDetail(index)
{
  document.frmServices.selectedServiceIndex.value = index;
  document.frmServices.SzCdScrDataAction.value='U';
  disableValidation('frmServices');
  window.onbeforeunload = null;
  submitValidateForm('frmServices', '/resource/ServicesByArea/displayServiceDetail');
}

//submit Services form to go to the services detail page in add mode
function addService()
{
  document.frmServices.selectedServiceIndex.value = '';
  document.frmServices.SzCdScrDataAction.value='A';
  disableValidation('frmServices');
  return true;
}

//submit Services form to go to the services detail page in delete mode
function deleteService()
{
  var confirmMessage = "";

  if ((getState() == 'Georgia' && getRegionCode() == '98') || (getState() != 'Georgia'))
  {
    confirmMessage = "This will delete the Client Characteristics for the service within the state. Delete?";
  }
  else
  {
    confirmMessage = "This will delete the Client Characteristics for the service within the region. Delete?";
  }

  if (checkForSelection('document.frmServices.rbServicesList'))
  {
    document.frmServices.selectedServiceIndex.value = whichButtonChecked('document.frmServices.rbServicesList');
    if (! serviceIsContracted())
    {
      if (confirm(confirmMessage))
      {
        document.frmServices.SzCdScrDataAction.value='D';
        disableValidation('frmServices');
        return true;
      }
      else
      {
        return false;
      }
    }
    else
    {
      alert("Service is in an active contract. Deletion is not allowed.");
      return false;
    }
  }
  else
  {
    setInformationalMessage("<%= MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>");
    return false;
  }
}

function goToClientCharacteristicsDetail(rownum)
{
  document.frmCharacteristics.selectedCharacteristicIndex.value = rownum;
  document.frmCharacteristics.SzCdScrDataAction.value='U';
  disableValidation('frmCharacteristics');
  submitValidateForm('frmCharacteristics', '/resource/ServicesByArea/displayClientCharacteristicDetail');
}

function addClientCharacteristicsDetail()
{
  document.frmCharacteristics.SzCdScrDataAction.value='A';
  disableValidation('frmCharacteristics');
  return true;
}

//submit Services form to go to the services detail page in delete mode
function deleteClientCharacteristicsDetail()
{
  if (checkForSelection('document.frmCharacteristics.rbCharacteristics'))
  {
    if (confirm("Are you sure you want to delete this record?"))
    {
      document.frmCharacteristics.SzCdScrDataAction.value='D';
      return true;
    }
    else
    {
      return false;
    }
  }
  else
  {
    document.frmCharacteristics.SzCdScrDataAction.value='D';
    setInformationalMessage("<%= MessageLookup.getMessageByName("MSG_SELECT_ROW_ACTION")%>");
    return false;
  }
}
</script>


<impact:validateForm
 name="frmServices"
 method="post"
 action="/resource/ServicesByArea/default"
 schema="/WEB-INF/Constraints.xsd"
 pageMode="<%= pageMode %>">

<impact:validateErrors formName="frmServices"/>

<%--Hidden input fields for passing information to services detail and redisplaying this page--%>
<input type="hidden" name="lastPage" value=""/>
<input type="hidden" name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>" value="<%=pageMode%>"/>
<input type="hidden" name="selectedServiceIndex" value="<%=selectedServiceIndex%>"/>
<input type="hidden" name="txtNmResource" value="<%=ResourceName%>"/>
<input type="hidden" name="SzCdScrDataAction" value=""/>
<input type="hidden" name="txtUlIdResource" value="<%=ResourceID%>"/>
<impact:validateInput type="hidden" name="validationOverride"/>
<impact:pagination saveState="false" submitUrl="/resource/ServicesByArea/default">
<table width="100%" cellpading="0" cellspacing="0" border="0">
 <tr><td class="alignRight">
<div class="formInstruct">Scroll for more information  --></div>
  </td>
</tr>
</table>
  
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder" >
 <th>Services by Area - <%=ResourceName%></th>
  <tr>
   <td>
    <div name="thediv" id="scroll2" style="HEIGHT:200px;WIDTH:763px;OVERFLOW:auto"class="tableborderList">
   <div name="thediv" id="scroll2" style="OVERFLOW:auto; WIDTH:763px">
    <table name="thetable" border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
    <tr>
     <th class="thList">&nbsp;</th>
     <th class="thList">Category</th>
     <th class="thList">Service</th>
     <th class="thList">C</th>
     <th class="thList">Program</th>
     <th class="thList">Region</th>
     <th class="thList">County</th>
     <th class="thList">Partial County</th>
     <th class="thList">Income Based</th>
     <th class="thList">State</th>
    </tr>

<%
   ROWCRES05SOG00 service = null;
   loopCount = 0;

   if (!services.hasMoreElements())
   {
%>
       <tr class="odd">
         <td colspan="7">
            <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
         </td>
       </tr>
<%
   }
     else
   {
     while (services.hasMoreElements())
     {
       service = (ROWCRES05SOG00) services.nextElement();
%>
    <tr name="therow" class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
     <td name="theelement">
     <input type="radio"
            <%if (loopCount == selectedServiceIndex) {%>checked="true"<%}%>
            name="rbServicesList"
            value="<%=service.getUlIdResourceService()%>"
            tabIndex="<%=loopCount%>"
            onClick="javascript:updateSelectedService(<%=loopCount%>);">

     <%if (loopCount == selectedServiceIndex)
       {
         currServiceIsContracted = (StringHelper.isTrue(service.getCScrIndRsrcContracted()));
       %>
          <input type="hidden"
                 name="State"
                 value='<%= Lookup.simpleDecodeSafe("CSTATE", service.getSzCdRsrcSvcState()) %>'/>

          <input type="hidden"
                 name="RegionCode"
                 value="<%= service.getSzCdRsrcSvcRegion() %>"/>

          <input type="hidden"
                 name="County" value='<%= Lookup.simpleDecodeSafe("CCOUNT", service.getSzScrRsrcSvcCntyCode()) %>'/>

          <input type="hidden"
                 name="isContracted"
                 value='<%= "" + StringHelper.isTrue(service.getCScrIndRsrcContracted()) %>'/>

          <input type="hidden"
                 name="txtUlIdResourceService"
                 value="<%= service.getUlIdResourceService() %>"/>
     <%}%>

     </td>
     <% 
        if( "G".equalsIgnoreCase( service.getSzCdRsrcSvcServiceType() ) ){
           serviceCode = Lookup.simpleDecodeSafe(CodesTables.CGLSVCCD, service.getSzCdRsrcSvcService());
           serviceCategory = Lookup.simpleDecodeSafe(CodesTables.CATOFSVC, service.getSzCdRsrcSvcCategRsrc());
        }
        else if( "F".equalsIgnoreCase( service.getSzCdRsrcSvcServiceType() ) ){
           serviceCode = Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, service.getSzCdRsrcSvcService());
           serviceCategory = Lookup.simpleDecodeSafe(CodesTables.CPRGCODE, service.getSzCdRsrcSvcCategRsrc());        
        }
        
        int begin = 0, end = 29, strLen = 30;
        if(!"".equals(serviceCode) & serviceCode.length() > strLen){
           serviceCode = serviceCode.substring(begin,end);
        }
        if(!"".equals(serviceCategory) & serviceCategory.length() > strLen){
         serviceCategory = serviceCategory.substring(begin,end);
        }
     %>
     <td><nobr><%= serviceCategory %></td>
     <td><nobr><A href="javascript:goToServicesDetail(<%=loopCount%>);"><%= serviceCode %></A></td>
     <td><nobr><%if (StringHelper.isTrue(service.getCScrIndRsrcContracted())){%><img alt="checkmark" src="/grnds-docs/images/shared/checkMark.gif" ><%}%></td>
     <td><nobr><%=Lookup.simpleDecodeSafe("CRSCPROG", service.getSzCdRsrcSvcProgram())%></td>
     <td><nobr><%=Lookup.simpleDecodeSafe("CREGIONS", service.getSzCdRsrcSvcRegion())%></td>
     <td><nobr><%=Lookup.simpleDecodeSafe("CCOUNT", service.getSzScrRsrcSvcCntyCode())%></td>
     <td><nobr><%=service.getBIndRsrcSvcCntyPartial()%></td>
     <td><nobr><%=service.getCIndRsrcSvcIncomeBsed()%></td>
     <td><nobr><%=Lookup.simpleDecodeSafe("CSTATE", service.getSzCdRsrcSvcState())%></td>
    </tr>
<%
      loopCount++;
     } // end while
   }
%>

    </table>
  </div>
    </td>
  </tr>
</table>
</impact:pagination>
  <input type="hidden" name="frmCount" value="<%=loopCount+1%>"/>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
<% if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {%>
<table border="0" cellspacing="0" cellpadding="3" width="100%"  >
 <tr>
    <td align="left">
    <%if (!currServiceIsContracted && servicesArray.getROWCRES05SOG00Count() > 0) {%>
     <impact:ButtonTag name="btnDeleteSrv"
                       img="btnDelete"
                       editableMode="<%= EditableMode.EDIT %>"
                       function="return deleteService();"
                       form="frmServices"
                       action="/resource/ServicesByArea/deleteServiceDetail"
                       tabIndex="<%=loopCount++%>"/>
    <%}%>
    </td>
    <td align="right" >
      <impact:ButtonTag name="btnAddSrv"
                       img="btnAdd"
                       align="right"
                       editableMode="<%= EditableMode.EDIT %>"
                       function="return addService();"
                       form="frmServices"
                       action="/resource/ServicesByArea/addFinServiceDetail"
                       tabIndex="<%=loopCount++%>"/>
    </td>
 </tr>
</table>
<%}%>

</impact:validateForm>


<!--End Service Area List-->
<BR>
<% if (services != null) { %>
<impact:validateForm
 name="frmCharacteristics"
 method="post"
 action="/resource/ServicesByArea/default"
 schema="/WEB-INF/Constraints.xsd"
 pageMode="<%= pageMode %>"
 redisplayParameters="true">

<input type="hidden"
       name="servicesList"
       value="<%=serviceId%>"/>

<input type="hidden"
       name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME %>"
       value="<%=pageMode%>"/>

<input type="hidden"
       name="txtUlIdResourceService"
       value='<%= ContextHelper.getStringSafe(request, "txtUlIdResourceService") %>'/>

<input type="hidden"
       name="txtNmResource"
       value="<%=ResourceName%>"/>

<input type="hidden"
       name="txtUlIdResource"
       value="<%=ResourceID%>"/>

<input type="hidden"
       name="SzCdScrDataAction"
       value=""/>

<input type="hidden"
       name="selectedServiceIndex"
       value="<%=selectedServiceIndex%>"/>

<impact:validateInput type="hidden"
       name="selectedCharacteristicIndex"
       value=""/>

<impact:validateInput type="hidden"
       name="page"
       value="<%=Integer.toString(currPage)%>"/>

<impact:validateInput type="hidden" name="orderBy" />
<impact:validateInput type="hidden" name="orderByDirection" />
<impact:validateInput type="hidden" name="validationOverride"/>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder"  >
  <% String serviceDecode = "";
     if( "G".equalsIgnoreCase(selectedServiceType) ){
     	serviceDecode = Lookup.simpleDecodeSafe(CodesTables.CGLSVCCD, selectedServiceName);
     }
     if( "F".equalsIgnoreCase(selectedServiceType) ){
         serviceDecode = Lookup.simpleDecodeSafe(CodesTables.CSVCCODE, selectedServiceName);
     }
  %>
  <th>Client Characteristics - <%=serviceDecode%></th>
    <tr>
      <td>
        <div id="scroll3" style="OVERFLOW: auto; WIDTH: 760px; HEIGHT: 150px">
        <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
          <tr>
            <th class="thList">&nbsp;</th>
            <th class="thList">Characteristics</th>
            <th class="thList">Male Min Age</th>
            <th class="thList">Male Max Age</th>
            <th class="thList">Female Min Age</th>
            <th class="thList">Female Max Age</th>
          </tr>

<%
   ROWCRES07SOG characteristic = null;
   int characteristicsLoopCount = 0;

   if (!characteristics.hasMoreElements())
   {
%>
       <tr class="odd">
         <td colspan="7">
            <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
         </td>
       </tr>
<%
   }
     else
   {
     while (characteristics.hasMoreElements())
     {
       characteristic = (ROWCRES07SOG) characteristics.nextElement();
%>
    <tr class="<%=FormattingHelper.getRowCss(characteristicsLoopCount + 1)%>" valign="top">
      <td>
       <input type="radio"
              name="rbCharacteristics"
              value="<%=characteristicsLoopCount%>"
              tabIndex="<%=characteristicsLoopCount%>"
              onClick="javascript:updateSelectedCharacteristic(<%=characteristicsLoopCount%>);">
      </td>
      <td><nobr><A href="javascript:goToClientCharacteristicsDetail('<%=characteristicsLoopCount%>');"><%=Lookup.simpleDecodeSafe("CLNCHAR2", characteristic.getSzCdRsrcCharChrctr())%></A></td>
      <td><nobr><%=getFormattedAge(characteristic.getUNbrRsrcCharMinMAge())%></td>
      <td><nobr><%=getFormattedAge(characteristic.getUNbrRsrcCharMaxMAge())%></td>
      <td><nobr><%=getFormattedAge(characteristic.getUNbrRsrcCharMinFAge())%></td>
      <td><nobr><%=getFormattedAge(characteristic.getUNbrRsrcCharMaxFAge())%></td>
    </tr>
<%
      characteristicsLoopCount++;
     } // end while
   }
%>
    </table>
</div>
    </td>
    </tr>
</table>

  <input type="hidden" name="frmCount" value="<%= characteristicsLoopCount + 1 %>"/>
  <input type="hidden" name="<%= HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY %>">


<% if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) { %>
<table border="0" cellspacing="0" cellpadding="3" width="100%"  >
  <tr>
    <td align="left">
      <%if (characteristicsRecourdFound) { %>
        <impact:ButtonTag name="btnDeleteChar"
                          img="btnDelete"
                          editableMode="<%= EditableMode.EDIT %>"
                          function="return deleteClientCharacteristicsDetail();"
                          form="frmCharacteristics"
                          action="/resource/ServicesByArea/deleteClientCharacteristicDetail"
                          tabIndex="<%=characteristicsLoopCount++%>"/>
      <%}%>
    </td>
    <td align="right" >
      <% if (servicesRecordFound) { %>
        <impact:ButtonTag name="btnAddChar"
                          img="btnAdd"
                          align="right"
                          editableMode="<%= EditableMode.EDIT %>"
                          function="return addClientCharacteristicsDetail();"
                          form="frmCharacteristics"
                          action="/resource/ServicesByArea/addClientCharacteristicDetail"
                          tabIndex="<%=characteristicsLoopCount++%>"/>
      <%}%>
    </td>
  </tr>
 </table>

 <%}%>

</impact:validateForm>
<%}%>


<%!
/**
 * GetFormattedAge  using the string parameters in order to get
 * age converted from months to years and months
 * @return String
 * @param months The number of months for the age
 */
  public String getFormattedAge(int months)
  {
    int years = 0;
    if (months < 12)
    {
      return (" 0 Yr " + months + " Mo");
    }
    else
    {
      years = months / 12;
      months = months % 12;
      return ( years + " Yr " + months + " Mo ");
    }
  }
%>
