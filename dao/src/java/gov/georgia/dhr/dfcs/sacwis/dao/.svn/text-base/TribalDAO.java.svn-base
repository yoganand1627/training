package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Tribal;

public interface TribalDAO {

  /**
   * This will retrieve an entire row from the tribal table given the primary key of idPerson
   *
   * @param idPerson
   * @return The {@link gov.georgia.dhr.dfcs.sacwis.db.Tribal} object for a given idPerson.
   */
  Tribal findTribalByIdPerson(int idPerson);

  /**
   * This will retrieve id_tribal from the tribal table given the primary key of idPerson
   *
   * @param idPerson
   * @return The {idTribal} for a given idPerson.
   */
  Integer findIdTribalByIdPerson(int idPerson);
  
  /**
   * Retrieves the one Tribal record for idPerson that was last updated according to dtLastUpdate
   * 
   * @param idPerson
   * @return
   */
  Tribal findLatestTribal(int idPerson);
  
  /**
   * Calls Session#saveOrUpdate to persist the given Tribal object.
   * 
   * @param tribal
   */
  void saveTribal(Tribal tribal);
}
