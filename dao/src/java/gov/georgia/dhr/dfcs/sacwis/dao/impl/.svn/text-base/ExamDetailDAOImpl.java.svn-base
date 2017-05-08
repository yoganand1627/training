package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ExamDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExamDetail;

import java.util.List;

import org.hibernate.Query;

public class ExamDetailDAOImpl extends BaseDAOImpl implements ExamDetailDAO {
  @SuppressWarnings("unchecked")
  public List<ExamDetail> findExamsByIdPersonIndGed(int idPerson, String indGed) {
    Query query = getSession().createQuery(
                                           " from ExamDetail ea " + "where ea.person.idPerson = :idPerson "
                                                           + " and ea.indGed = :indGed " + " order by ea.dtExam desc");
    query.setInteger("idPerson", idPerson);
    query.setString("indGed", indGed);
    return (List<ExamDetail>) query.list();
  }

  public void saveExamDetails(ExamDetail examDetail) {
    getSession().saveOrUpdate(examDetail);
  }

  @SuppressWarnings( { "unchecked" })
  public ExamDetail findExamDetailsOnId(int idExamDetail) {
    Query query = getSession().createQuery("   from ExamDetail a" + "    where a.idExamDetail = :idExamDetail");

    query.setInteger("idExamDetail", idExamDetail);
    return (ExamDetail) firstResult(query);
  }

}