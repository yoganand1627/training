package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;

public class ComplexPortalUserDAOImpl extends BaseDAOImpl implements ComplexPortalUserDAO {
  PortalUserDAO portalUserDAO;
  PortalUserVendorLinkDAO portalUserVendorLinkDAO;
  
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }

  public void setPortalUserVendorLinkDAO(PortalUserVendorLinkDAO portalUserVendorLinkDAO) {
    this.portalUserVendorLinkDAO = portalUserVendorLinkDAO;
  }

  public void savePortalUserAndPortalUserVendorLink(PortalUser portalUser, PortalUserVendorLink portalUserVendorLink,
                                                    String txtSecAns1, String txtSecAns2, String txtSecAns3,
                                                    String txtPassword) {
    Session session = getSession();
    //Save Portal User and Portal User Vendor Link using the same session
    Integer portalUserId = portalUserDAO.saveNewPortalUser(session, portalUser, txtSecAns1, txtSecAns2, txtSecAns3, txtPassword);
    PortalUser newPortalUser = portalUserDAO.findPortalUserbyIdUserSession(session, portalUserId);
    portalUserVendorLink.setPortalUser(newPortalUser);
    portalUserVendorLinkDAO.saveNewPortalUserVendorLink(session, portalUserVendorLink);
  }
  public void savePortalUserAndPortalUserVendorLink(PortalUser portalUser, 
                                                    String txtSecAns1, String txtSecAns2, String txtSecAns3,
                                                    String txtPassword) {
    Session session = getSession();
    //Save Portal User using the session created here
    portalUserDAO.saveNewPortalUser(session, portalUser, txtSecAns1, txtSecAns2, txtSecAns3, txtPassword);
  }
}
