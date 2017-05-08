package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Allegation;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO class for ALLEGATION
 * 
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/08/08  SWR       STGAP00006446 - Added findAllegationsForResource() method to support
 *                      Policy Violation Report.
 *  09/11/08  VVO       STGAP00009865 - Corrected DAM translation in findAllegationIdVictim()
 *                      and findAllegationIdPerp(). DAM reference: cinva0d and cinva5d     
 *  09/23/08  mxpatel   STGAP00010044: added findAllegationByIdPersonClosedAsVictim method to find
 *                      any rows with person being closed in the person merge as a victim. 
 *                      wrote updateAllegationIdVictim to update the allegation table with new person.
 *  09/23/08  arege     STGAP00006539 Added countAllegationByIdAllegedPerpetratorAndidAllegationStage()
 *                      method to find if there exists any Allegation on the given person and the
 *                      given stage.
 *  04/02/09  bgehlot   added the method findRecurrenceOfMaltreatment, findPersonByIdVictimByIdStage,
 *                      findpersonByIdAllegedPerpetratorByIdStage, findpersonByIdAllegedPerpetratorByIdVictim,
 *                      findCdAllegTypeByIdStageIdVictim, findCdAllegTypeByIdStageIdVictim       
 *  09/21/09  bgehlot   added the method findRecurrenceOfMaltreatmentFromMaterializedView   
 *  03/03/10  cwells    added the method findListOfCDNFSIAllgByIdPersonIdCaseCdStageTypeByCdStageType     
 *  05/20/10  mxpatel   SMS #42783: modified the query for findRecurrenceOfMaltreatment method to avoid "Temporary Error"    
 *  05/24/10  bgehlot   SMS#51977 MR-066 Changes 
 *  05/26/10  hjbaptisteSMS#51977-MR66-Maltreatment In Care: Added method to check to see if incident date is after
 *                      the removal date       
 *  02/08/12  htvo      STGAP00017831: MR-102 - Added method findByIdCaseCdDispositionCdMalType   
 *  03/02/12  aavila	STGAP00017987: Added method countAllegationWithSevAsCDNFSIWithNoCNSEventByIdCase   
 *  03/07/12  htvo      STGAP00017991: update findByIdCaseCdDispositionCdMalType to include INT allegations     
 *  03/07/12  aavila	STGAP00017987: Updating method countAllegationWithSevAsCDNFSIWithNoCNSEventByIdCase
 *  					to search through all stages of a case for allegations, instead of just case itself.
 *  03/15/12  schoi     STGAP00018045: MR-102 Corrected findByIdCaseCdDispositionCdMalType to consider idCase in the query
 *  04/03/12  aavila	STGAP00018058: Updating method countAllegationWithSevAsCDNFSIWithNoCNSEventByIdCase
 *  					to compare event stage id with allegation stage id instead of allegation case id.
 * </pre>
 */
public class AllegationDAOImpl extends BaseDAOImpl implements AllegationDAO {
  public long countAllegationPerpetratorByIdStageAndIdPerson(int idPerson, int idStage, int idAllegation) {
    Query query = getSession().createQuery("select count(personByIdAllegedPerpetrator.idPerson) " +
                                           "  from Allegation " +
                                           " where personByIdAllegedPerpetrator.idPerson = :idPerson " +
                                           "   and stage.idStage = :idStage " +
                                           "   and idAllegation != :idAllegation");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setInteger("idAllegation", idAllegation);

    return (Long) query.uniqueResult();
  }

