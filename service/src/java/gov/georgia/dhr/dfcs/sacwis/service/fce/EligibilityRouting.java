package gov.georgia.dhr.dfcs.sacwis.service.fce;

public interface EligibilityRouting {
  
  /**
   * Description: This service will perform the MES ProcessFlow. 
   * It will submit the application and will add the 
   * county's MES Program Assistant as the secondary assignment to the Foster
   * Care stage.
   * 
   * @param idStage, int idUser, int idPerson, String eventType
   * @return Integer
   */
  public void eligibilityRouting(int idStage, int idUser, int idPerson, String eventType);
}
