/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CwLastViewed;

/**
 * @author Patrick Coogan
 *
 */
public interface CwLastViewedDAO {
  /**
   * This selects a row for the most recent time the staff member has
   * viewed the Case Watch page.
   *
   * @param idStaff
   * @return CwLastViewed
   */
  CwLastViewed findLastViewedByIdStaff(int idStaff, int idStage);
  
  /**
   * This method saves a new row, to be used when the case manager or supervisor views
   * the case watch page.
   *
   * @param cwLastViewed
   */
  void saveCwLastViewed(CwLastViewed cwLastViewed);
  
}
