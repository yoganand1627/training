package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.PortalLoginAuditDAO;

public class PortalLoginAuditDAOImpl extends BaseDAOImpl implements PortalLoginAuditDAO {

  public Date findLastDtUserLoggedInByIdUser(int idUser) {
    Query query = getSession().createQuery( " select max(pla.dtUserAction) " +
                                            " from PortalLoginAudit pla " +
                                            " where pla.portalUser.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    return (Date)firstResult(query);
  }

}
