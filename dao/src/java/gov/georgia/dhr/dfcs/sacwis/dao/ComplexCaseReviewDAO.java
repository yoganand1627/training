/**
 * Created on March 13 2009 by Bhavna Gehlot
 */

package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

public interface ComplexCaseReviewDAO {

  /**
   * This calls the different DAO methods depending on the stage type.
   *
   * @param cdStage
   * @return List<Map<Object, Object>>
   */
  List<Map<String, Object>> findCaseReviewQuestions(String cdStage, int maxVersion);
}
