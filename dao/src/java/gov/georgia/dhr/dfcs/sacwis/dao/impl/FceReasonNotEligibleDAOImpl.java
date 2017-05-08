package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.FceReasonNotEligibleDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FceReasonNotEligible;

public class FceReasonNotEligibleDAOImpl extends BaseDAOImpl implements FceReasonNotEligibleDAO {

  @SuppressWarnings({"unchecked"})
  public List<String> findFceReasonsNotEligible (int idFceEligibility) {
    Query query = getSession().createQuery("select cdReasonNotEligible from  FceReasonNotEligible " +
                                           "where fceEligibility.idFceEligibility = :idFceEligibility " +
                                           "order by cdReasonNotEligible ");
    
    query.setInteger("idFceEligibility", idFceEligibility);
    return (List<String>) query.list();
  }
  
  public void saveFceReasonNotEligible(FceReasonNotEligible fceReasonNotEligible){
    getSession().saveOrUpdate(fceReasonNotEligible);
  }
}