  public long countAllegationVictimByIdPersonAndIdStage(int idPerson, int idStage, int idAllegation) {
    Query query = getSession().createQuery("select count(personByIdVictim.idPerson) " +
                                           "  from Allegation " +
                                           " where personByIdVictim.idPerson = :idPerson " +
                                           "   and stage.idStage = :idStage " +
                                           "   and idAllegation != :idAllegation");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idAllegation", idAllegation);
    return (Long) query.uniqueResult();
  }
  //Added Per STGAP00006539
  public long countAllegationByIdAllegedPerpetratorAndidAllegationStage(int idAllegedPerpetrator, int idStage){
    Query query = getSession().createQuery("select count(*) " +
                                           " from Allegation " +
                                           " where personByIdAllegedPerpetrator.idPerson = :idAllegedPerpetrator " +
                                           " and stage.idStage = :idStage " );
    query.setInteger("idAllegedPerpetrator", idAllegedPerpetrator);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public Integer findAllegationByPersonByIdAllegedPerpetrator(int idAllegedPerpetrator, String cdAllegType,
                                                              int idVictim, int idStage) {
    Query query = getSession().createQuery("select idAllegation " +
                                           "  from Allegation " +
                                           " where personByIdAllegedPerpetrator.idPerson = :idAllegedPerpetrator " +
                                           "   and cdAllegType = :cdAllegType " +
                                           "   and personByIdVictim.idPerson = :idVictim " +
                                           "   and stage.idStage = :idStage");
    query.setInteger("idAllegedPerpetrator", idAllegedPerpetrator);
    query.setString("cdAllegType", cdAllegType);
    query.setInteger("idVictim", idVictim);
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public Integer findAllegation(String cdAllegType, int idVictim, int idStage) {
    Query query = getSession().createQuery("select idAllegation " +
                                           "  from Allegation " +
                                           " where personByIdAllegedPerpetrator.idPerson is null " +
                                           "   and cdAllegType = :cdAllegType " +
                                           "   and personByIdVictim.idPerson = :idVictim " +
                                           "   and stage.idStage = :idStage");
    query.setString("cdAllegType", cdAllegType);
    query.setInteger("idVictim", idVictim);
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Allegation> findAllegationsForResource(int idResource, String cdDisposition) {
    
    Query query = getSession().createQuery(" select a " +
                                           " from Allegation a " +
                                             " inner join a.stage as currStage " +
                                             " inner join currStage.stageLinksForIdStage as prevStage " +
                                             " inner join prevStage.stageByIdPriorStage as intakeLink " +
                                             " inner join intakeLink.incomingDetail as id " +
                                           " where id.cdIncomingDisposition = :cdDisposition " +
                                           " and id.capsResource.idResource = :idResource " + 
                                           " order by a.dtAllegedIncident ");
    
    query.setInteger("idResource", idResource);
    query.setString("cdDisposition", cdDisposition);
    return (List<Allegation>) query.list();
  }
  
  public long countAllegationByPersonByIdAllegedPerpetrator(int idAllegedPerpetrator, String cdAllegType, int idVictim,
                                                            int idStage) {
    Query query = getSession().createQuery("select count(idAllegation) " +
                                           "  from Allegation " +
                                           " where personByIdAllegedPerpetrator.idPerson = :idAllegedPerpetrator " +
                                           "   and cdAllegType = :cdAllegType " +
                                           "   and personByIdVictim.idPerson = :idVictim " +
                                           "   and stage.idStage = :idStage");
    query.setInteger("idAllegedPerpetrator", idAllegedPerpetrator);
    query.setString("cdAllegType", cdAllegType);
    query.setInteger("idVictim", idVictim);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public long countAllegationByCdAllegType(String cdAllegType, int idVictim, int idStage) {
    Query query = getSession().createQuery("select count(idAllegation) " +
                                           "  from Allegation " +
                                           " where personByIdAllegedPerpetrator.idPerson is null " +
                                           "   and cdAllegType = :cdAllegType " +
                                           "   and personByIdVictim.idPerson = :idVictim " +
                                           "   and stage.idStage = :idStage");
    query.setString("cdAllegType", cdAllegType);
    query.setInteger("idVictim", idVictim);
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findAllegationsByIdStageAndIdSituation(int idStage) {
    Query query = getSession().createQuery("   select new map(b.nmPersonFull as nmPersVictim, " +
                                           "                  c.nmPersonFull as nmPersonFull, " +
                                           "                  a.personByIdVictim.idPerson as personByIdVictim, " +
                                           "                  a.cdAllegType as cdAllegType, " +
                                           "                  a.personByIdAllegedPerpetrator.idPerson as personByIdAllegedPerpetrator, " +
                                           "                  a.cdAllegDisposition as cdAllegDisposition , " +
                                           "                  a.cdAllegIncidentStage as cdAllegIncidentStage, " +
                                           "                  a.idAllegation as idAllegation, " +
                                           "                  a.dtLastUpdate as dtLastUpdate) " +
                                           "     from Stage d,Allegation a " +
                                           "     join a.personByIdVictim b " +
                                           "left join a.personByIdAllegedPerpetrator c " +
                                           "     join a.stage e " +
                                           "    where d.idStage = :idStage " +
                                           "      and e.situation.idSituation = d.situation.idSituation");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findAllegationsByIdStage(int idStage) {
    Query query = getSession().createQuery("   select new map(a.cdAllegDisposition as cdAllegDisposition , " +
                                           "                  a.idAllegation as idAllegation) " +
                                           "     from Allegation a " +
                                           "    where a.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<String> findAllegDispositionfromIdStage(int idStage) {
    Query query = getSession().createQuery("select distinct a.cdAllegDisposition " +
                                           "  from Allegation a" +
                                           " where a.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<String>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findAllegationByIdVictimAndIdAllegedPerp(int idStage) {
    SQLQuery query = getSession().createSQLQuery("SELECT DISTINCT A.ID_VICTIM as idVictim, " +
                                                 "                B.ID_ALLEGED_PERPETRATOR as idPerp, " +
                                                 "                A.CD_ALLEG_DISPOSITION as cdAllegDispVictim, " +
                                                 "                B.CD_ALLEG_DISPOSITION as cdAllegDispPerp " +
                                                 "           FROM ALLEGATION B, " +
                                                 "                ALLEGATION A " +
                                                 "          WHERE A.ID_ALLEGATION_STAGE = :idStage " +
                                                 "            AND B.ID_ALLEGATION_STAGE = :idStage " +
                                                 "            AND A.ID_VICTIM = B.ID_ALLEGED_PERPETRATOR");
    query.addScalar("idVictim", Hibernate.INTEGER);
    query.addScalar("idPerp", Hibernate.INTEGER);
    query.addScalar("cdAllegDispVictim", Hibernate.STRING);
    query.addScalar("cdAllegDispPerp", Hibernate.STRING);
    query.setInteger("idStage", idStage);
    return (List<Object[]>) query.list();

  }

  public Integer findIdStageByIdVictim(int idStage, int idPerson) {
    Query query = getSession().createQuery("select stage.idStage " +
                                           "  from Allegation " +
                                           " where (personByIdAllegedPerpetrator.idPerson = :idPerson " +
                                           "        or personByIdVictim.idPerson = :idPerson) " +
                                           "   and stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  public long countCasesOfVictimPrepetratorMerge(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from Allegation a , Stage s " +
                                           "  where ((a.personByIdVictim.idPerson = :idPersMergeForward " +
                                           "      and a.personByIdAllegedPerpetrator.idPerson = :idPersMergeClosed ) " +
                                           "      or (a.personByIdVictim.idPerson = :idPersMergeClosed " +
                                           "          and a.personByIdAllegedPerpetrator.idPerson = :idPersMergeForward ) ) " +
                                           "    and ( s.dtStageClose is null " +
                                           "          or s.dtStageClose = :maxDate ) " +
                                           "    and a.stage.idStage = s.idStage ");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  public long countAllegationsByPersonStatusCategoryStage(int idPerson, String cdPersonStatus, String cdPersonCategory,
                                                          int idAllegationStage) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from Person a, " +
                                           "       PersonCategory b, " +
                                           "       Allegation c " +
                                           " where a.idPerson = :idPerson " +
                                           "   and a.cdPersonStatus = :cdPersonStatus " +
                                           "   and b.person.idPerson = a.idPerson " +
                                           "   and b.cdPersonCategory = :cdPersonCategory " +
                                           "   and c.personByIdAllegedPerpetrator.idPerson = a.idPerson " +
                                           "   and c.stage.idStage = :idAllegationStage ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonStatus", cdPersonStatus);
    query.setString("cdPersonCategory", cdPersonCategory);
    query.setInteger("idAllegationStage", idAllegationStage);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findAllegationDuplicatesByIdPerson(int idPersMergeForward) {
    Query query = getSession().createQuery("   from Allegation a1 , " +
                                           "        Allegation a2 " +
                                           "  where a1.stage.idStage = a2.stage.idStage " +
                                           "    and a1.idAllegation < a2.idAllegation " +
                                           "    and a1.personByIdVictim = a2.personByIdVictim " +
                                           "    and a1.personByIdAllegedPerpetrator = a2.personByIdAllegedPerpetrator " +
                                           "    and a1.cdAllegType = a2.cdAllegType " +
                                           "    and ( a1.stage.dtStageClose is null " +
                                           "          or a1.stage.dtStageClose = :maxDate ) " +
                                           "    and (a1.personByIdVictim.idPerson = :idPersMergeForward " +
                                           "         or a1.personByIdAllegedPerpetrator.idPerson = :idPersMergeForward)");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Object[]>) query.list();
  }

  public Allegation findAllegationByIdPersonAndIdStage(int idPerson, int idStage) {
    Query query = getSession().createQuery(" from Allegation a, " + "        Stage s " +
                                           "where a.personByIdVictim.idPerson = :idPerson " +
                                           "  and a.stage.idStage = :idStage " +
                                           "  and a.stage.idStage = s.idStage " +
                                           "  and ((s.cdStageProgram in ('AFC') " +
                                           "        and a.cdAllegDisposition in ('CON', " +
                                           "                                     'VAL')) " +
                                           "        or (s.cdStageProgram in ('CPS', " +
                                           "                                 'CCL', " +
                                           "                                 'RCL') " +
                                           "            and a.cdAllegSeverity = 'FT'))");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (Allegation) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Allegation> findAllegationAfterRemovalByIdPersonAndDtRemoval(int idPerson,  Date dtRemoval) {
    Query query = getSession().createQuery(" from Allegation a, " + "        Stage s " +
                                           "where a.personByIdVictim.idPerson = :idPerson " +
                                           "  and a.dtAllegedIncident > :dtRemoval " +
                                           "  and a.stage.idStage = s.idStage " +
                                           "  and (s.dtStageClose is null or s.dtStageClose = :maxJavaDate)");
    query.setInteger("idPerson", idPerson);
    query.setDate("dtRemoval", dtRemoval);
    query.setDate("maxJavaDate", DateHelper.MAX_JAVA_DATE);
    return (List<Allegation>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findAllegationAllegationPerson(int idStage) {
    Query query = getSession().createQuery(" select new map(a.idAllegation as idAllegation, " +
                                           "                a.dtLastUpdate as dtLastUpdate, " +
                                           "                a.stage.idStage as idStage, " +
                                           "                a.personByIdVictim.idPerson as personByIdVictim, " +
                                           "                a.personByIdAllegedPerpetrator.idPerson as personByIdAllegedPerpetrator, " +
                                           "                a.cdAllegIncidentStage as cdAllegIncidentStage, " +
                                           "                a.txtAllegDuration as txtAllegDuration, " +
                                           "                a.cdAllegType as cdAllegType, " +
                                           "                a.cdAllegDisposition as cdAllegDisposition, " +
                                           "                a.cdAllegSeverity as cdAllegSeverity, " +
                                           "                a.cdMaltreatorRel as cdMaltreatorRel, " +
                                           "                a.indAllegCancelHist as indAllegCancelHist, " +
                                           "                f.indFacilAllegCancelHist as indFacilAllegCancelHist, " +
                                           "                f.cdFacilAllegEventLoc as cdFacilAllegEventLoc, " +
                                           "                f.cdFacilAllegClss as cdFacilAllegClss, " +
                                           "                f.cdFacilAllegClssSupr as cdFacilAllegClssSupr, " +
                                           "                f.cdFacilAllegDispSupr as cdFacilAllegDispSupr, " +
                                           "                f.cdFacilAllegSrc as cdFacilAllegSrc, " +
                                           "                f.cdFacilAllegSrcSupr as cdFacilAllegSrcSupr, " +
                                           "                f.dtFacilAllegSuprReply as dtFacilAllegSuprReply, " +
                                           "                f.dtFacilAllegInvstgtr as dtFacilAllegInvstgtr, " +
                                           "                f.cdFacilAllegInjSer as cdFacilAllegInjSer, " +
                                           "                f.cdFacilAllegNeglType as cdFacilAllegNeglType, " +
                                           "                f.dtFacilAllegIncident as dtFacilAllegIncident, " +
                                           "                f.indFacilAllegAbOffGr as indFacilAllegAbOffGr, " +
                                           "                f.indFacilAllegSupvd as indFacilAllegSupvd, " +
                                           "                f.txtFacilAllegCmnts as txtFacilAllegCmnts, " +
                                           "                f.nbrFacilAllegMhmr as nbrFacilAllegMhmr, " +
                                           "                p.idPerson as idPerson, " +
                                           "                p.cdPersonSex as cdPersonSex, " +
                                           "                p.nmPersonFull as nmPersonFull, " +
                                           "                p.nbrPersonAge as nbrPersonAge, " +
                                           "                p.dtPersonDeath as dtPersonDeath, " +
                                           "                p.dtPersonBirth as dtPersonBirth, " +
                                           "                p.cdPersonReligion as cdPersonReligion, " +
                                           "                p.cdPersonChar as cdPersonChar, " +
                                           "                p.indPersonDobApprox as indPersonDobApprox, " +
                                           "                p.cdPersonLivArr as cdPersonLivArr, " +
                                           "                p.cdPersGuardCnsrv as cdPersGuardCnsrv, " +
                                           "                p.cdPersonStatus as cdPersonStatus, " +
                                           "                p.cdPersonDeath as cdPersonDeath, " +
                                           "                p.cdPersonMaritalStatus as cdPersonMaritalStatus, " +
                                           "                p.txtPersonOccupation as txtPersonOccupation, " +
                                           "                p.cdPersonLanguage as cdPersonLanguage, " +
                                           "                p.cdPersonEthnicGroup as cdPersonEthnicGroup, " +
                                           "                p.indPersCancelHist as indPersCancelHist, " +
                                           "                p.nmPersonFirst as nmPersonFirst, " +
                                           "                p.nmPersonMiddle as nmPersonMiddle, " +
                                           "                p.nmPersonLast as nmPersonLast, " +
                                           "                p.cdPersonSuffix as cdPersonSuffix) " +
                                           "    from FacilAlleg f, " +
                                           "         Person p, " +
                                           "         Allegation a " +
                                           "   where a.stage.idStage = :idStage " +
                                           "     and a.idAllegation = f.allegation.idAllegation " +
                                           "     and a.personByIdVictim.idPerson = p.idPerson " +
                                           "order by a.cdAllegType ");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findAllegationFacilAllegFullVictimFullAllegPerpetrator(int idStage, int pageNbr,
                                                                                            int pageSize) {

    Query query = getSession().createQuery(" select new map(p1.nmPersonFull as victimNmPersonFull, " +
                                           "                p2.nmPersonFull as perpetratorNmPersonFull, " +
                                           "                a.personByIdVictim.idPerson as idVictim, " +
                                           "                a.cdAllegType as cdAllegType, " +
                                           "                a.cdMaltreatorRel as cdMaltreatorRel, " +
                                           "                a.personByIdAllegedPerpetrator.idPerson as idAllegedPerpetrator, " +
                                           "                a.cdAllegDisposition as cdAllegDisposition, " +
                                           "                a.cdAllegIncidentStage as cdAllegIncidentStage, " +
                                           "                a.idAllegation as idAllegation, " +
                                           "                a.dtLastUpdate as allegationDtLastUpdate, " +
                                           "                a.dtLastUpdate as facilAllegDtLastUpdate, " +
                                           "                a.cdAllegSeverity as cdAllegSeverity, " +
                                           "                a.indChildDeathSeverity as indChildDeathSeverity ) " +
                                           "    from  Allegation a " +
                                           "      join a.personByIdVictim p1 " +
                                           " left join a.personByIdAllegedPerpetrator p2 " +
                                           "   where a.stage.idStage = :idStage " +
                                           "order by p1.nmPersonFull, " +
                                           "         a.cdAllegType, " +
                                           "         p2.nmPersonFull");

    query.setInteger("idStage", idStage);

    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map<String, Object>> findIdPersonByVictimIdByIdStage(int idStage) {
    Query query = getSession().createQuery("select distinct new map (a.personByIdVictim.idPerson as idPerson, " +
                                           "                         a.cdAllegDisposition as cdAllegDisposition) " +
                                           "  from Allegation a " +
                                           " where a.stage.idStage = :idStage " +
                                           "   and a.personByIdAllegedPerpetrator is null");
    query.setInteger("idStage", idStage);
    return (List<Map<String, Object>>) query.list();
  }

  public Integer findPhSxAbIdAllegationByIdStage(int idStage) {
    Query query = getSession().createQuery("select idAllegation " +
                                           "  from Allegation " +
                                           " where stage.idStage = :idStage " +
                                           "   and (cdAllegType = 'PHAB' " +
                                           "       or cdAllegType = 'SXAB') " +
                                           "   and rownum < 2");

    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public Allegation findAllegationByIdAllegation(int idAllegation) {
    Query query = getSession().createQuery("  from Allegation a " +
                                           " where a.idAllegation = :idAllegation ");
    query.setInteger("idAllegation", idAllegation);
    return (Allegation) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map<String, Object>> findAllegationIdVictim(int idStage) {
    Query query = getSession().createQuery(" select distinct new map(c.personByIdVictim.idPerson as idPerson, " +
                                           "                         c.cdAllegDisposition as cdAllegDisposition) " +
                                           "  from Allegation c " +
                                           "  where c.stage.idStage = :idStage " +
                                           "  and not  exists (select distinct a.personByIdVictim.idPerson, " +
                                           "                                   a.cdAllegDisposition " +
                                           "                    from Allegation b, " +
                                           "                         Allegation a " +
                                           "                    where a.stage.idStage = :idStage " +
                                           "                    and b.stage.idStage = :idStage " +
                                           "                    and a.personByIdVictim.idPerson = b.personByIdAllegedPerpetrator.idPerson" +
                                           "                    and a.personByIdVictim.idPerson = c.personByIdVictim.idPerson) ");
    query.setInteger("idStage", idStage);
    return (List<Map<String, Object>>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map<String, Object>> findAllegationIdPerp(int idStage) {
    Query query = getSession().createQuery(
            " select distinct new map(c.personByIdAllegedPerpetrator.idPerson as idPerson, " +
            "                         c.cdAllegDisposition as cdAllegDisposition) " +
            " from Allegation c " +
            " where c.stage.idStage = :idStage " +
            " and c.personByIdAllegedPerpetrator.idPerson is not null " +
            " and  not  exists (select distinct a.personByIdAllegedPerpetrator.idPerson, " +
            "                                   a.cdAllegDisposition " +
            "                   from Allegation b, " +
            "                        Allegation a " +
            "                   where a.stage.idStage = :idStage " +
            "                   and b.stage.idStage = :idStage " +
            "                   and a.personByIdAllegedPerpetrator.idPerson = b.personByIdVictim.idPerson" +
            "                   and a.personByIdAllegedPerpetrator.idPerson = c.personByIdAllegedPerpetrator.idPerson) ");
    query.setInteger("idStage", idStage);
    return (List<Map<String, Object>>) query.list();
  }

  public int updateCdAllegDispositionByIdAllegationAndDtLastUpdate(int idAllegation, Date dtLastUpdate) {
    Query query = getSession().createQuery("update Allegation " +
                                           "   set cdAllegDisposition = null " +
                                           " where idAllegation = :idAllegation " +
                                           "   and dtLastUpdate = :tsLastUpdate");

    query.setInteger("idAllegation", idAllegation);
    query.setTimestamp("tsLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateCdAllegDispositionAndCdAllegSeverity(int idAllegation, Date dtLastUpdate, String cdAllegDisposition,
                                                        String cdAllegSeverity, String txtEvidenceSummary) {
    Query query = getSession().createQuery("update Allegation " +
                                           "   set cdAllegDisposition = :cdAllegDisposition, " +
                                           "       cdAllegSeverity = :cdAllegSeverity, " +
                                           "       txtEvidenceSummary = :txtEvidenceSummary " +
                                           " where idAllegation = :idAllegation " +
                                           "   and dtLastUpdate = :dtLastUpdate");

    query.setInteger("idAllegation", idAllegation);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setString("cdAllegDisposition", cdAllegDisposition);
    query.setString("cdAllegSeverity", cdAllegSeverity);
    query.setString("txtEvidenceSummary", txtEvidenceSummary);
    return query.executeUpdate();
  }

  public void saveAllegation(Allegation allegation) {
    getSession().saveOrUpdate(allegation);
  }

  public void deleteAllegation(Allegation allegation) {
    getSession().delete(allegation);
  }

  public int deleteAllegation(int idAllegation, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete Allegation " +
                                           " where idAllegation = :idAllegation " +
                                           "   and dtLastUpdate = :dtLastUpdate");
    query.setInteger("idAllegation", idAllegation);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updateAllegationIdAllegedPerpetrator(int idPersMergeForward, int idPersMergeClosed, int idStage) {
    Query query = getSession().createQuery("update Allegation " +
                                           "   set personByIdAllegedPerpetrator.idPerson = :idPersMergeForward " +
                                           " where personByIdAllegedPerpetrator.idPerson = :idPersMergeClosed " +
                                           "   and stage.idStage = :idStage");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
//mxpatel wrote this method for defect #10044
  @SuppressWarnings({"unchecked"})
  public List<Allegation> findAllegationByIdPersonClosedAsVictim(int idPersMergeClosed){
    
    Query query = getSession().createQuery(" select a " +
                                           " from Allegation a " +
                                           " where personByIdVictim.idPerson = :idPersMergeClosed " );
                                           
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return (List<Allegation>) query.list();
  }
  //mxpatel wrote this method for defect #10044
  public int updateAllegationIdVictim(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery("update Allegation " +
                                           "   set personByIdVictim.idPerson = :idPersMergeForward " +
                                           " where personByIdVictim.idPerson = :idPersMergeClosed ");
                                           
    
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return query.executeUpdate();
  }

  //STGAP00012833: This method returns Y if the child has been the victim of substantiated maltreatment  in the prior incident
  // within the previous six months of the intake date from the current case.
  public String findRecurrenceOfMaltreatment(int idAllegedVictim, int idCase) {
    SQLQuery query = getSession().createSQLQuery("select  "
                                                 + " inner_main.HAS_SIX_MONTH_RECURRENCE  "
                                                 + " from(( "
                                                 + " select distinct  "
                                                 + " (decode( ( select count(*)   "
                                                 + " from CAPS.cps_invst_detail cps_invst_detail2,  "
                                                 + " CAPS.stage_person_link stage_person_link2,   "
                                                 + " CAPS.stage stage2  "
                                                 + " where cps_invst_detail2.ID_CPS_INVST_STAGE = stage_person_link2.ID_STAGE  "
                                                 + " and stage_person_link2.ID_stage = stage2.id_stage  "
                                                 + " and exists (select *   "
                                                 + " from allegation  "
                                                 + " where allegation.ID_ALLEGATION_STAGE = stage_person_link2.ID_STAGE   "
                                                 + " and allegation.ID_VICTIM = stage_person_link2.ID_PERSON   "
                                                 + " and allegation.CD_ALLEG_DISPOSITION IN ('SUB')   "
                                                 + " and allegation.ID_VICTIM = :idAllegedVictim  "
                                                 + " )      "
                                                 + " AND cps_invst_detail2.cd_cps_invst_dtl_ovrll_disptn='SUB'  "
                                                 + " and cps_invst_detail2.CD_CNCLSN_RISK_FND NOT IN ('06')   "
                                                 + " and cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE <= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE   "
                                                 + " and add_months(cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE, 6) >= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE  "
                                                 + " and alleged_victim.ID_PERSON = stage_person_link2.ID_PERSON    "
                                                 + " and stage2.DT_STAGE_CLOSE is not null   "
                                                 + " and stage.id_case <> stage2.id_case   "
                                                 + " ), 0, 'N', 'Y')) as HAS_SIX_MONTH_RECURRENCE  "
                                                 + " from stage,   "
                                                 + " stage_person_link,   "
                                                 + " stage_person_link stage_person_link_cm,  "
                                                 + " person primary_caretaker,   "
                                                 + " person alleged_victim,  "
                                                 + " cps_invst_detail,   "
                                                 + " allegation,   "
                                                 + " stage_link,  "
                                                 + " (select   "
                                                 + " intake_stage.ID_STAGE as id_int_stage "
                                                 + " from incoming_detail,   "
                                                 + " stage intake_stage   "
                                                 + " where incoming_detail.ID_STAGE = intake_stage.ID_STAGE  "
                                                 + " ) intake_details   "
                                                 + " where stage.CD_STAGE = 'INV'  "
                                                 + " and allegation.ID_VICTIM = :idAllegedVictim  "
                                                 + " and stage.id_case = :idCase  "
                                                 + " and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null)   "
                                                 + " and stage.ID_STAGE = stage_person_link.ID_STAGE  "
                                                 + " and stage_person_link.CD_STAGE_PERS_REL_INT IN ('PK')   "
                                                 + " and stage_person_link.ID_PERSON = primary_caretaker.ID_PERSON   "
                                                 + " and cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE  "
                                                 + " and allegation.ID_ALLEGATION_STAGE = stage.ID_STAGE  "
                                                 + " and alleged_victim.ID_PERSON = allegation.ID_VICTIM  "
                                                 + " and stage_person_link_cm.CD_STAGE_PERS_ROLE IN ('PR','HP')   "
                                                 + " and stage_person_link_cm.ID_STAGE = stage.ID_STAGE  "
                                                 + " and stage_link.ID_STAGE = stage.ID_STAGE   "
                                                 + " and (stage_link.ID_PRIOR_STAGE = intake_details.id_int_stage) "
                                                 + " and (cps_invst_detail.CD_CNCLSN_RISK_FND NOT IN ('06') or cps_invst_detail.CD_CNCLSN_RISK_FND is null )) "
                                                 + " UNION "
                                                 + " select distinct  "
                                                 + " (decode( ( select count(*)   "
                                                 + " from CAPS.cps_invst_detail cps_invst_detail2,  "
                                                 + " CAPS.stage_person_link stage_person_link2,   "
                                                 + " CAPS.stage stage2  "
                                                 + " where cps_invst_detail2.ID_CPS_INVST_STAGE = stage_person_link2.ID_STAGE  "
                                                 + " and stage_person_link2.ID_stage = stage2.id_stage  "
                                                 + " and exists (select *   "
                                                 + " from allegation  "
                                                 + " where allegation.ID_ALLEGATION_STAGE = stage_person_link2.ID_STAGE   "
                                                 + " and allegation.ID_VICTIM = stage_person_link2.ID_PERSON   "
                                                 + " and allegation.CD_ALLEG_DISPOSITION IN ('SUB')   "
                                                 + " and allegation.ID_VICTIM = :idAllegedVictim  "
                                                 + " )      "
                                                 + " AND cps_invst_detail2.cd_cps_invst_dtl_ovrll_disptn='SUB'  "
                                                 + " and cps_invst_detail2.CD_CNCLSN_RISK_FND NOT IN ('06')   "
                                                 + " and cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE <= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE   "
                                                 + " and add_months(cps_invst_detail2.DT_CPS_INVST_DTL_INTAKE, 6) >= cps_invst_detail.DT_CPS_INVST_DTL_INTAKE  "
                                                 + " and alleged_victim.ID_PERSON = stage_person_link2.ID_PERSON    "
                                                 + " and stage2.DT_STAGE_CLOSE is not null   "
                                                 + " and stage.id_case <> stage2.id_case   "
                                                 + " ), 0, 'N', 'Y')) as HAS_SIX_MONTH_RECURRENCE  "
                                                 + " from stage,   "
                                                 + " stage div_stage,  "
                                                 + " stage_person_link,   "
                                                 + " stage_person_link stage_person_link_cm,  "
                                                 + " person primary_caretaker,   "
                                                 + " person alleged_victim,  "
                                                 + " cps_invst_detail,   "
                                                 + " allegation,   "
                                                 + " stage_link,  "
                                                 + " incoming_detail    "
                                                 + " where stage.CD_STAGE = 'INV'  "
                                                 + " and allegation.ID_VICTIM = :idAllegedVictim  "
                                                 + " and stage.id_case = :idCase  "
                                                 + " and (stage.CD_STAGE_REASON_CLOSED NOT IN ('97', '97 ') or stage.CD_STAGE_REASON_CLOSED is null)   "
                                                 + " and stage.ID_STAGE = stage_person_link.ID_STAGE  "
                                                 + " and stage_person_link.CD_STAGE_PERS_REL_INT IN ('PK')   "
                                                 + " and stage_person_link.ID_PERSON = primary_caretaker.ID_PERSON   "
                                                 + " and cps_invst_detail.ID_CPS_INVST_STAGE = stage.ID_STAGE  "
                                                 + " and allegation.ID_ALLEGATION_STAGE = stage.ID_STAGE  "
                                                 + " and alleged_victim.ID_PERSON = allegation.ID_VICTIM  "
                                                 + " and stage_person_link_cm.CD_STAGE_PERS_ROLE IN ('PR','HP')   "
                                                 + " and stage_person_link_cm.ID_STAGE = stage.ID_STAGE  "
                                                 + " and stage_link.ID_STAGE = stage.ID_STAGE   "
                                                 + " and div_stage.id_stage=stage_link.ID_PRIOR_STAGE   "
                                                 + " and div_stage.cd_stage =  'DIV'   " 
                                                 + " and incoming_detail.id_stage=div_stage.id_stage  "
                                                 + " and (cps_invst_detail.CD_CNCLSN_RISK_FND NOT IN ('06') or cps_invst_detail.CD_CNCLSN_RISK_FND is null ) "
                                                 + " )inner_main ");
    query.setInteger("idAllegedVictim", idAllegedVictim);
    query.setInteger("idCase", idCase);
    return (String) firstResult(query);

  }
  
  //STGAP00012833: Retrieve the alleged victims for the stage
  @SuppressWarnings({"unchecked"})
  public List<Integer> findPersonByIdVictimByIdStage(int idStage) {
    Query query = getSession().createQuery("   select distinct a.personByIdVictim.idPerson " +
                                           "   from Allegation a " +
                                           "   where a.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<Integer>) query.list();
  }
  
  //STGAP00012833: Retrieve the alleged perpetrator for the stage
  @SuppressWarnings({"unchecked"})
  public List<Integer> findpersonByIdAllegedPerpetratorByIdStage(int idStage, int idVictim) {
    Query query = getSession().createQuery("   select distinct a.personByIdAllegedPerpetrator.idPerson " +
                                           "   from Allegation a " +
                                           "   where a.stage.idStage = :idStage " +
                                           "   and a.personByIdVictim.idPerson = :idVictim " +
                                           "   and a.personByIdAllegedPerpetrator.idPerson is not null " +
                                           "   order by a.personByIdAllegedPerpetrator.idPerson asc");
    query.setInteger("idStage", idStage);
    query.setInteger("idVictim", idVictim);
    return (List<Integer>) query.list();
  }
  
  //STGAP00012833: Retrieve the alleged perpetrator for the victim
  @SuppressWarnings({"unchecked"})
  public List<Integer> findpersonByIdAllegedPerpetratorByIdVictim(int idVictim) {
    Query query = getSession().createQuery("   select distinct a.personByIdAllegedPerpetrator.idPerson " +
                                           "   from Allegation a " +
                                           "   where a.personByIdVictim.idPerson = :idVictim " +
                                           "   and a.personByIdAllegedPerpetrator.idPerson is not null " +
                                           "   order by a.personByIdAllegedPerpetrator.idPerson asc");
    query.setInteger("idVictim", idVictim);
    return (List<Integer>) query.list();
  }
  
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findListOfCDNFSIAllgByIdPersonIdCaseCdStageTypeByCdStageType(int idPerson, Collection<Integer> idStages) {
    Query query = getSession()
                              .createQuery(
                                           "  select distinct new map(s.capsCase.idCase as idCase, "
                                                           + "                 s.cdStage as cdStage, "
                                                           + "                 s.idStage as idStage, "
                                                           + "                 s.nmStage as nmStage, "
                                                           + "                 s.dtStageStart as dtStageStart) "
                                                           + "    from Allegation a "
                                                           + "         join a.stage s "
                                                           + "   where a.personByIdVictim.idPerson = :idPerson "
                                                           + "     and s.idStage in (:idStages) "
                                                           + "     and a.cdAllegSeverity in ('FT','SR','NF') "
                                                           + "order by s.idStage desc ");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("idStages", idStages);
    return (List<Map>) query.list();
  }
  
  
  //STGAP00012833: Retrieve the alleged perpetrator for the stage and victim
  @SuppressWarnings({"unchecked"})
  public List<String> findCdAllegTypeByIdStageIdVictim(int idStage, int idVictim) {
    Query query = getSession().createQuery("   select distinct a.cdAllegType " +
                                           "   from Allegation a " +
                                           "   where a.stage.idStage = :idStage " +
                                           "   and a.personByIdVictim.idPerson = :idVictim " +
                                           "   and a.cdAllegType is not null " +
                                           "   order by a.cdAllegType asc");
    query.setInteger("idStage", idStage);
    query.setInteger("idVictim", idVictim);
    return (List<String>) query.list();
  }
  
  //STGAP00012833: Retrieve the cdAllegType for the victim
  @SuppressWarnings({"unchecked"})
  public List<String> findCdAllegTypeByIdVictim(int idVictim) {
    Query query = getSession().createQuery("   select distinct a.cdAllegType " +
                                           "   from Allegation a " +
                                           "   where a.personByIdVictim.idPerson = :idVictim " +
                                           "   and a.cdAllegType is not null " +
                                           "   order by a.cdAllegType asc");
    query.setInteger("idVictim", idVictim);
    return (List<String>) query.list();
  }
  
  //STGAP00014667 : This method returns Y if the child has been the victim of substantiated maltreatment  in the prior incident
  // within the previous six months of the intake date from the current case.
  public String findRecurrenceOfMaltreatmentFromMaterializedView(int idStage) {
    SQLQuery query = getSession().createSQLQuery(" select i.HAS_SIX_MONTH_RECURRENCE from INVESTIGATION_ALLEGATIONS i "
                                                +" where i.STAGE_ID = :idStage");
    query.setInteger("idStage", idStage);
    return (String) firstResult(query);

  }
  @SuppressWarnings({"unchecked"})
  public List<Allegation> findIdVictimByIdStageWithSevAsChildDeath(int idStage){
    //FT is Child Death
    Query query = getSession().createQuery("   from Allegation a " +
                                           " join fetch a.personByIdVictim " +
                                           "   where a.stage.idStage = :idStage " +
                                           "   and a.cdAllegSeverity = 'FT' " );
    query.setInteger("idStage", idStage);
    return (List<Allegation>) query.list();    
  }

  @SuppressWarnings( { "unchecked" })
  public BigDecimal countAllegationWithSevAsCDNFSIWithNoCNSEventByIdStage(int idStage) {
    // FT is Child Death, NF for Near Fatality, SR for Serious Injury
    // SMS#48860 Modified to take into account APRV event status 
    Query query = getSession().createSQLQuery(
                                              " select count(*) from Allegation a " 
                                              + " where a.id_allegation_stage = :idStage "
                                              + " and a.cd_alleg_severity IN ('FT', 'NF', 'SR') "
                                              + " and not EXISTS ( select 1 from event_person_link epl , event ev "
                                              + "      where epl.id_person = a.id_victim "
                                              + "      and epl.id_event = ev.id_event "
                                              + "      and ev.cd_event_type = 'CNS' "
                                              + "      and ev.cd_event_status = 'APRV' "
                                              + "      and ev.id_event_stage = a.id_allegation_stage ) " );                                         

    query.setInteger("idStage", idStage);
    return (BigDecimal) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public long countAllegationsWithSeverityNearFatalityByIdVictim(int idPerson) {
    // NF for Near Fatality
    Query query = getSession().createQuery(
                                           " select count(*) " + " from Allegation a"
                                                           + " where a.personByIdVictim.idPerson = :idPerson" 
                                                           + " and a.cdAllegSeverity = 'NF' ");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  /**
   * MR-066 Find all allegations for the stage
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Allegation> findAllegationsByIdStageForCPS(int idStage) {
    Query query = getSession().createQuery("    from Allegation a " +
                                           "    where a.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<Allegation>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<String> findByIdCaseCdDispositionCdMalType(int idCase, String cdDisposition, Collection<String> cdMalTypeSet) {
    Query query = getSession().createQuery("select distinct substr(a.cdAllegType, 1, 1)  " +
                                           " from Allegation a, StagePersonLink spl " +
                                           " where spl.capsCase.idCase = :idCase " +
                                           " and a.capsCase.idCase = :idCase " +
                                           " and a.personByIdVictim.idPerson = spl.person.idPerson " +
                                           " and a.cdAllegDisposition = :cdDisposition " +
                                           " and substr(a.cdAllegType, 1, 1) in (:cdMalTypeSet) ");
    query.setInteger("idCase", idCase);
    query.setString("cdDisposition", cdDisposition);
    query.setParameterList("cdMalTypeSet", cdMalTypeSet);
    return (List<String>) query.list();
  }
  
  //STGAP00017987 - Searching for CD/NF/SI report throughout entire case.
  @SuppressWarnings({"unchecked"})
  public BigDecimal countAllegationWithSevAsCDNFSIWithNoCNSEventByIdCase(int idCase){
	  Query query = getSession().createSQLQuery(
			  " select count(*) from Allegation a " 
              + " where a.id_allegation_stage in (select s.id_stage from stage s where s.id_case = :idCase) "
              + " and a.cd_alleg_severity IN ('FT', 'NF', 'SR') "
              + " and not EXISTS ( select 1 from event_person_link epl , event ev "
              + "      where epl.id_person = a.id_victim "
              + "      and epl.id_event = ev.id_event "
              + "      and ev.cd_event_type = 'CNS' "
              + "      and ev.cd_event_status = 'APRV' "
              + "      and ev.id_event_stage = a.id_allegation_stage ) ");
	  
	  	query.setInteger("idCase", idCase);
	  	return (BigDecimal) query.uniqueResult();
  }
}
