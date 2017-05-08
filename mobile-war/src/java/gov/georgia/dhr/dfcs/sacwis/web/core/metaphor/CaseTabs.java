package gov.georgia.dhr.dfcs.sacwis.web.core.metaphor;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

/**
 * Determines which 2nd level tabs as well as which 3rd-level Tabs get displayed for 2nd-level tabs under the 1st-level
 * Tab 'CASE'
 * <pre>
 * Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/24/04  RIOSJA    SIR 16114 - Add "Services and Referrals Checklist"
 *                      functionality to family stages. Third-level tab should
 *                      appear after "Family Plan Evaluation" tab.
 *  04/08/05  ANANDV    SIR 23522 - Added PRINCIPAL_CASE_HISTORY tab on level2Tab
 *                      for Principal Case History Information Page
 *  04/20/05  CORLEYAN  SIR 23531 - Added CARE tab
 *  04/20/05  CORLEYAN  SIR 23530 - Added display logic for APS Service Plan.
 *  07/18/05  OCHUMD    Sir 23713  APS Reform R2 - CRSR Neither the CARE
 *                      nor Outcome Matrix Tabs should display for C-REG or C-GUA
 *                      stage types.
 *  21/02/06  AODUTAYO  Added DIV stage and its related tabs to getLevel2CaseTabs
 *                      andn getLevel3CaseTabs
 *  06/01/08  SSUBRAM   Added Non Compliance and Policy Violation
 *  07/24/2008  ssubram STGAP00009509: Child life History check list has been added
 *  02/25/2008 arege    STGAP00012636: Added new tab in getLevel2CaseTabs method to
 *                      display Service Authorization tab for FAD stage.
 *  03/10/2009 bgehlot STGAP00012833: Added new tab Case Review under the Case Management tab for 
 *                           INT, INV, SUB, ADO, FPR, DIV stages.
 *  11/09/2009 pcoogan  ECEM Enhancements: Added tab constants for case watch and changed the page to be
 *                      first available under Case Maintenance for FCC, ADO, INV, ONG stages.
 *  01/20/2010 arege    Added tab constant for Children 1st Referral Page.
 *  02/08/2010 arege    STGAP00015749 Added Tab Constant for Children 1st Referral for DIV stage
 *  02/10/2010 arege    STGAP00015749 Added Tab Constant for CD/NF/SI tab in INT, INV, ONG, FCC, ADO and PFC stages.
 * </pre>
 *
 * @author Stephan Brauchli
 * @version 1.0
 */
public abstract class CaseTabs {
  public static final String TRACE_TAG = "CaseTabs.";

