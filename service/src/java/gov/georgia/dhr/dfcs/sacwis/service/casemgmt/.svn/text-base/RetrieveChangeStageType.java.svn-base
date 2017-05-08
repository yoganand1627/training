package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB63SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO;

public interface RetrieveChangeStageType {

  /**
   * This service will receive Id Event and Id Stage. These two elements will be used as inputs to call a DAO which will
   * perform a full row from STAGE table. The message will only return CD STAGE TYPE.  It will also call a DAO to
   * retrieve information from the Event Table.
   *
   * @param csub63si
   * @return CSUB63SO
   */
  CSUB63SO retrieveChangeStageType(CSUB63SI csub63si);
}
