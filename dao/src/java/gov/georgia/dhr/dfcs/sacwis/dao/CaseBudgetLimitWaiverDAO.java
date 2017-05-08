/**
 * Created on April 6, 2007 by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimitWaiver;

import java.util.List;

public interface CaseBudgetLimitWaiverDAO {

  /**
   * Retrieves the record in Case Budget Limit Waiver table for the given idWaiver. <p/>
   *
   * @param idWaiver
   * @return
   */

  CaseBudgetLimitWaiver findPolicyWaiverEntry(int idWaiver);

  /**
   * Inserts the record in Budget Limit Waiver table. <p/>
   *
   * @param bLmtWaiver
   * @return
   */

  void saveCaseBudgetLimitWaiver(CaseBudgetLimitWaiver bLmtWaiver);
}