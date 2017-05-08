/**
 * Created on August 17, 2010 by Seung-eun (Caroline) Choi
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;
/**Change History:
 * Date        User              Description
 * --------    ----------------  --------------------------------------------------
 * 08/21/2010  schoi             SMS #66384: MR-067 Removed savePortalUserDtl and deletePortalUserByIdUser methods 
 *                               per code review
 * 08/29/2101  schoi             SMS #66384: MR-067 Added savePortalUserDtl back for the use in SaveVendorStaffDetailImpl.java                              
 *
 */
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;

import org.hibernate.Query;

public class PortalUserDtlDAOImpl extends BaseDAOImpl implements PortalUserDtlDAO {
  public PortalUserDtl findPortalUserbyIdUser(int idUser) {
    Query query = getSession().createQuery(" from  PortalUserDtl p " +
                                           " where p.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    return (PortalUserDtl) firstResult(query);
  }
  public PortalUserDtl findPortalUserbyIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from  PortalUserDtl p " +
                                           " where p.person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (PortalUserDtl) firstResult(query);
  }   
  public void savePortalUserDtl(PortalUserDtl portalUserDtl) {
    getSession().saveOrUpdate(portalUserDtl);
  }
}
