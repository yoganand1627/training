package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC44SO;

public interface SaveAdminReview {

  /**
   * This service performs the steps necessary to save the information on the Admin Review & Appeal window as well as
   * update the Admin Review event status and send any necessary ToDos. If the Admin Review stage is being closed, the
   * service manually closes the stage rather than calling the CloseOpenStage common function.
   * <p/>
   * The service first calls the CheckStageEventStatus common function (CCMN06U) to ensre that the Admin Review event
   * and stage have not been modified since the window was opened.  If the check is successful, the current row from the
   * ADMIN_REVIEW table is retrieved (CSES65D), the new data from the window is saved (CAUDA3D) and the Postevent common
   * function (CCMN01U) is called to update the event status.
   * <p/>
   * If the Admin Review stage is being closed (i.e., the status of the review is set to "Approved"), additional
   * processing is necessary since the service manually closes the stage rather than calling the CloseOpenStage common
   * function.
   *
   * @param ccfc44si
   * @return CCFC44SO
   */
  public CCFC44SO saveAdminReview(CCFC44SI ccfc44si);
}
