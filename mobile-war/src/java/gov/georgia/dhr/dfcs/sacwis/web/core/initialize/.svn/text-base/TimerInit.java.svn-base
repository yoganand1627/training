package gov.georgia.dhr.dfcs.sacwis.web.core.initialize;

import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.management.ListenerNotFoundException;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.timer.Timer;
import javax.servlet.ServletContext;

import org.grnds.facility.log.GrndsTrace;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class TimerInit implements Initializable, Destroyable {

  public static final String REPOST_CLEANUP_NOTIF_TYPE = "RepostCleanupNotification";
  public static final String LOOKUP_REFRESH_NOTIF_TYPE = "LookupRefreshNotification";
  public static final String REFERENCE_REFRESH_NOTIF_TYPE = "ReferenceDataRefreshNotification";

  private static final String TRACE_TAG = "TimerInitialization";

  private static final List<WeakReference<NotificationListener>> listeners =
          new LinkedList<WeakReference<NotificationListener>>();

  @SuppressWarnings({"FieldAccessedSynchronizedAndUnsynchronized"})
  private static Timer timer;

  public TimerInit() {
  }

  public void initialize(ServletContext servletContext) throws LookupException {
    GrndsTrace.enterScope(TRACE_TAG + ".initialize");
    try {
      //noinspection AssignmentToStaticFieldFromInstanceMethod
      timer = new Timer();
      timer.start();
    } catch (Exception e) {
      throw new LookupException("Failed to start timer service.", e, BasePrsException.CRITICAL_PRIORITY);
    }
    GrndsTrace.exitScope();
  }

  public static synchronized void addTimerListener(NotificationListener listener, NotificationFilter filter,
                                                   Object handbackObj) {
    try {
      timer.addNotificationListener(listener, filter, handbackObj);
      // Store references to the listeners so they can be removed.
      listeners.add(new WeakReference<NotificationListener>(listener));
      timer.start();
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failed to add notification: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public static boolean addTimerNotificationNoDupType(String notificationType, String notificationMessage,
                                                      Object handbackObj, Date startDate, long interval,
                                                      long nbrOccurences) {
    return addTimerNotification(notificationType, notificationMessage, handbackObj,
                                startDate, interval, nbrOccurences, true);
  }

  public static synchronized boolean addTimerNotification(String notificationType, String notificationMessage,
                                                          Object handbackObj, Date startDate, long interval,
                                                          long nbrOccurences, boolean noDupType) {
    try {
      if (noDupType) {
        List sameTypeNotifVector = timer.getNotificationIDs(notificationType);
        if (sameTypeNotifVector.size() > 0) {
          GrndsTrace.msg(TRACE_TAG, 7, "Notification of type " + notificationType + " already exists.");
          return false;
        }
        timer.addNotification(notificationType, notificationMessage, handbackObj, startDate, interval, nbrOccurences);
        timer.start();
      }
      GrndsTrace.msg(TRACE_TAG, 7, "Added notification " + notificationType + " to timer.");
      GrndsTrace.msg(TRACE_TAG, 7, "Timer now has " + timer.getNbNotifications() + " notifications.");
      return true;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "An exception was thrown adding notification to timer.");
      throw new RuntimeException(e);
    }
  }

  /**
   * Removes the timer on undeployment.
   *
   * @param config
   * @throws BasePrsException
   */
  public void destroy(ServletContext config) throws BasePrsException {
    for (Iterator<WeakReference<NotificationListener>> it = listeners.iterator(); it.hasNext();) {
      NotificationListener listener = it.next().get();
      if (listener == null) {
        // If the listener has been GC'd, then it could not have been assigned to the timer anymore.
        continue;
      }
      try {
        timer.removeNotificationListener(listener);
      } catch (ListenerNotFoundException e) {
        // Ignore this
      }
      it.remove();
    }
    timer.removeAllNotifications();
    timer.stop();
    // The timer itself holds a reference to a thread that will prevent this class from being GC'd properly,
    //   so we manually set it to null.
    //noinspection AssignmentToStaticFieldFromInstanceMethod,AssignmentToNull
    timer = null;
  }
}