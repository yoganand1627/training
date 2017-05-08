package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO class is used for the STAGE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/04/08  SWR       STGAP00009080 - Added findOtherOpenStagesInCase() to support
 *                      edits required for MR-005 'Opened in Error' closure reason in 
 *                      Investigation
 *                      
 *  07/10/08  arege     STGAP00008896 - Added updateStageClearIdCaseAndIdSituationByIdStage
 *                      clears the idCase and idSituation fields.
 *  07/15/08  arege     STGAP00009014   updateStageByIdStageAndDtLastUpdateAndResTimeCmnts()
 *                      to support Intake Closure for saving Comments to  TXT_STAGE_RES_TIME_CMNTS
 *  10/31/09  mchillman STGAP00010898 - Changed query to allow FAD stages to return since even though 
 *                      they are sealed the users is still allowed to view them  
 *  03/04/09  bgehlot   STGAP00012734: Added the method findIdStageByIdCaseAndCdStageAndDtStageClose() which
 *                      gets the stage id of the active stage for a given case id and cd_stage.
 *  03/30/09  mxpatel   STGAP00013045: added method to find idStage of existing ADO stage.  
 *  06/14/09  mxpatel   STGAP00013002: wrote findCdStageByIdStage method to find cdStage from idStage      
 *  07/23/09  bgehlot   STGAP00014341: Added method updateStageAsgnmtHistory, deleteStageAsgnmtHistory
 *  02/23/10  wjcochran MR-62 Added method findStageByIdCaseAndCdStageSet That will look up a series of
 *                      stages for a particular case (i.e. - 'ONG', 'PAD' stages for a case idCase)
 *  03/03/10  cwells    CAPTA child death Form added methods findClosedStageByIdPersonCdStageDtStart,findStagesByIdCaseCdStagesIdPrimary
 *                      and findOpenStagesByIdCaseCdStagesIdPrimary
 *  08/30/10  wjcochran SMS #66752: Added new method, updateSummaryRedFlagCaseStages, to update the 
 *                      IND_RED_FLAG field of the STAGE table. Also updated findCPSSealedCaseSummaryStages,
 *                      findCPSCaseSummaryStagesForPadCase, and findCPSCaseSummaryStages to retrieve the
 *                      value of this new field.
 *  03/20/11  htvo      SMS#97845 MR-074-2 AFCARS: added findIdCaseByIdPersonCdRoleCdStageDtStageStart
 *  08/24/11  schoi     STGAP00017013: MR-095 Added findOpenStagesByIdCaseByIdPersonNotExistsInSPL
 *  10/06/11  schoi     STGAP00017013: MR-095 Added new method findMostRecentIdStageByIdCaseAndCdStage
 *  02/10/12  htvo      STGAP00017831: MR-102 - Added findIdCasesByIdCaseCdStageCdStageReasonClosed
 * </pre>
 */

