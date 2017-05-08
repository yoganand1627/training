package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CnsrvtrshpRemovalDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CnsrvtrshpRemoval;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

/**
 *  
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  10/27/2008  arege     STGAP00006284 - Added findDtRemovalByIdPersonByIdCase()
 *                        to reflect correct Removal Date on the Initial Medicaid
 *                        Application. 
 *  03/19/2009  bgehlot   STGAP00012833 - Added new method findLatestCnsrvtrshpRemovalDatetByIdCase for Case Review Page
 *  11/09/2010  htvo      SMS#81140 - MR-074 - AFCARS: Added new method findDtRemovalByIdPersonIdCaseByDate
 *  09/12/2011  arege     STGAP00017062: Added new method to Update CnvrvtrshpRemoval id_victim field with the forward person id.
 * </pre>
 */

public class CnsrvtrshpRemovalDAOImpl extends BaseDAOImpl implements CnsrvtrshpRemovalDAO {
  public CnsrvtrshpRemoval findCnsrvtrshpRemoval(int idRemovalEvent) {
    Query query = getSession().createQuery(
                                           " from  CnsrvtrshpRemoval cr "
                                                           + " where cr.idRemovalEvent = :idRemovalEvent ");

    query.setInteger("idRemovalEvent", idRemovalEvent);
    return (CnsrvtrshpRemoval) firstResult(query);
  }

  public void saveCnsrvtrshpRemoval(CnsrvtrshpRemoval cnsrvtrshpRemoval) {
    getSession().saveOrUpdate(cnsrvtrshpRemoval);
  }

  public void deleteCnsrvtrshpRemoval(CnsrvtrshpRemoval cnsrvtrshpRemoval) {
    getSession().delete(cnsrvtrshpRemoval);
  }

