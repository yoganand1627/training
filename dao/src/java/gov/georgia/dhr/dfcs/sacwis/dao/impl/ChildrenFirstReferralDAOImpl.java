/**
 *  This is the DAO class is used for the Children_First_Referral table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/20/2011 arege    SMS#112531 Added a method to find latest completed (COMP) CFR record for a given person id
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildrenFirstReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral;

/**
 * @author ashwini.rege
 *
 */
public class ChildrenFirstReferralDAOImpl extends BaseDAOImpl implements ChildrenFirstReferralDAO {  

  public ChildrenFirstReferral findChildrenFirstReferralByIdEvent(int idEvent) {
    Query query = getSession()
                              .createQuery(" from  ChildrenFirstReferral cfr " + " where cfr.eventByIdEvent.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (ChildrenFirstReferral) firstResult(query);
  }
  
  public ChildrenFirstReferral findLatestCompChildrenFirstReferralByIdPerson (int idPerson) {
    Query query = getSession()
                              .createQuery(" from  ChildrenFirstReferral cfr  join fetch  cfr.eventByIdEvent e " 
                                           + " where cfr.eventByIdEvent.idEvent = e.idEvent " 
                                           + " and cfr.idChildReferred = :idPerson "
                                           + " and e.cdEventStatus in ( :cdEventStatus ) "   
                                           + " and e.cdEventType = :eventType " 
                                           + " order by e.idEvent desc ");
   query.setInteger("idPerson", idPerson);
   query.setString("cdEventStatus", CodesTables.CEVTSTAT_COMP);
   query.setString("eventType", CodesTables.CEVNTTYP_CFR);                                      
   return (ChildrenFirstReferral) firstResult(query);
  }
  
  public void saveChildrenFirstReferral(ChildrenFirstReferral childrenFirstReferral) {
    getSession().saveOrUpdate(childrenFirstReferral);
  }
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral} object.
   * 
   * @param idEvent
   */
  public int deleteCFR(int idEvent) {
    Query query = getSession().createQuery(
                                           "delete from ChildrenFirstReferral cfr"
                                                           + "       where cfr.eventByIdEvent.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }


}
