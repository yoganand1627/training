package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*** Change History:
 **  Date      User                 Description
 **  --------  ------------------   --------------------------------------------------
 **  4/4/2008  Corey Harden         STGAP00007558: Created new method countLegalStatusByDtLegalStatStatusDtByIdCase
 *                                  to count the number of legal status's entered on a particular date
 *
 * 04/28/2009  bgehlot              STGAP00012833: Added the method findCurrentLegalStatusByIdPersonCdLegalStatuses,
 *                                  findTwelveMonthRecurrence
 *                                 
 * 04/29/2009  bgehlot              STGAP00012734: Added the method findLegalStatCntyByIdPersonIdStage, findMonthDiff
 * 
 * 12/04/2009  cwells               37365: Added method findLegalStatusByIdCaseByIdPerson
 * 
 * 2/7/2010    cwells               CAPTA DEV: added findMostRecentLegalStatusByIdPersonIdCase
 * 
 * 5/11/2010   mxpatel              SMS #52233: added method findMostRecentAdoFinalizedDate to find the latest legal status 
 *                                  Adoption Finalized Effective Date of any child placed in the resource.
 * 05/26/2010  hjbaptiste           SMS#51977-MR66-Maltreatment In Care: Added method to check legal status view to see if child
 *                                  was in DFCS Custody at the time of an alleged incident  
 * 06/14/2010  bgehlot              SMS#51977 Changed the query for findInCustodyLegalStatus to include the cd_legal_stat_status
 *                                  so that Not in DFCS Custody and Short Term Emergency care are counted as Maltreatment in Care                   
 * 09/15/2010  wjcochran            SMS#67942: Added method findIdCaseForLegalStatusByIdLegalStatEvent to return the
 *                                  ID_CASE of a given Legal Status Event
 * 11/08/2010  htvo                 SMS#81140 - MR-074: update findMostRecentLegalStatusByIdPersonIdCase to look within the current case.
 *                                  Add findPriorLegalStatusByIdPersonIdCaseByDate, findNextLegalStatusByIdPersonIdCaseByDate  
 * 12/09/2010  schoi                SMS #81140: MR-074 Added findMostRecentLegalStatusViewByIdPersonIdCase(int idPerson, int idCase) 
 *                                  and findInDFCSCustodyLegalStatusByIdPersonByIdCaseByIdEvent(int idPerson, int idCase, int idEvent) 
 * 12/10/2010  schoi                SMS #81140: MR-074 Added countCurrentLegalStatusByIdPersonIdCaseIdEventCdLegalStatStatus    
 * 12/12/2010  schoi                SMS #81140: MR-074 Removed previously added findMostRecentLegalStatusViewByIdPersonIdCase
 *                                  and findInDFCSCustodyLegalStatusByIdPersonByIdCaseByIdEvent methods; 
 *                                  these methods are no longer needed per design change requested by the State team
 * 02/09/2011  Hai Nguyen           SMS#95590: Added new method findLegalStatusByIdVictimByIdCaseByCdLegalStatuses.                                                                                                                                                                                                          
 * 02/10/2011  Hai Nguyen           SMS#95590: Removed method findLegalStatusByIdVictimByIdCaseByCdLegalStatuses.                                                                                                                                                                                                          
 * 02/28/2011  htvo                 SMS#97845 MR-074-2 AFCARS: added findLegalStatusByIdStageByIdPerson to find all 
 *                                  LS (id event and LS code map) for a person
 * 02/28/2011  htvo                 SMS#97845 MR-074-2 AFCARS: added findLegalStatusByIdStageByIdPerson to find all 
 *                                  LS (id event and LS code map) for a person      
 * 09/12/2011  charden              STGAP00017058 - created method countLegalStatusByStatusDtLegalStatStatusIdPerson() to find number of delinquent children
 * 09/21/2011  charden              STGAP00017058 - created method countKennyACountyForIdPersons
 * 09/30/2011  hjbaptiste           STGAP00017011: MR-092 Fostering Connections. Added findAllLegalStatusesForCaseUsingView                                                         
 * 10/17/2011  hnguyen              STGAP00017242: Corrected findAllLegalStatusesForCaseUsingView query to retrieve legal status that match id case argument
 *                                  and corrected scalar name to match alias name in query.  Also to set end date beyond sysdate to sysdate using LEAST.                                                         
 */

