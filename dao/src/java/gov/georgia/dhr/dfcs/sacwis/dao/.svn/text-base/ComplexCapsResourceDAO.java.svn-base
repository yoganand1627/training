/**
 * Created on Mar 23, 2006 at 4:16:17 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComplexCapsResourceDAO {
  /**
   * Provides methods that add/update/delete rows from the CapsResource table.
   * 
   * @param idResource
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcClosureRsn
   * @param cdRsrcInvolClosure
   * @param cdRsrcRecmndReopen
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param dtRsrcClose
   * @param lastUpdate
   * @param idRsrcFaHomeStage
   * @param indHoldPlacements
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateCapsResource(int idResource, String cdRsrcFaHomeStatus, String cdRsrcClosureRsn, String cdRsrcInvolClosure,
                         String cdRsrcRecmndReopen, String szTxtStatusRsnComments,
                         int idRsrcFaHomeEvent, String indRsrcWriteHist, Date dtRsrcClose, Date lastUpdate,
                         int idRsrcFaHomeStage, String indHoldPlacements);

  /**
   * Update the CAPS RESOURCE table
   * 
   * @param nmRsrcResource
   * @param sysIndRsrcPrsChg
   * @param cdRsrcEthnicity
   * @param cdRsrcLanguage
   * @param cdRsrcMaritalStatus
   * @param cdRsrcReligion
   * @param cdRsrcRespite
   * @param cdRsrcSourceInquiry
   * @param cdRsrcFacilType
   * @param dtRsrcMarriage
   * @param idEvent
   * @param indRsrcCareProv
   * @param indRsrcEmergPlace
   * @param indRsrcIndivStudy
   * @param indRsrcNonPrs
   * @param ndfcsCertEntity
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcMaintainer
   * @param cdRsrcRegion
   * @param indRsrcTransport
   * @param indRsrcWriteHist
   * @param nbrRsrcAnnualIncome
   * @param indSpecificChild
   * @param nbrRsrcFmAgeMin
   * @param nbrRsrcFmAgeMax
   * @param nbrRsrcIntFeAgeMax
   * @param nbrRsrcIntFeAgeMin
   * @param nbrRsrcIntMaAgeMin
   * @param nbrRsrcIntMaAgeMax
   * @param nbrRsrcMlAgeMin
   * @param nbrRsrcMlAgeMax
   * @param txtRsrcComments
   * @param dtRsrcCert
   * @param idResource
   * @param lastUpdate
   * @param cdPrevHomeStudy
   * @param cdSchoolDistrict
   * @param cdElementary
   * @param cdMiddle
   * @param cdHigh
   * @param cdAdExchangeStat
   * @param indWaiverExists
   * @param txtHmPrgInterest
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateCapsResource(String nmRsrcResource, boolean sysIndRsrcPrsChg, String cdRsrcEthnicity, String cdRsrcLanguage,
                         String cdRsrcMaritalStatus, String cdRsrcReligion, String cdRsrcRespite,
                         String cdRsrcFacilType, Date dtRsrcMarriage, int idEvent, String indRsrcCareProv,
                         String indRsrcEmergPlace, String indRsrcIndivStudy, String indRsrcNonPrs,
                         String ndfcsCertEntity, String cdRsrcFaHomeStatus, String cdRsrcMaintainer,
                         String cdRsrcRegion, String indRsrcTransport, String indRsrcWriteHist,
                         int nbrRsrcAnnualIncome, String indSpecificChild, int nbrRsrcFmAgeMin, int nbrRsrcFmAgeMax,
                         int nbrRsrcIntFeAgeMax, int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMin,
                         int nbrRsrcIntMaAgeMax, int nbrRsrcMlAgeMin, int nbrRsrcMlAgeMax, String txtRsrcComments,
                         Date dtRsrcCert, int idResource, Date lastUpdate, String cdPrevHomeStudy,
                         String cdSchoolDistrict, String cdElementary, String cdMiddle, String cdHigh,
                         String cdAdExchangeStat, String indWaiverExists, String nmLegal, String txtHmPrgInterest);

  /**
   * Updates CAPS_RESOURCE with license information.
   * 
   * @param cdRsrcCategory
   * @param cdRsrcFaHomeStatus
   * @param indRsrcWriteHist
   * @param nbrRsrcMaAgeMin
   * @param nbrRsrcMaAgeMax
   * @param nbrRsrcFmAgeMin
   * @param nbrRsrcFmAgeMax
   * @param nbrRsrcFacilCapacity
   * @param nbrRsrcOpenSlots
   * @param cdRsrcFaHomeType1
   * @param cdRsrcFaHomeType2
   * @param cdRsrcFaHomeType3
   * @param cdRsrcFaHomeType4
   * @param cdRsrcFaHomeType5
   * @param cdRsrcFaHomeType6
   * @param cdRsrcFaHomeType7
   * @param idEvent
   * @param nmRsrcLastUpdate
   * @param cdRsrcRegion
   * @param cdRsrcInvolClosure
   * @param cdRsrcClosureRsn
   * @param cdRsrcRecmndReopen
   * @param idResource
   * @param dtLastUpdate
   * @param approvalBeginDate
   * @param approvalEndDate
   * @param szTxtStatusRsnComments
   * @param indHoldPlacements
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateCapsResource(String cdRsrcCategory, String cdRsrcFaHomeStatus, String indRsrcWriteHist,
                         int nbrRsrcMaAgeMin, int nbrRsrcMaAgeMax, int nbrRsrcFmAgeMin, int nbrRsrcFmAgeMax,
                         int nbrRsrcFacilCapacity, Integer nbrRsrcOpenSlots, String cdRsrcFaHomeType1,
                         String cdRsrcFaHomeType2, String cdRsrcFaHomeType3, String cdRsrcFaHomeType4,
                         String cdRsrcFaHomeType5, String cdRsrcFaHomeType6, String cdRsrcFaHomeType7, int idEvent,
                         String nmRsrcLastUpdate, String cdRsrcRegion,
                         String cdRsrcInvolClosure, String cdRsrcClosureRsn, String cdRsrcRecmndReopen, int idResource,
                         Date dtLastUpdate, Date approvalBeginDate, Date approvalEndDate,
                         String szTxtStatusRsnComments, Date fosterParentManualDate, Date fosterParentBillDate,
                         String indHoldPlacements);

  /**
   * Update the CAPS RESOURCE table
   * 
   * @param idRsrcFaHomeStage
   * @param idApproval
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcStatus
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param indHoldPlacements
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateCapsResource(int idRsrcFaHomeStage, int idApproval, String cdRsrcFaHomeStatus, String cdRsrcStatus,
                         int idRsrcFaHomeEvent, String indRsrcWriteHist, String indHoldPlacements);

  /**
   * Inserts a new row in the CAPS_RESOURCE table. DT_RSRC_CERT should be populated with the current time for non-PRS
   * homes when they are opened
   * 
   * @param addrRsrcStLn1
   * @param addrRsrcStLn2
   * @param addrRsrcCity
   * @param cdRsrcState
   * @param addrRsrcZip
   * @param addrRsrcAttn
   * @param cdRsrcCnty
   * @param cdRsrcInvolClosure
   * @param cdRsrcClosureRsn
   * @param cdRsrcSourceInquiry
   * @param cdRsrcType
   * @param cdRsrcCampusType
   * @param cdRsrcMaintainer
   * @param cdRsrcSchDist
   * @param cdRsrcOwnership
   * @param cdRsrcFacilType
   * @param cdRsrcHub
   * @param cdRsrcCertBy
   * @param cdRsrcOperBy
   * @param cdRsrcSetting
   * @param cdRsrcPayment
   * @param cdRsrcCategory
   * @param cdRsrcEthnicity
   * @param cdRsrcLanguage
   * @param cdRsrcMaritalStatus
   * @param cdRsrcRecmndReopen
   * @param cdRsrcRegion
   * @param cdRsrcReligion
   * @param cdRsrcRespite
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcFaHomeType1
   * @param cdRsrcFaHomeType2
   * @param cdRsrcFaHomeType3
   * @param cdRsrcFaHomeType4
   * @param cdRsrcFaHomeType5
   * @param cdRsrcFaHomeType6
   * @param cdRsrcFaHomeType7
   * @param dtRsrcMarriage
   * @param dtRsrcClose
   * @param dtRsrcCert
   * @param idRsrcFaHomeStage
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param indRsrcCareProv
   * @param indRsrcEmergPlace
   * @param indRsrcInactive
   * @param indRsrcTransport
   * @param indCurrHmStdyExsts
   * @param indRsrcNonPrs
   * @param ndfcsCertEntity
   * @param nmRsrcLastUpdate
   * @param nmResource
   * @param nmRsrcContact
   * @param nbrRsrcPhn
   * @param nbrFacilPhoneExtension
   * @param nbrRsrcFacilCapacity
   * @param nbrRsrcFacilAcclaim
   * @param nbrRsrcVid
   * @param nbrRsrcCampusNbr
   * @param indSpecificChild
   * @param nbrRsrcIntFeAgeMax
   * @param nbrRsrcIntFeAgeMin
   * @param nbrRsrcIntMaAgeMax
   * @param nbrRsrcIntMaAgeMin
   * @param nbrRsrcAnnualIncome
   * @param nbrRsrcFMAgeMax
   * @param nbrRsrcFMAgeMin
   * @param nbrRsrcMlAgeMax
   * @param nbrRsrcMlAgeMin
   * @param nbrRsrcOpenSlots
   * @param txtRsrcAddrCmnts
   * @param txtRsrcComments
   * @param cdPrevHomeStudy
   * @param cdSchoolDistrict
   * @param cdElementary
   * @param cdMiddle
   * @param cdHigh
   * @param cdAdExchangeStat
   * @param indWaiverExists
   * @param txtHmPrgInterest
   * @param indHoldPlacements
   * @return int
   */
  public int insertCapsResourceForPrsAndNonPrsHome(String addrRsrcStLn1, String addrRsrcStLn2, String addrRsrcCity,
                                                   String cdRsrcState, String addrRsrcZip, String addrRsrcAttn,
                                                   String cdRsrcCnty, String cdRsrcInvolClosure,
                                                   String cdRsrcClosureRsn, String cdRsrcType, String cdRsrcCampusType,
                                                   String cdRsrcMaintainer, String cdRsrcSchDist,
                                                   String cdRsrcOwnership, String cdRsrcFacilType, String cdRsrcHub,
                                                   String cdRsrcCertBy, String cdRsrcOperBy,
                                                   String cdRsrcPayment, String cdRsrcCategory, String cdRsrcEthnicity,
                                                   String cdRsrcLanguage, String cdRsrcMaritalStatus,
                                                   String cdRsrcRecmndReopen, String cdRsrcRegion,
                                                   String cdRsrcReligion, String cdRsrcRespite,
                                                   String cdRsrcFaHomeStatus, String cdRsrcFaHomeType1,
                                                   String cdRsrcFaHomeType2, String cdRsrcFaHomeType3,
                                                   String cdRsrcFaHomeType4, String cdRsrcFaHomeType5,
                                                   String cdRsrcFaHomeType6, String cdRsrcFaHomeType7,
                                                   Date dtRsrcMarriage, Date dtRsrcClose,
                                                   Date dtRsrcCert, int idRsrcFaHomeStage, int idRsrcFaHomeEvent,
                                                   String indRsrcWriteHist, String indRsrcCareProv,
                                                   String indRsrcEmergPlace, String indRsrcInactive,
                                                   String indRsrcTransport, String indCurrHmStdyExsts,
                                                   String indRsrcNonPrs, String ndfcsCertEntity,
                                                   String nmRsrcLastUpdate, String nmResource, String nmRsrcContact,
                                                   String nbrRsrcPhn, String nbrFacilPhoneExtension,
                                                   int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim,
                                                   String nbrRsrcVid, int nbrRsrcCampusNbr, String indSpecificChild,
                                                   int nbrRsrcIntFeAgeMax, int nbrRsrcIntFeAgeMin,
                                                   int nbrRsrcIntMaAgeMax, int nbrRsrcIntMaAgeMin,
                                                   int nbrRsrcAnnualIncome, int nbrRsrcFMAgeMax, int nbrRsrcFMAgeMin,
                                                   int nbrRsrcMlAgeMax, int nbrRsrcMlAgeMin, int nbrRsrcOpenSlots,
                                                   String txtRsrcAddrCmnts, String txtRsrcComments,
                                                   String indPrevFamStdyRqstd, String cdSchDist, String cdElem,
                                                   String cdMiddle, String cdHigh, String cdExchangeStat,
                                                   String indWaiver, String nmLegal, String txtHmPrgInterest,
                                                   String indHoldPlacements);

  /**
   * Updates a row in the CAPS_RESOURCE table. DT_RSRC_CERT should be populated for non-PRS homes when they are opened
   * or <p/> DT_RSRC_CERT should be cleared out when home is changed from nonPRS to PRS
   * 
   * @param sysIndRsrcPrsChg
   * @param idResource
   * @param addrRsrcStLn1
   * @param addrRsrcStLn2
   * @param addrRsrcCity
   * @param cdRsrcState
   * @param addrRsrcZip
   * @param addrRsrcAttn
   * @param cdRsrcCnty
   * @param cdRsrcInvolClosure
   * @param cdRsrcClosureRsn
   * @param cdRsrcSourceInquiry
   * @param cdRsrcType
   * @param cdRsrcCampusType
   * @param cdRsrcMaintainer
   * @param cdRsrcSchDist
   * @param cdRsrcOwnership
   * @param cdRsrcFacilType
   * @param cdRsrcHub
   * @param cdRsrcCertBy
   * @param cdRsrcOperBy
   * @param cdRsrcSetting
   * @param cdRsrcPayment
   * @param cdRsrcCategory
   * @param cdRsrcEthnicity
   * @param cdRsrcLanguage
   * @param cdRsrcMaritalStatus
   * @param cdRsrcRecmndReopen
   * @param cdRsrcRegion
   * @param cdRsrcReligion
   * @param cdRsrcRespite
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcFaHomeType1
   * @param cdRsrcFaHomeType2
   * @param cdRsrcFaHomeType3
   * @param cdRsrcFaHomeType4
   * @param cdRsrcFaHomeType5
   * @param cdRsrcFaHomeType6
   * @param cdRsrcFaHomeType7
   * @param dtRsrcMarriage
   * @param dtRsrcClose
   * @param dtRsrcCert
   * @param idRsrcFaHomeStage
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param indRsrcCareProv
   * @param indRsrcEmergPlace
   * @param indRsrcInactive
   * @param indRsrcTransport
   * @param indCurrHmStdyExsts
   * @param indRsrcNonPrs
   * @param ndfcsCertEntity
   * @param nmRsrcLastUpdate
   * @param nmResource
   * @param nmRsrcContact
   * @param nbrRsrcPhn
   * @param nbrFacilPhoneExtension
   * @param nbrRsrcFacilCapacity
   * @param nbrRsrcFacilAcclaim
   * @param nbrRsrcVid
   * @param nbrRsrcCampusNbr
   * @param indSpecificChild
   * @param nbrRsrcIntFeAgeMax
   * @param nbrRsrcIntFeAgeMin
   * @param nbrRsrcIntMaAgeMax
   * @param nbrRsrcIntMaAgeMin
   * @param nbrRsrcAnnualIncome
   * @param nbrRsrcFmAgeMax
   * @param nbrRsrcFmAgeMin
   * @param nbrRsrcMaAgeMax
   * @param nbrRsrcMaAgeMin
   * @param nbrRsrcOpenSlots
   * @param txtRsrcAddrCmnts
   * @param txtRsrcComments
   * @param lastUpdate
   * @param indPrevFamStdyRqstd
   * @param cdSchDist
   * @param cdElem
   * @param cdMiddle
   * @param cdHigh
   * @param cdExchangeStat
   * @param indWaiver
   * @param txtHmPrgInterest
   * @return The number of rows updated.
   */
  public int updateCapsResourceForPrsAndNonPrsHome(boolean sysIndRsrcPrsChg, int idResource, String addrRsrcStLn1,
                                                   String addrRsrcStLn2, String addrRsrcCity, String cdRsrcState,
                                                   String addrRsrcZip, String addrRsrcAttn, String cdRsrcCnty,
                                                   String cdRsrcInvolClosure, String cdRsrcClosureRsn,
                                                   String cdRsrcType, String cdRsrcCampusType, String cdRsrcMaintainer,
                                                   String cdRsrcSchDist, String cdRsrcOwnership,
                                                   String cdRsrcFacilType, String cdRsrcHub, String cdRsrcCertBy,
                                                   String cdRsrcOperBy, String cdRsrcSetting, String cdRsrcPayment,
                                                   String cdRsrcCategory, String cdRsrcEthnicity,
                                                   String cdRsrcLanguage, String cdRsrcMaritalStatus,
                                                   String cdRsrcRecmndReopen, String cdRsrcRegion,
                                                   String cdRsrcReligion, String cdRsrcRespite,
                                                   String cdRsrcFaHomeStatus, String cdRsrcFaHomeType1,
                                                   String cdRsrcFaHomeType2, String cdRsrcFaHomeType3,
                                                   String cdRsrcFaHomeType4, String cdRsrcFaHomeType5,
                                                   String cdRsrcFaHomeType6, String cdRsrcFaHomeType7,
                                                   Date dtRsrcMarriage, Date dtRsrcClose,
                                                   Date dtRsrcCert, int idRsrcFaHomeStage, int idRsrcFaHomeEvent,
                                                   String indRsrcWriteHist, String indRsrcCareProv,
                                                   String indRsrcEmergPlace, String indRsrcInactive,
                                                   String indRsrcTransport, String indCurrHmStdyExsts,
                                                   String indRsrcNonPrs, String ndfcsCertEntity,
                                                   String nmRsrcLastUpdate, String nmResource, String nmRsrcContact,
                                                   String nbrRsrcPhn, String nbrFacilPhoneExtension,
                                                   int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim,
                                                   String nbrRsrcVid, int nbrRsrcCampusNbr, String indSpecificChild,
                                                   int nbrRsrcIntFeAgeMax, int nbrRsrcIntFeAgeMin,
                                                   int nbrRsrcIntMaAgeMax, int nbrRsrcIntMaAgeMin,
                                                   int nbrRsrcAnnualIncome, int nbrRsrcFmAgeMax, int nbrRsrcFmAgeMin,
                                                   int nbrRsrcMaAgeMax, int nbrRsrcMaAgeMin, int nbrRsrcOpenSlots,
                                                   String txtRsrcAddrCmnts, String txtRsrcComments, Date lastUpdate,
                                                   String indPrevFamStdyRqstd, String cdSchDist, String cdElem,
                                                   String cdMiddle, String cdHigh, String cdExchangeStat,
                                                   String indWaiver, String nmLegal, String txtHmPrgInterest);

  /**
   * Description: Retrieve all counties in which a resource can provide a service, which may also be contracted within
   * the effective dates passed into the DAM <p/>
   * <h3>EXAMPLE:</h3>
   * Table RESOURCE_SERVICE has 5 county records: C1..C5 <p/> Table CONTRACT_COUNTY has 5 records for C1..C3, no C4 nor
   * C5 <p/> Suppose (R1,S1,...) is passed in, with dates are such that only the first record of C1 matches and the 2nd
   * record of C3 match. <p/> Output will be: C1, C3, C4, C5 <p/> Reason:<br/> 1 record of C1 match ==> return C1<br/>
   * No record of C2 match ==> do not return C2<br/> 1 record of C3 match ==> return C3<br/> C4 and C5 have NO records
   * in table CONTRACT_COUNTY, then return all such records
   * 
   * <pre>
   *  Resource_Service           Contract_County
   *  R1,S1,C1    ----------+--- 1,R1,S1,C1:  date1 match        RETURN
   *                        +--- 2,R1,S1,C1:  date2 NOT match
   *  R1,S1,C2    ----------+--- 3,R1,S1,C2:  date1 NOT match    NOT RETURN
   *                        +--- 4,R1,S1,C2:  date2 NOT match      --&quot;--
   *                        +--- 5,R1,S1,C2:  date3 NOT match      --&quot;--
   *  R1,S1,C3    ----------+--- 6,R1,S1,C3:  date1 NOT match
   *                        +--- 7,R1,S1,C3:  date2 match        RETURN
   *                        +--- 8,R1,S1,C3:  date3 NOT match
   *  R1,S1,C4    -------------- no record                       RETURN
   *  R1,S1,C5    -------------- no record                       RETURN
   * </pre>
   * 
   * (NOTE that the input criteria includes (PERIOD,VERSION,LINE_ITEM), which forces only 1 record of a county in table
   * CONTRACT_COUNTY to match. For example: in C3: there are 3 records (#6,7,8). The dates passed in might intersect all
   * 3 records, but combination (PERIOD,VERSION,LINE_ITEM) is unique; thus only 1 record will match. This allows us NOT
   * to use DISTINCT clause.) <p/> ALGORITHM: The solution requires 2 SELECT statements UNIONed together<br/> 1st
   * SELECT: Return all records that match (C1 and C3)<br/> 2nd SELECT: records from RESOURCE_SERVICE but not in
   * CONTRACT_COUNTY through the use of (+) and NULL
   */
  @SuppressWarnings( { "unchecked" })
  List<Map> findCountyResource(int idContract, String cdRsrcSvcService, int nbrCncntyPeriod, int nbrCncntyVersion,
                               int nbrCncntyLineItem, int idResource, Date dtCncntyEffective, Date dtCncntyEnd);
  /**
   * Set Ind_rsrc_contracted to Y or N depending on whether rerource is being contracted (having active contract)
   * @param idContract
   * @return
   */
  int updateResourceIndRsrcContracted(int idContract);
}
