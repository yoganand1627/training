package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CsupChildleftcareOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CsupChildleftcareOutbound;

/**
 * CsupParentOutboundDAOImpl
 *
 * @author Kalpana Thirumurthy
 * @version 1.0
 *          <p/>
 *          <pre>
 *                      Change History:
 *                      Date      User              Description
 *                      --------  ----------------  --------------------------------------------------
 *          </pre>
 */
public class CsupChildleftcareOutboundDAOImpl extends BaseDAOImpl implements CsupChildleftcareOutboundDAO {

  /**
   * Method used to save the Outbound web Service for parent demographic updates for STARS
   *
   * @param csupChildleftcareTable Accepts the hibernate table to be saved into as the input
   * @return Returns the id created for the saved row in the database
   */
  public int saveCsupChildleftcare(CsupChildleftcareOutbound csupChildleftcareTable) {
    getSession().saveOrUpdate(csupChildleftcareTable);
    return csupChildleftcareTable.getIdCsupChldlftcareOutbound();

  }
}