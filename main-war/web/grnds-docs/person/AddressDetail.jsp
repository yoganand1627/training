<%//*  JSP Name:     Address Detail
      //*  Created by:   ? ( Change Log added by Jenn Casdorph 05/13/2003
      //*  Date Created: ? ( Change Log created 05/13/2003
      //*
      //*  Description:
      //*  This JSP will be used to maintain address details for the address list.
      //*
      //** Change History:
      //**  Date        User              Description
      //**  --------   ----------------  --------------------------------------------------
      //**  05/13/03    CASDORJM          SIR 17462:  Added a check around the Address Type
      //**                                to make sure we were not in ADD mode.  If we are in
      //**                                add mode the Address Type should be blank.
      //**  09/26/03     CORLEYAN         SIR 19780 Attenion field should have a max length of 30
      //**  02/27/2009   bgehlot          STGAP00012734 MR-019 Added the excludeOptions to Remove the -None- from the 
      //**                                County DropDown Box on Address Detail Page.%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.AddressDetailConversation"%>




<%@ page import="java.util.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="java.util.ArrayList"%> 

<%
   String formName = "frmAddressDetail";
   String url = "/person/AddressDetail/saveAddress";
   int tabIndex = 1;
   ROWCCMN42SOG00 addressRow = (ROWCCMN42SOG00) request.getAttribute("AddressDetail_Attribute");
   int iIndex = 0;
   String txtLdIdAddress = StringHelper.EMPTY_STRING;
   Date dateTsLastUpdate = null;
   String txtUlIdPerson = null;
   String txtSzAddrPersAddrAttn = StringHelper.EMPTY_STRING;
   String txtLAddrZip = StringHelper.EMPTY_STRING;
   String txtPersonEmail = StringHelper.EMPTY_STRING;
   String txtSzCdPersAddrLinkType = StringHelper.EMPTY_STRING;
   String txtDtDtPersAddrLinkStart = StringHelper.EMPTY_STRING;
   String txtDtDtPersAddrLinkEnd = StringHelper.EMPTY_STRING;
   String bIndPersAddrLinkPrimary = StringHelper.EMPTY_STRING;
   String bIndPersAddrLinkInvalid = StringHelper.EMPTY_STRING;
   String bIndRemovalHome = StringHelper.EMPTY_STRING;
   String szCReqFuncCd = StringHelper.EMPTY_STRING;
   String pageMode = PageModeConstants.VIEW;
   String addressTypeDisabled = ArchitectureConstants.FALSE;
   String attentionDisabled = ArchitectureConstants.FALSE;
   String emailDisabled = ArchitectureConstants.FALSE;
   boolean saveButtonHide = false;
   boolean newUsingButtonHide = false;
   boolean setEndDateButtonHide = false;
   String cbxInvalidDisabled = ArchitectureConstants.FALSE;
   String cbxPrimaryDisabled = ArchitectureConstants.FALSE;
   String cbxRemovalHomeDisabled = ArchitectureConstants.TRUE;
   org.exolab.castor.types.Date today = DateHelper.toCastorDate(new java.util.Date());
   txtDtDtPersAddrLinkStart = FormattingHelper.formatDate(today);

   BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                    .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
   UserProfile user = UserProfileHelper.getUserProfile(request);

   //Set up the exclude array.
   ArrayList<String> excludeOptions = new ArrayList<String>();
   //Exclude -None-.
   excludeOptions.add(CodesTables.CCOUNT_XXX);

   // If the mode was set in the activity method, get it.
   // Since this page is accessed via a submodule, it should
   // use the page mode passed to it by the including JSP.
   if (request.getParameter("cReqFuncCd") != null) {
     szCReqFuncCd = request.getParameter("cReqFuncCd");
   }
   if (state.getAttribute(AddressListConversation.PAGE_MODE_KEY, request) != null
       && !"A".equalsIgnoreCase(szCReqFuncCd)) {
     pageMode = (String) state.getAttribute(AddressListConversation.PAGE_MODE_KEY, request);
   } else if ("A".equalsIgnoreCase(szCReqFuncCd)) {
     pageMode = PageModeConstants.NEW;
   }
   if (StringHelper.getSafeString(request.getParameter("indexNum")) != null) {
     iIndex = Integer.parseInt(request.getParameter("indexNum"));
   }
   if (request.getParameter("txtUlIdPerson") != null) {
     txtUlIdPerson = request.getParameter("txtUlIdPerson");
   }
   if (request.getParameter("txtSzAddrPersAddrAttn") != null) {
     txtSzAddrPersAddrAttn = request.getParameter("txtSzAddrPersAddrAttn");
   }
   if (request.getParameter("txtLAddrZip") != null) {
     txtLAddrZip = request.getParameter("txtLAddrZip");
   }
   if (request.getParameter("txtPersonEmail") != null) {
     txtPersonEmail = request.getParameter("txtPersonEmail");
   }

   // JMC SIR 17462 - The Address Type was getting passed from the
   // Intake Call Person Detail page incorrectly.  (The fields have the
   // same names - hence when the Call Person Detail form is submitted the
   // Address Type is submitted into the request as a parameter.  We are able
   // to clear the main address data in the AddressDetailConversation by putting
   // a new empty AddressBean into the request, but we are unable to overwrite
   // selSzCdPersAddrLinkType in the conversation since it's a parameter.
   if ((request.getParameter("selSzCdPersAddrLinkType") != null)
       && !(AddressListConversation.REQ_FUNC_CD_ADD.equals(szCReqFuncCd))) {
     txtSzCdPersAddrLinkType = request.getParameter("selSzCdPersAddrLinkType");
   }

   if (StringHelper.getSafeString(request.getParameter("cbxBIndPersAddrLinkPrimary")) != null) {
     bIndPersAddrLinkPrimary = ArchitectureConstants.TRUE;
   }
   if (StringHelper.getSafeString(request.getParameter("cbxBIndPersAddrLinkInvalid")) != null) {
     bIndPersAddrLinkInvalid = ArchitectureConstants.TRUE;
   }
   if (StringHelper.getSafeString(request.getParameter("cbxBIndRemovalHome")) != null) {
     bIndRemovalHome = ArchitectureConstants.TRUE;
   }

   if (request.getParameter("txtLdIdAddress") != null) {
     txtLdIdAddress = request.getParameter("txtLdIdAddress");
   }
   if (request.getParameter("txtTsLastUpdate") != null) {
     dateTsLastUpdate = (Date) SerializationHelper.deserializeObject(request.getParameter("txtTsLastUpdate"));
   }

   if ((request.getAttribute(AddressDetailConversation.MARK_REMOVAL_ALLOWED) != null)
       && (ArchitectureConstants.Y.equals(request.getAttribute(AddressDetailConversation.MARK_REMOVAL_ALLOWED)))) {
     cbxRemovalHomeDisabled = ArchitectureConstants.FALSE;
   }

   // If address row has been returned from conversation
   if (addressRow != null && "U".equalsIgnoreCase(szCReqFuncCd)) {
     iIndex = Integer.parseInt(request.getParameter("indexNum"));
     txtLdIdAddress = String.valueOf(addressRow.getLdIdAddress());
     dateTsLastUpdate = addressRow.getTsLastUpdate();
     if (addressRow.getSzAddrPersAddrAttn() != null) {
       txtSzAddrPersAddrAttn = addressRow.getSzAddrPersAddrAttn();
     }
     if (addressRow.getSzTxtPersonEmail() != null) {
       txtPersonEmail = addressRow.getSzTxtPersonEmail();
     }
     txtLAddrZip = addressRow.getLAddrZip();

     if (txtLAddrZip != null && txtLAddrZip.length() > 5) {

       txtLAddrZip = txtLAddrZip.substring(0, 5);
     }

     txtSzCdPersAddrLinkType = addressRow.getSzCdPersAddrLinkType();

     if (addressRow.getBIndPersAddrLinkPrimary().compareToIgnoreCase(ArchitectureConstants.Y) == 0) {
       bIndPersAddrLinkPrimary = ArchitectureConstants.TRUE;
     } else {
       bIndPersAddrLinkPrimary = ArchitectureConstants.FALSE;
     }

     if (addressRow.getBIndPersAddrLinkInvalid().compareToIgnoreCase(ArchitectureConstants.Y) == 0) {
       bIndPersAddrLinkInvalid = ArchitectureConstants.TRUE;
     } else {
       bIndPersAddrLinkInvalid = ArchitectureConstants.FALSE;
     }

     if (StringHelper.getNonNullString(addressRow.getBIndRemovalHome()).compareToIgnoreCase(ArchitectureConstants.Y) == 0) {
       bIndRemovalHome = ArchitectureConstants.TRUE;
     } else {
       bIndRemovalHome = ArchitectureConstants.FALSE;
     }

     if (addressRow.getDtDtPersAddrLinkEnd() != null) {
       txtDtDtPersAddrLinkEnd = FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkEnd());
     }

     if (addressRow.getDtDtPersAddrLinkStart() != null) {
       txtDtDtPersAddrLinkStart = FormattingHelper.formatDate(addressRow.getDtDtPersAddrLinkStart());
     }
   }

   /* enable/disable section */
   if (szCReqFuncCd.compareToIgnoreCase(ArchitectureConstants.U) == 0
       && (pageMode.equals(PageModeConstants.EDIT) || pageMode.equals(PageModeConstants.MODIFY))) {
     newUsingButtonHide = true;
     if (!user.hasRight(UserProfile.SEC_MNTN_PERSON)
         || (pageMode.equals(PageModeConstants.EDIT) || pageMode.equals(PageModeConstants.MODIFY))) {
       addressTypeDisabled = ArchitectureConstants.TRUE;
       attentionDisabled = ArchitectureConstants.TRUE;
       emailDisabled = ArchitectureConstants.TRUE;
       cbxInvalidDisabled = ArchitectureConstants.FALSE;
       cbxPrimaryDisabled = ArchitectureConstants.FALSE;
     }
   }

   //Hide buttons if in view mode
   if (pageMode.equals(PageModeConstants.VIEW)) {
     saveButtonHide = true;
     newUsingButtonHide = true;
     setEndDateButtonHide = true;
   }

   if (pageMode.equals(PageModeConstants.NEW)) {
     newUsingButtonHide = false;
   }
 %>

