package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SaSafetyFactorDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SaSafetyFactor;
import java.util.List;
import org.hibernate.Query;


public class SaSafetyFactorDAOImpl extends BaseDAOImpl implements SaSafetyFactorDAO {

  @SuppressWarnings({"unchecked"})
  public List<SaSafetyFactor> findSafetyFactorsByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from SaSafetyFactor sf" +
                                           "  where sf.saSafetyAssessment.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (List<SaSafetyFactor>) query.list();
  }
  
  public void saveOrUpdateSafetyFactor(SaSafetyFactor safetyFactors){
    getSession().saveOrUpdate(safetyFactors);
  }
  
  public int deleteSafetyFactor(int idEvent) {
    Query query = getSession().createQuery("delete from SaSafetyFactor sf " +
                                           "       where sf.saSafetyAssessment.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}
