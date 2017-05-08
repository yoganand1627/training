/**
 * Created on April 12, 2007 by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

public interface ComplexCaseBudgetLimitDAO {

  /**
   * updates the the Case Budget Limit table when the service Authorization is approved, rejected or invalidated. <p/>
   * 
   * @param idCase
   * @param waiverId
   * @param svcAmtReqLmtMap
   * @return
   */
  void updateCaseBudgetLimit(int idCase, int waiverId, Map<String, List> svcAmtReqLmtMap);

  /**
   * updates the the Case Budget Limit table when the service Authorization is submitted for approval or when the
   * service auth detail is saved while the corresponding service auth header is in pending status. <p/>
   * 
   * @param idCase
   * @param svcCodeMap
   * @param indicator
   * @param idWaiver
   * @return
   */
  void updateCaseBudgetLimitOnApproval(int idCase, Map<String, List> svcCodeMap, String indicator, int idWaiver);

  /**
   * updates the the Case Budget Limit table when the termination date is set to an earlier date or the service is
   * rejectedR. <p/>
   * 
   * @param idCase
   * @param waiverId
   * @param svcAmtReqLmtMap
   * @param indRefReject
   * @param amtUsed
   * @return
   */
  void updateCaseBudgetLimitOnTerm(int idCase, Map<String, List> svcAmtReqLmtMap, String indRefReject, double amtUsed);
}