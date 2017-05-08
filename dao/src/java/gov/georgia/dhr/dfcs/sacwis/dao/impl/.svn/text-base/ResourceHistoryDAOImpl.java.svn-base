package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This class provides the access methods to query, insert into and update the RESOURCE_HISTORY table.
 * 
 * @author  
 *
 * <pre>
 *   Change History:
 *   Date      User        Description
 *   --------  ----------  --------------------------------------------------
 *   10/28/08  alwilliams  STGAP00010494 - Renamed method findMinEffectiveDateByHomeStatusIdPerson
 *                         to findMaxEffectiveDateByHomeStatusIdPerson. Updated method 
 *                         findMaxEffectiveDateByHomeStatusIdPerson to get the last
 *                         (maximum) F/A Home approval date instead of the first (minimum)
 *                         F/A Home approval date.
 *   03/23/09  arege       STGAP00012363: Changed method findResourceHistoryMaxEffective so  
 *                         that it takes into account correct FA home status.
 *   09/23/09  arege       STGAP00012363: Added method findResourceHistoryMaxEffectiveByIdEvent
 *   02/28/11  hnguyen     SMS#97850: MR-075 Added method findResourceCurrentIveReimbursableStatus(idResource).
 *   03/20/11  hnguyen     SMS#97850: MR-075 Added method findLastApprovalDateByIdResourceByCdFaHomeStatuses.
 *   03/21/11  hnguyen     SMS#97850: MR-075 Added method findResourceIveReimbursableStatusByDate(idResource, Date).
 *   03/25/11  hnguyen     SMS#97850: MR-075 Updated column name. 
 *                                                    
 * </pre>
 */
public class ResourceHistoryDAOImpl extends BaseDAOImpl implements ResourceHistoryDAO {
  public ResourceHistory findResourceHistoryByIdEvent(int idRshsFaHomeEvent) {
    Query query = getSession().createQuery(" from ResourceHistory rh " +
                                           "where rh.event.idEvent = :idRshsFaHomeEvent");
    query.setInteger("idRshsFaHomeEvent", idRshsFaHomeEvent);
    return (ResourceHistory) firstResult(query);
  }

  public ResourceHistory findResourceHistory(int idResourceHistory) {
    Query query = getSession().createQuery(" from ResourceHistory r " +
                                           "where r.idResourceHistory = :idResourceHistory ");
    query.setInteger("idResourceHistory", idResourceHistory);
    return (ResourceHistory) firstResult(query);
  }
 
