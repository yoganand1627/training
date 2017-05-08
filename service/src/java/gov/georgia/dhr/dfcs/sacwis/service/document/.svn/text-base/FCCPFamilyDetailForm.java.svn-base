package gov.georgia.dhr.dfcs.sacwis.service.document;

import java.util.HashMap;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFAMILYDETAILFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFAMILYDETAILFORMSO;

public interface FCCPFamilyDetailForm extends DocumentService{
  
  // Template names
  public static final String FCM05O00 = "FCM05O00";  
  
  public static final String FCM05O00_DOC_NAME = "fcm05o00";  
  public static int FCM05O00_MAJOR = 1;
  public static int FCM05O00_MINOR = 0;
  public static int FCM05O00_REVISION = 1;
  
  
  // repeating groups names
  // STGAP00005914 Adding  CareTaker Information Group Back
  public static final String TMPLAT_CARETAKER_INFO             = "TMPLAT_CARETAKER_INFO";
  public static final String TMPLAT_RELATIVE_INFO              = "TMPLAT_RELATIVE_INFO";
  public static final String TMPLAT_CASEMNGR_INFO              = "TMPLAT_CASEMNGR_INFO";
  public static final String TMPLAT_CASE_TRACKING             = "TMPLAT_CASE_TRACKING";
  public static final String TMPLAT_REMOVAL_SEPARATION        = "TMPLAT_REMOVAL_SEPARATION";
  public static final String TMPLAT_REUNIF_PLAN               = "TMPLAT_REUNIF_PLAN";
  public static final String TMPLAT_REUNIF_CNCUR_PERM_PLN     = "TMPLAT_REUNIF_CNCUR_PERM_PLN";
  public static final String TMPLAT_REUNIF_GOAL_TYPES         = "TMPLAT_REUNIF_GOAL_TYPES";
  public static final String TMPLAT_REUNIF_GOAL_STEPS         = "TMPLAT_REUNIF_GOAL_STEPS";
  public static final String TMPLAT_NON_AFC_1                 =  "TMPLAT_NON_AFC_1";
  public static final String TMPLAT_NON_AFC                 =  "TMPLAT_NON_AFC";
  public static final String TMPLAT_AFTERCARE_PLAN            = "TMPLAT_AFTERCARE_PLAN";
  public static final String TMPLAT_AFTERCARE_GOAL_TYPES      = "TMPLAT_AFTERCARE_GOAL_TYPES";
  public static final String TMPLAT_AFTERCARE_GOAL_STEPS      = "TMPLAT_AFTERCARE_GOAL_STEPS";
  public static final String TMPLAT_AFTERCARE_CAREGIVER_NAME  = "TMPLAT_AFTERCARE_CAREGIVER_NAME";
  public static final String TMPLAT_DFCS_PLAN                 = "TMPLAT_DFCS_PLAN";
  public static final String TMPLAT_DFCS_GOAL_TYPES           = "TMPLAT_DFCS_GOAL_TYPES";
  public static final String TMPLAT_DFCS_GOAL_STEPS           = "TMPLAT_DFCS_GOAL_STEPS"; 
  public static final String TMPLAT_NON_REUNIF_PLAN           = "TMPLAT_NON_REUNIF_PLAN";
  public static final String TMPLAT_NON_REUNIF_CNCUR_PERM_PLN = "TMPLAT_NON_REUNIF_CNCUR_PERM_PLN";
  public static final String TMPLAT_NON_REUNIF_GOAL_TYPES     = "TMPLAT_NON_REUNIF_GOAL_TYPES";
  public static final String TMPLAT_NON_REUNIF_GOAL_STEPS     = "TMPLAT_NON_REUNIF_GOAL_STEPS";  
  public static final String TMPLAT_SECONDARY_PLAN            = "TMPLAT_SECONDARY_PLAN";
  public static final String TMPLAT_SCNDRY_GOAL_TYPES         = "TMPLAT_SCNDRY_GOAL_TYPES";
  public static final String TMPLAT_FCCP_CHLD_NRE             = "TMPLAT_FCCP_CHLD_NRE";
  public static final String TMPLAT_CURRENT_PLACEMENT         = "TMPLAT_CURRENT_PLACEMENT";
  public static final String TMPLAT_WTLP_GOAL_TYPE            = "TMPLAT_WTLP_GOAL_TYPE";
  public static final String TMPLAT_WTLP_GOAL_TYPES           = "TMPLAT_WTLP_GOAL_TYPES";
  public static final String TMPLAT_WTLP_GOAL_STEPS           = "TMPLAT_WTLP_GOAL_STEPS";  
  public static final String TMPLAT_PLCMT_HISTORY             = "TMPLAT_PLCMT_HISTORY";
  public static final String TMPLAT_PLCMT_HISTORY_LIST        = "TMPLAT_PLCMT_HISTORY_LIST";
  public static final String TMPLAT_HEALTHCARE_PROVIDER       = "TMPLAT_HEALTHCARE_PROVIDER";
  public static final String TMPLAT_HEALTHCARE_PRVDR_LIST     = "TMPLAT_HEALTHCARE_PRVDR_LIST";
  public static final String TMPLAT_HEALTH_STATUS             = "TMPLAT_HEALTH_STATUS";
  public static final String TMPLAT_EDUCATION                 = "TMPLAT_EDUCATION";
  public static final String TMPLAT_PARTICIATION_DISCLOSURE   = "TMPLAT_PARTICIATION_DISCLOSURE";
  public static final String TMPLAT_PARTICIATION_lIST         = "TMPLAT_PARTICIATION_lIST";
  public static final String TMPLAT_VISITATION_PLAN_lIST      = "TMPLAT_VISITATION_PLAN_lIST";
  public static final String TMPLAT_VISITATION_PLAN           = "TMPLAT_VISITATION_PLAN";
  public static final String TMPLAT_WTLP                      = "TMPLAT_WTLP";
  public static final String TMPLAT_ADO_INFO 				  = "TMPLAT_ADO_INFO"; 
  
  
  // individual fields
    // Miscellaneous
  public static final String NEEDS_CONCL_TASK_CODE = "2340";
  public static final String SPACE = " ";
  public static final String CAPX = "X";
  public static final String DOUBLEUNDERSCORE = "__";
  public static final String YES = "Y";
  public static final String NO  = "N";
  public static final String NA  = "A";
  public static final String VISIT_PLAN_NARR = "VISIT_PLAN_NARR";
  
  public static final int    FOURTEEN = 14;
  public static final int    FOUR     = 4;
  public static final int    EIGHTEEN = 18;
  

    //Header
  public static final String REPORT_COUNTY      = "REPORT_COUNTY";
  public static final String TODAY_DATE         = "TODAY_DATE";
  public static final String CASE_REVIEW_MTHD   = "CASE_REVIEW_MTHD";
    //Case Header
  public static final String CHILD_INFO_CHLD_FULLNAME = "CHILD_INFO_CHLD_FULLNAME";
  public static final String FCCP_FAM_ID_CASE         = "FCCP_FAM_ID_CASE";
  public static final String DT_CURR_CASE_RVW_DT      = "DT_CURR_CASE_RVW_DT";
  public static final String DT_NEXT_CASE_RVW_DT      = "DT_NEXT_CASE_RVW_DT";
    // Child Info  
  public static final String CHILD_FULL_NAME    = "CHILD_FULL_NAME";
  public static final String DT_CHILD_DOB       = "DT_CHILD_DOB";
  public static final String CHILD_GENDER       = "CHILD_GENDER";
  public static final String CHILD_RACE         = "CHILD_RACE";
  public static final String CHILD_ETHNICITY    = "CHILD_ETHNICITY";
  public static final String CHILD_PLAN_TYPE    = "CHILD_PLAN_TYPE";
  public static final String CHILD_INTL_RVW     = "CHILD_INTL_RVW";
  public static final String CHILD_LEGAL_STATUS = "CHILD_LEGAL_STATUS";
  //Added for MR-057 APPLA
  public static final String DT_CHILD_LEGAL_STATUS = "DT_CHILD_LEGAL_STATUS";
  public static final String ASSIGNED_JUDGE     = "ASSIGNED_JUDGE";
  public static final String DT_INTL_CP_FILED   = "DT_INTL_CP_FILED";
  
