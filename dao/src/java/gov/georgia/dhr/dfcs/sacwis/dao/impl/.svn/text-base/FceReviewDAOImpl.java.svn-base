package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;

public class FceReviewDAOImpl extends BaseDAOImpl implements FceReviewDAO{

  public FceReview findFceReviewByIdReviewEvent(long idReviewEvent) {
    Query query = getSession().createQuery(" from FceReview fr " +
                                           "where fr.eventByIdEvent.idEvent = :idReviewEvent");

    query.setLong("idReviewEvent", idReviewEvent);
    return (FceReview) query.uniqueResult();
  }
  
  public FceReview findFceReviewByIdFceReview(long idFceReview) {
    Query query = getSession().createQuery("      from FceReview fr " +
                                           "join fetch fr.stage " +
                                           "join fetch fr.fceEligibility " +
                                           "join fetch fr.eventByIdEvent " +
                                           "join fetch fr.fceApplication " +
                                           "join fetch fr.capsCase " +
                                           "     where fr.idFceReview = :idFceReview");
    query.setLong("idFceReview", idFceReview);
    return (FceReview) query.uniqueResult();
  }	
  
  public void saveFceReview(FceReview fceReview) {
    getSession().saveOrUpdate(fceReview);
  }
  public FceReview findFceReviewByIdEvent(int idEvent) {
    Query query = getSession().createQuery("  from FceReview fcr " +
                                           "join fetch fcr.fceEligibility " +
                                           "join fetch fcr.fceApplication " +
                                           "join fetch fcr.fceApplication.fceEligibility " +
                                           "where fcr.eventByIdEvent.idEvent = :idEvent ");
                    query.setInteger("idEvent", idEvent);
                    return (FceReview) firstResult(query);
    }
  
  public int updateFceReviewByCdLivingConditionCurrent(long idFceReview, String cdLivingConditionCurrent) {

    Query query = getSession().createQuery(" update FceReview " +
                                           "    set cdLivingConditionCurrent = :cdLivingConditionCurrent" +
                                           "  where idFceReview = :idFceReview");

    query.setString("cdLivingConditionCurrent", cdLivingConditionCurrent);
    query.setLong("idFceReview", idFceReview);
    return query.executeUpdate();
  }
  
  public FceReview findFceReviewByIdEventAndDtReviewComplete(int idEvent) {
    Query query = getSession().createQuery(" from FceReview fcr " +
                                           " where fcr.eventByIdEvent.idEvent = :idEvent " +
                                           "    and fcr.dtReviewComplete is not null " +
                                           "order by fcr.dtReviewComplete desc, fcr.dtLastUpdate desc ");
    query.setInteger("idEvent", idEvent);
    return (FceReview) firstResult(query);
  }
}
