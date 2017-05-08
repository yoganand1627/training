package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserAuditDAO;

public class PortalUserAuditDAOImpl extends BaseDAOImpl implements PortalUserAuditDAO {

  public void updatePortalUserAuditWithPortalUserId(int idUser, int idPortalUser) {
    Query query = getSession().createQuery( " update PortalUserAudit pua " +
                                            " set pua.idPortalPersonModifiedBy = :idPortalUser " +
                                            " where pua.idUser = :idUser " +
                                            " and pua.tableAction = 'DELETE' ");
    query.setInteger("idUser", idUser);
    query.setInteger("idPortalUser", idPortalUser);
    query.executeUpdate();
  }
  public void updatePortalUserAuditWithShinesUserId(int idUser, int idShinesUser) {
    Query query = getSession().createQuery( " update PortalUserAudit pua " +
                                            " set pua.idShinesPersonModifiedBy = :idShinesUser " +
                                            " where pua.idUser = :idUser " +
                                            " and pua.tableAction = 'DELETE' ");
    query.setInteger("idUser", idUser);
    query.setInteger("idShinesUser", idShinesUser);
    query.executeUpdate();
  }
}
