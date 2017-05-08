package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN11SO;

public interface SaveFosterCareDetail {

  /**
   * This service will Add or Update records to the DELVRD_SVC_DTL table. The provided data-action code will determine
   * Add versus Update. All fields on the DELVRD_SVC_DTL which are not used in the add of update will be set to Null or
   * 0 depending upon type. Prior to the above add/update, this service will count the number of reversals and
   * adjustments.
   *
   * @param cfin11si
   */
  CFIN11SO saveFosterCareDetail(CFIN11SI cfin11si);
}
