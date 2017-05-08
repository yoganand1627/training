package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD38SO;

/**
 * *********************************************************************** * * Module File:   CFAD38S.src * * Service
 * Name:  Home License Save * * Description:   This service checks for Stage/Event, and Post Event * information.  It
 * also updates CAPS_RESOURCE, and *                family LOC information.  If a change has been made to * the child's
 * foster type, a ToDo will be sent to each *                child's primary worker. There is a trigger on CAPS_RESOURCE
 * *                    which checks IND_RSRC_WRITE_HIST and updates RESOURCE_HISTORY * * Environment: HP-UX V9.0 *
 * FOUNDATION V2.4 for Unix (Construction, Production) * HP-UX Ansi C Compiler * * Date Created:  December 22, 1995 * *
 * Programmer:    Sandra Wang * * Archive Information: $Revision:   1.3  $ * $Date:   10 Mar 1997 17:36:26  $ *
 * $Modtime:   10 Mar 1997 18:09:14  $ *                      $Author: pvcs  $ * * Change History: *  Date      User
 * Description *  --------  -------- -------------------------------------------------- *  02/22/96  VISHNUR   SIR 3321
 * - The future date of todo alert is wrong. *                      Added code to pass current date. *  03/01/96 VISHNUR
 * SIR 3276 - Pssing NULL_DATE for FLOC end date is *                      not creating a MAX_DATE in facility_loc. So
 * passing * MAX_DATE instead of NULL_DATE. *  03/11/96  VISHNUR   SIR 3276 - Change in Foster type is not being *
 * reflected on Resource Services. Before calling * cfad01u cSysIndFosterTypeChange needs to be passed. *  03/14/96
 * VISHNUR   SIR 3867 - The LOC for 3,4 is showing only 3,4 *                      needs to show 1,2,3 & 4. * Completely
 * modified the process of updating the FLOC. *                      Whatever processing that is done on the Client side
 * * is ignored. In this save service dam CSEC25D is *                      called to retrieve the current status of
 * FLOC and *                      determine how it should be updated based on present * Home status and Foster types. *
 * A new row is inserted using CAUD80D. *  3/22/96   PURCELA   SIR #4164 - Pass the Worker of the Stage as well *
 *               as who the ToDo will be assigned to into the ToDo * Common Function.  The Worker must be passed in *
 *                   they could be a Historical Primary, in which case * CINV51D should not be executed within CSUB40U.
 * * *  4/11/96 CRYSTAEP SIR #20358 - Change Order Enhancement: * Added logic in Success Case of DAM CAUD98D * to allow
 * for the creation or update of * contracts for NonPRS Homes.  The contract tables * will be updated upon saving of the
 * window for a * change in the F/A Home Status field.The service will *                      validate that two
 * contracts exist for a NonPRS Home- *                      a Foster and an Adoptive contract.  The service will *
 * retrieve all contracts for the FA Home that have a *                      period term date that is >= the current
 * date. Contracts *                      will be created for homes that do not have a Home * Status of "Closed" and do
 * not have existing Foster * and Adoptive contracts. *  5/8/96    DENTONRA  SIR 21003 - Changed "extendo" date
 * processing to *                      have == instead of = .  Also, changed error * processing of cses80d to allow
 * sql-not-found because *                      that is an acceptible condition. It should not * "blow-up" at that
 * point. * *  03/10/97  GONZALCE  SIR 11917 - Added a new dam to update the todo table. * CAUDB7D.PC will update the
 * dt_todo_completed to * SYSDATE for any FAD todo's that are completed for a * specific id_stage. * * 9/10/2001 Hadjimh
 * SIR #15787 & 13380: A change is requested to the * Foster Care Rate Structure.  The revised structure will add the *
 *                     element of age to the determination of service code, * The new rate structure will take effect
 * September 1, *                      2001, for services delivered after August 31, 2001. *
 * Regardless of whether the associated contract can serve LOC 1 * or LOC 1 and 2 clients, CONTRACT_SERVICE rows are
 * currently set up *                      for both level 1 (service code 95L) and level 2 (service code 95M). *
 *              CONTRACT_COUNTY rows are linked to both. Because the contract is *                      set up for both
 * level 1 and level 2, the home may be incorrectly * reimbursed at the level 2 rate. *   1/23/03   DWW      Added
 * following line for error handling: * if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } *  03/25/03  Srini     Modified
 * to check for the transaction and tpbegin only if it * is not already started and similarly for tpcommit at the end. *
 * * 06/23/03  Srini SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR * to PROCESS_TUX_RC_ERROR_NOFREE after
 * the * ARC_UTLCheckServiceBatchBlock so that it doesn't free the * input and output objects before they are allocated
 * * * 06/25/03  Srini    SIR#18334 Added new fields to be saved by the CAUD98D dam. * *  06/30/03  Srini     SIR 18602
 * - Modified to fix error handling for * transaction aware code * * 07/10/03  Srini     SIR 18602 - More changes.
 * Changed all PROCESS_TUX_RC_ERROR calls to * PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to *
 * PROCESS_TUX_SQL_ERROR_TRANSACT calls. * * 08/29/03 MMcClain,  SIR 19596, set all Change flags when calling cfad01u *
 * *  09/04/03  A.Corley  SIR 19613 LOC Reduction -- Service Codes 60A-E are now *                      being reduced to
 * Service Codes 63A - D, updated code to compare and *                      save with new codes. * *  10/24/2003
 * Matthew McClain  SIR 19998, Contracts don't need to be updated *                      for closed status; that's
 * handled by cfad36 *  11/17/03  A.Corley SIR 22390 LOC Change -- Service Code 63C is now being used * for Specialized
 * home, also add FLOC 5 if the home is * ther, habil, or prim med *  12/16/03 A.Corley  SIR 22485 LOC Change -- Service
 * Code 63D is now being used *                      for Intense home, also add FLOC 6 if the home is * ther, habil, or
 * prim med *  4/22/2004 gerryc    SIR 14700 - only set indicator to update RESOURCE_HISTORY if * the status, category,
 * or the license info has been * changed. *  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information
 * page. This new *                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS * Adoptive
 * Home checkbox is checked, staff will have to select a *                      'Certifying Entity'. to indicate the
 * certifying agency *                      2) This will be a required field when the Non-FPS Adoptive Home *
 *           checkbox is checked for a new home. 3) If a user is modifying an * existing Non-FPS Adoptive Home, this new
 * field will be required, *                      unless the home status is also being changed to 'Pending Closure' *
 *                   or 'Closed'. *  09/19/05  yeehp     SIR 23890 - changed level of care to service level *  5/25/06
 * Bittar    Converted cfad38d to SaveHomeLicense *************************************************************************
 */

