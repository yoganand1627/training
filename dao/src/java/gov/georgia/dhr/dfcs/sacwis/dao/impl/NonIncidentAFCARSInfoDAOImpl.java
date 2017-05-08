package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.NonIncidentAFCARSInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.NonIncidentAfcarsInfo;


import org.hibernate.Query;

public class NonIncidentAFCARSInfoDAOImpl extends BaseDAOImpl implements NonIncidentAFCARSInfoDAO {

  public NonIncidentAfcarsInfo findNonIncidentAFCARSInfoByPersonID(int idPerson) {
    Query query = getSession().createQuery("from NonIncidentAfcarsInfo n " +
                                            "where n.person.idPerson=:idPerson");
    query.setInteger("idPerson", idPerson);
    return (NonIncidentAfcarsInfo) firstResult(query);
  }

  public void saveNonIncidentAFCARSInfo(NonIncidentAfcarsInfo nonIncAFCARS) {
    getSession().saveOrUpdate(nonIncAFCARS);
  }

}
