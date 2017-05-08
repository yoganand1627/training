/**
 *  Created on February 25, 2010 at by Ashwini Rege
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.ChldDthCauseCbx;

import java.util.List;

/**
 *   This is the DAO class is used for the CHLD_DTH_CAUSE_CBX table
 *   
 * @author ashwini.rege
 *  * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  03/22/2010  arege    Added method to delete ChldDthCauseCbx recoord for a given idEvent
 */

public interface ChldDthCauseCbxDAO {
  
  /**
   * 
   * Find Causes of Death Records for given idEvent
   * @param idEvent
   * @return cdCauseDeath
   */
  List<String> findSavedCausesByIdEvent(int idEvent);
  

  /**
   * Inserts or updates a row in CHLD_DTH_CAUSE_CBX
   * 
   * @param idEvent
   * @return int
   */  
  public void saveOrUpdateCausesOfDeath(ChldDthCauseCbx chldDthCauseCbx);  
  
  /**
   * 
   * 
   * @param cdCauseDeath
   * @param idEvent
   * @return
   */
  public int deleteCauseOfDeath(String cdCauseDeath, int idEvent);
  
  /**
   * @param idEvent
   * @return
   */
  public int  deleteChldDthCauseCbxByIdEvent(int idEvent);

}
