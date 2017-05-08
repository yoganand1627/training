package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import java.util.ArrayList;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class PhoneDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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

      out.write("\r\n\r\n<title> Phone Detail</title>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n /*\r\n  *This function is called before the page unloads.\r\n  */\r\n  window.attachEvent('onbeforeunload', setDirty );\r\n  function setDirty()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n /*\r\n  *This function is called when saving phone details.\r\n  */\r\n  function savePhoneDetail()\r\n  {\r\n    window.onbeforeunload = null;\r\n    document.frmPhoneDetail.action = \"/resource/ResourceDetail/displayPhoneDetail\";\r\n    return true;\r\n  }\r\n\r\n /*\r\n  *This function is called when deleting a phone record.\r\n  */\r\n  function deletePhoneRow()\r\n  {\r\n    var doDelete = false;\r\n\r\n    window.onbeforeunload = null;\r\n    var x = document.frmPhoneDetail;\r\n    if( x.selSzCdFacilPhoneType.value == \"01\"  )\r\n    {\r\n      //MSG - A primary phone record may not be deleted.\r\n      setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByName("MSG_CMN_PRIMARY_PHONE_NO_DELETE"));
      out.write("\");\r\n    }\r\n    else\r\n    {\r\n      var cnfrm = window.confirm(\"");
      out.print(MessageLookup.getMessageByName("MSG_CONFIRM_ON_DELETE"));
      out.write("\")\r\n      if(cnfrm)\r\n      {\r\n        x.cReqFuncCd.value = \"D\";\r\n        doDelete = true;\r\n      }\r\n    }\r\n\r\n      return doDelete;\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPhoneDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/ResourceDetail/savePhoneDetail");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("IdResourcePhone");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatInt( phoneRow.getUlIdRsrcPhone() ));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<!-- SR- ");
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write(" -->\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("cReqFuncCd");
          _jspx_th_impact_validateInput_2.setValue(szCReqFuncCd);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("rbPhoneRadioIndex");
          _jspx_th_impact_validateInput_3.setValue(iIndex);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("txtTsLastUpdate");
          _jspx_th_impact_validateInput_5.setValue(SerializationHelper.serializeObject( phoneRow.getTsLastUpdate() ));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("classResource");
          _jspx_th_impact_validateInput_6.setValue(classResource);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("fadResource");
          _jspx_th_impact_validateInput_7.setValue(fadResource);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("hdnPhone");
          _jspx_th_impact_validateInput_8.setValue(phoneRow.getLNbrFacilPhoneNumber());
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("hdnExt");
          _jspx_th_impact_validateInput_9.setValue( phoneRow.getLNbrFacilPhoneExtension() );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("    \r\n    \r\n<!-- SR-    ");
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("  -->\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr align=left valign=top>\r\n    <th colspan=\"2\">Resource Phone Detail</th>\r\n  </tr>\r\n  <tr  align=left valign=top>\r\n    <td width=\"15%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setName("selSzCdFacilPhoneType");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setCodesTable("CRSCPHON");
          _jspx_th_impact_validateSelect_0.setDisabled(phoneTypeDisabled);
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludePrimaryOption);
          _jspx_th_impact_validateSelect_0.setValue( phoneRow.getSzCdFacilPhoneType() );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setLabel("Phone");
          _jspx_th_impact_validateInput_11.setConstraint("Phone");
          _jspx_th_impact_validateInput_11.setRequired("true");
          _jspx_th_impact_validateInput_11.setName("txtLNbrFacilPhoneNumber");
          _jspx_th_impact_validateInput_11.setDisabled(phoneNumberDisabled);
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setValue( FormattingHelper.formatPhone( phoneRow.getLNbrFacilPhoneNumber() ) );
          _jspx_th_impact_validateInput_11.setSize("14");
          _jspx_th_impact_validateInput_11.setMaxLength("14");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr  align=left valign=top>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("Ext");
          _jspx_th_impact_validateInput_12.setName("txtLNbrFacilPhoneExtension");
          _jspx_th_impact_validateInput_12.setDisabled(phoneExtensionDisabled);
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue( phoneRow.getLNbrFacilPhoneExtension() );
          _jspx_th_impact_validateInput_12.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_12.setSize("8");
          _jspx_th_impact_validateInput_12.setMaxLength("8");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\" valign=\"top\">Comments:</td>\r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setCols("120");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setName("txtszTxtRsrcPhoneComments");
          _jspx_th_impact_validateTextArea_0.setDisabled(phoneCommentsDisabled);
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print( szSzTxtRsrcPhoneComments );
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n   <td align=\"left\">\r\n    ");
if ( !phoneDeleteButtonHide ){
          out.write("\r\n           ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeletePhoneDetail");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setFunction("return deletePhoneRow();");
          _jspx_th_impact_ButtonTag_0.setForm("frmPhoneDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/ResourceDetail/deletePhoneDetail");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
}
          out.write("\r\n   </td>\r\n   <td align=\"right\">\r\n   ");
if( !phoneSaveButtonHide )
     {
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSavePhoneDetail");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setFunction("return savePhoneDetail();");
          _jspx_th_impact_ButtonTag_1.setForm("frmPhoneDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/resource/ResourceDetail/savePhoneDetail");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   ");
}
          out.write("\r\n   </td>\r\n  </tr>\r\n</table>\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("txtUlIdResource");
    _jspx_th_impact_validateInput_1.setValue("<!%=FormattingHelper.formatInt( iUlIdResource )%>");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("WindowName");
    _jspx_th_impact_validateInput_4.setValue("PhoneDetail");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("cbxCIndRsrcTransport");
    _jspx_th_impact_validateInput_10.setValue("<!%=cbxCIndRsrcTransport%>");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
