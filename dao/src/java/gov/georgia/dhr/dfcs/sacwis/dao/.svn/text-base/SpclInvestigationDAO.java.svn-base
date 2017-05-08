package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.SpclInvestigation;


/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, May 20, 2011
 */

public interface SpclInvestigationDAO {
  
  /**
   * Retrieves the Special Investigation from the db for the given idEvent. <p/>
   * 
   * @param idSpclInvEvent
   * @return
   */
  SpclInvestigation findSpclInvestigationByIdEvent (int idSpclInvEvent);
  
  /**
   * Updates Spcl Investigation table.
   * 
   * @param spclInvestigation
   * 
   * @return
   */
  void saveSpclInvestigation(SpclInvestigation spclInvestigation);
  
  /**
   * Simple deletes of a Special Investigation
   * 
   * @param spclInvestigation
   * @return Integer
   */
  void deleteSpclInvestigation(SpclInvestigation spclInvestigation);
  
  /**
   * Updates the date the Special Investigation was sent to the Policy Unit
   * 
   * @param dtSpclInvSent
   * @param idSpclInvEvent
   * @return
   */
  int updateSpclInvDateSent(Date dtSpclInvSent, int idSpclInvEvent);
  
  /**
   * Updates the date the Special Investigation was approved by the Policy Unit
   * 
   * @param dtSpclInvApproved
   * @param idSpclInvEvent
   * @return
   */
  int updateSpclInvDateApproved(Date dtSpclInvApproved, int idSpclInvEvent);
  
}
