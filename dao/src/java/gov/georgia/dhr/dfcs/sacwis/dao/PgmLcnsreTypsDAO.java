package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps;

/**
 *  Created on Jan 22, 2007 at 4:50:45 PM by Haritha Mandava
 *
 */
public interface PgmLcnsreTypsDAO {
  /**
   * This selects a row from PgmLcnsreTyps table given the Floc ID. <p/>
   *
   * @param idFloc
   * @return PgmLcnsreTyps by idFloc
   * 
   */  
  List<PgmLcnsreTyps> findPgmLcnsreTypsByIdResource(int idResource);
  
  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps} object to the database.
   *
   * @param pgmLcnsreTyps A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps} object.
   */
  void savePgmLcnsreTyps(PgmLcnsreTyps pgmLcnsreTyps);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PgmLcnsreTyps} object.
   *
   * @param idFloc
   */
  void deletePgmLcnsreTypsByIdResource(int idResource);
}
