/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralRetrieveSO;

/**
 * @author ashwini.rege
 *
 */
public interface RetrieveChildrenFirstReferral {
  /**
   * @param childrenFirstReferralRetrieveSI
   * @return ChildrenFirstReferralRetrieveSO.
   */
  public ChildrenFirstReferralRetrieveSO retrieveChildrenFirstReferral(ChildrenFirstReferralRetrieveSI childrenFirstReferralRetrieveSI);

}
