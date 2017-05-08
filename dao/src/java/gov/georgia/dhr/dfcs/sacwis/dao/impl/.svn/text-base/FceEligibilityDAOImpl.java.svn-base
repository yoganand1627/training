package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;

import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------------------------------
 *   09/30/2011  hjbaptiste        STGAP00017011: MR-092 Fostering Connections. Added findIdEligibilityForLatestInitialAmendedApplication                                                                                                                                                                                           
 *   10/17/2011  hjbaptiste        STGAP00017237: MR-092 Fostering Connections. Added findIdFceEligibilityByIdEligibility   
 *   03/01/2012  arege             STGAP00017972: Restored the method as it was originally written findIdEligibilityForLatestInitialAmendedApplication 
 *                                 Added new method to get latest eligibility event for latest completed initial or amended application
 *   03/08/2012  arege             STGAP00017972: Removed the new method findLatestIdEligibilityForLatestInitialAmendedApplication as the design changed this method no longer needed.
 *                                                                                                                                                                                        
 */


public class FceEligibilityDAOImpl extends BaseDAOImpl implements FceEligibilityDAO {
  @SuppressWarnings({"unchecked"})
  public Object[] findIdEligibilityForLatestInitialAmendedApplication(int idStage) {
    SQLQuery query = getSession().createSQLQuery(" select id_eligibility_event as idEligibilityEvent, id_fce_eligibility as idFceEligibility from " +
                                           " (select fe.id_eligibility_event as id_eligibility_event, " +
                                           "         fe.id_fce_eligibility as id_fce_eligibility,  " +
                                           "         fa.dt_application_complete as date_complete " + 
                                           "  from fce_application fa, fce_eligibility fe " +
                                           "  where fa.id_stage = :idStage and fa.dt_application_complete is not null " +
                                           "    and fa.cd_application = 'A' and fa.id_fce_application = fe.id_fce_application " +
                                           "    and (fe.id_eligibility_event is not null " +
                                           "    and fe.id_eligibility_event > 0) order by date_complete desc)");

    query.setInteger("idStage", idStage);
    query.addScalar("idEligibilityEvent", Hibernate.INTEGER);
    query.addScalar("idFceEligibility", Hibernate.INTEGER);
    return (Object[]) firstResult(query);
  }

