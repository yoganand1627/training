package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.EmergencyAssistDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmergencyAssist;
import org.hibernate.Query;

public class EmergencyAssistDAOImpl extends BaseDAOImpl implements EmergencyAssistDAO {
  @SuppressWarnings({"unchecked"})
  public List<EmergencyAssist> findEmergencyAssistByIdEvent(int idEvent) {
    Query query = getSession().createQuery("     from EmergencyAssist e " +
                                           "    where e.event.idEvent=:idEvent " +
                                           " order by e.cdEaQuestion asc ");
    query.setInteger("idEvent", idEvent);
    return (List<EmergencyAssist>) query.list();
  }

  public void saveEmergencyAssist(EmergencyAssist emergencyAssist) {
    getSession().saveOrUpdate(emergencyAssist);
  }
}
