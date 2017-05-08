package gov.georgia.dhr.dfcs.sacwis.dao.impl;

/**
 * This DAO contains sqls that save data to the CodesTablesHistory table in the database <p/>
 * 
 * <pre>
 *    Change History:
 *    Date         User              Description
 *    ----------     ------------    --------------------------------------------------
 *    07/18/2008     vdevarakonda    Initial class creation           
 * </pre>
 */

import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CodesTablesHistory;

public class CodesTablesHistoryDAOImpl extends BaseDAOImpl implements CodesTablesHistoryDAO {
  @SuppressWarnings( { "unchecked" })
  public void saveCodeDetail(CodesTablesHistory codesTableHistory) {
    getSession().saveOrUpdate(codesTableHistory);
  }
}