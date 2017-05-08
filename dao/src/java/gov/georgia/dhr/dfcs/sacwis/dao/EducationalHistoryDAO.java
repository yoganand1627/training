/**
 * Created on Mar 25, 2006 at 2:32:13 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;

public interface EducationalHistoryDAO {
  /**
   * This selects a row from EducationalHistory.
   *
   * @param idPerson
   * @return EducationalHistory
   */
  EducationalHistory findEducationalHistory(int idPerson);

  String findSchoolNameByIdPersonCdEnrollGrade(int idPerson, Collection<String> enrollGrades);

  /**
   * Retrieves rows from EducationalHistory given the idPerson.
   *
   * @param idPerson
   * @return List of {@link gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory} objects for a given idPerson
   */
  @SuppressWarnings({"unchecked"})
  List<EducationalHistory> findEducationalHistoryByIdPerson(int idPerson);
  
  /**
   * Use this method to find all EducationalHistory records for idPerson where the person was enrolled
   * according to the dtEffective given. Pass the current date to retrieve all current enrollments for
   * the person.
   * 
   * @param idPerson
   * @param dtEffective
   * @return
   */
  List<EducationalHistory> findEnrollmentsByIdPersonAndDate(int idPerson, Date dtEffective);

  /**
   * This is an  update/insert for EducationalHistory info.
   *
   * @param educationalHistory
   */

  void saveEducationalHistory(EducationalHistory educationalHistory);

  /**
   * Find highest current grade recorded for idPerson
   * 
   * @param idPerson
   * @return String - code for CSCHGRAD
   */
  String findEducationalHistoryHighestGrade(int idPerson);
}
