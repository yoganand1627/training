package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RISKASSMTFORMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RISKASSMTFORMSO;

public interface RiskAssmtForm extends DocumentService{
  
  // Template names
  public final String CFA02O00 = "CFA02O00";
  public final String CFA02O01 = "CFA02O01";
  
  // repeating groups names
  public final String TMPLAT_SUMMARY = "TMPLAT_SUMMARY";
  public final String TMPLAT_SUMMARY_CATEGORY = "TMPLAT_SUMMARY_CATEGORY";
  public final String TMPLAT_AREA = "TMPLAT_AREA";
  public final String TMPLAT_AREA_CATEGORY = "TMPLAT_AREA_CATEGORY";
  public final String TMPLAT_AREA_FACTOR = "TMPLAT_AREA_FACTOR";
  public final String TMPLAT_PRIOR_HISTORY = "TMPLAT_PRIOR_HISTORY";
  
  // individual fields
  public final String AREA_FACTOR_ANSWER = "AREA_FACTOR_ANSWER";
  public final String RISK_ASSMT_PURPOSE = "RISK_ASSMT_PURPOSE";
  public final String RISK_ASSMT_RESP_DATE = "RISK_ASSMT_RESP_DATE";
  public final String RISK_ASSMT_RESP_TIME = "RISK_ASSMT_RESP_TIME";
  public final String RISK_ASSMT_RESP_TIME_MET = "RISK_ASSMT_RESP_TIME_MET";
  public final String SUMMARY_AREA_OF_CONCERN = "SUMMARY_AREA_OF_CONCERN";
  public final String SUMMARY_SCALE_OF_CONCERN = "SUMMARY_SCALE_OF_CONCERN";
  public final String SUMMARY_OVRLL_AREA_OF_CONCERN  = " SUMMARY_OVRLL_AREA_OF_CONCERN";
  public final String SUMMARY_OVRLL_SCALE_OF_CONCERN  = " SUMMARY_OVRLL_SCALE_OF_CONCERN";
  public final String AREA_AREA_OF_CONCERN = "AREA_AREA_OF_CONCERN";
  public final String AREA_CATEGORY = "AREA_CATEGORY";
  public final String AREA_CATEGORY_OF_CONCERN = "AREA_CATEGORY_OF_CONCERN";
  public final String AREA_CATEGORY_SCALE_OF_CONCERN = "AREA_CATEGORY_SCALE_OF_CONCERN";
  public final String AREA_FACTOR = "AREA_FACTOR";
  public final String Y_IS_CHECKED = "Y_IS_CHECKED";
  public final String N_IS_CHECKED = "N_IS_CHECKED";
  public final String U_IS_CHECKED = "U_IS_CHECKED";
  public final String FIELD_NAME   = "FIELD_NAME";
  public final String FIELD_NAME_YES  = "FIELD_NAME_YES";
  public final String FIELD_NAME_NO   = "FIELD_NAME_NO";
  public final String FIELD_NAME_UNK  = "FIELD_NAME_UNK";
  public final String CATEGORY_OVRL_SCALE_OF_CONCERN = "CATEGORY_OVRL_SCALE_OF_CONCERN";
  public final String CATEGORY_SCALE_OF_CONCERN_RESULT = "CATEGORY_SCALE_OF_CONCERN_RESULT";
  public final String AREA_SCALE_OF_CONCERN_LABEL = "AREA_SCALE_OF_CONCERN_LABEL";
  public final String AREA_OVRL_SCALE_OF_CONCERN = "AREA_OVRL_SCALE_OF_CONCERN";
  public final String AREA_SCALE_OF_CONCERN_RESULT = "AREA_SCALE_OF_CONCERN_RESULT";
  public final String AREA_JUSTIFICATION_FINDINGS = "AREA_JUSTIFICATION_FINDINGS";
  public final String PARENTS_GUIDE_GIVEN = "PARENTS_GUIDE_GIVEN";
  public final String DATE_PARENTS_RCVD_GUIDE = "DATE_PARENTS_RCVD_GUIDE";
  public final String PARENTS_CHILD_EXAM_NOTIF = "PARENTS_CHILD_EXAM_NOTIF";
  public final String DATE_PARENTS_CHILD_EXAM_NOTIF = "DATE_PARENTS_CHILD_EXAM_NOTIF";
  public final String HIPPA_EXPLAINED = "HIPPA_EXPLAINED";
  public final String PRIM_CARETAKER_SIGNED_AGRMNT = "PRIM_CARETAKER_SIGNED_AGRMNT";
  public final String DATE_HIPPA_AGRMNT_SIGNED = "DATE_HIPPA_AGRMNT_SIGNED";
  public final String HIPPA_COMMENTS = "HIPPA_COMMENTS";
  // Prior History
  public final String HIST_DT_REPORT = "HIST_DT_REPORT";
  public final String HIST_CHILD_INJURY = "HIST_CHILD_INJURY";
  public final String HIST_DT_CLOSURE = "HIST_DT_CLOSURE";
  public final String HIST_PRIOR_COMMENTS = "HIST_PRIOR_COMMENTS";
  
