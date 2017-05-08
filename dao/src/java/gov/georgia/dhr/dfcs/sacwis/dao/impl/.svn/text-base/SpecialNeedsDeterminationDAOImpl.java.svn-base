package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/** @author vishala devarakonda */
/** Change History
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
                 
 * 05/18/2009  bgehlot           STGAP00013779: MR-050: Added method  findLatestApprovedNonRecSpclDetermination.
 * 05/27/2009  bgehlot           STGAP00013924: Added method findLatestApprovedSpclDetermination
 * 06/01/2009  hjbaptiste        STGAP00012521: Renamed findSpclDeterminationsByIdCaseByIdPerson to findSpclDeterminationsByIdCaseIdStageIdPerson
 *                               and passed in the idStage parameter
 * 06/8/2009   bgehlot           STGAP00012194: Added method findSpclDeterminationByIdStageByIdPersonNA
 * 06/09/2009  bgehlot           STGAP00014155: Added condition for Deferred
 * 06/14/2009  mxpatel           STGAP00013002: mxpatel wrote findIndAprvByIdAgreement method to find out if the application that is 
 *                               associated with a particular agreement is Approved, Denied or Deferred.
 * 12/30/2009  mchillman         Change not pull over any applications that special services only for new agreements  
 * 01/08/2010  mxpatel           STGAP00015702: Added methods for MR-52   findSpecNeedsDeterByIdSpcNeedsDeter
 * 02/19/2010  hjbaptiste        SMS#44783: In findLatestApprovedSpclDetermination() using codestables to exclude the Non Applicable special needs type.
 *                               checking the approved special needs type instead of the request type    
 * 03/04/2010  mxpatel           SMS #46736: added new method findCountAprvSpecServByIdPerosnIdStageType to find any exisiting applications that would
 *                               overlap with the application that we are trying to approve.                         
 * 01/06/2011  arege             SMS#77302 Modified return type for method findIndAprvByIdAgreement              
 * 03/09/2011  htvo              SMS#97845 MR-074-2 AFCARS: new method findLatestAprvSpclDeterminationByIdStageIdPerson,
 *                               findIdEventsByIdPersonIdStageSpcNeedsDetType, findAPRVMonthlyAppByIdCaseIdPerson
 * 04/11/2011  htvo              SMS#97845 MR-074-2 AFCARS: modified findAPRVMonthlyAppByIdCaseIdPerson to findApprovedDeferredMonthlyAppByIdCaseIdPerson                              
 */

public class SpecialNeedsDeterminationDAOImpl extends BaseDAOImpl implements SpecialNeedsDeterminationDAO {

