/**
 * Created on Mar 25, 2006 at 3:26:31 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;

import java.util.Date;
import java.util.List;

/**
 * This interface defines the access methods to query, insert into and update the RESOURCE_HISTORY table.
 * 
 * @author  
 *
 * <pre>
 *   Change History:
 *   Date      User        Description
 *   --------  ----------  --------------------------------------------------
 *   10/28/08  alwilliams  STGAP00010494 - Renamed method findMinEffectiveDateByHomeStatusIdPerson
 *                         to findMaxEffectiveDateByHomeStatusIdPerson. 
 *   03/23/09  arege       STGAP00012363: Changed method findResourceHistoryMaxEffective so  
 *                         that it takes into account correct FA home status.
 *   02/28/11  hnguyen     SMS#97850: MR-075 Added method findResourceCurrentIveReimbursableStatus(idResource).
 *   03/20/11  hnguyen     SMS#97850: MR-075 Added method findLastApprovalDateByIdResourceByCdFaHomeStatuses.
 *   03/21/11  hnguyen     SMS#97850: MR-075 Added method findResourceIveReimbursableStatusByDate(idResource, Date).
 * 
 *                         
 *                                                    
 * </pre>
 */
public interface ResourceHistoryDAO {
  /**
   * This selects a row from ResourceHistory by the associated event.
   *
   * @param idRshsFaHomeEvent
   * @return
   */
  ResourceHistory findResourceHistoryByIdEvent(int idRshsFaHomeEvent);

  /**
   * This selects a row from ResourceHistory by its primary ID.
   *
   * @param idResourceHistory
   * @return
   */
  ResourceHistory findResourceHistory(int idResourceHistory);
 
  /**
   * This selects a row from ResourceHistory where the effective date is the most recent date and FA home status is <>
   * 'PFA' or 'PTA' or 'PSA' or 'PCL'.
   *
   * @param event
   * @return
   */
   ResourceHistory findResourceHistoryMaxEffective(int idResource);

  /**
   * This counts the rows in the ResourceHistory Table.
   *
   * @param idStage
   * @return
   */
  long countResourceHistoryRowsByStageAndHomeStatus(int idStage);

  /**
   * This selects a row from ResourceHistory given idStage.
   *
   * @param idStage
   * @return
   */
  ResourceHistory findResourceHistoryByIdStage(int idStage);

  /**
   * This retrieves multiple rows from ResourceHistory given idStage.
   *
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<ResourceHistory> findResourceHistoryListByIdStage(int idStage);

  /**
   * This DAM will select a full row of the first record for the ID RESOURCE on the RESOURCE HISTORY table(where DT RSHS
   * EFFECTIVE is  <= PlacementStartDate and DT RSHS END is greater than PlacementStartDate).  This date will be
   * important in retrieving the correct row for historical placements.
   *
   * @param idResource
   * @param dtDtPlcmtStart
   * @return
   */
  ResourceHistory findResourceHistoryByIdResourceDtDtPlcmtStart(int idResource, Date dtDtPlcmtStart);

  /**
   * Retrieves an idResource from ResourceHistory given idResource and dtrshseffective.
   *
   * @param idResource
   * @param dtRshsEffective
   * @return Integer
   */
  Integer findIdResourceByIdResourceAndDtRshsEffective(int idResource, Date dtRshsEffective);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, dtRshsEnd and dtrshseffective.
   *
   * @param idResource
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdResourceDtRshsEndEqualDtRshsEffective(int idResource, Date dtRshsEnd, Date dtRshsEffective);

  /**
   * Retrieves an idResource from ResourceHistory given idResource dtRshsEnd and dtrshseffective.
   *
   * @param idResource
   * @param dtRshsEnd
   * @param dtRshsEffective
   * @return Integer
   */
  Integer findIdResourceDtRshsEffectiveLessThanParamDtRshsEnd(int idResource, Date dtRshsEnd, Date dtRshsEffective);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdResourceDtRshsEndGreaterThanParamDtRshsEffective(int idResource, Date dtRshsEffective, Date dtRshsEnd);

