<%--
JSP Name:     YouthReportDetail.jsp
Created by:   Andrew Goode
Date Created: 03/27/07

Change History:
Date      User              Description
--------  ----------------  ----------------------------------------------
03/27/07  abgoode           JSP creation
08/20/10  hnguyen           MR-067: Updated page to add new fields and privileges
09/01/10  hnguyen           MR-067: Removed unused javascript function and colon from survey question
09/09/10  hnguyen           MR-067: Moved label map from conversation 
                            and update condition to disable survey section if not in survey period
09/09/10  hnguyen           SMS#66384 MR-67 Added logic to display page based on youth current
                            population type and outcome foster care status, if youth is active
                            and report displayed is for current reporting period
09/20/10  hnguyen           SMS#72010 Added No response for OthHlthIns-medical
09/22/10  hnguyen           SMS#71814 Added labels for display on jsp and for 
                            validation to highlight field on page
09/23/10  hnguyen           SMS#72519 Removed invalid condition to disable not in care followup question
                            and added javascript to disable N/A radio buttons if it applies to youth

--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.person.YouthReportDetailConversation"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%  
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
%>

<script type="text/javascript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
  window.onload = function()
  {
    onRadioChanged();
  };

  window.onbeforeunload = function() {
    IsDirty();
  };
  
  //-- this function is called when custom error messages are displayed for radio buttons
  function focusOn(elmName) {
    elmsByName = document.getElementsByName(elmName);
    elm = elmsByName[0];
    try {
      elm.focus();
    } catch(e) {}
  }

  function onRadioChanged(){
    if(getRadioCheckedValue('<%=YouthReportDetailConversation.RADIO_CHL_NAME%>') == '<%= CodesTables.CINVACAN_Y%>'){
      // Disable question 14 N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_MAB_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].checked = false;
            e[i].disabled = true;
        }
      }
    }else{
      // Enable question 14 N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_MAB_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].disabled = false;
        }
      }
    }
    
    if(getRadioCheckedValue('<%=YouthReportDetailConversation.RADIO_OHIT_NAME%>') == '<%= CodesTables.CINVACAN_Y%>'){
      // Disable question 16a N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].checked = false;
            e[i].disabled = true;
        }
      }
    }else{
      // Enable question 16a N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].disabled = false;
        }
      }
    }
    
    if(getRadioCheckedValue('<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>') == '<%= CodesTables.CINVACAN_Y%>'){
      // Disable question 16b N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].checked = false;
            e[i].disabled = true;
        }
      }
      // Disable question 16c N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].checked = false;
            e[i].disabled = true;
        }
      }
    }else{
      // Enable question 16b N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].disabled = false;
        }
      }
      // Enable question 16c N/A
      var e = document.getElementsByName('<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>');
      for( var i = 0; i < e.length; i++ ){
        if( e[i].value == '<%= CodesTables.CINVACAN_A%>'){
            e[i].disabled = false;
        }
      }
    }
  }
  
  function getRadioCheckedValue( radioName ){
    var oRadio = document.<%=YouthReportDetailConversation.FORM_NAME%>.elements[radioName];
  
    for( var i = 0; i < oRadio.length; i++){
      if(oRadio[i].checked){
        return oRadio[i].value;
      }
      
      return '';
    }
  }

</script>

<impact:validateErrors />
<%
  List errorInputs = (List) state.getAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_INPUTS, request);
  if(errorInputs != null && !errorInputs.isEmpty()) {
    String customErrorHTML = (String) state.getAttribute(YouthReportDetailConversation.VALIDATION_CUSTOM_HTML, request);
    out.print(customErrorHTML);
  }