  public SpecialNeedsDetermination findSpecialNeedsDeterminationByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           "     from SpecialNeedsDetermination a"
                                                           + "    where a.event.idEvent = :idEvent"
                                                           + " order by a.dtLastUpdate desc");
    query.setInteger("idEvent", idEvent);
    return (SpecialNeedsDetermination) query.uniqueResult();
  }

  public Map findLatestSpecialNeedsDeterminationForADP(int idCase, int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(e.dtLastUpdate as dtApprvDate, "
                                                           + "               snd.cdFundingType as cdFundingType, "
                                                           + "               snd.indAprType as indAprType, "
                                                           + "               snd.cdSpclSerType as cdSpclSerType, "
                                                           + "               snd.nbrApprvAmt as nbrApprvAmt, "
                                                           + "               snd.nbrTotalIveIvbAmt as nbrTotalIveIvbAmt, "
                                                           + "               e.cdEventStatus as cdEventStatus) "
                                                           + "   from SpecialNeedsDetermination snd, " 
                                                           + "        Event e, "
                                                           + "        EventPersonLink epl "
                                                           + "  where snd.event.idEvent = epl.event.idEvent "
                                                           + "    and snd.event.idEvent = e.idEvent "
                                                           + "    and epl.capsCase.idCase = :idCase "
                                                           + "    and epl.person.idPerson = :idPerson "
                                                           + "    order by e.dtEventOccurred desc, e.idEvent desc");
                                                           
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (Map) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findSpclDeterminationsByIdCaseIdStageIdPerson(int idCase, int idStage, int idPerson){
    Query query = getSession().createQuery( " select s.event.idEvent from SpecialNeedsDetermination s " +
                                            " where s.event.capsCase.idCase = :idCase " +
                                            " and s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and (s.dtExpirationDate is null or s.dtExpirationDate > sysdate)" +
                                            " and (s.indSpcNeedsApproved in (:approved, :defered ) " +
                                            " or s.indSpclRateAdoAppr in (:approved, :defered) " +
                                            " or s.indNonRecApproved in (:approved, :defered) " +
                                            " or s.indSpclReqApproved in (:approved, :defered)) " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("approved", CodesTables.CAPPSTS_Y);
    query.setString("defered", CodesTables.CAPPSTS_D);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findAllSpclDeterminationsByIdCaseByIdPerson(int idCase, int idPerson, int idStage){
    Query query = getSession().createQuery( " select s.event.idEvent from SpecialNeedsDetermination s " +
                                            " where s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and s.dtExpirationDate is null " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Map> findApprovedSpclDeterminationEventsByIdStageNoSpclSer(int idStage, int pageNbr,
                                                                                            int pageSize) {

    Query query = getSession().createQuery(" select new map(cc.indCaseSensitive as indCaseSensitive, " +
                                           "                ev.dtEventOccurred as dtEventOccurred, " +
                                           "                ev.cdEventStatus as cdEventStatus, " +
                                           "                ev.cdEventType as cdEventType, " +
                                           "                ev.txtEventDescr as txtEventDescr, " +
                                           "                st.nmStage as nmStage, " +
                                           "                cc.idCase as idCase, " +
                                           "                ev.idEvent as idEvent, " +
                                           "                st.idStage as idStage, " +
                                           "                st.cdStage as cdStage, " +
                                           "                ev.cdTask as cdTask) " +
                                           " from Event ev, SpecialNeedsDetermination sn, Stage st, CapsCase cc " +
                                           " where sn.event.idEvent = ev.idEvent " +
                                           " and ev.stage.idStage = :idStage " +
                                           " and ev.cdEventStatus = :APRV " +
                                           " and st.idStage = ev.stage.idStage " +
                                           " and cc.idCase = st.capsCase.idCase " +
                                           " and (sn.indSpcNeedsApproved in (:approved, :defered ) " +
                                           " or sn.indSpclRateAdoAppr in (:approved, :defered) " +
                                           " or sn.indNonRecApproved in (:approved, :defered)) ");
                                           
    query.setInteger("idStage", idStage);
    query.setString("approved", CodesTables.CAPPSTS_Y);
    query.setString("defered", CodesTables.CAPPSTS_D);
    query.setString("APRV", CodesTables.CEVTSTAT_APRV);

    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Map> findApprovedSpclDeterminationEventsByIdStageSpclSerOnly(int idStage, Collection<String> spclSerTypes,
                                                                                             int pageNbr, int pageSize) {

    Query query = getSession().createQuery(" select new map(cc.indCaseSensitive as indCaseSensitive, " +
                                           "                ev.dtEventOccurred as dtEventOccurred, " +
                                           "                ev.cdEventStatus as cdEventStatus, " +
                                           "                ev.cdEventType as cdEventType, " +
                                           "                ev.txtEventDescr as txtEventDescr, " +
                                           "                st.nmStage as nmStage, " +
                                           "                cc.idCase as idCase, " +
                                           "                ev.idEvent as idEvent, " +
                                           "                st.idStage as idStage, " +
                                           "                st.cdStage as cdStage, " +
                                           "                ev.cdTask as cdTask) " +
                                           " from Event ev, SpecialNeedsDetermination sn, Stage st, CapsCase cc " +
                                           " where sn.event.idEvent = ev.idEvent " +
                                           " and ev.stage.idStage = :idStage " +
                                           " and ev.cdEventStatus = :APRV " +
                                           " and st.idStage = ev.stage.idStage " +
                                           " and cc.idCase = st.capsCase.idCase " +
                                           " and sn.indSpclReqApproved in (:approved) " +
                                           " and sn.cdSpclSerType in (:spclSerTypes) ");
                                           
    query.setInteger("idStage", idStage);
    query.setString("approved", CodesTables.CAPPSTS_Y);
    query.setString("APRV", CodesTables.CEVTSTAT_APRV);
    query.setParameterList("spclSerTypes", spclSerTypes);

    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  @SuppressWarnings("unchecked")
  public PaginatedHibernateList<Map> findApprovedSpclDeterminationEventsByIdStageNonRecOnly(int idStage, int pageNbr,
                                                                                            int pageSize) {

    Query query = getSession().createQuery(" select new map(cc.indCaseSensitive as indCaseSensitive, " +
                                           "                ev.dtEventOccurred as dtEventOccurred, " +
                                           "                ev.cdEventStatus as cdEventStatus, " +
                                           "                ev.cdEventType as cdEventType, " +
                                           "                ev.txtEventDescr as txtEventDescr, " +
                                           "                st.nmStage as nmStage, " +
                                           "                cc.idCase as idCase, " +
                                           "                ev.idEvent as idEvent, " +
                                           "                st.idStage as idStage, " +
                                           "                st.cdStage as cdStage, " +
                                           "                ev.cdTask as cdTask) " +
                                           " from Event ev, SpecialNeedsDetermination sn, Stage st, CapsCase cc " +
                                           " where sn.event.idEvent = ev.idEvent " +
                                           " and ev.stage.idStage = :idStage " +
                                           " and ev.cdEventStatus = :APRV " +
                                           " and st.idStage = ev.stage.idStage " +
                                           " and cc.idCase = st.capsCase.idCase " +
                                           " and sn.indNonRecApproved in (:approved) ");
                                           
    query.setInteger("idStage", idStage);
    query.setString("approved", CodesTables.CAPPSTS_Y);
    query.setString("APRV", CodesTables.CEVTSTAT_APRV);

    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  // STGAP00013002: mxpatel wrote this method to find out if the application that is associated with a particular
  // agreement is Approved, Denied or Deferred.
  // SMS#77302 Modified method to return indSpclRateAdoAppr and indSpcNeedsApproved 
  
   public Map findIndAprvByIdAgreement(int idEvent) {
     Query query = getSession()
                               .createQuery(
                                            " select new map(snd.indSpcNeedsApproved as indSpcNeedsApproved , "
                                                            + " snd.indSpclRateAdoAppr as indSpecialRateApproved )"
                                                            + " from SpecialNeedsDetermination snd "
                                                            + " where snd.event.idEvent = (select asub.specialNeedsDetermination.event.idEvent "
                                                            + " from AdoptionSubsidy asub "
                                                            + " where asub.idAdptSub = (select asl.adoptionSubsidy.idAdptSub "
                                                            + " from AdptSubEventLink asl "
                                                            + " where asl.event.idEvent = :idEvent))");

     query.setInteger("idEvent", idEvent);
     return (Map) firstResult(query);
   }
  public SpecialNeedsDetermination findSpclDeterminationByIdStageByIdPerson(int idStage, int idPerson, int idCase){
    Query query = getSession().createQuery( " from SpecialNeedsDetermination s " +
                                            " where s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and (s.indSpcNeedsApproved = :indAprv " +
                                            "      or  s.indSpclRateAdoAppr = :indAprv) " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indAprv", ArchitectureConstants.Y);
    return (SpecialNeedsDetermination)firstResult(query);
  }
  
  //STGAP00013779: Find the latest Approved Non Recurring Application
  public SpecialNeedsDetermination findLatestApprovedNonRecSpclDetermination(int idStage, int idPerson, int idCase){
    Query query = getSession().createQuery( " from SpecialNeedsDetermination s " +
                                            " where s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and s.indNonRecApproved = :indAprv " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indAprv", ArchitectureConstants.Y);
    return (SpecialNeedsDetermination)firstResult(query);
  }
  
  public SpecialNeedsDetermination findAprvNonRecurringByIdStageByIdPerson(int idStage, int idPerson, int idCase){
    Query query = getSession().createQuery( " from SpecialNeedsDetermination s " +
                                            " where s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and s.indNonRecApproved = :indAprv " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indAprv", ArchitectureConstants.Y);
    return (SpecialNeedsDetermination)firstResult(query);
  }
  
  //STGAP00013924: Find the latest Approved Special Needs Application
  //STGAP00014155: Added condition for Deferred
  public SpecialNeedsDetermination findLatestApprovedSpclDetermination(int idStage, int idPerson, int idCase){
    Query query = getSession().createQuery( " from SpecialNeedsDetermination s " +
                                            " where s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and s.indAprType != :cdExcludedSpecialNeedsType " +
                                            " and s.indSpcNeedsApproved in ('Y', 'D') " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdExcludedSpecialNeedsType", CodesTables.CSPCLTYP_N);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (SpecialNeedsDetermination)firstResult(query);
  }
  
  //STGAP00012194: Retrieves the approved special needs determination
  public SpecialNeedsDetermination findSpclDeterminationByIdStageByIdPersonNA(int idStage, int idPerson, int idCase){
    Query query = getSession().createQuery( " from SpecialNeedsDetermination s " +
                                            " where s.event.stage.idStage = :idStage " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and s.indReasonSpecialRequest = 'N' " +
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (SpecialNeedsDetermination)firstResult(query);
  }
  
  public int saveSpecialNeedsDetermination(SpecialNeedsDetermination spNdsDetermintion) {
    getSession().saveOrUpdate(spNdsDetermintion);
    return spNdsDetermintion.getIdEvent();
  }


  
  public SpecialNeedsDetermination findSpecNeedsDeterByIdSpcNeedsDeter(int idSpecNeedsDeter) {
    Query query = getSession().createQuery(" from SpecialNeedsDetermination snd " + " where snd.event.idEvent = :idSpecNeedsDeter");
    query.setInteger("idSpecNeedsDeter", idSpecNeedsDeter);
    return (SpecialNeedsDetermination)firstResult(query);
  }
  
  public long findCountAprvSpecServByIdPerosnIdStageType(int idPerson, int idEvent, Date aprvDate, Date expDate, int idStage,
                                                         String cdSpclSrvType) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    Query query = getSession()
                              .createQuery(
                                           " select count(*) "
                                                           + " from SpecialNeedsDetermination snd, Event e, EventPersonLink epl "
                                                           + " where snd.event.idEvent = e.idEvent "
                                                           + " and e.idEvent = epl.event.idEvent "
                                                           + " and e.stage.idStage = :idStage  "
                                                           + " and epl.person.idPerson = :idPerson "
                                                           + " and e.cdEventStatus = :cdEventStatus "
                                                           + " and snd.cdSpclSerType = :cdSpclSrvType "
                                                           + " and snd.event.idEvent <> :idEvent "
                                                           + " and ((:aprvDate between snd.dtApprvDate and snd.dtExpirationDate "
                                                           + " or :expDate between snd.dtApprvDate and snd.dtExpirationDate) "
                                                           + " or (snd.dtApprvDate between :aprvDate and  :expDate "
                                                           + " or snd.dtExpirationDate between :aprvDate and  :expDate))");
    query.setString("cdSpclSrvType", cdSpclSrvType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    query.setInteger("idStage", idStage);
    query.setDate("aprvDate", aprvDate);
    query.setDate("expDate", expDate);
    return (Long) query.uniqueResult();
  }
  
  // SMS#97845 MR-074-2 AFCARS
  public SpecialNeedsDetermination findLatestAprvSpclDeterminationByIdStageIdPerson(int idStage, int idPerson){
	    Query query = getSession()
                              .createQuery(
                                           " from SpecialNeedsDetermination snd "
                                                           + " where snd.event.stage.idStage = :idStage "
                                                           + " and snd.indIncidentChild is not null "
                                                           + " and snd.event.idEvent in (select epl.event.idEvent "
                                                           + " from EventPersonLink epl "
                                                           + " where epl.event.cdEventStatus = :cdEventStatus "
                                                           + " and epl.person.idPerson = :idPerson) "
                                                           + " order by snd.event.dtEventOccurred desc, snd.event.idEvent desc ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (SpecialNeedsDetermination) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findIdEventsByIdPersonIdCaseSpcNeedsDetType(int idPerson, int idCase, Collection spcNeedsDetType){
    Query query = getSession().createQuery( " select s.event.idEvent from SpecialNeedsDetermination s, EventPersonLink e " +
                                            " where s.event.cdEventStatus = :cdEventStatus " +
                                            " and s.event.capsCase.idCase = :idCase " +
                                            " and s.event.idEvent = e.event.idEvent " +
                                            " and e.person.idPerson = :idPerson " +
                                            " and s.indSpcNeedsApproved in (:spcNeedsDetType) ");
    query.setInteger("idCase", idCase);
    query.setParameterList("spcNeedsDetType", spcNeedsDetType);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (List<Integer>) query.list();
  }
  
  public List<SpecialNeedsDetermination> findApprovedDeferredMonthlyAppByIdCaseIdPerson(int idCase, int idPerson){
    Query query = getSession().createQuery( " from SpecialNeedsDetermination s " +
                                            " where s.event.capsCase.idCase = :idCase " +
                                            " and s.event.idEvent in (select epl.event.idEvent " +
                                            " from EventPersonLink epl " +
                                            " where epl.capsCase.idCase = :idCase " +
                                            " and epl.event.cdEventStatus = :cdEventStatus " +
                                            " and epl.person.idPerson = :idPerson) " +
                                            " and ((s.indSpcNeedsApproved in (:deferred) " + // basic/custom/specialized rate requested and deferred
                                            "       and (s.indBasicRateReqChild = :Y or s.indSpclRateReqChild = :Y)) " + 
                                            "  or (s.indSpcNeedsApproved in (:approved) and s.cdBasicRateType is not null)  " + // basic/custom rate approved
                                            "  or s.indSpclRateAdoAppr = :approved ) " + // specialized rate approved
                                            " order by s.event.dtEventOccurred desc, s.event.idEvent desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("Y", ArchitectureConstants.Y);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("approved", CodesTables.CAPPSTS_Y);
    query.setString("deferred", CodesTables.CAPPSTS_D);
    return (List<SpecialNeedsDetermination>) query.list();
  }


}