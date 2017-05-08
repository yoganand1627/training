package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.web.ws.SaveReceiveChildSupportPaymentInfoWS;
import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveChildSupportPaymentInfoWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveChildSupportPaymentInfoWO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SaveReceiveChildSupportPaymentInfoWSImpl
 * 
 * @author Kalpana Thirumurthy
 * @version 1.0
 * 
 * <pre>
 *              Change History:
 *              Date      User              Description
 *              --------  ----------------  --------------------------------------------------
 * </pre>
 */
public class SaveReceiveChildSupportPaymentInfoWSImpl implements SaveReceiveChildSupportPaymentInfoWS {

  Log log = LogFactory.getLog(SaveReceiveChildSupportPaymentInfoWS.class);

  private WS ws;

  public void setWS(WS ws) {

    this.ws = ws;

  }

  /**
   * Method used to save the Inbound web Service for TCM
   * 
   * @param context
   *          Accepts the WI Object as the input Returns the WO object
   */
  public int saveChildSupportPaymentInfo(SaveChildSupportPaymentInfoWI saveChildSupportPaymentInfoWI) {

    log.info(">> Inside SaveReceiveChildSupportPaymentInfoWSImpl-saveChildSupportPaymentInfo()");
    return ws.saveChildSupportPaymentInfo(saveChildSupportPaymentInfoWI);    
  }

}