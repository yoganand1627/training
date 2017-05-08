/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.financials;

import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthUasEntCode;

import java.util.List;

public interface SvcAuthUasEntCodeDAO {
  /**
   * find all ids of service auth header
   * @return
   */
  public List<Integer> findIdSvcAuthUasEntCode();
  /**
   * 
   * @param cdEnt
   * @return
   */
  public List<String> findCdUasByCdEnt(String cdEnt);
  /**
   * 
   * @param cdUas
   * @param cdEnt
   * @return
   */
  public int deleteSvcAuthUasEntCodeByCdUasCdEnt(String cdUas, String cdEnt);
  /**
   * find all service headers on the table
   * @return
   */
  public List<String> findSvcAuthHeaderCodes();
  /**
   * save or update to the table that contains service auth header
   * @param saHeader
   * @return
   */
  public int saveSvcAuthUasEntCode(SvcAuthUasEntCode saHeader);

}
