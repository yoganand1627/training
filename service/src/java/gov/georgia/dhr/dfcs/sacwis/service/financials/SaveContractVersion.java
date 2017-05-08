package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON08SO;

public interface SaveContractVersion {

  /**
   * This service will update all columns for a Contract/Contract Period/Contract Version combination in the Contract
   * Version table.  The service can add, modify, or delete a row in the Contract Version table.
   * <p/>
   * If the row passed has an action indicator of update and a Lock Modification indicator of yes numerous actions will
   * take place. First, The service information will be retrieved for the modified row.  Second, if the version is not
   * version number one, the services information will be retrieved for the previous version.  If all of the current
   * version service line item amounts are greater than the previous version's line item amounts used, the current
   * version's line item amounts used will be updated with the previous version's amount used values, (This comparison
   * is only done for versions other than the first version) the current contract worker's name, and the new row action
   * indicator will be set to No. In the case of the first version, only the workers name and new row action indicator
   * (set to No) will be updated. In addition, any service rows that did not exist in the previous version will be
   * updated with the current contract worker's name, and the new row action indicator will be set to No. This allows
   * the finance work to be updated to the most recent locked version.  Setting all of the locked version service rows
   * to No assures that new versions will contain at least as many service line items as the previous version in the
   * same order with the same service line item number.
   * <p/>
   * If the version end dates are modified for the row passed, the corresponding county dates are modified in order to
   * reflect the new version end dates as well.
   * <p/>
   * For any Contract Version that has a data action of add, the service will duplicate the previous Version's service
   * line items and corresponding contracted counties in a mimicking a new using feature.  Thus, this only works if the
   * version is not the first version.
   *
   * @param ccon08si
   * @return
   */
  CCON08SO saveContractVersion(CCON08SI ccon08si);
}
