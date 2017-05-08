/**
 * Created on Aug 11, 2006 at 10:05:30 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

public interface DynamicPersonDAO {

  public static final int VICTIM_TYPE = 1;
  public static final int PERPETRATOR_TYPE = 2;
  public static final int OTHER_PRN_TYPE = 3;
  public static final int REPORTER_TYPE = 4;
  public static final int COLLATERAL_TYPE = 5;

  /**
   * @param idStage
   * @param type
   * @param pageNbr
   * @param pageSize
   * @return
   */
  public PaginatedHibernateList<Map> findPersonInfoByTypeAndIdStage(int idStage, int type, int pageNbr, int pageSize);
}
