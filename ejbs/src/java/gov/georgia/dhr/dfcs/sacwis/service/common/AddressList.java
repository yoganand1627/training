package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.dao.person.AddressValueBean;

public interface AddressList {
  public AddressValueBean getActiveAddressForStage(AddressValueBean searchBean);
}