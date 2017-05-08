package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN49SO;

public interface SaveReopenStage {

  /**
   * This service is used to reopen Subcare and PostAdoption stages that have been closed. The service performs some
   * validation that the stage should be reopened, puts NULL_DATE in the appropriate closed date fields, and in the case
   * of SUBcare moves Service Authorizations created in the Adoption stage to the Subcare stage.
   *
   * @param ccmn49si
   * @return {@link CCMN49SO}
   * @throws ServiceException
   */

  public CCMN49SO saveReopenStage(CCMN49SI ccmn49si);
}