  /**
   * TRetrieves an idResource from ResourceHistory given idResource, dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdResourceDtRshsEffectiveLessOrEqualParamDtRshsEffective(int idResource, Date dtRshsEffective,
                                                                       Date dtRshsEnd);
  
  /**
  * Retrieves the earliest approval date from ResourceHistory given idResource.
  *
  * @param idResource
  * @return Date
  */
  Date findEarliestAprvDateResourceHistoryDateByIdResource(int idResource);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdResourceByIDResourceDtRshsEffectiveAndDtRshsEnd(int idResource, Date dtRshsEffective, Date dtRshsEnd);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, iDResourceHistory,dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param iDResourceHistory
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdResourceByIDResourceHistoryNotEqualParamIDResourceHistory(int idResource, int iDResourceHistory,
                                                                          Date dtRshsEffective, Date dtRshsEnd);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, iDResourceHistory,dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param iDResourceHistory
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdRsrcByIDRsrcHistNotEqualParamIDRsrcHistDtRshsEndEqualDtRshsEffective(int idResource,
                                                                                     int iDResourceHistory,
                                                                                     Date dtRshsEffective,
                                                                                     Date dtRshsEnd);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, iDResourceHistory,dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param iDResourceHistory
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdRsrcByIDRsrcHistNotEqualParamIDRsrcHistDtRshsEffectNotEqualDtRshsEnd(int idResource,
                                                                                     int iDResourceHistory,
                                                                                     Date dtRshsEffective,
                                                                                     Date dtRshsEnd);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, iDResourceHistory,dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param iDResourceHistory
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdRsrcByDtRshsEffectLessOrEqualParamDtRshsEffectDtRshsEndLessParamDtRshsEnd(int idResource,
                                                                                          int iDResourceHistory,
                                                                                          Date dtRshsEffective,
                                                                                          Date dtRshsEnd);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, iDResourceHistory,dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param iDResourceHistory
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdRsrcByDtRshsEffectLessOrEqualParamDtRshsEffectDtRshsEndGreaterOrEqualParamDtRshsEnd(
          int idResource, int iDResourceHistory, Date dtRshsEffective, Date dtRshsEnd);

  /**
   * Retrieves an idResource from ResourceHistory given idResource, iDResourceHistory,dtRshsEffective and dtRshsEnd.
   *
   * @param idResource
   * @param iDResourceHistory
   * @param dtRshsEffective
   * @param dtRshsEnd
   * @return Integer
   */
  Integer findIdRsrcByDtRshsEndLessOrEqualParamDtRshsEndDtRshsEffectGreaterOrEqualParamDtRshsEffect(
          int idResource, int iDResourceHistory, Date dtRshsEffective, Date dtRshsEnd);

  /**
   * Return a count of resource history rows by for a given stage and home status values
   * 
   * @param idStage
   * @return
   */
  long countResourceHistoryByIdStageAndCdHomeStatus(int idStage);
  