%>
<impact:validateForm
	name="<%= YouthReportDetailConversation.FORM_NAME %>"
	action="/person/YouthReportDetail/displayReportDetail"
	schema="/WEB-INF/Constraints.xsd" method="post"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.person.YouthReportDetailCustomValidation"
	pageMode="<%=PageMode.getPageMode(request)%>">
	<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3"
		border="0">

		<%-- **************** General Information section **************** --%>
		<tr>
			<th colspan="<%=outerColspan%>">
				General Information
			</th>
		</tr>
		<tr>
			<td width="30%" />
			<td width="25%" />
			<td width="20%" />
			<td width="25%" />
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField
					name="<%=YouthReportDetailConversation.DT_END_REPORT_PERIOD_NAME%>"
					label="End of Reporting Period"
					colspan="<%=String.valueOf(outerColspan - 1)%>"
					value="<%=FormattingHelper.formatDate(endReportPeriod)%>" />
			</td>
		</tr>
		<tr>
            <td valign="top">
                <div
                    class="<%=getLabelClass(YouthReportDetailConversation.DT_DOB_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.DT_DOB_NAME, labelMap)%>:
                </div>
            </td>
			<td>
				<impact:validateDate
					name="<%=YouthReportDetailConversation.DT_DOB_NAME%>"
					constraint="Date"
					disabled="<%=String.valueOf(disablePersonFields)%>"
					tabIndex="<%=tabIndex++%>"
					value="<%=FormattingHelper.formatDate(dob)%>" />
			</td>
			<td>
				Age Class:
				<%= Lookup.simpleDecodeSafe( "CAGECLSS" , ageClass) %>
			</td>
		</tr>
		<tr>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.SEL_SEX_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.SEL_SEX_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=String.valueOf(outerColspan - 1)%>">
				<impact:validateSelect
					name="<%=YouthReportDetailConversation.SEL_SEX_NAME%>"
					blankValue="true"
					disabled="<%=String.valueOf(disablePersonFields)%>"
					codesTable="<%=CodesTables.CSEX%>" tabIndex="<%=tabIndex++%>"
					value="<%=sex%>" />
			</td>
		</tr>
		<tr>
			<td valign="top">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.CBG_RACE_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.CBG_RACE_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 2%>">
				<impact:codesCheckbox
					name="<%=YouthReportDetailConversation.CBG_RACE_NAME%>" columns="2"
					isHorizontal="true"
					disabled="<%=String.valueOf(disablePersonFields)%>"
					codesTableName="<%=CodesTables.CRACE%>" tabIndex="<%=tabIndex++%>"
					defaultCodes="<%=races%>" />
			</td>
			<td valign="top">
			</td>
		</tr>
		<tr>
            <td>
                <div
                    class="<%=getLabelClass(YouthReportDetailConversation.SEL_ETHNICITY_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.SEL_ETHNICITY_NAME, labelMap)%>:
                </div>
            </td>
			<td>
				<impact:validateSelect
					name="<%=YouthReportDetailConversation.SEL_ETHNICITY_NAME%>"
					blankValue="true"
					disabled="<%=String.valueOf(disablePersonFields)%>"
					codesTable="<%=CodesTables.CINDETHN%>" tabIndex="<%=tabIndex++%>"
					value="<%=ethnicity%>" />
			</td>
			<td colspan="<%=outerColspan - 1%>">
			</td>
		</tr>
		<tr>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_TRIBAL_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_TRIBAL_NAME, labelMap)%>:
				</div>
			</td>
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_TRIBAL_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(tribal))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_TRIBAL_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(tribal))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
			</td>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME, labelMap)%>:
				</div>
			</td>
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(fcStatusSvcs))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FC_ST_SVCS_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(fcStatusSvcs))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_ADJ_DEL_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ADJ_DEL_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(adjDelinquent))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ADJ_DEL_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(adjDelinquent))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
			</td>
		</tr>
		<tr>
            <td>
                <div
                    class="<%=getLabelClass(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME, labelMap)%>:
                </div>
            </td>
			<td>
				<impact:validateSelect
					name="<%=YouthReportDetailConversation.SEL_LAST_GRD_COMP_NAME%>"
					blankValue="true"
					codesTable="<%=CodesTables.CEDUCOMP%>" tabIndex="<%=tabIndex++%>"
					value="<%=lastGradeComp%>" />
			</td>
		</tr>
		<tr>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(spcEdStat))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SPC_ED_STAT_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(spcEdStat))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%=String.valueOf(disablePersonFields)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(ilNeedsAsm))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_IL_NEEDS_ASM_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(ilNeedsAsm))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3"
		border="0">

		<%-- **************** Support/Training section **************** --%>
		<tr>
			<th colspan="<%=suppOuterColspan%>">
				Support/Training Provided Within Reporting Period:
			</th>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td colspan="2">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="2">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(academicSupp))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ACAD_SUPP_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(academicSupp))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_ACAD_SUPP_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtAcadSupport%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(postSecondary))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PS_EDU_SUPP_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(postSecondary))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_PS_EDU_SUPP_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtPsEduSupport%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_CAREER_PREP_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CAREER_PREP_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(careerPrep))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CAREER_PREP_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(careerPrep))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_CAREER_PREP_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtCareerPrep%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(empProgVoc))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EMP_PROG_VOC_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(empProgVoc))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_EMP_PROG_VOC_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtEmpProgVoc%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(budgetMgt))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_BGT_FIN_MGT_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(budgetMgt))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_BGT_FIN_MGT_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtBdgtFinMgt%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_HOME_MGT_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HOME_MGT_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(homeMgt))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HOME_MGT_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(homeMgt))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_HOME_MGT_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtHousingEdu%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(healthEdRP))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HLTH_ED_RP_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(healthEdRP))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_HLTH_ED_RP_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtHealthEdu%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(famMarrEd))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FAM_MARR_ED_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(famMarrEd))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_FAM_MARR_ED_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtFamMarrEdu%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_MENTORING_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_MENTORING_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MENTORING_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(mentoring))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MENTORING_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(mentoring))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_MENTORING_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtMentoring%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_SUPER_IL_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SUPER_IL_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(superIL))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SUPER_IL_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(superIL))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_SUPER_IL_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtSuperIl%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_ROOM_BRD_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ROOM_BRD_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(roomBoard))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ROOM_BRD_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(roomBoard))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_ROOM_BRD_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtRmBrdFin%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(edFinAsst))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_ED_FIN_ASST_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(edFinAsst))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_ED_FIN_ASST_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtEduFinance%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_OTHER_FIN_NAME, labelMap)%>:
				</div>
			</td>
			<td colspan="<%=outerColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OTHER_FIN_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(otherFin))%>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OTHER_FIN_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(otherFin))%>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
			</td>
			<td valign="middle">
				<!--- Text Area Custom Tag --->
				<impact:validateTextArea
					name="<%=YouthReportDetailConversation.TEXT_OTHER_FIN_COMM%>"
					label="<%=YouthReportDetailConversation.COMMENTS%>" colspan="2"
					rows="2" cols="50" tabIndex="<%=tabIndex++%>" constraint="Comments">
					<%=txtOthFinance%>
				</impact:validateTextArea>
			</td>
		</tr>
	</table>
	<% if (isBaseline || isFollowUp) { %>
	<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3"
		border="0">

		<%-- **************** Outcome Reporting and Responses section **************** --%>
		<tr>
			<th colspan="<%=outerColspan%>">
				The following survey questions needs to be answered by the Youth.
			</th>
		</tr>
		<tr>
			<th colspan="<%=outerColspan%>">
				Outcome Reporting
			</th>
		</tr>
		<tr>
			<td width="30%">
				Entered By:
			</td>
			<td width="25%"><%= nmEnteredByName %></td>
			<td width="20%"></td>
			<td width="25%"></td>
		</tr>
		<tr>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME, labelMap)%>:
				</div>
			</td>
			<td>
				<impact:validateSelect
					name="<%=YouthReportDetailConversation.SEL_OUTCOME_STAT_NAME%>"
					blankValue="true" codesTable="<%=CodesTables.COUTSTAT%>"
					tabIndex="<%=tabIndex++%>" value="<%=outcomeStatus%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth) || !isDuringSurveyPeriod ) %>" />
			</td>
			<td>
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.DT_OUTCOME_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.DT_OUTCOME_NAME, labelMap)%>:
				</div>
			</td>
			<td>
				<impact:validateDate
					name="<%=YouthReportDetailConversation.DT_OUTCOME_NAME%>"
					constraint="Date" tabIndex="<%=tabIndex++%>"
					value="<%=FormattingHelper.formatDate(outcomeDate)%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth) || !isDuringSurveyPeriod ) %>" />
			</td>
		</tr>
	</table>
	<%
  row = 1; //-- not really necessary, but looks better if we start with white row again
