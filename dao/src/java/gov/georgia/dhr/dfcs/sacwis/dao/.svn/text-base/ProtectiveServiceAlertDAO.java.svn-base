/**
 * Created on July 10, 2006 By Srividya Janakiraman
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.ProtectiveServiceAlert;

public interface ProtectiveServiceAlertDAO {

  /**
   * This is an  update/insert for ProtectiveServiceAlert info.
   *
   * @param protectiveServiceAlert
   */
  void saveProtectiveServiceAlert(ProtectiveServiceAlert protectiveServiceAlert);
  
  /**
   * Retrieves the detailed data for a particular Protective Service Alert using the given idStage.
   * 
   * @param idStage
   * @return
   */
  List<Object[]> findPSAByIdStage(int idStage);
  
  /*
   * Returns the max ID_PROTECTIVE_SERVICE_ALERT from the PROTECTIVE_SERVICE_ALERT table for the given stage id.
   * 
   * @param idStage
   * @return
   */
  /*
  Integer findIdPSAByIdStage(int idStage);
  */
}

