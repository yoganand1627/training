/**
 * Created on Mar 25, 2006 at 3:15:59 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PalPublicAssist;

public interface PalPublicAssistDAO {
  /**
   * This selects all rows from PalPublicAssist given idstage.
   *
   * @param idstage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<PalPublicAssist> findPalPublicAssist(int idstage);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PalPublicAssist} object to the database.
   *
   * @param palPublicAssist A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PalPublicAssist} object.
   */
  void savePalPublicAssist(PalPublicAssist palPublicAssist);

  /**
   * Deletes rows from PalPublicAssist based on idPalPublicAssistStge, cdPalPublicAssist, and dtLastUpdate
   *
   * @param idStage
   * @param cdPalPublicAssist
   * @param dtLastUpdate
   * @return Integer
   */
  int deletePalPublicAssist(int idStage, String cdPalPublicAssist, Date dtLastUpdate);
}
