package gov.georgia.dhr.dfcs.sacwis.service.assessment;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV55SO;

public interface SaveServicesAndReferrals {
  /**
   * This service calls DAMS CAUDE3D.pc and CAUDE4D.pc. This service will save or update all columns on the CPS_CHKLST
   * table.  It will also insert or delete one or more rows from the CPS_CHKLST_ITEM table, depending on what was
   * changed in the Services and Referrals Checklist window.
   *
   * @param cinv55si The input object populated with method parameters.
   * @return CINV55SO The output object populated with the retrieved row/column values.
   */
  public CINV55SO saveServicesAndReferralsInformation(CINV55SI cinv55si);

}
