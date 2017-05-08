package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;

public interface EligibilitySummaryCommonFunction {
  
  /**
   * This retrieves the data from the FCE_ELIGIBILITY table for idEligibilityEvent
   * @param idEligibilityEvent
   * @return FceEligibilityDB
   */
  public FceEligibilityDB retrieveEligibilityForEligibilityEvent(long idEligibilityEvent);
  
  /**
   * This updates the FCE_ELIGIBILITY table with CdBlocAmtSsi
   * @param long idFceEligibility, String cdBlocChild, double amtSsi
   * @return int
   */
  public int updateFceEligibilityCdBlocAmtSsi(long idFceEligibility, String cdBlocChild, double amtSsi);
  
  /**
   * This updates the FCE_ELIGIBILITY table with indChildSupportOrdered
   * @param long idFceEligibility, String cdBlocChild, String indChildSupportOrdered
   * @return int
   */
  public int updateFceEligibilityIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered);
}