<script src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/addressValidation.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.onbeforeunload = function()
{
  return IsDirty();
}

function fsetEndDate()
{
  var form = "<%=formName%>";
  frmAddressDetail.txtDtDtPersAddrLinkEnd.value = "<%=DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT)%>";
  disableValidation("<%=formName%>");
  return true;
}


function newUsing()
{
  disableValidation("<%=formName%>");
  return true;
}

<%String onclick2 = "javascript:setIsDirtyCalled(false); return saveDetail();";
      String action = "#";%>

function saveDetail()
  {  
    
    var retVal = true;
    retVal = validateAddressOnSave("<%=formName%>", "<%=url%>", "");    
      
   if(retVal == "false"){    
      <%onclick2 = "";%>
      <%action = "/person/AddressDetail/saveAddress";%>
    }
    
    if(retVal == "true"){    
      <%onclick2 = "javascript:setIsDirtyCalled(false); return saveDetail();";%>
      <%action = "/person/AddressDetail/saveAddress";%>
    }
    
    return retVal; 
}
//End Java Script-->
</script>


<impact:validateErrors/>

<impact:validateForm
        name="<%=formName%>"
        method="post"
        action="<%=url%>"        
        pageMode="<%=pageMode%>"
        schema="/WEB-INF/Constraints.xsd">

