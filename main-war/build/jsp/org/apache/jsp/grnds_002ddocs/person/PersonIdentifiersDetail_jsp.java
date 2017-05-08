package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT14WLB;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersSubmoduleConversation;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class PersonIdentifiersDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
          BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = (String) state.getAttribute(PersonIdentifiersSubmoduleConversation.PAGE_MODE_KEY, request);

  int tabIndex = 1;

  int ulIdPersonId = ContextHelper.getIntSafe(request, "hdnUlIdPersonId");

  CINT14WLB cint14wlb = (CINT14WLB) state.getAttribute("cint14wlb", request);

  boolean notNew = ulIdPersonId > 0 && cint14wlb != null;

  //Use newCRS to determin if this is a new CRS number
  boolean newCRS = false;
  String newCRSString = "false";
  if (ulIdPersonId == 0 && cint14wlb != null) {
    newCRS = true;
    newCRSString = "true";
  }
  

  // set variables that are used in multiple places and/or are too long to be readible below
  boolean isInvalid = notNew && cint14wlb.getBIndPersonIDInvalid().equals(ServiceConstants.FND_YES) ? true : false;
  String codeType = notNew ? cint14wlb.getSzCdPersonIdType() : "";
  //if this is  an existing ID Type or if this is a new CRS with a number,
  //set idNumber and codeType to the values retrieved form the object. Else set those values to empty string.
  String idNumber;
  if (notNew || newCRS) {
    idNumber = cint14wlb.getSzNbrPersonIdNumber();
    codeType = cint14wlb.getSzCdPersonIdType();
  } else {
    idNumber = "";
    codeType = "";
  }

  org.exolab.castor.types.Date endDate = notNew ? cint14wlb.getDtPersonIDEnd() : null;

  //Start Sir23446
  // isVerified is used to exclude SSN from drop down when one already exits so another can not be added
  // it is always set false right now but can be changed in PersonIdentifiersConversation so that it can be used
  boolean isVerified = "true".equals(request.getAttribute("VERIFIED_DHS").toString());

  boolean isValidateByInterface = false;
  boolean isSSN = false;
  if (notNew && cint14wlb.getSzDescPersonID() != null && cint14wlb.getSzDescPersonID() != null) {
    isValidateByInterface = ServiceConstants.FND_YES.equals(cint14wlb.getBIndValidateByInterface());
    isSSN = cint14wlb.getSzCdPersonIdType().equals(CodesTables.CNUMTYPE_SSN) ? true : false;
  }

  //Remove SSN from drop down Type when there exit a validated record and the worker does not have the correct profile
  // Get cint14wlb_array out of the request
  //CINT14WLB_ARRAY cint14wlb_array = (CINT14WLB_ARRAY)request.getAttribute( PersonIdentifiersConversation.CINT14WLB_ARRAY_KEY );

  boolean hasUpdateProfile = UserProfileHelper.getUserProfile(request).hasRight(UserProfile.SEC_MNTN_PERSON);

  // Use hasEndDate to disable editing when there is an end date saved
  boolean hasEndDate = endDate != null ? true : false;
  //Sir23446 Future use, Program may want regular user not to update when it is a SSN that has been Validated
  // by the interface isVerified is always set false right now but can be changed in PersonIdentifiersConversation
  // line 557 so that it can be used
  boolean isNotUpdatable = hasEndDate || (isVerified && isSSN && !hasUpdateProfile) || (codeType.equals(
          CodesTables.CNUMTYPE_CRS_IDNUMBER) && notNew);
  //End Sir23446

  // This will be the default display value of the CRS Button which will be toggled
  // by the selection of type of Identifier

  String displayCrsButton = "none";
  String displayDtFields = "inline";
  String displayCrsMod = "inline";

      out.write("\r\n\r\n");
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" language=\"Javascript1.2\">\r\n// Check for changes before navigating off\r\nwindow.onbeforeunload = function () {\r\n  IsDirty();\r\n};\r\n//SIR 23827 fixed the javascript runtime error\r\n");

  if( isValidateByInterface ) {

      out.write("\r\nwindow.onload = function () {\r\n  //Sir23446 This removes the flaky behavior of the checkbox\r\n  frmPersonIdentifiersDetail.cbxBIndVerifiedInterface.value = \" \";\r\n  updateForCrs();\r\n};\r\n");

  } else {

      out.write("\r\nwindow.onload = function () {\r\n  updateForCrs();\r\n};\r\n");

  }

      out.write("\r\n\r\nfunction confirmAddWhenExistingOfSameType(type, comment, bHasEnddate)\r\n{\r\n  var returnedValue = true;\r\n  var existingTypes = new Array(");
      out.print((String) request.getAttribute("existingTypes"));
      out.write(");\r\n\r\n  for (var i = 0; i < existingTypes.length; i++)\r\n  {\r\n    if (existingTypes[ i ] == type && !bHasEnddate)\r\n    {\r\n      returnedValue = confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_INT_ACTIVE_TYPE_EXISTS));
      out.write("')\r\n      if (returnedValue) {\r\n        if (type == '");
      out.print(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      out.write("') {\r\n          returnedValue =\r\n          confirm('You are about to add another CRS ID as an identifier for the same person!  Are you sure ?');\r\n        }\r\n      }\r\n    }\r\n  }\r\n  return returnedValue;\r\n}\r\n\r\nfunction updatePersonIdentifierFields(selectControl)\r\n{\r\n  // We only need to execute this if we are editing an existing one;\r\n  // it sets hdnIsNew to true, which will prevent it from running more than once\r\n  if (frmPersonIdentifiersDetail.hdnIsNew.value != \"true\")\r\n  {\r\n    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value = \"\";\r\n    updateDisplayOnlyField('frmPersonIdentifiersDetail', 'dspDtPersonIDStart', '");
      out.print(FormattingHelper.formatDate(new Date()));
      out.write("');\r\n    updateDisplayOnlyField('frmPersonIdentifiersDetail', 'dspDtPersonIDEnd', '');\r\n    frmPersonIdentifiersDetail.txtSzDescPersonID.value = \"\";\r\n    frmPersonIdentifiersDetail.cbxBIndPersonIDInvalid.checked = false;\r\n    //frmPersonIdentifiersDetail.cbxBIndVerifiedInterface.checked = false;\r\n    frmPersonIdentifiersDetail.hdnIsNew.value = true;\r\n    frmPersonIdentifiersDetail.hdnUlIdPersonId.value = 0;\r\n    frmPersonIdentifiersDetail.hdnTsLastUpdate2.value = \"\";\r\n\r\n  }\r\n  if (selectControl.value == \"");
      out.print(CodesTables.CNUMTYPE_DRIVERS_LICENSE_NUMBER);
      out.write("\"\r\n          && frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value == \"\")\r\n  {\r\n    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value = \"GA\";\r\n  }\r\n  else\r\n  {\r\n    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.value = \"\";\r\n  }\r\n  updateForCrs();\r\n}\r\n\r\nfunction updateForCrs()\r\n{\r\n  if (");
      out.print(newCRS);
      out.write(") {\r\n    frmPersonIdentifiersDetail.selSzCdPersonIdType.value = '");
      out.print(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      out.write("';\r\n  }\r\n  // Now if the CRS ID is the Type selected then perfom the following logic\r\n  if ((frmPersonIdentifiersDetail.selSzCdPersonIdType.value == \"");
      out.print(CodesTables.CNUMTYPE_CRS_IDNUMBER);
      out.write("\" || ");
      out.print(newCRS);
      out.write(")\r\n          && \"");
      out.print(!isNotUpdatable);
      out.write("\")\r\n  {\r\n");

  displayCrsButton = "inline";
  displayDtFields = "none";
  displayCrsMod= (!newCRS ? "none":"inline");

      out.write("\r\n    crsBtnSpanId.style.display = \"");
      out.print(displayCrsButton);
      out.write("\";\r\n    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.disabled = true;\r\n    frmPersonIdentifiersDetail.dspDtPersonIDStart.visible = false;\r\n    frmPersonIdentifiersDetail.dspDtPersonIDEnd.visible = false;\r\n  }\r\n  else\r\n  {\r\n");

  displayCrsButton = "none";
  displayDtFields = "inline";
  displayCrsMod= "inline";

      out.write("\r\n    crsBtnSpanId.style.display = \"");
      out.print(displayCrsButton);
      out.write("\";\r\n    frmPersonIdentifiersDetail.txtSzNbrPersonIdNumber.disabled = false;\r\n  }\r\n}\r\n\r\n</script>\r\n\r\n");

  /* Include custom tag for displaying errors on the page */

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPersonIdentifiersDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/PersonIdentifiers/displayPersonIdDetail");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.PersonIdentifiersCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
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
          _jspx_th_impact_validateInput_0.setName("hdnSSN");
          _jspx_th_impact_validateInput_0.setValue(notNew ? cint14wlb.getSzNbrPersonIdNumber() : "");
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
          _jspx_th_impact_validateInput_1.setName("hdnIncludingPageDisplayCommand");
          _jspx_th_impact_validateInput_1.setValue((String) request.getAttribute("includingPageDisplayCommand"));
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
          _jspx_th_impact_validateInput_2.setName("hdnIsNew");
          _jspx_th_impact_validateInput_2.setValue(notNew ? "false" : "true");
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
          _jspx_th_impact_validateInput_3.setName("hdnUlIdPersonId");
          _jspx_th_impact_validateInput_3.setValue(FormattingHelper.formatInt(ulIdPersonId));
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
          _jspx_th_impact_validateInput_4.setName("newCRSString");
          _jspx_th_impact_validateInput_4.setValue(newCRSString);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("hidden");
          _jspx_th_impact_validateInput_5.setName("hdnTsLastUpdate2");
          _jspx_th_impact_validateInput_5.setValue(notNew ? String.valueOf(cint14wlb.getTsSysTsLastUpdate2()) : "");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n<table class=\"tableBorder\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n<tr>\r\n  <th colspan=\"5\">\r\n    Person Identifiers Detail\r\n  </th>\r\n</tr>\r\n<tr>\r\n  ");

    Set<String> excludeOptions = new HashSet<String>();
    if (pageMode.equals(PageModeConstants.NEW)
        || (pageMode.equals(PageModeConstants.EDIT) && !codeType.equals(CodesTables.CNUMTYPE_PACE_PROJECT_CLIENT))) {
      excludeOptions.add(CodesTables.CNUMTYPE_PACE_PROJECT_CLIENT);
    }

    //Sir23446 exclude SSN once it is verified by DHS
    if (isVerified && !hasUpdateProfile) {
      excludeOptions.add(CodesTables.CNUMTYPE_SSN);
    }
    if (!newCRS) {
  
          out.write("\r\n  <td>\r\n    ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName("selSzCdPersonIdType");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setValue(codeType);
          _jspx_th_impact_validateSelect_0.setLabel("Type");
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CNUMTYPE);
          _jspx_th_impact_validateSelect_0.setContentType(SelectTag.CODES);
          _jspx_th_impact_validateSelect_0.setValueType(SelectTag.CODES);
          _jspx_th_impact_validateSelect_0.setOnChange("updatePersonIdentifierFields( this )");
          _jspx_th_impact_validateSelect_0.setDisabled(String.valueOf(isNotUpdatable));
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeOptions);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  ");

  } else {
  
          out.write("\r\n  <td>\r\n    ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("selSzCdPersonIdType");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Type");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(codeType );
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Type");
          _jspx_th_impact_validateDisplayOnlyField_0.setRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <input type=\"hidden\" name=\"selSzCdPersonIdType\" value=\"");
          out.print(idNumber);
          out.write("  \">\r\n  </td>\r\n  ");

    }
  
          out.write("\r\n    ");
          out.write("\r\n\r\n\r\n  ");

    if (!newCRS) {
  
          out.write("\r\n\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setName("txtSzNbrPersonIdNumber");
          _jspx_th_impact_validateInput_6.setSize("15");
          _jspx_th_impact_validateInput_6.setMaxLength("15");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setLabel("Number");
          _jspx_th_impact_validateInput_6.setValue(idNumber);
          _jspx_th_impact_validateInput_6.setDisabled(String.valueOf(isNotUpdatable));
          _jspx_th_impact_validateInput_6.setRequired("true");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n    ");
          out.write("\r\n  ");

  } else {
  
          out.write("\r\n  <td>\r\n    ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtSzNbrPersonIdNumber");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Number");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(idNumber);
          _jspx_th_impact_validateDisplayOnlyField_1.setRequired("true");
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <input type=\"hidden\" name=\"txtSzNbrPersonIdNumber\" value=\"");
          out.print(idNumber);
          out.write("\">\r\n  </td>\r\n  ");

    }
  
          out.write("\r\n</tr>\r\n<tr>\r\n  <td>\r\n      ");
          out.write("\r\n    ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspDtPersonIDStart");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Start Date");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(notNew ? FormattingHelper.formatDate(cint14wlb.getDtPersonIDStart())
                           : FormattingHelper.formatDate(DateHelper.getTodayCastorDate()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td>\r\n      ");
          out.write("\r\n      ");
          out.write("\r\n    ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspDtPersonIDEnd");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("End Date");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(endDate));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n  <td width=\"10%\">\r\n    ");

      if (!isNotUpdatable && (pageMode.equals(PageModeConstants.NEW) || pageMode.equals(PageModeConstants.EDIT))) {
        String updateDisplayJS =
                "javascript:updateDisplayOnlyField( 'frmPersonIdentifiersDetail', 'dspDtPersonIDEnd', '"
                + FormattingHelper.formatDate(new Date()) + "' );setPageDirtyFlag(true);";
    
          out.write("\r\n    <a href=\"");
          out.print(updateDisplayJS);
          out.write("\" onClick=\"setIsDirtyCalled(true);\" tabIndex=\"");
          out.print(tabIndex++);
          out.write("\"><img\r\n            src=\"/grnds-docs/images/shared/btnSetEndDate.gif\" class=\"md\" border=\"0\">\r\n    </a>\r\n    ");

      }
    
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setName("txtSzDescPersonID");
          _jspx_th_impact_validateInput_7.setSize("40");
          _jspx_th_impact_validateInput_7.setMaxLength("40");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setColspan("2");
          _jspx_th_impact_validateInput_7.setLabel("Comments");
          _jspx_th_impact_validateInput_7.setDisabled(String.valueOf(isNotUpdatable));
          _jspx_th_impact_validateInput_7.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_7.setValue(notNew ? cint14wlb.getSzDescPersonID() : "");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>\r\n<tr>\r\n  <td>\r\n    ");

      // To enable Invalid check box in Update mode if ID is end-dated/inactive
      //Before, Invalid was disabled in Update mode if ID is end-dated/inactive (page must have been set VIEW only)
      if (!DateHelper.isNull(endDate) || !newCRS) {
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("checkbox");
          _jspx_th_impact_validateInput_8.setName("cbxBIndPersonIDInvalid");
          _jspx_th_impact_validateInput_8.setLabel("Invalid");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_8.setDisabled("false");
          _jspx_th_impact_validateInput_8.setChecked(isInvalid ? "true" : "false");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");

    } else {
    
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("checkbox");
          _jspx_th_impact_validateInput_9.setName("cbxBIndPersonIDInvalid");
          _jspx_th_impact_validateInput_9.setLabel("Invalid");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_9.setDisabled(String.valueOf(isNotUpdatable));
          _jspx_th_impact_validateInput_9.setChecked(isInvalid ? "true" : "false");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");

      }
    
          out.write("\r\n  </td>\r\n  <td colspan=\"4\">\r\n    &nbsp;\r\n  </td>\r\n</tr>\r\n</table>\r\n<br>\r\n");

  String functionString = "";
  if (!newCRS) {
    functionString =
            "javascript:return confirmAddWhenExistingOfSameType(frmPersonIdentifiersDetail.selSzCdPersonIdType.value, "
            + "frmPersonIdentifiersDetail.txtSzDescPersonID.value, " + hasEndDate + ");";
  } else {

    functionString = "javascript:return confirmAddWhenExistingOfSameType('" + codeType + "', "
                     + "frmPersonIdentifiersDetail.txtSzDescPersonID.value, " + hasEndDate + ");";
  }

          out.write("\r\n<Table align=\"right\">\r\n  <Tr>\r\n    ");

      // To enable Save button in Update mode if ID is end-dated/inactive (page must have been set VIEW only)
      // Before, Save button was hidden in Update mode if ID is end-dated/inactive
      if (!DateHelper.isNull(endDate) && !newCRS) {
    
          out.write("\r\n    <!-- STGAP00003954 display save button when -->\r\n    <td>\r\n        <span id=\"btnSaveFinalSpanId\" style=\"");
          out.print("display:" + displayCrsMod);
          out.write("\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setDisabled("false");
          _jspx_th_impact_ButtonTag_0.setFunction(functionString);
          _jspx_th_impact_ButtonTag_0.setForm("frmPersonIdentifiersDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/person/PersonIdentifiers/savePersonIdDetail");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </span>\r\n    </td>\r\n    ");

    } else {
    
          out.write("\r\n    <!-- Add a Get CRS ID button which will only display when the ID Type is CRS ID (using span-display) -->\r\n    <td>\r\n        <span id=\"crsBtnSpanId\" style=\"");
          out.print("display:" + displayCrsButton);
          out.write("\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setFunction("javascript:disableValidation('frmPersonIdentifiersDetail');");
          _jspx_th_impact_ButtonTag_1.setName("btnCrsId");
          _jspx_th_impact_ButtonTag_1.setImg("btnCRSRequest");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setDisabled(String.valueOf(isNotUpdatable));
          _jspx_th_impact_ButtonTag_1.setForm("frmPersonIdentifiersDetail");
          _jspx_th_impact_ButtonTag_1.setAction("/person/PersonIdentifiers/displayCrsInquiryScreen");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" </span>\r\n    </td>\r\n    <td>\r\n        <span id=\"btnSaveFinalSpanId\" style=\"");
          out.print("display:" + displayCrsMod);
          out.write("\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSaveFinal");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setDisabled(String.valueOf(isNotUpdatable));
          _jspx_th_impact_ButtonTag_2.setFunction(functionString);
          _jspx_th_impact_ButtonTag_2.setForm("frmPersonIdentifiersDetail");
          _jspx_th_impact_ButtonTag_2.setAction("/person/PersonIdentifiers/savePersonIdDetail");
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        </span>\r\n    </Td>\r\n    ");

      }
    
          out.write("\r\n  </Tr>\r\n</Table>\r\n\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"");
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
