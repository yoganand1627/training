package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV20SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV84DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV96DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV96DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVD4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVD4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
/**************************************************************************
**
** Module File:   CINV20S.src
**
** Service Name:  CINV20S - APS INV CONCL VAL
**
** Description:   Performs a series of edits to determine if an APS
**                Investigation is complete or not and will either close
**                the Investigation, prepare it for submittal, or return
**                warnings from the edits.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  03/28/95
**
** Programmer:    CRG
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   14 Mar 2002 12:13:28  $
**                      $Modtime:   13 Mar 2002 17:23:18  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  09/25/95  bruckmk   SIR 675:  An Outcome Matrix Event and Shell needs to
**                      be created when the Closure Reason is Code = 15, 20,
**                      35, 45.  For 15, the event status will be NEW, for
**                      20, 35 & 45, the event status will be complete.
**  10/02/95    KRD     SIR 1590 - Modified CallCINV34D() to insure that
**                      only PRNs are checked for characteristics.  Other
**                      superficial changes made to match the Release 1.x
**                      service shell.
**  10/03/85    KRD     SIR 1595 - Modified CallCSYS04D() to insure that the
**                      Architecture Input structure has the correct value.
**  10/03/95  HUSTONMJ  ERR#1596 and 1588.  Change to edits after CINV34D
**                      and to Investigation Closure event edit.
**  10/10/95  BRUCKMK   SIR 1717: Remove the (only) "if" no edits statement
**                      for calling the Close Stage Function.  We will
**                      already only hit this function if the only edit is
**                      the Outcome Matrix Actions Edit.
**  10/11/95  ELLIOTSL  SIR 1466 - Changed "Aps Outcome Matrix"to
**                      "APS Outcome Matrix" in #define.
**  10/12/95  VISHNUR   SIR 1702 - 'No characteristics Applicable' should not
**                      apply to APS Victims. They need to be either
**                      aged or disable.
**  10/12/95  VISHNUR   SIR 1772 - APS Conclusion Edit:modified if-statement
**  10/13/95  HUSTONMJ  ERR#1674 Changes to CCMN87BD
**  10/13/95    KRD     SIR 1751 - Modified CSVC09CreateAOM() and
**                      CallCSVC16D() to ensure that the DAM is called with
**                      the proper.
**  10/18/95    KRD     SIR 1804 - Replaced OUT_MATRIX_ACTIONS_EDIT with
**                      OUT_MATRIX_ACT_WARNING in if-statements which were
**                      comparing against the wrong macro.  The first macro
**                      is an index into an array.  The second is the code
**                      for a user message.
**
**  10/20/95    AGS     SIR 675 - Additional updates to check for client
**                      assessment factors prior to creating an AOM.
**  11/13/95  HELMKEST  SIR 1710: Included CheckStageEventStatus common
**                      function. (CCMN06U)
**  11/29/95  YANTISTK  SIR 1887 - Added Service Authorization Edit
**  11/30/95  maxhamkj  SIR 2130: do not execute PersonChar edit if the
**                      closure code is 40 -- "Does not meet definition
**                      for APS".
**
**  01/05/96    AGS     SIR #2497 - Changed event status if check (see cmnt
**                      in code) from OR'ing of Legal Action and Guardianship
**                      event type check to AND'ing.
**
**  01/12/96  BRUCKMK   SIR 2551: The Outcome Matrix Event, Three-Month
**                      Review and Monthly Status Contact Events should not
**                      be passed back to the window if they are either NEW
**                      or IN_PROGRESS, since they would then be passed
**                      on to the ToDo window, which would update their status
**                      to Pending. Only COMPLETE and APPROVED Outcome Matrices
**                      and Contacts should be passed to the ToDo Window to be
**                      updated to PENDING. Also, no EditWarningMessages
**                      should be displayed for any of the above when
**                      incomplete.
**
** 01/29/96   MCRAEBS  SIR 2977 - Added missing break statements to the
**                     nested switches.  Missing statements were causing the
**                     logic to fall into the default case and failing the
**                     service.     BSM
**
** 03/19/96   DYARGR   SIR 5034 - Conclusion reason of Client Died or Adminis-
**                     strative Closure should not be progressed. If there
**                     is an Outcome Matrix started with Actions in it, messgae
**                     the user to complete the actions with outcomes before
**                     closing the stage. If there is not Outcome Matrix or
**                     there are no Actions on the Outcome Matrix, don't message
**                     the user and allow them to close the stage.
** 06/04/96   ODONNERJ SIR# 5466 - If the Event Status is PROC or NEW
**                     then a SVC_AUTH_DETAIL record does not exist. DO NOT
**                     continue processing with id_event with this status.
** 06/12/96   BRUCKMK  SIR 10110: Switched out DAM CSYS04D with CSYS18D
**                     because of slow performance.  CSYS18D was created
**                     specifically for 24-Hour Contact validation.
** 07/01/96   ODONNERJ SIR# 10174 - If the only SVC_AUTH has event status
**                     of PROC/NEW then return SQL_NOT_FOUND for CCMN87D.
**
** 08/20/96   OMARAJJ   SIR# 21884 - Added another code from Person Role codes
**                      "CL" for the Living Arrangement edit check to verify.
**                      The codes that this edit is currently validating
**                      against are generally not valid now.
**
** 12/16/96   ODONNERJ  SIR# 21885 - Added the following condition above to
**                      the if - do not pass NEW GUA Events. They will be
**                      changed to APRV and after Stage progression and there
**                      will be a data access error from event list.
**
** 01/07/97   RIOSJA    SIR 10491 - This service was returning a data access
**                      error during APS Investigation Conclusions for all
**                      Closure Reasons except "Valid, continue as APS."
**                      PURIFY located an unitialized loop counter "i" in
**                      CallCCMN87D that was being referenced before it had
**                      valid data in it. The loop counter will now be
**                      initialized to zero.
**
** 02/07/97   RIOSJA    SIR 13057 - When conclusions are submitted for
**                      approval, the status of existing approval events
**                      should not be changed to PENDING.
**
** 05/21/97   GONZALCE  SIR 13939 - In the case of rapid closure, do not
**                      display any edit messages.
**
** 3/29/01    MERRELGS  SIR 13532 - Made code modifications in the CPS
**                      investigation conclusion validation service to
**                      prevent the 1)person characteristics,
**                      2)marital/ethnicity, 3)date of birth, and
**                      4)person search edits from appearing while trying
**                      to close an investigation when the name is unknown.
**
** 3/01/2002 ochumd     Sir 15712 - Made code modifications in the APS
**                      investigation conclusion validation service to prevent
**                      person search edits from appearing while trying to close
**                      an investigation when the person type is collateral.
**
**
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of full
**                      table scans for ccmn87dQUERYdam.
**
**  08/01/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**  09/17/03   Srini    SIR 19822 - IMPACT: Changed the pagesizenbr to the
**                      cinv34d dam from 100 to 50 as the output dam struct
**                      can accomodate 50 rows at a time. Setting 100 would
**                      potential crash the server, so changed to 50.
**  4/15/2004  gerryc   SIR 22848 - when checking person characteristics on
**                      the close of an APS investigation, added the check
**                      to see if a person was a client, then they couldn't
**                      have 'No Characteristics Applicable'
**  4/19/2004  gerryc   SIR 16206 - if event status for the client assessment
**                      is not complete throw the CLT_ASSMT_WARNING error
**  04/29/04   RIOSJA   SIR 14512 - Previously, worker was able to select
**                      'Yes' Factors on the Client Assessment, then save the
**                      page (which creates the Outcome Matrix event), then
**                      deselect the 'Yes' Factors, then save the page, then
**                      close the INV stage and progress to SVC without any
**                      'Yes' Factors because the Outcome Matrix event exists.
**                      This is bad because the SVC stage is created without
**                      any Problems in the Outcome Matrix. I modified this
**                      service significantly so that it would check for 'Yes'
**                      Factors before allowing the worker to progress to SVC.
**                      The code to check for 'Yes' Factors already existed
**                      in this service, it just needed to be rearranged so
**                      that it would always be processed when needed.
**  4/21/2005  gerryc   SIR 23538 - part of APS Reform R1.  Added the method
**                      CheckAOMActions so that if there are actions in the
**                      outcome matrix, the corresponding pieces in IMPACT
**                      are also required.  If an action requires a certain
**                      service auth, this checks for that service auth.  If
**                      the action is legal related, this checks for the legal
**                      action.
**  5/2/2005   gerryc   SIR 23530 - added check for care factors when closing
**                      the investigation.  If any are H (severe problem) or
**                      M (problem), then an outcome matrix needs to be created.
**  5/12/2005  gerryc   SIR 23530 - When checking events that are in PROC status,
**                      it now ignores any Client Assessment events.  It also
**                      makes sure there is either a COMP Client Assessment
**                      or a COMP CARE event.
**  5/15/2005  gerryc   SIR 23530 - the outcome matrix required message now
**                      only shows up for those cases that are 'valid, continue
**                      as APS.'  The CARE is still required for valid continue, valid
**                      refused services, valid services not available, and valid
**                      services not needed.
**  07/29/2005 berkime  SIR 23681 - EVENT_WARNING_STATUS was being called when client died
**                      for contact type was selected--that is a problem.  So put logic into the
**                      statement to fix the problem.
**  07/29/2005 wadesa   SIR 23746 - added SQL_NOT_FOUND when calling clss24d DAM.
**                      The call now returns a ARC_SUCCESS message because no
**                      Service Auth event types were found so the code can
**                      continue processing
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv20s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /* Number of persons to retrieve during loop */
    public static final int PERSON_LIST_SIZE = 100;
    
    /* Event and Stage info */
    public static final String EVENT_TYPE_NONE = "";
    public static final String SERV_DELIVERY_STAGE = "SVC";
    public static final String EVENT_TYPE_OUTCOME_MATRIX = "PLN";
    public static final String EVENT_TYPE_PRIORITY_CHANGE = "PRT";
    public static final String EVENT_TYPE_CONTACT = "CON";
    public static final String EVENT_TYPE_MED_MENTAL_ASSESS = "MED";
    
    public static final String SERVICE_AUTH_EVENT_TYPE = "AUT";
    
    
    public static final String AOM_EVENT_DESCR = "Outcome Matrix";
    public static final String CLOSE_CODE_VALID = "15";
    public static final String CLOSE_CODE_ADMIN = "30";
    public static final String CLOSE_CODE_DIED = "50";
    /***************************************************
    ** SIR 675:  Add the following closure reason codes
    ***************************************************/
    public static final String CLOSE_CODE_REFUSED = "20";
    public static final String CLOSE_CODE_NOT_AVAIL = "35";
    public static final String CLOSE_CODE_NOT_REQ = "45";
    
    
    /* Code for Contact Types */
    public static final String CONTACT_TYPE_24HR = "C24H";
    
    /* Function codes for Close or Submit action */
    public static final char ACTION_CODE_CLOSE = 'C';
    
    /* Parameter for Edit Process String */
    public static final char EDIT_YES = 'Y';
    
    /* Positions within Edit Process String */
    public static final int LIVING_ARRANGE_EDIT = 0;
    public static final int CLT_ASSMT_EDIT = 1;
    public static final int OUT_MATRIX_REQ_EDIT = 2;
    public static final int OUT_MATRIX_ACTIONS_EDIT = 3;
    public static final int CONTACT_EDIT = 4;
    public static final int PERS_CHARACTER_EDIT = 5;
    public static final int VICTIM_DOB_EDIT = 6;
    public static final int PERS_SEARCH_EDIT = 7;
    public static final int SVC_AUTH_EDIT = 8;
    
    /* Validation Edit Warning Codes */
    public static final int LIVING_ARRANGE_WARNING = 4049;
    public static final int PERS_CHARACTER_WARNING = 4054;
    public static final int VICTIM_DOB_WARNING = 4055;
    public static final int PERS_SEARCH_WARNING = 4056;
    public static final int CLT_ASSMT_WARNING = 4050;
    public static final int OUT_MATRIX_REQ_WARNING = 4052;
    public static final int OUT_MATRIX_ACT_WARNING = 4051;
    public static final int CONTACT_WARNING = 4053;
    public static final int EVENT_STATUS_WARNING = 4079;
    
    /*
    ** SIR 2130
    */
    public static final String CD_DOES_NOT_MEET_DEFINITION = "40";
    
    /* Person roles, types, searches, etc. */
    public static final int PERSON_CHAR_NULL = 0;
    public static final char PERSON_CHAR_NONE = '0';
    public static final char PERSON_CHAR_TWO = '2';
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final String PERSON_TYPE_STF = "STF";
    public static final String PERSON_ROLE_BOTH = "VP";
    public static final String PERSON_ROLE_VICTIM = "VC";
    public static final String PERSON_ROLE_CLIENT = "CL";
    public static final char PERSON_SEARCH_R = 'R';
    public static final char PERSON_SEARCH_V = 'V';
    public static final String PERSON_TYPE_COL = "COL";
    
    /* check that all events are COMP before closing stage */
    public static final String EVENT_STATUS_COMP = "COMP";
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String EVENT_STATUS_PROCESS = "PROC";
    public static final String EVENT_STATUS_APPROVED = "APRV";
    
    /* Client Assessment Event Type */
    public static final String ASSMT_EVENT_TYPE = "ASM";
    public static final String FACTOR_ANSWER_YES = "Y";
    public static final char OUTCOME_IND_NONE = ' ';
    public static final char OUTCOME_IND_ACTION = 'A';
    public static final char OUTCOME_IND_RESULT = 'R';
    public static final String TXT_NARR_TABLENAME = "APS_CLIENT_ASSMT_NARR";
    public static final String TXT_NARR_EXISTS = "NARRATIVE";
    public static final String CONCL_EVENT_TYPE = "CCL";
    public static final String EVENT_STATUS_PENDING = "PEND";
    
    /* SIR 1887: Added new event types */
    public static final String SVC_AUTH_EVENT_TYPE = "AUT";
    public static final String LEGAL_ACTION_EVENT_TYPE = "LEG";
    public static final String GUARDIANSHIP_EVENT_TYPE = "GUA";
    
    /* SIR 13057: Added new event type */
    public static final String APPROVAL_EVENT_TYPE = "APP";
    public static final String OUTCOME_MATRIX_TASK = "2090";
    public static final String CONTACTS_TASK = "2030";
    public static final String THREE_MONTH_CONTACT = "Three-Month Review";
    public static final String MONTHLY_SUMMARY_CONTACT = "Monthly Status";
    
    /* SIR 3119 */
    public static final String SERVICE_AUTH_TASK = "2100";
    public static final String EMPTY_STRING = "";
    
    /* SIR 23538 */
    public static final String AOM_ACTION_LEGAL = "LEG";
    public static final String AOM_ACTION_ECS = "ECS";
    public static final String AOM_ACTION_COMMUNITY = "COM";
    
    /* SIR 23530 */
    public static final String FACTOR_ANSWER_PROB = "M";
    public static final String FACTOR_ANSWER_SEV_PROB = "H";
    public static final char INV_VALIDATION = 'I';
    public static final String CARE_TASK = "2085";
    public static final String CLIENT_ASSMT_TASK = "2080";
    
    /* SIR# 5366 */
    public static final String CD_EVENT_STATUS_PROCESS = "PROC";
    public static final String CD_EVENT_STATUS_NEW = "NEW";
    
    /*
    ** SIR 13939- MHMR Enhancement for "APS Rapid Closure".
    */
    public static final String DECODE_NO_EDITS = "NNNNNNNNN";
    public static final String CLIENT_DIED = "YNNYYYYYY";
    static int transactionflag = - 1;
    CINV20SO CINV20S(CINV20SI cinv20si) {
        CINV20SO cinv20so = new CINV20SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINV20S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            
            //  Call CLSS46D
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        /*
        ** SIR 16206 - If the Date Completed is not null, check
        ** the event status of the Client Assessment event to
        ** ensure it is COMP. If it is not, post a warning.
        */
        else if (transactionflag == 1) {
            // This is the case of transaction in progress.
            //So we should not start a new one
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV20S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV20S \n");
            bTransactionStarted = true;
        }
        Pint ulIdOutcomeMatrixEvent = new Pint();
        ulIdOutcomeMatrixEvent.value = 0;
        int ulIdSituation3 = 0;
        int ulIdEvent17 = 0;
        Pint ulIdClient = new Pint();
        ulIdClient.value = 0;
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#2426 */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#2426 */
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv20si.getArchInputStruct());
        
        
        /**************************************************************************
        ** SIR 1710:
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv20si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv20si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv20si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv20si.getSzCdTask());
        
        /*
        ** Call CSEC33D
        */
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                
                break;
                
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
                
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                
                break;
        }
        if (SUCCESS == RetVal) {
            
            rc = Cint99s.CallCINV34D(cinv20si, cinv20so, ulIdClient, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            if (EDIT_YES == cinv20si.getSzDcdEditProcess()[CLT_ASSMT_EDIT]) {
                if ((DateHelper.NULL_DATE == cinv20si.getDtDtApsInvstCltAssmt().day) || (DateHelper.NULL_DATE == cinv20si.getDtDtApsInvstCltAssmt().month) || (DateHelper.NULL_DATE == cinv20si.getDtDtApsInvstCltAssmt().year)) {
                    cinv20so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(cinv20so.getCINV59SOG01().ulRowQty, CLT_ASSMT_WARNING);
                    cinv20so.getCINV59SOG01().ulRowQty++;
                }
                else 
                {
                    // check to see if age is required
                    
                    rc = CallCCMN87AD(cinv20si, ASSMT_EVENT_TYPE, cinv20so, null, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
            
            if (cinv20si.getSzDcdEditProcess()[CONTACT_EDIT] == EDIT_YES) {
                
                rc = CallCSYS18D(cinv20si, cinv20so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            rc = CallCINV84D(cinv20si, cinv20so, ulIdOutcomeMatrixEvent, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            
            if (EDIT_YES == cinv20si.getSzDcdEditProcess()[SVC_AUTH_EDIT]) {
                rc = Cinv15s.CallServiceAuth(cinv20si, cinv20so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            if (ulIdOutcomeMatrixEvent.value != 0) {
                
                //  Call CSEC33D
                rc = CheckAOMActions(cinv20si, cinv20so, ulIdOutcomeMatrixEvent.value, ulIdClient.value, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            if (!(cinv20so.getCINV20SOG01().getUlRowQty() != 0) || OUT_MATRIX_ACT_WARNING == cinv20so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCode(0)) {
                // check to see if age is required
                
                rc = Cinv12s.CallCINV43D(cinv20si, cinv20so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                rc = CallCCMN87BD(cinv20si, EVENT_TYPE_NONE, cinv20so, null, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                if (ACTION_CODE_CLOSE == cinv20si.getArchInputStruct().getCReqFuncCd() && (!(cinv20so.getCINV20SOG01().getUlRowQty() != 0) || 1 == cinv20so.getCINV20SOG01().getUlRowQty() && OUT_MATRIX_ACT_WARNING == cinv20so.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().getUsSysNbrMessageCode(0))) {
                    rc = Cinv61s.CloseStage(cinv20si, cinv20so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
        }
        
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv20si.getArchInputStruct() , cinv20so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /** 6/4/2003, Matthew McClain, don't count surrounding single quotes **/
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV20S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                // Set rc to ARC_SUCCESS
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV20S\n");
        }
        return cinv20so;
    }

    static int CallCCMN62D(CINV20SI pInputMsg646, CINV20SO pOutputMsg599, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        int usEventCtr = 0;
        
        /*
        ** Declare local variables
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setArchInputStruct(pInputMsg646.getArchInputStruct());
        
        /*
        ** Loop through Investigation Events, changing status to Approved
        */
        for (usEventCtr = 0;usEventCtr < pOutputMsg599.getArchOutputStruct().getUlRowQty();usEventCtr++) {
            pCCMN62DInputRec.setUlIdEvent(pOutputMsg599.getCINV20SOG00_ARRAY().getCINV20SOG00(usEventCtr).getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus(EVENT_STATUS_APPROVED);
            pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    //##         sprintf(pReturnPB->appl_status.explan_data,
                    //##                 "%u",
                    //##                 pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        return rc;
    }

    static int CallCCMN87AD(CINV20SI pInputMsg647, String szCdEventType3, CINV20SO pOutputMsg600, Pint ulIdOutcomeMatrixEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        int usEventCtr = 0;
        int i326 = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setUlIdStage(pInputMsg647.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(szCdEventType3);
        pCCMN87DInputRec.setArchInputStruct(pInputMsg647.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        if (szCdEventType3.compareTo("") != 0) {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        }
        else {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV20SO._CINV20SO__CINV20SOG00_SIZE);
        }
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (!(szCdEventType3.compareTo("") != 0)) {
                    pOutputMsg600.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                    
                    for (usEventCtr = 0;usEventCtr < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();usEventCtr++) {
                        if ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(OUTCOME_MATRIX_TASK)) && ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW)) || (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS)))) {
                            pOutputMsg600.getArchOutputStruct().getUlRowQty()--;
                        }
                        else if ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(CONTACTS_TASK)) && ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzTxtEventDescr().compareTo(THREE_MONTH_CONTACT)) || (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzTxtEventDescr().compareTo(MONTHLY_SUMMARY_CONTACT))) && ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW)) || (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS)))) {
                            pOutputMsg600.getArchOutputStruct().getUlRowQty()--;
                        }
                        else if (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(SERVICE_AUTH_TASK)) {
                            pOutputMsg600.getArchOutputStruct().getUlRowQty()--;
                        }
                        //  SIR 21885 - If the event is a NEW Guardianship event,
                        // do not change the status to PENDING.
                        else if ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW)) && (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(GUARDIANSHIP_EVENT_TYPE))) {
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            pOutputMsg600.getArchOutputStruct().getUlRowQty()--;
                        }
                        //  SIR 13057, 02/07/97 - If the event is an approval
                        // event, do not change its status to PENDING.
                        else if (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(APPROVAL_EVENT_TYPE)) {
                            pOutputMsg600.getArchOutputStruct().getUlRowQty()--;
                        }
                        else {
                            pOutputMsg600.getCINV20SOG00_ARRAY().getCINV20SOG00(i326).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getUlIdEvent());
                            i326++;
                        }
                        
                        if (0 == szCdEventType3.compareTo(ASSMT_EVENT_TYPE) && ulIdOutcomeMatrixEvent == null && 0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(CARE_TASK) && 0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_COMP)) {
                            pOutputMsg600.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg600.getCINV59SOG01().ulRowQty, CLT_ASSMT_WARNING);
                            pOutputMsg600.getCINV59SOG01().ulRowQty++;
                        }
                    }
                }
                
                //  If Outcome Matrix Event Type given, set Event ID in
                // output message to Event ID returned from DAM
                else if (ulIdOutcomeMatrixEvent != null) {
                    ulIdOutcomeMatrixEvent.value = pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent();
                }
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                //  If no rows found it is ok and rc is returned successful
            case NO_DATA_FOUND:
                
                
                
                //  Initialize Service Status Fields
                
                
                //  SIR 13618 - Call CINVB8D to determine if a Request for Review
                // contact was recorded.
                rc = NO_DATA_FOUND;
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    
    static int CallCINV34D(CINV20SI pInputMsg648, CINV20SO pOutputMsg601, Pint ulIdClient, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i327 = 0;
        
        /*
        ** Declare local variables
        */
        /*
        ** SIR 13532 - Add flags to determine unknown name, principals,
        **             and whether or not characteristics apply.
        */
        CINV34DI pCINV34DInputRec = null;
        CINV34DO pCINV34DOutputRec = null;
        int /* SIR 13532 */
        bUnknownName = 0;
        int bPersCharPrn = 0;
        int bNoCharAppl = 0;
        boolean bLivingArrange = false;
        /*
        ** SIR 13532 - Add unknown name flag
        */
        boolean bPersCharacter = false;
        boolean bVictimDob = false;
        boolean bPersSearch = false;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV34DInputRec = new CINV34DI();
        
        
        pCINV34DOutputRec = new CINV34DO();
        pCINV34DInputRec.setArchInputStruct(pInputMsg648.getArchInputStruct());
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(0);
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV34DO._CINV34DO__ROWCINV34DO_SIZE);
        
        pCINV34DInputRec.setUlIdStage(pInputMsg648.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(PERSON_TYPE_STF);
        pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(1);
        
        /*
        ** Set loop to retrieve all the persons associated with the case
        */
        while (pCINV34DOutputRec.getArchOutputStruct().getBMoreDataInd() != 0) {
            pCINV34DInputRec.getArchInputStruct().getUsPageNbr()++;
            rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    for (i327 = 0;i327 < pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();++i327) {
                        //  SIR 13532: Reset bUnknownName, bPersCharPrn
                        // & bNoCharAppl for each person in the loop
                        bUnknownName = 0;
                        bPersCharPrn// SIR 13532
                         = 0;
                        bNoCharAppl// SIR 13532
                         = 0;
                        if ((null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzNmPersonFirst()[0]) && (null == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzNmPersonLast()[0])) {
                            bUnknownName = 1;
                            
                        }
                        if (EDIT_YES == pInputMsg648.getSzDcdEditProcess()[LIVING_ARRANGE_EDIT] && (!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole() , PERSON_ROLE_BOTH, PERSON_ROLE_BOTH.length()) != 0) ||!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole() , PERSON_ROLE_CLIENT, PERSON_ROLE_CLIENT.length()) != 0) ||!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole() , PERSON_ROLE_VICTIM, PERSON_ROLE_VICTIM.length()) != 0)) &&!(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdPersonLivArr().compareTo("") != 0) && true != bUnknownName) {
                            
                            bLivingArrange = true;
                        }
                        //  Retrieve all the events associated with the Investigation.
                        // SIR 13618, 04/15/97 - MHMR Enhancement for "APS Rapid
                        // Closure". If the case is Rapid Closure, do not
                        // assign any edits to be displayed.
                        if (0 != CD_DOES_NOT_MEET_DEFINITION.compareTo(pInputMsg648.getSzCdStageReasonClosed())) {
                            if // if event status is anything but "COMP"
                            ((EDIT_YES == pInputMsg648.getSzDcdEditProcess()[PERS_CHARACTER_EDIT]) && ((PERSON_CHAR_NONE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getBCdPersonChar()) || (PERSON_CHAR_NULL == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getBCdPersonChar())) && (0 == PERSON_TYPE_PRN.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersType()))) {
                                bPersCharPrn = 1;
                            }
                            //  ERR# 1674 Do not return warning if Contact, Priority,
                            // or Med/Mental events are new.
                            //  SIR 5165
                            // Added Change Case Name to events that are ok to be
                            // NEW
                            if ((EDIT_YES == pInputMsg648.getSzDcdEditProcess()[PERS_CHARACTER_EDIT]) && (PERSON_CHAR_TWO == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getBCdPersonChar()) && ((0 == strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole() , PERSON_ROLE_BOTH, PERSON_ROLE_BOTH.length())) || (0 == strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole() , PERSON_ROLE_VICTIM, PERSON_ROLE_VICTIM.length())) || (0 == strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole() , PERSON_ROLE_CLIENT, PERSON_ROLE_CLIENT.length())))) {
                                bNoCharAppl = 1;
                            }
                            if (((bPersCharPrn) || (bNoCharAppl)) && (!bUnknownName)) {
                                bPersCharacter = true;
                            }
                        }
                        if (EDIT_YES == pInputMsg648.getSzDcdEditProcess()[VICTIM_DOB_EDIT] &&!(strncmp(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersType() , PERSON_TYPE_PRN, PERSON_TYPE_PRN.length()) != 0) && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getDtDtPersonBirth().day && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getDtDtPersonBirth().month && DateHelper.NULL_DATE == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getDtDtPersonBirth().year && true != bUnknownName) {
                            bVictimDob = true;
                        }
                        
                        if ((EDIT_YES == pInputMsg648.getSzDcdEditProcess()[PERS_SEARCH_EDIT]) && ((PERSON_SEARCH_R != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersSearchInd()) && (PERSON_SEARCH_V != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersSearchInd())) && (0 != PERSON_TYPE_COL.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersType())) && (!bUnknownName)) {
                            bPersSearch = true;
                        }
                        //  If the event status is something other than "COMP", then
                        // the event might not be eligible for closure.
                        // 
                        if (0 == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole().compareTo(PERSON_ROLE_BOTH) || 0 == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole().compareTo(PERSON_ROLE_VICTIM) || 0 == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getSzCdStagePersRole().compareTo(PERSON_ROLE_CLIENT)) {
                            ulIdClient.value = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i327).getUlIdPerson();
                        }
                        //  ERR# 1674 -  If the event is a "NEW" Contact, "NEW"
                        // Priority, or "NEW" Medical/Mental event, then
                        // do not return the "uncompleted event" warning.
                        // The event is eligible for closure.
                        if (bLivingArrange && bPersCharacter && bVictimDob && bPersSearch) {
                            
                            
                            break;
                        }
                    }
                    
                    // Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    break;
            }
            if (rc != 0 || bLivingArrange && bPersCharacter && bVictimDob && bPersSearch) {
                pCINV34DOutputRec.getArchOutputStruct().setBMoreDataInd(0);
            }
        }
        if (bLivingArrange) {
            pOutputMsg601.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg601.getCINV59SOG01().ulRowQty, LIVING_ARRANGE_WARNING);
            pOutputMsg601.getCINV59SOG01().ulRowQty++;
        }
        if (bPersCharacter) {
            pOutputMsg601.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg601.getCINV59SOG01().ulRowQty, PERS_CHARACTER_WARNING);
            pOutputMsg601.getCINV59SOG01().ulRowQty++;
        }
        if (bVictimDob) {
            pOutputMsg601.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg601.getCINV59SOG01().ulRowQty, VICTIM_DOB_WARNING);
            pOutputMsg601.getCINV59SOG01().ulRowQty++;
        }
        if (bPersSearch) {
            pOutputMsg601.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg601.getCINV59SOG01().ulRowQty, PERS_SEARCH_WARNING);
            
            pOutputMsg601.getCINV59SOG01().ulRowQty++;
        }
        
        return rc;
    }

    static int CallCINV43D(CINV20SI pInputMsg649, CINV20SO * pOutputMsg602, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setArchInputStruct(pInputMsg649.getArchInputStruct());
        pCINV43DInputRec.setUlIdEvent(pInputMsg649.getUlIdEvent());
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Call architecture function to retreive the current date.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                //  Add 100 years to todays date
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    static int CallCINV84D(CINV20SI pInputMsg650, CINV20SO pOutputMsg603, Pint pulIdOutcomeMatrixEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV84DI pCINV84DInputRec = null;
        CINV84DO pCINV84DOutputRec = null;
        int ulTempIdStage = 0;
        int ulIdSituation4 = 0;
        int ulIdEvent18 = 0;
        Pchar bYesFactors = new Pchar();
        bYesFactors.value = 0;
        boolean ulIdOutcomeMatrixEvent = false;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV84DInputRec = new CINV84DI();
        
        pCINV84DOutputRec = new CINV84DO();
        
        pCINV84DInputRec.setArchInputStruct(pInputMsg650.getArchInputStruct());
        /* Process utility Function */
        pCINV84DInputRec.setUlIdSituation(pInputMsg650.getUlIdSituation());
        pCINV84DInputRec.setSzCdStage(SERV_DELIVERY_STAGE);
        
        //## BEGIN TUX/XML: Declare XML variables
        pCINV84DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINV84DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        rc = cinv84dQUERYdam(sqlca, pCINV84DInputRec, pCINV84DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Set temporary stage variable and move output stage ID
                // to input message
                ulTempIdStage = pInputMsg650.getUlIdStage();
                pInputMsg650.setUlIdStage(pCINV84DOutputRec.getROWCINV84DO_ARRAY().getROWCINV84DO(0).getUlIdStage());
                rc = CallCCMN87AD(pInputMsg650, EVENT_TYPE_OUTCOME_MATRIX, pOutputMsg603, pulIdOutcomeMatrixEvent, pServiceStatus);
                pInputMsg650.setUlIdStage(ulTempIdStage);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        //  IMPACT BEGIN
                        // bIndEvent = FALSE;
                        //  IMPACT END
                        
                        
                        // 
                        // SIR 21330c: The Invalidate Approval function also has to be called
                        // for the Placement event if its status was pending.  This needs
                        // to be done so that the record on the Approvers table is set
                        // from 'PEND' to 'INVD', which will give the standard Invalid
                        // Approval message when navigating on the now invalid Approval ToDo.
                        // 
                        if (EDIT_YES == pInputMsg650.getSzDcdEditProcess()[OUT_MATRIX_ACTIONS_EDIT] && pulIdOutcomeMatrixEvent.value != 0) {
                            
                            //  Set rc to RetVal so TUX_CHECK_APPL_STATUS will work
                            rc = Csvc16s.CallCINV96D(pInputMsg650, pOutputMsg603, pulIdOutcomeMatrixEvent, pServiceStatus);
                            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        ulIdSituation4 = pInputMsg650.getUlIdSituation();
                        if (!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_REFUSED) != 0) ||!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_NOT_AVAIL) != 0) ||!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_NOT_REQ) != 0) ||!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_VALID) != 0)) {
                            rc = CallCCMN87AD(pInputMsg650, ASSMT_EVENT_TYPE, pOutputMsg603, pulIdOutcomeMatrixEvent, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) 
                            {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    rc = CallCINV35D(pInputMsg650, pOutputMsg603, bYesFactors, pulIdOutcomeMatrixEvent.value, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    rc = CallCINVD4D(pInputMsg650, pOutputMsg603, bYesFactors, pulIdOutcomeMatrixEvent.value, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    break;
                                case NO_DATA_FOUND:
                                    bYesFactors.value = 0;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            }
                            
                            // Return if InvalidateAprvl() failed.
                            if (bYesFactors.value != 0) {
                                
                                
                                
                                if (0 == pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_VALID)) {
                                    pOutputMsg603.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg603.getCINV59SOG01().ulRowQty, OUT_MATRIX_REQ_WARNING);
                                    pOutputMsg603.getCINV59SOG01().ulRowQty++;
                                }
                            }
                            else // At least one item must be indicated as Problem or Severe
                            // Problem on CARE to close the investigation with the selected Closure Reason.
                            {
                                pOutputMsg603.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg603.getCINV59SOG01().ulRowQty, Messages.MSG_INV_CARE_PROB_WARNING);
                                pOutputMsg603.getCINV59SOG01().ulRowQty++;
                                
                                
                            }
                        }
                        rc = 0;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        break;
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                ulIdSituation4 = pInputMsg650.getUlIdSituation();
                if (!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_REFUSED) != 0) ||!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_NOT_AVAIL) != 0) ||!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_NOT_REQ) != 0) ||!(pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_VALID) != 0)) {
                    rc = CallCCMN87AD(pInputMsg650, ASSMT_EVENT_TYPE, pOutputMsg603, pulIdOutcomeMatrixEvent, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            rc = CallCINV35D(pInputMsg650, pOutputMsg603, bYesFactors, pulIdOutcomeMatrixEvent.value, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            rc = CallCINVD4D(pInputMsg650, pOutputMsg603, bYesFactors, pulIdOutcomeMatrixEvent.value, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            break;
                        case NO_DATA_FOUND:
                            bYesFactors.value = 0;
                            break;
                            // 
                            // END SIR 675!!!
                            // 
                            
                            
                            //  Process error from function
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                    if (bYesFactors.value != 0) {
                        rc = CallCCMN87AD(pInputMsg650, EVENT_TYPE_OUTCOME_MATRIX, pOutputMsg603, pulIdOutcomeMatrixEvent, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                
                                if (EDIT_YES == pInputMsg650.getSzDcdEditProcess()[OUT_MATRIX_ACTIONS_EDIT] && ulIdOutcomeMatrixEvent) {
                                    rc = Csvc16s.CallCINV96D(pInputMsg650, pOutputMsg603, pulIdOutcomeMatrixEvent, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                }
                                break;
                            case NO_DATA_FOUND:
                                
                                if (0 == pInputMsg650.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_VALID)) {
                                    pOutputMsg603.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg603.getCINV59SOG01().ulRowQty, OUT_MATRIX_REQ_WARNING);
                                    pOutputMsg603.getCINV59SOG01().ulRowQty++;
                                }
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                break;
                        }
                    }
                    else // At least one item must be indicated as Problem or Severe
                    // Problem on CARE to close the investigation with the selected Closure Reason.
                    {
                        pOutputMsg603.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg603.getCINV59SOG01().ulRowQty, Messages.MSG_INV_CARE_PROB_WARNING);
                        pOutputMsg603.getCINV59SOG01().ulRowQty++;
                    }
                }
                
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                // 01/22/2003 DWW: Added for error handling
                // if ( RetVal == FND_SUCCESS ) { rc = FND_SUCCESS; }
                
                // 01/30/2003 Since this server almost never uses rc, I am just setting rc to RetVal,
                // so that the server will actually return correct error codes
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCINV96D(CINV20SI pInputMsg651, CINV20SO pOutputMsg604, Pint ulIdOutcomeMatrixEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /*
        ** Declare local variables
        */
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV96DI pCINV96DInputRec = null;
        CINV96DO pCINV96DOutputRec = null;
        int i328 = 0;
        
        /* SIR 5034 */
        boolean bNoOutcome = false;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV96DInputRec = new CINV96DI();
        
        pCINV96DOutputRec = new CINV96DO();
        pCINV96DInputRec.setArchInputStruct(pInputMsg651.getArchInputStruct());
        pCINV96DInputRec.setUlIdEvent(ulIdOutcomeMatrixEvent.value);
        
        pCINV96DInputRec.getArchInputStruct().setUsPageNbr(1);
        
        pCINV96DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        
        rc = cinv96dQUERYdam(sqlca, pCINV96DInputRec, pCINV96DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Set Calculated Retention date to maximum date
                if ((0 == CLOSE_CODE_ADMIN.compareTo(pInputMsg651.getSzCdStageReasonClosed())) || (0 == CLOSE_CODE_DIED.compareTo(pInputMsg651.getSzCdStageReasonClosed()))) {
                    for (i328 = 0;i328 < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty() && bNoOutcome == false;i328++) {
                        
                        if (0 == EMPTY_STRING.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(i328).getSzCdApsOutcomeResult())) {
                            pOutputMsg604.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg604.getCINV59SOG01().ulRowQty, Messages.MSG_INV_MATRIX_COMP);
                            pOutputMsg604.getCINV59SOG01().ulRowQty++;
                            
                            bNoOutcome = true;
                        }
                    }
                    
                }
                //  SIR 5034
                // Don't change the behavior for all other closure codes
                else {
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pOutputMsg604.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg604.getCINV59SOG01().ulRowQty, OUT_MATRIX_ACT_WARNING);
                    pOutputMsg604.getCINV59SOG01().ulRowQty++;
                }
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                
                // Habib
                // UPDATE FACILITY_LOC
                // SET    DT_FLOC_END = :hI_dtDtFlocEnd:hI_dtDtFlocEnd_i
                // WHERE  DT_FLOC_END = '12/31/4712'
                // AND    ID_RESOURCE = :hI_ulIdResource:hI_ulIdResource_i;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCSYS18D(CINV20SI pInputMsg652, CINV20SO pOutputMsg605, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSYS18DI pCSYS18DInputRec = null;
        CSYS18DO pCSYS18DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS18DInputRec = new CSYS18DI();
        
        pCSYS18DOutputRec = new CSYS18DO();
        pCSYS18DInputRec.setArchInputStruct(pInputMsg652.getArchInputStruct());
        pCSYS18DInputRec.setUlIdStage(pInputMsg652.getUlIdStage());
        
        /*
        ** Call CheckStageEventStatus
        */
        rc = csys18dQUERYdam(sqlca, pCSYS18DInputRec, pCSYS18DOutputRec);
        
        switch (rc) {
                
                //  Success Case for Dam CSES75D
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                //  Success Case for Dam CSES68D
            case NO_DATA_FOUND:
                pOutputMsg605.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg605.getCINV59SOG01().ulRowQty, CONTACT_WARNING);
                
                pOutputMsg605.getCINV59SOG01().ulRowQty++;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        
        return rc;
    }

    static int CloseStage(CINV20SI pInputMsg653, CINV20SO pOutputMsg606, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        rc = Ccmn05u.CallCCMN62D(pInputMsg653, pOutputMsg606, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        if (!(strncmp(pInputMsg653.getSzCdStageReasonClosed() , CLOSE_CODE_VALID, CLOSE_CODE_VALID.length()) != 0)) {
            //  Allocate memory for CloseOpenStage Input
            // and Output Structures
            pCCMN03UInputRec = new CCMN03UI();
            
            pCCMN03UOutputRec = new CCMN03UO();
            
            pCCMN03UInputRec.setUlIdStage(pInputMsg653.getUlIdStage());
            pCCMN03UInputRec.setSzCdStage(pInputMsg653.getSzCdStage());
            pCCMN03UInputRec.setSzCdStageProgram(pInputMsg653.getSzCdStageProgram());
            pCCMN03UInputRec.setSzCdStageOpen(SERV_DELIVERY_STAGE);
            pCCMN03UInputRec.setSzCdStageReasonClosed(pInputMsg653.getSzCdStageReasonClosed());
            rc = Ccmn03u.CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        /*
        ** Close the Investigation Stage and the Case
        */
        else {
            //  Allocate memory for CloseStageCase Input
            // and Output Structures
            pCCMN02UInputRec = new CCMN02UI();
            
            pCCMN02UOutputRec = new CCMN02UO();
            pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(pInputMsg653.getUlIdStage());
            pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(pInputMsg653.getSzCdStage());
            pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(pInputMsg653.getSzCdStageProgram());
            pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(pInputMsg653.getSzCdStageReasonClosed());
            
            //  Call CAUD17D.  The Contract Service AUD performs a full row
            // insert to the Contract Service table.
            rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCCMN87BD(CINV20SI pInputMsg654, String szCdEventType4, CINV20SO pOutputMsg607, Pint ulIdOutcomeMatrixEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        int usEventCtr = 0;
        //Added counter to pass the bIndVictimRole counter to marshal function - Srini
        int counter = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg654.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg654.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(szCdEventType4);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        
        if (szCdEventType4.compareTo("") != 0) {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        }
        else {
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV20SO._CINV20SO__CINV20SOG00_SIZE);
        }
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (!(szCdEventType4.compareTo("") != 0)) {
                    pOutputMsg607.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                    
                    for (usEventCtr = 0;usEventCtr < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();usEventCtr++) {
                        if (pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_COMP) != 0) {
                            if (!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_CONTACT) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_OUTCOME_MATRIX) != 0) && (!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0) ||!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS) != 0))) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_PRIORITY_CHANGE) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!(!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(EVENT_TYPE_MED_MENTAL_ASSESS) != 0) &&!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW) != 0)) &&!!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(LEGAL_ACTION_EVENT_TYPE) != 0) &&!!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(SERVICE_AUTH_EVENT_TYPE) != 0) &&!!(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(GUARDIANSHIP_EVENT_TYPE) != 0)) {
                                if ((0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(OUTCOME_MATRIX_TASK)) && (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(CLIENT_ASSMT_TASK)) && ((0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(CONTACTS_TASK)) && ((0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzTxtEventDescr().compareTo(THREE_MONTH_CONTACT)) || (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzTxtEventDescr().compareTo(MONTHLY_SUMMARY_CONTACT))))) {
                                    
                                    //  Analyze error code
                                    if ((0 != pInputMsg654.getSzDcdEditProcess().compareTo(DECODE_NO_EDITS)) &&!((0 == pInputMsg654.getSzDcdEditProcess().compareTo(CLIENT_DIED)) && (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(CARE_TASK)) && (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS)))) {
                                        pOutputMsg607.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg607.getCINV59SOG01().ulRowQty, EVENT_STATUS_WARNING);
                                        pOutputMsg607.getCINV59SOG01().ulRowQty++;
                                        
                                        break;
                                    }
                                }
                            }
                        }
                        if ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(OUTCOME_MATRIX_TASK)) && ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW)) || (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS)))) {
                            pOutputMsg607.getArchOutputStruct().getUlRowQty()--;
                        }
                        else if ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(CONTACTS_TASK)) && ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzTxtEventDescr().compareTo(THREE_MONTH_CONTACT)) || (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzTxtEventDescr().compareTo(MONTHLY_SUMMARY_CONTACT))) && ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW)) || (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS)))) {
                            pOutputMsg607.getArchOutputStruct().getUlRowQty()--;
                        }
                        else if (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdTask().compareTo(SERVICE_AUTH_TASK)) {
                            pOutputMsg607.getArchOutputStruct().getUlRowQty()--;
                        }
                        
                        //  SIR 21885 - If the event is a NEW Guardianship event,
                        // do not change its status to PENDING.
                        else if ((0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventStatus().compareTo(EVENT_STATUS_NEW)) && (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(GUARDIANSHIP_EVENT_TYPE))) {
                            pOutputMsg607.getArchOutputStruct().getUlRowQty()--;
                        }
                        
                        //  SIR 13057, 02/07/97 - If the event is an approval
                        // event, do not change its status to PENDING.
                        else if (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getSzCdEventType().compareTo(APPROVAL_EVENT_TYPE)) {
                            pOutputMsg607.getArchOutputStruct().getUlRowQty()--;
                        }
                        else {
                            pOutputMsg607.getCINV20SOG00_ARRAY().getCINV20SOG00(counter++).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(usEventCtr).getUlIdEvent());
                        }
                    }
                }
                
                
                
                //  If Outcome Matrix Event Type given, set Event ID in
                // output message to Event ID returned from DAM
                else if (ulIdOutcomeMatrixEvent != null) {
                    ulIdOutcomeMatrixEvent.value = pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent();
                }
                
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                rc = NO_DATA_FOUND;
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                // 
                // End Call CSYS06D
                // 
                
                
                break;
        }
        return rc;
    }

    static int CSVC09CreateAOM(int ulIdSituation5, Pint pulIdEvent, CINV20SI pInputMsg655, CINV20SO pOutputMsg608, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        CSYS21DI.ArchInputStruct ArchInputStruct4 = null;
        ROWCCMN01UIG00 EventStruct1 = null;
        boolean rc = false;
        FndInt3date dtCurDate = null;
        
        /* Get Date Event Occurred. */
        ARC_UTLGetDateAndTime(dtCurDate, 0);
        ArchInputStruct4.setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        EventStruct1.setSzCdTask(OUTCOME_MATRIX_TASK);
        
        if (!(pInputMsg655.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_REFUSED) != 0) ||!(pInputMsg655.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_NOT_AVAIL) != 0) ||!(pInputMsg655.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_NOT_REQ) != 0)) {
            EventStruct1.setSzCdEventStatus(EVENT_STATUS_COMP);
        }
        else if (!(pInputMsg655.getSzCdStageReasonClosed().compareTo(CLOSE_CODE_VALID) != 0)) {
            EventStruct1.setSzCdEventStatus(EVENT_STATUS_NEW);
        }
        EventStruct1.setSzCdEventType(EVENT_TYPE_OUTCOME_MATRIX);
        EventStruct1.setDtDtEventOccurred(dtCurDate);
        //## BEGIN TUX/XML: Declare XML variables 
        EventStruct1.setUlIdStage(pInputMsg655.getUlIdStage());
        EventStruct1.setUlIdPerson(pInputMsg655.getUlIdPerson());
        EventStruct1.setSzTxtEventDescr(AOM_EVENT_DESCR);
        
        /*
        ** Call DAM
        */
        rc = Ccmn25s.CallPostEvent(ArchInputStruct4, EventStruct1, pulIdEvent, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        rc = CallCSVC16D(ulIdSituation5, pulIdEvent.value, pInputMsg655, pOutputMsg608, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCSVC16D(int ulIdSituation6, int ulIdEvent19, CINV20SI pInputMsg656, CINV20SO * pOutputMsg609, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i329 = 0;
        CSVC16DI pCSVC16DI = null;
        CSVC16DO pCSVC16DO = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC16DI = new CSVC16DI();
        
        pCSVC16DO = new CSVC16DO();
        pCSVC16DI.setArchInputStruct(pInputMsg656.getArchInputStruct());
        pCSVC16DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCSVC16DI.setUlIdSituation(ulIdSituation6);
        pCSVC16DI.setUlIdEvent(ulIdEvent19);
        
        
        /*
        ** Call CCMN01U
        */
        rc = csvc16dAUDdam(sqlca, pCSVC16DI, pCSVC16DO);
        
        switch (rc) {
            case SUCCESS:
                
                break;
                
            case NO_DATA_FOUND:
                
                //  Set rc to SQL_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct5, ROWCCMN01UIG00 ROWCCMN01UIG004, Pint ulIdEvent20, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /*
        ** Declare local variables
        */
        int rc = SUCCESS;
        CCMN01UI pInputMsg657 = null;
        CCMN01UO pOutputMsg610 = null;
        pInputMsg657 = new CCMN01UI();
        pOutputMsg610 = new CCMN01UO();
        
        if ((ArchInputStruct5 == null) || (ROWCCMN01UIG004 == null) || (ulIdEvent20 == null)) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        
        pInputMsg657.setArchInputStruct(ArchInputStruct5);
        pInputMsg657.setROWCCMN01UIG00(ROWCCMN01UIG004);
        pOutputMsg610.setUlIdEvent(ulIdEvent20.value);
        
        /*
        ** Call DAM
        */
        rc = Ccmn01u.PostEvent(pInputMsg657, pOutputMsg610, pServiceStatus);
        
        if (ulIdEvent20.value == null) {
            ulIdEvent20.value = pOutputMsg610.getUlIdEvent();
        }
        return rc;
    }

    static int CallCINV35D(CINV20SI pInputMsg658, CINV20SO pOutputMsg611, String bYesFactors, int ulIdOutcomeMatrixEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i330 = 0;
        
        /*
        ** Declare local variables
        */
        CINV35DI pCINV35DInputRec = null;
        CINV35DO pCINV35DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV35DInputRec = new CINV35DI();
        
        pCINV35DOutputRec = new CINV35DO();
        pCINV35DInputRec.setArchInputStruct(pInputMsg658.getArchInputStruct());
        pCINV35DInputRec.setUlIdEvent(ulIdOutcomeMatrixEvent);
        pCINV35DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg658.getArchInputStruct().getUsPageNbr());
        pCINV35DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg658.getArchInputStruct().getUlPageSizeNbr());
        
        rc = cinv35dQUERYdam(sqlca, pCINV35DInputRec, pCINV35DOutputRec);
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        
        else {
            
            //  Populate Output Message
            for (i330 = 0;i330 < pCINV35DOutputRec.getArchOutputStruct().getUlRowQty();++i330) {
                if (!(strncmp(pCINV35DOutputRec.getROWCINV35DO_ARRAY().getROWCINV35DO(i330).getSzCdApsCltFactorAns() , FACTOR_ANSWER_YES, FACTOR_ANSWER_YES.length()) != 0)) {
                    bYesFactors = CStringUtils.setCharAt(bYesFactors, 0, true);
                    break;
                }
            };
            pOutputMsg611.getArchOutputStruct().setUlRowQty(pCINV35DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        return rc;
    }

    static int CallCINVD4D(CINV20SI pInputMsg659, CINV20SO pOutputMsg612, String bYesFactors, int ulIdOutcomeMatrixEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i331 = 0;
        
        /*
        ** Declare local variables
        */
        CINVD4DI pCINVD4DInputRec = null;
        CINVD4DO pCINVD4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVD4DInputRec = new CINVD4DI();
        
        pCINVD4DOutputRec = new CINVD4DO();
        pCINVD4DInputRec.setArchInputStruct(pInputMsg659.getArchInputStruct());
        pCINVD4DInputRec.setUlIdEvent(ulIdOutcomeMatrixEvent);
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCINVD4DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg659.getArchInputStruct().getUsPageNbr());
        pCINVD4DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg659.getArchInputStruct().getUlPageSizeNbr());
        
        rc = cinvd4dQUERYdam(sqlca, pCINVD4DInputRec, pCINVD4DOutputRec);
        
        
        /*
        ** If we are dealing with one of the Contact Types that require
        ** System Generated To-Do's, and we have marked the Event COMPlete,
        ** then we need to create a new set of Contact Shells, NEW Events,
        ** and To-Dos.
        **
        ** One exception:
        ** If the Contact was already marked COMPlete during an earlier Save,
        ** and we are modifying the Event, then we do NOT want to create another
        ** To-Do, Contact Shell, nor NEW Event.
        */
        
        
        
        /*
        ** SIR 3831 - Added PAL monthly summary
        */
        
        /*
        ** SIR 2041: Conditions added to include release 2 contacts
        */
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        
        else {
            
            //  Populate Output Message
            for (i331 = 0;i331 < pCINVD4DOutputRec.getArchOutputStruct().getUlRowQty();++i331) {
                if (!(strncmp(pCINVD4DOutputRec.getROWCINVD4DO_ARRAY().getROWCINVD4DO(i331).getSzCdCareFactorRspnse() , FACTOR_ANSWER_PROB, FACTOR_ANSWER_PROB.length()) != 0) ||!(strncmp(pCINVD4DOutputRec.getROWCINVD4DO_ARRAY().getROWCINVD4DO(i331).getSzCdCareFactorRspnse() , FACTOR_ANSWER_SEV_PROB, FACTOR_ANSWER_SEV_PROB.length()) != 0)) {
                    bYesFactors = CStringUtils.setCharAt(bYesFactors, 0, true);
                    break;
                }
            }
            pOutputMsg612.getArchOutputStruct().setUlRowQty(pCINVD4DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        return rc;
    }

    
    static int CallServiceAuth(CINV20SI pInputMsg660, CINV20SO pOutputMsg613, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i332 = 0;
        int j = 0;
        int rc = 0;
        
        Pint ulRowQtyEvent = new Pint();
        Pint ulRowQtySvcAuthDetail = new Pint();
        int[] ulIdEvent21 = new int[CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE];
        Pint ulIdSvcAuth4 = new Pint();
        String cIndSvcAuthComplete1 = new String();
        
        FndInt3date[] dtSvcAuthDtlTermDate = new FndInt3date[CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE];
        
        /*
        ** for each IdEvent returned from the DAM search the
        ** SVC_AUTH_EVENT_LINK table to find corresponding
        ** Service Auth Id.
        */
        
        
        
        for (int dtSvcAuthDtlTermDate1 = 0;dtSvcAuthDtlTermDate1 < dtSvcAuthDtlTermDate.length;dtSvcAuthDtlTermDate1++) {
            dtSvcAuthDtlTermDate[dtSvcAuthDtlTermDate1] = new FndInt3date();
        }
        FndInt3date dtCurrentDate = null;
        
        char bSvcAuthFlag = 1;
        
        
        /* populate CurrentDate variable with current date */
        ARC_UTLGetDateAndTime(dtCurrentDate, 0);
        rc = Cinv15s.CallCCMN87D(pInputMsg660, SVC_AUTH_EVENT_TYPE, ulRowQtyEvent, ulIdEvent21, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  For each Term date returned from the DAM, check it
                // to make sure it isn't greater than the current date.
                // If it is set the SvcAuthFlag to false.
                
                for (i332 = 0;i332 <= (ulRowQtyEvent.value - 1);i332++) {
                    if (!(bSvcAuthFlag != 0)) {
                        break;
                    }
                    
                    //  SIR 2771 01/20/96 - BSM
                    // Set Person Assigned to Contract Manager instead of
                    // Current User's Supervisor.  ToDo show date should also
                    // be set to the current date
                    rc = Ccmn35s.CallCSES24D(pInputMsg660, ulIdEvent21[i332], ulIdSvcAuth4, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            //  Call CSUB40U - ToDo Common Function
                            rc = Csvc16s.CallCLSS24D(pInputMsg660, ulIdSvcAuth4.value, ulRowQtySvcAuthDetail, dtSvcAuthDtlTermDate, cIndSvcAuthComplete1, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                    for (j = 0;j <= (ulRowQtySvcAuthDetail.value - 1);j++) {
                                        if (cIndSvcAuthComplete1.charAt(j) == 'Y') {
                                            
                                            // 
                                            // (END): CSES81D - Contract Version retrieve for an idContract
                                            // , contract period number, and version end date that is greater
                                            // than the current date.
                                            // 
                                            
                                            // 
                                            // (END): Contracts existance determination.  Is there an open foster
                                            // and adoptive contract for the home? SIR 20360
                                            // 
                                            
                                            // 
                                            // (BEGIN): Contract creation process if the contract does not already
                                            // exist. SIR 20360
                                            // 
                                            if ((ARC_UTLCompareDateAndTime((FndInt3date) & dtSvcAuthDtlTermDate[j], 0, (FndInt3date) & dtCurrentDate, 0)) > 0) {
                                                bSvcAuthFlag = 0;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    break;
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            break;
                    }
                }
                break;
            case NO_DATA_FOUND:
                return WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
        }
        if (!bSvcAuthFlag) {
            
            pOutputMsg613.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg613.getCINV59SOG01().ulRowQty, Messages.MSG_CLOSE_SVC_AUTH);
            // 
            // end sir #15712 - ochumd
            // 
            
            // 
            // Function Prototypes
            // 
            pOutputMsg613.getCINV59SOG01().ulRowQty++;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    
    
    static int CallCCMN87D(CINV20SI pInputMsg661, String szCdEventType5, Pint ulRowQty2, Pint ulIdEvent22, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i333 = 0;
        int j = 0;/* SIR# 5366: Loop counter */
        
        /*
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg661.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg661.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(szCdEventType5);
        
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                // SIR# 5366 - Only return the rows which an actual row
                // exists in the SVC AUTH DETAIL Table. Do NOT count rows which
                // are PROC or NEW.
                for (j = 0;j < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                    if ((0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(j).getSzCdEventStatus().compareTo(CD_EVENT_STATUS_PROCESS)) && (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(j).getSzCdEventStatus().compareTo(CD_EVENT_STATUS_NEW))) {
                        ulIdEvent22[i333] = pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(j).getUlIdEvent();
                        i333++;
                    }
                }
                ulRowQty2.value = i333;
                if (0 == i333) {
                    rc = NO_DATA_FOUND;
                }
                else {
                    
                    //  Call DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
            case NO_DATA_FOUND:
                rc = NO_DATA_FOUND;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCSES24D(CINV20SI pInputMsg662, int ulIdEvent23, Pint ulIdSvcAuth5, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCSES24DInputRec.setArchInputStruct(pInputMsg662.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(ulIdEvent23);
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdSvcAuth5.value = pCSES24DOutputRec.getUlIdSvcAuth();
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    static int CallCLSS24D(CINV20SI pInputMsg663, int ulIdSvcAuth6, Pint ulRowQty3, FndInt3date dtTermDate, String cIndSvcAuthComplete2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i334 = 0;
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS24DInputRec = new CLSS24DI();
        
        pCLSS24DOutputRec = new CLSS24DO();
        pCLSS24DInputRec.setArchInputStruct(pInputMsg663.getArchInputStruct());
        pCLSS24DInputRec.setUlIdSvcAuth(ulIdSvcAuth6);
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ulRowQty3.value = pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();
                
                for (i334 = 0;i334 < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();i334++) {
                    dtTermDate[i334] = pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i334).getDtDtSvcAuthDtlTerm();
                    cIndSvcAuthComplete2 = CStringUtils.setCharAt(cIndSvcAuthComplete2, i334, pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i334).getCIndSvcAuthComplete());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        
        return rc;
    }

    static int CheckAOMActions(CINV20SI pInputMsg664, CINV20SO pOutputMsg614, int ulIdOutcomeMatrixEvent, int ulIdClient, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINV96DI pCINV96DInputRec = null;
        CINV96DO pCINV96DOutputRec = null;
        CCMNB6DI CCMNB6DI = null;
        CCMNB6DO CCMNB6DO = null;
        CSVC48DI CCMN48DInputRec = null;
        CSVC48DO CCMN48DOutputRec = null;
        Pint ulIdCase2 = new Pint();
        Pint legalActions = new Pint();
        int k = 0;/* Loop Counters */
        int i335 = 0;
        
        Pint ulRowQtyEvent = new Pint();
        int[] ulIdEvent24 = new int[CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE];
        Pint ulIdSvcAuth7 = new Pint();
        Pchar cIndDntdCmmtySvc1 = new Pchar();
        
        char bDntdCmmtySvc = 0;
        char bOtherThanDntdCmmtySvc = 0;
        
        boolean bShowLegalMsg = false;
        boolean bShowECSMsg = false;
        boolean bShowCommMsg = false;
        
        /* take the outcome matrix event id and get the array of actions */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV96DInputRec = new CINV96DI();
        
        pCINV96DOutputRec = new CINV96DO();
        pCINV96DInputRec.setArchInputStruct(pInputMsg664.getArchInputStruct());
        pCINV96DInputRec.setUlIdEvent(ulIdOutcomeMatrixEvent);
        pCINV96DInputRec.getArchInputStruct().setCReqFuncCd(INV_VALIDATION);
        pCINV96DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINV96DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV96DO._CINV96DO__ROWCINV96DO_SIZE);
        rc = cinv96dQUERYdam(sqlca, pCINV96DInputRec, pCINV96DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                // loop through array of outcome matrix actions
                for (k = 0;k < pCINV96DOutputRec.getArchOutputStruct().getUlRowQty();k++) {
                    
                    if (0 == AOM_ACTION_LEGAL.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) &&!bShowLegalMsg) {
                        CCMNB6DI.setUlIdStage(pInputMsg664.getUlIdStage());
                        rc = CallCCMNB6D(CCMNB6DI, CCMNB6DO, ulIdCase2, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        CCMN48DInputRec.setUlIdCase(ulIdCase2.value);
                        CCMN48DInputRec.setUlIdPerson(ulIdClient);
                        
                        //  Call CMSC23D
                        rc = Csvc16s.CallCSVC48D(CCMN48DInputRec, CCMN48DOutputRec, legalActions, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        if (legalActions.value == 0) {
                            pOutputMsg614.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg614.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_LEG_ACT_REQD);
                            pOutputMsg614.getCINV59SOG01().ulRowQty++;
                            bShowLegalMsg = true;
                        }
                    }
                    
                    // check if any actions require service auth check
                    else if (0 == AOM_ACTION_ECS.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) || 0 == AOM_ACTION_COMMUNITY.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg())) {
                        rc = Cinv15s.CallCCMN87D(pInputMsg664, SVC_AUTH_EVENT_TYPE, ulRowQtyEvent, ulIdEvent24, pServiceStatus);
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                //  for each IdEvent returned from the DAM search the
                                // SVC_AUTH_EVENT_LINK table to find corresponding
                                // Service Auth Id.
                                for (i335 = 0;i335 <= (ulRowQtyEvent.value - 1);i335++) {
                                    if (bOtherThanDntdCmmtySvc != 0 && bDntdCmmtySvc != 0) {
                                        break;
                                    }
                                    rc = Ccmn35s.CallCSES24D(pInputMsg664, ulIdEvent24[i335], ulIdSvcAuth7, pServiceStatus);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            //  Call DAM
                                            rc = Csvc16s.CallCSES23D(pInputMsg664, pOutputMsg614, ulIdSvcAuth7.value, cIndDntdCmmtySvc1, pServiceStatus);
                                            
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    
                                                    if (cIndDntdCmmtySvc1.value == 'Y') {
                                                        bDntdCmmtySvc = 1;
                                                    }
                                                    else // it is 'N' or NULL
                                                    {
                                                        bOtherThanDntdCmmtySvc = 1;
                                                    }
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                    break;
                                            }
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                            break;
                                    }
                                }
                                break;
                            case NO_DATA_FOUND:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();// sir 21424
                                break;
                        }
                        
                        if (0 == AOM_ACTION_ECS.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) &&!(bOtherThanDntdCmmtySvc != 0) &&!bShowECSMsg) {
                            pOutputMsg614// sir 21424
                            .getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg614.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_SERV_AUTH_REQD);
                            pOutputMsg614.getCINV59SOG01().ulRowQty++;
                            bShowECSMsg = true;
                        }
                        if (0 == AOM_ACTION_COMMUNITY.compareTo(pCINV96DOutputRec.getROWCINV96DO_ARRAY().getROWCINV96DO(k).getSzCdApsOutcomeActnCateg()) &&!(bDntdCmmtySvc != 0) &&!bShowCommMsg) {
                            pOutputMsg614.getCINV20SOG01().getUsSysNbrMessageCode_ARRAY().setUsSysNbrMessageCode(pOutputMsg614.getCINV59SOG01().ulRowQty, Messages.MSG_SVC_COMM_SVC_REQD);
                            pOutputMsg614.getCINV59SOG01().ulRowQty++;
                            bShowCommMsg = true;
                        }
                    }
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    
    static int CallCCMNB6D(CCMNB6DI pInputMsg665, CCMNB6DO * pOutputMsg615, Pint ulIdCase3, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMNB6DI pCCMNB6DInputRec = null;
        CCMNB6DO pCCMNB6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB6DInputRec = new CCMNB6DI();
        
        pCCMNB6DOutputRec = new CCMNB6DO();
        pCCMNB6DInputRec.setArchInputStruct(pInputMsg665.getArchInputStruct());
        pCCMNB6DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCCMNB6DInputRec.setUlIdStage(pInputMsg665.getUlIdStage());
        rc = ccmnb6dQUERYdam(sqlca, pCCMNB6DInputRec, pCCMNB6DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdCase3.value = pCCMNB6DOutputRec.getUlIdCase();
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC48D(CSVC48DI pInputMsg666, CSVC48DO * pOutputMsg616, Pint legalActions, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCSVC48DInputRec.setArchInputStruct(pInputMsg666.getArchInputStruct());
        pCSVC48DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCSVC48DInputRec.setUlIdCase(pInputMsg666.getUlIdCase());
        pCSVC48DInputRec.setUlIdPerson(pInputMsg666.getUlIdPerson());
        rc = csvc48dQUERYdam(sqlca, pCSVC48DInputRec, pCSVC48DOutputRec);
        switch (rc) {
                // 
                // (END): Retrieve DAM: ccmn44d     
                // Get NmPersonFull given IdPerson
                // 
                
            case WtcHelperConstants.SQL_SUCCESS:
                legalActions.value = pCSVC48DOutputRec.getUlRowQty();
                
                //  Call CINV51D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSES23D(CINV20SI pInputMsg667, CINV20SO * pOutputMsg617, int ulIdSvcAuth8, String cIndDntdCmmtySvc2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCSES23DInputRec.setArchInputStruct(pInputMsg667.getArchInputStruct());
        
        pCSES23DInputRec.setUlIdSvcAuth(ulIdSvcAuth8);
        
        
        /*
        ** Call CRES25D
        */
        rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cIndDntdCmmtySvc2 = CStringUtils.setCharAt(cIndDntdCmmtySvc2, 0, pCSES23DOutputRec.getCIndDntdCmmtySvc());
                
                
                //  Call CRES25D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                
                
                
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
