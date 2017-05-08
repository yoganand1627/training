package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ReferralPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ReferralPersonLink;
import org.hibernate.Query;

public class ReferralPersonLinkDAOImpl extends BaseDAOImpl implements ReferralPersonLinkDAO {
  public ReferralPersonLink findReferralPersonLinkByIdPerson(int idPerson) {
    Query query = getSession().createQuery("from ReferralPersonLink r " +
                                           "where r.id.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (ReferralPersonLink) firstResult(query);
  }
}
