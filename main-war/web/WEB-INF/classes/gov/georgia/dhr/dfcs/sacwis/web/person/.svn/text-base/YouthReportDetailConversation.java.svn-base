package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.person.YouthDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   06/18/09  wjcochran Added labels for comment boxes
 *   08/11/10  hnguyen   MR-067 Updated conversation to add new fields and
 *                       removed some fields that no longer in use.
 *   09/01/10  hnguyen   MR-067 Updated validation error message branch, display info message condition,
 *                       and commented out logic that remove state information after save and validation
 *                       error occurs
 *   09/09/10  hnguyen   MR-067 Moved survey label maps to jsp
 *   09/15/10  hnguyen   SMS#66384 Added logic to compared retrieved report person data 
 *                       against person current data, adding outcome foster care status
 *                       and population type.
 *   09/22/10  hnguyen   SMS#71814 Added labels for display on jsp and for 
 *                       validation to highlight field on page
 *   09/23/10  hnguyen   SMS#72519 Removed pre-population of not applicable survey question response
 *                       on save, also to disable N/A radio button if question is applicable. 
 *   10/04/10  schoi     SMS #74841 Updated code to check for Independent Living Program Coordinator (ILC) 
 *                       by job title                           
 * </pre>
 */
@SuppressWarnings("serial")
public class YouthReportDetailConversation extends BaseHiddenFieldStateConversation {
  private static final GrndsConfiguration config = GrndsConfiguration.getInstance();

  private static final String TRACE_TAG = "YouthReportDetailConversation";

  private static final String Y = ArchitectureConstants.Y;

  private static final String N = ArchitectureConstants.N;

  private static final String YOUTH_REPORT_DETAIL = "YouthReportDetail";

  private static final String YOUTH_REPORT_DETAIL_PAGE = "/person/YouthReportDetail/displayYouthReportDetail";

  // -- state attribute names
  private static final String CREQFUNCCD = "youthReportFuncCd";

  private static final String ID_YOUTH_REPORT = "youthReportID";

  public static final String RETRIEVE_SO_PERSON = "youthReportRetrieveSOPerson";

  public static final String RETRIEVE_SO_REPORT = "youthReportRetrieveSOReport";

  public static final String RETRIEVE_DT_RPT_PERIOD_END = "youthReportDtReportPeriodEnd";

  public static final String SURVEY_ERROR_LABEL_MAP = "surveyErrorLabelMap";

  public static final String EDIT_PERSON_FIELDS = "youthReportEditPersonFields";

  public static final String VALIDATION_CUSTOM_HTML = "customErrorHTML";

  public static final String VALIDATION_CUSTOM_INPUTS = "customErrorInputs";

