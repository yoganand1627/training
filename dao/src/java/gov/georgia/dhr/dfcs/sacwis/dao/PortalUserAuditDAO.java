package gov.georgia.dhr.dfcs.sacwis.dao;

public interface PortalUserAuditDAO {
  void updatePortalUserAuditWithPortalUserId(int idUser, int idPortalUser);
  
  void updatePortalUserAuditWithShinesUserId(int idUser, int idShinesUser);
}
