/**
 * Created on Dec 21, 2006 at 6:00:36 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.launcher.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.launcher.ReportLauncher;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportLauncherMain {

  private static ReportLauncher reportLauncher;

  /**
   * @param reportLauncherImpl
   *          the reportLauncherImpl to set
   */
  public void setReportLauncher(ReportLauncher reportLauncher) {
    this.reportLauncher = reportLauncher;
  }

  /**
   * The main method that launches the Launcher Program
   * @param args
   */
  public static void main(String[] args) {
    // Dll this needs to do is create the bean factory, as the launcher-context.xml contains the server definition.
    // noinspection ResultOfObjectAllocationIgnored
    new ClassPathXmlApplicationContext(new String[] {"launcher-server-context.xml" });
    reportLauncher.runPendingReports();
  }
}