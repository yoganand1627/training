package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeHomeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeHome;

import org.hibernate.Query;

/**
 * This is the DAO that contains the SQL to save and retrieve ExchangeHome records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  08/20/08   mchillman   STGAP00010004: Initial code  
 *  04/08/09   mxpatel     STGAP00012983: added findCdNonAvlCodeByIdEvent to retrieve NAC of an exchange home
 * </pre>
 */

public class ExchangeHomeDAOImpl extends BaseDAOImpl implements ExchangeHomeDAO {
  
  @SuppressWarnings( { "unchecked" })
  public ExchangeHome findExchangeHomeByEventId(int idEvent) {
    Query query = getSession().createQuery(" from ExchangeHome where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (ExchangeHome) firstResult(query);
  }

  public ExchangeHome findCurrentExchangeHomeRegistrationForIdResource(int idResource) {
	  Query query = getSession().createQuery("select exh from ExchangeHome exh, Event e " 
            	+ " where exh.capsResource.idResource = :idResource "
            	+ "		and e.cdEventType = 'EXH' "
            	+ "     and e.cdEventStatus = 'PROC' "
            	+ " 	and e.idEvent = exh.idEvent "
            	+ " order by e.dtEventOccurred desc"	);
	  
	  query.setInteger("idResource", idResource);
	  return (ExchangeHome) firstResult(query);
  }
	  
  @SuppressWarnings( { "unchecked" })
  public int updateExchangeHomeCdNonAvailStatus(int idEvent, String cdNonAvailStatus) {
    Query query = getSession().createQuery("update ExchangeHome "
                                           + "  set cdNonAvailStatus  = :cdNonAvailStatus "
                                           + "  where idEvent = :idEvent");
    
    query.setString("cdNonAvailStatus", cdNonAvailStatus);
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" }) 
  public int updateExchangeHomeDateOut(int idEvent) {
    Query query = getSession().createQuery("update ExchangeHome "
                                           + " set dtOut  = (select min(dtOut) " 
                                           + " from ExchangeChildFamLink where eventByIdEventHomeRegistration = :idEvent "
                                           + " and indLinkCurrent = '" + ArchitectureConstants.Y + "') "
                                           + " where idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
    
  }
  
  @SuppressWarnings( { "unchecked" })
  public void saveUpdatExchangeHome(ExchangeHome home){
    getSession().saveOrUpdate(home);
  }
  
  public String findCdNonAvlCodeByIdEvent(int idEvent){
    Query query = getSession().createQuery(" select eh.cdNonAvailStatus "
                                           + " from ExchangeHome eh "
                                           + " where eh.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (String) query.uniqueResult();
  }
  
}
