package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;

/**
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  02/10/2010  wjcochran      SMS #44832 - Added new service retrieveAllPrincipalsWithNullInPKHshld
 *  
 * </pre>
 */
public interface RetrievePrincipals {
  /**
   * This service retrieves the Principal list.
   *
   * @param cinv36si
   * @return A populated {@link CINV36SO} object.
   */
  public CINV36SO retrievePrincipals(CINV36SI cinv36si);
  
  /**
   * This Service Retrieves all Principals regardless of household status 
   * @param idStage
   * @param type
   * @return List<Person>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> retrieveAllPrincipals(int idStage, String type);
 

  /**
   * This service retrieves all principals for a particular idStage
   * that do not have a household status.
   * @param idStage
   * @param type
   * @return List<Map>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Map> retrieveAllPrincipalsWithNullInPKHshld(int idStage, String type);

}
