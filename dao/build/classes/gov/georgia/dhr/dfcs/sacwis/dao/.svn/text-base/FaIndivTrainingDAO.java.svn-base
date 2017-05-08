/**
 * Created on Mar 25, 2006 at 2:47:03 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.FaIndivTraining;

public interface FaIndivTrainingDAO {
  @SuppressWarnings({"unchecked"})
  //List<FaIndivTraining> findFaIndivTrainingByIdPerson(int idPerson);
  List<Map> findFaIndivTrainingByIdPerson(int idPerson);

  /**
   * Retrieves a count by querying FaIndivTraining tables for the two given Person Ids idPerson and idNewPerson. (ie.
   * count of the training occurring on  the same day for two 'IdPerson's).
   *
   * @param idPerson
   * @param idNewPerson
   * @return Integer
   */
  long countFaIndivTrainingByIdPerson(int idPerson, int idNewPerson);

  /**
   * Retrieves the rows count from FaIndivTraining table for the given idPerson and cdIndivTrnType.
   *
   * @param idPerson
   * @param cdIndivTrnType
   * @return Integer
   */
  long countFaIndivTrainingByIdPersonAndCdIndivTrnType(int idPerson, String cdIndivTrnType);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.FaIndivTraining} object to the database.
   *
   * @param faIndivTraining A populated {@link gov.georgia.dhr.dfcs.sacwis.db.FaIndivTraining} object.
   */
  void saveFaIndivTraining(FaIndivTraining faIndivTraining);

  public int deleteFaIndivTraining(int idIndivTraining);
  long countFaIndivTrainingByIdPersonAndCdIndivTrnTypeAndDtIndivTrn(int idPerson, String cdIndivTrnType, Date dtIndivTrn);
}
