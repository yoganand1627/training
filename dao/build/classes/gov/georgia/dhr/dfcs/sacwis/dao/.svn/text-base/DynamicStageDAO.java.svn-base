/**
 * Created on Apr 25, 2006 at 9:50:53 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

public interface DynamicStageDAO {
  /**
   * This DAO will retrieve stages that: <ul><li>match the idCase</li> <li>match the cdStage</li> <li>do NOT match the
   * idStage</li> <li>have cdStageReasonClosed set to null unless cdStageReasonClosed is ADO, in which case it can be
   * "010"</li></ul>
   *
   * @param idCase
   * @param cdStage
   * @param idStage
   * @return The count of stages matching the specified criteria.
   */
  long countStages(int idCase, String cdStage, int idStage);
}