  // assessment
  public final String ASSMT_CHILD_VULNERABILITY = "ASSMT_CHILD_VULNERABILITY";
  public final String ASSMT_CHILD_FRGLTY_PRTCTN   = "ASSMT_CHILD_FRGLTY_PRTCTN";
  public final String ASSMT_CHILD_BEHAVIOR  = "ASSMT_CHILD_BEHAVIOR";
  public final String ASSMT_CAREGIVER_CPBLTY   = "ASSMT_CAREGIVER_CPBLTY";
  public final String ASSMT_KNOWLEDGE_SKILLS  = "ASSMT_KNOWLEDGE_SKILLS";
  public final String ASSMT_CONTROL = "ASSMT_CONTROL";
  public final String ASSMT_FUNCTIONING = "ASSMT_FUNCTIONING";
  public final String ASSMT_QUALITY_CARE = "ASSMT_QUALITY_CARE";
  public final String ASSMT_EMOTIONAL_CARE = "ASSMT_EMOTIONAL_CARE";
  public final String ASSMT_PHYSICAL_CARE = "ASSMT_PHYSICAL_CARE";
  public final String ASSMT_MALTREATMENT_PATTERN = "ASSMT_MALTREATMENT_PATTERN";
  public final String ASSMT_CURRENT_SEVERITY = "ASSMT_CURRENT_SEVERITY";
  public final String ASSMT_CHRONICITY = "ASSMT_CHRONICITY";
  public final String ASSMT_TREND = "ASSMT_TREND";
  public final String ASSMT_HOME_ENVIRONMENT = "ASSMT_HOME_ENVIRONMENT";
  public final String ASSMT_STRESSORS = "ASSMT_STRESSORS";
  public final String ASSMT_DANGEROUS_EXPOSURE = "ASSMT_DANGEROUS_EXPOSURE";
  public final String ASSMT_SOCIAL_ENVIRONMENT = "ASSMT_SOCIAL_ENVIRONMENT";
  public final String ASSMT_SOCIAL_CLIMATE = "ASSMT_SOCIAL_CLIMATE";
  public final String ASSMT_SOCIAL_VIOLENCE = "ASSMT_SOCIAL_VIOLENCE";
  public final String ASSMT_RESPONSE_INTRVNTION = "ASSMT_RESPONSE_INTRVNTION";
  public final String ASSMT_ATTITUDE = "ASSMT_ATTITUDE";
  public final String ASSMT_DECEPTION = "ASSMT_DECEPTION";
  public final String SUMMARIZE_COMMENTS = "SUMMARIZE_COMMENTS";
  
  
   
  
  

  public RISKASSMTFORMSO retrieveContactVisitationsLog(RISKASSMTFORMSI riskAssmtFormsi);

}
