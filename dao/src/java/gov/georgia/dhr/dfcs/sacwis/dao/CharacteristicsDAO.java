/**
 * Created on Mar 25, 2006 at 2:13:08 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;

/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - created method findCdCharacteristicsByIdPersons() 
 *                                to find characteristics for each person
 *
 */
public interface CharacteristicsDAO {
  /**
   * This method retrieves characteristic groupings for each person in the list
   * @param personIdsList - list of person id's
   * @return
   */
  public List<Map<String, String>> findCdCharacteristicsByIdPersons(Collection personIdsList);
  /**
   * This selects multiple rows from Characteristics given idPerson.
   *
   * @param idPerson
   * @param dtchareffdate
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.Characteristics} for the given idPerson.
   */
  @SuppressWarnings({"unchecked"})
  List<Characteristics> findCharacteristicsByIdPerson(int idPerson, Date dtchareffdate);

  /**
   * Retrieves rows from Characteristics table for a given idPerson and dtCharEnd
   *
   * @param idPerson
   * @param dtCharEnd
   * @return List of Characteristics object
   */
  @SuppressWarnings({"unchecked"})
  List<Characteristics> findCharacteristicsByIdPersonAndDtCharEnd(int idPerson, Date dtCharEnd);

  /**
   * Retrieves rows from Characteristics table for a given idPerson and a date(Effective Date).
   *
   * @param idPerson
   * @param dtCharEffDate
   * @return List of Characteristics objects
   */
  @SuppressWarnings({"unchecked"})
  List<Characteristics> findCharacteristicsByIdPersonAndEffectiveDate(int idPerson, Date dtCharEffDate);

  /**
   * Return a count of the number of Characteristics for a specific idPerson
   *
   * @param idPerson
   * @return A count of the number of Characteristics for a specific idPerson.
   */
  long countCharacteristicsByIdPerson(int idPerson);

  /**
   * Returns a record from Characteristics for idPerson and cdCharacteristic indicating Aged
   *
   * @param idPerson
   * @return A record from Characteristics for idPerson and cdCharacteristic indicating Aged.
   */
  Characteristics countAgedCharacteristicsByIdPerson(int idPerson);

  /**
   * Inserts a Characteristics row
   *
   * @param idPerson
   * @param cdCharCategory
   * @param cdCharacteristic
   * @param dtCharStart
   * @param dtCharEnd
   * @return
   */
  int insertCharacteristics(int idPerson, String cdCharCategory, String cdCharacteristic,
                            Date dtCharStart, Date dtCharEnd);

  /**
   * Updates the end date for a given Characteristics row
   *
   * @param idCharacteristics
   * @param dtCharEnd
   * @return
   */
  int updateCharacteristicsEndDate(int idCharacteristics, Date dtCharEnd);
  
  /**
   * This retrieves the characteristics for the given person  
   *
   * @param idCharacteristics
   * @param cdCharacteristicsList
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<String> findCdCharacteristicByIdPerson(Collection personIdsList);
  
  /**
   * gets characteristics for the given person
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Characteristics> findCharsByIdPerson(int idPerson);
  
  /**
   * Inserts or updates Characteristics record
   * @param characteristics
   */
  public void saveCharacteristics(Characteristics characteristics);

  /**
   * Return a count of the number of physical or developmental delay
   * Characteristics for a specific idPerson
   * 
   * Physical and developmental delay characteristics are define as any
   * any of the characteristics under Child Physical/Medical (CPM), 
   * Child Behavior (CHB), Child Mental/Emotional (CME), 
   * or the "Other Medically Diagnosed Conditions Requiring Special Care" 
   * characteristic 
   *
   * @param idPerson
   * @return A count of the number of physical or developmental delay Characteristics for a specific idPerson.
   */
  long countPhysicalDevelopmentalDelayCharacteristicsByIdPerson(int idPerson);
}
