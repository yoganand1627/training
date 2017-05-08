package gov.georgia.dhr.dfcs.sacwis.web.core.validation;

import javax.management.Notification;
import javax.management.NotificationListener;

import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TimerInit;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class RepostCheckCleanupTimerTask implements NotificationListener {

  public RepostCheckCleanupTimerTask() {
  }

  /** @deprecated  */
  public void handleNotification(Notification n, Object o) {
    if (TimerInit.REPOST_CLEANUP_NOTIF_TYPE.equals(n.getType())) {
      RepostCheckUtility.cleanupOldRepostCodes();
    }
  }
}