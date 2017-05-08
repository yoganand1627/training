 package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.FOSTERCAREAPPSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FOSTERCAREAPPSO;

public interface FosterCareApp extends DocumentService {

  // Blob data table names
  public static final String NARRATIVE = "NARRATIVE";

  public static final String FCE_NARRATIVE = "FCE_NARRATIVE";

  // Group Names

  public static final String CONTACT_VISITATION_NARRATIVE = "CONTACT_VISITATION_NARRATIVE";

  public static final String CONTACT_NARRATIVE = "CONTACT_NARRATIVE";

  public static final String VISIT_PLAN_NARR = "VISIT_PLAN_NARR";

  public static final String INCOMING_NARRATIVE = "INCOMING_NARRATIVE";

  public static final String HOME_STUD_NARR = "HOME_STUD_NARR";

  public static final String PLCMT_DISCHG_NARR = "PLCMT_DISCHG_NARR";

  // Group Names
  public static final String FEL01O00 = "FEL01O00";

  public static final String FCE_THIRDPARTY_EMPLOYERNM = "FCE_THIRDPARTY_EMPLOYERNM";

  public static final String NM_NAME_MIDDLE = "NM_NAME_MIDDLE";

  public static final String NM_NAME_LAST6 = "NM_NAME_LAST6";

  public static final String NM_NAME_FIRST6 = "NM_NAME_FIRST6";

  public static final String NM_NAME_MIDDLE6 = "NM_NAME_MIDDLE6";

  public static final String NM_NAME_LAST5 = "NM_NAME_LAST5";

  public static final String NM_NAME_FIRST5 = "NM_NAME_FIRST5";

  public static final String NM_NAME_MIDDLE5 = "NM_NAME_MIDDLE5";

  public static final String NM_NAME_LAST4 = "NM_NAME_LAST4";

  public static final String NM_NAME_FIRST4 = "NM_NAME_FIRST4";

  public static final String NM_NAME_MIDDLE4 = "NM_NAME_MIDDLE4";

  public static final String NM_NAME_LAST3 = "NM_NAME_LAST3";

  public static final String NM_NAME_FIRST3 = "NM_NAME_FIRST3";

  public static final String NM_NAME_MIDDLE3 = "NM_NAME_MIDDLE3";

  public static final String NM_NAME_LAST2 = "NM_NAME_LAST2";

  public static final String NM_NAME_FIRST2 = "NM_NAME_FIRST2";

  public static final String NM_NAME_MIDDLE2 = "NM_NAME_MIDDLE2";

  public static final String TXT_SAFETY_FACTOR = "TXT_SAFETY_FACTOR";

  public static final String TXT_DESC_OF_ACTIONS = "TXT_DESC_OF_ACTIONS";

  public static final String SIGN_DISCUSSION_DATE = "SIGN_DISCUSSION_DATE";

  public static final String SIGN_CARETAKER_AGREE = "SIGN_CARETAKER_AGREE";

  public static final String NM_OTHER_FIRST = "NM_OTHER_FIRST";
  
  public static final String ASSISTANCE_UNIT_NUM = "ASSISTANCE_UNIT_NUM";
  
  public static final String MONTHLY_GROSS_INCOME = "MONTHLY_GROSS_INCOME";
  
  public static final String PARENTS_NUM = "PARENTS_NUM";
  
  public static final String STANDARD_DEDUCTIONS = "STANDARD_DEDUCTIONS";
  
  public static final String INCOME_LIMIT = "INCOME_LIMIT";
  
  public static final String COUNTABLE_UNEARNED_INCOME = "COUNTABLE_UNEARNED_INCOME";
  
  public static final String MONTHLY_INCOME_LIMIT = "MONTHLY_INCOME_LIMIT";
  
  public static final String MONTHLY_COUNTABLE_UNEARNED_INCOME = "MONTHLY_COUNTABLE_UNEARNED_INCOME";
  
  public static final String MONTHLY_UNEARNED_INCOME = "MONTHLY_UNEARNED_INCOME";
  
  public static final String ALIMONY_CHILD_SUPPORT = "ALIMONY_CHILD_SUPPORT";

  public static final String STEPPARENT_INCOME = "STEPPARENT_INCOME";
  
  public static final String DEPENDENTS_ALLOWANCE = "DEPENDENTS_ALLOWANCE";
  
  public static final String TOTAL_COUNTABLE_INCOME = "TOTAL_COUNTABLE_INCOME";
  
  public static final String APPLIED_STEPPARENT_INCOME = "APPLIED_STEPPARENT_INCOME";
  
  public static final String APPLIED_STEPPARENT_INCOME2 = "APPLIED_STEPPARENT_INCOME2";
  
  public static final String STANDARD_OF_NEED_TEST = "STANDARD_OF_NEED_TEST";
  
  public static final String TOT_COUNT_INCOME = "TOT_COUNT_INCOME";
  
  public static final String RESOURCES_FOR_CHILD = "RESOURCES_FOR_CHILD";
  
  public static final String UNEARNED_INCOME_CHILD = "UNEARNED_INCOME_CHILD";
  
  public static final String STANDARD_OF_NEED_TEST_COUNTABLE = "STANDARD_OF_NEED_TEST_COUNTABLE";
  
  public static final String APPLIED_STEPPARENT_INCOME_STEPPARENT = "APPLIED_STEPPARENT_INCOME_STEPPARENT";
  
  public static final String IVE_INCOME_LIMIT_NEED_CHILD = "IVE_INCOME_LIMIT_NEED_CHILD";
  
  public static final String STANDARD_OF_NEED_TEST_CHILD = "STANDARD_OF_NEED_TEST_CHILD";
  
  public static final String DEDUCTION_FOR_CHILD = "DEDUCTION_FOR_CHILD";
  
  public static final String IVE_INCOME_LIMIT= "IVE_INCOME_LIMIT";
  
  public static final String IVE_INCOME_LIMIT_NEED = "IVE_INCOME_LIMIT_NEED";
  
  public static final String NM_OTHER_MIDDLE = "NM_OTHER_MIDDLE";

  public static final String NM_OTHER_LAST = "NM_OTHER_LAST";

  public static final String DT_COMPLETED = "DT_COMPLETED";

  public static final String DT_DISCUSSED = "DT_DISCUSSED";

  public static final String ND_CRTKR_AGREES = "ND_CRTKR_AGREES";
  
  public static final String FEL01O01 = "FEL01O01";

  public static final String FEL01O03 = "FEL01O03";

