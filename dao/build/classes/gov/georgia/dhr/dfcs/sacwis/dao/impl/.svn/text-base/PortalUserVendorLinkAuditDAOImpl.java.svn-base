package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import org.hibernate.Query;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkAuditDAO;

public class PortalUserVendorLinkAuditDAOImpl extends BaseDAOImpl implements PortalUserVendorLinkAuditDAO {

  public void updatePortalUserVendorLinkAuditWithPortalUserId(int idPortalUserVendorLink, int idPortalUser) {
    Query query = getSession().createQuery( " update PortalUsrVendorLnkAudit puvla " +
                                            " set puvla.idPortalPersonModifiedBy = :idPortalUser " +
                                            " where puvla.idPortalUserVendorLink = :idPortalUserVendorLink " +
                                            " and puvla.tableAction = 'DELETE' ");
    query.setInteger("idPortalUserVendorLink", idPortalUserVendorLink);
    query.setInteger("idPortalUser", idPortalUser);
    query.executeUpdate();
  }

  public void updatePortalUserVendorLinkAuditWithShinesUserId(int idPortalUserVendorLink, int idShinesUser) {
    Query query = getSession().createQuery( " update PortalUsrVendorLnkAudit puvla " +
                                                  " set puvla.idShinesPersonModifiedBy = :idShinesUser " +
                                                  " where puvla.idPortalUserVendorLink = :idPortalUserVendorLink " +
                                                  " and puvla.tableAction = 'DELETE' ");
    query.setInteger("idPortalUserVendorLink", idPortalUserVendorLink);
    query.setInteger("idShinesUser", idShinesUser);
    query.executeUpdate();
  }
  public void updatePortalUserVendorLinkAuditWithIdUserPortalUserId(int idUser, int idPortalUser){
    Query query = getSession().createQuery( " update PortalUsrVendorLnkAudit puvla " +
                                            " set puvla.idPortalPersonModifiedBy = :idPortalUser " +
                                            " where puvla.idUser = :idUser " +
                                            " and puvla.tableAction = 'DELETE' "); 
    query.setInteger("idUser", idUser);
    query.setInteger("idPortalUser", idPortalUser);
    query.executeUpdate();   
  }
  
  public void updatePortalUserVendorLinkAuditWithIdUserShinesUserId(int idUser, int idShinesUser){
    Query query = getSession().createQuery( " update PortalUsrVendorLnkAudit puvla " +
                                            " set puvla.idShinesPersonModifiedBy = :idShinesUser " +
                                            " where puvla.idUser = :idUser " +
                                            " and puvla.tableAction = 'DELETE' ");    
    query.setInteger("idUser", idUser);
    query.setInteger("idShinesUser", idShinesUser);
    query.executeUpdate();    
  }
  
  public Date findFirstUpdateDateToStatusActiveByIdRsrcIdUser(int idResource, int idUser){
    Query query = getSession().createQuery( " select min(puvla.dtLastUpdate) from PortalUsrVendorLnkAudit puvla " +
                                            " where puvla.idResource = :idResource " +
                                            " and puvla.idUser = :idUser " +
                                            " and puvla.cdStatus = 'ACT' " +
                                            " and puvla.dtEnd is null ");    
    query.setInteger("idUser", idUser);
    query.setInteger("idResource", idResource);
    return (Date)firstResult(query);
  }
}
