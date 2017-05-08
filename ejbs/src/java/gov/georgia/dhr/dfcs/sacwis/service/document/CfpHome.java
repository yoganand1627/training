package gov.georgia.dhr.dfcs.sacwis.service.document;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface CfpHome extends EJBLocalHome {
  public CfpLocal create() throws CreateException;
}
