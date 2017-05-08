package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

// java classes

import java.util.TimerTask;

import javax.management.Notification;
import javax.management.NotificationListener;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.web.core.exception.handler.ExceptionHandler;

/**
 * This class is responsible for calling the respective methods that update the ReferenceData object in WebLogic's JNDI
 * tree and  the ReferenceData instance in ReferenceDataLookup class.
 *
 * @author Prem Raghupathy, March 08, 2002.
 */
public class ReferenceDataRefreshTask extends TimerTask implements NotificationListener {
  private static final String TRACE_TAG = "ReferenceDataRefreshTask";

  public void run() {
    GrndsTrace.enterScope(TRACE_TAG + ".run) ");
    try {
      // updates the ReferenceData object in JNDI tree
      (new ReferenceDataInitializer()).buildReferenceData();
    }
    catch (ReferenceDataInitializerException rdiEx) {
      ExceptionHandler.handle(rdiEx);
    }
    GrndsTrace.msg(TRACE_TAG + ".run() ", 7, "::Reference Data Cache refreshed");
    GrndsTrace.exitScope();
  }

  public void handleNotification(Notification notif, Object o) {
    if (notif.getType().equals(TimerInit.REFERENCE_REFRESH_NOTIF_TYPE)) {
      GrndsTrace.enterScope(TRACE_TAG + ".handleNotification) ");
      try {
        // updates the ReferenceData object in JNDI tree
        (new ReferenceDataInitializer()).buildReferenceData();
      }
      catch (ReferenceDataInitializerException rdiEx) {
        ExceptionHandler.handle(rdiEx);
      }
      GrndsTrace.msg(TRACE_TAG + ".run() ", 7, "::Reference Data Cache refreshed");
      GrndsTrace.exitScope();
    }
  }
}







