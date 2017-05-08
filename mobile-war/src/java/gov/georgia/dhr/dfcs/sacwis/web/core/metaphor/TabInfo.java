package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * <p>Title: </p> <p>Description: Removes <br> tag from Second Level Tab text to format it correctly for the Third-Level
 * Tabs which use the same text Sets text, which tab is selected, destination, and width </p> <p>Copyright: Copyright
 * (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class TabInfo implements Serializable {
  private String url = "";
  private String name = "";
  private int tabId = 0;
  private String activeImg = "";
  private String inactiveImg = "";
  private String taskCode = "";

  public TabInfo() {
  }

  public String getTaskCode() {
    return taskCode;
  }

  public void setTaskCode(String tc) {
    this.taskCode = tc;
  }

  public String getName() {
    return this.name;
  }

  //** getUnbrokenText() takes the tab text and removes any '<br>'s
  public String getUnbrokenText() {
    StringTokenizer strtok = new StringTokenizer(this.getName(), "<>");
    String utext = "";
    while (strtok.hasMoreTokens()) {
      utext += strtok.nextToken();
      if (strtok.hasMoreTokens()) {
        strtok.nextToken(); //waste it
        utext += " ";
      }
    }
    return utext;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = defaulter(url);
  }

  public void setName(String name) {
    this.name = defaulter(name);
  }

  public static String defaulter(String text) {
    if (text == null) {
      return "";
    } else {
      return text;
    }
  }

  public int getTabId() {
    return this.tabId;
  }

  public void setTabId(int tabId) {
    this.tabId = tabId;
  }

  public void setActiveImg(String activeImg) {
    this.activeImg = activeImg;
  }

  public void setInactiveImg(String inactiveImg) {
    this.inactiveImg = inactiveImg;
  }

  public String getActiveImageName() {
    return this.activeImg;
  }

  public String getInactiveImageName() {
    return this.inactiveImg;
  }

  public String printContents() {
    StringBuffer contents = new StringBuffer();
    contents.append("TabID == ").append(this.getTabId()).append(", \n");
    contents.append("Url == ").append(this.getUrl()).append(", \n");
    contents.append("Name == ").append(this.getName()).append(", \n");
    contents.append("activeImg == ").append(this.getActiveImageName()).append(", \n");
    contents.append("inactiveImg == ").append(this.getInactiveImageName()).append(", \n");
    contents.append(" \n");
    return contents.toString();
  }

  /* Constants
  public static final int ADMINISTRATIVE_REVIEW_ADMNREVIEW = 10;
  public static final int ADOPTION_ASSISTANCE_EVENTLIST = 20;
  public static final int AGE_AND_CITIZENSHIP_AGECITIZENSHIP = 30;
  public static final int ALLEGATION_ALLEGATION = 40; // L2
  public static final int ALLEGATION_LIST_ALLEGATION = 50;
  public static final int APPLICATION_AND_BACKGROUND_APPBACKGROUND = 60;
  public static final int APS_INVESTIGATION_CONCLUSION_APSCNCLSN = 70;
  public static final int APS_SERVICE_PLAN_APSSERVICEPLAN = 80;
  public static final int ASSESSMENTS_EVENTLIST = 90; // L2
  public static final int CALL_INFORMATION_3_CALLINFRMTN = 100;
  public static final int CALL_INFORMATION_CALLINFRMTN = 110; // L1
  public static final int CALL_PERSON_DETAIL_REDISPLAY = 113;
  public static final int INCOMING_PERSON_DETAIL_INCOMING = 117;
  public static final int CALL_LOG_CALLLOG = 120; // L2
  public static final int CASE_CASESEARCH = 130; // L1
  public static final int CASE_MANAGEMENT_CASEMNT = 140; // L2
  public static final int CASE_MANAGEMENT_INTAKEPRIORITYCLOSURE = 150;
  public static final int CASE_CASESEARCH_CASESEARCH = 160; // L2
  public static final int CASE_SEARCHSEARCH_CASESEARCH = 170;
  public static final int CASE_STAGE_MAINT_3_CASEMNT = 180;
  public static final int CASE_TO_DO_LIST_TODCMNTTN = 190;
  public static final int CHANGE_STAGE_TYPE_EVENTLIST = 200;
  public static final int CHILD_BACKGROUND_SUMMARY_EVENTLIST = 210;
  public static final int CHILD_PLAN_EVENTLIST = 220;
  public static final int CHILD_PLAN_FOR_CASE_EVENTLIST = 230;
  public static final int CHILD_PLANS_EVENTLIST = 240;
  public static final int CLOSE_ADOPTION_STAGE_STAGECLOSURE = 250;
  public static final int CLOSE_AGING_OUT_STAGE_STAGECLOSURE = 260;
  public static final int CLOSE_CALL_INTAKEPRIORITYCLOSURE = 270;
  public static final int CLOSE_FAMILY_PRESERVATION_SERVICEDLVRYCLOSURE = 280;
  public static final int CLOSE_FAMILY_REUNIFICATION_STAGECLOSURE = 290;
  public static final int CLOSE_FAMILY_SUB_CARE_STAGECLOSURE = 300;
  public static final int CLOSE_POST_ADOPTION_STAGE_STAGECLOSURE = 310;
  public static final int CLOSE_SERVICE_DELIVERY_SERVICEDLVRYCLOSURE = 320;
  public static final int CLOSE_SUBCARE_STAGE_STAGECLOSURE = 330;
  public static final int COMMON_APPLICATION_EVENTLIST = 340;
  public static final int CONSERVATORSHIP_REMOVAL_EVENTLIST = 350;
  public static final int CONTACTS_SUMMARIES_CONTACTSEARCH = 360; // L3
  public static final int CONTRACT_CONTRACTSEARCH_CONTRACTSEARCH = 370; // L2
  public static final int CONTRACT_CONTRACTSEARCH_3_CONTRACTS = 380; // L3
  public static final int CORRECTIVE_ACTION_PLAN_EVENTLIST = 390;
  public static final int CVS_FA_HOME_PERSONDETAIL = 400;
  public static final int DEVELOPMENTAL_PLAN_EVENTLIST = 410;
  public static final int DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION = 420;
  public static final int ELIGIBILITY_DETERMINATION_ELGBLTYDTRMNTNWORKSHEET = 430;
  public static final int ELIGIBILITY_SUMMARY_EVENTLIST = 440;
  public static final int EVENT_LIST_EVENTLIST = 450;
  public static final int EVENT_SEARCH_EVENTSEARCHCONVERSATION = 460;
  public static final int EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN = 470;
  public static final int F_A_HOME_FAHOMESEARCH = 480;
  public static final int FACILITY_DETAIL_FACILITY = 490; // L2
  public static final int FACILITY_DETAIL_3_FACILITY = 500;
  public static final int FACILITY_INVESTIGATION_CONCLUSION_FACILITYINVCNCLSN = 510;
  public static final int FAMILY_PLAN_EVENTLIST = 520;
  public static final int FAMILY_PLAN_FOR_CASE_EVENTLIST = 530;
  public static final int FAMILY_PLAN_EVALUATION = 535;
  public static final int FAMILY_PLANS_EVENTLIST = 540;
  public static final int FC_ASSISTANCE_EVENTLIST = 550;
  public static final int FC_REVIEW_APPLICATION_FOSTERCAREREVIEW = 560;
  public static final int FINANCIAL_ACCOUNT_DETAIL_FINANCIALACCT = 570;
  public static final int FINANCIAL_ACCOUNT_FINANCIALACCT = 580;
  public static final int FINANCIAL_ACCOUNT_REGISTER_FINANCIALACCT = 590;
  public static final int FINANCIAL_CONTRACTSEARCH = 600; // L1
  public static final int GUARDIANSHIP_DETAIL_EVENTLIST = 610;
  public static final int HISTORY_EVENTLIST = 620;
  public static final int HOME_HISTORY_FAHOMEHISTORY = 630;
  public static final int HOME_INFORMATION_3_HOMEINFRMTN = 640;
  public static final int HOME_INFORMATION_HOMEINFRMTN = 650;
  public static final int HSEGH_EVENTLIST = 660;
  public static final int INCOME_AND_EXPENDITURES_INCOMEEXPENDITURES = 670;
  public static final int INFRACTION_DOCUMENTATION_EVENTLIST = 680;
  public static final int INTAKE_ACTIONS_3_INTAKEACTIONS = 690;
  public static final int INTAKE_ACTIONS_INTAKEACTIONS = 700; // L2
  public static final int INTAKE_INTAKE = 710; // L1
  public static final int INTAKE_PRIORITY_CLOSURE_INTAKEPRIORITYCLOSURE = 720;
  public static final int INVESTIGATION_CONCLUSION_AFC_FACILITYINVCNCLSN = 730;
  public static final int INVESTIGATION_CONCLUSION_APS_APSCNCLSN = 740;
  public static final int INVESTIGATION_CONCLUSION_CCL_LCNSGINVCNCLSN = 750;
  public static final int INVESTIGATION_CONCLUSION_RCL_LCNSGINVCNCLSN = 760;
  public static final int INVESTIGATION_CONCLUSION_CPS_CPSINVCNCLSN = 770;
  public static final int INVOICE_SEARCH_INVOICESEARCH = 780; // L2
  public static final int INVOICE_INVOICE = 790;
  public static final int LEGAL_ACTIONS_EVENTLIST = 800; // L3
  public static final int LEGAL_ACTIONS_FOR_CASE_EVENTLIST = 810; // L3
  public static final int LEGAL_EVENTLIST = 820; // L2
  public static final int LEGAL_STATUS_EVENTLIST = 830; // L3
  public static final int LEGAL_STATUS_FOR_CASE_EVENTLIST = 840; // L3
  public static final int LEVEL_OF_CARE_EVENTLIST = 850; // L3
  public static final int MAINTAIN_DESIGNEE_MNTAINDESIGNEE = 860;
  public static final int MEDICAL_DEVELOPMENTAL_HISTORY_3_EVENTLIST = 870;
  public static final int MEDICAL_DEVELOPMENTAL_HISTORY_EVENTLIST = 880;
  public static final int MEDICAL_MENTAL_ASSESSMENT_EVENTLIST = 890;
  public static final int MONTHLY_ASSESSMENT_FOR_ADOPTION_EVENTLIST = 900;
  public static final int MY_TASKS_ASSIGNEDWORKLOAD = 910;  // L1
  public static final int ON_CALL_ONCALL = 920; // L2
  public static final int PAL_INFORMATION_PAL = 930;
  public static final int PAYMENT_APPROVAL_PYMNTAPPROVAL = 940;
  public static final int PAYMENT_HISTORY_PYMNTHISTORY = 950; // L2
  public static final int PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST = 960;
  public static final int PERSON_DETAIL_PERSONDETAIL = 970; // L3
  public static final int PERSON_PERSONLIST = 980; // L2
  public static final int PERSON_PERSONSEARCH = 990; // L2
  public static final int PLACEMENT_3_EVENTLIST = 1000; // L3
  public static final int PLACEMENT_EVENTLIST = 1010; // L2
  public static final int PLACEMENT_LOG_PLACEMENTLOG = 1020;
  public static final int PLACEMENTS_FOR_CASE_EVENTLIST = 1030;
  public static final int QUARTERLY_ASSESSMENT_EVENTLIST = 1040;
  public static final int RE_EVALUATION_EVENTLIST = 1050;
  public static final int RECORD_ADMIN_REVIEW_APPEAL_ADMNREVIEW = 1060; // L2
  public static final int RECORD_REVIEW_CALL_INTAKEACTIONS = 1070;
  public static final int RECORDS_CHECK_RECORDSCHECK = 1080; // L3
  public static final int REPORT_LIST_REPORTLIST = 1090;
  public static final int REPORTS_REPORTLIST = 1100;
  public static final int RESOURCE_DETAIL_RESOURCEDETAIL = 1110; // L2
  public static final int RESOURCE_SEARCH_RESOURCESEARCH = 1120; // L2
  public static final int RESOURCE_RESOURCESEARCH = 1130; // L1
  public static final int REVIEW_CALL_INTAKEACTIONS = 1140;
  public static final int REVIEW_INTAKE_INTAKEACTIONS = 1150;
  public static final int REVIEW_INVESTIGATION_CPSINVCNCLSN = 1160;
  public static final int REVIEW_INVESTIGATION_APSCNCLSN = 1170;
  public static final int RISK_ASSESSMENT_RISKASSMT = 1180; // L2
  public static final int RISK_AND_SAFETY_ASSESSMENT_RISKASSMT = 1185; // L2 Added SPB
  public static final int SEARCH_PERSONSEARCH = 1190; // L1
  public static final int SECURITY_PROFILE_MAINTENANCE_SECURITYPROFILEMNT = 1200; // L2
  public static final int SERIOUS_INCIDENT_EVENTLIST = 1210;
  public static final int SERVICE_AUTHORIZATION_3_EVENTLIST = 1220;
  public static final int SERVICE_AUTHORIZATION_EVENTLIST = 1230;
  public static final int SERVICE_PLANS_APSSERVICEPLAN = 1240;
  public static final int SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST = 1250;
  public static final int SERVICES_BY_AREA_SERVICESBYAREA = 1260; // L2
  public static final int STAFF_DETAIL_STAFFSEARCH = 1270; // L3
  public static final int STAFF_SEARCH_STAFFSEARCH = 1280; // L2
  public static final int STAFF_SECURITY_MAINTENANCE_STAFFSECURITYMN = 1290; // L3
  public static final int STAFF_TO_DO_LIST_TODCMNTTN = 1300;
  public static final int STAFF_TO_DO_LIST_TODCMNTTN_OTHER = 1310;
  public static final int CASE_SUMMARY_3_CASESUMMARY = 1320; // L3
  public static final int CASE_SUMMARY_CASESUMMARY = 1330; // L2
  public static final int UNIT_MAINTENANCE_UNITMNT = 1340; // L2
  public static final int UNIT_SUMMARY_UNITSUMMARY = 1350; // L2
  public static final int UPDATE_PRIORITY_INTAKEPRIORITYCLOSURE = 1360;
  public static final int VARIANCE_EVENTLIST = 1370;
  public static final int VIOLATION_EVENTLIST = 1380;
  public static final int VISITATION_PLAN_EVENTLIST = 1390;
  public static final int WORKLOAD_ASSIGNEDWORKLOAD = 1400; // L2
  public static final int WORKLOAD_OTHER_ASSIGNEDWORKLOAD_OTHER = 1410; // L3
  */
}