package org.apache.jsp.grnds_002ddocs.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES02SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES07DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SelectedLicensureTypesArray;
import gov.georgia.dhr.dfcs.sacwis.web.core.metaphor.MetaphorTabs;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;

public final class FacilityDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(' ');
      out.write(' ');

/**
 * JSP Name:     FacilityDetail.jsp
 * Created by:   cawthocw
 * Date Created: 07/26/02
 *
 * Description:
 * This page displays the Facility Detail Information.
*
* Change History:
* Date      User              Description
* --------  ----------------  -----------------------------------------------
* 06/11/03  Todd Reser        18216 - added isExpanded="true" to
*                             ExpandableSectionTag : Level of Care History.
* 08/07/03  Todd Reser        Modified/Added Flowerbox and/or Change Log.
* 12/01/03  CORLEYAN          LOC Enhancement - When displaying LOC list, also
*                             check for new codes for post 09/01/2003.  The add
*                             pushbutton also now goes to add level of care instead
*                             of modify.
* 02/18/04  Linda Reed        SIR 22625- added txtChildResourceId so Home ResourceId
*                             passed on to following pages.
* 09/16/05  berkime           SIR 23890 - changed the wording from level of care to
*                             service level.
* 01/06/09  hnguyen           STGAP00010697 - modified Other/Specialty Certification
*                             textfield maxlength and constraint to 50 characters.
*/

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n  ");

    BaseSessionStateManager state = (BaseSessionStateManager)
            request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

    TuxedoPaginationValueBean tuxPagination = (TuxedoPaginationValueBean)
            request.getAttribute(PaginationResultBean.REQUEST_ATTRIBUTE_NAME);

    if (tuxPagination != null) {
      DatabaseResultDetails db = tuxPagination.getResultDetails();
    }

    String idResource = null;
    String facilityName = null;
    String facilityNumber = null;
    String contact = null;
    String resourceType = null;
    String facilityType = null;
    String certBy = "";
    String othSpclRsrcCert = "";
    String certificationDate = "";
    String closeDate = "";
    String availableAfterHours = "false";

    String codesTable = "CERTIFBY";
    CRES02SO cres02so = null;
    CRES09SO cres09so = null;
    ROWCRES07DO_ARRAY locArray = null;
    
    int capacity = 0;

    boolean facilitySaveButtonHide = false;
    //get the page mode
    String pageMode = PageMode.getPageMode(request);

    //get the input parameters from Global Data and state
    idResource = GlobalData.getUlIdResourceAsString(request);
    facilityName = GlobalData.getSzNmResource(request);
    facilityNumber = (String) state.getAttribute("lNbrRsrcFacilAcclaim", request);

    contact = (String) state.getAttribute("szNmRsrcContact", request);
    resourceType = (String) state.getAttribute(MetaphorTabs.RESOURCE_TYPE_ATTRIBUTE_NAME, request);
    facilityType = (String) state.getAttribute("szCdRsrcFacilType", request);
    //get the facility detail information
    cres09so = (CRES09SO) state.getAttribute("cres09so", request);
    //get the home list information
    cres02so = (CRES02SO) request.getAttribute("cres02so");
    //Get specific data from cres09so
    if (cres09so != null)
     {
      locArray = cres09so.getROWCRES07DO_ARRAY();
      capacity = cres09so.getUNbrRsrcFacilCapacity();

      if (StringHelper.isValid(cres09so.getSzCdRsrcCertBy())) 
      {
        certBy = cres09so.getSzCdRsrcCertBy();
      }
        
      if (StringHelper.isValid(cres09so.getTxtSpecCert()))
       {
        othSpclRsrcCert = cres09so.getTxtSpecCert();
       }
      //if there are certification and close dates, format them to the correct MM/DD/YYYY format
      if (cres09so.getDtDtRsrcCert() != null)
       {
        certificationDate = FormattingHelper.formatDate(cres09so.getDtDtRsrcCert());
       }
      if (cres09so.getDtDtRsrcClose() != null)
       {
        closeDate = FormattingHelper.formatDate(cres09so.getDtDtRsrcClose());
       }
       if(cres09so.getBIndAvailableAfterHrs() != null)
       {
         if(cres09so.getBIndAvailableAfterHrs().equals("Y"))
         {
         	availableAfterHours = "true";
         }
       }
    }
    
    ArrayList selLicensureTypesList = new ArrayList();
    if(cres09so != null)
    {
      SelectedLicensureTypesArray selectedLicensureTypesArray = cres09so.getSelectedLicensureTypesArray();
      if(selectedLicensureTypesArray != null)
      {
        for(Iterator it = selectedLicensureTypesArray.iterateSzPrgmLicensureType(); it.hasNext();)
        {
          String pgmLcnsreType = (String)it.next();
          selLicensureTypesList.add(pgmLcnsreType);
        }
      }
    }
    
    
    

    ROWCRES07DO locRow = null;
    //create new instance of the Home List array
    CRES02SOG01_ARRAY homeArray = new CRES02SOG01_ARRAY();
    CRES02SOG01 homeRow = null;
    if (cres02so != null) {
      homeArray = cres02so.getCRES02SOG01_ARRAY();
    }

    //check to see if the facility type supports Level of Care
    String levelOfCareSupported = null;
    if (facilityType != null) {
      levelOfCareSupported = Lookup.simpleDecodeSafe("CFACLOC", facilityType);
    }
      
    //If the page mode is Edit AND Resource Type is not Mhmr AND , show editable Cert date field
    String certificationDateMode = Integer.toString(EditableMode.EDIT);
    String certificationDateRequired = "true";
    String certificationDateDisabled = "false";
    String certifiedByDisabled = "false";
    if (pageMode.equals(PageModeConstants.VIEW)
        || (pageMode.equals(PageModeConstants.EDIT) && resourceType != null && "05".equals(resourceType))
        || StringHelper.isValid(facilityNumber)) {
      certificationDateMode = Integer.toString(EditableMode.NONE);
      certificationDateRequired = "false";
    }

    //Set Lic Capacity and Close Date to Protected if its a class facility (ie has fac #)
    int classFacilityTypeMode = EditableMode.EDIT;
    String closeDateDisabled = "false";
    if (StringHelper.isValid(facilityNumber) || pageMode.equals(PageModeConstants.VIEW)) {
      classFacilityTypeMode = EditableMode.NONE;
      certificationDateDisabled = "true";
      certifiedByDisabled = "true";
      closeDateDisabled = "true";
      facilitySaveButtonHide = true;
    }

    int tabIndex = 1;
  
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n//Set Page to display confirmation message on leaving page if something has changed\r\n  window.attachEvent('onbeforeunload', setDirty );\r\n  function setDirty()\r\n  {\r\n    IsDirty();\r\n  }\r\n\r\n//Submit the form to the saveFacility command\r\nfunction saveFacility()\r\n{\r\n  window.onbeforeunload = null;\r\n  document.FacilityDetail.cReqFuncCd.value = \"U\";\r\n  document.FacilityDetail.locDataAction.value = \"A\";\r\n  submitValidateForm( \"FacilityDetail\", \"/resource/Facility/saveFacility\" );\r\n}\r\n\r\n\r\nfunction modifyLevelOfCare(active, hold, effective, end, rownum)\r\n{\r\n  document.modifyLOC.activeLOC.value = active;\r\n  document.modifyLOC.holdLOC.value = hold;\r\n  document.modifyLOC.effectiveDate.value = effective;\r\n  document.modifyLOC.endDate.value = end;\r\n  document.modifyLOC.rownum.value = rownum;\r\n  document.modifyLOC.pageMode.value = \"");
      out.print(pageMode);
      out.write("\";\r\n  submitForm( \"modifyLOC\", \"/resource/Facility/modifyLOC\" );\r\n}\r\n\r\nfunction displayCaretakerInformation( idResource )\r\n{\r\n  document.FacilityDetail.txtChildResourceId.value = idResource;\r\n  disableValidation('FacilityDetail');\r\n  submitValidateForm( \"FacilityDetail\", \"/resource/Caretaker/displayCaretakerInformation\" );\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("FacilityDetail");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/resource/Facility/saveFacility");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
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
          _jspx_th_impact_validateInput_0.setName("txtLNbrRsrcFacilAcclaim");
          _jspx_th_impact_validateInput_0.setId("txtLNbrRsrcFacilAcclaim");
          _jspx_th_impact_validateInput_0.setValue(facilityNumber);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("txtNmRsrcContact");
          _jspx_th_impact_validateInput_2.setId("txtNmRsrcContact");
          _jspx_th_impact_validateInput_2.setValue(contact);
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
          _jspx_th_impact_validateInput_3.setName("cboCdRsrcType");
          _jspx_th_impact_validateInput_3.setId("cboCdRsrcType");
          _jspx_th_impact_validateInput_3.setValue(resourceType);
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
          _jspx_th_impact_validateInput_4.setName("cboCdRsrcFacilType");
          _jspx_th_impact_validateInput_4.setId("cboCdRsrcFacilType");
          _jspx_th_impact_validateInput_4.setValue(facilityType);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName(PageMode.PAGE_MODE_ATTRIBUTE_NAME );
          _jspx_th_impact_validateInput_7.setValue(pageMode);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setEditableMode(EditableMode.EDIT);
          _jspx_th_impact_validateInput_8.setName("validationOverride");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n  \r\n   <tr><th colspan=\"8\">Certification Information</th> </tr>\r\n  \r\n  <tr class=\"subDetail\">\r\n    <td>\r\n     ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtPlacementName");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Placement Provider Name");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( FormattingHelper.formatString( StringHelper.getNonNullString(facilityName)));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td >\r\n     ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName("certDate");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setLabel("Certification Date");
          _jspx_th_impact_validateDate_0.setRequired("true");
          _jspx_th_impact_validateDate_0.setValue(certificationDate);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td class=\"formLabel\" height=\"25\">\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtContactName");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Contact");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.formatString( StringHelper.getNonNullString(contact)));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>\r\n      ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName("closeDate");
          _jspx_th_impact_validateDate_1.setDisabled("false");
          _jspx_th_impact_validateDate_1.setLabel("Close Date");
          _jspx_th_impact_validateDate_1.setValue(closeDate);
          _jspx_th_impact_validateDate_1.setSize("8");
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>    \r\n  <tr class=\"subDetail\">\r\n    <td>\r\n      ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Certification Type");
          _jspx_th_impact_validateSelect_0.setValue(certBy);
          _jspx_th_impact_validateSelect_0.setName("szCdRsrcCertBy");
          _jspx_th_impact_validateSelect_0.setCodesTable("CERTIFBY");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setStyle("WIDTH: 340px");
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setLabel("Licensing Capacity");
          _jspx_th_impact_validateInput_9.setEditableMode(classFacilityTypeMode);
          _jspx_th_impact_validateInput_9.setMaxLength("4");
          _jspx_th_impact_validateInput_9.setType("input");
          _jspx_th_impact_validateInput_9.setConstraint("Numeric");
          _jspx_th_impact_validateInput_9.setName("uNbrRsrcFacilCapacity");
          _jspx_th_impact_validateInput_9.setSize("4");
          _jspx_th_impact_validateInput_9.setValue(Integer.toString(capacity));
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n   <td>\r\n   \t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setName("ckAvailAfterHrs");
          _jspx_th_impact_validateInput_10.setChecked(availableAfterHours);
          _jspx_th_impact_validateInput_10.setType("checkbox");
          _jspx_th_impact_validateInput_10.setValue("ON");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setLabel("Available After Hours?");
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n  </tr>\r\n  <tr class=\"subDetail\">\r\n    <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_11.setValue(othSpclRsrcCert);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setName("txtSpecCert");
          _jspx_th_impact_validateInput_11.setLabel("Other/Specialty Certification");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setSize("30");
          _jspx_th_impact_validateInput_11.setMaxLength("50");
          _jspx_th_impact_validateInput_11.setConstraint("Paragraph50");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n  </td>\r\n</tr>     \r\n</table>\r\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\" >\r\n<tr><th colspan=\"6\">Program Licensure Types</th></tr>\r\n<tr class=\"subDetail\">\r\n   ");

      int prgmLicensureTypesLoopCount = 0;
      Collection prgmLicensureTypesCollection = Lookup.getCategoryCodesCollection(CodesTables.CPGLICTP);
      Iterator prgmLicensureTypesIter = prgmLicensureTypesCollection.iterator();
      while(prgmLicensureTypesIter.hasNext())
      {
          String prgmLicensureType = (String)prgmLicensureTypesIter.next();
          boolean checked = false;
          if(selLicensureTypesList.contains(prgmLicensureType))
          {
            checked = true;
          }
          prgmLicensureTypesLoopCount++;
          String chkbxName = "PrgmLicensureTypesCbx_" + prgmLicensureTypesLoopCount;
  
          out.write("\r\n          <td>\r\n      ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setName( chkbxName );
          _jspx_th_impact_validateInput_12.setChecked( String.valueOf(checked) );
          _jspx_th_impact_validateInput_12.setType("checkbox");
          _jspx_th_impact_validateInput_12.setValue( String.valueOf(prgmLicensureType) );
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setLabel( Lookup.simpleDecodeSafe(CodesTables.CPGLICTP, prgmLicensureType));
          _jspx_th_impact_validateInput_12.setDisabled("false");
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
if (prgmLicensureTypesLoopCount % 3 == 0)
       {
          out.write("\r\n         </tr><tr class=\"subDetail\">\r\n           ");
}

                 } //end while
             if (prgmLicensureTypesLoopCount % 3 == 2)
                { 
          out.write("\r\n                 <td colspan=\"2\">&nbsp;</td>\r\n              ");
}
          out.write("\r\n  </tr>\r\n</table>\r\n\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" >\r\n  <tr>\r\n    <td align=\"left\" valign=\"top\" colspan=\"2\">\r\n      &nbsp;\r\n    </td>\r\n    <td align=\"right\" valign=\"top\" colspan=\"2\">\r\n       ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSave");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setAlign("right");
          _jspx_th_impact_ButtonTag_0.setFunction("return saveFacility();");
          _jspx_th_impact_ButtonTag_0.setForm("FacilityDetail");
          _jspx_th_impact_ButtonTag_0.setAction("/resource/Facility/saveFacility");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n </tr>\r\n</table>\r\n<br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n<!-- Begin LOC Table-->\r\n");
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
    _jspx_th_impact_validateInput_1.setName("txtChildResourceId");
    _jspx_th_impact_validateInput_1.setId("txtChildResourceId");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("locDataAction");
    _jspx_th_impact_validateInput_5.setId("locDataAction");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("cReqFuncCd");
    _jspx_th_impact_validateInput_6.setId("cReqFuncCd");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