  // STGAP00005914 Adding  the CareTaker Information Section back  
  public static final String DT_APPROVAL        = "DT_APPROVAL";
    // Caretaker info
  public static final String CARETAKER_TYPE             = "CARETAKER_TYPE";
  public static final String CARETAKER_FULLNAME         = "CARETAKER_FULLNAME";
  public static final String CARETAKER_DOB              = "CARETAKER_DOB";
  public static final String CARETAKER_ADDRESS_STREET   = "CARETAKER_ADDRESS_STREET";
  public static final String CARETAKER_ADDRESS_STATE    = "CARETAKER_ADDRESS_STATE";  
  public static final String CARETAKER_PHONE_NBR        = "CARETAKER_PHONE_NBR";
  public static final String CARETAKER_COMMENTS         = "CARETAKER_COMMENTS";
  
    // STGAP00005914 Relative info
  public static final String RELATIVE_TYPE             = "RELATIVE_TYPE";
  public static final String RELATIVE_FULLNAME         = "RELATIVE_FULLNAME";
  public static final String RELATIVE_SIDE_OF_FAMILY   = "RELATIVE_SIDE_OF_FAMILY";
  public static final String RELATIVE_ADDRESS_STREET   = "RELATIVE_ADDRESS_STREET";
  public static final String RELATIVE_ADDRESS_STATE    = "RELATIVE_ADDRESS_STATE";  
  public static final String RELATIVE_PHONE_NBR        = "RELATIVE_PHONE_NBR";
  public static final String RELATIVE_COMMENTS         = "RELATIVE_COMMENTS";
  
  // Case Manager info
  public static final String CASEMNGR_NAME             = "CASEMNGR_NAME";
  public static final String CASEMNGR_ADDRESS_STREET   = "CASEMNGR_ADDRESS_STREET";
  public static final String CASEMNGR_STATE_ZIP        = "CASEMNGR_STATE_ZIP";
  public static final String CASEMNGR_PHONE_NBR        = "CASEMNGR_PHONE_NBR";
  public static final String CASEMNGR_SPRVISOR_NAME    = "CASEMNGR_SPRVISOR_NAME";  
  public static final String CASEMNGR_SPRVISOR_PHONE_NBR = "CASEMNGR_SPRVISOR_PHONE_NBR";
  // Case Tracking and Legal info
  public static final String CT_LGL_CHILD_NAME             = "CT_LGL_CHILD_NAME";
  public static final String DT_CCFA_REFERRAL              = "DT_CCFA_REFERRAL";
  public static final String DT_FAM_TEAM_MEET              = "DT_FAM_TEAM_MEET";
  public static final String DT_MULTI_DISC_TEAM_MEET       = "DT_MULTI_DISC_TEAM_MEET";
  public static final String DT_COMP_ASSMT_CMPLT           = "DT_COMP_ASSMT_CMPLT";  
  public static final String DT_INITIAL_CASE_PLAN          = "DT_INITIAL_CASE_PLAN";
  public static final String DT_CURR_CASE_PLAN_RVW         = "DT_CURR_CASE_PLAN_RVW";
  public static final String DT_PREV_RVW                   = "DT_PREV_RVW";
  public static final String DT_NEXT_RVW                   = "DT_NEXT_RVW";
  public static final String DT_CHLD_RMVD_FRM_HOME         = "DT_CHLD_RMVD_FRM_HOME";
  public static final String DT_INIT_AUTH_PLCMT            = "DT_INIT_AUTH_PLCMT";  
  public static final String DT_EMRGNCY_SHELTER_CARE_ORDER = "DT_EMRGNCY_SHELTER_CARE_ORDER";
  public static final String DT_DTNTN_ORDER_72_HR          = "DT_DTNTN_ORDER_72_HR";
  public static final String DT_ADJUDICATORY_ORDER         = "DT_ADJUDICATORY_ORDER";
  public static final String DT_DISPOSITIONAL_ORDER        = "DT_DISPOSITIONAL_ORDER";
  public static final String DT_FINAL_DSPSTN_ORDER         = "DT_FINAL_DSPSTN_ORDER";
  public static final String DT_CUSTODY_EXPRTN_DT          = "DT_CUSTODY_EXPRTN_DT";  
  public static final String DT_EXTENDSION_ORDER           = "DT_EXTENDSION_ORDER";
  public static final String DT_DLGNT_SEARCH_CMPLT         = "DT_DLGNT_SEARCH_CMPLT";
  public static final String DT_DLGNT_SEARCH_RULING        = "DT_DLGNT_SEARCH_RULING";
  public static final String DT_CASE_PLAN_SUPP_ORDER       = "DT_CASE_PLAN_SUPP_ORDER";
  public static final String DT_PERMANENCY_ORDER           = "DT_PERMANENCY_ORDER";
  public static final String DT_NON_REUNIFICATION_ORDER    = "DT_NON_REUNIFICATION_ORDER";  
  public static final String DT_TPR_FILED                  = "DT_TPR_FILED";
  public static final String DT_TPR_VS_ACHVD               = "DT_TPR_VS_ACHVD";
  public static final String IND_TPR_APPEALED              = "IND_TPR_APPEALED";
  public static final String DT_ANT_DT_ACHVMT_PERMANENCY   = "DT_ANT_DT_ACHVMT_PERMANENCY";
  public static final String COURT_PLAN_TYPE               = "COURT_PLAN_TYPE";  
  public static final String PRIMARY_PERMANCY_PLAN         = "PRIMARY_PERMANCY_PLAN";
  public static final String TXT_COMP_REASON_PERM          = "TXT_COMP_REASON_PERM";
  public static final String SECONDARY_PERMANCY_PLAN       = "SECONDARY_PERMANCY_PLAN";
  public static final String TXT_COMP_REASON_CONC_PERM     = "TXT_COMP_REASON_CONC_PERM";
  // Removal and Separation
  public static final String REMOVAL_CHILD_FULL_NAME    = "REMOVAL_CHILD_FULL_NAME";
  public static final String PHYSICAL_ABUSE             = "PHYSICAL_ABUSE";
  public static final String ABANDONMENT                = "ABANDONMENT";
  public static final String SEXUAL_ABUSE               = "SEXUAL_ABUSE";
  public static final String PARENT_DRUG_ABUSE          = "PARENT_DRUG_ABUSE";
  public static final String PARENT_ALCOHOL_ABUSE       = "PARENT_ALCOHOL_ABUSE";  
  public static final String NEGLECT                    = "NEGLECT";
  public static final String INADEQUATE_HOUSING         = "INADEQUATE_HOUSING";
  public static final String CARETAKER_NOT_COPING       = "CARETAKER_NOT_COPING";
  public static final String PARENT_DEATH               = "PARENT_DEATH";
  public static final String CHILD_DRUG_ABUSE           = "CHILD_DRUG_ABUSE";  
  public static final String CHILD_ALCOHOL_ABUSE        = "CHILD_ALCOHOL_ABUSE";
  public static final String CHILD_BEHAVIOR_PROBLEM     = "CHILD_BEHAVIOR_PROBLEM";
  public static final String PARENT_INCARCERATION       = "PARENT_INCARCERATION";
  public static final String RELINQUISHMENT             = "RELINQUISHMENT";
  public static final String CHILD_DISABILITY           = "CHILD_DISABILITY";
  public static final String EFFORTS_PRVNT_RMVL         = "EFFORTS_PRVNT_RMVL";
  public static final String RSN_CHILD_PLCD_IN_FH       = "RSN_CHILD_PLCD_IN_FH";
  public static final String RSN_CHLD_NOT_PRTCT_AT_HOME = "RSN_CHLD_NOT_PRTCT_AT_HOME";
  public static final String CHILD_FUTURE_HARM_AT_HOME  = "CHILD_FUTURE_HARM_AT_HOME";
  public static final String CHILD_15_22_YES            = "CHILD_15_22_YES";  
  public static final String CHILD_15_22_NO             = "CHILD_15_22_NO";
  public static final String CHILD_ABNDND_OCGA_YES      = "CHILD_ABNDND_OCGA_YES";
  public static final String CHILD_ABNDND_OCGA_NO       = "CHILD_ABNDND_OCGA_NO";
  public static final String PARENT_COMMIT_MURDER_YES   = "PARENT_COMMIT_MURDER_YES";
  public static final String PARENT_COMMIT_MURDER_NO    = "PARENT_COMMIT_MURDER_NO";
  public static final String PARENT_AIDED_MURDER_YES    = "PARENT_AIDED_MURDER_YES";
  public static final String PARENT_AIDED_MURDER_NO     = "PARENT_AIDED_MURDER_NO";
  public static final String PARENT_COMMIT_FELONY_YES   = "PARENT_COMMIT_FELONY_YES";
  public static final String PARENT_COMMIT_FELONY_NO    = "PARENT_COMMIT_FELONY_NO";
  public static final String RELATIVE_CARING_FOR_CHILD  = "RELATIVE_CARING_FOR_CHILD";  
  public static final String RSN_PRNT_RIGHT_TERMINATION = "RSN_PRNT_RIGHT_TERMINATION";
  public static final String DFCS_CHLD_SAFE_RETURN_HOME = "DFCS_CHLD_SAFE_RETURN_HOME";
  public static final String REMOVAL_YES_DETAILS        = "REMOVAL_YES_DETAILS";
  
