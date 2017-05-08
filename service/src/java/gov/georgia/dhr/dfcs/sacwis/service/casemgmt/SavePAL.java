package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC04SO;

public interface SavePAL {

  /**
   * This service will update the Closure Reason and Stage Closure Date on the STAGE table.  It will also update the
   * Closure Living Arrangement on the PAL table.  It will also create a PAL closure event by doing a full row add to
   * the EVENT table and creating a link to the prmiary child. It will also write out an Alert for the primary PAL
   * worker indicating that the PAL stage has been closed. Additionally,it will set the status for all of the PAL events
   * to "COMP".
   *
   * @param ccfc04si
   * @return CCFC04SO
   */
  public CCFC04SO savePAL(CCFC04SI ccfc04si);
}
