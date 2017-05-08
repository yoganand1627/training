package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;

/**
 * @author ssubram
 * 
 */
public interface PortalUserVendorLinkDAO {
  
  /**
   * This selects a list of Portal User Vendor Link Objects for the given idUser. <p/>
   * 
   * @param idUser
   * @return
   */
  List<PortalUserVendorLink> findPortalUserVendorLinkbyIdUser(int idUser);

  /**
   * This will select the number of resources to which a user had security rights on a given date shared with the list
   * of resources to which a current user has access. Used to verify security to see items added by another uesr.<p/>
   * 
   * @param idUser
   * @param dtContactDate
   * @param assignedResources
   * @return
   */
  public long findCommonPortalUserVendorLinksbyIdUserAndDate(int idUser, Date dtContactDate,
                                                             List<Integer> assignedResources);
  /**
   * This method will display the appropriate list of staff members for the given view of the 
   * vendor staff list or pending vendor staff list page.<p/>
   * 
   * @param List<Integer> idRsrcList
   * @param List<String> statuses
   * @param List<String> types
   * @param idUser
   * @param pageNbr
   * @param pageSize
   * @return PaginatedHibernateList<Map>
   */
  public PaginatedHibernateList<Map> findPortalVendorStaffList(List<Integer> idRsrcList, List<String> statuses,
                                                               List<String> types, int idUser, int pageNbr,
                                                                                 int pageSize);
  /**
   * Returns the distinct Resources that are associated with the RBWO Administrators and the status as active 
   * @return
   */
  List<Object[]> findActiveResourceListForVendorPortal();
  /**
   * Returns the distinct Resources that are associated with the RBWO Administrators and the status as active
   * for the given user id. 
   * @return
   */
  List<Object[]> findActiveResourceListForVendorPortal(int idUser);
  
  /**
   * Returns the Resources that are associated with the given User 
   * @return
   */
  List<Object[]> findResourceListForGivenUser(int idUser); 
  /**
   * Saves the Portal User Vendor Link
   * @param portalUserVendorLink
   */
  void saveNewPortalUserVendorLink(Session session, PortalUserVendorLink portalUserVendorLink);
  /**
   * Returns a unique PortalUserVendorLink object for the given IdUser and IdResource
   * @param idUser
   * @param idResource
   * @return
   */
  PortalUserVendorLink findPortalUserVendorLinkByIdUserAndIdResource(int idUser, int idResource);
  
  /**
   * Saves Portal User Vendor Link information to the DB
   * @param portalUserVendorLink
   */
  void savePortalUserVendorLink(PortalUserVendorLink portalUserVendorLink);
  /**
   * Approving the Portal User Vendor Link sets the Status Code from Pending to Active
   * for all the associated Resources for the given user.
   * @param idUser
   */
  void approvePortalUserVendorLink(int idUser);
  /**
   * Delete Portal User Vendor Link for the given user.
   * @param idUser
   */
  void deletePortalUserVendorLinkByIdUser(int idUser);
  /**
   * Delete Portal User Vendor Link for the given PUVL.
   * @param idUser
   */
  void deletePortalUserVendorLinkByIdPuvl(int idPuvl);
} 