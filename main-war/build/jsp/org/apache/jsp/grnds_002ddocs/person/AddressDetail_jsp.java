package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.AddressDetailConversation;
import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import java.util.ArrayList;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressBean;
import gov.georgia.dhr.dfcs.sacwis.web.common.AddressSubDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import java.util.ArrayList;

public final class AddressDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/impact.tld");
    _jspx_dependants.add("/grnds-docs/common/AddressSub.jsp");
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

//*  JSP Name:     Address Detail
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
      //**                                County DropDown Box on Address Detail Page.
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n");

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
 
      out.write("\r\n\r\n<script src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.onbeforeunload = function()\r\n{\r\n  return IsDirty();\r\n}\r\n\r\nfunction fsetEndDate()\r\n{\r\n  var form = \"");
      out.print(formName);
      out.write("\";\r\n  frmAddressDetail.txtDtDtPersAddrLinkEnd.value = \"");
      out.print(DateHelper.toString(new Date(), DateHelper.SLASH_FORMAT));
      out.write("\";\r\n  disableValidation(\"");
      out.print(formName);
      out.write("\");\r\n  return true;\r\n}\r\n\r\n\r\nfunction newUsing()\r\n{\r\n  disableValidation(\"");
      out.print(formName);
      out.write("\");\r\n  return true;\r\n}\r\n\r\n");
String onclick2 = "javascript:setIsDirtyCalled(false); return saveDetail();";
      String action = "#";
      out.write("\r\n\r\nfunction saveDetail()\r\n  {  \r\n    \r\n    var retVal = true;\r\n    retVal = validateAddressOnSave(\"");
      out.print(formName);
      out.write("\", \"");
      out.print(url);
      out.write("\", \"\");    \r\n      \r\n   if(retVal == \"false\"){    \r\n      ");
onclick2 = "";
      out.write("\r\n      ");
action = "/person/AddressDetail/saveAddress";
      out.write("\r\n    }\r\n    \r\n    if(retVal == \"true\"){    \r\n      ");
onclick2 = "javascript:setIsDirtyCalled(false); return saveDetail();";
      out.write("\r\n      ");
