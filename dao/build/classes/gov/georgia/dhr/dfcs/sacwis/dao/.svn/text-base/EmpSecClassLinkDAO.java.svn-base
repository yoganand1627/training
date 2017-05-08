/**
 * Created on Mar 25, 2006 at 2:29:04 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink;
/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   02/28/2011  htvo              SMS#97845 MR-074-2 AFCARS: added findIdPersonsByCdSecurityClassName to find all 
 *                                 person sharing the same security profile                                 
 */
public interface EmpSecClassLinkDAO {
  /**
   * This will retrieve cdSecurityClassName from EmpSecClassLink and txtSecurityClassProfil from SecurityClass given
   * idPerson
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson);

  /**
   * Gets a list of {@link gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink} objects for a given idPerson.
   *
   * @param idPerson
   * @return A list of {@link gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink} objects for an idPerson.
   */
  @SuppressWarnings({"unchecked"})
  List<EmpSecClassLink> findEmpSecClassLinkSecurityClassbyIdPerson(int idPerson);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink} object to the database.
   *
   * @param empSecClassLink A populated {@link gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink} object.
   */
  public void saveEmpSecClassLink(EmpSecClassLink empSecClassLink);
  /**
   * Gets the info from the table
   *
   * @param cdSecurityClassName
   */
  public Long findEmpSecClassLink(String cdSecurityClassName);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.EmpSecClassLink} object.
   *
   * @param idEmpSecLink
   * @param dtLastUpdate
   */
  int deleteEmpSecClassLink(int idEmpSecLink, Date dtLastUpdate);

  /**
   * Delete rows from EmpSecClassLink based on ID_PERSON.
   *
   * @param idPerson
   * @return
   */
  int deleteEmpSecClassLinkByIdPerson(int idPerson);
  
  /**
   * Find all person sharing the same security profile
   * @param cdSecurityClassName
   * @return list of person ids
   */
  List<Integer> findIdPersonsByCdSecurityClassName(String cdSecurityClassName);
}
