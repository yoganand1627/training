//
// COPYRIGHT
//

package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

// -- architecture classes

import java.util.TimerTask;

import javax.management.Notification;
import javax.management.NotificationListener;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;

/**
 * Timable task for refreshing the codes table data.
 *
 * @author Daniel L. Boxwell, January 2002
 */
public class LookupRefreshTask extends TimerTask implements NotificationListener {
  /** Method called when the TimerTask is fired. */
  public void run() {
    GrndsTrace.enterScope(TRACE_TAG + ".run()");
    LookupInit.updateLookupData();
    GrndsTrace.exitScope();
  }

  /** Method called when the TimerTask is fired. */
  public void handleNotification(Notification notif, Object o) {
    GrndsTrace.enterScope(TRACE_TAG + ".handleNotification()");
    if (TimerInit.LOOKUP_REFRESH_NOTIF_TYPE.equals(notif.getType())) {
      try {
        LookupInit.updateLookupData();
      }
      catch (Exception e) {
        ExceptionHandler.handle(e);
      }
    }
    GrndsTrace.exitScope();
  }

  //
  // static constants
  //
  private static final String TRACE_TAG = "LookupRefreshTask"; //for tracing
}




