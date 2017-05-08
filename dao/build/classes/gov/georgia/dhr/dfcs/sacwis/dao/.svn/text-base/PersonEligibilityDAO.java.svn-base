/**
 * Created on Mar 25, 2006 at 3:13:36 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibility;

public interface PersonEligibilityDAO {
  /**
   * Retrieves DHS eligibility for the Person Closed given idPersEligPerson <p/>
   *
   * @param idPersEligPerson
   * @return PersonEligibility
   */
  List<PersonEligibility> findPersonEligibilityForPersonClosed(int idPersEligPerson);

  /**
   * Searches for all open stages associated with a principal. <p/>
   *
   * @param idPersEligPerson
   * @return PersonEligibility
   */
  @SuppressWarnings({"unchecked"})
  PersonEligibility findPersonEligibilityOpenStages(int idPersEligPerson);

  /**
   * Returns a count of PersonEligibility records associated with idPersEligPerson and cdPersEligType <p/>
   *
   * @param idPersEligPerson
   * @param cdPersEligType
   * @param dtPersEligStart
   * @param dtPersEligEnd
   * @return Integer
   */
  long countPersonEligibilityByIdAndType(int idPersEligPerson, String cdPersEligType, Date dtPersEligStart,
                                         Date dtPersEligEnd);

  /**
   * Retrieves a row from PersonEligibility table for the given Person ID and for the EligType 'EA'
   *
   * @param idPersonEligPerson
   * @return PersonEligibility
   */
  PersonEligibility findPersonEligibilityByIdPersonAndEligType(int idPersonEligPerson);

  /**
   * This gets a count of PersonEligibility
   * <p/>
   *
   * @param idPersEligPerson
   * @return Integer
   */
  long countPersonEligibilityByIdPersEligPersonAndSysDate(int idPersEligPerson);

  /**
   * Update cdPersEligPrgOpen for a specified idPersElig
   *
   * @param idPersElig
   * @param cdPersEligPrgOpen
   * @return number of rows updated
   */
  int updateCdPersEligPrgOpenByIdPersElig(int idPersElig, String cdPersEligPrgOpen);

  /**
   * Update cdPersEligPrgOpen and cdPersEligPrgClose for a specified idPersElig
   *
   * @param idPersElig
   * @param cdPersEligPrgOpen
   * @param cdPersEligPrgClose
   * @return number of rows updated
   */
  int updateCdPersEligPrgOpenCloseByIdPersElig(int idPersElig, String cdPersEligPrgOpen,
                                               String cdPersEligPrgClose);

  /**
   * Update cdPersEligPrgOpen and cdPersEligPrgClose for a specified idPersElig
   *
   * @param idPersElig
   * @param dtDtPersEligEaDeny
   * @param cdPersEligPrgClose
   * @return number of rows updated
   */
  int updateDtEligDenyAndCdPersEligPrgCloseByIdPersElig(int idPersElig, Date dtDtPersEligEaDeny,
                                                        String cdPersEligPrgClose);

  /**
   * Update cdPersEligPrgOpen, cdPersEligPrgOpen and cdPersEligPrgClose for a specified idPersElig
   *
   * @param idPersElig
   * @param dtDtPersEligEaDeny
   * @param cdPersEligPrgOpen
   * @param cdPersEligPrgClose
   * @return number of rows updated
   */
  int updateDtEligDenyAndCdPersEligPrgOpenCloseByIdPersElig(int idPersElig, Date dtDtPersEligEaDeny,
                                                            String cdPersEligPrgOpen,
                                                            String cdPersEligPrgClose);

  /**
   * Update eligibility type, dates and info for a specified idPersElig
   *
   * @param idPersElig
   * @param cdPersEligType
   * @param dtPersEligStart
   * @param dtPersEligEnd
   * @param dtPersEligEaDeny
   * @param cdPersEligPrgStart
   * @param cdPersEligPrgOpen
   * @return number of rows updated
   */
  int updateCdPersEligTypeAndEligDatesByIdPersElig(int idPersElig, String cdPersEligType,
                                                   Date dtPersEligStart, Date dtPersEligEnd,
                                                   Date dtPersEligEaDeny, String cdPersEligPrgStart,
                                                   String cdPersEligPrgOpen);

  /**
   * Insert a new PersonEligibility row
   *
   * @param idPerson
   * @param cdPersEligType
   * @param dtPersEligStart
   * @param dtPersEligEnd
   * @param dtPersEligEaDeny
   * @param cdPersEligPrgStart
   * @param cdPersEligPrgOpen
   * @return number of rows affected
   */
  int insertPersonEligibility(int idPerson, String cdPersEligType,
                              Date dtPersEligStart, Date dtPersEligEnd,
                              Date dtPersEligEaDeny, String cdPersEligPrgStart,
                              String cdPersEligPrgOpen);

  /**
   * Insert a new PersonEligibility row
   *
   * @param dtPersEligStart
   * @param daysToSubtract
   * @param dtMaxDate
   * @param idPerson
   * @return number of rows affected
   */
  int insertPersonEligibility(Date dtPersEligStart, int daysToSubtract, int idPerson);

  /**
   * Insert a new PersonEligibility row
   *
   * @param dtPersEligStart
   * @param dtPersEligEnd
   * @param dtDtPersEligEaDeny
   * @param cdPersEligPrgStart
   * @param cdPersEligPrgOpen
   * @param idPerson
   * @return number of rows affected
   */
  int insertPersonEligibility(Date dtPersEligStart, Date dtPersEligEnd, Date dtDtPersEligEaDeny,
                              String cdPersEligPrgStart, String cdPersEligPrgOpen, int idPerson);
}
