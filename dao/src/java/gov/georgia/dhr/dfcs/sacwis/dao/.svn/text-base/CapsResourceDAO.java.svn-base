/**
 * Created on Mar 25, 2006 at 2:14:35 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;

import java.util.Date;
import java.util.List;
import java.util.Map;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------
 **  04/10/2008  Corey Harden      STGAP00005794: created method CapsResource findCapsResourceByIdResc()
 *   03/01/2011  Hai Nguyen        SMS#97850: MR-075 Added method findCapsResourceByIdResourceHhMemberPerson(int IdPerson). 
 *   03/25/2011  Hai Nguyen        SMS#97850: MR-075 Updated methods that updates resource status and added new field for hold placements.
 *   06/10/2011  hjbaptiste       SMS#109631: CAPTA 4.3: Special Investigation - Added updateCapsResourceIndHoldPlacements() 
 *   06/09/2011  Corey Harden      SMS#109631 Added method findCapsResourceByIdStage(int idStage)                             
 *                                 
 **/

public interface CapsResourceDAO {
  /**
   * This method finds a resource attached to a FAD stage
   * 
   * @param idStage - the id of the FAD stage
   * @return - returns the Resource record associated with the FAD stage
   */
  CapsResource findCapsResourceByIdStage(int idStage);
  /**
   * Retrieves the info for Care taker window from Caps_Resource
   *
   * @param idResource
   * @return A list of maps including information about the parent and cihld resources.
   */

  List<Map> findCapsResourceByIdResource(int idResource);

  /**
   * Retrieves the info for Care taker window from Caps_Resource
   *
   * @param idRrscFacilList
   * @return A list of maps including information about the parent and child resources.
   */

  public PaginatedHibernateList<Map> findPortalCapsResourceByIdResource(List<Integer> idRrscFacilList,
          String cdSortBy, int pageNbr,int pageSize);
  
  /**
   * Retrieves the info for Care taker window from Caps_Resource
   *
   * @param idAgency
   * @return A list of maps including information about the parent and child resources.
   */

  PaginatedHibernateList<Map> findPortalCapsResourceByIdAgency(int idRrscAgency,String cdSortBy, int pageNbr,int pageSize);
  
  /**
   * Retrieves a row from CapsResource table for a given Stage ID
   *
   * @param idStage
   * @return CapsResource
   */
  CapsResource findResourceByIdRsrcFaHomeStage(int idStage);

  /**
   * Selects all Rsrc Address/VID combinations.
   *
   * @param idResource
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.CapsResource} object for the given idResource, including
   *         resourceAddress information.
   */

  /**
   * Gets Resource name, resource contarct based on the idEvent, idStage, idCase
   */
  Map findCapsResourceIDandNameByIdEventIdStageandIdCase(int idEvent, int idStage, int idCase);
  
  
  List<CapsResource> findCapsResourceAddressess(int idResource);

  /**
   * Retrieves Facility information
   *
   * @param idResource
   * @return A {@link gov.georgia.dhr.dfcs.sacwis.db.CapsResource} object for the given idResource.
   */
  CapsResource findCapsResourceByIdResourceOnly(int idResource);

  /**
   * Retrieves Rsrc info for a given idResource
   *
   * @param idResource
   * @return List<Map>
   */

  Map findRsrcCertAndNonprsByIdResource(int idResource);

  /**
   * Retrieves dtRsrcCert from CapsResource given idRsrcFaHomeStage.
   *
   * @param idRsrcFaHomeStage
   * @return
   */
  Date findDtRsrcCertByIdRsrcFaHomeStage(int idRsrcFaHomeStage);

  /**
   * Updates specific columns on the CAPS RESOURCE table.
   *
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcStatus
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param dtApprvDet
   * @param idRsrcFaHomeStage
   * @param indHoldPlacements
   * @return
   */
  int updateCapsResourceByCdRsrcFaHomeStatus(String cdRsrcFaHomeStatus, String cdRsrcStatus, int idRsrcFaHomeEvent,
                                             String indRsrcWriteHist, Date dtApprvDet, int idRsrcFaHomeStage,
                                             String indHoldPlacements);

