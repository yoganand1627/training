package gov.georgia.dhr.dfcs.sacwis.service.common;

import java.util.List;

/**
 * Interface for the Phone EJB.
 *
 * @author Matthew McClain, March 1, 2003
 */
public interface Phone {
  /** Delegates to PhoneDao.getActivePhonesForStage to retrieve all active phones for the stage. */
  public List getActivePhonesForStage(int stageId, String stageCode);
}