package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN07SO;

public interface SaveOnCallList {
  /**
   * This service is called from the On-Call List window. It's purpose is to add, modify or delete an on-call shift or
   * block. Also, when it deletes an on-call shift or block, it needs to check if there are employees assigned to that
   * block and if there are, each employee needs to be sent a To-Do (Alert) notifying the employee that the shift or
   * block in question has been deleted and they are no longer assigned to it.  After the To-Do's have been sent, the
   * employees are then deleted from the EMP ON CALL LINK table. This service calls five DAOs.
   *
   * @param ccmn07si The input object populated with parameters used in DAO calls.
   * @return The output object populated with results of queries, if any.
   */
  public CCMN07SO saveOnCallListInformation(CCMN07SI ccmn07si);
}
