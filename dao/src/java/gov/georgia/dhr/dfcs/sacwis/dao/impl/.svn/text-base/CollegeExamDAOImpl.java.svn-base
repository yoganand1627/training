package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CollegeExamDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CollegeExam;

import java.util.List;

import org.hibernate.Query;

public class CollegeExamDAOImpl extends BaseDAOImpl implements CollegeExamDAO {

  @SuppressWarnings("unchecked")
  public List<CollegeExam> findAllCollegeExamsByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " from CollegeExam c " + "where c.person.idPerson = :idPerson "
                                                           + " order by c.dtExam desc");
    query.setInteger("idPerson", idPerson);
    return (List<CollegeExam>) query.list();
  }

  public CollegeExam findCollegeExamByIdCollegeExam(int idCollegeExam) {
    Query query = getSession().createQuery(" from  CollegeExam c " +
                                           " where c.idCollegeExam = :idCollegeExam ");
    query.setInteger("idCollegeExam", idCollegeExam);
    return (CollegeExam) firstResult(query);
  }
  
  public void saveCollegeExam(CollegeExam ce) {
    getSession().saveOrUpdate(ce);
  }
}
