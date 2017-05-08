<%
  /**
   * JSP Name:     CaretakerInformation.jsp
   * Created by:   Brad Eiliers
   * Date Created: 09/30/02
   *
   * Description:
   * This page is accessed from a hyperlink on the Facility Detail Page.  It
   * allows users to view, add and delete Caretaker Information.
   **/
/*
  Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/11/03  Todd Reser        Added flowerbox, description and Change log.
  02/18/04  Linda Reed        SIR 22625- added txtChildResourceId so Home ResourceId
                              passed on to following pages.
  09/01/05  Linda Reed        SIR 23777 - split Race out of Ethnicity.
  01/02/09  Abraham Williams  STGAP00010681 - Updated CPA Resource ID and Home ID.
                              CPA Resource ID and Home ID are updated with the values from
                              the Caretaker Information output structure (CRES18SO).
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.*" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CRES18SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES55DO_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.CaretakerConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>

<%
  String caretakerName = "";
  String idResource = "";
  String ulHmResourceId = "";
  String cpaResourceId = "";
  String homeId = "";
  String maritalStatus = "";
  int iLoopCount = 0;
  String txtChildResourceId = "";
  String endDate = null;
  int activeCaretakerCount = 0;
  
  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  
  //get the CRES18SO object from state.
  CRES18SO caretakerInfo = (CRES18SO) state.getAttribute(CaretakerConversation.CRES18SO_ATTR_NAME, request);
  ROWCRES55DO_ARRAY caretakerArray = null;
  
  if (caretakerInfo != null) {
    caretakerArray = caretakerInfo.getROWCRES55DO_ARRAY();
    caretakerName = caretakerInfo.getSzCpaName();
    idResource = Integer.toString(caretakerInfo.getUlIdResource());
    ulHmResourceId = Integer.toString(caretakerInfo.getUlHmResourceId());
    
    // STGAP00010681 - This defect innvalidates the following comment for Home ID
    // as per Bryant suggestion- defect number STGAP00002542, setting the caretaker name as the resource name,
    // cparesourceid to the resourceid, homeId to Blank.
    //caretakerName = resourceName;
    //idResource = uidResource;
    //homeId = "";
    
    // STGAP00010681 - Set correct values for Home ID and CPA Resource ID
    if (idResource.equals("0")) {
      cpaResourceId = "";
    } else {
      cpaResourceId = idResource;
    }
    if (ulHmResourceId.equals("0")) {
      homeId = "";
    } else {
      homeId = ulHmResourceId;
    }    
    
    // Get home marital status
    if (caretakerArray != null) {
      ROWCRES55DO caretakerDetail = caretakerArray.getROWCRES55DO(0);

      if (caretakerDetail != null) {
        maritalStatus = Lookup.simpleDecodeSafe("CFAMSTRC", caretakerDetail.getCd_Home_Marital_Status());
        endDate = FormattingHelper.formatDate(caretakerDetail.getDtEnd());
      }
    }
  }
  
  if (caretakerArray == null) {
    caretakerArray = new ROWCRES55DO_ARRAY();
  }

  String pageMode = PageMode.getPageMode(request);

  int tabIndex = 1;
%>

<script type="text/javascript" language="JavaScript1.2">
  <!--Insert Java Script here

//Go to caretaker detail
function submitCaretakerForm( index )
{
  document.frmCaretakerDetail.caretakerIndex.value = index;
  document.frmCaretakerDetail.cReqFuncCd.value = 'U';
  //document.frmCaretakerDetail.<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>.value = "<%=PageModeConstants.EDIT%>";
  disableValidation('frmCaretakerDetail');
  submitValidateForm( 'frmCaretakerDetail', '/resource/Caretaker/displayCaretakerDetail' );
}

//Go to caretaker detail with a blank page
function addCaretaker()
{
  var x = document.frmCaretakerDetail;
  var careTakerLength = 0;
  var activeCaretakerLength = 0;
  careTakerLength = x.activeCaretakerCount.value;
    
  if ( careTakerLength == 2 )
  {
    alert( '<%= MessageLookup.getMessageByName( "MSG_MAX_CARETAKER_ROW") %>' );
    return false;
  }else
  {
    document.frmCaretakerDetail.cReqFuncCd.value = 'A';
    document.frmCaretakerDetail.<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>.value = "<%=PageModeConstants.EDIT%>";
    return true;

  }
}

function checkForSelection( objName )
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

//submit form to delete the caretaker
function deleteCaretaker()
{
  var x = document.frmCaretakerDetail;
  var rowSelected = false;
  //Alert user if they click a Delete button without selecting an item to delete

  rowSelected = checkForSelection("document.frmCaretakerDetail.rbSelectedCaretaker");

  if( !rowSelected )
  {
    setInformationalMessage("<%= MessageLookup.getMessageByName( "MSG_SELECT_ROW_ACTION" )%>" );
    return false;
  }
  else
  {
    var cnfrm = window.confirm( '<%= MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") %>' )
    if(cnfrm)
    {
      document.frmCaretakerDetail.cReqFuncCd.value = 'D';
      disableValidation('frmCaretakerDetail');
      //submitForm( 'frmCaretakerDetail', '/resource/Caretaker/deleteCaretaker' );
      return true;
    }
    else
    {
      return false;
    }
  }
}
//End Java Script-->
</script>

<impact:validateForm
        name="frmCaretakerDetail"
        action="/resource/Caretaker/displayCaretakerDetail"
        method="post"
        schema="/WEB-INF/Constraints.xsd"
        pageMode="<%=pageMode%>">

<impact:validateErrors/>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="4">Caretaker Information</th>
  </tr>
  <tr>
    <td class="formLabel"> Name: </td>
    <td><%=caretakerName%></td>
    <td class="formLabel">CPA Resource ID: </td>
    <td width=250><%=cpaResourceId%></td>
  </tr>
  <tr>
    <td class="formLabel">Home ID:</td>
    <td><%=homeId%></td>
    <td class="formLabel">Home Marital Status: </td>
    <td><%=maritalStatus%></td>
  </tr>
</table>
<br>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
<tr>
  <th>Caretakers</th>
</tr>
<tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorderList">
  <tr>
    <th class="thList">Name</th>
    <th class="thList">Date of Birth</th>
    <th class="thList">Ethnicity</th>
    <th class="thList">Gender</th>
    <th class="thList">End Date</th>
   </tr>
  <%
    ROWCRES55DO caretakerDetail;
    Enumeration caretakers = caretakerArray.enumerateROWCRES55DO();
    iLoopCount = 0;
    if (caretakers.hasMoreElements()) {
      while (caretakers.hasMoreElements()) {
        caretakerDetail = (ROWCRES55DO) caretakers.nextElement();
        if(caretakerDetail.getDtEnd() == null || "".equals(caretakerDetail.getDtEnd()) || caretakerDetail.getDtEnd() == null || DateHelper.isAfterToday(caretakerDetail.getDtEnd()) )  {
        	activeCaretakerCount++;
        }
  %>
  <tr>
    <td class="formInput"><a href="#" onClick="javascript:submitCaretakerForm( <%=iLoopCount%> )"
                                tabIndex="<%=tabIndex++%>"><%=caretakerDetail.getSzNmCaretkrLname()%>, <%=caretakerDetail.getSzNmCaretkrFname()%> <%=caretakerDetail.getSzNmCaretkrMname()%></a></td>
    <td class="formInput"><%
      if (caretakerDetail.getDtCaretkrBirth() != null) {
        out.println(FormattingHelper.formatDate(caretakerDetail.getDtCaretkrBirth()));
      }
    %></td>
    <td class="formInput"><%=Lookup.simpleDecodeSafe("CETHNIC", caretakerDetail.getCdCaretkrEthnic())%></td>
    <td class="formInput"><%=Lookup.simpleDecodeSafe("CSEX", caretakerDetail.getCdCaretkrSex())%></td>
    <td class="formInput"><%=FormattingHelper.formatDate(caretakerDetail.getDtEnd()) %>
  </tr>
  <%
      ++iLoopCount;
    } //end for loop for caretakerArray
  } else {
  %> <tr>
  <td>
    <%= MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") %>
  </td>
</tr>
  <% }
  %>
</table>
<%
  if (StringHelper.checkForEquality(pageMode, PageModeConstants.EDIT)) {
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <impact:ButtonTag name="btnAddCareTaker"
                        img="btnAdd"
                        restrictRepost="true"
                        navAwayCk="true"
                        align="right"
                        editableMode="<%= EditableMode.EDIT %>"
                        function="return addCaretaker();"
                        form="frmCaretakerDetail"
                        action="/resource/Caretaker/addCaretakerDetail"
                        tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<%
} else if (StringHelper.checkForEquality(pageMode, PageModeConstants.CREATE)) {
%>
<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
    <td align="right">
      <impact:ButtonTag name="btnAddCareTaker"
                        img="btnAdd"
                        restrictRepost="true"
                        navAwayCk="true"
                        align="right"
                        editableMode="<%= EditableMode.EDIT %>"
                        function="return addCaretaker();"
                        form="frmCaretakerDetail"
                        action="/resource/Caretaker/addCaretakerDetail"
                        tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<%
  }
%>

</td>
</tr>
</table>

<input type="hidden" name="caretakerCount" value="<%=iLoopCount%>"/>
<input type="hidden" name="activeCaretakerCount" value="<%=activeCaretakerCount%>"/>
<input type="hidden" name="txtChildResourceId" value="<%=txtChildResourceId%>"/>
<input type="hidden" name="cReqFuncCd"/>
<input type="hidden" name="caretakerIndex"/>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
<input type="hidden" name="<%=PageMode.PAGE_MODE_ATTRIBUTE_NAME%>" value="<%=pageMode%>">
</impact:validateForm>
