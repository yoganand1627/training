package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.PortalSecurityClassDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalSecurityClass;

public class PortalSecurityClassDAOImpl extends BaseDAOImpl implements PortalSecurityClassDAO {

  public PortalSecurityClass findPortalSecurityClassByClassName(String className) {
    Query query = getSession().createQuery(
                                           " from PortalSecurityClass psc "
                                         + " where psc.cdSecurityClassName = :className ");
    query.setString("className", className);
    return (PortalSecurityClass) firstResult(query);
  }

}
