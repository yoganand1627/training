package org.apache.jsp.grnds_002ddocs.fad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCFAD07SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.fad.HomeInfrmtnConversation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

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


      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n /*\r\n  *This function is called before the page unloads.\r\n  */\r\nwindow.onbeforeunload = function ()\r\n{\r\n    IsDirty();\r\n};\r\n\r\n /*\r\n  *This function is called when saving phone details.\r\n  */\r\nfunction savePhoneDetail()\r\n{\r\n  window.onbeforeunload = null;\r\n  return true;\r\n}\r\n\r\n /*\r\n  *This function is called when deleting a phone record.\r\n  */\r\nfunction deletePhoneRow()\r\n{\r\n  var doDelete = false;\r\n\r\n  window.onbeforeunload = null;\r\n  disableValidation( 'frmPhoneDetail' );\r\n  var x = document.frmPhoneDetail;\r\n  if( x.selSzCdFacilPhoneType.value == \"");
      out.print(  HomeInfrmtnConversation.CODE_PHONE_TYPE_PRIMARY  );
      out.write("\"  )\r\n  {\r\n    //MSG - A primary phone record may not be deleted.\r\n    setInformationalMessage(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CMN_PRIMARY_PHONE_NO_DELETE));
      out.write("\");\r\n  }\r\n  else\r\n  {\r\n    var cnfrm = window.confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE));
      out.write("\")\r\n    if(cnfrm)\r\n    {\r\n      x.cReqFuncCd.value = \"D\";\r\n      doDelete = true;\r\n    }\r\n  }\r\n\r\n  return doDelete;\r\n}\r\n\r\n\r\n//End Java Script-->\r\n</script>\r\n\r\n");

  if ( phoneDeleteButtonHide )
  {
    onlyButton = "true";
  }

      out.write("\r\n\r\n");
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
      _jspx_th_impact_validateForm_0.setAction("/fad/HomeInfrmtn/savePhoneDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation");
      _jspx_th_impact_validateForm_0.setDefaultButton( onlyButton );
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
          _jspx_th_impact_validateInput_0.setValue(String.valueOf(iUlIdRsrcPhone));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("txtUlIdResource");
          _jspx_th_impact_validateInput_1.setValue(String.valueOf(iUlIdResource));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
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
          _jspx_th_impact_validateInput_3.setValue(String.valueOf(iIndex));
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
          _jspx_th_impact_validateInput_5.setValue(String.valueOf( dateTsLastUpdate ));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("hidden");
          _jspx_th_impact_validateInput_6.setName("fadResource");
          _jspx_th_impact_validateInput_6.setValue(fadResource);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"2\">Phone Information</th>\r\n  </tr>\r\n  \r\n  <tr>\r\n    <td width=\"15%\">");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setName("selSzCdFacilPhoneType");
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setCodesTable("CRSCPHON");
          _jspx_th_impact_validateSelect_0.setDisabled(phoneTypeDisabled);
          _jspx_th_impact_validateSelect_0.setExcludeOptions( excludePrimaryOption );
          _jspx_th_impact_validateSelect_0.setValue(selSzCdFacilPhoneType);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setLabel("Phone");
          _jspx_th_impact_validateInput_7.setConstraint("Phone");
          _jspx_th_impact_validateInput_7.setRequired("true");
          _jspx_th_impact_validateInput_7.setName("txtLNbrFacilPhoneNumber");
          _jspx_th_impact_validateInput_7.setDisabled(phoneNumberDisabled);
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setValue(szLNbrFacilPhoneNumber);
          _jspx_th_impact_validateInput_7.setSize("15");
          _jspx_th_impact_validateInput_7.setMaxLength("15");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr  align=left valign=top>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setLabel("&nbsp;&nbsp;Ext");
          _jspx_th_impact_validateInput_8.setName("txtLNbrFacilPhoneExtension");
          _jspx_th_impact_validateInput_8.setDisabled(phoneExtensionDisabled);
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setValue(szLNbrFacilPhoneExtension);
          _jspx_th_impact_validateInput_8.setConstraint("PhoneExtension");
          _jspx_th_impact_validateInput_8.setSize("8");
          _jspx_th_impact_validateInput_8.setMaxLength("8");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n  </tr>\r\n  <tr>\r\n    <td class=\"formLabel\" colspan=1 valign=\"top\">Comments:</td>\r\n    <td>\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setCols("120");
          _jspx_th_impact_validateTextArea_0.setRows("3");
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
              out.print(FormattingHelper.formatString(szSzTxtRsrcPhoneComments));
              out.write("\r\n          ");
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
          out.write("\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnDeletePhoneDetail");
          _jspx_th_impact_ButtonTag_0.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_0.setFunction("return deletePhoneRow();");
          _jspx_th_impact_ButtonTag_0.setForm("frmPhoneDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setAction("/fad/HomeInfrmtn/deletePhoneRow");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
} else {
          out.write("\r\n      &nbsp;\r\n  ");
}
          out.write("\r\n   </td>\r\n   <td align=\"right\">\r\n   ");
if( !phoneSaveButtonHide ){
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSavePhoneDetail");
          _jspx_th_impact_ButtonTag_1.setImg("btnSave");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setFunction("return savePhoneDetail();");
          _jspx_th_impact_ButtonTag_1.setForm("frmPhoneDetail");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAction("/fad/HomeInfrmtn/savePhoneDetail");
          _jspx_th_impact_ButtonTag_1.setEditableMode( EditableMode.EDIT );
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   ");
} else{
          out.write("\r\n      &nbsp;\r\n   ");
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
}
