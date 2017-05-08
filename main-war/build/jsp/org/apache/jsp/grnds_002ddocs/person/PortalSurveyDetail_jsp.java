package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport;
import gov.georgia.dhr.dfcs.sacwis.web.person.PortalSurveyDetailConversation;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PortalSurveyDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  
  String getLabelClass(String inputName, List errorInputs) {
    if (errorInputs != null && errorInputs.contains(inputName)) {
      return PortalSurveyDetailConversation.HTML_INFO_STYLE;
    } else {
      return PortalSurveyDetailConversation.HTML_LABEL_STYLE;
    }
  }

  String getLabel(String inputName, Map<String, String> labelMap) {
    return labelMap.get(inputName);
  }

  String getDescription(String inputName, Map<String, String> descMap) {
    return descMap.get(inputName);
  }
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  BaseSessionStateManager state = PortalSurveyDetailConversation.getSessionStateManager(request);

  boolean isBaseline = false;
  boolean isFollowUp = false;
  boolean indInCare = false;

  String currFTE = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME);
  String currPTE = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME);
  String empRelSkills = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME);
  String socialSecurity = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_SS_NAME);
  String eduAid = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_EDU_AID_NAME);
  String tanf = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_TANF_NAME);
  String foodStamps = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME);
  String publicHsg = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME);
  String otherIncome = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_OTH_INC_NAME);
  String highEdu = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_HECR_NAME);
  String currAttdEnr = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CAE_NAME);
  String connectAdult = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_C2A_NAME);
  String medicaid = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MEDICAID_NAME);
  String otherHIT = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_OHIT_NAME);
  String medical = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
  String mental = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
  String prescription = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
  String homeless = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_HOME_NAME);
  String subAbuseRef = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_SAR_NAME);
  String incarcerate = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_INC_NAME);
  String children = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_CHL_NAME);
  String marrAtBirth = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.RADIO_MAB_NAME);
  String cdPopulationType = ContextHelper.getStringSafe(request, PortalSurveyDetailConversation.HDN_POPULATION_TYPE);

  //-- get attributes from state
  List errorInputs = (List) request.getAttribute(PortalSurveyDetailConversation.VALIDATION_CUSTOM_INPUTS);
  
  YouthReportDetailRetrieveSOPerson soPerson = (YouthReportDetailRetrieveSOPerson) state
                                                                                        .getAttribute(
                                                                                                      PortalSurveyDetailConversation.RETRIEVE_SO_PERSON,
                                                                                                      request);
  YouthReportDetailRetrieveSOReport soReport = (YouthReportDetailRetrieveSOReport) state
                                                                                        .getAttribute(
                                                                                                      PortalSurveyDetailConversation.RETRIEVE_SO_REPORT,
                                                                                                      request);

  Map<String, String> labelMap = new HashMap<String, String>() {
        {
          // -- fields
          put(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, PortalSurveyDetailConversation.LABEL_CURR_FTE);
          put(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, PortalSurveyDetailConversation.LABEL_CURR_PTE);
          put(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, PortalSurveyDetailConversation.LABEL_EMP_SKILLS);
          put(PortalSurveyDetailConversation.RADIO_SS_NAME, PortalSurveyDetailConversation.LABEL_SS);
          put(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, PortalSurveyDetailConversation.LABEL_EDU_AID);
          put(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, PortalSurveyDetailConversation.LABEL_OTH_INC);
          put(PortalSurveyDetailConversation.RADIO_HECR_NAME, PortalSurveyDetailConversation.LABEL_HECR);
          put(PortalSurveyDetailConversation.RADIO_CAE_NAME, PortalSurveyDetailConversation.LABEL_CAE);
          put(PortalSurveyDetailConversation.RADIO_C2A_NAME, PortalSurveyDetailConversation.LABEL_C2A);

          put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.LABEL_HOME_B);
          put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.LABEL_SAR_B);
          put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.LABEL_INC_B);
          put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.LABEL_CHL_B);

          put(PortalSurveyDetailConversation.RADIO_MAB_NAME, PortalSurveyDetailConversation.LABEL_MAB);
          put(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, PortalSurveyDetailConversation.LABEL_MEDICAID);
          put(PortalSurveyDetailConversation.RADIO_OHIT_NAME, PortalSurveyDetailConversation.LABEL_OHIT);
          put(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, PortalSurveyDetailConversation.LABEL_MEDICAL);
          put(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, PortalSurveyDetailConversation.LABEL_MENTAL);
          put(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, PortalSurveyDetailConversation.LABEL_PRESCRIPTION);

          put(PortalSurveyDetailConversation.RADIO_TANF_NAME, PortalSurveyDetailConversation.LABEL_TANF);
          put(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, PortalSurveyDetailConversation.LABEL_FOOD_STMP);
          put(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, PortalSurveyDetailConversation.LABEL_PUB_HSG);
        }
      };

  Map<String, String> descMap = new HashMap<String, String>() {
        {
          // -- fields
          put(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, PortalSurveyDetailConversation.CURR_FTE_DESC);
          put(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, PortalSurveyDetailConversation.CURR_PTE_DESC);
          put(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, PortalSurveyDetailConversation.EMP_SKILLS_DESC);
          put(PortalSurveyDetailConversation.RADIO_SS_NAME, PortalSurveyDetailConversation.SS_DESC);
          put(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, PortalSurveyDetailConversation.EDU_AID_DESC);
          put(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, PortalSurveyDetailConversation.OTH_INC_DESC);
          put(PortalSurveyDetailConversation.RADIO_HECR_NAME, PortalSurveyDetailConversation.HECR_DESC);
          put(PortalSurveyDetailConversation.RADIO_CAE_NAME, PortalSurveyDetailConversation.CAE_DESC);
          put(PortalSurveyDetailConversation.RADIO_C2A_NAME, PortalSurveyDetailConversation.C2A_DESC);

          put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.HOME_DESC);
          put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.SAR_DESC);
          put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.INC_DESC);
          put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.CHL_DESC);

          put(PortalSurveyDetailConversation.RADIO_MAB_NAME, PortalSurveyDetailConversation.MAB_DESC);
          put(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, PortalSurveyDetailConversation.MEDICAID_DESC);
          put(PortalSurveyDetailConversation.RADIO_OHIT_NAME, PortalSurveyDetailConversation.OHIT_DESC);
          put(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, PortalSurveyDetailConversation.MEDICAL_DESC);
          put(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, PortalSurveyDetailConversation.MENTAL_DESC);
          put(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, PortalSurveyDetailConversation.PRESCRIPTION_DESC);

          put(PortalSurveyDetailConversation.RADIO_TANF_NAME, PortalSurveyDetailConversation.TANF_DESC);
          put(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, PortalSurveyDetailConversation.FOOD_STMP_DESC);
          put(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, PortalSurveyDetailConversation.PUB_HSG_DESC);
        }
      };
    
  //Set the page mode only one mode for survey).
  String pageMode = PageModeConstants.EDIT;

  //-- soReport should never be null
  if (soReport != null) {
    indInCare = StringHelper.toBooleanSafe(soReport.getIndFcStatOutcome());
    currFTE = soReport.getCdCurrFtEmp();
    currPTE = soReport.getCdCurrPtEmp();
    empRelSkills = soReport.getCdEmpSkills();
    socialSecurity = soReport.getCdSocialSec();
    eduAid = soReport.getCdEducAid();
    otherIncome = soReport.getCdOthSupport();
    highEdu = soReport.getCdHighestEdu();
    currAttdEnr = soReport.getCdCurrEnrAtt();
    connectAdult = soReport.getCdConnAdult();
    homeless = soReport.getCdHomeless();
    subAbuseRef = soReport.getCdSubAbuseRef();
    incarcerate = soReport.getCdIncarceration();
    children = soReport.getCdChildren();
    marrAtBirth = soReport.getCdMarrAtBirth();
    medicaid = soReport.getCdMedicaid();
    otherHIT = soReport.getCdOthHlthInsTyp();
    medical = soReport.getCdMedicalSvc();
    mental = soReport.getCdMentalHlthSvc();
    prescription = soReport.getCdPrescription();
    tanf = soReport.getCdPubFinAst();
    foodStamps = soReport.getCdFoodAst();
    publicHsg = soReport.getCdHousingAst();

    cdPopulationType = soReport.getCdPopulationType();
  }

  //-- soPerson should never be null!
  if (soPerson != null) {
    // Portal Survey will display based on child current data
    indInCare = StringHelper.toBooleanSafe(soPerson.getIndFcStatOutcome());
    cdPopulationType = soPerson.getCdPopulationType();
  }

  if (PortalSurveyDetailConversation.POPULATION_TYPE_BASELINE.equals(cdPopulationType)) {
    isBaseline = true;
    labelMap.put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.LABEL_HOME_B);
    labelMap.put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.LABEL_SAR_B);
    labelMap.put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.LABEL_INC_B);
    labelMap.put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.LABEL_CHL_B);
  } else if (PortalSurveyDetailConversation.POPULATION_TYPE_FOLLOW_UP.equals(cdPopulationType)) {
    isFollowUp = true;
    labelMap.put(PortalSurveyDetailConversation.RADIO_HOME_NAME, PortalSurveyDetailConversation.LABEL_HOME_F);
    labelMap.put(PortalSurveyDetailConversation.RADIO_SAR_NAME, PortalSurveyDetailConversation.LABEL_SAR_F);
    labelMap.put(PortalSurveyDetailConversation.RADIO_INC_NAME, PortalSurveyDetailConversation.LABEL_INC_F);
    labelMap.put(PortalSurveyDetailConversation.RADIO_CHL_NAME, PortalSurveyDetailConversation.LABEL_CHL_F);
  }

  // Create a 1-based tab index variable that can be used to set tab indices down the page.
  int tabIndex = 1;
  int outerColspan = 4;
  String width = "5%";
  int rowspan = 2;
  int colspan = 3;
  int row = 1;


      out.write('\r');
      out.write('\n');
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n\r\n");
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onload = function()\r\n  {\r\n    onRadioChanged();\r\n  };\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n\r\n  function onRadioChanged(){\r\n    if(getRadioCheckedValue('");
      out.print(PortalSurveyDetailConversation.RADIO_OHIT_NAME);
      out.write("') == '");
      out.print( CodesTables.CINVACAN_Y);
      out.write("'){\r\n      // Unhide question 16a\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("_lbl');\r\n      e.style.display = '';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("_desc');\r\n      e.style.display = '';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("_grp');\r\n      e.style.display = '';\r\n\r\n      if(getRadioCheckedValue('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("') == '");
      out.print( CodesTables.CINVACAN_Y);
      out.write("'){\r\n        // Unhide question 16b\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_lbl');\r\n\t      e.style.display = '';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_desc');\r\n\t      e.style.display = '';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_grp');\r\n\t      e.style.display = '';\r\n\t\r\n\t      // Unhide question 16c\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_lbl');\r\n\t      e.style.display = '';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_desc');\r\n\t      e.style.display = '';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_grp');\r\n\t      e.style.display = '';\r\n\t    }else{\r\n        // reset question 16b response\r\n\t      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("');\r\n\t      for( var i = 0; i < e.length; i++ ){\r\n\t        e[i].checked = false;\r\n\t      }\r\n\t      e.value = '");
      out.print( CodesTables.CINVACAN_A);
      out.write("';\r\n\t\r\n\t      // reset question 16c response\r\n\t      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("');\r\n\t      for( var i = 0; i < e.length; i++ ){\r\n\t        e[i].checked = false;\r\n\t      }\r\n\t      e.value = '");
      out.print( CodesTables.CINVACAN_A);
      out.write("';\r\n\t\r\n\t      // Hide question 16b\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_lbl');\r\n\t      e.style.display = 'none';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_desc');\r\n\t      e.style.display = 'none';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_grp');\r\n\t      e.style.display = 'none';\r\n\t\r\n\t      // Hide question 16c\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_lbl');\r\n\t      e.style.display = 'none';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_desc');\r\n\t      e.style.display = 'none';\r\n\t      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_grp');\r\n\t      e.style.display = 'none';\r\n\t    }\r\n    }else{\r\n      // Reset question 16a\r\n      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        e[i].checked = false;\r\n      }\r\n      e.value = '");
      out.print( CodesTables.CINVACAN_A);
      out.write("';\r\n\r\n      // Reset question 16b\r\n      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        e[i].checked = false;\r\n      }\r\n      e.value = '");
      out.print( CodesTables.CINVACAN_A);
      out.write("';\r\n\r\n      // Reset question 16c\r\n      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        e[i].checked = false;\r\n      }\r\n      e.value = '");
      out.print( CodesTables.CINVACAN_A);
      out.write("';\r\n\r\n      // Hide question 16a\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("_lbl');\r\n      e.style.display = 'none';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("_desc');\r\n      e.style.display = 'none';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
      out.write("_grp');\r\n      e.style.display = 'none';\r\n\r\n      // Hide question 16b\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_lbl');\r\n      e.style.display = 'none';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_desc');\r\n      e.style.display = 'none';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
      out.write("_grp');\r\n      e.style.display = 'none';\r\n\r\n      // Hide question 16c\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_lbl');\r\n      e.style.display = 'none';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_desc');\r\n      e.style.display = 'none';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("_grp');\r\n      e.style.display = 'none';\r\n    }\r\n    \r\n    // Hide question 14 if question 13 response is not Yes\r\n    if(getRadioCheckedValue('");
      out.print(PortalSurveyDetailConversation.RADIO_CHL_NAME);
      out.write("') == '");
      out.print( CodesTables.CINVACAN_Y);
      out.write("'){\r\n      // Unhide question 14\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MAB_NAME);
      out.write("_lbl');\r\n      e.style.display = '';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MAB_NAME);
      out.write("_desc');\r\n      e.style.display = '';\r\n      var e = document.getElementById('");
      out.print(PortalSurveyDetailConversation.RADIO_MAB_NAME);
      out.write("_grp');\r\n      e.style.display = '';\r\n\r\n      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_MAB_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        e[i].disabled = false;\r\n      }\r\n    }else{\r\n      // Reset question 14 response\r\n      var e = document.getElementsByName('");
      out.print(PortalSurveyDetailConversation.RADIO_MAB_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        e[i].checked = false;\r\n        e[i].disabled = true;\r\n      }\r\n      e.value = '");
      out.print( CodesTables.CINVACAN_A);
      out.write("';\r\n    }\r\n  }\r\n  \r\n  function getRadioCheckedValue( radioName ){\r\n    var oRadio = document.");
      out.print(PortalSurveyDetailConversation.FORM_NAME);
      out.write(".elements[radioName];\r\n  \r\n    for( var i = 0; i < oRadio.length; i++){\r\n      if(oRadio[i].checked){\r\n        return oRadio[i].value;\r\n      }\r\n      \r\n      return '';\r\n    }\r\n  }\r\n</script>\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName(PortalSurveyDetailConversation.FORM_NAME);
      _jspx_th_impact_validateForm_0.setAction("/person/PortalSurveyDetail/displaySurveyDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setPageMode(PageModeConstants.EDIT);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');

  if( (isBaseline || isFollowUp) 
    && NytdHelper.isDuringSurveyPeriod(soPerson.getDtDob())){

          out.write("\r\n\t<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\"\tborder=\"0\">\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setName(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME);
          _jspx_th_impact_validateInput_0.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_0.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(currFTE)));
          _jspx_th_impact_validateInput_0.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME);
          _jspx_th_impact_validateInput_1.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_1.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(currFTE)));
          _jspx_th_impact_validateInput_1.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setName(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME);
          _jspx_th_impact_validateInput_2.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_2.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(currFTE)));
          _jspx_th_impact_validateInput_2.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME);
          _jspx_th_impact_validateInput_3.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_3.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(currPTE)));
          _jspx_th_impact_validateInput_3.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setName(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME);
          _jspx_th_impact_validateInput_4.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_4.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(currPTE)));
          _jspx_th_impact_validateInput_4.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setName(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME);
          _jspx_th_impact_validateInput_5.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_5.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(currPTE)));
          _jspx_th_impact_validateInput_5.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setName(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME);
          _jspx_th_impact_validateInput_6.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_6.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(empRelSkills)));
          _jspx_th_impact_validateInput_6.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setName(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME);
          _jspx_th_impact_validateInput_7.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_7.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(empRelSkills)));
          _jspx_th_impact_validateInput_7.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setName(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME);
          _jspx_th_impact_validateInput_8.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_8.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(empRelSkills)));
          _jspx_th_impact_validateInput_8.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_SS_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_SS_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_SS_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setName(PortalSurveyDetailConversation.RADIO_SS_NAME);
          _jspx_th_impact_validateInput_9.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_9.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(socialSecurity)));
          _jspx_th_impact_validateInput_9.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setName(PortalSurveyDetailConversation.RADIO_SS_NAME);
          _jspx_th_impact_validateInput_10.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_10.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(socialSecurity)));
          _jspx_th_impact_validateInput_10.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setName(PortalSurveyDetailConversation.RADIO_SS_NAME);
          _jspx_th_impact_validateInput_11.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_11.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(socialSecurity)));
          _jspx_th_impact_validateInput_11.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setName(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME);
          _jspx_th_impact_validateInput_12.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_12.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(eduAid)));
          _jspx_th_impact_validateInput_12.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setName(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME);
          _jspx_th_impact_validateInput_13.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_13.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(eduAid)));
          _jspx_th_impact_validateInput_13.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setName(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME);
          _jspx_th_impact_validateInput_14.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_14.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(eduAid)));
          _jspx_th_impact_validateInput_14.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setName(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME);
          _jspx_th_impact_validateInput_15.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_15.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(otherIncome)));
          _jspx_th_impact_validateInput_15.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setName(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME);
          _jspx_th_impact_validateInput_16.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_16.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(otherIncome)));
          _jspx_th_impact_validateInput_16.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setName(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME);
          _jspx_th_impact_validateInput_17.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_17.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(otherIncome)));
          _jspx_th_impact_validateInput_17.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_HECR_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_HECR_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_HECR_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_18.setLabel(PortalSurveyDetailConversation.HIGH_SCHOOL_GED);
          _jspx_th_impact_validateInput_18.setChecked(String.valueOf(CodesTables.CHIGHEDU_HS.equals(highEdu)));
          _jspx_th_impact_validateInput_18.setValue(CodesTables.CHIGHEDU_HS);
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_19.setLabel(PortalSurveyDetailConversation.VOC_CERTIFICATE);
          _jspx_th_impact_validateInput_19.setChecked(String.valueOf(CodesTables.CHIGHEDU_VC.equals(highEdu)));
          _jspx_th_impact_validateInput_19.setValue(CodesTables.CHIGHEDU_VC);
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_20.setLabel(PortalSurveyDetailConversation.VOC_LICENSE);
          _jspx_th_impact_validateInput_20.setChecked(String.valueOf(CodesTables.CHIGHEDU_VL.equals(highEdu)));
          _jspx_th_impact_validateInput_20.setValue(CodesTables.CHIGHEDU_VL);
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_21.setLabel(PortalSurveyDetailConversation.ASSOCIATE);
          _jspx_th_impact_validateInput_21.setChecked(String.valueOf(CodesTables.CHIGHEDU_AD.equals(highEdu)));
          _jspx_th_impact_validateInput_21.setValue(CodesTables.CHIGHEDU_AD);
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_22.setLabel(PortalSurveyDetailConversation.BACHELOR);
          _jspx_th_impact_validateInput_22.setChecked(String.valueOf(CodesTables.CHIGHEDU_BD.equals(highEdu)));
          _jspx_th_impact_validateInput_22.setValue(CodesTables.CHIGHEDU_BD);
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_23.setLabel(PortalSurveyDetailConversation.HIGHER_DEGREE);
          _jspx_th_impact_validateInput_23.setChecked(String.valueOf(CodesTables.CHIGHEDU_HD.equals(highEdu)));
          _jspx_th_impact_validateInput_23.setValue(CodesTables.CHIGHEDU_HD);
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_24.setLabel(PortalSurveyDetailConversation.NONE_ABOVE);
          _jspx_th_impact_validateInput_24.setChecked(String.valueOf(CodesTables.CHIGHEDU_NA.equals(highEdu)));
          _jspx_th_impact_validateInput_24.setValue(CodesTables.CHIGHEDU_NA);
          _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                <br/>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setName(PortalSurveyDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_25.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_25.setChecked(String.valueOf(CodesTables.CHIGHEDU_DC.equals(highEdu)));
          _jspx_th_impact_validateInput_25.setValue(CodesTables.CHIGHEDU_DC);
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_CAE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_CAE_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_CAE_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setName(PortalSurveyDetailConversation.RADIO_CAE_NAME);
          _jspx_th_impact_validateInput_26.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_26.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(currAttdEnr)));
          _jspx_th_impact_validateInput_26.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setName(PortalSurveyDetailConversation.RADIO_CAE_NAME);
          _jspx_th_impact_validateInput_27.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_27.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(currAttdEnr)));
          _jspx_th_impact_validateInput_27.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setName(PortalSurveyDetailConversation.RADIO_CAE_NAME);
          _jspx_th_impact_validateInput_28.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_28.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(currAttdEnr)));
          _jspx_th_impact_validateInput_28.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_C2A_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_C2A_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_C2A_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setName(PortalSurveyDetailConversation.RADIO_C2A_NAME);
          _jspx_th_impact_validateInput_29.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_29.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(connectAdult)));
          _jspx_th_impact_validateInput_29.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setName(PortalSurveyDetailConversation.RADIO_C2A_NAME);
          _jspx_th_impact_validateInput_30.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_30.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(connectAdult)));
          _jspx_th_impact_validateInput_30.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("radio");
          _jspx_th_impact_validateInput_31.setName(PortalSurveyDetailConversation.RADIO_C2A_NAME);
          _jspx_th_impact_validateInput_31.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_31.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(connectAdult)));
          _jspx_th_impact_validateInput_31.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_HOME_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_HOME_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_HOME_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setName(PortalSurveyDetailConversation.RADIO_HOME_NAME);
          _jspx_th_impact_validateInput_32.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_32.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(homeless)));
          _jspx_th_impact_validateInput_32.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("radio");
          _jspx_th_impact_validateInput_33.setName(PortalSurveyDetailConversation.RADIO_HOME_NAME);
          _jspx_th_impact_validateInput_33.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_33.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(homeless)));
          _jspx_th_impact_validateInput_33.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("radio");
          _jspx_th_impact_validateInput_34.setName(PortalSurveyDetailConversation.RADIO_HOME_NAME);
          _jspx_th_impact_validateInput_34.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_34.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(homeless)));
          _jspx_th_impact_validateInput_34.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_SAR_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_SAR_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_SAR_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("radio");
          _jspx_th_impact_validateInput_35.setName(PortalSurveyDetailConversation.RADIO_SAR_NAME);
          _jspx_th_impact_validateInput_35.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_35.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(subAbuseRef)));
          _jspx_th_impact_validateInput_35.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("radio");
          _jspx_th_impact_validateInput_36.setName(PortalSurveyDetailConversation.RADIO_SAR_NAME);
          _jspx_th_impact_validateInput_36.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_36.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(subAbuseRef)));
          _jspx_th_impact_validateInput_36.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("radio");
          _jspx_th_impact_validateInput_37.setName(PortalSurveyDetailConversation.RADIO_SAR_NAME);
          _jspx_th_impact_validateInput_37.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_37.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(subAbuseRef)));
          _jspx_th_impact_validateInput_37.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_INC_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_INC_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_INC_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setName(PortalSurveyDetailConversation.RADIO_INC_NAME);
          _jspx_th_impact_validateInput_38.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_38.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(incarcerate)));
          _jspx_th_impact_validateInput_38.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setType("radio");
          _jspx_th_impact_validateInput_39.setName(PortalSurveyDetailConversation.RADIO_INC_NAME);
          _jspx_th_impact_validateInput_39.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_39.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(incarcerate)));
          _jspx_th_impact_validateInput_39.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setType("radio");
          _jspx_th_impact_validateInput_40.setName(PortalSurveyDetailConversation.RADIO_INC_NAME);
          _jspx_th_impact_validateInput_40.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_40.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(incarcerate)));
          _jspx_th_impact_validateInput_40.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_CHL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_CHL_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_CHL_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setType("radio");
          _jspx_th_impact_validateInput_41.setName(PortalSurveyDetailConversation.RADIO_CHL_NAME);
          _jspx_th_impact_validateInput_41.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_41.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(children)));
          _jspx_th_impact_validateInput_41.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_41.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setType("radio");
          _jspx_th_impact_validateInput_42.setName(PortalSurveyDetailConversation.RADIO_CHL_NAME);
          _jspx_th_impact_validateInput_42.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_42.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(children)));
          _jspx_th_impact_validateInput_42.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_42.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("radio");
          _jspx_th_impact_validateInput_43.setName(PortalSurveyDetailConversation.RADIO_CHL_NAME);
          _jspx_th_impact_validateInput_43.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_43.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(children)));
          _jspx_th_impact_validateInput_43.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_43.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_43.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MAB_NAME);
          out.write("_lbl\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_MAB_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_MAB_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MAB_NAME);
          out.write("_desc\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_MAB_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MAB_NAME);
          out.write("_grp\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("radio");
          _jspx_th_impact_validateInput_44.setName(PortalSurveyDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_44.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_44.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_44.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setType("radio");
          _jspx_th_impact_validateInput_45.setName(PortalSurveyDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_45.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_45.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_45.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_45.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_46.setType("radio");
          _jspx_th_impact_validateInput_46.setName(PortalSurveyDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_46.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_46.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_46.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setType("radio");
          _jspx_th_impact_validateInput_47.setName(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME);
          _jspx_th_impact_validateInput_47.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_47.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(medicaid)));
          _jspx_th_impact_validateInput_47.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_47.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
          if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_48.setType("radio");
          _jspx_th_impact_validateInput_48.setName(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME);
          _jspx_th_impact_validateInput_48.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_48.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(medicaid)));
          _jspx_th_impact_validateInput_48.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
          if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_49.setType("radio");
          _jspx_th_impact_validateInput_49.setName(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME);
          _jspx_th_impact_validateInput_49.setLabel(PortalSurveyDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_49.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(medicaid)));
          _jspx_th_impact_validateInput_49.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_49.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_50.setType("radio");
          _jspx_th_impact_validateInput_50.setName(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME);
          _jspx_th_impact_validateInput_50.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_50.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(medicaid)));
          _jspx_th_impact_validateInput_50.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
          if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_OHIT_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_OHIT_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_OHIT_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_51.setType("radio");
          _jspx_th_impact_validateInput_51.setName(PortalSurveyDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_51.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_51.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(otherHIT)));
          _jspx_th_impact_validateInput_51.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_51.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
          if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setType("radio");
          _jspx_th_impact_validateInput_52.setName(PortalSurveyDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_52.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_52.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(otherHIT)));
          _jspx_th_impact_validateInput_52.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_52.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setType("radio");
          _jspx_th_impact_validateInput_53.setName(PortalSurveyDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_53.setLabel(PortalSurveyDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_53.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(otherHIT)));
          _jspx_th_impact_validateInput_53.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_53.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setType("radio");
          _jspx_th_impact_validateInput_54.setName(PortalSurveyDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_54.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_54.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(otherHIT)));
          _jspx_th_impact_validateInput_54.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_54.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          out.write("_lbl\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          out.write("_desc\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          out.write("_grp\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_55.setType("radio");
          _jspx_th_impact_validateInput_55.setName(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_55.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_55.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(medical)));
          _jspx_th_impact_validateInput_55.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_55.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
          if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_56.setType("radio");
          _jspx_th_impact_validateInput_56.setName(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_56.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_56.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(medical)));
          _jspx_th_impact_validateInput_56.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_56.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
          if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_57.setType("radio");
          _jspx_th_impact_validateInput_57.setName(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_57.setLabel(PortalSurveyDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_57.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(medical)));
          _jspx_th_impact_validateInput_57.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_57.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_57.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
          if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_58.setType("radio");
          _jspx_th_impact_validateInput_58.setName(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_58.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_58.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(medical)));
          _jspx_th_impact_validateInput_58.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_58.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_58.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
          if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          out.write("_lbl\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          out.write("_desc\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          out.write("_grp\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_59.setType("radio");
          _jspx_th_impact_validateInput_59.setName(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_59.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_59.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(mental)));
          _jspx_th_impact_validateInput_59.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_59.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
          if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_60.setType("radio");
          _jspx_th_impact_validateInput_60.setName(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_60.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_60.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(mental)));
          _jspx_th_impact_validateInput_60.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_60.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setType("radio");
          _jspx_th_impact_validateInput_61.setName(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_61.setLabel(PortalSurveyDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_61.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(mental)));
          _jspx_th_impact_validateInput_61.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_61.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
          if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_62.setType("radio");
          _jspx_th_impact_validateInput_62.setName(PortalSurveyDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_62.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_62.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(mental)));
          _jspx_th_impact_validateInput_62.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_62.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
          if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          out.write("_lbl\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          out.write("_desc\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\" id=\"");
          out.print( PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          out.write("_grp\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_63.setType("radio");
          _jspx_th_impact_validateInput_63.setName(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_63.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_63.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(prescription)));
          _jspx_th_impact_validateInput_63.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_63.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
          if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_64.setType("radio");
          _jspx_th_impact_validateInput_64.setName(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_64.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_64.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(prescription)));
          _jspx_th_impact_validateInput_64.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_64.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_64 = _jspx_th_impact_validateInput_64.doStartTag();
          if (_jspx_th_impact_validateInput_64.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_65 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_65.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_65.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_65.setType("radio");
          _jspx_th_impact_validateInput_65.setName(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_65.setLabel(PortalSurveyDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_65.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(prescription)));
          _jspx_th_impact_validateInput_65.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_65.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_65 = _jspx_th_impact_validateInput_65.doStartTag();
          if (_jspx_th_impact_validateInput_65.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_66 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_66.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_66.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_66.setType("radio");
          _jspx_th_impact_validateInput_66.setName(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_66.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_66.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(prescription)));
          _jspx_th_impact_validateInput_66.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_66.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
          if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  if (isFollowUp && !indInCare ) {
		
          out.write("\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_TANF_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_TANF_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_TANF_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_67.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_67.setType("radio");
          _jspx_th_impact_validateInput_67.setName(PortalSurveyDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_67.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_67.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(tanf)));
          _jspx_th_impact_validateInput_67.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_67.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_67 = _jspx_th_impact_validateInput_67.doStartTag();
          if (_jspx_th_impact_validateInput_67.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_68 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_68.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_68.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_68.setType("radio");
          _jspx_th_impact_validateInput_68.setName(PortalSurveyDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_68.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_68.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(tanf)));
          _jspx_th_impact_validateInput_68.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_68.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_68 = _jspx_th_impact_validateInput_68.doStartTag();
          if (_jspx_th_impact_validateInput_68.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_69 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_69.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_69.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_69.setType("radio");
          _jspx_th_impact_validateInput_69.setName(PortalSurveyDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_69.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_69.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(tanf)));
          _jspx_th_impact_validateInput_69.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_69.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_69 = _jspx_th_impact_validateInput_69.doStartTag();
          if (_jspx_th_impact_validateInput_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_70.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_70.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_70.setType("radio");
          _jspx_th_impact_validateInput_70.setName(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_70.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_70.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(foodStamps)));
          _jspx_th_impact_validateInput_70.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_70.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_70 = _jspx_th_impact_validateInput_70.doStartTag();
          if (_jspx_th_impact_validateInput_70.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_71 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_71.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_71.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_71.setType("radio");
          _jspx_th_impact_validateInput_71.setName(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_71.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_71.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(foodStamps)));
          _jspx_th_impact_validateInput_71.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_71.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_71 = _jspx_th_impact_validateInput_71.doStartTag();
          if (_jspx_th_impact_validateInput_71.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_72 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_72.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_72.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_72.setType("radio");
          _jspx_th_impact_validateInput_72.setName(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_72.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_72.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(foodStamps)));
          _jspx_th_impact_validateInput_72.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_72.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_72 = _jspx_th_impact_validateInput_72.doStartTag();
          if (_jspx_th_impact_validateInput_72.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(getLabel(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td width=\"");
          out.print(width);
          out.write("\" rowspan=\"");
          out.print(rowspan);
          out.write("\"/>\r\n\t\t\t<td valign=\"top\" colspan=\"");
          out.print(colspan);
          out.write("\"><i>");
          out.print(getDescription(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, descMap));
          out.write("</i></td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\t\t\t\r\n\t\t\t<td colspan=\"");
          out.print(colspan);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_73 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_73.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_73.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_73.setType("radio");
          _jspx_th_impact_validateInput_73.setName(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_73.setLabel(PortalSurveyDetailConversation.YES);
          _jspx_th_impact_validateInput_73.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(publicHsg)));
          _jspx_th_impact_validateInput_73.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_73.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_73 = _jspx_th_impact_validateInput_73.doStartTag();
          if (_jspx_th_impact_validateInput_73.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_74 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_74.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_74.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_74.setType("radio");
          _jspx_th_impact_validateInput_74.setName(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_74.setLabel(PortalSurveyDetailConversation.NO);
          _jspx_th_impact_validateInput_74.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(publicHsg)));
          _jspx_th_impact_validateInput_74.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_74.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_74 = _jspx_th_impact_validateInput_74.doStartTag();
          if (_jspx_th_impact_validateInput_74.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_75 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_75.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_75.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_75.setType("radio");
          _jspx_th_impact_validateInput_75.setName(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_75.setLabel(PortalSurveyDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_75.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(publicHsg)));
          _jspx_th_impact_validateInput_75.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_75.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_75 = _jspx_th_impact_validateInput_75.doStartTag();
          if (_jspx_th_impact_validateInput_75.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");

		  }
		
          out.write("\r\n\t</table>\r\n\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName(PortalSurveyDetailConversation.SAVE_BUTTON_NAME);
          _jspx_th_impact_ButtonTag_0.setForm(PortalSurveyDetailConversation.FORM_NAME);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setAction("/person/PortalSurveyDetail/savePortalSurveyDetail");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n");

  }

          out.write("\t\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_76 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_76.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_76.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_76.setType("hidden");
          _jspx_th_impact_validateInput_76.setName( PortalSurveyDetailConversation.HDN_POPULATION_TYPE );
          _jspx_th_impact_validateInput_76.setValue(cdPopulationType);
          int _jspx_eval_impact_validateInput_76 = _jspx_th_impact_validateInput_76.doStartTag();
          if (_jspx_th_impact_validateInput_76.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_77 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_77.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_77.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_77.setType("hidden");
          _jspx_th_impact_validateInput_77.setName( PortalSurveyDetailConversation.HDN_FC_STATUS );
          _jspx_th_impact_validateInput_77.setValue(StringHelper.toYorN(indInCare));
          int _jspx_eval_impact_validateInput_77 = _jspx_th_impact_validateInput_77.doStartTag();
          if (_jspx_th_impact_validateInput_77.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
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
