package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON14SO;

public interface SaveCountyList {

  /**
   * Uses ComplexResourceDAO and ContractCountyDAO to save or update ContractCounty.
   *
   * @param ccon14si
   * @return
   */
  CCON14SO saveCountyList(CCON14SI ccon14si);
}
