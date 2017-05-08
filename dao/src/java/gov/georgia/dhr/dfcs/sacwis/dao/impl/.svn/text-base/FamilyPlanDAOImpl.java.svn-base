package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.db.FamilyPlan;

import gov.georgia.dhr.dfcs.sacwis.dao.FamilyPlanDAO;

public class FamilyPlanDAOImpl extends BaseDAOImpl implements FamilyPlanDAO {
  
  @SuppressWarnings({"unchecked"})
  public FamilyPlan findNextFamilyPlanReviewDate(int idStage) {

    Query query = getSession().createQuery(" from FamilyPlan fp where" +
    		                               " fp.eventByIdEvent.stage.idStage = :idStage" +
    		                               " and fp.eventByIdEvent.cdEventStatus = 'APRV'" +
    		                               " order by fp.dtNextReview desc ");
    query.setInteger("idStage", idStage);
    return (FamilyPlan) firstResult(query);
 }
}
