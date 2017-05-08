package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15SO;

/**
 * This is the interface is used to run validations/edits for the Investigation
 * Conclusion page.
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/04/08  SWR       STGAP00009080 - Added new constants for edit checks to be
 *                      used in Impl class.
 * </pre>
 */

public interface SaveCPSInvestigationConclusionValidation {
  //Parameter for Edit Process String
  public static final char EDIT_YES = 'Y';
  //Positions within Edit Process String
  public static final int VICTIM_DOB_EDIT = 0;
  public static final int PERS_SEARCH_EDIT = 1;
  public static final int PERS_CHARACTER_EDIT = 2;
  public static final int EA_QUESTIONS_EDIT = 3;
  public static final int SVC_REF_CHKLST_EDIT = 4;
  public static final int SAFETY_EVAL_EDIT = 5;
  public static final int OPEN_SUBCARE_STAGE = 6;
  public static final int SVC_AUTH_EDIT = 7;
  public static final int RSN_DTH_EDIT = 9;
  public static final int DATE_RSN_DTH_EDIT = 10;
  
  // SWR 06/04/08 STGAP00009080 - Added new edit check constants
  public static final int UNSUB_ALLEG_EDIT = 11;
  public static final int OPEN_STAGE_EDIT = 12;
  
  // SWR 06/11/08 - Added edit check for safety resource
  public static final int SAFETY_RESOURCE_EDIT = 13;  

  // Task codes and event related constants
  public static final String SVC_REF_CKLST_TASK = "2309";
  public static final String INVESTIGATION_ACTION_TASK = "2210";
  public static final String SAFETY_EVAL_TASK = "2300";
  public static final String SVC_AUTH_CD_TASK = "2310";
  public static final String EA_ELIGIBILITY_TASK = "2325";

  public static final String FAM_PRES_CODE = CodesTables.CCINVCLS_64;
  public static final String MOD_FAM_PRES_CODE = CodesTables.CCINVCLS_65;
  public static final String INTNSV_FAM_PRES_CODE = CodesTables.CCINVCLS_66;
  public static final String CNTRCTED_FAM_PRES_CODE = CodesTables.CCINVCLS_68;
  public static final String CNTRCTED_MOD_FAM_PRES_CODE = CodesTables.CCINVCLS_69;
  public static final String CNTRCTED_INTNSV_FAM_PRES_CODE = CodesTables.CCINVCLS_70;

  /**
   * Performs server side validation for the CPS Investigation Conclusion window. The edits performed by the service
   * depend on the decode string in DCD_EDIT_PROCESS. Once all required edits are passed, the service will set all the
   * to-dos associated with the input ID_EVENT to "COMPLETE" and return a list of all the ID_EVENTs associated with the
   * input ID_STAGE.
   *
   * @param cinv15si
   * @return
   */
  public CINV15SO saveCPSInvestigationConclusionValidation(CINV15SI cinv15si);
}
