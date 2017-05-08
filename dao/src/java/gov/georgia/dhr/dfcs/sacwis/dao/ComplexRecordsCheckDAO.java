package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;

import java.util.List;

public interface ComplexRecordsCheckDAO {
  
  /**
   * This method serializes a list of Records Checks using the Hibernate
   * save or update method in the RecordsCheckDAO implementation and flushes
   * the list of serialized objects in a single batch process
   * @param rcList - a list of Records Checks
   */
  public void saveRecordsCheckBatch(List<RecordsCheck> rcList);
}
