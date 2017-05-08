/**
 * Created on Mar 25, 2006 at 2:45:33 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;

import java.util.Map;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------------------------------
 *   09/30/2011  hjbaptiste        STGAP00017011: MR-092 Fostering Connections. Added findIdEligibilityForLatestInitialAmendedApplication                                                                                                                                                                                           
 *   10/17/2011  hjbaptiste        STGAP00017237: MR-092 Fostering Connections. Added findIdFceEligibilityByIdEligibility                                                                                                                                                                                           
 */

public interface FceEligibilityDAO {
  /**
   * Retrieves the Eligibility Event ID (Eligibility Summary) for the most recent Initial/Amended application
   * 
   * @param idStage
   * @return Map 
   */
  Object[] findIdEligibilityForLatestInitialAmendedApplication(int idStage);
  
  /**
   * Retrieves the earliest FCE Eligibility record tied to an Application that generated
   * an Eligibility Summary based on the Eligibility Summary Event ID
   * 
   * @param idEligibilityEvent
   * @return
   */
  FceEligibility findIdFceEligibilityByIdEligibility(int idEligibilityEvent);
  
  /**
   * Updates table FceEligibility, field idPerson given idPersMergeClosed and idStage
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   */
  int updateFceEligibilityIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage);
  
  void updateFceEligibilityByCdPersonCitizenship(long idFceEligibility,String cdPersonCitizenship);
  
  void saveFceEligibility(FceEligibility fceEligibility);
  
  public FceEligibility findFceEligibilityByIdFceEligibility(long idFceEligibility);
  
  public FceEligibility findFceEligibilityByIdEligibilityEvent(long idEligibilityEvent);
  
  public int updateFceEligibilityByIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered);
  
  public Integer findFceEligibilityByIdFceApplication(long idFceApplication);
  
  public int updateFceEligibilityByCdBlocChild(long idFceEligibility, String cdBlocChild);
  
  public int updateFceEligibilityByCdBlocChild(long idFceEligibility, String cdBlocChild, double amtSsi);
  
  /**
   * This updates a row in the FCE_APPLICATION table with indMeetsDpOrNotEs
   * 
   * @param idFceEligibility
   * @param indMeetsDpOrNotEs
   * @return Integer indication how many rows were updated
   */
  int updateFceEligibilityByIndMeetsDpOrNotEs(long idFceEligibility, String indMeetsDpOrNotEs);
  
  /**
   * This updates a row in the FCE_APPLICATION table with NbrCertifiedGroup
   * 
   * @param idFceEligibility
   * @param nbrCertifiedGroup
   * @return Integer indication how many rows were updated
   */
  int updateFceEligibilityByNbrCertifiedGroup(long idFceEligibility, long nbrCertifiedGroup);
  
  /**
   * This updates a row in the FCE_APPLICATION table with indMeetsDpOrNotSystem
   * 
   * @param idFceEligibility
   * @param indMeetsDpOrNotSystem
   * @return Integer indication how many rows were updated
   */
  int updateFceEligibilityByIndMeetsDpOrNotSystem(long idFceEligibility, String indMeetsDpOrNotSystem);
}
