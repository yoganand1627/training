package gov.georgia.dhr.dfcs.sacwis.service.resource;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface ResourceORSHome extends EJBLocalHome {
  public ResourceORSLocal create() throws CreateException;
}
