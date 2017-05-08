package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;

public interface SaveFceApplication {

  /**  This service saves the record in FCE_APPLICATION table with
   *   required data filled in.
   *   @param fceApplicationDB
   *   @return int
   */
  public int saveFceApplication(FceApplicationDB fceApplicationDB);
}
