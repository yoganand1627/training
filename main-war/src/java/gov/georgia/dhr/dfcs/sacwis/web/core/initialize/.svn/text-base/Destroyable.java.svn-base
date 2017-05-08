/**
 * Created on Aug 30, 2006 at 9:23:34 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import javax.servlet.ServletContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/**
 * Interface for objects that will be started by the initialization framework.
 *
 * @author Daniel L. Boxwell, January 4, 2002
 */
public interface Destroyable {
  /**
   * Method called by the initialization framework. Place initialization code here.
   *
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException
   *          or subclasses thereof.
   */
  public void destroy(ServletContext config) throws BasePrsException;
}
