package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.SaReasonableEffortsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SaReasonableEfforts;
import java.util.List;
import org.hibernate.Query;


public class SaReasonableEffortsDAOImpl extends BaseDAOImpl implements SaReasonableEffortsDAO {

  @SuppressWarnings({"unchecked"})
  public List<SaReasonableEfforts> findReasonableEffortsByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from SaReasonableEfforts sre" +
                                           "  where sre.saSafetyAssessment.idEvent = :idEvent");

    query.setInteger("idEvent", idEvent);
    return (List<SaReasonableEfforts>) query.list();
  }
    
  public void saveOrUpdateReasonableEfforts(SaReasonableEfforts sar){
    getSession().saveOrUpdate(sar);
  }
  
  public int deleteReasonableEfforts(int idEvent) {
    Query query = getSession().createQuery("delete from SaReasonableEfforts sf " +
                                           "       where sf.saSafetyAssessment.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}

