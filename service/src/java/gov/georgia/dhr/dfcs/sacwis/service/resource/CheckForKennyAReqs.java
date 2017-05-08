package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForKennyAReqsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CheckForKennyAReqsSO;

/**
 * 
 * @author corey-khalil.harden
 * 
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *
 */

public interface CheckForKennyAReqs {

  /**
   * This method checks to see if the Kenny A. message needs to be thrown (if there are any currently placed 
   * children from Fulton or Dekalb Counties
   */
  public CheckForKennyAReqsSO checkForKennyAReqs(CheckForKennyAReqsSI checkForKennyAReqsSI);
}
