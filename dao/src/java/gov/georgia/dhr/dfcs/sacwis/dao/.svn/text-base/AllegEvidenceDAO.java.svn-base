package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence;

public interface AllegEvidenceDAO {

  /**
   * Retrieves all allegation evidences for a given allegation .<p/>
   *
   * @param idAllegation
   */
  List<AllegEvidence> findAllegEvidenceByIdAllegation(int idAllegation);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence} object to the database.
   *
   * @param AllegEvidenceDAO A populated {@link gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence} object.
   */
  void saveAllegEvidence(AllegEvidence allegEvidence);

  /**
   * Deletes a {@link gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence} object to the database.
   *
   * @param AllegEvidenceDAO A populated {@link gov.georgia.dhr.dfcs.sacwis.db.AllegEvidence} object.
   * @param idAllegation
   * @param dtLastUpdate
   * @return
   */

  int deleteAllegEvidence(int idAllegEvidence, Date dtLastUpdate);

}
