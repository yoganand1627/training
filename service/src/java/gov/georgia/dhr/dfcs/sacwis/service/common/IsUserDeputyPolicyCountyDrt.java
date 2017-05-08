package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.util.List;

/**
 * CAPTA 4.3 - Interface created for Contact Search/Detail page.
 * @author lata.lokhande
 *
 */

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - added hasSecurityClass() method
 *
 */
public interface IsUserDeputyPolicyCountyDrt {
  /**
   * This method returns true if logged in user is either Deputy director, Policy Unit or County director.
   * @param idPerson
   * @param county
   * @return
   */
  public boolean isUserDeputyPolicyCountyDrt(int idPerson, int idStage );
 /**
  * This method checks if logged in user is Deputy Director.
  * @param idCase
  * @param idStage
  * @param idPerson
  * @return
  */
  public boolean isUserDeputyDirector(int idPerson);
  /**
   * This method checks if logged in user is policy Unit
   * @param idPerson
   * @return
   */
  public boolean  isUserPolicyUnit(int idPerson);
  /**
   * This method checks if logged in user is County Director
   * @param idPerson
   * @param idStage
   * @return
   */
  public boolean  isUserCountyDirector(int idPerson, int idStage);
  /**
   * This method finds and returns the list of employee ids for State Office Resource Developer
   * @return
   */
  public List<Integer> getStateOfficeResourceDeveloperList();
  /**
   * This method retrieves the County Director's Id for the given county.
   * The unit number for the county director is always 18.
   * There is always only one county director for a county.
   * @param idStage
   * @param unitNumber
   * @return
   */
  public Integer getCountyDirector(int idStage, String unitNumber);
  /**
   * This method checks if the logged in person has assigned the Security Class
   * @param idPerson
   * @param securityClassName
   * @return
   */
  public boolean hasSecurityClass(int idPerson, String securityClassName);
}
