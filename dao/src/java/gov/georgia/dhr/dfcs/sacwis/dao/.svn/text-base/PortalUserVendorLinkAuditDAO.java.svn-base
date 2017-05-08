package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface PortalUserVendorLinkAuditDAO {
  /**
   * Update the Audit table with the Portal User ID
   * @param idPortalUserVendorLink
   * @param idPortalUser
   */
  void updatePortalUserVendorLinkAuditWithPortalUserId(int idPortalUserVendorLink, int idPortalUser);
  /**
   * Update the Audit table with the Shines User ID
   * @param idPortalUserVendorLink
   * @param idShinesUser
   */
  void updatePortalUserVendorLinkAuditWithShinesUserId(int idPortalUserVendorLink, int idShinesUser);
  /**
   * Update the Audit table with the Portal User ID
   * @param idUser
   * @param idPortalUser
   */
  void updatePortalUserVendorLinkAuditWithIdUserPortalUserId(int idUser, int idPortalUser);
  /**
   * Update the Audit table with the Shines User ID
   * @param idUser
   * @param idShinesUser
   */
  void updatePortalUserVendorLinkAuditWithIdUserShinesUserId(int idUser, int idShinesUser);
  /**
   * Get the First Update Date when the status was changed from Pending to Active.
   * @param idResource
   * @param idUser
   * @return Date
   */
  Date findFirstUpdateDateToStatusActiveByIdRsrcIdUser(int idResource, int idUser);
}
