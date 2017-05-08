package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;

public interface AppAndBgCommonFunction {
  
  /**
   * This checks the database to see if an FCE Application exists based on an idApplicationEvent
   * 
   * @param idApplicationEvent
   * @return FceApplicationDB
   */
  public FceApplicationDB findApplicationByApplicationEvent(long idApplicationEvent);
  
  /**
   * This updates the FCE_APPLICATION table with person address.
   * 
   * @param fceApplicationDB
   */  
  public void updateFceApplicationPersonAddress(FceApplicationDB fceApplicationDB);
  
  /**
   * This updates the Eval Conclusion indicator on the FCE Application
   * @param idFceApplication
   * @param indEvaluationConclusion
   */
  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion);
  /**
   * This updates the FCE_APPLICATION table with cdApplication.
   * 
   * @param fceApplicationDB
   */    
  public void updateFceApplicationCdApplication(FceApplicationDB fceApplicationDB);
  
  /**
   * This updates the FCE_PERSON table with CdRelInt and LegalCustodian.
   * 
   * @param long idFcePerson, String cdRelInt, boolean indLegalCustodian
   */  
  public void updateCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, boolean indLegalCustodian);
  
  /**
   * This updates the FCE_APPLICATION table with NbrLivingAtHome
   * 
   * @param idFceApplication
   * @param nbrLivingAtHome
   * @return Integer indicating how many rows were updated
   */
  public int updateNbrLivingAtHome(long idFceApplication, long nbrLivingAtHome);

  /**
   * This updates the FCE_ELIGIBILITY table with IndMeetsDpOrNotEs
   * 
   * @param idFceApplication
   * @param indMeetsDpOrNotEs
   * @return Integer indicating how many rows were updated
   */
  public int updateIndMeetsDpOrNotEs(long idFceApplication, String indMeetsDpOrNotEs);
  
  /**
   * This updates the FCE_ELIGIBILITY table with NbrCertifiedGroup
   * 
   * @param idFceApplication
   * @param nbrCertifiedGroup
   * @return Integer indicating how many rows were updated
   */
  public int updateNbrCertifiedGroup(long idFceApplication, long nbrCertifiedGroup);
  
  /**
   * This updates the FCE_PERSON table.
   * 
   * @param fcePersonDB
   */ 
  public void updateFcePerson(FcePersonDB fcePersonDB);
  
  /**
   * This updates the FCE_ELIGIBILITY table with IndMeetsDpOrNotSystem
   * 
   * @param idFceEligibility
   * @param indMeetsDpOrNotSystem
   * @return Integer indicating how many rows were updated
   */
  public void updateFceEligibilityByIndMeetsDpOrNotSystem(long idFceEligibility, String indMeetsDpOrNotSystem);
  
  /**
   * This updates the FCE_APPLICATION table with most recent removal date for case
   * 
   * @param idFceApplication
   */
  public void updateRemovalDate(int idFceApplication);
  
  /**  This service retrieves the record from FCE_APPLICATION table
   *   @param idFceApplication
   *   @return FceApplicationDB
   */
  public FceApplicationDB retrieveFceApplication(long idFceApplication) throws ServiceException;
}
