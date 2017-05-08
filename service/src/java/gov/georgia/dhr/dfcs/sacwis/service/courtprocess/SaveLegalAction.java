package gov.georgia.dhr.dfcs.sacwis.service.courtprocess;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO;

public interface SaveLegalAction {
  /**
   * Allows a user to save or update a Legal Action WITHOUT saving or updating the associated Attendees.  To save or
   * update Attendees as well, call the overloaded method.
   *
   * @param csub39si
   * @return {@link CSUB39SO}
   */
  CSUB39SO saveLegalAction(CSUB39SI csub39si);
}