  protected static List<TabInfo> getLevel3CaseTabs(int level2Tab, String stageType, HttpServletRequest request) {
    List<TabInfo> tabs = new LinkedList<TabInfo>();

    if ("INV".equals(stageType) || "ARI".equals(stageType)) {
      stageType = stageType + "_" + GlobalData.getSzCdStageProgram(request);
    }
    switch (level2Tab) {
      case TabConstants.CASE_SUMMARY_CASESUMMARY:
        tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_3_CASESUMMARY));
        tabs.add(Nav.getTabInfo(TabConstants.CASE_TO_DO_LIST_TODCMNTTN));
        tabs.add(Nav.getTabInfo(TabConstants.EVENT_LIST_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.EVENT_SEARCH_EVENTSEARCHCONVERSATION));
        tabs.add(Nav.getTabInfo(TabConstants.PRINCIPAL_CASE_HISTORY));
        break;
      case TabConstants.PERSON_PERSONLIST:
        // Need more logic here: These tabs load once the user has selected a person from Person List
        tabs.add(Nav.getTabInfo(TabConstants.PERSON_DETAIL_PERSONDETAIL));
        tabs.add(Nav.getTabInfo(TabConstants.RECORDS_CHECK_RECORDSCHECK));
        tabs.add(Nav.getTabInfo(TabConstants.PERSON_CITIZENSHIP_IDENTITY));//Citizenship and Identity
        tabs.add(Nav.getTabInfo(TabConstants.MEDICAL_MENTAL_ASSESSMENT_EVENTLIST));
        if (stageType.equals(MetaphorTabs.DIV) || stageType.equals(MetaphorTabs.FPR) || stageType.equals(MetaphorTabs.SUB) || stageType.equals(MetaphorTabs.ADO) ||stageType.startsWith("INV")
                        || stageType.equals(MetaphorTabs.FSU) || stageType.equals(MetaphorTabs.PFC) || stageType.equals(MetaphorTabs.PAD)){
        tabs.add(Nav.getTabInfo(TabConstants.CHILDREN_FIRST_REFERRAL_EVENTLIST));//Children 1st
        }
        tabs.add(Nav.getTabInfo(TabConstants.DILIGENT_SEARCH_DILIGENTSEARCH));
        tabs.add(Nav.getTabInfo(TabConstants.YOUTH_DETAIL));
        tabs.add(Nav.getTabInfo(TabConstants.FA_PERSON_DETAIL));
        //-- RESTRICTED_FUNDS -- see logic in RestrictedFundsShowTab
        tabs.add(Nav.getTabInfo(TabConstants.RESTRICTED_FUNDS));
        tabs.add(Nav.getTabInfo(TabConstants.EXCHANGE_CHILD_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.NON_INCIDENT_AFCARS_INFORMATION));
        break;
      case TabConstants.RISK_ASSESSMENT_RISKASSMT:
        tabs.add(Nav.getTabInfo(TabConstants.SAFETY_ASSESSMENT_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.SAFETY_PLAN_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.SAFETY_RESOURCE_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.RISK_ASSESSMENT_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.INVESTIGATION_CONCLUSION_CPS_CPSINVCNCLSN));
        tabs.add(Nav.getTabInfo(TabConstants.PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST));
        break;
      //-- SIR STGAP00005607 ----------------------------------------------
      case TabConstants.ONG_ASSESSMENT:
        tabs.add(Nav.getTabInfo(TabConstants.SAFETY_ASSESSMENT_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.SAFETY_PLAN_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.SAFETY_RESOURCE_EVENTLIST));
        break;
        //-- SIR STGAP00005607 ----------------------------------------------


    
      //-------------------------------------------------------------------
      case TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH:
        tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH_3RD));
        tabs.add(Nav.getTabInfo(TabConstants.PROTECTIVE_SERVICE_ALERT));
        if (stageType.equals(MetaphorTabs.INT) || stageType.equals(MetaphorTabs.FPR) || stageType.equals(MetaphorTabs.SUB) || stageType.equals(MetaphorTabs.ADO) ||stageType.startsWith("INV")
                        || stageType.equals(MetaphorTabs.PFC)){
        tabs.add(Nav.getTabInfo(TabConstants.CHLDDEATH_NRFAL_SERINJ_FOR_CASE_EVENTLIST));//Child Death/Nr Fatality/Serious Injury
        }
        if (stageType.equals(MetaphorTabs.FSU) || stageType.equals(MetaphorTabs.FPR)) {
          tabs.add(Nav.getTabInfo(TabConstants.CONTACT_STANDARDS_EVENTLIST));
        }
        break;
      case TabConstants.SERVICE_AUTHORIZATION_EVENTLIST:
        tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_3_EVENTLIST));
        if (!MetaphorTabs.DIV.equals(stageType)){
          tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTH_FOR_CASE_EVENTLIST));
        }
        tabs.add(Nav.getTabInfo(TabConstants.CASE_BUDGET_LIMIT));
        break;
      case TabConstants.LEGAL_EVENTLIST:
        if (stageType.equals(MetaphorTabs.PAD)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.INV_CPS)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_FOR_CASE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.ADO)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_FOR_CASE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.FPR)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_FOR_CASE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.FSU)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_FOR_CASE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.SUB)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_FOR_CASE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.PFC)) {
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_ACTIONS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.LEGAL_STATUS_FOR_CASE_EVENTLIST));
        }
        break;
      case TabConstants.CASE_MANAGEMENT_CASEMNT:
        if (stageType.equals(MetaphorTabs.ARI_AFC)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.FACILITY_INVESTIGATION_CONCLUSION_FACILITYINVCNCLSN));
        } else if (stageType.equals(MetaphorTabs.ARI_CPS)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
        } else if (stageType.equals(MetaphorTabs.FAD)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.FSU)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_FAMILY_SUB_CARE_STAGECLOSURE));
        } else if (stageType.equals(MetaphorTabs.INT)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.INTAKE_PRIORITY_CLOSURE_INTAKEPRIORITYCLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.PAD)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_POST_ADOPTION_STAGE_STAGECLOSURE));
        } else if (stageType.equals(MetaphorTabs.PFC)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_POST_FC_STAGE_STAGECLOSURE));
        } else if (stageType.equals(MetaphorTabs.DIV)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.DIVERSION_CONCLUSION_DIV_DVRSONCONCLSION));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.ADO)) {
          //tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_ADOPTION_STAGE_STAGECLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.FPR)) {
          //tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_FAMILY_PRESERVATION_SERVICEDLVRYCLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.INV_CPS)) {
          //tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.SUB)) {
          //tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_SUBCARE_STAGE_STAGECLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        }
        break;
      case TabConstants.CASE_MANAGEMENT_CASEMNT_CW:
        if (stageType.equals(MetaphorTabs.ADO)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_ADOPTION_STAGE_STAGECLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.FPR)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_FAMILY_PRESERVATION_SERVICEDLVRYCLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.INV_CPS)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.SUB)) {
          tabs.add(Nav.getTabInfo(TabConstants.CASE_WATCH));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_STAGE_MAINT_3_CASEMNT));
          tabs.add(Nav.getTabInfo(TabConstants.EXTERNAL_DOCUMENTATION_EXTERNALDCMNTTN));
          tabs.add(Nav.getTabInfo(TabConstants.POLICY_WAIVER_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CLOSE_SUBCARE_STAGE_STAGECLOSURE));
          tabs.add(Nav.getTabInfo(TabConstants.CASE_REVIEW_EVENTLIST));
        } 
        break;
      case TabConstants.CHILD_PLANS_EVENTLIST:
        if (stageType.equals(MetaphorTabs.ADO)) {
          tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLAN_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLAN_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.NEEDS_AND_OUTCOMES));
          tabs.add(Nav.getTabInfo(TabConstants.PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.VISITATION_PLAN_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.VISITATION_PLAN_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.WTLP_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.WTLP_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.ADOPTION_INFORMATION));
          tabs.add(Nav.getTabInfo(TabConstants.ADOPTION_INFORMATION_FOR_CASE_EVENTLIST));

        } else if (stageType.equals(MetaphorTabs.SUB)) {
          tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLAN_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLAN_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.NEEDS_AND_OUTCOMES));
          tabs.add(Nav.getTabInfo(TabConstants.PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.VISITATION_PLAN_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.VISITATION_PLAN_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.WTLP_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.WTLP_FOR_CASE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.PFC)) {
          tabs.add(Nav.getTabInfo(TabConstants.WTLP_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.WTLP_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST));
        }
        break;
      case TabConstants.FC_ASSISTANCE_EVENTLIST:
        if (stageType.equals(MetaphorTabs.SUB)) {
          tabs.add(Nav.getTabInfo(TabConstants.ELIGIBILITY_SUMMARY_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.INITIAL_MEDICAID_INITIALMEDICAID));
          tabs.add(Nav.getTabInfo(TabConstants.APPLICATION_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.FC_REVIEW_APPLICATION_FOSTERCAREREVIEW));
          // Need more logic:  These tabs load once the user has selected an application from the List
          tabs.add(Nav.getTabInfo(TabConstants.APPLICATION_AND_BACKGROUND_APPBACKGROUND));
          tabs.add(Nav.getTabInfo(TabConstants.AGE_AND_CITIZENSHIP_AGECITIZENSHIP));
          tabs.add(Nav.getTabInfo(TabConstants.DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION));
          tabs.add(Nav.getTabInfo(TabConstants.THIRD_PARTY_HEALTH_INSURANCE_DETAIL_THIRDPARTYHEALTHINSURANCEDETAIL));
          tabs.add(Nav.getTabInfo(TabConstants.INCOME_AND_EXPENDITURES_INCOMEEXPENDITURES));
          // Need more logic:  This tab loads once the user has selected an application from the List that is
          // in COMP mode or the application is in APRVL mode and the user has the SEC_ELIGIBILTY security attribute.
          // Otherwise the tab does not display
          tabs.add(Nav.getTabInfo(TabConstants.ELIGIBILITY_DETERMINATION_ELGBLTYDTRMNTNWORKSHEET));
        }else if(stageType.equals(MetaphorTabs.ADO)){
          tabs.add(Nav.getTabInfo(TabConstants.ELIGIBILITY_SUMMARY_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.INITIAL_MEDICAID_INITIALMEDICAID));
          // Need more logic:  These tabs load once the user has selected an application from the List
          tabs.add(Nav.getTabInfo(TabConstants.APPLICATION_AND_BACKGROUND_APPBACKGROUND));
          tabs.add(Nav.getTabInfo(TabConstants.AGE_AND_CITIZENSHIP_AGECITIZENSHIP));
          tabs.add(Nav.getTabInfo(TabConstants.DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION));
          tabs.add(Nav.getTabInfo(TabConstants.THIRD_PARTY_HEALTH_INSURANCE_DETAIL_THIRDPARTYHEALTHINSURANCEDETAIL));
          tabs.add(Nav.getTabInfo(TabConstants.INCOME_AND_EXPENDITURES_INCOMEEXPENDITURES));
          // Need more logic:  This tab loads once the user has selected an application from the List that is
          // in COMP mode or the application is in APRVL mode and the user has the SEC_ELIGIBILTY security attribute.
          // Otherwise the tab does not display
          tabs.add(Nav.getTabInfo(TabConstants.ELIGIBILITY_DETERMINATION_ELGBLTYDTRMNTNWORKSHEET));
        }else if(stageType.equals(MetaphorTabs.PAD)){
          tabs.add(Nav.getTabInfo(TabConstants.ELIGIBILITY_SUMMARY_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.INITIAL_MEDICAID_INITIALMEDICAID));
          // Need more logic:  These tabs load once the user has selected an application from the List
          tabs.add(Nav.getTabInfo(TabConstants.APPLICATION_AND_BACKGROUND_APPBACKGROUND));
          tabs.add(Nav.getTabInfo(TabConstants.AGE_AND_CITIZENSHIP_AGECITIZENSHIP));
          tabs.add(Nav.getTabInfo(TabConstants.DOMICILE_AND_DEPRIVATION_DOMICILEDEPRIVATION));
          tabs.add(Nav.getTabInfo(TabConstants.THIRD_PARTY_HEALTH_INSURANCE_DETAIL_THIRDPARTYHEALTHINSURANCEDETAIL));
          tabs.add(Nav.getTabInfo(TabConstants.INCOME_AND_EXPENDITURES_INCOMEEXPENDITURES));
          // Need more logic:  This tab loads once the user has selected an application from the List that is
          // in COMP mode or the application is in APRVL mode and the user has the SEC_ELIGIBILTY security attribute.
          // Otherwise the tab does not display
          tabs.add(Nav.getTabInfo(TabConstants.ELIGIBILITY_DETERMINATION_ELGBLTYDTRMNTNWORKSHEET));
        }
        break;
      case TabConstants.PLACEMENT_EVENTLIST:
        if (stageType.equals(MetaphorTabs.ADO)) {
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_3_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENTS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PAYMENT_OF_CARE_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.SUB)) {
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_3_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENTS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PAYMENT_OF_CARE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.RELATIVE_CARE_ASSESSMENT));
        } else if ((stageType.equals(MetaphorTabs.PAD))) // Added PAD case
        {
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_3_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.PFC)) {
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_3_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PLACEMENTS_FOR_CASE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PAYMENT_OF_CARE_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.RELATIVE_CARE_ASSESSMENT));
        }
        break;
      case TabConstants.HISTORY_EVENTLIST:
        if (stageType.equals(MetaphorTabs.ADO)) {
          tabs.add(Nav.getTabInfo(TabConstants.HSEGH_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.CHILD_LIFE_HISTORY_CHKLST_EVENTLIST));
        } else if (stageType.equals(MetaphorTabs.SUB)) {
          tabs.add(Nav.getTabInfo(TabConstants.HSEGH_EVENTLIST));
        }
        break;
      case TabConstants.FAMILY_PLANS_EVENTLIST:
        if (stageType.equals(MetaphorTabs.FSU)) {
          tabs.add(Nav.getTabInfo(TabConstants.FAMILY_CASE_PLAN_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
        }
        if (stageType.equals(MetaphorTabs.FPR)) {
          tabs.add(Nav.getTabInfo(TabConstants.FAMILY_PLAN_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.PERMANENCY_PLANNING_REVIEW_PPT_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.RISK_REASSESSMENTS_EVENTLIST));
          tabs.add(Nav.getTabInfo(TabConstants.SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST));
        }
        break;
      case TabConstants.ASSESSMENTS_EVENTLIST:
        tabs.add(Nav.getTabInfo(TabConstants.RE_EVALUATION_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.MONTHLY_ASSESSMENT_FOR_ADOPTION_EVENTLIST));
        break;
      case TabConstants.NON_COMPLIANCE_DOCUMENTATION:
        tabs.add(Nav.getTabInfo(TabConstants.POLICY_VIOLATION_EVENTLIST));
        tabs.add(Nav.getTabInfo(TabConstants.CORRECTIVE_ACTION_PLAN_EVENTLIST));
        break;
      case TabConstants.HOME_INFORMATION_HOMEINFRMTN:
        tabs.add(Nav.getTabInfo(TabConstants.HOME_INFORMATION_3_HOMEINFRMTN));
        tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_LOG_PLACEMENTLOG));
        tabs.add(Nav.getTabInfo(TabConstants.HOME_HISTORY_FAHOMEHISTORY));
        tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_REFERRAL_LOG_FAD));
        tabs.add(Nav.getTabInfo(TabConstants.EXCHANGE_HOME_DETAIL));
        tabs.add(Nav.getTabInfo(TabConstants.HOMEINFRMTN_HOME_CONVERSION_3));
        break;
      case TabConstants.RECORD_ADMIN_REVIEW_APPEAL_ADMNREVIEW:
        tabs.add(Nav.getTabInfo(TabConstants.ADMINISTRATIVE_REVIEW_ADMNREVIEW));
        // SIR 19323 - Allegation Tab should not show in ARF stage
        if (!stageType.equals(MetaphorTabs.ARF)) {
          tabs.add(Nav.getTabInfo(TabConstants.ALLEGATION_LIST_ALLEGATION));
        }
        tabs.add(Nav.getTabInfo(TabConstants.INVESTIGATION_CONCLUSION_CPS_CPSINVCNCLSN));
        break;
      case TabConstants.ADOPTION_ASSISTANCE_EVENTLIST:
        tabs.add(Nav.getTabInfo(TabConstants.ADOPTION_ASSISTANCE_APPLICATION_EVENTLIST));
        //-- Adoption Assistance added back for Adoption development SHINES 3.0 
        tabs.add(Nav.getTabInfo(TabConstants.ADOPTION_ASSISTANCE_3_EVENTLIST));
        break;
      case TabConstants.DIVERSION_CONCLUSION_INV_DIVERSIONCONCLUSION:
        tabs.add(Nav.getTabInfo(TabConstants.DIVERSION_CONCLUSION_DIV_DVRSONCONCLSION));
        break;
      default:
        // ??
        break;
    }
    return tabs;
  }

  /**
   * Gets the L2 tabs for a given stage type and program code. Defaults to Case Search if the caseNumber is null or
   * blank, if the L2 tab id is 0, or if the user doesn't have SEC_RESTRICT_CASE_SEARCH permissions.
   */
  protected static List<TabInfo> getLevel2CaseTabs(UserProfile profile, int level2Tab, String stageType,
                                                   HttpServletRequest request) {
    GrndsTrace.enterScope(TRACE_TAG + " Calling *** getLevel2CaseTabs()");
    List<TabInfo> tabs = new LinkedList<TabInfo>();
    if ("INV".equals(stageType) || "ARI".equals(stageType)) {
      stageType = stageType + "_" + GlobalData.getSzCdStageProgram(request);
    }

    GrndsTrace.msg(TRACE_TAG, 8, "Stage Type in CaseTabs == " + stageType);
    GrndsTrace.msg(TRACE_TAG, 8, "level2Tab is == " + level2Tab);
    if (stageType.equals(MetaphorTabs.ADO)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.ADOPTION_ASSISTANCE_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLANS_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.FC_ASSISTANCE_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.HISTORY_EVENTLIST));
      //tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT_CW));
    } else if (stageType.equals(MetaphorTabs.DIV)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.REVIEW_INTAKE_INTAKEACTIONS));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.ARI_CPS)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.RECORD_ADMIN_REVIEW_APPEAL_ADMNREVIEW));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.FAD)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST)); //Added Per STGAP00012636 
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.HOME_INFORMATION_HOMEINFRMTN));
      tabs.add(Nav.getTabInfo(TabConstants.ASSESSMENTS_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.NON_COMPLIANCE_DOCUMENTATION));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.FPR)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.REVIEW_INVESTIGATION_CPSINVCNCLSN));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      //-- SIR STGAP00005607 -------------------------------
      tabs.add(Nav.getTabInfo(TabConstants.ONG_ASSESSMENT));
      //----------------------------------------------------
      tabs.add(Nav.getTabInfo(TabConstants.FAMILY_PLANS_EVENTLIST));
      //tabs.add(Nav.getTabInfo(TabConstants.MEDICAL_MENTAL_ASSESSMENT_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONSERVATORSHIP_REMOVAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT_CW));
      //tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.FSU)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.FAMILY_PLANS_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONSERVATORSHIP_REMOVAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.INT)) {
      if (GlobalData.getUlIdCase(request) != 0) {
        tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      } else {
        tabs.add(Nav.getTabInfo(TabConstants.EVENT_LIST_EVENTLIST));
      }
      tabs.add(Nav.getTabInfo(TabConstants.RECORD_REVIEW_CALL_INTAKEACTIONS));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.INV_CPS)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.REVIEW_INTAKE_INTAKEACTIONS));
      tabs.add(Nav.getTabInfo(TabConstants.DIVERSION_CONCLUSION_INV_DIVERSIONCONCLUSION));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.ALLEGATION_ALLEGATION));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.RISK_ASSESSMENT_RISKASSMT));
      tabs.add(Nav.getTabInfo(TabConstants.CONSERVATORSHIP_REMOVAL_EVENTLIST));
      //tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT_CW));
    } else if (stageType.equals(MetaphorTabs.PAD)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.ADOPTION_ASSISTANCE_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.FC_ASSISTANCE_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.PFC)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLANS_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (stageType.equals(MetaphorTabs.SUB)) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
      tabs.add(Nav.getTabInfo(TabConstants.PERSON_PERSONLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CONTACTS_SUMMARIES_CONTACTSEARCH));
      tabs.add(Nav.getTabInfo(TabConstants.SERVICE_AUTHORIZATION_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.LEGAL_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CHILD_PLANS_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.PLACEMENT_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.HISTORY_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.FC_ASSISTANCE_EVENTLIST));
      tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT_CW));
      //tabs.add(Nav.getTabInfo(TabConstants.CASE_MANAGEMENT_CASEMNT));
    } else if (level2Tab == TabConstants.CASE_CASESEARCH_CASESEARCH) {
      if (!profile.hasRight(UserProfile.SEC_RESTRICT_CASE_SEARCH) && tabs.isEmpty()) {
        tabs.add(Nav.getTabInfo(TabConstants.CASE_CASESEARCH_CASESEARCH));
      }
    } else if (level2Tab == TabConstants.CASE_SUMMARY_CASESUMMARY && "".equals(stageType) && tabs.isEmpty()) {
      tabs.add(Nav.getTabInfo(TabConstants.CASE_SUMMARY_CASESUMMARY));
    } else if (tabs.isEmpty()) {
      if (!profile.hasRight(UserProfile.SEC_RESTRICT_CASE_SEARCH) && tabs.isEmpty()) {
        tabs.add(Nav.getTabInfo(TabConstants.CASE_CASESEARCH_CASESEARCH));
      }
    }
    GrndsTrace.exitScope();
    return tabs;
  }
}