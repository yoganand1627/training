<%
/**
 * JSP Name:     SecurityProfileDetail.jsp
 * Created by:   Habib Hadjimani
 * Date Created: 10/01/02
 *
 * Description:
 * The Security Profile Detail page allows security profiles to be maintained.
 * The user can modify or add the attributes for a profile by selecting the
 * appropriate attribute checkboxes.
**/
/*
  Change History:
  Date      User              Description
  --------  ----------------  -----------------------------------------------
  08/01/03  Todd Reser        Added Change Log and Flowerbox comments.  Removed
                              ToDo comment above isRestrictITCbxChecked because
                              Sanjay said the line now looks correct.  Someone
                              apparently fixed the line but forgot to remove the
                              ToDo comment.
  08/05/03  Hadjimh           SIR# 19653. "hide" security attributes from view
                              that are "future use"--not currently functional.
                              regions 12, 13, 14
  01/18/04  CORLEYAN          SIR 23369 - Increase the possible size of the
                              security profile to 100
  07/26/11  cwells            SMS #116335: ECEM 5.0 Updated size of the MAX_NUM_ATTRIBUTES 
  							  from 100(hardcoded) to UserProfile.MAX_NUM_ATTRIBUTES (200) 
  							  to accommodate database field update 
  							  and to respond better for future size increase                            
*/

%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.resource.*" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<% /* Import State Management classes - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%/* Import PageMode and other utilities used on the page - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>

<%/* Import needed for Form Launch */ %>
<%@ page import="org.grnds.facility.log.GrndsTrace" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.SecurityProfileMntConversation" %>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.admin.SecurityProfileMntConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%
  //Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
  //  to see how the page functions, but it should always be initialized to view mode.
  String pageMode = PageModeConstants.EDIT;

  String szCReqFuncCd = "";
  String iIndex = "";
  int tabIndex = 1;

  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  UserProfile userProfile = UserProfileHelper.getUserProfile( request );

  // get out the security information
  ROWCARC12SOG00 securityProfileRow = (ROWCARC12SOG00) state.getAttribute( "SecurityDetail_Attribute", request );
  List checkedValues= (List) request.getAttribute("checkedValues");
  // SIR# 19653. added the next two variable
  List arryayExcludeRegion = (List) request.getAttribute("arryayExcludeRegion");
  String stExcludeRegion = (String) request.getAttribute("sExcludeRegion");
  String sTxtSecurityClassProfile = (String)state.getAttribute(SecurityProfileMntConversation.TXT_SECURITY_CLASS_PROFIL, request);

  if (securityProfileRow == null)
  {
    securityProfileRow = new ROWCARC12SOG00();
  }
  String szNmSecurityClass = securityProfileRow.getSzNmSecurityClass();

  // calculate page mode from security
  boolean areITAttributesDisabled = true;
  boolean isRestrictITCbxChecked = "Y".equals( securityProfileRow.getCIndRestrict() );
  String iTCbxChecked = "Y".equalsIgnoreCase( securityProfileRow.getCIndRestrict() )?"Y":"N";
  boolean hasRightModifyIT = userProfile.hasRight(UserProfile.SEC_RESTRICT_SEC);
  boolean hasRightModify = userProfile.hasRight(UserProfile.SEC_MNTN_SEC_PROFILE);

  if (!hasRightModify && !hasRightModifyIT)
  {
    pageMode = PageModeConstants.VIEW;
  }

  else if (hasRightModifyIT && hasRightModify )
  {
    pageMode = PageModeConstants.EDIT;
    areITAttributesDisabled = false;
  }

  else if (!hasRightModifyIT && hasRightModify && isRestrictITCbxChecked)
  {
    pageMode = PageModeConstants.VIEW;
    areITAttributesDisabled = true;
  }

  else if (!hasRightModifyIT && hasRightModify && !isRestrictITCbxChecked)
  {
    pageMode = PageModeConstants.EDIT;
    areITAttributesDisabled = true;
  }

  // the length of szTxtSecurityClassProfil is 100. because it may change in near future,
  // it is safer to retrieve it thru the carc12so output
  // SMS #116335: ECEM 5.0 Updated size of the MAX_NUM_ATTRIBUTES from 100(hardcoded) 
  // to UserProfile.MAX_NUM_ATTRIBUTES (200) to accommodate database field update 
  // and to respond better for future size increase
  int iTxtSecClassProfileLen = UserProfile.MAX_NUM_ATTRIBUTES;
  if (sTxtSecurityClassProfile != null)
  {
    iTxtSecClassProfileLen = sTxtSecurityClassProfile.length();
  }

  if( request.getParameter("cReqFuncCd") != null )
  {
    szCReqFuncCd = request.getParameter("cReqFuncCd");
    if ("N".equals(szCReqFuncCd) )
    {
      if ( ( request.getParameter("rbSecurityProfileRadioIndex") != null ) &&
           !"".equals(request.getParameter("rbSecurityProfileRadioIndex")) )
      {
        iIndex =  request.getParameter("rbSecurityProfileRadioIndex");
      }
    }
    else if("U".equals(szCReqFuncCd) )
    {
      iIndex =  request.getParameter("indexNum");
    }
  }

  if("A".equals(szCReqFuncCd) )
  {
    szNmSecurityClass = "";
    checkedValues.clear();
  }
  else if("N".equals(szCReqFuncCd) )
  {
    szNmSecurityClass = "";
  }
  //String indRestrictParam = request.getParameter( "cbCIndRestrict" );
  //if ("Y".equals( indRestrictParam )) { iTCbxChecked = "true"; }
%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<SCRIPT LANGUAGE=JavaScript>

