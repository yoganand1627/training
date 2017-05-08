package gov.georgia.dhr.dfcs.sacwis.service.fce;

public interface SaveEligibilityAlert {
  
  /**
   * This method saves the alert "Eligibility needs to be redetermined for <Stage Name> by <Current Date + 6 Months>"
   * when MES Worker confirms the eligibility. 
   * This method also saves the alert "Child's Initial Medicaid Application has been submitted for assignment."
   * when Case Manager submits the initial Medicaid Application
   *
   * @param int idPerson, int idCase, int idStage, String eventType
   */
  public void saveEligibilityAlert(int idPerson, int idUser, int idStage, int idCase, String eventType );
}