public interface SaveHomeLicense {
  /*
   * SIR 19613, 22390, 22485, 22686 Homes that are basic will only have * Level A assigned to them, Homes that are Hab, *
   * Ther, and Prim Med will have Level A, B, C & D
   */
  public static final int NBR_OF_HOME_TYPE = 6;
  public static final int FIRST_REC = 0;
  public static final int ZERO = 0;
  public static final int ONE = 1;
  public static final int TWO = 2;
  public static final int ADOPTIVE = 2;
  public static final int FOSTER = 1;
  public static final int NUM_FOSTER_TYPES = 6;
  public static final int END_FAC_LOC_YEAR = 4712;
  public static final int END_FAC_LOC_MONTH = 12;
  public static final int END_FAC_LOC_DAY = 31;
  public static final int CURRENT = 0;
  public static final int NEXT = 1;

  public final int SUCCESS = 1;
  public final int FAILED = -1;

  public static final double FOSTER_PAYMENT_LEV_BASIC = 20.00;
  public static final double FOSTER_PAYMENT_LEV_MOD = 35.00;
  public static final double FOSTER_PAYMENT_LEV_SPEC = 45.00;
  public static final double FOSTER_PAYMENT_LEV_INT = 0.00;
  public static final double SUBSIDY_PAYMENT = 486.00;