  // Reunification Goals
  public static final String REUNIF_CHILD_FULL_NAME     = "REUNIF_CHILD_FULL_NAME";
  public static final String DT_CURR_REUNIF_REVIEW_DT   = "DT_CURR_REUNIF_REVIEW_DT";
  public static final String DT_PREV_REUNIF_REVIEW_DT   = "DT_PREV_REUNIF_REVIEW_DT";  
  public static final String DT_NEXT_REUNIF_REVIEW_DT   = "DT_NEXT_REUNIF_REVIEW_DT";
  public static final String REUNIF_PLAN_TYPE           = "REUNIF_PLAN_TYPE";
  public static final String REUNIF_PERMNCY_PLAN        = "REUNIF_PERMNCY_PLAN";
  public static final String REUNIF_PERMNCY_PLN_CMNT    = "REUNIF_PERMNCY_PLN_CMNT";
  public static final String REUNIF_CNCRRNT_PLAN        = "REUNIF_CNCRRNT_PLAN";
  public static final String REUNIF_CNCRRNT_PLAN_CMNT   = "REUNIF_CNCRRNT_PLAN_CMNT";
  public static final String REUNIF_GOAL_TYPE           = "REUNIF_GOAL_TYPE";
  public static final String REUNIF_GOAL_REASON         = "REUNIF_GOAL_REASON";  
  public static final String REUNIF_GOAL_CHANGE_GOAL    = "REUNIF_GOAL_CHANGE_GOAL";
  public static final String REUNIF_GOAL_STEP_SEQ       = "REUNIF_GOAL_STEP_SEQ";
  public static final String REUNIF_STEP_SPECIFIC_ACTN  = "REUNIF_STEP_SPECIFIC_ACTN";
  public static final String REUNIF_STEP_RESP_PRSN      = "REUNIF_STEP_RESP_PRSN";
  public static final String REUNIF_STEP_PRIORITY       = "REUNIF_STEP_PRIORITY";
  public static final String REUNIF_STEP_CMPLTN_DT      = "REUNIF_STEP_CMPLTN_DT";
  public static final String REUNIF_STEP_STATUS         = "REUNIF_STEP_STATUS";
  public static final String REUNIF_STEP_COMMENTS       = "REUNIF_STEP_COMMENTS";
  
  // After Case Plan
  public static final String AFTERCARE_CHILD_FULLNAME      = "AFTERCARE_CHILD_FULLNAME";
  public static final String AFTERCARE_CASE_NAME           = "AFTERCARE_CASE_NAME";
  public static final String AFTERCARE_CASE_PLN_BTWN       = "AFTERCARE_CASE_PLN_BTWN";
  public static final String AFTERCARE_CAREGIVER_NAME      = "AFTERCARE_CAREGIVER_NAME";
  public static final String AFTERCARE_CASE_MNGR_NAME      = "AFTERCARE_CASE_MNGR_NAME";
  public static final String AFTERCARE_COUNTY              = "AFTERCARE_COUNTY";
  public static final String AFTERCARE_CASE_MNGR_PH        = "AFTERCARE_CASE_MNGR_PH";
  public static final String AFTERCARE_DT_CHLD_DISCHARGED  = "AFTERCARE_DT_CHLD_DISCHARGED";  
  public static final String AFTERCARE_RSN_CHLD_DISCHARGED = "AFTERCARE_RSN_CHLD_DISCHARGED";
  public static final String AFTERCARE_DT_DURATION_FROM    = "AFTERCARE_DT_DURATION_FROM";
  public static final String AFTERCARE_DT_DURATION_TO      = "AFTERCARE_DT_DURATION_TO";
  public static final String AFTERCARE_GOAL_REASON         = "AFTERCARE_GOAL_REASON";
  public static final String AFTERCARE_GOAL_CHANGE_GOAL    = "AFTERCARE_GOAL_CHANGE_GOAL";
  public static final String AFTERCARE_GOAL_STEP_SEQ       = "AFTERCARE_GOAL_STEP_SEQ";
  public static final String AFTERCARE_STEP_SPECIFIC_ACTN  = "AFTERCARE_STEP_SPECIFIC_ACTN";
  public static final String AFTERCARE_STEP_RESP_PRSN      = "AFTERCARE_STEP_RESP_PRSN";
  public static final String AFTERCARE_STEP_PRIORITY       = "AFTERCARE_STEP_PRIORITY";
  public static final String AFTERCARE_STEP_CMPLTN_DT      = "AFTERCARE_STEP_CMPLTN_DT";
  public static final String AFTERCARE_STEP_STATUS         = "AFTERCARE_STEP_STATUS";
  public static final String AFTERCARE_COMMENTS            = "AFTERCARE_COMMENTS";
  
  // DFCS standard goals
  public static final String DFCS_CHILD_FULLNAME      = "DFCS_CHILD_FULLNAME";
  public static final String DFCS_CURR_CASE_PLAN_DT   = "DFCS_CURR_CASE_PLAN_DT";
  public static final String DFCS_PREV_CASE_PLAN_DT   = "DFCS_PREV_CASE_PLAN_DT";  
  public static final String DFCS_NEXT_CASE_PLAN_DT   = "DFCS_NEXT_CASE_PLAN_DT";
  public static final String DFCS_GOAL_TYPE           = "DFCS_GOAL_TYPE";
  public static final String DFCS_GOAL_CHANGE_GOAL    = "DFCS_GOAL_CHANGE_GOAL";
  public static final String DFCS_GOAL_STEP_SEQ       = "DFCS_GOAL_STEP_SEQ";
  public static final String DFCS_STEP_SPECIFIC_ACTN  = "DFCS_STEP_SPECIFIC_ACTN";
  public static final String DFCS_STEP_RESP_PRSN      = "DFCS_STEP_RESP_PRSN";
  public static final String DFCS_STEP_PRIORITY       = "DFCS_STEP_PRIORITY";
  public static final String DFCS_STEP_CMPLTN_DT      = "DFCS_STEP_CMPLTN_DT";
  public static final String DFCS_STEP_STATUS         = "DFCS_STEP_STATUS";
  public static final String DFCS_STEP_COMMENTS       = "DFCS_STEP_COMMENTS";
  
  // Steps for all parents
  public static final String STEPS_PARENTS_CHILD_FULL_NAME = "STEPS_PARENTS_CHILD_FULL_NAME";
  
