package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexCharacteristicsDAO {
  /**
   * If adding characteristic from the Person Merge process, we need to update person at the same time.
   *
   * @param idPerson
   * @param cdCharCategory
   * @param cdCharacteristic
   * @param dtCharStart
   * @param dtCharEnd
   * @return The number of rows updated.
   */
  public int insertCharacteristicsForPersonMerge(int idPerson, String cdCharCategory, String cdCharacteristic,
                                                 Date dtCharStart, Date dtCharEnd);

  /**
   * If adding/updating from Person Detail window we need to change the update code appropriately.  If 'Aged' record
   * exists and person is not over 65 then UPDATE by end dating to uncheck. If 'Aged' is not checked and person is over
   * 65 then ADD the new record to table. And if an 'Aged' record exists and person age is over 65 then do
   * NO_ACTION.</p>
   *
   * @param idPerson
   * @param nbrPersonAge
   * @param cdCharCategory
   * @param cdCharacteristic
   * @param dtCharStart
   * @return The number of rows updated.
   */
  public int updateCharacteristicsForPerson(int idPerson, int nbrPersonAge, String cdCharCategory,
                                            String cdCharacteristic, Date dtCharStart);
}
