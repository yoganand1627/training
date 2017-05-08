package gov.georgia.dhr.dfcs.sacwis.web.person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;

import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.YouthReportDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOPerson;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailRetrieveSOReport;
import gov.georgia.dhr.dfcs.sacwis.structs.output.YouthReportDetailSaveSO;

/**
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 08/09/10  hnguyen           SMS#66384 MR-067: Conversation creation
 * 09/01/10  hnguyen           SMS#66384 MR-67 Updated populateYouthReportDetailSaveSI method to include performance trace
 * 09/02/10  hnguyen           SMS#66384 MR-67 Added method to check for unanswered survey question after save
 * 09/14/10  hnguyen           SMS#66384 MR-067 Update populateYouthReportDetailSaveSI to set N/A response for hlth question
 *                             if it does apply to youth.
 * 09/17/10  hnguyen           SMS#71396 MR-67 Updated display survey unavailable based on youth population at current time
 *                             rather than based on previously saved population type.
 * 09/23/10  hnguyen           SMS#72516 Corrected some HTML incompatible characters and grammer.
 * 09/29/10  hnguyen           SMS#74128 Set save SI with youth current population type and foster care status to resolve issue with
 *                             question 17-19 not saving when CM/ILC changes youth foster care status after YRD is created.
 * </pre>
 */
