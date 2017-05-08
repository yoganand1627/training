/**
 * This is the DAOImpl class is used for the CHLD_DTH_CAUSE_CBX table
 *   
 * @author ashwini.rege
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  03/22/2010  arege    Added method to delete the CHLD_DTH_CAUSE_CBX record for a given idEvent
 *
 */

package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthCauseCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChldDthCauseCbx;

import java.util.List;

import org.hibernate.Query;

public class ChldDthCauseCbxDAOImpl extends BaseDAOImpl implements ChldDthCauseCbxDAO {

  @SuppressWarnings( { "unchecked" })
  public  List<String> findSavedCausesByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" select cdc.cdCauseDeath " +
    		                           " from ChldDthCauseCbx cdc" +
                                           " where cdc.chldDthNrFtlySeriInj.event.idEvent = :idEvent"); 
    query.setInteger("idEvent", idEvent);
    return  (List<String>) query.list();
  }

  public void saveOrUpdateCausesOfDeath(ChldDthCauseCbx chldDthCauseCbx){
    getSession().saveOrUpdate(chldDthCauseCbx);
  }
  
  public int deleteCauseOfDeath(String cdCauseDeath, int idEvent) {
    Query query = getSession().createSQLQuery("delete from CHLD_DTH_CAUSE_CBX CDC" +
                                           "       where CDC.CD_CAUSE_DEATH = :cdCauseDeath and CDC.ID_CHLD_DEATH_EVENT = :idEvent ");
    query.setParameter("cdCauseDeath", cdCauseDeath);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  public int deleteChldDthCauseCbxByIdEvent(int idEvent) {
    Query query = getSession().createSQLQuery(
                                              "delete from CHLD_DTH_CAUSE_CBX CDC"
                                                              + "       where  CDC.ID_CHLD_DEATH_EVENT = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}