  /**
   * Updates specific columns on the CAPS RESOURCE table.
   *
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcStatus
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param dtRsrcDate
   * @param idRsrcFaHomeStage
   * @param indHoldPlacements
   * @return
   */
  int updateCapsResourceByDtRsrcDate(String cdRsrcFaHomeStatus, String cdRsrcStatus, int idRsrcFaHomeEvent,
                                     String indRsrcWriteHist, Date dtRsrcDate, int idRsrcFaHomeStage,
                                     String indHoldPlacements);

  /**
   * Updates specific columns on the CAPS RESOURCE table.
   *
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcStatus
   * @param idRsrcFaHomeEvent
   * @param indRsrcWriteHist
   * @param dtApprvDet
   * @param idRsrcFaHomeStage
   * @param indHoldPlacements
   * @return
   */
  int updateCapsResourceByDtRsrcClose(String cdRsrcFaHomeStatus, String cdRsrcStatus, int idRsrcFaHomeEvent,
                                      String indRsrcWriteHist, Date dtApprvDet, int idRsrcFaHomeStage,
                                      String indHoldPlacement);

  /**
   * Updates NM RESOURCE on the CAPS RESOURCE table where IdStage = Id Rsrc FA Home Stage.
   *
   * @param nmResource
   * @param nmRsrcLastUpdate
   * @param idRsrcFaHomeStage
   * @return
   */
  int updateCapsResourceSetNmResource(String nmResource, String nmRsrcLastUpdate, int idRsrcFaHomeStage);

  /**
   * Partial update of CapsResource table using the supplied parameters(column values).
   *
   * @param idResource
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcStatus
   * @param lastUpdate
   */
  int updateCapsResource(int idResource, String cdRsrcFaHomeStatus, String cdRsrcStatus, Date lastUpdate);
  
  /**
   * 
   * @param idResource
   * @param cdRsrcClosureRsn
   * @param cdRsrcInvolClosure
   * @param cdRsrcRecmndReopen
   * @param szTxtStatusRsnComments
   * @param txtLegalNm
   * 
   */
  int updateCapsResource(int idResource, String cdRsrcClosureRsn,
                         String cdRsrcInvolClosure, String cdRsrcRecmndReopen, String szTxtStatusRsnComments, String txtLegalNm);
    
  /**
   * Partial update of CapsResource table using the supplied parameters(column values).
   *
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
   * @param indRsrcNonDfcs
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
   * @return
   */
  int updateCapsResource(int idResource, String addrRsrcStLn1, String addrRsrcStLn2, String addrRsrcCity,
                         String cdRsrcState, String addrRsrcZip, String addrRsrcAttn, String cdRsrcCnty,
                         String cdRsrcInvolClosure, String cdRsrcClosureRsn, String cdRsrcType, String cdRsrcCampusType,
                         String cdRsrcMaintainer, String cdRsrcSchDist, String cdRsrcOwnership, String cdRsrcFacilType,
                         String cdRsrcHub, String cdRsrcCertBy, String cdRsrcOperBy, String cdRsrcSetting,
                         String cdRsrcPayment, String cdRsrcCategory, String cdRsrcEthnicity, String cdRsrcLanguage,
                         String cdRsrcMaritalStatus, String cdRsrcRecmndReopen, String cdRsrcRegion,
                         String cdRsrcReligion, String cdRsrcRespite, String cdRsrcFaHomeStatus,
                         String cdRsrcFaHomeType1, String cdRsrcFaHomeType2, String cdRsrcFaHomeType3,
                         String cdRsrcFaHomeType4, String cdRsrcFaHomeType5, String cdRsrcFaHomeType6,
                         Date dtRsrcMarriage, Date dtRsrcClose, Date dtRsrcCert,
                         int idRsrcFaHomeStage, int idRsrcFaHomeEvent, String indRsrcWriteHist, String indRsrcCareProv,
                         String indRsrcEmergPlace, String indRsrcInactive, String indRsrcTransport,
                         String indCurrHmStdyExsts, String indRsrcNonDfcs, String ndfcsCertEntity,
                         String nmRsrcLastUpdate, String nmResource, String nmRsrcContact, String nbrRsrcPhn,
                         String nbrFacilPhoneExtension, int nbrRsrcFacilCapacity, int nbrRsrcFacilAcclaim,
                         String nbrRsrcVid, int nbrRsrcCampusNbr, String indSpecificChild, int nbrRsrcIntFeAgeMax,
                         int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMax, int nbrRsrcIntMaAgeMin,
                         int nbrRsrcAnnualIncome, int nbrRsrcFmAgeMax, int nbrRsrcFmAgeMin, int nbrRsrcMaAgeMax,
                         int nbrRsrcMaAgeMin, int nbrRsrcOpenSlots, String txtRsrcAddrCmnts, String txtRsrcComments,
                         Date lastUpdate, String indPrevFamStdyRqstd, String cdSchDist, String cdElem, String cdMiddle,
                         String cdHigh, String cdExchangeStat, String indWaiver, String nmLegal, String txtHmPrgInterest);

