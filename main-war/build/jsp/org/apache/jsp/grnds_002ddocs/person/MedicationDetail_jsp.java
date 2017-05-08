package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonMedicationList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.MedicationSubmoduleConversation;

public final class MedicationDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//*-----------------------------------------------------------------------------
      //*  JSP Name:     Medication Detail
      //*  Created by:   Vishala Devarakonda
      //*  Date Created: 09/10/2006
      //*
      //*  Description:
      //*  The Medication Detail page, accessed only through the sub-module, will provide a
      //*  facility for users to capture and document information associated with a person's
      //*  prescribed medication or known allergies in IMPACT.  The Medication Detail page 
      //*  will add or contain the medication information like medication name, dosage, reason, 
      //*  administering person, date prescribed, end date, and the allergies information.
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //** 

      
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<!--Start Main Content-->\r\n");
BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      out.write("\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script language=\"Javascript1.2\">\r\n// Check for changes before navigating off\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\n</script>\r\n\r\n");

  int tabIndex = 1;
  //view mode
  boolean disableMedName = false;
  boolean disableDosage = false;
  boolean disableReason = false;
  boolean disableAdminPerson = false;
  boolean disablePrescDate = false;
  boolean disableEndDate = false;
  boolean disablePrescribingPerson = false;
  boolean disableAllergies = false;
  boolean disableAllergyDisc = false;
  boolean disableComments = false;
  boolean disableSaveButton = false;
  boolean allergyPresent = true;
  boolean allergyAbsent = false;
  boolean disablePharmacyInfo = false;

  String EMPTY_STRING = "";
  String medName = EMPTY_STRING;
  String dosage = EMPTY_STRING;
  String reason = EMPTY_STRING;
  String adminPerson = EMPTY_STRING;
  String prescribingPerson = EMPTY_STRING;
  String allergies = EMPTY_STRING;
  String allergyDesc = EMPTY_STRING;
  String comments = EMPTY_STRING;
  String prescDate = EMPTY_STRING;
  String endDate = EMPTY_STRING;
  String pageMode = null;
  String isAdd = EMPTY_STRING;
  
  String nmPharmacy = EMPTY_STRING;
  String phoneNumber = EMPTY_STRING;
  String addLine1  = EMPTY_STRING;
  String city = EMPTY_STRING;
  String addLine2 = EMPTY_STRING;
  String state1 = EMPTY_STRING;
  String zip = EMPTY_STRING;
  String txtAddrZip5 = EMPTY_STRING;
  String txtAddrZip4 = EMPTY_STRING;
  
  int arrayIndex = ContextHelper.getIntSafe(request, "medicationIndex");

  // Get the page mode that was passed to the Medication
  // submodule by the including JSP.
  pageMode = (String) state.getAttribute(MedicationSubmoduleConversation.PAGE_MODE_KEY, request);

  PersonMedicationList selectedMedication = (PersonMedicationList) state.getAttribute("PersonMedicationList",
                                                                                      request);
                                                                          
  if (selectedMedication != null) {
    if (request.getParameter("medicationIndex") != null) {
      isAdd = request.getParameter("isAddMedication");
    }
    if (!"true".equals(isAdd)) {
      medName = FormattingHelper.formatString(selectedMedication.getLdNmMedctn());
      dosage = selectedMedication.getLdCdMedctnDose();
      reason = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnReason());
      adminPerson = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnAdminPerson());
      prescribingPerson = FormattingHelper.formatString(selectedMedication.getSzTxtPrescribingPerson());
      prescDate = selectedMedication.getLdDtMedctnPresc().toString();

      if(selectedMedication.getLdDtMedctnEndDate()!= null)
      {
        endDate = selectedMedication.getLdDtMedctnEndDate().toString();
      }
      allergies = selectedMedication.getLdIndMedctnAllergies();
      allergyDesc = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnDescrip());
      comments = FormattingHelper.formatString(selectedMedication.getLdTxtMedctnCmnts());
      if(allergies == null)
      {
         allergies="";
      }
      if (allergies.equals(ArchitectureConstants.Y)) {
        allergyPresent = true;
        allergyAbsent = false;
      } else if (allergies.equals(ArchitectureConstants.N)) {
        allergyPresent = false;
        allergyAbsent = true;
      } else {
        allergyPresent = true;//default
        allergyAbsent = false;
      }
      if(selectedMedication.getLdDtMedctnEndDate()!=null)
      {
      if (DateHelper.isBeforeToday(selectedMedication.getLdDtMedctnEndDate())){
        disableMedName = true;
        disableDosage = true;
        disableReason = true;
        disableAdminPerson = true;
        disablePrescDate = true;
        disableEndDate = true;
        disableAllergies = true;
        disableAllergyDisc = false;
        disablePharmacyInfo = true;
     }
     }
     nmPharmacy = FormattingHelper.formatString(selectedMedication.getLdPharmacy());
     phoneNumber = FormattingHelper.formatString(selectedMedication.getLdPhoneNumber());
     addLine1  = FormattingHelper.formatString(selectedMedication.getLdAddLine1());
     city = FormattingHelper.formatString(selectedMedication.getLdCity());
     addLine2 = FormattingHelper.formatString(selectedMedication.getLdAddLine2());
     state1 = FormattingHelper.formatString(selectedMedication.getLdState1());
     zip = FormattingHelper.formatString(selectedMedication.getLdZip());
     if (!EMPTY_STRING.equals(zip) ){
       int len = zip.length();
       if (len>=5){
          txtAddrZip5 = zip.substring(0,5);
         }
         if (len>5){
           txtAddrZip4 = zip.substring(5,len);
         }
     }
    }
  } //end if medretso not null

      out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction setHdnEndDate()\r\n{\r\n");
   if(!"true".equals(isAdd))

      out.write("\r\n   frmMedicationDetail.hdnMedEndDate.value = selectedMedication.getLdDtMedctnEndDate();\r\n}\r\n//End Java Script\r\n</script>\r\n\r\n\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmMedicationDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/person/MedicationDetail/saveMedicationDetail");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.MedicationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n  <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n  ");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("isAddMedication");
          _jspx_th_impact_validateInput_1.setValue( isAdd );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("medicationIndex");
          _jspx_th_impact_validateInput_2.setValue( FormattingHelper.formatInt(arrayIndex) );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n  <table width=\"100%\" class=\"tableborder\" cellpadding=\"3\" cellspacing=\"0\">\r\n    <tr>\r\n      <th colspan=\"8\">\r\n        Medication Information\r\n      </th>\r\n    <tr>\r\n      <td width=\"50%\">\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setDisabled( "" + disableMedName );
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Medication Name");
          _jspx_th_impact_validateInput_3.setId("szNmMedctn");
          _jspx_th_impact_validateInput_3.setName("szNmMedctn");
          _jspx_th_impact_validateInput_3.setSize("20");
          _jspx_th_impact_validateInput_3.setMaxLength("80");
          _jspx_th_impact_validateInput_3.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_3.setRequired("true");
          _jspx_th_impact_validateInput_3.setValue(medName );
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n      \t &nbsp;\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_0.setDisabled( "" + disableDosage );
          _jspx_th_impact_validateSelect_0.setLabel("Frequency");
          _jspx_th_impact_validateSelect_0.setId("szCdMedctnDose");
          _jspx_th_impact_validateSelect_0.setName("szCdMedctnDose");
          _jspx_th_impact_validateSelect_0.setWidth("20%");
          _jspx_th_impact_validateSelect_0.setValue(dosage);
          _jspx_th_impact_validateSelect_0.setRequired("true");
          _jspx_th_impact_validateSelect_0.setCodesTable("CMDDOSE");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_4.setDisabled( "" + disableReason );
          _jspx_th_impact_validateInput_4.setType("text");
          _jspx_th_impact_validateInput_4.setLabel("Reason");
          _jspx_th_impact_validateInput_4.setId("szTxtMedctnReason");
          _jspx_th_impact_validateInput_4.setName("szTxtMedctnReason");
          _jspx_th_impact_validateInput_4.setSize("20");
          _jspx_th_impact_validateInput_4.setMaxLength("80");
          _jspx_th_impact_validateInput_4.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_4.setValue( reason);
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_5.setDisabled( "" + disableAdminPerson );
          _jspx_th_impact_validateInput_5.setType("text");
          _jspx_th_impact_validateInput_5.setLabel("Administering Person");
          _jspx_th_impact_validateInput_5.setId("szTxtMedctnAdminPerson");
          _jspx_th_impact_validateInput_5.setName("szTxtMedctnAdminPerson");
          _jspx_th_impact_validateInput_5.setSize("20");
          _jspx_th_impact_validateInput_5.setMaxLength("80");
          _jspx_th_impact_validateInput_5.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_5.setValue( adminPerson );
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setName("szDtMedctnPresc");
          _jspx_th_impact_validateDate_0.setDisabled( "" + disablePrescDate );
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_0.setValue( prescDate );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setName("szDtMedctnEndDate");
          _jspx_th_impact_validateDate_1.setDisabled( "" + disableEndDate );
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateDate_1.setValue( endDate );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setDisabled( "" + disablePrescribingPerson );
          _jspx_th_impact_validateInput_6.setType("text");
          _jspx_th_impact_validateInput_6.setLabel("Prescribing Person");
          _jspx_th_impact_validateInput_6.setId("szTxtPrescribingPerson");
          _jspx_th_impact_validateInput_6.setName("szTxtPrescribingPerson");
          _jspx_th_impact_validateInput_6.setSize("20");
          _jspx_th_impact_validateInput_6.setMaxLength("80");
          _jspx_th_impact_validateInput_6.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_6.setValue( prescribingPerson );
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <th colspan=\"8\">\r\n        Pharmacy Information\r\n      </th>\r\n    <tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setDisabled( "" + disablePharmacyInfo );
          _jspx_th_impact_validateInput_7.setLabel("Pharmacy");
          _jspx_th_impact_validateInput_7.setId("szNmPharamacy");
          _jspx_th_impact_validateInput_7.setName("szNmPharamacy");
          _jspx_th_impact_validateInput_7.setSize("20");
          _jspx_th_impact_validateInput_7.setMaxLength("80");
          _jspx_th_impact_validateInput_7.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_7.setValue(nmPharmacy );
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setDisabled( "" + disablePharmacyInfo );
          _jspx_th_impact_validateInput_8.setLabel("Phone Number");
          _jspx_th_impact_validateInput_8.setId("szPhoneNumber");
          _jspx_th_impact_validateInput_8.setName("szPhoneNumber");
          _jspx_th_impact_validateInput_8.setSize("14");
          _jspx_th_impact_validateInput_8.setMaxLength("14");
          _jspx_th_impact_validateInput_8.setConstraint("Phone");
          _jspx_th_impact_validateInput_8.setValue(FormattingHelper.formatPhone(phoneNumber));
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setDisabled( "" + disablePharmacyInfo );
          _jspx_th_impact_validateInput_9.setLabel("Address Line 1");
          _jspx_th_impact_validateInput_9.setId("szAddLine1");
          _jspx_th_impact_validateInput_9.setName("szAddLine1");
          _jspx_th_impact_validateInput_9.setSize("20");
          _jspx_th_impact_validateInput_9.setMaxLength("80");
          _jspx_th_impact_validateInput_9.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_9.setValue(addLine1 );
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setDisabled( "" + disablePharmacyInfo );
          _jspx_th_impact_validateInput_10.setLabel("City");
          _jspx_th_impact_validateInput_10.setId("szCity");
          _jspx_th_impact_validateInput_10.setName("szCity");
          _jspx_th_impact_validateInput_10.setSize("20");
          _jspx_th_impact_validateInput_10.setMaxLength("80");
          _jspx_th_impact_validateInput_10.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_10.setValue(city);
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setDisabled( "" + disablePharmacyInfo );
          _jspx_th_impact_validateInput_11.setLabel("Address Line 2");
          _jspx_th_impact_validateInput_11.setId("szAddLine2");
          _jspx_th_impact_validateInput_11.setName("szAddLine2");
          _jspx_th_impact_validateInput_11.setSize("20");
          _jspx_th_impact_validateInput_11.setMaxLength("80");
          _jspx_th_impact_validateInput_11.setConstraint("Paragraph80");
          _jspx_th_impact_validateInput_11.setValue(addLine2 );
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setLabel("State");
          _jspx_th_impact_validateSelect_1.setDisabled( "" + disablePharmacyInfo );
          _jspx_th_impact_validateSelect_1.setId("szState");
          _jspx_th_impact_validateSelect_1.setName("szState");
          _jspx_th_impact_validateSelect_1.setWidth("20%");
          _jspx_th_impact_validateSelect_1.setValue(state1);
          _jspx_th_impact_validateSelect_1.setCodesTable("CSTATE");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        &nbsp;\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setName("txtZip5");
          _jspx_th_impact_validateInput_12.setLabel("Zip");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setValue(txtAddrZip5);
          _jspx_th_impact_validateInput_12.setMaxLength("5");
          _jspx_th_impact_validateInput_12.setSize("5");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_12.setConstraint("Digit5");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    -\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("text");
          _jspx_th_impact_validateInput_13.setName("txtZip4");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setValue(txtAddrZip4);
          _jspx_th_impact_validateInput_13.setConstraint("Digit4");
          _jspx_th_impact_validateInput_13.setMaxLength("4");
          _jspx_th_impact_validateInput_13.setSize("4");
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <th colspan=\"8\">\r\n        Allergy Information \r\n      </th>\r\n    <tr>\r\n    <tr>\r\n      <td>\r\n        <span class=\"formCondRequiredText\">&#8225;</span>Allergies:\r\n      </td>\r\n\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setChecked( String.valueOf( allergyAbsent ) );
          _jspx_th_impact_validateInput_14.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_14.setDisabled( "" + disableAllergies );
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_14.setValue("N");
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setName("szIndMedctnAllergies");
          _jspx_th_impact_validateInput_14.setLabel("No");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setChecked( String.valueOf( allergyPresent ) );
          _jspx_th_impact_validateInput_15.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_15.setDisabled( "" + disableAllergies );
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_15.setValue("Y");
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setName("szIndMedctnAllergies");
          _jspx_th_impact_validateInput_15.setLabel("Yes");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td>\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setDisabled( "" + disableAllergyDisc );
          _jspx_th_impact_validateTextArea_0.setCols("80");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setLabel("Allergy Description");
          _jspx_th_impact_validateTextArea_0.setName("szTxtMedctnDescrip");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(allergyDesc);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n    <tr>\r\n      <td >\r\n        ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setDisabled( "" + disableComments );
          _jspx_th_impact_validateTextArea_1.setCols("80");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setLabel("Comments");
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_1.setName("szTxtMedctnCmnts");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n          ");
              out.print(comments);
              out.write("\r\n        ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
if (!disableSaveButton) {
          out.write("\r\n  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n    <tr>\r\n      <td align=\"right\">\r\n        ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave1");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setForm("frmMedicationDetail");
          _jspx_th_impact_ButtonTag_0.setFunction("setHdnEndDate(selectedMedication.getLdDtMedctnEndDate());");
          _jspx_th_impact_ButtonTag_0.setFunction("setIsDirtyCalled(false);");
          _jspx_th_impact_ButtonTag_0.setAction("/person/MedicationDetail/saveMedicationDetail");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n  ");
}
          out.write('\r');
          out.write('\n');
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnMedEndDate");
    _jspx_th_impact_validateInput_0.setValue("12/31/3500");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
