package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.NonComplianceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NonCompliance;
/**
 * This is the DAO that contains the SQL to save and retrieve NonCompliance records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  06/19/08   ssubram   STGAP00006446: Initial code                
 * </pre>
 */
public class NonComplianceDAOImpl extends BaseDAOImpl implements NonComplianceDAO {
  @SuppressWarnings( { "unchecked" })
  public NonCompliance findNonComplianceByIdEventIdCase(int idEvent, int idCase) {
    Query query = getSession().createQuery(
                                           " from NonCompliance a " + " where a.event.idEvent = :idEvent "
                                                           + " and a.capsCase.idCase = :idCase "
                                                           + " order by a.dtLastUpdate desc ");
    query.setInteger("idEvent", idEvent);
    query.setInteger("idCase", idCase);
    return (NonCompliance) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public NonCompliance findNonComplianceById(int idNonCompliance) {
    Query query = getSession().createQuery(
                                           " from NonCompliance a " + " where a.idNonCompliance = :idNonCompliance "
                                                           + " order by a.dtLastUpdate desc ");
    query.setInteger("idNonCompliance", idNonCompliance);
    return (NonCompliance) firstResult(query);
  }

  public long countTotalNonComplianceByIdCaseCdNonCompliance(int idCase, String cdNonCompliance) {
    Query query = getSession().createQuery(
                                           " Select count(*) from NonCompliance nc "
                                                           + " where nc.capsCase.idCase = :idCase "
                                                           + " and nc.cdNonCompliance = :cdNonCompliance ");
    query.setInteger("idCase", idCase);
    query.setString("cdNonCompliance", cdNonCompliance);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public int saveNonComplianceReturnId(NonCompliance nonCompliance) {
    getSession().saveOrUpdate(nonCompliance);
    return nonCompliance.getIdNonCompliance();
  }

}
