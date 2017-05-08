package gov.georgia.dhr.dfcs.sacwis.service.fce;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface EligibilitySummaryHome extends EJBLocalHome {
  public EligibilitySummaryLocal create() throws CreateException;
}
