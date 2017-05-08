/**
 * Created on Mar 25, 2006 at 1:48:42 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

public interface AllegationHistoryDAO {
  /**
   * This will retrieve all person ids in the alleged_perpetrator column on the allegation_history window for each of
   * the allegations on the allegation table for the stage_id passed in if the case program is AFC. The person ids
   * retrieved will be used to select the person information necessary to populate the Person List window.
   *
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Integer> findAllegationHistoryIdAllegedPerpetrator(int idStage);

  /**
   * This will retrieve all victims for a case from AllegationHistory given idStage.
   *
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<String> findAllegationHistoryNmPersonFull(int idStage);

}
