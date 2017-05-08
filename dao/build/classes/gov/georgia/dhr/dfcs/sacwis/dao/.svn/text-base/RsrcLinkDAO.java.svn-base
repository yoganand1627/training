/**
 * Created on Mar 25, 2006 at 3:35:19 PM by Michael K. Werle
 * 
 * Change History:
 * Date         User              Description
 * --------     ----------------  -------------------------------------------------
 * 04/03/2009   arege             STGAP00012937 Added new method for Pagination of Service Site/SubContractor List
 *                                on the Resource Detail Page.
 *                              
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;

import java.util.List;

public interface RsrcLinkDAO {
  /**
   * Retrieves rows from the RSRC LINK and CAPS RESOURCE tables given the Id Rsrc Link Parent
   *
   * @param idRsrcLinkParent
   * @return List of RsrcLink by idRsrcLinkParent
   */
    @SuppressWarnings({"unchecked"})
  List<RsrcLink> findRsrcLinkSubcontractorsByIdRsrcLinkParent(int idRsrcLinkParent);
  
  //STGAP000012937 Added for pagination
    /**
     * Retrieves paginated list of ResourceLink records
     * @param idRsrcLinkParent
     * @param pageNbr
     * @param pageSize
     * @return Paginated List of RsrcLink by idRsrcLinkParent 
     */
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<RsrcLink> findRsrcLinkSubcontractorsByIdRsrcLinkParent(int idRsrcLinkParent, int pageNbr, int pageSize);
  
  /**
   * Returns an ID resource if the resource ID passed is a sub contractor.
   *
   * @param idRsrcLinkChild
   * @return
   */
  Integer findIdRsrcLinkByIdRsrcLinkChildAndCdRsrcPrimeSubLink(int idRsrcLinkChild);

  /**
   * This returns an ID resource if the resource ID passed is a prime contractor. (Found on the Parent column)
   *
   * @param idRsrcLinkParent
   * @return
   */
  Integer findIdRsrcLinkByIdRsrcLinkParentCdRsrcPrimeSubLink(int idRsrcLinkParent);

  /**
   * Retrieves a full row from the CapsResource and RsrcLink tables for the given idRsrcLinkChild and cdRsrcLinkType.
   *
   * @param idRsrcLinkChild
   * @param cdRsrcLinkType
   * @return RsrcLink object
   */
  RsrcLink findCapsResourceAndRsrcLink(int idRsrcLinkChild, String cdRsrcLinkType);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.RsrcLink} object to the database.
   *
   * @param RsrcLink A populated {@link gov.georgia.dhr.dfcs.sacwis.db.RsrcLink} object.
   */
  void saveRsrcLink(RsrcLink rsrcLink);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.RsrcLink} object.
   *
   * @param rsrcLink
   */
  void deleteRsrcLink(RsrcLink rsrcLink);
  /**
   * This returns an Parent ID resource for use by Adoption to find the Agency Name.
   *
   * @param idRsrcLinkChild
   * @return
   */
  public Integer findCapsResourceParentIdRsrcLink(int idRsrcLinkChild);
}
