<%
//*  JSP Name:     PhoneDetail.jsp
//*  Created by:   Heather Dean
//*  Date Created: 2/21/03
//*
//*
//*  Description:
//*              This page allows a user to edit and delete the Phone Detail
//*              information.
//*
/* Change History:
  Date      User              Description
  --------  ----------------  --------------------------------------------------
  08/06/03  Todd Reser        Modified/Added Flowerbox and Changelog.
  01/15/04  RIOSJA            SIR 22396 - removed the following function call
                              from the savePhoneDetail() JavaScript function
                              because the Save button is already calling that
                              same command:
                              submitValidateForm("frmPhoneDetail","/fad/HomeInfrmtn/savePhoneDetail");
  11/09/04  Linda Reed        SIR 22684 - This SIR 'un-requires' phone on FAD dialogue for Inquiry status.
                              So, need to selectively include the Primary phone type on the Phone Type drop-down.
                              Instead of always excluding Primary phone type from drop-down,  now it will
                              be displayed when no Primary phone exists.  But, do not allow multiple
                              Primary phones, so exclude the Primary phone type when a primary phone
                              already exists.
*/
%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>


<%
//  String TRACE_TAG = "PhoneDetail.jsp";
  String tmpLNbrFacilPhoneNumber = "";
  int iUlIdResource = 0;
  String szCReqFuncCd = "";
  int iUlIdRsrcPhone = 0;
  int iIndex = 0;
  Date dateTsLastUpdate = null;
  String szLNbrFacilPhoneNumber = "";
  String szLNbrFacilPhoneExtension = "";
  String szSzTxtRsrcPhoneComments = "";
  String selSzCdFacilPhoneType = "";
  String cbxCIndRsrcTransport = "0";
  String classResource = "false";
  String fadResource = "false";
  String pageMode = PageModeConstants.VIEW;
  String phoneTypeDisabled = "false";
  String phoneNumberDisabled = "false";
  String phoneExtensionDisabled = "false";
  String phoneCommentsDisabled = "false";
  String onlyButton = "false";
  boolean phoneSaveButtonHide = false;
  boolean phoneDeleteButtonHide = false;
  
  

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  if( PageMode.getPageMode( request ) != null )
  {
    pageMode = PageMode.getPageMode( request );
  }
  List excludePrimaryOption = new ArrayList();
  ROWCFAD07SOG00 phoneRow = (ROWCFAD07SOG00) state.getAttribute( "currentPhone", request );
  // If phone row has been returned from conversation
  if ( phoneRow != null)
  {
    iUlIdRsrcPhone = phoneRow.getUlIdRsrcPhone();
    dateTsLastUpdate = phoneRow.getTsLastUpdate();
    szLNbrFacilPhoneNumber = FormattingHelper.formatPhone( phoneRow.getLNbrFacilPhoneNumber() );
    szLNbrFacilPhoneExtension = phoneRow.getLNbrFacilPhoneExtension();
    szSzTxtRsrcPhoneComments = phoneRow.getSzTxtRsrcPhoneComments();
    selSzCdFacilPhoneType = phoneRow.getSzCdFacilPhoneType();
  } else  {
    szSzTxtRsrcPhoneComments = ContextHelper.getStringSafe( request, "txtszTxtRsrcPhoneComments" );
    szLNbrFacilPhoneExtension = ContextHelper.getStringSafe( request, "txtLNbrFacilPhoneExtension" );
    szLNbrFacilPhoneNumber =  ContextHelper.getStringSafe( request, "txtLNbrFacilPhoneNumber" );
    selSzCdFacilPhoneType = ContextHelper.getStringSafe( request, "selSzCdFacilPhoneType" );
    tmpLNbrFacilPhoneNumber = ContextHelper.getStringSafe( request, "selSzCdFacilPhoneType" );
    iUlIdResource =  ContextHelper.getIntSafe( request, "txtUlIdResource" );
    iUlIdRsrcPhone =  ContextHelper.getIntSafe( request, "IdResourcePhone" );
    dateTsLastUpdate = ContextHelper.getJavaDateSafe( request, "txtTsLastUpdate");
    phoneDeleteButtonHide = true;
  }

    szCReqFuncCd = ContextHelper.getStringSafe( request, "cReqFuncCd");
    iIndex = ContextHelper.getIntSafe( request, "rbPhoneRadioIndex");
    cbxCIndRsrcTransport = ContextHelper.getStringSafe( request, "cbxCIndRsrcTransport");
    iIndex = ContextHelper.getIntSafe( request, "indexNum" );

  // If in Add mode
 if ("A".equalsIgnoreCase(szCReqFuncCd))
 {
   iUlIdRsrcPhone = 0;
   iIndex = 0;
   dateTsLastUpdate = new Date();
   szLNbrFacilPhoneNumber = "";
   szLNbrFacilPhoneExtension = "";
   szSzTxtRsrcPhoneComments = "";
   selSzCdFacilPhoneType = "";
   phoneDeleteButtonHide = true;
  }

  // If a FAD resource
  if( request.getParameter("fadResource") != null && "true".equals(request.getParameter("fadResource")) )
  {
    //pageMode = PageMode.VIEW;
    fadResource = "true";
    phoneSaveButtonHide = true;
    phoneDeleteButtonHide = true;
  }

  //  SIR 22684 - Primary Phone is no longer required on Add Home page in FAD dialogue for homes in Inquiry status.
  //  'Primary' Phone code needs to be displayed on Phone Type drop-down to add a Primary Phone later;
  //  however, do not display Primary code in Phone Type drop-down if a Primary Phone already exists,
  //  since you can only have one Primary phone.
  String selSzCdFacilPhoneType2 = "";
  CFAD07SO cfad07so = (CFAD07SO)state.getAttribute("CFAD07SO", request);
  //  If the currently displayed phone is not the Primary Phone, check to see if a primary phone exists,
  //  so the drop-down codeset can be built correctly, with or without the primary code.
  if (!selSzCdFacilPhoneType.equals( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY ) )
  {
    if (cfad07so != null)
    {// Check every phone record to see if Primary Phone already exists.
      ROWCFAD07SOG00_ARRAY phoneArray = new ROWCFAD07SOG00_ARRAY();
      phoneArray = cfad07so.getROWCFAD07SOG00_ARRAY();
      for (int phoneIndex = 0; phoneIndex < (phoneArray.getUlRowQty()); phoneIndex++)
      {
        ROWCFAD07SOG00 phoneRow2 = new ROWCFAD07SOG00();
        phoneRow2 = phoneArray.getROWCFAD07SOG00(phoneIndex);
        selSzCdFacilPhoneType2 = phoneRow2.getSzCdFacilPhoneType();
        if( selSzCdFacilPhoneType2.equals( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY ) )
        {// if Primary phone exists, do not display code Primary in Phone Type drop-down.
          excludePrimaryOption.add( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY );
        }
      }
      selSzCdFacilPhoneType2 = "";
    }
  }

  // If primary phone not in Add mode
  if(!"A".equals(szCReqFuncCd) && selSzCdFacilPhoneType.equals( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY ))
  {
    phoneTypeDisabled = "true";
    phoneDeleteButtonHide = true;
  }
  if(selSzCdFacilPhoneType != null && !selSzCdFacilPhoneType.trim().equals(""))
  {
    phoneTypeDisabled = "true";
    phoneDeleteButtonHide = true;

  }
  else{
  excludePrimaryOption.add( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY );
  }
 
  // If Update mode, disable the phoneType
  if("U".equals(szCReqFuncCd))
  {
    phoneTypeDisabled = "true";
  }
  // If other than primary phone in Add or Update mode
  if("A".equals(szCReqFuncCd) || ("U".equals(szCReqFuncCd) &&!selSzCdFacilPhoneType.equals( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY )) )
  {
    excludePrimaryOption.add( HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY );
  }

    
   //Hide buttons if in view mode
  if( pageMode.equals(PageModeConstants.VIEW) )
  {
    phoneDeleteButtonHide = true;
    phoneSaveButtonHide = true;
    phoneTypeDisabled = "true";
  }
  int tabIndex = 1;

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">

 /*
  *This function is called before the page unloads.
  */
