/**
 * Created on Mar 25, 2006 at 3:18:39 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   02/08/2012  schoi             STGAP00017831: MR-102 Added method findLatestNbrResourcePhoneByIdResourceByCdPhoneType
 */

public interface ResourcePhoneDAO {
  /**
   * Retrieves all of the Phone data given a resource ID.
   *
   * @param idResource
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<ResourcePhone> findResourcePhoneByIdResource(int idResource);

  /**
   * Insert ResourcePhone
   *
   * @param resourcePhone
   */
  void saveResourcePhone(ResourcePhone resourcePhone);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone} object.
   *
   * @param resourcePhone
   */
  void deleteResourcePhone(ResourcePhone resourcePhone);
  
  /*
   * Retrieves Fax Information given a stage ID
   * 
   * @param idStage
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Object[]> findFaxInformation(int idStage);
  
  /**
   *  Gets resource phone Information
   * @param idResource
   * @return
   */
  Map findResourcePhoneInfo(int idResource);
  
  /**
   * Gets resource fax Information
   * @param idResource
   * @return
   */
  Map findResourceFaxInfo(int idResource);

  // STGAP00017831: MR-102
  /**
   * Gets the most recently entered Resource phone information by idResource and cdRsrcPhoneType
   */
  String findLatestNbrResourcePhoneByIdResourceByCdPhoneType(int idResource, String cdRsrcPhoneType);
}