  public static final String FEL01O04 = "FEL01O04";

  public static final String FEL01O05 = "FEL01O05";

  public static final String FEL01O06 = "FEL01O06";

  public static final String FEL01O07 = "FEL01O07";

  // Form Group Bookmark Names
  public static final String TMPLAT_INITIAL_APPLICATION = "TMPLAT_INITIAL_APPLICATION";

  public static final String TMPLAT_AMENDED_APPLICATION = "TMPLAT_AMENDED_APPLICATION";

  public static final String TMPLAT_NOTIFICATION_OF_CHANGE = "TMPLAT_NOTIFICATION_OF_CHANGE";

  public static final String TMPLAT_HOSPITAL_INFORMATION = "TMPLAT_HOSPITAL_INFORMATION";

  public static final String TMPLAT_HOME_REMOVAL = "TMPLAT_HOME_REMOVAL";

  public static final String TMPLAT_PLACEMENT = "TMPLAT_PLACEMENT";

  public static final String TMPLAT_METHOD_VERIFY_AGE = "TMPLAT_METHOD_VERIFY_AGE";

  public static final String TMPLAT_METHOD_VERIFY_CITIZENSHIP = "TMPLAT_METHOD_VERIFY_CITIZENSHIP";

  public static final String TMPLAT_REASON_FOR_ABSENCE = "TMPLAT_REASON_FOR_ABSENCE";

  public static final String TMPLAT_BOTH_PARENTS = "TMPLAT_BOTH_PARENTS";

  public static final String TMPLAT_PARENTS_DISABLED_YES = "TMPLAT_PARENTS_DISABLED_YES";

  public static final String TMPLAT_VERIFICATION = "TMPLAT_VERIFICATION";
  
  public static final String TMPLAT_VERIF_DOCUMENTATION = "TMPLAT_VERIF_DOCUMENTATION";

  public static final String TMPLAT_DOC_TYPE_VA = "TMPLAT_DOC_TYPE_VA";

  public static final String TMPLAT_DOC_TYPE_RR_RSDI = "TMPLAT_DOC_TYPE_RR_RSDI";

  public static final String TMPLAT_PARENTS_DISABLED_NO = "TMPLAT_PARENTS_DISABLED_NO";

  public static final String TMPLAT_LONG_UNEMPLOYMENT = "TMPLAT_LONG_UNEMPLOYMENT";

  public static final String TMPLAT_ENG_EDU_TRN = "TMPLAT_ENG_EDU_TRN";

  public static final String TMPLAT_PE_NOT_ACPT_EMP_TRN = "TMPLAT_PE_NOT_ACPT_EMP_TRN";

  public static final String TMPLAT_PE_WORK_LESS_100_HOURS = "TMPLAT_PE_WORK_LESS_100_HOURS";
  
  public static final String TMPLAT_MONTHS_IN_DEP = "TMPLAT_MONTHS_IN_DEP";

  public static final String TMPLAT_ONE_LEGAL = "TMPLAT_ONE_LEGAL";

  public static final String TMPLAT_GROSS_INCOME = "TMPLAT_GROSS_INCOME";

  public static final String TMPLAT_MANAGER_NOTIFICATION = "TMPLAT_MANAGER_NOTIFICATION";

  public static final String TMPLAT_IA_WORKER_INFO = "TMPLAT_IA_WORKER_INFO";

  public static final String TMPLAT_CHILD_INCOME = "TMPLAT_CHILD_INCOME";

  public static final String TMPLAT_FAMILY_INCOME2 = "TMPLAT_FAMILY_INCOME2";

  public static final String TMPLAT_CHILD_RESOURCES = "TMPLAT_CHILD_RESOURCES";

  public static final String TMPLAT_FAMILY_RESOURCES = "TMPLAT_FAMILY_RESOURCES";
  
  public static final String TMPLAT_CHILD_COST_OF_CARE = "TMPLAT_CHILD_COST_OF_CARE";
  
  public static final String TMPLAT_COST_OF_CARE_EXCEEDS = "TMPLAT_COST_OF_CARE_EXCEEDS";

  public static final String TMPLAT_EXPENDITURES_INFO = "TMPLAT_EXPENDITURES_INFO";

  public static final String TMPLAT_EXPENDITURES_NONE = "TMPLAT_EXPENDITURES_NONE";

  public static final String TMPLAT_AFDC_ALLOCATION = "TMPLAT_AFDC_ALLOCATION";
  
  public static final String TMPLAT_ALLOCATION = "TMPLAT_ALLOCATION";
  
  public static final String TMPLAT_ALLOCATION_NONE = "TMPLAT_ALLOCATION_NONE";
  
  public static final String TMPLAT_SINGLE_ALLOCATION = "TMPLAT_SINGLE_ALLOCATION";
  
  public static final String TMPLAT_MULTIPLE_ALLOCATION = "TMPLAT_MULTIPLE_ALLOCATION";
  
  public static final String TMPLAT_MUTUAL_ALLOCATION = "TMPLAT_MUTUAL_ALLOCATION";
  
  public static final String TMPLAT_AFDC_DEEMING = "TMPLAT_AFDC_DEEMING";
  
  public static final String TMPLAT_DEEMING = "TMPLAT_DEEMING";
  
  public static final String TMPLAT_DEEMING_NONE = "TMPLAT_DEEMING_NONE";
  
  public static final String TMPLAT_DEEMING_INDIV_1 = "TMPLAT_DEEMING_INDIV_1";

  public static final String TMPLAT_DEEMING_INDIV_2 = "TMPLAT_DEEMING_INDIV_2";

  public static final String TMPLAT_AFDC_BUDGET_WORKSHEET = "TMPLAT_AFDC_BUDGET_WORKSHEET";
  
  public static final String TMPLAT_AU_MBR_SON_TEST = "TMPLAT_AU_MBR_SON_TEST";
  
  public static final String TMPLAT_AU_MBR_30_THIRD_DEDUC = "TMPLAT_AU_MBR_30_THIRD_DEDUC";
  
  public static final String TMPLAT_APROXIMATE = "TMPLAT_APROXIMATE";

  public static final String TMPLAT_NONE_OF_ABOVE = "TMPLAT_NONE_OF_ABOVE";

  public static final String TMPLAT_CONTACT_INFORMATION = "TMPLAT_CONTACT_INFORMATION";

  public static final String TMPLAT_COVERED_PRINCIPALS = "TMPLAT_COVERED_PRINCIPALS";

