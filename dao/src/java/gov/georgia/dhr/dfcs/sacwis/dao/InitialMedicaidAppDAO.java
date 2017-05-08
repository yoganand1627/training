/**
 * Created on Mar 24, 2006 at 5:32:41 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.InitialMedParent;
import gov.georgia.dhr.dfcs.sacwis.db.InitialMedicaidApp;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface InitialMedicaidAppDAO {
  public int saveInitialMedicaidApp(InitialMedicaidApp initialMedicaidApp);
  public Map findInitialMedicaid(int idEvent);
  
  /**
   * This method retrieves the Success Medicaid Assistance and the Date of the
   * Success Medicaid Assistance from the INITIAL_MEDICAID_APP table. 
   * 
   * @param idCase
   * @param idStage
   * @return Map which contains the two fields
   */
  public Map findSuccessMedAssistanceByCaseAndStage (long idCase, long idStage, String eventType);
  
  /**
   * This method updates the CD_SUCCESS_CLASS_ASSISTANCE, DT_SUCC_CLASS_ASSISTANCE
   * which is obtained through MedicaidCoareq inbound service
   * @param idEvent
   * @param cdSuccessClassAssistance
   * @param dtSuccClassAssistance
   * @return
   */
  public Integer updateMedicaidCoa(int idEvent, String cdSuccessClassAssistance, Date dtSuccClassAssistance);
  
  /**
   * This method returns DtSuccessClassAssistance based on idEvent parameter
   * @param idEvent
   * @return
   */
  public Date findDtSuccClassAssiastanceByIdEvent(int idEvent);
  
  /**
   * This method returns InitialMedicaidApp based on idEvent parameter
   * @param idEvent
   * @return
   */
  public InitialMedicaidApp findInitialMedicaidByIdEvent(int idEvent); 
  
  /**
   * This method saves the data in the Initial_Med_Parent table
   * @param initialMedParent
   */
  public void saveInitialMedParent(InitialMedParent initialMedParent);
  
  /**
   * This method retreives the indParent from the Initial_Med_Parent table
   * @param idStage, idCase, idEvent
   */
  public List<Map> findIndParent(int idStage, int idCase, int idEvent);
  
  /**
   * This method updates the data in the Initial_Med_Parent table
   * @param initialMedParent
   */
  public Integer updateInitialMedParent(int idPerson , String indParent);
}
  
