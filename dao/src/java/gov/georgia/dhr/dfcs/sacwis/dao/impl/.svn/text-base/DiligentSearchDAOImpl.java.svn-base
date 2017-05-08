package gov.georgia.dhr.dfcs.sacwis.dao.impl;


import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.dao.DiligentSearchDAO;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;
import org.hibernate.Query;

public class DiligentSearchDAOImpl extends BaseDAOImpl implements DiligentSearchDAO {

  public void saveDiligentSearchInfo(DiligentSearch diligentSearch) {
    getSession().saveOrUpdate(diligentSearch);
  }

  @SuppressWarnings( { "unchecked" })
  public List<DiligentSearch> findDiligentSearchInfo(int idPersonSearch) {
    Query query = getSession().createQuery(
                                           "   from DiligentSearch a"
                                                           + "    where a.personByIdPersonSearch = :idPersonSearch");

    query.setInteger("idPersonSearch", idPersonSearch);
    return (List<DiligentSearch>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<DiligentSearch> findDiligentSearchInfoBasedOnCaseId(int idCase) {
    Query query = getSession().createQuery("   from DiligentSearch a" + "    where a.capsCase = :idCase");

    query.setInteger("idCase", idCase);
    return (List<DiligentSearch>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<DiligentSearch> findDiligentSearchInfoBasedOnCaseIdByIdPersonDtl(int idCase, int idPersonSrch) {
    Query query = getSession().createQuery(" from DiligentSearch a" + 
                                           " where a.capsCase = :idCase " +
                                           " and a.personByIdPersonSearch = :idPersonSrch ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPersonSrch", idPersonSrch);
    return (List<DiligentSearch>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<DiligentSearch> findDiligentSearchInfoBasedOnCaseIdStageIdByIdPersonDtl(int idCase, int idStage, int idPersonSrch) {
    Query query = getSession().createQuery(" from DiligentSearch a" + 
                                           " where a.capsCase = :idCase " +
                                           " and a.stage = :idStage" + 
                                           " and a.personByIdPersonSearch = :idPersonSrch ");

    query.setInteger("idCase", idCase);
    query.setInteger("idStage", idStage);
    query.setInteger("idPersonSrch", idPersonSrch);
    return (List<DiligentSearch>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<DiligentSearch> findDiligentSearchInfoBasedOnCaseIdByListOfIdPersonSearch(int idCase, List<Integer> idPersonSrch) {
    Query query = getSession().createQuery(" from DiligentSearch a" + 
                                           " where a.capsCase = :idCase " +
                                           " and a.personByIdPersonSearch.idPerson in (:idPersonSrch) ");

    query.setInteger("idCase", idCase);
    query.setParameterList("idPersonSrch", idPersonSrch);
    return (List<DiligentSearch>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<DiligentSearch> findDiligentSearchInfoByCaseIdByIdpersonSeachByIdPersonDtl(int idCase, List<Integer> idPersonSrch, int idPersonDtl) {
    Query query = getSession().createQuery(" from DiligentSearch a" + 
                                           " where a.capsCase = :idCase " +
                                           " and a.personByIdPersonSearch.idPerson in (:idPersonSrch) " +
                                           " and a.personByIdPersonDetail.idPerson = :idPersonDtl" );

    query.setInteger("idCase", idCase);
    query.setParameterList("idPersonSrch", idPersonSrch);
    query.setInteger("idPersonDtl", idPersonDtl);
    return (List<DiligentSearch>) query.list();
  }

    public DiligentSearch findDiligentSearchInfoBasedOnId(int idDiligentSearch) {
    Query query = getSession().createQuery(
                                           "   from DiligentSearch a"
                                                           + "    where a.idDiligentSearch = :idDiligentSearch");

    query.setInteger("idDiligentSearch", idDiligentSearch);
    return (DiligentSearch) firstResult(query);
  }

  public long countExistingRecord(int idPersonDetail, int idPersonSearch) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from DiligentSearch a"
                                                           + " where a.personByIdPersonDetail = :idPersonDetail "
                                                           + "   and a.personByIdPersonSearch = :idPersonSearch ");

    query.setInteger("idPersonDetail", idPersonDetail);
    query.setInteger("idPersonSearch", idPersonSearch);
    return (Long) query.uniqueResult();
  }

}
