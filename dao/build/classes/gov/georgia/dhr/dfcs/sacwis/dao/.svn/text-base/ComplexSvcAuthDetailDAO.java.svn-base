package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;

public interface ComplexSvcAuthDetailDAO {
  /**
   * Generate next value for primary key if insert and call SvcAuthDetailDAO.saveSvcAuthDetail()
   * This is ecause table SVC_AUTH_DETAIL does not provide trigger to generate sequence next value
   * and will allow primakey to be 0
   *
   * @param SvcAuthDetail
   * @return int value of next sequence value
   */
  public void saveSvcAuthDetail(SvcAuthDetail svcAuthDetail);

}
