package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PsaPersonLink;

import java.util.Collection;
import java.util.List;
//import java.util.Map;

public interface PsaPersonLinkDAO {
  /**
   * This method is used by the Protective Service Alert page to retrieve the detailed data
   * for each person that has been issued a protective service alert for the Persons Absconded section of
   * the page.  The persons returned from this retrieve are ONLY the persons currently marked
   * as absconded.
   * 
   * @param idStage
   * @return List of Maps, each containing the data for each person with an active p.s.a. issued
   *         for them for the given stage, meaning they have been marked as absconded or runaway
   */
  List<Object[]> findPersonsAbsconded(int idStage);
  
  /**
   * Calls the Hibernate method saveOrUpdate for the given PsaPersonLink (Hibernate) object.
   * 
   * @param psaPersonLink
   */
  void savePsaPersonLink(PsaPersonLink psaPersonLink);

  /**
   * Retrieves a list of all active (no dtDeactivated) PsaPersonLink entries for the given idPerson.
   * 
   * @param idPerson
   * @return
   */
  List<PsaPersonLink> findActivePsaPersonLinksByIdPerson(int idPerson);
  
  /**
   * Counts number of active Protective Service alerts.
   * 
   * @param person id
   * @return count
   */
  long countActivePsa(int idPerson);
  
  /**
   * Retrieves the associated idStage for the earliest activated protective service alert from the
   * PROTECTIVE_SERVICE_ALERT table for the given idPerson from PSA_PERSON_LINK.  The earliest activated
   * date is represented by the minimum value for DT_ACTIVATED from all PSA_PERSON_LINK entries for the
   * person that have no DT_DEACTIVATED value. 
   * 
   * @param idPerson
   * @return
   */
  Integer findIdStageForEarliestPSAByIdPerson(int idPerson);
  
  /**
   * 
   * @param idPersons
   * @return
   */
  List<Integer> findActivePsaByPersonList(Collection<Integer> idPersons);
}
