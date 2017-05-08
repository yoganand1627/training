package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC42SO;

public interface SaveCreateAdminReview {

  /**
   * The service performs the steps necessary to create an Admin Review Stage.  If the stage being reviewed is an
   * investigation stage, the service will be passed an ID_PERSON for the requestor of the review which is used with the
   * ID_STAGE to retrieve an entire row from the STAGE_PERSON_LINK table. (CINV39D).  If the person's role in the
   * reviewed stage is not that of a confirmed perpetrator, the service will return an error message and the Admin
   * Review stage is not created. Otherwise, the ADMIN_REVIEW table is checked(CSEC62D) to ensure that ther is no
   * currently an Admin Review stage open for the requestor and for the stage to be reviewed. If an Admin review stage
   * is open, then the service will return an error message and the Admin Review stage is not created. Once these
   * initial checks have been made, the service calls the CloseOpenStage common function(CCMN03U) to open the Admin
   * Review Stage. Next, the service copies all of the allegations relating to the requestor and the reviewed stage from
   * the ALLEGATION table to the ADMIN_ALLEGATION table(CMSC43D) for historical purposes, sets the name of the Admin
   * Review Stage to that of the requestor(CCMND8D), retrieves the ID_EVENT for the Admin Review event created by
   * CloseOpenStage(CSES63D), and creates an EVENT_PERSON_LINK record for the requestor and the Admin Review
   * Event(CCMN68D). If the stage being reviewed is an APS investigation, then the CD_STAGE_REASON_CLOSED for the stage
   * to be reviewed is cleared (CAUDA5D).  Finally, the service retreives the ID_PERSON for the historical primary
   * worker of the stage to be reviewed(CCMN19D) and the worker's supervisor(CCMN60D). If the worker is still an active
   * employee, the ToDo common function(CSUB40U) is called to send a ToDo to both the worker and the supervisor.
   * <p/>
   * If the stage being reviewed is a F/A home stage, the ADMIN_REVIEW table is checked(CSEC64D) to ensure that there is
   * not currently an Admin Review stage open for the stage being reviewed.  If an Admin Review stage is open, then the
   * service will return an error message and the Admin Review Stage is not open. Otherwise, the CloseOpenStage common
   * function is called(CCMN03U) to create the Admin Review Stage.  The ID_PERSON of the primary worker(or historical
   * primary worker) for the F/A Home Stage(CCMN19D) and the worker's supervisor (CCMN60D are then retreived.If the
   * worker is still an active employee, the ToDo common function(CSUB40U) is called to send a ToDo to both the woker
   * and the supervisor.
   *
   * @param ccfc42si
   * @return CCFC42SO
   */
  public CCFC42SO saveCreateAdminReview(CCFC42SI ccfc42si);

}
