package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ProtectiveServiceAlertSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertSaveSO;

public interface SaveProtectiveServiceAlert {
  /**
   * Save service for Protective Service Alert
   *
   * @param psaSI
   * @return {@link gov.georgia.dhr.dfcs.sacwis.structs.output.ProtectiveServiceAlertRetrieveSO}
   * @throws ServiceException
   */
  ProtectiveServiceAlertSaveSO saveProtectiveServiceAlert(ProtectiveServiceAlertSaveSI psaSI);
}