  // Non-Reunification Goals
  public static final String NON_REUNIF_CHILD_FULL_NAME     = "NON_REUNIF_CHILD_FULL_NAME";
  public static final String NON_REUNIF_CURR_REVIEW_DT      = "NON_REUNIF_CURR_REVIEW_DT";
  public static final String NON_REUNIF_PREV_REVIEW_DT      = "NON_REUNIF_PREV_REVIEW_DT";  
  public static final String NON_REUNIF_NEXT_REVIEW_DT      = "NON_REUNIF_NEXT_REVIEW_DT";
  public static final String NON_REUNIF_PLAN_TYPE           = "NON_REUNIF_PLAN_TYPE";
  public static final String NON_REUNIF_PERMNCY_PLAN        = "NON_REUNIF_PERMNCY_PLAN";
  public static final String NON_REUNIF_PERMNCY_PLN_CMNT    = "NON_REUNIF_PERMNCY_PLN_CMNT";
  public static final String NON_REUNIF_CNCRRNT_PLAN        = "NON_REUNIF_CNCRRNT_PLAN";
  public static final String NON_REUNIF_CNCRRNT_PLAN_CMNT   = "NON_REUNIF_CNCRRNT_PLAN_CMNT";
  public static final String NON_REUNIF_GOAL_TYPE           = "NON_REUNIF_GOAL_TYPE";
  public static final String NON_REUNIF_GOAL_REASON         = "NON_REUNIF_GOAL_REASON";  
  public static final String NON_REUNIF_GOAL_CHANGE_GOAL    = "NON_REUNIF_GOAL_CHANGE_GOAL";
  public static final String NON_REUNIF_GOAL_STEP_SEQ       = "NON_REUNIF_GOAL_STEP_SEQ";
  public static final String NON_REUNIF_STEP_SPECIFIC_ACTN  = "NON_REUNIF_STEP_SPECIFIC_ACTN";
  public static final String NON_REUNIF_STEP_RESP_PRSN      = "NON_REUNIF_STEP_RESP_PRSN";
  public static final String NON_REUNIF_STEP_PRIORITY       = "NON_REUNIF_STEP_PRIORITY";
  public static final String NON_REUNIF_STEP_CMPLTN_DT      = "NON_REUNIF_STEP_CMPLTN_DT";
  public static final String NON_REUNIF_STEP_STATUS         = "NON_REUNIF_STEP_STATUS";
  public static final String NON_REUNIF_COMMENTS            = "NON_REUNIF_COMMENTS";
  
  // Secondary Goals
  public static final String SCNDRY_CHILD_FULLNAME = "SCNDRY_CHILD_FULLNAME";
  public static final String SCNDRY_DESC           = "SCNDRY_DESC";
  public static final String SCNDRY_GOAL_STATUS    = "SCNDRY_GOAL_STATUS";
  
