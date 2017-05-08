package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AlertMesWorkerIfSESI;

public interface AlertMesWorkerIfSE {
  // SMS #116335: ECEM 5.0 Updated hardcoded 100 to the constant variable 
  public static final int MAX_NUM_ATTRIBUTES = ArchitectureConstants.MAX_NUM_ATTRIBUTES;
  public static final String ADD = ServiceConstants.REQ_FUNC_CD_ADD;
  public static final String MES_PROGRAM_ASSISTANT = "MES_PROGRAM_ASSISTANT";
  public static final String MES_WORKER = "MES_WORKER";
  /**
   * <p>This method checks to see if an MES Worker is already assigned as a Secondary Manager to
   * the passed in Stage. It sends all MES Workers assigned as 'SE' an alert that says, 
   * 'An FCEA Initial Application or Notification of Change is ready to be processed'. It also
   * sends the MES Program Assistant an alert that says 'An FCEA Initial Application 
   * or Notification of Change that is ready to be processed has been assigned'.</p>
   * 
   * @param alertMesWorkerIfSESI {@link AlertMesWorkerIfSESI}
   * @return boolean indicating if MES Worker is already an SE
   */
  public boolean alertMesWorkerIfAlreadySE(AlertMesWorkerIfSESI alertMesWorkerIfSESI);
    
}