  /**
   * Partial insert of CapsResource table using the supplied parameters(column values). (Note that the insert is done
   * using straight SQL)
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
   * @param cdRsrcType
   * @param cdRsrcCampusType
   * @param cdRsrcMaintainer
   * @param cdRsrcSchDist
   * @param cdRsrcOwnership
   * @param cdRsrcFacilType
   * @param cdRsrcHub
   * @param cdRsrcCertBy
   * @param cdRsrcOperBy
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
   * @param indRsrcNonDfcs
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
   * @param idResource
   * @param indPrevFamStdyRqstd
   * @param cdSchDist
   * @param cdElem
   * @param cdMiddle
   * @param cdHigh
   * @param cdExchangeStat
   * @param indWaiver
   * @param txtHmPrgInterest
   * @param indHoldPlacements
   * @return
   */
  int insertCapsResource(String addrRsrcStLn1, String addrRsrcStLn2, String addrRsrcCity, String cdRsrcState,
                         String addrRsrcZip, String addrRsrcAttn, String cdRsrcCnty, String cdRsrcInvolClosure,
                         String cdRsrcClosureRsn, String cdRsrcType, String cdRsrcCampusType, String cdRsrcMaintainer,
                         String cdRsrcSchDist, String cdRsrcOwnership, String cdRsrcFacilType, String cdRsrcHub,
                         String cdRsrcCertBy, String cdRsrcOperBy, String cdRsrcPayment, String cdRsrcCategory,
                         String cdRsrcEthnicity, String cdRsrcLanguage, String cdRsrcMaritalStatus,
                         String cdRsrcRecmndReopen, String cdRsrcRegion, String cdRsrcReligion, String cdRsrcRespite,
                         String cdRsrcFaHomeStatus, String cdRsrcFaHomeType1, String cdRsrcFaHomeType2,
                         String cdRsrcFaHomeType3, String cdRsrcFaHomeType4, String cdRsrcFaHomeType5,
                         String cdRsrcFaHomeType6, Date dtRsrcMarriage, Date dtRsrcClose,
                         Date dtRsrcCert, int idRsrcFaHomeStage, int idRsrcFaHomeEvent, String indRsrcWriteHist,
                         String indRsrcCareProv, String indRsrcEmergPlace, String indRsrcInactive,
                         String indRsrcTransport, String indCurrHmStdyExsts, String indRsrcNonDfcs,
                         String ndfcsCertEntity, String nmRsrcLastUpdate, String nmResource, String nmRsrcContact,
                         String nbrRsrcPhn, String nbrFacilPhoneExtension, int nbrRsrcFacilCapacity,
                         int nbrRsrcFacilAcclaim, String nbrRsrcVid, int nbrRsrcCampusNbr, String indSpecificChild,
                         int nbrRsrcIntFeAgeMax, int nbrRsrcIntFeAgeMin, int nbrRsrcIntMaAgeMax, int nbrRsrcIntMaAgeMin,
                         int nbrRsrcAnnualIncome, int nbrRsrcFMAgeMax, int nbrRsrcFMAgeMin, int nbrRsrcMlAgeMax,
                         int nbrRsrcMlAgeMin, int nbrRsrcOpenSlots, String txtRsrcAddrCmnts, String txtRsrcComments,
                         int idResource, String indPrevFamStdyRqstd, String cdSchDist, String cdElem, String cdMiddle,
                         String cdHigh, String cdExchangeStat, String indWaiver, String nmLegal, String txtHmPrgInterest,
                         String indHoldPlacements);

