/**
 * Created on Jan 4, 2007 at 4:40:40 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.control;

import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncherControl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.RemoteLookupFailureException;

/**
 *  The class is used to shut down the launcher
 */
public class ReportLauncherShutdownMain {

  private static final Log LOG = LogFactory.getLog(ReportLauncherShutdownMain.class);

  /**
   * Main method called to shut down launcher
   * @param args
   */
  public static void main(String[] args) {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:launcher-control-context.xml");
    try {
      ReportLauncherControl reportLauncher = (ReportLauncherControl) beanFactory.getBean("reportLauncherControl");
      reportLauncher.shutdown();
    } catch (RemoteLookupFailureException e) {
      String msg = "Failed to connect to report launcher server.";
      if (LOG.isDebugEnabled()) {
        LOG.debug("msg", e);
      } else {
        LOG.info(msg);
      }
    } catch (Exception e) {
      LOG.fatal("Failed to shut down server.", e);
      System.exit(-1);
    }
    // Explicity set the exit code to 0.
    System.exit(0);
  }
}
