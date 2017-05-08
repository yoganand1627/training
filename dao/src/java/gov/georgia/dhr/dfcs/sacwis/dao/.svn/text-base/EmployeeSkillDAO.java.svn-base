/**
 * Created on Mar 25, 2006 at 2:29:54 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.EmployeeSkill;

public interface EmployeeSkillDAO {
  /**
   * Retrieves all rows with just the column cdEmpSkill from EmployeeSkill table, for a given a Person Id.
   *
   * @param idPerson
   * @return @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.EmployeeSkill} objects.
   */
  @SuppressWarnings({"unchecked"})
  List<EmployeeSkill> findCdEmpSkillFromEmployeeSkillByIdPerson(int idPerson);

  /**
   * Inserts into EmployeeSkill table
   *
   * @param idPerson
   * @param cdEmpSkill
   * @return
   */
  int insertEmployeeSkill(int idPerson, String cdEmpSkill);

  /**
   * Delete rows from EmployeeSkill based on ID_PERSON and CD_EMP_SKILL.
   *
   * @param idPerson
   * @param cdEmpSkill
   * @return Integer
   */
  int deleteEmployeeSkillByIdPersonAndCdEmpSkill(int idPerson, String cdEmpSkill);
}
