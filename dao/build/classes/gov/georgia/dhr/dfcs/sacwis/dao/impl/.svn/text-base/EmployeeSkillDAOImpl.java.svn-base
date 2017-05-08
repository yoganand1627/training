package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeSkillDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmployeeSkill;
import org.hibernate.Query;

public class EmployeeSkillDAOImpl extends BaseDAOImpl implements EmployeeSkillDAO {
  @SuppressWarnings({"unchecked"})
  public List<EmployeeSkill> findCdEmpSkillFromEmployeeSkillByIdPerson(int idPerson) {
    Query query = getSession().createQuery("    from EmployeeSkill " +
                                           "   where person.idPerson  = :idPerson " +
                                           "order by cdEmpSkill ");
    query.setInteger("idPerson", idPerson);
    return (List<EmployeeSkill>) query.list();
  }

  public int insertEmployeeSkill(int idPerson, String cdEmpSkill) {
    Query query = getSession().createSQLQuery(" insert into EMPLOYEE_SKILL " +
                                              "             (ID_EMPLOYEE_SKILL, " +
                                              "              ID_PERSON, " +
                                              "              CD_EMP_SKILL ) " +
                                              "      values (SEQ_EMPLOYEE_SKILL.nextval, " +
                                              "              :idPerson, " +
                                              "              :cdEmpSkill)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdEmpSkill", cdEmpSkill);
    return query.executeUpdate();
  }

  public int deleteEmployeeSkillByIdPersonAndCdEmpSkill(int idPerson, String cdEmpSkill) {
    Query query = getSession().createQuery("delete EmployeeSkill " +
                                           " where person.idPerson = :idPerson " +
                                           "   and cdEmpSkill = :cdEmpSkill");
    query.setInteger("idPerson", idPerson);
    query.setString("cdEmpSkill", cdEmpSkill);
    return query.executeUpdate();
  }
}
