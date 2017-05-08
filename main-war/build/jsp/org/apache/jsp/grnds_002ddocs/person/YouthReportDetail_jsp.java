package org.apache.jsp.grnds_002ddocs.person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.YouthReportDetailConversation;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class YouthReportDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  String getLabelClass(String inputName, List errorInputs) {
    if (errorInputs != null && errorInputs.contains(inputName)) {
      return YouthReportDetailConversation.HTML_ERROR_STYLE;
    } else {
      return YouthReportDetailConversation.HTML_LABEL_STYLE;
    }
  }

  String getLabel(String inputName, Map<String, String> labelMap) {
    return labelMap.get(inputName);
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
  
  //-- input/display value initialization
  String nmEnteredByName = ContextHelper.getStringSafe(request, YouthReportDetailConversation.NM_ENTERED_BY_NAME);
  String indEnteredByYth = ContextHelper.getStringSafe(request, YouthReportDetailConversation.IND_ENTERED_BY_YTH);
  Date endReportPeriod = ContextHelper.getJavaDateSafe(request, YouthReportDetailConversation.DT_END_REPORT_PERIOD_NAME);
  Date dob = ContextHelper.getJavaDateSafe(request, YouthReportDetailConversation.DT_DOB_NAME);
  String ageClass = ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_AGE_CLASS_NAME);
  String sex = ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_SEX_NAME);
  List<String> races = Arrays.asList(CheckboxHelper.getCheckedValues(request, YouthReportDetailConversation.CBG_RACE_NAME));
  String ethnicity = ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_ETHNICITY_NAME);
  String tribal = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_TRIBAL_NAME);
  String fcStatusSvcs = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME);
  String adjDelinquent = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_ADJ_DEL_NAME);
  String lastGradeComp = ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME);
  String spcEdStat = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME);
  String ilNeedsAsm = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME);
  String academicSupp = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME);
  String postSecondary = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME);
  String careerPrep = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_CAREER_PREP_NAME);
  String empProgVoc = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME);
  String budgetMgt = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME);
  String homeMgt = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_HOME_MGT_NAME);
  String healthEdRP = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME);
  String famMarrEd = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME);
  String mentoring = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MENTORING_NAME);
  String superIL = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_SUPER_IL_NAME);
  String roomBoard = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_ROOM_BRD_NAME);
  String edFinAsst = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME);
  String otherFin = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_OTHER_FIN_NAME);
  String outcomeStatus = ContextHelper.getStringSafe(request, YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME);
  Date outcomeDate = ContextHelper.getJavaDateSafe(request, YouthReportDetailConversation.DT_OUTCOME_NAME);
  String fcStatus = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_FC_STATUS_NAME);
  String currFTE = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_CURR_FTE_NAME);
  String currPTE = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_CURR_PTE_NAME);
  String empRelSkills = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME);
  String socialSecurity = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_SS_NAME);
  String eduAid = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_EDU_AID_NAME);
  String tanf = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_TANF_NAME);
  String foodStamps = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_FOOD_STMP_NAME);
  String publicHsg = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_PUB_HSG_NAME);
  String otherIncome = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_OTH_INC_NAME);
  String highEdu = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_HECR_NAME);
  String currAttdEnr = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_CAE_NAME);
  String connectAdult = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_C2A_NAME);
  String medicaid = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MED_NAME);
  String otherHIT = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_OHIT_NAME);
  String medical = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MEDICAL_NAME);
  String mental = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MENTAL_NAME);
  String prescription = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
  String homeless = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_HOME_NAME);
  String subAbuseRef = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_SAR_NAME);
  String incarcerate = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_INC_NAME);
  String children = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_CHL_NAME);
  String marrAtBirth = ContextHelper.getStringSafe(request, YouthReportDetailConversation.RADIO_MAB_NAME);
  String cdPopulationType = ContextHelper.getStringSafe(request, YouthReportDetailConversation.HDN_CD_POPULATION_TYPE);
    
  //-- get attributes from state
  BaseSessionStateManager state = YouthReportDetailConversation.getSessionStateManager(request);
  YouthReportDetailRetrieveSOPerson soPerson = (YouthReportDetailRetrieveSOPerson) state.getAttribute(YouthReportDetailConversation.RETRIEVE_SO_PERSON, request);
  YouthReportDetailRetrieveSOReport soReport = (YouthReportDetailRetrieveSOReport) state.getAttribute(YouthReportDetailConversation.RETRIEVE_SO_REPORT, request);
  Date dtRptPeriodEnd = (Date) state.getAttribute(YouthReportDetailConversation.RETRIEVE_DT_RPT_PERIOD_END, request);
  
  Map<String, String> labelMap = new HashMap<String, String>() {
    {
      // -- required fields
      put(YouthReportDetailConversation.DT_DOB_NAME, YouthReportDetailConversation.LABEL_DOB);
      put(YouthReportDetailConversation.SEL_SEX_NAME, YouthReportDetailConversation.LABEL_SEX);
      put(YouthReportDetailConversation.CBG_RACE_NAME, YouthReportDetailConversation.LABEL_RACE);
      put(YouthReportDetailConversation.SEL_ETHNICITY_NAME, YouthReportDetailConversation.LABEL_ETHNICITY);
      put(YouthReportDetailConversation.RADIO_TRIBAL_NAME, YouthReportDetailConversation.LABEL_TRIBAL_MBR);
      put(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, YouthReportDetailConversation.LABEL_ADJ_DEL);
      put(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, YouthReportDetailConversation.LABEL_LAST_GRD_COMP);
      put(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, YouthReportDetailConversation.LABEL_SPC_ED_STAT);
      put(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, YouthReportDetailConversation.LABEL_IL_NEEDS_ASM);
      put(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, YouthReportDetailConversation.LABEL_ACAD_SUPP);
      put(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, YouthReportDetailConversation.LABEL_PS_EDU_SUPP);
      put(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, YouthReportDetailConversation.LABEL_CAREER_PREP);
      put(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, YouthReportDetailConversation.LABEL_EMP_PROG_VOC);
      put(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, YouthReportDetailConversation.LABEL_BGT_FIN_MGT);
      put(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, YouthReportDetailConversation.LABEL_HOME_MGT);
      put(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, YouthReportDetailConversation.LABEL_HLTH_ED_RP);
      put(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, YouthReportDetailConversation.LABEL_FAM_MARR_ED);
      put(YouthReportDetailConversation.RADIO_MENTORING_NAME, YouthReportDetailConversation.LABEL_MENTORING);
      put(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, YouthReportDetailConversation.LABEL_SUPER_IL);
      put(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, YouthReportDetailConversation.LABEL_ROOM_BRD);
      put(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, YouthReportDetailConversation.LABEL_ED_FIN_ASST);
      put(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, YouthReportDetailConversation.LABEL_OTHER_FIN);
      put(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME, YouthReportDetailConversation.LABEL_FC_ST_SVCS);

      // -- condRequired fields
      put(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, YouthReportDetailConversation.LABEL_OUTCOME_STAT);
      put(YouthReportDetailConversation.DT_OUTCOME_NAME, YouthReportDetailConversation.LABEL_DT_OUTCOME);
      put(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, YouthReportDetailConversation.LABEL_FC_STATUS);
      // -- fields
      put(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, YouthReportDetailConversation.LABEL_CURR_FTE);
      put(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, YouthReportDetailConversation.LABEL_CURR_PTE);
      put(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, YouthReportDetailConversation.LABEL_EMP_SKILLS);
      put(YouthReportDetailConversation.RADIO_SS_NAME, YouthReportDetailConversation.LABEL_SS);
      put(YouthReportDetailConversation.RADIO_EDU_AID_NAME, YouthReportDetailConversation.LABEL_EDU_AID);
      put(YouthReportDetailConversation.RADIO_OTH_INC_NAME, YouthReportDetailConversation.LABEL_OTH_INC);
      put(YouthReportDetailConversation.RADIO_HECR_NAME, YouthReportDetailConversation.LABEL_HECR);
      put(YouthReportDetailConversation.RADIO_CAE_NAME, YouthReportDetailConversation.LABEL_CAE);
      put(YouthReportDetailConversation.RADIO_C2A_NAME, YouthReportDetailConversation.LABEL_C2A);

      put(YouthReportDetailConversation.RADIO_HOME_NAME, YouthReportDetailConversation.LABEL_HOME_B);
      put(YouthReportDetailConversation.RADIO_SAR_NAME, YouthReportDetailConversation.LABEL_SAR_B);
      put(YouthReportDetailConversation.RADIO_INC_NAME, YouthReportDetailConversation.LABEL_INC_B);
      put(YouthReportDetailConversation.RADIO_CHL_NAME, YouthReportDetailConversation.LABEL_CHL_B);

      put(YouthReportDetailConversation.RADIO_MAB_NAME, YouthReportDetailConversation.LABEL_MAB);
      put(YouthReportDetailConversation.RADIO_MED_NAME, YouthReportDetailConversation.LABEL_MEDICAID);
      put(YouthReportDetailConversation.RADIO_OHIT_NAME, YouthReportDetailConversation.LABEL_OHIT);
      put(YouthReportDetailConversation.RADIO_MEDICAL_NAME, YouthReportDetailConversation.LABEL_MEDICAL);
      put(YouthReportDetailConversation.RADIO_MENTAL_NAME, YouthReportDetailConversation.LABEL_MENTAL);
      put(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, YouthReportDetailConversation.LABEL_PRESCRIPTION);

      put(YouthReportDetailConversation.RADIO_TANF_NAME, YouthReportDetailConversation.LABEL_TANF);
      put(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, YouthReportDetailConversation.LABEL_FOOD_STMP);
      put(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, YouthReportDetailConversation.LABEL_PUB_HSG);
    }
  };

  // Comments for for support/training section
  String txtAcadSupport = "";
  String txtPsEduSupport = "";
  String txtCareerPrep = "";
  String txtBdgtFinMgt = "";
  String txtHealthEdu = "";
  String txtMentoring = "";
  String txtRmBrdFin = "";
  String txtOthFinance = "";
  String txtEmpProgVoc = "";
  String txtHousingEdu = "";
  String txtFamMarrEdu = "";
  String txtSuperIl = "";
  String txtEduFinance = "";
  
  boolean isBaseline = false;
  boolean isFollowUp = false;
     
  if(soReport != null) {  
    nmEnteredByName = StringHelper.getNonNullString(soReport.getNmEnteredByName());
    indEnteredByYth = soReport.getIndEnteredByYth();
    endReportPeriod = soReport.getDtRptPeriodEnd();

    dob = soReport.getDtDob();
    ageClass = soReport.getCdAgeClass();
    sex = soReport.getCdSex();
    races = soReport.getRaces();
    ethnicity = soReport.getCdEthinicity();
    tribal = soReport.getIndTribalMbr();
    adjDelinquent = soReport.getIndAdjDelinquent();
    spcEdStat = soReport.getIndSpecEdu();
    fcStatusSvcs = soReport.getIndFcStatSvcs();
    lastGradeComp = soReport.getCdLastGradeComp();
    ilNeedsAsm = soReport.getIndIlNeedsAsm();
    
    academicSupp = soReport.getIndAcadSupport();
    postSecondary = soReport.getIndPsEduSupport();
    careerPrep = soReport.getIndCareerPrep();
    empProgVoc = soReport.getIndEmpProgVoc();
    budgetMgt = soReport.getIndBdgtFinMgt();
    homeMgt = soReport.getIndHousingEdu();
    healthEdRP = soReport.getIndHealthEdu();
    famMarrEd = soReport.getIndFamMarrEdu();
    mentoring = soReport.getIndMentoring();
    superIL = soReport.getIndSuperIl();
    roomBoard = soReport.getIndRoomBrdFin();
    edFinAsst = soReport.getIndEduFinance();
    otherFin = soReport.getIndOthFinance();
    
    outcomeStatus = soReport.getCdOutcomeRptStat();
    outcomeDate = soReport.getDtOutcomeDate();
    fcStatus = soReport.getIndFcStatOutcome();
    
    currFTE = soReport.getCdCurrFtEmp();
    currPTE = soReport.getCdCurrPtEmp();
    empRelSkills = soReport.getCdEmpSkills();
    eduAid = soReport.getCdEducAid();
    publicHsg = soReport.getCdHousingAst();
    otherIncome = soReport.getCdOthSupport();
    connectAdult = soReport.getCdConnAdult();
    medicaid = soReport.getCdMedicaid();
    otherHIT = soReport.getCdOthHlthInsTyp();
    medical = soReport.getCdMedicalSvc();
    mental = soReport.getCdMentalHlthSvc();
    prescription = soReport.getCdPrescription();
    homeless = soReport.getCdHomeless();
    subAbuseRef = soReport.getCdSubAbuseRef();
    incarcerate = soReport.getCdIncarceration();
    children = soReport.getCdChildren();
    marrAtBirth = soReport.getCdMarrAtBirth();
    
    socialSecurity = soReport.getCdSocialSec();
    tanf = soReport.getCdPubFinAst();
    foodStamps = soReport.getCdFoodAst();
    highEdu = soReport.getCdHighestEdu();
    currAttdEnr = soReport.getCdCurrEnrAtt();    

    // Comments
    txtAcadSupport = StringHelper.getNonNullString(soReport.getTxtAcadSupport());
    txtPsEduSupport = StringHelper.getNonNullString(soReport.getTxtPsEduSupport());
    txtCareerPrep = StringHelper.getNonNullString(soReport.getTxtCareerPrep());
    txtBdgtFinMgt = StringHelper.getNonNullString(soReport.getTxtBdgtFinMgt());
    txtHealthEdu = StringHelper.getNonNullString(soReport.getTxtHealthEdu());
    txtMentoring = StringHelper.getNonNullString(soReport.getTxtMentoring());
    txtRmBrdFin = StringHelper.getNonNullString(soReport.getTxtRmBrdFin());
    txtOthFinance = StringHelper.getNonNullString(soReport.getTxtOthFinance());
    txtEmpProgVoc = StringHelper.getNonNullString(soReport.getTxtEmpProgVoc());
    txtHousingEdu = StringHelper.getNonNullString(soReport.getTxtHousingEdu());
    txtFamMarrEdu = StringHelper.getNonNullString(soReport.getTxtFamMarrEdu());
    txtSuperIl = StringHelper.getNonNullString(soReport.getTxtSuperIl());
    txtEduFinance = StringHelper.getNonNullString(soReport.getTxtEduFinance());

    cdPopulationType = soReport.getCdPopulationType();
  }
  
  //-- soPerson should never be null!
  if(soPerson != null) {
    // if youth is active in a case and if retreived report is for current period, then update youth general info with current data
    // from soPerson
    if(CodesTables.CPERSTAT_A.equals(soPerson.getCdPersonActiveStatus())
          && soReport.getDtRptPeriodEnd().compareTo(NytdHelper.getDtRptPeriodEnd()) == 0){
	    dob = soPerson.getDtDob();
	    ageClass = soPerson.getCdAgeClass();
	    sex = soPerson.getCdSex();
	    races = soPerson.getRaces();
	    ethnicity = soPerson.getCdEthinicity();
	    tribal = soPerson.getIndTribalMbr();
	    adjDelinquent = soPerson.getIndAdjDelinquent();
	    spcEdStat = soPerson.getIndSpcEduStat();
	    fcStatusSvcs = soPerson.getIndFcStatSvcs();
	    // last grade comp is only populated on initial display and soReport should handle that
	    // otherwise do no populate last grade comp again for existing record
	    // lastGradeComp = soPerson.getCdLastGradeComp();
	    fcStatus = soPerson.getIndFcStatOutcome();
	    cdPopulationType = soPerson.getCdPopulationType();
    }else if(CodesTables.CPERSTAT_I.equals(soPerson.getCdPersonActiveStatus())
                    && soReport.getDtRptPeriodEnd().compareTo(NytdHelper.getDtRptPeriodEnd()) == 0){
      // if youth is inactive and report displayed is for current reporting period then set non-input data
      ageClass = soPerson.getCdAgeClass();
      cdPopulationType = soPerson.getCdPopulationType();      
    }
  }
    
  if (YouthReportDetailConversation.POPULATION_TYPE_BASELINE.equals(cdPopulationType)) {
     isBaseline = true;
     labelMap.put(YouthReportDetailConversation.RADIO_HOME_NAME, YouthReportDetailConversation.LABEL_HOME_B);
     labelMap.put(YouthReportDetailConversation.RADIO_SAR_NAME, YouthReportDetailConversation.LABEL_SAR_B);
     labelMap.put(YouthReportDetailConversation.RADIO_INC_NAME, YouthReportDetailConversation.LABEL_INC_B);
     labelMap.put(YouthReportDetailConversation.RADIO_CHL_NAME, YouthReportDetailConversation.LABEL_CHL_B);
   } else if (YouthReportDetailConversation.POPULATION_TYPE_FOLLOW_UP.equals(cdPopulationType)) {
     isFollowUp = true;
     labelMap.put(YouthReportDetailConversation.RADIO_HOME_NAME, YouthReportDetailConversation.LABEL_HOME_F);
     labelMap.put(YouthReportDetailConversation.RADIO_SAR_NAME, YouthReportDetailConversation.LABEL_SAR_F);
     labelMap.put(YouthReportDetailConversation.RADIO_INC_NAME, YouthReportDetailConversation.LABEL_INC_F);
     labelMap.put(YouthReportDetailConversation.RADIO_CHL_NAME, YouthReportDetailConversation.LABEL_CHL_F);
   }
  
  if(endReportPeriod == null) {
    endReportPeriod = dtRptPeriodEnd;
  }
  
  Boolean editPersonFields = (Boolean) state.getAttribute(YouthReportDetailConversation.EDIT_PERSON_FIELDS, request);
  editPersonFields = editPersonFields == null ? Boolean.FALSE : editPersonFields;
  boolean disablePersonFields = !editPersonFields;
  boolean isDuringSurveyPeriod = NytdHelper.isDuringSurveyPeriod(dob);
  
  int tabIndex = 1;
  int outerColspan = 4;
  int row = 1;
  
  int suppOuterColspan = 8;
  int outcomeOuterColspan = 2;

      out.write("\r\n\r\n<script type=\"text/javascript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  window.onload = function()\r\n  {\r\n    onRadioChanged();\r\n  };\r\n\r\n  window.onbeforeunload = function() {\r\n    IsDirty();\r\n  };\r\n  \r\n  //-- this function is called when custom error messages are displayed for radio buttons\r\n  function focusOn(elmName) {\r\n    elmsByName = document.getElementsByName(elmName);\r\n    elm = elmsByName[0];\r\n    try {\r\n      elm.focus();\r\n    } catch(e) {}\r\n  }\r\n\r\n  function onRadioChanged(){\r\n    if(getRadioCheckedValue('");
      out.print(YouthReportDetailConversation.RADIO_CHL_NAME);
      out.write("') == '");
      out.print( CodesTables.CINVACAN_Y);
      out.write("'){\r\n      // Disable question 14 N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_MAB_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].checked = false;\r\n            e[i].disabled = true;\r\n        }\r\n      }\r\n    }else{\r\n      // Enable question 14 N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_MAB_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].disabled = false;\r\n        }\r\n      }\r\n    }\r\n    \r\n    if(getRadioCheckedValue('");
      out.print(YouthReportDetailConversation.RADIO_OHIT_NAME);
      out.write("') == '");
      out.print( CodesTables.CINVACAN_Y);
      out.write("'){\r\n      // Disable question 16a N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].checked = false;\r\n            e[i].disabled = true;\r\n        }\r\n      }\r\n    }else{\r\n      // Enable question 16a N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].disabled = false;\r\n        }\r\n      }\r\n    }\r\n    \r\n    if(getRadioCheckedValue('");
      out.print(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
      out.write("') == '");
      out.print( CodesTables.CINVACAN_Y);
      out.write("'){\r\n      // Disable question 16b N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_MENTAL_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].checked = false;\r\n            e[i].disabled = true;\r\n        }\r\n      }\r\n      // Disable question 16c N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].checked = false;\r\n            e[i].disabled = true;\r\n        }\r\n      }\r\n    }else{\r\n      // Enable question 16b N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_MENTAL_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].disabled = false;\r\n        }\r\n      }\r\n      // Enable question 16c N/A\r\n      var e = document.getElementsByName('");
      out.print(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
      out.write("');\r\n      for( var i = 0; i < e.length; i++ ){\r\n        if( e[i].value == '");
      out.print( CodesTables.CINVACAN_A);
      out.write("'){\r\n            e[i].disabled = false;\r\n        }\r\n      }\r\n    }\r\n  }\r\n  \r\n  function getRadioCheckedValue( radioName ){\r\n    var oRadio = document.");
      out.print(YouthReportDetailConversation.FORM_NAME);
      out.write(".elements[radioName];\r\n  \r\n    for( var i = 0; i < oRadio.length; i++){\r\n      if(oRadio[i].checked){\r\n        return oRadio[i].value;\r\n      }\r\n      \r\n      return '';\r\n    }\r\n  }\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

  List errorInputs = (List) state.getAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_INPUTS, request);
  if(errorInputs != null && !errorInputs.isEmpty()) {
    String customErrorHTML = (String) state.getAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_HTML, request);
    out.print(customErrorHTML);
  }

      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName( YouthReportDetailConversation.FORM_NAME );
      _jspx_th_impact_validateForm_0.setAction("/person/YouthReportDetail/displayReportDetail");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.person.YouthReportDetailCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(PageMode.getPageMode(request));
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\tborder=\"0\">\r\n\r\n\t\t");
          out.write("\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\tGeneral Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"30%\" />\r\n\t\t\t<td width=\"25%\" />\r\n\t\t\t<td width=\"20%\" />\r\n\t\t\t<td width=\"25%\" />\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName(YouthReportDetailConversation.DT_END_REPORT_PERIOD_NAME);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("End of Reporting Period");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan(String.valueOf(outerColspan - 1));
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatDate(endReportPeriod));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n            <td valign=\"top\">\r\n                <div\r\n                    class=\"");
          out.print(getLabelClass(YouthReportDetailConversation.DT_DOB_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.DT_DOB_NAME, labelMap));
          out.write(":\r\n                </div>\r\n            </td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setName(YouthReportDetailConversation.DT_DOB_NAME);
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          _jspx_th_impact_validateDate_0.setDisabled(String.valueOf(disablePersonFields));
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(dob));
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\tAge Class:\r\n\t\t\t\t");
          out.print( Lookup.simpleDecodeSafe( "CAGECLSS" , ageClass) );
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.SEL_SEX_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.SEL_SEX_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(String.valueOf(outerColspan - 1));
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setName(YouthReportDetailConversation.SEL_SEX_NAME);
          _jspx_th_impact_validateSelect_0.setBlankValue("true");
          _jspx_th_impact_validateSelect_0.setDisabled(String.valueOf(disablePersonFields));
          _jspx_th_impact_validateSelect_0.setCodesTable(CodesTables.CSEX);
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setValue(sex);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.CBG_RACE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.CBG_RACE_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 2);
          out.write("\">\r\n\t\t\t\t");
          //  impact:codesCheckbox
          gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag _jspx_th_impact_codesCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CodesCheckboxesTag();
          _jspx_th_impact_codesCheckbox_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_codesCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_codesCheckbox_0.setName(YouthReportDetailConversation.CBG_RACE_NAME);
          _jspx_th_impact_codesCheckbox_0.setColumns(2);
          _jspx_th_impact_codesCheckbox_0.setIsHorizontal(true);
          _jspx_th_impact_codesCheckbox_0.setDisabled(String.valueOf(disablePersonFields));
          _jspx_th_impact_codesCheckbox_0.setCodesTableName(CodesTables.CRACE);
          _jspx_th_impact_codesCheckbox_0.setTabIndex(tabIndex++);
          _jspx_th_impact_codesCheckbox_0.setDefaultCodes(races);
          int _jspx_eval_impact_codesCheckbox_0 = _jspx_th_impact_codesCheckbox_0.doStartTag();
          if (_jspx_th_impact_codesCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"top\">\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n            <td>\r\n                <div\r\n                    class=\"");
          out.print(getLabelClass(YouthReportDetailConversation.SEL_ETHNICITY_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.SEL_ETHNICITY_NAME, labelMap));
          out.write(":\r\n                </div>\r\n            </td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setName(YouthReportDetailConversation.SEL_ETHNICITY_NAME);
          _jspx_th_impact_validateSelect_1.setBlankValue("true");
          _jspx_th_impact_validateSelect_1.setDisabled(String.valueOf(disablePersonFields));
          _jspx_th_impact_validateSelect_1.setCodesTable(CodesTables.CINDETHN);
          _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_1.setValue(ethnicity);
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_TRIBAL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_TRIBAL_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("radio");
          _jspx_th_impact_validateInput_0.setName(YouthReportDetailConversation.RADIO_TRIBAL_NAME);
          _jspx_th_impact_validateInput_0.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_0.setChecked(String.valueOf(ArchitectureConstants.Y.equals(tribal)));
          _jspx_th_impact_validateInput_0.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_0.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("radio");
          _jspx_th_impact_validateInput_1.setName(YouthReportDetailConversation.RADIO_TRIBAL_NAME);
          _jspx_th_impact_validateInput_1.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_1.setChecked(String.valueOf(ArchitectureConstants.N.equals(tribal)));
          _jspx_th_impact_validateInput_1.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_1.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setName(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME);
          _jspx_th_impact_validateInput_2.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_2.setChecked(String.valueOf(ArchitectureConstants.Y.equals(fcStatusSvcs)));
          _jspx_th_impact_validateInput_2.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME);
          _jspx_th_impact_validateInput_3.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_3.setChecked(String.valueOf(ArchitectureConstants.N.equals(fcStatusSvcs)));
          _jspx_th_impact_validateInput_3.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setName(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME);
          _jspx_th_impact_validateInput_4.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_4.setChecked(String.valueOf(ArchitectureConstants.Y.equals(adjDelinquent)));
          _jspx_th_impact_validateInput_4.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_4.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setName(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME);
          _jspx_th_impact_validateInput_5.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_5.setChecked(String.valueOf(ArchitectureConstants.N.equals(adjDelinquent)));
          _jspx_th_impact_validateInput_5.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_5.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n            <td>\r\n                <div\r\n                    class=\"");
          out.print(getLabelClass(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, labelMap));
          out.write(":\r\n                </div>\r\n            </td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setName(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME);
          _jspx_th_impact_validateSelect_2.setBlankValue("true");
          _jspx_th_impact_validateSelect_2.setCodesTable(CodesTables.CEDUCOMP);
          _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_2.setValue(lastGradeComp);
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setName(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME);
          _jspx_th_impact_validateInput_6.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_6.setChecked(String.valueOf(ArchitectureConstants.Y.equals(spcEdStat)));
          _jspx_th_impact_validateInput_6.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_6.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setName(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME);
          _jspx_th_impact_validateInput_7.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_7.setChecked(String.valueOf(ArchitectureConstants.N.equals(spcEdStat)));
          _jspx_th_impact_validateInput_7.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_7.setDisabled(String.valueOf(disablePersonFields));
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setName(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME);
          _jspx_th_impact_validateInput_8.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_8.setChecked(String.valueOf(ArchitectureConstants.Y.equals(ilNeedsAsm)));
          _jspx_th_impact_validateInput_8.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setName(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME);
          _jspx_th_impact_validateInput_9.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_9.setChecked(String.valueOf(ArchitectureConstants.N.equals(ilNeedsAsm)));
          _jspx_th_impact_validateInput_9.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\tborder=\"0\">\r\n\r\n\t\t");
          out.write("\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"");
          out.print(suppOuterColspan);
          out.write("\">\r\n\t\t\t\tSupport/Training Provided Within Reporting Period:\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setName(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME);
          _jspx_th_impact_validateInput_10.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_10.setChecked(String.valueOf(ArchitectureConstants.Y.equals(academicSupp)));
          _jspx_th_impact_validateInput_10.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_11.setName(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME);
          _jspx_th_impact_validateInput_11.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_11.setChecked(String.valueOf(ArchitectureConstants.N.equals(academicSupp)));
          _jspx_th_impact_validateInput_11.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName(YouthReportDetailConversation.TEXT_ACAD_SUPP_COMM);
          _jspx_th_impact_validateTextArea_0.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_0.setColspan("2");
          _jspx_th_impact_validateTextArea_0.setRows("2");
          _jspx_th_impact_validateTextArea_0.setCols("50");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtAcadSupport);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setName(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME);
          _jspx_th_impact_validateInput_12.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_12.setChecked(String.valueOf(ArchitectureConstants.Y.equals(postSecondary)));
          _jspx_th_impact_validateInput_12.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_13.setName(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME);
          _jspx_th_impact_validateInput_13.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_13.setChecked(String.valueOf(ArchitectureConstants.N.equals(postSecondary)));
          _jspx_th_impact_validateInput_13.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName(YouthReportDetailConversation.TEXT_PS_EDU_SUPP_COMM);
          _jspx_th_impact_validateTextArea_1.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_1.setColspan("2");
          _jspx_th_impact_validateTextArea_1.setRows("2");
          _jspx_th_impact_validateTextArea_1.setCols("50");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtPsEduSupport);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setName(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME);
          _jspx_th_impact_validateInput_14.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_14.setChecked(String.valueOf(ArchitectureConstants.Y.equals(careerPrep)));
          _jspx_th_impact_validateInput_14.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setName(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME);
          _jspx_th_impact_validateInput_15.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_15.setChecked(String.valueOf(ArchitectureConstants.N.equals(careerPrep)));
          _jspx_th_impact_validateInput_15.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName(YouthReportDetailConversation.TEXT_CAREER_PREP_COMM);
          _jspx_th_impact_validateTextArea_2.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_2.setColspan("2");
          _jspx_th_impact_validateTextArea_2.setRows("2");
          _jspx_th_impact_validateTextArea_2.setCols("50");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtCareerPrep);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setName(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME);
          _jspx_th_impact_validateInput_16.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_16.setChecked(String.valueOf(ArchitectureConstants.Y.equals(empProgVoc)));
          _jspx_th_impact_validateInput_16.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_17.setName(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME);
          _jspx_th_impact_validateInput_17.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_17.setChecked(String.valueOf(ArchitectureConstants.N.equals(empProgVoc)));
          _jspx_th_impact_validateInput_17.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName(YouthReportDetailConversation.TEXT_EMP_PROG_VOC_COMM);
          _jspx_th_impact_validateTextArea_3.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_3.setColspan("2");
          _jspx_th_impact_validateTextArea_3.setRows("2");
          _jspx_th_impact_validateTextArea_3.setCols("50");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtEmpProgVoc);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("radio");
          _jspx_th_impact_validateInput_18.setName(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME);
          _jspx_th_impact_validateInput_18.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_18.setChecked(String.valueOf(ArchitectureConstants.Y.equals(budgetMgt)));
          _jspx_th_impact_validateInput_18.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("radio");
          _jspx_th_impact_validateInput_19.setName(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME);
          _jspx_th_impact_validateInput_19.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_19.setChecked(String.valueOf(ArchitectureConstants.N.equals(budgetMgt)));
          _jspx_th_impact_validateInput_19.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName(YouthReportDetailConversation.TEXT_BGT_FIN_MGT_COMM);
          _jspx_th_impact_validateTextArea_4.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_4.setColspan("2");
          _jspx_th_impact_validateTextArea_4.setRows("2");
          _jspx_th_impact_validateTextArea_4.setCols("50");
          _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_4.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtBdgtFinMgt);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("radio");
          _jspx_th_impact_validateInput_20.setName(YouthReportDetailConversation.RADIO_HOME_MGT_NAME);
          _jspx_th_impact_validateInput_20.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_20.setChecked(String.valueOf(ArchitectureConstants.Y.equals(homeMgt)));
          _jspx_th_impact_validateInput_20.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("radio");
          _jspx_th_impact_validateInput_21.setName(YouthReportDetailConversation.RADIO_HOME_MGT_NAME);
          _jspx_th_impact_validateInput_21.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_21.setChecked(String.valueOf(ArchitectureConstants.N.equals(homeMgt)));
          _jspx_th_impact_validateInput_21.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setName(YouthReportDetailConversation.TEXT_HOME_MGT_COMM);
          _jspx_th_impact_validateTextArea_5.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_5.setColspan("2");
          _jspx_th_impact_validateTextArea_5.setRows("2");
          _jspx_th_impact_validateTextArea_5.setCols("50");
          _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_5.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtHousingEdu);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("radio");
          _jspx_th_impact_validateInput_22.setName(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME);
          _jspx_th_impact_validateInput_22.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_22.setChecked(String.valueOf(ArchitectureConstants.Y.equals(healthEdRP)));
          _jspx_th_impact_validateInput_22.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("radio");
          _jspx_th_impact_validateInput_23.setName(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME);
          _jspx_th_impact_validateInput_23.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_23.setChecked(String.valueOf(ArchitectureConstants.N.equals(healthEdRP)));
          _jspx_th_impact_validateInput_23.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_6.setName(YouthReportDetailConversation.TEXT_HLTH_ED_RP_COMM);
          _jspx_th_impact_validateTextArea_6.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_6.setColspan("2");
          _jspx_th_impact_validateTextArea_6.setRows("2");
          _jspx_th_impact_validateTextArea_6.setCols("50");
          _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_6.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
          if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_6.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtHealthEdu);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("radio");
          _jspx_th_impact_validateInput_24.setName(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME);
          _jspx_th_impact_validateInput_24.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_24.setChecked(String.valueOf(ArchitectureConstants.Y.equals(famMarrEd)));
          _jspx_th_impact_validateInput_24.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("radio");
          _jspx_th_impact_validateInput_25.setName(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME);
          _jspx_th_impact_validateInput_25.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_25.setChecked(String.valueOf(ArchitectureConstants.N.equals(famMarrEd)));
          _jspx_th_impact_validateInput_25.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_7.setName(YouthReportDetailConversation.TEXT_FAM_MARR_ED_COMM);
          _jspx_th_impact_validateTextArea_7.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_7.setColspan("2");
          _jspx_th_impact_validateTextArea_7.setRows("2");
          _jspx_th_impact_validateTextArea_7.setCols("50");
          _jspx_th_impact_validateTextArea_7.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_7.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
          if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_7.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtFamMarrEdu);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_MENTORING_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_MENTORING_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setName(YouthReportDetailConversation.RADIO_MENTORING_NAME);
          _jspx_th_impact_validateInput_26.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_26.setChecked(String.valueOf(ArchitectureConstants.Y.equals(mentoring)));
          _jspx_th_impact_validateInput_26.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_27.setName(YouthReportDetailConversation.RADIO_MENTORING_NAME);
          _jspx_th_impact_validateInput_27.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_27.setChecked(String.valueOf(ArchitectureConstants.N.equals(mentoring)));
          _jspx_th_impact_validateInput_27.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_8.setName(YouthReportDetailConversation.TEXT_MENTORING_COMM);
          _jspx_th_impact_validateTextArea_8.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_8.setColspan("2");
          _jspx_th_impact_validateTextArea_8.setRows("2");
          _jspx_th_impact_validateTextArea_8.setCols("50");
          _jspx_th_impact_validateTextArea_8.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_8.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_8 = _jspx_th_impact_validateTextArea_8.doStartTag();
          if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_8.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtMentoring);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_8.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setName(YouthReportDetailConversation.RADIO_SUPER_IL_NAME);
          _jspx_th_impact_validateInput_28.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_28.setChecked(String.valueOf(ArchitectureConstants.Y.equals(superIL)));
          _jspx_th_impact_validateInput_28.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setType("radio");
          _jspx_th_impact_validateInput_29.setName(YouthReportDetailConversation.RADIO_SUPER_IL_NAME);
          _jspx_th_impact_validateInput_29.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_29.setChecked(String.valueOf(ArchitectureConstants.N.equals(superIL)));
          _jspx_th_impact_validateInput_29.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_9.setName(YouthReportDetailConversation.TEXT_SUPER_IL_COMM);
          _jspx_th_impact_validateTextArea_9.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_9.setColspan("2");
          _jspx_th_impact_validateTextArea_9.setRows("2");
          _jspx_th_impact_validateTextArea_9.setCols("50");
          _jspx_th_impact_validateTextArea_9.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_9.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_9 = _jspx_th_impact_validateTextArea_9.doStartTag();
          if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_9.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtSuperIl);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_9.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("radio");
          _jspx_th_impact_validateInput_30.setName(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME);
          _jspx_th_impact_validateInput_30.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_30.setChecked(String.valueOf(ArchitectureConstants.Y.equals(roomBoard)));
          _jspx_th_impact_validateInput_30.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_31.setName(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME);
          _jspx_th_impact_validateInput_31.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_31.setChecked(String.valueOf(ArchitectureConstants.N.equals(roomBoard)));
          _jspx_th_impact_validateInput_31.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_10.setName(YouthReportDetailConversation.TEXT_ROOM_BRD_COMM);
          _jspx_th_impact_validateTextArea_10.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_10.setColspan("2");
          _jspx_th_impact_validateTextArea_10.setRows("2");
          _jspx_th_impact_validateTextArea_10.setCols("50");
          _jspx_th_impact_validateTextArea_10.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_10.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_10 = _jspx_th_impact_validateTextArea_10.doStartTag();
          if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_10.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtRmBrdFin);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_10.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setName(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME);
          _jspx_th_impact_validateInput_32.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_32.setChecked(String.valueOf(ArchitectureConstants.Y.equals(edFinAsst)));
          _jspx_th_impact_validateInput_32.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_33.setName(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME);
          _jspx_th_impact_validateInput_33.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_33.setChecked(String.valueOf(ArchitectureConstants.N.equals(edFinAsst)));
          _jspx_th_impact_validateInput_33.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_11.setName(YouthReportDetailConversation.TEXT_ED_FIN_ASST_COMM);
          _jspx_th_impact_validateTextArea_11.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_11.setColspan("2");
          _jspx_th_impact_validateTextArea_11.setRows("2");
          _jspx_th_impact_validateTextArea_11.setCols("50");
          _jspx_th_impact_validateTextArea_11.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_11.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_11 = _jspx_th_impact_validateTextArea_11.doStartTag();
          if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_11.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtEduFinance);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_11.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"");
          out.print(outerColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setType("radio");
          _jspx_th_impact_validateInput_34.setName(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME);
          _jspx_th_impact_validateInput_34.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_34.setChecked(String.valueOf(ArchitectureConstants.Y.equals(otherFin)));
          _jspx_th_impact_validateInput_34.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("radio");
          _jspx_th_impact_validateInput_35.setName(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME);
          _jspx_th_impact_validateInput_35.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_35.setChecked(String.valueOf(ArchitectureConstants.N.equals(otherFin)));
          _jspx_th_impact_validateInput_35.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td valign=\"middle\">\r\n\t\t\t\t<!--- Text Area Custom Tag --->\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_12.setName(YouthReportDetailConversation.TEXT_OTHER_FIN_COMM);
          _jspx_th_impact_validateTextArea_12.setLabel(YouthReportDetailConversation.COMMENTS);
          _jspx_th_impact_validateTextArea_12.setColspan("2");
          _jspx_th_impact_validateTextArea_12.setRows("2");
          _jspx_th_impact_validateTextArea_12.setCols("50");
          _jspx_th_impact_validateTextArea_12.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_12.setConstraint("Comments");
          int _jspx_eval_impact_validateTextArea_12 = _jspx_th_impact_validateTextArea_12.doStartTag();
          if (_jspx_eval_impact_validateTextArea_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_12.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_12.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(txtOthFinance);
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_12.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
 if (isBaseline || isFollowUp) { 
          out.write("\r\n\t<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\tborder=\"0\">\r\n\r\n\t\t");
          out.write("\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\tThe following survey questions needs to be answered by the Youth.\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"");
          out.print(outerColspan);
          out.write("\">\r\n\t\t\t\tOutcome Reporting\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"30%\">\r\n\t\t\t\tEntered By:\r\n\t\t\t</td>\r\n\t\t\t<td width=\"25%\">");
          out.print( nmEnteredByName );
          out.write("</td>\r\n\t\t\t<td width=\"20%\"></td>\r\n\t\t\t<td width=\"25%\"></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setName(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME);
          _jspx_th_impact_validateSelect_3.setBlankValue("true");
          _jspx_th_impact_validateSelect_3.setCodesTable(CodesTables.COUTSTAT);
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_3.setValue(outcomeStatus);
          _jspx_th_impact_validateSelect_3.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth) || !isDuringSurveyPeriod ) );
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.DT_OUTCOME_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.DT_OUTCOME_NAME, labelMap));
          out.write(":\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setName(YouthReportDetailConversation.DT_OUTCOME_NAME);
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(outcomeDate));
          _jspx_th_impact_validateDate_1.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth) || !isDuringSurveyPeriod ) );
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

  row = 1; //-- not really necessary, but looks better if we start with white row again

          out.write("\r\n\t<table width=\"100%\" class=\"tableBorder\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\tborder=\"0\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\tRespond to the following as of the outcome date:\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td width=\"10%\" />\r\n\t\t\t<td width=\"90%\" colspan=\"");
          out.print(outcomeOuterColspan - 1);
          out.write("\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("radio");
          _jspx_th_impact_validateInput_36.setName(YouthReportDetailConversation.RADIO_FC_STATUS_NAME);
          _jspx_th_impact_validateInput_36.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_36.setChecked(String.valueOf(ArchitectureConstants.Y.equals(fcStatus)));
          _jspx_th_impact_validateInput_36.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_36.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth) || disablePersonFields  || !isDuringSurveyPeriod) );
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
          _jspx_th_impact_validateInput_37.setName(YouthReportDetailConversation.RADIO_FC_STATUS_NAME);
          _jspx_th_impact_validateInput_37.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_37.setChecked(String.valueOf(ArchitectureConstants.N.equals(fcStatus)));
          _jspx_th_impact_validateInput_37.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_37.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth) || disablePersonFields  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setName(YouthReportDetailConversation.RADIO_CURR_FTE_NAME);
          _jspx_th_impact_validateInput_38.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_38.setChecked(String.valueOf(ArchitectureConstants.Y.equals(currFTE)));
          _jspx_th_impact_validateInput_38.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_38.setDisabled(  String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod)  );
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
          _jspx_th_impact_validateInput_39.setName(YouthReportDetailConversation.RADIO_CURR_FTE_NAME);
          _jspx_th_impact_validateInput_39.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_39.setChecked(String.valueOf(ArchitectureConstants.N.equals(currFTE)));
          _jspx_th_impact_validateInput_39.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_39.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod)  );
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
          _jspx_th_impact_validateInput_40.setName(YouthReportDetailConversation.RADIO_CURR_FTE_NAME);
          _jspx_th_impact_validateInput_40.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_40.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(currFTE)));
          _jspx_th_impact_validateInput_40.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_40.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setType("radio");
          _jspx_th_impact_validateInput_41.setName(YouthReportDetailConversation.RADIO_CURR_PTE_NAME);
          _jspx_th_impact_validateInput_41.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_41.setChecked(String.valueOf(ArchitectureConstants.Y.equals(currPTE)));
          _jspx_th_impact_validateInput_41.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_41.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setType("radio");
          _jspx_th_impact_validateInput_42.setName(YouthReportDetailConversation.RADIO_CURR_PTE_NAME);
          _jspx_th_impact_validateInput_42.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_42.setChecked(String.valueOf(ArchitectureConstants.N.equals(currPTE)));
          _jspx_th_impact_validateInput_42.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_42.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("radio");
          _jspx_th_impact_validateInput_43.setName(YouthReportDetailConversation.RADIO_CURR_PTE_NAME);
          _jspx_th_impact_validateInput_43.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_43.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(currPTE)));
          _jspx_th_impact_validateInput_43.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_43.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_43.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setType("radio");
          _jspx_th_impact_validateInput_44.setName(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME);
          _jspx_th_impact_validateInput_44.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_44.setChecked(String.valueOf(ArchitectureConstants.Y.equals(empRelSkills)));
          _jspx_th_impact_validateInput_44.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_44.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_45.setName(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME);
          _jspx_th_impact_validateInput_45.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_45.setChecked(String.valueOf(ArchitectureConstants.N.equals(empRelSkills)));
          _jspx_th_impact_validateInput_45.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_45.setValue(ArchitectureConstants.N);
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
          _jspx_th_impact_validateInput_46.setName(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME);
          _jspx_th_impact_validateInput_46.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_46.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(empRelSkills)));
          _jspx_th_impact_validateInput_46.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_46.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_SS_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_SS_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setType("radio");
          _jspx_th_impact_validateInput_47.setName(YouthReportDetailConversation.RADIO_SS_NAME);
          _jspx_th_impact_validateInput_47.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_47.setChecked(String.valueOf(ArchitectureConstants.Y.equals(socialSecurity)));
          _jspx_th_impact_validateInput_47.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_47.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_48.setName(YouthReportDetailConversation.RADIO_SS_NAME);
          _jspx_th_impact_validateInput_48.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_48.setChecked(String.valueOf(ArchitectureConstants.N.equals(socialSecurity)));
          _jspx_th_impact_validateInput_48.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_48.setValue(ArchitectureConstants.N);
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
          _jspx_th_impact_validateInput_49.setName(YouthReportDetailConversation.RADIO_SS_NAME);
          _jspx_th_impact_validateInput_49.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_49.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(socialSecurity)));
          _jspx_th_impact_validateInput_49.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_49.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_49.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_EDU_AID_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_EDU_AID_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_50.setType("radio");
          _jspx_th_impact_validateInput_50.setName(YouthReportDetailConversation.RADIO_EDU_AID_NAME);
          _jspx_th_impact_validateInput_50.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_50.setChecked(String.valueOf(ArchitectureConstants.Y.equals(eduAid)));
          _jspx_th_impact_validateInput_50.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_50.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
          if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_51.setType("radio");
          _jspx_th_impact_validateInput_51.setName(YouthReportDetailConversation.RADIO_EDU_AID_NAME);
          _jspx_th_impact_validateInput_51.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_51.setChecked(String.valueOf(ArchitectureConstants.N.equals(eduAid)));
          _jspx_th_impact_validateInput_51.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_51.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
          if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setType("radio");
          _jspx_th_impact_validateInput_52.setName(YouthReportDetailConversation.RADIO_EDU_AID_NAME);
          _jspx_th_impact_validateInput_52.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_52.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(eduAid)));
          _jspx_th_impact_validateInput_52.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_52.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_OTH_INC_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_OTH_INC_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setType("radio");
          _jspx_th_impact_validateInput_53.setName(YouthReportDetailConversation.RADIO_OTH_INC_NAME);
          _jspx_th_impact_validateInput_53.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_53.setChecked(String.valueOf(ArchitectureConstants.Y.equals(otherIncome)));
          _jspx_th_impact_validateInput_53.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_53.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setType("radio");
          _jspx_th_impact_validateInput_54.setName(YouthReportDetailConversation.RADIO_OTH_INC_NAME);
          _jspx_th_impact_validateInput_54.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_54.setChecked(String.valueOf(ArchitectureConstants.N.equals(otherIncome)));
          _jspx_th_impact_validateInput_54.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_54.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_55.setType("radio");
          _jspx_th_impact_validateInput_55.setName(YouthReportDetailConversation.RADIO_OTH_INC_NAME);
          _jspx_th_impact_validateInput_55.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_55.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(otherIncome)));
          _jspx_th_impact_validateInput_55.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_55.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
          if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_HECR_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_HECR_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_56.setType("radio");
          _jspx_th_impact_validateInput_56.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_56.setLabel(YouthReportDetailConversation.HIGH_SCHOOL_GED);
          _jspx_th_impact_validateInput_56.setChecked(String.valueOf(CodesTables.CHIGHEDU_HS.equals(highEdu)));
          _jspx_th_impact_validateInput_56.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_56.setValue(CodesTables.CHIGHEDU_HS);
          _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
          if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_57.setType("radio");
          _jspx_th_impact_validateInput_57.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_57.setLabel(YouthReportDetailConversation.VOC_CERTIFICATE);
          _jspx_th_impact_validateInput_57.setChecked(String.valueOf(CodesTables.CHIGHEDU_VC.equals(highEdu)));
          _jspx_th_impact_validateInput_57.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_57.setValue(CodesTables.CHIGHEDU_VC);
          _jspx_th_impact_validateInput_57.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
          if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_58.setType("radio");
          _jspx_th_impact_validateInput_58.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_58.setLabel(YouthReportDetailConversation.VOC_LICENSE);
          _jspx_th_impact_validateInput_58.setChecked(String.valueOf(CodesTables.CHIGHEDU_VL.equals(highEdu)));
          _jspx_th_impact_validateInput_58.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_58.setValue(CodesTables.CHIGHEDU_VL);
          _jspx_th_impact_validateInput_58.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
          if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_59.setType("radio");
          _jspx_th_impact_validateInput_59.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_59.setLabel(YouthReportDetailConversation.ASSOCIATE);
          _jspx_th_impact_validateInput_59.setChecked(String.valueOf(CodesTables.CHIGHEDU_AD.equals(highEdu)));
          _jspx_th_impact_validateInput_59.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_59.setValue(CodesTables.CHIGHEDU_AD);
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
          _jspx_th_impact_validateInput_60.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_60.setLabel(YouthReportDetailConversation.BACHELOR);
          _jspx_th_impact_validateInput_60.setChecked(String.valueOf(CodesTables.CHIGHEDU_BD.equals(highEdu)));
          _jspx_th_impact_validateInput_60.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_60.setValue(CodesTables.CHIGHEDU_BD);
          _jspx_th_impact_validateInput_60.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
          if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_61.setType("radio");
          _jspx_th_impact_validateInput_61.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_61.setLabel(YouthReportDetailConversation.HIGHER_DEGREE);
          _jspx_th_impact_validateInput_61.setChecked(String.valueOf(CodesTables.CHIGHEDU_HD.equals(highEdu)));
          _jspx_th_impact_validateInput_61.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_61.setValue(CodesTables.CHIGHEDU_HD);
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
          _jspx_th_impact_validateInput_62.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_62.setLabel(YouthReportDetailConversation.NONE_ABOVE);
          _jspx_th_impact_validateInput_62.setChecked(String.valueOf(CodesTables.CHIGHEDU_NA.equals(highEdu)));
          _jspx_th_impact_validateInput_62.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_62.setValue(CodesTables.CHIGHEDU_NA);
          _jspx_th_impact_validateInput_62.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
          if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_63.setType("radio");
          _jspx_th_impact_validateInput_63.setName(YouthReportDetailConversation.RADIO_HECR_NAME);
          _jspx_th_impact_validateInput_63.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_63.setChecked(String.valueOf(CodesTables.CHIGHEDU_DC.equals(highEdu)));
          _jspx_th_impact_validateInput_63.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_63.setValue(CodesTables.CHIGHEDU_DC);
          _jspx_th_impact_validateInput_63.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
          if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_CAE_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_CAE_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_64 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_64.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_64.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_64.setType("radio");
          _jspx_th_impact_validateInput_64.setName(YouthReportDetailConversation.RADIO_CAE_NAME);
          _jspx_th_impact_validateInput_64.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_64.setChecked(String.valueOf(ArchitectureConstants.Y.equals(currAttdEnr)));
          _jspx_th_impact_validateInput_64.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_64.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_65.setName(YouthReportDetailConversation.RADIO_CAE_NAME);
          _jspx_th_impact_validateInput_65.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_65.setChecked(String.valueOf(ArchitectureConstants.N.equals(currAttdEnr)));
          _jspx_th_impact_validateInput_65.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_65.setValue(ArchitectureConstants.N);
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
          _jspx_th_impact_validateInput_66.setName(YouthReportDetailConversation.RADIO_CAE_NAME);
          _jspx_th_impact_validateInput_66.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_66.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(currAttdEnr)));
          _jspx_th_impact_validateInput_66.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_66.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_66.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_66 = _jspx_th_impact_validateInput_66.doStartTag();
          if (_jspx_th_impact_validateInput_66.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_C2A_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_C2A_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_67 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_67.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_67.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_67.setType("radio");
          _jspx_th_impact_validateInput_67.setName(YouthReportDetailConversation.RADIO_C2A_NAME);
          _jspx_th_impact_validateInput_67.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_67.setChecked(String.valueOf(ArchitectureConstants.Y.equals(connectAdult)));
          _jspx_th_impact_validateInput_67.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_67.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_68.setName(YouthReportDetailConversation.RADIO_C2A_NAME);
          _jspx_th_impact_validateInput_68.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_68.setChecked(String.valueOf(ArchitectureConstants.N.equals(connectAdult)));
          _jspx_th_impact_validateInput_68.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_68.setValue(ArchitectureConstants.N);
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
          _jspx_th_impact_validateInput_69.setName(YouthReportDetailConversation.RADIO_C2A_NAME);
          _jspx_th_impact_validateInput_69.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_69.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(connectAdult)));
          _jspx_th_impact_validateInput_69.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_69.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_69.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_69 = _jspx_th_impact_validateInput_69.doStartTag();
          if (_jspx_th_impact_validateInput_69.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_HOME_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_HOME_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_70 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_70.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_70.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_70.setType("radio");
          _jspx_th_impact_validateInput_70.setName(YouthReportDetailConversation.RADIO_HOME_NAME);
          _jspx_th_impact_validateInput_70.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_70.setChecked(String.valueOf(ArchitectureConstants.Y.equals(homeless)));
          _jspx_th_impact_validateInput_70.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_70.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_71.setName(YouthReportDetailConversation.RADIO_HOME_NAME);
          _jspx_th_impact_validateInput_71.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_71.setChecked(String.valueOf(ArchitectureConstants.N.equals(homeless)));
          _jspx_th_impact_validateInput_71.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_71.setValue(ArchitectureConstants.N);
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
          _jspx_th_impact_validateInput_72.setName(YouthReportDetailConversation.RADIO_HOME_NAME);
          _jspx_th_impact_validateInput_72.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_72.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(homeless)));
          _jspx_th_impact_validateInput_72.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_72.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_72.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_72 = _jspx_th_impact_validateInput_72.doStartTag();
          if (_jspx_th_impact_validateInput_72.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_SAR_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_SAR_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_73 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_73.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_73.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_73.setType("radio");
          _jspx_th_impact_validateInput_73.setName(YouthReportDetailConversation.RADIO_SAR_NAME);
          _jspx_th_impact_validateInput_73.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_73.setChecked(String.valueOf(ArchitectureConstants.Y.equals(subAbuseRef)));
          _jspx_th_impact_validateInput_73.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_73.setValue(ArchitectureConstants.Y);
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
          _jspx_th_impact_validateInput_74.setName(YouthReportDetailConversation.RADIO_SAR_NAME);
          _jspx_th_impact_validateInput_74.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_74.setChecked(String.valueOf(ArchitectureConstants.N.equals(subAbuseRef)));
          _jspx_th_impact_validateInput_74.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_74.setValue(ArchitectureConstants.N);
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
          _jspx_th_impact_validateInput_75.setName(YouthReportDetailConversation.RADIO_SAR_NAME);
          _jspx_th_impact_validateInput_75.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_75.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(subAbuseRef)));
          _jspx_th_impact_validateInput_75.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_75.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_75.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_75 = _jspx_th_impact_validateInput_75.doStartTag();
          if (_jspx_th_impact_validateInput_75.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_INC_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_INC_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_76 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_76.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_76.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_76.setType("radio");
          _jspx_th_impact_validateInput_76.setName(YouthReportDetailConversation.RADIO_INC_NAME);
          _jspx_th_impact_validateInput_76.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_76.setChecked(String.valueOf(ArchitectureConstants.Y.equals(incarcerate)));
          _jspx_th_impact_validateInput_76.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_76.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_76.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_76 = _jspx_th_impact_validateInput_76.doStartTag();
          if (_jspx_th_impact_validateInput_76.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_77 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_77.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_77.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_77.setType("radio");
          _jspx_th_impact_validateInput_77.setName(YouthReportDetailConversation.RADIO_INC_NAME);
          _jspx_th_impact_validateInput_77.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_77.setChecked(String.valueOf(ArchitectureConstants.N.equals(incarcerate)));
          _jspx_th_impact_validateInput_77.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_77.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_77.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_77 = _jspx_th_impact_validateInput_77.doStartTag();
          if (_jspx_th_impact_validateInput_77.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_78 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_78.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_78.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_78.setType("radio");
          _jspx_th_impact_validateInput_78.setName(YouthReportDetailConversation.RADIO_INC_NAME);
          _jspx_th_impact_validateInput_78.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_78.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(incarcerate)));
          _jspx_th_impact_validateInput_78.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_78.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_78.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_78 = _jspx_th_impact_validateInput_78.doStartTag();
          if (_jspx_th_impact_validateInput_78.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_CHL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_CHL_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_79 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_79.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_79.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_79.setType("radio");
          _jspx_th_impact_validateInput_79.setName(YouthReportDetailConversation.RADIO_CHL_NAME);
          _jspx_th_impact_validateInput_79.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_79.setChecked(String.valueOf(ArchitectureConstants.Y.equals(children)));
          _jspx_th_impact_validateInput_79.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_79.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_79.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_79.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_79 = _jspx_th_impact_validateInput_79.doStartTag();
          if (_jspx_th_impact_validateInput_79.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_80 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_80.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_80.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_80.setType("radio");
          _jspx_th_impact_validateInput_80.setName(YouthReportDetailConversation.RADIO_CHL_NAME);
          _jspx_th_impact_validateInput_80.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_80.setChecked(String.valueOf(ArchitectureConstants.N.equals(children)));
          _jspx_th_impact_validateInput_80.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_80.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_80.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_80.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_80 = _jspx_th_impact_validateInput_80.doStartTag();
          if (_jspx_th_impact_validateInput_80.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_81 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_81.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_81.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_81.setType("radio");
          _jspx_th_impact_validateInput_81.setName(YouthReportDetailConversation.RADIO_CHL_NAME);
          _jspx_th_impact_validateInput_81.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_81.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(children)));
          _jspx_th_impact_validateInput_81.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_81.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_81.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_81.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_81 = _jspx_th_impact_validateInput_81.doStartTag();
          if (_jspx_th_impact_validateInput_81.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_MAB_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_MAB_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_82 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_82.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_82.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_82.setType("radio");
          _jspx_th_impact_validateInput_82.setName(YouthReportDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_82.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_82.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_82.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_82.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_82.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_82 = _jspx_th_impact_validateInput_82.doStartTag();
          if (_jspx_th_impact_validateInput_82.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_83 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_83.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_83.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_83.setType("radio");
          _jspx_th_impact_validateInput_83.setName(YouthReportDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_83.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_83.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_83.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_83.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_83.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_83 = _jspx_th_impact_validateInput_83.doStartTag();
          if (_jspx_th_impact_validateInput_83.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_84 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_84.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_84.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_84.setType("radio");
          _jspx_th_impact_validateInput_84.setName(YouthReportDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_84.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_84.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_84.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_84.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_84.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_84 = _jspx_th_impact_validateInput_84.doStartTag();
          if (_jspx_th_impact_validateInput_84.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_85 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_85.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_85.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_85.setType("radio");
          _jspx_th_impact_validateInput_85.setName(YouthReportDetailConversation.RADIO_MAB_NAME);
          _jspx_th_impact_validateInput_85.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_85.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(marrAtBirth)));
          _jspx_th_impact_validateInput_85.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_85.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_85.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_85 = _jspx_th_impact_validateInput_85.doStartTag();
          if (_jspx_th_impact_validateInput_85.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_MED_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_MED_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_86 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_86.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_86.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_86.setType("radio");
          _jspx_th_impact_validateInput_86.setName(YouthReportDetailConversation.RADIO_MED_NAME);
          _jspx_th_impact_validateInput_86.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_86.setChecked(String.valueOf(ArchitectureConstants.Y.equals(medicaid)));
          _jspx_th_impact_validateInput_86.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_86.setValue(ArchitectureConstants.Y);
          _jspx_th_impact_validateInput_86.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_86 = _jspx_th_impact_validateInput_86.doStartTag();
          if (_jspx_th_impact_validateInput_86.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_87 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_87.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_87.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_87.setType("radio");
          _jspx_th_impact_validateInput_87.setName(YouthReportDetailConversation.RADIO_MED_NAME);
          _jspx_th_impact_validateInput_87.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_87.setChecked(String.valueOf(ArchitectureConstants.N.equals(medicaid)));
          _jspx_th_impact_validateInput_87.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_87.setValue(ArchitectureConstants.N);
          _jspx_th_impact_validateInput_87.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_87 = _jspx_th_impact_validateInput_87.doStartTag();
          if (_jspx_th_impact_validateInput_87.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_88 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_88.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_88.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_88.setType("radio");
          _jspx_th_impact_validateInput_88.setName(YouthReportDetailConversation.RADIO_MED_NAME);
          _jspx_th_impact_validateInput_88.setLabel(YouthReportDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_88.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(medicaid)));
          _jspx_th_impact_validateInput_88.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_88.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_88.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_88 = _jspx_th_impact_validateInput_88.doStartTag();
          if (_jspx_th_impact_validateInput_88.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_89 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_89.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_89.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_89.setType("radio");
          _jspx_th_impact_validateInput_89.setName(YouthReportDetailConversation.RADIO_MED_NAME);
          _jspx_th_impact_validateInput_89.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_89.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(medicaid)));
          _jspx_th_impact_validateInput_89.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_89.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_89.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_89 = _jspx_th_impact_validateInput_89.doStartTag();
          if (_jspx_th_impact_validateInput_89.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_OHIT_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_OHIT_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_90 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_90.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_90.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_90.setType("radio");
          _jspx_th_impact_validateInput_90.setName(YouthReportDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_90.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_90.setChecked(String.valueOf(ArchitectureConstants.Y.equals(otherHIT)));
          _jspx_th_impact_validateInput_90.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_90.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_90.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_90.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_90 = _jspx_th_impact_validateInput_90.doStartTag();
          if (_jspx_th_impact_validateInput_90.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_91 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_91.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_91.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_91.setType("radio");
          _jspx_th_impact_validateInput_91.setName(YouthReportDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_91.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_91.setChecked(String.valueOf(ArchitectureConstants.N.equals(otherHIT)));
          _jspx_th_impact_validateInput_91.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_91.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_91.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_91.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_91 = _jspx_th_impact_validateInput_91.doStartTag();
          if (_jspx_th_impact_validateInput_91.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_92 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_92.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_92.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_92.setType("radio");
          _jspx_th_impact_validateInput_92.setName(YouthReportDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_92.setLabel(YouthReportDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_92.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(otherHIT)));
          _jspx_th_impact_validateInput_92.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_92.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_92.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_92.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_92 = _jspx_th_impact_validateInput_92.doStartTag();
          if (_jspx_th_impact_validateInput_92.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_93 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_93.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_93.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_93.setType("radio");
          _jspx_th_impact_validateInput_93.setName(YouthReportDetailConversation.RADIO_OHIT_NAME);
          _jspx_th_impact_validateInput_93.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_93.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(otherHIT)));
          _jspx_th_impact_validateInput_93.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_93.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_93.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_93.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_93 = _jspx_th_impact_validateInput_93.doStartTag();
          if (_jspx_th_impact_validateInput_93.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_MEDICAL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_MEDICAL_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_94 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_94.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_94.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_94.setType("radio");
          _jspx_th_impact_validateInput_94.setName(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_94.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_94.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(medical)));
          _jspx_th_impact_validateInput_94.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_94.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_94.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_94.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_94 = _jspx_th_impact_validateInput_94.doStartTag();
          if (_jspx_th_impact_validateInput_94.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_95 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_95.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_95.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_95.setType("radio");
          _jspx_th_impact_validateInput_95.setName(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_95.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_95.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(medical)));
          _jspx_th_impact_validateInput_95.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_95.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_95.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_95.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_95 = _jspx_th_impact_validateInput_95.doStartTag();
          if (_jspx_th_impact_validateInput_95.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_96 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_96.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_96.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_96.setType("radio");
          _jspx_th_impact_validateInput_96.setName(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_96.setLabel(YouthReportDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_96.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(medical)));
          _jspx_th_impact_validateInput_96.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_96.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_96.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_96.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_96 = _jspx_th_impact_validateInput_96.doStartTag();
          if (_jspx_th_impact_validateInput_96.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_97 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_97.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_97.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_97.setType("radio");
          _jspx_th_impact_validateInput_97.setName(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_97.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_97.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(medical)));
          _jspx_th_impact_validateInput_97.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_97.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_97.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_97.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_97 = _jspx_th_impact_validateInput_97.doStartTag();
          if (_jspx_th_impact_validateInput_97.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_98 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_98.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_98.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_98.setType("radio");
          _jspx_th_impact_validateInput_98.setName(YouthReportDetailConversation.RADIO_MEDICAL_NAME);
          _jspx_th_impact_validateInput_98.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_98.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(medical)));
          _jspx_th_impact_validateInput_98.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_98.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_98.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_98.setOnClick("onRadioChanged()");
          int _jspx_eval_impact_validateInput_98 = _jspx_th_impact_validateInput_98.doStartTag();
          if (_jspx_th_impact_validateInput_98.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_MENTAL_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_MENTAL_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_99 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_99.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_99.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_99.setType("radio");
          _jspx_th_impact_validateInput_99.setName(YouthReportDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_99.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_99.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(mental)));
          _jspx_th_impact_validateInput_99.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_99.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_99.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_99 = _jspx_th_impact_validateInput_99.doStartTag();
          if (_jspx_th_impact_validateInput_99.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_100 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_100.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_100.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_100.setType("radio");
          _jspx_th_impact_validateInput_100.setName(YouthReportDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_100.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_100.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(mental)));
          _jspx_th_impact_validateInput_100.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_100.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_100.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_100 = _jspx_th_impact_validateInput_100.doStartTag();
          if (_jspx_th_impact_validateInput_100.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_101 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_101.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_101.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_101.setType("radio");
          _jspx_th_impact_validateInput_101.setName(YouthReportDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_101.setLabel(YouthReportDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_101.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(mental)));
          _jspx_th_impact_validateInput_101.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_101.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_101.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_101 = _jspx_th_impact_validateInput_101.doStartTag();
          if (_jspx_th_impact_validateInput_101.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_102 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_102.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_102.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_102.setType("radio");
          _jspx_th_impact_validateInput_102.setName(YouthReportDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_102.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_102.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(mental)));
          _jspx_th_impact_validateInput_102.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_102.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_102.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_102 = _jspx_th_impact_validateInput_102.doStartTag();
          if (_jspx_th_impact_validateInput_102.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_103 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_103.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_103.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_103.setType("radio");
          _jspx_th_impact_validateInput_103.setName(YouthReportDetailConversation.RADIO_MENTAL_NAME);
          _jspx_th_impact_validateInput_103.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_103.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(mental)));
          _jspx_th_impact_validateInput_103.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_103.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_103.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_103 = _jspx_th_impact_validateInput_103.doStartTag();
          if (_jspx_th_impact_validateInput_103.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_104 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_104.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_104.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_104.setType("radio");
          _jspx_th_impact_validateInput_104.setName(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_104.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_104.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(prescription)));
          _jspx_th_impact_validateInput_104.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_104.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_104.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_104 = _jspx_th_impact_validateInput_104.doStartTag();
          if (_jspx_th_impact_validateInput_104.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_105 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_105.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_105.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_105.setType("radio");
          _jspx_th_impact_validateInput_105.setName(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_105.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_105.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(prescription)));
          _jspx_th_impact_validateInput_105.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_105.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_105.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_105 = _jspx_th_impact_validateInput_105.doStartTag();
          if (_jspx_th_impact_validateInput_105.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_106 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_106.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_106.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_106.setType("radio");
          _jspx_th_impact_validateInput_106.setName(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_106.setLabel(YouthReportDetailConversation.DONT_KNOW);
          _jspx_th_impact_validateInput_106.setChecked(String.valueOf(CodesTables.CINVACAN_K.equals(prescription)));
          _jspx_th_impact_validateInput_106.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_106.setValue(CodesTables.CINVACAN_K);
          _jspx_th_impact_validateInput_106.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_106 = _jspx_th_impact_validateInput_106.doStartTag();
          if (_jspx_th_impact_validateInput_106.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_107 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_107.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_107.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_107.setType("radio");
          _jspx_th_impact_validateInput_107.setName(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_107.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_107.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(prescription)));
          _jspx_th_impact_validateInput_107.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_107.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_107.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_107 = _jspx_th_impact_validateInput_107.doStartTag();
          if (_jspx_th_impact_validateInput_107.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_108 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_108.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_108.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_108.setType("radio");
          _jspx_th_impact_validateInput_108.setName(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME);
          _jspx_th_impact_validateInput_108.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_108.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(prescription)));
          _jspx_th_impact_validateInput_108.setDisabled( String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          _jspx_th_impact_validateInput_108.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_108.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_108 = _jspx_th_impact_validateInput_108.doStartTag();
          if (_jspx_th_impact_validateInput_108.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n        ");
if(isFollowUp && ArchitectureConstants.N.equals(fcStatus) ){ 
          out.write("\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_TANF_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_TANF_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_109 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_109.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_109.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_109.setType("radio");
          _jspx_th_impact_validateInput_109.setName(YouthReportDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_109.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_109.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(tanf)));
          _jspx_th_impact_validateInput_109.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_109.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_109.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_109 = _jspx_th_impact_validateInput_109.doStartTag();
          if (_jspx_th_impact_validateInput_109.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_110 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_110.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_110.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_110.setType("radio");
          _jspx_th_impact_validateInput_110.setName(YouthReportDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_110.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_110.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(tanf)));
          _jspx_th_impact_validateInput_110.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_110.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_110.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_110 = _jspx_th_impact_validateInput_110.doStartTag();
          if (_jspx_th_impact_validateInput_110.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_111 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_111.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_111.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_111.setType("radio");
          _jspx_th_impact_validateInput_111.setName(YouthReportDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_111.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_111.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(tanf)));
          _jspx_th_impact_validateInput_111.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_111.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_111.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_111 = _jspx_th_impact_validateInput_111.doStartTag();
          if (_jspx_th_impact_validateInput_111.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_112 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_112.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_112.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_112.setType("radio");
          _jspx_th_impact_validateInput_112.setName(YouthReportDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_112.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_112.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(tanf)));
          _jspx_th_impact_validateInput_112.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_112.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_112.setDisabled( String.valueOf(true) );
          int _jspx_eval_impact_validateInput_112 = _jspx_th_impact_validateInput_112.doStartTag();
          if (_jspx_th_impact_validateInput_112.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_113 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_113.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_113.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_113.setType("radio");
          _jspx_th_impact_validateInput_113.setName(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_113.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_113.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(foodStamps)));
          _jspx_th_impact_validateInput_113.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_113.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_113.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_113 = _jspx_th_impact_validateInput_113.doStartTag();
          if (_jspx_th_impact_validateInput_113.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_114 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_114.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_114.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_114.setType("radio");
          _jspx_th_impact_validateInput_114.setName(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_114.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_114.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(foodStamps)));
          _jspx_th_impact_validateInput_114.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_114.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_114.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_114 = _jspx_th_impact_validateInput_114.doStartTag();
          if (_jspx_th_impact_validateInput_114.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_115 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_115.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_115.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_115.setType("radio");
          _jspx_th_impact_validateInput_115.setName(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_115.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_115.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(foodStamps)));
          _jspx_th_impact_validateInput_115.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_115.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_115.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_115 = _jspx_th_impact_validateInput_115.doStartTag();
          if (_jspx_th_impact_validateInput_115.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_116 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_116.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_116.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_116.setType("radio");
          _jspx_th_impact_validateInput_116.setName(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_116.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_116.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(foodStamps)));
          _jspx_th_impact_validateInput_116.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_116.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_116.setDisabled( String.valueOf(true) );
          int _jspx_eval_impact_validateInput_116 = _jspx_th_impact_validateInput_116.doStartTag();
          if (_jspx_th_impact_validateInput_116.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row));
          out.write("\">\r\n\t\t\t<td colspan=\"");
          out.print(outcomeOuterColspan);
          out.write("\">\r\n\t\t\t\t<div\r\n\t\t\t\t\tclass=\"");
          out.print(getLabelClass(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, errorInputs));
          out.write('"');
          out.write('>');
          out.print(YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED);
          out.print(getLabel(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, labelMap));
          out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr class=\"");
          out.print(FormattingHelper.getRowCss(row++));
          out.write("\">\r\n\t\t\t<td />\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_117 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_117.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_117.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_117.setType("radio");
          _jspx_th_impact_validateInput_117.setName(YouthReportDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_117.setLabel(YouthReportDetailConversation.YES);
          _jspx_th_impact_validateInput_117.setChecked(String.valueOf(CodesTables.CINVACAN_Y.equals(publicHsg)));
          _jspx_th_impact_validateInput_117.setValue(CodesTables.CINVACAN_Y);
          _jspx_th_impact_validateInput_117.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_117.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_117 = _jspx_th_impact_validateInput_117.doStartTag();
          if (_jspx_th_impact_validateInput_117.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_118 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_118.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_118.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_118.setType("radio");
          _jspx_th_impact_validateInput_118.setName(YouthReportDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_118.setLabel(YouthReportDetailConversation.NO);
          _jspx_th_impact_validateInput_118.setChecked(String.valueOf(CodesTables.CINVACAN_N.equals(publicHsg)));
          _jspx_th_impact_validateInput_118.setValue(CodesTables.CINVACAN_N);
          _jspx_th_impact_validateInput_118.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_118.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_118 = _jspx_th_impact_validateInput_118.doStartTag();
          if (_jspx_th_impact_validateInput_118.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_119 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_119.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_119.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_119.setType("radio");
          _jspx_th_impact_validateInput_119.setName(YouthReportDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_119.setLabel(YouthReportDetailConversation.DECLINED);
          _jspx_th_impact_validateInput_119.setChecked(String.valueOf(CodesTables.CINVACAN_D.equals(publicHsg)));
          _jspx_th_impact_validateInput_119.setValue(CodesTables.CINVACAN_D);
          _jspx_th_impact_validateInput_119.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_119.setDisabled( String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) );
          int _jspx_eval_impact_validateInput_119 = _jspx_th_impact_validateInput_119.doStartTag();
          if (_jspx_th_impact_validateInput_119.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_120 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_120.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_120.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_120.setType("radio");
          _jspx_th_impact_validateInput_120.setName(YouthReportDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_120.setLabel(YouthReportDetailConversation.NA);
          _jspx_th_impact_validateInput_120.setChecked(String.valueOf(CodesTables.CINVACAN_A.equals(publicHsg)));
          _jspx_th_impact_validateInput_120.setValue(CodesTables.CINVACAN_A);
          _jspx_th_impact_validateInput_120.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_120.setDisabled( String.valueOf(true) );
          int _jspx_eval_impact_validateInput_120 = _jspx_th_impact_validateInput_120.doStartTag();
          if (_jspx_th_impact_validateInput_120.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");
} 
          out.write("\r\n\t</table>\r\n\t");

  }

          out.write("\r\n\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t<tr>\r\n\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName(YouthReportDetailConversation.SAVE_BUTTON_NAME);
          _jspx_th_impact_ButtonTag_0.setForm(YouthReportDetailConversation.FORM_NAME);
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ButtonTag_0.setAction("/person/YouthReportDetail/saveReportDetail");
          _jspx_th_impact_ButtonTag_0.setImg("btnSave");
          _jspx_th_impact_ButtonTag_0.setRestrictRepost(true);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_121 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_121.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_121.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_121.setType("hidden");
          _jspx_th_impact_validateInput_121.setName(YouthReportDetailConversation.HDN_CD_POPULATION_TYPE);
          _jspx_th_impact_validateInput_121.setValue(cdPopulationType);
          int _jspx_eval_impact_validateInput_121 = _jspx_th_impact_validateInput_121.doStartTag();
          if (_jspx_th_impact_validateInput_121.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_122 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_122.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_122.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_122.setType("hidden");
          _jspx_th_impact_validateInput_122.setName(YouthReportDetailConversation.IND_ENTERED_BY_YTH);
          _jspx_th_impact_validateInput_122.setValue(indEnteredByYth);
          int _jspx_eval_impact_validateInput_122 = _jspx_th_impact_validateInput_122.doStartTag();
          if (_jspx_th_impact_validateInput_122.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_123 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_123.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_123.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_123.setType("hidden");
          _jspx_th_impact_validateInput_123.setName(YouthReportDetailConversation.SEL_AGE_CLASS_NAME);
          _jspx_th_impact_validateInput_123.setValue(ageClass);
          int _jspx_eval_impact_validateInput_123 = _jspx_th_impact_validateInput_123.doStartTag();
          if (_jspx_th_impact_validateInput_123.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_124 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_124.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_124.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_124.setType("hidden");
          _jspx_th_impact_validateInput_124.setName(YouthReportDetailConversation.RADIO_FC_STATUS_NAME);
          _jspx_th_impact_validateInput_124.setValue(fcStatus);
          int _jspx_eval_impact_validateInput_124 = _jspx_th_impact_validateInput_124.doStartTag();
          if (_jspx_th_impact_validateInput_124.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_125 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_125.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_125.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_125.setType("hidden");
          _jspx_th_impact_validateInput_125.setName(YouthReportDetailConversation.RADIO_TANF_NAME);
          _jspx_th_impact_validateInput_125.setValue(tanf);
          int _jspx_eval_impact_validateInput_125 = _jspx_th_impact_validateInput_125.doStartTag();
          if (_jspx_th_impact_validateInput_125.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_126 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_126.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_126.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_126.setType("hidden");
          _jspx_th_impact_validateInput_126.setName(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME);
          _jspx_th_impact_validateInput_126.setValue(foodStamps);
          int _jspx_eval_impact_validateInput_126 = _jspx_th_impact_validateInput_126.doStartTag();
          if (_jspx_th_impact_validateInput_126.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_127 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_127.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_127.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_127.setType("hidden");
          _jspx_th_impact_validateInput_127.setName(YouthReportDetailConversation.RADIO_PUB_HSG_NAME);
          _jspx_th_impact_validateInput_127.setValue(publicHsg);
          int _jspx_eval_impact_validateInput_127 = _jspx_th_impact_validateInput_127.doStartTag();
          if (_jspx_th_impact_validateInput_127.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n");
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
