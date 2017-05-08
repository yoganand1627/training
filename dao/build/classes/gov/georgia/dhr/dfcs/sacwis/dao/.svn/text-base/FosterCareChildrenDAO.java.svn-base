/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FosterCareChildren;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Patrick Coogan
 *
 */
public interface FosterCareChildrenDAO {
  /**
   * This selects a unique row from the Foster Care Children materialized view for a child and
   * case. <p/>
   *
   * @param idPerson
   * @param idCase
   * @return FosterCareChildren
   */
  FosterCareChildren findFosterCareChildByPersonAndCaseId(int idPerson, int idCase);
  
  /**
   * This selects a map of custody entry and exit dates for the last 22 months in support
   * of the 15 of 22 month calculation
   *
   * @param idPerson
   * @param dtStart
   * @return List<Map> of entry/exit dates
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findFosterIncidentsByChildThruDate(int idPerson, Date dtStart);
  
}