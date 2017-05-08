/**
 * Created on August 17, 2010 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;
/**Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 08/21/2010  schoi             SMS #66384: MR-067 Removed savePortalUserDtl and deletePortalUserByIdUser methods 
 *                               per code review
 * 08/29/2101  schoi             SMS #66384: MR-067 Added savePortalUserDtl back for the use in SaveVendorStaffDetailImpl.java                              
 *
 */

public interface PortalUserDtlDAO {
  /**
   * This selects a unique row from the Portal User Dtl table <p/>
   *
   * @param idUser
   * @return
   */
  PortalUserDtl findPortalUserbyIdUser(int idUser);

  /**
   * This selects a unique row from the Portal User Dtl table <p/>
   *
   * @param idPerson
   * @return
   */
  PortalUserDtl findPortalUserbyIdPerson(int idPerson);

  /**
   * Saves Portal User information to the DB
   * @param portalUser
   */
  void savePortalUserDtl(PortalUserDtl portalUserDtl);
  
}
