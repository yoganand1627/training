/**
 * Created on Mar 25, 2006 at 3:31:00 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Workload;
import java.util.List;

public interface WorkloadDAO {
  /**
   * Retrieve the ID PERSON for a given role, for a given stage. It's used to find the primary worker for a given stage.
   * 
   * @param idStage
   * @param cdWkldStagePersRole
   * @return
   */
  Integer findIdWkldPersonByIdStageAndCdWkldStagePersRole(int idStage, String cdWkldStagePersRole);

  /**
   * Retrieves all of the ID PERSON for a given role, for a given stage. It's used to find the secondary workers for a
   * given stage.
   * 
   * @param idStage
   * @param cdWkldStagePersRole
   * @return
   */
  List<Integer> findIdOfAllSecondaryWorkersOfStage(int idStage, String cdWkldStagePersRole);

  /**
   * Retrieves the total assignments from the Workload table for the given Person ID.
   * 
   * @param idPerson
   * @return Integer
   */
  long countWorkloadByIdPerson(int idPerson);

  /**
   * Retrieves the total Primary Stages from the Workload table for the given Person ID.
   * 
   * @param idPerson
   * @return Integer
   */
  long countPrimaryStagesByIdPerson(int idPerson);

  /**
   * Retrieves the row from Workload table for the given Stage ID.
   * 
   * @param idStage
   * @return Workload
   */
  Workload findWorkloadByIdStage(int idStage);

  /**
   * 
   * 
   * @param idPerson
   * @param idCurrentUser
   * @return The people assigned to stages of person.
   */
  List<Object[]> findAssignedPersonStage(int idPerson, int idCurrentUser);

  /**
   * Retrieves a list of idPersons for all workers with assignations to the idCase specified by the given role ('PR' or
   * 'SE'). The list will contain all unique idPersons, meaning that if one person has a PR or SE assignment to more
   * than one stage for the same case, their id will only be listed once.
   * 
   * @param idCase
   * @param cdStagePersRole
   * @return
   */
  List<Object[]> findAssignedPersonStageByIdCase(int idCase);

  /**
   * Retrieves a list of idPersons for all workers with assignations to the idCase specified by the given role ('PR' or
   * 'SE'). The list will contain all unique idPersons, meaning that if one person has a PR or SE assignment to more
   * than one stage for the same case, their id will only be listed once.
   * 
   * @param idCase
   * @return
   */
  List<Integer> findIdPersonsByIdCaseAndCdStagePersRole(int idCase, String cdStagePersRole);

  /**
   * Retrieves a list of idPersons for all workers with assignations to the idStage specified by the given role ('PR' or
   * 'SE'). The list will contain all unique idPersons.
   * 
   * @param idStage
   * @param cdStagePersRole
   * @return
   */
  List<Integer> findIdPersonsByIdStageAndCdStagePersRole(int idStage, String cdStagePersRole);

  /**
   * Retrieves the role of the person for the given idStage and idPerson
   * 
   * @param idStage
   * @param idPerson
   * @return
   */
  String findPersRoleByIdStageIdPerson(int idStage, int idPerson);
  
  
  
  /**
   * Updates the County displayed for the Workload page 
   * @param idStage
   * @param cdCounty
   * @return
   */
  public int updateWklStageCountyByIdStage(int idStage, String cdCounty);
}
