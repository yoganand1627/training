package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;

public interface ComplexPortalUserDAO {
  /**
   * Inserts Row into Portal User table first and updates password and security
   * answers to the row. Then finally inserts the row into Portal User Vendor Link
   * table.
   * @param portalUser
   * @param portalUserVendorLink
   * @param txtSecAns1
   * @param txtSecAns2
   * @param txtSecAns3
   * @param txtPassword
   */
  void savePortalUserAndPortalUserVendorLink(PortalUser portalUser, 
                                             PortalUserVendorLink portalUserVendorLink,
                                             String txtSecAns1,
                                             String txtSecAns2, 
                                             String txtSecAns3,
                                             String txtPassword);
  /**
   * Inserts Row into Portal User table first and updates password and security
   * answers to the row. 
   * @param portalUser
   * @param txtSecAns1
   * @param txtSecAns2
   * @param txtSecAns3
   * @param txtPassword
   */
  void savePortalUserAndPortalUserVendorLink(PortalUser portalUser, 
                                             String txtSecAns1, String txtSecAns2, String txtSecAns3,
                                             String txtPassword);
}
