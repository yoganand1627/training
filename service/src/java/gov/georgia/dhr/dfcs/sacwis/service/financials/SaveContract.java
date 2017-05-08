package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO;

public interface SaveContract {

  /**
   * If stage is closed, do not allow save. If the stage is open, then proceed with the save service
   *
   * @param ccon03si
   * @return
   */
  CCON03SO saveContract(CCON03SI ccon03si);
}
