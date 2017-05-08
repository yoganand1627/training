package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveVendorStaffDetailSO;

public interface SaveVendorStaffDetail {
  /**
   * This service will retrieve Vendor Staff Detail information
   *
   * @param RetrieveVendorStaffDetailSI
   * @return A populated {@link RetrieveVendorStaffDetailSO} object.
   */
  public SaveVendorStaffDetailSO saveVendorStaffDetail(SaveVendorStaffDetailSI saveVendorStaffDetailSI);

}
