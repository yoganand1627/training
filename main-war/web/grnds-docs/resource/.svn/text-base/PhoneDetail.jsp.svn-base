<%
/**
 * JSP Name:     PhoneDetail.jsp
 * Created by:   Habib|Ranas
 * Date Created: 7/30/02|08/08/2002
 *
 * Description:
 * The Phone Detail page will display detailed information for the resource
 * selected on the Resource Detail page.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
  06/10/03  Todd Reser        SIR 18144 Removed all occurances of &nbsp;
  4/2/2004  gerryc            SIR 22822 - instead of just getting rbPhoneRadioIndex,
                              also get indexNum from ResourceDetail.jsp.  This is
                              then passed as a hidden variable to ResourceDetailConversation
                              where it is used to delete the correct phone record.
*/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>


<%
  int iUlIdResource = 0;
  String szCReqFuncCd = "";
  String iIndex = "0";
  String szSzTxtRsrcPhoneComments = "";
  String classResource = "false";
  String fadResource = "false";
  String phoneTypeDisabled = "false";
  String phoneNumberDisabled = "false";
  String phoneExtensionDisabled = "false";
  String phoneCommentsDisabled = "false";
  boolean phoneSaveButtonHide = false;
  boolean phoneDeleteButtonHide = false;

  String pageMode = PageMode.getPageMode(request);
  if(StringHelper.isValid(request.getParameter("cReqFuncCd") ))
  {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
  }

  if( StringHelper.isValid(request.getParameter("rbPhoneRadioIndex")))
  {
    iIndex =  request.getParameter("rbPhoneRadioIndex");
  }
  else if (StringHelper.isValid(request.getParameter("indexNum"))) //22822 added
  {
    iIndex = request.getParameter("indexNum");
  }

  List excludePrimaryOption = new ArrayList();
  ROWCRES03SOG01 phoneRow = (ROWCRES03SOG01)request.getAttribute( "PhoneDetail_Attribute" );
  // In case phoneRow is null or in Add mode create a new empty phone row
  if( phoneRow == null || "A".equals(szCReqFuncCd) )
  {
    phoneRow = new ROWCRES03SOG01();
  }
  // Retain this in state in case of validation failure --->request.removeAttribute( "PhoneDetail_Attribute" );
  // If phone row has been returned from conversation

    iUlIdResource = phoneRow.getUlIdResource();

    if( StringHelper.isValid( phoneRow.getSzTxtRsrcPhoneComments() ))
    {
      szSzTxtRsrcPhoneComments = phoneRow.getSzTxtRsrcPhoneComments();
    }

  // If in Add mode
 if ("A".equalsIgnoreCase(szCReqFuncCd))
  {
     phoneDeleteButtonHide = true;
  }

  // Values will be populated from phoneRow no longer being removed from request
     iUlIdResource =  GlobalData.getUlIdResource( request );
  // If a FAD resource
  if( ArchitectureConstants.TRUE.equalsIgnoreCase( request.getParameter("fadResource") ))
  {
    fadResource = "true";
    phoneSaveButtonHide = true;
    phoneDeleteButtonHide = true;
  }
  // If a CLASS resource in update mode
  if( ArchitectureConstants.TRUE.equalsIgnoreCase( request.getParameter("classResource")) && "U".equalsIgnoreCase(szCReqFuncCd) )
  {
    classResource = "true";
    phoneDeleteButtonHide = true;
  }
  // If primary phone in Add mode
  if( !"A".equals(szCReqFuncCd) && "01".equals(phoneRow.getSzCdFacilPhoneType()) )
  {
    phoneTypeDisabled = "true";
    phoneDeleteButtonHide = true;
  }
  // In update mode, totally disable the phone type
  if( "U".equals(szCReqFuncCd))
  {
    phoneTypeDisabled = "true";
  }
  // If other than primary phone in Add or Update mode
  if("A".equals(szCReqFuncCd) || ("U".equals(szCReqFuncCd) && !"01".equals(phoneRow.getSzCdFacilPhoneType())) )
  {
    excludePrimaryOption.add("01");
  }
  //Hide buttons if in view mode
  if( pageMode.equals(PageModeConstants.VIEW) )
  {
    phoneDeleteButtonHide = true;
    phoneSaveButtonHide = true;
  }
  int tabIndex = 1;
%>

