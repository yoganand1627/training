<%
/**
 * JSP Name:     SecurityProfileMnt.jsp
 * Created by:   Habib Hadjimani
 * Date Created: 10/01/02
 *
 * Description:
 * The Security Profile Maintenance page allows security profiles to be added,
 * removed and maintained.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/01/03  Todd Reser        Added Change Log and Flowerbox comments.
*/

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CARC12SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<% /* Import State Management classes - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%/* Import PageMode and other utilities used on the page - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="java.util.Enumeration" %>

<%/* Import needed for Messages */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%/* Import needed for Form Launch */ %>

<%
  //Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
  //  to see how the page functions, but it should always be initialized to view mode.
  String pageMode = PageModeConstants.VIEW;
  String sProfileRadioIsDisabled = "true";
  String sProfileRadioIsDisabledTwo= "true";
  String sProfileRadioIsDisabledThree = "true";

  int tabIndex = 1;

  UserProfile userProfile = UserProfileHelper.getUserProfile( request );
  boolean bHasRightModifyIT = userProfile.hasRight(UserProfile.SEC_RESTRICT_SEC);
  boolean bHasRightModify = userProfile.hasRight(UserProfile.SEC_MNTN_SEC_PROFILE);
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  }
  else if( state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request ) != null )
  {
    pageMode = (String)state.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME, request);
  }
  if (userProfile == null )
    userProfile = new UserProfile();

  //Everything above this point should be in every page.
  boolean addButtonHide = false;
  boolean deleteButtonHide = false;
  boolean newUsingButtonHide = false;

  if( pageMode.equals(PageModeConstants.VIEW))
  {
    addButtonHide = true;
    deleteButtonHide = true;
    newUsingButtonHide = true;
  }

  CARC12SO carc12so = (CARC12SO) state.getAttribute("CARC12S_SecurityProfiles", request);
  ROWCARC12SOG00_ARRAY profileArray = carc12so.getROWCARC12SOG00_ARRAY();

%>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="JavaScript1.2">

/*
*This function submits the form to bring up Security detail page.
*/
function submitFormToSecurityDetailWindow( indexNum, cReqFuncCd)
{
  var x = document.frmSecurityProfileMnt;
  x.indexNum.value = indexNum;
  x.cReqFuncCd.value = cReqFuncCd;
  disableValidation( "frmSecurityProfileMnt" );
  submitValidateForm( "frmSecurityProfileMnt", "/admin/SecurityProfileMnt/securityProfileDetail" );
}

function submitFormForDeleteNewUsing(cReqFuncCd)
{
  enableValidation( "frmSecurityProfileMnt" );
  var x = document.frmSecurityProfileMnt;
  x.cReqFuncCd.value = cReqFuncCd;

  if (cReqFuncCd == "A")
  {
    x.indexNum.value = -1;
  }

//!!! TODO 'N' should check for selection?
  if ( cReqFuncCd == "N")
  {
    return true;
  }

  if (x.cReqFuncCd.value == "D" && checkForSelection())
  {
    bRetValue = confirm('<%= MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") %>');
    disableValidation( "frmSecurityProfileMnt" );
    return bRetValue;
  }

  return true;
}

// check to see if a radio button is selected for new using
function checkForSelection()
{
  var x = document.frmSecurityProfileMnt;
  var radioButtonChecked = false;
  for(var i=0; i < x.rbSecurityProfileRadioIndex.length ; i++)
  {
    if(x.rbSecurityProfileRadioIndex[i].checked == true)
    {
      radioButtonChecked = true;
      break;
    }
  }
  return radioButtonChecked;
}

</script>
<impact:validateErrors/>
<impact:validateForm name="frmSecurityProfileMnt"
     method="post"
     validationClass="gov.georgia.dhr.dfcs.sacwis.web.admin.SecurityProfileMntCustomValidation"
     action="/admin/SecurityProfileMnt/displaySecurityProfileMnt"
     schema="/WEB-INF/Constraints.xsd"
     onSubmit=""
     pageMode="<%=pageMode%>">
<impact:validateInput type="hidden" name="indexNum" editableMode="<%=EditableMode.EDIT%>" />
<impact:validateInput type="hidden" name="cReqFuncCd" editableMode="<%=EditableMode.EDIT%>" />

<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder" border="0">
<th> Security Profiles </th>
</table>
<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder" border="0">
<%
   int itemCount = 0;
   Enumeration rowObjects = carc12so.getROWCARC12SOG00_ARRAY().enumerateROWCARC12SOG00();
   while ( rowObjects.hasMoreElements() )
   {
     if ( itemCount%3 == 0 )
     {
%>
  <tr valign="top">
<%
     }
     ROWCARC12SOG00 rowObject = (ROWCARC12SOG00)rowObjects.nextElement();
     if (bHasRightModifyIT)
     {
      sProfileRadioIsDisabled = "false";
     }
     else if (bHasRightModify && "N".equals(rowObject.getCIndRestrict()))
     {
       sProfileRadioIsDisabled = "false";
     }
     else
     {
       sProfileRadioIsDisabled = "true";
     }
    %>
    <td width="33%" >
    <impact:validateInput editableMode="<%=EditableMode.EDIT%>" name="rbSecurityProfileRadioIndex" type="radio" disabled="<%=sProfileRadioIsDisabled%>" value="<%= String.valueOf( itemCount ) %>" tabIndex="<%= tabIndex++ %>"/><a href="javascript:submitFormToSecurityDetailWindow( '<%= itemCount %>', 'U')"><%= rowObject.getSzNmSecurityClass()%></a>
    </td>
    <%
     if ( itemCount%3 == 2 )
     {
%>
  </tr>
<%
     }
     itemCount++;
   }
   if ( itemCount%3 != 0)
   {
     while ( itemCount%3 != 0 )
     {
%>
       <td width="33%" >
       &nbsp;
       </td>
<%
       itemCount++;
     }
%>
  </tr>
<%
   }
%>
</table>

<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td align="left">
        <impact:ButtonTag name="btnDelete"
                          img="btnDelete"
                          disabled='<%= "" + deleteButtonHide %>'
                          function="return submitFormForDeleteNewUsing('D');"
                          form="frmSecurityProfileMnt"
                          action="/admin/SecurityProfileMnt/deleteProfile"
                          tabIndex="<%= tabIndex++ %>"/>
    </td>
    <td align="right">
        <impact:ButtonTag name="btnNewUsing"
                          img="btnNewUsing"
                          disabled='<%= "" + newUsingButtonHide %>'
                          function="return submitFormForDeleteNewUsing('N');"
                          form="frmSecurityProfileMnt"
                          action="/admin/SecurityProfileMnt/securityProfileDetail"
                          tabIndex="<%= tabIndex++ %>"/>

        <impact:ButtonTag name="btnAdd"
                          img="btnAdd"
                          disabled='<%= "" + addButtonHide %>'
                          function="return submitFormForDeleteNewUsing('A');"
                          form="frmSecurityProfileMnt"
                          action="/admin/SecurityProfileMnt/securityProfileDetail"
                          tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>