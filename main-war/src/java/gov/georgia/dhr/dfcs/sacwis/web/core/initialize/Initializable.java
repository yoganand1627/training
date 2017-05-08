//
// COPYRIGHT
//

package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import javax.servlet.ServletContext;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;

/**
 * Interface for objects that will be started by the initialization framework.
 *
 * @author Daniel L. Boxwell, January 4, 2002
 */
public interface Initializable {
  /**
   * Method called by the initialization framework. Place initialization code here.
   *
   * @throws BasePrsException or subclasses thereof.
   */
  public void initialize(ServletContext config) throws BasePrsException;
}










