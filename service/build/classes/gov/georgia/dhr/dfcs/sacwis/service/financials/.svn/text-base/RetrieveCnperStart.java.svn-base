package gov.georgia.dhr.dfcs.sacwis.service.financials;

/**
 * Service consisting of method to retrieve and return home approval date using either the contract ID or the resource ID
 *
 * @author Corey Harden, 28 July 2008
 */

import gov.georgia.dhr.dfcs.sacwis.structs.input.DtLicBeginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DtLicBeginSO;


public interface RetrieveCnperStart {

  /**
   * Description:   This service will receive IDContract, NbrCnperPeriod, and NbrCnverVersion and will return multiple
   * rows to populate the listbox of CCON07W and the BFCD CCON01CB.  In addition, this service will receive Id Resource
   * and will retrieve the services maintained for the resource in the resource directory which are found on the
   * Resource Service table.
   *
   * @param ccon11si
   * @return {@link CCON11SO}
   */
  
  public DtLicBeginSO retrieveDtCnperStart (DtLicBeginSI dtLicBeginSI);

}






