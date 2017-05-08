package gov.georgia.dhr.dfcs.sacwis.service.fce;

public interface RetrieveMesProgramAssistant {
  /**
   * Description: This service first checks for the existance of a MES Program Assistant for the stage county
   * then if he/she exists then it returns the idPerson of the Mes Program Assistant or else it returns 0.
   * 
   * @param idStage, securityAttribute, specialization
   */
  public int retrieveMesProgramAssistant(int idStage, String securityAttribute);
}