  public static final String FA_CATG_FOST = CodesTables.CFACATEG_F;
  public static final String FA_CATG_ADOPT = CodesTables.CFACATEG_A;
  public static final String FA_CATG_LEG_RISK = CodesTables.CFACATEG_L;
  public static final String HOME_STATUS_APVD_FULL_ACT = CodesTables.CFAHMSTA_AFA;
  public static final String HOME_STATUS_APVD_SPEC_ACT = CodesTables.CFAHMSTA_ASA;
  public static final String HOME_STATUS_APVD_TEMP_ACT = CodesTables.CFAHMSTA_ATA;
  //public static final String HOME_STATUS_APVD_INACT = CodesTables.CCDO_050;
  public static final String CONTRACT_STATUS_CLOSED = CodesTables.CCONSTAT_CLS;
  public static final String CONTRACT_STATUS_SERVICE_HOLD = CodesTables.CCONSTAT_SVH;
  public static final String PERSON_STAGE_ROLE_PRIMARY = CodesTables.CROLEALL_PR;
  public static final String PERSON_TYPE_WORKER = CodesTables.CPRSNALL_STF;
  public static final String RSRC_PRIM_ADDR = CodesTables.CRSCADDR_01;
  public static final String RSRC_BUIS_ADDR = CodesTables.CRSCADDR_02;
  public static final String STAGE_CD_FAD = CodesTables.CCONFUNC_FAD;
  public static final String FA_PROGRAM = CodesTables.CCONPROG_CPS;
  public static final String PROVIDER_ENROLL = CodesTables.CCONPROC_PEN;
  public static final String CONTRACT_STATUS_ACTIVE = CodesTables.CCONSTAT_ACT;
  public static final String UNIT_RATE_PAYMENT_TYPE = CodesTables.CCONPAY_URT;
  public static final String ADOPTION_SUBSIDY = CodesTables.CCONUNIT_SUB;
  public static final String DAY_24_HOURS = CodesTables.CCONUNIT_DA2;
  //public static final String FOST_TYPE_GROUP = CodesTables.CAFCTRSP_U;
  //public static final String FOST_TYPE_HABIL = CodesTables.CFAHMTYP_H;
  public static final String FOST_TYPE_THER = CodesTables.CFAHMTYP_THR;
  //public static final String FOST_TYPE_PRIM_MED = CodesTables.CFAHMTYP_R;
  public static final String FLOC_ACTIVE = CodesTables.CFLOCSTA_A;
  public static final String FLOC_HOLD = CodesTables.CFLOCSTA_H;
  public static final String HOME_STATUS_PEND_FULL_APPROVAL = CodesTables.CFAHMSTA_PFA;
  public static final String HOME_STATUS_PEND_SPEC_APPROVAL = CodesTables.CFAHMSTA_PSA;
  public static final String HOME_STATUS_PEND_TEMP_APPROVAL = CodesTables.CFAHMSTA_PTA;
  public static final String PLCMT_ACTUAL = CodesTables.CPLCMTAC_A;

  public static final String INDICATOR_YES = ArchitectureConstants.Y;
  public static final String SIGNED_YES = ArchitectureConstants.Y;
  public static final String FND_YES = ArchitectureConstants.Y;
  public static final String INDICATOR_NO = ArchitectureConstants.N;
  public static final String NO_LIMIT = ArchitectureConstants.N;
  public static final String NO_RENEWAL = ArchitectureConstants.N;
  public static final String FND_NO = ArchitectureConstants.N;

  public static final String ZERO_STR = "0";

  CFAD38SO saveHomeLicense(CFAD38SI cfad38si);
  public boolean checkEvalDocExists(int idStage);
}