  public Date findEarliestCurrentRemovalDate(int idCase) {
    Query query = getSession().createSQLQuery(
                                              "SELECT MIN(dt_removal) "
                                                              + "FROM (SELECT id_victim,MAX(dt_removal) dt_removal "
                                                              + " FROM CNSRVTRSHP_REMOVAL "
                                                              + "  WHERE id_case= :idCase "
                                                              + "  AND dt_removal IS NOT NULL "
                                                              + "  AND dt_removal <> :maxDate "
                                                              + "  GROUP BY id_victim) ");
    query.setInteger("idCase", idCase);
    query.setDate("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Date) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<CnsrvtrshpRemoval> findCnsrvtrshpRemovalLatestByCaseAndByIdVictim(int idCase, int idVictim) {

    Query query = getSession().createQuery(
                                           " from  CnsrvtrshpRemoval cr " + "  WHERE cr.person.idPerson= :idVictim "
                                                           + "  AND cr.capsCase.idCase= :idCase "
                                                           + "  ORDER BY cr.dtRemoval desc");
    /*
     * Query query = getSession().createSQLQuery("SELECT dt_removal " + " FROM CNSRVTRSHP_REMOVAL " + " WHERE id_case=
     * :idCase " + " AND id_victim= :idVictim " + " ORDER BY dt_removal " );
     */
    query.setInteger("idCase", idCase);
    query.setInteger("idVictim", idVictim);
    return (List<CnsrvtrshpRemoval>) query.list();
  }

  public CnsrvtrshpRemoval findCnsrvtrshpLatestRemovalByCaseAndByIdVictim(int idCase, int idVictim) {

    Query query = getSession().createQuery(
                                           " from  CnsrvtrshpRemoval cr " + "  WHERE cr.person.idPerson= :idVictim "
                                                           + "  AND cr.capsCase.idCase= :idCase "
                                                           + "  ORDER BY cr.dtRemoval desc");
    /*
     * Query query = getSession().createSQLQuery("SELECT dt_removal " + " FROM CNSRVTRSHP_REMOVAL " + " WHERE id_case=
     * :idCase " + " AND id_victim= :idVictim " + " ORDER BY dt_removal " );
     */
    query.setInteger("idCase", idCase);
    query.setInteger("idVictim", idVictim);
    return (CnsrvtrshpRemoval) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public CnsrvtrshpRemoval findLatestCnsrvtrshpRemovaltByIdCase(int idCase, Date nullDate) {
    Query query = getSession().createQuery(
                                           " from CnsrvtrshpRemoval cr " + " where cr.capsCase.idCase = :idCase "
                                                           + " and cr.dtRemoval IS NOT NULL "
                                                           + " and cr.dtRemoval < :nullDate "
                                                           + " order by cr.dtRemoval desc");
    query.setInteger("idCase", idCase);
    query.setDate("nullDate", nullDate);
    return (CnsrvtrshpRemoval) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Integer> findOpenRemovalsAfterDate(int idPerson, Date dtEnd) {
    Query query = getSession().createQuery(
                                           " select cr.person.idPerson from CnsrvtrshpRemoval cr, StagePersonLink spl, Stage s " 
                                                           + " where cr.person.idPerson = spl.person.idPerson "
                                                           + " and spl.stage.idStage = s.idStage "
                                                           + " and s.dtStageClose is NULL "
                                                           + " and s.cdStage in ('SUB','ADO')"
                                                           + " and spl.cdStagePersRole = 'PC' "
                                                           + " and cr.dtRemoval < :dtEnd "
                                                           + " and cr.person.idPerson = :idPerson ");
                                                           
    query.setInteger("idPerson", idPerson);
    query.setDate("dtEnd", dtEnd);
    return query.list();
    
  }
  
  // Per STGAP00006284 Added the following method to find dt_removal of a child that 
  // contributed to the opening of the FCC stage for that child in the corresponding 
  // case.
  public Date findDtRemovalByIdPersonByIdCase(int idPerson, int idCase, int idPrevStage) {
    Query query = getSession().createQuery(
                                           "select cr.dtRemoval " + "  from CnsrvtrshpRemoval cr "
                                                           + " where cr.person.idPerson  = :idPerson"
                                                           + "  and cr.capsCase.idCase= :idCase "
                                                           + "and cr.idRemovalEvent in "
                                                           + "(select e.idEvent from Event e"
                                                           + " where e.cdEventType = 'REM'"
                                                           + "  and e.stage.idStage = :idPrevStage )"                                                                                                                
                                                           +"order by cr.dtRemoval desc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setInteger("idPrevStage",idPrevStage);
    return (Date) firstResult(query);
  }
  
  // STGAP00012833: Retrieves latest DtRemoval from Cnsrvtrshp_Removal based on Case and person.
  public Date findLatestCnsrvtrshpRemovalDatetByIdCase(int idCase, int idPerson) {
    Query query = getSession().createQuery( "select cr.dtRemoval from CnsrvtrshpRemoval cr " 
                                                           + " where cr.capsCase.idCase = :idCase "
                                                           + " and cr.person.idPerson = :idPerson "
                                                           + " and cr.dtRemoval IS NOT NULL "
                                                           + " order by cr.dtRemoval desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (Date) firstResult(query);
  }
  
  public Date findDtRemovalByIdPersonIdCaseByDate(int idPerson, int idCase, Date beforeThisDate) {
	  Query query = getSession().createQuery("select cr.dtRemoval from CnsrvtrshpRemoval cr " +
	  		" where cr.capsCase.idCase = :idCase " +
	  		" and cr.person.idPerson = :idPerson " +
	  		" and trunc(cr.dtRemoval) <= trunc(:beforeThisDate) " +
	  		" order by cr.dtRemoval desc " );
	  
	  query.setInteger("idCase", idCase);
	  query.setInteger("idPerson", idPerson);
	  query.setDate("beforeThisDate", beforeThisDate);
	  return (Date) firstResult(query);
  }
  
  public void updateCnrvtrshpRemovalWithForwardPerson(int idPersonForward, int idPersonClosed) {
    Query query = getSession().createQuery(
                    "update CnsrvtrshpRemoval cr"
                                    + "  set  cr.person.idPerson   = :idPersonForward "
                                    + "  where cr.person.idPerson = :idPersonClosed ");

    query.setInteger("idPersonForward", idPersonForward);
    query.setInteger("idPersonClosed", idPersonClosed);
    query.executeUpdate();
}
}
