package gov.georgia.dhr.dfcs.sacwis.service.fce;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface AgeCitizenshipHome extends EJBLocalHome {
  public AgeCitizenshipLocal create() throws CreateException;
}