  public ResourceHistory findResourceHistoryMaxEffective(int idResource) {
    Query query = getSession()
                              .createQuery(
                                           "  from ResourceHistory r "
                                                           + " where capsResource.idResource = :idResource "
                                                           + "   and r.cdRshsFaHomeStatus not in ('"
                                                           +  CodesTables.CFAHMSTA_PSA + "', '"
                                                           +  CodesTables.CFAHMSTA_PTA + "', '"
                                                           +  CodesTables.CFAHMSTA_PFA + "', '"
                                                           +  CodesTables.CFAHMSTA_PCL + "')"
                                                           + "   and r.dtRshsEffective = "
                                                           + "          (select max(r2.dtRshsEffective) "
                                                           + "          from ResourceHistory r2 "
                                                           + "          where r2.capsResource.idResource = :idResource "
                                                           + "          and  r2.cdRshsFaHomeStatus not in ('"
                                                           +  CodesTables.CFAHMSTA_PSA + "', '"
                                                           +  CodesTables.CFAHMSTA_PTA + "', '"
                                                           +  CodesTables.CFAHMSTA_PFA + "', '"
                                                           +  CodesTables.CFAHMSTA_PCL + "'))"
                                                           + "   order by r.idResourceHistory desc ");
    query.setInteger("idResource", idResource);
    return (ResourceHistory) firstResult(query);
  }
  public long countResourceHistoryRowsByStageAndHomeStatus(int idStage) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from ResourceHistory " +
                                           " where stage.idStage = :idStage " +
                                           "   and cdRshsFaHomeStatus in ('APP', " +
                                           "                              'AFA', 'ATA', 'ASA', " +
                                           "                              'PFA','PTA','PSA') ");
    //commented this line out
    //"   and cdRshsFaHomeStatus in ('020', '030', '040', '050', '060') ");
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();
  }

  public ResourceHistory findResourceHistoryByIdStage(int idStage) {
    Query query = getSession().createQuery("    from ResourceHistory r " +
                                           "   where r.stage.idStage = :idStage " +
                                           "order by r.dtRshsEnd desc, " +
                                           "         r.dtRshsEffective desc");
    query.setInteger("idStage", idStage);
    return (ResourceHistory) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<ResourceHistory> findResourceHistoryListByIdStage(int idStage) {
    Query query = getSession().createQuery("    from ResourceHistory r " +
                                           "   where stage.idStage = :idStage " +
                                           "order by dtRshsEffective");
    query.setInteger("idStage", idStage);
    return (List<ResourceHistory>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public Date findEarliestAprvDateResourceHistoryDateByIdResource(int idResource) {
    Query query = getSession().createQuery(" select dtLicBegin from ResourceHistory r " +
                                           " where r.capsResource.idResource = :idResource " +
                                           " and dtLicBegin is not null " +
                                           " and dtLicBegin <> :maxDate" +
                                           " order by dtLicBegin asc");
    query.setInteger("idResource", idResource);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Date) firstResult(query);
  }

  public ResourceHistory findResourceHistoryByIdResourceDtDtPlcmtStart(int idResource, Date dtDtPlcmtStart) {
    Query query = getSession().createQuery(" from ResourceHistory r " +
                                           "where r.capsResource.idResource = :idResource " +
                                           "  and trunc(r.dtRshsEffective) <= (:dtDtPlcmtStart) " +
                                           "  and trunc(r.dtRshsEnd) > (:dtDtPlcmtStart) ");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtDtPlcmtStart", dtDtPlcmtStart);
    return (ResourceHistory) firstResult(query);
  }

  public Integer findIdResourceByIdResourceAndDtRshsEffective(int idResource, Date dtRshsEffective) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtRshsEffective) < trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) > trunc(:dtRshsEffective)");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    return (Integer) firstResult(query);
  }

  public Integer findIdResourceDtRshsEndEqualDtRshsEffective(int idResource, Date dtRshsEnd, Date dtRshsEffective) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtRshsEnd) < trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) > trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) = trunc(dtRshsEffective)");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    return (Integer) firstResult(query);
  }

  public Integer findIdResourceDtRshsEffectiveLessThanParamDtRshsEnd(int idResource, Date dtRshsEnd,
                                                                     Date dtRshsEffective) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtRshsEffective) < trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEnd) >= trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) > trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    return (Integer) firstResult(query);
  }

  public Integer findIdResourceDtRshsEndGreaterThanParamDtRshsEffective(int idResource, Date dtRshsEffective,
                                                                        Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtRshsEnd) > trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEffective) <= trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) < trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdResourceDtRshsEffectiveLessOrEqualParamDtRshsEffective(int idResource, Date dtRshsEffective,
                                                                              Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtRshsEffective) <= trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) >= trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdResourceByIDResourceDtRshsEffectiveAndDtRshsEnd(int idResource, Date dtRshsEffective,
                                                                       Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtRshsEnd) <= trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) >= trunc(:dtRshsEffective)");
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdResourceByIDResourceHistoryNotEqualParamIDResourceHistory(int idResource, int idResourceHistory,
                                                                                 Date dtRshsEffective, Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceHistory != :idResourceHistory " +
                                           "   and trunc(dtRshsEffective) < trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) > trunc(:dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdRsrcByIDRsrcHistNotEqualParamIDRsrcHistDtRshsEndEqualDtRshsEffective(int idResource,
                                                                                            int idResourceHistory,
                                                                                            Date dtRshsEffective,
                                                                                            Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceHistory != :idResourceHistory " +
                                           "   and trunc(dtRshsEnd) < trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) > trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) = trunc(dtRshsEffective)");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdRsrcByIDRsrcHistNotEqualParamIDRsrcHistDtRshsEffectNotEqualDtRshsEnd(int idResource,
                                                                                            int iDResourceHistory,
                                                                                            Date dtRshsEffective,
                                                                                            Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceHistory != :iDResourceHistory " +
                                           "   and trunc(dtRshsEffective) < trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEnd) >= trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) > trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setInteger("iDResourceHistory", iDResourceHistory);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdRsrcByDtRshsEffectLessOrEqualParamDtRshsEffectDtRshsEndLessParamDtRshsEnd(int idResource,
                                                                                                 int idResourceHistory,
                                                                                                 Date dtRshsEffective,
                                                                                                 Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceHistory != :idResourceHistory " +
                                           "   and trunc(dtRshsEnd) > trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEffective) <= trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) < trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdRsrcByDtRshsEffectLessOrEqualParamDtRshsEffectDtRshsEndGreaterOrEqualParamDtRshsEnd(
          int idResource, int idResourceHistory, Date dtRshsEffective, Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceHistory != :idResourceHistory " +
                                           "   and trunc(dtRshsEffective) <= trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEnd) >= trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public Integer findIdRsrcByDtRshsEndLessOrEqualParamDtRshsEndDtRshsEffectGreaterOrEqualParamDtRshsEffect(
          int idResource, int idResourceHistory, Date dtRshsEffective, Date dtRshsEnd) {
    Query query = getSession().createQuery("select capsResource.idResource " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceHistory != :idResourceHistory " +
                                           "   and trunc(dtRshsEnd) <= trunc(:dtRshsEnd) " +
                                           "   and trunc(dtRshsEffective) >= trunc(:dtRshsEffective) " +
                                           "   and trunc(dtRshsEffective) != trunc(dtRshsEnd)");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    return (Integer) firstResult(query);
  }

  public long countResourceHistoryByIdStageAndCdHomeStatus(int idStage) {
    Query query = getSession().createQuery("select count(*)" +
                                           "   from ResourceHistory r" +
                                           "  where r.stage.idStage = :idStage" +
                                           "    and r.cdRshsFaHomeStatus in( 'AFA','ASA','ATA' )");
    
    query.setInteger("idStage", idStage);
    
    return (Long) query.uniqueResult();
  }
  
  public int updateResourceHistory(int idResourceHistory, int idResource, Date dtlastUpdate, Date dtRshsEffective,
                                   Date dtRshsClose, Date dtRshsCert, Date dtRshsMarriage, Date dtRshsEnd,
                                   String addrRshsStLn1, String addrRshsStLn2, String addrRshsCity, String cdRshsState,
                                   String addrRshsZip, String addrRshsAttn, String cdRshsCnty,
                                   String cdRshsInvolClosure, String cdRshsClosureRsn, String cdRshsType,
                                   String cdRshsHub, String cdRshsCampusType,
                                   String cdRshsMaintainer, String cdRshsSchDist, String cdRshsOwnership,
                                   String cdRshsStatus, String cdRshsFacilType, String cdRshsCertBy,
                                   String cdRshsOperBy, String cdRshsSetting, String cdRshsPayment,
                                   String cdRshsCategory, String cdRshsEthnicity, String cdRshsLanguage,
                                   String cdRshsMaritalStatus, String cdRshsRecmndReopen, String cdRshsRegion,
                                   String cdRshsReligion, String cdRshsRespite, String cdRshsFaHomeStatus,
                                   String cdRshsFaHomeType1, String cdRshsFaHomeType2, String cdRshsFaHomeType3,
                                   String cdRshsFaHomeType4, String cdRshsFaHomeType5, String cdRshsFaHomeType6,
                                   int idStage, int idEvent, String indRshsCareProv,
                                   String indRshsInactive, String indRshsTransport, String indRsrcNondfcs,
                                   String ndfcsCertEntity, String indRshsEmergPlace, String nmRshsResource,
                                   String nmRshsContact, String nmRshsLastUpdate, String nbrRshsVid, String nbrRshsPhn,
                                   int nbrRshsFacilCapacity, int nbrRshsFacilAcclaim, String nbrRshsPhoneExtension,
                                   int nbrRshsCampusNbr, int nbrRshsAnnualIncome, int nbrRshsFMAgeMax,
                                   int nbrRshsFMAgeMin, int nbrRshsMaAgeMax, int nbrRshsMaAgeMin,
                                   int nbrRshsIntFeAgeMax, int nbrRshsIntFeAgeMin,
                                   int nbrRshsIntMaAgeMax, int nbrRshsIntMaAgeMin, String txtRshsAddrCmnts,
                                   String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist) {
    Query query = getSession().createQuery("update ResourceHistory rh " +
                                           "   set rh.idResourceHistory = :idResourceHistory, " +
                                           "       rh.capsResource.idResource = :idResource, " +
                                           "       rh.dtLastUpdate = :dtlastUpdate, " +
                                           "       rh.dtRshsEffective = :dtRshsEffective, " +
                                           "       rh.dtRshsClose = :dtRshsClose, " +
                                           "       rh.dtRshsCert = :dtRshsCert, " +
                                           "       rh.dtRshsMarriage = :dtRshsMarriage, " +
                                           "       rh.dtRshsEnd = :dtRshsEnd, " +
                                           "       rh.addrRshsStLn1 = :addrRshsStLn1, " +
                                           "       rh.addrRshsStLn2 = :addrRshsStLn2, " +
                                           "       rh.addrRshsCity = :addrRshsCity, " +
                                           "       rh.cdRshsState = :cdRshsState, " +
                                           "       rh.addrRshsZip = :addrRshsZip, " +
                                           "       rh.addrRshsAttn = :addrRshsAttn, " +
                                           "       rh.cdRshsCnty = :cdRshsCnty, " +
                                           "       rh.cdRshsInvolClosure = :cdRshsInvolClosure, " +
                                           "       rh.cdRshsClosureRsn = :cdRshsClosureRsn, " +
                                           "       rh.cdRshsType = :cdRshsType, " +
                                           "       rh.cdRshsHub = :cdRshsHub, " +
                                           "       rh.cdRshsCampusType = :cdRshsCampusType, " +
                                           "       rh.cdRshsMaintainer = :cdRshsMaintainer, " +
                                           "       rh.cdRshsSchDist = :cdRshsSchDist, " +
                                           "       rh.cdRshsOwnership = :cdRshsOwnership, " +
                                           "       rh.cdRshsStatus = :cdRshsStatus, " +
                                           "       rh.cdRshsFacilType = :cdRshsFacilType, " +
                                           "       rh.cdRshsCertBy = :cdRshsCertBy, " +
                                           "       rh.cdRshsOperBy = :cdRshsOperBy, " +
                                           "       rh.cdRshsSetting = :cdRshsSetting, " +
                                           "       rh.cdRshsPayment = :cdRshsPayment, " +
                                           "       rh.cdRshsCategory = :cdRshsCategory, " +
                                           "       rh.cdRshsEthnicity = :cdRshsEthnicity, " +
                                           "       rh.cdRshsLanguage = :cdRshsLanguage, " +
                                           "       rh.cdRshsMaritalStatus = :cdRshsMaritalStatus, " +
                                           "       rh.cdRshsRecmndReopen = :cdRshsRecmndReopen, " +
                                           "       rh.cdRshsRegion = :cdRshsRegion, " +
                                           "       rh.cdRshsReligion = :cdRshsReligion, " +
                                           "       rh.cdRshsRespite = :cdRshsRespite, " +
                                           "       rh.cdRshsFaHomeStatus = :cdRshsFaHomeStatus, " +
                                           "       rh.cdRshsFaHomeType1 = :cdRshsFaHomeType1, " +
                                           "       rh.cdRshsFaHomeType2 = :cdRshsFaHomeType2, " +
                                           "       rh.cdRshsFaHomeType3 = :cdRshsFaHomeType3, " +
                                           "       rh.cdRshsFaHomeType4 = :cdRshsFaHomeType4, " +
                                           "       rh.cdRshsFaHomeType5 = :cdRshsFaHomeType5, " +
                                           "       rh.cdRshsFaHomeType6 = :cdRshsFaHomeType6, " +
                                           "       rh.stage.idStage = :idStage, " +
                                           "       rh.event.idEvent = :idEvent, " +
                                           "       rh.indRshsCareProv = :indRshsCareProv, " +
                                           "       rh.indRshsInactive = :indRshsInactive, " +
                                           "       rh.indRshsTransport = :indRshsTransport, " +
                                           "       rh.indRsrcNondfcs = :indRsrcNondfcs, " +
                                           "       rh.ndfcsCertEntity = :ndfcsCertEntity, " +
                                           "       rh.indRshsEmergPlace = :indRshsEmergPlace, " +
                                           "       rh.nmRshsResource = :nmRshsResource, " +
                                           "       rh.nmRshsContact = :nmRshsContact, " +
                                           "       rh.nmRshsLastUpdate = :nmRshsLastUpdate, " +
                                           "       rh.nbrRshsVid = :nbrRshsVid, " +
                                           "       rh.nbrRshsPhn = :nbrRshsPhn, " +
                                           "       rh.nbrRshsFacilCapacity = :nbrRshsFacilCapacity, " +
                                           "       rh.nbrRshsFacilAcclaim = :nbrRshsFacilAcclaim, " +
                                           "       rh.nbrRshsPhoneExt = :nbrRshsPhoneExtension, " +
                                           "       rh.nbrRshsCampusNbr = :nbrRshsCampusNbr, " +
                                           "       rh.nbrRshsAnnualIncome = :nbrRshsAnnualIncome, " +
                                           "       rh.nbrRshsFmAgeMax = :nbrRshsFMAgeMax, " +
                                           "       rh.nbrRshsFmAgeMin = :nbrRshsFMAgeMin, " +
                                           "       rh.nbrRshsMaAgeMax = :nbrRshsMaAgeMax, " +
                                           "       rh.nbrRshsMaAgeMin = :nbrRshsMaAgeMin, " +
                                           "       rh.nbrRshsIntFeAgeMax = :nbrRshsIntFeAgeMax, " +
                                           "       rh.nbrRshsIntFeAgeMin = :nbrRshsIntFeAgeMin, " +
                                           "       rh.nbrRshsIntMaAgeMax = :nbrRshsIntMaAgeMax, " +
                                           "       rh.nbrRshsIntMaAgeMin = :nbrRshsIntMaAgeMin, " +
                                           "       rh.txtRshsAddrCmnts = :txtRshsAddrCmnts, " +
                                           "       rh.txtRshsComments = :txtRshsComments, " +
                                           "       rh.nbrRshsOpenSlots = :nbrRshsOpenSlots, " +
                                           "       rh.indRshsWriteAudit = :indRshsWriteHist " +
                                           " where rh.idResourceHistory = :idResourceHistory " +
                                           "   and rh.dtLastUpdate = :dtlastUpdate ");
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtlastUpdate", dtlastUpdate);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsClose", dtRshsClose);
    query.setTimestamp("dtRshsCert", dtRshsCert);
    query.setTimestamp("dtRshsMarriage", dtRshsMarriage);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    query.setString("addrRshsStLn1", addrRshsStLn1);
    query.setString("addrRshsStLn2", addrRshsStLn2);
    query.setString("addrRshsCity", addrRshsCity);
    query.setString("cdRshsState", cdRshsState);
    query.setString("addrRshsZip", addrRshsZip);
    query.setString("addrRshsAttn", addrRshsAttn);
    query.setString("cdRshsCnty", cdRshsCnty);
    query.setString("cdRshsInvolClosure", cdRshsInvolClosure);
    query.setString("cdRshsClosureRsn", cdRshsClosureRsn);
    query.setString("cdRshsType", cdRshsType);
    query.setString("cdRshsHub", cdRshsHub);
    query.setString("cdRshsCampusType", cdRshsCampusType);
    query.setString("cdRshsMaintainer", cdRshsMaintainer);
    query.setString("cdRshsSchDist", cdRshsSchDist);
    query.setString("cdRshsOwnership", cdRshsOwnership);
    query.setString("cdRshsStatus", cdRshsStatus);
    query.setString("cdRshsFacilType", cdRshsFacilType);
    query.setString("cdRshsCertBy", cdRshsCertBy);
    query.setString("cdRshsOperBy", cdRshsOperBy);
    query.setString("cdRshsSetting", cdRshsSetting);
    query.setString("cdRshsPayment", cdRshsPayment);
    query.setString("cdRshsCategory", cdRshsCategory);
    query.setString("cdRshsEthnicity", cdRshsEthnicity);
    query.setString("cdRshsLanguage", cdRshsLanguage);
    query.setString("cdRshsMaritalStatus", cdRshsMaritalStatus);
    query.setString("cdRshsRecmndReopen", cdRshsRecmndReopen);
    query.setString("cdRshsRegion", cdRshsRegion);
    query.setString("cdRshsReligion", cdRshsReligion);
    query.setString("cdRshsRespite", cdRshsRespite);
    query.setString("cdRshsFaHomeStatus", cdRshsFaHomeStatus);
    query.setString("cdRshsFaHomeType1", cdRshsFaHomeType1);
    query.setString("cdRshsFaHomeType2", cdRshsFaHomeType2);
    query.setString("cdRshsFaHomeType3", cdRshsFaHomeType3);
    query.setString("cdRshsFaHomeType4", cdRshsFaHomeType4);
    query.setString("cdRshsFaHomeType5", cdRshsFaHomeType5);
    query.setString("cdRshsFaHomeType6", cdRshsFaHomeType6);
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);
    query.setString("indRshsCareProv", indRshsCareProv);
    query.setString("indRshsInactive", indRshsInactive);
    query.setString("indRshsTransport", indRshsTransport);
    query.setString("indRsrcNondfcs", indRsrcNondfcs);
    query.setString("ndfcsCertEntity", ndfcsCertEntity);
    query.setString("indRshsEmergPlace", indRshsEmergPlace);
    query.setString("nmRshsResource", nmRshsResource);
    query.setString("nmRshsContact", nmRshsContact);
    query.setString("nmRshsLastUpdate", nmRshsLastUpdate);
    query.setString("nbrRshsVid", nbrRshsVid);
    query.setString("nbrRshsPhn", nbrRshsPhn);
    query.setInteger("nbrRshsFacilCapacity", nbrRshsFacilCapacity);
    query.setInteger("nbrRshsFacilAcclaim", nbrRshsFacilAcclaim);
    query.setString("nbrRshsPhoneExtension", nbrRshsPhoneExtension);
    query.setInteger("nbrRshsCampusNbr", nbrRshsCampusNbr);
    query.setInteger("nbrRshsAnnualIncome", nbrRshsAnnualIncome);
    query.setInteger("nbrRshsFMAgeMax", nbrRshsFMAgeMax);
    query.setInteger("nbrRshsFMAgeMin", nbrRshsFMAgeMin);
    query.setInteger("nbrRshsMaAgeMax", nbrRshsMaAgeMax);
    query.setInteger("nbrRshsMaAgeMin", nbrRshsMaAgeMin);
    query.setInteger("nbrRshsIntFeAgeMax", nbrRshsIntFeAgeMax);
    query.setInteger("nbrRshsIntFeAgeMin", nbrRshsIntFeAgeMin);
    query.setInteger("nbrRshsIntMaAgeMax", nbrRshsIntMaAgeMax);
    query.setInteger("nbrRshsIntMaAgeMin", nbrRshsIntMaAgeMin);
    query.setString("txtRshsAddrCmnts", txtRshsAddrCmnts);
    query.setString("txtRshsComments", txtRshsComments);
    query.setInteger("nbrRshsOpenSlots", nbrRshsOpenSlots);
    query.setString("indRshsWriteHist", indRshsWriteHist);
    return query.executeUpdate();
  }

  public int insertResourceHistory(int idResourceHistory, int idResource, Date dtLastUpdate, Date dtRshsEffective,
                                   Date dtRshsClose, Date dtRshsCert, Date dtRshsMarriage, Date dtRshsEnd,
                                   String addrRshsStLn1, String addrRshsStLn2, String addrRshsCity, String cdRshsState,
                                   String addrRshsZip, String addrRshsAttn, String cdRshsCnty,
                                   String cdRshsInvolClosure, String cdRshsClosureRsn, String cdRshsType,
                                   String cdRshsHub, String cdRshsCampusType, String cdRshsSourceInquiry,
                                   String cdRshsMaintainer, String cdRshsSchDist, String cdRshsOwnership,
                                   String cdRshsStatus, String cdRshsFacilType, String cdRshsCertBy,
                                   String cdRshsOperBy, String cdRshsSetting, String cdRshsPayment,
                                   String cdRshsCategory, String cdRshsEthnicity, String cdRshsLanguage,
                                   String cdRshsMaritalStatus, String cdRshsRecmndReopen, String cdRshsRegion,
                                   String cdRshsReligion, String cdRshsRespite, String cdRshsFaHomeStatus,
                                   String cdRshsFaHomeType1, String cdRshsFaHomeType2, String cdRshsFaHomeType3,
                                   String cdRshsFaHomeType4, String cdRshsFaHomeType5, String cdRshsFaHomeType6,
                                   String cdRshsFaHomeType7, int idStage, int idEvent, String indRshsCareProv,
                                   String indRshsInactive, String indRshsTransport,
                                   String indRsrcNondfcs, String ndfcsCertEntity, String indRshsEmergPlace,
                                   String nmRshsResource, String nmRshsContact, String nmRshsLastUpdate,
                                   String nbrRshsVid, String nbrRshsPhn, int nbrRshsFacilCapacity,
                                   int nbrRshsFacilAcclaim, String nbrRshsPhoneExtension, int nbrRshsCampusNbr,
                                   int nbrRshsAnnualIncome, int nbrRshsFMAgeMax, int nbrRshsFMAgeMin,
                                   int nbrRshsMaAgeMax, int nbrRshsMaAgeMin, int nbrRshsIntChildren,
                                   int nbrRshsIntFeAgeMax, int nbrRshsIntFeAgeMin, int nbrRshsIntMaAgeMax,
                                   int nbrRshsIntMaAgeMin, String txtRshsAddrCmnts, String txtRshsComments,
                                   int nbrRshsOpenSlots, String indRshsWriteHist) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO RESOURCE_HISTORY (ID_RESOURCE_HISTORY, " +
                                                 "                              ID_RESOURCE, " +
                                                 "                              DT_LAST_UPDATE, " +
                                                 "                              DT_RSHS_EFFECTIVE, " +
                                                 "                              DT_RSHS_CLOSE, " +
                                                 "                              DT_RSHS_CERT, " +
                                                 "                              DT_RSHS_MARRIAGE, " +
                                                 "                              DT_RSHS_END,ADDR_RSHS_ST_LN_1, " +
                                                 "                              ADDR_RSHS_ST_LN_2, " +
                                                 "                              ADDR_RSHS_CITY, " +
                                                 "                              CD_RSHS_STATE, " +
                                                 "                              ADDR_RSHS_ZIP, " +
                                                 "                              ADDR_RSHS_ATTN, " +
                                                 "                              CD_RSHS_CNTY, " +
                                                 "                              CD_RSHS_INVOL_CLOSURE, " +
                                                 "                              CD_RSHS_CLOSURE_RSN, " +
                                                 "                              CD_RSHS_TYPE, " +
                                                 "                              CD_RSHS_HUB, " +
                                                 "                              CD_RSHS_CAMPUS_TYPE, " +
                                                 "                              CD_RSHS_SOURCE_INQUIRY, " +
                                                 "                              CD_RSHS_MAINTAINER, " +
                                                 "                              CD_RSHS_SCH_DIST, " +
                                                 "                              CD_RSHS_OWNERSHIP, " +
                                                 "                              CD_RSHS_STATUS, " +
                                                 "                              CD_RSHS_FACIL_TYPE, " +
                                                 "                              CD_RSHS_CERT_BY, " +
                                                 "                              CD_RSHS_OPER_BY, " +
                                                 "                              CD_RSHS_SETTING, " +
                                                 "                              CD_RSHS_PAYMENT, " +
                                                 "                              CD_RSHS_CATEGORY, " +
                                                 "                              CD_RSHS_ETHNICITY, " +
                                                 "                              CD_RSHS_LANGUAGE, " +
                                                 "                              CD_RSHS_MARITAL_STATUS, " +
                                                 "                              CD_RSHS_RECMND_REOPEN, " +
                                                 "                              CD_RSHS_REGION, " +
                                                 "                              CD_RSHS_RELIGION, " +
                                                 "                              CD_RSHS_RESPITE, " +
                                                 "                              CD_RSHS_FA_HOME_STATUS, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE1, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE2, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE3, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE4, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE5, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE6, " +
                                                 "                              CD_RSHS_FA_HOME_TYPE7, " +
                                                 "                              ID_RSHS_FA_HOME_STAGE, " +
                                                 "                              ID_RSHS_FA_HOME_EVENT, " +
                                                 "                              IND_RSHS_CARE_PROV, " +
                                                 "                              IND_RSHS_INACTIVE, " +
                                                 "                              IND_RSHS_TRANSPORT, " +
                                                 "                              IND_RSRC_NONDFCS, " +
                                                 "                              NDFCS_CERT_ENTITY, " +
                                                 "                              IND_RSHS_EMERG_PLACE, " +
                                                 "                              NM_RSHS_RESOURCE, " +
                                                 "                              NM_RSHS_CONTACT, " +
                                                 "                              NM_RSHS_LAST_UPDATE, " +
                                                 "                              NBR_RSHS_VID,NBR_RSHS_PHN, " +
                                                 "                              NBR_RSHS_FACIL_CAPACITY, " +
                                                 "                              NBR_RSHS_FACIL_ACCLAIM, " +
                                                 "                              NBR_RSHS_PHONE_EXT, " +
                                                 "                              NBR_RSHS_CAMPUS_NBR, " +
                                                 "                              NBR_RSHS_ANNUAL_INCOME, " +
                                                 "                              NBR_RSHS_FM_AGE_MAX, " +
                                                 "                              NBR_RSHS_FM_AGE_MIN, " +
                                                 "                              NBR_RSHS_MA_AGE_MAX, " +
                                                 "                              NBR_RSHS_MA_AGE_MIN, " +
                                                 "                              NBR_RSHS_INT_CHILDREN, " +
                                                 "                              NBR_RSHS_INT_FE_AGE_MAX, " +
                                                 "                              NBR_RSHS_INT_FE_AGE_MIN, " +
                                                 "                              NBR_RSHS_INT_MA_AGE_MAX, " +
                                                 "                              NBR_RSHS_INT_MA_AGE_MIN, " +
                                                 "                              TXT_RSHS_ADDR_CMNTS, " +
                                                 "                              TXT_RSHS_COMMENTS, " +
                                                 "                              NBR_RSHS_OPEN_SLOTS, " +
                                                 "                              IND_RSHS_WRITE_AUDIT ) " +
                                                 "      VALUES(:idResourceHistory, " +
                                                 "             :idResource, " +
                                                 "             :dtLastUpdate, " +
                                                 "             :dtRshsEffective, " +
                                                 "             :dtRshsClose, " +
                                                 "             :dtRshsCert, " +
                                                 "             :dtRshsMarriage, " +
                                                 "             :dtRshsEnd, " +
                                                 "             :addrRshsStLn1, " +
                                                 "             :addrRshsStLn2, " +
                                                 "             :addrRshsCity, " +
                                                 "             :cdRshsState, " +
                                                 "             :addrRshsZip, " +
                                                 "             :addrRshsAttn, " +
                                                 "             :cdRshsCnty, " +
                                                 "             :cdRshsInvolClosure, " +
                                                 "             :cdRshsClosureRsn, " +
                                                 "             :cdRshsType, " +
                                                 "             :cdRshsHub, " +
                                                 "             :cdRshsCampusType, " +
                                                 "             :cdRshsSourceInquiry, " +
                                                 "             :cdRshsMaintainer, " +
                                                 "             :cdRshsSchDist, " +
                                                 "             :cdRshsOwnership, " +
                                                 "             :cdRshsStatus, " +
                                                 "             :cdRshsFacilType, " +
                                                 "             :cdRshsCertBy, " +
                                                 "             :cdRshsOperBy, " +
                                                 "             :cdRshsSetting, " +
                                                 "             :cdRshsPayment, " +
                                                 "             :cdRshsCategory, " +
                                                 "             :cdRshsEthnicity, " +
                                                 "             :cdRshsLanguage, " +
                                                 "             :cdRshsMaritalStatus, " +
                                                 "             :cdRshsRecmndReopen, " +
                                                 "             :cdRshsRegion, " +
                                                 "             :cdRshsReligion, " +
                                                 "             :cdRshsRespite, " +
                                                 "             :cdRshsFaHomeStatus, " +
                                                 "             :cdRshsFaHomeType1, " +
                                                 "             :cdRshsFaHomeType2, " +
                                                 "             :cdRshsFaHomeType3, " +
                                                 "             :cdRshsFaHomeType4, " +
                                                 "             :cdRshsFaHomeType5, " +
                                                 "             :cdRshsFaHomeType6, " +
                                                 "             :cdRshsFaHomeType7, " +
                                                 "             :idStage, " +
                                                 "             :idEvent, " +
                                                 "             :indRshsCareProv, " +
                                                 "             :indRshsInactive, " +
                                                 "             :indRshsTransport, " +
                                                 "             :indRsrcNondfcs, " +
                                                 "             :ndfcsCertEntity, " +
                                                 "             :indRshsEmergPlace, " +
                                                 "             :nmRshsResource, " +
                                                 "             :nmRshsContact, " +
                                                 "             :nmRshsLastUpdate, " +
                                                 "             :nbrRshsVid, " +
                                                 "             :nbrRshsPhn, " +
                                                 "             :nbrRshsFacilCapacity, " +
                                                 "             :nbrRshsFacilAcclaim, " +
                                                 "             :nbrRshsPhoneExtension, " +
                                                 "             :nbrRshsCampusNbr, " +
                                                 "             :nbrRshsAnnualIncome, " +
                                                 "             :nbrRshsFMAgeMax, " +
                                                 "             :nbrRshsFMAgeMin, " +
                                                 "             :nbrRshsMaAgeMax, " +
                                                 "             :nbrRshsMaAgeMin, " +
                                                 "             :nbrRshsIntChildren, " +
                                                 "             :nbrRshsIntFeAgeMax, " +
                                                 "             :nbrRshsIntFeAgeMin, " +
                                                 "             :nbrRshsIntMaAgeMax, " +
                                                 "             :nbrRshsIntMaAgeMin, " +
                                                 "             :txtRshsAddrCmnts, " +
                                                 "             :txtRshsComments, " +
                                                 "             :nbrRshsOpenSlots, " +
                                                 "             :indRshsWriteHist) ");
    query.setInteger("idResourceHistory", idResourceHistory);
    query.setInteger("idResource", idResource);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setTimestamp("dtRshsEffective", dtRshsEffective);
    query.setTimestamp("dtRshsClose", dtRshsClose);
    query.setTimestamp("dtRshsCert", dtRshsCert);
    query.setTimestamp("dtRshsMarriage", dtRshsMarriage);
    query.setTimestamp("dtRshsEnd", dtRshsEnd);
    query.setString("addrRshsStLn1", addrRshsStLn1);
    query.setString("addrRshsStLn2", addrRshsStLn2);
    query.setString("addrRshsCity", addrRshsCity);
    query.setString("cdRshsState", cdRshsState);
    query.setString("addrRshsZip", addrRshsZip);
    query.setString("addrRshsAttn", addrRshsAttn);
    query.setString("cdRshsCnty", cdRshsCnty);
    query.setString("cdRshsInvolClosure", cdRshsInvolClosure);
    query.setString("cdRshsClosureRsn", cdRshsClosureRsn);
    query.setString("cdRshsType", cdRshsType);
    query.setString("cdRshsHub", cdRshsHub);
    query.setString("cdRshsCampusType", cdRshsCampusType);
    query.setString("cdRshsSourceInquiry", cdRshsSourceInquiry);
    query.setString("cdRshsMaintainer", cdRshsMaintainer);
    query.setString("cdRshsSchDist", cdRshsSchDist);
    query.setString("cdRshsOwnership", cdRshsOwnership);
    query.setString("cdRshsStatus", cdRshsStatus);
    query.setString("cdRshsFacilType", cdRshsFacilType);
    query.setString("cdRshsCertBy", cdRshsCertBy);
    query.setString("cdRshsOperBy", cdRshsOperBy);
    query.setString("cdRshsSetting", cdRshsSetting);
    query.setString("cdRshsPayment", cdRshsPayment);
    query.setString("cdRshsCategory", cdRshsCategory);
    query.setString("cdRshsEthnicity", cdRshsEthnicity);
    query.setString("cdRshsLanguage", cdRshsLanguage);
    query.setString("cdRshsMaritalStatus", cdRshsMaritalStatus);
    query.setString("cdRshsRecmndReopen", cdRshsRecmndReopen);
    query.setString("cdRshsRegion", cdRshsRegion);
    query.setString("cdRshsReligion", cdRshsReligion);
    query.setString("cdRshsRespite", cdRshsRespite);
    query.setString("cdRshsFaHomeStatus", cdRshsFaHomeStatus);
    query.setString("cdRshsFaHomeType1", cdRshsFaHomeType1);
    query.setString("cdRshsFaHomeType2", cdRshsFaHomeType2);
    query.setString("cdRshsFaHomeType3", cdRshsFaHomeType3);
    query.setString("cdRshsFaHomeType4", cdRshsFaHomeType4);
    query.setString("cdRshsFaHomeType5", cdRshsFaHomeType5);
    query.setString("cdRshsFaHomeType6", cdRshsFaHomeType6);
    query.setString("cdRshsFaHomeType7", cdRshsFaHomeType7);
    query.setInteger("idStage", idStage);
    query.setInteger("idEvent", idEvent);
    query.setString("indRshsCareProv", indRshsCareProv);
    query.setString("indRshsInactive", indRshsInactive);
    query.setString("indRshsTransport", indRshsTransport);
    query.setString("indRsrcNondfcs", indRsrcNondfcs);
    query.setString("ndfcsCertEntity", ndfcsCertEntity);
    query.setString("indRshsEmergPlace", indRshsEmergPlace);
    query.setString("nmRshsResource", nmRshsResource);
    query.setString("nmRshsContact", nmRshsContact);
    query.setString("nmRshsLastUpdate", nmRshsLastUpdate);
    query.setString("nbrRshsVid", nbrRshsVid);
    query.setString("nbrRshsPhn", nbrRshsPhn);
    query.setInteger("nbrRshsFacilCapacity", nbrRshsFacilCapacity);
    query.setInteger("nbrRshsFacilAcclaim", nbrRshsFacilAcclaim);
    query.setString("nbrRshsPhoneExtension", nbrRshsPhoneExtension);
    query.setInteger("nbrRshsCampusNbr", nbrRshsCampusNbr);
    query.setInteger("nbrRshsAnnualIncome", nbrRshsAnnualIncome);
    query.setInteger("nbrRshsFMAgeMax", nbrRshsFMAgeMax);
    query.setInteger("nbrRshsFMAgeMin", nbrRshsFMAgeMin);
    query.setInteger("nbrRshsMaAgeMax", nbrRshsMaAgeMax);
    query.setInteger("nbrRshsMaAgeMin", nbrRshsMaAgeMin);
    query.setInteger("nbrRshsIntChildren", nbrRshsIntChildren);
    query.setInteger("nbrRshsIntFeAgeMax", nbrRshsIntFeAgeMax);
    query.setInteger("nbrRshsIntFeAgeMin", nbrRshsIntFeAgeMin);
    query.setInteger("nbrRshsIntMaAgeMax", nbrRshsIntMaAgeMax);
    query.setInteger("nbrRshsIntMaAgeMin", nbrRshsIntMaAgeMin);
    query.setString("txtRshsAddrCmnts", txtRshsAddrCmnts);
    query.setString("txtRshsComments", txtRshsComments);
    query.setInteger("nbrRshsOpenSlots", nbrRshsOpenSlots);
    query.setString("indRshsWriteHist", indRshsWriteHist);
    return query.executeUpdate();
  }

  public void deleteResourceHistory(ResourceHistory resourceHistory) {
    getSession().delete(resourceHistory);
  }

  /**
   * This query is used to get the last (maximum) F/A Home approved date.
   *
   * @param idPerson
   * @param stage
   * @param faHomeStatus
   * @return
   */
  
  //STGAP00010494 - Change the name of this method to findMaxEffectiveDateByHomeStatusIdPerson
  public Date findMaxEffectiveDateByHomeStatusIdPerson(int idPerson, String stage, String faHomeStatus) {
    // STGAP00010494 - Updated the query to find the last (maximum) approval date.
    Query query = getSession().createQuery("select MAX(rh.dtRshsEffective) as maxEffectiveDate " + 
                                           "  from ResourceHistory rh, " +
                                           "       Stage s, " +
                                           "       StagePersonLink sp " + 
                                           " where s.idStage = sp.stage.idStage " +
                                           "   and rh.stage.idStage = sp.stage.idStage " +
                                           "   and rh.stage.idStage = s.idStage " +
                                           "   and s.capsCase.idCase = sp.capsCase.idCase " +
                                           "   and rh.capsCase.idCase = sp.capsCase.idCase " +
                                           "   and sp.person.idPerson = :idPerson " +
                                           "   and s.cdStage = :stage " +
                                          "   and rh.cdRshsFaHomeStatus in(:faHomeStatusAFA, :faHomeStatusASA, :faHomeStatusATA) ");
    query.setInteger("idPerson", idPerson);
    query.setString("stage", stage);
    query.setString("faHomeStatusAFA", "AFA");
    query.setString("faHomeStatusASA", "ASA");
    query.setString("faHomeStatusATA", "ATA");
    return (Date) firstResult(query);
  }



  /**
   *
   */
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<ResourceHistory> findResourceHistoryListByIdStage(int idStage, int pageNbr,
                                                                                  int pageSize) {
    Query query = getSession().createQuery("    from ResourceHistory rh " +
                                           "   where rh.stage.idStage = :idStage " +
                                           "order by rh.dtRshsEnd desc, " +
                                           "         rh.dtRshsEffective desc");
    query.setInteger("idStage", idStage);
    return (PaginatedHibernateList<ResourceHistory>) paginatedList(pageNbr, pageSize, query);
  }

  /**
   * @param idResourceHistory
   * @return
   */
  public int deleteResourceHistory(int idResourceHistory) {
    Query query = getSession().createQuery("delete ResourceHistory rh " +
                                           " where rh.idResourceHistory = :idResourceHistory ");
    query.setInteger("idResourceHistory", idResourceHistory);
    return query.executeUpdate();
  }
  

  @SuppressWarnings({"unchecked"}) 
  public ResourceHistory findResourceHistoryMaxEffectiveByIdEvent(int idEvent) {
    Query query = getSession().createQuery("  from ResourceHistory r " +
                                           " where r.event.idEvent = :event " +
                                           "   and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PCL + "' " +
                                           "   and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PFA + "' " +
                                           "   and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PSA + "' " +
                                           "   and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PTA + "' " +
                                           "   and r.cdRshsFaHomeStatus != 'PV' " +
                                           "   and r.dtRshsEffective = " +
                                           "       (select max(r2.dtRshsEffective) " +
                                           "          from ResourceHistory r2 " +
                                           "         where r2.cdRshsFaHomeStatus !='" + CodesTables.CFAHMSTA_PCL + "' " +
                                           "           and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PFA + "' " +
                                           "           and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PSA + "' " +
                                           "           and r.cdRshsFaHomeStatus != '" + CodesTables.CFAHMSTA_PTA + "' " +
                                           "           and r2.cdRshsFaHomeStatus !='PV') " +
                                           "   order by r.idResourceHistory desc ");
    query.setInteger("event", idEvent);
    return (ResourceHistory) firstResult(query);
  }

  @SuppressWarnings({"unchecked"}) 
  public String findResourceCurrentIveReimbursableStatus(int idResource) {
    Query query = getSession().createQuery("select indHomeIveReimbursable " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtReimbursableEffective) <= trunc(sysdate) " +
                                           "   and dtReimbursableEnd is not null " +
                                           "   and trunc(dtReimbursableEnd) > trunc(sysdate) " +
                                           " order by dtReimbursableEnd desc ");
    query.setInteger("idResource", idResource);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"}) 
  public Date findLastApprovalDateByIdResourceByCdFaHomeStatuses(int idResource, List<String> cdFaHomeStatuses) {
    Query query = getSession().createQuery("SELECT h.dtRshsEffective " +
                                              " FROM  Stage s, ResourceHistory h, ResourceHistory h2 " +
                                              " WHERE h.capsResource.idResource = h2.capsResource.idResource " +
                                              " and h.capsResource.idResource = :idResource " +
                                              " AND h.stage.idStage = s.idStage " +
                                              " AND s.dtStageClose IS NULL " +
                                              " AND h.cdRshsFaHomeStatus IN ( :cdFaHomeStatuses ) " +
                                              " AND h2.cdRshsFaHomeStatus <> h.cdRshsFaHomeStatus " +
                                              " AND h2.dtRshsEffective = (SELECT MAX(h3.dtRshsEffective) " +
                                                " FROM ResourceHistory h3 " +
                                                " WHERE h3.capsResource.idResource = h.capsResource.idResource " +
                                                " AND h3.cdRshsFaHomeStatus <> h.cdRshsFaHomeStatus " +
                                                " and h3.dtRshsEffective < h.dtRshsEffective) " +
                                              " AND h.dtRshsEffective = (SELECT MIN(h4.dtRshsEffective) " +
                                                " FROM ResourceHistory h4 " +
                                                " WHERE h4.capsResource.idResource = h.capsResource.idResource " +
                                                " AND h4.cdRshsFaHomeStatus = h.cdRshsFaHomeStatus " +
                                                " and h4.dtRshsEffective > h2.dtRshsEffective)");
    query.setInteger("idResource", idResource);
    query.setParameterList("cdFaHomeStatuses", cdFaHomeStatuses);
    return (Date) firstResult(query);
  }

  @SuppressWarnings({"unchecked"}) 
  public String findResourceIveReimbursableStatusByDate(int idResource, Date dtEffective) {
    Query query = getSession().createQuery("select indHomeIveReimbursable " +
                                           "  from ResourceHistory " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and trunc(dtReimbursableEffective) <= trunc(:dtEffective) " +
                                           "   and dtReimbursableEnd is not null " +
                                           "   and trunc(dtReimbursableEnd) > trunc(:dtEffective) " +
                                           " order by dtReimbursableEnd desc ");
    query.setInteger("idResource", idResource);
    query.setDate("dtEffective", dtEffective);
    return (String) firstResult(query);
  }
}
