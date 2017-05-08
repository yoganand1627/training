package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.TCMClaimValidateSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.TCMClaimValidateSO;

public interface ValidateTCMClaim {
  /**
   * Use this service to validate a proposed TCM Claim before it is saved. If validation fails, a
   * ServiceException will be thrown. If validation is successful (okay to save), the returned
   * object will contain the medicaid value to be saved under NBR_MEDICAID in TCM_CLAIM. This service
   * DOES NOT insert or update anything in the database.
   * 
   * @param tcmClaimValidateSI
   * @return
   */
  public TCMClaimValidateSO validateTCMClaim(TCMClaimValidateSI tcmClaimValidateSI);
}