public class LegalStatusDAOImpl extends BaseDAOImpl implements LegalStatusDAO {
  
  /*
   * Added for calculating per diem for service that updates CSUP_PARENT_OUTBOUND table
   * (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO#findCurrentLegalStatusbyIdPerson(int)
   */
  @SuppressWarnings({"unchecked"})
  public LegalStatus findCurrentLegalStatusbyIdPersonForPerDiem(int idPerson) {
    Query query = getSession().createQuery(" from LegalStatus ls " 
                                           + "where ls.person.idPerson = :idPerson and " 
                                           + "ls.dtLegalStatStatusDt <= sysdate");
    query.setInteger("idPerson", idPerson);
    return (LegalStatus) firstResult(query);
  }
  
  //STGAP00017058
  public Long countKennyACountyForIdPersons(List<Integer> idPersons) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from LegalStatus " +
                                           "  where person.idPerson in (:idPersons) " +
                                           "  and cdLegalStatCnty in ('089', '121')" +
                                           "  and dtLegalStatStatusDt <= sysdate");
    query.setParameterList("idPersons", idPersons);
    return (Long) query.uniqueResult();
  }
  
  @SuppressWarnings("unchecked")
  public List<LegalStatus> countLegalStatusByStatusDtLegalStatStatusIdPerson(List<Integer> idPersons, List<String> statuses, Date dtLegalStat){
    Query query = getSession().createQuery("from LegalStatus " +
                                           "   where person.idPerson in (:idPersons) " +
                                           "   and dtLegalStatStatusDt <= :dtLegalStat " +
                                           "   and cdLegalStatStatus in (:statuses)");
    query.setParameterList("idPersons", idPersons);
    query.setParameterList("statuses", statuses);
    query.setTimestamp("dtLegalStat", dtLegalStat);
    return (List<LegalStatus>) query.list();
  }
  
  public long countLegalStatusByDtLegalStatStatusDt(int idPerson, Date dtLegalStatStatusDt) {
    Query query = getSession().createQuery("select count(*) " +
                                           "   from LegalStatus " +
                                           "  where person.idPerson = :idPerson " +
                                           "    and dtLegalStatStatusDt = :dtLegalStatStatusDt");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLegalStatStatusDt", dtLegalStatStatusDt);
    return (Long) query.uniqueResult();
  }
  
  public long countLegalStatusByDtLegalStatStatusDtByIdCaseIdPerson(int idCase, int idPerson, Date dtLegalStatStatusDt) {
    Query query = getSession().createQuery("select count(*) " +
                                           "   from LegalStatus l" +
                                           "  where l.capsCase.idCase = :idCase " +
                                           "    and l.person.idPerson = :idPerson " +
                                           "    and dtLegalStatStatusDt = :dtLegalStatStatusDt");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLegalStatStatusDt", dtLegalStatStatusDt);
    return (Long) query.uniqueResult();
  }
  

  public LegalStatus findLegalStatusByMaxDtLegalStatStatusDt(int idPerson, int idCase) {
    Query query = getSession().createQuery("   from LegalStatus l " +
                                           "  where l.person.idPerson = :idPerson " +
                                           "    and l.capsCase.idCase = :idCase " +
                                           "    and l.dtLegalStatStatusDt = (select max(l2.dtLegalStatStatusDt) " +
                                           "                                   from LegalStatus l2 " +
                                           "                                  where l2.person.idPerson = :idPerson " +
                                           "                                    and l2.capsCase.idCase = :idCase)");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (LegalStatus) firstResult(query);
  }

  public String findCdLegalStatStatusByMaxIdLegalStatEvent(int idPerson, String type1) {
    Query query = getSession().createQuery("select cdLegalStatStatus " +
                                           "  from LegalStatus " +
                                           " where person.idPerson = :idPerson " +
                                           "   and idLegalStatEvent in " +
                                           "       (select max(idLegalStatEvent) " +
                                           "          from LegalStatus " +
                                           "         where person.idPerson = :idPerson " +
                                           "           and cdLegalStatStatus = :type1 " +
                                           "           and dtLegalStatStatusDt = " +
                                           "               (select max(dtLegalStatStatusDt) " +
                                           "                  from LegalStatus " +
                                           "                 where person.idPerson = :idPerson))");
    query.setInteger("idPerson", idPerson);
    query.setString("type1", type1);

    return (String) firstResult(query);
  }

  public LegalStatus findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(int idPerson, String cdLegalStatStatus) {
    Query query = getSession().createQuery("  from LegalStatus l join fetch l.event " +
                                           " where l.person.idPerson = :idPerson " +
                                           "   and l.cdLegalStatStatus = :cdLegalStatStatus " +
                                           "   and l.dtLegalStatStatusDt = " +
                                           "       (select max(l2.dtLegalStatStatusDt) " +
                                           "          from LegalStatus l2 " +
                                           "         where l2.person.idPerson = :idPerson " +
                                           "           and l2.cdLegalStatStatus = :cdLegalStatStatus)"
    );
    query.setInteger("idPerson", idPerson);
    query.setString("cdLegalStatStatus", cdLegalStatStatus);
    return (LegalStatus) firstResult(query);
  }

  public LegalStatus findMostRecentLegalStatusByIdPerson(int idPerson) {
    Query query = getSession().createQuery("  from LegalStatus ls " +
                                           " where ls.person.idPerson = :idPerson " +
                                           "   and ls.dtLegalStatStatusDt = " +
                                           "       ( select max(ls2.dtLegalStatStatusDt) " +
                                           "           from LegalStatus ls2 " +
                                           "          where ls2.person.idPerson = :idPerson )");
    query.setInteger("idPerson", idPerson);
    return (LegalStatus) firstResult(query);
  }
  
  public LegalStatus findMostRecentLegalStatusByIdPersonIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery("  from LegalStatus ls " +
                                           " where ls.person.idPerson = :idPerson " +
                                           " and ls.capsCase.idCase = :idCase " + 
                                           "   and ls.dtLegalStatStatusDt = " +
                                           "       ( select max(ls2.dtLegalStatStatusDt) " +
                                           "           from LegalStatus ls2 " +
                                           "          where ls2.person.idPerson = :idPerson " +
                                           "          and ls2.capsCase.idCase = :idCase)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (LegalStatus) firstResult(query);
  }

  public Map findMostRecentLegalStatusIdAndCounty(int idPerson) {
    Query query = getSession().createQuery(" select new map (ls.event.idEvent as idEvent," +
    		                           "                 ls.cdLegalStatCnty as cdLegalStatCnty, " +
    		                           "                 ls.dtLegalStatStatusDt as dtLegalStatStatusDt) " +
                                           " from LegalStatus ls " +
                                           " where ls.person.idPerson = :idPerson " +
                                           "   and ls.dtLegalStatStatusDt = " +
                                           "       ( select max(ls2.dtLegalStatStatusDt) " +
                                           "           from LegalStatus ls2 " +
                                           "          where ls2.person.idPerson = :idPerson )");
    query.setInteger("idPerson", idPerson);
    return (Map) firstResult(query);    
  }
  
  
  
  public LegalStatus findCurrentLegalStatusByIdPerson(int idPerson) {
    Query query = getSession().createQuery("  from LegalStatus ls " +
                                          " where ls.person.idPerson = :idPerson " +
                                          "   and ls.dtLegalStatStatusDt = " +
                                          "       ( select max(ls2.dtLegalStatStatusDt) " +
                                          "           from LegalStatus ls2 " +
                                          "          where ls2.person.idPerson = :idPerson " +
                                          "   and ls.dtLegalStatStatusDt<=:date )");
   query.setInteger("idPerson", idPerson);
   query.setDate("date",new Date());
   return (LegalStatus) firstResult(query);
 }

  // SMS #81140: MR-074 Find the Legal Status records under the Person ID, Case ID and Event ID specified
  @SuppressWarnings("unchecked")
  public Long countCurrentLegalStatusByIdPersonIdCaseIdEventCdLegalStatStatus(int idPerson, int idCase, int idEvent, String cdLegalStatStatus) {
    SQLQuery query = getSession().createSQLQuery(
                                              "select count(*) as result "
                                              + " from legal_status_view l, placement p, event ev, stage_person_link spl " 
                                              + " where l.id_person = :idPerson " 
                                              + "   AND l.id_case = :idCase "
                                              + "   AND p.id_plcmt_child = :idPerson "
                                              + "   AND l.id_person = p.id_plcmt_child "
                                              + "   AND spl.id_person = p.id_plcmt_child "
                                              + "   AND spl.cd_stage_pers_role = 'PC' "
                                              + "   AND p.id_plcmt_event = :idEvent "
                                              + "   AND ev.id_event = p.id_plcmt_event "
                                              + "   AND ev.id_event_stage = spl.id_stage "  
                                              + "   AND l.cd_legal_stat_status = :cdLegalStatStatus "
                                              + "   AND (l.dt_legal_stat_end is null "
                                              + "     OR l.dt_legal_stat_end >= p.dt_plcmt_start) "
                                              + "   AND l.dt_legal_stat_status_dt <= p.dt_plcmt_start ") ;
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setInteger("idEvent", idEvent);
    query.setString("cdLegalStatStatus", cdLegalStatStatus);
    query.addScalar("result", Hibernate.LONG);
    return (Long) query.uniqueResult();
  }
  
  public LegalStatus findLegalStatusByIdPersonByDtLegalStatStatusDt(int idPerson, Date dtLegalStatStatusDt) {
    Query query = getSession().createQuery("  from LegalStatus ls " +
                                          " where ls.person.idPerson = :idPerson " +
                                          "   and ls.dtLegalStatStatusDt = " +
                                          "       ( select max(ls2.dtLegalStatStatusDt) " +
                                          "           from LegalStatus ls2 " +
                                          "          where ls2.person.idPerson = :idPerson " +
                                          "   and trunc(ls2.dtLegalStatStatusDt)<=trunc(:dtLegalStatStatusDt) )");
   query.setInteger("idPerson", idPerson);
   query.setDate("dtLegalStatStatusDt", dtLegalStatStatusDt);
   return (LegalStatus) firstResult(query);
 }
  
  public LegalStatus findLegalStatus(int idLegalStatEvent) {
    Query query = getSession().createQuery("  from LegalStatus ls " +
                                           " where ls.idLegalStatEvent = :idLegalStatEvent ");
    query.setInteger("idLegalStatEvent", idLegalStatEvent);
    return (LegalStatus) firstResult(query);
  }

  public void saveLegalStatus(LegalStatus legalStatus) {
    getSession().saveOrUpdate(legalStatus);
  }

  public int updateLegalStatus(int idPersMergeClosed, int idPersMergeForward, int idEvent) {
    Query query = getSession().createQuery("update LegalStatus " +
                                           "    set person.idPerson = :idPersMergeForward " +
                                           "  where person.idPerson = :idPersMergeClosed " +
                                           "    and idLegalStatEvent = :idEvent");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public void deleteLegalStatus(LegalStatus legalStatus) {
    getSession().delete(legalStatus);
    getSession().flush();
  }
  
  //STGAP00012021: Modified signature to include status parameter
  public Map findLegalStatusByIdSatgeByIdPerson(int idStage, int idPerson, List<String> cdLegalStatStatusList){
    Query query = getSession().createQuery(
                                           " select new map( l.dtLegalStatStatusDt as dtLegalStatStatusDt, "
                                           + " l.cdLegalStatStatus as cdLegalStatStatus, "
                                           + " l.cdLegalStatCnty as cdLegalStatCnty, "
                                           + " l.event.dtEventOccurred as dtEventOccurred) "
                                           + " from LegalStatus l "
                                           + " where l.person.idPerson = :idPerson "
                                           + " and l.event.stage.idStage = :idStage "
                                           + " and l.cdLegalStatStatus in (:cdLegalStatStatusList)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setParameterList("cdLegalStatStatusList", cdLegalStatStatusList);
    
    return (Map) firstResult(query);
  }
  
  
  public Map findLegalStatusByIdCaseByIdPerson(int idCase, int idPerson, List<String> cdLegalStatStatusList, Date dtEcdCreated){
    Query query = getSession().createQuery(
                                           " select new map( l.dtLegalStatStatusDt as dtLegalStatStatusDt, "
                                           + " l.cdLegalStatStatus as cdLegalStatStatus, "
                                           + " l.cdLegalStatCnty as cdLegalStatCnty, "
                                           + " l.event.dtEventOccurred as dtEventOccurred) "
                                           + " from LegalStatus l "
                                           + " where l.person.idPerson = :idPerson "
                                           + " and l.event.capsCase.idCase = :idCase "
                                           + " and l.event.dtEventOccurred >= :dtEcdCreated " 
                                           + " and l.cdLegalStatStatus in (:cdLegalStatStatusList)  "
                                           + " order by l.dtLegalStatStatusDt desc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setDate("dtEcdCreated", dtEcdCreated);
    query.setParameterList("cdLegalStatStatusList", cdLegalStatStatusList);
    
    return (Map) firstResult(query);
  }
  
  public Map findLegalStatusByIdCaseByIdPersonByCdStatusByCdStages(int idCase, int idPerson, String cdLegalStatStatus, List<String> cdStages){
    Query query = getSession().createQuery(
                                           " select new map( l.dtLegalStatStatusDt as dtLegalStatStatusDt, "
                                           + " l.cdLegalStatStatus as cdLegalStatStatus, "
                                           + " l.cdLegalStatCnty as cdLegalStatCnty, "
                                           + " l.event.dtEventOccurred as dtEventOccurred) "
                                           + " from LegalStatus l "
                                           + " where l.person.idPerson = :idPerson "
                                           + " and l.capsCase.idCase = :idCase "
                                           + " and l.cdLegalStatStatus = :cdLegalStatStatus "
                                           + " and l.event.stage.cdStage in (:cdStages) "
                                           + " order by l.dtLegalStatStatusDt asc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setParameterList("cdStages", cdStages);
    query.setString("cdLegalStatStatus", cdLegalStatStatus);
    
    return (Map) firstResult(query);
  }
  
  //STGAP00012734: Returns the Legal Status County for the person and the event
  public String findLegalStatCntyByIdPersonIdStage(int idPerson, int idEvent) {
    Query query = getSession().createQuery(" select ls.cdLegalStatCnty from LegalStatus ls " +
                                           " where ls.person.idPerson = :idPerson " +
                                           "  and ls.idLegalStatEvent = :idEvent ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);

    return (String) firstResult(query);
  }
  
  //STGAP00012833: Gets the month difference between the Removal Date and the dtLegalStatus
  public Float findCurrentLegalStatusByIdPersonCdLegalStatuses(int idPerson, List<String> cdLegalStatuses, Date dtRemoval ) {
    Query query = getSession().createQuery("select trunc(months_between(ls.dtLegalStatStatusDt , :dtRemoval)) as months " +
    		                          " from LegalStatus ls " +
                                          " where ls.person.idPerson = :idPerson " +
                                          "   and ls.dtLegalStatStatusDt = " +
                                          "       ( select max(ls2.dtLegalStatStatusDt) " +
                                          "           from LegalStatus ls2 " +
                                          "          where ls2.person.idPerson = :idPerson " +
                                          "   and ls.dtLegalStatStatusDt<=:date " +
                                          "   and ls.dtLegalStatStatusDt >= :dtRemoval ) " +
                                          "   and ls.cdLegalStatStatus in (:cdLegalStatuses)  " );
   query.setInteger("idPerson", idPerson);
   query.setDate("date",new Date());
   query.setDate("dtRemoval",dtRemoval);
   query.setParameterList("cdLegalStatuses", cdLegalStatuses);
   return (Float) firstResult(query);
 }
  
  //STGAP00012833: This method returns Y if if this child had a twelve month recurrence due to a re-entry into 
  // foster care within twelve months of the child's previous discharge.
  public Character findTwelveMonthRecurrence(int idStage, int idCase, int idPerson) {
    SQLQuery query = getSession().createSQLQuery(" select " 
                                                 + " outer_main.twelve_month_re_entry " 
                                                 + " from "
                                               + "  (select (case when ( select count(*) " 
                                               + "   from legal_status legal_status_nocustody, " 
                                               + "   legal_status legal_status_incustody, " 
                                               + "   event event_prime " 
                                               + "   where legal_status_nocustody.CD_LEGAL_STAT_STATUS NOT IN ('JCD','PCT','PVL','TCT','TVL','JCP','JCT') " 
                                               + "   and legal_status_nocustody.ID_CASE = legal_status_incustody.ID_CASE " 
                                               + "   and legal_status_nocustody.ID_PERSON = legal_status_incustody.ID_PERSON  " 
                                               + "   and legal_status_nocustody.ID_LEGAL_STAT_EVENT = event_prime.id_event " 
                                               + "   and legal_status_nocustody.DT_LEGAL_STAT_STATUS_DT <= main_details.CUSTODY_REMOVAL_DATE " 
                                               + "   and add_months(legal_status_nocustody.DT_LEGAL_STAT_STATUS_DT, 12) >= main_details.CUSTODY_REMOVAL_DATE " 
                                               + "   and legal_status_nocustody.DT_LEGAL_STAT_STATUS_DT = TO_DATE((NVL( (select (min(legal_status.DT_LEGAL_STAT_STATUS_DT)-1) " 
                                               + "                              from legal_status, event " 
                                               + "                              where legal_status.DT_LEGAL_STAT_STATUS_DT > legal_status_incustody.DT_LEGAL_STAT_STATUS_DT  " 
                                               + "                              and legal_status.ID_LEGAL_STAT_EVENT = event.ID_EVENT  " 
                                               + "                              and event.ID_CASE = event_prime.ID_CASE  " 
                                               + "                              and legal_status.ID_PERSON = legal_status_incustody.ID_PERSON " 
                                               + "                              ), to_date('12/31/4712', 'MM/DD/YYYY')))+1) " 
                                               + "  and legal_status_incustody.CD_LEGAL_STAT_STATUS IN ('JCD','PCT','PVL','TCT','TVL','JCP','JCT') "
                                               + "  and main_details.PC_PERSON_ID = legal_status_nocustody.ID_PERSON " 
                                               + " ) > 0 then 'Y'  " 
                                               + " when ( select count(*) from afcars_history  " 
                                               + " where main_details.PC_PERSON_ID = afcars_history.ID_PERSON " 
                                               + " and add_months(afcars_history.DT_DISCHARGE, 12) >= main_details.CUSTODY_REMOVAL_DATE  " 
                                               + " ) > 0 then 'Y'  " 
                                               + " else 'N'  " 
                                               + " end) as twelve_month_re_entry " 
                                               + " from (select NVL(removal_details.DT_REMOVAL, stage.DT_STAGE_START) as CUSTODY_REMOVAL_DATE,   " 
                                               + "       spl_primary_child.id_person as PC_PERSON_ID from ( select inner_removal.ID_CASE,   " 
                                               + "                                               inner_removal.ID_VICTIM, " 
                                               + "                                               inner_removal.DT_REMOVAL,  " 
                                               + "                                               inner_removal.ID_REMOVAL_EVENT, " 
                                               + " to_string(cast (collect (inner_removal.CD_REMOVAL_REASON) as collection_char1)) \"REMOVAL_REASON\"  " 
                                               + "from ( select cnsrvtrshp_removal.ID_CASE, cnsrvtrshp_removal.ID_VICTIM, "
                                               + "       cnsrvtrshp_removal.DT_REMOVAL, cnsrvtrshp_removal.ID_REMOVAL_EVENT, "
                                               + "      removal_reason.CD_REMOVAL_REASON from cnsrvtrshp_removal, removal_reason "
                                               + "      where cnsrvtrshp_removal.ID_REMOVAL_EVENT = removal_reason.ID_REMOVAL_EVENT  "          
                                               + "       )inner_removal "
                                               + "       group by  "
                                               + "       inner_removal.ID_CASE, inner_removal.ID_VICTIM, inner_removal.DT_REMOVAL,inner_removal.ID_REMOVAL_EVENT "
                                               + "   ) removal_details, stage, stage_person_link spl_primary_child "
                                               + "       where spl_primary_child.CD_STAGE_PERS_ROLE = 'PC'and spl_primary_child.id_stage = stage.ID_stage "
                                               + "and spl_primary_child.id_person = removal_details.ID_VICTIM(+) and spl_primary_child.id_case = removal_details.ID_CASE(+) " 
                                               + "and stage.id_stage = :idStage and stage.id_case = :idCase and spl_primary_child.id_person = :idPerson "
                                               + "and (removal_details.ID_REMOVAL_EVENT = (SELECT MAX (cnsrvtrshp_removal.ID_REMOVAL_EVENT)  "
                                               + "                                         FROM  cnsrvtrshp_removal  "
                                               + "                                     WHERE  cnsrvtrshp_removal.ID_VICTIM = spl_primary_child.id_person  "
                                               + "                                     AND  cnsrvtrshp_removal.ID_CASE = spl_primary_child.id_case  "
                                               + "                                     ) OR  "
                                               + "                                     (SELECT MAX (cnsrvtrshp_removal.ID_REMOVAL_EVENT) "
                                               + "                                     FROM  cnsrvtrshp_removal  "
                                               + "                                     WHERE  cnsrvtrshp_removal.ID_VICTIM = spl_primary_child.id_person "
                                               + "                                 AND  cnsrvtrshp_removal.ID_CASE = spl_primary_child.id_case  "
                                               + "                                     ) IS NULL))main_details) outer_main");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    return (Character) firstResult(query);

  }
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findInDFCSCareLegalStatus(int idVictim, int idCase, Date dtAllegedIncident) {
    SQLQuery query = getSession().createSQLQuery(" select l.id_legal_stat_event " +
                                                 " from legal_status_view l " +
                                                 " where l.id_person = :idPerson "+
                                                 " and l.id_case != :idCase " +
                                                 " and l.dt_legal_stat_status_dt <= to_date(:dtAllegedIncident, 'MM/DD/YYYY') " +
                                                 " and l.dt_legal_stat_end >= to_date(:dtAllegedIncident, 'MM/DD/YYYY') " +
                                                 " and l.cd_legal_stat_status in  ('NCS','PCT','PVL','TCT','JCP','JCT')");
    
    query.setInteger("idPerson", idVictim); 
    query.setInteger("idCase", idCase);
    query.setDate ("dtAllegedIncident", dtAllegedIncident);
    query.addScalar("id_legal_stat_event", Hibernate.INTEGER);
    return (List<Integer>) query.list();                                                 
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findAllLegalStatusesForCaseUsingView(int idVictim, int idCase) {
    SQLQuery query = getSession().createSQLQuery(" select l.dt_legal_stat_status_dt as legalStartDate, " +
                                                 " LEAST(l.dt_legal_stat_end, sysdate) as legalEndDate, l.in_dfcs_custody as isInDFCSCustody " +
                                                 " from legal_status_view l " +
                                                 " where l.id_person = :idPerson "+
                                                 " and l.id_case = :idCase " +
                                                 " order by l.dt_legal_stat_end desc, l.dt_legal_stat_status_dt desc");
    
    query.setInteger("idPerson", idVictim); 
    query.setInteger("idCase", idCase);
    query.addScalar("legalStartDate", Hibernate.DATE);
    query.addScalar("legalEndDate", Hibernate.DATE);
    query.addScalar("isInDFCSCustody", Hibernate.STRING);
    return (List<Object[]>) query.list();                                                 
  }
  
  //STGAP00012833: Gets the month difference between the Removal Date and the last day of the previous month
  public Float findMonthDiff(Date previousMonth, Date dtRemoval ) {
    Query query = getSession().createQuery("select trunc(months_between(:previousMonth, :dtRemoval)) as months " +
                                          " from LegalStatus ls ");
   query.setDate("dtRemoval",dtRemoval);
   query.setDate("previousMonth",previousMonth);
   return (Float) firstResult(query);
 }
  
  public Date findMostRecentAdoFinalizedDate(int idResource){
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = CodesTables.CEVNTTYP_LES;
    String cdPlcmtType = CodesTables.CPLMNTYP_ADH;
    String cdStage = CodesTables.CSTAGES_ADO;
    String cdStageSub = CodesTables.CSTAGES_SUB;
    String cdLegalStatStatus = CodesTables.CLEGSTAT_NAF;
    Query query = getSession().createQuery("select ls.dtLegalStatStatusDt "
                                           + "from Stage s, LegalStatus ls, Event e "
                                           + "where ls.event.idEvent = e.idEvent "
                                           + "and e.stage.idStage = s.idStage "
                                           + "and e.cdEventType = :cdEventType "
                                           + "and ls.cdLegalStatStatus = :cdLegalStatStatus "
                                           + "and (s.cdStage = :cdStage or s.cdStage = :cdStageSub) "
                                           + "and s.idStage in ( "
                                           + "select e.stage.idStage "
                                           + "from Placement p, Event e "
                                           + "where e.idEvent = p.event.idEvent "
                                           + "and p.capsResourceByIdRsrcFacil.idResource = :idResource  "
                                           + "and p.cdPlcmtType = :cdPlcmtType "
                                           + "and e.cdEventStatus = :cdEventStatus) "
                                           + "order by ls.dtLegalStatStatusDt desc");
    query.setInteger("idResource", idResource);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setString("cdPlcmtType", cdPlcmtType);
    query.setString("cdStage", cdStage);
    query.setString("cdStageSub", cdStageSub);
    query.setString("cdLegalStatStatus", cdLegalStatStatus);
    return (Date) firstResult(query);
  }

  public Integer findIdCaseForLegalStatusByIdLegalStatEvent(int idEvent) {
    Query query = getSession().createQuery(" select ls.capsCase.idCase from LegalStatus ls " +
                                           " where ls.idLegalStatEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);

    return (Integer) firstResult(query);
  }
  
  public LegalStatus findPriorLegalStatusByIdPersonIdCaseByDate(int idPerson, int idCase, Date beforeThisDate, int thisIdEvent) {
	    Query query = getSession().createQuery("  from LegalStatus ls " +
	                                           " where ls.person.idPerson = :idPerson " +
	                                           " and ls.capsCase.idCase = :idCase " + 
	                                           "   and ls.dtLegalStatStatusDt = " +
	                                           "       ( select max(ls2.dtLegalStatStatusDt) " +
	                                           "           from LegalStatus ls2 " +
	                                           "          where ls2.person.idPerson = :idPerson " +
	                                           "          and ls2.capsCase.idCase = :idCase " +
	                                           "          and ls2.dtLegalStatStatusDt < :beforeThisDate " +
	                                           "          and ls2.idLegalStatEvent <> :thisIdEvent) ");
	    query.setInteger("idPerson", idPerson);
	    query.setInteger("idCase", idCase);
	    query.setDate("beforeThisDate", beforeThisDate);
	    query.setInteger("thisIdEvent", thisIdEvent);
	    return (LegalStatus) firstResult(query);
	  } 
  
  public LegalStatus findNextLegalStatusByIdPersonIdCaseByDate(int idPerson, int idCase, Date afterThisDate, int thisIdEvent) {
	    Query query = getSession().createQuery("  from LegalStatus ls " +
	                                           " where ls.person.idPerson = :idPerson " +
	                                           " and ls.capsCase.idCase = :idCase " + 
	                                           "   and ls.dtLegalStatStatusDt = " +
	                                           "       ( select min(ls2.dtLegalStatStatusDt) " +
	                                           "           from LegalStatus ls2 " +
	                                           "          where ls2.person.idPerson = :idPerson " +
	                                           "          and ls2.capsCase.idCase = :idCase " +
	                                           "          and ls2.dtLegalStatStatusDt > :afterThisDate " +
	                                           "          and ls2.idLegalStatEvent <> :thisIdEvent) ");
	    query.setInteger("idPerson", idPerson);
	    query.setInteger("idCase", idCase);
	    query.setDate("afterThisDate", afterThisDate);
	    query.setInteger("thisIdEvent", thisIdEvent);
	    return (LegalStatus) firstResult(query);
	  } 
  
  public List<Map> findLegalStatusByIdStageByIdPerson(int idStage, int idPerson){
    Query query = getSession().createQuery(
                                           " select new map( l.event.idEvent as ID_LS_EVENT , "
                                           + " l.cdLegalStatStatus as CD_LS_STATUS) "
                                           + " from LegalStatus l "
                                           + " where l.person.idPerson = :idPerson "
                                           + " and l.event.stage.idStage = :idStage "
                                           + " )");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    
    return (List<Map>) query.list();
  }
}