package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface AdoExchangeHome extends EJBLocalHome {
  public AdoExchangeLocal create() throws CreateException;

}
