package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.HOMEEVALUATIONSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HOMEEVALUATIONSO;

public interface HomeEvaluation extends DocumentService {
  //   Group Names
  public static final String FRD03O00 = "FRD03O00";
  public static final String FRD03O01 = "FRD03O01";

  // Form Group Bookmark Names
  public static final String TMP1_CITIZENSHIP = "TMP1_CITIZENSHIP";
  public static final String TMP2_ETHNICITY = "TMP2_ETHNICITY";

  public HOMEEVALUATIONSO retrieveHomeEvaluation(HOMEEVALUATIONSI homeEvaluationSI);
}