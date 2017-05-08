/**
 * Created on Mar 25, 2006 at 2:47:18 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnic;
import gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnicId;

import java.util.List;

public interface FaHomeIntEthnicDAO {
  /**
   * This selects a row from FaHomeIntEthnic table given the Resource ID. <p/>
   *
   * @param idResource
   * @return FaHomeIntEthnic by idResource
   */
  List<FaHomeIntEthnic> findFaHomeIntEthnicByIdResource(int idResource);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnic} object to the database.
   *
   * @param faHomeIntEthnic A populated {@link gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnic} object.
   */
  void saveFaHomeIntEthnic(FaHomeIntEthnic faHomeIntEthnic);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.FaHomeIntEthnic} object.
   *
   * @param faHomeIntEthnic
   */
  int deleteFaHomeIntEthnic(FaHomeIntEthnicId faHomeIntEthnicId);
}