  /**
   * Update CapsResource
   *
   * @param nmResource
   * @param nmRsrcContact
   * @param cdRsrcFacilType
   * @param nbrRsrcFacilAcclaim
   * @param cdRsrcType
   * @param cdRsrcCampusType
   * @param nbrSchCampusNbr
   * @param cdMhmrCompCode
   * @param cdRsrcCertBy
   * @param cdRsrcOperBy
   * @param cdRsrcSetting
   * @param cdRsrcPayment
   * @param nbrRsrcFacilCapacity
   * @param cdRsrcMaintainer
   * @param cdRsrcOwnership
   * @param cdRsrcStatus
   * @param nmRsrcLastUpdate
   * @param indRsrcTransport
   * @param txtRsrcComments
   * @param cdRsrcHub
   * @param nmLegal
   * @param idResource
   * @param tsLastUpdate
   * @param nmRsrcContactTitle
   * @param nbrRsrcNtnlProvider
   * @param cdAddrRsrcEmail
   * @param cdAddrRsrcWebsite
   * @param cdSchoolType
   * @param cdPaymentDelivery
   * @param cdSchoolDistrict
   * @return
   */
  int updateCapsResource(String nmResource, String nmRsrcContact, String cdRsrcFacilType, int nbrRsrcFacilAcclaim,
                         String cdRsrcType, String cdRsrcCampusType, int nbrSchCampusNbr, String cdMhmrCompCode,
                         String cdRsrcCertBy, String cdRsrcOperBy, String cdRsrcSetting, String cdRsrcPayment,
                         int nbrRsrcFacilCapacity, String cdRsrcMaintainer, String cdRsrcOwnership, String cdRsrcStatus,
                         String nmRsrcLastUpdate, String indRsrcTransport, String txtRsrcComments, String cdRsrcHub,
                         String nmLegal, int idResource, Date tsLastUpdate, String nmRsrcContactTitle,
                         String nbrRsrcNtnlProvider, String cdAddrRsrcEmail, String cdAddrRsrcWebsite,
                         String cdSchoolType, String cdPaymentDelivery, String cdSchoolDistrict);

  /**
   * Insert Caps Resource
   *
   * @param idResource
   * @param nmResource
   * @param nmRsrcContact
   * @param cdRsrcFacilType
   * @param nbrRsrcFacilAcclaim
   * @param cdRsrcType
   * @param cdRsrcCampusType
   * @param nbrSchCampusNbr
   * @param cdMhmrCompCode
   * @param cdRsrcCertBy
   * @param cdRsrcOperBy
   * @param cdRsrcSetting
   * @param cdRsrcPayment
   * @param nbrRsrcFacilCapacity
   * @param cdRsrcMaintainer
   * @param cdRsrcOwnership
   * @param cdRsrcStatus
   * @param indRsrcTransport
   * @param txtRsrcComments
   * @param cdRsrcHub
   * @param nmLegal
   * @param nmRsrcLastUpdate
   * @param nmRsrcContactTitle
   * @param nbrRsrcNtnlProvider
   * @param cdAddrRsrcEmail
   * @param cdAddrRsrcWebsite
   * @param cdSchoolType
   * @param cdPaymentDelivery
   * @param cdSchoolDistrict
   * @return
   */
  int insertCapsResource(int idResource, String nmResource, String nmRsrcContact, String cdRsrcFacilType,
                         int nbrRsrcFacilAcclaim, String cdRsrcType, String cdRsrcCampusType, int nbrSchCampusNbr,
                         String cdMhmrCompCode, String cdRsrcCertBy, String cdRsrcOperBy, String cdRsrcSetting,
                         String cdRsrcPayment, int nbrRsrcFacilCapacity, String cdRsrcMaintainer,
                         String cdRsrcOwnership, String cdRsrcStatus, String indRsrcTransport, String txtRsrcComments,
                         String cdRsrcHub, String nmLegal, String nmRsrcLastUpdate, String nmRsrcContactTitle,
                         String nbrRsrcNtnlProvider, String cdAddrRsrcEmail, String cdAddrRsrcWebsite,
                         String cdSchoolType, String cdPaymentDelivery, String cdSchoolDistrict);