%>
	<table width="100%" class="tableBorder" cellspacing="0" cellpadding="3"
		border="0">
		<tr>
			<th colspan="<%=outcomeOuterColspan%>">
				Respond to the following as of the outcome date:
			</th>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_FC_STATUS_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td width="10%" />
			<td width="90%" colspan="<%=outcomeOuterColspan - 1%>">
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FC_STATUS_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(fcStatus))%>"
					value="<%=ArchitectureConstants.Y%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth) || disablePersonFields  || !isDuringSurveyPeriod) %>"
					tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FC_STATUS_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(fcStatus))%>"
					value="<%=ArchitectureConstants.N%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth) || disablePersonFields  || !isDuringSurveyPeriod) %>"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_CURR_FTE_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CURR_FTE_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(currFTE))%>"
					value="<%=ArchitectureConstants.Y%>"
					disabled="<%=  String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod)  %>"
					tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CURR_FTE_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(currFTE))%>"
					value="<%=ArchitectureConstants.N%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod)  %>"
					tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CURR_FTE_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(currFTE))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_CURR_PTE_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CURR_PTE_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(currPTE))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CURR_PTE_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(currPTE))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CURR_PTE_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(currPTE))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(empRelSkills))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(empRelSkills))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EMP_SKILLS_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(empRelSkills))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_SS_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_SS_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SS_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(socialSecurity))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SS_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(socialSecurity))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SS_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(socialSecurity))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_EDU_AID_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_EDU_AID_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EDU_AID_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(eduAid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EDU_AID_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(eduAid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_EDU_AID_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(eduAid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_OTH_INC_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_OTH_INC_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OTH_INC_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(otherIncome))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OTH_INC_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(otherIncome))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OTH_INC_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(otherIncome))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_HECR_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_HECR_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.HIGH_SCHOOL_GED%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_HS.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_HS%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.VOC_CERTIFICATE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_VC.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_VC%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.VOC_LICENSE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_VL.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_VL%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.ASSOCIATE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_AD.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_AD%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.BACHELOR%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_BD.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_BD%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.HIGHER_DEGREE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_HD.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_HD%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.NONE_ABOVE%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_NA.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_NA%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HECR_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CHIGHEDU_DC.equals(highEdu))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CHIGHEDU_DC%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_CAE_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_CAE_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CAE_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(currAttdEnr))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CAE_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(currAttdEnr))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CAE_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(currAttdEnr))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_C2A_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_C2A_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_C2A_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(connectAdult))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_C2A_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(connectAdult))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_C2A_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(connectAdult))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_HOME_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_HOME_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HOME_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(homeless))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HOME_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(homeless))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_HOME_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(homeless))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_SAR_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_SAR_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SAR_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(subAbuseRef))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SAR_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(subAbuseRef))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_SAR_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(subAbuseRef))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_INC_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_INC_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_INC_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(incarcerate))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_INC_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(incarcerate))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_INC_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(incarcerate))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_CHL_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_CHL_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CHL_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(children))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CHL_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(children))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_CHL_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(children))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_MAB_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_MAB_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MAB_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(marrAtBirth))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MAB_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(marrAtBirth))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MAB_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(marrAtBirth))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MAB_NAME%>"
					label="<%=YouthReportDetailConversation.NA%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(marrAtBirth))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_MED_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_MED_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MED_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(medicaid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MED_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(medicaid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=ArchitectureConstants.N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MED_NAME%>"
					label="<%=YouthReportDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(medicaid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MED_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(medicaid))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_OHIT_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_OHIT_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(ArchitectureConstants.Y.equals(otherHIT))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(ArchitectureConstants.N.equals(otherHIT))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
                <impact:validateInput type="radio"
                    name="<%=YouthReportDetailConversation.RADIO_OHIT_NAME%>"
                    label="<%=YouthReportDetailConversation.DONT_KNOW%>"
                    checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(otherHIT))%>"
                    disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
                    value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_OHIT_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(otherHIT))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_MEDICAL_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_MEDICAL_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(medical))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
					onClick="onRadioChanged()" />
                <impact:validateInput type="radio"
                    name="<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>"
                    label="<%=YouthReportDetailConversation.NO%>"
                    checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(medical))%>"
                    disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
                    value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>"
					label="<%=YouthReportDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(medical))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(medical))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
                <impact:validateInput type="radio"
                    name="<%=YouthReportDetailConversation.RADIO_MEDICAL_NAME%>"
                    label="<%=YouthReportDetailConversation.NA%>"
                    checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(medical))%>"
                    disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
                    value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>"
                    onClick="onRadioChanged()" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_MENTAL_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_MENTAL_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(mental))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(mental))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=YouthReportDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(mental))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(mental))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
                <impact:validateInput type="radio"
                    name="<%=YouthReportDetailConversation.RADIO_MENTAL_NAME%>"
                    label="<%=YouthReportDetailConversation.NA%>"
                    checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(mental))%>"
                    disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
                    value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(prescription))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(prescription))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=YouthReportDetailConversation.DONT_KNOW%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_K.equals(prescription))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_K%>" tabIndex="<%=tabIndex++%>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(prescription))%>"
					disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>" />
                <impact:validateInput type="radio"
                    name="<%=YouthReportDetailConversation.RADIO_PRESCRIPTION_NAME%>"
                    label="<%=YouthReportDetailConversation.NA%>"
                    checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(prescription))%>"
                    disabled="<%= String.valueOf(StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>"
                    value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
        <%if(isFollowUp && ArchitectureConstants.N.equals(fcStatus) ){ %>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_TANF_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_TANF_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_TANF_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_TANF_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_TANF_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_TANF_NAME%>"
					label="<%=YouthReportDetailConversation.NA%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(tanf))%>"
					value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf(true) %>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_FOOD_STMP_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_FOOD_STMP_NAME%>"
					label="<%=YouthReportDetailConversation.NA%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(foodStamps))%>"
					value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf(true) %>" />
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row)%>">
			<td colspan="<%=outcomeOuterColspan%>">
				<div
					class="<%=getLabelClass(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, errorInputs)%>"><%=YouthReportDetailConversation.HTML_MARK_AS_COND_REQUIRED%><%=getLabel(YouthReportDetailConversation.RADIO_PUB_HSG_NAME, labelMap)%>
				</div>
			</td>
		</tr>
		<tr class="<%=FormattingHelper.getRowCss(row++)%>">
			<td />
			<td>
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=YouthReportDetailConversation.YES%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_Y.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_Y%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=YouthReportDetailConversation.NO%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_N.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_N%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=YouthReportDetailConversation.DECLINED%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_D.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_D%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf( StringHelper.toBooleanSafe(indEnteredByYth)  || !isDuringSurveyPeriod) %>" />
				<impact:validateInput type="radio"
					name="<%=YouthReportDetailConversation.RADIO_PUB_HSG_NAME%>"
					label="<%=YouthReportDetailConversation.NA%>"
					checked="<%=String.valueOf(CodesTables.CINVACAN_A.equals(publicHsg))%>"
					value="<%=CodesTables.CINVACAN_A%>" tabIndex="<%=tabIndex++%>"
					disabled="<%= String.valueOf(true) %>" />
			</td>
		</tr>
		<%} %>
	</table>
	<%
  }