<title> Phone Detail</title>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

 /*
  *This function is called before the page unloads.
  */
  window.attachEvent('onbeforeunload', setDirty );
  function setDirty()
  {
    IsDirty();
  }

 /*
  *This function is called when saving phone details.
  */
  function savePhoneDetail()
  {
    window.onbeforeunload = null;
    document.frmPhoneDetail.action = "/resource/ResourceDetail/displayPhoneDetail";
    return true;
  }

 /*
  *This function is called when deleting a phone record.
  */
  function deletePhoneRow()
  {
    var doDelete = false;

    window.onbeforeunload = null;
    var x = document.frmPhoneDetail;
    if( x.selSzCdFacilPhoneType.value == "01"  )
    {
      //MSG - A primary phone record may not be deleted.
      setInformationalMessage("<%=MessageLookup.getMessageByName("MSG_CMN_PRIMARY_PHONE_NO_DELETE")%>");
    }
    else
    {
      var cnfrm = window.confirm("<%=MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE")%>")
      if(cnfrm)
      {
        x.cReqFuncCd.value = "D";
        doDelete = true;
      }
    }

      return doDelete;
  }

</script>

<impact:validateErrors/>
<impact:validateForm name="frmPhoneDetail"
  method="post"
  action="/resource/ResourceDetail/savePhoneDetail"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">
    <impact:validateInput type="hidden" name="IdResourcePhone" value="<%=FormattingHelper.formatInt( phoneRow.getUlIdRsrcPhone() )%>"/>
<!-- SR- <impact:validateInput type="hidden" name="txtUlIdResource" value="<!%=FormattingHelper.formatInt( iUlIdResource )%>"/> -->
    <impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>"/>
    <impact:validateInput type="hidden" name="rbPhoneRadioIndex" value="<%=iIndex%>"/>
    <impact:validateInput type="hidden" name="WindowName" value="PhoneDetail"/>
    <impact:validateInput type="hidden" name="txtTsLastUpdate" value="<%=SerializationHelper.serializeObject( phoneRow.getTsLastUpdate() )%>"/>
    <impact:validateInput type="hidden" name="classResource" value="<%=classResource%>"/>
    <impact:validateInput type="hidden" name="fadResource" value="<%=fadResource%>"/>
    <impact:validateInput type="hidden" name="hdnPhone" value="<%=phoneRow.getLNbrFacilPhoneNumber()%>" />
<impact:validateInput type="hidden" name="hdnExt" value="<%= phoneRow.getLNbrFacilPhoneExtension() %>" />    
    
<!-- SR-    <impact:validateInput type="hidden" name="cbxCIndRsrcTransport" value="<!%=cbxCIndRsrcTransport%>"/>  -->

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr align=left valign=top>
    <th colspan="2">Resource Phone Detail</th>
  </tr>
  <tr  align=left valign=top>
    <td width="15%"><impact:validateSelect label="Type" orderBy="decode" required="true" name="selSzCdFacilPhoneType" tabIndex="<%=tabIndex++%>" codesTable="CRSCPHON" disabled="<%=phoneTypeDisabled%>" excludeOptions="<%=excludePrimaryOption%>" value="<%= phoneRow.getSzCdFacilPhoneType() %>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput type="text"
                              label="Phone"
                              constraint="Phone"
                              required="true"
                              name="txtLNbrFacilPhoneNumber"
                              disabled="<%=phoneNumberDisabled%>"
                              cssClass="formInput"
                              value="<%= FormattingHelper.formatPhone( phoneRow.getLNbrFacilPhoneNumber() ) %>"
                              size="14"
                              maxLength ="14"
                              tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr  align=left valign=top>
    <td><impact:validateInput type="text" label="Ext" name="txtLNbrFacilPhoneExtension" disabled="<%=phoneExtensionDisabled%>" cssClass="formInput" value="<%= phoneRow.getLNbrFacilPhoneExtension() %>" constraint="PhoneExtension" size="8" maxLength ="8" tabIndex="<%=tabIndex++%>"/></td>
  </tr>
  <tr>
    <td class="formLabel" valign="top">Comments:</td>
    <td>
      <impact:validateTextArea cols="120"
                               rows="4"
                               name="txtszTxtRsrcPhoneComments"
                               disabled="<%=phoneCommentsDisabled%>"
                               tabIndex="<%=tabIndex++%>"
                               maxLength="300"><%= szSzTxtRsrcPhoneComments %>
      </impact:validateTextArea>
    </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
   <td align="left">
    <%if ( !phoneDeleteButtonHide ){%>
           <impact:ButtonTag name="btnDeletePhoneDetail" img="btnDelete" editableMode="<%= EditableMode.EDIT %>" function="return deletePhoneRow();" form="frmPhoneDetail" action="/resource/ResourceDetail/deletePhoneDetail" tabIndex="<%=tabIndex++%>"/>
  <%}%>
   </td>
   <td align="right">
   <%if( !phoneSaveButtonHide )
     {%>
      <impact:ButtonTag name="btnSavePhoneDetail"
                  img="btnSave"
                        align="right"
      editableMode="<%= EditableMode.EDIT %>"
      function="return savePhoneDetail();"
      form="frmPhoneDetail"
      action="/resource/ResourceDetail/savePhoneDetail"
                        tabIndex="<%=tabIndex++%>"/>
   <%}%>
   </td>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

