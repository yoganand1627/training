/**
 *  This is the DAO class is used for the CHLD_DTH_NR_FLTY_SERI_INJ table
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  03/22/2010  arege    Added method to delete the Child Death Form record
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthNrFltySeriInjDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChldDthNrFltySeriInj;
import gov.georgia.dhr.dfcs.sacwis.db.ChildDeathNarr;
/**
 * @author ashwini.rege
 *
 */
public class ChldDthNrFltySeriInjDAOImpl extends BaseDAOImpl implements ChldDthNrFltySeriInjDAO {

  public ChldDthNrFltySeriInj findChldDthNrFltySeriInjByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           " from  ChldDthNrFltySeriInj cdnf "
                                                           + " where cdnf.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (ChldDthNrFltySeriInj) firstResult(query);
  }

  public void saveChldDthNrFltySeriInj(ChldDthNrFltySeriInj chldDthNrFltySeriInj) {
    getSession().saveOrUpdate(chldDthNrFltySeriInj);
  }
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ChldDthNrFltySeriInj} object.
   * 
   * @param idEvent
   */
  public int deleteCNS(int idEvent) {
    Query query = getSession().createQuery(
                                           "delete from ChldDthNrFltySeriInj cdnf"
                                                           + "       where cdnf.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  /**
   * Deletes a record from Child_Death_Narr table based on the passed idEvent.
   */
  public int deleteCNSForm(int idEvent){
    Query query = getSession().createSQLQuery(
                                           "delete from Child_Death_Narr cdn"
                                                           + "  where cdn.id_event = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
}