  public static final String TMPLAT_RELEASE_PERMISSION = "TMPLAT_RELEASE_PERMISSION";

  public static final String TMPLAT_PAYMENT_PERMISSION = "TMPLAT_PAYMENT_PERMISSION";

  public static final String TMPLAT_CHANGE = "TMPLAT_CHANGE";

  public static final String TMPLAT_CANCELLATION = "TMPLAT_CANCELLATION";

  public static final String TMPLAT_DT_HEALTH_CHANGE = "TMPLAT_DT_HEALTH_CHANGE";
  
  public static final String TMPLAT_DEP_SYSTEM = "TMPLAT_DEP_SYSTEM";
  
  public static final String TMPLAT_DEP_ES_CONFIRMATION = "TMPLAT_DEP_ES_CONFIRMATION";
  
  public static final String TMPLAT_OTHER_RELATIVE = "TMPLAT_OTHER_RELATIVE";
  
  public static final String TMPLAT_VRFY_METHODS_US_CITIZEN = "TMPLAT_VRFY_METHODS_US_CITIZEN";
  
  public static final String TMPLAT_VRFY_METHODS_IDENTITY_ADULT = "TMPLAT_VRFY_METHODS_IDENTITY_ADULT";
  
  public static final String TMPLAT_VRFY_METHODS_IDENTITY_UNDER16 = "TMPLAT_VRFY_METHODS_IDENTITY_UNDER16";
  
  public static final String TMPLAT_VRFY_METHODS_PERM_RES = "TMPLAT_VRFY_METHODS_PERM_RES";
  
  public static final String TMPLAT_VRFY_METHODS_OTHER_ALIEN = "TMPLAT_VRFY_METHODS_OTHER_ALIEN";
  
  public static final String TMPLAT_VRFY_METHODS_UNDETERMINED = "TMPLAT_VRFY_METHODS_UNDETERMINED";
  
  public static final String TMPLAT_VRFY_METHODS_SPECIAL = "TMPLAT_VRFY_METHODS_SPECIAL";
  
  public static final String TMPLAT_CONDITIONAL_MTHD_VERIFY = "TMPLAT_CONDITIONAL_MTHD_VERIFY";
  
  public static final String TMPLAT_REQUIREMENTS = "TMPLAT_REQUIREMENTS";
  
  public static final String TMPLAT_BEST_INTEREST_YES = "TMPLAT_BEST_INTEREST_YES";

  public static final String TMPLAT_BEST_INTEREST_NO = "TMPLAT_BEST_INTEREST_NO";

  public static final String TMPLAT_PARENTAL_REMOVAL_YES = "TMPLAT_PARENTAL_REMOVAL_YES";

  public static final String TMPLAT_PARENTAL_REMOVAL_NO = "TMPLAT_PARENTAL_REMOVAL_NO";

  public static final String TMPLAT_DFCS_RESPONSIBLE_YES = "TMPLAT_DFCS_RESPONSIBLE_YES";

  public static final String TMPLAT_DFCS_RESPONSIBLE_NO = "TMPLAT_DFCS_RESPONSIBLE_NO";
  
  public static final String TMPLAT_AFDC_CHECK = "TMPLAT_AFDC_CHECK";

  public static final String TMPLAT_REASONS_NOT_ELIGIBLE  = "TMPLAT_REASONS_NOT_ELIGIBLE";

  public static final String TMPLAT_REASONS  = "TMPLAT_REASONS";
  
  public static final String TMPLAT_IVE_CHECKLIST = "TMPLAT_IVE_CHECKLIST";

  public static final String TMPLAT_AFDC_CHECKLIST = "TMPLAT_AFDC_CHECKLIST";
  
  // Bookmark name
  public static final String FCE_ELG_DEP = "FCE_ELG_DEP";

  public static final String FCE_PERS_DOB = "FCE_PERS_DOB";

  public static final String CHILD_SSN = "CHILD_SSN";

  public static final String CHILD_MEDICAID = "CHILD_MEDICAID";

  public static final String CHILD_MHN_NUMBER = "CHILD_MHN_NUMBER";

  public static final String CHILD_APP_MONTH = "CHILD_APP_MONTH";

  public static final String CHILD_PERSON_ID = "CHILD_PERSON_ID";

  public static final String REMOVAL_STREET = "REMOVAL_STREET";
  
  public static final String REMOVAL_STREET_2 = "REMOVAL_STREET_2";
  
  public static final String REMOVAL_CITY = "REMOVAL_CITY";

  public static final String REMOVAL_STATE = "REMOVAL_STATE";

  public static final String REMOVAL_ZIP = "REMOVAL_ZIP";

  public static final String REMOVAL_COUNTY = "REMOVAL_COUNTY";

  public static final String REMOVAL_NAME = "REMOVAL_NAME";

  public static final String REMOVAL_LC = "REMOVAL_LC";

  public static final String REMOVAL_RELATIONSHIP = "REMOVAL_RELATIONSHIP";

  public static final String REMOVAL_DATE_OF_BIRTH = "REMOVAL_DATE_OF_BIRTH";

  public static final String REMOVAL_CURRENT_ADDRESS_LN_1 = "REMOVAL_CURRENT_ADDRESS_LN_1";

  public static final String REMOVAL_CURRENT_ADDRESS_LN_2 = "REMOVAL_CURRENT_ADDRESS_LN_2";
  
  public static final String CUSTODY_MINOR_DFCS = "CUSTODY_MINOR_DFCS";

  public static final String CUSTODY_HOSPITAL_DFCS = "CUSTODY_HOSPITAL_DFCS";

  public static final String CUSTODY_ADMIN_DATE = "CUSTODY_ADMIN_DATE";

  public static final String CUSTODY_DISC_DATE = "CUSTODY_DISC_DATE";

  public static final String CUSTODY_MEDICAL_NEEDED = "CUSTODY_MEDICAL_NEEDED";

  public static final String CUSTODY_MONTHS = "CUSTODY_MONTHS";

  public static final String REMOVAL_MEMB_ASSIST_UNIT = "REMOVAL_MEMB_ASSIST_UNIT";

  public static final String PLACEMENT_DATE_ENTERED = "PLACEMENT_DATE_ENTERED";

  public static final String PLACEMENT_STATUS = "PLACEMENT_STATUS";

  public static final String PLACEMENT_DESCRIPTION = "PLACEMENT_DESCRIPTION";

  public static final String PLACEMENT_ENTERED_BY = "PLACEMENT_ENTERED_BY";

