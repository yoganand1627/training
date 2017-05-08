/**
 * Created on Mar 25, 2006 at 2:30:57 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.EmpJobHistory;

public interface EmpJobHistoryDAO {
  /**
   * This obtains a full row from the EMP_JOB_HISTORY table, plus NM PERSON FULL of the supervisor from the PERSON
   * table, of the employee indicated by the ID PERSON the DAM receives.
   *
   * @param idPerson return keys cdJobBjn, cdJobClass, cdJobFunction, dtJobEnd, dtJobStart, idEmpJobHistory,
   *                 personByIdPerson, personByIdJobPersSupv, nmPersonFull, indJobAssignable, dtLastUpdate
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findEmpJobHistoryByIdPerson(int idPerson);

  /**
   * Finds the job description of an employee given the id. If multiple
   * records exist, the one with the lowest primary key value is returned.
   *
   * @param idPerson int
   * @return list of map objects
   */
  Map findEmpJobDescriptionByIdPerson(int idPerson);
  
  /**
   * Returns the one and only relevant EmpJobHistory record for the given idPerson. If
   * multiple records exist, the one with the lowest primary key value is returned.
   * 
   * @param idPerson
   * @return
   */
  EmpJobHistory findSoleEJHByIdPerson(int idPerson);

  /**
   * Inserts the required fields into the emp_job_history table
   *
   * @param seqEmpJobDescriptionNextVal
   * @param idPerson
   * @param idJobPersSupv
   * @param cdJobTitle
   * @param indCaseAssignable
   * @param textErsNumber
   * @return
   */
  int insertEmpJobDescription(int seqEmpJobHistoryNextVal, int idPerson, int idJobPersSupv, String cdJobClass,
                              String indJobAssignable, String bjnJob, String cdJobTitle);

  /**
   * Updates the employee's job description
   *
   * @param idEmpJobHistory
   * @param idPerson
   * @param idJobPersSupv
   * @param cdJobTitle
   * @param indCaseAssignable
   * @param textErsNumber
   * @param dtLastUpdate
   * @return
   */
  int updateEmpJobDescription(int idEmpJobHistory, int idPerson, int idJobPersSupv, String cdJobClass,
                              String indJobAssignable, String cdJobBjn, Date dtLastUpdate, String cdJobTitle);
  
  /**
   * Saves the {@link gov.georgia.dhr.dfcs.sacwis.db.EmpJobHistory} object to the database.
   * 
   * @param empJobHistory
   */
  void saveEmpJobHistory(EmpJobHistory empJobHistory);

  public void flushEmpJobHistory();
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.EmpJobHistory} object.
   *
   * @param empJobHistory
   */
  void deleteEmpJobDescription(EmpJobHistory empJobHistory);

  /**
   * This obtains the Job History Title from the EMP_JOB_HISTORY table
   *
   * @param idPerson return keys dtJobEnd, cdJobTitle
   * @return Map
   *                 
   */
  @SuppressWarnings({"unchecked"})
   public String findEmpJobTitle(int idPerson);
  
}
