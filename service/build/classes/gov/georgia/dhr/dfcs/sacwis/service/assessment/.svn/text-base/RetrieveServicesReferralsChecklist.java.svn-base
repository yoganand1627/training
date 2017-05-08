package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;

public interface RetrieveServicesReferralsChecklist {
  /**
   * This service calls DAMS CLSS81D.pc and CSESA2D.pc to retrieve all the information needed to poplulate the Services
   * and Referrals Checklist window. This service will retrive an entire row from the CPS_CHECKLIST table, and one or
   * more rows from the CPS_CHECKLIST_ITEM table.
   *
   * @param cinv54si
   * @return {@link CINV54SO}
   */
  public CINV54SO retrieveServicesReferralsChecklist(CINV54SI cinv54si);
}
