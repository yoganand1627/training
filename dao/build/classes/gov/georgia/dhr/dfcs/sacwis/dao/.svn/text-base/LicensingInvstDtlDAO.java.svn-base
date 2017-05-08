/**
 * Created on Mar 25, 2006 at 3:05:48 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.LicensingInvstDtl;

public interface LicensingInvstDtlDAO {
  /**
   * Retrieves a full record from the LICENSING_INVST_DTL table.
   *
   * @param idStage
   * @return
   */
  LicensingInvstDtl findLicensingInvstDtlByIdStageOnly(int idStage);

  /**
   * This is designed to retrieve NmResource from LICENSING_INVST_DTL for CCL and RCL cases.
   *
   * @param idStage
   * @return
   */
  String findLicensingInvstDtlByIdStage(int idStage);

  /**
   * Inserts new LicensingInvstDtl row. Note that idCase is query.set by the insert trigger
   *
   * @param idEvent
   * @param idStage
   * @param cdLicngInvstOvrallDisp
   * @param dtLicngInvstIntake
   * @param dtLicngInvstDtlBegun
   * @param dtLicngInvstComplt
   * @param dtLicngInvstAssigned
   * @param cdTxtLicngInvstNoncomp
   * @param cdLicngInvstCoractn
   * @param idResource
   * @param cdNmResource
   * @param iNbrAcclaim
   * @param cdFacilType
   * @param cdTxtComments
   * @param cdNbrPhone
   * @param cdNbrPhoneExt
   * @param cdAddrAttn
   * @param cdAddrStLn1
   * @param cdAddrStLn2
   * @param cdAddrCity
   * @param cdAddrCounty
   * @param cdAddrState
   * @param cdAddrZip
   * @param idAffilResource
   * @param cdNmAffilResource
   * @param cdTxtAffilComments
   * @param cdNbrAffilPhone
   * @param cdNbrAffilPhoneExt
   * @param cdAddrAffilAttn
   * @param cdAddrAffilStLn1
   * @param cdAddrAffilStLn2
   * @param cdAddrAffilCity
   * @param cdAddrAffilCounty
   * @param cdAddrAffilState
   * @param cdAddrAffilZip
   * @param idClassFclty
   * @param idClassAffilFclty
   * @param iNbrAffilAcclaim
   * @param iNbrAgency
   * @param iNbrBranch
   * @param iNbrAffilAgency
   * @param iNbrAffilBranch
   * @param cdAffilFacilType
   * @return
   */
  int insertLicensingInvstDtl(int idEvent,
                              int idStage,
                              String cdLicngInvstOvrallDisp,
                              Date dtLicngInvstIntake,
                              Date dtLicngInvstDtlBegun,
                              Date dtLicngInvstComplt,
                              Date dtLicngInvstAssigned,
                              String cdTxtLicngInvstNoncomp,
                              String cdLicngInvstCoractn,
                              int idResource,
                              String cdNmResource,
                              int iNbrAcclaim,
                              String cdFacilType,
                              String cdTxtComments,
                              String cdNbrPhone,
                              String cdNbrPhoneExt,
                              String cdAddrAttn,
                              String cdAddrStLn1,
                              String cdAddrStLn2,
                              String cdAddrCity,
                              String cdAddrCounty,
                              String cdAddrState,
                              String cdAddrZip,
                              int idAffilResource,
                              String cdNmAffilResource,
                              String cdTxtAffilComments,
                              String cdNbrAffilPhone,
                              String cdNbrAffilPhoneExt,
                              String cdAddrAffilAttn,
                              String cdAddrAffilStLn1,
                              String cdAddrAffilStLn2,
                              String cdAddrAffilCity,
                              String cdAddrAffilCounty,
                              String cdAddrAffilState,
                              String cdAddrAffilZip,
                              int idClassFclty,
                              int idClassAffilFclty,
                              int iNbrAffilAcclaim,
                              int iNbrAgency,
                              int iNbrBranch,
                              int iNbrAffilAgency,
                              int iNbrAffilBranch,
                              String cdAffilFacilType);

  /**
   * Updates a LicensingInvstDtl all fields except idCase which is set automatically on the insert.
   *
   * @param idEvent
   * @param idStage
   * @param cdLicngInvstOvrallDisp
   * @param dtLicngInvstIntake
   * @param dtLicngInvstDtlBegun
   * @param dtLicngInvstComplt
   * @param dtLicngInvstAssigned
   * @param cdTxtLicngInvstNoncomp
   * @param cdLicngInvstCoractn
   * @param idResource
   * @param cdNmResource
   * @param iNbrAcclaim
   * @param cdFacilType
   * @param cdTxtComments
   * @param cdNbrPhone
   * @param cdNbrPhoneExt
   * @param cdAddrAttn
   * @param cdAddrStLn1
   * @param cdAddrStLn2
   * @param cdAddrCity
   * @param cdAddrCounty
   * @param cdAddrState
   * @param cdAddrZip
   * @param idAffilResource
   * @param cdNmAffilResource
   * @param cdTxtAffilComments
   * @param cdNbrAffilPhone
   * @param cdNbrAffilPhoneExt
   * @param cdAddrAffilAttn
   * @param cdAddrAffilStLn1
   * @param cdAddrAffilStLn2
   * @param cdAddrAffilCity
   * @param cdAddrAffilCounty
   * @param cdAddrAffilState
   * @param cdAddrAffilZip
   * @param idClassFclty
   * @param idClassAffilFclty
   * @param iNbrAffilAcclaim
   * @param iNbrAgency
   * @param iNbrBranch
   * @param iNbrAffilAgency
   * @param iNbrAffilBranch
   * @param cdAffilFacilType
   * @return
   */
  int updateLicensingInvstDtl(int idEvent,
                              int idStage,
                              String cdLicngInvstOvrallDisp,
                              Date dtLicngInvstIntake,
                              Date dtLicngInvstDtlBegun,
                              Date dtLicngInvstComplt,
                              Date dtLicngInvstAssigned,
                              String cdTxtLicngInvstNoncomp,
                              String cdLicngInvstCoractn,
                              int idResource,
                              String cdNmResource,
                              int iNbrAcclaim,
                              String cdFacilType,
                              String cdTxtComments,
                              String cdNbrPhone,
                              String cdNbrPhoneExt,
                              String cdAddrAttn,
                              String cdAddrStLn1,
                              String cdAddrStLn2,
                              String cdAddrCity,
                              String cdAddrCounty,
                              String cdAddrState,
                              String cdAddrZip,
                              int idAffilResource,
                              String cdNmAffilResource,
                              String cdTxtAffilComments,
                              String cdNbrAffilPhone,
                              String cdNbrAffilPhoneExt,
                              String cdAddrAffilAttn,
                              String cdAddrAffilStLn1,
                              String cdAddrAffilStLn2,
                              String cdAddrAffilCity,
                              String cdAddrAffilCounty,
                              String cdAddrAffilState,
                              String cdAddrAffilZip,
                              int idClassFclty,
                              int idClassAffilFclty,
                              int iNbrAffilAcclaim,
                              int iNbrAgency,
                              int iNbrBranch,
                              int iNbrAffilAgency,
                              int iNbrAffilBranch,
                              String cdAffilFacilType);

  /**
   * Save or update a LicensingInvstDtl object
   *
   * @param licensingInvstDtl
   */
  void saveLicensingInvstDtl(LicensingInvstDtl licensingInvstDtl);

}
