package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexContractServiceDAO {
  /**
   * Delete CONTRACT_COUNTY and CONTRACT_SERVICE based on this combination (ID_CONTRACT, PERIOD,VERSION) (i.e., delete
   * all LINE_ITEM)
   *
   * @param idContract
   * @param nbrCnverPeriod
   * @param nbrCnverVersion
   * @param dtLastUpdate
   */
  public void deleteContractCountyServiceAndVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion,
                                                    Date dtLastUpdate);
}
