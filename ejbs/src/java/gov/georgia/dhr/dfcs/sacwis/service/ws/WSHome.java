/**
 * Created on Jun 28, 2006 at 9:46:30 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.ws;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

import gov.georgia.dhr.dfcs.sacwis.service.common.CommonLocal;

public interface WSHome extends EJBLocalHome {
  public WSLocal create() throws CreateException;
}