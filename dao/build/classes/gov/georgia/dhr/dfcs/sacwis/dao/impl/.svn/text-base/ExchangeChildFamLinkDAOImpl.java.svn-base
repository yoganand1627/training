package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildFamLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.ExchangeChildFamLink;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * This is the DAO that contains the SQL to save and retrieve Exchange Child Family Link records to and from the
 * Database. <p/> <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  09/02/08   mchillman  STGAP00010004: Initial code
 *  04/08/09   mxpatel    STGAP00012983: wrote required methods for the defect      
 *  05/21/09   mchillman  STGAP00012047 deletion of linked records          
 *  12/18/09   arege      SMS#37206 Modified the findExchangeChildFamLinksIdPersonByResourceEventId() so that it finds linked children for given eventid and 
 *                        IND_LINK_CURRENT column set to Y, i.e this will give list of children in the Family is Now Considering section.
 * </pre>
 */

public class ExchangeChildFamLinkDAOImpl extends BaseDAOImpl implements ExchangeChildFamLinkDAO {

  @SuppressWarnings( { "unchecked" })
  public List<ExchangeChildFamLink> findExchangeChildFamLinksByResourceEventIdAndCurrentInd(int idResourceEvent,
                                                                                            String indLinkCurrent) {
    Query query = getSession().createQuery(
                                           " from ExchangeChildFamLink where eventByIdEventHomeRegistration = :idResourceEvent "
                                                           + " and indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idResourceEvent", idResourceEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (List<ExchangeChildFamLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<ExchangeChildFamLink> findExchangeChildFamLinksByChildEventIdAndCurrentInd(int idChildEvent,
                                                                                         String indLinkCurrent) {
    Query query = getSession().createQuery(
                                           " from ExchangeChildFamLink where eventByIdEventChildRegistration = :idChildEvent "
                                                           + " and indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idChildEvent", idChildEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (List<ExchangeChildFamLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public ExchangeChildFamLink findExchangeChildFamLinksByChildEventIdByHomeEventIdBYCurrentInd(int idChildEvent,
                                                                                               int idHomeEvent,
                                                                                               String indLinkCurrent) {
    Query query = getSession().createQuery(
                                           " from ExchangeChildFamLink where eventByIdEventChildRegistration = :idChildEvent "
                                                           + " and eventByIdEventHomeRegistration = :idHomeEvent "
                                                           + " and indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idChildEvent", idChildEvent);
    query.setInteger("idHomeEvent", idHomeEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (ExchangeChildFamLink) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public int updateExchangeHomeCdNonSelectionRsnIdExchangeChildFamLin(int idExchangeChildFamLink,
                                                                      String cdNonSelectionRsn, String indLinkCurrent) {
    Query query = getSession().createQuery(
                                           "update ExchangeChildFamLink " + " set indLinkCurrent = :indLinkCurrent,  "
                                                           + " cdNonSelectionRsn = :cdNonSelectionRsn "
                                                           + " where idExchangeChildFamLink = :idExchangeChildFamLink");
    query.setInteger("idExchangeChildFamLink", idExchangeChildFamLink);
    query.setString("cdNonSelectionRsn", cdNonSelectionRsn);
    query.setString("indLinkCurrent", indLinkCurrent);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public void saveExchangeChildFamLink(ExchangeChildFamLink exchangeChildFamLink) {
    getSession().saveOrUpdate(exchangeChildFamLink);
  }

  public Long countExcChildFamLinksByChildRegEventIdAndCurInd(int idChildRegEvent, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + " from ExchangeChildFamLink "
                                                           + " where eventByIdEventChildRegistration.idEvent = :idChildRegEvent "
                                                           + " and indLinkCurrent = :indLinkCurrent");
    query.setInteger("idChildRegEvent", idChildRegEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (Long) query.uniqueResult();
  }

  public Long countExcChildFamLinksByHomeRegEventIdAndCurInd(int idHomeRegEvent, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + " from ExchangeChildFamLink "
                                                           + " where eventByIdEventHomeRegistration.idEvent = :idHomeRegEvent "
                                                           + " and indLinkCurrent = :indLinkCurrent");
    query.setInteger("idHomeRegEvent", idHomeRegEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (Long) query.uniqueResult();
  }

  public Date findMinDtOutByHomeRegEventIdAndCurInd(int idHomeEvent, String indCurLink) {
    Query query = getSession()
                              .createQuery(
                                           "select min(ecl.dtOut) "
                                                           + " from ExchangeChildFamLink ecl"
                                                           + " where ecl.eventByIdEventHomeRegistration.idEvent = :idHomeEvent "
                                                           + " and ecl.indLinkCurrent = :indLinkCurrent");
    query.setInteger("idHomeEvent", idHomeEvent);
    query.setString("indLinkCurrent", indCurLink);
    return (Date) query.uniqueResult();

  }

  public Date findMinDtOutByChildRegEventIdAndCurInd(int idChildEvent, String indCurLink) {
    Query query = getSession()
                              .createQuery(
                                           "select min(ecl.dtOut) "
                                                           + " from ExchangeChildFamLink ecl"
                                                           + " where ecl.eventByIdEventChildRegistration.idEvent = :idChildRegEvent "
                                                           + " and ecl.indLinkCurrent = :indLinkCurrent");
    query.setInteger("idChildRegEvent", idChildEvent);
    query.setString("indLinkCurrent", indCurLink);
    return (Date) query.uniqueResult();

  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findExcChildFamLinksInfoByChildRegEventIdAndCurInd(int idChildRegEvent, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(  eh.capsResource.idResource as idResource, "
                                                           + " eh.capsResource.nmResource as nmResource, "
                                                           + " eh.capsResource.cdRsrcCnty as cdRsrcCnty, "
                                                           + " eh.event.idEvent as idHomeEvent, "
                                                           + " ecl.cdNonAvailCode as cdNonAvailCode, "
                                                           + " ecl.dtLastUpdate as dtLastUpdate, "
                                                           + " ecl.cdNonSelectionRsn as cdNonSelectionRsn, "
                                                           + " ecl.dtOut as dtOut) "
                                                           + " from ExchangeChildFamLink ecl, ExchangeHome eh "
                                                           + " where ecl.eventByIdEventHomeRegistration.idEvent = eh.idEvent "
                                                           + " and ecl.eventByIdEventChildRegistration.idEvent = :idChildRegEvent "
                                                           + " and ecl.indLinkCurrent = :indLinkCurrent");
    query.setInteger("idChildRegEvent", idChildRegEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findExchangeChildFamLinksIdPersonByResourceEventId(int idResourceEvent, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select distinct(exc.idPerson) "
                                                           + " from ExchangeChildFamLink ecl, ExchangeChild exc "
                                                           + " where ecl.eventByIdEventHomeRegistration.idEvent = :idResourceEvent "
                                                           + " and ecl.eventByIdEventChildRegistration.idEvent = exc.idEvent "
                                                           + " and ecl.indLinkCurrent = :indLinkCurrent");
    query.setInteger("idResourceEvent", idResourceEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (List<Integer>) query.list();
  }

  public String findCdNonAvlCodeByIdExchangeChildFamLink(int idExchangeChildFamLink, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.cdNonAvailCode "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where ecf.idExchangeChildFamLink = :idExchangeChildFamLink "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idExchangeChildFamLink", idExchangeChildFamLink);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (String) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findListIdExchangeChildFamilyLinkByIdEventHomeReg(int idEventHomeReg, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.idExchangeChildFamLink "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where  ecf.eventByIdEventHomeRegistration.idEvent = :idEventHomeReg  "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idEventHomeReg", idEventHomeReg);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (List<Integer>) query.list();
  }

  public Integer findIdExchangeChildFamilyLinkByIdEventHomeReg(int idEventHomeReg, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.idExchangeChildFamLink "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where  ecf.eventByIdEventHomeRegistration.idEvent = :idEventHomeReg  "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idEventHomeReg", idEventHomeReg);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (Integer) query.uniqueResult();
  }

  public int updateExchangeHomeCdNonAvlRsnByIdExchangeChildFamLink(int idEvent, String cdNonAvailability) {
    Query query = getSession().createQuery(
                                           " update ExchangeChildFamLink ecf "
                                                           + " set ecf.cdNonAvailCode = :cdNonAvailability "
                                                           + " where ecf.idExchangeChildFamLink = :idEvent ");
    query.setInteger("idEvent", idEvent);
    query.setString("cdNonAvailability", cdNonAvailability);
    return query.executeUpdate();
  }
  
  public int deleteExchangeChildFamLink(int idEvent) {
    Query query = getSession().createQuery(
                                           "delete from ExchangeChildFamLink "
                                                           + " where idExchangeChildFamLink = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public Long countIdHomeRegEventByIdEventChildReg(int idEventChildReg, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select count(*) "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where ecf.eventByIdEventChildRegistration = :idEventChildReg "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idEventChildReg", idEventChildReg);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Integer> findIdChildRegEventByIdHomeReg(int idEventHomeReg, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.eventByIdEventChildRegistration.idEvent "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where ecf.eventByIdEventHomeRegistration.idEvent = :idEventHomeReg "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idEventHomeReg", idEventHomeReg);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (List<Integer>) query.list();
  }

  public Integer findIdExchangeChildFamilyLinkByIdEventChildReg(int idEventChildReg, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.idExchangeChildFamLink "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where  ecf.eventByIdEventChildRegistration.idEvent = :idEventChildReg  "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idEventChildReg", idEventChildReg);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (Integer) query.uniqueResult();
  }

  public Integer findIdEventExchangeChildReg(int idExchangeChildFamLink) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.eventByIdEventChildRegistration.idEvent "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where ecf.idExchangeChildFamLink = :idExchangeChildFamLink ");
    query.setInteger("idExchangeChildFamLink", idExchangeChildFamLink);
    return (Integer) query.uniqueResult();
  }

  public Integer findIdHomeRegEvenbtByIdEventChildReg(int idEventChildReg, String indLinkCurrent) {
    Query query = getSession()
                              .createQuery(
                                           " select ecf.eventByIdEventHomeRegistration.idEvent "
                                                           + " from ExchangeChildFamLink ecf "
                                                           + " where ecf.eventByIdEventChildRegistration = :idEventChildReg "
                                                           + " and ecf.indLinkCurrent = :indLinkCurrent ");
    query.setInteger("idEventChildReg", idEventChildReg);
    query.setString("indLinkCurrent", indLinkCurrent);
    return (Integer) query.uniqueResult();
  }

}
