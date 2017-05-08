package org.apache.jsp.grnds_002ddocs.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

public final class SecurityProfileMnt_jsp extends org.apache.jasper.runtime.HttpJspBase
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


      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 /* Import State Management classes - Should be on every page */ 
      out.write("\r\n\r\n\r\n");
/* Import PageMode and other utilities used on the page - Should be on every page */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
/* Import needed for Messages */ 
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
/* Import needed for Form Launch */ 
      out.write("\r\n\r\n");

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


      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"JavaScript1.2\">\r\n\r\n/*\r\n*This function submits the form to bring up Security detail page.\r\n*/\r\nfunction submitFormToSecurityDetailWindow( indexNum, cReqFuncCd)\r\n{\r\n  var x = document.frmSecurityProfileMnt;\r\n  x.indexNum.value = indexNum;\r\n  x.cReqFuncCd.value = cReqFuncCd;\r\n  disableValidation( \"frmSecurityProfileMnt\" );\r\n  submitValidateForm( \"frmSecurityProfileMnt\", \"/admin/SecurityProfileMnt/securityProfileDetail\" );\r\n}\r\n\r\nfunction submitFormForDeleteNewUsing(cReqFuncCd)\r\n{\r\n  enableValidation( \"frmSecurityProfileMnt\" );\r\n  var x = document.frmSecurityProfileMnt;\r\n  x.cReqFuncCd.value = cReqFuncCd;\r\n\r\n  if (cReqFuncCd == \"A\")\r\n  {\r\n    x.indexNum.value = -1;\r\n  }\r\n\r\n//!!! TODO 'N' should check for selection?\r\n  if ( cReqFuncCd == \"N\")\r\n  {\r\n    return true;\r\n  }\r\n\r\n  if (x.cReqFuncCd.value == \"D\" && checkForSelection())\r\n  {\r\n    bRetValue = confirm('");
      out.print( MessageLookup.getMessageByName( "MSG_CONFIRM_ON_DELETE") );
      out.write("');\r\n    disableValidation( \"frmSecurityProfileMnt\" );\r\n    return bRetValue;\r\n  }\r\n\r\n  return true;\r\n}\r\n\r\n// check to see if a radio button is selected for new using\r\nfunction checkForSelection()\r\n{\r\n  var x = document.frmSecurityProfileMnt;\r\n  var radioButtonChecked = false;\r\n  for(var i=0; i < x.rbSecurityProfileRadioIndex.length ; i++)\r\n  {\r\n    if(x.rbSecurityProfileRadioIndex[i].checked == true)\r\n    {\r\n      radioButtonChecked = true;\r\n      break;\r\n    }\r\n  }\r\n  return radioButtonChecked;\r\n}\r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSecurityProfileMnt");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.admin.SecurityProfileMntCustomValidation");
      _jspx_th_impact_validateForm_0.setAction("/admin/SecurityProfileMnt/displaySecurityProfileMnt");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setOnSubmit("");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("indexNum");
          _jspx_th_impact_validateInput_0.setEditableMode(EditableMode.EDIT);
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
          _jspx_th_impact_validateInput_1.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" border=\"0\">\r\n<th> Security Profiles </th>\r\n</table>\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\" border=\"0\">\r\n");

   int itemCount = 0;
   Enumeration rowObjects = carc12so.getROWCARC12SOG00_ARRAY().enumerateROWCARC12SOG00();
   while ( rowObjects.hasMoreElements() )
   {
     if ( itemCount%3 == 0 )
     {

          out.write("\r\n  <tr valign=\"top\">\r\n");

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
    
          out.write("\r\n    <td width=\"33%\" >\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setEditableMode(EditableMode.EDIT);
          _jspx_th_impact_validateInput_2.setName("rbSecurityProfileRadioIndex");
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setDisabled(sProfileRadioIsDisabled);
          _jspx_th_impact_validateInput_2.setValue( String.valueOf( itemCount ) );
          _jspx_th_impact_validateInput_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("<a href=\"javascript:submitFormToSecurityDetailWindow( '");
          out.print( itemCount );
          out.write("', 'U')\">");
          out.print( rowObject.getSzNmSecurityClass());
          out.write("</a>\r\n    </td>\r\n    ");

     if ( itemCount%3 == 2 )
     {

          out.write("\r\n  </tr>\r\n");

     }
     itemCount++;
   }
   if ( itemCount%3 != 0)
   {
     while ( itemCount%3 != 0 )
     {

          out.write("\r\n       <td width=\"33%\" >\r\n       &nbsp;\r\n       </td>\r\n");

       itemCount++;
     }

          out.write("\r\n  </tr>\r\n");

   }

          out.write("\r\n</table>\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n  <tr>\r\n    <td align=\"left\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDelete");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setDisabled( "" + deleteButtonHide );
          _jspx_th_impact_ButtonTag_0.setFunction("return submitFormForDeleteNewUsing('D');");
          _jspx_th_impact_ButtonTag_0.setForm("frmSecurityProfileMnt");
          _jspx_th_impact_ButtonTag_0.setAction("/admin/SecurityProfileMnt/deleteProfile");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setDisabled( "" + newUsingButtonHide );
          _jspx_th_impact_ButtonTag_1.setFunction("return submitFormForDeleteNewUsing('N');");
          _jspx_th_impact_ButtonTag_1.setForm("frmSecurityProfileMnt");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/SecurityProfileMnt/securityProfileDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnAdd");
          _jspx_th_impact_ButtonTag_2.setImg("btnAdd");
          _jspx_th_impact_ButtonTag_2.setDisabled( "" + addButtonHide );
          _jspx_th_impact_ButtonTag_2.setFunction("return submitFormForDeleteNewUsing('A');");
          _jspx_th_impact_ButtonTag_2.setForm("frmSecurityProfileMnt");
          _jspx_th_impact_ButtonTag_2.setAction("/admin/SecurityProfileMnt/securityProfileDetail");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
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

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