  // FCCP Child Non-Reunification
  public static final String FCCP_CHLD_NRE_CHLD_FULLNAME  = "FCCP_CHLD_NRE_CHLD_FULLNAME";
  public static final String FCCP_CHLD_NRE_IND_TPR_YES    = "FCCP_CHLD_NRE_IND_TPR_YES";
  public static final String FCCP_CHLD_NRE_IND_TPR_NO     = "FCCP_CHLD_NRE_IND_TPR_NO";
  public static final String FCCP_CHLD_NRE_DT_TPR         = "FCCP_CHLD_NRE_DT_TPR";
  public static final String FCCP_CHLD_NRE_TXT_TPR        = "FCCP_CHLD_NRE_TXT_TPR";  
  public static final String FCCP_CHLD_NRE_TXT_STEPS      = "FCCP_CHLD_NRE_TXT_STEPS";
  public static final String FCCP_CHLD_NRE_TXT_ADDTL_INFO = "FCCP_CHLD_NRE_TXT_ADDTL_INFO";
  public static final String FCCP_CHLD_NRE_NCR            = "FCCP_CHLD_NRE_NCR";
  public static final String FCCP_CHLD_NRE_NVS            = "FCCP_CHLD_NRE_NVS";
  public static final String FCCP_CHLD_NRE_NAB            = "FCCP_CHLD_NRE_NAB";
  public static final String FCCP_CHLD_NRE_NDC            = "FCCP_CHLD_NRE_NDC";
  public static final String FCCP_CHLD_NRE_NMD            = "FCCP_CHLD_NRE_NMD";
  public static final String FCCP_CHLD_NRE_NPD            = "FCCP_CHLD_NRE_NPD";  
  public static final String FCCP_CHLD_NRE_NCV            = "FCCP_CHLD_NRE_NCV";   
  public static final String FCCP_CHLD_NRE_NEC            = "FCCP_CHLD_NRE_NEC";
  public static final String FCCP_CHLD_NRE_NPN            = "FCCP_CHLD_NRE_NPN";
  public static final String FCCP_CHLD_NRE_NID            = "FCCP_CHLD_NRE_NID";
  public static final String FCCP_CHLD_NRE_NPB            = "FCCP_CHLD_NRE_NPB";
  public static final String FCCP_CHLD_NRE_NPV            = "FCCP_CHLD_NRE_NPV";
  public static final String FCCP_CHLD_NRE_NCO            = "FCCP_CHLD_NRE_NCO";
  public static final String FCCP_CHLD_NRE_NTR            = "FCCP_CHLD_NRE_NTR";
  
  
  // Current Placement
  public static final String CURR_PLCMT_CHLD_FULLNAME          = "CURR_PLCMT_CHLD_FULLNAME";
  public static final String CURR_PLCMT_IND_COMP_REFERRAL_Y    = "CURR_PLCMT_IND_COMP_REFERRAL_Y";
  public static final String CURR_PLCMT_IND_COMP_REFERRAL_N    = "CURR_PLCMT_IND_COMP_REFERRAL_N";
  public static final String CURR_PLCMT_PLCMT_RCMDTN_Y         = "CURR_PLCMT_PLCMT_RCMDTN_Y";
  public static final String CURR_PLCMT_PLCMT_RCMDTN_N         = "CURR_PLCMT_PLCMT_RCMDTN_N";
  public static final String CURR_PLCMT_IND_PLCMT_CCFA_Y       = "CURR_PLCMT_IND_PLCMT_CCFA_Y";
  public static final String CURR_PLCMT_IND_PLCMT_CCFA_N       = "CURR_PLCMT_IND_PLCMT_CCFA_N";  
  public static final String CURR_PLCMT_TXT_PLCMT_CCFA         = "CURR_PLCMT_TXT_PLCMT_CCFA";  
  public static final String CURR_PLCMT_ADDR_PLCMT_CNTY        = "CURR_PLCMT_ADDR_PLCMT_CNTY";  
  public static final String CURR_PLCMT_ADDR_PLCMT_ST          = "CURR_PLCMT_ADDR_PLCMT_ST";
  public static final String CURR_PLCMT_CHLD_PLCMT_DT          = "CURR_PLCMT_CHLD_PLCMT_DT";
  public static final String CURR_PLCMT_PARENT_NOTIF_DT        = "CURR_PLCMT_PARENT_NOTIF_DT";
  public static final String CURR_PLCMT_IND_EMRGCY_PLCMT_Y     = "CURR_PLCMT_IND_EMRGCY_PLCMT_Y";
  public static final String CURR_PLCMT_IND_EMRGCY_PLCMT_N     = "CURR_PLCMT_IND_EMRGCY_PLCMT_N";
  public static final String CURR_PLCMT_PREPLCMT_VISIT_DT      = "CURR_PLCMT_PREPLCMT_VISIT_DT";
  public static final String CURR_PLCMT_CD_PCLMT_TYPE          = "CURR_PLCMT_CD_PCLMT_TYPE";
  public static final String CURR_PLCMT_PRSN_LVNG_ARRGMT       = "CURR_PLCMT_PRSN_LVNG_ARRGMT";
  public static final String CURR_PLCMT_RELATIVE_RLTNSHP       = "CURR_PLCMT_RELATIVE_RLTNSHP";  
  public static final String CURR_PLCMT_RELATIVE_NAME          = "CURR_PLCMT_RELATIVE_NAME";   
  public static final String CURR_PLCMT_HM_EVAL_COMP_Y         = "CURR_PLCMT_HM_EVAL_COMP_Y";
  public static final String CURR_PLCMT_HM_EVAL_COMP_N         = "CURR_PLCMT_HM_EVAL_COMP_N";
  public static final String CURR_PLCMT_RLTV_HM_EVAL_COMP_DT   = "CURR_PLCMT_RLTV_HM_EVAL_COMP_DT";
  public static final String CURR_PLCMT_IND_RLTV_HM_APRVD_Y    = "CURR_PLCMT_IND_RLTV_HM_APRVD_Y";
  public static final String CURR_PLCMT_IND_RLTV_HM_APRVD_N    = "CURR_PLCMT_IND_RLTV_HM_APRVD_N";
  public static final String CURR_PLCMT_DFCS_CMNT              = "CURR_PLCMT_DFCS_CMNT";
  public static final String CURR_PLCMT_RLTV_HM_EVAL_APRVD_DT  = "CURR_PLCMT_RLTV_HM_EVAL_APRVD_DT";
  public static final String CURR_PLCMT_IND_DLGNT_SEARCH_Y     = "CURR_PLCMT_IND_DLGNT_SEARCH_Y";
  public static final String CURR_PLCMT_IND_DLGNT_SEARCH_N     = "CURR_PLCMT_IND_DLGNT_SEARCH_N";
  public static final String CURR_PLCMT_CHK_PLCMT_SAFE_Y       = "CURR_PLCMT_CHK_PLCMT_SAFE_Y";
  public static final String CURR_PLCMT_CHK_PLCMT_SAFE_N       = "CURR_PLCMT_CHK_PLCMT_SAFE_N";
  public static final String CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y = "CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_Y";
  public static final String CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N = "CURR_PLCMT_CHK_LST_RSTRCT_AVAIL_N";
  public static final String CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_Y  = "CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_Y";
  public static final String CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_N  = "CURR_PLCMT_CHK_FMLY_LIKE_AVAIL_N";
  public static final String CURR_PLCMT_CHK_PLCMT_APPROP_Y     = "CURR_PLCMT_CHK_PLCMT_APPROP_Y";
  public static final String CURR_PLCMT_CHK_PLCMT_APPROP_N     = "CURR_PLCMT_CHK_PLCMT_APPROP_N";
  public static final String CURR_PLCMT_CHK_PRXMT_PARENT_Y     = "CURR_PLCMT_CHK_PRXMT_PARENT_Y";
  public static final String CURR_PLCMT_CHK_PRXMT_PARENT_N     = "CURR_PLCMT_CHK_PRXMT_PARENT_N";
  public static final String CURR_PLCMT_CHK_CHLD_BEST_INTRST_Y = "CURR_PLCMT_CHK_CHLD_BEST_INTRST_Y";
  public static final String CURR_PLCMT_CHK_CHLD_BEST_INTRST_N = "CURR_PLCMT_CHK_CHLD_BEST_INTRST_N";
  public static final String CURR_PLCMT_TXT_PLCMT_CHECKLIST    = "CURR_PLCMT_TXT_PLCMT_CHECKLIST";
  public static final String CURR_PLCMT_RSN_PLCMT_DISCUSS_DT   = "CURR_PLCMT_RSN_PLCMT_DISCUSS_DT";
  public static final String CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_Y = "CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_Y";
  public static final String CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_N = "CURR_PLCMT_IND_CHLD_EXPR_TRAUMA_N";
  public static final String CURR_PLCMT_TXT_PLCMT_TRAUMA       = "CURR_PLCMT_TXT_PLCMT_TRAUMA";
  public static final String CURR_PLCMT_TXT_PLCMT_DISCUSS      = "CURR_PLCMT_TXT_PLCMT_DISCUSS";
  public static final String CURR_PLCMT_CHLD_AGE_GT_14_Y       = "CURR_PLCMT_CHLD_AGE_GT_14_Y";
  public static final String CURR_PLCMT_CHLD_AGE_GT_14_N       = "CURR_PLCMT_CHLD_AGE_GT_14_N";
  public static final String CURR_PLCMT_CHLD_ADJ_IN_CARE_Y     = "CURR_PLCMT_CHLD_ADJ_IN_CARE_Y";
  public static final String CURR_PLCMT_CHLD_ADJ_IN_CARE_N     = "CURR_PLCMT_CHLD_ADJ_IN_CARE_N";
  public static final String CURR_PLCMT_CHLD_ADJ_COMM          = "CURR_PLCMT_CHLD_ADJ_COMM";
  public static final String CURR_PLCMT_IND_PLCMT_SIBLINGS_Y   = "CURR_PLCMT_IND_PLCMT_SIBLINGS_Y";
  public static final String CURR_PLCMT_IND_PLCMT_SIBLINGS_N   = "CURR_PLCMT_IND_PLCMT_SIBLINGS_N";
  public static final String CURR_PLCMT_IND_PLCMT_SIBLINGS_A   = "CURR_PLCMT_IND_PLCMT_SIBLINGS_A";
  public static final String CURR_PLCMT_TXT_SIBLINGS_COMM      = "CURR_PLCMT_TXT_SIBLINGS_COMM";
  public static final String CURR_PLCMT_CAREGVR_DISCUSS_DT     = "CURR_PLCMT_CAREGVR_DISCUSS_DT";
  public static final String CURR_PLCMT_MEDDEV_HISTORY_DT      = "CURR_PLCMT_MEDDEV_HISTORY_DT";
  public static final String CURR_PLCMT_EDUC_LOG_DT            = "CURR_PLCMT_EDUC_LOG_DT";
  public static final String CURR_PLCMT_SCHOOL_RECORDS_DT      = "CURR_PLCMT_SCHOOL_RECORDS_DT";
  public static final String CURR_PLCMT_CHILD_PLAN_DT          = "CURR_PLCMT_CHILD_PLAN_DT";
  public static final String CURR_PLCMT_TXT_PLCMT_DOCUMENTS    = "CURR_PLCMT_TXT_PLCMT_DOCUMENTS";
  public static final String CURR_PLCMT_CHILD_SCHOOL_CHANGE_Y     = "CURR_PLCMT_CHILD_SCHOOL_CHANGE_Y";
  public static final String CURR_PLCMT_CHILD_SCHOOL_CHANGE_N     = "CURR_PLCMT_CHILD_SCHOOL_CHANGE_N";
  