%>
	<table width="100%" cellspacing="0" cellpadding="3" border="0">
		<tr>
			<td class="alignRight">
				<impact:ButtonTag
					name="<%=YouthReportDetailConversation.SAVE_BUTTON_NAME%>"
					form="<%=YouthReportDetailConversation.FORM_NAME%>"
					tabIndex="<%=tabIndex++%>"
					action="/person/YouthReportDetail/saveReportDetail" img="btnSave"
					restrictRepost="true" />
			</td>
		</tr>
	</table>
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<impact:validateInput type="hidden"
		name="<%=YouthReportDetailConversation.HDN_CD_POPULATION_TYPE%>"
		value="<%=cdPopulationType%>" />
	<impact:validateInput type="hidden"
		name="<%=YouthReportDetailConversation.IND_ENTERED_BY_YTH%>"
		value="<%=indEnteredByYth%>" />
	<impact:validateInput type="hidden"
		name="<%=YouthReportDetailConversation.SEL_AGE_CLASS_NAME%>"
		value="<%=ageClass%>" />
    <impact:validateInput type="hidden"
        name="<%=YouthReportDetailConversation.RADIO_FC_STATUS_NAME%>"
        value="<%=fcStatus%>" />
    <impact:validateInput type="hidden"
        name="<%=YouthReportDetailConversation.RADIO_TANF_NAME%>"
        value="<%=tanf%>" />
    <impact:validateInput type="hidden"
        name="<%=YouthReportDetailConversation.RADIO_FOOD_STMP_NAME%>"
        value="<%=foodStamps%>" />
    <impact:validateInput type="hidden"
        name="<%=YouthReportDetailConversation.RADIO_PUB_HSG_NAME%>"
        value="<%=publicHsg%>" />

</impact:validateForm>
<%!
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
%>