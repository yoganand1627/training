package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.REDETERMINATIONFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.REDETERMINATIONFORMSO;

public interface ReDeterminationForm extends DocumentService {
  
  // Template names
  public final String FEL02O00 = "FEL02O00";
  
  // repeating groups names
  public final String TMPLAT_RESOURCE_FOR_CHILD = "TMPLAT_RESOURCE_FOR_CHILD";
  public final String TMPLAT_EXPENDITURES = "TMPLAT_EXPENDITURES";
  public final String TMPLAT_EXPENDITURES_NONE = "TMPLAT_EXPENDITURES_NONE";
  public final String TMPLAT_INCOME_FOR_CHILD = "TMPLAT_INCOME_FOR_CHILD";

  // individual fields
  //  child Info
  public final String CHILD_NAME = "CHILD_NAME";
  //public final String CHILD_DOB = "CHILD_DOB"; // exists in service parent class
  public final String CHILD_SSN                    = "CHILD_SSN";
  public final String CHILD_MEDICAID_NBR           = "CHILD_MEDICAID_NBR";
  public final String CHILD_PERSON_ID              = "CHILD_PERSON_ID";
  public final String CHILD_MHN_NBR                = "CHILD_MHN_NBR";
  // case manager info
  public final String CASE_MNGR_NAME               = "CASE_MNGR_NAME";
  public final String CASE_MNGR_PHONE_NBR          = "CASE_MNGR_PHONE_NBR";

  // Eligibility Determination info
  public final String CHILD_TITLE_IV_ISELIGIBLE    = "CHILD_TITLE_IV_ISELIGIBLE";
  
  // Reasons Not Eligible
  public final String TMPLAT_REASONS_NOT_ELIGIBLE  = "TMPLAT_REASONS_NOT_ELIGIBLE";
  public final String TMPLAT_REASONS  = "TMPLAT_REASONS";
  public final String REASONS  = "REASONS";
  
  // Close Foster Care Reimbursability Determination
  public final String IS_NO_LONGER_APPROPRIATE = "IS_NO_LONGER_APPROPRIATE";
  public final String INAPPROPRIATE_COMMENTS = "INAPPROPRIATE_COMMENTS";
  
  // Income for the Child
  public final String CHILD_INCOME_NAME            = "CHILD_INCOME_NAME";
  public final String CHILD_INCOME_TYPE            = "CHILD_INCOME_TYPE";
  public final String CHILD_INCOME_AMT             = "CHILD_INCOME_AMT";
  public final String CHILD_INCOME_SOURCE          = "CHILD_INCOME_SOURCE";
  public final String CHILD_INCOME_NO_INC          = "CHILD_INCOME_NO_INC";
  public final String CHILD_INCOME_EARNED_UNEARNED = "CHILD_INCOME_EARNED_UNEARNED";
  public final String CHILD_INCOME_CNTBLE_EXMPT    = "CHILD_INCOME_CNTBLE_EXMPT";
  
  // Resources for the Child 
  public final String CHILD_RSRC_NAME              = "CHILD_RSRC_NAME";
  public final String CHILD_RSRC_TYPE              = "CHILD_RSRC_TYPE";
  public final String CHILD_RSRC_AMT               = "CHILD_RSRC_AMT";
  public final String CHILD_RSRC_SOURCE            = "CHILD_RSRC_SOURCE";
  public final String CHILD_RSRC_VERIFY_MTHD       = "CHILD_RSRC_VERIFY_MTHD";
  public final String CHILD_RSRC_INACCESSIBLE      = "CHILD_RSRC_INACCESSIBLE";
  public final String CHILD_RSRC_CNTBLE_EXMPT      = "CHILD_RSRC_CNTBLE_EXMPT";
  
  // Child Care Expenditures
  public final String PERSON_RECEIVING_CARE        = "PERSON_RECEIVING_CARE";
  public final String SERVICE_PROVIDER_NAME        = "SERVICE_PROVIDER_NAME";
  public final String AMT_PAID_MONTHLY             = "AMT_PAID_MONTHLY";
  