  //41275 MR057 APPLA fields added
  public static final String CURR_PLCMT_APPLA_LTFC_Y           = "CURR_PLCMT_APPLA_LTFC_Y";
  public static final String CURR_PLCMT_APPLA_LTFC_N           = "CURR_PLCMT_APPLA_LTFC_N";
  public static final String CURR_PLCMT_AGREEMENT_SIGNED_DT    = "CURR_PLCMT_AGREEMENT_SIGNED_DT";
  public static final String CURR_PLCMT_CONNECTED_ADULT_Y      = "CURR_PLCMT_CONNECTED_ADULT_Y";
  public static final String CURR_PLCMT_CONNECTED_ADULT_N      = "CURR_PLCMT_CONNECTED_ADULT_N";
  public static final String CURR_PLCMT_CONNECTED_ADULT        = "CURR_PLCMT_CONNECTED_ADULT";
  public static final String CURR_PLCMT_TEMP_Y                 = "CURR_PLCMT_TEMP_Y";
  public static final String CURR_PLCMT_TEMP_N                 = "CURR_PLCMT_TEMP_N";
  public static final String CURR_PLCMT_TEMP_TYPE              = "CURR_PLCMT_TEMP_TYPE";

  
  // WTLP 
  public static final String WTLP_CHLD_FULLNAME       = "WTLP_CHLD_FULLNAME";
  public static final String WTLP_COUNTY              = "WTLP_COUNTY";
  public static final String WTLP_YDP_FULLNAME        = "WTLP_YDP_FULLNAME";
  public static final String WTLP_YDP_PH_NBR          = "WTLP_YDP_PH_NBR";
  public static final String WTLP_CASE_MNGR_FNAME     = "WTLP_CASE_MNGR_FNAME";  
  public static final String WTLP_CASE_MNGR_PH_NBR    = "WTLP_CASE_MNGR_PH_NBR";
  public static final String WTLP_DT                  = "WTLP_DT";
  public static final String WTLP_DOB                 = "WTLP_DOB";
  public static final String WTLP_GENDER              = "WTLP_GENDER";
  public static final String WTLP_RACE_ETHNCTY        = "WTLP_RACE_ETHNCTY";
  public static final String WTLP_ELIGIBILITY         = "WTLP_ELIGIBILITY";
  public static final String WTLP_CURR_LV_ARR         = "WTLP_CURR_LV_ARR";
  public static final String WTLP_TYPE                = "WTLP_TYPE";  
  public static final String WTLP_CUST_STAT           = "WTLP_CUST_STAT";   
  public static final String WTLP_MRTL_STAT           = "WTLP_MRTL_STAT";
  public static final String WTLP_PARENT_STATUS       = "WTLP_PARENT_STATUS";
  public static final String WTLP_AUTHRTY_PLCMT       = "WTLP_AUTHRTY_PLCMT";
  public static final String WTLP_EXPTD_GRAD_DT       = "WTLP_EXPTD_GRAD_DT";
  public static final String WTLP_ACDMY_TRACK         = "WTLP_ACDMY_TRACK";
  public static final String WTLP_EDU_CRDT_GRAD_REQ  = "WTLP_EDU_CRDT_GRAD_REQ";
  public static final String WTLP_EDU_CRDT_GRAD_ERND  = "WTLP_EDU_CRDT_GRAD_ERND";
  public static final String WTLP_EMNCPTN_DISC_YTH_Y  = "WTLP_EMNCPTN_DISC_YTH_Y";
  public static final String WTLP_EMNCPTN_DISC_YTH_N  = "WTLP_EMNCPTN_DISC_YTH_N";
  public static final String WTLP_EMNCPTN_DISC_DT     = "WTLP_EMNCPTN_DISC_DT";
  public static final String WTLP_EMNCPTN_DISC_COMM   = "WTLP_EMNCPTN_DISC_COMM";  
  public static final String WTLP_EMAN_CRDT_GRAD_REQ  = "WTLP_EMAN_CRDT_GRAD_REQ";   
  public static final String WTLP_EMAN_CRDT_GRAD_ERND = "WTLP_EMAN_CRDT_GRAD_ERND";
  public static final String WTLP_GOAL_TYPE           = "WTLP_GOAL_TYPE";
  public static final String WTLP_DRTN_DT_FROM        = "WTLP_DRTN_DT_FROM";
  public static final String WTLP_DRNT_DT_TO          = "WTLP_DRNT_DT_TO";
  public static final String WTLP_STRENGTH            = "WTLP_STRENGTH";
  public static final String WTLP_NEEDS               = "WTLP_NEEDS";
  public static final String WTLP_GOAL                = "WTLP_GOAL";
  public static final String WTLP_STEPS_CHLD_FNAME    = "WTLP_STEPS_CHLD_FNAME";
  public static final String WTLP_CHK_EDU             = "WTLP_CHK_EDU";
  public static final String WTLP_CHK_VOC             = "WTLP_CHK_VOC";
  public static final String WTLP_CHK_DAY_LVNG        = "WTLP_CHK_DAY_LVNG";
  public static final String WTLP_CHK_HEALTH          = "WTLP_CHK_HEALTH";
  public static final String WTLP_CHK_PRSNL           = "WTLP_CHK_PRSNL";
  public static final String WTLP_GOAL_RSN            = "WTLP_GOAL_RSN";  
  public static final String WTLP_GOAL_TXT            = "WTLP_GOAL_TXT";   
  public static final String WTLP_STEP_SEQ            = "WTLP_STEP_SEQ";
  public static final String WTLP_STEP_ACTN           = "WTLP_STEP_ACTN";
  public static final String WTLP_STEP_PRSN           = "WTLP_STEP_PRSN";
  public static final String WTLP_STEP_PRIORITY       = "WTLP_STEP_PRIORITY";
  public static final String WTLP_STEP_CMPLTN_DT      = "WTLP_STEP_CMPLTN_DT";
  public static final String WTLP_STEP_STATUS         = "WTLP_STEP_STATUS";
  public static final String WTLP_STEP_COMM           = "WTLP_STEP_COMM";
  public static final String WTLP_STEP_CHILD_FULLNAME = "WTLP_STEP_CHILD_FULLNAME";
  
  // Placement History
  public static final String PLCMT_HIST_CHILD_FULLNAME = "PLCMT_HIST_CHILD_FULLNAME";   
  public static final String PLCMT_HIST_COUNTY         = "PLCMT_HIST_COUNTY";
  public static final String PLCMT_HIST_STATE          = "PLCMT_HIST_STATE";
  public static final String PLCMT_HIST_DT_ENTER       = "PLCMT_HIST_DT_ENTER";
  public static final String PLCMT_HIST_DT_EXIT        = "PLCMT_HIST_DT_EXIT";
  public static final String PLCMT_HIST_PLCMT_TYPE     = "PLCMT_HIST_PLCMT_TYPE";
  public static final String PLCMT_HIST_CHLD_REL_INT   = "PLCMT_HIST_CHLD_REL_INT";
  public static final String PLCMT_HIST_REMOVAL_RSN    = "PLCMT_HIST_REMOVAL_RSN";
  
  // Healthcare Provider
  public static final String HLTHCARE_PRVDR_CHILD_FULLNAME = "HLTHCARE_PRVDR_CHILD_FULLNAME";   
  public static final String HLTHCARE_PRVDR_PRVDR_NAME     = "HLTHCARE_PRVDR_PRVDR_NAME";
  public static final String HLTHCARE_PRVDR_PRVDR_TYPE     = "HLTHCARE_PRVDR_PRVDR_TYPE";
  public static final String HLTHCARE_PRVDR_PRVDR_ADDR     = "HLTHCARE_PRVDR_PRVDR_ADDR";
  public static final String HLTHCARE_PRVDR_PRVDR_CSZIP    = "HLTHCARE_PRVDR_PRVDR_CSZIP";
  public static final String HLTHCARE_PRVDR_PRVDR_CO       = "HLTHCARE_PRVDR_PRVDR_CO";
  public static final String HLTHCARE_PRVDR_PRVDR_PH       = "HLTHCARE_PRVDR_PRVDR_PH";
  public static final String HLTHCARE_PRVDR_PRVDR_FAX      = "HLTHCARE_PRVDR_PRVDR_FAX";
    
