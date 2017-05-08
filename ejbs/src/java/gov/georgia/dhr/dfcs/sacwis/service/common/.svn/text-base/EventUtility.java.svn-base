package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.service.admin.Admin;

import java.util.List;

/** User: mkw Date: Jun 30, 2003 Time: 11:10:15 AM */
public interface EventUtility {
  /**
   * Update the event status for an array of events.
   *
   * @param eventIds the events to be udpated
   */
  public void updateEventStatus(List eventIds);

  /**
   * Update the event status for an array of events.
   *
   * @param eventIds the events to be udpated
   * @param status   the status to be used to udpate the events
   */
  public void updateEventStatus(List eventIds, String status);

  /**
   * Set the event status to COMP for a stage closure event and invalidate the associated Approval event.
   *
   * @param stageClosureEventId the closure event for the stage
   * @param admin
   */
  public void invalidatePendingStageClosure(int stageClosureEventId, Admin admin);
}