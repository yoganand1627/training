package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;

public class ComplexResourceHistoryDAOImpl extends BaseDAOImpl implements ComplexResourceHistoryDAO {
  private ResourceHistoryDAO resourceHistoryDAO = null;

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }

  private boolean isSameDay(Date d1, Date d2) {
    GregorianCalendar gc1 = new GregorianCalendar();
    gc1.setTime(d1);
    GregorianCalendar gc2 = new GregorianCalendar();
    gc2.setTime(d2);

    return (gc1.get(Calendar.DAY_OF_MONTH) == gc2.get(Calendar.DAY_OF_MONTH) &&
            gc1.get(Calendar.MONTH) == gc2.get(Calendar.MONTH) &&
            gc1.get(Calendar.YEAR) == gc2.get(Calendar.YEAR));
  }

  public int insertIfNoOverlap(int idResourceHistory, int idResource, Date dtLastUpdate, Date dtRshsEffective,
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
                               String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist) {

    if (dtRshsEnd == null) {
      dtRshsEnd = DateHelper.MAX_JAVA_DATE;
    }

    /*
    * Check 1. Check that it is one day that that day is covered by an existing perion.
    */

    if (isSameDay(dtRshsEnd, dtRshsEffective)) {
      Integer idResourceRshs = resourceHistoryDAO.findIdResourceByIdResourceAndDtRshsEffective(idResource,
                                                                                               dtRshsEffective);
      if (idResourceRshs != null && idResourceRshs > 0) {
        return 0;
      }
    }

    /*
    * Check 2. Check if days overlap on the right
    */

    Integer idResourceRshs = resourceHistoryDAO.findIdResourceDtRshsEndEqualDtRshsEffective(idResource,
                                                                                            dtRshsEnd,
                                                                                            dtRshsEffective);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 3. Check is new record is identical or within a record
    */
    idResourceRshs = resourceHistoryDAO.findIdResourceDtRshsEffectiveLessThanParamDtRshsEnd(idResource,
                                                                                            dtRshsEnd,
                                                                                            dtRshsEffective);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 4.
    */
    idResourceRshs = resourceHistoryDAO.findIdResourceDtRshsEndGreaterThanParamDtRshsEffective(idResource,
                                                                                               dtRshsEffective,
                                                                                               dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 5.
    *
    */
    idResourceRshs = resourceHistoryDAO.findIdResourceDtRshsEffectiveLessOrEqualParamDtRshsEffective(idResource,
                                                                                                     dtRshsEffective,
                                                                                                     dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 6.
    */
    idResourceRshs = resourceHistoryDAO.findIdResourceByIDResourceDtRshsEffectiveAndDtRshsEnd(idResource,
                                                                                              dtRshsEffective,
                                                                                              dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Insert into ResourceHistory
    */
    return resourceHistoryDAO.insertResourceHistory(idResourceHistory, idResource, dtLastUpdate, dtRshsEffective,
                                                    dtRshsClose, dtRshsCert, dtRshsMarriage, dtRshsEnd,
                                                    addrRshsStLn1, addrRshsStLn2, addrRshsCity,
                                                    cdRshsState, addrRshsZip, addrRshsAttn, cdRshsCnty,
                                                    cdRshsInvolClosure, cdRshsClosureRsn, cdRshsType,
                                                    cdRshsHub,
                                                    cdRshsCampusType, cdRshsSourceInquiry, cdRshsMaintainer,
                                                    cdRshsSchDist,
                                                    cdRshsOwnership, cdRshsStatus, cdRshsFacilType,
                                                    cdRshsCertBy,
                                                    cdRshsOperBy, cdRshsSetting, cdRshsPayment,
                                                    cdRshsCategory,
                                                    cdRshsEthnicity, cdRshsLanguage, cdRshsMaritalStatus,
                                                    cdRshsRecmndReopen,
                                                    cdRshsRegion, cdRshsReligion, cdRshsRespite,
                                                    cdRshsFaHomeStatus,
                                                    cdRshsFaHomeType1, cdRshsFaHomeType2, cdRshsFaHomeType3,
                                                    cdRshsFaHomeType4,
                                                    cdRshsFaHomeType5, cdRshsFaHomeType6, cdRshsFaHomeType7,
                                                    idStage, idEvent, indRshsCareProv, indRshsInactive,
                                                    indRshsTransport, indRshsNonPrs,
                                                    cdCertifyEntity, indRshsEmergPlace, nmRshsResource,
                                                    nmRshsContact, nmRshsLastUpdate, nbrRshsVid, nbrRshsPhn,
                                                    nbrRshsFacilCapacity, nbrRshsFacilAcclaim, nbrRshsPhoneExtension,
                                                    nbrRshsCampusNbr, nbrRshsAnnualIncome, nbrRshsFMAgeMax,
                                                    nbrRshsFMAgeMin, nbrRshsMaAgeMax, nbrRshsMaAgeMin,
                                                    nbrRshsIntChildren, nbrRshsIntFeAgeMax, nbrRshsIntFeAgeMin,
                                                    nbrRshsIntMaAgeMax, nbrRshsIntMaAgeMin, txtRshsAddrCmnts,
                                                    txtRshsComments, nbrRshsOpenSlots, indRshsWriteHist);
  }

  public int updateIfNoOverlap(int idResourceHistory, int idResource, Date dtlastUpdate,
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
                               String txtRshsComments, int nbrRshsOpenSlots, String indRshsWriteHist) {

    if (dtRshsEnd == null) {
      dtRshsEnd = DateHelper.MAX_JAVA_DATE;
    }

    /*
    * Check 1. Check that it is one day that that day is covered by an existing perion.
    */

    if (isSameDay(dtRshsEnd, dtRshsEffective)) {
      Integer idResourceRshs = resourceHistoryDAO.findIdResourceByIDResourceHistoryNotEqualParamIDResourceHistory(
              idResource,
              idResourceHistory,
              dtRshsEffective,
              dtRshsEnd);
      if (idResourceRshs != null && idResourceRshs > 0) {
        return 0;
      }
    }

    /*
    * Check 2. Check if new record overlaps other records on the right
    */
    Integer idResourceRshs =
            resourceHistoryDAO.findIdRsrcByIDRsrcHistNotEqualParamIDRsrcHistDtRshsEndEqualDtRshsEffective(idResource,
                                                                                                          idResourceHistory,
                                                                                                          dtRshsEffective,
                                                                                                          dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 3. Check if updated record is identical or within a record
    */
    idResourceRshs = resourceHistoryDAO.findIdRsrcByIDRsrcHistNotEqualParamIDRsrcHistDtRshsEffectNotEqualDtRshsEnd(
            idResource,
            idResourceHistory,
            dtRshsEffective,
            dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 4.
    */
    idResourceRshs = resourceHistoryDAO.findIdRsrcByDtRshsEffectLessOrEqualParamDtRshsEffectDtRshsEndLessParamDtRshsEnd(
            idResource,
            idResourceHistory,
            dtRshsEffective,
            dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 5.
    */
    idResourceRshs =
            resourceHistoryDAO.findIdRsrcByDtRshsEffectLessOrEqualParamDtRshsEffectDtRshsEndGreaterOrEqualParamDtRshsEnd(
                    idResource,
                    idResourceHistory,
                    dtRshsEffective,
                    dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Check 6.
    */
    idResourceRshs =
            resourceHistoryDAO.findIdRsrcByDtRshsEndLessOrEqualParamDtRshsEndDtRshsEffectGreaterOrEqualParamDtRshsEffect(
                    idResource,
                    idResourceHistory,
                    dtRshsEffective,
                    dtRshsEnd);
    if (idResourceRshs != null && idResourceRshs > 0) {
      return 0;
    }

    /*
    * Now can update the ResourceHistory record
    */
    return resourceHistoryDAO.updateResourceHistory(idResourceHistory, idResource, dtlastUpdate,
                                                    dtRshsEffective, dtRshsClose, dtRshsCert,
                                                    dtRshsMarriage, dtRshsEnd, addrRshsStLn1,
                                                    addrRshsStLn2, addrRshsCity, cdRshsState,
                                                    addrRshsZip, addrRshsAttn, cdRshsCnty,
                                                    cdRshsInvolClosure, cdRshsClosureRsn, cdRshsType,
                                                    cdRshsHub, cdRshsCampusType,
                                                    cdRshsMaintainer, cdRshsSchDist, cdRshsOwnership,
                                                    cdRshsStatus, cdRshsFacilType, cdRshsCertBy,
                                                    cdRshsOperBy, cdRshsSetting, cdRshsPayment,
                                                    cdRshsCategory, cdRshsEthnicity, cdRshsLanguage,
                                                    cdRshsMaritalStatus, cdRshsRecmndReopen, cdRshsRegion,
                                                    cdRshsReligion, cdRshsRespite, cdRshsFaHomeStatus,
                                                    cdRshsFaHomeType1,
                                                    cdRshsFaHomeType2, cdRshsFaHomeType3, cdRshsFaHomeType4,
                                                    cdRshsFaHomeType5,
                                                    cdRshsFaHomeType6, idStage, idEvent,
                                                    indRshsCareProv, indRshsInactive, indRshsTransport,
                                                    indRshsNonPrs, cdCertifyEntity, indRshsEmergPlace,
                                                    nmRshsResource, nmRshsContact, nmRshsLastUpdate, nbrRshsVid,
                                                    nbrRshsPhn, nbrRshsFacilCapacity, nbrRshsFacilAcclaim,
                                                    nbrRshsPhoneExtension,
                                                    nbrRshsCampusNbr, nbrRshsAnnualIncome, nbrRshsFMAgeMax,
                                                    nbrRshsFMAgeMin,
                                                    nbrRshsMaAgeMax, nbrRshsMaAgeMin, nbrRshsIntFeAgeMax,
                                                    nbrRshsIntFeAgeMin, nbrRshsIntMaAgeMax, nbrRshsIntMaAgeMin,
                                                    txtRshsAddrCmnts,
                                                    txtRshsComments, nbrRshsOpenSlots, indRshsWriteHist);
  }
}