  /**
   * Partial update of ResourceHistory table using the supplied parameters(column values).
   *
   * @param idResourceHistory
   * @param idResource
   * @param dtlastUpdate
   * @param dtRshsEffective
   * @param dtRshsClose
   * @param dtRshsCert
   * @param dtRshsMarriage
   * @param dtRshsEnd
   * @param addrRshsStLn1
   * @param addrRshsStLn2
   * @param addrRshsCity
   * @param cdRshsState
   * @param addrRshsZip
   * @param addrRshsAttn
   * @param cdRshsCnty
   * @param cdRshsInvolClosure
   * @param cdRshsClosureRsn
   * @param cdRshsType
   * @param cdRshsHub
   * @param cdRshsCampusType
   * @param cdRshsSourceInquiry
   * @param cdRshsMaintainer
   * @param cdRshsSchDist
   * @param cdRshsOwnership
   * @param cdRshsStatus
   * @param cdRshsFacilType
   * @param cdRshsCertBy
   * @param cdRshsOperBy
   * @param cdRshsSetting
   * @param cdRshsPayment
   * @param cdRshsCategory
   * @param cdRshsEthnicity
   * @param cdRshsLanguage
   * @param cdRshsMaritalStatus
   * @param cdRshsRecmndReopen
   * @param cdRshsRegion
   * @param cdRshsReligion
   * @param cdRshsRespite
   * @param cdRshsFaHomeStatus
   * @param cdRshsFaHomeType1
   * @param cdRshsFaHomeType2
   * @param cdRshsFaHomeType3
   * @param cdRshsFaHomeType4
   * @param cdRshsFaHomeType5
   * @param cdRshsFaHomeType6
   * @param cdRshsFaHomeType7
   * @param idStage
   * @param idEvent
   * @param indRshsCareProv
   * @param indRshsInactive
   * @param indRshsTransport
   * @param indRsrcNondfcs
   * @param ndfcsCertEntity
   * @param indRshsEmergPlace
   * @param nmRshsResource
   * @param nmRshsContact
   * @param nmRshsLastUpdate
   * @param nbrRshsVid
   * @param nbrRshsPhn
   * @param nbrRshsFacilCapacity
   * @param nbrRshsFacilAcclaim
   * @param nbrRshsPhoneExtension
   * @param nbrRshsCampusNbr
   * @param nbrRshsAnnualIncome
   * @param nbrRshsFMAgeMax
   * @param nbrRshsFMAgeMin
   * @param nbrRshsMaAgeMax
   * @param nbrRshsMaAgeMin
   * @param nbrRshsIntChildren
   * @param nbrRshsIntFeAgeMax
   * @param nbrRshsIntFeAgeMin
   * @param nbrRshsIntMaAgeMax
   * @param nbrRshsIntMaAgeMin
   * @param txtRshsAddrCmnts
   * @param txtRshsComments
   * @param nbrRshsOpenSlots
   * @param indRshsWriteHist
   */
  int updateResourceHistory(int idResourceHistory, int idResource, Date dtlastUpdate, Date dtRshsEffective,
                            Date dtRshsClose, Date dtRshsCert, Date dtRshsMarriage, Date dtRshsEnd,
                            String addrRshsStLn1, String addrRshsStLn2, String addrRshsCity, String cdRshsState,
                            String addrRshsZip, String addrRshsAttn, String cdRshsCnty, String cdRshsInvolClosure,
                            String cdRshsClosureRsn, String cdRshsType, String cdRshsHub, String cdRshsCampusType,
                            String cdRshsMaintainer, String cdRshsSchDist,
                            String cdRshsOwnership, String cdRshsStatus, String cdRshsFacilType, String cdRshsCertBy,
                            String cdRshsOperBy, String cdRshsSetting, String cdRshsPayment, String cdRshsCategory,
                            String cdRshsEthnicity, String cdRshsLanguage, String cdRshsMaritalStatus,
                            String cdRshsRecmndReopen, String cdRshsRegion, String cdRshsReligion, String cdRshsRespite,
                            String cdRshsFaHomeStatus, String cdRshsFaHomeType1, String cdRshsFaHomeType2,
                            String cdRshsFaHomeType3, String cdRshsFaHomeType4, String cdRshsFaHomeType5,
                            String cdRshsFaHomeType6, int idStage, int idEvent,
                            String indRshsCareProv, String indRshsInactive, String indRshsTransport,
                            String indRsrcNondfcs, String ndfcsCertEntity, String indRshsEmergPlace,
                            String nmRshsResource, String nmRshsContact, String nmRshsLastUpdate, String nbrRshsVid,
                            String nbrRshsPhn, int nbrRshsFacilCapacity, int nbrRshsFacilAcclaim,
                            String nbrRshsPhoneExtension, int nbrRshsCampusNbr, int nbrRshsAnnualIncome,
                            int nbrRshsFMAgeMax, int nbrRshsFMAgeMin, int nbrRshsMaAgeMax, int nbrRshsMaAgeMin,
                            int nbrRshsIntFeAgeMax, int nbrRshsIntFeAgeMin,
                            int nbrRshsIntMaAgeMax, int nbrRshsIntMaAgeMin, String txtRshsAddrCmnts,
                            String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist);

