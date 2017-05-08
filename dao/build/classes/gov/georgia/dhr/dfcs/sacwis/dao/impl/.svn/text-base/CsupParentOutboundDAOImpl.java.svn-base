package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.CsupParentOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CsupParentOutbound;

/**
 * CsupParentOutboundDAOImpl
 * 
 * @author Kalpana Thirumurthy
 * @version 1.0
 * 
 * <pre>
 *             Change History:
 *             Date      User              Description
 *             --------  ----------------  --------------------------------------------------
 * </pre>
 */
public class CsupParentOutboundDAOImpl extends BaseDAOImpl implements CsupParentOutboundDAO {

  /**
   * Method used to save the Outbound web Service for parent demographic updates for STARS
   * 
   * @param context
   * Accepts the hibernate table to be saved into as the input
   * Returns the id created for the saved row in the database
   */
  public int saveCsupParentOutboundTable(CsupParentOutbound csupParentTable) {
    getSession().saveOrUpdate(csupParentTable);
    return csupParentTable.getIdCsupParentOutbound();

  }

}