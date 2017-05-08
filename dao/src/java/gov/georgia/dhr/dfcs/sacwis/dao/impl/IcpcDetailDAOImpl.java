/**
 *  This is the DAO class is used for the ICPC_DETAIL table
 *  @author ashwini.rege
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.IcpcDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IcpcDetail;

import org.hibernate.Query;

/**
 * 
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  01/24/2012  arege   STGAP00017827: MR-085 Initial Creation
 *  02/06/2012  arege   STGAP00012827: Added comments.
 */
public class IcpcDetailDAOImpl extends BaseDAOImpl implements IcpcDetailDAO {
  
  /**
   * Retrieves ICPC_DETAIL record for a given idEvent
   */
  public IcpcDetail findIcpcDetailByIdEvent(int idEvent) {
    Query query = getSession()
                              .createQuery(" from  IcpcDetail icp " + " where icp.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (IcpcDetail) firstResult(query);
  }
  
  public void saveIcpcDetail(IcpcDetail icpcDetail) {
    getSession().saveOrUpdate(icpcDetail);
  }
  
}
