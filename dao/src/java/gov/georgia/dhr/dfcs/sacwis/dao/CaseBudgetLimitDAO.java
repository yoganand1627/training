/**
 * Created on April 6, 2007 by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CaseBudgetLimit;

import java.util.List;

public interface CaseBudgetLimitDAO {

  /**
   * Retrieves the remaining balance for a given combination of caseid and service code. <p/>
   *
   * @param idCase
   * @param cdSvcAuthCode
   * @return
   */
  CaseBudgetLimit findByIdCaseBySvcCode(int idCase, String cdSvcAuthCode);

  /**
   * Retrieves all the records in Case Budget Limit table for the given combination of caseid and service code. <p/>
   *
   * @param idCase
   * @return
   */
  List<CaseBudgetLimit> findCaseBudgetLimitListByIdCase(int idCase);

  /**
   * @param cdSvcCode1
   * @param cdSvcCode2
   * @param cdSvcCode0
   * @param idSvcAuthDtl
   * @return
   */
  List<CaseBudgetLimit> findCaseBudgetLimitBySmileInvoiceParams(String cdSvcCode1, String cdSvcCode2,
                                                                String cdSvcCode0, int idSvcAuthDtl);
  
  /**
   * Increments amtSpent and decrements amtRemain by the given addAmtSpent for all
   * CaseBudgetLimit records associated to the idSvcAuthDtl using SvcAuthEventLink.
   * 
   * @param idSvcAuthDtl
   * @param cdSvcCode
   * @param addAmtSpent
   * @return
   */
  int updateCaseBudgetLimitByIdSvcAuthDtl(int idSvcAuthDtl, String cdSvcCode, double addAmtSpent);

  /**
   * Increments amtSpent and decrements amtBalance by the given addAmtSpent for all
   * CaseBudgetLimit records associated to the idSvcAuthDtl using SvcAuthEventLink.
   * 
   * @param idSvcAuthDtl
   * @param cdSvcCode
   * @param addAmtSpent
   * @return
   */
  int updateCaseBudgetLimitByIdSvcAuthDtlForTermDate(int idSvcAuthDtl, String cdSvcCode, double addAmtSpent);

  /**
   * Inserts or updates a row in Case Budget Limit table. <p/>
   *
   * @param csBLmt
   * @return
   */
  void saveCaseBudgetLimit(CaseBudgetLimit csBLmt);
}