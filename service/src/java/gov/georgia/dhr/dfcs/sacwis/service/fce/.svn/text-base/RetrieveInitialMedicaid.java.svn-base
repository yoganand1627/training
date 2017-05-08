package gov.georgia.dhr.dfcs.sacwis.service.fce;

import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;
/**
 * @author hjbaptiste
 * 
 */
public interface RetrieveInitialMedicaid {

  /**
   * Retrieves all columns for an IdPerson from the Person Dtl table.
   * 
   * @param medicaidApplicationRetrieveSI
   * @return MedicaidApplicationRetrieveSO
   */
  public MedicaidApplicationRetrieveSO retrieveInitialMedicaid(MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI);
  /**
   * Retrieves the stageId by the stage county 
   *
   * @param idStage
   * @return String
   */  
  public String retrieveStageCountyByStageId(int idStage);
  /**
   * Retrieves the IdEven from Event 
   *
   * @param idCase
   * @return int
   */  
  public int retrieveIdEventFromEvent(int idCase);
  /**
   * Retrieves the Even by IdEvent 
   *
   * @param idEvent
   * @return List<Map>
   */  
  public List retrieveEventByIdEvent(int idEvent);
}