<impact:validateInput type="hidden" name="indexNum" value="<%=String.valueOf(iIndex)%>" />
<impact:validateInput type="hidden" name="txtLdIdAddress" value="<%=txtLdIdAddress%>"/>
<impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>"/>
<impact:validateInput type="hidden" name="txtTsLastUpdate" value="<%=SerializationHelper.serializeObject(dateTsLastUpdate)%>"/>
<impact:validateInput type="hidden" name="txtUlIdPerson" value="<%=txtUlIdPerson%>" editableMode="<%=EditableMode.EDIT%>" />

<table border="0" cellspacing="0" cellpadding="3" width="760" class="tableBorder">
  <tr>
    <th colspan="8">
      Address Information
    </th>
  </tr>
  <tr>
    <td width="10%">
  <impact:validateSelect name="selSzCdPersAddrLinkType"
                               label="Type"
                               required="true"
             tabIndex="<%=tabIndex++%>"
             disabled="<%=addressTypeDisabled%>"
                               codesTable="CADDRTYP"
                               width="20%"
                               value="<%=txtSzCdPersAddrLinkType%>"/>
    </td>
    <td width="10%">
        <impact:validateDisplayOnlyField  name="txtDtDtPersAddrLinkStart"
                                          label="Start Date"
                                          width="15%"
                                          value="<%=txtDtDtPersAddrLinkStart%>" />
    </td>
    <td width="8%">
        <impact:validateDisplayOnlyField  name="txtDtDtPersAddrLinkEnd"
                                          label="End Date"
                                          width="15%"
                                          value="<%=txtDtDtPersAddrLinkEnd%>"  />
    </td>
    <td class="alignRight">
         <%
           if (!setEndDateButtonHide) {
         %>
              <a onClick="javascript:updateDisplayOnlyField( 'frmAddressDetail', 'txtDtDtPersAddrLinkEnd', '<%=FormattingHelper.formatDate(new java.util.Date())%>' );setPageDirtyFlag(true);" tabIndex="<%=tabIndex++%>" >
              <img src="/grnds-docs/images/shared/btnSetEndDate.gif" class="md" border="0" >
              </a>
    <%
      } else {
    %> &nbsp;  <%
    }
  %>
    </td>
  </tr>
  <tr>
    <td>
           <impact:validateInput type="text"
                                 name="txtSzAddrPersAddrAttn"
         label="Attention"
         tabIndex="<%=tabIndex++%>"
         cssClass="formInput"
         value="<%=txtSzAddrPersAddrAttn%>"
         constraint="Name"
                                 maxLength="30"
         disabled="<%=attentionDisabled%>" />
   </td>
   <td>
          <impact:validateInput type="checkbox"
                                name="cbxBIndPersAddrLinkPrimary"
                                checked="<%=bIndPersAddrLinkPrimary%>"
                                tabIndex="<%=tabIndex++%>"
                                disabled="<%=cbxPrimaryDisabled%>" />Primary
         </td>
   <td>
          <impact:validateInput type="checkbox"
                                name="cbxBIndPersAddrLinkInvalid"
                                checked="<%=bIndPersAddrLinkInvalid%>"
                                tabIndex="<%=tabIndex++%>"
                                disabled="<%=cbxInvalidDisabled%>" />Invalid
         </td>
    <td colspan="3">
          <impact:validateInput type="checkbox"
                                name="cbxBIndRemovalHome"
                                checked="<%=bIndRemovalHome%>"
                                tabIndex="<%=tabIndex++%>"
                                disabled="<%=cbxRemovalHomeDisabled%>" />Removal Home
         </td>
  </tr>
  <tr>
         <td>
           <impact:validateInput type="text"
                                 name="szTxtPersonEmail"
                                 label="E-mail Address"
                                 tabIndex="<%=tabIndex++%>"
                                 cssClass="formInput"
                                 value="<%=txtPersonEmail%>"
                                 constraint="Email"
                                 maxLength="30"
                                 disabled="<%=emailDisabled%>" />
   </td>
   </tr>
   <tr>
   <td colspan="7">
              <%
                /* BEGIN Address Submodule */
              %>
              <%
                AddressSubDB addressSubDB = new AddressSubDB();
                  addressSubDB.setFormName("frmAddressDetail");
                  addressSubDB.setPageMode(pageMode);
                  addressSubDB.setAddressSubmoduleName("");
                  addressSubDB.setCommentsVisible(true);
                  addressSubDB.setCommentsRequired(false);
                  addressSubDB.setStreetRequired(false);
                  addressSubDB.setZipRequired(false);
                  addressSubDB.setCommentsDisabled(false);
                  addressSubDB.setAddressRequired(!pageMode.equals(PageModeConstants.EDIT));
                  addressSubDB.setAddressDisabled(pageMode.equals(PageModeConstants.EDIT));
                  addressSubDB.setTabIndex(tabIndex);
                  /*MR-019 Added this to exclude -None- in county dropdown box */
                  addressSubDB.setExcludeCounty(excludeOptions);
                  AddressSubDB.setIntoRequest(addressSubDB, request);
              %>
              <%@ include file="/grnds-docs/common/AddressSub.jsp" %>
              <%
                tabIndex = addressSubDB.getTabIndex();
                  AddressSubDB.removeFromRequest(request);
              %>
              <%
                /* END Address Submodule */
              %>
   </td>
 </tr>
</table>

<table border="0" cellspacing="0" cellpadding="3" width="760">
   <tr>
     <td align="right">
       <%
         if (!newUsingButtonHide) {
       %>
       <impact:ButtonTag name="btnNewUsing"
                         img="btnNewUsing"
                         function="newUsing();"
                         form="frmAddressDetail"
                         action="/person/AddressDetail/addressListPullBack"
                         tabIndex="<%=tabIndex++%>"/>
       <%
         }
       %>


       <%
         if (!saveButtonHide) {
       %>
       <impact:ButtonTag name="btnSave"
                         img="btnSave"
                         restrictRepost ="true"                         
                         function="<%=onclick2%>"
                         form="frmAddressDetail"
                         action="<%=action%>"
                         tabIndex="<%=tabIndex++%>"/>
       <%
         }
       %>
     </td>
   </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>