window.onbeforeunload = function ()
{
    IsDirty();
};

 /*
  *This function is called when saving phone details.
  */
function savePhoneDetail()
{
  window.onbeforeunload = null;
  return true;
}

 /*
  *This function is called when deleting a phone record.
  */
function deletePhoneRow()
{
  var doDelete = false;

  window.onbeforeunload = null;
  disableValidation( 'frmPhoneDetail' );
  var x = document.frmPhoneDetail;
  if( x.selSzCdFacilPhoneType.value == "<%=  HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY  %>"  )
  {
    //MSG - A primary phone record may not be deleted.
    setInformationalMessage("<%=MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_PHONE_NO_DELETE)%>");
  }
  else
  {
    var cnfrm = window.confirm("<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>")
    if(cnfrm)
    {
      x.cReqFuncCd.value = "D";
      doDelete = true;
    }
  }

  return doDelete;
}


//End Java Script-->
</script>

<%
  if ( phoneDeleteButtonHide )
  {
    onlyButton = "true";
  }
%>

<impact:validateErrors/>
<impact:validateForm name="frmPhoneDetail"
  method="post"
  action="/fad/HomeInfrmtn/savePhoneDetail"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation"
  defaultButton="<%= onlyButton %>"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">
    <impact:validateInput type="hidden" name="IdResourcePhone" value="<%=String.valueOf(iUlIdRsrcPhone)%>"/>
    <impact:validateInput type="hidden" name="txtUlIdResource" value="<%=String.valueOf(iUlIdResource)%>"/>
    <impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>"/>
    <impact:validateInput type="hidden" name="rbPhoneRadioIndex" value="<%=String.valueOf(iIndex)%>"/>
    <impact:validateInput type="hidden" name="WindowName" value="PhoneDetail"/>
    <impact:validateInput type="hidden" name="txtTsLastUpdate" value="<%=String.valueOf( dateTsLastUpdate )%>"/>
    <impact:validateInput type="hidden" name="fadResource" value="<%=fadResource%>"/>

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
  <tr>
    <th colspan="2">Phone Information</th>
  </tr>
  
  <tr>
    <td width="15%"><impact:validateSelect
          label="Type"
          required="true"
          name="selSzCdFacilPhoneType"
          orderBy="decode"
          tabIndex="<%=tabIndex++%>"
          codesTable="CRSCPHON"
          disabled="<%=phoneTypeDisabled%>"
          excludeOptions="<%= excludePrimaryOption %>"
          value="<%=selSzCdFacilPhoneType%>"/></td>
  </tr>
  <tr>
    <td><impact:validateInput
          type="text"
          label="Phone"
          constraint="Phone"
          required="true"
          name="txtLNbrFacilPhoneNumber"
          disabled="<%=phoneNumberDisabled%>"
          cssClass="formInput"
          value="<%=szLNbrFacilPhoneNumber%>"
          size="15"
          maxLength ="15"
          tabIndex="<%=tabIndex++%>"/></td>
  </tr>
  <tr  align=left valign=top>
    <td><impact:validateInput
          type="text"
          label="&nbsp;&nbsp;Ext"
          name="txtLNbrFacilPhoneExtension"
          disabled="<%=phoneExtensionDisabled%>"
          cssClass="formInput"
          value="<%=szLNbrFacilPhoneExtension%>"
          constraint="PhoneExtension"
          size="8"
          maxLength="8"
          tabIndex="<%=tabIndex++%>"/></td>
  </tr>
  <tr>
    <td class="formLabel" colspan=1 valign="top">Comments:</td>
    <td>
      <impact:validateTextArea
          cols="120"
          rows="3"
          name="txtszTxtRsrcPhoneComments"
          disabled="<%=phoneCommentsDisabled%>"
          tabIndex="<%=tabIndex++%>"
          maxLength="300"><%=FormattingHelper.formatString(szSzTxtRsrcPhoneComments)%>
          </impact:validateTextArea>
    </td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="100%">
  <tr>
   <td align="left">
    <%if ( !phoneDeleteButtonHide ){%>
        <impact:ButtonTag
          name="btnDeletePhoneDetail"
          img="btnDelete"
          function="return deletePhoneRow();"
          form="frmPhoneDetail"
          restrictRepost="true"
          action="/fad/HomeInfrmtn/deletePhoneRow"
          editableMode="<%= EditableMode.EDIT %>"
          tabIndex="<%=tabIndex++%>"/>
  <%} else {%>
      &nbsp;
  <%}%>
   </td>
   <td align="right">
   <%if( !phoneSaveButtonHide ){%>
      <impact:ButtonTag
          name="btnSavePhoneDetail"
          img="btnSave"
          align="right"
          function="return savePhoneDetail();"
          form="frmPhoneDetail"
          restrictRepost="true"
          action="/fad/HomeInfrmtn/savePhoneDetail"
          editableMode="<%= EditableMode.EDIT %>"
          tabIndex="<%=tabIndex++%>"/>
   <%} else{%>
      &nbsp;
   <%}%>
   </td>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