  public static final String AGECITIZEN_AGE = "AGECITIZEN_AGE";

  public static final String AGECITIZEN_DOB = "AGECITIZEN_DOB";

  public static final String AGE_APPORXIMATE = "AGE_APPORXIMATE";

  public static final String CITIZENSHIP_AGE_VERIFY = "CITIZENSHIP_AGE_VERIFY";

  public static final String CITIZENSHIP_VERIFICATION = "CITIZENSHIP_VERIFICATION";

  public static final String VERIFY_CITIZEN_STATUS = "VERIFY_CITIZEN_STATUS";

  public static final String MEETS_NOT_MEETS = "MEETS_NOT_MEETS";

  public static final String SPECIAL_MEETS_NOT_MEETS = "SPECIAL_MEETS_NOT_MEETS";

  public static final String Elgibility_Comments = "Elgibility_Comments";

  public static final String DISABLED = "DISABLED";

  public static final String MONTHS_DISABLED = "MONTHS_DISABLED";

  public static final String VERIFY_DISABLED = "VERIFY_DISABLED";
  
  public static final String VERIF_METHOD = "VERIF_METHOD";

  public static final String VERIF_DOC_TYPE = "VERIF_DOC_TYPE";
  
  public static final String IS_RECV_100_PCT_VA = "IS_RECV_100_PCT_VA";
  
  public static final String IS_RECV_RR_RSDI = "IS_RECV_RR_RSDI";

  public static final String PRIMARY_WAGE_EARNER = "PRIMARY_WAGE_EARNER";

  public static final String LONG_UNEMPLOYMENT = "LONG_UNEMPLOYMENT";

  public static final String IS_RECV_UNEMP_COMP = "IS_RECV_UNEMP_COMP";
  
  public static final String IS_ENG_EDU_TRN = "IS_ENG_EDU_TRN";
  
  public static final String IS_PE_NOT_ACPT_EMP_TRN = "IS_PE_NOT_ACPT_EMP_TRN";
  
  public static final String UNDEREMPLOYMENT = "UNDEREMPLOYMENT";

  public static final String GROSS_INCOME = "GROSS_INCOME";

  public static final String PARENT_SELECTION = "PARENT_SELECTION";

  public static final String ABSENCE_EXECEPTION = "ABSENCE_EXECEPTION";

  public static final String ABSENCE_REASON = "ABSENCE_REASON";

  public static final String LEGAL_CUSTODY = "LEGAL_CUSTODY";

  public static final String REMOVAL_DATE = "REMOVAL_DATE";

  public static final String INCOME_ASSISATNCE = "INCOME_ASSISATNCE";

  public static final String CASE_MANAGER_NOTIFIED = "CASE_MANAGER_NOTIFIED";

  public static final String PERSON_FIRST = "PERSON_FIRST";

  public static final String PERSON_LAST = "PERSON_LAST";

  public static final String PERSON_MIDDLE = "PERSON, MIDDLE";

  public static final String PERSON_NBR = "PERSON_NBR";

  public static final String PERSON_DT_NOTIFIED = "PERSON_DT_NOTIFIED";

  public static final String INCOME_CHILD_NAME = "INCOME_CHILD_NAME";
  
  public static final String INCOME_CHILD_TYPE = "INCOME_CHILD_TYPE";

  public static final String INCOME_CHILD_EARNED = "INCOME_CHILD_EARNED";

  public static final String INCOME_CHILD_AMOUNT = "INCOME_CHILD_AMOUNT";

  public static final String INCOME_CHILD_NO_INCOME = "INCOME_CHILD_NO_INCOME";

  public static final String INCOME_CHILD_SOURCE = "INCOME_CHILD_SOURCE";

  public static final String INCOME_CHILD_COUNTABLE = "INCOME_CHILD_COUNTABLE";

  public static final String INCOME_FAMILY_NAME = "INCOME_FAMILY_NAME";

  public static final String INCOME_FAMILY_RELATIONSHIP = "INCOME_FAMILY_RELATIONSHIP";

  public static final String INCOME_FAMILY_TYPE = "INCOME_FAMILY_TYPE";

  public static final String INCOME_FAMILY_AMOUNT = "INCOME_FAMILY_AMOUNT";

  public static final String INCOME_FAMILY_SOURCE = "INCOME_FAMILY_SOURCE";

  public static final String INCOME_FAMILY_NO_INCOME = "INCOME_FAMILY_NO_INCOME";

  public static final String INCOME_FAMILY_EARNED = "INCOME_FAMILY_EARNED";

  public static final String INCOME_FAMILY_AGE = "INCOME_FAMILY_AGE";

  public static final String INCOME_FAMILY_COUNTABLE = "INCOME_FAMILY_COUNTABLE";

  public static final String CRESOURCE_NAME = "CRESOURCE_NAME";

  public static final String CRESOURCE_AMOUNT = "CRESOURCE_AMOUNT";

  public static final String CRESOURCE_SOURCE = "CRESOURCE_SOURCE";

  public static final String CRESOURCE_VERIFICATION = "CRESOURCE_VERIFICATION";

  public static final String CRESOURCE_INACCESSIBLE = "CRESOURCE_INACCESSIBLE";

  public static final String CRESOURCE_COUNTABLE = "CRESOURCE_COUNTABLE";

  public static final String FRESOURCE_FAM_NAME = "FRESOURCE_FAM_NAME";

  public static final String FRESOURCE_FAM_AMOUNT = "FRESOURCE_FAM_AMOUNT";

  public static final String FRESOURCE_FAM_TYPE = "FRESOURCE_FAM_TYPE";

  public static final String FRESOURCE_FAM_SOURCE = "CRESOURCE_FAM_SOURCE";

  public static final String FRESOURCE_FAM_VERIFICATION = "FRESOURCE_FAM_VERIFICATION";

  public static final String FRESOURCE_FAM_INACCESSIBLE = "FRESOURCE_FAM_INACCESSIBLE";

  public static final String FRESOURCE_FAM_COUNTABLE = "FRESOURCE_FAM_INACCESSIBLE";

  public static final String EQUITY_ANSWER = "EQUITY_ANSWER";

  public static final String FRESOURCE_COUNTABLE = "FRESOURCE_COUNTABLE";

  public static final String ALLOCATION_TYPE = "ALLOCATION_TYPE";
  
  public static final String SNG_ALLOC_PERSON = "SNG_ALLOC_PERSON";
  
  public static final String SNG_ALLOC_NBR_INELIG_SPOUSE = "SNG_ALLOC_NBR_INELIG_SPOUSE";
  