  // IV-E Budget Worksheet
  public final String AMT_CHSUP_CHILD = "AMT_CHSUP_CHILD";
  public final String AMT_COUNTABLE_INCOME = "AMT_COUNTABLE_INCOME";
  public final String AMT_CNTBL_INCOME = "AMT_CNTBL_INCOME";
  public final String AMT_CNTBL_INCOME_30 = "AMT_CNTBL_INCOME_30";
  public final String AMT_CNTBL_INCOME_LESS_30 = "AMT_CNTBL_INCOME_LESS_30";
  public final String AMT_CNTBL_INCOME_THIRD = "AMT_CNTBL_INCOME_THIRD";
  public final String AMT_CNTBL_INCOME_LESS_THIRD = "AMT_CNTBL_INCOME_LESS_THIRD";
  public final String AMT_CNTBL_RESOURCE_CHILD = "AMT_CNTBL_RESOURCE_CHILD";
  public final String AMT_DEP_CARE_DEDUC_CHILD = "AMT_DEP_CARE_DEDUC_CHILD";
  public final String AMT_EARNED_LESS_STD_DEDUCT = "AMT_EARNED_LESS_STD_DEDUCT";
  public final String AMT_GIC_SURP_DEFCT_CHILD = "AMT_GIC_SURP_DEFCT_CHILD";
  public final String AMT_GROSS_EARNED_CHILD = "AMT_GROSS_EARNED_CHILD";
  public final String AMT_GROSS_UNEARNED_CHILD = "AMT_GROSS_UNEARNED_CHILD";
  public final String AMT_GROSS_INCOME_CEILING_CHILD = "AMT_GROSS_INCOME_CEILING_CHILD";
  public final String AMT_LESS_DEP_CARE_ELIG = "AMT_LESS_DEP_CARE_ELIG";
  public final String AMT_NET_EARNED_INCOME_CHILD = "AMT_NET_EARNED_INCOME_CHILD";
  public final String AMT_PLUS_UNEARNED_ELIG = "AMT_PLUS_UNEARNED_ELIG";
  public final String AMT_PLUS_CHSUP_CHILD = "AMT_PLUS_CHSUP_CHILD";
  public final String AMT_RESOURCE_LIMIT_CHILD = "AMT_RESOURCE_LIMIT_CHILD";
  public final String AMT_STD_EARNED_INCOME_DEDUCT = "AMT_STD_EARNED_INCOME_DEDUCT";
  public final String AMT_STD_OF_NEED_CHILD = "AMT_STD_OF_NEED_CHILD";
  public final String AMT_SURP_DEFCT_ELIG_CHILD = "AMT_SURP_DEFCT_ELIG_CHILD";
  public final String AMT_TOTAL_GROSS_INCOME_CHILD = "AMT_TOTAL_GROSS_INCOME_CHILD";
  public final String ELIG_SURP_DEFCT_CHILD = "ELIG_SURP_DEFCT_CHILD";
  public final String GIC_SURP_DEFCT_CHILD = "GIC_SURP_DEFCT_CHILD";
  public final String IS_CTNBL_RES_CHILD_ELGBLTY = "IS_CTNBL_RES_CHILD_ELGBLTY";
  public final String IS_GROSS_INC_CHILD_ELGBLTY = "IS_GROSS_INC_CHILD_ELGBLTY";

  // Judicial Determination
  public final String TMPLAT_PRMNCY_OVERDUE  = "TMPLAT_PRMNCY_OVERDUE";
  public final String TMPLAT_PRMNCY_NOT_OVERDUE  = "TMPLAT_PRMNCY_NOT_OVERDUE";
  public final String TMPLAT_PRMNCY_EXISTS  = "TMPLAT_PRMNCY_EXISTS";
  public final String DT_PRMNCY_HRNGS_12_MONTH  = "DT_PRMNCY_HRNGS_12_MONTH";
  
  public final String TMPLAT_EXTNSION_EXISTS   = "TMPLAT_EXTNSION_EXISTS";
  public final String TMPLAT_EXTNSION_NOT_EXISTS   = "TMPLAT_EXTNSION_NOT_EXISTS";
  public final String DT_EXTNSION_PROVIDED_12_MNTHS   = "DT_EXTNSION_PROVIDED_12_MNTHS";
  
  // constants
  public static final String FOSTER_CARE_REVIEW_JNDI_NAME = "FosterCareReview";
  

//  public REDETERMINATIONFORMSO retrieveFCReDeterminationForm(FosterCareReviewDB fosterCareReviewDB);
  public REDETERMINATIONFORMSO retrieveFCReDeterminationForm(REDETERMINATIONFORMSI reDeterminationtFormsi);
  
}
