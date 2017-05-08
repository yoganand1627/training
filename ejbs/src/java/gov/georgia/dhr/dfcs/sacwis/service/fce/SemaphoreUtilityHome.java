package gov.georgia.dhr.dfcs.sacwis.service.fce;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface SemaphoreUtilityHome extends EJBLocalHome {
  public SemaphoreUtilityLocal create() throws CreateException;
}
