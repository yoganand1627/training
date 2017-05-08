package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS30DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC27DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC27DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC28DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV96DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV96DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC49DO;
/**************************************************************************
**
** Module File:   CSVC16S.src
**
** Service Name:  CSVC16S - CLOSURE VALIDATION
**
** Description:   Performs a series of edits to determine if Service Delivery
**                is complete or not and will either close
**                the Stage, prepare it for submittal, or return
**                warnings from the edits.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  03/28/95
**
** Programmer:    Wendy Purtle,
**                Mark Dunnagan, Final Review changes.
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   22 Aug 1997 16:16:26  $
**                      $Modtime:   22 Aug 1997 16:03:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/29/95  GLOORJW   PWO #1264 Truncated output message
**
**  10/05/95  BRUCKMK   SIR 1582:  An approved Family Plan and Monthly
**                      Summary is no longer necessary for Family
**                      Preservation Closure.  Remove the Edit, Function Call
**                      & DAM Call that were checking for Family Plan's
**                      existence.
**
**  10/05/95  BRUCKMK   SIR 1583: No edits should be generated when the Stage
**                      Type is Contacted or Con-Intensive.
**                      Exceptions: - If the Closure Reason is Client Died,
**                                    check that all Victims have a date of
**                                    death.
**                                  - Always check that there are no Pending
**                                    Events associated with the stage.
**                      Added szCdStageType to the Service Input Message and
**                      Population of Input Message in the .win file.
**
**  10/05/95  BRUCKMK   SIR 1673: There should be no edits for Case Related
**                      Special Request Stage Types except to check for
**                      PENDING events.
**  10/05/95  BRUCKMK   SIR 1673: There should be no edits for Case Related
**   15Oct95  sladewmf  SIR #1794: Added a call to the CallCSVC28D function.
**
**  10/18/95  BRUCKMK   SIR 1830: When Closing a stage or Submitting a
**                      Closure for Approval, all the IN PROGRESS "PROC"
**                      events should also be updated to approved "APRV" for
**                      closing and pending "PEND" for submitting.
**                      Added a second call to DAM CSVC28D pasing event
**                      status of IN PROGRESS instead of COMPLETE.
**                      Added row counter and Addition statement, to append
**                      the PROC event list to the COMP event list within
**                      the CALLCSVC28D function.
**  10/21/95    KRD     SIR 1883 - There should be no edits generated for
**                      CPS closure reasons "Workload constraints" and
**                      "Administratively closed".
**  10/26/95    KRD     SIR 1967 - Modified CallCSVC28D() and added
**                      CallCCMN56D() so that the only CPS completed
**                      Approval events that are returned are those with
**                      an approval status of invalid or rejected.
**
**  11/13/95  YANTISTK  SIR#1710: Added CheckStageEventStatus common function.
**
**  11/30/95  YANTISTK  SIR#1888: Added Service Authorization edit check.
**
**  01/08/96  GUARRICR  ERR#2548: Set page size and number values in input
**                      record to CCMN87D.
**
**  02/01/96  WILSONET SIR#3054: Added missing break statements to the
**                     nested switches.  Missing statements were causing the
**                     logic to fall into the default case and failing the
**                     service.
**
** 02/20/96   LASKEYRM SIR #5050: CheckStageEventStatus() was screwing
**                     up the code that checked for NEW Events. A simple
**                     change to the input cReqFuncCd fixed the problem. See
**                     CheckStateEventStatus() documentation for details
**                     about the MSG_SYS_MULT_INST funtionality.
**  04/09/96  DENTONRA  SIR 20085 - Change order for Service Authorizations.
**                      Do not allow stage closure if any of the Service Auth's
**                      are not APRoved or if they are not approved they must
**                      be terminated for today or earlier. Do not allow stage/case
**                      closure if any of the Service Auth's are open (term date greater
**                      than today's date).
**
** 05/5/96   DYARGR    SIR 20911 - Added if test for processing SvcAuths when
**                     the FamilyPres stage is not the last stage in the case.
**                     Only COMP and PEND SvcAuth's should give the error message.
**                     Also, changed the message passed back into the Error List
**                     Array to be more consistent with other stage edit checks.
**
**  8/12/96   vanderm   SIR #21968 - database should be restored for
**                      database updates (AUD's) which encounter a problem.
**                      Error handling was corrected by changing
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
** 10/31/96   SISSONM   SIR #22190 - PROC Service Authorization gets set to
**                      APRV with stage closure.
**
** 11/01/96   LYDD      SIR #21883 - Open SVC Auth with end date in future.
**                      Variable Ccmn87do.ArchOutputStruc.ulRowQty is being
**                      replace with a local variable ulRowQtyEvent in for
**                      loop where bPassedSvcAuthEdit == TRUE.  Also, For Loop
**                      (i=0;i<=ulRowQtyEvent-1;i++) is being taken out.
**
** 11/14/96  SISSONM    SIR 11788 - When FPR stage is the last stage of the
**                      case, you will be able to close it with open DAYCARE
**                      service auths...(daycare is provided for up to 6
**                      months after the closure of a case.
**
** 12/02/96  VANDERM    SIR 12741 - Server CSVC00V was being killed by signal
**                      10 because this service was calling a dam without
**                      allocating memory for the output message.  Added
**                      malloc call and memset for the output message. Memory
**                      free after call to dam is complete.
**
** 02/07/97   RIOSJA    SIR 13057 - When conclusions are submitted for
**                      approval, the status of existing approval events
**                      should not be changed to PENDING.
**
** 08/22/97   PAULS     SIR 14129 - Created 2  new Stage types  for FRE and
**                      FPR (MOD and CMOD) . All Contracted Stage Types
**                      Should not have Edits when Doing a Service Delivery
**                      Stage Closure. So I added CMOD to that Condition.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of
**                      full table scans for ccmn87dQUERYdam.
**
**  03/19/04  RIOSJA    SIR 19973 - If one or more APRV'd Service Auths exist
**                      with Term Date in the future, confirm that an eligible
**                      open stage exists to which those Service Auths can be
**                      progressed. If an eligible stage does not exist,
**                      return an error message to the user informing them
**                      that the Service Auths must be ended. NOTE: COPIED
**                      THE CODE FROM CLOSE-STAGE-CASE COMMON FUNCTION
**                      (CCMN02U) AND MODIFIED IT SLIGHTLY FOR USE IN THIS
**                      SERVICE.
**
**  03/23/04  RIOSJA    SIR 19049 - The APS Service Plan addresses abuse,
**                      nelgect and exploitation issues and is never used by
**                      guardianship staff. For referrals received from APS,
**                      in-home staff complete the plan prior to guardianship.
**                      The Guardianship Service Plan is currently on Smiley
**                      Face (an FPS form). Remove the requirement to complete
**                      the APS Service Plan (Outcome Matrix) from both SVC
**                      GUA and AOC stages.
**
**  03/24/04  RIOSJA    SIR 16227 - Added ARI to the list of stages not
**                      eligible to receive Service Auths from a closed
**                      stage.
**
**  04/05/04  RIOSJA    SIR 14003 - When validating that a SUB stage has
**                      been created, search the entire case for CVS
**                      Removal events. Don't search just the stage being
**                      closed.
**
**  05/18/04  RIOSJA    SIR 16123 - Removed GENERAL_PROT_CARE, DAY_CARE,
**                      IVE_FC_DAY_CARE, REGISTERED_FAMILY_HM and
**                      STATE_PAID_FC_DAY_CARE from the list of service
**                      auth types that are allowed to remain open when
**                      the last stage in the case is being closed. Only
**                      FORMER_DAY_CARE service auths are allowed to remain
**                      open.
**
**  07/01/04  RIOSJA    SIR 16114 - Services and Referral Checklist has been
**                      added to all family stages (FPR, FRE and FSU). Add
**                      an edit to this validation service to verify that
**                      the user has completed the Services and Referrals
**                      Checklist.
**
**  07/13/04  RIOSJA    SIR 22970 - If a case with an open INV stage is
**                      merged with a case with an open SVC stage, the
**                      worker should not be allowed to close the SVC stage
**                      before the INV stage is closed.
**
**  4/24/2005 gerryc    SIR 23538 - part of APS Reform R1.  Added the method
**                      CheckAOMActions so that if there are actions in the
**                      outcome matrix, the corresponding pieces in IMPACT
**                      are also required.  If an action requires a certain
**                      service auth, this checks for that service auth.  If
**                      the action is legal related, this checks for the legal
**                      action.
**  5/12/2005 gerryc    SIR 23530 - instead of using CSVC09D to retrieve
**                      outcome matrix rows, we're now using CINV96D.  The CINV96D
**                      dam is not dependent on the APS_CLIENT_FACTORS table.
**                      This is important because with the CARE enhancement,
**                      the Client Assessment was replaced.
**  5/24/2005 gerryc    SIR 23597 - don't check outcome matrix actions if the
**                      closure reason is Client Died or Unable to Locate.
**  6/7/2005  gerryc    SIR 23657 - search for APS/SVC service auth events case-wide,
**                      not CPS/FPR service auth events.  Users are not able
**                      to close FPR stages because of open service auths in other
**                      stages.  This was an unexpected result of SIR 23538.
**  7/11/2005 dunawakl  SIR 23716 - Added Call to function that calls a DAM to
**                      check for open CRSR Guardianships.
**  7/29/2005 Nallavs   SIR 23821 - Added check for CRSR stage types and perform
**                      display of error page hyperlink accordingly
**  8/03/2005 dunawakl  SIR 23854 - Added check to guardianship edit
**                      check for letter issued value to ensure valid guardianship
**  8/15/2005 Nallavs   SIR 23661 -- Added message display in error list
**                      if ECS has been identified as an Action on
**                      the Outcome Matrix and the only ECS for the case
**                      is in PROC status then closure service delivery
**                      should display error message in error list
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/





public class Csvc16s {
    static final String POST_ADOPT1 = "PAD";
    static final String SUBCARE2 = "SUB";
    static final String PREP_ADULT1 = "PAL";
    static final String ADOPTION2 = "ADO";
    static final String INVESTIGATION2 = "INV";
    static final String ARI_STAGE1 = "ARI";
    static final String FPR_PROGRAM1 = "FPR";
    static final String FRE_PROGRAM1 = "FRE";
    static final String FSU_PROGRAM1 = "FSU";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /* Task codes and event related constants */
    public static final String INVESTIGATION_ACTION_TASK = "2210";
    public static final String SAFETY_EVAL_TASK = "2300";
    public static final String SVC_AUTH_APPROVAL_TASK = "3310";
    public static final String PENDING = "PEND";
    public static final String APPROVED = "APRV";
    public static final String NO_EVENT_TYPE = "";
    public static final String NO_TASK = "";
    public static final String INV_ACTION_EVENT_TYPE = "STG";
    public static final String SAFETY_EVAL_EVENT_TYPE = "ASM";
    public static final String SERVICE_AUTH = "AUT";
    public static final String SVC_REF_CHKLST_FPR_TASK = "2306";
    public static final String SVC_REF_CHKLST_EVENT_TYPE = "CHK";
    public static final String INVESTIGATION_STAGE = "INV";
    
    /* SIR 11788*/
    public static final String FORMER_DAY_CARE = "40M";
    
    /* Event and Stage info */
    public static final String CONTACTS_COMPLETE = "0";
    
    /* Function codes for Close or Submit action */
    public static final char ACTION_CODE_CLOSE = 'C';
    public static final char ACTION_CODE_SUBMIT = 'S';
    public static final String SVC_CD_STAGE_TYPE_CONTRACTED = "CON";
    public static final String SVC_CD_STAGE_TYPE_CON_INTENSIVE = "CINT";
    public static final String SVC_CD_STAGE_TYPE_CON_MODERATE = "CMOD";
    
    /************************************************************************
    **  SIR 1673: There should be no edits for Case Related Special Request
    **  Stage Types except to check for PENDING events.
    ************************************************************************/
    public static final String SVC_CD_STAGE_TYPE_CRSR = "C-";
    public static final int SVC_CD_STAGE_TYPE_CRSR_LEN = 2;
    
    /*
    ** SIR 1967 - macros needed for Approval event checks
    */
    public static final String APRV_REJECT = "REJT";
    public static final String APRV_INVALID = "INVD";
    public static final String EVENT_TYPE_APPROVAL = "APP";
    
    /* SIR 1888 added new event types */
    public static final String SVC_AUTH_EVENT_TYPE = "AUT";
    public static final String CVS_REMOVAL_EVENT_TYPE = "REM";
    
    public static final int INITIAL_PAGE = 1;
    
    /*
    ** SIR# 22190
    */
    public static final String PROGRESS = "PROC";
    public static final String NEW = "NEW";
    public static final String COMPLETE = "COMP";
    /*
    ** SIR# 21883
    */
    public static final String GUARDIANSHIP = "GUA";
    
    /* SIR 23538 */
    public static final String AOM_ACTION_LEGAL = "LEG";
    public static final String AOM_ACTION_ECS = "ECS";
    public static final String AOM_ACTION_COMMUNITY = "COM";
    public static final String PERSON_STAGE_ROLE_CL = "CL";
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final char SVC_VALIDATION = 'S';
    
    /* SIR 23716 */
    public static final String SVC_CD_STAGE_TYPE_CGUA = "C-GUA";
    public static final String SVC_CD_STAGE_TYPE_CREG = "C-REG";
    
    public static final String SVC_CD__GUARDIAN_TYPE_APS = "APS";
    public static final String SVC_CD__GUARDIAN_TYPE_CON = "CON";
    CSVC16SO CSVC16S(CSVC16SI csvc16si) {
        CSVC16SO csvc16so = new CSVC16SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/*SIR#1710*/
        
        
        int TempRowCtr = 0;
        int[] ulIdEvent32 = new int[CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE];
        Pint ulRowQtyEvent = new Pint();/*SIR#1888*/
        boolean bAPS = true;
        boolean bCPS = true;
        Pchar bGUA_Found = new Pchar();/* RIOSJA, SIR 19049*/
        bGUA_Found.value = 0;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#2426 */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#2426 */
        CLSS30DI pCLSS30DInputRec = null;/* RIOSJA, SIR 22970 */
        CLSS30DO pCLSS30DOutputRec = null;/* RIOSJA, SIR 22970 */
        boolean bOpenInvStageFound = false;/* RIOSJA, SIR 22970 */
        
        
        
        /*
        ** 22190 - Added declaration of output structures for CallServiceAuth
        */
        CCMN87DO pDAM87Out = null;
        
        /* Send Notification to Worker  */
        rc = ARC_PRFServiceStartTime_TUX(csvc16si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /**************************************************************************
        ** SIR#1710
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csvc16si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN06UInputRec.setUlIdStage(csvc16si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csvc16si.getSzCdTask());
        /* Capture Supervisor's ID into locally declared 2nd parameter */
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                break;// Break for success of cinv51d (CL)
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;// break for SQL_NOT_FOUND for CINV51D(VP)
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;// break for SQL_NOT_FOUND for CINV51D(VC)
                // /*
                // default for CINV51D(VC)
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;// break for success to CSES06D
        }
        if (SUCCESS == RetVal) {
            if (0 == csvc16si.getSzCdStage().compareTo(SVC_CD_STAGE_CPS_SVC)) {
                bAPS = false;
            }
            else {
                bCPS = false;
            }
            
            // SIR 15078 -- If the ALOC is not ONE, TWO, or BASIC, that means
            // It is greater than those values, so call CLSS46 to retrieve
            // Child-Placement Characteristics
            if (0 == csvc16si.getSzCdStageType().compareTo(GUARDIANSHIP)) {
                csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(csvc16so.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_OPEN_APS_CON_GUA);
                csvc16so.getCINV59SOG01().ulRowQty++;
            }
            if (0 == csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                
                rc = CallCSVC49D(csvc16si, csvc16so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
            if ((0 == csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CONTRACTED)) || (0 == csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CON_INTENSIVE)) || (0 == csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CON_MODERATE))) {
                
                //  Although this if statement should only be true if lrc < 0,
                // it should also be true when dtDtPlocEnd is MaxDt. Because
                // Foundation reads MaxDt as -1/-1/-1, the lrc will be POSITIVE.
                // Unless the lrc = 0, it should perform the following processing.
                if (0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_DIED)) {
                    rc = CallCSVC20D(csvc16si, csvc16so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            
            // 
            // SIR 1673: There should be no edits for Case Related Special
            // Request Stage Types
            // SIR 1883 - or if the reason closed is SVC_CLOSE_WKLD_CONSTRAINTS
            // or SVC_CLOSE_ADMIN_CLOSURE_CPS
            // except to check for PENDING events.
            // 
            else if ((0 != csvc16si.getSzCdStageType().substring(0, SVC_CD_STAGE_TYPE_CRSR_LEN).compareTo(SVC_CD_STAGE_TYPE_CRSR.substring(0, SVC_CD_STAGE_TYPE_CRSR_LEN))) && (0 != csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_WKLD_CONSTRAINTS)) && (0 != csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_ADMIN_CLOSURE_CPS))) {
                
                // SIR#3573: Modify ARC_FRMGetDecode
                // FRMGetDecode is called to retrieve the
                // PLCMT_CODES_TABLE that is linked to the LocAndType.
                // ARC_FRMGetDecode has been changed to ServerSide ARC_UTL
                // Parameters: Decode,Code,CodeLength,CodeTableName
                // SIR#15787. If date of service is after 9/1/2001
                if (bCPS) {
                    rc = CallCSVC19D(csvc16si, SVC_CD_CONTACT_TYPE_FPR_CLOSE, csvc16so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    if (FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_RECORD_DEATH]) {
                        
                        // Send Notification to Supervisor
                        rc = CallCSVC20D(csvc16si, csvc16so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                if (bAPS) {
                    //  RIOSJA, SIR 22970 - Verify that there are no open INV stages,
                    // which can happen with Case Merge. If there are, the worker
                    // cannot close the SVC stage before closing the INV stage.
                    pCLSS30DInputRec = new CLSS30DI();
                    
                    pCLSS30DOutputRec = new CLSS30DO();
                    pCLSS30DInputRec.setArchInputStruct(csvc16si.getArchInputStruct());
                    pCLSS30DInputRec.setUlIdCase(csvc16si.getUlIdCase());
                    //SIR 23334- Save Rejection to APPROVAL_REJECTION table
                    rc = Ccmn02u.CallCLSS30D(pCLSS30DInputRec, pCLSS30DOutputRec, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (int j = 0;j < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty() && bOpenInvStageFound == false;j++) {
                        
                        // SIR#3582: if fost_adopt, check Living Arrangement
                        if (((DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year && DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day && DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month) || DateHelper.ARC_MAX_YEAR == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && 0 == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(INVESTIGATION_STAGE) && pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getUlIdStage() != csvc16si.getUlIdStage()) {
                            bOpenInvStageFound = true;
                            csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(csvc16so.getCINV59SOG01().ulRowQty, Messages.MSG_OPEN_INV_STAGE_FOUND);
                            csvc16so.getCINV59SOG01().ulRowQty++;
                        }
                    }
                    bGUA_Found.value = 0;
                    //End save Rejection
                    
                    
                    // Update the Event Status (Intervening Update Strategy)
                    rc = CallCLSCB6D(csvc16si, bGUA_Found, pServiceStatus);
                    if (!(bGUA_Found.value != 0) && (FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_AOM_ACTION_OUTCOME] || FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_AOM_ACTION] || FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_CLIENT_DIED] || FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_NO_RESOURCES] || FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_AGENCY_REFERRAL] || FND_YES == csvc16si.getSzDcdEditProcess()[(int) SVC_EDIT_UNABLE_LOCATE])) {
                        // SIR 23530 - get outcome matrix event id - there should only be one
                        int[] ulIdAOMEvent = new int[CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE];
                        pDAM87Out = new CCMN87DO();
                        
                        // Save the Approval Determination
                        rc = CallCCMN87D(csvc16si, SVC_CD_EVENT_TYPE_AOM, pDAM87Out, ulRowQtyEvent, ulIdAOMEvent, pServiceStatus);
                        
                        // Invalidate all other Approvers
                        rc = Cinv20s.CallCINV96D(csvc16si, csvc16so, ulIdAOMEvent[0], pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                            case Messages.MSG_NO_ROWS_RETURNED:
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                    }
                }
            }
            
            // Get list of related Events
            rc = Cinv15s.CallServiceAuth(csvc16si, csvc16so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            if (FND_YES == csvc16si.getSzDcdEditProcess()[(int) CVS_REMOVAL_EDIT]) {
                //  SIR 12741 - Allocate and initialize memory for call
                // to ccmn87d.
                pDAM87Out = new CCMN87DO();
                
                
                
                // Demote related Events
                rc = CallCCMN87D(csvc16si, CVS_REMOVAL_EVENT_TYPE, pDAM87Out, ulRowQtyEvent, ulIdEvent32, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;// break for success of CCMN44
                    case NO_DATA_FOUND:
                        csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(csvc16so.getCINV59SOG01().ulRowQty, Messages.MSG_OPEN_SUBCARE_STAGE);
                        csvc16so.getCINV59SOG01().ulRowQty++;
                        break;
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            //  SIR#23112: if the date is greater than or equal to 09/01/04 use
            // New code, otherwise use old codes
            if (!(csvc16so.getCINV20SOG01().getUlRowQty() != 0)) {
                if (ACTION_CODE_SUBMIT == csvc16si.getArchInputStruct().getCReqFuncCd()) {
                    TempRowCtr = csvc16so.getCINV59SOG01().ulRowQty;
                    
                    // Delete the Todo
                    rc = CallCSVC28D(csvc16si, SVC_CD_EVENT_STATUS_PENDING, csvc16so, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            csvc16so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(csvc16so.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_EVENT_PENDING);
                            csvc16so.getCINV59SOG01().ulRowQty++;
                            break;// break for success to CSES06D
                        case Messages.MSG_NO_ROWS_RETURNED:
                            
                            // SIR#21325: Set Ind to YES if not BLOC of ONE
                            if (bAPS) {
                                if (!(csvc16so.getCINV20SOG01().getUlRowQty() != 0) && (0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_DIED) || 0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_UNABLE_TO_LOCATE) || 0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_WITHDREW) || 0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_ADMIN_CLOSURE))) {
                                    
                                    rc = CallCSVC26D(csvc16si, csvc16so, pServiceStatus);
                                    switch (rc) {
                                            
                                        case Messages.MSG_CMN_UPDATE_FAILED:
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    }
                                    //  SIR#23112: if the date is greater than or equal to 09/01/04 use
                                    // New code, otherwise use old codes
                                    if (0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                                        rc = CallCSVC27D(csvc16si, csvc16so, pServiceStatus);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case Messages.MSG_NO_ROWS_RETURNED:
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                break;// break for success of CINT21D
                                            case Messages.MSG_CMN_UPDATE_FAILED:
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        }
                                    }
                                }
                            }
                            
                            
                            if (bCPS) {
                                
                                // SIR#3573: Modify ARC_FRMGetDecode
                                // FRMGetDecode is called to retrieve the
                                // PLCMT_CODES_TABLE that is linked to the LocAndType.
                                // ARC_FRMGetDecode has been changed to
                                // ServerSide ARC_UTLGetDecode.
                                // Parameters: Decode,Code,CodeLength,CodeTableName
                                // SIR#15787. If date of service is after 9/1/2001
                                if ((0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CONTRACTED)) && (0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CON_INTENSIVE)) && (0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CON_MODERATE)) && (0 != csvc16si.getSzCdStageType().substring(0, SVC_CD_STAGE_TYPE_CRSR_LEN).compareTo(SVC_CD_STAGE_TYPE_CRSR.substring(0, SVC_CD_STAGE_TYPE_CRSR_LEN))) && (0 != csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_WKLD_CONSTRAINTS)) && (0 != csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_ADMIN_CLOSURE_CPS))) {
                                    rc = CallCSVC19D(csvc16si, SVC_CD_CONTACT_TYPE_FPR_MNTH, csvc16so, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                
                                // Send Notification to Worker
                                rc = CallCSESA3D(csvc16si, csvc16so, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        break;
                                        
                                        //  WANGSS 2/12/96
                                        // SQL_NOT_FOUND is a normal process in this
                                        // situation.  A facility loc row does not necessarily
                                        // have to exist for the resource.
                                        // NOTE:  A facility loc row will exist if the FA Home
                                        // Status is Pending Approval and a Foster Type has
                                        // been changed.
                                    case NO_DATA_FOUND:
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                            }
                            if (TempRowCtr == csvc16so.getCINV59SOG01().ulRowQty) {
                                // Capture Supervisor's ID into locally declared 2nd parameter
                                rc = CallCSVC28D(csvc16si, SVC_CD_EVENT_STATUS_COMPLETE, csvc16so, pServiceStatus);
                                
                                //  Analyze error code
                                switch (rc) {
                                    case Messages.MSG_NO_ROWS_RETURNED:
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        break;
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                
                                rc = CallCSVC28D(csvc16si, SVC_CD_EVENT_STATUS_PROCESS, csvc16so, pServiceStatus);
                                
                                //  Analyze error code
                                switch (rc) {
                                    case Messages.MSG_NO_ROWS_RETURNED:
                                        rc = SUCCESS;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                if (ACTION_CODE_CLOSE == csvc16si.getArchInputStruct().getCReqFuncCd()) {
                    
                    // SIR#3582: if fost_adopt, check Living Arrangement
                    if (!(csvc16so.getCINV20SOG01().getUlRowQty() != 0) && (0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_DIED) || 0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_UNABLE_TO_LOCATE) || 0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_WITHDREW) || 0 == csvc16si.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_ADMIN_CLOSURE))) {
                        rc = CallCSVC26D(csvc16si, csvc16so, pServiceStatus);
                        
                        //  Analyze error code
                        switch (rc) {
                            case Messages.MSG_CMN_UPDATE_FAILED:
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        if (0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != csvc16si.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                            
                            // Send Notification to Supervisor
                            rc = CallCSVC27D(csvc16si, csvc16so, pServiceStatus);
                            switch (rc) {
                                    
                                    //  SIR 21003 - Changed error processing of cses80d
                                    // to allow sql-not-found because that is an
                                    // acceptible condition.  It should not "blow-up"
                                    // at this point.
                                case Messages.MSG_NO_ROWS_RETURNED:
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    break;
                                    
                                    
                                case Messages.MSG_CMN_UPDATE_FAILED:
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    // TLC 06/25/97 We need a break here
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                        }
                    }
                    // Retrieve Home status
                    rc = CallCSVC28D(csvc16si, SVC_CD_EVENT_STATUS_COMPLETE, csvc16so, pServiceStatus);
                    switch (rc) {
                        case Messages.MSG_NO_ROWS_RETURNED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    rc = CallCSVC28D(csvc16si, SVC_CD_EVENT_STATUS_PROCESS, csvc16so, pServiceStatus);
                    
                    //  Analyze error code
                    switch (rc) {
                        case Messages.MSG_NO_ROWS_RETURNED:
                            
                            rc = SUCCESS;
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    // Update the Event Status (Intervening Update Strategy)
                    rc = Cinv20s.CloseStage(csvc16si, csvc16so, pServiceStatus);
                    switch (rc) {
                        case Messages.MSG_NO_ROWS_RETURNED:
                            
                            //  Set explan_data to usRow
                            // Note: Use sprintf
                            
                            
                            break;
                            
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            
                            break;
                            
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
        }
        
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(csvc16si.getArchInputStruct() , csvc16so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            // Save the Approval Determination
            rc = SUCCESS;
        }
        /*
        ** SIR#23112: if the date is greater than or equal to 09/01/04 use
        ** New code, otherwise use old codes
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                // Get list of related Events
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csvc16so;
    }

    
    static int CallCSESA3D(CSVC16SI pInputMsg851, CSVC16SO pOutputMsg796, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSESA3DI pCSESA3DInputRec = null;
        CSESA3DO pCSESA3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSESA3DInputRec = new CSESA3DI();
        
        pCSESA3DOutputRec = new CSESA3DO();
        
        pCSESA3DInputRec.setUlIdStage(pInputMsg851.getUlIdStage());
        pCSESA3DInputRec.setSzCdEventType(SVC_REF_CHKLST_EVENT_TYPE);
        pCSESA3DInputRec.setSzCdTask(SVC_REF_CHKLST_FPR_TASK);
        
        /* SIR 15049 */
        pCSESA3DInputRec.setArchInputStruct(pInputMsg851.getArchInputStruct());
        rc = csesa3dQUERYdam(sqlca, pCSESA3DInputRec, pCSESA3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (0 != strncmp(pCSESA3DOutputRec.getSzCdEventStatus() , COMPLETE, COMPLETE.length()) && (pInputMsg851.getArchInputStruct().getUlSysNbrReserved1() != true || 0 != strncmp(pCSESA3DOutputRec.getSzCdEventStatus() , PENDING, PENDING.length()))) {
                    pOutputMsg796.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg796.getCINV59SOG01().ulRowQty, Messages.MSG_INV_SVC_RFRL_CHKLST_WARNING);
                    pOutputMsg796.getCINV59SOG01().ulRowQty++;
                }
                break;
            case NO_DATA_FOUND:
                pOutputMsg796.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg796.getCINV59SOG01().ulRowQty, Messages.MSG_INV_SVC_RFRL_CHKLST_WARNING);
                pOutputMsg796.getCINV59SOG01().ulRowQty++;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC19D(CSVC16SI pInputMsg852, String szCdContactType1, CSVC16SO pOutputMsg797, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC19DI pCSVC19DInputRec = null;
        CSVC19DO pCSVC19DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC19DInputRec = new CSVC19DI();
        pCSVC19DOutputRec = new CSVC19DO();
        pCSVC19DInputRec.setUlIdStage(pInputMsg852.getUlIdStage());
        pCSVC19DInputRec.setSzCdContactType(szCdContactType1);
        pCSVC19DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_APPR);
        
        if (0 == SVC_CD_CONTACT_TYPE_FPR_CLOSE.compareTo(szCdContactType1)) {
            pCSVC19DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        rc = csvc19dQUERYdam(sqlca, pCSVC19DInputRec, pCSVC19DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                if (0 == szCdContactType1.compareTo(SVC_CD_CONTACT_TYPE_FPR_CLOSE) && 0 != pInputMsg852.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != pInputMsg852.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                    
                    pOutputMsg797.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg797.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_CLOSE_SUMMARY);
                    pOutputMsg797.getCINV59SOG01().ulRowQty++;
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC20D(CSVC16SI pInputMsg853, CSVC16SO pOutputMsg798, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC20DI pCSVC20DInputRec = null;
        CSVC20DO pCSVC20DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC20DInputRec = new CSVC20DI();
        pCSVC20DOutputRec = new CSVC20DO();
        pCSVC20DInputRec.setUlIdStage(pInputMsg853.getUlIdStage());
        
        /* SIR 15346
        ** pOutputMsg->dtDtSvcAuthDtlEnd =
        **            pCSECA3DOutputRec->dtDtSvcAuthDtlEnd;
        */
        
        rc = csvc20dQUERYdam(sqlca, pCSVC20DInputRec, pCSVC20DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (0 != pCSVC20DOutputRec.getUlIdPerson()) {
                    pOutputMsg798.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg798.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_RECORD_DEATH);
                    pOutputMsg798.getCINV59SOG01().ulRowQty++;
                }
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC26D(CSVC16SI pInputMsg854, CSVC16SO * pOutputMsg799, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC26DI pCSVC26DInputRec = null;
        CSVC26DO pCSVC26DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC26DInputRec = new CSVC26DI();
        pCSVC26DOutputRec = new CSVC26DO();
        pCSVC26DInputRec.setUlIdSituation(pInputMsg854.getUlIdSituation());
        
        
        /*
        ** SIR 22097 - removed logic to send the todo if the child
        ** is placed in a for-profit facility.
        **
        ** if ((INDICATOR_YES== pInputMsg->SysIndNewActualPlcmt)
        **     &&(INDICATOR_YES== pInputMsg->cSysIndPlcmtFacilProf))
        ** {
        **    ToDoFlags[SUB033] = TRUE;
        ** }
        **
        ** if ((INDICATOR_YES== pInputMsg->SysIndNewActualPlcmt)
        **    && (INDICATOR_YES== pInputMsg->cSysIndPlcmtFacilProf)
        **     && (0 < ulIdEligibilityWorker))
        ** {
        **    ToDoFlags[SUB034] = TRUE;
        ** }
        */
        
        if (0 == pInputMsg854.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_DIED)) {
            pCSVC26DInputRec.setSzCdStageReasonClosed(SVC_CD_CLIENT_DIED);
        }
        
        if (0 == pInputMsg854.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_UNABLE_TO_LOCATE)) {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pCSVC26DInputRec.setSzCdStageReasonClosed(SVC_CD_UNABLE_TO_LOCATE);
        }
        
        /*
        ** SIR 3577
        ** 0 or 1 rows returned from NbrStageOpen is OK
        */
        if (0 == pInputMsg854.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_CLIENT_WITHDREW)) {
            pCSVC26DInputRec.setSzCdStageReasonClosed(SVC_CD_CLIENT_WITHDREW);
        }
        
        if (0 == pInputMsg854.getSzCdStageReasonClosed().compareTo(SVC_CLOSE_ADMIN_CLOSURE)) {
            pCSVC26DInputRec.setSzCdStageReasonClosed(SVC_CD_ADMIN_CLOSURE);
        }
        rc = ARC_UTLGetDateAndTime(pCSVC26DInputRec.getDtDtApsOutcomeRecord() , 0);
        
        /*
        ** SIR#3949: use Recruiter until we figure out what
        ** a ulIdAdoptSubWorker actually does
        */
        if (WtcHelperConstants.ARC_SUCCESS != rc) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCSVC26DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CCMN44D
        */
        rc = csvc26dAUDdam(sqlca, pCSVC26DInputRec, pCSVC26DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                // 
                // (END): Retrieve DAM: ccmn44d     
                // Get NmPersonFull given IdPerson
                // 
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                //  Call CINV51D
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC27D(CSVC16SI pInputMsg855, CSVC16SO * pOutputMsg800, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC27DI pCSVC27DInputRec = null;
        CSVC27DO pCSVC27DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC27DInputRec = new CSVC27DI();
        pCSVC27DOutputRec = new CSVC27DO();
        pCSVC27DInputRec.setUlIdStage(pInputMsg855.getUlIdStage());
        pCSVC27DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_COMPLETE);
        pCSVC27DInputRec.setSzCdEventType(SVC_CD_EVENT_TYPE_AOM);
        pCSVC27DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        
        /*
        ** Call CSES57D
        */
        rc = csvc27dAUDdam(sqlca, pCSVC27DInputRec, pCSVC27DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                
                //  Call CAUD76D
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC28D(CSVC16SI pInputMsg856, String szCdEventStatus1, CSVC16SO pOutputMsg801, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;
        int usEventCtr = 0;/* Row counter */
        int i441 = 0;
        
        /*
        ** Declare local variables
        */
        CSVC28DI pCSVC28DInputRec = null;
        CSVC28DO pCSVC28DOutputRec = null;
        
        /*
        ** SIR 1967 - Added declaration of input/output structures for DAM
        ** CCMN56D, a boolean flag andnd another counter
        */
        CCMN56DI pDAM56In = null;
        CCMN56DO pDAM56Out = null;
        int uCount = 0;
        boolean bFound = false;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC28DInputRec = new CSVC28DI();
        pCSVC28DOutputRec = new CSVC28DO();
        
        /*
        ** SIR 1967 - Added memory allocation for CCMN56D input/output
        ** structures
        */
        pDAM56In = new CCMN56DI();
        
        pDAM56Out = new CCMN56DO();
        pDAM56In.setArchInputStruct(pInputMsg856.getArchInputStruct());
        pDAM56In.getArchInputStruct().setUsPageNbr(1);
        pDAM56In.getArchInputStruct().setUlPageSizeNbr(CCMN56DO._CCMN56DO__ROWCCMN56DO_SIZE);
        pCSVC28DInputRec.setArchInputStruct(pInputMsg856.getArchInputStruct());
        pCSVC28DInputRec.setUlIdStage(pInputMsg856.getUlIdStage());
        pCSVC28DInputRec.setSzCdEventStatus(szCdEventStatus1);
        pCSVC28DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCSVC28DInputRec.getArchInputStruct().setUlPageSizeNbr(CSVC16SO._CSVC16SO__CINV20SOG00_SIZE);
        rc = csvc28dQUERYdam(sqlca, pCSVC28DInputRec, pCSVC28DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate the Output message with the number of ID events
                // retrieved for truncation.  PWO 1264
                
                // 
                // SIR 1830: When Closing a stage or Submitting a
                // Closure for Approval, all the IN PROGRESS "PROC"
                // events should also be updated to approved "APRV" for
                // closing and pending "PEND" for submitting.
                // Added a second call to DAM CSVC28D pasing event
                // status of IN PROGRESS instead of COMPLETE.
                // Added row counter and Addition statement, to append
                // the PROC event list to the COMP event list within
                // the CALLCSVC28D function.
                // 
                
                usEventCtr = 0;
                
                if (0 == SVC_CD_EVENT_STATUS_PROCESS.compareTo(szCdEventStatus1)) {
                    usEventCtr = pOutputMsg801.getArchOutputStruct().getUlRowQty();
                    pOutputMsg801.getArchOutputStruct().setUlRowQty(pCSVC28DOutputRec.getArchOutputStruct().getUlRowQty() + pOutputMsg801.getArchOutputStruct().getUlRowQty());
                }
                else {
                    pOutputMsg801.getArchOutputStruct().setUlRowQty(pCSVC28DOutputRec.getArchOutputStruct().getUlRowQty());
                }
                
                //  Populate Output Message if event list requested
                // "i" is the index used to access all of the rows returned from
                // the DAM. It increments through each iteration of the loop.
                // "usEventCtr" is the index used to access all the rows to be
                // returned from the service to the window. It increments only
                // when an ID EVENT is added to the output message.
                // "pCSVC28DOutputRec->ArchOutputStruct.ulRowQty" is the number
                // of rows returned from the DAM.
                // "pOutputMsg->ArchOutputStruct.ulRowQty" is the number of rows
                // returned from the service to the window. It is set in the
                // if-statement above, but is decremented in the if-statement
                // below when necessary.
                for (i441 = 0;((i441 < pCSVC28DOutputRec.getArchOutputStruct().getUlRowQty()) && (usEventCtr < pOutputMsg801.getArchOutputStruct().getUlRowQty()));i441++) {
                    
                    if ((0 == pInputMsg856.getSzCdStage().compareTo(SVC_CD_STAGE_CPS_SVC)) && (0 == pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getSzCdEventType().compareTo(EVENT_TYPE_APPROVAL)) && (0 == szCdEventStatus1.compareTo(SVC_CD_EVENT_STATUS_COMPLETE))) {
                        pDAM56In.setUlIdApproval(pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getUlIdEvent());
                        rc = Ccmn19s.CallCCMN56D(pDAM56In, pDAM56Out, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        //  Cycle through all rows returned from CCMN56D looking
                        // for an approver status of rejected or invalid.  If
                        // one is found, add that event to the service output
                        // message, otherwise decrement the number of rows
                        // being returned.
                        while ((!bFound) && (null != pDAM56Out.getROWCCMN56DO_ARRAY().getROWCCMN56DO(uCount).getSzCdApproversStatus()[0]) && (uCount < pDAM56Out.getArchOutputStruct().getUlRowQty())) {
                            
                            if ((0 == APRV_REJECT.compareTo(pDAM56Out.getROWCCMN56DO_ARRAY().getROWCCMN56DO(uCount).getSzCdApproversStatus())) || (0 == APRV_INVALID.compareTo(pDAM56Out.getROWCCMN56DO_ARRAY().getROWCCMN56DO(uCount).getSzCdApproversStatus()))) 
                            {
                                bFound = true;
                            }
                            uCount++;
                        }
                        if (bFound) {
                            pOutputMsg801.getCINV20SOG00_ARRAY().getCINV20SOG00(usEventCtr++).setUlIdEvent(pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getUlIdEvent());
                        }
                        
                        else {
                            pOutputMsg801.getArchOutputStruct().getUlRowQty()--;
                        }
                    }
                    else if (!(((0 == pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getSzCdEventType().compareTo(SERVICE_AUTH)) && ((0 == pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getSzCdEventStatus().compareTo(PROGRESS)) || (0 == pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getSzCdEventStatus().compareTo(NEW)) || (0 == pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getSzCdEventStatus().compareTo(COMPLETE)))) || (0 == pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getSzCdTask().compareTo(SVC_AUTH_APPROVAL_TASK)))) {
                        
                        pOutputMsg801.getCINV20SOG00_ARRAY().getCINV20SOG00(usEventCtr++).setUlIdEvent(pCSVC28DOutputRec.getROWCSVC28DO_ARRAY().getROWCSVC28DO(i441).getUlIdEvent());
                    }
                    else {
                        pOutputMsg801.getArchOutputStruct().getUlRowQty()--;
                    }
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                
            case NO_DATA_FOUND:
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
        }
        return rc;
    }

    static int CallCINV96D(CSVC16SI pInputMsg857, CSVC16SO pOutputMsg802, int ulIdAOMEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV96DI pCINV96DInputRec = null;
        CINV96DO pCINV96DOutputRec = null;
        int ulTempIdStage = 0;
        int i442 = 0;
        boolean bNoReferral = true;
        boolean bNoResource = true;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV96DInputRec = new CINV96DI();
        pCINV96DOutputRec = new CINV96DO();
        pCINV96DInputRec.setUlIdEvent(ulIdAOMEvent);
        pCINV96DInputRec.getArchInputStruct().setCReqFuncCd(SVC_VALIDATION);
        pCINV96DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINV96DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV96DO._CINV96DO__ROWCINV96DO_SIZE);
        rc = cinv96dQUERYdam(sqlca, pCINV96DInputRec, pCINV96DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Set Calculated Retention date to maximum date
                if (FND_YES == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_AOM_ACTION_OUTCOME]) {
                    for (i442 = 0;i442 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();i442++) 
                    {
                        
                        if ((0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG)) || (0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA))) {
                            
                            //  Set Calculated Retention date to maximum date
                            if (pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i442).getSzCdApsOutcomeResult()[0] == null) {
                                pOutputMsg802.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg802.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_PROB_ACTION_OUTCOME);
                                pOutputMsg802.getCINV59SOG01().ulRowQty++;
                                break;
                            }
                        }
                    }// cses01d
                }
                
                if (FND_YES == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_AOM_ACTION]) {
                    for (i442 = 0;i442 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();i442++) {
                        
                        //  Set Calculated Retention date to maximum date
                        if (0 == pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i442).getSzCdApsOutcomeAction().compareTo(0) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                            pOutputMsg802.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg802.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_PROB_ACTION);
                            pOutputMsg802.getCINV59SOG01().ulRowQty++;
                            break;
                        }
                    }
                }
                
                if (0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                    
                    //  Determine whether Category is Foster
                    if (FND_YES == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_CLIENT_DIED]) {
                        for (i442 = 0;i442 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();i442++) {
                            
                            //  For Count > 0, code is CODE_FOSTER_ADOPTIVE
                            if (0 == pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i442).getSzCdApsOutcomeResult().compareTo(SVC_CD_CLIENT_DIED)) {
                                pOutputMsg802.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg802.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_CLIENT_DIED);
                                pOutputMsg802.getCINV59SOG01().ulRowQty++;
                                break;
                            }
                        }
                    }
                }
                
                //  Set Calculated Retention date to maximum date
                if (0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                    
                    if (FND_YES == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_NO_RESOURCES]) 
                    {
                        for (i442 = 0;i442 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();i442++) {
                            
                            //  Set Calculated Retention date to maximum date
                            if (0 == pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i442).getSzCdApsOutcomeResult().compareTo(SVC_CD_NO_AVAILABLE_RESOURCES)) {
                                bNoResource = false;
                                break;
                            }
                        }
                        
                        if (bNoResource) {
                            pOutputMsg802.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg802.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_NO_RESOURCES);
                            pOutputMsg802.getCINV59SOG01().ulRowQty++;
                        }
                    }
                }
                
                //  For Count > 0, code is AHA or AHR
                if (0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                    
                    //  Check if count from CSEC70D returned > 0
                    if (FND_YES == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_AGENCY_REFERRAL]) {
                        
                        for (i442 = 0;i442 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();i442++) 
                        {
                            
                            //  Set Calculated Retention date to maximum date
                            if (0 == pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i442).getSzCdApsOutcomeResult().compareTo(SVC_CD_REFERRED_OTHER_AGENCY)) {
                                bNoReferral = false;
                                break;
                            }
                        }
                        
                        if (bNoReferral) {
                            pOutputMsg802.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg802.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_OTHER_AGENCY);
                            pOutputMsg802.getCINV59SOG01().ulRowQty++;
                        }
                    }
                }
                
                //  Set Calculated Retention date to maximum date
                if (FND_NO == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_CLIENT_DIED]) 
                {
                    for (i442 = 0;i442 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();i442++) {
                        
                        if (0 == pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i442).getSzCdApsOutcomeResult().compareTo(SVC_CD_UNABLE_TO_LOCATE) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) && 0 != pInputMsg857.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                            pOutputMsg802.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg802.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_UNABLE_LOCATE);
                            pOutputMsg802.getCINV59SOG01().ulRowQty++;
                            break;
                        }
                    }
                }
                
                if (FND_NO == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_UNABLE_LOCATE] && FND_YES == pInputMsg857.getSzDcdEditProcess()[(int) SVC_EDIT_CLIENT_DIED]) {// CMSC52D.PC  QUICK_WIN BEGINS
                    CheckAOMActions(pInputMsg857, pOutputMsg802, pCINV96DOutputRec, pServiceStatus);
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                //  Call CloseStageCase
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CloseStage(CSVC16SI pInputMsg858, CSVC16SO pOutputMsg803, Arcxmlerrors.TUX_DECL_STATUSPARMS) {/* if service code is a adoptive code */
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        rc = Ccmn05u.CallCCMN62D(pInputMsg858, pOutputMsg803, pServiceStatus);
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        
        /*
        ** Allocate memory for CloseStageCase Input
        ** and Output Structures
        */
        pCCMN02UInputRec = new CCMN02UI();
        
        pCCMN02UOutputRec = new CCMN02UO();
        pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(pInputMsg858.getUlIdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(pInputMsg858.getSzCdStage());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(pInputMsg858.getSzCdStageProgram());
        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(pInputMsg858.getSzCdStageReasonClosed());
        rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call CAUD08D The Contract County AUD performs a full row insert,
                // update or delete to the Contract County table.
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN62D(CSVC16SI * pInputMsg859, CSVC16SO pOutputMsg804, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        int usEventCtr = 0;
        /*
        ** Declare local variables
        */
        /* The ARC_SUCCESS initializtion has been added to the following line
        ** so that the logic relevant exiting out of the loop in this function
        ** will work correctly.
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        
        /*
        ** Loop through Service Delivery Events, changing status to Approved
        */
        for (usEventCtr = 0;usEventCtr < pOutputMsg804.getArchOutputStruct().getUlRowQty();usEventCtr++) {
            pCCMN62DInputRec.setUlIdEvent(pOutputMsg804.getCINV20SOG00_ARRAY().getCINV20SOG00(usEventCtr).getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_APPR);
            pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Call CINV51D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN56D(CCMN56DI pInputMsg860, CCMN56DO pOutputMsg805, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i443 = 0;
        
        
        /*
        ** Call CRES03D
        */
        rc = ccmn56dQUERYdam(sqlca, pInputMsg860, pOutputMsg805);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                //  Set rc to ARC_SUCCESS
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                break;
        }
        return rc;
    }

    
    static int CallServiceAuth(CSVC16SI pInputMsg861, CSVC16SO pOutputMsg806, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        public public public public public public public public public int lRC13 = 0;
        FndInt3date DtTempStageStart = null;
        boolean bSvcAuthsToProgress = false;
        boolean bEligibleStageFound = false;
        DtTempStageStart.day = DateHelper.NULL_DATE;
        DtTempStageStart.month = DateHelper.NULL_DATE;
        DtTempStageStart.year = DateHelper.NULL_DATE;
        int i444 = 0;
        int j = 0;
        int rc = 0;/* Return code */
        
        Pint ulRowQtyEvent = new Pint();
        Pint ulRowQtySvcAuthDetail = new Pint();
        int[] ulIdEvent33 = new int[CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE];
        Pint ulIdSvcAuth9 = new Pint();
        
        FndInt3date[] dtSvcAuthDtlTermDate = new FndInt3date[CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE];
        
        /*
        ** Check the Term Date to make sure it
        ** isn't greater than the current date.
        */
        for (int dtSvcAuthDtlTermDate1 = 0;dtSvcAuthDtlTermDate1 < dtSvcAuthDtlTermDate.length;dtSvcAuthDtlTermDate1++) {
            dtSvcAuthDtlTermDate[dtSvcAuthDtlTermDate1] = new FndInt3date();
        }
        FndInt3date dtCurrentDate = null;
        
        char bPassedSvcAuthEdit = 1;
        char bLastStage = 0;
        
        /*
        ** 22190 - Added declaration of output structures for CallServiceAuth
        */
        CCMN87DO pDAM87Out = null;
        
        /*
        ** 11788 - Added declaration of output structures for CallServiceAuth
        */
        CLSS24DO pDAM24Out = null;
        
        /*
        ** SIR 20085
        ** Declare and initialize all locally used dam i/o's
        */
        CSES24DI CSES24DI = null;
        CSES24DO CSES24DO = null;
        CLSS24DI CLSS24DI = null;
        /*_CLSS24DO   Clss24do;sir 11788 */
        CCMN87DI CCMN87DI = null;
        /*_CCMN87DO   Ccmn87do;22190*/
        CCMNF6DI CCMNF6DI = null;
        CCMNF6DO CCMNF6DO = null;
        CCMNB6DI CCMNB6DI = null;
        CCMNB6DO CCMNB6DO = null;
        
        /* RIOSJA, SIR 19973 */
        CLSS30DI CLSS30DI = null;
        CLSS30DO CLSS30DO = null;
        
        /*
        ** 22190  Add memory allocation for CCMN87DO input/output structures
        */
        pDAM87Out = new CCMN87DO();
        
        /*
        ** 11788  Add memory allocation for CLSS24DO input/output structures
        */
        pDAM24Out = new CLSS24DO();
        CCMNB6DI.setArchInputStruct(pInputMsg861.getArchInputStruct());
        CCMNB6DI.setUlIdStage(pInputMsg861.getUlIdStage());
        rc = Cinv08s.CallCCMNB6D(CCMNB6DI, CCMNB6DO, pServiceStatus);
        
        CCMNF6DI.setArchInputStruct(pInputMsg861.getArchInputStruct());
        CCMNF6DI.setUlIdCase(CCMNB6DO.getUlIdCase());
        rc = Ccmn02u.CallCCMNF6D(CCMNF6DI, CCMNF6DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (1 == CCMNF6DO.getArchOutputStruct().getUlRowQty()) {
            bLastStage = 1;
        }
        
        /* populate CurrentDate variable with current date */
        ARC_UTLGetDateAndTime(dtCurrentDate, 0);
        
        /*
        ** Call InvalidateApproval Common Function
        */
        rc = CallCCMN87D(pInputMsg861, SVC_AUTH_EVENT_TYPE, pDAM87Out, ulRowQtyEvent, ulIdEvent33, pServiceStatus);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (!bLastStage) {
                    //  SIR #21883 - Open SVC Auth with end date in future.
                    // Variable Ccmn87do.ArchOutputStruc.ulRowQty is being
                    // replace with a local variable ulRowQtyEvent in for
                    // loop where bPassedSvcAuthEdit == TRUE.
                    for (i444 = 0;i444 < ulRowQtyEvent.value;i444++) {
                        if ((0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(COMPLETE)) || (0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(PENDING)) || (0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(APPROVED))) {
                            if (!(bPassedSvcAuthEdit != 0)) {
                                break;
                            }
                            rc = Ccmn35s.CallCSES24D(pInputMsg861, ulIdEvent33[i444], ulIdSvcAuth9, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    rc = Cinv20s.CallCLSS24D(pInputMsg861, pDAM24Out, ulIdSvcAuth9.value, ulRowQtySvcAuthDetail, dtSvcAuthDtlTermDate, pServiceStatus);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            //  Check Term date to make sure it isn't greater
                                            // than the current date. If it is set the
                                            // bPassedSvcAuthEdit to false.
                                            for (j = 0;j < pDAM24Out.getArchOutputStruct().getUlRowQty();j++) {
                                                
                                                //  SIR 20846 - Changed to buisness from primary and added VID
                                                // validation
                                                //  Copy idResourceAddress if the address type if "buisness"
                                                // and has a valid VID. (There can be more than one business
                                                // address but only one with a VID.)
                                                if ((ARC_UTLCompareDateAndTime((FndInt3date) & dtCurrentDate, 0, (FndInt3date) & pDAM24Out.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getDtDtSvcAuthDtlTerm() , 0)) < 0) {
                                                    
                                                    
                                                    
                                                    // 
                                                    // (END): Retrieve Resource Address
                                                    // 
                                                    
                                                    //  SIR 19600 - Modified statement to use FND_YES rather than TRUE.
                                                    // original code:
                                                    // if((RetVal == FND_SUCCESS) && (TRUE == pInputMsg->bIndRsrcNonPrs) &&
                                                    if (0 != pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(APPROVED)) {
                                                        bPassedSvcAuthEdit = 0;
                                                    }
                                                    else if (0 != pDAM24Out.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getSzCdSvcAuthDtlSvc().compareTo(FORMER_DAY_CARE)) {
                                                        bSvcAuthsToProgress = true;
                                                    }
                                                }
                                            }
                                            break;
                                        case Messages.MSG_NO_ROWS_RETURNED:
                                            break;
                                            
                                        default :
                                            
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    break;
                            }
                        }
                    }
                    break;
                }
                else {
                    
                    //  Loop through all the stages to see if an eligible stage exists
                    // to which we can progress the Service Auths. The following stages
                    // are not eligible: a.) closed stages, b.) the stage currently being
                    // submitted for closure, and c.) ADO, ARI, INV, PAL or SUB stages.
                    // RIOSJA SIR 16227 - Added ARI to the list of stages not eligible
                    // to receive Service Auths from a closed stage.
                    for (i444 = 0;i444 < ulRowQtyEvent.value && bPassedSvcAuthEdit == true;i444++) {
                        
                        if ((0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(COMPLETE)) || (0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(PENDING)) || (0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(APPROVED))) {
                            
                            
                            //  ADD 
                            
                            // SIR 22177 - calling the ccmn39d dam
                            if (!(bPassedSvcAuthEdit != 0)) {
                                break;
                            }
                            
                            
                            //  Call CLSS24D
                            rc = Ccmn35s.CallCSES24D(pInputMsg861, ulIdEvent33[i444], ulIdSvcAuth9, pServiceStatus);
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                    rc = Cinv20s.CallCLSS24D(pInputMsg861, pDAM24Out, ulIdSvcAuth9.value, ulRowQtySvcAuthDetail, dtSvcAuthDtlTermDate, pServiceStatus);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            for (j = 0;j <= (ulRowQtySvcAuthDetail.value - 1);j++) {
                                                lRC13 = ARC_UTLCompareDateAndTime((FndInt3date) & dtSvcAuthDtlTermDate[j], 0, (FndInt3date) & dtCurrentDate, 0);
                                                
                                                if (lRC13 > 0) {
                                                    if (0 != pDAM24Out.getROWCLSS24DO_ARRAY().getROWCLSS24DO(j).getSzCdSvcAuthDtlSvc().compareTo(FORMER_DAY_CARE) || 0 != pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i444).getSzCdEventStatus().compareTo(APPROVED)) {
                                                        bPassedSvcAuthEdit = 0;
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        case Messages.MSG_NO_ROWS_RETURNED:
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    break;
                            }
                        }
                    }
                    break;
                }
            case NO_DATA_FOUND:
                return WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        /*
        ** checking to see if someone with a division number is trying
        ** to save.  if not then delete the leading zero in the region
        ** number
        */
        if (bPassedSvcAuthEdit != 0 && bSvcAuthsToProgress) {
            CLSS30DI.setArchInputStruct(pInputMsg861.getArchInputStruct());
            
            CLSS30DI.setUlIdCase(CCMNB6DO.getUlIdCase());
            rc = Ccmn02u.CallCLSS30D(CLSS30DI, CLSS30DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            for (j = 0;j < CLSS30DO.getArchOutputStruct().getUlRowQty() && bEligibleStageFound == false;j++) {
                if (((DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year && DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day && DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month) || DateHelper.ARC_MAX_YEAR == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getUlIdStage() != pInputMsg861.getUlIdStage()) {
                    lRC13 = ARC_UTLCompareDateAndTime((FndInt3date) & DtTempStageStart, (char) 0, (FndInt3date) & CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageStart() , (char) 0);
                    if ((lRC13 < 0) && ((0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(PREP_ADULT1)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ARI_STAGE1)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(SUBCARE2)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(INVESTIGATION2)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ADOPTION2)))) {
                        bEligibleStageFound = true;
                    }
                    //  If the current stage started on the same date as the stage
                    // being submitted for closure, and the stage is FPR, FSU or
                    // FRE, then it is eligible to receive the Service Auths.
                    else if ((lRC13 == 0) && ((0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(PREP_ADULT1)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ARI_STAGE1)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(SUBCARE2)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ADOPTION2)))) {
                        for (i444 = 0;i444 < CLSS30DO.getArchOutputStruct().getUlRowQty();i444++) {
                            if (((DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && (DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day) && (DateHelper.NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month)) || (DateHelper.ARC_MAX_YEAR == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year)) {
                                if (0 == FPR_PROGRAM1.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i444).getSzCdStage())) {
                                    bEligibleStageFound = true;
                                }
                                else if (0 == FSU_PROGRAM1.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i444).getSzCdStage())) {
                                    bEligibleStageFound = true;
                                }
                                else if (0 == FRE_PROGRAM1.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i444).getSzCdStage())) {
                                    bEligibleStageFound = true;
                                }
                            }
                        }
                    }
                }
            }
            if (!bEligibleStageFound) {
                bPassedSvcAuthEdit = 0;
            }
        }
        if (!bPassedSvcAuthEdit) {
            
            if (0 == pInputMsg861.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CREG) || 0 == pInputMsg861.getSzCdStageType().compareTo(SVC_CD_STAGE_TYPE_CGUA)) {
                pOutputMsg806.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg806.getCINV59SOG01().ulRowQty, Messages.MSG_SVA_CRSR_OPN_AUTHS);
                // 
                // begin sir# 15712 - ochumd
                // 
                pOutputMsg806.getCINV59SOG01().ulRowQty++;
            }
            else {
                pOutputMsg806.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg806.getCINV59SOG01().ulRowQty, Messages.MSG_SVA_OPN_AUTHS);
                pOutputMsg806.getCINV59SOG01().ulRowQty++;
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCLSS30D(CLSS30DI pInputMsg862, CLSS30DO pOutputMsg807, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i445 = 0;
        
        /*
        ** Declare local variables
        */
        CLSS30DI pCLSS30DInputRec = null;
        CLSS30DO pCLSS30DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS30DInputRec = new CLSS30DI();
        
        pCLSS30DOutputRec = new CLSS30DO();
        pCLSS30DInputRec.setUlIdCase(pInputMsg862.getUlIdCase());
        pCLSS30DInputRec.setArchInputStruct(pInputMsg862.getArchInputStruct());
        pCLSS30DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS30DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS30DO._CLSS30DO__ROWCLSS30DO_SIZE);
        rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
        
        
        /* Analyze error code */
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                for (i445 = 0;i445 < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty();++i445) {
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setUlIdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getUlIdStage());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageType(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageType());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setTsLastUpdate(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getTsLastUpdate());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setUlIdUnit(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getUlIdUnit());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setUlIdCase(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getUlIdCase());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setDtDtStageClose(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getDtDtStageClose());
                    //  PROCESS_TUX_RC_ERROR will always return, so make sure that any
                    // memory that has been allocated is free'd in this case 
                    // statement before PROCESS_TUX_RC_ERROR is called.
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageClassification(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageClassification());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageCurrPriority(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageCurrPriority());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageReasonClosed(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageReasonClosed());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageCnty(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageCnty());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzNmStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzNmStage());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageRegion(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageRegion());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setDtDtStageStart(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getDtDtStageStart());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setUlIdSituation(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getUlIdSituation());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStageProgram(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStageProgram());
                    pOutputMsg807.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).setSzCdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i445).getSzCdStage());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                pOutputMsg807.getArchOutputStruct().setUlRowQty(pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg807.getArchOutputStruct().setBMoreDataInd(pCLSS30DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        
        return rc;
    }

    static int CallCCMN87D(CSVC16SI pInputMsg863, String szCdEventType7, CCMN87DO pCCMN87DOutputRec, Pint ulRowQty4, Pint ulIdEvent34, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        int i446 = 0;
        CCMN87DI pCCMN87DInputRec = null;
        
        /* RIOSJA, SIR 14003 */
        CCMNB6DI CCMNB6DI = null;
        CCMNB6DO CCMNB6DO = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg863.getArchInputStruct());
        if (0 == szCdEventType7.compareTo(CVS_REMOVAL_EVENT_TYPE) || (0 == szCdEventType7.compareTo(SVC_AUTH_EVENT_TYPE) && 0 != pInputMsg863.getSzCdStage().compareTo(SVC_CD_STAGE_CPS_SVC))) {
            CCMNB6DI.setArchInputStruct(pInputMsg863.getArchInputStruct());
            
            CCMNB6DI.setUlIdStage(pInputMsg863.getUlIdStage());
            
            
            //  Call CLSS57D
            rc = Cinv08s.CallCCMNB6D(CCMNB6DI, CCMNB6DO, pServiceStatus);
            
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            
            pCCMN87DInputRec.setUlIdCase(CCMNB6DO.getUlIdCase());
        }
        else {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pCCMN87DInputRec.setUlIdStage(pInputMsg863.getUlIdStage());
        }
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(szCdEventType7);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ulRowQty4.value = pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();
                
                for (i446 = 0;i446 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();i446++) {
                    ulIdEvent34[i446] = pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i446).getUlIdEvent();
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                rc = NO_DATA_FOUND;
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    
    static int CallCSES24D(CSVC16SI pInputMsg864, int ulIdEvent35, Pint ulIdSvcAuth10, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSES24DI pCSES24DInputRec = null;
        CSES24DO pCSES24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES24DInputRec = new CSES24DI();
        
        pCSES24DOutputRec = new CSES24DO();
        pCSES24DInputRec.setArchInputStruct(pInputMsg864.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(ulIdEvent35);
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdSvcAuth10.value = pCSES24DOutputRec.getUlIdSvcAuth();
                
                
                //  Call CAUD18D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    
    static int CallCLSS24D(CSVC16SI pInputMsg865, CLSS24DO pCLSS24DOutputRec, int ulIdSvcAuth11, Pint ulRowQty5, FndInt3date dtTermDate, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i447 = 0;
        CLSS24DI pCLSS24DInputRec = new CLSS24DI();
        pCLSS24DInputRec.setArchInputStruct(pInputMsg865.getArchInputStruct());
        pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE);
        pCLSS24DInputRec.setUlIdSvcAuth(ulIdSvcAuth11);
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ulRowQty5.value = pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();
                
                for (i447 = 0;i447 < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();i447++) {
                    dtTermDate[i447] = pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i447).getDtDtSvcAuthDtlTerm();
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNF6D(CCMNF6DI pInputMsg866, CCMNF6DO pOutputMsg808, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i448 = 0;
        int rc = 0;/* Return code */
        
        CCMNF6DI pCCMNF6DInputRec = null;
        CCMNF6DO pCCMNF6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF6DInputRec = new CCMNF6DI();
        
        pCCMNF6DOutputRec = new CCMNF6DO();
        pCCMNF6DInputRec.setArchInputStruct(pInputMsg866.getArchInputStruct());
        pCCMNF6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNF6DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNF6DO._CCMNF6DO__ROWCCMNF6DO_SIZE);
        pCCMNF6DInputRec.setUlIdCase(pInputMsg866.getUlIdCase());
        rc = ccmnf6dQUERYdam(sqlca, pCCMNF6DInputRec, pCCMNF6DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i448 = 0;i448 < pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty();++i448) {
                    pOutputMsg808.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i448).setUlIdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i448).getUlIdStage());
                    pOutputMsg808.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i448).setSzCdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i448).getSzCdStage());
                }
                pOutputMsg808.getArchOutputStruct().setUlRowQty(pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCCMNB6D(CCMNB6DI pInputMsg867, CCMNB6DO pOutputMsg809, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i449 = 0;
        int rc = 0;/* Return code */
        
        CCMNB6DI pCCMNB6DInputRec = null;
        CCMNB6DO pCCMNB6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB6DInputRec = new CCMNB6DI();
        
        pCCMNB6DOutputRec = new CCMNB6DO();
        pCCMNB6DInputRec.setArchInputStruct(pInputMsg867.getArchInputStruct());
        pCCMNB6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNB6DInputRec.setUlIdStage(pInputMsg867.getUlIdStage());
        rc = ccmnb6dQUERYdam(sqlca, pCCMNB6DInputRec, pCCMNB6DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg809.setUlIdCase(pCCMNB6DOutputRec.getUlIdCase());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSCB6D(CSVC16SI pInputMsg868, String pbGUA_Found, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i450 = 0;
        int rc = 0;
        String guarTypeAPS = "APS";
        String guarTypeCON = "CON";
        
        CLSCB6DI pCLSCB6DInputRec = null;
        CLSCB6DO pCLSCB6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSCB6DInputRec = new CLSCB6DI();
        
        pCLSCB6DOutputRec = new CLSCB6DO();
        pCLSCB6DInputRec.setArchInputStruct(pInputMsg868.getArchInputStruct());
        pCLSCB6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        
        pCLSCB6DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSCB6DO._CLSCB6DO__ROWCLSCB6DO_SIZE);
        
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCLSCB6DInputRec.setUlIdStage(pInputMsg868.getUlIdStage());
        rc = clscb6dQUERYdam(sqlca, pCLSCB6DInputRec, pCLSCB6DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Determine whether or not any GUARDIANSHIP records
                // are APS or Contracted.
                for (i450 = 0;i450 < pCLSCB6DOutputRec.getArchOutputStruct().getUlRowQty();i450++) {
                    
                    if (0 == pCLSCB6DOutputRec.getROWCLSCB6DO_ARRAY().getROWCLSCB6DO(i450).getSzCdGuardGuardianType().compareTo(guarTypeAPS) || 0 == pCLSCB6DOutputRec.getROWCLSCB6DO_ARRAY().getROWCLSCB6DO(i450).getSzCdGuardGuardianType().compareTo(guarTypeCON)) {
                        pbGUA_Found = CStringUtils.setCharAt(pbGUA_Found, 0, true);
                        
                        break;
                    }
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                
                //  Call CDYN15D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    void CheckAOMActions(CSVC16SI pInputMsg869, CSVC16SO pOutputMsg810, CINV96DO pCINV96DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMNB6DI CCMNB6DI = null;
        CCMNB6DO CCMNB6DO = null;
        CSVC48DI CSVC48DInputRec = null;
        CSVC48DO CSVC48DOutputRec = null;
        CINT20DI CINT20DInputRec = null;
        CINT20DO CINT20DOutputRec = null;
        CCMN87DO pDAM87Out = null;
        Pint legalActions = new Pint();
        legalActions.value = 0;
        Pint ulIdClient = new Pint();
        ulIdClient.value = 0;
        int i451 = 0;
        int counter = 0;
        
        Pint ulRowQtyEvent = new Pint();
        int[] ulIdEvent36 = new int[CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE];
        Pint ulIdSvcAuth12 = new Pint();
        Pchar cIndDntdCmmtySvc3 = new Pchar();
        
        char bDntdCmmtySvc = 0;
        char bOtherThanDntdCmmtySvc = 0;
        
        boolean bShowLegalMsg = false;
        boolean bShowECSMsg = false;
        boolean bShowCommMsg = false;
        
        
        for (int k = 0;k < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();k++) {
            if (0 == AOM_ACTION_LEGAL.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) &&!bShowLegalMsg) {
                
                //  Call CLSCB4D
                rc = CallCINT20D(pInputMsg869, pOutputMsg810, ulIdClient, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                CSVC48DInputRec.setUlIdCase(pInputMsg869.getUlIdCase());
                CSVC48DInputRec.setUlIdPerson(ulIdClient.value);
                //  IMPACT END
                
                
                //  Populate number of rows and more data indicator in output
                // message
                // pOutputMsg->ArchOutputStruct.ulRowQty =
                // pCCMNB9DOutputRec->ArchOutputStruct.ulRowQty;
                // pOutputMsg->ArchOutputStruct.bMoreDataInd =
                // pCCMNB9DOutputRec->ArchOutputStruct.bMoreDataInd;
                
                rc = Cinv20s.CallCSVC48D(CSVC48DInputRec, CSVC48DOutputRec, legalActions, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                if (legalActions.value == 0) {
                    pOutputMsg810.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg810.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_LEG_ACT_REQD);
                    pOutputMsg810.getCINV59SOG01().ulRowQty++;
                    bShowLegalMsg = true;
                }
            }
            
            // check if any require service auth check
            else if (0 == AOM_ACTION_ECS.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) || 0 == AOM_ACTION_COMMUNITY.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg())) {
                //  Call DAM to retrieve all Service Authorization events
                pDAM87Out = new CCMN87DO();
                
                //  Set rc to ARC_SUCCESS
                rc = CallCCMN87D(pInputMsg869, SVC_AUTH_EVENT_TYPE, pDAM87Out, ulRowQtyEvent, ulIdEvent36, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        //  for each IdEvent returned from the DAM search the
                        // SVC_AUTH_EVENT_LINK table to find corresponding
                        // Service Auth Id.
                        for (i451 = 0;i451 <= (ulRowQtyEvent.value - 1);i451++) {
                            
                            if (bOtherThanDntdCmmtySvc != 0 && bDntdCmmtySvc != 0) {
                                
                                break;
                            }
                            rc = Ccmn35s.CallCSES24D(pInputMsg869, ulIdEvent36[i451], ulIdSvcAuth12, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    rc = Cinv20s.CallCSES23D(pInputMsg869, pOutputMsg810, ulIdSvcAuth12.value, cIndDntdCmmtySvc3, pServiceStatus);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            if (cIndDntdCmmtySvc3.value == 'Y') {
                                                bDntdCmmtySvc = 1;
                                            }
                                            else // it is 'N' or NULL
                                            if ((0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i451).getSzCdEventStatus().compareTo(PROGRESS)) || (0 == pDAM87Out.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i451).getSzCdEventStatus().compareTo(NEW))) {
                                                counter++;
                                            }
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    break;
                            }
                        }
                        if (counter == 0) {
                            
                            bOtherThanDntdCmmtySvc = 1;
                        }
                        else if (counter > 0) {
                            bOtherThanDntdCmmtySvc = 0;
                        }
                        break;
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                if (0 == AOM_ACTION_ECS.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) &&!(bOtherThanDntdCmmtySvc != 0) &&!bShowECSMsg) {
                    pOutputMsg810.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg810.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_SERV_AUTH_REQD);
                    pOutputMsg810.getCINV59SOG01().ulRowQty++;
                    bShowECSMsg = true;
                }
                
                if (0 == AOM_ACTION_COMMUNITY.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) &&!(bDntdCmmtySvc != 0) &&!bShowCommMsg) {
                    pOutputMsg810.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg810.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_COMM_SVC_REQD);
                    pOutputMsg810.getCINV59SOG01().ulRowQty++;
                    bShowCommMsg = true;
                }
            }
        }
    }

    static int CallCSVC48D(CSVC48DI pInputMsg870, CSVC48DO * pOutputMsg811, Pint legalActions, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        
        CSVC48DI pCSVC48DInputRec = null;
        CSVC48DO pCSVC48DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC48DInputRec = new CSVC48DI();
        
        pCSVC48DOutputRec = new CSVC48DO();
        pCSVC48DInputRec.setArchInputStruct(pInputMsg870.getArchInputStruct());
        pCSVC48DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCSVC48DInputRec.setUlIdCase(pInputMsg870.getUlIdCase());
        pCSVC48DInputRec.setUlIdPerson(pInputMsg870.getUlIdPerson());
        rc = csvc48dQUERYdam(sqlca, pCSVC48DInputRec, pCSVC48DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                legalActions.value = pCSVC48DOutputRec.getUlRowQty();
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSES23D(CSVC16SI pInputMsg871, CSVC16SO * pOutputMsg812, int ulIdSvcAuth13, String cIndDntdCmmtySvc4, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES23DInputRec = new CSES23DI();
        
        pCSES23DOutputRec = new CSES23DO();
        pCSES23DInputRec.setArchInputStruct(pInputMsg871.getArchInputStruct());
        pCSES23DInputRec.setUlIdSvcAuth(ulIdSvcAuth13);
        rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cIndDntdCmmtySvc4 = CStringUtils.setCharAt(cIndDntdCmmtySvc4, 0, pCSES23DOutputRec.getCIndDntdCmmtySvc());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT20D(CSVC16SI pInputMsg872, CSVC16SO * pOutputMsg813, Pint ulIdClient, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        
        CINT20DI pCINT20DInputRec = null;
        CINT20DO pCINT20DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT20DInputRec = new CINT20DI();
        
        pCINT20DOutputRec = new CINT20DO();
        pCINT20DInputRec.setArchInputStruct(pInputMsg872.getArchInputStruct());
        pCINT20DInputRec.setUlIdStage(pInputMsg872.getUlIdStage());
        pCINT20DInputRec.setSzCdStagePersRole(PERSON_STAGE_ROLE_CL);
        pCINT20DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        
        rc = cint20dQUERYdam(sqlca, pCINT20DInputRec, pCINT20DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdClient.value = pCINT20DOutputRec.getUlIdPerson();
                // Call DAM to retrieve the event id
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC49D(CSVC16SI pInputMsg873, CSVC16SO pOutputMsg814, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC49DI pCSVC49DInputRec = null;
        CSVC49DO pCSVC49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC49DInputRec = new CSVC49DI();
        pCSVC49DOutputRec = new CSVC49DO();
        pCSVC49DInputRec.setUlIdCase(pInputMsg873.getUlIdCase());
        rc = csvc49dQUERYdam(sqlca, pCSVC49DInputRec, pCSVC49DOutputRec);
        
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                for (int j = 0;j < pCSVC49DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                    
                    //  SIR 2427: Only call ccmn19d.pc, if the stage is not I&R or
                    // SPC.
                    if (((0 == SVC_CD__GUARDIAN_TYPE_APS.compareTo(pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getSzCdGuardGuardianType())) || (0 == SVC_CD__GUARDIAN_TYPE_CON.compareTo(pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getSzCdGuardGuardianType()))) && (DateHelper.NULL_DATE == pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getDtDtGuardCloseDate().year && DateHelper.NULL_DATE == pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getDtDtGuardCloseDate().day && DateHelper.NULL_DATE == pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE != pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getDtDtGuardLetterIssued().year && DateHelper.NULL_DATE != pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getDtDtGuardLetterIssued().day && DateHelper.NULL_DATE != pCSVC49DOutputRec.getROWCSVC49DO_ARRAY().getROWCSVC49DO(j).getDtDtGuardLetterIssued().month)) {
                        pOutputMsg814.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg814.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_OPEN_APS_CON_GUA);
                        pOutputMsg814.getCINV59SOG01().ulRowQty++;
                        break;
                    }
                }
                
                //  Call CINV51D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
