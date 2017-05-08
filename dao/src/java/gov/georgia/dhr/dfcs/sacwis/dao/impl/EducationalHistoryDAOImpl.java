package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.EducationalHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EducationalHistory;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

public class EducationalHistoryDAOImpl extends BaseDAOImpl implements EducationalHistoryDAO {
  //changed for STGAP00006597 - enrollment date can be null, so order by id (the time it was entered). 
  //not a perfect answer, but more reliable than enrollment date.
  //this query is used on FCCP form, CPRS interface, and Youth Report detail 
  public EducationalHistory findEducationalHistory(int idPerson) {
    Query query = getSession().createQuery("    from EducationalHistory e " +
                                           "   where e.person.idPerson = :idPerson " +
                                           "order by e.idEdhist desc ");
    query.setInteger("idPerson", idPerson);
    return (EducationalHistory) firstResult(query);
  }

  public String findSchoolNameByIdPersonCdEnrollGrade(int idPerson, Collection<String> enrollGrades) {
    Query query = getSession().createQuery(" select e.nmEdhistSchool from EducationalHistory e " +
                                           "   where e.person.idPerson = :idPerson " +
                                           "     and e.cdEdhistEnrollGrade in (:enrollGrades) " +
                                           "order by e.dtEdhistEnrollDate desc ");
    query.setInteger("idPerson", idPerson);
    query.setParameterList("enrollGrades", enrollGrades);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  //changed for STGAP00006597 - enrollment date can be null, so order by id (the time it was entered). 
  //not a perfect answer, but more reliable than enrollment date.
  //this query is used for the education submodule list on person detail
  public List<EducationalHistory> findEducationalHistoryByIdPerson(int idPerson) {
    Query query = getSession().createQuery("    from EducationalHistory e " +
                                           "   where e.person.idPerson = :idPerson " +
                                           "order by e.idEdhist desc");

    query.setInteger("idPerson", idPerson);
    return (List<EducationalHistory>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<EducationalHistory> findEnrollmentsByIdPersonAndDate(int idPerson, Date dtEffective) {
    Query query = getSession().createQuery("    from EducationalHistory e " +
                                           "   where e.person.idPerson = :idPerson " +
                                           "     and e.dtEdhistEnrollDate <= :dtEffective " +
                                           "     and (e.dtEdhistWithdrawnDate is null " +
                                           "          or e.dtEdhistWithdrawnDate > :dtEffective) " +
                                           "order by e.dtEdhistEnrollDate desc");
    query.setInteger("idPerson", idPerson);
    query.setDate("dtEffective", dtEffective);
    return (List<EducationalHistory>) query.list();
  }

  public void saveEducationalHistory(EducationalHistory educationalHistory) {
    getSession().saveOrUpdate(educationalHistory);
  }

  public String findEducationalHistoryHighestGrade(int idPerson) {
    Query query = getSession().createSQLQuery(" select GREATEST(NVL(max(e.cd_curr_grade),'0'), NVL(max(e.cd_edhist_withdrawn_grade),'0')) " +
    		                           "   from Educational_History e " +
                                           "   where e.id_person = :idPerson " +
                                           "   and (e.cd_curr_grade is not null " +
                                           "   or e.cd_edhist_withdrawn_grade is not null) ");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

}