  /**
   * Partial insert of ResourceHistory table using the supplied parameters(column values).
   *
   * @param idResourceHistory
   * @param idResource
   * @param dtLastUpdate
   * @param dtRshsEffective
   * @param dtRshsClose
   * @param dtRshsCert
   * @param dtRshsMarriage
   * @param dtRshsEnd
   * @param addrRshsStLn1
   * @param addrRshsStLn2
   * @param addrRshsCity
   * @param cdRshsState
   * @param addrRshsZip
   * @param addrRshsAttn
   * @param cdRshsCnty
   * @param cdRshsInvolClosure
   * @param cdRshsClosureRsn
   * @param cdRshsType
   * @param cdRshsHub
   * @param cdRshsCampusType
   * @param cdRshsSourceInquiry
   * @param cdRshsMaintainer
   * @param cdRshsSchDist
   * @param cdRshsOwnership
   * @param cdRshsStatus
   * @param cdRshsFacilType
   * @param cdRshsCertBy
   * @param cdRshsOperBy
   * @param cdRshsSetting
   * @param cdRshsPayment
   * @param cdRshsCategory
   * @param cdRshsEthnicity
   * @param cdRshsLanguage
   * @param cdRshsMaritalStatus
   * @param cdRshsRecmndReopen
   * @param cdRshsRegion
   * @param cdRshsReligion
   * @param cdRshsRespite
   * @param cdRshsFaHomeStatus
   * @param cdRshsFaHomeType1
   * @param cdRshsFaHomeType2
   * @param cdRshsFaHomeType3
   * @param cdRshsFaHomeType4
   * @param cdRshsFaHomeType5
   * @param cdRshsFaHomeType6
   * @param cdRshsFaHomeType7
   * @param idStage
   * @param idEvent
   * @param indRshsCareProv
   * @param indRshsInactive
   * @param indRshsTransport
   * @param indRsrcNondfcs
   * @param ndfcsCertEntity
   * @param indRshsEmergPlace
   * @param nmRshsResource
   * @param nmRshsContact
   * @param nmRshsLastUpdate
   * @param nbrRshsVid
   * @param nbrRshsPhn
   * @param nbrRshsFacilCapacity
   * @param nbrRshsFacilAcclaim
   * @param nbrRshsPhoneExtension
   * @param nbrRshsCampusNbr
   * @param nbrRshsAnnualIncome
   * @param nbrRshsFMAgeMax
   * @param nbrRshsFMAgeMin
   * @param nbrRshsMaAgeMax
   * @param nbrRshsMaAgeMin
   * @param nbrRshsIntChildren
   * @param nbrRshsIntFeAgeMax
   * @param nbrRshsIntFeAgeMin
   * @param nbrRshsIntMaAgeMax
   * @param nbrRshsIntMaAgeMin
   * @param txtRshsAddrCmnts
   * @param txtRshsComments
   * @param nbrRshsOpenSlots
   * @param indRshsWriteHist
   */
  int insertResourceHistory(int idResourceHistory, int idResource, Date dtLastUpdate, Date dtRshsEffective,
                            Date dtRshsClose, Date dtRshsCert, Date dtRshsMarriage, Date dtRshsEnd,
                            String addrRshsStLn1, String addrRshsStLn2, String addrRshsCity, String cdRshsState,
                            String addrRshsZip, String addrRshsAttn, String cdRshsCnty, String cdRshsInvolClosure,
                            String cdRshsClosureRsn, String cdRshsType, String cdRshsHub, String cdRshsCampusType,
                            String cdRshsSourceInquiry, String cdRshsMaintainer, String cdRshsSchDist,
                            String cdRshsOwnership, String cdRshsStatus, String cdRshsFacilType, String cdRshsCertBy,
                            String cdRshsOperBy, String cdRshsSetting, String cdRshsPayment, String cdRshsCategory,
                            String cdRshsEthnicity, String cdRshsLanguage, String cdRshsMaritalStatus,
                            String cdRshsRecmndReopen, String cdRshsRegion, String cdRshsReligion, String cdRshsRespite,
                            String cdRshsFaHomeStatus, String cdRshsFaHomeType1, String cdRshsFaHomeType2,
                            String cdRshsFaHomeType3, String cdRshsFaHomeType4, String cdRshsFaHomeType5,
                            String cdRshsFaHomeType6, String cdRshsFaHomeType7, int idStage, int idEvent,
                            String indRshsCareProv, String indRshsInactive, String indRshsTransport,
                            String indRsrcNondfcs, String ndfcsCertEntity, String indRshsEmergPlace,
                            String nmRshsResource, String nmRshsContact, String nmRshsLastUpdate, String nbrRshsVid,
                            String nbrRshsPhn, int nbrRshsFacilCapacity, int nbrRshsFacilAcclaim,
                            String nbrRshsPhoneExtension, int nbrRshsCampusNbr, int nbrRshsAnnualIncome,
                            int nbrRshsFMAgeMax, int nbrRshsFMAgeMin, int nbrRshsMaAgeMax, int nbrRshsMaAgeMin,
                            int nbrRshsIntChildren, int nbrRshsIntFeAgeMax, int nbrRshsIntFeAgeMin,
                            int nbrRshsIntMaAgeMax, int nbrRshsIntMaAgeMin, String txtRshsAddrCmnts,
                            String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory} object.
   *
   * @param resourceHistory
   */
  void deleteResourceHistory(ResourceHistory resourceHistory);

  
  /**
   * This query is used to get the last (maximum) F/A Home approved date.
   * 
   * @param idPerson
   * @param stage
   * @param faHomeStatus
   * @return
   * 
   */
  
