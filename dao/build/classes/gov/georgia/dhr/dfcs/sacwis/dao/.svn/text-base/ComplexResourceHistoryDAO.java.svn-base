package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexResourceHistoryDAO {
  /**
   * Insert a row into ResourceHistory if dates do not overlap
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
   * @param indRshsIndivStudy
   * @param indRshsNonPrs
   * @param cdCertifyEntity
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
   * @return 0 is no row inserted, 1 if inserted
   */
  int insertIfNoOverlap(int idResourceHistory, int idResource, Date dtLastUpdate, Date dtRshsEffective,
                        Date dtRshsClose, Date dtRshsCert, Date dtRshsMarriage, Date dtRshsEnd,
                        String addrRshsStLn1, String addrRshsStLn2, String addrRshsCity,
                        String cdRshsState, String addrRshsZip, String addrRshsAttn, String cdRshsCnty,
                        String cdRshsInvolClosure, String cdRshsClosureRsn, String cdRshsType,
                        String cdRshsHub,
                        String cdRshsCampusType, String cdRshsSourceInquiry, String cdRshsMaintainer,
                        String cdRshsSchDist,
                        String cdRshsOwnership, String cdRshsStatus, String cdRshsFacilType,
                        String cdRshsCertBy,
                        String cdRshsOperBy, String cdRshsSetting, String cdRshsPayment,
                        String cdRshsCategory,
                        String cdRshsEthnicity, String cdRshsLanguage, String cdRshsMaritalStatus,
                        String cdRshsRecmndReopen,
                        String cdRshsRegion, String cdRshsReligion, String cdRshsRespite,
                        String cdRshsFaHomeStatus,
                        String cdRshsFaHomeType1, String cdRshsFaHomeType2, String cdRshsFaHomeType3,
                        String cdRshsFaHomeType4,
                        String cdRshsFaHomeType5, String cdRshsFaHomeType6, String cdRshsFaHomeType7,
                        int idStage, int idEvent, String indRshsCareProv, String indRshsInactive,
                        String indRshsTransport, String indRshsIndivStudy, String indRshsNonPrs,
                        String cdCertifyEntity, String indRshsEmergPlace, String nmRshsResource,
                        String nmRshsContact, String nmRshsLastUpdate, String nbrRshsVid, String nbrRshsPhn,
                        int nbrRshsFacilCapacity, int nbrRshsFacilAcclaim, String nbrRshsPhoneExtension,
                        int nbrRshsCampusNbr, int nbrRshsAnnualIncome, int nbrRshsFMAgeMax,
                        int nbrRshsFMAgeMin, int nbrRshsMaAgeMax, int nbrRshsMaAgeMin,
                        int nbrRshsIntChildren, int nbrRshsIntFeAgeMax, int nbrRshsIntFeAgeMin,
                        int nbrRshsIntMaAgeMax, int nbrRshsIntMaAgeMin, String txtRshsAddrCmnts,
                        String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist);

  /**
   * Updates a ResourceHistory if the updated row does not overlap another row
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
   * @param indRshsIndivStudy
   * @param indRshsNonPrs
   * @param cdCertifyEntity
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
   * @return number of rows updated (0/1)
   */
  int updateIfNoOverlap(int idResourceHistory, int idResource, Date dtlastUpdate,
                        Date dtRshsEffective, Date dtRshsClose, Date dtRshsCert,
                        Date dtRshsMarriage, Date dtRshsEnd, String addrRshsStLn1,
                        String addrRshsStLn2, String addrRshsCity, String cdRshsState,
                        String addrRshsZip, String addrRshsAttn, String cdRshsCnty,
                        String cdRshsInvolClosure, String cdRshsClosureRsn, String cdRshsType,
                        String cdRshsHub, String cdRshsCampusType, String cdRshsSourceInquiry,
                        String cdRshsMaintainer, String cdRshsSchDist, String cdRshsOwnership,
                        String cdRshsStatus, String cdRshsFacilType, String cdRshsCertBy,
                        String cdRshsOperBy, String cdRshsSetting, String cdRshsPayment,
                        String cdRshsCategory, String cdRshsEthnicity, String cdRshsLanguage,
                        String cdRshsMaritalStatus, String cdRshsRecmndReopen, String cdRshsRegion,
                        String cdRshsReligion, String cdRshsRespite, String cdRshsFaHomeStatus,
                        String cdRshsFaHomeType1,
                        String cdRshsFaHomeType2, String cdRshsFaHomeType3, String cdRshsFaHomeType4,
                        String cdRshsFaHomeType5,
                        String cdRshsFaHomeType6, String cdRshsFaHomeType7, int idStage, int idEvent,
                        String indRshsCareProv, String indRshsInactive, String indRshsTransport,
                        String indRshsIndivStudy,
                        String indRshsNonPrs, String cdCertifyEntity, String indRshsEmergPlace,
                        String nmRshsResource, String nmRshsContact, String nmRshsLastUpdate, String nbrRshsVid,
                        String nbrRshsPhn, int nbrRshsFacilCapacity, int nbrRshsFacilAcclaim,
                        String nbrRshsPhoneExtension,
                        int nbrRshsCampusNbr, int nbrRshsAnnualIncome, int nbrRshsFMAgeMax,
                        int nbrRshsFMAgeMin,
                        int nbrRshsMaAgeMax, int nbrRshsMaAgeMin, int nbrRshsIntChildren,
                        int nbrRshsIntFeAgeMax,
                        int nbrRshsIntFeAgeMin, int nbrRshsIntMaAgeMax, int nbrRshsIntMaAgeMin,
                        String txtRshsAddrCmnts,
                        String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist);
}