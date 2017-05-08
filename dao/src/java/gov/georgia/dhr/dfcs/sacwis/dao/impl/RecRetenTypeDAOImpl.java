package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.RecRetenTypeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RecRetenType;
import org.hibernate.Query;

public class RecRetenTypeDAOImpl extends BaseDAOImpl implements RecRetenTypeDAO {
  public RecRetenType findRecRetenType(String cdRecRtnType) {
    Query query = getSession().createQuery(" from RecRetenType a " +
                                           "where a.cdRecRtnType = :cdRecRtnType ");
    query.setString("cdRecRtnType", cdRecRtnType);
    return (RecRetenType) firstResult(query);
  }

}
