/**
 * Created on Jun 28, 2006 at 11:21:47 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.resource;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface ResourceHome extends EJBLocalHome {
  public ResourceLocal create() throws CreateException;
}
