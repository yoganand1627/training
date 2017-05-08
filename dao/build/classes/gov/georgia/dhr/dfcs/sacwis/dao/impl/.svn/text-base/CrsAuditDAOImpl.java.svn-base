/**
 * Created on Apr 27, 2007 at 3:25:59 PM by Kapil Aggarwal
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CrsAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CrsAudit;

/**
 *
 */
public class CrsAuditDAOImpl extends BaseDAOImpl implements CrsAuditDAO {


  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.dao.CrsAuditDAO#saveCrsAudit(gov.georgia.dhr.dfcs.sacwis.db.CrsAudit)
   */
  public void saveCrsAudit(CrsAudit crsAudit) {
    getSession().saveOrUpdate(crsAudit);
  }

}
