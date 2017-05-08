/**
 * Created on Jun 28, 2006 at 9:46:30 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.common;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface CommonHome extends EJBLocalHome {
  public CommonLocal create() throws CreateException;
}