public class StageDAOImpl extends BaseDAOImpl implements StageDAO {
  public long countCdStage(int idEvent) {
    Query query = getSession().createQuery("select count(s.cdStage) " +
                                           "  from Stage s, " +
                                           "       Event e " +
                                           " where e.idEvent = :idEvent " +
                                           "   and e.stage.idStage = s.idStage " +
                                           "   and s.cdStage in ('SUB','PFC','ADO','PAD') " +
                                           "   and s.dtStageClose is null ");
    query.setInteger("idEvent", idEvent);
    return (Long) query.uniqueResult();
  }
  public Stage findStageAndSituation(int idStage) {
    Query query = getSession().createQuery(" from Stage st join fetch st.situation " +
                                           "where st.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (Stage) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findSubStagesByCaseId(int idCase, String cdStage, String indStageClosure){
    Query query = getSession().createQuery("select s.idStage from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "  and s.cdStage = :cdStage " +
                                           "  and s.indStageClose = :indStageClosure ");
    query.setString("cdStage", cdStage);
    query.setString("indStageClosure", indStageClosure);
    query.setInteger("idCase", idCase);
    return (List<Integer>) query.list();
  }
 
  @SuppressWarnings({"unchecked"})
  public List<Integer> findStageIdSategeForAllDupliactes(int idPersMergeClosed, int idPersMergeForward) {

    Query query = getSession().createQuery("select distinct s.idStage " +
                                           "  from Stage s, " +
                                           "       StagePersonLink sl1, " +
                                           "       StagePersonLink sl2 " +
                                           " where sl1.stage.idStage = sl2.stage.idStage " +
                                           "   and sl1.stage.idStage =   s.idStage " +
                                           "   and sl2.stage.idStage =   s.idStage " +
                                           "   and (s.dtStageClose is null " +
                                           "        or trunc(s.dtStageClose) = to_Date('12/31/4712', 'mm/dd/yyyy')) " +
                                           "   and sl1.person.idPerson =   :idPersMergeClosed " +
                                           "   and sl2.person.idPerson =   :idPersMergeForward ");

    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idPersMergeForward", idPersMergeForward);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Stage> findStageByIdCase(int idCase) {

    Query query = getSession().createQuery(" from  Stage where capsCase.idCase = :idCase order By idStage ");

    query.setInteger("idCase", idCase);

    return (List<Stage>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findStageByIdCaseAndCdStage(int idCase, String cdStage) {

    Query query = getSession().createQuery(" from  Stage s where s.capsCase.idCase = :idCase " + 
                                           "and s.cdStage = :cdStage " +
                                          "order By idStage ");

    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    return (List<Stage>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public ArrayList<Integer> findStageIdsByIdCaseAndCdStage(int idCase, String cdStage) {

    Query query = getSession().createQuery(" select s.idStage from Stage s where s.capsCase.idCase = :idCase " + 
                                           "and s.cdStage = :cdStage " +
                                          "order By idStage ");

    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    return (ArrayList<Integer>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findClosedStageByIdPersonCdStageDtStart(int idPerson, String cdStage, Date dtStageStart) {

    Query query = getSession().createQuery(" select s from  Stage s " +
                                           " join s.stagePersonLinks spl" +
                                           " where spl.person.idPerson = :idPerson " + 
                                           "and s.cdStage = :cdStage " +
                                           "and s.dtStageClose < :dtStageStart " +
                                          "order By s.idStage ");

    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    query.setTimestamp("dtStageStart", dtStageStart);
    return (List<Stage>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public Long findClosedStageByPersonListDtStart(List<Integer> idPersons, Date dtStageStart) {

    Query query = getSession().createQuery(" select count(*) from  Stage s " +
                                           " join s.stagePersonLinks spl" +
                                           " where spl.person.idPerson in (:idPersons) " +
                                           "and s.dtStageClose < :dtStageStart ");

    query.setParameterList("idPersons", idPersons);
    query.setTimestamp("dtStageStart", dtStageStart);
    return (Long) query.uniqueResult();
  }
  
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findClosedStageByPersonListCdStageDtStart(List<Integer> idPersons, String cdStage, Date dtStageStart) {

    Query query = getSession().createQuery(" select s from  Stage s " +
                                           " join s.stagePersonLinks spl" +
                                           " where spl.person.idPerson in (:idPersons) " + 
                                           "and s.cdStage = :cdStage " +
                                           "and s.dtStageClose < :dtStageStart " +
                                          "order By s.idStage ");

    query.setParameterList("idPersons", idPersons);
    query.setString("cdStage", cdStage);
    query.setTimestamp("dtStageStart", dtStageStart);
    return (List<Stage>) query.list();
  }
  
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findStageByIdCaseAndCdStageSet(int idCase, Set<String> cdStage) {

    Query query = getSession().createQuery(" from  Stage s where s.capsCase.idCase = :idCase " + 
                                           "and s.cdStage in ( :cdStage )" +
                                          "order By idStage ");

    query.setInteger("idCase", idCase);
    query.setParameterList("cdStage", cdStage);
    return (List<Stage>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Stage> findStageByIdCaseAndCdStageDesc(int idCase, String cdStage) {

    Query query = getSession().createQuery(" from  Stage s where s.capsCase.idCase = :idCase " + 
                                           "and s.cdStage = :cdStage " +
                                          "order By idStage desc ");

    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    return (List<Stage>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public Integer findIdStageByIdCaseAndCdStage(int idCase, String cdStage) {

    Query query = getSession().createQuery(" select s.idStage from  Stage s where s.capsCase.idCase = :idCase " + 
                                           "and s.cdStage = :cdStage " +
                                          "order By idStage ");

    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    return (Integer) firstResult(query);
 }

  // STGAP00017013: MR-095
  @SuppressWarnings({"unchecked"})
  public Stage findMostRecentIdStageByIdCaseAndCdStage(int idCase, List<String> cdStage, int idStage) {

    Query query = getSession().createQuery(
                                           " from Stage s " 
                                           + " where s.capsCase.idCase = :idCase "
                                                           + " and s.cdStage in (:cdStage) "
                                                           + " and s.idStage <> :idStage "
                                                           + " order by s.idStage desc ");

    query.setInteger("idCase", idCase);
    query.setParameterList("cdStage", cdStage);
    query.setInteger("idStage", idStage);
    return (Stage) firstResult(query);
  }
  
  public Stage findStageAndCapsCase(int idStage) {
    Query query = getSession().createQuery("      from Stage s " +
                                           "join fetch s.capsCase " +
                                           "     where s.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (Stage) firstResult(query);
  }

  public Stage findStageByIdStage(int idStage) {
    Query query = getSession().createQuery("  from Stage " +
                                           "  where idStage = :idStage ");

    query.setInteger("idStage", idStage);
    return (Stage) firstResult(query);
  }
  
  public String findNmStageByIdStage(int idStage) {
    Query query = getSession().createQuery("  select nmStage from Stage " +
                                           "  where idStage = :idStage ");

    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }
  
  
  //STGAP00013002: wrote this method to find cdStage from idStage
  public String findCdStageByIdStage(int idStage) {
    Query query = getSession().createQuery("  select cdStage from Stage " +
                                           "  where idStage = :idStage ");

    query.setInteger("idStage", idStage);
    return (String) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findStagesByIdCase(int idCase) {

    Query query = getSession().createQuery("    from Stage s " +
                                           "   where s.capsCase.idCase = :idCase " +
                                           "order by s.situation.idSituation, " +
                                           "         s.dtStageStart desc");

    query.setInteger("idCase", idCase);

    return (List<Stage>) query.list();
  }  
  
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findStagesNotHaveWTLP(int idCase, Collection<Integer> principalsForEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_STAGE as idStage " +
                                              "  FROM (SELECT DISTINCT S.ID_STAGE " +
                                              "          FROM EVENT E, " +
                                              "               STAGE S, " +
                                              "               STAGE_PERSON_LINK SPL, " +
                                              "               PERSON P " +
                                              "         WHERE S.ID_CASE = :idCase " +
                                              "           AND (S.CD_STAGE = 'SUB' " +
                                              "                 OR S.CD_STAGE = 'ADO') " +
                                              "           AND E.ID_EVENT_STAGE = S.ID_STAGE " +
                                              "           AND E.ID_EVENT_STAGE = SPL.ID_STAGE " +
                                              "           AND SPL.ID_PERSON = P.ID_PERSON " +
                                              "           AND SPL.ID_PERSON IN (:principalsForEvent) " +
                                              "           AND SPL.CD_STAGE_PERS_ROLE = 'PC' " +
                                              "           AND MONTHS_BETWEEN(SYSDATE,P.DT_PERSON_BIRTH) >= 168) " +
                                              " WHERE NOT EXISTS (SELECT 'x' " +
                                              "                 FROM EVENT EV " +
                                              "                WHERE EV.ID_EVENT_STAGE = ID_STAGE " +
                                              "                  AND EV.CD_EVENT_TYPE = 'WTL')" );
    
    query.setInteger("idCase", idCase);
    query.setParameterList("principalsForEvent", principalsForEvent);
    query.addScalar("idStage", Hibernate.INTEGER);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findStagesNotHaveChildDetailCompleted(int idCase, Collection<Integer> principalsForEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT ID_STAGE as idStage " +
                                              "  FROM (SELECT DISTINCT S.ID_STAGE " +
                                              "          FROM EVENT E, " +
                                              "               STAGE S, " +
                                              "               STAGE_PERSON_LINK SPL " +
                                              "         WHERE S.ID_CASE = :idCase " +
                                              "           AND (S.CD_STAGE = 'SUB' " +
                                              "                 OR S.CD_STAGE = 'ADO') " +
                                              "           AND E.ID_EVENT_STAGE = S.ID_STAGE " +
                                              "           AND E.ID_EVENT_STAGE = SPL.ID_STAGE " +
                                              "           AND SPL.ID_PERSON IN (:principalsForEvent) " +
                                              "           AND SPL.CD_STAGE_PERS_ROLE = 'PC') " +
                                              " WHERE NOT EXISTS (SELECT 1 " +
                                              "                 FROM EVENT EV " +
                                              "                WHERE EV.ID_EVENT_STAGE = ID_STAGE " +
                                              "                  AND EV.CD_EVENT_TYPE = 'CSP') " +
                                              "    OR EXISTS (SELECT 1 " +
                                              "                     FROM EVENT EV2 " +
                                              "                    WHERE EV2.ID_EVENT_STAGE = ID_STAGE " +
                                              "                      AND EV2.CD_EVENT_TYPE = 'CSP' " +
                                              "                      AND EV2.CD_EVENT_STATUS <> 'COMP')" );
    query.setInteger("idCase", idCase);
    query.setParameterList("principalsForEvent", principalsForEvent);
    query.addScalar("idStage", Hibernate.INTEGER);
    return (List<Integer>) query.list();
  }

 /* public Map findStageByIdStageAndIdPersonAndRole(int idStage) {

    Query query = getSession().createQuery("select new map (a.idStage as idStage, " +
                                           "                a.cdStage as cdStage, " +
                                           "                a.cdStageProgram as cdStageProgram, " +
                                           "                a.cdStageCnty as cdStageCnty, " +
                                           "                a.nmStage as nmStage, " +
                                           "                a.capsCase.idCase as idCase, " +
                                           "                b.nmPersonFull as nmPersonFull, " +
                                           "                c.person.idPerson as idPerson, " +
                                           "                c.cdStagePersRole as cdStagePersRole, " +
                                           "                c.idStagePersonLink as idStagePersonLink, " +
                                           "                c.dtLastUpdate as dtLastUpdate) " +
                                           "   from Stage a, " +
                                           "        Person b, " +
                                           "        StagePersonLink c " +
                                           "  where a.idStage = :idStage " +
                                           "    and a.idStage = c.stage " +
                                           "    and c.cdStagePersRole =  NVL((Select spl1.cdStagePersRole from StagePersonLink spl1 " +
                                           "                             where spl1.idStage = :idStage and spl1.cdStagePersRole = 'PR') , " +
                                           "                             (Select spl2.cdStagePersRole from StagePersonLink spl2 " +
                                           "                             where spl2.idStage = :idStage and spl2.cdStagePersRole = 'HP')) " +
                                           "    and c.person.idPerson = b.idPerson");

    query.setInteger("idStage", idStage);
    return (Map) firstResult(query);
  }*/
  
  public Integer findStageByIdStageAndIdPersonAndRole(int idStage) {

    Query query = getSession().createSQLQuery("select c.ID_PERSON as idPerson " + 
                                              "   from Stage a, " + 
                                              "         Person b, " + 
                                              "          Stage_Person_Link c " + 
                                              "   where a.ID_STAGE = :idStage " +
                                              "     and a.ID_STAGE = c.ID_STAGE " +
                                              "     and c.CD_STAGE_PERS_ROLE =  " +
                                              "                               NVL((Select spl1.CD_STAGE_PERS_ROLE " +
                                              "                               from Stage_Person_Link spl1 " +
                                              "                               where spl1.id_stage = :idStage " +
                                              "                               and spl1.CD_STAGE_PERS_ROLE = 'PR') , " + 
                                              "                               (Select spl2.CD_STAGE_PERS_ROLE " +
                                              "                               from Stage_Person_Link spl2 " +
                                              "                               where spl2.id_stage = :idStage " +
                                              "                               and spl2.CD_STAGE_PERS_ROLE = 'HP')) " +  
                                              "    and c.ID_PERSON = b.ID_PERSON");

    query.setInteger("idStage", idStage);
    BigDecimal result = (BigDecimal)firstResult(query);
    return (result != null ? result.intValue() : 0);
  }

  @SuppressWarnings({"unchecked"})
  public Integer findStageIdCaseByIdStage(int idStage) {

    Query query = getSession().createQuery(" select s.capsCase.idCase " +
                                           "   from Stage s " +
                                           "  where s.idStage = :idStage ");

    query.setInteger("idStage", idStage);

    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findStageByIdCaseDtStageClose(int idCase) {

    Query query = getSession().createQuery(" select new map(s.idStage as idStage, " +
                                           "                s.cdStage as cdStage) " +
                                           "   from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +                                          
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :dtStageClose) ");
    
    query.setInteger("idCase", idCase);
    query.setTimestamp("dtStageClose", DateHelper.MAX_JAVA_DATE);

    return (List<Map>) query.list();
  }

  public long countOpenStagesByIdPersonAndIdStages(int idPerson) {

    Query query = getSession().createQuery("select count(*) " +
                                           "   from Stage s, " +
                                           "        StagePersonLink spl " +
                                           "  where spl.person.idPerson = :idPerson " +
                                           "    and spl.stage = s.idStage " +
                                           "    and spl.cdStagePersType != 'stf'" +
                                           "    and ( s.dtStageClose is null )");

    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Stage> findStageByIdPerson(int idPerson, int pageNbr, int pageSize) {
    Query query = getSession().createQuery(" select sl.stage  " +
                                           "   from StagePersonLink sl " +
                                           "  where sl.person.idPerson = :idPerson " +
                                           "    and sl.cdStagePersRole = '" + CodesTables.CROLEALL_PC +
                                           "' ");
    query.setInteger("idPerson", idPerson);
    return (PaginatedHibernateList<Stage>) paginatedList(pageNbr, pageSize, query);
  }

  public Date findStageDtLastUpdate(int idStage) {
    Query query = getSession().createQuery("select dtLastUpdate " +
                                           "   from Stage " +
                                           "  where idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (Date) firstResult(query);
  }

  public long countStageByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from Stage a , " +
                                           "        StagePersonLink b " +
                                           "  where a.capsCase.idCase = :idCase " +
                                           "    and a.idStage = b.stage.idStage " +
                                           "    and b.capsCase.idCase = :idCase " +
                                           "    and b.person.idPerson = :idPerson " +
                                           "    and b.cdStagePersRole = 'CodesTables.CROLEALL_PR' ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public String findCdStageByIdCase(int idCase) {
    Query query = getSession().createQuery("select cdStage " +
                                           "   from Stage " +
                                           "  where capsCase.idCase = :idCase " +
                                           "    and cdStage = '" + CodesTables.CSTAGES_PAD + "'");

    query.setInteger("idCase", idCase);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findStageByIdStageAndOrderByCdStagePersRole(int idStage) {
    Query query = getSession().createQuery("  select new map(a.idStage as idStage , " +
                                           "                a.cdStage as cdStage, " +
                                           "                a.cdStageProgram as cdStageProgram, " +
                                           "                a.cdStageType as cdStageType , " +
                                           "                a.cdStageCnty as cdStageCnty, " +
                                           "                a.nmStage as nmStage, " +
                                           "                a.capsCase.idCase as idCase, " +
                                           "                b.nmPersonFull as nmPersonFull, " +
                                           "                c.person.idPerson as idPerson, " +
                                           "                c.cdStagePersRole as cdStagePersRole, " +
                                           "                c.idStagePersonLink as idStagePersonLink, " +
                                           "                c.dtLastUpdate as dtLastUpdate, " +
                                           "                a.capsCase.nmCase as nmCase) " +
                                           "   from   Stage a , " +
                                           "          Person b , " +
                                           "          StagePersonLink c " +
                                           "left join a.capsCase " +
                                           "  where   a.idStage = :idStage " +
                                           "    and   a.idStage = c.stage.idStage " +
                                           "    and   c.person.idPerson = b.idPerson " +
                                           "    and   c.cdStagePersType = '" +
                                           CodesTables.CPRSNALL_STF + "' " +
                                           "order by  c.cdStagePersRole ");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findCPSCaseSummaryStages(int idCase, String cdStagePersRole,
                                                                   String scrCdStagePersRole, int pageNbr,
                                                                   int pageSize) {
    SQLQuery query = getSession().createSQLQuery(" SELECT S.NM_STAGE, " +
                                                 "         S.CD_STAGE, " +
                                                 "         S.DT_STAGE_START, " +
                                                 "         S.DT_STAGE_CLOSE, " +
                                                 "         S.CD_STAGE_CNTY, " +
                                                 "         S.CD_STAGE_PROGRAM, " +
                                                 "         S.ID_SITUATION, " +
                                                 "         S.ID_STAGE, " +
                                                 "         S.CD_STAGE_REASON_CLOSED, " +
                                                 "         S.IND_ECS_VER, " +
                                                 "         SPL.ID_PERSON, " +
                                                 "         P.NM_PERSON_FULL, " +
                                                 "         S.IND_STAGE_CLOSE, " +
                                                 "         S.IND_RED_FLAG" +
                                                 "    FROM STAGE S, " +
                                                 "         STAGE_PERSON_LINK SPL, " +
                                                 "         PERSON P " +
                                                 "    WHERE SPL.ID_STAGE = S.ID_STAGE " +
                                                 "    AND S.ID_CASE = :idCase " +
                                                 "    AND P.ID_PERSON=SPL.ID_PERSON " +
                                                 "    AND (SPL.CD_STAGE_PERS_ROLE = :cdStagePersRole " +
                                                 "           OR SPL.CD_STAGE_PERS_ROLE = :scrCdStagePersRole) " +
                                                 "    ORDER BY S.ID_SITUATION DESC, " +
                                                 "         S.ID_STAGE DESC");
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("scrCdStagePersRole", scrCdStagePersRole);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }
  
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findCPSSealedCaseSummaryStages(int idCase, String cdStagePersRole,
                                                                   String scrCdStagePersRole, int pageNbr,
                                                                   int pageSize) {
    SQLQuery query = getSession().createSQLQuery(" SELECT S.NM_STAGE, " +
                                                 "         S.CD_STAGE, " +
                                                 "         S.DT_STAGE_START, " +
                                                 "         S.DT_STAGE_CLOSE, " +
                                                 "         S.CD_STAGE_CNTY, " +
                                                 "         S.CD_STAGE_PROGRAM, " +
                                                 "         S.ID_SITUATION, " +
                                                 "         S.ID_STAGE, " +
                                                 "         S.CD_STAGE_REASON_CLOSED, " +
                                                 "         S.IND_ECS_VER, " +
                                                 "         SPL.ID_PERSON, " +
                                                 "         P.NM_PERSON_FULL, " +
                                                 "         S.IND_STAGE_CLOSE, " +
                                                 "         S.IND_RED_FLAG " +                                                 
                                                 "    FROM STAGE S, " +
                                                 "         STAGE_PERSON_LINK SPL, " +
                                                 "         PERSON P " +
                                                 "    WHERE SPL.ID_STAGE = S.ID_STAGE " +
                                                 "    AND S.ID_CASE = :idCase " +
                                                 "    AND P.ID_PERSON=SPL.ID_PERSON " +
                                                 "    AND (SPL.CD_STAGE_PERS_ROLE = :cdStagePersRole " +
                                                 "           OR SPL.CD_STAGE_PERS_ROLE = :scrCdStagePersRole) " +
                                                 "    AND (S.IND_STAGE_SEALED is null " +
                                                 "           OR S.IND_STAGE_SEALED <> 'Y' " +
                                                 "           OR S.CD_STAGE = '" + CodesTables.CSTAGES_FAD + "') " +                                                 
                                                 "    ORDER BY S.ID_SITUATION DESC, " +
                                                 "         S.ID_STAGE DESC");
    query.setInteger("idCase", idCase);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("scrCdStagePersRole", scrCdStagePersRole);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findStageStagePersonLinkByIdStageAndIdStageRelated(int idStage, int idStageRelated) {
    SQLQuery query = getSession().createSQLQuery("SELECT S.ID_STAGE, " +
                                                 "       S.DT_LAST_UPDATE, " +
                                                 "       S.CD_STAGE_TYPE, " +
                                                 "       S.ID_UNIT, " +
                                                 "       S.ID_CASE, " +
                                                 "       S.ID_SITUATION, " +
                                                 "       S.DT_STAGE_CLOSE, " +
                                                 "       S.CD_STAGE_CLASSIFICATION, " +
                                                 "       S.CD_STAGE_CURR_PRIORITY, " +
                                                 "       S.CD_STAGE_INITIAL_PRIORITY, " +
                                                 "       S.CD_STAGE_REASON_CLOSED, " +
                                                 "       S.CD_STAGE_RSN_PRIORITY_CHGD, " +
                                                 "       S.IND_STAGE_CLOSE, " +
                                                 "       S.CD_STAGE_CNTY, " +
                                                 "       S.NM_STAGE, " +
                                                 "       S.CD_STAGE_REGION, " +
                                                 "       S.DT_STAGE_START, " +
                                                 "       S.CD_STAGE_PROGRAM, " +
                                                 "       S.CD_STAGE, " +
                                                 "       S.TXT_STAGE_PRIORITY_CMNTS, " +
                                                 "       S.TXT_STAGE_CLOSURE_CMNTS, " +
                                                 "       SPL1.ID_STAGE_PERSON_LINK, " +
                                                 "       SPL1.DT_LAST_UPDATE, " +
                                                 "       SPL1.ID_PERSON, " +
                                                 "       SPL1.CD_STAGE_PERS_ROLE, " +
                                                 "       SPL1.IND_STAGE_PERS_IN_LAW, " +
                                                 "       SPL1.CD_STAGE_PERS_TYPE, " +
                                                 "       SPL1.CD_STAGE_PERS_SEARCH_IND, " +
                                                 "       SPL1.TXT_STAGE_PERS_NOTES, " +
                                                 "       SPL1.DT_STAGE_PERS_LINK, " +
                                                 "       SPL1.CD_STAGE_PERS_REL_INT, " +
                                                 "       SPL1.IND_STAGE_PERS_REPORTER, " +
                                                 "       SPL1.IND_STAGE_PERS_EMP_NEW " +
                                                 "   FROM STAGE S,STAGE_PERSON_LINK SPL1, STAGE_PERSON_LINK SPL2 " +
                                                 "  WHERE S.ID_STAGE = SPL1.ID_STAGE " +
                                                 "        AND SPL1.CD_STAGE_PERS_TYPE != 'STF' " +
                                                 "        AND S.ID_STAGE = :idStage " +
                                                 "        AND SPL1.ID_PERSON = SPL2.ID_PERSON (+) " +
                                                 "        AND SPL2.CD_STAGE_PERS_TYPE (+)  != 'STF' " +
                                                 "        AND SPL2.ID_PERSON IS NULL " +
                                                 "        AND SPL2.ID_STAGE (+)  = :idStageRelated ");
    query.setInteger("idStage", idStage);
    query.setInteger("idStageRelated", idStageRelated);
    return (List<Object[]>) query.list();
  }

  public void saveStage(Stage stage) {
    getSession().saveOrUpdate(stage);
  }

  public int updateStage(Date dtStageClose, String cdStageReasonClosed, String txtStageClosureCmnts, Date lastUpdate,
                         int idStage) {
    Query query = getSession().createQuery(" update Stage " +
                                           "    set dtStageClose= " +
                                           "        :dtStageClose, " +
                                           "        cdStageReasonClosed= " +
                                           "        :cdStageReasonClosed, " +
                                           "        txtStageClosureCmnts= " +
                                           "        :txtStageClosureCmnts " +
                                           "  where dtLastUpdate = :lastUpdate " +
                                           "    and idStage = :idStage ");
    query.setTimestamp("dtStageClose", dtStageClose);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setString("txtStageClosureCmnts", txtStageClosureCmnts);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIntakeStageByIdStageAndDtLastUpdate(int idUnit, String cdStageClassification,
                                                       String cdStageCurrPriority, String cdStageInitialPriority,
                                                       String cdStageRsnPriorityChgd, String cdStageReasonClosed,
                                                       String nmStage, Date dtIncomingCall, String cdStageProgram,
                                                       String cdStage, String cdStageScroutReason,
                                                       String txtStageSplInstrtCmnt, int idStage, Date tsLastUpdate,
                                                       String txtStagePriorityCmnts) {
    Query query = getSession().createQuery("update Stage set unit.idUnit = :idUnit, " +
                                           "cdStageClassification = :cdStageClassification, " +
                                           "cdStageCurrPriority = :cdStageCurrPriority, " +
                                           "cdStageInitialPriority = :cdStageInitialPriority, " +
                                           "cdStageRsnPriorityChgd = :cdStageRsnPriorityChgd, " +
                                           "cdStageReasonClosed = :cdStageReasonClosed, " +
                                           "nmStage = :nmStage, " +
                                           "dtStageStart = :dtIncomingCall, " +
                                           "cdStageProgram = :cdStageProgram, " +
                                           "cdStage = :cdStage, " +
                                           "cdStageScroutReason = :cdStageScroutReason, " +
                                           "txtStageSplInstrtCmnt = :txtStageSplInstrtCmnt, " +
                                           "txtStagePriorityCmnts = :txtStagePriorityCmnts " +
                                           "where idStage = :idStage and dtLastUpdate = :tsLastUpdate ");

    query.setInteger("idUnit", idUnit);
    query.setString("cdStageClassification", cdStageClassification);
    query.setString("cdStageCurrPriority", cdStageCurrPriority);
    query.setString("cdStageInitialPriority", cdStageInitialPriority);
    query.setString("cdStageRsnPriorityChgd", cdStageRsnPriorityChgd);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setString("nmStage", nmStage);
    query.setTimestamp("dtIncomingCall", dtIncomingCall);
    query.setString("cdStageProgram", cdStageProgram);
    query.setString("cdStage", cdStage);
    query.setString("cdStageScroutReason", cdStageScroutReason);
    query.setString("txtStageSplInstrtCmnt", txtStageSplInstrtCmnt);
    query.setString("txtStagePriorityCmnts", txtStagePriorityCmnts);
    query.setInteger("idStage", idStage);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);

    return query.executeUpdate();
  }

  public int updateStageCdStageRegioncCStageCntyByIdStage(int idStage, String cdStageRegion, String cdStageCnty) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set cdStageRegion = :cdStageRegion, " +
                                           "        cdStageCnty = :cdStageCnty " +
                                           "  where idStage = :idStage");

    query.setInteger("idStage", idStage);
    query.setString("cdStageRegion", cdStageRegion);
    query.setString("cdStageCnty", cdStageCnty);
    return query.executeUpdate();
  }

  public int updateStageIdUnitCdStageRegionByIdUnit(int idUnit) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set unit.idUnit = null, " +
                                           "        cdStageRegion = null " +
                                           "  where unit.idUnit = :idUnit");

    query.setInteger("idUnit", idUnit);
    return query.executeUpdate();
  }

  public int updateStageIdUnitByIdStageAndUnitEmpLinkIdUnit(int idStage, int idPerson) {
    Query query = getSession().createQuery("update Stage s " +
                                           "    set s.unit.idUnit = (select u.unit.idUnit " +
                                           "                           from UnitEmpLink u " +
                                           "                          where u.person.idPerson = :idPerson " +
                                           "                            and u.cdUnitMemberInOut = 'IN') " +
                                           "  where s.idStage = :idStage");

    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int updateStageIdUnitByIdStage(int idUnit, int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set unit.idUnit = :idUnit " +
                                           "  where idStage = :idStage");

    query.setInteger("idUnit", idUnit);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStageDtStageCloseCdStageReasonClosed(Date dtStageClose, String cdStageReasonClosed, int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set dtStageClose = :dtStageClose, " +
                                           "        cdStageReasonClosed = :cdStageReasonClosed " +
                                           "  where idStage = :idStage");
    query.setTimestamp("dtStageClose", dtStageClose);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStageNmStage(String nmCase, int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set nmStage = :nmCase " +
                                           "  where idStage = :idStage");
    query.setString("nmCase", nmCase);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStage(String nmStage, String nmPersonFull, int idPerson, Date maxDate) {
    Query query = getSession().createQuery("update Stage s1 " +
                                           "    set s1.nmStage = :nmStage " +
                                           "  where s1.nmStage = :nmPersonFull " +
                                           "    and s1.idStage in (select s2.idStage " +
                                           "                         from Stage s2, " +
                                           "                              StagePersonLink l " +
                                           "                        where l.person.idPerson = :idPerson " +
                                           "                          and s2.idStage = l.stage.idStage " +
                                           "                          and (s2.cdStageProgram = 'aps'" +
                                           "                                or s2.cdStageProgram = 'afc') " +
                                           "                          and (s2.dtStageClose is null " +
                                           "                                or s2.dtStageClose = :maxDate) " +
                                           "                          and l.cdStagePersRole in ('vc', " +
                                           "                                                    'vp', " +
                                           "                                                    'db', " +
                                           "                                                    'dv', " +
                                           "                                                    'cl', " +
                                           "                                                    'uk', " +
                                           "                                                    'no'))");
    query.setString("nmStage", nmStage);
    query.setString("nmPersonFull", nmPersonFull);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", maxDate);

    return query.executeUpdate();
  }

  public int insertStageWithIdCase(int idStage, String cdStageType, Integer idCase, Date dtStageClose,
                                   String cdStageClassification, String cdStageCurrPriority,
                                   String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                   String cdStageReasonClosed, String indStageClose, String cdTxtStagePriorityCmnts,
                                   String cdStageCnty, String cdNmStage, String cdStageRegion, Date dtStageStart,
                                   Integer idSituation, String cdStageProgram, String cdStage,
                                   String cdTxtStageClosureCmnts, int idUnit, String cdStageScroutReason,
                                   String cdTxtStageSplInstrtCmnt) {
    SQLQuery query = getSession().createSQLQuery(
            "INSERT INTO STAGE (ID_STAGE, " +
            "                   CD_STAGE_TYPE, " +
            "                   ID_CASE, " +
            "                   DT_STAGE_CLOSE, " +
            "                   CD_STAGE_CLASSIFICATION, " +
            "                   CD_STAGE_CURR_PRIORITY, " +
            "                   CD_STAGE_INITIAL_PRIORITY, " +
            "                   CD_STAGE_RSN_PRIORITY_CHGD, " +
            "                   CD_STAGE_REASON_CLOSED, " +
            "                   IND_STAGE_CLOSE, " +
            "                   TXT_STAGE_PRIORITY_CMNTS, " +
            "                   CD_STAGE_CNTY, " +
            "                   NM_STAGE, " +
            "                   CD_STAGE_REGION, " +
            "                   DT_STAGE_START, " +
            "                   ID_SITUATION, " +
            "                   CD_STAGE_PROGRAM, " +
            "                   CD_STAGE, " +
            "                   TXT_STAGE_CLOSURE_CMNTS, " +
            "                   ID_UNIT, " +
            "                   CD_STAGE_SCROUT_REASON, " +
            "                    TXT_STAGE_SPL_INSTRT_CMNT) " +
            "  VALUES (:idStage, " +
            "          :cdStageType, " +
            "          :idCase, " +
            "          :dtStageClose, " +
            "          :cdStageClassification, " +
            "          :cdStageCurrPriority, " +
            "          :cdStageInitialPriority, " +
            "          :cdStageRsnPriorityChgd, " +
            "          :cdStageReasonClosed, " +
            "          :indStageClose, " +
            "          :cdTxtStagePriorityCmnts,  " +
            "          :cdStageCnty, " +
            "          :cdNmStage, " +
            "          :cdStageRegion, " +
            "          :dtStageStart, " +
            "          :idSituation, " +
            "          :cdStageProgram, " +
            "          :cdStage, " +
            "          :cdTxtStageClosureCmnts, " +
            "          :idUnit, " +
            "          :cdStageScroutReason, " +
            "          :cdTxtStageSplInstrtCmnt)");

    query.setInteger("idStage", idStage);
    query.setString("cdStageType", cdStageType);
    query.setParameter("idCase", idCase, Hibernate.INTEGER);
    query.setTimestamp("dtStageClose", dtStageClose);
    query.setString("cdStageClassification", cdStageClassification);
    query.setString("cdStageCurrPriority", cdStageCurrPriority);
    query.setString("cdStageInitialPriority", cdStageInitialPriority);
    query.setString("cdStageRsnPriorityChgd", cdStageRsnPriorityChgd);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setString("indStageClose", indStageClose);
    query.setString("cdTxtStagePriorityCmnts", cdTxtStagePriorityCmnts);
    query.setString("cdStageCnty", cdStageCnty);
    query.setString("cdNmStage", cdNmStage);
    query.setString("cdStageRegion", cdStageRegion);
    query.setTimestamp("dtStageStart", dtStageStart);
    query.setParameter("idSituation", idSituation, Hibernate.INTEGER);
    query.setString("cdStageProgram", cdStageProgram);
    query.setString("cdStage", cdStage);
    query.setString("cdTxtStageClosureCmnts", cdTxtStageClosureCmnts);
    query.setInteger("idUnit", idUnit);
    query.setString("cdStageScroutReason", cdStageScroutReason);
    query.setString("cdTxtStageSplInstrtCmnt", cdTxtStageSplInstrtCmnt);

    return query.executeUpdate();
  }

  // STGAP00008086 - Added CdStageScroutReason as a parameter and to the list
  // of fields being set by this update routine, since the Intake Closure
  // page provides a drop down for updating the screen out reason.
  public int updateStageByIdStageAndDtLastUpdate(String cdStageType, String cdStageCurrPriority,
                                                 String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                                 String cdStageReasonClosed, String txtStagePriorityCmnts,
                                                 String txtStageClosureCmnts, Date tsLastUpdate, 
                                                 String cdStageScroutReason, int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set cdStageType = :cdStageType, " +
                                           "        cdStageCurrPriority = :cdStageCurrPriority, " +
                                           "        cdStageInitialPriority = :cdStageInitialPriority, " +
                                           "        cdStageRsnPriorityChgd = :cdStageRsnPriorityChgd, " +
                                           "        cdStageReasonClosed = :cdStageReasonClosed, " +
                                           "        txtStagePriorityCmnts = :txtStagePriorityCmnts, " +
                                           "        txtStageClosureCmnts = :txtStageClosureCmnts, " +
                                           "        cdStageScroutReason = :cdStageScroutReason " +
                                           "  where idStage = :idStage " +
                                           "    and dtLastUpdate = :tsLastUpdate");
    query.setString("cdStageType", cdStageType);
    query.setString("cdStageCurrPriority", cdStageCurrPriority);
    query.setString("cdStageInitialPriority", cdStageInitialPriority);
    query.setString("cdStageRsnPriorityChgd", cdStageRsnPriorityChgd);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setString("txtStagePriorityCmnts", txtStagePriorityCmnts);
    query.setString("txtStageClosureCmnts", txtStageClosureCmnts);
    query.setString("cdStageScroutReason", cdStageScroutReason);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }
  
  // STGAP00009014 - Created this method to update the stage table when  
  // Saving from the IntakeClosure Page.
  
  public int updateStageByIdStageAndDtLastUpdateAndResTimeCmnts(String cdStageType, String cdStageCurrPriority,
                                                 String cdStageInitialPriority, String cdStageRsnPriorityChgd,
                                                 String cdStageReasonClosed, String txtStageResponseTimeCmnts,
                                                 String txtStageClosureCmnts, Date tsLastUpdate, 
                                                 String cdStageScroutReason, int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set cdStageType = :cdStageType, " +
                                           "        cdStageCurrPriority = :cdStageCurrPriority, " +
                                           "        cdStageInitialPriority = :cdStageInitialPriority, " +
                                           "        cdStageRsnPriorityChgd = :cdStageRsnPriorityChgd, " +
                                           "        cdStageReasonClosed = :cdStageReasonClosed, " +
                                           "        txtStageResponseTimeCmnts = :txtStageResponseTimeCmnts, " +
                                           "        txtStageClosureCmnts = :txtStageClosureCmnts, " +
                                           "        cdStageScroutReason = :cdStageScroutReason " +
                                           "        where idStage = :idStage " +
                                           "        and dtLastUpdate = :tsLastUpdate");
    query.setString("cdStageType", cdStageType);
    query.setString("cdStageCurrPriority", cdStageCurrPriority);
    query.setString("cdStageInitialPriority", cdStageInitialPriority);
    query.setString("cdStageRsnPriorityChgd", cdStageRsnPriorityChgd);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setString("txtStageResponseTimeCmnts", txtStageResponseTimeCmnts);
    query.setString("txtStageClosureCmnts", txtStageClosureCmnts);
    query.setString("cdStageScroutReason", cdStageScroutReason);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }

  public int updateStageWithIdCase(String cdStageType, int idCase, Date dtStageClose, String cdStageClassification,
                                   String cdStageCurrPriority, String cdStageInitialPriority,
                                   String cdStageRsnPriorityChgd, String cdStageReasonClosed, String indStageClose,
                                   String cdTxtStagePriorityCmnts, String cdStageCnty, String cdNmStage,
                                   String cdStageRegion, Date dtStageStart, int idSituation, String cdStageProgram,
                                   String cdStage, String cdTxtStageClosureCmnts, int idUnit, int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set cdStageType = :cdStageType, " +
                                           "        capsCase.idCase = :idCase, " +
                                           "        dtStageClose = :dtStageClose, " +
                                           "        cdStageClassification = :cdStageClassification, " +
                                           "        cdStageCurrPriority = :cdStageCurrPriority, " +
                                           "        cdStageInitialPriority = :cdStageInitialPriority, " +
                                           "        cdStageRsnPriorityChgd = :cdStageRsnPriorityChgd, " +
                                           "        cdStageReasonClosed = :cdStageReasonClosed, " +
                                           "        indStageClose = :indStageClose, " +
                                           "        txtStagePriorityCmnts = :cdTxtStagePriorityCmnts, " +
                                           "        cdStageCnty = :cdStageCnty, " +
                                           "        nmStage = :cdNmStage, " +
                                           "        cdStageRegion = :cdStageRegion, " +
                                           "        dtStageStart = :dtStageStart, " +
                                           "        situation.idSituation = :idSituation, " +
                                           "        cdStageProgram = :cdStageProgram, " +
                                           "        cdStage = :cdStage, " +
                                           "        txtStageClosureCmnts = :cdTxtStageClosureCmnts, " +
                                           "        unit.idUnit = :idUnit " +
                                           "  where idStage = :idStage");

    query.setString("cdStageType", cdStageType);
    query.setInteger("idCase", idCase);
    query.setTimestamp("dtStageClose", dtStageClose);
    query.setString("cdStageClassification", cdStageClassification);
    query.setString("cdStageCurrPriority", cdStageCurrPriority);
    query.setString("cdStageInitialPriority", cdStageInitialPriority);
    query.setString("cdStageRsnPriorityChgd", cdStageRsnPriorityChgd);
    query.setString("cdStageReasonClosed", cdStageReasonClosed);
    query.setString("indStageClose", indStageClose);
    query.setString("cdTxtStagePriorityCmnts", cdTxtStagePriorityCmnts);
    query.setString("cdStageCnty", cdStageCnty);
    query.setString("cdNmStage", cdNmStage);
    query.setString("cdStageRegion", cdStageRegion);
    query.setTimestamp("dtStageStart", dtStageStart);
    query.setInteger("idSituation", idSituation);
    query.setString("cdStageProgram", cdStageProgram);
    query.setString("cdStage", cdStage);
    query.setString("cdTxtStageClosureCmnts", cdTxtStageClosureCmnts);
    query.setInteger("idUnit", idUnit);
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }

  public int deleteStage(int idStage) {
    Query query = getSession().createQuery("delete from Stage s " +
                                           "       where s.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStage(Date dtStageStart, int idStage) {
    Query query = getSession().createQuery(" update Stage " +
                                           "    set dtStageStart = :dtStageStart " +
                                           "  where idStage = :idStage");
    query.setTimestamp("dtStageStart", dtStageStart);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStageCdStageCnty(int idStage, String cdStageCnty) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set cdStageCnty = :cdStageCnty " +
                                           "  where idStage = :idStage ");
    query.setString("cdStageCnty", cdStageCnty);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStageSetCdStageReasonClosed(int idStage) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set cdStageReasonClosed = null " +
                                           "  where idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
  public int updateStageIndEcsVerified(int idStage, String indEcsVer) {
	Query query = getSession().createQuery("update Stage " +
                                           "  set indEcsVer = :indEcsVer " +
                                           "where idStage = :idStage");
    query.setString("indEcsVer", indEcsVer);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateStageIndRedFlag(int idStage, String indRedFlag) {
    Query query = getSession().createQuery("update Stage " +
                                       "  set indRedFlag = :indRedFlag " +
                                       "where idStage = :idStage");
    query.setString("indRedFlag", indRedFlag);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findStageByIdPersonInput(int idPerson) {
    Query query = getSession().createQuery("  select  new map( sl.stage.idStage as idStage, " +
                                           "          sl.cdStagePersType as cdStagePersType, " +
                                           "          sl.cdStagePersRelInt as cdStagePersRelInt, " +
                                           "          s.dtStageStart as dtStageStart, " +
                                           "          s.dtStageClose as dtStageClose, " +
                                           "          s.cdStage as cdStage, " +
                                           "          s.cdStageType as cdStageType, " +
                                           "          s.nmStage as nmStage, " +
                                           "          s.capsCase.idCase as idCase, " +
                                           "          c.nmCase as nmCase, " +
                                           "          c.dtCaseOpened as dtCaseOpened, " +
                                           "          c.dtCaseClosed as dtCaseClosed ) " +
                                           "     from StagePersonLink sl, " +
                                           "          PersonMergeView v, " +
                                           "          Stage s " +
                                           "          left join s.capsCase c " +
                                           "    where v.id.idPersonInput = :idPerson " +
                                           "      and sl.person.idPerson = v.id.idPersonOutput " +
                                           "      and s.idStage = sl.stage.idStage " +
                                           " order by c.dtCaseOpened, " +
                                           "          c.dtCaseClosed, " +
                                           "          s.dtStageStart, " +
                                           "          s.dtStageClose");
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public Integer findStageByStageByIdPriorStage(String cdStage, int idPriorStage, int idPerson,
                                                String cdStagePersRole) {

    Query query = getSession().createQuery(" select s.idStage" +
                                           "   from Stage s," +
                                           "        StagePersonLink spl," +
                                           "        StageLink sl" +
                                           "  where spl.stage.idStage = s.idStage" +
                                           "    and sl.stageByIdStage = s.idStage" +
                                           "    and s.cdStage = :cdStage" +
                                           "    and sl.stageByIdPriorStage.idStage = :idPriorStage" +
                                           "    and spl.person.idPerson = :idPerson" +
                                           "    and spl.cdStagePersRole = :cdStagePersRole ");

    query.setString("cdStage", cdStage);
    query.setInteger("idPriorStage", idPriorStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStagePersRole", cdStagePersRole);

    return (Integer) firstResult(query);
  }
  @SuppressWarnings({"unchecked"})
  public List<Map> findOpenStagesByIdCaseCdStage(int idCase, String cdStage) {

    Query query = getSession().createQuery(" select new map(s.idStage as idStage, " +
                                           "                s.cdStage as cdStage) " +
                                           "   from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "    and s.cdStage = :cdStage " +                                          
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate) ");
    
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (List<Map>) query.list();
  }
  
  // STGAP00017013: MR-095
  @SuppressWarnings( { "unchecked" })
  public List<Stage> findOpenStagesByIdCaseByIdPersonNotExistsInSPL(int idCase, int idStage, int idPerson,
                                                                    List<String> cdStages) {
    Query query = getSession().createQuery(
                                           " from Stage s " + " where s.capsCase.idCase = :idCase "
                                                           + " and (s.dtStageClose is null "
                                                           + "         or s.dtStageClose = :maxDate) "
                                                           + " and s.cdStage in (:cdStages) "
                                                           + " and s.idStage <> :idStage "
                                                           + " and not exists (select spl2.person.idPerson "
                                                           + " from StagePersonLink spl2 "
                                                           + " where spl2.person.idPerson = :idPerson "
                                                           + " and spl2.stage.idStage = s.idStage ) ");

    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdStages", cdStages);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (List<Stage>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findStagesByIdCaseCdStagesIdPrimary(int idCase, Collection<String> cdStages, int idPerson) {

    Query query = getSession().createQuery(" select new map(s.capsCase.idCase as idCase, "
                                                           + "                 s.cdStage as cdStage, "
                                                           + "                 s.idStage as idStage, "
                                                           + "                 s.nmStage as nmStage, "
                                                           + "                 s.dtStageStart as dtStageStart) " +
                                           "   from Stage s " +
                                           "  join s.capsCase c " +
                                           "  join s.stagePersonLinks spl  " +
                                           "  where c.idCase = :idCase "  +
                                           "  and s.cdStage in (:cdStages ) "  +
                                           "   and spl.cdStagePersRole = 'PC' "  +
                                           "      and spl.person.idPerson = :idPerson " );
    
    query.setInteger("idCase", idCase);
    query.setParameterList("cdStages", cdStages);
    query.setInteger("idPerson", idPerson);

    return (List<Map>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findOpenStagesByIdCaseCdStagesIdPrimary(Collection<String> cdStages, int idPerson, Date dtCaseSt) {

    Query query = getSession().createQuery(" select new map(s.capsCase.idCase as idCase, "
                                                           + "                 s.cdStage as cdStage, "
                                                           + "                 s.idStage as idStage, "
                                                           + "                 s.nmStage as nmStage, "
                                                           + "                 s.dtStageStart as dtStageStart) " +
                                           "   from Stage s " +
                                           "  join s.capsCase c " +
                                           "  join s.stagePersonLinks spl  " +
                                           "  where s.cdStage in (:cdStages ) "  +
                                           "   and spl.cdStagePersRole = 'PC' "  +
                                            " and (s.dtStageClose is null or s.dtStageClose = '' or " +
                                                   " s.dtStageClose   >= :dtCaseSt) " +
                                           "      and spl.person.idPerson = :idPerson " );
    query.setParameterList("cdStages", cdStages);
    query.setTimestamp("dtCaseSt", dtCaseSt);
    query.setInteger("idPerson", idPerson);
    
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findOpenStagesByIdCase(int idCase) {

    Query query = getSession().createQuery("  from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate) ");
    
    query.setInteger("idCase", idCase);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (List<Stage>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public String indStageClose(int idStage, int idCase) {

    Query query = getSession().createQuery("select s.indStageClose " +
                                           "  from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "    and s.idStage = :idStage ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);

    return (String) firstResult(query);
  }
  
  public String findStageCountyForPerson(int idPerson){
    Query query = getSession().createQuery(" select s.cdStageCnty " +
                                           " from Stage s, StagePersonLink spl " +
                                           " where s.idStage = spl.stage.idStage " +
                                           " and spl.person = :idPerson " +
                                           " order by s.dtLastUpdate desc");
    
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Stage> findOtherOpenStagesInCase(int idCase, int idStage) {

    Query query = getSession().createQuery("  from Stage s " +
                                           "  where s.idStage != :idStage " +
                                           "    and s.capsCase.idCase = :idCase " +
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate) ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (List<Stage>) query.list();
  }  
  
  @SuppressWarnings({"unchecked"})
  public int updateStageClearIdCaseAndIdSituationByIdStage(int idStage){
    Query query = getSession().createQuery(
                                     "update Stage s" + 
                                     "   set s.capsCase.idCase = null " +
                                     " , s.situation.idSituation = null" +
                                     " where s.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public long countOpenAdoStageByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery(" select count(*) " +
                                           "   from Stage a , " +
                                           "        StagePersonLink b " +
                                           "  where a.capsCase.idCase = :idCase " +
                                           "    and a.idStage = b.stage.idStage " +
                                           "    and b.capsCase.idCase = a.capsCase.idCase " +
                                           "    and b.person.idPerson = :idPerson " +
                                           "    and a.dtStageClose is null " +
                                           "    and a.cdStage  = '" + CodesTables.CSTAGES_ADO + 
                                           "' " +
                                           "    and b.cdStagePersRole = '" + CodesTables.CROLEALL_PC +
                                           "' ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }
  
  public Integer findStageByIdCaseIdPerson(int idCase, int idPerson, String cdStage){
    Query query = getSession().createQuery(
                                            "select s.idStage " +
                                            " from Stage s, StagePersonLink spl " +
                                            " where s.idStage = spl.stage.idStage " +
                                            " and s.capsCase.idCase = :idCase " +
                                            " and s.cdStage = :cdStage " +
                                            " and spl.person.idPerson = :idPerson");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    return (Integer)firstResult(query);
  }
  
  @SuppressWarnings({"unchecked"})
  public int updateStageMarkStageSealed(Collection idStageList){
    Query query = getSession().createQuery(
                                     "update Stage s " + 
                                     "   set s.indStageSealed = :indStageSealed, " +
                                     "   s.dtStageSealed = sysdate " +
                                     " where s.idStage in (:idStageList)");
    query.setParameterList("idStageList", idStageList);
    query.setString("indStageSealed", ArchitectureConstants.Y);
    return query.executeUpdate();
  }
  
  //STGAP00010749: Marks the stages in the passed collection as sensitive
  @SuppressWarnings({"unchecked"})
  public int updateStageMarkStageSensitive(Collection idStageList){
    Query query = getSession().createQuery(
                                     "update Stage s " + 
                                     "   set s.indStageSensitive = :indStageSensitive " +
                                     " where s.idStage in (:idStageList)");
    query.setParameterList("idStageList", idStageList);
    query.setString("indStageSensitive", ArchitectureConstants.Y);
    return query.executeUpdate();
  }
  
  //STGAP00010749 :Gets the list of open stages in a case
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdStagesOfOpenStagesByIdCase(int idCase) {

    Query query = getSession().createQuery("  select s.idStage from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate) ");
    
    query.setInteger("idCase", idCase);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (List<Integer>) query.list();
  }
  
  //STGAP00010749 : Save or update a stage record
  public int saveOrUpdateStage(Stage stage) {
    //Session session = getSession();
    getSession().saveOrUpdate(stage);
    //session.flush();
    return stage.getIdStage();
  }
  
  //STGAP00010749: Update the stage record with the id Situation and id Unit
  public int updateStageIdUnitByIdStageIdSituation(int idUnit, int idStage, int idSituation) {
    Query query = getSession().createQuery("update Stage " +
                                           "    set unit.idUnit = :idUnit, " +
                                           "    situation.idSituation = :idSituation " +
                                           "  where idStage = :idStage");

    query.setInteger("idUnit", idUnit);
    query.setInteger("idSituation", idSituation);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
  //STGAP00010749: Get the list of stages that belong to the PAD case and 
  //the case to which the corresponding ADO stage belong to
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Object[]> findCPSCaseSummaryStagesForPadCase(Collection caseIds, String cdStagePersRole,
                                                                   String scrCdStagePersRole, int pageNbr,
                                                                   int pageSize) {
    SQLQuery query = getSession().createSQLQuery(" SELECT S.NM_STAGE, " +
                                                 "         S.CD_STAGE, " +
                                                 "         S.DT_STAGE_START, " +
                                                 "         S.DT_STAGE_CLOSE, " +
                                                 "         S.CD_STAGE_CNTY, " +
                                                 "         S.CD_STAGE_PROGRAM, " +
                                                 "         S.ID_SITUATION, " +
                                                 "         S.ID_STAGE, " +
                                                 "         S.CD_STAGE_REASON_CLOSED, " +
                                                 "         S.IND_ECS_VER, " +
                                                 "         SPL.ID_PERSON, " +
                                                 "         P.NM_PERSON_FULL, " +
                                                 "         S.IND_STAGE_CLOSE, " +   
                                                 "         S.IND_RED_FLAG, " +
                                                 "         S.ID_CASE " +
                                                 "    FROM STAGE S, " +
                                                 "         STAGE_PERSON_LINK SPL, " +
                                                 "         PERSON P " +
                                                 "    WHERE SPL.ID_STAGE = S.ID_STAGE " +
                                                 "    AND S.ID_CASE in (:caseIds) " +
                                                 "    AND P.ID_PERSON=SPL.ID_PERSON " +
                                                 "    AND (SPL.CD_STAGE_PERS_ROLE = :cdStagePersRole " +
                                                 "           OR SPL.CD_STAGE_PERS_ROLE = :scrCdStagePersRole) " +
                                                 "    ORDER BY S.ID_SITUATION DESC, " +
                                                 "         S.ID_STAGE DESC");
    query.setParameterList("caseIds", caseIds);
    query.setString("cdStagePersRole", cdStagePersRole);
    query.setString("scrCdStagePersRole", scrCdStagePersRole);
    return (PaginatedHibernateList<Object[]>) paginatedList(pageNbr, pageSize, query);
  }
  
  //STGAP00010749: Get the PAD stage in the given case
  @SuppressWarnings({"unchecked"})
  public Integer findOpenPadStageByIdCaseCdStage(int idCase, String cdStage) {

    Query query = getSession().createQuery(" select s.idStage as idStage " +
                                           "   from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "    and s.cdStage = :cdStage " +                                          
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate) " +
                                           "    order by s.dtStageStart desc");
    
    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Integer) firstResult(query);
  }

  //STGAP00010749: Gets the corresponding open FCC stage if there is one for the given ADO stage
  public Integer findOpenFccStageByIdAdoStage(int idStage) {

    Query query = getSession().createQuery(" select s.idStage as idStage " +
                                           "   from Stage s " +
                                           "  where s.idStage = (select sl.stageByIdPriorStage.idStage " +
                                           "  from StageLink sl " +
                                           "  where sl.stageByIdStage.idStage = :idStage) " +
                                           "  and s.cdStage = :cdStage " +
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate)");
    
    query.setInteger("idStage", idStage);
    query.setString("cdStage", CodesTables.CSTAGES_SUB);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (Integer) firstResult(query);
  }
  
  //STGAP00010749:Gets list of Open stages for the given case other than the stage passed
  @SuppressWarnings({"unchecked"})
  public List<Stage> findOpenStagesByIdCaseByIdStage(int idCase, int idStage) {

    Query query = getSession().createQuery("  from Stage s " +
                                           "  where s.capsCase.idCase = :idCase " +
                                           "  and s.idStage <> :idStage " +
                                           "    and (s.dtStageClose is null " +
                                           "         or s.dtStageClose = :maxDate) ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);

    return (List<Stage>) query.list();
  }
  
  public Integer findStageFCCByIdCaseIdPerson(int idCase, int idPerson, String cdStage){
    Query query = getSession().createQuery(
                                            "select s.idStage " +
                                            " from Stage s, StagePersonLink spl " +
                                            " where s.idStage = spl.stage.idStage " +
                                            " and s.capsCase.idCase = :idCase " +
                                            " and s.cdStage = :cdStage " +
                                            " and spl.cdStagePersRole = :cdRole " +
                                            " and spl.person.idPerson = :idPerson " +
                                            "  order by s.idStage desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdStage", cdStage);
    query.setString("cdRole", CodesTables.CROLES_PC);
    return (Integer)firstResult(query);
  }
  
  //STGAP00012734: Gets the stage id of the active stage for a given case id and cd_stage. 
  @SuppressWarnings({"unchecked"})
  public Integer findIdStageByIdCaseAndCdStageAndDtStageClose(int idCase, String cdStage) {

    Query query = getSession().createQuery(" select s.idStage from  Stage s where s.capsCase.idCase = :idCase " + 
                                           " and s.cdStage = :cdStage " +
                                           " and (s.dtStageClose is null " +
                                           "      or s.dtStageClose = :dtStageClose) ");

    query.setInteger("idCase", idCase);
    query.setString("cdStage", cdStage);
    query.setTimestamp("dtStageClose", DateHelper.MAX_JAVA_DATE);
    return (Integer) firstResult(query);
 }
  
  // mxpatel wrote this method for defect #STGAP00013045 to find idStage of existing ADO stage
  public Integer findIdStageForOpenAdoStageByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery(
                                           " select a.idStage " + "   from Stage a , " + "        StagePersonLink b "
                                                           + "  where a.capsCase.idCase = :idCase "
                                                           + "    and a.idStage = b.stage.idStage "
                                                           + "    and b.capsCase.idCase = a.capsCase.idCase "
                                                           + "    and b.person.idPerson = :idPerson "
                                                           + "    and a.dtStageClose is null "
                                                           + "    and a.cdStage  = '" + CodesTables.CSTAGES_ADO + "' "
                                                           + "    and b.cdStagePersRole = '" + CodesTables.CROLEALL_PC
                                                           + "' ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (Integer) query.uniqueResult();
  }
  
  
  //STGAP00014341: Update Stage Assignment History for idPErson idStage and cdRole
  public int updateStageAsgnmtHistory(int idPerson, int idStage) {
    SQLQuery query = getSession().createSQLQuery("  update stage_assign_history " +
                                                 "  set dt_unassgnd = null " +
                                                 "  where id_person = :idPerson " +
                                                 "  and id_stage = :idStage " +
                                                 "  and cd_role = :cdRole ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("cdRole", CodesTables.CROLEALL_PR);
    return query.executeUpdate();
  }
  
  //STGAP00014341: delete Staff Assignment History for idPErson idStage and cdRole
  public int deleteStageAsgnmtHistory(int idPerson, int idStage) {
    SQLQuery query = getSession().createSQLQuery("  delete from stage_assign_history " +
                                                 "  where id_person = :idPerson " +
                                                 "  and id_stage = :idStage " +
                                                 "  and cd_role = :cdRole ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("cdRole", CodesTables.CROLEALL_HP);
    return query.executeUpdate();
  }
  
  // SMS#97845 MR-074-2 AFCARS:
  public Integer findIdCaseByIdPersonCdRoleCdStageDtStageStart(int idChild, String cdRole, String cdStage, Date dt) {
    Query query = getSession().createQuery(
                                           "select spl.capsCase.idCase " + " from StagePersonLink spl "
                                                           + " where spl.person.idPerson = :idChild "
                                                           + " and spl.cdStagePersRole = :cdRole "
                                                           + " and spl.stage.cdStage = :cdStage "
                                                           + " and spl.stage.dtStageStart < :dt "
                                                           + " order by spl.stage.dtStageStart desc");
    query.setInteger("idChild", idChild);
    query.setString("cdRole", cdRole);
    query.setString("cdStage", cdStage);
    query.setTimestamp("dt", dt);
    return (Integer) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findIdCasesByIdCaseCdStageCdStageReasonClosed(Collection<Integer> idCases,
                                                                     Collection<String> cdStages,
                                                                     Collection<String> cdStageReasonClosed) {
    Query query = getSession().createQuery(" select s.capsCase.idCase from Stage s "
                                                           + " where s.capsCase.idCase in (:idCases) "
                                                           + " and s.cdStageReasonClosed in (:cdStageReasonClosed)"
                                                           + " and s.cdStage in (:cdStages) ");
    query.setParameterList("idCases", idCases);
    query.setParameterList("cdStages", cdStages);
    query.setParameterList("cdStageReasonClosed", cdStageReasonClosed);
    return (List<Integer>) query.list();
  }


}