  // Healthcare Status
  public static final String HLTH_STAT_CHILD_FULLNAME    = "HLTH_STAT_CHILD_FULLNAME";   
  public static final String HLTH_STAT_IMUN_UPTODATE_Y   = "HLTH_STAT_IMUN_UPTODATE_Y";
  public static final String HLTH_STAT_IMUN_UPTODATE_N   = "HLTH_STAT_IMUN_UPTODATE_N";
  public static final String HLTH_STAT_IMUN_UPTDT_COMM   = "HLTH_STAT_IMUN_UPTDT_COMM";
  public static final String HLTH_STAT_IMUN_REC_Y        = "HLTH_STAT_IMUN_REC_Y";
  public static final String HLTH_STAT_IMUN_REC_N        = "HLTH_STAT_IMUN_REC_N";
  public static final String HLTH_STAT_IMUN_REC_COMM     = "HLTH_STAT_IMUN_REC_COMM";
  public static final String HLTH_STAT_IMUN_CERT_Y       = "HLTH_STAT_IMUN_CERT_Y";
  public static final String HLTH_STAT_IMUN_CERT_N       = "HLTH_STAT_IMUN_CERT_N";   
  public static final String HLTH_STAT_IMUN_CERT_COMM    = "HLTH_STAT_IMUN_CERT_COMM";
  public static final String HLTH_STAT_MDCL_PROB_Y       = "HLTH_STAT_MDCL_PROB_Y";
  public static final String HLTH_STAT_MDCL_PROB_N       = "HLTH_STAT_MDCL_PROB_N";
  public static final String HLTH_STAT_MDCL_PROB_EXPLN   = "HLTH_STAT_MDCL_PROB_EXPLN";
  public static final String HLTH_STAT_MDCL_TREAT_Y      = "HLTH_STAT_MDCL_TREAT_Y";
  public static final String HLTH_STAT_MDCL_TREAT_N      = "HLTH_STAT_MDCL_TREAT_N";
  public static final String HLTH_STAT_DOC_REC_Y         = "HLTH_STAT_DOC_REC_Y";
  public static final String HLTH_STAT_DOC_REC_N         = "HLTH_STAT_DOC_REC_N";
  public static final String HLTH_STAT_MED_REC_FILE_Y    = "HLTH_STAT_MED_REC_FILE_Y";
  public static final String HLTH_STAT_MED_REC_FILE_N    = "HLTH_STAT_MED_REC_FILE_N";
  public static final String HLTH_STAT_MED_REC_FILE_COMM = "HLTH_STAT_MED_REC_FILE_COMM";
  public static final String HLTH_STAT_PSY_REC_FILE_Y    = "HLTH_STAT_PSY_REC_FILE_Y";   
  public static final String HLTH_STAT_PSY_REC_FILE_N    = "HLTH_STAT_PSY_REC_FILE_N";
  public static final String HLTH_STAT_PSY_REC_FILE_COMM = "HLTH_STAT_PSY_REC_FILE_COMM";
  public static final String HLTH_STAT_CHLD_ON_MED_Y     = "HLTH_STAT_CHLD_ON_MED_Y";
  public static final String HLTH_STAT_CHLD_ON_MED_N     = "HLTH_STAT_CHLD_ON_MED_N";
  public static final String HLTH_STAT_CHLD_MED_NAMES    = "HLTH_STAT_CHLD_MED_NAMES";
  public static final String HLTH_STAT_PRSN_ADMN_MED     = "HLTH_STAT_PRSN_ADMN_MED";
  public static final String HLTH_STAT_DT_LAST_HLTH_CHK  = "HLTH_STAT_DT_LAST_HLTH_CHK";
  public static final String HLTH_STAT_DT_LAST_MED_EXAM  = "HLTH_STAT_DT_LAST_MED_EXAM";
  public static final String HLTH_STAT_DT_LAST_DNTL_SCRN = "HLTH_STAT_DT_LAST_DNTL_SCRN";
  public static final String HLTH_STAT_DT_LAST_DNTL_EXAM = "HLTH_STAT_DT_LAST_DNTL_EXAM";
  public static final String HLTH_STAT_DT_LAST_PSYC_EVAL = "HLTH_STAT_DT_LAST_PSYC_EVAL";
  public static final String HLTH_STAT_MISSING_DT_EXPLN  = "HLTH_STAT_MISSING_DT_EXPLN";
  public static final String HLTH_STAT_OTHER_MED_INFO    = "HLTH_STAT_OTHER_MED_INFO";
  
  // Visitation Plan Narrative
  public static final String VISIT_PLAN_EXIST    = "VISIT_PLAN_EXIST";  
  public static final String CHILD_NAME    = "CHILD_NAME"; 
  
