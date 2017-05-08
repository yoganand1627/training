/**
 * Created on Jan 4, 2007 at 5:22:31 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.impl;

import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncherControl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * This Report Launcher class exists solely to accept report requests and forward them to report jobs.  It relies on a
 * {@link org.springframework.core.task.TaskExecutor} to execute the jobs.
 * <p/>
 * Currently, the only report type is SQR (and this is likely to stay the same), but this class is designed to accept
 * different report types in the future.
 */
public class ReportLauncherControlImpl implements ApplicationContextAware, ReportLauncherControl {

  private static final Log log = LogFactory.getLog(ReportLauncherControlImpl.class);

  private ApplicationContext context;

  /**
   * Setting the application context. This method is called by the spring framework
   * to set up the context
   */
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    this.context = context;
  }

  /**
   * Implementation of ReportLauncherControl called by the ReportLauncherShutdownMain
   * to shut down launcher
   */
  public void shutdown() {
    try {
      ((ConfigurableApplicationContext) context).close();
    } catch (ClassCastException e) {
      throw new RuntimeException("The Report Launcher server was not configured for a clean shutdown.", e);
    } catch (Exception e) {
      throw new RuntimeException("Failed to shut down Report Launcher server.", e);
    }
  }
}
