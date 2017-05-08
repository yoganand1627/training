package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO;

public interface SaveServiceAuthorization {

  /**
   * Performs Service Authorization header save functionality as well as the creation and modification of events,
   * Approval Invalidation and ToDo creation.
   * <p/>
   * If the Window Mode is New then a new record will be saved to the SERVICE AUTHORIZATION table and a new record
   * inserted into the SVC_AUTH_EVENT_LINK table.
   * <p/>
   * If the Window Mode is Modify and the Event Status is 'PEND' then the approval will have to be invalidated and the
   * Event Status demoted to 'COMP'.
   * <p/>
   * If this is the first time that the Service Authorization has been marked complete then the appropriate alerts will
   * be generated.
   * <p/>
   * ToDo's also have to be generated if the worker is authorizing services that are contracted in a region different to
   * their unit region.
   *
   * @param ccon19si
   * @return CCON19SO
   */
  public CCON19SO saveServiceAuthorization(CCON19SI ccon19si);

}
