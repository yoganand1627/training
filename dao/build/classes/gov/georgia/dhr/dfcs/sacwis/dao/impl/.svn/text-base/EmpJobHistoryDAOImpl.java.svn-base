package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpJobHistory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class EmpJobHistoryDAOImpl extends BaseDAOImpl implements EmpJobHistoryDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findEmpJobHistoryByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select new map(a.cdJobBjn as cdJobBjn, " +
                                           "               a.cdJobClass as cdJobClass, " +
                                           "               a.cdJobFunction as cdJobFunction, " +
                                           "               a.dtJobEnd as dtJobEnd, " +
                                           "               a.dtJobStart as dtJobStart, " +
                                           "               a.idEmpJobHistory as idEmpJobHistory, " +
                                           "               a.personByIdPerson.idPerson as personByIdPerson, " +
                                           "               a.personByIdJobPersSupv.idPerson as personByIdJobPersSupv, " +
                                           "               a.personByIdJobPersSupv.nmPersonFull as nmPersonFull, " +
                                           "               a.indJobAssignable as indJobAssignable, " +
                                           "               a.dtLastUpdate as dtLastUpdate) " +
                                           "      from EmpJobHistory a " +
                                           "     where a.personByIdPerson.idPerson = :idPerson " +
                                           "  order by a.dtJobEnd desc, " +
    "           a.dtJobStart desc ");
    query.setInteger("idPerson", idPerson);
    return (List<Map>) query.list();
  }

  public Map findEmpJobDescriptionByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select new map(a.cdJobBjn as cdJobBjn, " +
                                           "               a.cdJobClass as cdJobClass, " +
                                           "               a.cdJobTitle as cdJobTitle, " +
                                           "               a.idEmpJobHistory as idEmpJobHistory, " +
                                           "               a.personByIdPerson.idPerson as personByIdPerson, " +
                                           "               a.personByIdJobPersSupv.idPerson as personByIdJobPersSupv, " +
                                           "               a.indJobAssignable as indJobAssignable, " +
                                           "               a.dtLastUpdate as dtLastUpdate) " +
                                           "  from EmpJobHistory a " +
                                           " where a.idEmpJobHistory = ( " +
                                           "       select min(ejh.idEmpJobHistory) " +
                                           "         from EmpJobHistory ejh " +
                                           "        where ejh.personByIdPerson.idPerson = :idPerson)");
    query.setInteger("idPerson", idPerson);
    return (Map) query.uniqueResult();
  }
  
  public EmpJobHistory findSoleEJHByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from EmpJobHistory ejh " +
                                           "where ejh.idEmpJobHistory = ( " +
                                           "  select min(ej.idEmpJobHistory) " +
                                           "    from EmpJobHistory ej " +
                                           "   where ej.personByIdPerson.idPerson = :idPerson)");
    query.setInteger("idPerson", idPerson);
    return (EmpJobHistory) query.uniqueResult();
  }
  
  public int insertEmpJobDescription(int seqEmpJobHistoryNextVal, int idPerson, int idJobPersSupv, String cdJobClass, String indJobAssignable, String bjnJob, String cdJobTitle) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO EMP_JOB_HISTORY (ID_EMP_JOB_HISTORY, " +
                                                 "                             ID_PERSON, " +
                                                 "                             ID_JOB_PERS_SUPV, " +
                                                 "                             CD_JOB_CLASS, " +
                                                 "                             IND_JOB_ASSIGNABLE, " +
                                                 "                             CD_JOB_BJN, " +
                                                 "                             CD_JOB_TITLE) " +
                                                 "     VALUES (:seqEmpJobHistoryNextVal, " +
                                                 "             :idPerson, " +
                                                 "             :idJobPersSupv, " +
                                                 "             :cdJobClass, " +
                                                 "             :indJobAssignable, " +
                                                 "             :bjnJob, " +
                                                 "             :cdJobTitle)" );

    query.setInteger("seqEmpJobHistoryNextVal", seqEmpJobHistoryNextVal);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idJobPersSupv", idJobPersSupv);
    query.setString("cdJobClass", cdJobClass);
    query.setString("indJobAssignable", indJobAssignable);
    query.setString("bjnJob", bjnJob);
    query.setString("cdJobTitle", cdJobTitle);
    return query.executeUpdate();
  }
  
  public int updateEmpJobDescription(int idEmpJobHistory, int idPerson, int idJobPersSupv, String cdJobClass,
                                     String indJobAssignable, String cdJobBjn, Date dtLastUpdate, String cdJobTitle) {
        Query query = getSession().createQuery("update EmpJobHistory " +
                                               "   set personByIdPerson.idPerson = :idPerson, " +
                                               "       personByIdJobPersSupv.idPerson = :idJobPersSupv, " +
                                               "       cdJobClass = :cdJobClass, " +
                                               "       indJobAssignable = :indJobAssignable, " +
                                               "       cdJobBjn = :cdJobBjn, " +
                                               "       cdJobTitle = :cdJobTitle " +
                                               "   where idEmpJobHistory = :idEmpJobHistory " );
        query.setInteger("idEmpJobHistory", idEmpJobHistory);
        query.setInteger("idPerson", idPerson);
        query.setInteger("idJobPersSupv", idJobPersSupv);
        query.setString("cdJobClass", cdJobClass);
        query.setString("indJobAssignable", indJobAssignable);
        query.setString("cdJobBjn", cdJobBjn);
        query.setString("cdJobTitle", cdJobTitle);
        return query.executeUpdate();
      }
  
  public void saveEmpJobHistory(EmpJobHistory empJobHistory) {
    getSession().saveOrUpdate(empJobHistory);
  }
  
  public void flushEmpJobHistory(){
    getSession().flush();
  }
  
  public void deleteEmpJobDescription(EmpJobHistory empJobHistory) {
    getSession().delete(empJobHistory);
  }

  //query for job title
  public String findEmpJobTitle(int idPerson){
    Query query = getSession().createQuery("select ejh.cdJobClass " +
                                           " from EmpJobHistory ejh " +
                                           " where ejh.personByIdPerson=:idPerson " +
                                           " and ejh.dtLastUpdate=(select max(e.dtLastUpdate) " +
                                           " from EmpJobHistory e" +
                                           " where e.personByIdPerson=:idPerson)" );
    query.setInteger("idPerson", idPerson); 
   return (String) firstResult(query); 
  }
}
