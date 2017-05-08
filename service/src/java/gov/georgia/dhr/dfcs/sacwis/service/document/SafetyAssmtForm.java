/**
 * Created on Dec 13, 2006 at 10:30:11 AM by Selima Rollins
 */
package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SAFETYASSESSMENTFRMSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SAFETYASSESSMENTFRMSO;

public interface SafetyAssmtForm extends DocumentService {

  //   Template Name
  public final String FAS01O00 = "FAS01O00";

  // Repeating Groups
  public final String TMPLAT_SAFETY_FACTORS = "TMPLAT_SAFETY_FACTORS";
  public final String TMPLAT_CARETAKER_INFO = "TMPLAT_CARETAKER_INFO";
  public final String TMPLAT_DRUG_EXPOSED = "TMPLAT_DRUG_EXPOSED";
  public final String TMPLAT_OTHER_SA_FACTOR = "TMPLAT_OTHER_SA_FACTOR";
  public final String TMPLAT_COMMA = "TMPLAT_COMMA";
  public final String TMPLAT_REASONABLE_EFFORTS = "TMPLAT_REASONABLE_EFFORTS";
  public final String TMPLAT_CLIENT_NAME = "TMPLAT_CLIENT_NAME";
  public final String TMPLAT_CLIENT_NAME_LIST = "TMPLAT_CLIENT_NAME_LIST";
  public final String TMPLAT_REASON_LISTNAMES = "TMPLAT_REASON_LISTNAMES";
  public final String TMPLAT_REASONNAME = "TMPLAT_REASONNAME";
  public final String TMPLAT_NAME_ALL = "TMPLAT_NAME_ALL";
  public final String TMPLAT_OTHER_NLIST = "TMPLAT_OTHER_NLIST";
  public final String TMPLAT_NAMES = "TMPLAT_NAMES";
  public final String TMPLAT_EXPOSED_DRUG = "TMPLAT_EXPOSED_DRUG";

  // Individual Fields

  public final String SAFETY_FACTORS_LIST = "SAFETY_FACTORS_LIST";
  public final String CARETAKER_FULL_NAME = "CARETAKER_FULL_NAME";
  public final String CHILD_NAME_FULL = "CHILD_NAME_FULL";
  public final String SAFETY_DECISION = "SAFETY_DECISION";
  public final String OTHER_FACTORS = "OTHER_FACTORS";
  public final String DRUG_EXPOSED_NEWBORN = "DRUG_EXPOSED_NEWBORN";
  public final String REASONABLE_EFFORTS = "REASONABLE_EFFORTS";
  public final String REASONABLE_EFF_RSPNS = "REASONABLE_EFF_RSPNS";
  public final String REASONABLE_EFFORTS_COMMENT = "REASONABLE_EFFORTS_COMMENT";
  public final String SAFETY_COMMENTS_ASSMNT = "SAFETY_COMMENTS_ASSMNT";
  public final String OVERALL_SAFETY_DECISION = "OVERALL_SAFETY_DECISION";
  public final String CHILD_NAME_WHOLE = "CHILD_NAME_WHOLE";
  public final String ADDITIONAL_COMMENTS_EFFORTS = "ADDITIONAL_COMMENTS_EFFORTS";
  public final String CHILD_OTHER_NA = "CHILD_OTHER_NA";
  public final String OTHER_SAFETY_DECISIONS1 = "OTHER_SAFETY_DECISIONS1";
  public final String OTHER_CARETAKER1 = "OTHER_CARETAKER1";
  public final String TITLE_COUNTY_NAME = "TITLE_COUNTY_NAME";
  public final String TITLE_MANAGER_ID = "TITLE_MANAGER_ID";
  public final String TITLE_MANAGER_NAME = "TITLE_MANAGER_NAME";

  public SAFETYASSESSMENTFRMSO retrieveSafetyAssmtFrm(SAFETYASSESSMENTFRMSI safetyAssessmentFrmsi);

}
