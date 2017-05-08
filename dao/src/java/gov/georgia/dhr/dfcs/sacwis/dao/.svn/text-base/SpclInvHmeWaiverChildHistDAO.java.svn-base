package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHist;

import java.util.List;

/**
 * <pre>
 * Change History:
 * Date        User                     Description
 * --------    ----------------         ----------------------------------------------
 * 07/07/2011  hjbaptiste               SMS109631: CAPTA 4.3: Changed method name to updateSpclInvHmeWaiverChildHistWithPersonForward
 *                                      for person merge
 * </pre>
 *
 * @author Herve Jean-Baptiste, May 20, 2011
 */
public interface SpclInvHmeWaiverChildHistDAO {
  
  /**
   * Retrieves the Home Waiver Child List from the db for the given idSpclInvEvent. <p/>
   * 
   * @param idSpclInvEvent
   * @return
   */
  List<SpclInvHmeWaiverChildHist> findSpclInvHmeWaiverChildHist(int idSpclInvEvent);
  
  /**
   * Retrieves the Home Waiver Child from the db for the given idSpclInvEvent and idChild. <p/>
   * 
   * @param idSpclInvEvent
   * @param idChild
   * @return
   */
  SpclInvHmeWaiverChildHist findSpclInvHmeWaiverChildHistByIdEventIdChild(int idSpclInvEvent, int idChild);
  
  /**
   * Retrieves the column IndRemainInHome for a child listed in the Home Waiver section of a Special Investigation
   * 
   * @param idSpclInvEvent
   * @param idChild
   * @return
   */
  String findIndRemainInHomeByIdEventIdChild(int idSpclInvEvent, int idChild);
  
  /**
   * Saves in SPCL_INV_HME_WAIVER_CHILD_HIST table
   */
  void saveSpclInvHmeWaiverChildHist(SpclInvHmeWaiverChildHist spclInvHmeWaiverChildHist);
  
  /**
   * Deletes all Home Waiver Child records for the passed in idSpclInvEvent
   *  
   * @param idSpclInvEvent
   * @return Integer
   */
  int deleteAllSpclInvHmeWaiverChildHistByIdIdEvent(int idSpclInvEvent);
  
  /**
   * Deletes all Home Waiver Children records for the passed in list of idSpclInvEvent
   * 
   * @param List of idSpclInvEvents
   * @return Integer
   */
  public int deleteAllSpclInvHmeWaiverChildHistByListIdEvent(List<Integer> idSpclInvEvents);
  
  /**
   * Deletes a Home Waiver Child record from the db
   * 
   * @param spclInvHmeWaiverChildHist
   */
  void deleteSpclInvHmeWaiverChildHist(SpclInvHmeWaiverChildHist spclInvHmeWaiverChildHist);
  
  /**
   * Updates the person ids for all the Home Waiver Children for a person closed with a the person forward.
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return long
   */  
  int updateSpclInvHmeWaiverChildHistWithPersonForward(int idPersMergeForward, int idPersMergeClosed);
}