<impact:codeArray codeName="CSECATTR" arrayName="securityAttributeArray" blankValue="false"/>

/* this function runs at onLoad event of the window.
** if user has ModifyIT right, everything is enabled.
** if user does not have ModifyIT but has Modify right, then both Restrict Indicator & IT Security
** are disabled. Value of "FE" corresponds to IT Security attribute.
** if user does not have ModifyIT nor Modify rights, everything is disabled.
**
** This is done in javascript, because it is easier that trying to disable the one
** checkbox in the entire checkbox group using java
**
** This function is only run if the java variable isRestrictITCbxChecked is true
*/

function disableITAttributeCbx()
{
  var x = document.frmSecurityProfileDetail;
  sTmp2 = new String("");
  for(var i=0; i < x.elements.length ; i++)
  {
    if(x.elements[i].value == "FE")
    {
      x.elements[i].disabled = true;
    }
  }
}

<%
// Ensuring that the fDisableCheckBox javascript function is only run if
// the java has hasRightModify and the isRestrictITCbxChecked is checked.
if (!hasRightModifyIT && hasRightModify && !isRestrictITCbxChecked)
{
%>
  window.attachEvent ('onload', disableITAttributeCbx);
<%
}
%>

//Confirm on Exit Message
window.onbeforeunload = function ()
{
  IsDirty();
};


/*
** This function submits the form to bring up Security detail page.
** sTmp2 is a string of 0's & 1's which creates txtSecurityClassProfil string.
*/
function submitFormToSaveSecurity()
{
  var x = document.frmSecurityProfileDetail;
  var secClassProfileLen = <%=iTxtSecClassProfileLen%>;
  var sRegionExclude = "";
  sRegionExclude = "<%=stExcludeRegion%>";
  sTmp2 = new String("");
  for(var i=0; i < x.elements.length ; i++)
  {
    sElementName = new String(x.elements[i].name);
    if( x.elements[i].type == "checkbox" && sElementName.substring(0,17) == "cbSecurityProfile")
    {
      sTmp2 = (x.elements[i].checked == true) ? sTmp2.concat("1") : sTmp2.concat("0");
    }
  }

  /* SIR# 19653. regions 12, 13, 14 don't exist for now and it's for future use. this loop
  ** routine will add 0 for the postions of those region so that the database gets updated
  ** correctly. sRegionExclude variable holds "1" 's in the postions of those regions. this
  ** is done because those region are hidden on the page, but they exist in the database */
   for (var k = 0; k < sRegionExclude.length; k++)
   {
     if ( sRegionExclude.substring(k, k+1) == "1" )
     {
       sTmp2 = sTmp2.substring(0, k) + "0" + sTmp2.substring(k, sTmp2.length);
     }
   }

  sTmp3 = new String("");
  /* the length of szTxtSecurityClassProfil is 100. but there may be less attributes
  ** therefore add "0" to the tail of the string */

  for (var j=0; j < (secClassProfileLen - sTmp2.length ); j++)
  {
    sTmp3 = sTmp3.concat("0");
  }
  sTmp2 = sTmp2.concat(sTmp3);
  x.txtSzTxtSecurityClassProfil.value = sTmp2;
}
</script>
<impact:validateForm name="frmSecurityProfileDetail"
     defaultButton="true"
     method="post"
     action="/admin/SecurityProfileMnt/securityProfileDetail"
     schema="/WEB-INF/Constraints.xsd"
     pageMode="<%=pageMode%>">
<impact:validateErrors/>

<impact:validateInput type="hidden" name="indexNum" value="<%=iIndex%>" />
<impact:validateInput type="hidden" name="cReqFuncCd" value="<%=szCReqFuncCd%>" />
<impact:validateInput type="hidden" name="txtSzTxtSecurityClassProfil" value="" />
<table width="100%" border="0" cellspacing="0" cellpadding="3" class="tableBorder">
  <tr>
    <th colspan="4">Security Profile Detail
    </th>
  <tr>
  <tr>
    <td><impact:validateInput type="text"
                              name="txtSzNmSecurityClass"
                              label="Security Profile"
                              tabIndex="<%= tabIndex++ %>"
                              value="<%=szNmSecurityClass%>"
                              constraint="Any15"
                              required="true"/>

    <%--\This hidden field is used to compare if the user has changed the Security Profile txt field.  The comparsion
        is done on the conversation --%>
    <impact:validateInput type="hidden" name="hdntxtSzNmSecurityClass" value="<%=szNmSecurityClass%>"/>

    </td>
    <td></td>
    <td><impact:validateInput type="checkbox" name="cbCIndRestrict" value="<%= iTCbxChecked %>" checked="<%=String.valueOf(iTCbxChecked)%>" disabled="<%=String.valueOf(areITAttributesDisabled)%>" tabIndex="<%= tabIndex++ %>" /> Restricted to IT Security</td>
  </tr>
</table>

<table width="100%" cellspacing="0" cellpadding="3" class="tableBorder" border="0">
  <tr>
    <th colspan="3">Security Profile Attributes</th>
  </tr>
  <tr>
    <td>
      <impact:codesCheckbox defaultCodes="<%=checkedValues%>" name="cbSecurityProfile" codesTableName="CSECATTR" columns="3" isHorizontal="true" excludeCodes="<%=arryayExcludeRegion%>" tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>

<table width="100%" cellspacing="0" cellpadding="3" border="0">
  <tr>
    <td align="right">
<impact:ButtonTag name="btnSave"
          img="btnSave"
          function="submitFormToSaveSecurity();"
          form="frmSecurityProfileDetail"
          action="/admin/SecurityProfileMnt/saveProfile"
          tabIndex="<%= tabIndex++ %>"/>
    </td>
  </tr>
</table>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
