package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44SO;

public interface SaveAddressListDetail {

  /**
   * This is the AUD service for the Address List/Detail window.
   *
   * @param ccmn44si
   * @return
   */
  public CCMN44SO saveAddressListDetail(CCMN44SI ccmn44si);

}
