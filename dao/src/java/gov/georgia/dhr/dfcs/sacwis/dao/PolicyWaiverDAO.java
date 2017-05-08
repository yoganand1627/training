/**
 * Created on Aug 29, 2006 by Carina Gerry
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;

public interface PolicyWaiverDAO {
  /**
   * This selects a row from policy_waiver given id_event. <p/>
   *
   * @param idEvent
   * @return
   */
  PolicyWaiver findPolicyWaiverByIdEvent(int idEvent);

  /**
   * Inserts/updates an entire row of PolicyWaiver table.
   *
   * @param policyWaiver
   */
  void savePolicyWaiver(PolicyWaiver policyWaiver);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver} object.
   *
   * @param policyWaiver
   */
  int deletePolicyWaiverByIdEvent(int idEvent);
}
