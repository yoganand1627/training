/**
 * Created on Jun 28, 2006 at 10:48:35 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface InvestigationHome extends EJBLocalHome {
  public InvestigationLocal create() throws CreateException;
}