  public static final String SNG_ALLOC_NBR_INELIG_CHILDREN = "SNG_ALLOC_NBR_INELIG_CHILDREN";
  
  public static final String MULTIPLE_ALLOC_PERSON = "MULTIPLE_ALLOC_PERSON";
  
  public static final String MULTIPLE_ALLOC_NBR_INELIG_SPOUSE = "MULTIPLE_ALLOC_NBR_INELIG_SPOUSE";
  
  public static final String MULTIPLE_ALLOC_NBR_INELIG_CHILDREN = "MULTIPLE_ALLOC_NBR_INELIG_CHILDREN";
  
  public static final String MUTUAL_ALLOC_PERSON_1 = "MUTUAL_ALLOC_PERSON_1";
  
  public static final String MUTUAL_ALLOC_PERSON_2 = "MUTUAL_ALLOC_PERSON_2";
  
  public static final String MUTUAL_ALLOC_NBR_INELIG_SPOUSE = "MUTUAL_ALLOC_NBR_INELIG_SPOUSE";
  
  public static final String MUTUAL_ALLOC_NBR_INELIG_CHILDREN = "MUTUAL_ALLOC_NBR_INELIG_CHILDREN";
  
  public static final String DEEMING_TYPE = "DEEMING_TYPE";
  
  public static final String DEEMING_INDIV_1_NAME = "DEEMING_INDIV_1_NAME";
  
  public static final String DEEMING_INDIV_1_REL = "DEEMING_INDIV_1_REL";
  
  public static final String DEEMING_INDIV_2_NAME = "DEEMING_INDIV_2_NAME";
  
  public static final String DEEMING_INDIV_2_REL = "DEEMING_INDIV_2_REL";
  
  public static final String DEEMING_INDIV_CHLDRN_NOT_IN_AU = "DEEMING_INDIV_CHLDRN_NOT_IN_AU";

  public static final String DEEMING_INDIV_TAX_DEP_NOT_IN_AU = "DEEMING_INDIV_TAX_DEP_NOT_IN_AU";
  
  public static final String DEEMING_NBR_RESP_INDIV = "DEEMING_NBR_RESP_INDIV";
  
  public static final String DEEMING_AMT_DEEM_TAX_DEP_OUTS_HH = "DEEMING_AMT_DEEM_TAX_DEP_OUTS_HH";
  
  public static final String DEEMING_AMT_DEEM_ALIMONY_OUTS_HH = "DEEMING_AMT_DEEM_ALIMONY_OUTS_HH";
  
  public static final String NBR_DEEM_PERSONS_SON_LOOKUP = "NBR_DEEM_PERSONS_SON_LOOKUP";
  
  public static final String AMT_DEEM_GROSS_EARNED_INCOME = "AMT_DEEM_GROSS_EARNED_INCOME";
  
  public static final String AMT_DEEM_STD_EARNED_INC_DEDUCT = "AMT_DEEM_STD_EARNED_INC_DEDUCT";
  
  public static final String AMT_DEEM_NET_EARNED_INCOME = "AMT_DEEM_NET_EARNED_INCOME";
  
  public static final String AMT_DEEM_UNEARNED_INCOME = "AMT_DEEM_UNEARNED_INCOME";
  
  public static final String AMT_DEEM_CNT_NET_INCOME = "AMT_DEEM_CNT_NET_INCOME";
  
  public static final String AMT_DEEM_STD_OF_NEED = "AMT_DEEM_STD_OF_NEED";
  
  public static final String AMT_DEEM_TAX_DEPEND_OUT_HH = "AMT_DEEM_TAX_DEPEND_OUT_HH";
  
  public static final String AMT_DEEM_ALIMONY_OUT_HH = "AMT_DEEM_ALIMONY_OUT_HH";
  
  public static final String DEEM_SURPLUS_OR_DEFICIT = "DEEM_SURPLUS_OR_DEFICIT";
  
  public static final String AMT_DEEM_SURPLUS_OR_DEFICIT = "AMT_DEEM_SURPLUS_OR_DEFICIT";
  
  public static final String AMT_DEEM_TOTAL = "AMT_DEEM_TOTAL";
  
  public static final String ALLOCATION_BUDGET_SNG1 = "ALLOCATION_BUDGET_SNG1";
  
  public static final String SNG1_ALLOC_PERSON = "SNG1_ALLOC_PERSON";
  
  public static final String NBR_INELIG_PERSON_ALLOC_SNG1 = "NBR_INELIG_PERSON_ALLOC_SNG1";
  
  public static final String AMT_STD_OF_NEED_ALLOC_SNG1 = "AMT_STD_OF_NEED_ALLOC_SNG1";
  
  public static final String AMT_GROSS_INCOME_ALLOC_SNG1 = "AMT_GROSS_INCOME_ALLOC_SNG1";
  
  public static final String AMT_ALLOC_ALLOWANCE_SNG1 = "AMT_ALLOC_ALLOWANCE_SNG1";
  
  public static final String ALLOCATION_BUDGET_SNG2 = "ALLOCATION_BUDGET_SNG2";
  
  public static final String SNG2_ALLOC_PERSON = "SNG2_ALLOC_PERSON";
  
  public static final String NBR_INELIG_PERSON_ALLOC_SNG2 = "NBR_INELIG_PERSON_ALLOC_SNG2";
  
  public static final String AMT_STD_OF_NEED_ALLOC_SNG2 = "AMT_STD_OF_NEED_ALLOC_SNG2";
  
  public static final String AMT_GROSS_INCOME_ALLOC_SNG2 = "AMT_GROSS_INCOME_ALLOC_SNG2";
  
  public static final String AMT_ALLOC_ALLOWANCE_SNG2 = "AMT_ALLOC_ALLOWANCE_SNG2";
  
  public static final String ALLOCATION_BUDGET_MUTUAL = "ALLOCATION_BUDGET_MUTUAL";
  
  public static final String NBR_INELIG_PERSON_ALLOC_MUTUAL = "NBR_INELIG_PERSON_ALLOC_MUTUAL";
  
  public static final String AMT_STD_OF_NEED_ALLOC_MUTUAL = "AMT_STD_OF_NEED_ALLOC_MUTUAL";
  
  public static final String AMT_GROSS_INCOME_ALLOC_MUTUAL = "AMT_GROSS_INCOME_ALLOC_MUTUAL";
  
  public static final String AMT_ALLOC_ALLOWANCE_MUTUAL = "AMT_ALLOC_ALLOWANCE_MUTUAL";
  
