package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SpclInvStateConcur;

import java.util.List;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, May 22, 2011
 */

public interface SpclInvStateConcurDAO {

  /**
   * Calls Hibernate method Session.saveOrUpdate for the given {@link gov.georgia.dhr.dfcs.sacwis.db.SpclInvStateConcur} object.
   * 
   * @param sisc
   */
  void saveStateConcurrence(SpclInvStateConcur sisc);
  
  /**
   * Calls Hibernate method Session.delete for the given {@link gov.georgia.dhr.dfcs.sacwis.db.SpclInvStateConcur} object.
   * 
   * @param sisc
   */
  void deleteStateConcurrence(SpclInvStateConcur sisc);
  
  /**
   * Deletes all entries in SpclInvStateConcur for the given idSpclInvEvent-cdStateConcur combination.
   * 
   * @param idSpclInvEvent
   * @param cdStateConcur
   * @return
   */
  int deleteStateConcurrence(int idSpclInvEvent, String cdStateConcur);
  
  /**
   * Deletes all entries in SpclInvStateConcur for the given idSpclInvEvent
   * 
   * @param idSpclInvEvent
   * @return
   */
  int deleteStateConcurrence(int idSpclInvEvent);
  
  /**
   * Retrieves a list of all SpclInvStateConcur entries for the given idSpclInvEvent (key to SpclInvestigation).
   * 
   * @param idSpclInvEvent
   * @return
   */
  List<SpclInvStateConcur> findSpclInvStateConcurList(int idSpclInvEvent);

  /**
   * Retrieves a list of all cdStateConcur entries for the given idSpclInvEvent (key to SpclInvestigation).
   * 
   * @param idSpclInvEvent
   * @return List<String>
   */
  List<String> findCdStateConcurrenceListByIdEvent(int idSpclInvEvent);
}