action = "/person/AddressDetail/saveAddress";
      out.write("\r\n    }\r\n    \r\n    return retVal; \r\n}\r\n//End Java Script-->\r\n</script>\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName(formName);
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction(url);
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("indexNum");
          _jspx_th_impact_validateInput_0.setValue(String.valueOf(iIndex));
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
          _jspx_th_impact_validateInput_1.setName("txtLdIdAddress");
          _jspx_th_impact_validateInput_1.setValue(txtLdIdAddress);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
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
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("hidden");
          _jspx_th_impact_validateInput_3.setName("txtTsLastUpdate");
          _jspx_th_impact_validateInput_3.setValue(SerializationHelper.serializeObject(dateTsLastUpdate));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("hidden");
          _jspx_th_impact_validateInput_4.setName("txtUlIdPerson");
          _jspx_th_impact_validateInput_4.setValue(txtUlIdPerson);
          _jspx_th_impact_validateInput_4.setEditableMode(EditableMode.EDIT);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"760\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"8\">\r\n      Address Information\r\n    </th>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"10%\">\r\n  ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdPersAddrLinkType");
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setDisabled(addressTypeDisabled);
          _jspx_th_impact_validateSelect_0.setCodesTable("CADDRTYP");
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue(txtSzCdPersAddrLinkType);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"10%\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtDtDtPersAddrLinkStart");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Start Date");
          _jspx_th_impact_validateDisplayOnlyField_0.setWidth("15%");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(txtDtDtPersAddrLinkStart);
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"8%\">\r\n        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtDtDtPersAddrLinkEnd");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("End Date");
          _jspx_th_impact_validateDisplayOnlyField_1.setWidth("15%");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(txtDtDtPersAddrLinkEnd);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\">\r\n         ");

           if (!setEndDateButtonHide) {
         
          out.write("\r\n              <a onClick=\"javascript:updateDisplayOnlyField( 'frmAddressDetail', 'txtDtDtPersAddrLinkEnd', '");
          out.print(FormattingHelper.formatDate(new java.util.Date()));
          out.write("' );setPageDirtyFlag(true);\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" >\r\n              <img src=\"/grnds-docs/images/shared/btnSetEndDate.gif\" class=\"md\" border=\"0\" >\r\n              </a>\r\n    ");

      } else {
    
          out.write(" &nbsp;  ");

    }
  
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setName("txtSzAddrPersAddrAttn");
          _jspx_th_impact_validateInput_5.setLabel("Attention");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setValue(txtSzAddrPersAddrAttn);
          _jspx_th_impact_validateInput_5.setConstraint("Name");
          _jspx_th_impact_validateInput_5.setMaxLength("30");
          _jspx_th_impact_validateInput_5.setDisabled(attentionDisabled);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setName("cbxBIndPersAddrLinkPrimary");
          _jspx_th_impact_validateInput_6.setChecked(bIndPersAddrLinkPrimary);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setDisabled(cbxPrimaryDisabled);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Primary\r\n         </td>\r\n   <td>\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("checkbox");
          _jspx_th_impact_validateInput_7.setName("cbxBIndPersAddrLinkInvalid");
          _jspx_th_impact_validateInput_7.setChecked(bIndPersAddrLinkInvalid);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setDisabled(cbxInvalidDisabled);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Invalid\r\n         </td>\r\n    <td colspan=\"3\">\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setName("cbxBIndRemovalHome");
          _jspx_th_impact_validateInput_8.setChecked(bIndRemovalHome);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setDisabled(cbxRemovalHomeDisabled);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("Removal Home\r\n         </td>\r\n  </tr>\r\n  <tr>\r\n         <td>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setName("szTxtPersonEmail");
          _jspx_th_impact_validateInput_9.setLabel("E-mail Address");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setValue(txtPersonEmail);
          _jspx_th_impact_validateInput_9.setConstraint("Email");
          _jspx_th_impact_validateInput_9.setMaxLength("30");
          _jspx_th_impact_validateInput_9.setDisabled(emailDisabled);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   </tr>\r\n   <tr>\r\n   <td colspan=\"7\">\r\n              ");

                /* BEGIN Address Submodule */
              
          out.write("\r\n              ");

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
              
          out.write("\r\n              ");
          out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n \r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/addressValidation.js\"></script>\r\n");

  {
    AddressSubDB addressSubAddressSubDB = AddressSubDB.getFromRequest( request );
    String addressSubFormName = addressSubAddressSubDB.getFormName();
    String addressSubPageMode = addressSubAddressSubDB.getPageMode();
    String addressSubAddressSubmoduleName = addressSubAddressSubDB.getAddressSubmoduleName();
    boolean addressSubCommentsVisible = addressSubAddressSubDB.isCommentsVisible();
    boolean addressSubCommentsRequired = addressSubAddressSubDB.isCommentsRequired();
    boolean addressSubCommentsDisabled = addressSubAddressSubDB.isCommentsDisabled();
    boolean addressSubStreetRequired = addressSubAddressSubDB.isStreetRequired();
    boolean addressSubZipRequired = addressSubAddressSubDB.isZipRequired();
    boolean addressSubAddressRequired = addressSubAddressSubDB.isAddressRequired();
    boolean addressSubAddressDisabled = addressSubAddressSubDB.isAddressDisabled();
    int addressSubTabIndex = addressSubAddressSubDB.getTabIndex();
    ArrayList<String> addressSubExcludeCounty = addressSubAddressSubDB.getExcludeCounty();

    AddressBean addressBean = null;
    addressSubAddressSubmoduleName = FormattingHelper.formatString( addressSubAddressSubmoduleName );
    if ( AddressBean.isInRequest( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromRequest( addressSubAddressSubmoduleName, request );
    }
    else if ( AddressBean.isInState( addressSubAddressSubmoduleName, request ) )
    {
      addressBean = AddressBean.getFromState( addressSubAddressSubmoduleName, request );
    }
    else
    {
      addressBean = new AddressBean();
      addressBean.setAddressSubmoduleName( addressSubAddressSubmoduleName );
    }

    String changeAddress= "javascript:changeValidAddress( '" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

          out.write("\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"0\">\r\n <tr>\r\n  <td width=\"10%\">\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName( addressBean.getAttributeName( AddressBean.ADDRESS1 ) );
          _jspx_th_impact_validateInput_10.setValue(FormattingHelper.formatString( addressBean.getAddress1() ));
          _jspx_th_impact_validateInput_10.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setRequired( String.valueOf( addressSubStreetRequired ));
          _jspx_th_impact_validateInput_10.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_10.setLabel("Street");
          _jspx_th_impact_validateInput_10.setWidth("45%");
          _jspx_th_impact_validateInput_10.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setConstraint("Address");
          _jspx_th_impact_validateInput_10.setSize("50");
          _jspx_th_impact_validateInput_10.setMaxLength("30");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"15%\">&nbsp;</td>\r\n    <td width=\"30%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>&nbsp;</td>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setName( addressBean.getAttributeName( AddressBean.ADDRESS2 ) );
          _jspx_th_impact_validateInput_11.setValue(FormattingHelper.formatString( addressBean.getAddress2() ));
          _jspx_th_impact_validateInput_11.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_11.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setConstraint("Address");
          _jspx_th_impact_validateInput_11.setSize("50");
          _jspx_th_impact_validateInput_11.setMaxLength("30");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("</td>\r\n    <td>&nbsp;</td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td>");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName( addressBean.getAttributeName( AddressBean.CITY ) );
          _jspx_th_impact_validateInput_12.setValue(FormattingHelper.formatString( addressBean.getCity() ));
          _jspx_th_impact_validateInput_12.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setRequired( String.valueOf( addressSubAddressRequired ));
          _jspx_th_impact_validateInput_12.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_12.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_12.setLabel("City");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setConstraint("City");
          _jspx_th_impact_validateInput_12.setMaxLength("20");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n");

    // default the state to Georgia, override default if the state is set
    String stateDefault = CodesTables.CSTATE_GA;
    if ( StringHelper.isValid( addressBean.getState() ) )
    {
     stateDefault = addressBean.getState();
    }
    else if ( StringHelper.isValid( addressBean.getCounty() ) )
    {
     stateDefault = "";
    }

    String onChange= changeAddress + "toggleCounty('" + addressSubFormName + "', '" + addressSubAddressSubmoduleName + "');";

          out.write("\r\n    <td>");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName( addressBean.getAttributeName( AddressBean.STATE ));
          _jspx_th_impact_validateSelect_1.setValue( FormattingHelper.formatString( stateDefault ) );
          _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateSelect_1.setRequired( String.valueOf( addressSubAddressRequired ));
          _jspx_th_impact_validateSelect_1.setCodesTable( CodesTables.CSTATE );
          _jspx_th_impact_validateSelect_1.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateSelect_1.setOnChange( onChange );
          _jspx_th_impact_validateSelect_1.setLabel("State");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n        <td>\r\n           ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setName( addressBean.getAttributeName( AddressBean.ZIP ));
          _jspx_th_impact_validateInput_13.setValue(FormattingHelper.formatString( addressBean.getZip() ));
          _jspx_th_impact_validateInput_13.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_13.setRequired( String.valueOf( addressSubZipRequired  ));
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_13.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_13.setLabel("Zip");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setConstraint("Zip");
          _jspx_th_impact_validateInput_13.setMaxLength("5");
          _jspx_th_impact_validateInput_13.setSize("5");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      -\r\n          ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setName( addressBean.getAttributeName( AddressBean.ZIP_SUFF ));
          _jspx_th_impact_validateInput_14.setValue(FormattingHelper.formatString( addressBean.getZipSuff() ));
          _jspx_th_impact_validateInput_14.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateInput_14.setType("text");
          _jspx_th_impact_validateInput_14.setOnChange( changeAddress );
          _jspx_th_impact_validateInput_14.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setConstraint("ZipSuff");
          _jspx_th_impact_validateInput_14.setMaxLength("4");
          _jspx_th_impact_validateInput_14.setSize("4");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </td>\r\n        <td>\r\n            ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName( addressBean.getAttributeName( AddressBean.COUNTY ) );
          _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString( addressBean.getCounty() ) );
          _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( addressSubAddressDisabled ) );
          _jspx_th_impact_validateSelect_2.setRequired( String.valueOf( addressSubAddressRequired ) );
          _jspx_th_impact_validateSelect_2.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setLabel("County");
          _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_2.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_2.setExcludeOptions(addressSubExcludeCounty);
          _jspx_th_impact_validateSelect_2.setOnChange( changeAddress );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <td>\r\n  </tr>\r\n");

    if ( addressSubCommentsVisible )
    {

          out.write("\r\n  <tr>\r\n   <td>");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setLabel("Comments");
          _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( addressSubCommentsDisabled ) );
          _jspx_th_impact_validateTextArea_0.setRequired( String.valueOf( addressSubCommentsRequired ) );
          _jspx_th_impact_validateTextArea_0.setName( addressBean.getAttributeName( AddressBean.COMMENTS ) );
          _jspx_th_impact_validateTextArea_0.setCols("125");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setColspan("3");
          _jspx_th_impact_validateTextArea_0.setTabIndex( addressSubTabIndex );
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print( FormattingHelper.formatString(addressBean.getComments() ));
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n");

    }

          out.write("\r\n</table>\r\n");

    if ( !addressSubAddressDisabled && !EditableMode.isCompatibleWith( addressSubPageMode, EditableMode.VIEW ) )
    {

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n");

    String onclick = "javascript:setIsDirtyCalled(true);" +
                     "launchAddressValidate('" + addressSubFormName + "', 'validate', '" +
                     addressBean.getAddressSubmoduleName() + "');return false;";

          out.write("\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnvalidate");
          _jspx_th_impact_ButtonTag_0.setImg("btnValidate");
          _jspx_th_impact_ButtonTag_0.setAction("#");
          _jspx_th_impact_ButtonTag_0.setFunction(onclick);
          _jspx_th_impact_ButtonTag_0.setForm(addressSubFormName);
          _jspx_th_impact_ButtonTag_0.setTabIndex(addressSubTabIndex);
          _jspx_th_impact_ButtonTag_0.setOnBlur("setIsDirtyCalled(false);");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

    }

          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_16(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("hidden");
          _jspx_th_impact_validateInput_17.setName( addressBean.getAttributeName( AddressBean.IN_REQUEST ));
          _jspx_th_impact_validateInput_17.setValue("true");
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("hidden");
          _jspx_th_impact_validateInput_18.setName( addressBean.getAttributeName( AddressBean.IS_VALID ));
          _jspx_th_impact_validateInput_18.setValue("true");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("hidden");
          _jspx_th_impact_validateInput_19.setName( addressBean.getAttributeName( AddressBean.FORM_ACTION ));
          _jspx_th_impact_validateInput_19.setValue("");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("hidden");
          _jspx_th_impact_validateInput_20.setName( addressBean.getAttributeName( AddressBean.MULT_COUNTY ));
          _jspx_th_impact_validateInput_20.setValue("");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<script language=\"javascript\">\r\n//Run this script to protect the county on start up.\r\ntoggleCounty('");
          out.print( addressSubFormName );
          out.write("', '");
          out.print( addressSubAddressSubmoduleName );
          out.write("');\r\n</script>\r\n");

    addressSubAddressSubDB.setTabIndex( addressSubTabIndex );
  }

          out.write('\r');
          out.write('\n');
          out.write("\r\n              ");

                tabIndex = addressSubDB.getTabIndex();
                  AddressSubDB.removeFromRequest(request);
              
          out.write("\r\n              ");

                /* END Address Submodule */
              
          out.write("\r\n   </td>\r\n </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"760\">\r\n   <tr>\r\n     <td align=\"right\">\r\n       ");

         if (!newUsingButtonHide) {
       
          out.write("\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setImg("btnNewUsing");
          _jspx_th_impact_ButtonTag_1.setFunction("newUsing();");
          _jspx_th_impact_ButtonTag_1.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/person/AddressDetail/addressListPullBack");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       ");

         }
       
          out.write("\r\n\r\n\r\n       ");

         if (!saveButtonHide) {
       
          out.write("\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setFunction(onclick2);
          _jspx_th_impact_ButtonTag_2.setForm("frmAddressDetail");
          _jspx_th_impact_ButtonTag_2.setAction(action);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n       ");

         }
       
          out.write("\r\n     </td>\r\n   </tr>\r\n</table>\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("hdnNbrRsrcAddrLat");
    _jspx_th_impact_validateInput_15.setValue("0");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_16(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_16.setType("hidden");
    _jspx_th_impact_validateInput_16.setName("hdnNbrRsrcAddrLong");
    _jspx_th_impact_validateInput_16.setValue("0");
    int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
    if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