  public static final String AMT_ALLOC_ALLOWANCE = "AMT_ALLOC_ALLOWANCE";
  
  public static final String NBR_CERTIFIED_GROUP = "NBR_CERTIFIED_GROUP";
  
  public static final String AMT_NONEXEMPT_RSRC_CRTFD_GRP = "AMT_NONEXEMPT_RSRC_CRTFD_GRP";
  
  public static final String AMT_GROSS_INCOME_CRTFD_GRP = "AMT_GROSS_INCOME_CRTFD_GRP";
  
  public static final String AMT_RESOURCE_LIMIT_CRTFD_GRP = "AMT_RESOURCE_LIMIT_CRTFD_GRP";
  
  public static final String AMT_GROSS_INCOME_CEILING = "AMT_GROSS_INCOME_CEILING";
  
  public static final String IS_EQUITY = "IS_EQUITY";
  
  public static final String GIC_SURP_DEFCT_CRTFD_GRP = "GIC_SURP_DEFCT_CRTFD_GRP";
  
  public static final String AMT_GIC_SURP_DEFCT_CRTFD_GRP = "AMT_GIC_SURP_DEFCT_CRTFD_GRP";
  
  public static final String IS_GROSS_INC_CEILING_ELGBLTY = "IS_GROSS_INC_CEILING_ELGBLTY";
  
  public static final String AU_MBR_NAME = "AU_MBR_NAME";
  
  public static final String AU_MBR_REL = "AU_MBR_REL";
  
  public static final String AU_MBR_AMT_GROSS_EARNED_INCOME = "AU_MBR_AMT_GROSS_EARNED_INCOME";
  
  public static final String AU_MBR_AMT_STD_EARNED_INCOME_DEDUCT = "AU_MBR_AMT_STD_EARNED_INCOME_DEDUCT";
  
  public static final String AU_MBR_AMT_CNTBL_INCOME = "AU_MBR_AMT_CNTBL_INCOME";
  
  public static final String AU_MBR_AMT_CNTBL_INCOME_LESS_30 = "AU_MBR_AMT_CNTBL_INCOME_LESS_30";
  
  public static final String AU_MBR_AMT_CNTBL_INCOME_LESS_THIRD = "AU_MBR_AMT_CNTBL_INCOME_LESS_THIRD";
  
  public static final String AMT_GROSS_EARNED_CRTFD_GRP = "AMT_GROSS_EARNED_CRTFD_GRP"; 
  
  public static final String AMT_STD_EARNED_INCOME_DEDUCT = "AMT_STD_EARNED_INCOME_DEDUCT"; 
  
  public static final String AMT_EARNED_LESS_STD_DEDUCT = "AMT_EARNED_LESS_STD_DEDUCT"; 
  
  public static final String AMT_DEPENDENT_CARE_DEDUC = "AMT_DEPENDENT_CARE_DEDUC"; 
  
  public static final String AMT_LESS_DEP_CARE_STD_NEED = "AMT_LESS_DEP_CARE_STD_NEED"; 
  
  public static final String AMT_GROSS_UNEARNED_CRTFD_GRP = "AMT_GROSS_UNEARNED_CRTFD_GRP"; 
  
  public static final String AMT_PLUS_UNEARNED_STD_NEED = "AMT_PLUS_UNEARNED_STD_NEED"; 
  
  public static final String AMT_PLUS_DEEMED_STD_NEED = "AMT_PLUS_DEEMED_STD_NEED"; 
  
  public static final String AMT_COUNTABLE_INCOME_STD_NEED = "AMT_COUNTABLE_INCOME_STD_NEED"; 
  
  public static final String AMT_STANDARD_OF_NEED = "AMT_STANDARD_OF_NEED"; 
  
  public static final String STD_TEST_SURP_DEFCT = "STD_TEST_SURP_DEFCT"; 
  
  public static final String AMT_SURP_DEFCT_STD_NEED = "AMT_SURP_DEFCT_STD_NEED"; 
  
  public static final String AMT_EARNED_LESS_ALL_DEDUCT = "AMT_EARNED_LESS_ALL_DEDUCT"; 
  
  public static final String AMT_LESS_DEP_CARE_ELIG = "AMT_LESS_DEP_CARE_ELIG"; 
  
  public static final String AMT_NET_EARNED_INCOME = "AMT_NET_EARNED_INCOME"; 
  
  public static final String AMT_PLUS_UNEARNED_ELIG = "AMT_PLUS_UNEARNED_ELIG"; 
  
  public static final String AMT_CHSUP_CRTFD_GRP = "AMT_CHSUP_CRTFD_GRP"; 
  
  public static final String AMT_PLUS_CHSUP_CRTFD_GRP = "AMT_PLUS_CHSUP_CRTFD_GRP"; 
  
  public static final String AMT_PLUS_DEEMED_ELIG = "AMT_PLUS_DEEMED_ELIG"; 
  
  public static final String AMT_LESS_ALLOC_ELIG = "AMT_LESS_ALLOC_ELIG"; 
  
  public static final String AMT_COUNTABLE_INCOME = "AMT_COUNTABLE_INCOME"; 
  
  public static final String ELIG_SURP_DEFCT_CRTFD_GRP = "ELIG_SURP_DEFCT_CRTFD_GRP"; 
  
  public static final String AMT_SURP_DEFCT_ELIG_CRTFD_GRP = "AMT_SURP_DEFCT_ELIG_CRTFD_GRP"; 
  
  public static final String TMPLAT_IV_E_BUDGET_WORKSHEET = "TMPLAT_IV_E_BUDGET_WORKSHEET"; 
  
  public static final String AMT_CTNBL_RESOURCE_CHILD = "AMT_CTNBL_RESOURCE_CHILD"; 
  
  public static final String AMT_TOTAL_GROSS_EARNED_CHILD = "AMT_TOTAL_GROSS_EARNED_CHILD"; 
  
  public static final String AMT_GROSS_EARNED_CHILD = "AMT_GROSS_EARNED_CHILD"; 
  
  public static final String AMT_RESOURCE_LIMIT_CHILD = "AMT_RESOURCE_LIMIT_CHILD"; 
  
  public static final String AMT_GROSS_INCOME_CEILING_CHILD = "AMT_GROSS_INCOME_CEILING_CHILD"; 
  
  public static final String IS_CTNBL_RES_CHILD_ELGBLTY = "IS_CTNBL_RES_CHILD_ELGBLTY"; 
  