  // -- commonly used values in JSP
  public static final String HTML_MARK_AS_REQUIRED = config.getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                        "validation.mark.as.required");

  public static final String HTML_MARK_AS_COND_REQUIRED = config
                                                                .getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                             "validation.mark.as.conditionally.required");

  public static final String HTML_LABEL_STYLE = config.getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                   "validation.label.style");

  public static final String HTML_ERROR_STYLE = "formLabelError";

  public static final String YES = "Yes";

  public static final String NO = "No";

  public static final String NA = "N/A";

  public static final String DECLINED = "Declined";

  public static final String DONT_KNOW = "Don't know";

  public static final String COMMENTS = "Comments";

  public static final String ACTIVE = "A";

  public static final String HIGH_SCHOOL_GED = "High School Diploma/GED";

  public static final String VOC_CERTIFICATE = "Vocational Certificate";

  public static final String VOC_LICENSE = "Vocational License";

  public static final String ASSOCIATE = "Associate's Degree (e.g., A.A.)";

  public static final String BACHELOR = "Bachelor's Degree (e.g., B.A. or B.S.)";

  public static final String HIGHER_DEGREE = "Higher Degree";

  public static final String NONE_ABOVE = "None of the above";

  // -- standard input/display names
  public static final String FORM_NAME = "frmYouthReportDetail";

  public static final String DT_END_REPORT_PERIOD_NAME = "dspDtEndReportPeriod";

  public static final String DT_DOB_NAME = "txtDtDOB";

  public static final String SEL_AGE_CLASS_NAME = "dspAgeClass";

  public static final String SEL_SEX_NAME = "selSex";

  public static final String CBG_RACE_NAME = "cbgRace_";

  public static final String SEL_ETHNICITY_NAME = "selEthnicity";

  public static final String RADIO_TRIBAL_NAME = "radTribal";

  public static final String RADIO_ADJ_DEL_NAME = "radAdjDelinquent";

  public static final String SEL_LAST_GRD_COMP_NAME = "selLastGradeComp";

  public static final String RADIO_SPC_ED_STAT_NAME = "radSpcEdStatus";

  public static final String RADIO_IL_NEEDS_ASM_NAME = "radILNeedsAsm";

  public static final String RADIO_ACAD_SUPP_NAME = "radAcadSupport";

  public static final String RADIO_PS_EDU_SUPP_NAME = "radPSEdSupport";

  public static final String RADIO_CAREER_PREP_NAME = "radCareerPrep";

  public static final String RADIO_EMP_PROG_VOC_NAME = "radEmpProgVoc";

  public static final String RADIO_BGT_FIN_MGT_NAME = "radBudgetMgt";

  public static final String RADIO_HOME_MGT_NAME = "radHomeMgt";

  public static final String RADIO_HLTH_ED_RP_NAME = "radHealthEd";

  public static final String RADIO_FAM_MARR_ED_NAME = "radFamilyMarrEd";

  public static final String RADIO_MENTORING_NAME = "radMentoring";

  public static final String RADIO_SUPER_IL_NAME = "radSuperIL";

  public static final String RADIO_ROOM_BRD_NAME = "radRoomBoard";

  public static final String RADIO_ED_FIN_ASST_NAME = "radEdFinAsst";

  public static final String RADIO_OTHER_FIN_NAME = "radOtherFinAsst";

  public static final String SEL_OUTCOME_STAT_NAME = "selOutcomeStatus";

  public static final String DT_OUTCOME_NAME = "txtDtOutcome";

  public static final String RADIO_FC_STATUS_NAME = "radFCStatus";

  public static final String RADIO_CURR_FTE_NAME = "radCurrFullTime";

  public static final String RADIO_CURR_PTE_NAME = "radCurrPartTime";

  public static final String RADIO_EMP_SKILLS_NAME = "radEmpRelSkills";

  public static final String RADIO_SS_NAME = "radSocialSecurity";

  public static final String RADIO_EDU_AID_NAME = "radEduAid";

  public static final String RADIO_TANF_NAME = "radTANF";

  public static final String RADIO_FOOD_STMP_NAME = "radFoodStamps";

  public static final String RADIO_PUB_HSG_NAME = "radPublicHousing";

  public static final String RADIO_OTH_INC_NAME = "radOtherIncome";

  public static final String RADIO_HECR_NAME = "radHighestEduCert";

  public static final String RADIO_CAE_NAME = "radCurrAttdEnr";

  public static final String RADIO_C2A_NAME = "radConnectToAdult";

  public static final String RADIO_MED_NAME = "radMedicaid";

  public static final String RADIO_OHIT_NAME = "radOtherHlthIns";

  public static final String RADIO_MEDICAL_NAME = "radHlthInsMedical";

  public static final String RADIO_MENTAL_NAME = "radHlthInsMental";

  public static final String RADIO_PRESCRIPTION_NAME = "radHlthInsPrescription";

  public static final String RADIO_HOME_NAME = "radHomelessness";

  public static final String RADIO_SAR_NAME = "radSubAbuseRef";

  public static final String RADIO_INC_NAME = "radIncarceration";

  public static final String RADIO_CHL_NAME = "radChildren";

  public static final String RADIO_MAB_NAME = "radMarrAtBirth";

  public static final String SAVE_BUTTON_NAME = "btnSave";

  public static final String RADIO_FC_ST_SVCS_NAME = "radFcStatSvc";

  public static final String NM_ENTERED_BY_NAME = "nmEnteredByName";

  public static final String IND_ENTERED_BY_YTH = "indEnteredByYth";

  // -- comment text area box names
  public static final String TEXT_ACAD_SUPP_COMM = "txtAcadSupport";

  public static final String TEXT_PS_EDU_SUPP_COMM = "txtPSEdSupport";

  public static final String TEXT_CAREER_PREP_COMM = "txtCareerPrep";

  public static final String TEXT_BGT_FIN_MGT_COMM = "txtBudgetMgt";

  public static final String TEXT_HLTH_ED_RP_COMM = "txtHealthEd";

  public static final String TEXT_MENTORING_COMM = "txtMentoring";

  public static final String TEXT_ROOM_BRD_COMM = "txtRoomBoard";

  public static final String TEXT_OTHER_FIN_COMM = "txtOtherFinAsst";

  public static final String TEXT_ED_FIN_ASST_COMM = "txtEduFinance";

  public static final String TEXT_EMP_PROG_VOC_COMM = "txtEmpProgVoc";

  public static final String TEXT_HOME_MGT_COMM = "txtHousingEdu";

  public static final String TEXT_FAM_MARR_ED_COMM = "txtFamMarrEdu";

  public static final String TEXT_SUPER_IL_COMM = "txtSuperIl";

  // -- labels
  public static final String LABEL_DOB = "Date of birth";

  public static final String LABEL_SEX = "Sex";

  public static final String LABEL_RACE = "Race";

  public static final String LABEL_ETHNICITY = "Ethnicity";

  public static final String LABEL_TRIBAL_MBR = "Tribal Membership";

  public static final String LABEL_LAST_GRD_COMP = "Last Grade Completed";

  public static final String LABEL_ADJ_DEL = "Adjudicated Delinquent";

  public static final String LABEL_SPC_ED_STAT = "Special Education Status";

  public static final String LABEL_IL_NEEDS_ASM = "Independent Living Needs (Life Skills) Assessment";

  public static final String LABEL_ACAD_SUPP = "Academic Support";

  public static final String LABEL_PS_EDU_SUPP = "Post Secondary Education Support";

  public static final String LABEL_CAREER_PREP = "Career Preparation";

  public static final String LABEL_EMP_PROG_VOC = "Employment Programs or Vocational Training";

  public static final String LABEL_BGT_FIN_MGT = "Budget and Finance Management";

  public static final String LABEL_HOME_MGT = "Housing Education and Home Management Training";

  public static final String LABEL_HLTH_ED_RP = "Health Education and Risk Prevention";

  public static final String LABEL_FAM_MARR_ED = "Family Support/Health Marriage Education";

  public static final String LABEL_MENTORING = "Mentoring";

  public static final String LABEL_SUPER_IL = "Supervised Independent Living (Transitional Indpt. Living)";

  public static final String LABEL_ROOM_BRD = "Room and Board Financial Assistance";

  public static final String LABEL_ED_FIN_ASST = "Education Financial Assistance";

  public static final String LABEL_OTHER_FIN = "Other Financial Assistance";

  public static final String LABEL_OUTCOME_STAT = "Outcomes Reporting Status";

  public static final String LABEL_DT_OUTCOME = "Outcome Date";

  public static final String LABEL_FC_STATUS = "Foster Care Status (Is DFCS responsible for placement, including for youth who have signed an agreement for Extended Youth Support Services?)";

  public static final String LABEL_FC_ST_SVCS = "Foster care status-services";

  // -- Survey labels
  public static final String LABEL_CURR_FTE = " 1) Currently are you employed full-time?";

  public static final String LABEL_CURR_PTE = " 2) Currently are you employed part-time?";

  public static final String LABEL_EMP_SKILLS = " 3) In the past year, did you complete an apprenticeship, "
                                                + "internship, or other on-the-job training, either paid or unpaid?";

  public static final String LABEL_SS = " 4) Currently are you receiving social security "
                                        + "payments (Supplemental Security Income(SSI), "
                                        + "Social Security Disability Insurance(SSDI), " + "or dependents' payments)?";

  public static final String LABEL_EDU_AID = " 5) Currently are you using a scholarship, grant, "
                                             + "stipend, student loan, voucher, or other "
                                             + "type of educational financial aid to cover "
                                             + "any educational expenses?";

  public static final String LABEL_OTH_INC = " 6) Currently are you receiving any periodic and/or "
                                             + "significant financial resources or support "
                                             + "from another source not previously indicated "
                                             + "and excluding paid employment?";

  public static final String LABEL_HECR = " 7) What is the highest educational degree or "
                                          + "certification that you have received?";

  public static final String LABEL_CAE = " 8) Currently are you enrolled in and attending "
                                         + "high school, GED classes, post-high school "
                                         + "vocational training, or college?";

  public static final String LABEL_C2A = " 9) Currently is there at least one adult in your "
                                         + "life, other than your caseworker, to whom "
                                         + "you can go for advice or emotional support?";

  public static final String LABEL_HOME_B = "10) Have you ever been homeless?";

  public static final String LABEL_HOME_F = "10) In the past two years, were you homeless at any time?";

  public static final String LABEL_SAR_B = "11) Have you ever referred yourself or has someone "
                                           + "else referred you for an alcohol or drug "
                                           + "abuse assessment or counseling?";

  public static final String LABEL_SAR_F = "11) In the past two years, did you refer yourself, "
                                           + "or had someone else referred you for an alcohol "
                                           + "or drug abuse assessment or counseling?";

  public static final String LABEL_INC_B = "12) Have you ever been confined in a jail, prison, "
                                           + "correctional facility, or juvenile or community "
                                           + "detention facility, in connection with allegedly "
                                           + "committing a crime?";

  public static final String LABEL_INC_F = "12) In the past two years, were you confined in a "
                                           + "jail, prison, correctional facility, or juvenile "
                                           + "or community detention facility, in connection "
                                           + "with allegedly committing a crime?";

  public static final String LABEL_CHL_B = "13) Have you ever given birth or fathered any "
                                           + "children that were born?";

  public static final String LABEL_CHL_F = "13) In the past two years, did you give birth to or "
                                           + "father any children that were born?";

  public static final String LABEL_MAB = "14) If you responded yes to the previous question, "
                                         + "were you married to the child's other "
                                         + "parent at the time each child was born?";

  public static final String LABEL_MEDICAID = "15) Currently are you on Medicaid?";

  public static final String LABEL_OHIT = "16) Currently do you have health insurance, other than Medicaid?";

  public static final String LABEL_MEDICAL = "16a) Does your health insurance include coverage for medical services?";

  public static final String LABEL_MENTAL = "16b) Does your health insurance include coverage for mental health services?";

  public static final String LABEL_PRESCRIPTION = "16c) Does your health insurance include coverage for prescription drugs?";

  public static final String LABEL_TANF = "17) Currently are you receiving ongoing (TANF) welfare "
                                          + "payments from the government to support your basic needs?";

  public static final String LABEL_FOOD_STMP = "18) Currently are you receiving public food "
                                               + "assistance (Food Stamps)?";

  public static final String LABEL_PUB_HSG = "19) Currently are you receiving any sort of housing "
                                             + "assistance from the government, such "
                                             + "as living in public housing or receiving a housing voucher?";

  // -- Survey Error labels
  public static final String LABEL_CURR_FTE_ERROR = "Question #1";

  public static final String LABEL_CURR_PTE_ERROR = "Question #2";

  public static final String LABEL_EMP_SKILLS_ERROR = "Question #3";

  public static final String LABEL_SS_ERROR = "Question #4";

  public static final String LABEL_EDU_AID_ERROR = "Question #5";

  public static final String LABEL_OTH_INC_ERROR = "Question #6";

  public static final String LABEL_HECR_ERROR = "Question #7";

  public static final String LABEL_CAE_ERROR = "Question #8";

  public static final String LABEL_C2A_ERROR = "Question #9";

  public static final String LABEL_HOME_ERROR = "Question #10";

  public static final String LABEL_SAR_ERROR = "Question #11";

  public static final String LABEL_INC_ERROR = "Question #12";

  public static final String LABEL_CHL_ERROR = "Question #13";

  public static final String LABEL_MAB_ERROR = "Question #14";

  public static final String LABEL_MEDICAID_ERROR = "Question #15";

  public static final String LABEL_OHIT_ERROR = "Question #16";

  public static final String LABEL_MEDICAL_ERROR = "Question #16a";

  public static final String LABEL_MENTAL_ERROR = "Question #16b";

  public static final String LABEL_PRESCRIPTION_ERROR = "Question #16c";

  public static final String LABEL_TANF_ERROR = "Question #17";

  public static final String LABEL_FOOD_STMP_ERROR = "Question #18";

  public static final String LABEL_PUB_HSG_ERROR = "Question #19";

  public static final String HDN_CD_POPULATION_TYPE = "hdnCdPopulationType";

  public static final String POPULATION_TYPE_SERVED = "S";

  public static final String POPULATION_TYPE_BASELINE = "B";

  public static final String POPULATION_TYPE_FOLLOW_UP = "F";

  private Person person;
  
  public void setPerson(Person person) {
    this.person = person;
  }
  
  public void displayReportDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".displayReportDetail_xa()");
    pt.enterScope();

    HttpServletRequest request = context.getRequest();
    clearCustomErrorMessages(request);
    YouthReportDetailRetrieveSI si = populateRetrieveSI(request, true);
    YouthReportDetailRetrieveSO so = null;
    try {
      so = person.retrieveYouthReportDetail(si);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    setRetrieveSOPerson(request, so.getPerson());
    setRetrieveSOReport(request, so.getReport());
    
    setFunctionCode(request, ServiceConstants.REQ_FUNC_CD_UPDATE);
    if (isPageModeModify(request, so.getPerson().getCdPersonActiveStatus(), so.getReport().getDtRptPeriodEnd())) {
      YouthReportDetailRetrieveSOPerson soPerson = so.getPerson();
      YouthReportDetailRetrieveSOReport soReport = so.getReport();
      
      if (!soPerson.getCdAgeClass().equals(soReport.getCdAgeClass())
          || !soPerson.getCdEthinicity().equals(soReport.getCdEthinicity())
          || !soPerson.getCdLastGradeComp().equals(soReport.getCdLastGradeComp())
          || !soPerson.getCdSex().equals(soReport.getCdSex())
          || !soPerson.getDtDob().equals(soReport.getDtDob())
          || !soPerson.getIndAdjDelinquent().equals(soReport.getIndAdjDelinquent())
          || !soPerson.getIndFcStatSvcs().equals(soReport.getIndFcStatSvcs())
          || !soPerson.getIndTribalMbr().equals(soReport.getIndTribalMbr())
          || !soPerson.getIndSpcEduStat().equals(soReport.getIndSpecEdu())
          || !soPerson.getRaces().containsAll(soReport.getRaces())
          || !soPerson.getIndFcStatOutcome().equals(soReport.getIndFcStatOutcome())
          || !soPerson.getCdPopulationType().equals(soReport.getCdPopulationType())) {
        setInformationalMessage(Messages.MSG_CMN_YDP_UPDATE, request);
      }
    }

    Date dtRptPeriodEnd = NytdHelper.getDtRptPeriodEnd();
    setRptPeriodEnd(request, dtRptPeriodEnd);

    pt.getTotalTime();
    pt.exitScope();
  }

  @SuppressWarnings("deprecation")
  public void addReportDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".addReportDetail_xa()");
    pt.enterScope();

    HttpServletRequest request = context.getRequest();
    clearCustomErrorMessages(request);
    setFunctionCode(request, ServiceConstants.REQ_FUNC_CD_ADD);

    YouthReportDetailRetrieveSI si = populateRetrieveSI(request, false);
    YouthReportDetailRetrieveSO so = null;
    try {
      so = person.retrieveYouthReportDetail(si);
    } catch (ServiceException se ){
      handleException(se, context);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    setRetrieveSOPerson(request, so.getPerson());
    setRetrieveSOReport(request, so.getReport());

    Date dtRptPeriodEnd = NytdHelper.getDtRptPeriodEnd();
    setRptPeriodEnd(request, dtRptPeriodEnd);

    determinePageMode(request, so.getPerson().getCdPersonActiveStatus(), dtRptPeriodEnd);

    pt.getTotalTime();
    pt.exitScope();
  }

  public void saveReportDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".saveReportDetail_xa()");
    pt.enterScope();

    YouthReportDetailSaveSI si = populateSaveSI(context.getRequest());
    try {
      person.saveYouthReportDetail(si);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    Date dtRptPeriodEnd = NytdHelper.getDtRptPeriodEnd();
    setRptPeriodEnd(context.getRequest(), dtRptPeriodEnd);

    pt.getTotalTime();
    pt.exitScope();
  }

  private YouthReportDetailRetrieveSI populateRetrieveSI(HttpServletRequest request, boolean includeReportId) {
    YouthReportDetailRetrieveSI retrieveSI = new YouthReportDetailRetrieveSI();

    retrieveSI.setIdPerson(GlobalData.getUlIdPerson(request));
    if (includeReportId) {
      int idYouthReportDtl = ContextHelper.getIntSafe(request, "hdnReportId"); // -- from Youth Detail
      retrieveSI.setSzScreenName(YOUTH_REPORT_DETAIL);
      retrieveSI.setIdYouthReportDtl(idYouthReportDtl);
      BaseSessionStateManager state = getSessionStateManager(request);
      state.setAttribute(ID_YOUTH_REPORT, idYouthReportDtl, request);
    }

    return retrieveSI;
  }

  private YouthReportDetailSaveSI populateSaveSI(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    String cReqFuncCd = (String) state.getAttribute(CREQFUNCCD, request);

    YouthReportDetailSaveSI si = new YouthReportDetailSaveSI(cReqFuncCd);
    si.setSzScreenName(YOUTH_REPORT_DETAIL);
    Integer idYouthReportDtl = (Integer) state.getAttribute(ID_YOUTH_REPORT, request);
    si.setIdYouthReportDtl(idYouthReportDtl != null ? idYouthReportDtl : 0);

    si.setIdPerson(GlobalData.getUlIdPerson(request));
    si.setDtRptPeriodEnd(ContextHelper.getJavaDateSafe(request, DT_END_REPORT_PERIOD_NAME));

    // -- dates
    si.setDtDob(ContextHelper.getJavaDateSafe(request, DT_DOB_NAME));
    si.setDtOutcomeDate(ContextHelper.getJavaDateSafe(request, DT_OUTCOME_NAME));

    // -- direct strings
    si.setCdAgeClass(ContextHelper.getStringSafe(request, SEL_AGE_CLASS_NAME));
    si.setCdEthinicity(ContextHelper.getStringSafe(request, SEL_ETHNICITY_NAME));
    si.setCdFoodStamps(ContextHelper.getStringSafe(request, RADIO_FOOD_STMP_NAME));
    si.setCdHighEdu(ContextHelper.getStringSafe(request, RADIO_HECR_NAME));
    si.setCdHousingAst(ContextHelper.getStringSafe(request, RADIO_PUB_HSG_NAME));
    si.setCdLastGradeComp(ContextHelper.getStringSafe(request, SEL_LAST_GRD_COMP_NAME));
    
    si.setCdMarrAtBirth(ContextHelper.getStringSafe(request, RADIO_MAB_NAME));
    
    si.setCdTanf(ContextHelper.getStringSafe(request, RADIO_TANF_NAME));
    si.setCdFoodStamps(ContextHelper.getStringSafe(request, RADIO_FOOD_STMP_NAME));
    si.setCdHousingAst(ContextHelper.getStringSafe(request, RADIO_PUB_HSG_NAME));

    si.setCdOthHlthInsTyp(ContextHelper.getStringSafe(request, RADIO_OHIT_NAME));
    si.setCdHlthInsMedical(ContextHelper.getStringSafe(request, RADIO_MEDICAL_NAME));
    si.setCdHlthInsMental(ContextHelper.getStringSafe(request, RADIO_MENTAL_NAME));
    si.setCdHlthInsPrescription(ContextHelper.getStringSafe(request, RADIO_PRESCRIPTION_NAME));

    si.setCdOutcomeRptStat(ContextHelper.getStringSafe(request, SEL_OUTCOME_STAT_NAME));
    si.setCdSex(ContextHelper.getStringSafe(request, SEL_SEX_NAME));
    si.setCdTanf(ContextHelper.getStringSafe(request, RADIO_TANF_NAME));
    si.setIndAcadSupport(ContextHelper.getStringSafe(request, RADIO_ACAD_SUPP_NAME));
    si.setIndAdjDelinquent(ContextHelper.getStringSafe(request, RADIO_ADJ_DEL_NAME));
    si.setIndBdgtFinMgt(ContextHelper.getStringSafe(request, RADIO_BGT_FIN_MGT_NAME));
    si.setIndCareerPrep(ContextHelper.getStringSafe(request, RADIO_CAREER_PREP_NAME));
    si.setCdChildren(ContextHelper.getStringSafe(request, RADIO_CHL_NAME));
    si.setCdConnAdult(ContextHelper.getStringSafe(request, RADIO_C2A_NAME));
    si.setCdCurrAtdEnr(ContextHelper.getStringSafe(request, RADIO_CAE_NAME));
    si.setCdCurrFtEmp(ContextHelper.getStringSafe(request, RADIO_CURR_FTE_NAME));
    si.setCdCurrPtEmp(ContextHelper.getStringSafe(request, RADIO_CURR_PTE_NAME));
    si.setCdEducAid(ContextHelper.getStringSafe(request, RADIO_EDU_AID_NAME));
    si.setIndEduFinance(ContextHelper.getStringSafe(request, RADIO_ED_FIN_ASST_NAME));
    si.setIndEmpProgVoc(ContextHelper.getStringSafe(request, RADIO_EMP_PROG_VOC_NAME));
    si.setCdEmpSkills(ContextHelper.getStringSafe(request, RADIO_EMP_SKILLS_NAME));
    si.setIndFamMarrEdu(ContextHelper.getStringSafe(request, RADIO_FAM_MARR_ED_NAME));
    si.setIndFcStatOutcome(ContextHelper.getStringSafe(request, RADIO_FC_STATUS_NAME));
    si.setIndHealthEdu(ContextHelper.getStringSafe(request, RADIO_HLTH_ED_RP_NAME));
    si.setCdHomeless(ContextHelper.getStringSafe(request, RADIO_HOME_NAME));
    si.setIndHousingEdu(ContextHelper.getStringSafe(request, RADIO_HOME_MGT_NAME));
    si.setIndIlNeedsAsm(ContextHelper.getStringSafe(request, RADIO_IL_NEEDS_ASM_NAME));
    si.setCdIncarceration(ContextHelper.getStringSafe(request, RADIO_INC_NAME));
    si.setCdMedicaid(ContextHelper.getStringSafe(request, RADIO_MED_NAME));
    si.setIndMentoring(ContextHelper.getStringSafe(request, RADIO_MENTORING_NAME));
    si.setIndOthFinance(ContextHelper.getStringSafe(request, RADIO_OTHER_FIN_NAME));
    si.setCdOthSupport(ContextHelper.getStringSafe(request, RADIO_OTH_INC_NAME));
    si.setIndPsEduSupport(ContextHelper.getStringSafe(request, RADIO_PS_EDU_SUPP_NAME));
    si.setIndRoomBrdFin(ContextHelper.getStringSafe(request, RADIO_ROOM_BRD_NAME));
    si.setCdSocialSec(ContextHelper.getStringSafe(request, RADIO_SS_NAME));
    si.setIndSpcEduStat(ContextHelper.getStringSafe(request, RADIO_SPC_ED_STAT_NAME));
    si.setCdSubAbuseRef(ContextHelper.getStringSafe(request, RADIO_SAR_NAME));
    si.setIndSuperIl(ContextHelper.getStringSafe(request, RADIO_SUPER_IL_NAME));
    si.setIndTribalMbr(ContextHelper.getStringSafe(request, RADIO_TRIBAL_NAME));
    si.setIndFcStatSvcs(ContextHelper.getStringSafe(request, RADIO_FC_ST_SVCS_NAME));

    // -- comments
    si.setTxtAcadSupport(ContextHelper.getStringSafe(request, TEXT_ACAD_SUPP_COMM));
    si.setTxtBdgtFinMgt(ContextHelper.getStringSafe(request, TEXT_BGT_FIN_MGT_COMM));
    si.setTxtCareerPrep(ContextHelper.getStringSafe(request, TEXT_CAREER_PREP_COMM));
    si.setTxtHealthEdu(ContextHelper.getStringSafe(request, TEXT_HLTH_ED_RP_COMM));
    si.setTxtMentoring(ContextHelper.getStringSafe(request, TEXT_MENTORING_COMM));
    si.setTxtOthFinance(ContextHelper.getStringSafe(request, TEXT_OTHER_FIN_COMM));
    si.setTxtPsEduSupport(ContextHelper.getStringSafe(request, TEXT_PS_EDU_SUPP_COMM));
    si.setTxtRmBrdFin(ContextHelper.getStringSafe(request, TEXT_ROOM_BRD_COMM));
    si.setTxtEmpProgVoc(ContextHelper.getStringSafe(request, TEXT_EMP_PROG_VOC_COMM));
    si.setTxtHousingEdu(ContextHelper.getStringSafe(request, TEXT_HOME_MGT_COMM));
    si.setTxtFamMarrEdu(ContextHelper.getStringSafe(request, TEXT_FAM_MARR_ED_COMM));
    si.setTxtSuperIl(ContextHelper.getStringSafe(request, TEXT_SUPER_IL_COMM));
    si.setTxtEduFinance(ContextHelper.getStringSafe(request, TEXT_ED_FIN_ASST_COMM));

    si.setCdPopulationType(ContextHelper.getStringSafe(request, HDN_CD_POPULATION_TYPE));

    UserProfile user = UserProfileHelper.getUserProfile(request);

    si.setNmEnteredByName(user.getUserFullName());

    // -- create raceMap from race checkboxes
    Map<String, String> raceMap = new HashMap<String, String>();
    List<String> raceCodes = Arrays.asList(CheckboxHelper.getCheckedValues(request, CBG_RACE_NAME));
    Collection<String> allRaceCodes = null;
    try {
      allRaceCodes = Lookup.getCategoryCodesCollection(CodesTables.CRACE);
    } catch (LookupException le) {
      // -- don't handle; if LookupData has not been initialized, the custom tag fails on JSP
    }
    if (allRaceCodes != null) {
      for (String code : allRaceCodes) {
        String value = raceCodes.contains(code) ? Y : N;
        raceMap.put(code, value);
      }
    }
    si.setRaceMap(raceMap);

    if (raceMap != null) {
      si.setIndRaceAmerIndian(raceMap.get(CodesTables.CRACE_AA));
      si.setIndRaceAsian(raceMap.get(CodesTables.CRACE_AN));
      si.setIndRaceBlack(raceMap.get(CodesTables.CRACE_BK));
      si.setIndRacePacIslander(raceMap.get(CodesTables.CRACE_HP));
      si.setIndRaceUnknown(raceMap.get(CodesTables.CRACE_UD));
      si.setIndRaceWhite(raceMap.get(CodesTables.CRACE_WT));
      si.setIndRaceDeclined("N"); // this will always be "N"
    }

    return si;
  }

  private void setRetrieveSOPerson(HttpServletRequest request, YouthReportDetailRetrieveSOPerson soPerson) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(RETRIEVE_SO_PERSON, request);
    state.setAttribute(RETRIEVE_SO_PERSON, soPerson, request);
  }

  private void setRetrieveSOReport(HttpServletRequest request, YouthReportDetailRetrieveSOReport soReport) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(RETRIEVE_SO_REPORT, request);
    state.setAttribute(RETRIEVE_SO_REPORT, soReport, request);
  }

  private void setRptPeriodEnd(HttpServletRequest request, Date dtRptPeriodEnd) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(RETRIEVE_DT_RPT_PERIOD_END, request);
    state.setAttribute(RETRIEVE_DT_RPT_PERIOD_END, dtRptPeriodEnd, request);
  }

  private void setFunctionCode(HttpServletRequest request, String cReqFuncCd) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(CREQFUNCCD, request);
    state.setAttribute(CREQFUNCCD, cReqFuncCd, request);
  }

  private void setEditPersonFields(HttpServletRequest request, boolean editable) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(EDIT_PERSON_FIELDS, request);
    state.setAttribute(EDIT_PERSON_FIELDS, editable, request);
  }

  private void removeStateAttributes(HttpServletRequest request, boolean all) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(RETRIEVE_SO_REPORT, request);
    if (all) {
      state.removeAttribute(CREQFUNCCD, request);
      state.removeAttribute(RETRIEVE_SO_PERSON, request);
      state.removeAttribute(RETRIEVE_DT_RPT_PERIOD_END, request);
      state.removeAttribute(EDIT_PERSON_FIELDS, request);
      state.removeAttribute(ID_YOUTH_REPORT, request);
    }
  }

  private void clearCustomErrorMessages(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    state.removeAttribute(VALIDATION_CUSTOM_HTML, request);
    state.removeAttribute(VALIDATION_CUSTOM_INPUTS, request);
  }

  private String determinePageMode(HttpServletRequest request, String cdPersonActiveStatus, Date dtRptPeriodEnd) {
    // -- if user is YDP coordinator, pageMode is MODIFY
    // -- else, MODIFY only for case managers of active case for current reporting period records
    String pageMode = PageModeConstants.VIEW;

    Date dtRptPeriodBegin = NytdHelper.getDtRptPeriodBegin(dtRptPeriodEnd);
    Date today = new Date();

    // SMS #74841 
    // Check Independent Living Program Coordinator (ILC) by job title of 'ILC'
    boolean isEmpClassILC = false;
    
    BaseSessionStateManager state = getSessionStateManager(request);
    YouthDetailRetrieveSO so = (YouthDetailRetrieveSO) state.getAttribute("YOUTH_DETAIL", request);
    if(so != null) {
      isEmpClassILC = so.getIsUserEmpClassILC();
    }
    
    if ((YouthDetailConversation.isUserYDPCoordinator(request) || isEmpClassILC)
        && ((today.compareTo(dtRptPeriodBegin) >= 0 && today.compareTo(dtRptPeriodEnd) <= 0)
                        || NytdHelper.isInGracePeriod(dtRptPeriodEnd, 45)
                        )) {
      // ILP Coordinator and current date is within reporting period
      pageMode = PageModeConstants.MODIFY;
    } else if (!YouthDetailConversation.isUserYDPCoordinator(request) 
               && !isEmpClassILC     
               && YouthDetailConversation.hasStageAccess(request)
               && ((today.compareTo(dtRptPeriodBegin) >= 0 && today.compareTo(dtRptPeriodEnd) <= 0)
                               || NytdHelper.isInGracePeriod(dtRptPeriodEnd, 45)
                               )
               && CodesTables.CPERSTAT_A.equals(cdPersonActiveStatus)) {
      // This scenario for assigned CM of active youth in a case
      pageMode = PageModeConstants.MODIFY;
    }

    // -- special retrieved fields: if MODIFY from above, make special fields editable only
    // -- when person is not in a case (inactive) and user is YDPCoordinator
    if (PageModeConstants.MODIFY.equals(pageMode) && CodesTables.CPERSTAT_I.equals(cdPersonActiveStatus)
        && (YouthDetailConversation.isUserYDPCoordinator(request) || isEmpClassILC)) {
      setEditPersonFields(request, true);
    }

    PageMode.setPageMode(pageMode, request);
    return pageMode;
  }

  private boolean isPageModeModify(HttpServletRequest request, String cdPersonActiveStatus, Date dtRptPeriodEnd) {
    return PageModeConstants.MODIFY.equals(determinePageMode(request, cdPersonActiveStatus, dtRptPeriodEnd));
  }

  /**
   * This method is called by the other methods when an exception is caught.
   * 
   * @param context
   *                The GrndsExchangeContext object.
   * @param e
   *                The Exception
   * @param methodName
   *                A String containing the method which threw the exception
   */
  private void handleException(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    case Messages.MSG_CMN_YDP_DEATH:
    case Messages.MSG_CMN_YDP_RUNAWAY:
      setPresentationBranch("error", context );
      setErrorMessage(we.getErrorCode(), request);
      break;
    default:
      if (we.getErrorCode() != 0) {
        setErrorMessage(we.getErrorCode(), request);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
      break;
    }
  }
}
