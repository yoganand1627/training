package gov.georgia.dhr.dfcs.sacwis.web.ws.impl;

import gov.georgia.dhr.dfcs.sacwis.web.ws.UpdateTcmClaimInfoWS;
import gov.georgia.dhr.dfcs.sacwis.service.ws.WS;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveTcmClaimInfoWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveTcmClaimInfoWO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * TcmUpdateWSImpl
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
public class UpdateTcmClaimInfoWSImpl implements UpdateTcmClaimInfoWS {

  Log log = LogFactory.getLog(UpdateTcmClaimInfoWS.class);

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
  public SaveTcmClaimInfoWO saveTcmClaimInfo(SaveTcmClaimInfoWI saveTcmClaimInfoWI) {

    log.info(">> Inside UpdateTcmClaimInfoWSImpl-saveTcmClaimInfo()");
    return ws.saveTcmClaimInfo(saveTcmClaimInfoWI);

  }

}