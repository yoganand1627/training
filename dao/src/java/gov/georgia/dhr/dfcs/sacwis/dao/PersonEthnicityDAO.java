/**
 * Created on Mar 25, 2006 at 3:13:10 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;

import java.util.List;

public interface PersonEthnicityDAO {
  /**
   * This retrieves PersonEthnicity given idPerson
   *
   * @param idPerson
   * @return PersonEthnicity
   */
  List<PersonEthnicity> findPersonEthnicityByIdPerson(int idPerson);

  /**
   * This retrieves the latest entry of PersonEthnicity given idPerson
   *
   * @param idPerson
   * @return PersonEthnicity
   */
  public PersonEthnicity findLatestPersonEthnicityByIdPerson(int idPerson);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity} object to the database.
   *
   * @param personEthnicity A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity} object.
   */
  void savePersonEthnicity(PersonEthnicity personEthnicity);

  /**
   * Insert a new PersonEthnicity row
   *
   * @param idPerson
   * @param cdPersonEthnicity
   * @return number of rows affected
   */
  int insertPersonEthnicity(int idPerson, String cdPersonEthnicity);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity} object.
   *
   * @param idPerson
   */
  int deletePersonEthnicity(int idPerson);

  /**
   * Delete row from PersonEthnicity given idPerson and idIncmgPerson
   *
   * @param idPerson
   * @param idIncmgPerson
   * @return
   */
  int insertPersonEthnicityByIdPersonIdIncmgPerson(int idPerson, int idIncmgPerson);
}
