package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.web.resource.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import org.grnds.facility.log.GrndsTrace;
import gov.georgia.dhr.dfcs.sacwis.web.admin.SecurityProfileMntConversation;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.admin.SecurityProfileMntConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class SecurityProfileDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


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


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 /* Import State Management classes - Should be on every page */ 
      out.write("\r\n\r\n\r\n");
/* Import PageMode and other utilities used on the page - Should be on every page */ 
      out.write("\r\n\r\n\r\n\r\n");
/* Import needed for Form Launch */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<SCRIPT LANGUAGE=JavaScript>\r\n\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n/* this function runs at onLoad event of the window.\r\n** if user has ModifyIT right, everything is enabled.\r\n** if user does not have ModifyIT but has Modify right, then both Restrict Indicator & IT Security\r\n** are disabled. Value of \"FE\" corresponds to IT Security attribute.\r\n** if user does not have ModifyIT nor Modify rights, everything is disabled.\r\n**\r\n** This is done in javascript, because it is easier that trying to disable the one\r\n** checkbox in the entire checkbox group using java\r\n**\r\n** This function is only run if the java variable isRestrictITCbxChecked is true\r\n*/\r\n\r\nfunction disableITAttributeCbx()\r\n{\r\n  var x = document.frmSecurityProfileDetail;\r\n  sTmp2 = new String(\"\");\r\n  for(var i=0; i < x.elements.length ; i++)\r\n  {\r\n    if(x.elements[i].value == \"FE\")\r\n    {\r\n      x.elements[i].disabled = true;\r\n    }\r\n  }\r\n}\r\n\r\n");

// Ensuring that the fDisableCheckBox javascript function is only run if
// the java has hasRightModify and the isRestrictITCbxChecked is checked.
if (!hasRightModifyIT && hasRightModify && !isRestrictITCbxChecked)
{

      out.write("\r\n  window.attachEvent ('onload', disableITAttributeCbx);\r\n");

}

      out.write("\r\n\r\n//Confirm on Exit Message\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n\r\n/*\r\n** This function submits the form to bring up Security detail page.\r\n** sTmp2 is a string of 0's & 1's which creates txtSecurityClassProfil string.\r\n*/\r\nfunction submitFormToSaveSecurity()\r\n{\r\n  var x = document.frmSecurityProfileDetail;\r\n  var secClassProfileLen = ");
      out.print(iTxtSecClassProfileLen);
      out.write(";\r\n  var sRegionExclude = \"\";\r\n  sRegionExclude = \"");
      out.print(stExcludeRegion);
      out.write("\";\r\n  sTmp2 = new String(\"\");\r\n  for(var i=0; i < x.elements.length ; i++)\r\n  {\r\n    sElementName = new String(x.elements[i].name);\r\n    if( x.elements[i].type == \"checkbox\" && sElementName.substring(0,17) == \"cbSecurityProfile\")\r\n    {\r\n      sTmp2 = (x.elements[i].checked == true) ? sTmp2.concat(\"1\") : sTmp2.concat(\"0\");\r\n    }\r\n  }\r\n\r\n  /* SIR# 19653. regions 12, 13, 14 don't exist for now and it's for future use. this loop\r\n  ** routine will add 0 for the postions of those region so that the database gets updated\r\n  ** correctly. sRegionExclude variable holds \"1\" 's in the postions of those regions. this\r\n  ** is done because those region are hidden on the page, but they exist in the database */\r\n   for (var k = 0; k < sRegionExclude.length; k++)\r\n   {\r\n     if ( sRegionExclude.substring(k, k+1) == \"1\" )\r\n     {\r\n       sTmp2 = sTmp2.substring(0, k) + \"0\" + sTmp2.substring(k, sTmp2.length);\r\n     }\r\n   }\r\n\r\n  sTmp3 = new String(\"\");\r\n  /* the length of szTxtSecurityClassProfil is 100. but there may be less attributes\r\n");
      out.write("  ** therefore add \"0\" to the tail of the string */\r\n\r\n  for (var j=0; j < (secClassProfileLen - sTmp2.length ); j++)\r\n  {\r\n    sTmp3 = sTmp3.concat(\"0\");\r\n  }\r\n  sTmp2 = sTmp2.concat(sTmp3);\r\n  x.txtSzTxtSecurityClassProfil.value = sTmp2;\r\n}\r\n</script>\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSecurityProfileDetail");
      _jspx_th_impact_validateForm_0.setDefaultButton("true");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/admin/SecurityProfileMnt/securityProfileDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateErrors_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("indexNum");
          _jspx_th_impact_validateInput_0.setValue(iIndex);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_1.setValue(szCReqFuncCd);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Security Profile Detail\r\n    </th>\r\n  <tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setName("txtSzNmSecurityClass");
          _jspx_th_impact_validateInput_3.setLabel("Security Profile");
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setValue(szNmSecurityClass);
          _jspx_th_impact_validateInput_3.setConstraint("Any15");
          _jspx_th_impact_validateInput_3.setRequired("true");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    ");
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("hdntxtSzNmSecurityClass");
          _jspx_th_impact_validateInput_4.setValue(szNmSecurityClass);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n    </td>\r\n    <td></td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("checkbox");
          _jspx_th_impact_validateInput_5.setName("cbCIndRestrict");
          _jspx_th_impact_validateInput_5.setValue( iTCbxChecked );
          _jspx_th_impact_validateInput_5.setChecked(String.valueOf(iTCbxChecked));
          _jspx_th_impact_validateInput_5.setDisabled(String.valueOf(areITAttributesDisabled));
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" Restricted to IT Security</td>\r\n  </tr>\r\n</table>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" border=\"0\">\r\n  <tr>\r\n    <th colspan=\"3\">Security Profile Attributes</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(checkedValues);
          _jspx_th_impact_codesCheckbox_0.setName("cbSecurityProfile");
          _jspx_th_impact_codesCheckbox_0.setCodesTableName("CSECATTR");
          _jspx_th_impact_codesCheckbox_0.setColumns(3);
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_0.setExcludeCodes(arryayExcludeRegion);
          _jspx_th_impact_codesCheckbox_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td align=\"right\">\r\n");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setFunction("submitFormToSaveSecurity();");
          _jspx_th_impact_ButtonTag_0.setForm("frmSecurityProfileDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/SecurityProfileMnt/saveProfile");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CSECATTR");
    _jspx_th_impact_codeArray_0.setArrayName("securityAttributeArray");
    _jspx_th_impact_codeArray_0.setBlankValue("false");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateErrors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("txtSzTxtSecurityClassProfil");
    _jspx_th_impact_validateInput_2.setValue("");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
