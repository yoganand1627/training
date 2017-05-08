package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes;

public interface NeedsOutcomesDAO {

  /**
   * Retrieves all needs and outcomes from the Needs_Outcomes table given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  // @SuppressWarnings({"unchecked"})
  NeedsOutcomes findNeedsAndOutcomes(int idEvent);
  
  /**
   * Retrieves the latest approved needsOutcome for a stage . <p/>
   * 
   * @param idEvent
   * @return
   */
  NeedsOutcomes findNeedsAndOutcomesLatestApprovedByIdStage(int idStage);
  
  /**
   * Retrieves the latest approved/complete needsOutcome for a stage . <p/>
   * 
   * @param idEvent
   * @return
   */
  NeedsOutcomes findNeedsAndOutcomesLatestByIdStage(int idStage);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes} object to the database.
   * 
   * @param needsOutcomes
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.NeedsOutcomes} object.
   */
  void saveNeedsOutcomes(NeedsOutcomes needsOutcomes);
}
