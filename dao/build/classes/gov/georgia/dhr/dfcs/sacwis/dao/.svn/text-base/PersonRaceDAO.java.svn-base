/**
 * Created on Mar 25, 2006 at 3:18:51 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;

public interface PersonRaceDAO {
  /**
   * Retrieves all race info from the person_race table given idPerson.
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  PersonRace findDistinctPersonRaceByIdPerson(int idPerson);
  
 /**
  * Checks to see if the persons race already exists
  * @param idPerson
  * @param cdPersonRace
  * @return
  */
  long findPersonRaceByIdPersonCdPersonRace(int idPerson, String cdPersonRace);
  
  /**
   * Retrieves all PersonRace rows for a specified idPerson
   *
   * @param idPerson
   * @return List<PersonRace>
   */
  @SuppressWarnings({"unchecked"})
  List<PersonRace> findPersonRaceByIdPerson(int idPerson);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonRace} object to the database.
   *
   * @param personRace A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PersonRace} object.
   */
  void savePersonRace(PersonRace personRace);

  /**
   * Delete rows from PersonRace based on ID_PERSON and CD_RACE.
   *
   * @param idPerson
   * @param cdPersonRace
   * @return
   */
  int deletePersonRaceByIdPersonAndCdPersonRace(int idPerson, String cdPersonRace);

  /**
   * Delete rows from PersonRace given idPersin and idIncmgPerson.
   *
   * @param idPerson
   * @param idIncmgPerson
   * @return
   */
  int insertPersonRaceByIdPersonIdIncmgPerson(int idPerson, int idIncmgPerson);
}