  public static final String GIC_SURP_DEFCT_CHILD = "GIC_SURP_DEFCT_CHILD"; 
  
  public static final String IS_GROSS_INC_CHILD_ELGBLTY = "IS_GROSS_INC_CHILD_ELGBLTY"; 
  
  public static final String CHILD_AMT_CNTBL_INCOME_30 = "CHILD_AMT_CNTBL_INCOME_30"; 
  
  public static final String CHILD_AMT_CNTBL_INCOME_LESS_30 = "CHILD_AMT_CNTBL_INCOME_LESS_30"; 
  
  public static final String CHILD_AMT_CNTBL_INCOME_THIRD = "CHILD_AMT_CNTBL_INCOME_THIRD"; 
  
  public static final String CHILD_AMT_CNTBL_INCOME_LESS_THIRD = "CHILD_AMT_CNTBL_INCOME_LESS_THIRD"; 
  
  public static final String AMT_DEP_CARE_DEDUC_CHILD = "AMT_DEP_CARE_DEDUC_CHILD"; 
  
  public static final String AMT_NET_EARNED_INCOME_CHILD = "AMT_NET_EARNED_INCOME_CHILD"; 
  
  public static final String AMT_GROSS_UNEARNED_CHILD = "AMT_GROSS_UNEARNED_CHILD"; 
  
  public static final String AMT_CHSUP_CHILD = "AMT_CHSUP_CHILD"; 
  
  public static final String AMT_PLUS_CHSUP_CHILD = "AMT_PLUS_CHSUP_CHILD"; 
  
  public static final String AMT_CNTBL_INCOME = "AMT_CNTBL_INCOME"; 
  
  public static final String AMT_STD_OF_NEED_CHILD = "AMT_STD_OF_NEED_CHILD"; 
  
  public static final String ELIG_SURP_DEFCT_CHILD = "ELIG_SURP_DEFCT_CHILD"; 
  
  public static final String AMT_SURP_DEFCT_ELIG_CHILD = "AMT_SURP_DEFCT_ELIG_CHILD"; 
  
  public static final String COST_OF_CARE_ANSWER = "COST_OF_CARE_ANSWER";

  public static final String EMANCIPATION_ANSWER = "EMANCIPATION_ANSWER";

  public static final String CRESOURCE_TYPE = "CRESOURCE_TYPE";

  public static final String FAMILY_COUNTABLE = "FAMILY_COUNTABLE";

  public static final String TXT_COMMENTS = "TXT_COMMENTS";

  public static final String OUT_OF_HOME_CARE_ANSWER = "OUT_OF_HOME_CARE_ANSWER";

  public static final String PROCESS_OF_ADOPTION_ANSWER = "PROCESS_OF_ADOPTION_ANSWER";

  public static final String FUNDING_ANSWER = "FUNDING_ANSWER";

  public static final String PAYEER = "PAYEER";

  public static final String RECEIVER = "RECEIVER";

  public static final String SERVICE_PROVIDER = "SERVICE_PROVIDER";

  public static final String MONTHLY_PAYMENT = "MONTHLY_PAYMENT";

  public static final String NBR_CHILDREN_IN_REMOVAL = "NBR_CHILDREN_IN_REMOVAL";

  public static final String COURT_ORDERED_SUPPORT = "COURT_ORDERED_SUPPORT";

  public static final String OTHER_PAYMENTS = "OTHER_PAYMENTS";

  public static final String PROOF_DATE = "PROOF_DATE";

  public static final String PROOF_COMMENTS = "PROOF_COMMENTS";

  public static final String FAM_CHILD_INCOME = "FAM_CHILD_INCOME";

  public static final String PROOF = "PROOF";

  public static final String CITIZENSHIP = "CITIZENSHIP";

  public static final String CITIZENSHIP_DT_VERIFY = "CITIZENSHIP_DT_VERIFY";

  public static final String CITIZENSHIP_COMMENTS_VERIFY = "CITIZENSHIP_COMMENTS_VERIFY";

  public static final String AFFIDAVIT_PROVIDED = "AFFIDAVIT_PROVIDED";
  
  public static final String AFFIDAVIT_DT_PROVIDED = "AFFIDAVIT_DT_PROVIDED";

  public static final String LEGAL_DOCUMENTS_COMMENTS_VERIFY = "LEGAL_DOCUMENTS_COMMENTS_VERIFY";

  public static final String PREGNACY_DATE = "PREGNACY_DATE";

  public static final String PREGNACY_COMMENTS = "PREGNACY_COMMENTS";

  public static final String CHILD_SUPPORT = "CHILD_SUPPORT";

  public static final String CASE_MGR_NOM = "CASE_MGR_NOM";

  public static final String CASE_MGR_PHONE = "CASE_MGR_PHONE";

  public static final String CHILD_ELGIBILITY = "CHILD_ELGIBILITY";

  public static final String CHECK_UNDER_AGE = "CHECK_UNDER_AGE";

  public static final String CHECK_CITIZEN = "CHECK_CITIZEN";

  public static final String CHECK_DEPRIVATION = "CHECK_DEPRIVATION";

  public static final String CHECK_PHISICAL_REMOVAL = "CHECK_PHISICAL_REMOVAL";

  public static final String CHECK_AFDC = "CHECK_AFDC";

  public static final String PREGNACY = "PREGNACY";

  public static final String MANAGER_NAME_FIRST = "MANAGER_NAME_FIRST";

  public static final String MANAGER_NAME_MIDDLE = "MANAGER_NAME_MIDDLE";

  public static final String MANAGER_NAME_LAST = "MANAGER_NAME_LAST";

  public static final String MANAGER_NAME_SUFFIX = "MANAGER_NAME_SUFFIX";

  public static final String CHECK_LESS_EQUITY = "CHECK_LESS_EQUITY";

  public static final String DT_BEST_INTEREST = "DT_BEST_INTEREST";

  public static final String DT_PARENTAL_REMOVAL = "DT_PARENTAL_REMOVAL";

  public static final String CHILD_STATUS = "CHILD_STATUS";

  public static final String EGIBILITY_ACTUAL = "EGIBILITY_ACTUAL";

  public static final String ELIGIBILITY_START_DATES = "ELIGIBILITY_START_DATES";

  public static final String ELIGIBILITY_END_DATES = "ELIGIBILITY_END_DATES";

  public static final String ELIGIBILITY_REVIEW_DATES = "ELIGIBILITY_REVIEW_DATES";