  // Education
  public static final String EDUCTN_CHILD_FULLNAME          = "EDUCTN_CHILD_FULLNAME";   
  public static final String EDUCTN_CCFA_EDUC_ASSMT_DT      = "EDUCTN_CCFA_EDUC_ASSMT_DT";
  public static final String EDUCTN_CCFA_EDUC_ASSMT_EXPLN   = "EDUCTN_CCFA_EDUC_ASSMT_EXPLN";
  public static final String EDUCTN_DEV_SCRN_Y              = "EDUCTN_DEV_SCRN_Y";
  public static final String EDUCTN_DEV_SCRN_N              = "EDUCTN_DEV_SCRN_N";
  public static final String EDUCTN_DEV_SCRN_NA             = "EDUCTN_DEV_SCRN_NA";
  public static final String EDUCTN_DEV_SCRN_DT             = "EDUCTN_DEV_SCRN_DT";
  public static final String EDUCTN_DEV_ASSMT_Y             = "EDUCTN_DEV_ASSMT_Y";
  public static final String EDUCTN_DEV_ASSMT_N             = "EDUCTN_DEV_ASSMT_N";
  public static final String EDUCTN_DEV_ASSMT_NA            = "EDUCTN_DEV_ASSMT_NA";
  public static final String EDUCTN_DEV_ASSMT_DT            = "EDUCTN_DEV_ASSMT_DT";
  public static final String EDUCTN_CURR_EID_Y              = "EDUCTN_CURR_EID_Y";
  public static final String EDUCTN_CURR_EID_N              = "EDUCTN_CURR_EID_N";   
  public static final String EDUCTN_PREV_EID_Y              = "EDUCTN_PREV_EID_Y";
  public static final String EDUCTN_PREV_EID_N              = "EDUCTN_PREV_EID_N";
  public static final String EDUCTN_EID_YES_EXPLN           = "EDUCTN_EID_YES_EXPLN";
  public static final String EDUCTN_CHLD_IN_SCHOOL_Y        = "EDUCTN_CHLD_IN_SCHOOL_Y";
  public static final String EDUCTN_CHLD_IN_SCHOOL_N        = "EDUCTN_CHLD_IN_SCHOOL_N";
  public static final String EDUCTN_SCHL_GRADE_LVL          = "EDUCTN_SCHL_GRADE_LVL";
  public static final String EDUCTN_SCHL_DISCTRICT          = "EDUCTN_SCHL_DISCTRICT";
  public static final String EDUCTN_SCHL_NAME               = "EDUCTN_SCHL_NAME";
  public static final String EDUCTN_SCHL_ST_ADDRESS         = "EDUCTN_SCHL_ST_ADDRESS";   
  public static final String EDUCTN_SCHL_ADDR_CSZIP         = "EDUCTN_SCHL_ADDR_CSZIP";
  public static final String EDUCTN_SCHL_PHONE              = "EDUCTN_SCHL_PHONE";
  public static final String EDUCTN_SCHL_FAX                = "EDUCTN_SCHL_FAX";
  public static final String EDUCTN_GUIDANCE_CNSLR          = "EDUCTN_GUIDANCE_CNSLR";
  public static final String EDUCTN_CLASSRM_PLCMT           = "EDUCTN_CLASSRM_PLCMT";
  public static final String EDUCTN_ATTENDANCE_REG          = "EDUCTN_ATTENDANCE_REG";
  public static final String EDUCTN_ATTENDANCE_TRUANT       = "EDUCTN_ATTENDANCE_TRUANT";
  public static final String EDUCTN_ATTENDANCE_NA           = "EDUCTN_ATTENDANCE_NA";
  public static final String EDUCTN_PRFMNCE_GRADE_LVL_Y     = "EDUCTN_PRFMNCE_GRADE_LVL_Y";
  public static final String EDUCTN_PRFMNCE_GRADE_LVL_N     = "EDUCTN_PRFMNCE_GRADE_LVL_N";
  public static final String EDUCTN_PRFMNCE_GRADE_LVL_NA    = "EDUCTN_PRFMNCE_GRADE_LVL_NA";
  public static final String EDUCTN_SPCL_EDU_NEEDS_Y        = "EDUCTN_SPCL_EDU_NEEDS_Y";
  public static final String EDUCTN_SPCL_EDU_NEEDS_N        = "EDUCTN_SPCL_EDU_NEEDS_N";
  public static final String EDUCTN_SPCL_EDU_NEEDS_NA       = "EDUCTN_SPCL_EDU_NEEDS_NA";
  public static final String EDUCTN_SPCL_EDU_NEEDS_EXPLN    = "EDUCTN_SPCL_EDU_NEEDS_EXPLN";  
  public static final String EDUCTN_PREV_SPCL_EDU_SRVC_Y    = "EDUCTN_PREV_SPCL_EDU_SRVC_Y";
  public static final String EDUCTN_PREV_SPCL_EDU_SRVC_N    = "EDUCTN_PREV_SPCL_EDU_SRVC_N";
  public static final String EDUCTN_PREV_SPCL_EDU_SRVC_NA   = "EDUCTN_PREV_SPCL_EDU_SRVC_NA";
  public static final String EDUCTN_STDNT_SUPRT_REF_DT      = "EDUCTN_STDNT_SUPRT_REF_DT";
  public static final String EDUCTN_SST_IEP_RCMDTN_COMM         = "EDUCTN_SST_IEP_RCMDTN_COMM";
  public static final String EDUCTN_IEP_DT                  = "EDUCTN_IEP_DT";
  public static final String EDUCTN_BHVR_DISCPLN_REC        = "EDUCTN_BHVR_DISCPLN_REC";
  public static final String EDUCTN_LGL_PRNT_INVOLVE_Y      = "EDUCTN_LGL_PRNT_INVOLVE_Y";
  public static final String EDUCTN_LGL_PRNT_INVOLVE_N      = "EDUCTN_LGL_PRNT_INVOLVE_N";
  public static final String EDUCTN_SURROGATE_PRNT_NM       = "EDUCTN_SURROGATE_PRNT_NM";
  public static final String EDUCTN_SURROGATE_PRNT_TYP      = "EDUCTN_SURROGATE_PRNT_TYP";
  public static final String EDUCTN_SCHL_CHG_DUE_PLCMT_Y    = "EDUCTN_SCHL_CHG_DUE_PLCMT_Y";
  public static final String EDUCTN_SCHL_CHG_DUE_PLCMT_N    = "EDUCTN_SCHL_CHG_DUE_PLCMT_N";
  public static final String EDUCTN_SCHL_CHG_DUE_PLCMT_NA   = "EDUCTN_SCHL_CHG_DUE_PLCMT_NA";
  public static final String EDUCTN_SCH_REC_CHLD_FILE_Y     = "EDUCTN_SCH_REC_CHLD_FILE_Y";
  public static final String EDUCTN_SCH_REC_CHLD_FILE_N     = "EDUCTN_SCH_REC_CHLD_FILE_N";
  public static final String EDUCTN_SCH_REC_CHLD_FILE_NA    = "EDUCTN_SCH_REC_CHLD_FILE_NA";
  public static final String EDUCTN_SCH_REC_CHLD_FILE_EXPLN = "EDUCTN_SCH_REC_CHLD_FILE_EXPLN";
  public static final String EDUCTN_EDU_REC_BOARD_CO_Y      = "EDUCTN_EDU_REC_BOARD_CO_Y";
  public static final String EDUCTN_EDU_REC_BOARD_CO_N      = "EDUCTN_EDU_REC_BOARD_CO_N";
  public static final String EDUCTN_EDU_REC_BOARD_CO_NOUT   = "EDUCTN_EDU_REC_BOARD_CO_NOUT";
  public static final String EDUCTN_SUPLMNT_SPRVSN_Y        = "EDUCTN_SUPLMNT_SPRVSN_Y";
  public static final String EDUCTN_SUPLMNT_SPRVSN_N        = "EDUCTN_SUPLMNT_SPRVSN_N";
  public static final String EDUCTN_SUPLMNT_SPRVSN_EXPLN    = "EDUCTN_SUPLMNT_SPRVSN_EXPLN";
  public static final String EDUCTN_FINAL_COMMENT           = "EDUCTN_FINAL_COMMENT";
  public static final String EDUCTN_VISIT_PLAN_BLOB         = "EDUCTN_VISIT_PLAN_BLOB";
  public static final String DEV_SCRN_ASSMT_CMNT            = "DEV_SCRN_ASSMT_CMNT";
  public static final String EDUCTN_DEV_SCRN_EXPLN          = "EDUCTN_DEV_SCRN_EXPLN";
  public static final String EDUCTN_REC_IN_FILE_EXPLN       = "EDUCTN_REC_IN_FILE_EXPLN";
  public static final String EDUCTN_SCHL_CHG_DUE_PLCMT_EXPLN  = "EDUCTN_SCHL_CHG_DUE_PLCMT_EXPLN";
  
  // Participation and Disclosure;
  public static final String HEARING_REQUEST_COMM        = "HEARING_REQUEST_COMM";
  public static final String PARTCPTN_CHILD_FULLNAME     = "PARTCPTN_CHILD_FULLNAME";   
  public static final String PARTCPTN_PARTICIPANT_NAME   = "PARTCPTN_PARTICIPANT_NAME";
  public static final String PARTCPTN_PARTICIPANT_RELTN  = "PARTCPTN_PARTICIPANT_RELTN";
  public static final String PARTCPTN_DFCS_REF_SUP_ENF_Y = "PARTCPTN_DFCS_REF_SUP_ENF_Y";
  public static final String PARTCPTN_DFCS_REF_SUP_ENF_N = "PARTCPTN_DFCS_REF_SUP_ENF_N";
  public static final String PARTCPTN_DFCS_SUP_ENF_EXPLN = "PARTCPTN_DFCS_SUP_ENF_EXPLN";
  public static final String PARTCPTN_PRNT_REFUSE_SIGN_Y = "PARTCPTN_PRNT_REFUSE_SIGN_Y";
  public static final String PARTCPTN_PRNT_REFUSE_SIGN_N = "PARTCPTN_PRNT_REFUSE_SIGN_N";
  public static final String PARTCPTN_NOT_AGREE_COMM     = "PARTCPTN_NOT_AGREE_COMM";
  public static final String PARTCPTN_HEAR_REQ_SUBMIT_Y  = "PARTCPTN_HEAR_REQ_SUBMIT_Y";
  public static final String PARTCPTN_HEAR_REQ_SUBMIT_N  = "PARTCPTN_HEAR_REQ_SUBMIT_N";
  public static final String PARTCPTN_HEAR_REQ_DT        = "PARTCPTN_HEAR_REQ_DT";
  public static final String PARTCPTN_ADDITIONAL_COMM    = "PARTCPTN_ADDITIONAL_COMM";
  
  //Adoption Information
  public static final String FCCP_CHLD_ADO_INFO_CHLD_FULLNAME = "FCCP_CHLD_ADO_INFO_CHLD_FULLNAME";
  public static final String DT_FP_NT_TPR                     = "DT_FP_NT_TPR";
  public static final String DT_PERM_STAFF 					  = "DT_PERM_STAFF";
  public static final String DT_FPR_NTF_AG 					  = "DT_FPR_NTF_AG";
  public static final String IND_FPR_NTF_OUTCOME              = "IND_FPR_NTF_OUTCOME";
  public static final String DT_SL_SENT                       = "DT_SL_SENT";
  public static final String DT_CLH_PRS   					  = "DT_CLH_PRS";
  public static final String DT_STAFFING_AF                   = "DT_STAFFING_AF";
  public static final String DT_ADO_PLCMT_SD 				  = "DT_ADO_PLCMT_SD";
  public static final String DT_PM_TO_FILE					  = "DT_PM_TO_FILE";
  public static final String DT_DOC_SENT					  = "DT_DOC_SENT";
  public static final String DT_DR_DT						  = "DT_DR_DT";
  


  public FCCPFAMILYDETAILFORMSO retrieveFccpFamilyDetailForm(FCCPFAMILYDETAILFORMSI fccpFamilyDtlFormsi);

}
