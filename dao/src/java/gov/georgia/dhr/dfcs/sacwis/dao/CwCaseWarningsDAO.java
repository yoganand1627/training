/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CwCaseWarnings;
import java.util.List;

/**
 * @author Patrick Coogan
 *
 */
public interface CwCaseWarningsDAO {
  /**
   * This selects a list of case warnings for a stage.
   *
   * @param idStage
   * @return List<CwCaseWarnings>
   */
  List<CwCaseWarnings> findCwCaseWarningsByStageID(int idStage);
  
}
