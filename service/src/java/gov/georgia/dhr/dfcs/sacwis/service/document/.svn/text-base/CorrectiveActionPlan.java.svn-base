package gov.georgia.dhr.dfcs.sacwis.service.document;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CorrectiveActionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CorrectiveActionSO;

public interface CorrectiveActionPlan extends PolicyViolationReport {
    
  //Repeating group constants for TMPLAT_PRU_SIGNATURE
  public static final String TMPLAT_PRU_SIGNATURE = "TMPLAT_PRU_SIGNATURE";
  public static final String TMPLAT_CPA_TEXT1 = "TMPLAT_CPA_TEXT1";
  public static final String TMPLAT_CPA_TEXT2 = "TMPLAT_CPA_TEXT2";
  
  // In-line bookmarks
  public static final String HOME_TYPE = "HOME_TYPE";
  public static final String COUNTY_PLAN = "COUNTY_PLAN";
  public static final String EFFECTIVE_FROM_DATE = "EFFECTIVE_FROM_DATE";
  public static final String EFFECTIVE_TO_DATE = "EFFECTIVE_TO_DATE";

  
  /**
   * The retrieveCorrectiveActionPlan method is the main entry point
   * for the service to generate the Corrective Action Plan.
   * 
   * @param CorrectiveActionSI
   *          Input object which should contain the Stage ID.
   * @return CorrectiveActionSO Output object which contains prefill data
   */
  public CorrectiveActionSO retrieveCorrectiveActionPlan(CorrectiveActionSI correctiveActionSI);

}
