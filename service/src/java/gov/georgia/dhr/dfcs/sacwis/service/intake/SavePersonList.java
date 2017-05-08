package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PersListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersListAudOutRec;

public interface SavePersonList {

  /**
   * Call Person List AUD from OK click
   *
   * @param cint02si
   * @return PersListAudOutRec
   */
  PersListAudOutRec savePersonList(PersListAudInRec cint02si);
}
