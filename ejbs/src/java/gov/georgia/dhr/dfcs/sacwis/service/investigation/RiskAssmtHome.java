package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * This class is the home class for RiskAssmtEjb.
 *
 * @author Jason Rios, October 10, 2002
 */
public interface RiskAssmtHome extends EJBLocalHome {
  public RiskAssmtLocal create() throws CreateException, TimestampMismatchException;
}






