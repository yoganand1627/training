/**
 * Created on Apr 19, 2007 at 3:28:31 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.core.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.LogFactory;

public class LoggingListener implements ServletContextListener {
  public void contextInitialized(ServletContextEvent event) {
    // Do nothing
  }

  public void contextDestroyed(ServletContextEvent event) {
    LogFactory.releaseAll();
  }
}
