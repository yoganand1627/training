package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomesDetail;

import java.util.List;

public interface NeedsOutcomesDetailDAO {

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes} object to the database.
   *
   * @param needsOutcomesDetail
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes} object.
   */
  void saveNeedsOutcomesDetail(NeedsOutcomesDetail needsOutcomesDetail);

  /**
   * Retrieves all needs and outcomes detail from the Needs_Outcomes_detail table given idNeedsAndOutComesDetail. <p/>
   *
   * @param idEvent
   * @return
   */
  List<NeedsOutcomesDetail> findNeedsAndOutcomesDetailList(int idEvent);

  /**
   * Retrieves all needs and outcomes from the Needs_Outcomes_detail table given needs and outcomes id. <p/>
   *
   * @param idNeedsAndOutcomes
   * @return
   */
  NeedsOutcomesDetail findNeedsAndOutcomesDetail(int idNeedsAndOutcomes);

  /**
   * Deletes all needs and outcomes from the Needs_Outcomes_detail table given needs and outcomes id. <p/>
   *
   * @param idNeedsAndOutcomes
   * @return
   */
  int deleteNeedsAndOutcomesDetail(int idNeedsAndOutcomes);
}