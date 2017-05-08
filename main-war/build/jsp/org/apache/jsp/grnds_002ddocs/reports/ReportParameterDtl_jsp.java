package org.apache.jsp.grnds_002ddocs.reports;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.lang.String;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveReportParametersSO;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.reports.ReportStaffSearchDB;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public final class ReportParameterDtl_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

 UserProfile user = UserProfileHelper.getUserProfile(request);
 // SMS-52949: Populate report static info when page failed constraint validation too. The hdn fiels are used to populate the option lists.
 String hdnNmRptSqrName = request.getParameter("hdnNmRptSqrName") == null ? request.getParameter("szNmRptSqrName") : request.getParameter("hdnNmRptSqrName");	
 String hdnNmRptSqrVer = request.getParameter("hdnNmRptSqrVer") == null ? request.getParameter("szNmRptSqrVer") : request.getParameter("hdnNmRptSqrVer");
 String hdnNmRptType = request.getParameter("hdnNmRptType") == null ? request.getParameter("szNmRptType") : request.getParameter("hdnNmRptType");
 BaseSessionStateManager state = (BaseSessionStateManager)
  request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

 //Set the page mode
 String pageMode = PageModeConstants.EDIT;

 int tabIndex = 1;
 String reportName = (String)state.getAttribute("NAME_OF_REPORT", request);
 List<RetrieveReportParametersSO> list = (List)state.getAttribute("PARAMETER_LIST", request);
 Iterator<RetrieveReportParametersSO>  parmIterator = list.iterator(); 
 boolean hasStaffName= false;
 ReportStaffSearchDB reportStaffSearchDb = (ReportStaffSearchDB)
         state.getAttribute(ReportsConversation.REPORT_STAFF_SEARCH_DB, request);
 hasStaffName = (reportStaffSearchDb != null && reportStaffSearchDb.getStaffId()!=0);
 
 String staffIdString = (hasStaffName) ? Integer.toString(reportStaffSearchDb.getStaffId()):"" ;    
 // STGAP00011011 - default county and region with user's county and region; 
 // set blank if user is of region 99 and/or county XXX   
 UserProfile userProfile = UserProfileHelper.getUserProfile(request);
 String userCounty = userProfile.getUserCounty();
 String userRegion = userProfile.getUserRegion();
 if (userCounty == null || "XXX".equalsIgnoreCase(userCounty) ) {
  userCounty = "";
 }
 // fail-safe since most reports set max length for county code at 3 chars
 if (userCounty.length() > 3) {
   userCounty = "";
  }
 if (userRegion == null || "099".equalsIgnoreCase(userRegion) ) {
  userRegion = "";
 } else {
 // user region was retrieved from Unit table which has 3-byte region code (eg 017 for Region 17); 
 // region dropdown sends 2-byte region code (17 for Region 17) to reports so remove the first byte, 
 // which should always be 0
  if (userRegion.trim().length() == 3) {
   userRegion = userRegion.substring(1);
  }
  // fail-safe when region code retrieved is not at length of 2 or 3
  // also most reports set max length for region code at 2 chars
  if (userRegion.length() > 2) {
   userRegion = "";
  }
 }
 // STGAP00012549 - adding hint on how to run statewide view of a report
 boolean hasRegionParm = false;
 boolean hasCountyParam = false;
 boolean regionRequired = false;
 boolean countyRequired = false;
 boolean hasOptionalRegionCountyParm = false;
 boolean hasOptionalRegionOnly = false;
 String statewideMessage = "";
 String udrMessage = "";
 
 // SMS #54117 Diversion Activity Report is having 'N' parameter for 'Open' Cases, 
 // 'Y' for 'Closed' Cases and blank string for 'All' Cases
 String blankValueDefault = "";
 String cdAllCases = "All";
 String cdOpenCases = "Open";
 String cdClosedCases = "Closed";
 
 Iterator<RetrieveReportParametersSO>  parmItr = list.iterator(); 
 while (parmItr.hasNext())
    {
      RetrieveReportParametersSO parmSO = parmItr.next();
      if (("COUNTYCD".equals(parmSO.getNmRptParmName()))) {
        hasCountyParam = true;
        if ("Y".equals(parmSO.getIndRequired())) {
          countyRequired =  true;
        }
      }
      if (("REGIONCD".equals(parmSO.getNmRptParmName()))) {
        hasRegionParm = true;
        if ("Y".equals(parmSO.getIndRequired())) {
          regionRequired =  true;
        }
      }
    }  
 if (hasRegionParm && !regionRequired && hasCountyParam && !countyRequired) {
   hasOptionalRegionCountyParm = true;
   statewideMessage = "Tip:  Set both region and county paramaters blank to generate the statewide or non-region/county specific view of this report.";
 } else if (hasRegionParm && !regionRequired && (!hasCountyParam || (hasCountyParam && countyRequired))) {
     hasOptionalRegionOnly = true;
     statewideMessage = "Tip:  Set the region parameter blank to generate the statewide or non-county specific view of this report.";
 }
 // end STGAP00012549  
 // SMS45483 - PPA report to exclude regular invoice (non adjustment invoice)
 List excludeINVADJCD = new ArrayList();
 excludeINVADJCD.add(CodesTables.CINVADJT_N);
 
  // SMS#51990: Set option list depend on resource report. 
 List<Option> facilOptionList = new ArrayList<Option>();
 List<Option> resourceOptionList = new ArrayList<Option>();
 List<Option> catOptionList = new ArrayList<Option>();
 List<Option> statusOptionList = new ArrayList<Option>();
 List<Option> caseStatusOptionList = new ArrayList<Option>();
 List<Option> stageOptionList = new ArrayList<Option>();
 

 if (ReportsConversation.RELATIVE_RESOURCE_RPRT_SQR_NAME.equals(hdnNmRptSqrName) || ReportsConversation.NON_PLACEMENT_RELATIVE_RESOURCE_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_NA, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_NA)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_NR, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_NR)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RC, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RC)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RE, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RE)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RN, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RN)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_RT, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_RT)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_SG, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_SG)));
 } else if (ReportsConversation.FACILITY_LIST_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_CC, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_CC)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_CP, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_CP)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_MH, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_MH)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_SH, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_SH)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_OT, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_OT)));
 } else if (ReportsConversation.HOME_LIST_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_70, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_70)));
 	facilOptionList.add(new Option(CodesTables.CFACTYP4_71, Lookup.simpleDecodeSafe(CodesTables.CFACTYP4, CodesTables.CFACTYP4_71)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_A, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_A)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_D, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_D)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_F, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_F)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_I, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_I)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_J, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_J)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_L, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_L)));
 	catOptionList.add(new Option(CodesTables.CFACATEG_O, Lookup.simpleDecodeSafe(CodesTables.CFACATEG, CodesTables.CFACATEG_O))); 
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_APP, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_APP)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PFA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PFA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PSA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PSA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PTA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PTA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_AFA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_AFA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_ASA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ASA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_ATA, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_ATA)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_PCL, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_PCL)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_CSD, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_CSD)));
 	statusOptionList.add(new Option(CodesTables.CFAHMSTA_WTL, Lookup.simpleDecodeSafe(CodesTables.CFAHMSTA, CodesTables.CFAHMSTA_WTL)));
 } else if (ReportsConversation.PROVIDER_LIST_RPRT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_01, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_01)));
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_02, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_02)));
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_03, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_03)));
 	resourceOptionList.add(new Option(CodesTables.CRSCTYPE_04, Lookup.simpleDecodeSafe(CodesTables.CRSCTYPE, CodesTables.CRSCTYPE_04)));
 } else if (ReportsConversation.DIV_ACT_CASE_STAT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	caseStatusOptionList.add(new Option(blankValueDefault, cdAllCases));
 	caseStatusOptionList.add(new Option(ArchitectureConstants.N, cdOpenCases));
 	caseStatusOptionList.add(new Option(ArchitectureConstants.Y, cdClosedCases)); 	 	
 } else if (ReportsConversation.CASE_WO_FTM_SQR_NAME.equals(hdnNmRptSqrName)) {
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FPR, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR)));
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FSU, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU)));
 } else if (ReportsConversation.FTM_WO_PARENT_PARTICIPATION_RPT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FPR, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR)));
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FSU, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU)));
 } else if (ReportsConversation.EDUCATION_DETAIL_RPT_SQR_NAME.equals(hdnNmRptSqrName)) {
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FPR, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FPR)));
 	stageOptionList.add(new Option(CodesTables.CSTAGES_FSU, Lookup.simpleDecodeSafe(CodesTables.CSTAGES, CodesTables.CSTAGES_FSU)));
 }
 
 // Contains drop down parameter name and corresponding option or sub list. Any new entry in this list should have a corresponding entry in the
 // paramCodesTablesMap list but not vice versa.
 HashMap<String, List<Option>> paramOptionMap = new HashMap<String, List<Option>>();
 paramOptionMap.put("CATEGORYCD", catOptionList);
 paramOptionMap.put("FACILITYCD", facilOptionList);
 paramOptionMap.put("FAHOMESTATUSCD", statusOptionList);
 paramOptionMap.put("RESOURCETYPECD", resourceOptionList);
 // SMS #54117 "STATUSCASECD" parameter does not have corresponding CODES_TABLES value; 
 // no need to have paramCodesTablesMap value
 paramOptionMap.put("STATUSCASECD", caseStatusOptionList);
 paramOptionMap.put("STAGECD", stageOptionList); //SMS 78537
  
 // Contains codes tables name for drop down parameters. Used for reports display full codes list
 // An entry in here does not require an corresponding entry in the paraOptionMap list
 // Also this is for parameters that do not require default value
 HashMap<String, String> paramCodesTablesMap = new HashMap<String, String>();
 paramCodesTablesMap.put("CATEGORYCD", "CFACATEG");
 paramCodesTablesMap.put("FACILITYCD", "CFACTYP4");
 paramCodesTablesMap.put("FAHOMESTATUSCD", "CFAHMSTA");
 paramCodesTablesMap.put("RESOURCETYPECD", "CRSCTYPE");
 paramCodesTablesMap.put("INVTYPECD", "CINVSRTP");
 paramCodesTablesMap.put("INVPHASECD", "CINVSRCH");
 paramCodesTablesMap.put("TCMDENIALREASONCD", "CTCMDEN");
 paramCodesTablesMap.put("STAGECD", "CSTAGES"); //SMS 78537
 
      out.write("\r\n\r\n<script type=\"text/javascript\">\r\n\r\n\r\n// The setParameters function loops through the input fields constructing a string that\r\n// will be passed to the ReportsConversation.  The format is param1^param2^.  Since the parameters\r\n// are listed on the page in order needed by the SQR program this approach works effectively.\r\nfunction setParameters(){\r\n  var parmString = \"\";\r\n  for (i=0; i < frmReportParameters.elements.length; i++)\r\n  {\r\n    var formElement = frmReportParameters.elements(i);\r\n    var inputName = formElement.name;\r\n    var index = inputName.indexOf(\"parm\");\r\n    var elementValue = \"\";\r\n    if (index == 0) {\r\n      //Set defaults for null fields.\r\n      if (inputName == \"parmMONTHYEAR\" && formElement.value == \"\"){\r\n        elementValue = \"12/4712\";\r\n      }\r\n      else if (formElement.value == \"\") {\r\n        elementValue = \"0\";\r\n      }\r\n      else {\r\n        elementValue = formElement.value;\r\n      } \r\n      parmString = parmString + elementValue + \"^\";\r\n    }\r\n  }\r\n  // Encode the string\r\n  parmString = escape(parmString);\r\n");
      out.write("  frmReportParameters.txtRptParmList.value = parmString;\r\n  return true;\r\n}\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmReportParameters");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.reports.ReportsCustomValidation");
      _jspx_th_impact_validateForm_0.setRedisplayParameters("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
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
          _jspx_th_impact_validateInput_1.setName("ulIdPerson");
          _jspx_th_impact_validateInput_1.setValue( String.valueOf(user.getUserID()));
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
          _jspx_th_impact_validateInput_2.setName( ReportsConversation.REPORT_PARAM_NM_PERSON_FULL );
          _jspx_th_impact_validateInput_2.setValue( String.valueOf(user.getUserFullName()) );
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
          _jspx_th_impact_validateInput_3.setName("szNmRptSqrName");
          _jspx_th_impact_validateInput_3.setValue(hdnNmRptSqrName);
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
          _jspx_th_impact_validateInput_4.setName("szNmRptSqrVer");
          _jspx_th_impact_validateInput_4.setValue(hdnNmRptSqrVer);
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
          _jspx_th_impact_validateInput_5.setName("szNmRptType");
          _jspx_th_impact_validateInput_5.setValue(hdnNmRptType);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n<!--- Begin Detail Table --->\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n\t  <th colspan=\"3\">");
          out.print(reportName);
          out.write("</th>\r\n  </tr>\r\n  \r\n  ");

    /**
    * While loop goes through the parameters for the report.  Depending on the name and type of parameter
    * the input element is created.
    */
    while (parmIterator.hasNext())
    {
      RetrieveReportParametersSO rrpSO = parmIterator.next();
      String paramName = rrpSO.getNmRptParmName();
      String paramNameRequest = "param" + paramName;
  
          out.write("\r\n  ");

      if ("DATE".equals(rrpSO.getTxtRptParmType()))
      { 
          out.write("\r\n        <tr>\r\n          <td width=\"25%\">\r\n          &nbsp;\r\n          </td>\r\n\t      <td>\r\n            ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue("");
          _jspx_th_impact_validateDate_0.setDisabled("false");
          _jspx_th_impact_validateDate_0.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateDate_0.setConditionallyRequired( ("C".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateDate_0.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateDate_0.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t   </td>\r\n        </tr>  \r\n   \r\n     ");
} else if ("MONTHYEAR".equals(rrpSO.getNmRptParmName())) { 
          out.write("\r\n       <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>      \r\n\t     <td>\r\n\t       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setSize( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_7.setValue("");
          _jspx_th_impact_validateInput_7.setType("text");
          _jspx_th_impact_validateInput_7.setDisabled("false");
          _jspx_th_impact_validateInput_7.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateInput_7.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateInput_7.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_7.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_7.setMaxLength( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_7.setConstraint("MonthYear");
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n       </tr>\r\n     ");
 // STGAP00013351 - added 2 new param name so that constraint error message can display the label for reports that have 2+ monthyear params
     } else if ("STARTMMYYYY".equals(rrpSO.getNmRptParmName())) { 
          out.write("\r\n       <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>      \r\n\t     <td>\r\n\t       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setSize( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_8.setValue("");
          _jspx_th_impact_validateInput_8.setType("text");
          _jspx_th_impact_validateInput_8.setDisabled("false");
          _jspx_th_impact_validateInput_8.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateInput_8.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateInput_8.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_8.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_8.setMaxLength( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_8.setConstraint("MonthYear");
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n       </tr>\r\n     ");
} else if ("ENDMMYYYY".equals(rrpSO.getNmRptParmName())) { 
          out.write("\r\n       <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>      \r\n\t     <td>\r\n\t       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setSize( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_9.setValue("");
          _jspx_th_impact_validateInput_9.setType("text");
          _jspx_th_impact_validateInput_9.setDisabled("false");
          _jspx_th_impact_validateInput_9.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateInput_9.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateInput_9.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_9.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_9.setMaxLength( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_9.setConstraint("MonthYear");
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n       </tr>\r\n     ");
} else if (("COUNTYCD".equals(rrpSO.getNmRptParmName()))) {
          out.write("\r\n        <tr>\r\n         <td width=\"25%\">\r\n           &nbsp;\r\n         </td>        \r\n\t     <td>    \r\n   \t\t  ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("County");
          _jspx_th_impact_validateSelect_0.setRequired("false");
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_0.setCodesTable("CCOUNT");
          _jspx_th_impact_validateSelect_0.setValue( userCounty );
          _jspx_th_impact_validateSelect_0.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("   \r\n\t     </td>\r\n       </tr>     \r\n     ");
} else if (("REGIONCD".equals(rrpSO.getNmRptParmName()))) {
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setLabel("Region");
          _jspx_th_impact_validateSelect_1.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_1.setValue( userRegion );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_1.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_1.setConditionallyRequired( ("C".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_1.setCodesTable("CREGIONS");
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n     ");
} else if ("UNIT".equals(rrpSO.getNmRptParmName())) { 
          out.write("\r\n       <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>      \r\n\t     <td>\r\n\t       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setSize("2");
          _jspx_th_impact_validateInput_10.setValue("");
          _jspx_th_impact_validateInput_10.setType("text");
          _jspx_th_impact_validateInput_10.setDisabled("false");
          _jspx_th_impact_validateInput_10.setLabel("Unit");
          _jspx_th_impact_validateInput_10.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateInput_10.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_10.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_10.setMaxLength("2");
          _jspx_th_impact_validateInput_10.setConstraint("AlphaNumeric2Unit");
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n       </tr>       \r\n      ");
} else if("STAFFID".equals(rrpSO.getNmRptParmName())){ 
          out.write(" \r\n\t<!--STGAP00006764 staff Id requires select resource button-->\r\n       <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>\r\n\t     <td>\r\n\t       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setSize( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_11.setValue(staffIdString);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setDisabled("false");
          _jspx_th_impact_validateInput_11.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateInput_11.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_11.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_11.setMaxLength( String.valueOf(rrpSO.getNbrRptParmLength()) );
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n        </tr>\r\n        <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>\r\n\t     <td>\t\r\n         ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setDisabled("false");
          _jspx_th_impact_ButtonTag_0.setForm("frmReportParameters");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_0.setFunction("disableValidation('frmReportParameters');");
          _jspx_th_impact_ButtonTag_0.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_0.setAction("/admin/Reports/displayStaffList");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n        </tr>\t      \r\n      ");
// SMS#51990:: general logic for codes tables parameters
      } else if ((StringHelper.isValid(paramName)) && 
     (paramCodesTablesMap.containsKey(paramName) ) )  { 
               if (paramOptionMap.containsKey(paramName) && paramOptionMap.get(paramName).size() > 0) {// extra check  for size > 0 even though a full code list parameter should not be in this option map list
      
          out.write("\r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_2.setName( "parm" + paramName );
          _jspx_th_impact_validateSelect_2.setOptions( paramOptionMap.get(paramName) );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_2.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>      \r\n       \t\t");
} else { 
          out.write("\r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_3.setName( "parm" + paramName );
          _jspx_th_impact_validateSelect_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_3.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_3.setCodesTable( paramCodesTablesMap.get(paramName) );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>      \r\n     <!-- STGAP00013607 - invoice report: replaced with general logic above -->\r\n      ");
 // SMS #54117 The default value for the dropdown is "All" cases
      } } else if (("STATUSCASECD".equals(rrpSO.getNmRptParmName())) && (StringHelper.isValid(paramName)) 
      && (paramOptionMap.containsKey(paramName) 
      && paramOptionMap.get(paramName).size() > 0)) {
      
          out.write("\r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_4.setBlankValue("false");
          _jspx_th_impact_validateSelect_4.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_4.setName( "parm" + paramName );
          _jspx_th_impact_validateSelect_4.setValue( FormattingHelper.formatString(rrpSO.getTxtRptParmType().valueOf(blankValueDefault)) );
          _jspx_th_impact_validateSelect_4.setOptions( paramOptionMap.get(paramName) );
          _jspx_th_impact_validateSelect_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_4.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
          if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>      \r\n      <!--SMS# 74618 - Special Inv Report drop down parameter    -->       \r\n       ");
} else if ("SPECINVTYPE".equals(rrpSO.getNmRptParmName())) 
      { 
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_5.setBlankValue("true");
          _jspx_th_impact_validateSelect_5.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_5.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_5.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_5.setCodesTable("CSPECREQ");
          int _jspx_eval_impact_validateSelect_5 = _jspx_th_impact_validateSelect_5.doStartTag();
          if (_jspx_th_impact_validateSelect_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n      <!--  MR-34 and MR-59 - PPA report (SMS45483): new parameter drop down-->\r\n      ");
 } else if (("INVADJCD".equals(rrpSO.getNmRptParmName()))) {
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_6.setBlankValue("true");
          _jspx_th_impact_validateSelect_6.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_6.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_6.setExcludeOptions( excludeINVADJCD );
          _jspx_th_impact_validateSelect_6.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_6.setCodesTable("CINVADJT");
          int _jspx_eval_impact_validateSelect_6 = _jspx_th_impact_validateSelect_6.doStartTag();
          if (_jspx_th_impact_validateSelect_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n      <!--  STGAP00013184 - TCM report: replaced with general logic above -->\r\n      <!--  STGAP00015328 - Case Review List report (MR-056) -->\r\n     ");
 } else if (("CASEREVIEWTYPECD".equals(rrpSO.getNmRptParmName()))) {
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_7.setBlankValue("true");
          _jspx_th_impact_validateSelect_7.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_7.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_7.setValue( CodesTables.CCSRTYPE_RT4 );
          _jspx_th_impact_validateSelect_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_7.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_7.setCodesTable("CCSRTYPE");
          int _jspx_eval_impact_validateSelect_7 = _jspx_th_impact_validateSelect_7.doStartTag();
          if (_jspx_th_impact_validateSelect_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n      <!--   end STGAP00015328-->\r\n      <!-- Begin Adding three new types for Case Watch Activity Report -->\r\n     ");
 } else if (("ERRWARN".equals(rrpSO.getNmRptParmName()))) {
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>\r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_8.setBlankValue("false");
          _jspx_th_impact_validateSelect_8.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_8.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_8.setValue( CodesTables.CERRWARN_ALL );
          _jspx_th_impact_validateSelect_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_8.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_8.setCodesTable("CERRWARN");
          int _jspx_eval_impact_validateSelect_8 = _jspx_th_impact_validateSelect_8.doStartTag();
          if (_jspx_th_impact_validateSelect_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n     ");
 } else if (("OPNCLDSTG".equals(rrpSO.getNmRptParmName()))) {
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_9.setBlankValue("false");
          _jspx_th_impact_validateSelect_9.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_9.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_9.setValue( CodesTables.COPCLSTG_OPNONLY );
          _jspx_th_impact_validateSelect_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_9.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_9.setCodesTable("COPCLSTG");
          int _jspx_eval_impact_validateSelect_9 = _jspx_th_impact_validateSelect_9.doStartTag();
          if (_jspx_th_impact_validateSelect_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n     ");
 } else if (("ERRWARNTYP".equals(rrpSO.getNmRptParmName()))) { 
          out.write("     \r\n        <tr>\r\n         <td width=\"25%\">\r\n          &nbsp;\r\n         </td>   \r\n\t     <td>    \r\n           ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_10.setBlankValue("false");
          _jspx_th_impact_validateSelect_10.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateSelect_10.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateSelect_10.setValue( CodesTables.CERWRTYP_ALL );
          _jspx_th_impact_validateSelect_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateSelect_10.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateSelect_10.setCodesTable("CERWRTYP");
          int _jspx_eval_impact_validateSelect_10 = _jspx_th_impact_validateSelect_10.doStartTag();
          if (_jspx_th_impact_validateSelect_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("     \r\n\t     </td>\r\n       </tr>\r\n       <tr>\r\n       <td colspan=\"2\">\r\n       </td>\r\n       \t<td>\r\n\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspUdr2TipText");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue("When using date Parameters, Errors Only and All Open/Closed Stages must be selected");
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("       \t\t\r\n       \t</td>\r\n       </tr>\r\n      <!-- End Adding three new types for Case Watch Activity Report -->                           \r\n      ");
 
      	//Adding Tool Tip for Case Watch UDR Report
      	udrMessage = "Tip: To ensure your report does not return error message: 'Report exceeds limit of 65,000 rows of data,' you may need to input narrower Report Parameter search criteria (i.e. reduce number of regions, counties, case managers or time period).";
      
      } else {
          out.write("       \r\n       <tr>\r\n        <td width=\"25%\">\r\n          &nbsp;\r\n         </td>\r\n\t     <td>\r\n\t       ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setSize( String.valueOf(rrpSO.getNbrRptParmLength()) );
          _jspx_th_impact_validateInput_12.setValue("");
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setDisabled("false");
          _jspx_th_impact_validateInput_12.setLabel( rrpSO.getNmRptParmLabel() );
          _jspx_th_impact_validateInput_12.setName( "parm" + rrpSO.getNmRptParmName() );
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++);
          _jspx_th_impact_validateInput_12.setRequired( ("Y".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_12.setConditionallyRequired( ("C".equals(rrpSO.getIndRequired())) ? "true" : "false" );
          _jspx_th_impact_validateInput_12.setMaxLength( String.valueOf(rrpSO.getNbrRptParmLength()) );
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t     </td>\r\n        </tr>\r\n\t\t\t\r\n\t\r\n       ");
}
          out.write("     \r\n     \r\n ");
}// End while loop
          out.write(" \r\n \r\n</table>\r\n");
 // // STGAP00012549
if (hasOptionalRegionCountyParm || hasOptionalRegionOnly) { 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"> \r\n <tr>\r\n   <td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspTipText");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(statewideMessage);
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n </tr>\r\n <tr>\r\n   <td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspUdrTipText");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(udrMessage);
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n   </td>\r\n </tr> \r\n</table>\r\n");
 } 
          out.write('\r');
          out.write('\n');
 // end STGAP00012549 
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td width=\"72%\">&nbsp;</td>\r\n    <td class=\"alignRight\" width=\"10%\">&nbsp;</td>\r\n    <td class=\"alignRight\" width=\"18%\">                    \r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnLaunch");
          _jspx_th_impact_ButtonTag_1.setImg("btnLaunch");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmReportParameters");
          _jspx_th_impact_ButtonTag_1.setAction("/admin/Reports/launcherGenerate");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_1.setBackSafe("false");
          _jspx_th_impact_ButtonTag_1.setFunction("javascript:setParameters();");
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<!--- End Detail Table --->\r\n");
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
    _jspx_th_impact_validateErrors_0.setFormName("frmReportParameters");
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_6.setName("txtRptParmList");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