  // STGAP0000494 - Change the name of this method to findMaxEffectiveDateByHomeStatusIdPerson
  Date findMaxEffectiveDateByHomeStatusIdPerson(int idPerson, String stage, String faHomeStatus);

  /**
   * @param idStage
   * @param pageNbr
   * @param pageSize
   * @return
   */
  PaginatedHibernateList<ResourceHistory> findResourceHistoryListByIdStage(int idStage, int pageNbr, int pageSize);

  /**
   * @param idResourceHistory
   * @return
   */
  int deleteResourceHistory(int idResourceHistory);

/**
   * This selects a row from ResourceHistory where the effective date is the most recent date and FA home status is <>
   * 'PV' or 'SP'.
   *
   * @param idEvent
   * @return
   */
  ResourceHistory findResourceHistoryMaxEffectiveByIdEvent(int idEvent);

  /**
   * This returns the resource IV-E Reimbursability status as of the current date.
   *
   * @param idResource
   * @return String - "Y" if IV-E Reimbursable, "N" otherwise.
   */
  String findResourceCurrentIveReimbursableStatus(int idResource);

  /**
   * This returns the last approval date of the one of the statuses
   * listed in the specified FA Home status list, given that home is
   * still open.
   *
   * @param idResource
   * @param cdFaHomeStatuses
   * @return java.util.Date
   */
  Date findLastApprovalDateByIdResourceByCdFaHomeStatuses(int idResource, List<String> cdFaHomeStatuses);

  /**
   * This returns the resource IV-E Reimbursability status at the specified date.
   *
   * @param idResource
   * @return String - "Y" if IV-E Reimbursable, "N" otherwise.
   */
  String findResourceIveReimbursableStatusByDate(int idResource, Date dtEffective);

}
