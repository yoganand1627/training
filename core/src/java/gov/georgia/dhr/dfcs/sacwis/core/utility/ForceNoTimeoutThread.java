package gov.georgia.dhr.dfcs.sacwis.core.utility;

import javax.servlet.jsp.JspWriter;

/**
 * Used by long running Test JSPs to "stream" data back the the client every so often to keep the browser from timing
 * out
 */
public class ForceNoTimeoutThread extends Thread {
  protected boolean cleanStop = false;
  protected JspWriter out = null;

  public ForceNoTimeoutThread(JspWriter out) {
    this.out = out;
  }

  public void cleanStop() {
    cleanStop = true;
  }

  public void run() {
    while (cleanStop == false) {
      try {
        out.println("time: " + new Date());
        out.flush();
        sleep(20 * 1000);
      } catch (Exception e) {
        e.printStackTrace();
        return;
      }
    }
  }
}

  
