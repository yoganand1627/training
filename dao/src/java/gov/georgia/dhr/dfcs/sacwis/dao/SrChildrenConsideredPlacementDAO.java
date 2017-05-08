package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SrChildConsiderPlcmnt;
import java.util.List;

/**
 *  Created on June 22, 2009  by Bhavna Gehlot
 * This class declares the interface for the SrChildrenConsideredPlacementDAO and holds the simple
 * methods for accessing the SR_CHILD_CONSIDER_PLCMNT table in the CAPS schema.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * </pre>
 */

public interface SrChildrenConsideredPlacementDAO {

 
  /**
   * Returns person id's of existing children considered for a passed event
   * 
   * @param idEvent
   * @return List <Integer>
   */
  public List<Integer> findSrChildrenConsideredByIdEvent(int idEvent);
  
  /**
   * Deletes a row from SR_CHILD_CONSIDER_PLCMNT for a passed person and event
   * 
   * @param idEvent
   * @param idPerson
   * @return int
   */ 
  public int deleteSrChildrenConsiderByPersonAndEvent(int idPerson, int IdEvent);
  
  /**
   * Deletes all row from SR_CHILD_CONSIDER_PLCMNT for a given safety resource event
   * 
   * @param idEvent
   * @return int
   */ 
  public int deleteSrChildrenConsiderByEvent(int IdEvent);
  
  /**
   * Inserts or updates a row in SR_CHILD_CONSIDER_PLCMNT 
   * 
   * @param idEvent
   * @return int
   */  
  public void saveOrUpdateSrChildrenConsidered(SrChildConsiderPlcmnt srChildConsiderPlcmnt);
}