  public static final String REIMBUSABLE_SSI = "REIMBUSABLE_SSI";

  public static final String REIMBUSABLE_SELECT_ELIGIBLE = "REIMBUSABLE_SELECT_ELIGIBLE";

  public static final String REIMBUSABLE_ASSISTANCE = "REIMBUSABLE_ASSISTANCE";

  public static final String REFERRAL_DT = "REFERRAL_DT";

  public static final String REFERRAL_COMMENTS = "REFERRAL_COMMENTS";

  public static final String HOSPITAL_NAME = "HOSPITAL_NAME";

  public static final String HOSPITAL_CITY = "HOSPITAL_CITY";

  public static final String HOSPITAL_MAIDEN_NAME = "HOSPITAL_MAIDEN_NAME";

  public static final String HOSPITAL_COUNTY = "HOSPITAL_COUNTY";

  public static final String FCE_ELIGIBILITY = "FCE_ELIGIBILITY";

  public static final String DEPRIVATION_MONTHS = "DEPRIVATION_MONTHS";

  public static final String DEPRIVATION_UNDEREMP_MONTHS = "DEPRIVATION_UNDEREMP_MONTHS";

  public static final String THIRD_TYPE = "THIRD_TYPE";

  public static final String THIRD_BEGIN_DATE = "THIRD_BEGIN_DATE";

  public static final String THIRD_END_DATE = "THIRD_END_DATE";

  public static final String THIRD_COMPANY_NAME = "THIRD_COMPANY_NAME";

  public static final String THIRD_POLICY_NUMBER = "THIRD_POLICY_NUMBER";

  public static final String THIRD_GROUP_NUMBER = "THIRD_GROUP_NUMBER";

  public static final String THIRD_STREET_ONE = "THIRD_STREET_ONE";

  public static final String THIRD_STREET_TWO = "THIRD_STREET_TWO";

  public static final String THIRD_CITY = "THIRD_CITY";

  public static final String THIRD_STATE = "THIRD_STATE";

  public static final String THIRD_ZIP = "THIRD_ZIP";

  public static final String THIRD_PHONE = "THIRD_PHONE";

  public static final String EMPLOYERS_NM = "EMPLOYERS_NM";

  public static final String EMPLOYEES_NM = "EMPLOYEES_NM";

  public static final String PRINCIPAL_NM = "PRINCIPAL_NM";

  public static final String PRINCIPAL_RELATIONSHIP = "PRINCIPAL_RELATIONSHIP";

  public static final String DATE_RELEASE = "DATE_RELEASE";

  public static final String DATE_PAYMENT = "DATE_PAYMENT";

  public static final String CHANGE = "CHANGE";

  public static final String CANCELLATION = "CANCELLATION";

  public static final String DATE_HEALTH_CHANGE = "DATE_HEALTH_CHANGE";

  public static final String MANAGER_NAME_FIRST2 = "MANAGER_NAME_FIRST2";

  public static final String MANAGER_NAME_MIDDLE2 = "MANAGER_NAME_MIDDLE2";

  public static final String MANAGER_NAME_LAST2 = "MANAGER_NAME_LAST2";

  public static final String MANAGER_NAME_SUFFIX2 = "MANAGER_NAME_SUFFIX2";

  public static final String MANAGER_PHONE2 = "MANAGER_PHONE2";

  public static final String OTHER_INSURANCE = "OTHER_INSURANCE";

  public static final String DATE_OF_BIRTH = "DATE_OF_BIRTH";

  public static final String VERIFY_DOCUMENTS = "VERIFY_DOCUMENTS";

  public static final String VERIFY_DATE = "VERIFY_DATE";

  public static final String VERIFY_COMMENTS = "VERIFY_COMMENTS";

  public static final String FAMILY_AGE = "FAMILY_AGE";

  public static final String SPECIALIST_PHONE = "SPECIALIST_PHONE";

  public static final String SPECIALIST_ID = "SPECIALIST_ID";

  public static final String HOSPITAL_STATE = "HOSPITAL_STATE";

  public static final String THIRD_POLICY_HOLDER = "THIRD_POLICY_HOLDER";

  public static final String MANAGER_CHANGE = "MANAGER_CHANGE";

  public static final String CASE_MGR_COMMENTS = "CASE_MGR_COMMENTS";

  public static final String ELIGIBILITY_REASON = "ELIGIBILITY_REASON";
  
  public static final String NM_OF_RELATIVE = "NM_OF_RELATIVE";
  
  public static final String IS_SPECIFIED_RELATIVE = "IS_SPECIFIED_RELATIVE"; 
  
  public static final String PE_WORK_LESS_100_HOURS = "PE_WORK_LESS_100_HOURS";
  
  public static final String SPECIALIST_FIRST2 = "SPECIALIST_FIRST2";
  
  public static final String SPECIALIST_MIDDLE2 = "SPECIALIST_MIDDLE2"; 
  
  public static final String SPECIALIST_LAST2 = "SPECIALIST_LAST2"; 
  
  public static final String SPECIALIST_NAME_FIRST = "SPECIALIST_NAME_FIRST";
  
  public static final String SPECIALIST_NAME_LAST = "SPECIALIST_NAME_LAST";
  
  public static final String SPECIALIST_NAME_MIDDLE = "SPECIALIST_NAME_MIDDLE";
  
  public static final String METHOD_OF_VRFTN = "METHOD_OF_VRFTN";
  
  public static final String METHOD_OF_VRFTN_IDENTITY_ADULT = "METHOD_OF_VRFTN_IDENTITY_ADULT";
  
  public static final String METHOD_OF_VRFTN_IDENTITY_UNDER16 = "METHOD_OF_VRFTN_IDENTITY_UNDER16";
  
  public static final String METHOD_OF_VRFTN_PERM_RES = "METHOD_OF_VRFTN_PERM_RES";
  
  public static final String METHOD_OF_VRFTN_OTHER_ALIEN = "METHOD_OF_VRFTN_OTHER_ALIEN";
  
  public static final String METHOD_OF_VRFTN_UNDETERMINED = "METHOD_OF_VRFTN_UNDETERMINED";
  
  public static final String VRFY_METHODS_SPECIAL = "VRFY_METHODS_SPECIAL";
  
  public static final String ALLOCATION_ALLOWANCE = "ALLOCATION_ALLOWANCE";
  
  public static final String REASONS  = "REASONS";
  
  public FOSTERCAREAPPSO retrieveFosterCareApp(FOSTERCAREAPPSI fosterCareAppsi);
}
