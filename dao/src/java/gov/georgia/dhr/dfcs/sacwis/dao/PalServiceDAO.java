/**
 * Created on Mar 25, 2006 at 3:15:37 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PalService;

public interface PalServiceDAO {
  /**
   * Retrieves a list from PalService given idStage
   *
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<PalService> findPalService(int idStage);

  /**
   * Retrieves a count of distinct cdPalServiceType from PalService given idStage, cdPalServiceCatgory, idPerson,
   * cdSvcDtlA, cdSvcDtlB, cdSvcDtlC, cdSvcDtlD, cdSvcDtlE, cdSvcDtlF.
   *
   * @param idStage
   * @param cdPalServiceCatgory
   * @param idPerson
   * @param cdSvcDtlA
   * @param cdSvcDtlB
   * @param cdSvcDtlC
   * @param cdSvcDtlD
   * @param cdSvcDtlE
   * @param cdSvcDtlF
   * @return cdPalServiceType
   */
  long countPalServiceType(int idStage, String cdPalServiceCatgory, int idPerson,
                           String cdSvcDtlA, String cdSvcDtlB, String cdSvcDtlC,
                           String cdSvcDtlD, String cdSvcDtlE, String cdSvcDtlF);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PalService} object to the database.
   *
   * @param palService A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PalService} object.
   */
  void savePalService(PalService palService);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PalService} object.
   *
   * @param palService
   */
  void deletePalService(PalService palService);
}
