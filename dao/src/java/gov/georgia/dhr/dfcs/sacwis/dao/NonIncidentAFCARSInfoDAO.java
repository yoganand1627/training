package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.NonIncidentAfcarsInfo;

public interface NonIncidentAFCARSInfoDAO {

  /**
   * Inserts or updates a Non-Incident AFCARS Information record
   * 
   * @param exchangeChild
   * @return 
   */
  public void saveNonIncidentAFCARSInfo(NonIncidentAfcarsInfo nonIncAFCARS);
  
  /**
   * Finds the Non-Incident AFCARS Information record for the person id passed in.
   * 
   * @param idPerson
   * @return 
   */
  public NonIncidentAfcarsInfo findNonIncidentAFCARSInfoByPersonID(int idPerson);

}