  /**
   * Update Caps Resource
   *
   * @param cdRsrcCertBy
   * @param cdRsrcOperBy
   * @param cdRsrcSetting
   * @param cdRsrcPayment
   * @param dtRsrcCert
   * @param dtRsrcClose
   * @param nbrRsrcFacilCapacity
   * @param nmRsrcLastUpdate
   * @param idResource
   * @param tsLastUpdate
   * @return
   */
  int updateCapsResource(String cdRsrcCertBy, String txtSpecCert, String cdRsrcOperBy, String cdRsrcSetting,
                         String cdRsrcPayment, Date dtRsrcCert, Date dtRsrcClose, int nbrRsrcFacilCapacity, String indAfterHours,
                         String nmRsrcLastUpdate, int idResource, Date tsLastUpdate);

  /**
   * Partial update of CapsResource
   *
   * @param nbrRsrcOpenSlots
   * @param idResource
   * @return
   */
  int updateCapsResource(int nbrRsrcOpenSlots, int idResource);
  
  /**
   * Updates the CapsResource record to indicate whether to hold placements
   * 
   * @param idResource
   * @param indHoldPlacements
   * @return
   */
  int updateCapsResourceIndHoldPlacements(int idResource, String indHoldPlacements);

  /**
   * Partial update of CapsResource table using the supplied parameters(column values).
   *
   * @param idResource
   * @param cdRsrcFaHomeStatus
   * @param cdRsrcClosureRsn
   * @param cdRsrcInvolClosure
   * @param cdRsrcRecmndReopen
   * @param szTxtStatusRsnComments
   * @param idRsrcFaHomeEvent
   * @param ndRsrcWriteHist
   * @param dtRsrcCert
   * @param dtRsrcClose
   * @param lastUpdate
   * @param indHoldPlacements
   * @return
   */
  int updateCapsResource(int idResource, String cdRsrcFaHomeStatus, String cdRsrcClosureRsn, String cdRsrcInvolClosure,
                         String cdRsrcRecmndReopen, String szTxtStatusRsnComments,
                         int idRsrcFaHomeEvent, String ndRsrcWriteHist, Date dtRsrcCert, Date dtRsrcClose,
                         Date lastUpdate, String indHoldPlacements);
  /**
   * 
   * @param indRsrcContracted
   * @param dtLastUpdate
   * @param idResource
   * @return
   */
  int updateResourceByIndContractedDtLastUpdate(String indRsrcContracted, Date dtLastUpdate, int idResource);

  /**
   * Save a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsResource} object.
   *
   * @param capsResource
   */
  void saveOrUpdateCapsResource(CapsResource capsResource);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CapsResource} object.
   *
   * @param capsResource
   */
  void deleteCapsResource(CapsResource capsResource);

  /**
   * Partial update of CapsResource table using the supplied parameters(column values).
   *
   * @param idResource
   * @param cdRsrcMaritalStatus
   */
  int updateCapsResource(String cdRsrcMaritalStatus, int idResource);

  /**
   * find CapsResource by idResource.
   *
   * @param idResource
   */
  CapsResource findCapsResourceByIdResc(int idResource);
  
  /**
   * find CapsResource Name by idResource.(Used for AdoptionInformation Page)
   *
   * @param idAgencyResource
   */
  
  String findNmByIdResourceOnly(int idAgencyResource);
  
  /**
   * find CapsResource by idCase.
   *
   * @param idCase
   * @return CapsResource
   */
  CapsResource findCapsResourceByIdCase(int idCase);
  
  /**
   * Gets the stage Id for the given resource
   * @param idResource
   * @return
   */
  Integer findIdFadStageByIdResource(int idResource);
  
  /**
   * Check to see if a resource exists with a given name
   * @param strNameResource
   * @return
   */
  Integer findIdResourceByNmResource(String strNameResource);

  /**
   * Retrieve CapsResource where idPerson is one of the resource household member
   * in the open FAD stage.
   * @param idPerson
   * @return CapsResource
   */
  CapsResource findCapsResourceByIdResourceHhMemberPerson(int idPerson);
}
