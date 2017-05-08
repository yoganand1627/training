/**
 * Created on May 4, 2007 at 2:24:47 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ChildSupportReferralOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ChildsupRefOutbound;

public class ChildSupportReferralOutboundDAOImpl extends BaseDAOImpl implements ChildSupportReferralOutboundDAO {

  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.dao.ChildSupportReferralOutboundDAO#saveChildSupportReferral(gov.georgia.dhr.dfcs.sacwis.db.ChildsupRefOutbound)
   */
  public int saveChildSupportReferralOutbound(ChildsupRefOutbound childsupRefOutbound) {
    getSession().saveOrUpdate(childsupRefOutbound);
    return childsupRefOutbound.getIdChildsupRefOutbound();
  }

}
