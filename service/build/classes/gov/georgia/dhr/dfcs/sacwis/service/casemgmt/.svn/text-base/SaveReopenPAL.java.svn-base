package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC05SO;

public interface SaveReopenPAL {

  /**
   * This service will update the close date ofr the Stage, Situation and Case tables to null.  It will also set the
   * stage closure reason to null on the STAGE table. Additionally, the new primary worker will be added t the stage
   * along with a link to the primary child.  Finally, the ILS Assessment and PAL Services event statuses will be set
   * back to "PROC".  When the case is reopened, the records retention recored must be deleted and the case file
   * management recored must be updated with the appropriate information.
   *
   * @param ccfc05si
   * @return CCFC05SO
   */
  public CCFC05SO saveReopenPAL(CCFC05SI ccfc05si);
}
