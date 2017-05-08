package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

public interface UpdateFcePersonBirthday {
  
  /**
   * This updates the FCE_PERSON table with dtBirth, nbrAge, indDobApprox.
   * 
   * @param fcePersonDB
   */   
  public void updateFcePersonBirthday(FcePersonDB fcePersonDB);

}
