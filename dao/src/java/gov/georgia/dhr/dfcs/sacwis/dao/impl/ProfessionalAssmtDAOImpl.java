package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ProfessionalAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ProfessionalAssmt;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------
 *   02/24/2011   hnguyen                  Added change history.
 *   02/24/2011   hnguyen                  SMS#97850: MR-075 Added method findProfessionalAssmtByIdPersonByCdProfAssmtApptRsn.
 *   03/27/2011   hnguyen                  SMS#97850: MR-075 Added method findProfessionalAssmtByIdPersonByCdProfAssmtApptRsns.
 *   
 * </pre>
 * 
 */

public class ProfessionalAssmtDAOImpl extends BaseDAOImpl implements ProfessionalAssmtDAO {
  public ProfessionalAssmt findProfessionalAssmtByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from ProfessionalAssmt " +
                                           "where idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (ProfessionalAssmt) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public ProfessionalAssmt findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsns(int idCase, int idPerson,
                                                                                Collection<String> cdProfAssmtApptRsns) {
    Query query = getSession().createQuery("  from ProfessionalAssmt pa " + 
                                           " where pa.cdProfAssmtApptRsn in (:cdProfAssmtApptRsns) " + 
                                           " and pa.personByIdPersonPrincipal = :idPerson " + 
                                           " and pa.capsCase.idCase = :idCase " +
                                           " order by pa.dtProfAssmtAppt desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdProfAssmtApptRsns", cdProfAssmtApptRsns);
    return (ProfessionalAssmt) firstResult(query);
  }
  @SuppressWarnings({"unchecked"})
  public List<ProfessionalAssmt> findLastProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsnsList(int idCase, int idPerson,
                                                                                Collection<String> cdProfAssmtApptRsns) {
    Query query = getSession().createQuery("  from ProfessionalAssmt pa " + 
                                           " where pa.cdProfAssmtApptRsn in (:cdProfAssmtApptRsns) " + 
                                           " and pa.personByIdPersonPrincipal = :idPerson " + 
                                           " and pa.capsCase.idCase = :idCase " +
                                           " order by pa.dtProfAssmtAppt desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdProfAssmtApptRsns", cdProfAssmtApptRsns);
    return (List<ProfessionalAssmt>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public ProfessionalAssmt findProfessionalAssmtByIdPersonByIdCaseByCdProfAssmtApptRsn(int idCase, int idPerson,
                                                                                String cdProfAssmtApptRsn) {
    Query query = getSession().createQuery(" from ProfessionalAssmt pa " +
                                           " where pa.cdProfAssmtApptRsn = :cdProfAssmtApptRsn " +
                                           " and pa.personByIdPersonPrincipal = :idPerson " +
                                           " and pa.capsCase.idCase = :idCase " +
                                           " order by pa.dtProfAssmtAppt desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdProfAssmtApptRsn", cdProfAssmtApptRsn);
    return (ProfessionalAssmt) firstResult( query );
  }

  @SuppressWarnings({"unchecked"})
  public ProfessionalAssmt findProfessionalAssmtByIdPersonByCdProfAssmtApptRsn(int idPerson,
                                                                                String cdProfAssmtApptRsn) {
    Query query = getSession().createQuery(" from ProfessionalAssmt pa " +
                                           " where pa.cdProfAssmtApptRsn = :cdProfAssmtApptRsn " +
                                           " and pa.personByIdPersonPrincipal = :idPerson " +
                                           " and pa.dtProfAssmtAppt is not null " +
                                           " order by pa.dtProfAssmtAppt desc");
    query.setInteger("idPerson", idPerson);
    query.setString("cdProfAssmtApptRsn", cdProfAssmtApptRsn);
    return (ProfessionalAssmt) firstResult( query );
  }

  @SuppressWarnings({"unchecked"})
  public ProfessionalAssmt findProfessionalAssmtByIdPersonByCdProfAssmtApptRsns(int idPerson,
                                                                                Collection<String> cdProfAssmtApptRsns) {
    Query query = getSession().createQuery(" from ProfessionalAssmt pa " +
                                           " where pa.cdProfAssmtApptRsn in ( :cdProfAssmtApptRsns ) " +
                                           " and pa.personByIdPersonPrincipal = :idPerson " +
                                           " and pa.dtProfAssmtAppt is not null " +
                                           " order by pa.dtProfAssmtAppt desc");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdProfAssmtApptRsns", cdProfAssmtApptRsns);
    return (ProfessionalAssmt) firstResult( query );
  }

  @SuppressWarnings( { "unchecked" })
  public List<ProfessionalAssmt> findProfessionalAssmtByIdCaseByIdPersonPrincipal(int idCase, int idPerson) {
    Query query = getSession().createQuery(" select pa " +
                                           " from ProfessionalAssmt pa, EventPersonLink epl " +
                                           " where pa.event.idEvent = epl.event.idEvent " +
                                           " and epl.capsCase.idCase = :idCase " +
                                           " and pa.personByIdPersonPrincipal.idPerson  = :idPerson ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (List<ProfessionalAssmt>) query.list();
  }

  public void saveProfessionalAssmt(ProfessionalAssmt professionalAssmt) {
    getSession().saveOrUpdate(professionalAssmt);
  }

}
