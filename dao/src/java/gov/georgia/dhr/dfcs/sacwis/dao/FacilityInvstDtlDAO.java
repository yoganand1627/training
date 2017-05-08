/**
 * Created on Mar 25, 2006 at 2:48:00 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.FacilityInvstDtl;

public interface FacilityInvstDtlDAO {
  /**
   * This will retrieve the facility name of a stage.
   *
   * @param idStage
   * @return String
   */
  @SuppressWarnings({"unchecked"})
  String findNmFacilInvstFacilityFromFacilityInvstDtlByIdStage(int idStage);

  /**
   * Returns some FacilityInvstDtl info and stageReasonClosed by idStage
   *
   * @param idStage
   * @return List<Map>
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findFacilityInvstDtlOvrallDisCompltReasonClosedByIdStage(int idStage);

  /**
   * Retrieves a row from FacilityInvstDtl table for the given idStage.
   *
   * @param idStage
   * @return FacilityInvstDtl
   */
  FacilityInvstDtl findFacilityInvstDtlByIdStage(int idStage);

  /**
   * Insert row with specified columns
   *
   * @param idEvent
   * @param idStage
   * @param idFacilResource
   * @param idAffilResource
   * @param cdFacilInvstOvrallDis
   * @param cdAddrFacilInvstAffAttn
   * @param cdAddrFacilInvstAffCity
   * @param cdAddrFacilInvstAffCnty
   * @param cdAddrFacilInvstAffilSt
   * @param cdAddrFacilInvstAffStr1
   * @param cdAddrFacilInvstAffStr2
   * @param cdAddrFacilInvstAffZip
   * @param cdAddrFacilInvstAttn
   * @param cdAddrFacilInvstCity
   * @param cdAddrFacilInvstCnty
   * @param cdAddrFacilInvstState
   * @param cdAddrFacilInvstStr1
   * @param cdAddrFacilInvstStr2
   * @param cdAddrFacilInvstZip
   * @param dtFacilInvstIntake
   * @param dtFacilInvstIncident
   * @param dtFacilInvstBegun
   * @param dtFacilInvstComplt
   * @param iNbrFacilInvstAffilPhn
   * @param iNbrFacilInvstPhone
   * @param cdNbrFacilInvstAffilExt
   * @param cdNbrFacilInvstExtension
   * @param cdTxtFacilInvstAffilCmnt
   * @param cdTxtFacilInvstComments
   * @param cdNmFacilInvstAff
   * @param cdNmFacilInvstFacility
   * @return
   */
  int insertFacilityInvstDtl2(int idEvent,
                              int idStage,
                              int idFacilResource,
                              int idAffilResource,
                              String cdFacilInvstOvrallDis,
                              String cdAddrFacilInvstAffAttn,
                              String cdAddrFacilInvstAffCity,
                              String cdAddrFacilInvstAffCnty,
                              String cdAddrFacilInvstAffilSt,
                              String cdAddrFacilInvstAffStr1,
                              String cdAddrFacilInvstAffStr2,
                              String cdAddrFacilInvstAffZip,
                              String cdAddrFacilInvstAttn,
                              String cdAddrFacilInvstCity,
                              String cdAddrFacilInvstCnty,
                              String cdAddrFacilInvstState,
                              String cdAddrFacilInvstStr1,
                              String cdAddrFacilInvstStr2,
                              String cdAddrFacilInvstZip,
                              Date dtFacilInvstIntake,
                              Date dtFacilInvstIncident,
                              Date dtFacilInvstBegun,
                              Date dtFacilInvstComplt,
                              int iNbrFacilInvstAffilPhn,
                              int iNbrFacilInvstPhone,
                              String cdNbrFacilInvstAffilExt,
                              String cdNbrFacilInvstExtension,
                              String cdTxtFacilInvstAffilCmnt,
                              String cdTxtFacilInvstComments,
                              String cdNmFacilInvstAff,
                              String cdNmFacilInvstFacility);

  /**
   * Set 3 columns to null for a given idStage
   *
   * @param idStage
   * @return number of rows affected
   */
  int updateFacilInvstDtlSetNullByIdStage(int idStage);

}
