package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO;

public interface SaveContractList {

  /**
   * This service will add, update, or delete rows on the Contract Service table.  Updates and deletes will use ID Cnsvc
   * and Timestamp to identify the affected row.
   *
   * @param ccon12si
   * @return CCON12SO
   */
  CCON12SO saveContractList(CCON12SI ccon12si);
}
