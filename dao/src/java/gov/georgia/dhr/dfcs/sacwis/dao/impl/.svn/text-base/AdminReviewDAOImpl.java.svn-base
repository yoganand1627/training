package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;

import java.util.List;

import org.hibernate.Query;

/**
 * 
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  --------    --------  --------------------------------------------------
 *  09/24/2008  arege     Modified methods and method names for  findAdminReviewByIdStageIdPersonDtMaxDate()
 *                        ,findAdminReviewByIdStageDtMaxDate to findAdminReviewByIdStageIdPerson() 
 *                        , findAdminReviewByIdStageDtStageClose() respectively. Now, the code in CloseOpenStageImpl
 *                        does not enter a MAX_JAVA_DATE in the Dt_Stage_Close field of Stage table when creating
 *                        New 'ARI' stage.
 *  
 *  
 **/


public class AdminReviewDAOImpl extends BaseDAOImpl implements AdminReviewDAO {
  public Integer findAdminReviewByIdStageIdPerson(int idStage, int idPerson) {
    Query query = getSession().createQuery(" select a.stage.idStage " +
                                           "   from AdminReview a," +
                                           "        Stage s" +
                                           "  where a.person.idPerson = :idPerson " +
                                           "    and a.stageByIdStageRelated.idStage = :idStage " +
                                           "    and s.idStage = a.stage.idStage " +
                                           "    and s.dtStageClose is null ");
    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  public Integer findAdminReviewByIdStageDtStageClose(int idStage) {

    Query query = getSession().createQuery("select a.stage.idStage " +
                                           "  from AdminReview a," +
                                           "  Stage s " +
                                           " where a.stageByIdStageRelated.idStage = :idStage " +
                                           "   and s.idStage = a.stage.idStage " +
                                           "   and s.dtStageClose is null ");
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public AdminReview findAdminReviewByIdStage(int idStage) {
    Query query = getSession().createQuery(" from AdminReview  a " +
                                           "where a.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (AdminReview) firstResult(query);
  }

  public AdminReview findAdminReviewByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from AdminReview  a " +
                                           "where a.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (AdminReview) firstResult(query);
  }

  public List<AdminReview> retrievePrior1lvlAdminReviews(int idCase, int idPerson) {
    Query query = getSession().createQuery(
                 " from AdminReview a where " +
                 " a.indLevel = '1' and a.event.cdEventStatus = 'APRV' " +
                 " and a.person.idPerson = :idPerson and a.capsCase.idCase =:idCase ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    return (List<AdminReview>) query.list();
  }
  
  public long countAdminReviewByIdStage(int idStage) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from AdminReview  a " +
                                           " where a.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (Long) query.uniqueResult();

  }

  public void saveAdminReview(AdminReview adminReview) {
    getSession().saveOrUpdate(adminReview);
  }
}
