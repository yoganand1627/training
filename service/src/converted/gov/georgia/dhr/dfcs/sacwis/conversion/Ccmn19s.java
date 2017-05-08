package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN91DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN91DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN92DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN92DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN93DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN93DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC03DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG3DO;
/**************************************************************************
** Module File:   CCMN19S.src
**
** Service Name:  CCMN19S
**
** Description:   This service will Add/Update to the TODO table, Add to the
**                Approval, Approval Event Link table, Event table, and
**                Approvers table if the ReqFuncCd is "APPROVAL"
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/15/94
**
** Programmer:    Limin Zhang
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   20 Jul 1999 17:07:00  $
**                      $Modtime:   20 Jul 1999 16:43:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  ---------------------------------------------------
**  02/22/95  FOGARTIS  SIR#60 - Included save of Task Due Date to Todo Tbl
**  03/01/95  FOGARTIS  SIR#59 - Reworked Service Error Handling. Handling
**                      of already deleted To-Do added.
**  03/01/95  FOGARTIS  SIR#212 - Approval Related ToDo ID capture reworked
**                      so that FK constaint not broken on Approvers Table.
**  03/28/95  FOGARTIS  SIR#62 - Added logic to create event with task
**                      assignment if event create flag was sent by the Task
**                      list window (CCMN63W.WIN). To support this Task SMP
**                      dam was added to the service to get the event type
**                      and default event decription, as well as CCMN46D
**                      event AUD was modified to act differently depending
**                      on scenerio Approval Create vs Assign Task.
**  05/24/95  RUSSELRM  Final Unit Test clean up.
**  06/29/95  PITMANGS  SIR#699 - Added logic to call dam CCMNG3D to update
**                      timestamp on Event table if Approver is being added
**                      and the user did NOT come from the Approval Status
**                      window.  Indicated by a value of 'Z' in IndTaskNew
**                      of Input message
**  07/25/95  DMV       SIR 928 - Added if statement in CALLCCMN43D to set
**                      the ID_TODO_CREATER to NULL if the mode is NEW
**                      Approver of Next Approver.  This will fix the
**                      problem of deleting Approval ToDo's because the
**                      ToDo will be system generated.
**  07/25/95  DMV       SIR 774  In the call to DAM CCMN91D,  Replaced
**                      original while looping sturcture
**                      while (pInputMsg->EventIdStruct[iIndex].ulIdEvent !=
**                      0 && rc 1= 0)
**                      to a for loop with a check for NULL ID EVENT.  This
**                      fixed the problem encountered when the max events
**                      are added.
**  09/26/95  bruckmk   SIR 1403 - A Family Assessment Shell, not just the
**          event needs to be created when creating a ToDo for
**          a New Family Assessment Event.
**  10/19/95  GSP   SIR 1855 - Change service to delete Approvals when they
**          have been previously rejected or invalidated.  This
**          will solve the problem of multiple approvals appearing
**          to be for the same submition. Added 3 DAMS:
**          CCMN55D, CCMN56D, CAUD51D
**
**  11/06/95  BRUCKMK   SIR 2026: For service delivery, need the
**                      pInputMsg->szCdTodoType variable to store a flag if
**                      the linked Family Assessment has already been
**                      approved.
**                      If the Family Assessment has been approved, we do not
**                      want to demote its status to PENDING. The Family
**                      Assessment will always be the Indexed as 1 in the
**                      EventIdStruct.
**  11/10/95  YANTISTK  SIR#1710 Add CheckStageEventStatus common function
**
**  12/20/95  BRUCKMK   SIR 2217: Need to check the ToDo type, so that the
**                      CheckStageEventStatus function won't be called for
**                      Alerts and Reminders, which do not pass a stage.
**  05/21/96  PHILLILH  SIR #21233 - Set ulIdEvent to ulIdApproval if the
**                      window Mode is WINDOW_MODE_NEXT_APPRV.  If it is not
**                      this window Mode, then Id Event is set like it
**                      originally was.  This is done because when a new
**                      approver is added, the IdEvent for the approve
**                      event was not being set to the IdApproval.
**   27Jun96  sladewmf  SIR #10190: Addition to change made for SIR 2217:
**                      Add a condition to the if (cReqFuncCd != DELETE).
**  10/08/96  ODONNERJ  SIR #21795 - All Dates must be set to NULL_DATE after
**      a structure containing an array has been memset to NULL
**      Remember this on YOUR NEXT PROJECT. WE HAVE HAD TO CLEAN
**      UP OVER A DOZEN SERVICES!!!!
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**   1/29/03   SRINI D   Modified TRUE to INDICATOR_YES for the line
**						 if (( INDICATOR_YES == pInputMsg->cSysIndTaskNew ) &&
**   04/07/04 CORLEYAN  SIR 22548 -- If timestamp mismatch is returned from
**                      ccmn43d, return that error.
**
**   10/05/05 ACODREA   No code changes. Needed for SIR#23704, ccmn19si.h.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn19s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PEND = "PEND";
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String EVENT_STATUS_PROC = "PROC";
    public static final String EVENT_TYPE_APPRV = "APP";
    public static final char APPROVAL_FLAG = 'Z';
    public static final String FAMILY_ASSESSMENT_TASK = "7060";
    public static final String FAM_PLAN_TYPE_FPP = "FPP";
    public static final int ONE = 1;
    public static final String NULL_STRING = "";
    /*
    ** the following were added per SIR 1855
    */
    public static final String APPROVAL_REJECT = "REJT";
    public static final String APPROVAL_INVALID = "INVD";
    public static final int PAGE_NBR = 1;
    public static final int MAX_APPROVERS = 15;
    CCMN19SO CCMN19S(CCMN19SI ccmn19si) {
        CCMN19SO ccmn19so = new CCMN19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables
        
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/* SIR#1710 */
        int iCount = 0;/* used to keep track of events for SIR 1855 */
        int i141 = 0;
        int bMatch = 0;/* used to break loop when match is made */
        int CurrentEvent = 0;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#2426 */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#2426 */
        rc = ARC_PRFServiceStartTime_TUX(ccmn19si.getArchInputStruct());
        if (0 == (ccmn19si.getToDoAUDStruct().getSzCdTodoType().substring(0, 1).compareTo(TASK_TODO.substring(0, 1))) && (WtcHelperConstants.REQ_FUNC_CD_DELETE != ccmn19si.getArchInputStruct().getCReqFuncCd())) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(ccmn19si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(ccmn19si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(ccmn19si.getToDoAUDStruct().getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(ccmn19si.getToDoAUDStruct().getSzCdTodoTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
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
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    
                    break;
            }
        }
        /**************************************************************************
        ** (END): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        else {
            //  Set RetVal to FND_SUCCESS
            RetVal = SUCCESS;
        }
        if (SUCCESS == RetVal) {
            switch (ccmn19si.getArchInputStruct().getCReqFuncCd()) {
                case WINDOW_MODE_NEW_APPRV:
                    ccmn19si.getApprvStruct().setUlIdApproval(0);
                    
                    //  For each id_event passed to the service, loop through to
                    // see if the event is linked to a previous approval.  If so,
                    // continue processing to delete approval.  If not, keep looping
                    // through events to find others linked to approvals. Need to loop
                    // through all events because the iCount+1 event may have beem
                    // deleted because it was an approval event.
                    
                    while (iCount < CCMN19SI._CCMN19SI__EVENTIDSTRUCT_SIZE) {
                        CurrentEvent = ccmn19si.getEventIdStruct_ARRAY().getEventIdStruct(iCount).getUlIdEvent();
                        
                        //  Call CLSS11D.  The Contract Service Retrieve DAM retrieves
                        // a row from Contract Service table where IdContract, Period and 
                        // Version match.
                        rc = CallCCMN55D(ccmn19si, ccmn19so, pServiceStatus, CurrentEvent);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        if (0 != ccmn19si.getApprvStruct().getUlIdApproval()) {
                            for (i141 = 0;((i141 < CCMN19SI._CCMN19SI__EVENTIDSTRUCT_SIZE) && (0 == bMatch));i141++) {
                                
                                //  Analyze error code
                                if (ccmn19si.getApprvStruct().getUlIdApproval() == ccmn19si.getEventIdStruct_ARRAY().getEventIdStruct(i141).getUlIdEvent()) {
                                    ccmn19si.getEventIdStruct_ARRAY().getEventIdStruct(i141).setUlIdEvent(0);
                                    bMatch = 1;
                                }
                            }
                            
                            //  reset boolean for next round of processing
                            bMatch = 0;
                        }
                        
                        if (0 != ccmn19si.getApprvStruct().getUlIdApproval()) {
                            // SIR 15166 taking out free stmts since SIR 22080 had freed it
                            // free(pCLSS11DInputRec);
                            // free(pCLSS11DOutputRec);
                            rc = Ccmn34s.CallCCMN56D(ccmn19si, ccmn19so, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        
                        if (0 != ccmn19si.getApprvStruct().getUlIdApproval()) {
                            rc = CallCAUD51D(ccmn19si, ccmn19so, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        ccmn19si.getApprvStruct().setUlIdApproval(0);
                        iCount++;
                    }
                    
                    
                    //  Call CAUD28D.  TheVersion Dates AUD performs an update to the 
                    // Contract Version table.  It receives IdContract, NbrCnperPeriod,
                    // NbrCnverVersion, DtCnperStart, DtCnperTerm and IdCntrctWkr with 
                    // update DtCnverEffective, DtCnverEnd and IdCntrctWkr columns.
                    rc = Ccmn01u.CallCCMN46D(ccmn19si, ccmn19so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    // SIR 15166 taking out free stmts since SIR 22080 had freed it
                    // free(pCLSS11DInputRec);
                    // free(pCLSS11DOutputRec);
                    rc = Ccmn05u.CallCCMN62D(ccmn19si, ccmn19so, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    ccmn19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                    rc = Csys07s.CallCCMN91D(ccmn19si, ccmn19so, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    ccmn19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    
                    //  Call CLSS37D.  The Contract County Retrieve receives IdContract,
                    // NbrCnsvcPeriod, NbrCnsvcVersion, NbrCnsvcLineItem and will
                    // return n full rows.
                    rc = Csys07s.CallCCMN91D(ccmn19si, ccmn19so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    rc = CallCCMN92D(ccmn19si, ccmn19so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    rc = Ccmn25s.CallCCMN43D(ccmn19si, ccmn19so, pServiceStatus, WINDOW_MODE_NEW_APPRV);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    //  Call CAUD08D The Contract County AUD performs a full row insert,
                    // update or delete to the Contract County table.
                    rc = CallCCMN93D(ccmn19si, ccmn19so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                case WINDOW_MODE_NEXT_APPRV:
                    ccmn19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    rc = Ccmn25s.CallCCMN43D(ccmn19si, ccmn19so, pServiceStatus, WINDOW_MODE_NEXT_APPRV);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    rc = CallCCMN93D(ccmn19si, ccmn19so, pServiceStatus);
                    
                    // 
                    // Service Macro Definitions
                    // 
                    
                    
                    // 
                    // Function Prototypes
                    // 
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    if (APPROVAL_FLAG != ccmn19si.getCSysIndTaskNew()) {
                        rc = CallCCMNG3D(ccmn19si, ccmn19so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    
                    break;
                case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                    rc = Ccmn25s.CallCCMN43D(ccmn19si, ccmn19so, pServiceStatus, WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        case Messages.MSG_CMN_TODO_DELETED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            
                            break;
                            
                        default :
                            
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    break;
                case WtcHelperConstants.REQ_FUNC_CD_DELETE:
                    rc = Ccmn25s.CallCCMN43D(ccmn19si, ccmn19so, pServiceStatus, WtcHelperConstants.REQ_FUNC_CD_DELETE);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        case Messages.MSG_CMN_TODO_DELETED:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    break;
                case WINDOW_MODE_ASSIGN:
                    if ((INDICATOR_YES == ccmn19si.getCSysIndTaskNew()) && (ccmn19si.getToDoAUDStruct().getSzCdTodoTask()[0] != null)) {
                        rc = Ccmn13s.CallCCMN82D(ccmn19si, ccmn19so, pServiceStatus);
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        rc = Ccmn01u.CallCCMN46D(ccmn19si, ccmn19so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        //## END TUX/XML: Turn the XML buffer into an input message struct
                        
                        
                        
                        if (!(ccmn19si.getToDoAUDStruct().getSzCdTodoTask().compareTo(FAMILY_ASSESSMENT_TASK) != 0)) {
                            
                            //  Call DAM
                            rc = CallCSVC03D(ccmn19si, ccmn19so, pServiceStatus);
                            switch (rc) {
                                    //SIR 24002
                                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    
                                    break;
                                case Messages.MSG_CMN_UPDATE_FAILED:
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                        }
                    }
                    ccmn19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    rc = Ccmn25s.CallCCMN43D(ccmn19si, ccmn19so, pServiceStatus, WINDOW_MODE_ASSIGN);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    break;
                    
                default :
                    ccmn19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    //  No OnCalls exist against that employee
                    rc = Ccmn25s.CallCCMN43D(ccmn19si, ccmn19so, pServiceStatus, (char) 0);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn19si.getArchInputStruct() , ccmn19so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        
        
        /**************************************************************************
        ** SIR#2602
        ** Do not execute CheckStageEventStatus if Contact was recorded on a
        ** closed stage
        **************************************************************************/
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn19so;
    }

    static int CallCCMN46D(CCMN19SI pInputMsg240, CCMN19SO * pOutputMsg221, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN46DI pCCMN46DInputRec = null;
        CCMN46DO pCCMN46DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN46DInputRec = new CCMN46DI();
        pCCMN46DOutputRec = new CCMN46DO();
        
        
        /*
        ** Analyze return code
        */
        switch (pInputMsg240.getArchInputStruct().getCReqFuncCd()) {
                
            case WINDOW_MODE_NEW_APPRV:
                pCCMN46DInputRec.setSzCdEventType(EVENT_TYPE_APPRV);
                pCCMN46DInputRec.setSzCdTask(pInputMsg240.getToDoAUDStruct().getSzCdTodoTask());
                
                pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg240.getToDoAUDStruct().getSzTxtTodoDesc());
                
                
                
                pCCMN46DInputRec.setDtDtEventOccurred(pInputMsg240.getToDoAUDStruct().getDtDtTodoCreated());
                pCCMN46DInputRec.setUlIdStage(pInputMsg240.getEventStruct().getUlIdStage());
                pCCMN46DInputRec.setUlIdPerson(pInputMsg240.getToDoAUDStruct().getUlIdTodoPersCreator());
                pCCMN46DInputRec.setSzCdEventStatus(EVENT_STATUS_PROC);
                break;
            case WINDOW_MODE_ASSIGN:
                pCCMN46DInputRec.setSzCdEventStatus(EVENT_STATUS_NEW);
                pCCMN46DInputRec.setSzCdTask(pInputMsg240.getToDoAUDStruct().getSzCdTodoTask());
                pCCMN46DInputRec.setSzCdEventType(pInputMsg240.getSzCdEventType());
                pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg240.getSzTxtEventDescr());
                
                ARC_UTLGetDateAndTime(pCCMN46DInputRec.getDtDtEventOccurred() , 0);
                pCCMN46DInputRec.setUlIdPerson(pInputMsg240.getToDoAUDStruct().getUlIdTodoPersCreator());
                pCCMN46DInputRec.setUlIdStage(pInputMsg240.getToDoAUDStruct().getUlIdStage());
        }
        pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        
        
        rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg240.getApprvStruct().setUlIdApproval(pCCMN46DOutputRec.getUlIdEvent());
                pInputMsg240.getApproversStruct().setUlIdApproval(pCCMN46DOutputRec.getUlIdEvent());
                pInputMsg240.getToDoAUDStruct().setUlIdEvent(pCCMN46DOutputRec.getUlIdEvent());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCAUD51D(CCMN19SI pInputMsg241, CCMN19SO * pOutputMsg222, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUD51DI pCAUD51DInputRec = null;
        CAUD51DO pCAUD51DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD51DInputRec = new CAUD51DI();
        pCAUD51DOutputRec = new CAUD51DO();
        pCAUD51DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        pCAUD51DInputRec.setUlIdApproval(pInputMsg241.getApprvStruct().getUlIdApproval());
        rc = caud51dAUDdam(sqlca, pCAUD51DInputRec, pCAUD51DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCCMN56D(CCMN19SI pInputMsg242, CCMN19SO * pOutputMsg223, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i142 = 0;
        int bAprv = 1;/* indicator stating approval was aprvd */
        
        /*
        ** Declare local variables
        */
        CCMN56DI pCCMN56DInputRec = null;
        CCMN56DO pCCMN56DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN56DInputRec = new CCMN56DI();
        pCCMN56DOutputRec = new CCMN56DO();
        pCCMN56DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NBR);
        
        /* Exit the service */
        pCCMN56DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_APPROVERS);
        pCCMN56DInputRec.setUlIdApproval(pInputMsg242.getApprvStruct().getUlIdApproval());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Set CCFC17SO WCD DtSystemDate to current date
        */
        rc = ccmn56dQUERYdam(sqlca, pCCMN56DInputRec, pCCMN56DOutputRec);
        
        switch (rc) {
                
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pInputMsg242.getApprvStruct().setUlIdApproval(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        /*
        ** loop through dam output rec to see if any of the approver rejected an
        ** approval or if any of them were invalidated
        */
        while ((0 != pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i142).getSzCdApproversStatus().length()) && (i142 < CCMN56DO._CCMN56DO__ROWCCMN56DO_SIZE) && (pInputMsg242.getApprvStruct().getUlIdApproval() != 0) && (bAprv != 0)) {
            
            // 
            // End Call to PAL Closure Liv Arr Dam - CMSC15D
            // 
            
            if ((pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i142).getSzCdApproversStatus().equals(APPROVAL_REJECT)) || (pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i142).getSzCdApproversStatus().equals(APPROVAL_INVALID))) {
                bAprv = 0;
            }
            i142++;
        }
        if (1 == bAprv) {
            pInputMsg242.getApprvStruct().setUlIdApproval(0);
        }
        
        return rc;
    }

    static int CallCCMN55D(CCMN19SI pInputMsg243, CCMN19SO * pOutputMsg224, Arcxmlerrors.TUX_DECL_STATUSPARMS, int CurrentEvent) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN55DI pCCMN55DInputRec = null;
        CCMN55DO pCCMN55DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN55DInputRec = new CCMN55DI();
        pCCMN55DOutputRec = new CCMN55DO();
        pCCMN55DInputRec.setUlIdEvent(CurrentEvent);
        rc = ccmn55dQUERYdam(sqlca, pCCMN55DInputRec, pCCMN55DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg243.getApprvStruct().setUlIdApproval(pCCMN55DOutputRec.getUlIdApproval());
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // 
                // END: CAUDE0D
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCCMN91D(CCMN19SI pInputMsg244, CCMN19SO * pOutputMsg225, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int iIndex = 0;
        CCMN91DI pCCMN91DInputRec = null;
        CCMN91DO pCCMN91DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN91DInputRec = new CCMN91DI();
        pCCMN91DOutputRec = new CCMN91DO();
        pCCMN91DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg244.getArchInputStruct().getCReqFuncCd());
        pCCMN91DInputRec.setUlIdApproval(pInputMsg244.getApprvStruct().getUlIdApproval());
        
        /*
        ** SIR 774
        ** Replaced original while looping sturcture
        ** while (pInputMsg->EventIdStruct[iIndex].ulIdEvent != 0 && rc 1= 0)
        ** to a for loop with a check for NULL ID EVENT.  This fixed the problem
        ** enclountered when the max events are added.
        */
        
        /* loop through all the Event Id's */
        for (iIndex = 0;iIndex < CCMN19SI._CCMN19SI__EVENTIDSTRUCT_SIZE;iIndex++) {
            
            if (pInputMsg244.getEventIdStruct_ARRAY().getEventIdStruct(iIndex).getUlIdEvent() != 0) {
                pCCMN91DInputRec.setUlIdEvent(pInputMsg244.getEventIdStruct_ARRAY().getEventIdStruct(iIndex).getUlIdEvent());
                rc = ccmn91dAUDdam(sqlca, pCCMN91DInputRec, pCCMN91DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        
                        //  Call CSES41D - Retreive Resource Info from caps_resource
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            else {
            }
        }
        return rc;
    }

    static int CallCCMN92D(CCMN19SI pInputMsg245, CCMN19SO * pOutputMsg226, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int iIndex = 0;
        CCMN92DI pCCMN92DInputRec = null;
        CCMN92DO pCCMN92DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN92DInputRec = new CCMN92DI();
        pCCMN92DOutputRec = new CCMN92DO();
        pCCMN92DInputRec.setUlIdApproval(pInputMsg245.getApprvStruct().getUlIdApproval());
        pCCMN92DInputRec.setUlIdPerson(pInputMsg245.getApprvStruct().getUlIdPerson());
        pCCMN92DInputRec.setSzTxtApprovalTopic(pInputMsg245.getApprvStruct().getSzTxtApprovalTopic());
        pCCMN92DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg245.getArchInputStruct().getCReqFuncCd());
        
        /*
        ** Call CAUDE0D
        */
        rc = ccmn92dAUDdam(sqlca, pCCMN92DInputRec, pCCMN92DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN93D(CCMN19SI pInputMsg246, CCMN19SO * pOutputMsg227, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN93DI pCCMN93DInputRec = null;
        CCMN93DO pCCMN93DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN93DInputRec = new CCMN93DI();
        pCCMN93DOutputRec = new CCMN93DO();
        pCCMN93DInputRec.setSzCdApproversStatus(EVENT_STATUS_PEND);
        pCCMN93DInputRec.setDtDtApproversDetermination(pInputMsg246.getApproversStruct().getDtDtApproversDetermination());
        pCCMN93DInputRec.setDtDtApproversRequested(pInputMsg246.getApproversStruct().getDtDtApproversRequested());
        pCCMN93DInputRec.setUlIdApproval(pInputMsg246.getApproversStruct().getUlIdApproval());
        pCCMN93DInputRec.setUlIdPerson(pInputMsg246.getApproversStruct().getUlIdPerson());
        pCCMN93DInputRec.setLdIdTodo(pInputMsg246.getApproversStruct().getLdIdTodo());
        pCCMN93DInputRec.setBIndApproversHistorical(pInputMsg246.getApproversStruct().getBIndApproversHistorical());
        pCCMN93DInputRec.setSzTxtApproversComments(pInputMsg246.getApproversStruct().getSzTxtApproversComments());
        pCCMN93DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg246.getArchInputStruct().getCReqFuncCd());
        rc = ccmn93dAUDdam(sqlca, pCCMN93DInputRec, pCCMN93DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN43D(CCMN19SI pInputMsg247, CCMN19SO pOutputMsg228, Arcxmlerrors.TUX_DECL_STATUSPARMS, char cReqFuncCd1) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        int sc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN43DInputRec = new CCMN43DI();
        pCCMN43DOutputRec = new CCMN43DO();
        pCCMN43DInputRec.setSzCdTodoTask(pInputMsg247.getToDoAUDStruct().getSzCdTodoTask());
        pCCMN43DInputRec.setSzCdTodoType(pInputMsg247.getToDoAUDStruct().getSzCdTodoType());
        pCCMN43DInputRec.setDtDtTodoCompleted(pInputMsg247.getToDoAUDStruct().getDtDtTodoCompleted());
        pCCMN43DInputRec.setDtDtTodoCreated(pInputMsg247.getToDoAUDStruct().getDtDtTodoCreated());
        pCCMN43DInputRec.setDtDtTodoDue(pInputMsg247.getToDoAUDStruct().getDtDtTodoDue());
        pCCMN43DInputRec.setDtDtTaskDue(pInputMsg247.getToDoAUDStruct().getDtDtTaskDue());
        pCCMN43DInputRec.setUlIdCase(pInputMsg247.getToDoAUDStruct().getUlIdCase());
        
        if (WINDOW_MODE_NEXT_APPRV == cReqFuncCd1) {
            pCCMN43DInputRec.setUlIdEvent(pInputMsg247.getApproversStruct().getUlIdApproval());
        }
        else {
            pCCMN43DInputRec.setUlIdEvent(pInputMsg247.getToDoAUDStruct().getUlIdEvent());
        }
        pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg247.getToDoAUDStruct().getUlIdTodoPersAssigned());
        
        if ((WINDOW_MODE_NEW_APPRV == cReqFuncCd1) || (WINDOW_MODE_NEXT_APPRV == cReqFuncCd1)) {
            pCCMN43DInputRec.setUlIdTodoPersCreator(0);
        }
        else {
            pCCMN43DInputRec.setUlIdTodoPersCreator(pInputMsg247.getToDoAUDStruct().getUlIdTodoPersCreator());
        }
        pCCMN43DInputRec.setUlIdTodoPersWorker(pInputMsg247.getToDoAUDStruct().getUlIdTodoPersWorker());
        pCCMN43DInputRec.setUlIdStage(pInputMsg247.getToDoAUDStruct().getUlIdStage());
        pCCMN43DInputRec.setLdIdTodo(pInputMsg247.getToDoAUDStruct().getLdIdTodo());
        pCCMN43DInputRec.setSzTxtTodoDesc(pInputMsg247.getToDoAUDStruct().getSzTxtTodoDesc());
        pCCMN43DInputRec.setTxtTodoLongDesc(pInputMsg247.getToDoAUDStruct().getTxtTodoLongDesc());
        pCCMN43DInputRec.tsLastUpdate = pInputMsg247.getToDoAUDStruct().getTsLastUpdate();
        pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg247.getArchInputStruct().getCReqFuncCd());
        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case NO_DATA_FOUND:
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(0, 147);
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(1, 112);
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(2, 12);
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(3, 31);
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(4, 1);
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(5, 0);
                pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(6, 0);
                pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                
                sc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                switch (sc) {
                        
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TODO_DELETED;
                        
                        //  Call DAM
                        rc = Messages.MSG_CMN_TODO_DELETED;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
                
                
                
                break;
                
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg247.getApproversStruct().setLdIdTodo(pCCMN43DOutputRec.getLdIdTodo());
                pOutputMsg228.setLdIdTodo(pCCMN43DOutputRec.getLdIdTodo());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN62D(CCMN19SI pInputMsg248, CCMN19SO * pOutputMsg229, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        int iIndex = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setSzCdEventStatus(EVENT_STATUS_PEND);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        
        
        /*
        ** SIR 774
        ** Replaced original while looping sturcture
        ** while (pInputMsg->EventIdStruct[iIndex].ulIdEvent != 0 && rc == 0)
        ** to a for loop with a check for NULL ID EVENT.  This fixed the problem
        ** enclountered when the max events are added.
        */
        
        /* loop through all the Event Id's */
        for (iIndex = 0;iIndex < CCMN19SI._CCMN19SI__EVENTIDSTRUCT_SIZE;iIndex++) {
            if (pInputMsg248.getEventIdStruct_ARRAY().getEventIdStruct(iIndex).getUlIdEvent() != 0) {
                if (iIndex == ONE) {
                    
                    // 
                    // (END): Retrieve Resource Address
                    // 
                    
                    // 
                    // (BEGIN): Retrieve Resource Phone
                    // 
                    
                    if (0 != pInputMsg248.getSzCdTodoType().substring(0, 2).compareTo(FAM_PLAN_TYPE_FPP.substring(0, 2))) {
                        pCCMN62DInputRec.setUlIdEvent(pInputMsg248.getEventIdStruct_ARRAY().getEventIdStruct(iIndex).getUlIdEvent());
                        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                                //  SIR 22080: moved freeing of CLSS11D in and out
                                // rec to appropriate place
                                
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                    }
                }
                
                else {
                    pCCMN62DInputRec.setUlIdEvent(pInputMsg248.getEventIdStruct_ARRAY().getEventIdStruct(iIndex).getUlIdEvent());
                    
                    //  Call CINT40D
                    rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            //##         sprintf(pReturnPB->appl_status.explan_data,
                            //##                "%u",
                            //##                pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    }
                }
            }
            
            else {
            }
        }
        return rc;
    }

    static int CallCCMN82D(CCMN19SI pInputMsg249, CCMN19SO * pOutputMsg230, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN82DI pCCMN82DInputRec = null;
        CCMN82DO pCCMN82DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN82DInputRec = new CCMN82DI();
        pCCMN82DOutputRec = new CCMN82DO();
        pCCMN82DInputRec.setSzCdTask(pInputMsg249.getToDoAUDStruct().getSzCdTodoTask());
        
        
        /*
        ** Call CFAD01U
        */
        
        
        rc = ccmn82dQUERYdam(sqlca, pCCMN82DInputRec, pCCMN82DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg249.setSzCdEventType(pCCMN82DOutputRec.getSzCdEventType());
                pInputMsg249.setSzTxtEventDescr(pCCMN82DOutputRec.getSzTxtTaskDecode());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC03D(CCMN19SI pInputMsg250, CCMN19SO * pOutputMsg231, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i143 = 0;
        
        /*
        ** Declare local variables
        */
        CSVC03DI pCSVC03DInputRec = null;
        CSVC03DO pCSVC03DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC03DInputRec = new CSVC03DI();
        
        pCSVC03DOutputRec = new CSVC03DO();
        pCSVC03DInputRec.setArchInputStruct(pInputMsg250.getArchInputStruct());
        pCSVC03DInputRec.setUlIdEvent(pInputMsg250.getToDoAUDStruct().getUlIdEvent());
        pCSVC03DInputRec.setUlIdStage(pInputMsg250.getToDoAUDStruct().getUlIdStage());
        
        pCSVC03DInputRec.getLDtFamAssmtComplt().year = DateHelper.NULL_DATE;
        pCSVC03DInputRec.getLDtFamAssmtComplt().day = DateHelper.NULL_DATE;
        pCSVC03DInputRec.getLDtFamAssmtComplt().month = DateHelper.NULL_DATE;
        pCSVC03DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        
        /*
        ** Set rc to SQL_SUCCESS
        */
        rc = csvc03dAUDdam(sqlca, pCSVC03DInputRec, pCSVC03DOutputRec);
        switch (rc) {
                
                //  SIR 21003 - Changed error processing of cses80d
                // to allow sql-not-found because that is an
                // acceptible condition.  It should not "blow-up"
                // at this point.
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call DAM
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

    static int CallCCMNG3D(CCMN19SI pInputMsg251, CCMN19SO * pOutputMsg232, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNG3DI pCCMNG3DInputRec = null;
        CCMNG3DO pCCMNG3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG3DInputRec = new CCMNG3DI();
        pCCMNG3DOutputRec = new CCMNG3DO();
        pCCMNG3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMNG3DInputRec.setUlIdEvent(pInputMsg251.getApproversStruct().getUlIdApproval());
        rc = ccmng3dAUDdam(sqlca, pCCMNG3DInputRec, pCCMNG3DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  Success Case for Dam CSEC63D (OPS)
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
