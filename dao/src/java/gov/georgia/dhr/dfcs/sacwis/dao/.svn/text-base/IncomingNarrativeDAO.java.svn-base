/**
 * Created on Mar 25, 2006 at 2:58:05 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.IncomingNarrative;

public interface IncomingNarrativeDAO {
  /**
   * Counts the IncomingNaratives for the given idStage.
   *
   * @param idStage
   * @return The count of narratives for a particular stage (0 or 1).
   */
  long countIncomingNarrativesByIdStage(int idStage);

  /**
   * Retrieves the IncomingNaraative for the given idStage.
   *
   * @param idStage
   * @return IncomingNarrative
   */
  IncomingNarrative findIncomingNarrativeByIdStage(int idStage);
}