  // Used by the AA Funding Summary Retrieve service to find the earliest FCE Eligibility record 
  // tied to an Application that generated an Eligibility Summary based on the Eligibility Summary Event ID
  public FceEligibility findIdFceEligibilityByIdEligibility(int idEligibilityEvent) {
    Query query = getSession().createQuery(" from FceEligibility fe1, FceEligibility fe2 " +
                                           " where fe2.event.idEligEvent = :idEligibilityEvent " +
                                           " and fe1.fceApplication.idFceApplication =  fe2.fceApplication.idFceApplication " +
                                           " and fe1.idFceEligibility <> fe2.idFceEligibility " +
                                           " order by fe1.idFceEligibility asc");

    query.setLong("idEligibilityEvent", idEligibilityEvent);
    return (FceEligibility) firstResult(query);
  }
  
  
  public int updateFceEligibilityIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage) {
    Query query = getSession().createQuery(" update FceEligibility e" +
                                           "    set e.personByIdPerson.idPerson = :idPersMergeForward " +
                                           "  where e.personByIdPerson.idPerson = :idPersMergeClosed " +
                                           "    and e.stage.idStage = :idStage");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public void saveFceEligibility(FceEligibility fceEligibility) {
    getSession().saveOrUpdate(fceEligibility);
  }

  public FceEligibility findFceEligibilityByIdFceEligibility(long idFceEligibility) {
    Query query = getSession().createQuery(" from FceEligibility fe " +
                                           "where fe.idFceEligibility = :idFceEligibility");

    query.setLong("idFceEligibility", idFceEligibility);
    return (FceEligibility) query.uniqueResult();
  }

  public FceEligibility findFceEligibilityByIdEligibilityEvent(long idEligibilityEvent) {
    Query query = getSession().createQuery(" from FceEligibility fce " +
                                           "where fce.event.idEvent = :idEligibilityEvent");

    query.setLong("idEligibilityEvent", idEligibilityEvent);
    return (FceEligibility) query.uniqueResult();
  }

  public void updateFceEligibilityByCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship) {

    Query query = getSession().createQuery(" update FceEligibility " +
                                           "    set cdPersonCitizenship = :cdPersonCitizenship" +
                                           "  where idFceEligibility = :idFceEligibility");

    query.setString("cdPersonCitizenship", cdPersonCitizenship);
    query.setLong("idFceEligibility", idFceEligibility);
    query.executeUpdate();
  }

  public int updateFceEligibilityByIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered) {
    Query query = getSession().createQuery(" update FceEligibility " +
                                           "    set indChildSupportOrdered = :indChildSupportOrdered" +
                                           "  where idFceEligibility = :idFceEligibility");
    query.setString("indChildSupportOrdered", indChildSupportOrdered);
    query.setLong("idFceEligibility", idFceEligibility);
    return query.executeUpdate();

  }

  public Integer findFceEligibilityByIdFceApplication(long idFceApplication) {
    Query query = getSession().createQuery("select a.fceEligibility.idFceEligibility " +
                                           "  from FceApplication a " +
                                           " where a.idFceApplication = :idFceApplication");
    query.setLong("idFceApplication", idFceApplication);
    return (Integer) query.uniqueResult();
  }

  public int updateFceEligibilityByCdBlocChild(long idFceEligibility, String cdBlocChild) {
    Query query = getSession().createQuery(" update FceEligibility e " +
                                           "    set e.cdBlocChild = :cdBlocChild" +
                                           "  where e.idFceEligibility = :idFceEligibility");

    query.setString("cdBlocChild", cdBlocChild);
    query.setLong("idFceEligibility", idFceEligibility);
    return query.executeUpdate();
  }

  public int updateFceEligibilityByCdBlocChild(long idFceEligibility, String cdBlocChild, double amtSsi) {
    Query query = getSession().createQuery(" update FceEligibility e " +
                                           "    set e.cdBlocChild = :cdBlocChild, " +
                                           "        e.amtSsi = :amtSsi " +
                                           "  where e.idFceEligibility = :idFceEligibility");
    query.setDouble("amtSsi", amtSsi);
    query.setString("cdBlocChild", cdBlocChild);
    query.setLong("idFceEligibility", idFceEligibility);
    return query.executeUpdate();
  }
  
  public int updateFceEligibilityByIndMeetsDpOrNotEs(long idFceEligibility, String indMeetsDpOrNotEs) {

    Query query = getSession().createQuery(" update FceEligibility " +
                                           "    set indMeetsDpOrNotEs = :indMeetsDpOrNotEs" +
                                           "  where idFceEligibility = :idFceEligibility");

    query.setString("indMeetsDpOrNotEs", indMeetsDpOrNotEs);
    query.setLong("idFceEligibility", idFceEligibility);
    return query.executeUpdate();
  }
  
  public int updateFceEligibilityByNbrCertifiedGroup(long idFceEligibility, long nbrCertifiedGroup) {

    Query query = getSession().createQuery(" update FceEligibility " +
                                           "    set nbrCertifiedGroup = :nbrCertifiedGroup" +
                                           "  where idFceEligibility = :idFceEligibility");

    query.setLong("nbrCertifiedGroup", nbrCertifiedGroup);
    query.setLong("idFceEligibility", idFceEligibility);
    return query.executeUpdate();
  }
  
  public int updateFceEligibilityByIndMeetsDpOrNotSystem(long idFceEligibility, String indMeetsDpOrNotSystem) {

    Query query = getSession().createQuery(" update FceEligibility " +
                                           "    set indMeetsDpOrNotSystem = :indMeetsDpOrNotSystem" +
                                           "  where idFceEligibility = :idFceEligibility");

    query.setString("indMeetsDpOrNotSystem", indMeetsDpOrNotSystem);
    query.setLong("idFceEligibility", idFceEligibility);
    return query.executeUpdate();
  }
 
}
