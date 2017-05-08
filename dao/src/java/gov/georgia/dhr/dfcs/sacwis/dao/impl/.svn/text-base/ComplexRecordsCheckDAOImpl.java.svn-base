package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexRecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;

import java.util.List;

/**
 * Complex Records Check DAO
 * Author: Corey Harden
 * Date: 06/03/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 *
 *
 *
 *
*/


public class ComplexRecordsCheckDAOImpl extends BaseDAOImpl implements ComplexRecordsCheckDAO {

  private RecordsCheckDAO recordsCheckDAO;
  
  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }

  
  /**
   * This method serializes a list of Records Checks using the Hibernate
   * save or update method in the RecordsCheckDAO implementation and flushes
   * the list of serialized objects in a single batch process
   * @param rcList - a list of Records Checks
   */
  public void saveRecordsCheckBatch(List<RecordsCheck> rcList) {
    //loop thru list of Records Checks to save each record
    for(RecordsCheck rc : rcList){
      // do one last check to make sure Records Check is not null and date requested is filled
      if(rc != null && rc.getDtRecCheckRequest() != null){
        // save Records Check
        recordsCheckDAO.saveRecordsCheck(rc);
      }
    }
  }
  
}