public class PortalSurveyDetailConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "PortalSurveyDetailConversation";

  private static final GrndsConfiguration config = GrndsConfiguration.getInstance();

  private static final String Y = ArchitectureConstants.Y;

  private static final String N = ArchitectureConstants.N;

  private static final String PORTAL_SURVEY_DETAIL = "PortalSurveyDetail";

  private static final String PORTAL_SURVEY_DETAIL_PAGE = "/person/PortalSurveyDetail/displayPortalSurveyDetail";

  private List<String> varInputs = new ArrayList<String>();

  private Person person = null;

  private YouthReportDetailRetrieveSI youthReportDetailRetrieveSI = null;

  private YouthReportDetailRetrieveSO youthReportDetailRetrieveSO = null;

  private YouthReportDetailRetrieveSOPerson youthReportDetailRetrieveSOPerson = null;

  private YouthReportDetailRetrieveSOReport youthReportDetailRetrieveSOReport = null;

  private YouthReportDetailSaveSI youthReportDetailSaveSI = null;

  private YouthReportDetailSaveSO youthReportDetailSaveSO = null;

  // -- state attribute names
  public static final String CREQFUNCCD = "youthReportFuncCd";

  public static final String ID_YOUTH_REPORT = "youthReportID";

  public static final String RETRIEVE_SO_PERSON = "youthReportRetrieveSOPerson";

  public static final String RETRIEVE_SO_REPORT = "youthReportRetrieveSOReport";

  public static final String RETRIEVE_DT_RPT_PERIOD_END = "youthReportDtReportPeriodEnd";

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

  public static final String HTML_INFO_STYLE = "formLabelInfo";

  public static final String YES = "Yes";

  public static final String NO = "No";

  public static final String DONT_KNOW = "Don't know";

  public static final String DECLINED = "Declined";

  public static final String HIGH_SCHOOL_GED = "High School Diploma/GED";

  public static final String VOC_CERTIFICATE = "Vocational Certificate";

  public static final String VOC_LICENSE = "Vocational License";

  public static final String ASSOCIATE = "Associate's Degree (e.g., A.A.)";

  public static final String BACHELOR = "Bachelor's Degree (e.g., B.A. or B.S.)";

  public static final String HIGHER_DEGREE = "Higher Degree";

  public static final String NONE_ABOVE = "None of the above";

  // -- standard input/display names
  public static final String FORM_NAME = "frmPortalSurveyDetail";

  public static final String SAVE_BUTTON_NAME = "btnSave";

  // -- input fields name
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

  public static final String RADIO_MEDICAID_NAME = "radMedicaid";

  public static final String RADIO_OHIT_NAME = "radOtherHlthIns";

  public static final String RADIO_MEDICAL_NAME = "radHlthInsMedical";

  public static final String RADIO_MENTAL_NAME = "radHlthInsMental";

  public static final String RADIO_PRESCRIPTION_NAME = "radHlthInsPrescription";

  public static final String RADIO_HOME_NAME = "radHomelessness";

  public static final String RADIO_SAR_NAME = "radSubAbuseRef";

  public static final String RADIO_INC_NAME = "radIncarceration";

  public static final String RADIO_CHL_NAME = "radChildren";

  public static final String RADIO_MAB_NAME = "radMarrAtBirth";

  // -- hidden fields names
  public static final String HDN_POPULATION_TYPE = "hdnCdPopulationType";

  public static final String HDN_FC_STATUS = "hdnFosterCareStatOutcome";

  // -- labels
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
                                          + "payments from the government to support " + "your basic needs?";

  public static final String LABEL_FOOD_STMP = "18) Currently are you receiving public food "
                                               + "assistance (Food Stamps)?";

  public static final String LABEL_PUB_HSG = "19) Currently are you receiving any sort of housing "
                                             + "assistance from the government, such "
                                             + "as living in public housing or receiving a " + "housing voucher?";

  // Survey Descriptions
  public static final String CURR_FTE_DESC = "\"Full-time\" means working at least 35 hours per week at one or multiple jobs.";

  public static final String CURR_PTE_DESC = "\"Part-time\" means working at least 1-34 hours per week at one or multiple jobs.";

  public static final String EMP_SKILLS_DESC = "This means apprenticeships, internships, or other on-the-job trainings, either paid or unpaid, that helped you acquire employment related skills (which can include specific trade skills such as carpentry or auto mechanics, or office skills such as word processing or use of office equipment).";

  public static final String SS_DESC = "These are payments from the government to meet basic needs for food, clothing, and shelter for you if you have a disability. You may be receiving these payments because of a parent or guardian's disability, rather than your own.";

  public static final String EDU_AID_DESC = "Scholarships, grants, and stipends are funds awarded for spending on expenses related to gaining an education. \"Student loan\" means a government-guaranteed, low-interest loan for students in post-secondary education.";

  public static final String TANF_DESC = "This refers to ongoing welfare payments from the government to support your basic needs. Do not consider payments or subsidies for specific purposes, such as unemployment insurance, child care subsidies, education assistance, food stamps or housing assistance in this category.";

  public static final String FOOD_STMP_DESC = "Public food assistance includes food stamps, which are government-issued coupons or debit cards that you can use to buy eligible food at authorized stores. Public food assistance also includes assistance from the Women, Infants and Children (WIC) program.";

  public static final String PUB_HSG_DESC = "Public housing is rental housing provided by the government to keep rents affordable for eligible individuals and families, and a housing voucher allows participants to choose their own housing while the government pays part of the housing costs. This does not include payments from the child welfare agency for room and board payments.";

  public static final String OTH_INC_DESC = "This means periodic and/or significant financial support from a spouse or family member (biological, foster or adoptive), child support that you receive or funds from a legal settlement. This does not include occasional gifts, such as birthday or graduation checks or small donations of food or personal incidentals, child care subsidies, child support for your child or other financial help that does not benefit you directly in supporting yourself.";

  public static final String HECR_DESC = "\"Vocational certificate\" means a document stating that you have received education or training that qualifies you for a particular job, e.g., auto mechanics or cosmetology. \"Vocational license\" means a document that indicates that the state or local government recognizes an individual as a qualified professional in a particular trade or business. An Associate's degree is generally a two-year degree from a community college, and a Bachelor's degree is a four-year degree from a college or university. \"Higher degree\" indicates a graduate degree, such as a Masters or Doctorate degree. \"None of the above\" means that you have not received any of the above educational certifications.";

  public static final String CAE_DESC = "This means both enrolled in and attending high school, GED classes, or post-secondary vocational training or college. You are still considered enrolled in and attending school if you would otherwise be enrolled in and attending a school that is currently out of session (e.g., Spring break, summer vacation, etc.).";

  public static final String C2A_DESC = "This refers to an adult who you can go to for advice or guidance when there is a decision to make or a problem to solve, or for companionship to share personal achievements. This can include, but is not limited to, adult relatives, parents or foster parents. The definition excludes spouses, partners, boyfriends or girlfriends and current caseworkers. The adult must be easily accessible to you, either by telephone or in person.";

  public static final String MEDICAID_DESC = "Medicaid is a health insurance program funded by the government.";

  public static final String OHIT_DESC = "\"Health insurance\" means having a third party pay for all or part of health care. You  might have health insurance such as group coverage offered by employers or schools, or individual policies that cover medical and/or mental health care and/or prescription drugs, or you might be covered under your parents' insurance. This also could include access to free health care through a college, Indian Tribe, or other source.";

  public static final String MEDICAL_DESC = "This means that your health insurance covers at least some medical services or procedures.";

  public static final String MENTAL_DESC = "This means that your health insurance covers at least some mental health services. ";

  public static final String PRESCRIPTION_DESC = "This means that your health insurance covers at least some drugs your doctor ordered for you.";

  public static final String HOME_DESC = "\"Homeless\" means that you had no regular or adequate place to live. This includes living in a car, or on the street, or staying in a homeless or other temporary shelter.";

  public static final String SAR_DESC = "This includes either self-referring or being referred by a social worker, school staff, physician, mental health worker, foster parent, or other adult for an alcohol or drug abuse assessment or counseling. Alcohol or drug abuse assessment is a process designed to determine if someone has a problem with alcohol or drug use.";

  public static final String INC_DESC = "This means that you were confined in a jail, prison, correctional facility, or juvenile or community detention facility in connection with a crime (misdemeanor or felony) allegedly committed by you.";

  public static final String CHL_DESC = "This means giving birth to or fathering at least one child that was born. If you are a male and do not know if you have fathered a child, answer \"No.\"";

  public static final String MAB_DESC = "This means that when every child was born you were married to the other parent of the child.";

  public static final String POPULATION_TYPE_SERVED = "S";

  public static final String POPULATION_TYPE_BASELINE = "B";

  public static final String POPULATION_TYPE_FOLLOW_UP = "F";
  
  public void setPerson(Person person) {
    this.person = person;
  }

  public void setYouthReportDetailRetrieveSI(YouthReportDetailRetrieveSI youthReportDetailRetrieveSI) {
    this.youthReportDetailRetrieveSI = youthReportDetailRetrieveSI;
  }

  public void setYouthReportDetailRetrieveSO(YouthReportDetailRetrieveSO youthReportDetailRetrieveSO) {
    this.youthReportDetailRetrieveSO = youthReportDetailRetrieveSO;
  }

  public void setYouthReportDetailRetrieveSOPerson(YouthReportDetailRetrieveSOPerson youthReportDetailRetrieveSOPerson) {
    this.youthReportDetailRetrieveSOPerson = youthReportDetailRetrieveSOPerson;
  }

  public void setYouthReportDetailRetrieveSOReport(YouthReportDetailRetrieveSOReport youthReportDetailRetrieveSOReport) {
    this.youthReportDetailRetrieveSOReport = youthReportDetailRetrieveSOReport;
  }

  public void setYouthReportDetailSaveSI(YouthReportDetailSaveSI youthReportDetailSaveSI) {
    this.youthReportDetailSaveSI = youthReportDetailSaveSI;
  }

  public void setYouthReportDetailSaveSO(YouthReportDetailSaveSO youthReportDetailSaveSO) {
    this.youthReportDetailSaveSO = youthReportDetailSaveSO;
  }

  /**
   * \ *
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayPortalSurveyDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPortalSurveyDetail_xa()");
    performanceTrace.enterScope();

    try {
      // Get the state and request objects, if necessary.
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      YouthReportDetailRetrieveSI si = populateYouthReportDetailRetrieveSI(request);
      YouthReportDetailRetrieveSO so = new YouthReportDetailRetrieveSO();

      so = person.retrieveYouthReportDetail(si);

      String cdPopulationType = so.getPerson().getCdPopulationType();
      // if not( baseline or followup population and within survey period)
      if ((!(POPULATION_TYPE_BASELINE.equals(cdPopulationType) 
                      || POPULATION_TYPE_FOLLOW_UP.equals(cdPopulationType)) 
                      || !NytdHelper.isDuringSurveyPeriod(so.getPerson().getDtDob()))) {
        setInformationalMessage(Messages.MSG_SURVEY_UNAVAILABLE, PORTAL_SURVEY_DETAIL_PAGE, request);
      } else {
        // set parameterized messages
        String msg_est_close = MessageLookup.getMessageByNumber(Messages.MSG_SURVEY_EST_CLOSE);
        String msg_comp_est_close = MessageLookup.getMessageByNumber(Messages.MSG_SURVEY_COMP_EST_CLOSE);

        Date dob = so.getPerson().getDtDob();
        Date dtRptPeriodEnd = so.getReport().getDtRptPeriodEnd();
        java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG);

        int daysLeft = NytdHelper.getNumDaysLeft(dob);
        Date dtSurveyEnd = NytdHelper.getCurrentSurveyPeriodEnd(dob);
        String szSurveyEnd = df.format(dtSurveyEnd);

        msg_est_close = MessageLookup.addMessageParameter(msg_est_close, daysLeft);
        msg_est_close = MessageLookup.addMessageParameter(msg_est_close, szSurveyEnd);

        msg_comp_est_close = MessageLookup.addMessageParameter(msg_comp_est_close, daysLeft);
        msg_comp_est_close = MessageLookup.addMessageParameter(msg_comp_est_close, szSurveyEnd);

        if (so.getReport().getIdYouthReportDetail() == 0) {
          // Set initial messages here on first unsaved display
          setInformationalMessage(Messages.MSG_SURVEY_EST_TIME, request);
          setInformationalMessage(msg_est_close, request);
        } else {
          // Set post-saved messages
          if (so.getReport().getIndSurveyCompleted()) {
            setInformationalMessage(msg_comp_est_close, request);
          } else {
            setInformationalMessage(msg_est_close, request);
          }
        }
        
      }
      setRetrieveSOPerson(request, so.getPerson());
      setRetrieveSOReport(request, so.getReport());

    } catch (ServiceException se){
      handleException( se, context );
    } catch (Exception e) {
      processSevereException(context, e);
    }

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void savePortalSurveyDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "savePortalSurveyDetail_xa");
    performanceTrace.enterScope();
    
    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      YouthReportDetailSaveSI si = null;

      si = this.populateYouthReportDetailSaveSI(context);

      YouthReportDetailSaveSO so = person.saveYouthReportDetail(si);
      if (so.getIndSurveyCompleted()) {
        setInformationalMessage(Messages.MSG_SURVEY_COMP_SAVED, request);
      } else {
        setInformationalMessage(Messages.MSG_SURVEY_NOT_COMP_SAVED, request);
        // check for unanswer questions and set array for highlighting question
        checkForm(request);
      }

      state.removeAttribute(RETRIEVE_SO_PERSON, request);
      state.removeAttribute(RETRIEVE_SO_REPORT, request);

      setPresentationBranch("survey", context);

    } catch (ServiceException se) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + se.getMessage());
      processSevereException(context, se);
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private YouthReportDetailRetrieveSI populateYouthReportDetailRetrieveSI(HttpServletRequest request) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateYouthReportDetailRetrieveSI");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(request);
    YouthReportDetailRetrieveSI si = new YouthReportDetailRetrieveSI();

    si.setSzScreenName(PORTAL_SURVEY_DETAIL);
    si.setIdUser(getUserID(request));
    si.setDtRptPeriodEnd(NytdHelper.getDtRptPeriodEnd());

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return si;
  }

  private YouthReportDetailSaveSI populateYouthReportDetailSaveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateYouthReportDetailSaveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    YouthReportDetailRetrieveSOReport rso = new YouthReportDetailRetrieveSOReport();

    rso = (YouthReportDetailRetrieveSOReport) state.getAttribute(RETRIEVE_SO_REPORT, request);

    YouthReportDetailSaveSI si = null;

    Integer idYouthReportDtl = rso.getIdYouthReportDetail();
    Integer idUser = getUserID(request);

    if( idYouthReportDtl != null && idYouthReportDtl != 0 ){
      si = new YouthReportDetailSaveSI(ServiceConstants.REQ_FUNC_CD_UPDATE);
      si.setIdYouthReportDtl(idYouthReportDtl);
    }else{
      si = new YouthReportDetailSaveSI(ServiceConstants.REQ_FUNC_CD_ADD);
      si.setIdYouthReportDtl(0);
    }
    
    si.setSzScreenName(PORTAL_SURVEY_DETAIL);
    si.setIdUser(idUser);
    si.setIdPerson(rso.getIdPerson());
    si.setDtRptPeriodEnd(rso.getDtRptPeriodEnd());

    si.setDtDob(rso.getDtDob());
    si.setCdSex(rso.getCdSex());
    si.setIndRaceAmerIndian(rso.getIndRaceAmerIndnAkNative());
    si.setIndRaceAsian(rso.getIndRaceAsian());
    si.setIndRaceBlack(rso.getIndRaceBlackAfricanAmer());
    si.setIndRacePacIslander(rso.getIndRaceNativeHiPacIslander());
    si.setIndRaceWhite(rso.getIndRaceWhite());
    si.setIndRaceUnknown(rso.getIndRaceUnknown());
    si.setIndRaceDeclined(rso.getIndRaceDeclined());
    si.setCdEthinicity(rso.getCdEthinicity());
    si.setIndFcStatSvcs(rso.getIndFcStatSvcs());
    si.setIndTribalMbr(rso.getIndTribalMbr());
    si.setIndSpcEduStat(rso.getIndSpecEdu());

    si.setCdAgeClass(rso.getCdAgeClass());
    si.setCdLastGradeComp(rso.getCdLastGradeComp());
    si.setIndIlNeedsAsm(rso.getIndIlNeedsAsm());
    si.setIndAdjDelinquent(rso.getIndAdjDelinquent());

    si.setCdOutcomeRptStat(CodesTables.COUTSTAT_YP);
    si.setDtOutcomeDate(Calendar.getInstance().getTime());
    si.setIndFcStatOutcome(ContextHelper.getStringSafe(request, HDN_FC_STATUS));

    // -- direct strings
    si.setCdCurrFtEmp(ContextHelper.getStringSafe(request, RADIO_CURR_FTE_NAME));
    si.setCdCurrPtEmp(ContextHelper.getStringSafe(request, RADIO_CURR_PTE_NAME));
    si.setCdEducAid(ContextHelper.getStringSafe(request, RADIO_EDU_AID_NAME));
    si.setCdSocialSec(ContextHelper.getStringSafe(request, RADIO_SS_NAME));
    si.setCdEmpSkills(ContextHelper.getStringSafe(request, RADIO_EMP_SKILLS_NAME));
    si.setCdHighEdu(ContextHelper.getStringSafe(request, RADIO_HECR_NAME));
    si.setCdCurrAtdEnr(ContextHelper.getStringSafe(request, RADIO_CAE_NAME));
    si.setCdConnAdult(ContextHelper.getStringSafe(request, RADIO_C2A_NAME));
    si.setCdHomeless(ContextHelper.getStringSafe(request, RADIO_HOME_NAME));
    si.setCdOthSupport(ContextHelper.getStringSafe(request, RADIO_OTH_INC_NAME));
    si.setCdSubAbuseRef(ContextHelper.getStringSafe(request, RADIO_SAR_NAME));
    si.setCdIncarceration(ContextHelper.getStringSafe(request, RADIO_INC_NAME));
    si.setCdChildren(ContextHelper.getStringSafe(request, RADIO_CHL_NAME));
    
    if( !ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, RADIO_CHL_NAME))
                    && StringHelper.isEmptyOrNull(ContextHelper.getStringSafe(request, RADIO_MAB_NAME)) ){
      si.setCdMarrAtBirth(CodesTables.CINVACAN_A);
    }else{
      si.setCdMarrAtBirth(ContextHelper.getStringSafe(request, RADIO_MAB_NAME));
    }
    
    si.setCdMedicaid(ContextHelper.getStringSafe(request, RADIO_MEDICAID_NAME));
    si.setCdOthHlthInsTyp(ContextHelper.getStringSafe(request, RADIO_OHIT_NAME));
    
    si.setCdHlthInsMedical(ContextHelper.getStringSafe(request, RADIO_MEDICAL_NAME));
    si.setCdHlthInsMental(ContextHelper.getStringSafe(request, RADIO_MENTAL_NAME));
    si.setCdHlthInsPrescription(ContextHelper.getStringSafe(request, RADIO_PRESCRIPTION_NAME));

    if( !ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, RADIO_OHIT_NAME))
                    && StringHelper.isEmptyOrNull(ContextHelper.getStringSafe(request, RADIO_MEDICAL_NAME))){
      si.setCdHlthInsMedical(CodesTables.CINVACAN_A);
    }
    
    if( !ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(request, RADIO_MEDICAL_NAME))
                    && StringHelper.isEmptyOrNull(ContextHelper.getStringSafe(request, RADIO_MENTAL_NAME))
                    && StringHelper.isEmptyOrNull(ContextHelper.getStringSafe(request, RADIO_PRESCRIPTION_NAME))){
      si.setCdHlthInsMental(CodesTables.CINVACAN_A);
      si.setCdHlthInsPrescription(CodesTables.CINVACAN_A);
    }

    if (POPULATION_TYPE_FOLLOW_UP.equals(ContextHelper.getStringSafe(request, HDN_POPULATION_TYPE))
        && ArchitectureConstants.N.equals(ContextHelper.getStringSafe(request, HDN_FC_STATUS))) {
      si.setCdTanf(ContextHelper.getStringSafe(request, RADIO_TANF_NAME));
      si.setCdFoodStamps(ContextHelper.getStringSafe(request, RADIO_FOOD_STMP_NAME));
      si.setCdHousingAst(ContextHelper.getStringSafe(request, RADIO_PUB_HSG_NAME));
    } else {
      si.setCdTanf(CodesTables.CINVACAN_A);
      si.setCdFoodStamps(CodesTables.CINVACAN_A);
      si.setCdHousingAst(CodesTables.CINVACAN_A);
    }

    // on ADD default services received to N
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(si.getCReqFuncCd())) {
      si.setIndAcadSupport(N);
      si.setIndBdgtFinMgt(N);
      si.setIndCareerPrep(N);
      si.setIndEduFinance(N);
      si.setIndEmpProgVoc(N);
      si.setIndFamMarrEdu(N);
      si.setIndHealthEdu(N);
      si.setIndHousingEdu(N);
      si.setIndMentoring(N);
      si.setIndOthFinance(N);
      si.setIndPsEduSupport(N);
      si.setIndRoomBrdFin(N);
      si.setIndSuperIl(N);
    }

    si.setCdPopulationType(ContextHelper.getStringSafe(request, HDN_POPULATION_TYPE));
    si.setIndFollowUp(StringHelper.toYorN(POPULATION_TYPE_FOLLOW_UP.equals(ContextHelper.getStringSafe(request, HDN_POPULATION_TYPE))));
    si.setIndEnteredByYth(ArchitectureConstants.Y);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
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

  private void checkForm(HttpServletRequest request) {
    PerformanceTrace pt = new PerformanceTrace(TRACE_TAG, ".checkForm()");
    pt.enterScope();

    request.removeAttribute(PortalSurveyDetailConversation.VALIDATION_CUSTOM_INPUTS);
    varInputs = new ArrayList<String>();

    checkField(PortalSurveyDetailConversation.RADIO_CURR_FTE_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_CURR_PTE_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_EDU_AID_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_EMP_SKILLS_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_SS_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_HECR_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_C2A_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_CAE_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_HOME_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_INC_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_CHL_NAME, request);
    
    // if youth has given birth or fathered a child, then check
    if( Y.equals(ContextHelper.getStringSafe(request, RADIO_CHL_NAME)) ){
      checkField(PortalSurveyDetailConversation.RADIO_MAB_NAME, request);      
    }
    
    checkField(PortalSurveyDetailConversation.RADIO_MEDICAID_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_MEDICAL_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_MENTAL_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_OHIT_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_OTH_INC_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_SAR_NAME, request);
    checkField(PortalSurveyDetailConversation.RADIO_PRESCRIPTION_NAME, request);
    
    // if followup and not in care then validate the following questions
    if (POPULATION_TYPE_FOLLOW_UP.equals(ContextHelper.getStringSafe(request, HDN_POPULATION_TYPE))
        && N.equals(ContextHelper.getStringSafe(request, HDN_FC_STATUS))) {
      checkField(PortalSurveyDetailConversation.RADIO_PUB_HSG_NAME, request);
      checkField(PortalSurveyDetailConversation.RADIO_TANF_NAME, request);
      checkField(PortalSurveyDetailConversation.RADIO_FOOD_STMP_NAME, request);
    }

    request.setAttribute(PortalSurveyDetailConversation.VALIDATION_CUSTOM_INPUTS, varInputs);

    pt.getTotalTime();
    pt.exitScope();
  }

  private void checkField(String inputName, HttpServletRequest request) {
    if (StringHelper.isEmptyOrNull(ContextHelper.getStringSafe(request, inputName))) {
      varInputs.add(inputName);
    }
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
    case Messages.MSG_PORTAL_USER_TMP_PASSWORD_RESET:
      setPresentationBranch("errorUser", context);
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