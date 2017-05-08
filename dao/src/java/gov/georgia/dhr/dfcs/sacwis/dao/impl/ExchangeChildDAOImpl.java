package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChild;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;

import org.hibernate.Query;
/**
 * This is the DAO that contains the SQL to save and retrieve Exchange Child records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  09/02/08   mchillman  STGAP00010004: Initial code  
 *  03/02/09   mxpatel    STGAP00012533: added findIdEventByIdChild method to retrieve idEvent. 
 *  04/08/09   mxpatel    STGAP00012983: added updateExchangeChildCdNonAvlCdByIdExchangeChildFamLink to update the NonAvailabilityCode of
 *                        Exchange Child.     
 *  12/03/09   arege      SMS#37215 Added to find Earliest Exchange Child that was complete (in COMP status) in the given stage.
 * </pre>
 */
public class ExchangeChildDAOImpl extends BaseDAOImpl implements ExchangeChildDAO {
  public Long countExchangeChildByIdPerson(int idPerson){
    Query query = getSession().createQuery("select count(idEvent) from ExchangeChild "
                                           + " where idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (Long) firstResult(query);
  }
  public Integer findIdPersonByEventId(int idEvent) {
    Query query = getSession().createQuery("select idPerson from ExchangeChild "
                                                           + " where idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (Integer) firstResult(query);
  }
  
 
  public ExchangeChild findMostRecentExchangeChildRecordByIdPerson(int idPerson){
	  Query query = getSession().createQuery("from ExchangeChild ec where ec.idPerson = :idPerson "+
			  								 "order by ec.event.dtEventOccurred desc");
	  
	  query.setInteger("idPerson", idPerson);
	  return (ExchangeChild) firstResult(query);
  }
  
  public ExchangeChild findExchangeChildByEventId(int idEvent) {
    Query query = getSession().createQuery(" from ExchangeChild ec"
                                           + " join fetch ec.event " 
                                                           + " where ec.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (ExchangeChild) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public int updateExchangeChildCdNonAvailStatus(int idEvent, String cdNonAvailStatus) {

    Query query = getSession().createQuery("update ExchangeChild "
                                           + "  set cdNonAvailStatus  = :cdNonAvailStatus "
                                           + "  where idEvent = :idEvent");
    
    query.setString("cdNonAvailStatus", cdNonAvailStatus);
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
  }
  
  @SuppressWarnings( { "unchecked" }) 
  public int updateExchangeChildDateOut(int idEvent) {
    Query query = getSession().createQuery("update ExchangeChild "
                                           + " set dtOut  = (select min(dtOut) " 
                                           + " from ExchangeChildFamLink where eventByIdEventChildRegistration = :idEvent"
                                           + " and indLinkCurrent = '" + ArchitectureConstants.Y + "') "
                                           + " where idEvent = :idEvent");
    
    query.setInteger("idEvent", idEvent);

    return query.executeUpdate();
    
  }
  
  public String findExchangeChildNonAvailCodeByIdEvent(int idEvent) {
    Query query = getSession()
                              .createQuery("select cdNonAvailStatus from ExchangeChild " + " where idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (String) firstResult(query);
  }
  
  public int saveExchangeChild(ExchangeChild excChild) {
    getSession().saveOrUpdate(excChild);
    return excChild.getIdEvent();
  }
  
  // #STGAP00012533
  public Integer findIdEventByIdChild(Integer idChild) {
    Query query = getSession().createQuery(
                                           " select ec.idEvent " + " from ExchangeChild ec "
                                                           + " where ec.idPerson = :idChild ");
    query.setInteger("idChild", idChild);
    return (Integer) firstResult(query);

  }
  
//#STGAP00012983 - update the NAC when NAC on EHD is "selected"
  public int updateExchangeChildCdNonAvlCdByIdExchangeChildFamLink(int idEvent, String cdNonAvailability) {
    Query query = getSession().createQuery(
                                           " update ExchangeChild ec " 
                                           + " set ec.cdNonAvailStatus = :cdNonAvailability "
                                           + " where ec.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    query.setString("cdNonAvailability", cdNonAvailability);
    return query.executeUpdate();
  }
  
  //SMS#37215 Added to find Earliest Exchange Child that was complete (in COMP status) in the given stage.
  public ExchangeChild findEarliestExchangeChildByIdStageEventStatus(int idStage, Collection<String> cdEventStatuses) {
    Query query = getSession().createQuery(
                                           "from ExchangeChild ec "
                                                           + " where ec.event.cdEventStatus in (:cdEventStatuses )"
                                                           + " and ec.event.stage.idStage = :idStage  "
                                                           + " order by ec.idEvent asc");
    query.setInteger("idStage", idStage);
    query.setParameterList("cdEventStatuses", cdEventStatuses);
    return (ExchangeChild) firstResult(query);
  }
  
}
