package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;

public interface StageClosureEditChecks {
  /** These need to be put into the CodesTables since their counterparts are */
  public static final String LEGAL_STS_TYPE_SIX = "060";
  public static final String LEGAL_STS_TYPE_ONE_FOURTY = "140";
  public static final String SUB_TASK_CODE = "9944";
  public static final String FSU_TASK_CODE = "9943";
  public static final String ADO_TASK_CODE = "9941";
  public static final String PAD_TASK_CODE = "9945";
  public static final String FPR_TASK_CODE = "9942";
  public static final String DIV_TASK_CODE = "9947";
  public static final String PFC_TASK_CODE = "9946";

  /**
   * This service performs edit checks in a variety of situations related to stage closure.  It searches the appropriate
   * table given a stage to close and the closure reason.  Not all stages and closure reason have edit checks that must
   * be performed. This service will also call CloseOpenStage to close the stage and will call CloseCaseStage if the
   * stage being closed is the last in the case
   * <p/>
   * The APS Service Plan addresses abuse, nelgect and exploitation issues and is never used by guardianship staff. For
   * referrals received from APS, in-home staff complete the plan prior to guardianship. The Guardianship Service Plan
   * is currently on Smiley Face (an FPS form). Remove the requirement to complete the APS Service Plan from both SVC
   * GUA and AOC stages.
   * <p/>
   * If one or more APRV'd Service Auths exist with Term Date in the future, confirm that an eligible open stage exists
   * to which those Service Auths can be progressed. If an eligible stage does not exist, return an error message to the
   * user informing them that the Service Auths must be ended. NOTE: COPIED THE CODE FROM CLOSE-STAGE-CASE COMMON
   * FUNCTION (CCMN02U) AND MODIFIED IT SLIGHTLY FOR USE IN THIS SERVICE.
   * <p/>
   * To close a PAD stage, a Legal Status record is not required. If a Legal Status record exists, however, the most
   * recent Legal Status record must be a terminating Legal Status, but it does not have to be 'FPR Resp Terminated', in
   * particular.
   * <p/>
   * When closing an ADO stage with Adoption Disruption, find the most recent Placement whose Living Arrangement is
   * either "Adoptive Placement" or "Private Agency Adoptive Home", and verify that the Closure Reason is "Adoption
   * Disrupted". If it is not, display the new message MSG_PLCMT_ADOPT_PLCMT_REQ which says "Child must have a Placement
   * with Living Arrangement of Adoptive Placement or Private Agency Adoptive Home."
   * <p/>
   * Before closing the SUB stage, if an FPS paid placement (anything but 'Non-Certified Person' (010) or 'Non-FPS Paid'
   * (040)) exists in the stage, stage must have ALOC, BLOC and Foster Care Eligibility events so the resource can be
   * paid.
   * <p/>
   * Services and Referral Checklist is included with all family stages (FPR, FRE and FSU). This validation service also
   * verifies that the user has completed the Services and Referrals Checklist.
   * <p/>
   * included new Unauthorized Placement Type to edit check on stage closure.  If an open unauthorized Placement Type
   * exists upon stage closure, issue message MSG_STG_CLOS_SUB_C.
   * <p/>
   * CSVC28D is included in order to ensure that there are no pending events before allowing an FSU or FPR stage to be
   * sumitted for closure.
   * <p/>
   * If a pending closing request is present in event list, it does not allow to save and submit new stage closing
   * request for FSU and FRE cases. Added the code to allow to save and submit of new closing request.
   *
   * @param csub68si {@link CSUB68SI}
   * @return CSUB68SO
   */
  public CSUB68SO performEditChecks(CSUB68SI csub68si);
}
