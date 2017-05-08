package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntakeProgressionStatusSI;

/**
 * <p>Description:</p><br>
 * 
 * <pre>This service should be called by the AssignedWorkloadConversation's stageProgression_xa method.
 * It checks to make sure that all the most recent approver has approved the Intake stage being
 * stage progressed. If the determination status is not set to approved, it will throw a 
 * ServiceException. This will prevent the user from being able to stage progress the Intake.</pre>
 * 
 *
 */
public interface CheckIntakeProgressionStatus {

  /**
   * <p>This main method gets the approval event and using that retrieves the list of approvers for the 
   * approval. It then checks to see if the most recent approver's determination is set to approved (APRV).
   * If it's not, it throws the exception to prevent stage progression.
   * 
   * @param IntakeProgressionStatusSI
   * @return boolean indicating that the exception wasn't thrown
   * @throws ServiceException
   */
  public boolean  checkIntakeProgressionStatus(IntakeProgressionStatusSI intakeProgressionStatusSI) throws ServiceException;
}
