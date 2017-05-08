/**
 * Created on Mar 25, 2006 at 3:05:35 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate;

public interface MedicaidUpdateDAO {
  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate} object to the database.<p/>
   *
   * @param medicaidUpdate A populated {@link gov.georgia.dhr.dfcs.sacwis.db.MedicaidUpdate} object.
   */
  void saveMedicaidUpdate(MedicaidUpdate medicaidUpdate);

  /**
   * Will add row to the MEDICAID_UPDATE table.
   *
   * @param tsLastUpdate
   * @param idMedUpdPerson
   * @param idMedUpdStage
   * @param idMedUpdRecord
   * @param cdMedUpdType
   * @param cdMedUpdTransTypE
   * @return the number of rows inserted
   */
  int insertMedicaidUpdate(Date tsLastUpdate, int idMedUpdPerson, int idMedUpdStage,
                           int idMedUpdRecord, String cdMedUpdType, String cdMedUpdTransTypE);
}
