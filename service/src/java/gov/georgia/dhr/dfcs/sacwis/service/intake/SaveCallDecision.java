package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CallDcsnAUDIn;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUOutRec;

public interface SaveCallDecision {

  /**
   * This service makes database changes for the information held on the Call Decision window.
   *
   * @param callDcsnAUDIn
   * @return a populated {@link CallDcsnAUOutRec}
   */
  public CallDcsnAUOutRec saveCallDecision(CallDcsnAUDIn callDcsnAUDIn);
}
