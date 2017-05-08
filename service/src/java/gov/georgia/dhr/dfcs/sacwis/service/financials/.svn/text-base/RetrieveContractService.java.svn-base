package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO;

public interface RetrieveContractService {
  /**
   * Description:   This service will receive IDContract, NbrCnperPeriod, and NbrCnverVersion and will return multiple
   * rows to populate the listbox of CCON07W and the BFCD CCON01CB.  In addition, this service will receive Id Resource
   * and will retrieve the services maintained for the resource in the resource directory which are found on the
   * Resource Service table.
   *
   * @param ccon11si
   * @return {@link CCON11SO}
   */
  public CCON11SO findContractService(CCON11SI ccon11si);

}
