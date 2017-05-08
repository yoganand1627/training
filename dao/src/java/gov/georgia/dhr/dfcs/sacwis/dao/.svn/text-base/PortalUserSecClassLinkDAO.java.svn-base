/**
 * Created on Mar 25, 2006 at 2:29:04 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink;

public interface PortalUserSecClassLinkDAO {
  /**
   * This will retrieve cdSecurityClassName from PortalUserSecClassLink and txtSecurityClassProfil from SecurityClass given
   * idPerson
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findPortalUserSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson);

  /**
   * Gets a list of {@link gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink} objects for a given idPerson.
   *
   * @param idPerson
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink} objects for an idPerson.
   */
  @SuppressWarnings({"unchecked"})
  List<PortalUserSecClassLink> findPortalUserSecClassLinkSecurityClassbyIdPerson(int idPerson);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink} object to the database.
   *
   * @param PortalUserSecClassLink A populated {@link gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink} object.
   */
  public void savePortalUserSecClassLink(PortalUserSecClassLink portalUserSecClassLink);
  /**
   * Gets the info from the table
   *
   * @param cdSecurityClassName
   */
  public Long findPortalUserSecClassLink(String cdSecurityClassName);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink} object.
   *
   * @param idEmpSecLink
   * @param dtLastUpdate
   */
  int deletePortalUserSecClassLink(int idEmpSecLink, Date dtLastUpdate);

  /**
   * Delete rows from PortalUserSecClassLink based on ID_PERSON.
   *
   * @param idPerson
   * @return
   */
  int deletePortalUserSecClassLinkByIdPerson(int idPerson);
}
